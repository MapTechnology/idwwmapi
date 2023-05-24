package ms.excessao;

public class FuncionalidadeIndisponivelException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final short CD_FLAG_GERAL = Byte.MAX_VALUE;
	public static final short MAX_ID = 1;
	
	//private String[] IdExcecao = new String[MAX_ID+1];
	
	private short flagAtivo = -1; 
	
	public FuncionalidadeIndisponivelException(Exception e){
		super(e.getMessage());
	}
	
		
	public int getIdErro() {
		
		return this.flagAtivo;
	}

	public String getIdExcecao() {
		return "semhomologacaoerror.jsp";
	}

}
