package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.OmPapro;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;

public class OmpaproDao {
	
	private Session session = null;
	
	public OmpaproDao(Session session){
		this.session = session;
	}
	
	public OmPapro saveOrUpdate(OmPapro omPapro){
		session.saveOrUpdate(omPapro);
		return omPapro;
	}
	
	public List<OmPapro> getTodosProdutosDoPaDoPt(String cdPt){
		OmPt omPt = new OmPt();
		omPt.setCdPt(cdPt);
		return getTodosProdutosDoPaDoPt(omPt);
	}
	
	public List<OmPapro> getTodosProdutosDoPaDoPt(OmPt omPt){
		MapQuery q = new MapQuery(session);
		q.append("SELECT omPapro FROM OmPapro omPapro");
		q.append("LEFT JOIN FETCH omPapro.omProduto ");
		q.append("LEFT JOIN FETCH omPapro.omMapapa omMapapa");
		q.append("LEFT JOIN FETCH omMapapa.omMapa ");
		q.append("LEFT JOIN FETCH omMapapa.omPa ");
		q.append("LEFT JOIN FETCH omPapro.omPt ompt");
		
		q.append("WHERE ompt.cdPt = :omPt");
		q.append("ORDER BY omPapro.idPapro");
		q.defineParametro("omPt", omPt.getCdPt());
		return q.list();
	}
	
	public void removerTodosProdutosDoPaDoPt(OmPt omPt){
		MapQuery q = new MapQuery(session);
		q.append("DELETE FROM OmPapro p");	
		q.append("WHERE p.omPt  =:pt");			
		q.defineParametro("pt", omPt);
		q.query().executeUpdate();		
	}
	
	public void removerTodosOmPapros(){
		MapQuery q = new MapQuery(session);
		q.append("DELETE FROM OmPapro p");
		q.query().executeUpdate();		
	}
	
	public void removerOmpapro(OmPapro omPapro){
		session.delete(omPapro);
	}
	
	public List<OmPapro> getTodosProdutosDoPa(){
		MapQuery q = new MapQuery(session);
		q.append("SELECT omPapro FROM OmPapro omPapro");
		q.append("LEFT JOIN FETCH omPapro.omProduto omproduto");
		q.append("LEFT JOIN FETCH omPapro.omPt ompt");
		q.append("LEFT JOIN FETCH omPapro.omPa ompa");
		q.append("LEFT JOIN FETCH omPapro.omMapapa ommapapa");
		q.append("LEFT JOIN FETCH ommapapa.omMapa ommapa");
		q.append("where ompt.stAtivo = 1");
		return q.list();
	}

	public OmPapro getOmPapro(OmPt omPt, String cdPa) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT omPapro FROM OmPapro omPapro");
		q.append("INNER JOIN omPapro.omProduto omProduto");
		q.append("INNER JOIN omPapro.omPa omPa");		
		q.append("WHERE omPapro.omPt = :omPt");
		q.append("AND omPa.cdPa = :cdPa");
		q.defineParametro("omPt", omPt);
		q.defineParametro("cdPa", cdPa);
		q.setMaxResults(1);
		return (OmPapro) q.uniqueResult();
	}

	public List<OmPapro> getProdutosDaPosicaoNaOrdem(OmPt omPt, String cdPa) {//, long idProduto) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT DISTINCT omPapro FROM OmPapro omPapro");
		q.append("LEFT JOIN omPapro.omMapapa omMapapa");
		q.append("LEFT JOIN omMapapa.omMapa omMapa");
		q.append("LEFT JOIN omMapa.omPt omPt");
		q.append("LEFT JOIN omPapro.omPa omPa");
		q.append("WHERE omMapa.stAtivo = :mapaStAtivo");
		q.append("AND omPapro.omPt = :omPt");
		q.append("AND omPa.cdPa = :cdPa)");
		q.defineParametro("mapaStAtivo", (byte)1);
		q.defineParametro("omPt", omPt);
		q.defineParametro("cdPa", cdPa);
		
		return q.list();
	}

	public List<OmPapro> getProdutosDaPosicaoNaOrdemPeloDePara(OmPt omPt, String cdDePara) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT DISTINCT omPapro FROM OmPapro omPapro");
		q.append("LEFT JOIN omPapro.omMapapa omMapapa");
		q.append("LEFT JOIN omMapapa.omMapa omMapa");
		q.append("LEFT JOIN omMapa.omPt omPt");
		q.append("LEFT JOIN omPapro.omPa omPa");
		q.append("WHERE omMapa.stAtivo = :mapaStAtivo");
		q.append("AND omPapro.omPt = :omPt");
		q.append("AND (omPa.depara = :cdDePara)");
		q.defineParametro("mapaStAtivo", (byte)1);
		q.defineParametro("omPt", omPt);
		q.defineParametro("cdDePara", cdDePara);
		
		return q.list();
	}

	public void removerProdutoTodosOmPapro(OmProduto omProduto) {
		MapQuery q = new MapQuery(session);
		q.append("DELETE FROM OmPapro p");	
		q.append("WHERE p.omProduto  =:omProduto");			
		q.defineParametro("omProduto", omProduto);
		q.query().executeUpdate();			
	}
	
	
}
