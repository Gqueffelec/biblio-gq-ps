package biblio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import biblio.model.User;

@Repository
public class UserDAO implements IDAO<User> {

	private EntityManager em;

	public UserDAO() {
		em = EntityManagerTools.getEntityManager();
	}

	@Override
	public User create(User o) {
		EntityTransaction transaction = null;
		try {
			transaction = this.em.getTransaction();
			transaction.begin();
			this.em.persist(o);
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
			User o = this.em.find(User.class, id);
			this.em.remove(o);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} 
		return true;
	}

	@Override
	public boolean update(User o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getById(int id) {
		EntityTransaction transaction = null;
		User o = null;
		try {
			transaction = this.em.getTransaction();
			transaction.begin();
			o = this.em.find(User.class, id);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
		return o;
	}

	@Override
	public List<User> getAll() {
		EntityTransaction transaction = null;
		List<User> liste = null;
		try {
			transaction = this.em.getTransaction();
			transaction.begin();
			CriteriaQuery<User> criteria = this.em.getCriteriaBuilder().createQuery(User.class);
			criteria.from(User.class);
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
