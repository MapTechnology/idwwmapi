package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.Date;

import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwTArea;
import idw.model.rn.DataHoraRN;

public class DetalheParadaDTO {
	
	private String maquina;
	private String dsPt;
	private String folha;
	private String ferramenta;
	private String parada;
	private Date inicio;
	private Date fim;
	private String duracao;
	private Double duracaoEmSegundos;
	private DwTArea area_resp;
	private String causa;
	private String acao;
	private String justificativa;
	private String tecnico1;
	private String tecnico2;
	private String tecnico_responsavel;
	private double perdas_paradas;
	private String turno;
	private DwConsolpaoco dwConsolpaoco;
	private boolean isComPeso;
	
	public DetalheParadaDTO() {
		super();
	}
	
	public DetalheParadaDTO(DwConsolpalog palog) {
		super();
		if (palog.getSegAutoTempoparadaCp() != null) {
			this.setDuracao(DataHoraRN.formatSegundosParaHHMMSS(palog.getSegAutoTempoparadaCp().intValue()));
			this.setDuracaoEmSegundos(palog.getSegAutoTempoparadaCp().divide(new BigDecimal(1000)).doubleValue());
		} else if (palog.getSegAutoTempoparadaSp() != null) {
			this.setDuracao(DataHoraRN.formatSegundosParaHHMMSS(palog.getSegAutoTempoparadaSp().intValue()));
			this.setDuracaoEmSegundos(palog.getSegAutoTempoparadaSp().divide(new BigDecimal(1000)).doubleValue());
		} else if (palog.getDthrFparada() == null) {
			long duracao = DataHoraRN.getQuantidadeSegundosNoPeriodo(palog.getDthrIparada(),DataHoraRN.getDataHoraAtual());
			this.setDuracao(DataHoraRN.formatSegundosParaHHMMSS((int) duracao));
			this.setDuracaoEmSegundos((double) duracao);
		}
		this.setFim(palog.getDthrFparada());
		this.setInicio(palog.getDthrIparada());
		this.setParada(palog.getDwTParada().getCdTparada() + "-" + palog.getDwTParada().getDsTparada());
		if (palog.getDwTParada().getDwTArea() != null)
			this.setArea_resp(palog.getDwTParada().getDwTArea().clone(false));
	}
	
	
	
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getFerramenta() {
		return ferramenta;
	}
	public void setFerramenta(String ferramenta) {
		this.ferramenta = ferramenta;
	}
	public String getParada() {
		return parada;
	}
	public void setParada(String parada) {
		this.parada = parada;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public DwTArea getArea_resp() {
		return area_resp;
	}
	public void setArea_resp(DwTArea area_resp) {
		this.area_resp = area_resp;
	}
	public String getCausa() {
		return causa;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public String getJustificativa() {
		return justificativa;
	}
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
	public String getTecnico1() {
		return tecnico1;
	}
	public void setTecnico1(String tecnico1) {
		this.tecnico1 = tecnico1;
	}
	public String getTecnico2() {
		return tecnico2;
	}
	public void setTecnico2(String tecnico2) {
		this.tecnico2 = tecnico2;
	}
	public String getTecnico_responsavel() {
		return tecnico_responsavel;
	}
	public void setTecnico_responsavel(String tecnico_responsavel) {
		this.tecnico_responsavel = tecnico_responsavel;
	}
	public double getPerdas_paradas() {
		return perdas_paradas;
	}
	public void setPerdas_paradas(double perdas_paradas) {
		this.perdas_paradas = perdas_paradas;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public DwConsolpaoco getDwConsolpaoco() {
		return dwConsolpaoco;
	}
	public void setDwConsolpaoco(DwConsolpaoco dwConsolpaoco) {
		this.dwConsolpaoco = dwConsolpaoco;
	}
	
	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder();
		if (getDwConsolpaoco() != null) {
			retorno.append("idOco ");
			retorno.append(getDwConsolpaoco().getIdConsolpaoco());
			retorno.append("Parada ");
			if (getDwConsolpaoco().getDwConsolpa() != null && getDwConsolpaoco().getDwConsolpa().getDwTParada() != null)
				retorno.append(getDwConsolpaoco().getDwConsolpa().getDwTParada().getCdTparada());
			else
				retorno.append(" -- ");
			
			retorno.append(" inicio em ");
			retorno.append(DataHoraRN.dateToStringYYYYMMDDHHMMSS(getDwConsolpaoco().getDthrIparada()));
			retorno.append(" termino em ");
			retorno.append(DataHoraRN.dateToStringYYYYMMDDHHMMSS(getDwConsolpaoco().getDthrFparada()));
		} else {
			retorno.append("Parada ");
			retorno.append(parada);
			retorno.append(" inicio em ");
			retorno.append(DataHoraRN.dateToStringYYYYMMDDHHMMSS(getInicio()));
			retorno.append(" termino em ");
			retorno.append(DataHoraRN.dateToStringYYYYMMDDHHMMSS(getFim()));
		}		
		return retorno.toString();
	}
	public String getDsPt() {
		return dsPt;
	}
	public void setDsPt(String dsPt) {
		this.dsPt = dsPt;
	}

	public Double getDuracaoEmSegundos() {
		return duracaoEmSegundos;
	}

	public void setDuracaoEmSegundos(Double duracaoEmSegundos) {
		this.duracaoEmSegundos = duracaoEmSegundos;
	}

	public String getFolha() {
		return folha;
	}

	public void setFolha(String folha) {
		this.folha = folha;
	}

	public boolean isComPeso() {
		return isComPeso;
	}

	public void setComPeso(boolean isComPeso) {
		this.isComPeso = isComPeso;
	}
	
	
}
