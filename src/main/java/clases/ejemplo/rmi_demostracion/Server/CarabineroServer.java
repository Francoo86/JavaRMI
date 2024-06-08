package clases.ejemplo.rmi_demostracion.Server;

import clases.ejemplo.rmi_demostracion.Shared.SingleSessionFactory;
import clases.ejemplo.rmi_demostracion.models.Vehiculo;
import clases.ejemplo.rmi_demostracion.sessions.CarabineroSession;
import clases.ejemplo.rmi_demostracion.sessions.SessionRMI;
import org.hibernate.SessionFactory;

import clases.ejemplo.rmi_demostracion.Interface.PreguntarPatente;

import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CarabineroServer extends UnicastRemoteObject implements PreguntarPatente {
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
        /*
        boolean robo= false;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Vehiculo vehiculo = (Vehiculo) session.createQuery("FROM Vehiculo WHERE patente = :patente")
                    .setParameter("patente", patente)
                    .uniqueResult();
            if (vehiculo != null) {
                robo = vehiculo.isRobo();
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return robo;*/
    }

    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(PORT);
            CarabineroServer obj = new CarabineroServer();
            reg.rebind(String.format("//%s:%s/PreguntarPatente", ServerUtils.BASE_HOST, PORT), obj);
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
    
}
