import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopingAndMovingExam {
    public static void main(String[] args) throws Exception{
        Path source = Paths.get("C:\\Temp\\hanoijava.txt" )  ;
        Path target = Paths.get("C:\\Temp\\simple.txt" ) ;
        Files.copy(source , target , StandardCopyOption.REPLACE_EXISTING) ;

        Path targets = Paths.get("C:\\Temp\\hanoijava.txt");
        Files.delete(targets);

        Path target2 = Paths.get("C:\\Temp\\hanoijava.txt") ;
        Files.delete(target2);
    }
}
