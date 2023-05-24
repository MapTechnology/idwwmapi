package idw.model.rn.relatorios.consolidados;

import java.util.Date;

import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwRap;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;
import idw.webservices.dto.TurnoDTO;

public class FiltroRelatorioConsolidadosDTO {
    
    public enum Agrupamento {
        POSTO(1), 
        FERRAMENTA(2),
        PRODUTO(3);

        private final int value;

        private Agrupamento(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
    
    public enum TipoProducao {
        PECAS(1),
        PESO_LIQUIDO(2),
        PESO_BRUTO(3);

        private final int value;

        private TipoProducao(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
    
    public enum TipoPeso {
        KG(1), 
        TON(2);

        private final int value;

        private TipoPeso(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    private OmGt omgt;
    private OmPt ompt;
    private TurnoDTO turnoDTO;
    private String horario;
    private Date periodoInicial;
    private Date periodoFinal;
    private String cdop;
    private TipoProducao tipoProducao;
    private TipoPeso tipoPeso;    
    private Agrupamento agrupamento;
    private DwRap rap;
    private DwGrupoFerramenta dwGrupoFerramenta;
    
    public OmGt getOmgt() {
        return omgt;
    }
    public void setOmgt(OmGt omgt) {
        this.omgt = omgt;
    }
    public OmPt getOmpt() {
        return ompt;
    }
    public void setOmpt(OmPt ompt) {
        this.ompt = ompt;
    }
    public TurnoDTO getTurnoDTO() {
        return turnoDTO;
    }
    public void setTurnoDTO(TurnoDTO turnoDTO) {
        this.turnoDTO = turnoDTO;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public Date getPeriodoInicial() {
        return periodoInicial;
    }
    public void setPeriodoInicial(Date periodoInicial) {
        this.periodoInicial = periodoInicial;
    }
    public Date getPeriodoFinal() {
        return periodoFinal;
    }
    public void setPeriodoFinal(Date periodoFinal) {
        this.periodoFinal = periodoFinal;
    }
    public String getCdop() {
        return cdop;
    }
    public void setCdop(String cdop) {
        this.cdop = cdop;
    }
    public TipoProducao getTipoProducao() {
        return tipoProducao;
    }
    public void setTipoProducao(TipoProducao tipoProducao) {
        this.tipoProducao = tipoProducao;
    }
    public TipoPeso getTipoPeso() {
        return tipoPeso;
    }
    public void setTipoPeso(TipoPeso tipoPeso) {
        this.tipoPeso = tipoPeso;
    }
    public Agrupamento getAgrupamento() {
        return agrupamento;
    }
    public void setAgrupamento(Agrupamento agrupamento) {
        this.agrupamento = agrupamento;
    }
    public DwRap getRap() {
        return rap;
    }
    public void setRap(DwRap rap) {
        this.rap = rap;
    }
    public DwGrupoFerramenta getDwGrupoFerramenta() {
        return dwGrupoFerramenta;
    }
    public void setDwGrupoFerramenta(DwGrupoFerramenta dwGrupoFerramenta) {
        this.dwGrupoFerramenta = dwGrupoFerramenta;
    }
	@Override
	public String toString() {
		
		String retorno;
		
		retorno = "FiltroRelatorioConsolidadosDTO ["; 
		
		retorno += "omgt=";

		if (this.omgt != null) {
			retorno += this.omgt.getCdGt() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "ompt=";
		
		if (this.ompt != null) {
			retorno += this.ompt.getCdPt() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "turnoDTO=";
		
		if (this.turnoDTO != null) {
			retorno += this.turnoDTO.getTurno().getCdTurno() + ", ";
		} else {
			retorno += "null, ";
		}

		retorno += "horario=" + this.horario + ", " +
		           "periodoInicial=" + this.periodoInicial + ", " +
				   "periodoFinal=" + this.periodoFinal + ", " +
		           "cdop=" + this.cdop + ", " +
		           "tipoProducao=" + this.tipoProducao + ", " +
				   "tipoPeso=" + this.tipoPeso + ", " +
		           "agrupamento=" + this.agrupamento + ", ";

		retorno += "rap=";
		
		if (this.rap != null) {
			retorno += this.rap.getCd()  + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "dwGrupoFerramenta=";
		
		if (this.dwGrupoFerramenta != null) {
			retorno += this.dwGrupoFerramenta.getCd() + "]";
		} else {
			retorno += "null]";
		}
		
		return retorno;
		/*
		return "FiltroRelatorioConsolidadosDTO [omgt=" + omgt + ", ompt=" + ompt + ", turnoDTO=" + turnoDTO + ", horario=" + horario
				+ ", periodoInicial=" + periodoInicial + ", periodoFinal=" + periodoFinal + ", cdop=" + cdop + ", tipoProducao="
				+ tipoProducao + ", tipoPeso=" + tipoPeso + ", agrupamento=" + agrupamento + ", rap=" + rap + ", dwGrupoFerramenta="
				+ dwGrupoFerramenta + "]";
		*/
	}
        
}
