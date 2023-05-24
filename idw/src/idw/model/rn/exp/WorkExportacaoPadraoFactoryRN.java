package idw.model.rn.exp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import idw.model.IdwFacade;
import idw.model.dao.MapQuery;
import idw.model.excessoes.SemConfiguracaoException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFtEtapa;
import idw.model.pojos.DwFtSub;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwPasscau;
import idw.model.pojos.DwPassdef;
import idw.model.pojos.DwPassmon;
import idw.model.pojos.DwPasstf;
import idw.model.pojos.DwPasstfse;
import idw.model.pojos.DwPasstfsepmView;
import idw.model.pojos.DwTDefeito;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.rn.DataHoraRN;
import idw.util.Compress;
import idw.webservices.dto.ExpAcaoDTO;
import idw.webservices.dto.ExpArquivoExportadoDTO;
import idw.webservices.dto.ExpCausaDTO;
import idw.webservices.dto.ExpDetalheLinhaExportadaDTO;
import idw.webservices.dto.ExpLinhaExportadaDTO;
import idw.webservices.dto.ExportacaoDTO;
import idw.webservices.dto.FiltroExportacaoDTO;
import ms.util.UtilsThreads;

public class WorkExportacaoPadraoFactoryRN implements Work{

	private StringBuilder sql1;
	private StringBuilder sql2;
	private StringBuilder sqlFinal;
	private String sqlOrderBy;
	private FiltroExportacaoDTO filtro;
	private int iPt, iSku, iDsComplemento, iNserieinicial, iDthrIentrada, iNseriefinal, iDthrFentrada, iOperador, iSupervisor;
	private ExportacaoDTO exportacao;
	private List<String> nomeArquivos = new ArrayList<String>();
	private Session sessao;
	private ExportacaoPadraoFactory expRN;
	
	public WorkExportacaoPadraoFactoryRN(StringBuilder sql1, StringBuilder sql2, StringBuilder sqlFinal, FiltroExportacaoDTO filtro, int iPt, int iSku, int iDsComplemento, int iNserieinicial, int iDthrIentrada, int iNseriefinal, int iDthrFentrada, int iOperador, int iSupervisor,Session sessao,ExportacaoDTO exportacao,ExportacaoPadraoFactory expRN , String sqlOrderBy  ) {
		this.sql1=sql1;
		this.sql2=sql2;
		this.sqlFinal=sqlFinal;
		this.filtro=filtro;
		this.iPt=iPt;
		this.iSku=iSku;
		this.iDsComplemento=iDsComplemento;
		this.iNserieinicial=iNserieinicial;
		this.iDthrIentrada=iDthrIentrada;
		this.iNseriefinal=iNseriefinal;
		this.iDthrFentrada=iDthrFentrada;
		this.iOperador=iOperador;
		this.iSupervisor=iSupervisor;
		this.sessao=sessao;
		this.exportacao=exportacao;
		this.expRN=expRN;
		this.sqlOrderBy=sqlOrderBy;
	}
	
	@Override
	public void execute(Connection connection) throws SQLException {
		PreparedStatement  ps = null;
		ResultSet rs = null;
		
		// Obtem a quantidade de registros que serao avalaidos
		try {			
			sql1.append(sqlFinal);
			ps = connection.prepareStatement(sql1.toString(), ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (filtro.getFiltro().getOmPt() != null && !filtro.getFiltro().getOmPt().getCdPt().equals("")){
			try {
				ps.setString(iPt, filtro.getFiltro().getOmPt().getCdPt());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (filtro.getFiltro().getSku() != null && filtro.getFiltro().getSku().equals("") == false)
			try {
				ps.setString(iSku, filtro.getFiltro().getSku());
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		if (filtro.getFiltro().getComplemento() != null && filtro.getFiltro().getComplemento().equals("") == false)
			try {
				ps.setString(iDsComplemento, filtro.getFiltro().getComplemento());
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
		if (filtro.getFiltro().getNserieincial() != null && filtro.getFiltro().getNserieincial().equals("") == false)
			try {
				ps.setString(iNserieinicial, filtro.getFiltro().getNserieincial());
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
		if (filtro.getFiltro().getNseriefinal() != null && filtro.getFiltro().getNseriefinal().equals("") == false)
			try {
				ps.setString(iNseriefinal, filtro.getFiltro().getNseriefinal());
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		if (filtro.getFiltro().getDthrIentrada() != null)
			try {
				ps.setTimestamp(iDthrIentrada, new Timestamp(filtro.getFiltro().getDthrIentrada().getTime()));
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
		if (filtro.getFiltro().getDthrFentrada() != null)
			try {
				ps.setTimestamp(iDthrFentrada, new Timestamp(filtro.getFiltro().getDthrFentrada().getTime()));
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		if (filtro.getFiltro().getOmUsrByIdUsrsupervisor() != null && filtro.getFiltro().getOmUsrByIdUsrsupervisor().getCdUsr().equals("") == false){
			try {
				ps.setString(iSupervisor, filtro.getFiltro().getOmUsrByIdUsrsupervisor().getCdUsr());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (filtro.getFiltro().getOmUsrByIdUsroperador() != null && filtro.getFiltro().getOmUsrByIdUsroperador().getCdUsr().equals("") == false){
			try {
				ps.setString(iOperador, filtro.getFiltro().getOmUsrByIdUsroperador().getCdUsr());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		Date di1 = new Date();
		try{
			if (filtro.getFiltro().getQtLinhasporarquivo() != null){
				rs = ps.executeQuery();
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		Date df2 = new Date();
		
		//determina a lista de arquivos que sera retornada List<ArquivoExportadoDTO
		if (filtro.getFiltro().getQtTotallinhas() == null){
			filtro.getFiltro().setQtTotallinhas(BigDecimal.valueOf(0l));
		}
		int qtde_arquivos = 1;
		if (filtro.getFiltro().getQtLinhasporarquivo() != null){
			int totallinhas = 0;
			try {
				if (rs.next() == true)
					totallinhas = rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int totalDefinidaPeloUsuario = filtro.getFiltro().getQtTotallinhas().intValue();
			if (totalDefinidaPeloUsuario > 0){
				if (totallinhas > totalDefinidaPeloUsuario){
					totallinhas = totalDefinidaPeloUsuario;
				}
			}

			qtde_arquivos = totallinhas / filtro.getFiltro().getQtLinhasporarquivo().intValue();
			if (qtde_arquivos * filtro.getFiltro().getQtLinhasporarquivo().intValue() < totallinhas){
				qtde_arquivos++;				
			}
		}
		if (qtde_arquivos <= 0){
			qtde_arquivos = 1;
		}
		List<ExpArquivoExportadoDTO> listaArquivos = new ArrayList<ExpArquivoExportadoDTO>();
		for (int i = 1; i <= qtde_arquivos; i++){
			ExpArquivoExportadoDTO arquivo = new ExpArquivoExportadoDTO();
			arquivo.setNomeArquivo(filtro.getPrefixo() + String.valueOf(i));
			listaArquivos.add(arquivo);
		}	

		int arquivo = 0;
		int linha = 0;

		OmCfg omCfg = null;

		try {
			omCfg = IdwFacade.getInstancia().pesquisaOmcfg();
		} catch (SemConfiguracaoException e1) {
			exportacao.setResultadoEvento(exportacao.getSEM_CONFIGURACAO());
			return;
		}

		BufferedWriter arquivoExportado = null;
		ExpArquivoExportadoDTO expArquivo = new ExpArquivoExportadoDTO();
		
		
		
		// Pesquisa os dados
		try {
			sql2.append(sqlFinal);
			sql2.append(sqlOrderBy);
			ps = connection.prepareStatement(sql2.toString(), ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (filtro.getFiltro().getOmPt() != null && !filtro.getFiltro().getOmPt().getCdPt().equals("")){
			try {
				ps.setString(iPt, filtro.getFiltro().getOmPt().getCdPt());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		if (filtro.getFiltro().getSku() != null && filtro.getFiltro().getSku().equals("") == false)
			try {
				ps.setString(iSku, filtro.getFiltro().getSku());
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		if (filtro.getFiltro().getComplemento() != null && filtro.getFiltro().getComplemento().equals("") == false)
			try {
				ps.setString(iDsComplemento, filtro.getFiltro().getComplemento());
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
		if (filtro.getFiltro().getNserieincial() != null && filtro.getFiltro().getNserieincial().equals("") == false)
			try {
				ps.setString(iNserieinicial, filtro.getFiltro().getNserieincial());
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
		if (filtro.getFiltro().getNseriefinal() != null && filtro.getFiltro().getNseriefinal().equals("") == false)
			try {
				ps.setString(iNseriefinal, filtro.getFiltro().getNseriefinal());
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		if (filtro.getFiltro().getDthrIentrada() != null)
			try {
				ps.setTimestamp(iDthrIentrada, new Timestamp(filtro.getFiltro().getDthrIentrada().getTime()));
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
		if (filtro.getFiltro().getDthrFentrada() != null)
			try {
				ps.setTimestamp(iDthrFentrada, new Timestamp(filtro.getFiltro().getDthrFentrada().getTime()));
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		if (filtro.getFiltro().getOmUsrByIdUsrsupervisor() != null && filtro.getFiltro().getOmUsrByIdUsrsupervisor().getCdUsr().equals("") == false){
			try {
				ps.setString(iSupervisor, filtro.getFiltro().getOmUsrByIdUsrsupervisor().getCdUsr());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (filtro.getFiltro().getOmUsrByIdUsroperador() != null && filtro.getFiltro().getOmUsrByIdUsroperador().getCdUsr().equals("") == false){
			try {
				ps.setString(iOperador, filtro.getFiltro().getOmUsrByIdUsroperador().getCdUsr());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		di1 = new Date();
		try{
			rs = ps.executeQuery();
		} catch (Exception e){
			e.printStackTrace();
		}
		df2 = new Date();
		System.out.println("Query exportacao em seg = " + DataHoraRN.getQuantidadeSegundosNoPeriodo(di1, df2) + "  " + sql2);
		
		try {
			int qtdTotalLinha = 0;
			Boolean isExisteRegistro = rs.next(); // o boolean foi criado pq o resultset deixou de ser scroll para consumir menos memoria, e como existe um metodo q tb faz o next, precisei deixar isso em um flag
			while (isExisteRegistro == true) {
				
				// Testa se ja ultrapassou a quantidade total de linhas a serem exportadas
				if (filtro.getFiltro().getQtTotallinhas() != null && filtro.getFiltro().getQtTotallinhas().intValue() > 0 && qtdTotalLinha >= filtro.getFiltro().getQtTotallinhas().intValue()){
					break;
				}
				DwPassagem dwPassagem = new DwPassagem();
				
				isExisteRegistro = instanciarDwPassagem(rs, dwPassagem);
				
				linha ++;
				qtdTotalLinha++; // conta qts linha ja foram exportadas
				if (arquivoExportado == null || (qtde_arquivos > 1 && linha > filtro.getFiltro().getQtLinhasporarquivo().intValue())){
					if (arquivoExportado != null){
						arquivo ++;
						linha = 1;
					}
					
					// Usar novo arquivo para gravar as linhas
					try {
						if (arquivoExportado != null){
							arquivoExportado.close();
						}
						String nomeArquivo = filtro.getPath() + "/" + listaArquivos.get(arquivo).getNomeArquivo() + ".csv";
						nomeArquivos.add(nomeArquivo);
						arquivoExportado = new BufferedWriter(new FileWriter(new File(nomeArquivo), false));
					} catch (IOException e) {
						exportacao.setResultadoEvento(exportacao.getERRO_IO());
						rs.close();
						ps.close();
						return;
					} catch (IndexOutOfBoundsException e){
						// Eh pq ja ultrapassou a qtde de linhas no total, pois nao existem novos arquivos para receber a linha
						break; // sai do while
					}
				}
	
				ExpLinhaExportadaDTO expLinha = null;
	
				// Inicializa expLinha
				expLinha = new ExpLinhaExportadaDTO(dwPassagem);
				
	
				expLinha.inicializaComponentesMontados(dwPassagem);
				expLinha.inicializaStatusUltimoTeste(dwPassagem, omCfg);
				
					
				List<ExpCausaDTO> defeitos = new ArrayList<ExpCausaDTO>();
				ExpCausaDTO expCausa = new ExpCausaDTO();
				expCausa.setId_passcau(0);	
	
				long idPassCau = expLinha.inicializaCausaDoDefeito(dwPassagem);
				
				if (idPassCau > 0){
					expCausa = new ExpCausaDTO();
					ExpAcaoDTO expAcao = new ExpAcaoDTO();
	
					try {
						sqlFinal = null;
						sqlFinal = new StringBuilder();
						sqlFinal.append("from DwPasscau t where t.idPasscau = :idPasscau ");
	
	
						MapQuery q = new MapQuery(sessao.createQuery(sqlFinal.toString()));
	
						q.defineParametro("idPasscau", idPassCau);
	
						DwPasscau item = (DwPasscau) q.query().uniqueResult();
	
						expAcao.setCdAcao(item.getDwTAcao().getCdTacao());
						expAcao.setDsAcao(item.getDwTAcao().getDsTacao());
						expCausa.setCdDefeito(item.getDwTDefeito().getCdTdefeito());
						expCausa.setDsDefeito(item.getDwTDefeito().getDsTdefeito());
						expCausa.setAcao(expAcao);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
	
				defeitos.add(expCausa);
				expLinha.setDefeitos(defeitos);
	
				List<ExpDetalheLinhaExportadaDTO> detalhes = new ArrayList<ExpDetalheLinhaExportadaDTO>();
	
				for (DwPasstf dwPasstf : dwPassagem.getDwPasstfs()){
					for (DwPasstfse dwPasstfse : dwPasstf.getDwPasstfses()){
						Set<DwPasstfsepmView> ldwpasstfsepm = null;
	
						ldwpasstfsepm = new HashSet<DwPasstfsepmView>();
						
						ExpDetalheLinhaExportadaDTO detalhe = null;
						if (filtro.getFiltro().getTpExportacao().intValue() == 3){
							for (DwPasstfsepmView dwPasstfsepmView : ldwpasstfsepm){
								detalhe = new ExpDetalheLinhaExportadaDTO(dwPassagem, dwPasstf, dwPasstfse, dwPasstfsepmView);
								detalhes.add(detalhe);
								UtilsThreads.pausaNaThread(60l);
							}
						}
						UtilsThreads.pausaNaThread(60l);
					}
					UtilsThreads.pausaNaThread(60l);
				}
				sessao.clear();
				expLinha.setDetalhes(detalhes);
				
				// A linha abaixo foi comentada pois ao inves de guardar em memoria será gravado direto no arquivo
	//			expLinhas.add(expLinha);
				
				expArquivo.setLinhas(new ArrayList<ExpLinhaExportadaDTO>());
				expArquivo.getLinhas().add(expLinha);
				
				//Modelo resumido empilhado
				if (filtro.getFiltro().getTpExportacao().byteValue() == 1){
					expArquivo.setConteudo(expRN.exportaModeloResumidoEmpilhado(expArquivo));
				}
				//Modelo resumido horizontal
				if (filtro.getFiltro().getTpExportacao().byteValue() == 2){
					expArquivo.setConteudo(expRN.exportaModeloResumidoHorizontal(expArquivo));
				}
				//Modelo detalhamento dos testes
				if (filtro.getFiltro().getTpExportacao().byteValue() == 3){
					expArquivo.setConteudo(expRN.exportaModeloDetalhamentoTestes(expArquivo));
				}
	
				// Salvando linha em arquivo
				try {
					arquivoExportado.write(expArquivo.getConteudo());
				} catch (IOException e) {
					exportacao.setResultadoEvento(exportacao.getERRO_IO());
					return;
				}
				
				// Limpando memoria
				expLinha = null;
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		// A linha abaixo foi comentada pq a lista de arquivos nao sera mais enviada para o cliente, visto que os arquivos ja foram gerados na propria RN
		//exportacao.setArquivos(listaArquivos);

		// Ajuda ao garbage collector
		try {
			if (arquivoExportado != null){
				arquivoExportado.close();
				exportacao.setResultadoEvento(exportacao.getEVENTO_BEM_SUCEDIDO());
			} else {
				exportacao.setResultadoEvento(exportacao.getERRO_SEM_INFORMACAO());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Alessandre: Comentei a linha abaixo para usar outro metodo compactar que recebe a lista dos arquivos
		// isso pq em alguma situacao a exportacao gerou dados do modelo 1 e 3 no mesmo arquivo. Acho que poderia ser a rotina de compactacao, mas nao
		// tenho certeza.
		//Compress.compactar(filtro.getPath() + "/", filtro.getPrefixo(), ".csv", filtro.getPath() + "/" + filtro.getPrefixo() + ".zip");
		try {
			Compress.compactar(nomeArquivos, filtro.getPath() + "/" + filtro.getPrefixo() + ".zip");
		} catch (Exception e){}
		
		sqlFinal = null;
		
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		omCfg = null;

	}

	private Boolean instanciarDwPassagem(ResultSet rs, DwPassagem retorno) throws SQLException{
		retorno.setDthr(rs.getTimestamp("dthr"));
		
		retorno.setDthrInicio(rs.getTimestamp("dthr_inicio"));
		retorno.setIdPassagem(rs.getLong("id_passagem"));
		retorno.setIsTfFinalizado(rs.getBoolean("is_tf_finalizado"));
		retorno.setMsDthr(rs.getInt("ms_dthr"));
		retorno.setSegCiclo(rs.getBigDecimal("seg_ciclo"));
		retorno.setStNserie(rs.getByte("st_nserie"));
		retorno.setOmPt(instanciaOmPt(rs));
		retorno.setDwConsolid(instanciaDwConsolid(rs));
		retorno.setDwNserie(instanciaDwNserie(rs));
		retorno.setDwPasscau(instanciaDwPasscau(rs));
		retorno.setOmUsrByIdUsroperador(instanciaOperador(rs));
		retorno.setOmUsrByIdUsrsupervisor(instanciaSupervisor(rs));
		retorno.getDwPassmons().add(instanciaDwPassmon(rs));
		retorno.getDwPassdefs().add(instanciaDwPassdef(rs));
		retorno.setDwEst(instanciaDwEst(rs));

		// Varre demais registros ate mudar a passagem, quando isso ocorrer volta um registro
		// Se for final de arquivo volta um registro tb
		//
		Boolean isExisteRegistro = true;
		do {
			Long idpassagem = rs.getLong("id_passagem");

			// Verifica se o registro avaliado ainda é do retorno
			if (retorno.getIdPassagem() != idpassagem ){
				break;
			}
			instanciarDwPasstfs(rs, retorno);
			//System.out.println(",,,instanciaDwpasstfs mili = " + DataHoraRN.getQuantidadeMilisegundosNoPeriodo(d1, d2));
			
			UtilsThreads.pausaNaThread(60l);

//			retorno.setDwNseries(dwNseries);
//			retorno.setDwPasscaus(dwPasscaus);
			isExisteRegistro = rs.next();
		} while (isExisteRegistro == true);
		
//		sqlFinal.append(" join Om_Pt ompt on ompt.id_pt = A.id_pt");
//		sqlFinal.append(" left join dw_Passtf dwpasstf on dwpasstf.id_passagem = A.id_passagem ");
//		sqlFinal.append(" left join dw_Passtfse dwpasstfse on dwpasstfse.id_passtf = dwpasstf.id_passtf");
//		sqlFinal.append(" left join dw_Nserie B on B.id_nserie = A.id_nserie");
//		sqlFinal.append(" left join dw_Passdef dwpassdef on dwpassdef.id_passagem = A.id_passagem");
//		sqlFinal.append(" left join dw_T_Defeito dwtdefeito on dwtdefeito.id_tdefeito = dwpassdef.id_tdefeito ");
//		sqlFinal.append(" left join dw_Consolid D on D.id_consolid = A.id_consolid");
//		sqlFinal.append(" left join dw_Passcau dwpasscau on dwpasscau.id_passagem = A.id_passagem");
//		sqlFinal.append(" left join dw_Ft_Sub dwftsub on dwftsub.id_ft_sub = dwpasstfse.id_ft_sub");
//		sqlFinal.append(" left join dw_Ft_Etapa dwftetapa on dwftetapa.id_ft_etapa = dwpasstf.id_ft_etapa");
//		sqlFinal.append(" left join dw_Passmon dwpassmon on dwpassmon.id_passagem = A.id_passagem");
//		sqlFinal.append(" left join dw_Folha E on E.id_folha = D.id_folha");
//		sqlFinal.append(" left join dw_Folhamon F on F.id_folha = E.id_folha");
//		sqlFinal.append(" left join om_Produto  C on C.id_produto = B.id_produto");
//		sqlFinal.append(" left join om_Progrp omprogrp on omprogrp.id_progrp = C.id_progrp");
//		sqlFinal.append(" left join om_Usr SUPERVISOR on SUPERVISOR.id_usr = A.id_usrsupervisor");
//		sqlFinal.append(" left join om_Usr OPERADOR on OPERADOR.id_usr = A.id_usroperador");

		//rs.previous(); // pq???
		
		return isExisteRegistro;
	}
	private void instanciarDwPasstfs(ResultSet rs, DwPassagem dw){
		// Procura se ja existe em dw o registro que se deseja incluir
		boolean isExiste = false;
		DwPasstf dwpasstf = null;
		if (dw.getDwPasstfs() != null && dw.getDwPasstfs().size() > 0){
			for (DwPasstf dp : dw.getDwPasstfs()){
				try {
					if (dp.getIdPasstf() == rs.getLong("id_passtf")){
						dwpasstf = dp;
						isExiste = true;
						break;
					}
				} catch (SQLException e){
					e.printStackTrace();
				}
				UtilsThreads.pausaNaThread(10l);
			}
		}
		
		// Se nao existir, incluir
		if (isExiste == false){
			dwpasstf = new DwPasstf();
			
			DwFtEtapa dwFtEtapa = new DwFtEtapa();
			try {
				dwFtEtapa.setCdEtapa(rs.getString("cd_etapa"));
				dwFtEtapa.setDsEtapa(rs.getString("ds_etapa"));
				dwFtEtapa.setDsMensagemnok(rs.getString("ds_mensagemnok"));
				dwFtEtapa.setDsMensagemok(rs.getString("ds_mensagemok"));
	
				dwpasstf.setDthrFetapa(rs.getDate("dthr_fetapa"));
				dwpasstf.setDthrIetapa(rs.getDate("dthr_ietapa"));
				dwpasstf.setIdPasstf(rs.getLong("id_passtf"));
				dwpasstf.setMsDthrfetapa(rs.getBigDecimal("ms_dthrfetapa"));
				dwpasstf.setMsDthrietapa(rs.getBigDecimal("ms_dthrietapa"));
				dwpasstf.setOrdemetapa(rs.getInt("ordemetapa"));
				dwpasstf.setStEtapa(rs.getInt("st_etapa"));
			} catch (SQLException e){
				e.printStackTrace();
			}
			dwpasstf.setDwFtEtapa(dwFtEtapa);

			dw.getDwPasstfs().add(dwpasstf);
		}
		
		// Incluir dwpasstfse
		instanciarDwPasstfse(rs, dwpasstf);
	}
	private void instanciarDwPasstfse(ResultSet rs, DwPasstf dwpasstf){
		boolean isExiste = false;
		DwPasstfse dwpasstfse = null;
		if (dwpasstf.getDwPasstfses() != null && dwpasstf.getDwPasstfses().size() > 0){
			for (DwPasstfse dp : dwpasstf.getDwPasstfses()){
				try {
					if (dp.getIdPasstfse() == rs.getLong("id_passtfse")){
						dwpasstfse = dp;
						isExiste = true;
						break;
					}
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
		
		if (isExiste == false){
			dwpasstfse = new DwPasstfse();
			DwFtSub dwFtSub = new DwFtSub();
			try {
				dwFtSub.setDsSub(rs.getString("ds_sub"));
				dwFtSub.setIdFtSub(rs.getLong("id_ft_sub"));
				dwFtSub.setMs(rs.getInt("ms"));
				dwFtSub.setStFtParam(rs.getByte("st_ft_param"));
				dwFtSub.setTpFtParam(rs.getByte("tp_ft_param"));
				dwFtSub.setTpFtSub(rs.getByte("tp_ft_sub"));
				dwFtSub.setTpStatus(rs.getByte("tp_status"));
				dwFtSub.setVlFtParam(rs.getBigDecimal("vl_ft_param"));
				dwFtSub.setX41(rs.getInt("x41"));
				dwFtSub.setX42(rs.getInt("x42"));
				dwFtSub.setX45(rs.getInt("x45"));
				dwFtSub.setX46(rs.getInt("x46"));
				dwFtSub.setX47(rs.getInt("x47"));
				dwFtSub.setX48(rs.getInt("x48"));
				dwFtSub.setX49(rs.getInt("x49"));
				dwFtSub.setY81(rs.getBigDecimal("y81"));
				dwFtSub.setY82(rs.getBigDecimal("y82"));
				dwFtSub.setY83(rs.getBigDecimal("y83"));
				dwFtSub.setY84(rs.getBigDecimal("y84"));
				
				dwpasstfse.setDwFtSub(dwFtSub);
				dwpasstfse.setIdPasstfse(rs.getLong("id_passtfse"));
				dwpasstfse.setOrdemsubetapa(rs.getInt("ordemsubetapa"));
				dwpasstfse.setStSubetapa(rs.getInt("st_subetapa"));
			} catch (SQLException e){
				e.printStackTrace();
			}
			dwpasstf.getDwPasstfses().add(dwpasstfse);
		}
	}
	private DwPassdef instanciaDwPassdef(ResultSet rs){
		DwPassdef retorno = new DwPassdef();
		try {
			retorno.setIdPassdef(rs.getLong("id_passdef"));
			retorno.setDwTDefeito(instanciaDwTDefeito(rs));
		} catch (SQLException e){
			e.printStackTrace();
		}
		return retorno;
	}
	private DwTDefeito instanciaDwTDefeito(ResultSet rs){
		DwTDefeito retorno = new DwTDefeito();
		try {
			retorno.setCdTdefeito(rs.getString("cd_tdefeito"));
			retorno.setDsTdefeito(rs.getString("ds_tdefeito"));
			retorno.setDtRevisao(rs.getDate("dt_revisao"));
			retorno.setDtStativo(rs.getDate("dt_stativo"));
			retorno.setIdTdefeito(rs.getLong("id_tdefeito"));
			retorno.setIsRequeracao(rs.getBoolean("is_requeracao"));
			retorno.setRevisao(rs.getLong("revisao"));
			retorno.setStAtivo(rs.getByte("st_ativo"));
		} catch (SQLException e){
			e.printStackTrace();
		}
		return retorno;
	}
	private DwPassmon instanciaDwPassmon (ResultSet rs){
		DwPassmon retorno = new DwPassmon();
		try {
			retorno.setDsMon(rs.getString("ds_mon"));
			retorno.setIdPassmon(rs.getLong("id_passmon"));
			retorno.setIsAlternativo(rs.getBoolean("is_alternativo"));
		} catch (SQLException e){
			e.printStackTrace();
		}
		return retorno;
	}
	private OmUsr instanciaSupervisor(ResultSet rs){
		OmUsr retorno = new OmUsr();
		try {
			retorno.setCdUsr(rs.getString("cd_usr_supervisor"));
			retorno.setDsApelido(rs.getString("ds_apelido_supervisor"));
			retorno.setDsNome(rs.getString("ds_nome_supervisor"));
			retorno.setDtRevisao(rs.getDate("dt_revisao_supervisor"));
			retorno.setDtStativo(rs.getDate("dt_stativo_supervisor"));
			retorno.setIdUsr(rs.getLong("id_usr_supervisor"));
			retorno.setLogin(rs.getString("login_supervisor"));
			retorno.setRevisao(rs.getLong("revisao_supervisor"));
			retorno.setSenha(rs.getString("senha_supervisor"));
			retorno.setStAtivo(rs.getByte("st_ativo_supervisor"));
		} catch (SQLException e){
			e.printStackTrace();
		}
		return retorno;
	}

	private OmUsr instanciaOperador(ResultSet rs){
		OmUsr retorno = new OmUsr();
		try {
			retorno.setCdUsr(rs.getString("cd_usr_operador"));
			retorno.setDsApelido(rs.getString("ds_apelido_operador"));
			retorno.setDsNome(rs.getString("ds_nome_operador"));
			retorno.setDtRevisao(rs.getDate("dt_revisao_operador"));
			retorno.setDtStativo(rs.getDate("dt_stativo_operador"));
			retorno.setIdUsr(rs.getLong("id_usr_operador"));
			retorno.setLogin(rs.getString("login_operador"));
			retorno.setRevisao(rs.getLong("revisao_operador"));
			retorno.setSenha(rs.getString("senha_operador"));
			retorno.setStAtivo(rs.getByte("st_ativo_operador"));
		} catch (SQLException e){
			e.printStackTrace();
		}
		return retorno;
	}
	private DwPasscau instanciaDwPasscau(ResultSet rs){
		DwPasscau retorno = new DwPasscau();
		try {
			retorno.setIdPasscau(rs.getLong("id_passcau"));
		} catch (SQLException e){
			e.printStackTrace();
		}
		return retorno;
	}
	private DwNserie instanciaDwNserie(ResultSet rs){
		DwNserie retorno = new DwNserie();
		try {
			retorno.setCb(rs.getString("cb"));
			retorno.setIdNserie(rs.getLong("id_nserie"));
			retorno.setNs(rs.getString("ns"));
			retorno.setOmProduto(instanciaOmProduto(rs));
		} catch (SQLException e){
			e.printStackTrace();
		}
		return retorno;
	}
	private OmProduto instanciaOmProduto(ResultSet rs){
		OmProduto retorno = new OmProduto();
		
		try {
			retorno.setCdProduto(rs.getString("cd_produto"));
			retorno.setDsProduto(rs.getString("ds_produto"));
			retorno.setDepara(rs.getString("depara"));
			retorno.setDsComplemento(rs.getString("ds_complemento"));
			retorno.setDtRevisao(rs.getDate("dt_revisao"));
			retorno.setDtStativo(rs.getDate("dt_stativo"));
			retorno.setIdProduto(rs.getLong("id_produto"));
			retorno.setRevisao(rs.getLong("revisao"));
			retorno.setStAtivo(rs.getByte("st_ativo"));
			retorno.setTpProduto(rs.getByte("tp_produto"));
			retorno.setOmProgrp(instanciaOmProgrp(rs));
		} catch (SQLException e){
			e.printStackTrace();
		}
		return retorno;
	}
	private OmProgrp instanciaOmProgrp(ResultSet rs){
		OmProgrp retorno = new OmProgrp();
		
		try {
			retorno.setCdProgrp(rs.getString("cd_progrp"));
			retorno.setDsProgrp(rs.getString("ds_progrp"));
			retorno.setDtRevisao(rs.getDate("dt_revisao"));
			retorno.setDtStativo(rs.getDate("dt_stativo"));
			retorno.setIdProgrp(rs.getLong("id_progrp"));
			retorno.setRevisao(rs.getLong("revisao"));
			retorno.setStAtivo(rs.getByte("st_ativo"));
		} catch (SQLException e){
			e.printStackTrace();
		}
		return retorno;
	}
	private OmPt instanciaOmPt(ResultSet rs){
		OmPt retorno = new OmPt();
		try {
			retorno.setCdPt(rs.getString("cd_pt"));
			retorno.setDepara(rs.getString("depara"));
			retorno.setDsCurta(rs.getString("ds_curta"));
			retorno.setDsPt(rs.getString("ds_pt"));
			retorno.setDtRevisao(rs.getDate("dt_revisao"));
			retorno.setDtStativo(rs.getDate("dt_stativo"));
			retorno.setIdPt(rs.getLong("id_pt"));
			retorno.setRevisao(rs.getLong("revisao"));
			retorno.setStAtivo(rs.getByte("st_ativo"));
			retorno.setTpImpprog(rs.getByte("tp_impprog"));
			retorno.setUrlConexao(rs.getString("url_conexao"));
		} catch (SQLException e){
			e.printStackTrace();
		}
		return retorno;
	}
	
	private DwConsolid instanciaDwConsolid(ResultSet rs){
		DwConsolid retorno = new DwConsolid();
		
		try {
			retorno.setAno(rs.getInt("ano"));
			retorno.setDthrCadastro(rs.getDate("dthr_cadastro"));
			retorno.setDthrFhora(rs.getDate("dthr_fhora"));
			retorno.setDthrFturno(rs.getDate("dthr_fturno"));
			retorno.setDthrIhora(rs.getDate("dthr_ihora"));
			retorno.setDthrIturno(rs.getDate("dthr_iturno"));
			retorno.setDtReferencia(rs.getDate("dt_referencia"));
			retorno.setIdConsolid(rs.getLong("id_consolid"));
			retorno.setMes(rs.getInt("mes"));
			retorno.setDwFolha(instanciaDwFolha(rs));
		} catch (SQLException e){
			e.printStackTrace();
		}
		return retorno;
	}
	private DwFolha instanciaDwFolha(ResultSet rs){
		DwFolha retorno = new DwFolha();
		
		try{
			retorno.setCdFolha(rs.getString("cd_folha"));
			retorno.setDsFolha(rs.getString("ds_folha"));
			retorno.setDtRevisao(rs.getDate("dt_revisao"));
			retorno.setDtStativo(rs.getDate("dt_stativo"));
			retorno.setIdFolha(rs.getLong("id_folha"));
			retorno.setIsLogonobrigatorio(rs.getBoolean("is_logonobrigatorio"));
			retorno.setIsModelo(rs.getBoolean("is_modelo"));
			retorno.setRevisao(rs.getLong("revisao"));
			retorno.setSegCiclominimo(rs.getBigDecimal("seg_ciclominimo"));
			retorno.setSegCiclopadrao(rs.getBigDecimal("seg_ciclopadrao"));
			retorno.setSegCiclotimeout(rs.getBigDecimal("seg_ciclotimeout"));
			retorno.setSegLogoutauto(rs.getBigDecimal("seg_logoutauto"));
			retorno.setStAtivo(rs.getByte("st_ativo"));
			retorno.setTpFolha(rs.getByte("tp_folha"));
		} catch (SQLException e){
			e.printStackTrace();
		}
		return retorno;
	}
	
	private DwEst instanciaDwEst(ResultSet rs){
		DwEst retorno = new DwEst();
		
		try{
			retorno.setIdEst(rs.getLong("id_est"));
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return retorno;
	}
}
