import java.io.File;
import java.nio.file.*;

public class FileVisiorExam {

    public static class PrintFiles extends SimpleFileVisitor<Path> {
        public FileVisitResult visitResult( Path path ) {
            System.out.println( path + " is FIle");
            return FileVisitResult.CONTINUE ;
        }
//
//        public FileVisitResult postVisitDirectory( ) {
//            System.out.println(" is directory");
//        }
    }


    public static void main(String[] args) throws Exception{
        Path path = Paths.get("C:\\Temp");
        Files.walkFileTree( path , new PrintFiles()) ;
    }
}
