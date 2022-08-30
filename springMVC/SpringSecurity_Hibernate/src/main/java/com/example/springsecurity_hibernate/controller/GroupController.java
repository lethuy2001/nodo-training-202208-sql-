package com.example.springsecurity_hibernate.controller;

import com.example.springsecurity_hibernate.dao.GroupDao;
import com.example.springsecurity_hibernate.model.Group;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("group")
public class GroupController {
    private final Logger logger = Logger.getLogger(GroupController.class);
    @Autowired
    GroupDao dao ;

    @RequestMapping("add")
    public ModelAndView addForm() {

        return new ModelAndView("form" , "command" , new Group() ) ;
    }

    @RequestMapping("new")
    public ModelAndView addNew(@Valid @ModelAttribute("command") Group group , BindingResult result ){
        if( result.hasErrors() ){
            ModelAndView model = new ModelAndView("form" , "command" , group);
            model.addObject("error" , result ) ;
            return model;
        }

        if( group.getId() > 0 ){
            dao.update(group);
        }else{
            dao.insert(group);
        }
        return new ModelAndView( "form");
    }

    @RequestMapping("list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView( ) ;
        mv.setViewName("group_list");
        mv.addObject("groups" , dao.list() );
        return mv ;
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id ) {
        if( id == null ) return "redirect:/group/list" ;
        dao.delete(id);
        return "redirect:/group/list" ;
    }

//    @RequestMapping("edit/{id}")
//    public String edit( @PathVariable("id") Integer id ){
//        Group group = dao.get
//    }

}
