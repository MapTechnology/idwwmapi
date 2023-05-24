package idw.model.rn.monitorizacao.roteiro;

import idw.model.pojos.DwConsolid;
import idw.model.pojos.OmObj;
import idw.model.rn.geraplano.dtos.PassosDTO;

/*
 * Essa classe retorna para o cliente com os dados necessarios para a monitorizacao em tempo real
 */
public class OmObjDTO extends OmObj{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer segCicloPadrao;
	private Double segCiclomedio;
	private Double segCiclosomado;
	private Integer segTempoRotatividadeEstoque;
	private Double er;
	private Double ec;
	private Double ip;
	
	private boolean isForaMeta;
	private boolean isOffline;
	private boolean isParada;
	private String identificacao;
	private PassosDTO passo;
	
	private DwConsolid dwconsolid;
	private Byte tpId; // No caso sera por turno ou acumulado
	
	public OmObjDTO() {
		super();
	}
	
	public OmObjDTO(OmObj omobj) {
		atribuir(omobj, this, true);
		// Atibuir a identificacao
		if (omobj.getDwFolhaByIdFolha() != null) {
			this.identificacao = omobj.getDwFolhaByIdFolha().getCdFolha();
		} else if (omobj.getDwEstByIdEst() != null) {
			this.identificacao = omobj.getDwEstByIdEst().getCdEst();
		} else {
			this.identificacao = "si";
		}
	}
	
	public Integer getSegCicloPadrao() {
		return segCicloPadrao;
	}
	public void setSegCicloPadrao(Integer segCicloPadrao) {
		this.segCicloPadrao = segCicloPadrao;
	}
	public Integer getSegTempoRotatividadeEstoque() {
		return segTempoRotatividadeEstoque;
	}
	public void setSegTempoRotatividadeEstoque(Integer segTempoRotatividadeEstoque) {
		this.segTempoRotatividadeEstoque = segTempoRotatividadeEstoque;
	}
	public boolean isForaMeta() {
		return isForaMeta;
	}
	public void setForaMeta(boolean isForaMeta) {
		this.isForaMeta = isForaMeta;
	}
	public boolean isOffline() {
		return isOffline;
	}
	public void setOffline(boolean isOffline) {
		this.isOffline = isOffline;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public boolean isParada() {
		return isParada;
	}

	public void setParada(boolean isParada) {
		this.isParada = isParada;
	}

	public Double getEr() {
		return er;
	}

	public void setEr(Double er) {
		this.er = er;
	}

	public Double getEc() {
		return ec;
	}

	public void setEc(Double ec) {
		this.ec = ec;
	}

	public Double getIp() {
		return ip;
	}

	public void setIp(Double ip) {
		this.ip = ip;
	}

	public DwConsolid getDwconsolid() {
		return dwconsolid;
	}

	public void setDwconsolid(DwConsolid dwconsolid) {
		this.dwconsolid = dwconsolid;
	}

	public Byte getTpId() {
		return tpId;
	}

	public void setTpId(Byte tpId) {
		this.tpId = tpId;
	}

	public Double getSegCiclomedio() {
		return segCiclomedio;
	}

	public void setSegCiclomedio(Double segCiclomedio) {
		this.segCiclomedio = segCiclomedio;
	}

	public Double getSegCiclosomado() {
		return segCiclosomado;
	}

	public void setSegCiclosomado(Double segCiclosomado) {
		this.segCiclosomado = segCiclosomado;
	}

	public PassosDTO obtemPasso() {
		return passo;
	}

	public void mudaPasso(PassosDTO passo) {
		this.passo = passo;
	}
	
}
