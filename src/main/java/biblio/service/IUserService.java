package biblio.service;

public interface IUserService<T> {
	public T login(T o);
	public void save(T o);
}
