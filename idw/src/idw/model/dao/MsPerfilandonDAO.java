package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.MsPerfilandon;
import idw.model.rn.DataHoraRN;

public class MsPerfilandonDAO {

	private Session session;
	
	public MsPerfilandonDAO(Session session){
		this.session = session;
	}
	
	public List<MsPerfilandon> getMsPerfilandons(MsPerfilandon filtro) {
		MapQuery q = new MapQuery(session);
		q.append("FROM MsPerfilandon andon");
		q.append("WHERE 1 = 1");
		
		if(filtro.getIdPerfilandon() != null && filtro.getIdPerfilandon() != 0) {
			q.append("AND andon.idPerfilandon = :idPerfilandon");
		} else {
			if(filtro.getCdPerfilandon() != null && !filtro.getCdPerfilandon().isEmpty()) {
				q.append("AND andon.cdPerfilandon = :cdPerfilandon");
			}
			if(filtro.getDsPerfilandon() != null && !filtro.getDsPerfilandon().isEmpty()) {
				q.append("AND andon.dsPerfilandon = :dsPerfilandon");
			}
			if (filtro.getDtRevisao() != null){
				q.append("AND andon.dtRevisao >= :dtRevisao AND andon.dtRevisao <= :dtRevisaoF");
			}
			if (filtro.getDtStativo() != null){
				q.append("AND andon.dtStativo >= :dtStativo AND andon.dtStativo <= :dtStativoF");
			}
			if ((filtro.getMsUsrByIdUsrStAtivo() != null) && !filtro.getMsUsrByIdUsrStAtivo().getCdUsr().equals("")){
				q.append("AND andon.msUsrByIdUsrStAtivo.cdUsr = :cdUsrAtivo");
			}
			if ((filtro.getMsUsrByIdUsrStAtivo() != null) && !filtro.getMsUsrByIdUsrStAtivo().getNmUsr().equals("")){
				q.append("AND andon.msUsrByIdUsrStAtivo.nmUsr = :nmUsrAtivo");
			}
			if ((filtro.getMsUsrByIdUsrRevisao() != null) && !filtro.getMsUsrByIdUsrRevisao().getCdUsr().equals("")){
				q.append("AND andon.msUsrByIdUsrRevisao.cdUsr = :cdUsrRevisao");
			}
			if ((filtro.getMsUsrByIdUsrRevisao() != null) && !filtro.getMsUsrByIdUsrRevisao().getNmUsr().equals("")){
				q.append("AND andon.msUsrByIdUsrRevisao.nmUsr = :nmUsrRevisao");
			}
			if (filtro.getRevisao() != null){
				q.append("AND andon.revisao = :revisao");
			}
			if ((filtro.getStAtivo() != null) && (filtro.getStAtivo() < (byte)2)){
				q.append("AND andon.stAtivo = :stAtivo");
			}
		}
		
		q.defineParametro("idPerfilandon", filtro.getIdPerfilandon());
		q.defineParametro("cdPerfilandon", filtro.getCdPerfilandon());
		q.defineParametro("dsPerfilandon", filtro.getDsPerfilandon());
		q.defineParametro("revisao", filtro.getRevisao());
		if (filtro.getDtRevisao() != null){
			try {
				q.defineParametroTimestamp("dtRevisao", filtro.getDtRevisao());
				q.defineParametroTimestamp("dtRevisaoF", DataHoraRN.getDataHora235959(filtro.getDtRevisao()));
			} catch (Exception e) {}
		}
		if (filtro.getDtStativo() != null){
			try {
				q.defineParametroTimestamp("dtStativo", filtro.getDtStativo());
				q.defineParametroTimestamp("dtStativoF", DataHoraRN.getDataHora235959(filtro.getDtStativo()));
			} catch (Exception e) {}
		}
		if (filtro.getMsUsrByIdUsrStAtivo() != null){
			q.defineParametro("cdUsrAtivo", filtro.getMsUsrByIdUsrStAtivo().getCdUsr());
			q.defineParametro("nmUsrAtivo", filtro.getMsUsrByIdUsrStAtivo().getNmUsr());			
		}
		if (filtro.getMsUsrByIdUsrRevisao() != null){
			q.defineParametro("cdUsrRevisao", filtro.getMsUsrByIdUsrRevisao().getCdUsr());
			q.defineParametro("nmUsrRevisao", filtro.getMsUsrByIdUsrRevisao().getNmUsr());
		}		
		if(filtro.getStAtivo() != null){
			q.defineParametro("stAtivo", filtro.getStAtivo().byteValue());
		}
		
		return q.list();
	}
	
	public List<MsPerfilandon> getPerfilAndonsAtivos() {
		MapQuery q = new MapQuery(session);
		q.append("FROM MsPerfilandon andon");
		q.append("WHERE andon.stAtivo = :stAtivo");
		q.defineParametro("stAtivo", (byte) 1);		
		return q.list();
	}
	
	public MsPerfilandon getMsPerfilAndonPorCdAtivo(String cdPerfilandon) {
		MapQuery q = new MapQuery(session);
		q.append("FROM MsPerfilandon andon");
		q.append("WHERE andon.cdPerfilandon = :codigo");
		q.append("AND andon.stAtivo = :stAtivo");
		q.defineParametro("codigo", cdPerfilandon);
		q.defineParametro("stAtivo", (byte)1);
		q.setMaxResults(1);
		return (MsPerfilandon) q.uniqueResult();
	}
	
	public MsPerfilandon getMsPerfilAndonPorId(long idPerfilandon) {
		MapQuery q = new MapQuery(session);
		q.append("FROM MsPerfilandon andon");
		q.append("WHERE andon.idPerfilandon = :id");
		q.defineParametro("id", idPerfilandon);
		return (MsPerfilandon) q.uniqueResult();
	}
	
}