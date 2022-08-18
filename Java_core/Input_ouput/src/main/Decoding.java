package main;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Decoding {
    public static void main(String[] args) {
        int[] values = { 120 , 105 , 110 , 32 , 99 , 104 , -61 , -96, 111 } ;
        byte[] bytes = new byte[values.length];

        for( int i=0 ; i< bytes.length ; i++ ){
            bytes[i] = (byte) values[i] ;
        }

        try {
            System.out.println(new String(bytes , "utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        String sk = "Xin chào mọi người" ;

        byte[] bytes1 = sk.getBytes(StandardCharsets.UTF_8) ;
        for( int i = 0 ; i< bytes1.length ; i++ ){
            System.out.println(bytes1[i]);
        }
    }
}
