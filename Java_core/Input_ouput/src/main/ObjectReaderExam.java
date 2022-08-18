package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

public class ObjectReaderExam {
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Temp\\hanoijava.txt");
        ObjectInputStream input = null ;

        input = new ObjectInputStream(
                new FileInputStream( file )) ;

        Object obj = input.readObject() ;
        Method method = obj.getClass().getMethod("run" ,new Class[0]) ;
        method.invoke( obj , new Object[0]) ;
        input.close();
    }
}
