package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class SocketClientExam {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost" , 8091 );
        System.out.println("CLIENT 1 start sending.....");

        try (DataInputStream input = new DataInputStream( socket.getInputStream()) ;
             DataOutputStream output = new DataOutputStream ( socket.getOutputStream());
        ){
            output.writeUTF("Client 2: Hello world" );
            output.flush();
            System.out.println("Server say: " + input.readUTF() );
        }finally {
            socket.close();
        }
    }
}
