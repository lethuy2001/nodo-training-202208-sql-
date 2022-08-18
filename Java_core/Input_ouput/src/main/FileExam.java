package main;

import javax.crypto.spec.PSource;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class FileExam {
    public static void main(String[] args) {
//        File file = new File("D:\\JavaCoreCompany\\New folder\\JSE.Unit03.Collection.1-Win64\\JSE.Unit03.Collection.1-64.exe") ;
//        if( file.isFile() ){
//            System.out.println("this is file");
//        }else {
//            System.out.println("this is folder");
//        }
//
//        System.out.println( "This is" + ( file.isFile() ? "file" : "folder"));
//
        File file1 = new File("D:\\Mon_Hoc\\java6");
//        File[] files = file1.listFiles() ;
//        for( File f : files ){
//            System.out.println(f.getName() + " length: " + f.length() + "Bytes");
//        }

        System.out.println("Size: " + getSize(file1) / ( 1024 * 1024) + "MB");
    }

    private static long getSize( File file ){
        if( file.isFile() ) return file.length() ;
        File[] files = file.listFiles() ;
//        int length = 0 ;
//        for( int i=0 ; i< files.length ; i++ ){
//            if( files[i].isFile() ){
//
//            }else{
//                length += getSize(files[i]);
//                continue;
//            }
//            length += files[i].length() ;
//        }
//        return length ;
        AtomicLong length = new AtomicLong(0) ;
        Arrays.stream(file.listFiles() ).forEach( f ->{
            length.getAndSet(length.longValue() + (f.isFile() ? f.length() : getSize(f) ));
        });
        return length.longValue() ;
    }
}
