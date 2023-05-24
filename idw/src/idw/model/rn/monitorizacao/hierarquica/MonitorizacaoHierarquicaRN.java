package idw.model.rn.monitorizacao.hierarquica;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.ObjectUtils;

import idw.model.dao.OmObjDAO;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwRt;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmInd;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.pojos.template.DwRtTemplate;
import idw.model.pojos.template.OmIndTemplate;
import idw.model.pojos.template.OmIndTemplate.Tipo;
import idw.model.pojos.template.OmObjTemplate;
import idw.model.pojos.template.OmTpptTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.model.rn.indicador.CalculoIndicadorAgrupadoRN;
import idw.model.rn.indicador.IndicadorRN;
import idw.model.rn.indicador.IndicadorValorDTO;
import idw.model.rn.indicador.IndicadorValorMinMetaMaxDTO;
import idw.model.rn.indicador.NivelIndicadorRN;
import idw.util.CompareUtils;
import idw.webservices.dto.FiltroProducaoDTO;
import idw.webservices.dto.IndicadorMinMetaMaxDTO;
import idw.webservices.dto.MonitorizacaoHierarquicaDTO;
import idw.webservices.dto.TurnoAtualDTO;

public class MonitorizacaoHierarquicaRN extends DetalheMonitorizacaoPTInsertRN {
	
	private final BigDecimal MINIMO_PADRAO = new BigDecimal(50);
	private final BigDecimal META_PADRAO = new BigDecimal(90);	
	private final BigDecimal MAXIMO_PADRAO = new BigDecimal(100);
	
	/*
	 * Metodo principal para retorno dos dados da monitorização hierárquica
	 */
	public MonitorizacaoHierarquicaDTO getMonitorizacaoHierarquicaDTO(FiltroProducaoDTO filtro){
				
		MonitorizacaoHierarquicaDTO retorno = getLayoutMonitorizacaoHierarquicaDTO(filtro.getOmGt());
		
		Map<String, List<DwConsolid>> mapProducaoPT = new HashMap<String, List<DwConsolid>>();
		Map<String, List<DwConsolid>> mapProducaoGT = new HashMap<String, List<DwConsolid>>();
		Map<String, List<DwConsolid>> mapProducaoCP = new HashMap<String, List<DwConsolid>>();
		agruparListasProducaoGtePteCP(retorno, filtro, mapProducaoGT, mapProducaoPT, mapProducaoCP);

		Map<String, List<MonitorizacaoHierarquicaDTO>> mapMonitorizacaoHierarquicaPT = new HashMap<String, List<MonitorizacaoHierarquicaDTO>>();
		Map<String, List<MonitorizacaoHierarquicaDTO>> mapMonitorizacaoHierarquicaGT = new HashMap<String, List<MonitorizacaoHierarquicaDTO>>();
		Map<String, List<MonitorizacaoHierarquicaDTO>> mapMonitorizacaoHierarquicaCP = new HashMap<String, List<MonitorizacaoHierarquicaDTO>>();
		agruparListasMonitorizacaoHierarquicaGtEPteCP(retorno, mapMonitorizacaoHierarquicaGT, mapMonitorizacaoHierarquicaPT, mapMonitorizacaoHierarquicaCP, mapProducaoPT);
		
		atualizarDadosIndicadoresMonitorizacaoHierarquica(mapMonitorizacaoHierarquicaGT, mapProducaoGT);
		atualizarDadosIndicadoresMonitorizacaoHierarquica(mapMonitorizacaoHierarquicaPT, mapProducaoPT);
		atualizarDadosIndicadoresMonitorizacaoHierarquica(mapMonitorizacaoHierarquicaCP, mapProducaoCP);
		
		
		atualizarDadosIndicadoresMetaMinMaxMonitoricaoHierarquicaArvore(retorno);
		totalizaMaquinasParadas(retorno);
		
		retorno.setDtHrUltimaImportacao(getDtHrUltimaImportacao(mapProducaoPT));
		
		return retorno;
		
	}
	
	
	private void totalizaMaquinasParadas(MonitorizacaoHierarquicaDTO retorno)
	{
		// totaliza qtde de máq paradas aqui - força que maq sem dados no turno apareçam como sem planejamento		
		int totalMaqSemPeso = 0;
		int totalMaqComPeso = 0;
		
		for (MonitorizacaoHierarquicaDTO objMonit :  retorno.getMonitorizacaoHierarquicaDTOs())
		{
			if (objMonit.getOmGt() != null)
			{
				totalizaMaquinasParadas(objMonit);
				for (IndicadorValorMinMetaMaxDTO indicadorObj : objMonit.getIndicadorValorMinMetaMaxDTOs())
				{
					if (indicadorObj.getIndicadorValorDTO().getOmInd().isTotalMaquinasParadasSemPeso())
					{
						totalMaqSemPeso = totalMaqSemPeso + (int) indicadorObj.getIndicadorValorDTO().getValor();
					}
					if (indicadorObj.getIndicadorValorDTO().getOmInd().isTotalMaquinasParadasComPeso())
					{
						totalMaqComPeso = totalMaqComPeso + (int) indicadorObj.getIndicadorValorDTO().getValor();
					}					
				}
				  
			}
			else
			{
				if (objMonit.getOmObj().getOmPt() != null && objMonit.getCdCp() == null)
				{
					for (IndicadorValorMinMetaMaxDTO indicadorMaq : objMonit.getIndicadorValorMinMetaMaxDTOs())
					{
						if (indicadorMaq.getIndicadorValorDTO().getOmInd().isTotalMaquinasParadasSemPeso()) 
						{
							if (indicadorMaq.getIndicadorValorDTO().getValor() == 1d) 
							{							
								totalMaqSemPeso ++;
							}
						}
						
						if (indicadorMaq.getIndicadorValorDTO().getOmInd().isTotalMaquinasParadasComPeso()) 
						{
							if (indicadorMaq.getIndicadorValorDTO().getValor() == 1d) 
							{							
								totalMaqComPeso ++;
							}
						}					
					}
				}
			}
		}

		for (IndicadorValorMinMetaMaxDTO indicador : retorno.getIndicadorValorMinMetaMaxDTOs())
		{
			if (indicador.getIndicadorValorDTO().getOmInd().isTotalMaquinasParadasSemPeso())
			{
				indicador.getIndicadorValorDTO().setValor(totalMaqSemPeso);	
			}

			if (indicador.getIndicadorValorDTO().getOmInd().isTotalMaquinasParadasComPeso())
			{
				indicador.getIndicadorValorDTO().setValor(totalMaqComPeso);
			}
		}			
		
	}
	
	
	/*
	 * O objetivo desse metodo eh agrupar os DTOs que serao retornados pelo webservice. Esse agrupamento leva em contaa hierarquia de GT -> PT -> CP
	 */
	private void agruparListasMonitorizacaoHierarquicaGtEPteCP(
			MonitorizacaoHierarquicaDTO retorno, 
			Map<String, List<MonitorizacaoHierarquicaDTO>> mapMonitorGT, 
			Map<String, List<MonitorizacaoHierarquicaDTO>> mapMonitorPT,
			Map<String, List<MonitorizacaoHierarquicaDTO>> mapMonitorCP,
			Map<String, List<DwConsolid>> mapProducaoPT){
		

		String cdGt = retorno.getOmGt().getCdGt();
		List<MonitorizacaoHierarquicaDTO> monitorGT = mapMonitorGT.get(cdGt);
		if(monitorGT == null){
			monitorGT = new ArrayList<MonitorizacaoHierarquicaDTO>();
			mapMonitorGT.put(cdGt, monitorGT);
		}
		monitorGT.add(retorno);
		
		for(MonitorizacaoHierarquicaDTO filho: retorno.getMonitorizacaoHierarquicaDTOs()){
			
			if(filho.getOmObj() != null){
				
				if(filho.getOmObj().getOmPt() != null){					
					
					String cdPt = filho.getOmObj().getOmPt().getCdPt(); 
					List<MonitorizacaoHierarquicaDTO> monitorPT = mapMonitorPT.get(cdPt);					
					if(monitorPT == null){
						monitorPT = new ArrayList<MonitorizacaoHierarquicaDTO>();
						mapMonitorPT.put(cdPt, monitorPT);
					}
					monitorPT.add(filho);
					
					// Apos inserir o PT, avaliar para inserir o CPs do PT. Para isso é necessário interagir sobre os dwconsolid do PT
					List<DwConsolid> lista = mapProducaoPT.get(cdPt);
					if (lista != null) {
						filho.setMonitorizacaoHierarquicaDTOs(new ArrayList<MonitorizacaoHierarquicaDTO>());
						for (DwConsolid id : lista) {
							String cd = cdPt + "-" + id.getPpCp().getCdCp();
							List<MonitorizacaoHierarquicaDTO> monitorCP = mapMonitorCP.get(cd);
							if (monitorCP == null) {
								monitorCP = new ArrayList<MonitorizacaoHierarquicaDTO>();
								MonitorizacaoHierarquicaDTO dto = new MonitorizacaoHierarquicaDTO();
								dto.setCdCp(id.getPpCp().getCdCp());
								monitorCP.add(dto);
								mapMonitorCP.put(cd, monitorCP);
								filho.getMonitorizacaoHierarquicaDTOs().addAll(monitorCP);
							}
							//monitorCP.add(filho);
						}
					}					
				}else if (filho.getOmObj().getOmGtByIdGtfilho() != null){
					agruparListasMonitorizacaoHierarquicaGtEPteCP(filho, mapMonitorGT, mapMonitorPT, mapMonitorCP, mapProducaoPT);	
				}
				
			
			}

		}
		
	}

	private void atualizarDadosIndicadoresMetaMinMaxMonitoricaoHierarquicaArvore(MonitorizacaoHierarquicaDTO root) {
		
		//atualizarIndicadorMinMetaMax()
		atualizarIndicadoresMinMetaMaxNode(root);
		
		for(MonitorizacaoHierarquicaDTO node: root.getMonitorizacaoHierarquicaDTOs()){
			if(node.getOmObj().getOmGtByIdGtfilho() != null){
				atualizarDadosIndicadoresMetaMinMaxMonitoricaoHierarquicaArvore(node);
			}else{
				atualizarIndicadoresMinMetaMaxNode(node);
			}
		}
		
	}
	
	private void atualizarIndicadoresMinMetaMaxNode(MonitorizacaoHierarquicaDTO monitorizacaoHierarquicaDTO)
	{
		Boolean aplicarCorParada = false;
		OmObj omObj = monitorizacaoHierarquicaDTO.getOmObj();
		
		atualizarIndicadorMinMetaMax(Tipo.OEE, monitorizacaoHierarquicaDTO);
		atualizarIndicadorMinMetaMax(Tipo.DISPONIBILIDADE, monitorizacaoHierarquicaDTO);
		atualizarIndicadorMinMetaMax(Tipo.RITMO_PERC, monitorizacaoHierarquicaDTO);
		atualizarIndicadorMinMetaMax(Tipo.QUALIDADE, monitorizacaoHierarquicaDTO);
		
		atualizarIndicadorMinMetaMax(Tipo.TOTAL_MAQUINAS, monitorizacaoHierarquicaDTO);
		atualizarIndicadorMinMetaMax(Tipo.TOTAL_MAQ_PAR_COM_PESO, monitorizacaoHierarquicaDTO);
		atualizarIndicadorMinMetaMax(Tipo.TOTAL_MAQ_PAR_SEM_PESO, monitorizacaoHierarquicaDTO);

		
        if (omObj != null && omObj.getOmPt() != null)
        {
            aplicarCorParada = true;
        }
        else 
        {   
            if (monitorizacaoHierarquicaDTO.getCdCp() != null && monitorizacaoHierarquicaDTO.getCdCp().equals("") == false) 
            {
            	aplicarCorParada = true;
            }
        }
		
		NivelIndicadorRN.ajustarNivelIndicador(monitorizacaoHierarquicaDTO.getIndicadorValorMinMetaMaxDTOs(), aplicarCorParada);
		
	}
	
	private void atualizarIndicadorMinMetaMax(OmIndTemplate.Tipo tipoInd, MonitorizacaoHierarquicaDTO monitorizacaoHierarquicaDTO){
		
		boolean isEncontrou = false;
		
		IndicadorValorMinMetaMaxDTO indicadorValorMinMetaMaxDTO = null;
		OmInd omInd = null;
		
		for(IndicadorValorMinMetaMaxDTO item: monitorizacaoHierarquicaDTO.getIndicadorValorMinMetaMaxDTOs()){
			indicadorValorMinMetaMaxDTO = item;
			omInd = indicadorValorMinMetaMaxDTO.getIndicadorValorDTO().getOmInd();
			Tipo tipoIndItem = Tipo.getTipo(omInd.getIdInd());
			if(tipoInd.equals(tipoIndItem)){
				isEncontrou = true;
				break;
			}
		}
		
		if(isEncontrou){
			IndicadorRN indicadorRN = new IndicadorRN(this.getDao());
			
			OmTpptTemplate.Type tipoTppt = null;
			
			OmPt omPt = null;
			OmGt omGt = null;
			if(monitorizacaoHierarquicaDTO.getOmObj() != null){
				omPt = monitorizacaoHierarquicaDTO.getOmObj().getOmPt();
				omGt = monitorizacaoHierarquicaDTO.getOmObj().getOmGtByIdGtfilho();
			}
						
			
			if(omPt != null){
				PTRN ptRN = new PTRN(getDao());
				
				omPt = ptRN.getOmPtById(omPt.getIdPt());
				if(omPt != null){
					tipoTppt = OmTpptTemplate.Type.get(omPt.getOmTppt().getId());					
				}				
				
			}
			
			if(omGt == null){
				omGt = monitorizacaoHierarquicaDTO.getOmGt();
			}
			
			IndicadorMinMetaMaxDTO indicadorMinMetaMaxDTO = indicadorRN.buscarIndicadorMinMetaMaxDTOPorPtOuTpptOuGtOuCfg(omGt, omPt, tipoTppt, tipoInd);
						
			if(indicadorMinMetaMaxDTO == null){
				indicadorMinMetaMaxDTO = new IndicadorMinMetaMaxDTO(omInd, MINIMO_PADRAO, MAXIMO_PADRAO, META_PADRAO);
			}
			
			indicadorValorMinMetaMaxDTO.setIndicadorMinMetaMaxDTO(indicadorMinMetaMaxDTO);

		}
		
		
	}
	
	private void atualizarDadosIndicadoresMonitorizacaoHierarquica(
			Map<String, List<MonitorizacaoHierarquicaDTO>> mapMonitorizacaoHierarquica, Map<String, List<DwConsolid>> mapProducao){
		
		for(String cd: mapMonitorizacaoHierarquica.keySet()){
			
			
			// o trecho abaixo é necessário porque eventualemnte máquinas de um agrupamento podem estar sem registro em dwconsolid
			int numQtdItens = totalMaquinasMap(mapMonitorizacaoHierarquica.get(cd));
			
			List<DwConsolid> listaDwConsolDwConsolid = mapProducao.get(cd);
			
			if(listaDwConsolDwConsolid == null){
				listaDwConsolDwConsolid = new ArrayList<DwConsolid>();
				
				// necessário por causa de maq sem dados no período... usada pra setar maq sem programacao
				listaDwConsolDwConsolid.add(new DwConsolid());		
				listaDwConsolDwConsolid.get(0).setOmPt(new OmPt());				
				listaDwConsolDwConsolid.get(0).getOmPt().setCdPt(cd);
				listaDwConsolDwConsolid.get(0).setDwRt(new DwRt());
				listaDwConsolDwConsolid.get(0).getDwRt().setStFuncionamento(DwRtTemplate.StFuncionamento.PARADA.getId());
				listaDwConsolDwConsolid.get(0).getDwRt().setIsSemplanejamento(true);
				listaDwConsolDwConsolid.get(0).getDwRt().setIsParadapeso(false);
			
				
				mapProducao.put(cd, listaDwConsolDwConsolid);
			}

			Map<OmIndTemplate.Tipo, BigDecimal> indicadores =  CalculoIndicadorAgrupadoRN.calcularIndicadores(listaDwConsolDwConsolid, numQtdItens);
			
			List<IndicadorValorMinMetaMaxDTO> indicadorValorMinMetaMaxDTOs = getIndicadorValorMinMetaMaxDTOs(indicadores);
			
			for(MonitorizacaoHierarquicaDTO monitorizacaoHierarquicaDTO: mapMonitorizacaoHierarquica.get(cd)){
				monitorizacaoHierarquicaDTO.setIndicadorValorMinMetaMaxDTOs(indicadorValorMinMetaMaxDTOs);
			}
			
		}
		
		
	}
	
	private int totalMaquinasMap(List<MonitorizacaoHierarquicaDTO> listaItensDTO)
	{
		int numQtdItens = 0;
		for (MonitorizacaoHierarquicaDTO itemLista : listaItensDTO)
		{
			if (itemLista.getCdCp() != null)
			{
				numQtdItens = numQtdItens + 1;
				break;
			}
			else
			{
				if (itemLista.getMonitorizacaoHierarquicaDTOs() != null)
				{
					numQtdItens = numQtdItens + totalMaquinasMap(itemLista.getMonitorizacaoHierarquicaDTOs());
				}
				else
				{
					numQtdItens = numQtdItens + 1;
				}
			}
		}
		
		return numQtdItens;
	}
	
	private List<IndicadorValorMinMetaMaxDTO> getIndicadorValorMinMetaMaxDTOs(Map<OmIndTemplate.Tipo, BigDecimal> indicadores){
		List<IndicadorValorMinMetaMaxDTO> indicadorValorMinMetaMaxDTOs = new ArrayList<IndicadorValorMinMetaMaxDTO>();
		
		indicadorValorMinMetaMaxDTOs.add(getIndicadorValorMinMetaMaxDTO(Tipo.OEE, indicadores));
		indicadorValorMinMetaMaxDTOs.add(getIndicadorValorMinMetaMaxDTO(Tipo.DISPONIBILIDADE, indicadores));
		indicadorValorMinMetaMaxDTOs.add(getIndicadorValorMinMetaMaxDTO(Tipo.RITMO_PERC, indicadores));
		indicadorValorMinMetaMaxDTOs.add(getIndicadorValorMinMetaMaxDTO(Tipo.QUALIDADE, indicadores));
		
		indicadorValorMinMetaMaxDTOs.add(getIndicadorValorMinMetaMaxDTO(Tipo.TOTAL_MAQUINAS, indicadores));
		indicadorValorMinMetaMaxDTOs.add(getIndicadorValorMinMetaMaxDTO(Tipo.TOTAL_MAQ_PAR_COM_PESO, indicadores));
		indicadorValorMinMetaMaxDTOs.add(getIndicadorValorMinMetaMaxDTO(Tipo.TOTAL_MAQ_PAR_SEM_PESO, indicadores));
		
		return indicadorValorMinMetaMaxDTOs;
		
	}
	
	private IndicadorValorMinMetaMaxDTO getIndicadorValorMinMetaMaxDTO(OmIndTemplate.Tipo tipo, Map<OmIndTemplate.Tipo, BigDecimal> indicadores){
		
		IndicadorValorMinMetaMaxDTO indicadorValorMinMetaMaxDTO = new IndicadorValorMinMetaMaxDTO();
		IndicadorValorDTO indicadorValorDTO = getIndicadorValorDTO(tipo, indicadores);
		
		indicadorValorMinMetaMaxDTO.setIndicadorValorDTO(indicadorValorDTO);
		
		// Marcos Sardinha: 24/03/2015:  Necessário setar status referente a parada com peso e sem peso para cada um dos indicadores. A cor nestas situações terá que se sobresair
		IndicadorValorDTO indParComPeso = getIndicadorValorDTO(OmIndTemplate.Tipo.STATUS_PARADA_COM_PESO, indicadores);
		IndicadorValorDTO indParSemPeso = getIndicadorValorDTO(OmIndTemplate.Tipo.STATUS_PARADA_SEM_PESO, indicadores);
		
		indicadorValorMinMetaMaxDTO.setParadaComPeso(indParComPeso.getValor() == 1d ? true :  false);
		indicadorValorMinMetaMaxDTO.setParadaSemPeso(indParSemPeso.getValor() == 1d ? true :  false);
		
		return indicadorValorMinMetaMaxDTO;
		
	}
	private IndicadorValorDTO getIndicadorValorDTO(OmIndTemplate.Tipo tipo, Map<OmIndTemplate.Tipo, BigDecimal> indicadores){
		IndicadorValorDTO indicadorValorDTO = new IndicadorValorDTO();
		
		OmInd omInd = new OmInd();
		indicadorValorDTO.setOmInd(omInd);
		omInd.setIdInd(tipo.getId());
		omInd.setCdInd(tipo.toString());
		omInd.setCdInd(tipo.toString());
		
		BigDecimal valor = ObjectUtils.defaultIfNull(indicadores.get(tipo), BigDecimal.ZERO);
		
		indicadorValorDTO.setValor(valor.doubleValue());
		
		return indicadorValorDTO;
		
	}
	
	
	/*
	 * Metodo para pesquisar dwconsolid
	 */
	private List<DwConsolid> getRecursivamenteViaGTFilhoDwConsolid(Date dtReferencia, DwTurno dwturno, OmGt omgt, boolean isTurnoAtual) {
		List<DwConsolid> retorno = new ArrayList<DwConsolid>();
		
		Date dtReferenciaDwConsol = null;
		
		// Se for true entao obter para o Gt qual o turno de referencia, conforme a dt hr de referencia em dtReferencia
		if (isTurnoAtual == true) {
			TurnoRN trn = new TurnoRN(getDao());
            TurnoAtualDTO turnoAtualDTO;
			try {
				turnoAtualDTO = trn.getTurnoAtualGtDTO(omgt, dtReferencia, true);
			} catch (SemCalendarioException e) {
				e.printStackTrace();
				return retorno;
			}
			
            // Setar a data e turno na interface
            //dtReferencia = turnoAtualDTO.getDtReferencia();
			dtReferenciaDwConsol = turnoAtualDTO.getDtReferencia();
            dwturno = turnoAtualDTO.getDwturno();
            System.out.println("TURNO usado para " + omgt.getCdGt() + " - id gt " + omgt.getId().toString()  + " dt " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtReferencia) + " cdturno=" + dwturno.getCdTurno());
		} 
		else
		{
			dtReferenciaDwConsol = dtReferencia;
		}
		
		
		
		List<DwConsolid> listaDwConsolid = getDwConsolid(
				null, DwConsolidTemplate.TpId.TURNO.getValue(), 
				dwturno, null, null, dtReferenciaDwConsol, null,
				null, null , null, 
				null, null, true, false, false,
				0, omgt, null , false, false, false);

		retorno.addAll(listaDwConsolid);
		
		for (OmObj omobj : omgt.getOmObjsForIdGt()) {
			if (omobj.getOmGtByIdGtfilho() != null) {
				retorno.addAll(getRecursivamenteViaGTFilhoDwConsolid(dtReferencia, dwturno, omobj.getOmGtByIdGtfilho(), isTurnoAtual));
			}
		}
		return retorno;
	}

	/*
	 * O objetivo desse metodo eh relacionar nos MAPs os dwconsolids relacionados e agrupados por GT pT e CP
	 */
	private void agruparListasProducaoGtePteCP(
			MonitorizacaoHierarquicaDTO retorno, 
			FiltroProducaoDTO filtro, 
			Map<String, List<DwConsolid>> mapProducaoGTGeral, 
			Map<String, List<DwConsolid>> mapProducaoPTGeral, 
			Map<String, List<DwConsolid>> mapProducaoCPGeral){
		
		boolean isProducaoDoGtJaFoiPega = mapProducaoGTGeral.containsKey(retorno.getOmGt()); 
		
		if(!isProducaoDoGtJaFoiPega){
			
			// A lista de dwConsolid para o GT deve ser, alem dos dwconsolid dos pt abaixo do GT, os dwconsolids dos sub-GTs recrusivamente.
			List<DwConsolid> listaDwConsolid = null;
			Date dtReferencia = filtro.getDtReferencia();
			if (filtro.getIsTurnoAtual() != null && filtro.getIsTurnoAtual() == true)
				dtReferencia = filtro.getDthrReferencia();
			
			listaDwConsolid = getRecursivamenteViaGTFilhoDwConsolid(
					dtReferencia,
					filtro.getDwTurno(),
					retorno.getOmGt(),
					filtro.getIsTurnoAtual()
					);
			
			
			// agrupa os pts e cps
			Map<String, List<DwConsolid>> mapProducaoPTLocal = new HashMap<String, List<DwConsolid>>();
			Map<String, List<DwConsolid>> mapProducaoCPLocal = new HashMap<String, List<DwConsolid>>();

			// Avalia os dwconsolid para avaliar a insersao em PT e CP
			for(DwConsolid dwConsolid: listaDwConsolid){
				// Insere apenas os pts					
				String cd = dwConsolid.getOmPt().getCdPt();
				
				if(mapProducaoPTGeral.containsKey(cd) == false){
					
					List<DwConsolid> listaDwConsolidaLocal = mapProducaoPTLocal.get(cd);
					if(listaDwConsolidaLocal == null){
						listaDwConsolidaLocal = new ArrayList<DwConsolid>();
						mapProducaoPTLocal.put(cd, listaDwConsolidaLocal);
					}
					
					listaDwConsolidaLocal.add(dwConsolid);
				}
				
				// Insere os CPs
				cd += "-" + dwConsolid.getPpCp().getCdCp();
				if (mapProducaoCPGeral.containsKey(cd) == false) {
					
					List<DwConsolid> listaDwconsolidLocalCp = mapProducaoCPLocal.get(cd);
					if (listaDwconsolidLocalCp == null) {
						listaDwconsolidLocalCp = new ArrayList<DwConsolid>();
						mapProducaoCPLocal.put(cd, listaDwconsolidLocalCp);
					}
					
					listaDwconsolidLocalCp.add(dwConsolid);
				}
				
			}
			mapProducaoPTGeral.putAll(mapProducaoPTLocal);
			mapProducaoCPGeral.putAll(mapProducaoCPLocal);
			
			mapProducaoGTGeral.put(retorno.getOmGt().getCdGt(), listaDwConsolid);
			
			// Insere apenas gts filhos 
			for(MonitorizacaoHierarquicaDTO item: retorno.getMonitorizacaoHierarquicaDTOs()){
				if(item.getOmObj().getOmGtByIdGtfilho() != null){
					agruparListasProducaoGtePteCP(item, filtro, mapProducaoGTGeral, mapProducaoPTGeral, mapProducaoCPGeral );					
				}
			}
		}
	}
	
	

	/*
	 * O objetivo desse metodo é retorno a arvore hierarquica com os valores de GT e PT
	 */
	public MonitorizacaoHierarquicaDTO getLayoutMonitorizacaoHierarquicaDTO(OmGt omGt){
		
		MonitorizacaoHierarquicaDTO monitorizacaoHierarquicaDTO = new MonitorizacaoHierarquicaDTO();
		monitorizacaoHierarquicaDTO.setOmGt(omGt.clone());
		monitorizacaoHierarquicaDTO.setMonitorizacaoHierarquicaDTOs(new ArrayList<MonitorizacaoHierarquicaDTO>());
		
		OmObjDAO omObjDAO = new OmObjDAO(getDaoSession());
		List<OmObj> listaOmObj = omObjDAO.getOmObjComCdGt(omGt, 0);
		for(OmObj omObj: listaOmObj){
			if(OmObjTemplate.TpObj.TIPO_OBJ_GT.equals(omObj.getTpObj()) || OmObjTemplate.TpObj.TIPO_OBJ_PT.equals(omObj.getTpObj())){
				if(omObj.getOmPt() != null || omObj.getOmGtByIdGtfilho() != null){
					MonitorizacaoHierarquicaDTO filhoDTO = new MonitorizacaoHierarquicaDTO();
					if(omObj.getOmGtByIdGtfilho() != null){
						filhoDTO = getLayoutMonitorizacaoHierarquicaDTO(omObj.getOmGtByIdGtfilho());
					}
					
					filhoDTO.setOmObj(omObj.clone(true));
					monitorizacaoHierarquicaDTO.getMonitorizacaoHierarquicaDTOs().add(filhoDTO);
				}
			}
			
		}
		
		if(!monitorizacaoHierarquicaDTO.getMonitorizacaoHierarquicaDTOs().isEmpty()){
			Collections.sort(monitorizacaoHierarquicaDTO.getMonitorizacaoHierarquicaDTOs(), new Comparator<MonitorizacaoHierarquicaDTO>() {
				@Override
				public int compare(MonitorizacaoHierarquicaDTO o1, MonitorizacaoHierarquicaDTO o2) {
					int compareTo = CompareUtils.compareTo(o1.getOmObj().getX(), o2.getOmObj().getX());
					if(compareTo == 0){
						if(o1.getOmObj() != null && o2.getOmObj() != null && o1.getOmObj().getY() != null && o2.getOmObj().getY() != null){		
							compareTo = o1.getOmObj().getY().compareTo(o2.getOmObj().getY());	
						}
						
					}
					return compareTo;
				}
			});
		}
		
		return monitorizacaoHierarquicaDTO;
	}
	
	/*
	 * O objetivo desse metodo é retornar a data/hora da última importa��oo baseda na coluna dthrfconsol de dw_consolid
	 */

	private Date getDtHrUltimaImportacao(Map<String, List<DwConsolid>> mapProducaoPT)
	{
		Date retorno = null;
		
		Set<String> chavesDwConsolid = mapProducaoPT.keySet();
		
		for (String chaveDwci : chavesDwConsolid)
		{			
			for (DwConsolid dwci : mapProducaoPT.get(chaveDwci))
			{			
				if (dwci.getDthrFconsol() != null)
				{
					if (retorno == null)
					{
						retorno = dwci.getDthrFconsol(); 
					}
					else
					{
						if (DataHoraRN.compareTo(retorno, dwci.getDthrFconsol()) < 0)
						{
							retorno = dwci.getDthrFconsol();
						}
					}
				}
			}
		}		
		return retorno;
	}
	
}
