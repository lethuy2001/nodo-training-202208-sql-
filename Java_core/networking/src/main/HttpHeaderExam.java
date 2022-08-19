package main;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class HttpHeaderExam {
    public static void main(String[] args) throws IOException {
        URL url = new URL( "https://www.facebook.com/") ;

        HttpURLConnection connection = (HttpURLConnection)url.openConnection() ;

        System.out.println("http method: " + connection.getRequestMethod() );
        Map<String, List<String>> headers = connection.getHeaderFields();
        BiConsumer<String , List<String> > header = ( key , values ) -> {
            System.out.println("Key: " + key  + "Value: " + values );
        };
        headers.forEach( header);
    }
}
