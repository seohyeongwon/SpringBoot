package org.comstudy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.model.Saram;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController를 사용 하면 요청 결과가 브라우저 화면에 바로 출력 된다.
@RestController
public class SaramController {
   List<Saram> saramList = new ArrayList<>();
   public SaramController() {
      for(int i=1; i<=10; i++) {
         saramList.add(new Saram(i, "id"+i, "name"+i));
      }
   }
   
   @GetMapping("/myapp/saram")
   public List<Saram> saramList() {
      return saramList;
   }
   
   @PostMapping("/myapp/saram")
   public List<Saram> insertSaram(Saram saram, HttpServletResponse resp) throws IOException {
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
}