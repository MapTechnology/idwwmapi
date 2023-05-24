package idw.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


public class GenericHibernateDAO<T> implements GenericDAO<T>{
	private final Session session;
	private final Class<T> persistentClass;
	public GenericHibernateDAO(Session session, Class<T> persistentClass){
		this.session = session;
		this.persistentClass = persistentClass;
	}
	
	public Class<T> getPersistentClass(){
		return persistentClass;
	}

	public Session getSession() {
		return this.session;
	}
	
	@Override
	public T save(T entity) {
		session.saveOrUpdate(entity);
		return entity;
	}

	@Override
	public void delete(T entity) {
		session.delete(entity);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll() {		
		Query q = session.createQuery("FROM " + persistentClass.getName());
    	return q.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Long id) {
		return (T) session.load(persistentClass, id);
	}
	
	
}
