package idw.model.rn;

import java.util.HashSet;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpfaltamp;
import idw.webservices.dto.CpDTO;

/**
 *
 * @author milton
 *
 */
public class MateriaPrimaRN extends AbstractRN<DAOGenerico> {

	public MateriaPrimaRN() {
		this(null);
	}

	public MateriaPrimaRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	
	public CpDTO pesquisarMpFaltante(Long idCp){
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select ppcp");
		q.append("from PpCp ppcp");
		q.append("join ppcp.ppCpfaltamps ppcpfaltamp");
		q.append("where ppcp.idCp = :id");
		
		q.defineParametro("id", idCp);
		
		CpDTO retorno = new CpDTO();
		PpCp ppcp = (PpCp) q.uniqueResult();
		retorno.setCp(ppcp.clone());
		
		// Clonar a falta da materia-prima
		retorno.getCp().setPpCpfaltamps(new HashSet<PpCpfaltamp>());
		for (PpCpfaltamp mp : ppcp.getPpCpfaltamps()){
			retorno.getCp().getPpCpfaltamps().add(mp.clone());
		}
		
		return retorno;
	}
}
