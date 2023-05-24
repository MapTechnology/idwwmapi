package idw.model.rn.geraplano.passos.tipoA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import idw.model.pojos.OmUsr;
import idw.model.pojos.PpPlano;
import idw.model.rn.DataHoraRN;
import idw.model.rn.geraplano.dtos.CtDTO;
import idw.model.rn.geraplano.dtos.IdCtDTO;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.util.IdwLogger;

public class TipoARemoveConflitoInclusivePre {
	
	/*
	 * 
	 */
	public SortedMap<IdCtDTO, CtDTO> geraCpsSemConflitoRecalculandoPredecessoras(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<IdCtDTO, CtDTO> alocacaoCTs, boolean isCalculaPassoComIndisponibilidade){
		log.info(idLog, identacao, "geraCpsSemConflitoRecalculandoPredecessoras");
		SortedMap<IdCtDTO, CtDTO> alocacaoCTsSemConflito = new TreeMap<IdCtDTO, CtDTO>();
		
		// Nesse momento é interessante que sejam percorridos os CTs a partir das SMDs para as Ilhois
		// visto que as predecessoras sao recalculadas
		List<IdCtDTO> ctsOrdenados = new ArrayList<IdCtDTO>(alocacaoCTs.keySet());
		Collections.sort(ctsOrdenados, new Comparator<IdCtDTO>() {
			@Override
			public int compare(IdCtDTO o1, IdCtDTO o2) {
				return o1.compareTo(o2)*-1 ;
			}
		});
		
		for (IdCtDTO idctdto : ctsOrdenados){
			log.info(idctdto.toString());
		}

		for (IdCtDTO idctdto : ctsOrdenados){
			// Ordena da maior data de fim para a menor data de fim
			if (idctdto.toString().equals("PtRH-2")){
				log.info(idctdto.toString());
			}
			CtDTO ctdto = alocacaoCTs.get(idctdto);

			List<PassosDTO> listaordenada = ctdto.getPassosAlocadosJaOrdenadosPeloFimComEspelhoAjustado(log, idLog, identacao);
			List<PassosDTO> lista = new ArrayList<PassosDTO>();
			
			// Varre as CPs removendo os conflitos colocando uma das duas para um periodo anterior
			PassosDTO pAnterior = null;
			log.info(idLog, identacao, "Removendo conflito para o CT " + ctdto);
			for (PassosDTO p : listaordenada){
				
				if (p.getOmproduto().toString().equals("922381"))
					log.info(idLog, identacao, "DEBUG");
				

				p.getCtEscolhido().setHorariosIndisponiveis(ctdto.getHorariosIndisponiveis());
				if ((ctdto.toString().equals("Gt SMD_L5") && (p.getOmproduto().getOmproduto().getCdProduto().equals("1RE1TGA130LB-CO")))&&(p.getProducaoPlanejada() == 2400.0)){
					log.info("DEBUG");
				}
				
				if (pAnterior == null) {
					pAnterior = p;
					lista.add(p);
					continue;
				}
				
				log.info(idLog, identacao, (p.isConflitaCom(pAnterior) ? "CONFLITA" : "NAO CONFLITA") + p + " com anterior " + pAnterior);
				
				// Recalcula o passo avaliado
				if (	p.isConflitaCom(pAnterior) == true /*
						Alessandre: em 14-01-13 Removi os 2 OR abaixo pois teoricamente o isCOnflitaCom deve prover qq periodos
						conflitantes entre as datas
						Alessandre: Descomentei pois deixou de recalcular */
						|| 
						DataHoraRN.after(p.getFim(), pAnterior.getInicio()) == true || 
								DataHoraRN.before(p.getInicio(), pAnterior.getFim()) == true
					){
					p.calculaDatasInicioFim(log, idLog, identacao, DataHoraRN.subtraiSegundosDaData(pAnterior.getInicio(),1));
					log.info(idLog, identacao + 10, "SEM INDIPONIBILIDADE 2: " + p + " BASEANDO-SE Em " + pAnterior);
				}
				
				// Alessandre: comentei a linha abaixo em 18-02-13 pois nao criei ela e estou com problema de conflito
				//verificaConflito(log, idLog, identacao, p, lista);
				//calculaPassoComIndisponibilidade(log, idLog, identacao, p);
				//log.info("Com INDISPONIBILIDADE 2: " + p);
				
				// o passo atual passa a ser o anterior para qdo o passo seguinte for avaliado
				pAnterior = p;
				lista.add(p);
			}
			
			// sera necessario jogar novamente a lista para o SortedMap? avaliar...NAO eh necessario jogar para o map novamente.
			CtDTO ctdto2 = new CtDTO(ctdto);
			ctdto2.setPassosAlocados(listaordenada);
			lista = null;
			alocacaoCTsSemConflito.put(ctdto2.getId(), ctdto2);
		}
		
		return alocacaoCTsSemConflito;
	}
	
	private void verificaConflito(IdwLogger log, int idLog, int identacao, PassosDTO p, List<PassosDTO> lista){

		boolean loop = true;
		
		while (loop == true){
			loop = false;
			for (PassosDTO passoLista: lista){
				if (p.isConflitaCom(passoLista) == false)
					continue;
				if(p.toString().equals("CT Gt SMD_L5 2012-10-22 09:22:02 ate 2012-10-23 09:56:05 (24hrs) produto REA4743B-IAC quantidade 1300.0 rota 3 qtcavativ 1.0 tmpEst 17.5675")){
					log.info("DEBUG");
				}
				p.calculaDatasInicioFim(log, idLog, identacao, DataHoraRN.subtraiSegundosDaData(passoLista.getInicio(),1));
			//	extra.setInicio(DataHoraRN.subtraiSegundosDaData(extra.getInicio(),60));
				log.info(idLog, identacao, (p.isConflitaCom(passoLista) ? "Verifica conflito: CONFLITA " : "Verifica conflito: NAO CONFLITA") + p + " com anterior " + passoLista);
				//loop = true;
				break;
			}
		}
		
	}
	
	public void calculaPassoComIndisponibilidade(IdwLogger log, int idLog, int identacao, PassosDTO passo){
		
	//	passo.calculaDatasInicioFim(log, idLog, identacao, passo.getFim());
	
		for (PassosDTO predecessora : passo.getPassosPredecessoras()){
			double qtMovimentacao = predecessora.getDwrotapasso().getQtMovimentacao().doubleValue();
			
			// Se a quantidade de movimentacao for maior que a producao planejada, entao considerar a producaoPlanejada para o calculo
			if (predecessora.getProducaoPlanejada() < qtMovimentacao){
				qtMovimentacao = predecessora.getProducaoPlanejada();
			}
			if((DataHoraRN.after(predecessora.getInicio(), passo.getInicio()))||(DataHoraRN.before(passo.getFim(), predecessora.getFim()))){
				//recalcularPredecessora
				predecessora.recalculaExcecoesDeInicioFim(log, idLog, identacao, true, predecessora, qtMovimentacao);
				//predecessora.calculaDatasInicioFim(log, idLog, identacao, DataHoraRN.subtraiSegundosDaData(predecessora.getFim(), 10));
				log.info("Recalculando datas!");
			}
		}
			
	}
}
