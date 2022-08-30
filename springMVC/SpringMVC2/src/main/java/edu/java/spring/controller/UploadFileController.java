package edu.java.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("student")
public class UploadFileController {

    @PostMapping("avatar/save")
    public String handleFormUpaload(@RequestParam("file")MultipartFile file ) throws IOException {
        if( file.isEmpty() ){
            return "student.error" ;
        }

        byte[] bytes = file.getBytes() ;
        return "" ;
    }

    private File getImageFile(HttpServletRequest request ) {
        ServletContext servletContext = request.getServletContext() ;
        Path diskPath = Paths.get(servletContext.getRealPath("/"));
        File folder = new File(diskPath + File.separator + "avatar" + File.separator) ;
        folder.mkdirs() ;
        return new File( folder , "sss.jsp");
    }
}
