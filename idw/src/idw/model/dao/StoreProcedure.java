package idw.model.dao;

import org.hibernate.Query;

public abstract class StoreProcedure  {
	
	public abstract String getName();	
	private final Query q;
	
	protected StoreProcedure(AbstractDAOGenerico dao, Object... objs){
		q = dao.createSQLQueryBaseadoStoreProcedure(getName(), objs.length);
		setParameter(objs);
	}
	
	private void setParameter(Object... objs){
		int i = 0;
		SetParameter setParameter = new SetParameter(q);
		for(Object obj: objs){
			setParameter.set(i, obj);
			i++;
		}
	}
	
	public Query getQuery(){
		return q;
	}

}
