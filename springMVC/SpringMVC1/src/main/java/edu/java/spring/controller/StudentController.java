package edu.java.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("student")
public class StudentController {
    @GetMapping("form")
    public ModelAndView printForm(){
        ModelAndView mv = new ModelAndView( "student.form" , "command" , new Student()) ;
        mv.setViewName("svForm");
        return mv ;
    }

    @GetMapping("save")
    public ModelAndView printInfo(@RequestParam ( value = "name" , required = false ) String name ,
                                  @RequestParam (value = "age" , required = false ) String age ){
        ModelAndView mv = new ModelAndView() ;
        mv.setViewName("formInfo");
        mv.addObject("name" , name );
        mv.addObject("age" , age ) ;
        return mv ;
    }

    @PostMapping ("info")
    public ModelAndView printFormss(@Valid @ModelAttribute("command") Student student , BindingResult rs ){

        if(rs.hasErrors()){
            ModelAndView mv = new ModelAndView( "student.form" , "command" , student ) ;
            mv.addObject("student" , student );
            mv.addObject("error" , rs );
            mv.setViewName("svForm");
            return mv ;
        }else{
            ModelAndView mv = new ModelAndView() ;
            mv.addObject("sv" , student );
            mv.setViewName("formInfo");
            return mv ;
        }
    }

}
