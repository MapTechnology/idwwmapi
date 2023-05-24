package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;

public class PpCpprodutoDAO {
	
	private Session session;
	
	public PpCpprodutoDAO(Session session) {
		this.session = session;
	}

	public List<PpCpproduto> getPpCpprodutoDoPpCp(String cdCp) {
		MapQuery q = new MapQuery(session);
		q.append("FROM PpCpproduto cpproduto");
		q.append("JOIN cpproduto.ppCp cp");
		q.append("WHERE cp.cdPp LIKE :idCp");
		q.defineParametro("idCp", cdCp + "%");
		return q.list();
	}
	
	public List<PpCp> getPpCpprodutoPorNrDoc(String nrDoc) {
		MapQuery q = new MapQuery(session);
		q.append("select ppcp");
		q.append("from PpCp ppcp");
		q.append("join fetch ppcp.ppCpprodutos cpproduto");
		q.append("WHERE cpproduto.nrDoc = :nrDoc");
		q.append("and ppcp.stAtivo = 1");
		
		q.defineParametro("nrDoc", nrDoc);
		
		return q.list();
	}
	
	public List<PpCpproduto> getPpCpprodutosDoPpCpAtivo(String codigo) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT DISTINCT ppCpprodutos");
		q.append("FROM PpCp ppCp");
		q.append("INNER JOIN ppCp.ppCpprodutos ppCpprodutos");
		q.append("WHERE ppCp.stAtivo = :stAtivo");
		if(!codigo.equals("")) {
			q.append("AND ppCpprodutos.nrDoc = :nrdoc");
		}
		q.defineParametro("stAtivo", (byte) 1);
		if(!codigo.equals("")){
			q.defineParametro("nrdoc", codigo);
		}
		return q.list();
	}

	public PpCpproduto getPpCpprodutoPorId(long idCpproduto) {
		MapQuery q = new MapQuery(session);
		q.append("FROM PpCpproduto ppCpproduto");
		q.append("WHERE ppCpproduto.idCpproduto = :idCpproduto");
		q.defineParametro("idCpproduto", idCpproduto);
		return (PpCpproduto) q.uniqueResult();
	}
	
}