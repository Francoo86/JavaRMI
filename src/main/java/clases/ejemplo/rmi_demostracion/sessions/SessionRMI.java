package clases.ejemplo.rmi_demostracion.sessions;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.HashMap;
import java.util.Map;

public class SessionRMI {
    private static SessionRMI instance;
    private static final Map<String, SessionFactory> sessionFactoryMap = new HashMap<>();

    private SessionRMI() {}

    public static synchronized SessionRMI getInstance() {
        if (instance == null) {
            instance = new SessionRMI();
        }
        return instance;
    }

    public SessionFactory getSessionFactory(String dbName, Class<?>... entityClasses) {
        return sessionFactoryMap.computeIfAbsent(dbName, key -> buildSessionFactory(dbName, entityClasses));
    }

    private SessionFactory buildSessionFactory(String dbName, Class<?>... entityClasses) {
        try {
            Configuration configuration = getConfiguration(dbName);
            for (Class<?> entityClass : entityClasses) {
                configuration.addAnnotatedClass(entityClass);
            }
            return configuration.configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed for database " + dbName + "." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private Configuration getConfiguration(String dbName) {
        Configuration configuration = new Configuration();
        Dotenv dotenv = Dotenv.load();

        String dbHost = dotenv.get("DB_HOST");
        String dbUser = dotenv.get("DB_USER");
        String dbPassword = dotenv.get("DB_PASSWORD");

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

    public void closeSessionFactory(String dbName) {
        SessionFactory sessionFactory = sessionFactoryMap.get(dbName);
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
