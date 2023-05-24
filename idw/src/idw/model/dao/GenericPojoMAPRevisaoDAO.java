package idw.model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.hibernate.Session;

import idw.model.IPojoMAP;
import idw.model.IPojoMAPAkOmTppt;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.rn.DataHoraRN;

public class GenericPojoMAPRevisaoDAO<T extends IPojoMAP> extends GenericHibernateDAO<T>{
	
	public GenericPojoMAPRevisaoDAO(Session session, Class<T> persistentClass) {
		super(session, persistentClass);
	}


	public void desativar( String cd, String columnNameCd, OmTppt omTppt, Date dateOperacao, OmUsr omUsrOperacao ) throws RegistroDesconhecidoException, RegistroJaDesativadoException{
		this.desativar(this.findByCd(cd, columnNameCd, omTppt, false), dateOperacao, omUsrOperacao);
	}

	public void desativar(long id, Date dateOperacao, OmUsr omUsrOperacao ) throws RegistroJaDesativadoException{
		this.desativar(this.findById(id), dateOperacao, omUsrOperacao);
	}

	public void desativar(T e, Date dateOperacao, OmUsr omUsrOperacao) throws RegistroJaDesativadoException{
		Validate.notNull(e, "pojo");
		Validate.notNull(dateOperacao, "date");
		Validate.notNull(omUsrOperacao, "omUsr");
		Validate.notNull(e.getStAtivo(), "e.getStAtivo()");

		if(e.getStAtivo().equals((byte)0)){
			throw new RegistroJaDesativadoException();
		}
		e.setDtStativo(dateOperacao);
		e.setOmUsrByIdUsrstativo(omUsrOperacao);
		e.setStAtivo((byte) 0);
		this.save(e);
	}

	
	public  T salvarDesativandoOriginal(T e, Date dateOperacao, OmUsr omUsrOperacao){

		Validate.notNull(e, "e");

		T eDB = null;
		try {
			eDB = this.findByCd(e, false);
		// Registro n�o existe na base
		} catch (RegistroDesconhecidoException e1) {
		}
		
		// Se tiver OmTppt, atribui so o id, para nao dar problema de transiente nele quando persistir o pojo
		if( e instanceof IPojoMAPAkOmTppt){
			IPojoMAPAkOmTppt iPojoMAPAkOmTppt = (IPojoMAPAkOmTppt) e;
			
			// Verifica se estah no cache do hibernate (persistido)
			if(getSession().contains(iPojoMAPAkOmTppt.getOmTppt()) == false){
				OmTppt omTppt = (OmTppt) this.getSession().get(OmTppt.class, iPojoMAPAkOmTppt.getOmTppt().getIdTppt());
				iPojoMAPAkOmTppt.setOmTppt(omTppt);
			}
		}
		
		return this.salvarDesativandoOriginal(eDB, e, dateOperacao, omUsrOperacao);

	}

    public T salvarDesativandoOriginal(T pojoAnterior, T pojoProximo, Date dateOperacao, OmUsr omUsrOperacao){

    	Validate.notNull(pojoProximo, "pojoProximo");
    	Validate.notNull(dateOperacao, "date");
    	Validate.notNull(omUsrOperacao, "omUsr");

    	// Desativa registro anterior
    	if (pojoAnterior != null) {

    		Validate.notNull(pojoAnterior.getStAtivo(), "pojoAnterior.getStAtivo()");

    		// S� desativa anterior, se estiver ativado
    		if(pojoAnterior.getStAtivo().byteValue() == 1){

    			// Se estiver no mesmo estado, n�o precisa persistir
				if(pojoAnterior.equals(pojoProximo)){
					return pojoAnterior;
				}

	    		try {
					this.desativar(pojoAnterior, dateOperacao, omUsrOperacao);
				// Opera��o n�o realizada, registro j� desativado
				} catch (RegistroJaDesativadoException e) {
				}

    		}
    		
    		
    		pojoProximo.setRevisao(pojoAnterior.getRevisao());

    	}

    	// Seta registro que sera incluido
    	if ((pojoProximo.getRevisao() == null) || pojoProximo.getRevisao().equals((long)0)) {
			pojoProximo.setRevisao(1l);
		} else {
			pojoProximo.setRevisao(pojoProximo.getRevisao() + 1l );
		}
    	
    	pojoProximo.setId(null);
    	pojoProximo.setDtStativo(dateOperacao);
    	pojoProximo.setDtRevisao(dateOperacao);
    	pojoProximo.setStAtivo( (byte) 1);
    	pojoProximo.setOmUsrByIdUsrrevisao(omUsrOperacao);
    	pojoProximo.setOmUsrByIdUsrstativo(omUsrOperacao);

    	return this.save(pojoProximo);
    }


    public T salvarDeixandoOriginal(T pojoAnterior, T pojoProximo, Date dateOperacao, OmUsr omUsrOperacao){

    	Validate.notNull(pojoProximo, "pojoProximo");
    	Validate.notNull(dateOperacao, "date");
    	Validate.notNull(omUsrOperacao, "omUsr");

    	// Desativa registro anterior
    	if (pojoAnterior != null) {
    		
    		Validate.notNull(pojoAnterior.getStAtivo(), "pojoAnterior.getStAtivo()");

    		pojoProximo.setRevisao(pojoAnterior.getRevisao());
    		
    		// S� desativa anterior, se estiver ativado
    		if(pojoAnterior.getStAtivo().byteValue() == 1){

    			// Se estiver no mesmo estado, n�o precisa persistir
				if(pojoAnterior.equals(pojoProximo)){
					return pojoAnterior;
				}
				
	    		try {
					this.desativar(pojoAnterior, dateOperacao, omUsrOperacao);
				// Opera��o n�o realizada, registro j� desativado
				} catch (RegistroJaDesativadoException e) {
				}

    		}

    	}else{
    	   try {
    		   T objDesativado = findByCd(pojoProximo, false);
			
    		   pojoProximo.setRevisao(objDesativado.getRevisao());
    	    
    	    } catch (RegistroDesconhecidoException e) {
			}
    	   
    	}

    	// Seta registro que sera incluido
    	if ((pojoProximo.getRevisao() == null) || pojoProximo.getRevisao().equals((long)0)) {
			pojoProximo.setRevisao(1l);
		} else {
			pojoProximo.setRevisao(pojoProximo.getRevisao() + 1l );
		}
    	
    	pojoProximo.setDtStativo(dateOperacao);
    	pojoProximo.setDtRevisao(dateOperacao);
    	pojoProximo.setStAtivo( (byte) 1);
    	pojoProximo.setOmUsrByIdUsrrevisao(omUsrOperacao);
    	pojoProximo.setOmUsrByIdUsrstativo(omUsrOperacao);

    	return this.save(pojoProximo);
    }

    /**
     * Procura pojo com a �ltima revis�o da alternative key que estende de IPojoMAP
     * @param <T>
     * @param o
     * @return
     * @throws RegistroDesconhecidoException
     */
	public T findByCd(T o) throws RegistroDesconhecidoException {
		Validate.notNull(o, "o");
		return this.findByCd(o, true);
	}

    /**
     * Procura pojo com a �ltima revis�o da alternative key que estende de IPojoMAP
     * <br> Caso o objeto seja um implementa��o de IPojoMAPAkOmTppt, passa o tipo do posto para o procedimento {@link #findByCd(Class, String, String, OmTppt, boolean)}
     * @param <T>
     * @param o
     * @param isFiltraApenasAtivo filtra pelo StAtivo = 1
     * @return
     * @throws RegistroDesconhecidoException
     */	
	public T findByCd(T o, boolean isFiltraApenasAtivo) throws RegistroDesconhecidoException {
		Validate.notNull(o, "o");

        if( o instanceof IPojoMAPAkOmTppt){
        	IPojoMAPAkOmTppt iPojoMAPAkOmTppt = (IPojoMAPAkOmTppt) o;
        	return (T) this.findByCd(o.getCd(), o.getFieldNameCd(), iPojoMAPAkOmTppt.getOmTppt() , isFiltraApenasAtivo);
        }else {
        	return (T) this.findByCd(o.getCd(), o.getFieldNameCd(), isFiltraApenasAtivo);
        }

	}

	public <T extends IPojoMAPAkOmTppt> T findByCd(T o) throws RegistroDesconhecidoException {
		Validate.notNull(o, "o");
		return (T) this.findByCd(o.getCd(), o.getFieldNameCd(), o.getOmTppt(), true);
	}

	public T findByCd(String cd, String columnNameCd, boolean isFiltraApenasAtivo) throws RegistroDesconhecidoException {
		return this.findByCd(cd, columnNameCd, null, isFiltraApenasAtivo);
	}


	/**
	 * Procura pojo pela alternative key (c�digo ou c�digo e OmTppt), a sua �ltima revis�o do pojo
	 * @param cd c�digo do pojo
	 * @param columnNameCd nome do campo de c�digo do pojo
	 * @param omTppt Se {@code cl} for derivada de IPojoMAPPkOmTppt
	 * @param isFiltraApenasAtivo filtra pelo StAtivo = 1
	 * @return
	 */	
	public T findByCd(String cd, String columnNameCd, OmTppt omTppt, boolean isFiltraApenasAtivo) throws RegistroDesconhecidoException {
		return findByCd(cd, columnNameCd, omTppt, isFiltraApenasAtivo, null );
	}
	
	
	/**
	 * Procura pojo pela alternative key (c�digo ou c�digo e OmTppt), a sua �ltima revis�o do pojo
	 * <p>
	 * Para usar o parametro {@code hqlJoin}, coloque o hql necess�rio para fazer o join com o outro objeto
	 * <br>Por exemplo se o objeto for o {@code OmProduto}, e tiver a necessidade de carregar OmUnidmedida e PpCliente passar o seguinte para {@code hqlJoin}
	 * <br>"LEFT JOIN FETCH omProduto.OmUnidMedida LEFT JOIN FETCH omProduto.PpCliente "
	 * @param cd c�digo do pojo
	 * @param columnNameCd nome do campo de c�digo do pojo
	 * @param omTppt Se {@code cl} for derivada de IPojoMAPPkOmTppt
	 * @param isFiltraApenasAtivo filtra pelo StAtivo = 1
	 * @param hqlJoin instru��o em hql para fazer join com outras tabelas. Isso � �til para j� carregar os dados dos objetos que comp�em a classe passada {@code cl}
	 * @return
	 */
	public T findByCd(String cd, String columnNameCd, OmTppt omTppt, boolean isFiltraApenasAtivo, String hqlJoin) throws RegistroDesconhecidoException {

        Validate.notBlank(columnNameCd, "columnNameCd");
        Validate.notBlank(cd, "cd" + columnNameCd);

        MapQuery q = montarMapQueryFindByCd(cd, columnNameCd, omTppt, isFiltraApenasAtivo, hqlJoin);
        
		q.query().setMaxResults(1);

		@SuppressWarnings("unchecked")
		T entity = (T) q.query().uniqueResult();

		if(entity == null){
			throw new RegistroDesconhecidoException();
		}
		return entity;

    }
	
	/**
	 * Monta o {@code MapQuery} para pesquisar pelo c�digo baseado no {@code IPojoMap} 
	 * @param cd
	 * @param columnNameCd
	 * @param omTppt
	 * @param isFiltraApenasAtivo
	 * @param hqlJoin
	 * @see DAOGenerico#montarMapQueryFindByCds(Class, Set, String, OmTppt, boolean, String)
	 * @return
	 */
	private MapQuery montarMapQueryFindByCd(String cd, String columnNameCd, OmTppt omTppt, boolean isFiltraApenasAtivo, String hqlJoin){
		Set<String> cds = new HashSet<String>();
		cds.add(cd);
		return montarMapQueryFindByCds(cds, columnNameCd, omTppt, isFiltraApenasAtivo, hqlJoin);
	}
	
	/**
	 * Montar o {@code MapQuery} para pesquisar pelos c�digos passados no parametro {@code cds}
	 * <br> Ex. se lista com os c�digos {4,5,7,8}, montar� 
	 * <br>    (codigo = 4 or codigo = 5 or codigo = 7 or codigo = 8 or codigo = 9)
	 * @param cl
	 * @param cds
	 * @param columnNameCd
	 * @param omTppt
	 * @param isFiltraApenasAtivo
	 * @param hqlJoin
	 * @return
	 */
	private MapQuery montarMapQueryFindByCds(Set<String> cds, String columnNameCd, OmTppt omTppt, boolean isFiltraApenasAtivo, String hqlJoin){
//        Validate.notNull(cl, "cl");
        Validate.notEmpty(cds, "cds");
        Validate.notBlank(columnNameCd, "columnNameCd");

        // Se a classe for IPojoMAPPkOmTppt, tratar OmTppt
        boolean isUsarOmTppt = IPojoMAPAkOmTppt.class.isAssignableFrom(getPersistentClass());

        if(isUsarOmTppt){
        	Validate.notNull(omTppt, "omTppt nao pode ser nulo");
        }

        String pojoAliasName = StringUtils.uncapitalize(getPersistentClass().getSimpleName());
        columnNameCd = StringUtils.uncapitalize(columnNameCd);

        StringBuilder sb = new StringBuilder("from ");

        // Entidade
		sb.append(getPersistentClass().getSimpleName()).append(" ").append(pojoAliasName);
		
		// Join
		sb.append(" ").append(ObjectUtils.defaultIfNull(hqlJoin, ""));
		
		sb.append(" WHERE ");

		// Filtro para ativado
		if(isFiltraApenasAtivo){
			sb.append(pojoAliasName).append(".stAtivo = :stAtivoAtivado");
			sb.append(" AND ");
		}

		if(isUsarOmTppt){
			// Filtro com OmTppt
			sb.append(" ").append(pojoAliasName).append(".omTppt = :omTppt");
			sb.append(" AND ");
		}
		
		sb.append("(");
		for(int i = 0 ; i < cds.size(); i++){
			
			if(i != 0){
				sb.append(" OR ");
			}
			sb.append("(");
			// Filtro com o c�digo
			sb.append(pojoAliasName).append(".").append(columnNameCd).append(" = :").append(columnNameCd).append(i);
			sb.append(")");
		
		}
		
		sb.append(")");
		sb.append(" ORDER BY ");
		sb.append(pojoAliasName).append(".revisao desc");

		MapQuery q = new MapQuery(getSession());
		q.append(sb.toString());
		
		int i = 0;
		for(String cd: cds){
			Validate.notBlank(cd, "cd");
			q.defineParametro(new StringBuilder(columnNameCd).append(i).toString(), cd);
			i++;
		}
		
		if(isFiltraApenasAtivo){
			q.defineParametro("stAtivoAtivado",(byte) 1);
		}

		if(isUsarOmTppt){
			q.defineParametro("omTppt", omTppt);
		}
		
		return q;
		
	}
	
	public List<T> findByCds(Set<String> cds, String columnNameCd, OmTppt omTppt, boolean isFiltraApenasAtivo, String hqlJoin) throws RegistroDesconhecidoException {
		MapQuery q = montarMapQueryFindByCds(cds, columnNameCd, omTppt, isFiltraApenasAtivo, hqlJoin);
		
		List<T> entities =  q.list();

		if(entities == null || entities.isEmpty() ){
			throw new RegistroDesconhecidoException();
		}
		return entities;		
	}
	
	/**
	 * Desativar registros
	 * @param cl classe que ter� os registros exclu�dos
	 * @param columnNameCd nome da coluna de c�digo
	 * @param listaCdDevemFicarAtivos - Lista de c�digos de devem ficar permanecer ativos
	 * @param isUsarLista - se for {@code true}, usa os itens da lista, caso contr�rio n�o usa e desativa todos os registros
	 */
	public void desativarMuitos(Class<? extends IPojoMAP> cl, String columnNameCd, List<String> listaCdDevemFicarAtivos, boolean isUsarLista, Date dataHora, OmUsr omUsr){

		Validate.notNull(cl);
		Validate.notBlank(columnNameCd);
		Validate.notNull(omUsr, "omUsr");
		Validate.isTrue(omUsr.getIdUsr() > 0, "omUsr.getIdUsr", omUsr.getIdUsr());

		if(isUsarLista == true){
			Validate.notEmpty(listaCdDevemFicarAtivos,"listaCdDevemFicarAtivos");
		}

		if(dataHora == null){
			dataHora = DataHoraRN.getDataHoraAtual();
		}

		String pojoAliasName = StringUtils.uncapitalize(cl.getSimpleName());
		columnNameCd = StringUtils.uncapitalize(columnNameCd);

		StringBuilder sb = new StringBuilder();


		sb.append("update ");
		sb.append(cl.getSimpleName());
		sb.append(" ");
		sb.append(pojoAliasName);

		sb.append(" set ");

		//Altera stativo
		sb.append(pojoAliasName).append(".stAtivo = :stAtivoDesativado");
		// Altera dtStativo
		sb.append(" , ").append(pojoAliasName).append(".dtStativo = :dt");
		// Altera omUsrByIdUsrstativo
		sb.append(" , ").append(pojoAliasName).append(".omUsrByIdUsrstativo = :omUsr");

		// Filtro, apenas registros que est�o ativos
		sb.append(" where ").append(pojoAliasName).append(".stAtivo = :stAtivoAtivado");

		if(isUsarLista){
			// Filtro, apenas registros que n�o est�o na lista de c�digos
			sb.append(" and ").append(pojoAliasName).append(".").append(columnNameCd).append(" not in (:lista)");
		}

		MapQuery q = new MapQuery(this.getSession());

		q.append(sb.toString());
		if(isUsarLista){
			q.defineListaParametro("lista",new ArrayList<Object>( listaCdDevemFicarAtivos));
		}
		//q.defineParametro("lista", codigosConcatenados);
		q.defineParametro("stAtivoDesativado", (byte) 0);
		q.defineParametro("stAtivoAtivado",(byte) 1);
		q.defineParametro("dt", dataHora);
		q.defineParametro("omUsr", omUsr);

		q.query().executeUpdate();

	}
	
	public Long getUltimaRevisao(String cd, String columnNameCd){
		Set<String> cds = new HashSet<String>();
		cds.add(cd);
		MapQuery q = montarMapQueryFindByCds(cds, columnNameCd, null, false, null);
		
		q.setMaxResults(1);
		
		@SuppressWarnings("unchecked")
		T obj = (T) q.uniqueResult();
		
		if(obj == null){
			return 1L;
		}else{
			return obj.getRevisao();
		}
		
	}


}
