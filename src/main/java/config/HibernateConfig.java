package config;

import entities.Account;
import entities.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfig {

    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public SessionFactory getSessionFactory(){

        if (factory == null){
            try {
                Configuration config = new Configuration();
                // config.configure();
                config.configure("hibernate.cfg.xml");
                config.addResource("named-queries.hbm.xml");

                config.addAnnotatedClass(Customer.class);
                config.addAnnotatedClass(Account.class);

                serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
                factory = config.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return factory;

    }

}