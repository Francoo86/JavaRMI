package clases.ejemplo.rmi_demostracion.Client.ConsultaDatos;


public class CarabineroClient {
    public static void main(String[] args) {
        try {
            ClientMenu carabineroMenu = new ClientMenu();
            carabineroMenu.setShouldClose(true);
            carabineroMenu.carabineroMenu();
        } catch (Exception e) {
            System.err.println("Excepción del cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
