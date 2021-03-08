package biblio.controller;

import java.util.List;

public interface IController<T> {
	public T create(T o);
	public boolean remove(int id);
	public boolean update(T o);
	public T getById(int id);
	public List<T> getAll();
}
