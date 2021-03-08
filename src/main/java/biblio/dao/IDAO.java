package biblio.dao;

import java.util.List;

public interface IDAO<T> {
	public T create(T o);
	public boolean remove(int id);
	public boolean update(T o);
	public T getById(int id);
	public List<T> getAll();
}
