package idw.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.injet.Ijtbinj;
import idw.model.pojos.injet.Ijtbinjstatus;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.LeiturasCODTO;
import idw.webservices.dto.PtDTO;
import ms.util.ConversaoTipos;

public class OmPtDAO {
	
	private Session session;

	private static final int sp_Injet_Molde = 1;
	private static final int sp_Injet_OP = 2;
	private static final int sp_Injet_Produto = 3;
	private static final int sp_Injet_Molde_Com_Estrutura_OP_Criada_Mestre = 4;
	private static final int sp_Injet_Produto_Com_Estrutura_OP_Criada_Mestre = 5;
	private static final int sp_Injet_Produto_OP_Montagem = 6;
	private static final int sp_Injet_Produto_OP_Criada_Mestre = 7;
	private static final int sp_Injet_Molde_Produto_OP_Criada_Mestre = 8;
	private static final int sp_Injet_Cartoes_Kanban_OP_Criada_Mestre = 9;
	private static final int sp_Injet_CDM_Tigre = 10;
	private static final int sp_Injet_OP_Fim_Automatico = 11;
	private static final int sp_Injet_OP_Arthi_Integracao = 12;
	private static final int sp_Injet_OP_Fitesa_Corte = 13;

	
	public OmPtDAO(Session session){
		this.session = session;
	}
	
	public List<OmPt> getOmPts(PtDTO filtro){
		MapQuery q = new MapQuery(session);
		q.append("SELECT t");
		q.append("FROM OmPt t");
		q.append("WHERE 1 = 1");
		
		if ((filtro.getPt().getIdPt() != null) && (filtro.getPt().getIdPt() != 0)){
			q.append("AND t.idPt = :idPt");
		}else{
			if ((filtro.getPt().getCdPt() != null) && !filtro.getPt().getCdPt().equals("")){
				q.append("AND t.cdPt like :cdPt");
			}
			if ((filtro.getPt().getDsPt() != null) && !filtro.getPt().getDsPt().equals("")){
				q.append("AND t.dsPt = :dsPt");
			}
			if ((filtro.getPt().getDsCurta() != null) && !filtro.getPt().getDsCurta().equals("")){
				q.append("AND t.dsCurta = :dsCurta");
			}
			if (filtro.getPt().getDtRevisao()!=null){
				q.append("AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF");
			}
			if (filtro.getPt().getDtStativo()!=null){
				q.append("AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF");
			}
			if ((filtro.getPt().getUrlConexao() != null) && !filtro.getPt().getUrlConexao().equals("")){
				q.append("AND t.urlConexao = :urlConexao");
			}
			if ((filtro.getPt().getDepara() != null) && !filtro.getPt().getDepara().equals("")){
				q.append("AND t.depara = :dePara");
			}
			if (filtro.getPt().getEstagio() != null){
				q.append("AND t.estagio = :estagio");
			}
			if ((filtro.getPt().getTpImpprog() != null) && (filtro.getPt().getTpImpprog()<(byte)3)){
				q.append("AND t.tpImpprog = :tpImpprog");
			}
			if ((filtro.getPt().getOmGt() != null) && !filtro.getPt().getOmGt().getCdGt().equals("")){
				q.append("AND t.omGt.cdGt = :cdGt");
			}
			if ((filtro.getPt().getOmGt() != null) && !filtro.getPt().getOmGt().getDsGt().equals("")){
				q.append("AND t.omGt.dsGt = :dsGt");
			}
			if ((filtro.getPt().getOmCc() != null) && !filtro.getPt().getOmCc().getCdCc().equals("")){
				q.append("AND t.omCc.cdCc = :cdCc");
			}
			if ((filtro.getPt().getOmCc() != null) && !filtro.getPt().getOmCc().getDsCc().equals("")){
				q.append("AND t.omCc.dsCc = :dsCc");
			}
			if ((filtro.getPt().getOmTppt() != null) && !filtro.getPt().getOmTppt().getCdTppt().equals("")){
				q.append("AND t.omTppt.cdTppt = :cdTppt");
			}
			if ((filtro.getPt().getOmTppt() != null) && !filtro.getPt().getOmTppt().getDsTppt().equals("")){
				q.append("AND t.omTppt.dsTppt = :dsTppt");
			}
			if ((filtro.getPt().getOmUsrByIdUsrrevisao() != null) && !filtro.getPt().getOmUsrByIdUsrrevisao().getCdUsr().equals("")){
				q.append("AND t.omUsrByIdUsrrevisao.cdUsr = :cdUsrRev");
			}
			if ((filtro.getPt().getOmUsrByIdUsrrevisao() != null) && !filtro.getPt().getOmUsrByIdUsrrevisao().getDsNome().equals("")){
				q.append("AND t.omUsrByIdUsrrevisao.dsNome = :dsNomeRev");
			}
			if ((filtro.getPt().getOmUsrByIdUsrstativo() != null) && !filtro.getPt().getOmUsrByIdUsrstativo().getCdUsr().equals("")){
				q.append("AND t.omUsrByIdUsrstativo.cdUsr = :cdUsrSt");
			}
			if ((filtro.getPt().getOmUsrByIdUsrstativo() != null) && !filtro.getPt().getOmUsrByIdUsrstativo().getDsNome().equals("")){
				q.append("AND t.omUsrByIdUsrstativo.dsNome = :dsNomeSt");
			}
			if (filtro.getPt().getRevisao()!=null){
				q.append("AND t.revisao = :revisao");
			}
			if ((filtro.getPt().getStAtivo() != null) && (filtro.getPt().getStAtivo()<(byte)2)){
				q.append("AND t.stAtivo = :stAtivo");
			}
		}
		
		q.append("ORDER BY t.cdPt");
		
		q.defineParametro("idPt", filtro.getPt().getIdPt());
		q.defineParametro("cdPt", filtro.getPt().getCdPt());
		q.defineParametro("dsPt", filtro.getPt().getDsPt());
		q.defineParametro("dsCurta", filtro.getPt().getDsCurta());
		q.defineParametro("urlConexao", filtro.getPt().getUrlConexao());
		q.defineParametro("dePara", filtro.getPt().getDepara());
		q.defineParametro("revisao", filtro.getPt().getRevisao());
		
		if (filtro.getPt().getEstagio() != null){
			q.defineParametro("estagio", filtro.getPt().getEstagio().intValue());
		}
		if(filtro.getPt().getTpImpprog() != null){
			q.defineParametro("tpImpprog", filtro.getPt().getTpImpprog().byteValue());
		}
		if(filtro.getPt().getStAtivo() != null){
			q.defineParametro("stAtivo", filtro.getPt().getStAtivo().byteValue());
		}
		if (filtro.getPt().getOmGt() != null){
			q.defineParametro("cdGt", filtro.getPt().getOmGt().getCdGt());
			q.defineParametro("dsGt", filtro.getPt().getOmGt().getDsGt());
		}
		if (filtro.getPt().getOmTppt() != null){
			q.defineParametro("cdTppt", filtro.getPt().getOmTppt().getCdTppt());
			q.defineParametro("dsTppt", filtro.getPt().getOmTppt().getDsTppt());
		}
		if (filtro.getPt().getOmCc() != null){
			q.defineParametro("cdCc", filtro.getPt().getOmCc().getCdCc());
			q.defineParametro("dsCc", filtro.getPt().getOmCc().getDsCc());
		}
		if (filtro.getPt().getOmUsrByIdUsrrevisao() != null){
			q.defineParametro("cdUsrRev", filtro.getPt().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getPt().getOmUsrByIdUsrrevisao().getDsNome());
		}
		if (filtro.getPt().getOmUsrByIdUsrstativo() != null){
			q.defineParametro("cdUsrSt", filtro.getPt().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getPt().getOmUsrByIdUsrstativo().getDsNome());
		}
		if (filtro.getPt().getDtRevisao()!=null){
			try {
				q.defineParametroTimestamp("dtRevisao", filtro.getPt().getDtRevisao());
				q.defineParametroTimestamp("dtRevisaoF", DataHoraRN.getDataHora235959(filtro.getPt().getDtRevisao()));
			} catch (Exception e) {
			}
		}
		if (filtro.getPt().getDtStativo()!=null){
			try {
				q.defineParametroTimestamp("dtStativo", filtro.getPt().getDtStativo());
				q.defineParametroTimestamp("dtStativoF", DataHoraRN.getDataHora235959(filtro.getPt().getDtStativo()));
			} catch (Exception e) {
			}
		}
		return q.list();
	}
	
	public List<OmPt> getOmPtsAtivosOrderByCd(){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmPt t");
		// Alessandre, comentei a linha abaixo pois somente os PTs com OP estavam sendo retornados
		// E para a OP simples eh necessario tambem os PTs sem OP. Caso prejudique outro ponto, deve-se separar
		// aparentemente verifiquei que nao vai prejudicar
		//listaOmPt = ptDAO.getOmPtsAtivosOrderByCd();
		// q.append("JOIN FETCH t.ppCp ppcp");
		q.append("WHERE t.stAtivo = :stAtivo");
		q.append("ORDER BY t.cdPt");
		q.defineParametro("stAtivo", (byte)1);
		return q.list();
	}
	
	public OmPt getConsultaOmPtbyCdMaquina(String cdPt){
		MapQuery q = new MapQuery(session);

		q.append("FROM OmPt ompt ");
		q.append("LEFT JOIN FETCH ompt.omAlimByIdAlimcorrente omalimcorrente ");
		q.append("LEFT JOIN FETCH omalimcorrente.omMapa ommapa ");
		q.append("WHERE ompt.cdPt = :cdPt AND ompt.stAtivo = 1 ");
		q.defineParametro("cdPt", cdPt);
		
		List<OmPt> listaompt = q.list();	
		
		OmPt omPt = listaompt.get(0);
		
		return omPt;
	}
	
	public OmPt getOmPtbyCdMaquina(LeiturasCODTO leituras){

		return getConsultaOmPtbyCdMaquina(leituras.getCdMaquina());
		
	}

	public OmPt getOmPtPorId(long idPt){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmPt ompt");
		q.append("WHERE ompt.idPt = :idPt");
		q.defineParametro("idPt", idPt);
		q.setMaxResults(1);
		return (OmPt) q.uniqueResult();
	}
	
	public OmPt getOmPtAtivoComUltimaRevisao(String cdPt){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmPt ompt");
		q.append("WHERE ompt.cdPt = :cdPt");
		q.append("AND ompt.stAtivo = 1");
		q.append("ORDER BY ompt.revisao DESC");
		q.defineParametro("cdPt", cdPt);
		q.setMaxResults(1);
		return (OmPt) q.uniqueResult();
	}
	
	public OmPt getOmPtComMaiorRevisao(String cdPt, long revisao){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmPt ompt");
		q.append("WHERE ompt.cdPt = :cdPt");
		q.append("AND ompt.revisao > :revisao");
		q.defineParametro("cdPt", cdPt);
		q.defineParametro("revisao", revisao);
		q.setMaxResults(1);
		return (OmPt) q.uniqueResult();
	}
	
	public OmPt getOmPtPorAlim(long idAlim){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmPt ompt");
		q.append("where ompt.omAlimByIdAlimcorrente.idAlim = :idalim");
		q.defineParametro("idalim", idAlim);
		q.setMaxResults(1);
		return (OmPt) q.uniqueResult();
	}
	
	public List<OmPt> getOmPtsPorTppt(long idTppt){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmPt t");
		q.append("WHERE t.stAtivo = :stAtivo");
		q.append("AND t.omTppt.idTppt = :idOmTppt");
		q.append("ORDER BY t.cdPt");
		q.defineParametro("idOmTppt", idTppt);
		q.defineParametro("stAtivo", (byte)1);
		return q.list();
	}
	
	public OmPt getOmPtPorCdAtivoOrderById(String cdPt){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmPt ompt");
		q.append("WHERE ompt.cdPt = :cdPt");
		q.append("AND ompt.stAtivo = :stAtivo");
		q.append("ORDER BY ompt.idPt ");
		q.defineParametro("cdPt", cdPt);
		q.defineParametro("stAtivo", (byte)1);
		q.setMaxResults(1);
		return (OmPt) q.uniqueResult();
	}
	
	public List<OmPt> getOmPtsContamGt(String cdGt) {
		MapQuery q = getMapQueryOmPtsContamGt(cdGt);
		return q.list();
	}
	
	public OmPt getOmPtContaGt(String cdGt) {
		MapQuery q = getMapQueryOmPtsContamGt(cdGt);
		q.setMaxResults(1);
		return (OmPt) q.uniqueResult();
	}

	private MapQuery getMapQueryOmPtsContamGt(String cdGt) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT ompt");
		q.append("FROM OmPt ompt");
		q.append("JOIN FETCH ompt.omGt omgt");
		q.append("WHERE omgt.cdGt = :cdGt");
		q.append("AND ompt.stAtivo = :stAtivo");
		q.append("AND ompt.isApongt = :isApongt");
		q.append("AND omgt.stAtivo = :stAtivo");
		q.append("ORDER BY ompt.cdPt ");
		q.defineParametro("cdGt", cdGt);
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("isApongt", true);
		return q;
	}

	public OmPt getOmPtAtivoComUltimaRevisaoInjet(DAOGenericoInjet dao, String cdPt){
		OmPt retorno;
		Ijtbinj maq;
		MapQuery q = new MapQuery(dao.getSession());
		q.append("SELECT a FROM Ijtbinj a");		
		q.append("LEFT JOIN FETCH a.ijtbinjstatuses b");
		q.append("WHERE a.cdinjestendido = :cdPt");
		q.append("AND a.tpabertsessaoprod IS NOT NULL ");
		//q.append("AND a.stinjetora = 0 ");
		
		q.defineParametro("cdPt", cdPt);
		q.setMaxResults(1);
		maq = (Ijtbinj) q.uniqueResult();
		
		String dsSessaoProdMaq = "";
		
		switch ((int) maq.getTpabertsessaoprod()) {
			case sp_Injet_Molde:
				dsSessaoProdMaq = "Molde";
				break;
			case sp_Injet_OP:
				dsSessaoProdMaq = "OP";
				break;
			case sp_Injet_Produto:
				dsSessaoProdMaq = "Produto";
				break;
			case sp_Injet_Molde_Com_Estrutura_OP_Criada_Mestre:
				dsSessaoProdMaq = "Molde-Estrutura";
				break;
			case sp_Injet_Produto_Com_Estrutura_OP_Criada_Mestre:
				dsSessaoProdMaq = "Produto-Estrutura";
				break;
			case sp_Injet_Produto_OP_Montagem:
				dsSessaoProdMaq = "OP Montagem";
				break;
			case sp_Injet_Produto_OP_Criada_Mestre:
				dsSessaoProdMaq = "Produto-OP";
				break;
			case sp_Injet_Molde_Produto_OP_Criada_Mestre:
				dsSessaoProdMaq = "Molde-Produto-OP";
				break;
			case sp_Injet_Cartoes_Kanban_OP_Criada_Mestre:
				dsSessaoProdMaq = "Cartao Kanban";
				break;
			case sp_Injet_CDM_Tigre:
				dsSessaoProdMaq = "CDM Tigre";
				break;
			case sp_Injet_OP_Fim_Automatico:
				dsSessaoProdMaq = "OP Fim Auto";
				break;
			case sp_Injet_OP_Arthi_Integracao:
				dsSessaoProdMaq = "OP Arthi";
				break;
			case sp_Injet_OP_Fitesa_Corte:			
				dsSessaoProdMaq = "OP Fitesa Corte";
				break;
		}
		
		retorno = new OmPt();
		retorno.setCdPt(cdPt);
		retorno.setDsCurta(maq.getCdidentific());
		retorno.setDsPt(maq.getCdidentific());
		
		if (maq.getCdinjetora().substring(0, 1).equals("|")) {
			retorno.setIdPt(ConversaoTipos.converteParaBigDecimal(maq.getCdinjetora().substring(1, 6)).longValue());
		} else {
			retorno.setIdPt(ConversaoTipos.converteParaBigDecimal(ConversaoTipos.converteStringParaSequenciaNumericaUniCode(maq.getCdinjetora())).longValue());
		}		
		retorno.setDsSessao(dsSessaoProdMaq);
		
		retorno.setOmTppt(new OmTppt());
		
		retorno.setIsPerdasinc(false);
		retorno.setIsConsolpendente(false);
		
		if (maq.getIjtbinjstatuses() != null && maq.getIjtbinjstatuses().size() > 0) {
			Ijtbinjstatus injst = maq.getIjtbinjstatuses().iterator().next();
			
			retorno.setIsPerdasinc(((Character) injst.getStperdasinc()).toString().equals("1"));
			retorno.setIsConsolpendente(((Character) injst.getStdelayconsol()).toString().equals("1"));
		}
		
		return retorno;
	}
	
	public List<OmPt> getOmPtsAtivosByGt(DAOGenericoInjet dao, String cdGt){
		
		List<OmPt> retorno = new ArrayList<OmPt>();
		List<Ijtbinj> listaMaquinas;
		String dsSessaoProdMaq = "";
		
		
		MapQuery q = new MapQuery(dao.getSession());
		q.append("SELECT b FROM Ijgalobj a");
		q.append("INNER JOIN a.ijtbinj b");
		q.append("INNER JOIN a.ijtbgal c");
	
		q.append("WHERE c.cdgalpao = :cdGt");
		
		q.defineParametro("cdGt", cdGt);
		
		listaMaquinas = q.list();
		
		for (Ijtbinj maq : listaMaquinas) {
			
			switch ((int) maq.getTpabertsessaoprod()) {
				case sp_Injet_Molde:
					dsSessaoProdMaq = "Molde";
					break;
				case sp_Injet_OP:
					dsSessaoProdMaq = "OP";
					break;
				case sp_Injet_Produto:
					dsSessaoProdMaq = "Produto";
					break;
				case sp_Injet_Molde_Com_Estrutura_OP_Criada_Mestre:
					dsSessaoProdMaq = "Molde-Estrutura";
					break;
				case sp_Injet_Produto_Com_Estrutura_OP_Criada_Mestre:
					dsSessaoProdMaq = "Produto-Estrutura";
					break;
				case sp_Injet_Produto_OP_Montagem:
					dsSessaoProdMaq = "OP Montagem";
					break;
				case sp_Injet_Produto_OP_Criada_Mestre:
					dsSessaoProdMaq = "Produto-OP";
					break;
				case sp_Injet_Molde_Produto_OP_Criada_Mestre:
					dsSessaoProdMaq = "Molde-Produto-OP";
					break;
				case sp_Injet_Cartoes_Kanban_OP_Criada_Mestre:
					dsSessaoProdMaq = "Cartao Kanban";
					break;
				case sp_Injet_CDM_Tigre:
					dsSessaoProdMaq = "CDM Tigre";
					break;
				case sp_Injet_OP_Fim_Automatico:
					dsSessaoProdMaq = "OP Fim Auto";
					break;
				case sp_Injet_OP_Arthi_Integracao:
					dsSessaoProdMaq = "OP Arthi";
					break;
				case sp_Injet_OP_Fitesa_Corte:			
					dsSessaoProdMaq = "OP Fitesa Corte";
					break;
			}
			
			OmPt pt = new OmPt();
			pt.setCdPt(maq.getCdinjestendido());
			pt.setDsCurta(maq.getCdidentific());
			pt.setDsPt(maq.getCdidentific());
			
			if (maq.getCdinjetora().substring(0, 1).equals("|")) {
				pt.setIdPt(ConversaoTipos.converteParaBigDecimal(maq.getCdinjetora().substring(1, 5)).longValue());
			} else {
				pt.setIdPt(ConversaoTipos.converteParaBigDecimal(ConversaoTipos.converteStringParaSequenciaNumericaUniCode(maq.getCdinjetora())).longValue());
			}		
			pt.setDsSessao(dsSessaoProdMaq);
			
			retorno.add(pt);
		}
		
		return retorno;
		
	
		
	}

	
	public List<OmPt> getOmPtsAtivosOrderByCdInjet(DAOGenericoInjet dao){
		List<OmPt> retorno = new ArrayList<OmPt>();
		List<Ijtbinj> listaMaquinas;
		String dsSessaoProdMaq = "";

		MapQuery q = new MapQuery(dao.getSession());
		q.append("SELECT a FROM Ijtbinj a");
		q.append("WHERE a.tpabertsessaoprod IS NOT NULL ");
		//q.append("AND a.stinjetora = 0 ");
		q.append("ORDER BY a.cdinjestendido");
		listaMaquinas = q.list();
		
		for (Ijtbinj maq : listaMaquinas) {
			
			switch ((int) maq.getTpabertsessaoprod()) {
				case sp_Injet_Molde:
					dsSessaoProdMaq = "Molde";
					break;
				case sp_Injet_OP:
					dsSessaoProdMaq = "OP";
					break;
				case sp_Injet_Produto:
					dsSessaoProdMaq = "Produto";
					break;
				case sp_Injet_Molde_Com_Estrutura_OP_Criada_Mestre:
					dsSessaoProdMaq = "Molde-Estrutura";
					break;
				case sp_Injet_Produto_Com_Estrutura_OP_Criada_Mestre:
					dsSessaoProdMaq = "Produto-Estrutura";
					break;
				case sp_Injet_Produto_OP_Montagem:
					dsSessaoProdMaq = "OP Montagem";
					break;
				case sp_Injet_Produto_OP_Criada_Mestre:
					dsSessaoProdMaq = "Produto-OP";
					break;
				case sp_Injet_Molde_Produto_OP_Criada_Mestre:
					dsSessaoProdMaq = "Molde-Produto-OP";
					break;
				case sp_Injet_Cartoes_Kanban_OP_Criada_Mestre:
					dsSessaoProdMaq = "Cartao Kanban";
					break;
				case sp_Injet_CDM_Tigre:
					dsSessaoProdMaq = "CDM Tigre";
					break;
				case sp_Injet_OP_Fim_Automatico:
					dsSessaoProdMaq = "OP Fim Auto";
					break;
				case sp_Injet_OP_Arthi_Integracao:
					dsSessaoProdMaq = "OP Arthi";
					break;
				case sp_Injet_OP_Fitesa_Corte:			
					dsSessaoProdMaq = "OP Fitesa Corte";
					break;
			}
			
			OmPt pt = new OmPt();
			pt.setCdPt(maq.getCdinjestendido());
			pt.setDsCurta(maq.getCdidentific());
			pt.setDsPt(maq.getCdidentific());
			
			if (maq.getCdinjetora().substring(0, 1).equals("|")) {
				pt.setIdPt(ConversaoTipos.converteParaBigDecimal(maq.getCdinjetora().substring(1, 5)).longValue());
			} else {
				pt.setIdPt(ConversaoTipos.converteParaBigDecimal(ConversaoTipos.converteStringParaSequenciaNumericaUniCode(maq.getCdinjetora())).longValue());
			}		
			pt.setDsSessao(dsSessaoProdMaq);
			
			retorno.add(pt);
		}
		
		return retorno;
		
	}	
	
}
