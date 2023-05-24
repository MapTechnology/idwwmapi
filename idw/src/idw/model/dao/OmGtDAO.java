package idw.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.OmGt;
import idw.model.pojos.injet.Ijtbgal;
import idw.model.pojos.template.OmTpgtTemplate;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.GtDTO;
import ms.util.ConversaoTipos;

public class OmGtDAO {
	
	private Session session;
	
	public OmGtDAO(Session session){
		this.session = session;
	}
	
	public List<OmGt> getOmGts(GtDTO filtro) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT t");
		q.append("FROM OmGt t");
		q.append("WHERE 1 = 1");
		
		if (filtro.getGt().getIdGt() != null && filtro.getGt().getIdGt() != 0) {
			q.append("AND t.idGt = :idGt");
		} else {
			if (filtro.getGt().getCdGt() != null && !filtro.getGt().getCdGt().equals("")) {
				q.append("AND t.cdGt = :cdGt");
			}
			if (filtro.getGt().getDsGt() != null && !filtro.getGt().getDsGt().equals("")) {
				q.append("AND t.dsGt = :dsGt");		
			}
			if (filtro.getGt().getDsCurta() != null && !filtro.getGt().getDsCurta().equals("")) {
				q.append("AND t.dsCurta = :dsCurta");
			}
			if (filtro.getGt().getRevisao() != null && !filtro.getGt().getRevisao().equals("")) {
				q.append("AND t.revisao = :revisao");
			}
			if (filtro.getGt().getStAtivo() != null && filtro.getGt().getStAtivo() < (byte) 2) {
				q.append("AND t.stAtivo = :stAtivo");
			}
			if (filtro.getGt().getOmTpgt() != null && !filtro.getGt().getOmTpgt().getCdTpgt().equals("")) {
				q.append("AND t.omTpgt.cdTpgt = :cdTpgt");
			}
			if (filtro.getGt().getOmTpgt() != null && filtro.getGt().getOmTpgt().getDsTpgt() != null && !filtro.getGt().getOmTpgt().getDsTpgt().equals("")) {
				q.append("AND t.omTpgt.dsTpgt = :dsTpgt");
			}
			if (filtro.getGt().getOmCc() != null && !filtro.getGt().getOmCc().getCdCc().equals("")) {
				q.append("AND t.omCc.cdCc = :cdCc");
			}
			if (filtro.getGt().getOmCc() != null && !filtro.getGt().getOmCc().getDsCc().equals("")) {
				q.append("AND t.omCc.dsCc = :dsCc");	
			}
			if (filtro.getGt().getOmUsrByIdUsrrevisao() != null && !filtro.getGt().getOmUsrByIdUsrrevisao().getCdUsr().equals("")) {
				q.append("AND t.omUsrByIdUsrrevisao.cdUsr = :cdUsrRev");	
			}
			if (filtro.getGt().getOmUsrByIdUsrrevisao() != null	&& !filtro.getGt().getOmUsrByIdUsrrevisao().getDsNome().equals("")) {
				q.append("AND t.omUsrByIdUsrrevisao.dsNome = :dsNomeRev");	
			}
			if (filtro.getGt().getOmUsrByIdUsrstativo() != null	&& !filtro.getGt().getOmUsrByIdUsrstativo().getCdUsr().equals("")) {
				q.append("AND t.omUsrByIdUsrstativo.cdUsr = :cdUsrSt");
			}
			if (filtro.getGt().getOmUsrByIdUsrstativo() != null	&& !filtro.getGt().getOmUsrByIdUsrstativo().getDsNome().equals("")) {
				q.append("AND t.omUsrByIdUsrstativo.dsNome = :dsNomeSt");	
			}
			if (filtro.getGt().getOmImg() != null && !filtro.getGt().getOmImg().getCdImg().equals("")) {
				q.append("AND t.omImg.cdImg = :cdImg");
			}
			if (filtro.getGt().getOmImg() != null && filtro.getGt().getOmImg().getDsImg() != null && !filtro.getGt().getOmImg().getDsImg().equals("")) {
				q.append("AND t.omImg.dsImg = :dsImg");
			}
			if (filtro.getGt().getDtRevisao() != null) {
				q.append("AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF");
			}
			if (filtro.getGt().getDtStativo() != null) {
				q.append("AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF");
			}
		}
		q.append("ORDER BY t.cdGt");
		q.defineParametro("idGt", filtro.getGt().getIdGt());
		q.defineParametro("cdGt", filtro.getGt().getCdGt());
		q.defineParametro("dsGt", filtro.getGt().getDsGt());
		q.defineParametro("dsCurta", filtro.getGt().getDsCurta());
		q.defineParametro("revisao", filtro.getGt().getRevisao());
		q.defineParametro("stAtivo", filtro.getGt().getStAtivo());
		
		if(filtro.getGt().getOmTpgt() != null) {
			q.defineParametro("cdTpgt", filtro.getGt().getOmTpgt().getCdTpgt());
			q.defineParametro("dsTpgt", filtro.getGt().getOmTpgt().getDsTpgt());
		}
		if(filtro.getGt().getOmCc() != null) {
			q.defineParametro("cdCc", filtro.getGt().getOmCc().getCdCc());
			q.defineParametro("dsCc", filtro.getGt().getOmCc().getDsCc());
		}
		if(filtro.getGt().getOmUsrByIdUsrrevisao() != null) {
			q.defineParametro("cdUsrRev", filtro.getGt().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getGt().getOmUsrByIdUsrrevisao().getDsNome());
		}
		if(filtro.getGt().getOmUsrByIdUsrstativo() != null) {
			q.defineParametro("cdUsrSt", filtro.getGt().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getGt().getOmUsrByIdUsrstativo().getDsNome());
		}
		if(filtro.getGt().getOmImg() != null) {
			q.defineParametro("cdImg", filtro.getGt().getOmImg().getCdImg());
			q.defineParametro("dsImg", filtro.getGt().getOmImg().getDsImg());
		}
		try {
			q.defineParametroTimestamp("dtRevisao", filtro.getGt().getDtRevisao()); 
			q.defineParametroTimestamp("dtRevisaoF", DataHoraRN.getDataHora235959(filtro.getGt().getDtRevisao()));
		} catch (Exception e) {}
		try {
			q.defineParametroTimestamp("dtStativo", filtro.getGt().getDtStativo());
			q.defineParametroTimestamp("dtStativoF", DataHoraRN.getDataHora235959(filtro.getGt().getDtStativo()));
		} catch (Exception e) {}
		
		return q.list();
	}
	
	public List<OmGt> getGtsComLayout(){
		MapQuery q = new MapQuery(session);
		q.append("select distinct t");
		q.append("FROM OmGt t");
		q.append("join t.omTpgt a");
		q.append("WHERE t.stAtivo = 1");
		q.append("AND EXISTS (FROM OmObj omobj");
		q.append("WHERE omobj.omGtByIdGt = t)");
		//q.append("AND omobj.omPt.stAtivo = 1)"); removi pra mostrar os GTs que tem apenas GTs no layout
		
		// Alessandre em 09-09-20 acrescentei o filtro abaixo para nao mostrar as celulas
		q.append("and (a.tpConsolidacao = :tpconsolidacao or a.tpConsolidacao is null)");
		q.append("ORDER BY t.cdGt");
		
		q.defineParametro("tpconsolidacao", OmTpgtTemplate._TP_CONSOLIDACAO._TP_CONSOLIDACAO_SEMCONSOLIDACAO.getTpConsolidacao());
		
		return q.list();
	}
	
	public OmGt getOmGtPorId(long idGt){
		return getOmGt(idGt, null);
	}
	
	private OmGt getOmGt(long idGt, Byte stAtivo){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmGt omgt");
		q.append("WHERE omgt.idGt = :idGt");
		if(stAtivo != null){
			q.append("AND omgt.stAtivo = :stAtivo");
		}
		q.defineParametro("idGt", idGt);
		q.defineParametro("stAtivo", stAtivo);
		q.setMaxResults(1);
		return (OmGt) q.uniqueResult();
	}
	
	private OmGt getOmGt(String codigo, Byte stAtivo){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmGt omgt");
		q.append("WHERE omgt.cdGt = :codigo");
		if(stAtivo != null){
			q.append("AND omgt.stAtivo = :stAtivo");
		}
		q.defineParametro("codigo", codigo);
		q.defineParametro("stAtivo", stAtivo);
		q.setMaxResults(1);
		return (OmGt) q.uniqueResult();
	}
	
	public OmGt getPrimeiroGtAtivo() {
		MapQuery q = new MapQuery(session);
		q.append("FROM OmGt t");
		q.append("WHERE t.stAtivo = 1");
		q.append("ORDER BY t.cdGt");
		q.setMaxResults(1);
		return (OmGt) q.uniqueResult();
	}
	
	public OmGt getOmGtPorCdMaiorRevisao(String cdGt, long revisao){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmGt omgt");
		q.append("WHERE omgt.cdGt = :cdgt");
		q.append("AND omgt.revisao > :revisao");
		q.defineParametro("cdgt", cdGt);
		q.defineParametro("revisao", revisao);
		q.setMaxResults(1);
		return (OmGt) q.uniqueResult();
	}
	
	public List<OmGt> getOmGtsAtivos(){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmGt t");
		q.append("WHERE t.stAtivo = 1");
		q.append("ORDER BY t.cdGt");
		return q.list();
	}
	
	public OmGt getOmGtPorIdOuCdAtivos(Long idGt, String cdGt){
		if(idGt != null){
			return getOmGtPorId(idGt);
		}
		if(cdGt != null){
			return getOmGtPorCdAtivo(cdGt);
		}
		return null;
	}
	
	public OmGt getOmGtPorCdAtivoOrderById(String cdGt){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmGt omgt");
		q.append("WHERE omgt.cdGt = :codigo");
		q.append("AND omgt.stAtivo = :stAtivo");
		q.append("ORDER BY omgt.idGt");
		q.defineParametro("codigo", cdGt);
		q.defineParametro("stAtivo", (byte)1);
		q.setMaxResults(1);
		return (OmGt) q.uniqueResult();
	}
	
	public OmGt getOmGtPorCdAtivo(String cdGt){
		return getOmGt(cdGt, (byte)1);
	}

	public List<OmGt> getOmGtsAtivosPorTp(String idTpGt) {
		MapQuery q = new MapQuery(session);
		q.append("FROM OmGt gt");
		q.append("WHERE gt.stAtivo = :stAtivo");
		q.append("AND gt.omTpgt.idTpgt = :idTpGt");
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("idTpGt", Long.parseLong(idTpGt));
		return q.list();
	}

	public List<OmGt> getOmGtsAtivosInjet(DAOGenericoInjet dao){
		List<OmGt> retorno = new ArrayList<OmGt>();
		
		MapQuery q = new MapQuery(dao.getSession());
		q.append("FROM Ijtbgal t");
		q.append("ORDER BY t.cdgalpao");
		List<Ijtbgal> listaGalpoes = q.list();
		
		for (Ijtbgal galpao : listaGalpoes) {
			OmGt gt = new OmGt();
			gt.setIdGt(ConversaoTipos.converteParaBigDecimal(galpao.getCdgalpao()).longValue());
			gt.setCdGt(galpao.getCdgalpao());
			gt.setDsGt(galpao.getDsgalpao());
			gt.setDsGt(gt.getDsGt());
			gt.setStAtivo((byte)1) ; 
			retorno.add(gt);
		}
		return retorno;
	}

	public List<OmGt> getGtsComLayoutInjet(DAOGenericoInjet dao){
		List<OmGt> retorno = new ArrayList<OmGt>();
		
		MapQuery q = new MapQuery(dao.getSession());
		q.append("SELECT DISTINCT a");
		q.append("FROM Ijtbgal a");
		q.append("WHERE EXISTS (FROM Ijgalobj obj WHERE obj.ijtbgal = a)");
		q.append("ORDER BY a.cdgalpao");

		List<Ijtbgal> listaGalpoes = q.list();
		
		for (Ijtbgal galpao : listaGalpoes) {
			OmGt gt = new OmGt();
			gt.setIdGt(ConversaoTipos.converteParaBigDecimal(galpao.getCdgalpao()).longValue());
			gt.setCdGt(galpao.getCdgalpao());
			gt.setDsGt(galpao.getDsgalpao());
			gt.setDsGt(gt.getDsGt());
			gt.setStAtivo((byte)1) ; 
			retorno.add(gt);
		}

		return retorno;
	}

	public OmGt getOmGtPorCdAtivoOrderByIdInjet(DAOGenericoInjet dao, String cdGt){
		MapQuery q = new MapQuery(dao.getSession());
		q.append("FROM Ijtbgal t");
		q.append("WHERE t.cdgalpao = :codigo");
		q.defineParametro("codigo", cdGt);
		q.setMaxResults(1);
		Ijtbgal galpao = (Ijtbgal) q.uniqueResult();
		
		OmGt gt = new OmGt();
		if (galpao == null) {
			gt = new OmGt();
		} else {
			gt.setIdGt(ConversaoTipos.converteParaBigDecimal(galpao.getCdgalpao()).longValue());
			gt.setCdGt(galpao.getCdgalpao());
			gt.setDsGt(galpao.getDsgalpao());
			gt.setDsGt(gt.getDsGt());
			gt.setStAtivo((byte)1) ; 
		}
		
		return gt;
	}		
	
}
