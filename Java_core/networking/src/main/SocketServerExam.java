package main;

import javax.sound.sampled.Port;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerExam {
    public SocketServerExam( int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket( port ) ;
        System.out.println("SERVER Listening.....");
        while ( true ){
            Socket socket = serverSocket.accept() ;
            new Thread( () -> {
                try (DataInputStream input = new DataInputStream(socket.getInputStream());
                     DataOutputStream ouput = new DataOutputStream( socket.getOutputStream() )
                ){
                    System.out.println("Client say: " + input.readUTF() );
                    ouput.writeUTF("I am a socket server");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }

    public static void main(String[] args) throws Exception {
        SocketServerExam sc = new SocketServerExam( 8081) ;
    }
}
