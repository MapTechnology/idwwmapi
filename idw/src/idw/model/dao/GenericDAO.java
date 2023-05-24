package idw.model.dao;

import java.util.List;

public interface GenericDAO<T> {
	public T save(T entity);
	public void delete(T entity);
	public List<T> listAll();
	public T findById(Long id);	
}
