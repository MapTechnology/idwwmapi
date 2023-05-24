package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwEst;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.EstoqueDTO;

public class DwEstDAO {
	
	private final GenericPojoMAPRevisaoDAO<DwEst> pojoMAPRevisaoDAO;
	
	public DwEstDAO(Session session){
		this.pojoMAPRevisaoDAO = new GenericPojoMAPRevisaoDAO<DwEst>(session, DwEst.class);
	}
	
	public List<DwEst> getEstoquesDTO(EstoqueDTO filtro){
		MapQuery q = new MapQuery(pojoMAPRevisaoDAO.getSession());
		
		q.append("SELECT t ");
		q.append("FROM DwEst t ");
		q.append("WHERE 1 = 1 ");
		
		if (filtro.getEstoque().getIdEst() != 0) {
			q.append("AND t.idEst =:idEst ");
		} else {
			if (filtro.getEstoque().getCdEst() != null && !filtro.getEstoque().getCdEst().equals("")){
				q.append("AND t.cdEst =:cdEst ");
			}
			if (filtro.getEstoque().getDsEst() != null && !filtro.getEstoque().getDsEst().equals("")){
				q.append("AND t.dsEst =:dsEst ");
			}
			if (filtro.getEstoque().getDtRevisao() != null){
				q.append("AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ");
			}
			if (filtro.getEstoque().getOmUsrByIdUsrrevisao() != null && !filtro.getEstoque().getOmUsrByIdUsrrevisao().getCdUsr().equals("")){
				q.append("AND t.omUsrByIdUsrrevisao.cdUsr =:cdUsrRev ");
			}
			if (filtro.getEstoque().getOmUsrByIdUsrrevisao() != null && !filtro.getEstoque().getOmUsrByIdUsrrevisao().getDsNome().equals("")){
				q.append("AND t.omUsrByIdUsrrevisao.dsNome =:dsNomeRev ");
			}
			if (filtro.getEstoque().getOmUsrByIdUsrstativo() != null && !filtro.getEstoque().getOmUsrByIdUsrstativo().getCdUsr().equals("")){
				q.append("AND t.omUsrByIdUsrstativo.cdUsr =:cdUsrSt ");
			}
			if (filtro.getEstoque().getOmUsrByIdUsrstativo() != null && !filtro.getEstoque().getOmUsrByIdUsrstativo().getDsNome().equals("")){
				q.append("AND t.omUsrByIdUsrstativo.dsNome =:dsNomeSt ");
			}
			if (filtro.getEstoque().getDtStativo() != null){
				q.append("AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF ");
			}
			if (filtro.getEstoque().getStAtivo() != null && filtro.getEstoque().getStAtivo() >= (byte)0 && filtro.getEstoque().getStAtivo() < (byte)2){
				q.append("AND t.stAtivo =:stAtivo ");
			}
			q.append("ORDER BY t.idEst "); 
		} 
	
		q.defineParametro("idEst", filtro.getEstoque().getIdEst());
		q.defineParametro("cdEst", filtro.getEstoque().getCdEst());
		q.defineParametro("dsEst", filtro.getEstoque().getDsEst());

		if (filtro.getEstoque().getOmUsrByIdUsrrevisao()!=null){
			q.defineParametro("cdUsrRev", filtro.getEstoque().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getEstoque().getOmUsrByIdUsrrevisao().getDsNome());
		}
		if (filtro.getEstoque().getOmUsrByIdUsrstativo()!=null){
			q.defineParametro("cdUsrSt", filtro.getEstoque().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getEstoque().getOmUsrByIdUsrstativo().getDsNome());
		}
		q.defineParametro("revisao", filtro.getEstoque().getRevisao());
		q.defineParametro("stAtivo", filtro.getEstoque().getStAtivo());
		
		try {
			q.defineParametroTimestamp("dtRevisao", filtro.getEstoque().getDtRevisao());
			q.defineParametroTimestamp("dtRevisaoF", DataHoraRN.getDataHora235959(filtro.getEstoque().getDtRevisao()));
		} catch (Exception e) {	}		
		try {
			q.defineParametroTimestamp("dtStativo", filtro.getEstoque().getDtStativo());
			q.defineParametroTimestamp("dtStativoF", DataHoraRN.getDataHora235959(filtro.getEstoque().getDtStativo()));
		} catch (Exception e) {	}
		
		return q.list();
	}

	public List<DwEst> pesquisarEstoqueMateriaPrima(String cdEst, String cdProduto, String cdCliente){
		MapQuery q = new MapQuery(pojoMAPRevisaoDAO.getSession());
		q.append("SELECT distinct e ");
		q.append("FROM DwEst e ");
		q.append("LEFT JOIN FETCH e.dwEstpros estpros ");
		q.appendWhere(MapQuery._NULL, "e.cdEst = :cdEst", cdEst != null && cdEst.equals("") == false);
		q.appendWhere(MapQuery._AND, "estpros.omProduto.cdProduto = :cdProduto", cdProduto != null && cdProduto.equals("") == false);
		q.appendWhere(MapQuery._AND, "estpros.ppCliente.cdCliente = :cdCliente", cdCliente != null && cdCliente.equals("") == false);
		q.defineParametro("cdEst", cdEst);
		q.defineParametro("cdProduto", cdProduto);
		q.defineParametro("cdCliente", cdCliente);
		return q.list();
	}
	
	public DwEst setEstoqueDTO(EstoqueDTO filtro){
		MapQuery q = new MapQuery(pojoMAPRevisaoDAO.getSession());
		q.append("from DwEst t ");
		q.append("where t.idEst = :idEst");
		q.defineParametro("idEst", filtro.getEstoque().getIdEst());
		q.setMaxResults(1);
		DwEst retorno = (DwEst) q.uniqueResult();
		return retorno;
	}
	
	public List<DwEst> getDwEstPorCd(String cdEst){
		MapQuery q = new MapQuery(pojoMAPRevisaoDAO.getSession());
		q.append("FROM DwEst t ");
		q.append("WHERE t.cdEst = :cdEst");
		q.defineParametro("cdEst", cdEst);
		return q.list();
	}
	
	public List<DwEst> ativaEstoqueDTO(EstoqueDTO filtro){
		MapQuery q = new MapQuery(pojoMAPRevisaoDAO.getSession());
		q.append("FROM DwEst t ");
		q.append("WHERE t.cdEst = :cdEst ");
		q.append("AND t.revisao > :revisao ");
		q.defineParametro("cdEst", filtro.getEstoque().getCdEst());
		q.defineParametro("revisao", filtro.getEstoque().getRevisao());
		return q.list();
	}
	
	public DwEst getDwEstPorCdAtivo(String cdEst){
		MapQuery q = new MapQuery(pojoMAPRevisaoDAO.getSession());
		q.append("FROM DwEst e ");
		q.append("WHERE e.cdEst = :cdEst ");
		q.append("AND e.stAtivo = 1 ");
		q.defineParametro("cdEst", cdEst);
		return (DwEst) q.uniqueResult();
	}
	
	public DwEst getDwEstPorId(long idEst){
		MapQuery q = new MapQuery(pojoMAPRevisaoDAO.getSession());
		q.append("FROM DwEst e ");
		q.append("WHERE e.idEst = :idEst ");
		q.defineParametro("idEst", idEst);
		return (DwEst) q.uniqueResult();
	}
	
	public DwEst getDwEstPorCdAtivoOrderById(String cdEst){
		MapQuery q = new MapQuery(pojoMAPRevisaoDAO.getSession());
		q.append("FROM DwEst e");
		q.append("WHERE e.cdEst = :cdEst");
		q.append("AND e.stAtivo = :stAtivo");
		q.append("ORDER BY e.idEst");
		q.defineParametro("cdEst", cdEst);
		q.defineParametro("stAtivo", (byte)1);
		q.setMaxResults(1);
		return (DwEst) q.uniqueResult();
	}

}
