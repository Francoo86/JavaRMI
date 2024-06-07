package clases.ejemplo.rmi_demostracion.Server;

import clases.ejemplo.rmi_demostracion.sessions.PDISession;
import org.hibernate.SessionFactory;

import clases.ejemplo.rmi_demostracion.Interface.PreguntarRUT;

import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PDIServer extends UnicastRemoteObject implements PreguntarRUT {
    private static SessionFactory sessionFactory;

    public PDIServer() throws RemoteException {
        super();
        sessionFactory = PDISession.getSessionFactory();
    }

    @Override
    public boolean consultarArraigo(String rut) throws RemoteException {
        return ServerUtils.verifyArraigo(sessionFactory, rut);
        /*
        boolean arraigo = false;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Persona persona = (Persona) session.createQuery("FROM Persona WHERE rut = :rut")
                    .setParameter("rut", rut)
                    .uniqueResult();
            if (persona != null) {
                arraigo = persona.isArraigo();
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return arraigo;*/
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            PDIServer obj = new PDIServer();
            Naming.rebind("//localhost/PreguntarRUT", obj);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
