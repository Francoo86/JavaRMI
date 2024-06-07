// HibernateUtilMunicipalidad.java
package clases.ejemplo.rmi_demostracion.sessions;

public class MunicipalidadSession extends BaseSession{
    private static final String CONFIG_FILE = "hibernateMunicipalidad.cfg.xml";

    static {
        initialize(CONFIG_FILE);
    }
}
