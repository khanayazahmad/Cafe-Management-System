package com.cmpe202.starbucks.security;

import com.cmpe202.starbucks.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class StarbucksUserDetails implements UserDetails {

    private User user;
    private List<Permission> permissions;

    public StarbucksUserDetails(User user, List<Permission> permissions){
        super();
        this.user = user;
        this.permissions = permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(null== permissions){
            return Collections.emptySet();
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        permissions.forEach(group->{
           grantedAuthorities.add(new SimpleGrantedAuthority(group.getPermission()));
        });
        return grantedAuthorities;

    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
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

    public User getUser(){return user;}
}
