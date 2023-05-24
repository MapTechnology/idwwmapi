package idw.model.rn;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.pojos.PpNecimpurl;
import idw.webservices.dto.PpNecimpurlDTO;

@SuppressWarnings("serial")
public class PpNecimpurlRN extends PpNecimpurlDTO implements IDao {
	
	private DAOGenerico dao;
	
	public PpNecimpurlRN() {
		if(this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}
	public PpNecimpurlRN(DAOGenerico dao) {
		this.dao = dao;
	}
	public PpNecimpurlRN(PpNecimpurlDTO ppnecimpurl) {
		super(ppnecimpurl);
		
		if(this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}

	@Override
	public void iniciaConexaoBanco(Session sessao) {		
		this.dao.iniciaSessao();
		this.dao.iniciaTransacao();
	}

	@Override
	public void finalizaConexaoBanco() {
		this.dao.finalizaTransacao();
		this.dao.finalizaSessao();
	}
	
	public PpNecimpurl pesquisar(PpNecimpurlDTO ppnecimpurlDTO) {
		PpNecimpurl retorno = null;
		
		MapQuery q = new MapQuery(dao.getSession());
		
		q.append("select ppurl from PpNecimpurl ppurl ");
		q.appendWhere(MapQuery._NULL, "ppurl.idNecimpurl = :idnecimpurl", (ppnecimpurlDTO.getIdNecimpurl() != null && ppnecimpurlDTO.getIdNecimpurl() > 0));
		
		q.defineParametro("idnecimpurl", ppnecimpurlDTO.getIdNecimpurl());
		
		q.setMaxResults(1);
		retorno = (PpNecimpurl)q.uniqueResult();
		
		return retorno;
		
	}
	
}
