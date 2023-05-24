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

public class TipoAAntecipaSeDer {
	/*
	 * Esse metodo tem como objetivo antecipar a OP nas seguintes situacoes
	 * 
	 */
	public SortedMap<IdCtDTO, CtDTO> geraCpsAntecipandoQuandoDer(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<IdCtDTO, CtDTO> listaParaProcessamento){
		log.info(idLog, identacao, "geraCpsAntecipandoQuandoDer");
		// Inicializa  o vetor que ira receber o valor do processamento
		SortedMap<IdCtDTO, CtDTO> alocacaoCTsAntecipacaoQdoDer =  new TreeMap<IdCtDTO, CtDTO>();
		
		// Ordenar a lista de maquinas para a seguinte ordem
		// 1o - Ilhoes
		// 2o - Jumpers
		// 3o - Axiais
		// 4o - Radiais
		// 5o - SMDs
		// Assim, pode-se antecipar as que tem predecessoras mas com data final inferior a antecipacao
		
		for (IdCtDTO idctdto : listaParaProcessamento.keySet()){
			// Ordena da maior data de fim para a menor data de fim
			CtDTO ctdto = listaParaProcessamento.get(idctdto);
			List<PassosDTO> listaordenada = ctdto.getPassosAlocados();
			Collections.sort(listaordenada, new Comparator<PassosDTO>() {
				@Override
				public int compare(PassosDTO o1, PassosDTO o2) {
					return DataHoraRN.before(o1.getInicio(), o2.getInicio()) ? -1 : (DataHoraRN.after(o1.getInicio(), o2.getInicio()) ? +1 : 0);
				}
			});
			
			// Varre as CPs removendo os conflitos colocando uma das duas para um periodo anterior
			PassosDTO pAnterior = null;
			log.info(idLog, identacao, ctdto + " - Antecipando quando der para o CT");
			List<PassosDTO> novaLista = new ArrayList<PassosDTO>();

			// If abaixo para teste, nao vou adiantar qdo der para as SMDs.
			if (idctdto.toString().indexOf("SMD") > 0) {
				alocacaoCTsAntecipacaoQdoDer.put(ctdto.getId(), ctdto);
				continue;
			}
			

			for (PassosDTO p : listaordenada){
				if (p.getOmproduto().getOmproduto().getCdProduto().equals("TP7N4G508AG-ILH")){
					log.info("DEBUG");
				}
				// Se o passo estiver excluido ou for do mesmo produto do passo anterior, entao pegar o proximo passo
				// A questao do mesmo produto do passo anterior eh pq pode acontecer do produto anterior se o X
				// o proximo passo estar excluido e o passo seguinte tb ser o produto X. Nesse caso o tempo transcorrido
				// ficara errado, visto que essse passo naturalmente ser� incorporado no passo anterior
				if (p.isExcluida() == true){
					// Pode ocorrer do p ser o ultimo registro em avaliacao, nesse caso devemos guardar seu valor
					// e apos o for, se o pAnterior for do mesmo produto do ultimoPasso
					// entao concaternar os dois passos em um
					continue;
				}

				// O passo anterior eh necessario para se descobrir quanto tempo disponivel existe entre o passo anterior e o passo seguinte
				// pois nesse tempo que se ir� adiantar ou nao a producao
				if (pAnterior != null) {

					if (pAnterior.getOmproduto().getOmproduto().getCdProduto().equals("RENX0886CZ-AXI"))
						log.info(idLog, identacao, "Avaliar antecipacao para o passo " + pAnterior);

					
					double tempoDisponivel = DataHoraRN.getQuantidadeSegundosNoPeriodo(pAnterior.getFim(), p.getInicio());
					List<PassosDTO> passosASeremAntecipados = getPassosASeremAntecipados(log, idLog, identacao+20, listaordenada, pAnterior);
					log.info(idLog, identacao+10, "Tempo disponivel = " + tempoDisponivel + "s. ate o passo " + p);
					for (PassosDTO pA : passosASeremAntecipados){
						if (pA.getTempoEstimadoSegundos() <= tempoDisponivel || pA == p){ // Se pA == p siginica que o passo seguinte ao pAnterior eh do mesmo produto
							
							if (pA.getOmproduto().getOmproduto().getCdProduto().equals("TP7NA5361AG-ILH"))
								log.info(idLog, identacao+10, "Antecipando com o passo " + pA);
							
							// Entao antecipa o passo
							pAnterior.acumulaPassosSemPredecessoras(pA);
							pAnterior.calculaDatasFim();

							pA.setExcluida(true);
							pA.setPassoAoQualFoiVinculad(pAnterior);
							
							tempoDisponivel -= pA.getTempoEstimadoSegundos();
						} else {
							log.info(idLog, identacao+10, "O passo com tempo est " + pA.getTempoEstimadoSegundos() + " eh maior que " + tempoDisponivel);
						}
					}
					novaLista.add(pAnterior);
				}
				
				// o p pode estar excluida no passo acima, isso ocorre qdo o pAnterior == ao mesmo produto do p, incorporando assim
				// o p no pAnterior, qdo isso ocorre o pAnterior deve ser nulo para se obter um proximo registro para avaliacao
				if (p.isExcluida() == false) {
					pAnterior = p;
					if (pAnterior.getOmproduto().getOmproduto().getCdProduto().equals("TP7NA5361AG-ILH"))
						log.info(idLog, identacao+5, "Avaliando o passo anterior " + pAnterior);
				} else
					pAnterior = null;
				
			} // fim do loop

			// se panterior tiver conteudo eh pq ainda nao foi inserido na lista
			// isso ira acontecer para o ultimo passo avaliado
			if (pAnterior != null) {
				novaLista.add(pAnterior);
			}
			CtDTO ctdto2 = new CtDTO(ctdto);
			ctdto2.setPassosAlocados(novaLista);
			alocacaoCTsAntecipacaoQdoDer.put(ctdto2.getId(), ctdto2);

		}
		
		return alocacaoCTsAntecipacaoQdoDer;
	}

	private List<PassosDTO> getPassosASeremAntecipados(IdwLogger log, int idLog, int identacao, List<PassosDTO> lista, PassosDTO passo){
		List<PassosDTO> retorno = new ArrayList<PassosDTO>();
		boolean isEncontrouPasso = false;
		for (PassosDTO p : lista){
			if (p.isExcluida() == true){
				log.info(idLog, identacao, "Nao considerando (ta excluido) o passo " + p);
				continue;
			}
			
			if (isEncontrouPasso == true){
				if (p.getOmproduto().getOmproduto().getIdProduto() == passo.getOmproduto().getOmproduto().getIdProduto() && p.getPassosPredecessoras().size() <= 0){
					retorno.add(p);
					log.info(idLog, identacao, "Considerando o passo " + p);
				}
			}
			if (p == passo) {
				isEncontrouPasso = true;
				log.info(idLog, identacao, "Encontrou correspondente para o passo " + p);
			}
			
		}
		return retorno;
	}
}
