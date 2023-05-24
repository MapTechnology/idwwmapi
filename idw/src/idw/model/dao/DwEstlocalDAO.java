package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstlocal;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.DwEstlocalTemplate;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.DwEstlocalDTO;

public class DwEstlocalDAO {
	
	private Session session;
	
	public DwEstlocalDAO(Session session){
		this.session = session;
	}
	
	public DwEstlocal pesquisarUniqueDwEstlocalByCdLocal(String cdLocal){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwEstlocal dwEstlocal ");
		q.append("WHERE dwEstlocal.cdLocal = :cdlocal ");
		q.append("AND dwEstlocal.stAtivo = 1");
		q.defineParametro("cdlocal", cdLocal);
		return (DwEstlocal) q.uniqueResult();
	}
	
	public DwEstlocal getDwEstlocalPorId(DwEstlocalDTO filtro){
		DwEstlocal dwEstlocal = null;
		if(filtro.getDwEstlocal().getIdEstlocal() != null){
			dwEstlocal = getDwEstlocalPorId(filtro.getDwEstlocal().getIdEstlocal());
		}
		return dwEstlocal;
	}
	
	public DwEstlocal getDwEstlocalPorId(long idEstlocal){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwEstlocal estlocal");
		q.append("WHERE estlocal.idEstlocal = :idEstlocal");
		q.defineParametro("idEstlocal", idEstlocal);
		q.setMaxResults(1);
		return (DwEstlocal) q.uniqueResult();
	}

	public List<DwEstlocal> getDwEstLocals(String codigo, String descricao, Byte tpLocalEstoque){
		MapQuery q = new MapQuery(session);
		q.append("SELECT t FROM DwEstlocal t");
		q.append("WHERE t.stAtivo = 1");

		if (!codigo.equals("") && !descricao.equals("")) {
			q.append("AND (t.cdLocal = :cdLocal OR t.dsLocal = :dsLocal)");
		} else if (!codigo.equals("")) {
			q.append("AND t.cdLocal = :cdLocal");
		} else if (!descricao.equals("")) {
			q.append("AND t.dsLocal = :dsLocal");
		}
		if(tpLocalEstoque != null){
			q.append("AND t.tpLocalEstoque = :tpLocalEstoque");
		}
		
		if(codigo != null && !codigo.equals("")){
			q.defineParametro("cdLocal", codigo);
		}
		if(descricao != null && !descricao.equals("")){
			q.defineParametro("dsLocal", descricao);
		}
		if(tpLocalEstoque != null){
			q.defineParametro("tpLocalEstoque", tpLocalEstoque);
		}
		return q.list();
	}

	public DwEstlocal getDwEstLocalPrimeiroDoEstoque(DwEst dwEst) {
		MapQuery q = new MapQuery(session);
		q.append("select a");
		q.append("from DwEstlocal a");
		q.append("where a.dwEst = :dwest");
		q.append("and a.stAtivo = 1");
		q.defineParametro("dwest", dwEst);
		q.setMaxResults(1);
		return (DwEstlocal) q.uniqueResult();
	}

	public DwEstlocal getDwEstLocalPeloPtCdPaTpLocalEstoque(DwEst dwEst, OmPt omPt, String cdPa, DwEstlocalTemplate.TpLocalEstoque tpLocalEstoque) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwEstlocal FROM DwEstlocal dwEstlocal");
		q.append("INNER JOIN dwEstlocal.omPa omPa");
		q.append("WHERE dwEstlocal.omPt = :omPt ");
		q.append("AND omPa.cdPa = :cdPa ");		
		q.append("AND omPa.omPt = :omPt ");
		q.append("AND dwEstlocal.dwEst = :dwEst ");		
		q.append("AND dwEstlocal.stAtivo = :stAtivo ");
		q.append("and omPa.stAtivo = :stAtivo");
		q.append("AND dwEstlocal.tpLocalEstoque = :tpLocalEstoque ");
		q.append("ORDER BY dwEstlocal.idEstlocal");
		q.defineParametro("omPt", omPt);
		q.defineParametro("cdPa", cdPa);		 
		q.defineParametro("tpLocalEstoque", tpLocalEstoque.getId());
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("dwEst", dwEst);	

		
		return (DwEstlocal) q.uniqueResult();
	}
	
	public List<DwEstlocal> getDwEstLocalPorFiltro(DwEstlocal filtro){
		MapQuery q = new MapQuery(session);
		q.append("SELECT e ");
		q.append("FROM DwEstlocal e ");
		q.append("WHERE 1 = 1 ");
		
		if(filtro.getIdEstlocal() != null && filtro.getIdEstlocal() != 0){
			q.append("AND e.idEstlocal = :idEstlocal ");
		}else{
			if(filtro.getCdLocal() != null && !filtro.getCdLocal().equals("")){
				q.append("AND e.cdLocal = :cdLocal ");
			}
			if(filtro.getDsLocal() != null && !filtro.getDsLocal().equals("")){
				q.append("AND e.dsLocal = :dsLocal ");
			}
			if(filtro.getDwEst() != null && !filtro.getDwEst().getCdEst().equals("")){
				q.append("AND e.dwEst.cdEst = :cdEst ");
			}
			if(filtro.getOmGt() != null && !filtro.getOmGt().getCdGt().equals("")){
				q.append("AND e.omGt.cdGt = :cdGt ");
			}
			if(filtro.getOmPt() != null && !filtro.getOmPt().getCdPt().equals("")){
				q.append("AND e.omPt.cdPt = :cdPt ");
			}
			if(filtro.getOmPa() != null && !filtro.getOmPa().getCdPa().equals("")){
				q.append("AND e.omPa.cdPa = :cdPa ");
			}
			if(filtro.getTpLocalEstoque() != null && !(filtro.getTpLocalEstoque() < (byte)3)){
				q.append("AND e.tpLocalEstoque = :stTpLocalEst ");
			}
			if (filtro.getDtRevisao()!=null){
				q.append("AND e.dtRevisao >= :dtRevisao AND e.dtRevisao <= :dtRevisaoF ");
			}
			if (filtro.getDtStativo()!=null){
				q.append("AND e.dtStativo >= :dtStativo AND e.dtStativo <= :dtStativoF ");
			}
			if (filtro.getRevisao()!=null){
				q.append("AND e.revisao = :revisao ");
			}
			if ((filtro.getStAtivo() != null) && (filtro.getStAtivo() < (byte)2)){
				q.append("AND e.stAtivo = :stAtivo ");
			}
		}
		
		q.append("order by e.idEstlocal ");
		q.defineParametro("idEstlocal", filtro.getIdEstlocal());
		q.defineParametro("cdLocal", filtro.getCdLocal());
		q.defineParametro("dsLocal", filtro.getDsLocal());
		q.defineParametro("stTpLocalEst", filtro.getTpLocalEstoque());
		q.defineParametro("stAutomatico", filtro.getAutomatico());
		q.defineParametro("revisao", filtro.getRevisao());
		q.defineParametro("stAtivo", filtro.getStAtivo());
		
		if(filtro.getDwEst() != null){
			q.defineParametro("cdEst", filtro.getDwEst().getCdEst());
		}
		if(filtro.getOmGt() != null){
			q.defineParametro("cdGt", filtro.getOmGt().getCdGt());
		}
		if(filtro.getOmPt() != null){
			q.defineParametro("cdPt", filtro.getOmPt().getCdPt());
		}
		if(filtro.getOmPa() != null){
			q.defineParametro("cdPa", filtro.getOmPa().getCdPa());
		}
		
		if(filtro.getDtRevisao() != null){
			try {
				q.defineParametroTimestamp("dtRevisao", filtro.getDtRevisao());
				q.defineParametroTimestamp("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getDtRevisao()));
			} catch (Exception e) {}
		}
		
		if (filtro.getDtStativo() != null){
			try {
				q.defineParametroTimestamp("dtStativo", filtro.getDtStativo());
				q.defineParametroTimestamp("dtStativoF",DataHoraRN.getDataHora235959(filtro.getDtStativo()));
			} catch (Exception e) {}
		}

		List<DwEstlocal> listaPesquisada = q.list();
		return listaPesquisada;
	}
	
	public DwEstlocal getDwEstlocalPorCdAtivoOrderById(String cdEstlocal){
		MapQuery q = new MapQuery(session);
		q.append("SELECT t FROM DwEstlocal t");
		q.append("WHERE t.stAtivo = :stAtivo");
		q.append("AND t.cdLocal = :cdLocal");
		q.append("ORDER BY t.idEstlocal");
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdLocal", cdEstlocal);
		q.setMaxResults(1);
		return (DwEstlocal) q.uniqueResult();
	}
	
}