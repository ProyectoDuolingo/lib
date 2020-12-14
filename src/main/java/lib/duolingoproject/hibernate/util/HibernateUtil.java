package lib.duolingoproject.hibernate.util;

import lib.duolingoproject.hibernate.model.*;
import lib.duolingoproject.hibernate.model.Level.LevelId;
import lib.duolingoproject.hibernate.model.association.*;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/test2?serverTimezone=UTC");
                settings.put(Environment.USER, "adminDuolingo");
                settings.put(Environment.PASS, "P@ssw0rd");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);
                
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Language.class);
                configuration.addAnnotatedClass(Course.class);
                configuration.addAnnotatedClass(Category.class);
                configuration.addAnnotatedClass(Level.class);
                configuration.addAnnotatedClass(LevelId.class);
                configuration.addAnnotatedClass(ExerciseType.class);
                configuration.addAnnotatedClass(Exercise.class);
                configuration.addAnnotatedClass(Division.class);
                configuration.addAnnotatedClass(League.class);
                configuration.addAnnotatedClass(ShopItem.class);
                
                configuration.addAnnotatedClass(UserCourse.class);
                configuration.addAnnotatedClass(UserShop.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
