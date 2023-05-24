package idw.model.rn.monitorizacao.injet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwTArea;
import idw.model.pojos.OmCfg;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.model.rn.injet.FuncoesApoioInjet;
import idw.util.Util;
import idw.webservices.dto.DetalhamentoParadaDTO;
import idw.webservices.dto.DetalheParadaDTO;
import ms.util.ConversaoTipos;

public class OcorrenciaParettoParadaInjetRN  extends AbstractRN<DAOGenericoInjet> {

    public OcorrenciaParettoParadaInjetRN() {
        super(new DAOGenericoInjet());
    }

    public OcorrenciaParettoParadaInjetRN(DAOGenericoInjet dao) {
        super(dao);
    }


    @SuppressWarnings("unchecked")
	public DetalhamentoParadaDTO getOcorrenciaParetoParadaFichaMaqDTO(Byte tpId, Date dtInicial, Date dtFinal, BigDecimal idTurno,
            String cdPt, String cdGt, String cdCp, Boolean isComPeso, Boolean isSemPeso, String cdParada, String cdArea, Integer filtroOp) {

        DetalhamentoParadaDTO retorno = new DetalhamentoParadaDTO();
        List<DetalheParadaDTO> listaparadas = new ArrayList<DetalheParadaDTO>();

        int _dtTurno = 0;
        int _cdTurno = _dtTurno + 1;
        int _dthrIniPar = _cdTurno + 1;
        int _dthrFimPar = _dthrIniPar + 1;
        int _cdParada = _dthrFimPar +1;
        int _dsParada = _cdParada + 1;
        int _cdCausa = _dsParada +1;
        int _dsCausa = _cdCausa + 1;
        int _cdAcao = _dsCausa +1;
        int _dsAcao = _cdAcao + 1;
        int _cdJust = _dsAcao +1;
        int _dsJust = _cdJust + 1;        
        int _cdArea = _dsJust + 1;
        int _dsArea = _cdArea + 1;
        int _isComPeso = _dsArea + 1;
        int _segTmpParCP = _isComPeso + 1;
        int _segTmpParSP = _segTmpParCP + 1;
        int _pcsPerdaParCP = _segTmpParSP + 1;
        int _pcsPerdaParSP = _pcsPerdaParCP + 1;
        int _cdMaquina = _pcsPerdaParSP + 1;
        int _cdMaqEstendido = _cdMaquina + 1;
        int _cdIdentific = _cdMaqEstendido + 1;
        int _cdMolde = _cdIdentific + 1;
        int _cdMolEstendido = _cdMolde + 1;
        int _cdTecR = _cdMolEstendido + 1;
        int _nmTecR = _cdTecR + 1;
        int _cdTec1 = _nmTecR + 1;
        int _nmTec1 = _cdTec1 + 1;
        int _cdTec2 = _nmTec1 + 1;
        int _nmTec2 = _cdTec2+ 1;
        
        
        class RegistroLido {
            Date dtTurno;
            String cdTurno;
            Date dthrIniPar;
            Date dthrFimPar;
            String cdParada;
            String dsParada;
            String cdCausa;
            String dsCausa;
            String cdAcao;
            String dsAcao;
            String cdJust;
            String dsJust;        
            String cdArea;
            String dsArea;
            int isComPeso;
            BigDecimal segTmpParCP = BigDecimal.ZERO;
            BigDecimal segTmpParSP = BigDecimal.ZERO;
            BigDecimal pcsPerdaParCP = BigDecimal.ZERO;
            BigDecimal pcsPerdaParSP = BigDecimal.ZERO;
            String cdMaquina;
            String cdMaqEstendido;
            String cdIdentific;
            String cdMolde;
            String cdMolEstendido;
            String cdTecR;
            String nmTecR;
            String cdTec1;
            String nmTec1;
            String cdTec2;
            String nmTec2;
        }
        
        
        String strSQL = "";
        
        strSQL = strSQL.concat("SELECT a.dtturno, a.cdturno, ");
        strSQL = strSQL.concat(" a.dthripar, a.dthrfpar, ");
        strSQL = strSQL.concat(" a.cdparada, p.dsparada, ");
        strSQL = strSQL.concat(" cau.cdcausas, cau.dscausas, ");
        strSQL = strSQL.concat(" aco.cdacoes, aco.dsacoes, ");
        strSQL = strSQL.concat(" jup.cdjustparada, jup.dsjustparada, ");
        strSQL = strSQL.concat(" p.cdarea, ar.dsarea, ");
        strSQL = strSQL.concat(" a.paradacompeso, a.tmpparadas, a.tmpparadassempeso, ");
        strSQL = strSQL.concat(" ( ( a.tmpparadas / ft.ciclopadrao) * (c2.qtcavativas * ft.fatorcontagemprod) ) as qtdperdasparCP, ");
        strSQL = strSQL.concat(" ( ( a.tmpparadassempeso / ft.ciclopadrao) * (c2.qtcavativas * ft.fatorcontagemprod) ) as qtdperdasparSP,  ");
        strSQL = strSQL.concat(" i.cdinjetora, i.cdinjestendido, i.cdidentific, ");
        strSQL = strSQL.concat(" m.cdmolde, m.cdmolestendido, ");
        strSQL = strSQL.concat(" a.drtresponsa, ur.nmusuario as nmTecR, ");
        strSQL = strSQL.concat(" a.drtecnico1, u1.nmusuario as nmTec1, ");
        strSQL = strSQL.concat(" a.drttecnico2, u2.nmusuario as nmTec2 ");
        
        strSQL = strSQL.concat(" FROM ijreaparcnsocorTUR a  ");        
        strSQL = strSQL.concat(" JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
        strSQL = strSQL.concat(" JOIN ijtbmol m ON (m.cdmolde = a.cdmolde) ");
        strSQL = strSQL.concat(" JOIN ijtbpar p ON (p.cdparada = a.cdparada) ");
        strSQL = strSQL.concat(" JOIN ijareres ar ON (ar.cdarea = p.cdarea)  ");
        strSQL = strSQL.concat(" JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic)  ");
        strSQL = strSQL.concat(" JOIN cavidades2 c2 ON (c2.cdmolde = ft.cdmolde AND c2.cdestrutura = ft.cdestrutura AND c2.dthrival = ft.dthrivalestru)  ");
        
        strSQL = strSQL.concat(" LEFT JOIN ijtbcau cau ON (cau.cdcausas = a.cdcausas) ");
        strSQL = strSQL.concat(" LEFT JOIN ijtbaco aco ON (aco.cdacoes = a.cdacoes) ");
        strSQL = strSQL.concat(" LEFT JOIN ijtbjup jup ON (jup.cdjustparada = a.cdjustparada) ");

        strSQL = strSQL.concat(" LEFT JOIN ijtbusu ur ON (ur.cdusuario = a.drtresponsa) ");
        strSQL = strSQL.concat(" LEFT JOIN ijtbusu u1 ON (u1.cdusuario = a.drtecnico1) ");
        strSQL = strSQL.concat(" LEFT JOIN ijtbusu u2 ON (u2.cdusuario = a.drttecnico2) ");

        
        if (cdGt != null && cdGt.equals("") == false) {
        	strSQL = strSQL.concat(" JOIN ijgrpdetinj ginj ON (ginj.cdinjetora = a.cdinjetora) ");	
        }


        // filtros
        strSQL = strSQL.concat(" WHERE 1 =1 ");
        
        if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO)) {
            // data
            if (dtInicial != null) {
            	strSQL = strSQL.concat(" AND a.dtturno BETWEEN :dtinicial and :dtfinal");
            }

            // turno
            if (idTurno != null) {
            	strSQL = strSQL.concat(" AND a.cdturno = :idturno ");
            }
        }
        
        
        
        if (cdGt != null && cdGt.equals("") == false) {
        	strSQL = strSQL.concat(" AND ginj.cdgrpinj = :cdgrpmaq ");
        }

        
        // máquina
        if (!cdPt.equals("") && !cdPt.equals(null)) {
        	strSQL = strSQL.concat(" AND i.cdinjestendido = :cdpt");
        }

        // op
        if (!cdCp.equals("") && !cdCp.equals(null)) {
        	strSQL = strSQL.concat(" AND a.nrop = :cdcp");
        }

        // paradas
        if (isComPeso == true && isSemPeso == false) {
        	strSQL = strSQL.concat("  AND a.paradacompeso = '1' ");
            
        } else if (isComPeso == false && isSemPeso == true) {
        	strSQL = strSQL.concat("  AND a.paradacompeso = '0' ");
        }

        // filtro de parada
        if (cdParada != null && cdParada.equals("") == false) {
        	strSQL = strSQL.concat(" AND a.cdparada = :cdparada ");
        }

        if (cdArea != null && cdArea.equals("") == false) {
        	strSQL = strSQL.concat("  AND ar.cdarea = :cdarea ");
        }

        strSQL = strSQL.concat(" ORDER BY a.dtturno, a.cdturno, a.dthripar ");
        
        
        List<Object> lista = new ArrayList<Object>();
        SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
        
        // definicao do parametros
        if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO)) {
            // data
            if (dtInicial != null) {
            	q.setTimestamp("dtinicial", dtInicial);
            	q.setTimestamp("dtfinal", dtFinal);
            }

            // turno
            if (idTurno != null && idTurno.equals(BigDecimal.ZERO) == false) {
                q.setString("idturno", FuncoesApoioInjet.getStrZero(idTurno.longValue(),6));
            }
        }

		if (!cdPt.equals("") && !cdPt.equals(null)) {
			q.setString("cdpt", cdPt);
		}

        // op
        if (!cdCp.equals("") && !cdCp.equals(null)) {
        	q.setString("cdcp", cdCp);
        }

        // filtro de parada
        if (cdParada != null && cdParada.equals("") == false) {
            q.setString("cdparada", cdParada);
        }

        // paradas
        if (cdArea != null && cdArea.equals("") == false) {
            q.setString("cdarea", cdArea);
        }


        lista = q.list();

        
        //quando montagem for por op tem que recuperar pts da OP
		Map<String, String> mapCdPts = new HashMap<String, String>();
        if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP)  && !cdCp.equals("") && !cdCp.equals(null)) {
        	strSQL = "";
        	strSQL = strSQL.concat("SELECT DISTINCT b.cdinjestendido ");
        	strSQL = strSQL.concat("  FROM ijoproteiro a ");
        	strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
        	strSQL = strSQL.concat(" WHERE a.nrop = '" + cdCp + "'");
        	SQLQuery qCps = this.getDaoSession().createSQLQuery(strSQL);
        	
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
        	RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			registro.dtTurno = (Date) registroLido[_dtTurno];
			registro.cdTurno = (String) registroLido[_cdTurno];
			
			registro.dthrIniPar = (Date) registroLido[_dthrIniPar];
			registro.dthrFimPar = (Date) registroLido[_dthrFimPar];
			registro.cdParada = (String) registroLido[_cdParada];
			registro.dsParada = (String) registroLido[_dsParada];
			registro.cdArea = (String) registroLido[_cdArea];
			registro.dsArea = (String) registroLido[_dsArea];

			if (registroLido[_cdCausa] != null) {
				registro.cdCausa = (String) registroLido[_cdCausa];
				registro.dsCausa = (String) registroLido[_dsCausa];
			}
			
			if (registroLido[_cdAcao] != null) {
				registro.cdAcao = (String) registroLido[_cdAcao];
				registro.dsAcao = (String) registroLido[_dsAcao];
			}

			if (registroLido[_cdJust] != null) {
				registro.cdJust = (String) registroLido[_cdJust];
				registro.dsJust = (String) registroLido[_dsJust];
			}
			
			registro.isComPeso = ConversaoTipos.converterParaBigDecimal(registroLido[_isComPeso]).intValue();
			
			registro.segTmpParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParCP]);
			registro.segTmpParSP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParSP]);;
			registro.pcsPerdaParCP = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParCP]).setScale(0, RoundingMode.FLOOR));
			//registro.pcsPerdaParSP = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParSP]).setScale(0, RoundingMode.FLOOR));
			registro.pcsPerdaParSP = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(BigDecimal.ZERO).setScale(0, RoundingMode.FLOOR);
			
			registro.cdMaquina = (String) registroLido[_cdMaquina];
			registro.cdMaqEstendido = (String) registroLido[_cdMaqEstendido];
			registro.cdIdentific = (String) registroLido[_cdIdentific];
			registro.cdMolde = (String) registroLido[_cdMolde];
			registro.cdMolEstendido = (String) registroLido[_cdMolEstendido];
			

			if (registroLido[_cdTecR] != null) {
				registro.cdTecR = (String) registroLido[_cdTecR];
				registro.nmTecR = (String) registroLido[_nmTecR];
			}
			
			if (registroLido[_cdTec1] != null) {
				registro.cdTec1 = (String) registroLido[_cdTec1];
				registro.nmTec1 = (String) registroLido[_nmTec1];
			}

			if (registroLido[_cdTec2] != null) {
				registro.cdTec2 = (String) registroLido[_cdTec2];
				registro.nmTec2 = (String) registroLido[_nmTec2];
			}
			
			
            DetalheParadaDTO detalhe = new DetalheParadaDTO();

            Date dti = registro.dthrIniPar;
            Date dtf = registro.dthrFimPar;

            DwTArea area = new DwTArea();
            area.setCdArea(registro.cdArea);
            area.setIdArea(ConversaoTipos.converterParaBigDecimal(area.getCdArea()).longValue());
            area.setDsArea(registro.dsArea);
            detalhe.setArea_resp(area); 

            if (registro.cdAcao != null) {
                detalhe.setAcao(registro.cdAcao + "-" + registro.dsAcao);
            } else {
            	detalhe.setAcao("");
            }

            if (registro.cdCausa != null) {
                detalhe.setCausa(registro.cdCausa + "-" + registro.dsCausa);
            } else {
            	detalhe.setCausa("");
            }
                
            if (registro.cdJust != null) {
                detalhe.setJustificativa(registro.cdJust + "-" + registro.dsJust);
            } else {
                detalhe.setJustificativa("");
            }

            double duracao = (double) DataHoraRN.getQuantidadeMilisegundosNoPeriodo(dti, dtf);
            totalDuracao += (duracao / 1000d);

            detalhe.setDuracao(DataHoraRN.formatMilisegundosParaHHMMSSmmm((long)duracao));
            detalhe.setDuracaoEmSegundos((double) duracao / 1000);
            
            detalhe.setFerramenta(registro.cdMolEstendido);
            detalhe.setFolha("");
            
            detalhe.setFim(dtf);
            detalhe.setInicio(dti);


            detalhe.setMaquina(registro.cdMaqEstendido);
            detalhe.setDsPt(registro.cdIdentific);

            detalhe.setParada(registro.cdParada + "-" + registro.dsParada);


            //detalhe.setPerdas_paradas(registro.isComPeso == 1 ? registro.pcsPerdaParCP.doubleValue() : registro.pcsPerdaParSP.doubleValue());
            detalhe.setPerdas_paradas(registro.isComPeso == 1 ? registro.pcsPerdaParCP.doubleValue() : 0d);

        	if (registro.cdTecR != null) {
                detalhe.setTecnico_responsavel(registro.cdTecR + "-" + registro.nmTecR);
        	}
        	
        	if (registro.cdTec1 != null) {
                detalhe.setTecnico1(registro.cdTec1 + "-" + registro.nmTec1);
        	}
        	
        	if (registro.cdTec2 != null) {
                detalhe.setTecnico2(registro.cdTec2 + "-" + registro.nmTec2);
        	}
        	
            detalhe.setTurno(registro.cdTurno);

            detalhe.setComPeso((registro.isComPeso==1));
            
            // Somente se a duracao for positiva
            if (duracao > 0d) {
                listaparadas.add(detalhe);
            }
        }
        retorno.setDuracaoParadas(DataHoraRN.formatSegundosParaHHMMSS( (int) totalDuracao));
        retorno.setListaparadas(listaparadas);
        return retorno;
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
