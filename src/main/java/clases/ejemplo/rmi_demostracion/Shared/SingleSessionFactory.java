package clases.ejemplo.rmi_demostracion.Shared;

import clases.ejemplo.rmi_demostracion.models.Permiso;
import clases.ejemplo.rmi_demostracion.models.Persona;
import clases.ejemplo.rmi_demostracion.models.Vehiculo;
import clases.ejemplo.rmi_demostracion.sessions.SessionRMI;
import org.hibernate.SessionFactory;

public class SingleSessionFactory {
    public static SessionFactory getCarabineroFactory() {
        return SessionRMI.getInstance().getSessionFactory("RMI_Carabineros", Vehiculo.class);
    }

    public static SessionFactory getPDIFactory() {
        return SessionRMI.getInstance().getSessionFactory("RMI_PDI", Persona.class);
    }

    public static SessionFactory getMuniFactory(){
        return SessionRMI.getInstance().getSessionFactory("RMI_Municipalidad", Permiso.class);
    }


}