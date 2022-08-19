import java.nio.file.*;
import java.security.Provider;
import java.util.Map;

public class WatchFolderExam {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("C:\\Temp") ;
        watch(path);
    }

    public static void watch(Path path ) throws Exception {
        FileSystem fs = path.getFileSystem() ;
        try (WatchService service = fs.newWatchService() ){
            path.register( service , StandardWatchEventKinds.ENTRY_CREATE  ) ;
            while ( true ){
                WatchKey key =  service.take();
                for ( WatchEvent watchEvent : key.pollEvents() ){
                    if( StandardWatchEventKinds.ENTRY_CREATE == watchEvent.kind() ){
                        Path newPath = ((WatchEvent<Path>) watchEvent ).context();
                        System.out.println("New path created: " + newPath);
                    }
                }
                if( !key.reset() ){
                    break;
                }
            }
        }
    }
}
