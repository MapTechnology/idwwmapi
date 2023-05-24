package idw.model.rn.geraplano.passos.tipoB;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpPlano;
import idw.model.rn.DataHoraRN;
import idw.model.rn.geraplano.dtos.CtDTO;
import idw.model.rn.geraplano.dtos.IdCtDTO;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.model.rn.geraplano.dtos.ProdutoComparable;
import idw.util.IdwLogger;
import idw.webservices.dto.PlanoDTO;

public class TipoBAlocacaoEmMaquina {
	private SortedMap<IdCtDTO, CtDTO> retorno = new TreeMap<IdCtDTO, CtDTO>();
	private MapQuery q;
	private DAOGenerico dao;
	public static int _SOMENTE_CTS_EXCLUSIVOS = 1;
	public static int _SOMENTE_CTS_COM_CP = 2;
	public static int _SOMENTE_COM_MAIS_DE_UM_CT = 3;
	
	public TipoBAlocacaoEmMaquina(DAOGenerico dao){
		this.dao = dao;
	}
	
	public SortedMap<IdCtDTO, CtDTO> geraCpsAlocandoEmMaquina(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<ProdutoComparable, List<PassosDTO>> alocacaoProduto, PlanoDTO planoResultError, int tipoCt){

		// Define consulta para saber se o produto esta em maquina
		q = new MapQuery(dao.getSession());
		q.append("select ppcp");
		q.append("from PpCp ppcp");
		q.append("join fetch ppcp.ppPlano ppplano");
		q.append("join fetch ppcp.ppCpprodutos ppcpprodutos");
		q.append("join fetch ppcpprodutos.omProduto omproduto");
		q.append("where ppplano.stAtivo = 1 and ppplano.stPlano = 1"); // plano
																		// firmado
		q.append("and ? between ppcp.dthrInicio and ppcp.dthrFinal");
		q.append("and omproduto.cdProduto = :omproduto");
		q.append("and omproduto.stAtivo = 1");
		q.setMaxResults(1);

		
		// Para cada produto final, varrer a arvore das predecessoras a partir do primeiro passo
		// para tanto identificar os diveros seguimentos do roteiro
		for (ProdutoComparable p : alocacaoProduto.keySet()){
			List<PassosDTO> seguimentosDoRoteiro = alocacaoProduto.get(p);
			// Os passos listados em seguimentosDoRoteiro possuem as varias datas de entrega para o produto e esses passos
			// devem ser ordenados cronologicamente em ordem crescente pela data final, pois a data inicial pode estar inconsistente devido as quantidades
			Collections.sort(seguimentosDoRoteiro, new Comparator<PassosDTO>() {

				@Override
				public int compare(PassosDTO o1, PassosDTO o2) {
					return DataHoraRN.compareTo(o1.getFim(), o2.getFim());
				}
			});
			
			
			// Varre cada seguimento do roteiro
			for (PassosDTO seguimento : seguimentosDoRoteiro) {
				// Para cada seguimento do roteiro, varrer a quantidade maxima de passos
				for (int iPasso = 1 ; iPasso <= seguimento.getQtMaxPassos(); iPasso++){
					List<PassosDTO> passosNoNivel = seguimento.getPassosNoNivel(iPasso);
					
					for (PassosDTO passoNoNivel : passosNoNivel){
						if (passoNoNivel.getCtEscolhido() != null)
							continue;
						
						// Alocar o nivel iPasso nos CTs.
						alocarPassoEmMaquina(passoNoNivel, tipoCt);
						
						// acredito que deva recalcular o inicio e fim se baseando na predecessora do passo
						// determina predecessora com maior data final e a usa para calcular inicio e fim do passo
						PassosDTO pMaiorRef = null;
						for (PassosDTO pPredec : passoNoNivel.getPassosPredecessoras()){
							if (pMaiorRef == null){
								pMaiorRef = pPredec;
								continue;
							}
							if (DataHoraRN.after(pPredec.getFim(), pMaiorRef.getFim())){
								pMaiorRef = pPredec;
							}
						}
						if (pMaiorRef != null){
							passoNoNivel.setInicio(pMaiorRef.getFim());
							passoNoNivel.calculaDatasFim();
						}
					}
				}
			}
		}
		return retorno;
	}
	
	/*
	 * O objetivo desse metodo eh avaliar o passo e aloca-lo em maquina
	 */

	private void alocarPassoEmMaquina(PassosDTO passo, int tipoCt){
		if (passo.getOmproduto().getOmproduto().getCdProduto().equals("246613")) {
			System.out.println("deb");
		}
		// Determinar CTs disponiveis prevendo a indisponibilidade
		// 1a regra: Se tiver apenas um Ct possivel entao utiliza-lo
		if (tipoCt == _SOMENTE_CTS_EXCLUSIVOS){
			if (passo.getCtsPossiveis().size() == 1) {
				// Verifica se o Ct ja existe no retorno
				CtDTO ctEscolhido = passo.getCtsPossiveis().get(0);
				CtDTO ct = null;
				if (retorno.containsKey(ctEscolhido.getId())){
					ct = retorno.get(ctEscolhido.getId());
				} else {
					ct = ctEscolhido; // assume o auxiliar pois ainda nao existe em retorno
				}
	
				passo.setCtEscolhido(ct);
				
				if (retorno.containsKey(ct.getId()) == true) {
					ct = retorno.get(ct.getId());
				}
				ct.addPassoAlocado(passo);
				retorno.put(ct.getId(), ct);
				return;
			}
		}
		
		// 2a regra: se o produto ja estiver em maquina, usar a mesma maquina
		if (tipoCt == _SOMENTE_CTS_COM_CP){
			q.query().setTimestamp(0, DataHoraRN.getDataHoraAtual());
			q.defineParametro("omproduto", passo.getOmproduto().getOmproduto().getCdProduto());
			PpCp ppcp = (PpCp) q.uniqueResult();
			if (ppcp != null){
				// Verifica se o Ct ja existe no retorno
				CtDTO ctEscolhido = null;
				if (ppcp.getOmPt() != null){
					ctEscolhido = new CtDTO(ppcp.getOmPt());
				}
				CtDTO ct = null;
				if (retorno.containsKey(ctEscolhido.getId())){
					ct = retorno.get(ctEscolhido.getId());
				} else {
					ct = ctEscolhido; // assume o auxiliar pois ainda nao existe em retorno
				}
	
				passo.setCtEscolhido(ct);
				
				if (retorno.containsKey(ct.getId()) == true) {
					ctEscolhido = retorno.get(ct.getId());
				}
				// Se for o primeiro passo colocado no e se o CT nao tiver predecessora entao coloca-lo a partir da data e hora atual
				if (ct.getPassosAlocados() == null || ct.getPassosAlocados().isEmpty() == true){
					passo.setInicio(DataHoraRN.getDataHoraAtual());
					passo.calculaDatasFim();
				}
				ct.addPassoAlocado(passo);
				retorno.put(ct.getId(), ctEscolhido);
				return;
			}
		}		
		
		if (tipoCt == _SOMENTE_COM_MAIS_DE_UM_CT){
			// Se existe mais de um CT, entao varre os cts possiveis para escolha de um
			// O escolhido deve ser o que tiver mais tempo disponivel
			// o tempo disponivel eh o tempo total - alocado, onde tempo total leva em conta as indisponibilidades
			CtDTO ctMaiorTempoDisponivel = null;
			for (CtDTO ctAux : passo.getCtsPossiveisOrdenandoPeloCiclo()) {
				// Utilizar o CT que ja esta em retorno pois ele tera o tempo alocado. Os ctspossiveis o tempo alocado sera sempre 0
				CtDTO ct = null;
				if (retorno.containsKey(ctAux.getId())){
					ct = retorno.get(ctAux.getId());
				} else {
					ct = ctAux; // assume o auxiliar pois ainda nao existe em retorno
				}
				if (ctMaiorTempoDisponivel == null){
					ctMaiorTempoDisponivel = ct;
					continue;
				}
				if (ct.getTempoAlocacao() < ctMaiorTempoDisponivel.getTempoAlocacao()){
					ctMaiorTempoDisponivel = ct;
				}
			}
			
			passo.setCtEscolhido(ctMaiorTempoDisponivel);

			if (ctMaiorTempoDisponivel != null) {
				if (retorno.containsKey(ctMaiorTempoDisponivel.getId()) == true) {
					ctMaiorTempoDisponivel = retorno.get(ctMaiorTempoDisponivel.getId());
				}
				// Se for o primeiro passo colocado no e se o CT nao tiver predecessora entao coloca-lo a partir da data e hora atual
				if (ctMaiorTempoDisponivel.getPassosAlocados() == null || ctMaiorTempoDisponivel.getPassosAlocados().isEmpty() == true){
					passo.setInicio(DataHoraRN.getDataHoraAtual());
					passo.calculaDatasFim();
				} else {
					// Se ja existir passos alocados, pegar a maio data de fim e usa-la como referencia para esse passo
					Date dthrFMaior = null;
					for (PassosDTO pdto : ctMaiorTempoDisponivel.getPassosAlocados()) {
						if (dthrFMaior == null)
							dthrFMaior = pdto.getFim();
						if (DataHoraRN.after(pdto.getFim(), dthrFMaior))
							dthrFMaior = pdto.getFim();
					}
					passo.setInicio(dthrFMaior);
					passo.calculaDatasFim();
				}

				ctMaiorTempoDisponivel.addPassoAlocado(passo);
				retorno.put(ctMaiorTempoDisponivel.getId(), ctMaiorTempoDisponivel);
			}
		}
	}
}
