package idw.model.excessoes;

@SuppressWarnings("serial")
public class ReferenciaCircularPaiComFilho extends Exception {
	private String galho;
	
	
	public ReferenciaCircularPaiComFilho(String galho){
		this.galho = galho;
	}
	
	
	@Override
	public String getMessage() {
		return "Referencia circular " + this.galho + "descendente tem ele mesmo como descendente. /n";
	}
	
}
