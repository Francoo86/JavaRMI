// HibernateUtil.java
package clases.ejemplo.rmi_demostracion.sessions;

import io.github.cdimascio.dotenv.Dotenv;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public abstract class BaseSession {
    private static SessionFactory sessionFactory;

    protected static void initialize(String dbName, Class<?>... annotatedClasses) {
        try {
            Configuration configuration = getConfiguration(dbName);

            // Add annotated classes
            for (Class<?> annotatedClass : annotatedClasses) {
                configuration.addAnnotatedClass(annotatedClass);
            }

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static Configuration getConfiguration(String dbName) {
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

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}

/*
public abstract class BaseSession {
    private static SessionFactory sessionFactory;

    protected static void initialize(String configFile) {
        try {
            sessionFactory = new Configuration().configure(configFile).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}*/
