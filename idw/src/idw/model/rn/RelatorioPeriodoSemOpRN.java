package idw.model.rn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwConsolsplog;
import idw.model.pojos.OmPt;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroRelatorioPeriodoSemOpDTO;
import idw.webservices.dto.RelatorioPeriodoSemOpDTO;
import idw.webservices.dto.TurnoAtualDTO;

public class RelatorioPeriodoSemOpRN extends AbstractRN<DAOGenerico>{

	public RelatorioPeriodoSemOpRN() {
		this(null);
	}
	
	public RelatorioPeriodoSemOpRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	public RelatorioPeriodoSemOpDTO getRelatorioPeriodoSemOp(FiltroRelatorioPeriodoSemOpDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioPeriodoSemOpRN.getRelatorioPeriodoSemOp");
		log.info( idLog , 0, "RelatorioPeriodoSemOpRN.getRelatorioPeriodoSemOp filtro usado:" + filtro.toString());
		
		RelatorioPeriodoSemOpDTO retorno = new RelatorioPeriodoSemOpDTO();
		List<RelatorioPeriodoSemOpDTO> listaRetorno = new ArrayList<>();
		List<DwConsolid> lista = consultaParadasFechadas(filtro);
				
		// Avaliacao das paradas fechadas
		for (DwConsolid id : lista) {
			for (DwConsol consol : id.getDwConsols()) {
				for (DwConsolpa pa : consol.getDwConsolpas()) {
					if (pa.getDwTParada().getIsSemOp() != null && pa.getDwTParada().getIsSemOp() == true) {
						for (DwConsolpaoco oco : pa.getDwConsolpaocos()) {
							RelatorioPeriodoSemOpDTO dto = new RelatorioPeriodoSemOpDTO();
							dto.setDtHrFim(oco.getDthrFparada());
							dto.setDtHrInicio(oco.getDthrIparada());
							dto.setDuracao(DataHoraRN.getQuantidadeMilisegundosNoPeriodo(oco.getDthrIparada(), oco.getDthrFparada()));
							dto.setMaquina(id.getOmPt().getCdPt());
							listaRetorno.add(dto);
						}
					}
				}
			}
		}
		// Avaliarcao das paradas abertas se for do tipo correto
		// Se o parametro de filtro pot GT estiver ativo, entao devemos avaliar para todos os pts do gt
		List<OmPt> listapts = null;
		if (filtro.getOmgt() != null && filtro.getOmgt().getIdGt() != null) {
			PTRN ptrn = new PTRN(getDao());
			listapts = ptrn.pesquisarPtByGt(filtro.getOmgt());
		}
		if (listapts == null) {
			listapts = new ArrayList<>();
			listapts.add(filtro.getOmpt());
		}
		
		// Marcos Sardinha: 2017-08-31 >> Defeito #4360  
		Map<String, Date> mapUltimaDtH = new HashMap<String, Date>();
		
		// Avaliar os periodos em aberto sem OP a partir dos eventos de entrada e saida de planejamento
		List<DwConsolsplog> listasplog = pesquisarSplog(filtro);
		TurnoRN turnoRN = new TurnoRN(getDao());
		
		for (DwConsolsplog splog : listasplog) {
			
			// obtem os calendarios semanais para o PT
			List<DwCalsem> dwCalsems;
			try {
				dwCalsems = turnoRN.getCalendarioSemanalComTurnosIndefinidosParaPt(splog.getOmPt(), splog.getDthrInicio());
			} catch (SemCalendarioException e) {
				continue;
			}
		
			// Encontrar os turnos dentro do periodo sem op
			Date dthrFim = splog.getDthrFim();
			if (dthrFim == null) {
				if (mapUltimaDtH.containsKey(splog.getOmPt().getCdPt()) == false) {
					dthrFim = DataHoraRN.getDataHoraAtual();
				} else {
					dthrFim = mapUltimaDtH.get(splog.getOmPt().getCdPt());
				}
			}				
			mapUltimaDtH.put(splog.getOmPt().getCdPt(), splog.getDthrInicio());				

			List<TurnoAtualDTO>  listaTurnoAtualDTO = turnoRN.getTurnoAtualDTOsPeriodo(dwCalsems, splog.getDthrInicio(), dthrFim);
			// Para cada turno abrir uma entrada no listaRetorno
			for(TurnoAtualDTO turnoAtual: listaTurnoAtualDTO){
				// Se nao houver intersecao entre o periodo sem op e o turno avaliado, entao passar pro poximo turno
				if (DataHoraRN.isIntersecao(turnoAtual.getDtHrITurno(), turnoAtual.getDtHrFTurno(), splog.getDthrInicio(), dthrFim) == false)
					continue;
				
				// Se houver um filtro por turno e nao for o turno analiado passar pro proximo
				if (filtro.getDwTurno() != null && filtro.getDwTurno().getCdTurno() != null && filtro.getDwTurno().getCdTurno().equals(turnoAtual.getCdTurno()) == false)
					continue;
				
				// Filtrar considerando as datas  do filtro
				if (DataHoraRN.isIntersecao(turnoAtual.getDtReferencia(), filtro.getPeriodoInicial(), filtro.getPeriodoFinal()) == false)
					continue;
				
				Date dthrIRef = (DataHoraRN.before(splog.getDthrInicio(), turnoAtual.getDtHrITurnoComTolerancia()) ? turnoAtual.getDtHrITurnoComTolerancia() : splog.getDthrInicio());
				Date dthrFRef = (DataHoraRN.before(dthrFim, turnoAtual.getDtHrFTurnoComTolerancia()) ? dthrFim : turnoAtual.getDtHrFTurnoComTolerancia());
				
				long duracao = DataHoraRN.getQuantidadeMilisegundosNoPeriodo(dthrIRef, dthrFRef);

				RelatorioPeriodoSemOpDTO dto = new RelatorioPeriodoSemOpDTO();
				dto.setDtHrFim(dthrFRef);
				dto.setDtHrInicio(dthrIRef);
				dto.setDuracao(duracao);
				dto.setMaquina(splog.getOmPt().getCdPt());
				// Se nao exsitir a ocorrencia entao incluir
				boolean isExiste = false;
				for (RelatorioPeriodoSemOpDTO dtoAux : listaRetorno) {
					if (dtoAux.getMaquina().equals(dto.getMaquina()) && DataHoraRN.equals(dtoAux.getDtHrInicio(), dto.getDtHrInicio()))
						isExiste = true;
				}
				if (isExiste == false)
					listaRetorno.add(dto);

			}
			
			
		}
		
		Comparator<RelatorioPeriodoSemOpDTO> comparator = new Comparator<RelatorioPeriodoSemOpDTO>() {
			@Override
			public int compare(RelatorioPeriodoSemOpDTO o1,
					RelatorioPeriodoSemOpDTO o2) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				String objeto1 = o1.getMaquina() + sdf.format(o1.getDtHrInicio());
				String objeto2 = o2.getMaquina() + sdf.format(o2.getDtHrInicio());
				return objeto1.compareTo(objeto2);
			}
		};
		Collections.sort(listaRetorno, comparator);
		
		retorno.setItens(listaRetorno);
		log.mostrarAvaliacaoCompleta();
		return retorno;
	}
	
	/*
	 * O metodo abaixo deve pesqusiar todos os periodos sem op englobados pelo filtro
	 */
	private List<DwConsolsplog> pesquisarSplog(FiltroRelatorioPeriodoSemOpDTO filtro) {
		List<DwConsolsplog> retorno;
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwConsolsplog a");
		q.append("join fetch a.omPt ompt");
		q.append("join fetch ompt.omObjs omobj");
		q.appendWhere(MapQuery._NULL, "a.omPt = :ompt", filtro.getOmpt() != null && filtro.getOmpt().getIdPt() != null);
		q.appendWhere(MapQuery._NULL, "omobj.omGtByIdGt = :omgt", filtro.getOmgt() != null && filtro.getOmgt().getIdGt() != null);
		q.append("order by a.idConsolsplog DESC");
		
		q.defineParametro("ompt", filtro.getOmpt());
		q.defineParametro("omgt", filtro.getOmgt());
		
		retorno = q.list();
		return retorno;
	}

	private List<DwConsolid> consultaParadasFechadas(FiltroRelatorioPeriodoSemOpDTO filtro) {		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwConsols consol");
		q.append("JOIN consolid.omPt pt");
		q.append("LEFT JOIN pt.omObjs obj");
		q.append("LEFT JOIN obj.omGtByIdGt gt");
		q.append("JOIN consol.dwConsolpas consolpa");
		q.append("JOIN consolpa.dwTParada parada");
		q.append("JOIN consolpa.dwConsolpaocos consoloco");
		q.append("WHERE consolid.tpId = :tpid");
		q.append("AND parada.isSemOp = :semOp");
		q.append("AND consolid.dtReferencia BETWEEN :dtInicio AND :dtFim");
		if(filtro.getDwTurno() != null) {
			q.append("AND consolid.dwTurno.idTurno = :idTurno");
			q.append("AND consoloco.dthrIparada >= consolid.dthrIturno AND consoloco.dthrFparada <= consolid.dthrFturno");
		}else{
			q.append("AND consolid.dwTurno.idTurno != 1");
		}
		if(filtro.getOmpt() != null) {
			q.append("AND pt.idPt = :idpt");
			q.defineParametro("idpt", filtro.getOmpt().getIdPt());
		} else {
			q.append("AND gt.idGt = :idgt");
			q.defineParametro("idgt", filtro.getOmgt().getIdGt());
		}
		if(filtro.getDwTurno() != null) {
			q.defineParametro("idTurno", filtro.getDwTurno().getIdTurno());
		}		
		q.defineParametro("tpid", (byte) 1);
		q.defineParametro("semOp", true);
		q.defineParametroData("dtInicio", DataHoraRN.getDataHora235959(filtro.getPeriodoInicial()));
		q.defineParametroData("dtFim", DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));
		return q.list();
	}
}
