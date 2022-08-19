package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote  {
    String say(String name ) throws RemoteException ;
}
