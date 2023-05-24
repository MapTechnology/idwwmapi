package injetws.webservices.dto;
import injetws.model.pojos.PrUpUltimaVariacaoRitmo;
import injetws.model.pojos.PrUpVariacaoRitmoPend;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class IwsVariacaoRitmoDTO implements Serializable{
	
	private boolean isComVariacaoRitmoPend=false;
	private boolean isComVariacaoRitmoInformada=false;
	private double idvariacaoritmoinjet;
	private String variacaoritmo;
	private Date dthrini;
	private Date dthrfim;
	
	private String cdvarritmo01;
	private String dsvarritmo01;
	private int perc01;
	private String cdvarritmo02;
	private String dsvarritmo02;
	private int perc02;
	private String cdvarritmo03;
	private String dsvarritmo03;
	private int perc03;
	private String cdvarritmo04;
	private String dsvarritmo04;
	private int perc04;
	private String cdvarritmo05;
	private String dsvarritmo05;
	private int perc05;
	private String cdvarritmo06;
	private String dsvarritmo06;
	private int perc06;
	private String cdvarritmo07;
	private String dsvarritmo07;
	private int perc07;
	private String cdvarritmo08;
	private String dsvarritmo08;
	private int perc08;
	
	/**
	 * @return the isComVariacaoRitmoPend
	 */
	public boolean getIsComVariacaoRitmoPend() {
		return isComVariacaoRitmoPend;
	}
	/**
	 * @param isComVariacaoRitmoPend the isComVariacaoRitmoPend to set
	 */
	public void setIsComVariacaoRitmoPend(boolean isComVariacaoRitmoPend) {
		this.isComVariacaoRitmoPend = isComVariacaoRitmoPend;
		if(isComVariacaoRitmoPend) 
			this.isComVariacaoRitmoInformada=false;
	}
	
	/**
	 * @return the isComVariacaoRitmoInformada
	 */
	public boolean getIsComVariacaoRitmoInformada() {
		if(isComVariacaoRitmoPend) 
			this.isComVariacaoRitmoInformada=false;
		return isComVariacaoRitmoInformada;
	}
	/**
	 * @param isComVariacaoRitmoInformada the isComVariacaoRitmoInformada to set
	 */
	public void setIsComVariacaoRitmoInformada(boolean isComVariacaoRitmoInformada) {		
		this.isComVariacaoRitmoInformada = isComVariacaoRitmoInformada;
	}
	
	/**
	 * @return the IdVariacaoRitmoInjet
	 */
	public double getIdVariacaoRitmoInjet() {
		return idvariacaoritmoinjet;
	}
	/**
	 * @param IdVariacaoRitmoInjet the IdVariacaoRitmoInjet to set
	 */
	public void setIdVariacaoRitmoInjet(double idvariacaoritmoinjet) {
		this.idvariacaoritmoinjet = idvariacaoritmoinjet;
	}
	
	/**
	 * @return the VariacaoRitmo
	 */
	public String getVariacaoRitmo() {
		return variacaoritmo;
	}
	/**
	 * @param VariacaoRitmo the VariacaoRitmo to set
	 */
	public void setVariacaoRitmo(String variacaoritmo) {
		this.variacaoritmo = variacaoritmo;
	}
	/**
	 * @return the DtHrIni
	 */
	public Date getDtHrIni() {
		return dthrini;
	}
	/**
	 * @param DtHrIni the DtHrIni to set
	 */
	public void setDtHrIni(Date dthrini) {
		this.dthrini = dthrini;
	}
	
	/**
	 * @return the DtHrFim
	 */
	public Date getDtHrFim() {
		return dthrfim;
	}
	/**
	 * @param DtHrFim the DtHrFim to set
	 */
	public void setDtHrFim(Date dthrfim) {
		this.dthrfim = dthrfim;
	}
	
	public String getCdVarRitmo01() {
		return cdvarritmo01;
	}	

	public void setCdVarRitmo01(String cdvarritmo01) {
		this.cdvarritmo01 = cdvarritmo01;
	}
	
	public String getDsVarRitmo01() {
		return dsvarritmo01;
	}	

	public void setDsVarRitmo01(String dsvarritmo01) {
		this.dsvarritmo01 = dsvarritmo01;
	}
	
	public int getPerc01() {
		return perc01;
	}	

	public void setPerc01(int perc01) {
		this.perc01 = perc01;
	}	
	
	public String getCdVarRitmo02() {
		return cdvarritmo02;
	}	

	public void setCdVarRitmo02(String cdvarritmo02) {
		this.cdvarritmo02 = cdvarritmo02;
	}
	
	public String getDsVarRitmo02() {
		return dsvarritmo02;
	}	

	public void setDsVarRitmo02(String dsvarritmo02) {
		this.dsvarritmo02 = dsvarritmo02;
	}
	
	public int getPerc02() {
		return perc02;
	}	

	public void setPerc02(int perc02) {
		this.perc02 = perc02;
	}	
	
	public String getCdVarRitmo03() {
		return cdvarritmo03;
	}	

	public void setCdVarRitmo03(String cdvarritmo03) {
		this.cdvarritmo03 = cdvarritmo03;
	}
	
	public String getDsVarRitmo03() {
		return dsvarritmo03;
	}	

	public void setDsVarRitmo03(String dsvarritmo03) {
		this.dsvarritmo03 = dsvarritmo03;
	}
	
	public int getPerc03() {
		return perc03;
	}	

	public void setPerc03(int perc03) {
		this.perc03 = perc03;
	}	
	
	public String getCdVarRitmo04() {
		return cdvarritmo04;
	}	

	public void setCdVarRitmo04(String cdvarritmo04) {
		this.cdvarritmo04 = cdvarritmo04;
	}
	
	public String getDsVarRitmo04() {
		return dsvarritmo04;
	}	

	public void setDsVarRitmo04(String dsvarritmo04) {
		this.dsvarritmo04 = dsvarritmo04;
	}
	
	public int getPerc04() {
		return perc04;
	}	

	public void setPerc04(int perc04) {
		this.perc04 = perc04;
	}	
	
	public String getCdVarRitmo05() {
		return cdvarritmo05;
	}	

	public void setCdVarRitmo05(String cdvarritmo05) {
		this.cdvarritmo05 = cdvarritmo05;
	}
	
	public String getDsVarRitmo05() {
		return dsvarritmo05;
	}	

	public void setDsVarRitmo05(String dsvarritmo05) {
		this.dsvarritmo05 = dsvarritmo05;
	}
	
	public int getPerc05() {
		return perc05;
	}	

	public void setPerc05(int perc05) {
		this.perc05 = perc05;
	}	
	
	public String getCdVarRitmo06() {
		return cdvarritmo06;
	}	

	public void setCdVarRitmo06(String cdvarritmo06) {
		this.cdvarritmo06 = cdvarritmo06;
	}
	
	public String getDsVarRitmo06() {
		return dsvarritmo06;
	}	

	public void setDsVarRitmo06(String dsvarritmo06) {
		this.dsvarritmo06 = dsvarritmo06;
	}
	
	public int getPerc06() {
		return perc06;
	}	

	public void setPerc06(int perc06) {
		this.perc06 = perc06;
	}	
	
	public String getCdVarRitmo07() {
		return cdvarritmo07;
	}	

	public void setCdVarRitmo07(String cdvarritmo07) {
		this.cdvarritmo07 = cdvarritmo07;
	}
	
	public String getDsVarRitmo07() {
		return dsvarritmo07;
	}	

	public void setDsVarRitmo07(String dsvarritmo07) {
		this.dsvarritmo07 = dsvarritmo07;
	}
	
	public int getPerc07() {
		return perc07;
	}	

	public void setPerc07(int perc07) {
		this.perc07 = perc07;
	}	
	
	public String getCdVarRitmo08() {
		return cdvarritmo08;
	}	

	public void setCdVarRitmo08(String cdvarritmo08) {
		this.cdvarritmo08 = cdvarritmo08;
	}
	
	public String getDsVarRitmo08() {
		return dsvarritmo08;
	}	

	public void setDsVarRitmo08(String dsvarritmo08) {
		this.dsvarritmo08 = dsvarritmo08;
	}
	
	public int getPerc08() {
		return perc08;
	}	

	public void setPerc08(int perc08) {
		this.perc08 = perc08;
	}	
	
	public void copyVariacaoPend(PrUpVariacaoRitmoPend oVar){
		this.idvariacaoritmoinjet=oVar.getIdVariacaoRitmoInjet();
		this.variacaoritmo=oVar.getVariacaoRitmo();
		this.dthrini=oVar.getDtHrIni();
		this.dthrfim=oVar.getDtHrFim();
		setIsComVariacaoRitmoPend(true);
	}
			
	public void copyUltimaVariacaoRitmoInformada(PrUpUltimaVariacaoRitmo oUltivar) 
	{	
		if(this.isComVariacaoRitmoPend)
				return;
		this.idvariacaoritmoinjet =oUltivar.getIdVariacaoRitmoInjet();
		this.variacaoritmo=oUltivar.getVariacaoRitmo();
		this.dthrini=oUltivar.getDtHrIni();
		this.dthrfim= oUltivar.getDtHrFim();		
		this.cdvarritmo01= oUltivar.getCdVarRitmo01();
		this.dsvarritmo01= oUltivar.getDsVarRitmo01();
		this.perc01= oUltivar.getPerc01();
		this.cdvarritmo02= oUltivar.getCdVarRitmo02(); 
		this.dsvarritmo02=oUltivar.getDsVarRitmo02() ;
		this.perc02= oUltivar.getPerc02(); 
		this.cdvarritmo03= oUltivar.getCdVarRitmo03();
		this.dsvarritmo03= oUltivar.getDsVarRitmo03();
		this.perc03= oUltivar.getPerc03(); 
		this.cdvarritmo04= oUltivar.getCdVarRitmo04(); 
		this.dsvarritmo04= oUltivar.getDsVarRitmo04();
		this.perc04= oUltivar.getPerc04();
		this.cdvarritmo05= oUltivar.getCdVarRitmo05();
		this.dsvarritmo05= oUltivar.getDsVarRitmo05();
		this.perc05= oUltivar.getPerc05(); 
		this.cdvarritmo06= oUltivar.getCdVarRitmo06();
		this.dsvarritmo06= oUltivar.getDsVarRitmo06();
		this.perc06= oUltivar.getPerc06();
		this.cdvarritmo07= oUltivar.getCdVarRitmo07();
		this.dsvarritmo07= oUltivar.getDsVarRitmo07();
		this.perc07= oUltivar.getPerc07();
		this.cdvarritmo08= oUltivar.getCdVarRitmo08(); 
		this.dsvarritmo08= oUltivar.getDsVarRitmo08();
		this.perc08=oUltivar.getPerc08();
		setIsComVariacaoRitmoInformada(true);
	}
	
	public void getUltimaVariacaoRitmoInformada(PrUpUltimaVariacaoRitmo oVar) 
	{	
		if(oVar==null)
			oVar = new PrUpUltimaVariacaoRitmo();
		oVar.setVariacaoRitmo(this.variacaoritmo);
		oVar.setIdVariacaoRitmoInjet(this.idvariacaoritmoinjet);
		oVar.setDtHrIni(this.dthrini);
		oVar.setDtHrFim(this.dthrfim);
		oVar.setCdVarRitmo01(this.cdvarritmo01);
		oVar.setDsVarRitmo01(this.dsvarritmo01);
		oVar.setPerc01(this.perc01);	
		oVar.setCdVarRitmo02(this.cdvarritmo02);
		oVar.setDsVarRitmo02(this.dsvarritmo02);
		oVar.setPerc02(this.perc02);
		oVar.setCdVarRitmo03(this.cdvarritmo03);
		oVar.setDsVarRitmo03(this.dsvarritmo03);
		oVar.setPerc03(this.perc03);
		oVar.setCdVarRitmo04(this.cdvarritmo04);
		oVar.setDsVarRitmo04(this.dsvarritmo04);
		oVar.setPerc04(this.perc04);
		oVar.setCdVarRitmo05(this.cdvarritmo05);
		oVar.setDsVarRitmo05(this.dsvarritmo05);
		oVar.setPerc05(this.perc05);
		oVar.setCdVarRitmo06(this.cdvarritmo06);
		oVar.setDsVarRitmo06(this.dsvarritmo06);
		oVar.setPerc06(this.perc06);
		oVar.setCdVarRitmo07(this.cdvarritmo07);
		oVar.setDsVarRitmo07(this.dsvarritmo07);
		oVar.setPerc07(this.perc07);
		oVar.setCdVarRitmo08(this.cdvarritmo08);
		oVar.setDsVarRitmo08(this.dsvarritmo08);
		oVar.setPerc08(this.perc08);		
	}
}
