package clases.ejemplo.rmi_demostracion.Server;

import clases.ejemplo.rmi_demostracion.models.Persona;
import clases.ejemplo.rmi_demostracion.models.Permiso;
import clases.ejemplo.rmi_demostracion.models.Vehiculo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.function.Function;

public class ServerUtils {
    public static final String BASE_HOST = "127.0.0.1";
    private static <T> T executeTransaction(SessionFactory sessionFactory, Function<Session, T> action) {
        T result = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            result = action.apply(session);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static boolean verifyArraigo(SessionFactory sessionFactory, String rut) {
        return executeTransaction(sessionFactory, session -> {
            Persona persona = (Persona) session.createQuery("FROM Persona WHERE rut = :rut")
                    .setParameter("rut", rut)
                    .uniqueResult();
            return persona != null && persona.hasArraigo();
        });
    }

    public static boolean verifyVehicle(SessionFactory sessionFactory, String patente) {
        return executeTransaction(sessionFactory, session -> {
            Vehiculo vehiculo = (Vehiculo) session.createQuery("FROM Vehiculo WHERE patente = :patente")
                    .setParameter("patente", patente)
                    .uniqueResult();
            return vehiculo != null && vehiculo.isRobado();
        });
    }

    public static boolean verifyPermission(SessionFactory sessionFactory, String patente) {
        return executeTransaction(sessionFactory, session -> {
            Permiso permiso = (Permiso) session.createQuery("FROM Permiso WHERE patente = :patente")
                    .setParameter("patente", patente)
                    .uniqueResult();
            return permiso != null && permiso.isValido();
        });
    }
}
