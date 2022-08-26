package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in) ;
        Socket socket = new Socket( "localhost" , 8091) ;
        System.out.println("Client đang kết nối...");
        try (DataInputStream inputStream = new DataInputStream( socket.getInputStream() );
             DataOutputStream outputStream = new DataOutputStream( socket.getOutputStream());
        ){
            while ( true) {

                String sk = sc.nextLine() ;
                outputStream.writeUTF("Client 1: " + sk);
                outputStream.flush() ;
                System.out.println("Server say: " + inputStream.readUTF() );
            }
        }
    }
}
