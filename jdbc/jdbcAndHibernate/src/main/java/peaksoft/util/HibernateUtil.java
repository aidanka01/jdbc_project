package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import peaksoft.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class HibernateUtil {
    private static final String url = "jdbc:postgresql://localhost:5432/database_hibernate";
    private static final String user = "postgres";
    private static final String password = "123456";

    public static Connection connection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    private static SessionFactory buildSessionFactory() {
        Properties prop = new Properties();

        prop.setProperty("connection.driver_class", "org.postgresql.Driver");
        prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/database_hibernate");
        prop.setProperty("hibernate.connection.username", "postgres");
        prop.setProperty("hibernate.connection.password", "123456");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        prop.setProperty("hibernate.show_sql", "true");
        prop.setProperty("hibernate.hbm2ddl.auto", "update");
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(peaksoft.model.User.class);
        cfg.setProperties(prop);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties()).build();
        System.out.println("Successfully connected to Hibernate!");
        return cfg.buildSessionFactory(serviceRegistry);
    }
    public static SessionFactory getSession() {
        return buildSessionFactory();
    }
    public static void shutDown() {
        getSession().close();
    }

}
