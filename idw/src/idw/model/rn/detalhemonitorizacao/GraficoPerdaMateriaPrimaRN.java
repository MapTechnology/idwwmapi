package idw.model.rn.detalhemonitorizacao;

import java.awt.Color;
import java.awt.Paint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolperdamplog;
import idw.model.pojos.OmMapapa;
import idw.model.pojos.OmPt;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.geraplano.dtos.DatasDTO;
import idw.util.AritmeticaUtil;
import idw.util.Cor;
import idw.util.FormulasInjet;
import idw.util.GrafTendenciaUtils;
import idw.util.IdwLogger;
import idw.util.IntervaloGrafTendenciaRefugoParada;
import idw.webservices.dto.FiltroGraficoDetalhePtDTO;
import idw.webservices.dto.ListaPerdasmpDTO;
import idw.webservices.dto.OcorrenciasEvtDTO;
import idw.webservices.dto.PTsDTO;
import idw.webservices.dto.PerdasmpDTO;
import idw.webservices.dto.TurnoAtualDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoPerdasMpDTO;
import idw.webservices.rest.dto.monitorizacao.PerdasProdutoDTO;
import ms.util.ConversaoTipos;
import ms.util.UtilsThreads;

public class GraficoPerdaMateriaPrimaRN  extends AbstractRN<DAOGenerico>{
	
	private static final Integer PRECISAO_DECIMAIS_PERDA_MP = 4;
	
	private MapQuery queryQtTodasAlimentacoes;
	
	public GraficoPerdaMateriaPrimaRN() {
		super(new DAOGenerico());
	}
	
    public GraficoPerdaMateriaPrimaRN(DAOGenerico dao) {
		super(dao);
	}

	public ListaPerdasmpDTO getGraficoPerdasMateriaPrima(FiltroGraficoDetalhePtDTO filtro) {
		queryQtTodasAlimentacoes = new MapQuery(getDaoSession());
		
		queryQtTodasAlimentacoes.append("select sum(b.qtAlimentada)");
		queryQtTodasAlimentacoes.append("from OmAlimrea b");
		queryQtTodasAlimentacoes.append("where b.omMapapa.idMapapa = :ommapapa");
		
		
    	ListaPerdasmpDTO retorno;
    	StringBuilder nomeLog = new StringBuilder();
    	nomeLog.append("GraficoPerdaMateriaPrimaRN-gt-");
    	if (filtro.getOmGt() != null)
    		nomeLog.append(filtro.getOmGt().getCdGt());
    	nomeLog.append("-pt-");
    	if (filtro.getOmPt() != null)
    		nomeLog.append(filtro.getOmPt().getCdPt());
    	
    	IdwLogger log = new IdwLogger(nomeLog.toString());
    	int idLog = log.getIdAleatorio();
    	int identacao = 0;
    	
    	log.iniciaAvaliacao("getGraficoPerdasMateriaPrima");

    	retorno = inicializaListaPerdampDTO(filtro, log, idLog, identacao);
    	
//    	preencherCoresOcorrencia(DetalheMonitorizacaoPTInsertRN.ORDEM_PRODUTO, retorno.getPerdasmpDTOs(), retorno);
    	
    	log.mostrarAvaliacaoCompleta(idLog, identacao);
    	return retorno;
    }

	
	
	
	private ListaPerdasmpDTO inicializaListaPerdampDTO(FiltroGraficoDetalhePtDTO filtro, IdwLogger log, int idLog, int identacao) {
		ListaPerdasmpDTO retorno = new ListaPerdasmpDTO();
		retorno.setPerdasmpDTOs(new ArrayList<PerdasmpDTO>());
		retorno.setPerdasmpOPDTOs(new ArrayList<PerdasmpDTO>());
		retorno.setPerdasmpAlimDTOs(new ArrayList<PerdasmpDTO>());
		retorno.setPerdasmpRapDTOs(new ArrayList<PerdasmpDTO>());
		
		List<DwConsolperdamplog> lista = pesquisarPerda(filtro);
		
		// Inicializa retorno com as perdas encontradas
		log.info(idLog, identacao, "qtde de perdas " + lista.size());
		long parte1 = 0;
		long parte2 = 0;
		long parte3 = 0;
		long parte4 = 0;
//		int i = 0;
		boolean isInicializarAlimentacao = lista.size() < 20000; // Se tiver ate 20000 perda a alimentacao é inicializada. Se nao fica muito lento.
		for (DwConsolperdamplog mplog : lista) {
			if (mplog.getDwRap().getCdRap().contains("Z")) {
				log.iniciaAvaliacao("avaliParcial");
				PerdasmpDTO dto = inicializaPerdamp(mplog, isInicializarAlimentacao, log, idLog);
				adicionarNoRetornoAgrupandoPorProduto(retorno, dto);
				log.paraAvaliacao();
				parte1 += log.getSegundosTranscorridos();
			}
			log.iniciaAvaliacao("parte2");
			PerdasmpDTO dto = inicializaPerdamp(mplog, false, log, idLog);
			log.paraAvaliacao();
			parte2 += log.getSegundosTranscorridos();
				
			log.iniciaAvaliacao("parte3");
	        retorno.getPerdasmpOPDTOs().add(inicializaPerdamp(mplog, false, log, idLog));
	        retorno.getPerdasmpAlimDTOs().add(inicializaPerdamp(mplog, false, log, idLog));
	        log.paraAvaliacao();
	        parte3 += log.getSegundosTranscorridos();
	        
	        log.iniciaAvaliacao("parte4");
	        adicionarNoRetornoAgrupandoPorFerramenta(retorno, dto);
	        log.paraAvaliacao();
	        parte4 += log.getSegundosTranscorridos();
	        
	        // Limpar buffer do banco para diminuir consumo ou usar statless
	        
	        
	        // faz um delay pra nao consumir cpu
	        UtilsThreads.pausaNaThread(5);
		}
		
		log.info(idLog, identacao, "parte1 " + parte1 + " parte2=" + parte2 + " parte3=" + parte3 + " parte4=" + parte4);
		log.info(idLog, identacao, "saiu do for de dwconsolperdamplog");
		
		// Finaliza calculando os indices
		for (PerdasmpDTO dto : retorno.getPerdasmpDTOs()) {
			calculaIndices(dto);
		}
		for (PerdasmpDTO dto : retorno.getPerdasmpOPDTOs()) {
			calculaIndices(dto);
		}
		for (PerdasmpDTO dto : retorno.getPerdasmpAlimDTOs()) {
			calculaIndices(dto);
		}
		for (PerdasmpDTO dto : retorno.getPerdasmpRapDTOs()) {
			calculaIndices(dto);
		}
		
		// Ordernar descrente
		 // Comparator que ordena pela quantidade
        Comparator<PerdasmpDTO> comparator = new Comparator<PerdasmpDTO>() {
            @Override
            public int compare(PerdasmpDTO o1, PerdasmpDTO o2) {
                return o1.getIndiceDePerda().compareTo(o2.getIndiceDePerda());
            }
        };

        // Colocando lista em ordem decrescente de acordo com a quantidade
        Collections.sort(retorno.getPerdasmpDTOs(), Collections.reverseOrder(comparator));
        Collections.sort(retorno.getPerdasmpOPDTOs(), Collections.reverseOrder(comparator));
        Collections.sort(retorno.getPerdasmpAlimDTOs(), Collections.reverseOrder(comparator));
        Collections.sort(retorno.getPerdasmpRapDTOs(), Collections.reverseOrder(comparator));
		
		return retorno;
	}
	
	private void calculaIndices(PerdasmpDTO dto) {
		
		// Calculo dos indices
		dto.setIndiceDePerda(FormulasInjet.calcularIndice(new BigDecimal(dto.getQuantidade()), new BigDecimal(dto.getQuantidadeUtilizada()), PRECISAO_DECIMAIS_PERDA_MP).doubleValue());
		dto.setIndiceDePerdaAlimentacao(FormulasInjet.calcularIndice(new BigDecimal(dto.getQuantidade()), new BigDecimal(dto.getQuantidadeAlimentacao()), PRECISAO_DECIMAIS_PERDA_MP).doubleValue());
		dto.setIndiceDePerdaOP(FormulasInjet.calcularIndice(new BigDecimal(dto.getQuantidade()), new BigDecimal(dto.getQuantidadePrevistaOP()), PRECISAO_DECIMAIS_PERDA_MP).doubleValue());
		


	}
	
	/* Agrupo o dto por Produto
	 * 
	 */
	private void adicionarNoRetornoAgrupandoPorProduto(ListaPerdasmpDTO retorno, PerdasmpDTO dto) {
		// Verifica se ja existe registro da perda. Se sim, acumular, se nao incluir
		boolean isExiste = false;
		for (PerdasmpDTO perda : retorno.getPerdasmpDTOs()) {

			if (
					perda.getOmproduto().getCdProduto().equals(dto.getOmproduto().getCdProduto()) && 
					perda.getOmPt().getCdPt().equals(dto.getOmPt().getCdPt())) {
				isExiste = true;
				perda.setQuantidade(perda.getQuantidade() + dto.getQuantidade());
				perda.setQuantidadeUtilizada(perda.getQuantidadeUtilizada() + dto.getQuantidade());

				break;
			}
		}
		if (isExiste == false) {
			dto.setQuantidadeUtilizada(dto.getQuantidadeUtilizada() + dto.getQuantidade());
			retorno.getPerdasmpDTOs().add(dto);
		}
	}
	
	private List<DwConsolperdamplog> pesquisarPerda(FiltroGraficoDetalhePtDTO filtro) {
		/* Encontrar periodos a serem avaliados para obtencao das perdas de componenetes */
		Date dthrI = null;
		Date dthrF = null;

		OmPt omptReferenciaTurno = null;
		List<Object> listapt = new ArrayList<>();
		
		
		PTRN prn = new PTRN();
		prn.setDao(getDao());
		
		// Se o PT foi passado
		if (filtro.getOmPt() != null && filtro.getOmPt().getCdPt() != null && filtro.getOmPt().getCdPt().equals("") == false) {
			omptReferenciaTurno = filtro.getOmPt();
			listapt.add(filtro.getOmPt().getCdPt());
		} else if (filtro.getOmPt() != null && filtro.getOmPt().getIdPt() != null && filtro.getOmPt().getIdPt() > 0) {
			omptReferenciaTurno = prn.getOmPtById(filtro.getOmPt().getIdPt() );
			if (omptReferenciaTurno != null) {
				listapt.add(omptReferenciaTurno.getCdPt());
			}
		}
		
		// Se o GT foi passado
		if (filtro.getOmGt() != null && filtro.getOmGt().getCdGt() != null) {
			
			List<OmPt> pts = prn.pesquisarPtByGtComLayout(filtro.getOmGt());
			for (OmPt ompt : pts) {
				omptReferenciaTurno =  ompt;
				listapt.add(ompt.getCdPt());
			}
		}
		
		// Se nao existe um pt de referencia pegar o 1o ativo
		if (omptReferenciaTurno == null) {
			PTsDTO pts;
			try {
				pts = prn.getOmPtAtivos();
				if (pts.getPts().isEmpty() == false && pts.getPts().size() > 0)
					omptReferenciaTurno = pts.getPts().get(0).getPt();
			} catch (RegistroDesconhecidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		
		TurnoRN rn = new TurnoRN(getDao());
		
		// Avalia se o filtro do ano foi definido
		if (filtro.getAnoInicial() != null && filtro.getAnoInicial() > 0) {
			dthrI = DataHoraRN.getData(filtro.getAnoInicial(), filtro.getMesInicial(), 1);
			dthrF = DataHoraRN.getData(filtro.getAnoFinal(), filtro.getMesFinal(), 1);
			dthrF = DataHoraRN.getFimMes(dthrF);
			dthrF = DataHoraRN.getDataHora235959(dthrF);
		}

		// 1o caso: Considerando as perdas de determinado turno
		if (filtro.getDtReferencia() != null && filtro.getDwTurno() != null) {
			TurnoAtualDTO turnodto = null;
			try {
				System.out.println("1. pt " + omptReferenciaTurno.getCdPt() + " dtRef=" + filtro.getDtReferencia() + " idturno=" + filtro.getDwTurno().getIdTurno());
				turnodto = rn.getTurnoAtualDTOPassandoIdPtEDtTurnoEIdTurno(omptReferenciaTurno, filtro.getDtReferencia(), filtro.getDwTurno().getIdTurno());
			} catch (SemCalendarioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			dthrI = turnodto.getDtHrITurnoComTolerancia();
			dthrF = turnodto.getDtHrFTurnoComTolerancia();
		} else  if (filtro.getDtReferenciaInicial() != null && filtro.getDtReferenciaFinal() != null && filtro.getDwTurno() != null) {
			System.out.println("2. pt " + omptReferenciaTurno.getCdPt() + " dtRef=" + filtro.getDtReferenciaInicial() + " idturno=" + filtro.getDwTurno().getIdTurno());

			try {
				List<TurnoAtualDTO> turnos = rn.getTurnoAtualDTOsPeriodo(omptReferenciaTurno, filtro.getDtReferenciaInicial(), DataHoraRN.getDataHora235959(filtro.getDtReferenciaFinal()));
				for (TurnoAtualDTO dto : turnos) {
					if (dto.getCdTurno().equals(filtro.getDwTurno().getCdTurno()) && dto.getDtReferencia().equals(filtro.getDtReferenciaInicial()) || dto.getDtReferencia().equals(filtro.getDtReferenciaFinal())) {
						if (dthrI == null || dthrI.after(dto.getDtHrITurnoComTolerancia()))
							dthrI = dto.getDtHrITurnoComTolerancia();
						
						if (dthrF == null || dthrF.before(dto.getDtHrFTurnoComTolerancia()))
							dthrF = dto.getDtHrFTurnoComTolerancia();
					}
				}
				
			} catch (SemCalendarioException e) {
			}

		
		} else if (filtro.getDtReferenciaInicial() != null && filtro.getDtReferenciaFinal() != null && filtro.getDwTurno() == null) {
			
			System.out.println("3. pt " + omptReferenciaTurno.getCdPt() + " dtRef=" + filtro.getDtReferenciaInicial() + " idturno=" + filtro.getDwTurno().getIdTurno());

			// PEgar todos os turnos no periodo definido
			try {
				List<TurnoAtualDTO> turnos = rn.getTurnoAtualDTOsPeriodo(omptReferenciaTurno, filtro.getDtReferenciaInicial(), DataHoraRN.getDataHora235959(filtro.getDtReferenciaFinal()));
				for (TurnoAtualDTO dto : turnos) {
					if (dto.getDtReferencia().equals(filtro.getDtReferenciaInicial()) || dto.getDtReferencia().equals(filtro.getDtReferenciaFinal())) {
						if (dthrI == null || dthrI.after(dto.getDtHrITurnoComTolerancia()))
							dthrI = dto.getDtHrITurnoComTolerancia();
						
						if (dthrF == null || dthrF.before(dto.getDtHrFTurnoComTolerancia()))
							dthrF = dto.getDtHrFTurnoComTolerancia();
					}
				}
				
			} catch (SemCalendarioException e) {
			}
			
		}
		
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from DwConsolperdamplog a");
		q.append("join a.omPt b");
		q.append("join fetch a.dwRap c");
		q.append("join fetch a.dwConsolpempocos d");
		q.append("join fetch d.dwConsolpemp e");
		q.append("join fetch e.dwConsol f");
		q.append("left join fetch a.omMapapa g");
		q.append("join fetch a.omProduto h");
		q.append("where a.dthrPerdamp between :dthri and :dthrf");
		q.append("and b.cdPt in (:listapt)");
		
		q.defineParametro("dthri", dthrI);
		q.defineParametro("dthrf", dthrF);
		
		q.defineListaParametro("listapt", listapt);
		
		if (listapt.size() == 0)
			System.out.println("lista de pts vazio");
		
		return q.list();
		
	}	
	
	/* Inicializa a perda de materia prima idenpendentemente do agrupamento se eh poir produto, ferramenta, etc
	 * 
	 */
	private PerdasmpDTO inicializaPerdamp(DwConsolperdamplog mplog, boolean isInicializaQtAlimentada, IdwLogger log, int idLog) {
		PerdasmpDTO dto = new PerdasmpDTO();
		
		dto.setCdUP(mplog.getOmPt().getCdPt());
		dto.setOmPt(mplog.getOmPt().clone(false));
		dto.setDwRap(mplog.getDwRap().clone(false));
		dto.setOmproduto(mplog.getOmProduto().clone(false));
		dto.setDwTPerdamp(mplog.getDwTPerdamp().clone(false));
		dto.setPreco(mplog.getOmProduto().getVlCustounit());
		if (mplog.getOmMapapa() != null) {
			
			// Clona ommapapa
			OmMapapa ommapapa = new OmMapapa();
			ommapapa.setIdMapapa(mplog.getOmMapapa().getIdMapapa());
			dto.setOmmapapa(ommapapa);
			dto.getOmmapapa().setOmMapa(mplog.getOmMapapa().getOmMapa().clone(false));
			dto.getOmmapapa().setOmPa(mplog.getOmMapapa().getOmPa().clone(false));
			dto.setConsumoPorCiclo(mplog.getOmMapapa().getQtUsada().doubleValue());
		}else {
			log.info(idLog, 0, "mplog id=" + mplog.getIdConsolpemplog() + " comommapapa null");
			dto.setConsumoPorCiclo(1d);
		}
		dto.setQuantidade(mplog.getQtAutoPerdamp().doubleValue());

		
		// Setei como amarelo mas o correto é setar conforme a tendencia de crescimento. Mas como o algoritmo anterior nao eestava implementado e nao existe uma legenda na GUI e
		// sempre aparecer AMARELO na gui, setei uma cor constante
		dto.setCorBarra(String.valueOf(Color.YELLOW));

		// Encontra a quantidade prevista da OP
		if (mplog.getPpCp() != null)
			dto.setQuantidadePrevistaOP(mplog.getPpCp().getQtPecasProduzir());

		
		
		
		
		// Calcula quantidade de componentes utilizados com a formula Qtde Ciclos executados * qt Compponentes consumidos por ciclo + Quantidade perdida
		DwConsol dwconsol = mplog.getDwConsolpempocos().iterator().next().getDwConsolpemp().getDwConsol();
		BigDecimal qtdCiclosExecCP =  AritmeticaUtil.somar(dwconsol.getQtAutoCicloprodutivo(), dwconsol.getQtManuCicloprodutivo());
		dto.setQuantidadeUtilizada(AritmeticaUtil.multiplicar(qtdCiclosExecCP, dto.getConsumoPorCiclo()).doubleValue());


		List<String> raps = new ArrayList<>();
		raps.add(mplog.getDwRap().getCdRap());
		dto.setCdsRaps(raps);

		
		/* Encontrar a quantidade alimentada com base na data e hora da perda e no idmapapa */
		if (isInicializaQtAlimentada)
			dto.setQuantidadeAlimentacao(getQuantidadeAlimentacao(dwconsol, mplog.getOmMapapa(), log, idLog) );
		else
			dto.setQuantidadeAlimentacao(0d);

		return dto;
		
	}
	
	private Double getQuantidadeAlimentacao(DwConsol dwconsol, OmMapapa ommapapa, IdwLogger log, int idLog) {
		Double retorno = 0d;
		
		if (ommapapa != null && ommapapa.getIdMapapa() > 0) {
			queryQtTodasAlimentacoes.defineParametro("ommapapa", ommapapa.getIdMapapa());
			
			List<Object> lista = queryQtTodasAlimentacoes.list();
			
			if (lista.isEmpty() == false)  {
				if (lista.get(0) != null) {
					retorno = ((Long) lista.get(0)).doubleValue();
					log.info(idLog, 0, "Qtde alimentada na OP "+ retorno + " para idMapapa=" + ommapapa.getIdMapapa());
				}
			}
		}
		return retorno;
	}


	// Originalmente esse metodo esta em DetalheMonitorizacaoPTInsertRN. Veio para ca pois o grafico de materia prima foi reescrito
    private void preencherCoresOcorrencia(int ordem, Collection<PerdasmpDTO> perdas, ListaPerdasmpDTO retorno) {
    	HashMap<String, List<OcorrenciasEvtDTO>> mapOcorrencias = new HashMap<String, List<OcorrenciasEvtDTO>>();
    	
    	if(perdas == null) {
    		return;
    	}
    	
    	Date ocorrenciaInicial = null;
    	Date ocorrenciaFinal = null;

    	for(PerdasmpDTO perda : perdas) {
    		
    		if(perda.getLogs() == null) {
    			continue;
    		}

    		for(DwConsolperdamplog log : perda.getLogs()) {
    			String chave = ordem == DetalheMonitorizacaoPTInsertRN.ORDEM_PRODUTO ? log.getOmProduto().getCdProduto() : log.getDwRap().getCdRap();
    			
    			List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrencias.get(chave);
    			OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
    			ocoDTO.setIdEvt(ordem == DetalheMonitorizacaoPTInsertRN.ORDEM_PRODUTO ? log.getOmProduto().getIdProduto() : log.getDwRap().getIdRap());
    			ocoDTO.setDthrIni(log.getDthrPerdamp()); 
    			ocoDTO.setDthrFim(log.getDthrPerdamp());
    			ocoDTO.setDuracaoEvt(BigDecimal.ZERO);
    			ocoDTO.setMsDtHrIni(new BigDecimal(log.getMsDthrperdamp()));
    			ocoDTO.setMsDtHrFim(new BigDecimal(log.getMsDthrperdamp()));
    			
    			if(listaOcoDTO == null) {
    				listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
    				listaOcoDTO.add(ocoDTO);
    				mapOcorrencias.put(chave, listaOcoDTO);
    			} else {
    				listaOcoDTO.add(ocoDTO);
    			}
    			
    			ocorrenciaInicial = DataHoraRN.getMenorData(ocorrenciaInicial, log.getDthrPerdamp());
    			ocorrenciaFinal = DataHoraRN.getMaiorData(ocorrenciaFinal, log.getDthrPerdamp());
    		}
    		
    	}
    	
    	GrafTendenciaUtils algoritmoGraf = null;
		
		if(ocorrenciaInicial != null && ocorrenciaFinal != null){
			algoritmoGraf = new GrafTendenciaUtils(ocorrenciaInicial, ocorrenciaFinal);
		}
		
		if(algoritmoGraf != null && algoritmoGraf.getIntervaloGrafTend() != null && algoritmoGraf.getIntervaloGrafTend().isEmpty() == false){
			for(IntervaloGrafTendenciaRefugoParada intervalo : algoritmoGraf.getIntervaloGrafTend()){
				if(intervalo.getCorIntervalo().equals(Color.YELLOW)){
					DatasDTO datasAmarelo = new DatasDTO();
					datasAmarelo.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
					datasAmarelo.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
					if(ordem == DetalheMonitorizacaoPTInsertRN.ORDEM_PRODUTO) {
						retorno.setCorAmarela(datasAmarelo);
					} else {
						retorno.setCorAmarelaRap(datasAmarelo);
					}
				}
				if(intervalo.getCorIntervalo().equals(Color.ORANGE)){
					DatasDTO datasLaranja = new DatasDTO();
					datasLaranja.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
					datasLaranja.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
					if(ordem == DetalheMonitorizacaoPTInsertRN.ORDEM_PRODUTO) {
						retorno.setCorLaranja(datasLaranja);
					} else {
						retorno.setCorLaranjaRap(datasLaranja);
					}
				}
				if(intervalo.getCorIntervalo().equals(Color.GREEN)){
					DatasDTO datasVerde = new DatasDTO();
					datasVerde.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
					datasVerde.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
					if(ordem == DetalheMonitorizacaoPTInsertRN.ORDEM_PRODUTO) {
						retorno.setCorVerde(datasVerde);
					} else {
						retorno.setCorVerdeRap(datasVerde);
					}
				}
				if(intervalo.getCorIntervalo().equals(Color.RED)){
					DatasDTO datasVermelho = new DatasDTO();
					datasVermelho.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
					datasVermelho.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
					if(ordem == DetalheMonitorizacaoPTInsertRN.ORDEM_PRODUTO) {
						retorno.setCorVermelho(datasVermelho);
					} else {
						retorno.setCorVermelhoRap(datasVermelho);
					}
				}
			}
		}
		
		HashMap<String, Paint> mapCores = new HashMap<String, Paint>();
		Set<String> chaves = mapOcorrencias.keySet();
		for(String chave : chaves) {
			List<OcorrenciasEvtDTO> listaOco = mapOcorrencias.get(chave);
			if(listaOco != null) {
				Paint paint = algoritmoGraf.corBarraTendencia(listaOco.get(0).getIdEvt(), listaOco);
				mapCores.put(chave, paint);
			}
		}
		
		for(PerdasmpDTO perda : perdas) {
			String chave = ordem == DetalheMonitorizacaoPTInsertRN.ORDEM_PRODUTO ? perda.getOmproduto().getCdProduto() : perda.getDwRap().getCdRap();
			Paint paint = mapCores.get(chave);
			if(paint != null) {
				Color cor = (Color) paint;
				perda.setCorBarra(String.valueOf(cor.getRGB()));
			}
		}

    }

    
    
	/* Agrupo o dto por Ferramenta
	 * 
	 */
	private void adicionarNoRetornoAgrupandoPorFerramenta(ListaPerdasmpDTO retorno, PerdasmpDTO dto) {
		// Verifica se ja existe registro da perda. Se sim, acumular, se nao incluir
		boolean isExiste = false;
		for (PerdasmpDTO perda : retorno.getPerdasmpRapDTOs()) {

			if (
					// perda.getOmproduto().getCdProduto().equals(dto.getOmproduto().getCdProduto()) && acredito nao ser necessario considerar o produto aqui
					perda.getDwRap().getCdRap().contentEquals(dto.getDwRap().getCdRap()) &&
					perda.getOmPt().getCdPt().equals(dto.getOmPt().getCdPt())) {
				isExiste = true;
				perda.setQuantidade(perda.getQuantidade() + dto.getQuantidade());
				perda.setQuantidadeUtilizada(perda.getQuantidadeUtilizada() + dto.getQuantidade());

				break;
			}
		}
		if (isExiste == false) {
			dto.setQuantidadeUtilizada(dto.getQuantidadeUtilizada() + dto.getQuantidade());
			retorno.getPerdasmpRapDTOs().add(dto);
		}
	}
	
	private List<PerdasProdutoDTO> getPerdasMateriaPrimaWM(List<PerdasmpDTO> listaPerdasDTO) {
		List<PerdasProdutoDTO> perdasMateriaPrima = new ArrayList<>();

		for (PerdasmpDTO perda : listaPerdasDTO) {
			PerdasProdutoDTO perdaProduto = new PerdasProdutoDTO();

			perdaProduto.setIdProduto(perda.getOmproduto().getIdProduto());
			perdaProduto.setCdProduto(perda.getOmproduto().getCdProduto());

			//perdaProduto.setQuantidadeUtilizada(ConversaoTipos.converteParaString(perda.getQuantidadeUtilizada(), 1, true));
			perdaProduto.setQuantidadePerdida(ConversaoTipos.converteParaString(perda.getQuantidade(), 1, true));
			perdaProduto.setPorcentagemPerda(ConversaoTipos.converteParaString(perda.getIndiceDePerda(), 4, true));

			//perdaProduto.setQuantidadeAlimentada(ConversaoTipos.converteParaString(perda.getQuantidadeAlimentacao(), 1, true));
			//perdaProduto.setPorcentagemPerdaAlimentacao(ConversaoTipos.converteParaString(perda.getIndiceDePerdaAlimentacao(), 4, true));

			//perdaProduto.setQuantidadePrevistaOP(ConversaoTipos.converteParaString(perda.getQuantidadePrevistaOP(), 1, true));
			//perdaProduto.setPorcentagemPerdaOP(ConversaoTipos.converteParaString(perda.getIndiceDePerdaOP(), 4, true));

			try {
				perdaProduto.setCorOcorrencia(Cor.transformarColorParaCodigoHexadecimal(perda.getCorBarra()));
			} catch (NumberFormatException e) {
				System.out.println("deb " + perda.getCorBarra());
			}

			perdasMateriaPrima.add(perdaProduto);
		}
		return perdasMateriaPrima;
	}
	
	
	public GraficoPerdasMpDTO getPerdasMateriaPrima(List<Object> listaIdsCns)  {
		ListaPerdasmpDTO dto = new ListaPerdasmpDTO();
		dto = getGraficoPerdasMateriaPrima(listaIdsCns);

		if (dto.getPerdasmpDTOs() == null) {
			dto.setPerdasmpDTOs(new ArrayList<PerdasmpDTO>());
		}

		if (dto.getPerdasmpRapDTOs() == null) {
			dto.setPerdasmpRapDTOs(new ArrayList<PerdasmpDTO>());
		}

		GraficoPerdasMpDTO retorno = new GraficoPerdasMpDTO();
		retorno.setPerdasMateriaPrima(getPerdasMateriaPrimaWM(dto.getPerdasmpDTOs()));

		/*
		 * retorno.setPerdasFerramenta(getPerdasFerramenta(dto)); retorno.setLegendasMateriaPrima(getLegendasMateriaPrima(dto));
		 * retorno.setLegendasFerramenta(getLegendasFerramenta(dto)); retorno.setGraficoDropRate(getGraficoDropRate(dto,
		 * filtro.getListaMpBruta())); retorno.setGraficoCustoPorPerda(getGraficoCustoPorPerdas(dto));
		 */

		return retorno;
	}

	
	public ListaPerdasmpDTO getGraficoPerdasMateriaPrima(List<Object> listaIdsCns) {
		BigDecimal totalPerdas = BigDecimal.ZERO;

		ListaPerdasmpDTO retorno = new ListaPerdasmpDTO();
		retorno.setPerdasmpDTOs(new ArrayList<PerdasmpDTO>());

		List<DwConsolperdamplog> listaPerdas = this.getOcorrenciasPerdaMPWM(listaIdsCns);
		Map<String, PerdasmpDTO> mapPerdasMP = new HashMap<String, PerdasmpDTO>();

		// Avalia as perdas de componente
		long segGetComponentesUsadosMapa = 0l;
		long segGetComponentesUsadosMapa2 = 0l;

		for (DwConsolperdamplog logPerda : listaPerdas) {

			boolean isIncrementaQtPerdaMpPorProduto = true;

			PerdasmpDTO perdasmpDTO = null;
			perdasmpDTO = mapPerdasMP.get("*" + logPerda.getOmProduto().getCdProduto());

			if (perdasmpDTO == null) {
				perdasmpDTO = new PerdasmpDTO();
				perdasmpDTO.setCdsRaps(new ArrayList<String>());
				perdasmpDTO.setLogs(new ArrayList<DwConsolperdamplog>());
				perdasmpDTO.setDwRap(logPerda.getDwRap().clone(false));
				perdasmpDTO.setDwTPerdamp(logPerda.getDwTPerdamp().clone(false));
				perdasmpDTO.setOmproduto(logPerda.getOmProduto().clone(false));
				perdasmpDTO.setQuantidade(new Double(0));
				perdasmpDTO.setPreco(logPerda.getOmProduto().getVlCustounit());

			}

			/*
			 * Alessandre em 13-04-20. como existem lancamentos repetidos de perda de componente é necessario descartar os eventos com mesma
			 * data e hora e feeder encontrei uma ocorrencia em que a data eh igual mas a qtde é diferente. Nesse caso ficar com a qtde
			 * maior posso ordenar antes de interagir, ou guardo a qtde e comparo. Alterei o PerdasMpDTO para recalcular a diferenca
			 */
			if (perdasmpDTO.incluirDthr(logPerda.getDthrPerdamp(), logPerda.getOmProduto().getCdProduto(),
					logPerda.getQtAutoPerdamp().intValue())) {
				isIncrementaQtPerdaMpPorProduto = true; // Acrescentado devido ao comentario acima
			} else {
				isIncrementaQtPerdaMpPorProduto = false;
			}

			// Acumula apenas se quantidade ainda nÃ£o foi processada
			if (isIncrementaQtPerdaMpPorProduto) {
				totalPerdas = AritmeticaUtil.somar(totalPerdas, logPerda.getQtAutoPerdamp());

				perdasmpDTO.setQuantidade(perdasmpDTO.getQuantidade() + logPerda.getQtAutoPerdamp().doubleValue());
				perdasmpDTO.setIndiceDePerda(0d);
				perdasmpDTO.getLogs().add(logPerda.clone(true));

			}

		}

		// Calcula o indice de perda
		for (PerdasmpDTO dto : mapPerdasMP.values()) {
			Double ipd = FormulasInjet.calcularIndicePerda(new BigDecimal(dto.getQuantidade()), totalPerdas).doubleValue();
			ipd = ConversaoTipos.converteParaDouble(ipd, 4);
			dto.setIndiceDePerda(ipd);
		}

		retorno.getPerdasmpDTOs().addAll(mapPerdasMP.values());

		// Comparator que ordena pelo indice de perda
		Comparator<PerdasmpDTO> comparator = new Comparator<PerdasmpDTO>() {
			@Override
			public int compare(PerdasmpDTO o1, PerdasmpDTO o2) {
				// return o1.getQuantidade().compareTo(o2.getQuantidade());
				return o1.getIndiceDePerda().compareTo(o2.getIndiceDePerda());
			}

		};

		// Colocando lista em ordem decrescente de acordo com a quantidade
		Collections.sort(retorno.getPerdasmpDTOs(), Collections.reverseOrder(comparator));
		//Collections.sort(retorno.getPerdasmpRapDTOs(), Collections.reverseOrder(comparator));

		return retorno;
	}


	private List<DwConsolperdamplog> getOcorrenciasPerdaMPWM(List<Object> listaIdsCns) {

		MapQuery query = new MapQuery(getDao().getSession());
		query.append("SELECT DISTINCT polog");
		query.append(" FROM DwConsolperdamplog polog");
		query.append(" JOIN FETCH polog.dwRap rap ");
		query.append(" JOIN FETCH polog.omProduto pro ");
		query.append(" JOIN polog.dwConsolpempocos oco ");
		query.append(" JOIN oco.dwConsolpemp pmp ");
		query.append(" JOIN pmp.dwConsol cns ");
		query.append(" JOIN cns.dwConsolid cid ");
		query.append("WHERE cid.idConsolid IN (:listaIds)");

		query.defineListaParametro("listaIds", listaIdsCns);

		List<DwConsolperdamplog> listaretorno = query.list();

		return listaretorno;

	}
	

}
