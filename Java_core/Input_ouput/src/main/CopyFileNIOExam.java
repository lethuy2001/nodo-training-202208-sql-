package main;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class CopyFileNIOExam {
    public static void main(String[] args) throws Exception {
        File sourceFile = new File("C:\\Temp\\hanoijava.txt") ;
        File desFile = new File( sourceFile.getParentFile() , "sample.txt" ) ;
        FileChannel src =  new FileInputStream(sourceFile).getChannel() ;
        FileChannel des = new FileOutputStream(desFile).getChannel() ;

        src.transferTo( 0 , src.size() , des ) ;

        FileInputStream svvv = new FileInputStream( new File("C:\\Temp\\hanoijava.txt"));
        FileOutputStream sa = new FileOutputStream( new File( sourceFile.getParentFile() , "sampleee.txt" ));

        svvv.transferTo(sa) ;


        Desktop.getDesktop().open(sourceFile.getParentFile());
    }
}
