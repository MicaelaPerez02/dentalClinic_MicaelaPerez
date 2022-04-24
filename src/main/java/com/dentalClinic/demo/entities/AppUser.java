package com.dentalClinic.demo.entities;

import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Getter
@Setter
public class AppUser implements UserDetails {

        @Id
        @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
        private Long id;
        @Enumerated(EnumType.STRING)
        private AppUserRoles appUserRoles;
        private String email;
        private String name;
        private String password;
        private String username;




        public AppUser() {
        }

        public AppUser(String name, String username, String email, String password, AppUserRoles appUserRoles) {
            this.name = name;
            this.username = username;
            this.email = email;
            this.password = password;
            this.appUserRoles = appUserRoles;
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

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appUserRoles.name());
            return Collections.singletonList(grantedAuthority);
        }
    }

