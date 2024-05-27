import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {

    private Cliente() {}

    public static void main(String[] args){

        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registro = LocateRegistry.getRegistry(host);
            Hola stub = (Hola) registro.lookup("Hola");
            String respuesta = stub.diHola();
            System.out.println("respuesta: " + respuesta);
        } catch (Exception e) {
            System.err.println("Exception del cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}