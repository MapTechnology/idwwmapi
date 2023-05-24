package idw.model.rn.geraplano.passos.tipoC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpPlano;
import idw.model.rn.DataHoraRN;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.model.rn.geraplano.dtos.ProdutoComparable;
import idw.util.IdwLogger;

public class TipoCAdiantandoCPsParaAmanha {

	private DAOGenerico dao;
	
	public TipoCAdiantandoCPsParaAmanha(DAOGenerico dao) {
		super();
		this.dao = dao;
	}
	
	public SortedMap<ProdutoComparable, List<PassosDTO>> geraCpsAdiantandoParaAmanha(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<ProdutoComparable, List<PassosDTO>> cpsVirtuais){
		
		SortedMap<ProdutoComparable, List<PassosDTO>> cpsConsolidadas = new TreeMap<ProdutoComparable, List<PassosDTO>>();
		
		// Consolida a producao do produto que termina na mesma data, recalculando a data de inicio (para as predecessora tb)
		for (ProdutoComparable pr : cpsVirtuais.keySet()){
			List<PassosDTO> listaOrdenada = cpsVirtuais.get(pr);
			List<PassosDTO> listaConsolidada = new ArrayList<PassosDTO>();
			
			// Ordena pela data inicio pq o estoque deve abater as primeiras ordens
			Collections.sort(listaOrdenada, new Comparator<PassosDTO>() {
				@Override
				public int compare(PassosDTO o1, PassosDTO o2) {
					return (DataHoraRN.before(o1.getInicio(), o2.getInicio()) ? -1 : (DataHoraRN.after(o1.getInicio(), o2.getInicio()) ? +1 : 0));
				}
			});

			listaConsolidada = getListaConsolidadaComAdiantamento(log, idLog, identacao, listaOrdenada);
			
			cpsConsolidadas.put(pr, listaConsolidada);
		}
		log.info(idLog, 20, "Fim geraCpsAdiantandoParaAmanha");
		
		return cpsConsolidadas;
		
	}
	
	
	private List<PassosDTO> getListaConsolidadaComAdiantamento(IdwLogger log, int idLog, int identacao, List<PassosDTO> listaOrdenada){
		List<PassosDTO> listaConsolidada = new ArrayList<PassosDTO>();
		
		for (PassosDTO p : listaOrdenada){
			// Avalia predecessoras do passo
			if (p.getPassosPredecessoras()== null || p.getPassosPredecessoras().size() <= 0){
				p.setInicio(DataHoraRN.getDataHoraAtual());
			}
			
			listaConsolidada.add(p);
		}

		return listaConsolidada;
	}

}
