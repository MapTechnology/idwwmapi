package idw.model.rn.exp;


import idw.model.IdwFacade;
import idw.model.pojos.DwExpcvspf;
import idw.webservices.dto.ExportacaoDTO;
import ms.util.UtilsThreads;


public class ExportacaoFullFactory extends ExportacaoFactory {

	@Override
	public ExportacaoDTO exportaCVS() {

		ExportacaoDTO exportacao = new ExportacaoDTO();
		exportacao.setResultadoEvento(exportacao.getERRO_DESCONHECIDO());
		if (IdwFacade.getInstancia().isModoTeste() == true)
			filtro.setPath("C:/logsmap/");

		StringBuilder sql = new StringBuilder();
		String sqlComplemento = "where ";
		
		sql.append("select * ");
		sql.append("from dw_passagem dwpassagem ");
		sql.append(" join dw_nserie dwnserie on dwnserie.id_nserie = dwpassagem.id_nserie ");
		sql.append(" join om_produto  omproduto on omproduto.id_produto = dwnserie.id_produto ");
		
		if (filtro.getFiltro().getOmPt() != null && !filtro.getFiltro().getOmPt().getCdPt().equals("")){
			sql.append(" join om_pt ompt on ompt.id_pt = dwpassagem.id_pt ");
		}

		if (filtro.getFiltro().getDwExpcvspfs() != null && filtro.getFiltro().getDwExpcvspfs().size() > 0){
			boolean isExisteGrupo = false;
			for (DwExpcvspf pojo : filtro.getFiltro().getDwExpcvspfs()){
				if (pojo.getOmProgrp() != null)
					isExisteGrupo = true;
				UtilsThreads.pausaNaThread(60l);
			}
			if (isExisteGrupo == true){
				sql.append(" left join om_progrp omprogrp on omprogrp.id_progrp = omproduto.id_progrp ");
			}
		}
		
		sql.append(" join dw_passtf dwpasstf on dwpasstf.id_passagem = dwpassagem.id_passagem ");
		sql.append(" join dw_passtfse dwpasstfse on dwpasstfse.id_passtf = dwpasstf.id_passtf ");
		sql.append(" join dw_passtfsepm_view dwpasstfsepmview on dwpasstfsepmview.id_passtfse = dwpasstfse.id_passtfse ");

		if (filtro.getFiltro().getDthrIentrada() !=null && filtro.getFiltro().getDthrFentrada() !=null){
			sql.append(sqlComplemento + " dwpassagem.dthr between ? and ? ");
			sqlComplemento = " and ";
		}else if (filtro.getFiltro().getDthrIentrada() !=null){
			sql.append(sqlComplemento + " dwpassagem.dthr = ? ");
			sqlComplemento = " and ";
		}else if (filtro.getFiltro().getDthrFentrada() !=null){
			sql.append(sqlComplemento + " dwpassagem.dthr = ? ");
			sqlComplemento = " and ";
		}
		
		if (filtro.getFiltro().getSku() != null && !filtro.getFiltro().getSku().equals("")){
			sql.append(sqlComplemento + " omproduto.cd_Produto = '" + filtro.getFiltro().getSku() + "'");
			sqlComplemento = " and ";
		}


		if (filtro.getFiltro().getDwExpcvspfs() != null && filtro.getFiltro().getDwExpcvspfs().size() > 0){
			boolean isExistePlataforma = false;
			for (DwExpcvspf pojo : filtro.getFiltro().getDwExpcvspfs()){
				if (pojo.getOmProgrp() != null)
					isExistePlataforma = true;
			}
			if (isExistePlataforma == true){
				sql.append(sqlComplemento + " omprogrp.cd_progrp in (" + getPlataformasEscolhidasParaIn().toString() + ") and omprogrp.st_ativo = 1 ");
				sqlComplemento = " and ";
			}
		}
		
		if (filtro.getFiltro().getOmPt() != null && !filtro.getFiltro().getOmPt().getCdPt().equals("")){
			sql.append(sqlComplemento + " ompt.cd_pt = '" + filtro.getFiltro().getOmPt().getCdPt() + "' ");
			sqlComplemento = " and ";
		}

		if (filtro.getFiltro().getNserieincial() != null && filtro.getFiltro().getNseriefinal() != null && !filtro.getFiltro().getNserieincial().equals("") && !filtro.getFiltro().getNseriefinal().equals("")){
			sql.append(sqlComplemento + " dwnserie.ns between '" + filtro.getFiltro().getNserieincial().trim() + "' and '" + filtro.getFiltro().getNseriefinal().trim() + "'");
			sqlComplemento = " and ";
		}else if (filtro.getFiltro().getNserieincial() != null &&  !filtro.getFiltro().getNserieincial().equals("")){
			sql.append(sqlComplemento + " dwnserie.ns = '" + filtro.getFiltro().getNserieincial().trim() + "'");
			sqlComplemento = " and ";
		}else if (filtro.getFiltro().getNseriefinal() != null && !filtro.getFiltro().getNseriefinal().equals("")){
			sql.append(sqlComplemento + " dwnserie.ns = '" + filtro.getFiltro().getNseriefinal().trim() + "'");
			sqlComplemento = " and ";
		}

		// Avalia corrente
		if (filtro.getFiltro().getCorrenteminima() != null && filtro.getFiltro().getCorrentemaxima() != null){
			sql.append(sqlComplemento + " dwpasstfsepmview.vlcorrente between " + filtro.getFiltro().getCorrenteminima() + " and " + filtro.getFiltro().getCorrentemaxima());
			sqlComplemento = " and ";
		} else if (filtro.getFiltro().getCorrenteminima() != null){
			sql.append(sqlComplemento + " dwpasstfsepmview.vlcorrente >= " + filtro.getFiltro().getCorrenteminima());
			sqlComplemento = " and ";
		} else if (filtro.getFiltro().getCorrentemaxima() != null){
			sql.append(sqlComplemento + " dwpasstfsepmview.vlcorrente <= " + filtro.getFiltro().getCorrentemaxima());
			sqlComplemento = " and ";
		}

		// Avalia tensao
		if (filtro.getFiltro().getTensaominima() != null && filtro.getFiltro().getTensaomaxima() != null){
			sql.append(sqlComplemento + " dwpasstfsepmview.tensao between " + filtro.getFiltro().getTensaominima() + " and " + filtro.getFiltro().getTensaomaxima());
			sqlComplemento = " and ";
		} else if (filtro.getFiltro().getTensaominima() != null){
			sql.append(sqlComplemento + " dwpasstfsepmview.tensao >= " + filtro.getFiltro().getTensaominima());
			sqlComplemento = " and ";
		} else if (filtro.getFiltro().getTensaomaxima() != null){
			sql.append(sqlComplemento + " dwpasstfsepmview.tensao <= " + filtro.getFiltro().getTensaomaxima());
			sqlComplemento = " and ";
		}

		// Fluxo entrada
		if (filtro.getFiltro().getStFluxoentrada() != null){
			sql.append(sqlComplemento + " dwpasstfsepmview.fluxoe = " + filtro.getFiltro().getStFluxoentrada());
			sqlComplemento = " and ";
		}

		// Fluxo saida
		if (filtro.getFiltro().getStFluxosaida() != null){
			sql.append(sqlComplemento + " dwpasstfsepmview.fluxos = " + filtro.getFiltro().getStFluxosaida());
			sqlComplemento = " and ";
		}
		
		// Pega testes com falha
		if (filtro.getFiltro().getIsApenascomfalhareprocesso() != null && filtro.getFiltro().getIsApenascomfalhareprocesso() == true) {
			sql.append(sqlComplemento + " dwpasstf.st_etapa = 1 ");
			sqlComplemento = " and ";
		}
		
		// Pega testes com sucesso
		if (filtro.getFiltro().getIsApenassucessoreprocesso() != null && filtro.getFiltro().getIsApenassucessoreprocesso() == true) {
			sql.append(sqlComplemento + " dwpasstf.st_etapa = 0 ");
			sqlComplemento = " and ";
		}

		sql.append(" order by dwpasstfsepmview.dthr_medicao, dwpasstfsepmview.ms_dthrmedicao ");
		

		getSession().doWork(new WorkExportacaoFullFactory(filtro, sql, exportacao, this));
		
		return exportacao;
	}
}
