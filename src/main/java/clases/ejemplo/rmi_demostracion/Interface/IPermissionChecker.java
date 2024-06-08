package clases.ejemplo.rmi_demostracion.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPermissionChecker extends Remote{
    boolean consultarValidez(String rut) throws RemoteException;
}
