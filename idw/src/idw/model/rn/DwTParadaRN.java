package idw.model.rn;

import java.util.List;

import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwTParada;
import idw.model.pojos.OmPt;

public class DwTParadaRN extends AbstractRN<DAOGenerico> implements IDao{

	public DwTParadaRN(){
		super(new DAOGenerico());
	}


	public DwTParadaRN(DAOGenerico dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	//Caso retorne uma parada n�o sera necess�rio cadastra-la

	public DwTParada getParada(String codigoParada){
		
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select dwtparada");
		q.append("from DwTParada dwtparada");
		q.append("where dwtparada.stAtivo = 1");
		q.append("and dwtparada.cdTparada like :depara");

		q.defineParametro("depara", ("%" + codigoParada));
		q.setMaxResults(1);

		return (DwTParada) q.uniqueResult();
		
	}
	
public List<DwTParada> getParadabyTppt(OmPt ompt){
		
		MapQuery q = new MapQuery(this.getDao().getSession());

		
		q.append("select dwtparada");
		q.append("from DwTParada dwtparada");
		q.append("where dwtparada.stAtivo = 1");
		q.append("and dwtparada.omTppt.idTppt=:idTppt");
		q.defineParametro("idTppt", ompt.getOmTppt().getIdTppt());

		return q.list();
		
	}
	public DwTParada setParada(DwTParada dwtparada)
	{
		DwTParada dtRetorno = new DwTParada();
		if(dwtparada.getCdTparada().trim().equals("")){
			//N�o posso salvar pq n�o existe o codigo de parada
			return null;
		}	
		String hql = "";
		
		hql = "from DwTParada dwtparada where dwtparada.idTparada= ::idTparada";
		hql = hql.replaceAll("::idTparada", String.valueOf(dwtparada.getIdTparada()));
		Query q = this.getDao().getSession().createQuery(hql);
		DwTParada dwtOriginal = (DwTParada) q.uniqueResult();
		DwTParada dwtAlteracao = null;
		boolean isInclusao = false;
		
		//Caso n�o exista o dwt dessa m�quina, criar um novo
		if(dwtOriginal == null){
			dwtOriginal = dwtparada.clone();
					
		
		}
		
		
		return null;
	}
}
