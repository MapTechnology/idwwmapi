package idw.webservices.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwRap;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;

public class FiltroRelatorioProducaoR043DTO {
	
	private int ano;
	private int mes;
	List<Date> dias;
	private TurnoDTO turno;
	
	private OmPt posto;
	private OmGt grupoTrabalho;
	private DwRap ferramenta;
	private DwGrupoFerramenta grupoFerramenta;
	
	private boolean isTodosHorarios;
	private boolean isRelatorioSemanal;
	private boolean isRelatorioMensal;
	private boolean isPecaOEE;
	private boolean isHoraOEE;
	
	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public List<Date> getDias() {
		return dias;
	}

	public void setDias(List<Date> dias) {
		this.dias = dias;
	}

	public TurnoDTO getTurno() {
		return turno;
	}

	public void setTurno(TurnoDTO turno) {
		this.turno = turno;
	}

	public OmPt getPosto() {
		return posto;
	}

	public void setPosto(OmPt posto) {
		this.posto = posto;
	}

	public OmGt getGrupoTrabalho() {
		return grupoTrabalho;
	}

	public void setGrupoTrabalho(OmGt grupoTrabalho) {
		this.grupoTrabalho = grupoTrabalho;
	}

	public DwRap getFerramenta() {
		return ferramenta;
	}

	public void setFerramenta(DwRap ferramenta) {
		this.ferramenta = ferramenta;
	}

	public DwGrupoFerramenta getGrupoFerramenta() {
		return grupoFerramenta;
	}

	public void setGrupoFerramenta(DwGrupoFerramenta grupoFerramenta) {
		this.grupoFerramenta = grupoFerramenta;
	}

	public boolean isTodosHorarios() {
		return isTodosHorarios;
	}

	public void setTodosHorarios(boolean isTodosHorarios) {
		this.isTodosHorarios = isTodosHorarios;
	}

	public boolean isRelatorioSemanal() {
		return isRelatorioSemanal;
	}

	public void setRelatorioSemanal(boolean isRelatorioSemanal) {
		this.isRelatorioSemanal = isRelatorioSemanal;
	}

	public boolean isRelatorioMensal() {
		return isRelatorioMensal;
	}

	public void setRelatorioMensal(boolean isRelatorioMensal) {
		this.isRelatorioMensal = isRelatorioMensal;
	}

	public boolean isPecaOEE() {
		return isPecaOEE;
	}

	public void setPecaOEE(boolean isPecaOEE) {
		this.isPecaOEE = isPecaOEE;
	}

	public boolean isHoraOEE() {
		return isHoraOEE;
	}

	public void setHoraOEE(boolean isHoraOEE) {
		this.isHoraOEE = isHoraOEE;
	}

	@Override
	public String toString() {
		String retorno =  "Filtro Relatorio Producao Semanal/Mensal \n";
		retorno += "ano: "+ano+"\n";
		retorno += "mes: "+mes+"\n";
		retorno += "dias: "+diasToString()+"\n";		
		
		if(turno != null){
			retorno += "turno: "+turno.getTurno().getCdTurno()+"\n";
		} else {
			retorno += "turno: null\n";
		}
		
		if(posto != null){
			retorno += "posto: "+posto.getCdPt()+"\n";
		} else {
			retorno += "posto: null\n";
		}
		
		if(grupoTrabalho != null){
			retorno += "grupoTrabalho: "+grupoTrabalho.getCdGt()+"\n";
		} else {
			retorno += "grupoTrabalho: null\n";
		}
		
		if(ferramenta != null){
			retorno += "ferramenta: "+ferramenta.getCdRap()+"\n";
		} else {
			retorno += "ferramenta: null\n";
		}
		
		if(grupoFerramenta != null){
			retorno += "grupoFerramenta: "+grupoFerramenta.getCdGrupoFerramenta()+"\n";
		} else {
			retorno += "grupoFerramenta: null\n";
		}		
		
		retorno += "isTodosHorarios: "+isTodosHorarios+"\n";
		retorno += "isRelatorioSemanal: "+isRelatorioSemanal+"\n";
		retorno += "isRelatorioMensal: "+isRelatorioMensal+"\n";
		retorno += "isPecaOEE: "+isPecaOEE+"\n";
		retorno += "isHoraOEE: "+isHoraOEE+"\n";
		return retorno;
	}
	
	private String diasToString(){
		String retorno = "";
		for(Date dia : dias){
			retorno += new SimpleDateFormat("dd").format(dia) + ",";
		}
		retorno = retorno.substring(0, retorno.length()-1);
		return retorno;
	}
	
}
