package clases.ejemplo.rmi_demostracion.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PreguntarRUT extends Remote {
    boolean consultarArraigo(String rut) throws RemoteException;
}
