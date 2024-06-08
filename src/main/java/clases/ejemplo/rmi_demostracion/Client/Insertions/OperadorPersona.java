package clases.ejemplo.rmi_demostracion.Client.Insertions;

import clases.ejemplo.rmi_demostracion.Shared.ChileUtility;
import clases.ejemplo.rmi_demostracion.Shared.SingleSessionFactory;
import clases.ejemplo.rmi_demostracion.models.Persona;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class OperadorPersona {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear una nueva persona
        Persona persona = new Persona();

        System.out.println("Ingrese el nombre:");
        persona.setName(scanner.nextLine());

        System.out.println("Ingrese el apellido:");
        persona.setLastName(scanner.nextLine());

        System.out.println("Ingrese el RUT:");

        try{
            int rut = Integer.parseInt(scanner.nextLine());
            //calcula el digito verificador
            String dv = ChileUtility.calculateVerifierDigit(rut);
            // convert dv to char
            char dvChar = dv.charAt(0);

            persona.setRut(Integer.parseInt(scanner.nextLine().trim()));
            persona.setDv(dvChar);
        } catch (NumberFormatException e) {
            System.out.println("El RUT debe ser un número.");
            return;
        }

        System.out.println("Ingrese la nacionalidad:");
        persona.setNationality(scanner.nextLine().trim());

        System.out.println("¿Tiene arraigo nacional? (Y/N):");
        boolean hasArraigo = scanner.nextLine().trim().equalsIgnoreCase("Y");

        persona.setHasArraigo(hasArraigo);

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
    }
}