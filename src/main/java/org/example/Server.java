package org.example;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hola{
    public Server() {}

    public String diHola(){
        return "Hola, mundo";
    }

    public static void main(String args[]){

        try {
            Server obj = new Server();
            Hola stub = (Hola) UnicastRemoteObject.exportObject(obj, 0);

            // Liga los datos (stub) del objeto remoto en el registro
            Registry registro = LocateRegistry.getRegistry();
            registro.bind("Hola",stub);

            System.err.println(" listo");
        } catch (Exception e) {
            System.err.println("Excepción del servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
