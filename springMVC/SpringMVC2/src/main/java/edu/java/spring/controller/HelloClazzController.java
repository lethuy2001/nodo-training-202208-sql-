package edu.java.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloClazzController {
//    @RequestMapping(method = RequestMethod.GET)
//    public ModelAndView printMessage(){
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("index");
//        mv.addObject("message","Hello Java Clazz!xddd");
//        mv.addObject("name" ,"Siêu nhân gao");
//        return mv;
//    }

    @RequestMapping( value = "site" , method = RequestMethod.GET )
    public String redirect(){
        return "redirect:https://www.facebook.com/" ;
    }

//    @RequestMapping(Mapping="data")
//    public @ResponseBody String raw() {
//        return "Xin chao moi nguoi" ;
//    }

    @RequestMapping( method = RequestMethod.GET)
    public ModelAndView printMessage(@RequestParam ( value = "data" , required = false , defaultValue = "hello world my nam ") String name ){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("message", name );
        return mv;
    }


}
