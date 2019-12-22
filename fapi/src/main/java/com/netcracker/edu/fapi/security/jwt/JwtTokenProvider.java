//package com.netcracker.edu.fapi.security.jwt;
//
//import io.jsonwebtoken.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//import javax.validation.constraints.Max;
//import java.util.ArrayList;
//import java.util.Base64;
//import java.util.Date;
//import java.util.List;
//
//@Component
//public class JwtTokenProvider {
//
//    @Value("${jwt.token.secret}")
//    private String secret;
//    @Value("${jwt.token.expired}")
//    private long validityInMiliSeconds;
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @PostConstruct
//    public void init() {
//        secret = Base64.getEncoder().encodeToString(secret.getBytes());
//    }
//
//
//    //TODO: +List<Role>roles
//    public String createToken(String login) {
//        Claims claims = Jwts.claims().setSubject(login);
//        //claims.put("role",getRoleName(roles));
//
//        Date now = new Date();
//        Date validity = new Date(now.getTime() + validityInMiliSeconds);
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(now)
//                .setExpiration(validity)
//                .signWith(SignatureAlgorithm.HS256, secret)
//                .compact();
//    }
//
//    public Authentication getAuthentication(String token) {
//        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getLoginByToken(token));
//        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//    }
//
//    public String getLoginByToken(String token) {
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
//    }
//
//    public String resolveToken(HttpServletRequest req){
//        String bearerToken = req.getHeader("Authorization");
//        if(bearerToken!=null && bearerToken.startsWith("Bearer_")){
//            return bearerToken.substring(7/bearerToken.length());
//        }
//        return null;
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
//            if (claims.getBody().getExpiration().before(new Date())) {
//                return false;
//            }
//            return true;
//        } catch (JwtException | IllegalArgumentException e) {
//            throw new JwtAuthenticationException("JWT token is expired or invalid");
//        }
//    }
//
////    private List<String> getRoleNames(List<Role> userRoles) {
////        List<String> result = new ArrayList<>();
////        userRoles.forEach(role -> {
////            result.add(role.getName);
////        });
////        return result;
////    }
//}
