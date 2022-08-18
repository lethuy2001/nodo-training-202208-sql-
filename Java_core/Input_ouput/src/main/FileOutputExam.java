package main;

import java.io.*;

public class FileOutputExam {
    public static void main(String[] args) throws IOException {
        File file = new File("C:" + File.separator + "Temp" + File.separator + "hanoijava.txt"  ) ;
        String sks = "Hello ta khá";

        try(FileOutputStream outputStream = new FileOutputStream(file)) {
            byte[] bytes = sks.getBytes("utf-8") ;
            outputStream.write(bytes);
        }

        try ( FileInputStream inputStream = new FileInputStream(file)){
            byte[] bytes1 = new byte[ 4 *1024] ;
            int read = -1 ;
            StringBuilder builder = new StringBuilder() ;
            while ( (read = inputStream.read(bytes1)) != -1 ){
                builder.append( new String( bytes1 , 0 , read )) ;
            }
//            inputStream.read(bytes1) ;
//
//            System.out.println( new String( bytes1 , "utf-8"));
            System.out.println(builder);
        }
    }
}
