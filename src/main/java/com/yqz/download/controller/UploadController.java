package com.yqz.download.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
      private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

      @GetMapping("/upload")
    public String upload(){
          return "upload" ;
      }

      @PostMapping("/upload")
     @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file){
          if (file.isEmpty()){
              return "上传文件失败,请重新选择文件";
          }
          String filename = file.getOriginalFilename();
          String filePath = "/var/www/html/" ;
          File dest = new File(filePath+filename);
          try {
              file.transferTo(dest);
              LOGGER.info("上传成功");
              return filename+"上传成功";
          }catch (IOException e){
              LOGGER.error(e.toString(),e);
          }
              return "上传失败";
      }

}
