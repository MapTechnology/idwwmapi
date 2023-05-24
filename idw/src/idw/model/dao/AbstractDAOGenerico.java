package idw.model.dao;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.exception.LockAcquisitionException;

import idw.model.IPojoMAP;
import idw.model.excessoes.SemSessaoHibernateException;
import idw.model.pojos.OmUsr;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;
import ms.model.IPojoMs;

public abstract class AbstractDAOGenerico implements IDao{

    private Session session;
    private StatelessSession sessionStatless;

    protected abstract SessionFactory getSessionFactory();

	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}

	@Override
	public void iniciaConexaoBanco(Session sessao) {
		this.iniciaSessao();
		this.iniciaTransacao();
	}

	@Override
	public void finalizaConexaoBanco() {
		this.finalizaTransacao();
		this.finalizaSessao();
	}
	
	/**
	 * Chama {@link AbstractDAOGenerico#finalizaConexaoBanco()}, sem disparar exception
	 */
	public void finalizaConexaoBancoSemException() {		
		this.finalizaTransacaoSemException();
		this.finalizaSessaoSemException();
	}

	public void setSession(Session s) {
        this.session = s;
    }
    public void setSessionStateless(StatelessSession s) {
        this.sessionStatless = s;
    }

    public Session getSession() {
        if ((this.session == null) && (this.sessionStatless == null)) {
			throw new SemSessaoHibernateException();
		}
        return this.session;
    }
    public StatelessSession getSessionStateless() {
        if (this.sessionStatless == null) {
			throw new SemSessaoHibernateException();
		}
        return this.sessionStatless;
    }


    @SuppressWarnings("unchecked")
	public <T> T findById(Class<T> cl, Long id, boolean lock) {
        T entity;
        if (this.getSession() != null) {
	        if (lock) {
				entity = (T) this.getSession().load(cl, id, LockOptions.UPGRADE);
			} else {
				entity = (T) this.getSession().load(cl, id);
			}
        } else {
	        if (lock) {
				entity = (T) this.getSessionStateless().get(cl.getName(), (Serializable) id, LockMode.UPGRADE);
			} else {
				entity = (T) this.getSessionStateless().get(cl, id);
			}
        }
        return entity;
    }


	public <T> List<T> findAll(Class<T> cl) {
		MapQuery q = new MapQuery(this.getSession());
    	q.append("from " + cl.getName());
    	return q.list();
    }
    public <T> List<T> findByExample(Class<T> cl, T exampleInstance) {
    	return this.findByExample(cl, exampleInstance, null);
    }

    @SuppressWarnings("unchecked")
	public <T> List<T> findByExample(Class<T> cl, T exampleInstance, String[] excludeProperty) {
        Criteria crit = this.getSession().createCriteria(cl);
        Example example =  Example.create(exampleInstance);
        if (excludeProperty != null){
        	for (String exclude : excludeProperty) {
        		example.excludeProperty(exclude);
        	}
        }
        crit.add(example);
        return crit.list();
    }

    public <T> T makePersistent(T entity) {
    	if (this.getSession() !=  null) {
    		this.getSession().saveOrUpdate(entity);
    	} else {
    		this.getSessionStateless().insert(entity);
    	}
        return entity;
    }

    public void makeTransient(Object entity) {
        this.getSession().delete(entity);
    }

    public void flush() {
        this.getSession().flush();
    }

    public void clear() {
        this.getSession().clear();
    }
    
    public void delete(Object entity){
    	this.getSession().delete(entity);
    }
    
    /**
     * Use this inside subclasses as a convenience method.
     */

    @SuppressWarnings("unchecked")
	public <T> List<T> findByCriteria(Class<T> cl, Criterion... criterion) {
        Criteria crit = this.getSession().createCriteria(cl);
        for (Criterion c : criterion) {
            crit.add(c);
        }
        crit.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return crit.list();

    }

// @Deprecated   
    public void flushReiniciandoTransacao(){
    	if (this.getSession().getTransaction().isActive() == true)
    		this.getSession().getTransaction().commit();

		try{
			this.getSession().beginTransaction();
		} catch (Exception e){
			e.printStackTrace();
//			throw new SemSGBDException();
		}
    }
    
    /**
     * Chama {@link AbstractDAOGenerico#finalizaTransacao()} que n�o dispara exce��o
     */
    public void finalizaTransacaoSemException(){
    	try{
    		finalizaTransacao();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    public void finalizaTransacao(){
    	if ((this.getSession() != null) && (this.getSession().isOpen() == true) && (this.getSession().getTransaction() != null) && (this.getSession().getTransaction().isActive() == true)){
    		try {
    			this.getSession().getTransaction().commit();
    		} catch (LockAcquisitionException e) {
    			e.printStackTrace();
    			this.getSession().getTransaction().rollback();
    		} catch (Exception e){
    			e.printStackTrace();
    			this.getSession().getTransaction().rollback();
    			throw e;
    		}
     	}
    }
    public void finalizaTransacao(IdwLogger log, int idLog) throws SemSGBDException{
    	if ((this.getSession() != null) && (this.getSession().isOpen() == true) && (this.getSession().getTransaction() != null) && (this.getSession().getTransaction().isActive() == true)){
    		try {
    			log.info(idLog, 0, "comitando transacao");
    			this.getSession().getTransaction().commit();
    		} catch (LockAcquisitionException e) {
    			log.info("excessao ", e);
    			this.getSession().getTransaction().rollback();
    			throw new SemSGBDException();
    		} catch (Exception e){
    			log.info("excessao ", e);
    			this.getSession().getTransaction().rollback();
    			throw new SemSGBDException();
    		}
     	} else {
     		if (this.getSession() == null)
     			log.info(idLog, 0, "Sessao null");
     		else if (this.getSession().getTransaction() == null)
     			log.info(idLog, 0, "Trasacao null");
     		else
     			log.info(idLog, 0, "Sessao isOpen=" + this.getSession().isOpen() + " transacao isActive=" + this.getSession().getTransaction().isActive());
     	}
    }
    
    /**
     * Chama {@link AbstractDAOGenerico#rollBackTransacao()} que n�o dispara exce��o
     */
    public void rollBackTransacaoSemException(){
    	try{
    		rollBackTransacao();
    	}catch(Exception e){
    	}
    }
    
    public void rollBackTransacao(){
    	if ((this.getSession() != null) && (this.getSession().isOpen() == true) && (this.getSession().getTransaction() != null) && (this.getSession().getTransaction().isActive() == true)){
   			this.getSession().getTransaction().rollback();
     	}
    }

    public void finalizaTransacaoStateless(){
    	if ((this.getSessionStateless() != null) && (this.getSessionStateless().getTransaction() != null) && (this.getSessionStateless().getTransaction().isActive() == true)){
    		try {
    			this.getSessionStateless().getTransaction().commit();
    		} catch (Exception e){
    			e.printStackTrace();
    			this.getSessionStateless().getTransaction().rollback();
    		}
     	}
    }

    public void iniciaTransacao(){
		try{
			if (this.getSession().getTransaction().isActive() == false) {
				this.getSession().beginTransaction();
			}
		} catch (IllegalStateException e){
			// Sessao fechada abrir uma nova
			this.iniciaSessao();
			if (this.getSession().getTransaction().isActive() == false) {
				this.getSession().beginTransaction();
			}
		}
    }
    
    public Transaction iniciaTransacaoComRetorno(){
    	Transaction retorno = null;
		try{
			if (this.getSession().getTransaction().isActive() == false) {
				retorno = this.getSession().beginTransaction();
			}
		} catch (IllegalStateException e){
			// Sessao fechada abrir uma nova
			this.iniciaSessao();
			if (this.getSession().getTransaction().isActive() == false) {
				retorno = this.getSession().beginTransaction();
			}
		}
		return retorno;
    }

    public void iniciaTransacaoStateless(){

		try{
			if (this.getSessionStateless().getTransaction().isActive() == false) {
				this.getSessionStateless().beginTransaction();
			}
		} catch (IllegalStateException e){
			// Sessao fechada abrir uma nova
			this.iniciaSessaoStateless();
			if (this.getSessionStateless().getTransaction().isActive() == false) {
				this.getSessionStateless().beginTransaction();
			}
		}
    }

    public void commitaTransacao(){
    	commitaTransacao(session);
    }
    
    public void commitaTransacao(Session sessao){
    	if (sessao.isOpen() == true){
    		if (sessao.getTransaction().isActive() == true){
    			sessao.getTransaction().commit();
    		}
    		//CfwsFacade.log.info("Fechando sessao " + sessao);
    		sessao.close();
    	}
    }
    
    public void rollbackTransacao(){
    	rollbackTransacao(session);
    }
    
    public void rollbackTransacao(Session sessao){
    	if (sessao.isOpen() == true){
    		if (sessao.getTransaction().isActive() == true) {
				sessao.getTransaction().rollback();
			}
    		sessao.close();
    	}
    }
    
    /**
     * Cria consulta baseado em store procedure
     * @param storeProcedure
     * @param totalParametros
     */
    public Query createSQLQueryBaseadoStoreProcedure(String storeProcedure, int totalParametros){
    	Validate.isTrue(totalParametros >= 0, "totalCampos >= 0");    	
    	String campos = StringUtils.repeat("?", ",  ",totalParametros);
    	StringBuilder sb = new StringBuilder().append("{call ").append(storeProcedure).append("(").append(campos).append(")}");    		
    	return this.session.createSQLQuery(sb.toString());
    }
    
    public Session iniciaSessao(){
    	this.session = this.getSessionFactory().openSession();
    	return this.session;
    }

    public Session iniciaSessao(Session sessao){
    	if (sessao != null)
    		this.session = this.getSessionFactory().openSession();
    	else
    		this.session = iniciaSessao();
    	
    	return this.session;
    }

    public Session iniciaSessao(IdwLogger log, int idLog){
    	this.session = this.getSessionFactory().openSession();
    	log.info(idLog, 0, "sessao id = " + this.session.hashCode());
    	return this.session;
    }

    public StatelessSession iniciaSessaoStateless(){
    	this.sessionStatless = this.getSessionFactory().openStatelessSession();
    	return this.sessionStatless;
    }

    public void evict(Object obj){
    	if (this.session != null)
    		this.session.evict(obj);
    }

    public boolean contains(Object obj){
    	return this.session.contains(obj);
    }

    public void finalizaSessaoStateless(){
    	if (this.sessionStatless != null ) {
			this.sessionStatless.close();
		}
    }
    
    /**
     * Chama {@link AbstractDAOGenerico#finalizaSessao()} e n�o dispara exce��o se ocorrer erro
     * @return {@code true} se comando executado com sucesso. {@code false} se deu erro. 
     */
    public boolean finalizaSessaoSemException(){
    	try{
    		finalizaSessao();
    	}catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
    
    public void finalizaSessao(){
    	// Alessandre: Acrescentei isOpen em 04-10-12 pois algumas RN chamam internamente o comitatransacao que ja fecha a sessao, e o facade
    	// manda fechar novamente e dava erro
    	if (this.session != null && this.session.isOpen() == true) {
    		this.session.clear();
			this.session.close();
		}
    }
    public void finalizaSessao(IdwLogger log, int idLog){
    	// Alessandre: Acrescentei isOpen em 04-10-12 pois algumas RN chamam internamente o comitatransacao que ja fecha a sessao, e o facade
    	// manda fechar novamente e dava erro
    	if (this.session != null && this.session.isOpen() == true) {
    		log.info(idLog, 0, "Limpando e fechando sessao");
    		this.session.clear();
			this.session.close();
    		log.info(idLog, 0, "Sessao fechada");
		} else {
			log.info(idLog, 0, "a sessao estava null ou fechada");
		}
    }

    public void iniciaTransacao(Session sessao){
		sessao.beginTransaction();
    }

    public void iniciaTransacaoStateless(StatelessSession sessao){
		sessao.beginTransaction();
    }
    public void inclusaoDescartandoOriginal(Object anterior, OmUsr omusr, Object proximo){
    	// Seta registro anterior que ser� descartado
    	IPojoMAP pojoAnterior = (IPojoMAP) anterior;
    	IPojoMAP pojoProximo = (IPojoMAP) proximo;
    	if (anterior != null) {
    		pojoAnterior.setDtStativo(new Date());
    		pojoAnterior.setStAtivo((byte)0);
    		pojoAnterior.setOmUsrByIdUsrstativo(omusr);
    		this.makePersistent(anterior);
    	}

    	// Seta registro que sera incluido
    	if ((pojoAnterior == null) || (pojoAnterior != null && pojoAnterior.getRevisao() == null)) {
			pojoProximo.setRevisao(1l);
		} else {
			pojoProximo.setRevisao(pojoAnterior.getRevisao() + 1);
		}
    	pojoProximo.setDtStativo(new Date());
    	pojoProximo.setDtRevisao(new Date());
    	pojoProximo.setOmUsrByIdUsrrevisao(omusr);
    	pojoProximo.setOmUsrByIdUsrstativo(omusr);
    	pojoProximo.setStAtivo((byte)1);

    	this.makePersistent(proximo);
    }
    
    public void inclusaoDescartandoOriginal(Object anterior, Object proximo){
    	// Seta registro anterior que ser� descartado
    	IPojoMs pojoAnterior = (IPojoMs) anterior;
    	IPojoMs pojoProximo = (IPojoMs) proximo;
    	if (anterior != null) {
    		pojoAnterior.setDthrStativo(new Date());
    		pojoAnterior.setStAtivo(new BigDecimal(0));
    		makePersistent(anterior);
    	}
    	
    	// Seta registro que sera incluido
    	if ((pojoAnterior == null)||
    			(pojoAnterior != null && pojoAnterior.getRevisao() == null)) {
        	pojoProximo.setRevisao(BigDecimal.ONE);
    	}
    	else{
    		pojoProximo.setRevisao(pojoAnterior.getRevisao().add(BigDecimal.ONE) );
    	}
    	pojoProximo.setDthrStativo(new Date());
    	pojoProximo.setDthrRevisao(new Date());
    	pojoProximo.setStAtivo(new BigDecimal(1));
    	
    	makePersistent(proximo);
    }

}
