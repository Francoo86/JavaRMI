package clases.ejemplo.rmi_demostracion.Client.Reader;

public class PDIClient {

    private PDIClient() {}

    public static void main(String[] args) {
        try {
            ClientMenu pdiMenu = new ClientMenu();
            pdiMenu.setShouldClose(true);
            pdiMenu.pdiMenu();

        } catch (Exception e) {
            System.err.println("Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}