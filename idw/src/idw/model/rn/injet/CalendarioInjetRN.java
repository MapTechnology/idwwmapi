package idw.model.rn.injet;


import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.injet.Ijhorage;
import idw.model.pojos.injet.Ijhortur;
import idw.model.pojos.injet.IjhorturId;
import idw.model.pojos.injet.Ijtbtur;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;

@SuppressWarnings("unchecked")
public class CalendarioInjetRN extends AbstractRN<DAOGenericoInjet>{

	public CalendarioInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}
	
	public List<Ijtbtur> pesquisarTodosOsTurnosValidos(){
		String HQL = "";
		
		HQL += "select ijtbtur ";
		HQL += "from Ijtbtur ijtbtur ";
		HQL += "where ijtbtur.cdturno != '999999' ";
		HQL += "and ";
		HQL += "exists (from Ijhortur ijhortur "; 
		HQL += "		join ijhortur.ijhorage ijhorage ";
		HQL += "	where ijhortur.id.cdturno = ijtbtur.cdturno and ijhorage.dtfvagenda is null) ";
		
		List<Ijtbtur> listaIjtbtur = null;

		Query q = getDaoSession().createQuery(HQL);

		listaIjtbtur = q.list();

		return listaIjtbtur;
	}
	public Ijtbtur pesquisarIjtbtur(String cdTurno){
		Criterion[] listaCriterion = {
				Expression.eq("cdturno", cdTurno)
		};

		Ijtbtur ijtbtur = (Ijtbtur) getDao().findByCriteria(Ijtbtur.class, listaCriterion).get(0);
		
		return ijtbtur;
	}
	
	public Ijhortur pesquisarIjhorturVigente(String cdTurno, String cdDiaSemana){
		Ijhortur retorno = new Ijhortur();

		// Obtem lista ijcnsturno do filtro
		String HQL = "";

		HQL += "from Ijhortur ijhortur ";
		HQL += "join fetch ijhortur.ijhorage ";
		HQL += "where ijhortur.id.cdturno = '::cdturno' and ijhortur.ijhorage.dtfvagenda is null ";
		HQL += "and ijhortur.id.cddiasem = '::cddiasemana' ";


		HQL = HQL.replaceAll("::cdturno", cdTurno);
		HQL = HQL.replaceAll("::cddiasemana", cdDiaSemana);

		List<Ijhortur> listaIjhortur = null;

		Query q = getDaoSession().createQuery(HQL);

		try{
			listaIjhortur = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		if (listaIjhortur != null && listaIjhortur.size() > 0)
			retorno = listaIjhortur.get(0);
		
		return retorno;
	}

	public Ijhortur pesquisarIjhorturNaData(Date data, String cdTurno, String cdDiaSemana){
		Ijhortur retorno = new Ijhortur();

		// Obtem lista ijcnsturno do filtro
		String HQL = "";

		HQL += "from Ijhortur ijhortur ";
		HQL += "join fetch ijhortur.ijhorage ";
		HQL += "where ijhortur.id.cdturno = '::cdturno' and ( ( :data between ijhortur.ijhorage.dtivagenda and ijhortur.ijhorage.dtfvagenda ) or ";
		HQL += " (:data >= ijhortur.ijhorage.dtivagenda and ijhortur.ijhorage.dtfvagenda is null) ) ";
		HQL += "and ijhortur.id.cddiasem = '::cddiasemana' ";


		HQL = HQL.replaceAll("::cdturno", cdTurno);
		HQL = HQL.replaceAll("::cddiasemana", cdDiaSemana);

		List<Ijhortur> listaIjhortur = null;

		Query q = getDaoSession().createQuery(HQL);

		q.setTimestamp("data", data);

		Date inicio = DataHoraRN.getDataHoraAtual();
		try{
			listaIjhortur = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}
		Date fim = DataHoraRN.getDataHoraAtual();
		
		if (listaIjhortur != null && listaIjhortur.size() > 0)
			retorno = listaIjhortur.get(0);
		
		return retorno;
	}

	public Ijhorage pesquisarIjhorageNaData(Date data){
		Ijhorage retorno = new Ijhorage();

		// Obtem lista ijcnsturno do filtro
		String HQL = "";

		HQL += "from Ijhorage ijhorage ";
		HQL += "where ( :data between ijhorage.dtivagenda and ijhorage.dtfvagenda ) or ";
		HQL += "      ( :data >= ijhorage.dtivagenda and ijhorage.dtfvagenda is null ) ";

		List<Ijhorage> lista = null;

		Query q = getDaoSession().createQuery(HQL);

		q.setTimestamp("data", data);

		try{
			lista = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		if (lista != null && lista.size() > 0)
			retorno = lista.get(0);
		
		return retorno;
	}

	
	public List<Ijhortur> pesquisarListaIjhortur(Date data, String cdDiaSemana){
		// Obtem lista ijcnsturno do filtro
		String HQL = "";

		HQL += "from Ijhortur ijhortur ";
		HQL += "join fetch ijhortur.ijhorage ";
		HQL += "join fetch ijhortur.ijtbtur ";
		HQL += "where ( ( :data between ijhortur.ijhorage.dtivagenda and ijhortur.ijhorage.dtfvagenda ) or ";
		HQL += " (:data >= ijhortur.ijhorage.dtivagenda and ijhortur.ijhorage.dtfvagenda is null) ) ";
		HQL += "and ijhortur.id.cddiasem = '::cddiasemana' ";

		HQL = HQL.replaceAll("::cddiasemana", cdDiaSemana);

		List<Ijhortur> listaIjhortur = null;

		Query q = getDaoSession().createQuery(HQL);

		q.setTimestamp("data", data);

		try{
			listaIjhortur = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return listaIjhortur;
	}


	public Ijhortur pesquisarIjhorturMaximo(String cdDiaSemana){
		Ijhortur retorno = new Ijhortur();

		// Obtem lista ijcnsturno do filtro
		String HQL = "";

//		max(ijhortur.cdturno)
//		from ijhortur join ijhorage on ijhortur.cdagenda = ijhorage.cdagenda
//		where ijhorage.dtfvagenda is null and ijhortur.cddiasem = '00000' + v_Dia;

		HQL += "select max(ijhortur.id.cdturno) ";
		HQL += "from Ijhortur ijhortur ";
		HQL += "join ijhortur.ijhorage ";
		HQL += "where ijhortur.ijhorage.dtfvagenda is null ";
		HQL += "and ijhortur.id.cddiasem = '::cddiasemana' ";


		HQL = HQL.replaceAll("::cddiasemana", cdDiaSemana);

		String cdTurno = null;

		Query q = getDaoSession().createQuery(HQL);

		try{
			cdTurno = q.uniqueResult().toString();
		} catch (Exception e){
			e.printStackTrace();
		}

		IjhorturId id = new IjhorturId();
		id.setCdturno(cdTurno);
		retorno.setId(id);
		return retorno;
	}
	
	@Deprecated
	public Ijtbtur getTurnoAnteriorAReferencia(Date dtTurnoRef, String cdTurnoRef){
		
		// TODO Esse metodo deve ser implementado para funcionar genericamente, entretanto para a bettanin
		// foi desenvolvido para a realidade
		Ijtbtur retorno = new Ijtbtur();
		String cdTurno = "";
		if (cdTurnoRef.equals("000001"))
			cdTurno = "000003";
		if (cdTurnoRef.equals("000002"))
			cdTurno = "000001";
		if (cdTurnoRef.equals("000003"))
			cdTurno = "000002";
		
		retorno.setCdturno(cdTurno);
		
		return retorno;
	}
	
	// Substitui o metodo getTurnoAnteirorAReferencia
	public TurnoInjetDTO getTurnoAnteriorAReferenciaFinal(Date dtTurnoRef, String cdTurnoRef) throws SemCalendarioException{
		TurnoInjetDTO retorno = null;
		// Encontrar o inicio do turno de referencia
		Date dthriturno = FuncoesApoioInjet.calcularInicioTurno((DAOGenericoInjet) getDaoSession(), dtTurnoRef, cdTurnoRef);

		// Retroceder alguns minutos na data e hora de inicio do turno de referencia
		Date dthriturnoDes = null;
		
		dthriturnoDes = DataHoraRN.regressMinutes(dthriturno, 60);
		
		// Usar essa nova data e hora para encontrar a qual turno pertence
		boolean isTurnoValido = false;
		int nTentativas = 1;
		while (isTurnoValido == false){
			try{
				retorno = FuncoesApoioInjet.encontraTurno((DAOGenericoInjet)getDaoSession(), dthriturnoDes);
				isTurnoValido = true;
			} catch (SemCalendarioException e){
				dthriturnoDes = DataHoraRN.regressMinutes(dthriturnoDes, 60);
				nTentativas++;
				if (nTentativas > 48)
					new SemCalendarioException();
			}
		}
		return retorno;
	}
}