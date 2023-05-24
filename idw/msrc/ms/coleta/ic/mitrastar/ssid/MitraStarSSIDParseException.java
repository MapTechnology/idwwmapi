package ms.coleta.ic.mitrastar.ssid;

public class MitraStarSSIDParseException extends Exception {

	private static final String MESSAGE = "Parse do MitraStarSSID falhou. ";
	private static final long serialVersionUID = 1L;

	public MitraStarSSIDParseException(String aux) {
		super(MESSAGE + aux);
	}

	public MitraStarSSIDParseException(String aux, Throwable e) {
		super(MESSAGE + aux, e);
	}

}
