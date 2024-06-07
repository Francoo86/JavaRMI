package clases.ejemplo.rmi_demostracion.Client.ConsultaDatos;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import clases.ejemplo.rmi_demostracion.Interface.PreguntarRUT;

public class Cliente_PDI {

    private Cliente_PDI() {}

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(null);
            PreguntarRUT stub = (PreguntarRUT) registry.lookup("PreguntarRUT");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el RUT que desea consultar:");
            String rut = scanner.nextLine();

            boolean arraigo = stub.consultarArraigo(rut);
            System.out.println("La persona con RUT " + rut + " tiene arraigo: " + arraigo);

            //cerra scanner
            scanner.close();

        } catch (Exception e) {
            System.err.println("Excepción del cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}