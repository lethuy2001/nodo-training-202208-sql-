package com.example.webservice;

import com.example.webservice.controller.UserRestController;
import com.example.webservice.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class SpringHnserviceApplication {

    @Autowired
    UserRestController userRestController ;

//    @Test
//    public void contextLoad(){
//        List<User> users = userRestController.ListUser() ;
//        Assert.isTrue( users.size() > 0 , "True" );
//    }
}
