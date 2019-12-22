//package com.netcracker.edu.fapi.security.jwt;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class JwtUser implements UserDetails {
//
//    private final Long idUser;
//    private final String name;
//    private final String surname;
//    private final String email;
//    private final Object role;
//    private final String login;
//    private final String password;
//    private final boolean enabled;
//    private final Collection<? extends GrantedAuthority>authorities;
//
//    public JwtUser(Long idUser, String name, String surname, String email, Object role, String login, String password, boolean enabled, Collection<? extends GrantedAuthority> authorities) {
//        this.idUser = idUser;
//        this.name = name;
//        this.surname = surname;
//        this.email = email;
//        this.role = role;
//        this.login = login;
//        this.password = password;
//        this.enabled = enabled;
//        this.authorities = authorities;
//    }
//
//
//    public String getLogin() {
//        return login;
//    }
//
//    public Long getIdUser() {
//        return idUser;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public Object getRole() {
//        return role;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return enabled;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getUsername() {
//        return login;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//}
