package org.comstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class demoController {

   @GetMapping("/home")
   public String home() {
      return "home";
   }
   
}