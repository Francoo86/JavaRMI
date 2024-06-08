package clases.ejemplo.rmi_demostracion.Client.Insertions;

import clases.ejemplo.rmi_demostracion.Shared.SingleSessionFactory;
import clases.ejemplo.rmi_demostracion.models.Permiso;
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
        permiso.setPatente(scanner.nextLine().trim());

        System.out.println("Ingrese el año de vencimiento:");
        permiso.setFecha_vencimiento(scanner.nextLine().trim());

        System.out.println("¿Está el permiso al día? (Y/N):");

        boolean isPermisoValido = scanner.nextLine().trim().equalsIgnoreCase("Y");
        permiso.setValidez(isPermisoValido);

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

        // Cerrar Hibernate;

    }
    
}
