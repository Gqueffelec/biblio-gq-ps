package biblio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import biblio.model.User;

public interface IRepositoryUser extends JpaRepository<User, Integer>{

	public User findByName(String name);

}
