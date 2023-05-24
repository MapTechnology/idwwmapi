package idw.model.rn;

import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;

public class ResumoRetornoRegistrosRN extends AbstractRN<DAOGenerico> {
	
	public ResumoRetornoRegistrosRN() {
		this(null);
	}
	
	public ResumoRetornoRegistrosRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	@SuppressWarnings("deprecation")
	public MetaDTO getMetaDTO(FiltroPesquisaDTO filtro, MapQuery q, int totItensLista) {
		MetaDTO meta = new MetaDTO(filtro);
		
		List<Object> listaPesquisa = null;
		
 		if (totItensLista > 0) {
 			meta.setCurrentPage(filtro.getPagina());
 			meta.setItemsPerPage(filtro.getRegistrosPorPagina());
 			meta.setItemCount(totItensLista);			

			String strSQL = q.getHql().toString();
			q = new MapQuery(this.getDaoSession());
			q.append(strSQL);
	 		listaPesquisa =  q.list();
	 		meta.setTotalItems(listaPesquisa.size());
	 		
	 		if ((listaPesquisa.size() % filtro.getRegistrosPorPagina()) == 0) {
	 			meta.setTotalPages((int) (listaPesquisa.size() / filtro.getRegistrosPorPagina()));	 			 			
	 		} else {
	 			meta.setTotalPages(((int) (listaPesquisa.size()  / filtro.getRegistrosPorPagina())) + 1);	 			 
	 		}
 		}
 		
 		listaPesquisa = null;
		return meta;
	}
}
 