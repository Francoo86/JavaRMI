package clases.ejemplo.rmi_demostracion.Shared;

import clases.ejemplo.rmi_demostracion.Shared.Interfaces.IPatentChecker;
import clases.ejemplo.rmi_demostracion.Shared.Interfaces.IPermissionChecker;
import clases.ejemplo.rmi_demostracion.Shared.Interfaces.IRUTChecker;

public class Constants {
    public static final String SERVER_IP = "localhost";
    //specify the host and stuff.
    public static final int PDI_PORT = 1099;
    public static final int CARABINEROS_PORT = 1100;
    public static final int MUNICIPALIDAD_PORT = 1101;
    //classes used by client.
    public static final String REVISA_PATENTES = IPatentChecker.class.getSimpleName();
    public static final String REVISA_PERMISOS = IPermissionChecker.class.getSimpleName();
    public static final String REVISA_RUT = IRUTChecker.class.getSimpleName();
}
