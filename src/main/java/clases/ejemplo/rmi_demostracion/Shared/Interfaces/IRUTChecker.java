package clases.ejemplo.rmi_demostracion.Shared.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRUTChecker extends Remote {
    boolean consultarArraigo(String rut) throws RemoteException;
}
