package idw.model.rn.web.vf.monitorizacao.detalhe;

import java.awt.Color;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmedparamlog;
import idw.model.pojos.DwFolhamedtemhor;
import idw.model.pojos.DwFolhamedtemp;
import idw.model.pojos.DwFolhamedtemphorcfg;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwConsolidTemplate.TpId;
import idw.model.rn.AbstractRN;
import idw.model.rn.CpRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTFornoRN;
import idw.model.rn.injet.PlanejamentoInjetRN;
import idw.model.rn.monitorizacao.cep.MonitorizacaoCEPRN;
import idw.model.rn.monitorizacao.injet.DetalheMonitorizacaoPTInjetRN;
import idw.model.rn.web.injet.monitorizacao.detalhe.DetalheMonitorizacaoWebCepInjetRN;
import idw.util.Cor;
import idw.util.IdwLogger;
import idw.webservices.dto.DetalheCEPDTO;
import idw.webservices.dto.DetalheMonitorizacaoCEPDTO;
import idw.webservices.dto.DetalheMonitorizacaoCEPOcorrDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.FiltroGraficoDetalhePtDTO;
import idw.webservices.dto.GraficoCEPDTO;
import idw.webservices.dto.GraficoCEPDetParamDTO;
import idw.webservices.dto.GraficoCEPPeriodoDTO;
import idw.webservices.dto.GraficoDetalhePtFornoDTO;
import idw.webservices.dto.IndicadoresEstatisticosCEPDTO;
import idw.webservices.dto.ListaParametrosCEPDTO;
import idw.webservices.dto.ParametroCEPDTO;
import idw.webservices.dto.PeriodoDTO;
import idw.webservices.rest.dto.monitorizacao.ComboDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroGraficoCepDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoCepProcessoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoCepValoresDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoCepXDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaCepDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaGraficoCepDTO;
import ms.util.ConversaoTipos;

public class DetalheMonitorizacaoWebCepRN extends AbstractRN<DAOGenerico> {
	
	public static final byte FILTRO_PERIODO_POR_HORA = 1;
	public static final byte FILTRO_PERIODO_POR_DATA_TURNO = 2;
	public static final byte FILTRO_PERIODO_POR_DATA = 3;
	
	public static final byte CEP_REFERENCIA_TEMPO_TOTAL = 0;
    public static final byte CEP_REFERENCIA_TEMPO_TRABALHADO = 1;
    public static final byte CEP_REFERENCIA_TEMPO_PARADA_COM_PESO = 2;
    public static final byte CEP_REFERENCIA_TEMPO_PARADA_SEM_PESO = 3;
    
    public static final byte GRAFICO_CNC_POR_DATA = 4;
    
    public static final String DESCRICAO_BASE_CHAVE = "LISTA_DETALHE_CEP_PARAM_";

	private final String formatoData;
	private final String formatoDataHora;
	
	public DetalheMonitorizacaoWebCepRN(String formatoData, String formatoDataHora) {
        this(new DAOGenerico(), formatoData, formatoDataHora);
    }

    public DetalheMonitorizacaoWebCepRN(DAOGenerico dao, String formatoData, String formatoDataHora) {
        super(dao);
        this.formatoData = formatoData;
        this.formatoDataHora = formatoDataHora;
    }
    
    public List<ComboDTO> getParametrosCEP() {
    	List<ComboDTO> listaDTO = new ArrayList<ComboDTO>();
    	
    	MonitorizacaoCEPRN monitorizacaoCEPRN = new MonitorizacaoCEPRN(this.getDao());
    	ListaParametrosCEPDTO lista = monitorizacaoCEPRN.getListaParametrosCEP(false);
    	for(ParametroCEPDTO parametro : lista.getParametrosCEP()) {
    		ComboDTO dto = new ComboDTO();
    		dto.setId(parametro.getIdFtParam());

    		if(parametro.getIdFtParam()!=null){
    			dto.setDsView(DESCRICAO_BASE_CHAVE + String.valueOf(parametro.getIdFtParam()) ); //181009	
    		}
    		//181009 dto.setDsView(parametro.getDsParametro());
    		listaDTO.add(dto);
    	}
    	
    	return listaDTO;
    }
    
    public ListaParametrosCEPDTO getFiltroParametro(long id) {
    	ListaParametrosCEPDTO parametros = new ListaParametrosCEPDTO();
    	
    	MonitorizacaoCEPRN monitorizacaoCEPRN = new MonitorizacaoCEPRN(this.getDao());
    	ListaParametrosCEPDTO lista = monitorizacaoCEPRN.getListaParametrosCEP(false);
    	for(ParametroCEPDTO parametro : lista.getParametrosCEP()) {
    		if(parametro.getIdFtParam() == id) {
    			parametros.setParametrosCEP(new ArrayList<ParametroCEPDTO>());
    			parametros.getParametrosCEP().add(parametro);
    			break;
    		}
    	}
    	 
    	return parametros;
    }
    
    public GraficoCepXDTO getGraficoCepX(FiltroGraficoCepDTO filtro, FiltroDetalhePTInjetDTO filtroDetalhe) throws RegistroDesconhecidoException {
    	
    	ajustarFiltro(filtroDetalhe, filtro.getFiltroDetalhePosto().getCdPosto());
    	
    	filtroDetalhe.setTpId(TpId.TURNO.getValue());
    	filtroDetalhe.setDthrIhora(null);
    	filtroDetalhe.setDthrFhora(null);
//    	DAOGenericoInjet daoInj = new DAOGenericoInjet();
//    	List<PeriodoDTO> listaPeriodosOP = new ArrayList<>();
	//	PlanejamentoInjetRN ijRN = new PlanejamentoInjetRN(this.getDao());
		
//		List<DwConsolid> listaDwconsolid; 
//		DetalheMonitorizacaoPTInjetRN rnptInjet = new DetalheMonitorizacaoPTInjetRN(daoInj.getDao());
//		IdwLogger log = new IdwLogger("getDetalheCEPGraf2INJET");
//		listaDwconsolid = rnptInjet.pesquisarDwConsolids(log, filtroDetalhe);	
//		DwConsolid id  =  listaDwconsolid.get(0);
//		
//			String cdCP = id.getPpCp().getCdCp();
//			String cdPt = id.getOmPt().getCdPt();
//			Date dthrIniTur = id.getDthrIturno();
//			Date dthrFimTur = id.getDthrFturno();
//		
//		listaPeriodosOP = ijRN.getPeriodosOPTurno(filtro.getFiltroDetalhePosto().getCdPosto(), filtro.getFiltroDetalhePosto().getCdCp(), dthrIniTur, dthrFimTur);
    	MonitorizacaoCEPRN rn = new MonitorizacaoCEPRN(getDao());
    	GraficoCEPDTO grafico = rn.getGraficoCEP2(
    			GRAFICO_CNC_POR_DATA, 
    			CEP_REFERENCIA_TEMPO_TOTAL, 
    			getFiltroParametro(filtro.getParametro()), 
    			filtroDetalhe);
    	//PeriodoDTO teste = new PeriodoDTO();
    	//teste.setDtHrFim(DataHoraRN.toDateFromYYYYMMDDHHMISS(filtroDetalhe.get))
    	//teste.setDtHrInicio(new Date(arg0));iltro.
    	//List<DetalheMonitorizacaoCEPOcorrDTO> retorno =	rn.getListaOcorrenciasCEPInjet(GRAFICO_CNC_POR_DATA, filtro.getParametro(), (long)0, filtroDetalhe.get, filtro.getFiltroDetalhePosto().getCdPosto());

    	
    	
		//GRAFICO_CNC_RESUMO, 
		//CEP_REFERENCIA_TEMPO_TOTAL,
    	GraficoCepXDTO dto = new GraficoCepXDTO();
//    	List<GraficoCepValoresDTO> t = (getValores(grafico,filtro.getParametro()));	
//    	List<GraficoCepValoresDTO> aux = new ArrayList<GraficoCepValoresDTO>();
//    	for (DetalheMonitorizacaoCEPOcorrDTO a : retorno){
//			GraficoCepValoresDTO valor = new GraficoCepValoresDTO();
//			valor.setLabel(a.getDthrMedicao().toString());
//			valor.setLimInf(t.get(0).getLimInf());
//			valor.setLimSup(t.get(0).getLimSup());
//			valor.setParametro(t.get(0).getParametro());
//			valor.setMeta(t.get(0).getMeta());
//			valor.setValor(a.getVlrLido().toString());
//		
//			aux.add(valor);
//		}
//    	
//    	
    	dto.setValores(getValores(grafico,filtro.getParametro()));	
    	
    	if (grafico.getIndicadoresEstatisticos().size() == 0) {
    		preencherIndicadores(new IndicadoresEstatisticosCEPDTO(), dto);
    	} else {
    		preencherIndicadores(grafico.getIndicadoresEstatisticos().get(0), dto);
    	}
    	
    	
    	return dto;
    }
    
    public GraficoCepXDTO getGraficoCepX2(FiltroGraficoCepDTO filtro, FiltroDetalhePTInjetDTO filtroDetalhe) throws RegistroDesconhecidoException {
    	
    	ajustarFiltro(filtroDetalhe, filtro.getFiltroDetalhePosto().getCdPosto());
    	
    	MonitorizacaoCEPRN rn = new MonitorizacaoCEPRN(getDao());
    	GraficoCEPDTO grafico = rn.getGraficoCEP3(
    			FILTRO_PERIODO_POR_HORA, 
    			CEP_REFERENCIA_TEMPO_TOTAL, 
    			getFiltroParametro(filtro.getParametro()), 
    			filtroDetalhe);
    	
    	GraficoCepXDTO dto = new GraficoCepXDTO();
    	
    	dto.setValores(getValores(grafico,filtro.getParametro()));	
    	
    	if (grafico.getIndicadoresEstatisticos().size() == 0) {
    		preencherIndicadores(new IndicadoresEstatisticosCEPDTO(), dto);
    	} else {
    		preencherIndicadores(grafico.getIndicadoresEstatisticos().get(0), dto);
    	}
    	
    	
    	return dto;
    }
    
    public List<TabelaCepDTO> getCepTabela(FiltroGraficoCepDTO filtro, FiltroDetalhePTInjetDTO filtroDetalhe) throws RegistroDesconhecidoException {
    	
    	ajustarFiltro(filtroDetalhe, filtro.getFiltroDetalhePosto().getCdPosto());
    	
    	filtroDetalhe.setTpId(TpId.TURNO.getValue());
    	filtroDetalhe.setDthrIhora(null);
    	filtroDetalhe.setDthrFhora(null);
    	
    	MonitorizacaoCEPRN rn = new MonitorizacaoCEPRN(getDao());
    	DetalheCEPDTO consulta = rn.getDetalheCEPGraf2(
    			GRAFICO_CNC_POR_DATA, 
    			CEP_REFERENCIA_TEMPO_TOTAL, 
    			filtro.getParametro(), 
    			filtroDetalhe);
    	
    	List<DetalheMonitorizacaoCEPDTO> lista = new ArrayList<DetalheMonitorizacaoCEPDTO>();
    	if (consulta != null && consulta.getListaFolhasCEP() != null && consulta.getListaFolhasCEP().getListaFolhas() != null && consulta.getListaFolhasCEP().getListaFolhas().isEmpty() == false) {
            lista = consulta.getListaFolhasCEP().getListaFolhas().get(0).getListaDetalheCEP().getDetMonitorizacaoCEP();
        }
    	
    	return getListaTabelaCepDTO(lista);
    }

    public List<TabelaGraficoCepDTO> getCepTabelaGrafico(FiltroGraficoCepDTO filtro, FiltroDetalhePTInjetDTO filtroDetalhe) throws RegistroDesconhecidoException {
    	
    	ajustarFiltro(filtroDetalhe, filtro.getFiltroDetalhePosto().getCdPosto());
    	
    	filtroDetalhe.setTpId(TpId.TURNO.getValue());
    	filtroDetalhe.setDthrIhora(null);
    	filtroDetalhe.setDthrFhora(null);
    	
    	MonitorizacaoCEPRN rn = new MonitorizacaoCEPRN(getDao());
    	DetalheCEPDTO consulta = rn.getDetalheCEPGraf2(
    			GRAFICO_CNC_POR_DATA, 
    			CEP_REFERENCIA_TEMPO_TOTAL, 
    			0L, 
    			filtroDetalhe);
    	
    	List<DetalheMonitorizacaoCEPDTO> lista = new ArrayList<DetalheMonitorizacaoCEPDTO>();
    	if (consulta != null && consulta.getListaFolhasCEP() != null && consulta.getListaFolhasCEP().getListaFolhas() != null && consulta.getListaFolhasCEP().getListaFolhas().isEmpty() == false) {
            lista = consulta.getListaFolhasCEP().getListaFolhas().get(0).getListaDetalheCEP().getDetMonitorizacaoCEP();
        }
    	List<TabelaCepDTO> listaTabelacepdto = new ArrayList<TabelaCepDTO>();
    	listaTabelacepdto = getListaTabelaCepDTO(lista);
    	
    	List<TabelaGraficoCepDTO> listatabelagraficocepdtopRetorno = new ArrayList<TabelaGraficoCepDTO>();
    	
    	if (listaTabelacepdto!=null && listaTabelacepdto.size()>0 && listaTabelacepdto.get(0)!=null){
    		for (TabelaCepDTO tabelaCepDTO : listaTabelacepdto){
    			FiltroGraficoCepDTO filtrotabelagraficocepDTO = new FiltroGraficoCepDTO();
    			TabelaGraficoCepDTO tabelagraficocepDTO = new TabelaGraficoCepDTO();

    			filtrotabelagraficocepDTO.setFiltroDetalhePosto(filtro.getFiltroDetalhePosto());
    			filtrotabelagraficocepDTO.setParametro(tabelaCepDTO.getIdFtParam());
    			filtrotabelagraficocepDTO.setPeriodo(filtro.getPeriodo());
    			filtrotabelagraficocepDTO.setReferencia(filtro.getReferencia());
    			
    			tabelagraficocepDTO.setTabelaCepDTO(tabelaCepDTO);
    			tabelagraficocepDTO.setFiltro(filtro);
    			listatabelagraficocepdtopRetorno.add(tabelagraficocepDTO);
    		}
    	}

    	return listatabelagraficocepdtopRetorno;
    }
    
    public List<GraficoCepProcessoDTO> getGraficoCepProcesso(FiltroGraficoCepDTO filtro) throws RegistroDesconhecidoException {
    	    	
    	FiltroGraficoDetalhePtDTO filtroDetalhe = new FiltroGraficoDetalhePtDTO();
    	
    	OmPt posto = new OmPt();
    	posto.setCdPt(filtro.getFiltroDetalhePosto().getCdPosto());
    
    	filtroDetalhe.setOmPt(posto);
    	
    	
    	if (IdwFacade.IS_IDW_ATIVO == true) {
        	CpRN cpRN = new CpRN(getDao());
        	PpCp cp = cpRN.pesquisarPpCpByCdCpCdPt(
        			filtro.getFiltroDetalhePosto().getCdCp(), 
        			filtro.getFiltroDetalhePosto().getCdPosto());
        	if(cp!=null && cp.getId()!=null){
        		filtroDetalhe.setIdCp(cp.getId());	
        	}
    	}else {
    		// Realizar consulta pela op no injet web
    		PpCp ppcp = new PpCp();
        	ppcp.setCdCp(filtro.getFiltroDetalhePosto().getCdCp());
        	filtroDetalhe.setPpCp(ppcp);
    	}
    	
    	// converte string data no padrão: 21 August, 2018 10:10:37 para data
    	//filtroDetalhe.setDtReferencia(DataHoraRN.stringToDate(filtro.getFiltroDetalhePosto().getDtHrReferenciaInicial()));
    	filtroDetalhe.setDtReferencia(DataHoraRN.stringToDate(filtro.getFiltroDetalhePosto().getDtHrReferenciaInicial(), formatoDataHora));
    	
    	
    	DwTurno turno = new DwTurno();
    	turno.setIdTurno(filtro.getFiltroDetalhePosto().getIdTurno());
    	filtroDetalhe.setDwTurno(turno);
    	    	
    	filtroDetalhe.setTpId((byte) filtro.getParametro());
    	
    	DetalheMonitorizacaoPTFornoRN rn = new DetalheMonitorizacaoPTFornoRN(getDao());
    	GraficoDetalhePtFornoDTO consulta = rn.getGraficoPtForno(filtroDetalhe);
    	
    	return getGraficoProcessoDTO(consulta);
    }
    
    public List<GraficoCepProcessoDTO> getGraficoXCepProcesso(FiltroGraficoCepDTO filtro) throws RegistroDesconhecidoException {
    	
    	FiltroGraficoDetalhePtDTO filtroDetalhe = new FiltroGraficoDetalhePtDTO();
    	
    	OmPt posto = new OmPt();
    	posto.setCdPt(filtro.getFiltroDetalhePosto().getCdPosto());
    	filtroDetalhe.setOmPt(posto);
    	
    	if (IdwFacade.IS_IDW_ATIVO == true) {
        	CpRN cpRN = new CpRN(getDao());
        	PpCp cp = cpRN.pesquisarPpCpByCdCpCdPt(
        			filtro.getFiltroDetalhePosto().getCdCp(), 
        			filtro.getFiltroDetalhePosto().getCdPosto());
        	if(cp!=null && cp.getId()!=null){
        		filtroDetalhe.setIdCp(cp.getId());	
        	}
    	}
    	
    	// converte string data no padrão: 21 August, 2018 10:10:37 para data
    	//filtroDetalhe.setDtReferencia(DataHoraRN.stringToDate(filtro.getFiltroDetalhePosto().getDtHrReferenciaInicial()));
    	filtroDetalhe.setDtReferencia(DataHoraRN.stringToDate(filtro.getFiltroDetalhePosto().getDtHrReferenciaInicial(), formatoDataHora));
    	
    	
    	DwTurno turno = new DwTurno();
    	filtroDetalhe.setDthrIhora(null);
    	filtroDetalhe.setDthrFhora(null);
    	turno.setIdTurno(filtro.getFiltroDetalhePosto().getIdTurno());
    	filtroDetalhe.setDwTurno(turno);
    	    	
    	filtroDetalhe.setTpId((byte) filtro.getParametro());
    	
    	DetalheMonitorizacaoPTFornoRN rn = new DetalheMonitorizacaoPTFornoRN(getDao());
    	GraficoDetalhePtFornoDTO consulta = rn.getGraficoPtForno(filtroDetalhe);
    	
    	return getGraficoProcessoDTO(consulta);
    }
    // Fonte Netbeans: DetalheMonitorizacaoPTTempMain.gerarGraficoCEP()
    private void ajustarFiltro(FiltroDetalhePTInjetDTO filtroDetalhe, String cdPt) throws RegistroDesconhecidoException {
    	PTRN ptrn = new PTRN(getDao());
    	
    	OmPt pt = ptrn.getOmPt(cdPt).clone();
    	filtroDetalhe.setOmPt(pt);
    	
    	Date dthrAtual = new Date();
        Date dthrInicio = dthrAtual;
        Date dthrFim = dthrAtual;
        
        if (filtroDetalhe.getAnoInicial() != null) {
            dthrInicio = DataHoraRN.setAnoNaData(dthrInicio, filtroDetalhe.getAnoFinal());
            dthrInicio = DataHoraRN.setMesNaData(dthrInicio, filtroDetalhe.getMesFinal());
            dthrInicio = DataHoraRN.setDiaNaData(dthrInicio, 1);
            dthrInicio = DataHoraRN.getUltimoDiaDoMesDaData(dthrInicio);
            dthrInicio = DataHoraRN.setHoraNaData(dthrInicio, 0, 0, 0);
            dthrFim = DataHoraRN.setHoraNaData(dthrInicio, 23, 59, 59);                                
        } else {
            if (filtroDetalhe.getDtReferenciaFinal() != null) {
            	dthrInicio = filtroDetalhe.getDtReferenciaFinal();
            } else {
            	dthrInicio = filtroDetalhe.getDtReferencia();
                dthrInicio = DataHoraRN.setHoraNaData(dthrInicio, 0, 0, 0);
                dthrFim = DataHoraRN.setHoraNaData(dthrInicio, 23, 59, 59);  
            }
        }

        if(dthrInicio.compareTo(dthrAtual) > 0) {
            dthrFim = dthrAtual;
            dthrInicio = DataHoraRN.adicionaSegundosNaData(dthrFim, (86400-1)*-1);
        }
        
        filtroDetalhe.setAnoInicial(null);
        filtroDetalhe.setAnoFinal(null);
        filtroDetalhe.setDthrIhora(dthrInicio);
        filtroDetalhe.setDthrFhora(dthrFim);
        filtroDetalhe.setTpId((byte) 0);
    }
    
    // Fonte Netbeans: GraficoAbstractPadraoLinhaView.createLinhas();
    private List<GraficoCepValoresDTO> getValores(GraficoCEPDTO graficoCEP, long idFtParam) {
    	
    	//graficoCEP.
    	List<GraficoCepValoresDTO> retorno = new ArrayList<GraficoCepValoresDTO>();

    	if (MonitorizacaoCEPRN.getIsTemperaturaZona(idFtParam)) {    	
	        Collections.sort(graficoCEP.getItemGrafico(), new Comparator<GraficoCEPPeriodoDTO>() {
	            @Override
	            public int compare(GraficoCEPPeriodoDTO o1, GraficoCEPPeriodoDTO o2) {
	                int retorno = 0;
	                retorno = o1.getZona().compareTo(o2.getZona());
	                return retorno;
	            }
	        });
	        
	        for (GraficoCEPPeriodoDTO dto : graficoCEP.getItemGrafico()) {
	        	
	            for (GraficoCEPDetParamDTO par : dto.getParametros()) {
	                double valorSomado;
	                valorSomado = par.getDetParam().getVlMedio().doubleValue();
	                //par.getDetParam().setVlUltimo();
	                //par.getDetParam().getVlUltimo();
	                double valorMonetario = par.getDetParam().getVlMedio().doubleValue();
	                
	                GraficoCepValoresDTO valorDTO = new GraficoCepValoresDTO();                
	                valorDTO.setValor(ConversaoTipos.converteParaString(valorSomado, 2));
	                valorDTO.setValorMonetario(ConversaoTipos.converteParaString(valorMonetario, 2));
	                valorDTO.setParametro(par.getDsFtParam());
	               
	                //180828 ERA PARA TESTE valorDTO.setMeta(ConversaoTipos.converteParaString(valorSomado * 1.25, 2));
	                // valorDTO.setMeta(valorDTO.getValor());
	                // valorDTO.setMeta(ConversaoTipos.converteParaString(valorSomado * 1.25, 2));
	                valorDTO.setMeta(ConversaoTipos.converteParaString(valorSomado, 2));//TODO: fazer vir de cadastro
	                
	                if (dto!=null && dto.getZona()!=null){
	                	valorDTO.setLabel("Zona " + dto.getZona().toString());	
	                }
	                else{
	                	valorDTO.setLabel(" ");
	                }
	                retorno.add(valorDTO);
	            }
	        }
    	} else {
            Collections.sort(graficoCEP.getItemGrafico(), new Comparator<GraficoCEPPeriodoDTO>() {
                @Override
                public int compare(GraficoCEPPeriodoDTO o1, GraficoCEPPeriodoDTO o2) {
                    int retorno = 0;
                    if (o1.getDthrIni() != null)
                        retorno = o1.getDthrIni().compareTo(o2.getDthrIni());
                    else if (o1.getDtTurno() != null && o1.getCdTurno() != null)
                        retorno = o1.getDtTurno().compareTo(o2.getDtTurno());
                    else if (o1.getDtTurno() != null) {
                        retorno = o1.getDtTurno().compareTo(o2.getDtTurno());
                        if (retorno == 0)
                            retorno = o1.getCdTurno().compareTo(o2.getCdTurno());
                    }
                    return retorno;
                }
            });
            
            for (GraficoCEPPeriodoDTO dto : graficoCEP.getItemGrafico()) {
                for (GraficoCEPDetParamDTO par : dto.getParametros()) {
                    double valorSomado;
                    // Se a variavel apresentada for FATOR DE POTENCIA ou qq TENSAO ou CORRENTE, mostrar a media, ao contrario mostrar o valor somado
                    if (
                    		par.getIdFtParam().equals(7L) // fator de potencia
                         || par.getIdFtParam().equals(1L) // corrente
                         || par.getIdFtParam().equals(4L) // tensao
                         || par.getIdFtParam().equals(20L) // VELOCIDADE
                         || (par.getIdFtParam()>=8L && par.getIdFtParam() <= 16L)
                     //    || (par.getIdFtParam()>=20L && par.getIdFtParam() <= 26L) // ou VELOCIDADE ou qq PRESSAO
                        ) {
                        valorSomado = par.getDetParam().getVlMedio().doubleValue();
                    } if ( par.getIdFtParam().equals(5L) || (par.getIdFtParam()>=17L && par.getIdFtParam() <= 20L) ) {// temperaturas
                        valorSomado = par.getDetParam().getVlMaximo().doubleValue();
                    } else {
                        valorSomado = par.getDetParam().getVlSomado().doubleValue();
                    }
                    
                    if ( par.getIdFtParam().equals(6L) ){ //energia consumida (em kwh)
                    	valorSomado =  valorSomado / 1000L;
                    }
                    
                    double valorMonetario = par.getDetParam().getVlMonetario().doubleValue();
                  
            
                    GraficoCepValoresDTO valorDTO = new GraficoCepValoresDTO();                
                    valorDTO.setValor(ConversaoTipos.converteParaString(valorSomado, 2));
                    valorDTO.setValorMonetario(ConversaoTipos.converteParaString(par.getDetParam().getVlMedio().doubleValue(), 2));
                    valorDTO.setParametro(par.getDsFtParam());
                    
                    
                    if (dto.getDthrIni() != null) {
                    	valorDTO.setLabel(DataHoraRN.dateToStringDDMMYYYYHHMMSS(dto.getDthrIni()));
                    } else if (dto.getDtTurno() != null && dto.getCdTurno() != null) {
                    	valorDTO.setLabel(DataHoraRN.dateToStringDDMMYYYY(dto.getDtTurno()) + "-" + dto.getCdTurno());
                    } else if (dto.getDtTurno() != null) {
                    	valorDTO.setLabel(DataHoraRN.dateToStringDDMMYYYY(dto.getDtTurno()));
                    }
                    
                    if (IdwFacade.IS_IDW_ATIVO == false) {
                    	if (par.getDetParam().getFolhaCEPSemListas().getLimIdealIni() != null) {
                            valorDTO.setMeta(ConversaoTipos.converteParaString(par.getDetParam().getFolhaCEPSemListas().getLimIdealIni(),3));
                            valorDTO.setLimInf(ConversaoTipos.converteParaString(par.getDetParam().getFolhaCEPSemListas().getLimCriticoInf(),3));
                            valorDTO.setLimSup(ConversaoTipos.converteParaString(par.getDetParam().getFolhaCEPSemListas().getLimCriticoSup(),3));
                           
                    	} else {
                            valorDTO.setMeta("");
                            valorDTO.setLimInf("");
                            
                            valorDTO.setLimSup("");                    	
                    	}
                    }
                    
                    retorno.add(valorDTO);
                }
            }    		
    	}
	        
    	
        
        return retorno;
    }
   
    
    private void preencherIndicadores(IndicadoresEstatisticosCEPDTO indicadores, GraficoCepXDTO dto) {
    	dto.setLscx(indicadores.getLsc_X() == null ? "-" : ConversaoTipos.converteParaString(indicadores.getLsc_X(), 4));
    	dto.setLcx(indicadores.getLc_X() == null ? "-" : ConversaoTipos.converteParaString(indicadores.getLc_X(), 4));
    	dto.setLicx(indicadores.getLic_X() == null ? "-" : ConversaoTipos.converteParaString(indicadores.getLic_X(), 4));
    	dto.setLscr(indicadores.getLsc_R() == null ? "-" : ConversaoTipos.converteParaString(indicadores.getLsc_R(), 4));
    	dto.setLcr(indicadores.getLc_R() == null ? "-" : ConversaoTipos.converteParaString(indicadores.getLc_R(), 4));
    	dto.setLicr(indicadores.getLic_R() == null ? "-" : ConversaoTipos.converteParaString(indicadores.getLic_R(), 4));
    	
        dto.setM(indicadores.getM() == null ? "-" : indicadores.getM().toString());
        dto.setN(indicadores.getN() == null ? "-" : indicadores.getN().toString());
        dto.setDesvioPadrao(indicadores.getDesvioPadrao() == null ? "-" : ConversaoTipos.converteParaString(indicadores.getDesvioPadrao(), 4));

        dto.setCp(indicadores.getCp() == null ? "-" : ConversaoTipos.converteParaString(indicadores.getCp(), 4));
    	dto.setCpi(indicadores.getCpi() == null ? "-" : ConversaoTipos.converteParaString(indicadores.getCpi(), 4));
    	dto.setCps(indicadores.getCps() == null ? "-" : ConversaoTipos.converteParaString(indicadores.getCps(), 4));
    	dto.setCpk(indicadores.getCpk() == null ? "-" : ConversaoTipos.converteParaString(indicadores.getCpk(), 4));
    }
    
    private List<GraficoCepProcessoDTO> getGraficoProcessoDTO(GraficoDetalhePtFornoDTO graficoDTO) {
    	List<GraficoCepProcessoDTO> listaDTO = new ArrayList<GraficoCepProcessoDTO>();
    	
        if (graficoDTO.getListaDwConsolMedParamLog() != null && !graficoDTO.getListaDwConsolMedParamLog().isEmpty()) {
            Collections.sort(graficoDTO.getListaDwConsolMedParamLog(), new Comparator<DwConsolmedparamlog>() {
                @Override
                public int compare(DwConsolmedparamlog o1, DwConsolmedparamlog o2) {
                    return o1.getDthrMedicao().compareTo(o2.getDthrMedicao());
                }
            });
            for (DwConsolmedparamlog dwconsolmedparamlog : graficoDTO.getListaDwConsolMedParamLog()) {
                BigDecimal valorLido = dwconsolmedparamlog.getVlrLido();
                GraficoCepProcessoDTO dto = new GraficoCepProcessoDTO();
                dto.setLabel(DataHoraRN.dateToStringDDMMYYYYHHMMSS(dwconsolmedparamlog.getDthrMedicao()));
                dto.setValor(ConversaoTipos.converteParaString(valorLido, 1));
                dto.setDataLeitura(DataHoraRN.dateToStringDDMMYYYYHHMMSS(dwconsolmedparamlog.getDthrMedicao()));
                dto.setCor(getCorCepProcesso(graficoDTO, valorLido));
                listaDTO.add(dto);
            }
        }
    	return listaDTO;
    }
    
    // Fonte Netbeans: GraficoTemperaturaBarra.setarValorBarra();
    private String getCorCepProcesso(GraficoDetalhePtFornoDTO graficoDTO, BigDecimal valorLido) {
    	if (valorLido != null && graficoDTO.getListaDwConsolId() != null) {
        	
            for (DwConsolid dwconsolid : graficoDTO.getListaDwConsolId()) {
                for (DwFolhamedtemp dwfolhamedtemp : dwconsolid.getDwFolha().getDwFolhamedtemps()) {
                    for (DwFolhamedtemhor dwfolhamedtemhor : dwfolhamedtemp.getDwFolhamedtemhors()) {
                        for (DwFolhamedtemphorcfg dwfolhamedtemphorcfg : dwfolhamedtemhor.getDwFolhamedtemphorcfgs()) {
                            if (dwfolhamedtemphorcfg.getDsCfg().equals("Ideal")) {
                                if (valorLido.compareTo(dwfolhamedtemphorcfg.getLimInfTemp()) > 0 && valorLido.compareTo(dwfolhamedtemphorcfg.getLimSupTemp()) <= 0) {
                                    return Cor.transformarParaCodigoHexadecimal(Color.GREEN);
                                }

                            } else if (dwfolhamedtemphorcfg.getDsCfg().equals("Crítica inferior")) {

                                if (valorLido.compareTo(dwfolhamedtemphorcfg.getLimSupTemp()) <= 0) {
                                	return Cor.transformarParaCodigoHexadecimal(Color.RED);
                                }

                            } else if (dwfolhamedtemphorcfg.getDsCfg().equals("Aceitável superior")) {

                                if (valorLido.compareTo(dwfolhamedtemphorcfg.getLimInfTemp()) > 0
                                        && valorLido.compareTo(dwfolhamedtemphorcfg.getLimSupTemp()) <= 0) {
                                	return Cor.transformarParaCodigoHexadecimal(Color.YELLOW);
                                }

                            } else if (dwfolhamedtemphorcfg.getDsCfg().equals("Crítica superior")) {

                                if (valorLido.compareTo(dwfolhamedtemphorcfg.getLimInfTemp()) > 0) {
                                	return Cor.transformarParaCodigoHexadecimal(Color.RED);
                                }

                            } else if (dwfolhamedtemphorcfg.getDsCfg().equals("Aceitável inferior")) {

                                if (valorLido.compareTo(dwfolhamedtemphorcfg.getLimInfTemp()) > 0
                                        && valorLido.compareTo(dwfolhamedtemphorcfg.getLimSupTemp()) <= 0) {
                                	return Cor.transformarParaCodigoHexadecimal(Color.YELLOW);
                                }
                            }
                        }
                    }
                }
            }
        }
    	return Cor.transformarParaCodigoHexadecimal(Color.RED);
    }
    
    private List<TabelaCepDTO> getListaTabelaCepDTO(List<DetalheMonitorizacaoCEPDTO> consulta) {
    	List<TabelaCepDTO> retorno = new ArrayList<TabelaCepDTO>();
    	
    	for(DetalheMonitorizacaoCEPDTO itemDTO : consulta) {
    		TabelaCepDTO cep = new TabelaCepDTO();
    		cep.setReferencia("Tempo total");
    		cep.setGrupoVariavel(itemDTO.getCdFtGrupo() + " - " + itemDTO.getDsFtGrupo());
    		cep.setVariacaoMedicao(itemDTO.getIdFtParam().toString() + " - " + itemDTO.getDsParamentro());
    		cep.setValorMinimoMedido(ConversaoTipos.converteParaString(itemDTO.getVlMinimo(), 3));
    		cep.setValorMedioMedido(ConversaoTipos.converteParaString(itemDTO.getVlMedio(), 3));
    		cep.setValorMaximoMedido(ConversaoTipos.converteParaString(itemDTO.getVlMaximo(), 3));
    		
    		String valorTotalMedido = "-";
    		if (itemDTO.getIdFtParam().equals(6L)) { //se for ENERGIACONSUMIDA, será total SOMADO
    			valorTotalMedido = ConversaoTipos.converteParaString(itemDTO.getVlSomado(), 3);
    		}
    		cep.setValorTotalMedido(valorTotalMedido);
    		
    		cep.setQuantidadeMedicao(String.valueOf(itemDTO.getQtMedicoes()));
    		cep.setValorMonetario(ConversaoTipos.converteParaString(itemDTO.getVlMonetario(), 0));
    		
    		
    		cep.setValorUltimoMedido(ConversaoTipos.converteParaString(itemDTO.getVlUltimo(), 3));
    		cep.setIdFtParam(itemDTO.getIdFtParam().longValue());

    		retorno.add(cep);
    	}
    	
    	return retorno;
    }
    
    
}
