package com.example.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@PropertySource("classpath:/application.properties")
public class AppConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private Environment env ;

//    @Override
//    public void configureDefaultSevletHandling(){
//
//    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        super.configureDefaultServletHandling(configurer);
    }

    @Bean
    public DataSource dataSource()  {
        String url = env.getProperty("jdbc.url") ;
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url);
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        return dataSource ;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory()  {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.example.webservice.model");
        sessionFactory.setHibernateProperties( hibernateProperties());
        return sessionFactory ;
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
