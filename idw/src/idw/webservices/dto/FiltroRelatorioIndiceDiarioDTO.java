package idw.webservices.dto;

import java.util.Date;
import java.util.List;

import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwRap;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;

public class FiltroRelatorioIndiceDiarioDTO {
	
	private Date dt_inicio;
	private Date dt_final;
	private OmPt ompt;
	private OmGt omgt;
	private boolean peso;
	private boolean peca;
	private String tipo;
	private String unidMedida;
	private String horarios;
	private TurnoDTO turnoDTO;
	private DwFolha dwFolha;
	private DwRap dwRap;
	private DwRap gpDwRap; // deve sair e usar o dwGrupoFerramenta
    private DwGrupoFerramenta dwGrupoFerramenta;
    private List<OmProduto> omProduto;
	private List<DwConsolid>  dwConsolid;
	
	public Date getDt_inicio() {
		return dt_inicio;
	}
	public void setDt_inicio(Date dt_inicio) {
		this.dt_inicio = dt_inicio;
	}
	public Date getDt_final() {
		return dt_final;
	}
	public void setDt_final(Date dt_final) {
		this.dt_final = dt_final;
	}
	public OmPt getOmpt() {
		return ompt;
	}
	public void setOmpt(OmPt ompt) {
		this.ompt = ompt;
	}
	public OmGt getOmgt() {
		return omgt;
	}
	public void setOmgt(OmGt omgt) {
		this.omgt = omgt;
	}
	public boolean isPeso() {
		return peso;
	}
	public void setPeso(boolean peso) {
		this.peso = peso;
	}
	public boolean isPeca() {
		return peca;
	}
	public void setPeca(boolean peca) {
		this.peca = peca;
	}
	public String getUnidMedida() {
		return unidMedida;
	}
	public void setUnidMedida(String unidMedida) {
		this.unidMedida = unidMedida;
	}
	public String getHorarios() {
		return horarios;
	}
	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}
	public TurnoDTO getTurnoDTO() {
		return turnoDTO;
	}
	public void setTurnoDTO(TurnoDTO turnoDTO) {
		this.turnoDTO = turnoDTO;
	}
	public DwFolha getDwFolha() {
		return dwFolha;
	}
	public void setDwFolha(DwFolha dwFolha) {
		this.dwFolha = dwFolha;
	}
	public DwRap getDwRap() {
		return dwRap;
	}
	public void setDwRap(DwRap dwRap) {
		this.dwRap = dwRap;
	}
	public DwRap getGpDwRap() {
		return gpDwRap;
	}
	public void setGpDwRap(DwRap gpDwRap) {
		this.gpDwRap = gpDwRap;
	}
	public DwGrupoFerramenta getDwGrupoFerramenta() {
		return dwGrupoFerramenta;
	}
	public void setDwGrupoFerramenta(DwGrupoFerramenta dwGrupoFerramenta) {
		this.dwGrupoFerramenta = dwGrupoFerramenta;
	}
	public List<OmProduto> getOmProduto() {
		return omProduto;
	}
	public void setOmProduto(List<OmProduto> omProduto) {
		this.omProduto = omProduto;
	}
	public List<DwConsolid> getDwConsolid() {
		return dwConsolid;
	}
	public void setDwConsolid(List<DwConsolid> dwConsolid) {
		this.dwConsolid = dwConsolid;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		
		String retorno;
		
		retorno = "FiltroRelatorioIndiceDiarioDTO [";
		
		retorno += "dt_inicio=" + this.dt_inicio + ", " +
				   "dt_final=" + this.dt_final + ", ";
		
		retorno += "ompt=";
		
		if (this.ompt != null) {
			retorno += this.ompt.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "omgt=";

		if (this.omgt != null) {
			retorno += this.omgt.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "peso=" + this.peso + ", " +
				   "peca=" + this.peca + ", " +
				   "tipo=" + this.tipo + ", " +
				   "unidMedida" + this.unidMedida + ", " +
				   "horarios=" + this.horarios + ", ";
		
		retorno += "turnoDTO=";
		
		if (this.turnoDTO != null) {
			retorno += this.turnoDTO.getTurno().getCdTurno() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "dwFolha=";
		
		if (this.dwFolha != null) {
			retorno += this.dwFolha.getCd()  + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "dwRap=";
		
		if (this.dwRap != null) {
			retorno += this.dwRap.getCd()  + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "gpDwRap=";
		
		if (this.gpDwRap != null) {
			retorno += this.gpDwRap.getCd()  + ", ";
		} else {
			retorno += "null, ";
		}

		retorno += "dwGrupoFerramenta=";
		
		if (this.dwGrupoFerramenta != null) {
			retorno += this.dwGrupoFerramenta.getCd() + "]";
		} else {
			retorno += "null]";
		}
		
		retorno += "omProduto=";
		
		if (this.omProduto != null) {
			retorno += this.omProduto.toString() + "]";
		} else {
			retorno += "null]";
		}

		retorno += "dwConsolid=";
		
		if (this.dwConsolid != null) {
			retorno += this.dwConsolid.toString() + "]";
		} else {
			retorno += "null]";
		}
		
		return retorno;
		/*
		return "FiltroRelatorioIndiceDiarioDTO [dt_inicio=" + dt_inicio + ", dt_final=" + dt_final + ", ompt=" + ompt + ", omgt=" + omgt
				+ ", peso=" + peso + ", peca=" + peca + ", tipo=" + tipo + ", unidMedida=" + unidMedida + ", horarios=" + horarios
				+ ", turnoDTO=" + turnoDTO + ", dwFolha=" + dwFolha + ", dwRap=" + dwRap + ", gpDwRap=" + gpDwRap + ", dwGrupoFerramenta="
				+ dwGrupoFerramenta + ", omProduto=" + omProduto + ", dwConsolid=" + dwConsolid + "]";
		*/
	}

}
