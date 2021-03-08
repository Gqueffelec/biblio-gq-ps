package biblio.utils;

public interface IMapper<T,U> {

	public T convertToDto(U u);
	
	public U convertToEntity(T t);
}
