package clases.ejemplo.rmi_demostracion.Server;

import clases.ejemplo.rmi_demostracion.Shared.Constants;
import clases.ejemplo.rmi_demostracion.Shared.SingleSessionFactory;
import org.hibernate.SessionFactory;

import clases.ejemplo.rmi_demostracion.Shared.Interfaces.IPatentChecker;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CarabineroServer extends UnicastRemoteObject implements IPatentChecker {
    private static SessionFactory sessionFactory;
    private static final int PORT = 1100;

    public CarabineroServer() throws RemoteException {
        super();
        sessionFactory = SingleSessionFactory.getCarabineroFactory();
        if(sessionFactory != null) {
            System.out.println("[CarabineroServer] La fabrica de sesiones se ha creado correctamente.");
        }
    }

    @Override
    public boolean consultarRobo(String patente) throws RemoteException {
        return ServerUtils.verifyVehicle(sessionFactory, patente);
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(Constants.CARABINEROS_PORT);
            CarabineroServer obj = new CarabineroServer();

            String baseUrl = String.format("//%s:%s/%s", Constants.SERVER_IP, Constants.CARABINEROS_PORT, Constants.REVISA_PATENTES);
            System.out.println(baseUrl);
            Naming.rebind(baseUrl, obj);
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
    
}
