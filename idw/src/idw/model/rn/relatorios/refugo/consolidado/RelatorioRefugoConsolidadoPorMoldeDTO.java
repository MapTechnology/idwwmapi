package idw.model.rn.relatorios.refugo.consolidado;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RelatorioRefugoConsolidadoPorMoldeDTO {
    
    private List<RelatorioRefugoConsolidadoPorMoldeDTO> lista = new ArrayList<>();

    private String ferramenta;
    private String posto;
    private String cicloPadrao;
    private String produto;
    
    private BigDecimal cicloMedio;
    private BigDecimal cavidade;
    
    private BigDecimal pecasProduzidas;
    private BigDecimal pecasRefugadas;
    private BigDecimal pecasBoas;
    private BigDecimal indiceRef;
    private BigDecimal perdasSeg;
    
    public List<RelatorioRefugoConsolidadoPorMoldeDTO> getLista() {
        return lista;
    }
    public void setLista(List<RelatorioRefugoConsolidadoPorMoldeDTO> lista) {
        this.lista = lista;
    }
    public String getFerramenta() {
        return ferramenta;
    }
    public void setFerramenta(String ferramenta) {
        this.ferramenta = ferramenta;
    }
    public String getPosto() {
        return posto;
    }
    public void setPosto(String posto) {
        this.posto = posto;
    }
    public String getCicloPadrao() {
        return cicloPadrao;
    }
    public void setCicloPadrao(String cicloPadrao) {
        this.cicloPadrao = cicloPadrao;
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public BigDecimal getCicloMedio() {
        return cicloMedio;
    }
    public void setCicloMedio(BigDecimal cicloMedio) {
        this.cicloMedio = cicloMedio;
    }
    public BigDecimal getCavidade() {
        return cavidade;
    }
    public void setCavidade(BigDecimal cavidade) {
        this.cavidade = cavidade;
    }
    public BigDecimal getPecasProduzidas() {
        return pecasProduzidas;
    }
    public void setPecasProduzidas(BigDecimal pecasProduzidas) {
        this.pecasProduzidas = pecasProduzidas;
    }
    public BigDecimal getPecasRefugadas() {
        return pecasRefugadas;
    }
    public void setPecasRefugadas(BigDecimal pecasRefugadas) {
        this.pecasRefugadas = pecasRefugadas;
    }
    public BigDecimal getPecasBoas() {
        return pecasBoas;
    }
    public void setPecasBoas(BigDecimal pecasBoas) {
        this.pecasBoas = pecasBoas;
    }
	public BigDecimal getIndiceRef() {
		return indiceRef;
	}
	public void setIndiceRef(BigDecimal indiceRef) {
		this.indiceRef = indiceRef;
	}
	public BigDecimal getPerdasSeg() {
		return perdasSeg;
	}
	public void setPerdasSeg(BigDecimal perdasSeg) {
		this.perdasSeg = perdasSeg;
	}
    
}
