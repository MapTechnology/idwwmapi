package idw.model.rn;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.pojos.PpNecimp;
import idw.webservices.dto.PpNecimpDTO;

public class PpNecimpRN extends PpNecimpDTO implements IDao {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient DAOGenerico dao;
	
	public PpNecimpRN() {
		if(this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}
	public PpNecimpRN(DAOGenerico dao) {
		this.dao = dao;
	}
	public PpNecimpRN(PpNecimpDTO ppnecimpDTO) {
		super(ppnecimpDTO);
		
		if(this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}
	
	public PpNecimp pesquisar(PpNecimpDTO ppnecimpDTO) {
		MapQuery q = new MapQuery(this.dao.getSession());
		
		q.append("select distinct ppnecimp from PpNecimp ppnecimp ");
		
		q.appendWhere(MapQuery._NULL, "ppnecimp.idNecimp = :idnecimp", (ppnecimpDTO.getIdNecimp() != null));
		
		q.defineParametro("idnecimp", ppnecimpDTO.getIdNecimp());
		
		q.setMaxResults(1);
		
		return (PpNecimp)q.uniqueResult();
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
	
}
