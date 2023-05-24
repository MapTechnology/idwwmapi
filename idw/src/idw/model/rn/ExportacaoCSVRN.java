package idw.model.rn;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwExpcvs;
import idw.model.pojos.DwExpcvspf;
import idw.model.pojos.DwFtEtapa;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.DwTDefeito;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.rn.exp.ExportacaoFactory;
import idw.model.rn.exp.WorkExportacaoCSVRN;
import idw.webservices.dto.ExportacaoDTO;
import idw.webservices.dto.FiltroExportacaoDTO;
import idw.webservices.dto.FiltroRelDTO;
import idw.webservices.dto.FiltrosExportacaoDTO;
import idw.webservices.dto.RelIndTesteFinalDTO;


@SuppressWarnings("unchecked")
public class ExportacaoCSVRN extends AbstractRN<DAOGenerico>	{

	public ExportacaoCSVRN() {
		super(new DAOGenerico());
	}
	public ExportacaoCSVRN(DAOGenerico dao) {
		super(dao);
	}

	public FiltrosExportacaoDTO getFiltrosDTO(FiltroExportacaoDTO filtro){

		String hql="";
		hql += "select t ";
		hql += "from DwExpcvs t ";		
		hql += "where 1=1 ";

		if (filtro.getFiltro().getIdExpcvs()!=0){
			hql += "AND t.idExpcvs=::idExpcvs: ";
		}else{
			if (filtro.getFiltro().getCdExpcvs() != null && !filtro.getFiltro().getCdExpcvs().equals("")){
				hql += "AND t.cdExpcvs='::cdExpcvs:' ";
			}
			if (filtro.getFiltro().getDsExpcvs() != null && !filtro.getFiltro().getDsExpcvs().equals("")){
				hql += "AND t.dsExpcvs='::dsExpcvs:' ";
			}			
		}

		hql = hql.replaceAll("::idExpcvs:", String.valueOf(filtro.getFiltro().getIdExpcvs()));		
		hql = hql.replaceAll("::cdExpcvs:", filtro.getFiltro().getCdExpcvs());
		hql = hql.replaceAll("::dsExpcvs:", filtro.getFiltro().getDsExpcvs());

		Query q = getDaoSession().createQuery(hql);

		List<DwExpcvs> listaPesquisa = null;
		try{
			listaPesquisa = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<FiltroExportacaoDTO> lista = new ArrayList<FiltroExportacaoDTO>();

		if (listaPesquisa != null){
			for (DwExpcvs item : listaPesquisa) {
				FiltroExportacaoDTO itemDTO = new FiltroExportacaoDTO();								
				itemDTO.setFiltro((DwExpcvs)item.clone());

				StringBuilder retorno = new StringBuilder();	

				retorno.append("<select name='plataformasSel' id='plataformasSel' multiple='multiple' size='2' style='width: 250px;'>");

							
				
				//DwExpcvspf			
				itemDTO.getFiltro().setDwExpcvspfs(new HashSet<DwExpcvspf>());
				for (DwExpcvspf itemList : item.getDwExpcvspfs()) {
					DwExpcvspf subItem = (DwExpcvspf)itemList.clone();								
					itemDTO.getFiltro().getDwExpcvspfs().add(subItem);

					
					retorno.append("<option value='");
					retorno.append(subItem.getOmProgrp().getCdProgrp());
					retorno.append("'>");
					retorno.append(subItem.getOmProgrp().getCdProgrp());
					retorno.append(" - ");
					retorno.append(subItem.getOmProgrp().getDsProgrp());
					retorno.append("</option>");
				}				

				retorno.append("</select>");

				itemDTO.setPlataformasSelecionadas(retorno.toString());
				itemDTO.setResultadoEvento(0);
				lista.add(itemDTO);
			}
		}

		FiltrosExportacaoDTO dtoRetorno = new FiltrosExportacaoDTO();
		dtoRetorno.setFiltros(lista);
		return dtoRetorno;
	}

	public FiltroExportacaoDTO setFiltroExportacaoDTO(FiltroExportacaoDTO itemDTO){
		FiltroExportacaoDTO dtoRetorno = new FiltroExportacaoDTO();
		dtoRetorno.setResultadoEvento(dtoRetorno.getEVENTO_BEM_SUCEDIDO());

		String hql = "";

		hql = "from DwExpcvs t where t.cdExpcvs = '::cdExpcvs' ";
		hql = hql.replaceAll("::cdExpcvs", String.valueOf(itemDTO.getFiltro().getCdExpcvs()));

		Query q = getDaoSession().createQuery(hql);

		DwExpcvs itemOriginal = (DwExpcvs) q.uniqueResult();

		if (itemOriginal == null){			
			itemOriginal = (DwExpcvs)itemDTO.getFiltro().clone();


		}else{
			itemOriginal.copy(itemDTO.getFiltro(), false);		
			if (itemOriginal.getDwExpcvspfs() != null){
				for (Iterator<DwExpcvspf> iterator = itemOriginal.getDwExpcvspfs().iterator(); iterator.hasNext();) {
					DwExpcvspf subItem = iterator.next();
					getDaoSession().delete(subItem);
					iterator.remove();				
				}	
			}
		}	

		//DwExpcvspf
		if (itemDTO.getFiltro().getDwExpcvspfs() != null){
			itemOriginal.setDwExpcvspfs(new HashSet<DwExpcvspf>());
			for (DwExpcvspf itemList : itemDTO.getFiltro().getDwExpcvspfs()) {
				//todas as plataformas
				if (itemList.getIdExpcfvpf() == 1l){
					hql = "from OmProgrp t where t.stAtivo = 1 ";
					hql += "order by t.idProgrp ";

					q = getDaoSession().createQuery(hql);

					List<OmProgrp> lista = q.list();

					for (OmProgrp omProgrp : lista){
						DwExpcvspf item = new DwExpcvspf();
						item.setDwExpcvs(itemOriginal);
						item.setOmProgrp(omProgrp);

						itemOriginal.getDwExpcvspfs().add(item);
					}
					break;
				}else{
					itemList.setDwExpcvs(itemOriginal);			

					//Verifica se existe			
					try {
						hql = "from OmProgrp t where t.cdProgrp = '::cdProgrp' ";
						hql += "and t.stAtivo = 1 ";
						hql += "order by t.idProgrp ";

						hql = hql.replaceAll("::cdProgrp", String.valueOf(itemList.getOmProgrp().getCdProgrp()));

						q = getDaoSession().createQuery(hql);

						OmProgrp item = (OmProgrp) q.list().get(0);

						itemList.setOmProgrp(item);

						itemOriginal.getDwExpcvspfs().add(itemList);

					} catch (Exception e) {
						//return retorno.getERRO_COMPONENTE_DESCONHECIDO();
					}						

				}
			}	

		}

		if (itemDTO.getFiltro().getDwFtEtapa() != null && !itemDTO.getFiltro().getDwFtEtapa().getCdEtapa().equals("")){
			try {
				hql = "from DwFtEtapa t where t.cdEtapa = '::cdEtapa' ";
				hql += "and t.stAtivo = 1 ";
				hql += "order by t.idFtEtapa ";

				hql = hql.replaceAll("::cdEtapa", itemDTO.getFiltro().getDwFtEtapa().getCdEtapa());

				q = getDaoSession().createQuery(hql);

				DwFtEtapa item = (DwFtEtapa) q.list().get(0);

				itemOriginal.setDwFtEtapa(item);
			} catch (Exception e) {			
			}
		} else {
			itemOriginal.setDwFtEtapa(null);
		}
		if (itemDTO.getFiltro().getDwTAcao() != null && !itemDTO.getFiltro().getDwTAcao().getCdTacao().equals("")){
			try {
				hql = "from DwTAcao t where t.cdTacao = '::cdTacao' ";
				hql += "and t.stAtivo = 1 ";
				hql += "order by t.idTacao ";

				hql = hql.replaceAll("::cdTacao", itemDTO.getFiltro().getDwTAcao().getCdTacao());

				q = getDaoSession().createQuery(hql);

				DwTAcao item = (DwTAcao) q.list().get(0);

				itemOriginal.setDwTAcao(item);
			} catch (Exception e) {			
			}
		} else {
			itemOriginal.setDwTAcao(null);
		}
		if (itemDTO.getFiltro().getDwTDefeitoByIdTdefeito() != null && !itemDTO.getFiltro().getDwTDefeitoByIdTdefeito().getCdTdefeito().equals("")){
			try {
				hql = "from DwTDefeito t where t.cdTdefeito = '::cdTdefeito' ";
				hql += "and t.stAtivo = 1 ";
				hql += "order by t.idTdefeito ";

				hql = hql.replaceAll("::cdTdefeito", itemDTO.getFiltro().getDwTDefeitoByIdTdefeito().getCdTdefeito());

				q = getDaoSession().createQuery(hql);

				DwTDefeito item = (DwTDefeito) q.list().get(0);

				itemOriginal.setDwTDefeitoByIdTdefeito(item);
			} catch (Exception e) {			
			}
		} else {
			itemOriginal.setDwTDefeitoByIdTdefeito(null);
		}
		if (itemDTO.getFiltro().getDwTDefeitoByIdTdefeitoreprocesso() != null && !itemDTO.getFiltro().getDwTDefeitoByIdTdefeitoreprocesso().getCdTdefeito().equals("")){
			try {
				hql = "from DwTDefeito t where t.cdTdefeito = '::cdTdefeito' ";
				hql += "and t.stAtivo = 1 ";
				hql += "order by t.idTdefeito ";

				hql = hql.replaceAll("::cdTdefeito", itemDTO.getFiltro().getDwTDefeitoByIdTdefeitoreprocesso().getCdTdefeito());

				q = getDaoSession().createQuery(hql);

				DwTDefeito item = (DwTDefeito) q.list().get(0);

				itemOriginal.setDwTDefeitoByIdTdefeitoreprocesso(item);
			} catch (Exception e) {			
			}
		} else {
			itemOriginal.setDwTDefeitoByIdTdefeitoreprocesso(null);
		}
		if (itemDTO.getFiltro().getOmProduto() != null && !itemDTO.getFiltro().getOmProduto().getCdProduto().equals("")){
			try {
				hql = "from OmProduto t where t.cdProduto= '::cdProduto' ";
				hql += "and t.stAtivo = 1 ";
				hql += "order by t.idProduto ";

				hql = hql.replaceAll("::cdProduto", itemDTO.getFiltro().getOmProduto().getCdProduto());

				q = getDaoSession().createQuery(hql);

				OmProduto item = (OmProduto) q.list().get(0);

				itemOriginal.setOmProduto(item);
			} catch (Exception e) {			
			}
		} else {
			itemOriginal.setOmProduto(null);
		}
		if (itemDTO.getFiltro().getOmPt() != null && !itemDTO.getFiltro().getOmPt().getCdPt().equals("")){
			try {
				hql = "from OmPt t where t.cdPt= '::cdPt' ";
				hql += "and t.stAtivo = 1 ";
				hql += "order by t.idPt ";

				hql = hql.replaceAll("::cdPt", itemDTO.getFiltro().getOmPt().getCdPt());

				q = getDaoSession().createQuery(hql);

				OmPt item = (OmPt) q.list().get(0);

				itemOriginal.setOmPt(item);
			} catch (Exception e) {			
			}
		} else {
			itemOriginal.setOmPt(null);
		}
		if (itemDTO.getFiltro().getOmUsrByIdUsroperador() != null && !itemDTO.getFiltro().getOmUsrByIdUsroperador().getCdUsr().equals("")){
			try {
				hql = "from OmUsr t where t.cdUsr= '::cdUsr' ";
				hql += "and t.stAtivo = 1 ";
				hql += "order by t.idUsr ";

				hql = hql.replaceAll("::cdUsr", itemDTO.getFiltro().getOmUsrByIdUsroperador().getCdUsr());

				q = getDaoSession().createQuery(hql);

				OmUsr item = (OmUsr) q.list().get(0);

				itemOriginal.setOmUsrByIdUsroperador(item);
			} catch (Exception e) {			
			}
		} else {
			itemOriginal.setOmUsrByIdUsroperador(null);
		}
		if (itemDTO.getFiltro().getOmUsrByIdUsrsupervisor() != null && !itemDTO.getFiltro().getOmUsrByIdUsrsupervisor().getCdUsr().equals("")){
			try {
				hql = "from OmUsr t where t.cdUsr= '::cdUsr' ";
				hql += "and t.stAtivo = 1 ";
				hql += "order by t.idUsr ";

				hql = hql.replaceAll("::cdUsr", itemDTO.getFiltro().getOmUsrByIdUsrsupervisor().getCdUsr());

				q = getDaoSession().createQuery(hql);

				OmUsr item = (OmUsr) q.list().get(0);

				itemOriginal.setOmUsrByIdUsrsupervisor(item);
			} catch (Exception e) {			
			}
		} else {
			itemOriginal.setOmUsrByIdUsrsupervisor(null);
		}

		if (dtoRetorno.getResultadoEvento() == dtoRetorno.getEVENTO_BEM_SUCEDIDO()){
			try{
				itemOriginal = getDao().makePersistent(itemOriginal);				
			} catch (Exception e){
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
				e.printStackTrace();
			}

			dtoRetorno.setFiltro((DwExpcvs)itemOriginal.clone());

			//DwExpcvspf			
			dtoRetorno.getFiltro().setDwExpcvspfs(new HashSet<DwExpcvspf>());
			for (DwExpcvspf itemList : itemOriginal.getDwExpcvspfs()) {
				DwExpcvspf subItem = (DwExpcvspf)itemList.clone();								
				dtoRetorno.getFiltro().getDwExpcvspfs().add(subItem);
			}	

		}

		return dtoRetorno;
	}

	public FiltroExportacaoDTO validarFiltro(FiltroExportacaoDTO filtro){
		FiltroExportacaoDTO retorno = new FiltroExportacaoDTO();
		retorno.setResultadoEvento(retorno.getEVENTO_BEM_SUCEDIDO());

		if (filtro.getFiltro().getCdExpcvs() == null || filtro.getFiltro().getCdExpcvs().trim().equals("")){
			retorno.setResultadoEvento(retorno.getERRO_CDEXPCVS_INVALIDO());
			return retorno;
		}

		if (filtro.getFiltro().getDsExpcvs() == null || filtro.getFiltro().getDsExpcvs().trim().equals("")){
			retorno.setResultadoEvento(retorno.getERRO_DSEXPCVS_INVALIDO());
			return retorno;
		}

		// Verifica se o codigo + revisao ja existe no banco, se exitir retornar ao cliente a excessao
		String hql = "";

		hql += "from DwExpcvs t ";
		hql += "where t.cdExpcvs = '::cdExpcvs' ";			

		hql = hql.replaceAll("::cdExpcvs", filtro.getFiltro().getCdExpcvs());			
		Query q = getDaoSession().createQuery(hql);

		if (q.list().size() > 0){
			retorno.setResultadoEvento(retorno.getERRO_FILTRO_JA_EXISTE());
			return retorno;
		}

		return retorno;
	}

	public ExportacaoDTO exportaCVS(FiltroExportacaoDTO filtro) {
		ExportacaoFactory exp = null;
		
		exp = ExportacaoFactory.instance(ExportacaoFactory._factory[filtro.getFiltro().getTpExportacao().intValue() - 1]);
		
		exp.setSession(getDaoSession());
		exp.setFiltro(filtro);
		return exp.exportaCVS();
	}

	/*
	 * Relatorio com os graficos para o teste final
	 */
	public RelIndTesteFinalDTO getRelIndTesteFinal(FiltroRelDTO filtro) {
		RelIndTesteFinalDTO retorno = new RelIndTesteFinalDTO();		

		if (filtro == null || filtro.getAgrupamento() == null)
			return retorno;

		//seleciona todas as passagens que atendem ao filtro especificado 
		StringBuilder sql= new StringBuilder();
		sql.append("select dwpassagem.*, dwnserie.*, omproduto.*, omprogrp.*, dwpasscau.*, dwtdefeito.*, ");
		sql.append(" omproduto2.cd_produto cd_produto_dwpasscau, omproduto2.ds_produto ds_produto_dwpasscau ");
		sql.append("from Dw_Passagem dwpassagem ");
		sql.append(" left join Dw_NSerie dwnserie ON dwnserie.id_nserie = dwpassagem.id_nserie ");
		sql.append(" left join Om_produto omproduto ON omproduto.id_produto = dwnserie.id_produto ");
		sql.append(" left join Om_progrp omprogrp ON omprogrp.id_progrp = omproduto.id_progrp ");
		sql.append(" left join Dw_passcau dwpasscau ON dwpasscau.id_passagem = dwpassagem.id_passagem ");
		sql.append(" left join Om_produto omproduto2 ON omproduto2.id_produto = dwpasscau.id_produto ");
		sql.append(" left join Dw_T_Defeito dwtdefeito ON dwtdefeito.id_tdefeito = dwpasscau.id_tdefeito ");
//		sql.append(" left join Dw_Passdef dwpassdef ON dwpassdef.id_passagem = dwpassagem.id_passagem ");
//		sql.append(" left join Dw_Passtf dwpasstf ON dwpasstf.id_passagem = dwpassagem.id_passagem ");
		
		if (filtro.getDataInicial() != null && filtro.getDataFinal() != null){
			sql.append("where dwpassagem.dthr between  ? and  ? ");
		}
		
		StringBuilder listaPlataformas = null;
		int iListaPlataforma = 0;
		if (
				filtro.getPlataformas() == null ||
				(filtro.getPlataformas().size()== 1 && filtro.getPlataformas().get(0) == null) || 
				(filtro.getPlataformas().size()== 1 && filtro.getPlataformas().get(0).getIdProgrp()==-1)){
			//plataformaOK = true;
			// Todas as plataformas serao processadas
			listaPlataformas = null;
		}else{
			
			for (OmProgrp omProgrp : filtro.getPlataformas()){
				if (listaPlataformas == null){
					listaPlataformas = new StringBuilder();
				} else
					listaPlataformas.append(",");
				
				listaPlataformas.append(omProgrp.getCdProgrp());
			}
		}
		if (listaPlataformas != null){
			if (sql.indexOf("where") < 0){
				sql.append(" where ");
				iListaPlataforma = 1;
			} else {
				sql.append(" and ");
				iListaPlataforma = 3;
			}
		
			sql.append("omprogrp.cd_Progrp in (?) ");
			
			//sql.append("omprogrp.cd_Progrp in (:listaPlataformas) ");
		}

		sql.append(" order by dwpassagem.dthr ");
		
		
		getDaoSession().doWork(new WorkExportacaoCSVRN(sql, filtro, listaPlataformas, iListaPlataforma, retorno));
		return retorno;
	}


}

