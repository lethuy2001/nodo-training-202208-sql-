import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WritePathExam {
    public static void main(String[] args) throws Exception{
        Path path = Paths.get("C:\\Temp\\hanoijava.txt");
        try (BufferedWriter writer = Files.newBufferedWriter( path
                , Charset.forName("utf-8")  )){
            for( int i=0 ; i<10 ; i++ ){
                writer.write("Nguyễn Văn " + i + "\r\n");
            }
        }catch ( Exception e ){
            e.printStackTrace();
        }
    }
}
