package idw.model.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;

import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.OmProduto;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.model.pojos.template.OmProdutoTemplate.TpProduto;
import idw.model.rn.DataHoraRN;

public class OmProdutoDAO {

	private Session session;
	
	public OmProdutoDAO(Session session){
		this.session = session;
	}
	
	public List<OmProduto> getProdutosMax50(OmProduto filtro){
		MapQuery q = new MapQuery(session);
		q.append("SELECT t");
		q.append("FROM OmProduto t");
		q.append("WHERE 1 = 1");
		
		if (filtro.getIdProduto() != 0) {
			q.append("AND t.idProduto = :idProduto");
		} else {
			if ((filtro.getCdProduto() != null )&&(!filtro.getCdProduto().equals(""))) {
				q.append("AND t.cdProduto like :cdProduto");
			}
			if ((filtro.getDsProduto() != null)&&(!filtro.getDsProduto().equals(""))) {
				q.append("AND t.dsProduto = :dsProduto");
			}
			if ((filtro.getDsComplemento() != null)&&(!filtro.getDsComplemento().equals(""))) {
				q.append("AND t.dsComplemento = :dsComplemento");
			}
			if ((filtro.getDepara() != null)&&(!filtro.getDepara().equals(""))) {
				q.append("AND t.depara = :depara");
			}
			if (filtro.getDtRevisao() != null) {
				q.append("AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF");
			}
			if (filtro.getMinValposalim() != null) {
				q.append("AND t.minValposalim = :minValposalim");
			}
			if (filtro.getVlCustounit() != null){
				q.append("AND t.vlCustounit = :vlCustounit");
			}
			if(filtro.getOmUnidmedida() != null){
				if ((filtro.getOmUnidmedida().getCdUnidmedida() !=null) && (!filtro.getOmUnidmedida().getCdUnidmedida().equals(""))) {
					q.append("AND t.omUnidmedida.cdUnidmedida = :cdUnidmedida");
				}
				if ((filtro.getOmUnidmedida().getDsUnidmedida() != null) && (!filtro.getOmUnidmedida().getDsUnidmedida().equals(""))) {
					q.append("AND t.omUnidmedida.dsUnidmedida = :dsUnidmedida");
				}
			}
			if(filtro.getOmProgrp() != null){
				if ((filtro.getOmProgrp().getCdProgrp() != null ) && (!filtro.getOmProgrp().getCdProgrp().equals(""))) {
					q.append("AND t.omProgrp.cdProgrp = :cdProgrp");
				}
				if ((filtro.getOmProgrp().getDsProgrp() != null) && (!filtro.getOmProgrp().getDsProgrp().equals(""))) {
					q.append("AND t.omProgrp.dsProgrp = :dsProgrp");
				}		
			}
			if (filtro.getOmCc() != null){
				if ((filtro.getOmCc().getCdCc() != null) && (!filtro.getOmCc().getCdCc().equals(""))) {
					q.append("AND t.omCc.cdCc = :cdCc");
				}
				if ((filtro.getOmCc().getDsCc() != null) && (!filtro.getOmCc().getDsCc().equals(""))) {
					q.append("AND t.omCc.dsCc = :dsCc");
				}
			}
			if(filtro.getOmFor() != null){
				if ((filtro.getOmFor().getCdFor() !=null) && (!filtro.getOmFor().getCdFor().equals(""))) {
					q.append("AND t.omFor.cdFor = :cdFor");
				}
				if ((filtro.getOmFor().getNmFornecedor() != null) && (!filtro.getOmFor().getNmFornecedor().equals(""))) {
					q.append("AND t.omFor.nmFornecedor = :nmFornecedor");
				}
			}
			if (filtro.getOmUsrByIdUsrrevisao() != null){
				if ((filtro.getOmUsrByIdUsrrevisao().getCdUsr() != null) &&	(!filtro.getOmUsrByIdUsrrevisao().getCdUsr().equals(""))) {
					q.append("AND t.omUsrByIdUsrrevisao.cdUsr = :cdUsrRev");
				}
				if ((!filtro.getOmUsrByIdUsrrevisao().getDsNome().equals("")) && (filtro.getOmUsrByIdUsrrevisao().getDsNome() != null)) {
					q.append("AND t.omUsrByIdUsrrevisao.dsNome = :dsNomeRev");
				}
			}
			if (filtro.getOmUsrByIdUsrstativo() != null){
				if ((filtro.getOmUsrByIdUsrstativo().getCdUsr() != null) && (!filtro.getOmUsrByIdUsrstativo().getCdUsr().equals(""))) {
					q.append("AND t.omUsrByIdUsrstativo.cdUsr = :cdUsrSt");
				}
				if ((filtro.getOmUsrByIdUsrstativo().getDsNome() != null) && (!filtro.getOmUsrByIdUsrstativo().getDsNome().equals(""))) {
					q.append("AND t.omUsrByIdUsrstativo.dsNome = :dsNomeSt");
				}				
			}
			if (filtro.getDtStativo() != null) {
				q.append("AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF");
			}
			if ((filtro.getStAtivo() != null) && (filtro.getStAtivo() < (byte) 2)) {
				q.append("AND t.stAtivo = :stAtivo");
			}
			if ((filtro.getTpProduto() != null) && (filtro.getTpProduto() < (byte) 5)) {
				q.append("AND t.tpProduto = :tpProduto");
			}
			if ((filtro.getTpProducao() != null) && (filtro.getTpProducao().intValue() < 4)) {
				q.append("AND t.tpProducao = :tpProducao");
			}
			if ((filtro.getTpOrigem() != null) && (filtro.getTpOrigem().intValue() > 0)) {
				q.append("AND t.tpOrigem = :tpOrigem");
			}
			
			if (filtro.getCdSap() != null && filtro.getCdSap().trim().equals("") == false) {
				q.append("AND t.cdSap = :cdsap");
			}
		}

		if(filtro.getIdProduto() > 0){
			q.defineParametro("idProduto", filtro.getIdProduto());
		}
		if(filtro.getCdProduto() != null && !filtro.getCdProduto().equals("")){
			q.defineParametro("cdProduto", filtro.getCdProduto());
		}
		if(filtro.getDsProduto() != null && !filtro.getDsProduto().equals("")){
			q.defineParametro("dsProduto", filtro.getDsProduto());
		}
		if(filtro.getDsComplemento() != null && !filtro.getDsComplemento().equals("")){
			q.defineParametro("dsComplemento", filtro.getDsComplemento());
		}
		if(filtro.getDepara() != null && !filtro.getDepara().equals("")){
			q.defineParametro("depara", filtro.getDepara());
		}
		if(filtro.getMinValposalim() != null){
			q.defineParametro("minValposalim", filtro.getMinValposalim());
		}
		if(filtro.getVlCustounit() != null){
			q.defineParametro("vlCustounit", filtro.getVlCustounit());
		}
		if(filtro.getOmUnidmedida() != null){
			q.defineParametro("cdUnidmedida", filtro.getOmUnidmedida().getCdUnidmedida());
			q.defineParametro("dsUnidmedida", filtro.getOmUnidmedida().getDsUnidmedida());
		}
		if(filtro.getOmProgrp() != null){
			q.defineParametro("cdProgrp", filtro.getOmProgrp().getCdProgrp());
			q.defineParametro("dsProgrp", filtro.getOmProgrp().getDsProgrp());
		}
		if(filtro.getOmCc() != null){
			q.defineParametro("cdCc", filtro.getOmCc().getCdCc());
			q.defineParametro("dsCc", filtro.getOmCc().getDsCc());
		}
		if(filtro.getOmFor() != null){
			q.defineParametro("cdFornecedor", filtro.getOmFor().getCdFor());
			q.defineParametro("nmFornecedor", filtro.getOmFor().getNmFornecedor());
		}
		if(filtro.getOmUsrByIdUsrrevisao() != null){
			q.defineParametro("cdUsrRev", filtro.getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getOmUsrByIdUsrrevisao().getDsNome());
		}
		if(filtro.getOmUsrByIdUsrstativo() != null){
			q.defineParametro("cdUsrSt", filtro.getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getOmUsrByIdUsrstativo().getDsNome());
		}
	
		q.defineParametro("stAtivo", filtro.getStAtivo());
		q.defineParametro("tpProduto", filtro.getTpProduto());
		q.defineParametro("tpProducao", filtro.getTpProducao());
		q.defineParametro("tpOrigem", filtro.getTpOrigem());
		q.defineParametro("cdsap", filtro.getCdSap());
		
		try {
			if(filtro.getDtRevisao() != null){
				q.defineParametroTimestamp("dtRevisao", filtro.getDtRevisao());
				q.defineParametroTimestamp("dtRevisaoF", DataHoraRN.getDataHora235959(filtro.getDtRevisao()));
			}
		} catch (Exception e) {}
		try {
			if (filtro.getDtStativo() != null){
				q.defineParametroTimestamp("dtStativo", filtro.getDtStativo());
				q.defineParametroTimestamp("dtStativoF", DataHoraRN.getDataHora235959(filtro.getDtStativo()));
			}
		} catch (Exception e) {}
		
		q.setMaxResults(50);
		
		return q.list();
	}

	public List<OmProduto> getOmProdutos(String codigo, String descricao, Byte tpProduto){
		MapQuery q = new MapQuery(session);
		q.append("SELECT distinct t ");
		q.append("FROM OmProduto t ");
		q.append("WHERE t.stAtivo = :stAtivo ");
		if (!codigo.equals("") && !descricao.equals("")) {
			q.append("AND ( t.cdProduto = :cdProduto OR t.dsProduto = :dsProduto)");
		} else if (!codigo.equals("")) {
			q.append("AND t.cdProduto = :cdProduto");
		} else if (!descricao.equals("")) {
			q.append("AND t.dsProduto = :dsProduto");
		}
		if(tpProduto != null){
			q.append("AND t.tpProduto = :tpProduto");
		}
		q.append("ORDER BY t.cdProduto");
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdProduto", codigo);
		q.defineParametro("dsProduto", descricao);
		q.defineParametro("tpProduto", tpProduto);
		q.setMaxResults(50);
		return q.list();
	}
	
	public Map<String, Set<DwEstpro>> getEstoquesProdutos(Collection<OmProduto> listProdutos, DwEst dwEst){
		MapQuery q = new MapQuery(session);
		q.append("SELECT omProduto FROM OmProduto omProduto");
		q.append("INNER JOIN FETCH omProduto.dwEstpros dwEstpro");
		q.append("INNER JOIN FETCH dwEstpro.dwEst dwEst");
		q.append("WHERE omProduto IN :omProdutos");
		if(dwEst != null){
			q.append("AND dwEst = :dwEst");
		}
		List<Object> listObjects = new ArrayList<Object>();
		listObjects.addAll(listProdutos);
		q.defineListaParametro("omProdutos", listObjects);
		Map<String, Set<DwEstpro>> mapProdutoEstoques = new HashMap<String, Set<DwEstpro>>();
		for(OmProduto omProduto: listProdutos){
			mapProdutoEstoques.put(omProduto.getCdProduto(), omProduto.getDwEstpros());
		}
		return mapProdutoEstoques;
	}
	
	public OmProduto getOmProdutoPorId(long idProduto){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmProduto produto");
		q.append("WHERE produto.idProduto = :idProduto");
		q.defineParametro("idProduto", idProduto);
		return (OmProduto) q.uniqueResult();
	}
	
	public OmProduto getOmProdutoPorCdAtivoOrderByIdDesc(String cdProduto){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmProduto t ");
		q.append("WHERE t.stAtivo = :stAtivo");
		q.append("AND t.cdProduto = :cdProduto");
		q.append("ORDER BY t.idProduto DESC");
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdProduto", cdProduto);
		q.setMaxResults(1);
		return (OmProduto) q.uniqueResult();
	}
	
	public List<OmProduto> getOmProdutosAtivos(){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmProduto t");
		q.append("WHERE t.stAtivo = :stAtivo");
		q.append("and (t.tpProduto = :tpFinal or t.tpProduto = :tpSemiAcabado)");
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("tpFinal", OmProdutoTemplate.TpProduto.PRODUTO_FINAL.getId());
		q.defineParametro("tpSemiAcabado", OmProdutoTemplate.TpProduto.SEMI_ACABADO.getId());
		return q.list();
	}
		
	public List<OmProduto> getProdutosSemConsumo(){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmProduto t");
		q.append("WHERE t.stAtivo = :stAtivo");
		q.append("AND t.isConsumido = :isConsumido");
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("isConsumido", false);
		return q.list();
	}
	
	public OmProduto getOmProdutoPorCdComMaiorRevisao(String cdProduto, long revisao){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmProduto omproduto");
		q.append("WHERE omproduto.cdProduto = :cdproduto");
		q.append("AND omproduto.revisao > :revisao");
		q.defineParametro("cdproduto", cdProduto);
		q.defineParametro("revisao", revisao);
		q.setMaxResults(1);
		return (OmProduto) q.uniqueResult();
	}
	
	public List<OmProduto> getOmProdutoFinalAtivoPorCdDsOuPedido(String cdProduto, String dsProduto, Long idPedido){
		MapQuery q = new MapQuery(session);
		q.append("SELECT produto");
		q.append("FROM PpNec pedido");
		q.append("JOIN pedido.omProduto produto");
		q.append("WHERE pedido.stAtivo = :pedidoAtivo");
		q.append("AND produto.stAtivo = :produtoAtivo");
		if(cdProduto != null && !cdProduto.equals("") && dsProduto != null && !dsProduto.equals("")) {
			q.append("AND (produto.cdProduto = :cdProduto OR produto.dsProduto = :dsProduto)");
		} else if(cdProduto != null && !cdProduto.equals("")) {
			q.append("AND produto.cdProduto = :cdProduto");
		} else if(dsProduto != null && !dsProduto.equals("")) {
			q.append("AND produto.dsProduto = :dsProduto");
		}
		if(idPedido != null && idPedido != 0) {
			q.append("AND pedido.idNec = :idPedido");
		}
		q.defineParametro("pedidoAtivo", 1);
		q.defineParametro("produtoAtivo", (byte) 1);
		q.defineParametro("cdProduto", cdProduto);
		q.defineParametro("dsProduto", dsProduto);
		q.defineParametro("idPedido", idPedido);
		return q.list();
	}
	
	public List<OmProduto> getOmProdutoFinalAtivoApartirDaRota(String cdProduto, String dsProduto) {
		MapQuery q = new MapQuery(session);		
		q.append("SELECT DISTINCT produto");
		q.append("FROM DwRota rota");
		q.append("JOIN rota.omProduto produto");
		q.append("WHERE rota.stAtivo = :stAtivo");
		q.append("AND produto.stAtivo = :stAtivo");
		q.append("AND produto.tpProduto = :tpProduto");
		if(cdProduto != null && !cdProduto.equals("") && dsProduto != null && !dsProduto.equals("")){
			q.append("AND (produto.cdProduto = :cdProduto OR produto.dsProduto = :dsProduto)");
		} else if(cdProduto != null && !cdProduto.equals("")) {
			q.append("AND produto.cdProduto = :cdProduto");
		} else if(dsProduto != null && !dsProduto.equals("")) {
			q.append("AND produto.dsProduto = :dsProduto");
		}
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("tpProduto", TpProduto.PRODUTO_FINAL.getId());
		q.defineParametro("cdProduto", cdProduto);
		q.defineParametro("dsProduto", dsProduto);		
		return q.list();
	}
	
	public List<OmProduto> getOmprodutosFinaisESemiAcabados(String cdProduto, String dsProduto) {
		MapQuery q = new MapQuery(session);
		q.append("FROM OmProduto produto");
		q.append("WHERE produto.stAtivo = :stAtivo");
		if(cdProduto != null && !cdProduto.equals("") && dsProduto != null && !dsProduto.equals("")){
			q.append("AND (produto.cdProduto = :cdProduto OR produto.dsProduto = :dsProduto)");
		} else if(cdProduto != null && !cdProduto.equals("")) {
			q.append("AND produto.cdProduto = :cdProduto");
		} else if(dsProduto != null && !dsProduto.equals("")) {
			q.append("AND produto.dsProduto = :dsProduto");
		}
		q.append("AND (produto.tpProduto = :tpFinal");
		q.append("OR produto.tpProduto = :tpSemiAcabado)");
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("cdProduto", cdProduto);
		q.defineParametro("dsProduto", dsProduto);
		q.defineParametro("tpFinal", OmProdutoTemplate.TpProduto.PRODUTO_FINAL.getId());
		q.defineParametro("tpSemiAcabado", OmProdutoTemplate.TpProduto.SEMI_ACABADO.getId());
		return q.list();
	}
	
	public List<OmProduto> getListaProduto(String cdProduto) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT omProduto FROM OmProduto omProduto");
		q.append("WHERE omProduto.stAtivo = :stAtivo");
		if (cdProduto != null && !cdProduto.equals("")) {
			q.append("AND omProduto.cdProduto = :cdProduto");
		}
		q.append("AND (omProduto.idProduto IN ( SELECT pp_cpproduto.omProduto.idProduto FROM PpCpproduto pp_cpproduto");
		q.append("WHERE (pp_cpproduto.ppCp.idCp IN ( SELECT dw_consolid.ppCp.idCp FROM DwConsolid dw_consolid");
		q.append("WHERE (dw_consolid.ppCp.idCp IN ( SELECT pp_cp.idCp FROM PpCp pp_cp");
		q.append("WHERE (pp_cp.omPt.idPt IN ( SELECT om_pt.idPt FROM OmPt om_pt");
		q.append("WHERE om_pt.omGt.idGt NOT IN (999)))))))))");
		q.append("ORDER BY omProduto.dsProduto");
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("cdProduto", cdProduto);
		return q.list();
	}

	public List<OmProduto> getListaProdutoGts(String listaIdGt) {
		MapQuery q = new MapQuery(session);
		q.novaConsulta();
		
		String[] array = listaIdGt.split(",");// trata a string com separadores para gerar array e list
		List<Long> listLongs = new ArrayList<Long>();
		for ( String s : array ) {
		    try {
		    	listLongs.add( Long.valueOf( s.trim() ) );
		    } catch ( NumberFormatException exc ) {}
		}
		
		q.append("select p from OmProduto p ");
		q.append("where ");
		q.append("p.stAtivo = 1 AND ");
		q.append("p.idProduto IN  ");
		q.append("(select cpp.omProduto.idProduto from PpCpproduto cpp where cpp.ppCp.idCp IN ");
		q.append("(select dw.ppCp.idCp from DwConsolid dw where dw.ppCp.idCp IN ");
		q.append("(select cp.idCp from PpCp cp where cp.omPt.idPt IN  ");
		q.append("(select pt.idPt from OmPt pt where pt.omGt.idGt  ");
		if (listLongs != null && listLongs.size()>0 && listLongs.get(0)!=null) {
			q.append(" IN (:listaIdGt))))) ");
			q.query().setParameterList("listaIdGt",listLongs);
		} else
		{
			q.append("NOT IN (999))))) ");
		}
		return q.list();
	}
	
	public List<OmProduto> getListaProdutoGtsCdProduto(String listaIdGt, String cdProduto) {
		MapQuery q = new MapQuery(session);
		q.novaConsulta();
		
		String[] array = listaIdGt.split(",");// trata a string com separadores para gerar array e list
		List<Long> listLongs = new ArrayList<Long>();
		for ( String s : array ) {
		    try {
		    	listLongs.add( Long.valueOf( s.trim() ) );
		    } catch ( NumberFormatException exc ) {}
		}
		
		q.append("select p from OmProduto p ");
		q.append("where ");
		q.append("p.stAtivo = 1  ");
		if (cdProduto != null && !cdProduto.equals("")) {
			q.append("AND p.cdProduto = :cdProduto ");
		}
		q.append("AND p.idProduto IN  ");
		q.append("(select cpp.omProduto.idProduto from PpCpproduto cpp where cpp.ppCp.idCp IN ");
		q.append("(select dw.ppCp.idCp from DwConsolid dw where dw.ppCp.idCp IN ");
		q.append("(select cp.idCp from PpCp cp where cp.omPt.idPt IN  ");
		q.append("(select pt.idPt from OmPt pt where pt.omGt.idGt  ");
		if (listLongs != null && listLongs.size()>0 && listLongs.get(0)!=null) {
			q.append(" IN (:listaIdGt))))) ");
			q.query().setParameterList("listaIdGt",listLongs);
		} else
		{
			q.append("NOT IN (999))))) ");
		}
		if (cdProduto != null && !cdProduto.equals("")) {
			q.defineParametro("cdProduto", cdProduto);			
		}
		
		return q.list();
	}


}