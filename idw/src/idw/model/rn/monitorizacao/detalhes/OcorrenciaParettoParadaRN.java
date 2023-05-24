package idw.model.rn.monitorizacao.detalhes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpalogtec;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwTArea;
import idw.model.pojos.OmCfg;
import idw.model.pojos.template.DwConsolpalogtecTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.util.FormulasInjet;
import idw.util.Util;
import idw.webservices.dto.DetalhamentoParadaDTO;
import idw.webservices.dto.DetalheParadaDTO;

public class OcorrenciaParettoParadaRN extends AbstractRN<DAOGenerico> {

    public OcorrenciaParettoParadaRN() {
        super(new DAOGenerico());
    }

    public OcorrenciaParettoParadaRN(DAOGenerico dao) {
        super(dao);
    }

    public DetalhamentoParadaDTO getOcorrenciaParettoParadaDTO(Date dtReferencia, BigDecimal idTurno, BigDecimal idPt, Boolean isComPeso,
            Boolean isSemPeso, String cdParada) {

        DetalhamentoParadaDTO retorno = new DetalhamentoParadaDTO();
        List<DetalheParadaDTO> listaparadas = new ArrayList<DetalheParadaDTO>();
        MapQuery q = new MapQuery(getDaoSession());

        q.append("select");
        q.append("e.cdTparada,");
        q.append("e.dsTparada,");
        q.append("f.cdTacao,");
        q.append("f.dsTacao,");
        q.append("h.cdArea,");
        q.append("h.dsArea,");
        q.append("i.cdTcausa,");
        q.append("i.dsTcausa,");
        q.append("a.dthrIparada,");
        q.append("a.dthrFparada,");
        q.append("j.cdTjust,");
        q.append("j.dsTjust,");
        q.append("ompt.cdPt,");
        q.append("ompt.dsPt,");
        q.append("dwrap.cdRap,");
        q.append("dwturno.cdTurno");
        q.append("from DwConsolpaoco a");
        q.append("join a.dwConsolpa b");
        q.append("join b.dwConsol c");
        q.append("join c.dwConsolid d");
        q.append("join b.dwTParada e");
        q.append("join a.dwConsolpalog g");
        q.append("join d.omPt ompt");
        q.append("join d.dwFolha dwfolha");
        q.append("left join dwfolha.dwFolharaps dwfolharap");
        q.append("left join dwfolharap.dwRap dwrap");
        q.append("join d.dwTurno dwturno");
        q.append("left join a.dwTAcao f");
        q.append("left join e.dwTArea h");
        q.append("left join a.dwTCausa i");
        q.append("left join a.dwTJust j");
        q.append("where d.dtReferencia = :dtreferencia");
        q.append("and d.dwTurno.idTurno = :idturno");
        q.append("and d.stAtivo is null");
        q.append("and d.tpId = 1");
        q.append("and ompt.idPt = :idpt");

        if (cdParada != null && cdParada.equals("") == false) {
            q.append("and e.cdTparada = :cdparada");
            q.defineParametro("cdparada", cdParada);
        }

        q.defineParametro("dtreferencia", dtReferencia);
        q.defineParametro("idturno", idTurno.longValue());
        q.defineParametro("idpt", idPt.longValue());

        List<Object> lista = q.list();

        double totalDuracao = 0d;

        for (Object reg : lista) {
            Object[] registro = (Object[]) reg;

            DetalheParadaDTO detalhe = new DetalheParadaDTO();

            DwTArea area = new DwTArea();
            // Se a area nao for definida no cadastrado, retornar vazia
            if (registro[4] != null) {
                area.setCdArea(registro[4].toString());
                area.setDsArea(registro[5].toString());
            } else {
                area.setCdArea("");
                area.setDsArea("");
            }

            Date dti = (Date) registro[8];
            Date dtf = (Date) registro[9];

            if (registro[2] != null)
                detalhe.setAcao(registro[2] + "-" + registro[3]);
            else
                detalhe.setAcao("");

            detalhe.setArea_resp(area);

            if (registro[6] != null)
                detalhe.setCausa(registro[6] + "-" + registro[7]);
            else
                detalhe.setCausa("");

            long duracao = DataHoraRN.getQuantidadeMilisegundosNoPeriodo(dti, dtf);
            totalDuracao += (duracao / 1000);

            detalhe.setDuracao(DataHoraRN.formatMilisegundosParaHHMMSSmmm(duracao));
            detalhe.setDuracaoEmSegundos((double) duracao / 1000);
            if (registro[14] != null)
            	detalhe.setFerramenta(registro[14].toString());
            else
            	detalhe.setFerramenta("---");
            detalhe.setFim(dtf);
            detalhe.setInicio(dti);

            if (registro[10] != null)
                detalhe.setJustificativa(registro[10] + "-" + registro[11]);
            else
                detalhe.setJustificativa("");

            detalhe.setMaquina(registro[12].toString());
            detalhe.setDsPt(registro[13].toString());

            if (registro[0] != null)
                detalhe.setParada(registro[0] + "-" + registro[1]);
            else
                detalhe.setParada("");

            detalhe.setPerdas_paradas(0d);
            detalhe.setTecnico1(null);
            detalhe.setTecnico2(null);
            detalhe.setTecnico_responsavel(null);
            detalhe.setTurno(registro[15].toString());

            listaparadas.add(detalhe);
        }
        retorno.setDuracaoParadas(DataHoraRN.formatSegundosParaHHMMSS((int) totalDuracao));
        retorno.setListaparadas(listaparadas);
        return retorno;
    }

    public DetalhamentoParadaDTO getOcorrenciaParetoParadaFichaMaqDTO(Byte tpId, Date dtInicial, Date dtFinal, BigDecimal idTurno,
            String cdPt, String cdGt, String cdCp, Boolean isComPeso, Boolean isSemPeso, String cdParada, String cdArea, Integer filtroOp) {

        DetalhamentoParadaDTO retorno = new DetalhamentoParadaDTO();
        List<DetalheParadaDTO> listaparadas = new ArrayList<DetalheParadaDTO>();
        MapQuery q = new MapQuery(getDaoSession());

        q.append("select");
        q.append("e.cdTparada,"); // 0
        q.append("e.dsTparada,"); // 1
        q.append("f.cdTacao,"); // 2
        q.append("f.dsTacao,"); // 3
        q.append("h.cdArea,"); // 4
        q.append("h.dsArea,"); // 5
        q.append("i.cdTcausa,"); // 6
        q.append("i.dsTcausa,"); // 7
        q.append("a.dthrIparada,"); // 8
        q.append("a.dthrFparada,"); // 9
        q.append("j.cdTjust,"); // 10
        q.append("j.dsTjust,"); // 11
        q.append("ompt.cdPt,"); // 12
        q.append("ompt.dsPt,"); // 13
        q.append("dwrap.cdRap,"); // 14
        q.append("dwturno.cdTurno,"); // 15
        q.append("d.dthrIturno,"); // 16
        q.append("d.dthrFturno,"); // 17
        q.append("g.idConsolpalog,"); // 18
        q.append("dwfolha.idFolha,"); // 19
        q.append("e.isPesa,"); // 20
        q.append("dwfolha.cdFolha,"); // 21
        q.append("c.qtAutoCavativas,"); //22
        q.append("c.segAutoCiclopadrao"); //23
        q.append("from DwConsolpaoco a");
        q.append("join a.dwConsolpa b");
        q.append("join b.dwConsol c");
        q.append("join c.dwConsolid d");

        // Marcos Sardinha: 2016-11-03 - Mapa das OPs
        if (filtroOp == 3 && !cdCp.equals("") && !cdCp.equals(null)) {
            q.append("join d.ppCp p");
            //q.append("join p.ppCpprodutos pr");
        }

        q.append("join b.dwTParada e");
        q.append("join a.dwConsolpalog g");
        q.append("join d.omPt ompt");
        q.append("join d.dwFolha dwfolha");
        q.append("left join dwfolha.dwFolharaps dwfolharap");
        q.append("left join dwfolharap.dwRap dwrap");
        q.append("join d.dwTurno dwturno");
        q.append("left join a.dwTAcao f");
        q.append("left join e.dwTArea h");
        q.append("left join a.dwTCausa i");
        q.append("left join a.dwTJust j");
        q.append("where d.stAtivo is null");
        q.append("and d.tpId = :tpid");

        
        // Alessandre em 19-01-15 acrescentei um novo parametro ao metodo, cdGt, isso pq o BI do INSERT tambem chama o grafico de paradas,
        // mas considerando apenas o GT sem o PT
        if (cdGt != null && cdGt.equals("") == false) {
            q.append("and exists (from OmObj omobj where omobj.omGtByIdGt.cdGt = '" + cdGt + "' and omobj.omPt = ompt)");
        }

        if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO)) {
            // data
            if (dtInicial != null) {
                q.append("AND d.dtReferencia between :dtinicial and :dtfinal");
            }

            // turno
            if (idTurno != null && idTurno.equals(BigDecimal.ZERO) == false) {
                q.append("AND d.dwTurno.idTurno = :idturno");
            } else {
                // Alessandre em 27-02-15 coloquei esse filtro para na semp nao mostrar as ocorrencias do turno indefinido
                // o ideal eh mudar o filtor do bi para escolher quais turnos entrarao
                q.append("and d.dwTurno.idTurno <> 1");
            }
        }

        // máquina
        if (!cdPt.equals("") && !cdPt.equals(null)) {
            q.append("AND d.omPt.cdPt = :cdpt");
        }

        // op
        if (!cdCp.equals("") && !cdCp.equals(null)) {
            q.append("AND d.ppCp.cdCp = :cdcp");
        }

        // paradas
        if (isComPeso == true && isSemPeso == false) {
            q.append("AND e.isPesa = :isPesa");
        } else if (isComPeso == false && isSemPeso == true) {
            q.append("AND e.isPesa = :isPesa");
        }

        // filtro de parada
        if (cdParada != null && cdParada.equals("") == false) {
            q.append("and e.cdTparada = :cdparada");
        }

        if (cdArea != null && cdArea.equals("") == false) {
            q.append("and h.cdArea = :cdarea");
        }

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

		if (!cdPt.equals("") && !cdPt.equals(null)) {
			q.defineParametro("cdpt", cdPt);
		}

        // op
        if (!cdCp.equals("") && !cdCp.equals(null)) {
            q.defineParametro("cdcp", cdCp);
        }

        // filtro de parada
        if (cdParada != null && cdParada.equals("") == false) {
            q.defineParametro("cdparada", cdParada);
        }

        // paradas
        if (isComPeso == true && isSemPeso == false) {
            q.defineParametro("isPesa", true);
        } else if (isComPeso == false && isSemPeso == true) {
            q.defineParametro("isPesa", false);
        }

        if (cdArea != null && cdArea.equals("") == false) {
            q.defineParametro("cdarea", cdArea);
        }

        if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_ACUMULADO)|| tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP))
            q.defineParametro("tpid", DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_ACUMULADO);
        else
            q.defineParametro("tpid", DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO);

        List<Object> lista = q.list();

        Date dthrITurno = null;
        Date dthrFTurno = null;

        // Esse loop ira identificar o inicio e fim do turno
        for (Object reg : lista) {
            Object[] registro = (Object[]) reg;
            Date dti = (Date) registro[16];
            Date dtf = (Date) registro[17];
            if (dthrITurno == null || DataHoraRN.before(dti, dthrITurno))
                dthrITurno = dti;

            if (dthrFTurno == null || DataHoraRN.after(dtf, dthrFTurno))
                dthrFTurno = dtf;

        }
        
        // Marcos Sardinha: 2017-06-21 >> tem que considerar Cp quando for informado
        
        // Se lista for vazio entao procurar qual o turno inicio e fim para possivel parada em aberto
         
        if (dthrITurno == null) {
            MapQuery q2 = new MapQuery(getDaoSession());
            q2.append("select a");
            q2.append("from DwConsolid a");
            q2.append("join a.omPt ompt");
            q2.append("where a.tpId = 1");
            
            if (!cdCp.equals("") && !cdCp.equals(null)) {
                q2.append("  and a.ppCp.cdCp = :cdcp");
            }
            

            if (cdGt != null && cdGt.equals("") == false) {
                q2.append("and exists (from OmObj omobj where omobj.omGtByIdGt.cdGt = '" + cdGt + "' and omobj.omPt = ompt)");
            }

            if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO)) {
                // data
                if (dtInicial != null) {
                    q2.append("AND a.dtReferencia between :dtinicial and :dtfinal");
                }

                // turno
                if (idTurno != null && idTurno.equals(BigDecimal.ZERO) == false) {
                    q2.append("AND a.dwTurno.idTurno = :idturno");
                } else {
                    // Alessandre em 27-02-15 coloquei esse filtro para na semp nao mostrar as ocorrencias do turno indefinido
                    // o ideal eh mudar o filtor do bi para escolher quais turnos entrarao
                    q2.append("and a.dwTurno.idTurno <> 1");
                }
            }
            
            q2.defineParametroData("dtinicial", dtInicial);
            q2.defineParametroData("dtfinal", dtFinal);
            q2.defineParametro("idturno", idTurno.longValue());
            
            if (!cdCp.equals("") && !cdCp.equals(null)) {
            	q2.defineParametro("cdcp", cdCp);
            }

            List<DwConsolid> listaConsolids = q2.list();
            for (DwConsolid id : listaConsolids) {
                if (dthrITurno == null || DataHoraRN.before(id.getDthrIturno(), dthrITurno))
                    dthrITurno = id.getDthrIturno();

                if (dthrFTurno == null || DataHoraRN.after(id.getDthrFturno(), dthrFTurno))
                    dthrFTurno = id.getDthrFturno();


            }
        }

        
        /*
         * Alessandre em 23-07-15 avaliar se existe uma parada em aberto que atenda o filtro Se sim adicionar no vetor lista
         */
        
        
        //Marcos Sardinha: 2017-06-21 >> quando montagem for por op tem que recuperar pts da OP
		Map<String, String> mapCdPts = new HashMap<String, String>();
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
        
        
        double totalDuracao = 0d;
        /*
         * Esse loop ira preparar o retorno do webservice
         */
        for (Object reg : lista) {
            Object[] registro = (Object[]) reg;

            DetalheParadaDTO detalhe = new DetalheParadaDTO();

            DwTArea area = new DwTArea();
            // Se a area nao for definida no cadastrado, retornar vazia
            if (registro[4] != null) {
                area.setCdArea(registro[4].toString());
                area.setDsArea(registro[5].toString());
            } else {
                area.setCdArea("");
                area.setDsArea("");
            }

            Date dti = (Date) registro[8];
            Date dtf = (Date) registro[9];

            if (registro[2] != null && registro[3] != null && registro[2] != "" && registro[3] != "")
                detalhe.setAcao(registro[2] + "-" + registro[3]);
            else
                detalhe.setAcao("");

            detalhe.setArea_resp(area);

            if (registro[6] != null && registro[7] != null && registro[6] != "" && registro[7] != "")
                detalhe.setCausa(registro[6] + "-" + registro[7]);
            else
                detalhe.setCausa("");

            double duracao = (double) DataHoraRN.getQuantidadeMilisegundosNoPeriodo(dti, dtf);
            totalDuracao += (duracao / 1000d);

            detalhe.setDuracao(DataHoraRN.formatMilisegundosParaHHMMSSmmm((long)duracao));
            detalhe.setDuracaoEmSegundos((double) duracao / 1000);
            if (registro[14] != null)
            	detalhe.setFerramenta(registro[14].toString());
            else
            	detalhe.setFerramenta("");
            
            if (registro[21] != null) {
            	detalhe.setFolha(registro[21].toString());
            } else {
            	detalhe.setFolha("");
            }
            
            detalhe.setFim(dtf);
            detalhe.setInicio(dti);

            if (registro[10] != null && registro[11] != null && registro[10] != "" && registro[11] != "")
                detalhe.setJustificativa(registro[10] + "-" + registro[11]);
            else
                detalhe.setJustificativa("");

            detalhe.setMaquina(registro[12].toString());
            detalhe.setDsPt(registro[13].toString());

            if (registro[0] != null)
                detalhe.setParada(registro[0] + "-" + registro[1]);
            else
                detalhe.setParada("");

            // Caluclar a perda na parada
            // A perda na parada eh o tempo da parada / ciclo padrao * producao por ciclo
            DwFolha dwfolha = getDao().findById(DwFolha.class, (Long) registro[19], false);
            if (dwfolha != null) {

                BigDecimal qtPcsCicloAtivas = (BigDecimal) registro[22]; 
                BigDecimal cicloPadrao = (BigDecimal) registro[23]; 

                if (qtPcsCicloAtivas == null)  {
                    FolhaRN folhaRN = new FolhaRN(getDao());
                    try {
                        qtPcsCicloAtivas = folhaRN.getPcsPorCicloAtivas(dwfolha);
                    } catch (Exception e) {
                        qtPcsCicloAtivas = BigDecimal.ONE;
                    }
                }
                double perdaNaParada = FormulasInjet.calcularPcsPerdaParada(new BigDecimal(duracao / 1000), cicloPadrao,
                        qtPcsCicloAtivas).doubleValue();
                
                
                if (registro[20] != null && ((boolean) registro[20]) == true)
                    detalhe.setPerdas_paradas(perdaNaParada);
                else
                    detalhe.setPerdas_paradas(0d);
            } else {
                detalhe.setPerdas_paradas(0d);
            }

            /*
             * Obtem a lista de tecnicos logados na parada
             */
            DwConsolpalog palog;
            try {
                palog = getDao().findById(DwConsolpalog.class, (Long) registro[18], false);
            } catch (ArrayIndexOutOfBoundsException e) {
                palog = null;
            }
            if (palog != null) {
                List<DwConsolpalogtec> listatec = new ArrayList<>(palog.getDwConsolpalogtecs());
                Collections.sort(listatec, new Comparator<DwConsolpalogtec>() {
                    @Override
                    public int compare(DwConsolpalogtec o1, DwConsolpalogtec o2) {
                        return o1.getIdConsolpalogtec().compareTo(o2.getIdConsolpalogtec());
                    }
                });
                for (DwConsolpalogtec tec : listatec) {
                	if (tec.getTpUsuario() != null && tec.getTpUsuario().equals(DwConsolpalogtecTemplate._TpUsuario.TECRESP.getValue()))
                        detalhe.setTecnico_responsavel(tec.getOmUsr().getCdUsr() + "-" + tec.getOmUsr().getDsNome());
                	if (tec.getTpUsuario() != null && tec.getTpUsuario().equals(DwConsolpalogtecTemplate._TpUsuario.TEC1.getValue()))
                        detalhe.setTecnico1(tec.getOmUsr().getCdUsr() + "-" + tec.getOmUsr().getDsNome());
                	if (tec.getTpUsuario() != null && tec.getTpUsuario().equals(DwConsolpalogtecTemplate._TpUsuario.TEC2.getValue()))
                        detalhe.setTecnico2(tec.getOmUsr().getCdUsr() + "-" + tec.getOmUsr().getDsNome());
                }
            }
            detalhe.setTurno(registro[15].toString());

            // Somente se a duracao for positiva
            if (duracao > 0d)
                listaparadas.add(detalhe);
        }
        retorno.setDuracaoParadas(DataHoraRN.formatSegundosParaHHMMSS( (int) totalDuracao));
        retorno.setListaparadas(listaparadas);
        return retorno;
    }

    public DetalhamentoParadaDTO getOcorrenciaBIParettoParadaDTO(Date dtInicial, Date dtFinal, BigDecimal idTurno, BigDecimal idPt,
            BigDecimal idGt, Boolean isComPeso, Boolean isSemPeso, BigDecimal totalParadas, String cdParada) {

        DetalhamentoParadaDTO retorno = new DetalhamentoParadaDTO();
        List<DetalheParadaDTO> listaparadas = new ArrayList<DetalheParadaDTO>();
        MapQuery q = new MapQuery(getDaoSession());

        q.append("select");
        q.append("e.cdTparada,");
        q.append("e.dsTparada,");
        q.append("f.cdTacao,");
        q.append("f.dsTacao,");
        q.append("h.cdArea,");
        q.append("h.dsArea,");
        q.append("i.cdTcausa,");
        q.append("i.dsTcausa,");
        q.append("a.dthrIparada,");
        q.append("a.dthrFparada,");
        q.append("j.cdTjust,");
        q.append("j.dsTjust,");
        q.append("ompt.cdPt,");
        q.append("ompt.dsPt,");
        q.append("dwrap.cdRap");
        q.append("from DwConsolpaoco a");
        q.append("join a.dwConsolpa b");
        q.append("join b.dwConsol c");
        q.append("join c.dwConsolid d");
        q.append("join b.dwTParada e");
        q.append("join a.dwConsolpalog g");
        q.append("join d.omPt ompt");
        q.append("join d.dwFolha dwfolha");
        q.append("left join dwfolha.dwFolharaps dwfolharap");
        q.append("left join dwfolharap.dwRap dwrap");
        q.append("left join a.dwTAcao f");
        q.append("left join e.dwTArea h");
        q.append("left join a.dwTCausa i");
        q.append("left join a.dwTJust j");

        if (idGt != null && idGt.equals(BigDecimal.ZERO) == false) {
            q.append("left join ompt.omObjs omobj");
            q.append("left join omobj.omGtByIdGt omgt");
        }

        q.append("where d.dtReferencia between :dtinicial and :dtfinal");
        q.append("and d.dwCal.idCal <> :idcalindefinido");
        q.append("and d.stAtivo is null");
        q.append("and d.tpId = 1");

        if (idTurno != null && idTurno.equals(BigDecimal.ZERO) == false) {
            q.append("and d.dwTurno.idTurno = :idturno");
        }

        if (idPt != null && idPt.equals(BigDecimal.ZERO) == false) {
            q.append("and ompt.idPt = :idpt");
        }

        if (idGt != null && idGt.equals(BigDecimal.ZERO) == false)
            q.append("and omgt.idGt = :idgt");

        if (cdParada != null && cdParada.equals("") == false) {
            q.append("and e.cdTparada = :cdparada");
            q.defineParametro("cdparada", cdParada);
        }

        q.defineParametro("dtinicial", dtInicial);
        q.defineParametro("dtfinal", dtFinal);

        OmCfg omcfg = Util.getConfigGeral(getDaoSession());
        q.defineParametro("idcalindefinido", omcfg.getDwCal().getIdCal());

        if (idTurno != null && idTurno.equals(BigDecimal.ZERO) == false)
            q.defineParametro("idturno", idTurno.longValue());

        if (idPt != null && idPt.equals(BigDecimal.ZERO) == false)
            q.defineParametro("idpt", idPt.longValue());

        if (idGt != null && idGt.equals(BigDecimal.ZERO) == false)
            q.defineParametro("idgt", idGt.longValue());

        List<Object> lista = q.list();

        for (Object reg : lista) {
            Object[] registro = (Object[]) reg;

            DetalheParadaDTO detalhe = new DetalheParadaDTO();

            DwTArea area = new DwTArea();
            try {
                area.setCdArea(registro[4].toString());
                area.setDsArea(registro[5].toString());
            } catch (NullPointerException e) {
                area.setCdArea("");
                area.setDsArea("");
            }
            Date dti = (Date) registro[8];
            Date dtf = (Date) registro[9];

            if (registro[2] != null)
                detalhe.setAcao(registro[2] + "-" + registro[3]);
            else
                detalhe.setAcao("");

            detalhe.setArea_resp(area);

            if (registro[6] != null)
                detalhe.setCausa(registro[6] + "-" + registro[7]);
            else
                detalhe.setCausa("");

            long duracao = DataHoraRN.getQuantidadeMilisegundosNoPeriodo(dti, dtf);
            detalhe.setDuracao(DataHoraRN.formatMilisegundosParaHHMMSSmmm(duracao));
            detalhe.setDuracaoEmSegundos((double) (duracao / 1000));
            if (registro[14] != null)
            	detalhe.setFerramenta(registro[14].toString());
            else
            	detalhe.setFerramenta("---");
            detalhe.setFim(dtf);
            detalhe.setInicio(dti);

            if (registro[10] != null)
                detalhe.setJustificativa(registro[10] + "-" + registro[11]);
            else
                detalhe.setJustificativa("");

            detalhe.setMaquina(registro[12].toString());
            detalhe.setDsPt(registro[13].toString());

            if (registro[0] != null)
                detalhe.setParada(registro[0] + "-" + registro[1]);
            else
                detalhe.setParada("");

            detalhe.setPerdas_paradas(0d);
            detalhe.setTecnico1(null);
            detalhe.setTecnico2(null);
            detalhe.setTecnico_responsavel(null);
            detalhe.setTurno("turno");

            listaparadas.add(detalhe);
        }

        retorno.setListaparadas(listaparadas);
        return retorno;
    }

}
