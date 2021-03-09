package biblio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import biblio.model.Livre;

public interface IRepositoryLivre extends JpaRepository<Livre, Integer> {
}
