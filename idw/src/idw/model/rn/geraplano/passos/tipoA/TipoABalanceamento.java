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

public class TipoABalanceamento {
	public SortedMap<IdCtDTO, CtDTO> geraCpsBalanceandoMaquinas(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<IdCtDTO, CtDTO> alocacaoCTsAntecipacaoQdoDer){
		log.info(idLog, identacao, "geraCpsBalanceandoMaquinas");
		for (IdCtDTO idctdto : alocacaoCTsAntecipacaoQdoDer.keySet()){
			// Ordena da maior data de fim para a menor data de fim
			CtDTO ctdto = alocacaoCTsAntecipacaoQdoDer.get(idctdto);
			List<PassosDTO> listaordenada = ctdto.getPassosAlocados();
			
			if(listaordenada.size()<=1){
				continue;
			}
			
			Collections.sort(listaordenada, new Comparator<PassosDTO>() {
				@Override
				public int compare(PassosDTO o1, PassosDTO o2) {
					return DataHoraRN.before(o1.getInicio(), o2.getInicio()) ? -1 : (DataHoraRN.after(o1.getInicio(), o2.getInicio()) ? +1 : 0);
				}
			});
			
			log.info(idLog, identacao, "O CT " + ctdto + " esta com alocacao = " + ctdto.getTempoAlocacao());
			
			if (idctdto.getOmptEscolhido() != null && idctdto.getOmptEscolhido().getCdPt().equals("MS2")){
				log.info(idLog, identacao, "Debugar o pt " + idctdto);
			}
			
			double alocacaoTotal = ctdto.getTempoAlocacao();
			
			// Varre as CPs removendo os conflitos colocando uma das duas para um periodo anterior
			SortedMap<IdCtDTO, List<PassosDTO>> passosCandidatos = new TreeMap<IdCtDTO, List<PassosDTO>>();
			
			for (PassosDTO p : listaordenada){
				
				if (p.getOmproduto().getOmproduto().getCdProduto().equals("TP7N4G508AG-ILH")){
					log.info("DEBUG");
				}
				
				if (p.isExcluida() == false){
					for (CtDTO ctp : p.getCtsPossiveis()){
						CtDTO ctpEncontrado = alocacaoCTsAntecipacaoQdoDer.get(ctp.getId());
						if (ctpEncontrado == null){
							continue; /// se o ct nao teve alocacao entao desconsidera-lo
						}
						double alocacaoPa = ctpEncontrado.getTempoAlocacao();
						ctp.setTempoAlocacao(alocacaoPa);
						double tempoCtdto = ctdto.getTempoAlocacao() - p.getTempoEstimadoSegundos();
						//if (ctp.equals(ctdto) == false && alocacaoPa < ctdto.getTempoAlocacao()){
						if (ctp.equals(ctdto) == false && alocacaoPa < tempoCtdto){
							log.info(idLog, identacao+10, "O ctdto " + ctp + " est� subutilizado com alocao = " + alocacaoPa);
							
							if (ctpEncontrado.isExisteConflitoParaInserir(p) == false){
								log.info(idLog, identacao+10, "Novo candidato " + p);
								// Nesse caso eh possivel inserir o passo
								// Logo iremos coloca-lo na lista como um possivel candidato a ser transferido para outro CT
								List<PassosDTO> pCandidatos = null;
								if (passosCandidatos.containsKey(ctp.getId()) == true){
									pCandidatos = passosCandidatos.get(ctp.getId());
								} else {
									pCandidatos = new ArrayList<PassosDTO>();
									alocacaoTotal += alocacaoPa;
								}
								pCandidatos.add(p);
								passosCandidatos.put(ctp.getId(), pCandidatos);
								break; // sai do for dos cts evitando que o passo va para outro CT
							}
						}
					}
				}
			}

			// Analisa quais dos passos candidatos serao passados para outro CT
			// 1o: Encontra a alocacao media para os cts envolvidos
			int qtCtsEnvolvidos = passosCandidatos.size() + 1;
			
			double alocacaoMediaEsperada = alocacaoTotal / qtCtsEnvolvidos;
			
			// se o ct avaliado ja estiver abaixo da media, entao nem se preocupar com ele
			if (ctdto.getTempoAlocacao() > alocacaoMediaEsperada){
				for (IdCtDTO id : passosCandidatos.keySet()){
					// Ordena do passo mais demorado ao emnos demorado
					List<PassosDTO> listacandidatos = passosCandidatos.get(id);
					
					Collections.sort(listacandidatos, new Comparator<PassosDTO>() {
	
						@Override
						public int compare(PassosDTO o1, PassosDTO o2) {
							return (o1.getTempoEstimadoSegundos() < o2.getTempoEstimadoSegundos() ? -1 : o1.getTempoEstimadoSegundos() > o2.getTempoEstimadoSegundos() ? +1 : 0);
						}
					});
					// Interage sobre os passos para trnasferir
					for (PassosDTO pc : listacandidatos) {
						// transfere passo
						// 1o remove o passo do ct antigo
						ctdto.removerPasso(pc);
						
						// 2o localiza o ct que ira receber o novo passo
						CtDTO ctrecebedor = alocacaoCTsAntecipacaoQdoDer.get(id);
						ctrecebedor.inserirPasso(pc);
						
						// se o tempo de alocacao do ct avaliado ficar abaixo do tempo de alocacao Media entao parar com os passos e
						// passar para outro CT.
						if (ctdto.getTempoAlocacao() <= alocacaoMediaEsperada)
							break;
					}
					
				}
			} // fim do if
		}

		return alocacaoCTsAntecipacaoQdoDer;
	}
}
