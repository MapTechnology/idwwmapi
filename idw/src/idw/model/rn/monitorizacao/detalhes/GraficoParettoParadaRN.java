package idw.model.rn.monitorizacao.detalhes;

import java.awt.Color;
import java.awt.Paint;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
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
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhacic;
import idw.model.pojos.DwTArea;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.AreaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.DwRapRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.GTRN;
import idw.model.rn.PTRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.model.rn.geraplano.dtos.DatasDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParetoParadaAreaRespDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoParadaDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParettoParadaDTO;
import idw.util.AritmeticaUtil;
import idw.util.Cor;
import idw.util.FormulasInjet;
import idw.util.GrafTendenciaUtils;
import idw.util.IntervaloGrafTendenciaRefugoParada;
import idw.webservices.dto.AreaRespParadaDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.GraficoAreaRespParadaDTO;
import idw.webservices.dto.OcorrenciasEvtDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiFiltroDTO;
import ms.util.ConversaoTipos;

public class GraficoParettoParadaRN extends AbstractRN<DAOGenerico> {

    public GraficoParettoParadaRN() {
        this(new DAOGenerico());
    }

    public GraficoParettoParadaRN(DAOGenerico dao) {
        super(dao);
    }

    /* Esse metodo retona os dados para o grafico de area responsavel da ficha da máquina
     * 
     */
    public GraficoAreaRespParadaDTO getGraficoAreaRespParada(
    		Byte tpId, 
    		Date dtInicial, 
    		Date dtFinal, 
    		BigDecimal idTurno, 
    		String cdPt, 
    		String cdCp, 
    		Boolean isComPeso, 
    		Boolean isSemPeso) {

        GraficoAreaRespParadaDTO retorno;
        AreaRespParadaDTO areaResp = null;

        BigDecimal tempoTotalParadas = BigDecimal.ZERO;
        
        final int _cdArea = 0;
        final int _dsArea = 1;
        final int _segAutoTempoparadaCp = 2;
        final int _segAutoTempoparadaSp = 3;

        MapQuery q = new MapQuery(getDaoSession());
        q.append("SELECT ");

        q.append("dwtarea.cdArea,");
        q.append("dwtarea.dsArea,");
        q.append("SUM(dwconsolpa.segAutoTempoparadaCp),");
        q.append("SUM(dwconsolpa.segAutoTempoparadaSp)");
        q.append("FROM DwConsolpa dwconsolpa");
        q.append("JOIN dwconsolpa.dwConsol dwconsol");
        q.append("JOIN dwconsol.dwConsolid dwconsolid");
        q.append("JOIN dwconsolpa.dwTParada dwtparada");
        q.append("JOIN dwtparada.dwTArea dwtarea");

        q.append("WHERE dwconsolid.tpId = :tpid");

        if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO)) {
            // data
            if (dtInicial != null) {
                q.append("AND dwconsolid.dtReferencia between :dtinicial and :dtfinal");
            }

            // turno
            if (idTurno != null && idTurno.equals(BigDecimal.ZERO) == false) {
                q.append("AND dwconsolid.dwTurno.idTurno = :idturno");
            } else {
            	//Alex 24/05/2017 #3023 item 1
            	q.append("AND dwconsolid.dwTurno.idTurno <> 1");
            }
        }

        if (!tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP)) {
            // máquina
            if (!cdPt.equals("") && !cdPt.equals(null)) {
                q.append("AND dwconsolid.omPt.cdPt = :cdpt");
            }
        }

        // op
        if (!cdCp.equals("") && !cdCp.equals(null)) {
            q.append("AND dwconsolid.ppCp.cdCp = :cdcp");
        }

        // paradas
        if (isComPeso == true && isSemPeso == false) {
            q.append("AND dwtparada.isPesa = :ispesa");
        } else if (isComPeso == false && isSemPeso == true) {
            q.append("AND dwtparada.isPesa = :ispesa");
        }

        q.append("GROUP BY dwtarea.cdArea, dwtarea.dsArea");

        // definicao de parâmetros

        if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO)) {
            // data
            if (dtInicial != null) {
                q.defineParametroData("dtinicial", dtInicial);
                q.defineParametroData("dtfinal", dtFinal);
            }

            // turno
            if (idTurno != null && idTurno.equals(BigDecimal.ZERO) == false) {
                q.defineParametro("idturno", idTurno.longValue());
            }
        }

        if (!tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP)) {
            // máquina
            if (!cdPt.equals("") && !cdPt.equals(null)) {
                q.defineParametro("cdpt", cdPt);
            }
        }


        // parada
        if (isComPeso == true && isSemPeso == false) {
            q.defineParametro("ispesa", true);
        } else if (isComPeso == false && isSemPeso == true) {
            q.defineParametro("ispesa", false);
        }
        
        // op
        if (!cdCp.equals("") && !cdCp.equals(null)) {
            q.defineParametro("cdcp", cdCp);
        }
        if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_ACUMULADO)
                || tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP))
            q.defineParametro("tpid", DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_ACUMULADO);
        else
            q.defineParametro("tpid", DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO);

        List<Object> lista = q.list();

        retorno = new GraficoAreaRespParadaDTO();
        retorno.setListaAreasRespParada(new ArrayList<AreaRespParadaDTO>());

        for (Object reg : lista) {

            Object[] registro = (Object[]) reg;
            String cdArea = (String) registro[_cdArea];
            String dsArea = (String) registro[_dsArea];
            BigDecimal segAutoTempoparadaCp = (registro[_segAutoTempoparadaCp] != null ? (BigDecimal) registro[_segAutoTempoparadaCp] : BigDecimal.ZERO);
            BigDecimal segAutoTempoparadaSp = (registro[_segAutoTempoparadaSp] != null ? (BigDecimal) registro[_segAutoTempoparadaSp] : BigDecimal.ZERO);
            
            //Alex 20/03/2017
            BigDecimal segTempoArea = BigDecimal.ZERO;
            segTempoArea = segTempoArea.add(segAutoTempoparadaCp);
            segTempoArea = segTempoArea.add(segAutoTempoparadaSp);

            if (segTempoArea.doubleValue() > 0) {
	            // inclui info da área
	            areaResp = new AreaRespParadaDTO();
	            areaResp.setCdAreaResp(cdArea);
	            areaResp.setDsAreaResp(dsArea);
	            areaResp.setSegTempoParada(segTempoArea.doubleValue());
	            areaResp.setTempoParada(DataHoraRN.formatSegundosParaHHMMSS(areaResp.getSegTempoParada().intValue()));
	
	            retorno.getListaAreasRespParada().add(areaResp);
	            
	            tempoTotalParadas = AritmeticaUtil.somar(tempoTotalParadas, segTempoArea);
            }
        }        
        
        // calcula perc de cada area
        for (AreaRespParadaDTO area : retorno.getListaAreasRespParada()) {
        	BigDecimal perc = AritmeticaUtil.calcularPorcentagem(new BigDecimal(area.getSegTempoParada()), tempoTotalParadas).setScale(2, RoundingMode.HALF_UP);
        	area.setPercAreaResp(perc.doubleValue());        	
        }
        
        
        /* Alessandre em 01-03-17 para solucionar o chamado 3351
         * Pegar a parada em aberto para acrescentar no retorno
         * 
         */
        
        /*
         *  Marcos Sardinha: 2017-07-21 >> verificacao de parada em aberto falhaava qdo filtro era OP (cp vinha com string nula e dava erro em getDwConsolpaEmAberto)
         *  Necessario montar map com pts da OP
         */
        
        Map <String, String> mapCdPts = new HashMap<String, String>();
        if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP)  && !cdCp.equals("") && !cdCp.equals(null)) {
            MapQuery qCps = new MapQuery(getDaoSession());
            qCps.append("SELECT a.omPt.cdPt");
            qCps.append("  FROM PpCp a");
            qCps.append(" WHERE a.cdCp = :cdcp");
            qCps.defineParametro("cdcp", cdCp);
            List<String> listaCps = qCps.list();
            for (String regCdPt : listaCps) {
                mapCdPts.put(regCdPt, regCdPt);
            }            
            
        } else {
        	mapCdPts.put(cdPt, cdPt);
        }

        return retorno;

    }


    public GraficosParettoParadaDTO getGraficoParettoParadaBIDTO(FiltroDetalhePTInjetDTO filtro, Boolean isComPeso, Boolean isSemPeso, BigDecimal totalParadas) {
        Double qtdPerdasParadaTOTAL = 0d;

        final int _idConsolpa = 0;
        final int _idTparada = 1;
        final int _cdTparada = 2;
        final int _dsTparada = 3;
        final int _ispesa = 4;

        final int _idTarea = 5;
        final int _cdTarea = 6;
        final int _dsTarea = 7;

        final int _segAutoTempoparadaCp = 8;
        final int _segAutoTempoparadaSp = 9;

        final int _pcsAutoPerdaparadaCp = 10;
        final int _pcsAutoPerdaparadaSp = 11;

        Date menorDthrInicioParada = null;
        Date maiorDthrFimParada = null;

        HashMap<Long, GraficoParettoParadaDTO> mapParadas = new HashMap<Long, GraficoParettoParadaDTO>();
        HashMap<Long, List<OcorrenciasEvtDTO>> mapOcorrenciasPorParada = new HashMap<Long, List<OcorrenciasEvtDTO>>();
        HashMap<Long, List<DwConsolpaoco>> mapOcorrenciasPorParadaAberta = new HashMap<Long, List<DwConsolpaoco>>();        
        HashMap<Long, BigDecimal> mapIndicePorParada = new HashMap<Long, BigDecimal>();

        List<Object> listaParadasFechadas = consultaParadasFechadas(filtro, isComPeso, isSemPeso);

        // Calcular o tempo de parada ou quantidade perdida para se calcular o indice de parada
        // nao � possivel usar mais a variavel recebida totalParada, pois o grafico pode conter apenas algumas paradas e o totalParada � o
        // tempo
        // de todas as paradas, mesmo as n�o filtradas, gerando um indice de parada errado;
        // Alem disso o indice as vezes devera considerar a quantidade perdida ao inves do tempo
        totalParadas = BigDecimal.ZERO;
        for (Object reg : listaParadasFechadas) {
            Object[] registro = (Object[]) reg;
            BigDecimal segAutoTempoparadaCp = (BigDecimal) registro[_segAutoTempoparadaCp];
            BigDecimal segAutoTempoparadaSp = (BigDecimal) registro[_segAutoTempoparadaSp];
            
            if (segAutoTempoparadaCp != null)
                totalParadas = totalParadas.add(segAutoTempoparadaCp);

            if (segAutoTempoparadaSp != null)
                totalParadas = totalParadas.add(segAutoTempoparadaSp);

        }

        Boolean isProcessouParadaAberta = false;
        
        for (Object reg : listaParadasFechadas) {

            Object[] registro = (Object[]) reg;
            Long idConsolpa = (Long) registro[_idConsolpa];
            Long idTparada = (Long) registro[_idTparada];
            String cdParada = (String) registro[_cdTparada];
            String dsParada = (String) registro[_dsTparada];

            Long idTarea = (Long) registro[_idTarea];
            String cdArea = (String) registro[_cdTarea];
            String dsArea = (String) registro[_dsTarea];
            
            Boolean isPesa = (Boolean) registro[_ispesa];
            BigDecimal segAutoTempoparadaCp = (BigDecimal) registro[_segAutoTempoparadaCp];
            BigDecimal segAutoTempoparadaSp = (BigDecimal) registro[_segAutoTempoparadaSp];
            BigDecimal pcsAutoPerdaparadaCp = (BigDecimal) registro[_pcsAutoPerdaparadaCp];
            BigDecimal pcsAutoPerdaparadaSp = (BigDecimal) registro[_pcsAutoPerdaparadaSp];

            if (pcsAutoPerdaparadaCp ==  null){
                pcsAutoPerdaparadaCp = BigDecimal.ZERO;
            }

            if (pcsAutoPerdaparadaSp ==  null){
                pcsAutoPerdaparadaSp = BigDecimal.ZERO;
            }

            GraficoParettoParadaDTO paradaGraf = mapParadas.get(idTparada);
            

            if (paradaGraf == null) {
                // parada
                paradaGraf = new GraficoParettoParadaDTO();
                paradaGraf.setIdTParada(idTparada);
                paradaGraf.setCdParada(cdParada);
                paradaGraf.setIdTArea(idTarea);
                paradaGraf.setCdArea(cdArea);
                paradaGraf.setDsArea(dsArea);

                if (isPesa) {
                    paradaGraf.setDsParada(dsParada.toUpperCase());
                } else {
                    paradaGraf.setDsParada(dsParada.toLowerCase());
                }

                BigDecimal tempoParadas = BigDecimal.ZERO;

                if (segAutoTempoparadaCp != null)
                    tempoParadas = segAutoTempoparadaCp;

                if (segAutoTempoparadaSp != null) {
                    if (tempoParadas.doubleValue() == 0)
                        tempoParadas = segAutoTempoparadaSp;
                    else
                        tempoParadas = tempoParadas.add(segAutoTempoparadaSp);
                }
                if (tempoParadas.doubleValue() <= 0) {
                    continue;
                }

                // ARMAZENA O TEMPO PARADAS DE ACORDO COM CD PARADA
                BigDecimal tempoPar = mapIndicePorParada.get(idTparada);
                if (tempoPar == null) {
                    tempoPar = tempoParadas;
                    mapIndicePorParada.put(idTparada, tempoPar);
                }

                double indiceParada = FormulasInjet.calcularIndiceParada(tempoParadas, totalParadas);
                
                paradaGraf.setIndiceParada(indiceParada);

                String tempoParadasF = DataHoraRN.formatMilisegundosParaHHMMSSmmm(tempoParadas.multiply(new BigDecimal(1000)).longValue());
                paradaGraf.setTempoFormatado(tempoParadasF);
                paradaGraf.setTempo(tempoParadas.doubleValue());
                paradaGraf.setQtdPerdasParada(pcsAutoPerdaparadaCp.doubleValue());
                
                List<DwConsolpaoco> listaOcorrencias = getDwConsolpas(idConsolpa);
                // Se o idConsolpa for zero eh pq eh uma parada em aberto. Assim ireimos criar uma oco ficticia

                if ( (idConsolpa.equals(0l) && isProcessouParadaAberta == false)) {
                    isProcessouParadaAberta = true;
                    
                    Set<Long> cdsParadasAbertas = mapOcorrenciasPorParadaAberta.keySet();
                    for (Long cdParadaAberta : cdsParadasAbertas) {
                        for(DwConsolpaoco ocor : mapOcorrenciasPorParadaAberta.get(cdParadaAberta)){
                            listaOcorrencias.add(ocor);                            
                        }
                    }
                }

                qtdPerdasParadaTOTAL = qtdPerdasParadaTOTAL + pcsAutoPerdaparadaCp.doubleValue();

                
                // SARDINHA: varre lista de ocorrencias e calcula as perdas por parada (necessário na ficha da máquina padr�o Injet)
                for (DwConsolpaoco ocorrencia : listaOcorrencias) {
                	/* Alessandre em 3-3-17. Se a ocorrencia nao tiver data de fim esta inconsistente
                	 * 
                	 */
                	if (ocorrencia.getDthrFparada() == null)
                		continue;
                	
                    // PEGA MAIOR DATA E MENOR DATA DE TODAS AS OCORRENCIAS DE PARADAS DA CONSULTA
                    menorDthrInicioParada = getMenorDthrInicioParada(ocorrencia.getDthrIparada(), menorDthrInicioParada);
                    Date dtf = ocorrencia.getDthrFparada();
                    if (dtf == null)
                        dtf = ocorrencia.getDwConsolpa().getDwConsol().getDwConsolid().getDthrFturno();
                    if (DataHoraRN.after(dtf, DataHoraRN.getDataHoraAtual()))
                        dtf = DataHoraRN.getDataHoraAtual();
                    maiorDthrFimParada = getMaiorDthrFimParada(dtf, maiorDthrFimParada);

                    List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorParada.get(idTparada);
                    if (listaOcoDTO == null) {
                        listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
                        OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
                        ocoDTO.setIdEvt(idTparada); // verificar
                        ocoDTO.setDthrIni(ocorrencia.getDthrIparada());
                        ocoDTO.setDthrFim(ocorrencia.getDthrFparada());

                        int duracaoEvt = DataHoraRN
                                .getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());
                        ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
                        ocoDTO.setMsDtHrIni(ocorrencia.getMsDthriparada());
                        ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrfparada());

                        listaOcoDTO.add(ocoDTO);
                        mapOcorrenciasPorParada.put(idTparada, listaOcoDTO);

                    } else {
                        OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
                        ocoDTO.setIdEvt(idTparada); // veririficar
                        ocoDTO.setDthrIni(ocorrencia.getDthrIparada());
                        ocoDTO.setDthrFim(ocorrencia.getDthrFparada());

                        int duracaoEvt = DataHoraRN
                                .getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());

                        ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
                        ocoDTO.setMsDtHrIni(ocorrencia.getMsDthriparada());
                        ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrfparada());

                        listaOcoDTO.add(ocoDTO);
                        mapOcorrenciasPorParada.put(idTparada, listaOcoDTO);
                    }
                }
                mapParadas.put(idTparada, paradaGraf);

            } else {                
                qtdPerdasParadaTOTAL = qtdPerdasParadaTOTAL + pcsAutoPerdaparadaCp.doubleValue();
                
                BigDecimal tempoParadas = BigDecimal.ZERO;

                if (segAutoTempoparadaCp != null)
                    tempoParadas = segAutoTempoparadaCp;

                if (segAutoTempoparadaSp != null) {
                    if (tempoParadas.doubleValue() == 0)
                        tempoParadas = segAutoTempoparadaSp;
                    else
                        tempoParadas = tempoParadas.add(segAutoTempoparadaSp);
                }

                
                if (tempoParadas.doubleValue() <= 0) {
                    continue;
                }

                // ARMAZENA O TEMPO PARADAS DE ACORDO COM CD PARADA
                BigDecimal tempoPar = mapIndicePorParada.get(idTparada);
                if (tempoPar != null) {
                    tempoPar = tempoPar.add(tempoParadas);
                    mapIndicePorParada.put(idTparada, tempoPar);
                } else {
                	tempoPar = tempoParadas;
                }

                double indiceParada = FormulasInjet.calcularIndiceParada(tempoPar, totalParadas);
                mapParadas.get(idTparada).setIndiceParada(indiceParada);

                String tempoParadasF = DataHoraRN.formatSegundosParaHHMMSS(tempoPar.intValue());
                mapParadas.get(idTparada).setTempoFormatado(tempoParadasF);
                mapParadas.get(idTparada).setTempo(tempoPar.doubleValue());
                mapParadas.get(idTparada).setQtdPerdasParada(mapParadas.get(idTparada).getQtdPerdasParada() + pcsAutoPerdaparadaCp.doubleValue());

                List<DwConsolpaoco> listaOcorrencias = getDwConsolpas(idConsolpa);

                for (DwConsolpaoco ocorrencia : listaOcorrencias) {
                    // PEGA MAIOR DATA E MENOR DATA DE TODAS AS OCORRENCIAS DE PARADAS DA CONSULTA
                    menorDthrInicioParada = getMenorDthrInicioParada(ocorrencia.getDthrIparada(), menorDthrInicioParada);
                    maiorDthrFimParada = getMaiorDthrFimParada(ocorrencia.getDthrFparada(), maiorDthrFimParada);

                    List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorParada.get(idTparada);
                    if (listaOcoDTO != null) {
                        OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
                        ocoDTO.setIdEvt(idTparada);
                        ocoDTO.setDthrIni(ocorrencia.getDthrIparada());
                        ocoDTO.setDthrFim(ocorrencia.getDthrFparada());

                        int duracaoEvt = DataHoraRN
                                .getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());

                        ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
                        ocoDTO.setMsDtHrIni(ocorrencia.getMsDthriparada());
                        ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrfparada());

                        listaOcoDTO.add(ocoDTO);
                    }
                }
            }

        }

        // Ainda falta calcular o índice de paradas baseado na quantidade de perdas por parada (o total geral de perdas nesta condi��oo é
        // calculado nesta rotina, nao vem como parâmetro

        // Areas resp
        GraficoParetoParadaAreaRespDTO areaGraf = new GraficoParetoParadaAreaRespDTO();
        HashMap<String, GraficoParetoParadaAreaRespDTO> mapAreaResp = new HashMap<String, GraficoParetoParadaAreaRespDTO>();

        Set<Long> cdsParadas = mapParadas.keySet();
        BigDecimal totalPerdaParada = BigDecimal.ZERO;
        for (Long cdParada : cdsParadas) {
            GraficoParettoParadaDTO paradaGraf = mapParadas.get(cdParada);
            totalPerdaParada = totalPerdaParada.add(new BigDecimal(paradaGraf.getQtdPerdasParada()));

            // Areas resp -- identificar e acumular
            areaGraf = mapAreaResp.get(paradaGraf.getCdArea());

            if (areaGraf == null) {
                areaGraf = new GraficoParetoParadaAreaRespDTO();
                areaGraf.setAreaResp(new DwTArea());

                //Marcos Sardinha: 2017-01-31 - tratamento para parada sem area (problema verificado na Sony)
                DwTArea areaResp = new DwTArea();
                if (paradaGraf.getIdTArea() != null) {
                    areaResp.setIdArea(paradaGraf.getIdTArea());
                    areaResp.setCdArea(paradaGraf.getCdArea());
                    areaResp.setDsArea(paradaGraf.getDsArea());
    
                    areaGraf.setAreaResp(areaResp);
                    areaGraf.setTempoParada(paradaGraf.getTempo());
                    areaGraf.setQtdPerdasParada(paradaGraf.getQtdPerdasParada());
                    areaGraf.getParadas().add(paradaGraf);
    
                    mapAreaResp.put(paradaGraf.getCdArea(), areaGraf);
                }
            } else {
                // acumula
                areaGraf.setTempoParada(areaGraf.getTempoParada() + paradaGraf.getTempo());
                areaGraf.setQtdPerdasParada(areaGraf.getQtdPerdasParada() + paradaGraf.getQtdPerdasParada());
                areaGraf.getParadas().add(paradaGraf);

                mapAreaResp.put(areaGraf.getAreaResp().getCdArea(), areaGraf);
            }

        }

        for (Long cdParada : cdsParadas) {
            GraficoParettoParadaDTO paradaGraf = mapParadas.get(cdParada);
            paradaGraf.setIndiceParadaQtdPerdasPar(FormulasInjet.calcularIndiceParada(new BigDecimal(paradaGraf.getQtdPerdasParada()),
                    totalPerdaParada).doubleValue());
        }

        // Area resp - calcular ind parada por area
        Set<String> cdsAreas = mapAreaResp.keySet();
        for (String cdArea : cdsAreas) {
            GraficoParetoParadaAreaRespDTO areaParGraf = mapAreaResp.get(cdArea);
            areaParGraf.setIndiceArea((FormulasInjet.calcularIndiceParada(new BigDecimal(areaParGraf.getQtdPerdasParada()),
                    totalPerdaParada).doubleValue()));
        }

        GrafTendenciaUtils algoritmoGraf = null;

        // MONTA O GRAFICO - NESTE MOMENTO É DEFINIDO O INTERVALO DE CORES
        if (menorDthrInicioParada != null && maiorDthrFimParada != null) {
            algoritmoGraf = new GrafTendenciaUtils(menorDthrInicioParada, maiorDthrFimParada);
        }

        GraficosParettoParadaDTO retorno = new GraficosParettoParadaDTO();
        if (algoritmoGraf != null) {
            defineCoresLegendaEBarra(algoritmoGraf, retorno, mapParadas, mapOcorrenciasPorParada);
        }

        // area resp - atribuir a retorno
        retorno.setAreas(new ArrayList<GraficoParetoParadaAreaRespDTO>());
        for (String cdArea : cdsAreas) {
            GraficoParetoParadaAreaRespDTO areaParGraf = mapAreaResp.get(cdArea);
            retorno.getAreas().add(areaParGraf);
        }

        return retorno;

    }

    private FiltroDetalhePTInjetDTO filtroBItoFiltroDetalhePt(BiFiltroDTO filtroBI)  {
    	FiltroDetalhePTInjetDTO filtro = new FiltroDetalhePTInjetDTO();
    	
    	// --------- filtros relacionados a PT ------------------- //
    	// gt
    	if (filtroBI.getCdGt() != null && !filtroBI.getCdGt().equals("")) {
    		GTRN rnGt = new GTRN();
    		rnGt.setDao(getDao());
    		filtro.setOmGt(rnGt.getOmGtByCdGt(filtroBI.getCdGt()));
    		rnGt = null;
    	}
    	
    	// pt
    	if (filtroBI.getCdPt() != null && !filtroBI.getCdPt().equals("")) {
    		PTRN rnPt = new PTRN(getDao());
    		try {
				filtro.setOmPt(rnPt.getOmPt(filtroBI.getCdPt()));
			} catch (RegistroDesconhecidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		rnPt = null;
    	}
    	
    	// classe
    	if (filtroBI.getCdClasseMaquina() != null && !filtroBI.getCdClasseMaquina().equals("")) {
    		filtro.setTpClasseABCpt((byte)  (filtroBI.getCdClasseMaquina().equals("A") ? 0 : filtroBI.getCdClasseMaquina().equals("B") ? 1 : 2));
    	}
    	
    	// --------- filtros relacionados a ferramenta  ------------------- //
    	// grupo rap/ferramenta
    	if (filtroBI.getCdGrpRap() != null && !filtroBI.getCdGrpRap().equals("")) {
    		filtro.setCdGrupoFerramenta(filtroBI.getCdGrpRap());
    	}
    	
    	// ferramenta
    	if (filtroBI.getCdRap() != null && !filtroBI.getCdRap().equals("")) {
    		DwRapRN rnRap = new DwRapRN(getDao());
    		filtro.setDwRap(rnRap.getDwRapPorCodigo(filtroBI.getCdRap(), getDao()));
    		rnRap = null;
    	}
    	
    	// --------- filtros relacionados a produto  ------------------- //
    	// produto
    	if (filtroBI.getCdProduto() != null && !filtroBI.getCdProduto().equals("")) {
    		ProdutoRN rnPro = new ProdutoRN(getDao());
    		try {
				filtro.setOmProduto(rnPro.getOmProduto(filtroBI.getCdProduto()));
			} catch (RegistroDesconhecidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		rnPro = null;
    	}
    	
    	
    	
    	// --------- filtros relacionados a periodo  ------------------- //
    	// perioodo
    	if (! filtroBI.getDtIni().equals("")) {
        	filtro.setDtReferenciaInicial(filtroBI.getDtIniDt());
        	filtro.setDtReferenciaFinal(filtroBI.getDtFimDt());
    	}
    	

    	if (! filtroBI.getAnoIni().equals("")) {
        	filtro.setAnoInicial(ConversaoTipos.converterParaBigDecimal(filtroBI.getAnoIni()).intValue());
        	filtro.setMesInicial(ConversaoTipos.converterParaBigDecimal(filtroBI.getMesIni()).intValue());
        	filtro.setAnoFinal(ConversaoTipos.converterParaBigDecimal(filtroBI.getAnoFim()).intValue());
        	filtro.setMesFinal(ConversaoTipos.converterParaBigDecimal(filtroBI.getMesFim()).intValue());    		
    	}
    	
    	
    	
    	// turno
    	if (filtroBI.getCdTurno() != null && !filtroBI.getCdTurno().equals("")) {
    		TurnoRN rnTur = new TurnoRN(getDao());
    		filtro.setDwTurno(rnTur.getDwTurnoPorCodigo(filtroBI.getCdTurno()));
    		rnTur = null;
    	}
    	
    	
    	// --------- filtros relacionados a area resp   ------------------- //     	
    	if (filtroBI.getFiltroBIParetoParada().getCdAreaResp() != null && !filtroBI.getFiltroBIParetoParada().getCdAreaResp().equals("")) {
    		AreaRN rnAR = new AreaRN(getDao());
    		filtro.setDwtarea(rnAR.getTArea(filtroBI.getFiltroBIParetoParada().getCdAreaResp()));
    		rnAR = null;
    	}    		
    	
    	// tipo de consolidacao
    	filtro.setTpId(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO);
    	
    	
    	return filtro;
    }

	private List<Object> consultaParadasFechadas(FiltroDetalhePTInjetDTO filtro, Boolean isComPeso, Boolean isSemPeso) {
		MapQuery q = new MapQuery(getDaoSession());
		
		
		//sub query com lista de idconsolpa
		q.append("SELECT DISTINCT dwconsolpa.idConsolpa");	
        q.append("FROM DwConsolpa dwconsolpa");
        q.append("JOIN dwconsolpa.dwConsol dwconsol");
        q.append("JOIN dwconsol.dwConsolid dwconsolid");
        q.append("join dwconsolid.omPt ompt");
        q.append("JOIN dwconsolpa.dwTParada dwtparada");
        q.append("LEFT JOIN dwtparada.dwTArea dwtarea");
        q.append("LEFT JOIN dwconsolid.ppCp ppcp");

        q.append("LEFT JOIN ppcp.ppCpprodutos ppcpprodutos");
        
        if ((filtro.getCdProdutoPai() != null ) ||  (filtro.getOmProduto() != null && filtro.getOmProduto().getCdProduto() != null && filtro.getOmProduto().getCdProduto().equals("") == false) || (filtro.getCdGrupoFerramenta() != null || filtro.getDwRap() != null)) {
            q.append("LEFT JOIN dwconsolid.dwFolha dwfolha");
        }

        if (filtro.getOmProduto() != null && filtro.getOmProduto().getCdProduto() != null && filtro.getOmProduto().getCdProduto().equals("") == false) {
            q.append("LEFT JOIN dwfolha.dwFolhaiacs dwfolhaiac");
            q.append("LEFT JOIN dwfolhaiac.omProduto omprodutoiac");
        }

        if ((filtro.getCdProdutoPai() != null ) || (filtro.getOmProduto() != null && filtro.getOmProduto().getCdProduto() != null && filtro.getOmProduto().getCdProduto().equals("") == false) || (filtro.getCdGrupoFerramenta() != null || filtro.getDwRap() != null)) {
            q.append("LEFT JOIN dwfolha.dwFolharaps dwfolharap");
            q.append("LEFT JOIN dwfolharap.dwFolharapcoms dwfolharapcom");

            if (filtro.getCdGrupoFerramenta() != null) {
                q.append("LEFT JOIN dwfolharap.dwRap.dwRapGrupos grpmol");
            }
        }

        
        if (filtro.getCdProdutoPai() != null || (filtro.getOmProduto() != null && filtro.getOmProduto().getCdProduto() != null && filtro.getOmProduto().getCdProduto().equals("") == false)) {
            q.append("LEFT JOIN dwfolharapcom.omProduto omprodutorap");
            q.append("LEFT JOIN dwconsol.dwConsolprs dwConsolprs");
            q.append("LEFT JOIN dwConsolprs.omProduto omproduto ");
            q.append("LEFT JOIN omproduto.omProcomestsForIdProdutomp profilho");
            q.append("LEFT JOIN profilho.omProdutoByIdProduto propai");
        }

        q.appendWhere(MapQuery._NULL, "dwconsolid.tpId = :tpId and dwconsolid.stAtivo is null ", true);

        /* 
         * Marcos Sardinha: 2017-02-03 - teste abaixo necessario por causa do grafico de produtos fabricados no turno.
         * Este grafico deve levar em consideracao somente a ultima op da maquina
         */
        if (filtro.getFiltroOp() != null &&  filtro.getFiltroOp() == 0 && filtro.getCdCp() ==  null) {
            String clausulaUltimaOP = "dwconsolid.dthrFconsol = (SELECT MAX(a.dthrFconsol) "
                    + " FROM DwConsolid a " 
                    + " WHERE a.tpId = dwconsolid.tpId "
                    + "   AND a.stAtivo IS NULL "
                    + "   AND a.dwTurno.idTurno = dwconsolid.dwTurno.idTurno "
                    + "   AND a.omPt.idPt = dwconsolid.omPt.idPt " 
                    + "   AND a.dtReferencia =  dwconsolid.dtReferencia " 
                    + "   AND a.dthrFconsol IS NOT NULL)";
            q.appendWhere(MapQuery._AND, clausulaUltimaOP, true);                     
        } else {        
            if (filtro.getCdCp() != null && filtro.getFiltroOp() == 4) {
                q.appendWhere(MapQuery._AND, "ppcpprodutos.nrDoc = :nrop", filtro.getCdCp() != null && filtro.getCdCp().equals("") == false
                        && filtro.getFiltroOp() != null && filtro.getFiltroOp() == 4);
            }
        }
        
        
        /*
         * o filtroOP pode assumir os seguintes valores 0 = ultima OP 1 = todas as ops Se o filtroOP for igual a zero, entao utilizar a ppCP
         * que estïver no filtro
         */
        q.appendWhere(MapQuery._AND, "dwconsolid.ppCp.cdCp = :nrop", filtro.getCdCp() != null && filtro.getCdCp().equals("") == false && filtro.getFiltroOp() != null && (filtro.getFiltroOp() == 0 || filtro.getFiltroOp() == 3));

        // pt
        q.appendWhere(MapQuery._AND, "ompt.cdPt = :ompt and ompt.stAtivo = 1", filtro.getOmPt() != null);

        // classfiicacao ABC pt

        // Marcos Sardinha: 2017-02-03 - se pt sem classe abc, considerar classe C (2)
        // Avalia se o filtro de classificacao ABC para o posto foi definido, se sim, incluir o filtro
        if (filtro.getTpClasseABCpt() != null) {
            if (filtro.getTpClasseABCpt() == 2) {
                q.appendWhere(MapQuery._AND, "(ompt.tpClasseabc = :tpabcpt OR ompt.tpClasseabc IS NULL)", filtro.getTpClasseABCpt() != null);
            } else {
                q.appendWhere(MapQuery._AND, "ompt.tpClasseabc = :tpabcpt", filtro.getTpClasseABCpt() != null);
            }
        }
        
        
        
        // gt
        q.appendWhere(
                MapQuery._AND,
                "exists (select ompt from OmPt ompt join ompt.omObjs omobj where omobj.omGtByIdGt.idGt = :idGt and ompt = dwconsolid.omPt)",
                filtro.getOmGt() != null && filtro.getOmPt() == null);
        q.appendWhere(MapQuery._AND, "ppcpprodutos.omProduto.idProduto = :idProduto", filtro.getOmProduto() != null && filtro.getOmProduto().getIdProduto() > 0);

        // classificacao ABC produto
        q.appendWhere(MapQuery._AND, "ppcpprodutos.omProduto.tpClasseabc = :tpclasseproduto", filtro.getTpClasseABCproduto() != null);

        // Se for acumulado ou OP nao filtrar o turno indefinido
        if (filtro.getTpId() != null) {
            if (filtro.getTpId().equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP) == false) {
                q.appendWhere(MapQuery._AND, "dwconsolid.dwTurno.idTurno <> 1", filtro.getDwTurno() == null);
            }
        }

        // periodo e turno
        if (filtro.getTpId() == null || filtro.getTpId().equals(DwConsolidTemplate.TpId.ACUMULADO.getValue()) == false) {
            q.appendWhere(MapQuery._AND, "dwconsolid.dtReferencia = :data", filtro.getDtReferencia() != null && filtro.getAnoInicial() == null);
            q.appendWhere(MapQuery._AND, "dwconsolid.dwTurno.idTurno = :idTurno", filtro.getDwTurno() != null);
            q.appendWhere(MapQuery._AND, "dwconsolid.dtReferencia between :dti and :dtf", filtro.getDtReferenciaInicial() != null && filtro.getDtReferenciaFinal() != null);
            
            //Alex 30/06/2017 #3949
            q.appendWhere(MapQuery._AND, "dwconsolid.dthrIhora >= :dthi and dwconsolid.dthrFhora <= :dthf", filtro.getDthrIhora() != null && filtro.getDthrFhora() != null);
            
            q.appendWhere(MapQuery._AND, "((dwconsolid.ano * 1000) + dwconsolid.mes)	between :ami AND :amf", filtro.getAnoInicial() != null && filtro.getAnoInicial() > 0);
           
        }

        // produto
        q.appendWhere(MapQuery._AND,
                "( omprodutoiac.cdProduto = :cdproduto or omprodutorap.cdProduto = :cdproduto or omproduto.cdProduto = :cdproduto ) ",
                filtro.getOmProduto() != null && filtro.getOmProduto().getCdProduto() != null && filtro.getOmProduto().getCdProduto().equals("") == false);

        // folha
        q.appendWhere(MapQuery._AND, "dwfolharap.dwRap.cdRap = :cdmol", (filtro.getDwRap() != null));
        q.appendWhere(MapQuery._AND, "grpmol.dwGrupoFerramenta.cdGrupoFerramenta = :cdgrpmol", (filtro.getCdGrupoFerramenta() != null));
        q.appendWhere(MapQuery._AND, "propai.cdProduto = :cdProdutoPai", (filtro.getCdProdutoPai() != null));
        
        // paradas
        if (isComPeso == true && isSemPeso == false) {
            q.append("AND dwtparada.isPesa = :ispesa");
        } else if (isComPeso == false && isSemPeso == true) {
            q.append("AND dwtparada.isPesa = :ispesa");
        }

        // area rsp
        if (filtro.getDwtarea() != null && !filtro.getDwtarea().getCdArea().equals("") && !filtro.getDwtarea().getCdArea().equals(null)) {
            q.append("AND dwtarea.cdArea = :cdarearesp");
        }

        //Marcos Sardinha 2017-07-04: Defeito #4061
        if (filtro.getIdDwConsolId() != 0) {
        	q.appendWhere(MapQuery._AND, "dwconsolid.idConsolid = :idConsolid", true);
        }
                
        
        // definicao de parametros
        q.defineParametro("idTurno", filtro.getDwTurno() != null ? filtro.getDwTurno().getIdTurno() : 0);

        
        if (filtro.getOmPt() != null && filtro.getOmPt().getCdPt() == null) {
            OmPt ompt = getDao().findById(OmPt.class, filtro.getOmPt().getIdPt(), false);
            filtro.getOmPt().setCdPt(ompt.getCdPt());
        }

        if (filtro.getOmPt() != null) {
            q.defineParametro("ompt", filtro.getOmPt().getCdPt());
        }

        // parada
        if (isComPeso == true && isSemPeso == false) {
            q.defineParametro("ispesa", true);
        } else if (isComPeso == false && isSemPeso == true) {
            q.defineParametro("ispesa", false);
        }

        q.defineParametro("idGt", filtro.getOmGt() != null ? filtro.getOmGt().getIdGt() : null);
        q.defineParametro("idProduto", filtro.getOmProduto() != null && filtro.getOmProduto().getIdProduto() > 0 ? filtro.getOmProduto().getIdProduto() : null);

        q.defineParametro("tpabcpt", filtro.getTpClasseABCpt());

        
        
        q.defineParametro("tpclasseproduto", filtro.getTpClasseABCproduto());

        q.defineParametro("cdproduto", filtro.getOmProduto() != null && filtro.getOmProduto().getCdProduto() != null && filtro.getOmProduto().getCdProduto().equals("") == false ? filtro.getOmProduto().getCdProduto() : null);
        q.defineParametroData("data", filtro.getDtReferencia() != null ? DataHoraRN.getDataSemHora(filtro.getDtReferencia()) : null);

        q.defineParametroData("dti", filtro.getDtReferenciaInicial() != null ? DataHoraRN.getDataSemHora(filtro.getDtReferenciaInicial()) : null);
        q.defineParametroData("dtf", filtro.getDtReferenciaFinal() != null ? DataHoraRN.getDataSemHora(filtro.getDtReferenciaFinal()) : null);

        //Alex 30/06/2017 #3949
        q.defineParametroTimestamp("dthi", filtro.getDthrIhora());
        q.defineParametroTimestamp("dthf", filtro.getDthrFhora());
        
        if (filtro.getTpId() == null) {
            filtro.setTpId(DwConsolidTemplate.TpId.TURNO.getValue());
        }

        // TODO alterar esse trecho
        // mudei o periodo de consolidacao pra TURNO pois ainda nao
        // existe registros para ACUMULADO
        if (filtro.getTpId().equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP)) {
            q.defineParametro("tpId", DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_ACUMULADO);
        } else if (filtro.getTpId() == DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_MES) {
            q.defineParametro("tpId", DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO);
        } else {
            q.defineParametro("tpId", filtro.getTpId());
        }

        // filtroOP que se for 0 (ver comentario anterior) passar a OP
        if (filtro.getCdCp() != null && filtro.getCdCp().equals("") == false) {
            q.defineParametro("nrop", filtro.getCdCp());
        }

        if (filtro.getAnoInicial() != null && filtro.getAnoInicial() > 0) {
            q.defineParametro("ami", (filtro.getAnoInicial() * 1000) + filtro.getMesInicial());
            q.defineParametro("amf", (filtro.getAnoFinal() * 1000) + filtro.getMesFinal());
        }

        if (filtro.getDwRap() != null) {
            q.defineParametro("cdmol", filtro.getDwRap().getCdRap());
        }

        if (filtro.getCdGrupoFerramenta() != null) {
            q.defineParametro("cdgrpmol", filtro.getCdGrupoFerramenta());
        }

        if (filtro.getCdProdutoPai() != null) {
            q.defineParametro("cdProdutoPai", filtro.getCdProdutoPai());
        }

        // area rsp
        if (filtro.getDwtarea() != null && !filtro.getDwtarea().getCdArea().equals("") && !filtro.getDwtarea().getCdArea().equals(null)) {
            q.defineParametro("cdarearesp",filtro.getDwtarea().getCdArea());
        }

        //Marcos Sardinha 2017-07-04: Defeito #4061
        if (filtro.getIdDwConsolId() != 0) {
        	q.defineParametro("idConsolid", filtro.getIdDwConsolId());
        }

        
        
        List<Object> listaParadasFechadas = q.list();

        String listaIds = listaParadasFechadas.toString();
        listaIds = listaIds.replace("[", "");
        listaIds = listaIds.replace("]", "");
        
        if (listaIds.trim().equals("")) {
            listaParadasFechadas = new ArrayList<Object>();        	
        } else {
            q = new MapQuery(getDaoSession());
    		
            q.append("SELECT ");
            q.append("dwconsolpa.idConsolpa,");
            q.append("dwtparada.idTparada,");
            q.append("dwtparada.cdTparada,");
            q.append("dwtparada.dsTparada,");
            q.append("dwtparada.isPesa,");
            q.append("dwtarea.idArea, dwtarea.cdArea, dwtarea.dsArea, ");
            q.append("SUM(dwconsolpa.segAutoTempoparadaCp),");
            q.append("SUM(dwconsolpa.segAutoTempoparadaSp),");
            q.append("SUM(dwconsolpa.pcsAutoPerdaparadaCp),");
            q.append("SUM(dwconsolpa.pcsAutoPerdaparadaSp)");
            q.append("FROM DwConsolpa dwconsolpa");
            q.append("JOIN dwconsolpa.dwTParada dwtparada");
            q.append("LEFT JOIN dwtparada.dwTArea dwtarea");
    		q.append("WHERE dwconsolpa.idConsolpa IN (" + listaIds + ")");
            q.append("GROUP BY dwconsolpa.idConsolpa, dwtparada.idTparada, dwtparada.cdTparada, dwtparada.dsTparada, dwtparada.isPesa, dwtarea.idArea, dwtarea.cdArea, dwtarea.dsArea");
    		        
            listaParadasFechadas = q.list();
        }
        
		return listaParadasFechadas;
	}
	
	
    

    /*
     * Metodo principal para gerar o grafico de parada no detalhe da maquina
     */
    public GraficosParettoParadaDTO getGraficoParettoParadaDTO(Date dtReferencia, BigDecimal idTurno, BigDecimal idPt, Boolean isComPeso,
            Boolean isSemPeso, BigDecimal totalParadasComPeso, String cdAreaResp, Boolean isConsiderarOP, String cdCp) {
        Double qtdPerdasParada = 0d;
        Double qtdPerdasParadaPARADA = 0d;
        Double qtdPerdasParadaTOTAL = 0d;
        Double cicloPadrao = 0d;
        Double qtPcsCicloAtivas = 0d;
        int duracaoOcorrenciaParada = 0;

        BigDecimal totalParadaSemPeso = BigDecimal.ZERO;
        BigDecimal totalParadaSoma = BigDecimal.ZERO; // vou usar essa variavel ao inves de totalParadaComPeso vinda como parametro. Assim
                                                      // ela tera as paradas com peso, sem peso e em aberto

        DwFolhacic dwFolhaCic;
        FolhaRN folhaRN = new FolhaRN(this.getDao());

        Date menorDthrInicioParada = null;
        Date maiorDthrFimParada = null;
        HashMap<Long, GraficoParettoParadaDTO> mapParadas = new HashMap<Long, GraficoParettoParadaDTO>();
        HashMap<Long, List<OcorrenciasEvtDTO>> mapOcorrenciasPorParada = new HashMap<Long, List<OcorrenciasEvtDTO>>();
        HashMap<Long, BigDecimal> mapIndicePorParada = new HashMap<Long, BigDecimal>();

        MapQuery q = new MapQuery(getDaoSession());
        MapQuery qSemParada = new MapQuery(getDaoSession());

        // Alessandre: em 01-09-15 comentei o trecho abaixo mudando a abordagem de consulta do consolpa para o consolid. Eh importante
        // consultar o consolid
        // pois no turno de referencia pode nao ter nenhuma parada aberta mas ter uma parada em aberto que comecou no turno anterior
        // e o inicio e fim do turno eh importante para poder filtrar corretamente essa parada
        /*
         * q.append("select distinct dwconsolpa"); q.append("from DwConsolpa dwconsolpa");
         * q.append("join fetch dwconsolpa.dwConsol dwconsol"); q.append("join fetch dwconsol.dwConsolid dwconsolid");
         * q.append("join dwconsolpa.dwTParada dwtparada");
         */
        StringBuilder trecho1 = new StringBuilder();
        StringBuilder trecho2 = new StringBuilder();
        StringBuilder trecho3 = new StringBuilder();

        trecho1.append("select distinct dwconsolid");
        trecho1.append(" from DwConsolid dwconsolid");
        trecho1.append(" join fetch dwconsolid.dwConsols dwconsol");
        trecho1.append(" left join fetch dwconsol.dwConsolpas dwconsolpa");
        trecho1.append(" left join fetch dwconsolpa.dwTParada dwtparada");

        if (!cdAreaResp.equals("")) {
            trecho1.append(" JOIN dwtparada.dwTArea dwtarea");
        }
        if (isConsiderarOP) {
            trecho1.append(" join dwconsolid.ppCp ppcp");
        }
        trecho1.append(" left join fetch dwconsolpa.dwConsolpaocos dwconsolpaoco");

        trecho1.append(" WHERE dwconsolid.dtReferencia = :dtreferencia");
        trecho1.append(" and dwconsolid.omPt.idPt = :idpt");
        trecho1.append(" and dwconsolid.dwTurno.idTurno = :idturno");
        trecho1.append(" and dwconsolid.tpId = :tpId");

        if (isComPeso == true && isSemPeso == false) {
            trecho2.append(" AND dwtparada.isPesa = :ispesa");
        } else if (isComPeso == false && isSemPeso == true) {
            trecho2.append(" AND dwtparada.isPesa = :ispesa");
        }

        if (!cdAreaResp.equals("")) {
            trecho3.append(" AND dwtarea.cdArea = :cdarearesp");
        }

        if (isConsiderarOP) {
            trecho3.append(" and ppcp.cdCp = :cdcp");
        }

        q.append(trecho1.toString());
        q.append(trecho3.toString());

        q.defineParametro("dtreferencia", dtReferencia);
        q.defineParametro("idpt", idPt.longValue());
        q.defineParametro("idturno", idTurno.longValue());
        q.defineParametro("tpId", (byte) 1);
        q.defineParametro("cdarearesp", cdAreaResp);
        q.defineParametro("cdcp", cdCp);

        if (isComPeso == true && isSemPeso == false) {
            q.defineParametro("ispesa", true);
        } else if (isComPeso == false && isSemPeso == true) {
            q.defineParametro("ispesa", false);
        }

        List<DwConsolid> consolidsSemFiltroParada = q.list();
        

        List<DwConsolpa> todosConsolpa = new ArrayList<DwConsolpa>();

        // Pesquisar novamente considerando se existe o filtro de parada
        List<DwConsolid> consolids;
        if (trecho2.toString().trim().equals(""))
            consolids = consolidsSemFiltroParada;
        else {
            qSemParada.append(trecho1.toString());
            qSemParada.append(trecho2.toString());
            qSemParada.append(trecho3.toString());

            qSemParada.defineParametro("dtreferencia", dtReferencia);
            qSemParada.defineParametro("idpt", idPt.longValue());
            qSemParada.defineParametro("idturno", idTurno.longValue());
            qSemParada.defineParametro("tpId", (byte) 1);
            qSemParada.defineParametro("cdarearesp", cdAreaResp);
            qSemParada.defineParametro("cdcp", cdCp);

            if (isComPeso == true && isSemPeso == false) {
                qSemParada.defineParametro("ispesa", true);
            } else if (isComPeso == false && isSemPeso == true) {
                qSemParada.defineParametro("ispesa", false);
            }

            consolids = qSemParada.list();
        }

        // Interage sobre a lista de consolpa para totalizar valores e iniciar vetor
        for (DwConsolid id : consolids) {
            for (DwConsol dwconsol : id.getDwConsols()) {
                for (DwConsolpa dwconsolpa : dwconsol.getDwConsolpas()) {
                    if (isComPeso == true && isSemPeso == false) {
                        if (dwconsolpa.getDwTParada().getIsPesa() == false)
                            continue;
                    }
                    if (isComPeso == false && isSemPeso == true) {
                        if (dwconsolpa.getDwTParada().getIsPesa())
                            continue;
                    }
                    
                    if (dwconsolpa.getSegAutoTempoparadaCp() != null)
                        totalParadaSoma = totalParadaSoma.add(dwconsolpa.getSegAutoTempoparadaCp());
                    if (dwconsolpa.getSegAutoTempoparadaSp() != null)
                        totalParadaSoma = totalParadaSoma.add(dwconsolpa.getSegAutoTempoparadaSp());

                	todosConsolpa.add(dwconsolpa);
                    
                }
            }
        }
        
        Map<String, DwFolhacic> mapFolhaCic = new HashMap<String, DwFolhacic>();
        Map<DwFolha, BigDecimal> mapQtPcsCicloAtivas = new HashMap<DwFolha, BigDecimal>();
        
        for (DwConsolpa consolpa : todosConsolpa) {
            GraficoParettoParadaDTO paradaGraf = mapParadas.get(consolpa.getDwTParada().getIdTparada());
            
            if (paradaGraf == null) {
            	// Quando for a 1a vez do idTParada
                paradaGraf = new GraficoParettoParadaDTO();

                paradaGraf.setIdTParada(consolpa.getDwTParada().getIdTparada());
                paradaGraf.setCdParada(consolpa.getDwTParada().getCdTparada());

                if (consolpa.getDwTParada().getIsPesa() != null && (consolpa.getDwTParada().getIsPesa())) {
                    paradaGraf.setDsParada(consolpa.getDwTParada().getDsTparada().toUpperCase());
                } else {
                    paradaGraf.setDsParada(consolpa.getDwTParada().getDsTparada().toLowerCase());
                }

                BigDecimal tempoParadas = BigDecimal.ZERO;

                if (consolpa.getSegAutoTempoparadaCp() != null)
                    tempoParadas = consolpa.getSegAutoTempoparadaCp();

                if (consolpa.getSegAutoTempoparadaSp() != null) {
                    tempoParadas = tempoParadas.add(consolpa.getSegAutoTempoparadaSp());
                    totalParadaSemPeso = totalParadaSemPeso.add(consolpa.getSegAutoTempoparadaSp());
                }

                if (tempoParadas.doubleValue() <= 0) {
                    continue;
                }

                // ARMAZENA O TEMPO PARADAS DE ACORDO COM CD PARADA
                BigDecimal tempoParadaAdd = mapIndicePorParada.get(consolpa.getDwTParada().getIdTparada());
                if (tempoParadaAdd == null) {
                    tempoParadaAdd = tempoParadas;
                    mapIndicePorParada.put(consolpa.getDwTParada().getIdTparada(), tempoParadaAdd);
                }

                double indiceParada = FormulasInjet.calcularIndiceParada(tempoParadas, totalParadaSoma);
                // Coloquei esse if pq agora estou calculando tb a parada em aberto no grafico e qdo ela comeca no turno anterior o indice
                // pode
                // ser superior a 100%
                if (indiceParada > 100d)
                    indiceParada = 100d;
                
                paradaGraf.setIndiceParada(indiceParada);

                String tempoParadasF = DataHoraRN.formatMilisegundosParaHHMMSSmmm(tempoParadas.multiply(new BigDecimal(1000)).longValue());
                paradaGraf.setTempoFormatado(tempoParadasF);
                paradaGraf.setTempo(tempoParadas.doubleValue());

                List<DwConsolpaoco> listaOcorrencias = getDwConsolpas(consolpa.getIdConsolpa());
                if (listaOcorrencias == null || listaOcorrencias.size() <= 0)
                    listaOcorrencias.addAll(consolpa.getDwConsolpaocos());
                
                
                // PARQUE QUE PEGO AS OCORRENCIAS DA PARADA
                for (DwConsolpaoco ocorrencia : listaOcorrencias) {
                    BigDecimal pcsCicloAtivas = BigDecimal.ONE;
                    
                    // Alex 21/06/2017: percebi que ao gerar uma parada aberta virtual a DwConsolpaoco dela nao tem
                	// referencia para a DwConsolpa, causando NPE ao tentar acessar a folha da ocorrencia.
                	// Adicionei o if abaixo para solucionar o problema.
                    DwConsolpa paDaOcorrencia = ocorrencia.getDwConsolpa();
                    if(paDaOcorrencia == null) {
                    	paDaOcorrencia = consolpa;
                    }

                    // recupera ciclo padr�o
                    try {
                    	
                    	//Alex 09/06/2017 #3918
                    	DwFolha folha = paDaOcorrencia.getDwConsol().getDwConsolid().getDwFolha();
                    	OmPt pt = paDaOcorrencia.getDwConsol().getDwConsolid().getOmPt().clone(false);
                    	
                        pcsCicloAtivas = folhaRN.getPcsCicloAtivas(mapQtPcsCicloAtivas, folha);
                    	dwFolhaCic = folhaRN.getFolhaCic(mapFolhaCic, folha, pt);
                        cicloPadrao = dwFolhaCic.getSegCiclopadrao().doubleValue();

                    } catch (SemCicloPadraoException e) {
                        cicloPadrao = paDaOcorrencia.getDwConsol().getDwConsolid().getDwFolha().getSegCiclopadrao().doubleValue();
                    } catch (NullPointerException e) {
                        // Nessa caso eh pq a parada esta em aberta por enquanto vou considerar um valor 60 para o ciclo
                        cicloPadrao = 60d;
                        pcsCicloAtivas = BigDecimal.ONE;
                    }

                    qtPcsCicloAtivas = pcsCicloAtivas.doubleValue();
                    
                    duracaoOcorrenciaParada = DataHoraRN.getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(),
                            ocorrencia.getDthrFparada());
                    qtdPerdasParada = FormulasInjet.calcularPcsPerdaParada(new BigDecimal(duracaoOcorrenciaParada),
                            new BigDecimal(cicloPadrao), new BigDecimal(qtPcsCicloAtivas)).doubleValue();
                    qtdPerdasParadaPARADA = qtdPerdasParadaPARADA + qtdPerdasParada;
                    qtdPerdasParadaTOTAL = qtdPerdasParadaTOTAL + qtdPerdasParada;

                    // PEGA MAIOR DATA E MENOR DATA DE TODAS AS OCORRENCIAS DE PARADAS DA CONSULTA
                    menorDthrInicioParada = getMenorDthrInicioParada(ocorrencia.getDthrIparada(), menorDthrInicioParada);
                    // Alessandre: em 25-11-15 teve uma situacao que ocorrencia.dthrFParada esta null e apenas 1 ocorrencia para ser
                    // validada. Se for null vou utilizar o final do turno ou a hora atual como referencia
                    Date dthrf = ocorrencia.getDthrFparada();
                    if (dthrf == null)
                        dthrf = consolpa.getDwConsol().getDwConsolid().getDthrFturno();
                    if (DataHoraRN.after(dthrf, DataHoraRN.getDataHoraAtual()))
                        dthrf = DataHoraRN.getDataHoraAtual();
                    maiorDthrFimParada = getMaiorDthrFimParada(dthrf, maiorDthrFimParada);

                    List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorParada.get(consolpa.getDwTParada().getCdTparada());
                    if (listaOcoDTO == null) {
                        listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
                        OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
                        ocoDTO.setIdEvt(consolpa.getDwTParada().getIdTparada());
                        ocoDTO.setDthrIni(ocorrencia.getDthrIparada());
                        ocoDTO.setDthrFim(ocorrencia.getDthrFparada());

                        int duracaoEvt = DataHoraRN
                                .getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());

                        ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
                        ocoDTO.setMsDtHrIni(ocorrencia.getMsDthriparada());
                        ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrfparada());

                        listaOcoDTO.add(ocoDTO);
                        mapOcorrenciasPorParada.put(consolpa.getDwTParada().getIdTparada(), listaOcoDTO);

                    } else {
                        OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
                        ocoDTO.setIdEvt(consolpa.getDwTParada().getIdTparada());
                        ocoDTO.setDthrIni(ocorrencia.getDthrIparada());
                        ocoDTO.setDthrFim(ocorrencia.getDthrFparada());

                        int duracaoEvt = DataHoraRN
                                .getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());

                        ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
                        ocoDTO.setMsDtHrIni(ocorrencia.getMsDthriparada());
                        ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrfparada());

                        listaOcoDTO.add(ocoDTO);
                    }
                }

                paradaGraf.setQtdPerdasParada(qtdPerdasParadaPARADA);
                mapParadas.put(consolpa.getDwTParada().getIdTparada(), paradaGraf);

            } else {
            	// QUando idTParada ja existe no map de paradas
                BigDecimal tempoParadas = BigDecimal.ZERO;

                if (consolpa.getSegAutoTempoparadaCp() != null)
                    tempoParadas = consolpa.getSegAutoTempoparadaCp();

                if (consolpa.getSegAutoTempoparadaSp() != null) {
                    tempoParadas = tempoParadas.add(consolpa.getSegAutoTempoparadaSp());
                    totalParadaSemPeso = totalParadaSemPeso.add(consolpa.getSegAutoTempoparadaSp());
                }

                if (tempoParadas.doubleValue() <= 0) {
                    continue;
                }

                // ARMAZENA O TEMPO PARADAS DE ACORDO COM CD PARADA
                BigDecimal tempoParadaDeUmMotivo = mapIndicePorParada.get(consolpa.getDwTParada().getIdTparada());
                if (tempoParadaDeUmMotivo != null) {
                    tempoParadaDeUmMotivo = tempoParadaDeUmMotivo.add(tempoParadas);
                    mapIndicePorParada.put(consolpa.getDwTParada().getIdTparada(), tempoParadaDeUmMotivo);
                }

                double indiceParada = FormulasInjet.calcularIndiceParada(tempoParadaDeUmMotivo, totalParadaSoma);
                paradaGraf.setIndiceParada(indiceParada);

                String tempoParadasF = DataHoraRN.formatSegundosParaHHMMSS(tempoParadaDeUmMotivo.intValue());
                paradaGraf.setTempoFormatado(tempoParadasF);
                paradaGraf.setTempo(tempoParadaDeUmMotivo.doubleValue());

                List<DwConsolpaoco> listaOcorrencias = getDwConsolpas(consolpa.getIdConsolpa());

                // PARQUE QUE PEGO AS OCORRENCIAS DA PARADA
                for (DwConsolpaoco ocorrencia : listaOcorrencias) {
                    // recupera ciclo padr�o
                    try {
                    	//Alex 09/06/2017 #3918
                    	DwFolha folha = ocorrencia.getDwConsolpa().getDwConsol().getDwConsolid().getDwFolha();
                    	OmPt pt = ocorrencia.getDwConsolpa().getDwConsol().getDwConsolid().getOmPt().clone(false);
                    	
                    	dwFolhaCic = folhaRN.getFolhaCic(mapFolhaCic, folha, pt);
                        cicloPadrao = dwFolhaCic.getSegCiclopadrao().doubleValue();

                    } catch (SemCicloPadraoException e) {
                        cicloPadrao = ocorrencia.getDwConsolpa().getDwConsol().getDwConsolid().getDwFolha().getSegCiclopadrao()
                                .doubleValue();
                    }

                    //Alex 09/06/2017 #3918
                    DwFolha folha = ocorrencia.getDwConsolpa().getDwConsol().getDwConsolid().getDwFolha();
                    BigDecimal pcsCicloAtivas = folhaRN.getPcsCicloAtivas(mapQtPcsCicloAtivas, folha);
                    qtPcsCicloAtivas = pcsCicloAtivas.doubleValue();
                    

                    duracaoOcorrenciaParada = DataHoraRN.getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(),
                            ocorrencia.getDthrFparada());
                    qtdPerdasParada = FormulasInjet.calcularPcsPerdaParada(new BigDecimal(duracaoOcorrenciaParada),
                            new BigDecimal(cicloPadrao), new BigDecimal(qtPcsCicloAtivas)).doubleValue();
                    qtdPerdasParadaPARADA = qtdPerdasParadaPARADA + qtdPerdasParada;
                    qtdPerdasParadaTOTAL = qtdPerdasParadaTOTAL + qtdPerdasParada;

                    // PEGA MAIOR DATA E MENOR DATA DE TODAS AS OCORRENCIAS DE PARADAS DA CONSULTA
                    menorDthrInicioParada = getMenorDthrInicioParada(ocorrencia.getDthrIparada(), menorDthrInicioParada);
                    maiorDthrFimParada = getMaiorDthrFimParada(ocorrencia.getDthrFparada(), maiorDthrFimParada);

                    List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorParada.get(consolpa.getDwTParada().getCdTparada());
                    if (listaOcoDTO != null) {
                        OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
                        ocoDTO.setIdEvt(consolpa.getDwTParada().getIdTparada());
                        ocoDTO.setDthrIni(ocorrencia.getDthrIparada());
                        ocoDTO.setDthrFim(ocorrencia.getDthrFparada());

                        int duracaoEvt = DataHoraRN
                                .getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());

                        ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
                        ocoDTO.setMsDtHrIni(ocorrencia.getMsDthriparada());
                        ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrfparada());

                        listaOcoDTO.add(ocoDTO);
                    }
                    paradaGraf.setQtdPerdasParada(qtdPerdasParadaPARADA);
                }
            }
        }

        // Ainda falta calcular o índice de paradas baseado na quantidade de perdas por parada (o total geral de perdas nesta condi��oo é
        // calculado nesta rotina, n�o vem como parâmero
        Set<Long> cdsParadas = mapParadas.keySet();
        for (Long cdParada : cdsParadas) {
            GraficoParettoParadaDTO paradaGraf = mapParadas.get(cdParada);
            paradaGraf.setIndiceParadaQtdPerdasPar(FormulasInjet.calcularIndiceParada(new BigDecimal(paradaGraf.getQtdPerdasParada()),
                    new BigDecimal(qtdPerdasParadaTOTAL)).doubleValue());
        }

        GrafTendenciaUtils algoritmoGraf = null;

        // MONTA O GRAFICO - NESTE MOMENTO É DEFINIDO O INTERVALO DE CORES
        if (menorDthrInicioParada != null && maiorDthrFimParada != null) {
            algoritmoGraf = new GrafTendenciaUtils(menorDthrInicioParada, maiorDthrFimParada);
        }

        GraficosParettoParadaDTO retorno = new GraficosParettoParadaDTO();
        if (algoritmoGraf != null) {
            defineCoresLegendaEBarra(algoritmoGraf, retorno, mapParadas, mapOcorrenciasPorParada);
        }

        return retorno;

    }

    /*
     * Esse metodo esta sendo chamado pela tela de detalhe padrao Injet no momento em que o grafico de parada eh solicitado
     */
    public GraficosParettoParadaDTO getGraficoParettoParadaDTO(Byte tpId, Date dtInicial, Date dtFinal, BigDecimal idTurno, String cdPt,
            String cdCp, Boolean isComPeso, Boolean isSemPeso, BigDecimal totalParadas, String cdAreaResp) {
        Double qtdPerdasParada = 0d;
        Double qtdPerdasParadaPARADA = 0d;
        Double qtdPerdasParadaTOTAL = 0d;
        int duracaoOcorrenciaParada = 0;

        FolhaRN folhaRN = new FolhaRN(this.getDao());

        final int _idConsolpa = 0;
        final int _idTparada = 1;
        final int _cdTparada = 2;
        final int _dsTparada = 3;
        final int _ispesa = 4;
        final int _cicloPadrao = 5;
        final int _pcsCicloAtivas = 6;
        final int _segAutoTempoparadaCp = 7;
        final int _segAutoTempoparadaSp = 8;

        MapQuery q = new MapQuery(getDaoSession());
        q.append("SELECT ");
        q.append("dwconsolpa.idConsolpa,");
        q.append("dwtparada.idTparada,");
        q.append("dwtparada.cdTparada,");
        q.append("dwtparada.dsTparada,");
        q.append("dwtparada.isPesa,");
        q.append("dwconsol.segAutoCiclopadrao,");
        q.append("dwconsol.qtAutoCavativas,");
        q.append("SUM(dwconsolpa.segAutoTempoparadaCp),");
        q.append("SUM(dwconsolpa.segAutoTempoparadaSp)");
        q.append("FROM DwConsolpa dwconsolpa");
        q.append("JOIN dwconsolpa.dwConsol dwconsol");
        q.append("JOIN dwconsol.dwConsolid dwconsolid");
        q.append("JOIN dwconsolpa.dwTParada dwtparada");

        if (cdAreaResp != null && cdAreaResp.equals("") == false) {
            q.append("JOIN dwtparada.dwTArea dwtarea");
        }

        q.append("WHERE dwconsolid.tpId = :tpid");

        if (idTurno != null && idTurno.equals(BigDecimal.ONE) == false)
            q.append("AND dwconsolid.dwTurno.idTurno <> 1");

        if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO)) {
            // data
            if (dtInicial != null) {
                q.append("AND dwconsolid.dtReferencia between :dtinicial and :dtfinal");
            }

            // turno
            if (idTurno != null && idTurno.equals(BigDecimal.ZERO) == false) {
                q.append("AND dwconsolid.dwTurno.idTurno = :idturno");
            }
        }

        if (!tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP)) {
            // máquina
            if (!cdPt.equals("") && !cdPt.equals(null)) {
                q.append("AND dwconsolid.omPt.cdPt = :cdpt");
            }
        }

        // op
        if (!cdCp.equals("") && !cdCp.equals(null)) {
            q.append("AND dwconsolid.ppCp.cdCp = :cdcp");
        }

        // paradas
        if (isComPeso == true && isSemPeso == false) {
            q.append("AND dwtparada.isPesa = 1");
        } else if (isComPeso == false && isSemPeso == true) {
            q.append("AND dwtparada.isPesa = 0");
        }

        if (cdAreaResp != null && cdAreaResp.equals("") == false) {
            q.append("AND dwtarea.cdArea = :cdarearesp");
        }

        q.append("GROUP BY dwconsolpa.idConsolpa, dwtparada.idTparada, dwtparada.cdTparada, dwtparada.dsTparada, dwtparada.isPesa, dwconsol.segAutoCiclopadrao, dwconsol.qtAutoCavativas");

        // defini��oo de parâmetros

        if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO)) {
            // data
            if (dtInicial != null) {
                q.defineParametroData("dtinicial", dtInicial);
                q.defineParametroData("dtfinal", dtFinal);
            }

            // turno
            if (idTurno != null && idTurno.equals(BigDecimal.ZERO) == false) {
                q.defineParametro("idturno", idTurno.longValue());
            }
        }

        if (!tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP)) {
            // máquina
            if (!cdPt.equals("") && !cdPt.equals(null)) {
                q.defineParametro("cdpt", cdPt);
            }
        }

        // op
        if (!cdCp.equals("") && !cdCp.equals(null)) {
            q.defineParametro("cdcp", cdCp);
        }

        if (cdAreaResp != null && cdAreaResp.equals("") == false) {
            q.defineParametro("cdarearesp", cdAreaResp);
        }

        if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_ACUMULADO)
                || tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP))
            q.defineParametro("tpid", DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_ACUMULADO);
        else
            q.defineParametro("tpid", DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO);

        List<Object> lista = q.list();

        Date menorDthrInicioParada = null;
        Date maiorDthrFimParada = null;

        HashMap<Long, GraficoParettoParadaDTO> mapParadas = new HashMap<Long, GraficoParettoParadaDTO>();
        HashMap<Long, List<OcorrenciasEvtDTO>> mapOcorrenciasPorParada = new HashMap<Long, List<OcorrenciasEvtDTO>>();
        HashMap<Long, BigDecimal> mapIndicePorParada = new HashMap<Long, BigDecimal>();

        /*
         * Alessandre em 25-11-15 incluir nesse ponto a parada em aberto Pode-se ter a situacao em que o PT esta definido como apenas a OP
         * esta definida
         */
        
        
        Map <String, String> mapCdPts = new HashMap<String, String>();
        if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP)  && !cdCp.equals("") && !cdCp.equals(null)) {
            MapQuery qCps = new MapQuery(getDaoSession());
            qCps.append("SELECT a.omPt.cdPt");
            qCps.append("  FROM PpCp a");
            qCps.append(" WHERE a.cdCp = :cdcp");
            qCps.defineParametro("cdcp", cdCp);
            List<String> listaCps = qCps.list();
            for (String regCdPt : listaCps) {
                mapCdPts.put(regCdPt, regCdPt);
            }            
            
        } else {
        	mapCdPts.put(cdPt, cdPt);
        }
        
        // Calcular o tempo de parada ou quantidade perdida para se calcular o indice de parada
        // nao � possivel usar mais a variavel recebida totalParada, pois o grafico pode conter apenas algumas paradas e o totalParada � o
        // tempo
        // de todas as paradas, mesmo as n�o filtradas, gerando um indice de parada errado;
        // Alem disso o indice as vezes devera considerar a quantidade perdida ao inves do tempo
        totalParadas = BigDecimal.ZERO;
        for (Object reg : lista) {
            Object[] registro = (Object[]) reg;
            BigDecimal segAutoTempoparadaCp = (BigDecimal) registro[_segAutoTempoparadaCp];
            BigDecimal segAutoTempoparadaSp = (BigDecimal) registro[_segAutoTempoparadaSp];
            if (segAutoTempoparadaCp != null)
                totalParadas = totalParadas.add(segAutoTempoparadaCp);

            if (segAutoTempoparadaSp != null)
                totalParadas = totalParadas.add(segAutoTempoparadaSp);

        }
        
        Map<String, DwFolhacic> mapFolhaCic = new HashMap<String, DwFolhacic>();
        Map<DwFolha, BigDecimal> mapQtPcsCicloAtivas = new HashMap<DwFolha, BigDecimal>();

        for (Object reg : lista) {
            
            Object[] registro = (Object[]) reg;
            Long idConsolpa = (Long) registro[_idConsolpa];
            Long idTparada = (Long) registro[_idTparada];
            String cdParada = (String) registro[_cdTparada];
            String dsParada = (String) registro[_dsTparada];
            Boolean isPesa = (Boolean) registro[_ispesa];            
            BigDecimal segCiclopadrao = (BigDecimal) registro[_cicloPadrao];
            BigDecimal qtPcsCicloAtivas = (BigDecimal) registro[_pcsCicloAtivas];
            BigDecimal segAutoTempoparadaCp = (BigDecimal) registro[_segAutoTempoparadaCp];
            BigDecimal segAutoTempoparadaSp = (BigDecimal) registro[_segAutoTempoparadaSp];

            GraficoParettoParadaDTO paradaGraf = mapParadas.get(idTparada);

            if (paradaGraf == null) {
                qtdPerdasParadaPARADA = 0d; // totalizador de perdas por parada

                paradaGraf = new GraficoParettoParadaDTO();

                paradaGraf.setIdTParada(idTparada);
                paradaGraf.setCdParada(cdParada);

                if (isPesa) {
                    paradaGraf.setDsParada(dsParada.toUpperCase());
                } else {
                    paradaGraf.setDsParada(dsParada.toLowerCase());
                }

                BigDecimal tempoParadas = BigDecimal.ZERO;

                if (segAutoTempoparadaCp != null)
                    tempoParadas = segAutoTempoparadaCp;

                if (segAutoTempoparadaSp != null) {
                    if (tempoParadas.doubleValue() == 0)
                        tempoParadas = segAutoTempoparadaSp;
                    else
                        tempoParadas = tempoParadas.add(segAutoTempoparadaSp);
                }
                if (tempoParadas.doubleValue() <= 0) {
                    continue;
                }

                // ARMAZENA O TEMPO PARADAS DE ACORDO COM CD PARADA
                BigDecimal indiceParadaa = mapIndicePorParada.get(idTparada);
                if (indiceParadaa == null) {
                    indiceParadaa = tempoParadas;
                    mapIndicePorParada.put(idTparada, indiceParadaa);
                }

                double indiceParada = FormulasInjet.calcularIndiceParada(tempoParadas, totalParadas);
                paradaGraf.setIndiceParada(indiceParada);

                String tempoParadasF = DataHoraRN.formatMilisegundosParaHHMMSSmmm(tempoParadas.multiply(new BigDecimal(1000)).longValue());
                paradaGraf.setTempoFormatado(tempoParadasF);
                paradaGraf.setTempo(tempoParadas.doubleValue());

                List<DwConsolpaoco> listaOcorrencias = getDwConsolpas(idConsolpa);
                // Se o idConsolpa for zero eh pq eh uma parada em aberto. Assim ireimos criar uma oco ficticia

            	DwFolha folha = null;
            	OmPt pt = null;
            	DwConsolpaoco ocorrenciaAux = null;
            	
            	if (listaOcorrencias.isEmpty() == false) {
            		ocorrenciaAux = listaOcorrencias.get(0);
            	}

            	if (idConsolpa.equals(0l) == false) {
	                if (segCiclopadrao == null) {
	                	folha = ocorrenciaAux.getDwConsolpa().getDwConsol().getDwConsolid().getDwFolha();
	                	pt = ocorrenciaAux.getDwConsolpa().getDwConsol().getDwConsolid().getOmPt().clone(false);
	                	try {
							segCiclopadrao = new BigDecimal(folhaRN.getCicloPadrao(folha, pt).doubleValue());
						} catch (SemCicloPadraoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                }
	                
	                // recupera pcs por ciclo
	                if (qtPcsCicloAtivas == null) {                        
	                	try {
							qtPcsCicloAtivas = new BigDecimal(folhaRN.getPcsPorCicloAtivas(folha).doubleValue());
						} catch (SemPcsPorCicloAtivasException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                }
            	}            	

                // SARDINHA: varre lista de ocorrencias e calcula as perdas por parada (necessário na ficha da máquina padrao Injet)
                for (DwConsolpaoco ocorrencia : listaOcorrencias) {
                    duracaoOcorrenciaParada = DataHoraRN.getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());

                    // calcular a perda somente se a parada pesar
                    if (isPesa) {
                        qtdPerdasParada = FormulasInjet.calcularPcsPerdaParada(new BigDecimal(duracaoOcorrenciaParada), segCiclopadrao, qtPcsCicloAtivas).doubleValue();
                        qtdPerdasParadaPARADA = qtdPerdasParadaPARADA + qtdPerdasParada;
                        qtdPerdasParadaTOTAL = qtdPerdasParadaTOTAL + qtdPerdasParada;
                    }

                    // PEGA MAIOR DATA E MENOR DATA DE TODAS AS OCORRENCIAS DE PARADAS DA CONSULTA
                    menorDthrInicioParada = getMenorDthrInicioParada(ocorrencia.getDthrIparada(), menorDthrInicioParada);
                    Date dtf = ocorrencia.getDthrFparada();
                    if (dtf == null)
                        dtf = ocorrencia.getDwConsolpa().getDwConsol().getDwConsolid().getDthrFturno();
                    if (DataHoraRN.after(dtf, DataHoraRN.getDataHoraAtual()))
                        dtf = DataHoraRN.getDataHoraAtual();
                    maiorDthrFimParada = getMaiorDthrFimParada(dtf, maiorDthrFimParada);

                    List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorParada.get(cdParada);
                    if (listaOcoDTO == null) {
                        listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
                        OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
                        ocoDTO.setIdEvt(idTparada); // verificar
                        ocoDTO.setDthrIni(ocorrencia.getDthrIparada());
                        ocoDTO.setDthrFim(ocorrencia.getDthrFparada());

                        int duracaoEvt = DataHoraRN.getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());
                        ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
                        ocoDTO.setMsDtHrIni(ocorrencia.getMsDthriparada());
                        ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrfparada());

                        listaOcoDTO.add(ocoDTO);
                        mapOcorrenciasPorParada.put(idTparada, listaOcoDTO);

                    } else {
                        OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
                        ocoDTO.setIdEvt(idTparada); // veririficar
                        ocoDTO.setDthrIni(ocorrencia.getDthrIparada());
                        ocoDTO.setDthrFim(ocorrencia.getDthrFparada());

                        int duracaoEvt = DataHoraRN.getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());

                        ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
                        ocoDTO.setMsDtHrIni(ocorrencia.getMsDthriparada());
                        ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrfparada());

                        listaOcoDTO.add(ocoDTO);
                    }
                }

                paradaGraf.setQtdPerdasParada(qtdPerdasParadaPARADA);
                mapParadas.put(idTparada, paradaGraf);

            } else {

                BigDecimal tempoParadas = BigDecimal.ZERO;

                if (segAutoTempoparadaCp != null)
                    tempoParadas = segAutoTempoparadaCp;

                if (segAutoTempoparadaSp != null)
                    tempoParadas.add(segAutoTempoparadaSp);

                if (tempoParadas.doubleValue() <= 0) {
                    continue;
                }

                // ARMAZENA O TEMPO PARADAS DE ACORDO COM CD PARADA
                BigDecimal indiceParadaa = mapIndicePorParada.get(idTparada);
                if (indiceParadaa != null) {
                    indiceParadaa = indiceParadaa.add(tempoParadas);
                    mapIndicePorParada.put(idTparada, indiceParadaa);
                }

                double indiceParada = FormulasInjet.calcularIndiceParada(indiceParadaa, totalParadas);
                paradaGraf.setIndiceParada(indiceParada);

                String tempoParadasF = DataHoraRN.formatSegundosParaHHMMSS(indiceParadaa.intValue());
                paradaGraf.setTempoFormatado(tempoParadasF);
                paradaGraf.setTempo(indiceParadaa.doubleValue());

                List<DwConsolpaoco> listaOcorrencias = getDwConsolpas(idConsolpa);

                /* Alessandre em 13-06-17 tirei o trecho que pesquisa a folha de dentro do for pois qdo o filtor
                 * eh por OP existiam 11mil ocorrencias e a folha eh a mesma e estava pesquisando 11mil vezes a mesma coisa
                 */
                DwConsolpaoco ocorrenciaAux = null;
                if (listaOcorrencias.isEmpty() == false) {
                	ocorrenciaAux = listaOcorrencias.get(0);
                }
                
            	DwFolha folha = null;
            	OmPt pt = null;
            	
            	if (idConsolpa.equals(0l) == false) {
                	// recupera ciclo padrao
	                if (segCiclopadrao == null) {
	                	folha = ocorrenciaAux.getDwConsolpa().getDwConsol().getDwConsolid().getDwFolha();
	                	pt = ocorrenciaAux.getDwConsolpa().getDwConsol().getDwConsolid().getOmPt().clone(false);
	                	try {
							segCiclopadrao = new BigDecimal(folhaRN.getCicloPadrao(folha, pt).doubleValue());
						} catch (SemCicloPadraoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                }
	                
	                // recupera pcs por ciclo
	                if (qtPcsCicloAtivas == null) {                        
	                	try {
							qtPcsCicloAtivas = new BigDecimal(folhaRN.getPcsPorCicloAtivas(folha).doubleValue());
						} catch (SemPcsPorCicloAtivasException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                }
            	}               	
                
                // Modificar o loop abaixo para nao calcular a perda, somente as datas, reduzindo o tempo
                // SARDINHA: varre lista de ocorrencias e calcula as perdas por parada (necessário na ficha da máquina padr�o Injet)
                for (DwConsolpaoco ocorrencia : listaOcorrencias) {

                    duracaoOcorrenciaParada = DataHoraRN.getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());
                    qtdPerdasParada = FormulasInjet.calcularPcsPerdaParada(new BigDecimal(duracaoOcorrenciaParada), segCiclopadrao, qtPcsCicloAtivas).doubleValue();
                	
                    qtdPerdasParadaPARADA = qtdPerdasParadaPARADA + qtdPerdasParada;
                    qtdPerdasParadaTOTAL = qtdPerdasParadaTOTAL + qtdPerdasParada;

                    // PEGA MAIOR DATA E MENOR DATA DE TODAS AS OCORRENCIAS DE PARADAS DA CONSULTA
                    menorDthrInicioParada = getMenorDthrInicioParada(ocorrencia.getDthrIparada(), menorDthrInicioParada);
                    maiorDthrFimParada = getMaiorDthrFimParada(ocorrencia.getDthrFparada(), maiorDthrFimParada);

                    List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorParada.get(cdParada);
                    if (listaOcoDTO != null) {
                        OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
                        ocoDTO.setIdEvt(idTparada);
                        ocoDTO.setDthrIni(ocorrencia.getDthrIparada());
                        ocoDTO.setDthrFim(ocorrencia.getDthrFparada());

                        int duracaoEvt = DataHoraRN.getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());

                        ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
                        ocoDTO.setMsDtHrIni(ocorrencia.getMsDthriparada());
                        ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrfparada());

                        listaOcoDTO.add(ocoDTO);
                    }
                }
                paradaGraf.setQtdPerdasParada(qtdPerdasParadaPARADA);
            }

        }

        // Ainda falta calcular o índice de paradas baseado na quantidade de perdas por parada (o total geral de perdas nesta condi��oo é
        // calculado nesta rotina, n�o vem como parâmero
        Set<Long> idsParadas = mapParadas.keySet();
        BigDecimal totalPerdaParada = BigDecimal.ZERO;
        for (Long idParada : idsParadas) {
            GraficoParettoParadaDTO paradaGraf = mapParadas.get(idParada);
            totalPerdaParada = totalPerdaParada.add(new BigDecimal(paradaGraf.getQtdPerdasParada()));
        }

        for (Long idParada : idsParadas) {
            GraficoParettoParadaDTO paradaGraf = mapParadas.get(idParada);
            paradaGraf.setIndiceParadaQtdPerdasPar(FormulasInjet.calcularIndiceParada(new BigDecimal(paradaGraf.getQtdPerdasParada()),
                    totalPerdaParada).doubleValue());

        }

        GrafTendenciaUtils algoritmoGraf = null;

        // MONTA O GRAFICO - NESTE MOMENTO É DEFINIDO O INTERVALO DE CORES
        if (menorDthrInicioParada != null && maiorDthrFimParada != null) {
            algoritmoGraf = new GrafTendenciaUtils(menorDthrInicioParada, maiorDthrFimParada);
        }

        GraficosParettoParadaDTO retorno = new GraficosParettoParadaDTO();
        if (algoritmoGraf != null) {
            defineCoresLegendaEBarra(algoritmoGraf, retorno, mapParadas, mapOcorrenciasPorParada);
        }

        return retorno;
    }

    private List<DwConsolpaoco> getDwConsolpas(long idConsolpa) {
        MapQuery q = new MapQuery(getDaoSession());
        q.append("SELECT consolpaoco");
        q.append("FROM DwConsolpaoco consolpaoco");
        q.append("JOIN consolpaoco.dwConsolpa consolpa");
        q.append("WHERE consolpa.idConsolpa = :idConsolpa");
        q.defineParametro("idConsolpa", idConsolpa);
        return q.list();
    }

    private Date getMenorDthrInicioParada(Date dthrInicioParada, Date menorDthrInicioParada) {
        if (menorDthrInicioParada == null) {
            return dthrInicioParada;
        } else {
            if (DataHoraRN.before(dthrInicioParada, menorDthrInicioParada)) {
                return dthrInicioParada;
            } else {
                return menorDthrInicioParada;
            }
        }
    }

    private Date getMaiorDthrFimParada(Date dthrFimParada, Date maiorDthrFimParada) {
        if (maiorDthrFimParada == null) {
            return dthrFimParada;
        } else {
            if (dthrFimParada != null && DataHoraRN.after(dthrFimParada, maiorDthrFimParada)) {
                return dthrFimParada;
            } else {
                return maiorDthrFimParada;
            }
        }
    }

    private void defineCoresLegendaEBarra(GrafTendenciaUtils algoritmoGraf, GraficosParettoParadaDTO retorno,
            HashMap<Long, GraficoParettoParadaDTO> mapParadas, HashMap<Long, List<OcorrenciasEvtDTO>> mapOcorrenciasPorParada) {

        if (algoritmoGraf.getIntervaloGrafTend() != null && !algoritmoGraf.getIntervaloGrafTend().isEmpty()) {
            for (IntervaloGrafTendenciaRefugoParada intervalo : algoritmoGraf.getIntervaloGrafTend()) {
                if (intervalo.getCorIntervalo().equals(Color.YELLOW)) {
                    DatasDTO datasAmarelo = new DatasDTO();
                    datasAmarelo.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
                    datasAmarelo.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
                    datasAmarelo.setCorHexa(Cor.transformarParaCodigoHexadecimal(Color.YELLOW));
                    retorno.setCorAmarela(datasAmarelo);
                }
                if (intervalo.getCorIntervalo().equals(Color.ORANGE)) {
                    DatasDTO datasLaranja = new DatasDTO();
                    datasLaranja.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
                    datasLaranja.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
                    datasLaranja.setCorHexa(Cor.transformarParaCodigoHexadecimal(Color.ORANGE));
                    retorno.setCorLaranja(datasLaranja);
                }
                if (intervalo.getCorIntervalo().equals(Color.GREEN)) {
                    DatasDTO datasVerde = new DatasDTO();
                    datasVerde.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
                    datasVerde.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
                    datasVerde.setCorHexa(Cor.transformarParaCodigoHexadecimal(Color.GREEN));
                    retorno.setCorVerde(datasVerde);
                }
                if (intervalo.getCorIntervalo().equals(Color.RED)) {
                    DatasDTO datasVermelho = new DatasDTO();
                    datasVermelho.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
                    datasVermelho.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
                    datasVermelho.setCorHexa(Cor.transformarParaCodigoHexadecimal(Color.RED));
                    retorno.setCorVermelho(datasVermelho);
                }
            }
        }

        List<GraficoParettoParadaDTO> listaParadas = new ArrayList<GraficoParettoParadaDTO>();

        Set<Long> cdsParadas = mapParadas.keySet();
        for (Long cdParada : cdsParadas) {
            GraficoParettoParadaDTO paradaGraf = mapParadas.get(cdParada);
            List<OcorrenciasEvtDTO> listaOco = mapOcorrenciasPorParada.get(cdParada);
            if (listaOco != null && listaOco.size() > 0) {
                Paint paint = algoritmoGraf.corBarraTendencia(paradaGraf.getIdTParada(), listaOco);
                Color cor = (Color) paint;
                paradaGraf.setCorBarra(String.valueOf(cor.getRGB()));
                paradaGraf.setCorHexa(Cor.transformarParaCodigoHexadecimal(cor.getRGB()));
                listaParadas.add(paradaGraf);
            }
        }

        retorno.setParadas(listaParadas);

    }
    
    public GraficosParettoParadaDTO getGraficoParettoParadaBIDTO(BiFiltroDTO filtro) {
    	BigDecimal totalParadas = BigDecimal.ZERO;
    	boolean isComPeso = true;
    	boolean isSemPeso = false;
    	
    	Double qtdPerdasParadaTOTAL = 0d;

        final int _idConsolpa = 0;
        final int _idTparada = 1;
        final int _cdTparada = 2;
        final int _dsTparada = 3;
        final int _ispesa = 4;

        final int _idTarea = 5;
        final int _cdTarea = 6;
        final int _dsTarea = 7;

        final int _segAutoTempoparadaCp = 8;
        final int _segAutoTempoparadaSp = 9;

        final int _pcsAutoPerdaparadaCp = 10;
        final int _pcsAutoPerdaparadaSp = 11;

        Date menorDthrInicioParada = null;
        Date maiorDthrFimParada = null;

        HashMap<Long, GraficoParettoParadaDTO> mapParadas = new HashMap<Long, GraficoParettoParadaDTO>();
        HashMap<Long, List<OcorrenciasEvtDTO>> mapOcorrenciasPorParada = new HashMap<Long, List<OcorrenciasEvtDTO>>();
        HashMap<Long, List<DwConsolpaoco>> mapOcorrenciasPorParadaAberta = new HashMap<Long, List<DwConsolpaoco>>();        
        HashMap<Long, BigDecimal> mapIndicePorParada = new HashMap<Long, BigDecimal>();

        
        
    	// --------- filtros relacionados a area resp   ------------------- // 
		isComPeso = filtro.getFiltroBIParetoParada().getIsComPeso();
		isSemPeso = filtro.getFiltroBIParetoParada().getIsSemPeso();
        
        List<Object> listaParadasFechadas = consultaParadasFechadas(filtroBItoFiltroDetalhePt(filtro), isComPeso, isSemPeso);

        // Calcular o tempo de parada ou quantidade perdida para se calcular o indice de parada
        // nao � possivel usar mais a variavel recebida totalParada, pois o grafico pode conter apenas algumas paradas e o totalParada � o
        // tempo
        // de todas as paradas, mesmo as n�o filtradas, gerando um indice de parada errado;
        // Alem disso o indice as vezes devera considerar a quantidade perdida ao inves do tempo
        
        totalParadas = BigDecimal.ZERO;
        for (Object reg : listaParadasFechadas) {
            Object[] registro = (Object[]) reg;
            BigDecimal segAutoTempoparadaCp = (BigDecimal) registro[_segAutoTempoparadaCp];
            BigDecimal segAutoTempoparadaSp = (BigDecimal) registro[_segAutoTempoparadaSp];
            
            if (segAutoTempoparadaCp != null)
                totalParadas = totalParadas.add(segAutoTempoparadaCp);

            if (segAutoTempoparadaSp != null)
                totalParadas = totalParadas.add(segAutoTempoparadaSp);

        }

        Boolean isProcessouParadaAberta = false;
        
        for (Object reg : listaParadasFechadas) {

            Object[] registro = (Object[]) reg;
            Long idConsolpa = (Long) registro[_idConsolpa];
            Long idTparada = (Long) registro[_idTparada];
            String cdParada = (String) registro[_cdTparada];
            String dsParada = (String) registro[_dsTparada];

            Long idTarea = (Long) registro[_idTarea];
            String cdArea = (String) registro[_cdTarea];
            String dsArea = (String) registro[_dsTarea];
            
            Boolean isPesa = (Boolean) registro[_ispesa];
            BigDecimal segAutoTempoparadaCp = (BigDecimal) registro[_segAutoTempoparadaCp];
            BigDecimal segAutoTempoparadaSp = (BigDecimal) registro[_segAutoTempoparadaSp];
            BigDecimal pcsAutoPerdaparadaCp = (BigDecimal) registro[_pcsAutoPerdaparadaCp];
            BigDecimal pcsAutoPerdaparadaSp = (BigDecimal) registro[_pcsAutoPerdaparadaSp];

            if (pcsAutoPerdaparadaCp ==  null){
                pcsAutoPerdaparadaCp = BigDecimal.ZERO;
            }

            if (pcsAutoPerdaparadaSp ==  null){
                pcsAutoPerdaparadaSp = BigDecimal.ZERO;
            }

            GraficoParettoParadaDTO paradaGraf = mapParadas.get(idTparada);
            

            if (paradaGraf == null) {
                // parada
                paradaGraf = new GraficoParettoParadaDTO();
                paradaGraf.setIdTParada(idTparada);
                paradaGraf.setCdParada(cdParada);
                paradaGraf.setIdTArea(idTarea);
                paradaGraf.setCdArea(cdArea);
                paradaGraf.setDsArea(dsArea);

                if (isPesa) {
                    paradaGraf.setDsParada(dsParada.toUpperCase());
                } else {
                    paradaGraf.setDsParada(dsParada.toLowerCase());
                }

                BigDecimal tempoParadas = BigDecimal.ZERO;

                if (segAutoTempoparadaCp != null)
                    tempoParadas = segAutoTempoparadaCp;

                if (segAutoTempoparadaSp != null) {
                    if (tempoParadas.doubleValue() == 0)
                        tempoParadas = segAutoTempoparadaSp;
                    else
                        tempoParadas = tempoParadas.add(segAutoTempoparadaSp);
                }
                if (tempoParadas.doubleValue() <= 0) {
                    continue;
                }

                // ARMAZENA O TEMPO PARADAS DE ACORDO COM CD PARADA
                BigDecimal tempoPar = mapIndicePorParada.get(idTparada);
                if (tempoPar == null) {
                    tempoPar = tempoParadas;
                    mapIndicePorParada.put(idTparada, tempoPar);
                }

                double indiceParada = FormulasInjet.calcularIndiceParada(tempoParadas, totalParadas);
                
                paradaGraf.setIndiceParada(indiceParada);

                String tempoParadasF = DataHoraRN.formatMilisegundosParaHHMMSSmmm(tempoParadas.multiply(new BigDecimal(1000)).longValue());
                paradaGraf.setTempoFormatado(tempoParadasF);
                paradaGraf.setTempo(tempoParadas.doubleValue());
                paradaGraf.setQtdPerdasParada(pcsAutoPerdaparadaCp.doubleValue());
                
                List<DwConsolpaoco> listaOcorrencias = getDwConsolpas(idConsolpa);
                // Se o idConsolpa for zero eh pq eh uma parada em aberto. Assim ireimos criar uma oco ficticia

                if ( (idConsolpa.equals(0l) && isProcessouParadaAberta == false)) {
                    isProcessouParadaAberta = true;
                    
                    Set<Long> cdsParadasAbertas = mapOcorrenciasPorParadaAberta.keySet();
                    for (Long cdParadaAberta : cdsParadasAbertas) {
                        for(DwConsolpaoco ocor : mapOcorrenciasPorParadaAberta.get(cdParadaAberta)){
                            listaOcorrencias.add(ocor);                            
                        }
                    }
                }

                qtdPerdasParadaTOTAL = qtdPerdasParadaTOTAL + pcsAutoPerdaparadaCp.doubleValue();

                
                // SARDINHA: varre lista de ocorrencias e calcula as perdas por parada (necessário na ficha da máquina padr�o Injet)
                for (DwConsolpaoco ocorrencia : listaOcorrencias) {
                	/* Alessandre em 3-3-17. Se a ocorrencia nao tiver data de fim esta inconsistente
                	 * 
                	 */
                	if (ocorrencia.getDthrFparada() == null)
                		continue;
                	
                    // PEGA MAIOR DATA E MENOR DATA DE TODAS AS OCORRENCIAS DE PARADAS DA CONSULTA
                    menorDthrInicioParada = getMenorDthrInicioParada(ocorrencia.getDthrIparada(), menorDthrInicioParada);
                    Date dtf = ocorrencia.getDthrFparada();
                    if (dtf == null)
                        dtf = ocorrencia.getDwConsolpa().getDwConsol().getDwConsolid().getDthrFturno();
                    if (DataHoraRN.after(dtf, DataHoraRN.getDataHoraAtual()))
                        dtf = DataHoraRN.getDataHoraAtual();
                    maiorDthrFimParada = getMaiorDthrFimParada(dtf, maiorDthrFimParada);

                    List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorParada.get(idTparada);
                    if (listaOcoDTO == null) {
                        listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
                        OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
                        ocoDTO.setIdEvt(idTparada); // verificar
                        ocoDTO.setDthrIni(ocorrencia.getDthrIparada());
                        ocoDTO.setDthrFim(ocorrencia.getDthrFparada());

                        int duracaoEvt = DataHoraRN
                                .getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());
                        ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
                        ocoDTO.setMsDtHrIni(ocorrencia.getMsDthriparada());
                        ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrfparada());

                        listaOcoDTO.add(ocoDTO);
                        mapOcorrenciasPorParada.put(idTparada, listaOcoDTO);

                    } else {
                        OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
                        ocoDTO.setIdEvt(idTparada); // veririficar
                        ocoDTO.setDthrIni(ocorrencia.getDthrIparada());
                        ocoDTO.setDthrFim(ocorrencia.getDthrFparada());

                        int duracaoEvt = DataHoraRN
                                .getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());

                        ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
                        ocoDTO.setMsDtHrIni(ocorrencia.getMsDthriparada());
                        ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrfparada());

                        listaOcoDTO.add(ocoDTO);
                        mapOcorrenciasPorParada.put(idTparada, listaOcoDTO);
                    }
                }
                mapParadas.put(idTparada, paradaGraf);

            } else {                
                qtdPerdasParadaTOTAL = qtdPerdasParadaTOTAL + pcsAutoPerdaparadaCp.doubleValue();
                
                BigDecimal tempoParadas = BigDecimal.ZERO;

                if (segAutoTempoparadaCp != null)
                    tempoParadas = segAutoTempoparadaCp;

                if (segAutoTempoparadaSp != null) {
                    if (tempoParadas.doubleValue() == 0)
                        tempoParadas = segAutoTempoparadaSp;
                    else
                        tempoParadas = tempoParadas.add(segAutoTempoparadaSp);
                }

                
                if (tempoParadas.doubleValue() <= 0) {
                    continue;
                }

                // ARMAZENA O TEMPO PARADAS DE ACORDO COM CD PARADA
                BigDecimal tempoPar = mapIndicePorParada.get(idTparada);
                if (tempoPar != null) {
                    tempoPar = tempoPar.add(tempoParadas);
                    mapIndicePorParada.put(idTparada, tempoPar);
                } else {
                	tempoPar = tempoParadas;
                }

                double indiceParada = FormulasInjet.calcularIndiceParada(tempoPar, totalParadas);
                mapParadas.get(idTparada).setIndiceParada(indiceParada);

                String tempoParadasF = DataHoraRN.formatSegundosParaHHMMSS(tempoPar.intValue());
                mapParadas.get(idTparada).setTempoFormatado(tempoParadasF);
                mapParadas.get(idTparada).setTempo(tempoPar.doubleValue());
                mapParadas.get(idTparada).setQtdPerdasParada(mapParadas.get(idTparada).getQtdPerdasParada() + pcsAutoPerdaparadaCp.doubleValue());

                List<DwConsolpaoco> listaOcorrencias = getDwConsolpas(idConsolpa);

                for (DwConsolpaoco ocorrencia : listaOcorrencias) {
                    // PEGA MAIOR DATA E MENOR DATA DE TODAS AS OCORRENCIAS DE PARADAS DA CONSULTA
                    menorDthrInicioParada = getMenorDthrInicioParada(ocorrencia.getDthrIparada(), menorDthrInicioParada);
                    maiorDthrFimParada = getMaiorDthrFimParada(ocorrencia.getDthrFparada(), maiorDthrFimParada);

                    List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorParada.get(idTparada);
                    if (listaOcoDTO != null) {
                        OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
                        ocoDTO.setIdEvt(idTparada);
                        ocoDTO.setDthrIni(ocorrencia.getDthrIparada());
                        ocoDTO.setDthrFim(ocorrencia.getDthrFparada());

                        int duracaoEvt = DataHoraRN
                                .getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());

                        ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
                        ocoDTO.setMsDtHrIni(ocorrencia.getMsDthriparada());
                        ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrfparada());

                        listaOcoDTO.add(ocoDTO);
                    }
                }
            }

        }

        // Ainda falta calcular o índice de paradas baseado na quantidade de perdas por parada (o total geral de perdas nesta condi��oo é
        // calculado nesta rotina, nao vem como parâmetro

        // Areas resp
        GraficoParetoParadaAreaRespDTO areaGraf = new GraficoParetoParadaAreaRespDTO();
        HashMap<String, GraficoParetoParadaAreaRespDTO> mapAreaResp = new HashMap<String, GraficoParetoParadaAreaRespDTO>();

        Set<Long> cdsParadas = mapParadas.keySet();
        BigDecimal totalPerdaParada = BigDecimal.ZERO;
        for (Long cdParada : cdsParadas) {
            GraficoParettoParadaDTO paradaGraf = mapParadas.get(cdParada);
            totalPerdaParada = totalPerdaParada.add(new BigDecimal(paradaGraf.getQtdPerdasParada()));

            // Areas resp -- identificar e acumular
            areaGraf = mapAreaResp.get(paradaGraf.getCdArea());

            if (areaGraf == null) {
                areaGraf = new GraficoParetoParadaAreaRespDTO();
                areaGraf.setAreaResp(new DwTArea());

                //Marcos Sardinha: 2017-01-31 - tratamento para parada sem area (problema verificado na Sony)
                DwTArea areaResp = new DwTArea();
                if (paradaGraf.getIdTArea() != null) {
                    areaResp.setIdArea(paradaGraf.getIdTArea());
                    areaResp.setCdArea(paradaGraf.getCdArea());
                    areaResp.setDsArea(paradaGraf.getDsArea());
    
                    areaGraf.setAreaResp(areaResp);
                    areaGraf.setTempoParada(paradaGraf.getTempo());
                    areaGraf.setQtdPerdasParada(paradaGraf.getQtdPerdasParada());
                    areaGraf.getParadas().add(paradaGraf);
    
                    mapAreaResp.put(paradaGraf.getCdArea(), areaGraf);
                }
            } else {
                // acumula
                areaGraf.setTempoParada(areaGraf.getTempoParada() + paradaGraf.getTempo());
                areaGraf.setQtdPerdasParada(areaGraf.getQtdPerdasParada() + paradaGraf.getQtdPerdasParada());
                areaGraf.getParadas().add(paradaGraf);

                mapAreaResp.put(areaGraf.getAreaResp().getCdArea(), areaGraf);
            }

        }

        for (Long cdParada : cdsParadas) {
            GraficoParettoParadaDTO paradaGraf = mapParadas.get(cdParada);
            paradaGraf.setIndiceParadaQtdPerdasPar(FormulasInjet.calcularIndiceParada(new BigDecimal(paradaGraf.getQtdPerdasParada()), totalPerdaParada));
            
            // formatacao
            paradaGraf.setIndiceParadaQtdPerdasPar(ConversaoTipos.converterParaBigDecimal(paradaGraf.getIndiceParadaQtdPerdasPar()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            paradaGraf.setIndiceParada(ConversaoTipos.converterParaBigDecimal(paradaGraf.getIndiceParada()).setScale(2, RoundingMode.HALF_UP).doubleValue());   
            paradaGraf.setQtdPerdasParada(ConversaoTipos.converterParaBigDecimal(paradaGraf.getQtdPerdasParada()).setScale(3, RoundingMode.HALF_UP).doubleValue());   
            
        }

        // Area resp - calcular ind parada por area
        Set<String> cdsAreas = mapAreaResp.keySet();
        for (String cdArea : cdsAreas) {
            GraficoParetoParadaAreaRespDTO areaParGraf = mapAreaResp.get(cdArea);
            areaParGraf.setIndiceArea((FormulasInjet.calcularIndiceParada(new BigDecimal(areaParGraf.getQtdPerdasParada()), totalPerdaParada).doubleValue()));
            
            // formatacao
            areaParGraf.setIndiceArea(ConversaoTipos.converterParaBigDecimal(areaParGraf.getIndiceArea()).setScale(2, RoundingMode.HALF_UP).doubleValue());   
            areaParGraf.setQtdPerdasParada(ConversaoTipos.converterParaBigDecimal(areaParGraf.getQtdPerdasParada()).setScale(3, RoundingMode.HALF_UP).doubleValue());   
            
            //set null em propriedades nao usadas no front
            areaParGraf.getAreaResp().setDwTParadas(null);
            areaParGraf.getAreaResp().setDwTRefugos(null);
            areaParGraf.getAreaResp().setDwProcativs(null);
            areaParGraf.setParadas(null);
            
        }

        GrafTendenciaUtils algoritmoGraf = null;

        // MONTA O GRAFICO - NESTE MOMENTO É DEFINIDO O INTERVALO DE CORES
        if (menorDthrInicioParada != null && maiorDthrFimParada != null) {
            algoritmoGraf = new GrafTendenciaUtils(menorDthrInicioParada, maiorDthrFimParada);
        }

        GraficosParettoParadaDTO retorno = new GraficosParettoParadaDTO();
        if (algoritmoGraf != null) {
            defineCoresLegendaEBarra(algoritmoGraf, retorno, mapParadas, mapOcorrenciasPorParada);
        }

        // area resp - atribuir a retorno
        retorno.setAreas(new ArrayList<GraficoParetoParadaAreaRespDTO>());
        for (String cdArea : cdsAreas) {
            GraficoParetoParadaAreaRespDTO areaParGraf = mapAreaResp.get(cdArea);
            retorno.getAreas().add(areaParGraf);
        }

        return retorno;

    }



    public GraficosParettoParadaDTO getMaiorParadaCPWM(List<Object> listaIdsCns) {
        Double qtdPerdasParadaTOTAL = 0d;
        BigDecimal totalParadas = BigDecimal.ZERO;
        
        final int _idConsolpa = 0;
        final int _idTparada = 1;
        final int _cdTparada = 2;
        final int _dsTparada = 3;
        final int _ispesa = 4;

        final int _idTarea = 5;
        final int _cdTarea = 6;
        final int _dsTarea = 7;

        final int _segAutoTempoparadaCp = 8;
        final int _segAutoTempoparadaSp = 9;

        final int _pcsAutoPerdaparadaCp = 10;
        final int _pcsAutoPerdaparadaSp = 11;

        Date menorDthrInicioParada = null;
        Date maiorDthrFimParada = null;

        HashMap<Long, GraficoParettoParadaDTO> mapParadas = new HashMap<Long, GraficoParettoParadaDTO>();
        HashMap<Long, List<OcorrenciasEvtDTO>> mapOcorrenciasPorParada = new HashMap<Long, List<OcorrenciasEvtDTO>>();
        HashMap<Long, List<DwConsolpaoco>> mapOcorrenciasPorParadaAberta = new HashMap<Long, List<DwConsolpaoco>>();        
        HashMap<Long, BigDecimal> mapIndicePorParada = new HashMap<Long, BigDecimal>();

        List<Object> listaParadasFechadas = consultaParadasFechadasCPWM(listaIdsCns);

        // Calcular o tempo de parada ou quantidade perdida para se calcular o indice de parada
        totalParadas = BigDecimal.ZERO;
        for (Object reg : listaParadasFechadas) {
            Object[] registro = (Object[]) reg;
            BigDecimal segAutoTempoparadaCp = (BigDecimal) registro[_segAutoTempoparadaCp]; 
            
            if (segAutoTempoparadaCp != null) {
                totalParadas = totalParadas.add(segAutoTempoparadaCp);            	
            }
        }

        Boolean isProcessouParadaAberta = false;
        
        for (Object reg : listaParadasFechadas) {

            Object[] registro = (Object[]) reg;
            Long idConsolpa = (Long) registro[_idConsolpa];
            Long idTparada = (Long) registro[_idTparada];
            String cdParada = (String) registro[_cdTparada];
            String dsParada = (String) registro[_dsTparada];

            Long idTarea = (Long) registro[_idTarea];
            String cdArea = (String) registro[_cdTarea];
            String dsArea = (String) registro[_dsTarea];
            
            Boolean isPesa = (Boolean) registro[_ispesa];
            BigDecimal segAutoTempoparadaCp = (BigDecimal) registro[_segAutoTempoparadaCp]; 
            BigDecimal pcsAutoPerdaparadaCp = (BigDecimal) registro[_pcsAutoPerdaparadaCp]; 

            if (pcsAutoPerdaparadaCp ==  null){
                pcsAutoPerdaparadaCp = BigDecimal.ZERO;
            }

             GraficoParettoParadaDTO paradaGraf = mapParadas.get(idTparada);
            
            if (paradaGraf == null) {
                // parada
                paradaGraf = new GraficoParettoParadaDTO();
                paradaGraf.setIdTParada(idTparada);
                paradaGraf.setCdParada(cdParada);
                paradaGraf.setIdTArea(idTarea);
                paradaGraf.setCdArea(cdArea);
                paradaGraf.setDsArea(dsArea);
                paradaGraf.setDsParada(dsParada.toUpperCase()); 

                BigDecimal tempoParadas = BigDecimal.ZERO;

                if (segAutoTempoparadaCp != null) {
                    tempoParadas = segAutoTempoparadaCp;
                }
                
                if (tempoParadas.doubleValue() <= 0) {
                    continue;
                }

                // ARMAZENA O TEMPO PARADAS DE ACORDO COM CD PARADA
                BigDecimal tempoPar = mapIndicePorParada.get(idTparada);
                if (tempoPar == null) {
                    tempoPar = tempoParadas;
                    mapIndicePorParada.put(idTparada, tempoPar);
                }

                double indiceParada = FormulasInjet.calcularIndiceParada(tempoParadas, totalParadas);
                
                paradaGraf.setIndiceParada(indiceParada);

                String tempoParadasF = DataHoraRN.formatMilisegundosParaHHMMSSmmm(tempoParadas.multiply(new BigDecimal(1000)).longValue());
                paradaGraf.setTempoFormatado(tempoParadasF);
                paradaGraf.setTempo(tempoParadas.doubleValue());
                paradaGraf.setQtdPerdasParada(pcsAutoPerdaparadaCp.doubleValue());
                
                List<DwConsolpaoco> listaOcorrencias = getDwConsolpas(idConsolpa);
                
                // Se o idConsolpa for zero eh pq eh uma parada em aberto. Assim ireimos criar uma oco ficticia
                if ( (idConsolpa.equals(0l) && isProcessouParadaAberta == false)) {
                    isProcessouParadaAberta = true;
                    
                    Set<Long> cdsParadasAbertas = mapOcorrenciasPorParadaAberta.keySet();
                    for (Long cdParadaAberta : cdsParadasAbertas) {
                        for(DwConsolpaoco ocor : mapOcorrenciasPorParadaAberta.get(cdParadaAberta)){
                            listaOcorrencias.add(ocor);                            
                        }
                    }
                }

                qtdPerdasParadaTOTAL = qtdPerdasParadaTOTAL + pcsAutoPerdaparadaCp.doubleValue();

                
                // SARDINHA: varre lista de ocorrencias e calcula as perdas por parada (necessário na ficha da máquina padr�o Injet)
                for (DwConsolpaoco ocorrencia : listaOcorrencias) {
                	/* Alessandre em 3-3-17. Se a ocorrencia nao tiver data de fim esta inconsistente
                	 * 
                	 */
                	if (ocorrencia.getDthrFparada() == null)
                		continue;
                	
                    // PEGA MAIOR DATA E MENOR DATA DE TODAS AS OCORRENCIAS DE PARADAS DA CONSULTA
                    menorDthrInicioParada = getMenorDthrInicioParada(ocorrencia.getDthrIparada(), menorDthrInicioParada);
                    Date dtf = ocorrencia.getDthrFparada();
                    if (dtf == null)
                        dtf = ocorrencia.getDwConsolpa().getDwConsol().getDwConsolid().getDthrFturno();
                    if (DataHoraRN.after(dtf, DataHoraRN.getDataHoraAtual()))
                        dtf = DataHoraRN.getDataHoraAtual();
                    maiorDthrFimParada = getMaiorDthrFimParada(dtf, maiorDthrFimParada);

                    List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorParada.get(idTparada);
                    if (listaOcoDTO == null) {
                        listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
                        OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
                        ocoDTO.setIdEvt(idTparada); // verificar
                        ocoDTO.setDthrIni(ocorrencia.getDthrIparada());
                        ocoDTO.setDthrFim(ocorrencia.getDthrFparada());

                        int duracaoEvt = DataHoraRN
                                .getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());
                        ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
                        ocoDTO.setMsDtHrIni(ocorrencia.getMsDthriparada());
                        ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrfparada());

                        listaOcoDTO.add(ocoDTO);
                        mapOcorrenciasPorParada.put(idTparada, listaOcoDTO);

                    } else {
                        OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
                        ocoDTO.setIdEvt(idTparada); // veririficar
                        ocoDTO.setDthrIni(ocorrencia.getDthrIparada());
                        ocoDTO.setDthrFim(ocorrencia.getDthrFparada());

                        int duracaoEvt = DataHoraRN
                                .getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());

                        ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
                        ocoDTO.setMsDtHrIni(ocorrencia.getMsDthriparada());
                        ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrfparada());

                        listaOcoDTO.add(ocoDTO);
                        mapOcorrenciasPorParada.put(idTparada, listaOcoDTO);
                    }
                }
                mapParadas.put(idTparada, paradaGraf);

            } else {                
                qtdPerdasParadaTOTAL = qtdPerdasParadaTOTAL + pcsAutoPerdaparadaCp.doubleValue();
                
                BigDecimal tempoParadas = BigDecimal.ZERO;

                if (segAutoTempoparadaCp != null) {
                    tempoParadas = segAutoTempoparadaCp;
                }
               
                if (tempoParadas.doubleValue() <= 0) {
                    continue;
                }

                // ARMAZENA O TEMPO PARADAS DE ACORDO COM CD PARADA
                BigDecimal tempoPar = mapIndicePorParada.get(idTparada);
                if (tempoPar != null) {
                    tempoPar = tempoPar.add(tempoParadas);
                    mapIndicePorParada.put(idTparada, tempoPar);
                } else {
                	tempoPar = tempoParadas;
                }

                double indiceParada = FormulasInjet.calcularIndiceParada(tempoPar, totalParadas);
                mapParadas.get(idTparada).setIndiceParada(indiceParada);

                String tempoParadasF = DataHoraRN.formatSegundosParaHHMMSS(tempoPar.intValue());
                mapParadas.get(idTparada).setTempoFormatado(tempoParadasF);
                mapParadas.get(idTparada).setTempo(tempoPar.doubleValue());
                mapParadas.get(idTparada).setQtdPerdasParada(mapParadas.get(idTparada).getQtdPerdasParada() + pcsAutoPerdaparadaCp.doubleValue());

                List<DwConsolpaoco> listaOcorrencias = getDwConsolpas(idConsolpa);

                for (DwConsolpaoco ocorrencia : listaOcorrencias) {
                    // PEGA MAIOR DATA E MENOR DATA DE TODAS AS OCORRENCIAS DE PARADAS DA CONSULTA
                    menorDthrInicioParada = getMenorDthrInicioParada(ocorrencia.getDthrIparada(), menorDthrInicioParada);
                    maiorDthrFimParada = getMaiorDthrFimParada(ocorrencia.getDthrFparada(), maiorDthrFimParada);

                    List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorParada.get(idTparada);
                    if (listaOcoDTO != null) {
                        OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
                        ocoDTO.setIdEvt(idTparada);
                        ocoDTO.setDthrIni(ocorrencia.getDthrIparada());
                        ocoDTO.setDthrFim(ocorrencia.getDthrFparada());

                        int duracaoEvt = DataHoraRN
                                .getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());

                        ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
                        ocoDTO.setMsDtHrIni(ocorrencia.getMsDthriparada());
                        ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrfparada());

                        listaOcoDTO.add(ocoDTO);
                    }
                }
            }

        }

        // Ainda falta calcular o índice de paradas baseado na quantidade de perdas por parada (o total geral de perdas nesta condi��oo é
        // calculado nesta rotina, nao vem como parâmetro

        // Areas resp
        GraficoParetoParadaAreaRespDTO areaGraf = new GraficoParetoParadaAreaRespDTO();
        HashMap<String, GraficoParetoParadaAreaRespDTO> mapAreaResp = new HashMap<String, GraficoParetoParadaAreaRespDTO>();

        Set<Long> cdsParadas = mapParadas.keySet();
        BigDecimal totalPerdaParada = BigDecimal.ZERO;
        for (Long cdParada : cdsParadas) {
            GraficoParettoParadaDTO paradaGraf = mapParadas.get(cdParada);
            totalPerdaParada = totalPerdaParada.add(new BigDecimal(paradaGraf.getQtdPerdasParada()));

            // Areas resp -- identificar e acumular
            areaGraf = mapAreaResp.get(paradaGraf.getCdArea());

            if (areaGraf == null) {
                areaGraf = new GraficoParetoParadaAreaRespDTO();
                areaGraf.setAreaResp(new DwTArea());

                //Marcos Sardinha: 2017-01-31 - tratamento para parada sem area (problema verificado na Sony)
                DwTArea areaResp = new DwTArea();
                if (paradaGraf.getIdTArea() != null) {
                    areaResp.setIdArea(paradaGraf.getIdTArea());
                    areaResp.setCdArea(paradaGraf.getCdArea());
                    areaResp.setDsArea(paradaGraf.getDsArea());
    
                    areaGraf.setAreaResp(areaResp);
                    areaGraf.setTempoParada(paradaGraf.getTempo());
                    areaGraf.setQtdPerdasParada(paradaGraf.getQtdPerdasParada());
                    areaGraf.getParadas().add(paradaGraf);
    
                    mapAreaResp.put(paradaGraf.getCdArea(), areaGraf);
                }
            } else {
                // acumula
                areaGraf.setTempoParada(areaGraf.getTempoParada() + paradaGraf.getTempo());
                areaGraf.setQtdPerdasParada(areaGraf.getQtdPerdasParada() + paradaGraf.getQtdPerdasParada());
                areaGraf.getParadas().add(paradaGraf);

                mapAreaResp.put(areaGraf.getAreaResp().getCdArea(), areaGraf);
            }

        }

        for (Long cdParada : cdsParadas) {
            GraficoParettoParadaDTO paradaGraf = mapParadas.get(cdParada);
            paradaGraf.setIndiceParadaQtdPerdasPar(FormulasInjet.calcularIndiceParada(new BigDecimal(paradaGraf.getQtdPerdasParada()),
                    totalPerdaParada).doubleValue());
        }

        // Area resp - calcular ind parada por area
        Set<String> cdsAreas = mapAreaResp.keySet();
        for (String cdArea : cdsAreas) {
            GraficoParetoParadaAreaRespDTO areaParGraf = mapAreaResp.get(cdArea);
            areaParGraf.setIndiceArea((FormulasInjet.calcularIndiceParada(new BigDecimal(areaParGraf.getQtdPerdasParada()),
                    totalPerdaParada).doubleValue()));
        }

        GrafTendenciaUtils algoritmoGraf = null;

        // MONTA O GRAFICO - NESTE MOMENTO É DEFINIDO O INTERVALO DE CORES
        if (menorDthrInicioParada != null && maiorDthrFimParada != null) {
            algoritmoGraf = new GrafTendenciaUtils(menorDthrInicioParada, maiorDthrFimParada);
        }

        GraficosParettoParadaDTO retorno = new GraficosParettoParadaDTO();
        if (algoritmoGraf != null) {
            defineCoresLegendaEBarra(algoritmoGraf, retorno, mapParadas, mapOcorrenciasPorParada);
        }

        // area resp - atribuir a retorno
        retorno.setAreas(new ArrayList<GraficoParetoParadaAreaRespDTO>());
        for (String cdArea : cdsAreas) {
            GraficoParetoParadaAreaRespDTO areaParGraf = mapAreaResp.get(cdArea);
            retorno.getAreas().add(areaParGraf);
        }

        Collections.sort(retorno.getParadas(), comparaPorTempo);
        
        return retorno;

    }


	private List<Object> consultaParadasFechadasCPWM(List<Object> listaIdsCns) {
		MapQuery q = new MapQuery(getDaoSession());
		
		
		//sub query com lista de idconsolpa
		q.append("SELECT DISTINCT dwconsolpa.idConsolpa");	
        q.append("FROM DwConsolpa dwconsolpa");
        q.append("JOIN dwconsolpa.dwConsol dwconsol");
        q.append("JOIN dwconsol.dwConsolid dwconsolid");
        q.append("join dwconsolid.omPt ompt");
        q.append("JOIN dwconsolpa.dwTParada dwtparada");
        q.append("LEFT JOIN dwtparada.dwTArea dwtarea");
        q.append("LEFT JOIN dwconsolid.ppCp ppcp");
        q.append("LEFT JOIN ppcp.ppCpprodutos ppcpprodutos"); 
        q.append("WHERE dwtparada.isPesa = :ispesa");        
        q.append(" AND dwconsolid.idConsolid IN (:listaIds)");                
        
        q.defineParametro("ispesa", true); 
        q.defineListaParametro("listaIds", listaIdsCns);
         
        
        List<Object> listaParadasFechadas = q.list();

        String listaIds = listaParadasFechadas.toString();
        listaIds = listaIds.replace("[", "");
        listaIds = listaIds.replace("]", "");
        
        if (listaIds.trim().equals("")) {
            listaParadasFechadas = new ArrayList<Object>();        	
        } else {
            q = new MapQuery(getDaoSession());
    		
            q.append("SELECT ");
            q.append("dwconsolpa.idConsolpa,");
            q.append("dwtparada.idTparada,");
            q.append("dwtparada.cdTparada,");
            q.append("dwtparada.dsTparada,");
            q.append("dwtparada.isPesa,");
            q.append("dwtarea.idArea, dwtarea.cdArea, dwtarea.dsArea, ");
            q.append("SUM(dwconsolpa.segAutoTempoparadaCp),");
            q.append("SUM(dwconsolpa.segAutoTempoparadaSp),");
            q.append("SUM(dwconsolpa.pcsAutoPerdaparadaCp),");
            q.append("SUM(dwconsolpa.pcsAutoPerdaparadaSp)");
            q.append("FROM DwConsolpa dwconsolpa");
            q.append("JOIN dwconsolpa.dwTParada dwtparada");
            q.append("LEFT JOIN dwtparada.dwTArea dwtarea");
    		q.append("WHERE dwconsolpa.idConsolpa IN (" + listaIds + ")");
            q.append("GROUP BY dwconsolpa.idConsolpa, dwtparada.idTparada, dwtparada.cdTparada, dwtparada.dsTparada, dwtparada.isPesa, dwtarea.idArea, dwtarea.cdArea, dwtarea.dsArea");
    		        
            listaParadasFechadas = q.list();
        }
        
		return listaParadasFechadas;
	}
	
	
	public static final Comparator<GraficoParettoParadaDTO> comparaPorTempo = new Comparator<GraficoParettoParadaDTO>() {
		@Override
        public int compare(GraficoParettoParadaDTO o1, GraficoParettoParadaDTO o2) {
			return o1.getTempo().compareTo(o2.getTempo()) * -1;
        }
    };
    

}
