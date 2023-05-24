package ms.excessao;

@SuppressWarnings("serial")
public class SemComunicacaoICException extends Exception{
	Exception e;
	public SemComunicacaoICException(Exception e){
		this.e = e;
	}
}
