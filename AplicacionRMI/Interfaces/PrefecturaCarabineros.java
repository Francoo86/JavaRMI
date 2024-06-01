package AplicacionRMI.Interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PrefecturaCarabineros extends Remote {
    String verificarVehiculoRobado(String placa) throws RemoteException;
}
