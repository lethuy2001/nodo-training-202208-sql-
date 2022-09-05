package com.example.webservice;


import com.example.webservice.model.Group;
import com.example.webservice.model.User;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class SpringServiceClientTests {
    private RestTemplate restTemplate ;

    @Before
    public void setUp( ){
        HttpClientBuilder builder = HttpClientBuilder.create() ;
        CloseableHttpClient httpClient = builder.build() ;
        restTemplate = new RestTemplate( new HttpComponentsClientHttpRequestFactory(httpClient)) ;
    }

    @Test
    public void contextLoads() {
        restTemplate = new RestTemplate() ;
        String address = "http://localhost:8080/list/users" ;
        ResponseEntity<List> entity = restTemplate.getForEntity( address , List.class ) ;
        List users = entity.getBody();

        users.forEach( x -> {
            System.out.println(x);
        });
    }
//
//    @Test
//    public void contextLoadss(){
//        restTemplate = new RestTemplate() ;
//        String address = "http://localhost:8080/list/groups/" ;
//        ResponseEntity<List> entity = restTemplate.getForEntity( address , List.class );
//        List groups = entity.getBody();
//        Assert.assertTrue( groups.size() > 0  );
//
//        groups.forEach( x -> {
//            System.out.println(x);
//        });
//    }

//    @Test
//    public void contextLoads() {
//        User user = new User() ;
//        user.setUsername("Hscasascascasc");
//        user.setPassword("sssss");
//        user.setAge(18);
//        user.setEmail("Hienacs@gmai.com");
//        user.setGroupId(1);
//
//        String address = "http://localhost:8080/add/user" ;
//        restTemplate = new RestTemplate( );
//        ResponseEntity<String> insertUser = restTemplate.postForEntity(address , user , String.class) ;
//        Assert.assertEquals( user.getUsername() , insertUser.getBody() );
//    }

//    @Test
//    public void contextLoads( ){
//        String address = "http://localhost:8080/get/user/thuylm" ;
//        restTemplate = new RestTemplate( );
//        ResponseEntity<User> insertUser = restTemplate.getForEntity(address , User.class) ;
//        Assert.assertEquals( "thuylm" , insertUser.getBody().getPassword() );
//    }

//    @Test
//    public void contextLoads( ){
//        restTemplate = new RestTemplate( );
//        String addresss = "http://localhost:8080/delete/user/thuylm" ;
//        ResponseEntity<Void> deleteEntity = restTemplate.getForEntity(addresss , Void.class) ;
//
//        String address = "http://localhost:8080/get/user/thuylm" ;
//        ResponseEntity<User> insertUser = restTemplate.getForEntity(address , User.class) ;
//        Assert.assertEquals( null , insertUser.getBody() );
//    }

//    @Test
//    public void contextLoads( ){
//        restTemplate = new RestTemplate() ;
//        String address = "http://localhost:8080/get/user/thuylmw" ;
//        ResponseEntity<User> getUser = restTemplate.getForEntity(address , User.class) ;
//        User user =  getUser.getBody() ;
////        Assert.assertEquals( null , user );
//
//        user.setPassword("123456");
//        String addresss = "http://localhost:8080/update/user" ;
//        ResponseEntity<Void> updateEntity = restTemplate.postForEntity(addresss , user , Void.class);
//
//        ResponseEntity<User> getUser1 = restTemplate.getForEntity(address , User.class) ;
//        Assert.assertEquals( user.getPassword() , getUser1.getBody().getPassword() );
//    }
}
