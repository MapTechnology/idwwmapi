package idw.model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.PpNec;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.PpNecDTO;

public class PpNecDAO {
	
	private Session session;
	
	public PpNecDAO(Session session) {
		this.session = session;
	}
	
	public List<PpNec> getPpNecs(PpNecDTO ppNecDTO, Date d1, Date d2, boolean isPesquisarDatas) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT DISTINCT ppnec");
		q.append("FROM PpNec ppnec");
		q.append("LEFT JOIN FETCH ppnec.ppNeccrons ppneccrons");		
		q.append("JOIN ppnec.omProduto omproduto");
		q.append("left JOIN ppnec.ppCliente ppcliente");
		q.appendWhere(MapQuery._NULL, "ppnec.cdNec = :cdnec", ((ppNecDTO.getCdNec() != null) && (ppNecDTO.getCdNec().equals("") == false)));
		q.appendWhere(MapQuery._AND, "ppnec.idNec = :idnec", ((ppNecDTO.getIdNec() != 0L) && (ppNecDTO.getIdNec() > 0)) );
		q.appendWhere(MapQuery._AND, "omproduto.cdProduto = :cdproduto", (ppNecDTO.getOmProduto() != null) && (ppNecDTO.getOmProduto().getCdProduto() != null));
		q.appendWhere(MapQuery._AND, "ppneccrons.dtDesejada BETWEEN :d1 AND :d2", isPesquisarDatas);
		q.appendWhere(MapQuery._AND, "ppcliente.cdCliente = :cdcliente", (ppNecDTO.getPpCliente() != null) && (ppNecDTO.getPpCliente().getCdCliente().equals("") == false));
		q.appendWhere(MapQuery._AND, "ppnec.dtRevisao >= :dtRevisao AND ppnec.dtRevisao <= :dtRevisaoF ", (ppNecDTO.getDtRevisao() != null));
		q.appendWhere(MapQuery._AND, "ppnec.dtStativo >= :dtStativo AND ppnec.dtStativo <= :dtStativoF ", (ppNecDTO.getDtStativo() != null));
		
		if(ppNecDTO.getStAtivo()== null){
			q.appendWhere(MapQuery._AND, "ppnec.stAtivo = 1", true);
		}else{
			q.appendWhere(MapQuery._AND, "ppnec.stAtivo = :stativo", true);
			q.defineParametro("stativo", ppNecDTO.getStAtivo());
		}

		q.defineParametro("cdnec", ppNecDTO.getCdNec());
		q.defineParametro("idnec", ppNecDTO.getIdNec());

		if (isPesquisarDatas == true){
			q.defineParametroData("d1", d1);
			q.defineParametroData("d2", d2);
		}

		if ((ppNecDTO.getPpCliente() != null) && (ppNecDTO.getPpCliente().getCdCliente().equals("") == false)){
			q.defineParametro("cdcliente", ppNecDTO.getPpCliente().getCdCliente());
		}
		if (ppNecDTO.getOmProduto() != null) {
			q.defineParametro("cdproduto", ppNecDTO.getOmProduto().getCdProduto());
		}
		
		if(ppNecDTO.getDtRevisao()!=null){
			q.defineParametro("dtRevisao", ppNecDTO.getDtRevisao());
			q.defineParametro("dtRevisaoF",DataHoraRN.getDataHora235959(ppNecDTO.getDtRevisao()));
		}
		if(ppNecDTO.getDtStativo()!=null){
			q.defineParametro("dtStativo", ppNecDTO.getDtStativo());
			q.defineParametro("dtStativoF",DataHoraRN.getDataHora235959(ppNecDTO.getDtStativo()));
		}

		return q.list();
	}
	
	public List<PpNec> getPpNecAtivos(){
		MapQuery q = new MapQuery(session);
		q.append("FROM PpNec ppnec");
		q.append("WHERE ppnec.stAtivo = :stAtivo");
		q.defineParametro("stAtivo", 1);
		return q.list();
	}

	public List<PpNec> getPpNecAtivosPorCdOuCliente(String cdNec, Long idCliente){
		MapQuery q = new MapQuery(session);
		q.append("FROM PpNec ppnec");
		q.append("WHERE ppnec.stAtivo = :stAtivo");
		if(idCliente != null && idCliente != 0) {
			q.append("AND ppnec.ppCliente.idCliente = :idCliente");
			q.defineParametro("idCliente", idCliente);
		}
		q.defineParametro("stAtivo", 1);
		return q.list();
	}
	
	public PpNec getPpNecPorId(Long idNec) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT ppnec");
		q.append("FROM PpNec ppnec");
		q.append("WHERE ppnec.idNec = :idNec");
		q.defineParametro("idNec", idNec);
		return (PpNec) q.uniqueResult();
	}
	
	public PpNec getPpNecPorCdAtivo(String cdNec) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT ppnec");
		q.append("FROM PpNec ppnec");
		q.append("WHERE ppnec.cdNec = :cdNec");
		q.append("AND ppnec.stAtivo = :stAtivo");
		q.defineParametro("stAtivo", 1);
		q.defineParametro("cdNec", cdNec);
		q.setMaxResults(1);
		return (PpNec) q.uniqueResult();
	}
	
	/**
	* BUSCA O PEDIDO/NECESSIDADE BASEADO NO SEU CÓDIGO E NO PT, SE {@code cdPt} FOR DIFERENTE DE NULO E DE VAZIO
	* @param cdNec
	* @param cdPt
	* @return
	*/
	public PpNec getPpNecAtivoPorCdOuCdPt(String cdNec, String cdPt){
		boolean isFiltraPt = cdPt != null && !cdPt.isEmpty();
		MapQuery q = new MapQuery(session);
		q.append("SELECT ppnec");
		q.append("FROM PpNec ppnec");
		q.append("WHERE ppnec.cdNec = :cdNec");
		q.append("AND ppnec.stAtivo = :stAtivo");
		if(isFiltraPt){
			q.append("AND ppnec.omPt.cdPt = :cdPt");
		}
		q.defineParametro("stAtivo", 1);
		q.defineParametro("cdNec", cdNec);
		if(isFiltraPt){
			q.defineParametro("cdPt", cdPt);
		}
		q.setMaxResults(1);
		return (PpNec) q.uniqueResult();
	}

}
