package main;

import java.net.*;

public class DatagramClientExam {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket() ;
            InetAddress  address = InetAddress.getByName("localhost");
            byte[] bytes = "Clien Say Xin Chao".getBytes() ;
            DatagramPacket packet = new DatagramPacket( bytes , bytes.length , address , 4445);

            socket.receive(packet);

            System.out.println("From Server: " + new String(packet.getData() , 0 , packet.getLength()));
            socket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
