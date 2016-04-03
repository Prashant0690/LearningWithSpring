package org.pt.learn.hibernate.genericDao;

import java.io.Serializable;
import java.util.List;

import org.pt.learn.hibernate.generic.model.IEntityObject;

public interface IGenericDao<T extends IEntityObject<k>,  k extends Serializable> extends Serializable {
	
	T findOne(final long id);

	List<T> findAll();

	void create(final T entity);

	//T update(final T entity);
	void update(final T entity);
	
	void delete(final T entity);

	void deleteById(final long entityId);

}
