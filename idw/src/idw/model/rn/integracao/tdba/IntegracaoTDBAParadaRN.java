package idw.model.rn.integracao.tdba;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
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
import idw.model.rn.monitorizacao.detalhes.GraficoParettoParadaRN;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoParadaDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParettoParadaDTO;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.PTsDTO;
import idw.webservices.dto.PtDTO;
import idw.webservices.dto.TurnoAtualDTO;

public class IntegracaoTDBAParadaRN extends AIntegracaoTDBA {

	public IntegracaoTDBAParadaRN(DAOGenerico dao, DAOGenericoErp daoERP) {
		super(dao, daoERP);
	}

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
					turnoAnterior = trn.getTurnoAnteriorDTOPassandoIdPtEDtTurnoEIdTurno(ompt, turnoAtual.getDtReferencia(),
							turnoAtual.getIdTurno(), turnoAtual);
				} catch (SemCalendarioException e) {
					continue;
				}

				// Obtem a lista de OPs a serem exportadas que possuem produção no turno anterior
				CpRN crn = new CpRN(daoSessao);
				List<PpCp> cpsAux =
						crn.pesquisarPpCpQuePassaramNaDataDoPt(turnoAnterior.getDtHrITurno(), turnoAnterior.getDtHrFTurno(), ompt);

				// Varre cada OP
				for (PpCp cpAux : cpsAux) {
					// Verifica se ja existe na lista de ops a serem exportadas. Se sim, desconsiderar
					if (cps.containsKey(cpAux.getIdCp()))
						continue;
					
					
					

					FiltroDetalhePTInjetDTO filtro = new FiltroDetalhePTInjetDTO();

					filtro.setDtReferencia(turnoAnterior.getDtReferencia());
					filtro.setDwTurno(turnoAnterior.getDwturno());
					filtro.setTpId(DwConsolidTemplate.TpId.TURNO.getValue());
					// filtro.setOmGt(omobj.getOmGtByIdGtfilho());
					filtro.setOmPt(ompt);
					filtro.setPpCp(cpAux);
					filtro.setFiltroOp(1); // se fosse 0 pesquisaria a ultima op, 1 pesquisa determinada op

					
					// Pesquisar paradas
					GraficoParettoParadaRN rn = new GraficoParettoParadaRN(daoSessao);
					GraficosParettoParadaDTO paradas = rn.getGraficoParettoParadaBIDTO(filtro, true, true, BigDecimal.ZERO);
					
					for (GraficoParettoParadaDTO parada : paradas.getParadas()) {
						
						// Verifica se ja existe a parada
						if (isParadaExiste(turnoAnterior, ompt, cpAux, parada) == false) {
							// incluir o apontamento de produção.
							incluirMiReportParadas(turnoAnterior, ompt, cpAux, parada);
						}
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("IntegracaoTDBAParadaRN", e);
		} finally {
			daoSessao.finalizaConexaoBanco();
		}

		return isRetorno;

	}

	private boolean isParadaExiste(TurnoAtualDTO turnoAnterior, OmPt ompt, PpCp cpAux, GraficoParettoParadaDTO parada) {
		MapQuery q = new MapQuery(daoERP.getSession());
		q.append("select * from mi_report_paradas where nr_ord_prod = :nrop and cd_posto = :cdposto and cd_parada = :cdparada and dthr_inicio_periodo_coleta = :inicio and dthr_final_periodo_coleta = :fim");

		q.querySQL().setString("nrop", cpAux.getNrop());
		q.querySQL().setString("cdposto", cpAux.getOmPt().getCdPt());
		q.querySQL().setString("cdparada", parada.getCdParada());
		q.querySQL().setTimestamp("inicio", turnoAnterior.getDtHrITurno());
		q.querySQL().setTimestamp("fim", turnoAnterior.getDtHrFTurno());
		
		List<Object> lista = q.querySQL().list();
		
		return lista.size() > 0;

	}

	private void incluirMiReportParadas(TurnoAtualDTO turnoAnterior, OmPt ompt, PpCp cpAux, GraficoParettoParadaDTO parada) {
		MapQuery q = new MapQuery(daoERP.getSession());
		q.append("insert into mi_report_paradas (nr_ord_prod, sequencia, cd_posto, cd_parada, tempo_total_parada, dthr_inicio_periodo_coleta, dthr_final_periodo_coleta, ");
		q.append("cd_usuario, inicio_processo, st_registro, dthr_cadastro)");
		q.append("values (:nr_ord_prod, :sequencia, :cd_posto, :cd_parada, :tempo_total_parada, :dthr_inicio_periodo_coleta, :dthr_final_periodo_coleta, ");
		q.append(":cd_usuario, :inicio_processo, :st_registro, :dthr_cadastro)");

		q.querySQL().setString("nr_ord_prod", cpAux.getNrop());
		q.querySQL().setInteger("sequencia", 1); // como pegar esse dado de cdcp
		q.querySQL().setString("cd_posto", ompt.getCdPt());
		q.querySQL().setString("cd_parada", parada.getCdParada());
		q.querySQL().setTimestamp("dthr_inicio_periodo_coleta", turnoAnterior.getDtHrITurno());
		q.querySQL().setTimestamp("dthr_final_periodo_coleta", turnoAnterior.getDtHrFTurno());
		q.querySQL().setInteger("inicio_processo", 0);
		
		if (parada.getTempo() != null)
			q.querySQL().setDouble("tempo_total_parada", parada.getTempo());
		else
			q.querySQL().setDouble("tempo_total_parada", 0d);
		
		q.querySQL().setString("cd_usuario", ""); // operador com maior tempo logado
		q.querySQL().setInteger("st_registro", 0);
		q.querySQL().setTimestamp("dthr_cadastro", DataHoraRN.getDataHoraAtual());
		
		q.querySQL().executeUpdate();
	}

}
