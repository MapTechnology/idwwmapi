package ms.coleta.dto;

import java.util.Date;

public class SessaoParadaDTO {
	private String cdParada = "";
	private String dsParada = "";
	private long idConsolpalog;
	private long idTParada;
	private long idTppt;
	private Date dthrIParada;
	private Date dthrFParada;
	private boolean isParado;
	private boolean isRequerCausa;
	private boolean isRequerAcao;
	private boolean isRequerJustificativa;
	private int qtdTecnico;
	private boolean isPermiteCorrecao;
	private boolean isPesaEficiencia;
	private boolean isRegulagem;
	private double timeoutAlerta;
	private String cdAlerta = "";
	private double extrapolacao;
	private String cdParadaExtra = "";
	
	public void dumbRN() {
		if(dthrFParada == null){
			isParado = true;
		} else{
			isParado = false;
		}
	}

	public String getCdParada() {
		return cdParada;
	}

	public void setCdParada(String cdParada) {
		this.cdParada = cdParada;
	}

	public String getDsParada() {
		return dsParada;
	}

	public void setDsParada(String dsParada) {
		this.dsParada = dsParada;
	}

	public long getIdTppt() {
		return idTppt;
	}

	public void setIdTppt(long idTppt) {
		this.idTppt = idTppt;
	}

	public Date getDthrIParada() {
		return dthrIParada;
	}

	public void setDthrIParada(Date dthrIParada) {
		this.dthrIParada = dthrIParada;
	}

	public Date getDthrFParada() {
		return dthrFParada;
	}

	public void setDthrFParada(Date dthrFParada) {
		this.dthrFParada = dthrFParada;
	}

	public boolean isParado() {
		return isParado;
	}

	public void setParado(boolean isParado) {
		this.isParado = isParado;
	}

	public boolean isRequerCausa() {
		return isRequerCausa;
	}

	public void setRequerCausa(boolean isRequerCausa) {
		this.isRequerCausa = isRequerCausa;
	}

	public boolean isRequerAcao() {
		return isRequerAcao;
	}

	public void setRequerAcao(boolean isRequerAcao) {
		this.isRequerAcao = isRequerAcao;
	}

	public boolean isRequerJustificativa() {
		return isRequerJustificativa;
	}

	public void setRequerJustificativa(boolean isRequerJustificativa) {
		this.isRequerJustificativa = isRequerJustificativa;
	}

	public int getQtdTecnico() {
		return qtdTecnico;
	}

	public void setQtdTecnico(int qtdTecnico) {
		this.qtdTecnico = qtdTecnico;
	}

	public boolean isPermiteCorrecao() {
		return isPermiteCorrecao;
	}

	public void setPermiteCorrecao(boolean isPermiteCorrecao) {
		this.isPermiteCorrecao = isPermiteCorrecao;
	}

	public boolean isPesaEficiencia() {
		return isPesaEficiencia;
	}

	public void setPesaEficiencia(boolean isPesaEficiencia) {
		this.isPesaEficiencia = isPesaEficiencia;
	}

	public boolean isRegulagem() {
		return isRegulagem;
	}

	public void setRegulagem(boolean isRegulagem) {
		this.isRegulagem = isRegulagem;
	}

	public double getTimeoutAlerta() {
		return timeoutAlerta;
	}

	public void setTimeoutAlerta(double timeoutAlerta) {
		this.timeoutAlerta = timeoutAlerta;
	}

	public String getCdAlerta() {
		return cdAlerta;
	}

	public void setCdAlerta(String cdAlerta) {
		this.cdAlerta = cdAlerta;
	}

	public double getExtrapolacao() {
		return extrapolacao;
	}

	public void setExtrapolacao(double extrapolacao) {
		this.extrapolacao = extrapolacao;
	}

	public String getCdParadaExtra() {
		return cdParadaExtra;
	}

	public void setCdParadaExtra(String cdParadaExtra) {
		this.cdParadaExtra = cdParadaExtra;
	}

	public long getIdConsolpalog() {
		return idConsolpalog;
	}

	public void setIdConsolpalog(long idConsolpalog) {
		this.idConsolpalog = idConsolpalog;
	}

	public long getIdTParada() {
		return idTParada;
	}

	public void setIdTParada(long idTParada) {
		this.idTParada = idTParada;
	}
}
