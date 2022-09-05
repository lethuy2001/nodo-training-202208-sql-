package com.example.webservice.controller;

import com.example.webservice.dao.GroupDao;
import com.example.webservice.dao.UserDao;
import com.example.webservice.model.Group;
import com.example.webservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    UserDao userDao ;

    @Autowired
    GroupDao groupDao ;

    @RequestMapping ("list/users")
    public List<User> ListUser(HttpServletRequest request ){
        if( !request.isUserInRole("ADMIN")){
            throw new RuntimeException("Access Denied!");
        }
        return userDao.findAll();
    }

    @RequestMapping ("list/groups")
    public List<Group> listGroup(){
        return groupDao.list() ;
    }

    @RequestMapping( value = "add/user" , method = RequestMethod.POST)
    @ResponseStatus( HttpStatus.CREATED )
    public String addUser( @RequestBody User user ){
        return userDao.insert(user) ;
    }

    @RequestMapping(value = "get/user/{name}")
    public User getUser( @PathVariable("name") String name ){
        return userDao.getByName(name );
    }

    @RequestMapping("delete/user/{name}")
    public void delete( @PathVariable("name") String name ){
        userDao.delete(name);
    }

    @RequestMapping(value = "update/user" , method = RequestMethod.POST)
    public void update( User user  ){
        userDao.update(user);
    }
}
