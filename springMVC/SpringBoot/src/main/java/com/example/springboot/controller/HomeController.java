package com.example.springboot.controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
//@RequestMapping("home")
public class HomeController {
    private final static Logger logger = Logger.getLogger(HomeController.class) ;

//    @GetMapping("hh")
//    public String home( Model model ){
//        model.addAttribute("message" , "hahhahffaha") ;
//        logger.info("Đã truy cập vào đây");
//        return "index" ;
//    }
//
//    @GetMapping("sv")
//    public @ResponseBody String sk (){
//        return "hello world" ;
//    }

    @RequestMapping("/login")
    public String login( Model model , @RequestParam( value = "error" , required = false ) String error){
        if( error != null ){
            model.addAttribute("error" , "Sai tên hoặc maajtg khẩu");
        }
        return "login" ;
    }

    @RequestMapping("nguoi-dung")
    public String forUser( Model model ){
        model.addAttribute( "message" , "hello User") ;
        return "infomation" ;
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request , HttpServletResponse response ){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if( auth != null ){
            new SecurityContextLogoutHandler().logout( request , response , auth );
        }
        return "redirect:/login" ;
    }

//    @RequestMapping("home")
//    public String Home() {
//
//        return "layout" ;
//    }

}
