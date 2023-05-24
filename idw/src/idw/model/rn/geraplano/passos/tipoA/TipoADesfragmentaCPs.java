package idw.model.rn.geraplano.passos.tipoA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpPlano;
import idw.model.rn.DataHoraRN;
import idw.model.rn.TpptRN;
import idw.model.rn.geraplano.dtos.CtDTO;
import idw.model.rn.geraplano.dtos.IdCtDTO;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.util.IdwLogger;
import idw.webservices.dto.OmTpptDTO;

public class TipoADesfragmentaCPs {

	public SortedMap<IdCtDTO, CtDTO> geraCpsDesfragmentadas(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<IdCtDTO, CtDTO> listaParaProcessamento, DAOGenerico dao){
		// Inicializa vetor que recebera o resultado do processamento
		SortedMap<IdCtDTO, CtDTO> alocacaoCTsDefrag = new TreeMap<IdCtDTO, CtDTO>();
		
		TpptRN tp = new TpptRN(dao);
		OmTpptDTO listaTpPt = tp.getOmTpptDTO();
		
		for(OmTppt idTppt : listaTpPt.getListaOmTppts()){
			for (IdCtDTO idctdto : listaParaProcessamento.keySet()){
				if (idctdto.getOmptEscolhido() != null && idTppt!=null && idctdto.getOmptEscolhido().getOmTppt().getIdTppt() != idTppt.getIdTppt())
					continue;
				
				if (idctdto.getOmgtEscolhido() != null && idTppt!=null && idTppt.getIdTppt() != 13l)
					continue;
				
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
					
					if (pAnterior == null) {
						pAnterior = p;
						continue;
					}
	
					Date dtMaiorFinal = p.getMaiorDataFinalDasPredecessoras();
					Date dtInicioPrevista = pAnterior.getFim();
					Date dataAtual = new Date();
	
					// Se o passo nao tiver antecessoras e tendo, a maior data de fim delas
					if (	(DataHoraRN.before(dtInicioPrevista, dataAtual)==false) &&
							(p.isPossuiPredecessoras() == false || 
							dtMaiorFinal == null ||
							DataHoraRN.before(dtMaiorFinal, dtInicioPrevista) == true ||
							DataHoraRN.equals(dtMaiorFinal, dtInicioPrevista) == true)
						) {
						log.info(idLog, identacao, "Mudando inicio do passo " + p + " para " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtInicioPrevista));
						//p.getCtEscolhido().setHorariosIndisponiveis(ctdto.getHorariosIndisponiveis());
						p.setInicioDtInicioPrevista(dtInicioPrevista);
						p.calculaDatasFimDtInicioPrevista();
					}
	
					novaLista.add(pAnterior);
					pAnterior = p;
				}
	
				if (pAnterior != null)
					novaLista.add(pAnterior);
				
				CtDTO ctdto2 = new CtDTO(ctdto);
				ctdto2.setPassosAlocados(novaLista);
				alocacaoCTsDefrag.put(ctdto2.getId(), ctdto2);
			}
		}
		
		if((alocacaoCTsDefrag == null) ||(alocacaoCTsDefrag.size()<=0)){
			return listaParaProcessamento;
		}
		
		return alocacaoCTsDefrag;
	}
}
