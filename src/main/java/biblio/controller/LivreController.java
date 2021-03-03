package biblio.controller;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import biblio.model.Livre;

public class LivreController implements IController<Livre> {

	private SessionFactory sessionFactory;

	public LivreController() {
		sessionFactory = HibernateController.getSessionFactory();
	}

	@Override
	public Livre create(Livre o) {
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
			Livre o = session.get(Livre.class, id);
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
	public boolean update(Livre o) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Livre temp = session.get(Livre.class, o.getId());
			temp.setDate_edition(o.getDate_edition());
			temp.setId_categorie(o.getId_categorie());
			temp.setLabel(o.getLabel());
			temp.setPrix(o.getPrix());
			temp.setStock(o.getStock());
			temp.setTitre(o.getTitre());
			System.err.println(temp);
			session.persist(temp);
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
	public Livre getById(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Livre o = null;
		try {
			transaction = session.beginTransaction();
			o = session.get(Livre.class, id);
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
	public List<Livre> getAll() {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<Livre> liste = null;
		try {
			transaction = session.beginTransaction();
			CriteriaQuery<Livre> criteria = session.getCriteriaBuilder().createQuery(Livre.class);
			criteria.from(Livre.class);
			liste = session.createQuery(criteria).getResultList();
			liste.stream().forEach(System.out::println);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		return liste;
	}

}
