package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tabelaCep")
public class TabelaCepDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String referencia;
	private String grupoVariavel;
	private String variacaoMedicao;
	private String valorMinimoMedido;
	private String valorMedioMedido;
	private String valorMaximoMedido;
	private String valorTotalMedido;
	private String quantidadeMedicao;
	private String valorMonetario;
	private String valorUltimoMedido;
	private long idFtParam; //será usado como "parametro" para o próximo filtro (passar para próxima chamada)
	
	
	private String meta;
	private String limiteInferior;
	private String limiteSuperior;	
	private String desvioPadrao;
	private String cp;
	private String cpi;
	private String cps;
	private String cpk;
	
	private Boolean isForaMeta;
	private Boolean isForaUltimoValor;
		
	
	
	public Boolean getIsForaUltimoValor() {
		return isForaUltimoValor;
	}
	public void setIsForaUltimoValor(Boolean isForaUltimoValor) {
		this.isForaUltimoValor = isForaUltimoValor;
	}
	public String getMeta() {
		return meta;
	}
	public void setMeta(String meta) {
		this.meta = meta;
	}
	public String getLimiteInferior() {
		return limiteInferior;
	}
	public void setLimiteInferior(String limiteInferior) {
		this.limiteInferior = limiteInferior;
	}
	public String getLimiteSuperior() {
		return limiteSuperior;
	}
	public void setLimiteSuperior(String limiteSuperior) {
		this.limiteSuperior = limiteSuperior;
	}
	public String getDesvioPadrao() {
		return desvioPadrao;
	}
	public void setDesvioPadrao(String desvioPadrao) {
		this.desvioPadrao = desvioPadrao;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getCpi() {
		return cpi;
	}
	public void setCpi(String cpi) {
		this.cpi = cpi;
	}
	public String getCps() {
		return cps;
	}
	public void setCps(String cps) {
		this.cps = cps;
	}
	public String getCpk() {
		return cpk;
	}
	public void setCpk(String cpk) {
		this.cpk = cpk;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getGrupoVariavel() {
		return grupoVariavel;
	}
	public void setGrupoVariavel(String grupoVariavel) {
		this.grupoVariavel = grupoVariavel;
	}
	public String getVariacaoMedicao() {
		return variacaoMedicao;
	}
	public void setVariacaoMedicao(String variacaoMedicao) {
		this.variacaoMedicao = variacaoMedicao;
	}
	public String getValorMinimoMedido() {
		return valorMinimoMedido;
	}
	public void setValorMinimoMedido(String valorMinimoMedido) {
		this.valorMinimoMedido = valorMinimoMedido;
	}
	public String getValorMedioMedido() {
		return valorMedioMedido;
	}
	public void setValorMedioMedido(String valorMedioMedido) {
		this.valorMedioMedido = valorMedioMedido;
	}
	public String getValorMaximoMedido() {
		return valorMaximoMedido;
	}
	public void setValorMaximoMedido(String valorMaximoMedido) {
		this.valorMaximoMedido = valorMaximoMedido;
	}
	public String getValorTotalMedido() {
		return valorTotalMedido;
	}
	public void setValorTotalMedido(String valorTotalMedido) {
		this.valorTotalMedido = valorTotalMedido;
	}
	public String getQuantidadeMedicao() {
		return quantidadeMedicao;
	}
	public void setQuantidadeMedicao(String quantidadeMedicao) {
		this.quantidadeMedicao = quantidadeMedicao;
	}
	public String getValorMonetario() {
		return valorMonetario;
	}
	public void setValorMonetario(String valorMonetario) {
		this.valorMonetario = valorMonetario;
	}
	
	public String getValorUltimoMedido() {
		return valorUltimoMedido;
	}
	public void setValorUltimoMedido(String valorUltimoMedido) {
		this.valorUltimoMedido = valorUltimoMedido;
	}
	public long getIdFtParam() {
		return idFtParam;
	}
	public void setIdFtParam(long idFtParam) {
		this.idFtParam = idFtParam;
	}
	public Boolean getIsForaMeta() {
		return isForaMeta;
	}
	public void setIsForaMeta(Boolean isForaMeta) {
		this.isForaMeta = isForaMeta;
	}
	
}
