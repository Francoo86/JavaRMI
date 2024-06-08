package clases.ejemplo.rmi_demostracion.Server;

import clases.ejemplo.rmi_demostracion.Shared.SingleSessionFactory;
import org.hibernate.SessionFactory;

import clases.ejemplo.rmi_demostracion.Interface.IPermissionChecker;

import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MuniServer extends UnicastRemoteObject implements IPermissionChecker {
    private static SessionFactory sessionFactory;
    private static final int PORT = 1101;

    public MuniServer() throws RemoteException {
        super();
        sessionFactory = SingleSessionFactory.getMuniFactory();
        if(sessionFactory != null) {
            System.out.println("[MuniServer] La fabrica de sesiones se ha creado correctamente.");
        }
    }

    @Override
    public boolean consultarValidez(String patente) throws RemoteException {
        return ServerUtils.verifyPermission(sessionFactory, patente);
        /*
        boolean valido = false;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Permiso permiso = (Permiso) session.createQuery("FROM Permiso WHERE patente = :patente")
                    .setParameter("patente", patente)
                    .uniqueResult();
            if (permiso != null) {
                valido = permiso.isValido();
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return valido;*/
    }

    public static void main(String[] args) throws RemoteException, java.net.MalformedURLException {
        try {
            LocateRegistry.createRegistry(PORT);
            MuniServer obj = new MuniServer();
            Naming.rebind(String.format("//%s:%s/IPermissionChecker", ServerUtils.BASE_HOST, PORT), obj);
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
    
}
