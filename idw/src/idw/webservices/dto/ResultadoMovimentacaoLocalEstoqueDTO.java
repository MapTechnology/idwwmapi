package idw.webservices.dto;



public class ResultadoMovimentacaoLocalEstoqueDTO {

	private Boolean isOk;
	private Boolean isLocalOrigemNaoEncontrado;
	private Boolean isLocalDestinoNaoEncontrado;
	private Boolean isProdutoNaoEncontrado;
	private Boolean isUsuarioNaoEncontrado;
	private Boolean isEntradaNaoEncontrada;
	private Boolean isCalendarioNaoEncontrado;
	private Boolean isSaidaMaiorQueTotal = false;
	
	private String msgErro;
	
	public void setCalendarioNaoEncontrado(Boolean isCalendarioNaoEncontrado) {
		this.isCalendarioNaoEncontrado = isCalendarioNaoEncontrado;
	}
	
	public Boolean isCalendarioNaoEncontrado() {
		return isCalendarioNaoEncontrado;
	}
	
	public Boolean isProdutoNaoEncontrado() {
		return isProdutoNaoEncontrado;
	}
	public void setProdutoNaoEncontrado(Boolean isProdutoNaoEncontrado) {
		this.isProdutoNaoEncontrado = isProdutoNaoEncontrado;
	}
	public Boolean isOk() {
		return isOk;
	}
	public void setOk(Boolean isOk) {
		this.isOk = isOk;
	}
	public Boolean isLocalOrigemNaoEncontrado() {
		return isLocalOrigemNaoEncontrado;
	}
	public void setLocalOrigemNaoEncontrado(Boolean isLocalNaoEncontrado) {
		this.isLocalOrigemNaoEncontrado = isLocalNaoEncontrado;
	}

	public Boolean isUsuarioNaoEncontrado(){
		return isUsuarioNaoEncontrado;
	}

	public void setUsuarioNaoEncontrado(Boolean isUsuarioNaoEncontrado) {
		this.isUsuarioNaoEncontrado = isUsuarioNaoEncontrado;		
	}
	public Boolean isLocalDestinoNaoEncontrado() {
		return isLocalDestinoNaoEncontrado;
	}
	public void setLocalDestinoNaoEncontrado(Boolean isLocalDestinoNaoEncontrado) {
		this.isLocalDestinoNaoEncontrado = isLocalDestinoNaoEncontrado;
	}
	public Boolean isEntradaNaoEncontrada() {
		return isEntradaNaoEncontrada;
	}
	public void setEntradaNaoEncontrada(Boolean isEntradaNaoEncontrada) {
		this.isEntradaNaoEncontrada = isEntradaNaoEncontrada;
	}
	public Boolean isSaidaMaiorQueTotal() {
		return isSaidaMaiorQueTotal;
	}
	public void setSaidaMaiorQueTotal(Boolean isSaidaMaiorQueTotal) {
		this.isSaidaMaiorQueTotal = isSaidaMaiorQueTotal;
	}
	public String getMsgErro() {
		return msgErro;
	}
	public void setMsgErro(String msgErro) {
		this.msgErro = msgErro;
	}
	
}
