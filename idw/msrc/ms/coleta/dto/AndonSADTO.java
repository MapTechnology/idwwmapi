package ms.coleta.dto;

import idw.model.pojos.MsPerfilregras;

public class AndonSADTO {

	private int porta;
	private int prioridade;
	private int tpEvento;
	private int TmpAlto;
	private int TmpBaixo;
	private boolean isPiscando;
	private String argumento;
	private int sinalMotivo;
	private int urlConexao;
	private int tolerancia;


	public AndonSADTO(){

	}

	public AndonSADTO(int porta, int prioridade, int tpEvento, int tmpAlto,
			int tmpBaixo, boolean isPiscando, String argumento,
			int sinalMotivo, int urlConexao, int tolerancia) {
		super();
		this.porta = porta;
		this.prioridade = prioridade;
		this.tpEvento = tpEvento;
		TmpAlto = tmpAlto;
		TmpBaixo = tmpBaixo;
		this.isPiscando = isPiscando;
		this.argumento = argumento;
		this.sinalMotivo = sinalMotivo;
		this.urlConexao = urlConexao;
		this.tolerancia = tolerancia;
	}

	public AndonSADTO(MsPerfilregras perfilRegras){

		this.porta       = perfilRegras.getPorta(); 
		this.prioridade  = perfilRegras.getPrioridade();
		this.tpEvento    = perfilRegras.getTpMotivo();

		if(perfilRegras.getSegTempoauto() == null){
			this.TmpAlto = 0;
		}else
			this.TmpAlto     = perfilRegras.getSegTempoauto().intValue() * 1000;

		if(perfilRegras.getSegTempobaixa() == null){
			this.TmpBaixo = 0;	
		}else
			this.TmpBaixo    = perfilRegras.getSegTempobaixa().intValue() * 1000;

		this.isPiscando  = perfilRegras.getIsPiscante();

		if(perfilRegras.getVlMotivo() == null || perfilRegras.getVlMotivo().equals("")){
			this.argumento = "NULL";
		}else
			this.argumento   = perfilRegras.getVlMotivo();

		if (perfilRegras.getSinalMotivo() != null)
			this.sinalMotivo = perfilRegras.getSinalMotivo();
		else
			this.sinalMotivo = 0;
		
		this.urlConexao  = Integer.valueOf(perfilRegras.getUrlConexaoUp());

		if(perfilRegras.getSegTolerancia() == null){
			this.tolerancia = 0;
		}else
			this.tolerancia  = perfilRegras.getSegTolerancia().intValue() * 1000;

	}

	public String getLinha(){

		return this.porta + "," + this.prioridade + "," + this.tpEvento + "," + this.TmpAlto + "," + this.TmpBaixo + "," + isPiscando() + "," + this.argumento + "," + this.sinalMotivo + "," + this.urlConexao + "," + this.tolerancia;
	}

	public int getPorta() {
		return porta;
	}
	public void setPorta(int porta) {
		this.porta = porta;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public int getTpEvento() {
		return tpEvento;
	}
	public void setTpEvento(int tpEvento) {
		this.tpEvento = tpEvento;
	}
	public int getTmpAlto() {
		return TmpAlto;
	}
	public void setTmpAlto(int tmpAlto) {
		TmpAlto = tmpAlto;
	}
	public int getTmpBaixo() {
		return TmpBaixo;
	}
	public void setTmpBaixo(int tmpBaixo) {
		TmpBaixo = tmpBaixo;
	}

	public int isPiscando() {
		if(isPiscando)
			return 1;
		else
			return 0;
	}

	public void setPiscando(boolean isPiscando) {
		this.isPiscando = isPiscando;
	}

	public String getArgumento() {
		return argumento;
	}
	public void setArgumento(String argumento) {
		this.argumento = argumento;
	}
	public int getSinalMotivo() {
		return sinalMotivo;
	}
	public void setSinalMotivo(int sinalMotivo) {
		this.sinalMotivo = sinalMotivo;
	}
	public int getUrlConexao() {
		return urlConexao;
	}
	public void setUrlConexao(int urlConexao) {
		this.urlConexao = urlConexao;
	}
	public int getTolerancia() {
		return tolerancia;
	}
	public void setTolerancia(int tolerancia) {
		this.tolerancia = tolerancia;
	}



}
