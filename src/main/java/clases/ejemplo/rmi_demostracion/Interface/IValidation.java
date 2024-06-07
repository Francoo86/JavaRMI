package clases.ejemplo.rmi_demostracion.Interface;

import java.rmi.Remote;

public interface IValidation<T> extends Remote {
    boolean consultData(T input) throws Exception;
}
