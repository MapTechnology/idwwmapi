package idw.model.dao;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Query;

public final class SetParameter {
	private final Query q;
	
	public SetParameter(Query q){
		this.q = q;
	}
	
	public Query set(int position, String val){
		return q.setString(position, val);
	}

	public Query set(int position, BigDecimal val){
		return q.setBigDecimal(position, val);
	}
	
	public Query set(int position, boolean val){
		return q.setBoolean(position, val);
	}
	
	public Query set(int position, Date val){
		return q.setTimestamp(position, val);
	}

	public Query set(int position, byte val){
		return q.setByte(position, val);
	}	
	
	public Query set(int position, Short val){
		return q.setShort(position, val);
	}
	
	public Query set(int position, long val){
		return q.setLong(position, val);
	}

	public Query set(int position, float val){
		return q.setFloat(position, val);
	}	
	
	public Query set(int position, double val){
		return q.setDouble(position, val);
	}
	
	public Query set(int position, Object val){
		return q.setParameter(position, val);
	}
	
	
}
