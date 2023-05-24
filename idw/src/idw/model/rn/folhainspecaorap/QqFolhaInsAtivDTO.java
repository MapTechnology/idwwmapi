package idw.model.rn.folhainspecaorap;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class QqFolhaInsAtivDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long idFolhainsativ;
	private Integer ordem;
	private String dsFolhainsativ;
	private BigDecimal segDuracaoesperada;
	
	
	private List<QqFolhaInsMedDTO> qqFolhaInsMeds;
	private List<QqFolhainsftDTO> qqFolhainsfts;

	
	public Long getIdFolhainsativ() {
		return idFolhainsativ;
	}
	public void setIdFolhainsativ(Long idFolhainsativ) {
		this.idFolhainsativ = idFolhainsativ;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	public String getDsFolhainsativ() {
		return dsFolhainsativ;
	}
	public void setDsFolhainsativ(String dsFolhainsativ) {
		this.dsFolhainsativ = dsFolhainsativ;
	}
	public BigDecimal getSegDuracaoesperada() {
		return segDuracaoesperada;
	}
	public void setSegDuracaoesperada(BigDecimal segDuracaoesperada) {
		this.segDuracaoesperada = segDuracaoesperada;
	}

	public List<QqFolhaInsMedDTO> getQqFolhaInsMeds() {
		return qqFolhaInsMeds;
	}
	public void setQqFolhaInsMeds(List<QqFolhaInsMedDTO> qqFolhaInsMeds) {
		this.qqFolhaInsMeds = qqFolhaInsMeds;
	}

	public List<QqFolhainsftDTO> getQqFolhainsfts() {
		return qqFolhainsfts;
	}
	public void setQqFolhainsfts(List<QqFolhainsftDTO> qqFolhainsfts) {
		this.qqFolhainsfts = qqFolhainsfts;
	}
}
