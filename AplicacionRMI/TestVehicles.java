package AplicacionRMI;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import io.github.cdimascio.dotenv.Dotenv;

public class TestVehicles {
    public void testVehicles() {
        System.out.println("Testing vehicles...");
        Dotenv dotenv = Dotenv.load();

        System.out.println(dotenv.get("DB_HOST"));

        // create a connection source to our database mysql
        String dbUrl = "jdbc:mysql://" + dotenv.get("DB_HOST") + "/" + dotenv.get("DB_NAME");
        try (ConnectionSource connectionSource = new JdbcConnectionSource(dbUrl, dotenv.get("DB_USER"), dotenv.get("DB_PASSWORD"))) {
            VehicleDAO vehicleDAO = new VehicleDAO(connectionSource);

            //create 5 vehicles using setters
            Vehicle vehicle1 = new Vehicle();
            vehicle1.setPlate("AB1234");
            vehicle1.setBrand("Toyota");
            vehicle1.setModel("Corolla");
            vehicle1.setColor("Red");
            vehicle1.setYear("2010");
            vehicle1.setOwner("Juan Perez");
            vehicle1.setRut("123456");

            //send to db
            vehicleDAO.create(vehicle1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestVehicles testVehicles = new TestVehicles();
        testVehicles.testVehicles();
    }
}
