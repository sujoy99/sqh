package com.example.sqh.service;

import com.example.sqh.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

  private static final long serialVersionUID = 1L;

  private User user;

  public CustomUserDetails(User user) {
    super();
    this.user = user;
  }

  public User getUser() {
    System.out.println("Custom User Details = " + user);
    return user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singleton(new SimpleGrantedAuthority(user.getUserType().toString()));
  }

  @Override
  public String getPassword() {
    String s = user.getPassword();
    return s;
  }

  @Override
  public String getUsername() {
    String s = user.getName();
    return s;
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
