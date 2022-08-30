package com.example.springsecurity_hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("home")
    public String home(Model model ) {
        model.addAttribute("message" , "Hello vinh cức trâu");
        return "index" ;
    }

    @RequestMapping("nguoi-dung")
    public String forUser( Model model ){
        model.addAttribute("message" , "Đày là trang hoho");
        return "index" ;
    }

    @RequestMapping("login")
    public String login( ){
        return "login" ;
    }

    @RequestMapping("dang-nhap")
    public String login(@RequestParam( value = "error" , required = false) String error , Model model ){
        if( error != null ){
            model.addAttribute("error" , error) ;
        }
        return "login" ;
    }
}
