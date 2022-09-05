package com.example.webservice.test;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;

public class RestClientTest {

    public static void main(String[] args) throws Exception{
        URL url = new URL("http://localhost:8080/list/users/") ;
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("Accept" , "Application/Json");
        InputStream stream = connection.getInputStream();

        byte[] bytes = new byte[4*1024] ;
        int read = -1 ;
        try {
            while ( (read=stream.read(bytes)) != -1 ){
                System.out.println(new String( bytes , 0 , read ));
            }
        }catch ( Exception e ){
            e.printStackTrace();
        } finally {
            stream.close();
        }
    }
}
