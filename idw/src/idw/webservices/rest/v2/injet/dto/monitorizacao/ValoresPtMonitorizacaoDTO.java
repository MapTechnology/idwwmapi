package idw.webservices.rest.v2.injet.dto.monitorizacao;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="valoresPtMonitorizacaoDTO")
public class ValoresPtMonitorizacaoDTO implements Serializable {
	
	BigDecimal coorelobjy; 
	BigDecimal coorelobjx ; 
	String cdinjetora; 
	String cdinjestendido ; 
	String stfuncionamento ; 
	String TpIcone; 
	Integer aguardandomolde; 
	Integer AlertaInspQld; 
	Integer maquinaemalerta; 
	Integer StUltInspQld; 
	Integer StDelayConsol; 
	Integer StManut; 
	Integer StPerdaSinc; 
	Integer StProbQld; 
	BigDecimal QtAleParCIP; 
	BigDecimal QtAlertasExtrInsp; 
	BigDecimal QtAlertasExtrPar; 
	BigDecimal QtAlertasOperador; 
	BigDecimal QtAlertasProbQld; 
	Integer parcompeso; 
	Integer parnaoinf; 
	BigDecimal EfiReaMaq; 
	BigDecimal EfiCicMaq; 
	BigDecimal IndRefMaiorQue; 
	BigDecimal efi_rea; 
	BigDecimal efi_cic; 
	BigDecimal ind_ref; 
	BigDecimal ind_par; 
	BigDecimal ind_cav; 
	BigDecimal ind_qld; 
	BigDecimal ind_disp; 
	BigDecimal oee;	
	String nropatual;
	String cdmoldeatual;
	
	
	BigDecimal indprd ;
	BigDecimal qtpliqop ;
	BigDecimal qtplanop ;	
	

	BigDecimal tmpultimociclo ;
	BigDecimal tmpciclopadrao ;
	BigDecimal eficinstantanea ;

	

	String cdproduto;
	String dsproduto;
	
	
	public BigDecimal getCoorelobjy() {
		return coorelobjy;
	}
	public void setCoorelobjy(BigDecimal coorelobjy) {
		this.coorelobjy = coorelobjy;
	}
	public BigDecimal getCoorelobjx() {
		return coorelobjx;
	}
	public void setCoorelobjx(BigDecimal coorelobjx) {
		this.coorelobjx = coorelobjx;
	}
	public String getCdinjetora() {
		return cdinjetora;
	}
	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}
	public String getCdinjestendido() {
		return cdinjestendido;
	}
	public void setCdinjestendido(String cdinjestendido) {
		this.cdinjestendido = cdinjestendido;
	}
	public String getStfuncionamento() {
		return stfuncionamento;
	}
	public void setStfuncionamento(String stfuncionamento) {
		this.stfuncionamento = stfuncionamento;
	}
	public String getTpIcone() {
		return TpIcone;
	}
	public void setTpIcone(String tpIcone) {
		TpIcone = tpIcone;
	}
	public Integer getAguardandomolde() {
		return aguardandomolde;
	}
	public void setAguardandomolde(Integer aguardandomolde) {
		this.aguardandomolde = aguardandomolde;
	}
	public Integer getAlertaInspQld() {
		return AlertaInspQld;
	}
	public void setAlertaInspQld(Integer alertaInspQld) {
		AlertaInspQld = alertaInspQld;
	}
	public Integer getMaquinaemalerta() {
		return maquinaemalerta;
	}
	public void setMaquinaemalerta(Integer maquinaemalerta) {
		this.maquinaemalerta = maquinaemalerta;
	}
	public Integer getStUltInspQld() {
		return StUltInspQld;
	}
	public void setStUltInspQld(Integer stUltInspQld) {
		StUltInspQld = stUltInspQld;
	}
	public Integer getStDelayConsol() {
		return StDelayConsol;
	}
	public void setStDelayConsol(Integer stDelayConsol) {
		StDelayConsol = stDelayConsol;
	}
	public Integer getStManut() {
		return StManut;
	}
	public void setStManut(Integer stManut) {
		StManut = stManut;
	}
	public Integer getStPerdaSinc() {
		return StPerdaSinc;
	}
	public void setStPerdaSinc(Integer stPerdaSinc) {
		StPerdaSinc = stPerdaSinc;
	}
	public Integer getStProbQld() {
		return StProbQld;
	}
	public void setStProbQld(Integer stProbQld) {
		StProbQld = stProbQld;
	}
	public BigDecimal getQtAleParCIP() {
		return QtAleParCIP;
	}
	public void setQtAleParCIP(BigDecimal qtAleParCIP) {
		QtAleParCIP = qtAleParCIP;
	}
	public BigDecimal getQtAlertasExtrInsp() {
		return QtAlertasExtrInsp;
	}
	public void setQtAlertasExtrInsp(BigDecimal qtAlertasExtrInsp) {
		QtAlertasExtrInsp = qtAlertasExtrInsp;
	}
	public BigDecimal getQtAlertasExtrPar() {
		return QtAlertasExtrPar;
	}
	public void setQtAlertasExtrPar(BigDecimal qtAlertasExtrPar) {
		QtAlertasExtrPar = qtAlertasExtrPar;
	}
	public BigDecimal getQtAlertasOperador() {
		return QtAlertasOperador;
	}
	public void setQtAlertasOperador(BigDecimal qtAlertasOperador) {
		QtAlertasOperador = qtAlertasOperador;
	}
	public BigDecimal getQtAlertasProbQld() {
		return QtAlertasProbQld;
	}
	public void setQtAlertasProbQld(BigDecimal qtAlertasProbQld) {
		QtAlertasProbQld = qtAlertasProbQld;
	}
	public Integer getParcompeso() {
		return parcompeso;
	}
	public void setParcompeso(Integer parcompeso) {
		this.parcompeso = parcompeso;
	}
	public Integer getParnaoinf() {
		return parnaoinf;
	}
	public void setParnaoinf(Integer parnaoinf) {
		this.parnaoinf = parnaoinf;
	}
	public BigDecimal getEfiReaMaq() {
		return EfiReaMaq;
	}
	public void setEfiReaMaq(BigDecimal efiReaMaq) {
		EfiReaMaq = efiReaMaq;
	}
	public BigDecimal getEfiCicMaq() {
		return EfiCicMaq;
	}
	public void setEfiCicMaq(BigDecimal efiCicMaq) {
		EfiCicMaq = efiCicMaq;
	}
	public BigDecimal getIndRefMaiorQue() {
		return IndRefMaiorQue;
	}
	public void setIndRefMaiorQue(BigDecimal indRefMaiorQue) {
		IndRefMaiorQue = indRefMaiorQue;
	}
	public BigDecimal getEfi_rea() {
		return efi_rea;
	}
	public void setEfi_rea(BigDecimal efi_rea) {
		this.efi_rea = efi_rea;
	}
	public BigDecimal getEfi_cic() {
		return efi_cic;
	}
	public void setEfi_cic(BigDecimal efi_cic) {
		this.efi_cic = efi_cic;
	}
	public BigDecimal getInd_ref() {
		return ind_ref;
	}
	public void setInd_ref(BigDecimal ind_ref) {
		this.ind_ref = ind_ref;
	}
	public BigDecimal getInd_par() {
		return ind_par;
	}
	public void setInd_par(BigDecimal ind_par) {
		this.ind_par = ind_par;
	}
	public BigDecimal getInd_cav() {
		return ind_cav;
	}
	public void setInd_cav(BigDecimal ind_cav) {
		this.ind_cav = ind_cav;
	}
	public BigDecimal getInd_qld() {
		return ind_qld;
	}
	public void setInd_qld(BigDecimal ind_qld) {
		this.ind_qld = ind_qld;
	}
	public BigDecimal getInd_disp() {
		return ind_disp;
	}
	public void setInd_disp(BigDecimal ind_disp) {
		this.ind_disp = ind_disp;
	}
	public BigDecimal getOee() {
		return oee;
	}
	public void setOee(BigDecimal oee) {
		this.oee = oee;
	}
	
	
	
	public String getNropatual() {
		return nropatual;
	}
	public void setNropatual(String nropatual) {
		this.nropatual = nropatual;
	}
	public String getCdmoldeatual() {
		return cdmoldeatual;
	}
	public void setCdmoldeatual(String cdmoldeatual) {
		this.cdmoldeatual = cdmoldeatual;
	}
	public BigDecimal getIndprd() {
		return indprd;
	}
	public void setIndprd(BigDecimal indprd) {
		this.indprd = indprd;
	}
	public BigDecimal getQtpliqop() {
		return qtpliqop;
	}
	public void setQtpliqop(BigDecimal qtpliqop) {
		this.qtpliqop = qtpliqop;
	}
	public BigDecimal getQtplanop() {
		return qtplanop;
	}
	public void setQtplanop(BigDecimal qtplanop) {
		this.qtplanop = qtplanop;
	}
	public BigDecimal getTmpultimociclo() {
		return tmpultimociclo;
	}
	public void setTmpultimociclo(BigDecimal tmpultimociclo) {
		this.tmpultimociclo = tmpultimociclo;
	}
	public BigDecimal getTmpciclopadrao() {
		return tmpciclopadrao;
	}
	public void setTmpciclopadrao(BigDecimal tmpciclopadrao) {
		this.tmpciclopadrao = tmpciclopadrao;
	}
	public BigDecimal getEficinstantanea() {
		return eficinstantanea;
	}
	public void setEficinstantanea(BigDecimal eficinstantanea) {
		this.eficinstantanea = eficinstantanea;
	}
	
	
	public String getCdproduto() {
		return cdproduto;
	}
	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}
	public String getDsproduto() {
		return dsproduto;
	}
	public void setDsproduto(String dsproduto) {
		this.dsproduto = dsproduto;
	}
	
	
	
	
	
	
	

}