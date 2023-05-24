package idw.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwRtcic;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.consolidacao.parada.ConsolidacaoParada;
import ms.util.ConversaoTipos;

public class TesteRitmoRN  extends AbstractRN<DAOGenerico>  {

	public TesteRitmoRN() {
		super(new DAOGenerico());
	}
	public TesteRitmoRN(DAOGenerico dao) {
		super(dao);
	}

	/*
	 * 0 = Data de referencia do turno formato YYYY-mm-dd
	 * 1 = Numero do turno
	 * 2 = Codigo do PT
	 */
	public static void main (String args[]) {
		TesteRitmoRN rn = new TesteRitmoRN();
		rn.iniciaConexaoBanco();
		
		ConsolidacaoParada consolidacaoParada = new ConsolidacaoParada(rn.getDao());
		
		Date dtReferencia = null;
		
		try {
			dtReferencia = DataHoraRN.stringToDate(args[0], "yyyy-MM-dd");
		} catch (Exception e) {
			System.out.println("Sintaxe TesteRitmoRN yyyy-mm-dd idturno cdmaquina");
			System.exit(0);
		}
		
		// Descobrir o inicio e fim do turno
		
		MapQuery q0 = new MapQuery(rn.getDaoSession());
		q0.append("select dwconsolid");
		q0.append("from DwConsolid dwconsolid");
		q0.append("join dwconsolid.omPt ompt");
		q0.append("where dwconsolid.dtReferencia = :dt");
		q0.append("and ompt.cdPt = :cdpt");
		q0.append("and dwconsolid.tpId = 1");
		q0.append("and dwconsolid.dwTurno.idTurno = :id");
		
		q0.setMaxResults(1);
		q0.defineParametroData("dt", dtReferencia);
		q0.defineParametro("cdpt", args[2]);
		q0.defineParametro("id", Long.valueOf(args[1]));
		
		DwConsolid dwconsolid = (DwConsolid) q0.uniqueResult();
		
		MapQuery q = new MapQuery(rn.getDaoSession());

		q.append("select a");
		q.append("from DwRtcic a");
		q.append("join a.dwRt b");
		q.append("join b.omPt c");
		q.append("where");
		q.append("c.cdPt = :cdpt");
		q.append("and (a.dthrIciclo between :dti and :dtf");
		q.append("or a.dthrFciclo between :dti and :dtf )");
		q.append("order by a.dthrIciclo");
		
		q.defineParametroTimestamp("dti", dwconsolid.getDthrIturno());
		q.defineParametroTimestamp("dtf", dwconsolid.getDthrFturno());
		q.defineParametro("cdpt", args[2]);
		
		System.out.println("Dt.Referencia: " + DataHoraRN.toStringYYYYMMDD(dtReferencia));
		System.out.println("idTurno " + args[1]);
		System.out.println("Pt= " + args[2]);
		List<DwRtcic> lista = q.list();
		
		
		BigDecimal somaTempoativo = BigDecimal.ZERO;
		BigDecimal somaCicloImpro = BigDecimal.ZERO;
		BigDecimal somaTempoparada = BigDecimal.ZERO;
		double somaDiff = 0d;
		
		// Pesquisa para obter as paradas que ocorreram durante o ciclo, mas filtrando o inicio e fim da parada ao turno
		MapQuery q9 = new MapQuery(rn.getDaoSession());
		q9.append("select distinct a");
		q9.append("from DwConsolpaoco a");
		q9.append("join a.dwConsolpa b");
		q9.append("join b.dwConsol c");
		q9.append("join c.dwConsolid d");
		q9.append("where");
		q9.append("d.tpId = 1");
		q9.append("and d.dtReferencia = :dtreferencia");
		q9.append("and d.dwTurno.idTurno = :idturno");
		q9.append("and d.omPt.idPt = :idpt");
		q9.append("and ( (a.dthrIparada >= :inicio and a.dthrIparada <= :fim) or (a.dthrFparada >= :inicio and a.dthrFparada <= :fim) )");
		
		q9.defineParametroData("dtreferencia", dwconsolid.getDtReferencia());
		q9.defineParametro("idturno", dwconsolid.getDwTurno().getIdTurno());
		q9.defineParametro("idpt", dwconsolid.getOmPt().getIdPt());
		
		List<Long> idConsolpaoco = new ArrayList<Long>(); 
		int qtCiclosProdu = 0;
		
		Date dthrIMenorCiclo = null;
		Date dthrFMaiorCiclo = null;
		StringBuilder cab = new StringBuilder();
		cab.append("Inicio ciclo");
		cab.append("\t\t");
		cab.append("Fim Ciclo");
		
		cab.append("\t");
		cab.append("T.Ciclo");
		cab.append("\t");

		cab.append("TParada");
		cab.append("\t");
		cab.append("C.Padrao");
		cab.append("\t");
		cab.append("T.Ciclo-TParada");
		cab.append("\t");
		cab.append("T.AtivoParc");
		
		System.out.println(cab.toString());
		
		List<DwRtcic> listaTodosCicloAvalisados = new ArrayList<>();

		for (DwRtcic dwrtcic : lista) {
			// Verificar seo ciclo avaliado tem conflito com algum ciclo ja processado
			for (DwRtcic japroc : listaTodosCicloAvalisados) {
				if (DataHoraRN.isIntersecao(dwrtcic.getDthrIciclo(), dwrtcic.getDthrFciclo(), japroc.getDthrIciclo(), japroc.getDthrFciclo()))
					System.out.println("Ciclo com conflito = " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dwrtcic.getDthrIciclo()));
			}
			DwRtcic clone = dwrtcic.clone(false);
			clone.setDthrIciclo(DataHoraRN.adicionaMilisegundosNaData(clone.getDthrIciclo(), 1));
			clone.setDthrFciclo(DataHoraRN.subtraiSegundosDaData(clone.getDthrFciclo(), 1));
			listaTodosCicloAvalisados.add(clone);
			
			if (dthrIMenorCiclo == null || DataHoraRN.after(dthrIMenorCiclo, dwrtcic.getDthrIciclo()))
				dthrIMenorCiclo = dwrtcic.getDthrIciclo();
			if (dthrFMaiorCiclo == null || DataHoraRN.before(dthrFMaiorCiclo, dwrtcic.getDthrFciclo()))
				dthrFMaiorCiclo = dwrtcic.getDthrFciclo();
			// Procurar as paradas para o ciclo avaliado
			
			StringBuilder linha = new StringBuilder();
			StringBuilder linha2 = new StringBuilder();
			
			BigDecimal tciclo = BigDecimal.ZERO;
			Date dthriciclo = dwrtcic.getDthrIciclo();
			Date dthrfciclo = dwrtcic.getDthrFciclo();

			boolean isCicloFora = false;
			
			if (DataHoraRN.before(dthriciclo, dwconsolid.getDthrIturno())) {
				dthriciclo = dwconsolid.getDthrIturno();
				isCicloFora = true;
			} else {
				qtCiclosProdu++;
			}
			
			if (DataHoraRN.after(dthrfciclo, dwconsolid.getDthrFturno()))
				dthrfciclo = dwconsolid.getDthrFturno();
			
			tciclo = new BigDecimal(DataHoraRN.getQuantidadeMilisegundosNoPeriodo(dthriciclo, dthrfciclo));
			tciclo = tciclo.divide(new BigDecimal(1000));
			
			if (isCicloFora)
				somaCicloImpro = somaCicloImpro.add(tciclo);
			
			somaTempoativo = somaTempoativo.add(tciclo);
			
			q9.defineParametroTimestamp("inicio", dthriciclo);
			q9.defineParametroTimestamp("fim", dthrfciclo);

			linha.append(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dthriciclo));
			linha.append("\t");
			linha.append(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dthrfciclo));
			
			linha.append("\t");
			linha.append(ConversaoTipos.converteParaString(tciclo.doubleValue(), 0));
			linha.append("\t");

			List<DwConsolpaoco> paradas  = q9.list();
			BigDecimal tparada = BigDecimal.ZERO;
			boolean isMesmaparada = false;
			List<DwConsolpaoco> leudenovo = new ArrayList<DwConsolpaoco>();
			java.util.Collections.sort(paradas, new Comparator<DwConsolpaoco>() {
				@Override
				public int compare(DwConsolpaoco o1, DwConsolpaoco o2) {
					return DataHoraRN.compareTo(o1.getDthrIparada(), o2.getDthrIparada());
				}
			});
			for (DwConsolpaoco parada : paradas) {
				double duracao = DataHoraRN.getQuantidadeMilisegundosNaIntersecao(dthriciclo, dthrfciclo, parada.getDthrIparada(), parada.getDthrFparada());
				duracao /= 1000;
				if (idConsolpaoco.contains(parada.getIdConsolpaoco())) {
					linha2.append("RE.......inicio parada=");
				} else {
					idConsolpaoco.add(parada.getIdConsolpaoco());
					linha2.append(".........inicio parada=");
				}
				linha2.append(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(parada.getDthrIparada()));
				linha2.append(".....fim parada=");
				linha2.append(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(parada.getDthrFparada()));
				linha2.append("...duracao=" + duracao);
				linha2.append("\n");
				
				tparada = tparada.add(new BigDecimal(duracao));
			}
			linha.append(ConversaoTipos.converteParaString(tparada.doubleValue(), 0));
			linha.append("\t");
			linha.append(ConversaoTipos.converteParaString(dwrtcic.getDwFolha().getSegCiclopadrao().doubleValue(), 2));
			linha.append("\t");
			double diff =  tciclo.doubleValue() - tparada.doubleValue() - dwrtcic.getDwFolha().getSegCiclopadrao().doubleValue();
			
			if ( isCicloFora )
				diff = 0d;
			
			linha.append(diff);
			linha.append("\t");
			
			somaDiff += diff;

			somaTempoparada = somaTempoparada.add(tparada);

			linha.append(somaTempoativo.subtract(somaTempoparada));

			System.out.println(linha.toString());
			System.out.println(linha2.toString());
		}
		
		System.out.println("Fim da lista");
		System.out.println("Soma tempo ativo= " + DataHoraRN.formatSegundosParaHHMMSS(somaTempoativo.intValue()));
		System.out.println("Soma ciclo improdutivo = " + DataHoraRN.formatSegundosParaHHMMSS(somaCicloImpro.intValue()));
		System.out.println("Ciclo Produtivo (D) = " + DataHoraRN.formatSegundosParaHHMMSS(somaTempoativo.intValue() - somaCicloImpro.intValue() - somaTempoparada.intValue()));
		System.out.println("QtCiclosProd = " + qtCiclosProdu);
		System.out.println("Soma tempo parada: " + DataHoraRN.formatSegundosParaHHMMSS(somaTempoparada.intValue()));
		System.out.println("Soma diffCiclo: " + somaDiff);
		
		System.out.println("Menor data e hora de ciclos=" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dthrIMenorCiclo));
		System.out.println("Maior data e hora de ciclos=" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dthrFMaiorCiclo));
		if (somaDiff < 0) {
			somaDiff *= -1;
			System.out.println("Diff formatado: -" + DataHoraRN.formatSegundosParaHHMMSS( (int)somaDiff));
		} else {
			System.out.println("Diff formatado: " + DataHoraRN.formatSegundosParaHHMMSS( (int)somaDiff));
		}
		
		rn.finalizaConexaoBanco();
	}
}
