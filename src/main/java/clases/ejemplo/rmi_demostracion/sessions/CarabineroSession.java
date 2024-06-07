// HibernateUtilCarabinero.java
package clases.ejemplo.rmi_demostracion.sessions;

import clases.ejemplo.rmi_demostracion.models.Vehiculo;

public class CarabineroSession extends BaseSession{
    private static final String DATABASE_NAME = "RMI_Carabinero";

    static {
        initialize(DATABASE_NAME, Vehiculo.class);
    }
}
