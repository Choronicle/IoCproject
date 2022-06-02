package com.example.xianyu.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin
public class FileUpLoadController {
        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
    @PostMapping("/uploadImage")
    public Map<String, Object> fileUpLoad(MultipartFile file, HttpServletRequest request){
        Map<String, Object> result = new HashMap<>();
        String originName = file.getOriginalFilename();
        if(originName.endsWith(".png") || originName.endsWith(".jpeg")|| originName.endsWith(".jpg")){

        }else{
            result.put("status","error");
            result.put("msg","文件类型不对");
            return result;
        }
        String format = sdf.format(new Date());
        String realPath = request.getServletContext().getRealPath("/") + format;
        File folder = new File(realPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        String newName = UUID.randomUUID() + ".png";
        try{
            file.transferTo(new File(folder, newName));
            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + format + newName;
            result.put("status","success");
            result.put("url",url);
        }catch (IOException e){
            result.put("status","error");
            result.put("msg", e.getMessage());

        }
        return result;
    }
}
