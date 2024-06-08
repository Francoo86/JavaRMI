package clases.ejemplo.rmi_demostracion.Client.Insertions;

import clases.ejemplo.rmi_demostracion.Shared.ChileUtility;
import clases.ejemplo.rmi_demostracion.Shared.SingleSessionFactory;
import clases.ejemplo.rmi_demostracion.models.Permiso;
import clases.ejemplo.rmi_demostracion.models.Persona;
import clases.ejemplo.rmi_demostracion.models.Vehiculo;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class InsertionMenus {
    public static void insertPermisos() {
        System.out.println("Insertando permisos...");
        Scanner scanner = new Scanner(System.in);

        // Crear un nuevo permiso
        Permiso permiso = new Permiso();

        // Permiso contiene los siguientes campos: Patente, Fecha_vencimiento y Estado_permiso(boolean)
        System.out.println("Ingrese la patente:");
        permiso.setPatent(scanner.nextLine().trim());

        System.out.println("Ingrese el año de vencimiento:");
        permiso.setDueDate(scanner.nextLine().trim());

        System.out.println("¿Está el permiso al día? (Y/N):");

        boolean isPermisoValido = scanner.nextLine().trim().equalsIgnoreCase("Y");
        permiso.setIsValido(isPermisoValido);

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
    }

    public static void insertPersons() {
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

    public static void insertVehicles() {
        Scanner scanner = new Scanner(System.in);

        // Crear un nuevo vehículo
        Vehiculo vehiculo = new Vehiculo();

        System.out.println("Ingrese la patente:");
        vehiculo.setPatent(scanner.nextLine());

        System.out.println("Ingrese la marca:");
        vehiculo.setBrand(scanner.nextLine());

        System.out.println("Ingrese el modelo:");
        vehiculo.setModel(scanner.nextLine());

        System.out.println("Ingrese el año:");
        vehiculo.setYear(scanner.nextInt());

        System.out.println("¿Tiene encargo por robo? (Y/N):");
        boolean isRobado = scanner.nextLine().trim().equalsIgnoreCase("Y");

        vehiculo.setRobado(isRobado);

        // Cerrar scanner
        scanner.close();

        // Guardar el vehículo en la base de datos
        Session session = SingleSessionFactory.getCarabineroFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(vehiculo);
            transaction.commit();
            System.out.println("Vehículo guardado exitosamente.");
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
