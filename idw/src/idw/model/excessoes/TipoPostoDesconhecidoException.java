package idw.model.excessoes;

@SuppressWarnings("serial")
public class TipoPostoDesconhecidoException extends Exception{
	public TipoPostoDesconhecidoException(){		
	}
	public TipoPostoDesconhecidoException(String message) {
		super(message);
	}
}
