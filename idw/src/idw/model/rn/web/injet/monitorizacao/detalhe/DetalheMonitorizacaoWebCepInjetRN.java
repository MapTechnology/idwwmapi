package idw.model.rn.web.injet.monitorizacao.detalhe;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;

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
import idw.model.pojos.template.DwFtParamTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.CpRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTFornoRN;
import idw.model.rn.injet.FuncoesApoioInjet;
import idw.model.rn.injet.PlanejamentoInjetRN;
import idw.model.rn.monitorizacao.cep.MonitorizacaoCEPRN;
import idw.model.rn.monitorizacao.injet.DetalheMonitorizacaoPTInjetRN;
import idw.util.Cor;
import idw.util.IdwLogger;
import idw.webservices.dto.DetalheCEPDTO;
import idw.webservices.dto.DetalheMonitorizacaoCEPDTO;
import idw.webservices.dto.DetalheMonitorizacaoCEPOcorrDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.FiltroGraficoDetalhePtDTO;
import idw.webservices.dto.FolhaCEPDTO;
import idw.webservices.dto.GraficoCEPDTO;
import idw.webservices.dto.GraficoCEPDetParamDTO;
import idw.webservices.dto.GraficoCEPPeriodoDTO;
import idw.webservices.dto.GraficoDetalhePtFornoDTO;
import idw.webservices.dto.IndicadoresEstatisticosCEPDTO;
import idw.webservices.dto.ListaDetalheMonitorizacaoCEPDTO;
import idw.webservices.dto.ListaParametrosCEPDTO;
import idw.webservices.dto.ParametroCEPDTO;
import idw.webservices.dto.PeriodoDTO;
import idw.webservices.rest.dto.monitorizacao.ComboDTO;
import idw.webservices.rest.dto.monitorizacao.DetalheOcorrenciasDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroGraficoCepDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoCepProcessoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoCepValoresDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoCepXDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaCepDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaGraficoCepDTO;
import idw.webservices.rest.dto.monitorizacao.UltimosCicloDTO;
import ms.util.ConversaoTipos;

public class DetalheMonitorizacaoWebCepInjetRN extends AbstractRN<DAOGenericoInjet> {
	
	public static final byte FILTRO_PERIODO_POR_HORA = 1;
	public static final byte FILTRO_PERIODO_POR_DATA_TURNO = 2;
	public static final byte FILTRO_PERIODO_POR_DATA = 3;
	
	public static final byte CEP_REFERENCIA_TEMPO_TOTAL = 0;
    public static final byte CEP_REFERENCIA_TEMPO_TRABALHADO = 1;
    public static final byte CEP_REFERENCIA_TEMPO_PARADA_COM_PESO = 2;
    public static final byte CEP_REFERENCIA_TEMPO_PARADA_SEM_PESO = 3;
    
    public static final byte GRAFICO_CNC_RESUMO = 4;

	private final String formatoData;
	private final String formatoDataHora;
	
	public DetalheMonitorizacaoWebCepInjetRN(String formatoData, String formatoDataHora) {
        this(new DAOGenericoInjet(), formatoData, formatoDataHora);
    }

    public DetalheMonitorizacaoWebCepInjetRN(DAOGenericoInjet dao, String formatoData, String formatoDataHora) {
        super(dao);
        this.formatoData = formatoData;
        this.formatoDataHora = formatoDataHora;
    }
    
    public List<ComboDTO> getParametrosCEP() {
    	
		DAOGenerico daoVF = new DAOGenerico();
		daoVF.iniciaSessao();
		//AQUITOO INJET getListaParametrosCEP

    	List<ComboDTO> listaDTO = new ArrayList<ComboDTO>();
    	
    	MonitorizacaoCEPRN monitorizacaoCEPRN = new MonitorizacaoCEPRN(daoVF.getDao());
    	
    	
    	ListaParametrosCEPDTO lista = monitorizacaoCEPRN.getListaParametrosCEP(false);
    	for(ParametroCEPDTO parametro : lista.getParametrosCEP()) {
    		ComboDTO dto = new ComboDTO();
    		dto.setId(parametro.getIdFtParam());
    		dto.setDsView(parametro.getDsParametro());
    		listaDTO.add(dto);
    	}
    	
    	return listaDTO;
    }
    
    public ListaParametrosCEPDTO getFiltroParametro(long id) {
    	
		DAOGenerico daoVF = new DAOGenerico();
		daoVF.iniciaSessao();

    	ListaParametrosCEPDTO parametros = new ListaParametrosCEPDTO();
    	
    	MonitorizacaoCEPRN monitorizacaoCEPRN = new MonitorizacaoCEPRN(daoVF.getDao());
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
    	
		DAOGenerico daoVF = new DAOGenerico();
		daoVF.iniciaSessao();
		
		
    	ajustarFiltro(filtroDetalhe, filtro.getFiltroDetalhePosto().getCdPosto());
    	filtroDetalhe.setTpId(TpId.TURNO.getValue());
    	filtroDetalhe.setDthrIhora(null);
    	filtroDetalhe.setDthrFhora(null);
    	
    	MonitorizacaoCEPRN rn = new MonitorizacaoCEPRN(daoVF.getDao());
    	GraficoCEPDTO grafico = rn.getGraficoCEP2(
    			GRAFICO_CNC_RESUMO, 
    			CEP_REFERENCIA_TEMPO_TOTAL, 
    			getFiltroParametro(filtro.getParametro()), 
    			filtroDetalhe);
    	
    		GraficoCepXDTO dto = new GraficoCepXDTO();
    
			dto.setValores(getValores(grafico,filtro.getParametro()));	
    	
    	preencherIndicadores(grafico.getIndicadoresEstatisticos().get(0), dto);
    	
    	return dto;
    }
    
    
    public List<DetalheMonitorizacaoCEPOcorrDTO> getListaOcorrenciasCEPInjet(
			Byte tpReferencia, Long idFtParam, Long idFolha, PeriodoDTO periodo, String cdPt) { // mais recente ocorrencia CEP
MonitorizacaoCEPRN teste = new  MonitorizacaoCEPRN();
teste.getListaOcorrenciasCEPInjet(tpReferencia, idFtParam, idFolha, periodo, cdPt);
		List<DetalheMonitorizacaoCEPOcorrDTO> retorno = new ArrayList<DetalheMonitorizacaoCEPOcorrDTO>();

		String strSQL = "";
		strSQL = "SELECT a.id_ft_param AS idFtParam,";
		strSQL = strSQL.concat(" d.ds_parametro AS dsParamentro, ");
		strSQL = strSQL.concat(" c.dthr_medicao AS dthrMedicao, ");
		strSQL = strSQL.concat(" c.ms_dthrmedicao AS msDthrmedicao, ");
		strSQL = strSQL.concat(" (CASE WHEN c.vl_monetario IS NULL THEN 0 ELSE c.vl_monetario END) AS vlMonetario, ");
		strSQL = strSQL.concat(" c.vlr_lido AS vlrLido ");
		strSQL = strSQL.concat(" FROM dw_consol_param a ");
		strSQL = strSQL.concat(" JOIN dw_consol_parammed b ON (b.id_consolparam = a.id_consolparam) ");
		strSQL = strSQL.concat(" JOIN dw_consolmedparamlog c ON (c.id_consolmedparamlog = b.id_consolmedparamlog)");
		strSQL = strSQL.concat(" JOIN dw_ft_param d ON (d.id_ft_param = a.id_ft_param) ");
		strSQL = strSQL.concat(" JOIN dw_consol e ON (e.id_consol = a.id_consol) ");
		strSQL = strSQL.concat(" JOIN dw_consolid f ON (f.id_consolid = e.id_consolid) ");		
		strSQL = strSQL.concat(" JOIN om_pt g ON (g.id_pt = f.id_pt AND g.cd_pt = '" + cdPt + "'" + ") ");
		strSQL = strSQL.concat(" WHERE 1=1 " );
		
//		if (idFolha!=null && idFolha.longValue()>0L){
//			strSQL = strSQL.concat(" AND f.id_folha = " + idFolha );			
//		}
		if (idFtParam!=null ){
			strSQL = strSQL.concat(" AND a.id_ft_param = " + idFtParam );			
		}
		
		strSQL = strSQL.concat("  AND c.dthr_medicao BETWEEN :dthrini AND :dthrfim");
		strSQL = strSQL.concat("  AND a.tp_referencia = " + tpReferencia);
		strSQL = strSQL.concat("  ORDER BY dthrMedicao DESC ");

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q.setParameter("dthrini", periodo.getDtHrInicio())
		 .setParameter("dthrfim", periodo.getDtHrFim());

		List<DetalheMonitorizacaoCEPOcorrDTO> lista = 
				this.getDaoSession().createSQLQuery(strSQL)
				.addScalar("idFtParam", new LongType())
				.addScalar("dsParamentro", new StringType())
				.addScalar("dthrMedicao", new DateType())
				.addScalar("msDthrmedicao", new IntegerType())
				.addScalar("vlMonetario", new BigDecimalType())
				.addScalar("vlrLido", new BigDecimalType())				
				.setResultTransformer(Transformers.aliasToBean(DetalheMonitorizacaoCEPOcorrDTO.class))
				.list();
		
		retorno.addAll(lista);
		lista = null;
		
		return retorno;
	}
	
    public List<TabelaCepDTO> getCepTabela(FiltroGraficoCepDTO filtro, FiltroDetalhePTInjetDTO filtroDetalhe) throws RegistroDesconhecidoException {
    	
		DAOGenerico daoVF = new DAOGenerico();
		daoVF.iniciaSessao();
		//AQUITOO INJET getDetalheCEPGraf2
    	
    	ajustarFiltro(filtroDetalhe, filtro.getFiltroDetalhePosto().getCdPosto());
    	
    	filtroDetalhe.setTpId(TpId.TURNO.getValue());
    	filtroDetalhe.setDthrIhora(null);
    	filtroDetalhe.setDthrFhora(null);
    	
    	
    	
    	MonitorizacaoCEPRN rn = new MonitorizacaoCEPRN(daoVF.getDao());
    	DetalheCEPDTO consulta = rn.getDetalheCEPGraf2INJET(this.getDao(), daoVF.getDao(),
    			GRAFICO_CNC_RESUMO, 
    			CEP_REFERENCIA_TEMPO_TOTAL, 
    			filtro.getParametro(), 
    			filtroDetalhe);
    	
    	List<DetalheMonitorizacaoCEPDTO> lista = new ArrayList<DetalheMonitorizacaoCEPDTO>();
    	if (consulta != null && consulta.getListaFolhasCEP() != null && consulta.getListaFolhasCEP().getListaFolhas() != null && consulta.getListaFolhasCEP().getListaFolhas().isEmpty() == false) {
            lista = consulta.getListaFolhasCEP().getListaFolhas().get(0).getListaDetalheCEP().getDetMonitorizacaoCEP();
        }
    	
    	return getListaTabelaCepDTO(lista);
    }
    
    public List<GraficoCepProcessoDTO> getGraficoCepProcesso(FiltroGraficoCepDTO filtro) throws RegistroDesconhecidoException {

		DAOGenerico daoVF = new DAOGenerico();
		daoVF.iniciaSessao();
		//AQUITOO INJET getGraficoPtForno
    	
    	FiltroGraficoDetalhePtDTO filtroDetalhe = new FiltroGraficoDetalhePtDTO();
    	
    	OmPt posto = new OmPt();
    	posto.setCdPt(filtro.getFiltroDetalhePosto().getCdPosto());
    	filtroDetalhe.setOmPt(posto);
    	
    	CpRN cpRN = new CpRN( daoVF.getDao());
    	PpCp cp = cpRN.pesquisarPpCpByCdCpCdPt(
    			filtro.getFiltroDetalhePosto().getCdCp(), 
    			filtro.getFiltroDetalhePosto().getCdPosto());
    	
    	filtroDetalhe.setIdCp(cp.getId());
    	filtroDetalhe.setDtReferencia(DataHoraRN.stringToDate(filtro.getFiltroDetalhePosto().getDtHrReferenciaInicial(), formatoDataHora));
    	
    	DwTurno turno = new DwTurno();
    	turno.setIdTurno(filtro.getFiltroDetalhePosto().getIdTurno());
    	filtroDetalhe.setDwTurno(turno);
    	    	
    	filtroDetalhe.setTpId((byte) filtro.getParametro());
    	
    	DetalheMonitorizacaoPTFornoRN rn = new DetalheMonitorizacaoPTFornoRN(daoVF.getDao());
    	GraficoDetalhePtFornoDTO consulta = rn.getGraficoPtForno(filtroDetalhe);
    	
    	return getGraficoProcessoDTO(consulta);
    }
    
    // Fonte Netbeans: DetalheMonitorizacaoPTTempMain.gerarGraficoCEP()
    private void ajustarFiltro(FiltroDetalhePTInjetDTO filtroDetalhe, String cdPt) throws RegistroDesconhecidoException {


		DAOGenerico daoVF = new DAOGenerico();
		daoVF.iniciaSessao();
		//AQUITOO INJET getGraficoPtForno
    	
    	
    	PTRN ptrn = new PTRN(daoVF.getDao());
    	
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
	        
	      List<DetalheMonitorizacaoCEPOcorrDTO> ultimasamostras= graficoCEP.getItemGrafico().get(0).getParametros().get(0).getDetParam().getListaOcorrencias();
	        for (GraficoCEPPeriodoDTO dto : graficoCEP.getItemGrafico()) {
	            for (GraficoCEPDetParamDTO par : dto.getParametros()) {
	            	 double valorSomado;
		                valorSomado = par.getDetParam().getVlMedio().doubleValue();
	               for(DetalheMonitorizacaoCEPOcorrDTO ocorrencia: par.getDetParam().getListaOcorrencias()){
	            	  
		                double valorMonetario = par.getDetParam().getVlMonetario().doubleValue();
		                
		                GraficoCepValoresDTO valorDTO = new GraficoCepValoresDTO();                
		                valorDTO.setValor(ConversaoTipos.converteParaString(ocorrencia.getVlrLido(), 2));
		                valorDTO.setValorMonetario(ConversaoTipos.converteParaString(ocorrencia.getVlMonetario(), 2));
		                valorDTO.setParametro(par.getDsFtParam());
		                
		                valorDTO.setMeta(ConversaoTipos.converteParaString(valorSomado, 2));
		                
		                valorDTO.setLabel("Zona " + dto.getZona().toString());                
		                retorno.add(valorDTO);
	               }
	            	
	            	
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
            
//            for (GraficoCEPPeriodoDTO dto : graficoCEP.getItemGrafico()) {
//                for (GraficoCEPDetParamDTO par : dto.getParametros()) {
//                    double valorSomado;
//                    // Se a variavel apresentada for FATOR DE POTENCIA ou qq TENSAO ou CORRENTE, mostrar a media, ao contrario mostrar o valor somado
//                    if (par.getIdFtParam().equals(7l) // fator de potencia
//                            || par.getIdFtParam().equals(1l) // corrente
//                            || par.getIdFtParam().equals(4l) // tensao
//                            || (par.getIdFtParam()>=8l && par.getIdFtParam() <= 16l)
//                            ) {
//                        valorSomado = par.getDetParam().getVlMedio().doubleValue();
//                    } if (par.getIdFtParam().equals(5l)) {// temperatura
//                        valorSomado = par.getDetParam().getVlMaximo().doubleValue();
//                    } else {
//                        valorSomado = par.getDetParam().getVlSomado().doubleValue();
//                    }
//                    double valorMonetario = par.getDetParam().getVlMonetario().doubleValue();
//                    
//                    GraficoCepValoresDTO valorDTO = new GraficoCepValoresDTO();                
//                    valorDTO.setValor(ConversaoTipos.converteParaString(valorSomado, 2));
//                    valorDTO.setValorMonetario(ConversaoTipos.converteParaString(valorMonetario, 2));
//                    valorDTO.setParametro(par.getDsFtParam());
//                    
//                    if (dto.getDthrIni() != null) {
//                    	valorDTO.setLabel(DataHoraRN.dateToStringDDMMYYYYHHMMSS(dto.getDthrIni()));
//                    } else if (dto.getDtTurno() != null && dto.getCdTurno() != null) {
//                    	valorDTO.setLabel(DataHoraRN.dateToStringDDMMYYYY(dto.getDtTurno()) + "-" + dto.getCdTurno());
//                    } else if (dto.getDtTurno() != null) {
//                    	valorDTO.setLabel(DataHoraRN.dateToStringDDMMYYYY(dto.getDtTurno()));
//                    }
//                    
//                    if (par.getIdFtParam().equals(55)) {
//                    	for(DetalheMonitorizacaoCEPOcorrDTO ocorrencia: par.getDetParam().getListaOcorrencias()){
//      	            	  
//    		               
//    		                
//    		                GraficoCepValoresDTO valorDTOAux = new GraficoCepValoresDTO();                
//    		                valorDTOAux.setValor(ConversaoTipos.converteParaString(ocorrencia.getVlrLido(), 2));
//    		                valorDTOAux.setValorMonetario(ConversaoTipos.converteParaString(ocorrencia.getVlMonetario(), 2));
//    		                valorDTOAux.setParametro(par.getDsFtParam());
//    		                
//    		                valorDTOAux.setMeta(ConversaoTipos.converteParaString(valorSomado, 2));
//    		                
//    		                valorDTOAux.setLabel("Zona " + dto.getZona().toString());                
//    		                retorno.add(valorDTO);
//    	               }
//                    } 
//                    
//                    
//                    //retorno.add(valorDTO);
//                }
//            }    
            
            for (GraficoCEPPeriodoDTO dto : graficoCEP.getItemGrafico()) {
	            for (GraficoCEPDetParamDTO par : dto.getParametros()) {
	            	 double valorSomado;
		                valorSomado = par.getDetParam().getVlMedio().doubleValue();
	               for(DetalheMonitorizacaoCEPOcorrDTO ocorrencia: par.getDetParam().getListaOcorrencias()){
	            	  
		                double valorMonetario = par.getDetParam().getVlMonetario().doubleValue();
		                
		                GraficoCepValoresDTO valorDTO = new GraficoCepValoresDTO();                
		                valorDTO.setValor(ConversaoTipos.converteParaString(ocorrencia.getVlrLido(), 4));
		                valorDTO.setValorMonetario(ConversaoTipos.converteParaString(valorMonetario, 4));
		                valorDTO.setParametro(par.getDsFtParam());
		                valorDTO.setMeta("");
		                valorDTO.setLimInf("");
		                valorDTO.setLimSup("");
		                
		                if (par.getDetParam().getFolhaCEPSemListas().getTemMaximo()!=null) {
			                valorDTO.setLimSup(ConversaoTipos.converteParaString(par.getDetParam().getFolhaCEPSemListas().getLimCriticoSup(), 2));
		                }
		        		if (par.getDetParam().getFolhaCEPSemListas().getTemMeta()!=null) {
		        			valorDTO.setMeta(ConversaoTipos.converteParaString(par.getDetParam().getFolhaCEPSemListas().getLimIdealIni(), 2));  
		        		} 
		        		if (par.getDetParam().getFolhaCEPSemListas().getTemMinimo()!=null) {
		        			valorDTO.setLimInf(ConversaoTipos.converteParaString(par.getDetParam().getFolhaCEPSemListas().getLimCriticoInf(), 2));  
		        		}
		        		
		                valorDTO.setLabel(ocorrencia.getDthrMedicao().toString());                
		                retorno.add(valorDTO);
	               }
       	
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
    	
        dto.setM(indicadores.getM().toString());
        dto.setN(indicadores.getN().toString());
        dto.setDesvioPadrao(indicadores.getDesvioPadrao() == null ? "-" : ConversaoTipos.converteParaString(indicadores.getDesvioPadrao(), 4));
        dto.setMedia(indicadores.getMedia()== null ? "-" : ConversaoTipos.converteParaString(indicadores.getMedia(), 4));
        dto.setCp(indicadores.getCp() == null ? "-" : ConversaoTipos.converteParaString(indicadores.getCp(), 4));
//    	dto.setCpi(indicadores.getCpi() == null ? "-" : ConversaoTipos.converteParaString(indicadores.getCpi(), 4));
//    	dto.setCps(indicadores.getCps() == null ? "-" : ConversaoTipos.converteParaString(indicadores.getCps(), 4));
    	dto.setCpi("-");
    	dto.setCps("-");
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
    		cep.setValorMinimoMedido(ConversaoTipos.converteParaString(itemDTO.getVlMinimo(), 4));
    		cep.setValorMedioMedido(ConversaoTipos.converteParaString(itemDTO.getVlMedio() , 4));
    		cep.setValorMaximoMedido(ConversaoTipos.converteParaString(itemDTO.getVlMaximo(), 4));
    		//cep.setValorUltimoMedido(ConversaoTipos.converteParaString(itemDTO.getVlUltimo(), 3));
    		
    		String valorTotalMedido = "-";
    		if (itemDTO.getIdFtParam().equals(DwFtParamTemplate.Type.ENERGIACONSUMIDA)) {
    			valorTotalMedido = ConversaoTipos.converteParaString(itemDTO.getVlSomado(), 3);
    		}    		
    		cep.setValorTotalMedido(valorTotalMedido);
    		
    		cep.setQuantidadeMedicao(String.valueOf(itemDTO.getQtMedicoes()));
    		cep.setValorMonetario(ConversaoTipos.converteParaString(itemDTO.getVlMonetario(), 4));
    		
    		cep.setValorUltimoMedido(ConversaoTipos.converteParaString(itemDTO.getVlUltimo(), 4));
    		cep.setIdFtParam(itemDTO.getIdFtParam().longValue());
    		
    		
    		//novos atributos
    		cep.setLimiteInferior("-");
    		cep.setLimiteSuperior("-");
    		cep.setMeta("-");
    		//.setValorUltimoMedido(itemDTO.getDsPa);
    		cep.setDesvioPadrao("-");
    		cep.setCp("-");
    		cep.setCpi("-");	
    		cep.setCps("-");
    		cep.setCps("-");
    		cep.setCpk("-");	
    		
    		cep.setIsForaMeta(false);
    		cep.setIsForaUltimoValor(false);
    		
    		if (itemDTO.getFolhaCEPSemListas().getIndicadoresCEP().getDesvioPadrao() != null) {    		
    			cep.setDesvioPadrao(ConversaoTipos.converteParaString(itemDTO.getFolhaCEPSemListas().getIndicadoresCEP().getDesvioPadrao(), 4));
    		}
    		
    		if (itemDTO.getFolhaCEPSemListas().getTemMinimo() != null) {
        		if (itemDTO.getFolhaCEPSemListas().getTemMinimo()) {
        			cep.setLimiteInferior(ConversaoTipos.converteParaString(itemDTO.getFolhaCEPSemListas().getLimCriticoInf(), 4));
        		}
        		if (itemDTO.getFolhaCEPSemListas().getTemMaximo()) {
        			cep.setLimiteSuperior(ConversaoTipos.converteParaString(itemDTO.getFolhaCEPSemListas().getLimCriticoSup(), 4));
        		}
        		if (itemDTO.getFolhaCEPSemListas().getTemMeta()) {
        			cep.setMeta(ConversaoTipos.converteParaString(itemDTO.getFolhaCEPSemListas().getLimIdealIni(), 4));
        		}    		
        		
        		if (itemDTO.getFolhaCEPSemListas().getIndicadoresCEP().getCp() != null) {
        			cep.setCp(ConversaoTipos.converteParaString(itemDTO.getFolhaCEPSemListas().getIndicadoresCEP().getCp(), 4));
        		}    		
        		if (itemDTO.getFolhaCEPSemListas().getIndicadoresCEP().getCpi() != null) {
        			cep.setCpi(ConversaoTipos.converteParaString(itemDTO.getFolhaCEPSemListas().getIndicadoresCEP().getCpi(), 4));	
        		}
        		if (itemDTO.getFolhaCEPSemListas().getIndicadoresCEP().getCps() != null) {
        			cep.setCps(ConversaoTipos.converteParaString(itemDTO.getFolhaCEPSemListas().getIndicadoresCEP().getCps(), 4));
        		}    		
        		if (itemDTO.getFolhaCEPSemListas().getIndicadoresCEP().getCpk() != null) {
        			cep.setCpk(ConversaoTipos.converteParaString(itemDTO.getFolhaCEPSemListas().getIndicadoresCEP().getCpk(), 4));	
        		}
        		 
//        		if (itemDTO.getFolhaCEPSemListas().getIndicadoresCEP().getCp() != null) {
//        			if (itemDTO.getVlMedio().doubleValue() < itemDTO.getFolhaCEPSemListas().getLimCriticoInf().doubleValue() ||
//        			    itemDTO.getVlMedio().doubleValue() > itemDTO.getFolhaCEPSemListas().getLimCriticoSup().doubleValue() 
//        				) {
//        				cep.setIsForaMeta(true);
//        			}
//        		}
        		
        		/**  Criterio utilizado para analizar os valores médios estão fora dos intervalos específicos */
        		if (itemDTO.getFolhaCEPSemListas().getLimCriticoInf() != null&&itemDTO.getFolhaCEPSemListas().getLimCriticoSup()!=null) {
        			if (itemDTO.getVlMedio().doubleValue() < itemDTO.getFolhaCEPSemListas().getLimCriticoInf().doubleValue() ||
        			    itemDTO.getVlMedio().doubleValue() > itemDTO.getFolhaCEPSemListas().getLimCriticoSup().doubleValue() 
        				) {
        				cep.setIsForaMeta(true);
        			}
        			
            		/**  Criterio utilizado para analizar se o ultimo valor  está fora dos intervalos específicos */
        			if (itemDTO.getVlUltimo().doubleValue() < itemDTO.getFolhaCEPSemListas().getLimCriticoInf().doubleValue() ||
            			    itemDTO.getVlUltimo().doubleValue() > itemDTO.getFolhaCEPSemListas().getLimCriticoSup().doubleValue() 
            				) {
            				cep.setIsForaUltimoValor(true);
            			}
        		}
        		
        		
        		
    		}
    		
    		//Só irá adicionar se tiver limite superior no injet
    		if(itemDTO.getFolhaCEPSemListas().getLimCriticoInf() != null&&itemDTO.getFolhaCEPSemListas().getLimCriticoSup()!=null){
    			if(itemDTO.getFolhaCEPSemListas().getTemMinimo()&& itemDTO.getFolhaCEPSemListas().getTemMaximo()){
    				retorno.add(cep);	
    			}
    			
    		}
    		
    	}
    	
    	return retorno;
    }
    
    public List<TabelaGraficoCepDTO> getCepTabelaGrafico(FiltroGraficoCepDTO filtro, FiltroDetalhePTInjetDTO filtroDetalhe) throws RegistroDesconhecidoException {
    	
		DAOGenerico daoVF = new DAOGenerico();
		daoVF.iniciaSessao();
		
    	ajustarFiltro(filtroDetalhe, filtro.getFiltroDetalhePosto().getCdPosto());
    	
    	filtroDetalhe.setTpId(TpId.TURNO.getValue());
    	filtroDetalhe.setDthrIhora(null);
    	filtroDetalhe.setDthrFhora(null);
     
    	MonitorizacaoCEPRN rn = new MonitorizacaoCEPRN(daoVF.getDao());
    	DetalheCEPDTO consulta = rn.getDetalheCEPGraf2INJET(this.getDao(), daoVF.getDao(),
    			GRAFICO_CNC_RESUMO,  
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
    
    @SuppressWarnings("unchecked")
	public Map<Long, FolhaCEPDTO> getLimitesCEP(String cdPt, String nrOP, Long idFtParam) {
    	Map<Long, FolhaCEPDTO> retorno = new HashMap<Long, FolhaCEPDTO>();
    	
    	int _cdItemCNC = 0;
		int _meta = _cdItemCNC + 1;
		int _vlrMin = _meta + 1;
		int _vlrMax = _vlrMin + 1;
		
		class RegistroLido {
			String cdItemCNC= "";
			BigDecimal meta = BigDecimal.ZERO;
			BigDecimal vlrMin = BigDecimal.ZERO;
			BigDecimal vlrMax = BigDecimal.ZERO;
		}
		
    	String cdItemCNC = FuncoesApoioInjet.getStrZero(idFtParam, 6);
    	String strSQL = "";
    	
		strSQL = strSQL.concat("SELECT a.cditemcnc, a.vlidealdefinido, a.vlmindefinido, a.vlmaxdefinido ");
		strSQL = strSQL.concat("  FROM ijficcnc a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijop c ON (c.nrop = :nrOP AND c.cdmolde = a.cdmolde AND c.cdestrutura = a.cdestrutura) ");
		strSQL = strSQL.concat(" WHERE b.cdinjestendido = :cdPt ");
		
		if (idFtParam > 0) {
			strSQL = strSQL.concat("   AND a.cditemcnc = :cdItemCNC ");	
		}
		
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q.setString("nrOP", nrOP);
		q.setString("cdPt", cdPt);
		
		if (idFtParam > 0) {
			q.setString("cdItemCNC", cdItemCNC);
		}
		
		List<Object> lista = new ArrayList<Object>();
		lista = q.list();
   
		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			registro.cdItemCNC = (String) registroLido[_cdItemCNC];		
			registro.meta = ConversaoTipos.converterParaBigDecimal(registroLido[_meta]);
			registro.vlrMin = ConversaoTipos.converterParaBigDecimal(registroLido[_vlrMin]);
			registro.vlrMax = ConversaoTipos.converterParaBigDecimal(registroLido[_vlrMax]);
			
			FolhaCEPDTO folha = new FolhaCEPDTO();
			
			folha.setIndicadoresCEP(new IndicadoresEstatisticosCEPDTO());
			folha.setListaDetalheCEP(new ListaDetalheMonitorizacaoCEPDTO());
			folha.getListaDetalheCEP().setDetMonitorizacaoCEP(new ArrayList<DetalheMonitorizacaoCEPDTO>());		
			
			folha.setCdFolha(nrOP);
			folha.setIdFtParam(ConversaoTipos.converterParaBigDecimal(registro.cdItemCNC).longValue());
			folha.setLimCriticoInf(registro.vlrMin);
			folha.setLimCriticoSup(registro.vlrMax);
			folha.setLimIdealIni(registro.meta);
			folha.setTemMinimo(true);
			folha.setTemMaximo(true);
			folha.setTemMeta(true);	
			
			retorno.put(folha.getIdFtParam(), folha);
		}
    	
    	
    	
    	return retorno;
    }

    public List<GraficoCepProcessoDTO> atualizaLimites(List<GraficoCepProcessoDTO> grafico, FolhaCEPDTO folha)  {
    	
    	if (folha != null) {
        	for (GraficoCepProcessoDTO itemGraf : grafico) {        		
        		itemGraf.setMeta(ConversaoTipos.converteParaStringCasasOpcionais(folha.getLimIdealIni(), 3));
        		itemGraf.setLimInf(ConversaoTipos.converteParaStringCasasOpcionais(folha.getLimCriticoInf(), 3));
        		itemGraf.setLimSup(ConversaoTipos.converteParaStringCasasOpcionais(folha.getLimCriticoSup(), 3));
        	}    		
    	} else {
        	for (GraficoCepProcessoDTO itemGraf : grafico) {        		
        		itemGraf.setMeta("");
        		itemGraf.setLimInf("");
        		itemGraf.setLimSup("");
        	}    		    		
    	}
    	
    	return grafico;
    }
}
