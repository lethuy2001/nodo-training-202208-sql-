package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public class DatagramServerExam implements Runnable{
    DatagramSocket socket = new DatagramSocket( 4445) ;

    public DatagramServerExam() throws SocketException {
        System.out.println("DATA SERVER listening.....");
    }

    @Override
    public void run() {
        try {
            byte[] bytes = new byte[0];
            DatagramPacket packet = new DatagramPacket( bytes , bytes.length ) ;
            socket.receive(packet);
            System.out.println("From Client: " + (new String( packet.getData() , 0 , packet.getLength() )));
            bytes = "Server say hello".getBytes() ;
            socket.send( new DatagramPacket( bytes , bytes.length , packet.getAddress() , packet.getPort()));
        } catch ( Exception e ) {
            throw new RuntimeException(e);
        } finally {
            socket.close();
        }
    }

    public static void main(String[] args) throws SocketException {
        new Thread( new  DatagramServerExam() ).start();
    }


}
