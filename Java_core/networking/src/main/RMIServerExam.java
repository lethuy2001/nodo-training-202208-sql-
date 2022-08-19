package main;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServerExam implements Hello {

    @Override
    public String say(String name) throws RemoteException {
        return "Hello " + name ;
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("java.rmi.server.hostname" , "127.0.0.1") ;
        RMIServerExam obj = new RMIServerExam();
        Remote stub = UnicastRemoteObject.exportObject(obj , 0) ;

        Registry register = LocateRegistry.getRegistry("127.0.0.1" , 8000) ;
        register.bind("Hello" , stub);
        System.out.println("Server ready");
    }
}
