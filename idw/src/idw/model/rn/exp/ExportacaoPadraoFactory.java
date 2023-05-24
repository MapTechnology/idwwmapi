package idw.model.rn.exp;


import idw.model.IdwFacade;
import idw.model.pojos.DwExpcvspf;
import idw.webservices.dto.ExportacaoDTO;

public class ExportacaoPadraoFactory extends ExportacaoFactory {

	@Override
	public ExportacaoDTO exportaCVS() {
		ExportacaoDTO exportacao = new ExportacaoDTO();
		exportacao.setResultadoEvento(exportacao.getERRO_DESCONHECIDO());

		if (IdwFacade.getInstancia().isModoTeste() == true)
			filtro.setPath("C:/logsmap/");
		
		//seleciona todas as passagens que atendem ao filtro especificado 
		StringBuilder sqlFinal = new StringBuilder();
		StringBuilder sql1 = new StringBuilder();
		StringBuilder sql2 = new StringBuilder();
		sql1.append("select count(*) ");

		sql2.append("select A.*, ompt.*, dwpasstf.*, dwpasstfse.*, B.*, C.*, dwpassdef.*, dwtdefeito.*, D.*, dwpasscau.*, dwftsub.*, dwftetapa.*, dwpassmon.*, E.*, omprogrp.*, ");

		sql2.append("OPERADOR.cd_usr cd_usr_operador,");
		sql2.append("OPERADOR.ds_apelido ds_apelido_operador,");
		sql2.append("OPERADOR.ds_nome ds_nome_operador,");
		sql2.append("OPERADOR.dt_revisao dt_revisao_operador,");
		sql2.append("OPERADOR.dt_stativo dt_stativo_operador,");
		sql2.append("OPERADOR.id_usr id_usr_operador,");
		sql2.append("OPERADOR.login login_operador,");
		sql2.append("OPERADOR.revisao revisao_operador,");
		sql2.append("OPERADOR.senha senha_operador,");
		sql2.append("OPERADOR.st_ativo st_ativo_operador,");

		sql2.append("SUPERVISOR.cd_usr cd_usr_supervisor,");
		sql2.append("SUPERVISOR.ds_apelido ds_apelido_supervisor,");
		sql2.append("SUPERVISOR.ds_nome ds_nome_supervisor,");
		sql2.append("SUPERVISOR.dt_revisao dt_revisao_supervisor,");
		sql2.append("SUPERVISOR.dt_stativo dt_stativo_supervisor,");
		sql2.append("SUPERVISOR.id_usr id_usr_supervisor,");
		sql2.append("SUPERVISOR.login login_supervisor,");
		sql2.append("SUPERVISOR.revisao revisao_supervisor,");
		sql2.append("SUPERVISOR.senha senha_supervisor,");
		sql2.append("SUPERVISOR.st_ativo st_ativo_supervisor ");

		sqlFinal.append("from Dw_Passagem A ");
		sqlFinal.append(" join Om_Pt ompt on ompt.id_pt = A.id_pt");
		sqlFinal.append(" left join dw_Passtf dwpasstf on dwpasstf.id_passagem = A.id_passagem ");
		sqlFinal.append(" left join dw_Passtfse dwpasstfse on dwpasstfse.id_passtf = dwpasstf.id_passtf");
		sqlFinal.append(" left join dw_Nserie B on B.id_nserie = A.id_nserie");
		sqlFinal.append(" left join dw_Passdef dwpassdef on dwpassdef.id_passagem = A.id_passagem");
		sqlFinal.append(" left join dw_T_Defeito dwtdefeito on dwtdefeito.id_tdefeito = dwpassdef.id_tdefeito ");
		sqlFinal.append(" left join dw_Consolid D on D.id_consolid = A.id_consolid");
		sqlFinal.append(" left join dw_Passcau dwpasscau on dwpasscau.id_passagem = A.id_passagem");
		sqlFinal.append(" left join dw_Ft_Sub dwftsub on dwftsub.id_ft_sub = dwpasstfse.id_ft_sub");
		sqlFinal.append(" left join dw_Ft_Etapa dwftetapa on dwftetapa.id_ft_etapa = dwpasstf.id_ft_etapa");
		sqlFinal.append(" left join dw_Passmon dwpassmon on dwpassmon.id_passagem = A.id_passagem");
		sqlFinal.append(" left join dw_Folha E on E.id_folha = D.id_folha");
		sqlFinal.append(" left join dw_Folhamon F on F.id_folha = E.id_folha");
		sqlFinal.append(" left join om_Produto  C on C.id_produto = B.id_produto");
		sqlFinal.append(" left join om_Progrp omprogrp on omprogrp.id_progrp = C.id_progrp");
		sqlFinal.append(" left join om_Usr SUPERVISOR on SUPERVISOR.id_usr = A.id_usrsupervisor");
		sqlFinal.append(" left join om_Usr OPERADOR on OPERADOR.id_usr = A.id_usroperador");
		sqlFinal.append(" where 1=1 ");

		int iSku = 0;
		int iDsComplemento = 0;
		int iNserieinicial = 0;
		int iNseriefinal = 0;
		int iDthrIentrada = 0;
		int iDthrFentrada = 0;
		int iSupervisor = 0;
		int iOperador = 0;
		int contadorParametros = 0;
		int iPt = 0;

		if (filtro.getFiltro().getDthrIentrada() != null && filtro.getFiltro().getDthrFentrada() !=null){
			contadorParametros++;
			iDthrIentrada = contadorParametros;
			contadorParametros++;
			iDthrFentrada = contadorParametros;
			sqlFinal.append("AND A.dthr between ? and ? ");
		}else if (filtro.getFiltro().getDthrIentrada() !=null){
			contadorParametros++;
			iDthrIentrada = contadorParametros;
			sqlFinal.append("AND A.dthr = ? ");
		}else if (filtro.getFiltro().getDthrFentrada() != null){
			contadorParametros++;
			iDthrFentrada = contadorParametros;
			sqlFinal.append("AND A.dthr = ? ");
		}

		if (filtro.getFiltro().getOmPt() != null && !filtro.getFiltro().getOmPt().getCdPt().equals("")){
			contadorParametros++;
			iPt = contadorParametros;
			sqlFinal.append("AND ompt.cd_Pt = ? ");
		}

		if (filtro.getFiltro().getSku() != null && !filtro.getFiltro().getSku().equals("")){
			contadorParametros++;
			iSku = contadorParametros;
			sqlFinal.append("AND C.cd_Produto = ? ");
		}

		if (filtro.getFiltro().getDwExpcvspfs() != null && filtro.getFiltro().getDwExpcvspfs().size() > 0){
			boolean isExistePlataforma = false;
			for (DwExpcvspf pojo : filtro.getFiltro().getDwExpcvspfs()){
				if (pojo.getOmProgrp() != null)
					isExistePlataforma = true;
			}
			if (isExistePlataforma == true){
				sqlFinal.append("AND omprogrp.cd_Progrp in (" + getPlataformasEscolhidasParaIn().toString() + ") and omprogrp.st_Ativo = 1 ");
			}
		}

		if (filtro.getFiltro().getComplemento() != null && !filtro.getFiltro().getComplemento().equals("")){
			contadorParametros++;
			iDsComplemento = contadorParametros;
			sqlFinal.append("AND C.ds_Complemento = ? ");
		}

		if (filtro.getFiltro().getNserieincial() != null && filtro.getFiltro().getNseriefinal() != null && !filtro.getFiltro().getNserieincial().equals("") && !filtro.getFiltro().getNseriefinal().equals("")){
			contadorParametros++;
			iNserieinicial = contadorParametros;

			contadorParametros++;
			iNseriefinal = contadorParametros;

			sqlFinal.append("AND B.ns between ? and ? ");
		}else if (filtro.getFiltro().getNserieincial() != null && !filtro.getFiltro().getNserieincial().equals("")){
			contadorParametros++;
			iNserieinicial = contadorParametros;
			sqlFinal.append("AND B.ns = ? ");
		}else if (filtro.getFiltro().getNseriefinal() != null && !filtro.getFiltro().getNseriefinal().equals("")){
			contadorParametros++;
			iNseriefinal = contadorParametros;
			sqlFinal.append("AND B.ns = ? ");
		}

		if (filtro.getFiltro().getOmUsrByIdUsrsupervisor() != null && !filtro.getFiltro().getOmUsrByIdUsrsupervisor().getCdUsr().equals("")){
			contadorParametros++;
			iSupervisor = contadorParametros;
			sqlFinal.append("AND SUPERVISOR.cd_Usr = ? ");
		}

		if (filtro.getFiltro().getOmUsrByIdUsroperador() != null && !filtro.getFiltro().getOmUsrByIdUsroperador().getCdUsr().equals("")){
			contadorParametros++;
			iOperador = contadorParametros;
			sqlFinal.append("AND OPERADOR.cd_Usr = ? ");
		}

		if (filtro.getFiltro().getIsApenascomfalha() != null && filtro.getFiltro().getIsApenascomfalha() == true) {
			sqlFinal.append(" and dwpasstf.st_Etapa = 1 ");
		}
		
		if (filtro.getFiltro().getDwFtEtapa() != null && filtro.getFiltro().getDwFtEtapa().getCdEtapa().equals("") == false){
			sqlFinal.append(" and dwftetapa.id_Ft_etapa = " + filtro.getFiltro().getDwFtEtapa().getCdEtapa());
		}
		String sqlOrderBy =" order by A.id_passagem, A.dthr, A.ms_Dthr ";

		getSession().doWork(new WorkExportacaoPadraoFactoryRN(sql1, sql2, sqlFinal, filtro, iPt, iSku, iDsComplemento, iNserieinicial, iDthrIentrada, iNseriefinal, iDthrFentrada, iOperador, iSupervisor,getSession(),exportacao, this,sqlOrderBy));
		
		return exportacao;

	}
	
}
