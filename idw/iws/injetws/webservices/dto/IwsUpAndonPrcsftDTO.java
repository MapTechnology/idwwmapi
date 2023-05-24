package injetws.webservices.dto;

import java.io.Serializable;

import injetws.model.pojos.PrUpAndonPrcsft;
import idw.model.pojos.injet.Ijtbinjandonprcsft;

@SuppressWarnings("serial")
public class IwsUpAndonPrcsftDTO implements Serializable {
	
	private String idup;
    private String stRele6;
    private Integer tmpRele6Lig;
    private Integer tmpRele6Des;
    private String stRele7;
    private Double tmpLimParNaoInf;
    private Integer tmpRele7Lig;
    private Integer tmpRele7Des;
    private String stRele8;
    private Double vlRefEficUltCiclo;
    private Integer tmpRele8Lig;
    private Integer tmpRele8Des;
    private Boolean deveSetarLimitePar;
    private Boolean deveSetarRefEfic;   
    private String stRele7SldZero;				 
    private Integer tmpRele7LigSldZero;			
    private Integer tmpRele7DesSldZero;
    
	private Boolean erro;
    
	
	public String getidup() {
		return(this.idup);
	}
	public void setidup(String idup) {
		this.idup = idup;
	}

	public String getstRele7SldZero() {
		return(this.stRele7SldZero);
	}
	public void setstRele7SldZero(String stRele7SldZero) {
		this.stRele7SldZero = stRele7SldZero;
	}
	
    
	public Integer gettmpRele7LigSldZero() {
		return(this.tmpRele7LigSldZero);
	}
	public void settmpRele7LigSldZero(Integer tmpRele7LigSldZero) {
		this.tmpRele7LigSldZero = tmpRele7LigSldZero;
	}
	
    
	public Integer gettmpRele7DesSldZero() {
		return(this.tmpRele7DesSldZero);
	}
	public void settmpRele7DesSldZero(Integer tmpRele7DesSldZero) {
		this.tmpRele7DesSldZero = tmpRele7DesSldZero;
	}
	

	public String getstRele6() {
		return(this.stRele6);
	}
	public void setstRele6(String stRele6) {
		this.stRele6 = stRele6;
	}
	
    
	public Integer gettmpRele6Lig() {
		return(this.tmpRele6Lig);
	}
	public void settmpRele6Lig(Integer tmpRele6Lig) {
		this.tmpRele6Lig = tmpRele6Lig;
	}
	
    
	public Integer gettmpRele6Des() {
		return(this.tmpRele6Des);
	}
	public void settmpRele6Des(Integer tmpRele6Des) {
		this.tmpRele6Des = tmpRele6Des;
	}
	
    
	public String getstRele7() {
		return(this.stRele7);
	}
	public void setstRele7(String stRele7) {
		this.stRele7 = stRele7;
	}
	
    
	public Double gettmpLimParNaoInf() {
		return(this.tmpLimParNaoInf);
	}
	public void settmpLimParNaoInf(Double tmpLimParNaoInf) {
		this.tmpLimParNaoInf = tmpLimParNaoInf;
	}
	
    
	public Integer gettmpRele7Lig() {
		return(this.tmpRele7Lig);
	}
	public void settmpRele7Lig(Integer tmpRele7Lig) {
		this.tmpRele7Lig = tmpRele7Lig;
	}
	
    
	public Integer gettmpRele7Des() {
		return(this.tmpRele7Des);
	}
	public void settmpRele7Des(Integer tmpRele7Des) {
		this.tmpRele7Des = tmpRele7Des;
	}
	
    
	public String getstRele8() {
		return(this.stRele8);
	}
	public void setstRele8(String stRele8) {
		this.stRele8 = stRele8;
	}
	
    
	public Double getvlRefEficUltCiclo() {
		return(this.vlRefEficUltCiclo);
	}
	public void setvlRefEficUltCiclo(Double vlRefEficUltCiclo) {
		this.vlRefEficUltCiclo = vlRefEficUltCiclo;
	}
	
    
	public Integer gettmpRele8Lig() {
		return(this.tmpRele8Lig);
	}
	public void settmpRele8Lig(Integer tmpRele8Lig) {
		this.tmpRele8Lig = tmpRele8Lig;
	}
	
    
	public Integer gettmpRele8Des() {
		return(this.tmpRele8Des);
	}
	public void settmpRele8Des(Integer tmpRele8Des) {
		this.tmpRele8Des = tmpRele8Des;
	}
	 
	public Boolean getdeveSetarLimitePar() {
		return deveSetarLimitePar;
	}	

	public void setdeveSetarLimitePar(Boolean deveSetarLimitePar) {
		this.deveSetarLimitePar = deveSetarLimitePar;
	}
	
	public Boolean getdeveSetarRefEfic() {
		return deveSetarRefEfic;
	}	

	public void setdeveSetarRefEfic(Boolean deveSetarRefEfic) {
		this.deveSetarRefEfic = deveSetarRefEfic;
	}
	
	
	public Boolean geterro() {
		return erro;
	}	

	public void seterro(Boolean erro) {
		this.erro = erro;
	}
	
	public void copyPrUpAndonPrcsft(PrUpAndonPrcsft prupandonprcsft) {
		this.idup = prupandonprcsft.getidup();
		this.stRele6 = prupandonprcsft.getstRele6();
		this.tmpRele6Lig = prupandonprcsft.gettmpRele6Lig();
		this.tmpRele6Des = prupandonprcsft.gettmpRele6Des();
		this.stRele7 = prupandonprcsft.getstRele7();
		if(prupandonprcsft.gettmpLimParNaoInf() != null)this.deveSetarLimitePar=true;
		this.tmpLimParNaoInf = prupandonprcsft.gettmpLimParNaoInf();
		this.tmpRele7Lig = prupandonprcsft.gettmpRele7Lig();
		this.tmpRele7Des = prupandonprcsft.gettmpRele7Des();
		this.stRele8 = prupandonprcsft.getstRele8();
		if(prupandonprcsft.getvlRefEficUltCiclo() != null)this.deveSetarRefEfic=true;
		this.vlRefEficUltCiclo = prupandonprcsft.getvlRefEficUltCiclo();
		this.tmpRele8Lig = prupandonprcsft.gettmpRele8Lig();
		this.tmpRele8Des = prupandonprcsft.gettmpRele8Des();
		this.stRele7SldZero =prupandonprcsft.getstRele7SldZero();
		this.tmpRele7DesSldZero=prupandonprcsft.gettmpRele7DesSldZero();
		this.tmpRele7LigSldZero=prupandonprcsft.gettmpRele7LigSldZero();		
	}

	public void copyIjandonprcsft(Ijtbinjandonprcsft ijtbinjandonprcsft) {
		this.idup = ijtbinjandonprcsft.getCdinjetora();
		this.stRele6 = ijtbinjandonprcsft.getStrele6()+"";
		this.tmpRele6Lig = ijtbinjandonprcsft.getTmprele6lig().intValue();
		this.tmpRele6Des = ijtbinjandonprcsft.getTmprele6des().intValue();
		this.stRele7 = ijtbinjandonprcsft.getStrele7()+"";
		this.deveSetarLimitePar=true;
		this.tmpLimParNaoInf = ijtbinjandonprcsft.getTmplimparnaoinf();
		this.tmpRele7Lig = ijtbinjandonprcsft.getTmprele7lig().intValue();
		this.tmpRele7Des = ijtbinjandonprcsft.getTmprele7des().intValue();
		this.stRele8 = ijtbinjandonprcsft.getStrele8()+"";
		this.deveSetarRefEfic=true;
		this.vlRefEficUltCiclo = ijtbinjandonprcsft.getVlrefeficultciclo();
		this.tmpRele8Lig = ijtbinjandonprcsft.getTmprele8lig().intValue();
		this.tmpRele8Des = ijtbinjandonprcsft.getTmprele8des().intValue();
	}

}