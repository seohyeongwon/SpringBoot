package org.comstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class FileUploadController {

   
   @GetMapping("/upload")
   public String uploadForm(Model model) {
      model.addAttribute("title", "Upload Form");
      return "uploadForm";
   }
   
   @PostMapping("/upload")
   public String uploadResult(Model model) {
      model.addAttribute("title", "Upload Result");
      return "uploadResult";
   }
   
}