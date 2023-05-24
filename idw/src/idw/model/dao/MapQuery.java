package idw.model.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.type.Type;

public class MapQuery{

	private StringBuilder hql = new StringBuilder();
	private Query q;
	private Session s;
	private StatelessSession sessionStaless;
	private boolean isPrimeiro = true;
	private SQLQuery qsql =null;
			
	public static String _NULL = "";
	public static String _AND = "AND";
	public static String _OR  = "OR";

	public MapQuery(Session s){
		this.hql = new StringBuilder();
		this.s = s;
	}
	public MapQuery(StatelessSession session){
		this.hql = new StringBuilder();
		this.sessionStaless = session;
	}
	public MapQuery(Query q){
		this.q = q;
	}
	public void novaConsulta(){
		this.hql = new StringBuilder();
		this.q = null;
		this.qsql = null;
		this.isPrimeiro = true;
	}
	public Query query(){
		if (this.q == null){
			if (s != null)
				q = s.createQuery(this.hql.toString());
			else {
				q = sessionStaless.createQuery(this.hql.toString());
			}
			
//			q.setLockOptions(LockOptions.NONE);
			
		}
		return this.q;
	}
	
	public SQLQuery querySQL() {
		if (this.qsql == null){
			if (s != null)
				qsql = s.createSQLQuery(this.hql.toString());
			else
				qsql = sessionStaless.createSQLQuery(this.hql.toString());
		}
		return qsql;
	}
	
	public void defineParametro(String parametro, Object valor, Type  type){
		try {
			query().setParameter(parametro, valor, type);
		} catch (Exception e){
		}
	}
	public void defineParametro(String parametro, Object valor){
		try {
			query().setParameter(parametro, valor);
		} catch (Exception e){
		}
	}
	public void defineParametro(int ordem, Object valor){
		try {
			query().setParameter(ordem, valor);
		} catch (Exception e){
		}
	}
	public void defineListaParametro(String parametro, List<Object> valor){
		try {
			query().setParameterList(parametro, valor);
		} catch (Exception e){			
		}
	}
	public void defineParametroData(String parametro, Date valor){
		try{
			query().setDate(parametro, valor);
		}catch (Exception e) {
		}
	}
	public void defineParametroTimestamp(String parametro, Date valor){
		try{
			query().setTimestamp(parametro, valor);	
		}catch (Exception e) {
		}
	}
	public void defineParametroData(int parametro, Date valor){
		try{
			query().setDate(parametro, valor);	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void defineParametroTimestamp(int parametro, Date valor){
		try{
			query().setTimestamp(parametro, valor);	
		}catch (Exception e) {
		}
	}
	
	@Deprecated
	public StringBuilder getHql(){
		return this.hql;
	}
	
	public void setHql(StringBuilder valor) {
		this.hql = valor;
	}
	
	public String hqlToString(){
		return (hql == null ? null: hql.toString());
	}
	
	public ScrollableResults resultSet(){
		return query().scroll(ScrollMode.FORWARD_ONLY);
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> list() {
	    return query().list();
	}
	
	public MapQuery append(String hql){
		this.hql.append(" ");
		this.hql.append(hql);
		this.hql.append(" ");
		return this;
	}
	
	public MapQuery appendAND(){
		this.append(MapQuery._AND);
		return this;
	}

	public MapQuery appendOR(){
		this.append(MapQuery._OR);
		return this;
	}	
	
	public void appendWhere(String operador, String hql, boolean isValido){
		if (isValido == true){
			
			if (!this.hql.toString().contains("where"))
				this.hql.append(" where ");

			if (this.isPrimeiro == false){
				this.hql.append(" ");
				this.hql.append(operador);
				this.hql.append(" ");
			}
			this.hql.append(" ");
			this.hql.append(hql);
			this.hql.append(" ");
			
			this.isPrimeiro = false;
		}
	}
	public Object uniqueResult(){
		return query().uniqueResult();
	}
	public void setMaxResults(int total){
		query().setMaxResults(total);
	}
	
	public boolean isExists(){
		query().setMaxResults(1);
		return (query().uniqueResult() != null);
	}

	private String orderby;

	
	/* Configura o hql para count
	 * 
	 */
	public void configuraSelectCount(String tag) {
		// Substitui por um select count(*)
		hql.replace(0, tag.length()+1, "select count(*)");
		
		// Desabilita o ultimo order by
		if (hql.lastIndexOf("order") >= 0) {
			orderby = hql.substring(hql.lastIndexOf("order") );
			hql.delete(hql.lastIndexOf("order"), hql.length());
		} else
			orderby = "";
		
	}
	
	
	/* Metodo para encontrar quantos registros o select retorna
	 * 
	 */
	public Integer selectCount(String tag) {
		
		
		Object ret = query().uniqueResult();
		Long retorno = (Long) ret;
		hql.replace(0, 15, tag);
		hql.append(orderby);
		
		q = null;
		return retorno.intValue();
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> listComPaginacao(int pagina, int registrosPorPagina) {
		return query().setFirstResult((pagina -1) * registrosPorPagina).setMaxResults(registrosPorPagina).list();
	}
}
