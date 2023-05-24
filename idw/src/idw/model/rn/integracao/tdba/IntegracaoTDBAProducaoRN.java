package idw.model.rn.integracao.tdba;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.OmJobdet;
import idw.model.pojos.OmJobdetlog;
import idw.model.pojos.OmJoblog;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.CpRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.model.rn.detalhemonitorizacao.IndicadoresDoDetalheRN;
import idw.util.IdwLogger;
import idw.webservices.dto.DetalheMonitorizacaoPTInjetDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.PTsDTO;
import idw.webservices.dto.PtDTO;
import idw.webservices.dto.TurnoAtualDTO;

public class IntegracaoTDBAProducaoRN extends AIntegracaoTDBA {

	public IntegracaoTDBAProducaoRN(DAOGenerico dao, DAOGenericoErp daoERP) {
		super(dao, daoERP);
	}

	/* A exportação dos dados de produção ocorrem apos o final do turno
	 * mas a verificação do final de turno é feita no tempo definido no job
	 */
	@Override
	public boolean integrar(OmJoblog joblog, OmJobdet det, IdwLogger log, int idLog) {
		boolean isRetorno = false;
		
		// Abrir DAO com session
		DAOGenerico daoSessao = new DAOGenerico();

		
		try {
			daoSessao.iniciaConexaoBanco();

			Date dthr = DataHoraRN.getDataHoraAtual();
			
			// Obtem a lista de postos de trabalho para avaliação das exportacoes
			PTRN ptrn = new PTRN(daoSessao);
			PTsDTO listaPts;
			try {
				listaPts = ptrn.getOmPtAtivos();
			} catch (RegistroDesconhecidoException e1) {
				log.info(idLog, 0, "Não existe postos ativos");
				// Incluir o resultado da importação do registro
				OmJobdetlog detlog = new OmJobdetlog();
				detlog.setIdJobdetlog(null);
				detlog.setDsExecucao(getResultado());
				detlog.setDthrIexecucao(dthr);
				detlog.setDthrFexecucao(DataHoraRN.getDataHoraAtual());
				detlog.setOmJoblog(joblog);
				detlog.setOmJobdet(det);
				detlog.setUrlOrigem("não existem postos ativos");
				detlog.setStExecucao((byte) (getStregistro() == 1 ? 1 : 0));
	
				daoSessao.makePersistent(detlog);
	
				return false;
			}
			
			
			Map<Long, PpCp> cps = new HashMap<>();
			
			for (PtDTO dto : listaPts.getPts()) {
				OmPt ompt = dto.getPt();
				// Obtem a referencia do turno anterior
				Date dthrAtual = DataHoraRN.getDataHoraAtual();
				TurnoRN trn = new TurnoRN(daoSessao);
				TurnoAtualDTO turnoAtual;
				try {
					turnoAtual = trn.getTurnoAtualDTO(ompt, dthrAtual);
				} catch (SemCalendarioException e) {
					continue;
				}
				TurnoAtualDTO turnoAnterior;
				try {
					turnoAnterior = trn.getTurnoAnteriorDTOPassandoIdPtEDtTurnoEIdTurno(ompt, turnoAtual.getDtReferencia(), turnoAtual.getIdTurno(), turnoAtual);
				} catch (SemCalendarioException e) {
					continue;
				}
				
				System.out.println("turno Anterior: " + turnoAnterior.toString());
				System.out.println("turno Atual: " + turnoAtual.toString());
				
				// Obtem a lista de OPs a serem exportadas que possuem produção no turno anterior
				CpRN crn = new CpRN(daoSessao);
				List<PpCp> cpsAux = crn.pesquisarPpCpQuePassaramNaDataDoPt(turnoAnterior.getDtHrITurno(), turnoAnterior.getDtHrFTurno(), ompt);
				
				// Varre cada OP
				for (PpCp cpAux : cpsAux) {
					// Verifica se ja existe na lista de ops a serem exportadas. Se sim, desconsiderar
					if (cps.containsKey(cpAux.getIdCp()))
						continue;
					
					
					// Para cada OP verifica se ja foi exportada
					if (isOpExportadaNoTurnoAnterior(cpAux, turnoAnterior) == false) {
						DetalheMonitorizacaoPTInsertRN rnid =  new DetalheMonitorizacaoPTInsertRN(daoSessao);
	
						FiltroDetalhePTInjetDTO filtro = new FiltroDetalhePTInjetDTO();
						
						filtro.setDtReferencia(turnoAnterior.getDtReferencia());
						filtro.setDwTurno(turnoAnterior.getDwturno());
						filtro.setTpId(DwConsolidTemplate.TpId.TURNO.getValue());
	//					filtro.setOmGt(omobj.getOmGtByIdGtfilho());
						filtro.setOmPt(ompt);
						filtro.setPpCp(cpAux);
						filtro.setFiltroOp(1); // se fosse 0 pesquisaria a ultima op, 1 pesquisa determinada op
						
						List<DwConsolid> ids = rnid.pesquisarDwConsolids(log, filtro);
						
						// Pesquisar os apontamentos
						DetalheMonitorizacaoPTInjetDTO detalhe = new DetalheMonitorizacaoPTInjetDTO();
						IndicadoresDoDetalheRN iRN = new IndicadoresDoDetalheRN(
								daoSessao, 
								log, 
								omcfg, 
								ids,
								false /* isRecuperarListaProdutos */, 
								false /* isRecuperarListaOperadores */,
								false /* isRecuperarListaAlertas */, 
								false /* isRecuperarListaPerdas */,
								false /* isRecuperarListaResumoDatas */, 
								false /* isRecuperarListaResumoTurnos */, 
								detalhe, 
								filtro);
						
						iRN.setResumoIndicadores();
						
						// incluir o apontamento de produção.
						incluirMiReport(turnoAnterior, ompt, cpAux, detalhe);
						
					}
	
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			daoSessao.finalizaConexaoBanco();
		}
		
		return isRetorno;
	}

	private void incluirMiReport(TurnoAtualDTO turnoAnterior, OmPt ompt, PpCp cpAux, DetalheMonitorizacaoPTInjetDTO detalhe) {
		// incluir registro
		MapQuery q = new MapQuery(daoERP.getSession());
		q.append("insert into mi_report (nr_ord_prod, sequencia, cd_posto, dthr_inicio, dthr_termino, dthr_inicio_periodo_coleta, dthr_final_periodo_coleta, qt_produzida, qt_refugada, qt_estorno_refugada, tempo_liquido, tempo_parada, fim_op, fim_producao, cd_usuario, st_registro, dthr_cadastro)");
		q.append("values (:nr_ord_prod, :sequencia, :cd_posto, :dthr_inicio, :dthr_termino, :dthr_inicio_periodo_coleta, :dthr_final_periodo_coleta, ");
		q.append(":qt_produzida, :qt_refugada, :qt_estorno_refugada, :tempo_liquido, :tempo_parada, :fim_op, :fim_producao, :cd_usuario, :st_registro, :dthr_cadastro)");

		q.querySQL().setString("nr_ord_prod", cpAux.getNrop());
		q.querySQL().setInteger("sequencia", 1); // como pegar esse dado de cdcp
		q.querySQL().setString("cd_posto", ompt.getCdPt());
		q.querySQL().setTimestamp("dthr_inicio", cpAux.getDthrInicioreal());
		q.querySQL().setTimestamp("dthr_termino", cpAux.getDthrFinalreal());
		q.querySQL().setTimestamp("dthr_inicio_periodo_coleta", turnoAnterior.getDtHrITurno());
		q.querySQL().setTimestamp("dthr_final_periodo_coleta", turnoAnterior.getDtHrFTurno());
		if (detalhe.getQtdProduzida() != null)
			q.querySQL().setDouble("qt_produzida", detalhe.getQtdProduzida());
		else
			q.querySQL().setDouble("qt_produzida", 0d);
		if (detalhe.getQtdRefugadas() != null)
			q.querySQL().setDouble("qt_refugada", detalhe.getQtdRefugadas());
		else
			q.querySQL().setDouble("qt_refugada", 0d);
		q.querySQL().setDouble("qt_estorno_refugada", 0d); // ve como pegar esse valor
		
		if (detalhe.getTempoAtivo() != null)
			q.querySQL().setDouble("tempo_liquido", detalhe.getTempoAtivo());
		else
			q.querySQL().setDouble("tempo_liquido", 0d);
		if (detalhe.getTempoParadas() != null)
			q.querySQL().setDouble("tempo_parada", detalhe.getTempoParadas());
		else
			q.querySQL().setDouble("tempo_parada", 0d);
		
		q.querySQL().setInteger("fim_op", 0); // como detectar se a op terminou, comparar o total da op com o planejado
		q.querySQL().setInteger("fim_producao", 0); // como detectar se eh fim da produção???? se fim_op eh true e a op nao continuou no proximo turno
		q.querySQL().setString("cd_usuario", ""); // operador com maior tempo logado
		q.querySQL().setInteger("st_registro", 0);
		q.querySQL().setTimestamp("dthr_cadastro", DataHoraRN.getDataHoraAtual());
		
		q.querySQL().executeUpdate();
		
		
	}

	// Metodo para avaliar se a OP já foi exportado
	private boolean isOpExportadaNoTurnoAnterior(PpCp cpAux, TurnoAtualDTO turnoAnterior) {
		MapQuery q = new MapQuery(daoERP.getSession());
		q.append("select * from mi_report where nr_ord_prod = :nrop and cd_posto = :cdposto and dthr_inicio_periodo_coleta = :inicio and dthr_final_periodo_coleta = :fim");

		q.querySQL().setString("nrop", cpAux.getNrop());
		q.querySQL().setString("cdposto", cpAux.getOmPt().getCdPt());
		q.querySQL().setTimestamp("inicio", turnoAnterior.getDtHrITurno());
		q.querySQL().setTimestamp("fim", turnoAnterior.getDtHrFTurno());
		
		List<Object> lista = q.querySQL().list();
		
		return lista.size() > 0;

	}

}
