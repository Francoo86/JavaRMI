package clases.ejemplo.rmi_demostracion.Server;

import clases.ejemplo.rmi_demostracion.sessions.CarabineroSession;
import org.hibernate.SessionFactory;

import clases.ejemplo.rmi_demostracion.Interface.PreguntarPatente;

import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CarabineroServer extends UnicastRemoteObject implements PreguntarPatente {

    private static SessionFactory sessionFactory;

    public CarabineroServer() throws RemoteException {
        super();
        sessionFactory = CarabineroSession.getSessionFactory();
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
            LocateRegistry.createRegistry(1100);
            CarabineroServer obj = new CarabineroServer();
            Naming.rebind("//localhost/PreguntarPatente", obj);
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
    
}
