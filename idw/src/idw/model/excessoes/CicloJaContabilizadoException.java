package idw.model.excessoes;

@SuppressWarnings("serial")
public class CicloJaContabilizadoException extends Exception{
	private Long idFolha;
	private Long idPt;
	private String message;
	private String complemento;
	private static final String MSG = "Ciclo ja contabilizado"; 
	
	public CicloJaContabilizadoException(){		
	}
	
	/**
	 * 
	 * @param message mensagem da exce��o
	 * @param idFolha coloca na mensagem o idFolha usado
	 * @param idPt coloca na mensagem o idPt usado
	 * @param complemento texto adicional que complementar� a mensagem 
	 */
	public CicloJaContabilizadoException(String message, Long idFolha, Long idPt, String complemento){
		this.message = message;
		this.idFolha = idFolha;
		this.idPt = idPt;		
		this.complemento = complemento;
	}
	
	public CicloJaContabilizadoException(Long idFolha, Long idPt, String complemento){
		this(CicloJaContabilizadoException.MSG, idFolha, idPt, complemento);
	}
	
	public CicloJaContabilizadoException(Long idFolha, Long idPt){
		this(idFolha, idPt, null);
	}
	
	@Override
	public String getMessage(){
		return message
			+ (complemento != null ? "." + complemento : "")
			+ (idFolha != null && idPt != null ? ".":"") 
			+ (idFolha != null ? " idFolha.CicloJaContado:" + idFolha : "" )
			+ (idPt != null ? " idPt:" + idPt : "" );
	}
	
	
}
