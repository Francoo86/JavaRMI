package AplicacionRMI;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import io.github.cdimascio.dotenv.Dotenv;

public class TestVehicles {
    public void testVehicles() {
        System.out.println("Testing vehicles...");
        Dotenv dotenv = Dotenv.load();

        System.out.println(dotenv.get("DB_HOST"));


        ConnectionSource connectionSource = new JdbcConnectionSource();

    }

    public static void main(String[] args) {
        TestVehicles testVehicles = new TestVehicles();
        testVehicles.testVehicles();
    }
}
