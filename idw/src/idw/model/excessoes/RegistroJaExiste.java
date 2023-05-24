package idw.model.excessoes;

@SuppressWarnings("serial")
public class RegistroJaExiste extends Exception {

	public RegistroJaExiste(String message) {
		super(message);
	}

}
