package clases.ejemplo.rmi_demostracion.Server;

import clases.ejemplo.rmi_demostracion.Shared.SingleSessionFactory;
import org.hibernate.SessionFactory;

import clases.ejemplo.rmi_demostracion.Interface.IRUTChecker;

import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PDIServer extends UnicastRemoteObject implements IRUTChecker {
    private static SessionFactory sessionFactory;
    private static final int PORT = 1099;

    public PDIServer() throws RemoteException {
        super();
        sessionFactory = SingleSessionFactory.getPDIFactory();

        if (sessionFactory != null) {
            System.out.println("[PDIServer] La fabrica de sesiones se ha creado correctamente.");
        }
    }

    @Override
    public boolean consultarArraigo(String rut) throws RemoteException {
        return ServerUtils.verifyArraigo(sessionFactory, rut);
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(PORT);
            PDIServer obj = new PDIServer();
            String url = String.format("//%s:%s/IRUTChecker", ServerUtils.BASE_HOST, PORT);
            System.out.println(url);
            Naming.rebind(url, obj);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
