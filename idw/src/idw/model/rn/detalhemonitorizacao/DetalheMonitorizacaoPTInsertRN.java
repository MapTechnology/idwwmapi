package idw.model.rn.detalhemonitorizacao;

import java.awt.Color;
import java.awt.Paint;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPacoteOuFatorException;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolciplog;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpalogtec;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwConsolpemp;
import idw.model.pojos.DwConsolpempoco;
import idw.model.pojos.DwConsolperdamplog;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwConsolre;
import idw.model.pojos.DwConsolrelog;
import idw.model.pojos.DwConsolreoco;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhacic;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwRtcic;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTParada;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmAlim;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmMapa;
import idw.model.pojos.OmMapapa;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpentsai;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.pojos.template.DwConsolpalogtecTemplate;
import idw.model.pojos.template.OmAlimTemplate;
import idw.model.pojos.template.OmAlimreaTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.PTRN;
import idw.model.rn.geraplano.dtos.DatasDTO;
import idw.model.rn.monitorizacao.detalhes.GraficoParettoParadaRN;
import idw.model.rn.monitorizacao.detalhes.IndicadoresSMEDRN;
import idw.util.AritmeticaUtil;
import idw.util.Cor;
import idw.util.FormulasInjet;
import idw.util.GrafTendenciaUtils;
import idw.util.IdwLogger;
import idw.util.IntervaloGrafTendenciaRefugoParada;
import idw.util.Util;
import idw.webservices.dto.CIPDTO;
import idw.webservices.dto.CapabilidadeProcessoDTO;
import idw.webservices.dto.CicloDTO;
import idw.webservices.dto.CiclosDTO;
import idw.webservices.dto.DetalhamentoProducaoDTO;
import idw.webservices.dto.DetalheAnaliseGargaloDTO;
import idw.webservices.dto.DetalheMonitorizacaoPTInjetDTO;
import idw.webservices.dto.DetalheParadaDTO;
import idw.webservices.dto.DetalheProducaoDTO;
import idw.webservices.dto.DetalheRefugoDTO;
import idw.webservices.dto.DwConsolidDTO;
import idw.webservices.dto.DwConsolidDTOs;
import idw.webservices.dto.DwFolhaDTO;
import idw.webservices.dto.DwFolhasDTO;
import idw.webservices.dto.FiltroCiclosDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.FiltroDetalheProducaoDTO;
import idw.webservices.dto.FiltroGraficoDetalhePtDTO;
import idw.webservices.dto.FiltroProducaoDTO;
import idw.webservices.dto.FiltroProducaoPtCpDTO;
import idw.webservices.dto.GraficoBIParetoDetCiclosOrdemMaquinaDTO;
import idw.webservices.dto.GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO;
import idw.webservices.dto.GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO;
import idw.webservices.dto.GraficoBIParetoDetCiclosOrdemProdutoDTO;
import idw.webservices.dto.GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO;
import idw.webservices.dto.GraficoBIParetoDetParOrdemMaquinaDTO;
import idw.webservices.dto.GraficoBIParetoDetParOrdemMaquinaFerramentaDTO;
import idw.webservices.dto.GraficoBIParetoDetParOrdemMaquinaFerramentaParadaDTO;
import idw.webservices.dto.GraficoBIParetoDetParOrdemMaquinaFerramentaParadaProdutoDTO;
import idw.webservices.dto.GraficoBIParetoDetParOrdemMaquinaTurnoDTO;
import idw.webservices.dto.GraficoBIParetoDetRefOrdemMaquinaDTO;
import idw.webservices.dto.GraficoBIParetoDetRefOrdemMaquinaFerramentaDTO;
import idw.webservices.dto.GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoDTO;
import idw.webservices.dto.GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO;
import idw.webservices.dto.GraficoBIParetoDetRefOrdemProdutoDTO;
import idw.webservices.dto.GraficoBIParetoDetRefOrdemProdutoMaquinaDTO;
import idw.webservices.dto.GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaDTO;
import idw.webservices.dto.GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO;
import idw.webservices.dto.GraficoBIParetoDetTodasDTO;
import idw.webservices.dto.GraficoDetalhePtDTO;
import idw.webservices.dto.IndicadoresDTO;
import idw.webservices.dto.IndicadoresPtDTO;
import idw.webservices.dto.IntervaloDTO;
import idw.webservices.dto.ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO;
import idw.webservices.dto.ListaGraficoBIParetoDetCiclosOrdemProdutoDTO;
import idw.webservices.dto.ListaGraficoBIParetoDetParOrdemMaquinaDTO;
import idw.webservices.dto.ListaGraficoBIParetoDetRefOrdemMaquinaDTO;
import idw.webservices.dto.ListaGraficoBIParetoDetRefOrdemProdutoDTO;
import idw.webservices.dto.ListaGraficoBIParetoDetTodasDTO;
import idw.webservices.dto.ListaIndicadoresDTO;
import idw.webservices.dto.ListaOperadoresDTO;
import idw.webservices.dto.ListaPerdasmpDTO;
import idw.webservices.dto.OcorrenciasEvtDTO;
import idw.webservices.dto.OperadorDTO;
import idw.webservices.dto.PerdasDTO;
import idw.webservices.dto.PerdasmpDTO;
import idw.webservices.dto.PeriodoDTO;
import idw.webservices.dto.PosicaoCODTO;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.dto.ProdutoPerdasFichaMaqDTO;
import idw.webservices.dto.ProdutosDTO;
import idw.webservices.dto.ProdutosPerdasFichaMaqDTO;
import idw.webservices.dto.ResumoParetoPerdasDetCiclosDTO;
import idw.webservices.dto.ResumoParetoPerdasDetParadasDTO;
import idw.webservices.dto.ResumoParetoPerdasDetRefugosDTO;
import idw.webservices.dto.ResumoParetoPerdasDetTodasDTO;
import ms.util.ConversaoTipos;

/**
 * TODO milton - refatorar classe, remover pontos desnecessÃ¡rios
 * 
 * @author map
 * 
 */
public class DetalheMonitorizacaoPTInsertRN extends AbstractRN<DAOGenerico> {

    /**
     * Abate o tempo do ciclos nos cÃ¡lculos, porque nas mÃ¡quinas insersoras, o tempo da parada estÃ¡ embutida no tempo do ciclo, mesmo
     * assim o tempo desta parada Ã© contabilizada novamente. <br>
     * Para evitar que o tempo fique duplicado, se for {@code true}, faz o abatimento do tempo. <br>
     * Se estiver sendo realizado o tratamento de parada como variaÃ§Ã£o de ritmo do ciclos
     * {@link ConsolidaRN#MAQUINA_INSERSORA_CONSIDERA_PARADA_COMO_TEMPO_ATIVO}, entÃ£o nÃ£o precisa realizar este ajuste
     */
    public static final boolean ABATER_TEMPO_PARADAS_COM_PESO_PARADA_NAO_FECHA_CICLO = ConsolidaRN.MAQUINA_INSERSORA_CONSIDERA_PARADA_COMO_TEMPO_ATIVO;

    public static final Byte PERIODO_CONSOLIDACAO_HORA = 0;
    public static final Byte PERIODO_CONSOLIDACAO_TURNO = 1;
    public static final Byte PERIODO_CONSOLIDACAO_MES = 2;
    public static final Byte PERIODO_CONSOLIDACAO_ACUMULADO = 3;
    public static final byte PERIODO_CONSOLIDACAO_OP = 4;

    public static final byte EXIBICAO_QTD_UNIDADE_BASICA = 1;
    public static final byte EXIBICAO_QTD_PESO_KG = 2;
    public static final byte EXIBICAO_QTD_PESO_TON = 3;
    
    public static final Byte ORDEM_UB = 1;
    public static final Byte ORDEM_PESO = 2;
    public static final Byte ORDEM_UM = 3;
    
    public static final Byte ORDEM_PRODUTO = 1;
    public static final Byte ORDEM_FERRAMENTA = 2;

    public static final Integer PRECISAO_DECIMAIS_PERDA_MP = 4;
    
    private DetalheMonitorizacaoPTInjetDTO retorno;
    private List<DwConsolid> listaDwconsolid;

    public DetalheMonitorizacaoPTInsertRN() {
        this(new DAOGenerico());
    }

    public DetalheMonitorizacaoPTInsertRN(DAOGenerico dao) {
        super(dao);
    }

    /*
     * Metodo principal para retorno das informacoes do detalhamento
     */
    public DetalheMonitorizacaoPTInjetDTO getDetalheMonitorizacaoPtInjetDTO(FiltroDetalhePTInjetDTO filtro) {

        IdwLogger log = new IdwLogger("getDetalheMonitorizacaoPtInjetDTO");

        log.iniciaAvaliacao("TEMPO TOTAL");

        // Depois da pesquisa abaixo o vetor listaDwconsolid estara preenchido
        // Milton 14/08/2017 #4364 'fetchProdutoPerda = false'
        listaDwconsolid = pesquisarDwConsolids(log, filtro, false);
        


        OmCfg omcfg = Util.getConfigGeral(getDaoSession());

        retorno = new DetalheMonitorizacaoPTInjetDTO();
        if (listaDwconsolid.isEmpty() == false) {
            // Ordena listas

            ordenaListas(listaDwconsolid);

            IndicadoresDoDetalheRN iRN = new IndicadoresDoDetalheRN(getDao(), log, omcfg, listaDwconsolid,
                    true /* isRecuperarListaProdutos */, 
                    true /* isRecuperarListaOperadores */, 
                    true /* isRecuperarListaAlertas */,
                    true /* isRecuperarListaPerdas */, 
                    true /* isRecuperarListaResumoDatas */, 
                    true /* isRecuperarListaResumoTurnos */,
                    retorno, filtro);
            log.iniciaAvaliacao("resumoIndicadores");
            iRN.setResumoIndicadores();
            log.mostrarAvaliacaoCompleta();

            log.iniciaAvaliacao("indicadoresAdicionais");
            iRN.setIndicadoresAdicionais();
            log.mostrarAvaliacaoCompleta();

            /*
             * Alessandre em 11-03-15 setResumoIndicadores esta pegando apenas os operadores consolidados. Abaixo pegamos os em aberto
             */
            log.iniciaAvaliacao("listaOperadores");
            retorno.setListaOperadores(getListaOperadores(listaDwconsolid, filtro));
            log.mostrarAvaliacaoCompleta();

            /*
             * Alessandre em 20-05-15 gerar os indicadores do uso do SMED
             */
            log.iniciaAvaliacao("historicoSMED");
            IndicadoresSMEDRN smedRN = new IndicadoresSMEDRN(getDao());
            retorno.setHistoricoSmed(smedRN.getHistoricoSmedDTO(listaDwconsolid));
            log.mostrarAvaliacaoCompleta();

            /*
             * Alessandre em 04-01-16. INiciando dados para energia consumida
             */
            log.iniciaAvaliacao("energiaconsumidaproducao");
            EnergiaConsumidaProducaoRN eneRN = new EnergiaConsumidaProducaoRN(getDao());
            retorno.setEnergiaConsumidaProducao(eneRN.getListaEnergiaConsumidaProducao(listaDwconsolid));
            log.mostrarAvaliacaoCompleta();

            /*
             * Alessandre em 21-01-16 iniciando dados de cip
             */
            log.iniciaAvaliacao("inicializandoCIP");
            retorno.setListacips(getListaCips(listaDwconsolid));
            log.mostrarAvaliacaoCompleta();

            /*
             * Alessandre em 17-10-16 setando qual dos indicadores esta deixando o posto fora de meta
             */
            if (filtro.getOmPt() != null) {

                OmPt ompt;
                if (filtro.getOmPt().getIdPt() != null)
                	ompt = getDao().findById(OmPt.class, filtro.getOmPt().getIdPt(), false);
                else {
                	PTRN ptrn = new PTRN(getDao());
                	try {
						ompt = ptrn.getOmPt(filtro.getOmPt().getCdPt());
					} catch (RegistroDesconhecidoException e) {
						ompt = null;
					}
                }
                			

                retorno.setIsForaMetaEficienciaUltCic(!iRN.isMaquinaDentroDaMetaEC(log, ompt, omcfg, retorno.getCiclosEficienciaCic()));

                retorno.setIsForaMetaIefiCiclos(!iRN.isMaquinaDentroDaMetaEI(log, ompt, omcfg, retorno.getEfiCiclos()));

                retorno.setIsForaMetaIefiRealizacao(!iRN.isMaquinaDentroDaMetaER(log, ompt, omcfg, retorno.getEfiRealizacao()));

                retorno.setIsForaMetaIndiceParadas(!iRN.isMaquinaDentroDaMetaIP(log, ompt, omcfg, retorno.getIndiceParadas()));

                retorno.setIsForaMetaIndiceRefugos(!iRN.isMaquinaDentroDaMetaIR(log, ompt, omcfg, retorno.getIndiceRefugos()));
            }

            // Remover o dwconsolid que esta dentro de dwconsoid.dwconsol para
            // evitar o ws infinito
            Date dtHrMin = null;
            Date dtHrMax = null;
            Date dtHrTur = null;

            for (DwConsolid dwconsolid : listaDwconsolid) {

                // Encontrar o inicio e fim do turno
                dtHrTur = dwconsolid.getDtReferencia();
                if (dtHrMin == null) {
                    dtHrMin = dtHrTur;
                } else {
                    if (DataHoraRN.compareTo(dtHrMin, dtHrTur) > 0) {
                        dtHrMin = dtHrTur;
                    }
                }

                if (dtHrMax == null) {
                    dtHrMax = dtHrTur;
                } else {
                    if (DataHoraRN.compareTo(dtHrMax, dtHrTur) < 0) {
                        dtHrMax = dtHrTur;
                    }
                }

                /*
                 * Alessandre em 11-03-15 como nao clonei dwconsolid o for abaixo vai gerar um erro de atualizacao por isso comentei, meu
                 * objetivo eh reavaliar a necessidade do clone for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
                 * getDao().evict(dwconsol); dwconsol.setDwConsollogs(null); dwconsol.setDwConsolid(null);
                 * dwconsol.setDwConsolmedparams(null); dwconsol.setDwConsolmos(null); dwconsol.setDwConsolres(null);
                 * dwconsol.setDwConsolpas(null); dwconsol.setDwConsolprs(null); dwconsol.setDwConsolpemps(null);
                 * 
                 * 
                 * // Alessandre: em 15-8-13 Removendo dwconsolal do dwconsol pois nao quis criar um clone para dwconsolal dwconsolaloco //
                 * e deixei os pojos vinculados ate aqui, mas para retornar via webservice estou removendo dwconsol.setDwConsolals(null); }
                 */
            }

            retorno.setDtRefMin(dtHrMin);
            retorno.setDtRefMax(dtHrMax);

        }

        // Obter a lista de ops no turno se NAO for o BI. Isso eh importante pq
        // o detalhe da maquina permite escolher outra OP
        if (filtro.getTpId() != null && filtro.getTpId().equals((byte) 1) && filtro.getDtReferencia() != null) {
            MapQuery query = new MapQuery(getDao().getSession());

            query.append("SELECT DISTINCT ppcp");
            query.append("from PpCp ppcp");
            query.append("join ppcp.dwConsolids dwconsolid");

            query.appendWhere(MapQuery._NULL, "dwconsolid.tpId = :tpId and dwconsolid.stAtivo is null ", true);
            query.appendWhere(MapQuery._AND, "dwconsolid.dtReferencia = :data", filtro.getDtReferencia() != null);
            query.appendWhere(MapQuery._AND, "dwconsolid.dwTurno.idTurno = :idTurno", filtro.getDwTurno() != null);
          //Marcos Sardinha: 2017-07-17 >> Defeito #3885 ... qdo tem filtro de turno indefinido e necessita analisar hora nao recuperada dados
            query.appendWhere(MapQuery._AND, "dwconsolid.dwTurno.idTurno <> 1", filtro.getDwTurno() == null && filtro.getTpId().equals(PERIODO_CONSOLIDACAO_HORA) == false);
            query.appendWhere(MapQuery._AND, "dwconsolid.omPt.cdPt = :ompt", filtro.getOmPt() != null);
            query.append("order by ppcp.dthrInicioreal");

            query.defineParametro("idTurno", filtro.getDwTurno() != null ? filtro.getDwTurno().getIdTurno() : 0);
            query.defineParametro("tpId", (byte) 1);

            if (filtro.getOmPt() != null && filtro.getOmPt().getCdPt() == null) {
            	OmPt ompt = getDao().findById(OmPt.class, filtro.getOmPt().getIdPt(), false);
                filtro.getOmPt().setCdPt(ompt.getCdPt());
            }

            if (filtro.getOmPt() != null)
                query.defineParametro("ompt", filtro.getOmPt().getCdPt());

            query.defineParametroData("data", filtro.getDtReferencia() != null ? DataHoraRN.getDataSemHora(filtro.getDtReferencia()) : null);

            log.iniciaAvaliacao("obtem ppcp");
            List<PpCp> lista = query.list();
            log.mostrarAvaliacaoCompleta();

            List<PpCp> ops = new ArrayList<PpCp>();

            for (PpCp ppcp : lista) {
                PpCp clone = new PpCp();
                clone.setCdCp(ppcp.getCdCp());
                clone.setIdCp(ppcp.getIdCp());
                clone.setDthrInicioreal(ppcp.getDthrInicioreal());
                clone.setPpCpprodutos(new HashSet<PpCpproduto>());
                for (PpCpproduto ppcpproduto : ppcp.getPpCpprodutos()) {
                    clone.getPpCpprodutos().add(ppcpproduto.clone(false));
                }
                ops.add(clone);
            }
            retorno.setOpsNoTurno(ops);
        }

        // calcular indicadores utilizados na ficha da máquina da op
        if (filtro.getTpId() == PERIODO_CONSOLIDACAO_OP) {
            Date dthrFimPrevisto = null;
            Date dthrFimPrevistoMax = null;
            Double qtCiclosAExec = null;
            Double restoDivisao = null;
            Date dthrAtual = DataHoraRN.getDataHoraAtual();

            Double qtPlanOP = 0d;
            Double qtPlanProduto = 0d;

            MapQuery query = new MapQuery(getDao().getSession());

            query.append("SELECT DISTINCT ppcp");
            query.append("from PpCp ppcp");
            query.append("join fetch ppcp.ppCpprodutos b");
            query.appendWhere(MapQuery._NULL, "ppcp.cdCp = :cdcp ", filtro.getCdCp() != null && filtro.getCdCp().equals("") == false);
            query.appendWhere(MapQuery._NULL,  "b.nrDoc = :cdcp", filtro.getNrDoc() != null && filtro.getNrDoc().equals("") == false);
            query.append("order by ppcp.dthrInicioreal");

//            query.defineParametro("idTurno", filtro.getDwTurno() != null ? filtro.getDwTurno().getIdTurno() : 0);
            query.defineParametro("tpId", (byte) 3);

            if (filtro.getCdCp() != null && filtro.getCdCp().equals("") == false)
            	query.defineParametro("cdcp", filtro.getCdCp());
            else
            	query.defineParametro("cdcp", filtro.getNrDoc());

            List<PpCp> lista = query.list();

            for (PpCp ppcp : lista) {
                for (PpCpproduto produto : ppcp.getPpCpprodutos()) {
                    qtPlanProduto = (produto.getPcsProducaoplanejada() != null ? produto.getPcsProducaoplanejada().doubleValue() : 0);
                    qtPlanOP = qtPlanOP + qtPlanProduto;
                }
            }

            // índice de produ��oo
            if (retorno.getQtdPecasBoas() != null) {
                retorno.setIndiceProducao(FormulasInjet.calcularEficienciaRealizacao(new BigDecimal(retorno.getQtdPecasBoas()),
                        new BigDecimal(qtPlanOP)).doubleValue());
            } else {
                retorno.setIndiceProducao(0d);
            }
            // gargalo
            if (retorno.getListaProdutos() != null) {
                for (ProdutoDTO produto : retorno.getListaProdutos()) {
                    if (produto.getAproduzir().doubleValue() > 0d) {
                        restoDivisao = produto.getAproduzir().doubleValue() % produto.getQtdAtiva().doubleValue();
                        qtCiclosAExec = produto.getAproduzir().doubleValue() / produto.getQtdAtiva().doubleValue();

                        if (!restoDivisao.equals(0d)) {
                            qtCiclosAExec = qtCiclosAExec + 1;
                        }

                        // calcular fim previsto
                        dthrFimPrevisto = DataHoraRN.adicionaSegundosNaData(dthrAtual, (int) (qtCiclosAExec * produto.getCicloPadrao()));

                        if (dthrFimPrevistoMax == null) {
                            dthrFimPrevistoMax = dthrFimPrevisto;
                        } else {
                            dthrFimPrevistoMax = (DataHoraRN.compareTo(dthrFimPrevistoMax, dthrFimPrevisto) < 0 ? dthrFimPrevistoMax
                                    : dthrFimPrevistoMax);
                        }
                    }
                }
            }

            if (dthrFimPrevistoMax == null || retorno.getDtFimPlanejado() == null) {
                retorno.setDtFimPrevisto(retorno.getDtFimPlanejado());
                retorno.setGargalo("00:00:00");

            } else {
                // calcula a diferença entre gargalo e final previsto            	
        		Date dtHrFimPlan = DataHoraRN.stringToDate(retorno.getDtFimPlanejado(), "yyyy-MM-dd HH:mm:ss");
                int segGargalo = DataHoraRN.getQuantidadeSegundosNoPeriodo(dtHrFimPlan, dthrFimPrevistoMax);

                retorno.setDtFimPrevisto(DataHoraRN.dateToString(dthrFimPrevistoMax, "dd/MM/yyyy HH:mm:ss"));
                retorno.setGargalo(DataHoraRN.getSegundosFormatadosEmDiasHoras(new BigDecimal(segGargalo)));
            }

        }
        log.mostrarAvaliacaoCompleta();

        // Ajuste temporario do retorno
        if (retorno.getListaDwConsolId() != null) {
            for (DwConsolid id : retorno.getListaDwConsolId()) {
                for (DwConsol consol : id.getDwConsols()) {
                    consol.setDwConsolid(null);
                }
            }
        }
        
        
        // retorno.setIndiceFPY(getIndiceFPY(listaDwconsolid));
        Double fpy;
        fpy = 0.0;
        if (retorno!=null && retorno.getOpsNoTurno()!=null && retorno.getDwTurno()!=null && retorno.getDwTurno().getIdTurno()!=0L && filtro.getDtReferencia()!=null  ){
        	fpy = getIndiceFPY(retorno.getOpsNoTurno(), retorno.getDwTurno().getIdTurno(), filtro.getDtReferencia() );
        }
        retorno.setIndiceFPY(fpy);
        
        
        return retorno;

    }
    
    
    private Double getIndiceFPY(List<PpCp> listaCps, Long idTurno, Date dtRef)
    {
    	/*
    	 	FPY = (1 - (D/P))
			FPY% = FPY*100
    	 */
    	
    	
    	Double retorno = 0.0;
    	Long longP = 0L;
    	Long longD = 0L;
    	
    	
    	if (idTurno==null){return 0.0;}
    	
    	List<Object> listobjsIDs;
    	if(listaCps!=null && listaCps.size()>0 && listaCps.get(0)!=null && listaCps.get(0).getIdCp()!=0L){
        	listobjsIDs  = new ArrayList<Object>();
    		for (PpCp o : listaCps){
    			if(o!=null && o.getIdCp()!=0L){
    				listobjsIDs.add(o.getIdCp());
    			}
    		}
    		
        	List<DwNserie> listaDwnserieP;
        	List<DwNserie> listaDwnserieD;
        	
        	// Qt P
            MapQuery query = new MapQuery(getDao().getSession());
            query.append("");
            query.append("select ns ");
            query.append("from DwNserie ns");
            query.append("where ");
            query.append("ns.idNserie in");
            query.append("(");
            query.append("	select p.dwNserie.idNserie from DwPassagem p ");
            query.append("	where ");
            query.append("		p.dwConsolid.idConsolid in ");
            query.append("		(");
            
            //query.append("			:listobjsids");

            query.append("select c.idConsolid from DwConsolid c ");
            query.append("where ");
            query.append("c.dtReferencia = :dtref ");
            query.append("and c.dwTurno.idTurno = :idtur ");
            query.append("and c.ppCp.idCp in (:listobjsids) ");
            
            query.append("		)");
            query.append(")");
            query.defineListaParametro("listobjsids", listobjsIDs);
            query.defineParametro("idtur", idTurno);
            query.defineParametroData("dtref", dtRef);
            listaDwnserieP = query.list();
            if(listaDwnserieP!=null && listaDwnserieP.size()>0){
            	longP = Long.valueOf(listaDwnserieP.size());
            }
            listaDwnserieP = null;
            query = null;
        	
        	
        	// Qt D
            query = new MapQuery(getDao().getSession());
            query.append("");
            query.append("select ns  ");
            query.append("from DwNserie ns ");
            query.append("where  ");
            query.append("ns.idNserie in  ");
            query.append("( ");
            query.append("	select p.dwNserie.idNserie from DwPassagem p  ");
            query.append("	where ");
            query.append("	p.idPassagem in ");
            query.append("	( ");
            query.append("		select pdef.dwPassagem.idPassagem from DwPassdef pdef  ");
            query.append("		where  ");
            query.append("			pdef.dwPassagem.idPassagem in  ");
            query.append("			( ");
            query.append("				select pp.idPassagem from DwPassagem pp  ");
            query.append("				where  ");
            query.append("					pp.dwConsolid.idConsolid  in  ");
            query.append("					( ");
            
            //query.append("						:listobjsids ");
            query.append("select c.idConsolid from DwConsolid c ");
            query.append("where ");
            query.append("c.dtReferencia = :dtref ");
            query.append("and c.dwTurno.idTurno = :idtur ");
            query.append("and c.ppCp.idCp in (:listobjsids) ");

            
            query.append("					) ");
            query.append("			) ");
            query.append("	) ");
            query.append(") ");
            query.defineListaParametro("listobjsids", listobjsIDs);
            query.defineParametro("idtur", idTurno);
            query.defineParametroData("dtref", dtRef);
            listaDwnserieD = query.list();
            if(listaDwnserieD!=null && listaDwnserieD.size()>0){
            	longD = Long.valueOf(listaDwnserieD.size());
            }
            listaDwnserieD = null;
            query = null;
     
    		
    	}
    	
    	double d = 0.0;
    	double p = 0.0;
    	double r = 0.0;
    	if(longP!=null && longP.longValue()>0L){
        	d = longD.longValue();
        	p  = longP.longValue();
    		r = d/p;
    		r = 1 - r;
    		retorno = Double.valueOf( r );
    		retorno = retorno.doubleValue()*100;
    	}
 	
    	
    	return retorno;
    }
    
    
    
    
    public List<DwConsolid> pesquisarDwConsolids(IdwLogger log, FiltroDetalhePTInjetDTO filtro) {
    	return pesquisarDwConsolids(log, filtro, false);
    }

    /*
     * Metodo principal para pesquisar os DwConsolid necessarios para o detalhe
     */
    private List<DwConsolid> pesquisarDwConsolids(IdwLogger log, FiltroDetalhePTInjetDTO filtro, boolean fetchProdutoPerda) {
        MapQuery query = new MapQuery(getDao().getSession());

        query.append("SELECT DISTINCT dwconsolid");
        query.append("FROM DwConsolid dwconsolid");
        query.append("join fetch dwconsolid.dwConsols dwconsol");
        query.append("left join fetch dwconsolid.dwRt dwRt");
        query.append("left join fetch dwconsolid.dwProreas dwprorea");
        query.append("left join fetch dwRt.dwConsolpalog dwconsolpalog");
        query.append("left join fetch dwconsolid.ppCp ppcp");
        query.append("left join fetch ppcp.dwCal dwcal");
        query.append("left join fetch ppcp.ppCpprodutos ppcpprodutos");
        query.append("left join fetch dwconsolid.dwFolha dwfolha");

        if ( 	(filtro.getOmProduto() != null && filtro.getOmProduto().getCdProduto() != null && filtro.getOmProduto().getCdProduto().equals("") == false) || 
        		filtro.getCdGrupoFerramenta() != null || 
        		filtro.getDwRap() != null) {
            query.append("left join dwfolha.dwFolharaps dwfolharap");
            query.append("left join dwfolharap.dwFolharapcoms dwfolharapcom");

            // grupo de moldes - novo filtro BI
            if (filtro.getCdGrupoFerramenta() != null) {
                query.append("LEFT JOIN dwfolharap.dwRap.dwRapGrupos grpmol");
            }
        }

        if (filtro.getOmProduto() != null && filtro.getOmProduto().getCdProduto() != null && filtro.getOmProduto().getCdProduto().equals("") == false) {
            query.append("left join dwfolharapcom.omProduto omprodutorap");
        }

        query.append("left join fetch dwconsol.dwConsolmos dwconsolmo");
        query.append("left join fetch dwconsol.dwConsolals dwconsolal");

        query.append("left join fetch dwconsolid.dwTurno ");
        query.append("left join fetch dwconsolid.omPt ompt ");
        query.append("left join fetch dwfolha.dwFolhaiacs dwfolhaiac");
        query.append("left join dwfolhaiac.omProduto omprodutoiac");
        query.append("left join fetch dwconsol.dwConsolprs dwConsolprs");
        query.append("left join fetch dwConsolprs.omProduto omproduto ");
        query.append("left join fetch dwconsol.dwConsolParams dwconsolparam");
        
        //Alex 06/06/2017 #3707
        query.append("left join fetch dwconsol.dwConsolpemps dwconsolpemps");
        
        //Alex 07/08/2017 #4251
        /* 
         * Milton 14/08/2017 #4364 quando tem muitas perdas de matéria-prima, a consulta retorna um volume muito grande de dados
         * No caso do chamado, ficou mais lento quando faz o join fetch, 
         * por isso a chamada do método foi alterada para fetchProdutoPerda = false
         */        
        if(fetchProdutoPerda) {
        	query.append("left join fetch dwconsolpemps.dwConsolpempocos dwConsolpempocos");
            query.append("left join fetch dwConsolpempocos.dwConsolperdamplog dwConsolperdamplog");
            query.append("left join fetch dwConsolperdamplog.omProduto omProdutoPerda");
        }        

        // conjuntos - novo filtro BI
        if (filtro.getCdProdutoPai() != null) {
            query.append("LEFT JOIN omproduto.omProcomestsForIdProdutomp profilho");
            query.append("LEFT JOIN profilho.omProdutoByIdProduto propai");
        }

        query.appendWhere(MapQuery._NULL, "dwconsolid.tpId = :tpId and dwconsolid.stAtivo is null ", true);
        /*
         * Como nao existe consolidacao por mes, entao comentei o trecho abaixo que podera voltar no futuro query.appendWhere(
         * MapQuery._AND, "((dwconsolid.ano * 1000) + dwconsolid.mes) BETWEEN :ami AND :amf", filtro.getAnoInicial() != null &&
         * filtro.getMesInicial() != null && filtro.getAnoFinal() != null && filtro.getMesFinal() != null);
         */
        // //Eduardo: Trecho comentado com o intutito de considerar todos os
        // DwConsolids do Turno
        // query.appendWhere(MapQuery._AND,
        // "dwconsolid.ppCp.cdCp = :nrop and dwconsolid.ppCp.stAtivo = 1",
        // filtro.getCdCp() != null);

        /* 
         * Marcos Sardinha: 2017-01-23 - teste abaixo necessario por causa do grafico de produtos fabricados no turno.
         * Este grafico deve levar em consideracao somente a ultima op da maquina
         */
        if (filtro.getFiltroOp() != null &&  filtro.getFiltroOp() == 0 && filtro.getCdCp() ==  null && filtro.getTpId() == 1) {
            String clausulaUltimaOP = "dwconsolid.dthrFconsol = (SELECT MAX(a.dthrFconsol) "
                    + " FROM DwConsolid a " 
                    + " WHERE a.tpId = dwconsolid.tpId "
                    + "   AND a.stAtivo IS NULL "
                    + "   AND a.dwTurno.idTurno = dwconsolid.dwTurno.idTurno "
                    + "   AND a.omPt.idPt = dwconsolid.omPt.idPt " 
                    + "   AND a.dtReferencia =  dwconsolid.dtReferencia " 
                    + "   AND a.dthrFconsol IS NOT NULL)";

            String clausulaUltimaOPParAberta = "dwconsolid.idConsolid = (SELECT MAX(a.idConsolid) "
                    + " FROM DwConsolid a " 
                    + " WHERE a.tpId = dwconsolid.tpId "
                    + "   AND a.stAtivo IS NULL "
                    + "   AND a.dwTurno.idTurno = dwconsolid.dwTurno.idTurno "
                    + "   AND a.omPt.idPt = dwconsolid.omPt.idPt " 
                    + "   AND a.dtReferencia =  dwconsolid.dtReferencia " 
                    + "   AND a.dthrIconsol IS NULL)";

            clausulaUltimaOP = " (" + clausulaUltimaOP + " OR " + clausulaUltimaOPParAberta + ") "; 
            query.appendWhere(MapQuery._AND, clausulaUltimaOP, true);                     
        } else {        
            /*
             * Marcos Sardinha: 2016-10-25 - filtro de nrdoc -> utilizado no mapa das OPs Se filtroOP = 4, então CdCP na verdade traz o NrDoc
             */
        	
            //if (filtro.getCdCp() != null && filtro.getFiltroOp() == 4) {
            //    query.appendWhere(MapQuery._AND, "ppcpprodutos.nrDoc = :nrop", filtro.getCdCp() != null && filtro.getCdCp().equals("") == false
            //            && filtro.getFiltroOp() != null && filtro.getFiltroOp() == 4);
            //}
    
            /*
             * Alessandre: em 29-10-14 o filtroOP pode assumir os seguintes valores 0 = ultima OP 1 = todas as ops Se o filtroOP for igual a
             * zero, entao utilizar a ppCP que estï¿½ no filtro
             */
            query.appendWhere(MapQuery._AND, 
            		"dwconsolid.ppCp.cdCp = :cdcp", 
            		filtro.getCdCp() != null && 
            		filtro.getCdCp().equals("") == false && 
            		filtro.getFiltroOp() != null && 
            		(filtro.getFiltroOp() == 0 || filtro.getFiltroOp() == 3));
            
            /* Alessandre em 10-10-2017 acrescentei o filtro por NrDoc pois na ficha da maquina, ao acionar o botao OP
             * é necessário trazer todas as maquinas que rodaram a OP, e se utilizarmos o cdCp apenas a OP do posto sera
             * trazida
             */
            query.appendWhere(MapQuery._AND, 
            		"ppcpprodutos.nrDoc = :nrop", 
            		filtro.getNrDoc() != null && 
            		filtro.getNrDoc().equals("") == false && 
            		filtro.getFiltroOp() != null && 
            		(filtro.getFiltroOp() == 0 || filtro.getFiltroOp() == 3));
            
        }
            
        // Na clausula abaixo para filtrar OmPt antes considerava apenas os Pts ativos, mas nao eh correto pois o pt
        // pode estar desativado mas em determinada data ele estava ativo. Nesse caso devemos mostrar o detalhe do posto
        //query.appendWhere(MapQuery._AND, "ompt.cdPt = :ompt and ompt.stAtivo = 1", filtro.getOmPt() != null);
        query.appendWhere(MapQuery._AND, "ompt.cdPt = :ompt", filtro.getOmPt() != null);

        // Marcos Sardinha: 2017-02-03 - se pt sem classe abc, considerar classe C (2)
        // Avalia se o filtro de classificacao ABC para o posto foi definido, se sim, incluir o filtro
        if (filtro.getTpClasseABCpt() != null) {
            if (filtro.getTpClasseABCpt() == 2) {
                query.appendWhere(MapQuery._AND, "(ompt.tpClasseabc = :tpabcpt OR ompt.tpClasseabc IS NULL)", filtro.getTpClasseABCpt() != null);
            } else {
                query.appendWhere(MapQuery._AND, "ompt.tpClasseabc = :tpabcpt", filtro.getTpClasseABCpt() != null);
            }
        }
        
        query.appendWhere(
                MapQuery._AND,
                "exists (select ompt from OmPt ompt join ompt.omObjs omobj where omobj.omGtByIdGt.idGt = :idGt and ompt = dwconsolid.omPt)",
                filtro.getOmGt() != null && filtro.getOmPt() == null);
        query.appendWhere(MapQuery._AND, "ppcpprodutos.omProduto.idProduto = :idProduto", filtro.getOmProduto() != null
                && filtro.getOmProduto().getIdProduto() > 0);

        query.appendWhere(MapQuery._AND, "omproduto.tpClasseabc = :tpclasseproduto", filtro.getTpClasseABCproduto() != null);

        // Se for acumulado ou OP nao filtrar o turno indefinido
        if (filtro.getTpId() != null) {
        	//Marcos Sardinha: 2017-07-17 >> Defeito #3885 ... qdo tem filtro de turno indefinido e necessita analisar hora nao recuperada dados
        	if (filtro.getTpId().equals(PERIODO_CONSOLIDACAO_HORA) == false) {
	            if (filtro.getTpId().equals(PERIODO_CONSOLIDACAO_OP) == false)
	                query.appendWhere(MapQuery._AND, "dwconsolid.dwTurno.idTurno <> 1", filtro.getDwTurno() == null);
	        }
        }

        if (filtro.getTpId() == null || filtro.getTpId().equals(DwConsolidTemplate.TpId.ACUMULADO.getValue()) == false) {
            query.appendWhere(MapQuery._AND, 
            		"dwconsolid.dtReferencia = :data", 
            		filtro.getDtReferencia() != null && 
            		filtro.getAnoInicial() == null);
            query.appendWhere(MapQuery._AND, "dwconsolid.dwTurno.idTurno = :idTurno", filtro.getDwTurno() != null);
            query.appendWhere(MapQuery._AND, 
            		"dwconsolid.dtReferencia between :dti and :dtf", 
            		filtro.getDtReferenciaInicial() != null && 
            		filtro.getDtReferenciaFinal() != null);
        }

        query.appendWhere(MapQuery._AND, "dwconsolid.dthrIhora >= :dthrIhora", filtro.getDthrIhora() != null);
        query.appendWhere(MapQuery._AND, "dwconsolid.dthrFhora <= :dthrFhora", filtro.getDthrFhora() != null);
        query.appendWhere(MapQuery._AND,
                "( omprodutoiac.cdProduto = :cdproduto or omprodutorap.cdProduto = :cdproduto or omproduto.cdProduto = :cdproduto ) ",
                filtro.getOmProduto() != null && 
                filtro.getOmProduto().getCdProduto() != null && 
                filtro.getOmProduto().getCdProduto().equals("") == false);

        // novo filtro BI
        query.appendWhere(MapQuery._AND, "dwfolharap.dwRap.cdRap = :cdmol", (filtro.getDwRap() != null));
        query.appendWhere(MapQuery._AND, "grpmol.dwGrupoFerramenta.cdGrupoFerramenta = :cdgrpmol", (filtro.getCdGrupoFerramenta() != null));
        query.appendWhere(MapQuery._AND, "propai.cdProduto = :cdProdutoPai", (filtro.getCdProdutoPai() != null));

        //Marcos Sardinha 2017-07-04: Defeito #4061
        if (filtro.getIdDwConsolId() != 0) {
        	query.appendWhere(MapQuery._AND, "dwconsolid.idConsolid = :idConsolid", true);
        }
        
        /* Alessandre em 26-10-17 acrescentei a clausula where abaixo quando o tpId for acumulado e nao for passado nenhum NrDoc ou CdCp
         * Isso aconteceu no algoritmo de classificacao abc que soliciou basicaente todos os acumulados de todas as op por falta do trecho abaixo
         */
        if (
        		filtro.getTpId() != null && 
        		filtro.getTpId().equals(DwConsolidTemplate.TpId.ACUMULADO.getValue()) &&
        		filtro.getCdCp() == null &&
        		filtro.getNrDoc() == null) {
        	query.appendWhere(MapQuery._AND, "dwconsolid.ppCp = ompt.ppCp", true);
        }
        
        query.append("order by dwconsolid.idConsolid desc");

        // preenchimento dos parametros
        query.defineParametro("idTurno", filtro.getDwTurno() != null ? filtro.getDwTurno().getIdTurno() : 0);

        if (filtro.getOmPt() != null && filtro.getOmPt().getCdPt() == null) {
            OmPt ompt = getDao().findById(OmPt.class, filtro.getOmPt().getIdPt(), false);
            filtro.getOmPt().setCdPt(ompt.getCdPt());
        }

        if (filtro.getOmPt() != null)
            query.defineParametro("ompt", filtro.getOmPt().getCdPt());

        query.defineParametro("idGt", filtro.getOmGt() != null ? filtro.getOmGt().getIdGt() : null);
        query.defineParametro("idProduto", filtro.getOmProduto() != null && filtro.getOmProduto().getIdProduto() > 0 ? filtro
                .getOmProduto().getIdProduto() : null);

        query.defineParametro("tpabcpt", filtro.getTpClasseABCpt());
        query.defineParametro("tpclasseproduto", filtro.getTpClasseABCproduto());

        query.defineParametro("cdproduto", filtro.getOmProduto() != null && filtro.getOmProduto().getCdProduto() != null && filtro.getOmProduto().getCdProduto().equals("") == false ? filtro.getOmProduto().getCdProduto() : null);
        query.defineParametroData("data", filtro.getDtReferencia() != null ? DataHoraRN.getDataSemHora(filtro.getDtReferencia()) : null);
        query.defineParametroData("dti", filtro.getDtReferenciaInicial() != null ? DataHoraRN.getDataSemHora(filtro.getDtReferenciaInicial()) : null);
        query.defineParametroData("dtf", filtro.getDtReferenciaFinal() != null ? DataHoraRN.getDataSemHora(filtro.getDtReferenciaFinal()) : null);

        if (filtro.getDthrIhora() != null) {
            query.defineParametroTimestamp("dthrIhora", filtro.getDthrIhora());
        }

        if (filtro.getDthrFhora() != null) {
            query.defineParametroTimestamp("dthrFhora", filtro.getDthrFhora());
        }

        if (filtro.getTpId() == null) {
            filtro.setTpId(DwConsolidTemplate.TpId.TURNO.getValue());
        }

        // TODO alterar esse trecho
        // mudei o periodo de consolidaÃ§Ã£o pra TURNO pois ainda nÃ£o
        // existe registros para ACUMULADO
        if (filtro.getTpId().equals(PERIODO_CONSOLIDACAO_OP)) {
            query.defineParametro("tpId", PERIODO_CONSOLIDACAO_ACUMULADO);
        } else if (filtro.getTpId() == PERIODO_CONSOLIDACAO_MES) {
            query.defineParametro("tpId", PERIODO_CONSOLIDACAO_TURNO);
        } else {
            query.defineParametro("tpId", filtro.getTpId());
        }

        // Eduardo: Trecho comentado com o intutito de considerar todos os
        // DwConsolids do Turno
        // Alessandre: em 29-10-14 reativei o trecho abaixo posi agora existe o
        // filtroOP que se for 0 (ver comentario anterior) passar a OP
        if (filtro.getCdCp() != null && filtro.getCdCp().equals("") == false) {
            query.defineParametro("cdcp", filtro.getCdCp());
        }

        // Alessandre em 10-10-2017 acrescentei a passagem do nrDoc
        if (filtro.getNrDoc() != null && filtro.getNrDoc().equals("") == false) {
            query.defineParametro("nrop", filtro.getNrDoc());
        }

        if (filtro.getAnoInicial() != null && filtro.getMesInicial() != null && filtro.getAnoFinal() != null && filtro.getMesFinal() != null) {
            query.defineParametro("ami", (filtro.getAnoInicial() * 1000) + filtro.getMesInicial());
            query.defineParametro("amf", (filtro.getAnoFinal() * 1000) + filtro.getMesFinal());
        }

        // novo filtro BI
        if (filtro.getDwRap() != null) {
            query.defineParametro("cdmol", filtro.getDwRap().getCdRap());
        }
        if (filtro.getCdGrupoFerramenta() != null) {
            query.defineParametro("cdgrpmol", filtro.getCdGrupoFerramenta());
        }

        if (filtro.getCdProdutoPai() != null) {
            query.defineParametro("cdProdutoPai", filtro.getCdProdutoPai());
        }

        //Marcos Sardinha 2017-07-04: Defeito #4061
        if (filtro.getIdDwConsolId() != 0) {
        	query.defineParametro("idConsolid", filtro.getIdDwConsolId());
        }

        
        List<DwConsolid> retorno = query.list();

        return retorno;
    }

    /**
     * MÃ©todo de produtos produzidos utilizada nos filtros do BI
     * 
     * @param filtro
     * @return
     */
    
    public ProdutosDTO getListaProdutosFiltrosBIDTO(FiltroDetalhePTInjetDTO filtro) {
        List<OmProduto> listaProdutos = new ArrayList<OmProduto>();
        List<ProdutoDTO> listaProdutoDTO = new ArrayList<ProdutoDTO>();
        ProdutosDTO retornoDTO = new ProdutosDTO();

        try {
            MapQuery query = new MapQuery(getDao().getSession());

            query.append("SELECT DISTINCT omp");
            query.append("FROM DwConsolid dwconsolid");
            query.append("JOIN dwconsolid.dwConsols dwconsols");
            query.append("JOIN dwconsols.dwConsolprs dwconsolprs");
            query.append("JOIN dwconsolprs.omProduto omp");

            query.appendWhere(MapQuery._AND, "dwconsolid.tpId = :tpId", true);
            if (filtro.getAnoInicial() != null && filtro.getMesInicial() != null && filtro.getAnoFinal() != null
                    && filtro.getMesFinal() != null) {
                query.appendWhere(MapQuery._AND, "((dwconsolid.ano * 1000) + dwconsolid.mes) BETWEEN :ami AND :amf", true);
            }

            if (filtro.getIdCp() != null) {
                query.appendWhere(MapQuery._AND, "dwconsolid.dwconsolid.ppCp.cdCp = :nrop", true);
            }

            query.appendWhere(MapQuery._AND, "dwconsolid.dtReferencia = :data", filtro.getDtReferencia() != null);
            query.appendWhere(MapQuery._AND, "dwconsolid.dwTurno.idTurno = :idTurno", filtro.getDwTurno() != null);
            query.appendWhere(MapQuery._AND, "dwconsolid.omPt = :ompt", filtro.getOmPt() != null);
            query.appendWhere(MapQuery._AND, "dwconsolid.omGt.idGt = :idGt", filtro.getOmGt() != null);
            query.appendWhere(MapQuery._AND, "ppcpprodutos.omProduto.idProduto = :idProduto", filtro.getOmProduto() != null);
            query.appendWhere(MapQuery._AND, "dwconsolid.dtReferencia between :dti and :dtf", filtro.getDtReferenciaInicial() != null
                    && filtro.getDtReferenciaFinal() != null);

            query.appendWhere(MapQuery._AND, "dwconsolid.dthrIhora >= :dthrIhora", filtro.getDthrIhora() != null);
            query.appendWhere(MapQuery._AND, "dwconsolid.dthrFhora <= :dthrFhora", filtro.getDthrFhora() != null);

            if (filtro.getDwTurno() != null) {
                query.defineParametro("idTurno", filtro.getDwTurno() != null ? filtro.getDwTurno().getIdTurno() : 0);
            }

            query.defineParametro("ompt", filtro.getOmPt());
            query.defineParametro("idGt", filtro.getOmGt() != null ? filtro.getOmGt().getIdGt() : null);
            query.defineParametro("idProduto", filtro.getOmProduto() != null ? filtro.getOmProduto().getIdProduto() : null);
            query.defineParametroData("data", filtro.getDtReferencia() != null ? DataHoraRN.getDataSemHora(filtro.getDtReferencia()) : null);
            query.defineParametroData("dti",
                    filtro.getDtReferenciaInicial() != null ? DataHoraRN.getDataSemHora(filtro.getDtReferenciaInicial()) : null);
            query.defineParametroData("dtf",
                    filtro.getDtReferenciaFinal() != null ? DataHoraRN.getDataSemHora(filtro.getDtReferenciaFinal()) : null);

            if (filtro.getDthrIhora() != null) {
                query.defineParametroTimestamp("dthrIhora", filtro.getDthrIhora());
            }

            if (filtro.getDthrFhora() != null) {
                query.defineParametroTimestamp("dthrFhora", filtro.getDthrFhora());
            }

            query.defineParametro("tpId", filtro.getTpId());

            if (filtro.getIdCp() != null) {
                query.defineParametro("nrop", filtro.getIdCp());
            }

            if (filtro.getAnoInicial() != null && filtro.getMesInicial() != null && filtro.getAnoFinal() != null
                    && filtro.getMesFinal() != null) {
                query.defineParametro("ami", (filtro.getAnoInicial() * 1000) + filtro.getMesInicial());
                query.defineParametro("amf", (filtro.getAnoFinal() * 1000) + filtro.getMesFinal());
            }

            listaProdutos = query.list();

            if (listaProdutos != null) {
                for (OmProduto produto : listaProdutos) {
                    ProdutoDTO prodDTO = new ProdutoDTO();
                    prodDTO.setProduto(produto.clone(false));
                    listaProdutoDTO.add(prodDTO);
                }
            }

            retornoDTO.setProdutos(listaProdutoDTO);
            return retornoDTO;

        } catch (Exception e) {
            e.printStackTrace();
            return new ProdutosDTO();
        }

    }

    private void ordenaListas(List<DwConsolid> listaDwconsolid) {
        Collections.sort(listaDwconsolid, new Comparator<DwConsolid>() {
            @Override
            public int compare(final DwConsolid o1, final DwConsolid o2) {
                final DwConsolid dwConsolid1 = o1;
                final DwConsolid dwConsolid2 = o2;
                return Long.valueOf(dwConsolid1.getIdConsolid()).compareTo(Long.valueOf(dwConsolid2.getIdConsolid()));
            }
        });
    }

    public static void main(String[] args) {
        // testGetDetalheCelulas();
        testGetDetalheCelulas2();

    }

    public static void testGetDetalheCelulas2() {
        DetalheMonitorizacaoPTInsertRN detalheMonitorizacaoPTInjetRN = new DetalheMonitorizacaoPTInsertRN();
        detalheMonitorizacaoPTInjetRN.iniciaConexaoBanco();
        FiltroProducaoDTO filtro = new FiltroProducaoDTO();
        filtro.setDtReferencia(DataHoraRN.getData(2013, 04, 18));
        filtro.setDwTurno(new DwTurno());
        filtro.getDwTurno().setIdTurno(2L);
        filtro.setOmGt(new OmGt());
        filtro.getOmGt().setId(107L);
        filtro.setTpId((byte) 1);
        filtro.setListaFiltroProducaoPtCp(new ArrayList<FiltroProducaoPtCpDTO>());

        FiltroProducaoPtCpDTO filtroProducaoPtCpDTO = new FiltroProducaoPtCpDTO();
        OmPt omPt = new OmPt();
        PpCp ppCp = new PpCp();
        // omPt.setIdPt(100L);
        // ppCp.setCdCp("L1_SH26_35B2199011_TOP_T04");
        ppCp.setIdCp(644L);
        // L1_SH26_35B2199011_TOP_T04 644

        filtroProducaoPtCpDTO.setOmPt(omPt);
        filtroProducaoPtCpDTO.setPpCp(ppCp);
        filtro.getListaFiltroProducaoPtCp().add(filtroProducaoPtCpDTO);

        detalheMonitorizacaoPTInjetRN.finalizaConexaoBanco();
    }

    public static void testGetDetalheCelulas() {
        DetalheMonitorizacaoPTInsertRN detalheMonitorizacaoPTInjetRN = new DetalheMonitorizacaoPTInsertRN();
        detalheMonitorizacaoPTInjetRN.iniciaConexaoBanco();
        FiltroProducaoDTO filtro = new FiltroProducaoDTO();
        filtro.setDtReferencia(DataHoraRN.getData(2013, 04, 18));
        filtro.setDwTurno(new DwTurno());
        filtro.getDwTurno().setIdTurno(2L);
        filtro.setOmGt(new OmGt());
        filtro.getOmGt().setId(107L);
        filtro.setTpId((byte) 1);

        detalheMonitorizacaoPTInjetRN.finalizaConexaoBanco();
    }

    public ListaIndicadoresDTO getProducaoBrutaPt(FiltroProducaoDTO filtro) {
        ListaIndicadoresDTO retornoListaIndicadores = new ListaIndicadoresDTO();
        List<IndicadoresDTO> lista = new ArrayList<IndicadoresDTO>();

        byte tpId = filtro.getTpId();

        OmCfg omcfg = Util.getConfigGeral(getDaoSession());

        try {
            List<DwConsolid> listadwconsolid = getDwConsolid(null, tpId, filtro.getDwTurno(), null, null, filtro.getDtReferencia(), null,
                    null, null, null, null, null, true, false, false, 0, filtro.getOmGt(), filtro.getListaFiltroProducaoPtCp(), false,
                    false, false);

            IndicadoresDTO ind;
            if (listadwconsolid != null) {
                for (DwConsolid dwConsolid : listadwconsolid) {
                    IndicadoresDTO aux = IndicadoresDTO.newInstance(dwConsolid, omcfg, getDao());
                    ind = new IndicadoresDTO();
                    ind.setDtHrIPeriodo(aux.getDtHrIPeriodo());
                    ind.setProducaoBruta(aux.getProducaoBruta());
                    lista.add(ind);
                }
            } else {
                retornoListaIndicadores = new ListaIndicadoresDTO();
            }

            if (lista != null && !lista.isEmpty()) {
                retornoListaIndicadores.setListaIndicadores(lista);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retornoListaIndicadores;
    }

    public DetalheAnaliseGargaloDTO getDetalheCelulas(FiltroProducaoDTO filtro) {
        DetalheAnaliseGargaloDTO retorno = new DetalheAnaliseGargaloDTO();
        byte tpId = filtro.getTpId();

        try {
            List<DwConsolid> listadwconsolid = getDwConsolid(null, tpId, filtro.getDwTurno(), null, null, filtro.getDtReferencia(), null,
                    null, null, null, null, null, false /*
                                                         * alessandre mudei pra false deu problema???
                                                         */, false, false, 0, filtro.getOmGt(), filtro.getListaFiltroProducaoPtCp(), false,
                    false, false);
            if (listadwconsolid != null) {
                retorno = preecheValoresDetalheGargalo(listadwconsolid);
            } else {
                retorno = new DetalheAnaliseGargaloDTO();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;

    }



	/**
	 * Funcao especializada para uso da VF-WEB, derivada de outra; vem de [getDetalheCelulas(FiltroProducaoDTO filtro)], a original. Esta aqui requer passar adicionalmente um BOOLEAN; se [gargalosAgrupados==true] agrupa os dados de alguns indicadores (temposciclos) omPts (já previamente agrupados) por TpPt também.
	 * 
	 *  @param FiltroProducaoDTO, boolean
	 *  @return Retorna um objeto (DetalheAnaliseGargaloDTO); mesmo tipo que da funcao original.
	 */
    public DetalheAnaliseGargaloDTO getDetalheCelulas(FiltroProducaoDTO filtro, boolean gargalosAgrupados) {
        DetalheAnaliseGargaloDTO retorno = new DetalheAnaliseGargaloDTO();
        byte tpId = filtro.getTpId();

        try {
            List<DwConsolid> listadwconsolid = getDwConsolid(null, tpId, filtro.getDwTurno(), null, null, filtro.getDtReferencia(), null,
                    null, null, null, null, null, false /*
                                                         * alessandre mudei pra false deu problema???
                                                         */, false, false, 0, filtro.getOmGt(), filtro.getListaFiltroProducaoPtCp(), false,
                    false, false);
            if (listadwconsolid != null) {
            	
            	if (gargalosAgrupados){            		//190417 
                    retorno = preecheValoresDetalheGargalo(listadwconsolid, gargalosAgrupados); //190417 
            	}else {
                    retorno = preecheValoresDetalheGargalo(listadwconsolid);

            	}
            } else {
                retorno = new DetalheAnaliseGargaloDTO();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;

    }
    

    /**
     * Pega os detalhes da produÃ§Ã£o, parada e refugos
     * 
     * @param filtro
     *            <p>
     *            filtro.getOmPt: filtra por um posto de trabalho
     *            <p>
     *            filtro.getDtReferencia: filtra pela data de referencia do turno
     *            <p>
     *            filtro.getDtReferenciaInicial e filtro.getDtReferenciaInicial: filtra pelo intervalo da data de referencia
     *            <p>
     *            filtro.getDwTurno: filtra para o turno
     * @return
     */
    public DetalhamentoProducaoDTO getDetalhamentoProducao(FiltroDetalheProducaoDTO filtro) {
        DetalhamentoProducaoDTO retorno = new DetalhamentoProducaoDTO();
        try {

            byte tpId = (filtro.getTpId() == null ? DwConsolidTemplate.TpId.TURNO.getValue() : filtro.getTpId());

            Date dthrIturno = null;
            Date dthrFturno = null;
            Date dthrIhora = null;

            if (DwConsolidTemplate.TpId.HORA.getValue().equals(tpId)) {
                dthrIhora = filtro.getDthrinicio();

                // Pesquisa pelo intervalo do turno
            } else if (DwConsolidTemplate.TpId.TURNO.getValue().equals(tpId)) {
                dthrIturno = filtro.getDthrinicio();
                dthrFturno = filtro.getDthrfim();
            }

            if (filtro.getIdCp() != 0) {
                filtro.setPpCp(new PpCp());
                filtro.getPpCp().setIdCp(filtro.getIdCp());
            }

            List<DwConsolid> listadwconsolid = null;
            if (filtro.getIddwConsolid() != 0) {
                //Marcos Sardinha 2017-07-04: Defeito #4061
            	listadwconsolid = getDwConsolid(null, filtro.getIddwConsolid(), true, false, false, false, false, false);
            } else {
	            listadwconsolid = getDwConsolid(null, tpId, filtro.getOmpt(), filtro.getPpCp(), filtro.getDwTurno(), null, null, null, null,
	                    null, dthrIturno, dthrFturno, dthrIhora, null /* fim da hora */, true, false, false, false, null, false, false, false);
            }
            
            if (listadwconsolid != null) {
                preencherValoresDetalheProducao(retorno, listadwconsolid, filtro);
            } else {
                preenchervaloresdefaultdetalheproducao(retorno);
            }

        } catch (Exception e) {
            e.printStackTrace();
            retorno.setListaparadas(null);
            retorno.setListaproducao(null);
            retorno.setListarefugos(null);
            return retorno;
        }
        return retorno;
    }

    public GraficoDetalhePtDTO getGraficoDetalhePtBIDTO(FiltroGraficoDetalhePtDTO filtro) {
        GraficoDetalhePtDTO retorno = new GraficoDetalhePtDTO();
        DwConsolidDTOs dwconsolidDTOs = new DwConsolidDTOs();
        List<DwConsolidDTO> listaDwConsolidDTO = new ArrayList<DwConsolidDTO>();
        MapQuery query = new MapQuery(getDao().getSession());

        query.append("SELECT distinct dwconsolid");
        query.append("FROM DwConsolid dwconsolid");
        query.append("join fetch dwconsolid.dwConsols dwconsol");
        query.append("left join fetch dwconsolid.dwFolha dwfolha");
        // query.append("left join fetch dwconsolid.dwCal dwcal");
        // query.append("left join fetch dwcal.dwCalsems dwcalsems");
        query.append("left join fetch dwfolha.ppCps ppcp");
        query.append("left join fetch ppcp.ppCpprodutos ppcpprodutos");
        query.append("WHERE dwconsolid.tpId = 1");
        if (filtro.getOmPt() != null) {
            query.append("AND dwconsolid.omPt.idGt =:idGt");
        }
        if (filtro.getDwTurno() != null) {
            query.append("AND dwconsolid.dwTurno.idTurno =:idTurno");
        }

        if (filtro.getDtReferenciaInicial() != null && filtro.getDtReferenciaFinal() != null) {
            query.append("AND dwconsolid.dtReferencia >= :dtrefinicial");
            query.append("AND dwconsolid.dtReferencia <= :dtreffinal");
        } else {
            if (filtro.getDtReferenciaFinal() != null) {
                query.append("AND dwconsolid.dtReferencia <= :dtreffinal");
            }
            if (filtro.getDtReferencia() != null && filtro.getDtReferencia().getTime() > 0) {
                query.append("AND dwconsolid.dtReferencia = :dtref");
            }
        }

        query.defineParametro("idTurno", filtro.getDwTurno() != null ? filtro.getDwTurno().getIdTurno() : 0);
        query.defineParametro("idGt", filtro.getOmGt() != null ? filtro.getOmGt().getIdGt() : 0);
        query.defineParametroData("dtref", filtro.getDtReferencia());
        query.defineParametroData("dtreffinal", filtro.getDtReferenciaFinal());
        query.defineParametroData("dtrefinicial", filtro.getDtReferencia());
        List<DwConsolid> listadwconsolid = query.list();

        if (listadwconsolid != null) {
            for (DwConsolid dwconsolid : listadwconsolid) {
                DwConsolidDTO dto = new DwConsolidDTO();
                dto.setDwConsolid(dwconsolid.clone(true));

                /*
                 * if (dwconsolid.getDwConsols() != null){ for(DwConsol dwconsol :dwconsolid.getDwConsols()){ if (dwconsol.getDwConsolpas()
                 * != null){ for(){
                 * 
                 * } } } }
                 */
                listaDwConsolidDTO.add(dto);
            }
        }

        dwconsolidDTOs.setListaDwConsolidDTO(listaDwConsolidDTO);
        retorno.setDwConsolidDTOs(dwconsolidDTOs);
        return retorno;
    }
    
    private OmAlim obtemUltimaAlimentacaoComSucesso(String cdpt) {
    	MapQuery q = new MapQuery(getDaoSession());
    	q.append("select a");
    	q.append("  FROM OmAlim a");
    	q.append("  JOIN a.omAlimreas b");
    	q.append("  JOIN a.omMapa c");
    	q.append("  JOIN b.omMapapa d");
    	q.append("  JOIN d.omProduto p");
    	q.append("join c.omPt ompt");
    	q.append(" WHERE a.tpAlim = :tipoAlim ");
    	q.append("   AND a.stAlim = :statusAlim");
    	q.append("   AND b.tpLeitura <> :tipoLeituraDesalimentacao");
    	q.append("   AND b.stLeitura = :statusLeitura");
    	q.append("   AND ompt.cdPt = :cdpt");
    	q.append("and ompt.stAtivo = 1");
    	q.append("order by a.idAlim desc");

		q.defineParametro("tipoAlim", OmAlimTemplate.TpAlim.ALIMENTACAO.getId());
		q.defineParametro("statusAlim", OmAlimTemplate.StAlim.SUCESSO.getId());
		q.defineParametro("tipoLeituraDesalimentacao", OmAlimreaTemplate.TpLeitura.DESALIMENTACAO.getId());
		q.defineParametro("statusLeitura", OmAlimreaTemplate.StLeitura.SUCESSO.getId());
		q.defineParametro("cdpt", cdpt);

		q.setMaxResults(1);
		
		return (OmAlim) q.uniqueResult();

    
    }

    private BigDecimal getComponentesAlimentados(String cdPt, Date dtHrIniOPTurno, Date dtHrFimOPTurno, OmProduto omproduto) {
    	BigDecimal qtdAlimentados = BigDecimal.ZERO;
    			
    	MapQuery q = new MapQuery(getDaoSession());
    	q = new MapQuery(getDaoSession());
    	
    	OmAlim ultimaAlimentacao = obtemUltimaAlimentacaoComSucesso(cdPt);
    	
    	if (ultimaAlimentacao == null)
    		return BigDecimal.ZERO;
    	
    	// O select abaixo deve retornar a quantidade alimentada e realimentada com sucesso na maquina, considerando a ultima
    	// alimentacao
    	q.append("SELECT SUM(b.qtAlimentada) as qtdalimentada ");
    	q.append("  FROM OmAlim a");
    	q.append("  JOIN a.omAlimreas b");
    	q.append("  JOIN a.omMapa c");
    	q.append("  JOIN b.omMapapa d");
    	q.append("  JOIN d.omProduto p");
    	q.append("  JOIN c.omPt ompt");
    	q.append(" WHERE a.tpAlim = :tipoAlim ");
    	q.append("   AND a.stAlim = :statusAlim");
//    	q.append("   AND b.dthrLeitura BETWEEN :dthrini AND :dthrfim ");
    	q.append("   AND b.tpLeitura <> :tipoLeituraDesalimentacao");
    	q.append("   AND b.stLeitura = :statusLeitura");
    	q.append("   AND p.idProduto = :idcomponente");
    	q.append("   AND ompt.cdPt = :cdpt");
    	q.append("and a = :omalim");

    	
		q.defineParametro("tipoAlim", OmAlimTemplate.TpAlim.ALIMENTACAO.getId());
		q.defineParametro("statusAlim", OmAlimTemplate.StAlim.SUCESSO.getId());
//		q.defineParametro("dthrini", dtHrIniOPTurno);
//		q.defineParametro("dthrfim", dtHrFimOPTurno);
		q.defineParametro("tipoLeituraDesalimentacao", OmAlimreaTemplate.TpLeitura.DESALIMENTACAO.getId());
		q.defineParametro("statusLeitura", OmAlimreaTemplate.StLeitura.SUCESSO.getId());
		q.defineParametro("idcomponente", omproduto.getIdProduto());
		q.defineParametro("cdpt", cdPt);
		q.defineParametro("omalim", ultimaAlimentacao);
		q.setMaxResults(1);
		List<Object> lista = q.list();		
		qtdAlimentados = ConversaoTipos.converterParaBigDecimal(lista.get(0));
		if (qtdAlimentados == null) {
			qtdAlimentados = BigDecimal.ZERO;
		}

		return qtdAlimentados;
    }
    
    
    private PosicaoCODTO getComponentesUsadosMapa(
    		String cdPt, 
    		long idProduto, 
    		Date dtHrIniOPTurno, 
    		Date dtHrFimOPTurno, 
    		Long idComponente, 
    		Date dthrPerdaMP, 
    		DwFolha dwfolha,
    		DwConsolperdamplog dwConsolperdamplog) { // talvez esse parametro seja usado para corrigir a situacao em que a perda foi lancada mas em algum momento o mapa mudou e deixou de ter o componente
    	
    	BigDecimal qtdUsados = BigDecimal.ZERO;
    	long idMapa = 0;
    	
    	int _idMapa = 0;
    	int _dtHrIniLeitura = _idMapa + 1;
    	int _dtHrFimLeitura = _dtHrIniLeitura + 1;
    	
    	class RegistroLido{
        	long idMapaLido;
        	Date dtHrIniLeitura;
        	Date dtHrFimLeitura;		
    	}
    	List<RegistroLido> listaMapas = new ArrayList<RegistroLido>();
    	// Encontra o codigo do produto para ser usado ao inves do id pois o id pode ter sido desaativado
    	OmProduto omproduto = dwConsolperdamplog.getOmProduto();
    	
    	
    	MapQuery q = new MapQuery(getDaoSession());
    	
    	
    	// Obtem o intervalo de leitura minima e maxima das alimentacoes. Para que??
    	q = new MapQuery(getDaoSession());
    	q.append("SELECT a.idMapa, MIN(d.dthrLeitura) as dthrIniLeitura, MAX(d.dthrLeitura) as dthrFimLeitura ");
    	q.append("  FROM OmMapa a");
    	q.append("  JOIN a.omPt  b");
    	q.append("  JOIN a.omAlims c");
    	q.append("  JOIN c.omAlimreas d");
    	q.append(" WHERE b.cdPt = :cdpt");
    	//q.append("   AND a.omProduto.idProduto = :idproduto");
    	q.append("   AND d.dthrLeitura BETWEEN :dthrini AND :dthrfim");
    	q.append(" GROUP BY a.idMapa");
		q.defineParametro("cdpt", cdPt);
		//q.defineParametro("idproduto", idProduto);
		q.defineParametro("dthrini", dtHrIniOPTurno);
		q.defineParametro("dthrfim", dtHrFimOPTurno);
		
    	List<Object> lista = q.list();

    	if (lista.size() == 0) {
    		// se nao encontrou recua pra tentar utilizar o ultimo mapa utilizado
        	q = new MapQuery(getDaoSession());
        	q.append("SELECT a.idMapa, MIN(d.dthrLeitura) as dthrIniLeitura, MAX(d.dthrLeitura) as dthrFimLeitura ");
        	q.append("  FROM OmMapa a");
        	q.append("  JOIN a.omPt  b");
        	q.append("  JOIN a.omAlims c");
        	q.append("  JOIN c.omAlimreas d");
        	q.append(" WHERE a.omPt.cdPt = :cdpt");
        	//q.append("   AND a.omProduto.idProduto = :idproduto");
        	q.append("   AND d.dthrLeitura < :dthrini");
        	q.append(" GROUP BY a.idMapa");
        	q.append(" ORDER BY 2 DESC");
    		q.defineParametro("cdpt", cdPt);
    		//q.defineParametro("idproduto", idProduto);
    		q.defineParametro("dthrini", dtHrIniOPTurno);
    		q.setMaxResults(1);
        	lista = q.list();    		
    	}
    	
    	/* Alessandre em 25-09-18 acrescentei o if abaixo pois na GBR e Braslux nao se usa o CF mas pode-se ter o mapa de alimentação
    	 * entao vou usar o codigo da folha para encontrar o mapa. Nao estou prevendo caso se use OP
    	 */
    	if (lista.isEmpty()) {
    		q = new MapQuery(getDaoSession());
        	q.append("SELECT a.idMapa, MIN(a.dtRevisao) as dthrIniLeitura, MAX(a.dtRevisao) as dthrFimLeitura ");
        	q.append("  FROM OmMapa a");
        	q.append("  JOIN a.omPt  b");
        	q.append(" WHERE a.omPt.cdPt = :cdpt");
        	q.append("and :cdmapa like (a.cdMapa || '%') ");
        	q.append("and a.stAtivo = 1");
        	q.append(" GROUP BY a.idMapa");
        	q.append(" ORDER BY 2 DESC");
    		q.defineParametro("cdpt", cdPt);
    		q.defineParametro("cdmapa", dwfolha.getCdFolha());
    		q.setMaxResults(1);
        	lista = q.list();    		
    	}
    	
    	
    	// A lista contem a hora minima e maxima das revisoes do mapa
		for (Object reg : lista) {
			Object[] registro = (Object[]) reg;
			RegistroLido regLido = new RegistroLido();
			
			regLido.idMapaLido = (Long) registro[_idMapa];
			regLido.dtHrIniLeitura = (Date) registro[_dtHrIniLeitura];
			regLido.dtHrFimLeitura = (Date) registro[_dtHrFimLeitura];
			
			listaMapas.add(regLido);
		}
    
		// ordena
        Collections.sort(listaMapas, new Comparator<RegistroLido>() {
            @Override
            public int compare(RegistroLido o1, RegistroLido o2) {
                int retorno = 0;
                retorno = o1.dtHrIniLeitura.compareTo(o2.dtHrIniLeitura);
                return retorno;
            }
        });
		
        if (listaMapas.size() > 0) {
        	if (DataHoraRN.before(dthrPerdaMP, listaMapas.get(0).dtHrIniLeitura)) {
        		idMapa = listaMapas.get(0).idMapaLido;
        	} else {
        		if (DataHoraRN.after(dthrPerdaMP, listaMapas.get(listaMapas.size()-1).dtHrFimLeitura)) {
        			idMapa = listaMapas.get(listaMapas.size()-1).idMapaLido;
        		} else {
        			idMapa = listaMapas.get(listaMapas.size()-1).idMapaLido;
        			for (RegistroLido reg : listaMapas) {        				
        				if (DataHoraRN.between(dthrPerdaMP, reg.dtHrIniLeitura, reg.dtHrFimLeitura)) {
        					idMapa = reg.idMapaLido;
        					break;
        				} else {
        					// necessario para apt de perdas que nao se encaixem nos intervalos min e max de cada maapa
        					if (DataHoraRN.before(dthrPerdaMP, reg.dtHrIniLeitura)) {
        						idMapa = reg.idMapaLido;	
        						break;
        					}        					 
        				}
        			}
        		}
        	}
        }
        
    	// Encontra o codigo do mapa a partir do id para usar o codigo ao inves do id, pois o id pode ser de um mapa
    	// excluido
    	OmMapa ommapa = getDao().findById(OmMapa.class, idMapa, false);
    	
    	// Se o mapa nao existir entao pode ser que a posicao seja referente a um posto de reprocesso. nesse caso retornar nesse momento
    	if (ommapa == null || idMapa == 0) {
    		PosicaoCODTO retorno = new PosicaoCODTO();
    		retorno.setQtdeConsumidaPorCiclo(BigDecimal.ZERO);
    		retorno.setCdMapa(cdPt);
    		retorno.setCdFeeder(cdPt);
    		retorno.setCdProduto(dwConsolperdamplog.getOmProduto().getCdProduto());
    		OmMapapa ommapapa = new OmMapapa();
    		ommapapa.setOmProduto(dwConsolperdamplog.getOmProduto().clone(false));
    		getDao().evict(ommapapa);
    		retorno.setOmmapapa(ommapapa);
    		return retorno;
    	}
    	

        q = new MapQuery(getDaoSession());
    	q.append(" SELECT SUM(a.qtUsada) as qtdUsada ");
    	q.append("  FROM OmMapapa a");
    	q.append("join a.omMapa b");
    	q.append("join a.omProduto c");
    	q.append("join b.omPt d");
    	q.append(" WHERE b.cdMapa = :cdmapa");
    	q.append("   AND c.cdProduto = :cdproduto");
    	q.append("and d.cdPt = :cdpt");
    	q.append("and b.stAtivo = 1");
    	q.append("and c.stAtivo = 1");
    	q.append("and d.stAtivo = 1");
		q.defineParametro("cdmapa", ommapa.getCdMapa());
		q.defineParametro("cdproduto", omproduto.getCdProduto());
		q.defineParametro("cdpt", cdPt);
		q.setMaxResults(1);
		qtdUsados = (BigDecimal) q.uniqueResult();
		
		if (qtdUsados == null)
			qtdUsados = BigDecimal.ZERO;

		
		// Obtem o ommapapa para ser apresentado na tabela de justificativa do calculo do indice de perda MP
		q.novaConsulta();
		q.append("select a");
		q.append("from OmMapapa a");
		q.append("join a.omMapa b");
		q.append("join a.omProduto c");
		q.append("where b.cdMapa = :cdmapa");
		q.append("and c.cdProduto = :cdproduto");
		q.append("and b.stAtivo = 1");
		q.append("and c.stAtivo = 1");
		
		q.defineParametro("cdmapa", ommapa.getCdMapa());
		q.defineParametro("cdproduto", omproduto.getCdProduto());
		
		q.setMaxResults(1);
		
		OmMapapa ommapapa = (OmMapapa) q.uniqueResult();
		
         
		PosicaoCODTO retorno = new PosicaoCODTO();
		retorno.setQtdeConsumidaPorCiclo(qtdUsados);
		if (ommapapa != null) {
			retorno.setCdMapa(ommapapa.getOmMapa().getCdMapa());
			retorno.setCdFeeder(ommapapa.getOmPa().getCdPa());
		}
		retorno.setOmmapapa(ommapapa);
		
		
    	return retorno;
    }
    
    private Map<Date, PeriodoDTO> getPeriodoOPNoTurno(DwConsolid dwci) {
    	Map<Date, PeriodoDTO> mapPeriodo = new HashMap<Date, PeriodoDTO>();
    	Date dthrAtual = DataHoraRN.getDataHoraAtual();
    	
    	MapQuery q = new MapQuery(getDaoSession());
    	
    	q = new MapQuery(getDaoSession());
    	q.append("SELECT DISTINCT a");
    	q.append("  FROM PpCpentsai a");
    	q.append(" WHERE ( ");
    	q.append("           (a.dthrInicio BETWEEN :dthrIniTur  AND :dthrFimTur) ");
    	q.append("        OR (a.dthrFim    BETWEEN :dthrIniTur  AND :dthrFimTur) ");
    	q.append("        OR (:dthrIniTur  BETWEEN a.dthrInicio AND a.dthrFim) ");
    	q.append("        OR (a.dthrFim IS NULL AND a.dthrInicio  <= :dthrIniTur ) ");
    	q.append("       ) ");
    	q.append("   AND a.ppCp.cdCp = :cdCp ");
		q.defineParametro("cdCp", dwci.getPpCp().getCdCp());
		q.defineParametro("dthrIniTur", dwci.getDthrIturno());
		q.defineParametro("dthrFimTur", dwci.getDthrFturno());
		
		List<PpCpentsai> lista = q.list();
		
		for (PpCpentsai ppcpEntSai : lista) {
	    	PeriodoDTO periodo = new PeriodoDTO();
			periodo.setDtHrInicio(ppcpEntSai.getDthrInicio());
			periodo.setDtHrFim(ppcpEntSai.getDthrFim());
			
			if (DataHoraRN.after(dwci.getDthrIturno(), periodo.getDtHrInicio())) {
				periodo.setDtHrInicio(dwci.getDthrIturno());
			}
			
			if (periodo.getDtHrFim() != null) {    			
    			if (DataHoraRN.before(dwci.getDthrFturno(), periodo.getDtHrFim())) {
    				periodo.setDtHrFim(dwci.getDthrFturno());
    			}
			} else {
    			if (DataHoraRN.after(dthrAtual, dwci.getDthrFturno())) {
    				periodo.setDtHrFim(dwci.getDthrFturno());
    			} else {
    				periodo.setDtHrFim(dthrAtual);
    			}
			}    			
			if (mapPeriodo.containsKey(periodo.getDtHrInicio()) == false) {			
				mapPeriodo.put(periodo.getDtHrInicio(), periodo);
			}
		}  
		
    	return mapPeriodo;
    }
    
    
    /**
     * Substiuido pelo mesmo metodo na classe GraficoPerdaMateriaPrima
     * @param filtro
     * @return
     */
    @Deprecated
    public ListaPerdasmpDTO getGraficoPerdasMateriaPrima(FiltroGraficoDetalhePtDTO filtro) {
    	StringBuilder nomeLog = new StringBuilder();
    	
    	nomeLog.append("getGraficoPerdasMateriaPrima-gt-");
    	if (filtro.getOmGt() != null)
    		nomeLog.append(filtro.getOmGt().getCdGt());
    	nomeLog.append("-pt-");
    	if (filtro.getOmPt() != null)
    		nomeLog.append(filtro.getOmPt().getCdPt());
    	
    	IdwLogger log = new IdwLogger(nomeLog.toString());
    	int idLog = log.getIdAleatorio();
    	
    	log.iniciaAvaliacao("getGraficoPerdasMateriaPrima");
    	
    	boolean isVisaoGT = filtro.getOmGt() != null;

        ListaPerdasmpDTO retorno = new ListaPerdasmpDTO();
        retorno.setPerdasmpDTOs(new ArrayList<PerdasmpDTO>());
        retorno.setPerdasmpOPDTOs(new ArrayList<PerdasmpDTO>());
        retorno.setPerdasmpAlimDTOs(new ArrayList<PerdasmpDTO>());
        retorno.setPerdasmpRapDTOs(new ArrayList<PerdasmpDTO>());

        Byte tpId = filtro.getTpId();

        if (filtro.getIdCp() != null) {
            filtro.setPpCp(new PpCp());
            filtro.getPpCp().setIdCp(filtro.getIdCp());
        }

        log.iniciaAvaliacao(idLog, "getDwConsolid");
        List<DwConsolid> listadwconsolid = this.getDwConsolid(null, tpId, filtro.getOmPt(), filtro.getPpCp(), filtro.getDwTurno(),
                filtro.getDwTParada(), null, filtro.getDtReferencia(), filtro.getDtReferenciaInicial(), filtro.getDtReferenciaFinal(),
                filtro.getDthrIturno(), filtro.getDthrFturno(), filtro.getDthrIhora(), filtro.getDthrFhora(), false, false, false, true,
                filtro.getOmGt(), true, false, false);

        log.mostrarAvaliacaoCompleta(idLog, 0);
        
        Map<String, PerdasmpDTO> listaPerdamp = new HashMap<String, PerdasmpDTO>();
        Map<String, PerdasmpDTO> listaRap = new HashMap<String, PerdasmpDTO>();
        Map<String, BigDecimal> listaCiclosExecPorCp = new HashMap<String, BigDecimal>();
        Map<String, BigDecimal> listaCiclosPrevPorCp = new HashMap<String, BigDecimal>();

        
        // total de ciclos executados por cp
        log.iniciaAvaliacao(idLog, "1o loop");
        for (DwConsolid consolid : listadwconsolid) {        	
            for (DwConsol dwconsol : consolid.getDwConsols()) {
            	BigDecimal qtdCiclosExecCP =  AritmeticaUtil.somar(dwconsol.getQtAutoCicloprodutivo(), dwconsol.getQtManuCicloprodutivo());
            	String cdCp = consolid.getPpCp().getCdCp();
            	
                BigDecimal qtdPcsCiclo = consolid.getDwConsol().getQtAutoCavativas();
                BigDecimal qtdCiclosPrev = consolid.getPpCp().getPpCpprodutos().iterator().next().getPcsProducaoplanejada();
                qtdCiclosPrev = AritmeticaUtil.dividir(qtdCiclosPrev, qtdPcsCiclo);
            	
            	if (listaCiclosExecPorCp.containsKey(cdCp)) {
            		qtdCiclosExecCP = AritmeticaUtil.somar(qtdCiclosExecCP, listaCiclosExecPorCp.get(cdCp));
            		listaCiclosExecPorCp.put(cdCp, qtdCiclosExecCP);
            		listaCiclosPrevPorCp.put(cdCp, qtdCiclosPrev);
            	} else {
            		listaCiclosExecPorCp.put(cdCp, qtdCiclosExecCP);
            		listaCiclosPrevPorCp.put(cdCp, qtdCiclosPrev);
            	}            
            }
        }
        log.mostrarAvaliacaoCompleta(idLog, 0);
        
        // Avalia as perdas de componente
        log.iniciaAvaliacao(idLog, "2o loop");
        long segGetComponentesUsadosMapa = 0l;
        long segGetComponentesUsadosMapa2 = 0l;
        for (DwConsolid consolid : listadwconsolid) {
        	Map<Date, PeriodoDTO> periodosOP = getPeriodoOPNoTurno(consolid);
        	
            DwConsol dwconsol = consolid.getDwConsols().iterator().next();

            log.info(idLog, 0, "qtde DwConsolpemps.size=" + dwconsol.getDwConsolpemps().size());
                for (DwConsolpemp consolpemp : dwconsol.getDwConsolpemps()) {
                	
                	// Ordena por dwconsolpeerdamplog asc com o objetivo de avaliacao na obtencao dos valores dos logs que hora le de forma diferente
                	List<DwConsolpempoco> lista = new ArrayList<DwConsolpempoco>(consolpemp.getDwConsolpempocos());
                	Collections.sort(lista, new Comparator<DwConsolpempoco>() {

						@Override
						public int compare(DwConsolpempoco o1, DwConsolpempoco o2) {
							DwConsolperdamplog c1 = o1.getDwConsolperdamplog();
							DwConsolperdamplog c2 = o2.getDwConsolperdamplog();
							
							return c1.getDthrPerdamp().compareTo(c2.getDthrPerdamp());
						}
					});

                	log.info(idLog, 0, "lista.size=" + lista.size());
                    for (DwConsolpempoco dwConsolpempoco : lista) {
                        // Agrupa por perda mp
                        DwConsolperdamplog dwConsolperdamplog = dwConsolpempoco.getDwConsolperdamplog();
                        
                        
                        // Eduardo: comentei porque esse trecho nÃ£o estava
                        // sendo usado pra nada
                        // if(isControleQtdeComponentesUsados){
                        // getQtdeComponentesUsados(dwConsolperdamplog.getOmProduto());
                        // isControleQtdeComponentesUsados = false;
                        // }

                        boolean isIncrementaQtPerdaMpPorProduto = true;
                        
                        PerdasmpDTO perdasmpDTO = null;
                        if(isVisaoGT) {
                        	perdasmpDTO = listaPerdamp.get(consolid.getOmPt().getCd() + "-" + dwConsolperdamplog.getOmProduto().getCdProduto());
                        } else {
                        	perdasmpDTO = listaPerdamp.get("*" + dwConsolperdamplog.getOmProduto().getCdProduto());
                        }

                        if (perdasmpDTO == null) {
                            perdasmpDTO = new PerdasmpDTO();
                            perdasmpDTO.setCdsRaps(new ArrayList<String>());
                            perdasmpDTO.setLogs(new ArrayList<DwConsolperdamplog>());
                            perdasmpDTO.setDwRap(dwConsolperdamplog.getDwRap().clone(false));
                            perdasmpDTO.setDwTPerdamp(dwConsolperdamplog.getDwTPerdamp().clone(false));
                            perdasmpDTO.setOmproduto(dwConsolperdamplog.getOmProduto().clone(false));
                            perdasmpDTO.setQuantidade(new Double(0));
                            perdasmpDTO.setPreco(dwConsolperdamplog.getOmProduto().getVlCustounit());
                            perdasmpDTO.setCdUP(consolid.getOmPt().getCd());
                            perdasmpDTO.setOmPt(consolid.getOmPt().clone(false));
                            perdasmpDTO.getOmPt().setOmTppt(consolid.getOmPt().getOmTppt().clone(false));

                            perdasmpDTO.setQuantidadePrevistaOP(new Double(0));
                            perdasmpDTO.setIndiceDePerdaOP(new Double(0));
                            perdasmpDTO.setQuantidadeAlimentacao(new Double(0));
                            perdasmpDTO.setIndiceDePerdaAlimentacao(new Double(0));
                            
                            if(isVisaoGT) {
                            	listaPerdamp.put(consolid.getOmPt().getCd() + "-" + dwConsolperdamplog.getOmProduto().getCdProduto(), perdasmpDTO);
                            } else {
                            	listaPerdamp.put("*" + dwConsolperdamplog.getOmProduto().getCdProduto(), perdasmpDTO);
                            }
                        }

                        if (perdasmpDTO.getCdsRaps().contains(dwConsolperdamplog.getDwRap().getCdRap()) == false) {
                            perdasmpDTO.getCdsRaps().add(dwConsolperdamplog.getDwRap().getCdRap());
                        }

                        // Soh incrementa se ainda nao pegou nenhuma perda
                        // para maquina x produto x data ocorrencia
                        // Eh necessario este tratamento, porque pode
                        // ocorrer uma perda que seja ao mesmo tempo para mais
                        // de 1 rap,
                        // quando isso acontece, mais de um registro eh gerado
                        // na tabela de ocorrencias, levando em
                        // consideracao os diferentes raps.
                        // E nestes casos a data da ocorrencia eh a mesma.
                        /*
                         * Alessandre em 06-07-16 apesar da explicacao acima, comentei a verificacao da repetica da perda no mesmo horario
                         * senao existir� uma divergencia aentre o grafico de perda de componente e o grafico de perda por ferramenta e com
                         * a planilha em excel que usa uma view List<Object> colecaoParaGeracaoHashCodeConjunto = new ArrayList<>();
                         * Collections.addAll( colecaoParaGeracaoHashCodeConjunto, consolid.getOmPt().getCdPt(),
                         * dwConsolperdamplog.getOmProduto().getCdProduto(), dwConsolperdamplog.getDthrPerdamp());
                         * 
                         * int hashCodeMaquinaProdutoData = colecaoParaGeracaoHashCodeConjunto.hashCode(); isIncrementaQtPerdaMpPorProduto =
                         * colecaoComHashCodeMaquinaProdutoDataProcessada.add(hashCodeMaquinaProdutoData);
                         */

                        
                        /*
                         * Alessandre em 13-04-20. como existem lancamentos repetidos de perda de componente é necessario descartar os eventos com mesma data e hora e feeder
                        encontrei uma ocorrencia em que a data eh igual mas a qtde é diferente. Nesse caso ficar com a qtde maior
                        posso ordenar antes de interagir, ou guardo a qtde e comparo. Alterei o PerdasMpDTO para recalcular a diferenca
                        */
                       if (perdasmpDTO.incluirDthr(dwConsolperdamplog.getDthrPerdamp(), dwConsolperdamplog.getOmProduto().getCdProduto(), dwConsolperdamplog.getQtAutoPerdamp().intValue())) {
                        	isIncrementaQtPerdaMpPorProduto = true; // Acrescentado devido ao comentario acima
                        } else {
                        	isIncrementaQtPerdaMpPorProduto = false;
                        }

                        
                        // Acumula apenas se quantidade ainda nÃ£o foi
                        // processada
                        if (isIncrementaQtPerdaMpPorProduto) {
                            perdasmpDTO.setQuantidade(perdasmpDTO.getQuantidade() + dwConsolperdamplog.getQtAutoPerdamp().doubleValue());

                            // VERIFICAR A QUANTIDADE DE COMPONENTES USADOS
                            
                            BigDecimal qtUsadaDoComponenteMapa = BigDecimal.ZERO;
                            BigDecimal qtAlimentadaComponenteMapa = BigDecimal.ZERO;
                            
                            Set<Date> periodos = periodosOP.keySet();
                            for (Date periodo : periodos) {
                            	
                            	Date inicio = DataHoraRN.getDataHoraAtual();
                            	
                            	// AQUI 1 - perda de performance abaixo
                            	PosicaoCODTO podto = getComponentesUsadosMapa(
                            			consolid.getOmPt().getCdPt(),
                            			0,
                            			periodosOP.get(periodo).getDtHrInicio(), 
                            			periodosOP.get(periodo).getDtHrFim(), 
                            			dwConsolperdamplog.getOmProduto().getIdProduto(),
                            			dwConsolperdamplog.getDthrPerdamp(),
                            			consolid.getDwFolha(),
                            			dwConsolperdamplog);
                            	
                            	Date fim = DataHoraRN.getDataHoraAtual();
                            	segGetComponentesUsadosMapa += DataHoraRN.getQuantidadeMilisegundosNoPeriodo(inicio, fim);

                            	if (podto != null && podto.getOmmapapa() != null) {
	                            	perdasmpDTO.setOmmapapa((OmMapapa) podto.getOmmapapa().clone());
	                            	if (podto.getOmmapapa().getOmMapa() != null)
	                            		perdasmpDTO.getOmmapapa().setOmMapa(podto.getOmmapapa().getOmMapa().clone(false));
	                            	if (podto.getOmmapapa().getOmPa() != null)
	                            		perdasmpDTO.getOmmapapa().setOmPa(podto.getOmmapapa().getOmPa().clone(false));
                            	} else {
	                            	perdasmpDTO.setOmmapapa(new OmMapapa());
	                            	perdasmpDTO.getOmmapapa().setOmMapa(new OmMapa());
	                            	perdasmpDTO.getOmmapapa().getOmMapa().setCdMapa(" - ");
	                            	perdasmpDTO.getOmmapapa().setOmPa(new OmPa());
	                            	perdasmpDTO.getOmmapapa().getOmPa().setCdPa("");
                            	}
                            	
                            	// Alessandre em 20-09-19 comentei a linha abaixo e substitui pela seguinte
                            	// pois quando priodosOP tem mais de 1 periordo a qtde consmo por ciclo multiplica pela qtde de periodos
                            	//qtUsadaDoComponenteMapa = AritmeticaUtil.somar(qtUsadaDoComponenteMapa, podto.getQtdeConsumidaPorCiclo());
                            	qtUsadaDoComponenteMapa = podto.getQtdeConsumidaPorCiclo();
                            	
                            	


                            	// AQUI 2 - perda de performance abaixo
                            	qtAlimentadaComponenteMapa = AritmeticaUtil.somar(qtAlimentadaComponenteMapa,
                            			
                            			
                            			
                            			getComponentesAlimentados(
                            			consolid.getOmPt().getCdPt(),
                            			periodosOP.get(periodo).getDtHrInicio(), 
                            			periodosOP.get(periodo).getDtHrFim(), 
                            			dwConsolperdamplog.getOmProduto()));

                            	

                            }
                           
                            BigDecimal qtdCiclosExec = BigDecimal.ZERO;
                            BigDecimal qtdComponentesUtilizados = BigDecimal.ZERO;                            
                            Double indiceDePerda = 0d;    
                            Double indiceDePerdaAlimentacao = 0d;

                            qtdCiclosExec = listaCiclosExecPorCp.get(consolid.getPpCp().getCdCp());
                            qtdComponentesUtilizados = AritmeticaUtil.somar(AritmeticaUtil.multiplicar(qtdCiclosExec, qtUsadaDoComponenteMapa), new BigDecimal(perdasmpDTO.getQuantidade()));                                
                            
                            if (qtUsadaDoComponenteMapa.doubleValue() > 0d) {
                                indiceDePerda = FormulasInjet.calcularIndice(new BigDecimal(perdasmpDTO.getQuantidade()), qtdComponentesUtilizados, PRECISAO_DECIMAIS_PERDA_MP).doubleValue();                            	
                            }
                            
                            perdasmpDTO.setQuantidadeUtilizada(qtdComponentesUtilizados.doubleValue());
                            perdasmpDTO.setQtCiclosExecutados(qtdCiclosExec.doubleValue());
                            perdasmpDTO.setIndiceDePerda(indiceDePerda);


                            // Quantidade consumida pro ciclo
                            perdasmpDTO.setConsumoPorCiclo(qtUsadaDoComponenteMapa.doubleValue());

                            if (qtAlimentadaComponenteMapa.doubleValue() > 0d) {
                                indiceDePerdaAlimentacao = FormulasInjet.calcularIndice(new BigDecimal(perdasmpDTO.getQuantidade()), qtAlimentadaComponenteMapa, PRECISAO_DECIMAIS_PERDA_MP).doubleValue();                            	
                            }

                            
                            // quantidades e indices baseados no planejamento
                            BigDecimal qtdComponentesPrevOP = BigDecimal.ZERO; 
                            BigDecimal qtdCiclosPrev = listaCiclosPrevPorCp.get(consolid.getPpCp().getCdCp());                          
                            Double indiceDePerdaOP = 0d;            
                            
                            qtdComponentesPrevOP = AritmeticaUtil.multiplicar(qtdCiclosPrev, qtUsadaDoComponenteMapa);                              
                            if (qtUsadaDoComponenteMapa.doubleValue() > 0d) {
                            	indiceDePerdaOP = FormulasInjet.calcularIndice(new BigDecimal(perdasmpDTO.getQuantidade()), qtdComponentesPrevOP, PRECISAO_DECIMAIS_PERDA_MP).doubleValue();                            	
                            }

                            perdasmpDTO.setQuantidadeAlimentacao(qtAlimentadaComponenteMapa.doubleValue());
                            perdasmpDTO.setIndiceDePerdaAlimentacao(indiceDePerdaAlimentacao);
                            perdasmpDTO.setQuantidadePrevistaOP(qtdComponentesPrevOP.doubleValue());
                            perdasmpDTO.setIndiceDePerdaOP(indiceDePerdaOP);
                            
                            
                            perdasmpDTO.getLogs().add(dwConsolperdamplog.clone(true));


                        }

                        Date inicio1 = DataHoraRN.getDataHoraAtual();
                        // Agrupa por perda rap
                        DwConsolperdamplog dwConsolperdamplogRap = dwConsolpempoco.getDwConsolperdamplog();
                        PerdasmpDTO perdasmpDTORap = listaRap.get("*" + dwConsolperdamplogRap.getDwRap().getIdRap());
                        if (perdasmpDTORap == null) {
                            perdasmpDTORap = new PerdasmpDTO();
                            perdasmpDTORap.setOmPt(consolid.getOmPt().clone(false));
                            perdasmpDTORap.getOmPt().setOmTppt(consolid.getOmPt().getOmTppt().clone(false));
                            perdasmpDTORap.setDwRap(dwConsolperdamplogRap.getDwRap().clone(false));
                            perdasmpDTORap.setDwTPerdamp(dwConsolperdamplogRap.getDwTPerdamp().clone(false));
                            perdasmpDTORap.setQuantidade(new Double(0));
                            listaRap.put("*" + dwConsolperdamplogRap.getDwRap().getIdRap(), perdasmpDTORap);

                            perdasmpDTORap.setLogs(new ArrayList<DwConsolperdamplog>());
                            
                        }
                        perdasmpDTORap.setQuantidade(perdasmpDTORap.getQuantidade() + dwConsolperdamplogRap.getQtAutoPerdamp().doubleValue());
                        perdasmpDTORap.getLogs().add(dwConsolperdamplog.clone(true));

                        // somanando todas as quantidades de perda de rap
                        // qtdTotalPerdasRAP = qtdTotalPerdasRAP+
                        // dwConsolperdamplogRap.getQtAutoPerdamp().doubleValue();
                    	Date fim = DataHoraRN.getDataHoraAtual();
                    	segGetComponentesUsadosMapa2 += DataHoraRN.getQuantidadeMilisegundosNoPeriodo(inicio1, fim);
                    }
                }
            
        }
        log.mostrarAvaliacaoCompleta(idLog, 0);
        
        log.info(idLog, 0, "Tempo segGetComponentesUsadosMapa:" + segGetComponentesUsadosMapa);
        log.info(idLog, 0, "Tempo segGetComponentesUsadosMapa2:" + segGetComponentesUsadosMapa2);
        
        
        log.iniciaAvaliacao(idLog, "resto do algoritmo");
        /* Calcula o indice de perda
         * 
         */
        BigDecimal totalPerdas = BigDecimal.ZERO;
        for (PerdasmpDTO dto : listaPerdamp.values()) {
        	totalPerdas = totalPerdas.add(new BigDecimal(dto.getQuantidade()));
        }
        
        for (PerdasmpDTO dto : listaPerdamp.values()) {
        	//Double ipd = FormulasInjet.calcularIndicePerda(new BigDecimal(dto.getQuantidade()), totalPerdas).doubleValue();
        	Double ipd = dto.getIndiceDePerda().doubleValue();
        	ipd = ConversaoTipos.converteParaDouble(ipd, 4);
        	dto.setIndiceDePerda(ipd);
        }

        totalPerdas = BigDecimal.ZERO;
        for (PerdasmpDTO dto : listaRap.values()) {
        	totalPerdas = totalPerdas.add(new BigDecimal(dto.getQuantidade()));
        }
        for (PerdasmpDTO dto : listaRap.values()) {
        	Double ipd = FormulasInjet.calcularIndicePerda(new BigDecimal(dto.getQuantidade()), totalPerdas).doubleValue();
        	ipd = ConversaoTipos.converteParaDouble(ipd, 4);
        	dto.setIndiceDePerda(ipd);
        }
        
        retorno.getPerdasmpDTOs().addAll(listaPerdamp.values());
        retorno.getPerdasmpOPDTOs().addAll(listaPerdamp.values());
        retorno.getPerdasmpAlimDTOs().addAll(listaPerdamp.values());
        retorno.getPerdasmpRapDTOs().addAll(listaRap.values());


        // Comparator que ordena pelo indice de perda        
        Comparator<PerdasmpDTO> comparator = new Comparator<PerdasmpDTO>() {
            @Override
            public int compare(PerdasmpDTO o1, PerdasmpDTO o2) {
                //return o1.getQuantidade().compareTo(o2.getQuantidade());
            	return o1.getIndiceDePerda().compareTo(o2.getIndiceDePerda());
            }

        };

        
        Comparator<PerdasmpDTO> comparatorOP = new Comparator<PerdasmpDTO>() {
            @Override
            public int compare(PerdasmpDTO o1, PerdasmpDTO o2) {
                //return o1.getQuantidade().compareTo(o2.getQuantidade());
            	return o1.getIndiceDePerdaOP().compareTo(o2.getIndiceDePerdaOP());
            }

        };
        
        Comparator<PerdasmpDTO> comparatorAlim = new Comparator<PerdasmpDTO>() {
            @Override
            public int compare(PerdasmpDTO o1, PerdasmpDTO o2) {
                //return o1.getQuantidade().compareTo(o2.getQuantidade());
            	return o1.getIndiceDePerdaAlimentacao().compareTo(o2.getIndiceDePerdaAlimentacao());
            }

        };
        
        // Colocando lista em ordem decrescente de acordo com a quantidade
        Collections.sort(retorno.getPerdasmpDTOs(), Collections.reverseOrder(comparator));
        Collections.sort(retorno.getPerdasmpRapDTOs(), Collections.reverseOrder(comparator));

        Collections.sort(retorno.getPerdasmpOPDTOs() , Collections.reverseOrder(comparatorOP));
        Collections.sort(retorno.getPerdasmpAlimDTOs(), Collections.reverseOrder(comparatorAlim));

        
        preencherCoresOcorrencia(ORDEM_PRODUTO, retorno.getPerdasmpDTOs(), retorno);
        preencherCoresOcorrencia(ORDEM_FERRAMENTA, retorno.getPerdasmpRapDTOs(), retorno);

        log.mostrarAvaliacaoCompleta(idLog, 0);
        
        log.mostrarAvaliacaoCompleta(idLog, 0);
        return retorno;
    }


    /* Esse metodo foi copiado para dentro de GraficoPerdaMateriaPrimaRN que possui o nome algorimo para montagem
     * desse grafico
     */
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
    			String chave = ordem == ORDEM_PRODUTO ? log.getOmProduto().getCdProduto() : log.getDwRap().getCdRap();
    			
    			List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrencias.get(chave);
    			OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
    			ocoDTO.setIdEvt(ordem == ORDEM_PRODUTO ? log.getOmProduto().getIdProduto() : log.getDwRap().getIdRap());
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
					datasAmarelo.setCorHexa(Cor.transformarParaCodigoHexadecimal(Color.YELLOW));
					if(ordem == ORDEM_PRODUTO) {
						retorno.setCorAmarela(datasAmarelo);
					} else {
						retorno.setCorAmarelaRap(datasAmarelo);
					}
					
				}
				if(intervalo.getCorIntervalo().equals(Color.ORANGE)){
					DatasDTO datasLaranja = new DatasDTO();
					datasLaranja.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
					datasLaranja.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
					datasLaranja.setCorHexa(Cor.transformarParaCodigoHexadecimal(Color.ORANGE));
					if(ordem == ORDEM_PRODUTO) {
						retorno.setCorLaranja(datasLaranja);
					} else {
						retorno.setCorLaranjaRap(datasLaranja);
					}
				}
				if(intervalo.getCorIntervalo().equals(Color.GREEN)){
					DatasDTO datasVerde = new DatasDTO();
					datasVerde.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
					datasVerde.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
					datasVerde.setCorHexa(Cor.transformarParaCodigoHexadecimal(Color.GREEN));
					if(ordem == ORDEM_PRODUTO) {
						retorno.setCorVerde(datasVerde);
					} else {
						retorno.setCorVerdeRap(datasVerde);
					}
				}
				if(intervalo.getCorIntervalo().equals(Color.RED)){
					DatasDTO datasVermelho = new DatasDTO();
					datasVermelho.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
					datasVermelho.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
					datasVermelho.setCorHexa(Cor.transformarParaCodigoHexadecimal(Color.RED));
					if(ordem == ORDEM_PRODUTO) {
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
			String chave = ordem == ORDEM_PRODUTO ? perda.getOmproduto().getCdProduto() : perda.getDwRap().getCdRap();
			Paint paint = mapCores.get(chave);
			if(paint != null) {
				Color cor = (Color) paint;
				perda.setCorBarra(String.valueOf(cor.getRGB()));
			}
		}

    }
    
    public List<DwConsolperdamplog> pesquisarMateriaPrima(FiltroGraficoDetalhePtDTO filtro) {
    	MapQuery q = new MapQuery(getDaoSession());
        q.append("SELECT DISTINCT dwconsolperdamplog");
        q.append("FROM DwConsolid dwconsolid");
        q.append("JOIN dwconsolid.dwConsols dwconsol");
        q.append("LEFT JOIN dwconsol.dwConsolpemps dwconsolpemp");
        q.append("LEFT JOIN dwconsolpemp.dwConsolpempocos dwconsolpempoco");
        q.append("LEFT JOIN dwconsolpempoco.dwConsolperdamplog dwconsolperdamplog");
        q.append("WHERE dwconsolid.tpId = :tpId");
        q.append("AND dwconsolid.stAtivo is null");
        q.append("AND dwconsolid.omPt.idPt = :idPt");
        q.append("AND dwconsolid.dtReferencia = :dtReferencia");
        q.append("AND dwconsolid.dwTurno.idTurno = :idTurno");
        
        if(filtro.getOmProduto() != null) {
        	q.append("AND dwconsolperdamplog.omProduto.idProduto = :idProduto");
        }
        
        if(filtro.getDwRap() != null) {
        	q.append("AND dwconsolperdamplog.dwRap.idRap = :idRap");
        }
        
        q.append("ORDER BY dwconsolperdamplog.idConsolpemplog");

        q.defineParametro("tpId", filtro.getTpId());
        q.defineParametro("idPt", filtro.getOmPt().getIdPt());
        q.defineParametro("dtReferencia", filtro.getDtReferencia());
        q.defineParametro("idTurno", filtro.getDwTurno().getIdTurno());
        
        if(filtro.getOmProduto() != null) {
        	q.defineParametro("idProduto", filtro.getOmProduto().getIdProduto());
        }
        
        if(filtro.getDwRap() != null) {
        	q.defineParametro("idRap", filtro.getDwRap().getIdRap());
        }
        
        List<DwConsolperdamplog> listaretorno = q.list();

        return listaretorno;
    }

    public ListaPerdasmpDTO getGraficoPerdaFerrmantaPorProduto(FiltroGraficoDetalhePtDTO filtro) {
        ListaPerdasmpDTO retorno = new ListaPerdasmpDTO();
        retorno.setPerdasmpRapDTOs(new ArrayList<PerdasmpDTO>());

        Byte tpId = filtro.getTpId();

        if (filtro.getIdCp() != null) {
            filtro.setPpCp(new PpCp());
            filtro.getPpCp().setIdCp(filtro.getIdCp());
        }

        MapQuery q = new MapQuery(getDaoSession());
        q.append("SELECT dwconsolperdamplog");
        q.append("FROM DwConsolid dwconsolid");
        q.append("JOIN dwconsolid.dwConsols dwconsol");

        if (filtro.getOmGt() != null) {
        	q.append("LEFT JOIN dwconsolid.omPt omPt");
            q.append("LEFT JOIN omPt.omObjs omObj");
            q.append("LEFT JOIN omObj.omGtByIdGt omGt");
        }

        q.append("LEFT JOIN dwconsol.dwConsolpemps dwconsolpemp");
        q.append("LEFT JOIN dwconsolpemp.dwConsolpempocos dwconsolpempoco");
        q.append("LEFT JOIN dwconsolpempoco.dwConsolperdamplog dwconsolperdamplog");
        q.append("WHERE dwconsolid.tpId = :tpId");
        q.append("AND dwconsolid.stAtivo is null");
        
        if(filtro.getOmPt() != null) {
        	q.append("AND  dwconsolid.omPt.idPt = :idPt");        	
        }
        
        if (filtro.getOmGt() != null) {
            q.append("AND omGt.idGt = :idGt");
        }

        q.append("AND dwconsolid.dtReferencia = :dtReferencia");
        q.append("AND dwconsolid.dwTurno.idTurno = :idTurno");
        q.append("AND dwconsolperdamplog.omProduto.idProduto = :idProduto");
        q.append("ORDER BY dwconsolid.idConsolid");

        q.defineParametro("tpId", tpId);
        
        if(filtro.getOmPt() != null) {
        	q.defineParametro("idPt", filtro.getOmPt().getIdPt());	
        }

        if (filtro.getOmGt() != null) {
            q.defineParametro("idGt", filtro.getOmGt().getIdGt());
        }
        
        q.defineParametro("dtReferencia", filtro.getDtReferencia());
        q.defineParametro("idTurno", filtro.getDwTurno().getIdTurno());
        q.defineParametro("idProduto", filtro.getOmProduto().getIdProduto());

        List<DwConsolperdamplog> listaDwConsolperdamplogs = q.list();
        Map<Long, PerdasmpDTO> listaRap = new HashMap<Long, PerdasmpDTO>();
        for (DwConsolperdamplog log : listaDwConsolperdamplogs) {
            PerdasmpDTO perdasmpDTORap = listaRap.get(log.getDwRap().getIdRap());
            if (perdasmpDTORap == null) {
                perdasmpDTORap = new PerdasmpDTO();
                perdasmpDTORap.setDwRap(log.getDwRap().clone(false));
                perdasmpDTORap.setDwTPerdamp(log.getDwTPerdamp().clone(false));
                perdasmpDTORap.setQuantidade(new Double(0));
                perdasmpDTORap.setOmproduto(filtro.getOmProduto());
                perdasmpDTORap.setOmPt(filtro.getOmPt());
                listaRap.put(log.getDwRap().getIdRap(), perdasmpDTORap);
                perdasmpDTORap.setLogs(new ArrayList<DwConsolperdamplog>());
            }
            perdasmpDTORap.setQuantidade(perdasmpDTORap.getQuantidade() + log.getQtAutoPerdamp().doubleValue());
            perdasmpDTORap.getLogs().add(log.clone(true));
        }

        retorno.getPerdasmpRapDTOs().addAll(listaRap.values());

        // Comparator que ordena pela quantidade
        Comparator<PerdasmpDTO> comparator = new Comparator<PerdasmpDTO>() {
            @Override
            public int compare(PerdasmpDTO o1, PerdasmpDTO o2) {
                return o1.getQuantidade().compareTo(o2.getQuantidade());
            }
        };

        // Colocando lista em ordem decrescente de acordo com a quantidade
        Collections.sort(retorno.getPerdasmpRapDTOs(), Collections.reverseOrder(comparator));
        
        preencherCoresOcorrencia(ORDEM_PRODUTO, retorno.getPerdasmpDTOs(), retorno);
        preencherCoresOcorrencia(ORDEM_FERRAMENTA, retorno.getPerdasmpRapDTOs(), retorno);

        return retorno;
    }

    public ListaPerdasmpDTO getGraficoPerdaMpPorRap(FiltroGraficoDetalhePtDTO filtro) {
        ListaPerdasmpDTO retorno = new ListaPerdasmpDTO();
        retorno.setPerdasmpDTOs(new ArrayList<PerdasmpDTO>());

        Byte tpId = filtro.getTpId();

        if (filtro.getIdCp() != null) {
            filtro.setPpCp(new PpCp());
            filtro.getPpCp().setIdCp(filtro.getIdCp());
        }

        List<DwConsolid> listadwconsolid = this.getDwConsolid(null, tpId, filtro.getOmPt(), filtro.getPpCp(), filtro.getDwTurno(),
                filtro.getDwTParada(), null, filtro.getDtReferencia(), filtro.getDtReferenciaInicial(), filtro.getDtReferenciaFinal(),
                filtro.getDthrIturno(), filtro.getDthrFturno(), filtro.getDthrIhora(), filtro.getDthrFhora(), false, false, false, true,
                null, true, false, false);

        Map<Long, PerdasmpDTO> listaPerdamp = new HashMap<Long, PerdasmpDTO>();
        Set<Integer> colecaoComHashCodeMaquinaProdutoDataProcessada = new HashSet<Integer>();

        for (DwConsolid consolid : listadwconsolid) {
            for (DwConsol dwconsol : consolid.getDwConsols()) {
                for (DwConsolpemp consolpemp : dwconsol.getDwConsolpemps()) {
                    for (DwConsolpempoco dwConsolpempoco : consolpemp.getDwConsolpempocos()) {
                        // Agrupa por perda mp
                        DwConsolperdamplog dwConsolperdamplog = dwConsolpempoco.getDwConsolperdamplog();

                        if (filtro.getDwRap().getIdRap().longValue() == dwConsolperdamplog.getDwRap().getIdRap().longValue()) {
                            boolean isIncrementaQtPerdaMpPorProduto = true;
                            PerdasmpDTO perdasmpDTO = listaPerdamp.get(dwConsolperdamplog.getOmProduto().getIdProduto());

                            if (perdasmpDTO == null) {
                                perdasmpDTO = new PerdasmpDTO();
                                perdasmpDTO.setCdsRaps(new ArrayList<String>());
                                perdasmpDTO.setDwRap(dwConsolperdamplog.getDwRap().clone(false));
                                perdasmpDTO.setDwTPerdamp(dwConsolperdamplog.getDwTPerdamp().clone(false));
                                perdasmpDTO.setOmproduto(dwConsolperdamplog.getOmProduto().clone(false));
                                perdasmpDTO.setQuantidade(new Double(0));
                                perdasmpDTO.setOmPt(consolid.getOmPt().clone(false));
                                listaPerdamp.put(dwConsolperdamplog.getOmProduto().getIdProduto(), perdasmpDTO);
                                perdasmpDTO.setLogs(new ArrayList<DwConsolperdamplog>());
                            }
                            
                            perdasmpDTO.getLogs().add(dwConsolperdamplog.clone(true));

                            if (!perdasmpDTO.getCdsRaps().contains(dwConsolperdamplog.getDwRap().getCdRap())) {
                                perdasmpDTO.getCdsRaps().add(dwConsolperdamplog.getDwRap().getCdRap());
                            }

                            // SÃ³ incrementa se ainda nÃ£o pegou nenhuma
                            // perda para mÃ¡quina x produto x data ocorrencia
                            // Ã‰ necessÃ¡rio este tratamento, porque pode
                            // ocorrer uma perda que seja ao mesmo tempo para
                            // mais de 1 rap,
                            // quando isso acontece, mais de um registro Ã©
                            // gerado na tabela de ocorrencias, levando em
                            // consideraÃ§Ã£o os diferentes raps.
                            // E nestes casos a data da ocorrencia Ã© a mesma.
                            List<Object> colecaoParaGeracaoHashCodeConjunto = new ArrayList<Object>();
                            Collections.addAll(colecaoParaGeracaoHashCodeConjunto, consolid.getOmPt().getCdPt(), dwConsolperdamplog
                                    .getOmProduto().getCdProduto(), dwConsolperdamplog.getDthrPerdamp());
                            int hashCodeMaquinaProdutoData = colecaoParaGeracaoHashCodeConjunto.hashCode();
                            isIncrementaQtPerdaMpPorProduto = colecaoComHashCodeMaquinaProdutoDataProcessada
                                    .add(hashCodeMaquinaProdutoData);

                            // Acumula apenas se quantidade ainda nÃ£o foi
                            // processada
                            if (isIncrementaQtPerdaMpPorProduto) {
                                perdasmpDTO
                                        .setQuantidade(perdasmpDTO.getQuantidade() + dwConsolperdamplog.getQtAutoPerdamp().doubleValue());

                                // VERIFICAR A QUANTIDADE DE COMPONENTES USADOS
                                Double indiceDePerda = FormulasInjet.calcularIndiceMP(new BigDecimal(
                                		perdasmpDTO.getQuantidade()),
                                        BigDecimal.ONE, 
                                        dwconsol.getPcsProducaoBruta());
                                perdasmpDTO.setIndiceDePerda(indiceDePerda);

                            }
                        }
                    }
                }
            }
        }

        retorno.getPerdasmpDTOs().addAll(listaPerdamp.values());

        // Comparator que ordena pela quantidade
        Comparator<PerdasmpDTO> comparator = new Comparator<PerdasmpDTO>() {
            @Override
            public int compare(PerdasmpDTO o1, PerdasmpDTO o2) {
                return o1.getQuantidade().compareTo(o2.getQuantidade());
            }
        };

        // Colocando lista em ordem decrescente de acordo com a quantidade
        Collections.sort(retorno.getPerdasmpDTOs(), Collections.reverseOrder(comparator));
        
        preencherCoresOcorrencia(ORDEM_PRODUTO, retorno.getPerdasmpDTOs(), retorno);
        preencherCoresOcorrencia(ORDEM_FERRAMENTA, retorno.getPerdasmpRapDTOs(), retorno);

        return retorno;
    }

    /**
     * Pega os ultimos ciclos da maquina/op TODO milton - falta pegar o ciclos padrao, cavidades ativas e meta hora, de cada ciclos. Tambem
     * parametrizar, novo campo em FiltroCiclosDTO, se isso Ã© necessÃ¡rio.
     * 
     * @param filtroCiclosDTO
     *            -
     * @return
     */
    public CiclosDTO getUltimosCiclos(FiltroCiclosDTO filtroCiclosDTO) {

        Validate.notNull(filtroCiclosDTO, "FiltroCiclosDTO deve ser preenchido");
        Validate.notNull(filtroCiclosDTO.getOmPt(), "FiltroCiclosDTO.OmPt deve ser preenchido");

        final int TOTAL_ULTIMOS_CICLOS = 50;
        boolean recuperarTodos;
        CiclosDTO ciclosDTO = new CiclosDTO();
        ciclosDTO.setListaCicloDTO(new ArrayList<CicloDTO>());

        if (filtroCiclosDTO.getPpCp() != null && filtroCiclosDTO.getPpCp().getIdCp() != null && filtroCiclosDTO.getPpCp().getIdCp() > 0) {
            PpCp ppCp = getDao().findById(PpCp.class, filtroCiclosDTO.getPpCp().getIdCp(), false);
            filtroCiclosDTO.setPpCp(ppCp);
        }

        if (filtroCiclosDTO.getRecuperarTodosOsCiclos() == null) {
            recuperarTodos = false;
        } else {
            recuperarTodos = filtroCiclosDTO.getRecuperarTodosOsCiclos();
        }
        Date dtReferencia = null;
        DwTurno dwturno = null;
        if (filtroCiclosDTO.getAnaliseTurnoDTO() != null) {
            dtReferencia = filtroCiclosDTO.getAnaliseTurnoDTO().getDtReferencia();
            dwturno = filtroCiclosDTO.getAnaliseTurnoDTO().getDwTurno();
        }

        FolhaRN folhaRN = new FolhaRN(this.getDao());
        
        List<DwRtcic> listaDwRtcic = getDwRtcics(
        		filtroCiclosDTO.getOmPt(), 
        		filtroCiclosDTO.getPpCp(), 
        		filtroCiclosDTO.getDwFolha(), 
        		(recuperarTodos == true ? 0 : TOTAL_ULTIMOS_CICLOS), dtReferencia, dwturno);

        // Se nÃ£o estiver vazia, ordena pela data de inÃ­cio do ciclo
        if (listaDwRtcic.isEmpty() == false) {

            // Ordena em ordem crescente
            Collections.sort(listaDwRtcic, new Comparator<DwRtcic>() {
                @Override
                public int compare(DwRtcic a, DwRtcic b) {
                    return DataHoraRN.compareTo(a.getDthrIciclo(), b.getDthrIciclo());
                }
            });

            for (DwRtcic dwRtcic : listaDwRtcic) {
                // Alessandre em 18-08-15 Alteracao feita para o Chile Se o
                // ciclo for superior ao ciclo de timeout remove-lo do grafico
                // o correto eh remover do ciclo o tempo da parada
                BigDecimal cicloReferencia = null;
                BigDecimal cicloPadrao;
                
                try {
					cicloPadrao = folhaRN.getCicloPadrao(dwRtcic.getDwFolha(), filtroCiclosDTO.getOmPt());
				} catch (SemCicloPadraoException e) {
					cicloPadrao = BigDecimal.ONE;
				}

                
                // Definir o ciclo de referencia para filtrar as barras do ciclo
                if (dwRtcic.getDwFolha() != null && dwRtcic.getDwFolha().getSegCiclotimeout() != null) {
                    if (dwRtcic.getDwFolha().getSegCiclotimeout().doubleValue() < 100d) {
                        cicloReferencia = new BigDecimal(2);
                    } else {
                        cicloReferencia = dwRtcic.getDwFolha().getSegCiclotimeout().divide(new BigDecimal(100));
                    }
                    cicloReferencia = cicloReferencia.multiply(cicloPadrao);
                } else {
                    cicloReferencia = cicloPadrao.multiply(new BigDecimal(2));
                }
                
                // Se o ciclo foir maior que o ciclo de timeout entao o mesmo nao deve aparecer
                // no grafico, com excessao se a parada do posto fechar o ciclo
                
                if (
                		filtroCiclosDTO.getOmPt().getIsParadaFechaciclo() != null && 
                		filtroCiclosDTO.getOmPt().getIsParadaFechaciclo() == false &&
                		dwRtcic.getSegDuracao() != null && 
                		dwRtcic.getSegDuracao().doubleValue() > cicloReferencia.doubleValue() && 
                		listaDwRtcic.size() > 1)
                    continue;

                CicloDTO cicloDTO = new CicloDTO();
                cicloDTO.setDwRtcic(dwRtcic);
                ciclosDTO.getListaCicloDTO().add(cicloDTO);
            }

            // Analisa dados dos ciclos
            analisarUltimosCiclos(ciclosDTO);

            // Guarda apenas os clones de DwRtCic
            for (CicloDTO cicloDTO : ciclosDTO.getListaCicloDTO()) {
            	DwRtcic dwRtcic = cicloDTO.getDwRtcic().clone(false);
            	dwRtcic.setDwFolha(cicloDTO.getDwRtcic().getDwFolha().clone(false));
                cicloDTO.setDwRtcic(dwRtcic);
            }

        } else {
            // TODO milton - buscar dados da op atual
            ciclosDTO.setCavAtivas(BigDecimal.ONE);
            ciclosDTO.setCicloPadrao(BigDecimal.ZERO);
            ciclosDTO.setMetaHora(BigDecimal.ONE);
            ciclosDTO.setCapabilidadeProcessoDTO(new CapabilidadeProcessoDTO());
        }

        return ciclosDTO;
    }

    /**
     * Analisa os ciclos e guarda cÃ¡lculos no DTO <br>
     * calcula: CP, CPK, metaHora, desvio padrÃ£o, limite inferior, limite superior
     * 
     * @param ciclosDTO
     *            item da coleÃ§Ã£o DwRtCic, deve estar persistido
     */
    private void analisarUltimosCiclos(CiclosDTO ciclosDTO) {

        // Objeto deve estar preenchido
        if (ciclosDTO == null || ciclosDTO.getListaCicloDTO() == null || ciclosDTO.getListaCicloDTO().isEmpty()) {
            return;
        }

        // Pega do Ãºltimo ciclos os dados referentes a ciclo padrÃ£o e
        // cavidades
        DwRtcic ultimoCiclo = ciclosDTO.getListaCicloDTO().get(ciclosDTO.getListaCicloDTO().size() - 1).getDwRtcic();

        DwConsolid dwConsolid = ultimoCiclo.getDwRt().getDwConsolids().iterator().next();
        DwFolha dwFolha = dwConsolid.getDwFolha();
        OmPt omPt = ultimoCiclo.getDwRt().getOmPt();

        FolhaRN folhaRN = new FolhaRN(this.getDao());
        
        /* Alessandre em 12-05-17 comentei a linha abaixo pois a tooltip do grafico dos ultimos ciclo mostra o ciclo padrao
         * atual para os ciclos anteriores a mudanca do ciclo padrão
        dwFolha = folhaRN.pesquisaFolhaByCdEStSemRota(dwFolha.getCdFolha());
         */

        // Guarda as cavidades ativas
        try {
            ciclosDTO.setCavAtivas(folhaRN.getPcsPorCicloAtivas(dwFolha));
        } catch (SemPcsPorCicloAtivasException e) {
            e.printStackTrace();
            ciclosDTO.setCavAtivas(BigDecimal.ONE);
        }

        // Guarda o ciclo padrÃ£o
        try {
            ciclosDTO.setCicloPadrao(folhaRN.getCicloPadrao(dwFolha, omPt));
        } catch (SemCicloPadraoException e) {
            e.printStackTrace();
            ciclosDTO.setCicloPadrao(BigDecimal.ONE);
        }
        try {
        	ciclosDTO.setSegCicloMinimo(folhaRN.getCicloMinimoFromDwFolha(dwFolha, omPt));
        	if (ciclosDTO.getSegCicloMinimo() == null)
        		ciclosDTO.setSegCicloMinimo(BigDecimal.ZERO);
        } catch (SemCicloPadraoException e) {
        	ciclosDTO.setSegCicloMinimo(BigDecimal.ZERO);
        }
        try {
        	ciclosDTO.setPercCicloMaximo(folhaRN.getCicloMaximoFromDwFolha(dwFolha, omPt));
        	if (ciclosDTO.getPercCicloMaximo() == null)
        		ciclosDTO.setPercCicloMaximo(new BigDecimal(100));
        } catch (SemCicloPadraoException e) {
        	ciclosDTO.setPercCicloMaximo(new BigDecimal(100));
        }
        
        // Guarda meta hora
        ciclosDTO.setMetaHora(new BigDecimal(FormulasInjet.calcularMetaHora(ciclosDTO.getCicloPadrao(), ciclosDTO.getCavAtivas().longValue(), omPt.getIndOee())));

        double[] ciclos = new double[ciclosDTO.getListaCicloDTO().size()];
        for (int i = 0; i < ciclosDTO.getListaCicloDTO().size(); i++) {

            CicloDTO cicloDTO = ciclosDTO.getListaCicloDTO().get(i);

            double ciclo = cicloDTO.getDwRtcic().getSegDuracao().doubleValue();

            // Guarda ciclos para calcular capabilidade do processo
            ciclos[i] = ciclo;

            /*
             * Dados baseados no que estÃ¡ no Ãºltimo ciclo TODO milton - pegar os dados abaixo do proprio ciclo, quando o campo DwFolha
             * estiver em DwRtcic
             */
            /* Recalcular os valores caso o ciclo padrao seja diferente do definido anteriormente
             * Isso é necessário pois o ciclo padrao pode mudar para o conjunto de ciclos avaliados
             */
            BigDecimal cicloPadrao;
            try {
                cicloPadrao = folhaRN.getCicloPadrao(cicloDTO.getDwRtcic().getDwFolha(), omPt);
            } catch (SemCicloPadraoException e) {
            	cicloPadrao = BigDecimal.ONE;
            }

            cicloDTO.setCicloPadrao(cicloPadrao);
            cicloDTO.setCavAtivas(ciclosDTO.getCavAtivas().intValue());
            ciclosDTO.setMetaHora(ciclosDTO.getMetaHora());

            // calcula eficiencia de ciclos
            cicloDTO.setEficienciaCiclo(new BigDecimal(FormulasInjet.calcularEficienciaCiclo(cicloPadrao, new BigDecimal(ciclo))));

        }

        /*
         * Limites superior e inferior variando em 10% sobre o ciclo. Usando desta forma atÃ© o modelo ser atualizado TODO milton - quando
         * modelo estiver com os campos ciclomincep e ciclomaxcep, usÃ¡-lo para referencia para lse e lie
         */
        BigDecimal lse = ciclosDTO.getCicloPadrao().multiply(ciclosDTO.getPercCicloMaximo().divide(new BigDecimal(100)));
        BigDecimal lie = ciclosDTO.getSegCicloMinimo();
        
        if (lse.compareTo(ciclosDTO.getCicloPadrao()) < 0)
        	lse = ciclosDTO.getCicloPadrao();

        BigDecimal k = new BigDecimal(getNumeroDeIntervalo(ciclosDTO.getListaCicloDTO().size()));

        // Guarda dados sobre a capabilidade do processo

        CapabilidadeProcessoDTO capabilidadeProcessoDTO = FormulasInjet.calcularCapabilidadeProcesso(lse, lie, ciclos, k);
        if (capabilidadeProcessoDTO == null) {
            capabilidadeProcessoDTO = new CapabilidadeProcessoDTO();
            capabilidadeProcessoDTO.setLie(lie.doubleValue());
            capabilidadeProcessoDTO.setLse(lse.doubleValue());

        }
        ciclosDTO.setCapabilidadeProcessoDTO(capabilidadeProcessoDTO);
        calcularIntervaloFrequenciaCiclo(ciclosDTO, k.longValue());
    }

    private void calcularIntervaloFrequenciaCiclo(CiclosDTO ciclosDTO, long k) {

        double cicloMenorDuracao = ciclosDTO.getListaCicloDTO().get(0).getDwRtcic().getSegDuracao().doubleValue();
        double cicloMaiorDuracao = ciclosDTO.getListaCicloDTO().get(0).getDwRtcic().getSegDuracao().doubleValue();

        // captura a maior e a menor duracao de ciclo
        for (CicloDTO ciclo : ciclosDTO.getListaCicloDTO()) {
            double duracaoCiclo = ciclo.getDwRtcic().getSegDuracao().doubleValue();

            if (duracaoCiclo < cicloMenorDuracao) {
                cicloMenorDuracao = duracaoCiclo;
            }

            if (duracaoCiclo > cicloMaiorDuracao) {
                cicloMaiorDuracao = duracaoCiclo;
            }
        }

        double amplitudeTotal = cicloMaiorDuracao - cicloMenorDuracao;

        double amplitudeClasse = amplitudeTotal / k;

        List<IntervaloDTO> listaIntervaloDTO = new ArrayList<>();
        double lseAnterior = 0;
        for (int i = 1; i <= k; i++) {
            double lie;
            double lse;
            if (i == 1) {
                lie = cicloMenorDuracao - (amplitudeClasse / 2);
            } else {
                lie = lseAnterior;
            }
            lse = lie + amplitudeClasse;
            double pontoMedio = (lie + lse) / 2;

            long frequencia = 0;
            for (CicloDTO ciclo : ciclosDTO.getListaCicloDTO()) {
                double duracaoCiclo = ciclo.getDwRtcic().getSegDuracao().doubleValue();
                if (duracaoCiclo >= lie && duracaoCiclo <= lse) {
                    frequencia++;
                }
            }
            lseAnterior = lse;

            IntervaloDTO intervalo = new IntervaloDTO();
            intervalo.setNumero(i);
            intervalo.setLie(lie);
            intervalo.setLse(lse);
            intervalo.setPontoMedio(pontoMedio);
            intervalo.setFrequencia(frequencia);
            intervalo.setAmplitude(amplitudeTotal);
            intervalo.setAmplitudeClasse(amplitudeClasse);
            listaIntervaloDTO.add(intervalo);
        }

        ciclosDTO.setK(new BigDecimal(k));
        ciclosDTO.getCapabilidadeProcessoDTO().setMaximo(cicloMaiorDuracao);
        ciclosDTO.getCapabilidadeProcessoDTO().setMinimo(cicloMenorDuracao);
        ciclosDTO.setListaIntervaloDTO(listaIntervaloDTO);
    }

    private long getNumeroDeIntervalo(long numeroCiclos) {
        if (numeroCiclos < 50) {
            return 6;
        }

        if (numeroCiclos >= 50 && numeroCiclos <= 100) {
            return 8;
        }

        if (numeroCiclos > 100 && numeroCiclos <= 250) {
            return 10;
        }

        if (numeroCiclos > 250) {
            return 15;
        }

        return 0;
    }

    /**
     * Pega os ciclos em ordem decrescente, filtrando pelo {@link OmPt} , e se for necessÃ¡rio {@link PpCp}, limitando pela quantidade
     * 
     * @param omPt
     *            filtro pelo posto de trabalho (obrigatÃ³rio)
     * @param ppCp
     *            filtro pelo ppCp (nÃ£o obrigatÃ³rio)
     * @param qtdCiclos
     * @return
     */
    private List<DwRtcic> getDwRtcics(OmPt omPt, PpCp ppCp, DwFolha folha, int qtdCiclos, Date dtReferencia, DwTurno dwTurno) {
        Validate.notNull(omPt, "omPt nao pode ser nulo");

        MapQuery query = new MapQuery(getDao().getSession());

        query.append("SELECT DISTINCT dwRtcic");
        query.append("FROM DwRtcic dwRtcic");
        query.append("JOIN dwRtcic.dwRt dwRt");
        // Alessandre em 05-10-17 removi o dwconsolid pois nao eh mais necessario visto que dwrtcic ja tem a folha
        //query.append("JOIN dwRt.dwConsolids dwConsolid");
        //Alex 12/04/2017
        //query.append("JOIN FETCH dwRtcic.dwRt dwRt");
        //query.append("JOIN FETCH dwRt.dwConsolids dwConsolid");
        query.append("WHERE dwRt.omPt = :omPt");
        
        // Alessandre em 03-10-17 comentei a linha abaixo para que os ciclos em regulagem tambem aparecam no grafico #4465
        //query.append("and dwRtcic.isRegulagem = :isregulagem ");

        /*
         * Liga a dwConsolid para pega DwFolha TODO milton - desfazer esta ligaÃ§Ã£o com DwConsolid quando DwFolha estiver em DwRt
         */
        //query.append("AND dwConsolid.tpId = :tpId");

        if (ppCp != null && ppCp.getCdCp() != null && ppCp.getCdCp().equals("") == false) {
            query.append("AND dwRtcic.dwRt.ppCp.cdCp = :cdCp");
        } else if (ppCp != null && ppCp.getIdCp() != null && ppCp.getIdCp() > 0) {
        	query.append("AND dwRtcic.dwRt.ppCp.idCp = :idcp");
        }
        
        if (folha != null) {
            query.append("AND dwRtcic.dwFolha.cdFolha = :cdfolha");
        }
        if (dtReferencia != null) {
            query.append("AND dwRt.dtReferencia = :dtReferencia");
        }
        if (dwTurno != null) {
            query.append("AND dwRt.dwTurno.idTurno = :idTurno");
        }

        query.append("ORDER by dwRtcic.idRtcic DESC");

        // define os parametros
        query.defineParametro("omPt", omPt);
        if (ppCp != null && ppCp.getCdCp() != null && ppCp.getCdCp().equals("") == false) {
            query.defineParametro("cdCp", ppCp.getCdCp());
        } else if (ppCp != null && ppCp.getIdCp() != null && ppCp.getIdCp() > 0) {
        	query.defineParametro("idcp", ppCp.getIdCp());
        }
        if (folha != null) {
            query.defineParametro("cdfolha", folha.getCdFolha());
        }
        if (dtReferencia != null) {
            query.defineParametroData("dtReferencia", DataHoraRN.getDataSemHora(dtReferencia));
        }
        if (dwTurno != null) {
            query.defineParametro("idTurno", dwTurno.getIdTurno());
        }

        
        // Alessandre em 03-10-17 comentei a linha abaixo para que os ciclos em regulagem tambem aparecam no grafico #4465
        //query.defineParametro("isregulagem", false);

        if (qtdCiclos != 0) {
            query.setMaxResults(qtdCiclos);
        }

        List<DwRtcic> listaDwRtcic = query.list();

        return listaDwRtcic;

    }

    public GraficoDetalhePtDTO getGraficoDetalhePtUltimosCiclosBIDTO(FiltroGraficoDetalhePtDTO filtro) {
        GraficoDetalhePtDTO retorno = new GraficoDetalhePtDTO();
        MapQuery query = new MapQuery(getDao().getSession());

        query.append("SELECT dwconsolid");
        query.append("FROM DwConsolid dwconsolid");
        // query.append("WHERE dwconsolid.stAtivo = 1");
        query.append("WHERE dwconsolid.tpId = 1");
        query.append("AND dwconsolid.omGt.idGt =:idGt");
        if (filtro.getDwTurno() != null) {
            query.append("AND dwconsolid.dwTurno.idTurno =:idTurno");
        }

        query.append("AND dwconsolid.dtReferencia =:dtReferencia");

        if (filtro.getIdrt() > 0) {
            query.append("AND dwconsolid.dwRt.idRt =:idRt");
        }

        if (filtro.getDwTurno() != null) {
            query.defineParametro("idTurno", filtro.getDwTurno().getIdTurno());
        }
        query.defineParametro("idGt", filtro.getOmGt().getIdGt());
        query.defineParametro("idRt", filtro.getIdrt());
        query.defineParametroData("dtReferencia", filtro.getDtReferencia());

        // query.setMaxResults(1);
        List<DwConsolid> listadwconsolid = query.list();
        List<DwConsolidDTO> listdwconsolidDTO = new ArrayList<DwConsolidDTO>();
        DwConsolidDTO dto = new DwConsolidDTO();
        DwConsolidDTOs dConsolidDTOs = new DwConsolidDTOs();

        if (listadwconsolid != null) {
            for (DwConsolid dwconsolid : listadwconsolid) {
                dwconsolid = dwconsolid.clone(true);
                dto.setDwConsolid(dwconsolid);
                listdwconsolidDTO.add(dto);
                dConsolidDTOs.setListaDwConsolidDTO(listdwconsolidDTO);
            }
        }

        retorno.setDwConsolidDTOs(dConsolidDTOs);
        return retorno;
    }

    /**
     * @deprecated substituÃ­do {@link #getUltimosCiclos(FiltroCiclosDTO)} milton
     * @param filtro
     * @return
     */
    @Deprecated
    public GraficoDetalhePtDTO getGraficoDetalhePtUltimosCiclosDTO(FiltroGraficoDetalhePtDTO filtro) {
        GraficoDetalhePtDTO retorno = new GraficoDetalhePtDTO();
        DwConsolidDTO dto = new DwConsolidDTO();
        MapQuery query = new MapQuery(getDao().getSession());

        query.append("SELECT dwconsolid");
        query.append("FROM DwConsolid dwconsolid");
        // query.append("WHERE dwconsolid.stAtivo = 1");
        query.append("WHERE dwconsolid.tpId = 1");
        query.append("AND dwconsolid.omPt.idPt =:idPt");

        if (filtro.getDwTurno() != null) {
            query.append("AND dwconsolid.dwTurno.idTurno =:idTurno");
        }

        query.append("AND dwconsolid.dtReferencia =:dtReferencia");

        if (filtro.getIdrt() > 0) {
            query.append("AND dwconsolid.dwRt.idRt =:idRt");
        }

        if (filtro.getDwTurno() != null) {
            query.defineParametro("idTurno", filtro.getDwTurno().getIdTurno());
        }
        query.defineParametro("idPt", filtro.getOmPt().getIdPt());
        query.defineParametro("idRt", filtro.getIdrt());
        query.defineParametroData("dtReferencia", filtro.getDtReferencia());

        query.setMaxResults(1);
        DwConsolid dwconsolid = (DwConsolid) query.uniqueResult();

        if (dwconsolid != null) {
            dto = new DwConsolidDTO();
            dto.setDwConsolid(dwconsolid.clone(true));
        } else {
            dto.setDwConsolid(new DwConsolid());
        }

        retorno.setDwConsolid(dto);
        return retorno;
    }

    public DwFolhasDTO getGraficoDetalhePadraoDTO(FiltroGraficoDetalhePtDTO filtro) {
        DwFolhasDTO retorno = new DwFolhasDTO();
        List<DwFolhaDTO> listaDwFolhaDTO = new ArrayList<DwFolhaDTO>();
        MapQuery query = new MapQuery(getDao().getSession());
        query.append("Select dwfolha");
        query.append("From DwFolha dwfolha");
        query.append("join fetch dwfolha.omPts ompts");
        query.append("Where dwfolha.cdFolha = :cdfolha");
        query.append("AND dwfolha.dtRevisao <= :dtreferencia");
        query.append("AND ompts.idPt = :idpt");
        query.append("ORDER BY dwfolha.revisao");

        query.defineParametro("cdfolha", filtro.getDwfolha().getCdFolha());
        query.defineParametro("idpt", filtro.getOmPt().getIdPt());
        query.defineParametroData("dtreferencia", filtro.getDtReferencia());
        List<DwFolha> listaDwFolha = query.list();
        if (listaDwFolha != null) {
            for (DwFolha dwfolha : listaDwFolha) {
                DwFolhaDTO dto = new DwFolhaDTO();
                dto.setDwFolha(dwfolha.clone());
                listaDwFolhaDTO.add(dto);
            }
        }

        retorno.setListaDwFolhaDTO(listaDwFolhaDTO);
        return retorno;
    }

    public DwFolhasDTO getGraficoDetalhePadraoBIDTO(FiltroGraficoDetalhePtDTO filtro) {
        DwFolhasDTO retorno = new DwFolhasDTO();
        List<DwFolhaDTO> listaDwFolhaDTO = new ArrayList<DwFolhaDTO>();
        MapQuery query = new MapQuery(getDao().getSession());
        query.append("Select dwfolha");
        query.append("From DwFolha dwfolha");
        query.append("Where dwfolha.cdFolha = :cdfolha");
        query.append("AND dwfolha.dtRevisao <= :dtreferencia");
        query.append("AND ompts.idGt = :idgt");
        query.append("ORDER BY dwfolha.revisao");

        query.defineParametro("cdfolha", filtro.getDwfolha().getCdFolha());
        query.defineParametro("idgt", filtro.getOmGt().getIdGt());
        query.defineParametro("dtreferencia", filtro.getDtReferencia());
        List<DwFolha> listaDwFolha = query.list();
        if (listaDwFolha != null) {
            for (DwFolha dwfolha : listaDwFolha) {
                DwFolhaDTO dto = new DwFolhaDTO();
                dto.setDwFolha(dwfolha.clone());
                listaDwFolhaDTO.add(dto);
            }
        }

        retorno.setListaDwFolhaDTO(listaDwFolhaDTO);
        return retorno;
    }


    /**
	 * Funcao especializada para uso da VF-WEB, derivada de outra; vem de [preecheValoresDetalheGargalo(List<DwConsolid> listaDwConsolid)], a original. Esta aqui requer passar adicionalmente um BOOLEAN; se [gargalosAgrupados==true] agrupa os dados de alguns indicadores (temposciclos) omPts (já previamente agrupados) por TpPt também.
     * Preenche dos dados do {@code DetalheAnaliseGargaloDTO}
     * 
     * @param listaDwConsolid, gargalosAgrupados
     * @return Um objeto (DetalheAnaliseGargaloDTO), identico ao da funcao original.
     */
    private DetalheAnaliseGargaloDTO preecheValoresDetalheGargalo(List<DwConsolid> listaDwConsolid, boolean isGargalosAgrupados) {

        DetalheAnaliseGargaloDTO retorno = new DetalheAnaliseGargaloDTO();
        DetalheAnaliseGargaloDTO temporarioRetorno = new DetalheAnaliseGargaloDTO();

        OmCfg omcfg = Util.getConfigGeral(getDaoSession());
        OmPt omptReferencia = null;


        if(!isGargalosAgrupados){
            // Preparada lista de todas as maquinas (NORMAL)
        	temporarioRetorno = null;
        	temporarioRetorno = new DetalheAnaliseGargaloDTO();
            for (DwConsolid consolid : listaDwConsolid) {
                omptReferencia = consolid.getOmPt();
                // agrupa para todas as maquinas
                temporarioRetorno.getListaIndicadoresPt().getAgrupador().add(consolid, omcfg, getDao());
            }
            // resultado do agrupamento de todas as maquinas
            temporarioRetorno.getListaIndicadoresPt().getAgrupador().resultMerge(omcfg, omptReferencia);
        }


        if(isGargalosAgrupados){
        	
            // Preparada lista de todas as maquinas (NORMAL)
        	temporarioRetorno = null;
        	temporarioRetorno = new DetalheAnaliseGargaloDTO();
            for (DwConsolid consolid : listaDwConsolid) {
                omptReferencia = consolid.getOmPt();
                // agrupa para todas as maquinas
                temporarioRetorno.getListaIndicadoresPt().getAgrupador().add(consolid, omcfg, getDao());
            }
            // resultado do agrupamento de todas as maquinas
            temporarioRetorno.getListaIndicadoresPt().getAgrupador().resultMerge(omcfg, omptReferencia);


            // outro teste para evitar agrupamentos desnecessários: cuja lista contem apenas itens unitarios.
            
        	boolean isAoMenosUmGargaloAgrupar = false; //contendo mais de um item. 
            Set<String> setTps = new HashSet<String>();
            if (temporarioRetorno!=null && temporarioRetorno.getListaIndicadoresPt()!=null && temporarioRetorno.getListaIndicadoresPt().getLista()!=null && temporarioRetorno.getListaIndicadoresPt().getLista().size()>0){
                for (IndicadoresPtDTO indicadoresPtDTO : temporarioRetorno.getListaIndicadoresPt().getLista()) {
                	setTps.add(indicadoresPtDTO.getOmPt().getOmTppt().getCdTppt());
                }
            }       
            isAoMenosUmGargaloAgrupar = false;
            if (setTps!=null && setTps.size()>0){
            	Iterator it = setTps.iterator();
            	String tppt;
            	int conta = 0;
            	while (it.hasNext()){
            		conta = 0;
            		tppt = (String) it.next();

            		for (IndicadoresPtDTO indicadoresPtDTO : temporarioRetorno.getListaIndicadoresPt().getLista()) {
            			if (indicadoresPtDTO.getOmPt().getOmTppt().getCdTppt().equals(tppt)){
            				conta++;
            			}
                    }
            		if (conta>1){
            			isAoMenosUmGargaloAgrupar = true;
            			break;
            		}
            	}
            }
            if (! isAoMenosUmGargaloAgrupar){ //entao faz normal, sem agrupamentos
            	isGargalosAgrupados = false;
            } else {

            	// Preparada lista de todas as maquinas (com isGargalosAgrupados)
            	temporarioRetorno = null;
            	temporarioRetorno = new DetalheAnaliseGargaloDTO();
                for (DwConsolid consolid : listaDwConsolid) {
                    omptReferencia = consolid.getOmPt();
                    // agrupa para todas as maquinas
                    temporarioRetorno.getListaIndicadoresPt().getAgrupador().add(consolid, omcfg, getDao(), isGargalosAgrupados);
                }
                // resultado do agrupamento de todas as maquinas
                temporarioRetorno.getListaIndicadoresPt().getAgrupador().resultMerge(omcfg, omptReferencia, isGargalosAgrupados);
            	
            }
            
            
        }

        
        
        retorno = temporarioRetorno;


        
        BigDecimal maiorCicloPadrao = BigDecimal.ZERO;
        BigDecimal maiorCicloMedio = BigDecimal.ZERO;
        // Preparada lista somente com as maquinas de saida, e pegar maior
        // ciclo
        // padrao e menor eficiencia de realizacao
        for (IndicadoresPtDTO indicadoresPtDTO : retorno.getListaIndicadoresPt().getLista()) {
      	
        	


            if (indicadoresPtDTO.getOmPt().getIsApongt()) {
            	
            	
            	if(isGargalosAgrupados){
            		
                    retorno.getListaIndicadoresPtSaida().getAgrupador().add(indicadoresPtDTO, isGargalosAgrupados);
                    
            	} else {
            		
                    retorno.getListaIndicadoresPtSaida().getAgrupador().add(indicadoresPtDTO);
            	}
            }

            // Pegar maior ciclo padrao
            BigDecimal indCicloPadrao = Util.getBigDecimalDefault(indicadoresPtDTO.getIndicadoresDTO().getCicloPadrao());
            if (indCicloPadrao.compareTo(maiorCicloPadrao) == 1) {
                maiorCicloPadrao = indCicloPadrao;
            }

            // Pegar menor ciclo medio
            BigDecimal cicloMedio = Util.getBigDecimalDefault(indicadoresPtDTO.getIndicadoresDTO().getCicloMedio());
            if (cicloMedio.compareTo(maiorCicloMedio) == 1 || maiorCicloMedio.equals(BigDecimal.ZERO)) {
                maiorCicloMedio = cicloMedio;
            }

        }
        
        // resultado do agrupamento dos indicadores do Pt saida
        if(isGargalosAgrupados){
            retorno.getListaIndicadoresPtSaida().getAgrupador().resultMerge(omcfg, omptReferencia, isGargalosAgrupados);
        	
        } else {
        	
            retorno.getListaIndicadoresPtSaida().getAgrupador().resultMerge(omcfg, omptReferencia);
        }

        // Prepara lista so com as maquinas de gargalo teorico e gargalo
        // dinamico
        for (IndicadoresPtDTO indicadoresPtDTO : retorno.getListaIndicadoresPt().getLista()) {
        	
        	
            BigDecimal indCicloPadrao = Util.getBigDecimalDefault(indicadoresPtDTO.getIndicadoresDTO().getCicloPadrao());
            BigDecimal cicloMedio = Util.getBigDecimalDefault(indicadoresPtDTO.getIndicadoresDTO().getCicloMedio());

            // Agrupa para o gargalo dinamico
            if (maiorCicloMedio.equals(cicloMedio)) {
            	
            	
                if(isGargalosAgrupados){
                    retorno.getListaIndicadoresPtGargaloDinamico().getAgrupador().add(indicadoresPtDTO, isGargalosAgrupados);                	
                } else {
                    retorno.getListaIndicadoresPtGargaloDinamico().getAgrupador().add(indicadoresPtDTO);
                }
            }

            // Agrupa para o gargalo teorico
            if (maiorCicloPadrao.equals(indCicloPadrao)) {
            	
                if(isGargalosAgrupados){
                    retorno.getListaIndicadoresPtGargaloTeorico().getAgrupador().add(indicadoresPtDTO, isGargalosAgrupados);
                	
                } else {
                	
                    retorno.getListaIndicadoresPtGargaloTeorico().getAgrupador().add(indicadoresPtDTO);
                }
            }

        }


        // Resultado do agrupamento do gargalo dinamico e teorico
        if(isGargalosAgrupados){
        	
            retorno.getListaIndicadoresPtGargaloDinamico().getAgrupador().resultMerge(omcfg, omptReferencia, isGargalosAgrupados);
            retorno.getListaIndicadoresPtGargaloTeorico().getAgrupador().resultMerge(omcfg, omptReferencia, isGargalosAgrupados);
        } else {
        	
            retorno.getListaIndicadoresPtGargaloDinamico().getAgrupador().resultMerge(omcfg, omptReferencia);
            retorno.getListaIndicadoresPtGargaloTeorico().getAgrupador().resultMerge(omcfg, omptReferencia);
        }



        if (isGargalosAgrupados){
            if(retorno!=null && retorno.getListaIndicadoresPt()!=null && retorno.getListaIndicadoresPt().getLista()!=null){
            	Iterator it = retorno.getListaIndicadoresPt().getLista().iterator();
            	IndicadoresPtDTO objiterar;
            	while (it.hasNext()){
            		objiterar = (IndicadoresPtDTO) it.next();
            		if (objiterar!=null && objiterar.getIndicadoresDTO()!=null && objiterar.getOmPt()!=null){
            			//190514 if (objiterar.getIndicadoresDTO().getQtAgrupCicloPadrao()>1L){
            			if (objiterar.getIndicadoresDTO().getQtAgrupCicloPadrao()>1L && !objiterar.getOmPt().getOmTppt().getCdTppt().equals("EMB")){ //190514
            				objiterar.setGargalosAgrupados(true);
            			} else
            			{
            				objiterar.setGargalosAgrupados(false);
            			}
            		}
            	}
            }
        }


        // prepara a serializacao de OmPt
        retorno.prepararSerializacao();

        return retorno;
    }

    
    
    /**
     * Preenche dos dados do {@code DetalheAnaliseGargaloDTO}
     * 
     * @param listaDwConsolid
     * @return
     */
    private DetalheAnaliseGargaloDTO preecheValoresDetalheGargalo(List<DwConsolid> listaDwConsolid) {

        DetalheAnaliseGargaloDTO retorno = new DetalheAnaliseGargaloDTO();

        OmCfg omcfg = Util.getConfigGeral(getDaoSession());
        OmPt omptReferencia = null;
        // Preparada lista de todas as mÃ¡quinas
        for (DwConsolid consolid : listaDwConsolid) {
            omptReferencia = consolid.getOmPt();
            // agrupa para todas as maquinas
            retorno.getListaIndicadoresPt().getAgrupador().add(consolid, omcfg, getDao());
        }
        // resultado do agrupamento de todas as maquinas
        retorno.getListaIndicadoresPt().getAgrupador().resultMerge(omcfg, omptReferencia);

        BigDecimal maiorCicloPadrao = BigDecimal.ZERO;
        BigDecimal maiorCicloMedio = BigDecimal.ZERO;
        // Preparada lista sÃ³ com as mÃ¡quinas de saÃ­da, e pegar maior
        // ciclo
        // padrÃ£o e menor eficiencia de realizaÃ§Ã£o
        for (IndicadoresPtDTO indicadoresPtDTO : retorno.getListaIndicadoresPt().getLista()) {

            if (indicadoresPtDTO.getOmPt().getIsApongt()) {
                retorno.getListaIndicadoresPtSaida().getAgrupador().add(indicadoresPtDTO);
            }

            // Pegar maior ciclo padrÃ£o
            BigDecimal indCicloPadrao = Util.getBigDecimalDefault(indicadoresPtDTO.getIndicadoresDTO().getCicloPadrao());
            if (indCicloPadrao.compareTo(maiorCicloPadrao) == 1) {
                maiorCicloPadrao = indCicloPadrao;
            }

            // Pegar menor ciclo medio
            BigDecimal cicloMedio = Util.getBigDecimalDefault(indicadoresPtDTO.getIndicadoresDTO().getCicloMedio());
            if (cicloMedio.compareTo(maiorCicloMedio) == 1 || maiorCicloMedio.equals(BigDecimal.ZERO)) {
                maiorCicloMedio = cicloMedio;
            }

        }
        // resultado do agrupamento dos indicadores do Pt saÃ­da
        retorno.getListaIndicadoresPtSaida().getAgrupador().resultMerge(omcfg, omptReferencia);

        // Prepara lista sÃ³ com as mÃ¡quinas de gargalo teorico e gargalo
        // dinÃ¢mico
        for (IndicadoresPtDTO indicadoresPtDTO : retorno.getListaIndicadoresPt().getLista()) {
            BigDecimal indCicloPadrao = Util.getBigDecimalDefault(indicadoresPtDTO.getIndicadoresDTO().getCicloPadrao());
            BigDecimal cicloMedio = Util.getBigDecimalDefault(indicadoresPtDTO.getIndicadoresDTO().getCicloMedio());

            // Agrupa para o gargalo dinamico
            if (maiorCicloMedio.equals(cicloMedio)) {
                retorno.getListaIndicadoresPtGargaloDinamico().getAgrupador().add(indicadoresPtDTO);
            }

            // Agrupa para o gargalo teorico
            if (maiorCicloPadrao.equals(indCicloPadrao)) {
                retorno.getListaIndicadoresPtGargaloTeorico().getAgrupador().add(indicadoresPtDTO);
            }

        }
        // Resultado do agrupamento do gargalo dinÃ¢mico e teÃ³rico
        retorno.getListaIndicadoresPtGargaloDinamico().getAgrupador().resultMerge(omcfg, omptReferencia);
        retorno.getListaIndicadoresPtGargaloTeorico().getAgrupador().resultMerge(omcfg, omptReferencia);

        // prepara a serializaÃ§Ã£o de OmPt
        retorno.prepararSerializacao();

        return retorno;
    }

    public BigDecimal pegaEficienciaInstantanea(OmPt omPt) {
        BigDecimal retorno = BigDecimal.ZERO;
        MapQuery query = new MapQuery(getDao().getSession());
        query.append("select dwRtcic");
        query.append("FROM DwRtcic dwRtcic");
        query.append("join dwRtcic.dwRt b");
        query.append("join b.omPt c");
        query.append("WHERE c.idPt = :idPt");
        query.append("ORDER BY dwRtcic.idRtcic DESC");
        query.defineParametro("idPt", omPt.getIdPt());
        query.setMaxResults(1);
        DwRtcic dwRtcic = (DwRtcic) query.uniqueResult();
        if (dwRtcic == null)
            return retorno;

        DwConsolid consolid = dwRtcic.getDwRt().getDwConsolids().iterator().next();
        DwConsol consol = consolid.getDwConsols().iterator().next();
        Float eficienciaInstantanea = FormulasInjet.calcularEficienciaCiclo(dwRtcic.getSegDuracao(), consol.getSegAutoCiclopadrao());
        retorno = new BigDecimal(eficienciaInstantanea);
        return retorno;
    }

    private void preencherValoresDetalheProducao(DetalhamentoProducaoDTO retorno, List<DwConsolid> listaDwConsolid,
            FiltroDetalheProducaoDTO filtro) {
        prepararRefugoDTO(retorno, listaDwConsolid);
        prepararProducaoDTO(retorno, listaDwConsolid, filtro);
        retorno.setListaparadas(prepararListaParadaDTO(filtro.getOmpt(), listaDwConsolid));
        pegarcamposdetalheproducaoDTO(retorno, listaDwConsolid, filtro);
    }

    private void preenchervaloresdefaultdetalheproducao(DetalhamentoProducaoDTO retorno) {
        retorno.setListaparadas(new ArrayList<DetalheParadaDTO>());
        retorno.setListaproducao(new ArrayList<DetalheProducaoDTO>());
        retorno.setListarefugos(new ArrayList<DetalheRefugoDTO>());
        retorno.setTempodisponivel(0d);
        retorno.setHorastrabalhadas(0d);
        retorno.setHorasparadas(0d);
        retorno.setIndiceparadas(0d);
        retorno.setCicmedio(0d);
        retorno.setPerdascic(0d);
        retorno.setPerdasparadas(0d);
        retorno.setPerdasrefugos(0d);
        retorno.setTotalperdas(0d);
    }

    private void pegarcamposdetalheproducaoDTO(DetalhamentoProducaoDTO retorno, List<DwConsolid> listaDwConsolid,
            FiltroDetalheProducaoDTO filtro) {

        retorno.setDthrinicio(filtro.getDthrinicio());
        retorno.setDthrfim(filtro.getDthrfim());
        retorno.setDuracaointervalo(DataHoraRN.getIntervaloFormatoHHMMSS(filtro.getDthrinicio(), filtro.getDthrfim()));
        
        retorno.setHorastrabalhadas(getTempoTrabalhadas(listaDwConsolid));
        
        retorno.setIndiceparadas(getIndiceParadas(listaDwConsolid, filtro));
        retorno.setCicpadraomedio(getCicPadraoMed(listaDwConsolid));
        retorno.setCicmedio(getCicMedio(listaDwConsolid));
        retorno.setPerdascic(getPerdasCiclos(listaDwConsolid));
        
        /*
         * Marcos Sardinha: 2017-07-06 >> qdo tem parada aberta esta somando perdas e paradas duas vezes. 
         * Não sei se em algum momento funciona diferente. Pro detalhe da hora dos graficos nao funciona.
         * 
         * retorno.setTempodisponivel(getTempoDisponiveis(listaDwConsolid)); << nao ta somando parada com peso aberta no tempo disponivel
         * retorno.setHorasparadas(getTempoParadas(listaDwConsolid, filtro));
         * retorno.setPerdasparadas(getPerdasParadas(listaDwConsolid, filtro));
         * 
         */
        
        retorno.setTempodisponivel(retorno.getHorastrabalhadas() + segTempoParadasComPesoBaseadoEmDetalheParadaDTO(retorno));        
        retorno.setHorasparadas(segTempoParadasBaseadoEmDetalheParadaDTO(retorno));
        retorno.setPerdasparadas(qtdPerdasParadasBaseadaEmDetalheParadaDTO(retorno));
        
        retorno.setPerdasrefugos(getPerdasRefugo(listaDwConsolid));
        retorno.setUltimocicpadrao(getUltimoCicPadrao(listaDwConsolid));
        retorno.setTotalperdas(retorno.getPerdasparadas() + retorno.getPerdasrefugos() + retorno.getPerdascic());
    }

    private Double segTempoParadasComPesoBaseadoEmDetalheParadaDTO(DetalhamentoProducaoDTO detHora) {
    	Double segTempoParadas = 0d;
    	
    	for(DetalheParadaDTO par : detHora.getListaparadas()) {
    		if (par.getPerdas_paradas() > 0d) {
    			segTempoParadas += par.getDuracaoEmSegundos().doubleValue();
    		}
    	}
    	
    	return segTempoParadas;
    }

    
    private Double qtdPerdasParadasBaseadaEmDetalheParadaDTO(DetalhamentoProducaoDTO detHora) {
    	Double qtdPerdasParadas = 0d;
    	
    	for(DetalheParadaDTO par : detHora.getListaparadas()) {
    		qtdPerdasParadas += par.getPerdas_paradas();
    	}
    	
    	return qtdPerdasParadas;
    }

    private Double segTempoParadasBaseadoEmDetalheParadaDTO(DetalhamentoProducaoDTO detHora) {
    	Double segTempoParadas = 0d;
    	
    	for(DetalheParadaDTO par : detHora.getListaparadas()) {
    		segTempoParadas += par.getDuracaoEmSegundos().doubleValue();
    	}
    	
    	return segTempoParadas;
    }

    
    /**
     * Recupera detalhes de produÃ§Ã£o
     * 
     * @param retorno
     * @param listaDwConsolid
     * @param filtro
     */
    private void prepararProducaoDTO(DetalhamentoProducaoDTO retorno, List<DwConsolid> listaDwConsolid, FiltroDetalheProducaoDTO filtro) {
        retorno.setListaproducao(new ArrayList<DetalheProducaoDTO>());
        for (DwConsolid dwconsolid : listaDwConsolid) {
            for (DwConsol dwc : dwconsolid.getDwConsols()) {
                for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {
                    DetalheProducaoDTO producaoDTO = new DetalheProducaoDTO();
                    producaoDTO = new DetalheProducaoDTO();

                    if (dwconsolid.getOmPt().getDsCurta() != null) {
                        producaoDTO.setMaquina(dwconsolid.getOmPt().getCdPt() + " - " + dwconsolid.getOmPt().getDsCurta());
                    } else {
                        producaoDTO.setMaquina(dwconsolid.getOmPt().getCdPt());
                    }

                    producaoDTO.setDsPt(dwconsolid.getOmPt().getDsPt());

                    //Alex 03/05/2017
                    producaoDTO.setFerramenta(getMolde(dwconsolid));
                    
                    producaoDTO.setProduto(dwcpr.getOmProduto().getCdProduto());

                    BigDecimal prodref = dwcpr.getPcsProducaoRefugada();
                    BigDecimal prodbruta = dwcpr.getPcsProducaoBruta();

                    FolhaRN folhaRN = new FolhaRN(this.getDao());
                    BigDecimal segCicloPadrao = BigDecimal.ZERO;
                    try {
                        segCicloPadrao = folhaRN.getCicloPadrao(dwconsolid.getDwFolha(), dwconsolid.getOmPt());
                    } catch (SemCicloPadraoException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    BigDecimal qtPcsCiclo = BigDecimal.ZERO;
                    try {
                        qtPcsCiclo = folhaRN.getPcsPorCicloAtivas(dwconsolid.getDwFolha(), dwcpr.getOmProduto());
                    } catch (SemPcsPorCicloAtivasException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    
                    BigDecimal fatorContagem = BigDecimal.ONE;
                    try {
						fatorContagem = folhaRN.getFatorContagemFromDwFolha(dwconsolid.getDwFolha(), dwconsolid.getOmPt());
					} catch (SemPacoteOuFatorException e) {
						fatorContagem = BigDecimal.ONE;
					}

                    BigDecimal tempoCiclosProdutivos = AritmeticaUtil.somar(
                            dwc.getSegAutoCicloprodutivo() != null ? dwc.getSegAutoCicloprodutivo() : BigDecimal.ZERO,
                            dwc.getSegManuCicloprodutivo() != null ? dwc.getSegManuCicloprodutivo() : BigDecimal.ZERO);

                    BigDecimal qtCiclosProdutivos = AritmeticaUtil.somar(
                            dwc.getQtAutoCicloprodutivo() != null ? dwc.getQtAutoCicloprodutivo() : BigDecimal.ZERO,
                            dwc.getQtManuCicloprodutivo() != null ? dwc.getQtManuCicloprodutivo() : BigDecimal.ZERO);

                    BigDecimal segRitmo = FormulasInjet.calcularRitmo(tempoCiclosProdutivos, qtCiclosProdutivos, segCicloPadrao, dwc.getSegAutoTempoparadaCpVr(), dwc.getSegAutoTempoparadaSpVr());
                    BigDecimal segCicloMedio = FormulasInjet.calcularCicloMedio(tempoCiclosProdutivos, qtCiclosProdutivos);
                    BigDecimal qtMetaInstantanea = FormulasInjet.calcularProducaoPrevista(
                    		dwc.getSegAutoTempoativo(), 
                    		segCicloPadrao, 
                    		qtPcsCiclo,
                    		fatorContagem,
                    		dwc.getDwConsolid().getOmPt().getIndOee()
                    		);
                    
                    //Marcos Sardinha: 2017-07-05 - Defeito #3951
                    BigDecimal qtPerdasCiclo = FormulasInjet.calcularPcsPerdaciclo(segRitmo, segCicloPadrao, qtPcsCiclo);

                    producaoDTO.setProd_prevista(qtMetaInstantanea.doubleValue());
                    producaoDTO.setProd_realizada(prodbruta.doubleValue());
                    producaoDTO.setProd_refugadas(prodref.doubleValue());
                    producaoDTO.setProd_boas(producaoDTO.getProd_realizada() - producaoDTO.getProd_refugadas());
                    producaoDTO.setPerdas_ciclo(qtPerdasCiclo.doubleValue());

                    producaoDTO.setEficiencia_realizacao(FormulasInjet.calcularEficienciaRealizacao(producaoDTO.getProd_boas(),
                            producaoDTO.getProd_prevista()));

                    producaoDTO.setEficiencia_ciclo(FormulasInjet.calcularEficienciaCiclo(segCicloPadrao, segCicloMedio));

                    producaoDTO.setCicloPadrao(segCicloPadrao.doubleValue());
                    producaoDTO.setProducaoPorCiclo(qtPcsCiclo.doubleValue());

                    producaoDTO.setIdFolha(dwconsolid.getDwFolha().getIdFolha());
                    producaoDTO.setDtRevisao(dwconsolid.getDwFolha().getDtRevisao());

                    retorno.getListaproducao().add(producaoDTO);
                }
            }

        }
    }

    private void prepararRefugoDTO(DetalhamentoProducaoDTO retorno, List<DwConsolid> listaDwConsolid) {
        retorno.setListarefugos(new ArrayList<DetalheRefugoDTO>());
        for (DwConsolid dwconsolid : listaDwConsolid) {

            if (dwconsolid.getDwConsols() != null) {
                for (DwConsol dwconsol : dwconsolid.getDwConsols()) {

                    if (dwconsol.getDwConsolres() != null) {
                        for (DwConsolre dwconsolre : dwconsol.getDwConsolres()) {
                            if (dwconsolre.getDwConsolreocos() != null) {
                                for (DwConsolreoco dwconsolreoco : dwconsolre.getDwConsolreocos()) {
                                    if (dwconsolreoco.getDwConsolrelog() != null && (dwconsolreoco.getDwConsolrelog().getIsCancelado() == null || dwconsolreoco.getDwConsolrelog().getIsCancelado() == false) ) {
                                        DwConsolrelog dwconsolrelog = dwconsolreoco.getDwConsolrelog();

                                        DetalheRefugoDTO refugoDTO = new DetalheRefugoDTO();
                                        refugoDTO.setMaquina(dwconsolrelog.getOmPt() != null ? dwconsolrelog.getOmPt().getCdPt() + " - " + dwconsolrelog.getOmPt().getDsCurta() : "");
                                        refugoDTO.setDsPt(dwconsolrelog.getOmPt().getDsPt());
                                        refugoDTO.setFerramenta(getMolde(dwconsolid));
                                        
                                        //Alex 03/05/2017: Fiz as alteracoes abaixo para evitar o null como no seguinte exemplo:
                                        //produto = "Prod03 - null"
                                        String produto = "";
                                        if(dwconsolrelog.getOmProduto() != null) {
                                        	produto += dwconsolrelog.getOmProduto().getCdProduto();
                                        	                                        	
                                        	if(dwconsolrelog.getOmProduto().getDsCurta() != null) {
                                            	produto += " - " + dwconsolrelog.getOmProduto().getDsCurta();
                                            }
                                        }
                                        refugoDTO.setProduto(produto);
                                        //------
                                        
                                        refugoDTO.setRefugo(dwconsolre.getDwTRefugo() != null ? dwconsolre.getDwTRefugo().getCdTrefugo()
                                                + " - " + dwconsolre.getDwTRefugo().getDsTrefugo() : "");
                                        Double qtde = dwconsolrelog.getPcsAutoProducaorefugada() != null ? dwconsolrelog
                                                .getPcsAutoProducaorefugada().doubleValue() : 0d;
                                        qtde += dwconsolrelog.getPcsManuProducaorefugada() != null ? dwconsolrelog
                                                .getPcsManuProducaorefugada().doubleValue() : 0d;
                                        refugoDTO.setQtde_refugo(qtde);
                                        Date dtOcorrencia = dwconsolrelog.getDthrRefugo();
                                        DataHoraRN.adicionaSegundosNaData(dtOcorrencia,
                                                dwconsolrelog.getMsDthrrefugo() != null ? dwconsolrelog.getMsDthrrefugo().intValue() : 0);
                                        refugoDTO.setDthrocorrencia(dtOcorrencia);
                                        refugoDTO.setCausa(dwconsolrelog.getDwTCausa() != null ? dwconsolrelog.getDwTCausa().getCdTcausa()
                                                + " - " + dwconsolrelog.getDwTCausa().getDsTcausa() : "");
                                        refugoDTO.setAcao(dwconsolrelog.getDwTAcao() != null ? dwconsolrelog.getDwTAcao().getCdTacao()
                                                + " - " + dwconsolrelog.getDwTAcao().getDsTacao() : "");

                                        retorno.getListarefugos().add(refugoDTO);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    /**
     * Prepara lista com o detalhes das paradas que ocorreram dentro do perÃ­odo de {@code DwConsolid}
     * 
     * @param listaDwConsolid
     * @return
     */
    private List<DetalheParadaDTO> prepararListaParadaDTO(OmPt ompt, List<DwConsolid> listaDwConsolid) {
    	
    	//Marcos Sardinha: 2017-07-05 >> Defeito #4136
    	Map<Long, OmPt> mapPts = new HashMap<Long, OmPt>();
        List<DetalheParadaDTO> retorno = new ArrayList<DetalheParadaDTO>();
    	
    	if (ompt == null) {
    		for (DwConsolid dwci : listaDwConsolid) {
    			OmPt ptLista = dwci.getOmPt().clone();
    			if (mapPts.containsKey(ptLista.getIdPt()) == false) {
    				mapPts.put(ptLista.getIdPt(), ptLista);
    			}
    		}
    		
    	} else {
    		mapPts.put(ompt.getIdPt(), ompt);
    	}

    	Set<Long> idPts = mapPts.keySet();
    	
    	for (Long idPt : idPts) {
    		ompt = mapPts.get(idPt);
    		
	        Set<DwConsolpalog> pas = new HashSet<DwConsolpalog>();
	        if (listaDwConsolid != null) {
	            for (DwConsolid dwconsolid : listaDwConsolid) {
	
	                FolhaRN folhaRN = new FolhaRN(this.getDao());
	                BigDecimal segCicloPadrao = BigDecimal.ZERO;
	                try {
	                    segCicloPadrao = folhaRN.getCicloPadraoFromDwFolhacisOuDwFolha(dwconsolid.getDwFolha(), dwconsolid.getOmPt());
	                } catch (SemCicloPadraoException e) {
	                    // TODO Auto-generated catch
	                    // block
	                    e.printStackTrace();
	                }
	
	                BigDecimal qtPcsCiclo = BigDecimal.ZERO;
	                try {
	                    qtPcsCiclo = folhaRN.getPcsPorCicloAtivasFromFolhaiacOuDwFolha(dwconsolid.getDwFolha());
	                    if (qtPcsCiclo == null)
	                        qtPcsCiclo = BigDecimal.ZERO;
	                } catch (SemPcsPorCicloAtivasException e) {
	                    // TODO Auto-generated catch
	                    // block
	                    e.printStackTrace();
	                    qtPcsCiclo = BigDecimal.ONE;
	                }
	
	                if (dwconsolid.getDwConsols() != null) {
	                	
	                    for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
	                        if (dwconsol.getDwConsolpas() != null) {
	                            for (DwConsolpa dwconsolpa : dwconsol.getDwConsolpas()) {
	                            	gerarParadaDTO(dwconsolid, dwconsolpa, segCicloPadrao, qtPcsCiclo, pas, retorno);
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        pas.clear();
    	}
        return retorno;
    }
    
    private void gerarParadaDTO(
    		DwConsolid dwconsolid, 
    		DwConsolpa dwconsolpa, 
    		BigDecimal segCicloPadrao, 
    		BigDecimal qtPcsCiclo, 
    		Set<DwConsolpalog> pas, 
    		List<DetalheParadaDTO> retorno) {

        if (dwconsolpa.getDwConsolpaocos() != null) {
            for (DwConsolpaoco dwconsolpaoco : dwconsolpa.getDwConsolpaocos()) {
                if (dwconsolpaoco.getDthrFparada() == null)
                    continue;

                if (dwconsolpaoco.getDwConsolpalog() != null) {
                    DwConsolpalog dwconsolpalog = dwconsolpaoco.getDwConsolpalog();
                    if (pas.contains(dwconsolpalog) == true)
                        continue;

                    pas.add(dwconsolpalog);

                    DetalheParadaDTO paradaDTO = new DetalheParadaDTO();

                    retorno.add(paradaDTO);

                    if (dwconsolid.getDwTurno()  != null) {
                    	
                    	if (dwconsolid.getDwTurno().getDsTurno() != null) {
                    		paradaDTO.setTurno(dwconsolid.getDwTurno().getDsTurno());
                    	}else {
                    		paradaDTO.setTurno(dwconsolid.getDwTurno().getCdTurno());
                    	}
                        
                    }
                    
                    if (dwconsolid.getOmPt() != null) {
                        if (dwconsolid.getOmPt().getDsCurta() != null) {
                            paradaDTO.setMaquina(dwconsolid.getOmPt().getCdPt() + " - " + dwconsolid.getOmPt().getDsCurta());
                        } else {
                            paradaDTO.setMaquina(dwconsolid.getOmPt().getCdPt());
                        }

                        paradaDTO.setDsPt(dwconsolid.getOmPt().getDsPt());
                    }
                    
                    //Alex 28/06/2017 #3952
                    String folha = dwconsolid.getDwFolha().getCdFolha();
                    if(folha == null) {
                    	folha = "";
                    }
                    paradaDTO.setFolha(folha);

                    //Alex 03/05/2017
                    paradaDTO.setFerramenta(getMolde(dwconsolid));

                    /*
                     * paradaDTO.setMaquina(dwconsolpalog .getOmPt() != null ? dwconsolpalog .getOmPt() .getCdPt() +
                     * "-" + dwconsolpalog .getOmPt() .getDsCurta() : ""); paradaDTO .setFerramenta(getMolde(
                     * dwconsolid ));
                     */

                    //Marcos Sardinha: 2017-07-05 - Defeito #3951
                    //long segDuracaoParada = DataHoraRN.getQuantidadeSegundosNoPeriodo(
                    //        dwconsolpaoco.getDthrIparada(), dwconsolpaoco.getDthrFparada());

                    double segDuracaoParada = DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodo(
                            dwconsolpaoco.getDthrIparada(), dwconsolpaoco.getDthrFparada()).doubleValue();

                    
                    if (dwconsolpa.getDwTParada() != null ) {
                        paradaDTO.setParada(dwconsolpa.getDwTParada().getCdTparada() + " - " 
                        			+ (dwconsolpa.getDwTParada().getIsPesa() ? dwconsolpa.getDwTParada().getDsTparada() : dwconsolpa.getDwTParada().getDsTparada().toLowerCase()));
                    	
                    } else {
                        paradaDTO.setParada("");                    	
                    }
                    	

                    /*
                     * Alessandre 21-5-16 Alterei as linhas abaixo para pegar o inico e fim da parada a partir da
                     * ocorrencia ao inves do log paradaDTO.setInicio(dwconsolpalog.getDthrIparada());
                     * paradaDTO.setFim(dwconsolpalog.getDthrFparada());
                     */
                    paradaDTO.setInicio(dwconsolpaoco.getDthrIparada());
                    paradaDTO.setFim(dwconsolpaoco.getDthrFparada());

                    paradaDTO.setDuracao(DataHoraRN.formatSegundosParaHHMMSS((int) segDuracaoParada));
                    paradaDTO.setDuracaoEmSegundos((double) segDuracaoParada);

                    paradaDTO.setArea_resp(dwconsolpa.getDwTParada() != null
                            && dwconsolpa.getDwTParada().getDwTArea() != null ? dwconsolpa.getDwTParada()
                            .getDwTArea().clone(false) : null);

                    /* Alessandre em 22-08-17 ao inves de usar causa acao e just do log, pegar do oco, pois a rn de correcao de parada pode ter modificado
                    paradaDTO.setCausa(dwconsolpalog.getDwTCausa() != null ? dwconsolpalog.getDwTCausa().getCdTcausa() + "-" + dwconsolpalog.getDwTCausa().getDsTcausa() : "");
                    paradaDTO.setAcao(dwconsolpalog.getDwTAcao() != null ? dwconsolpalog.getDwTAcao().getCdTacao() + "-" + dwconsolpalog.getDwTAcao().getDsTacao() : "");
                    paradaDTO.setJustificativa(dwconsolpalog.getDwTJust() != null ? dwconsolpalog.getDwTJust().getCdTjust() + "-" + dwconsolpalog.getDwTJust().getDsTjust() : "");
                    */
                    paradaDTO.setCausa(dwconsolpaoco.getDwTCausa() != null ? dwconsolpaoco.getDwTCausa().getCdTcausa() + "-" + dwconsolpaoco.getDwTCausa().getDsTcausa() : "");
                    paradaDTO.setAcao(dwconsolpaoco.getDwTAcao() != null ? dwconsolpaoco.getDwTAcao().getCdTacao() + "-" + dwconsolpaoco.getDwTAcao().getDsTacao() : "");
                    paradaDTO.setJustificativa(dwconsolpaoco.getDwTJust() != null ? dwconsolpaoco.getDwTJust().getCdTjust() + "-" + dwconsolpaoco.getDwTJust().getDsTjust() : "");

                    
                    // TODO necessÃ¡rio consolidar as
                    // peradas qdo processar os eventos
                    // paradaDTO.setPerdas_paradas(getPerdasParadas(dwconsolid));

                    //Marcos Sardinha: 2017-07-05 - Defeito #3951
                    if (dwconsolpa.getDwTParada().getIsPesa() ) {
	                    paradaDTO.setPerdas_paradas(FormulasInjet.calcularPcsPerdaParada(
	                            new BigDecimal(segDuracaoParada), segCicloPadrao, qtPcsCiclo).setScale(2, RoundingMode.HALF_UP) .doubleValue());
                    } else {
                    	paradaDTO.setPerdas_paradas(0d);
                    }
                    
                    if (dwconsolpalog.getDwConsolpalogtecs() != null) {
                        for (DwConsolpalogtec tecnico : dwconsolpalog.getDwConsolpalogtecs()) {
                        	if (tecnico.getTpUsuario().equals(DwConsolpalogtecTemplate._TpUsuario.TECRESP.getValue())){
                                paradaDTO.setTecnico_responsavel(tecnico.getOmUsr().getCdUsr() + " - " + tecnico.getOmUsr().getDsNome());
                            } else if (tecnico.getTpUsuario().equals(DwConsolpalogtecTemplate._TpUsuario.TEC1.getValue())) {
                                paradaDTO.setTecnico1(tecnico.getOmUsr().getCdUsr() + " - " + tecnico.getOmUsr().getDsNome());
                            } else if (tecnico.getTpUsuario().equals(DwConsolpalogtecTemplate._TpUsuario.TEC2.getValue())) {
                                paradaDTO.setTecnico2(tecnico.getOmUsr().getCdUsr() + " - " + tecnico.getOmUsr().getDsNome());
                            }
                        }
                    }

                }
            }
        }
    
    }

    private Double getPerdasRefugo(List<DwConsolid> listaDwconsolid) {
        double prod_ref = 0d;
        for (DwConsolid dwconsolid : listaDwconsolid) {
            if (dwconsolid.getDwConsols() != null) {
                for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
                    prod_ref += dwconsol.getPcsAutoProducaorefugada() != null ? dwconsol.getPcsAutoProducaorefugada().doubleValue() : 0d;
                    prod_ref += dwconsol.getPcsManuProducaorefugada() != null ? dwconsol.getPcsManuProducaorefugada().doubleValue() : 0d;
                }
            }
        }
        return prod_ref;
    }

    private double getPerdasParada(double ciclopadrao, double cavativas, BigDecimal segautotempoparadaCP) {
        if (ciclopadrao == 0 || cavativas == 0) {
            return 0d;
        }
        double tempoparada = segautotempoparadaCP != null ? segautotempoparadaCP.doubleValue() : 0d;

        return (tempoparada / ciclopadrao) * cavativas;
    }

    /**
     * MÃ©todo que carrega as informaÃ§Ãµes sobre Operadores Logados, a serem exibidas na tela de Detalhe MonitorizaÃ§Ã£o do PT INJET
     */
    private List<OperadorDTO> getListaOperadores(List<DwConsolid> listaDwconsolid, FiltroDetalhePTInjetDTO filtro) {
        List<OperadorDTO> retornoOperadores = new ArrayList<OperadorDTO>();
        ListaOperadoresDTO operadoresandroidDTO = new ListaOperadoresDTO();
        MapQuery q = new MapQuery(getDaoSession());

        // q usado para TURNO
        q.append("SELECT distinct dwConsolmolog");
        q.append("FROM DwConsolmolog dwConsolmolog ");
        q.append("JOIN dwConsolmolog.omUsr omUsr ");
        q.append("join dwConsolmolog.dwConsolmoocos b");
        q.append("join b.dwConsolmo c");
        q.append("join c.dwConsol d");
        q.append("join d.dwConsolid a");
        q.append("join a.ppCp e");
        q.append(" LEFT JOIN dwConsolmolog.omPt omPt ");
        q.append(" LEFT JOIN dwConsolmolog.omGt omGt ");
        // Se no filtro for para a ultma OP entao criar filtro para a OP
        if (filtro.getFiltroOp() != null && filtro.getFiltroOp() == 0) {
        	q.append(" WHERE ( (dwConsolmolog.dthrFlogin IS NULL or e.cdCp = :cdCp) ");
            q.append("or (dwConsolmolog.dthrFlogin between :inicio and :fim and e.cdCp = :cdCp ) ");
            q.append("or (dwConsolmolog.dthrIlogin between :inicio and :fim and e.cdCp = :cdCp ) ) ");
        } else {
        	q.append(" WHERE ( (dwConsolmolog.dthrFlogin IS NULL) ");
            q.append("or (dwConsolmolog.dthrFlogin between :inicio and :fim) ");
            q.append("or (dwConsolmolog.dthrIlogin between :inicio and :fim) ) ");
        }
        
        q.append(" AND omPt.idPt = :idPt ");
        
        // Alessandre em 11-11-16 criei o q2 para ser usado nos operadores logados acumulado
        // q2 usado para acumulado
        MapQuery q2 = new MapQuery(getDaoSession());
        q2.append(" SELECT distinct dwConsolmolog");
        q2.append(" FROM DwConsolmolog dwConsolmolog ");
        q2.append("JOIN dwConsolmolog.omUsr omUsr ");
        q2.append("JOIN dwConsolmolog.omPt omPt ");
        q2.append("join dwConsolmolog.dwConsolmoocos b");
        q2.append("join b.dwConsolmo c");
        q2.append("join c.dwConsol d");
        q2.append("join d.dwConsolid a");
        q2.append("join a.ppCp e");
        q2.append("WHERE omPt.idPt = :idPt ");
        q2.append("AND dwConsolmolog.dthrFlogin IS NOT NULL ");
        q2.append("and e.cdCp = :cdCp");
        q2.append("and a.tpId = 1");
        q2.append("and a.stAtivo is null");

        try {
            List<DwConsolmolog> listaoperadores = new ArrayList<>();
            for (DwConsolid dwci : listaDwconsolid) {
                if (dwci.getOmPt() == null) {
                    continue;
                }

                q.defineParametro("idPt", dwci.getOmPt().getIdPt());
                q.defineParametroTimestamp("inicio", dwci.getDthrIturno());
                q.defineParametroTimestamp("fim", dwci.getDthrFturno());
                q.defineParametro("cdCp", dwci.getPpCp().getCdCp());                
                List<DwConsolmolog> listaDwConsolmolog = q.list();
                
                // Se for Acumulado rodar q2 tb. O q pegaria apenas login aberto
                if (dwci.getDthrIturno() == null) {
                	q2.defineParametro("idPt", dwci.getOmPt().getIdPt());
                	q2.defineParametro("cdCp", dwci.getPpCp().getCdCp());
                	
                	List<DwConsolmolog> lista2 = q2.list();
                	listaDwConsolmolog.addAll(lista2);
                }

                for (DwConsolmolog dwConsolmolog : listaDwConsolmolog) {
                    if (listaoperadores.contains(dwConsolmolog)) {
                        continue;
                    }
                    listaoperadores.add(dwConsolmolog);

                    OperadorDTO operadorDTO = new OperadorDTO();
                    operadorDTO.setMaquina(dwConsolmolog.getOmPt().clone(false));
                    // Alessandre: 17-1-14 comentei a ordem producao do operador
                    // pois esse dado nao eh usado em nenhum lugar e esta dando
                    // erro
                    // operadorDTO.setOrdemproducao(dwConsolmolog.getOmPt().getPpCps().iterator().next().clone(false));
                    operadorDTO.setDthrFlogin(dwConsolmolog.getDthrFlogin());
                    operadorDTO.setDthrIlogin(dwConsolmolog.getDthrIlogin());
                    operadorDTO.setMsDthrflogin(dwConsolmolog.getMsDthrflogin());
                    operadorDTO.setMsDthrilogin(dwConsolmolog.getMsDthrilogin());
                    operadorDTO.setOmUsr(dwConsolmolog.getOmUsr().clone(false));
                    retornoOperadores.add(operadorDTO);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return retornoOperadores;
        }
        operadoresandroidDTO.setListaOperadoresDTO(retornoOperadores);
        retorno.setOperadoresandroidDTO(operadoresandroidDTO);
        return retornoOperadores;
    }

    private Double getCicMedio(List<DwConsolid> listaDwconsolid) {
        Float segCicloMedio = 0f;
        Float segTempoCiclosProdutivos = 0f;
        Float qtCicloProdutivos = 0f;

        for (DwConsolid dwci : listaDwconsolid) {
            for (DwConsol dwconsol : dwci.getDwConsols()) {
                // acumula tempos e qtd necessÃ¡rias para calcular o ciclo
                // mÃ©dio
                qtCicloProdutivos += dwconsol.getQtAutoCicloprodutivo() != null ? dwconsol.getQtAutoCicloprodutivo().floatValue() : 0f;
                qtCicloProdutivos += dwconsol.getQtManuCicloprodutivo() != null ? dwconsol.getQtManuCicloprodutivo().floatValue() : 0f;

                segTempoCiclosProdutivos += dwconsol.getSegAutoCicloprodutivo() != null ? dwconsol.getSegAutoCicloprodutivo().floatValue()
                        : 0f;
                segTempoCiclosProdutivos += dwconsol.getSegManuCicloprodutivo() != null ? dwconsol.getSegManuCicloprodutivo().floatValue()
                        : 0f;
            }
        }

        if (qtCicloProdutivos > 0) {
            segCicloMedio = FormulasInjet.calcularCicloMedio(new BigDecimal(segTempoCiclosProdutivos), new BigDecimal(qtCicloProdutivos))
                    .floatValue();
        }

        return segCicloMedio.doubleValue();

    }

    private String getMolde(DwConsolid dwconsolid) {
        try {
            for (DwFolharap dwFolhaRap : dwconsolid.getDwFolha().getDwFolharaps()) {
                return dwFolhaRap.getDwRap().getCdRap();
            }
        } catch (Exception e) {
            return "";
        }
        return "";
    }


    /**
     * 
     * @param listadwconsolid
     * @return
     */
    private Double getTempoTrabalhadas(List<DwConsolid> listadwconsolid) {
        Double tempotrabalhado = 0d;

        for (DwConsolid dwconsolid : listadwconsolid) {
            if (dwconsolid.getDwConsols() != null) {
                for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
                    tempotrabalhado += dwconsol.getSegAutoTempotrabalhado() != null ? dwconsol.getSegAutoTempotrabalhado().doubleValue()
                            : 0d;
                    tempotrabalhado += dwconsol.getSegManuTempotrabalhado() != null ? dwconsol.getSegManuTempotrabalhado().doubleValue()
                            : 0d;
                }
            }
        }

        return tempotrabalhado.doubleValue();
    }

    private Double getIndiceParadas(List<DwConsolid> listadwconsolid, FiltroDetalheProducaoDTO filtro) {
        Long tempoparadacp = 0l;
        Long tempoativo = 0l;

        Double tempoParada = 0d;

        /*
         * Aqui devemos obter qual a parada em aberto para o periodo analisado
         */
       
        for (DwConsolid dwconsolid : listadwconsolid) {
            if (dwconsolid.getDwConsols() != null) {
                for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
                	BigDecimal tempoParadaCP = dwconsol.getSegAutoTempoparadaCp(); 
                    if (tempoParadaCP == null) {
                        tempoParadaCP = BigDecimal.ZERO;
                    }
                    BigDecimal tempoAtivo = dwconsol.getSegAutoTempoativo();
                    if (tempoAtivo == null) {
                        tempoAtivo = BigDecimal.ZERO;
                    }

                    tempoparadacp += tempoParadaCP.longValue();
                    tempoativo += tempoAtivo.longValue();
                }
            }
        }
        tempoparadacp += tempoParada.longValue();
        tempoativo += tempoParada.longValue();
	        
        
        return FormulasInjet.calcularIndiceParada(BigDecimal.valueOf(tempoparadacp), BigDecimal.valueOf(tempoativo)).doubleValue();
    }

    private Double getCicPadraoMed(List<DwConsolid> listadwconsolid) {
        Double cicloPadrao = 0d;
        Double qtdeCiclos = 0d;

        for (DwConsolid dwconsolid : listadwconsolid) {
            if (dwconsolid.getDwConsols() != null) {
                for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
                    qtdeCiclos += 1;
                    cicloPadrao += dwconsol.getSegAutoCiclopadrao() != null ? dwconsol.getSegAutoCiclopadrao().longValue() : 0l;
                    cicloPadrao += dwconsol.getSegManuCiclopadrao() != null ? dwconsol.getSegManuCiclopadrao().longValue() : 0l;
                }
            }
        }
        return cicloPadrao.doubleValue() / qtdeCiclos;
    }

    // VERIFICAR MÃ‰TODO - MESMA CODIGO DO getCicPadraoMed
    private Double getUltimoCicPadrao(List<DwConsolid> listadwconsolid) {
        Double ultCicloPadrao = 0d;
        for (DwConsolid dwconsolid : listadwconsolid) {
            if (dwconsolid.getDwConsols() != null) {
                for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
                    ultCicloPadrao += dwconsol.getSegAutoCiclopadrao() != null ? dwconsol.getSegAutoCiclopadrao().longValue() : 0l;
                    ultCicloPadrao += dwconsol.getSegManuCiclopadrao() != null ? dwconsol.getSegManuCiclopadrao().longValue() : 0l;
                    break;
                }
            }

        }
        return ultCicloPadrao;
    }

    private Double getPerdasParadas(List<DwConsolid> listadwconsolid, FiltroDetalheProducaoDTO filtro) {
        Double perdaparadacp = 0d;

        GraficoParettoParadaRN rn = new GraficoParettoParadaRN(getDao());
        Double tempoParada = 0d;
        Double perdaParada = 0d;

        for (DwConsolid dwconsolid : listadwconsolid) {
            if (dwconsolid.getDwConsols() != null) {
                for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
                    if (dwconsol.getPcsAutoPerdaparadaCp() == null) {
                        dwconsol.setPcsAutoPerdaparadaCp(BigDecimal.ZERO);
                    }

                    perdaparadacp += dwconsol.getPcsAutoPerdaparadaCp().doubleValue();
                }
            }
            // Calcular a perda da parada em aberto
            if (tempoParada > 0d) {
                FolhaRN frn = new FolhaRN(getDao());
                Double cicloPadrao;
                try {
                    cicloPadrao = frn.getCicloPadrao(dwconsolid.getDwFolha(), dwconsolid.getOmPt()).doubleValue();
                } catch (SemCicloPadraoException e) {
                    cicloPadrao = 1d;
                }
                Double producaoPorCiclo;
                try {
                    producaoPorCiclo = frn.getPcsPorCicloAtivas(dwconsolid.getDwFolha()).doubleValue();
                } catch (SemPcsPorCicloAtivasException e) {
                    producaoPorCiclo = 0d;
                }
                perdaParada = (tempoParada / cicloPadrao) * producaoPorCiclo;
            }
        }

        perdaparadacp += perdaParada.doubleValue();

        return new BigDecimal(perdaparadacp.doubleValue()).doubleValue();
    }

    private Double getPerdasCiclos(List<DwConsolid> listadwconsolid) {
        Double perdaciclo = 0d;
        for (DwConsolid dwconsolid : listadwconsolid) {
            if (dwconsolid.getDwConsols() != null) {
                for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
                    perdaciclo += dwconsol.getPcsAutoPerdaciclo() != null ? dwconsol.getPcsAutoPerdaciclo().doubleValue() : 0d;
                    perdaciclo += dwconsol.getPcsManuPerdaciclo() != null ? dwconsol.getPcsManuPerdaciclo().doubleValue() : 0d;
                }
            }
        }

        return new BigDecimal(perdaciclo.doubleValue()).doubleValue();
    }

    /**
     * Pega lista de DwConsolid
     * 
     * @param tpId
     * @param omPt
     * @param ppCp
     * @param dwTurno
     * @param dwTParada
     * @param dtReferencia
     * @param dtRefIni
     * @param dtRefFim
     * @param dthrIturno
     * @param dthrFturno
     * @param dthrIhora
     * @param dthrFhora
     * @param isJoinParada
     * @param isJoinCiclos
     * @param isJoinProdutos
     * @return
     */
    protected List<DwConsolid> getDwConsolid(IdwLogger log, Byte tpId, OmPt omPt, PpCp ppCp, DwTurno dwTurno, DwTParada dwTParada,
            DwTArea dwtarea, Date dtReferencia, Date dtRefIni, Date dtRefFim, Date dthrIturno, Date dthrFturno, Date dthrIhora,
            Date dthrFhora, boolean isJoinParada, boolean isJoinCiclos, boolean isJoinProdutos, boolean isJoinPerdaMp, OmGt omGt,
            boolean isJoinPerdaMP, boolean isJoinCicloPadrao, boolean isJoinPcPorCiclo) {

        return getDwConsolid(log, tpId, omPt, ppCp, dwTurno, dwTParada, dwtarea, dtReferencia, dtRefIni, dtRefFim, dthrIturno, dthrFturno,
                dthrIhora, dthrFhora, isJoinParada, isJoinCiclos, isJoinProdutos, 0, omGt, isJoinPerdaMP, isJoinCicloPadrao,
                isJoinPcPorCiclo);
    }

    protected List<DwConsolid> getDwConsolid(IdwLogger log, Byte tpId, OmPt omPt, PpCp ppCp, DwTurno dwTurno, DwTParada dwTParada,
            DwTArea dwtarea, Date dtReferencia, Date dtRefIni, Date dtRefFim, Date dthrIturno, Date dthrFturno, Date dthrIhora,
            Date dthrFhora, boolean isJoinParada, boolean isJoinCiclos, boolean isJoinProdutos, int limiteMaxResult, OmGt omGt,
            boolean isJoinPerdaMP, boolean isJoinCicloPadrao, boolean isJoinPcPorCiclo) {

        List<FiltroProducaoPtCpDTO> listaFiltroProducaoPtCp = new ArrayList<FiltroProducaoPtCpDTO>();
        if (omPt != null || ppCp != null) {
            FiltroProducaoPtCpDTO filtro = new FiltroProducaoPtCpDTO();
            filtro.setOmPt(omPt);
            filtro.setPpCp(ppCp);
            listaFiltroProducaoPtCp.add(filtro);
        }

        return getDwConsolid(
        		log, 
        		tpId, 
        		dwTurno, 
        		dwTParada, 
        		dwtarea, 
        		dtReferencia, 
        		dtRefIni, 
        		dtRefFim, 
        		dthrIturno, 
        		dthrFturno, 
        		dthrIhora,
                dthrFhora, isJoinParada, isJoinCiclos, isJoinProdutos, 0, 
                omGt, 
                listaFiltroProducaoPtCp, isJoinPerdaMP, isJoinCicloPadrao, isJoinPcPorCiclo);

    }

    private void definirParametroListaFiltroProducaoPtCp(MapQuery query, List<FiltroProducaoPtCpDTO> listaFiltroProducaoPtCp) {
        if (listaFiltroProducaoPtCp != null && !listaFiltroProducaoPtCp.isEmpty()) {
            int i = 0;

            // Pega monta filtro para todos os itens da lista
            for (FiltroProducaoPtCpDTO filtro : listaFiltroProducaoPtCp) {

                // Filtro pelo idPt
                boolean isFiltroIdPt = filtro.getOmPt() != null && filtro.getOmPt().getIdPt() != null && filtro.getOmPt().getIdPt() > 0;

                // Filtro para o Cp, com base no idCp
                boolean isFiltroIdCp = filtro.getPpCp() != null && filtro.getPpCp().getIdCp() != null && filtro.getPpCp().getIdCp() > 0;

                // Filtro para o Cp, se jÃ¡ tiver para o IdCp, nÃ£o precisa
                // fazer pelo cdCp
                boolean isFiltroCdCp = !isFiltroIdCp && filtro.getPpCp() != null && StringUtils.isNotBlank(filtro.getPpCp().getCdCp());

                if (isFiltroIdPt) {
                    String parametro = new StringBuilder("idPt").append(i).toString();
                    query.defineParametro(parametro, filtro.getOmPt().getIdPt());
                }

                if (isFiltroIdCp) {
                    String parametro = new StringBuilder("idCp").append(i).toString();
                    query.defineParametro(parametro, filtro.getPpCp().getIdCp());
                }

                if (isFiltroCdCp) {
                    String parametro = new StringBuilder("cdCp").append(i).toString();
                    query.defineParametro(parametro, filtro.getPpCp().getCdCp());
                }

                
                
                i++;

            }
            query.append(")");
        }
    }

    private void montarSQLListaFiltroProducaoPtCp(MapQuery query, List<FiltroProducaoPtCpDTO> listaFiltroProducaoPtCp) {
        if (listaFiltroProducaoPtCp != null && !listaFiltroProducaoPtCp.isEmpty()) {
            int i = 0;
            query.append("AND (");

            // Pega monta filtro para todos os itens da lista
            for (FiltroProducaoPtCpDTO filtro : listaFiltroProducaoPtCp) {
                // Primeiro item nÃ£o precisa ter o OR
                if (i != 0) {
                    query.appendOR();
                }
                // Abre parenteses do agrupamento Pt e Cp
                query.append("(");

                String filtroPt = "";
                String filtroCp = "";

                // Filtro pelo idPt
                boolean isFiltroIdPt = filtro.getOmPt() != null && filtro.getOmPt().getIdPt() != null && filtro.getOmPt().getIdPt() > 0;

                // Filtro para o Cp, com base no idCp
                boolean isFiltroIdCp = filtro.getPpCp() != null && filtro.getPpCp().getIdCp() != null && filtro.getPpCp().getIdCp() > 0;

                // Filtro para o Cp, se jÃ¡ tiver para o IdCp, nÃ£o precisa
                // fazer pelo cdCp
                boolean isFiltroCdCp = !isFiltroIdCp && filtro.getPpCp() != null && StringUtils.isNotBlank(filtro.getPpCp().getCdCp());

                if (isFiltroIdPt) {
                    String parametro = new StringBuilder("idPt").append(i).toString();
                    filtroPt = new StringBuilder("dwconsolid.omPt.idPt =:").append(parametro).toString();
                    // query.defineParametro(parametro,
                    // filtro.getOmPt().getIdPt());
                }

                if (isFiltroIdCp) {
                    filtroCp = new StringBuilder("dwconsolid.ppCp.idCp =:idCp").append(i).toString();
                    // query.defineParametro(parametro,
                    // filtro.getPpCp().getIdCp());
                }

                if (isFiltroCdCp) {
                    filtroCp = new StringBuilder("dwconsolid.ppCp.cdCp =:cdCp").append(i).toString();
                    // query.defineParametro(parametro,
                    // filtro.getPpCp().getCdCp());
                }

                // Monta filtro quando for Pt e Cp
                if (isFiltroIdPt && (isFiltroIdCp || isFiltroCdCp)) {
                    query.append(filtroPt).appendAND().append(filtroCp);
                } else if (isFiltroIdPt) {
                    query.append(filtroPt);
                } else if (!filtroCp.isEmpty()) {
                    query.append(filtroCp);
                }

                // Fecha parenteses do agrupamento Pt e Cpj
                query.append(")");

                i++;

            }
            query.append(")");
        }
    }


    /**
     * 
     * No caso de limiteMaxResult ser 0 nÃ£o serÃ¡ utilizado o query.setMaxResult();
     * 
     * 
     */
    protected List<DwConsolid> getDwConsolid(
    		IdwLogger log, 
    		Byte tpId, 
    		DwTurno dwTurno, 
    		DwTParada dwTParada, 
    		DwTArea dwtarea,
            Date dtReferencia, 
            Date dtRefIni, 
            Date dtRefFim, 
            Date dthrIturno, 
            Date dthrFturno, 
            Date dthrIhora, 
            Date dthrFhora,
            boolean isJoinParada, boolean isJoinCiclos, boolean isJoinProdutos, int limiteMaxResult, 
            OmGt omGt,
            List<FiltroProducaoPtCpDTO> listaFiltroProducaoPtCp, boolean isJoinPerdaMP, boolean isJoinCicloPadrao, boolean isJoinPcPorCiclo) {

        MapQuery query = new MapQuery(getDao().getSession());
        query.append("SELECT DISTINCT dwconsolid");
        query.append("FROM DwConsolid dwconsolid");
        query.append("join fetch dwconsolid.dwConsols dwconsol");
        query.append("left join fetch dwconsolid.dwRt dwRt");
        query.append("left join fetch dwconsolid.dwFolha dwfolha");
        query.append("left join fetch dwconsolid.ppCp ppCp");
        query.append("left join fetch dwconsolid.omPt omPt");

        if (omGt != null) {
            query.append("left join fetch omPt.omObjs omObj");
            query.append("left join fetch omObj.omGtByIdGt omGt");
        }

        if (isJoinCiclos) {
            query.append("left join fetch dwRt.dwRtcics");
        }

        if (isJoinParada) {

            query.append("left join fetch dwconsol.dwConsolpas dwconsolpa");
            query.append("left join fetch dwconsolpa.dwConsolpaocos dwconsolpaoco");
            query.append("left join fetch dwconsolpaoco.dwConsolpalog dwconsolpalog");
            query.append("left join fetch dwconsolpalog.dwTParada dwtparada1");
            query.append("left join fetch dwconsolpa.dwTParada dwtparada2");
            query.append("left join fetch dwconsolpalog.dwTAcao");
            query.append("left join fetch dwconsolpalog.dwTJust");
            query.append("left join fetch dwconsolpalog.dwTCausa");
            query.append("left join fetch dwtparada2.dwTArea dwtarea");
            query.append("left join fetch dwconsolpalog.dwConsolpalogtecs");

        }

        if (isJoinCicloPadrao) {
            query.append("left join fetch dwfolha.dwFolhacics dwFolhacic");
            query.append("left join fetch dwFolhacic.omPt");
        }

        if (isJoinPcPorCiclo) {
            query.append("left join fetch dwfolha.dwFolharaps dwFolharap");
            query.append("left join fetch dwFolharap.dwFolharapcoms");
        }

        if (isJoinProdutos) {
            query.append("left join fetch dwconsol.dwConsolprs");
            query.append("left join fetch ppcp.ppCpprodutos ppcpprodutos");
        }

        if (isJoinPerdaMP == true) {
            query.append("left join dwconsol.dwConsolpemps dwconsolpemp");
            query.append("left join dwconsolpemp.dwConsolpempocos dwconsolpempoco");
            query.append("left join dwconsolpempoco.dwConsolperdamplog dwconsolperdamplog");
            query.append("left join dwconsolperdamplog.dwRap dwrap");
        }

        query.append("WHERE dwconsolid.tpId = :tpId and dwconsolid.stAtivo is null ");

        montarSQLListaFiltroProducaoPtCp(query, listaFiltroProducaoPtCp);

        if (dtRefIni != null) {
            query.append("AND dwconsolid.dtReferencia >= :dtrefinicial");
        }

        if (dthrIturno != null) {
            query.append("AND dwconsolid.dthrIturno >= :dthrIturno");
        }

        if (dthrIhora != null && dthrFhora == null) {
            query.append("AND dwconsolid.dthrIhora = :dthrIhora");
        }
        if (dthrIhora != null && dthrFhora != null) {
            query.append("AND dwconsolid.dthrIhora between :dthrIhora and  :dthrFhora");
        }

        if (dtRefFim != null) {
            query.append("AND dwconsolid.dtReferencia <= :dtreffinal");
        }

        if (dthrFturno != null) {
            query.append("AND dwconsolid.dthrFturno <= :dthrFturno");
        }

        if (dtReferencia != null && dtRefIni == null && dtRefFim == null) {
            query.append("AND dwconsolid.dtReferencia = :dtReferencia");
        }

        if (dwTurno != null) {
            query.append("AND dwconsolid.dwTurno.idTurno = :idTurno");
        } else {
        	//Alex 30/06/2017 #3949
        	//Marcos Sardinha: 2017-07-17 >> Defeito #3885 ... qdo tem filtro de turno indefinido e necessita analisar hora nao recuperada dados
        	if (tpId.equals(PERIODO_CONSOLIDACAO_HORA) == false && dwTurno == null) {
        		query.append("AND dwconsolid.dwTurno.idTurno <> 1");
        	}
        }

        if (omGt != null) {
            query.append("AND omGt.idGt = :idGt");
        }

        if (dwTParada != null) {
            query.append("AND dwtparada1.cdTparada = :cdParada");
        }

        if (dwtarea != null) {
            query.append("and dwtarea.cdArea = :cdarea");
        }

        query.append("ORDER BY dwconsolid.idConsolid");

        if (tpId == PERIODO_CONSOLIDACAO_OP) {
            query.defineParametro("tpId", PERIODO_CONSOLIDACAO_ACUMULADO);
        } else {
            query.defineParametro("tpId", tpId);
        }

        definirParametroListaFiltroProducaoPtCp(query, listaFiltroProducaoPtCp);

        if (dtReferencia != null) {
            query.defineParametroData("dtReferencia", DataHoraRN.getDataSemHora(dtReferencia));
        }

        if (dwTurno != null) {
            query.defineParametro("idTurno", dwTurno.getIdTurno());
        }

        if (omGt != null) {
            query.defineParametro("idGt", omGt.getIdGt());
        }

        if (dtRefIni != null) {
            query.defineParametroData("dtrefinicial", DataHoraRN.getDataSemHora(dtRefIni));
        }

        if (dtRefFim != null) {
            query.defineParametroData("dtreffinal", DataHoraRN.getDataSemHora(dtRefFim));
        }

        if (dthrIturno != null) {
            query.defineParametroTimestamp("dthrIturno", dthrIturno);
        }

        if (dthrIhora != null) {
            query.defineParametroTimestamp("dthrIhora", dthrIhora);
        }

        if (dthrFturno != null) {
            query.defineParametroTimestamp("dthrFturno", dthrFturno);
        }

        if (dthrFhora != null) {
            query.defineParametroTimestamp("dthrFhora", dthrFhora);
        }

        if (dwTParada != null) {
            query.defineParametro("cdParada", dwTParada.getCdTparada());
        }

        if (dwtarea != null) {
            query.defineParametro("cdarea", dwtarea.getCdArea());
        }

        if (limiteMaxResult > 0) {
            query.setMaxResults(limiteMaxResult);
        }

        List<DwConsolid> listaretorno = query.list();

        return listaretorno;

    }

    /**
     * 
     * No caso de limiteMaxResult ser 0 nÃ£o serÃ¡ utilizado o query.setMaxResult();
     * Consulta baseada em idconsolid conhecido (ou seja demais parametros sao desnecessarios)
     * 
     * 
     */
    protected List<DwConsolid> getDwConsolid(IdwLogger log, Long idConsolid, 
    		boolean isJoinParada, boolean isJoinCiclos, boolean isJoinProdutos, 
            boolean isJoinPerdaMP, boolean isJoinCicloPadrao, boolean isJoinPcPorCiclo) {

        MapQuery query = new MapQuery(getDao().getSession());
        query.append("SELECT DISTINCT dwconsolid");
        query.append("FROM DwConsolid dwconsolid");
        query.append("join fetch dwconsolid.dwConsols dwconsol");
        query.append("left join fetch dwconsolid.dwRt dwRt");
        query.append("left join fetch dwconsolid.dwFolha dwfolha");
        query.append("left join fetch dwconsolid.ppCp ppCp");
        query.append("left join fetch dwconsolid.omPt omPt");
        query.append("left join fetch dwconsolid.dwTurno dwTurno");

        if (isJoinCiclos) {
            query.append("left join fetch dwRt.dwRtcics");
        }

        if (isJoinParada) {

            query.append("left join fetch dwconsol.dwConsolpas dwconsolpa");
            query.append("left join fetch dwconsolpa.dwConsolpaocos dwconsolpaoco");
            query.append("left join fetch dwconsolpaoco.dwConsolpalog dwconsolpalog");
            query.append("left join fetch dwconsolpalog.dwTParada dwtparada1");
            query.append("left join fetch dwconsolpa.dwTParada dwtparada2");
            query.append("left join fetch dwconsolpalog.dwTAcao");
            query.append("left join fetch dwconsolpalog.dwTJust");
            query.append("left join fetch dwconsolpalog.dwTCausa");
            query.append("left join fetch dwtparada2.dwTArea dwtarea");
            query.append("left join fetch dwconsolpalog.dwConsolpalogtecs");

        }

        if (isJoinCicloPadrao) {
            query.append("left join fetch dwfolha.dwFolhacics dwFolhacic");
            query.append("left join fetch dwFolhacic.omPt");
        }

        if (isJoinPcPorCiclo) {
            query.append("left join fetch dwfolha.dwFolharaps dwFolharap");
            query.append("left join fetch dwFolharap.dwFolharapcoms");
        }

        if (isJoinProdutos) {
            query.append("left join fetch dwconsol.dwConsolprs");
            query.append("left join fetch ppcp.ppCpprodutos ppcpprodutos");
        }

        if (isJoinPerdaMP == true) {
            query.append("left join dwconsol.dwConsolpemps dwconsolpemp");
            query.append("left join dwconsolpemp.dwConsolpempocos dwconsolpempoco");
            query.append("left join dwconsolpempoco.dwConsolperdamplog dwconsolperdamplog");
            query.append("left join dwconsolperdamplog.dwRap dwrap");
        }

        query.append("WHERE dwconsolid.idConsolid = :idConsolid");

        query.append("ORDER BY dwconsolid.idConsolid");

        query.defineParametro("idConsolid", idConsolid);


        List<DwConsolid> listaretorno = query.list();

        return listaretorno;

    }
    
    public List<DwConsolre> getDwconsolRes(DwConsol dwConsol) {

        MapQuery q = new MapQuery(getDao().getSession());

        q.append("select distinct a");
        q.append("from DwConsolre a");
        q.append("join a.dwConsolreocos b");
        q.append("join b.dwConsolrelog c");
        q.append("where a.dwConsol = :consol");
        q.append("and (c.isCancelado = :iscancelado or c.isCancelado is null)");

        q.defineParametro("consol", dwConsol);
        q.defineParametro("iscancelado", false);

        List<DwConsolre> listaRes = q.list();

        return listaRes;
    }

    public DwFolhasDTO getFolhasDoPt(OmPt pt) {

        MapQuery q = new MapQuery(getDao().getSession());
        q.append("SELECT DISTINCT consolid FROM DwConsolid consolid");
        q.append("JOIN FETCH consolid.dwFolha folha");
        q.append("WHERE consolid.omPt =:pt");
        q.defineParametro("pt", pt);

        List<DwConsolid> listaConsolids = q.list();

        DwFolhasDTO retorno = new DwFolhasDTO();
        retorno.setListaDwFolhaDTO(new ArrayList<DwFolhaDTO>());

        HashMap<String, DwFolha> mapFolhas = new HashMap<String, DwFolha>();

        for (DwConsolid consolid : listaConsolids) {
            mapFolhas.put(consolid.getDwFolha().getCdFolha(), consolid.getDwFolha());
        }

        for (DwFolha f : mapFolhas.values()) {
            DwFolhaDTO folhaDTO = new DwFolhaDTO();
            folhaDTO.setDwFolha(f.clone(false));
            retorno.getListaDwFolhaDTO().add(folhaDTO);
        }

        return retorno;
    }

    /*
     * Metodo para montar lista com informacoes consolidadas das perdas por produto
     */

    public ProdutosPerdasFichaMaqDTO getListaProdutosPerdasFichaMaqDTO(DetalheMonitorizacaoPTInjetDTO detMonitoramento, byte tipoExibicaoQtd) {

        boolean itemExisteNaLista = false;
        ProdutosPerdasFichaMaqDTO retorno = new ProdutosPerdasFichaMaqDTO();

        // perdas por produto
        double qtcicloprod = 0d;
        double segcicloprod = 0d;
        double segcicloimprod = 0d;
        double qtperdapar = 0d;
        double tempodisponivel = 0d;
        double tempoparadaCP = 0d;
        double tempoparadaCpVarRitmo = 0d;
        double tempoparadaSpVarRitmo = 0d;

        BigDecimal pesoBruto = BigDecimal.ZERO;

        double efiCic = 0d;
        double indPar = 0d;
        double indRef = 0d;
        double indCav = 0d;

        double segcicloPadrao = 0d;
        double segCicloMedio = 0d;

        // aba ciclos
        Long qtPcsCiclo = 0l;
        Long qtPcsCicloSum = 0l;

        FolhaRN folhaRN = new FolhaRN(this.getDao());
        DwFolhacic dwFolhaCic;

        for (DwConsolid dwci : detMonitoramento.getListaDwConsolId()) {
            if (dwci.getDwConsols() != null) {
                for (DwConsol dwconsol : dwci.getDwConsols()) {

                    // recupera ciclo padrao
                    try {
                        dwFolhaCic = folhaRN.getFolhacic(dwci.getDwFolha(), dwci.getOmPt().clone(false));
                        segcicloPadrao = dwFolhaCic.getSegCiclopadrao().doubleValue();

                    } catch (SemCicloPadraoException e) {
                        segcicloPadrao = dwci.getDwFolha().getSegCiclopadrao().doubleValue();
                    }

                    if (dwconsol.getSegAutoCiclomedio() != null) {
                        segCicloMedio = dwconsol.getSegAutoCiclomedio().doubleValue();
                    }

                    // recupera ciclo padrao
                    try {
                        qtPcsCiclo = folhaRN.getPcsPorCicloAtivas(dwci.getDwFolha()).longValue();
                    } catch (SemPcsPorCicloAtivasException e) {
                        qtPcsCiclo = 1l;
                    }

                    // efi cic será¡£alculada com base no ò¬´©mo ciclo
                    // para
                    // manter compatibilidade com outros pontos
                    efiCic = FormulasInjet.calcularEficienciaCiclo(new BigDecimal(segcicloPadrao), new BigDecimal(segCicloMedio))
                            .doubleValue();

                    // acumula
                    qtPcsCicloSum += qtPcsCiclo;

                    // lista de produtos
                    if (dwconsol.getDwConsolprs() != null) {

                        List<DwConsolid> consolids = new ArrayList<>();
                        consolids.add(dwci);
                        
                        for (DwConsolpr dwconsolpr : dwconsol.getDwConsolprs()) {
                            ProdutoDTO dtoCav = new ProdutoDTO();
                            dtoCav.setProduto(dwconsolpr.getOmProduto());

                            // aqui devo pegar o qt ativo do rap se nao tiver
                            // pegar folhaiac
                            try {
                                dtoCav.setQtdAtiva(folhaRN.getPcsPorCicloAtivas(dwci.getDwFolha(), dwconsolpr.getOmProduto()));
                            } catch (SemPcsPorCicloAtivasException e1) {
                                dtoCav.setQtdAtiva(BigDecimal.ONE);
                            }

                            if (dtoCav.getQtdAtiva() == null) {
                                dtoCav.setQtdAtiva(BigDecimal.ONE);
                            }

                            try {
                                dtoCav.setQtdTotal(folhaRN.getPcsPorCicloTodas(dwci.getDwFolha(), dwconsolpr.getOmProduto()));
                            } catch (SemPcsPorCicloAtivasException e1) {
                                dtoCav.setQtdTotal(BigDecimal.ZERO);
                            }

                            if (dtoCav.getQtdTotal() == null)
                                dtoCav.setQtdTotal(BigDecimal.ZERO);

                            Long prodrefproduto = dwconsolpr.getPcsAutoProducaorefugada() != null ? dwconsolpr.getPcsAutoProducaorefugada()
                                    .longValue() : 0l;
                            prodrefproduto += dwconsolpr.getPcsManuProducaorefugada() != null ? dwconsolpr.getPcsManuProducaorefugada()
                                    .longValue() : 0l;

                            Long prodbrutaproduto = dwconsolpr.getPcsAutoProducaobruta() != null ? dwconsolpr.getPcsAutoProducaobruta()
                                    .longValue() : 0l;
                            prodbrutaproduto += dwconsolpr.getPcsManuProducaobruta() != null ? dwconsolpr.getPcsManuProducaobruta()
                                    .longValue() : 0l;

                            BigDecimal qtPcsCicloProduto = dtoCav.getQtdAtiva();
                            BigDecimal qtPcsCicloProdutoTotais = dtoCav.getQtdTotal();

                            // perdas por produto
                            qtcicloprod = 0d;
                            segcicloprod = 0d;
                            segcicloimprod = 0d;
                            qtperdapar = 0d;
                            tempodisponivel = 0d;
                            tempoparadaCP = 0d;
                            tempoparadaCpVarRitmo = 0d;
                            tempoparadaSpVarRitmo = 0d;

                            qtcicloprod += dwconsol.getQtAutoCicloprodutivo() != null ? dwconsol.getQtAutoCicloprodutivo().doubleValue()
                                    : 0d;
                            qtcicloprod += dwconsol.getQtManuCicloprodutivo() != null ? dwconsol.getQtManuCicloprodutivo().doubleValue()
                                    : 0d;

                            segcicloprod += dwconsol.getSegAutoCicloprodutivo() != null ? dwconsol.getSegAutoCicloprodutivo().doubleValue()
                                    : 0d;
                            segcicloprod += dwconsol.getSegManuCicloprodutivo() != null ? dwconsol.getSegManuCicloprodutivo().doubleValue()
                                    : 0d;

                            segcicloimprod += dwconsol.getSegAutoCicloimprodutivo() != null ? dwconsol.getSegAutoCicloimprodutivo()
                                    .doubleValue() : 0d;
                            segcicloimprod += dwconsol.getSegManuCicloimprodutivo() != null ? dwconsol.getSegManuCicloimprodutivo()
                                    .doubleValue() : 0d;

                            tempoparadaCP += dwconsol.getSegAutoTempoparadaCp() != null ? dwconsol.getSegAutoTempoparadaCp().doubleValue()
                                    : 0d;
                            tempoparadaCP += dwconsol.getSegManuTempoparadaCp() != null ? dwconsol.getSegManuTempoparadaCp().doubleValue()
                                    : 0d;

                            tempoparadaCpVarRitmo += ObjectUtils.defaultIfNull(dwconsol.getSegAutoTempoparadaCpVr(), BigDecimal.ZERO)
                                    .doubleValue();
                            tempoparadaCpVarRitmo += ObjectUtils.defaultIfNull(dwconsol.getSegManuTempoparadaCpVr(), BigDecimal.ZERO)
                                    .doubleValue();

                            tempoparadaSpVarRitmo += ObjectUtils.defaultIfNull(dwconsol.getSegAutoTempoparadaSpVr(), BigDecimal.ZERO)
                                    .doubleValue();
                            tempoparadaSpVarRitmo += ObjectUtils.defaultIfNull(dwconsol.getSegManuTempoparadaSpVr(), BigDecimal.ZERO)
                                    .doubleValue();

                            tempodisponivel += FormulasInjet.calcularTempoAtivo(new BigDecimal(segcicloprod),
                                    new BigDecimal(tempoparadaCP), new BigDecimal(segcicloimprod), new BigDecimal(tempoparadaCpVarRitmo),
                                    new BigDecimal(tempoparadaSpVarRitmo)).doubleValue();

                            PerdasDTO perdasDTO = new PerdasDTO();

                            try {
                                qtperdapar = getPerdasParada(segcicloPadrao, qtPcsCicloProduto.doubleValue(), new BigDecimal(
                                        tempoparadaCP));
                                perdasDTO.setPerdasparada(qtperdapar);
                            } catch (Exception e) {
                                perdasDTO.setPerdasparada(0d);
                            }

                            perdasDTO.setIndiceparadas(FormulasInjet.calcularIndiceParada(new BigDecimal(tempoparadaCP),
                                    BigDecimal.valueOf(tempodisponivel)).doubleValue());
                            perdasDTO.setIndicerefugos(FormulasInjet.calcularIndiceRefugo(dwconsolpr.getPcsAutoProducaorefugada(),
                                    dwconsolpr.getPcsAutoProducaobruta()).doubleValue());
                            perdasDTO.setPerdasrefugos(dwconsolpr.getPcsAutoProducaorefugada() != null ? dwconsolpr
                                    .getPcsAutoProducaorefugada().doubleValue() : 0d);
                            try {
                                perdasDTO.setEficienciaciclo(efiCic);

                            } catch (Exception e) {
                                perdasDTO.setEficienciaciclo(0d);
                            }

                            BigDecimal segRitmo = FormulasInjet.calcularRitmo(new BigDecimal(segcicloprod), new BigDecimal(qtcicloprod),
                                    new BigDecimal(segcicloPadrao), new BigDecimal(tempoparadaCpVarRitmo), new BigDecimal(
                                            tempoparadaSpVarRitmo));

                            try {
                                perdasDTO.setPerdasineficienciaciclo(FormulasInjet.calcularPcsPerdaciclo(segRitmo,
                                        new BigDecimal(segcicloPadrao), qtPcsCicloProduto).doubleValue());
                            } catch (Exception e) {
                                perdasDTO.setPerdasineficienciaciclo(0d);
                            }

                            BigDecimal perdaPorCiclo = BigDecimal.ZERO;
                            if (qtPcsCicloProdutoTotais != null && qtPcsCicloProduto != null) {
                                perdaPorCiclo = qtPcsCicloProdutoTotais.subtract(qtPcsCicloProduto);
                            }
                            Double perdaPCI = qtcicloprod * perdaPorCiclo.doubleValue();

                            try {
                                perdasDTO.setPerdascavativas(perdaPCI);
                                perdasDTO.setIndicecavativas(FormulasInjet.calcularIndicePcsPorCicloAtivas(qtPcsCicloProdutoTotais,
                                        qtPcsCicloProduto).doubleValue());
                            } catch (Exception e) {
                                perdasDTO.setPerdascavativas(0d);
                                perdasDTO.setIndicecavativas(0d);
                            }

                            try {
                                perdasDTO
                                        .setTotalperdas(FormulasInjet.calcularTotalPerdas(
                                                perdasDTO.getPerdasineficienciaciclo(),
                                                perdasDTO.getPerdasparada(), perdasDTO.getPerdasrefugos(),
                                                perdasDTO.getPerdascavativas()).doubleValue());
                            } catch (Exception e) {
                                perdasDTO.setTotalperdas(0d);
                            }

                            // depois da informaè¤¯ consolidada deve-se fazer
                            // o
                            // preenchimento do DTO
                            ProdutoPerdasFichaMaqDTO prResumo = new ProdutoPerdasFichaMaqDTO();
                            prResumo.setMaquina(dwci.getOmPt());

                            if (dwci.getDwFolha().getDwFolharaps() != null && dwci.getDwFolha().getDwFolharaps().size() > 0) {
                                prResumo.setFerramenta(dwci.getDwFolha().getDwFolharaps().iterator().next().getDwRap());
                            }

                            prResumo.setProduto(dwconsolpr.getOmProduto());
                            prResumo.setPerdasineficienciaciclo(new BigDecimal(perdasDTO.getPerdasineficienciaciclo()));
                            prResumo.setPerdasparada(new BigDecimal(perdasDTO.getPerdasparada()));
                            prResumo.setPerdasrefugos(new BigDecimal(perdasDTO.getPerdasrefugos()));
                            prResumo.setPerdascavativas(new BigDecimal(perdasDTO.getPerdascavativas()));
                            prResumo.setTotalperdas(new BigDecimal(perdasDTO.getTotalperdas()));
                            prResumo.setQtdProducaoBruta(new BigDecimal(prodbrutaproduto.doubleValue()));

                            // tempos
                            prResumo.setSegTempoAtivo(new BigDecimal(tempodisponivel));
                            prResumo.setSegTempoParComPeso(new BigDecimal(tempoparadaCP));
                            prResumo.setSegTempoCiclosNormais(new BigDecimal(segcicloprod));
                            prResumo.setQtdCountCiclosNormais(new BigDecimal(qtcicloprod));
                            prResumo.setSegSumCicloPadrao(new BigDecimal(segcicloPadrao));
                            prResumo.setQtdSumPcsCicAtivas(new BigDecimal(qtPcsCicloProduto.doubleValue()));
                            prResumo.setQtdSumPcsCicTotais(new BigDecimal(qtPcsCicloProdutoTotais.doubleValue()));

                            // indicadores
                            prResumo.setEficienciaciclo(BigDecimal.ZERO);
                            prResumo.setIndiceparadas(BigDecimal.ZERO);
                            prResumo.setIndicerefugos(BigDecimal.ZERO);
                            prResumo.setIndicecavativas(BigDecimal.ZERO);

                            if (tipoExibicaoQtd != EXIBICAO_QTD_UNIDADE_BASICA) {
                                /*
                                 * Necessario converter as qtdes para peso. Se nao houver peso cadastrado as qtdes ficarao zeradas
                                 */

                                pesoBruto = prResumo.getProduto().getGPesoBruto();

                                if (pesoBruto == null) {
                                    pesoBruto = BigDecimal.ZERO;
                                }

                                if (tipoExibicaoQtd == EXIBICAO_QTD_PESO_KG) {
                                    pesoBruto = pesoBruto.divide(new BigDecimal(1000), BigDecimal.ROUND_HALF_EVEN);
                                } else {
                                    pesoBruto = pesoBruto.divide(new BigDecimal(1000000), BigDecimal.ROUND_HALF_EVEN);
                                }

                                if (pesoBruto.compareTo(BigDecimal.ZERO) == 0) {
                                    prResumo.setPerdasineficienciaciclo(BigDecimal.ZERO);
                                    prResumo.setPerdasparada(BigDecimal.ZERO);
                                    prResumo.setPerdasrefugos(BigDecimal.ZERO);
                                    prResumo.setPerdascavativas(BigDecimal.ZERO);
                                    prResumo.setTotalperdas(BigDecimal.ZERO);
                                } else {
                                    prResumo.setPerdasineficienciaciclo(prResumo.getPerdasineficienciaciclo().divide(pesoBruto,
                                            BigDecimal.ROUND_HALF_EVEN));
                                    prResumo.setPerdasparada(prResumo.getPerdasparada().divide(pesoBruto, BigDecimal.ROUND_HALF_EVEN));
                                    prResumo.setPerdasrefugos(prResumo.getPerdasrefugos().divide(pesoBruto, BigDecimal.ROUND_HALF_EVEN));
                                    prResumo.setPerdascavativas(prResumo.getPerdascavativas().divide(pesoBruto, BigDecimal.ROUND_HALF_EVEN));
                                    prResumo.setTotalperdas(prResumo.getTotalperdas().divide(pesoBruto, BigDecimal.ROUND_HALF_EVEN));

                                }
                            }

                            if (retorno.getProdutos() == null) {
                                retorno.setProdutos(new ArrayList<ProdutoPerdasFichaMaqDTO>());
                                retorno.getProdutos().add(prResumo);
                            } else {
                                // verifica se o produto existe na lista
                                itemExisteNaLista = false;
                                for (ProdutoPerdasFichaMaqDTO itemLista : retorno.getProdutos()) {
                                    if ((itemLista.getProduto().getCdProduto().equals(prResumo.getProduto().getCdProduto()))
                                            && (itemLista.getMaquina().getCdPt().equals(prResumo.getMaquina().getCdPt()))) {
                                        // atualizar
                                        itemLista.setPerdasineficienciaciclo(itemLista.getPerdasineficienciaciclo().add(
                                                prResumo.getPerdasineficienciaciclo()));
                                        itemLista.setPerdasparada(itemLista.getPerdasparada().add(prResumo.getPerdasparada()));
                                        itemLista.setPerdasrefugos(itemLista.getPerdasrefugos().add(prResumo.getPerdasrefugos()));
                                        itemLista.setPerdascavativas(itemLista.getPerdascavativas().add(prResumo.getPerdascavativas()));
                                        itemLista.setTotalperdas(itemLista.getTotalperdas().add(prResumo.getTotalperdas()));

                                        itemLista.setQtdProducaoBruta(itemLista.getQtdProducaoBruta().add(prResumo.getQtdProducaoBruta()));
                                        itemLista.setSegTempoAtivo(itemLista.getSegTempoAtivo().add(prResumo.getSegTempoAtivo()));
                                        itemLista.setSegTempoParComPeso(itemLista.getSegTempoParComPeso().add(
                                                prResumo.getSegTempoParComPeso()));
                                        itemLista.setSegTempoCiclosNormais(itemLista.getSegTempoCiclosNormais().add(
                                                prResumo.getSegTempoCiclosNormais()));
                                        itemLista.setQtdCountCiclosNormais(itemLista.getQtdCountCiclosNormais().add(
                                                prResumo.getQtdCountCiclosNormais()));
                                        itemLista.setSegSumCicloPadrao(itemLista.getSegSumCicloPadrao()
                                                .add(prResumo.getSegSumCicloPadrao()));
                                        itemLista.setQtdSumPcsCicAtivas(itemLista.getQtdSumPcsCicAtivas().add(
                                                prResumo.getQtdSumPcsCicAtivas()));
                                        itemLista.setQtdSumPcsCicTotais(itemLista.getQtdSumPcsCicTotais().add(
                                                prResumo.getQtdSumPcsCicTotais()));

                                        // abandonar for
                                        itemExisteNaLista = true;
                                        break;
                                    }
                                }

                                if (itemExisteNaLista == false) {
                                    // adiciona item na lista
                                    retorno.getProdutos().add(prResumo);
                                }
                            }

                        }
                    }
                }
            }
        }

        // calcular indicadores
        if (retorno.getProdutos() != null) {
            for (ProdutoPerdasFichaMaqDTO pr : retorno.getProdutos()) {
                // ind paradas
                indPar = FormulasInjet.calcularIndiceParada(pr.getSegTempoParComPeso(), pr.getSegTempoAtivo());

                // ind refugo
                indRef = FormulasInjet.calcularIndiceRefugo(pr.getPerdasrefugos(), pr.getQtdProducaoBruta());

                // ind cav
                indCav = FormulasInjet.calcularIndicePcsPorCicloAtivas(pr.getQtdSumPcsCicTotais(), pr.getQtdSumPcsCicAtivas()).doubleValue();

                // efi cic
                /*
                 * segCicloMedio = FormulasInjet.calcularCicloMedio(pr.getSegTempoCiclosNormais (),
                 * pr.getQtdCountCiclosNormais()).doubleValue(); segcicloPadrao = pr.getSegSumCicloPadrao().doubleValue() /
                 * pr.getQtdCountCiclosNormais().doubleValue(); efiCic = FormulasInjet.calcularEficienciaCiclo(new
                 * BigDecimal(segcicloPadrao) , new BigDecimal(segCicloMedio));
                 */
                pr.setIndiceparadas(new BigDecimal(indPar));
                pr.setIndicerefugos(new BigDecimal(indRef));
                pr.setIndicecavativas(new BigDecimal(indCav));
                pr.setEficienciaciclo(new BigDecimal(efiCic));
            }
        }
        return retorno;

    }

    /*
     * Método que retorna o detalhamento de perdas/ganhos por ciclo - ordena��oo de máquinas, molde e produtos com maiores perdas
     */

    public ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO getDetalhamentoGraficoPerdasBICiclosOrdemMaquina(
            DetalheMonitorizacaoPTInjetDTO indicadores, String cdMaquina, String cdProduto, Boolean isConsiderarPerda, Boolean isConsiderarGanho) {
        
        ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO detalhamento = new ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO();
        detalhamento.setResumoIndicadores(new ResumoParetoPerdasDetCiclosDTO());
        
        GraficoBIParetoDetCiclosOrdemMaquinaDTO itemMaquina = new GraficoBIParetoDetCiclosOrdemMaquinaDTO();
        GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO itemFerramenta = new GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO();
        GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO itemProduto = new GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO();

        BigDecimal segCicloPadrao = BigDecimal.ZERO;
        BigDecimal qtPcsCiclo = BigDecimal.ZERO;

        BigDecimal segCiclosProdutivos = BigDecimal.ZERO;
        BigDecimal segTempoCiclosProdutivosSemParadasVariacaoRitmo = BigDecimal.ZERO;
        BigDecimal segTempoparadaCpVr = BigDecimal.ZERO;
        BigDecimal segTempoparadaSpVr = BigDecimal.ZERO;

        BigDecimal qtCiclosProdutivos = BigDecimal.ZERO;
        BigDecimal segRitmo = BigDecimal.ZERO;
        BigDecimal qtPerdasCiclo = BigDecimal.ZERO;
        BigDecimal segCicloMedio = BigDecimal.ZERO;

        BigDecimal qtPerdasCicloKg = BigDecimal.ZERO;
        BigDecimal qtPerdasCicloTon = BigDecimal.ZERO;
        BigDecimal qtPerdasCicloUM = BigDecimal.ZERO;
        BigDecimal pesoBruto = BigDecimal.ZERO;
        BigDecimal valorUnitario = BigDecimal.ZERO;

        boolean isMaquinaNaLista = false;
        boolean isFerramentaNaLista = false;
        boolean isProdutoNaLista = false;

        detalhamento.setListaMaquinas(new ArrayList<GraficoBIParetoDetCiclosOrdemMaquinaDTO>());

        for (DwConsolid dwci : indicadores.getListaDwConsolId()) {
            // ciclo padr�o
            FolhaRN folhaRN = new FolhaRN(this.getDao());
            segCicloPadrao = BigDecimal.ZERO;

            // sem filtro de máquina ou com filtro e máquina selecionada igual
            // ao filtro
            if ((cdMaquina.equals("")) || (cdMaquina.equals(dwci.getOmPt().getCdPt()))) {
                // máquina
                itemMaquina = new GraficoBIParetoDetCiclosOrdemMaquinaDTO();
                itemMaquina.setCdMaquina(dwci.getOmPt().getCdPt());
                itemMaquina.setDsMaquina(dwci.getOmPt().getDsPt());
                itemMaquina.setFerramentas(new ArrayList<GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO>());
                itemMaquina.setQtdEmUB(0d);
                itemMaquina.setQtdEmUM(0d);
                itemMaquina.setQtdEmKg(0d);
                itemMaquina.setQtdEmTon(0d);
                itemMaquina.setSegCiclosProdutivos(0d);

                for (DwConsol dwc : dwci.getDwConsols()) {
                    segCicloPadrao = dwc.getSegAutoCiclopadrao();

                    // ciclos produtivos sem parada de varia��oo de ritmo
                    segTempoparadaCpVr = dwc.getSegAutoTempoparadaCpVr();
                    segTempoparadaCpVr = AritmeticaUtil.somar(segTempoparadaCpVr, dwc.getSegManuTempoparadaCpVr());

                    segTempoparadaSpVr = dwc.getSegAutoTempoparadaSpVr();
                    segTempoparadaSpVr = AritmeticaUtil.somar(segTempoparadaSpVr, dwc.getSegManuTempoparadaSpVr());

                    segCiclosProdutivos = AritmeticaUtil.somar(dwc.getSegAutoCicloprodutivo() != null ? dwc.getSegAutoCicloprodutivo()
                            : BigDecimal.ZERO, dwc.getSegManuCicloprodutivo() != null ? dwc.getSegManuCicloprodutivo() : BigDecimal.ZERO);

                    segTempoCiclosProdutivosSemParadasVariacaoRitmo = segCiclosProdutivos.subtract(segTempoparadaCpVr).subtract(
                            segTempoparadaSpVr);

                    qtCiclosProdutivos = AritmeticaUtil.somar(dwc.getQtAutoCicloprodutivo() != null ? dwc.getQtAutoCicloprodutivo()
                            : BigDecimal.ZERO, dwc.getQtManuCicloprodutivo() != null ? dwc.getQtManuCicloprodutivo() : BigDecimal.ZERO);

                    segRitmo = (dwc.getSegAutoRitmo() != null ? dwc.getSegAutoRitmo() : BigDecimal.ZERO);
                    segCicloMedio = FormulasInjet.calcularCicloMedio(segCiclosProdutivos, qtCiclosProdutivos);
                    segCiclosProdutivos = segTempoCiclosProdutivosSemParadasVariacaoRitmo;

                    // ferramenta
                    itemFerramenta = new GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO();
                    itemFerramenta.setCdFerramenta(dwci.getDwFolha().getCdFolha());
                    itemFerramenta.setDsFerramenta(dwci.getDwFolha().getDsFolha());
                    itemFerramenta.setProdutos(new ArrayList<GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO>());
                    itemFerramenta.setCicloPadrao(segCicloPadrao.doubleValue());
                    itemFerramenta.setQtdCiclosExecutados(qtCiclosProdutivos.doubleValue());
                    itemFerramenta.setSegCiclosProdutivos(segCiclosProdutivos.doubleValue());
                    itemFerramenta.setCicloMedio(segCicloMedio.doubleValue());
                    itemFerramenta.setQtdEmUB(0d);
                    itemFerramenta.setQtdEmUM(0d);
                    itemFerramenta.setQtdEmKg(0d);
                    itemFerramenta.setQtdEmTon(0d);

                    for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {

                        // sem filtro de produto ou com filtro e máquina
                        // selecionada igual ao filtro
                        if ((cdProduto.equals("")) || (cdProduto.equals(dwcpr.getOmProduto().getCdProduto()))) {
                            // pcs por ciclo
                            qtPcsCiclo = BigDecimal.ZERO;
                            try {
                                qtPcsCiclo = folhaRN.getPcsPorCicloAtivas(dwci.getDwFolha(), dwcpr.getOmProduto());
                            } catch (SemPcsPorCicloAtivasException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }

                            qtPerdasCiclo = FormulasInjet.calcularPcsPerdaciclo(segRitmo, segCicloPadrao, qtPcsCiclo);

                            // perdas em kg e ton
                            if (dwcpr.getOmProduto().getGPesoBruto() != null) {
                                pesoBruto = dwcpr.getOmProduto().getGPesoBruto();

                                // perdas em kg
                                qtPerdasCicloKg = qtPerdasCiclo.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));

                                // perdas em toneladas
                                qtPerdasCicloTon = qtPerdasCiclo.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000000));
                            } else {
                                qtPerdasCicloKg = BigDecimal.ZERO;
                                qtPerdasCicloTon = BigDecimal.ZERO;
                            }

                            // perdas em unidade monetária
                            if (dwcpr.getOmProduto().getVlCustounit() != null) {
                                valorUnitario = dwcpr.getOmProduto().getVlCustounit();
                            } else {
                                valorUnitario = BigDecimal.ZERO;
                            }

                            // valor
                            qtPerdasCicloUM = qtPerdasCiclo.multiply(valorUnitario);

                            // produto
                            itemProduto = new GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO();
                            itemProduto.setCdProduto(dwcpr.getOmProduto().getCdProduto());
                            itemProduto.setDsProduto(dwcpr.getOmProduto().getDsProduto());
                            itemProduto.setQtdEmUB(qtPerdasCiclo.doubleValue());
                            itemProduto.setQtdEmUM(qtPerdasCicloUM.doubleValue());
                            itemProduto.setQtdEmKg(qtPerdasCicloKg.doubleValue());
                            itemProduto.setQtdEmTon(qtPerdasCicloTon.doubleValue());
                            
                            // procura
                            isMaquinaNaLista = false;
                            for (GraficoBIParetoDetCiclosOrdemMaquinaDTO maquina : detalhamento.getListaMaquinas()) {
                                // máq está na lista?
                                if (maquina.getCdMaquina().equals(itemMaquina.getCdMaquina())) {
                                    isMaquinaNaLista = true;

                                    // ferramenta está na lista?
                                    isFerramentaNaLista = false;
                                    for (GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO ferramenta : maquina.getFerramentas()) {
                                        if ((ferramenta.getCdFerramenta().compareTo(itemFerramenta.getCdFerramenta()) == 0)
                                                && (ferramenta.getCicloPadrao().compareTo(itemFerramenta.getCicloPadrao()) == 0)) {
                                            isFerramentaNaLista = true;

                                            // acumula tempos e ciclo recalcula
                                            // ciclo médio
                                            ferramenta.setSegCiclosProdutivos(ferramenta.getSegCiclosProdutivos()
                                                    + itemFerramenta.getSegCiclosProdutivos());
                                            ferramenta.setQtdCiclosExecutados(ferramenta.getQtdCiclosExecutados()
                                                    + itemFerramenta.getQtdCiclosExecutados());
                                            ferramenta.setCicloMedio(FormulasInjet.calcularCicloMedio(
                                                    new BigDecimal(ferramenta.getSegCiclosProdutivos()),
                                                    new BigDecimal(ferramenta.getQtdCiclosExecutados())).doubleValue());

                                            // produto na lista?
                                            isProdutoNaLista = false;

                                            for (GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO produto : ferramenta
                                                    .getProdutos()) {
                                                if (produto.getCdProduto().equals(itemProduto.getCdProduto())) {
                                                    isProdutoNaLista = true;

                                                    // acumula perdas
                                                    produto.setQtdEmKg(produto.getQtdEmKg() + itemProduto.getQtdEmKg());
                                                    produto.setQtdEmTon(produto.getQtdEmTon() + itemProduto.getQtdEmTon());
                                                    produto.setQtdEmUM(produto.getQtdEmUM() + itemProduto.getQtdEmUM());
                                                    produto.setQtdEmUB(produto.getQtdEmUB() + itemProduto.getQtdEmUB());

                                                    
                                                    break;
                                                }
                                            }

                                            if (!isProdutoNaLista) {
                                                ferramenta.getProdutos().add(itemProduto);
                                            }
                                        }
                                    }

                                    if (!isFerramentaNaLista) {
                                        itemFerramenta.getProdutos().add(itemProduto);
                                        maquina.getFerramentas().add(itemFerramenta);
                                    }
                                }
                            }

                            if (!isMaquinaNaLista) {
                                // adiciona máq
                                itemFerramenta.getProdutos().add(itemProduto);
                                itemMaquina.getFerramentas().add(itemFerramenta);
                                detalhamento.getListaMaquinas().add(itemMaquina);
                            }
                        }
                    }
                }
            }
        }


        // Totalizar por produto independente de ferramenta, ciclo, et. Total será atribuído posteriormente no atibuto ResumoIndicadores
        Map<String, ResumoParetoPerdasDetCiclosDTO> mapTotalMaquina = new HashMap<String, ResumoParetoPerdasDetCiclosDTO>();

        
        // remover itens com tempo de ciclo produtivo zerado
        Double totalFerramenta = 0d;
        Double totalMaquina = 0d;
        Double segCicloPadraoMedio = 0d;
        Double segCicloMedioMedio = 0d;
        Integer qtdOcorr = 0;
        
        ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO listaAux = new ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO();
        listaAux.setListaMaquinas(new ArrayList<GraficoBIParetoDetCiclosOrdemMaquinaDTO>());
        listaAux.setResumoIndicadores(new ResumoParetoPerdasDetCiclosDTO());
        
        for (GraficoBIParetoDetCiclosOrdemMaquinaDTO maquina : detalhamento.getListaMaquinas()) {                     
            totalMaquina = 0d;            
            GraficoBIParetoDetCiclosOrdemMaquinaDTO maqAux = new GraficoBIParetoDetCiclosOrdemMaquinaDTO();
            maqAux.setFerramentas(new ArrayList<GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO>());
            maqAux.setCdMaquina(maquina.getCdMaquina());
            maqAux.setDsMaquina(maquina.getDsMaquina());
            maqAux.setQtdEmUB(0d);
            maqAux.setQtdEmUM(0d);
            maqAux.setQtdEmKg(0d);
            maqAux.setQtdEmTon(0d);
            
            for (GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO ferramenta : maquina.getFerramentas()) {
                totalFerramenta = 0d;
                GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO ferrAux = new GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO();
                ferrAux.setProdutos(new ArrayList<GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO>());
                ferrAux.setCdFerramenta(ferramenta.getCdFerramenta());
                ferrAux.setDsFerramenta(ferramenta.getDsFerramenta());
                ferrAux.setCicloMedio(ferramenta.getCicloMedio());
                ferrAux.setCicloPadrao(ferramenta.getCicloPadrao());
                ferrAux.setQtdCiclosExecutados(ferramenta.getQtdCiclosExecutados());
                ferrAux.setSegCiclosProdutivos(ferramenta.getSegCiclosProdutivos());
                
                if (ferramenta.getSegCiclosProdutivos() == 0d) {
                    //ignorar a ferramenta
                                        
                } else {
                    for (GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO produto : ferramenta.getProdutos()) {
                        totalFerramenta = totalFerramenta + produto.getQtdEmUB();
                        totalMaquina = totalMaquina + totalFerramenta;
                        ferrAux.getProdutos().add(produto);
                        
                        maqAux.setQtdEmUB(maqAux.getQtdEmUB() + produto.getQtdEmUB());
                        maqAux.setQtdEmUM(maqAux.getQtdEmUM() + produto.getQtdEmUM());
                        maqAux.setQtdEmKg(maqAux.getQtdEmKg() + produto.getQtdEmKg());
                        maqAux.setQtdEmTon(maqAux.getQtdEmTon() + produto.getQtdEmTon());
                                                
                        
                        ResumoParetoPerdasDetCiclosDTO resumoTotalMaquina = new ResumoParetoPerdasDetCiclosDTO();

                        if (isConsiderarPerda && produto.getQtdEmUB() != 0d) {
    	                	if (isConsiderarPerda && produto.getQtdEmUB() > 0d) {
    	                		resumoTotalMaquina.setPerdaUB(produto.getQtdEmUB());
    	                		resumoTotalMaquina.setPerdaUM(produto.getQtdEmUM());
    	                		resumoTotalMaquina.setPerdaKg(produto.getQtdEmKg());
    	                		resumoTotalMaquina.setPerdaTon(produto.getQtdEmTon());
    	                	}
    	
    	                	if (isConsiderarGanho && produto.getQtdEmUB() < 0d) {
    	                		resumoTotalMaquina.setGanhoUB(produto.getQtdEmUB());
    	                		resumoTotalMaquina.setGanhoUM(produto.getQtdEmUM());
    	                		resumoTotalMaquina.setGanhoKg(produto.getQtdEmKg());
    	                		resumoTotalMaquina.setGanhoTon(produto.getQtdEmTon());
    	                	}
    	                	
    	                	resumoTotalMaquina.setSaldoUB(resumoTotalMaquina.getPerdaUB() + resumoTotalMaquina.getGanhoUB());
    	                	resumoTotalMaquina.setSaldoUM(resumoTotalMaquina.getPerdaUM() + resumoTotalMaquina.getGanhoUM());
    	                	resumoTotalMaquina.setSaldoKg(resumoTotalMaquina.getPerdaKg() + resumoTotalMaquina.getGanhoKg());
    	                	resumoTotalMaquina.setSaldoTon(resumoTotalMaquina.getPerdaTon() + resumoTotalMaquina.getGanhoTon());
    		                
    		                if (!mapTotalMaquina.containsKey(maqAux.getCdMaquina())){
    		                	mapTotalMaquina.put(maqAux.getCdMaquina(), resumoTotalMaquina);                	
    		                } else {
    		                	ResumoParetoPerdasDetCiclosDTO itemMapTotal = new ResumoParetoPerdasDetCiclosDTO();
    		                	itemMapTotal = mapTotalMaquina.get(maqAux.getCdMaquina());
    	
    		                	itemMapTotal.setPerdaUB(itemMapTotal.getPerdaUB() + resumoTotalMaquina.getPerdaUB());
    		                	itemMapTotal.setPerdaUM(itemMapTotal.getPerdaUM() + resumoTotalMaquina.getPerdaUM());
    		                	itemMapTotal.setPerdaKg(itemMapTotal.getPerdaKg() + resumoTotalMaquina.getPerdaKg());
    		                	itemMapTotal.setPerdaTon(itemMapTotal.getPerdaTon() + resumoTotalMaquina.getPerdaTon());
    	
    		                	itemMapTotal.setGanhoUB(itemMapTotal.getGanhoUB() + resumoTotalMaquina.getGanhoUB());
    		                	itemMapTotal.setGanhoUM(itemMapTotal.getGanhoUM() + resumoTotalMaquina.getGanhoUM());
    		                	itemMapTotal.setGanhoKg(itemMapTotal.getGanhoKg() + resumoTotalMaquina.getGanhoKg());
    		                	itemMapTotal.setGanhoTon(itemMapTotal.getGanhoTon() + resumoTotalMaquina.getGanhoTon());
    	
    		                	itemMapTotal.setSaldoUB(itemMapTotal.getPerdaUB() + itemMapTotal.getGanhoUB());
    		                	itemMapTotal.setSaldoUM(itemMapTotal.getPerdaUM() + itemMapTotal.getGanhoUM());
    		                	itemMapTotal.setSaldoKg(itemMapTotal.getPerdaKg() + itemMapTotal.getGanhoKg());
    		                	itemMapTotal.setSaldoTon(itemMapTotal.getPerdaTon() + itemMapTotal.getGanhoTon());
    		                	
    		                	mapTotalMaquina.put(maqAux.getCdMaquina(), itemMapTotal);
    		                }
                        }
                        
                    }
                    
                    if (totalFerramenta == 0d || ferrAux.getProdutos().size() == 0){
                        // ignorar a ferramenta
                    } else {
                        qtdOcorr = qtdOcorr + 1;
                        segCicloPadraoMedio = segCicloPadraoMedio + ferramenta.getCicloPadrao();
                        segCicloMedioMedio = segCicloMedioMedio + ferramenta.getCicloMedio();
                        maqAux.getFerramentas().add(ferrAux);
                    }
                }                        
            }
            
            if (totalMaquina == 0d || maqAux.getFerramentas().size() == 0) {
                // ignorar a maquina
            } else {
                listaAux.getListaMaquinas().add(maqAux);
                
                // resumo indicadores                
                if (isConsiderarPerda && maqAux.getQtdEmUB() > 0) {
                    listaAux.getResumoIndicadores().setPerdaUB(listaAux.getResumoIndicadores().getPerdaUB() + maqAux.getQtdEmUB());
                    listaAux.getResumoIndicadores().setPerdaUM(listaAux.getResumoIndicadores().getPerdaUM() + maqAux.getQtdEmUM());
                    listaAux.getResumoIndicadores().setPerdaKg(listaAux.getResumoIndicadores().getPerdaKg() + maqAux.getQtdEmKg());
                    listaAux.getResumoIndicadores().setPerdaTon(listaAux.getResumoIndicadores().getPerdaTon() + maqAux.getQtdEmTon());
                }
                
                if (isConsiderarGanho && maqAux.getQtdEmUB() < 0) {
                    listaAux.getResumoIndicadores().setGanhoUB(listaAux.getResumoIndicadores().getGanhoUB() + (maqAux.getQtdEmUB() * -1));
                    listaAux.getResumoIndicadores().setGanhoUM(listaAux.getResumoIndicadores().getPerdaUM() + (maqAux.getQtdEmUM() * -1));
                    listaAux.getResumoIndicadores().setGanhoKg(listaAux.getResumoIndicadores().getPerdaKg() + (maqAux.getQtdEmKg() * -1));
                    listaAux.getResumoIndicadores().setGanhoTon(listaAux.getResumoIndicadores().getPerdaTon() + (maqAux.getQtdEmTon() * -1));
                }
                
                listaAux.getResumoIndicadores().setSaldoUB(listaAux.getResumoIndicadores().getPerdaUB() + listaAux.getResumoIndicadores().getGanhoUB());
                listaAux.getResumoIndicadores().setSaldoUM(listaAux.getResumoIndicadores().getPerdaUM() + listaAux.getResumoIndicadores().getGanhoUM());
                listaAux.getResumoIndicadores().setSaldoKg(listaAux.getResumoIndicadores().getPerdaKg() + listaAux.getResumoIndicadores().getGanhoKg());
                listaAux.getResumoIndicadores().setSaldoTon(listaAux.getResumoIndicadores().getPerdaTon() + listaAux.getResumoIndicadores().getGanhoTon());             
            }
            
        }

        // resumo indicadores - ciclo padrao, medio e efic cic
        if (qtdOcorr > 0) {
            segCicloMedioMedio = AritmeticaUtil.dividir(new BigDecimal(segCicloMedioMedio), new BigDecimal(qtdOcorr)).doubleValue();
            segCicloPadraoMedio = AritmeticaUtil.dividir(new BigDecimal(segCicloPadraoMedio), new BigDecimal(qtdOcorr)).doubleValue();

            
            if (!cdMaquina.equals("")){
            	listaAux.setResumoIndicadores(mapTotalMaquina.get(cdMaquina));
            }
            
            listaAux.getResumoIndicadores().setCicloMedio(segCicloMedioMedio);
            listaAux.getResumoIndicadores().setCicloPadrao(segCicloPadraoMedio);
            listaAux.getResumoIndicadores().setEfiCic(FormulasInjet.calcularEficienciaCiclo(new BigDecimal(listaAux.getResumoIndicadores().getCicloPadrao()), new BigDecimal(listaAux.getResumoIndicadores().getCicloMedio())).doubleValue());
        }
        
        detalhamento = new ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO();
        detalhamento = listaAux;
        
        
        // totalizar qtds e tempo produtivo
        for (GraficoBIParetoDetCiclosOrdemMaquinaDTO maquina : detalhamento.getListaMaquinas()) {
            maquina.setSegCiclosProdutivos(0d);
            maquina.setQtdEmUB(0d);
            maquina.setQtdEmUM(0d);
            maquina.setQtdEmKg(0d);
            maquina.setQtdEmTon(0d);

            for (GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO ferramenta : maquina.getFerramentas()) {
                ferramenta.setQtdEmUB(0d);
                ferramenta.setQtdEmUM(0d);
                ferramenta.setQtdEmKg(0d);
                ferramenta.setQtdEmTon(0d);

                for (GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO produto : ferramenta.getProdutos()) {
                    ferramenta.setQtdEmUB(ferramenta.getQtdEmUB() + produto.getQtdEmUB());
                    ferramenta.setQtdEmUM(ferramenta.getQtdEmUM() + produto.getQtdEmUM());
                    ferramenta.setQtdEmKg(ferramenta.getQtdEmKg() + produto.getQtdEmKg());
                    ferramenta.setQtdEmTon(ferramenta.getQtdEmTon() + produto.getQtdEmTon());
                }

                maquina.setSegCiclosProdutivos(maquina.getSegCiclosProdutivos() + ferramenta.getSegCiclosProdutivos());
                maquina.setQtdEmUB(maquina.getQtdEmUB() + ferramenta.getQtdEmUB());
                maquina.setQtdEmUM(maquina.getQtdEmUM() + ferramenta.getQtdEmUM());
                maquina.setQtdEmKg(maquina.getQtdEmKg() + ferramenta.getQtdEmKg());
                maquina.setQtdEmTon(maquina.getQtdEmTon() + ferramenta.getQtdEmTon());
            }
        }

        
        // ordenar ferramentas de cada máquina
        for (GraficoBIParetoDetCiclosOrdemMaquinaDTO maquina : detalhamento.getListaMaquinas()) {

            Collections.sort(maquina.getFerramentas(), new Comparator<GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO>() {
                @Override
                public int compare(final GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO o1,
                        final GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO o2) {
                    final GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO item1 = o1;
                    final GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO item2 = o2;
                    return (item1.getQtdEmUB()).compareTo(item2.getQtdEmUB()) * -1;
                }
            });

            // ordernar produtos de cada ferramenta
            for (GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO ferramenta : maquina.getFerramentas()) {
                Collections.sort(ferramenta.getProdutos(), new Comparator<GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO>() {
                    @Override
                    public int compare(final GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO o1,
                            final GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO o2) {
                        final GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO item1 = o1;
                        final GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO item2 = o2;
                        return (item1.getQtdEmUB()).compareTo(item2.getQtdEmUB()) * -1;
                    }
                });
            }

        }

        // ordenar lista de máquinas
        Collections.sort(detalhamento.getListaMaquinas(), new Comparator<GraficoBIParetoDetCiclosOrdemMaquinaDTO>() {
            @Override
            public int compare(final GraficoBIParetoDetCiclosOrdemMaquinaDTO o1, final GraficoBIParetoDetCiclosOrdemMaquinaDTO o2) {
                final GraficoBIParetoDetCiclosOrdemMaquinaDTO item1 = o1;
                final GraficoBIParetoDetCiclosOrdemMaquinaDTO item2 = o2;
                return (item1.getQtdEmUB()).compareTo(item2.getQtdEmUB()) * -1;
            }
        });

        return detalhamento;
    }

    /*
     * Método que retorna o detalhamento de perdas/ganhos por ciclo - ordena��oo de máquina, molde e produtos com maiores perdas
     */

    public ListaGraficoBIParetoDetCiclosOrdemProdutoDTO getDetalhamentoGraficoPerdasBICiclosOrdemProduto(
            DetalheMonitorizacaoPTInjetDTO indicadores, Byte ordemQtd, String cdMaquina, String cdProduto, Boolean isConsiderarPerda, Boolean isConsiderarGanho) {

        ListaGraficoBIParetoDetCiclosOrdemProdutoDTO detalhamento = new ListaGraficoBIParetoDetCiclosOrdemProdutoDTO();
        detalhamento.setResumoIndicadores(new ResumoParetoPerdasDetCiclosDTO());
        GraficoBIParetoDetCiclosOrdemProdutoDTO itemProduto = new GraficoBIParetoDetCiclosOrdemProdutoDTO();
        GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO itemFicTec = new GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO();

        BigDecimal segCicloPadrao = BigDecimal.ZERO;
        BigDecimal qtPcsCiclo = BigDecimal.ZERO;

        BigDecimal segCiclosProdutivos = BigDecimal.ZERO;
        BigDecimal segTempoCiclosProdutivosSemParadasVariacaoRitmo = BigDecimal.ZERO;
        BigDecimal segTempoparadaCpVr = BigDecimal.ZERO;
        BigDecimal segTempoparadaSpVr = BigDecimal.ZERO;

        BigDecimal qtCiclosProdutivos = BigDecimal.ZERO;
        BigDecimal segRitmo = BigDecimal.ZERO;
        BigDecimal qtPerdasCiclo = BigDecimal.ZERO;
        BigDecimal segCicloMedio = BigDecimal.ZERO;

        BigDecimal qtPerdasCicloKg = BigDecimal.ZERO;
        BigDecimal qtPerdasCicloTon = BigDecimal.ZERO;
        BigDecimal qtPerdasCicloUM = BigDecimal.ZERO;
        BigDecimal pesoBruto = BigDecimal.ZERO;

        boolean isFicTecNaLista = false;
        boolean isProdutoNaLista = false;

        detalhamento.setListaProdutos(new ArrayList<GraficoBIParetoDetCiclosOrdemProdutoDTO>());

        for (DwConsolid dwci : indicadores.getListaDwConsolId()) {
            // ciclo padr�o
            FolhaRN folhaRN = new FolhaRN(this.getDao());
            segCicloPadrao = BigDecimal.ZERO;

            // sem filtro de máquina ou com filtro e máquina selecionada igual
            // ao filtro
            if ((cdMaquina.equals("")) || (cdMaquina.equals(dwci.getOmPt().getCdPt()))) {
                for (DwConsol dwc : dwci.getDwConsols()) {
                    segCicloPadrao = dwc.getSegAutoCiclopadrao();

                    // ciclos produtivos sem parada de varia��oo de ritmo
                    segTempoparadaCpVr = dwc.getSegAutoTempoparadaCpVr();
                    segTempoparadaCpVr = AritmeticaUtil.somar(segTempoparadaCpVr, dwc.getSegManuTempoparadaCpVr());

                    segTempoparadaSpVr = dwc.getSegAutoTempoparadaSpVr();
                    segTempoparadaSpVr = AritmeticaUtil.somar(segTempoparadaSpVr, dwc.getSegManuTempoparadaSpVr());

                    qtCiclosProdutivos = AritmeticaUtil.somar(dwc.getQtAutoCicloprodutivo() != null ? dwc.getQtAutoCicloprodutivo()
                            : BigDecimal.ZERO, dwc.getQtManuCicloprodutivo() != null ? dwc.getQtManuCicloprodutivo() : BigDecimal.ZERO);

                    segCiclosProdutivos = AritmeticaUtil.somar(dwc.getSegAutoCicloprodutivo() != null ? dwc.getSegAutoCicloprodutivo()
                            : BigDecimal.ZERO, dwc.getSegManuCicloprodutivo() != null ? dwc.getSegManuCicloprodutivo() : BigDecimal.ZERO);

                    segTempoCiclosProdutivosSemParadasVariacaoRitmo = segCiclosProdutivos.subtract(segTempoparadaCpVr).subtract(
                            segTempoparadaSpVr);

                    segRitmo = (dwc.getSegAutoRitmo() != null ? dwc.getSegAutoRitmo() :BigDecimal.ZERO);
                    segCicloMedio = FormulasInjet.calcularCicloMedio(segCiclosProdutivos, qtCiclosProdutivos);
                    segCiclosProdutivos = segTempoCiclosProdutivosSemParadasVariacaoRitmo;

                    // ficha técnica
                    itemFicTec = new GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO();
                    itemFicTec.setCdMaquina(dwci.getOmPt().getCdPt());
                    itemFicTec.setDsMasquina(dwci.getOmPt().getDsPt());
                    itemFicTec.setCdFerramenta(dwci.getDwFolha().getCdFolha());
                    itemFicTec.setDsFerramenta(dwci.getDwFolha().getDsFolha());
                    itemFicTec.setCicloPadrao(segCicloPadrao.doubleValue());
                    itemFicTec.setQtdCiclosExecutados(qtCiclosProdutivos.doubleValue());
                    itemFicTec.setSegCiclosProdutivos(segCiclosProdutivos.doubleValue());
                    itemFicTec.setCicloMedio(segCicloMedio.doubleValue());
                    itemFicTec.setQtdEmUB(0d);
                    itemFicTec.setQtdEmUM(0d);
                    itemFicTec.setQtdEmKg(0d);
                    itemFicTec.setQtdEmTon(0d);

                    for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {

                        // sem filtro de produto ou com filtro e máquina
                        // selecionada igual ao filtro
                        if ((cdProduto.equals("")) || (cdProduto.equals(dwcpr.getOmProduto().getCdProduto()))) {
                            // pcs por ciclo
                            qtPcsCiclo = BigDecimal.ZERO;
                            try {
                                qtPcsCiclo = folhaRN.getPcsPorCicloAtivas(dwci.getDwFolha(), dwcpr.getOmProduto());
                            } catch (SemPcsPorCicloAtivasException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }

                            qtPerdasCiclo = FormulasInjet.calcularPcsPerdaciclo(segRitmo, segCicloPadrao, qtPcsCiclo);

                            // perdas em kg e ton
                            if (dwcpr.getOmProduto().getGPesoBruto() != null) {
                                pesoBruto = dwcpr.getOmProduto().getGPesoBruto();

                                // perdas em kg
                                qtPerdasCicloKg = qtPerdasCiclo.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));

                                // perdas em toneladas
                                qtPerdasCicloTon = qtPerdasCiclo.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000000));
                            } else {
                                qtPerdasCicloKg = BigDecimal.ZERO;
                                qtPerdasCicloTon = BigDecimal.ZERO;
                            }

                            // perdas em unidade monetária
                            if (dwcpr.getOmProduto().getVlCustounit() != null) {
                                qtPerdasCicloUM = qtPerdasCiclo.multiply(dwcpr.getOmProduto().getVlCustounit());
                            } else {
                                qtPerdasCicloUM = BigDecimal.ZERO;
                            }

                            // produto
                            itemProduto = new GraficoBIParetoDetCiclosOrdemProdutoDTO();
                            itemProduto.setCdProduto(dwcpr.getOmProduto().getCdProduto());
                            itemProduto.setDsProduto(dwcpr.getOmProduto().getDsProduto());
                            itemProduto.setFictec(new ArrayList<GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO>());
                            itemProduto.setQtdEmUB(0d);
                            itemProduto.setQtdEmUM(0d);
                            itemProduto.setQtdEmKg(0d);
                            itemProduto.setQtdEmTon(0d);
                            itemProduto.setQtdCiclosExecutados(0d);
                            itemProduto.setSegCiclosProdutivos(0d);

                            // complemento das informações da ficha técnica
                            itemFicTec.setQtdEmUB(qtPerdasCiclo.doubleValue());
                            itemFicTec.setQtdEmUM(qtPerdasCicloUM.doubleValue());
                            itemFicTec.setQtdEmKg(qtPerdasCicloKg.doubleValue());
                            itemFicTec.setQtdEmTon(qtPerdasCicloTon.doubleValue());                            

                            // procura
                            isProdutoNaLista = false;
                            for (GraficoBIParetoDetCiclosOrdemProdutoDTO produto : detalhamento.getListaProdutos()) {
                                // produto está na lista?
                                if (produto.getCdProduto().equals(itemProduto.getCdProduto())) {
                                    isProdutoNaLista = true;

                                    // ficha técnica está na lista?
                                    isFicTecNaLista = false;
                                    for (GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO fichatecnica : produto.getFictec()) {

                                        if ((fichatecnica.getCdMaquina().compareTo(itemFicTec.getCdMaquina()) == 0)
                                                && (fichatecnica.getCdFerramenta().compareTo(itemFicTec.getCdFerramenta()) == 0)
                                                && (fichatecnica.getCicloPadrao().compareTo(itemFicTec.getCicloPadrao()) == 0)) {
                                            isFicTecNaLista = true;

                                            // acumula tempos e ciclo recalcula
                                            // ciclo médio
                                            fichatecnica.setSegCiclosProdutivos(fichatecnica.getSegCiclosProdutivos()
                                                    + itemFicTec.getSegCiclosProdutivos());
                                            fichatecnica.setQtdCiclosExecutados(fichatecnica.getQtdCiclosExecutados()
                                                    + itemFicTec.getQtdCiclosExecutados());
                                            fichatecnica.setCicloMedio(FormulasInjet.calcularCicloMedio(
                                                    new BigDecimal(fichatecnica.getSegCiclosProdutivos()),
                                                    new BigDecimal(fichatecnica.getQtdCiclosExecutados())).doubleValue());
                                            fichatecnica.setQtdEmKg(fichatecnica.getQtdEmKg() + itemFicTec.getQtdEmKg());
                                            fichatecnica.setQtdEmTon(fichatecnica.getQtdEmTon() + itemFicTec.getQtdEmTon());
                                            fichatecnica.setQtdEmUM(fichatecnica.getQtdEmUM() + itemFicTec.getQtdEmUM());
                                            fichatecnica.setQtdEmUB(fichatecnica.getQtdEmUB() + itemFicTec.getQtdEmUB());

                                            break;
                                        }

                                    }

                                    if (!isFicTecNaLista) {
                                        // adiciona fictec
                                        produto.getFictec().add(itemFicTec);
                                    }
                                }
                            }

                            if (!isProdutoNaLista) {
                                // adiciona produto
                                itemProduto.getFictec().add(itemFicTec);
                                detalhamento.getListaProdutos().add(itemProduto);
                            }
                        }
                    }
                }
            }
        }
        
        
        // Totalizar por produto independente de ferramenta, ciclo, et. Total será atribuído posteriormente no atibuto ResumoIndicadores
        Map<String, ResumoParetoPerdasDetCiclosDTO> mapTotalProduto = new HashMap<String, ResumoParetoPerdasDetCiclosDTO>();
        
        // remover itens com tempo de ciclo produtivo zerado
        Double totalProduto = 0d;
        Double totalFicTec = 0d;
        Double segCicloPadraoMedio = 0d;
        Double segCicloMedioMedio = 0d;
        Integer qtdOcorr = 0;
        
        ListaGraficoBIParetoDetCiclosOrdemProdutoDTO listaAux = new ListaGraficoBIParetoDetCiclosOrdemProdutoDTO();
        listaAux.setListaProdutos(new ArrayList<GraficoBIParetoDetCiclosOrdemProdutoDTO>());
        listaAux.setResumoIndicadores(new ResumoParetoPerdasDetCiclosDTO());
        
        for (GraficoBIParetoDetCiclosOrdemProdutoDTO produto : detalhamento.getListaProdutos()) {
            totalProduto = 0d;
            GraficoBIParetoDetCiclosOrdemProdutoDTO prodAux = new GraficoBIParetoDetCiclosOrdemProdutoDTO();
            prodAux.setCdProduto(produto.getCdProduto());
            prodAux.setDsProduto(produto.getDsProduto());
            prodAux.setFictec(new ArrayList<GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO>());
            prodAux.setQtdEmKg(0d);
            prodAux.setQtdEmTon(0d);
            prodAux.setQtdEmUB(0d);
            prodAux.setQtdEmUM(0d);
            prodAux.setSegCiclosProdutivos(0d);
            prodAux.setQtdCiclosExecutados(0d);
            
            for (GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO ficTec : produto.getFictec()) {
                totalFicTec = 0d;                
                GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO ficTecAux = new GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO();
                ficTecAux.setCdFerramenta(ficTec.getCdFerramenta());
                ficTecAux.setDsFerramenta(ficTec.getDsFerramenta());
                ficTecAux.setCicloPadrao(ficTec.getCicloPadrao());
                ficTecAux.setCicloMedio(ficTec.getCicloMedio());
                ficTecAux.setCdMaquina(ficTec.getCdMaquina());
                ficTecAux.setDsMasquina(ficTec.getDsMasquina());
                ficTecAux.setQtdCiclosExecutados(ficTec.getQtdCiclosExecutados());
                ficTecAux.setQtdEmKg(ficTec.getQtdEmKg());
                ficTecAux.setQtdEmTon(ficTec.getQtdEmTon());
                ficTecAux.setQtdEmUB(ficTec.getQtdEmUB());
                ficTecAux.setQtdEmUM(ficTec.getQtdEmUM());
                ficTecAux.setSegCiclosProdutivos(ficTec.getSegCiclosProdutivos());
                
                prodAux.setQtdEmKg(prodAux.getQtdEmKg() + ficTecAux.getQtdEmKg());
                prodAux.setQtdEmTon(prodAux.getQtdEmTon() + ficTecAux.getQtdEmTon());
                prodAux.setQtdEmUB(prodAux.getQtdEmUB() + ficTecAux.getQtdEmUB());
                prodAux.setQtdEmUM(prodAux.getQtdEmUM() + ficTecAux.getQtdEmUM());

                qtdOcorr = qtdOcorr + 1;
                segCicloPadraoMedio = segCicloPadraoMedio + ficTec.getCicloPadrao();
                segCicloMedioMedio = segCicloMedioMedio + ficTec.getCicloMedio();
                
                if (ficTec.getSegCiclosProdutivos() != 0d ){
                    totalFicTec = totalFicTec + ficTec.getQtdEmUB();
                    totalProduto = totalProduto  + ficTec.getQtdEmUB();
                    prodAux.getFictec().add(ficTecAux);
                    
                    
                    ResumoParetoPerdasDetCiclosDTO resumoTotalProduto = new ResumoParetoPerdasDetCiclosDTO();

                    if (isConsiderarPerda && ficTec.getQtdEmUB() != 0d) {
	                	if (isConsiderarPerda && ficTec.getQtdEmUB() > 0d) {
			                resumoTotalProduto.setPerdaUB(ficTec.getQtdEmUB());
			                resumoTotalProduto.setPerdaUM(ficTec.getQtdEmUM());
			                resumoTotalProduto.setPerdaKg(ficTec.getQtdEmKg());
			                resumoTotalProduto.setPerdaTon(ficTec.getQtdEmTon());
	                	}
	
	                	if (isConsiderarGanho && ficTec.getQtdEmUB() < 0d) {
			                resumoTotalProduto.setGanhoUB(ficTec.getQtdEmUB());
			                resumoTotalProduto.setGanhoUM(ficTec.getQtdEmUM());
			                resumoTotalProduto.setGanhoKg(ficTec.getQtdEmKg());
			                resumoTotalProduto.setGanhoTon(ficTec.getQtdEmTon());
	                	}
	                	
		                resumoTotalProduto.setSaldoUB(resumoTotalProduto.getPerdaUB() + resumoTotalProduto.getGanhoUB());
		                resumoTotalProduto.setSaldoUM(resumoTotalProduto.getPerdaUM() + resumoTotalProduto.getGanhoUM());
		                resumoTotalProduto.setSaldoKg(resumoTotalProduto.getPerdaKg() + resumoTotalProduto.getGanhoKg());
		                resumoTotalProduto.setSaldoTon(resumoTotalProduto.getPerdaTon() + resumoTotalProduto.getGanhoTon());
		                
		                if (!mapTotalProduto.containsKey(prodAux.getCdProduto())){
		                	mapTotalProduto.put(prodAux.getCdProduto(), resumoTotalProduto);                	
		                } else {
		                	ResumoParetoPerdasDetCiclosDTO itemMapTotal = new ResumoParetoPerdasDetCiclosDTO();
		                	itemMapTotal = mapTotalProduto.get(prodAux.getCdProduto());
	
		                	itemMapTotal.setPerdaUB(itemMapTotal.getPerdaUB() + resumoTotalProduto.getPerdaUB());
		                	itemMapTotal.setPerdaUM(itemMapTotal.getPerdaUM() + resumoTotalProduto.getPerdaUM());
		                	itemMapTotal.setPerdaKg(itemMapTotal.getPerdaKg() + resumoTotalProduto.getPerdaKg());
		                	itemMapTotal.setPerdaTon(itemMapTotal.getPerdaTon() + resumoTotalProduto.getPerdaTon());
	
		                	itemMapTotal.setGanhoUB(itemMapTotal.getGanhoUB() + resumoTotalProduto.getGanhoUB());
		                	itemMapTotal.setGanhoUM(itemMapTotal.getGanhoUM() + resumoTotalProduto.getGanhoUM());
		                	itemMapTotal.setGanhoKg(itemMapTotal.getGanhoKg() + resumoTotalProduto.getGanhoKg());
		                	itemMapTotal.setGanhoTon(itemMapTotal.getGanhoTon() + resumoTotalProduto.getGanhoTon());
	
		                	itemMapTotal.setSaldoUB(itemMapTotal.getPerdaUB() + itemMapTotal.getGanhoUB());
		                	itemMapTotal.setSaldoUM(itemMapTotal.getPerdaUM() + itemMapTotal.getGanhoUM());
		                	itemMapTotal.setSaldoKg(itemMapTotal.getPerdaKg() + itemMapTotal.getGanhoKg());
		                	itemMapTotal.setSaldoTon(itemMapTotal.getPerdaTon() + itemMapTotal.getGanhoTon());
		                	
		                	mapTotalProduto.put(prodAux.getCdProduto(), itemMapTotal);
		                }
                    }	                
                }                        
            }
            
            if (totalProduto == 0d || prodAux.getFictec().size() == 0) {
                // ignorar a maquina
            } else {
                listaAux.getListaProdutos().add(prodAux);
                
                if (isConsiderarPerda && prodAux.getQtdEmUB() > 0) {
	                listaAux.getResumoIndicadores().setPerdaUB(listaAux.getResumoIndicadores().getPerdaUB() + prodAux.getQtdEmUB());
	                listaAux.getResumoIndicadores().setPerdaUM(listaAux.getResumoIndicadores().getPerdaUM() + prodAux.getQtdEmUM());
	                listaAux.getResumoIndicadores().setPerdaKg(listaAux.getResumoIndicadores().getPerdaKg() + prodAux.getQtdEmKg());
	                listaAux.getResumoIndicadores().setPerdaTon(listaAux.getResumoIndicadores().getPerdaTon() + prodAux.getQtdEmTon());
                }
                
                if (isConsiderarGanho && prodAux.getQtdEmUB() < 0) {
	                listaAux.getResumoIndicadores().setGanhoUB(listaAux.getResumoIndicadores().getGanhoUB() + (prodAux.getQtdEmUB() * -1));
	                listaAux.getResumoIndicadores().setGanhoUM(listaAux.getResumoIndicadores().getPerdaUM() + prodAux.getQtdEmUM());
	                listaAux.getResumoIndicadores().setGanhoKg(listaAux.getResumoIndicadores().getPerdaKg() + (prodAux.getQtdEmKg() * -1));
	                listaAux.getResumoIndicadores().setGanhoTon(listaAux.getResumoIndicadores().getPerdaTon() + (prodAux.getQtdEmTon() * -1));
                }
                
                listaAux.getResumoIndicadores().setSaldoUB(listaAux.getResumoIndicadores().getPerdaUB() + listaAux.getResumoIndicadores().getGanhoUB());
                listaAux.getResumoIndicadores().setSaldoUM(listaAux.getResumoIndicadores().getPerdaUM() + listaAux.getResumoIndicadores().getGanhoUM());
                listaAux.getResumoIndicadores().setSaldoKg(listaAux.getResumoIndicadores().getPerdaKg() + listaAux.getResumoIndicadores().getGanhoKg());
                listaAux.getResumoIndicadores().setSaldoTon(listaAux.getResumoIndicadores().getPerdaTon() + listaAux.getResumoIndicadores().getGanhoTon());
                
            }            
        }

        // resumo indicadores - ciclo padrao, medio e efic cic
        if (qtdOcorr > 0) {
            segCicloMedioMedio = AritmeticaUtil.dividir(new BigDecimal(segCicloMedioMedio), new BigDecimal(qtdOcorr)).doubleValue();
            segCicloPadraoMedio = AritmeticaUtil.dividir(new BigDecimal(segCicloPadraoMedio), new BigDecimal(qtdOcorr)).doubleValue();

            if (!cdProduto.equals("")){
            	listaAux.setResumoIndicadores(mapTotalProduto.get(cdProduto));
            }
            
            listaAux.getResumoIndicadores().setCicloMedio(segCicloMedioMedio);
            listaAux.getResumoIndicadores().setCicloPadrao(segCicloPadraoMedio);
            listaAux.getResumoIndicadores().setEfiCic(FormulasInjet.calcularEficienciaCiclo(new BigDecimal(listaAux.getResumoIndicadores().getCicloPadrao()), new BigDecimal(listaAux.getResumoIndicadores().getCicloMedio())).doubleValue());
            
        }
        
        detalhamento = new ListaGraficoBIParetoDetCiclosOrdemProdutoDTO();
        detalhamento = listaAux;
        

        // totalizar qtds e tempo produtivo
        for (GraficoBIParetoDetCiclosOrdemProdutoDTO produto : detalhamento.getListaProdutos()) {
            produto.setQtdEmUB(0d);
            produto.setQtdEmUM(0d);
            produto.setQtdEmKg(0d);
            produto.setQtdEmTon(0d);

            for (GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO fictec : produto.getFictec()) {
                produto.setQtdEmUB(produto.getQtdEmUB() + fictec.getQtdEmUB());
                produto.setQtdEmUM(produto.getQtdEmUM() + fictec.getQtdEmUM());
                produto.setQtdEmKg(produto.getQtdEmKg() + fictec.getQtdEmKg());
                produto.setQtdEmTon(produto.getQtdEmTon() + fictec.getQtdEmTon());
                produto.setQtdCiclosExecutados(produto.getQtdCiclosExecutados() + fictec.getQtdCiclosExecutados());
                produto.setSegCiclosProdutivos(produto.getSegCiclosProdutivos() + fictec.getSegCiclosProdutivos());
            }
        }

        // ordenar fictecs do produto
        for (GraficoBIParetoDetCiclosOrdemProdutoDTO produto : detalhamento.getListaProdutos()) {

            if (ordemQtd.equals(ORDEM_UB)) {
                Collections.sort(produto.getFictec(), new Comparator<GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO>() {
                    @Override
                    public int compare(final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO o1,
                            final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO o2) {
                        final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO item1 = o1;
                        final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO item2 = o2;
                        return (item1.getQtdEmUB()).compareTo(item2.getQtdEmUB()) * -1;
                    }
                });
            }

            if (ordemQtd.equals(ORDEM_PESO)) {
                Collections.sort(produto.getFictec(), new Comparator<GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO>() {
                    @Override
                    public int compare(final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO o1,
                            final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO o2) {
                        final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO item1 = o1;
                        final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO item2 = o2;
                        return (item1.getQtdEmKg()).compareTo(item2.getQtdEmKg()) * -1;
                    }
                });
            }

            if (ordemQtd.equals(ORDEM_UM)) {
                Collections.sort(produto.getFictec(), new Comparator<GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO>() {
                    @Override
                    public int compare(final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO o1,
                            final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO o2) {
                        final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO item1 = o1;
                        final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO item2 = o2;
                        return (item1.getQtdEmUM()).compareTo(item2.getQtdEmUM()) * -1;
                    }
                });
            }

        }

        // ordenar lista de produtos
        if (ordemQtd.equals(ORDEM_UB)) {
            Collections.sort(detalhamento.getListaProdutos(), new Comparator<GraficoBIParetoDetCiclosOrdemProdutoDTO>() {
                @Override
                public int compare(final GraficoBIParetoDetCiclosOrdemProdutoDTO o1, final GraficoBIParetoDetCiclosOrdemProdutoDTO o2) {
                    final GraficoBIParetoDetCiclosOrdemProdutoDTO item1 = o1;
                    final GraficoBIParetoDetCiclosOrdemProdutoDTO item2 = o2;
                    return (item1.getQtdEmUB()).compareTo(item2.getQtdEmUB()) * -1;
                }
            });

        }

        if (ordemQtd.equals(ORDEM_PESO)) {
            Collections.sort(detalhamento.getListaProdutos(), new Comparator<GraficoBIParetoDetCiclosOrdemProdutoDTO>() {
                @Override
                public int compare(final GraficoBIParetoDetCiclosOrdemProdutoDTO o1, final GraficoBIParetoDetCiclosOrdemProdutoDTO o2) {
                    final GraficoBIParetoDetCiclosOrdemProdutoDTO item1 = o1;
                    final GraficoBIParetoDetCiclosOrdemProdutoDTO item2 = o2;
                    return (item1.getQtdEmKg()).compareTo(item2.getQtdEmKg()) * -1;
                }
            });

        }

        if (ordemQtd.equals(ORDEM_UM)) {
            Collections.sort(detalhamento.getListaProdutos(), new Comparator<GraficoBIParetoDetCiclosOrdemProdutoDTO>() {
                @Override
                public int compare(final GraficoBIParetoDetCiclosOrdemProdutoDTO o1, final GraficoBIParetoDetCiclosOrdemProdutoDTO o2) {
                    final GraficoBIParetoDetCiclosOrdemProdutoDTO item1 = o1;
                    final GraficoBIParetoDetCiclosOrdemProdutoDTO item2 = o2;
                    return (item1.getQtdEmUM()).compareTo(item2.getQtdEmUM()) * -1;
                }
            });

        }

        return detalhamento;
    }

    /*
     * Método que retorna o detalhamento de perdas/ganhos de todas as perdas
     */

    public ListaGraficoBIParetoDetTodasDTO getDetalhamentoGraficoPerdasBITodasOrdemProduto(DetalheMonitorizacaoPTInjetDTO indicadores,
            Byte ordemQtd, String cdMaquina, String cdProduto, Boolean isConsiderarPerda, Boolean isConsiderarGanho) {
        final Byte ORDEM_UB = 1;
        final Byte ORDEM_PESO = 2;
        final Byte ORDEM_UM = 3;

        ListaGraficoBIParetoDetTodasDTO detalhamento = new ListaGraficoBIParetoDetTodasDTO();
        detalhamento.setResumoIndicadores(new ResumoParetoPerdasDetTodasDTO());
        GraficoBIParetoDetTodasDTO itemProduto = new GraficoBIParetoDetTodasDTO();

        BigDecimal segCicloPadrao = BigDecimal.ZERO;
        BigDecimal qtPcsCiclo = BigDecimal.ZERO;
        BigDecimal qtPcsCicloTotal = BigDecimal.ZERO;
        
        BigDecimal fatorContagem = BigDecimal.ONE;

        BigDecimal segCiclosProdutivos = BigDecimal.ZERO;
        BigDecimal segTempoCiclosProdutivosSemParadasVariacaoRitmo = BigDecimal.ZERO;
        BigDecimal segTempoparadaCpVr = BigDecimal.ZERO;
        BigDecimal segTempoparadaSpVr = BigDecimal.ZERO;

        BigDecimal segTempoAtivoAuto = BigDecimal.ZERO;
        BigDecimal segTempoAtivoManual = BigDecimal.ZERO;
        BigDecimal segTempoAtivo = BigDecimal.ZERO;

        BigDecimal qtCiclosProdutivos = BigDecimal.ZERO;
        BigDecimal segRitmo = BigDecimal.ZERO;

        BigDecimal qtPerdasCiclo = BigDecimal.ZERO;
        BigDecimal qtPerdasCicloKg = BigDecimal.ZERO;
        BigDecimal qtPerdasCicloTon = BigDecimal.ZERO;
        BigDecimal qtPerdasCicloUM = BigDecimal.ZERO;

        BigDecimal pesoBruto = BigDecimal.ZERO;
        BigDecimal valorUnitario = BigDecimal.ZERO;

        BigDecimal segTempoParCP = BigDecimal.ZERO;
        BigDecimal qtPerdasPar = BigDecimal.ZERO;
        BigDecimal qtPerdasParKg = BigDecimal.ZERO;
        BigDecimal qtPerdasParTon = BigDecimal.ZERO;
        BigDecimal qtPerdasParUM = BigDecimal.ZERO;

        BigDecimal qtPerdasPCI = BigDecimal.ZERO;
        BigDecimal qtPerdasPCIKg = BigDecimal.ZERO;
        BigDecimal qtPerdasPCITon = BigDecimal.ZERO;
        BigDecimal qtPerdasPCIUM = BigDecimal.ZERO;

        BigDecimal qtPrevista = BigDecimal.ZERO;
        BigDecimal qtPrevistaKg = BigDecimal.ZERO;
        BigDecimal qtPrevistaTon = BigDecimal.ZERO;

        BigDecimal qtBruta = BigDecimal.ZERO;
        BigDecimal qtRef = BigDecimal.ZERO;
        BigDecimal qtRefKg = BigDecimal.ZERO;
        BigDecimal qtRefTon = BigDecimal.ZERO;
        BigDecimal qtRefUM = BigDecimal.ZERO;

        BigDecimal qtBoas = BigDecimal.ZERO;
        BigDecimal qtBoasKg = BigDecimal.ZERO;
        BigDecimal qtBoasTon = BigDecimal.ZERO;

        BigDecimal efiRea = BigDecimal.ZERO;

        boolean isProdutoNaLista = false;

        detalhamento.setListaProdutos(new ArrayList<GraficoBIParetoDetTodasDTO>());

        
        for (DwConsolid dwci : indicadores.getListaDwConsolId()) {
            // ciclo padr�o
            FolhaRN folhaRN = new FolhaRN(this.getDao());
            segCicloPadrao = BigDecimal.ZERO;

            // sem filtro de máquina ou com filtro e máquina selecionada igual
            // ao filtro
            if ((cdMaquina.equals("")) || (cdMaquina.equals(dwci.getOmPt().getCdPt()))) {
                for (DwConsol dwc : dwci.getDwConsols()) {
                    segCicloPadrao = dwc.getSegAutoCiclopadrao();

                    // ciclos produtivos sem parada de varia��oo de ritmo
                    segTempoparadaCpVr = dwc.getSegAutoTempoparadaCpVr();
                    segTempoparadaCpVr = AritmeticaUtil.somar(segTempoparadaCpVr, dwc.getSegManuTempoparadaCpVr());

                    segTempoparadaSpVr = dwc.getSegAutoTempoparadaSpVr();
                    segTempoparadaSpVr = AritmeticaUtil.somar(segTempoparadaSpVr, dwc.getSegManuTempoparadaSpVr());

                    segCiclosProdutivos = AritmeticaUtil.somar(dwc.getSegAutoCicloprodutivo() != null ? dwc.getSegAutoCicloprodutivo()
                            : BigDecimal.ZERO, dwc.getSegManuCicloprodutivo() != null ? dwc.getSegManuCicloprodutivo() : BigDecimal.ZERO);

                    segTempoCiclosProdutivosSemParadasVariacaoRitmo = segCiclosProdutivos.subtract(segTempoparadaCpVr).subtract(
                            segTempoparadaSpVr);

                    qtCiclosProdutivos = AritmeticaUtil.somar(dwc.getQtAutoCicloprodutivo() != null ? dwc.getQtAutoCicloprodutivo()
                            : BigDecimal.ZERO, dwc.getQtManuCicloprodutivo() != null ? dwc.getQtManuCicloprodutivo() : BigDecimal.ZERO);

                    segRitmo = (dwc.getSegAutoRitmo() != null ? dwc.getSegAutoRitmo() :BigDecimal.ZERO);

                    segCiclosProdutivos = segTempoCiclosProdutivosSemParadasVariacaoRitmo;

                    // temnpo ativo
                    segTempoAtivoAuto = FormulasInjet.calcularTempoAtivo(dwc.getSegAutoCicloprodutivo(), dwc.getSegAutoTempoparadaCp(),
                            dwc.getSegAutoCicloimprodutivo(), dwc.getSegAutoTempoparadaCpVr(), dwc.getSegAutoTempoparadaSpVr());

                    segTempoAtivoManual = FormulasInjet.calcularTempoAtivo(dwc.getSegManuCicloprodutivo(), dwc.getSegManuTempoparadaCp(),
                            dwc.getSegManuCicloimprodutivo(), dwc.getSegManuTempoparadaCpVr(), dwc.getSegManuTempoparadaSpVr());

                    segTempoAtivo = AritmeticaUtil.somar(segTempoAtivoAuto, segTempoAtivoManual);

                    // lista de paradas
                    segTempoParCP = BigDecimal.ZERO;
                    segTempoParCP = AritmeticaUtil.somar(dwc.getSegAutoTempoparadaCp() != null ? dwc.getSegAutoTempoparadaCp()
                            : BigDecimal.ZERO, dwc.getSegManuTempoparadaCp() != null ? dwc.getSegManuTempoparadaCp() : BigDecimal.ZERO);


                    for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {
                        // sem filtro de produto ou com filtro e máquina
                        // selecionada igual ao filtro
                        if ((cdProduto.equals("")) || (cdProduto.equals(dwcpr.getOmProduto().getCdProduto()))) {

                            // pcs por ciclo ativas
                            qtPcsCiclo = BigDecimal.ZERO;
                            try {
                                qtPcsCiclo = folhaRN.getPcsPorCicloAtivas(dwci.getDwFolha(), dwcpr.getOmProduto());
                            } catch (SemPcsPorCicloAtivasException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            
                            try {
								fatorContagem = folhaRN.getFatorContagemFromDwFolha(dwci.getDwFolha(), dwci.getOmPt());
							} catch (SemPacoteOuFatorException e1) {
								fatorContagem = BigDecimal.ONE;
							}

                            // pcs por ciclo totais
                            qtPcsCicloTotal = BigDecimal.ZERO;
                            try {
                                qtPcsCicloTotal = folhaRN.getPcsPorCicloTodas(dwci.getDwFolha(), dwcpr.getOmProduto());
                            } catch (SemPcsPorCicloAtivasException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }

                            // peso
                            if (dwcpr.getOmProduto().getGPesoBruto() != null) {
                                pesoBruto = dwcpr.getOmProduto().getGPesoBruto();
                            } else {
                                pesoBruto = BigDecimal.ZERO;
                            }

                            // custo
                            if (dwcpr.getOmProduto().getVlCustounit() != null) {
                                valorUnitario = dwcpr.getOmProduto().getVlCustounit();
                            } else {
                                valorUnitario = BigDecimal.ZERO;
                            }

                            // perdas ciclo
                            qtPerdasCiclo = new BigDecimal(FormulasInjet.calcularPcsPerdaciclo(segRitmo, segCicloPadrao, qtPcsCiclo)
                                    .doubleValue());

                            // perdas em kg
                            qtPerdasCicloKg = qtPerdasCiclo.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));

                            // perdas em toneladas
                            qtPerdasCicloTon = qtPerdasCiclo.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000000));

                            // perdas em unidade monetária
                            qtPerdasCicloUM = qtPerdasCiclo.multiply(valorUnitario);

                            // perdas por parada
                            qtPerdasPar = FormulasInjet.calcularPcsPerdaParada(segTempoParCP, segCicloPadrao, qtPcsCiclo);

                            // perdas por parada em kg
                            qtPerdasParKg = qtPerdasPar.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));

                            // perdas por parada em toneladas
                            qtPerdasParTon = qtPerdasPar.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000000));

                            // valor
                            qtPerdasParUM = qtPerdasPar.multiply(valorUnitario);
                            
                            // perdas por pcs/ciclo inativas
                            qtPerdasPCI = FormulasInjet.calcularPerdaCavidade(qtCiclosProdutivos, qtPcsCicloTotal, qtPcsCiclo);

                            // perdas por pcs/ciclo inativas em kg
                            qtPerdasParKg = qtPerdasPCI.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));

                            // perdas por pcs/ciclo inativas em toneladas
                            qtPerdasParTon = qtPerdasPCI.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000000));

                            // valor
                            qtPerdasPCIUM = qtPerdasPCI.multiply(valorUnitario);

                            // produ��oo bruta, refugada e boa
                            qtBruta = AritmeticaUtil.somar(
                                    dwcpr.getPcsAutoProducaobruta() != null ? dwcpr.getPcsAutoProducaobruta()
                                            : BigDecimal.ZERO,
                                    dwcpr.getPcsManuProducaobruta() != null ? dwcpr.getPcsManuProducaobruta()
                                            : BigDecimal.ZERO);

                            qtRef = AritmeticaUtil.somar(
                                    dwcpr.getPcsAutoProducaorefugada() != null ? dwcpr.getPcsAutoProducaorefugada()
                                            : BigDecimal.ZERO,
                                    dwcpr.getPcsManuProducaorefugada() != null ? dwcpr.getPcsManuProducaorefugada()
                                            : BigDecimal.ZERO);

                            qtBoas = AritmeticaUtil.diminuir(qtBruta, qtRef);

                            // em peso
                            qtRefKg = qtRef.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));
                            qtRefTon = qtRef.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));
                            // valor
                            qtRefUM = qtRef.multiply(valorUnitario);

                            // qtd prevista
                            qtPrevista = FormulasInjet.calcularProducaoPrevista(
                            		segTempoAtivo, 
                            		segCicloPadrao, 
                            		qtPcsCiclo,
                            		fatorContagem,
                            		dwci.getOmPt().getIndOee());

                            // produ��oo boa e prevista em peso
                            qtBoasKg = qtBoas.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));
                            qtBoasTon = qtBoas.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000000));
                            qtPrevistaKg = qtPrevista.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));
                            qtPrevistaTon = qtPrevista.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000000));

                            // efi realizacao
                            efiRea = new BigDecimal(FormulasInjet.calcularEficienciaRealizacao(qtBoas, qtPrevista));

                            // produto
                            itemProduto = new GraficoBIParetoDetTodasDTO();
                            itemProduto.setCdProduto(dwcpr.getOmProduto().getCdProduto());
                            itemProduto.setDsProduto(dwcpr.getOmProduto().getDsProduto());

                            itemProduto.setQtdPerdaEmUB(FormulasInjet.calcularTotalPerdas(qtPerdasCiclo.doubleValue(), 
                            		qtPerdasPar.doubleValue(), qtRef.doubleValue(), qtPerdasPCI.doubleValue()).doubleValue());
                            //itemProduto.setQtdPerdaEmUB(TOTAL_PERDAS_CICLO + TOTAL_PERDAS_REFUGO + TOTAL_PERDAS_PARADA + TOTAL_PERDAS_PCI);

                            itemProduto.setQtdPerdaEmUM(FormulasInjet.calcularTotalPerdas(qtPerdasCicloUM.doubleValue(),
                                    qtPerdasParUM.doubleValue(), qtRefUM.doubleValue(), qtPerdasPCIUM.doubleValue()).doubleValue());

                            itemProduto.setQtdPerdaEmKg(FormulasInjet.calcularTotalPerdas(qtPerdasCicloKg.doubleValue(),
                                    qtPerdasParKg.doubleValue(), qtRefKg.doubleValue(), qtPerdasPCIKg.doubleValue()).doubleValue());

                            itemProduto.setQtdPerdaEmTon(FormulasInjet.calcularTotalPerdas(qtPerdasCicloTon.doubleValue(),
                                    qtPerdasParTon.doubleValue(), qtRefTon.doubleValue(), qtPerdasPCITon.doubleValue()).doubleValue());

                                                        
                            itemProduto.setQtdBoas(qtBoas.doubleValue());
                            itemProduto.setQtdBoasKg(qtBoasKg.doubleValue());
                            itemProduto.setQtdBoasTon(qtBoasTon.doubleValue());

                            itemProduto.setQtdPrevista(qtPrevista.doubleValue());
                            itemProduto.setQtdPrevistaKg(qtPrevistaKg.doubleValue());
                            itemProduto.setQtdPrevistaTon(qtPrevistaTon.doubleValue());

                            itemProduto.setEfiRea(efiRea.doubleValue());
                            
                            // procura
                            isProdutoNaLista = false;
                            for (GraficoBIParetoDetTodasDTO produto : detalhamento.getListaProdutos()) {
                                // produto está na lista?
                                if (produto.getCdProduto().equals(itemProduto.getCdProduto())) {
                                    isProdutoNaLista = true;

                                    // acumula
                                    produto.setQtdPerdaEmUB(produto.getQtdPerdaEmUB() + itemProduto.getQtdPerdaEmUB());
                                    produto.setQtdPerdaEmUM(produto.getQtdPerdaEmUM() + itemProduto.getQtdPerdaEmUM());
                                    produto.setQtdPerdaEmKg(produto.getQtdPerdaEmKg() + itemProduto.getQtdPerdaEmKg());
                                    produto.setQtdPerdaEmTon(produto.getQtdPerdaEmTon() + itemProduto.getQtdPerdaEmTon());

                                    produto.setQtdBoas(produto.getQtdBoas() + itemProduto.getQtdBoas());
                                    produto.setQtdBoasKg(produto.getQtdBoasKg() + itemProduto.getQtdBoasKg());
                                    produto.setQtdBoasTon(produto.getQtdBoasTon() + itemProduto.getQtdBoasTon());

                                    produto.setQtdPrevista(produto.getQtdPrevista() + itemProduto.getQtdPrevista());
                                    produto.setQtdPrevistaKg(produto.getQtdPrevistaKg() + itemProduto.getQtdPrevistaKg());
                                    produto.setQtdPrevistaTon(produto.getQtdPrevistaTon() + itemProduto.getQtdPrevistaTon());

                                    efiRea = new BigDecimal(FormulasInjet.calcularEficienciaRealizacao(
                                            new BigDecimal(produto.getQtdBoas()), new BigDecimal(produto.getQtdPrevista())));

                                    produto.setEfiRea(efiRea.doubleValue());

                                    break;
                                }
                            }

                            if (!isProdutoNaLista) {
                                // adiciona produto
                                detalhamento.getListaProdutos().add(itemProduto);
                            }
                        }
                    }
                }
            }
        }

        
        // eliminar itens com perda zerada 
        ListaGraficoBIParetoDetTodasDTO listaAux = new ListaGraficoBIParetoDetTodasDTO();
        listaAux.setResumoIndicadores(new ResumoParetoPerdasDetTodasDTO());
        listaAux.setListaProdutos(new ArrayList<GraficoBIParetoDetTodasDTO>());
        
        for (GraficoBIParetoDetTodasDTO produto : detalhamento.getListaProdutos()) {
            if ( (produto.getQtdPerdaEmUB() != 0d) ){
                listaAux.getListaProdutos().add(produto);

                // resumo indicadores
                if (isConsiderarPerda && produto.getQtdPerdaEmUB() > 0) {
                    listaAux.getResumoIndicadores().setPerdaUB(listaAux.getResumoIndicadores().getPerdaUB() + produto.getQtdPerdaEmUB());
                    listaAux.getResumoIndicadores().setPerdaUM(listaAux.getResumoIndicadores().getPerdaUM() + produto.getQtdPerdaEmUM());
                    listaAux.getResumoIndicadores().setPerdaKg(listaAux.getResumoIndicadores().getPerdaKg() + produto.getQtdPerdaEmKg());
                    listaAux.getResumoIndicadores().setPerdaTon(listaAux.getResumoIndicadores().getPerdaTon() + produto.getQtdPerdaEmTon());
                }
                
                if (isConsiderarGanho && produto.getQtdPerdaEmUB() < 0) {
                    listaAux.getResumoIndicadores().setGanhoUB(listaAux.getResumoIndicadores().getGanhoUB() + (produto.getQtdPerdaEmUB() * -1));
                    listaAux.getResumoIndicadores().setGanhoUM(listaAux.getResumoIndicadores().getPerdaUM() + produto.getQtdPerdaEmUM());
                    listaAux.getResumoIndicadores().setGanhoKg(listaAux.getResumoIndicadores().getPerdaKg() + (produto.getQtdPerdaEmKg() * -1));
                    listaAux.getResumoIndicadores().setGanhoTon(listaAux.getResumoIndicadores().getPerdaTon() + (produto.getQtdPerdaEmTon() * -1));
                }
                
                listaAux.getResumoIndicadores().setSaldoUB(listaAux.getResumoIndicadores().getPerdaUB() + listaAux.getResumoIndicadores().getGanhoUB());
                listaAux.getResumoIndicadores().setSaldoUM(listaAux.getResumoIndicadores().getPerdaUM() + listaAux.getResumoIndicadores().getGanhoUM());
                listaAux.getResumoIndicadores().setSaldoKg(listaAux.getResumoIndicadores().getPerdaKg() + listaAux.getResumoIndicadores().getGanhoKg());
                listaAux.getResumoIndicadores().setSaldoTon(listaAux.getResumoIndicadores().getPerdaTon() + listaAux.getResumoIndicadores().getGanhoTon());                
            }
        }
        
        detalhamento = new ListaGraficoBIParetoDetTodasDTO();
        detalhamento = listaAux;
        
        
        // ordenar lista de produtos
        if (ordemQtd.equals(ORDEM_UB)) {
            Collections.sort(detalhamento.getListaProdutos(), new Comparator<GraficoBIParetoDetTodasDTO>() {
                @Override
                public int compare(final GraficoBIParetoDetTodasDTO o1, final GraficoBIParetoDetTodasDTO o2) {
                    final GraficoBIParetoDetTodasDTO item1 = o1;
                    final GraficoBIParetoDetTodasDTO item2 = o2;
                    return (item1.getQtdPerdaEmUB()).compareTo(item2.getQtdPerdaEmUB()) * -1;
                }
            });

        }

        if (ordemQtd.equals(ORDEM_PESO)) {
            Collections.sort(detalhamento.getListaProdutos(), new Comparator<GraficoBIParetoDetTodasDTO>() {
                @Override
                public int compare(final GraficoBIParetoDetTodasDTO o1, final GraficoBIParetoDetTodasDTO o2) {
                    final GraficoBIParetoDetTodasDTO item1 = o1;
                    final GraficoBIParetoDetTodasDTO item2 = o2;
                    return (item1.getQtdPerdaEmKg()).compareTo(item2.getQtdPerdaEmKg()) * -1;
                }
            });

        }

        if (ordemQtd.equals(ORDEM_UM)) {
            Collections.sort(detalhamento.getListaProdutos(), new Comparator<GraficoBIParetoDetTodasDTO>() {
                @Override
                public int compare(final GraficoBIParetoDetTodasDTO o1, final GraficoBIParetoDetTodasDTO o2) {
                    final GraficoBIParetoDetTodasDTO item1 = o1;
                    final GraficoBIParetoDetTodasDTO item2 = o2;
                    return (item1.getQtdPerdaEmUM()).compareTo(item2.getQtdPerdaEmUM()) * -1;
                }
            });

        }

        return detalhamento;
    }

    /*
     * Método que retorna o detalhamento de perdas por refugo - ordena��oo de máquinas, molde e produtos com maiores perdas
     */

    public ListaGraficoBIParetoDetRefOrdemMaquinaDTO getDetalhamentoGraficoPerdasBIRefOrdemMaquina(
            DetalheMonitorizacaoPTInjetDTO indicadores, String cdRefugo, String cdMaquina, String cdProduto) {

        class Produto {
            String cdProduto;
            String dsProduto;
        }

        class Maquina {
            String cdMaquina;
            String dsMaquina;
        }

        class Molde {
            String cdMolde;
            String dsMolde;
        }

        class Refugo {
            String cdRefugo;
            String dsRefugo;
        }

        class ProducaoBrutaProducaoPrevista {
            Double producaoBruta;
            Double producaoBrutaKg;
            Double producaoBrutaTon;
            Double producaoPrevista;
        }
        
        Map<String, Map<String, Map<String, Map<String, GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO>>>> mapMaq = new HashMap<>();
        Map<String, Map<String, Map<String, ProducaoBrutaProducaoPrevista>>> mapProducaoBrutaPrevista = new HashMap<>();

        Map<String, Produto> mapIdProduto = new HashMap<>();
        Map<String, Maquina> mapIdMaquina = new HashMap<>();
        Map<String, Molde> mapIdMolde = new HashMap<>();
        Map<String, Refugo> mapIdRefugo = new HashMap<>();

        ListaGraficoBIParetoDetRefOrdemMaquinaDTO detalhamento = new ListaGraficoBIParetoDetRefOrdemMaquinaDTO();
        detalhamento.setResumoIndicadores(new ResumoParetoPerdasDetRefugosDTO());
        ResumoParetoPerdasDetRefugosDTO resumo = new ResumoParetoPerdasDetRefugosDTO();
        GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO itemRefugo = new GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO();

        BigDecimal segCicloPadrao = BigDecimal.ZERO;
        BigDecimal qtPcsCiclo = BigDecimal.ZERO;

        BigDecimal fatorContagem = BigDecimal.ONE;
        
        BigDecimal segTempoAtivoAuto = BigDecimal.ZERO;
        BigDecimal segTempoAtivoManual = BigDecimal.ZERO;
        BigDecimal segTempoAtivo = BigDecimal.ZERO;

        BigDecimal qtPrevista = BigDecimal.ZERO;
        BigDecimal qtBruta = BigDecimal.ZERO;
        BigDecimal qtBrutaG = BigDecimal.ZERO;
        BigDecimal qtBrutaKg = BigDecimal.ZERO;
        BigDecimal qtBrutaTon = BigDecimal.ZERO;

        BigDecimal qtRefItem = BigDecimal.ZERO;
        BigDecimal qtRefItemKg = BigDecimal.ZERO;
        BigDecimal qtRefItemTon = BigDecimal.ZERO;
        BigDecimal qtRefItemUM = BigDecimal.ZERO;

        BigDecimal qtRef = BigDecimal.ZERO;
        BigDecimal qtRefKg = BigDecimal.ZERO;
        BigDecimal qtRefTon = BigDecimal.ZERO;
        BigDecimal qtRefUM = BigDecimal.ZERO;

        BigDecimal pesoBruto = BigDecimal.ZERO;
        BigDecimal valorUnitario = BigDecimal.ZERO;

        boolean isRefugoNaLista = false;

        // total bruto nao muda - tem que ser o mesmo independente do filtro
        resumo.setQtdProdUB(indicadores.getQtdProduzida());
        resumo.setQtdProdKg(indicadores.getProducaoBrutaKg().doubleValue());
        resumo.setQtdProdTon(indicadores.getProducaoBrutaTn().doubleValue());
        
        for (DwConsolid dwci : indicadores.getListaDwConsolId()) {
            // ciclo padr�o
            FolhaRN folhaRN = new FolhaRN(this.getDao());
            segCicloPadrao = BigDecimal.ZERO;

            // sem filtro de máquina ou com filtro e máquina selecionada igual
            // ao filtro
            if ((cdMaquina.equals("")) || (cdMaquina.equals(dwci.getOmPt().getCdPt()))) {
                for (DwConsol dwc : dwci.getDwConsols()) {
                    segCicloPadrao = dwc.getSegAutoCiclopadrao();

                    // temnpo ativo
                    segTempoAtivoAuto = FormulasInjet.calcularTempoAtivo(dwc.getSegAutoCicloprodutivo(), dwc.getSegAutoTempoparadaCp(),
                            dwc.getSegAutoCicloimprodutivo(), dwc.getSegAutoTempoparadaCpVr(), dwc.getSegAutoTempoparadaSpVr());

                    segTempoAtivoManual = FormulasInjet.calcularTempoAtivo(dwc.getSegManuCicloprodutivo(), dwc.getSegManuTempoparadaCp(),
                            dwc.getSegManuCicloimprodutivo(), dwc.getSegManuTempoparadaCpVr(), dwc.getSegManuTempoparadaSpVr());

                    segTempoAtivo = AritmeticaUtil.somar(segTempoAtivoAuto, segTempoAtivoManual);

                    for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {

                        // sem filtro de produto ou com filtro e produto
                        // selecionado igual ao filtro
                        if ((cdProduto.equals("")) || (cdProduto.equals(dwcpr.getOmProduto().getCdProduto()))) {
                            // pcs por ciclo
                            qtPcsCiclo = BigDecimal.ZERO;
                            try {
                                qtPcsCiclo = folhaRN.getPcsPorCicloAtivas(dwci.getDwFolha(), dwcpr.getOmProduto());
                            } catch (SemPcsPorCicloAtivasException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            
                            try {
								fatorContagem = folhaRN.getFatorContagemFromDwFolha(dwci.getDwFolha(), dwci.getOmPt());
							} catch (SemPacoteOuFatorException e) {
								fatorContagem = BigDecimal.ONE;
							}

                            // peso
                            if (dwcpr.getOmProduto().getGPesoBruto() != null) {
                                pesoBruto = dwcpr.getOmProduto().getGPesoBruto();
                            } else {
                                pesoBruto = BigDecimal.ZERO;
                            }

                            // custo
                            if (dwcpr.getOmProduto().getVlCustounit() != null) {
                                valorUnitario = dwcpr.getOmProduto().getVlCustounit();
                            } else {
                                valorUnitario = BigDecimal.ZERO;
                            }

                            // qtd bruta
                            qtBruta = AritmeticaUtil.somar(
                                    dwcpr.getPcsAutoProducaobruta() != null ? dwcpr.getPcsAutoProducaobruta()
                                            : BigDecimal.ZERO,
                                    dwcpr.getPcsManuProducaobruta() != null ? dwcpr.getPcsManuProducaobruta()
                                            : BigDecimal.ZERO);

                            qtBrutaG = AritmeticaUtil.somar(
                                    dwcpr.getGAutoPesoBruto() != null ? dwcpr.getGAutoPesoBruto()
                                            : BigDecimal.ZERO,
                                    dwcpr.getGManuPesoBruto() != null ? dwcpr.getGManuPesoBruto()
                                            : BigDecimal.ZERO);
                            
                            qtBrutaKg = AritmeticaUtil.dividir(qtBrutaG, new BigDecimal(1000));
                            qtBrutaTon = AritmeticaUtil.dividir(qtBrutaG, new BigDecimal(1000000));
                            
                            
                            // qtd prevista
                            qtPrevista = FormulasInjet.calcularProducaoPrevista(
                            		segTempoAtivo, 
                            		segCicloPadrao, 
                            		qtPcsCiclo,
                            		fatorContagem,
                            		dwci.getOmPt().getIndOee());

                            // refugo baseado na tabela de refugo
                            qtRef = BigDecimal.ZERO;
                            qtRefKg = BigDecimal.ZERO;
                            qtRefTon = BigDecimal.ZERO;
                            qtRefUM = BigDecimal.ZERO;

                            List<DwConsolre> dwcpres = getDwconsolRes(dwc); // (dwcpr.getDwConsol());
                            for (DwConsolre re : dwcpres) {
                                if ((cdRefugo.equals("")) || (cdRefugo.compareTo(re.getDwTRefugo().getCdTrefugo()) == 0)) {
                                    isRefugoNaLista = false;
                                    for (DwConsolreoco reoco : re.getDwConsolreocos()) {
                                        if (reoco.getDwConsolrelog().getOmProduto().getCdProduto()
                                                .compareTo(dwcpr.getOmProduto().getCdProduto()) == 0) {
                                            isRefugoNaLista = true;
                                            break;
                                        }
                                    }

                                    if (isRefugoNaLista) {
                                        // perdas
                                        qtRefItem = AritmeticaUtil
                                                .somar(re.getPcsAutoProducaorefugada() != null ? re.getPcsAutoProducaorefugada()
                                                        : BigDecimal.ZERO,
                                                        re.getPcsManuProducaorefugada() != null ? re.getPcsManuProducaorefugada()
                                                                : BigDecimal.ZERO);

                                        // perdas em kg
                                        qtRefItemKg = qtRefItem.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));

                                        // perdas em toneladas
                                        qtRefItemTon = qtRefItem.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000000));

                                        // perdas em unidade monetária
                                        qtRefItemUM = qtRefItem.multiply(valorUnitario);

                                        // acumula
                                        qtRef = AritmeticaUtil.somar(qtRef, qtRefItem);
                                        qtRefUM = AritmeticaUtil.somar(qtRefUM, qtRefItemUM);
                                        qtRefKg = AritmeticaUtil.somar(qtRefKg, qtRefItemKg);
                                        qtRefTon = AritmeticaUtil.somar(qtRefTon, qtRefItemTon);

                                        itemRefugo = new GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO();
                                        itemRefugo.setCdRefugo(re.getDwTRefugo().getCdTrefugo());
                                        itemRefugo.setDsRefugo(re.getDwTRefugo().getDsTrefugo());
                                        itemRefugo.setQtdRefEmUB(qtRefItem.doubleValue());
                                        itemRefugo.setQtdRefEmUM(qtRefItemUM.doubleValue());
                                        itemRefugo.setQtdRefEmKg(qtRefItemKg.doubleValue());
                                        itemRefugo.setQtdRefEmTon(qtRefItemTon.doubleValue());

                                        Maquina idMaq = new Maquina();
                                        idMaq.cdMaquina = dwci.getOmPt().getCd();
                                        idMaq.dsMaquina = dwci.getOmPt().getDsPt();
                                        mapIdMaquina.put(idMaq.cdMaquina, idMaq);

                                        Molde idMol = new Molde();
                                        idMol.cdMolde = dwci.getDwFolha().getCdFolha();
                                        idMol.dsMolde = dwci.getDwFolha().getDsFolha();
                                        mapIdMolde.put(idMol.cdMolde, idMol);

                                        Produto idPro = new Produto();
                                        idPro.cdProduto = dwcpr.getOmProduto().getCdProduto();
                                        idPro.dsProduto = dwcpr.getOmProduto().getDsProduto();
                                        mapIdProduto.put(idPro.cdProduto, idPro);

                                        Refugo idRef = new Refugo();
                                        idRef.cdRefugo = re.getDwTRefugo().getCdTrefugo();
                                        idRef.dsRefugo = re.getDwTRefugo().getDsTrefugo();
                                        mapIdRefugo.put(idRef.cdRefugo, idRef);

                                        String keyPro = dwcpr.getOmProduto().getCdProduto();
                                        String keyMaq = dwci.getOmPt().getCd();
                                        String keyMol = dwci.getDwFolha().getCdFolha();
                                        String keyRef = re.getDwTRefugo().getCdTrefugo();

                                        ProducaoBrutaProducaoPrevista prodBP = new ProducaoBrutaProducaoPrevista();
                                        prodBP.producaoBruta = qtBruta.doubleValue();
                                        prodBP.producaoBrutaKg = qtBrutaKg.doubleValue();
                                        prodBP.producaoBrutaTon = qtBrutaTon.doubleValue();
                                        prodBP.producaoPrevista = qtPrevista.doubleValue();

                                        // producao bruta e prevista
                                        if (mapProducaoBrutaPrevista.containsKey(keyMaq)) {
                                            if (mapProducaoBrutaPrevista.get(keyMaq).containsKey(keyMol)) {
                                                if (mapProducaoBrutaPrevista.get(keyMaq).get(keyMol).containsKey(keyPro)) {
                                                    mapProducaoBrutaPrevista.get(keyMaq).get(keyMol).get(keyPro).producaoBruta = mapProducaoBrutaPrevista
                                                            .get(keyMaq).get(keyMol).get(keyPro).producaoBruta
                                                            + prodBP.producaoBruta;
                                                    mapProducaoBrutaPrevista.get(keyMaq).get(keyMol).get(keyPro).producaoPrevista = mapProducaoBrutaPrevista
                                                            .get(keyMaq).get(keyMol).get(keyPro).producaoPrevista
                                                            + prodBP.producaoPrevista;
                                                    
                                                    mapProducaoBrutaPrevista.get(keyMaq).get(keyMol).get(keyPro).producaoBrutaKg = mapProducaoBrutaPrevista
                                                            .get(keyMaq).get(keyMol).get(keyPro).producaoBrutaKg
                                                            + prodBP.producaoBrutaKg;
                                                    mapProducaoBrutaPrevista.get(keyMaq).get(keyMol).get(keyPro).producaoBrutaTon = mapProducaoBrutaPrevista
                                                            .get(keyMaq).get(keyMol).get(keyPro).producaoBrutaTon
                                                            + prodBP.producaoBrutaTon;
                                                    
                                                } else {
                                                    // recupera map do conjunto keyMaq-keyMol
                                                    Map<String, ProducaoBrutaProducaoPrevista> mapProBP = new HashMap<>();
                                                    mapProBP = mapProducaoBrutaPrevista.get(keyMaq).get(keyMol);
                                                    mapProBP.put(keyPro, prodBP);
                                                    mapProducaoBrutaPrevista.get(keyMaq).put(keyMol, mapProBP);
                                                }
                                            } else {
                                                Map<String, ProducaoBrutaProducaoPrevista> mapProBP = new HashMap<>();
                                                mapProBP.put(keyPro, prodBP);
                                                mapProducaoBrutaPrevista.get(keyMaq).put(keyMol, mapProBP);
                                            }
                                        } else {
                                            Map<String, Map<String, ProducaoBrutaProducaoPrevista>> mapMolBP = new HashMap<>();
                                            Map<String, ProducaoBrutaProducaoPrevista> mapProBP = new HashMap<>();
                                            mapProBP.put(keyPro, prodBP);
                                            mapMolBP.put(keyMol, mapProBP);
                                            mapProducaoBrutaPrevista.put(keyMaq, mapMolBP);
                                        }

                                        if (mapMaq.containsKey(keyMaq)) {
                                            if (mapMaq.get(keyMaq).containsKey(keyMol)) {
                                                if (mapMaq.get(keyMaq).get(keyMol).containsKey(keyPro)) {
                                                    if (mapMaq.get(keyMaq).get(keyMol).get(keyPro).containsKey(keyRef)) {
                                                        mapMaq.get(keyMaq)
                                                                .get(keyMol)
                                                                .get(keyPro)
                                                                .get(keyRef)
                                                                .setQtdRefEmUB(
                                                                        mapMaq.get(keyMaq).get(keyMol).get(keyPro).get(keyRef)
                                                                                .getQtdRefEmUB()
                                                                                + itemRefugo.getQtdRefEmUB());
                                                        mapMaq.get(keyMaq)
                                                                .get(keyMol)
                                                                .get(keyPro)
                                                                .get(keyRef)
                                                                .setQtdRefEmUM(
                                                                        mapMaq.get(keyMaq).get(keyMol).get(keyPro).get(keyRef)
                                                                                .getQtdRefEmUM()
                                                                                + itemRefugo.getQtdRefEmUM());
                                                        mapMaq.get(keyMaq)
                                                                .get(keyMol)
                                                                .get(keyPro)
                                                                .get(keyRef)
                                                                .setQtdRefEmTon(
                                                                        mapMaq.get(keyMaq).get(keyMol).get(keyPro).get(keyRef)
                                                                                .getQtdRefEmTon()
                                                                                + itemRefugo.getQtdRefEmTon());
                                                        mapMaq.get(keyMaq)
                                                                .get(keyMol)
                                                                .get(keyPro)
                                                                .get(keyRef)
                                                                .setQtdRefEmKg(
                                                                        mapMaq.get(keyMaq).get(keyMol).get(keyPro).get(keyRef)
                                                                                .getQtdRefEmKg()
                                                                                + itemRefugo.getQtdRefEmKg());
                                                    } else {
                                                        mapMaq.get(keyMaq).get(keyMol).get(keyPro).put(keyRef, itemRefugo);
                                                    }
                                                } else {
                                                    Map<String, GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO> mapRef = new HashMap<>();
                                                    mapRef.put(keyRef, itemRefugo);
                                                    mapMaq.get(keyMaq).get(keyMol).put(keyPro, mapRef);
                                                }

                                            } else {
                                                Map<String, Map<String, GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO>> mapPro = new HashMap<>();
                                                Map<String, GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO> mapRef = new HashMap<>();

                                                mapRef.put(keyRef, itemRefugo);
                                                mapPro.put(keyPro, mapRef);

                                                mapMaq.get(keyMaq).put(keyMol, mapPro);
                                            }
                                        } else {
                                            Map<String, Map<String, Map<String, GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO>>> mapFer = new HashMap<>();
                                            Map<String, Map<String, GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO>> mapPro = new HashMap<>();
                                            Map<String, GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO> mapRef = new HashMap<>();

                                            mapRef.put(keyRef, itemRefugo);
                                            mapPro.put(keyPro, mapRef);
                                            mapFer.put(keyMol, mapPro);

                                            mapMaq.put(keyMaq, mapFer);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        detalhamento.setMaquinas(new ArrayList<GraficoBIParetoDetRefOrdemMaquinaDTO>());

        // totalizar qtds
        Set<String> keysMaquinas = mapMaq.keySet();
        for (String maq : keysMaquinas) {
            GraficoBIParetoDetRefOrdemMaquinaDTO maquina = new GraficoBIParetoDetRefOrdemMaquinaDTO();

            maquina.setCdMaquina(maq);
            maquina.setDsMaquina(mapIdMaquina.get(maq).dsMaquina);
            maquina.setQtdRefEmUB(0d);
            maquina.setQtdRefEmUM(0d);
            maquina.setQtdRefEmKg(0d);
            maquina.setQtdRefEmTon(0d);
            maquina.setQtdPrev(0d);
            maquina.setQtdProd(0d);
            maquina.setQtdProdKg(0d);
            maquina.setQtdProdTon(0d);
            maquina.setFerramentas(new ArrayList<GraficoBIParetoDetRefOrdemMaquinaFerramentaDTO>());

            Set<String> keysMoldes = mapMaq.get(maq).keySet();

            for (String mol : keysMoldes) {
                GraficoBIParetoDetRefOrdemMaquinaFerramentaDTO ferramenta = new GraficoBIParetoDetRefOrdemMaquinaFerramentaDTO();

                ferramenta.setCdFerramenta(mol);
                ferramenta.setDsFerramenta(mapIdMolde.get(mol).dsMolde);
                ferramenta.setQtdRefEmUB(0d);
                ferramenta.setQtdRefEmUM(0d);
                ferramenta.setQtdRefEmKg(0d);
                ferramenta.setQtdRefEmTon(0d);
                ferramenta.setQtdPrev(0d);
                ferramenta.setQtdProd(0d);
                ferramenta.setProdutos(new ArrayList<GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoDTO>());

                Set<String> keysProdutos = mapMaq.get(maq).get(mol).keySet();

                for (String pro : keysProdutos) {
                    GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoDTO produto = new GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoDTO();
                    produto.setCdProduto(pro);
                    produto.setDsProduto(mapIdProduto.get(pro).dsProduto);
                    produto.setQtdRefEmUB(0d);
                    produto.setQtdRefEmUM(0d);
                    produto.setQtdRefEmKg(0d);
                    produto.setQtdRefEmTon(0d);
                    produto.setQtdPrev(0d);
                    produto.setQtdProd(0d);
                    produto.setRefugos(new ArrayList<GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO>());

                    // produ��oo bruta e prevista
                    produto.setQtdProd(produto.getQtdProd() + mapProducaoBrutaPrevista.get(maq).get(mol).get(pro).producaoBruta);
                    produto.setQtdPrev(produto.getQtdPrev() + mapProducaoBrutaPrevista.get(maq).get(mol).get(pro).producaoPrevista);

                    ferramenta.setQtdProd(ferramenta.getQtdProd() + mapProducaoBrutaPrevista.get(maq).get(mol).get(pro).producaoBruta);
                    ferramenta.setQtdPrev(ferramenta.getQtdPrev() + mapProducaoBrutaPrevista.get(maq).get(mol).get(pro).producaoPrevista);

                    maquina.setQtdProd(maquina.getQtdProd() + mapProducaoBrutaPrevista.get(maq).get(mol).get(pro).producaoBruta);
                    maquina.setQtdProdKg(maquina.getQtdProdKg() + mapProducaoBrutaPrevista.get(maq).get(mol).get(pro).producaoBrutaKg);
                    maquina.setQtdProdTon(maquina.getQtdProdTon() + mapProducaoBrutaPrevista.get(maq).get(mol).get(pro).producaoBrutaTon);
                    maquina.setQtdPrev(maquina.getQtdPrev() + mapProducaoBrutaPrevista.get(maq).get(mol).get(pro).producaoPrevista);

                    Set<String> keysRef = mapMaq.get(maq).get(mol).get(pro).keySet();

                    for (String ref : keysRef) {
                        GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO refugo = new GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO();
                        refugo.setCdRefugo(ref);
                        refugo.setDsRefugo(mapIdRefugo.get(ref).dsRefugo);
                        refugo.setQtdRefEmUB(mapMaq.get(maq).get(mol).get(pro).get(ref).getQtdRefEmUB());
                        refugo.setQtdRefEmUM(mapMaq.get(maq).get(mol).get(pro).get(ref).getQtdRefEmUM());
                        refugo.setQtdRefEmKg(mapMaq.get(maq).get(mol).get(pro).get(ref).getQtdRefEmKg());
                        refugo.setQtdRefEmTon(mapMaq.get(maq).get(mol).get(pro).get(ref).getQtdRefEmTon());

                        produto.setQtdRefEmUB(produto.getQtdRefEmUB() + refugo.getQtdRefEmUB());
                        produto.setQtdRefEmUM(produto.getQtdRefEmUM() + refugo.getQtdRefEmUM());
                        produto.setQtdRefEmKg(produto.getQtdRefEmKg() + refugo.getQtdRefEmKg());
                        produto.setQtdRefEmTon(produto.getQtdRefEmTon() + refugo.getQtdRefEmTon());
                        produto.setIndRef(FormulasInjet.calcularIndiceRefugo(new BigDecimal(produto.getQtdRefEmUB()),
                                new BigDecimal(produto.getQtdProd())).doubleValue());
                        produto.getRefugos().add(refugo);

                        ferramenta.setQtdRefEmUB(ferramenta.getQtdRefEmUB() + refugo.getQtdRefEmUB());
                        ferramenta.setQtdRefEmUM(ferramenta.getQtdRefEmUM() + refugo.getQtdRefEmUM());
                        ferramenta.setQtdRefEmKg(ferramenta.getQtdRefEmKg() + refugo.getQtdRefEmKg());
                        ferramenta.setQtdRefEmTon(ferramenta.getQtdRefEmTon() + refugo.getQtdRefEmTon());
                        ferramenta.setIndRef(FormulasInjet.calcularIndiceRefugo(new BigDecimal(ferramenta.getQtdRefEmUB()),
                                new BigDecimal(ferramenta.getQtdProd())).doubleValue());

                        maquina.setQtdRefEmUB(maquina.getQtdRefEmUB() + refugo.getQtdRefEmUB());
                        maquina.setQtdRefEmUM(maquina.getQtdRefEmUM() + refugo.getQtdRefEmUM());
                        maquina.setQtdRefEmKg(maquina.getQtdRefEmKg() + refugo.getQtdRefEmKg());
                        maquina.setQtdRefEmTon(maquina.getQtdRefEmTon() + refugo.getQtdRefEmTon());
                        maquina.setIndRef(FormulasInjet.calcularIndiceRefugo(new BigDecimal(maquina.getQtdRefEmUB()),
                                new BigDecimal(maquina.getQtdProd())).doubleValue());

                    }

                    ferramenta.getProdutos().add(produto);
                }

                maquina.getFerramentas().add(ferramenta);
            }

            // resumo 
            detalhamento.getResumoIndicadores().setPerdaUB(detalhamento.getResumoIndicadores().getPerdaUB() + maquina.getQtdRefEmUB());
            detalhamento.getResumoIndicadores().setPerdaUM(detalhamento.getResumoIndicadores().getPerdaUM() + maquina.getQtdRefEmUM());
            detalhamento.getResumoIndicadores().setPerdaKg(detalhamento.getResumoIndicadores().getPerdaKg() + maquina.getQtdRefEmKg());
            detalhamento.getResumoIndicadores().setPerdaTon(detalhamento.getResumoIndicadores().getPerdaTon() + maquina.getQtdRefEmTon());
            detalhamento.getResumoIndicadores().setQtdProdUB(resumo.getQtdProdUB());
            detalhamento.getResumoIndicadores().setQtdProdKg(resumo.getQtdProdKg());
            detalhamento.getResumoIndicadores().setQtdProdTon(resumo.getQtdProdTon());
            detalhamento.getResumoIndicadores().setIndRefUB(FormulasInjet.calcularIndiceRefugo(detalhamento.getResumoIndicadores().getPerdaUB(), detalhamento.getResumoIndicadores().getQtdProdUB()).doubleValue());
            detalhamento.getResumoIndicadores().setIndRefKg(FormulasInjet.calcularIndiceRefugo(detalhamento.getResumoIndicadores().getPerdaKg(), detalhamento.getResumoIndicadores().getQtdProdKg()).doubleValue());
            detalhamento.getResumoIndicadores().setIndRefTon(detalhamento.getResumoIndicadores().getIndRefKg());
            
            detalhamento.getMaquinas().add(maquina);
        }

        // ordenar ferramentas de cada máquina
        for (GraficoBIParetoDetRefOrdemMaquinaDTO maquina : detalhamento.getMaquinas()) {

            Collections.sort(maquina.getFerramentas(), new Comparator<GraficoBIParetoDetRefOrdemMaquinaFerramentaDTO>() {
                @Override
                public int compare(final GraficoBIParetoDetRefOrdemMaquinaFerramentaDTO o1,
                        final GraficoBIParetoDetRefOrdemMaquinaFerramentaDTO o2) {
                    final GraficoBIParetoDetRefOrdemMaquinaFerramentaDTO item1 = o1;
                    final GraficoBIParetoDetRefOrdemMaquinaFerramentaDTO item2 = o2;
                    return (item1.getQtdRefEmUB()).compareTo(item2.getQtdRefEmUB()) * -1;
                }
            });

            // ordernar produtos de cada ferramenta
            for (GraficoBIParetoDetRefOrdemMaquinaFerramentaDTO ferramenta : maquina.getFerramentas()) {

                Collections.sort(ferramenta.getProdutos(), new Comparator<GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoDTO>() {
                    @Override
                    public int compare(final GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoDTO o1,
                            final GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoDTO o2) {
                        final GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoDTO item1 = o1;
                        final GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoDTO item2 = o2;
                        return (item1.getQtdRefEmUB()).compareTo(item2.getQtdRefEmUB()) * -1;
                    }
                });

                // ordernar refugos de cada produto
                for (GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoDTO produto : ferramenta.getProdutos()) {
                    Collections.sort(produto.getRefugos(), new Comparator<GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO>() {
                        @Override
                        public int compare(final GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO o1,
                                final GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO o2) {
                            final GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO item1 = o1;
                            final GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO item2 = o2;
                            return (item1.getQtdRefEmUB()).compareTo(item2.getQtdRefEmUB()) * -1;
                        }
                    });
                }

            }

        }

        // ordenar lista de máquinas
        Collections.sort(detalhamento.getMaquinas(), new Comparator<GraficoBIParetoDetRefOrdemMaquinaDTO>() {
            @Override
            public int compare(final GraficoBIParetoDetRefOrdemMaquinaDTO o1, final GraficoBIParetoDetRefOrdemMaquinaDTO o2) {
                final GraficoBIParetoDetRefOrdemMaquinaDTO item1 = o1;
                final GraficoBIParetoDetRefOrdemMaquinaDTO item2 = o2;
                return (item1.getQtdRefEmUB()).compareTo(item2.getQtdRefEmUB()) * -1;
            }
        });

        return detalhamento;
    }

    /*
     * Método que retorna o detalhamento de perdas por refugo - ordena��oo de produto, máquina e molde com maiores perdas
     */

    public ListaGraficoBIParetoDetRefOrdemProdutoDTO getDetalhamentoGraficoPerdasBIRefOrdemProduto(
            DetalheMonitorizacaoPTInjetDTO indicadores, Byte ordemQtd, String cdRefugo, String cdMaquina, String cdProduto) {
        final Byte ORDEM_UB = 1;
        final Byte ORDEM_PESO = 2;
        final Byte ORDEM_UM = 3;

        class Produto {
            String cdProduto;
            String dsProduto;
        }

        class Maquina {
            String cdMaquina;
            String dsMaquina;
        }

        class Molde {
            String cdMolde;
            String dsMolde;
        }

        class Refugo {
            String cdRefugo;
            String dsRefugo;
        }

        class ProducaoBrutaProducaoPrevista {
            Double producaoBruta;
            Double producaoPrevista;
        }

        Map<String, Map<String, Map<String, Map<String, GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO>>>> mapPro = new HashMap<>();
        Map<String, Map<String, Map<String, ProducaoBrutaProducaoPrevista>>> mapProducaoBrutaPrevista = new HashMap<>();
        Map<String, Produto> mapIdProduto = new HashMap<>();
        Map<String, Maquina> mapIdMaquina = new HashMap<>();
        Map<String, Molde> mapIdMolde = new HashMap<>();
        Map<String, Refugo> mapIdRefugo = new HashMap<>();

        ListaGraficoBIParetoDetRefOrdemProdutoDTO detalhamento = new ListaGraficoBIParetoDetRefOrdemProdutoDTO();
        detalhamento.setResumoIndicadores(new ResumoParetoPerdasDetRefugosDTO());
        ResumoParetoPerdasDetRefugosDTO resumo = new ResumoParetoPerdasDetRefugosDTO();
        GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO itemRefugo = new GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO();

        BigDecimal segCicloPadrao = BigDecimal.ZERO;
        BigDecimal qtPcsCiclo = BigDecimal.ZERO;
        
        BigDecimal fatorContagem = BigDecimal.ONE;

        BigDecimal segTempoAtivoAuto = BigDecimal.ZERO;
        BigDecimal segTempoAtivoManual = BigDecimal.ZERO;
        BigDecimal segTempoAtivo = BigDecimal.ZERO;

        BigDecimal qtPrevista = BigDecimal.ZERO;
        BigDecimal qtBruta = BigDecimal.ZERO;
        BigDecimal qtBrutaG = BigDecimal.ZERO;

        BigDecimal qtRefItem = BigDecimal.ZERO;
        BigDecimal qtRefItemKg = BigDecimal.ZERO;
        BigDecimal qtRefItemTon = BigDecimal.ZERO;
        BigDecimal qtRefItemUM = BigDecimal.ZERO;

        BigDecimal qtRef = BigDecimal.ZERO;
        BigDecimal qtRefKg = BigDecimal.ZERO;
        BigDecimal qtRefTon = BigDecimal.ZERO;
        BigDecimal qtRefUM = BigDecimal.ZERO;

        BigDecimal pesoBruto = BigDecimal.ZERO;
        BigDecimal valorUnitario = BigDecimal.ZERO;

        boolean isRefugoNaLista = false;

        // total bruto nao muda - tem que ser o mesmo independente do filtro
        resumo.setQtdProdUB(indicadores.getQtdProduzida());
        resumo.setQtdProdKg(indicadores.getProducaoBrutaKg().doubleValue());
        resumo.setQtdProdTon(indicadores.getProducaoBrutaTn().doubleValue());
        
        for (DwConsolid dwci : indicadores.getListaDwConsolId()) {
            // ciclo padr�o
            FolhaRN folhaRN = new FolhaRN(this.getDao());
            segCicloPadrao = BigDecimal.ZERO;

            // sem filtro de máquina ou com filtro e máquina selecionada igual
            // ao filtro
            if ((cdMaquina.equals("")) || (cdMaquina.equals(dwci.getOmPt().getCdPt()))) {
                for (DwConsol dwc : dwci.getDwConsols()) {
                    segCicloPadrao = dwc.getSegAutoCiclopadrao();

                    // temnpo ativo
                    segTempoAtivoAuto = FormulasInjet.calcularTempoAtivo(dwc.getSegAutoCicloprodutivo(), dwc.getSegAutoTempoparadaCp(),
                            dwc.getSegAutoCicloimprodutivo(), dwc.getSegAutoTempoparadaCpVr(), dwc.getSegAutoTempoparadaSpVr());

                    segTempoAtivoManual = FormulasInjet.calcularTempoAtivo(dwc.getSegManuCicloprodutivo(), dwc.getSegManuTempoparadaCp(),
                            dwc.getSegManuCicloimprodutivo(), dwc.getSegManuTempoparadaCpVr(), dwc.getSegManuTempoparadaSpVr());

                    segTempoAtivo = AritmeticaUtil.somar(segTempoAtivoAuto, segTempoAtivoManual);

                    for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {

                        // sem filtro de produto ou com filtro e produto
                        // selecionado igual ao filtro
                        if ((cdProduto.equals("")) || (cdProduto.equals(dwcpr.getOmProduto().getCdProduto()))) {
                            // pcs por ciclo
                            qtPcsCiclo = BigDecimal.ZERO;
                            try {
                                qtPcsCiclo = folhaRN.getPcsPorCicloAtivas(dwci.getDwFolha(), dwcpr.getOmProduto());
                            } catch (SemPcsPorCicloAtivasException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            try {
								fatorContagem = folhaRN.getFatorContagemFromDwFolha(dwci.getDwFolha(), dwci.getOmPt());
							} catch (SemPacoteOuFatorException e) {
								fatorContagem = BigDecimal.ONE;
							}

                            // peso
                            if (dwcpr.getOmProduto().getGPesoBruto() != null) {
                                pesoBruto = dwcpr.getOmProduto().getGPesoBruto();
                            } else {
                                pesoBruto = BigDecimal.ZERO;
                            }

                            // custo
                            if (dwcpr.getOmProduto().getVlCustounit() != null) {
                                valorUnitario = dwcpr.getOmProduto().getVlCustounit();
                            } else {
                                valorUnitario = BigDecimal.ZERO;
                            }

                            // qtd bruta
                            qtBruta = AritmeticaUtil.somar(
                                    dwcpr.getPcsAutoProducaobruta() != null ? dwcpr.getPcsAutoProducaobruta()
                                            : BigDecimal.ZERO,
                                    dwcpr.getPcsManuProducaobruta() != null ? dwcpr.getPcsManuProducaobruta()
                                            : BigDecimal.ZERO);


                            qtBrutaG = AritmeticaUtil.somar(
                                    dwcpr.getGAutoPesoBruto() != null ? dwcpr.getGAutoPesoBruto()
                                            : BigDecimal.ZERO,
                                    dwcpr.getGManuPesoBruto() != null ? dwcpr.getGManuPesoBruto()
                                            : BigDecimal.ZERO);

                            // qtd prevista
                            qtPrevista = FormulasInjet.calcularProducaoPrevista(
                            		segTempoAtivo, 
                            		segCicloPadrao, 
                            		qtPcsCiclo,
                            		fatorContagem,
                            		dwci.getOmPt().getIndOee());

                            // refugo baseado na tabela de refugo
                            qtRef = BigDecimal.ZERO;
                            qtRefKg = BigDecimal.ZERO;
                            qtRefTon = BigDecimal.ZERO;
                            qtRefUM = BigDecimal.ZERO;

                            List<DwConsolre> dwcpres = getDwconsolRes(dwc); // (dwcpr.getDwConsol());
                            for (DwConsolre re : dwcpres) {
                                if ((cdRefugo.equals("")) || (cdRefugo.compareTo(re.getDwTRefugo().getCdTrefugo()) == 0)) {
                                    isRefugoNaLista = false;
                                    for (DwConsolreoco reoco : re.getDwConsolreocos()) {
                                        if (reoco.getDwConsolrelog().getOmProduto().getCdProduto()
                                                .compareTo(dwcpr.getOmProduto().getCdProduto()) == 0) {
                                            isRefugoNaLista = true;
                                            break;
                                        }
                                    }

                                    if (isRefugoNaLista) {
                                        // perdas
                                        qtRefItem = AritmeticaUtil
                                                .somar(re.getPcsAutoProducaorefugada() != null ? re.getPcsAutoProducaorefugada()
                                                        : BigDecimal.ZERO,
                                                        re.getPcsManuProducaorefugada() != null ? re.getPcsManuProducaorefugada()
                                                                : BigDecimal.ZERO);

                                        // perdas em kg
                                        qtRefItemKg = qtRefItem.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));

                                        // perdas em toneladas
                                        qtRefItemTon = qtRefItem.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000000));

                                        // perdas em unidade monetária
                                        qtRefItemUM = qtRefItem.multiply(valorUnitario);

                                        // acumula
                                        qtRef = AritmeticaUtil.somar(qtRef, qtRefItem);
                                        qtRefUM = AritmeticaUtil.somar(qtRefUM, qtRefItemUM);
                                        qtRefKg = AritmeticaUtil.somar(qtRefKg, qtRefItemKg);
                                        qtRefTon = AritmeticaUtil.somar(qtRefTon, qtRefItemTon);

                                        itemRefugo = new GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO();
                                        itemRefugo.setCdRefugo(re.getDwTRefugo().getCdTrefugo());
                                        itemRefugo.setDsRefugo(re.getDwTRefugo().getDsTrefugo());
                                        itemRefugo.setQtdRefEmUB(qtRefItem.doubleValue());
                                        itemRefugo.setQtdRefEmUM(qtRefItemUM.doubleValue());
                                        itemRefugo.setQtdRefEmKg(qtRefItemKg.doubleValue());
                                        itemRefugo.setQtdRefEmTon(qtRefItemTon.doubleValue());

                                        // resumo
                                        resumo.setPerdaUB(resumo.getPerdaUB() +  itemRefugo.getQtdRefEmUB());
                                        resumo.setPerdaUM(resumo.getPerdaUM() + itemRefugo.getQtdRefEmUM());
                                        resumo.setPerdaKg(resumo.getPerdaKg() +  itemRefugo.getQtdRefEmKg());
                                        resumo.setPerdaTon(resumo.getPerdaTon() + itemRefugo.getQtdRefEmTon());
                                        
                                        Produto idPro = new Produto();
                                        idPro.cdProduto = dwcpr.getOmProduto().getCdProduto();
                                        idPro.dsProduto = dwcpr.getOmProduto().getDsProduto();
                                        mapIdProduto.put(idPro.cdProduto, idPro);

                                        Maquina idMaq = new Maquina();
                                        idMaq.cdMaquina = dwci.getOmPt().getCd();
                                        idMaq.dsMaquina = dwci.getOmPt().getDsPt();
                                        mapIdMaquina.put(idMaq.cdMaquina, idMaq);

                                        Molde idMol = new Molde();
                                        idMol.cdMolde = dwci.getDwFolha().getCdFolha();
                                        idMol.dsMolde = dwci.getDwFolha().getDsFolha();
                                        mapIdMolde.put(idMol.cdMolde, idMol);

                                        Refugo idRef = new Refugo();
                                        idRef.cdRefugo = re.getDwTRefugo().getCdTrefugo();
                                        idRef.dsRefugo = re.getDwTRefugo().getDsTrefugo();
                                        mapIdRefugo.put(idRef.cdRefugo, idRef);

                                        String keyPro = dwcpr.getOmProduto().getCdProduto();
                                        String keyMaq = dwci.getOmPt().getCd();
                                        String keyMol = dwci.getDwFolha().getCdFolha();
                                        String keyRef = re.getDwTRefugo().getCdTrefugo();

                                        ProducaoBrutaProducaoPrevista prodBP = new ProducaoBrutaProducaoPrevista();
                                        prodBP.producaoBruta = qtBruta.doubleValue();
                                        prodBP.producaoPrevista = qtPrevista.doubleValue();

                                        // produ��oo bruta e prevista
                                        if (mapProducaoBrutaPrevista.containsKey(keyPro)) {
                                            if (mapProducaoBrutaPrevista.get(keyPro).containsKey(keyMaq)) {
                                                if (mapProducaoBrutaPrevista.get(keyPro).get(keyMaq).containsKey(keyMol)) {
                                                    mapProducaoBrutaPrevista.get(keyPro).get(keyMaq).get(keyMol).producaoBruta = mapProducaoBrutaPrevista
                                                            .get(keyPro).get(keyMaq).get(keyMol).producaoBruta
                                                            + prodBP.producaoBruta;
                                                    mapProducaoBrutaPrevista.get(keyPro).get(keyMaq).get(keyMol).producaoPrevista = mapProducaoBrutaPrevista
                                                            .get(keyPro).get(keyMaq).get(keyMol).producaoPrevista
                                                            + prodBP.producaoPrevista;
                                                } else {
                                                    Map<String, ProducaoBrutaProducaoPrevista> mapMolBP = new HashMap<>();
                                                    mapMolBP = mapProducaoBrutaPrevista.get(keyPro).get(keyMaq);                                                    
                                                    mapMolBP.put(keyMol, prodBP);
                                                    mapProducaoBrutaPrevista.get(keyPro).put(keyMaq, mapMolBP);
                                                }
                                            } else {
                                                Map<String, Map<String, ProducaoBrutaProducaoPrevista>> mapMaqBP = new HashMap<>();
                                                Map<String, ProducaoBrutaProducaoPrevista> mapMolBP = new HashMap<>();
                                                mapMaqBP = mapProducaoBrutaPrevista.get(keyPro);
                                                mapMolBP.put(keyMol, prodBP);
                                                mapMaqBP.put(keyMaq, mapMolBP);
                                                mapProducaoBrutaPrevista.get(keyPro).putAll(mapMaqBP);
                                            }
                                        } else {
                                            Map<String, Map<String, ProducaoBrutaProducaoPrevista>> mapMaqBP = new HashMap<>();
                                            Map<String, ProducaoBrutaProducaoPrevista> mapMolBP = new HashMap<>();
                                            mapMolBP.put(keyMol, prodBP);
                                            mapMaqBP.put(keyMaq, mapMolBP);
                                            mapProducaoBrutaPrevista.put(keyPro, mapMaqBP);
                                        }

                                        if (mapPro.containsKey(keyPro)) {
                                            if (mapPro.get(keyPro).containsKey(keyMaq)) {
                                                if (mapPro.get(keyPro).get(keyMaq).containsKey(keyMol)) {
                                                    if (mapPro.get(keyPro).get(keyMaq).get(keyMol).containsKey(keyRef)) {
                                                        mapPro.get(keyPro)
                                                                .get(keyMaq)
                                                                .get(keyMol)
                                                                .get(keyRef)
                                                                .setQtdRefEmUB(
                                                                        mapPro.get(keyPro).get(keyMaq).get(keyMol).get(keyRef)
                                                                                .getQtdRefEmUB()
                                                                                + itemRefugo.getQtdRefEmUB());
                                                        mapPro.get(keyPro)
                                                                .get(keyMaq)
                                                                .get(keyMol)
                                                                .get(keyRef)
                                                                .setQtdRefEmUM(
                                                                        mapPro.get(keyPro).get(keyMaq).get(keyMol).get(keyRef)
                                                                                .getQtdRefEmUM()
                                                                                + itemRefugo.getQtdRefEmUM());
                                                        mapPro.get(keyPro)
                                                                .get(keyMaq)
                                                                .get(keyMol)
                                                                .get(keyRef)
                                                                .setQtdRefEmTon(
                                                                        mapPro.get(keyPro).get(keyMaq).get(keyMol).get(keyRef)
                                                                                .getQtdRefEmTon()
                                                                                + itemRefugo.getQtdRefEmTon());
                                                        mapPro.get(keyPro)
                                                                .get(keyMaq)
                                                                .get(keyMol)
                                                                .get(keyRef)
                                                                .setQtdRefEmKg(
                                                                        mapPro.get(keyPro).get(keyMaq).get(keyMol).get(keyRef)
                                                                                .getQtdRefEmKg()
                                                                                + itemRefugo.getQtdRefEmKg());
                                                    } else {
                                                        mapPro.get(keyPro).get(keyMaq).get(keyMol).put(keyRef, itemRefugo);
                                                    }
                                                } else {
                                                    Map<String, GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO> mapRef = new HashMap<>();
                                                    mapRef.put(keyRef, itemRefugo);
                                                    mapPro.get(keyPro).get(keyMaq).put(keyMol, mapRef);
                                                }

                                            } else {
                                                Map<String, Map<String, Map<String, GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO>>> mapMaq = new HashMap<>();
                                                Map<String, Map<String, GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO>> mapFer = new HashMap<>();
                                                Map<String, GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO> mapRef = new HashMap<>();

                                                mapMaq = mapPro.get(keyPro);                                                
                                                mapRef.put(keyRef, itemRefugo);
                                                mapFer.put(keyMol, mapRef);
                                                mapMaq.put(keyMaq, mapFer);

                                                mapPro.put(keyPro, mapMaq);
                                            }
                                        } else {
                                            Map<String, Map<String, Map<String, GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO>>> mapMaq = new HashMap<>();
                                            Map<String, Map<String, GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO>> mapFer = new HashMap<>();
                                            Map<String, GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO> mapRef = new HashMap<>();

                                            mapRef.put(keyRef, itemRefugo);
                                            mapFer.put(keyMol, mapRef);
                                            mapMaq.put(keyMaq, mapFer);

                                            mapPro.put(keyPro, mapMaq);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        detalhamento.setProdutos(new ArrayList<GraficoBIParetoDetRefOrdemProdutoDTO>());

        // totalizar qtds
        Set<String> keysProdutos = mapPro.keySet();
        for (String pro : keysProdutos) {
            GraficoBIParetoDetRefOrdemProdutoDTO produto = new GraficoBIParetoDetRefOrdemProdutoDTO();

            produto.setCdProduto(pro);
            produto.setDsProduto(mapIdProduto.get(pro).dsProduto);
            produto.setQtdRefEmUB(0d);
            produto.setQtdRefEmUM(0d);
            produto.setQtdRefEmKg(0d);
            produto.setQtdRefEmTon(0d);
            produto.setQtdPrev(0d);
            produto.setQtdProd(0d);
            produto.setMaquinas(new ArrayList<GraficoBIParetoDetRefOrdemProdutoMaquinaDTO>());

            Set<String> keysMaquinas = mapPro.get(pro).keySet();

            for (String maq : keysMaquinas) {
                GraficoBIParetoDetRefOrdemProdutoMaquinaDTO maquina = new GraficoBIParetoDetRefOrdemProdutoMaquinaDTO();

                maquina.setCdMaquina(maq);
                maquina.setDsMaquina(mapIdMaquina.get(maq).dsMaquina);
                maquina.setQtdRefEmUB(0d);
                maquina.setQtdRefEmUM(0d);
                maquina.setQtdRefEmKg(0d);
                maquina.setQtdRefEmTon(0d);
                maquina.setQtdPrev(0d);
                maquina.setQtdProd(0d);
                maquina.setFerramentas(new ArrayList<GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaDTO>());

                Set<String> keysMolde = mapPro.get(pro).get(maq).keySet();

                for (String mol : keysMolde) {
                    GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaDTO ferramenta = new GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaDTO();
                    ferramenta.setCdFerramenta(mol);
                    ferramenta.setDsFerramenta(mapIdMolde.get(mol).dsMolde);
                    ferramenta.setQtdRefEmUB(0d);
                    ferramenta.setQtdRefEmUM(0d);
                    ferramenta.setQtdRefEmKg(0d);
                    ferramenta.setQtdRefEmTon(0d);
                    ferramenta.setQtdPrev(0d);
                    ferramenta.setQtdProd(0d);
                    ferramenta.setRefugos(new ArrayList<GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO>());

                    // produ��oo bruta e prevista
                    ferramenta.setQtdProd(ferramenta.getQtdProd() + mapProducaoBrutaPrevista.get(pro).get(maq).get(mol).producaoBruta);
                    ferramenta.setQtdPrev(ferramenta.getQtdPrev() + mapProducaoBrutaPrevista.get(pro).get(maq).get(mol).producaoPrevista);

                    maquina.setQtdProd(maquina.getQtdProd() + mapProducaoBrutaPrevista.get(pro).get(maq).get(mol).producaoBruta);
                    maquina.setQtdPrev(maquina.getQtdPrev() + mapProducaoBrutaPrevista.get(pro).get(maq).get(mol).producaoPrevista);

                    produto.setQtdProd(produto.getQtdProd() + mapProducaoBrutaPrevista.get(pro).get(maq).get(mol).producaoBruta);
                    produto.setQtdPrev(produto.getQtdPrev() + mapProducaoBrutaPrevista.get(pro).get(maq).get(mol).producaoPrevista);

                    Set<String> keysRef = mapPro.get(pro).get(maq).get(mol).keySet();

                    for (String ref : keysRef) {
                        GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO refugo = new GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO();
                        refugo.setCdRefugo(ref);
                        refugo.setDsRefugo(mapIdRefugo.get(ref).dsRefugo);
                        refugo.setQtdRefEmUB(mapPro.get(pro).get(maq).get(mol).get(ref).getQtdRefEmUB());
                        refugo.setQtdRefEmUM(mapPro.get(pro).get(maq).get(mol).get(ref).getQtdRefEmUM());
                        refugo.setQtdRefEmKg(mapPro.get(pro).get(maq).get(mol).get(ref).getQtdRefEmKg());
                        refugo.setQtdRefEmTon(mapPro.get(pro).get(maq).get(mol).get(ref).getQtdRefEmTon());

                        ferramenta.setQtdRefEmUB(ferramenta.getQtdRefEmUB() + refugo.getQtdRefEmUB());
                        ferramenta.setQtdRefEmUM(ferramenta.getQtdRefEmUM() + refugo.getQtdRefEmUM());
                        ferramenta.setQtdRefEmKg(ferramenta.getQtdRefEmKg() + refugo.getQtdRefEmKg());
                        ferramenta.setQtdRefEmTon(ferramenta.getQtdRefEmTon() + refugo.getQtdRefEmTon());
                        ferramenta.getRefugos().add(refugo);
                        ferramenta.setIndRef(FormulasInjet.calcularIndiceRefugo(new BigDecimal(ferramenta.getQtdRefEmUB()),
                                new BigDecimal(ferramenta.getQtdProd())).doubleValue());

                        maquina.setQtdRefEmUB(maquina.getQtdRefEmUB() + refugo.getQtdRefEmUB());
                        maquina.setQtdRefEmUM(maquina.getQtdRefEmUM() + refugo.getQtdRefEmUM());
                        maquina.setQtdRefEmKg(maquina.getQtdRefEmKg() + refugo.getQtdRefEmKg());
                        maquina.setQtdRefEmTon(maquina.getQtdRefEmTon() + refugo.getQtdRefEmTon());
                        maquina.setIndRef(FormulasInjet.calcularIndiceRefugo(new BigDecimal(maquina.getQtdRefEmUB()),
                                new BigDecimal(maquina.getQtdProd())).doubleValue());

                        produto.setQtdRefEmUB(produto.getQtdRefEmUB() + refugo.getQtdRefEmUB());
                        produto.setQtdRefEmUM(produto.getQtdRefEmUM() + refugo.getQtdRefEmUM());
                        produto.setQtdRefEmKg(produto.getQtdRefEmKg() + refugo.getQtdRefEmKg());
                        produto.setQtdRefEmTon(produto.getQtdRefEmTon() + refugo.getQtdRefEmTon());
                        produto.setIndRef(FormulasInjet.calcularIndiceRefugo(new BigDecimal(produto.getQtdRefEmUB()),
                                new BigDecimal(produto.getQtdProd())).doubleValue());
                    }

                    maquina.getFerramentas().add(ferramenta);
                }

                produto.getMaquinas().add(maquina);
            }

            detalhamento.getProdutos().add(produto);
        }

        // resumo 
        detalhamento.setResumoIndicadores(resumo);
        detalhamento.getResumoIndicadores().setIndRefUB(FormulasInjet.calcularIndiceRefugo(detalhamento.getResumoIndicadores().getPerdaUB(), detalhamento.getResumoIndicadores().getQtdProdUB()).doubleValue());
        detalhamento.getResumoIndicadores().setIndRefKg(FormulasInjet.calcularIndiceRefugo(detalhamento.getResumoIndicadores().getPerdaKg(), detalhamento.getResumoIndicadores().getQtdProdKg()).doubleValue());
        detalhamento.getResumoIndicadores().setIndRefTon(detalhamento.getResumoIndicadores().getIndRefKg());
        

        
        // ordenar máquinas de cada produto
        for (GraficoBIParetoDetRefOrdemProdutoDTO produto : detalhamento.getProdutos()) {

            Collections.sort(produto.getMaquinas(), new Comparator<GraficoBIParetoDetRefOrdemProdutoMaquinaDTO>() {
                @Override
                public int compare(final GraficoBIParetoDetRefOrdemProdutoMaquinaDTO o1,
                        final GraficoBIParetoDetRefOrdemProdutoMaquinaDTO o2) {
                    final GraficoBIParetoDetRefOrdemProdutoMaquinaDTO item1 = o1;
                    final GraficoBIParetoDetRefOrdemProdutoMaquinaDTO item2 = o2;
                    return (item1.getQtdRefEmUB()).compareTo(item2.getQtdRefEmUB()) * -1;
                }
            });

            // ordernar ferramentas de cada máquina
            for (GraficoBIParetoDetRefOrdemProdutoMaquinaDTO maquina : produto.getMaquinas()) {

                Collections.sort(maquina.getFerramentas(), new Comparator<GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaDTO>() {
                    @Override
                    public int compare(final GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaDTO o1,
                            final GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaDTO o2) {
                        final GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaDTO item1 = o1;
                        final GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaDTO item2 = o2;
                        return (item1.getQtdRefEmUB()).compareTo(item2.getQtdRefEmUB()) * -1;
                    }
                });

                // ordernar refugos de cada ferramenta
                for (GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaDTO ferramenta : maquina.getFerramentas()) {
                    Collections.sort(ferramenta.getRefugos(),
                            new Comparator<GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO>() {
                                @Override
                                public int compare(final GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO o1,
                                        final GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO o2) {
                                    final GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO item1 = o1;
                                    final GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaRefugoDTO item2 = o2;
                                    return (item1.getQtdRefEmUB()).compareTo(item2.getQtdRefEmUB()) * -1;
                                }
                            });
                }

            }

        }

        // ordenar lista de produtos
        if (ordemQtd.equals(ORDEM_UB)) {
            Collections.sort(detalhamento.getProdutos(), new Comparator<GraficoBIParetoDetRefOrdemProdutoDTO>() {
                @Override
                public int compare(final GraficoBIParetoDetRefOrdemProdutoDTO o1, final GraficoBIParetoDetRefOrdemProdutoDTO o2) {
                    final GraficoBIParetoDetRefOrdemProdutoDTO item1 = o1;
                    final GraficoBIParetoDetRefOrdemProdutoDTO item2 = o2;
                    return (item1.getQtdRefEmUB()).compareTo(item2.getQtdRefEmUB()) * -1;
                }
            });

        }

        if (ordemQtd.equals(ORDEM_PESO)) {
            Collections.sort(detalhamento.getProdutos(), new Comparator<GraficoBIParetoDetRefOrdemProdutoDTO>() {
                @Override
                public int compare(final GraficoBIParetoDetRefOrdemProdutoDTO o1, final GraficoBIParetoDetRefOrdemProdutoDTO o2) {
                    final GraficoBIParetoDetRefOrdemProdutoDTO item1 = o1;
                    final GraficoBIParetoDetRefOrdemProdutoDTO item2 = o2;
                    return (item1.getQtdRefEmUB()).compareTo(item2.getQtdRefEmUB()) * -1;
                }
            });

        }

        if (ordemQtd.equals(ORDEM_UM)) {
            Collections.sort(detalhamento.getProdutos(), new Comparator<GraficoBIParetoDetRefOrdemProdutoDTO>() {
                @Override
                public int compare(final GraficoBIParetoDetRefOrdemProdutoDTO o1, final GraficoBIParetoDetRefOrdemProdutoDTO o2) {
                    final GraficoBIParetoDetRefOrdemProdutoDTO item1 = o1;
                    final GraficoBIParetoDetRefOrdemProdutoDTO item2 = o2;
                    return (item1.getQtdRefEmUB()).compareTo(item2.getQtdRefEmUB()) * -1;
                }
            });

        }

        return detalhamento;
    }

    /*
     * Método que retorna o detalhamento de perdas por parada - ordena��oo de máquinas, molde e produtos com maiores perdas
     */    
    public ListaGraficoBIParetoDetParOrdemMaquinaDTO getDetalhamentoGraficoPerdasBIParOrdemMaquina(
            DetalheMonitorizacaoPTInjetDTO indicadores, String cdParada, String cdMaquina, String cdProduto, Boolean isComPeso,
            Boolean isSemPeso) {

        final Double TEMPO_LIMITE_MICRO_PARADA_EM_SEGUNDOS = 60d;

        class TotaisDetalhe {
            Boolean isParComPeso;
            Double segTempoPar;
            Double qtdOcorrPar;
            Double segTempoMicroPar;
            Double qtdMicroPar;
            Double indMicroPar;
            Double qtdProd;
            Double qtdPrev;
            Double indPerda;
            Double qtdPerdasPar;
            Double qtdPerdasTon;
            Double qtdPerdasKg;
            Double qtdPerdasUM;
            
            final TotaisDetalhe cloneTotaisDetalhe() {
                TotaisDetalhe copia = new TotaisDetalhe();
                copia.isParComPeso = this.isParComPeso;
                copia.segTempoPar = this.segTempoPar;
                copia.qtdOcorrPar = this.qtdOcorrPar;
                copia.segTempoMicroPar = this.segTempoMicroPar;
                copia.qtdMicroPar = this.qtdMicroPar;
                copia.indMicroPar = this.indMicroPar;
                copia.qtdProd = this.qtdProd;
                copia.qtdPrev = this.qtdPrev;
                copia.indPerda = this.indPerda;
                copia.qtdPerdasPar = this.qtdPerdasPar;
                copia.qtdPerdasTon = this.qtdPerdasTon;
                copia.qtdPerdasKg = this.qtdPerdasKg;
                copia.qtdPerdasUM = this.qtdPerdasUM;
                
                return copia;
            }            
        }

        class Produto {
            String cdProduto;
            String dsProduto;
            TotaisDetalhe det = new TotaisDetalhe();
            
            final Produto cloneProduto() {
                Produto copia = new Produto();
                copia.cdProduto = this.cdProduto;
                copia.dsProduto = this.dsProduto;
                copia.det = this.det.cloneTotaisDetalhe();
                return copia;
            }                        
        }

        class Parada {
            Long idTParada;
            String cdParada;
            String dsParada;
            Map<String, Produto> produtos = new HashMap<String, Produto>();
            TotaisDetalhe det = new TotaisDetalhe();
            
            final Parada cloneParada() {
                Parada copia = new Parada();
                copia.idTParada = this.idTParada;
                copia.cdParada = this.cdParada;
                copia.dsParada = this.dsParada;
                copia.det = this.det.cloneTotaisDetalhe();
                copia.produtos.putAll(this.produtos);
                return copia;
            }                        
        }

        class Molde {
            String cdMolde;
            String dsMolde;
            Map<String, Parada> paradas = new HashMap<String, Parada>();
            TotaisDetalhe det = new TotaisDetalhe();
            
            final Molde cloneMolde() {
                Molde copia = new Molde();
                copia.cdMolde = this.cdMolde;
                copia.dsMolde = this.dsMolde;
                copia.det = this.det.cloneTotaisDetalhe();
                copia.paradas.putAll(this.paradas);
                return copia;
            }                  
        }

        class Turno {
            String cdTurno;
            String dsTurno;
            Map<String, Parada> paradas = new HashMap<String, Parada>();
            TotaisDetalhe det = new TotaisDetalhe();
            
            final Turno cloneTurno() {
                Turno copia = new Turno();
                copia.cdTurno = this.cdTurno;
                copia.dsTurno = this.dsTurno;
                copia.det = this.det.cloneTotaisDetalhe();
                copia.paradas.putAll(this.paradas);
                return copia;
            }                        
            
        }

        class Maquina {
            String cdMaquina;
            String dsMaquina;
            Map<String, Molde> moldes = new HashMap<String, Molde>();
            Map<String, Molde> moldesQtdProdPrev = new HashMap<String, Molde>();
            Map<String, Turno> turnos = new HashMap<String, Turno>();
            
            final Maquina cloneMaquina() {
                Maquina copia = new Maquina();
                copia.cdMaquina = this.cdMaquina;
                copia.dsMaquina = this.dsMaquina;
                copia.moldes.putAll(this.moldes);
                copia.turnos.putAll(this.turnos);
                copia.moldesQtdProdPrev.putAll(this.moldesQtdProdPrev);
                return copia;
            }                        
            
        }
        
        // utilizados na identifica��oo dos agrupamentos
        Maquina idMaq = new Maquina();
        Molde idMol = new Molde();
        Turno idTur = new Turno();
        Parada idPar = new Parada();
        Produto idPro = new Produto();
        Map<String, Maquina> mapIdMaq = new HashMap<String, Maquina>();
        Map<String, Molde> mapIdMol = new HashMap<String, Molde>();
        Map<String, Turno> mapIdTur = new HashMap<String, Turno>();
        Map<String, Parada> mapIdPar = new HashMap<String, Parada>();
        Map<String, Produto> mapIdPro = new HashMap<String, Produto>();

        // totalizadores
        Double segTempoDisponivelTotal = 0d;
        TotaisDetalhe itemDet = new TotaisDetalhe();

        // map utilizado na montagem das classes a serem retornadas
        Produto itemPro = new Produto();
        Parada itemPar = new Parada();
        Molde itemMol = new Molde();
        Maquina itemMaq = new Maquina();
        Turno itemTur = new Turno();
        Map<String, Maquina> mapDetMaq = new HashMap<String, Maquina>();

        ListaGraficoBIParetoDetParOrdemMaquinaDTO detalhamento = new ListaGraficoBIParetoDetParOrdemMaquinaDTO();
        detalhamento.setResumoIndicadores(new ResumoParetoPerdasDetParadasDTO());
        ResumoParetoPerdasDetParadasDTO resumo = new ResumoParetoPerdasDetParadasDTO();
        
        // ciclo padr�o e cav ativas
        BigDecimal segCicloPadrao = BigDecimal.ZERO;
        BigDecimal qtPcsCiclo = BigDecimal.ZERO;
        
        BigDecimal fatorContagem = BigDecimal.ONE;

        // tempo ativo
        BigDecimal segTempoAtivoAuto = BigDecimal.ZERO;
        BigDecimal segTempoAtivoManual = BigDecimal.ZERO;
        BigDecimal segTempoAtivo = BigDecimal.ZERO;

        // peso bruto e valor unitário
        BigDecimal pesoBruto = BigDecimal.ZERO;
        BigDecimal valorUnitario = BigDecimal.ZERO;

        // qtds
        BigDecimal qtPrevista = BigDecimal.ZERO;
        BigDecimal qtBruta = BigDecimal.ZERO;
        BigDecimal qtRef = BigDecimal.ZERO;
        BigDecimal qtBoa = BigDecimal.ZERO;

        BigDecimal qtPar = BigDecimal.ZERO;
        BigDecimal qtParKg = BigDecimal.ZERO;
        BigDecimal qtParTon = BigDecimal.ZERO;
        BigDecimal qtParUM = BigDecimal.ZERO;

        ConsolidaRN crn = new ConsolidaRN(getDao());

        // tempo disponivel eh o mesmo independente de filtro
        resumo.setTempoDisponivel(indicadores.getTempoDisponiveis());
        
        for (DwConsolid dwci : indicadores.getListaDwConsolId()) {
            // ciclo padr�o
            FolhaRN folhaRN = new FolhaRN(this.getDao());
            segCicloPadrao = BigDecimal.ZERO;

            // sem filtro de máquina ou com filtro e máquina selecionada igual
            // ao filtro
            if ((cdMaquina.equals("")) || (cdMaquina.equals(dwci.getOmPt().getCdPt()))) {

                for (DwConsol dwc : dwci.getDwConsols()) {
                    segCicloPadrao = dwc.getSegAutoCiclopadrao();

                    // temnpo ativo
                    segTempoAtivoAuto = FormulasInjet.calcularTempoAtivo(dwc.getSegAutoCicloprodutivo(), dwc.getSegAutoTempoparadaCp(),
                            dwc.getSegAutoCicloimprodutivo(), dwc.getSegAutoTempoparadaCpVr(), dwc.getSegAutoTempoparadaSpVr());

                    segTempoAtivoManual = FormulasInjet.calcularTempoAtivo(dwc.getSegManuCicloprodutivo(), dwc.getSegManuTempoparadaCp(),
                            dwc.getSegManuCicloimprodutivo(), dwc.getSegManuTempoparadaCpVr(), dwc.getSegManuTempoparadaSpVr());

                    segTempoAtivo = AritmeticaUtil.somar(segTempoAtivoAuto, segTempoAtivoManual);


                    segTempoDisponivelTotal = segTempoDisponivelTotal + segTempoAtivo.doubleValue();
                    
                    
                    // lista de paradas
                    List<DwConsolpa> dwcpas = crn.getDwconsolPas(dwc);
                    
                    
					List<DwConsolid> consolids = new ArrayList<>();
					consolids.add(dwci);
					
                    for (DwConsolpa par : dwcpas) {
                        if ((cdParada.equals("")) || (cdParada.compareTo(par.getDwTParada().getCdTparada()) == 0)) {

                            if (isComPeso != null && isComPeso && par.getDwTParada().getIsPesa() == false) {
                                if (isSemPeso == null || (isSemPeso != null && isSemPeso == false))
                                {
                                    continue;
                                }
                            }
                                
                            
                            if (isSemPeso != null && isSemPeso && par.getDwTParada().getIsPesa()) {
                                if (isComPeso == null || (isComPeso != null && isComPeso == false))
                                {
                                    continue;
                                }
                            }

                            // lista de produtos vinculados a parada
                            for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {

                                // resumo
                                itemDet = new TotaisDetalhe();

                                if (par.getDwTParada().getIsPesa()) {
                                    itemDet.isParComPeso = true;
                                    itemDet.segTempoPar = AritmeticaUtil.somar(
                                            par.getSegAutoTempoparadaCp() != null ? par.getSegAutoTempoparadaCp() : BigDecimal.ZERO,
                                            par.getSegManuTempoparadaCp() != null ? par.getSegManuTempoparadaCp() : BigDecimal.ZERO)
                                            .doubleValue();

                                    itemDet.qtdOcorrPar = AritmeticaUtil.somar(
                                            par.getQtAutoOcoparadaCp() != null ? par.getQtAutoOcoparadaCp() : BigDecimal.ZERO,
                                            par.getQtManuOcoparadaCp() != null ? par.getQtAutoOcoparadaCp() : BigDecimal.ZERO)
                                            .doubleValue();
                                    itemDet.indPerda = 0d;

                                } else {
                                    itemDet.isParComPeso = false;
                                    itemDet.segTempoPar = AritmeticaUtil.somar(
                                            par.getSegAutoTempoparadaSp() != null ? par.getSegAutoTempoparadaSp() : BigDecimal.ZERO,
                                            par.getSegManuTempoparadaSp() != null ? par.getSegManuTempoparadaSp() : BigDecimal.ZERO)
                                            .doubleValue();

                                    itemDet.qtdOcorrPar = AritmeticaUtil.somar(
                                            par.getQtAutoOcoparadaSp() != null ? par.getQtAutoOcoparadaSp() : BigDecimal.ZERO,
                                            par.getQtManuOcoparadaSp() != null ? par.getQtAutoOcoparadaSp() : BigDecimal.ZERO)
                                            .doubleValue();

                                    itemDet.indPerda = 0d;
                                }

                                if ((itemDet.segTempoPar < TEMPO_LIMITE_MICRO_PARADA_EM_SEGUNDOS) && (itemDet.segTempoPar != 0d)) {
                                    itemDet.qtdMicroPar = 1d;
                                    itemDet.segTempoMicroPar = itemDet.segTempoPar;
                                    itemDet.indMicroPar = 0d;
                                } else {
                                    itemDet.qtdMicroPar = 0d;
                                    itemDet.segTempoMicroPar = 0d;
                                    itemDet.indMicroPar = 0d;
                                }

                                itemDet.qtdProd = 0d;
                                itemDet.qtdPrev = 0d;
                                itemDet.indPerda = 0d;
                                itemDet.qtdPerdasPar = 0d;
                                itemDet.qtdPerdasTon = 0d;
                                itemDet.qtdPerdasKg = 0d;
                                itemDet.qtdPerdasUM = 0d;

                                // sem filtro de produto ou com filtro e
                                // máquina selecionada igual ao filtro
                                if ((cdProduto.equals("")) || (cdProduto.equals(dwcpr.getOmProduto().getCdProduto()))) {
                                    // pcs por ciclo
                                    qtPcsCiclo = BigDecimal.ZERO;
                                    try {
                                        qtPcsCiclo = folhaRN.getPcsPorCicloAtivas(dwci.getDwFolha(), dwcpr.getOmProduto());
                                    } catch (SemPcsPorCicloAtivasException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                    
                                    try {
										fatorContagem = folhaRN.getFatorContagemFromDwFolha(dwci.getDwFolha(), dwci.getOmPt());
									} catch (SemPacoteOuFatorException e) {
										fatorContagem = BigDecimal.ONE;
									}

                                    // peso
                                    if (dwcpr.getOmProduto().getGPesoBruto() != null) {
                                        pesoBruto = dwcpr.getOmProduto().getGPesoBruto();
                                    } else {
                                        pesoBruto = BigDecimal.ZERO;
                                    }

                                    // custo
                                    if (dwcpr.getOmProduto().getVlCustounit() != null) {
                                        valorUnitario = dwcpr.getOmProduto().getVlCustounit();
                                    } else {
                                        valorUnitario = BigDecimal.ZERO;
                                    }

                                    if (par.getDwTParada().getIsPesa()) {
                                        qtPar = FormulasInjet.calcularPcsPerdaParada(new BigDecimal(itemDet.segTempoPar), segCicloPadrao,
                                                qtPcsCiclo);
                                    } else {
                                        qtPar = BigDecimal.ZERO;
                                    }

                                    qtParUM = qtPar.multiply(valorUnitario);
                                    qtParKg = qtPar.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));
                                    qtParTon = qtPar.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000000));

                                    itemDet.qtdPerdasPar = qtPar.doubleValue();
                                    itemDet.qtdPerdasTon = qtParTon.doubleValue();
                                    itemDet.qtdPerdasKg = qtParKg.doubleValue();
                                    itemDet.qtdPerdasUM = qtParUM.doubleValue();

                                    // Maps com identifica��oo
                                    idMaq = new Maquina();
                                    idMaq.cdMaquina = dwci.getOmPt().getCdPt();
                                    idMaq.dsMaquina = dwci.getOmPt().getDsPt();
                                    idMaq.moldes = new HashMap<String, Molde>();
                                    idMaq.moldesQtdProdPrev = new HashMap<String, Molde>();                                    
                                    idMaq.turnos = new HashMap<String, Turno>();

                                    idMol = new Molde();
                                    idMol.cdMolde = dwci.getDwFolha().getCdFolha();
                                    idMol.dsMolde = dwci.getDwFolha().getDsFolha();
                                    idMol.paradas = new HashMap<String, Parada>();
                                    
                                    idTur = new Turno();
                                    idTur.cdTurno = dwci.getDwTurno().getCdTurno();
                                    idTur.dsTurno = dwci.getDwTurno().getDsTurno();
                                    idTur.paradas = new HashMap<String, Parada>();
                                    
                                    idPar = new Parada();
                                    idPar.idTParada = par.getDwTParada().getIdTparada();
                                    idPar.cdParada = par.getDwTParada().getCdTparada();
                                    idPar.dsParada = par.getDwTParada().getDsTparada();
                                    idPar.produtos = new HashMap<String, Produto>();
                                    
                                    idPro = new Produto();
                                    idPro.cdProduto = dwcpr.getOmProduto().getCdProduto();
                                    idPro.dsProduto = dwcpr.getOmProduto().getDsProduto();
                                    idPro.det =  new TotaisDetalhe();
                                    
                                    mapIdMaq.put(idMaq.cdMaquina, idMaq);
                                    mapIdMol.put(idMol.cdMolde, idMol);
                                    mapIdTur.put(idTur.cdTurno, idTur);
                                    mapIdPar.put(idPar.cdParada, idPar);
                                    mapIdPro.put(idPro.cdProduto, idPro);

                                    itemPro = new Produto();
                                    itemPro.cdProduto = idPro.cdProduto;
                                    itemPro.dsProduto = idPro.dsProduto;
                                    itemPro.det = new TotaisDetalhe();
                                    itemPro.det = itemDet.cloneTotaisDetalhe();

                                    itemPar = new Parada();
                                    itemPar.idTParada = idPar.idTParada;
                                    itemPar.cdParada = idPar.cdParada;
                                    itemPar.dsParada = idPar.dsParada;
                                    itemPar.produtos.put(idPro.cdProduto, itemPro);
                                    itemPar.det = new TotaisDetalhe();
                                    itemPar.det = itemDet.cloneTotaisDetalhe();

                                    itemMol = new Molde();
                                    itemMol.cdMolde = idMol.cdMolde;
                                    itemMol.dsMolde = idMol.dsMolde;
                                    itemMol.paradas.put(itemPar.cdParada, itemPar);
                                    itemMol.det = new TotaisDetalhe();
                                    itemMol.det = itemDet.cloneTotaisDetalhe(); 

                                    itemTur = new Turno();
                                    itemTur.cdTurno = idTur.cdTurno;
                                    itemTur.dsTurno = idTur.dsTurno;
                                    itemTur.paradas.put(itemPar.cdParada, itemPar);
                                    itemTur.det = new TotaisDetalhe();
                                    itemTur.det = itemDet.cloneTotaisDetalhe();
                                    
                                    itemMaq = new Maquina();
                                    itemMaq.cdMaquina = idMaq.cdMaquina;
                                    itemMaq.dsMaquina = idMaq.dsMaquina;
                                    itemMaq.moldes.put(itemMol.cdMolde, itemMol);
                                    itemMaq.turnos.put(itemTur.cdTurno, itemTur);

                                    if (mapDetMaq.containsKey(idMaq.cdMaquina)) {
                                        if (mapDetMaq.get(idMaq.cdMaquina).moldes.containsKey(idMol.cdMolde)) {
                                            if (mapDetMaq.get(idMaq.cdMaquina).moldes.get(idMol.cdMolde).paradas
                                                    .containsKey(idPar.cdParada)) {

                                                // total maq-mol-par
                                                TotaisDetalhe cloneItemPar = itemPar.det.cloneTotaisDetalhe();
                                                Parada clonePar = mapDetMaq.get(idMaq.cdMaquina).moldes.get(idMol.cdMolde).paradas.get(idPar.cdParada).cloneParada();
                                                TotaisDetalhe acumuladoMaqMolPar = clonePar.det.cloneTotaisDetalhe();
                                                
                                                
                                                acumuladoMaqMolPar.segTempoPar += cloneItemPar.segTempoPar;
                                                acumuladoMaqMolPar.qtdOcorrPar += cloneItemPar.qtdOcorrPar;
                                                acumuladoMaqMolPar.segTempoMicroPar += cloneItemPar.segTempoMicroPar;
                                                acumuladoMaqMolPar.qtdMicroPar += cloneItemPar.qtdMicroPar;

                                                acumuladoMaqMolPar.qtdPerdasPar += cloneItemPar.qtdPerdasPar;
                                                acumuladoMaqMolPar.qtdPerdasUM += cloneItemPar.qtdPerdasUM;
                                                acumuladoMaqMolPar.qtdPerdasKg += cloneItemPar.qtdPerdasKg;
                                                acumuladoMaqMolPar.qtdPerdasTon += cloneItemPar.qtdPerdasTon;
                                                
                                                clonePar.det = acumuladoMaqMolPar;
                                                mapDetMaq.get(idMaq.cdMaquina).moldes.get(idMol.cdMolde).paradas.put(clonePar.cdParada, clonePar);

                                                // totais maq-mol
                                                TotaisDetalhe acumuladoMaqMol = mapDetMaq.get(idMaq.cdMaquina).moldes.get(idMol.cdMolde).det.cloneTotaisDetalhe();
                                                
                                                acumuladoMaqMol.segTempoPar += cloneItemPar.segTempoPar;
                                                acumuladoMaqMol.qtdOcorrPar += cloneItemPar.qtdOcorrPar;
                                                acumuladoMaqMol.segTempoMicroPar += cloneItemPar.segTempoMicroPar;
                                                acumuladoMaqMol.qtdMicroPar += cloneItemPar.qtdMicroPar;

                                                acumuladoMaqMol.qtdPerdasPar += cloneItemPar.qtdPerdasPar;
                                                acumuladoMaqMol.qtdPerdasUM += cloneItemPar.qtdPerdasUM;
                                                acumuladoMaqMol.qtdPerdasKg += cloneItemPar.qtdPerdasKg;
                                                acumuladoMaqMol.qtdPerdasTon += cloneItemPar.qtdPerdasTon;

                                                mapDetMaq.get(idMaq.cdMaquina).moldes.get(idMol.cdMolde).det = acumuladoMaqMol.cloneTotaisDetalhe();
                                                                                                
                                                
                                                if (mapDetMaq.get(idMaq.cdMaquina).moldes.get(idMol.cdMolde).paradas.get(idPar.cdParada).produtos
                                                        .containsKey(idPro.cdProduto)) {
                                                    
                                                    // total maq-mol-par-produto
                                                    Produto cloneProduto = mapDetMaq.get(idMaq.cdMaquina).moldes.get(idMol.cdMolde).paradas.get(idPar.cdParada).produtos.get(idPro.cdProduto).cloneProduto();
                                                    TotaisDetalhe acumuladoMaqMolParPro = cloneProduto.det.cloneTotaisDetalhe();
                                                    acumuladoMaqMolParPro.qtdPerdasPar += cloneItemPar.qtdPerdasPar;
                                                    acumuladoMaqMolParPro.qtdPerdasUM += cloneItemPar.qtdPerdasUM;
                                                    acumuladoMaqMolParPro.qtdPerdasKg += cloneItemPar.qtdPerdasKg;
                                                    acumuladoMaqMolParPro.qtdPerdasTon += cloneItemPar.qtdPerdasTon;
                                                    cloneProduto.det = acumuladoMaqMolParPro.cloneTotaisDetalhe();
                                                    
                                                    mapDetMaq.get(idMaq.cdMaquina).moldes.get(idMol.cdMolde).paradas.get(idPar.cdParada).produtos.put(cloneProduto.cdProduto, cloneProduto);

                                                } else {
                                                    Produto cloneProduto = itemPro.cloneProduto();
                                                    
                                                    mapDetMaq.get(idMaq.cdMaquina).moldes.get(idMol.cdMolde).paradas.get(idPar.cdParada).produtos
                                                            .put(cloneProduto.cdProduto, cloneProduto); 
                                                }
                                            } else {
                                                // nova parada
                                                Parada clonePar = itemPar.cloneParada();
                                                mapDetMaq.get(idMaq.cdMaquina).moldes.get(idMol.cdMolde).paradas.put(clonePar.cdParada, clonePar);
                                                TotaisDetalhe totalMaqMolNovaPar = mapDetMaq.get(idMaq.cdMaquina).moldes.get(idMol.cdMolde).paradas.get(clonePar.cdParada).det.cloneTotaisDetalhe();                                                
                                                
                                                mapDetMaq.get(idMaq.cdMaquina).moldes.get(idMol.cdMolde).det = totalMaqMolNovaPar;
                                            }
                                        } else {
                                            Molde cloneMol = itemMol.cloneMolde();
                                            mapDetMaq.get(idMaq.cdMaquina).moldes.put(cloneMol.cdMolde, cloneMol);
                                        }

                                        // turnos
                                        if (mapDetMaq.get(idMaq.cdMaquina).turnos.containsKey(idTur.cdTurno)) {
                                            if (mapDetMaq.get(idMaq.cdMaquina).turnos.get(idTur.cdTurno).paradas
                                                    .containsKey(idPar.cdParada)) {
                                                
                                                TotaisDetalhe totalMaqTurPar = mapDetMaq.get(idMaq.cdMaquina).turnos.get(idTur.cdTurno).paradas.get(idPar.cdParada).det.cloneTotaisDetalhe();

                                                totalMaqTurPar.segTempoPar += itemPar.det.segTempoPar;
                                                totalMaqTurPar.qtdOcorrPar += itemPar.det.qtdOcorrPar;
                                                totalMaqTurPar.segTempoMicroPar += itemPar.det.segTempoMicroPar;
                                                totalMaqTurPar.qtdMicroPar += itemPar.det.qtdMicroPar;

                                                totalMaqTurPar.qtdPerdasPar += itemPar.det.qtdPerdasPar;
                                                totalMaqTurPar.qtdPerdasUM += itemPar.det.qtdPerdasUM;
                                                totalMaqTurPar.qtdPerdasKg += itemPar.det.qtdPerdasKg;
                                                totalMaqTurPar.qtdPerdasTon += itemPar.det.qtdPerdasTon;

                                                mapDetMaq.get(idMaq.cdMaquina).turnos.get(idTur.cdTurno).paradas.get(idPar.cdParada).det = totalMaqTurPar;
                                                
                                                
                                                TotaisDetalhe totalMaqTur = mapDetMaq.get(idMaq.cdMaquina).turnos.get(idTur.cdTurno).det.cloneTotaisDetalhe();
                                                totalMaqTur.segTempoPar += itemPar.det.segTempoPar;
                                                totalMaqTur.qtdOcorrPar += itemPar.det.qtdOcorrPar;
                                                totalMaqTur.segTempoMicroPar += itemPar.det.segTempoMicroPar;
                                                totalMaqTur.qtdMicroPar += itemPar.det.qtdMicroPar;

                                                totalMaqTur.qtdPerdasPar += itemPar.det.qtdPerdasPar;
                                                totalMaqTur.qtdPerdasUM += itemPar.det.qtdPerdasUM;
                                                totalMaqTur.qtdPerdasKg += itemPar.det.qtdPerdasKg;
                                                totalMaqTur.qtdPerdasTon += itemPar.det.qtdPerdasTon;

                                                mapDetMaq.get(idMaq.cdMaquina).turnos.get(idTur.cdTurno).det = totalMaqTur;
                                                
                                                
                                                if (mapDetMaq.get(idMaq.cdMaquina).turnos.get(idTur.cdTurno).paradas.get(idPar.cdParada).produtos
                                                        .containsKey(idPro.cdProduto)) {
                                                    
                                                    TotaisDetalhe totalMaqTurParPro = mapDetMaq.get(idMaq.cdMaquina).turnos.get(idTur.cdTurno).paradas.get(idPar.cdParada).produtos.get(idPro.cdProduto).det.cloneTotaisDetalhe();
                                                    
                                                    totalMaqTurParPro.qtdPerdasPar += itemPro.det.qtdPerdasPar;
                                                    totalMaqTurParPro.qtdPerdasUM += itemPro.det.qtdPerdasUM;
                                                    totalMaqTurParPro.qtdPerdasKg += itemPro.det.qtdPerdasKg;
                                                    totalMaqTurParPro.qtdPerdasTon += itemPro.det.qtdPerdasTon;
                                                    
                                                    mapDetMaq.get(idMaq.cdMaquina).turnos.get(idTur.cdTurno).paradas.get(idPar.cdParada).produtos.get(idPro.cdProduto).det = totalMaqTurParPro;
                                                    
                                                } else {
                                                    Produto cloneProdutoTurno = itemPro.cloneProduto();
                                                    mapDetMaq.get(idMaq.cdMaquina).turnos.get(idTur.cdTurno).paradas.get(idPar.cdParada).produtos
                                                            .put(cloneProdutoTurno.cdProduto, cloneProdutoTurno);
                                                }
                                            } else {
                                                // necessário atualizar turnos
                                                // pq turno pode ter sido
                                                // incluido no map em situaco
                                                // onde n�o havia parada

                                                TotaisDetalhe totalParTur = mapDetMaq.get(idMaq.cdMaquina).turnos.get(idTur.cdTurno).det.cloneTotaisDetalhe();
                                                
                                                mapDetMaq.get(idMaq.cdMaquina).turnos.get(idTur.cdTurno).det.segTempoPar += itemPar.det.segTempoPar;
                                                mapDetMaq.get(idMaq.cdMaquina).turnos.get(idTur.cdTurno).det.qtdOcorrPar += itemPar.det.qtdOcorrPar;
                                                mapDetMaq.get(idMaq.cdMaquina).turnos.get(idTur.cdTurno).det.segTempoMicroPar += itemPar.det.segTempoMicroPar;
                                                mapDetMaq.get(idMaq.cdMaquina).turnos.get(idTur.cdTurno).det.qtdMicroPar += itemPar.det.qtdMicroPar;

                                                mapDetMaq.get(idMaq.cdMaquina).turnos.get(idTur.cdTurno).det.qtdPerdasPar += itemPar.det.qtdPerdasPar;
                                                mapDetMaq.get(idMaq.cdMaquina).turnos.get(idTur.cdTurno).det.qtdPerdasUM += itemPar.det.qtdPerdasUM;
                                                mapDetMaq.get(idMaq.cdMaquina).turnos.get(idTur.cdTurno).det.qtdPerdasKg += itemPar.det.qtdPerdasKg;
                                                mapDetMaq.get(idMaq.cdMaquina).turnos.get(idTur.cdTurno).det.qtdPerdasTon += itemPar.det.qtdPerdasTon;

                                                mapDetMaq.get(idMaq.cdMaquina).turnos.get(idTur.cdTurno).paradas.put(itemPar.cdParada,
                                                        itemPar);
                                            }
                                        } else {
                                            // necessário atualizar turnos pq
                                            // turno pode ter sido incluido no
                                            // map em situaco onde n�o havia
                                            // parada
                                            Turno cloneTur = itemTur.cloneTurno();
                                            mapDetMaq.get(idMaq.cdMaquina).turnos.put(cloneTur.cdTurno, cloneTur);
                                        }

                                    } else {
                                        mapDetMaq.put(itemMaq.cdMaquina, itemMaq);
                                    }
                                }
                            }
                        }

                    } // fim paradas

                    
                    // lista de produtos vinculados as ferramenta e aos turnos
                    // ... só interessa a produ��oo líquida e a produ��oo
                    // prevista
                    for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {
                        // sem filtro de produto ou com filtro e máquina
                        // selecionada igual ao filtro
                        if ((cdProduto.equals("")) || (cdProduto.equals(dwcpr.getOmProduto().getCdProduto()))) {
                            // pcs por ciclo
                            qtPcsCiclo = BigDecimal.ZERO;
                            try {
                                qtPcsCiclo = folhaRN.getPcsPorCicloAtivas(dwci.getDwFolha(), dwcpr.getOmProduto());
                            } catch (SemPcsPorCicloAtivasException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }

                            // qtd bruta, ref e boa
                            qtBruta = AritmeticaUtil.somar(
                                    dwcpr.getPcsAutoProducaobruta() != null ? dwcpr.getPcsAutoProducaobruta()
                                            : BigDecimal.ZERO,
                                    dwcpr.getPcsManuProducaobruta() != null ? dwcpr.getPcsManuProducaobruta()
                                            : BigDecimal.ZERO);

                            qtRef = AritmeticaUtil.somar(
                                    dwcpr.getPcsAutoProducaorefugada() != null ? dwcpr.getPcsAutoProducaorefugada()
                                            : BigDecimal.ZERO,
                                    dwcpr.getPcsManuProducaorefugada() != null ? dwcpr.getPcsManuProducaorefugada()
                                            : BigDecimal.ZERO);

                            qtBoa = AritmeticaUtil.diminuir(qtBruta, qtRef);

                            // qtd prevista
                            qtPrevista = FormulasInjet.calcularProducaoPrevista(
                            		segTempoAtivo, 
                            		segCicloPadrao, 
                            		qtPcsCiclo,
                            		fatorContagem,
                            		dwci.getOmPt().getIndOee());

                            // verificar se existe... pode ser que nao tenho
                            // ocorrido parada no período analisado
                            
                            TotaisDetalhe totalDet = new TotaisDetalhe();
                            totalDet.qtdProd = qtBoa.doubleValue();
                            totalDet.qtdPrev = qtPrevista.doubleValue();
                            totalDet.indPerda = 0d;
                            totalDet.qtdPerdasPar = 0d;
                            totalDet.qtdPerdasKg = 0d;
                            totalDet.qtdPerdasTon = 0d;
                            totalDet.qtdPerdasUM = 0d;
                            totalDet.segTempoPar = 0d;
                            totalDet.qtdOcorrPar = 0d;
                            totalDet.segTempoMicroPar = 0d;
                            totalDet.qtdMicroPar = 0d;
                            totalDet.indMicroPar = 0d;
                            totalDet.isParComPeso = false;
                            
                            itemMol = new Molde();
                            itemMol.cdMolde = dwci.getDwFolha().getCdFolha();
                            itemMol.dsMolde = dwci.getDwFolha().getDsFolha();
                            itemMol.det = totalDet.cloneTotaisDetalhe(); 

                            itemTur = new Turno();
                            itemTur.cdTurno = dwci.getDwTurno().getCdTurno();
                            itemTur.dsTurno = dwci.getDwTurno().getDsTurno();
                            itemTur.det = new TotaisDetalhe();
                            itemTur.det = totalDet.cloneTotaisDetalhe();

                            itemMaq = new Maquina();
                            itemMaq.cdMaquina = dwci.getOmPt().getCdPt();
                            itemMaq.dsMaquina = dwci.getOmPt().getDsPt();
                            itemMaq.moldes.put(itemMol.cdMolde, itemMol.cloneMolde());
                            itemMaq.turnos.put(itemTur.cdTurno, itemTur.cloneTurno());

                            if (mapDetMaq.containsKey(itemMaq.cdMaquina)) {
                                if (!mapDetMaq.get(itemMaq.cdMaquina).moldesQtdProdPrev.containsKey(itemMol.cdMolde)) {
                                    mapDetMaq.get(itemMaq.cdMaquina).moldesQtdProdPrev.put(itemMol.cdMolde, itemMol);
                                    
                                } else {
                                    Molde cloneMolde = mapDetMaq.get(itemMaq.cdMaquina).moldesQtdProdPrev.get(itemMol.cdMolde).cloneMolde();

                                    cloneMolde.det.qtdProd += qtBoa.doubleValue();
                                    cloneMolde.det.qtdPrev += qtPrevista.doubleValue();
                                    cloneMolde.det.indPerda =  FormulasInjet.calcularEficiencia(
                                            new BigDecimal(cloneMolde.det.qtdPerdasPar),
                                            new BigDecimal(cloneMolde.det.qtdPrev)).doubleValue();                            
                                    
                                    mapDetMaq.get(itemMaq.cdMaquina).moldesQtdProdPrev.put(cloneMolde.cdMolde, cloneMolde);
                                }

                                // turno
                                if (!mapDetMaq.get(itemMaq.cdMaquina).turnos.containsKey(itemTur.cdTurno)) {
                                    mapDetMaq.get(itemMaq.cdMaquina).turnos.put(itemTur.cdTurno, itemTur);
                                    
                                } else {
                                    Turno cloneTur = mapDetMaq.get(itemMaq.cdMaquina).turnos.get(itemTur.cdTurno).cloneTurno();
                                    
                                    cloneTur.det.qtdProd += qtBoa.doubleValue();
                                    cloneTur.det.qtdPrev += qtPrevista.doubleValue();
                                    cloneTur.det.indPerda = FormulasInjet.calcularEficiencia(
                                            new BigDecimal(cloneTur.det.qtdPerdasPar),
                                            new BigDecimal(cloneTur.det.qtdPrev)).doubleValue();
                                    
                                    mapDetMaq.get(itemMaq.cdMaquina).turnos.put(cloneTur.cdTurno, cloneTur);
                                }                                    
                            } else {                                
                                mapDetMaq.put(itemMaq.cdMaquina, itemMaq);
                            }
                        }
                    }
                }
            }
        }
        

        //totalizar com base no item mais internos - parada e  produto
        Set<String> chavesMaquinaT = mapDetMaq.keySet();
        for (String keyMaq : chavesMaquinaT) {
            Set<String> chavesMoldeT = mapDetMaq.get(keyMaq).moldes.keySet();
                        
            for (String keyMol : chavesMoldeT) {
                // sub total do molde
                TotaisDetalhe subTotalMolde = mapDetMaq.get(keyMaq).moldes.get(keyMol).det.cloneTotaisDetalhe();
                
                // dados vinculados a parada
                subTotalMolde.segTempoMicroPar = 0d;
                subTotalMolde.segTempoPar = 0d;
                subTotalMolde.qtdOcorrPar = 0d;
                subTotalMolde.qtdMicroPar = 0d;
                // dados vinculados a qtd perdida
                subTotalMolde.qtdPerdasPar = 0d;
                subTotalMolde.qtdPerdasUM = 0d;
                subTotalMolde.qtdPerdasKg = 0d;
                subTotalMolde.qtdPerdasTon = 0d;
                
                //qtd boa e qtd prev
                if (mapDetMaq.get(keyMaq).moldesQtdProdPrev.get(keyMol) != null){
                	subTotalMolde.qtdProd = mapDetMaq.get(keyMaq).moldesQtdProdPrev.get(keyMol).det.qtdProd;
                	subTotalMolde.qtdPrev = mapDetMaq.get(keyMaq).moldesQtdProdPrev.get(keyMol).det.qtdPrev;
                
	                Set<String> chavesParadaT = mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.keySet();
	                for (String keyPar : chavesParadaT) {
	                    TotaisDetalhe subTotalParada = mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).det.cloneTotaisDetalhe();
	                    
	                    // atualizar dados das paradas do molde
	                    subTotalMolde.segTempoMicroPar += subTotalParada.segTempoMicroPar; 
	                    subTotalMolde.segTempoPar += subTotalParada.segTempoPar; 
	                    subTotalMolde.qtdOcorrPar += subTotalParada.qtdOcorrPar; 
	                    subTotalMolde.qtdMicroPar += subTotalParada.qtdMicroPar; 
	                    
	                    Set<String> chavesProdutoT = mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).produtos.keySet();
	                    for (String keyPro : chavesProdutoT) {
	                        TotaisDetalhe subTotalProduto = mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).produtos.get(keyPro).det.cloneTotaisDetalhe();
	 
	                        // atualizar qtd perdida do molde
	                        subTotalMolde.qtdPerdasPar += subTotalProduto.qtdPerdasPar;
	                        subTotalMolde.qtdPerdasUM += subTotalProduto.qtdPerdasUM;
	                        subTotalMolde.qtdPerdasKg += subTotalProduto.qtdPerdasKg;
	                        subTotalMolde.qtdPerdasTon += subTotalProduto.qtdPerdasTon;
	                    }
	                }
	                
	                mapDetMaq.get(keyMaq).moldes.get(keyMol).det = subTotalMolde;
                }
            }
        }
        
        
        
        
        detalhamento.setMaquinas(new ArrayList<GraficoBIParetoDetParOrdemMaquinaDTO>());

        Set<String> chavesMaquina = mapDetMaq.keySet();
        for (String keyMaq : chavesMaquina) {
            GraficoBIParetoDetParOrdemMaquinaDTO maq = new GraficoBIParetoDetParOrdemMaquinaDTO();
            maq.setFerramentas(new ArrayList<GraficoBIParetoDetParOrdemMaquinaFerramentaDTO>());
            maq.setTurnos(new ArrayList<GraficoBIParetoDetParOrdemMaquinaTurnoDTO>());

            maq.setCdMaquina(mapDetMaq.get(keyMaq).cdMaquina);
            maq.setDsMaquina(mapDetMaq.get(keyMaq).dsMaquina);

            maq.setSegTempoParadas(0d);
            maq.setQtOcorrParadas(0d);

            maq.setQtPerdasKg(0d);
            maq.setQtPerdasTon(0d);
            maq.setQtPerdasUB(0d);
            maq.setQtPerdasUM(0d);

            maq.setQtProd(0d);
            maq.setQtPrev(0d);
            maq.setIndPerda(0d);

            maq.setQtdOcorrMicroParadas(0d);
            maq.setSegTempoMicroParadas(0d);
            maq.setIndMicroParadas(0d);

            Set<String> chavesTurno = mapDetMaq.get(keyMaq).turnos.keySet();
            for (String keyTur : chavesTurno) {
                // totais da máquina
                maq.setSegTempoParadas(maq.getSegTempoParadas() + mapDetMaq.get(keyMaq).turnos.get(keyTur).det.segTempoPar);
                maq.setQtOcorrParadas(maq.getQtOcorrParadas() + mapDetMaq.get(keyMaq).turnos.get(keyTur).det.qtdOcorrPar);

                maq.setQtPerdasKg(maq.getQtPerdasKg() + mapDetMaq.get(keyMaq).turnos.get(keyTur).det.qtdPerdasKg);
                maq.setQtPerdasTon(maq.getQtPerdasTon() + mapDetMaq.get(keyMaq).turnos.get(keyTur).det.qtdPerdasTon);
                maq.setQtPerdasUB(maq.getQtPerdasUB() + mapDetMaq.get(keyMaq).turnos.get(keyTur).det.qtdPerdasPar);
                maq.setQtPerdasUM(maq.getQtPerdasUM() + mapDetMaq.get(keyMaq).turnos.get(keyTur).det.qtdPerdasUM);

                maq.setQtProd(maq.getQtProd() + mapDetMaq.get(keyMaq).turnos.get(keyTur).det.qtdProd);
                maq.setQtPrev(maq.getQtPrev() + mapDetMaq.get(keyMaq).turnos.get(keyTur).det.qtdPrev);
                maq.setIndPerda(FormulasInjet.calcularEficiencia(new BigDecimal(maq.getQtPerdasUB()), new BigDecimal(maq.getQtPrev()))
                        .doubleValue());

                maq.setQtdOcorrMicroParadas(maq.getQtdOcorrMicroParadas() + mapDetMaq.get(keyMaq).turnos.get(keyTur).det.qtdMicroPar);
                maq.setSegTempoMicroParadas(maq.getSegTempoMicroParadas() + mapDetMaq.get(keyMaq).turnos.get(keyTur).det.segTempoMicroPar);
                maq.setIndMicroParadas(FormulasInjet.calcularEficiencia(new BigDecimal(maq.getSegTempoMicroParadas()),
                        new BigDecimal(maq.getSegTempoParadas())).doubleValue());

                // totais do turno da máquina
                GraficoBIParetoDetParOrdemMaquinaTurnoDTO tur = new GraficoBIParetoDetParOrdemMaquinaTurnoDTO();
                tur.setCdTurno(mapDetMaq.get(keyMaq).turnos.get(keyTur).cdTurno);
                tur.setDsTurno(mapDetMaq.get(keyMaq).turnos.get(keyTur).dsTurno);

                tur.setSegTempoParadas(mapDetMaq.get(keyMaq).turnos.get(keyTur).det.segTempoPar);
                tur.setQtOcorrParadas(mapDetMaq.get(keyMaq).turnos.get(keyTur).det.qtdOcorrPar);

                tur.setQtPerdasKg(mapDetMaq.get(keyMaq).turnos.get(keyTur).det.qtdPerdasKg);
                tur.setQtPerdasTon(mapDetMaq.get(keyMaq).turnos.get(keyTur).det.qtdPerdasTon);
                tur.setQtPerdasUB(mapDetMaq.get(keyMaq).turnos.get(keyTur).det.qtdPerdasPar);
                tur.setQtPerdasUM(mapDetMaq.get(keyMaq).turnos.get(keyTur).det.qtdPerdasUM);

                tur.setQtProd(mapDetMaq.get(keyMaq).turnos.get(keyTur).det.qtdProd);
                tur.setQtPrev(mapDetMaq.get(keyMaq).turnos.get(keyTur).det.qtdPrev);
                tur.setIndPerda(FormulasInjet.calcularEficiencia(new BigDecimal(tur.getQtPerdasUB()), new BigDecimal(tur.getQtPrev()))
                        .doubleValue());

                tur.setQtdOcorrMicroParadas(mapDetMaq.get(keyMaq).turnos.get(keyTur).det.qtdMicroPar);
                tur.setSegTempoMicroParadas(mapDetMaq.get(keyMaq).turnos.get(keyTur).det.segTempoMicroPar);
                tur.setIndMicroParadas(FormulasInjet.calcularEficiencia(new BigDecimal(tur.getSegTempoMicroParadas()),
                        new BigDecimal(tur.getSegTempoParadas())).doubleValue());

                if (tur.getQtOcorrParadas() > 0 || tur.getQtOcorrParadas() > 0) {
                    maq.getTurnos().add(tur);
                }
            }

            Set<String> chavesMolde = mapDetMaq.get(keyMaq).moldes.keySet();
            for (String keyMol : chavesMolde) {
                GraficoBIParetoDetParOrdemMaquinaFerramentaDTO mol = new GraficoBIParetoDetParOrdemMaquinaFerramentaDTO();
                mol.setParadas(new ArrayList<GraficoBIParetoDetParOrdemMaquinaFerramentaParadaDTO>());
                mol.setProdutos(new ArrayList<GraficoBIParetoDetParOrdemMaquinaFerramentaParadaProdutoDTO>());

                // totais do molde da máquina
                mol.setCdFerramenta(mapDetMaq.get(keyMaq).moldes.get(keyMol).cdMolde);
                mol.setDsFerramenta(mapDetMaq.get(keyMaq).moldes.get(keyMol).dsMolde);

                mol.setSegTempoParadas(mapDetMaq.get(keyMaq).moldes.get(keyMol).det.segTempoPar);
                mol.setQtOcorrParadas(mapDetMaq.get(keyMaq).moldes.get(keyMol).det.qtdOcorrPar);

                mol.setQtPerdasKg(mapDetMaq.get(keyMaq).moldes.get(keyMol).det.qtdPerdasKg);
                mol.setQtPerdasTon(mapDetMaq.get(keyMaq).moldes.get(keyMol).det.qtdPerdasTon);
                mol.setQtPerdasUB(mapDetMaq.get(keyMaq).moldes.get(keyMol).det.qtdPerdasPar);
                mol.setQtPerdasUM(mapDetMaq.get(keyMaq).moldes.get(keyMol).det.qtdPerdasUM);

                mol.setQtProd(mapDetMaq.get(keyMaq).moldes.get(keyMol).det.qtdProd);
                mol.setQtPrev(mapDetMaq.get(keyMaq).moldes.get(keyMol).det.qtdPrev);
                mol.setIndPerda(FormulasInjet.calcularEficiencia(new BigDecimal(mol.getQtPerdasUB()), new BigDecimal(mol.getQtPrev()))
                        .doubleValue());

                mol.setQtdOcorrMicroParadas(mapDetMaq.get(keyMaq).moldes.get(keyMol).det.qtdMicroPar);
                mol.setSegTempoMicroParadas(mapDetMaq.get(keyMaq).moldes.get(keyMol).det.segTempoMicroPar);
                mol.setIndMicroParadas(FormulasInjet.calcularEficiencia(new BigDecimal(mol.getSegTempoMicroParadas()),
                        new BigDecimal(mol.getSegTempoParadas())).doubleValue());

                Set<String> chavesParada = mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.keySet();
                for (String keyPar : chavesParada) {
                    GraficoBIParetoDetParOrdemMaquinaFerramentaParadaDTO par = new GraficoBIParetoDetParOrdemMaquinaFerramentaParadaDTO();
                    par.setProdutos(new ArrayList<GraficoBIParetoDetParOrdemMaquinaFerramentaParadaProdutoDTO>());

                    par.setIdTparada(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).idTParada);
                    par.setCdParada(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).cdParada);
                    par.setDsParada(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).dsParada);

                    par.setSegTempoParadas(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).det.segTempoPar);
                    par.setQtOcorrParadas(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).det.qtdOcorrPar);

                    par.setQtPerdasKg(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).det.qtdPerdasKg);
                    par.setQtPerdasTon(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).det.qtdPerdasTon);
                    par.setQtPerdasUB(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).det.qtdPerdasPar);
                    par.setQtPerdasUM(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).det.qtdPerdasUM);

                    par.setQtProd(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).det.qtdProd);
                    par.setQtPrev(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).det.qtdPrev);
                    par.setIndPerda(FormulasInjet.calcularEficiencia(new BigDecimal(par.getQtPerdasUB()), new BigDecimal(par.getQtPrev()))
                            .doubleValue());

                    par.setQtdOcorrMicroParadas(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).det.qtdMicroPar);
                    par.setSegTempoMicroParadas(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).det.segTempoMicroPar);
                    par.setIndMicroParadas(FormulasInjet.calcularEficiencia(new BigDecimal(par.getSegTempoMicroParadas()),
                            new BigDecimal(par.getSegTempoParadas())).doubleValue());

                    Set<String> chavesProduto = mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).produtos.keySet();
                    for (String keyPro : chavesProduto) {
                        GraficoBIParetoDetParOrdemMaquinaFerramentaParadaProdutoDTO pro = new GraficoBIParetoDetParOrdemMaquinaFerramentaParadaProdutoDTO();
                        pro.setCdProduto(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).produtos.get(keyPro).cdProduto);
                        pro.setDsProduto(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).produtos.get(keyPro).dsProduto);

                        pro.setQtPerdasKg(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).produtos.get(keyPro).det.qtdPerdasKg);
                        pro.setQtPerdasTon(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).produtos.get(keyPro).det.qtdPerdasTon);
                        pro.setQtPerdasUB(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).produtos.get(keyPro).det.qtdPerdasPar);
                        pro.setQtPerdasUM(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).produtos.get(keyPro).det.qtdPerdasUM);

                        pro.setQtProd(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).produtos.get(keyPro).det.qtdProd);
                        pro.setQtPrev(mapDetMaq.get(keyMaq).moldes.get(keyMol).paradas.get(keyPar).produtos.get(keyPro).det.qtdPrev);
                        pro.setIndPerda(FormulasInjet.calcularEficiencia(new BigDecimal(pro.getQtPerdasUB()),
                                new BigDecimal(pro.getQtPrev())).doubleValue());
                        par.getProdutos().add(pro);
                    }

                    mol.getParadas().add(par);
                }

                if (mol.getQtOcorrParadas() > 0 || mol.getQtdOcorrMicroParadas() > 0) {
                    maq.getFerramentas().add(mol);
                }
            }

            if (maq.getQtOcorrParadas() > 0 || maq.getQtdOcorrMicroParadas() > 0) {
                // resumo indicadores
                detalhamento.getResumoIndicadores().setPerdaUB(detalhamento.getResumoIndicadores().getPerdaUB() + maq.getQtPerdasUB());
                detalhamento.getResumoIndicadores().setPerdaUM(detalhamento.getResumoIndicadores().getPerdaUM() + maq.getQtPerdasUM());
                detalhamento.getResumoIndicadores().setPerdaKg(detalhamento.getResumoIndicadores().getPerdaKg() + maq.getQtPerdasKg());
                detalhamento.getResumoIndicadores().setPerdaTon(detalhamento.getResumoIndicadores().getPerdaTon() + maq.getQtPerdasTon());
                detalhamento.getResumoIndicadores().setTempoParadas(detalhamento.getResumoIndicadores().getTempoParadas() + maq.getSegTempoParadas());
                detalhamento.getResumoIndicadores().setTempoDisponivel(resumo.getTempoDisponivel());    
                detalhamento.getResumoIndicadores().setIndPar(FormulasInjet.calcularIndiceParada( new BigDecimal(detalhamento.getResumoIndicadores().getTempoParadas()),  new BigDecimal(detalhamento.getResumoIndicadores().getTempoDisponivel())).doubleValue());
                
                detalhamento.getMaquinas().add(maq);
            }
        }

        // ordenar ferramentas e turnos de cada máquina
        for (GraficoBIParetoDetParOrdemMaquinaDTO maquina : detalhamento.getMaquinas()) {
            Collections.sort(maquina.getTurnos(), new Comparator<GraficoBIParetoDetParOrdemMaquinaTurnoDTO>() {
                @Override
                public int compare(final GraficoBIParetoDetParOrdemMaquinaTurnoDTO o1, final GraficoBIParetoDetParOrdemMaquinaTurnoDTO o2) {
                    final GraficoBIParetoDetParOrdemMaquinaTurnoDTO item1 = o1;
                    final GraficoBIParetoDetParOrdemMaquinaTurnoDTO item2 = o2;
                    return (item1.getQtPerdasUB()).compareTo(item2.getQtPerdasUB()) * -1;
                }
            });

            Collections.sort(maquina.getFerramentas(), new Comparator<GraficoBIParetoDetParOrdemMaquinaFerramentaDTO>() {
                @Override
                public int compare(final GraficoBIParetoDetParOrdemMaquinaFerramentaDTO o1,
                        final GraficoBIParetoDetParOrdemMaquinaFerramentaDTO o2) {
                    final GraficoBIParetoDetParOrdemMaquinaFerramentaDTO item1 = o1;
                    final GraficoBIParetoDetParOrdemMaquinaFerramentaDTO item2 = o2;
                    return (item1.getQtPerdasUB()).compareTo(item2.getQtPerdasUB()) * -1;
                }
            });

            // ordernar paradas de cada ferramenta
            for (GraficoBIParetoDetParOrdemMaquinaFerramentaDTO ferramenta : maquina.getFerramentas()) {

                Collections.sort(ferramenta.getParadas(), new Comparator<GraficoBIParetoDetParOrdemMaquinaFerramentaParadaDTO>() {
                    @Override
                    public int compare(final GraficoBIParetoDetParOrdemMaquinaFerramentaParadaDTO o1,
                            final GraficoBIParetoDetParOrdemMaquinaFerramentaParadaDTO o2) {
                        final GraficoBIParetoDetParOrdemMaquinaFerramentaParadaDTO item1 = o1;
                        final GraficoBIParetoDetParOrdemMaquinaFerramentaParadaDTO item2 = o2;
                        return (item1.getQtPerdasUB()).compareTo(item2.getQtPerdasUB()) * -1;
                    }
                });

                // ordernar produtos de cada parada
                for (GraficoBIParetoDetParOrdemMaquinaFerramentaParadaDTO parada : ferramenta.getParadas()) {
                    Collections.sort(parada.getProdutos(), new Comparator<GraficoBIParetoDetParOrdemMaquinaFerramentaParadaProdutoDTO>() {
                        @Override
                        public int compare(final GraficoBIParetoDetParOrdemMaquinaFerramentaParadaProdutoDTO o1,
                                final GraficoBIParetoDetParOrdemMaquinaFerramentaParadaProdutoDTO o2) {
                            final GraficoBIParetoDetParOrdemMaquinaFerramentaParadaProdutoDTO item1 = o1;
                            final GraficoBIParetoDetParOrdemMaquinaFerramentaParadaProdutoDTO item2 = o2;
                            return (item1.getQtPerdasUB()).compareTo(item2.getQtPerdasUB()) * -1;
                        }
                    });
                }

            }

        }

        // ordenar lista de máquinas
        Collections.sort(detalhamento.getMaquinas(), new Comparator<GraficoBIParetoDetParOrdemMaquinaDTO>() {
            @Override
            public int compare(final GraficoBIParetoDetParOrdemMaquinaDTO o1, final GraficoBIParetoDetParOrdemMaquinaDTO o2) {
                final GraficoBIParetoDetParOrdemMaquinaDTO item1 = o1;
                final GraficoBIParetoDetParOrdemMaquinaDTO item2 = o2;
                return (item1.getQtPerdasUB()).compareTo(item2.getQtPerdasUB()) * -1;
            }
        });

        return detalhamento;
    }

     
    
    // Retorna a lista de CIPs
    private List<CIPDTO> getListaCips(List<DwConsolid> ids) {
        List<CIPDTO> retorno = new ArrayList<>();
        MapQuery q = new MapQuery(getDaoSession());
        q.append("select a");
        q.append("from DwConsolciplog a");
        q.append("where a.omPt = :ompt");
        q.append("and a.dwConsolidByIdConsolidInicio.ppCp = :ppcp");
        q.append("order by a.idConsolciplog desc");

        for (DwConsolid id : ids) {
            q.defineParametro("ompt", id.getOmPt());
            q.defineParametro("ppcp", id.getPpCp());
            List<DwConsolciplog> lista = q.list();
            for (DwConsolciplog log : lista) {
                CIPDTO dto = new CIPDTO();

                dto.setFimCIP(log.getDthrFcip());
                if (log.getDwConsolidByIdConsolidFim() != null)
                    dto.setFimId(log.getDwConsolidByIdConsolidFim().clone(false));

                if (log.getDwConsolpalogByIdConsolpalogEntrada() != null)
                    dto.setFimParada(log.getDwConsolpalogByIdConsolpalogEntrada().getDthrIparada());

                if (log.getOmUsrByIdUsrEntrada() != null)
                    dto.setInicioUsuario(log.getOmUsrByIdUsrEntrada().clone(false));

                dto.setInicioCIP(log.getDthrIcip());
                if (log.getDwConsolidByIdConsolidInicio() != null)
                    dto.setInicioId(log.getDwConsolidByIdConsolidInicio().clone(false));
                if (log.getDwConsolpalogByIdConsolpalogSaida() != null)
                    dto.setInicioParada(log.getDwConsolpalogByIdConsolpalogSaida().getDthrIparada());

                if (log.getOmUsrByIdUsrSaida() != null)
                    dto.setFimUsuario(log.getOmUsrByIdUsrSaida().clone(false));

                dto.setOmpt(log.getOmPt().clone(false));
                dto.setPpcp(id.getPpCp().clone(false));

                retorno.add(dto);
            }
        }
        return retorno;
    }

    public DetalheMonitorizacaoPTInjetDTO getRetorno() {
        return retorno;
    }

    public void setRetorno(DetalheMonitorizacaoPTInjetDTO retorno) {
        this.retorno = retorno;
    }
}
