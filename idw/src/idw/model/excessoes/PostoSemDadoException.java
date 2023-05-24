package idw.model.excessoes;

public class PostoSemDadoException extends AbstractMapException {

	private static final long serialVersionUID = 1L;

	public PostoSemDadoException() {
        super("Posto sem dados!");
    }
	
}
