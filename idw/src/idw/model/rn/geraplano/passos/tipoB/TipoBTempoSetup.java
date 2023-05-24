package idw.model.rn.geraplano.passos.tipoB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import idw.model.pojos.DwFolhasetup;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpPlano;
import idw.model.rn.DataHoraRN;
import idw.model.rn.geraplano.dtos.CtDTO;
import idw.model.rn.geraplano.dtos.IdCtDTO;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.util.IdwLogger;

public class TipoBTempoSetup {
	/*
	 * Esse metodo tem como objetivo acrescentar o tempo de setup para as cps que serao salvas
	 * 
	 */
	public SortedMap<IdCtDTO, CtDTO> geraCpsIncluindoTempoSetup(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<IdCtDTO, CtDTO> listaParaProcessamento){
		// Inicializa  o vetor que ira receber o valor do processamento
		SortedMap<IdCtDTO, CtDTO> alocacaoCTcomTempoSetup =  new TreeMap<IdCtDTO, CtDTO>();
		
		for (IdCtDTO idctdto : listaParaProcessamento.keySet()){
			// Ordena da maior data de fim para a menor data de fim
			CtDTO ctdto = listaParaProcessamento.get(idctdto);
			
			if (idctdto.getOmptEscolhido() != null && idctdto.getOmptEscolhido().getCdPt().equals("MS2")){
				log.info(idLog, identacao, "Debugar o pt " + idctdto);
			}
			
			List<PassosDTO> listaordenada = ctdto.getPassosAlocados();
			Collections.sort(listaordenada, new Comparator<PassosDTO>() {
				@Override
				public int compare(PassosDTO o1, PassosDTO o2) {
					return DataHoraRN.before(o1.getInicio(), o2.getInicio()) ? -1 : (DataHoraRN.after(o1.getInicio(), o2.getInicio()) ? +1 : 0);
				}
			});
			
			// Varre as CPs para inclusao do tempo de setup
			PassosDTO pAnterior = null;// como o loop ira interagir do ultimo passo para o primeiro. pProximo sera o passo seguinte ao passo corrente
			log.info(idLog, identacao, "Setup para o CT " + ctdto);
			List<PassosDTO> novaLista = new ArrayList<PassosDTO>();

			int i=0;
			for (PassosDTO p : listaordenada){
				
				if (p.getOmproduto().getOmproduto().getCdProduto().equals("922522")){
					log.info("DEBUG");
				}
				
				// se o passo estiver excluido ignora-lo
				if (p.isExcluida() == true)
					continue;
				
				if (p.getOmproduto().getOmproduto().getCdProduto().equals("1RE1TG1381LB-CO") || p.getOmproduto().getOmproduto().getCdProduto().equals("1RH1TG1381LB-IA"))
					log.info(idLog, identacao, "debugar " + i + " passo " + p);
				
				i++;
				
				// Verifica se existe um tempo de setup especializado entre o passo e o passoProximo
				// Se nao existir usar o tempo definido na folha
				// Se nao existir tempo na folha usar 30min
				DwFolhasetup dwfolhasetup = null;
				// Se houver um passo anterior entao verificar se existe especializacao do tempo de setup
				if (pAnterior != null){
					for (DwFolhasetup dfs : p.getDwfolha().getDwFolhasetupsForIdFolhasaindo()){
						log.info(idLog, identacao, "Folha entrando " + p.getDwfolha().getCdFolha() + " tem a folha saindo " + pAnterior.getDwfolha().getCdFolha() + " = � folhasetup -> " + dfs.getDwFolhaByIdFolhaentrando().getCdFolha());
						if (dfs.getDwFolhaByIdFolhaentrando().getIdFolha() == pAnterior.getDwfolha().getIdFolha()){
							dwfolhasetup = dfs;
							break;
						}
					}
				}
				
				// Calcula o provavel tempo de setup
				double segTempoSetup = 0d;
				if (dwfolhasetup != null)
					segTempoSetup = dwfolhasetup.getSegSetup().doubleValue();
				else if (p.getDwfolha().getSegSetup() != null && p.getDwfolha().getSegSetup() > 0)
					segTempoSetup = p.getDwfolha().getSegSetup();
				
				// Se existe passo anterior e eh um espelho entao zerar o setup
				if (pAnterior != null && pAnterior.isEspelho() == true)
					segTempoSetup = 0d;
				
				
				// se o passo anterior for null entao inicializa-lo
				/*if (pAnterior == null){
					segTempoSetup = 0d;
					//if (segTempoSetup == 0d)
						//segTempoSetup = (30 * 60); // 30 minutos em segundos
				}*/

				// Acrescenta ao passo o tempo de setup
				log.info(idLog, identacao, "Definindo o tempo de setup " + segTempoSetup + " para o passo " + p);
				p.setSegTempoSetup(segTempoSetup);
				p.calculaDatasInicioFim(log, idLog, identacao, p.getFim());
				novaLista.add(p);

				pAnterior = p;

			} // fim do loop

			CtDTO ctdto2 = new CtDTO(ctdto);
			ctdto2.setPassosAlocados(novaLista);
			alocacaoCTcomTempoSetup.put(ctdto2.getId(), ctdto2);

		}
		return alocacaoCTcomTempoSetup;
	}
}
