package idw.model.rn.geraplano.passos.tipoA;

import java.math.BigDecimal;
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
import idw.model.rn.geraplano.dtos.ProdutoComparable;
import idw.util.IdwLogger;
import idw.webservices.dto.PlanoDTO;

public class TipoAAlocacaoEmMaquina {
	// Esse map contem o CT que primeiro foi escolhido para o produto, a ideia eh utilizar o mesmo CT caso o produto tenhas 
	// nova necessidade
	private SortedMap<ProdutoComparable, CtDTO> primeiraAlocacaoEmCTParaOProduto = new TreeMap<ProdutoComparable, CtDTO>();
	
	
	public SortedMap<IdCtDTO, CtDTO> geraCpsAlocandoEmMaquina(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<ProdutoComparable, List<PassosDTO>> alocacaoProduto, PlanoDTO planoResultError){

		SortedMap<IdCtDTO, CtDTO> alocacaoCTs = new TreeMap<IdCtDTO, CtDTO>();
		
		// Ordena os produtos pelo maior tempo estimado ao menor
		List<ProdutoComparable> listaProduto = null;

		listaProduto = new ArrayList<ProdutoComparable>(alocacaoProduto.keySet());
		
		Collections.sort(listaProduto, new Comparator<ProdutoComparable>() {

			@Override
			public int compare(ProdutoComparable o1, ProdutoComparable o2) {
				return (o1.getOmproduto().obtemTmpEstimado() < o2.getOmproduto().obtemTmpEstimado() ? +1 : o1.getOmproduto().obtemTmpEstimado() > o2.getOmproduto().obtemTmpEstimado() ? -1 : 0);
			}
		});
		
		for (ProdutoComparable p : listaProduto){
			if (p.getOmproduto().getCdProduto().equals("922381"))
				log.info(idLog, identacao, "Descobrindo pq o produto " + p.getOmproduto().getCdProduto() + " foi para CT nao possivel");
			
			List<PassosDTO> listaOrdenada = alocacaoProduto.get(p);
			
			// Ordem decrescente por data final
			Collections.sort(listaOrdenada, new Comparator<PassosDTO>() {
				@Override
				public int compare(PassosDTO o1, PassosDTO o2) {
					return (DataHoraRN.before(o1.getFim(), o2.getFim()) ? +1 : (DataHoraRN.after(o1.getFim(), o2.getFim()) ? -1 : 0));
				}
			});
			log.info(idLog, identacao, "Alocando maquinas para o produto " + p);
			
			// Varre as necessidade por ordem cronologia (dtfim) decrescente
			for (PassosDTO pa : listaOrdenada){
				
				if ((pa.getCtsPossiveisOrdenandoPeloCiclo().size()>1)||(pa.getCtsPossiveisOrdenandoPeloCiclo().size() == 0)){
					log.info(pa.getOmproduto().getOmproduto().getCdProduto());
				}
				
				log.info(idLog, identacao, "Escolhendo o ct para o passo " + pa);
				
				// A escolha do CT para o passo escolhe tb o CT para as predecessoras
				CtDTO ctEscolhido = escolherCtParaACP(log, idLog, identacao, pa, alocacaoCTs);

				log.info(idLog, identacao, "CT escolhido foi o " + ctEscolhido);
				
				// No metodo escolherCtParaACP o CT ja eh armazenado no ctEscolhido do pa
				
				try{
					@SuppressWarnings("unused")
					BigDecimal ciclo= pa.getCicloPadrao();					
				}catch (Exception e) {
					planoResultError.setMensagem(pa.getDwfolha().getCdFolha());
					planoResultError.getResultadoDTO().setIdmensagem(planoResultError.getResultadoDTO().getERROR_CICLO_PADRAO());
					return null;
				}
				try {
				log.info(idLog, identacao, "O tempo alocado do CT escolhido saiu de " + ctEscolhido.getTempoAlocacao() + " e foi para " + pa.getTempoEstimadoSegundos());
				} catch (NullPointerException e){
					log.debug("");
				}
				// Adiciona a CP ao CT escolhido
				CtDTO ctdtoRecuperado = null;
				if (alocacaoCTs != alocacaoCTs && alocacaoCTs.containsKey(ctEscolhido.getId()) == true){
					ctdtoRecuperado = alocacaoCTs.get(ctEscolhido.getId());
				} else {
					ctdtoRecuperado = ctEscolhido;
				}
				
				// Recalcula usando o CT escolhido como referencia de ciclo padrao
				// todo definir o ciclo padrao real para o recalculo abaixo
				pa.calculaDatasInicioFim(log, idLog, identacao, pa.getFim()); // o false nao foi passado pois as datas das predecessoras devem ser recalculadas, apenas no proximo passo que removerosconflitos nao devemos considerar o recalculo das predecessoras

				if (ctdtoRecuperado != null && ctdtoRecuperado.getPassosAlocados() != null) {
					ctdtoRecuperado.getPassosAlocados().add(pa);
					ctdtoRecuperado.addTempoAlocacao(pa.getTempoEstimadoSegundos());
					alocacaoCTs.put(ctEscolhido.getId(), ctdtoRecuperado);
				}
				
			}
		}
		return alocacaoCTs;
		
	}
	
	/* O objetivo desse metodo eh escolher o CT para o passo e suas predecessoras
	 */ /*
	private CtDTO escolherCtParaACP(IdwLogger log, int idLog, int identacao, PassosDTO pa, SortedMap<IdCtDTO, CtDTO> alocacaoCTs){
		// Os CTs das predecessras tb devem ser escolhidos em recursividade
		CtDTO retorno = null;
		
		// se o passo ja tiver um ct escolhido anteriormente, usa-lo
		if (pa.getCtEscolhido() != null) {
			retorno = pa.getCtEscolhido();
			log.info(idLog, identacao, "Reutilizando o CT escolhido " + retorno);
		} else {
			// Verifica se o produto j� foi alocado em alguma maquina, se sim, usar o mesmo CT para continuar prduzindo nele
			if (this.primeiraAlocacaoEmCTParaOProduto.containsKey(pa.getOmproduto())){
				retorno = this.primeiraAlocacaoEmCTParaOProduto.get(pa.getOmproduto());
				log.info(idLog, identacao, "Reutilizando CT do produto " + retorno);
			}
		}

		// Se CT ainda nao escolhido e o passo nao possuir predecessoras espelho
		boolean isCtDaPredecessoraDefinido = false;
		CtDTO ctPredecessoraEscolhido = null;
		if (retorno == null && pa.isPossuiPredecessoraEspelho() == false){
			// Verificar se o passo � o ultimo do roteiro e se eh para o SMD
			if (pa.isEoUltimoDoRoteiro() == true) {
				// Verifica se o passo eh para a SMD
				if (pa.isParaSMD() == true){
					// Verificar se a predecessora tb eh para o SMD
					if (pa.isPredecessorasParaSMD() == true){
						// verificar se os cts possiveis do PA sao mais de um
						if (pa.getCtsPossiveis().size() > 1) {
							// Verificar se os Cts Possiveis do pa sao os mesmos cts possiveis de sua predecessora
							if (pa.isPredecessorasImediatasSaoParaOMesmosCts() == true) {
								// Ordenar os cts possiveis pela descricao
								// O passo pa sera no ultimo CT
								retorno = pa.getCtsPossiveisUltimoCTOrdenadoAlfa();
								
								// E a predecessora sera o CT imediatamente anterior
								ctPredecessoraEscolhido = pa.getCtsPossiveisPenultimoCTOrdenadoAlfa();
								isCtDaPredecessoraDefinido = true;
							}
						}						
					}
				}
			}
		}
		
		// Se ainda o CT nao foi definido, escolher o ct menos usado, tomando como base o tempo j� alocado do ct
		if (retorno == null) {
			retorno = escolherCtMenosAlocado(log, idLog, identacao, pa, alocacaoCTs);
			log.info(idLog, identacao, "Utilizando CT menos alocado " + retorno);
		}

		// Seta o ct escolhido no passo
		pa.setCtEscolhido(retorno);

		// Se eh a 1a vez que o produto eh alocado a um CT, guardar essa informacao
		if (this.primeiraAlocacaoEmCTParaOProduto.containsKey(pa.getOmproduto()) == false){
			this.primeiraAlocacaoEmCTParaOProduto.put(pa.getOmproduto(), retorno);
		}
		
		// Escolhe os cts para as predecessoras
		for (PassosDTO passoPredecessor : pa.getPassosPredecessoras()){
			// Nesse momento pode ocorrer que uma predecessora nao tenha producao planejada
			// isso pq a producao foi zerada qdo o estoque foi abatido
			// Nesse caso deve-se ignorar o passo
			if (passoPredecessor.getProducaoPlanejada() <= 0d){
				log.info(idLog, identacao, "Producao planejada zerada. Descartando escolha do CT para a predecessora.");
				continue;
			}
			
			if (passoPredecessor.isEspelho() == true) {// se a predecessora for uma espelho, entao deve-se usar o mesmo ct
				passoPredecessor.setCtEscolhido(retorno);
				log.info(idLog, identacao, "O passo predecessor eh espelho, assumindo o mesmo CT do pai");
			}
			
			if (isCtDaPredecessoraDefinido == true && ctPredecessoraEscolhido != null) {
				passoPredecessor.setCtEscolhido(ctPredecessoraEscolhido);
			}
			
			// chama novamente o escolherCtParaACP a fim de definir os ct das predecessoras dessa predecessora
			CtDTO ctEscolhido = escolherCtParaACP(log, idLog, identacao, passoPredecessor, alocacaoCTs);
			
			
			// Adiciona a CP ao CT escolhido
			CtDTO ctdtoRecuperado = null;
			if (alocacaoCTs.containsKey(ctEscolhido.getId()) == true){
				ctdtoRecuperado = alocacaoCTs.get(ctEscolhido.getId());
			} else {
				ctdtoRecuperado = ctEscolhido;
			}
			ctdtoRecuperado.getPassosAlocados().add(passoPredecessor);
			// Recalcula usando o CT escolhido como referencia de ciclo padrao
			// todo definir o ciclo padrao real para o recalculo abaixo
			ctdtoRecuperado.addTempoAlocacao(passoPredecessor.getTempoEstimadoSegundos());
			
			alocacaoCTs.put(ctEscolhido.getId(), ctdtoRecuperado);
		}
		return retorno;
	}
*/
	
	private CtDTO escolherCtParaACP(IdwLogger log, int idLog, int identacao, PassosDTO pa, SortedMap<IdCtDTO, CtDTO> alocacaoCTs){
		// Os CTs das predecessras tb devem ser escolhidos em recursividade
		CtDTO retorno = null;
		
		if (pa.getOmproduto().getOmproduto().getCdProduto().equals("445409"))
			log.info(idLog, identacao, "Debug");
		
		retorno = escolherCtMenosAlocado(log, idLog, identacao, pa, alocacaoCTs);
		log.info(idLog, identacao, "Utilizando CT menos alocado " + retorno);

		// Seta o ct escolhido no passo
		pa.setCtEscolhido(retorno);


		// Escolhe os cts para as predecessoras
		for (PassosDTO passoPredecessor : pa.getPassosPredecessoras()){
			// Nesse momento pode ocorrer que uma predecessora nao tenha producao planejada
			// isso pq a producao foi zerada qdo o estoque foi abatido
			// Nesse caso deve-se ignorar o passo
			if (passoPredecessor.getProducaoPlanejada() <= 0d){
				log.info(idLog, identacao, "Producao planejada zerada. Descartando escolha do CT para a predecessora.");
				continue;
			}
			
			if (passoPredecessor.isEspelho() == true) {// se a predecessora for uma espelho, entao deve-se usar o mesmo ct
				passoPredecessor.setCtEscolhido(retorno);
				log.info(idLog, identacao, "O passo predecessor eh espelho, assumindo o mesmo CT do pai");
			}
			
			// chama novamente o escolherCtParaACP a fim de definir os ct das predecessoras dessa predecessora
			CtDTO ctEscolhido = escolherCtParaACP(log, idLog, identacao, passoPredecessor, alocacaoCTs);
			
			
			// Adiciona a CP ao CT escolhido
			CtDTO ctdtoRecuperado = null;
			try {
				if ((ctEscolhido!=null)&&(alocacaoCTs.containsKey(ctEscolhido.getId()) == true)){
					ctdtoRecuperado = alocacaoCTs.get(ctEscolhido.getId());
				} else {
					ctdtoRecuperado = ctEscolhido;
				}
			} catch (NullPointerException e){
				log.info(idLog, identacao, "Debug");
			}
	
			ctdtoRecuperado.getPassosAlocados().add(passoPredecessor);
			// Recalcula usando o CT escolhido como referencia de ciclo padrao
			// todo definir o ciclo padrao real para o recalculo abaixo
			ctdtoRecuperado.addTempoAlocacao(passoPredecessor.getTempoEstimadoSegundos());
			
			alocacaoCTs.put(ctEscolhido.getId(), ctdtoRecuperado);
		}
		
		if (retorno == null)
			log.info(idLog, identacao, "debug");
		

		return retorno;
	}

	/*.
	 * Metodo de apoio para se escolher o CT menos utilizado
	 */
	private CtDTO escolherCtMenosAlocado(IdwLogger log, int idLog, int identacao, PassosDTO pa, SortedMap<IdCtDTO, CtDTO> alocacaoCTs){

		CtDTO retorno = null;

		if (pa.getCtsPossiveisOrdenandoPeloCiclo() == null || pa.getCtsPossiveisOrdenandoPeloCiclo().isEmpty() == true)
			log.debug("");
		
		for (CtDTO ct : pa.getCtsPossiveisOrdenandoPeloCiclo()){
			// Recupera a alocacao dos CTs para o ct avaliado
			if((//ct.toString().equals("Gt SMD_L1") || 
					//ct.toString().equals("Gt SMD_L2") || 
					ct.toString().equals("Gt SMD_L3") //|| 
					//ct.toString().equals("Gt SMD_L4") || 
					//ct.toString().equals("Gt SMD_L5") || 
				//	ct.toString().equals("Gt SMD_L6")
					)&&
					(pa.getCtsPossiveisOrdenandoPeloCiclo().size()>1) ){
				log.info(ct.toString());
			}
			
			CtDTO ctRecuperado = null;
			if (alocacaoCTs.containsKey(ct.getId())){
				ctRecuperado = alocacaoCTs.get(ct.getId());
				ct.setTempoAlocacao(ctRecuperado.getTempoAlocacao());
			}
			if (retorno == null) {
				retorno = ct;
				log.info(idLog, identacao, "Assumindo o 1o CT " + ct);
			} else if (ct.getTempoAlocacao() < retorno.getTempoAlocacao()) {
				log.info(idLog, identacao, "Foi escolhido o CT " + ct + " com o tempo de alocacao em " + ct.getTempoAlocacao() + " em substituicao ao CT " + retorno + " com tempo de alocacao em " + retorno.getTempoAlocacao());
				retorno = ct;
			} else
				log.info(idLog, identacao, "NAO Foi escolhido o CT " + ct + " com o tempo de alocacao em " + ct.getTempoAlocacao() + " em substituicao ao CT " + retorno + " com tempo de alocacao em " + retorno.getTempoAlocacao());

		}
		
		return retorno;
	}
}
