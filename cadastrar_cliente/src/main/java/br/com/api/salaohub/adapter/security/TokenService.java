package br.com.api.salaohub.adapter.security;//package br.com.api.salaohub.adapter.security;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TokenService {
//
//    @Value("${api.security.token.secret-password}")
//    private String secretPassword;
//
//    public String getAuthenticationToken(String tokenJWT) {
//        try {
//            return JWT.require(Algorithm.HMAC256(secretPassword))
//                    .withIssuer("login.screm")
//                    .build()
//                    .verify(tokenJWT)
//                    .getSubject();
//        } catch (JWTVerificationException exception) {
//            throw new RuntimeException("Token JWT inválido ou expirado", exception);
//        }
//    }
//
//    public String recuperarToken(String authorizationHeader) {
//        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
//            throw new RuntimeException("Token inválido ou inexistente");
//        }
//        return authorizationHeader.substring(7);
//    }
//}
