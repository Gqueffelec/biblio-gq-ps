package biblio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import biblio.model.Categorie;

public interface IRepository extends JpaRepository<Categorie, Integer>{
	
	@SuppressWarnings("unchecked")
	public Categorie save(Categorie o);
	public boolean deleteById(int id);
	public Categorie findById(int id);
	public List<Categorie> findAll();
}
