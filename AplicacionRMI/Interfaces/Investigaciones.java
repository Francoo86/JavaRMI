package AplicacionRMI.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Investigaciones extends Remote {
    String verificarPersona(String rutOPasaporte) throws RemoteException;
}