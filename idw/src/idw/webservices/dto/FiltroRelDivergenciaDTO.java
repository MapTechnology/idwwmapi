package idw.webservices.dto;

import java.util.Date;

import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;

public class FiltroRelDivergenciaDTO {
	
	private Date dataInicio;
	private Date dataFim;
	private DwTurno turno;
	private OmUsr usuario;
	private DwRap rap;
	private DwGrupoFerramenta grupoFerramenta;
	private OmPt pt;
	private OmGt gt;
	private OmProduto produto;
	private boolean isOrdQtdProduzida;
	
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public DwTurno getTurno() {
		return turno;
	}
	public void setTurno(DwTurno turno) {
		this.turno = turno;
	}
	public OmUsr getUsuario() {
		return usuario;
	}
	public void setUsuario(OmUsr usuario) {
		this.usuario = usuario;
	}
	public DwRap getRap() {
		return rap;
	}
	public void setRap(DwRap rap) {
		this.rap = rap;
	}
	public DwGrupoFerramenta getGrupoFerramenta() {
		return grupoFerramenta;
	}
	public void setGrupoFerramenta(DwGrupoFerramenta grupoFerramenta) {
		this.grupoFerramenta = grupoFerramenta;
	}
	public OmPt getPt() {
		return pt;
	}
	public void setPt(OmPt pt) {
		this.pt = pt;
	}
	public OmGt getGt() {
		return gt;
	}
	public void setGt(OmGt gt) {
		this.gt = gt;
	}
	public OmProduto getProduto() {
		return produto;
	}
	public void setProduto(OmProduto produto) {
		this.produto = produto;
	}
	public boolean isOrdQtdProduzida() {
		return isOrdQtdProduzida;
	}
	public void setOrdQtdProduzida(boolean isOrdQtdProduzida) {
		this.isOrdQtdProduzida = isOrdQtdProduzida;
	}
	@Override
	public String toString() {
		
		String retorno;
		
		retorno = "FiltroRelDivergenciaDTO [";
		
		retorno += "dataInicio=" + this.dataInicio + ", " +
				   "dataFim=" + this.dataFim + ", ";

		retorno += "turno=";
		
		if (this.turno != null) {
			retorno += this.turno.getCdTurno() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "usuario=";
		
		if (this.usuario != null) {
			retorno += this.usuario.getCd() + ", ";
		} else {
			retorno += "null, ";
		}

		retorno += "rap=";
		
		if (this.rap != null) {
			retorno += this.rap.getCd() + ", ";
		} else {
			retorno += "null, ";
		}

		retorno += "grupoFerramenta=";
		
		if (this.grupoFerramenta != null) {
			retorno += this.grupoFerramenta.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "pt=";
		
		if (this.pt != null) {
			retorno += this.pt.getCd() + ", ";
		} else {
			retorno += "null, ";
		}

		retorno += "gt=";
		
		if (this.gt != null) {
			retorno += this.gt.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "produto=";
		
		if (this.produto != null) {
			retorno += this.produto.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "isOrdQtdProduzida=" + this.isOrdQtdProduzida + "]";
		
		return retorno;
		/*
		return "FiltroRelDivergenciaDTO [dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", turno=" + turno + ", usuario=" + usuario
				+ ", rap=" + rap + ", grupoFerramenta=" + grupoFerramenta + ", pt=" + pt + ", gt=" + gt + ", produto=" + produto
				+ ", isOrdQtdProduzida=" + isOrdQtdProduzida + "]";
		*/
	}
	
}