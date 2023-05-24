package ms.excessao;

@SuppressWarnings("serial")
public class DigestFileException extends Exception {

	public DigestFileException(String pDsDebug) {
		super(pDsDebug);
	}
	
	public DigestFileException(String pDsDebug, Throwable pRootException) {
		super(pDsDebug, pRootException);
	}
}
