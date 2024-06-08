package clases.ejemplo.rmi_demostracion.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPatentChecker extends Remote{
    boolean consultarRobo(String patente) throws RemoteException;
}
