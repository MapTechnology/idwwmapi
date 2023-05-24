package ms.model;


public abstract class APojoMs<T> implements Cloneable {

	protected abstract T atribuir(T from, T to, boolean isCopiarFK);
		
	@Override
	public T clone() {
		return clone(true);
	}
	
	
	public T clone(boolean isCopiarFK){
		@SuppressWarnings("unchecked")
		T item = (T) this;
		T clone = null;
		clone = atribuir(item, clone, isCopiarFK);
		return clone;
	}
	
	public void copy(T omFrom, T omTo, boolean isCopiarFK){
		atribuir(omFrom, omTo , isCopiarFK);
	}

	
	@SuppressWarnings("unchecked")
	public void copy(T omFrom, boolean isCopiarFK){
		atribuir(omFrom, (T) this, isCopiarFK);
	}
}
