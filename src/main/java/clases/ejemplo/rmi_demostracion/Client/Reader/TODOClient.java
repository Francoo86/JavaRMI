package clases.ejemplo.rmi_demostracion.Client.Reader;

import java.util.Scanner;

public class TODOClient {
    public static void main(String[] args) {
        try {
            System.out.println("======= CONSULTA DE DATOS =======");
            System.out.println("1- Saber si un ciudadano tiene arraigo nacional (para saber si puede salir del país)");
            System.out.println("2- Saber si un vehiculo fue robado");
            System.out.println("3- Saber si el vehículo tiene su permiso de conducir actualizado");
            System.out.println("=================================");
            System.out.println("Opción a solicitar:");

            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            //bypass the \n character
            scanner.nextLine();

            ClientMenu clientMenu = new ClientMenu(scanner);
            clientMenu.setShouldClose(false);

            switch (opcion) {
                case 1: {
                    clientMenu.pdiMenu();
                    break;
                }
                case 2: {
                    clientMenu.carabineroMenu();
                    break;
                }
                case 3: {
                    clientMenu.municipalMenu();
                    break;
                }
                default:
                    System.out.println("Opción no válida.");
            }

            // Cierra scanner
            scanner.close();

        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
