package clases.ejemplo.rmi_demostracion.Client.ConsultaDatos;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import clases.ejemplo.rmi_demostracion.Interface.PreguntarPatente;
import clases.ejemplo.rmi_demostracion.Interface.PreguntarRUT;
import clases.ejemplo.rmi_demostracion.Interface.PreguntarPermiso;

public class Cliente_General {

    private Cliente_General() {}

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("¿Qué servicio requiere?");
            System.out.println("1- Conocer si el ciudadano tiene arraigo nacional");
            System.out.println("2- Conocer si el automóvil es robado");
            System.out.println("3- Conocer si el vehículo tiene su permiso de conducir al día");
            System.out.println("Ingrese el número de la opción que desea:");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (opcion) {
                case 1: {
                    Registry registry = LocateRegistry.getRegistry(null);
                    PreguntarRUT stub = (PreguntarRUT) registry.lookup("PreguntarRUT");
                    System.out.println("Ingrese el RUT que desea consultar:");
                    String rut = scanner.nextLine();
                    boolean arraigo = stub.consultarArraigo(rut);
                    System.out.println("La persona con RUT " + rut + " tiene arraigo: " + arraigo);
                    break;
                }
                case 2: {
                    Registry registry = LocateRegistry.getRegistry(null);
                    PreguntarPatente stub = (PreguntarPatente) registry.lookup("PreguntarPatente");
                    System.out.println("Ingrese la patente que desea consultar:");
                    String patente = scanner.nextLine();
                    boolean robo = stub.consultarRobo(patente);
                    System.out.println("El vehículo con patente " + patente + " tiene encargo por robo: " + robo);
                    break;
                }
                case 3: {
                    Registry registry = LocateRegistry.getRegistry(null);
                    PreguntarPermiso stub = (PreguntarPermiso) registry.lookup("PreguntarPermiso");
                    System.out.println("Ingrese la patente que desea consultar:");
                    String patente = scanner.nextLine();
                    boolean valido = stub.consultarValidez(patente);
                    System.out.println("El permiso con patente " + patente + " tiene como estado de validación: " + valido);
                    break;
                }
                default:
                    System.out.println("Opción no válida.");
            }

            // Cierra scanner
            scanner.close();

        } catch (Exception e) {
            System.err.println("Excepción del cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
