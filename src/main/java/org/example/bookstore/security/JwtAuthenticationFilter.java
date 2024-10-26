package org.example.bookstore.security;

import org.example.bookstore.exceptions.AccessDeniedException;
import org.example.bookstore.repositories.TokenRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    public static final String BEARER_PREFIX = "Bearer ";
    public static final String HEADER_NAME = "Authorization";
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().contains("/api/v1/auth")) {
            filterChain.doFilter(request, response);
            return;
        }
        final String authHeader = request.getHeader(HEADER_NAME);
        if (authHeader == null || !StringUtils.startsWith(authHeader, BEARER_PREFIX)) {
            filterChain.doFilter(request, response);
            return;
        }
        String jwtToken = authHeader.substring(BEARER_PREFIX.length());
        String email = jwtService.extractEmail(jwtToken);
        String tokenType = jwtService.extractTokenType(jwtToken);

        if (StringUtils.isEmpty(tokenType) || tokenType.equals("REFRESH")) {
            throw new AccessDeniedException("Can not authorize user with refresh token");
        }

        tokenRepository.getByToken(jwtToken)
                .orElseThrow(() -> new AccessDeniedException("Token has expired or invalid"));
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()));

        filterChain.doFilter(request, response);
    }
}