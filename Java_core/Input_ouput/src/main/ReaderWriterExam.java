package main;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

public class ReaderWriterExam {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Temp\\hanoijava.txt");
        try (FileWriter writer = new FileWriter(file)){
            writer.write("\r\n");
            writer.write("Nguyễn Viết Hiên");
            Desktop.getDesktop().open(file);
        }

        FileReader reader = new FileReader(file) ;
        char[] buffer = new char[4*1024] ;
        StringBuilder builder = new StringBuilder() ;
        int read = -1 ;
        while ( ( read = reader.read(buffer) ) != -1 ){
            builder.append(buffer , 0 , read ) ;
        }

        System.out.println(builder);
    }
}
