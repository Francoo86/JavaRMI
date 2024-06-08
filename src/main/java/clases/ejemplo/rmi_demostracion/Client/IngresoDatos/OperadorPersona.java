package clases.ejemplo.rmi_demostracion.Client.IngresoDatos;

import clases.ejemplo.rmi_demostracion.Shared.SingleSessionFactory;
import clases.ejemplo.rmi_demostracion.models.Persona;
import clases.ejemplo.rmi_demostracion.sessions.PDISession;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class OperadorPersona {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear una nueva persona
        Persona persona = new Persona();

        System.out.println("Ingrese el nombre:");
        persona.setNombre(scanner.nextLine());

        System.out.println("Ingrese el apellido:");
        persona.setApellido(scanner.nextLine());

        System.out.println("Ingrese el RUT:");
        persona.setRut(scanner.nextLine());

        System.out.println("Ingrese la nacionalidad:");
        persona.setNacionalidad(scanner.nextLine());

        System.out.println("¿Tiene arraigo nacional? (true/false):");
        persona.setArraigo(scanner.nextBoolean());

        // Cerrar scanner
        scanner.close();

        // Guardar la persona en la base de datos
        Session session = SingleSessionFactory.getPDIFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(persona);
            transaction.commit();
            System.out.println("Persona guardada exitosamente.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        // Cerrar Hibernate
        PDISession.shutdown();
    }
}