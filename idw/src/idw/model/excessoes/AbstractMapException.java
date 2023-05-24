package idw.model.excessoes;

public abstract class AbstractMapException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String complemento;

	public AbstractMapException() {
		super();
	}
	public AbstractMapException(Exception e) {
		super(e);
	}
	public AbstractMapException(String complemento) {
		super();
		this.complemento = complemento;
	}
	
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
