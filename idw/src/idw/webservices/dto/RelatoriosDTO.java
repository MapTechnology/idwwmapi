package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.OmProduto;
import idw.model.pojos.PpCp;

@SuppressWarnings("serial")
public class RelatoriosDTO implements Serializable {
	
	private List<RelatorioDTO> rel = new ArrayList<RelatorioDTO>();
	private OmProduto produto;
	private PpCp ppcp;
	private String maquina;
	int ordem = 0;
	BigDecimal qtdApont = new BigDecimal(0);
	
	public OmProduto getProduto() {
		return produto;
	}
	public void setProduto(OmProduto produto) {
		this.produto = produto;
	}
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	private ResultadoDTO resul = new ResultadoDTO();
	
	public List<RelatorioDTO> getRel() {
		return rel;
	}
	public void setRel(List<RelatorioDTO> rel) {
		this.rel = rel;
	}
	public ResultadoDTO getResul() {
		return resul;
	}
	public void setResul(ResultadoDTO resul) {
		this.resul = resul;
	}
	public BigDecimal getQtdApont() {
		return qtdApont;
	}
	public void setQtdApont(BigDecimal qtdApont) {
		this.qtdApont = qtdApont;
	}
	public int getOrdem() {
		return ordem;
	}
	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	public PpCp getPpcp() {
		return ppcp;
	}
	public void setPpcp(PpCp ppcp) {
		this.ppcp = ppcp;
	}
}
