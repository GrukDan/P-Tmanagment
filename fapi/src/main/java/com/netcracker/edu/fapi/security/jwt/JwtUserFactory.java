//package com.netcracker.edu.fapi.security.jwt;
//
//import com.netcracker.edu.fapi.models.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import java.util.List;
//
//public final class JwtUserFactory {
//
//    public JwtUserFactory(){}
//
//    public static JwtUser create(User user){
//        return new JwtUser(
//                user.getIdUser(),
//                user.getName(),
//                user.getSurname(),
//                user.getEmail(),
//                user.getRole(),
//                user.getLogin(),
//                user.getPassword(),
//                true,
//                null
//        );
//    }
//
//    //TODO: роль - объект, класс?
//    private static List<GrantedAuthority> mapToGraGrantedAuthority(List<Object> userRoles ){
//        return userRoles.stream().map(role->{
//            new SimpleGrantedAuthority(role.)
//        })
//
//    }
//}
