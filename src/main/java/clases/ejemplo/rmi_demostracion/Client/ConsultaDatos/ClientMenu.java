package clases.ejemplo.rmi_demostracion.Client.ConsultaDatos;

import clases.ejemplo.rmi_demostracion.Interface.PreguntarPatente;
import clases.ejemplo.rmi_demostracion.Interface.PreguntarPermiso;
import clases.ejemplo.rmi_demostracion.Interface.PreguntarRUT;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientMenu {
    private Scanner sc;
    private boolean shouldClose = false;

    public ClientMenu() {
        this.sc = new Scanner(System.in);
    }

    //to make reusable scanners.
    public ClientMenu(Scanner sc) {
        this.sc = sc;
    }

    public void setShouldClose(boolean shouldClose) {
        this.shouldClose = shouldClose;
    }

    private Registry getRegistry() throws RemoteException {
        return LocateRegistry.getRegistry(null);
    }

    private void closeScannerIfNeeded() {
        if (shouldClose) {
            sc.close();
        }
    }

    private String getInput(String message) {
        System.out.println(message);
        return sc.nextLine();
    }

    private void displayResult(String message, boolean result) {
        System.out.println(message + result);
    }

    public void municipalMenu() throws RemoteException, NotBoundException {
        Registry registry = getRegistry();
        PreguntarPermiso stub = (PreguntarPermiso) registry.lookup("PreguntarPermiso");

        String patente = getInput("Ingrese la patente que desea consultar:");
        boolean valido = stub.consultarValidez(patente);
        displayResult("El permiso con patente " + patente + " tiene como estado de validación: ", valido);

        closeScannerIfNeeded();
    }

    public void carabineroMenu() throws RemoteException, NotBoundException {
        Registry registry = getRegistry();
        PreguntarPatente stub = (PreguntarPatente) registry.lookup("PreguntarPatente");

        String patente = getInput("Ingrese la patente que desea consultar:");
        boolean robo = stub.consultarRobo(patente);
        displayResult("El vehículo con patente " + patente + " tiene encargo por robo: ", robo);

        closeScannerIfNeeded();
    }

    public void pdiMenu() throws RemoteException, NotBoundException {
        Registry registry = getRegistry();
        PreguntarRUT stub = (PreguntarRUT) registry.lookup("PreguntarRUT");

        String rut = getInput("Ingrese el RUT que desea consultar:");
        boolean arraigo = stub.consultarArraigo(rut);
        displayResult("La persona con RUT " + rut + " tiene arraigo: ", arraigo);

        closeScannerIfNeeded();
    }
}
