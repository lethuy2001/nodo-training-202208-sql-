import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.logging.Filter;

public class PathExam {
    public static void main(String[] args) throws Exception{
        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isDirectory( entry) ;
            }
        };

        Path path = Paths.get("C:\\Temp");
        System.out.println("This is " + (Files.isDirectory(path) ? "file" : "folder"));
        System.out.println(Files.exists(path));

//        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)){
//            for ( Path p : directoryStream ){
//                System.out.println(p.getFileName());
//            }
//        }catch ( Exception e ){
//            e.printStackTrace();
//        }

        try ( DirectoryStream<Path> directoryStream = Files.newDirectoryStream( path , filter)){
            for ( Path p : directoryStream ){
                System.out.println(p.getFileName());
            }
        }catch ( Exception e ){
            e.printStackTrace();
        }
    }

}
