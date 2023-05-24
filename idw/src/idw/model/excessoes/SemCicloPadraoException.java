package idw.model.excessoes;

@SuppressWarnings("serial")
public class SemCicloPadraoException extends Exception{
	private Long idFolha;
	private Long idPt;
	private String message;
	private String complemento;
	private static final String MSG = "Sem ciclo padrao"; 
	
	public SemCicloPadraoException(){		
	}
	
	/**
	 * 
	 * @param message mensagem da exce��o
	 * @param idFolha coloca na mensagem o idFolha usado
	 * @param idPt coloca na mensagem o idPt usado
	 * @param complemento texto adicional que complementar� a mensagem 
	 */
	public SemCicloPadraoException(String message, Long idFolha, Long idPt, String complemento){
		this.message = message;
		this.idFolha = idFolha;
		this.idPt = idPt;		
		this.complemento = complemento;
	}
	
	public SemCicloPadraoException(Long idFolha, Long idPt, String complemento){
		this(SemCicloPadraoException.MSG, idFolha, idPt, complemento);
	}
	
	public SemCicloPadraoException(Long idFolha, Long idPt){
		this(idFolha, idPt, null);
	}
	
	@Override
	public String getMessage(){
		return message
			+ (complemento != null ? "." + complemento : "")
			+ (idFolha != null && idPt != null ? ".":"") 
			+ (idFolha != null ? " idFolha.SemCicloPadrao:" + idFolha : "" )
			+ (idPt != null ? " idPt:" + idPt : "" );
	}
	
	
}
