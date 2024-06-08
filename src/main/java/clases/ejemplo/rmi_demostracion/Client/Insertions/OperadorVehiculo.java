package clases.ejemplo.rmi_demostracion.Client.Insertions;

import clases.ejemplo.rmi_demostracion.Shared.SingleSessionFactory;
import clases.ejemplo.rmi_demostracion.models.Vehiculo;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class OperadorVehiculo {

    public static void main(String[] args) {
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
