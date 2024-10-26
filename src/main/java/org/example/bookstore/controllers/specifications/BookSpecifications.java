package org.example.bookstore.controllers.specifications;

import jakarta.persistence.criteria.JoinType;
import org.example.bookstore.domain.entities.BookEntity;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecifications {
    public static Specification<BookEntity> hasAuthor(String author) {
        return (root, query, builder) ->
                builder.equal(root.get("author"), author);
    }

    public static Specification<BookEntity> hasLanguage(BookEntity.BOOK_LANGUAGE language) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("language"), language.toString());
    }

    public static Specification<BookEntity> hasPublishers(String[] publishers) {
        return (root, query, builder) -> {
            if (publishers.length == 0) {
                return builder.conjunction();
            }
            return root.get("publisher").in((Object[]) publishers);
        };
    }

    public static Specification<BookEntity> hasGenres(String[] genres) {
        return (root, query, builder) -> {
            if (genres.length == 0) {
                return builder.conjunction();
            }

            return root.get("genre").in((Object[]) genres);
        };
    }

    public static Specification<BookEntity> hasState(BookEntity.BOOK_STATE state) {
        return (root, query, builder) ->
                builder.equal(root.get("state"), state);
    }

    public static Specification<BookEntity> hasTags(String[] tags) {
        return (root, query, builder) -> {
            if (tags.length == 0) return builder.conjunction();
            return root.join("tags", JoinType.INNER).get("name").in((Object[]) tags);
        };
    }

    public static Specification<BookEntity> hasOtherParam(String paramName, String paramValue) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(paramName), paramValue);
    }

}
