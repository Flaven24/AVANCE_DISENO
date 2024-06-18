package pe.edu.calificame.dao;

public interface CrudDAO {
	
	public <T> void register(T obj);

	public <T> void update(T obj);

	public <T> void delete(T obj);

}
