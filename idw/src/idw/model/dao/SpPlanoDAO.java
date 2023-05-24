package idw.model.dao;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.OmUsr;
import idw.model.pojos.SpPlano;
import idw.model.pojos.SpPlanoresp;
import idw.model.pojos.SpProblema;
import idw.model.rn.DataHoraRN;
import idw.model.rn.UsuarioRN;
import idw.webservices.rest.mfv.PlanoResource;

public class SpPlanoDAO {

	private final MapQuery q;
	private Session session;

	private final String formatoData;
	private final String formatoDataHora;	

	public SpPlanoDAO(Session session, String formatoData, String formatoDataHora) {
		this.session = session;
		this.formatoData = formatoData;
		this.formatoDataHora = formatoDataHora;
		q = new MapQuery(session);
	}

	public SpPlano getPlano(long idPlano) {
		SpPlano retorno = null;
		q.novaConsulta();
		q.append("SELECT spPlano");
		q.append("FROM SpPlano spPlano");
		q.append("LEFT JOIN FETCH spPlano.spPlanoresps planoresps ");		
		q.append("WHERE spPlano.idPlano = :idPlano");

		q.defineParametro("idPlano", new BigDecimal(idPlano));
		retorno = (SpPlano) q.uniqueResult();

		return retorno ;
	}

	public List<SpPlano> getListaPlanos(int idProblema) {
		q.novaConsulta();
		q.append("SELECT spPlano");
		q.append("FROM SpPlano spPlano ");
		q.append("INNER JOIN spPlano.spProblema spProblema");
		q.append("WHERE spProblema.idProblema = :idProblema");

		q.defineParametro("idProblema", new BigDecimal(idProblema));

		return q.list();
	}


	public List<SpPlanoresp> getListaPlanoresps(long idplano) {

		OmUsr omusrinternoa3 = null;
		omusrinternoa3 = getOmUsrInternoA3();
		
		q.novaConsulta();
		q.append("select a  ");
		q.append("from SpPlanoresp a ");
		q.append("join fetch a.omUsr u ");
		q.append("where a.spPlano.idPlano = :idplano ");
		
		if (omusrinternoa3!=null && omusrinternoa3.getIdUsr()>0L){//NÃO trazer os internos
			q.append(" and u.idUsr <> :idomusrinternoa3 ");			
			q.defineParametro("idomusrinternoa3", new Long(omusrinternoa3.getIdUsr()));
		}

		q.defineParametro("idplano", new BigDecimal(idplano));

		return q.list();
	}

	public SpPlanoresp getPlanoresp(long idplanoresp) {

		SpPlanoresp retorno = null;

		q.novaConsulta();
		q.append("select a  ");
		q.append("from SpPlanoresp a ");
		q.append("join fetch a.omUsr u ");
		q.append("where a.idPlanoresp = :idplanoresp ");


		q.defineParametro("idplanoresp", new BigDecimal(idplanoresp));
		retorno = (SpPlanoresp) q.uniqueResult();

		return retorno;
	}    



	public long insertPlano(
			long idPlano 
			, long idProblema
			, String problemaoque 
			, String acaocomo
			, String prazoiniquando
			, String prazofimquando
			, int statuspercconclusao
			) {

		long retorno = 0L;

		//    	//-- Primeiramente, garante que existe o param_idproblema no a3_problema
		q.novaConsulta();

		SpPlano spPersist = null;



		Calendar calIni = new GregorianCalendar();
		Calendar calFim = new GregorianCalendar();
		Calendar valdtalerta = new GregorianCalendar();
		calIni.setTime( DataHoraRN.stringToDate(prazoiniquando, PlanoResource.FORMATO_DATA)) ;
		calFim.setTime( DataHoraRN.stringToDate(prazofimquando, PlanoResource.FORMATO_DATA) );

		if (calFim.before(calIni)){
			calFim = (Calendar) calIni.clone();
			calFim.add(Calendar.DAY_OF_MONTH, 1);
		}


		boolean isUpdate = false;
		long idval = 0L;
		long idvalidproblema = 0L;
		if (prazofimquando != null) {
			valdtalerta = (Calendar)  calFim.clone();
			valdtalerta.add(Calendar.DAY_OF_MONTH, 1);
		}


		//-- Primeiramente, garante que existe o param_idproblema no a3_problema
		q.novaConsulta();
		SpProblema retornoSpProblema = null;

		q.append("SELECT sp");
		q.append("FROM SpProblema sp");
		q.append("WHERE sp.idProblema = :idProblema");
		q.defineParametro("idProblema", new BigDecimal(idProblema));
		retornoSpProblema = (SpProblema) q.uniqueResult();
		if (retornoSpProblema!=null && retornoSpProblema.getIdProblema()!=null && retornoSpProblema.getIdProblema().longValue()>0L){

			//-- Busca saber se já existe param_id. Se já existir, Update, senão, Insert.
			boolean isInsert = true; // verifica se é mesmo INSERT ou se já existe e deve-se fazer UPDATE
			spPersist = this.getPlano(idPlano);
			if (spPersist!=null && spPersist.getIdPlano()!=null && spPersist.getIdPlano().longValue()>0L){
				isInsert = false;
			}

			//-- Garante que se passado um ID-inexistente E <>0, retorna sem fazer nada.
			if ( (isInsert) && idPlano!=0L){
				return 0L;
			}

			if(isInsert){
				//-- Insert
				spPersist = null;
				spPersist = new SpPlano();
				spPersist.setIdUsrativo( new BigDecimal(1L));
				spPersist.setIdUsrrevisao( new BigDecimal(1L));

				spPersist.setSpProblema(retornoSpProblema);
				spPersist.setProblemaOque(problemaoque);
				spPersist.setAcaoComo(acaocomo);
				spPersist.setPrazoiniQuando(calIni.getTime());
				spPersist.setPrazofimQuando(calFim.getTime());
				spPersist.setStatusPercconclusao( new BigDecimal(statuspercconclusao) );
				spPersist.setDtalertafim(valdtalerta.getTime());
				spPersist.setDtRevisao(new Date());
				spPersist.setDtStativo(new Date());

				this.session.persist(spPersist);
				this.session.flush();

				retorno = spPersist.getIdPlano().longValue();

			} else
			{
				//Update
				spPersist.setProblemaOque(problemaoque);
				spPersist.setAcaoComo(acaocomo);
				spPersist.setPrazoiniQuando(calIni.getTime());
				spPersist.setPrazofimQuando(calFim.getTime());
				spPersist.setStatusPercconclusao( new BigDecimal(statuspercconclusao) );
				spPersist.setDtalertafim(valdtalerta.getTime());
				spPersist.setDtRevisao(new Date());

				this.session.merge(spPersist);
				this.session.flush();

				retorno = spPersist.getIdPlano().longValue();
			}

		}
		return retorno;
	}        




	public long insertPlanoresp(
			long idPlanoresp 
			, long idPlano
			, OmUsr omusuario 

			) {

		long retorno = 0L;

		//    	//-- Primeiramente, garante que existe o param_idproblema no a3_problema
		q.novaConsulta();

		SpPlano spPlano = null;
		SpPlanoresp spPersist = null;




		Calendar calDtprazofinal = new GregorianCalendar();
		Calendar calDtalertafim = new GregorianCalendar();




		boolean isUpdate = false;
		long idval = 0L;


		q.novaConsulta();
		spPlano = this.getPlano(idPlano);
		Date dtprazofinal = null;
		if (spPlano!=null && spPlano.getIdPlano()!=null && spPlano.getIdPlano().longValue()>0L){
			dtprazofinal = spPlano.getPrazofimQuando();
			calDtprazofinal.setTime(dtprazofinal);
		}
		if (spPlano==null) { return 0;}
		if (spPlano.getIdPlano()==null) { return 0;}
		if (spPlano.getIdPlano().equals(new BigDecimal(0L))) { return 0;}

		if (dtprazofinal != null) {

			calDtalertafim = (Calendar) calDtprazofinal.clone();
			calDtalertafim.add(Calendar.DAY_OF_MONTH, 1);

		}


		////-- Primeiramente, garante que existe o param_idproblema no a3_problema
		q.novaConsulta();



		//-- Busca saber se já existe param_id. Se já existir, Update, senão, Insert.
		boolean isInsert = true; // verifica se é mesmo INSERT ou se já existe e deve-se fazer UPDATE
		spPersist = this.getPlanoresp(idPlanoresp);
		if (spPersist!=null && spPersist.getIdPlanoresp()!=null && spPersist.getIdPlanoresp().longValue()>0L){
			isInsert = false;
		}

		//-- Garante que se passado um ID-inexistente E <>0, retorna sem fazer nada.
		if ( (isInsert) && idPlanoresp!=0L){
			return 0L;
		}

		if(isInsert){
			//-- Insert
			spPersist = null;
			spPersist = new SpPlanoresp();
			spPersist.setSpPlano(spPlano);
			spPersist.setOmUsr(omusuario);
			spPersist.setDtalertafim(calDtalertafim.getTime());

			this.session.persist(spPersist);
			this.session.flush();

			retorno = spPersist.getIdPlanoresp().longValue();

		} else
		{
			//Update


			spPersist.setOmUsr(omusuario);
			spPersist.setDtalertafim(calDtalertafim.getTime());

			this.session.merge(spPersist);
			this.session.flush();

			retorno = spPersist.getIdPlanoresp().longValue();
		}

		//}
		return retorno;
	}
	
	public OmUsr getOmUsrInternoA3() {

		OmUsr retorno = null;

		q.novaConsulta();
		q.append("select a from OmUsr a where a.login='a3' and a.stAtivo=1 ");
		
		q.setMaxResults(1);
		retorno = (OmUsr) q.uniqueResult();

		return retorno;
	}    
	

	public SpPlanoresp getSpPlanorespExisteComPlanoUsrInternoA3(long idplano, long idusrinternoa3 ) {

		SpPlanoresp retorno = null;

		q.novaConsulta();
		
		q.append("select a ");
		q.append("from SpPlanoresp a ");
		q.append("where ");
		q.append("a.spPlano.idPlano=:idplano");
		q.append("and a.omUsr.idUsr=:idusrinternoa3");

		q.setMaxResults(1);
		
		q.defineParametro("idplano", new BigDecimal(idplano));
		q.defineParametro("idusrinternoa3", new Long(idusrinternoa3));

		retorno = (SpPlanoresp) q.uniqueResult();

		return retorno;
	}    
	
}
