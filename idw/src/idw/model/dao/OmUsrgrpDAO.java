package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.OmUsrgrp;
import idw.model.rn.DataHoraRN;

public class OmUsrgrpDAO {
	
	private Session session;
	
	public OmUsrgrpDAO(Session session){
		this.session = session;
	}
	
	public List<OmUsrgrp> getOmUsrgrps(OmUsrgrp filtro){
		MapQuery q = new MapQuery(session);
		q.append("SELECT t");
		q.append("FROM OmUsrgrp t");
		q.append("WHERE 1 = 1");

		if (filtro.getIdUsrgrp()!=0){
			q.append("AND t.idUsrgrp = :idUsrgrp");
		}else{
			if (filtro.getCdUsrgrp() != null && !filtro.getCdUsrgrp().equals("")){
				q.append("AND t.cdUsrgrp = :cdUsrgrp");
			}
			if (filtro.getDsUsrGrp() != null && !filtro.getDsUsrGrp().equals("")){
				q.append("AND t.dsUsrGrp = :dsUsrGrp");
			}
			if (filtro.getDtRevisao() != null){
				q.append("AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF");
			}
			if (filtro.getDtStativo() != null){
				q.append("AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF");
			}
			if (filtro.getRevisao() != null){
				q.append("AND t.revisao = :revisao");
			}
			if (filtro.getStAtivo() != null && filtro.getStAtivo() < (byte)2){
				q.append("AND t.stAtivo = :stAtivo");
			}
		}

		q.defineParametro("idUsrgrp", filtro.getIdUsrgrp());
		q.defineParametro("cdUsrgrp", filtro.getCdUsrgrp());
		q.defineParametro("dsUsrGrp", filtro.getDsUsrGrp());
		q.defineParametro("revisao", filtro.getRevisao());
		q.defineParametro("stAtivo", filtro.getStAtivo());

		try {
			q.defineParametroTimestamp("dtRevisao", filtro.getDtRevisao());
			q.defineParametroTimestamp("dtRevisaoF", DataHoraRN.getDataHora235959(filtro.getDtRevisao()));
		} catch (Exception e) {}	
		
		try {
			q.defineParametroTimestamp("dtStativo", filtro.getDtStativo());
			q.defineParametroTimestamp("dtStativoF", DataHoraRN.getDataHora235959(filtro.getDtStativo()));
		} catch (Exception e) {}

		return q.list();
	}
	
	public OmUsrgrp getOmUsrgrpPorId(long idUsrgrp){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmUsrgrp omusrgrp");
		q.append("WHERE omusrgrp.idUsrgrp = :idUsrgrp");
		q.defineParametro("idUsrgrp", idUsrgrp);
		return (OmUsrgrp) q.uniqueResult();
	}
	
	public OmUsrgrp getOmUsrgrpPorCd(String cdUsrgrp){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmUsrgrp omusrgrp");
		q.append("WHERE omusrgrp.cdUsrgrp = :cdUsrgrp");
		q.append("and omusrgrp.stAtivo = 1");
		q.defineParametro("cdUsrgrp", cdUsrgrp);
		q.setMaxResults(1);
		return (OmUsrgrp) q.uniqueResult();
	}
	
	public OmUsrgrp getOmUsrgrpMaiorRevisao(String cdUsrgrp, long revisao){
		MapQuery q = new MapQuery(session);
		q.append("from OmUsrgrp omusrgrp");
		q.append("where omusrgrp.cdUsrgrp = :cdUsrgrp");
		q.append("and omusrgrp.revisao > :revisao");
		q.defineParametro("cdUsrgrp", cdUsrgrp);
		q.defineParametro("revisao", revisao);
		q.setMaxResults(1);
		return (OmUsrgrp) q.uniqueResult();
	}
	
	public OmUsrgrp getOmUsrgrpPorCdAtivoOrderById(String cdUsrgrp){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmUsrgrp t");
		q.append("WHERE t.cdUsrgrp = :cdUsrgrp");
		q.append("AND t.stAtivo = :stAtivo");
		q.append("ORDER BY t.idUsrgrp");
		q.defineParametro("cdUsrgrp", cdUsrgrp);
		q.defineParametro("stAtivo", (byte)1);
		q.setMaxResults(1);
		return (OmUsrgrp) q.uniqueResult();
	}

}
