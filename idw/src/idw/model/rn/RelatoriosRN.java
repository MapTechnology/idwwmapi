package idw.model.rn;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.OmAlimreaDAO;
import idw.model.pojos.OmAlimrea;
import idw.model.pojos.OmProduto;
import idw.model.pojos.template.OmAlimTemplate.TpAlim;
import idw.model.pojos.template.OmAlimreaTemplate.StLeitura;
import idw.model.pojos.template.OmAlimreaTemplate.TpLeitura;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.dto.ProdutosDTO;
import idw.webservices.dto.RelAbastecimentoComponentesAlimreaDTO;
import idw.webservices.dto.RelAbastecimentoComponentesDTO;


@SuppressWarnings("unchecked")	
public class RelatoriosRN extends DAOGenerico{	

	private static final String TXT_MARCADO = "X";

	public RelAbastecimentoComponentesDTO getRelAbastecimentoComponentes(Integer idAlimentacao){		
		RelAbastecimentoComponentesDTO rel = new RelAbastecimentoComponentesDTO();		

		OmAlimreaDAO omAlimreaDAO = new OmAlimreaDAO(getSession());
		
		List<OmAlimrea> lista = omAlimreaDAO.getOmAlimreaPorIdAlim(new Long(idAlimentacao));
		
//		String hql="";
//		hql += "select t ";
//		hql += "from OmAlimrea t ";
//		hql += "where t.omAlim.idAlim=::idAlimentacao ";
//
//		hql = hql.replaceAll("::idAlimentacao", String.valueOf(idAlimentacao));
//
//		Query q = getSession().createQuery(hql);
//
//		List<OmAlimrea> lista = null;
//		try{
//			lista = q.list();
//		} catch (Exception e){
//			e.printStackTrace();
//		}

		SimpleDateFormat formatterP = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		rel.setDataProcessamento(formatterP.format(new Date()));
		rel.setVersao("");

		if (lista != null && lista.size()>0){	
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			rel.setDataOperacao(formatter.format(lista.get(0).getOmAlim().getDtStativo()));
			rel.setMaquina(lista.get(0).getOmAlim().getOmMapa().getOmPt().getDsPt());
			
			String mapa = lista.get(0).getOmAlim().getOmMapa().getDsMapa();
			if(mapa == null) {
				mapa = lista.get(0).getOmAlim().getOmMapa().getCdMapa();
			}
			rel.setMapa(mapa);
		}

		List<RelAbastecimentoComponentesAlimreaDTO> listaDTO = new ArrayList<RelAbastecimentoComponentesAlimreaDTO>();

		if (lista != null) {
			for (OmAlimrea item : lista) {
				RelAbastecimentoComponentesAlimreaDTO itemDTO = new RelAbastecimentoComponentesAlimreaDTO();

				itemDTO.setComponente(item.getOmMapapa().getOmProduto().getCdProduto());
				itemDTO.setDsComponente(item.getOmMapapa().getOmProduto().getDsProduto());
				itemDTO.setPosicaoZ(item.getOmMapapa().getOmPa().getCdPa());
				itemDTO.setMatriculaOperador(item.getOmUsr().getCdUsr());
				itemDTO.setOperador(item.getOmUsr().getDsNome());

				SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
				itemDTO.setHora(formatter.format(item.getDthrLeitura()));
				itemDTO.setQuantidade(item.getQtAlimentada()+"");
				itemDTO.setAlimOK(StringUtils.EMPTY);
				itemDTO.setAlimNOK(StringUtils.EMPTY);
				itemDTO.setRealimOK(StringUtils.EMPTY);
				itemDTO.setRealimNOK(StringUtils.EMPTY);
				itemDTO.setConferOK(StringUtils.EMPTY);
				itemDTO.setConferNOK(StringUtils.EMPTY);
				
				boolean isSucesso = StLeitura.SUCESSO.equals(item.getStLeitura());
				
				//if ( item.getOmAlim().getTpAlim())
				if (TpAlim.CONFERENCIA.equals(item.getOmAlim().getTpAlim())
						|| TpAlim.PRE_CONFERENCIA.equals(item.getOmAlim().getTpAlim())) {
					if (isSucesso){
						itemDTO.setConferOK(TXT_MARCADO);
					}else{
						itemDTO.setConferNOK(TXT_MARCADO);
					}					
				} else {
					
					if (TpLeitura.CONFERENCIA_OU_ALIMENTACAO.equals(item.getTpLeitura())){
						//ok
						if (isSucesso){
							itemDTO.setAlimOK(TXT_MARCADO);
						}else{
							itemDTO.setAlimNOK(TXT_MARCADO);
						}
					}else{
						//ok
						if (isSucesso){
							itemDTO.setRealimOK(TXT_MARCADO);
						}else{
							itemDTO.setRealimNOK(TXT_MARCADO);
						}
					}			
				}
				
				listaDTO.add(itemDTO);
			}
		}
		rel.setAlimRea(listaDTO);
		return rel;

	}

	public ProdutosDTO getRelProdutosSemDePara(){

		String hql="";
		hql += "select t ";
		hql += "from OmProduto t ";		
		hql += "where (SELECT count(tr.idProalt) as qtd from OmProaltglo tr where tr.omProdutoByIdProdutoMae.idProduto = t.idProduto ) = 0 ";
		hql += "AND (SELECT count(tr.idProalt) as qtd from OmProaltglo tr where tr.omProdutoByIdProdutoFilho.idProduto = t.idProduto ) = 0 ";
		hql += "AND t.revisao = (SELECT max(tr.revisao) as Revisao from OmProduto tr where tr.cdProduto = t.cdProduto ) ";

		Query q = getSession().createQuery(hql);

		List<OmProduto> listaOmproduto = null;
		try{
			listaOmproduto = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<ProdutoDTO> lista = new ArrayList<ProdutoDTO>();

		if (listaOmproduto != null) {
			for (OmProduto omProduto : listaOmproduto) {
				ProdutoDTO produto = new ProdutoDTO();								
				produto.setProduto((OmProduto)omProduto.clone());			
				produto.setResultadoEvento(0);
				lista.add(produto);
			}
		}
		ProdutosDTO produtos = new ProdutosDTO();
		produtos.setProdutos(lista);
		return produtos;
	}

}