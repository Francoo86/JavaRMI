package clases.ejemplo.rmi_demostracion.Client.Reader;


public class MunicipalClient {
    
        private MunicipalClient() {}
    
        public static void main(String[] args) {
            try {
                ClientMenu municipalMenu = new ClientMenu();
                municipalMenu.setShouldClose(true);
                municipalMenu.municipalMenu();
            } catch (Exception e) {
                System.err.println("Exception: " + e.toString());
                e.printStackTrace();
            }
        }
}
