package idw.model.excessoes;

@SuppressWarnings("serial")
public class SemPlanejamentoException extends Exception{
	public SemPlanejamentoException(){
		
	}
	public SemPlanejamentoException(String msg){
		super(msg);
	}
}
