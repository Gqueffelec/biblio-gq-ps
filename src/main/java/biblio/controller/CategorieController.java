package biblio.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import biblio.model.Categorie;

public class CategorieController implements IController<Categorie> {

	private SessionFactory sessionFactory;

	public CategorieController() {
		sessionFactory = HibernateController.getSessionFactory();
	}

	@Override
	public Categorie create(Categorie o) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(o);
			System.out.println(o.getId());
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			return o;
		} finally {
			session.close();
		}
		return o;
	}

	@Override
	public boolean remove(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Categorie o = session.get(Categorie.class, id);
			session.delete(o);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public boolean update(Categorie o) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Categorie temp = session.get(Categorie.class, o.getId());
			temp.setNom(o.getNom());
			temp.setLabel(o.getLabel());
			temp.setInformation_technique(o.getInformation_technique());
			session.persist(temp);
			System.out.println(o.getId());
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public Categorie getById(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Categorie o = null;
		try {
			transaction = session.beginTransaction();
			o = session.get(Categorie.class, id);
			System.out.println(o);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return o;
	}

	@Override
	public List<Categorie> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
