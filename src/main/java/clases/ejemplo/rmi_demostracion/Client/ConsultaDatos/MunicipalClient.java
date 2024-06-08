package clases.ejemplo.rmi_demostracion.Client.ConsultaDatos;


public class MunicipalClient {
    
        private MunicipalClient() {}
    
        public static void main(String[] args) {
            try {
                ClientMenu municipalMenu = new ClientMenu();
                municipalMenu.setShouldClose(true);
                municipalMenu.municipalMenu();
            } catch (Exception e) {
                System.err.println("Excepción del cliente: " + e.toString());
                e.printStackTrace();
            }
        }
}
