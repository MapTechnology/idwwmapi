/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import idw.model.pojos.DwRap;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;


/**
 *
 * @author sardinha
 */
@SuppressWarnings("serial")
public class ProdutoResumoFichaMaqDTO implements Serializable {
	private OmPt maquina;
	private DwRap ferramenta; 
	private OmProduto produto;
	private BigDecimal pcsProducaoRefugada;
	private BigDecimal pcsProducaobruta;
	private BigDecimal pcsProducaoliquida;
	private BigDecimal metaInstantanea;
	private BigDecimal eficiencia;
	private BigDecimal aproduzir;
	private BigDecimal estoqueProducao;
	private BigDecimal qtdAtiva;
	private BigDecimal tempoAtivo;
	private BigDecimal pcsPlanejadas;
	private BigDecimal indProducao;
	
		
	public BigDecimal getQtdAtiva() {
		return qtdAtiva;
	}

	public void setQtdAtiva(BigDecimal qtdAtiva) {
		this.qtdAtiva = qtdAtiva;
	}

	public BigDecimal getTempoAtivo() {
		return tempoAtivo;
	}

	public void setTempoAtivo(BigDecimal tempoAtivo) {
		this.tempoAtivo = tempoAtivo;
	}

	public BigDecimal getEstoqueProducao() {
		return estoqueProducao;
	}

	public void setEstoqueProducao(BigDecimal estoqueProducao) {
		this.estoqueProducao = estoqueProducao;
	}
	

	/**
     * @return the produto
     */
    public OmProduto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(OmProduto produto) {
        this.produto = produto;
    }

		
	public BigDecimal getPcsProducaoRefugada() {
		return pcsProducaoRefugada;
	}

	public void setPcsProducaoRefugada(BigDecimal pcsProducaoRefugada) {
		this.pcsProducaoRefugada = pcsProducaoRefugada;
	}

	public BigDecimal getPcsProducaobruta() {
		return pcsProducaobruta;
	}

	public void setPcsProducaobruta(BigDecimal pcsProducaobruta) {
		this.pcsProducaobruta = pcsProducaobruta;
	}

	public void setMetaInstantanea(BigDecimal metaInstantanea) {
		this.metaInstantanea = metaInstantanea;
	}

	public BigDecimal getMetaInstantanea() {
		return metaInstantanea;
	}

	public void setEficiencia(BigDecimal eficiencia) {
		this.eficiencia = eficiencia;
	}

	public BigDecimal getEficiencia() {
		return eficiencia;
	}

	public void setAproduzir(BigDecimal aproduzir) {
		this.aproduzir = aproduzir;
	}

	public BigDecimal getAproduzir() {
		return aproduzir;
	}

	public BigDecimal getPcsProducaoliquida() {
		return pcsProducaoliquida;
	}

	public void setPcsProducaoliquida(BigDecimal pcsProducaoliquida) {
		this.pcsProducaoliquida = pcsProducaoliquida;
	}

	public DwRap getFerramenta() {
		return ferramenta;
	}

	public void setFerramenta(DwRap ferramenta) {
		this.ferramenta = ferramenta;
	}

	public OmPt getMaquina() {
		return maquina;
	}

	public void setMaquina(OmPt maquina) {
		this.maquina = maquina;
	}

	public BigDecimal getPcsPlanejadas() {
		return pcsPlanejadas;
	}

	public void setPcsPlanejadas(BigDecimal pcsPlanejadas) {
		this.pcsPlanejadas = pcsPlanejadas;
	}

	public BigDecimal getIndProducao() {
		return indProducao;
	}

	public void setIndProducao(BigDecimal indProducao) {
		this.indProducao = indProducao;
	}
}