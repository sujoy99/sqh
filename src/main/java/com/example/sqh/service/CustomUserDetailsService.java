package com.example.sqh.service;


import com.example.sqh.entity.User;
import com.example.sqh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;
  @Override
  public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    System.out.println("Custom User Details Service = "+ username);

    User user = userRepository.findByName(username);

    System.out.println("test = " + user);

    if(user == null) {

      System.out.println("user not found");

      throw new UsernameNotFoundException("User not found");
    }

    return new CustomUserDetails(user);
  }
}
