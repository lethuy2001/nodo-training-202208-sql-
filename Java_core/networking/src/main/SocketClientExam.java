package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class SocketClientExam {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost" , 8081 );
        System.out.println("CLIENT start sending.....");
        try (DataInputStream input = (DataInputStream) socket.getInputStream();
             DataOutputStream output = (DataOutputStream) socket.getOutputStream();
        ){
            output.writeUTF("Hello Server");
            System.out.println("Server say: " + input.readUTF() );
        }finally {
            socket.close();
        }
    }
}
