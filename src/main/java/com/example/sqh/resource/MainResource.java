package com.example.sqh.resource;

import com.example.sqh.request.JwtRequest;
import com.example.sqh.response.JwtResponse;
import com.example.sqh.service.CustomUserDetails;
import com.example.sqh.service.CustomUserDetailsService;
import com.example.sqh.utility.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MainResource {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private CustomUserDetailsService customUserDetailsService;


  @Autowired
  private JwtUtility jwtUtility;

  @GetMapping("/")
  public String login(){

    return "login";
  }

  @PostMapping("/")
  public ResponseEntity submitLogin(@RequestBody JwtRequest jwtRequest)throws Exception{

    System.out.println("jwt request =" + jwtRequest);

    try {

      authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken( jwtRequest.getUsername(), jwtRequest.getPassword())
      );

    }catch(BadCredentialsException e){

      throw new Exception("Invalid Credintial", e);
    }


    CustomUserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

    final String token = jwtUtility.generateToken1(userDetails);

    System.out.println("token = "+ token);

   return ResponseEntity.ok(new JwtResponse(token));

//    return "dashboard";
  }

  @GetMapping("/registration")
  public String registration(){

    return "registration";
  }

  @GetMapping("/home")
  public String dashboard(){

    return "dashboard";
  }
}
