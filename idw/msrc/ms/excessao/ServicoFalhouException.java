package ms.excessao;

@SuppressWarnings("serial")
public class ServicoFalhouException extends Exception{
	Exception e;	
	public ServicoFalhouException(Exception e){
		this.e = e;
	}
}
