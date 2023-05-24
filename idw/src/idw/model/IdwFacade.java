package idw.model;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.Session;
import org.jfree.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import idw.model.dao.DAOGenerico;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.GtDesconhecidoException;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.PostoSemDadoException;
import idw.model.excessoes.PtDesconhecidoException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemConfiguracaoException;
import idw.model.excessoes.SemFeedersException;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.excessoes.TurnoDesconhecidoException;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwConsolallog;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwDesalimpendcontag;
import idw.model.pojos.DwDetativ;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhacic;
import idw.model.pojos.DwFolhamoncomp;
import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwProcedimento;
import idw.model.pojos.DwProreaativobs;
import idw.model.pojos.DwRota;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.DwRt;
import idw.model.pojos.DwTPerdamp;
import idw.model.pojos.DwTurno;
import idw.model.pojos.MsEvt;
import idw.model.pojos.MsUp;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmImg;
import idw.model.pojos.OmMapapa;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmRegrasNscb;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpNeccron;
import idw.model.pojos.TeTarifasemanal;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.pojos.template.MsTpevtTemplate;
import idw.model.rn.*;
import idw.model.rn.alimentacao.AlimentacaoRN;
import idw.model.rn.alimentacao.DesalimentacaoRN;
import idw.model.rn.alimentacao.MapaAlimentacaoRN;
import idw.model.rn.alimentacao.MapasDTO;
import idw.model.rn.alimentacao.MonitorizacaoAlimentacaoByReelRN;
import idw.model.rn.alimentacao.MonitorizacaoAlimentacaoRN;
import idw.model.rn.alimentacao.RealimentacaoDTO;
import idw.model.rn.alimentacao.ReelidDTO;
import idw.model.rn.alimentacao.RelatorioAlimentacaoRN;
import idw.model.rn.analiseturno.AnaliseTurnoRN;
import idw.model.rn.cargabasica.CargaBasicaRN;
import idw.model.rn.cc.CcRN;
import idw.model.rn.cc.CcsDTO;
import idw.model.rn.classificacaoabc.ClassificacaoABCRN;
import idw.model.rn.consolidacao.parada.CorrecaoParadaRN;
import idw.model.rn.consolidacao.refugo.ConsolidacaoRefugoRN;
import idw.model.rn.dashboard.DashboardFlexRN;
import idw.model.rn.db.ManipularChangeLogs;
import idw.model.rn.detalhemonitorizacao.DetalheGraficoBIParetoPerdasRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoGraficoAreaResponsavelRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoOPRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTAndroidRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTFornoRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.model.rn.detalhemonitorizacao.DetalhePTRN;
import idw.model.rn.detalhemonitorizacao.GraficoBIParetoPerdasRN;
import idw.model.rn.detalhemonitorizacao.GraficoPerdaMateriaPrimaRN;
import idw.model.rn.detalhemonitorizacao.GraficoRecorrenciaFactory;
import idw.model.rn.diariobordo.DiarioBordoDTO;
import idw.model.rn.diariobordo.DiarioBordoRN;
import idw.model.rn.diariobordo.DiariosBordoDTO;
import idw.model.rn.el.ConcessionariaRN;
import idw.model.rn.el.TipoConsumidorRN;
import idw.model.rn.estoque.EstoqueRN;
import idw.model.rn.estoque.LocalEstoqueDTO;
import idw.model.rn.estoque.LocalEstoquePaRN;
import idw.model.rn.estoque.LocalEstoqueRN;
import idw.model.rn.estoque.MovimentacaoLocalEstoque;
import idw.model.rn.estoque.TiposEstoqueDTO;
import idw.model.rn.folhainspecaorap.FiltroFolhaInspecaoRapDTO;
import idw.model.rn.folhainspecaorap.FolhaInspecaoRapRN;
import idw.model.rn.folhainspecaorap.FolhasInspecaoRapDTO;
import idw.model.rn.folhainspecaorap.QqInsRapDTO;
import idw.model.rn.impprog.ImportaProgramaRN;
import idw.model.rn.indicador.IndicadorRN;
import idw.model.rn.indicador.IndicadorValorDTO;
import idw.model.rn.injet.DiversosInjetRN;
import idw.model.rn.injet.MaquinaInjetRN;
import idw.model.rn.injet.PlanejamentoInjetRN;
import idw.model.rn.injet.dto.FiltroMaquinaInjetDTO;
import idw.model.rn.injet.dto.MaquinasInjetDTO;
import idw.model.rn.insert.EventoInsertParaMsEvtRN;
import idw.model.rn.integracao.erp.IntegracaoOPRN;
import idw.model.rn.integracao.erp.OpsIntegracaoDTO;
import idw.model.rn.integracao.ipackchem.IntegracaoIpackChemRN;
import idw.model.rn.integracao.ipackchem.dto.IpcOPDTO;
import idw.model.rn.integracao.ipackchem.dto.IpcOPRet;
import idw.model.rn.integracao.ipackchem.dto.IpcProDTO;
import idw.model.rn.integracao.ipackchem.dto.IpcProRet;
import idw.model.rn.integracao.semptoshiba.IntegracaoApontamentoDiario;
import idw.model.rn.integracao.semptoshiba.IntegracaoCM;
import idw.model.rn.integracao.semptoshiba.IntegracaoEstoque;
import idw.model.rn.integracao.semptoshiba.IntegracaoEstruturaProduto;
import idw.model.rn.integracao.semptoshiba.IntegracaoPlanoProducao;
import idw.model.rn.integracao.semptoshiba.trilha.ArquivosTrilhaDTO;
import idw.model.rn.integracao.semptoshiba.trilha.ExportacaoTrilha;
import idw.model.rn.integracao.semptoshiba.trilha.ImportacaoArquivoTrilhaPlanoProducao;
import idw.model.rn.joblog.FiltroPesquisaOmJobDTO;
import idw.model.rn.joblog.JobRN;
import idw.model.rn.joblog.ListaOmJobLogDTO;
import idw.model.rn.joblog.ListaOmJobdetLogDTO;
import idw.model.rn.leadtime.LeadTimeRN;
import idw.model.rn.mapaops.MapaOpsRN;
import idw.model.rn.monitorizacao.MonitorizacaoRN;
import idw.model.rn.monitorizacao.MonitorizacaoVisaoMaquinaAndroidRN;
import idw.model.rn.monitorizacao.MonitorizacaoVisaoMaquinaRN;
import idw.model.rn.monitorizacao.cep.MonitorizacaoCEPRN;
import idw.model.rn.monitorizacao.detalhes.GraficoParetoRefugoRN;
import idw.model.rn.monitorizacao.detalhes.GraficoParettoParadaRN;
import idw.model.rn.monitorizacao.detalhes.GraficoParettoRitmoRN;
import idw.model.rn.monitorizacao.detalhes.OcorrenciaParetoRefugoRN;
import idw.model.rn.monitorizacao.detalhes.OcorrenciaParettoDefeitoRN;
import idw.model.rn.monitorizacao.detalhes.OcorrenciaParettoLogVRotRN;
import idw.model.rn.monitorizacao.detalhes.OcorrenciaParettoParadaRN;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoDefeitosDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoLogVRotSDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParetoRefugosDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParettoParadaDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParettoRitmoDTO;
import idw.model.rn.monitorizacao.hierarquica.MonitorizacaoHierarquicaRN;
import idw.model.rn.monitorizacao.rastreamentons.RastreamentoNSRN;
import idw.model.rn.monitorizacao.roteiro.ListaOmObjDTO;
import idw.model.rn.monitorizacao.roteiro.MonitorizacaoVisaoRoteiroRN;
import idw.model.rn.monitorizacao.tv.DashboardRN;
import idw.model.rn.numeroserie.ValidaNumeroSerieRN;
import idw.model.rn.op.OpSimplesRN;
import idw.model.rn.pdba.AlertaPdbaMsEvtRN;
import idw.model.rn.pdba.CIPPdbaMsEvtRN;
import idw.model.rn.pdba.CausaAcaoJustPdbaMsEvtRN;
import idw.model.rn.pdba.ConsultaPdbaMsEvtRN;
import idw.model.rn.pdba.HeartBeatPdbaMsEvtRN;
import idw.model.rn.pdba.MaoDeObraPdbaMsEvtRN;
import idw.model.rn.pdba.ParadaPdbaMsEvtRN;
import idw.model.rn.pdba.ProducaoPdbaMsEvtRN;
import idw.model.rn.procedimento.GrupoAtivRN;
import idw.model.rn.procedimento.ProcedimentoRN;
import idw.model.rn.procedimento.ProcedimentoRealizadoRN;
import idw.model.rn.relatorios.R100.FiltroR100DTO;
import idw.model.rn.relatorios.R100.RelatorioR100DTO;
import idw.model.rn.relatorios.R100.RelatorioR100RN;
import idw.model.rn.relatorios.R101.FiltroR101DTO;
import idw.model.rn.relatorios.R101.RelatorioR101DTO;
import idw.model.rn.relatorios.R101.RelatorioR101RN;
import idw.model.rn.relatorios.cargamaquina.RelCargaMaquinaRN;
import idw.model.rn.relatorios.consolidados.FiltroRelatorioConsolidadosDTO;
import idw.model.rn.relatorios.consolidados.RelatorioConsolidadoDTO;
import idw.model.rn.relatorios.consolidados.RelatorioConsolidadosRN;
import idw.model.rn.relatorios.opprocessada.ListaRelatorioOPProcessadaDTO;
import idw.model.rn.relatorios.opprocessada.RelatorioOrdemProducaoProcessadaRN;
import idw.model.rn.relatorios.refugo.consolidado.FiltroRelatorioRefugoConsolidadoPorMoldeDTO;
import idw.model.rn.relatorios.refugo.consolidado.RelatorioRefugoConsolidadoPorMoldeDTO;
import idw.model.rn.relatorios.refugo.consolidado.RelatorioRefugoConsolidadoPorMoldeRN;
import idw.model.rn.roteiroinspecao.RoteiroInspecaoDTO;
import idw.model.rn.roteiroinspecao.RoteiroInspecaoRN;
import idw.model.rn.roteiroinspecao.RoteirosInspecaoDTO;
import idw.model.rn.tipoos.TipoOSRN;
import idw.model.rn.tipoos.TiposOSDTO;
import idw.model.rn.web.wm.ConsultasWebWmRN;
import idw.relatorio.analiseproducaoeficiencia.AnaliseProducaoEficienciaHoraAHoraRN;
import idw.relatorio.analiseproducaoeficiencia.ListaDTOAnaliseProducaoEficienciaHoraAHora;
import idw.relatorio.causasrefugo.FiltroRelatorioCausasDeRefugoDTO;
import idw.relatorio.causasrefugo.ListaRelatorioCausasDeRefugoDTO;
import idw.relatorio.causasrefugo.RelatorioCausasDeRefugoRN;
import idw.util.EmailDTO;
import idw.util.EnviarEmail;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.*;
import idw.webservices.rest.dto.CodigoDescricaoDTO;
import idw.webservices.rest.dto.DadosTempoRealDTO;
import idw.webservices.rest.dto.dashboard.flex.DashboardFlexDTO;
import idw.webservices.rest.dto.iawm.AnalisesGtIADTO;
import injetws.model.excessoes.FalhaSnapshot;
import injetws.model.excessoes.FalhaSnapshotException;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsAlertaDTO;
import injetws.webservices.dto.IwsAutenticacaoDTO;
import injetws.webservices.dto.IwsCicloDTO;
import injetws.webservices.dto.IwsConsultaDTO;
import injetws.webservices.dto.IwsCpDTO;
import injetws.webservices.dto.IwsDadosApontamentoDTO;
import injetws.webservices.dto.IwsErroDTO;
import injetws.webservices.dto.IwsHorarioDTO;
import injetws.webservices.dto.IwsListaAlertaDTO;
import injetws.webservices.dto.IwsListaUpDTO;
import injetws.webservices.dto.IwsParadaDTO;
import injetws.webservices.dto.IwsRefugoDTO;
import injetws.webservices.dto.IwsRegistroBarCodeDTO;
import injetws.webservices.dto.IwsReleDTO;
import ms.coleta.dto.ColetaParametroDTO;
import ms.coleta.ic.drivercoleta.PararDeProcessarArquivoSemSalvarLinhaException;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
import ms.model.dto.ListaMSDTO;
import ms.model.dto.MsDTO;
import ms.model.rn.EventoRN;
import ms.model.rn.MsRN;
import ms.model.rn.UpRN;
import ms.model.rn.aoi.EventoAOIDTO;
import ms.model.rn.aoi.EventosAOIRN;

public class IdwFacade extends DAOGenerico {

	public static boolean IS_IDW_ATIVO;
	public static int TEMPO_EM_SEGUNDOS_REFRESH_MATERIALIZED_VIEW_BI;

	private static IdwFacade instancia = null;

	// Alterar para true ou false para salvar no banco desejado
	private boolean isConsolidarParaInsert = false;
	private boolean isConsolidarParaIDW = true;
	private boolean isIDWAtivo = false;
	

	/** MASCARAS */
	private String mascaraProduto = "??????";

	private String versaoMobile = "1.15";

	private Date horaServidorBanco;
	private Date horaLocalCapturaServidorBanco;

	private Boolean isRitmosempreNasHrsprod = false;
	
	// Ricardo: 06/03/2023
	public boolean isSimuladorLigado = false;
	
	private IdwFacade() {
		// Na criacao da instancia carregar as configuracoes do omcfg que nao
		// sofrem muitas mudancas.
		// Se essas configuracoes forem modificadas no banco, sera necessario
		// reiniciar o servidor do tomcat
		Session oSession = iniciaSessao();
		OmCfg omcfg = Util.getConfigGeral(oSession);

		if (omcfg != null) {
			if (omcfg.getIsProcessaiacidw() != null)
				this.isConsolidarParaIDW = omcfg.getIsProcessaiacidw();

			if (omcfg.getIsProcessaiacinsert() != null)
				this.isConsolidarParaInsert = omcfg.getIsProcessaiacinsert();

			if (omcfg.getMascaracdprodutoCB() != null)
				this.mascaraProduto = omcfg.getMascaracdprodutoCB();

			if (omcfg.getIsRitmosempreNasHrsprod() != null)
				this.isRitmosempreNasHrsprod = omcfg.getIsRitmosempreNasHrsprod();
		}
		commitaTransacao(oSession);
	}

	public static IdwFacade getInstancia() {
		if (instancia == null) {
			instancia = new IdwFacade();
		}

		return instancia;
	}

	public ChangeLogsBDDTO getChangeLogsBDNaoExecutados() {
		ChangeLogsBDDTO changeLogsBDDTO = new ChangeLogsBDDTO();
		try {
			ManipularChangeLogs m = new ManipularChangeLogs();
			changeLogsBDDTO = m.listarChangeLogsNaoExecutados();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return changeLogsBDDTO;
	}

	public ChangeLogsBDDTO getChangeLogsBDExecutados() {
		ChangeLogsBDDTO changeLogsBDDTO = new ChangeLogsBDDTO();
		try {
			ManipularChangeLogs m = new ManipularChangeLogs();
			changeLogsBDDTO = m.listarChangeLogsExecutados();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return changeLogsBDDTO;
	}

	public boolean executarChangeLogBD(ChangeLogBDDTO changeLogBDDTO) {
		boolean aceito = false;
		try {
			ManipularChangeLogs m = new ManipularChangeLogs();
			aceito = m.rodarChangeLog(changeLogBDDTO.getChangeLog());
		} catch (Exception e) {
			aceito = false;
			e.printStackTrace();
		}
		return aceito;
	}

	public UsuarioDTO setUsuarioDTO(UsuarioDTO usuario) {
		UsuarioRN rn = new UsuarioRN();
		UsuarioDTO retorno;
		try {
			retorno = new UsuarioDTO();
			rn.iniciaConexaoBanco();
			retorno = rn.setUsuarioDTO(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new UsuarioDTO();
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public UsuariosDTO getUsuariosDTO(UsuarioDTO usuario) {
		UsuarioRN rn = new UsuarioRN();
		UsuariosDTO usuarios;
		try {
			rn.iniciaConexaoBanco();
			usuarios = rn.getUsuariosDTO(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			usuarios = new UsuariosDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return usuarios;
	}
	public UsuariosDTO getUsuariosDTO(String variavel) {
		UsuarioRN rn = new UsuarioRN();
		UsuariosDTO usuarios;
		try {
			rn.iniciaConexaoBanco();
			usuarios = rn.getUsuariosDTO(variavel);
		} catch (Exception e) {
			e.printStackTrace();
			usuarios = new UsuariosDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return usuarios;
	}

	public UsuariosDTO removeUsuariosDTO(UsuariosDTO usuarios) {
		UsuarioRN rn = new UsuarioRN();
		UsuariosDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeUsuariosDTO(usuarios);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public UsuarioDTO ativaUsuarioDTO(UsuarioDTO usuario) {
		UsuarioRN rn = new UsuarioRN();
		UsuarioDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.ativaUsuarioDTO(usuario);
			;
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new UsuarioDTO();
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public UsuarioDTO isUsuarioAutenticado(UsuarioDTO usuario) {
		UsuarioRN rn = new UsuarioRN();
		UsuarioDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.isUsuarioAutenticado(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.rollbackTransacao();
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public UsuariosDTO getUsuarios() {
		UsuarioRN rn = new UsuarioRN();
		UsuariosDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getUsuariosSMED();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.rollbackTransacao();
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public UsuarioDTO getUsuarioDTO(UsuarioDTO usuario) {
		UsuarioRN rn = null;
		Session sessao = null;
		UsuarioDTO usuarioRetorno = null;
		try {
			rn = new UsuarioRN();
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			usuarioRetorno = rn.getUsuarioDTO(usuario);
		} catch (Exception e) {
			rollbackTransacao(sessao);
		} finally {
			if (sessao != null) {
				commitaTransacao(sessao);
			}
		}
		return usuarioRetorno;
	}

	public PesquisasDTO pesquisaTurno(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaTurno(filtro);
		} catch (Exception e) {
			retorno = new PesquisasDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwFolha(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwFolha(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwFolhaTesteFuncional(PesquisaDTO pesquisa) {
		DiversosRN rn = new DiversosRN();
		Session sessao = null;
		PesquisasDTO usuarioRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			usuarioRetorno = rn.pesquisaDwFolhaTesteFuncional(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null) {
				commitaTransacao(sessao);
			}
		}
		rn = null;
		return usuarioRetorno;
	}

	public PesquisasDTO pesquisaDwEst(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwEst(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwEstlocal(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwEstlocal(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwEstlocalDesalimentacao(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwEstlocalDesalimentacao(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwCal(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwCal(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwMacrangePAI(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwMacrangePAI(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwFtParam(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwFtParam(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwTAlerta(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwTAlerta(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwTRefugo(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwTRefugo(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaPpCp(PesquisaDTO filtro) {
		LeadTimeRN rn = new LeadTimeRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaPpCp(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaPpCpProduto(PesquisaDTO filtro, String cdOp) {
		LeadTimeRN rn = new LeadTimeRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaPpCpProduto(filtro, cdOp);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaDwPassagemDTO getListaLeadTime(String op, String pt, String produto, Date data1, Date data2) {
		LeadTimeRN rn = new LeadTimeRN();
		ListaDwPassagemDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getListaLeadTime(op, pt, produto, data1, data2);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public PesquisasDTO pesquisaDwPepro(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwPepro(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaGrupoProduto(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaGrupoProduto(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmgrpusr(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmgrpusr(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmcc(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmcc(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmusr(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmusr(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmresgui(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmresgui(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmimg(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmimg(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public OmImg pesquisaOmimgLikeUrl(String url) {
		DiversosRN rn = new DiversosRN();
		Session sessao = null;
		OmImg retorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			retorno = rn.pesquisarOmimgLikeUrl(url);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmgt(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmgt(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmGtPorTp(PesquisaDTO filtro, Long idTpGt) {
		GTRN rn = new GTRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmGtPorTp(filtro, idTpGt);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public Boolean verificaOmGtVazio(Long idGt) {
		GTRN rn = new GTRN();
		Boolean retorno = false;

		try {
			rn.iniciaConexaoBanco();
			retorno = rn.verificaOmGtVazio(idGt);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwTCausa(PesquisaDTO filtro) {
		CausaRN rn = new CausaRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwTCausa(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwTAcao(PesquisaDTO filtro) {
		TAcaoRN rn = new TAcaoRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwTAcao(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwTDefeito(PesquisaDTO filtro) {
		TDefeitoRN rn = new TDefeitoRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwTDefeito(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwTJust(PesquisaDTO filtro) {
		JustificativaRN rn = new JustificativaRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwTJust(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwTOrigem(PesquisaDTO filtro) {
		OrigemRN rn = new OrigemRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwTOrigem(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmCargo(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmCargo(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwGrpativ(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwGrpativ(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public GtDTO getOmGtPorIdOuCd(OmGt filtro) {
		GTRN rn = new GTRN();
		GtDTO retorno = new GtDTO();
		try {
			rn.iniciaConexaoBanco();
			OmGt gt = rn.getOmGtPorIdOuCd(filtro).getGt();
			if (gt != null) {
				gt = gt.clone(false);
				retorno.setGt(gt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmEstoque(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmEstoque(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public MaquinasInjetDTO getIndicadoresInjet(FiltroMaquinaInjetDTO filtro) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		dao.iniciaConexaoBanco();
		MaquinaInjetRN rn = new MaquinaInjetRN(dao);
		MaquinasInjetDTO retorno = new MaquinasInjetDTO();
		try {
			retorno = rn.analisarMaquinas(filtro);
		} catch (injetws.model.excessoes.RegistroDesconhecidoException e) {
			e.printStackTrace();
		} finally {
			dao.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmgtFabrica(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmgtFabrica(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmtpgt(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmtpgt(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmGtFase(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmGtFase(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public GTsDTO pesquisaOmGtFase(String variavel) {
		DiversosRN rn = new DiversosRN();
		GTsDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmGtFase(variavel);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new GTsDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmtppt(PesquisaDTO pesquisa) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO usuarioRetorno;
		try {
			rn.iniciaConexaoBanco();
			usuarioRetorno = rn.pesquisaOmtppt(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
			usuarioRetorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return usuarioRetorno;
	}

	public PesquisasDTO pesquisaOmAlgocor(PesquisaDTO pesquisa) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO usuarioRetorno;
		try {
			rn.iniciaConexaoBanco();
			usuarioRetorno = rn.pesquisaOmAlgocor(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
			usuarioRetorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return usuarioRetorno;
	}

	public PesquisasDTO pesquisaArea(PesquisaDTO pesquisa) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaArea(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwTParada(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwTParada(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwTParada_2(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwTParada(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmprodutoFinal(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmprodutoFinal(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmprodutoEmbalagem(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmprodutoEmbalagem(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmprodutoFinalSemiAcabado(PesquisaDTO filtro) {
		ProdutoRN rn = new ProdutoRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOmProdutosFinaisESemiAcabados(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmprodutoFinalDaRota(PesquisaDTO filtro) {
		ProdutoRN rn = new ProdutoRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOmProdutoFinalAtivo(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaPedido(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaPedido(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmprodutoTodosTp(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmprodutoTodosTp(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOp(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOp(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public boolean getProdutoByCdEStAtivo(String cdProduto) {
		ProdutoRN rn = new ProdutoRN();
		boolean existe = false;
		Session sessao = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			OmProduto usuarioRetorno = rn.getProdutoByCdEStAtivo(cdProduto);
			if (usuarioRetorno != null)
				existe = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return existe;
	}

	public PesquisasDTO pesquisaOmprodutoComponente(PesquisaDTO filtro) {
		ProdutoRN rn = new ProdutoRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmprodutoComponente(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmprodutoSemiacabado(PesquisaDTO filtro) {
		ProdutoRN rn = new ProdutoRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmprodutoSemiacabado(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ProdutosDTO pesquisarProdutosFinaisNoTurno(Date dtReferencia, String cdTurno) {
		ProdutoRN rn = new ProdutoRN();
		ProdutosDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarProdutosFinaisNoTurno(dtReferencia, cdTurno);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ProdutosDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmprodutoExcessaoProdutoFinal(PesquisaDTO filtro) {
		ProdutoRN rn = new ProdutoRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmprodutoExcessaoProdutoFinal(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwRap(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno = new PesquisasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwRap(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwGrupoFerramenta(PesquisaDTO filtro) {
		GrupoFerramentaRN rn = new GrupoFerramentaRN();
		PesquisasDTO retorno = new PesquisasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwGrupoFerramenta(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaProgramaIAC(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO usuarioRetorno;
		try {
			rn.iniciaConexaoBanco();
			usuarioRetorno = rn.pesquisaProgramaIAC(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			usuarioRetorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return usuarioRetorno;
	}

	public PesquisasDTO pesquisaProdutoIAC(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO usuarioRetorno;
		try {
			rn.iniciaConexaoBanco();
			usuarioRetorno = rn.pesquisaProdutoIAC(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			usuarioRetorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return usuarioRetorno;
	}

	public PesquisasDTO pesquisaOmprodutoComponenteComAgrupador(PesquisaDTO filtro) {
		ProdutoRN rn = new ProdutoRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmprodutoComponenteComAgrupador(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmprodutoAgrupador(PesquisaDTO filtro) {
		ProdutoRN rn = new ProdutoRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmprodutoAgrupador(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmprodutoNaFolha(PesquisaDTO filtro) {
		ProdutoRN rn = new ProdutoRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmprodutoNaFolha(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmfornecedor(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmfornecedor(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmprg(OmPt pt, PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmprg(pt, filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmpa(OmPt pt, PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmpa(pt, filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmpt(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmpt(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwprocedimento(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwprocedimento(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmmapa(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmmapa(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaOmcfgscrpimp(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaOmcfgscrpimp(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaTeConcessionaria(PesquisaDTO filtro) {
		ConcessionariaRN rn = new ConcessionariaRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaTeConcessionaria(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaTeTipoConsumidor(PesquisaDTO filtro) {
		TipoConsumidorRN rn = new TipoConsumidorRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaTeTipoConsumidor(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaTeLei(PesquisaDTO filtro) {
		LeiVigenteRN rn = new LeiVigenteRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaTeLei(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public GrupoUsuariosDTO getGrupoUsuariosDTO(GrupoUsuarioDTO usuario) {
		GrupoUsuarioRN rn = new GrupoUsuarioRN();
		GrupoUsuariosDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGrupoUsuariosDTO(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new GrupoUsuariosDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public GrupoUsuarioDTO setGrupoUsuarioDTO(GrupoUsuarioDTO usrGrp) {
		GrupoUsuarioRN rn = new GrupoUsuarioRN();
		GrupoUsuarioDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setGrupoUsuarioDTO(usrGrp);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new GrupoUsuarioDTO();
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
			rn.rollbackTransacao();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public GrupoUsuariosDTO removeGrupoUsuariosDTO(GrupoUsuariosDTO grupoUsuariosDTO) {
		GrupoUsuarioRN rn = new GrupoUsuarioRN();
		GrupoUsuariosDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeGrupoUsuariosDTO(grupoUsuariosDTO);
		} catch (Exception e) {
			e.printStackTrace();
			rn.rollbackTransacao();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public GrupoUsuarioDTO ativaGrupoUsuarioDTO(GrupoUsuarioDTO usuario) {
		GrupoUsuarioRN rn = new GrupoUsuarioRN();
		GrupoUsuarioDTO usuarioRetorno;
		try {
			rn.iniciaConexaoBanco();
			usuarioRetorno = rn.ativaGrupoUsuarioDTO(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			usuarioRetorno = new GrupoUsuarioDTO();
			rn.rollbackTransacao();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return usuarioRetorno;
	}

	public DireitoAcessoDTO validarRecursoGUI(DireitoAcessoDTO direitoAcesso) {
		GrupoUsuarioRN rn = new GrupoUsuarioRN();
		DireitoAcessoDTO usuarioRetorno;
		try {
			rn.iniciaConexaoBanco();
			usuarioRetorno = rn.validarRecursoGUI(direitoAcesso);
		} catch (Exception e) {
			e.printStackTrace();
			usuarioRetorno = new DireitoAcessoDTO();
			usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_RESGUI_INVALIDO());
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return usuarioRetorno;
	}

	public GTsDTO getGTsDTO(GtDTO gt) {
		GTRN rn = new GTRN();
		GTsDTO gts = null;
		try {
			rn.iniciaConexaoBanco();
			gts = rn.getGTsDTO(gt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return gts;
	}

	public MonitorizacaoHierarquicaDTO getGtsHieraquico(OmGt gt) {
		MonitorizacaoHierarquicaRN rn = new MonitorizacaoHierarquicaRN();
		MonitorizacaoHierarquicaDTO gts;
		try {
			rn.iniciaConexaoBanco();
			gts = rn.getLayoutMonitorizacaoHierarquicaDTO(gt);
		} catch (Exception e) {
			e.printStackTrace();
			gts = new MonitorizacaoHierarquicaDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return gts;
	}

	public GTsDTO getGTsComLayoutDTO(GtDTO gt) {
		GTRN rn = new GTRN();
		GTsDTO gts = null;
		try {
			rn.iniciaConexaoBanco();
			gts = rn.getGTsComLayoutDTO(gt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return gts;
	}

	public GtDTO setGTDTO(GtDTO gt) {
		GtDTO gtRetorno = new GtDTO();
		gtRetorno.setResultadoEvento(gtRetorno.getERRO_DESCONHECIDO());
		GTRN rn = new GTRN();
		try {
			rn.iniciaConexaoBanco();
			gtRetorno = rn.setGTDTO(gt);
		} catch (Exception e) {
			e.printStackTrace();
			if (gtRetorno.getResultadoEvento() == gtRetorno.getEVENTO_BEM_SUCEDIDO()) {
				gtRetorno.setResultadoEvento(gtRetorno.getERRO_DESCONHECIDO());
			}
		} finally {
			if (gtRetorno.getResultadoEvento() != gtRetorno.getEVENTO_BEM_SUCEDIDO()) {
				rn.rollBackTransacao();
			}
			rn.finalizaConexaoBanco();
		}
		return gtRetorno;
	}

	public GTsDTO removeGTsDTO(GTsDTO gts) {
		GTRN rn = new GTRN();
		GTsDTO gtsRetorno = new GTsDTO();
		gtsRetorno.setGts(new ArrayList<GtDTO>());
		try {
			rn.iniciaConexaoBanco();
			gtsRetorno = rn.removeGTsDTO(gts);
		} catch (Exception e) {
			e.printStackTrace();
			rn.rollBackTransacao();
			GtDTO dto = new GtDTO();
			dto.setResultadoEvento(dto.getERRO_DESCONHECIDO());
			gtsRetorno.getGts().add(dto);
		} finally {
			for (GtDTO dto : gtsRetorno.getGts()) {
				if (dto.getResultadoEvento() != dto.getEVENTO_BEM_SUCEDIDO()) {
					rn.rollBackTransacao();
					break;
				}
			}
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return gtsRetorno;
	}

	public GtDTO ativaGTDTO(GtDTO gt) {
		GTRN rn = new GTRN();
		GtDTO gtRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			gtRetorno = rn.ativaGTDTO(gt);
		} catch (Exception e) {
			e.printStackTrace();
			rn.rollBackTransacao();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return gtRetorno;
	}

	public ProdutosDTO getProdutosDTO(ProdutoDTO pesquisa) {
		ProdutoRN rn = new ProdutoRN();
		ProdutosDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getProdutosDTO(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ProdutosDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ProdutoDTO setProdutoDTO(ProdutoDTO pesquisa) {
		ProdutoRN rn = new ProdutoRN();
		ProdutoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setProdutoDTO(pesquisa);
		} catch (Exception e) {
			retorno = new ProdutoDTO();
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
			e.printStackTrace();
			rn.rollbackTransacao();
		} finally {
			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				rn.rollbackTransacao();
			}
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ProdutoDTO salvarProdutosComBanco(ProdutoDTO produtodto) {
		ProdutoRN rn = new ProdutoRN();
		ProdutoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.salvarProdutosComBanco(produtodto);
		} catch (Exception e) {
			retorno = new ProdutoDTO();
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
			e.printStackTrace();
			rn.rollbackTransacao();
		} finally {
			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				rn.rollbackTransacao();
			}
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ProdutosDTO removeProdutosDTO(ProdutosDTO pesquisa) {
		ProdutoRN rn = new ProdutoRN();
		ProdutosDTO retorno = new ProdutosDTO();
		retorno.setProdutos(new ArrayList<ProdutoDTO>());
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeProdutosDTO(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
			ProdutoDTO dto = new ProdutoDTO();
			dto.setResultadoEvento(dto.getERRO_DESCONHECIDO());
		} finally {
			for (ProdutoDTO dto : retorno.getProdutos()) {
				if (dto.getResultadoEvento() != dto.getEVENTO_BEM_SUCEDIDO()) {
					rn.rollbackTransacao();
					break;
				}
			}
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ProdutoDTO ativaProdutoDTO(ProdutoDTO pesquisa) {
		ProdutoRN rn = new ProdutoRN();
		ProdutoDTO retorno = new ProdutoDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.ativaProdutoDTO(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
		} finally {
			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				rn.rollbackTransacao();
			}
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public void setAtualizacaoDwconsolallog(Long idConsolallog, String obs, long idUsr) {
		DiversosRN rn = new DiversosRN();
		try {
			rn.iniciaConexaoBanco();
			rn.setAlteracaoDwConsolallog(idConsolallog, obs, idUsr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
	}

	public FornecedoresDTO getFornecedoresDTO(FornecedorDTO filtro) {
		FornecedorRN rn = new FornecedorRN();
		FornecedoresDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getFornecedoresDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new FornecedoresDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public FornecedorDTO setFornecedorDTO(FornecedorDTO fornecedor) {
		FornecedorRN rn = new FornecedorRN();
		FornecedorDTO fornecedorRetorno = new FornecedorDTO();
		try {
			rn.iniciaConexaoBanco();
			fornecedorRetorno = rn.setFornecedorDTO(fornecedor);
		} catch (Exception e) {
			e.printStackTrace();
			fornecedorRetorno.setResultadoEvento(fornecedorRetorno.getERRO_DESCONHECIDO());
		} finally {
			if (fornecedorRetorno.getResultadoEvento() != fornecedorRetorno.getEVENTO_BEM_SUCEDIDO()) {
				rn.rollBackTransacao();
			}
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return fornecedorRetorno;
	}

	public FornecedoresDTO removeFornecedoresDTO(FornecedoresDTO fornecedors) {
		FornecedorRN rn = new FornecedorRN();
		FornecedoresDTO retorno = new FornecedoresDTO();
		retorno.setFornecedores(new ArrayList<FornecedorDTO>());
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeFornecedoresDTO(fornecedors);
		} catch (Exception e) {
			e.printStackTrace();
			FornecedorDTO dto = new FornecedorDTO();
			dto.setResultadoEvento(dto.getERRO_DESCONHECIDO());
		} finally {
			for (FornecedorDTO dto : retorno.getFornecedores()) {
				if (dto.getResultadoEvento() != dto.getEVENTO_BEM_SUCEDIDO()) {
					rn.rollBackTransacao();
					break;
				}
			}
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public FornecedorDTO ativaFornecedorDTO(FornecedorDTO fornecedor) {
		FornecedorRN rn = new FornecedorRN();
		FornecedorDTO retorno = new FornecedorDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.ativaFornecedorDTO(fornecedor);
		} catch (Exception e) {
			e.printStackTrace();
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
		} finally {
			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				rn.rollBackTransacao();
			}
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PTsDTO getPTsDTO(PtDTO pt) {
		PTRN rn = new PTRN();
		PTsDTO pts;
		try {
			rn.iniciaConexaoBanco();
			pts = rn.getPtsDTO(pt);
		} catch (Exception e) {
			pts = new PTsDTO();
			pts.setPts(new ArrayList<PtDTO>());
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return pts;
	}

	public PTsDTO getPtsDTOSemClonarFilhos(PtDTO pt) {
		PTRN rn = new PTRN();
		PTsDTO pts;
		try {
			rn.iniciaConexaoBanco();
			pts = rn.getPtsDTOSemClonarFilhos(pt);
		} catch (Exception e) {
			pts = new PTsDTO();
			pts.setPts(new ArrayList<PtDTO>());
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return pts;
	}

	public PTsDTO getAndroidPTsDTO() {
		PTRN rn = new PTRN();
		Session sessao = null;
		PTsDTO pts = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			pts = rn.getPtsDTO(new PtDTO());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return pts;
	}

	public PtImgMonitorizacaoDTO getImgsPTsDTO() {
		MonitorizacaoRN rn = new MonitorizacaoRN();
		PtImgMonitorizacaoDTO resultado = null;
		try {
			rn.iniciaConexaoBanco();
			resultado = rn.getImgsPTsDTO();
		} catch (Exception e) {
			e.printStackTrace();
			resultado = new PtImgMonitorizacaoDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return resultado;
	}

	public ObjsLayoutRoteiroDTO getObjsLayoutRoteiroDTO() {
		MonitorizacaoRoteiroRN rn = new MonitorizacaoRoteiroRN();
		ObjsLayoutRoteiroDTO resultado = null;
		try {
			rn.iniciaConexaoBanco();
			resultado = rn.getObjsLayoutRoteiroDTO();
		} catch (Exception e) {
			e.printStackTrace();
			resultado = new ObjsLayoutRoteiroDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return resultado;
	}

	public GtImgMonitorizacaoDTO getImgsGTsDTO() {
		MonitorizacaoRN rn = new MonitorizacaoRN();
		GtImgMonitorizacaoDTO resultado = null;
		try {
			rn.iniciaConexaoBanco();
			resultado = rn.getImgsGTsDTO();
		} catch (Exception e) {
			e.printStackTrace();
			resultado = new GtImgMonitorizacaoDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return resultado;
	}

	public PTsDTO getPTsDeGtDTO(PtDTO pt) {
		PTRN rn = new PTRN();
		Session sessao = null;
		PTsDTO pts = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			pts = rn.getPtsDeGtDTO(pt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return pts;
	}

	public PtDTO setPtDTO(PtDTO pt) {
		PTRN rn = new PTRN();
		PtDTO ptRetorno = new PtDTO();
		ptRetorno.setResultadoEvento(ptRetorno.getERRO_DESCONHECIDO());
		try {
			rn.iniciaConexaoBanco();
			ptRetorno = rn.setPtDTO(pt);
		} catch (Exception e) {
			e.printStackTrace();
			if (ptRetorno.getResultadoEvento() == ptRetorno.getEVENTO_BEM_SUCEDIDO()) {
				ptRetorno.setResultadoEvento(ptRetorno.getERRO_DESCONHECIDO());
			}
		} finally {
			if (ptRetorno.getResultadoEvento() == ptRetorno.getEVENTO_BEM_SUCEDIDO()) {
				rn.getDao().finalizaConexaoBancoSemException();
			} else {
				rn.getDao().rollBackTransacaoSemException();
			}
			rn.getDao().finalizaSessaoSemException();
		}
		return ptRetorno;
	}

	public PTsDTO removePTsDTO(PTsDTO pts) {
		PTRN rn = new PTRN();
		PTsDTO ptsRetorno = new PTsDTO();
		ptsRetorno.setPts(new ArrayList<PtDTO>());
		try {
			rn.iniciaConexaoBanco();
			ptsRetorno = rn.removePTsDTO(pts);
		} catch (Exception e) {
			e.printStackTrace();
			PtDTO dto = new PtDTO();
			dto.setResultadoEvento(dto.getERRO_DESCONHECIDO());
			ptsRetorno.getPts().add(dto);
		} finally {
			for (PtDTO dto : ptsRetorno.getPts()) {
				if (dto.getResultadoEvento() != dto.getEVENTO_BEM_SUCEDIDO()) {
					rn.rollbackTransacao();
					break;
				}
			}
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return ptsRetorno;
	}

	public PtDTO ativaPtDTO(PtDTO pt) {
		PTRN rn = new PTRN();
		PtDTO ptRetorno = new PtDTO();
		try {
			rn.iniciaConexaoBanco();
			ptRetorno = rn.ativaPtDTO(pt);
		} catch (Exception e) {
			e.printStackTrace();
			ptRetorno.setResultadoEvento(ptRetorno.getERRO_DESCONHECIDO());
		} finally {
			if (ptRetorno.getResultadoEvento() != ptRetorno.getEVENTO_BEM_SUCEDIDO()) {
				rn.rollbackTransacao();
			}
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return ptRetorno;
	}

	public void importaPrograma() {
		ImportaProgramaRN rn = new ImportaProgramaRN();
		Session sessao = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			rn.importaProgramasInsersoras();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
	}

	public PaDTO validarPaDTO(PaDTO pa) {
		PTRN rn = new PTRN();
		Session sessao = null;
		PaDTO ptRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			ptRetorno = rn.validarPaDTO(pa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		commitaTransacao(sessao);
		rn = null;
		return ptRetorno;
	}

	public PAsDTO geracaoAutomaticaPA(PtDTO pt, WizPaDTO wizPa, Integer tipoAlgoritmo) {
		PTRN rn = new PTRN();
		Session sessao = null;
		PAsDTO pasRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			pasRetorno = rn.geracaoAutomaticaPA(pt, wizPa, tipoAlgoritmo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return pasRetorno;
	}

	public MapasAlimentacaoDTO getMapasAlimentacaoDTO(MapaAlimentacaoDTO mapa) {
		MapaAlimentacaoRN rn = new MapaAlimentacaoRN();
		Session sessao = null;
		MapasAlimentacaoDTO mapas = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			mapas = rn.getMapasAlimentacaoDTO(mapa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return mapas;
	}

	public MapaAlimentacaoDTO setMapaAlimentacaoDTO(MapaAlimentacaoDTO mapa) {
		MapaAlimentacaoRN rn = new MapaAlimentacaoRN();
		Session sessao = null;
		MapaAlimentacaoDTO mapaRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			mapaRetorno = rn.setMapaAlimentacaoDTO(mapa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return mapaRetorno;
	}

	public MapasAlimentacaoDTO removeMapasAlimentacaoDTO(MapasAlimentacaoDTO mapas) {
		MapaAlimentacaoRN rn = new MapaAlimentacaoRN();
		Session sessao = null;
		MapasAlimentacaoDTO mapasRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			mapasRetorno = rn.removeMapasAlimentacaoDTO(mapas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return mapasRetorno;
	}

	public MapaAlimentacaoDTO ativaMapaAlimentacaoDTO(MapaAlimentacaoDTO mapa) {
		MapaAlimentacaoRN rn = new MapaAlimentacaoRN();
		Session sessao = null;
		MapaAlimentacaoDTO mapaRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			mapaRetorno = rn.ativaMapaAlimentacaoDTO(mapa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return mapaRetorno;
	}

	public MapaPaDTO validarMapaPaDTO(MapaPaDTO mapaPa) {
		MapaAlimentacaoRN rn = new MapaAlimentacaoRN();
		Session sessao = null;
		MapaPaDTO mapaPaRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			mapaPaRetorno = rn.validarMapaPaDTO(mapaPa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return mapaPaRetorno;
	}

	public AlimentacoesDTO getAlimentacoesDTO(AlimentacaoDTO alimentacao) {
		AlimentacaoRN rn = new AlimentacaoRN();
		AlimentacoesDTO alimentacoes = null;
		try {
			rn.iniciaConexaoBanco();
			alimentacoes = rn.getAlimentacoesDTO(alimentacao);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return alimentacoes;
	}

	public RelAbastecimentoComponentesDTO getRelAbastecimentoComponentes(Integer idAlimentacao) {
		RelatoriosRN rn = new RelatoriosRN();
		Session sessao = null;
		RelAbastecimentoComponentesDTO relatorio = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			relatorio = rn.getRelAbastecimentoComponentes(idAlimentacao);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return relatorio;
	}

	public ProdutosDTO getRelProdutosSemDePara() {
		RelatoriosRN rn = new RelatoriosRN();
		Session sessao = null;
		ProdutosDTO relatorio = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			relatorio = rn.getRelProdutosSemDePara();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		commitaTransacao(sessao);
		rn = null;
		return relatorio;
	}

	public EtiquetasDTO getEtiquetas(ProdutosDTO produtos, String script) {
		DiversosRN rn = new DiversosRN();
		Session sessao = null;
		EtiquetasDTO etiquetas = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			etiquetas = rn.getEtiquetas(produtos, script);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return etiquetas;
	}

	public EtiquetasDTO getEtiquetas(MapasAlimentacaoDTO mapas, String script) {
		DiversosRN rn = new DiversosRN();
		Session sessao = null;
		EtiquetasDTO etiquetas = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			etiquetas = rn.getEtiquetas(mapas, script);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return etiquetas;
	}

	public EtiquetasDTO getEtiquetas(PTsDTO pts, String script) {
		DiversosRN rn = new DiversosRN();
		Session sessao = null;
		EtiquetasDTO etiquetas = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			etiquetas = rn.getEtiquetas(pts, script);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return etiquetas;
	}

	public EtiquetasDTO getEtiquetas(PAsDTO pas, String script) {
		DiversosRN rn = new DiversosRN();
		Session sessao = null;
		EtiquetasDTO etiquetas = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			etiquetas = rn.getEtiquetas(pas, script);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return etiquetas;
	}

	public ComponentesDeParaDTO importarComponentesDePara(ComponentesDeParaDTO componentes) {
		ProdutoRN rn = new ProdutoRN();
		ComponentesDeParaDTO componentesRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			componentesRetorno = rn.importarComponentesDePara(componentes);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return componentesRetorno;
	}

	public void importarPrograma(String arquivo, String conteudoArquivo, boolean isForcarImportacao) {
		ImportaProgramaRN rn = new ImportaProgramaRN();
		try {
			rn.iniciaConexaoBanco();
			rn.importarArquivo(arquivo, conteudoArquivo, isForcarImportacao);

		} catch (Exception e) {
			e.printStackTrace();
			rn.rollbackTransacao();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
	}

	public void importarProgramaConteudoBase64(String arquivo, String conteudoArquivo, boolean isForcarImportacao) throws FalhaSnapshot {
		ImportaProgramaRN rn = new ImportaProgramaRN();
		try {
			rn.iniciaConexaoBanco();
			rn.importarArquivo(arquivo, Base64.decodeBase64(conteudoArquivo), isForcarImportacao);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FalhaSnapshot(e.getMessage(), new FalhaSnapshotException());
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
	}

	public UsuarioCODTO getUsuarioCODTO(String matricula) {
		UsuarioRN rn = new UsuarioRN();
		Session sessao = null;
		UsuarioCODTO usuario = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			usuario = rn.getUsuarioCODTO(matricula);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return usuario;
	}

	public UsuarioCODTO isUsuarioAutorizadoLiberarCF(String matricula) {
		UsuarioRN rn = new UsuarioRN();
		Session sessao = null;
		UsuarioCODTO usuario = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			usuario = rn.isUsuarioAutorizadoLiberarCF(matricula);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return usuario;
	}

	public MapasCODTO getMapasCODTO(String maquina) {
		MapaAlimentacaoRN rn = new MapaAlimentacaoRN();
		Session sessao = null;
		MapasCODTO mapas = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			mapas = rn.getMapasCODTO(maquina);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return mapas;
	}

	public boolean isMapaValido(String maquina, String mapa) {
		MapaAlimentacaoRN rn = new MapaAlimentacaoRN();
		Session sessao = null;
		boolean isMapaValido = false;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			isMapaValido = rn.isMapaValido(maquina, mapa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return isMapaValido;
	}

	public PosicoesCODTO getPosicoesCODTO(String maquina, String mapa, Boolean isUsarEspelhamento) {
		MapaAlimentacaoRN rn = new MapaAlimentacaoRN();
		Session sessao = null;
		PosicoesCODTO posicoes = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			posicoes = rn.getPosicoesCODTO(maquina, mapa, isUsarEspelhamento);
		} catch (Exception e) {
			e.printStackTrace();
			rollbackTransacao(sessao);
			throw new RuntimeException(e);
		} finally {
			commitaTransacao(sessao);
		}
		rn = null;
		return posicoes;
	}
	
	public PosicoesCODTO getPosicaoAlternativos(String maquina, String mapa) {
		MapaAlimentacaoRN rn = new MapaAlimentacaoRN();
		Session sessao = null;
		PosicoesCODTO posicoes = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			posicoes = rn.getPosicaoAlternativos(maquina, mapa);
		} catch (Exception e) {
			e.printStackTrace();
			rollbackTransacao(sessao);
			throw new RuntimeException(e);
		} finally {
			commitaTransacao(sessao);
		}
		rn = null;
		return posicoes;
	}
	
	//Método de envio dos status das operações do Check Feeder
	
	public int sendStatusSemp(String maquina, String stCheck, String stAlim, String stRealim){
		
		int retorno = 0;
		/* Inicialmente o client SEMP quis a linha como parâmetro e depois quis a máquina
		OmPt ompt = null;
		
		try{
			
			PTRN rn = new PTRN();
			rn.iniciaConexaoBanco();
			ompt = rn.pesquisarPtByCdPtStAtivo(maquina);
			rn.finalizaConexaoBanco();
			
		}catch(Exception e){
			e.printStackTrace();
		}*/
		HttpURLConnection conn = null;
		try{
			
			String urlAux = 
			"http://sisap.semptcl.mao/IDW/GravarStatus/?maquina="+maquina+
			"&statusCheck=" +stCheck+ 
			"&statusAlimenta=" + stAlim +
			"&statusRealimenta=" + stRealim;
			
			URL url = new URL(urlAux);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
                        
            //conn.setRequestProperty("Accept", "application/json");
            
            retorno = conn.getResponseCode();
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            conn.connect();
            
            //InputStream response = url.openStream();           
            //InputStream response = conn.getInputStream();
            conn.disconnect();
		} catch(Exception e){
			e.printStackTrace();
			conn.disconnect();
		}
		
		return retorno;
	}

	public ResultadoEntradaLocalProdutoDTO setEntradaLocalProduto(String cdProduto, String cdLocalDestino, int qtdEntrada, String usuario) {
		DAOGenerico dao = new DAOGenerico();
		MovimentacaoLocalEstoque movimentacao = new MovimentacaoLocalEstoque(dao);
		ResultadoEntradaLocalProdutoDTO movimentacaoDTO = null;
		try {
			movimentacao.iniciaConexaoBanco();
			movimentacaoDTO = movimentacao.setEntradaLocalProduto(cdProduto, cdLocalDestino, qtdEntrada, usuario);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			movimentacao.finalizaConexaoBanco();
		}
		return movimentacaoDTO;
	}

	public ResultadoEntradaLocalProdutoDTO setMovimentacaoLocalProduto(String cdlocalOrigem, String cdProduto, String cdLocalDestino,
			int qtdEntrada, String usuario) {
		DAOGenerico dao = new DAOGenerico();
		MovimentacaoLocalEstoque movimentacao = new MovimentacaoLocalEstoque(dao);
		ResultadoEntradaLocalProdutoDTO movimentacaoDTO = null;

		try {
			movimentacao.iniciaConexaoBanco();
			movimentacaoDTO = movimentacao.setMovimentacaoLocalProduto(cdlocalOrigem, cdProduto, cdLocalDestino, qtdEntrada, usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			movimentacao.finalizaConexaoBanco();
		}

		return movimentacaoDTO;
	}

	public boolean setConferenciaOuPre(LeiturasCODTO leituras) {
		AlimentacaoRN rn = new AlimentacaoRN();
		DAOGenerico dao = new DAOGenerico();
		boolean confpre = false;
		try {
			dao.iniciaConexaoBanco();
			rn.setSession(dao.getSession());
			confpre = rn.setConferenciaOuPre(leituras);
		} catch (Exception e) {
			e.printStackTrace();
			dao.rollBackTransacaoSemException();
		} finally {
			dao.finalizaConexaoBancoSemException();
		}
		rn = null;
		return confpre;
	}

	public PTsDTO getTodosPtsEmOmPapro() {
		MonitorizacaoAlimentacaoRN rn = new MonitorizacaoAlimentacaoRN();
		PTsDTO retorno = new PTsDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTodosPtsEmOmPapro();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}
	
	public PTsDTO getTodosPtsComAlimentacao(){
		MonitorizacaoAlimentacaoRN rn = new MonitorizacaoAlimentacaoRN();
		PTsDTO retorno = new PTsDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTodosPtsComAlimentacao();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}


	public MonitorizacoesAlimsDTO getMonitorizacaoAlimComFiltro(String cdPt, boolean isMaisDeUmProduto, boolean isFiltrarGt) {
		MonitorizacoesAlimsDTO retorno = null;
		MonitorizacaoAlimentacaoByReelRN rn = new MonitorizacaoAlimentacaoByReelRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.monitorizacaoRealimentacao(cdPt, isMaisDeUmProduto, isFiltrarGt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public MonitorizacoesCheckFeederDTO getMonitorizacaoCheckFeeder(String cdPt) {

		MonitorizacoesCheckFeederDTO retorno = new MonitorizacoesCheckFeederDTO();
		DAOGenerico dao = new DAOGenerico();
		MonitorizacaoAlimentacaoRN alimentacoes = new MonitorizacaoAlimentacaoRN(dao);
		try {
			alimentacoes.iniciaConexaoBanco();
			retorno = alimentacoes.getListaMonitorizacaoCheckFeeder(cdPt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			alimentacoes.finalizaConexaoBanco();
		}
		return retorno;
	}

	public void desalimentacao(String omPt, Long usr) {
		DAOGenerico dao = new DAOGenerico();
		DesalimentacaoRN rn = new DesalimentacaoRN(dao);
		try {
			rn.iniciaConexaoBanco();
			rn.desalimentaPontosAlimentacaoDoPT(omPt, usr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
	}

	public LeiturasCODTO setCorrente(LeiturasCODTO leituras) {
		AlimentacaoRN rn = new AlimentacaoRN();
		DAOGenerico dao = new DAOGenerico();
		LeiturasCODTO corrente = null;
		try {
			dao.iniciaConexaoBanco();
			rn.setSession(dao.getSession());
			corrente = rn.setCorrente(leituras);
		} catch (Exception e) {
			e.printStackTrace();
			dao.rollBackTransacaoSemException();
		} finally {
			dao.finalizaConexaoBancoSemException();
		}
		rn = null;
		return corrente;
	}

	public boolean setRealimentacao(LeiturasCODTO leituras) {
		AlimentacaoRN rn = new AlimentacaoRN();
		DAOGenerico dao = new DAOGenerico();
		boolean rea = false;
		try {
			dao.iniciaConexaoBanco();
			rn.setSession(dao.getSession());
			rea = rn.setRealimentacao(leituras);
		} catch (Exception e) {
			e.printStackTrace();
			dao.rollBackTransacaoSemException();
		} finally {
			dao.finalizaConexaoBancoSemException();
		}
		rn = null;
		return rea;
	}

	public boolean isProdutoEAlternativo(String cdProduto, String cdProdutoLido) {
		ProdutoRN rn = new ProdutoRN();
		boolean retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.isProdutoEAlternativo(cdProduto, cdProdutoLido);
		} catch (Exception e) {
			retorno = false;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public void assumePreConferencia(String maquina) {
		PTRN rn = new PTRN();
		Session sessao = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			rn.assumePreConferencia(maquina);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
	}

	public LeiturasCODTO getCorrente(Long idAlimCorrente) {
		AlimentacaoRN rn = new AlimentacaoRN();
		Session sessao = null;
		LeiturasCODTO corrente = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			corrente = rn.getCorrente(idAlimCorrente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return corrente;
	}

	public boolean isRecursoAcessivel(int idAcesso, long idUsr) {
		UsuarioRN rn = new UsuarioRN();
		Session sessao = null;
		boolean retorno = false;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			retorno = rn.isRecursoAcessivel(idAcesso, idUsr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return retorno;
	}

	public HomologacoesDTO validarHomologacoesUsrPt(HomologacoesDTO homologacoesDTO) {
		UsuarioRN rn = new UsuarioRN();
		HomologacoesDTO homologacoes = null;
		Session sessao = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			homologacoes = rn.validarHomologacoesUsrPt(homologacoesDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return homologacoes;
	}

	public HomologacoesDTO validarHomologacoesUsrGt(HomologacoesDTO homologacoesDTO) {
		UsuarioRN rn = new UsuarioRN();
		Session sessao = null;

		HomologacoesDTO homologacoes = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			homologacoes = rn.validarHomologacoesUsrGt(homologacoesDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return homologacoes;
	}

	public HomologacoesDTO validarHomologacoesGt(HomologacoesDTO homologacoesDTO) {
		GTRN rn = new GTRN();
		Session sessao = null;
		HomologacoesDTO homologacoes = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			homologacoes = rn.validarHomologacoesGt(homologacoesDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return homologacoes;
	}

	public HomologacoesDTO validarHomologacoesPt(HomologacoesDTO homologacoesDTO) {
		PTRN rn = new PTRN();
		Session sessao = null;
		HomologacoesDTO homologacoes = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			homologacoes = rn.validarHomologacoesPt(homologacoesDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return homologacoes;
	}

	public ParametrosDTO getParametrosDTO(ParametroDTO parametro) {
		ParametroRN rn = new ParametroRN();
		Session sessao = null;
		ParametrosDTO parametros = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			parametros = rn.getParametrosDTO(parametro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return parametros;
	}

	public ParametrosDTO getParametrosDTOComoListaGeral() {
		ParametroRN rn = new ParametroRN();
		Session sessao = null;
		ParametrosDTO parametros = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			parametros = rn.getParametrosDTOComoListaGeral();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return parametros;
	}

	public ParametroDTO getDwFtParamPeloDs(String dsFtParam) {
		ParametroRN rn = new ParametroRN();

		Session sessao = null;
		ParametroDTO parametro = new ParametroDTO();

		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			parametro = rn.getDwFtParamPeloDs(dsFtParam);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return parametro;
	}

	public ConfiguracoesDTO getConfiguracoesDTO(ConfiguracaoDTO configuracao) {
		ConfiguracaoRN rn = new ConfiguracaoRN();
		ConfiguracoesDTO configuracoes;
		try {
			rn.iniciaConexaoBanco();
			configuracoes = rn.getConfiguracoesDTO(configuracao);
		} catch (Exception e) {
			configuracoes = new ConfiguracoesDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return configuracoes;
	}

	public ResultadoDTO removerProdutosSemConsumoDoEstoque() {
		LocalEstoquePaRN rn = new LocalEstoquePaRN();
		ResultadoDTO retorno = new ResultadoDTO();
		retorno.setIdmensagem(retorno.ERRO_DESCONHECIDO);
		try {
			rn.iniciaConexaoBanco();
			rn.removerProdutosSemConsumoDoEstoqueAlimentacao();
			retorno.setIdmensagem(retorno.COM_SUCESSO);
		} catch (Exception e) {
			e.printStackTrace();
			rn.rollbackTransacao();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ConfiguracaoCheckFeederDTO getConfiguracao() {
		ConfiguracaoRN rn = new ConfiguracaoRN();
		ConfiguracaoCheckFeederDTO checkFeeder = new ConfiguracaoCheckFeederDTO();
		Session sessao = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			OmCfg configuracoes = rn.getConfiguracao();
			checkFeeder.setMascara(configuracoes.getMascaraQtd());
			checkFeeder.setMascaraComponente(configuracoes.getMascaracdprodutomp());
			checkFeeder.setNivel(configuracoes.getIsNivelfeeder());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return checkFeeder;
	}

	public ConfiguracaoCheckLevelDTO getConfiguracaoCheckLevel() {
		ConfiguracaoRN rn = new ConfiguracaoRN();
		ConfiguracaoCheckLevelDTO checklevel = new ConfiguracaoCheckLevelDTO();
		Session sessao = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			OmCfg configuracoes = rn.getConfiguracao();
			checklevel.setMascara(configuracoes.getMascaraQtd());
			checklevel.setMascaraComponente(configuracoes.getMascaracdprodutomp());
			checklevel.setNivel(configuracoes.getIsNivelfeeder());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return checklevel;
	}

	public ParametroDTO setParametroDTO(ParametroDTO parametro) {
		ParametroRN rn = new ParametroRN();
		Session sessao = null;
		ParametroDTO parametroRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			parametroRetorno = rn.setParametroDTO(parametro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return parametroRetorno;
	}

	public ConfiguracaoDTO setConfiguracaoDTO(ConfiguracaoDTO configuracao) {
		ConfiguracaoRN rn = new ConfiguracaoRN();
		ConfiguracaoDTO configuracaoRetorno;
		try {
			rn.iniciaConexaoBanco();
			configuracaoRetorno = rn.setConfiguracaoDTO(configuracao);
		} catch (Exception e) {
			e.printStackTrace();
			configuracaoRetorno = new ConfiguracaoDTO();
			ResultadoDTO resultado = new ResultadoDTO();
			configuracaoRetorno.setResultado(resultado);
			configuracaoRetorno.getResultado().setIdmensagem(resultado.getERRO_DESCONHECIDO());
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return configuracaoRetorno;
	}

	public ParametrosDTO removeParametrosDTO(ParametrosDTO parametros) {
		ParametroRN rn = new ParametroRN();
		Session sessao = null;
		ParametrosDTO parametrosRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			parametrosRetorno = rn.removeParametrosDTO(parametros);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return parametrosRetorno;
	}

	public ConfiguracoesDTO removeConfiguracoesDTO(ConfiguracoesDTO configuracoes) {
		ConfiguracaoRN rn = new ConfiguracaoRN();
		Session sessao = null;
		ConfiguracoesDTO configuracoesRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			configuracoesRetorno = rn.removeConfiguracoesDTO(configuracoes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			commitaTransacao(sessao);
		}
		rn = null;
		return configuracoesRetorno;
	}

	public TurnosDTO getTurnosDTO(TurnoDTO itemDTO) {
		TurnoRN rn = new TurnoRN();
		TurnosDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTurnosDTO(itemDTO);
		} catch (Exception e) {
			retorno = new TurnosDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public TurnoDTO setTurnoDTO(TurnoDTO itemDTO) {
		TurnoRN rn = new TurnoRN();
		TurnoDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setTurnoDTO(itemDTO);
		} catch (Exception e) {
			retorno = new TurnoDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public TurnosDTO removeTurnosDTO(TurnosDTO itemDTO) {
		TurnoRN rn = new TurnoRN();
		TurnosDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeTurnosDTO(itemDTO);
		} catch (Exception e) {
			retorno = new TurnosDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public TurnoDTO ativaTurnoDTO(TurnoDTO itemDTO) {
		TurnoRN rn = new TurnoRN();
		TurnoDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.ativaTurnoDTO(itemDTO);
		} catch (Exception e) {
			retorno = new TurnoDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public TDefeitosDTO getTDefeitosDTO(TDefeitoDTO itemDTO) {
		TDefeitoRN rn = new TDefeitoRN();
		Session sessao = null;
		TDefeitosDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.getTDefeitosDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return itemRetorno;
	}

	public TDefeitoDTO setTDefeitoDTO(TDefeitoDTO itemDTO) {
		TDefeitoRN rn = new TDefeitoRN();
		Session sessao = null;
		TDefeitoDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.setTDefeitoDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return itemRetorno;
	}

	public TDefeitosDTO removeTDefeitosDTO(TDefeitosDTO itemDTO) {
		TDefeitoRN rn = new TDefeitoRN();
		Session sessao = null;
		TDefeitosDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.removeTDefeitosDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return itemRetorno;
	}

	public TDefeitoDTO ativaTDefeitoDTO(TDefeitoDTO itemDTO) {
		TDefeitoRN rn = new TDefeitoRN();
		Session sessao = null;
		TDefeitoDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.ativaTDefeitoDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return itemRetorno;
	}

	public DwTAcoes getDwAcao(Long idTppt) {
		AcaoRN rn = new AcaoRN();
		Session sessao = null;
		DwTAcoes itemRetorno = new DwTAcoes();
		sessao = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			itemRetorno = rn.getDwAcao(idTppt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return itemRetorno;
	}

	public TAcoesDTO getTAcoesDTO(TAcaoDTO itemDTO) {
		TAcaoRN rn = new TAcaoRN();
		Session sessao = null;
		TAcoesDTO itemRetorno = null;
		sessao = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.getTAcoesDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return itemRetorno;
	}

	public TAcaoDTO setTAcaoDTO(TAcaoDTO itemDTO) {
		TAcaoRN rn = new TAcaoRN();
		Session sessao = null;
		TAcaoDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.setTAcaoDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}

		rn = null;
		return itemRetorno;
	}

	public TAcoesDTO removeTAcoesDTO(TAcoesDTO itemDTO) {
		TAcaoRN rn = new TAcaoRN();
		Session sessao = null;
		TAcoesDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.removeTAcoesDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return itemRetorno;
	}

	public TAcaoDTO ativaTAcaoDTO(TAcaoDTO itemDTO) {
		TAcaoRN rn = new TAcaoRN();
		Session sessao = null;
		TAcaoDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.ativaTAcaoDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}

		rn = null;
		return itemRetorno;
	}

	public GruposProdutoDTO getGruposProdutoDTO(GrupoProdutoDTO itemDTO) {
		GrupoProdutoRN rn = new GrupoProdutoRN();
		Session sessao = null;
		GruposProdutoDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.getGruposProdutoDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return itemRetorno;
	}

	public GrupoProdutoDTO setGrupoProdutoDTO(GrupoProdutoDTO itemDTO) {
		GrupoProdutoRN rn = new GrupoProdutoRN();
		Session sessao = null;
		GrupoProdutoDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.setGrupoProdutoDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return itemRetorno;
	}

	public GruposProdutoDTO removeGruposProdutoDTO(GruposProdutoDTO itemDTO) {
		GrupoProdutoRN rn = new GrupoProdutoRN();
		Session sessao = null;
		GruposProdutoDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.removeGruposProdutoDTO(itemDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return itemRetorno;
	}

	public boolean validarPtcnc(OmPtcncDTO dto) {
		PTRN rn = new PTRN();
		boolean retorno = false;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.validarOmptcnc(dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public GrupoProdutoDTO ativaGrupoProdutoDTO(GrupoProdutoDTO itemDTO) {
		GrupoProdutoRN rn = new GrupoProdutoRN();
		Session sessao = null;
		GrupoProdutoDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.ativaGrupoProdutoDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return itemRetorno;
	}

	public CalendariosDTO getCalendariosDTO(CalendarioDTO itemDTO) {
		CalendarioRN rn = new CalendarioRN();
		Session sessao = null;
		CalendariosDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.getCalendariosDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return itemRetorno;
	}

	public CalendarioDTO setCalendarioDTO(CalendarioDTO itemDTO) {
		CalendarioRN rn = new CalendarioRN();
		Session sessao = null;
		CalendarioDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.setCalendarioDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return itemRetorno;
	}

	public CalendariosDTO removeCalendariosDTO(CalendariosDTO itemDTO) {
		CalendarioRN rn = new CalendarioRN();
		Session sessao = null;
		CalendariosDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.removeCalendariosDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return itemRetorno;
	}

	public CalendarioPtsDTO validarCalendarioPtsDTO(CalendarioPtsDTO itemDTO) {
		CalendarioRN rn = new CalendarioRN();
		Session sessao = null;
		CalendarioPtsDTO pts = null;
		try {
			sessao = null;
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			pts = rn.validarCalendarioPts(itemDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return pts;
	}

	public CalendariosSemanaisDTO getCalendariosSemanaisDTO(CalendarioSemanalFiltroDTO itemDTO) {
		CalendarioRN rn = new CalendarioRN();
		Session sessao = null;
		CalendariosSemanaisDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.getCalendariosSemanaisDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return itemRetorno;
	}
	public CalendariosSemanaisDTO getCalendarioPt(Long idCal) {
		CalendarioRN rn = new CalendarioRN();
		Session sessao = null;
		CalendariosSemanaisDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.getCalendarioPt(idCal);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return itemRetorno;
	}

	public CalendariosSemanaisDTO wizardCalendario(CalendarioWizardDTO itemDTO) {
		CalendarioRN rn = new CalendarioRN();
		CalendariosSemanaisDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.wizardCalendario(itemDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public SessoesDTO inicializacao(String mac, Date dthrevento) {
		InicializacaoRN rn = new InicializacaoRN();
		Session sessao = null;
		SessoesDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.inicializacao(mac, dthrevento);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (itemRetorno.getResultado().getIdmensagem() == itemRetorno.getResultado().getCOM_SUCESSO()) {
				if (sessao != null) {
					commitaTransacao(sessao);
				}
			} else {
				rollbackTransacao(sessao);
			}
		}
		rn = null;
		return (itemRetorno);
	}

	public SessoesDTO heartBeat(String mac, Date dthrevento) { // HERE
		InicializacaoRN rn = null;
		Session sessao = null;
		SessoesDTO itemRetorno = null;

		try {
			rn = new InicializacaoRN();
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.heartBeat(mac, dthrevento);
		} catch (SemCalendarioException e1) {
			itemRetorno = new SessoesDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().getERROR_SEM_CALENDARIO());
		} catch (Exception e) {
			e.printStackTrace();
			itemRetorno = new SessoesDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().getSEM_SGBD());
		} finally {
			if (itemRetorno.getResultado().getIdmensagem() == itemRetorno.getResultado().getCOM_SUCESSO()) {
				if (sessao != null) {
					commitaTransacao(sessao);
				}
			} else {
				rollbackTransacao(sessao);
			}
		}

		rn = null;
		return (itemRetorno);
	}

	public LoginDTO setLoginDTO(LoginDTO login) { // HERE
		LoginRN rn = new LoginRN();
		Session sessao = null;
		LoginDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.setLoginDTO(login);
		} catch (SemCalendarioException e) {
			itemRetorno = new LoginDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().getERROR_SEM_CALENDARIO());
		} catch (Exception e) {
			e.printStackTrace();
			itemRetorno = new LoginDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().getSEM_SGBD());
		} finally {
			if (itemRetorno.getResultado().getIdmensagem() == itemRetorno.getResultado().getLOGIN_GT_COM_SUCESSO()
					|| itemRetorno.getResultado().getIdmensagem() == itemRetorno.getResultado().getLOGIN_PT_COM_SUCESSO()) {
				if (sessao != null) {
					commitaTransacao(sessao);
				}
			} else {
				rollbackTransacao(sessao);
			}
		}

		rn = null;
		return (itemRetorno);
	}

	public LogoutDTO setLogoutDTO(LogoutDTO logout) {
		LoginRN rn = new LoginRN();
		Session sessao = null;

		LogoutDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.setLogoutDTO(logout);
		} catch (SemCalendarioException e) {
			itemRetorno = new LogoutDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().getERROR_SEM_CALENDARIO());
		} catch (Exception e) {
			e.printStackTrace();
			itemRetorno = new LogoutDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().getSEM_SGBD());
		} finally {
			if (itemRetorno.getResultado().getIdmensagem() == itemRetorno.getResultado().getLOGOUT_GT_COM_SUCESSO()
					|| itemRetorno.getResultado().getIdmensagem() == itemRetorno.getResultado().getLOGOUT_PT_COM_SUCESSO()) {
				if (sessao != null) {
					commitaTransacao(sessao);
				}
			} else {
				rollbackTransacao(sessao);
			}
		}

		rn = null;
		return (itemRetorno);
	}

	public PassagemDTO postoPassagem(PassagemDTO passagem) {
		PostoPassagemRN rn = new PostoPassagemRN();
		PassagemDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.postosPassagem(passagem);
		} catch (SemCalendarioException e) {
			itemRetorno = new PassagemDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().ERROR_SEM_CALENDARIO);
		} catch (Exception e) {
			e.printStackTrace();
			itemRetorno = new PassagemDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().getSEM_SGBD());
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return (itemRetorno);
	}

	public PassagemDTO postoTesteVisual(PassagemDTO passagem) {
		PostoTesteVisualRN rn = new PostoTesteVisualRN();
		PassagemDTO itemRetorno = null;

		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.postosPassagem(passagem);
		} catch (SemCalendarioException e) {
			itemRetorno = new PassagemDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().ERROR_SEM_CALENDARIO);
		} catch (SemSGBDException e) {
			itemRetorno = new PassagemDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().SEM_SGBD);
		} catch (Exception e) {
			e.printStackTrace();
			itemRetorno = new PassagemDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().SEM_SGBD);
		} finally {
			if (itemRetorno.getResultado().getIdmensagem() == itemRetorno.getResultado().getCOM_SUCESSO()
					|| itemRetorno.getResultado().getIdmensagem() == itemRetorno.getResultado().getPRODUTO_ENTROU_NAO_CONFORME()) {
				rn.finalizaConexaoBanco();
			} else {
				rn.rollbackTransacao();
			}
		}

		rn = null;
		return (itemRetorno);
	}

	public PassagemDTO postoReprocesso(PassagemDTO passagem) {
		PostoReprocessoRN rn = new PostoReprocessoRN();
		PassagemDTO itemRetorno = null;

		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.postosPassagem(passagem);
		} catch (SemCalendarioException e) {
			itemRetorno = new PassagemDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().ERROR_SEM_CALENDARIO);
		} catch (SemSGBDException e) {
			itemRetorno = new PassagemDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().SEM_SGBD);
		} catch (Exception e) {
			e.printStackTrace();
			itemRetorno = new PassagemDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().SEM_SGBD);
		} finally {
			if (itemRetorno.getResultado().getIdmensagem() == itemRetorno.getResultado().getCOM_SUCESSO()) {
				rn.finalizaConexaoBanco();
			} else {
				rn.rollbackTransacao();
			}
		}

		rn = null;
		return (itemRetorno);
	}

	public PassagemDTO postoMontagem(PassagemDTO passagem) {
		PostoMontagemRN rn = new PostoMontagemRN();
		PassagemDTO itemRetorno = null;

		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.postosPassagem(passagem);
		} catch (SemCalendarioException e) {
			itemRetorno = new PassagemDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().ERROR_SEM_CALENDARIO);
		} catch (SemSGBDException e) {
			itemRetorno = new PassagemDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().SEM_SGBD);
		} catch (Exception e) {
			e.printStackTrace();
			itemRetorno = new PassagemDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().SEM_SGBD);
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return (itemRetorno);
	}

	public EtapasDTO getEtapasDTO(EtapaDTO itemDTO) {
		EtapaRN rn = new EtapaRN();
		Session sessao = null;
		EtapasDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.getEtapasDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null) {
				commitaTransacao(sessao);
			}
		}

		rn = null;
		return itemRetorno;
	}

	public PassagemDTO verificaPassagem(PassagemDTO passagem) {
		VerificaPassagemRN rn = new VerificaPassagemRN(getDao());
		Session sessao = null;
		PassagemDTO itemRetorno = null;

		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.verificaPassagem(passagem);
		} catch (NumeroSerieIrregularException e) {
			itemRetorno = new PassagemDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().PRODUTO_DESCONHECIDO);
		} catch (Exception e) {
			e.printStackTrace();
			itemRetorno = new PassagemDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().SEM_SGBD);
		} finally {
			itemRetorno.setDwfolha(null);
			itemRetorno.setDwnserie(null);
			itemRetorno.setDwrotapasso(null);
			itemRetorno.setOmcfg(null);

			if (itemRetorno.getResultado().getIdmensagem() == itemRetorno.getResultado().getCOM_SUCESSO()
					|| itemRetorno.getResultado().getIdmensagem() == itemRetorno.getResultado().getPRODUTO_ENTROU_NAO_CONFORME()) {
				if (sessao != null) {
					commitaTransacao(sessao);
				}
			} else {
				rollbackTransacao(sessao);
			}
		}

		rn = null;
		return (itemRetorno);
	}

	public PassagemDTO obtemNaoConformidadesAtuais(PassagemDTO passagem) {
		VerificaPassagemRN rn = new VerificaPassagemRN(getDao());
		Session sessao = null;
		PassagemDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.obtemNaoConformidadesAtuais(passagem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			itemRetorno.setDwfolha(null);
			itemRetorno.setDwnserie(null);
			itemRetorno.setDwrotapasso(null);
			if (itemRetorno.getResultado().getIdmensagem() == itemRetorno.getResultado().getCOM_SUCESSO()) {
				if (sessao != null) {
					commitaTransacao(sessao);
				}
			} else {
				rollbackTransacao(sessao);
			}
		}

		rn = null;
		return (itemRetorno);
	}

	public EtapaDTO setEtapaDTO(EtapaDTO itemDTO) {
		EtapaRN rn = new EtapaRN();
		Session sessao = null;
		EtapaDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.setEtapaDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null) {
				commitaTransacao(sessao);
			}
		}
		rn = null;
		return itemRetorno;
	}

	public EtapasDTO removeEtapasDTO(EtapasDTO itemDTO) {
		EtapaRN rn = new EtapaRN();
		Session sessao = null;
		EtapasDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.removeEtapasDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null) {
				commitaTransacao(sessao);
			}
		}

		rn = null;
		return itemRetorno;
	}

	public ProdutosDTO pesquisarFolhaComOsProdutosConsiderandoEstrutura(ProdutosDTO produtos, OmPt ompt) {
		FolhaRN rn = new FolhaRN();
		ProdutosDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarFolhaComOsProdutosConsiderandoEstrutura(produtos, ompt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public FolhasDTO getFolhasDTO(FolhaDTO itemDTO) {
		FolhaRN rn = new FolhaRN();
		FolhasDTO itemRetorno;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.getFolhasDTO(itemDTO);
		} catch (Exception e) {
			e.printStackTrace();
			itemRetorno = new FolhasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return itemRetorno;
	}

	public DwFolha getDwFolhaPassagem(String cdPt, String nrop, String cb) {
		FolhaRN rn = new FolhaRN();
		DwFolha retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDwFolhaPassagem(cdPt, nrop, cb);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new DwFolha();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public FolhasDTO getFolhasDTOSemClonarFilhos(FolhaDTO itemDTO) {
		FolhaRN rn = new FolhaRN();
		FolhasDTO itemRetorno;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.getFolhasDTOSemClonarFilhos(itemDTO);
		} catch (Exception e) {
			e.printStackTrace();
			itemRetorno = new FolhasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return itemRetorno;
	}

	public FolhaDTO setFolhaDTO(FolhaDTO itemDTO) { // HERE
		FolhaRN rn = new FolhaRN();
		FolhaDTO itemRetorno;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.setFolhaSemCadastroEtapaDTO(itemDTO);
			// Alessandre: o commit abaixo deve ser feito apenas se a transacao
			// terminou com sucesso. Se não um rollback deve ser feito. Alem
			// disso,
			// o trecho abaixo não deveria estar no facade, mas sim na RN.
			if (itemRetorno.getResultadoEvento() == itemRetorno.getEVENTO_BEM_SUCEDIDO())
				rn.finalizaConexaoBanco();
			else
				rn.rollbackTransacao();

		} catch (Exception e) {
			e.printStackTrace();
			itemRetorno = new FolhaDTO();
		}
		rn = null;
		return itemRetorno;
	}

	public void updateFolhaDTO(FolhaDTO itemDTO) {
		FolhaRN rn = new FolhaRN();
		try {
			rn.iniciaConexaoBanco();
			rn.updateFolhaDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
	}

	public FolhasDTO removeFolhasDTO(FolhasDTO itemDTO) {
		FolhaRN rn = new FolhaRN();
		FolhasDTO itemRetorno;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.removeFolhasDTO(itemDTO);
		} catch (Exception e) {
			e.printStackTrace();
			itemRetorno = new FolhasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return itemRetorno;
	}

	public AcoplamentoDTO verificaAcoplamento(AcoplamentoDTO acoplamento, MontagensDTO montagens) {
		VerificaAcoplamentoRN rn = new VerificaAcoplamentoRN();
		Session sessao = null;
		AcoplamentoDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.verificaAcoplamento(acoplamento, montagens);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (itemRetorno.getResultado().getIdmensagem() == itemRetorno.getResultado().getCOM_SUCESSO()
					|| itemRetorno.getResultado().getIdmensagem() == itemRetorno.getResultado().getACOPLAMENTO_FINALIZADO()) {
				if (sessao != null) {
					commitaTransacao(sessao);
				}
			} else {
				rollbackTransacao(sessao);
			}
		}

		rn = null;
		return itemRetorno;
	}

	public AcoplamentoDTO verificaComponenteAcoplamento(AcoplamentoDTO acoplamento, MontagensDTO montagens) {
		VerificaAcoplamentoRN rn = new VerificaAcoplamentoRN();
		Session sessao = null;
		AcoplamentoDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.verificaComponenteAcoplamento(acoplamento, montagens);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (itemRetorno.getResultado().getIdmensagem() == itemRetorno.getResultado().getCOM_SUCESSO()) {
				if (sessao != null) {
					commitaTransacao(sessao);
				}
			} else {
				rollbackTransacao(sessao);
			}
		}

		rn = null;
		return itemRetorno;
	}

	public DefeitoDTO verificaDefeito(DefeitoDTO defeito) {
		VerificaDefeitoRN rn = new VerificaDefeitoRN();
		Session sessao = null;
		DefeitoDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.verificaDefeito(defeito);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (itemRetorno.getResultado().getIdmensagem() == itemRetorno.getResultado().getCOM_SUCESSO()
					|| itemRetorno.getResultado().getIdmensagem() == itemRetorno.getResultado().getACOPLAMENTO_FINALIZADO()) {
				if (sessao != null) {
					commitaTransacao(sessao);
				}
			} else {
				rollbackTransacao(sessao);
			}
		}

		rn = null;
		return itemRetorno;
	}

	public ComponenteDTO verificaComponente(ComponenteDTO componente) {
		ProdutoRN rn = new ProdutoRN();
		rn.iniciaConexaoBanco();
		ComponenteDTO retorno = null;
		try {
			retorno = rn.verificaComponente(componente);
		} catch (Exception e) {
			retorno = new ComponenteDTO();
		} finally {
			if (retorno.getResultado().getIdmensagem() == retorno.getResultado().getCOM_SUCESSO()
					|| retorno.getResultado().getIdmensagem() == retorno.getResultado().getACOPLAMENTO_FINALIZADO()) {
				rn.finalizaConexaoBanco();
			} else {
				rn.rollbackTransacao();
			}
		}
		return retorno;
	}

	public RoteirosDTO preenchePesquisaRoteiro(RoteiroDTO itemDTO) {

		RoteiroRN rn = new RoteiroRN();
		Session sessao = null;
		RoteirosDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			itemRetorno = rn.getRoteirosDTOSemClonarFilhos(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null) {
				commitaTransacao(sessao);
			}
		}

		rn = null;
		return itemRetorno;

	}

	public RoteirosDTO getRoteirosDTO(RoteiroDTO itemDTO) {
		RoteiroRN rn = new RoteiroRN();
		Session sessao = null;
		RoteirosDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			itemRetorno = rn.getRoteirosDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null) {
				commitaTransacao(sessao);
			}
		}

		rn = null;
		return itemRetorno;
	}

	public RoteiroDTO setRoteiroDTO(RoteiroDTO itemDTO) {
		RoteiroRN rn = new RoteiroRN();
		RoteiroDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.setRoteiroDTO(itemDTO);
			if (itemRetorno.getResultadoEvento() == itemRetorno.getEVENTO_BEM_SUCEDIDO())
				rn.finalizaConexaoBanco();
			else
				rn.rollbackTransacao();
		} catch (Exception e) {
			e.printStackTrace();
			itemRetorno.setResultadoEvento(itemRetorno.getERRO_DESCONHECIDO());
			rn.rollbackTransacao();
		}

		rn = null;
		return itemRetorno;
	}

	public RoteirosDTO removeRoteirosDTO(RoteirosDTO itemDTO) {
		RoteiroRN rn = new RoteiroRN();
		Session sessao = null;
		RoteirosDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			itemRetorno = rn.removeRoteirosDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null) {
				commitaTransacao(sessao);
			}
		}

		rn = null;
		return itemRetorno;
	}

	public List<String> pesquisaProdutoDepara() {
		DiversosRN rn = new DiversosRN();
		Session sessao = null;
		List<String> listaRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			listaRetorno = rn.pesquisaProdutoDepara();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null) {
				commitaTransacao(sessao);
			}
		}

		rn = null;
		return listaRetorno;
	}

	public List<String> pesquisaProdutoComplemento() {
		DiversosRN rn = new DiversosRN();
		Session sessao = null;
		List<String> listaRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			listaRetorno = rn.pesquisaProdutoComplemento();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null) {
				commitaTransacao(sessao);
			}
		}

		rn = null;
		return listaRetorno;
	}

	public PesquisasDTO pesquisaEtapa(PesquisaDTO pesquisa) {
		DiversosRN rn = new DiversosRN();
		Session sessao = null;
		PesquisasDTO listaRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			listaRetorno = rn.pesquisaEtapa(pesquisa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null) {
				commitaTransacao(sessao);
			}
		}

		rn = null;
		return listaRetorno;
	}

	// public CfgCheckFeederDTO pesquisaCfgCheckFeeder(){
	// ConfiguracaoRN rn = new ConfiguracaoRN();
	// rn.iniciaConexaoBanco();
	// CfgCheckFeederDTO itemRetorno = rn.pesquisarCfgCheckFeeder();
	// rn.finalizaConexaoBanco();
	// rn = null;
	// return itemRetorno;
	// }

	public OmCfg pesquisaOmcfg() throws SemConfiguracaoException {
		DiversosRN rn = new DiversosRN();
		Session sessao = null;
		OmCfg itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.pesquisaOmcfg();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null) {
				commitaTransacao(sessao);
			}
		}

		rn = null;
		return itemRetorno;
	}

	public PesquisasDTO getResultadoFiltro(String strValor, String strTipo, String cdpt) {
		DiversosRN usuariosRN = new DiversosRN();
		Session sessao = null;
		PesquisasDTO retorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			usuariosRN.setSession(sessao);
			retorno = usuariosRN.getResultadoFiltro(strValor, strTipo, cdpt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null) {
				commitaTransacao(sessao);
			}
		}

		usuariosRN = null;
		return retorno;
	}

	public FiltrosExportacaoDTO getFiltrosDTO(FiltroExportacaoDTO itemDTO) {
		ExportacaoCSVRN rn = new ExportacaoCSVRN();
		FiltrosExportacaoDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.getFiltrosDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return itemRetorno;
	}

	public FiltroExportacaoDTO setFiltroExportacaoDTO(FiltroExportacaoDTO itemDTO) {
		ExportacaoCSVRN rn = new ExportacaoCSVRN();
		FiltroExportacaoDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.setFiltroExportacaoDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return itemRetorno;
	}

	public ImgsDTO getImgsDTO(ImgDTO filtro) {
		MonitorizacaoRN rn = new MonitorizacaoRN();
		ImgsDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getImgsDTO(filtro, true);
		} catch (Exception e) {
			retorno = new ImgsDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ImgsDTO getImgsRoteiroDTO(ImgDTO filtro) {
		MonitorizacaoRoteiroRN rn = new MonitorizacaoRoteiroRN();
		Session sessao = null;
		ImgsDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			itemRetorno = rn.getImgsDTO(filtro, true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null) {
				commitaTransacao(sessao);
			}
		}

		rn = null;
		return itemRetorno;
	}

	public ObjsDTO getArvoreObjsGt(GtDTO gt) {
		MonitorizacaoRN rn = new MonitorizacaoRN();
		ObjsDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getArvoreObjsGt(gt);
		} catch (Exception e) {
			retorno = new ObjsDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwFolhasDTO getFolhasDoPt(OmPt pt) {
		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN();
		DwFolhasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getFolhasDoPt(pt);
		} catch (Exception e) {
			retorno = new DwFolhasDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public FiltroExportacaoDTO validarFiltro(FiltroExportacaoDTO itemDTO) {
		ExportacaoCSVRN rn = new ExportacaoCSVRN();
		FiltroExportacaoDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.validarFiltro(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return itemRetorno;
	}

	public ExportacaoDTO exportaCVS(FiltroExportacaoDTO itemDTO) {
		ExportacaoCSVRN rn = new ExportacaoCSVRN();
		ExportacaoDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.exportaCVS(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return itemRetorno;
	}

	public RelIndTesteFinalDTO getRelIndTesteFinal(FiltroRelDTO filtro) {
		ExportacaoCSVRN rn = new ExportacaoCSVRN();
		RelIndTesteFinalDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.getRelIndTesteFinal(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return itemRetorno;
	}

	public ObjsDTO getObjsDTO(ObjDTO itemDTO) {
		MonitorizacaoRN rn = new MonitorizacaoRN();
		ObjsDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getObjsDTO(null, itemDTO, true);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ObjsDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public GtRtDTO getGtRtDTO(GtRtDTO GtRtDTOFiltro) {
		MonitorizacaoRN rn = new MonitorizacaoRN();
		GtRtDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGtRtDTO(GtRtDTOFiltro);
		} catch (Exception e) {
			retorno = new GtRtDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public GtRtMonitorizacaoDTO getGtRtMonitorizacaoDTO(GtRtDTO GtRtDTOFiltro) {
		MonitorizacaoVisaoMaquinaRN rn = new MonitorizacaoVisaoMaquinaRN();
		GtRtMonitorizacaoDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTelaMonitorizacaoMaquina(GtRtDTOFiltro, DwConsolidTemplate.TpId.TURNO);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new GtRtMonitorizacaoDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public GtRtMonitorizacaoDTO getGtRtMonitorizacaoAcum(GtRtDTO GtRtDTOFiltro) {
		MonitorizacaoVisaoMaquinaRN rn = new MonitorizacaoVisaoMaquinaRN();
		GtRtMonitorizacaoDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTelaMonitorizacaoMaquina(GtRtDTOFiltro, DwConsolidTemplate.TpId.ACUMULADO);
		} catch (Exception e) {
			retorno = new GtRtMonitorizacaoDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public GtRtMonitorizacaoDTO getGtRtMonitorizacaoTmAndroidDTO(long idturno, long idgt, String dtreferencia) {
		MonitorizacaoVisaoMaquinaAndroidRN rn = new MonitorizacaoVisaoMaquinaAndroidRN();
		GtRtMonitorizacaoDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGtRtMonitorizacaoTmAndroidDTO(idturno, idgt, dtreferencia);
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			retorno = new GtRtMonitorizacaoDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ObjDTO getOmObjInicializado() {
		MonitorizacaoRN rn = new MonitorizacaoRN();
		ObjDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOmObjInicializado();
		} catch (Exception e) {
			retorno = new ObjDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ObjsDTO getObjsRoteiroDTO(ObjDTO itemDTO) {
		MonitorizacaoRoteiroRN rn = new MonitorizacaoRoteiroRN();
		Session sessao = null;
		ObjsDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			itemRetorno = rn.getObjsDTO(itemDTO, true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return itemRetorno;
	}

	public void setObjsRoteiro(DwRota dwRota) {
		MonitorizacaoRoteiroRN rn = new MonitorizacaoRoteiroRN();
		Session sessao = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			rn.setObjsRoteiro(dwRota);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null) {
				commitaTransacao(sessao);
			}
		}
		rn = null;
	}

	public DwDesalimpendcontagsDTO getDesalimentacoes(FiltroDesalimentacaoContagem filtro) {
		DesalimentacaoRN rn = new DesalimentacaoRN();
		DwDesalimpendcontagsDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDesalimentacoes(filtro);
		} catch (Exception e) {
			retorno = new DwDesalimpendcontagsDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ResultadoMovimentacaoLocalEstoqueDTO ajustarDesalimentacao(DwDesalimpendcontag desalimentacao, int novaQuantidade,
			int diferenca, String justificativa, String cdPa, OmUsr usuario, Date dthrDesalimentacao) {
		DesalimentacaoRN rn = new DesalimentacaoRN();
		ResultadoMovimentacaoLocalEstoqueDTO retorno = new ResultadoMovimentacaoLocalEstoqueDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.realizarAjusteDesalimentacao(desalimentacao, novaQuantidade, diferenca, justificativa, cdPa, usuario,
					dthrDesalimentacao);
		} catch (Exception e) {
			e.printStackTrace();
			retorno.setMsgErro("Erro ao tentar realizar desalimentaçãoo.");
			retorno.setOk(false);
		} finally {
			if (!retorno.isOk()) {
				rn.rollbackTransacao();
			}
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public PassagemDTO postoTesteFuncional(PassagemDTO passagem) { // HERE
		PostoTesteFuncionalRN rn = new PostoTesteFuncionalRN();
		Session sessao = null;
		PassagemDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.postosPassagem(passagem);
		} catch (SemCalendarioException e) {
			itemRetorno = new PassagemDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().ERROR_SEM_CALENDARIO);
		} catch (SemSGBDException e) {
			itemRetorno = new PassagemDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().SEM_SGBD);
		} catch (Exception e) {
			e.printStackTrace();
			itemRetorno = new PassagemDTO();
			itemRetorno.getResultado().setIdmensagem(itemRetorno.getResultado().SEM_SGBD);
		}

		if (itemRetorno.getResultado().getIdmensagem() == itemRetorno.getResultado().getCOM_SUCESSO()
				|| itemRetorno.getResultado().getIdmensagem() == itemRetorno.getResultado().getPRODUTO_ENTROU_NAO_CONFORME()) {
			if (sessao != null) {
				commitaTransacao(sessao);
			}
		} else {
			rollbackTransacao(sessao);
		}
		rn = null;
		return (itemRetorno);
	}

	public DetalhePTDTO detalhePT(FiltroDetalhePTDTO filtro) {
		DetalhePTRN rn = new DetalhePTRN();
		Session sessao = null;
		DetalhePTDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.detalhePT(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null) {
				commitaTransacao(sessao);
			}
		}

		rn = null;
		return itemRetorno;
	}

	public DetalhePTSerieDTO detalheEtapasTeste(long idNSerie) {
		DetalhePTRN rn = new DetalhePTRN();
		Session sessao = null;
		DetalhePTSerieDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.detalheEtapasTeste(idNSerie);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null) {
				commitaTransacao(sessao);
			}
		}

		rn = null;
		return itemRetorno;
	}

	public DetalhesColetasDTO detalhesColetas(long idSubetapa) {
		DetalhePTRN rn = new DetalhePTRN();
		Session sessao = null;
		DetalhesColetasDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.detalhesColetas(idSubetapa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}

		rn = null;
		return itemRetorno;
	}

	public DetalhePTGraficoTesteFuncionalDTO getGraficoTesteFuncional(FiltroDetalhePTDTO filtro) {
		DetalhePTRN rn = new DetalhePTRN();
		Session sessao = null;
		DetalhePTGraficoTesteFuncionalDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			itemRetorno = rn.getGraficoTesteFuncional(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}

		rn = null;
		return itemRetorno;
	}

	public FolhasDTO getFolhasporProduto(ProdutoDTO itemDTO) {
		FolhaRN rn = new FolhaRN();
		FolhasDTO itemRetorno;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.getFolhasporProduto(itemDTO);
		} catch (Exception e) {
			e.printStackTrace();
			itemRetorno = new FolhasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return itemRetorno;
	}

	public EstoquesDTO getEstoquesDTO(EstoqueDTO itemDTO) {
		EstoqueRN rn = new EstoqueRN();
		Session sessao = null;
		EstoquesDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.getDao().setSession(sessao);
			itemRetorno = rn.getEstoquesDTO(itemDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}

		rn = null;
		return itemRetorno;
	}

	public EstoqueDTO setEstoqueDTO(EstoqueDTO itemDTO) {
		EstoqueRN rn = new EstoqueRN();
		Session sessao = null;
		EstoqueDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.getDao().setSession(sessao);
			itemRetorno = rn.setEstoqueDTO(itemDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}

		rn = null;
		return itemRetorno;
	}

	public EstoquesDTO removeEstoquesDTO(EstoquesDTO itemDTO) {
		EstoqueRN rn = new EstoqueRN();
		Session sessao = null;
		EstoquesDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.getDao().setSession(sessao);
			itemRetorno = rn.removeEstoquesDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}

		rn = null;
		return itemRetorno;
	}

	public EstoqueDTO ativaEstoqueDTO(EstoqueDTO itemDTO) {
		EstoqueRN rn = new EstoqueRN();
		Session sessao = null;
		EstoqueDTO itemRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.getDao().setSession(sessao);
			itemRetorno = rn.ativaEstoqueDTO(itemDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}

		rn = null;
		return itemRetorno;
	}

	public PesquisasDTO pesquisaDwRota(PesquisaDTO pesquisa) {
		DiversosRN rn = new DiversosRN();
		Session sessao = null;
		PesquisasDTO usuarioRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			usuarioRetorno = rn.pesquisaDwRota(pesquisa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}

		rn = null;
		return usuarioRetorno;
	}

	public PesquisasDTO pesquisaCliente(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaCliente(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaUnidadeMedida(PesquisaDTO pesquisa) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO usuarioRetorno;
		try {
			rn.iniciaConexaoBanco();
			usuarioRetorno = rn.pesquisaUnidadeMedida(pesquisa);
		} catch (Exception e) {
			usuarioRetorno = new PesquisasDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return usuarioRetorno;
	}

	public boolean isModoTeste() {
		return false;
	}

	public ConfiguracoesNecessidadesDTO pesquisarListaConfiguracaoNecessidadeDTO(ConfiguracaoNecessidadeDTO configuracaoNecessidadeDTO) {
		ConfiguracoesNecessidadesDTO retorno = null;
		ConfiguracaoNecessidadeRN rn = new ConfiguracaoNecessidadeRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisar(configuracaoNecessidadeDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ConfiguracaoNecessidadeDTO setConfiguracaoNecessidadeDTO(ConfiguracaoNecessidadeDTO itemDTO) {
		// salva
		ConfiguracaoNecessidadeRN rn = new ConfiguracaoNecessidadeRN(itemDTO);
		ConfiguracaoNecessidadeDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.salvarRegistro();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return itemRetorno;
	}

	public ConfiguracaoNecessidadeDTO setExclusaoConfiguracoesNecessidadesDTO(ConfiguracaoNecessidadeDTO itemDTO) {
		// marca como Excluido
		ConfiguracaoNecessidadeRN rn = new ConfiguracaoNecessidadeRN(itemDTO);
		ConfiguracaoNecessidadeDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.excluirRegistro();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return itemRetorno;
	}

	public PpNecListDTO pesquisarListaNecessidadesClientesDTO(PpNecDTO ppNecDTO) {
		PpNecListDTO retorno = new PpNecListDTO();
		PedidoClienteRN rn = new PedidoClienteRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisar(ppNecDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public PpNecListDTO importarPlanilhas(PpNecListDTO listaPpNec) {
		PedidoClienteRN rn = new PedidoClienteRN();
		PpNecListDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco(null);
			itemRetorno = rn.salvarRegistroImportacao(listaPpNec);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return itemRetorno;
	}

	public PpNecimplogListDTO buscarLogs(long idNecimp, int limiteMaximo) {
		PpNecimplogRN rn = new PpNecimplogRN();
		PpNecimplogListDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.pesquisarLogsRealizadosByIdNecimp(idNecimp, limiteMaximo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return itemRetorno;
	}

	public PpNecimpurllogListDTO pesquisarAbasByUrlLog(PpNecimpurllogListDTO logDTO) {
		PpNecimplogRN rn = new PpNecimplogRN();
		PpNecimpurllogListDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.pesquisarAbasByUrlLog(logDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return itemRetorno;
	}

	public PpNecDTO setNecessidadesClientesDTO(PpNecDTO itemDTO) {
		// salva
		PedidoClienteRN rn = new PedidoClienteRN(itemDTO);
		PpNecDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco(null);
			itemRetorno = rn.salvarRegistro();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
			if (itemRetorno == null)
				itemRetorno = new PpNecDTO();
			// remover a referencia de ppnec dentro de ppneccron qdo for
			// retornar pelo webservice
			if (itemRetorno.getPpNeccrons().size() > 0) {
				for (PpNeccron pnecron : itemRetorno.getPpNeccrons()) {
					pnecron.setPpNec(null);
				}
			}
		}
		rn = null;
		return itemRetorno;
	}

	public PpNecDTO setExclusaoNecessidadesClientesDTO(PpNecDTO itemDTO) {
		// marca como Excluido
		PedidoClienteRN rn = new PedidoClienteRN(itemDTO);
		PpNecDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco(null);
			itemRetorno = new PpNecDTO(rn.excluirRegistro().clone());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return itemRetorno;
	}

	public DwRapListDTO pesquisarListaRAPDTO(DwRapDTO itemDTO) {
		DwRapListDTO retorno = null;
		DwRapRN rn = new DwRapRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisar(itemDTO);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwRapListDTO pesquisarFerramentaById(Long id) {
		DwRapListDTO retorno = null;
		DwRapRN rn = new DwRapRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarById(id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwRapDTO setRAPDTO(DwRapDTO itemDTO) {
		DwRapRN rn = new DwRapRN(itemDTO);
		DwRapDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.salvarRegistro();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		if (itemRetorno != null) {
			return itemRetorno;
		} else {
			itemRetorno = new DwRapDTO();
			ResultadoDTO resultadoDTO = new ResultadoDTO();
			resultadoDTO.setIdmensagem(resultadoDTO.getERRO_DESCONHECIDO());
			itemRetorno.setResultadoDTO(resultadoDTO);
		}
		return itemRetorno;
	}

	public DwRapDTO setExclusaoRAPDTO(DwRapDTO itemDTO) {
		// marca como Excluido
		DwRapRN rn = new DwRapRN(itemDTO);
		DwRapDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.excluirRegistro();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		DwRapDTO retorno = null;
		if (itemRetorno != null)
			retorno = new DwRapDTO(itemRetorno.clone());
		else
			retorno = new DwRapDTO();

		return retorno;
	}

	public PesquisasDTO pesquisaRAPs(PesquisaDTO pesquisa) {
		DiversosRN rn = new DiversosRN();
		Session sessao = null;
		PesquisasDTO dtoRetorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			dtoRetorno = rn.pesquisaRAPs(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}

		rn = null;
		return dtoRetorno;
	}

	public PlanoListDTO pesquisarPlanosPlanoProducao(PlanoDTO plano) {
		PlanoProducaoRN rn = new PlanoProducaoRN();
		PlanoListDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarPlanos(plano);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisarPlanosPlanoProducaoBusca(PlanoDTO plano) {
		PlanoProducaoRN rn = new PlanoProducaoRN();
		PlanoListDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarPlanos(plano);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		List<PlanoDTO> lista = retorno.getPlanos();
		PesquisasDTO ret = new PesquisasDTO();
		ret.setPesquisa(new ArrayList<PesquisaDTO>());
		for (PlanoDTO plan : lista) {
			PesquisaDTO p = new PesquisaDTO();
			p.setRegistro(plan);
			ret.getPesquisa().add(p);
		}
		rn = null;
		return ret;
	}

	public PpTpplanoListDTO pesquisarTpPlanos(PpTpplanoDTO pptpplanoDTO) {
		PpTpplanoRN rn = new PpTpplanoRN();
		PpTpplanoListDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarTpPlanos(pptpplanoDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PlanoDTO salvarPlano(PlanoDTO plano) {
		PlanoProducaoRN rn = new PlanoProducaoRN();
		PlanoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			rn.setPlanoDTO(plano, rn.getDao());
			retorno = rn.salvarRegistro();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PlanoDTO firmarPlano(PlanoDTO plano, Boolean isForcarFirmar) {
		PlanoProducaoRN rn = new PlanoProducaoRN();
		PlanoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			rn.setPlanoDTO(plano, rn.getDao());
			retorno = rn.firmarPlano(isForcarFirmar);
		} catch (Exception e) {
			rn.getDao().rollBackTransacao();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public EstoqueDTO salvarPrevChegadaMateriaPrima(EstoquesDTO estoquesDTO) {
		EstoqueRN rn = new EstoqueRN();
		EstoqueDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.salvarEstoqueMateriaPrima(estoquesDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PpNecListDTO pesquisarPpNecs(Date dtReferencia) {
		PlanoProducaoRN rn = new PlanoProducaoRN();
		PpNecListDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarPpNecs(dtReferencia);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PlanoDTO excluirRegistro(PlanoDTO planoDTO) {
		PlanoProducaoRN rn = new PlanoProducaoRN(planoDTO);
		PlanoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.excluirRegistro();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwFolhaRap() {
		DiversosRN rn = new DiversosRN();
		Session sessao = null;
		PesquisasDTO dtoRetorno = null;
		try {
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			dtoRetorno = rn.pesquisaDwFolhaRap();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}

		rn = null;
		return dtoRetorno;
	}

	public PTsDTO getPtsAtivos() {
		PTRN ptrn = new PTRN();
		PTsDTO retorno;
		try {
			ptrn.iniciaConexaoBanco();
			retorno = ptrn.getOmPtAtivos();
		} catch (RegistroDesconhecidoException e) {
			retorno = new PTsDTO();
			retorno.setPts(new ArrayList<PtDTO>());
			e.printStackTrace();
		} finally {
			ptrn.finalizaConexaoBanco();
		}
		ptrn = null;
		return retorno;
	}

	public PTsDTO getPtsSemCnc() {
		PTRN ptrn = new PTRN();
		PTsDTO retorno;
		try {
			ptrn.iniciaConexaoBanco();
			retorno = ptrn.getPtsSemCnc();
		} catch (RegistroDesconhecidoException e) {
			retorno = new PTsDTO();
			retorno.setPts(new ArrayList<PtDTO>());
			e.printStackTrace();
		} finally {
			ptrn.finalizaConexaoBanco();
		}
		ptrn = null;
		return retorno;
	}

	public DwRotapasso getOmPtDwRotapasso(DwRotapasso rotapasso) {
		DwRotapasso retorno;
		PTRN ptrn = new PTRN();
		try {
			ptrn.iniciaConexaoBanco();
			retorno = ptrn.getOmPtDwRotapasso(rotapasso);
		} catch (RegistroDesconhecidoException e) {
			retorno = new DwRotapasso();
		}
		ptrn.finalizaConexaoBanco();
		return retorno;
	}

	public DwRota getDwRota(String cdRota) {
		DwRota retorno = null;
		RoteiroRN rn = new RoteiroRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarDwRotaByCdRota(cdRota);
			if (retorno == null)
				retorno = new DwRota();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public OmPt pesquisarOmPtAPartiDePara(String dePara) {
		PTRN rn = new PTRN();
		OmPt ompt = null;
		try {
			rn.iniciaConexaoBanco();
			ompt = rn.pesquisarPtLikeDeParaPtStAtivo(dePara);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return ompt;
	}

	public OmPt pesquisarOmPtAPartiCdPt(String cdPt) {
		PTRN rn = new PTRN();
		OmPt ompt = null;
		try {
			rn.iniciaConexaoBanco();
			ompt = rn.pesquisarPtByCdPtStAtivo(cdPt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return ompt;
	}

	public PlanoListDTO pesquisarPlanoECPs(PlanoDTO planoDTO) {
		ManipulacaoCpsGeradasRN rn = new ManipulacaoCpsGeradasRN();
		PlanoListDTO retorno = null;
		try {
			rn.iniciaConexaoBancoStatless();
			retorno = rn.pesquisarPlanoECPs(planoDTO);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			rn.finalizaConexaoBancoStatless();
		}
		rn = null;
		return retorno;
	}

	public PtGtDTO pesquisarCentrosTrabalho() {
		ManipulacaoCpsGeradasRN rn = new ManipulacaoCpsGeradasRN();
		PtGtDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarCentrosTrabalho();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PtGtDTO pesquisarCentrosComCPsDeProdutosIguais(OmProduto produto) {
		ManipulacaoCpsGeradasRN rn = new ManipulacaoCpsGeradasRN();
		PtGtDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarCentrosComCPsDeProdutosIguais(produto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PlanoDTO salvarPlanoManipulacao(PlanoDTO plano) {
		ManipulacaoCpsGeradasRN rn = new ManipulacaoCpsGeradasRN(plano);
		PlanoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.salvarRegistro(plano);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public EstoquesDTO pesquisarEstoqueMateriaPrima(String cdEst, String cdProduto, String cdCliente) {
		EstoqueRN rn = new EstoqueRN();
		Session sessao = null;
		EstoquesDTO retorno = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.getDao().setSession(sessao);
			retorno = rn.pesquisarEstoqueMateriaPrima(cdEst, cdProduto, cdCliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}

		rn = null;
		return retorno;
	}

	public PTsDTO pesquisarOmPtsAtivos() {
		ApontamentoManualRN rn = new ApontamentoManualRN();
		PTsDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarOmPts();
		} catch (RegistroDesconhecidoException e) {
			retorno = new PTsDTO();

		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;

	}

	public ProdutoDTO importarPlanilhaEstruturaProduto(ProdutoDTO produto) {
		ProdutoDTO retorno = null;
		ProdutoRN rn;
		rn = new ProdutoRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.importarPlanilhaEstruturaProduto(produto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	/*
	public ProdutoDTO importarPlanilhaComponente(ProdutoDTO produto) {
        ProdutoDTO retorno = null;
        ProdutoRN rn;
        rn = new ProdutoRN();
        try {
            rn.iniciaConexaoBanco();
            retorno = rn.importarPlanilhaComponente(produto);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            rn.finalizaConexaoBanco();
        }
	}*/
	
	public SapEstoquesDTO getSapEstoquesDTO(SapEstoqueDTO sapestoquedto) {
		ImportacaoMatPrimaSapRN rn = new ImportacaoMatPrimaSapRN();
		SapEstoquesDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getSapEstoquesDTO(sapestoquedto);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DwConsolidDTOs pesquisarApontamentoProducao(DwConsolidDTO dto) {
		ApontamentoManualRN rn = new ApontamentoManualRN();
		DwConsolidDTOs retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarApontamentoProducao(dto);
		} catch (RegistroDesconhecidoException e) {
			retorno = new DwConsolidDTOs();

		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ListaCPDTO pesquisarCpComPedido(PpCp cp) {
		CpRN rn = new CpRN();
		ListaCPDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarCpComPedido(cp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public PpNecListDTO pesquisarTodosCpComPedidoAtivo() {
		CpRN rn = new CpRN();
		PpNecListDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarTodosCpComPedidoAtivo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public ListaCPDTO pesquisaListaPredecessoraCP(Long idCp) {
		CpRN rn = new CpRN();
		ListaCPDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaListaPredecessoraCP(idCp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwTurnosDTO pesquisarTurnos() {
		DwTurnoRN rn = new DwTurnoRN();
		DwTurnosDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarTurnos();
		} catch (RegistroDesconhecidoException e) {
			retorno = new DwTurnosDTO();
			retorno.setResultadoEvento(retorno.getNenhumResultadoEncontrado());

		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public SapConhecimentosDTO getSapConhecimentosDTO(SapConhecimentoDTO sapconhecimentodto) {
		ImportacaoMatPrimaSapRN rn = new ImportacaoMatPrimaSapRN();
		SapConhecimentosDTO retorno = null;

		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getSapConhecimentosDTO(sapconhecimentodto);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public TmgConhecimentosDTO getTmgConhecimentosDTO(TmgConhecimentoDTO tmgconhecimentodto) {
		ImportacaoMatPrimaSapRN rn = new ImportacaoMatPrimaSapRN();
		TmgConhecimentosDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTmgConhecimentosDTO(tmgconhecimentodto);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DwFolhasDTO pesquisaProdutoNaFolha(String cdProduto, long idpt) {
		FolhaRN rn = new FolhaRN();
		DwFolhasDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaProdutoNaFolha(cdProduto, idpt);
		} catch (Exception e) {
			retorno = new DwFolhasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public void salvarApontamentoManual(DwConsolidDTOs dtos) {
		ApontamentoManualRN rn = new ApontamentoManualRN();
		try {
			rn.iniciaConexaoBanco();
			rn.salvarApontamento(dtos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return;
	}

	public DsEspecializaAponDTO getEspecializaApon() {
		ApontamentoManualRN rn = new ApontamentoManualRN();
		DsEspecializaAponDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getEspecializaApon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public MsTpEvtsDTO pesquisarMsTpEvts() {
		AlertaPlanejamentoRN rn = new AlertaPlanejamentoRN();
		MsTpEvtsDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarMsTpEvts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public OmTpptDTO pesquisaOmTppts() {
		AlertaPlanejamentoRN rn = new AlertaPlanejamentoRN();
		OmTpptDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarOmTppts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public MsIndsDTO pesquisaInds() {
		AlertaPlanejamentoRN rn = new AlertaPlanejamentoRN();
		MsIndsDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaInds();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public MsDetectorDTO salvarAlertaPlanejamento(MsDetectorDTO dto) {
		AlertaPlanejamentoRN rn = new AlertaPlanejamentoRN();
		MsDetectorDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.salvarAlertaPlanejamento(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public PerfisAndonDTO getMsPerfilandon(PerfilAndonDTO filtro) {
		PerfilAndonRN rn = new PerfilAndonRN();
		PerfisAndonDTO retorno = new PerfisAndonDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getMsPerfilandon(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PerfisAndonDTO getPerfilAndonsAtivos() {
		PerfilAndonRN rn = new PerfilAndonRN();
		PerfisAndonDTO retorno = new PerfisAndonDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getPerfilAndonsAtivos();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PerfilAndonDTO setMsPerfilandon(PerfilAndonDTO dto) {
		PerfilAndonRN rn = new PerfilAndonRN();
		PerfilAndonDTO retorno = new PerfilAndonDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setMsPerfilandon(dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PerfilAndonDTO excluirPerfilAndon(PerfilAndonDTO dto) {
		PerfilAndonRN rn = new PerfilAndonRN();
		PerfilAndonDTO retorno = new PerfilAndonDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.excluirPerfilAndon(dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public MsDetectorsDTO pesquisarMsDetector(MsDetectorDTO dto) {
		AlertaPlanejamentoRN rn = new AlertaPlanejamentoRN();
		MsDetectorsDTO retorno = new MsDetectorsDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarMsDetector(dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public MsDetectorDTO excluirMsDetectors(MsDetectorsDTO msDetectorsDTO) {
		AlertaPlanejamentoRN rn = new AlertaPlanejamentoRN();
		MsDetectorDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.excluirMsDetectors(msDetectorsDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public PlanosIndisponibilidadesDTO pesquisarPlanoIndisponibilidade(PlanoIndisponibilidadeDTO plano) {
		PlanoIndisponibilidadeRN rn = new PlanoIndisponibilidadeRN();
		PlanosIndisponibilidadesDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarPlanos(plano);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PlanoIndisponibilidadeDTO salvarPlanoIndisponibilidade(PlanoIndisponibilidadeDTO plano) {
		PlanoIndisponibilidadeRN rn = new PlanoIndisponibilidadeRN(plano);
		PlanoIndisponibilidadeDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.salvarRegistro();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PlanoIndisponibilidadeDTO excluirPlanoIndisponibilidade(PlanoIndisponibilidadeDTO plano) {
		PlanoIndisponibilidadeRN rn = new PlanoIndisponibilidadeRN(plano);
		PlanoIndisponibilidadeDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.excluirRegistro();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PlanoListDTO pesquisarPlanosPlanejamentoProducao(PlanoDTO plano) {
		PlanejamentoProducaoRN rn = new PlanejamentoProducaoRN();
		PlanoListDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarPlanosAtivosParaPlanoListDTO(plano);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PlanoAcompanhamentoDTOList pesquisarAcompanhamentosDoPlano(PlanoAcompanhamentoDTO planoAcomp) {
		PlanoAcompanhamentoDTOList retorno = null;
		MonitorizacaoPPRN acompRN = new MonitorizacaoPPRN();
		try {
			acompRN.iniciaConexaoBanco();
			retorno = acompRN.capturarAcompanhamentos(planoAcomp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			acompRN.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ResultadoImportacaoSapDTO importarSap(UsuarioDTO usrlogadodto) {
		ImportacaoMatPrimaSapRN rn = new ImportacaoMatPrimaSapRN();
		ResultadoImportacaoSapDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.importarSap(usrlogadodto);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PlanoDTO simularPlano(PlanoDTO plano) {
		SimulacaoRN rn = new SimulacaoRN(plano);
		PlanoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.simularPlano();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rn.finalizaConexaoBanco();
			} catch (Exception e) {
				e.printStackTrace();
				retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().getERRO_DESCONHECIDO());
			}
		}
		rn = null;
		return retorno;
	}

	public PpCmDTO salvarCmEstrutura(PpCmDTO itemDto) {
		PpCmRN rn = new PpCmRN();
		PpCmDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.salvarCmEstrutura(itemDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public PpCmsDTO pesquisarPpCm(PpCmDTO itemDTO) {
		PpCmRN rn = new PpCmRN();
		PpCmsDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarPpCm(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwEstlocalsDTO getDwEstlocal(DwEstlocalDTO filtro) {
		LocalEstoqueRN rn = new LocalEstoqueRN();
		DwEstlocalsDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDwEstlocal(filtro);
		} catch (Exception e) {
			retorno = new DwEstlocalsDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DwEstlocalDTO setDwEstlocal(DwEstlocalDTO filtro) { // Here rollback
																// transacao
		LocalEstoqueRN rn = new LocalEstoqueRN();
		DwEstlocalDTO retorno = new DwEstlocalDTO();
		retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setDwEstlocal(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
			return retorno;
		} finally {
			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				rn.rollbackTransacao();
			}
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwEstlocalDTO removeDwEstlocal(DwEstlocalDTO filtro) {
		LocalEstoqueRN rn = new LocalEstoqueRN();
		DwEstlocalDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeDwEstlocal(filtro);
		} catch (Exception e) {
			retorno = new DwEstlocalDTO();
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DwconsolestlocalprosDTO getConsultaLocalEstoque(FiltroConsolLocalEstoqueDTO filtro) {
		EstoqueRN rn = new EstoqueRN();
		DwconsolestlocalprosDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getConsultaLocalEstoque(filtro);
		} catch (Exception e) {
			retorno = new DwconsolestlocalprosDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwEstlocalprosDTO getDwEstlocalpros(FiltroConsolLocalEstoqueDTO filtro) {
		EstoqueRN rn = new EstoqueRN();
		DwEstlocalprosDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDwEstlocalpros(filtro);
		} catch (Exception e) {
			retorno = new DwEstlocalprosDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public PpCmDTO removePpCm(PpCmDTO itemDTO) {
		PpCmRN rn = new PpCmRN();
		PpCmDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.excluirRegistro(itemDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public ResultadoImportacaoSapDTO importarPlanilhaSAP(SapEstoquesDTO estoques, UsuarioDTO usuario) {
		ImportacaoPlanilhaComMatPrimaSapRN rn = new ImportacaoPlanilhaComMatPrimaSapRN();
		rn.setSapestoques(estoques.getSapestoques());
		ResultadoImportacaoSapDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.importarPlanilha(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public FolhasDTO importarPlanilhaCiclos(FolhasDTO folhas, UsuarioDTO usuario) {
		ImportacaoPlanilhaCiclosRN rn = new ImportacaoPlanilhaCiclosRN();
		FolhasDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.importarPlanilha(folhas, usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwConsolidDTOs importarPlanilhaProducao(DwConsolidDTOs apontamentos, UsuarioDTO usuario) {
		ImportacaoPlanilhaProducaoRN rn = new ImportacaoPlanilhaProducaoRN();
		DwConsolidDTOs retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.importarPlanilha(apontamentos, usuario);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public CpsDTO pesquisarCpByProdutoFinal(String cdproduto) {
		CpRN rn = new CpRN();
		CpsDTO retorno = new CpsDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarCpByProdutoFinal(cdproduto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public CpsDTO pesquisarProximosCpsPorUsuario(String cdUsuario) {
		CpRN rn = new CpRN();
		CpsDTO retorno = new CpsDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarProximosCpsPorUsuario(cdUsuario);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DetalheMonitorizacaoPTInjetDTO getDetalheMonitorizacaoPtInjetDTO(FiltroDetalhePTInjetDTO filtro) {
		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN();
		DetalheMonitorizacaoPTInjetDTO retorno = new DetalheMonitorizacaoPTInjetDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDetalheMonitorizacaoPtInjetDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DwFolhasDTO getDwFolhasPorCod(FolhaDTO filtro) {
		FolhaRN rn = new FolhaRN();
		DwFolhasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDwFolhasPorCod(filtro);
		} catch (Exception e) {
			retorno = new DwFolhasDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ProdutosDTO pesquisarProdutosPaiDisponiveis(Long idProduto) {
		ProdutoRN rn = new ProdutoRN();
		ProdutosDTO produtosDTO = null;
		try {
			rn.iniciaConexaoBanco();
			produtosDTO = rn.pesquisarProdutosPaiDisponiveis(idProduto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return produtosDTO;
	}

	// Se for insert true; senão(IDW) false
	public boolean isConsolidarParaInsert() {
		return this.isConsolidarParaInsert;
	}

	public boolean isConsolidarParaIDW() {
		return this.isConsolidarParaIDW;
	}

	public TurnosDTO getTodosOsTurnos() {
		TurnosDTO retorno = new TurnosDTO();
		TurnoRN rn = new TurnoRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTurnos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public ProdutosDTO getTodosProdutosDTO() {
		ProdutosDTO retorno = new ProdutosDTO();
		ProdutoRN rn = new ProdutoRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTodosProdutosDTO();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public UsuariosDTO getOperadoresAtivos() {
		UsuarioRN rn = new UsuarioRN();
		UsuariosDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOperadoresAtivos();
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new UsuariosDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwRapListDTO getDwRapAtivos() {
		DwRapListDTO retorno = new DwRapListDTO();
		DwRapRN rn = new DwRapRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDwRapAtivos();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwRapListDTO getRapsDoGrupoRap(DwGrupoFerramenta grupo) {
		DwRapListDTO retorno = new DwRapListDTO();
		GrupoFerramentaRN rn = new GrupoFerramentaRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRapsDoGrupoRap(grupo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public GraficoDetalhePtDTO getGraficoDetalhePtDTO(FiltroGraficoDetalhePtDTO filtro) {
		DetalheMonitorizacaoGraficoAreaResponsavelRN rn = new DetalheMonitorizacaoGraficoAreaResponsavelRN();
		GraficoDetalhePtDTO retorno = new GraficoDetalhePtDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoDetalhePtDTO(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public GraficoDetalhePtFornoDTO getGraficoDetalhePtFornoDTO(FiltroGraficoDetalhePtDTO filtro) {
		GraficoDetalhePtFornoDTO retorno = new GraficoDetalhePtFornoDTO();
		DetalheMonitorizacaoPTFornoRN rn = new DetalheMonitorizacaoPTFornoRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoPtForno(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public RelatorioProcedimentoDTO getRelatorioProcedimento(FiltroRelProcedimentoDTO filtro) {
		RelatorioProcedimentoRN rn = new RelatorioProcedimentoRN();
		RelatorioProcedimentoDTO retorno = new RelatorioProcedimentoDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.gerarRelatorioProcedimento(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public GraficoDetalhePtFornoDTO getGraficoDetalhePtFornoDTOAndroid(Long idpt, Long idturno, String dtreferencia, Long idCp) {
		GraficoDetalhePtFornoDTO retorno = new GraficoDetalhePtFornoDTO();
		DetalheMonitorizacaoPTFornoRN rn = new DetalheMonitorizacaoPTFornoRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoPtFornoAndroid(idpt, idturno, dtreferencia, idCp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public ListaPerdasmpDTO getGraficoPerdasMateriaPrima(FiltroGraficoDetalhePtDTO filtro) {
//		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN();
		GraficoPerdaMateriaPrimaRN rn = new GraficoPerdaMateriaPrimaRN();
		ListaPerdasmpDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoPerdasMateriaPrima(filtro);
		} catch (Exception e) {
			retorno = new ListaPerdasmpDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaPerdasmpDTO getGraficoPerdaFerrmantaPorProduto(FiltroGraficoDetalhePtDTO filtro) {
		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN();
		ListaPerdasmpDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoPerdaFerrmantaPorProduto(filtro);
		} catch (Exception e) {
			retorno = new ListaPerdasmpDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaPerdasmpDTO getGraficoPerdaMpPorRap(FiltroGraficoDetalhePtDTO filtro) {
		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN();
		ListaPerdasmpDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoPerdaMpPorRap(filtro);
		} catch (Exception e) {
			retorno = new ListaPerdasmpDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DwTPerdasmpDTO getDwTPerdasmp() {
		PerdampRN rn = new PerdampRN();
		DwTPerdasmpDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDwTPerdasmp();
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new DwTPerdasmpDTO();
			retorno.setDwTPerdamps(new ArrayList<DwTPerdamp>());
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public CiclosDTO getUltimosCiclos(FiltroCiclosDTO filtroCiclosDTO) {
		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN();
		CiclosDTO retorno = new CiclosDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getUltimosCiclos(filtroCiclosDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public CiclosDTO getUltimosCiclosAndroid(Long idPt, Long idCp) {
		DetalheMonitorizacaoPTAndroidRN rn = new DetalheMonitorizacaoPTAndroidRN();
		CiclosDTO retorno = new CiclosDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getUltimosCiclosAndroid(idPt, idCp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public TempoRealDTO getUltimoTempoRealPt(FiltroProducaoDTO filtro) {
		TempoRealRN rn = new TempoRealRN();
		TempoRealDTO retorno = new TempoRealDTO();
		try {
			rn.iniciaConexaoBanco();
			OmPt pt = rn.getDao().findById(OmPt.class, filtro.getListaFiltroProducaoPtCp().get(0).getOmPt().getIdPt(), false);
			DwRt dwRt = null;
			if (filtro.getDtReferencia() == null) {
				dwRt = rn.getUltimoDwRt(pt.getIdPt());
			} else {
				dwRt = rn.getDwRt(filtro.getDtReferencia(), filtro.getDwTurno().getIdTurno(), pt.getIdPt(), null, null);
			}
			if (dwRt != null) {
				dwRt = dwRt.clone();
			}
			retorno.setDwRt(dwRt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public GraficoDetalhePtDTO getGraficoDetalhePtandroidUltimosCiclosDTO(Long idpt, Long idturno, String dtreferencia) {
		DetalheMonitorizacaoPTAndroidRN rn = new DetalheMonitorizacaoPTAndroidRN();
		GraficoDetalhePtDTO retorno = new GraficoDetalhePtDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoDetalhePtandroidUltimosCiclosDTO(idpt, idturno, dtreferencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public GraficoDetalhePtDTO getGraficoDetalhePtandroidUltimosCiclosBIDTO(Long idgt, Long idturno, String dtreferencia) {
		DetalheMonitorizacaoPTAndroidRN rn = new DetalheMonitorizacaoPTAndroidRN();
		GraficoDetalhePtDTO retorno = new GraficoDetalhePtDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoDetalhePtandroidUltimosCiclosBIDTO(idgt, idturno, dtreferencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	/**
	 * @deprecated usar {@link #getTurnoAtualDTO(OmPt, Date)}
	 * @param omPt
	 * @param dtHrRef
	 * @return
	 */
	@Deprecated
	public TurnoAtualDTO getTurnoAtual(OmPt omPt, Date dtHrRef) {
		TurnoRN rn = new TurnoRN();
		TurnoAtualDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTurnoAtualDTOComClone(omPt, dtHrRef);
		} catch (Exception e) {
			retorno = new TurnoAtualDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public TurnoAtualDTO getTurnoAtualGtDTO(OmGt gt, Date dataAtual) {
		TurnoRN rn = new TurnoRN();
		TurnoAtualDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTurnoAtualGtDTO(gt, dataAtual, true);
			if (retorno != null) {
				retorno = retorno.prepararSerializacao();
			} else {
				retorno = new TurnoAtualDTO();
			}
		} catch (Exception e) {
			retorno = new TurnoAtualDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public TurnoAtualDTO getTurnoAtual1PTDTO(Date dataAtual) {
		TurnoRN rn = new TurnoRN();
		TurnoAtualDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTurnoAtual1PTDTO(dataAtual);
			if (retorno != null) {
				retorno = retorno.prepararSerializacao();
			} else {
				retorno = new TurnoAtualDTO();
			}
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new TurnoAtualDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public TurnoAtualDTO getPeriodoTurno(FiltroTurnoDTO filtro) {
		TurnoRN rn = new TurnoRN();
		TurnoAtualDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTurnoAtualDTOPassandoIdPtEDtTurnoEIdTurno(filtro.getOmPt(), filtro.getDtReferencia(), filtro.getDwTurno()
					.getIdTurno());
			if (retorno != null) {
				retorno = retorno.prepararSerializacao();
			}
		} catch (Exception e) {
			retorno = new TurnoAtualDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public TurnoAtualDTO getTurnoAtualDTO(OmPt omPt, Date dtHrRef) {
		TurnoRN rn = new TurnoRN();
		TurnoAtualDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTurnoAtualDTOSemClone(omPt, dtHrRef);
			if (retorno != null) {
				retorno = retorno.prepararSerializacao();
			}
		} catch (Exception e) {
			retorno = new TurnoAtualDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwFolhasDTO getGraficoDetalhePadraoDTO(FiltroGraficoDetalhePtDTO filtro) {
		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN();
		DwFolhasDTO retorno = new DwFolhasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoDetalhePadraoDTO(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public CpsDTO setAdiantamentoDTO(AdiantamentoDTO produtos, PlanoDTO plano) {
		AdiantamentoRN rn = new AdiantamentoRN(plano, produtos);
		CpsDTO retorno = new CpsDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.adiantamentoRn();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public String getMascaraProduto() {
		return mascaraProduto;
	}

	public void setMascaraProduto(String mascaraProduto) {
		this.mascaraProduto = mascaraProduto;
	}

	public DetalhamentoProducaoDTO getDetalhamentoProducao(FiltroDetalheProducaoDTO filtro) {
		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN();
		DetalhamentoProducaoDTO retorno = new DetalhamentoProducaoDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDetalhamentoProducao(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public ListaDetalheAnaliseTurnoDTO getDetalheAnaliseTurnoDTO(FiltroProducaoDTO filtro) {
		AnaliseTurnoRN rn = new AnaliseTurnoRN();
		ListaDetalheAnaliseTurnoDTO retorno;
		try {
			retorno = new ListaDetalheAnaliseTurnoDTO();
			rn.iniciaConexaoBanco();
			retorno = rn.getDetalheAnaliseTurno(filtro);
		} catch (Exception e) {
			retorno = new ListaDetalheAnaliseTurnoDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DetalheAnaliseGargaloDTO getDetalheCelulas(FiltroProducaoDTO filtro) {
		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN();
		DetalheAnaliseGargaloDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDetalheCelulas(filtro);
		} catch (Exception e) {
			retorno = new DetalheAnaliseGargaloDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ParadasDTO getParadasDTO(FiltroRelatorioParadaDTO filtro) {
		ParadaRN rn = new ParadaRN();
		ParadasDTO retorno = new ParadasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getParadasDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public RelatorioDivergenciaDTO getRelatorioDivergencia(FiltroRelDivergenciaDTO filtro) {
		RelatorioDivergenciaRN rn = new RelatorioDivergenciaRN();
		RelatorioDivergenciaDTO retorno = new RelatorioDivergenciaDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioDivergencia(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public OmTpptDTO getOmTpptDTO() {
		TpptRN rn = new TpptRN();
		OmTpptDTO retorno = new OmTpptDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOmTpptDTO();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwTRefugosDTO getRefugosDTO(FiltroRelatorioRefugoDTO filtro) {
		RefugoRN rn = new RefugoRN();
		DwTRefugosDTO retorno = new DwTRefugosDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTRefugosDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwTRefugosDTO getRefugosDTO(Long filtro) {
		RefugoRN rn = new RefugoRN();
		DwTRefugosDTO retorno = new DwTRefugosDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRefugosDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public UsuariosDTO getOMUsuariosDTO(FiltroRelatorioUsuarioDTO filtro) {
		UsuarioRN rn = new UsuarioRN();
		UsuariosDTO retorno = new UsuariosDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOMUsuariosDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public AlertasDTO getAlertasDTO(FiltroRelatorioAlertaDTO filtro) {
		AlertaRN rn = new AlertaRN();
		AlertasDTO retorno = new AlertasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getAlertasDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public List<DwConsolallog> getAlertasDTOAbertosByIdPt(Long idPt) {
		AlertaRN rn = new AlertaRN();
		List<DwConsolallog> retorno = new ArrayList<DwConsolallog>();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getAlertasDTOAbertosByIdPt(idPt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public AlertasDTO getTAlertasDTO(Long filtro) {
		AlertaRN rn = new AlertaRN();
		AlertasDTO retorno = new AlertasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTAlertasDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public AlertasDTO getTAlertasDTO(AlertaDTO filtro) {
		AlertaRN rn = new AlertaRN();
		AlertasDTO retorno = new AlertasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTAlertasDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public AlertaDTO setTAlertaDTO(AlertaDTO filtro) {
		AlertaRN rn = new AlertaRN();
		AlertaDTO retorno = new AlertaDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setTAlertaDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public AlertasDTO removeTAlertasDTO(AlertasDTO filtro) {
		AlertaRN rn = new AlertaRN();
		AlertasDTO retorno = new AlertasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeTAlertasDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwTJustsDTO getTJustificativa(Long idTpPt) {
		JustificativaRN rn = new JustificativaRN();
		DwTJustsDTO retorno = new DwTJustsDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTJustificativa(idTpPt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwTJustsDTO getTJustificativa(DwTJustDTO filtro) {
		JustificativaRN rn = new JustificativaRN();
		DwTJustsDTO retorno = new DwTJustsDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTJustificativa(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwTJustDTO setTJustificativa(DwTJustDTO filtro) {
		JustificativaRN rn = new JustificativaRN();
		DwTJustDTO retorno = new DwTJustDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setTJustificativa(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwTJustsDTO removeTJustificativa(DwTJustsDTO filtro) {
		JustificativaRN rn = new JustificativaRN();
		DwTJustsDTO retorno = new DwTJustsDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeTJustificativa(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwTRitmosDTO getTRitmos(Long idTpPt) {
		RitmoRN rn = new RitmoRN();
		DwTRitmosDTO retorno = new DwTRitmosDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTRitmos(idTpPt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public TodosCiclosDestacandoParadasDTO getTodosCiclosDestacandoParadas(FiltroDetalhePTInjetDTO filtro) {
		RitmoRN rn = new RitmoRN();
		TodosCiclosDestacandoParadasDTO retorno = new TodosCiclosDestacandoParadasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTodosCiclosDestacandoParadas(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwTCausasDTO getTCausa(DwTCausaDTO filtro) {
		CausaRN rn = new CausaRN();
		DwTCausasDTO retorno = new DwTCausasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTCausa(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwTCausasDTO getTCausa(Long idTppt) {
		CausaRN rn = new CausaRN();
		DwTCausasDTO retorno = new DwTCausasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTCausa(idTppt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}
	
	public DwTAcoes getTAcao(Long idTppt) {
		AcaoRN rn = new AcaoRN();
		DwTAcoes retorno = new DwTAcoes();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDwAcao(idTppt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwTCausaDTO setTCausa(DwTCausaDTO filtro) {
		CausaRN rn = new CausaRN();
		DwTCausaDTO retorno = new DwTCausaDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setTCausa(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwTCausasDTO removeTCausa(DwTCausasDTO filtro) {
		CausaRN rn = new CausaRN();
		DwTCausasDTO retorno = new DwTCausasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeTCausa(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwTOrigensDTO getTOrigem(DwTOrigemDTO filtro) {
		OrigemRN rn = new OrigemRN();
		DwTOrigensDTO retorno = new DwTOrigensDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTOrigem(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwTOrigensDTO getTOrigem(Long idTppt) {
		OrigemRN rn = new OrigemRN();
		DwTOrigensDTO retorno = new DwTOrigensDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTOrigem(idTppt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwTOrigemDTO setTOrigem(DwTOrigemDTO filtro) {
		OrigemRN rn = new OrigemRN();
		DwTOrigemDTO retorno = new DwTOrigemDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setTOrigem(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwTOrigensDTO removeTOrigem(DwTOrigensDTO filtro) {
		OrigemRN rn = new OrigemRN();
		DwTOrigensDTO retorno = new DwTOrigensDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeTOrigem(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwTAreasDTO getTArea(DwTAreaDTO filtro) {
		AreaRN rn = new AreaRN();
		DwTAreasDTO retorno = new DwTAreasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTArea(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwTAreaDTO setTArea(DwTAreaDTO area) {
		AreaRN rn = new AreaRN();
		DwTAreaDTO retorno = new DwTAreaDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setTArea(area);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwTAreasDTO removeTArea(DwTAreasDTO filtro) {
		AreaRN rn = new AreaRN();
		DwTAreasDTO retorno = new DwTAreasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeTArea(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public OmCargosDTO getTodosOmCargosAtivos() {
		CargoRN rn = new CargoRN();
		OmCargosDTO retorno = new OmCargosDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTodosOmCargosAtivos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwFolhasDTO getTodasDwFolhasAtivas() {
		FolhaRN rn = new FolhaRN();
		DwFolhasDTO retorno = new DwFolhasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTodasDwFolhasAtivas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwFolhasDTO getDwFolhaDoProcedimento(DwProcedimento dwProcedimento) {
		FolhaRN rn = new FolhaRN();
		DwFolhasDTO retorno = new DwFolhasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDwFolhaDoProcedimento(dwProcedimento);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public OmCargosDTO getOmCargo(OmCargoDTO filtro) {
		CargoRN rn = new CargoRN();
		OmCargosDTO retorno = new OmCargosDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getCargo(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public OmCargoDTO setOmCargo(OmCargoDTO cargo) {
		CargoRN rn = new CargoRN();
		OmCargoDTO retorno = new OmCargoDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setOmCargo(cargo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public OmCargosDTO removeOmCargo(OmCargosDTO filtro) {
		CargoRN rn = new CargoRN();
		OmCargosDTO retorno = new OmCargosDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeOmCargo(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwProcedimentosDTO getDwProcedimento(DwProcedimentoDTO filtro) {
		ProcedimentoRN rn = new ProcedimentoRN();
		DwProcedimentosDTO retorno = new DwProcedimentosDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDwProcedimento(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwNseriesDTO getDwNserie(FiltroRastreamentoNSDTO filtro) {
		RastreamentoNSRN rn = new RastreamentoNSRN();
		DwNseriesDTO retorno = new DwNseriesDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDwNserie(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public RastreamentoNSDTO getRastreamentoNS(FiltroRastreamentoNSDTO filtro) {
		RastreamentoNSRN rn = new RastreamentoNSRN();
		RastreamentoNSDTO retorno = new RastreamentoNSDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRastreamentoNS(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public RastreamentoNaoLidosDTO getRastreamentoNSNaoLido(String nsInicial, String nsFinal) {

		RastreamentoNSRN rn = new RastreamentoNSRN();
		RastreamentoNaoLidosDTO retorno = new RastreamentoNaoLidosDTO();

		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRastreamentoNSNaoLido(nsInicial, nsFinal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DashboardsDTO getDashboardTV(FiltroDashboardDTO filtro) {
		DashboardRN rn = new DashboardRN();
		DashboardsDTO retorno = new DashboardsDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDashboardsDTO(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwProcedimentoDTO setDwProcedimento(DwProcedimentoDTO dwProcedimentoDTO) {
		DwProcedimentoDTO retorno = new DwProcedimentoDTO();
		ProcedimentoRN rn = new ProcedimentoRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setDwProcedimento(dwProcedimentoDTO);
		} catch (Exception e) {
			e.printStackTrace();
			rn.rollbackTransacao();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwProcedimentosDTO removeDwProcedimento(DwProcedimentosDTO filtro) {
		ProcedimentoRN rn = new ProcedimentoRN();
		DwProcedimentosDTO retorno = new DwProcedimentosDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeDwProcedimento(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public List<DwDetativ> getDwDetativ(Long idProcativ) {
		ProcedimentoRN rn = new ProcedimentoRN();
		List<DwDetativ> retorno = new ArrayList<DwDetativ>();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDwDetativ(idProcativ);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public List<DwDetativ> getAllDwDetativs(Long idProcedimento) {
		ProcedimentoRN rn = new ProcedimentoRN();
		List<DwDetativ> retorno = new ArrayList<DwDetativ>();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getAllDwDetativs(idProcedimento);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwDetativ getFoto(Long idDetativ) {
		ProcedimentoRN rn = new ProcedimentoRN();
		DwDetativ retorno = new DwDetativ();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getFoto(idDetativ);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		rn.finalizaConexaoBanco();
		return retorno;
	}

	public String finalizarSetup(AtividadesRealizadasDTO realizadasDTO) {
		ProcedimentoRealizadoRN rn = new ProcedimentoRealizadoRN();
		String retorno = new String();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.finalizarSetup(realizadasDTO);
		} catch (Exception e) {
			rn.rollbackTransacao();
			retorno = "Erro! Tem novamente.";
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwProreaativobs novaObs(Long idProreaativ, String dsObs, Date dthrObs) {
		ProcedimentoRealizadoRN rn = new ProcedimentoRealizadoRN();
		DwProreaativobs retorno = new DwProreaativobs();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.novaObs(idProreaativ, dsObs, dthrObs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwGrpativDTOs getTodosDwGrpativAtivos() {
		GrupoAtivRN rn = new GrupoAtivRN();
		DwGrpativDTOs retorno = new DwGrpativDTOs();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTodosDwGrpativAtivos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwGrpativDTOs getDwGrpativ(DwGrpativDTO filtro) {
		GrupoAtivRN rn = new GrupoAtivRN();
		DwGrpativDTOs retorno = new DwGrpativDTOs();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDwGrpativ(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwGrpativDTO setDwGrpativ(DwGrpativDTO dwGrpativDTO) {
		GrupoAtivRN rn = new GrupoAtivRN();
		DwGrpativDTO retorno = new DwGrpativDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setDwGrpativ(dwGrpativDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwGrpativDTOs removeDwGrpativ(DwGrpativDTOs filtro) {
		GrupoAtivRN rn = new GrupoAtivRN();
		DwGrpativDTOs retorno = new DwGrpativDTOs();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeDwGrpativ(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public ParadasDTO getTParada(DWParadaDTO filtro) {
		ParadaRN rn = new ParadaRN();
		ParadasDTO retorno = new ParadasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTParadasDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DWParadaDTO setTParada(DWParadaDTO filtro) {
		ParadaRN rn = new ParadaRN();
		DWParadaDTO retorno = new DWParadaDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setTparada(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ParadasDTO removeTParada(ParadasDTO filtro) {
		ParadaRN rn = new ParadaRN();
		ParadasDTO retorno = new ParadasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeTparada(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public GTsDTO getGTsDtoAtivos() {
		GTRN gtrn = new GTRN();
		GTsDTO retorno;
		try {
			gtrn.iniciaConexaoBanco();
			retorno = gtrn.getGTsDtoAtivos();
		} catch (RegistroDesconhecidoException e) {
			retorno = new GTsDTO();
			retorno.setGts(new ArrayList<GtDTO>());
			e.printStackTrace();
		} finally {
			gtrn.finalizaConexaoBanco();
		}
		gtrn = null;
		return retorno;
	}
	public GruposTrabalhoDTO getGTsDtoAtivosSemPt() {
		GTRN gtrn = new GTRN();
		GruposTrabalhoDTO retorno;
		try {
			gtrn.iniciaConexaoBanco();
			retorno = gtrn.getGTsDtoAtivosSemPt();
		} catch (RegistroDesconhecidoException e) {
			retorno = new GruposTrabalhoDTO();
			e.printStackTrace();
		} finally {
			gtrn.finalizaConexaoBanco();
		}
		gtrn = null;
		return retorno;
	}

	public List<GtDTO> getGTsComLayoutDTOAndroid() {
		GtDTO gt = new GtDTO();
		GTsDTO retorno = new GTsDTO();
		GTRN rn = new GTRN();
		Session sessao = null;
		List<GtDTO> gtDTOs = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			retorno = rn.getGTsComLayoutDTO(gt);
			gtDTOs = retorno.getGts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}

		rn = null;
		return gtDTOs;
	}

	public boolean setTr_alertaInicio(String idUp, String cdAlerta, Date dthrInicio) {
		AlertaPdbaMsEvtRN rn = new AlertaPdbaMsEvtRN();
		return rn.setTr_alertaInicio(idUp, cdAlerta, dthrInicio);
	}

	public boolean setTr_alertaFim(String idUp, String cdAlerta, Date dthrFim) {
		AlertaPdbaMsEvtRN rn = new AlertaPdbaMsEvtRN();
		return rn.setTr_alertaFim(idUp, cdAlerta, dthrFim);
	}

	public ListaRelatorioIndiceParadaDTO getRelatorioIndiceParadas(FiltroRelatorioIndiceParadasDTO filtro) {
		RelatorioIndiceParadasRN rn = new RelatorioIndiceParadasRN();
		ListaRelatorioIndiceParadaDTO retorno = new ListaRelatorioIndiceParadaDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioIndiceParadas(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public RelatorioIndiceParadaPtDTO getDadosRelatorioParadasPorMaquina(FiltroRelatorioIndiceParadasDTO filtro) {
		RelatorioParadaPorPtRN rn = new RelatorioParadaPorPtRN();
		RelatorioIndiceParadaPtDTO retorno = new RelatorioIndiceParadaPtDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDadosRelatorioParadasPorMaquina(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DadosRelEficienciaSetupDTO getRelatorioEficienciaSetup(FiltroRelatorioIndiceParadasDTO filtro) {
		RelatorioEficienciaSetupRN rn = new RelatorioEficienciaSetupRN();
		DadosRelEficienciaSetupDTO retorno = new DadosRelEficienciaSetupDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioEficienciaSetup(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaRelatorioParadasInicioProcessoDTO getRelatorioParadasInicioProcessoDTO(FiltroRelatorioIndiceParadasDTO filtro) {
		RelatorioEficienciaSetupRN rn = new RelatorioEficienciaSetupRN();
		ListaRelatorioParadasInicioProcessoDTO retorno = new ListaRelatorioParadasInicioProcessoDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioEficienciaSetupComParadas(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ItemRelatorioFichaTecnica getRelatorioFichaTecnica(ProdutoDTO filtro) {
		RelatorioFichaTecnicaRN rn = new RelatorioFichaTecnicaRN();
		ItemRelatorioFichaTecnica retorno = new ItemRelatorioFichaTecnica();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioFichaTecnica(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public RelatorioPlanejamentoRealizadoDTO getRelatorioPlanejamentoRealizado(FiltroRelatorioPlanejamentoRealizadoDTO filtro) {
		RelatorioPlanejamentoRealizadoRN rn = new RelatorioPlanejamentoRealizadoRN();
		RelatorioPlanejamentoRealizadoDTO retorno = new RelatorioPlanejamentoRealizadoDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioPlanejamentoRealizado(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public RelatorioPeriodoSemOpDTO getRelatorioPeriodoSemOp(FiltroRelatorioPeriodoSemOpDTO filtro) {
		RelatorioPeriodoSemOpRN rn = new RelatorioPeriodoSemOpRN();
		RelatorioPeriodoSemOpDTO retorno = new RelatorioPeriodoSemOpDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioPeriodoSemOp(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public RelatorioProdutoClasseDTO getRelatorioProdutoClasse(FiltroRelatorioAlertaDTO filtro) {
		RelatorioProdutosClasseRN rn = new RelatorioProdutosClasseRN();
		RelatorioProdutoClasseDTO retorno = new RelatorioProdutoClasseDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioProdutoClasse(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public RelatorioCavInativasDTO getRelatorioCavidadeInativas(FiltroRelCavInativaDTO filtro) {
		RelatorioCavInativasRN rn = new RelatorioCavInativasRN();
		RelatorioCavInativasDTO retorno = new RelatorioCavInativasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioCavidadeInativas(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public RelatorioAnaliseCicloDTO getRelatorioAnaliseCiclo(FiltroRelDivergenciaDTO filtro) {
		RelatorioAnaliseCicloRN rn = new RelatorioAnaliseCicloRN();
		RelatorioAnaliseCicloDTO retorno = new RelatorioAnaliseCicloDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioAnaliseCiclo(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public RelatorioMaquinasCriticasDTO getRelatorioMaquinasCriticas(FiltroRelMaqCriticaDTO filtro) {
		RelatorioMaquinaCriticaRN rn = new RelatorioMaquinaCriticaRN();
		RelatorioMaquinasCriticasDTO retorno = new RelatorioMaquinasCriticasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioMaquinasCriticas(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ParadasDTO getListaParadasAtivas(OmTppt tppt) {
		ParadaRN rn = new ParadaRN();
		ParadasDTO retorno = new ParadasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getListaParadasAtivas(tppt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public IwsCicloDTO setTr_paradaInicio(String idUp, Date dthrInicio, Boolean isParadaAutomatica, Boolean isParadaPersistente,
			Boolean isParPeriodSemConex) {
		ParadaPdbaMsEvtRN rn = new ParadaPdbaMsEvtRN();
		return rn.setTr_paradaInicio(idUp, dthrInicio, isParadaAutomatica, isParadaPersistente, isParPeriodSemConex);
	}

	public boolean setTr_paradaFim(String idUp, Date dthrFim) {
		ParadaPdbaMsEvtRN rn = new ParadaPdbaMsEvtRN();
		return rn.setTr_paradaFim(idUp, dthrFim);
	}

	public boolean setTr_paradaMotivo(String idUp, Date dthr, String idParada, String idAcao, String idCausa, String idJustificativa,
			String idTecnicoResponsavel, String idTecnicoUm, String idTecnicoDois, String idLocal, boolean isParadaRegulagem,
			String tipoParPreConfig, int batidas) {
		ParadaPdbaMsEvtRN rn = new ParadaPdbaMsEvtRN();
		return rn.setTr_paradaMotivo(idUp, dthr, idParada, idAcao, idCausa, idJustificativa, idTecnicoResponsavel, idTecnicoUm,
				idTecnicoDois, idLocal, isParadaRegulagem, tipoParPreConfig, batidas);
	}

	public IwsParadaDTO getTr_TabParadaSetaCod(String idUp, String cdParada) {
		ParadaPdbaMsEvtRN rn = new ParadaPdbaMsEvtRN();
		return rn.getTr_TabParadaSetaCod(idUp, cdParada);
	}

	public IwsCicloDTO setTr_CicloInicio(String idUp, Date dthr, IwsDadosApontamentoDTO dados) {
		ProducaoPdbaMsEvtRN rn = new ProducaoPdbaMsEvtRN();
		return rn.setTr_CicloInicioComInfo(idUp, dthr, dados);
	}

	public IwsReleDTO setTr_CicloFim(String idUp, Date dthr, IwsDadosApontamentoDTO dados) throws FalhaSnapshot {
		// Date inicio = new Date();
		ProducaoPdbaMsEvtRN rn = new ProducaoPdbaMsEvtRN();
		IwsReleDTO retorno = rn.setTr_CicloFim(idUp, dthr, dados);
		return retorno;
	}

	public boolean fimPlanejamento(String idUp, Date dthr, int batidas) {
		ProducaoPdbaMsEvtRN rn = new ProducaoPdbaMsEvtRN();
		return rn.fimPlanejamento(idUp, dthr, batidas);
	}

	public IwsCpDTO getTr_planejamento(String idUp, IwsCpDTO cpEntrada, Date dthr) {
		ProducaoPdbaMsEvtRN rn = new ProducaoPdbaMsEvtRN();
		return rn.getTr_planejamento(idUp, cpEntrada, dthr);
	}

	public IwsRefugoDTO getInfoUltimoRefugo(String idUp) {
		ProducaoPdbaMsEvtRN rn = new ProducaoPdbaMsEvtRN();
		return rn.getInfoUltimoRefugo(idUp);
	}

	public IwsHorarioDTO setUPBeatMac(String mac, Date dthrBeat) {
		HeartBeatPdbaMsEvtRN rn = new HeartBeatPdbaMsEvtRN();
		return rn.setUPBeatMac(mac, dthrBeat);
	}

	public IwsHorarioDTO setUPBeat(String mac, Date dthrBeat, boolean isLogoutNaViradaTurno, boolean isFechaParadaNaViradaTurno) {
		HeartBeatPdbaMsEvtRN rn = new HeartBeatPdbaMsEvtRN();
		return rn.setUPBeat(mac, dthrBeat, isLogoutNaViradaTurno, isFechaParadaNaViradaTurno);
	}

	public IwsListaUpDTO getTr_inicializacao(String mac, boolean comParadaSemConexao, boolean comParadaDefault, Date dtHr) {
		HeartBeatPdbaMsEvtRN rn = new HeartBeatPdbaMsEvtRN();
		return rn.getTr_inicializacao(mac, comParadaSemConexao, comParadaDefault, dtHr);
	}

	public IwsListaUpDTO inicializacaoSemEvento(String mac) {
		HeartBeatPdbaMsEvtRN rn = new HeartBeatPdbaMsEvtRN();
		return rn.inicializacaoSemEvento(mac);
	}

	public IwsErroDTO setTr_operadorInicio(String idUp, String cdOperador, Date dthrInicio) {
		MaoDeObraPdbaMsEvtRN rn = new MaoDeObraPdbaMsEvtRN();
		return rn.setTr_operadorInicio(idUp, cdOperador, dthrInicio);
	}

	public IwsErroDTO setTr_operadorFim(String idUp, String cdOperador, Date dthrFim, Date dthrInicio) {
		MaoDeObraPdbaMsEvtRN rn = new MaoDeObraPdbaMsEvtRN();
		return rn.setTr_operadorFim(idUp, cdOperador, dthrFim, dthrInicio);

	}

	public DetalheMonitorizacaoPTInjetDTO getDetalheMonitorizacaoPTAndroid(String dtreferencia, Long iddwconsolid,
			String dtreferenciainicial, String dtreferenciafinal, Long idturno, Long iddwrap, Long idpt, Long idgt, Long idproduto,
			String cdCp) {
		DetalheMonitorizacaoPTAndroidRN rn = new DetalheMonitorizacaoPTAndroidRN();
		DetalheMonitorizacaoPTInjetDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.getDetalheMonitorizacaoPTAndroid(dtreferencia, iddwconsolid, dtreferenciainicial, dtreferenciafinal, idturno,
					iddwrap, idpt, idgt, idproduto, cdCp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return itemRetorno;
	}

	public DetalhamentoProducaoDTO getDetalhamentoProducaoDTOAndroid(Long iddwconsolid, String dtreferenciainicial,
			String dtreferenciafinal, Long idpt) {
		DetalheMonitorizacaoPTAndroidRN rn = new DetalheMonitorizacaoPTAndroidRN();
		DetalhamentoProducaoDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.getDetalhamentoProducaoDTOAndroid(iddwconsolid, dtreferenciainicial, dtreferenciafinal, idpt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return itemRetorno;
	}

	public GraficoDetalhePtDTO getGraficoDetalhePTandroidDTO(Long idpt, Long idturno, Long idfolha, String dtReferencia,
			String dtReferenciainicial, String dtReferenciafinal, Long idCp, String tpId, int limiteMaxResult) {
		DetalheMonitorizacaoPTAndroidRN rn = new DetalheMonitorizacaoPTAndroidRN();
		GraficoDetalhePtDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.getGraficoDetalhePTandroidDTO(idpt, idturno, idfolha, dtReferencia, dtReferenciainicial, dtReferenciafinal,
					idCp, tpId, limiteMaxResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return itemRetorno;
	}

	public GraficoDetalhePtDTO getGraficoDetalhePtAndroidDTOPorHora(Long idpt, String dtReferenciainicial, String dtReferenciafinal) {
		DetalheMonitorizacaoPTAndroidRN rn = new DetalheMonitorizacaoPTAndroidRN();
		GraficoDetalhePtDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.getGraficoDetalhePtAndroidDTOPorHora(idpt, dtReferenciainicial, dtReferenciafinal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return itemRetorno;
	}

	public GraficoDetalhePtDTO getGraficoDetalhePTandroidBIDTO(Long idgt, Long idturno, Long idfolha, String dtReferencia,
			String dtReferenciainicial, String dtReferenciafinal) {
		DetalheMonitorizacaoPTAndroidRN rn = new DetalheMonitorizacaoPTAndroidRN();
		GraficoDetalhePtDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.getGraficoDetalhePTandroidBIDTO(idgt, idturno, idfolha, dtReferencia, dtReferenciainicial, dtReferenciafinal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return itemRetorno;
	}

	public DwFolhasDTO getGraficoDetalhePadraoandroidDTO(Long idpt, Long idfolha, String dtreferencia) {
		DetalheMonitorizacaoPTAndroidRN rn = new DetalheMonitorizacaoPTAndroidRN();
		DwFolhasDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.getGraficoDetalhePadraoandroidDTO(idpt, idfolha, dtreferencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return itemRetorno;
	}

	public DwFolhasDTO getGraficoDetalhePadraoandroidBIDTO(Long idgt, Long idfolha, String dtreferencia) {
		DetalheMonitorizacaoPTAndroidRN rn = new DetalheMonitorizacaoPTAndroidRN();
		DwFolhasDTO itemRetorno = null;
		try {
			rn.iniciaConexaoBanco();
			itemRetorno = rn.getGraficoDetalhePadraoandroidBIDTO(idgt, idfolha, dtreferencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return itemRetorno;
	}

	public void setEventosInsert(EventoDTO eventoDTO) throws IllegalArgumentException, Exception {
		EventoInsertParaMsEvtRN rn = new EventoInsertParaMsEvtRN();
		try {
			rn.trataEvento(eventoDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		rn = null;
	}

	public void carregaTabelasBasicas() {
		CargaBasicaRN rn = new CargaBasicaRN();
		try {
			rn.iniciaConexaoBanco();
			rn.carregaTabelasBasicas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

	}

	public ProdutoDTO integracaoEstProduto(ProdutoDTO produto) {
		return IntegracaoEstruturaProduto.integrarProdutoComTransacaoInterna(produto, null, null);
	}

	public void integracaoCM() {
		integrarAlternativoNA();
		integrarAlternativoDireto();
	}

	public void integrarAlternativoNA() {
		final DAOGenerico daoIdw = new DAOGenerico();
		final DAOGenericoErp daoSempToshiba = new DAOGenericoErp();
		Exception exp = null;
		try {
			daoIdw.iniciaConexaoBanco();
			daoSempToshiba.iniciaConexaoBanco();
			IntegracaoCM integracao = new IntegracaoCM(daoIdw, daoSempToshiba);
			integracao.integrarAlternativoNA();
		} catch (Exception e) {
			e.printStackTrace();
			daoIdw.rollBackTransacaoSemException();
			daoSempToshiba.rollBackTransacaoSemException();
			exp = e;
		} finally {
			daoIdw.finalizaConexaoBancoSemException();
			daoSempToshiba.finalizaConexaoBancoSemException();
		}
		if (exp != null) {
			throw new IllegalStateException(exp.getMessage());
		}
	}

	public void integrarAlternativoDireto() {
		final DAOGenerico daoIdw = new DAOGenerico();
		final DAOGenericoErp daoSempToshiba = new DAOGenericoErp();
		Exception exp = null;
		try {
			daoIdw.iniciaConexaoBanco();
			daoSempToshiba.iniciaConexaoBanco();
			IntegracaoCM integracao = new IntegracaoCM(daoIdw, daoSempToshiba);
			integracao.integrarAlternativoDireto();

		} catch (Exception e) {
			e.printStackTrace();
			daoIdw.rollBackTransacaoSemException();
			daoSempToshiba.rollBackTransacaoSemException();
			exp = e;
		} finally {
			daoIdw.finalizaConexaoBancoSemException();
			daoSempToshiba.finalizaConexaoBancoSemException();
		}
		if (exp != null) {
			throw new IllegalStateException(exp.getMessage());
		}
	}

	public void integrarEstoqueFuturo(PeriodoDTO periodoDTO, UsuarioDTO usrlogado) {
		final DAOGenerico daoIdw = new DAOGenerico();
		final DAOGenericoErp daoSempToshiba = new DAOGenericoErp();

		try {
			daoIdw.iniciaConexaoBanco();
			daoSempToshiba.iniciaConexaoBanco();
			IntegracaoEstoque integracao = new IntegracaoEstoque(daoIdw, daoSempToshiba);
			integracao.integrarPrevisaoEstoque(periodoDTO, usrlogado);

		} catch (Exception e) {
			e.printStackTrace();
			daoIdw.rollBackTransacaoSemException();
			daoSempToshiba.rollBackTransacaoSemException();
		} finally {
			daoIdw.finalizaConexaoBancoSemException();
			daoSempToshiba.finalizaConexaoBancoSemException();
		}
	}

	public ProdutosDTO integracaoEstoque(Date dtReferencia, UsuarioDTO usrlogado) {
		// Alessandre em 13-07-16 comentei a linha abaixo para a Inventus pois nao teremos apontamento diario
		// integracaoApontamentoDiario(usrlogado);
		ProdutosDTO prods = new ProdutosDTO();
		prods.setResultado(new ResultadoDTO());
		prods.getResultado().setIdmensagem(prods.getResultado().getERRO_DESCONHECIDO());

		final DAOGenerico daoIdw = new DAOGenerico();
		final DAOGenericoErp daoSempToshiba = new DAOGenericoErp();

		try {
			daoIdw.iniciaConexaoBanco();
			daoSempToshiba.iniciaConexaoBanco();
			IntegracaoEstoque integracao = new IntegracaoEstoque(daoIdw, daoSempToshiba);
			prods = integracao.integrarSaldoInicial(dtReferencia, usrlogado);
		} catch (Exception e) {
			e.printStackTrace();
			prods.getResultado().setIdmensagem(prods.getResultado().getERRO_DESCONHECIDO());
		} finally {
			if (prods == null || prods.getResultado().getIdmensagem() != prods.getResultado().getCOM_SUCESSO()) {
				daoIdw.rollBackTransacaoSemException();
				daoSempToshiba.rollBackTransacaoSemException();
			} else {
				daoIdw.finalizaConexaoBancoSemException();
				daoSempToshiba.finalizaConexaoBancoSemException();
			}
			daoIdw.finalizaSessaoSemException();
			daoSempToshiba.finalizaSessaoSemException();
		}
		return prods;
	}

	public void integracaoApontamentoDiario(UsuarioDTO usrlogado) {
		final DAOGenerico daoIdw = new DAOGenerico();
		final DAOGenericoErp daoSempToshiba = new DAOGenericoErp();

		try {
			daoIdw.iniciaConexaoBanco();
			daoSempToshiba.iniciaConexaoBanco();
			IntegracaoApontamentoDiario integracao = new IntegracaoApontamentoDiario(daoIdw, daoSempToshiba);
			// Se SEMP mudar para testar se eh semp
			if (false)
				integracao.integracaoApontamentoAposTesteEletrico(usrlogado);

		} catch (Exception e) {
			e.printStackTrace();
			daoIdw.rollBackTransacaoSemException();
			daoSempToshiba.rollBackTransacaoSemException();

		} finally {
			daoIdw.finalizaConexaoBancoSemException();
			daoSempToshiba.finalizaConexaoBancoSemException();

		}
	}

	public PpNecListDTO integracaoPlanoProducaoPeriodo(Date dtInicio, Date dtFim, UsuarioDTO usrlogado, boolean integrarProdutos) {
		PpNecListDTO retorno = new PpNecListDTO();
		final DAOGenerico daoIdw = new DAOGenerico();
		final DAOGenericoErp daoSempToshiba = new DAOGenericoErp();

		try {
			daoIdw.iniciaConexaoBanco();
			daoSempToshiba.iniciaConexaoBanco();
			IntegracaoPlanoProducao integracao = new IntegracaoPlanoProducao(daoIdw, daoSempToshiba);

			retorno = integracao.integrar(dtInicio, dtFim, usrlogado, integrarProdutos);
		} catch (Exception e) {
			e.printStackTrace();
			retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().getERRO_DESCONHECIDO());

		} finally {

			if (retorno.getResultadoDTO().getIdmensagem() != retorno.getResultadoDTO().getCOM_SUCESSO()) {
				daoIdw.rollBackTransacaoSemException();
				daoSempToshiba.rollBackTransacaoSemException();
			} else {
				daoIdw.finalizaConexaoBancoSemException();
				daoSempToshiba.finalizaConexaoBancoSemException();
			}
			daoIdw.finalizaSessaoSemException();
			daoSempToshiba.finalizaSessaoSemException();
		}
		return retorno;
	}

	public RoteiroDTO sugestaoRoteiro(String cdProduto) {
		RoteiroRN rn = new RoteiroRN();
		RoteiroDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.sugereRoteiro(cdProduto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DadosRelatorioDTO relatorioPlanejadoRealizado(Date dtInico, Date dtFim) {
		RelatorioDiarioTurnoHoraRN rel = new RelatorioDiarioTurnoHoraRN();
		DadosRelatorioDTO retorno = null;
		try {
			rel.iniciaConexaoBanco();
			retorno = rel.relatorioPlanejadoRealizado(dtInico, dtFim);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rel.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DadosRelatorioDTO relatorioTurnoHora(Date dtRf) {
		RelatorioDiarioTurnoHoraRN rel = new RelatorioDiarioTurnoHoraRN();
		DadosRelatorioDTO retorno = null;
		try {
			rel.iniciaConexaoBanco();
			retorno = rel.relatorioTurnoHora(dtRf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rel.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DadosRelatorioDTO relatorioMapaEscadinha(DadosRelatorioDTO dados) {
		RelatorioMapaEscadinhaRN rel = new RelatorioMapaEscadinhaRN(dados);
		DadosRelatorioDTO retorno = null;
		try {
			rel.iniciaConexaoBanco();
			retorno = rel.geraRelatorioEscadinha();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rel.finalizaConexaoBanco();
		}

		return retorno;
	}

	public ArquivosTrilhaDTO getArquivoTrilha(FiltroExportacaoTrilhaDTO filtro) {
		DAOGenerico dao = new DAOGenerico();
		ArquivosTrilhaDTO retorno = null;
		try {
			dao.iniciaConexaoBanco();
			ExportacaoTrilha rn = new ExportacaoTrilha(dao, filtro);
			retorno = rn.getArquivosTxt();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.finalizaConexaoBancoSemException();
		}
		return retorno;
	}

	public CpDTO pesquisarMpFaltante(Long idCp) {
		MateriaPrimaRN rn = new MateriaPrimaRN();
		CpDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarMpFaltante(idCp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public void salvarNovaPpCp(PpCp ppcp) {
		CpRN rn = new CpRN();
		try {
			rn.iniciaConexaoBanco();
			rn.salvarNovaCp(ppcp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
	}

	public ListaCPDTO getOrdemDeProducao(PpCp filtro) {
		PedidoClienteRN rn = new PedidoClienteRN();
		ListaCPDTO retorno;
		try {
			rn.iniciaConexaoBanco(null);
			retorno = rn.getOrdemDeProducao(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaCPDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ListaCPDTO getOPProdutos(String nrOP) {
		CpRN rn = new CpRN();
		ListaCPDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOPProdutos(nrOP);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaCPDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ListaCPDTO salvarOrdemProducao(ListaCPDTO dto) {
		CpRN rn = new CpRN();
		ListaCPDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.salvarPpCpOrdemProducao(dto);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaCPDTO();
			retorno.setResultado(new ResultadoDTO());
			retorno.getResultado().setIdmensagem(retorno.getResultado().ERRO_DESCONHECIDO);
		} finally {
			try {
				rn.finalizaConexaoBanco();
			} catch (Exception e) {
				e.printStackTrace();
				retorno = new ListaCPDTO();
				retorno.setResultado(new ResultadoDTO());
				retorno.getResultado().setIdmensagem(retorno.getResultado().ERRO_DESCONHECIDO);
			}
		}
		return retorno;
	}

	public CpDTO excluirOrdemProducao(ListaCPDTO dto) {
		CpRN rn = new CpRN();
		CpDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.desativarPpCpOrdemProducao(dto);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new CpDTO();
			retorno.setResultadoDTO(new ResultadoDTO());
			retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().ERRO_DESCONHECIDO);
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public Integer excluirOPSimples(String nrDoc) {
		OpSimplesRN rn = new OpSimplesRN();
		Integer retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.excluirOPSimples(nrDoc);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = 0;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ListaRelatorioProdutividade getRelatorioProdutividade(DwConsolid filtro) {
		RelatorioProdutividadeRN rn = new RelatorioProdutividadeRN();
		ListaRelatorioProdutividade retorno = new ListaRelatorioProdutividade();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioProdutividade(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public GTsDTO getOmGtsAtivosPorTp(int idTpGt) {
		GTRN rn = new GTRN();
		GTsDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOmGtsAtivosPorTp(idTpGt);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new GTsDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ProdutosSemiAcabadosDTO getProdutosSemiAcabados(OmProduto produto) {
		PedidoClienteRN rn = new PedidoClienteRN();
		ProdutosSemiAcabadosDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getProdutosSemiAcabados(produto);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ProdutosSemiAcabadosDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaCPDTO getPpCpsDaFolha(DwFolha folha) {
		CpRN rn = new CpRN();
		ListaCPDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getPpCpsDaFolha(folha);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaCPDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ProdutosDTO getListaProdutosFiltrosBIDTO(FiltroDetalhePTInjetDTO filtro) {
		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN();
		ProdutosDTO retorno = new ProdutosDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getListaProdutosFiltrosBIDTO(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public GraficoBIParetoDTO getGrafBIParetoPerdas(Byte unidadeQtItem, FiltroDetalhePTInjetDTO filtro,
			DetalheMonitorizacaoPTInjetDTO indicadores) {
		GraficoBIParetoPerdasRN rn = new GraficoBIParetoPerdasRN();
		GraficoBIParetoDTO retorno = new GraficoBIParetoDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGrafBIParetoPerdas(unidadeQtItem, filtro, indicadores);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public GraficoBIRecorrenciaDTO getGraficoBIRecorrencia(FiltroDetalhePTInjetDTO filtroBI, Byte tipoRecorrencia, String cdItem) {
		GraficoBIRecorrenciaDTO retorno = new GraficoBIRecorrenciaDTO();
		GraficoRecorrenciaFactory rn = null;
		try {
			rn = GraficoRecorrenciaFactory.getInstancia(tipoRecorrencia);
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoBIParetoRecorrencia(filtroBI, tipoRecorrencia, cdItem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rn != null)
				rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public Double getCicloPadrao(DwFolha dwfolha, OmPt omPt) {
		FolhaRN rn = new FolhaRN();
		Double cicloPadrao = null;
		try {
			rn.iniciaConexaoBanco();
			DwFolhacic dwFolhaCic = new DwFolhacic();
			dwFolhaCic = rn.getFolhacic(dwfolha, omPt);
			cicloPadrao = dwFolhaCic.getSegCiclopadrao().doubleValue();
		} catch (SemCicloPadraoException e) {
			cicloPadrao = dwfolha.getSegCiclopadrao().doubleValue();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return cicloPadrao;
	}

	public Double getPcsPorCicloAtivas(DwFolha dwfolha) {
		Double cavAtiva = null;
		FolhaRN rn = new FolhaRN();
		try {
			rn.iniciaConexaoBanco();
			cavAtiva = rn.getPcsPorCicloAtivas(dwfolha).doubleValue();
		} catch (SemPcsPorCicloAtivasException e) {
			cavAtiva = 1d;
		}
		rn.finalizaConexaoBanco();
		return cavAtiva;
	}

	// Devolve o clone do método
	public List<ColetaParametroDTO> getDadosMedTempPorIdPt(String cdpt) throws RegistroDesconhecidoException {
		FolhaRN rn = new FolhaRN();
		List<ColetaParametroDTO> retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDadosMedTempPorIdPt(cdpt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public PpClientesDTO getPpClientesDTO(PpClienteDTO item) {
		PpClienteRN rn = new PpClienteRN();
		PpClientesDTO retorno = new PpClientesDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getPpClientesDTO(item);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public PpClienteDTO setPpClienteDTO(PpClienteDTO item) {
		PpClienteRN rn = new PpClienteRN();
		PpClienteDTO retorno = new PpClienteDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setPpClienteDTO(item);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public PpClientesDTO removePpClientesDTO(PpClientesDTO itens) {
		PpClienteRN rn = new PpClienteRN();
		PpClientesDTO retorno = new PpClientesDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removePpClientesDTO(itens);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public ListaIndicadoresDTO getProducaoBrutaPt(FiltroProducaoDTO filtro) {
		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN();
		ListaIndicadoresDTO retorno = new ListaIndicadoresDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getProducaoBrutaPt(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwTRefugosDTO getTRefugo(DwTRefugoDTO filtro) {
		RefugoRN rn = new RefugoRN();
		DwTRefugosDTO retorno = new DwTRefugosDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTRefugo(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwTRefugoDTO setTRefugo(DwTRefugoDTO filtro) {
		RefugoRN rn = new RefugoRN();
		DwTRefugoDTO retorno = new DwTRefugoDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setTRefugo(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwTRefugosDTO removeTRefugo(DwTRefugosDTO filtro) {
		RefugoRN rn = new RefugoRN();
		DwTRefugosDTO retorno = new DwTRefugosDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeTRefugo(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	// teste metodo para pesquisar alertas
	public List<DwConsolallog> getDwConsolalComAlertaAberto(OmPt pt) {
		ConsolidaRN rn = new ConsolidaRN();
		List<DwConsolallog> retorno = new ArrayList<DwConsolallog>();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDwConsolalComAlertaAberto(pt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwConsolidDTOs pesquisarDwConsolidByHoraApontamentoManualRefugo(Date dtReferencia, DwTurno dwturno, OmPt ompt, PpCp ppcp,
			String cdproduto, DwPepro dwpepro, DwFolha dwfolha, DwCal dwcal) {

		ConsolidaRN rn = new ConsolidaRN();
		DwConsolidDTOs retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarDwConsolidByHoraApontamentoManualRefugo(dtReferencia, dwturno, ompt, ppcp, cdproduto, dwpepro, dwfolha,
					dwcal);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new DwConsolidDTOs();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	// teste metodo para pesquisar alertas
	public List<DwConsolallog> getDwConsolalComAlertaAberto(String cdPt) {
		ConsolidaRN rn = new ConsolidaRN();
		List<DwConsolallog> retorno = new ArrayList<DwConsolallog>();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDwConsolalComAlertaAberto(cdPt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public IndicadoresMinMetaMaxDTO buscaIndicadoresMinMetaMax(FiltroIndCfg filtro) {
		IndicadorRN rn = new IndicadorRN();
		IndicadoresMinMetaMaxDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.buscaIndicadoresMinMetaMax(filtro);
		} catch (Exception e) {
			retorno = new IndicadoresMinMetaMaxDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public OmPt getOmPt(String cdPt) {
		PTRN rn = new PTRN();
		OmPt retorno = new OmPt();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOmPt(cdPt);
		} catch (RegistroDesconhecidoException e) {
			e.printStackTrace();
		}
		rn.finalizaConexaoBanco();
		return retorno;
	}

	public List<DwFolhamoncomp> getListaDwFolhamoncomp(String cdPt) {
		FolhaRN rn = new FolhaRN();
		List<DwFolhamoncomp> retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getListaDwFolhamoncompOPAtual(cdPt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		rn.finalizaConexaoBanco();
		return retorno;
	}

	public PtDTO getOmPtPorIdOuCd(OmPt filtro) {
		PTRN rn = new PTRN();
		PtDTO retorno = new PtDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOmPtPorIdOuCd(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public MonitorizacaoHierarquicaDTO getMonitorizacaoHierarquicaDTO(FiltroProducaoDTO filtro) {
		MonitorizacaoHierarquicaRN monitorizacaoHierarquicaRN = new MonitorizacaoHierarquicaRN();
		MonitorizacaoHierarquicaDTO monitorizacaoHierarquicaDTO = null;
		try {
			monitorizacaoHierarquicaRN.iniciaConexaoBanco();

			monitorizacaoHierarquicaDTO = monitorizacaoHierarquicaRN.getMonitorizacaoHierarquicaDTO(filtro);

		} catch (Exception e) {
			e.printStackTrace();
			monitorizacaoHierarquicaRN.rollbackTransacao();
		} finally {
			monitorizacaoHierarquicaRN.finalizaConexaoBanco();
		}

		return monitorizacaoHierarquicaDTO;
	}

	public IwsAutenticacaoDTO getTr_Autorizacao(String idUp, String login, String password, int avaliar, Date DataHrAtual,
			Boolean validaPorDsUsuario) {
		MaoDeObraPdbaMsEvtRN rn = new MaoDeObraPdbaMsEvtRN();
		return rn.getTr_Autorizacao(idUp, login, password, avaliar, DataHrAtual, validaPorDsUsuario);
	}

	public IwsAutenticacaoDTO getTr_AutorizacaoLogout(String idUp, String login, String password, Date DataHrAtual,
			Boolean validaPorDsUsuario) {
		MaoDeObraPdbaMsEvtRN rn = new MaoDeObraPdbaMsEvtRN();
		return rn.getTr_AutorizacaoLogout(idUp, login, password, DataHrAtual, validaPorDsUsuario);
	}

	public IwsRefugoDTO getTr_ValidaCodRefugo(String cdMaquina, String cdRefugo) {
		ProducaoPdbaMsEvtRN rn = new ProducaoPdbaMsEvtRN();
		return rn.getTr_ValidaCodRefugo(cdMaquina, cdRefugo);
	}

	public boolean getTr_validaAcao(String cdAcao) {
		CausaAcaoJustPdbaMsEvtRN rn = new CausaAcaoJustPdbaMsEvtRN();
		return rn.getTr_validaAcao(cdAcao);
	}

	public boolean getTr_validaCausa(String cdCausa) {
		CausaAcaoJustPdbaMsEvtRN rn = new CausaAcaoJustPdbaMsEvtRN();
		return rn.getTr_validaCausa(cdCausa);
	}

	public boolean getTr_validaJustificativa(String cdJustificativa) {
		CausaAcaoJustPdbaMsEvtRN rn = new CausaAcaoJustPdbaMsEvtRN();
		return rn.getTr_validaJustificativa(cdJustificativa);
	}

	public IwsAlertaDTO getTr_TabAlertaSetaCod(String cdAlerta) {
		AlertaPdbaMsEvtRN rn = new AlertaPdbaMsEvtRN();
		return rn.getTr_TabAlertaSetaCod(cdAlerta);
	}

	public IwsListaAlertaDTO getTr_alertasAbertos(String cdMaquina) {
		AlertaPdbaMsEvtRN rn = new AlertaPdbaMsEvtRN();
		return rn.getTr_alertasAbertos(cdMaquina);
	}

	public GraficosParettoParadaDTO getGraficoParettoParadaDTO(Date dtReferencia, BigDecimal idTurno, BigDecimal idPt, Boolean isComPeso,
			Boolean isSemPeso, BigDecimal totalParadas, String cdAreaResp, Boolean isConsiderarOP, String cdCp) {
		GraficoParettoParadaRN rn = new GraficoParettoParadaRN();
		GraficosParettoParadaDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoParettoParadaDTO(dtReferencia, idTurno, idPt, isComPeso, isSemPeso, totalParadas, cdAreaResp,
					isConsiderarOP, cdCp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public GraficosParettoParadaDTO getGraficoParettoParadaDTO(Byte tpId, Date dtInicial, Date dtFinal, BigDecimal idTurno, String cdPt,
			String cdCp, Boolean isComPeso, Boolean isSemPeso, BigDecimal totalParadas, String cdAreaResp) {
		GraficoParettoParadaRN rn = new GraficoParettoParadaRN();
		GraficosParettoParadaDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoParettoParadaDTO(tpId, dtInicial, dtFinal, idTurno, cdPt, cdCp, isComPeso, isSemPeso, totalParadas,
					cdAreaResp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public DetalhamentoParadaDTO getOcorrenciaParettoParadaDTO(Date dtReferencia, BigDecimal idTurno, BigDecimal idPt, Boolean isComPeso,
			Boolean isSemPeso, BigDecimal totalParadas, String cdParada) {
		OcorrenciaParettoParadaRN rn = new OcorrenciaParettoParadaRN();
		DetalhamentoParadaDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOcorrenciaParettoParadaDTO(dtReferencia, idTurno, idPt, isComPeso, isSemPeso, cdParada);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public DetalhamentoParadaDTO getOcorrenciasParadas(FiltroParadasDTO filtro) {
		ParadaRN rn = new ParadaRN();

		DetalhamentoParadaDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarOcorrenciasParadas(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new DetalhamentoParadaDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;

		return retorno;
	}

	public DetalhamentoParadaDTO getOcorrenciasParadasREST(FiltroParadasDTO filtro) {
		ParadaRN rn = new ParadaRN();

		DetalhamentoParadaDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarOcorrenciasParadasREST(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new DetalhamentoParadaDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;

		return retorno;
	}

	public boolean corrigeLogParadas(DetalhamentoParadaDTO paradas) {
		CorrecaoParadaRN rn = new CorrecaoParadaRN();
		boolean retorno = true;
		try {
			rn.iniciaConexaoBanco();
			rn.correcaoParadas(paradas);
		} catch (Exception e) {
			retorno = false;
			e.printStackTrace();
			rn.rollbackTransacao();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ParadasDTO getDwTParadasDistinctCdDs() {
		ParadaRN rn = new ParadaRN();
		ParadasDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDwTParadasDistinctCdDs();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ParadasDTO getDwTParadasAtivas() {
		ParadaRN rn = new ParadaRN();
		ParadasDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDwTParadasAtivas();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DetalhamentoParadaDTO getOcorrenciaParettoBIParadaDTO(Date dtInicial, Date dtFinal, BigDecimal idTurno, BigDecimal idPt,
			BigDecimal idGt, Boolean isComPeso, Boolean isSemPeso, BigDecimal totalParadas, String cdParada) {

		OcorrenciaParettoParadaRN rn = new OcorrenciaParettoParadaRN();
		DetalhamentoParadaDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOcorrenciaBIParettoParadaDTO(dtInicial, dtFinal, idTurno, idPt, idGt, isComPeso, isSemPeso, totalParadas,
					cdParada);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public GraficosParettoParadaDTO getGraficoParettoParadaBIDTO(FiltroDetalhePTInjetDTO filtro, Boolean isComPeso, Boolean isSemPeso,
			BigDecimal totalParadas) {
		GraficoParettoParadaRN rn = new GraficoParettoParadaRN();
		GraficosParettoParadaDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoParettoParadaBIDTO(filtro, isComPeso, isSemPeso, totalParadas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public OmProduto pesquisaOmproduto(String cdProduto) {
		ProdutoRN rn = new ProdutoRN();
		OmProduto retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOmProduto(cdProduto).clone(false);
		} catch (Exception e) {
			retorno = new OmProduto();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public PlanoDTO importarArquivoTrilha(FiltroImportacaoTrilhaDTO filtro) {
		ImportacaoArquivoTrilhaPlanoProducao rn = new ImportacaoArquivoTrilhaPlanoProducao();
		PlanoDTO retorno = new PlanoDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.importarPlano(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ListaOmObjDTO obterMonitorizacaoVisaoRoteiro(Date dtReferencia, String cdTurno, String cdProduto) {
		MonitorizacaoVisaoRoteiroRN rn = new MonitorizacaoVisaoRoteiroRN();
		ListaOmObjDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.obterMonitorizacaoVisaoRoteiro(dtReferencia, cdTurno, cdProduto);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaOmObjDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public IwsRefugoDTO setTr_LancaEventoRefugo(String cdRefugo, String cdCausa, String cdAcao, String Quantidade, String IdUp,
			String idRdzProduto, Date DataHrAtual) {
		ProducaoPdbaMsEvtRN rn = new ProducaoPdbaMsEvtRN();
		return rn.setTr_LancaEventoRefugo(cdRefugo, cdCausa, cdAcao, Quantidade, IdUp, idRdzProduto, DataHrAtual);
	}

	public PTsDTO getPtsDoTtptDaFolha(DwFolha dwFolha) {
		PTRN rn = new PTRN();
		PTsDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			FolhaRN folhaRN = new FolhaRN();
			folhaRN.setDao(rn.getDao());
			DwFolha itemFolha = folhaRN.pesquisaFolhaByCdEStSemRota(dwFolha.getCdFolha());
			retorno = rn.getOmPtPeloTppt(itemFolha.getOmTppt());
		} catch (RegistroDesconhecidoException e) {
			retorno = new PTsDTO();
			retorno.setPts(new ArrayList<PtDTO>());
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PTsDTO getOmPtsAtivosPorTp(int idTpPt) {
		PTRN rn = new PTRN();
		PTsDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			OmTppt tppt = new OmTppt();
			tppt.setId(Long.parseLong(String.valueOf(idTpPt)));
			retorno = rn.getOmPtPeloTppt(tppt);
		} catch (RegistroDesconhecidoException e) {
			e.printStackTrace();
			retorno = new PTsDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DwEstlocalprosDTO getDwEstlocalprosMulti(FiltroMonitorizacaoLocalEstoque filtro) {
		EstoqueRN rn = new EstoqueRN();
		DwEstlocalprosDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = new DwEstlocalprosDTO();
			retorno.setDwEstlocalproDTOs(new ArrayList<DwEstlocalproDTO>());
			// for (DwEstlocalproDTO localProDTO :
			// filtro.getDwEstlocalproDTOs()){
			retorno = rn.getDwEstlocalpros(filtro);
			// if(!resultado.getDwEstlocalproDTOs().isEmpty())
			// retorno.getDwEstlocalproDTOs().addAll(resultado.getDwEstlocalproDTOs());
			// }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public boolean isIDWAtivo() {
		return isIDWAtivo;
	}

	public void setIDWAtivo(boolean isIDWAtivo) {
		this.isIDWAtivo = isIDWAtivo;
	}

	public String getVersaoMobile() {
		return versaoMobile;
	}

	public void setVersaoMobile(String versaoMobile) {
		this.versaoMobile = versaoMobile;
	}

	public void setHoraServidorBanco(Date dthr) {
		this.horaServidorBanco = dthr;
		this.horaLocalCapturaServidorBanco = DataHoraRN.getDataHoraAtual();
	}

	public Date getDataHoraServidorBanco() {
		if (horaLocalCapturaServidorBanco == null) {
			return DataHoraRN.getDataHoraAtual();
		}

		long elapsedTime = DataHoraRN.getQuantidadeMilisegundosNoPeriodo(this.horaLocalCapturaServidorBanco, DataHoraRN.getDataHoraAtual());
		Date retorno = DataHoraRN.adicionaMilisegundosNaData(this.horaServidorBanco, (int) elapsedTime);

		return retorno;
	}

	public String validaPosicoes(PosicoesCODTO posicoes, String maquina, String mapa) {
		MapaAlimentacaoRN rn = new MapaAlimentacaoRN();
		Session sessao = null;
		String stPosicoes = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			stPosicoes = rn.validaPosicoes(posicoes, maquina, mapa);
		} catch (Exception e) {
			rollbackTransacao(sessao);
			throw new RuntimeException(e);
		} finally {
			commitaTransacao(sessao);
		}
		rn = null;

		return stPosicoes;
	}

	public boolean validaPosicaoEProdutoRealim(String posicao, String produto, String maquina, String mapa) {
		MapaAlimentacaoRN rn = new MapaAlimentacaoRN();
		Session sessao = null;
		boolean stPosicoes = false;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			stPosicoes = rn.validaPosicaoEProdutoRealim(posicao, produto, maquina, mapa);
		} catch (Exception e) {
			rollbackTransacao(sessao);
			throw new RuntimeException(e);
		} finally {
			commitaTransacao(sessao);
		}
		rn = null;

		return stPosicoes;
	}

	public ProdutosResumoFichaMaqDTO getListaProdutosResumoFichaProducaoDTO(ProdutosDTO lista, byte tipoExibicaoQtd,
			byte periodoConsolidacao) {
		DetalheMonitorizacaoOPRN rn = new DetalheMonitorizacaoOPRN();
		ProdutosResumoFichaMaqDTO retorno = new ProdutosResumoFichaMaqDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getListaProdutosResumoFichaProducaoDTO(lista, tipoExibicaoQtd, periodoConsolidacao);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public ProdutosPerdasFichaMaqDTO getListaProdutosPerdasFichaMaqDTO(DetalheMonitorizacaoPTInjetDTO detMonitoramento,
			byte tipoExibicaoQtd) {
		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN();
		ProdutosPerdasFichaMaqDTO retorno = new ProdutosPerdasFichaMaqDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getListaProdutosPerdasFichaMaqDTO(detMonitoramento, tipoExibicaoQtd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public GraficosParetoRefugosDTO getGraficoParetoRefugosDTO(Byte tpId, Date dtInicial, Date dtFinal, BigDecimal idTurno, String cdPt,
			String cdCp, BigDecimal totalRefugado, String cdProduto) {
		GraficoParetoRefugoRN rn = new GraficoParetoRefugoRN();
		GraficosParetoRefugosDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoParetoRefugoDTO(tpId, dtInicial, dtFinal, idTurno, cdPt, cdCp, totalRefugado, cdProduto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public DetalhamentoRefugoDTO getOcorrenciaParetoRefugosDTO(Date dtReferencia, BigDecimal idTurno, BigDecimal idPt, String cdRefugo) {
		OcorrenciaParetoRefugoRN rn = new OcorrenciaParetoRefugoRN();
		DetalhamentoRefugoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOcorrenciaParetoRefugoDTO(dtReferencia, idTurno, idPt, cdRefugo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public GraficosParetoRefugosDTO getGraficoParetoRefugosBIDTO(Date dtInicial, Date dtFinal, BigDecimal idTurno, BigDecimal idPt,
			BigDecimal idGt, BigDecimal totalRefugado) {
		GraficoParetoRefugoRN rn = new GraficoParetoRefugoRN();
		GraficosParetoRefugosDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoParetoRefugosBIDTO(dtInicial, dtFinal, idTurno, idPt, idGt, totalRefugado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public DetalhamentoRefugoDTO getOcorrenciaParetoRefugoDTO(Date dtReferencia, BigDecimal idTurno, BigDecimal idPt, String cdRefugo) {
		OcorrenciaParetoRefugoRN rn = new OcorrenciaParetoRefugoRN();
		DetalhamentoRefugoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOcorrenciaParetoRefugoDTO(dtReferencia, idTurno, idPt, cdRefugo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public DetalhamentoRefugoDTO getOcorrenciaBIParetoRefugoDTO(Date dtInicial, Date dtFinal, BigDecimal idTurno, BigDecimal idPt,
			BigDecimal idGt, BigDecimal qtTotalRefugada, String cdRefugo) {
		OcorrenciaParetoRefugoRN rn = new OcorrenciaParetoRefugoRN();
		DetalhamentoRefugoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOcorrenciaBIParetoRefugoDTO(dtInicial, dtFinal, idTurno, idPt, idGt, qtTotalRefugada, cdRefugo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO getDetalhamentoGraficoPerdasBICiclosOrdemMaquina(
			DetalheMonitorizacaoPTInjetDTO indicadores, String cdMaquina, String cdProduto, Boolean isConsiderarPerda,
			Boolean isConsiderarGanho) {

		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN();
		ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO retorno;

		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDetalhamentoGraficoPerdasBICiclosOrdemMaquina(indicadores, cdMaquina, cdProduto, isConsiderarPerda,
					isConsiderarGanho);
		} catch (Exception e) {
			retorno = new ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO();
			retorno.setResumoIndicadores(new ResumoParetoPerdasDetCiclosDTO());
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public ListaGraficoBIParetoDetCiclosOrdemProdutoDTO getDetalhamentoGraficoPerdasBICiclosOrdemProduto(
			DetalheMonitorizacaoPTInjetDTO indicadores, Byte ordemQtd, String cdMaquina, String cdProduto, Boolean isConsiderarPerda,
			Boolean isConsiderarGanho) {
		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN();
		ListaGraficoBIParetoDetCiclosOrdemProdutoDTO retorno;

		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDetalhamentoGraficoPerdasBICiclosOrdemProduto(indicadores, ordemQtd, cdMaquina, cdProduto, isConsiderarPerda,
					isConsiderarGanho);
		} catch (Exception e) {
			retorno = new ListaGraficoBIParetoDetCiclosOrdemProdutoDTO();
			retorno.setResumoIndicadores(new ResumoParetoPerdasDetCiclosDTO());
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public ListaGraficoBIParetoDetTodasDTO getDetalhamentoGraficoPerdasBITodasOrdemProduto(DetalheMonitorizacaoPTInjetDTO indicadores,
			Byte ordemQtd, String cdMaquina, String cdProduto, Boolean isConsiderarPerda, Boolean isConsiderarGanho) {
		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN();
		ListaGraficoBIParetoDetTodasDTO retorno;

		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDetalhamentoGraficoPerdasBITodasOrdemProduto(indicadores, ordemQtd, cdMaquina, cdProduto, isConsiderarPerda,
					isConsiderarGanho);
		} catch (Exception e) {
			retorno = new ListaGraficoBIParetoDetTodasDTO();
			retorno.setResumoIndicadores(new ResumoParetoPerdasDetTodasDTO());
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;

	}

	public ListaGraficoBIParetoDetRefOrdemMaquinaDTO getDetalhamentoGraficoPerdasBIRefOrdemMaquina(
			DetalheMonitorizacaoPTInjetDTO indicadores, String cdRefugo, String cdMaquina, String cdProduto) {
		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN();
		ListaGraficoBIParetoDetRefOrdemMaquinaDTO retorno;

		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDetalhamentoGraficoPerdasBIRefOrdemMaquina(indicadores, cdRefugo, cdMaquina, cdProduto);
		} catch (Exception e) {
			retorno = new ListaGraficoBIParetoDetRefOrdemMaquinaDTO();
			retorno.setResumoIndicadores(new ResumoParetoPerdasDetRefugosDTO());
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;

	}

	public ListaGraficoBIParetoDetRefOrdemProdutoDTO getDetalhamentoGraficoPerdasBIRefOrdemProduto(
			DetalheMonitorizacaoPTInjetDTO indicadores, Byte ordemQtd, String cdRefugo, String cdMaquina, String cdProduto) {
		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN();
		ListaGraficoBIParetoDetRefOrdemProdutoDTO retorno;

		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDetalhamentoGraficoPerdasBIRefOrdemProduto(indicadores, ordemQtd, cdRefugo, cdMaquina, cdProduto);
		} catch (Exception e) {
			retorno = new ListaGraficoBIParetoDetRefOrdemProdutoDTO();
			retorno.setResumoIndicadores(new ResumoParetoPerdasDetRefugosDTO());
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;

	}

	public ListaGraficoBIParetoDetParOrdemMaquinaDTO getDetalhamentoGraficoPerdasBIParOrdemMaquina(
			DetalheMonitorizacaoPTInjetDTO indicadores, String cdParada, String cdMaquina, String cdProduto, Boolean isComPeso,
			Boolean isSemPeso) {
		DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN();
		ListaGraficoBIParetoDetParOrdemMaquinaDTO retorno;

		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDetalhamentoGraficoPerdasBIParOrdemMaquina(indicadores, cdParada, cdMaquina, cdProduto, isComPeso, isSemPeso);
		} catch (Exception e) {
			retorno = new ListaGraficoBIParetoDetParOrdemMaquinaDTO();
			retorno.setResumoIndicadores(new ResumoParetoPerdasDetParadasDTO());

			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;

	}

	public ListaGraficoBIParetoDetParOrdemProdutoDTO getDetalhamentoGraficoPerdasBIParOrdemProduto(
			DetalheMonitorizacaoPTInjetDTO indicadores, Byte ordemQtd, String cdParada, String cdMaquina, String cdProduto,
			Boolean isComPeso, Boolean isSemPeso) {

		DetalheGraficoBIParetoPerdasRN rn = new DetalheGraficoBIParetoPerdasRN();
		ListaGraficoBIParetoDetParOrdemProdutoDTO retorno;

		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDetalhamentoGraficoPerdasBIParOrdemProduto(indicadores, ordemQtd, cdParada, cdMaquina, cdProduto, isComPeso,
					isSemPeso);
		} catch (Exception e) {
			retorno = new ListaGraficoBIParetoDetParOrdemProdutoDTO();
			retorno.setResumoIndicadores(new ResumoParetoPerdasDetParadasDTO());
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public ProdutosDTO getListaProdutosRefugados(Byte tpId, Date dtInicial, Date dtFinal, BigDecimal idTurno, String cdPt, String cdCp) {
		GraficoParetoRefugoRN rn = new GraficoParetoRefugoRN();
		ProdutosDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getListaProdutosRefugados(tpId, dtInicial, dtFinal, idTurno, cdPt, cdCp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public DetalhamentoParadaDTO getOcorrenciaParetoParadaFichaMaqDTO(Byte tpId, Date dtInicial, Date dtFinal, BigDecimal idTurno,
			String cdPt, String cdGt, String cdCp, Boolean isComPeso, Boolean isSemPeso, String cdParada, String cdArea, Integer filtroOp) {

		OcorrenciaParettoParadaRN rn = new OcorrenciaParettoParadaRN();
		DetalhamentoParadaDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOcorrenciaParetoParadaFichaMaqDTO(tpId, dtInicial, dtFinal, idTurno, cdPt, cdGt, cdCp, isComPeso, isSemPeso,
					cdParada, cdArea, filtroOp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DetalhamentoRefugoDTO getOcorrenciaParetoRefugoFichaMaqDTO(Byte tpId, Date dtInicial, Date dtFinal, BigDecimal idTurno,
			String cdPt, String cdCp, String cdRefugo, String cdProduto) {
		OcorrenciaParetoRefugoRN rn = new OcorrenciaParetoRefugoRN();
		DetalhamentoRefugoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOcorrenciaParetoRefugoFichaMaqDTO(tpId, dtInicial, dtFinal, idTurno, cdPt, cdCp, cdRefugo, cdProduto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public GraficoAreaRespParadaDTO getGraficoAreaRespParada(Byte tpId, Date dtInicial, Date dtFinal, BigDecimal idTurno, String cdPt,
			String cdCp, Boolean isComPeso, Boolean isSemPeso) {
		GraficoParettoParadaRN rn = new GraficoParettoParadaRN();
		GraficoAreaRespParadaDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoAreaRespParada(tpId, dtInicial, dtFinal, idTurno, cdPt, cdCp, isComPeso, isSemPeso);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public TeTarifasemanaisDTO setTearifasemanaisDTO(TeTarifasemanaisDTO listDTO) {
		TarifasemanalRN rn = new TarifasemanalRN();
		TeTarifasemanaisDTO retorno = new TeTarifasemanaisDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setTearifasemanaisDTO(listDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public TeTarifasemanaisDTO getTeTarifasemanais(TeTarifasemanal filtro) {
		TarifasemanalRN rn = new TarifasemanalRN();
		TeTarifasemanaisDTO retorno = new TeTarifasemanaisDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTeTarifasemanais(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public TeTarifaDTO setTeTarifaDTO(TeTarifaDTO tarifa) {
		TarifaRN rn = new TarifaRN();
		TeTarifaDTO retorno = new TeTarifaDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setTeTarifaDTO(tarifa);
		} catch (Exception e) {
			e.printStackTrace();
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
		} finally {
			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				rn.rollbackTransacao();
			}
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public TeTarifaDTO excluirTeTarifa(TeTarifaDTO tarifa) {
		TarifaRN rn = new TarifaRN();
		TeTarifaDTO retorno = new TeTarifaDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.excluirTeTarifa(tarifa);
		} catch (Exception e) {
			e.printStackTrace();
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
		} finally {
			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				rn.rollbackTransacao();
			}
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public TeTarifasDTO getTeTarifaDTO(TeTarifaDTO filtro) {
		TarifaRN rn = new TarifaRN();
		TeTarifasDTO retorno = new TeTarifasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTeTarifaDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public TeConcessionariasDTO getTeConcessionaria(TeConcessionariaDTO filtro) {
		ConcessionariaRN rn = new ConcessionariaRN();
		TeConcessionariasDTO retorno = new TeConcessionariasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getConcessionaria(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public TeConcessionariaDTO setTeConcessionaria(TeConcessionariaDTO concessionaria) {
		ConcessionariaRN rn = new ConcessionariaRN();
		TeConcessionariaDTO retorno = new TeConcessionariaDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setTeConcessionaria(concessionaria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public TeConcessionariasDTO removeTeConcessionaria(TeConcessionariasDTO filtro) {
		ConcessionariaRN rn = new ConcessionariaRN();
		TeConcessionariasDTO retorno = new TeConcessionariasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeTeConcessionaria(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public TeLeisVigentesDTO getTeLeisVigentesDTO(TeLeiVigenteDTO itemDTO) {
		LeiVigenteRN rn = new LeiVigenteRN();
		Session sessao = null;
		TeLeisVigentesDTO itemRetorno = null;
		sessao = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			itemRetorno = rn.getTeLeisVigentesDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return itemRetorno;
	}

	public TeLeiVigenteDTO setTeLeiVigenteDTO(TeLeiVigenteDTO itemDTO) {
		LeiVigenteRN rn = new LeiVigenteRN();
		Session sessao = null;
		TeLeiVigenteDTO itemRetorno = null;
		sessao = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			itemRetorno = rn.setTeLeiVigenteDTO(itemDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return itemRetorno;
	}

	public TeTipoConsumidoresDTO getTeTipoConsumidor(TeTipoConsumidorDTO filtro) {
		TipoConsumidorRN rn = new TipoConsumidorRN();
		TeTipoConsumidoresDTO retorno = new TeTipoConsumidoresDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTeTipoConsumidor(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public TeTipoConsumidorDTO setTeTipoConsumidor(TeTipoConsumidorDTO tipoconsumidor) {
		TipoConsumidorRN rn = new TipoConsumidorRN();
		TeTipoConsumidorDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setTeTipoConsumidor(tipoconsumidor);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new TeTipoConsumidorDTO();
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public TeTipoConsumidoresDTO removeTeTipoConsumidor(TeTipoConsumidoresDTO filtro) {
		TipoConsumidorRN rn = new TipoConsumidorRN();
		TeTipoConsumidoresDTO retorno = new TeTipoConsumidoresDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeTeTipoConsumidor(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwTAreasDTO getListaAreasAtivas() {
		AreaRN rn = new AreaRN();
		DwTAreasDTO retorno = new DwTAreasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getListaAreasAtivas();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ConjuntoDTO getItensConjuntoProduto(String cdProduto) {
		FiltrosParaBIRN rn = new FiltrosParaBIRN();
		ConjuntoDTO retorno;

		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getItensConjuntoProduto(cdProduto);
		} catch (Exception e) {
			retorno = new ConjuntoDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public ProdutosDTO getListaProdutosPeriodoBI(FiltroDetalhePTInjetDTO filtro) {
		FiltrosParaBIRN rn = new FiltrosParaBIRN();
		ProdutosDTO retorno;

		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getListaProdutosPeriodoBI(filtro);
		} catch (Exception e) {
			retorno = new ProdutosDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;

	}

	public ProdutosDTO getListaConjuntosPeriodoBI(FiltroDetalhePTInjetDTO filtro) {
		FiltrosParaBIRN rn = new FiltrosParaBIRN();
		ProdutosDTO retorno = new ProdutosDTO();
		;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getListaConjuntosPeriodoBI(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public GruposFerramentaDTO getGruposFerramenta() {
		FiltrosParaBIRN rn = new FiltrosParaBIRN();
		GruposFerramentaDTO retorno = new GruposFerramentaDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGruposFerramenta();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public GruposFerramentaDTO getDwGrupoFerramenta(GrupoFerramentaDTO filtro) {
		GrupoFerramentaRN rn = new GrupoFerramentaRN();
		GruposFerramentaDTO retorno = new GruposFerramentaDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDwGrupoFerramenta(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public GrupoFerramentaDTO setDwGrupoFerramenta(GrupoFerramentaDTO dto) {
		GrupoFerramentaRN rn = new GrupoFerramentaRN();
		GrupoFerramentaDTO retorno = new GrupoFerramentaDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setDwGrupoFerramenta(dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public GrupoFerramentaDTO excluirDwGrupoFerramenta(GrupoFerramentaDTO dto) {
		GrupoFerramentaRN rn = new GrupoFerramentaRN();
		GrupoFerramentaDTO retorno = new GrupoFerramentaDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.excluirDwGrupoFerramenta(dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DwRapListDTO getListaCdDsRap() {
		DwRapRN rn = new DwRapRN();
		DwRapListDTO retorno = new DwRapListDTO();
		;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getListaCdDsRap();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaCBNumSerie(PesquisaDTO pesquisa) {

		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaCBNumSerie(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaMonitorDTO pesquisarMonitorPorEvento(Long idEvento) {
		MonitorRN rn = new MonitorRN();
		ListaMonitorDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarMonitorPorEvento(idEvento);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaMonitorDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaCPDTO getPpCpByCdPt(OmPt ompt) {
		CpRN rn = new CpRN();
		ListaCPDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getPpCpByCdPt(ompt);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaCPDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}
	
	public PpCp pesquisarPpCpAtualByCdPt(String cdpt) {
		CpRN rn = new CpRN();
		PpCp retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarPpCpAtualByCdPt(cdpt);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PpCp();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ListaParametrosCEPDTO getListaParametrosCEP(Boolean incluirItemTODOS) {
		MonitorizacaoCEPRN rn = new MonitorizacaoCEPRN();
		ListaParametrosCEPDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getListaParametrosCEP(incluirItemTODOS);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaParametrosCEPDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DetalheCEPDTO getDetalheCEPGraf(Byte quebraPeriodo, DwConsolidDTOs listaDwconsolid, ListaParametrosCEPDTO listaParametros) {
		MonitorizacaoCEPRN rn = new MonitorizacaoCEPRN();
		DetalheCEPDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDetalheCEPGraf(quebraPeriodo, listaDwconsolid, listaParametros);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new DetalheCEPDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DetalheCEPDTO getDetalheCEP(DwConsolidDTOs listaDwconsolid, ListaParametrosCEPDTO listaParametros) {
		MonitorizacaoCEPRN rn = new MonitorizacaoCEPRN();
		DetalheCEPDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDetalheCEP(listaDwconsolid, listaParametros);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new DetalheCEPDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DetalheCEPDTO getDetalheParadasCEP(DetalhamentoParadaDTO detParadaDTO, ListaParametrosCEPDTO listaParametros) {
		MonitorizacaoCEPRN rn = new MonitorizacaoCEPRN();
		DetalheCEPDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDetalheParadasCEP(detParadaDTO, listaParametros);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new DetalheCEPDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DetalheCEPDTO getDetalheCiclosCEP(CiclosDTO detCiclosDTO, ListaParametrosCEPDTO listaParametros) {
		MonitorizacaoCEPRN rn = new MonitorizacaoCEPRN();
		DetalheCEPDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDetalheCiclosCEP(detCiclosDTO, listaParametros);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new DetalheCEPDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public GraficoCEPDTO getGraficoCEP(Byte quebraPeriodo, DetalheCEPDTO folhasCEP) {
		MonitorizacaoCEPRN rn = new MonitorizacaoCEPRN();
		GraficoCEPDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoCEP(quebraPeriodo, folhasCEP);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new GraficoCEPDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public GraficoCEPDTO getGraficoCEP2(Byte quebraPeriodo, Byte tpReferencia, ListaParametrosCEPDTO parametros,
			FiltroDetalhePTInjetDTO filtro) {
		MonitorizacaoCEPRN rn = new MonitorizacaoCEPRN();
		GraficoCEPDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoCEP2(quebraPeriodo, tpReferencia, parametros, filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new GraficoCEPDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DetalheCEPDTO getDetalheCEPGraf2(Byte quebraPeriodo, Byte tpReferencia, Long idFtParam, FiltroDetalhePTInjetDTO filtro) {
		MonitorizacaoCEPRN rn = new MonitorizacaoCEPRN();
		DetalheCEPDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDetalheCEPGraf2(quebraPeriodo, tpReferencia, idFtParam, filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new DetalheCEPDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public IndicadoresEstatisticosCEPDTO getIndicadoresEstatisticosCEP(FolhaCEPDTO folhaCEP, Integer tamanhoAmostra) {
		MonitorizacaoCEPRN rn = new MonitorizacaoCEPRN();
		IndicadoresEstatisticosCEPDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getIndicadoresEstatisticosCEP(folhaCEP, tamanhoAmostra);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new IndicadoresEstatisticosCEPDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public boolean validaRefugoInovaSA(String ns, Long idRef) {
		ConsolidacaoRefugoRN rn = new ConsolidacaoRefugoRN();
		boolean retorno = false;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.validaRefugoInovaSA(ns, idRef);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public MapaCPDTOs getMapaCPs(FiltroDetalhePTInjetDTO filtro) {
		MapaOpsRN rn = new MapaOpsRN();

		MapaCPDTOs retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getMapaCPs(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new MapaCPDTOs();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaRelatorioIndiceParadaAreaRespDTO getConsolpasAreaRespDTO(FiltroRelatorioIndiceParadasDTO filtro) {
		RelatorioIndParadasAreaRespRN rn = new RelatorioIndParadasAreaRespRN();
		ListaRelatorioIndiceParadaAreaRespDTO retorno = new ListaRelatorioIndiceParadaAreaRespDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getConsolpasAreaRespDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaRelatorioIndiceParadaMoldeDTO getConsolpasMoldeDTO(FiltroRelatorioIndiceParadasDTO filtro) {
		RelatorioIndiceParadasMoldesRN rn = new RelatorioIndiceParadasMoldesRN();
		ListaRelatorioIndiceParadaMoldeDTO retorno = new ListaRelatorioIndiceParadaMoldeDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getConsolpasMoldeDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaRelatorioOcorrenciaParadasDTO getConsolpaocoDTO(FiltroRelatorioIndiceParadasDTO filtro) {
		RelatorioOcorrenciaParadasRN rn = new RelatorioOcorrenciaParadasRN();
		ListaRelatorioOcorrenciaParadasDTO retorno = new ListaRelatorioOcorrenciaParadasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getConsolpaocoDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaRelatorioParadasAbertasDTO getConsolpaLogDTO(FiltroRelatorioParadasAbertasDTO filtro) {
		RelatorioParadasAbertasRN rn = new RelatorioParadasAbertasRN();
		ListaRelatorioParadasAbertasDTO retorno = new ListaRelatorioParadasAbertasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getConsolpaLogDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaRelatorioQuantidadeParadasDTO getConsolpaDTO(FiltroRelatorioIndiceParadasDTO filtro) {
		RelatorioQuantidadeParadasRN rn = new RelatorioQuantidadeParadasRN(filtro);
		ListaRelatorioQuantidadeParadasDTO retorno = new ListaRelatorioQuantidadeParadasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.gerarRelatorio();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaRelatorioCausasParadasDTO getCausasParadas(FiltroRelatorioIndiceParadasDTO filtro) {
		RelatorioCausasParadasRN rn = new RelatorioCausasParadasRN();
		ListaRelatorioCausasParadasDTO retorno = new ListaRelatorioCausasParadasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getCausasParadas(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public RelatorioCargaMaquinaDTO getRelatorioCargaMaquina(FiltroRelatorioCargaMaquinaDTO filtro) {
		/*
		 * RelatorioCargaMaquinaRN rn = new RelatorioCargaMaquinaRN(); RelatorioCargaMaquinaDTO retorno = new RelatorioCargaMaquinaDTO();
		 * try { rn.iniciaConexaoBanco(); retorno = rn.getRelatorioCargaMaquina(filtro); } catch (Exception e) { e.printStackTrace(); }
		 * finally { rn.finalizaConexaoBanco(); } rn = null; return retorno;
		 */

		RelCargaMaquinaRN rn = new RelCargaMaquinaRN();
		RelatorioCargaMaquinaDTO retorno = new RelatorioCargaMaquinaDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioCargaMaquina(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public CicloDTO getCicloTimeoutEPadrao(String cdProduto, String maquina) {
		FolhaRN rn = new FolhaRN();
		CicloDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getCicloTimeoutEPadrao(cdProduto, maquina);
		} catch (Exception e) {
			retorno = null;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ListaAcompanhamentoProducaoDTO getAcompanhamentoProducaoRN(FiltroRelatorioAnaliseEficienciaDTO filtro) {
		RelAcompanhamentoProducaoRN rn = new RelAcompanhamentoProducaoRN();
		ListaAcompanhamentoProducaoDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getAcompanhamentoProducao(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaAcompanhamentoProducaoDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaRelatorioAnaliticoRefugoDTO relatorioAnaliticoRefugo(FiltroRelatorioIndiceDiarioDTO filtro) {
		RelatorioAnaliticoRefugoRN rn = new RelatorioAnaliticoRefugoRN();
		ListaRelatorioAnaliticoRefugoDTO retorno = new ListaRelatorioAnaliticoRefugoDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getListaRelatorioAnaliticoRefugoDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaRelatorioIndicesDiariosDTO getRelatorioIndicesDiarios(FiltroRelatorioIndiceDiarioDTO filtro) {
		RelatorioIndiceDiarioRN rn = new RelatorioIndiceDiarioRN();
		ListaRelatorioIndicesDiariosDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioIndicesDiarios(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaRelatorioIndicesDiariosDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaRelatorioIndiceRefugoDTO getRelatorioIndiceRefugo(FiltroRelatorioIndiceDiarioDTO filtro) {
		RelatorioIndiceRefugoRN rn = new RelatorioIndiceRefugoRN();
		ListaRelatorioIndiceRefugoDTO retorno = new ListaRelatorioIndiceRefugoDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioIndiceRefugo(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public RelatorioProgramacaoDTO getRelatorioProgramacao(FiltroRelatorioProgramacaoDTO filtro) {
		RelatorioProgramacaoRN rn = new RelatorioProgramacaoRN();
		RelatorioProgramacaoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioProgramacao(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaRelatorioRefugoSemConsolidacaoDTO getListaRelatorioRefugoSemConsolidacaoDTO(FiltroRelatorioIndiceDiarioDTO filtro) {
		RelatorioRefugoSemConsolidacaoRN rn = new RelatorioRefugoSemConsolidacaoRN();
		ListaRelatorioRefugoSemConsolidacaoDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getListaRelatorioRefugoSemConsolidacaoDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaRelatorioRefugoSemConsolidacaoDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PTsDTO getPtByGt(OmGt omgt) {
		PTRN rn = new PTRN();
		PTsDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getPtByGt(omgt);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PTsDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public IpcProRet importarProdutoIpcInj(IpcProDTO produto) {
		IntegracaoIpackChemRN rn = new IntegracaoIpackChemRN();
		IpcProRet retorno = new IpcProRet();

		try {
			rn.iniciaConexaoBanco();
			retorno = rn.importarProdutoIpcInj(produto);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new IpcProRet();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;

		return retorno;
	}

	public IpcOPRet importarOPIpcInj(IpcOPDTO op) {
		IntegracaoIpackChemRN rn = new IntegracaoIpackChemRN();
		IpcOPRet retorno = new IpcOPRet();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.importarOPIpcInj(op);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new IpcOPRet();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;

		return retorno;
	}

	public CEPFolhasDTO getCEPFolhas(Byte quebraPeriodo, FiltroDetalhePTInjetDTO filtro, ListaParametrosCEPDTO listaParametros) {
		MonitorizacaoCEPRN rn = new MonitorizacaoCEPRN();
		CEPFolhasDTO retorno = new CEPFolhasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getCEPFolhas(quebraPeriodo, filtro, listaParametros);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new CEPFolhasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;

		return retorno;
	}

	public GraficosParetoRefugosDTO getGraficoParetoRefugo2DTO(FiltroDetalhePTInjetDTO filtro, BigDecimal totalRefugado) {
		GraficoParetoRefugoRN rn = new GraficoParetoRefugoRN();
		GraficosParetoRefugosDTO retorno = new GraficosParetoRefugosDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoParetoRefugo2DTO(filtro, totalRefugado);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new GraficosParetoRefugosDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;

		return retorno;

	}

	public OmCfg getConfiguracaoAtual() {
		ConfiguracaoRN rn = new ConfiguracaoRN();
		Session sessao = null;
		OmCfg configuracoes = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			configuracoes = rn.getConfiguracao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return configuracoes;
	}

	public ClassificacaoABCDTO setClassificacaoABCDTO(ClassificacaoABCDTO itemDTO) {
		ClassificacaoABCRN rn = new ClassificacaoABCRN();
		ClassificacaoABCDTO retorno = new ClassificacaoABCDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setClassificacaoABCDTO(itemDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public ClassificacoesABCDTO getListaClassificacaoABCDTO(ClassificacaoABCDTO filtro) {
		ClassificacaoABCRN rn = new ClassificacaoABCRN();
		ClassificacoesABCDTO retorno = new ClassificacoesABCDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getListaClassificacaoABCDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public IndicadorValorDTO getIndicadorPorId(Long id) {
		IndicadorRN rn = new IndicadorRN();
		IndicadorValorDTO retorno = new IndicadorValorDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getIndicadorPorId(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public PesquisasDTO pesquisaClassificacaoABC(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaClassificacaoABC(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DwTRitmoDTO setTRitmo(DwTRitmoDTO filtro) {
		RitmoRN rn = new RitmoRN();
		DwTRitmoDTO retorno = new DwTRitmoDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setTRitmo(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public RelatorioConsolidadoDTO getConsolidadoDTO(FiltroRelatorioConsolidadosDTO filtro) {
		RelatorioConsolidadosRN rn = new RelatorioConsolidadosRN();
		RelatorioConsolidadoDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioConsolidados(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new RelatorioConsolidadoDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public RelatorioRefugoConsolidadoPorMoldeDTO getRefugoConsolidadoPorMoldeDTO(
			FiltroRelatorioRefugoConsolidadoPorMoldeDTO filtro) {

		RelatorioRefugoConsolidadoPorMoldeRN rn = new RelatorioRefugoConsolidadoPorMoldeRN();
		RelatorioRefugoConsolidadoPorMoldeDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioRefugoConsolidadoPorMolde(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new RelatorioRefugoConsolidadoPorMoldeDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public DwTRitmosDTO getTRitmo(DwTRitmoDTO filtro) {
		RitmoRN rn = new RitmoRN();
		DwTRitmosDTO retorno = new DwTRitmosDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTRitmo(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public DwTRitmosDTO removeTRitmo(DwTRitmosDTO filtro) {
		RitmoRN rn = new RitmoRN();
		DwTRitmosDTO retorno = new DwTRitmosDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeTRitmo(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public PesquisasDTO pesquisaRitmo(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaRitmo(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaRelatorioCausasDeRefugoDTO getRelatorioCausasDeRefugo(FiltroRelatorioCausasDeRefugoDTO filtro) {
		RelatorioCausasDeRefugoRN rn = new RelatorioCausasDeRefugoRN();
		ListaRelatorioCausasDeRefugoDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioCausasDeRefugo(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaRelatorioCausasDeRefugoDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaDTOAnaliseProducaoEficienciaHoraAHora getRelatorioEficienciaHoaraAHora(FiltroRelatorioAnaliseEficienciaDTO filtro) {
		AnaliseProducaoEficienciaHoraAHoraRN rn = new AnaliseProducaoEficienciaHoraAHoraRN();
		ListaDTOAnaliseProducaoEficienciaHoraAHora retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioEficienciaHoraAHora(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaDTOAnaliseProducaoEficienciaHoraAHora();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public OmEmpresaDTO setOmEmpresa(OmEmpresaDTO filtro) {
		EmpresaRN rn = new EmpresaRN();
		OmEmpresaDTO retorno = new OmEmpresaDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setEmpresa(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public OmEmpresasDTO removeOmEmpresa(OmEmpresasDTO filtro) {
		EmpresaRN rn = new EmpresaRN();
		OmEmpresasDTO retorno = new OmEmpresasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeOmEmpresa(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public OmEmpresasDTO getOmEmpresa(OmEmpresaDTO filtro) {
		EmpresaRN rn = new EmpresaRN();
		OmEmpresasDTO retorno = new OmEmpresasDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOmEmpresa(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public PesquisasDTO pesquisaEmpresa(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaEmpresa(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public LicencaIDWDTO isLicenciado(LicencaIDWDTO dto) {
		LicencaIDWDTO retorno;
		LicencaIDWRN rn = new LicencaIDWRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.isLecenciado(dto);
		} catch (Exception e) {
			retorno = new LicencaIDWDTO();
			retorno.setIsLicenciado(false);
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public RelatorioProducaoRegulagemDTO getProdRegulagemDTO(FiltroRelatorioProdRegulagemDTO filtro) {
		RelatorioProdRegulagemRN rn = new RelatorioProdRegulagemRN();
		RelatorioProducaoRegulagemDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getProdRegulagemDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new RelatorioProducaoRegulagemDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public GraficosParettoRitmoDTO getGraficoParettoRitmoDTO(FiltroDetalhePTInjetDTO filtroMaquina) {
		GraficoParettoRitmoRN rn = new GraficoParettoRitmoRN();
		GraficosParettoRitmoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoParettoRitmoDTO(filtroMaquina);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public int getValidarNumeroDeSerie(String cdpt, String nrop, String ns, String cdproduto, Long idpt, Boolean isAvaliarMontagem) {
		ValidaNumeroSerieRN rn = new ValidaNumeroSerieRN();
		int retorno = 0;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.validaNumeroSerie(cdpt, nrop, ns, idpt, isAvaliarMontagem);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;

	}

	public int getValidarNumeroDeSerieComExcessao(String cdpt, String nrop, String ns, String cdproduto, Long idpt, Boolean isAvaliarMontagem) throws PararDeProcessarArquivoSemSalvarLinhaException {
		ValidaNumeroSerieRN rn = new ValidaNumeroSerieRN();
		int retorno = 0;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.validaNumeroSerie(cdpt, nrop, ns, idpt, isAvaliarMontagem);
		} catch (Exception e) {
			System.out.println("getValidarNumeroDeSerieComExcessao cdpt=" + cdpt + " nrop=" + nrop + " ns=" + ns + " cdproduto=" + cdproduto + " idpt=" + idpt + " isAvalMont-" + isAvaliarMontagem);
			e.printStackTrace();
			throw new PararDeProcessarArquivoSemSalvarLinhaException();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;

	}

	public int getValidarNumeroDeSerieAgramkow(String cdpt, String nrop, String ns, String cdproduto, Long idpt,
			Boolean isAvaliarMontagem) {
		ValidaNumeroSerieRN rn = new ValidaNumeroSerieRN();
		
		UpRN uprn = new UpRN();
		
		int retorno = 0;
		int segundavalidacao = 1;

		try {
			rn.iniciaConexaoBanco();
			
			if (ns!=null && ns.length()>=10){
				nrop = ns.substring(0, 10);
			}
			
			retorno = rn.validaNumeroSerieAgramkow(cdpt, nrop, ns, idpt, isAvaliarMontagem);
			
			if(retorno == 3){//Ignora falhas de Roteiro pois aqui ignorando Roteiro
				retorno = 1;
			}

			if (retorno > 0 && retorno != 3 && retorno != 5) {
				
				//identificando o cdPtAnterior que condiciona a validação teste Agramkow. Código={server-unit}.
				uprn.setDaoPdba(rn.getDao());
				MsUp msup = new MsUp();
				msup = uprn.pesquisarMsUpPorCdUpStAtivo(cdpt);
				String sCdPtAnteriorCompleto = "0-131";
				String sCdPtAnterior = "131";
				String sCdPtServerAnterior = "0";

				if (msup!=null && msup.getCdBc()!=null && !msup.getCdBc().trim().equals("")){
					sCdPtAnteriorCompleto = msup.getCdBc();
					if (sCdPtAnteriorCompleto.trim().indexOf("-") >=0){
						sCdPtServerAnterior = sCdPtAnteriorCompleto.substring(0,sCdPtAnteriorCompleto.indexOf("-"));
						sCdPtAnterior = sCdPtAnteriorCompleto.substring(sCdPtAnteriorCompleto.indexOf("-")+1);						
					} else {
						sCdPtServerAnterior = "0";
						sCdPtAnterior = sCdPtAnteriorCompleto.trim();						
					}
				}
				sCdPtServerAnterior = sCdPtServerAnterior.trim();
				sCdPtAnterior = sCdPtAnterior.trim();
				msup = null;
				uprn = null;

				segundavalidacao = rn.validaNumeroSerieTestesAgramkow(ns,sCdPtServerAnterior,sCdPtAnterior);
				retorno = segundavalidacao;
			}
			if (segundavalidacao == 6) {
				retorno = segundavalidacao;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;

	}

	public void regristrarPassagem(String cdPt, String cdOp, String cb, Date dthr, String qtde) {
		UpRN uprn = new UpRN();

		try {
			uprn.iniciaConexaoBanco();

			uprn.regristrarPassagem(cdPt, cdOp, cb, dthr, qtde);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			uprn.finalizaConexaoBanco();
		}

	}

	public void regristrarPassagemAgramkow(String cdPt, String cdOp, String cb, Date dthr, String qtde) {
		UpRN uprn = new UpRN();

		try {
			uprn.iniciaConexaoBanco();
			
			if (cb!=null && cb.length()>=10){
				cdOp = cb.substring(0, 10) ;
			}

			uprn.regristrarPassagem(cdPt, cdOp, cb, dthr, qtde);

			uprn.regristrarTesteDefeitoAgramkow(cdPt, cdOp, cb, dthr, qtde);


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			uprn.finalizaConexaoBanco();
		}

	}

	public void regristrarTesteSimples(String cdPt, String cdOp, String cb, Date dthr, Integer stTeste, String qtde) {
		UpRN uprn = new UpRN();

		try {
			uprn.iniciaConexaoBanco();

			uprn.regristrarTesteSimples(cdPt, cdOp, cb, dthr, stTeste, qtde);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			uprn.finalizaConexaoBanco();
		}

	}
	public void regristrarTesteSimplesComExcessao(String cdPt, String cdOp, String cb, Date dthr, Integer stTeste, String qtde) throws PararDeProcessarArquivoSemSalvarLinhaException {
		UpRN uprn = new UpRN();

		try {
			uprn.iniciaConexaoBanco();

			uprn.regristrarTesteSimples(cdPt, cdOp, cb, dthr, stTeste, qtde);

		} catch (Exception e) {
			e.printStackTrace();
			throw new PararDeProcessarArquivoSemSalvarLinhaException();
		} finally {
			uprn.finalizaConexaoBanco();
		}

	}

    public void regristrarTesteDefeito(String cdPt, String cdOp, String cb, Date dthr, String cdDefeito, String qtde, String cdAreaResponsavel, String posicoesMecanicas) {
        
    	UpRN uprn = new UpRN();

        try {
            
        	uprn.iniciaConexaoBanco();
            uprn.regristrarTesteDefeito(cdPt, cdOp, cb, dthr, cdDefeito, qtde, cdAreaResponsavel, posicoesMecanicas, null);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            uprn.finalizaConexaoBanco();
        }

    }
    public void regristrarTesteDefeitoComExcessao(String cdPt, String cdOp, String cb, Date dthr, String cdDefeito, String qtde, String cdAreaResponsavel, String posicoesMecanicas) throws PararDeProcessarArquivoSemSalvarLinhaException {
        
    	UpRN uprn = new UpRN();

        try {
            
        	uprn.iniciaConexaoBanco();
            uprn.regristrarTesteDefeito(cdPt, cdOp, cb, dthr, cdDefeito, qtde, cdAreaResponsavel, posicoesMecanicas, null);

        } catch (Exception e) {
            throw new PararDeProcessarArquivoSemSalvarLinhaException();
        } finally {
            uprn.finalizaConexaoBanco();
        }

    }

	public void registrarMontagem(String cdPt, String cdOp, String cb, Date dthr, MontagensDTO lista, String qtde) {
		registrarMontagem(cdPt, cdOp, cb, dthr, lista, qtde, true, null);
	}

	public void registrarMontagemAntecipada(String cdPt, String cdOp, String cb, Date dthr, MontagensDTO lista, String qtde,
			Boolean isFechouAntecipadamente, String reSupervisor, String cbSerial) {
		UpRN uprn = new UpRN();

		try {
			uprn.iniciaConexaoBanco();

			uprn.registrarMontagemAntecipada(cdPt, cdOp, cb, dthr, lista, qtde, isFechouAntecipadamente, reSupervisor, cbSerial);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			uprn.finalizaConexaoBanco();
		}
	}
	

	public void registrarMontagem(String cdPt, String cdOp, String cb, Date dthr, MontagensDTO lista, String qtde, boolean isCbConforme,
			String cddefeito) {
		UpRN uprn = new UpRN();

		try {
			uprn.iniciaConexaoBanco();

			uprn.registrarMontagem(cdPt, cdOp, cb, dthr, lista, qtde, isCbConforme, cddefeito);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			uprn.finalizaConexaoBanco();
		}

	}

	public DwTOperacoesDTO getTiposOperacao() {
		TipoOperacaoRN rn = new TipoOperacaoRN();
		DwTOperacoesDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTiposOperacao();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public void setDwOperacao(DwOperacaoDTO dto) {
		OperacaoRN rn = new OperacaoRN();
		try {
			rn.iniciaConexaoBanco();
			rn.setDwOperacao(dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
	}

	public DwOperacoesDTO setListaDwOperacao(DwOperacoesDTO listaDTO) {
		OperacaoRN rn = new OperacaoRN();
		DwOperacoesDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setListaDwOperacao(listaDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwOperacoesDTO getDwOperacao(DwOperacaoDTO filtro) {
		OperacaoRN rn = new OperacaoRN();
		DwOperacoesDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDwOperacao(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwOperacaoDTO getDwOperacaoByCodigo(DwOperacaoDTO filtro) {
		OperacaoRN rn = new OperacaoRN();
		DwOperacaoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDwOperacaoByCodigo(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ListaRelatorioOPProcessadaDTO getListaRelatorioOPProcessadaDTO(FiltroRelatorioOPProcessadaDTO filtro) {
		RelatorioOrdemProducaoProcessadaRN rn = new RelatorioOrdemProducaoProcessadaRN();
		ListaRelatorioOPProcessadaDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioOPProcessada(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaRelatorioOPProcessadaDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public IpBalanceamentoDTO balancear(IpBalanceamentoDTO dto) {
		BalanceamentoRN rn = new BalanceamentoRN();
		IpBalanceamentoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.balancear(dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public IpBalanceamentoDTO setBalanceamento(IpBalanceamentoDTO dto) {
		BalanceamentoRN rn = new BalanceamentoRN();
		IpBalanceamentoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setBalanceamento(dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public IpBalanceamentosDTO excluirBalanceamentos(IpBalanceamentosDTO dtos) {
		BalanceamentoRN rn = new BalanceamentoRN();
		IpBalanceamentosDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.excluirBalanceamentos(dtos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public IpBalanceamentosDTO pesquisarBalanceamento(IpBalanceamentoDTO filtro) {
		BalanceamentoRN rn = new BalanceamentoRN();
		IpBalanceamentosDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarBalanceamento(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public IpBalanceamentoDTO firmarBalanceamento(IpBalanceamentoDTO dto) {
		BalanceamentoRN rn = new BalanceamentoRN();
		IpBalanceamentoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.firmarBalanceamento(dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public RelatorioProdutividadeR42DTO getRelatorioProdutividadeR42DTO(FiltroRelatorioProdutividadeR42DTO filtro) {
		RelatorioProdutividadeR42RN rn = new RelatorioProdutividadeR42RN();
		RelatorioProdutividadeR42DTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioProdutividadeR42DTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public Boolean isNumeroSerieRefugado(String cb) {
		NumeroSerieRN rn = new NumeroSerieRN();
		Boolean isRetorno = false;
		try {
			rn.iniciaConexaoBanco();
			isRetorno = rn.isNumeroSerieRefugado(cb);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return isRetorno;
	}

	public MontagensDTO isCodigoBarrasPossuiMontagem(String cb) {
		NumeroSerieRN rn = new NumeroSerieRN();
		MontagensDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getUltimaMontagem(cb);
		} catch (Exception e) {
			retorno = new MontagensDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;

	}

	public MontagensDTO isCBJaMontado(String cb) {
		NumeroSerieRN rn = new NumeroSerieRN();
		MontagensDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.isCBJaMontado(cb, 1);
		} catch (Exception e) {
			retorno = new MontagensDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;

	}
	
	public MontagensDTO isCBJaMontado(String cb, String cdpt, String cdcp) {
		NumeroSerieRN rn = new NumeroSerieRN();
		MontagensDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.isCBJaMontadoNoTppt(cb, cdpt, cdcp);
		} catch (Exception e) {
			retorno = new MontagensDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	
	
	public MontagensDTO getUltimaMontagemNoPosto(String cb, String cdpt, String cdcp) {
		NumeroSerieRN rn = new NumeroSerieRN();
		MontagensDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getUltimaMontagemNoPosto(cb, cdpt, cdcp);
		} catch (Exception e) {
			retorno = new MontagensDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public RelatorioProducaoR043DTO getRelatorioProducaoR043(FiltroRelatorioProducaoR043DTO filtro) {

		RelatorioProducaoR043RN rn = new RelatorioProducaoR043RN();
		RelatorioProducaoR043DTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioProducaoR043(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ListaRelatorioDuplicacaoDePartesAcoplamentoDTO getListaRelatorioDuplicacaoDePartesAcoplamento(
			FiltroRelatorioDuplicacaoDePartesAcoplamentoDTO filtro) {
		RelatorioDuplicacaoDePartesAcoplamentoRN rn = new RelatorioDuplicacaoDePartesAcoplamentoRN();
		ListaRelatorioDuplicacaoDePartesAcoplamentoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getListaRelatorioDuplicacaoDePartesAcoplamentoDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public DwOperacoesDTO getDwOperacaoInProcess() {
		OperacaoRN rn = new OperacaoRN(this.getDao());
		rn.iniciaConexaoBanco();
		DwOperacoesDTO retorno = new DwOperacoesDTO();
		try {
			retorno = rn.getDwOperacaoInProcess();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;

	}

	public String getMascaraCdProdutomp() {
		ConfiguracaoRN rn = new ConfiguracaoRN();
		Session sessao = null;
		String retorno;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			OmCfg configuracoes = rn.getConfiguracao();
			retorno = configuracoes.getMascaracdprodutomp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "-1";
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return retorno;
	}

	public DetalhamentoDefeitoDTO getOcorrenciaParettoDefeito(FiltroDetalheDefeito filtro) {
		OcorrenciaParettoDefeitoRN rn = new OcorrenciaParettoDefeitoRN();
		DetalhamentoDefeitoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOcorrenciaParettoDefeito(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public GraficoParettoDefeitosDTO getGraficoParettoDefeito(FiltroDetalheDefeito filtro) {
		OcorrenciaParettoDefeitoRN rn = new OcorrenciaParettoDefeitoRN();
		GraficoParettoDefeitosDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoParettoDefeito(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public PTsDTO pesquisarPtByGtComLayout(PtDTO pt) {
		PTRN rn = new PTRN();
		Session sessao = null;
		PTsDTO pts = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setDaoSession(sessao);
			pts = rn.pesquisarPtByGtComLayout(pt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return pts;
	}

	public ListaPeproDTO pesquisarDwPeproTodos() {
		DiversosRN rn = new DiversosRN();
		ListaPeproDTO retorno = new ListaPeproDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarDwPeproTodos();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public String gerarNS(OmRegrasNscb regra, OmProduto omproduto, OmPt ompt, String cdcp) {
		NumeroSerieRN rn = new NumeroSerieRN();
		rn.iniciaConexaoBanco();
		String retorno = null;
		try {
			retorno = rn.gerarNS(regra, omproduto, ompt, cdcp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public String montarSequencialSemanalAnual(String prefixo, int tamanhoSeqSemana) {
		NumeroSerieRN rn = new NumeroSerieRN();
		rn.iniciaConexaoBanco();
		String retorno = null;
		try {
			retorno = rn.montarSequencialSemanalAnual(prefixo, tamanhoSeqSemana);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ClassificacoesABCDTO removeClassificacaoABC(ClassificacoesABCDTO filtro) {
		ClassificacaoABCRN rn = new ClassificacaoABCRN();
		ClassificacoesABCDTO retorno = new ClassificacoesABCDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.removeClassificacaoABC(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ListaGraficoBIParetoDetAreaRespDTO getDetalhamentoGraficoPerdasBIAreaRespPar(
			DetalheMonitorizacaoPTInjetDTO indicadores, String cdArea, String cdParada, String cdMaquina, String cdProduto,
			Boolean isComPeso, Boolean isSemPeso) {

		DetalheGraficoBIParetoPerdasRN rn = new DetalheGraficoBIParetoPerdasRN();
		ListaGraficoBIParetoDetAreaRespDTO retorno;

		try {
			rn.iniciaConexaoBanco();
			retorno =
					rn.getDetalhamentoGraficoPerdasBIAreaRespPar(indicadores, cdArea, cdParada, cdMaquina, cdProduto, isComPeso, isSemPeso);
		} catch (Exception e) {
			retorno = new ListaGraficoBIParetoDetAreaRespDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		rn = null;
		return retorno;
	}

	public IwsConsultaDTO setTr_Consulta(String cdconsulta, String idup, Date dthr) {
		ConsultaPdbaMsEvtRN rn = new ConsultaPdbaMsEvtRN();
		return rn.setTr_Consulta(cdconsulta, idup, dthr);
	}

	public Boolean setTr_trataInicioDeCIP(String idup, Date dataReferencia, String tecnico) {
		CIPPdbaMsEvtRN rn = new CIPPdbaMsEvtRN();
		return rn.setTr_trataInicioDeCIP(idup, dataReferencia, tecnico);
	}

	public Boolean setTr_trataFimCIP(String idUp, Date dthrfim, String tecnico) {
		CIPPdbaMsEvtRN rn = new CIPPdbaMsEvtRN();
		return rn.setTr_trataFimCIP(idUp, dthrfim, tecnico);
	}

	public boolean setTr_ApagaUltimoRefugo(String cdRefugo, String idRdzProduto, Date DthrUltRefugo, String milisec, String IdUp,
			Date DataHrAtual) {
		ProducaoPdbaMsEvtRN rn = new ProducaoPdbaMsEvtRN();
		return rn.setTr_ApagaUltimoRefugo(cdRefugo, idRdzProduto, DthrUltRefugo, milisec, IdUp, DataHrAtual);
	}

	public IwsHorarioDTO getTr_sincronizaHorario() {
		HeartBeatPdbaMsEvtRN rn = new HeartBeatPdbaMsEvtRN();
		return rn.getTr_sincronizaHorario();
	}

	public PpCp pesquisarPpCpByNrDocCdPtClone(String cdcp, String cdPt) {
		CpRN rn = new CpRN();
		PpCp retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarPpCpByNrDocCdPtClone(cdcp, cdPt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public OpsIntegracaoDTO getOpsParaIntegrar(String cdop) {
		IntegracaoOPRN rn = new IntegracaoOPRN();
		OpsIntegracaoDTO retorno;
		ConfiguracaoRN crn = new ConfiguracaoRN();
		try {
			rn.iniciaConexaoBanco();
			crn.iniciaConexaoBanco();
			retorno = rn.getOpsParaIntegrar(crn.getConfiguracao(), cdop);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new OpsIntegracaoDTO();
		} finally {
			rn.finalizaConexaoBanco();
			crn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public PesquisasDTO pesquisarOmJob(PesquisaDTO filtro) {
		DiversosRN rn = new DiversosRN();
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarOmJob(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public ListaOmJobLogDTO pesquisarOmJoblog(FiltroPesquisaOmJobDTO filtro) {
		JobRN rn = new JobRN();
		ListaOmJobLogDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarOmJoblog(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaOmJobLogDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ListaOmJobdetLogDTO pesquisarOmJobdetlog(Long idJoblog) {
		JobRN rn = new JobRN();
		ListaOmJobdetLogDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarOmJobdetlog(idJoblog);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaOmJobdetLogDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public boolean setRegistroBarCode(IwsRegistroBarCodeDTO barcodeDTO) {
		ProducaoPdbaMsEvtRN rn = new ProducaoPdbaMsEvtRN();
		return rn.setRegistroBarCode(barcodeDTO);
	}

	public boolean getTr_ValidaLoginSenha(String login, String senha, int avaliar) {
		MaoDeObraPdbaMsEvtRN rn = new MaoDeObraPdbaMsEvtRN();
		return rn.getTr_ValidaLoginSenha(login, senha, avaliar);
	}

	public ListaTurnosDTO obtemTurnosPeriodo(OmPt ompt, Date dtHrIni, Date dtHrFim) {
		TurnoRN rn = new TurnoRN();
		ListaTurnosDTO retorno;

		retorno = new ListaTurnosDTO();
		retorno.setTurnos(new ArrayList<TurnoAtualDTO>());

		try {
			rn.iniciaConexaoBanco();
			retorno = new ListaTurnosDTO();
			retorno.setTurnos(rn.getTurnoAtualDTOsPeriodoComClone(ompt, dtHrIni, dtHrFim));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public OmEmpresaDTO getEmpresaAtiva() {
		EmpresaRN rn = new EmpresaRN();
		OmEmpresaDTO retorno = new OmEmpresaDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getEmpresaAtiva();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ListaRelatorioAlimentacaoDTO getListaRelatorioAlimentacaoDTO(Long idAlimentacao, boolean isApenasRealimentacao,
			Date dtHrInicioLeitura, Date dtHrFimLeitura) {
		DAOGenerico dao = new DAOGenerico();
		try {
			dao.iniciaConexaoBanco();
			RelatorioAlimentacaoRN relatorioAlimentacaoRN = new RelatorioAlimentacaoRN(dao);
			return relatorioAlimentacaoRN.getListaRelatorioAlimentacaoDTO(idAlimentacao, isApenasRealimentacao, dtHrInicioLeitura,
					dtHrFimLeitura);
		} catch (Exception e) {
			dao.rollBackTransacao();
			throw new RuntimeException(e);
		} finally {
			dao.finalizaConexaoBanco();
		}
	}

	public RelatorioParRegulagemDTO getParRegulagemDTO(FiltroRelatorioProdRegulagemDTO filtro) {
		RelatorioProdRegulagemRN rn = new RelatorioProdRegulagemRN();
		RelatorioParRegulagemDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getParRegulagemDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new RelatorioParRegulagemDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public RelatorioR100DTO getRelatorioR100DTO(FiltroR100DTO filtro) {
		RelatorioR100RN rn = new RelatorioR100RN();
		RelatorioR100DTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioR100DTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new RelatorioR100DTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public GTsDTO getOmGtLigadosAosPTs() {
		GTRN rn = new GTRN();
		GTsDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOmGtLigadosAosPTs();
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new GTsDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	// Marcos Sardinha: VFWEB - Injet
	public ListaCPDTO getPpCpByCdPtInjet(DAOGenericoInjet dao, OmPt ompt) {
		PlanejamentoInjetRN rn = new PlanejamentoInjetRN();
		ListaCPDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getPpCpByCdPtInjet(dao, ompt);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaCPDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public MontagensDTO getUltimaMontagemComSerial(String cb) {
		NumeroSerieRN rn = new NumeroSerieRN();
		MontagensDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getUltimaMontagemComSerial(cb);
		} catch (Exception e) {
			retorno = new MontagensDTO();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;

	}

	public void setDiarioBordo(DiarioBordoDTO obs) {
		DiarioBordoRN rn = new DiarioBordoRN();
		try {
			rn.iniciaConexaoBanco();
			rn.setDiarioBordo(obs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
	}

	public DiariosBordoDTO getDiariosBordoDTO(String ns) {
		DiarioBordoRN rn = new DiarioBordoRN();
		DiariosBordoDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getDiariosBordoDTO(ns);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new DiariosBordoDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public RelatorioR101DTO getRelatorioR101DTO(FiltroR101DTO filtro) {
		RelatorioR101RN rn = new RelatorioR101RN();
		RelatorioR101DTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioR101DTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new RelatorioR101DTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public MontagensDTO cancelarPalete(MontagensDTO palete) {
		PostoMontagemRN rn = new PostoMontagemRN();
		MontagensDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.cancelarPalete(palete);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new MontagensDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public MontagensDTO cancelarCaixa(String cbCaixa, String cdPt, String login, String motivo, String cdcp) {
		PostoMontagemRN rn = new PostoMontagemRN();
		MontagensDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.cancelarCaixa(cbCaixa, cdPt, login, motivo, cdcp);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new MontagensDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PTsDTO getGtsDoTtptDaFolha(DwFolha dwFolha) {
		GTRN rn = new GTRN();
		PTsDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOmGtsAtivosPorFolha(dwFolha);
		} catch (RegistroDesconhecidoException e) {
			retorno = new PTsDTO();
			retorno.setPts(new ArrayList<PtDTO>());
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public PesquisasDTO pesquisaDwTRefugoInjetToVF(PesquisaDTO filtro) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		DiversosInjetRN rn = new DiversosInjetRN(dao);
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwTRefugoInjetToVF(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;

		dao.finalizaSessao();

		return retorno;
	}

	public PesquisasDTO pesquisaDwTParadaInjetToVF(PesquisaDTO filtro) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		DiversosInjetRN rn = new DiversosInjetRN(dao);
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwTParadaInjetToVF(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}
	
	public ParadasGalpaoDTO pesquisaMaquinasParadasPorGalpao(String cdGalpao) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		DiversosInjetRN rn = new DiversosInjetRN(dao);
		ParadasGalpaoDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getParadasByGalpao(cdGalpao);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ParadasGalpaoDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}
	
	public AlertasGalpaoDTO pesquisaMaquinasEmAlertaPorGalpao(String cdGalpao) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		DiversosInjetRN rn = new DiversosInjetRN(dao);
		AlertasGalpaoDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getAlertasByGalpao(cdGalpao);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new AlertasGalpaoDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}
	
	public PesquisasDTO pesquisaDwTParadaInjetToVFCompleto(PesquisaDTO filtro) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		DiversosInjetRN rn = new DiversosInjetRN(dao);
		PesquisasDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisaDwTParadaInjetToVFCompleto(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	public ListaMSDTO pesquisarMsDTOExcesao(MsDTO msdto) {
		MsRN rn = new MsRN();
		ListaMSDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarMsDTOExcesao(msdto);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaMSDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public void transferirUps(MsDTO origem, MsDTO destino, IcDTO icupdto) {
		MsRN rn = new MsRN();
		try {
			rn.iniciaConexaoBanco();
			rn.transferirUps(origem, destino, icupdto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
	}

	public DwNserie getHistoricoNS(String cb) {
		DetalhePTRN rn = new DetalhePTRN();
		DwNserie retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getHistoricoNS(cb);
		} catch (Exception e) {
			retorno = new DwNserie();
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public MsEvt incluirEventoLog(EventoColetado evento) {
		MsEvt retorno;
		EventoRN rn = new EventoRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.incluirEventoLog(evento);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	public MsEvt incluirEvento(EventoColetado evento) {
		MsEvt retorno;
		EventoRN rn = new EventoRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.incluirEvento(evento);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public Boolean getIsRitmosempreNasHrsprod() {
		return isRitmosempreNasHrsprod;
	}

	
	public void setCepOPC(int zona, double valorlido, double idftparam, IcUpDTO dto,IcDTO Ic,String nrop) {
		
		if(zona==1){
			IdwLogger idwlog = new IdwLogger(Ic.getCd_ic());
			MsEvt retorno = new MsEvt();
			zona =1;
			EventoColetado evento1 = new EventoColetado();
			evento1.setCdop(nrop);
			evento1.setDthrEvento(new Date());
			evento1.setUp(dto.getUrlConexao());
			evento1.setVelocidade(new BigDecimal(idftparam));
			evento1.setTemperatura(new BigDecimal(valorlido, new MathContext(5)));
			evento1.setParametroLido(new BigDecimal(valorlido, new MathContext(5)) );
			evento1.setZona(Integer.valueOf(zona).byteValue());
			evento1.setTipoEvento(ServicoFactory._MEDICAO_TEMPERATURA_ZONAS_OPC);
			evento1.setIcUpDTO(dto);
			
			EventoRN rn = new EventoRN();
		
			try {
				
				rn.iniciaConexaoBanco();
				retorno = rn.incluirEvento(idwlog, idwlog.getIdAleatorio(), 0, evento1, MsTpevtTemplate.Type.PARAMETRO_MEDICAO.getId(), null);
			} catch (Exception e) {
				e.printStackTrace();
				retorno = null;
			} finally {
				rn.finalizaConexaoBanco();
			}
			return;
		}
		if(zona==2){
			IdwLogger idwlog = new IdwLogger(Ic.getCd_ic());
			MsEvt retorno = new MsEvt();
			zona =2;
			EventoColetado evento1 = new EventoColetado();
			evento1.setCdop(nrop);
			evento1.setDthrEvento(new Date());
			evento1.setUp(dto.getUrlConexao());
			evento1.setVelocidade(new BigDecimal(idftparam));
			evento1.setTemperatura(new BigDecimal(valorlido, new MathContext(5)));
			evento1.setParametroLido(new BigDecimal(valorlido, new MathContext(5)) );
			evento1.setZona(Integer.valueOf(zona).byteValue());
			evento1.setTipoEvento(ServicoFactory._MEDICAO_TEMPERATURA_ZONAS_OPC);
			evento1.setIcUpDTO(dto);
			EventoRN rn = new EventoRN();
			
			try {
				
				rn.iniciaConexaoBanco();
				retorno = rn.incluirEvento(idwlog, idwlog.getIdAleatorio(), 0, evento1, MsTpevtTemplate.Type.PARAMETRO_MEDICAO.getId(), null);
			} catch (Exception e) {
				e.printStackTrace();
				retorno = null;
			} finally {
				rn.finalizaConexaoBanco();
			}
			return;
		}
		if(zona==3){
			IdwLogger idwlog = new IdwLogger(Ic.getCd_ic());
			MsEvt retorno = new MsEvt();
			zona =3;
			EventoColetado evento1 = new EventoColetado();
			evento1.setCdop(nrop);
			evento1.setDthrEvento(new Date());
			evento1.setUp(dto.getUrlConexao());
			evento1.setVelocidade(new BigDecimal(idftparam));
			evento1.setTemperatura(new BigDecimal(valorlido, new MathContext(5)));
			evento1.setParametroLido(new BigDecimal(valorlido, new MathContext(5)) );
			evento1.setZona(Integer.valueOf(zona).byteValue());
			evento1.setTipoEvento(ServicoFactory._MEDICAO_TEMPERATURA_ZONAS_OPC);
			evento1.setIcUpDTO(dto);
			EventoRN rn = new EventoRN();
			
			try {
				
				rn.iniciaConexaoBanco();
				retorno = rn.incluirEvento(idwlog, idwlog.getIdAleatorio(), 0, evento1, MsTpevtTemplate.Type.PARAMETRO_MEDICAO.getId(), null);
			} catch (Exception e) {
				e.printStackTrace();
				retorno = null;
			} finally {
				rn.finalizaConexaoBanco();
			}
			return;
		}
		
		if(zona==4){
			IdwLogger idwlog = new IdwLogger(Ic.getCd_ic());
			MsEvt retorno = new MsEvt();
			zona =4;
			EventoColetado evento1 = new EventoColetado();
			evento1.setCdop(nrop);
			evento1.setDthrEvento(new Date());
			evento1.setUp(dto.getUrlConexao());
			evento1.setVelocidade(new BigDecimal(idftparam));
			evento1.setTemperatura(new BigDecimal(valorlido, new MathContext(5)));
			evento1.setParametroLido(new BigDecimal(valorlido, new MathContext(5)) );
			evento1.setZona(Integer.valueOf(zona).byteValue());
			evento1.setTipoEvento(ServicoFactory._MEDICAO_TEMPERATURA_ZONAS_OPC);
			evento1.setIcUpDTO(dto);
			EventoRN rn = new EventoRN();
			
			try {
				
				rn.iniciaConexaoBanco();
				retorno = rn.incluirEvento(idwlog, idwlog.getIdAleatorio(), 0, evento1, MsTpevtTemplate.Type.PARAMETRO_MEDICAO.getId(), null);
			} catch (Exception e) {
				e.printStackTrace();
				retorno = null;
			} finally {
				rn.finalizaConexaoBanco();
			}
			return;
		}
		
		if(zona==5){
			IdwLogger idwlog = new IdwLogger(Ic.getCd_ic());
			MsEvt retorno = new MsEvt();
			zona =5;
			EventoColetado evento1 = new EventoColetado();
			evento1.setCdop(nrop);
			evento1.setDthrEvento(new Date());
			evento1.setUp(dto.getUrlConexao());
			evento1.setVelocidade(new BigDecimal(idftparam));
			evento1.setTemperatura(new BigDecimal(valorlido, new MathContext(5)));
			evento1.setParametroLido(new BigDecimal(valorlido, new MathContext(5)) );
			evento1.setZona(Integer.valueOf(zona).byteValue());
			evento1.setTipoEvento(ServicoFactory._MEDICAO_TEMPERATURA_ZONAS_OPC);
			evento1.setIcUpDTO(dto);
			EventoRN rn = new EventoRN();
			
			try {
				
				rn.iniciaConexaoBanco();
				retorno = rn.incluirEvento(idwlog, idwlog.getIdAleatorio(), 0, evento1, MsTpevtTemplate.Type.PARAMETRO_MEDICAO.getId(), null);
			} catch (Exception e) {
				e.printStackTrace();
				retorno = null;
			} finally {
				rn.finalizaConexaoBanco();
			}
			return;
		}
		if(zona==0){
		IdwLogger idwlog = new IdwLogger(Ic.getCd_ic());
		MsEvt retorno = new MsEvt();
		
		EventoColetado evento1 = new EventoColetado();
		evento1.setDthrEvento(new Date());
		evento1.setCdop(nrop);
		evento1.setUp(dto.getUrlConexao());
		evento1.setVelocidade(new BigDecimal(idftparam));
		evento1.setTemperatura(new BigDecimal(valorlido, new MathContext(5)));
		evento1.setTipoEvento(ServicoFactory._MEDICAO_FT_PARAM_OPC);
		evento1.setIcUpDTO(dto);
		
		EventoRN rn = new EventoRN();
		
		try {
			
			rn.iniciaConexaoBanco();

			retorno = rn.incluirEvento(idwlog, idwlog.getIdAleatorio(), 0, evento1, MsTpevtTemplate.Type.PARAMETRO_MEDICAO.getId(), null);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return;
		}
		
	}

	public static void main(String[] args) {
		PassagensDTO dto = IdwFacade.getInstancia().getPassagens("FTP_08_LIN01", "A433D7C4D734");
		if (dto.getNcs() == null || dto.getNcs().isEmpty())
			System.out.println("sem nc");
		
	}
	public PassagensDTO getPassagens(String cdPt, String codigoBarras) {
		PassagensDTO retorno;
		
		VerificaPassagemRN rn = new VerificaPassagemRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getPassagens(cdPt, codigoBarras);
		} catch (Exception e ) {
			e.printStackTrace();
			retorno = new PassagensDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	
	public void trocarOP(String cdpt, String nrop, Date dthrevento) {
		CpRN rn = new CpRN();
		try {
			rn.iniciaConexaoBanco();
			rn.trocarOP(cdpt, nrop, dthrevento);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
	}
	
	public PassagensDTO getPassagensQC(String cdPt, String codigoBarras) {
		PassagensDTO retorno;
		
		VerificaPassagemRN rn = new VerificaPassagemRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getPassagensQC(cdPt, codigoBarras);
		} catch (Exception e ) {
			e.printStackTrace();
			retorno = new PassagensDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}


	public GraficoParettoLogVRotSDTO getGraficoParettoLogVRot(FiltroDetalheLogVRotDTO filtro) {
		OcorrenciaParettoLogVRotRN rn = new OcorrenciaParettoLogVRotRN();
		GraficoParettoLogVRotSDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getGraficoParettoLogVRotRN(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public ProdutosDTO pesquisarProdutosComBanco(String cdProduto) {
		ProdutoRN rn = new ProdutoRN();
		ProdutosDTO retorno = new ProdutosDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarProdutosComBanco(cdProduto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	
	public void registrarBatismoBC(String cb, String idRegistro) {
		IdwLogger log = new IdwLogger("batismo");
		NumeroSerieRN rn = new NumeroSerieRN();
		try {
			rn.iniciaConexaoBanco();
			rn.registrarBatismoBC(log, cb, idRegistro);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("nao batizou " + cb, e);
		} finally {
			rn.finalizaConexaoBanco();
		}
	}
	
	public ListaCPDTO definePpCpParaOProduto(OmGt omgt, String cdproduto, String nrop) {
		CpRN rn = new CpRN();
		ListaCPDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.definePpCpParaOProduto(omgt, cdproduto, nrop);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaCPDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	
	public  List<DwPassagem> pesquisarPassagensDoCbNoPosto(String cdPt, List<Object> cbs) {
		NumeroSerieRN rn = new NumeroSerieRN();
		List<DwPassagem> retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarPassagensDoCbNoPosto(cdPt, cbs);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ArrayList<>();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	
	public List<OmMapapa> obtemPaSemAlimentacao(String cdup) throws SemFeedersException, PostoSemDadoException{
		AlimentacaoRN rn = new AlimentacaoRN();
		List<OmMapapa> retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.obtemPaSemAlimentacao(cdup);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ArrayList<>();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	
	public ListaIwsAgendaDeParadaDTO getAgendaParada(String cdPt){
		DAOGenericoInjet dao = new DAOGenericoInjet();
		DiversosInjetRN rn = new DiversosInjetRN(dao);
		ListaIwsAgendaDeParadaDTO retorno = new ListaIwsAgendaDeParadaDTO();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getAgendaParada(cdPt);			
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaIwsAgendaDeParadaDTO();
			retorno.setAgendaParadas(new ArrayList<IwsAgendaDeParadaDTO>());
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;

		dao.finalizaSessao();

		return retorno;		
	}
	
	public String getLoteProdutivo(String cdPt){
		DAOGenericoInjet dao = new DAOGenericoInjet();
		DiversosInjetRN rn = new DiversosInjetRN(dao);
		String retorno = "";
		
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getLoteProdutivo(cdPt);			
		} catch (Exception e) {
			e.printStackTrace();
			retorno = "";
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;

		dao.finalizaSessao();

		return retorno;		
	}

	
	public Integer getProducaoPorCiclo(String cdpt) {
		FolhaRN rn = new FolhaRN();
		Integer retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getProducaoPorCiclo(cdpt);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = 0;
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		
		return retorno;
	}
	
	public EventoAOIDTO processaArquivoAoi(String cdup, String nrop, String nomeArquivo,  String conteudoArquivo, EventoColetado eventos) {
		EventosAOIRN rn = new EventosAOIRN();
		EventoAOIDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			//retorno = rn.processaArquivoAoi(cdup, nrop, nomeArquivo, conteudoArquivo, eventos);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new EventoAOIDTO();
			retorno.setStEnvio(EventoAOIDTO._ST_ENVIO._FALHA.getStEnvio());
			retorno.setCdParada(e.getMessage());
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		
		return retorno;
	}
	
	public EmailDTO enviarEmail(EmailDTO email)  {
		EnviarEmail rn = new EnviarEmail();
		EmailDTO retorno = rn.enviarEmail(email);
		return retorno;
	}

    public String getOpOndeMPUsadapeloCF(String ns, String cdproduto) {
    	NumeroSerieRN rn = new NumeroSerieRN();
    	String retorno;
    	try {
    		rn.iniciaConexaoBanco();
    		retorno = rn.getOpOndeMPUsadapeloCF(ns, cdproduto);
    	} catch(Exception e) {
    		e.printStackTrace();
    		retorno = "";
    	} finally {
    		rn.finalizaConexaoBanco();
    	}
    	return retorno;
    }
    
	public String getCdProdSistCorp(String cdProduto){
		DAOGenericoInjet dao = new DAOGenericoInjet();
		DiversosInjetRN rn = new DiversosInjetRN(dao);
		String retorno = "";
		
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getCdProdSistCorp(cdProduto);	
		} catch (Exception e) {
			e.printStackTrace();
			retorno = "";
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;

		dao.finalizaSessao();

		return retorno;		
	}

	public MateriaPrimaSemp getStatusSempMateriaPrima(String cdup, String op, String cdComponente) {
		// TODO Auto-generated method stub
		MateriaPrimaSemp retorno = null;
		//Luiz 20200220 É retirado os 2 primeiros digitos, pois o SISAP despreza os 2 primeiros digitos da op
		op = op.substring(2);
		cdComponente = "425010";
		String resp = null;
		HttpURLConnection conn = null;
		try{
			
			String urlAux = 
			"http://sisap.semptcl.mao/API/Funcoes/ObterDadosEstoque?numOp="+op;
			
			URL url = new URL(urlAux);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
                        
            //conn.setRequestProperty("Accept", "application/json");
            int resposta = conn.getResponseCode();
            if(resposta == HttpURLConnection.HTTP_OK) {
            	BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            	String inputLine;
    			StringBuffer response = new StringBuffer();

    			while ((inputLine = in.readLine()) != null) {
    				response.append(inputLine);
    			}
    			in.close();
    			resp = response.toString();
            }
            conn.disconnect();
            if(resp != null && resp.equals("") == false) {
			JsonParser parser = new JsonParser();
            JsonArray listaMp = (JsonArray) parser.parse(resp);
            String componente = "";
            int i = 0;
            for(Object o: listaMp) {
            	if(i==299){
            		System.out.println("achei");
            	}
            	JsonObject mpObj = (JsonObject) o;
            	componente = mpObj.get("MATERIAL").toString();
            	componente = componente.replace("\"", "");
            	componente = componente.substring(componente.length() - 6);
            	if(componente.equals(cdComponente)) {
            		retorno = new MateriaPrimaSemp();
            		retorno.setQtdeComprada(mpObj.get("CONSQTY").toString().replace("\"", ""));
            		retorno.setQtdePrevista(mpObj.get("NECQTY").toString().replace("\"", ""));
            		retorno.setQtdeRestante(mpObj.get("PENDQTY").toString().replace("\"", ""));
            		return retorno;
            	}
            	i++;
            }
            } else {
            	Log.info("Não obtive resposta da API para a op: "+op);
            	return null;
            }
		} catch(Exception e){
			e.printStackTrace();
			conn.disconnect();
		}
		
		
		return retorno;
	}    
	
	
	
	public ListaTipoGTDTO getTipoGTDTO(TipoGTDTO filtro) {
		TipoGTRN rn = new TipoGTRN();
		ListaTipoGTDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTipoGTDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaTipoGTDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	
	
	public TipoGTDTO setTipoGTDTO(TipoGTDTO dto) {
		TipoGTRN rn = new TipoGTRN();
		TipoGTDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setTipoGTDTO(dto);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new TipoGTDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	
	public TipoGTDTO excluirTipoGTDTO(TipoGTDTO filtro) {
		TipoGTRN rn = new TipoGTRN();
		TipoGTDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.excluirTipoGTDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new TipoGTDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	




	public ListaTipoPTDTO getTipoPTDTO(TipoPTDTO filtro) {
		TipoPTRN rn = new TipoPTRN();
		ListaTipoPTDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getTipoPTDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaTipoPTDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	
	
	public TipoPTDTO setTipoPTDTO(TipoPTDTO dto) {
		TipoPTRN rn = new TipoPTRN();
		TipoPTDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setTipoPTDTO(dto);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new TipoPTDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	
	public TipoPTDTO excluirTipoPTDTO(TipoPTDTO filtro) {
		TipoPTRN rn = new TipoPTRN();
		TipoPTDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.excluirTipoPTDTO(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new TipoPTDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	
	public List<OmGt> pesquisasrOmGtDosPostosQueApontamProducao() {
		GTRN rn = new GTRN();
		List<OmGt> retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisasrOmGtDosPostosQueApontamProducao();
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ArrayList<OmGt>();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	public DashboardFlexDTO producao(String cdGt, String dthr) throws GtDesconhecidoException, PtDesconhecidoException, ParseException, TurnoDesconhecidoException, SemCicloPadraoException, SemCalendarioException {
		DashboardFlexRN rn = new DashboardFlexRN();
		DashboardFlexDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.producao(cdGt, dthr);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new DashboardFlexDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public Integer getIdEmpresaInjet(){
		ConfiguracaoRN rn = new ConfiguracaoRN();
		Integer retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getConfiguracao().getOmEmpresa().getIdEmpresa().intValue();
		} catch (Exception e) {
			e.printStackTrace();
			retorno = 0;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}


	public FolhasInspecaoRapDTO pesquisarFolhasInspecaoRAP(FiltroFolhaInspecaoRapDTO filtro) {
		FolhaInspecaoRapRN rn = new FolhaInspecaoRapRN();
		FolhasInspecaoRapDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarFolhasInspecaoRAP(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public FolhasInspecaoRapDTO pesquisarFolhaInspecaoRAPById(Long id) {
		FolhaInspecaoRapRN rn = new FolhaInspecaoRapRN();
		FolhasInspecaoRapDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarFolhaInspecaoRAPById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	public ParametrosDTO pesquisarVariavelMedicao(String variavel) {
		ParametroRN rn = new ParametroRN();
		ParametrosDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarVariavelMedicao(variavel);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}


	public FolhasInspecaoRapDTO excluirFolhaInspecaoRAP(Long idFolhainsrap, Long idusr) {
		FolhaInspecaoRapRN rn = new FolhaInspecaoRapRN();
		FolhasInspecaoRapDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.excluirFolhaInspecaoRAP(idFolhainsrap, idusr);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	
	
	public GruposFerramentaDTO pesquisarGrupoRAP(String variavel) {
		GrupoFerramentaRN rn = new GrupoFerramentaRN();
		GruposFerramentaDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarGrupoFerramenta(variavel);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	
	
	public DwRapListDTO pesquisarRAP(String variavel) {
		DwRapRN rn = new DwRapRN();
		DwRapListDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarRAP(variavel);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	
	
	public DwTprapsDTO pesquisarTipoRAP(String variavel) {
		DwRapRN rn = new DwRapRN();
		DwTprapsDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarTipoRAP(variavel);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	
	
	public FolhasInspecaoRapDTO salvarFolhaInspecaoRAP(FiltroFolhaInspecaoRapDTO rapdto) {
		FolhaInspecaoRapRN rn = new FolhaInspecaoRapRN();
		FolhasInspecaoRapDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.salvarFolhaInspecaoRAP(rapdto);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	
	public FerramentaDTO pesquisarNCsFerramentaByCd(String cdrap) {
		DwRapRN rn = new DwRapRN();
		FerramentaDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarNCsFerramentaByCd(cdrap);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public LocalEstoqueDTO validarLocalEstoque(String cdlocalOrigem, String cdlocalDestino, String cdrap) {
		LocalEstoqueRN rn = new LocalEstoqueRN();
		LocalEstoqueDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.validarLocalEstoque(cdlocalOrigem, cdlocalDestino, cdrap);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	
	
	public SucessoDTO movimentarFerramenta(String cdLocalOrigem, String cdLocalDestino, String cdrap, String login) {
		EstoqueRN rn = new EstoqueRN();
		SucessoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.movimentarFerramenta(cdLocalOrigem, cdLocalDestino, cdrap, login);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public QqInsRapDTO salvarInspecaoFerramenta(LocalEstoqueDTO local) {
		FolhaInspecaoRapRN rn = new FolhaInspecaoRapRN();
		QqInsRapDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.salvarInspecaoFerramenta(local);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}


	public ProdutosDTO pesquisarProdutos(String variavel) {
		ProdutoRN rn = new ProdutoRN();
		ProdutosDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarProdutos(variavel);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}


	public TiposOSDTO pesquisarTiposOs(String valor) {
		TipoOSRN rn = new TipoOSRN();
		TiposOSDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarTiposOs(valor);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public TiposEstoqueDTO pesquisarTiposEstoque(String valor) {
		EstoqueRN rn = new EstoqueRN();
		TiposEstoqueDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarTiposEstoque(valor);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	public EstoquesDTO pesquisarEstoque(String valor) {
		EstoqueRN rn = new EstoqueRN();
		EstoquesDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarEstoque(valor);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	
	public CcsDTO getOmCcPorLikeCdDs(String valor) {
		CcRN rn = new CcRN();
		CcsDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOmCcPorLikeCdDs(valor);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	
	public RoteirosInspecaoDTO pesquisarRoteiroInspecao(RoteiroInspecaoDTO dto) {
		RoteiroInspecaoRN rn = new RoteiroInspecaoRN();
		RoteirosInspecaoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			
			retorno = rn.pesquisarRoteiroInspecao(dto);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public RoteirosInspecaoDTO pesquisarRoteiroInspecaoById(Long id) {
		RoteiroInspecaoRN rn = new RoteiroInspecaoRN();
		RoteirosInspecaoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			
			retorno = rn.pesquisarRoteiroInspecaoById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}


	public RoteirosInspecaoDTO salvarRoteiroInspecao(RoteiroInspecaoDTO dto) {
		RoteiroInspecaoRN rn = new RoteiroInspecaoRN();
		RoteirosInspecaoDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			
			retorno = rn.salvarRoteiroInspecao(dto);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public List<CodigoDescricaoDTO> getListaParadasAtivasPT(String cdMaquina) {
		DiversosRN rn = new DiversosRN();
		List<CodigoDescricaoDTO> retorno = new ArrayList<CodigoDescricaoDTO>();

		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getListaParadasAtivasPT(cdMaquina);	 
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}
	
	public DadosTempoRealDTO getDadosTempoReal(String cdMaquina) {
		DiversosRN rn = new DiversosRN();
		DadosTempoRealDTO retorno = new DadosTempoRealDTO();

		try {
			rn.iniciaConexaoBanco();
			
			retorno = rn.getDadosTempoReal(cdMaquina);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}
	
	public GTsDTO pesquisarGtdeUmFaseQueTenhaPts(String cdFase) {
		GTRN rn = new GTRN();
		GTsDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			
			retorno = rn.pesquisarGtdeUmFaseQueTenhaPts(cdFase);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	
	public RealimentacaoDTO getRealimentacaoDTO(String cdpt, String cdmapa, String cdpa) {
		AlimentacaoRN rn = new AlimentacaoRN();
		RealimentacaoDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getRealimentacaoDTO(cdpt, cdmapa, cdpa);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}




	public RealimentacaoDTO setRealimentacaoDTO(String cdpt, String cdmapa, String cdpa, String cdproduto, String cbLido, Double quantidade, Boolean isSucesso, String matricula) {
		AlimentacaoRN rn = new AlimentacaoRN();
		RealimentacaoDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setRealimentacaoDTO(cdpt, cdmapa, cdpa, cdproduto, cbLido, quantidade, isSucesso, matricula);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}




	public MonitorizacoesAlimsDTO getAlimentacaoDTO(String cdpt, String filtrar) {
		MonitorizacoesAlimsDTO retorno = null;
		MonitorizacaoAlimentacaoByReelRN rn = new MonitorizacaoAlimentacaoByReelRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.monitorizacaoAlimentacao(cdpt, filtrar);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	
	public MonitorizacoesAlimsDTO historicoAlimentacao(String cdpt, String cdpa) {
		MonitorizacoesAlimsDTO retorno = null;
		MonitorizacaoAlimentacaoByReelRN rn = new MonitorizacaoAlimentacaoByReelRN();
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.historicoAlimentacao(cdpt, cdpa);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}




	public MapasCODTO getMapasAlimentacaoDTO(String cdpt) {
		MapaAlimentacaoRN rn = new MapaAlimentacaoRN();
		Session sessao = null;
		MapasCODTO mapas = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			mapas = rn.getMapasDTO(cdpt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return mapas;
	}

	
	public MapaCODTO getMapaAlimentacaoDTO(String cdpt, String cdmapa) {
		MapaAlimentacaoRN rn = new MapaAlimentacaoRN();
		Session sessao = null;
		MapaCODTO mapa = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			mapa = rn.getMapaDTO(cdpt, cdmapa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return mapa;
	}




	public MonitorizacoesAlimsDTO setAlimentacaoDTO(idw.model.rn.alimentacao.AlimentacaoDTO alimentacaodto) {
		AlimentacaoRN rn = new AlimentacaoRN();
		MonitorizacoesAlimsDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setAlimentacaoDTO(alimentacaodto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}






	public ReelidDTO getReelidDTO(String reelid) {
		AlimentacaoRN rn = new AlimentacaoRN();
		ReelidDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getReelidDTO(reelid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}





	public MapasDTO getMapaCorrenteDTO(String cdlinha) {
		MapaAlimentacaoRN rn = new MapaAlimentacaoRN();
		MapasDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getMapaCorrenteDTO(cdlinha);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}
	
	
	
	
	
	
	public MonitorizacoesAlimsDTO setConferenciaDTO(idw.model.rn.alimentacao.AlimentacaoDTO alimentacaodto) {
		AlimentacaoRN rn = new AlimentacaoRN();
		MonitorizacoesAlimsDTO retorno = null;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.setConferenciaDTO(alimentacaodto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}

	
	public MapasCODTO getMapasGT(String cdgt) {
		MapaAlimentacaoRN rn = new MapaAlimentacaoRN();
		Session sessao = null;
		MapasCODTO mapas = null;
		try {
			sessao = iniciaSessao();
			iniciaTransacao(sessao);
			rn.setSession(sessao);
			mapas = rn.getMapasGT(cdgt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sessao != null)
				commitaTransacao(sessao);
		}
		rn = null;
		return mapas;
	}

	public AnalisesGtIADTO analiseIaWmGtsReturn() {
		ConsultasWebWmRN rn = new ConsultasWebWmRN("", "");
		AnalisesGtIADTO monitorizacaoDTO = new AnalisesGtIADTO();
		try {
			rn.iniciaConexaoBanco();
			monitorizacaoDTO = rn.getAnaliseGtsWM();
			///monitorizacaoDTO = null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return monitorizacaoDTO;
	}
	
	
	public void analiseIaWmGts() {
		ConsultasWebWmRN rn = new ConsultasWebWmRN("", "");
		AnalisesGtIADTO monitorizacaoDTO = new AnalisesGtIADTO();
		try {
			rn.iniciaConexaoBanco();
			monitorizacaoDTO = rn.getAnaliseGtsWM();
			///monitorizacaoDTO = null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		
	}		
	
	public ListaCPDTO getOpsGT(String cdgt) {
		CpRN rn = new CpRN();
		ListaCPDTO retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.getOpsGT(cdgt);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = new ListaCPDTO();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	// Ricardo: 06/03/2023
	public boolean getIsSimuladorLigado() {
		return isSimuladorLigado;
	}
	public void setIsSimuladorLigado(boolean ligado) {
		this.isSimuladorLigado = ligado;
	}
	
}
