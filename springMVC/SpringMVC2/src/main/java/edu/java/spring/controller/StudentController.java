package edu.java.spring.controller;


import edu.java.spring.dao.impl.StudentDAOImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("student")
public class StudentController {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml") ;
    StudentDAOImpl dml = (StudentDAOImpl) context.getBean("studentJdbcDAO") ;

    @GetMapping("form")
    public ModelAndView printForm(){
        ModelAndView mv = new ModelAndView( "student.form" , "command" , new Student()) ;
        mv.addObject("list" , dml.list() );
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

    @GetMapping("delete/{id}")
    public String  delete( @PathVariable( value = "id") Integer id   ){
        dml.DeleteById( id);
        return "redirect:/student/form" ;
    }

    @GetMapping("edit/{id}")
    public ModelAndView edit( @PathVariable( value = "id") Integer id ){
        Student student = dml.FindById(id) ;
        ModelAndView mv = new ModelAndView("svForm" , "command" , student) ;
        return mv  ;
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
            System.out.println(student.toString());
            if( student.getId() == 0 ){
                dml.insert(student);
                mv.addObject("message" , "Thêm mới thành công");
            }else {
                dml.Update( student ); ;
                mv.addObject("message" , "Cập nhập thành công") ;
            }
            mv.setViewName("svForm");
            return mv ;
        }
    }

    @GetMapping( "json/{id}")
    public @ResponseBody Student viewJson( @PathVariable(value = "id") Integer id ) {
        return dml.FindById(id);
    }

    @GetMapping("listStudent")
    public ModelAndView ListStudent () {
        ModelAndView mv = new ModelAndView() ;
        mv.addObject("lists" , dml.list() ) ;
        mv.setViewName("listsv");
        System.out.println(dml.list() );
        return mv;
    }

    @GetMapping("findbyname")
    public ModelAndView listStudents( @RequestParam(value = "data" , required = false ) String query ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("listsv");
        mv.addObject( "lists" , dml.findByName(query) );
        return mv ;
    }

}
