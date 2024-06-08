package clases.ejemplo.rmi_demostracion.Shared;

import clases.ejemplo.rmi_demostracion.Entity.Permiso;
import clases.ejemplo.rmi_demostracion.Entity.Persona;
import clases.ejemplo.rmi_demostracion.Entity.Vehiculo;
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
