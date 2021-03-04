package biblio.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import biblio.model.Livre;

public class LivreController implements IController<Livre> {

	private EntityManager em;

	public LivreController() {
		em = EntityManagerTools.getEntityManager();
	}

	@Override
	public Livre create(Livre o) {
		EntityTransaction transaction = null;
		try {
			transaction = this.em.getTransaction();
			transaction.begin();
			this.em.persist(o);
			System.out.println(o.getId());
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			return o;
		}
		return o;
	}

	@Override
	public boolean remove(int id) {
		EntityTransaction transaction = null;
		try {
			transaction = this.em.getTransaction();
			transaction.begin();
			Livre o = this.em.find(Livre.class, id);
			this.em.remove(o);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Livre o) {
		EntityTransaction transaction = null;
		try {
			transaction = this.em.getTransaction();
			transaction.begin();
			Livre temp = this.em.find(Livre.class, o.getId());
			temp.setDate_edition(o.getDate_edition());
			temp.setId_categorie(o.getId_categorie());
			temp.setLabel(o.getLabel());
			temp.setPrix(o.getPrix());
			temp.setStock(o.getStock());
			temp.setTitre(o.getTitre());
			System.err.println(temp);
			this.em.persist(temp);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			return false;
		}
		return true;
	}

	@Override
	public Livre getById(int id) {
		EntityTransaction transaction = null;
		Livre o = null;
		try {
			transaction = this.em.getTransaction();
			transaction.begin();
			o = this.em.find(Livre.class, id);
			System.out.println(o);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
		return o;
	}

	@Override
	public List<Livre> getAll() {
		EntityTransaction transaction = null;
		List<Livre> liste = null;
		try {
			transaction = this.em.getTransaction();
			transaction.begin();
			CriteriaQuery<Livre> criteria = this.em.getCriteriaBuilder().createQuery(Livre.class);
			criteria.from(Livre.class);
			liste = this.em.createQuery(criteria).getResultList();
			liste.stream().forEach(System.out::println);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		return liste;
	}

}
