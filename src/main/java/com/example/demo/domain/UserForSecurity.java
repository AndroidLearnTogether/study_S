package com.example.demo.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
@Log4j2
public class UserForSecurity implements UserDetails {
    private final PasswordEncoder passwordEncoder;
    @NonNull
    private User user;

    private static final long serialVersionUID = 1L;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_GUEST");
        authorities.add(simpleGrantedAuthority);
        if(user.getAuthorities() == 'U') {
            simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
            authorities.add(simpleGrantedAuthority);
        } else if(user.getAuthorities() == 'A') {
            simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
            authorities.add(simpleGrantedAuthority);
            simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
            authorities.add(simpleGrantedAuthority);
        }
        log.info(authorities);
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
