package clases.ejemplo.rmi_demostracion.Client.ConsultaDatos;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import clases.ejemplo.rmi_demostracion.Interface.PreguntarPermiso;


public class Cliente_Municipal {
    
        private Cliente_Municipal() {}
    
        public static void main(String[] args) {
            try {
                Registry registry = LocateRegistry.getRegistry(null);
                PreguntarPermiso stub = (PreguntarPermiso) registry.lookup("PreguntarPermiso");
    
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingrese la patente que desea consultar:");
                String patente = scanner.nextLine();
    
                boolean valido = stub.consultarValidez(patente);
                System.out.println("El permiso con patente " + patente + " tiene como estado de validación: " + valido);
    
                //cerra scanner
                scanner.close();
    
            } catch (Exception e) {
                System.err.println("Excepción del cliente: " + e.toString());
                e.printStackTrace();
            }
        }
}
