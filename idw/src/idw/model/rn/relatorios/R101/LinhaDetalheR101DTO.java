package idw.model.rn.relatorios.R101;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import idw.model.rn.diariobordo.DiarioBordoDTO;
import idw.webservices.dto.DefeitoDTO;
import idw.webservices.dto.MontagemDTO;

public class LinhaDetalheR101DTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ns;
	private String op;
	private String posto;
	private String dthrPassagem;
	private Integer stNserie;
	private List<MontagemDTO> montagem = new ArrayList<>();
	private List<DefeitoDTO> defeitos = new ArrayList<>();
	private List<DiarioBordoDTO> diarioBordo = new ArrayList<>();
	public String getNs() {
		return ns;
	}
	public void setNs(String ns) {
		this.ns = ns;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getPosto() {
		return posto;
	}
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public String getDthrPassagem() {
		return dthrPassagem;
	}
	public void setDthrPassagem(String dthrPassagem) {
		this.dthrPassagem = dthrPassagem;
	}
	public Integer getStNserie() {
		return stNserie;
	}
	public void setStNserie(Integer stNserie) {
		this.stNserie = stNserie;
	}
	public List<MontagemDTO> getMontagem() {
		return montagem;
	}
	public void setMontagem(List<MontagemDTO> montagem) {
		this.montagem = montagem;
	}
	public List<DefeitoDTO> getDefeitos() {
		return defeitos;
	}
	public void setDefeitos(List<DefeitoDTO> defeitos) {
		this.defeitos = defeitos;
	}
	public List<DiarioBordoDTO> getDiarioBordo() {
		return diarioBordo;
	}
	public void setDiarioBordo(List<DiarioBordoDTO> diarioBordo) {
		this.diarioBordo = diarioBordo;
	}
}
