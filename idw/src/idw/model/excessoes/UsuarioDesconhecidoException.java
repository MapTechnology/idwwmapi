package idw.model.excessoes;

@SuppressWarnings("serial")
public class UsuarioDesconhecidoException extends Exception{
	public UsuarioDesconhecidoException(){		
	}
	public UsuarioDesconhecidoException(String message) {
		super(message);
	}
}
