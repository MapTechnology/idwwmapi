package ms.model.rn.pdba;

import injetws.model.pojos.PrUp;
import injetws.model.pojos.PrUpAlertasEmAberto;

import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;

public class PrUpAlertasRN {
	
	DAOGenerico dao;
	
	public PrUpAlertasRN(DAOGenerico dao){
		this.dao = dao;
	}
	
	//funcao para buscar a lista de alertas em aberto da up
	public List<PrUpAlertasEmAberto> getAlertas(PrUp prup){
	  
	    	MapQuery query = new MapQuery(dao.getSession());
			query.append("select alerta ");
			query.append("from PrUpAlertasEmAberto alerta ");
			query.append("where alerta.prUp.idup = :idup");
			
			query.defineParametro("idup",prup.getIdup());
			
			List<PrUpAlertasEmAberto> listaalertas = query.list(); 
			
	    	return listaalertas ;
			
	    	
	   
		
	}
}
