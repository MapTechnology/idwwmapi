package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

import idw.model.pojos.DwCal;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwTurno;
import idw.model.rn.DataHoraRN;

/**
 * Trata assuntos relacionados a estrutura de {@code DwCalsem}
 *
 */
public abstract class DwCalsemTemplate extends AbstractTemplate<DwCalsem>{
	
	/**
	 * Enum para os dias da semana usado na propriedade {@code DwCalsem.DiaSemana} 		
	 *
	 */
	public enum DiaSemana{
		
		DOMINGO(new BigDecimal(0),Calendar.SUNDAY, "dom"),
		SEGUNDA(new BigDecimal(1), Calendar.MONDAY, "seg"),
		TERCA(new BigDecimal(2), Calendar.TUESDAY, "ter"),
		QUARTA(new BigDecimal(3), Calendar.WEDNESDAY, "qua"),
		QUINTA(new BigDecimal(4), Calendar.THURSDAY, "qui"),
		SEXTA(new BigDecimal(5), Calendar.FRIDAY, "sex"),
		SABADO(new BigDecimal(6), Calendar.SATURDAY, "s�b");
		
		private final BigDecimal id;
		private final int calendarDay;
		private String abrev;
		
		private DiaSemana(BigDecimal id, int calendarDay, String abrev){
			this.id = id;
			this.calendarDay = calendarDay;
			this.abrev = abrev;
		}
		
		/**
		 * Dia baseado no {@link Calendar}
		 * @return
		 */
		private int getCalendarDay(){
			return this.calendarDay;
		}
		
		public BigDecimal getId(){
			return this.id;
		}
		
		public boolean equals(BigDecimal id){
			if(id != null){
				return id.compareTo(this.id) == 0;
			}
			return false;
		}
		/**
		 * Descri��o reduzida do dia da semana
		 * <br><tt>dom, seg, ter, qua, qui, sex, s�b</tt>
		 * @return
		 */
		public String getAbrev(){
			return this.abrev;
		}
		
		public DiaSemana getDiaAnterior(){
			
			int calendarDayPrevious;
			if(this.calendarDay == Calendar.SUNDAY){
				calendarDayPrevious = Calendar.SATURDAY;
			}else{
				calendarDayPrevious = this.calendarDay - 1;
			}
			
			return DiaSemana.getPeloCalendarDay(calendarDayPrevious);
		}
		
		public DiaSemana getProximoDia(){
			int calendarDayNext;
			if(this.calendarDay == Calendar.SATURDAY){
				calendarDayNext= Calendar.SUNDAY;
			}else{
				calendarDayNext = this.calendarDay + 1;
			}
			
			return DiaSemana.getPeloCalendarDay(calendarDayNext);			
		}
		
		/**
		 * Pega {@code DiaSemana} correspondente {@code id}
		 * @param id
		 * @return
		 */
		public static DiaSemana get(BigDecimal id) {
			for (DiaSemana type : DiaSemana.values()){
				if (type.equals(id)){
					return type;
				}
			}
			
			throw new IllegalArgumentException("Nao foi possivel identificar o dia da semana para o idw. id=" + id);
		}		
		
		/**
		 * Pega {@code DiaSemana} correspondente {@code dt}
		 * @param dt
		 * @return
		 */
		public static DiaSemana get(Date dt){
			Validate.notNull(dt, "dt est� nulo");
			
			Calendar oCalendar = Calendar.getInstance();
			oCalendar.setTime(dt);			
			int calendarDay = oCalendar.get(Calendar.DAY_OF_WEEK);	

			return getPeloCalendarDay(calendarDay);
		}
		
		/**
		 * Pega {@code DiaSemana} correspondente ao dia da semana de {@link Calendar}
		 * @param calendarDay
		 * @return
		 */
		public static DiaSemana getPeloCalendarDay(int calendarDay){
			
			for (DiaSemana type : DiaSemana.values()){
				if ( type.getCalendarDay() == calendarDay){
					return type;
				}
			}
			
			throw new IllegalArgumentException("N�o foi possivel identificar o dia da semana para o idw," + 
					" relacionado ao dia semana do objeto Calendar. calendarDay=" + calendarDay);
			
		}

	}
	
	/**
	 * Enum para o tipo de referencia para a data da propriedade {@code DwCalsem.TpDtReferencia}
	 * 
	 */	
	public enum TpDtReferencia{
		
		DT_REF_MESMO_DIA((byte)0),
		DT_REF_DIA_SEGUINTE((byte)1),
		DT_REF_DIA_ANTERIOR((byte)2);
		
		private final byte id;
		
		private TpDtReferencia(byte value){			
			this.id = value;
		}
		public byte getId(){
			return this.id;
		}
				
		public boolean equals(Byte value){
			if(value != null){
				return value.equals(this.id);
			}
			return false;
		}
		
		public static TpDtReferencia getType(byte value) {
			for (TpDtReferencia type : TpDtReferencia.values()){
				if (type.getId() == value){
					return type;
				}
			}
			return null;
		}		
		
	}
	
	/**
	 * Cria nova instancia de {@code DwCalsem}
	 * @param dwTurno
	 * @param dwCal
	 * @param diaSemana
	 * @param hrInicial
	 * @param hrFinal
	 * @param segTempoCalendario
	 * @param tpDtreferencia
	 * @param isIniciotuno
	 * @param isFimturno
	 * @return
	 */
	public static DwCalsem newInstance(DwTurno dwTurno, DwCal dwCal, BigDecimal diaSemana, BigDecimal hrInicial, BigDecimal hrFinal, 
			BigDecimal segTempoCalendario, TpDtReferencia tpDtreferencia, Boolean isInicioturno, Boolean isFimturno){
		
		DwCalsem dwCalsem = new DwCalsem();
		
		dwCalsem.set(dwTurno, dwCal, diaSemana, hrInicial, hrFinal, hrFinal.subtract(hrInicial));
						
		dwCalsem.setTpDtreferencia(tpDtreferencia.getId());
		dwCalsem.setHrInicialGui(DataHoraRN.formatSegundosParaHHMM(hrInicial.intValue()));
		dwCalsem.setHrFinalGui(DataHoraRN.formatSegundosParaHHMM(hrFinal.intValue()));
		dwCalsem.setIsInicioturno(isInicioturno);
		dwCalsem.setIsFimturno(isFimturno);
		
		return dwCalsem;
		
	}
	
	/**
	 * Pega dia da semana correspondendo ao {@code DwCalsem.getDiaSemana} 
	 * @return
	 * @see DiaSemana#get(BigDecimal)
	 */
	public DiaSemana getDiaSemanaType(){
		return DiaSemana.get(this.getInstanceT().getDiasemana());
	}
	
	/**
	 * Tolerancia pre em segundos
	 * @return
	 */
	public BigDecimal getSegToleranciapreEmSeg(){
		DwCalsem dwCalsem = this.getInstanceT();
		BigDecimal retorno = dwCalsem.getSegToleranciapre();
		if (retorno == null || retorno.compareTo(BigDecimal.ZERO) == 0)
			retorno = BigDecimal.ZERO;
		retorno = retorno.multiply(new BigDecimal(DataHoraRN.SEG_MIN));
		return retorno;
	}
	
	/**
	 * Tolerancia pos em segundos
	 * @return
	 */
	public BigDecimal getSegToleranciaposEmSeg(){
		DwCalsem dwCalsem = this.getInstanceT();
		return ObjectUtils.defaultIfNull(dwCalsem.getSegToleranciapos(), BigDecimal.ZERO).multiply(new BigDecimal(DataHoraRN.SEG_MIN));
	}
	
	/**
	 * Pega a hora inicial {@code hrInicial} menos o tempo de pre-toler�ncia {@code segToleranciapre} em segundos
	 * @return 
	 */
	public BigDecimal getHrInicialComTolerancia(){
		DwCalsem dwCalsem = this.getInstanceT();
		
		return BigDecimal.ZERO
				.add(ObjectUtils.defaultIfNull(dwCalsem.getHrInicial(), BigDecimal.ZERO))
				.subtract(ObjectUtils.defaultIfNull(dwCalsem.getSegToleranciapreEmSeg(), BigDecimal.ZERO));
	}
	
	public String getHrInicialComToleranciaGUI() {
		return DataHoraRN.formatSegundosParaHHMM(getHrInicialComTolerancia().intValue());
	}
	
	
	/**
	 * Pega a hora final {@code hrFinal} mais o tempo de pos-toler�ncia {@code segToleranciapos}  em segundos
	 * @return
	 */
	public BigDecimal getHrFinalComTolerancia(){
		DwCalsem dwCalsem = this.getInstanceT();
		// Tempo de tolerancia em minutos
		return BigDecimal.ZERO
				.add(ObjectUtils.defaultIfNull(dwCalsem.getHrFinal(), BigDecimal.ZERO))
				.add(ObjectUtils.defaultIfNull(dwCalsem.getSegToleranciaposEmSeg(), BigDecimal.ZERO));
	}	
	
	public String getHrFinalComToleranciaGUI() {
		return DataHoraRN.formatSegundosParaHHMM(getHrFinalComTolerancia().intValue());
	}

	/**
	 * {@code String} com os dados de {@code List<DwCalsem>}
	 * @param lista n�o pode ser nula
	 * @return
	 */
	public static String dwCalsemsToString(List<DwCalsem> lista){
		Validate.notNull(lista, "Lista de calendario deve ser nula");
		StringBuilder sb = new StringBuilder();
		Collections.sort(lista, new Comparator<DwCalsem>() {
			@Override
			public int compare(DwCalsem o1, DwCalsem o2) {
				int retorno = o1.getDiasemana().compareTo(o2.getDiasemana());
				if (retorno == 0)
					retorno = o1.getHrInicial().compareTo(o2.getHrInicial());
				return retorno;
			}
		});
		for(DwCalsem dwCalsem: lista){			
			sb.append(dwCalsem.toString());
			sb.append(" \n"); // pula linha			
		}
		return sb.toString();
	}
	
	/**
	 * Clona lista de {@code DwCalsem}
	 * @param lista
	 * @return
	 */
	public static List<DwCalsem> cloneDwCalsems(List<DwCalsem> lista, boolean isCloneFK){
		Validate.notNull(lista, "Lista de calend�rio deve ser nula");
		
		List<DwCalsem> retorno = new ArrayList<DwCalsem>();
		for(DwCalsem dwCalsem: lista){
			DwCalsem dwCalsemClone = dwCalsem.clone(false);
			
			dwCalsemClone.setDwCal(new DwCal());
			dwCalsemClone.getDwCal().setIdCal(dwCalsem.getDwCal().getIdCal());
			
			dwCalsemClone.setDwTurno(new DwTurno());
			dwCalsemClone.getDwTurno().setIdTurno(dwCalsem.getDwTurno().getIdTurno());
			
			retorno.add(dwCalsemClone);
		}
		return retorno;
	}
	
	/**
	 * String com dados de {@code DwCalsem}
	 */
	@Override
	public String toString(){
		DwCalsem dwCalsem = (DwCalsem) this;
		StringBuilder sb = new StringBuilder();
		
		/* Comentei para substituir pela formatacao seguinte que é mais limpa
		sb.append(" dia=").append(dwCalsem.getDiasemana().intValue());
		sb.append(" idCal=").append(dwCalsem.getDwCal().getIdCal());
		sb.append(" idTurno=").append(dwCalsem.getDwTurno().getIdTurno());
		sb.append(" tpDtRef=").append(dwCalsem.getTpDtreferencia().intValue());
		sb.append(" hrInicial=").append(dwCalsem.getHrInicial().intValue());
		sb.append(" hrFinal=").append(dwCalsem.getHrFinal().intValue());				
		sb.append(" hrInicialGUI=").append(dwCalsem.getHrInicialGui());
		sb.append(" hrFimGUI=").append(dwCalsem.getHrFinalGui());
		sb.append(" inicioTurno=").append(dwCalsem.getIsInicioturno());
		sb.append(" fimTurno=").append(dwCalsem.getIsFimturno());
		sb.append(" tempoCalendario=").append(dwCalsem.getSegTempocalendario());
		sb.append(" tpDtReferencia=").append(dwCalsem.getTpDtreferencia());
		sb.append(" idCalsem=").append(dwCalsem.getIdCalsem());
		return sb.toString();*/
		
		
		sb.append("DwCalsem[ dia="+ dwCalsem.getDiasemana().intValue() + " " + dwCalsem.getHrInicialComToleranciaGUI() + " - " + dwCalsem.getHrFinalComToleranciaGUI());
		if(dwCalsem.getDwTurno() != null) {
			sb.append(" turno=");
			sb.append(dwCalsem.getDwTurno().getDsTurno());
			sb.append(" idcalsem=");
			sb.append(dwCalsem.getIdCalsem());
			sb.append(" idCal=");
			sb.append(dwCalsem.getDwCal().getIdCal());
			sb.append(" cdCal=");
			sb.append(dwCalsem.getDwCal().getCdCal());
		}
		
		if(dwCalsem.getIsInicioturno() != null && dwCalsem.getIsInicioturno()) {
			sb.append(" (INICIO DE TURNO" + getNomeTpDtreferencia(dwCalsem.getTpDtreferencia()) + ")");
		}
		
		if(dwCalsem.getIsFimturno() != null && dwCalsem.getIsFimturno()) {
			sb.append(" (FIM DE TURNO" + getNomeTpDtreferencia(dwCalsem.getTpDtreferencia()) + ")");
		}
		
		sb.append(" duracao(s)=");
		sb.append(dwCalsem.getSegTempocalendario());
		if (dwCalsem.getSegToleranciaposEmSeg() != null && dwCalsem.getSegToleranciaposEmSeg().compareTo(BigDecimal.ZERO) > 0) {
			sb.append(" pos(s)=");
			sb.append(dwCalsem.getSegToleranciaposEmSeg());
		}
		if (dwCalsem.getSegToleranciapreEmSeg() != null && dwCalsem.getSegToleranciapreEmSeg().compareTo(BigDecimal.ZERO) > 0) {
			sb.append(" pre(s)=");
			sb.append(dwCalsem.getSegToleranciapreEmSeg());
		}
		
		if (dwCalsem.getSegTempocalsempeso() != null && dwCalsem.getSegTempocalsempeso().compareTo(BigDecimal.ZERO) > 0) {
			sb.append(" semPeso(s)=");
			sb.append(dwCalsem.getSegTempocalsempeso().multiply(new BigDecimal(60)));
		}
		
		sb.append(" ]");

		return sb.toString();
		
	}
	
	private String getNomeTpDtreferencia(byte tpDtreferencia) {
		if(tpDtreferencia == TpDtReferencia.DT_REF_DIA_ANTERIOR.getId()) {
			return " REFERENCIA DIA ANTERIOR";
		}
		if(tpDtreferencia == TpDtReferencia.DT_REF_MESMO_DIA.getId()) {
			return " REFERENCIA MESMO DIA";
		}
		if(tpDtreferencia == TpDtReferencia.DT_REF_DIA_SEGUINTE.getId()) {
			return " REFERENCIA DIA SEGUINTE";
		}
		return "";
	}

	/**
	 * Inicializa campos do DWCalsem com valores padr�o
	 */
	public void init(){
		DwCalsem dwCalsem = (DwCalsem) this;
		dwCalsem.setIsFimturno(false);
		dwCalsem.setIsInicioturno(false);
		dwCalsem.setSegTempocalendario(BigDecimal.ZERO);
		dwCalsem.setSegTempocalsempeso(BigDecimal.ZERO);
		dwCalsem.setSegToleranciapos(BigDecimal.ZERO);
		dwCalsem.setSegToleranciapre(BigDecimal.ZERO);
	}		
	
	/**
	 * Atualiza campos de {@code DwCalsem}
	 * @param dwTurno
	 * @param dwCal
	 * @param diaSemana
	 * @param hrInicial
	 * @param hrFinal
	 * @param segTempoCalendario
	 * @return
	 */
	public DwCalsem set(DwTurno dwTurno, DwCal dwCal, BigDecimal diaSemana, BigDecimal hrInicial, BigDecimal hrFinal, BigDecimal segTempoCalendario){
		DwCalsem dwCalsem = (DwCalsem) this;
		
		dwCalsem.setDwTurno(dwTurno);		
		dwCalsem.setDwCal(dwCal);
		dwCalsem.setDiasemana(diaSemana);		
		dwCalsem.setHrInicial(hrInicial);
		dwCalsem.setHrFinal(hrFinal);
		dwCalsem.setSegTempocalendario(segTempoCalendario);
		return dwCalsem;
	}
	
	@Override
	protected DwCalsem atribuir(DwCalsem itemGet, DwCalsem itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwCalsem();
		
		itemSet.setIdCalsem(itemGet.getIdCalsem());
		itemSet.setDiasemana(itemGet.getDiasemana());
		itemSet.setHrFinal(itemGet.getHrFinal());
		itemSet.setHrFinalGui(itemGet.getHrFinalGui());
		itemSet.setHrInicial(itemGet.getHrInicial());		
		itemSet.setHrInicialGui(itemGet.getHrInicialGui());		
		itemSet.setIsFimturno(itemGet.getIsFimturno());
		itemSet.setIsInicioturno(itemGet.getIsInicioturno());
		itemSet.setOrdem(itemGet.getOrdem());
		itemSet.setSegTempocalendario(itemGet.getSegTempocalendario());
		itemSet.setSegTempocalsempeso(itemGet.getSegTempocalsempeso());
		itemSet.setSegToleranciapos(itemGet.getSegToleranciapos());
		itemSet.setSegToleranciapre(itemGet.getSegToleranciapre());
		itemSet.setTpDtreferencia(itemGet.getTpDtreferencia());
		
		
		if (isCopiarFK){
			itemSet.setDwTurno((DwTurno)itemGet.getDwTurno().clone(false));
			itemSet.setDwCal(new DwCal());
			itemSet.getDwCal().setIdCal(itemGet.getDwCal().getIdCal());
			//itemSet.setDwCal((DwCal) itemGet.getDwCal().clone(false));	
		}
		
	
		return itemSet;
	}
	
	
}
