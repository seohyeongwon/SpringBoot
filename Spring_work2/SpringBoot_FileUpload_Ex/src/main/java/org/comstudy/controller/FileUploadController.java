package org.comstudy.controller;

import org.comstudy.dto.FileDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {
   
   @GetMapping("/upload")
   public String uploadForm(Model model) {
      model.addAttribute("title", "Upload Form");
      return "uploadForm";
   }
   
   @PostMapping("/upload")
   public String uploadResult(@RequestParam MultipartFile[] uploadfile, Model model) throws IllegalStateException, IOException {
      List<FileDTO> files = new ArrayList<>();
      
      for(MultipartFile file: uploadfile) {
         FileDTO fileDto = new FileDTO(UUID.randomUUID().toString(), 
               file.getOriginalFilename(), 
               file.getContentType());
         files.add(fileDto);
         
         // uuid_파일명.png
         File newFile = new File(fileDto.getUuid()+"_"+fileDto.getFileName());
         file.transferTo(newFile);
      }
      
      model.addAttribute("title", "업로드 결과");
      model.addAttribute("files", files);
      return "uploadResult";
   }
   
   // applicaton.yml파일에 설정된 multipart.location 값 가져온다.
   @Value("${spring.servlet.multipart.location}")
   private String filePath;
   
   @GetMapping("/download")
   public ResponseEntity<Resource> download(@ModelAttribute FileDTO dto) throws IOException {
      Path path = Paths.get(filePath+"/"+dto.getUuid()+"_"+dto.getFileName());
      
      String contentType = Files.probeContentType(path);
      HttpHeaders headers = new HttpHeaders();
      ContentDisposition contentDisposition = 
            ContentDisposition.builder("attachment")
            .filename(dto.getFileName(), StandardCharsets.UTF_8)
            .build();
      headers.setContentDisposition(contentDisposition);
      headers.add(HttpHeaders.CONTENT_TYPE, contentType);
      Resource resource = new InputStreamResource(Files.newInputStream(path));
      return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
   }
}