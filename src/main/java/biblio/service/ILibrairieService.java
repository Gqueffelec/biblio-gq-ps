package biblio.service;

import java.util.List;

public interface ILibrairieService<T> {
	List<T> getAll();

	T getById(int id);

	void update(T o);

	void deleteById(int id);

	void add(T o);
}
