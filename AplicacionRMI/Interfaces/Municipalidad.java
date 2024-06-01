package AplicacionRMI.Interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Municipalidad extends Remote {
    String verificarPermisoCirculacion(String placa) throws RemoteException;
}