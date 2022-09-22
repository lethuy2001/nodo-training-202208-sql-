package com.example.webservice;

import com.example.webservice.dao.UserDao;
import com.example.webservice.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class HNServiceEvaluator implements PermissionEvaluator {
    private final Logger LOGGER = Logger.getLogger( HNServiceEvaluator.class );

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {

        if( targetDomainObject instanceof User ){
            User user = (User) targetDomainObject;
            return user.getAge() > 22 ;
        }
        LOGGER.info("------->" + targetDomainObject + ":" + permission );

        return true;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        LOGGER.info("------->" + targetType + ":" + permission );
        return true;
    }
}
