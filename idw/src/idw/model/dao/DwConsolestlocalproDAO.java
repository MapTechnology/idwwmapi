package idw.model.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwCal;
import idw.model.pojos.DwConsolestlocalpro;
import idw.model.pojos.DwEstlocalpro;
import idw.model.pojos.DwTurno;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.FiltroConsolLocalEstoqueDTO;

public class DwConsolestlocalproDAO {
	private final Session session;
	
	public DwConsolestlocalproDAO(Session session){
		
		this.session = session;
	}
	
	public DwConsolestlocalpro getDwConsolestlocalpro(DwCal dwCal, DwTurno dwTurno, Date dtReferencia, DwEstlocalpro dwEstlocalpro){		
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwConsolestlocalpro FROM DwConsolestlocalpro dwConsolestlocalpro");
		q.append("WHERE dwConsolestlocalpro.dwCal = :dwCal");
		q.append("AND dwConsolestlocalpro.dwTurno = :dwTurno");
		q.append("AND dwConsolestlocalpro.dtReferencia = :dtReferencia");
		q.append("AND dwConsolestlocalpro.dwEstlocalpro = :dwEstlocalpro");
		q.defineParametro("dwCal", dwCal);
		q.defineParametro("dwTurno", dwTurno);
		q.defineParametro("dtReferencia", dtReferencia);
		q.defineParametro("dwEstlocalpro", dwEstlocalpro);
		q.setMaxResults(1);
		return (DwConsolestlocalpro) q.uniqueResult();
	}
	
	public DwConsolestlocalpro getDwConsolestlocalproSenaoExistirCriar(DwCal dwCal, DwTurno dwTurno, Date dtReferencia, 
			DwEstlocalpro dwEstlocalpro, Date dthrIturno, Date dthrFturno){
		
		DwConsolestlocalpro dwConsolestlocalpro = getDwConsolestlocalpro(dwCal, dwTurno, dtReferencia, dwEstlocalpro);
		
		if(dwConsolestlocalpro == null && dwEstlocalpro != null){
			dwConsolestlocalpro = new DwConsolestlocalpro();
			dwConsolestlocalpro.setDwCal(dwCal);
			dwConsolestlocalpro.setDwTurno(dwTurno);
			dwConsolestlocalpro.setDtReferencia(dtReferencia);
			dwConsolestlocalpro.setDwEstlocalpro(dwEstlocalpro);
			dwConsolestlocalpro.setDthrIturno(dthrIturno);
			dwConsolestlocalpro.setDthrFturno(dthrFturno);			
			dwConsolestlocalpro.setMes(new BigDecimal(DataHoraRN.getMes(dtReferencia))) ;
			dwConsolestlocalpro.setAno(new BigDecimal(DataHoraRN.getAno(dtReferencia)));
			dwConsolestlocalpro.setQtAjuste(BigDecimal.ZERO);
			dwConsolestlocalpro.setQtConsumida(BigDecimal.ZERO);
			dwConsolestlocalpro.setQtEntrada(BigDecimal.ZERO);
			dwConsolestlocalpro.setQtPerda(BigDecimal.ZERO);
			dwConsolestlocalpro.setQtSaida(BigDecimal.ZERO);
			dwConsolestlocalpro.setQtTotal(BigDecimal.ZERO);
			session.saveOrUpdate(dwConsolestlocalpro);
		}
		
		return dwConsolestlocalpro;
	}
	
	public List<DwConsolestlocalpro> getConsolLocalEstoques(FiltroConsolLocalEstoqueDTO filtro){
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwConsolestlocalpro FROM DwConsolestlocalpro dwConsolestlocalpro");
		q.append("INNER JOIN FETCH dwConsolestlocalpro.dwTurno turno");
		q.append("INNER JOIN FETCH dwConsolestlocalpro.dwEstlocalpro localpro");
		q.append("INNER JOIN FETCH localpro.dwEstlocal estlocal");
		q.append("INNER JOIN FETCH estlocal.dwEst est");
		q.append("LEFT JOIN FETCH estlocal.omGt gt");
		q.append("LEFT JOIN FETCH estlocal.omPt pt");
		q.append("LEFT JOIN FETCH estlocal.omPa ");
		q.append("INNER JOIN FETCH localpro.dwEstpro estpro");
		q.append("INNER JOIN FETCH estpro.omProduto produto");
		q.append("WHERE 1 = 1");
		if(filtro.getDwTurno() != null){
			q.append("AND turno = :turno"); 
		}
		if(filtro.getOmProduto() != null){
			q.append("AND produto = :produto"); 
		}
		if(filtro.getDwEst() != null){
			q.append("AND est = :estoque");
		}
		if(filtro.getDwEstlocal() != null){
			q.append("AND estlocal = :local");
		}
		if(filtro.getOmGt() != null){
			q.append("AND gt = :gt"); 
		}
		if(filtro.getOmPt() != null){
			q.append("AND pt = :pt");
		}
		if(filtro.getTpLocalEstoque() != 0){
			q.append("AND estlocal.tpLocalEstoque = :tpLocalEstoque");
		}
		if(filtro.getDtRefInicio() != null && filtro.getDtRefFim() != null){
			q.append("AND dwConsolestlocalpro.dtReferencia >= :dtRefInicio AND dwConsolestlocalpro.dtReferencia <= :dtRefFim");
		}
		
		q.defineParametro("turno", filtro.getDwTurno());
		q.defineParametro("produto", filtro.getOmProduto());
		q.defineParametro("estoque", filtro.getDwEst());
		q.defineParametro("local", filtro.getDwEstlocal());
		q.defineParametro("gt", filtro.getOmGt());
		q.defineParametro("pt", filtro.getOmPt());
		q.defineParametro("tpLocalEstoque", filtro.getTpLocalEstoque());
		q.defineParametroTimestamp("dtRefInicio", filtro.getDtRefInicio());
		q.defineParametroTimestamp("dtRefFim", filtro.getDtRefFim());
		return q.list();
	}

	public DwConsolestlocalpro getDwConsolestlocalproUltimoRegistroValido(DwEstlocalpro dwEstlocalpro, byte tpLocalEstoque) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwConsolestlocalpro FROM DwConsolestlocalpro dwConsolestlocalpro");
		q.append("INNER JOIN FETCH dwConsolestlocalpro.dwEstlocalpro localpro");
		q.append("INNER JOIN FETCH localpro.dwEstlocal estlocal");
		q.append("INNER JOIN FETCH localpro.dwEstpro estpro");
		q.append("LEFT JOIN FETCH estlocal.omPt pt");
		q.append("LEFT JOIN FETCH estlocal.omPa pa");
		q.append("INNER JOIN FETCH estpro.omProduto produto");
		q.append("WHERE produto.cdProduto = :cdProduto");

		if (dwEstlocalpro.getDwEstlocal().getOmPt() != null) {
			q.append("and pt.cdPt = :cdPt");
			q.append("AND pt.omAlimByIdAlim = :idAlim");
		}
		if (dwEstlocalpro.getDwEstlocal().getOmPa() != null)
			q.append("AND pa.cdPa = :cdPa");

		
		q.append("AND estlocal.tpLocalEstoque = :tpLocalEstoque");
		q.append("ORDER BY dwConsolestlocalpro.idConsolestlocalpro DESC");
		
		
		if (dwEstlocalpro.getDwEstlocal().getOmPt() != null) {
			q.defineParametro("cdPt", dwEstlocalpro.getDwEstlocal().getOmPt().getCdPt());
			q.defineParametro("idAlim", dwEstlocalpro.getDwEstlocal().getOmPt().getOmAlimByIdAlim());
		}
		if (dwEstlocalpro.getDwEstlocal().getOmPa() != null)
			q.defineParametro("cdPa", dwEstlocalpro.getDwEstlocal().getOmPa().getCdPa());
		
		q.defineParametro("cdProduto", dwEstlocalpro.getDwEstpro().getOmProduto().getCdProduto());
		q.defineParametro("tpLocalEstoque", tpLocalEstoque);
		
		q.setMaxResults(1);
		return (DwConsolestlocalpro) q.uniqueResult();
	}
	
}
