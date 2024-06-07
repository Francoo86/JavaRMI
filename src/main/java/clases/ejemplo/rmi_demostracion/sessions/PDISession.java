package clases.ejemplo.rmi_demostracion.sessions;

import clases.ejemplo.rmi_demostracion.models.Persona;

public class PDISession extends BaseSession {
    private static final String DATABASE_NAME = "RMI_PDI";

    static {
        initialize(DATABASE_NAME, Persona.class);
    }
}
