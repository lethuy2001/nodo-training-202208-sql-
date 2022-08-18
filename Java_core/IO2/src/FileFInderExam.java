import java.io.File;
import java.nio.file.*;

public class FileFInderExam {
    public static class  Finder extends SimpleFileVisitor {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{txt}");

        public FileVisitResult visitFile (Path path){
            if( matcher.matches(path.getFileName()) ){
                System.out.println("Found: " + path );
            }
            return FileVisitResult.CONTINUE ;
        }
    }

    public static void main(String[] args) throws Exception{
        Finder finder = new Finder();
        Files.walkFileTree( Paths.get("C:\\Temp" )  , finder ) ;
    }
}
