package clases.ejemplo.rmi_demostracion.Client.Reader;

import clases.ejemplo.rmi_demostracion.Shared.Constants;
import clases.ejemplo.rmi_demostracion.Shared.Interfaces.IPatentChecker;
import clases.ejemplo.rmi_demostracion.Shared.Interfaces.IPermissionChecker;
import clases.ejemplo.rmi_demostracion.Shared.Interfaces.IRUTChecker;

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
        Registry registry = LocateRegistry.getRegistry(Constants.SERVER_IP, Constants.MUNICIPALIDAD_PORT);
        IPermissionChecker stub = (IPermissionChecker) registry.lookup(Constants.REVISA_PERMISOS);

        String patente = getInput("Ingrese la patente que desea consultar:");
        boolean valido = stub.consultarValidez(patente);
        displayResult("El permiso con patente " + patente + " tiene como estado de validación: ", valido);

        closeScannerIfNeeded();
    }

    public void carabineroMenu() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(Constants.SERVER_IP, Constants.CARABINEROS_PORT);
        IPatentChecker stub = (IPatentChecker) registry.lookup(Constants.REVISA_PATENTES);

        String patente = getInput("Ingrese la patente que desea consultar:");
        boolean robo = stub.consultarRobo(patente);
        displayResult("El vehículo con patente " + patente + " tiene encargo por robo: ", robo);

        closeScannerIfNeeded();
    }

    public void pdiMenu() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(Constants.SERVER_IP, Constants.PDI_PORT);
        IRUTChecker stub = (IRUTChecker) registry.lookup(Constants.REVISA_RUT);

        String rut = getInput("Ingrese el RUT que desea consultar:");
        boolean arraigo = stub.consultarArraigo(rut);
        displayResult("La persona con RUT " + rut + " tiene arraigo: ", arraigo);

        closeScannerIfNeeded();
    }
}
