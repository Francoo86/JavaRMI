package clases.ejemplo.rmi_demostracion.Client.ConsultaDatos;

public class PDIClient {

    private PDIClient() {}

    public static void main(String[] args) {
        try {
            ClientMenu pdiMenu = new ClientMenu();
            pdiMenu.setShouldClose(true);
            pdiMenu.pdiMenu();

        } catch (Exception e) {
            System.err.println("Excepción del cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}