package clases.ejemplo.rmi_demostracion.Shared.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPermissionChecker extends Remote{
    boolean consultarValidez(String rut) throws RemoteException;
}
