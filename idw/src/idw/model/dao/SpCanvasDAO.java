package idw.model.dao;


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.model.pojos.SpCausaefeito;
import idw.model.pojos.SpMain;
import idw.model.pojos.SpMfv;
import idw.model.pojos.SpProblema;
import idw.model.pojos.SpSetor;
import idw.model.rn.DataHoraRN;
import idw.webservices.rest.mfv.dto.A3MainDTO;

public class SpCanvasDAO {

	private final MapQuery q;

	private Session session;


	private final String formatoData;
	private final String formatoDataHora;		

	public SpCanvasDAO(Session session, String formatoData, String formatoDataHora) {
		this.session = session;
		this.formatoData = formatoData;
		this.formatoDataHora = formatoDataHora;			
		q = new MapQuery(session);
	}



	public List<A3MainDTO> getListaA3(long idUsuario, String chavePesquisa) {

		q.novaConsulta();
		List<A3MainDTO> retorno = null;

		boolean isSemChavePesquisa = true;

		if ( chavePesquisa != null && !chavePesquisa.trim().equals("")){
			isSemChavePesquisa = false;
		}

		if (isSemChavePesquisa){

			q.append("SELECT  ");
			q.append("	NEW idw.webservices.rest.mfv.dto.A3MainDTO  ");
			q.append("	( ");
			q.append("	a.idSp ,  ");
			q.append("	a.cdSp ,  ");
			q.append("	a.dsSp ,  ");
			q.append("	a.dtIsp ,  ");
			q.append("	a.dtFsp ,  ");
			q.append("	a.cdProduto ,  ");
			q.append("	a.cachep3CiclosbarraIdgt,  ");
			q.append("	a.cachep3ParadaspizzaIdgt,  ");
			q.append("	a.cachep3DefeitosbarraIdgt,  ");
			q.append("	a.cachep3ParadasbarraCdarea,  ");
			q.append("	a.cachep7ResultDti,  ");
			q.append("	a.cachep7ResultDtf,  ");
			q.append("	prd.cdProduto  ");
			q.append("	) ");
			q.append("from  ");
			q.append("	SpMain a,  ");
			q.append("	OmProduto prd  ");
			q.append("	join a.omUsr ausu  ");
			q.append("	left join a.spProblemas ps  ");
			q.append("	join ps.spMain m  ");
			q.append("	join ps.spPlanos plans  ");
			q.append("	left join plans.spProblema prob  ");
			q.append("	left join prob.spProblemadses probdss  ");
			q.append("	join probdss.spLingua probdssling  ");
			q.append("	left join plans.spPlanoresps planresps  ");
			q.append("	left join planresps.spPlano plan  ");
			q.append("	left join planresps.omUsr planrespsusu  ");
			q.append("	join prob.spCausaefeitos ces  ");
			q.append("where   ");
			q.append("	(a.cdProduto = prd.cdProduto)  ");
			q.append("	and (m.idSp = a.idSp)  ");
			q.append("	and (probdssling.idLingua = 1)  ");
			q.append("	and ( (ausu.idUsr= :idusuario) or (planrespsusu.idUsr= :idusuario))  ");
			//q.append("	group by 1,2,3,4,5,6,7,8,9,10,11,12,13 ");
			q.append("	group by a.idSp, a.cdSp, a.dsSp, a.dtIsp, a.dtFsp, a.cdProduto, a.cachep3CiclosbarraIdgt, a.cachep3ParadaspizzaIdgt, a.cachep3DefeitosbarraIdgt, a.cachep3ParadasbarraCdarea, a.cachep7ResultDti, a.cachep7ResultDtf, prd.cdProduto ");
		
			q.defineParametro("idusuario", idUsuario);
			retorno = q.list();

		} else{

			q.append("SELECT NEW idw.webservices.rest.mfv.dto.A3MainDTO");
			q.append("(   ");
			q.append("	a.idSp , ");
			q.append("	a.cdSp , ");
			q.append("	a.dsSp , ");
			q.append("	a.dtIsp , ");
			q.append("	a.dtFsp , ");
			q.append("	a.cdProduto , ");
			q.append("	a.cachep3CiclosbarraIdgt, ");
			q.append("	a.cachep3ParadaspizzaIdgt, ");
			q.append("	a.cachep3DefeitosbarraIdgt, ");
			q.append("	a.cachep3ParadasbarraCdarea, ");
			q.append("	a.cachep7ResultDti, ");
			q.append("	a.cachep7ResultDtf, ");
			q.append("	prd.cdProduto ");
			q.append(")   ");
			q.append("from SpMain a, OmProduto prd ");
			q.append("join a.omUsr ausu ");
			q.append("left join a.spProblemas ps ");
			q.append("join ps.spMain m ");
			q.append("join ps.spPlanos plans ");
			q.append("left join plans.spProblema prob ");
			q.append("left join prob.spProblemadses probdss ");
			q.append("left join probdss.spLingua probdssling ");
			q.append("left join plans.spPlanoresps planresps ");
			q.append("left join planresps.spPlano plan ");
			q.append("left join planresps.omUsr planrespsusu ");
			q.append("left join prob.spCausaefeitos ces ");
			q.append("left join ces.spCausaefeito ce ");
			q.append("left join ce.spCausa c ");
			q.append("left join c.spCausadses cdss ");
			q.append("left join cdss.spLingua cdssling ");
			q.append("where  ");
			q.append("	(a.cdProduto = prd.cdProduto) ");
			q.append("	and (m.idSp = a.idSp) ");
			//q.append("	and (cdssling.idLingua = 1) ");
			q.append("	and (probdssling.idLingua = 1) ");
			q.append("	and ( (ausu.idUsr= :idusuario) or (planrespsusu.idUsr= :idusuario)) ");
			q.append("	and ");
			q.append("	( ");
			q.append("		( lower( trim( cdss.dsCausa ) ) like lower( :chavepesq ) ) ");
			q.append("		or ( lower( trim(probdss.dsProblema) ) like lower( :chavepesq ) ) ");
			q.append("		or ( lower( trim(a.cdSp) ) like lower( :chavepesq ) ) ");
			q.append("		or ( lower( trim(plan.problemaOque) ) like lower( :chavepesq ) ) ");
			q.append("		or ( lower(trim( plan.acaoComo )) like lower( :chavepesq ) ) ");
			q.append("	) ");
			//q.append("	group by 1,2,3,4,5,6,7,8,9,10,11,12,13 ");
			q.append("	group by a.idSp, a.cdSp, a.dsSp, a.dtIsp, a.dtFsp, a.cdProduto, a.cachep3CiclosbarraIdgt, a.cachep3ParadaspizzaIdgt, a.cachep3DefeitosbarraIdgt, a.cachep3ParadasbarraCdarea, a.cachep7ResultDti, a.cachep7ResultDtf, prd.cdProduto ");

			q.defineParametro("idusuario", idUsuario);
			q.defineParametro("chavepesq",  "%"+chavePesquisa+"%");
			retorno = q.list();

		}


		return retorno;
	}


	public List<A3MainDTO> getListaA3IdUsr(long idUsuario) {

		q.novaConsulta();
		List<A3MainDTO> retorno = null;

		/* a3 COM idw: estava conferindo cdproduto; nao mais necessário.  
		q.append("SELECT   ");
		q.append("	NEW idw.webservices.rest.mfv.dto.A3MainDTO   ");
		q.append("	(  ");
		q.append("	a.idSp ,   ");
		q.append("	a.cdSp ,   ");
		q.append("	a.dsSp ,   ");
		q.append("	a.dtIsp ,   ");
		q.append("	a.dtFsp ,   ");
		q.append("	a.cdProduto ,   ");
		q.append("	a.cachep3CiclosbarraIdgt,   ");
		q.append("	a.cachep3ParadaspizzaIdgt,   ");
		q.append("	a.cachep3DefeitosbarraIdgt,   ");
		q.append("	a.cachep3ParadasbarraCdarea,   ");
		q.append("	a.cachep7ResultDti,   ");
		q.append("	a.cachep7ResultDtf,   ");
		q.append("	prd.cdProduto   ");
		q.append("	)  ");
		q.append("from   ");
		q.append("	SpMain a,   ");
		q.append("	OmProduto prd   ");
		q.append("	join a.omUsr ausu   ");
		q.append("	left join a.spProblemas ps   ");
		q.append("	join ps.spMain m   ");
		q.append("	join ps.spPlanos plans   ");
		q.append("	left join plans.spProblema prob   ");
		q.append("	left join prob.spProblemadses probdss   ");
		q.append("	join probdss.spLingua probdssling   ");
		q.append("	left join plans.spPlanoresps planresps   ");
		q.append("	left join planresps.spPlano plan   ");
		q.append("	left join planresps.omUsr planrespsusu   ");
		q.append("where    ");
		q.append("	(a.cdProduto = prd.cdProduto)   ");
		q.append("	and (m.idSp = a.idSp)   ");
		q.append("	and (probdssling.idLingua = 1)   ");
		q.append("	and ( (ausu.idUsr= :idusuario) or (planrespsusu.idUsr= :idusuario)) ");
		q.append("group by  ");
		q.append("	a.idSp ");
		q.append("	,a.cdSp ");
		q.append("	,a.dsSp ");
		q.append("	,a.dtIsp ");
		q.append("	,a.dtFsp ");
		q.append("	,prd.cdProduto ");
		q.append("order by ");
		q.append("	a.idSp desc ");
		q.append("	,a.dsSp asc ");
		*/
		
		// aqui opcao SEM idw: nao precisa conferir cdproduto
		q.append("SELECT   ");
		q.append("	NEW idw.webservices.rest.mfv.dto.A3MainDTO   ");
		q.append("	(  ");
		q.append("	a.idSp ,   ");
		q.append("	a.cdSp ,   ");
		q.append("	a.dsSp ,   ");
		q.append("	a.dtIsp ,   ");
		q.append("	a.dtFsp ,   ");
		q.append("	a.cdProduto ,   ");
		q.append("	a.cachep3CiclosbarraIdgt,   ");
		q.append("	a.cachep3ParadaspizzaIdgt,   ");
		q.append("	a.cachep3DefeitosbarraIdgt,   ");
		q.append("	a.cachep3ParadasbarraCdarea,   ");
		q.append("	a.cachep7ResultDti,   ");
		q.append("	a.cachep7ResultDtf,   ");
		q.append("	a.cdProduto   ");
		q.append("	)  ");
		q.append("from   ");
		q.append("	SpMain a    ");
		q.append("	join a.omUsr ausu   ");
		q.append("	left join a.spProblemas ps   ");
		q.append("	join ps.spMain m   ");
		q.append("	join ps.spPlanos plans   ");
		q.append("	left join plans.spProblema prob   ");
		q.append("	left join prob.spProblemadses probdss   ");
		q.append("	join probdss.spLingua probdssling   ");
		q.append("	left join plans.spPlanoresps planresps   ");
		q.append("	left join planresps.spPlano plan   ");
		q.append("	left join planresps.omUsr planrespsusu   ");
		q.append("where    ");
		q.append("	 (m.idSp = a.idSp)   ");
		q.append("	and (probdssling.idLingua = 1)   ");
		q.append("	and ( (ausu.idUsr= :idusuario) or (planrespsusu.idUsr= :idusuario)) ");
		q.append("group by  ");
		q.append("	a.idSp ");
		q.append("	,a.cdSp ");
		q.append("	,a.dsSp ");
		q.append("	,a.dtIsp ");
		q.append("	,a.dtFsp ");
		q.append("	,a.cdProduto ");
		q.append("	,a.cachep3CiclosbarraIdgt,   ");
		q.append("	a.cachep3ParadaspizzaIdgt,   ");
		q.append("	a.cachep3DefeitosbarraIdgt,   ");
		q.append("	a.cachep3ParadasbarraCdarea,   ");
		q.append("	a.cachep7ResultDti,   ");
		q.append("	a.cachep7ResultDtf   ");
		q.append("order by ");
		q.append("	a.idSp desc ");
		q.append("	,a.dsSp asc ");
		

		q.defineParametro("idusuario", idUsuario);
		retorno = q.list();




		return retorno;
	}


	//fa3geta3nw
	public List<A3MainDTO> getSp(long idSp) {

		q.novaConsulta();
		List<A3MainDTO> retorno = null;



		q.append("SELECT    ");
		q.append("	NEW idw.webservices.rest.mfv.dto.A3MainDTO    ");
		q.append("	(   ");
		q.append("	a.idSp ,    ");
		q.append("	a.cdSp ,    ");
		q.append("	a.dsSp ,    ");
		q.append("	a.dtIsp ,    ");
		q.append("	a.dtFsp ,    ");
		q.append("	a.cdProduto ,    ");
		q.append("	a.cachep3CiclosbarraIdgt,    ");
		q.append("	a.cachep3ParadaspizzaIdgt,    ");
		q.append("	a.cachep3DefeitosbarraIdgt,    ");
		q.append("	a.cachep3ParadasbarraCdarea,    ");
		q.append("	a.cachep7ResultDti,    ");
		q.append("	a.cachep7ResultDtf,    ");
		q.append("	prd.cdProduto    ");
		q.append("	)   ");
		q.append("from    ");
		q.append("	SpMain a,    ");
		q.append("	OmProduto prd    ");
		q.append("	join a.omUsr ausu    ");
		q.append("where     ");
		q.append("	(a.idSp = :idSp)    ");
		q.append("	and prd.cdProduto = a.cdProduto    ");
		q.append("order by  ");
		q.append("	a.idSp desc  ");
		q.append("	,a.dsSp asc  ");

		q.defineParametro("idSp", new BigDecimal( idSp));
		retorno = q.list();




		return retorno;
	}


	public long insertMainNw(
			long idSp
			,String cdSp
			,String dsSp
			,String dtisp
			,String dtfsp			
			,String cdproduto
			,long idusrdono			
			) {
		long retorno = 0;



		Calendar cal = new GregorianCalendar();
		boolean isUpdate = false;
		boolean isInsert = true;

		q.novaConsulta();

		//-- Busca saber se já existe ID. Se já existir, Update, senão, Insert.
		SpMain spPersist = null;
		q.append("SELECT sp");
		q.append("FROM SpMain sp");
		q.append("WHERE sp.idSp = :idSp");
		q.defineParametro("idSp", new BigDecimal(idSp));
		spPersist = (SpMain) q.uniqueResult();

		if (spPersist!=null && spPersist.getIdSp()!=null && spPersist.getIdSp().longValue()>0L){
			isInsert = false;
		}

		//-- Garante que se passado um ID-inexistente E <>0, retorna sem fazer nada.
		if ( (isInsert) && idSp!=0L){
			return 0L;
		}

		Calendar calIni = new GregorianCalendar();
		Calendar calFim = new GregorianCalendar();
		calIni.setTime( DataHoraRN.stringToDate(dtisp, formatoData)) ;
		calFim.setTime( DataHoraRN.stringToDate(dtfsp, formatoData) );


		if(isInsert){

			//-- Insert
			spPersist = null;
			spPersist = new SpMain();
			OmUsr omusr = new OmUsr();
			omusr.setId(idusrdono);
			spPersist.setCdSp(cdSp);
			spPersist.setDsSp(dsSp);
			spPersist.setDtIsp(calIni.getTime());
			spPersist.setDtFsp(calFim.getTime());
			spPersist.setCdProduto(cdproduto);
			spPersist.setOmUsr(omusr);


			this.session.persist(spPersist);
			this.session.flush();

			retorno = spPersist.getIdSp().longValue();

		} else {
			//Update
			OmUsr omusr = new OmUsr();
			omusr.setId(idusrdono);
			spPersist.setCdSp(cdSp);
			spPersist.setDsSp(dsSp);
			spPersist.setDtIsp(calIni.getTime());
			spPersist.setDtFsp(calFim.getTime());
			spPersist.setCdProduto(cdproduto);
			spPersist.setOmUsr(omusr);

			this.session.merge(spPersist);
			this.session.flush();

			retorno = spPersist.getIdSp().longValue();
		}


		return retorno;
	}	


	//fa3insertupdatevaloresmvf
	public long insertMfv(	
			String cdProduto
			, long idSetor
			, long  leadtime
			, long  cicletime
			, long percoee				
			) {
		long retorno = 0;

		boolean isUpdate = false;
		boolean isInsert = true;

		Calendar cal = new GregorianCalendar();

		//-- Primeiramente, garante que existe o cdproduto no om_produto
		if (cdProduto==null ||  cdProduto.equals("0") || cdProduto.equals("")){
			return retorno;
		}
		q.novaConsulta();
		OmProduto omprodutoRetorno = null;
		q.append("SELECT sp");
		q.append("FROM OmProduto sp");
		q.append("WHERE sp.stAtivo=1 and sp.cdProduto = :cdProduto");
		q.defineParametro("cdProduto", cdProduto);
		omprodutoRetorno = (OmProduto) q.uniqueResult();
		if (omprodutoRetorno==null || omprodutoRetorno.getCdProduto()==null || omprodutoRetorno.getCdProduto().equals("") || omprodutoRetorno.getCdProduto().equals("0")){
			return retorno;
		}


		//-- Primeiramente, garante que existe o id_setor no a3_setor
		if (idSetor==0L){
			return retorno;
		}
		q.novaConsulta();
		SpSetor spsetorRetorno = null;
		q.append("SELECT sp");
		q.append("FROM SpSetor sp");
		q.append("WHERE sp.idSetor = :idSetor");
		q.defineParametro("idSetor", new BigDecimal( idSetor) );
		spsetorRetorno = (SpSetor) q.uniqueResult();
		if (spsetorRetorno==null || spsetorRetorno.getIdSetor()==null || spsetorRetorno.getIdSetor().equals(0L) ){
			return retorno;
		}		


		//-- Busca saber se já existe id. Se já existir, Update, senão, Insert.
		q.novaConsulta();
		SpMfv spPersist = null;
		q.append("SELECT sp");
		q.append("FROM SpMfv sp");
		q.append("WHERE sp.cdProduto = :cdProduto ");
		q.append(" and sp.spSetor.idSetor = :idSetor");
		q.defineParametro("cdProduto", cdProduto);
		q.defineParametro("idSetor",  new BigDecimal(  idSetor) );
		spPersist = (SpMfv) q.uniqueResult();
		if (spPersist!=null && spPersist.getIdMfv()!=null && spPersist.getIdMfv().longValue()>0L){
			isInsert = false;
		}

		if(isInsert){
			//-- Insert
			spPersist = null;
			spPersist = new SpMfv();

			spPersist.setCdProduto(cdProduto);
			spPersist.setSpSetor(spsetorRetorno);
			spPersist.setMinLeadtime( new BigDecimal(leadtime));
			spPersist.setSegCicletime(new BigDecimal(cicletime));
			spPersist.setPercOee(new BigDecimal(percoee));
			spPersist.setDtRevisao(cal.getTime());
			spPersist.setDtStativo(cal.getTime());

			this.session.persist(spPersist);
			this.session.flush();

			retorno = spPersist.getIdMfv().longValue();

		} else {
			//Update
			spPersist.setMinLeadtime( new BigDecimal(leadtime));
			spPersist.setSegCicletime(new BigDecimal(cicletime));
			spPersist.setPercOee(new BigDecimal(percoee));
			spPersist.setDtRevisao(cal.getTime());

			this.session.merge(spPersist);
			this.session.flush();

			retorno = spPersist.getIdMfv().longValue();
		}


		return retorno;
	}

	//fa3dela3cascata
	public long deletarA3Cascata(int idSp){
		long retorno = 0L;

		boolean isDelete = false;

		//-- MAIN
		// busca ID; Se existir, Delete
		q.novaConsulta();
		SpMain spPersist = null;
		q.append("SELECT sp");
		q.append("FROM SpMain sp");
		q.append("WHERE sp.idSp = :idSp");
		q.defineParametro("idSp", new BigDecimal(idSp));
		spPersist = (SpMain) q.uniqueResult();
		if(spPersist!=null && spPersist.getIdSp()!=null){
			isDelete =  true;
		}

		if (!isDelete){
			return retorno;
		}

		retorno = spPersist.getIdSp().longValue();


		//-- PROBLEMA
		//Delete PROBLEMA em cascata
		q.novaConsulta();
		SpProblemaDAO daoproblema = new SpProblemaDAO(this.session,  formatoData,  formatoDataHora);
		List<SpProblema> listaproblemas = null;
		q.append("SELECT sp");
		q.append("FROM SpProblema sp");
		q.append("WHERE sp.spMain.idSp = :idSp ");
		q.defineParametro("idSp", new BigDecimal(idSp));
		listaproblemas =  q.list();
		for(SpProblema o : listaproblemas){
			daoproblema.deletarProblemaCascata(o.getIdProblema().longValue());				
		}		


		//Delete A3
		this.session.delete(spPersist);


		return retorno;
	}

}
