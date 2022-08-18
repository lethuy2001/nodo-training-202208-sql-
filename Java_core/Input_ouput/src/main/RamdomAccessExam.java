package main;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class RamdomAccessExam {
    public static void main(String[] args) throws Exception {

        File file = new File("D:\\JavaCoreCompany\\kakaka\\kfc.txt") ;

        try ( RandomAccessFile randomAccessFile = new RandomAccessFile(file , "rw")){
            randomAccessFile.seek(9);
            byte[] bytes = new byte[4*102] ;
            int read = randomAccessFile.read(bytes);
            System.out.println( new String( bytes , 0 , read , "utf-8"));
            randomAccessFile.seek( file.length() );
            randomAccessFile.write("\r\n".getBytes());
            randomAccessFile.writeChars("Hello cậu cả");

            Desktop.getDesktop().open(file); ;
        }
    }
}
