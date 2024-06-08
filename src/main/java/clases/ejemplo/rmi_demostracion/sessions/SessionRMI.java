package clases.ejemplo.rmi_demostracion.sessions;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.HashMap;
import java.util.Map;

public class SessionRMI {
    private static SessionRMI instance;
    private static final Map<String, Map<Class<?>, SessionFactory>> sessionFactoryMap = new HashMap<>();

    private SessionRMI() {}

    public static synchronized SessionRMI getInstance() {
        if (instance == null) {
            instance = new SessionRMI();
        }
        return instance;
    }

    public SessionFactory getSessionFactory(String dbName, Class<?> entityClass) {
        return sessionFactoryMap.computeIfAbsent(dbName, key -> new HashMap<>())
                .computeIfAbsent(entityClass, key -> buildSessionFactory(dbName, entityClass));
    }

    private SessionFactory buildSessionFactory(String dbName, Class<?> entityClass) {
        try {
            Configuration configuration = getConfiguration(dbName);
            configuration.addAnnotatedClass(entityClass);
            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed for database " + dbName + ", entity " + entityClass.getName() + "." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private Configuration getConfiguration(String dbName) {
        Configuration configuration = new Configuration();
        Dotenv dotenv = Dotenv.load();

        String dbHost = dotenv.get("DB_HOST");
        String dbUser = dotenv.get("DB_USER");
        String dbPassword = dotenv.get("DB_PASSWORD");

        // Set Hibernate properties programmatically
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", String.format("jdbc:mysql://%s:3306/%s", dbHost, dbName));
        configuration.setProperty("hibernate.connection.username", dbUser);
        configuration.setProperty("hibernate.connection.password", dbPassword);
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.format_sql", "true");
        return configuration;
    }

    // Optional: Add method to close the session factory when it's no longer needed
    public void closeSessionFactory(String dbName, Class<?> entityClass) {
        SessionFactory sessionFactory = sessionFactoryMap.get(dbName).get(entityClass);
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
