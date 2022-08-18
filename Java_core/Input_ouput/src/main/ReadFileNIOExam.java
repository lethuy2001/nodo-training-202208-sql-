package main;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFileNIOExam {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInput = null ;
        FileChannel fileChannel = null ;

        try {
            fileInput = new FileInputStream( new File("C:\\Temp\\hanoijava.txt")) ;
            fileChannel = fileInput.getChannel() ;

            long size = fileChannel.size() ;
            ByteBuffer buff = ByteBuffer.allocate( (int)size) ;
            fileChannel.read(buff);
            buff.rewind() ;
            System.out.println( new String( buff.array() , "utf-8"));
        }finally {
            if( fileChannel != null ) fileChannel.close();
            if( fileInput != null ) fileInput.close();
        }
    }
}
