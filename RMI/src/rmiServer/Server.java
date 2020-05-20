package rmiServer;
import rmiObject.RemoteService;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(1099);
            RemoteService remoteobject = new RemoteService();
            System.out.println("server started...");
            Naming.bind("echo",remoteobject);
            Naming.bind("add",remoteobject);

        }catch (Exception e){
            System.out.println(e);
        }
    }
}


