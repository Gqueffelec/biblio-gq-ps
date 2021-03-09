package biblio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import biblio.model.Categorie;

public interface IRepositoryCategorie extends JpaRepository<Categorie, Integer>{
}
