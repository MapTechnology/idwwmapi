package idw.model.rn.geraplano.passos.tipoB;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpPlano;
import idw.model.rn.CalendarioRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PlanoIndisponibilidadeRN;
import idw.model.rn.geraplano.dtos.CtDTO;
import idw.model.rn.geraplano.dtos.IdCtDTO;
import idw.model.rn.geraplano.dtos.IndisponibilidadeDTO;
import idw.model.rn.geraplano.dtos.IndisponibilidadesDTO;
import idw.util.IdwLogger;

public class TipoBIndisponibilidade {
	private DAOGenerico dao;
	
	public TipoBIndisponibilidade(DAOGenerico dao){
		this.dao = dao;
	}
	public void geraIndisponibilidade(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<IdCtDTO, CtDTO> alocacaoCTs){
		PlanoIndisponibilidadeRN irn = new PlanoIndisponibilidadeRN(dao);
		CalendarioRN crn = new CalendarioRN();
		crn.setSession(dao.getSession());
		
		for (IdCtDTO idctdto : alocacaoCTs.keySet()){
			CtDTO ctdto = alocacaoCTs.get(idctdto);

			log.info(ctdto.toString());
			
			calculandoIndisponibilidade (log, idLog, identacao, irn, crn, ctdto,ppplano);
		}
	}
	
	/*
	 * O objetivo desse metodo eh tornar as Cps atuais do plano firmado como periodos de indisponibilidade
	 * Isso significa que as Cps atuais devem terminar para que o proximo plano comece
	 * O passo que obtem os estoque atuais irá considerar também a producao dessas Cps para
	 * que o sistema nao mande produzir a mesma producao
	private List<IndisponibilidadeDTO> obtemCpsAtuaisNoPlanoFirmado(){
		List<IndisponibilidadeDTO> retorno = new ArrayList<IndisponibilidadeDTO>();
		MapQuery q = new MapQuery(dao.getSession());
		q.append("select ppcp");
		q.append("from PpCp ppcp");
		q.append("join fetch ppcp.ppPlano ppplano");
		q.append("where ppplano.stAtivo = 1 and ppplano.stPlano = 1"); // plano firmado
		q.append("and ? between ppcp.dthrInicio and ppcp.dthrFinal");
		
		q.query().setTimestamp(0, DataHoraRN.getDataHoraAtual());

		List<PpCp> lista = q.list();
		
		for (PpCp ppcp : lista){
			IndisponibilidadeDTO ind = new IndisponibilidadeDTO();
			ind.setFim(ppcp.getDthrFinal());
			ind.setInicio(ppcp.getDthrInicio());
			
			retorno.add(ind);
		}
		
		return retorno;
	}	 */

	public void calculandoIndisponibilidade (IdwLogger log, int idLog, int identacao, PlanoIndisponibilidadeRN irn, CalendarioRN crn, CtDTO ctdto, PpPlano ppplano){
		
		// Inicializa plano de indisponibilidade
		ctdto.addIndisponibilidade(irn.pesquisarIndisponibilidades(log, idLog, identacao, ctdto.getId()));

		// Alessandre no tipo de plano progressivo os horarios das cps firmadas nao sao inidsponibilidades
		// as cps servirao apenas como referencia para as novas cps
		// Inicializa indisponibilidades com as OPs que estao rodando, conforme identificadas no plano de producao firmado
		//ctdto.addIndisponibilidade(obtemCpsAtuaisNoPlanoFirmado());
		
		// Inicializa indisponbilidades do calendario
		//Tem as hrs que a maq trabalha
		List<DwCalsem> listaDwCalsem = crn.pesquisarHorariosDeIndisponibilidade(log, idLog, identacao, ctdto.getId(), ppplano);
//		ctdto.addCalendarioIndisponibilidade(listaDwCalsem);
		
		String ompt = ctdto.getId().toString();
		String stringOmpt = ompt.substring(2, ompt.length());		
		log.info(stringOmpt);
		
		//Horario de indisponibilidade de cada dia em tres meses
		Date dataAtual = DataHoraRN.getDataHoraAtual();
		dataAtual = DataHoraRN.getPrimeiroDiaDoMesDaData(dataAtual);
		
		Calendar mesAnterior = Calendar.getInstance();
		mesAnterior.setTime(dataAtual);
		mesAnterior.add(Calendar.MONTH,-1);

		if (stringOmpt.equals("MS1")){
			log.info("Mes anterior " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(mesAnterior.getTime()));
		}

		Date mesPosterior = DataHoraRN.getDataHoraAtual();
		mesPosterior = DataHoraRN.adicionaMesNaData(mesPosterior, +2);
		mesPosterior = DataHoraRN.getPrimeiroDiaDoMesDaData(mesPosterior);

		if (stringOmpt.equals("SMD_")){
			log.info("Mes posterior " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(mesPosterior));
		}
		 
		List<IndisponibilidadeDTO> listaHrIndisponivel = new ArrayList<IndisponibilidadeDTO>();
		
		Date diaAnterior = mesAnterior.getTime();
		diaAnterior=DataHoraRN.subtraiSegundosDaData(diaAnterior,1);

		
		// Ordena a lista do calendario semanal
		Collections.sort(listaDwCalsem, new Comparator<DwCalsem>() {

			@Override
			public int compare(DwCalsem o1, DwCalsem o2) {
				int dia1 = o1.getDiasemana().intValue();
				int dia2 = o2.getDiasemana().intValue();
				
				int seg1 = DataHoraRN.getHHMMEmSegundos(o1.getHrInicialGui());
				int seg2 = DataHoraRN.getHHMMEmSegundos(o2.getHrInicialGui());
				
				int retorno = (dia1 < dia2 ? -1 : (dia1 > dia2 ? +1 : (seg1 < seg2 ? -1 : seg1 > seg2 ? +1 : 0) ) );
				
				//System.out.println("Dia1=" + dia1 + " Dia2=" + dia2 + " seg1=" + seg1 + " seg2=" + seg2 + " retorno=" + retorno);
				return retorno;
			}
		});
		
		// Interage sobre todos os dias dos 3 meses que serao geradas as indisponibilidades
		while (DataHoraRN.before(mesAnterior.getTime(), mesPosterior)){			
			int diaDaSemanaDoMes = mesAnterior.get(Calendar.DAY_OF_WEEK) - 1;
			
			// Alessandre: Colocarei o dia todo como indisponivel, e conforme for se avancando pelos periodos produtivos, iremos
			// removendo-os da indisponibilidade
			IndisponibilidadesDTO indisponibilidadesNoDia = new IndisponibilidadesDTO();
			
			// Deixando o dia inteiro como indisponivel
			indisponibilidadesNoDia.addIndisponibilidade(DataHoraRN.getDataSemHora(mesAnterior.getTime()), DataHoraRN.setHoraNaData(mesAnterior.getTime(), 23, 59, 59, 999));
			
			for (DwCalsem diaDaSemana : listaDwCalsem){
				// Se o calendario for o do dia em avaliacao, continuar, senao obter o proximo registro
				if(diaDaSemanaDoMes != diaDaSemana.getDiasemana().intValue()) { //  || diaDaSemana.getDwCal().getStAtivo()!=1 || diaDaSemana.getDwCal().getDwCalpts().size()<=0){
					continue;
				}
				
				
				// Remover o dia produtivo da lista de indisponibilidades
			//	indispTempocalsempeso = indisponibilidadesNoDia.removerDwCalsem(mesAnterior.getTime(), diaDaSemana, indispTempocalsempeso, log);
				indisponibilidadesNoDia.removerDwCalsem(mesAnterior.getTime(), diaDaSemana, log);
			}
			
			// Encontra os horario nao trabalhados no dia avaliado
			listaHrIndisponivel.addAll(indisponibilidadesNoDia.getListaIndisponibilidades());
			
            mesAnterior.set(Calendar.DAY_OF_MONTH, mesAnterior.get(Calendar.DAY_OF_MONTH) +1 );  
        }
		
		
		// Apos passar por todos os horario, o proximo loop vai remover da lista aqueles horario que tiverem o inicio e fim iguais
		Iterator<IndisponibilidadeDTO> i = listaHrIndisponivel.iterator();
		IndisponibilidadeDTO pAnterior = null;
		while (i.hasNext() == true) {
			IndisponibilidadeDTO iIndisp = i.next();

			if (DataHoraRN.equals(iIndisp.getInicio(), iIndisp.getFim())  == true){
				i.remove();
				continue;
			}
			
			if (DataHoraRN.after(iIndisp.getInicio(), iIndisp.getFim())  == true){
				i.remove();
				continue;
			}
			
			if(pAnterior==null){
				pAnterior = iIndisp;
				continue;
			}
			
			if(pAnterior.equals(iIndisp)){
				i.remove();
			}else{
				pAnterior = iIndisp;
			}
		}
		
		if (listaHrIndisponivel.isEmpty()){
			log.info("Pt - sem tempo de indisponibilidade : " + stringOmpt);
		}else{
			ctdto.addIndisponibilidade(listaHrIndisponivel);
		}
	}
	
	/* Alessandre: comentei esse metodo em 21-01-13 pois nao esta sendo usado por ninguem
	private IndisponibilidadeDTO addListaIndisponibilidade(Date diaAnterior, Date fim, int segTempocalsempeso){
		
		IndisponibilidadeDTO horariosIndisponiveisSemanais = new IndisponibilidadeDTO();
		
		Date dateInicio = DataHoraRN.adicionaSegundosNaData(diaAnterior,1);
		Date dateFinal = fim;
		dateFinal = DataHoraRN.subtraiSegundosDaData(dateFinal,1);
	
		//adc o tempo improdutivo de uma determinada maquina
		dateFinal = DataHoraRN.adicionaSegundosNaData(dateFinal,segTempocalsempeso);
		
		horariosIndisponiveisSemanais.setInicio(dateInicio);
		horariosIndisponiveisSemanais.setFim(dateFinal);
			
		return horariosIndisponiveisSemanais;
	}*/
}
