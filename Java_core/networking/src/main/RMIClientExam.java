package main;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClientExam {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry("localhost" , 8080) ;
        Remote stub = registry.lookup("Hello");
        System.out.println("Response " + stub.toString() );
    }
}
