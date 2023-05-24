package idw.model.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstlocal;
import idw.model.pojos.DwEstlocalpro;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwEstlocalTemplate;
import idw.model.pojos.template.DwEstlocalproTemplate;
import idw.webservices.dto.FiltroConsolLocalEstoqueDTO;
import idw.webservices.dto.FiltroMonitorizacaoLocalEstoque;

public class DwEstlocalproDAO {
	
	private Session session;
	
	public DwEstlocalproDAO(Session session){
		this.session = session;
	}
	
	public DwEstlocalpro getDwEstlocalpro(DwEstlocal dwEstlocal, DwEstpro dwEstpro, PpCp ppCp){
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwEstlocalpro FROM DwEstlocalpro dwEstlocalpro");
		q.append("WHERE dwEstlocalpro.dwEstlocal = :dwEstlocal");
		q.append("AND dwEstlocalpro.dwEstpro = :dwEstpro");
		q.defineParametro("dwEstlocal", dwEstlocal);
		q.defineParametro("dwEstpro", dwEstpro);
		q.setMaxResults(1);
		return (DwEstlocalpro) q.uniqueResult();
	}
	
	public DwEstlocalpro getDwEstlocalpro(DwEstlocal dwEstlocal, OmProduto produto){
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwEstlocalpro FROM DwEstlocalpro dwEstlocalpro");
		q.append("INNER JOIN dwEstlocalpro.dwEstpro estPro");
		q.append("INNER JOIN estPro.omProduto produto");
		q.append("INNER JOIN dwEstlocalpro.dwEstlocal estLocal");
		q.append("WHERE estLocal = :dwEstlocal");
		q.append("AND estPro.dwEst = estLocal.dwEst");
		q.append("AND produto = :produto");
		q.defineParametro("dwEstlocal", dwEstlocal);
		q.defineParametro("produto", produto);
		q.setMaxResults(1);
		return (DwEstlocalpro) q.uniqueResult();
	}
	
	public DwEstlocalpro getDwEstlocalproSenaoExistirCriar(DwEstlocal dwEstlocal, DwEstpro dwEstpro, PpCp ppCp){
		DwEstlocalpro dwEstlocalpro = getDwEstlocalpro(dwEstlocal, dwEstpro, ppCp);
		if(dwEstlocalpro == null){
			dwEstlocalpro = DwEstlocalproTemplate.newDwEstlocalpro(dwEstlocal, dwEstpro, ppCp, BigDecimal.ZERO);
			session.saveOrUpdate(dwEstlocalpro);
		}
		return dwEstlocalpro;
	}
	
	public List<DwEstlocalpro> getDwEstlocalprosDoPt(OmPt omPt, DwEstlocalTemplate.TpLocalEstoque tpLocalEstoque, boolean isApenasTotalMaiorZero, boolean isJoinFetchOmPa){
		
		MapQuery query = new MapQuery(session);
		query.append("SELECT dwEstlocalpro FROM DwEstlocalpro dwEstlocalpro ");	
		query.append("INNER JOIN FETCH dwEstlocalpro.dwEstlocal dwEstlocal");
		if(isJoinFetchOmPa){
			query.append("LEFT JOIN FETCH dwEstlocal.omPa omPa");	
		}		
		query.append("INNER JOIN FETCH dwEstlocalpro.dwEstpro dwEstpro");
		query.append("INNER JOIN FETCH dwEstpro.omProduto omProduto");
		query.append("WHERE 1 = 1");
		query.append("AND dwEstlocal.omPt = :omPt");
		
		boolean isFiltroTpLocalEstoque = (tpLocalEstoque != null);  

		if(isFiltroTpLocalEstoque){
			query.append("AND dwEstlocal.tpLocalEstoque = :tpLocalEstoque");	
		}

		if(isApenasTotalMaiorZero){
			query.append("AND dwEstlocalpro.qtTotal > :zero");
		}

		query.append("ORDER BY dwEstlocalpro.idEstlocalpro");
		
		query.defineParametro("omPt", omPt);
		
		if(isFiltroTpLocalEstoque){
			query.defineParametro("tpLocalEstoque", new Byte(tpLocalEstoque.getId()));
		}
		
		if(isApenasTotalMaiorZero){
			query.defineParametro("zero", BigDecimal.ZERO);
		}
		
		return query.list();
		
	}
	
	public List<DwEstlocalpro> getDwEstlocalpros(FiltroConsolLocalEstoqueDTO filtro, boolean isApenasComTotal){
		MapQuery query = new MapQuery(session);
		query.append("SELECT elp FROM DwEstlocalpro elp ");	
		query.append("LEFT JOIN FETCH elp.dwEstpro estpro ");
		query.append("LEFT JOIN FETCH estpro.omProduto p ");
		query.append("LEFT JOIN FETCH estpro.dwEst e ");
		query.append("LEFT JOIN FETCH elp.dwEstlocal el ");
		query.append("LEFT JOIN FETCH el.omPt omPt ");
		query.append("LEFT JOIN FETCH el.omPa omPa ");
		query.append("LEFT JOIN el.omGt omGt ");
		query.append("WHERE 1 = 1");
		query.append("AND NOT el IS NULL");
		
		boolean isFiltroProduto = (filtro.getOmProduto() != null && filtro.getOmProduto().getCdProduto() != null && !filtro.getOmProduto().getCdProduto().equals(""));
		if(isFiltroProduto){
			query.append("AND p.cdProduto = :cdProduto ");
		}
		
		boolean isFiltroDwEst = filtro.getDwEst() != null && filtro.getDwEst().getCdEst() != null && !filtro.getDwEst().getCdEst().equals("");
		if(isFiltroDwEst){
			query.append("AND e.cdEst = :cdEst ");			
		}
		
		boolean isFiltroDwEstLocal = filtro.getDwEstlocal() != null && filtro.getDwEstlocal().getCdLocal() != null && !filtro.getDwEstlocal().getCdLocal().equals("");
		if(isFiltroDwEstLocal){
			query.append("AND el.cdLocal = :cdLocal ");			
		}
		
		boolean isFiltroTpLocalEstoque = (filtro.getTpLocalEstoque() != 0);
		if(isFiltroTpLocalEstoque){
			query.append("AND el.tpLocalEstoque = :tpLocalEstoque ");
		}
		
		boolean isFiltroOmPt = filtro.getOmPt() != null && filtro.getOmPt().getCdPt() != null && !filtro.getOmPt().getCdPt().equals("");
		if (isFiltroOmPt) {
			query.append("AND omPt.cdPt = :cdPt ");
		}
		
		boolean isFiltroOmGt = filtro.getOmGt() != null && filtro.getOmGt().getCdGt() != null && !filtro.getOmGt().getCdGt().equals("");
		if (isFiltroOmGt) {
			query.append("AND omGt.cdGt = :cdGt ");
		}
		
		if (isApenasComTotal) {
			query.append("AND elp.qtTotal > :qtTotal ");
		}
		
		if(isFiltroProduto){
			query.defineParametro("cdProduto", filtro.getOmProduto().getCdProduto());
		}
		
		if(isFiltroDwEst) {
			query.defineParametro("cdEst", filtro.getDwEst().getCdEst());
		}
		
		if(isFiltroDwEstLocal) {
			query.defineParametro("cdLocal", filtro.getDwEstlocal().getCdLocal());
		}
		
		if (isFiltroOmPt){
			query.defineParametro("cdPt", filtro.getOmPt().getCdPt());
		}
		
		if(isFiltroOmGt){
			query.defineParametro("cdGt", filtro.getOmGt().getCdGt());
		}
		
		if(isFiltroTpLocalEstoque){
			query.defineParametro("tpLocalEstoque", filtro.getTpLocalEstoque());
		}
		
		if(isApenasComTotal) {
			query.defineParametro("qtTotal", BigDecimal.ZERO);
		}
		
		return query.list();
	}
	
	public DwEstlocalpro saveOrUpdate(DwEstlocalpro dwEstlocalpro ){
		session.saveOrUpdate(dwEstlocalpro);
		return dwEstlocalpro;
	}


	public List<DwEstlocalpro> getDwEstlocalpros(FiltroMonitorizacaoLocalEstoque filtro) {
		MapQuery query = new MapQuery(session);
		query.append("SELECT elp FROM DwEstlocalpro elp ");
		query.append("LEFT JOIN elp.dwEstpro.omProduto p ");
		query.append("LEFT JOIN elp.dwEstlocal el ");
		query.append("LEFT JOIN elp.dwEstpro.dwEst e ");
		query.append("WHERE 1 = 1");
		List<OmProduto> produtos = filtro.getProdutos();
		DwEst estoque = filtro.getEstoque();
		DwEstlocal local = filtro.getLocal();
		
		if(produtos.size() > 0){
			boolean isFirstOK = true;
			for (OmProduto produto : produtos){
				if(produto != null && produto.getCdProduto() != null && !produto.getCdProduto().equals("")){
					if (isFirstOK){
						query.append("AND (p.cdProduto = '" + produto.getCdProduto() + "' ");
						isFirstOK = false;
					}
					else{
						query.append("OR p.cdProduto = '" + produto.getCdProduto() + "' ");
					}
				}
			}
			if (!isFirstOK)
				query.append(") ");
		}
		
		if(estoque != null && estoque.getCdEst() != null && !estoque.getCdEst().equals("")){
			query.append("AND e.cdEst = :cdEst ");
			query.defineParametro("cdEst", estoque.getCdEst());
		}
		if(local != null && local.getCdLocal() != null && !local.getCdLocal().equals("")){
			query.append("AND el.cdLocal = :cdLocal ");
			query.defineParametro("cdLocal", local.getCdLocal());
		}
		
		return query.list();
	}
	
	public DwEstlocalpro getDwEstlocalproPorId(long idEstlocalpro){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwEstlocalpro estLocalPro");
		q.append("WHERE estLocalPro.idEstlocalpro = :idEstlocalpro");
		q.defineParametro("idEstlocalpro", idEstlocalpro);
		q.setMaxResults(1);
		return (DwEstlocalpro) q.uniqueResult();
	}
	
	public DwEstlocalpro getDwEstlocalproPeloEstlocalProduto(DwEstlocal dwEstlocal, OmProduto produto) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwEstlocalpro FROM DwEstlocalpro dwEstlocalpro");
		q.append("INNER JOIN dwEstlocalpro.dwEstlocal estlocal");
		q.append("INNER JOIN dwEstlocalpro.dwEstpro estpro");
		q.append("INNER JOIN estpro.omProduto produto"); 
		q.append("WHERE estlocal = :estlocal");
		q.append("AND estlocal.tpLocalEstoque = :tpLocalestoque");
		q.append("AND produto = :produto ");	
		q.append("AND estlocal.stAtivo = :stAtivo");
		q.append("ORDER BY dwEstlocalpro.idEstlocalpro");
		q.defineParametro("estlocal", dwEstlocal);
		q.defineParametro("tpLocalestoque", dwEstlocal.getTpLocalEstoque());
		q.defineParametro("produto", produto);
		q.defineParametro("stAtivo", (byte) 1);
		return (DwEstlocalpro) q.uniqueResult();
	}

	public void zerarEstoqueProduto(DwEst dwEstAlim, OmProduto omProduto) {
		MapQuery q = new MapQuery(session);
		q.append("UPDATE DwEstlocalpro dwEstlocalpro ");
		q.append(" SET dwEstlocalpro.qtEntrada = :qtEntrada ");
		q.append(" ,dwEstlocalpro.qtSaida = :qtSaida ");
		q.append(" ,dwEstlocalpro.qtAjuste = :qtAjuste ");
		q.append(" ,dwEstlocalpro.qtTotal = :qtTotal ");
		q.append(" WHERE dwEstlocalpro.dwEstpro IN( ");
		q.append(" 		SELECT dwEstpro FROM DwEstpro dwEstpro ");
		q.append(" 			WHERE dwEstpro.dwEst = :dwEst ");
		q.append(" 			AND dwEstpro.omProduto = :omProduto ");
		q.append(" 		) ");
		q.defineParametro("qtEntrada", BigDecimal.ZERO);
		q.defineParametro("qtSaida", BigDecimal.ZERO);
		q.defineParametro("qtAjuste", BigDecimal.ZERO);
		q.defineParametro("qtTotal", BigDecimal.ZERO);
		q.defineParametro("dwEst", dwEstAlim);
		q.defineParametro("omProduto", omProduto);
		q.query().executeUpdate();
		session.flush();
	}
	
}
