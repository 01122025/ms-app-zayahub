package br.com.api.salaohub.adapter.out.entity;//package br.com.api.salaohub.adapter.out.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.time.LocalDateTime;
//import java.util.Collection;
//import java.util.List;
//
//@Table(name = "users")
//@Entity(name = "users")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class UserClient implements UserDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(nullable = false, unique = true)
//    private String login;
//
//    @Column(nullable = false)
//    private String password;
//
//    private LocalDateTime createdAt;
//    private Boolean active = true;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of();
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return login;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return Boolean.TRUE.equals(active);
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return Boolean.TRUE.equals(active);
//    }
//}
