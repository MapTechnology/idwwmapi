package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.Date;

public class MapaCPDetDTO 
{
	private String cdCp;
	private String NrDoc;
	
	// tempos em segundos
	private BigDecimal segHrsTrab = BigDecimal.ZERO;
	private BigDecimal segHrsParCP = BigDecimal.ZERO;
	private BigDecimal segHrsParSP = BigDecimal.ZERO;
	private BigDecimal segHrsDisp = BigDecimal.ZERO;
	private BigDecimal segHrsTot = BigDecimal.ZERO;

	// qtd na unidade básica
	private BigDecimal qtdPlan = BigDecimal.ZERO;
	private BigDecimal qtdPrev = BigDecimal.ZERO;
	private BigDecimal qtdProdBruta = BigDecimal.ZERO;
	private BigDecimal qtdProdRef = BigDecimal.ZERO;
	private BigDecimal qtdProdLiq = BigDecimal.ZERO;
	private BigDecimal qtdProdReg = BigDecimal.ZERO; 
	private BigDecimal qtdSaldoProd = BigDecimal.ZERO;
	
	// qtd em Kg
	private BigDecimal qtdPlanKg = BigDecimal.ZERO;
	private BigDecimal qtdPrevKg = BigDecimal.ZERO;
	private BigDecimal qtdProdBrutaKg = BigDecimal.ZERO;
	private BigDecimal qtdProdRefKg = BigDecimal.ZERO;
	private BigDecimal qtdProdLiqKg = BigDecimal.ZERO;
	private BigDecimal qtdProdRegKg = BigDecimal.ZERO;
	private BigDecimal qtdSaldoProdKg = BigDecimal.ZERO;
	
	// qtd em Ton
	private BigDecimal qtdPlanTon = BigDecimal.ZERO;
	private BigDecimal qtdPrevTon = BigDecimal.ZERO;
	private BigDecimal qtdProdBrutaTon = BigDecimal.ZERO;
	private BigDecimal qtdProdRefTon = BigDecimal.ZERO;
	private BigDecimal qtdProdLiqTon = BigDecimal.ZERO;
	private BigDecimal qtdProdRegTon = BigDecimal.ZERO;
	private BigDecimal qtdSaldoProdTon = BigDecimal.ZERO;
	
    // qtd em segundos
    private BigDecimal qtdPlanSeg = BigDecimal.ZERO;     
    private BigDecimal qtdPrevSeg = BigDecimal.ZERO;
    private BigDecimal qtdProdBrutaSeg = BigDecimal.ZERO;
    private BigDecimal qtdProdRefSeg = BigDecimal.ZERO;
    private BigDecimal qtdProdLiqSeg = BigDecimal.ZERO;
    private BigDecimal qtdProdRegSeg = BigDecimal.ZERO;
    private BigDecimal qtdSaldoProdSeg = BigDecimal.ZERO;

	
	// índices
	private BigDecimal indPar = BigDecimal.ZERO;
	private BigDecimal indRef = BigDecimal.ZERO;
	private BigDecimal efiRea = BigDecimal.ZERO;
	private BigDecimal efiCic = BigDecimal.ZERO;
	private BigDecimal indAtend = BigDecimal.ZERO; 

	// ciclo padr�o e médio
	private BigDecimal segCicloPadrao = BigDecimal.ZERO;
	private BigDecimal segCicloMedio = BigDecimal.ZERO;

	// datas de referencias (menor e maior)
	private Date dtTurnoMin;
	private Date dtTurnoMax;
	
	
	
	
	public BigDecimal getSegHrsTrab() {
		return segHrsTrab;
	}
	public void setSegHrsTrab(BigDecimal segHrsTrab) {
		this.segHrsTrab = segHrsTrab;
	}
	public BigDecimal getSegHrsParCP() {
		return segHrsParCP;
	}
	public void setSegHrsParCP(BigDecimal segHrsParCP) {
		this.segHrsParCP = segHrsParCP;
	}
	public BigDecimal getSegHrsParSP() {
		return segHrsParSP;
	}
	public void setSegHrsParSP(BigDecimal segHrsParSP) {
		this.segHrsParSP = segHrsParSP;
	}
	public BigDecimal getSegHrsDisp() {
		return segHrsDisp;
	}
	public void setSegHrsDisp(BigDecimal segHrsDisp) {
		this.segHrsDisp = segHrsDisp;
	}
	public BigDecimal getSegHrsTot() {
		return segHrsTot;
	}
	public void setSegHrsTot(BigDecimal segHrsTot) {
		this.segHrsTot = segHrsTot;
	}
	public BigDecimal getQtdPlan() {
		return qtdPlan;
	}
	public void setQtdPlan(BigDecimal qtdPlan) {
		this.qtdPlan = qtdPlan;
	}
	public BigDecimal getQtdPrev() {
		return qtdPrev;
	}
	public void setQtdPrev(BigDecimal qtdPrev) {
		this.qtdPrev = qtdPrev;
	}
	public BigDecimal getQtdProdBruta() {
		return qtdProdBruta;
	}
	public void setQtdProdBruta(BigDecimal qtdProdBruta) {
		this.qtdProdBruta = qtdProdBruta;
	}
	public BigDecimal getQtdProdRef() {
		return qtdProdRef;
	}
	public void setQtdProdRef(BigDecimal qtdProdRef) {
		this.qtdProdRef = qtdProdRef;
	}
	public BigDecimal getQtdProdLiq() {
		return qtdProdLiq;
	}
	public void setQtdProdLiq(BigDecimal qtdProdLiq) {
		this.qtdProdLiq = qtdProdLiq;
	}
	public BigDecimal getQtdProdReg() {
		return qtdProdReg;
	}
	public void setQtdProdReg(BigDecimal qtdProdReg) {
		this.qtdProdReg = qtdProdReg;
	}
	public BigDecimal getQtdSaldoProd() {
		return qtdSaldoProd;
	}
	public void setQtdSaldoProd(BigDecimal qtdSaldoProd) {
		this.qtdSaldoProd = qtdSaldoProd;
	}
	public BigDecimal getQtdPlanKg() {
		return qtdPlanKg;
	}
	public void setQtdPlanKg(BigDecimal qtdPlanKg) {
		this.qtdPlanKg = qtdPlanKg;
	}
	public BigDecimal getQtdPrevKg() {
		return qtdPrevKg;
	}
	public void setQtdPrevKg(BigDecimal qtdPrevKg) {
		this.qtdPrevKg = qtdPrevKg;
	}
	public BigDecimal getQtdProdBrutaKg() {
		return qtdProdBrutaKg;
	}
	public void setQtdProdBrutaKg(BigDecimal qtdProdBrutaKg) {
		this.qtdProdBrutaKg = qtdProdBrutaKg;
	}
	public BigDecimal getQtdProdRefKg() {
		return qtdProdRefKg;
	}
	public void setQtdProdRefKg(BigDecimal qtdProdRefKg) {
		this.qtdProdRefKg = qtdProdRefKg;
	}
	public BigDecimal getQtdProdLiqKg() {
		return qtdProdLiqKg;
	}
	public void setQtdProdLiqKg(BigDecimal qtdProdLiqKg) {
		this.qtdProdLiqKg = qtdProdLiqKg;
	}
	public BigDecimal getQtdProdRegKg() {
		return qtdProdRegKg;
	}
	public void setQtdProdRegKg(BigDecimal qtdProdRegKg) {
		this.qtdProdRegKg = qtdProdRegKg;
	}
	public BigDecimal getQtdSaldoProdKg() {
		return qtdSaldoProdKg;
	}
	public void setQtdSaldoProdKg(BigDecimal qtdSaldoProdKg) {
		this.qtdSaldoProdKg = qtdSaldoProdKg;
	}
	public BigDecimal getQtdPlanTon() {
		return qtdPlanTon;
	}
	public void setQtdPlanTon(BigDecimal qtdPlanTon) {
		this.qtdPlanTon = qtdPlanTon;
	}
	public BigDecimal getQtdPrevTon() {
		return qtdPrevTon;
	}
	public void setQtdPrevTon(BigDecimal qtdPrevTon) {
		this.qtdPrevTon = qtdPrevTon;
	}
	public BigDecimal getQtdProdBrutaTon() {
		return qtdProdBrutaTon;
	}
	public void setQtdProdBrutaTon(BigDecimal qtdProdBrutaTon) {
		this.qtdProdBrutaTon = qtdProdBrutaTon;
	}
	public BigDecimal getQtdProdRefTon() {
		return qtdProdRefTon;
	}
	public void setQtdProdRefTon(BigDecimal qtdProdRefTon) {
		this.qtdProdRefTon = qtdProdRefTon;
	}
	public BigDecimal getQtdProdLiqTon() {
		return qtdProdLiqTon;
	}
	public void setQtdProdLiqTon(BigDecimal qtdProdLiqTon) {
		this.qtdProdLiqTon = qtdProdLiqTon;
	}
	public BigDecimal getQtdProdRegTon() {
		return qtdProdRegTon;
	}
	public void setQtdProdRegTon(BigDecimal qtdProdRegTon) {
		this.qtdProdRegTon = qtdProdRegTon;
	}
	public BigDecimal getQtdSaldoProdTon() {
		return qtdSaldoProdTon;
	}
	public void setQtdSaldoProdTon(BigDecimal qtdSaldoProdTon) {
		this.qtdSaldoProdTon = qtdSaldoProdTon;
	}
	
	
	
	public BigDecimal getQtdPlanSeg() {
        return qtdPlanSeg;
    }
    public void setQtdPlanSeg(BigDecimal qtdPlanSeg) {
        this.qtdPlanSeg = qtdPlanSeg;
    }
    public BigDecimal getQtdPrevSeg() {
        return qtdPrevSeg;
    }
    public void setQtdPrevSeg(BigDecimal qtdPrevSeg) {
        this.qtdPrevSeg = qtdPrevSeg;
    }
    public BigDecimal getQtdProdBrutaSeg() {
        return qtdProdBrutaSeg;
    }
    public void setQtdProdBrutaSeg(BigDecimal qtdProdBrutaSeg) {
        this.qtdProdBrutaSeg = qtdProdBrutaSeg;
    }
    public BigDecimal getQtdProdRefSeg() {
        return qtdProdRefSeg;
    }
    public void setQtdProdRefSeg(BigDecimal qtdProdRefSeg) {
        this.qtdProdRefSeg = qtdProdRefSeg;
    }
    public BigDecimal getQtdProdLiqSeg() {
        return qtdProdLiqSeg;
    }
    public void setQtdProdLiqSeg(BigDecimal qtdProdLiqSeg) {
        this.qtdProdLiqSeg = qtdProdLiqSeg;
    }
    public BigDecimal getQtdProdRegSeg() {
        return qtdProdRegSeg;
    }
    public void setQtdProdRegSeg(BigDecimal qtdProdRegSeg) {
        this.qtdProdRegSeg = qtdProdRegSeg;
    }
    public BigDecimal getQtdSaldoProdSeg() {
        return qtdSaldoProdSeg;
    }
    public void setQtdSaldoProdSeg(BigDecimal qtdSaldoProdSeg) {
        this.qtdSaldoProdSeg = qtdSaldoProdSeg;
    }
    public BigDecimal getIndPar() {
		return indPar;
	}
	public void setIndPar(BigDecimal indPar) {
		this.indPar = indPar;
	}
	public BigDecimal getIndRef() {
		return indRef;
	}
	public void setIndRef(BigDecimal indRef) {
		this.indRef = indRef;
	}
	public BigDecimal getEfiRea() {
		return efiRea;
	}
	public void setEfiRea(BigDecimal efiRea) {
		this.efiRea = efiRea;
	}
	public BigDecimal getEfiCic() {
		return efiCic;
	}
	public void setEfiCic(BigDecimal efiCic) {
		this.efiCic = efiCic;
	}
	public BigDecimal getIndAtend() {
		return indAtend;
	}
	public void setIndAtend(BigDecimal indAtend) {
		this.indAtend = indAtend;
	}
	public BigDecimal getSegCicloPadrao() {
		return segCicloPadrao;
	}
	public void setSegCicloPadrao(BigDecimal segCicloPadrao) {
		this.segCicloPadrao = segCicloPadrao;
	}
	public BigDecimal getSegCicloMedio() {
		return segCicloMedio;
	}
	public void setSegCicloMedio(BigDecimal segCicloMedio) {
		this.segCicloMedio = segCicloMedio;
	}
	public Date getDtTurnoMin() {
		return dtTurnoMin;
	}
	public void setDtTurnoMin(Date dtTurnoMin) {
		this.dtTurnoMin = dtTurnoMin;
	}
	public Date getDtTurnoMax() {
		return dtTurnoMax;
	}
	public void setDtTurnoMax(Date dtTurnoMax) {
		this.dtTurnoMax = dtTurnoMax;
	}

	
	public String getNrDoc() {
		return NrDoc;
	}
	public void setNrDoc(String nrDoc) {
		NrDoc = nrDoc;
	}
	public String getCdCp() {
		return cdCp;
	}
	public void setCdCp(String cdCp) {
		this.cdCp = cdCp;
	}
}
