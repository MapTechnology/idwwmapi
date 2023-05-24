package idw.model.rn.injet;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.type.IntegerType;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.injet.Ijhortur;
import idw.model.pojos.injet.Ijreapar;
import idw.model.pojos.injet.Ijtbfresh;
import idw.model.pojos.injet.Ijtbtur;
import idw.model.pojos.injet.template.IjtbfreshTemplate;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.PeriodoDTO;
import idw.webservices.rest.dto.TurnoDTO;
import ms.coleta.dto.IntervaloTempoInjetDTO;


public class FuncoesApoioInjet {
	
	public static final String CODIGO_DEFAULT_6_DIGITOS = "999999";
	
	/**
	 * Pega o tipo da empresa, baseado no ID que est� no campo campo01
	 * @param daoInjet
	 * @return
	 */
	public static IjtbfreshTemplate.EmpresaType getEmpresa(DAOGenericoInjet daoInjet){
		MapQuery q = new MapQuery(daoInjet.getSession());
		
		q.append("SELECT ijtbfresh from Ijtbfresh ijtbfresh");
		q.setMaxResults(1);
		Ijtbfresh ijtbfresh = (Ijtbfresh) q.uniqueResult();
		
		String idEmpresa = SenhaRN.descriptografarSenha(ijtbfresh.getPk().getCampo01());
		
		return IjtbfreshTemplate.EmpresaType.get(idEmpresa);
		
	}
	
	public static Date calcularInicioTurno(DAOGenericoInjet daoInjet, Date dataReferencia, String cdTurno) throws SemCalendarioException{

		Date retorno = null;
		Date dthr;
		String v_Dia;
		String v_cdturno;
		Integer status = 0;

		dthr = dataReferencia;
		v_cdturno = cdTurno;
		v_Dia = String.valueOf(DataHoraRN.getWeekDay(dthr));

		TurnoInjetRN calendarioRN = new TurnoInjetRN(daoInjet);

		Ijhortur ijhortur = calendarioRN.pesquisarIjhorturNaData(dataReferencia, v_cdturno, "00000" + v_Dia);

		/* Se ijhortur for null significa que o turno em quest�o n�o trabalha no dia da semana analisado.
		 * Assim, deve-se gerar uma excess�o especifica
		 */
		if (ijhortur.getIjhorage() == null){
			throw new SemCalendarioException();
		}

		try{
			status = FuncoesApoioInjet.qualStatusDoDia(
					v_Dia, 
					ijhortur.getIjhorage().getSitiniciofimdom(), 
					ijhortur.getIjhorage().getSitiniciofimseg(),
					ijhortur.getIjhorage().getSitiniciofimter(),
					ijhortur.getIjhorage().getSitiniciofimqua(),
					ijhortur.getIjhorage().getSitiniciofimqui(),
					ijhortur.getIjhorage().getSitiniciofimsex(),
					ijhortur.getIjhorage().getSitiniciofimsab());
		} catch (Exception e){
			throw new SemCalendarioException();
		}

//		Date strHrIniDia = null;
		Date strHrFimDia = null;

		if (v_Dia.equals("1")){
//			numSitIniFimDia = rdoIJhorAGE("SitInicioFimDom")
//			strHrIniDia = ijhortur.getIjhorage().getHridom();
			strHrFimDia = ijhortur.getIjhorage().getHrfdom();
		}
		if (v_Dia.equals("2")){
//			numSitIniFimDia = rdoIJhorAGE("SitInicioFimSeg")
//			strHrIniDia = ijhortur.getIjhorage().getHriseg();
			strHrFimDia = ijhortur.getIjhorage().getHrfseg();
		}
		if (v_Dia.equals("3")){
//			numSitIniFimDia = rdoIJhorAGE("SitInicioFimTer")
//			strHrIniDia = ijhortur.getIjhorage().getHriter();
			strHrFimDia = ijhortur.getIjhorage().getHrfter();
		}
		if (v_Dia.equals("4")){
//			numSitIniFimDia = rdoIJhorAGE("SitInicioFimQua")
//			strHrIniDia = ijhortur.getIjhorage().getHriqua();
			strHrFimDia = ijhortur.getIjhorage().getHrfqua();
		}
		if (v_Dia.equals("5")){
//			numSitIniFimDia = rdoIJhorAGE("SitInicioFimQui")
//			strHrIniDia = ijhortur.getIjhorage().getHriqui();
			strHrFimDia = ijhortur.getIjhorage().getHrfqui();
		}
		if (v_Dia.equals("6")){
//			numSitIniFimDia = rdoIJhorAGE("SitInicioFimSex")
//			strHrIniDia = ijhortur.getIjhorage().getHrisex();
			strHrFimDia = ijhortur.getIjhorage().getHrfsex();
		}
		if (v_Dia.equals("7")){
//			numSitIniFimDia = rdoIJhorAGE("SitInicioFimSab")
//			strHrIniDia = ijhortur.getIjhorage().getHrisab();
			strHrFimDia = ijhortur.getIjhorage().getHrfsab();
		}

		Date strDtIniPeriodoAux = dataReferencia;

//		strHrIni = Format(rdoIJhorTUR("HrITurno"), "hh:mm:ss")
		Date strHrIni = ijhortur.getHriturno();

//		strHrFim = Format(rdoIJhorTUR("HrFTurno"), "hh:mm:ss")
		Date strHrFim = ijhortur.getHrfturno();

//		numHrIniTur = TimeToSeconds(strHrIni)
		int numHrIniTur = DataHoraRN.getTimeInSeconds(strHrIni);

//		numHrFimTur = TimeToSeconds(strHrFim)
		int numHrFimTur = DataHoraRN.getTimeInSeconds(strHrFim);

//		numHrIniDia = TimeToSeconds(strHrIniDia)
//		int numHrIniDia = DataHoraRN.getTimeInSeconds(strHrIniDia);

//		numHrFimDia = TimeToSeconds(strHrFimDia)
		int numHrFimDia = DataHoraRN.getTimeInSeconds(strHrFimDia);


		if (status == 0){
			retorno = DataHoraRN.concatenaPrimeiroDataSegundoHora(strDtIniPeriodoAux, strHrIni);
//			retorno = Format(strDtIniPeriodoAux, "yyyy-mm-dd") & " " & strHrIni;
//			clsPeriodo.DtHrFimReferencia = Format(strDtIniPeriodoAux, "yyyy-mm-dd") & " " & strHrFim
		}
		if (status == 1){
			if (numHrIniTur < numHrFimTur) {
				// Verifica se o fim do turno � menor ou igual ao fim do dia. _
				// Se for igual significa que a data de referencia _
				// � igual a data da ocorrencia.
				if (numHrFimTur <= numHrFimDia) {
					retorno = DataHoraRN.concatenaPrimeiroDataSegundoHora(strDtIniPeriodoAux, strHrIni);

//					clsPeriodo.DtHrIniReferencia = Format(strDtIniPeriodoAux, "yyyy-mm-dd") & " " & strHrIni
//					clsPeriodo.DtHrFimReferencia = Format(strDtIniPeriodoAux, "yyyy-mm-dd") & " " & strHrFim
				} else {
					// As datas s�o do dia anterior
					retorno = DataHoraRN.concatenaPrimeiroDataSegundoHora(DataHoraRN.regressDate(strDtIniPeriodoAux, 1), strHrIni);
//					clsPeriodo.DtHrIniReferencia = Format(SomaData(strDtIniPeriodoAux, -1), "yyyy-mm-dd") & " " & strHrIni
//					clsPeriodo.DtHrFimReferencia = Format(SomaData(strDtIniPeriodoAux, -1), "yyyy-mm-dd") & " " & strHrFim
				}
			} else {
				// A data de in�cio � o dia anterior
				retorno = DataHoraRN.concatenaPrimeiroDataSegundoHora(DataHoraRN.regressDate(strDtIniPeriodoAux, 1), strHrIni);
//				clsPeriodo.DtHrIniReferencia = Format(SomaData(strDtIniPeriodoAux, -1), "yyyy-mm-dd") & " " & strHrIni
//				clsPeriodo.DtHrFimReferencia = Format(strDtIniPeriodoAux, "yyyy-mm-dd") & " " & strHrFim
			}
		}
		if (status == 2){
			if (numHrIniTur < numHrFimTur) {
				//Os hor�rios podem ser tanto do dia seguinte como da data _
				// de referencia.
				if (numHrFimTur > numHrFimDia) {
					//Data de referencia
					retorno = DataHoraRN.concatenaPrimeiroDataSegundoHora(strDtIniPeriodoAux, strHrIni);

//					clsPeriodo.DtHrIniReferencia = Format(strDtIniPeriodoAux, "yyyy-mm-dd") & " " & strHrIni
//					clsPeriodo.DtHrFimReferencia = Format(strDtIniPeriodoAux, "yyyy-mm-dd") & " " & strHrFim
				} else {
					// Dia seguinte
					retorno = DataHoraRN.concatenaPrimeiroDataSegundoHora(DataHoraRN.advanceDate(strDtIniPeriodoAux, 1), strHrIni);
//					clsPeriodo.DtHrIniReferencia = Format(SomaData(strDtIniPeriodoAux, 1), "yyyy-mm-dd") & " " & strHrIni
//					clsPeriodo.DtHrFimReferencia = Format(SomaData(strDtIniPeriodoAux, 1), "yyyy-mm-dd") & " " & strHrFim
				}
			} else {
				//  A data final � do dia seguinte
				retorno = DataHoraRN.concatenaPrimeiroDataSegundoHora(strDtIniPeriodoAux, strHrIni);
//				clsPeriodo.DtHrIniReferencia = Format(strDtIniPeriodoAux, "yyyy-mm-dd") & " " & strHrIni
//				clsPeriodo.DtHrFimReferencia = Format(SomaData(strDtIniPeriodoAux, 1), "yyyy-mm-dd") & " " & strHrFim
			}
		}

		// Ajuda ao garbage collector
		calendarioRN = null;
		ijhortur = null;
		v_cdturno = null;
		v_Dia = null;
//		v_dthriturno = null;
//		v_hriturno = null;
		dthr = null;

		return retorno;
	}

	public static Date calcularFimTurno(DAOGenericoInjet daoInjet, Date dataReferencia, String cdTurno) throws SemCalendarioException{

		Date retorno = null;
		Date dthr;
		String v_Dia;
		String v_cdturno;
		Integer status = 0;

		dthr = dataReferencia;
		v_cdturno = cdTurno;
		v_Dia = String.valueOf(DataHoraRN.getWeekDay(dthr));

		TurnoInjetRN calendarioRN = new TurnoInjetRN(daoInjet);

		Ijhortur ijhortur = calendarioRN.pesquisarIjhorturNaData(dataReferencia, v_cdturno, "00000" + v_Dia);

		/* Se ijhortur for null significa que o turno em quest�o n�o trabalha no dia da semana analisado.
		 * Assim, deve-se gerar uma excess�o especifica
		 */
		if (ijhortur.getIjhorage() == null){
			throw new SemCalendarioException();
		}

		try{
			status = FuncoesApoioInjet.qualStatusDoDia(
					v_Dia, 
					ijhortur.getIjhorage().getSitiniciofimdom(), 
					ijhortur.getIjhorage().getSitiniciofimseg(),
					ijhortur.getIjhorage().getSitiniciofimter(),
					ijhortur.getIjhorage().getSitiniciofimqua(),
					ijhortur.getIjhorage().getSitiniciofimqui(),
					ijhortur.getIjhorage().getSitiniciofimsex(),
					ijhortur.getIjhorage().getSitiniciofimsab());
		} catch (Exception e){
			throw new SemCalendarioException();
		}

//		Date strHrIniDia = null;
		Date strHrFimDia = null;

		if (v_Dia.equals("1")){
//			numSitIniFimDia = rdoIJhorAGE("SitInicioFimDom")
//			strHrIniDia = ijhortur.getIjhorage().getHridom();
			strHrFimDia = ijhortur.getIjhorage().getHrfdom();
		}
		if (v_Dia.equals("2")){
//			numSitIniFimDia = rdoIJhorAGE("SitInicioFimSeg")
//			strHrIniDia = ijhortur.getIjhorage().getHriseg();
			strHrFimDia = ijhortur.getIjhorage().getHrfseg();
		}
		if (v_Dia.equals("3")){
//			numSitIniFimDia = rdoIJhorAGE("SitInicioFimTer")
//			strHrIniDia = ijhortur.getIjhorage().getHriter();
			strHrFimDia = ijhortur.getIjhorage().getHrfter();
		}
		if (v_Dia.equals("4")){
//			numSitIniFimDia = rdoIJhorAGE("SitInicioFimQua")
//			strHrIniDia = ijhortur.getIjhorage().getHriqua();
			strHrFimDia = ijhortur.getIjhorage().getHrfqua();
		}
		if (v_Dia.equals("5")){
//			numSitIniFimDia = rdoIJhorAGE("SitInicioFimQui")
//			strHrIniDia = ijhortur.getIjhorage().getHriqui();
			strHrFimDia = ijhortur.getIjhorage().getHrfqui();
		}
		if (v_Dia.equals("6")){
//			numSitIniFimDia = rdoIJhorAGE("SitInicioFimSex")
//			strHrIniDia = ijhortur.getIjhorage().getHrisex();
			strHrFimDia = ijhortur.getIjhorage().getHrfsex();
		}
		if (v_Dia.equals("7")){
//			numSitIniFimDia = rdoIJhorAGE("SitInicioFimSab")
//			strHrIniDia = ijhortur.getIjhorage().getHrisab();
			strHrFimDia = ijhortur.getIjhorage().getHrfsab();
		}

		Date strDtIniPeriodoAux = dataReferencia;

//		strHrIni = Format(rdoIJhorTUR("HrITurno"), "hh:mm:ss")
		Date strHrIni = ijhortur.getHriturno();

//		strHrFim = Format(rdoIJhorTUR("HrFTurno"), "hh:mm:ss")
		Date strHrFim = ijhortur.getHrfturno();

//		numHrIniTur = TimeToSeconds(strHrIni)
		int numHrIniTur = DataHoraRN.getTimeInSeconds(strHrIni);

//		numHrFimTur = TimeToSeconds(strHrFim)
		int numHrFimTur = DataHoraRN.getTimeInSeconds(strHrFim);

//		numHrIniDia = TimeToSeconds(strHrIniDia)
//		int numHrIniDia = DataHoraRN.getTimeInSeconds(strHrIniDia);

//		numHrFimDia = TimeToSeconds(strHrFimDia)
		int numHrFimDia = DataHoraRN.getTimeInSeconds(strHrFimDia);


		if (status == 0){
			retorno = DataHoraRN.concatenaPrimeiroDataSegundoHora(strDtIniPeriodoAux, strHrFim);
//			retorno = Format(strDtIniPeriodoAux, "yyyy-mm-dd") & " " & strHrIni;
//			clsPeriodo.DtHrFimReferencia = Format(strDtIniPeriodoAux, "yyyy-mm-dd") & " " & strHrFim
		}
		if (status == 1){
			if (numHrIniTur < numHrFimTur) {
				// Verifica se o fim do turno � menor ou igual ao fim do dia. _
				// Se for igual significa que a data de referencia _
				// � igual a data da ocorrencia.
				if (numHrFimTur <= numHrFimDia) {
					retorno = DataHoraRN.concatenaPrimeiroDataSegundoHora(strDtIniPeriodoAux, strHrFim);

//					clsPeriodo.DtHrIniReferencia = Format(strDtIniPeriodoAux, "yyyy-mm-dd") & " " & strHrIni
//					clsPeriodo.DtHrFimReferencia = Format(strDtIniPeriodoAux, "yyyy-mm-dd") & " " & strHrFim
				} else {
					// As datas s�o do dia anterior
					retorno = DataHoraRN.concatenaPrimeiroDataSegundoHora(DataHoraRN.regressDate(strDtIniPeriodoAux, 1), strHrFim);
//					clsPeriodo.DtHrIniReferencia = Format(SomaData(strDtIniPeriodoAux, -1), "yyyy-mm-dd") & " " & strHrIni
//					clsPeriodo.DtHrFimReferencia = Format(SomaData(strDtIniPeriodoAux, -1), "yyyy-mm-dd") & " " & strHrFim
				}
			} else {
				// A data de in�cio � o dia anterior
				retorno = DataHoraRN.concatenaPrimeiroDataSegundoHora(strDtIniPeriodoAux, strHrFim);
//				clsPeriodo.DtHrIniReferencia = Format(SomaData(strDtIniPeriodoAux, -1), "yyyy-mm-dd") & " " & strHrIni
//				clsPeriodo.DtHrFimReferencia = Format(strDtIniPeriodoAux, "yyyy-mm-dd") & " " & strHrFim
			}
		}
		if (status == 2){
			if (numHrIniTur < numHrFimTur) {
				//Os hor�rios podem ser tanto do dia seguinte como da data _
				// de referencia.
				if (numHrFimTur > numHrFimDia) {
					//Data de referencia
					retorno = DataHoraRN.concatenaPrimeiroDataSegundoHora(strDtIniPeriodoAux, strHrFim);

//					clsPeriodo.DtHrIniReferencia = Format(strDtIniPeriodoAux, "yyyy-mm-dd") & " " & strHrIni
//					clsPeriodo.DtHrFimReferencia = Format(strDtIniPeriodoAux, "yyyy-mm-dd") & " " & strHrFim
				} else {
					// Dia seguinte
					retorno = DataHoraRN.concatenaPrimeiroDataSegundoHora(DataHoraRN.advanceDate(strDtIniPeriodoAux, 1), strHrFim);
//					clsPeriodo.DtHrIniReferencia = Format(SomaData(strDtIniPeriodoAux, 1), "yyyy-mm-dd") & " " & strHrIni
//					clsPeriodo.DtHrFimReferencia = Format(SomaData(strDtIniPeriodoAux, 1), "yyyy-mm-dd") & " " & strHrFim
				}
			} else {
				//  A data final � do dia seguinte
				retorno = DataHoraRN.concatenaPrimeiroDataSegundoHora(DataHoraRN.advanceDate(strDtIniPeriodoAux, 1), strHrFim);
//				clsPeriodo.DtHrIniReferencia = Format(strDtIniPeriodoAux, "yyyy-mm-dd") & " " & strHrIni
//				clsPeriodo.DtHrFimReferencia = Format(SomaData(strDtIniPeriodoAux, 1), "yyyy-mm-dd") & " " & strHrFim
			}
		}

		// Ajuda ao garbage collector
		calendarioRN = null;
		ijhortur = null;
		v_cdturno = null;
		v_Dia = null;
//		v_dthriturno = null;
//		v_hriturno = null;
		dthr = null;

		return retorno;
	}

	public static String encontrarTurnoFinalNoDia(DAOGenericoInjet daoInjet, Date data) throws SemCalendarioException{
		String retorno = "";
		String v_Dia = String.valueOf(DataHoraRN.getWeekDay(data));

		TurnoInjetRN calendarioRN = new TurnoInjetRN(daoInjet);

		List<Ijhortur> listaIjhortur = calendarioRN.pesquisarListaIjhortur(data, "00000" + v_Dia);

		// O ultimo elemento da lista � o turno que comeca mais tarde no dia
		if (listaIjhortur.size() <= 0)
			throw new SemCalendarioException();

		retorno = listaIjhortur.get(listaIjhortur.size()-1).getIjtbtur().getCdturno();

		return retorno;
	}

	public static BigDecimal converteKgParaTn(BigDecimal quilo){
		BigDecimal retorno = quilo;

		retorno = retorno.divide(new BigDecimal(1000));

		return retorno;
	}

	public static Integer qualStatusDoDia(String diaSemana, Integer sitiniciofimdom, Integer sitiniciofimseg, Integer sitiniciofimter, Integer sitiniciofimqua, Integer sitiniciofimqui, Integer sitiniciofimsex, Integer sitiniciofimsab){
		Integer retorno = 0;
		Integer dia = Integer.valueOf(diaSemana);

		if (dia == 1)
			retorno = sitiniciofimdom;
		if (dia == 2)
			retorno = sitiniciofimseg;
		if (dia == 3)
			retorno = sitiniciofimter;
		if (dia == 4)
			retorno = sitiniciofimqua;
		if (dia == 5)
			retorno = sitiniciofimqui;
		if (dia == 6)
			retorno = sitiniciofimsex;
		if (dia == 7)
			retorno = sitiniciofimsab;

		return retorno;

	}


	public static boolean isParadaComPeso(Ijreapar ijreapar){
		boolean retorno = false;

		if (ijreapar.getTempoparada() == null)
			if (ijreapar.getIjtbpar().getSaidademolde().equals(BigDecimal.ZERO) == false)
				retorno = true;

		if (ijreapar.getTempoparada() != null)
			if (ijreapar.getTempoparada().equals(BigDecimal.ZERO) == false)
				retorno = true;

		return retorno;

	}

	public static int getEmSegundosIntersecaoHorarios(Date dthrIPrincipal, Date dthrFPrincipal, Date dthrISecundaria, Date dthrFSecundaria){
		Date inicioAConsiderar = null;
		Date fimAConsiderar = null;

		if (DataHoraRN.after(dthrISecundaria, dthrIPrincipal))
			inicioAConsiderar = dthrISecundaria;
		else
			inicioAConsiderar = dthrIPrincipal;

		if (DataHoraRN.before(dthrFSecundaria, dthrFPrincipal))
			fimAConsiderar = dthrFSecundaria;
		else
			fimAConsiderar = dthrFPrincipal;
		
		int segundos = 0;
		// Se nao houver interseccao entre as datas deve-se retornar 0
		if (DataHoraRN.before(dthrFPrincipal, dthrISecundaria) || DataHoraRN.after(dthrIPrincipal, dthrFSecundaria))
			segundos = 0;
		else
			segundos = DataHoraRN.getQuantidadeSegundosNoPeriodo(inicioAConsiderar, fimAConsiderar);

		if (segundos < 0)
			segundos = 0;
		
		return segundos;
	}
	
	
	public static String getCodigoPadraoInjet(String cd) {
		return StringUtils.repeat('0', 6 - cd.length()) + cd;
	}

	public static void main(String[] args){
		DAOGenericoInjet dao = new DAOGenericoInjet();
		dao.iniciaConexaoBanco();

		TurnoInjetDTO turno = null;
			try {
				turno = FuncoesApoioInjet.encontraTurno(dao, DataHoraRN.toDateFromYYYYMMDDHHMISS("2013-06-05 10:26:38"));
				//System.out.println(" agora " + turno.getIjtbtur().getCdturno());
				
			} catch (SemCalendarioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		/*
		 * 2013-05-20 15:41:36 - turno 000002 agora 000001
2013-05-20 15:37:56 - turno 000002 agora 000001
2013-05-20 15:37:44 - turno 000002 agora 000001
2013-05-20 15:36:25 - turno 000002 agora 000001
2013-05-20 15:36:08 - turno 000002 agora 000001
2013-05-20 15:35:16 - turno 000002 agora 000001
2013-05-20 15:34:59 - turno 000002 agora 000001
2013-05-20 15:33:28 - turno 000002 agora 000001
2013-05-20 15:33:00 - turno 000002 agora 000001

		MapQuery q = new MapQuery(dao.getSession());
		
		q.append("from Ijregistrobarcode order by dthrleitura desc");
		
		List<Ijregistrobarcode> l = q.list();
		

		for (Ijregistrobarcode b : l) {
			TurnoInjetDTO turno = null;
			try {
				turno = FuncoesApoioInjet.encontraTurno(dao, b.getDthrleitura());
				if (b.getCdturno().equals(turno.getIjtbtur().getCdturno()) == false)
					//System.out.println(DataHoraRN.dateToStringYYYYMMDDHHMMSS(b.getDthrleitura()) + " - turno " + b.getCdturno() + " agora " + turno.getIjtbtur().getCdturno());
			} catch (SemCalendarioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 */
		
		
	}

	
	public static TurnoInjetDTO encontraTurno(DAOGenericoInjet daoInjet, Date dthr) throws SemCalendarioException{
		TurnoInjetDTO retorno = null;
		// Encontra qual a agenda deve ser usada para a data e hora passada
		TurnoInjetRN rnCal = new TurnoInjetRN(daoInjet);

		// Encontra qual o dia da semana da data e hora passada
		int diaSemana = DataHoraRN.getWeekDay(dthr);
		int diaSemanaAnt = DataHoraRN.getWeekDay(DataHoraRN.advanceDate(dthr, -1) );
		int diaSemanaPos = DataHoraRN.getWeekDay(DataHoraRN.advanceDate(dthr, 1) );

		// Pesquisa todos os turnos (ijhortur) do dia da semana passada, do dia anterior e posterior
		List<Ijhortur> turnos = rnCal.pesquisarListaIjhortur(dthr, "00000" + diaSemana);
		List<Ijhortur> turnosAnt = rnCal.pesquisarListaIjhortur(dthr, "00000" + diaSemanaAnt);
		List<Ijhortur> turnosPos = rnCal.pesquisarListaIjhortur(dthr, "00000" + diaSemanaPos);

		// Interage sobre todos os dias definindo o inicio e final dos turnos
		// comparando cada turno com a data de referencia. Retornar o 1o que encontrar
		for (Ijhortur ijhortur : turnos){
			Date dataReferencia = dthr;
			Date dthrI = calcularInicioTurno(daoInjet, dataReferencia, ijhortur.getId().getCdturno());
			Date dthrF = calcularFimTurno(daoInjet, dataReferencia, ijhortur.getId().getCdturno());

			if ( (DataHoraRN.equals(dthr, dthrI) || DataHoraRN.after(dthr, dthrI) ) &&
					(DataHoraRN.equals(dthr, dthrF) || DataHoraRN.before(dthr, dthrF)) ){
				retorno = new TurnoInjetDTO(); 
				retorno.setDtReferencia(dataReferencia);
				retorno.setIjtbtur(ijhortur.getIjtbtur());
				break;
			}
			
		}
		if (retorno == null){
			for (Ijhortur ijhortur : turnosAnt){
				Date dataReferencia = DataHoraRN.advanceDate(dthr, -1);
				Date dthrI = calcularInicioTurno(daoInjet, dataReferencia, ijhortur.getId().getCdturno());
				Date dthrF = calcularFimTurno(daoInjet, dataReferencia, ijhortur.getId().getCdturno());

				if ( (dthr.equals(dthrI) || dthr.after(dthrI) ) &&
						(dthr.equals(dthrF) || dthr.before(dthrF)) ){
					retorno = new TurnoInjetDTO(); 
					retorno.setDtReferencia(dataReferencia);
					retorno.setIjtbtur(ijhortur.getIjtbtur());
					break;
				}
			}
		}
		if (retorno == null){
			for (Ijhortur ijhortur : turnosPos){
				Date dataReferencia = DataHoraRN.advanceDate(dthr, 1);
				Date dthrI = calcularInicioTurno(daoInjet, dataReferencia, ijhortur.getId().getCdturno());
				Date dthrF = calcularFimTurno(daoInjet, dataReferencia, ijhortur.getId().getCdturno());

				if ( (dthr.equals(dthrI) || dthr.after(dthrI) ) &&
						(dthr.equals(dthrF) || dthr.before(dthrF)) ){
					retorno = new TurnoInjetDTO(); 
					retorno.setDtReferencia(dataReferencia);
					retorno.setIjtbtur(ijhortur.getIjtbtur());
					break;
				}
			}
		}

		if (retorno == null)
			throw new SemCalendarioException();
		return retorno;
	}

	public static TurnoInjetDTO encontraTurnoColetas(DAOGenericoInjet daoInjet) throws SemCalendarioException{

		TurnoInjetDTO retorno = null;

		TurnoInjetRN rnCal = new TurnoInjetRN(daoInjet);

		PeriodoDTO periododto = null;
		Ijtbtur ijtbtur = null;
		
		periododto = rnCal.getTurnoAtualColetas();
		
		
		if (periododto!=null && periododto.getTurnoAtualDTO()!=null){
			retorno =  new TurnoInjetDTO();
			if ( periododto.getTurnoAtualDTO().getCdTurno()!=null){
				TurnoDTO turnodto = new TurnoDTO(); 
				turnodto =  rnCal.getTurnoInjet(periododto.getTurnoAtualDTO().getCdTurno());
				if (turnodto!=null && turnodto.getDsTurno()!=null){
					ijtbtur = new Ijtbtur();
					ijtbtur.setDsturno(turnodto.getDsTurno());
					ijtbtur.setCdturno(turnodto.getCdTurno());
					retorno.setIjtbtur(ijtbtur);
				}
			}
			retorno.setDtReferencia(periododto.getTurnoAtualDTO().getDtReferencia());			
		}

		if (retorno == null)
			throw new SemCalendarioException();

		return retorno;
	}
	
	public static List<IntervaloTempoInjetDTO> horasPeriodo(DAOGenericoInjet daoInjet, Date dthrini, Date dthrfim)
	{
		List<IntervaloTempoInjetDTO> listaRetorno = new ArrayList<IntervaloTempoInjetDTO>();
		IntervaloTempoInjetDTO intervalo = new IntervaloTempoInjetDTO();
		String hql;
		Integer segRefIni = 0;
		Date dthriniAux, dthrfimAux;
		Date dthriniHora, dthrfimHora;
		

		//recupera o hor�rio de in�cio de refer�ncia
		hql = "SELECT HrReferencia FROM ijconger";
		
		Query q = daoInjet.getSession().createSQLQuery(hql)
				.addScalar("HrReferencia", IntegerType.INSTANCE);
			
		try 
		{
			segRefIni = (Integer) q.list().get(0);

			// com base neste in�cio gerar lista de hor�rios que fa�am interse��o com o per�odo passado no par�metro
			
			/*
			dthriniAux = DataHoraRN.adicionaSegundosNaData(DataHoraRN.getDataSemHora(dthrini), segRefIni);
			dthrfimAux = DataHoraRN.adicionaSegundosNaData(dthrini, 86400);  
			*/
			dthriniAux = DataHoraRN.adicionaSegundosNaData(DataHoraRN.getDataSemHora(dthrini), -86400);
			dthrfimAux = DataHoraRN.adicionaSegundosNaData(DataHoraRN.getDataSemHora(dthriniAux), 86400 * 2);  

			dthriniHora = dthriniAux;
			dthrfimHora = dthriniHora;
			while (DataHoraRN.before(dthrfimHora, dthrfimAux))
			{
				dthrfimHora = DataHoraRN.adicionaSegundosNaData(dthriniHora, 3599);

				if ( ( (dthriniHora.after(dthrini) || DataHoraRN.equals(dthriniHora, dthrini)) && ((DataHoraRN.before(dthriniHora, dthrfim) || DataHoraRN.equals(dthriniHora, dthrfim))) ) ||
					 ( (dthrfimHora.after(dthrini) || DataHoraRN.equals(dthrfimHora, dthrini)) && ((DataHoraRN.before(dthrfimHora, dthrfim) || DataHoraRN.equals(dthrfimHora, dthrfim))) ) ||
					 ( (dthrini.after(dthriniHora) || DataHoraRN.equals(dthriniHora, dthrini)) && ((DataHoraRN.before(dthrini, dthrfimHora) || DataHoraRN.equals(dthriniHora, dthrfimHora))) ) )
				{
					intervalo = new IntervaloTempoInjetDTO();
					intervalo.setDtHrIniPeriodo(dthriniHora);
					intervalo.setDtHrFimPeriodo(dthrfimHora);
					
					listaRetorno.add(intervalo);					
				}
				
				dthriniHora = DataHoraRN.adicionaSegundosNaData(dthriniHora, 3600);
			}			
		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return listaRetorno;
	}
	
	public static BigDecimal getTempoParadaNoIntervaloDoTurno(
			DAOGenericoInjet dao,
			Date inicioPeriodoEntrada, 
			Date fimPeriodoEntrada, 
			Date inicioParada, 
			Date fimParada,
			String cdTurno){
		Date inicio = null;
		Date fim = null;
		BigDecimal retorno = new BigDecimal(0);

		DiversosInjetRN diversosRN = new DiversosInjetRN(dao);
		diversosRN.setDaoSession(dao.getSession());

		if (fimParada == null){
			fimParada = diversosRN.getDtHrSistemaDeIjtreal();
		}

		inicio = inicioPeriodoEntrada;
		fim = fimPeriodoEntrada;

		int dias = DataHoraRN.amountOfDaysInPeriod(inicio, fim);
		if (dias == 0)
			dias = 1;
		Date i = inicio; 
		for (int cont = 1; cont <= dias; cont++){
			// Encontrar inicio do turno para a data i
			Date inicioTurno = null;
			try{
				inicioTurno = FuncoesApoioInjet.calcularInicioTurno(dao, i, cdTurno);
			} catch (SemCalendarioException e){
				i = DataHoraRN.normalize(DataHoraRN.advanceDate(i, 1), DataHoraRN._DAY);
				continue;
			}
			// Encontrar fim do turno para a data i
			Date fimTurno = null;
			try{
				fimTurno = FuncoesApoioInjet.calcularFimTurno(dao, i, cdTurno);
			} catch (SemCalendarioException e){
				i = DataHoraRN.normalize(DataHoraRN.advanceDate(i, 1), DataHoraRN._DAY);
				continue;
			}
			
			int segundos = getEmSegundosIntersecaoHorarios(inicioTurno, fimTurno, inicioParada, fimParada);
			
			// Se o fim da parada for superior ao fim do turno, acrescentar 1seg para compensar os horarios de turno que terminam com 9999
			if (fimParada.after(fimTurno) && segundos > 0)
				segundos++;
			
			retorno = retorno.add(new BigDecimal(segundos));

			i = DataHoraRN.normalize(DataHoraRN.advanceDate(i, 1), DataHoraRN._DAY);
			
		}
		
		return retorno;
	}
	public static BigDecimal getTempoParadaNoIntervalo(DAOGenericoInjet dao, Date inicioPeriodoEntrada, Date fimPeriodoEntrada, Date inicioParada, Date fimParada){
		Date inicio = null;
		Date fim = null;
		Date fimTemporario = null;
		Date inicioPeriodo = inicioPeriodoEntrada;
		Date fimPeriodo = fimPeriodoEntrada;
		BigDecimal retorno;

		DiversosInjetRN diversosRN = new DiversosInjetRN(dao);
		diversosRN.setDaoSession(dao.getSession());

		if (inicioPeriodo == null)
			inicioPeriodo = inicioParada;

		if (fimPeriodo == null)
			fimPeriodo = fimParada;

		if (fimParada == null){
			fimTemporario = diversosRN.getDtHrSistemaDeIjtreal();
		} else
			fimTemporario = fimParada;

		if (fimPeriodo == null)
			fimPeriodo = fimTemporario;

		if (inicioParada.after(inicioPeriodo))
			inicio = inicioParada;
		else
			inicio = inicioPeriodo;

		if (DataHoraRN.before(fimTemporario, fimPeriodo))
			fim = fimTemporario;
		else
			fim = fimPeriodo;

		if (fim.before(inicio))
			retorno = new BigDecimal(0);
		else
			retorno = new BigDecimal(DataHoraRN.amountOfSecondsInPeriod(inicio, fim));

		return retorno;
	}

	public static TurnoInjetDTO encontraTurnoAtual(DAOGenericoInjet daoInjet) throws SemCalendarioException {
		Date dtHr = new Date();		
		return encontraTurno(daoInjet, dtHr);
	}

	public static TurnoInjetDTO encontraTurnoAtualColetas(DAOGenericoInjet daoInjet) throws SemCalendarioException {	
		return encontraTurnoColetas(daoInjet);
	}

	public static String getStrZero(Long cd, Integer tamanhoCodigo) {
		BigDecimal valor = new BigDecimal(cd);
		String cdStr = valor.toString().replace(" ", "");
		
		return StringUtils.repeat('0', tamanhoCodigo - cdStr.length()) + cdStr;
	}	
}