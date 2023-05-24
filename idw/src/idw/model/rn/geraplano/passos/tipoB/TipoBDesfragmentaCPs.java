package idw.model.rn.geraplano.passos.tipoB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpPlano;
import idw.model.rn.DataHoraRN;
import idw.model.rn.geraplano.dtos.CtDTO;
import idw.model.rn.geraplano.dtos.IdCtDTO;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.util.IdwLogger;

public class TipoBDesfragmentaCPs {

	/*
	 * O objetivo desse metodo eh remover os espacos em branco entre as ordens
	 * de producao quando der. Dará quando a predecessora tiver em uma data
	 * inferior a data se a ordem for antecipada. Se a ordem for atrasada netao
	 * nao tera problema
	 */
	public SortedMap<IdCtDTO, CtDTO> geraCpsDesfragmentadas(IdwLogger log,
			int idLog, int identacao, PpPlano ppplano, OmUsr omusr,
			SortedMap<IdCtDTO, CtDTO> listaParaProcessamento, DAOGenerico dao) {
		// Inicializa vetor que recebera o resultado do processamento
		SortedMap<IdCtDTO, CtDTO> alocacaoCTsDefrag = new TreeMap<IdCtDTO, CtDTO>();

		for (IdCtDTO idctdto : listaParaProcessamento.keySet()) {
			if (idctdto.getOmptEscolhido().getCdPt().equals("L8A"))
				log.trace(idLog, identacao, "Debugando");
			
			// Ordena cronologicamente pelo inicio da ordem
			CtDTO ctdto = listaParaProcessamento.get(idctdto);
			List<PassosDTO> listaordenada = ctdto.getPassosAlocados();
			Collections.sort(listaordenada, new Comparator<PassosDTO>() {
				@Override
				public int compare(PassosDTO o1, PassosDTO o2) {
					return DataHoraRN.compareTo(o1.getInicio(), o2.getInicio());
				}
			});

			PassosDTO pAnterior = null;
			log.info(idLog, identacao, "Removendo conflito para o CT " + ctdto);
			List<PassosDTO> novaLista = new ArrayList<PassosDTO>();

			for (PassosDTO p : listaordenada) {

				if (p.isExcluida() == true)
					continue;

				if (pAnterior == null) {
					pAnterior = p;
					continue;
				}

				Date dtMaiorFinal = p.getMaiorDataFinalDasPredecessoras();
				Date dtInicioPrevista = pAnterior.getFim();
				Date dataAtual = new Date();

				if (DataHoraRN.equals(p.getInicio(), p.getFim()))
					log.trace(idLog, identacao, "deb");

				// Se o passo nao tiver predecessoras e tendo, a maior data de
				// fim delas for anterior a data prevista de inicio
				if (DataHoraRN.before(p.getInicio(), dtInicioPrevista) == true) {
					log.info(idLog, identacao, p);
					p.setInicio(dtInicioPrevista);
					p.calculaDatasFim();
					log.info(idLog, identacao, p);
				}
				if (DataHoraRN.equals(p.getInicio(), p.getFim()))
					log.trace(idLog, identacao, "deb");
				
				novaLista.add(pAnterior);
				pAnterior = p;
			}

			if (pAnterior != null)
				novaLista.add(pAnterior);

			CtDTO ctdto2 = new CtDTO(ctdto);
			ctdto2.setPassosAlocados(novaLista);
			alocacaoCTsDefrag.put(ctdto2.getId(), ctdto2);
		}

		if ((alocacaoCTsDefrag == null) || (alocacaoCTsDefrag.size() <= 0)) {
			return listaParaProcessamento;
		}
		return alocacaoCTsDefrag;
	}
}
