package clases.ejemplo.rmi_demostracion.Client.ConsultaDatos;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import clases.ejemplo.rmi_demostracion.Interface.PreguntarPatente;


public class Cliente_Carabinero {

    private Cliente_Carabinero() {}

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(null);
            PreguntarPatente stub = (PreguntarPatente) registry.lookup("PreguntarPatente");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese la patente que desea consultar:");
            String patente = scanner.nextLine();

            boolean robo = stub.consultarRobo(patente);
            System.out.println("El vehículo con patente " + patente + " tiene encargo por robo: " + robo);

            //cerra scanner
            scanner.close();

        } catch (Exception e) {
            System.err.println("Excepción del cliente: " + e.toString());
            e.printStackTrace();
        }
    }
    
}
