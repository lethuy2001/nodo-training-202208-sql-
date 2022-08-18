package main;

import java.io.*;

public class ObjectWriteExam {
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Temp");
        ObjectOutputStream output = null ;
        FileOutputStream fileOutputStream = null;

        fileOutputStream = new FileOutputStream(new File(file , "my_object"));

        output = new ObjectOutputStream( fileOutputStream);

       PrintMessage printMessage =  new PrintMessage("hllo");
       output.writeObject(printMessage);

    }
}
