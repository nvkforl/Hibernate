package com.hibernateDemo;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

//import com.hibernateDemo.Model.User;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			
			Configuration configuration = new Configuration();
			//Type 1 config using properties
			/*
			 * configuration.addAnnotatedClass(User.class); return
			 * configuration.buildSessionFactory(new
			 * StandardServiceRegistryBuilder().build());
			 */
			
			//type 2 using Hibernate.cfg.xml
			configuration.configure();
			return configuration.buildSessionFactory(new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
