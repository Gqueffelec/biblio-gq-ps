package biblio.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import biblio.model.Categorie;

public class CategorieController {
	public static void main(String[] args) {
		Categorie categorie = new Categorie();
		categorie.setNom("Roman");
		categorie.setLabel("ROM");
		categorie.setInformation_technique("aucune");
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Categorie categorie1 = session.load(Categorie.class, 1);
		categorie1.setInformation_technique("aucune");
		session.flush();
		// session.persist(categorie);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
