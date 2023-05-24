package idw.webservices.dto;

import java.io.Serializable;

public class LeituraCODTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PosicaoCODTO posicaoASerLida;
    private boolean isLeituraOk;
    private String dthrLeitura;
    private boolean isRealimentacao;
    private String cdLidoProduto;
    private String cbRap;
    private long idUsuario;
    private int qtAlimentada;
    private int isConferenciaOuAlimentacao;
    private String cbInformacoes;
    private String cbNumeroLote;
	
    public String getCbInformacoes() {
		return cbInformacoes;
	}
	public void setCbInformacoes(String cbInformacoes) {
		this.cbInformacoes = cbInformacoes;
	}
	public String getCbNumeroLote() {
		return cbNumeroLote;
	}
	public void setCbNumeroLote(String cbNumeroLote) {
		this.cbNumeroLote = cbNumeroLote;
	}
	public PosicaoCODTO getPosicaoASerLida() {
		return posicaoASerLida;
	}
	public void setPosicaoASerLida(PosicaoCODTO posicaoASerLida) {
		this.posicaoASerLida = posicaoASerLida;
	}
	public boolean isLeituraOk() {
		return isLeituraOk;
	}
	public void setLeituraOk(boolean valor) {
		this.isLeituraOk = valor;
	}
	public String getDthrLeitura() {
		return dthrLeitura;
	}
	public void setDthrLeitura(String dthrLeitura) {
		this.dthrLeitura = dthrLeitura;
	}
	public boolean isRealimentacao() {
		return isRealimentacao;
	}
	public void setRealimentacao(boolean isRealimentacao) {
		this.isRealimentacao = isRealimentacao;
	}
	public String getCdLidoProduto() {
		return cdLidoProduto;
	}
	public void setCdLidoProduto(String cdLidoProduto) {
		this.cdLidoProduto = cdLidoProduto;
	}
	
	public String getCbRap() {
		return cbRap;
	}
	public void setCbRap(String cbRap) {
		this.cbRap = cbRap;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getQtAlimentada() {
		return qtAlimentada;
	}
	public void setQtAlimentada(int qtAlimentada) {
		this.qtAlimentada = qtAlimentada;
	}
	public int getIsConferenciaOuAlimentacao() {
		return isConferenciaOuAlimentacao;
	}
	public void setIsConferenciaOuAlimentacao(int isConferenciaOuAlimentacao) {
		this.isConferenciaOuAlimentacao = isConferenciaOuAlimentacao;
	}
	
	

    
}
