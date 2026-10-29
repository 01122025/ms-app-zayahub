package br.com.api.salaohub.adapter.security;//package br.com.api.salaohub.adapter.security;
//
//import br.com.api.salaohub.boot.security.AuthorizationConfigurations;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//@RequiredArgsConstructor
//public class SecurityFilter extends OncePerRequestFilter {
//
//    private final TokenService tokenService;
//    private final AuthorizationConfigurations authorizationConfigurations;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//
//        var authorizationHeader = request.getHeader("Authorization");
//
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            try {
//                String token = tokenService.recuperarToken(authorizationHeader);
//                String login = tokenService.getAuthenticationToken(token);
//
//                UserDetails userDetails = authorizationConfigurations.loadUserByUsername(login);
//
//                var authentication = new UsernamePasswordAuthenticationToken(
//                        userDetails,
//                        null,
//                        userDetails.getAuthorities()
//                );
//
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            } catch (RuntimeException e) {
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                response.setContentType("application/json");
//                response.getWriter().write("{\"error\":\"Token inválido ou expirado\"}");
//                return;
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
