import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class LinkFileExam {
    public static void main(String[] args) throws Exception{

        Path source = Paths.get( "C:\\Temp\\hanoijava.txt") ;
        Path target = Paths.get("C:\\Temp\\sample.txt") ;

        Charset charset = Charset.forName("utf-8") ;
        try (BufferedWriter writer = Files.newBufferedWriter(source , charset )){
            writer.write("Java NIO 2 example \r\n");
        }

        try (BufferedReader reader = Files.newBufferedReader( target , charset )){
            String line  =  null ;
            while ( (line = reader.readLine()) != null ){
                System.out.println(line);
            }
        }

    }
}
