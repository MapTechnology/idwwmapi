package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.SemPacoteOuFatorException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.rn.detalhemonitorizacao.IndicadoresDoDetalheRN;
import idw.util.FormulasInjet;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.AcompanhamentoProducaoDTO;
import idw.webservices.dto.DetalheMonitorizacaoPTInjetDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.FiltroRelatorioAnaliseEficienciaDTO;
import idw.webservices.dto.FiltroRelatorioParadasAbertasDTO;
import idw.webservices.dto.ListaAcompanhamentoProducaoDTO;
import idw.webservices.dto.ListaRelatorioParadasAbertasDTO;
import idw.webservices.dto.RelatorioParadasAbertasDTO;
import ms.util.ConversaoTipos;

public class RelAcompanhamentoProducaoRN extends AbstractRN<DAOGenerico> {

	public RelAcompanhamentoProducaoRN() {
		this(null);
	}

	public RelAcompanhamentoProducaoRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	/*
	 * Metodo principal para montagem do relatorio
	 */
	
	
	public ListaAcompanhamentoProducaoDTO getAcompanhamentoProducao(
			FiltroRelatorioAnaliseEficienciaDTO filtro) {
		IdwLogger log = new IdwLogger("RelAcompanhamentoProducao");
		
		
		class TotaisMetaHora {
			double metaUB = 0d;
			double metaKg = 0d;
			double metaTon = 0d;
		}
		
		// Obtem paradas em aberto conforme o filtro passado
		List<RelatorioParadasAbertasDTO> listaParadasEmAberto = new ArrayList<>();
		RelatorioParadasAbertasRN rnPA = new RelatorioParadasAbertasRN(getDao());
		FiltroRelatorioParadasAbertasDTO filtroParada = new FiltroRelatorioParadasAbertasDTO();
		filtroParada.setOmgt(filtro.getOmgt());
		filtroParada.setOmpt(filtro.getOmpt());
		filtroParada.setArea(null);
		filtroParada.setCdop(null);
		ListaRelatorioParadasAbertasDTO listaRelatorioParadasAbertas = rnPA .getConsolpaLogDTO(filtroParada);
		if (listaRelatorioParadasAbertas.getAbertasDTOs() != null) {
			listaParadasEmAberto.addAll(listaRelatorioParadasAbertas.getAbertasDTOs());
		}

		ListaAcompanhamentoProducaoDTO retorno = new ListaAcompanhamentoProducaoDTO();
		List<AcompanhamentoProducaoDTO> listaRetornoTotalMaq = new ArrayList<>();
		List<AcompanhamentoProducaoDTO> listaRetorno = new ArrayList<>();
		List<DwConsolid> listaconsolids = consultaRelatorioAcompProducao(filtro, (byte) 0);
		
		
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		

		
		//Necessario ter a projecao por maquina (soma de todas as metas horarias de uma maquina)
		Map <String, SortedMap<Date, List<DwConsolid>>> mapMaquinas =  new HashMap<String, SortedMap<Date, List<DwConsolid>>>();
		for (DwConsolid id : listaconsolids) {
			SortedMap<Date, List<DwConsolid>> mapDatas = new TreeMap<Date, List<DwConsolid>>();
			List<DwConsolid> listaIds = new ArrayList<DwConsolid>();
			
			if (mapMaquinas.containsKey(id.getOmPt().getCdPt()) == false) {
				listaIds = new ArrayList<DwConsolid>();
				listaIds.add(id);
				mapDatas.put(id.getDthrIhora(), listaIds);
				
			} else {
				mapDatas = mapMaquinas.get(id.getOmPt().getCdPt());
				if (mapDatas.containsKey(id.getDthrIhora()) == false) {
					listaIds = new ArrayList<DwConsolid>();
					listaIds.add(id);

				} else {
					listaIds = new ArrayList<DwConsolid>();
					listaIds = mapDatas.get(id.getDthrIhora());
					listaIds.add(id);					
				}
				
				mapDatas.put(id.getDthrIhora(), listaIds);
				
			}
			mapMaquinas.put(id.getOmPt().getCd(), mapDatas);				
		}
		
		
		
		FolhaRN folhaRN = new FolhaRN(getDao());
		
		// Necessario ter a projecao final de dada maquina
		Map <String, Double> mapMaquinasTotal =  new HashMap<String, Double>();

		// Necessario total por maquina (quantidade previstas - metas)
		Map <String, TotaisMetaHora> mapMaquinasResumo =  new HashMap<String, TotaisMetaHora>();
		
		// Necessario pra guardar media das metas
		Map <String, Map<Date, TotaisMetaHora>> mapMetasMaqHora =  new HashMap<String, Map<Date, TotaisMetaHora>>();
		
		Set<String> keysMaquinas = mapMaquinas.keySet();		
		for (String maq : keysMaquinas) {
			Double projecaoFimPeriodoMaq = 0d;
			Double projecaoFimPeriodoMaqKg = 0d;
			Double projecaoFimPeriodoMaqTon = 0d;
						
			Map<Date, List<DwConsolid>> mapDatas = new HashMap<Date, List<DwConsolid>>();
			
			mapDatas = mapMaquinas.get(maq);
			
			Set<Date> keysDtHrI = mapDatas.keySet();
			for (Date dthr : keysDtHrI) {
				// ordernar pra garantir saldos corretos 
				Comparator<DwConsolid> comparator = new Comparator<DwConsolid>() {
					@Override
					public int compare(DwConsolid o1, DwConsolid o2) {
						Long str1 = o1.getIdConsolid();
						Long str2 = o2.getIdConsolid();
						return str1.compareTo(str2);
					}
				};
				
				Collections.sort(mapDatas.get(dthr), comparator);
			}
			
						
			
			
			keysDtHrI = mapDatas.keySet();
			
			Map<Date, TotaisMetaHora> mapMetasHora = new HashMap<Date, TotaisMetaHora>();
			for (Date dthrI : keysDtHrI) {
				DetalheMonitorizacaoPTInjetDTO detalhes = new DetalheMonitorizacaoPTInjetDTO();
				AcompanhamentoProducaoDTO dto = new AcompanhamentoProducaoDTO();
				FiltroDetalhePTInjetDTO filtroInd = new FiltroDetalhePTInjetDTO();
				
				String intervalo = DataHoraRN.dateToStringDDMMYYYYHHMMSS(mapDatas.get(dthrI).get(0).getDthrIhora())
						 + " - " + DataHoraRN.dateToStringDDMMYYYYHHMMSS(mapDatas.get(dthrI).get(0).getDthrFhora());

				//String intervalo = DataHoraRN.dateToStringYYYYMMDDHHMMSS(mapDatas.get(dthrI).get(0).getDthrIhora())
				//		 + " - " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(mapDatas.get(dthrI).get(0).getDthrFhora());

				
				dto.setIntervalo(intervalo);
				dto.setMaquina(mapDatas.get(dthrI).get(0).getOmPt().getCdPt());
				dto.setUnidMedida(null); // nao eh usado pra nada
				dto.setListaCompletaParadas(null); // acho q nao serve pra nada
				listaRetornoTotalMaq.add(dto);

				List<DwConsolid> idAux = new ArrayList<>();
				idAux.addAll(mapDatas.get(dthrI)); 
				
				detalhes = new DetalheMonitorizacaoPTInjetDTO();
				filtroInd = new FiltroDetalhePTInjetDTO();
				filtroInd.setOmPt(mapDatas.get(dthrI).get(0).getOmPt());
				filtroInd.setOmGt(mapDatas.get(dthrI).get(0).getOmGt());

				IndicadoresDoDetalheRN rn = new IndicadoresDoDetalheRN(getDao(),
						log, omcfg, idAux, false, // isRecuperarListaProdutos,
						false, // isRecuperarListaOperadores,
						false, // isRecuperarListaAlertas,
						false, // isRecuperarListaPerdas,
						false, // isRecuperarListaResumoDatas,
						false, // isRecuperarListaResumoTurnos,
						detalhes, filtroInd);

				rn.setResumoIndicadores();
				rn.setIndicadoresAdicionais();

				TotaisMetaHora totalHora = new TotaisMetaHora();				
				for(DwConsolid id : mapDatas.get(dthrI)) {
					// O dto abaixo deve ser criado para cada linha do relatorio
					BigDecimal fatorContagem = BigDecimal.ONE;
					try {
						fatorContagem = folhaRN.getFatorContagemFromDwFolha(id.getDwFolha(), id.getOmPt());
					} catch (SemPacoteOuFatorException e) {

					}
					Double metaHora = FormulasInjet.calcularProducaoPrevista(new BigDecimal(3600), 
																			 id.getDwConsol().getSegAutoCiclopadrao(), 
																			 id.getDwConsol().getQtAutoCavativas(), 
																			 fatorContagem, id.getOmPt().getIndOee()).doubleValue();

					
					Long pesoBruto = 0l;
					for (DwConsolpr dwconsolpr : id.getDwConsol().getDwConsolprs()) {
						OmProduto omproduto = getDao().findById(OmProduto.class, dwconsolpr.getOmProduto().getIdProduto(), false);
						if (omproduto != null && omproduto.getGPesoBruto() != null)
							pesoBruto += omproduto.getGPesoBruto().longValue();
					}
					
					Double metaHoraKg = (metaHora *  pesoBruto) /1000;
					Double metaHoraTon = (metaHora *  pesoBruto) /1000000;

					
					//meta maquina/hora
					if (mapMetasHora.containsKey(dthrI)) {
						totalHora = new TotaisMetaHora();
						totalHora = mapMetasHora.get(dthrI);
					}
					
					totalHora.metaUB += metaHora;
					totalHora.metaKg += metaHoraKg;
					totalHora.metaTon += metaHoraTon;						
					
					mapMetasHora.put(dthrI, totalHora);
				}
				
				//meta maquina-hora
				int qtdIds = mapDatas.get(dthrI).size();
				mapMetasHora.get(dthrI).metaUB = mapMetasHora.get(dthrI).metaUB / qtdIds;
				mapMetasHora.get(dthrI).metaKg = mapMetasHora.get(dthrI).metaKg / qtdIds;
				mapMetasHora.get(dthrI).metaTon = mapMetasHora.get(dthrI).metaTon / qtdIds;
			
				//meta maquina
				projecaoFimPeriodoMaq += mapMetasHora.get(dthrI).metaUB;
				projecaoFimPeriodoMaqKg += mapMetasHora.get(dthrI).metaKg;
				projecaoFimPeriodoMaqTon += mapMetasHora.get(dthrI).metaTon; 
				
			}


			mapMetasMaqHora.put(maq, mapMetasHora);
			
			TotaisMetaHora metas = new TotaisMetaHora();
			metas.metaUB = projecaoFimPeriodoMaq;
			metas.metaKg = projecaoFimPeriodoMaqKg;
			metas.metaTon = projecaoFimPeriodoMaqTon;
			
			mapMaquinasResumo.put(maq, metas);
			
		}
		
		
		
		//indicadores e totais do intervalo
		keysMaquinas = mapMaquinas.keySet();		
		for (String maq : keysMaquinas) {
			Double projecaoFimPeriodoMaq = mapMaquinasResumo.get(maq).metaUB;
			Double projecaoFimPeriodoMaqKg = mapMaquinasResumo.get(maq).metaKg;
			Double projecaoFimPeriodoMaqTon = mapMaquinasResumo.get(maq).metaTon;
			
						
			Map<Date, List<DwConsolid>> mapDatas = new HashMap<Date, List<DwConsolid>>();
			mapDatas = mapMaquinas.get(maq);
			
			Set<Date> keysDtHrI = mapDatas.keySet();	
			
			Map<Date, TotaisMetaHora> mapMetasHora = mapMetasMaqHora.get(maq);  
			
			boolean isExiste = false;
			
			for (Date dthrI : keysDtHrI) {
				DetalheMonitorizacaoPTInjetDTO detalhes = new DetalheMonitorizacaoPTInjetDTO();
				AcompanhamentoProducaoDTO dto = new AcompanhamentoProducaoDTO();
				FiltroDetalhePTInjetDTO filtroInd = new FiltroDetalhePTInjetDTO();
				
				String intervalo = DataHoraRN.dateToStringDDMMYYYYHHMMSS(mapDatas.get(dthrI).get(0).getDthrIhora())
						 + " - " + DataHoraRN.dateToStringDDMMYYYYHHMMSS(mapDatas.get(dthrI).get(0).getDthrFhora());
				
				//String intervalo = DataHoraRN.dateToStringYYYYMMDDHHMMSS(mapDatas.get(dthrI).get(0).getDthrIhora())
				//		 + " - " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(mapDatas.get(dthrI).get(0).getDthrFhora());

				
				dto.setIntervalo(intervalo);
				dto.setMaquina(mapDatas.get(dthrI).get(0).getOmPt().getCdPt());
				dto.setUnidMedida(null); // nao eh usado pra nada
				dto.setListaCompletaParadas(null); // acho q nao serve pra nada
				listaRetorno.add(dto);

				List<DwConsolid> listaIds = new ArrayList<>();
				listaIds.addAll(mapDatas.get(dthrI)); 
				
				//ordenar por id >> igual ao criterio do BI
				Comparator<DwConsolid> comparator = new Comparator<DwConsolid>() {
					@Override
					public int compare(DwConsolid o1, DwConsolid o2) {
						Long str1 = o1.getIdConsolid();
						Long str2 = o2.getIdConsolid();
						return str1.compareTo(str2);
					}
				};
				Collections.sort(listaIds, comparator);				
				
				
				detalhes = new DetalheMonitorizacaoPTInjetDTO();
				filtroInd = new FiltroDetalhePTInjetDTO();
				filtroInd.setOmPt(mapDatas.get(dthrI).get(0).getOmPt());
				filtroInd.setOmGt(mapDatas.get(dthrI).get(0).getOmGt());

				IndicadoresDoDetalheRN rn = new IndicadoresDoDetalheRN(getDao(),
						log, omcfg, listaIds, false, // isRecuperarListaProdutos,
						false, // isRecuperarListaOperadores,
						false, // isRecuperarListaAlertas,
						false, // isRecuperarListaPerdas,
						false, // isRecuperarListaResumoDatas,
						false, // isRecuperarListaResumoTurnos,
						detalhes, filtroInd);

				rn.setResumoIndicadores();
				rn.setIndicadoresAdicionais();

				
				Double metaHora = mapMetasHora.get(dthrI).metaUB;
				Double metaHoraKg = mapMetasHora.get(dthrI).metaKg;
				Double metaHoraTon = mapMetasHora.get(dthrI).metaTon;

				
				if (filtro.isPeca()) {
					dto.setQtdPrevista(dto.getQtdPrevista()
							+ detalhes.getQtdPrevista().intValue());
					dto.setQtdPrevistaDec(dto.getQtdPrevistaDec()
							+ detalhes.getQtdPrevista());
					dto.setQtdProduzida(dto.getQtdProduzida()
							+ detalhes.getQtdPecasBoas().intValue());
					dto.setQtdProduzidaDec(dto.getQtdProduzidaDec()
							+ detalhes.getQtdPecasBoas());
					
					dto.setMetaPeriodo(metaHora.intValue());
					dto.setMetaPeriodoDec(metaHora);

					
					dto.setProjecaofPeriodo(projecaoFimPeriodoMaq.intValue());
					dto.setProjecaofPeriodoDec(projecaoFimPeriodoMaq);	
					
					
				} else if (filtro.isPeca() == false && filtro.getUnidMedida().equals("kilo")) {
					dto.setQtdPrevista(dto.getQtdPrevista()
							+ detalhes.getProducaoPrevistaKg().intValue());
					dto.setQtdPrevistaDec(dto.getQtdPrevistaDec()
							+ detalhes.getProducaoPrevistaKg().doubleValue());
					dto.setQtdProduzida(dto.getQtdProduzida()
							+ detalhes.getProducaoLiquidaKg().intValue());
					dto.setQtdProduzidaDec(dto.getQtdProduzidaDec()
							+ detalhes.getProducaoLiquidaKg().doubleValue());
					
					dto.setMetaPeriodo(metaHoraKg.intValue());
					dto.setMetaPeriodoDec(metaHoraKg);
					
					dto.setProjecaofPeriodo(projecaoFimPeriodoMaqKg.intValue());
					dto.setProjecaofPeriodoDec(projecaoFimPeriodoMaqKg);	
					
					
				} else if (filtro.isPeca() == false && filtro.getUnidMedida().equals("ton")) {
					dto.setQtdPrevista(dto.getQtdPrevista()
							+ detalhes.getProducaoPrevistaTn().intValue());
					dto.setQtdPrevistaDec(dto.getQtdPrevistaDec()
							+ detalhes.getProducaoPrevistaTn().doubleValue());
					dto.setQtdProduzida(dto.getQtdProduzida()
							+ detalhes.getProducaoLiquidaTn().intValue());
					dto.setQtdProduzidaDec(dto.getQtdProduzidaDec()
							+ detalhes.getProducaoLiquidaTn().doubleValue());
					
					dto.setMetaPeriodo(metaHoraTon.intValue());
					dto.setMetaPeriodoDec(metaHoraTon);
					
					dto.setProjecaofPeriodo(projecaoFimPeriodoMaqTon.intValue());
					dto.setProjecaofPeriodoDec(projecaoFimPeriodoMaqTon);	
				}
	 

				dto.setEficiCiclo(ConversaoTipos.converteParaDouble(
						detalhes.getEfiCiclos(), 2));
				dto.setEficiCicloDec(ConversaoTipos.converteParaDouble(
						detalhes.getEfiCiclos(), 2));
				dto.setIndicePa(ConversaoTipos.converteParaDouble(
						detalhes.getIndiceParadas(), 2));
				dto.setIndicePaDec(ConversaoTipos.converteParaDouble(
						detalhes.getIndiceParadas(), 2));

				dto.setIndicecavAtiva(detalhes.getIndiceCavAtivas());
				dto.setIndicecavAtivaDec(detalhes.getIndiceCavAtivas());

				
				if (filtro.isPeca()) {				
					dto.setEficRelaizacao(ConversaoTipos.converteParaDouble(
							detalhes.getEfiRealizacao(), 2));
					dto.setEficRelaizacaoDec(ConversaoTipos.converteParaDouble(
							detalhes.getEfiRealizacao(), 2));
					dto.setIndiceRef(ConversaoTipos.converteParaDouble(
							detalhes.getIndiceRefugos(), 2));
					dto.setIndiceRefDec(ConversaoTipos.converteParaDouble(
							detalhes.getIndiceRefugos(), 2));
				} else {
					dto.setEficRelaizacao(ConversaoTipos.converteParaDouble(
							detalhes.getEfiRealizacaoGr(), 2));
					dto.setEficRelaizacaoDec(ConversaoTipos.converteParaDouble(
							detalhes.getEfiRealizacaoGr(), 2));
					
					dto.setIndiceRef(ConversaoTipos.converteParaDouble(
							detalhes.getIndiceRefugoGr(), 2));
					dto.setIndiceRefDec(ConversaoTipos.converteParaDouble(
							detalhes.getIndiceRefugoGr(), 2));
					
				}
				

				projecaoFimPeriodoMaq = projecaoFimPeriodoMaq - detalhes.getQtdPecasBoas();
				projecaoFimPeriodoMaqKg = projecaoFimPeriodoMaqKg - detalhes.getProducaoPrevistaKg().doubleValue();
				projecaoFimPeriodoMaqTon = projecaoFimPeriodoMaqTon - detalhes.getProducaoPrevistaTn().doubleValue();			
			}
			

			if (filtro.isPeca()) {
				mapMaquinasTotal.put(maq, projecaoFimPeriodoMaq);
			} else if (filtro.isPeca() == false && filtro.getUnidMedida().equals("kilo")) {
				mapMaquinasTotal.put(maq, projecaoFimPeriodoMaqKg);
			} else if (filtro.isPeca() == false && filtro.getUnidMedida().equals("ton")) {
				mapMaquinasTotal.put(maq, projecaoFimPeriodoMaqTon);
			}
				

			TotaisMetaHora metas = new TotaisMetaHora();
			metas.metaUB = projecaoFimPeriodoMaq;
			metas.metaKg = projecaoFimPeriodoMaqKg;
			metas.metaTon = projecaoFimPeriodoMaqTon;
			
			mapMaquinasResumo.put(maq, metas);
			
		}
		
		
				
		criarConsolidVirtual(filtro, listaRetorno, listaParadasEmAberto);
		
		Comparator<AcompanhamentoProducaoDTO> comparator = new Comparator<AcompanhamentoProducaoDTO>() {
			@Override
			public int compare(AcompanhamentoProducaoDTO o1, AcompanhamentoProducaoDTO o2) {
				String str1 = o1.getIntervalo();
				String str2 = o2.getIntervalo();
				return str1.compareTo(str2);
			}
		};
		Collections.sort(listaRetorno, comparator);

		// Prepara retorno
		retorno.setListaAcompanhamentoProducaoDTO(listaRetorno);
		retorno.setListaCompletaParadas(listaParadasEmAberto); // USada no
																// subrelatorio
																// com as
																// paradas em
																// aberto
		return retorno;
	}
		
	private void criarConsolidVirtual(FiltroRelatorioAnaliseEficienciaDTO filtro,
			List<AcompanhamentoProducaoDTO> listaRetorno,
			List<RelatorioParadasAbertasDTO> listaParadasEmAberto){
		
		if(listaRetorno == null){
			listaRetorno = new ArrayList<>();
		}
		
		if(listaParadasEmAberto == null){
			listaParadasEmAberto = new ArrayList<>();
		}
		
		boolean isPossuiRetorno = listaRetorno.size() > 0;
		boolean isPossuiParadaAberta = listaParadasEmAberto.size() > 0;
		
		if(isPossuiRetorno){
			return;
		}
		
		if(isPossuiRetorno == false && isPossuiParadaAberta == false){
			return;
		}
		
		//continua o metodo se (isPossuiRetorno == false && isPossuiParadaAberta == true)
		
		for(RelatorioParadasAbertasDTO paradasAbertasDTO : listaParadasEmAberto){
			
			boolean listaRetornoContemPosto = false;
			String maquina = paradasAbertasDTO.getDsMaquinaCurta();
			for(AcompanhamentoProducaoDTO acompanhamentoProducaoDTO : listaRetorno){
				if(acompanhamentoProducaoDTO.getMaquina().equals(maquina)){
					listaRetornoContemPosto = true;
					break;
				}
			}
			
			if(listaRetornoContemPosto == false){
				AcompanhamentoProducaoDTO dto = new AcompanhamentoProducaoDTO();
				String intervalo = DataHoraRN.dateToStringYYYYMMDDHHMMSS(filtro.getDt_inicio())
						+ " - "
						+ DataHoraRN.dateToStringYYYYMMDDHHMMSS(filtro.getDt_final());
				dto.setIntervalo(intervalo);
				dto.setMaquina(paradasAbertasDTO.getMaquina());
				
				BigDecimal gramaPlanejada = paradasAbertasDTO.getPcsProducaoplanejada()
						.multiply(paradasAbertasDTO.getgPesoBruto());
				
				if (filtro.isPeca()) {
					dto.setProjecaofPeriodo(paradasAbertasDTO.getPcsProducaoplanejada().intValue());
					dto.setQtdPrevista(paradasAbertasDTO.getPcsProducaoplanejada().intValue());
					dto.setMetaPeriodo(paradasAbertasDTO.getPcsProducaoplanejada().intValue());
					dto.setProjecaofPeriodoDec(paradasAbertasDTO.getPcsProducaoplanejada().doubleValue());
					dto.setQtdPrevistaDec(paradasAbertasDTO.getPcsProducaoplanejada().doubleValue());
					dto.setMetaPeriodoDec(paradasAbertasDTO.getPcsProducaoplanejada().doubleValue());
				} else if (filtro.isPeca() == false
						&& filtro.getUnidMedida().equals("kilo")) {
					Double kiloPlanejada =  gramaPlanejada.doubleValue() / 1000d;
					dto.setProjecaofPeriodo(kiloPlanejada.intValue());
					dto.setQtdPrevista(kiloPlanejada.intValue());
					dto.setMetaPeriodo(kiloPlanejada.intValue());
					dto.setProjecaofPeriodoDec(kiloPlanejada);
					dto.setQtdPrevistaDec(kiloPlanejada);
					dto.setMetaPeriodoDec(kiloPlanejada);
				} else if (filtro.isPeca() == false
						&& filtro.getUnidMedida().equals("ton")) {
					Double tonPlanejada =  gramaPlanejada.doubleValue() / 1000000d;
					dto.setProjecaofPeriodo(tonPlanejada.intValue());
					dto.setQtdPrevista(tonPlanejada.intValue());
					dto.setMetaPeriodo(tonPlanejada.intValue());
					dto.setProjecaofPeriodoDec(tonPlanejada);
					dto.setQtdPrevistaDec(tonPlanejada);
					dto.setMetaPeriodoDec(tonPlanejada);
				}
				
				dto.setIndicePa(100d);
				listaRetorno.add(dto);
			}			
		}
	}

	private List<DwConsolid> consultaRelatorioAcompProducao(
			FiltroRelatorioAnaliseEficienciaDTO filtro,
			byte tpId) {

		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("LEFT JOIN consolid.omPt ompt");		
		q.append("LEFT JOIN ompt.omObjs omobj");		
		q.append("JOIN consolid.dwConsols consol");
		q.append("LEFT JOIN consol.dwConsolprs consolpr");
		q.append("LEFT JOIN consolpr.omProduto omproduto ");
		q.append("LEFT JOIN consol.dwConsolpas consolpa");
		q.append("LEFT JOIN consol.dwConsolres consolre");
		q.append("LEFT JOIN consolid.dwFolha folha");
		q.append("LEFT JOIN folha.dwFolharaps folharap");
		q.append("LEFT JOIN folharap.dwFolharapcoms folharapcom");
		q.append("LEFT JOIN consolpa.dwTParada dwtparada");
		q.append("LEFT JOIN dwtparada.dwConsolpalogs dwconsolpalog");
		q.append("LEFT JOIN dwconsolpalog.dwTAcao dwtacao ");
		q.append("WHERE consolid.tpId = :tpId");
		q.append("AND consolid.stAtivo IS NULL");
		
		// comentei as linhas abaixo pois stativo pode ser null e is null para
		// dthrfparada iria pegar apenas quem tem parada em aberta
		// q.append("AND ompt.stAtivo = :stAtivo");
		// q.append("AND dwconsolpalog.dthrFparada IS NULL");

		if (filtro.getDt_inicio() != null) {
			q.append("AND consolid.dthrIhora >= :dthrIhora");
		}
		if (filtro.getDt_final() != null) {
			q.append("AND consolid.dthrFhora <= :dthrFhora");
		}
		if (filtro.getOmpt() != null) {
			q.append("AND consolid.omPt.idPt = :idpt");
		}
		if (filtro.getOmgt() != null) {
			q.append("AND omobj.omGtByIdGt.idGt = :idGt");
		}

		//Marcos Sardinha: 2017-08-25 >> Defeito #4404
		q.append("ORDER BY consolid.idConsolid");
		
		q.defineParametro("tpId", tpId);

		if (filtro.getDt_inicio() != null) {
			q.defineParametroTimestamp("dthrIhora", filtro.getDt_inicio());
		}
		if (filtro.getDt_final() != null) {

			q.defineParametroTimestamp("dthrFhora", filtro.getDt_final());
		}
		if (filtro.getOmpt() != null) {
			q.defineParametro("idpt", filtro.getOmpt().getIdPt());
		}
		if (filtro.getOmgt() != null) {
			q.defineParametro("idGt", filtro.getOmgt().getIdGt());
		}
		
		return q.list();
	}
}
