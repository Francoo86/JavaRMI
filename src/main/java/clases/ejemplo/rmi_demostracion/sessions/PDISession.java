package clases.ejemplo.rmi_demostracion.sessions;

public class PDISession extends BaseSession {
    private static final String CONFIG_FILE = "hibernatePDI.cfg.xml";

    static {
        initialize(CONFIG_FILE);
    }
}
