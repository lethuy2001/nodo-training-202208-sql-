package main;

import javax.print.DocFlavor;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Stream;

public class URLConnectionExam {
    public static void main(String[] args) throws Exception {
        URL url = new URL( "https://www.google.com.vn/?hl=vi") ;
        URLConnection connection = url.openConnection();
        InputStream stream = connection.getInputStream() ;

        int read = -1  ;
        byte[] bytes;
        bytes = new byte[0];
        while ( (read = stream.read(bytes) ) != -1 ){
            System.out.println( new String( bytes , 0 , read));
        }
    }
}
