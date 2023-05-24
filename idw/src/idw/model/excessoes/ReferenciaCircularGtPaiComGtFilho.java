package idw.model.excessoes;

@SuppressWarnings("serial")
public class ReferenciaCircularGtPaiComGtFilho extends Exception {
	private String galho;
	
	
	public ReferenciaCircularGtPaiComGtFilho(String galho){
		this.galho = galho;
	}
	
	
	@Override
	public String getMessage() {
		return "Referencia circular Gt descendente tem ele mesmo como descendente. /n" + this.galho;
	}
	
}
