package idw.model.rn;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.AbstractDAOGenerico;
import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolpemp;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwTPerdamp;
import idw.webservices.dto.DwTPerdasmpDTO;

public class PerdampRN extends AbstractRN<AbstractDAOGenerico> {
	
	public PerdampRN(){
		this(null);
	}

	public PerdampRN(DAOGenerico dao) {
		super(dao);
		if(dao ==null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public DwTPerdamp getDwTPerdamp(long idTPerda){
		return this.getDao().findById(DwTPerdamp.class, idTPerda, false);
	}
	
	public DwRap getDwRap(String cdRap){
		DwRap dwRap = null;
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select dwRap from DwRap dwRap where dwRap.cdRap = :cdrap and dwRap.stAtivo = 1");
		q.defineParametro("cdrap", cdRap);
		q.setMaxResults(1);
		dwRap = (DwRap) q.uniqueResult();
		return dwRap; 
	}
	
	public DwConsolpemp getDwConsolpemp(long idConsol, long idPerdaPemp){
		DwConsolpemp dwConsolpemp = null;
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select dwConsolpemp from Dwconsolpemp dwconsolpemp ");
		q.append("inner join DwTPerdamp dwTPerdamp ");
		q.setMaxResults(1);
		dwConsolpemp = (DwConsolpemp) q.uniqueResult();
		return dwConsolpemp;
	}
	
	public DwTPerdasmpDTO getDwTPerdasmp(){
		MapQuery q = new MapQuery(getDaoSession());
		q.append("FROM DwTPerdamp dwTPerdamp");
		List<DwTPerdamp> listaPerdasmp = q.list();
		List<DwTPerdamp> listaAux = new ArrayList<>();
		for(DwTPerdamp dwTPerdamp : listaPerdasmp){
			listaAux.add(dwTPerdamp.clone(false));
		}
		DwTPerdasmpDTO retorno = new DwTPerdasmpDTO();
		retorno.setDwTPerdamps(listaAux);
		return retorno;
	}
	
	public DwTPerdamp getDwTPerdampPorDs(String dsPerdamp){
		MapQuery q = new MapQuery(getDaoSession());
		q.append("FROM DwTPerdamp dwTPerdamp");
		q.append("WHERE dwTPerdamp.dsPerdamp = :dsPerdamp");
		q.defineParametro("dsPerdamp", dsPerdamp);
		q.setMaxResults(1);
		return (DwTPerdamp) q.uniqueResult();
	}
	
}