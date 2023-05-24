package idw.model.rn.joblog;

import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.OmJobdetlog;
import idw.model.pojos.OmJoblog;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;

public class JobRN extends AbstractRN<DAOGenerico>{

	public JobRN() {
		super(new DAOGenerico());
	}
	
	public JobRN(DAOGenerico dao) {
		super(dao);
	}
	

	public ListaOmJobLogDTO pesquisarOmJoblog(FiltroPesquisaOmJobDTO filtro) {
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from OmJoblog a");
		q.appendWhere(MapQuery._NULL, "a.omJob.cdJob = :cd", filtro.getCdJob() != null && filtro.getCdJob().equals("") == false);
		q.appendWhere(MapQuery._AND, "a.dthrIexecucao between :dti and :dtf", filtro.getDthrIExecucao() != null);
		q.append("order by a.dthrIexecucao desc");
		
		q.defineParametro("cd", filtro.getCdJob());
		q.defineParametroTimestamp("dti", filtro.getDthrIExecucao());
		if (filtro.getDthrFExecucao() != null)
			q.defineParametroTimestamp("dtf", DataHoraRN.setHoraNaData(filtro.getDthrFExecucao(), 23, 59, 59));
		q.setMaxResults(filtro.getQtdeRegistros());
		
		List<OmJoblog> lista = q.list();
		ListaOmJobLogDTO retorno = new ListaOmJobLogDTO();
		for (OmJoblog joblog : lista) {
			OmJoblog clone = joblog.clone(false);
			clone.setOmJob(joblog.getOmJob().clone(false));
			retorno.getListaOmJoblog().add(clone);
			
		}
		return retorno;
	}

	public ListaOmJobdetLogDTO pesquisarOmJobdetlog(Long idJoblog) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from OmJobdetlog a");
		q.append("where a.omJoblog.idJoblog = :id");
		q.defineParametro("id", idJoblog);
		List<OmJobdetlog> lista = q.list();
		ListaOmJobdetLogDTO retorno = new ListaOmJobdetLogDTO();
		for (OmJobdetlog detlog : lista) {
			retorno.getLista().add(detlog.clone());
		}
		
		return retorno;
	}
}
