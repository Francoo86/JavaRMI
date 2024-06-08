package clases.ejemplo.rmi_demostracion.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRUTChecker extends Remote {
    boolean consultarArraigo(String rut) throws RemoteException;
}
