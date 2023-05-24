package idw.model.rn;
import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.TeTarifasemanal;
import idw.webservices.dto.TeTarifasemanaisDTO;
import idw.webservices.dto.TeTarifasemanalDTO;

/**
 *
 * @author amaury
 *
 */
public class TarifasemanalRN extends AbstractRN<DAOGenerico> {

	public TarifasemanalRN () {
		this(null);
	}
	public TarifasemanalRN (DAOGenerico dao) {
		super(dao);
		if(dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}


	@SuppressWarnings("unchecked")
	public TeTarifasemanaisDTO getTeTarifasemanais (TeTarifasemanal filtro) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t");
		q.append("from TeTarifasemanal t");
		q.append("where 1=1");
		/*Não existe filtro porque todas as tarifas semanais estarão associadas
		 * a uma Ãºnica tarifa principal */
		List<TeTarifasemanal> listaPesquisa = null;
		try {
			listaPesquisa = q.query().list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<TeTarifasemanalDTO> lista = new ArrayList<TeTarifasemanalDTO>();
		if(listaPesquisa!=null) {
			for(TeTarifasemanal item : listaPesquisa) {
				TeTarifasemanalDTO  teTarifasemanalDTO = new TeTarifasemanalDTO();
				teTarifasemanalDTO.setTeTarifasemanal(item.clone());
				lista.add(teTarifasemanalDTO);
			}
		}
		TeTarifasemanaisDTO listaRetorno = new TeTarifasemanaisDTO();
		listaRetorno.setListaTeTarifasemanalDTO(lista);

		return listaRetorno;
	}
	
	public TeTarifasemanaisDTO setTearifasemanaisDTO (TeTarifasemanaisDTO listDTO) {
		TeTarifasemanaisDTO dtoRetorno = new TeTarifasemanaisDTO();

		if (listDTO ==null || !(listDTO.getListaTeTarifasemanalDTO().size()>0)) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
			return dtoRetorno;
		}
		
		
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t");
		q.append("from TeTarifasemanal t");
		q.append("where 1=1");
		
		List<TeTarifasemanal> listaPesquisa= null;
		try {
			listaPesquisa=q.query().list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(listaPesquisa!=null) {
			
			
		}
		
		
		return listDTO;
		
	}
	
}