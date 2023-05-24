package idw.builders;

import idw.model.dao.AbstractDAOGenerico;

public abstract class AbstractPojoPersistentBuilder<T, D extends AbstractDAOGenerico> extends AbstractBuilder<T>{
	
	public  T buildAndPersist(D dao){	
		T obj = build();
		return dao.makePersistent(obj);
	}

}
