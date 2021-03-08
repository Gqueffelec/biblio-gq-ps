package biblio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import biblio.model.Categorie;

@Repository
public class CategorieDAO implements IDAO<Categorie> {

	private EntityManager em;

	public CategorieDAO() {
		em = EntityManagerTools.getEntityManager();
	}

	@Override
	public Categorie create(Categorie o) {

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
			Categorie o = this.em.find(Categorie.class, id);
			this.em.remove(o);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} 
		return true;
	}

	@Override
	public boolean update(Categorie o) {

		EntityTransaction transaction = null;
		try {
			transaction = this.em.getTransaction();
			transaction.begin();
			Categorie temp = this.em.find(Categorie.class, o.getId());
			temp.setNom(o.getNom());
			temp.setLabel(o.getLabel());
			temp.setInformation_technique(o.getInformation_technique());
			this.em.persist(temp);
			System.out.println(o.getId());
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} 
		return true;
	}

	@Override
	public Categorie getById(int id) {
		EntityTransaction transaction = null;
		Categorie o = null;
		try {
			transaction = this.em.getTransaction();
			transaction.begin();
			o = this.em.find(Categorie.class, id);
			System.out.println(o);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
		return o;
	}

	@Override
	public List<Categorie> getAll() {
		EntityTransaction transaction = null;
		List<Categorie> liste = null;
		try {
			transaction = this.em.getTransaction();
			transaction.begin();
			CriteriaQuery<Categorie> criteria = this.em.getCriteriaBuilder().createQuery(Categorie.class);
			criteria.from(Categorie.class);
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
