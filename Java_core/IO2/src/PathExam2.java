import javax.print.CancelablePrintJob;
import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExam2 {
    public static void main(String[] args) throws Exception{
        Path path = Paths.get("C:\\Temp") ;
        Path path2 = path.resolve("hanoijava.txt") ;

        Charset charset = Charset.forName("utf-8");
        try (BufferedReader reader = Files.newBufferedReader( path2 , charset)){
            String line = null ;
            while ( (line = reader.readLine()) != null ){
                System.out.println(line);
            }
        }catch ( Exception e) {
            e.printStackTrace();
        }
    }
}
