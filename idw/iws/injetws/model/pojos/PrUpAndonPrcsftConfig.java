package injetws.model.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "PR_UP_ANDON_PRCSFT_CONFIG")
public class PrUpAndonPrcsftConfig implements java.io.Serializable {
	
    private String idConfiguracaoANDON;		// VARCHAR(36) NOT NULL,
    //private idSequence;						// decimal(30,) IDENTITY(1,1),
    private String idup;							// VARCHAR(36) NOT NULL,
    private String idEventosBridgeCollecDb;	// VARCHAR(36) NOT NULL,
    private String stRele6;						// CHAR(1) NOT NULL,
    private Integer tmpRele6Lig;					// int NOT NULL,
    private Integer tmpRele6Des;					// int NOT NULL,
    private String stRele7;						// CHAR(1) NOT NULL,
    private Double tmpLimParNaoInf;				// FLOAT NOT NULL,
    private Integer tmpRele7Lig;					// int NOT NULL,
    private Integer tmpRele7Des;					// int NOT NULL,
    private String stRele8;						// CHAR(1) NOT NULL,
    private Double vlRefEficUltCiclo;				// FLOAT NOT NULL,
    private Integer tmpRele8Lig;					// int NOT NULL,
    private Integer tmpRele8Des;					// int NOT NULL
    private String stRele7SldZero;				 // CHAR(1) NOT NULL,
    private Integer tmpRele7LigSldZero;			// int NOT NULL,
    private Integer tmpRele7DesSldZero;			// int NOT NULL,
	
    
	public PrUpAndonPrcsftConfig(String idConfiguracaoANDON, String idup,
			String idEventosBridgeCollecDb, String stRele6,
			Integer tmpRele6Lig, Integer tmpRele6Des, String stRele7,
			Double tmpLimParNaoInf, Integer tmpRele7Lig, Integer tmpRele7Des,
			String stRele8, Double vlRefEficUltCiclo, Integer tmpRele8Lig,
			Integer tmpRele8Des,String stRele7SldZero,Integer tmpRele7LigSldZero,
			Integer tmpRele7DesSldZero) {
		this.idConfiguracaoANDON = idConfiguracaoANDON;
		this.idup = idup;
		this.idEventosBridgeCollecDb = idEventosBridgeCollecDb;
		this.stRele6 = stRele6;
		this.tmpRele6Lig = tmpRele6Lig;
		this.tmpRele6Des = tmpRele6Des;
		this.stRele7 = stRele7;
		this.tmpLimParNaoInf = tmpLimParNaoInf;
		this.tmpRele7Lig = tmpRele7Lig;
		this.tmpRele7Des = tmpRele7Des;
		this.stRele8 = stRele8;
		this.vlRefEficUltCiclo = vlRefEficUltCiclo;
		this.tmpRele8Lig = tmpRele8Lig;
		this.tmpRele8Des = tmpRele8Des;
		this.stRele7SldZero = stRele7SldZero;
		this.tmpRele7LigSldZero= tmpRele7LigSldZero;
		this.tmpRele7DesSldZero= tmpRele7DesSldZero;
	}
	
	public PrUpAndonPrcsftConfig() {
	}
	
	
	@Id
	@Column(name = "IDCONFIGURACAOANDON", unique = true, nullable = false, length = 36)
	public String getidConfiguracaoANDON() {
		return(this.idConfiguracaoANDON);
	}
	public void setidConfiguracaoANDON(String idConfiguracaoANDON) {
		this.idConfiguracaoANDON = idConfiguracaoANDON;
	}
	
    
	@Column(name = "IDUP", nullable = true, length = 36)
	public String getidup() {
		return(this.idup);
	}
	public void setidup(String idup) {
		this.idup = idup;
	}
	
    
	@Column(name = "IDEVENTOMASTERBRIDGECOLLECTODB", nullable = false, length = 36)
	public String getidEventosBridgeCollecDb() {
		return(this.idEventosBridgeCollecDb);
	}
	public void setidEventosBridgeCollecDb(String idEventosBridgeCollecDb) {
		this.idEventosBridgeCollecDb = idEventosBridgeCollecDb;
	}
	
    
	@Column(name = "StRele6", nullable = false, length = 1)
	public String getstRele6() {
		return(this.stRele6);
	}
	public void setstRele6(String stRele6) {
		this.stRele6 = stRele6;
	}
	
    
	@Column(name = "TmpRele6Lig", nullable = false, length = 10)
	public Integer gettmpRele6Lig() {
		return(this.tmpRele6Lig);
	}
	public void settmpRele6Lig(Integer tmpRele6Lig) {
		this.tmpRele6Lig = tmpRele6Lig;
	}
	
    
	@Column(name = "TmpRele6Des", nullable = false, length = 10)
	public Integer gettmpRele6Des() {
		return(this.tmpRele6Des);
	}
	public void settmpRele6Des(Integer tmpRele6Des) {
		this.tmpRele6Des = tmpRele6Des;
	}
	
    
	@Column(name = "StRele7", nullable = false, length = 1)
	public String getstRele7() {
		return(this.stRele7);
	}
	public void setstRele7(String stRele7) {
		this.stRele7 = stRele7;
	}
	
    
	@Column(name = "TmpLimParNaoInf", nullable = false, precision = 126, scale = 0)
	public Double gettmpLimParNaoInf() {
		return(this.tmpLimParNaoInf);
	}
	public void settmpLimParNaoInf(Double tmpLimParNaoInf) {
		this.tmpLimParNaoInf = tmpLimParNaoInf;
	}
	
    
	@Column(name = "TmpRele7Lig", nullable = false, length = 10)
	public Integer gettmpRele7Lig() {
		return(this.tmpRele7Lig);
	}
	public void settmpRele7Lig(Integer tmpRele7Lig) {
		this.tmpRele7Lig = tmpRele7Lig;
	}
	
    
	@Column(name = "TmpRele7Des", nullable = false, length = 10)
	public Integer gettmpRele7Des() {
		return(this.tmpRele7Des);
	}
	public void settmpRele7Des(Integer tmpRele7Des) {
		this.tmpRele7Des = tmpRele7Des;
	}
	
    
	@Column(name = "StRele8", nullable = false, length = 1)
	public String getstRele8() {
		return(this.stRele8);
	}
	public void setstRele8(String stRele8) {
		this.stRele8 = stRele8;
	}
	
    
	@Column(name = "VlRefEficUltCiclo", nullable = false, precision = 126, scale = 0)
	public Double getvlRefEficUltCiclo() {
		return(this.vlRefEficUltCiclo);
	}
	public void setvlRefEficUltCiclo(Double vlRefEficUltCiclo) {
		this.vlRefEficUltCiclo = vlRefEficUltCiclo;
	}
	
    
	@Column(name = "TmpRele8Lig", nullable = false, length = 10)
	public Integer gettmpRele8Lig() {
		return(this.tmpRele8Lig);
	}
	public void settmpRele8Lig(Integer tmpRele8Lig) {
		this.tmpRele8Lig = tmpRele8Lig;
	}
	
    
	@Column(name = "TmpRele8Des", nullable = false, length = 10)
	public Integer gettmpRele8Des() {
		return(this.tmpRele8Des);
	}
	public void settmpRele8Des(Integer tmpRele8Des) {
		this.tmpRele8Des = tmpRele8Des;
	}
	
	@Column(name = "stRele7SldZero", nullable = true, length = 1)
	public String getstRele7SldZero() {
		return(this.stRele7SldZero);
	}
	public void setstRele7SldZero(String stRele7SldZero) {
		this.stRele7SldZero = stRele7SldZero;
	}
	
    
	@Column(name = "TmpRele7LigSldZero", nullable = true, length = 10)
	public Integer gettmpRele7LigSldZero() {
		return(this.tmpRele7LigSldZero);
	}
	public void settmpRele7LigSldZero(Integer tmpRele7LigSldZero) {
		this.tmpRele7LigSldZero = tmpRele7LigSldZero;
	}
	
    
	@Column(name = "tmpRele7DesSldZero", nullable = true, length = 10)
	public Integer gettmpRele7DesSldZero() {
		return(this.tmpRele7DesSldZero);
	}
	public void settmpRele7DesSldZero(Integer tmpRele7DesSldZero) {
		this.tmpRele7DesSldZero = tmpRele7DesSldZero;
	}
	
	
}
