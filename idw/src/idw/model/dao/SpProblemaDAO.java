package idw.model.dao;


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.OmUsr;
import idw.model.pojos.SpCausaefeito;
import idw.model.pojos.SpLingua;
import idw.model.pojos.SpMain;
import idw.model.pojos.SpObj;
import idw.model.pojos.SpPlano;
import idw.model.pojos.SpPlanoresp;
import idw.model.pojos.SpProblema;
import idw.model.pojos.SpProblemads;
import idw.model.rn.DataHoraRN;
import idw.webservices.rest.mfv.dto.ProblemaDTO;

public class SpProblemaDAO {

	private final MapQuery q;

	private Session session;


	private final String formatoData;
	private final String formatoDataHora;	


	public SpProblemaDAO(Session session, String formatoData, String formatoDataHora) {
		this.session = session;
		this.formatoData = formatoData;
		this.formatoDataHora = formatoDataHora;		
		q = new MapQuery(session);
	}

	public List<ProblemaDTO> getListaProblema(long idA3) {

		q.novaConsulta();
		List<ProblemaDTO> retorno = null;


		q.append("SELECT  ");
		q.append("	NEW idw.webservices.rest.mfv.dto.ProblemaDTO   ");
		q.append("	(     	 ");
		q.append("	a.idProblema ,   	 ");
		q.append("	probdss.dsProblema ,   	 ");
		q.append("	a.cachep3CiclosbarraIdgt,   	 ");
		q.append("	a.cachep3ParadaspizzaIdgt,   	 ");
		q.append("	a.cachep3DefeitosbarraIdgt, ");
		q.append("	a.cachep3ParadasbarraIdarea, ");
		q.append("	a.cachep7ResultDti,   	 ");
		q.append("	a.cachep7ResultDtf	 ");
		q.append("	)      ");
		q.append("	from idw.model.pojos.SpProblema a  ");
		q.append("	join a.spProblemadses probdss    ");
		q.append("	join probdss.spLingua probdssling    ");
		q.append("	where ");
		q.append("		1=1 ");
		q.append("		and (a.spMain.idSp = :paramida3) ");
		q.append("		and (probdssling.idLingua = 1)  ");
		q.defineParametro("paramida3", new BigDecimal( idA3) );
		retorno = q.list();



		return retorno;
	}

	private SpProblema getProblema(long idProblema){
		SpProblema retorno = null;

		q.novaConsulta();

		//-- Primeiramente, garante que existe o param_ida3 no a3_main

		q.append("SELECT sp");
		q.append("FROM SpProblema sp");
		q.append("WHERE sp.idProblema = :idProblema");
		q.defineParametro("idProblema", new BigDecimal(idProblema));
		retorno = (SpProblema) q.uniqueResult();		

		return retorno;
	}

	public long insertProblema(long idProblema, long idSp, String texto) {
		long retorno = 0;

		q.novaConsulta();

		//-- Primeiramente, garante que existe o param_ida3 no a3_main
		SpMain sp = null;
		q.append("SELECT sp");
		q.append("FROM SpMain sp");
		q.append("WHERE sp.idSp = :idSp");
		q.defineParametro("idSp", new BigDecimal(idSp));
		sp = (SpMain) q.uniqueResult();

		if (sp==null) { return 0;}
		if (sp.getIdSp()==null) { return 0;}


		//-- Busca saber se já existe id_problema. Se já existir, Update, senão, Insert.
		Calendar cal = new GregorianCalendar();
		boolean isUpdate = false;
		q.novaConsulta();
		boolean isInsert = true;
		SpProblema spPersist = null;
		spPersist = this.getProblema(idProblema);
		SpProblemads spPersistDS = null;

		if (spPersist!=null && spPersist.getIdProblema()!=null && spPersist.getIdProblema().longValue()>0L){
			isInsert = false;
		}

		//-- Garante que se passado um ID-inexistente E <>0, retorna sem fazer nada.
		if ( (isInsert) && idProblema!=0L){
			return 0L;
		} 





		if(isInsert){


			//-- Insert
			OmUsr omusr = new OmUsr();
			omusr.setId(1L);
			spPersist = null;
			spPersist = new SpProblema();
			spPersist.setOmUsrByIdUsrativo(omusr);
			spPersist.setOmUsrByIdUsrrevisao(omusr);
			spPersist.setDtStativo(cal.getTime());
			spPersist.setDtRevisao(cal.getTime());
			spPersist.setSpMain(sp);
			spPersist.setCdProblema("");
			spPersist.setStAtivo(new BigDecimal(1L));
			spPersist.setRevisao(new BigDecimal(0L));
			SpProblemads spds = new SpProblemads();

			this.session.persist(spPersist);
			this.session.flush();

			if (spPersist!=null && spPersist.getIdProblema()!=null){

				spPersistDS = new SpProblemads();
				spPersistDS.setSpProblema(spPersist);
				spPersistDS.setSpLingua(new SpLingua( new BigDecimal(1L)));
				spPersistDS.setDsProblema(texto);

				this.session.persist(spPersistDS);
				this.session.flush();

				retorno = spPersist.getIdProblema().longValue();
			}				


		} else
		{
			//Update
			Iterator<SpProblemads> it = null;
			it = spPersist.getSpProblemadses().iterator();
			spPersistDS = (SpProblemads) it.next();
			spPersistDS.setDsProblema(texto);

			this.session.merge(spPersist);
			this.session.flush();

			retorno = spPersist.getIdProblema().longValue();
		}


		return retorno;
	}


	public long insertProblemaNw(
			long idProblema, 
			long idSp, 
			String texto,
			int cachep3ciclosbarraidgt , 
			int cachep3paradaspizzaidgt , 
			int cachep3defeitosbarraidgt , 
			String cachep3paradasbarracdarea , 
			String cachep7resultdti , 
			String cachep7resultdtf 			
			) {
		long retorno = 0;

		q.novaConsulta();



		//-- Busca saber se já existe id_problema. Se já existir, Update, senão, Insert.
		Calendar cal = new GregorianCalendar();
		boolean isUpdate = false;
		q.novaConsulta();
		boolean isInsert = true;
		SpProblema spPersist = null;
		spPersist = this.getProblema(idProblema);
		SpProblemads spPersistDS = null;

		if (spPersist!=null && spPersist.getIdProblema()!=null && spPersist.getIdProblema().longValue()>0L){
			isInsert = false;
		}

		//-- Garante que se passado um ID-inexistente E <>0, retorna sem fazer nada.
		if ( (isInsert) && idProblema!=0L){
			return 0L;
		} 


		Calendar calIni = new GregorianCalendar();
		Calendar calFim = new GregorianCalendar();
		calIni.setTime( DataHoraRN.stringToDate(cachep7resultdti, formatoData)) ;
		calFim.setTime( DataHoraRN.stringToDate(cachep7resultdtf, formatoData) );


		if(isInsert){


			//-- Insert
			SpMain sp = new SpMain();
			sp.setIdSp( new BigDecimal(idSp) );
			OmUsr omusr = new OmUsr();
			omusr.setId(1L);
			spPersist = null;
			spPersist = new SpProblema();
			spPersist.setOmUsrByIdUsrativo(omusr);
			spPersist.setOmUsrByIdUsrrevisao(omusr);
			spPersist.setDtStativo(cal.getTime());
			spPersist.setDtRevisao(cal.getTime());
			spPersist.setSpMain(sp);
			spPersist.setCdProblema("");
			spPersist.setStAtivo(new BigDecimal(1L));
			spPersist.setRevisao(new BigDecimal(0L));
			SpProblemads spds = new SpProblemads();

			this.session.persist(spPersist);
			this.session.flush();

			if (spPersist!=null && spPersist.getIdProblema()!=null){

				spPersistDS = new SpProblemads();
				spPersistDS.setSpProblema(spPersist);
				spPersistDS.setSpLingua(new SpLingua( new BigDecimal(1L)));
				spPersistDS.setDsProblema(texto);

				this.session.persist(spPersistDS);
				this.session.flush();

				retorno = spPersist.getIdProblema().longValue();
			}				


		} else
		{
			//Update
			Iterator<SpProblemads> it = null;
			it = spPersist.getSpProblemadses().iterator();
			spPersistDS = (SpProblemads) it.next();
			spPersistDS.setDsProblema(texto);

			spPersist.setCachep3CiclosbarraIdgt(new BigDecimal(cachep3ciclosbarraidgt));
			spPersist.setCachep3ParadaspizzaIdgt(new BigDecimal(cachep3paradaspizzaidgt));
			spPersist.setCachep3DefeitosbarraIdgt(new BigDecimal(cachep3defeitosbarraidgt));
			spPersist.setCachep3ParadasbarraIdarea(new BigDecimal(cachep3paradasbarracdarea));
			spPersist.setCachep7ResultDti(calIni.getTime());
			spPersist.setCachep7ResultDtf(calFim.getTime());

			this.session.merge(spPersist);
			this.session.flush();

			retorno = spPersist.getIdProblema().longValue();
		}


		return retorno;
	}


	//fa3delproblemacascata
	public long deletarProblemaCascata(long idProblema){
		long retorno = 0L;


		//-- Busca saber se existe param_idproblema na tabela a deletar. Se existir, Delete
		q.novaConsulta();
		SpProblema spPersist = null;
		q.append("SELECT sp");
		q.append("FROM SpProblema sp ");
		q.append("LEFT JOIN FETCH sp.spProblemadses dss ");
		q.append("WHERE sp.idProblema = :idProblema ");
		q.defineParametro("idProblema", new BigDecimal(idProblema));
		spPersist = (SpProblema) q.uniqueResult();			
		boolean isDelete = true;
		if (spPersist==null || spPersist.getIdProblema()==null ){
			isDelete = false;
		}

		if(!isDelete){
			return retorno;
		}


		//-- CausaEfeito
		q.novaConsulta();
		SpCausaDAO daocausa = new SpCausaDAO(this.session);
		List<SpCausaefeito> listacausaefeitos = null;
		q.append("SELECT sp");
		q.append("FROM SpCausaefeito sp");
		q.append("WHERE sp.spProblema.idProblema = :idProblema ");
		q.defineParametro("idProblema", new BigDecimal(idProblema));
		listacausaefeitos =  q.list();
		for(SpCausaefeito o : listacausaefeitos){
			daocausa.deletarCausaEfeito(o.getIdCausaefeito().longValue(), 6);				
		}


		//-- Plano
		q.novaConsulta();
		List<SpPlano> listaplanos = null;
		q.append("SELECT sp");
		q.append("FROM SpPlano sp");
		q.append("WHERE sp.spProblema.idProblema = :idProblema ");
		q.defineParametro("idProblema", new BigDecimal(idProblema));
		listaplanos =  q.list();
		SpPlanoDAO daoplano = new SpPlanoDAO(this.session, formatoData, formatoDataHora);
		SpPlano plano = null;
		for(SpPlano o : listaplanos){
			plano = daoplano.getPlano(o.getIdPlano().longValue());
			if (plano.getSpPlanoresps()!=null){
				for (SpPlanoresp pr : plano.getSpPlanoresps()){
					this.session.delete(pr);
				}
			}
			this.session.delete(plano);				
		}


		//-- Objetivo
		q.novaConsulta();
		List<SpObj> listaobj = null;
		q.append("SELECT sp");
		q.append("FROM SpObj sp");
		q.append("WHERE sp.spProblema.idProblema = :idProblema ");
		q.defineParametro("idProblema", new BigDecimal(idProblema));
		listaobj =  q.list();
		SpObjDAO daoobj = new SpObjDAO(this.session);
		SpObj objetivo = null;
		for(SpObj o : listaobj){
			objetivo = daoobj.getObjetivo(o.getIdObj().longValue());
			this.session.delete(objetivo);				
		}

		// -- Delete PROBLEMA propriamente. primeiro DS e em seguida o Principal.
		if(spPersist.getSpProblemadses()!=null && spPersist.getSpProblemadses().size()>0){
			for (SpProblemads ds : spPersist.getSpProblemadses()){
				this.session.delete(ds);
			}
		}
		this.session.delete(spPersist);


		retorno = spPersist.getIdProblema().longValue();

		return retorno;
	}	

}
