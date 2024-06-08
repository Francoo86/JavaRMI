package clases.ejemplo.rmi_demostracion.Client.IngresoDatos;

import clases.ejemplo.rmi_demostracion.Shared.SingleSessionFactory;
import clases.ejemplo.rmi_demostracion.models.Permiso;
import clases.ejemplo.rmi_demostracion.sessions.MunicipalidadSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class OperadorPermisos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear un nuevo permiso
        Permiso permiso = new Permiso();

        // Permiso contiene los siguientes campos: Patente, Fecha_vencimiento y Estado_permiso(boolean)
        System.out.println("Ingrese la patente:");
        permiso.setPatente(scanner.nextLine());

        System.out.println("Ingrese la fecha de vencimiento:");
        permiso.setFecha_vencimiento(scanner.nextLine());

        System.out.println("¿Está el permiso al día? (true/false):");
        permiso.setValidez(scanner.nextBoolean());

        // Cerrar scanner
        scanner.close();

        // Cerrar scanner
        scanner.close();

        // Guardar el permiso en la base de datos
        Session session = SingleSessionFactory.getMuniFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(permiso);
            transaction.commit();
            System.out.println("Permiso guardado exitosamente.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        // Cerrar Hibernate
        MunicipalidadSession.shutdown();

    }
    
}
