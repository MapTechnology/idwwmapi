package idw.webservices.rest.dto.monitorizacao.injet.bi;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import idw.model.rn.DataHoraRN;

@XmlRootElement(name="filtroBI")
public class BiFiltroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String anoIni;
	private String mesIni;
	private String anoFim;
	private String mesFim;
	private String dtIni; //ymdhms
	private String dtFim;
	
	private Date dtIniDt;
	private Date dtFimDt;
	
	private String cdTurno;
	private String cdPt;
	private String cdGt;
	private String cdClasseMaquina;
	private String cdRap;
	private String cdGrpRap;
	private String cdProduto;
	private String cdGalpao;
	private int agrupamentoBI;
	
	private String cdEstrutura;
	private String dsTurno;
	private String dsPt;
	private String dsGt;
	private String dsGrpRap;
	private String dsProduto;

	
	// filtros adicionais
	private FiltroBIParetoParadaDTO filtroBIParetoParada;
	private FiltroBIPizzaAreaRespParDTO filtroBIPizzaAreaRespPar;
	private FiltroBIParetoRefugoDTO	filtroBIParetoRefugo;
	private FiltroBIParetoPerdasParadaDTO filtroBIParetoPerdasParada;
	private FiltroBIParetoPerdasPCIDTO filtroBIParetoPerdasPCI;
	private FiltroBIParetoPerdasCicloDTO filtroBIParetoPerdasCiclo;
	private FiltroBIParetoPerdasTodasDTO filtroBIParetoPerdasTodas;
	private FiltroBIPerdasRefugoProdDetDTO filtroBIPerdasRefugoProdDet;
	private FiltroBIPerdasRefugoMaqDetDTO filtroBIPerdasRefugoMaqDet;
	private FiltroBIPerdasParadaProdDetDTO filtroBIPerdasParadaProdDet;	
	private FiltroBIPerdasParadaMaqDetDTO filtroBIPerdasParadaMaqDet;
	private FiltroBIPerdasAreaRespDetDTO filtroBIPerdasAreaRespDet;
	private FiltroBIPerdasCicloProdDetDTO filtroBIPerdasCicloProdDet;	
	private FiltroBIPerdasCicloMaqDetDTO filtroBIPerdasCicloMaqDet;
	private FiltroBIPerdasTodasDetDTO filtroBIPerdasTodasDet;

	// utilizado na ultima camada do BI - contem dados do cabecalho 
	private BiIndicadoresDTO indicadores;
	
	public String getDsTurno() {
		return dsTurno;
	}
	public void setDsTurno(String dsTurno) {
		this.dsTurno = dsTurno;
	}
	public String getDsPt() {
		return dsPt;
	}
	public void setDsPt(String dsPt) {
		this.dsPt = dsPt;
	}
	public String getDsGt() {
		return dsGt;
	}
	public void setDsGt(String dsGt) {
		this.dsGt = dsGt;
	}
	public String getDsGrpRap() {
		return dsGrpRap;
	}
	public void setDsGrpRap(String dsGrpRap) {
		this.dsGrpRap = dsGrpRap;
	}
	public String getDsProduto() {
		return dsProduto;
	}
	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}
	
	public FiltroBIParetoParadaDTO getFiltroBIParetoParada() {
		return filtroBIParetoParada;
	}
	public void setFiltroBIParetoParada(FiltroBIParetoParadaDTO filtroBIParetoParada) {
		this.filtroBIParetoParada = filtroBIParetoParada;
	}
	public FiltroBIPizzaAreaRespParDTO getFiltroBIPizzaAreaRespPar() {
		return filtroBIPizzaAreaRespPar;
	}
	public void setFiltroBIPizzaAreaRespPar(FiltroBIPizzaAreaRespParDTO filtroBIPizzaAreaRespPar) {
		this.filtroBIPizzaAreaRespPar = filtroBIPizzaAreaRespPar;
	}
	public FiltroBIParetoPerdasParadaDTO getFiltroBIParetoPerdasParada() {
		return filtroBIParetoPerdasParada;
	}
	public void setFiltroBIParetoPerdasParada(FiltroBIParetoPerdasParadaDTO filtroBIParetoPerdasParada) {
		this.filtroBIParetoPerdasParada = filtroBIParetoPerdasParada;
	}
	public FiltroBIParetoPerdasPCIDTO getFiltroBIParetoPerdasPCI() {
		return filtroBIParetoPerdasPCI;
	}
	public void setFiltroBIParetoPerdasPCI(FiltroBIParetoPerdasPCIDTO filtroBIParetoPerdasPCI) {
		this.filtroBIParetoPerdasPCI = filtroBIParetoPerdasPCI;
	}
	public FiltroBIParetoPerdasCicloDTO getFiltroBIParetoPerdasCiclo() {
		return filtroBIParetoPerdasCiclo;
	}
	public void setFiltroBIParetoPerdasCiclo(FiltroBIParetoPerdasCicloDTO filtroBIParetoPerdasCiclo) {
		this.filtroBIParetoPerdasCiclo = filtroBIParetoPerdasCiclo;
	}
	public FiltroBIParetoPerdasTodasDTO getFiltroBIParetoPerdasTodas() {
		return filtroBIParetoPerdasTodas;
	}
	public void setFiltroBIParetoPerdasTodas(FiltroBIParetoPerdasTodasDTO filtroBIParetoPerdasTodas) {
		this.filtroBIParetoPerdasTodas = filtroBIParetoPerdasTodas;
	}
	public FiltroBIPerdasRefugoProdDetDTO getFiltroBIPerdasRefugoProdDet() {
		return filtroBIPerdasRefugoProdDet;
	}
	public void setFiltroBIPerdasRefugoProdDet(FiltroBIPerdasRefugoProdDetDTO filtroBIPerdasRefugoProdDet) {
		this.filtroBIPerdasRefugoProdDet = filtroBIPerdasRefugoProdDet;
	}
	public FiltroBIPerdasRefugoMaqDetDTO getFiltroBIPerdasRefugoMaqDet() {
		return filtroBIPerdasRefugoMaqDet;
	}
	public void setFiltroBIPerdasRefugoMaqDet(FiltroBIPerdasRefugoMaqDetDTO filtroBIPerdasRefugoMaqDet) {
		this.filtroBIPerdasRefugoMaqDet = filtroBIPerdasRefugoMaqDet;
	}
	public FiltroBIPerdasParadaProdDetDTO getFiltroBIPerdasParadaProdDet() {
		return filtroBIPerdasParadaProdDet;
	}
	public void setFiltroBIPerdasParadaProdDet(FiltroBIPerdasParadaProdDetDTO filtroBIPerdasParadaProdDet) {
		this.filtroBIPerdasParadaProdDet = filtroBIPerdasParadaProdDet;
	}
	public FiltroBIPerdasParadaMaqDetDTO getFiltroBIPerdasParadaMaqDet() {
		return filtroBIPerdasParadaMaqDet;
	}
	public void setFiltroBIPerdasParadaMaqDet(FiltroBIPerdasParadaMaqDetDTO filtroBIPerdasParadaMaqDet) {
		this.filtroBIPerdasParadaMaqDet = filtroBIPerdasParadaMaqDet;
	}
	public FiltroBIPerdasAreaRespDetDTO getFiltroBIPerdasAreaRespDet() {
		return filtroBIPerdasAreaRespDet;
	}
	public void setFiltroBIPerdasAreaRespDet(FiltroBIPerdasAreaRespDetDTO filtroBIPerdasAreaRespDet) {
		this.filtroBIPerdasAreaRespDet = filtroBIPerdasAreaRespDet;
	}
	public FiltroBIPerdasCicloProdDetDTO getFiltroBIPerdasCicloProdDet() {
		return filtroBIPerdasCicloProdDet;
	}
	public void setFiltroBIPerdasCicloProdDet(FiltroBIPerdasCicloProdDetDTO filtroBIPerdasCicloProdDet) {
		this.filtroBIPerdasCicloProdDet = filtroBIPerdasCicloProdDet;
	}
	public FiltroBIPerdasCicloMaqDetDTO getFiltroBIPerdasCicloMaqDet() {
		return filtroBIPerdasCicloMaqDet;
	}
	public void setFiltroBIPerdasCicloMaqDet(FiltroBIPerdasCicloMaqDetDTO filtroBIPerdasCicloMaqDet) {
		this.filtroBIPerdasCicloMaqDet = filtroBIPerdasCicloMaqDet;
	}
	public FiltroBIPerdasTodasDetDTO getFiltroBIPerdasTodasDet() {
		return filtroBIPerdasTodasDet;
	}
	public void setFiltroBIPerdasTodasDet(FiltroBIPerdasTodasDetDTO filtroBIPerdasTodasDet) {
		this.filtroBIPerdasTodasDet = filtroBIPerdasTodasDet;
	}
	public String getAnoIni() {
		return anoIni;
	}
	public void setAnoIni(String anoIni) {
		this.anoIni = anoIni;
	}
	public String getMesIni() {
		return mesIni;
	}
	public void setMesIni(String mesIni) {
		this.mesIni = mesIni;
	}
	public String getAnoFim() {
		return anoFim;
	}
	public void setAnoFim(String anoFim) {
		this.anoFim = anoFim;
	}
	public String getMesFim() {
		return mesFim;
	}
	public void setMesFim(String mesFim) {
		this.mesFim = mesFim;
	}
	public String getDtIni() {
		return dtIni;
	}
	public void setDtIni(String dtIni) {
		this.dtIni = dtIni;
		this.dtIniDt = DataHoraRN.stringToDate(this.dtIni, "yyyy-MM-dd");
	}
	public String getDtFim() {
		return dtFim;
	}
	public void setDtFim(String dtFim) {
		this.dtFim = dtFim;
		this.dtFimDt = DataHoraRN.stringToDate(this.dtFim, "yyyy-MM-dd");
	}
	public String getCdTurno() {
		return cdTurno;
	}
	public void setCdTurno(String cdTurno) {
		this.cdTurno = cdTurno;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getCdGt() {
		return cdGt;
	}
	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}
	public String getCdClasseMaquina() {
		return cdClasseMaquina;
	}
	public void setCdClasseMaquina(String cdClasseMaquina) {
		this.cdClasseMaquina = cdClasseMaquina;
	}
	public String getCdRap() {
		return cdRap;
	}
	public void setCdRap(String cdRap) {
		this.cdRap = cdRap;
	}
	public String getCdGrpRap() {
		return cdGrpRap;
	}
	public void setCdGrpRap(String cdGrpRap) {
		this.cdGrpRap = cdGrpRap;
	}
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public String getCdGalpao() {
		return cdGalpao;
	}
	public void setCdGalpao(String cdGalpao) {
		this.cdGalpao = cdGalpao;
	}
	public int getAgrupamentoBI() {
		return agrupamentoBI;
	}
	public void setAgrupamentoBI(int agrupamentoBI) {
		this.agrupamentoBI = agrupamentoBI;
	}
	public String getCdEstrutura() {
		return cdEstrutura;
	}
	public void setCdEstrutura(String cdEstrutura) {
		this.cdEstrutura = cdEstrutura;
	}
	public FiltroBIParetoRefugoDTO getFiltroBIParetoRefugo() {
		return filtroBIParetoRefugo;
	}
	public void setFiltroBIParetoRefugo(FiltroBIParetoRefugoDTO filtroBIParetoRefugo) {
		this.filtroBIParetoRefugo = filtroBIParetoRefugo;
	}
	public BiIndicadoresDTO getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(BiIndicadoresDTO indicadores) {
		this.indicadores = indicadores;
	}
	public Date getDtIniDt() {
		return dtIniDt;
	}
	public Date getDtFimDt() {
		return dtFimDt;
	}
	
}
