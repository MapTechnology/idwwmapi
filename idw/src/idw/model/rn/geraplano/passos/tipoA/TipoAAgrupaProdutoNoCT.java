package idw.model.rn.geraplano.passos.tipoA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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

public class TipoAAgrupaProdutoNoCT {
	/*
	 * O objetivo desse metodo é unir o passo atual ao proximo passo quando os mesmos forem para o mesmo produto
	 * e o proximo passo puder ser antecipado (caso as predecessoras deixem)
	 */
	public SortedMap<IdCtDTO, CtDTO> geraCpsAgrupandoProdutosQdoDer(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<IdCtDTO, CtDTO> listaParaProcessamento){
		log.info(idLog, identacao, "geraCpsAgrupandoProdutosQdoDer");
		// Inicializa vetor que recebera o resultado do processamento
		SortedMap<IdCtDTO, CtDTO> alocacaoCTsDefrag = new TreeMap<IdCtDTO, CtDTO>();
		
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

			PassosDTO pAnterior = null;
			log.info(idLog, identacao, "Removendo conflito para o CT " + ctdto);
			List<PassosDTO> novaLista = new ArrayList<PassosDTO>();
			
			for (PassosDTO p : listaordenada){
				if (p.getOmproduto().getOmproduto().getCdProduto().equals("TP7N4G508AG-ILH")){
					log.info("DEBUG");
				}
				
				if (p.isExcluida() == true)
					continue;
				
				if (pAnterior == null)
					pAnterior = p;
				else {
					if (p.getOmproduto().getOmproduto().getIdProduto() == pAnterior.getOmproduto().getOmproduto().getIdProduto()){
						// Mesmo que os produtos sejam os mesmos, nao devemos unir se as predecessoras terminarem em uma data posterior ao necessario para o passo
						Date dtMaiorFinal = p.getMaiorDataFinalDasPredecessoras();
						Date dtInicioPrevista = pAnterior.getFim();
						
						if (dtMaiorFinal == null || DataHoraRN.before(dtMaiorFinal, dtInicioPrevista) == true) {
							// Unir a CP atual com a CP anterior
							pAnterior.acumulaPassosSemPredecessoras(p);
							pAnterior.calculaDatasFim();
							
							// A CP atual deixa de existir
							p.setExcluida(true);
							p.setPassoAoQualFoiVinculad(pAnterior);
							
							// A cpAnterior continua a mesma
						} else {
							novaLista.add(pAnterior);
							pAnterior = p;
						}
					} else {
						novaLista.add(pAnterior);
						pAnterior = p;
					}
				}
			}
			if (pAnterior != null)
				novaLista.add(pAnterior);
			
			// sera necessario jogar novamente a lista para o SortedMap? avaliar...NAO eh necessario jogar para o map novamente.
			CtDTO ctdto2 = new CtDTO(ctdto);
			ctdto2.setPassosAlocados(novaLista);
			alocacaoCTsDefrag.put(ctdto2.getId(), ctdto2);
		}
		
		return alocacaoCTsDefrag;
	}
}
