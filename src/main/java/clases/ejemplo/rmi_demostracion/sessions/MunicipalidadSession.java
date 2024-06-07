// HibernateUtilMunicipalidad.java
package clases.ejemplo.rmi_demostracion.sessions;

import clases.ejemplo.rmi_demostracion.models.Permiso;

public class MunicipalidadSession extends BaseSession{
    private static final String DATABASE_NAME = "RMI_Municipalidad";

    static {
        initialize(DATABASE_NAME, Permiso.class);
    }
}
