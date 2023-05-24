package ms.model.rn;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.rn.DataHoraRN;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.pojos.PrBridgeCollectorDatabase;
import injetws.model.pojos.PrUp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ms.model.dto.BcDTO;
import ms.model.dto.ListaBcDTO;


public class BcRN extends BcDTO implements IDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1550033408697055445L;
	private transient DAOGenerico dao = null;

	public BcRN(){
		if (dao == null)
			dao = new DAOGenerico();
	}
	public BcRN(DAOGenerico dao){
		this.dao = dao;
	}
	@Override
	public void iniciaConexaoBanco(Session sessao){
		dao.iniciaSessao();
		dao.iniciaTransacao();
	}
	@Override
	public void finalizaConexaoBanco(){
		dao.finalizaTransacao();
		dao.finalizaSessao();
	}
	public DAOGenerico getDao(){
		return this.dao;
	}
	public void setDao(DAOGenerico dao){
		this.dao = dao;
	}
	

	public boolean verificaBCOnLine(PrUp prup){
		
		
	    	MapQuery query = new MapQuery(dao.getSession());
			query.append("select prbridgecollectordatabase");
			query.append("from PrBridgeCollectorDatabase prbridgecollectordatabase ");
			query.append("join prbridgecollectordatabase.prConexoesInjets prconexoesinjet ");
			query.append("join prconexoesinjet.prUps prups ");
			query.append("where prups.idup =   :idup");
					
			query.defineParametro("idup",prup.getIdup());
			
			query.setMaxResults(1);
			
			
			
			PrBridgeCollectorDatabase mestre = (PrBridgeCollectorDatabase) query.uniqueResult();
			 
			
			if (mestre.getDthrultacessobd() == null
					|| DataHoraRN.getQuantidadeSegundosNoPeriodo(mestre.getDthrultacessobd(), 
							DataHoraRN.getDataHoraAtual(dao)) > mestre.getTmptimeoutmaster()) {

				return true;
			}

		return false;

		
	}

	public ListaBcDTO pesquisarListaBcDTO() throws RegistroDesconhecidoException{
		MapQuery q = new MapQuery(dao.getSession());
		
		q.append("from PrBridgeCollectorDatabase A ");
		
		List<PrBridgeCollectorDatabase> lista = q.list();
		
		if (lista == null || lista.size() <= 0){
			throw new RegistroDesconhecidoException();
		}
		
		List<BcDTO> listaBcs = new ArrayList<BcDTO>();
		for (PrBridgeCollectorDatabase p : lista){
			BcDTO b = new BcDTO();
			b.setCdBc(p.getIdmasterbridgecollecdatabase());
			listaBcs.add(b);
		}
		ListaBcDTO retorno = new ListaBcDTO();
		retorno.setListaBcDTO(listaBcs);
		return retorno;
	}
}
