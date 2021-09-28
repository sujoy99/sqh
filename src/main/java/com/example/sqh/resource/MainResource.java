package com.example.sqh.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainResource {

  @GetMapping("/hello")
  public String hello(){

    return "login";
  }
}
