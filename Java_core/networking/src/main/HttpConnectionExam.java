package main;

import java.awt.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class HttpConnectionExam {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.google.com.vn/?hl=vi") ;
        URLConnection connection = url.openConnection() ;
        Path path = Paths.get("test.html") ;
        try (InputStream inputStream = connection.getInputStream() ;
              OutputStream outputStream = Files.newOutputStream( path , StandardOpenOption.CREATE ,
                StandardOpenOption.APPEND )
        ){
            int read = -1 ;
            byte[] bytes = new byte[0];
            while (( read = inputStream.read(bytes) ) != -1 ){
                outputStream.write(bytes , 0 , read );
            }
        }finally {
            Desktop.getDesktop().open(path.toFile());
        }
    }
}
