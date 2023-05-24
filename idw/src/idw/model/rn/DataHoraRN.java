package idw.model.rn;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.hibernate.Session;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.MsDthr;
import injetws.model.pojos.PrColetorEventos;

public class DataHoraRN {
	public static final int _YEAR = Calendar.YEAR;
	public static final int _MONTH = Calendar.MONTH;
	public static final int _DAY = Calendar.DATE;
	public static final int _HOUR = Calendar.HOUR;
	public static final int _MINUTE = Calendar.MINUTE;
	public static final int _SECOND = Calendar.SECOND;
	public static final int _MILLISECOND = Calendar.MILLISECOND;
	public static final int _TIME_ONLY = 666;

	public static final int _MONDAY = Calendar.MONDAY;
	public static final int _TUESDAY = Calendar.TUESDAY;
	public static final int _WEDNESDAY = Calendar.WEDNESDAY;
	public static final int _THURSDAY = Calendar.THURSDAY;
	public static final int _FRIDAY = Calendar.FRIDAY;
	public static final int _SATURDAY = Calendar.SATURDAY;
	public static final int _SUNDAY = Calendar.SUNDAY;

	public static final int FORMATO_DATA_DDMMHHMM = 0;

	public static String ZERADO_HHMMSS = "00:00:00";

	/**
	 * Segundos do minuto ({@value #SEG_MIN}s)
	 * */
	public static final int SEG_MIN = 60;
	/**
	 * Segundos da hora	 ({@value #SEG_HORA}s)
	 * */
	public static final int SEG_HORA = SEG_MIN * 60;
	/**
	 * Segundos do dia	({@value #SEG_DIA}s)
	 * */
	public static final int SEG_DIA = SEG_HORA * 24;
	/**
	 * Segundos da semana ({@value #SEG_SEMANA}s)
	 */
	public static final int SEG_SEMANA = SEG_DIA * 7;

	public static Date getDataHoraAtual(){
		return new Date();
	}

	public static Date getDataHoraInicial(Date dthr) {
		return setHoraNaData(dthr, getHourAsInt(dthr), 0, 0, 0);
	}

	public static Date getDataHoraFinal(Date dthr) {
		return setHoraNaData(dthr, DataHoraRN.getHourAsInt(DataHoraRN.adicionaHorasDaData(dthr, 1)), 0, 0, 0);
	}

	public static Date getPrimeiroDiaDoMesDaData(Date dt){
		return getData(getApenasAno(dt), getApenasMes(dt), 1);
	}
	public static Date getUltimoDiaDoMesDaData(Date dt){
		return subtraiDiasDaData(getPrimeiroDiaDoMesDaData(adicionaMesNaData(dt, 1)), 1);
	}

	public static Date getDataInicioDiaAtual(){
		Date data = new Date();
		data = setHoraNaData(data, 0, 0, 0, 0);
		return data;
	}

	public static Date getData(int ano, int mes, int dia){
		Date data = new Date();


        /*
         *  Joga para o primeiro dia do m�s para evitar problema ao mudar o m�s e o ano
         *  Exemplo:
         *   Dia atual 29/01/2014,  chamo getData(2014, 2, 3)
         *   Ao mudar a o m�s para o Fevereiro, estando no dia 29, ele mudava a data para mar�o
         */
		data = setDiaNaData(data, 1);

		data = setAnoNaData(data, ano);
		data = setMesNaData(data, mes);
		data = setDiaNaData(data, dia);

		data = setHoraNaData(data, 0, 0, 0, 0);

		return data;
	}

	public static Date getDataHora(int ano, int mes, int dia, int horas, int minutos, int segundos, int mili){
		Date data = getData(ano, mes, dia);

		data = setHoraNaData(data, horas, minutos, segundos, mili);

		return data;
	}

	/**
	 * Busca a data hora do banco de dados
	 * @param oSessao
	 * @return
	 */
	public static Date getDataHoraSgbd(Session oSessao){
		MsDthr msDthr;
		MapQuery q = new MapQuery(oSessao);
		q.append("select msDthr FROM MsDthr msDthr");
		q.setMaxResults(1);
		msDthr = (MsDthr) q.uniqueResult();
		return msDthr.getDthrSgbd();
	}

	public static String getDataHoraMiliAtualFormatada(){
		return dateToStringYYYYMMDDHHMMSSmili(getDataHoraAtual());
	}

	public static String getDataHoraAtualFormatada(){
		return dateToStringYYYYMMDDHHMMSS(getDataHoraAtual());
	}

	public static String dateToStringYYYYMMDDHHMMSSmili(Date pDateTime){
		int mili = getApenasMilisegundos(pDateTime);
		NumberFormat formatter = new DecimalFormat("000");
		return dateToString(pDateTime, "yyyy-MM-dd HH:mm:ss") + "." + formatter.format(mili);
	}


	public static Date stringToDate(String dthr, String formato){
		SimpleDateFormat sim = new SimpleDateFormat(formato);
        java.util.Date datum = null;
        
        if(dthr!=null){
            try{
                datum = sim.parse(dthr);
           }catch(ParseException e){
           	datum = new Date();
           }        	
        }
        else{
        	datum = new Date();
        }
        
		return datum;
	}

	public static String dateToStringYYYYMM(Date pDateTime, String separador){
		String m = Integer.toString(DataHoraRN.getApenasMes(pDateTime));

		if (m.length() == 1) {
			m = "0" + m;
		}

		separador = ObjectUtils.defaultIfNull(separador, "");

		return DataHoraRN.getApenasAno(pDateTime) + separador + m;
	}

	public static String dateToStringYYYYMMDDHHMMSS(Date pDateTime){
		if (pDateTime == null)
			return "";
		return dateToString(pDateTime, "yyyy-MM-dd HH:mm:ss");
	}

	public static String dateToStringYYYYMMDDHHMMSSparaREST(Date pDateTime){
		if (pDateTime == null)
			return "";
		return dateToString(pDateTime, "yyyy-MM-dd-HH:mm:ss");
	}
	
	public static String dateToStringYYYYDDMMHHMMSS(Date pDateTime){
		if (pDateTime == null)
			return "";
		return dateToString(pDateTime, "yyyy-dd-MM HH:mm:ss");
	}

	public static String getHoraFormatoHHMMSS(Date pDateTime){
		return dateToString(pDateTime, "HH:mm:ss");
	}

    public static String dateToString(Date pDateTime, String formato) {
    	if(pDateTime == null || formato == null) {
    		return "";
    	}
        SimpleDateFormat formater = new SimpleDateFormat(formato);
        return formater.format(pDateTime);
    }

	public static int getQuantidadeDiasNoPeriodo(Date pDataInicial, Date pDataFinal){
		int qtDias;

		qtDias = (int) ((pDataFinal.getTime() - pDataInicial.getTime()) / (1000 * 60 * 60 * 24));

		return qtDias;
	}

	// REPLACED
	public static int getQuantidadeHorasNoPeriodo(Date pHoraInicial, Date pHoraFinal){
		int qtHoras;

		qtHoras = (int) ((pHoraFinal.getTime() - pHoraInicial.getTime()) / (1000 * 60 * 60));

		return qtHoras;
	}

	public static int getQuantidadeMinutosNoPeriodo(Date pHoraInicial, Date pHoraFinal){
		int qtMinutos;

		qtMinutos = (int) ((pHoraFinal.getTime() - pHoraInicial.getTime()) / (1000 * 60));

		return qtMinutos;
	}

	/**
	 * Obtem quantidade de segundos com os milisegundos, usando 3 casas decimais
	 * @param pHoraInicial
	 * @param pHoraFinal
	 * @return
	 */
	public static BigDecimal getQuantidadeSegundosComMilisegundosNoPeriodo(Date pHoraInicial, Date pHoraFinal){
		return getQuantidadeSegundosComMilisegundosNoPeriodo(pHoraInicial, pHoraFinal, 3);
	}

	/**
	 * Obtem quantidade de segundos com os milisegundos, usando 5 casas decimais
	 * @param pHoraInicial
	 * @param pHoraFinal
	 * @return
	 */
	public static BigDecimal getQuantidadeSegundosComMilisegundosNoPeriodoComScale5(Date pHoraInicial, Date pHoraFinal){
		return getQuantidadeSegundosComMilisegundosNoPeriodo(pHoraInicial, pHoraFinal, 5);
	}

	/**
	 * Obtem quantidade de segundos com os milisegundos
	 * @param pHoraInicial
	 * @param pHoraFinal
	 * @param scale numero de casas decimais
	 * @return
	 */
	public static BigDecimal getQuantidadeSegundosComMilisegundosNoPeriodo(Date pHoraInicial, Date pHoraFinal, int scale){
		BigDecimal tempo = new BigDecimal(getQuantidadeMilisegundosNoPeriodo(pHoraInicial, pHoraFinal));
		tempo = tempo.divide(new BigDecimal(1000), MathContext.DECIMAL32).setScale(scale);
		return tempo;
	}


	public static int getQuantidadeSegundosNoPeriodoTrantandoNulo(Date pHoraInicial, Date pHoraFinal){
		if(pHoraInicial == null || pHoraFinal == null){
			return 0;
		}
		return getQuantidadeSegundosNoPeriodo(pHoraInicial, pHoraFinal);

	}

	public static int getQuantidadeSegundosNoPeriodo(Date pHoraInicial, Date pHoraFinal){
		int qtSegundos = 0;
		if (pHoraFinal != null)
			qtSegundos = (int) ((pHoraFinal.getTime() - pHoraInicial.getTime()) / 1000);

		return qtSegundos;
	}

	public static int getQuantidadeSegundosNaIntersecao(Date pHoraInicial, Date pHoraFinal, Date dthr2Inicial, Date dthr2Final){
		Date dthrinicial = pHoraInicial;
		Date dthrfinal = pHoraFinal;
		if (isIntersecao(pHoraInicial, pHoraFinal, dthr2Inicial, dthr2Final)) {
			if (DataHoraRN.before(dthrinicial, dthr2Inicial))
				dthrinicial = dthr2Inicial;

			if (after(dthrfinal, dthr2Final))
				dthrfinal = dthr2Final;

			if (after(dthrinicial, dthrfinal))
				return 0;
		} else
			return 0;

		return getQuantidadeSegundosNoPeriodo(dthrinicial, dthrfinal);
	}

	public static long getQuantidadeMilisegundosNaIntersecao(Date pHoraInicial, Date pHoraFinal, Date dthr2Inicial, Date dthr2Final){
		Date dthrinicial = pHoraInicial;
		Date dthrfinal = pHoraFinal;
		if (isIntersecao(pHoraInicial, pHoraFinal, dthr2Inicial, dthr2Final)) {
			if (before(dthrinicial, dthr2Inicial))
				dthrinicial = dthr2Inicial;

			if (after(dthrfinal, dthr2Final))
				dthrfinal = dthr2Final;

			if (after(dthrinicial, dthrfinal))
				return 0;
		} else
			return 0;

		return getQuantidadeMilisegundosNoPeriodo(dthrinicial, dthrfinal);
	}

	public static void main(String[] args) {
		Date inicio = DataHoraRN.getDataHora(2015, 6, 19, 06, 3, 59, 0);
		Date fim = DataHoraRN.getDataHora(2015, 6, 19, 06, 4, 9, 0);
		System.out.println(DataHoraRN.getQuantidadeSegundosNoPeriodo(inicio, fim));
		System.out.println("toCalendar = " + DataHoraRN.toCalendar(new Date()));
	}
	/**
	 * Obt�m a quantidade de milisegundos entre duas datas.
	 * @param pDataInicial
	 * @param pDataFinal
	 * @return int contendo a quantidade de milisegundos
	 */
	public static long getQuantidadeMilisegundosNoPeriodo(Date pDataInicial, Date pDataFinal){
		long qtMiliSec=0l;

		if (pDataFinal != null && pDataInicial != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(pDataInicial);
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(pDataFinal);

			qtMiliSec = calendar2.getTimeInMillis() - calendar.getTimeInMillis();

		}

		return qtMiliSec;
	}

	public static String getIntervaloFormatoHHMMSS(Date pDataInicial, Date pDataFinal){
		String retorno = "00:00:00";

		if (pDataFinal != null && pDataInicial != null)
		  return  formatSegundosParaHHMMSS(getQuantidadeSegundosNoPeriodo(pDataInicial, pDataFinal));

		return retorno;
	}

	public static int getApenasMilisegundos(Date data){
		if (data == null)
			return 0;
        Calendar c = new GregorianCalendar();
        c.setTime(data);
        return c.get(Calendar.MILLISECOND);
	}

	public static int getApenasSegundos(Date data){
		if (data == null)
			return 0;
        Calendar c = new GregorianCalendar();
        c.setTime(data);
        return c.get(Calendar.SECOND);
	}

	public static int getApenasAno(Date data){
		if (data == null)
			return 0;
        Calendar c = new GregorianCalendar();
        c.setTime(data);
        return c.get(Calendar.YEAR);
	}
	public static int getApenasMes(Date data){
		if (data == null)
			return 0;
        Calendar c = new GregorianCalendar();
        c.setTime(data);
        return c.get(Calendar.MONTH) + 1; // soma 1 senao janeiro seria 0
	}
	public static int getApenasDia(Date data){
		if (data == null)
			return 0;
        Calendar c = new GregorianCalendar();
        c.setTime(data);
        return c.get(Calendar.DAY_OF_MONTH);
	}
	
	public static int getApenasHoras(Date data){
		if (data == null) {
			return 0;
		}
        Calendar c = new GregorianCalendar();
        c.setTime(data);
        return c.get(Calendar.HOUR_OF_DAY);
	}

	public static int getApenasMinutos(Date data){
		if (data == null) {
			return 0;
		}
        Calendar c = new GregorianCalendar();
        c.setTime(data);
        return c.get(Calendar.MINUTE);
	}

	public static Date getDataComMilisegundos(Date data, double milisegundos){
        Calendar c = new GregorianCalendar();
        c.setTime(data);
        c.set(Calendar.MILLISECOND,(int) milisegundos);
        return c.getTime();
	}
	public static Date setHoraNaData(Date data, int hora, int minuto, int segundo, int mili){
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		c.set(Calendar.HOUR_OF_DAY, hora);
		c.set(Calendar.MINUTE, minuto);
		c.set(Calendar.SECOND, segundo);
		c.set(Calendar.MILLISECOND, mili);
		return c.getTime();
	}
	public static Date setMiliNaData(Date data, int milisegundo){
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		c.set(Calendar.MILLISECOND, milisegundo);
		return c.getTime();
	}

	public static Date setAnoNaData(Date data, int ano){
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		c.set(Calendar.YEAR, ano);
		return c.getTime();
	}
	public static Date setMesNaData(Date data, int mes){
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		c.set(Calendar.MONTH, mes - 1);
		return c.getTime();
	}
	public static Date setDiaNaData(Date data, int dia){
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		c.set(Calendar.DATE, dia);
		return c.getTime();
	}

	public static Date setHoraNaData(Date data, int ano){
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		c.set(Calendar.HOUR, ano);
		return c.getTime();
	}
	public static Date setMinNaData(Date data, int mes){
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		c.set(Calendar.MINUTE, mes - 1);
		return c.getTime();
	}
	public static Date setSegNaData(Date data, int dia){
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		c.set(Calendar.SECOND, dia);
		return c.getTime();
	}

	public static Date getDataHoraInicioMes(Date data){
		Date dtIni = DataHoraRN.setDiaNaData(data, 1);
		dtIni = DataHoraRN.getDataSemHora(dtIni);
		return dtIni;
	}

	public static Date getDataHoraFimMes(Date data){
		Date dtFim = DataHoraRN.adicionaMesNaData(data, 1);
		dtFim = DataHoraRN.adicionaDiasDaData(dtFim, -1);
		dtFim = DataHoraRN.getDataHora235959(dtFim);
		return dtFim;
	}

	public static Date getDataSemHora(Date data){
		return setHoraNaData(data, 0, 0,0, 0);
	}

	public static Date getDataSemMinutosSegundosMilissegundos(Date data) {
		return getDataHoraInicial(data);
	}

	public static Date getDataSemMilissegundo(Date data){
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

    public static Date getDataHora235959(Date data) {
    	return setHoraNaData(data, 23, 59 ,59, 999);
    }

	public static int getHHMMEmSegundos(String dt){
		int retorno = 0;

		retorno = Integer.valueOf(dt.substring(0, 2));
		retorno *= 3600;
		retorno = (Integer.valueOf(dt.substring(3)) * 60);

		return retorno;
	}
	
	// Ricardo: 10/02/2023
	public static int getHHMMEmSegundosCorrigida(String hrHHMM){
		int retorno = 0;

		retorno = Integer.valueOf(hrHHMM.substring(0, 2));
		retorno *= 3600;
		retorno += (Integer.valueOf(hrHHMM.substring(3)) * 60);

		return retorno;
	}


	public static String formatSegundosParaHHMM(Integer tempoEmSegundos) {
        String retorno = "00:00";

        if (tempoEmSegundos <= 0)
        	return retorno;

        int horas = 0;
        int minutos = 0;
        int tempInteiro = 0;
        float tempResto = 0f;

        tempInteiro = tempoEmSegundos;
        horas = tempInteiro / 3600;
        tempResto = tempInteiro % 3600;
        tempInteiro = (int) (tempResto / 60f);
        minutos = tempInteiro;
//        tempResto = tempResto % 60f;

        int hora = horas;
        int minuto = minutos;

        retorno = (hora < 10 ? "0" + hora : hora) + ":" + (minuto < 10 ? "0" + minuto : minuto);

        return retorno;
    }

	public static String formatSegundosParaHHMMSS(BigDecimal tempoEmSegundos) {
		if(tempoEmSegundos == null) {
			return formatSegundosParaHHMMSS(0);
		}
		return formatSegundosParaHHMMSS(tempoEmSegundos.intValue());
	}

	public static String formatSegundosParaHHMMSSRound(BigDecimal tempoEmSegundos) {
		if(tempoEmSegundos == null) {
			return formatSegundosParaHHMMSS(0);
		}
		
		tempoEmSegundos = tempoEmSegundos.divide(BigDecimal.ONE).setScale(0, BigDecimal.ROUND_HALF_UP);
		return formatSegundosParaHHMMSS(tempoEmSegundos.intValue());
	}
	
	
	public static String formatSegundosParaHHMMSS(Integer tempoEmSegundos) {
        String retorno = "00:00:00";
        boolean isNegativo = (tempoEmSegundos < 0);

        if (IdwFacade.IS_IDW_ATIVO) {
	        if (tempoEmSegundos <= 0)
	        	return retorno;
        }
        
        tempoEmSegundos = Math.abs(tempoEmSegundos);
                
        int horas = 0;
        int minutos = 0;
        int tempInteiro = 0;
        int tempResto = 0;

        tempInteiro = tempoEmSegundos;
        horas = tempInteiro / 3600;
        tempResto = tempInteiro % 3600;
        tempInteiro = tempResto / 60;
        minutos = tempInteiro;
        tempResto = tempResto % 60;
        tempInteiro = tempResto / 60;

        int hora = horas;
        int minuto = minutos;

        retorno = (hora < 10 ? "0" + hora : hora) + ":" + (minuto < 10 ? "0" + minuto : minuto) + ":" + (tempResto < 10 ? "0" + tempResto : tempResto);

        if (isNegativo) {
        	retorno = "-" + retorno;
        }
        
        return retorno;
    }

	public static String formatMilisegundosParaHHMMSSmmm(long millis) {
		return DurationFormatUtils.formatDuration(millis, "HH:mm:ss.SSS");
	}

	public static String formatMilisegundosParaHHMMSS(long millis) {
		return DurationFormatUtils.formatDuration(millis, "HH:mm:ss");
	}

	public static int obtemApenasHHDoSegundos(Integer tempoEmSegundos) {
        int retorno = 0;

        if (tempoEmSegundos <= 0)
        	return retorno;

        int tempInteiro = 0;

        tempInteiro = tempoEmSegundos;
        retorno = tempInteiro / 3600;
        return retorno;
    }

	public static int obtemApenasMMDoSegundos(Integer tempoEmSegundos) {
        int retorno = 0;

        if (tempoEmSegundos <= 0)
        	return retorno;

        int tempInteiro = 0;
        float tempResto = 0f;

        tempInteiro = tempoEmSegundos;
        tempResto = tempInteiro % 3600;
        tempInteiro = (int) (tempResto / 60f);
        retorno = tempInteiro;
        return retorno;
    }

	public static int obtemApenasSSDoSegundos(Integer tempoEmSegundos) {
        int retorno = 0;

        if (tempoEmSegundos <= 0)
        	return retorno;

        int tempInteiro = 0;
        float tempResto = 0f;

        tempInteiro = tempoEmSegundos;
        tempResto = tempInteiro % 3600;
        tempInteiro = (int) (tempResto / 60f);
        tempResto = tempResto % 60f;

        return (int) tempResto;
    }

	/**
	 * Pega os segundos dos dia
	 * @param data
	 * @return
	 */

	public static int getSegundosDoDia(Date data){
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		return (cal.get(Calendar.HOUR_OF_DAY) * 60 * 60)
				+ (cal.get(Calendar.MINUTE) * 60)
				+ (cal.get(Calendar.SECOND));
	}

	public static Date subtraiHorasDaData(Date data, int horas){
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.HOUR_OF_DAY, horas * -1);
		return cal.getTime();
	}
	public static Date adicionaHorasDaData(Date data, int horas){
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.HOUR_OF_DAY, horas);
		return cal.getTime();
	}
	public static Date subtraiDiasDaData(Date data, int dias){
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.DAY_OF_MONTH, dias * -1);
		return cal.getTime();
	}
	public static Date adicionaDiasDaData(Date data, int dias){
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.DAY_OF_MONTH, dias);
		return cal.getTime();
	}
	public static Date subtraiSegundosDaData(Date data, int segundos){
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.SECOND, segundos * -1);
		return cal.getTime();
	}
	public static Date subtraiMilisegundosNaData(Date data, int milisegundos){
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MILLISECOND, milisegundos * -1);
		return cal.getTime();
	}
	public static Date adicionaSegundosNaData(Date data, int segundos){
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.SECOND, segundos);
		return cal.getTime();
	}
	public static Date adicionaMilisegundosNaData(Date data, int milisegundos){
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MILLISECOND, milisegundos);
		return cal.getTime();
	}
	public static Date adicionaMinutosNaData(Date data, int minutos){
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MINUTE, minutos);
		return cal.getTime();
	}
	public static Date subtraiMinutosNaData(Date data, int minutos){
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MINUTE, minutos * -1);
		return cal.getTime();
	}
	
	public static Date adicionaMesNaData(Date data, int meses){
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MONTH, meses);
		return cal.getTime();
	}
	public static boolean isMesAnoIguais(Date data1, Date data2){
		return (getApenasAno(data1) == getApenasAno(data2) && getApenasMes(data1) == getApenasMes(data2));
	}

	public static boolean isDiaMesAnoIguais(Date data1, Date data2){
		return (getApenasDia(data1) == getApenasDia(data2) && getApenasAno(data1) == getApenasAno(data2) && getApenasMes(data1) == getApenasMes(data2));
	}

	public static boolean isIntersecaoSemIgualdade(Date dAvaliada, Date inicio, Date fim){
		return (after(dAvaliada, inicio) && DataHoraRN.before(dAvaliada, fim));
	}

	public static boolean isIntersecao(Date dAvaliada, Date inicio, Date fim){

		if (equals(dAvaliada, inicio) || equals(dAvaliada, fim)){
			return true;
		}else{
			return isIntersecaoSemIgualdade(dAvaliada, inicio, fim);
		}

	}

	public static boolean isIntersecao(Date dAvaliadaI, Date dAvaliadaF, Date inicio, Date fim){
		boolean isRetorno = false;

		if (DataHoraRN.isIntersecao(dAvaliadaI, inicio, fim) == true)
			isRetorno = true;
		else if (DataHoraRN.isIntersecao(dAvaliadaF, inicio, fim) == true)
			isRetorno = true;
		else if (DataHoraRN.isIntersecao(inicio, dAvaliadaI, dAvaliadaF) == true)
			isRetorno = true;
		else if (DataHoraRN.isIntersecao(fim, dAvaliadaI, dAvaliadaF) == true)
			isRetorno = true;

		return isRetorno;
	}
	public static boolean isDataPertenceAoMes(Date data, int ano, int mes){
		return (DataHoraRN.getApenasAno(data) == ano && DataHoraRN.getApenasMes(data) == mes);
	}

	public static boolean isDomingo(Date data){
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		return (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
	}
	public static int getWeekDay(Date pDate) {
		Calendar calendario = Calendar.getInstance();

		// Cria calend�rio
		calendario.setTime(pDate);

		// Retorna verdadeiro se o dia for s�bado ou domingo
		return calendario.get(Calendar.DAY_OF_WEEK);

	}

    public static Date concatenaPrimeiroDataSegundoHora(Date pegaApenasData, Date pegaApenasHora){
    	String dataIntermediaria = toStringYYYYMMDD(pegaApenasData) + " " + toStringHHMISS(pegaApenasHora);
    	Date retorno = null;
    	try {
			retorno = toDateFromYYYYMMDDHHMISS(dataIntermediaria);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return retorno;
    }
	public static Date regressDate(Date pDataReferencia, int pQtDias) {
		Calendar calendario = Calendar.getInstance();

		calendario.setTime(pDataReferencia);
		calendario.add(Calendar.DATE, -pQtDias);

		return new Date(calendario.getTime().getTime());
	}
	public static Date advanceDate(Date pDataReferencia, int pQtDias) {
		Calendar calendario = Calendar.getInstance();

		calendario.setTime(pDataReferencia);
		calendario.add(Calendar.DATE, pQtDias);

		return new Date(calendario.getTime().getTime());
	}
    public static String toStringYYYYMMDD(java.util.Date pDateTime) {
        String dt = "";
        SimpleDateFormat formater = new SimpleDateFormat(
                "yyyy-MM-dd");

        dt = formater.format(pDateTime);
        return dt;
    }
    public static String toStringDDMMYY(java.util.Date pDateTime) {
        String dt = "";
        SimpleDateFormat formater = new SimpleDateFormat(
                "dd/MM/yy");

        dt = formater.format(pDateTime);
        return dt;
    }

    public static String toStringHHMISS(java.util.Date pDateTime) {
        String dt = "";
        SimpleDateFormat formater = new SimpleDateFormat(
                "HH:mm:ss");

        dt = formater.format(pDateTime);
        return dt;
    }

    public static Date toDateFrom(String padrao, String pDataHora) throws ParseException {
		java.util.Date dt = null;
		SimpleDateFormat formatador;

		formatador = new SimpleDateFormat(padrao);
		dt = formatador.parse(pDataHora);
		return dt;
	}

	public static Date toDateFromYYYYMMDDHHMISS(String pDataHora) throws ParseException {
		java.util.Date dt = null;
		SimpleDateFormat formatador;

		formatador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dt = formatador.parse(pDataHora);
		return dt;
	}

	public static Date toDateFromYYYYMMDDHHMI(String pDataHora) throws ParseException {
		java.util.Date dt = null;
		SimpleDateFormat formatador;

		formatador = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		dt = formatador.parse(pDataHora);
		return dt;
	}

	public static String dateToStringDDMMYYYYHHMMSS(XMLGregorianCalendar pDateTime) {
        return dateToStringDDMMYYYYHHMMSS(DataHoraRN.converteXMLCalendarParaDate(pDateTime));
    }

	public static Date converteXMLCalendarParaDate(XMLGregorianCalendar data) {
        if (data == null) {
            return null;
        }
        return data.toGregorianCalendar().getTime();
    }

	public static String dateToStringDDMMYYYYHHMMSS(Date pDateTime) {
		if (pDateTime == null)
			return "";
        return dateToString(pDateTime, "dd/MM/yyyy HH:mm:ss");
    }

	public static String dateToStringDDMMYYYY(Date pDateTime) {
		if (pDateTime == null)
			return "";
        return dateToString(pDateTime, "dd/MM/yyyy");
    }

	public static String dateToStringDDMMYYYYHHMMSSms(Date pDateTime) {
		if (pDateTime == null)
			return "";
		int mili = getApenasMilisegundos(pDateTime);
		NumberFormat formatter = new DecimalFormat("000");
        return dateToString(pDateTime, "dd/MM/yyyy HH:mm:ss") + "." + formatter.format(mili);
    }

	public static String dateToStringDDMMHHMM(Date pDateTime) {
        return dateToString(pDateTime, "dd/MM HH:mm");
    }

	public static String dateToStringHH(Date pDateTime) {
        return dateToString(pDateTime, "HH");
    }

	/**
	 * Obtem tempo em segundos de uma determinada data, por exemplo:
	 * data = '17/04/2007 10:33:17'
	 * tempo em segundos = 10*3600 + 33*60 + 17
	 * @param pDateTime - Date contendo uma data no formato DD/MM/YYYY HH:MM:SS
	 * @return int - tempo em segundos desde o in�cio do dia informado em pDateTime
	 */
	public static int getTimeInSeconds(Date pDateTime){
		int resultado = 0;
		String str = "";
		int h=0,m=0,s=0;

		str = getTimeHHMMSSASString(pDateTime);
		h= Integer.parseInt(str.substring(0, 2));
		m= Integer.parseInt(str.substring(3, 5));
		s= Integer.parseInt(str.substring(6, 8));

		resultado = h*3600 + m*60 + s;

		return resultado;
	}
	public static String getTimeHHMMSSASString(Date pTime) {
        String dt = "";
        SimpleDateFormat formater = new SimpleDateFormat(
                "HH:mm:ss");

        dt = formater.format(pTime);
        return dt;
    }

	/**
	 * Cria um novo objeto java.util.Date com base na precis�o informada
	 *  @param pDate
	 *  @param precision a precis�o a ser adotada na cria��o do objeto
	 *  @return o novo objeto Date
	 * */
	public static Date normalize(Date pDate, int precision) {

		GregorianCalendar completeDate = new GregorianCalendar();
		GregorianCalendar normalizedDate = new GregorianCalendar();

		completeDate.setTime(pDate);

		switch (precision) {

		case _YEAR:
			normalizedDate.set(completeDate.get(Calendar.YEAR), 0, 0, 0, 0, 0);
		break;

		case _MONTH:
			normalizedDate.set(completeDate.get(Calendar.YEAR), completeDate.get(Calendar.MONTH), 0, 0, 0, 0);
		break;

		case _DAY:
			normalizedDate.set(completeDate.get(Calendar.YEAR), completeDate.get(Calendar.MONTH), completeDate.get(Calendar.DATE), 0, 0, 0);
		break;

		case _HOUR:
			normalizedDate.set(completeDate.get(Calendar.YEAR), completeDate.get(Calendar.MONTH), completeDate.get(Calendar.DATE), completeDate.get(Calendar.HOUR), 0, 0);
			break;

		case _MINUTE:
			normalizedDate.set(completeDate.get(Calendar.YEAR), completeDate.get(Calendar.MONTH), completeDate.get(Calendar.DATE), completeDate.get(Calendar.HOUR), completeDate.get(Calendar.MINUTE), 0);

		case _SECOND:
			normalizedDate.set(completeDate.get(Calendar.YEAR), completeDate.get(Calendar.MONTH), completeDate.get(Calendar.DATE), completeDate.get(Calendar.HOUR), completeDate.get(Calendar.MINUTE), completeDate.get(Calendar.SECOND));

		case _MILLISECOND:
			// TODO bugado (melhorar testes)
			normalizedDate.setTimeInMillis(completeDate.getTimeInMillis());

		case _TIME_ONLY:
			//TODO Experimental criado para ser utilizado nas regras de neg�cio do Integrator
			normalizedDate.set( completeDate.get(Calendar.HOUR), completeDate.get(Calendar.MINUTE), completeDate.get(Calendar.SECOND) );
		}

		return normalizedDate.getTime();

	}

	//DataHoraRN de injetws segue abaixo
	public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

	/*Sustitu�do por m�todo que obtem da view ms_dtHr
	 *
	 *
	public static Date getDataHoraAtual(DAOGenerico daoPdba){

		Date dataHoraAtual=null;
		int tries=0;

		do{
			try{
				dataHoraAtual=(Date)daoPdba.getSession().createSQLQuery("SELECT DTHR FROM PR_DTHR").uniqueResult();
			}catch(Exception e){
				e.printStackTrace();
			}
			tries++;
		}while(dataHoraAtual == null && tries<10);
		if(dataHoraAtual==null){
			dataHoraAtual= new Date();
		}
		return dataHoraAtual;

	}*/

	public static Date getDataHoraUltimoEvento(DAOGenerico daoPdba,String idColetor){

		Date dataHoraUltimoEvento=null;

		try{

			MapQuery q = new MapQuery(daoPdba.getSession());
			q.append("select prcoletoreventos ");
			q.append("from PrColetorEventos prcoletoreventos ");
			q.append("where prcoletoreventos.prUp.idup in (");
			q.append("select prup.idup ");
			q.append( "from PrUp prup ");
			q.append("join prup.prSubColetor prsubcoletor ");
			q.append( "join prsubcoletor.prColetor prcoletor ");
			q.append( "where prcoletor.idcoletor = :idcoletor and prup.stativa = '1' ) ");
			q.append("order by prcoletoreventos.ideventocoletor desc");

			q.defineParametro("idcoletor", idColetor);
			q.query().setMaxResults(1);

			PrColetorEventos prcoletoreventos = (PrColetorEventos) q.query().uniqueResult();
			// Obtem a data e hora do evento mais recente deste coletor.
			dataHoraUltimoEvento= getDataComMilisegundos(
					prcoletoreventos.getDthr2evento(),prcoletoreventos.getMsdthr2evento());

		}catch(Exception e){
			//e.printStackTrace();
		}

		return dataHoraUltimoEvento;

	}

	public static String dateToStringYYYYMMDDHHMMSSms(Date pDateTime){
		return dateToString(pDateTime, YYYYMMDDHHMMSS) + "," + String.valueOf(getApenasMilisegundos(pDateTime));
	}

	public static Date trySaveDthrEvent(Date iniCic, Date fimCic, float tempolimite){
		Date retorno=null;
		// compara as horas somente e verifica se consegue recuperar a data para um evento confi�vel.
		// Caso seja devolve a nova data.
		// Caso n�o seja devolve null
		Calendar tmpc = new GregorianCalendar();
		tmpc.setTime(fimCic);
		Calendar inic = new GregorianCalendar();
		inic.setTime(iniCic);
		//Alimenta Calendars
		Calendar fimc = new GregorianCalendar();
		fimc.setTime(iniCic);
		fimc.set(Calendar.HOUR_OF_DAY, tmpc.get(Calendar.HOUR_OF_DAY));
		fimc.set(Calendar.MINUTE, tmpc.get(Calendar.MINUTE));
		fimc.set(Calendar.SECOND, tmpc.get(Calendar.SECOND));
		fimc.set(Calendar.MILLISECOND, tmpc.get(Calendar.MILLISECOND));

		if(fimc.before(inic)){
			fimc.add(Calendar.DAY_OF_MONTH, 1);
		}
		//obtem diferen�a e v� se � valido
		Long diff=getQuantidadeMilisegundosNoPeriodo(inic.getTime(), fimc.getTime());
		float diffemseg=diff/1000;
		if(diffemseg<=tempolimite){
			retorno=fimc.getTime();
		}
		return retorno;
	}

	public static Date getDataSemMilisegundos(Date data){
        Calendar c = new GregorianCalendar();
        c.setTime(data);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
	}

	public static Date somaSegundos(Date data, int segundos){
		GregorianCalendar dtGregoriana = new GregorianCalendar();
		dtGregoriana.setTime(data);
		dtGregoriana.add(Calendar.SECOND, segundos);
		java.util.Date datum = new java.util.Date();
		datum = dtGregoriana.getTime();

		return datum;
	}

	public static Date somaMiliSegundos(Date data, int milisegundos){
		GregorianCalendar dtGregoriana = new GregorianCalendar();
		dtGregoriana.setTime(data);
		dtGregoriana.add(Calendar.MILLISECOND, milisegundos);
		java.util.Date datum = new java.util.Date();
		datum = dtGregoriana.getTime();

		return datum;
	}

	public static boolean validaStringDtHr(String dtHr)	//vlauria 20100322
	{

		try
		{
			@SuppressWarnings("unused")
			Date dt = stringToDate(dtHr,YYYYMMDDHHMMSS);
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}

	// MS DataHoraRN segue abaixo

	public static Date getDataHoraAtual(DAOGenerico dao){
		MapQuery q = new MapQuery(dao.getSession());
		q.append("from MsDthr msdthr");
		q.setMaxResults(1);
		return ((MsDthr) q.uniqueResult()).getDthrSgbd();
	}


	public static Date setHoraNaData(Date data, int hora, int minuto, int segundo){
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		c.set(Calendar.HOUR_OF_DAY, hora);
		c.set(Calendar.MINUTE, minuto);
		c.set(Calendar.SECOND, segundo);
		return c.getTime();
	}


	/**
	 *
	 * Tempo da interse��o entre periodos em segundos com milisegundos
	 *
	 * @param dtHrIPeriodo1
	 * @param dtHrFPeriodo1
	 * @param dtHrIPeriodo2
	 * @param dtHrFPeriodo2
	 * @return
	 * @see DataHoraRN#getTempoIntersecaoEmMilisegundos(Date, Date, Date, Date)
	 */
	public static BigDecimal getTempoIntersecaoEmSegundosComMilisegundos(Date dtHrIPeriodo1, Date dtHrFPeriodo1,
			Date dtHrIPeriodo2, Date dtHrFPeriodo2){

		Long ms = DataHoraRN.getTempoIntersecaoEmMilisegundos(dtHrIPeriodo1, dtHrFPeriodo1, dtHrIPeriodo2, dtHrFPeriodo2);

		if(ms == 0){
			return BigDecimal.ZERO;
		}

		return new BigDecimal(ms).divide(new BigDecimal(1000, MathContext.DECIMAL32)).setScale(3);

	}

	/**
	 *  Tempo da interse��o entre periodos
	 *  <br> Se algum dos per�odos forem iguais, retorna 0
	 * @param dtHrIPeriodo1
	 * @param dtHrFPeriodo1
	 * @param dtHrIPeriodo2
	 * @param dtHrFPeriodo2
	 */
	public static Long getTempoIntersecaoEmMilisegundos(Date dtHrIPeriodo1, Date dtHrFPeriodo1, Date dtHrIPeriodo2, Date dtHrFPeriodo2) {
		Validate.notNull(dtHrIPeriodo1, "getTempoIntersecaoEmMilisegundos.Periodo 1 inicial nao pode ser nulo");
		Validate.notNull(dtHrFPeriodo1, "getTempoIntersecaoEmMilisegundos.Periodo 1 final nao pode ser nulo");
		Validate.notNull(dtHrIPeriodo2, "getTempoIntersecaoEmMilisegundos.Periodo 2 inicial nao pode ser nulo");
		Validate.notNull(dtHrFPeriodo2, "getTempoIntersecaoEmMilisegundos.Periodo 2 final nao pode ser nulo");


		// Se algum dos per�odos forem iguais tiverem o in�cio e fim iguais, retorna 0
		if(equals(dtHrIPeriodo1,dtHrFPeriodo1) || equals(dtHrIPeriodo2, dtHrFPeriodo2)){
			return 0L;
		}

		// Data de in�cio deve ser menor ou igual ao fim
		Validate.isTrue(compareTo(dtHrIPeriodo1, dtHrFPeriodo1) <= 0, "Data de inicio do periodo 1, deve ser menor que data de fim do periodo 1 " + dtHrIPeriodo1 + " > " + dtHrFPeriodo1);
		Validate.isTrue(compareTo(dtHrIPeriodo2, dtHrFPeriodo2) <= 0, "Data de inicio do periodo 2, deve ser menor que data de fim do periodo 2 " + dtHrIPeriodo2 + " > " + dtHrFPeriodo2);


		if (compareTo(dtHrIPeriodo1, dtHrFPeriodo2) > 0 || compareTo(dtHrFPeriodo1, dtHrIPeriodo2) < 0) {
			return 0L;
		}

		// Pega a maior data/hora de início
		Date dtHrIRef = (dtHrIPeriodo1.getTime() < dtHrIPeriodo2.getTime() ? dtHrIPeriodo2: dtHrIPeriodo1);
		// Pega a menor data/hora de fim
		Date dtHrFRef = (dtHrFPeriodo1.getTime() < dtHrFPeriodo2.getTime() ? dtHrFPeriodo1: dtHrFPeriodo2);

		return getQuantidadeMilisegundosNoPeriodo(dtHrIRef, dtHrFRef);

	}

	public static boolean equals(Date d1, Date d2) {
		return compareTo(d1, d2) == 0;
	}

	/**
	 * Compara duas datas usando o {@link Date#getTime()}
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int compareTo(Date d1, Date d2) {
		return Long.compare(d1.getTime(), d2.getTime());
	}

	public static boolean before(Date d1, Date d2){
		return DataHoraRN.compareTo(d1, d2) == -1;
	}

	public static boolean after(Date d1, Date d2){
		return DataHoraRN.compareTo(d1, d2) == 1;
	}

	public static boolean between(Date dtHr, Date dthrIniPeriodo, Date dtHrFimPeriodo){
		if ( (after(dtHr, dthrIniPeriodo)  || equals(dtHr, dthrIniPeriodo)) && 
			 (before(dtHr, dtHrFimPeriodo) || equals(dtHr, dtHrFimPeriodo))) {
			return true;
		} else {
			return false;
		}
	}

	public static Date getMenorData(Date... dts) {
		return getMenorOuMaiorData(true, dts);
	}

	public static Date getMaiorData(Date... dts) {
		return getMenorOuMaiorData(false, dts);
	}

	private static Date getMenorOuMaiorData(boolean isMenor, Date... dts) {
		Date targetDate = null;
		for (Date date : dts) {
			if (targetDate == null) {
				targetDate = date;
			} else {
				if (date != null) {
					if(isMenor) {
						if (before(date, targetDate)) {
							targetDate = date;
						}
					} else {
						if (after(date, targetDate)) {
							targetDate = date;
						}
					}
				}
			}
		}
		return targetDate;
	}



	public static String formatSegundosParaHHMMSSSemMilisegundos(Double tempoEmSegundos) {
        String retorno = DataHoraRN.ZERADO_HHMMSS;

	   if (tempoEmSegundos == null) {
	       return retorno;
	   }

	   int horas;
	   int minutos;
	   int tempInteiro;

	   float tempResto;

	   tempInteiro =  Math.abs(tempoEmSegundos.intValue());

	   horas = tempInteiro / 3600;
	   tempResto = tempInteiro % 3600;
	   tempInteiro = (int) (tempResto / 60f);
	   minutos = tempInteiro;
	   tempResto = tempResto % 60f;

	   int hora = horas;
	   int minuto = minutos;

	   String seg = String.valueOf(tempResto);

	   seg = seg.substring(0, seg.indexOf("."));
	   int segundo = Integer.parseInt(seg);

	   retorno = (hora < 10 ? "0" + hora : hora) + ":" + (minuto < 10 ? "0" + minuto : minuto) + ":" + (segundo < 10 ? "0" + segundo : segundo);

	   if (tempoEmSegundos < 0) {
	       retorno = "-" + retorno;
	   }
	   return retorno;
	}

    public static String formatSegundosParaHHMMSSmmm(Double tempoEmSegundos) {
        String retorno = DataHoraRN.ZERADO_HHMMSS;

        if (tempoEmSegundos == null) {
            return retorno;
        }

        int horas;
        int minutos;
        int mili;
        int tempInteiro;

        float tempResto;

        tempInteiro =  Math.abs(tempoEmSegundos.intValue());
        mili = (int) ((tempoEmSegundos % 1) * 1000);

        horas = tempInteiro / 3600;
        tempResto = tempInteiro % 3600;
        tempInteiro = (int) (tempResto / 60f);
        minutos = tempInteiro;
        tempResto = tempResto % 60f;

        int hora = horas;
        int minuto = minutos;

        String seg = String.valueOf(tempResto);

        seg = seg.substring(0, seg.indexOf("."));
        int segundo = Integer.parseInt(seg);

        retorno = (hora < 10 ? "0" + hora : hora) + ":" + (minuto < 10 ? "0" + minuto : minuto) + ":" + (segundo < 10 ? "0" + segundo : segundo);
        if (mili > 0) {
            retorno += "." + mili;
        }
        if (tempoEmSegundos < 0) {
            retorno = "-" + retorno;
        }
        return retorno;
    }

	public static String getSegundosFormatadosEmDiasHoras(BigDecimal p_segundos){
		String retorno;
		String formato = "%hh:%mi:%ss";
		double Periodo;
		double Calculo;
		double Resto;
		int Temp;
		int horas=0;

		if (p_segundos != null)
			Periodo = p_segundos.doubleValue();
		else
			Periodo = 0d;

		if (Periodo < 0){
			Periodo *= -1;
			formato = "-" + formato;
		}

		Calculo = Periodo / 86400;
		Temp = (int) Calculo;

		Resto = Periodo - (Temp * 86400);

		Calculo = Resto;

		if (formato.indexOf("%dd")!=-1)
			retorno = formato.replaceAll("%dd", String.valueOf(Temp));
		else{
			retorno = formato;
			horas = Temp * 24;
		}
		Calculo/=3600;
		Temp = (int) Calculo;
		Resto = Resto - (Temp * 3600);
		Calculo = Resto;
		if (formato.indexOf("%dd")==-1)
			Temp += horas;

		if (Temp <= 9){
			retorno = retorno.replaceAll("%hh", StringUtils.leftPad(String.valueOf(Temp),2,"0"));
		}else {
			retorno = retorno.replaceAll("%hh", String.valueOf(Temp));
		}

		Calculo/=60;
		Temp = (int) Calculo;
		Resto = Resto - (Temp * 60);
		Calculo = Resto;
		retorno = retorno.replaceAll("%mi", StringUtils.leftPad(String.valueOf(Temp),2,"0"));

		Temp = (int) Calculo;
		retorno = retorno.replaceAll("%ss", StringUtils.leftPad(String.valueOf(Temp),2,"0"));

		return retorno;
	}
	public static int getHourAsInt(Date pTime) {
        String dt = "";
        SimpleDateFormat formater = new SimpleDateFormat("HH");
        dt = formater.format(pTime);

        return new Integer(dt);
    }
	public static Date regressMinutes(Date pDataReferencia, int minutes) {
		Calendar calendario = Calendar.getInstance();

		calendario.setTime(pDataReferencia);
		calendario.add(Calendar.MINUTE, -1 * minutes);

		return new Date(calendario.getTime().getTime());
	}
	public static Date getInicioMes(Date dtreferencia){
		GregorianCalendar calendario = new GregorianCalendar();

		calendario.setTime(dtreferencia);

		calendario.set(calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH), 1, 0, 0, 0);

		return calendario.getTime();
	}

	public static Date getInicioMes(int ano, int mes){
		GregorianCalendar calendario = new GregorianCalendar();

		calendario.set(Calendar.YEAR, ano);
		calendario.set(Calendar.MONTH, mes-1);
		calendario.set(Calendar.DAY_OF_MONTH, 1);

		calendario.set(calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH), 1, 0, 0, 0);

		return calendario.getTime();
	}

	public static Date getFimMes(Date dtreferencia){
		GregorianCalendar calendario = new GregorianCalendar();

		calendario.setTime(dtreferencia);

		// Soma um mes a data de referencia
		calendario.add(Calendar.MONTH, 1);

		// Obtem 1o dia do mes de referencia apos a soma de um mes
		Date dtTemp = getInicioMes(calendario.getTime());

		// Decresce um dia a data encontrada
		calendario.setTime(dtTemp);
		calendario.add(Calendar.DAY_OF_MONTH, -1);

		return calendario.getTime();
	}
	public static Date getFimMes(int ano, int mes){
		GregorianCalendar calendario = new GregorianCalendar();

		calendario.set(Calendar.YEAR, ano);
		calendario.set(Calendar.MONTH, mes-1);
		calendario.set(Calendar.DAY_OF_MONTH, 1);

		// Soma um mes a data de referencia
		calendario.add(Calendar.MONTH, 1);

		// Obtem 1o dia do mes de referencia apos a soma de um mes
		Date dtTemp = getInicioMes(calendario.getTime());

		// Decresce um dia a data encontrada
		calendario.setTime(dtTemp);
		calendario.add(Calendar.DAY_OF_MONTH, -1);

		return calendario.getTime();
	}
	public static Date regressOneSecond(Date pDataReferencia) {
		Calendar calendario = Calendar.getInstance();

		calendario.setTime(pDataReferencia);
		calendario.add(Calendar.SECOND, -1);

		return new Date(calendario.getTime().getTime());
	}
	public static int amountOfSecondsInPeriod(Date pHoraInicial, Date pHoraFinal){
		if (pHoraFinal == null || pHoraInicial == null)
			return 0;

		int qtSegundos;

		qtSegundos = (int) ((pHoraFinal.getTime() - pHoraInicial.getTime()) / 1000);

		return qtSegundos;
	}
	public static int amountOfDaysInPeriod(Date pDataInicial, Date pDataFinal){
		int qtDias;

		qtDias = (int) ((pDataFinal.getTime() - pDataInicial.getTime()) / (1000 * 60 * 60 * 24));

		return qtDias;
	}
	public static int getDia(Date dtreferencia){
		GregorianCalendar calendario = new GregorianCalendar();

		calendario.setTime(dtreferencia);

		return calendario.get(Calendar.DAY_OF_MONTH);
	}
	public static int getMes(Date dtreferencia){
		GregorianCalendar calendario = new GregorianCalendar();

		calendario.setTime(dtreferencia);

		return calendario.get(Calendar.MONTH) + 1;
	}
	public static int getAno(Date dtreferencia){
		GregorianCalendar calendario = new GregorianCalendar();

		calendario.setTime(dtreferencia);

		return calendario.get(Calendar.YEAR);
	}
	public static Date getInicioAno(Date dtreferencia){
		GregorianCalendar calendario = new GregorianCalendar();

		calendario.setTime(dtreferencia);

		calendario.set(calendario.get(Calendar.YEAR), 0, 1, 0, 0, 0);

		return calendario.getTime();
	}
	public static Date getFimAno(Date dtreferencia){
		GregorianCalendar calendario = new GregorianCalendar();

		calendario.setTime(dtreferencia);

		calendario.set(Calendar.MONTH, 11);
		calendario.set(Calendar.DAY_OF_MONTH, 31);

		return calendario.getTime();
	}
	// compara datas baseado apenas no dia, m�s e ano, sem considerar horas, minutos, segundos ou milisegundos.
	public static int compareDateAsDayOnly (Date baseDate, Date compareDate) {

		Date normalizedBaseDate = normalize(baseDate, _DAY);
		Date normalizedcompareDate = normalize(compareDate, _DAY);

		return compareTo(normalizedBaseDate, normalizedcompareDate);
	}
	public static Double getNumDiasFrom1900(Date dtConv) {
		// pegando data de 1900
		Calendar cal1900 = Calendar.getInstance();
		cal1900.set(1900, 01, 01);
		Date dt1900 = cal1900.getTime();

		// numero de milisegundos em 1 dia
		Double oneDay = 1000d * 60d * 60d * 24d;

		// convertendo datas em milisegundos
		long dtConvMili = dtConv.getTime();
		long dt1900Mili = dt1900.getTime();

		// Calculate the difference in milliseconds
		long differenceMiliSecs = Math.abs(new Long(dtConvMili - dt1900Mili));

		Double qtdDias = (new Double(differenceMiliSecs))/oneDay;

		// Convert back to days and return
		return(new Long(Math.round(qtdDias)).doubleValue());
	}

	public static double getSegundosParaMinutos(int tempoEmSegundos){
		return (tempoEmSegundos) / 60d;
	}

	public static String getSegundosParaHoraFormata(Integer tempoEmSegundos){
		String retorno = "";
		int horas = 0;
		int minutos = 0;
		int segundos = 0;
		int tempInteiro = 0;
		float tempResto = 0f;

		tempInteiro = tempoEmSegundos;
		horas = tempInteiro / 3600;;
		tempResto = tempInteiro % 3600;
		tempInteiro = (int) (tempResto / 60f);
		minutos = tempInteiro;
		tempResto = tempResto % 60f;
		segundos = (int) tempResto;

		int hora = horas;
		int minuto = minutos;
		int segundo = segundos;

		retorno = (hora < 10 ? "0" + hora : hora) + ":" + (minuto < 10 ? "0" + minuto : minuto) + ":" + (segundo < 10 ? "0" + segundo : segundo);

		return retorno;

//		long data = tempoEmSegundos * 1000;
//
//		Date data2 = new Date(data);
//
//
//		return getTimeHHMMSSASString(data2);
	}
	public static Date getDataInicioInjetNaSulbras(){
		// Data de inicio fixa para a Sulbras. Ver como obter para qualquer empresa
		Date retorno = new Date();
		try {
			retorno = toDateFromYYYYMMDDHHMISS("2008-08-14 00:00:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}

	public static List<Date> getDatasNoPeriodo(Date dataInicio, Date dataFim){
		List<Date> listaDatas = new ArrayList<Date>();
		try {
			Calendar calendarioInicio = Calendar.getInstance();
			calendarioInicio.setTime(dataInicio);
			Calendar calendarioFim = Calendar.getInstance();
			calendarioFim.setTime(dataFim);
			for(Calendar cal = (Calendar) calendarioInicio.clone(); cal.compareTo (calendarioFim) <= 0; cal.add (Calendar.DATE, +1)){
				if(!cal.equals(calendarioInicio) && !cal.equals(calendarioFim)){
					listaDatas.add(cal.getTime());
				}
			}
			if (listaDatas.isEmpty()) {
				listaDatas.add(dataInicio);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaDatas;
	}

	public static Calendar toCalendar(Date date){
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  cal.setTimeZone(null);
		  return cal;
	}

	public static String getNomeResumidoMes(int mes)
	{
		String nomeMes = "";
		switch (mes)
		{
			case 1:
				nomeMes = "Jan";
				break;

			case 2:
				nomeMes = "Fev";
				break;

			case 3:
				nomeMes = "Mar";
				break;

			case 4:
				nomeMes = "Abr";
				break;

			case 5:
				nomeMes = "Mai";
				break;

			case 6:
				nomeMes = "Jun";
				break;

			case 7:
				nomeMes = "Jul";
				break;

			case 8:
				nomeMes = "Ago";
				break;

			case 9:
				nomeMes = "Set";
				break;

			case 10:
				nomeMes = "Out";
				break;

			case 11:
				nomeMes = "Nov";
				break;

			case 12:
				nomeMes = "Dez";
				break;
		}

		return nomeMes;
	}

	public static int getDiaSemana(Date dt) {
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek;
	}

    public static XMLGregorianCalendar converteDateParaXMLCalendar(Date data) {
        if (data == null) {
            return null;
        }

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(data);
        XMLGregorianCalendar xmlCalendar = new XMLGregorianCalendarImpl(calendar);
        return xmlCalendar;
    }


    public static BigDecimal getMilissegundoFromBigDecimal(BigDecimal b){

    	b = b.setScale(3, BigDecimal.ROUND_HALF_DOWN);
    	int inteiro = b.intValue();
    	if(inteiro == 0)
    		inteiro = 1;
    	BigDecimal remainder = b.remainder(new BigDecimal(inteiro));
    	remainder = remainder.multiply( new BigDecimal( Math.pow(10, (remainder.toString().length() - 2))));
    	BigDecimal milissegundos = new BigDecimal(inteiro * 1000);

    	milissegundos =  milissegundos.add(remainder);

    	return milissegundos;
    }
    public static String dateToStringYY(Date pDateTime) {
        return dateToString(pDateTime, "yy");
    }
    public static int getWeekYear(Date pDate) {
        Calendar calendario = Calendar.getInstance();

        // Cria calend�rio
        calendario.setTime(pDate);

        // Retorna verdadeiro se o dia for s�bado ou domingo
        return calendario.get(Calendar.WEEK_OF_YEAR);

    }
    

	public static boolean equal(Date d1, Date d2){
		return DataHoraRN.compareTo(d1, d2) == 0;
	}

	public static boolean maiorOUigual(Date d1, Date d2) {
		return (DataHoraRN.equal(d1, d2) || DataHoraRN.after(d1, d2));	
	}

	public static boolean menorOUigual(Date d1, Date d2) {
		return (DataHoraRN.equal(d1, d2) || DataHoraRN.before(d1, d2));
	}

    public static boolean existeIntersecaoDatas(Date dthrIniPeriodo, Date dthrFimPeriodo, Date dthrIniOcor, Date dthrFimOcor) {
    	boolean retorno = false;
    	
    	
    	if ( (DataHoraRN.maiorOUigual(dthrIniOcor, dthrIniPeriodo) && DataHoraRN.menorOUigual(dthrIniOcor, dthrFimPeriodo)) ||
    		 (DataHoraRN.maiorOUigual(dthrFimOcor, dthrIniPeriodo) && DataHoraRN.menorOUigual(dthrFimOcor, dthrFimPeriodo)) ||
    		 (DataHoraRN.maiorOUigual(dthrIniPeriodo, dthrIniOcor) && DataHoraRN.menorOUigual(dthrIniPeriodo, dthrFimOcor))) {
    		 
    		retorno = true;
    	}
    	
    	return retorno;
    }

	public static Date stringToDate(String dthr){
    	Date dataHora;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(dthr));    		
		dataHora = calendar.getTime();
		return dataHora;

	}
}
