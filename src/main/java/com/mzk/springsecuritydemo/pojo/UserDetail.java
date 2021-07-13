package com.mzk.springsecuritydemo.pojo;

import com.mzk.springsecuritydemo.pojo.dto.TRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author miaozhenkai
 * @version 2021-07-12  17:34
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String password;

    private Boolean accountnonexpired;

    private Boolean accountnonlocked;

    private Boolean credentialsnonexpired;

    private Boolean enabled;

    private List<TRole> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (TRole role : getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleValue()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountnonexpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountnonlocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsnonexpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
