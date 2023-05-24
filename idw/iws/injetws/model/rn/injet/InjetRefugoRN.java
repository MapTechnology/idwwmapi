package injetws.model.rn.injet;


import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijgrpinjref;
import idw.model.pojos.injet.Ijtbref;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.webservices.dto.IwsRefugoDTO;
import ms.model.dao.AbstractInjetDAO;

import org.apache.commons.lang3.Validate;

public class InjetRefugoRN extends AbstractInjetDAO {
	public InjetRefugoRN(DAOGenericoInjet daoInjet){
		Validate.notNull(daoInjet);
		
		this.setDaoInjet(daoInjet);
	}
	
	public String getTr_ValidaCodDescRefugo( String cdRefugo){
		MapQuery q = new MapQuery(getDaoInjet().getSession());
				
		q.append("from Ijtbref ijtbref  ");		
		q.append("WHERE ((ijtbref.cdrefugo = :cdRefugo) OR (ijtbref.dsrefugo = :dsRefugo)) AND (stativo = 1)");
				
		q.defineParametro("cdRefugo", cdRefugo);
		q.defineParametro("dsrefugo", cdRefugo);
		q.query().setMaxResults(1);
		Ijtbref ijtbref=null;
		try{
			ijtbref = (Ijtbref)q.uniqueResult();
			if(ijtbref==null){
				return cdRefugo;
			}
		}
		catch(Exception e){
			return cdRefugo;
		}
		return ijtbref.getCdrefugo();
	}
	
	public IwsRefugoDTO getTr_TabValidaCodRefugo(String cdmaquina, String cdRefugo) throws RegistroDesconhecidoException {
				
		MapQuery q = new MapQuery(getDaoInjet().getSession());		
		q.append("FROM Ijgrpinjref ijgrpinjpref ");
		q.append("WHERE ijgrpinjpref.id.cdinjetora = :cdinjetora "); 	
		q.defineParametro("cdinjetora", cdmaquina);
		q.setMaxResults(1);		
		Ijgrpinjref ijgrpinjpref =(Ijgrpinjref)q.uniqueResult();
		
		q.novaConsulta();
		if(ijgrpinjpref==null){
			q.append("FROM Ijtbref ijtbref "); 
			q.append("WHERE ijtbref.cdrefugo = :cdRefugo ");			
		}else{
			q.append("SELECT DISTINCT ijtbref FROM Ijtbref ijtbref, Ijgrpdetref ijgrpdetref, Ijgrpinjref ijgrpinjref "); 
			q.append("WHERE ijtbref.cdrefugo = ijgrpdetref.id.cdrefugo ");
			q.append("AND ijtbref.cdrefugo = :cdRefugo ");
			q.append("AND ijgrpdetref.id.cdgruporef = ijgrpinjref.id.cdgruporef ");
			q.append("AND ijgrpinjref.id.cdinjetora = :cdinjetora "); 	
		}
		q.append("AND ijtbref.cdrefugo <> '999999' ");
		q.append("AND ijtbref.stativo = 1  ");
				
		q.defineParametro("cdRefugo", cdRefugo);
		q.defineParametro("cdinjetora", cdmaquina);			
		q.setMaxResults(1);		
		Ijtbref oIjtbref =(Ijtbref)q.uniqueResult();
		
		IwsRefugoDTO oRefugoDTO = new IwsRefugoDTO();
		
		// colocando no DTO
		if(oIjtbref != null) {
			oRefugoDTO.setIsRefugoValido(true);
			oRefugoDTO.setCdRefugo(oIjtbref.getCdrefugo());
			oRefugoDTO.setDsRefugo(oIjtbref.getDsrefugo());
			
			if(oIjtbref.getLrequercausa().intValue()==0)
				oRefugoDTO.setPedeCausa(true);
			else
				oRefugoDTO.setPedeCausa(false);
			
			if(oIjtbref.getLrequeracao().intValue()==0)
				oRefugoDTO.setPedeAcao(true);
			else 
				oRefugoDTO.setPedeAcao(false);
			
			oRefugoDTO.setPedeJust(false);
		}else
			throw new RegistroDesconhecidoException();	
		
		return(oRefugoDTO);
	}
	
	
	
}
