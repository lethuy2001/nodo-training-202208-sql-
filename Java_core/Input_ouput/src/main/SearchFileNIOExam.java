package main;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFileNIOExam {
    public static void main(String[] args) throws Exception {
//
//        Pattern pattern = Pattern.compile("s\\S" , Pattern.CASE_INSENSITIVE) ;
//        File file = new File("C:\\Temp\\sample.txt") ;
//        FileInputStream stream = new FileInputStream(file );
//        FileChannel fileChannel = stream.getChannel() ;
//        ByteBuffer buffer = fileChannel.map(
//                FileChannel.MapMode.READ_ONLY , 0, fileChannel.size()
//        );
//        CharBuffer chars = Charset.defaultCharset().decode(buffer);
//        Matcher matcher = pattern.matcher(chars) ;
//
//        if(matcher.find()) {
//            System.out.println("Found at: " + Integer.toString( matcher.start() ));
//            System.out.println("Value: " + chars.subSequence( 0 , 10 ) + ".");
//        }else{
//            System.out.println("Not Found");
//        }
    }
}
