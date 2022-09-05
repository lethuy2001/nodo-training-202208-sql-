package com.example.springsecurity_hibernate.controller;

import com.example.springsecurity_hibernate.dao.GroupDao;
import com.example.springsecurity_hibernate.dao.UserDao;
import com.example.springsecurity_hibernate.model.Group;
import com.example.springsecurity_hibernate.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarOutputStream;

@Controller
@RequestMapping("acc")
public class UserController {
    private final Logger logger = Logger.getLogger(UserController.class) ;


    @Autowired
    GroupDao groupDao ;

    @Autowired
    UserDao userDao ;

    @RequestMapping("form")
    public ModelAndView addForm(){
        ModelAndView mv = new ModelAndView("user_form" , "command" , new User() ) ;
        mv.addObject("groups" , toGroupMap(groupDao.list()) );
        return mv ;
    }

    private Map<Integer, String> toGroupMap(List<Group> groups ){
        Map<Integer , String > map = new HashMap<>();
        groups.forEach( group -> map.put( group.getId() , group.getName() ));
        return map ;
    }

    @RequestMapping("save")
    public ModelAndView addNew( @ModelAttribute("command") User user , @RequestParam("group") int id  ){
        user.setGroup( groupDao.findById(id));
        userDao.insert( user );
        return new ModelAndView("redirect:/acc/form");
    }

    @RequestMapping("list/{id}")
    public ModelAndView list(@PathVariable("id") Integer id ){
        ModelAndView mv = new ModelAndView("user_list") ;
        mv.addObject("users" , userDao.listUserByGroup(id) ) ;
        return mv ;
    }
}
