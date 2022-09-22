package com.example.webservice;

import javax.xml.bind.DatatypeConverter;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestClientTest {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/list/users/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Accept" , "Application/Json");

        String account = "quantri:123456" ;

        String basicAuth = "Basic " + DatatypeConverter.printBase64Binary( account.getBytes());

        connection.setRequestProperty("Authorization" , basicAuth );
        InputStream stream = connection.getInputStream();
        int read = -1 ;
        byte[] bytes = new byte[ 4 * 1024] ;
        while ( ( read=stream.read(bytes)) != -1 ){
            System.out.println(new String( bytes ,0 , read ) );
        }
    }
}
