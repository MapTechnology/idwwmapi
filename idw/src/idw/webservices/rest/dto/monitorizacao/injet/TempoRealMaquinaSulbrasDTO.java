package idw.webservices.rest.dto.monitorizacao.injet;

import java.util.List;

public class TempoRealMaquinaSulbrasDTO {
	private String cdMaquina;
	private String nrOPExibicao;
	private String qtdProducaoPlanejada;
	private String qtdProducaoLiquida;
	private String mtbf;
	private String mttr;
	private String oee;
	private String corOEE; 
	private String indRef;
	private String corIndRef;
	private String tipoRodape; // pode ser "ALERTA", "PARADA", ""
	private String dsRodape; // conteúdo associado a tipoRodape >> codigo + descricao do alerta ou da parada ou ""
	private String dtHrRodape; // data/hora do alerta ou da parada ou ""
	private String qtdProducaoRefugada;
	private List<TempoRealSulbrasRefugoDTO> listaRefugos;
	private List<TempoRealSulbrasLoginDTO> listaOperadores;
	
	
	public String getQtdProducaoRefugada() {
		return qtdProducaoRefugada;
	}
	public void setQtdProducaoRefugada(String qtdProducaoRefugada) {
		this.qtdProducaoRefugada = qtdProducaoRefugada;
	}
	public String getCdMaquina() {
		return cdMaquina;
	}
	public void setCdMaquina(String cdMaquina) {
		this.cdMaquina = cdMaquina;
	}
	public String getNrOPExibicao() {
		return nrOPExibicao;
	}
	public void setNrOPExibicao(String nrOPExibicao) {
		this.nrOPExibicao = nrOPExibicao;
	}
	public String getQtdProducaoPlanejada() {
		return qtdProducaoPlanejada;
	}
	public void setQtdProducaoPlanejada(String qtdProducaoPlanejada) {
		this.qtdProducaoPlanejada = qtdProducaoPlanejada;
	}
	public String getQtdProducaoLiquida() {
		return qtdProducaoLiquida;
	}
	public void setQtdProducaoLiquida(String qtdProducaoLiquida) {
		this.qtdProducaoLiquida = qtdProducaoLiquida;
	}
	public String getMtbf() {
		return mtbf;
	}
	public void setMtbf(String mtbf) {
		this.mtbf = mtbf;
	}
	public String getMttr() {
		return mttr;
	}
	public void setMttr(String mttr) {
		this.mttr = mttr;
	}
	public String getOee() {
		return oee;
	}
	public void setOee(String oee) {
		this.oee = oee;
	}
 
	public String getCorOEE() {
		return corOEE;
	}
	public void setCorOEE(String corOEE) {
		this.corOEE = corOEE;
	}
	public String getIndRef() {
		return indRef;
	}
	public void setIndRef(String indRef) {
		this.indRef = indRef;
	}
	public String getCorIndRef() {
		return corIndRef;
	}
	public void setCorIndRef(String corIndRef) {
		this.corIndRef = corIndRef;
	}
	public String getTipoRodape() {
		return tipoRodape;
	}
	public void setTipoRodape(String tipoRodape) {
		this.tipoRodape = tipoRodape;
	}
	public String getDsRodape() {
		return dsRodape;
	}
	public void setDsRodape(String dsRodape) {
		this.dsRodape = dsRodape;
	}
	public String getDtHrRodape() {
		return dtHrRodape;
	}
	public void setDtHrRodape(String dtHrRodape) {
		this.dtHrRodape = dtHrRodape;
	}
	public List<TempoRealSulbrasRefugoDTO> getListaRefugos() {
		return listaRefugos;
	}
	public void setListaRefugos(List<TempoRealSulbrasRefugoDTO> listaRefugos) {
		this.listaRefugos = listaRefugos;
	}
	public List<TempoRealSulbrasLoginDTO> getListaOperadores() {
		return listaOperadores;
	}
	public void setListaOperadores(List<TempoRealSulbrasLoginDTO> listaOperadores) {
		this.listaOperadores = listaOperadores;
	}
	
}
