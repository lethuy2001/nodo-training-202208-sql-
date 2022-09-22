package com.example.webservice;

import com.example.webservice.dao.UserDao;
import com.example.webservice.model.User;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HnUserAuthProvider implements AuthenticationProvider {

    @Autowired
    private UserDao userDao ;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName().toString() ;
        User user = userDao.getByName(username ) ;
        if( user == null ){
            return null;
        }

        if( !user.getPassword().equals( authentication.getCredentials())){
            return null ;
        }

        return successful( username , authentication.getCredentials().toString() , "USER") ;
    }

    private UsernamePasswordAuthenticationToken successful( String username , String password , String role ) {
        List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>() ;
        grantedAuths.add( new SimpleGrantedAuthority(role));
        return new UsernamePasswordAuthenticationToken( username , password , grantedAuths) ;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals( UsernamePasswordAuthenticationToken.class);
    }
}
