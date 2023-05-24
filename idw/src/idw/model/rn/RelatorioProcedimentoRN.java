package idw.model.rn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwProrea;
import idw.model.pojos.DwProreaativ;
import idw.model.pojos.DwProreaativobs;
import idw.model.pojos.DwProreausr;
import idw.model.pojos.template.DwProreaTemplate;
import idw.model.pojos.template.DwProreaativTemplate;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroRelProcedimentoDTO;
import idw.webservices.dto.RelatorioProcedimentoDTO;

public class RelatorioProcedimentoRN extends AbstractRN<DAOGenerico> {

	public RelatorioProcedimentoRN() {
		this(null);
	}	

	public RelatorioProcedimentoRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public RelatorioProcedimentoDTO gerarRelatorioProcedimento(FiltroRelProcedimentoDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioProcedimentoRN.gerarRelatorioProcedimento");
		log.info( idLog , 0, "RelatorioProcedimentoRN.gerarRelatorioProcedimento filtro usado:" + filtro.toString());

		List<DwConsolid> listaConsolids = consulta(filtro);
		RelatorioProcedimentoDTO retorno = montarRelatorio(listaConsolids);
		log.mostrarAvaliacaoCompleta();
		return retorno;//montarRelatorio(listaConsolids);
	}
	
	private RelatorioProcedimentoDTO montarRelatorio(List<DwConsolid> listaConsolid) {
		
		RelatorioProcedimentoDTO retorno = new RelatorioProcedimentoDTO();
		retorno.setItens(new ArrayList<RelatorioProcedimentoDTO>());
		
		for(DwConsolid consolid : listaConsolid) {
			Date dthrIPlanejado = consolid.getPpCp().getDthrInicioreal();
			if (dthrIPlanejado == null) {
				dthrIPlanejado = consolid.getPpCp().getDthrInicio();
			} 
			if (dthrIPlanejado == null) {
				dthrIPlanejado = DataHoraRN.getDataHoraAtual();
			}
			
			
			for(DwProrea procedimentoRealizado : consolid.getDwProreas()) {
				if (procedimentoRealizado.getStProrea().equals(DwProreaTemplate.StProrea.STATUS_FECHADO.getValue()) == false){
					continue;
				}
				
				for(DwProreaativ atividadeRealizada : procedimentoRealizado.getDwProreaativs()) {
					if(atividadeRealizada.getStProreaativ().equals(DwProreaativTemplate.Type.EXECUTANDO.getId())) {
						continue;
					}
					
					Date dthrIReal = null;
					Date dthrFReal = null;
					
					if(atividadeRealizada.getDthrInicio() != null) {
						dthrIReal = atividadeRealizada.getDthrInicio();
					} else {
						dthrIReal = new Date();
					}
					if(atividadeRealizada.getDthrFim() != null) {
						dthrFReal = atividadeRealizada.getDthrFim();
					} else {
						// Alessandre: Em 24-06-15 quando nao houver uma data final assumir inicio para zerar a dura��o.
						dthrFReal = dthrIReal;
					}
					
					long duracaoReal = DataHoraRN.getQuantidadeSegundosNoPeriodo(dthrIReal, dthrFReal);
					
					RelatorioProcedimentoDTO item = new RelatorioProcedimentoDTO();
					item.setPt(consolid.getOmPt().getCdPt());
					if (consolid.getOmPt().getOmGt() != null)
						item.setGt(consolid.getOmPt().getOmGt().getCdGt());
					else
						item.setGt("");
					
					item.setOp(consolid.getPpCp().getNrop());
					item.setTurno(consolid.getDwTurno().getDsTurno());
					item.setProcedimento(procedimentoRealizado.getDwProcedimento().getCdProcedimento());
					item.setDtIReal(dthrIReal); 
					item.setDtFReal(dthrFReal); 
					item.setDuracaoReal(duracaoReal);
					item.setDuracaoPlan(atividadeRealizada.getDwProcativ().getSegTempopadrao().intValue());
					item.setStAtividade(getStAtividade(atividadeRealizada.getStProreaativ()));
					item.setGpAtividade(atividadeRealizada.getDwProcativ().getDwGrpativ().getCdGrpativ());
					item.setOrdemGpAtividade(atividadeRealizada.getDwProcativ().getOrdemGrupo());
					item.setAtividade(atividadeRealizada.getDwProcativ().getDsProcativ());				
					item.setOrdemAtividade(atividadeRealizada.getDwProcativ().getOrdemProcativ());
					item.setOperador(atividadeRealizada.getOmUsr().getDsNome());
					
					for(DwProreaativobs obs : atividadeRealizada.getDwProreaativobses()) {
						if(item.getObs() == null) {
							item.setObs(obs.getDsObs());
						} else {
							item.setObs(item.getObs() + " - " + obs.getDsObs());
						}						
					}
					
					for(DwConsol consol : consolid.getDwConsols()) {
						for(DwConsolpr consolpr : consol.getDwConsolprs()) {
							item.setProduto(consolpr.getOmProduto().getCdProduto());
						}
					}
					
					/**
					 * GEORGE: Campo de operadores participantes do Setup - DwProreaUsr
					 */
					List <DwProreausr> operadoresParticipantes = getOperadoresParticipantes(procedimentoRealizado.getIdProrea());
					
					if (operadoresParticipantes != null) {
						if (operadoresParticipantes.size() > 0) {
							for (DwProreausr operadorParticipante : operadoresParticipantes) {
								if (item.getOperadoresParticipantes() == null) {
									item.setOperadoresParticipantes(operadorParticipante.getOmUsr().getDsNome().toString());
								} else {
									item.setOperadoresParticipantes(item.getOperadoresParticipantes() + "; " + operadorParticipante.getOmUsr().getDsNome());
								}
							}
						} else {
							item.setOperadoresParticipantes("Apenas operador logado.");
						}
					} else {
						item.setOperadoresParticipantes("Apenas operador logado.");
					}
					
					// Antes de adicionar, verificar se ja nao existe, pois o APK esta salvando a mesma coisa varias vezes
					boolean isExiste = false;
					for (RelatorioProcedimentoDTO dto : retorno.getItens()) {
						if (dto.getOp().equals(item.getOp()) && DataHoraRN.equals(dto.getDtIReal(), item.getDtIReal()) ) {
							isExiste = true;
						}
					}
					if (isExiste == false)
						retorno.getItens().add(item);
				}				
			}			
		}
		
		Collections.sort(retorno.getItens(), new Comparator<RelatorioProcedimentoDTO>() {
			
			@Override
			public int compare(RelatorioProcedimentoDTO o1, RelatorioProcedimentoDTO o2) {
				int retorno;
				
				if(o1.getProcedimento().compareTo(o2.getProcedimento()) == 0) {
					if (o1.getOp().compareTo(o2.getOp()) == 0) {
						if (o1.getProduto().compareTo(o2.getProduto()) == 0) {
							if(o1.getOrdemGpAtividade().compareTo(o2.getOrdemGpAtividade()) == 0) {
								retorno = o1.getOrdemAtividade().compareTo(o2.getOrdemAtividade());
							} else {
								retorno = o1.getOrdemGpAtividade().compareTo(o2.getOrdemGpAtividade());
							}
						} else {
							retorno = o1.getProduto().compareTo(o2.getProduto());
						}						
					} else {
						retorno = o1.getOp().compareTo(o2.getOp());
					}
				} else {
					retorno = o1.getProcedimento().compareTo(o2.getProcedimento());
				}
				
				return retorno;
			}
		});
		
		return retorno;
	}

	private List<DwConsolid> consulta(FiltroRelProcedimentoDTO filtro) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT distinct consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwTurno turno");
		q.append("JOIN consolid.omPt pt");
		q.append("left JOIN pt.omGt gt");
		q.append("JOIN consolid.ppCp cp");
		q.append("JOIN consolid.dwProreas prorea");
		q.append("JOIN prorea.dwProcedimento procedimento");
		q.append("JOIN consolid.dwConsols consol");
		q.append("JOIN consol.dwConsolprs consolpr");
		q.append("JOIN consolpr.omProduto produto");
		q.append("WHERE consolid.dtReferencia BETWEEN :dtInicio AND :dtFim");
		q.append("AND (consolid.tpId = :tpId OR consolid.tpId IS NULL)");

		if(filtro.getDwTurno() != null){
			q.append("AND turno.idTurno = :idTurno");
		} /* Alessandre em 30-03-17 nao se deve descartar o smed do turno indefinido exe GE com integracao INJET else{
			q.append("AND consolid.dwTurno.idTurno != 1");
		}*/
		
		if(filtro.getOmPt() != null) {
			q.append("AND pt.idPt = :idPt");
		}
		if(filtro.getOmGt() != null) {
			q.append("AND gt.idGt = :idGt");
		}
		if(filtro.getOmProduto() != null) {
			q.append("AND produto.idProduto = :idProduto");
		}
		if(filtro.getPpCp() != null) {
			q.append("AND cp.idCp = :idCp");
		}
		
		q.defineParametro("tpId", (byte) 1);
		q.defineParametroData("dtInicio", filtro.getDataInicio());
		q.defineParametroData("dtFim", DataHoraRN.getDataHora235959(filtro.getDataFim()));
		
		if(filtro.getDwTurno() != null){
			q.defineParametro("idTurno", filtro.getDwTurno().getIdTurno());
		}
		
		if(filtro.getOmPt() != null) {
			q.defineParametro("idPt", filtro.getOmPt().getIdPt());
		}
		if(filtro.getOmGt() != null) {
			q.defineParametro("idGt", filtro.getOmGt().getIdGt());
		}
		if(filtro.getOmProduto() != null) {
			q.defineParametro("idProduto", filtro.getOmProduto().getIdProduto());
		}
		if(filtro.getPpCp() != null) {
			q.defineParametro("idCp", filtro.getPpCp().getIdCp());
		}
		return q.list();
		
	}
	
	private List<DwProreausr> getOperadoresParticipantes(Long idDwProrea) {
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT dwproreausr ");
		q.append("FROM DwProreausr dwproreausr ");
		q.append("JOIN FETCH dwproreausr.omUsr omusr ");
		q.append("WHERE dwproreausr.dwProrea.idProrea = :idDwProrea ");
		
		q.defineParametro("idDwProrea", idDwProrea);
	
		return q.list();
	}
	
	
	private String getStAtividade(Byte stAtividade) {
		String retorno = "";
		if(stAtividade == null) {
			return retorno;
		}
		if(stAtividade == (byte) 1) {
			retorno = "Executado com Sucesso";
		}
		if(stAtividade == (byte) 2) {
			retorno = "Executado com Resalva";	
		}
		if(stAtividade == (byte) 3) {
			retorno = "N�o Executado";
		}
		return retorno;
	}

}