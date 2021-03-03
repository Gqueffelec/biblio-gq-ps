package biblio.controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateController {

	static Configuration configuration;
	static SessionFactory sessionFactory;
	
	 public static void start() {
			configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
	 }
	 
	 public static SessionFactory getSessionFactory() {
		 return sessionFactory;
	 }
	 
	 
	 public static void close() {
		 sessionFactory.close();
	 }
}
