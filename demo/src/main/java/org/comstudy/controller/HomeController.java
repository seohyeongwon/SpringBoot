package org.comstudy.controller;

import java.util.ArrayList;
import java.util.List;

import org.comstudy.model.Saram;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController를 사용 하면 요청 결과가 브라우저 화면에 바로 출력 된다.
@RestController
public class HomeController {
   List<Saram> saramList = new ArrayList<>();
   
   public HomeController() {
      System.out.println("===> HomeController 생성");
      
      for(int i=1; i<=10; i++) {
         saramList.add(new Saram(i, "id"+i, "name"+i));
      }
   }
   
   @GetMapping("/saram")
   public List<Saram> saramList() {
      return saramList;
   }
   
   @PostMapping("/saram") 
   public List<Saram> insertSaram(Saram saram) {
      int maxIdx = -1;
      for(int i=0; i<saramList.size(); i++) {
         if(saramList.get(i).getIdx() > maxIdx) {
            maxIdx = saramList.get(i).getIdx();
         }
      }
      saram.setIdx(maxIdx+1);
      saramList.add(saram);
      
      return saramList;
   }
   
   @GetMapping("/hello")
   public String hello(String name) {
      return "Hello : " + name;
   }
   
   @GetMapping("/hello2")
   public Saram hello2(String name) {
      Saram saram = new Saram(10, "HONG", name);
      return saram;
   }
   
   @GetMapping("/hello3")
   public Saram hello3(Saram saram) {
      return saram;
   }
   

}