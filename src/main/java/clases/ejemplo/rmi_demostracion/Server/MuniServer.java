package clases.ejemplo.rmi_demostracion.Server;

import clases.ejemplo.rmi_demostracion.models.Permiso;
import clases.ejemplo.rmi_demostracion.sessions.MunicipalidadSession;
import clases.ejemplo.rmi_demostracion.sessions.SessionRMI;
import org.hibernate.SessionFactory;

import clases.ejemplo.rmi_demostracion.Interface.PreguntarPermiso;

import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MuniServer extends UnicastRemoteObject implements PreguntarPermiso {
    private static SessionFactory sessionFactory;

    public MuniServer() throws RemoteException {
        super();
        sessionFactory = SessionRMI.getInstance().getSessionFactory("RMI_Municipalidad", Permiso.class);
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

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1101);
            MuniServer obj = new MuniServer();
            Naming.rebind("//localhost/PreguntarPermiso", obj);
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
    
}
