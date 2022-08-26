package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServer {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in) ;
        ServerSocket serverSocket = new ServerSocket( 8091) ;
        System.out.println("Server đang kết nối...");
            Socket socket = serverSocket.accept() ;
                try (DataInputStream inputStream = new DataInputStream( socket.getInputStream() );
                     DataOutputStream outputStream = new DataOutputStream( socket.getOutputStream());
                ){
                    while (true){
                        System.out.println( inputStream.readUTF() );
                        String sk = sc.nextLine() ;
                        outputStream.writeUTF(  sk);
                        outputStream.flush();
                    }
                }
    }
}
