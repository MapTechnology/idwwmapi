package idw.model.excessoes;

@SuppressWarnings("serial")
public class TurnoDesconhecidoException extends RegistroDesconhecidoException {
	public TurnoDesconhecidoException(String msg){
		super(msg);
	}
}
