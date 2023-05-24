package idw.model.rn.injet.dto;

import java.util.Date;
import java.util.GregorianCalendar;

import idw.model.rn.DataHoraRN;


@SuppressWarnings("serial")
public class MesInjetDTO implements java.io.Serializable{

	public static int _JANEIRO = 1;
	public static int _FEVEREIRO = 2;
	public static int _MARCO = 3;
	public static int _ABRIL = 4;
	public static int _MAIO = 5;
	public static int _JUNHO = 6;
	public static int _JULHO = 7;
	public static int _AGOSTO = 8;
	public static int _SETEMBRO = 9;
	public static int _OUTUBRO = 10;
	public static int _NOVEMBRO = 11;
	public static int _DEZEMBRO = 12;
	public static int _TOTAL = 13;

	private int ano;
	private int mes = 1;
	
	// Caso o DTO tenha as datas de inicio e fim definidas externamente as mesmas serao consideradas
	// ao inves de calcular as mesmas automaticamente
	// Isso eh feito caso o filtro dos relatorios tenha data de inicio e fim ao inves de ano e semestre
	private Date dtInicio = null;
	private Date dtFim = null;
	
	public MesInjetDTO(String ano, int mes){
		this.ano = Integer.valueOf(ano);
		this.mes = mes;
	}
	public MesInjetDTO(int ano, int mes){
		this.ano = ano;
		this.mes = mes;
	}

	/**
	 * @return the ano
	 */
	public int getAno() {
		return ano;
	}

	/**
	 * @param ano the ano to set
	 */
	public void setAno(int ano) {
		this.ano = ano;
	}

	/**
	 * @return the mes
	 */
	public int getMes() {
		return mes;
	}

	/**
	 * @param mes the mes to set
	 */
	public void setMes(int mes) {
		if (mes < 1 || mes > 13)
			mes = 1;
		
		this.mes = mes;
	}
	
	public String getDescricaoMes(){
		String[] meses = {"JANEIRO", "FEVEREIRO", "MAR�O", "ABRIL", "MAIO", "JUNHO", "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO", "M�DIA"};
		
		return meses[mes - 1];
	}

	public String getDescricaoReduzidaMes(){
		String[] meses = {"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ", "M�DIA"};
		
		return meses[mes - 1];
	}

	public Date getDataInicioMes(){
		GregorianCalendar calendario = new GregorianCalendar();
		
		calendario.setTime(new Date());
		calendario.set(this.ano, this.mes - 1, 1);
		
		Date retorno = dtInicio;
		
		if (retorno == null)
			retorno = DataHoraRN.getPrimeiroDiaDoMesDaData(calendario.getTime()); 
		return retorno;
	}

	public Date getDataFinalMes(){
		GregorianCalendar calendario = new GregorianCalendar();
		
		calendario.setTime(new Date());
		calendario.set(this.ano, this.mes - 1, 1);
	
		Date retorno = dtFim;
		
		if (retorno == null)
			retorno = DataHoraRN.getUltimoDiaDoMesDaData(calendario.getTime());
		
		return retorno;
	}
	/**
	 * @return the dtInicio
	 */
	public Date getDtInicio() {
		return dtInicio;
	}
	/**
	 * @param dtInicio the dtInicio to set
	 */
	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}
	/**
	 * @return the dtFim
	 */
	public Date getDtFim() {
		return dtFim;
	}
	/**
	 * @param dtFim the dtFim to set
	 */
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}
}