package idw.model.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.OmUsr;
import idw.model.pojos.SpCatcausa;
import idw.model.pojos.SpCausa;
import idw.model.pojos.SpCausads;
import idw.model.pojos.SpCausaefeito;
import idw.model.pojos.SpLingua;
import idw.model.pojos.SpPlano;
import idw.model.pojos.SpProblema;
import idw.util.UtilsString;
import idw.webservices.rest.mfv.dto.CausaEfeitoDTO;

public class SpCausaDAO {

	private final MapQuery q;
	private Session session;


	public SpCausaDAO(Session session) {
		this.session = session;
		q = new MapQuery(session);
	}

	public SpCausa getCausa(long idCausa) {
		q.novaConsulta();

		q.append("SELECT spCausa");
		q.append("FROM SpCausa spCausa");
		q.append("LEFT JOIN FETCH spCausa.spCausadses spCausads");
		q.append("WHERE spCausa.idCausa = :idCausa");

		q.defineParametro("idCausa", new BigDecimal(idCausa));

		return (SpCausa) q.uniqueResult();
	}

	public SpCausads getCausaDs(int idCausa) {
		q.novaConsulta();

		q.append("SELECT spCausads");
		q.append("FROM SpCausads spCausads");
		q.append("WHERE spCausads.spCausa.idCausa = :idCausa");

		q.defineParametro("idCausa", new BigDecimal(idCausa));

		return (SpCausads) q.uniqueResult();
	}

	public List<SpCausads> getCausaDses(long idCausa) {
		q.novaConsulta();
		List<SpCausads> retorno = null;

		q.append("SELECT spCausads");
		q.append("FROM SpCausads spCausads");
		q.append("WHERE spCausads.spCausa.idCausa = :idCausa");

		q.defineParametro("idCausa", new BigDecimal(idCausa));
		retorno = q.list();

		return retorno;
	}    

	public List<SpCausaefeito> getListaCausaEfeitoOLD(long idCausaEfeito, long nivelMaximo) {
		// select multiniveis para usar internamente em fa3deletecausaefeito
		q.novaConsulta();

		if(nivelMaximo <= 0) {
			nivelMaximo = 5;
		}

		q.append("SELECT");

		String select = "";
		for(int contador = 1; contador <= nivelMaximo; contador++) {
			select += "spCausaefeito" + contador + ",";
		}
		select = UtilsString.removerUltimoCaracter(select);

		q.append(select);

		q.append("FROM SpCausaefeito spCausaefeito1");

		if(nivelMaximo > 1) {
			for(int contador = 2; contador <= nivelMaximo; contador++) {
				q.append("LEFT JOIN spCausaefeito" + (contador - 1) + ".spCausaefeitos AS spCausaefeito" + contador);
			}
		}

		q.append("WHERE spCausaefeito1.spCausaefeito.idCausaefeito = :idCausaEfeito");

		q.append("ORDER BY");

		String orderBy = "";
		for(int contador = 1; contador <= nivelMaximo; contador++) {
			orderBy += "spCausaefeito" + contador + ".idCausaefeito,";
		}
		orderBy = UtilsString.removerUltimoCaracter(orderBy);

		q.append(orderBy);

		q.defineParametro("idCausaEfeito", new BigDecimal(idCausaEfeito));

		List<SpCausaefeito> listaRetorno = new ArrayList<SpCausaefeito>();
		List<Object> listaConsulta = q.list();

		if(listaConsulta != null && listaConsulta.size() > 0) {
			Object[] causaEfeitosArray = (Object[]) listaConsulta.get(0);
			for(Object o : causaEfeitosArray) {
				listaRetorno.add((SpCausaefeito) o);
			}
		}

		return listaRetorno;
	}


	public List<SpCausaefeito> getListaCausaEfeito(long idCausaEfeito, long nivelMaximo) {
		// select multiniveis para usar internamente em fa3deletecausaefeito

		if(nivelMaximo <= 0) {
			nivelMaximo = 5;
		}

		List<SpCausaefeito> listaRetorno = new ArrayList<SpCausaefeito>();
		List<SpCausaefeito> lista = new ArrayList<SpCausaefeito>();
		List<SpCausaefeito> listaFilhosNivel1 = new ArrayList<SpCausaefeito>();//TODO: fixo 5 levels
		List<SpCausaefeito> listaFilhosNivel2 = new ArrayList<SpCausaefeito>();
		List<SpCausaefeito> listaFilhosNivel3 = new ArrayList<SpCausaefeito>();
		List<SpCausaefeito> listaFilhosNivel4 = new ArrayList<SpCausaefeito>();
		List<SpCausaefeito> listaFilhosNivel5 = new ArrayList<SpCausaefeito>();

		q.novaConsulta();
		q.append("SELECT  ");
		q.append(" a ");
		q.append("FROM  ");
		q.append(" SpCausaefeito as a  ");
		q.append("WHERE  ");
		q.append(" a.spCausaefeito.idCausaefeito = :idCausaEfeito ");
		q.defineParametro("idCausaEfeito", new BigDecimal(idCausaEfeito));
		listaFilhosNivel1 = q.list();	

		for (SpCausaefeito a : listaFilhosNivel1){
			lista = null;
			q.novaConsulta();
			q.append("SELECT  ");
			q.append(" a ");
			q.append("FROM  ");
			q.append(" SpCausaefeito as a  ");
			q.append("WHERE  ");
			q.append(" a.spCausaefeito.idCausaefeito = :idCausaEfeito ");
			q.defineParametro("idCausaEfeito", a.getIdCausaefeito());
			lista = q.list();
			listaFilhosNivel2.addAll(lista);
		}
		for (SpCausaefeito a : listaFilhosNivel2){
			lista = null;
			q.novaConsulta();
			q.append("SELECT  ");
			q.append(" a ");
			q.append("FROM  ");
			q.append(" SpCausaefeito as a  ");
			q.append("WHERE  ");
			q.append(" a.spCausaefeito.idCausaefeito = :idCausaEfeito ");
			q.defineParametro("idCausaEfeito", a.getIdCausaefeito());
			lista = q.list();
			listaFilhosNivel3.addAll(lista);
		}
		for (SpCausaefeito a : listaFilhosNivel3){
			lista = null;
			q.novaConsulta();
			q.append("SELECT  ");
			q.append(" a ");
			q.append("FROM  ");
			q.append(" SpCausaefeito as a  ");
			q.append("WHERE  ");
			q.append(" a.spCausaefeito.idCausaefeito = :idCausaEfeito ");
			q.defineParametro("idCausaEfeito", a.getIdCausaefeito());
			lista = q.list();
			listaFilhosNivel4.addAll(lista);
		}
		for (SpCausaefeito a : listaFilhosNivel4){
			lista = null;
			q.novaConsulta();
			q.append("SELECT  ");
			q.append(" a ");
			q.append("FROM  ");
			q.append(" SpCausaefeito as a  ");
			q.append("WHERE  ");
			q.append(" a.spCausaefeito.idCausaefeito = :idCausaEfeito ");
			q.defineParametro("idCausaEfeito", a.getIdCausaefeito());
			lista = q.list();
			listaFilhosNivel5.addAll(lista);
		}


		if (listaFilhosNivel5!=null && listaFilhosNivel5.size()>0){
			listaRetorno.addAll(listaFilhosNivel5);
		}
		if (listaFilhosNivel4!=null && listaFilhosNivel4.size()>0){
			listaRetorno.addAll(listaFilhosNivel4);
		}
		if (listaFilhosNivel3!=null && listaFilhosNivel3.size()>0){
			listaRetorno.addAll(listaFilhosNivel3);
		}
		if (listaFilhosNivel2!=null && listaFilhosNivel2.size()>0){
			listaRetorno.addAll(listaFilhosNivel2);
		}
		if (listaFilhosNivel1!=null && listaFilhosNivel1.size()>0){
			listaRetorno.addAll(listaFilhosNivel1);
		}

		return listaRetorno;
	}    

	public List<CausaEfeitoDTO> getCausaEfeitoFilhosParaCausaEfeitoPai(long idProblema, long idCausaEfeitoPai) {
		List<CausaEfeitoDTO> retorno = null;

		q.novaConsulta();


		// se PAI NULO (idCausaEfeitoPai==0L)... 
		if (idCausaEfeitoPai==0L){

			q.append("SELECT NEW idw.webservices.rest.mfv.dto.CausaEfeitoDTO");
			q.append("(   ");
			q.append("catcau.idCatcausa, ");
			q.append("catcauds.dsCatcausa, ");
			q.append("a.idCausaefeito, ");
			q.append("cepai.idCausaefeito, ");
			q.append("caudspai.idCausads, ");
			q.append("caudspai.dsCausa, ");
			q.append("cau.idCausa, ");
			q.append("cauds.dsCausa ");
			q.append(")   ");
			q.append("from  ");
			q.append("SpCausaefeito a  ");
			q.append("join a.spProblema p ");
			q.append("join p.spProblemadses pds ");
			q.append("join a.spCatcausa catcau ");
			q.append("join catcau.spCatcausadses catcauds ");
			q.append("join a.spCausa cau ");
			q.append("join cau.spCausadses cauds ");
			q.append("left join a.spCausaefeito cepai  ");
			q.append("left join cepai.spCausa.spCausadses caudspai  ");
			q.append("where  ");
			q.append("1=1 ");
			q.append("and pds.spLingua.idLingua=1 ");
			q.append("and catcauds.spLingua.idLingua=1 ");
			q.append("and cauds.spLingua.idLingua=1 ");
			q.append("and ( (cepai is null) or ( (cepai is not null) and (caudspai.spLingua.idLingua=1) ) ) ");
			q.append("and a.spProblema.idProblema= :idprob ");
			q.append("and cepai.idCausaefeito IS NULL ");
			q.append("order by a.spCausaefeito.idCausaefeito desc, catcau.idCatcausa, a.idCausaefeito, cau.idCausa ");
			q.defineParametro("idprob", new BigDecimal(idProblema));

		} else {
			q.append("SELECT NEW idw.webservices.rest.mfv.dto.CausaEfeitoDTO");
			q.append("(   ");
			q.append("catcau.idCatcausa, ");
			q.append("catcauds.dsCatcausa, ");
			q.append("a.idCausaefeito, ");
			q.append("cepai.idCausaefeito, ");
			q.append("caudspai.idCausads, ");
			q.append("caudspai.dsCausa, ");
			q.append("cau.idCausa, ");
			q.append("cauds.dsCausa ");
			q.append(")   ");
			q.append("from  ");
			q.append("SpCausaefeito a  ");
			q.append("join a.spProblema p ");
			q.append("join p.spProblemadses pds ");
			q.append("join a.spCatcausa catcau ");
			q.append("join catcau.spCatcausadses catcauds ");
			q.append("join a.spCausa cau ");
			q.append("join cau.spCausadses cauds ");
			q.append("left join a.spCausaefeito cepai  ");
			q.append("left join cepai.spCausa.spCausadses caudspai  ");
			q.append("where  ");
			q.append("1=1 ");
			q.append("and pds.spLingua.idLingua=1 ");
			q.append("and catcauds.spLingua.idLingua=1 ");
			q.append("and cauds.spLingua.idLingua=1 ");
			q.append("and ( (cepai is null) or ( (cepai is not null) and (caudspai.spLingua.idLingua=1) ) ) ");
			q.append("and a.spProblema.idProblema= :idprob ");
			q.append("and cepai.idCausaefeito = :idcaePai ");
			q.append("order by a.spCausaefeito.idCausaefeito desc, catcau.idCatcausa, a.idCausaefeito, cau.idCausa ");
			q.defineParametro("idprob", new BigDecimal(idProblema));
			q.defineParametro("idcaePai", new BigDecimal(idCausaEfeitoPai));
		}




		retorno = q.list();

		return retorno;

	}


	//fa3insertupdatecausa
	public long insertCausa(long idCausa, String texto) {

		long retorno = 0L;

		//    	//-- Primeiramente, garante que existe o param_idproblema no a3_problema
		q.novaConsulta();

		SpCausa spPersist = null;
		SpCausads spPersistDS = null;

		//-- Busca saber se já existe param_id. Se já existir, Update, senão, Insert.
		boolean isInsert = true; // verifica se é mesmo INSERT ou se já existe e deve-se fazer UPDATE
		spPersist = this.getCausa(idCausa);
		if (spPersist!=null && spPersist.getIdCausa()!=null && spPersist.getIdCausa().longValue()>0L){
			isInsert = false;
		}

		//-- Garante que se passado um ID-inexistente E <>0, retorna sem fazer nada.
		if ( (isInsert) && idCausa!=0L){
			return 0L;
		}

		if(isInsert){
			//-- Insert
			spPersist = null;
			spPersist = new SpCausa();
			OmUsr omusr = new OmUsr();
			omusr.setIdUsr(  1L);
			spPersist.setOmUsrByIdUsrativo(omusr);
			spPersist.setOmUsrByIdUsrrevisao(omusr);
			spPersist.setDtRevisao(new Date());
			spPersist.setDtStativo(new Date());

			this.session.persist(spPersist);
			this.session.flush();
			if (spPersist!=null && spPersist.getIdCausa()!=null){

				spPersistDS = new SpCausads();
				spPersistDS.setSpCausa(spPersist);
				spPersistDS.setSpLingua(new SpLingua( new BigDecimal(1L)));
				spPersistDS.setDsCausa(texto);

				this.session.persist(spPersistDS);
				this.session.flush();

				retorno = spPersist.getIdCausa().longValue();
			}
		} else
		{
			//Update
			Iterator<SpCausads> it = null;
			it = spPersist.getSpCausadses().iterator();
			spPersistDS = (SpCausads) it.next();
			spPersistDS.setDsCausa(texto);
			this.session.merge(spPersist);
			this.session.flush();

			retorno = spPersist.getIdCausa().longValue();
		}


		//}
		return retorno;
	}    



	//fa3insertupdatecausaefeito
	public CausaEfeitoDTO insertCausaEfeito(
			long idProblema
			, long idCatCausa 
			, long idCausaEfeito
			, long idCausa 
			, String textocausa 
			, long idCausaEfeitoPai

			) {


		CausaEfeitoDTO retorno = null;

		boolean isUpdate = false;

		//--  garante que existe o param_idproblema no a3_problema
		q.novaConsulta();
		SpProblema retornoSpProblema = null;
		q.append("SELECT sp");
		q.append("FROM SpProblema sp");
		q.append("WHERE sp.idProblema = :idProblema");
		q.defineParametro("idProblema", new BigDecimal(idProblema));
		retornoSpProblema = (SpProblema) q.uniqueResult();
		if (retornoSpProblema==null){
			return null;
		}
		if (retornoSpProblema!=null && retornoSpProblema.getIdProblema()==null){
			return null;
		}
		if (retornoSpProblema!=null && retornoSpProblema.getIdProblema()!=null && retornoSpProblema.getIdProblema().equals(0L)){
			return null;
		}


		//-- garante que existe o param_idcatcausa no a3_catcausa
		q.novaConsulta();
		SpCatcausa retornoSpCatcausa = null;
		q.append("SELECT sp");
		q.append("FROM SpCatcausa sp");
		q.append("WHERE sp.idCatcausa = :idCatCausa");
		q.defineParametro("idCatCausa", new BigDecimal(idCatCausa));
		retornoSpCatcausa = (SpCatcausa) q.uniqueResult();
		if (retornoSpCatcausa==null){
			return null;
		}
		if (retornoSpCatcausa!=null && retornoSpCatcausa.getIdCatcausa()==null){
			return null;
		}
		if (retornoSpCatcausa!=null && retornoSpCatcausa.getIdCatcausa()!=null && retornoSpCatcausa.getIdCatcausa().equals(0L)){
			return null;
		}


		SpCausaefeito retornoSpCausaefeitopai = null;
		if (idCausaEfeitoPai!=0L){
			//-- caso [param_idcausaefeitopai]<>null garante que existe o
			//param_idcausaefeitopai no a3_causaefeito
			q.novaConsulta();
			q.append("SELECT sp");
			q.append("FROM SpCausaefeito sp ");
			q.append(" LEFT JOIN FETCH sp.spCausa spcau ");
			q.append("WHERE sp.idCausaefeito = :idCausaEfeitoPai");
			q.defineParametro("idCausaEfeitoPai", new BigDecimal(idCausaEfeitoPai));
			retornoSpCausaefeitopai = (SpCausaefeito) q.uniqueResult();
			if (retornoSpCausaefeitopai==null){
				return null;
			}
			if (retornoSpCausaefeitopai!=null && retornoSpCausaefeitopai.getIdCausaefeito()==null){
				return null;
			}
			if (retornoSpCausaefeitopai!=null && retornoSpCausaefeitopai.getIdCausaefeito()!=null && retornoSpCausaefeitopai.getIdCausaefeito().equals(0L)){
				return null;
			}

		}

		//-- TRATA CAUSAEFEITO

		//-- Busca saber se já existe param_idcausaefeito. Se já existir, Update, senão, Insert.

		q.novaConsulta();
		SpCausaefeito spPersist = null;
		q.append("SELECT sp");
		q.append("FROM SpCausaefeito sp ");
		q.append(" left join fetch sp.spCausaefeito pai ");
		q.append(" left join fetch pai.spCausa caupai ");
		q.append("WHERE sp.idCausaefeito = :idCausaEfeito");
		q.defineParametro("idCausaEfeito", new BigDecimal(idCausaEfeito));
		spPersist = (SpCausaefeito) q.uniqueResult();

		//-- Busca saber se já existe param_id. Se já existir, Update, senão, Insert.
		boolean isInsert = true; // verifica se é mesmo INSERT ou se já existe e deve-se fazer UPDATE
		if (spPersist!=null && spPersist.getIdCausaefeito()!=null && spPersist.getIdCausaefeito().longValue()>0L){
			isInsert = false;
		}

		//-- Garante que se passado um ID-inexistente E <>0, retorna sem fazer nada.
		if ( (isInsert) && idCausaEfeito!=0L){
			return null;
		}

		//-- primeiro fa3insertupdatecausa - tanto faz se isUpdate = true ou false
		long idcausaretorno = 0L;
		idcausaretorno = insertCausa(idCausa, textocausa);
		if (idcausaretorno==0L){
			return null;
		}

		BigDecimal idcasaefeitopai = null;
		BigDecimal idcausapai = null;
		String cdcausapai = null;


		if(isInsert){
			//-- Insert
			spPersist = null;
			spPersist = new SpCausaefeito();

			spPersist.setSpCausaefeito(retornoSpCausaefeitopai);
			SpCausa spCausa = new SpCausa();
			spCausa = getCausa(idcausaretorno);

			spPersist.setSpCausa(spCausa);
			spPersist.setSpCatcausa(retornoSpCatcausa);
			spPersist.setSpProblema(retornoSpProblema);

			this.session.persist(spPersist);
			this.session.flush();

			if (spPersist.getSpCausaefeito()!=null && spPersist.getSpCausaefeito().getIdCausaefeito()!=null){
				idcasaefeitopai = spPersist.getSpCausaefeito().getIdCausaefeito();
				if (spPersist.getSpCausaefeito().getSpCausa()!=null && spPersist.getSpCausaefeito().getSpCausa().getIdCausa()!=null){
					idcausapai = spPersist.getSpCausaefeito().getSpCausa().getIdCausa();
				}
				SpCausa spcausapai = null;
				if (idcausapai!=null && !idcausapai.equals( new BigDecimal(0L))){
					spcausapai = getCausa(idcausaretorno);
				}
				if (spcausapai!=null && spcausapai.getCdCausa()!=null){
					cdcausapai = spPersist.getSpCausaefeito().getSpCausa().getCdCausa();
				}
			}

			retorno = new CausaEfeitoDTO(
					spPersist.getSpProblema().getIdProblema(),
					spPersist.getSpCatcausa().getIdCatcausa(),
					spPersist.getSpCatcausa().getCdCatcausa(),
					spPersist.getIdCausaefeito(),
					idcasaefeitopai,
					idcausapai,
					cdcausapai,
					spPersist.getSpCausa().getIdCausa(),
					spPersist.getSpCausa().getCdCausa()
					);

		} else
		{
			//Update
			spPersist.setSpCausaefeito(retornoSpCausaefeitopai);
			SpCausa spCausa = new SpCausa();
			spCausa = getCausa(idcausaretorno);
			spPersist.setSpCausa(spCausa);

			this.session.merge(spPersist);
			this.session.flush();


			if (spPersist.getSpCausaefeito()!=null && spPersist.getSpCausaefeito().getIdCausaefeito()!=null){
				idcasaefeitopai = spPersist.getSpCausaefeito().getIdCausaefeito();
				if (spPersist.getSpCausaefeito().getSpCausa()!=null && spPersist.getSpCausaefeito().getSpCausa().getIdCausa()!=null){
					idcausapai = spPersist.getSpCausaefeito().getSpCausa().getIdCausa();
				}
				SpCausa spcausapai = null;
				if (idcausapai!=null && !idcausapai.equals( new BigDecimal(0L))){
					spcausapai = getCausa(idcausaretorno);
				}
				if (spcausapai!=null && spcausapai.getCdCausa()!=null){
					cdcausapai = spPersist.getSpCausaefeito().getSpCausa().getCdCausa();
				}
			}

			retorno = new CausaEfeitoDTO(
					spPersist.getSpProblema().getIdProblema(),
					spPersist.getSpCatcausa().getIdCatcausa(),
					spPersist.getSpCatcausa().getCdCatcausa(),
					spPersist.getIdCausaefeito(),
					idcasaefeitopai,
					idcausapai,
					cdcausapai,
					spPersist.getSpCausa().getIdCausa(),
					spPersist.getSpCausa().getCdCausa()
					);
		}
		return retorno;
	}


	//fa3deletecausaefeito
	public long deletarCausaEfeito(long idCausaEfeito, int nivelMaximo){
		long id = 0L;

		List<SpCausaefeito> listaCausaefeito = null;
		listaCausaefeito = this.getListaCausaEfeito(idCausaEfeito, 5);

		if(listaCausaefeito!=null && listaCausaefeito.size()>0){

			for (SpCausaefeito a : listaCausaefeito){

				BigDecimal idcausa = null;
				idcausa = a.getSpCausa().getIdCausa();
				SpCausa spcausapersistido = this.getCausa(a.getSpCausa().getIdCausa().longValue());

				//-- delete causaefeito
				this.session.delete(a);


				//-- causa
				//-- CAUSA em OUTRO CausaEfeito
				//-- Busca saber se já existe val_idcausa em [a3_causaefeito] para OUTRO <> de [val_idcausaefeito]. Se existir, NÃO Delete o CAUSA. Senão, DELETE.
				q.novaConsulta();
				SpCausaefeito spceexistentecausa = null;
				q.append("SELECT sp");
				q.append("FROM SpCausaefeito sp ");
				q.append(" LEFT JOIN FETCH sp.spCausa spcau ");
				q.append("WHERE sp.idCausaefeito <> :idce AND spcau.idCausa = :idcausa");
				q.defineParametro("idce", a.getIdCausaefeito());
				q.defineParametro("idcausa", idcausa);
				spceexistentecausa = (SpCausaefeito) q.uniqueResult();

				if(spceexistentecausa==null || spceexistentecausa.getIdCausaefeito().equals(0L)){
					List<SpCausads> listaDses = null;
					listaDses = this.getCausaDses(idcausa.longValue());
					for(SpCausads causaDs : listaDses){
						this.session.delete(causaDs);
					}					

					if(spcausapersistido!=null){
						this.session.delete(spcausapersistido);
					}

				}

			}
		}
		//-- causaefeito
		//-- Busca saber se já existe param_idcausaefeito. Se existir, Delete	
		q.novaConsulta();
		q.append("SELECT  ");
		q.append(" a ");
		q.append("FROM  ");
		q.append(" SpCausaefeito as a  ");
		q.append("WHERE  ");
		q.append(" a.idCausaefeito = :idCausaEfeito ");
		q.defineParametro("idCausaEfeito",new BigDecimal( idCausaEfeito));
		SpCausaefeito spcausaefeitoprincipalpersistido = null;
		spcausaefeitoprincipalpersistido = (SpCausaefeito) q.uniqueResult();

		BigDecimal idcausa = null;
		if(spcausaefeitoprincipalpersistido!=null && spcausaefeitoprincipalpersistido.getSpCausa()!=null && spcausaefeitoprincipalpersistido.getSpCausa().getIdCausa()!=null){
			idcausa = spcausaefeitoprincipalpersistido.getSpCausa().getIdCausa();				
		}

		if(spcausaefeitoprincipalpersistido!=null){
			this.session.delete(spcausaefeitoprincipalpersistido);
		}


		//-- causa
		//-- CAUSA em OUTRO CausaEfeito
		//-- Busca saber se já existe val_idcausa em [a3_causaefeito] para OUTRO <> de [val_idcausaefeito]. Se existir, NÃO Delete o CAUSA. Senão, DELETE.
		SpCausa spcausapersistido = null;
		if(idcausa!=null){
			spcausapersistido = this.getCausa(idcausa.longValue());

			q.novaConsulta();
			SpCausaefeito spceexistentecausa = null;
			q.append("SELECT sp");
			q.append("FROM SpCausaefeito sp ");
			q.append(" LEFT JOIN FETCH sp.spCausa spcau ");
			q.append("WHERE sp.idCausaefeito <> :idce AND spcau.idCausa = :idcausa");
			q.defineParametro("idce", new BigDecimal(idCausaEfeito));
			q.defineParametro("idcausa", idcausa);
			spceexistentecausa = (SpCausaefeito) q.uniqueResult();		
			if(spceexistentecausa==null || spceexistentecausa.getIdCausaefeito().equals(0L)){
				List<SpCausads> listaDses = null;
				listaDses = this.getCausaDses(idcausa.longValue());
				for(SpCausads causaDs : listaDses){
					this.session.delete(causaDs);
				}					

				if(spcausapersistido!=null){
					this.session.delete(spcausapersistido);
				}

			}
			id = idCausaEfeito;
		}




		return id;
	}


}
