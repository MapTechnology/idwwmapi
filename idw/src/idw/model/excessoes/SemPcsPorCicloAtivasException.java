package idw.model.excessoes;

@SuppressWarnings("serial")
public class SemPcsPorCicloAtivasException extends Exception{
	private Long idFolha;
	private Long idPt;
	private String message;
	private String complemento;
	private static final String MSG = "Sem pecas por ciclo ativas"; 
	
	public SemPcsPorCicloAtivasException(){		
	}
	
	/**
	 * 
	 * @param message mensagem da exce��o
	 * @param idFolha coloca na mensagem o idFolha usado
	 * @param idPt coloca na mensagem o idPt usado
	 * @param complemento texto adicional que complementar� a mensagem 
	 */
	public SemPcsPorCicloAtivasException(String message, Long idFolha, Long idPt, String complemento){
		this.message = message;
		this.idFolha = idFolha;
		this.idPt = idPt;		
		this.complemento = complemento;
	}
	
	public SemPcsPorCicloAtivasException(Long idFolha, Long idPt, String complemento){
		this(SemPcsPorCicloAtivasException.MSG, idFolha, idPt, complemento);
	}
	
	public SemPcsPorCicloAtivasException(Long idFolha, Long idPt){
		this(idFolha, idPt, null);
	}

	public SemPcsPorCicloAtivasException(Long idFolha){
		this(idFolha, null, null);
	}
	
	@Override
	public String getMessage(){
		return message
			+ (complemento != null ? "." + complemento : "")
			+ (idFolha != null && idPt != null ? ".":"") 
			+ (idFolha != null ? " idFolha.SemPcsPorCiclo:" + idFolha : "" )
			+ (idPt != null ? " idPt:" + idPt : "" );
	}
	
	
}
