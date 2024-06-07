// HibernateUtilCarabinero.java
package clases.ejemplo.rmi_demostracion.sessions;

public class CarabineroSession extends BaseSession{
    private static final String CONFIG_FILE = "hibernateCarabinero.cfg.xml";

    static {
        initialize(CONFIG_FILE);
    }
}
