package com.example.websocket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebSocketMessageBroker
@PropertySource("classpath:/application.properties")
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/message").withSockJS();
        registry.addEndpoint("/user").withSockJS() ;
    }

    @Autowired
    private Environment env ;

    @Bean
    public DataSource dataSource(){
        String url = env.getProperty("jdbc.url") ;
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url);
        dataSource.setDriverClassName( env.getProperty("jdbc.driverClassName"));
        dataSource.setUsername( env.getProperty("jdbc.user") );
        dataSource.setPassword( env.getProperty("jdbc.password"));
        return dataSource ;
    }

    public Properties hibernateProperties(){
        return new Properties() {
            {
                setProperty("hibernate.show-sql"  , env.getProperty("hibernate.show-sql"));
                setProperty("hibernate.dialect" , env.getProperty("hibernate.dialect"));
            }
        };
    }

}
