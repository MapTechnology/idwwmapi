package ms.model.rn.pdba;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.MsUp;
import injetws.model.excessoes.SemSGBDException;
import injetws.model.pojos.PrUp;
import injetws.model.pojos.PrUpLoginsEmAberto;
import injetws.model.rn.ModRN;
import injetws.webservices.dto.IwsListaUpDTO;
import injetws.webservices.dto.IwsModDTO;

import java.util.ArrayList;
import java.util.List;

public class PrUpRN {
	private DAOGenerico dao = null;	
	
	public PrUpRN(DAOGenerico dao){
		this.dao = dao;
	}
	
	// funcao para bucar o prup do up
	public PrUp getPrup(MsUp msup){
		MapQuery q = new MapQuery(dao.getSession());
		
		q.append("select prup ");
		q.append("from PrUp prup ");
		q.append("where prup.cdmaqestendido = :idup ");
		q.append("and prup.stativa = 1");
		
		q.defineParametro("idup", msup.getCdUp());
		
		q.setMaxResults(1);
		
		PrUp prup = (PrUp) q.uniqueResult();
		return prup;
	}
	
	
	public IwsListaUpDTO getListaUpInjetWsDTO() throws SemSGBDException{
		IwsListaUpDTO listaUpDTO =null;
		try{
			MapQuery q = new MapQuery(dao.getSession());
			
			q.append("select prup ");
			q.append("from PrUp prup ");
			q.append("join fetch prup.prSubColetor prsubcoletor ");
			q.append("join fetch prsubcoletor.prColetor prcoletor ");
			q.append("where (prcoletor.idcoletor IS NOT NULL) AND prup.stativa ='1'");
			
			List<PrUp> prups = q.list();
			
			List<IwsModDTO> listaLogins = null;
			ModRN modrn = new ModRN(dao);
			listaUpDTO = new IwsListaUpDTO();
			
			
			for (PrUp prup : prups) {
				// Alessandre em 12-02-15 evict para remover a prup da sessao, estou atras do erro no snapshot em pr_up e esse metodo eh chamado pelo heart-beat do ms
				dao.evict(prup);
				try {
					listaLogins = modrn.getTr_operadoresLogados(prup.getIdup().toString()).getListModDTO();
				} catch (Exception e) {
					listaLogins = null;
					e.printStackTrace();
				}			
				prup.mudaListaLoginsEmAberto(listaLogins);
				//TODO: Os 4 casos abaixo resolvo depois, impacta somente no IHM android
	//			prup.mudaListaAlertasEmAberto(inforn.pesquisaAlertasEmAberto(prup.getIdup().toString()));				
	//			inforn.VerificaIsEmRegulagem(prup);
	//			inforn.verificaStatusVariacaoRitmo(prup);
	//			inforn.verificaIsComCIP(prup);
				listaUpDTO.setStAndonConfiguravel(false);
				listaUpDTO.setStAndonProcessoft(false);
				listaUpDTO.addPrUp(prup);
			}
		}catch(Exception e){
			e.printStackTrace();			
		}
		return listaUpDTO;
	}
	
	//retorna os operadores logados , em  cada UP
	public List<PrUpLoginsEmAberto> getOperadoresLogados(PrUp prup){
		
	    	MapQuery query = new MapQuery(dao.getSession());
			query.append("select operadores ");
			query.append("from PrUpLoginsEmAberto operadores ");
			query.append("where operadores.prUp.idup = :idup ");
			
			query.defineParametro("idup",prup.getIdup());
			
			List<PrUpLoginsEmAberto> listaoperadores = query.list(); 
			
			if (listaoperadores == null)
				listaoperadores = new ArrayList<PrUpLoginsEmAberto>();
			
	    	return listaoperadores ;
	    	
	    
	}
	
}
