package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.OmFor;
import idw.model.rn.DataHoraRN;

public class OmForDAO {
	
	private Session session;
	
	public OmForDAO(Session session){
		this.session = session;
	}
	
	public List<OmFor> getOmFor(OmFor filtro){
		MapQuery q = new MapQuery(session);
		
		q.append("SELECT t ");
		q.append("FROM OmFor t ");		

		q.appendWhere(MapQuery._NULL, "t.idFor = :idFornecedor", filtro.getIdFor()!=0);
		
		if (filtro.getIdFor()<=0) {
			q.appendWhere(MapQuery._AND, "t.cdFor = :cdFor", !filtro.getCdFor().equals(""));
			q.appendWhere(MapQuery._AND, "t.nmFornecedor=:nmFornecedor", !filtro.getNmFornecedor().equals(""));
			q.appendWhere(MapQuery._AND, "t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ", filtro.getDtRevisao()!=null);
			q.appendWhere(MapQuery._AND, "t.omUsrByIdUsrrevisao.cdUsr=:cdUsrRev", !filtro.getOmUsrByIdUsrrevisao().getCdUsr().equals(""));
			q.appendWhere(MapQuery._AND, "t.omUsrByIdUsrstativo.cdUsr=:cdUsrSt", !filtro.getOmUsrByIdUsrstativo().getCdUsr().equals(""));
			q.appendWhere(MapQuery._AND, "t.stAtivo=:stAtivo", filtro.getStAtivo()<(byte)2);
		}
		
		q.defineParametro("idFornecedor", filtro.getIdFor());		
		q.defineParametro("cdFor", filtro.getCdFor());
		q.defineParametro("nmFornecedor", filtro.getNmFornecedor());
		q.defineParametro("cdUsrRev", filtro.getOmUsrByIdUsrrevisao().getCdUsr());
		q.defineParametro("dsNomeRev", filtro.getOmUsrByIdUsrrevisao().getDsNome());
		q.defineParametro("cdUsrSt", filtro.getOmUsrByIdUsrstativo().getCdUsr());
		q.defineParametro("dsNomeSt", filtro.getOmUsrByIdUsrstativo().getDsNome());
		q.defineParametro("revisao", filtro.getRevisao());
		q.defineParametro("stAtivo", filtro.getStAtivo());
		q.defineParametroData("dtRevisao", filtro.getDtRevisao());
		if (filtro.getDtRevisao() != null){
			q.defineParametroData("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getDtRevisao()));
		}
		
		q.defineParametroData("dtStativo", filtro.getDtStativo());
		
		if (filtro.getDtStativo() != null){
			q.defineParametroData("dtStativoF",DataHoraRN.getDataHora235959(filtro.getDtStativo()));
		}
		
		return q.list();
	}

	public OmFor getOmForPorCdAtivoOrderById(String cdFor){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmFor t");
		q.append("WHERE t.cdFor = :cdFor");
		q.append("AND t.stAtivo = :stAtivo");
		q.append("ORDER BY t.idFor");
		q.defineParametro("cdFor", cdFor);
		q.defineParametro("stAtivo", (byte)1);
		q.setMaxResults(1);
		return (OmFor) q.uniqueResult();
	}
	
	public OmFor getOmForPorId(long idFor){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmFor omfornecedor");
		q.append("WHERE omfornecedor.idFor = :idfor");
		q.defineParametro("idfor", idFor);
		return (OmFor) q.uniqueResult();
	}
	
	public OmFor getOmForPorCdMaiorRevisao(String cdFor, long revisao){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmFor omfornecedor");
		q.append("WHERE omfornecedor.cdFor = :cdfornecedor");
		q.append("AND omfornecedor.revisao > :revisao");
		q.defineParametro("cdfornecedor", cdFor);
		q.defineParametro("revisao", revisao);
		q.setMaxResults(1);
		return (OmFor) q.uniqueResult();
	}
	
}
