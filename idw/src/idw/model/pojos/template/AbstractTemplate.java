package idw.model.pojos.template;

public abstract class AbstractTemplate<T> implements Cloneable {
	
	/**
	 * Instancia do tipo {@code T}
	 * 
	 */
	private T instanceT;
	
	protected abstract T atribuir(T from, T to, boolean isCopiarFK);

	@Override
	public T clone() {
		return this.clone(true);
	}

	@SuppressWarnings("unchecked")
	public T clone(boolean isCopiarFK){
		T item = (T) this;
		T clone = null;
		clone = this.atribuir(item, clone, isCopiarFK);
		return clone;
	}
	
	/**
	 * Pega a objeto no tipo relacionado a {@code T}
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected T getInstanceT(){
		if(instanceT == null){
			instanceT = (T) this; 
		}
		return (T) this;
	}
	
	public void copy(T omFrom, T omTo, boolean isCopiarFK){
		this.atribuir(omFrom, omTo , isCopiarFK);
	}
	@SuppressWarnings("unchecked")
	public void copy(T omFrom, boolean isCopiarFK){
		this.atribuir(omFrom, (T) this, isCopiarFK);
	}
}
