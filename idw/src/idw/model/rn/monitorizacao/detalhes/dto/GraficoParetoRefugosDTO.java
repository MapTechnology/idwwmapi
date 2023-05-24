package idw.model.rn.monitorizacao.detalhes.dto;

import java.util.ArrayList;
import java.util.List;

import idw.webservices.dto.ProdutoDTO;

public class GraficoParetoRefugosDTO {

	private String cdRefugo;
	private String dsRefugo;
	private Double qtdRefugada;
	private Double indiceRefugo;
	private String corBarra;
	private String corHexa;
	private Long idTRefugo;
	
	private Double indiceRefugoGr;
    private Double qtdRefugadaKg;
	private Double qtdRefugadaTon;
	
	// Esse atributo serve para guardar os refugos separados por produto
	private List<ProdutoDTO> refugosPorProduto = new ArrayList<>();
		
	
	public String getCdRefugo() {
		return cdRefugo;
	}
	public void setCdRefugo(String cdRefugo) {
		this.cdRefugo = cdRefugo;
	}
	public String getDsRefugo() {
		return dsRefugo;
	}
	public void setDsRefugo(String dsRefugo) {
		this.dsRefugo = dsRefugo;
	}
	public Double getQtdRefugada() {
		return qtdRefugada;
	}
	public void setQtdRefugada(Double qtdRefugada) {
		this.qtdRefugada = qtdRefugada;
	}
	public Double getIndiceRefugo() {
		return indiceRefugo;
	}
	public void setIndiceRefugo(Double indiceRefugo) {
		this.indiceRefugo = indiceRefugo;
	}
	public String getCorBarra() {
		return corBarra;
	}
	public void setCorBarra(String corBarra) {
		this.corBarra = corBarra;
	}
	public Long getIdTRefugo() {
		return idTRefugo;
	}
	public void setIdTRefugo(Long idTRefugo) {
		this.idTRefugo = idTRefugo;
	}
	public List<ProdutoDTO> getRefugosPorProduto() {
		return refugosPorProduto;
	}
	public void setRefugosPorProduto(List<ProdutoDTO> refugosPorProduto) {
		this.refugosPorProduto = refugosPorProduto;
	}
    public Double getQtdRefugadaKg() {
        return qtdRefugadaKg;
    }
    public void setQtdRefugadaKg(Double qtdRefugadaKg) {
        this.qtdRefugadaKg = qtdRefugadaKg;
    }
    public Double getQtdRefugadaTon() {
        return qtdRefugadaTon;
    }
    public void setQtdRefugadaTon(Double qtdRefugadaTon) {
        this.qtdRefugadaTon = qtdRefugadaTon;
    }
	public Double getIndiceRefugoGr() {
		return indiceRefugoGr;
	}
	public void setIndiceRefugoGr(Double indiceRefugoGr) {
		this.indiceRefugoGr = indiceRefugoGr;
	}
	public String getCorHexa() {
		return corHexa;
	}
	public void setCorHexa(String corHexa) {
		this.corHexa = corHexa;
	}
}
