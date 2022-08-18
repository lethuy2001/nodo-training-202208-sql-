import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RandomAccessFileExam {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("C:\\Temp\\hanoijava.txt") ;
        ByteBuffer buffer = ByteBuffer.allocate(17) ;
        try (FileChannel fc = FileChannel.open(path )){
            fc.read(buffer );
            System.out.println( new String( buffer.array() ));
        }
    }
}
