package clases.ejemplo.rmi_demostracion.Client.IngresoDatos;

import clases.ejemplo.rmi_demostracion.models.Vehiculo;
import clases.ejemplo.rmi_demostracion.sessions.CarabineroSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class OperadorVehiculo {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear un nuevo vehículo
        Vehiculo vehiculo = new Vehiculo();

        System.out.println("Ingrese la patente:");
        vehiculo.setPatente(scanner.nextLine());

        System.out.println("Ingrese la marca:");
        vehiculo.setMarca(scanner.nextLine());

        System.out.println("Ingrese el modelo:");
        vehiculo.setModelo(scanner.nextLine());

        System.out.println("Ingrese el año:");
        vehiculo.setAnio(scanner.nextInt());

        System.out.println("¿Tiene encargo por robo? (true/false):");
        vehiculo.setRobo(scanner.nextBoolean());

        // Cerrar scanner
        scanner.close();

        // Guardar el vehículo en la base de datos
        Session session = CarabineroSession.getSessionFactory().openSession();
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

        // Cerrar Hibernate
        CarabineroSession.shutdown();

    }
}
