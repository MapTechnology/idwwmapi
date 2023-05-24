package idw.model.rn.web.wm;

import java.awt.Color;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgind;
import idw.model.rn.AbstractRN;
import idw.model.rn.detalhemonitorizacao.GraficoPerdaMateriaPrimaRN;
import idw.model.rn.detalhemonitorizacao.IndicadorCicloMedioRN;
import idw.model.rn.monitorizacao.detalhes.GraficoParetoRefugoRN;
import idw.model.rn.monitorizacao.detalhes.GraficoParettoParadaRN;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParetoRefugosDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoParadaDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParetoRefugosDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParettoParadaDTO;
///import idw.model.rn.servemail.ServicoEmailAnaliseGtsIARN;
import idw.model.rn.servemail.ServicoEmailFactory;
import idw.util.AritmeticaUtil;
import idw.util.Cor;
import idw.util.FormulasInjet;
import idw.util.GrafTendenciaUtils;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.rest.dto.iawm.AlertasIADTO;
import idw.webservices.rest.dto.iawm.AnalisesGtIADTO;
import idw.webservices.rest.dto.iawm.GtAnaliseIADTO;
import idw.webservices.rest.dto.iawm.MaiorParadaWMDTO;
import idw.webservices.rest.dto.iawm.MaiorPerdaMPWMDTO;
import idw.webservices.rest.dto.iawm.MaiorRefugoWMDTO;
import idw.webservices.rest.dto.iawm.MetasIADTO;
import idw.webservices.rest.dto.iawm.PtAnaliseIADTO;
import idw.webservices.rest.dto.iawm.TotaisAnaliseIADTO;
import idw.webservices.rest.dto.monitorizacao.GraficoPerdasMpDTO;
import idw.webservices.rest.dto.monitorizacao.GtParadaDTO;
import idw.webservices.rest.dto.monitorizacao.GtParadaDetalheDTO;
import idw.webservices.rest.dto.monitorizacao.ParadasAbertasGtDTO;
import idw.webservices.rest.wm.dto.GtDTO;
import idw.webservices.rest.wm.dto.ParadaDetalheDTO;
import idw.webservices.rest.wm.dto.PtDTO;
import idw.webservices.rest.wm.dto.PtGargaloDTO;
import idw.webservices.rest.wm.dto.PtGargaloDinamicoDTO;
import idw.webservices.rest.wm.dto.PtGargaloParadoDTO;
import idw.webservices.rest.wm.dto.PtsGargaloDTO;
import idw.webservices.rest.wm.dto.PtsGargaloDinamicoDTO;
import idw.webservices.rest.wm.dto.PtsGargaloParadosDTO;
import ms.util.ConversaoTipos;

public class ConsultasWebWmRN extends AbstractRN<DAOGenerico> {
	
	public static final Color COR_LEGENDA_VERDE = Color.green;
	public static final Color COR_LEGENDA_AMARELO = Color.yellow;
	public static final Color COR_LEGENDA_LARANJA = Color.orange;
	public static final Color COR_LEGENDA_VERMELHO = Color.red;

	private final String formatoData;
	private final String formatoDataHora;
	    
	
	public ConsultasWebWmRN(String formatoData, String formatoDataHora) {
        this(new DAOGenerico(), formatoData, formatoDataHora);
    }

    public ConsultasWebWmRN(DAOGenerico dao, String formatoData, String formatoDataHora) {
        super(dao);
        this.formatoData = formatoData;
        this.formatoDataHora = formatoDataHora;
    }
    
    
    //WM1 -item4
    public ParadasAbertasGtDTO getLinhasParadas() {
    	List<GtParadaDTO> gts = new ArrayList<GtParadaDTO>();

    	//paradas IAC
    	GtParadaDetalheDTO detalheParadaIAC1 = new GtParadaDetalheDTO();
		detalheParadaIAC1.setIdParada(1802L);
		detalheParadaIAC1.setCdParada("67");
		detalheParadaIAC1.setDsParada("ERRO NO SENSOR");
		detalheParadaIAC1.setTempoParada(300L);
		detalheParadaIAC1.setTempoParadaFormatado("00:05:00");
		
		GtParadaDetalheDTO detalheParadaIAC2 = new GtParadaDetalheDTO();
		detalheParadaIAC2.setIdParada(1991L);
		detalheParadaIAC2.setCdParada("13");
		detalheParadaIAC2.setDsParada("SEM PLANEJAMENTO");
		detalheParadaIAC2.setTempoParada(600L);
		detalheParadaIAC2.setTempoParadaFormatado("00:10:00");
		
		GtParadaDetalheDTO detalheParadaIAC3 = new GtParadaDetalheDTO();
		detalheParadaIAC3.setIdParada(2126L);
		detalheParadaIAC3.setCdParada("12010101");
		detalheParadaIAC3.setDsParada("NG EMERGENCY");
		detalheParadaIAC3.setTempoParada(600L);
		detalheParadaIAC3.setTempoParadaFormatado("00:10:00");
    	

    	//paradas IM
    	GtParadaDetalheDTO detalheParadaIM1 = new GtParadaDetalheDTO();
    	detalheParadaIM1.setIdParada(2703L);
    	detalheParadaIM1.setCdParada("IM01");
    	detalheParadaIM1.setDsParada("TROCA DE BOSA");
    	detalheParadaIM1.setTempoParada(300L);
    	detalheParadaIM1.setTempoParadaFormatado("00:05:00");
		
		GtParadaDetalheDTO detalheParadaIM2 = new GtParadaDetalheDTO();
		detalheParadaIM2.setIdParada(2704L);
		detalheParadaIM2.setCdParada("IM03");
		detalheParadaIM2.setDsParada("AJUSTE NO SINAL RX");
		detalheParadaIM2.setTempoParada(600L);
		detalheParadaIM2.setTempoParadaFormatado("00:10:00");
		
		GtParadaDetalheDTO detalheParadaIM3 = new GtParadaDetalheDTO();
		detalheParadaIM3.setIdParada(2815L);
		detalheParadaIM3.setCdParada("IMS03");
		detalheParadaIM3.setDsParada("INSUFICIÊNCIA DE SOLDA");
		detalheParadaIM3.setTempoParada(600L);
		detalheParadaIM3.setTempoParadaFormatado("00:10:00");

		GtParadaDTO gt = new GtParadaDTO();

		//gt1 IAC 1
		gt = new GtParadaDTO();
		gt.setIdGt(226L);
		gt.setCdGt("LINHA04");
		gt.setDsGt("IAC-L04");
		gt.setParadas(new ArrayList<GtParadaDetalheDTO>());
		gt.getParadas().add(detalheParadaIAC2);
		gts.add(gt);

		//gt1 IAC 2
		gt = new GtParadaDTO();
		gt.setIdGt(337L);
		gt.setCdGt("LINHA 22");
		gt.setDsGt("IAC-L22");
		gt.setParadas(new ArrayList<GtParadaDetalheDTO>());
		gt.getParadas().add(detalheParadaIAC3);
		gts.add(gt);

		//gt1 IM 1
		gt = new GtParadaDTO();
		gt.setIdGt(1138L);
		gt.setCdGt("IM_LIN01");
		gt.setDsGt("Linha de Produção 01");
		gt.setParadas(new ArrayList<GtParadaDetalheDTO>());
		gt.getParadas().add(detalheParadaIM1);
		gts.add(gt);

		//gt1 IM 2
		gt = new GtParadaDTO();
		gt.setIdGt(964L);
		gt.setCdGt("IM_LIN03");
		gt.setDsGt("Linha de Produção 02");
		gt.setParadas(new ArrayList<GtParadaDetalheDTO>());
		gt.getParadas().add(detalheParadaIM3);
		gts.add(gt);

		ParadasAbertasGtDTO paradasAbertas = new ParadasAbertasGtDTO();
		paradasAbertas.setGts(gts);

    	return paradasAbertas;
    }
    
 
    //WM2 - item1 - pts-gargaloparado
    public PtsGargaloParadosDTO getPtsGargaloParados() {
    	
    	PtsGargaloParadosDTO retorno = new PtsGargaloParadosDTO();
    	List<PtGargaloParadoDTO> ptsgargalo = new ArrayList<PtGargaloParadoDTO>();
    	PtDTO pt;
    	GtDTO gt;
    	PtGargaloParadoDTO ptgargaloparado;

    	//paradas IAC
    	ParadaDetalheDTO detalheParadaIAC1 = new ParadaDetalheDTO();
		detalheParadaIAC1.setIdParada(1802L);
		detalheParadaIAC1.setCdParada("67");
		detalheParadaIAC1.setDsParada("ERRO NO SENSOR");
		detalheParadaIAC1.setTempoParada(300L);
		detalheParadaIAC1.setTempoParadaFormatado("00:05:00");
		
		ParadaDetalheDTO detalheParadaIAC2 = new ParadaDetalheDTO();
		detalheParadaIAC2.setIdParada(1991L);
		detalheParadaIAC2.setCdParada("13");
		detalheParadaIAC2.setDsParada("SEM PLANEJAMENTO");
		detalheParadaIAC2.setTempoParada(600L);
		detalheParadaIAC2.setTempoParadaFormatado("00:10:00");
		
		ParadaDetalheDTO detalheParadaIAC3 = new ParadaDetalheDTO();
		detalheParadaIAC3.setIdParada(2126L);
		detalheParadaIAC3.setCdParada("12010101");
		detalheParadaIAC3.setDsParada("NG EMERGENCY");
		detalheParadaIAC3.setTempoParada(600L);
		detalheParadaIAC3.setTempoParadaFormatado("00:10:00");
    	

    	//paradas IM
		ParadaDetalheDTO detalheParadaIM1 = new ParadaDetalheDTO();
    	detalheParadaIM1.setIdParada(2703L);
    	detalheParadaIM1.setCdParada("IM01");
    	detalheParadaIM1.setDsParada("TROCA DE BOSA");
    	detalheParadaIM1.setTempoParada(300L);
    	detalheParadaIM1.setTempoParadaFormatado("00:05:00");
		
    	ParadaDetalheDTO detalheParadaIM2 = new ParadaDetalheDTO();
		detalheParadaIM2.setIdParada(2704L);
		detalheParadaIM2.setCdParada("IM03");
		detalheParadaIM2.setDsParada("AJUSTE NO SINAL RX");
		detalheParadaIM2.setTempoParada(600L);
		detalheParadaIM2.setTempoParadaFormatado("00:10:00");
		
		ParadaDetalheDTO detalheParadaIM3 = new ParadaDetalheDTO();
		detalheParadaIM3.setIdParada(2815L);
		detalheParadaIM3.setCdParada("IMS03");
		detalheParadaIM3.setDsParada("INSUFICIÊNCIA DE SOLDA");
		detalheParadaIM3.setTempoParada(600L);
		detalheParadaIM3.setTempoParadaFormatado("00:10:00");

		//gt1 IAC 1
		gt = new GtDTO();
		gt.setIdGt("324");
		gt.setCdGt("LINHA09");
		gt.setDsGt("IAC-L09");
		pt = new PtDTO();
		pt.setIdPt(1542L);
		pt.setCdPt("CP4L09");
		pt.setDsPt("CP4L09");
		ptgargaloparado = new PtGargaloParadoDTO();
		ptgargaloparado.setGt(gt);
		ptgargaloparado.setPt(pt);
		ptgargaloparado.setParada(detalheParadaIAC2);
		ptsgargalo.add(ptgargaloparado);



		//gt1 IM 1
		gt = new GtDTO();
		gt.setIdGt("1138");
		gt.setCdGt("IM_LIN01");
		gt.setDsGt("Linha de Produção 01");
		pt = new PtDTO();
		pt.setIdPt(1740L);
		pt.setCdPt("FTP_08_LIN01");
		pt.setDsPt("FTP_08_LIN01");
		ptgargaloparado = new PtGargaloParadoDTO();
		ptgargaloparado.setGt(gt);
		ptgargaloparado.setPt(pt);
		ptgargaloparado.setParada(detalheParadaIM1);
		ptsgargalo.add(ptgargaloparado);
		
		retorno.setPts(ptsgargalo);

    	return retorno;
    }
    
    
    //WM3 - item2 - pts-gargalodinamico +tciclo
    public PtsGargaloDinamicoDTO getPtsGargaloDinamico() {
    	
    	PtsGargaloDinamicoDTO retorno = new PtsGargaloDinamicoDTO();
    	List<PtGargaloDinamicoDTO> ptsgargalo = new ArrayList<PtGargaloDinamicoDTO>();
    	PtDTO pt;
    	GtDTO gt;
    	PtGargaloDinamicoDTO ptgargalo;

    	/*
    	//paradas IAC
    	ParadaDetalheDTO detalheParadaIAC1 = new ParadaDetalheDTO();
		detalheParadaIAC1.setIdParada(1802L);
		detalheParadaIAC1.setCdParada("67");
		detalheParadaIAC1.setDsParada("ERRO NO SENSOR");
		detalheParadaIAC1.setTempoParada(300L);
		detalheParadaIAC1.setTempoParadaFormatado("00:05:00");
		
		ParadaDetalheDTO detalheParadaIAC2 = new ParadaDetalheDTO();
		detalheParadaIAC2.setIdParada(1991L);
		detalheParadaIAC2.setCdParada("13");
		detalheParadaIAC2.setDsParada("SEM PLANEJAMENTO");
		detalheParadaIAC2.setTempoParada(600L);
		detalheParadaIAC2.setTempoParadaFormatado("00:10:00");
		
		ParadaDetalheDTO detalheParadaIAC3 = new ParadaDetalheDTO();
		detalheParadaIAC3.setIdParada(2126L);
		detalheParadaIAC3.setCdParada("12010101");
		detalheParadaIAC3.setDsParada("NG EMERGENCY");
		detalheParadaIAC3.setTempoParada(600L);
		detalheParadaIAC3.setTempoParadaFormatado("00:10:00");
    	

    	//paradas IM
		ParadaDetalheDTO detalheParadaIM1 = new ParadaDetalheDTO();
    	detalheParadaIM1.setIdParada(2703L);
    	detalheParadaIM1.setCdParada("IM01");
    	detalheParadaIM1.setDsParada("TROCA DE BOSA");
    	detalheParadaIM1.setTempoParada(300L);
    	detalheParadaIM1.setTempoParadaFormatado("00:05:00");
		
    	ParadaDetalheDTO detalheParadaIM2 = new ParadaDetalheDTO();
		detalheParadaIM2.setIdParada(2704L);
		detalheParadaIM2.setCdParada("IM03");
		detalheParadaIM2.setDsParada("AJUSTE NO SINAL RX");
		detalheParadaIM2.setTempoParada(600L);
		detalheParadaIM2.setTempoParadaFormatado("00:10:00");
		
		ParadaDetalheDTO detalheParadaIM3 = new ParadaDetalheDTO();
		detalheParadaIM3.setIdParada(2815L);
		detalheParadaIM3.setCdParada("IMS03");
		detalheParadaIM3.setDsParada("INSUFICIÊNCIA DE SOLDA");
		detalheParadaIM3.setTempoParada(600L);
		detalheParadaIM3.setTempoParadaFormatado("00:10:00");
		*/

		//gt1 IAC 1
		gt = new GtDTO();
		gt.setIdGt("324");
		gt.setCdGt("LINHA09");
		gt.setDsGt("IAC-L09");
		pt = new PtDTO();
		pt.setIdPt(1542L);
		pt.setCdPt("CP4L09");
		pt.setDsPt("CP4L09");
		ptgargalo = new PtGargaloDinamicoDTO();
		ptgargalo.setGt(gt);
		ptgargalo.setPt(pt);
		//ptgargalo.setParada(detalheParadaIAC2);
		ptgargalo.setTempoCicloPadrao(  new BigDecimal(48) );//48.13
		ptgargalo.setTempoCicloRealMedio(  new BigDecimal(50) );
		ptsgargalo.add(ptgargalo);



		//gt1 IM 1
		gt = new GtDTO();
		gt.setIdGt("1138");
		gt.setCdGt("IM_LIN01");
		gt.setDsGt("Linha de Produção 01");
		pt = new PtDTO();
		pt.setIdPt(1740L);
		pt.setCdPt("FTP_08_LIN01");
		pt.setDsPt("FTP_08_LIN01");
		ptgargalo = new PtGargaloDinamicoDTO();
		ptgargalo.setGt(gt);
		ptgargalo.setPt(pt);
		//ptgargalo.setParada(detalheParadaIM1);
		ptgargalo.setTempoCicloPadrao(  new BigDecimal(119) );//119.11
		ptgargalo.setTempoCicloRealMedio(  new BigDecimal(120) );		
		ptsgargalo.add(ptgargalo);
		
		retorno.setPts(ptsgargalo);

    	return retorno;
    }    

    
    //WM4 - item3 - pts-gargalo extrapola 5%
    public PtsGargaloDTO getPtsGargaloExtrapola5p() {
    	
    	PtsGargaloDTO retorno = new PtsGargaloDTO();
    	List<PtGargaloDTO> ptsgargalo = new ArrayList<PtGargaloDTO>();
    	PtDTO pt;
    	GtDTO gt;
    	PtGargaloDTO ptgargalo;

    
		//gt1 IAC 1
		gt = new GtDTO();
		gt.setIdGt("327");
		gt.setCdGt("LINHA 12");
		gt.setDsGt("IAC-L12");
		pt = new PtDTO();
		pt.setIdPt(1512L);
		pt.setCdPt("QP3L12");
		pt.setDsPt("QP3L12");
		ptgargalo = new PtGargaloDTO();
		ptgargalo.setGt(gt);
		ptgargalo.setPt(pt);
		//ptgargalo.setParada(detalheParadaIAC2);
		ptgargalo.setTempoCicloPadrao(  new BigDecimal(48) );//48.13
		ptgargalo.setTempoCicloRealMedio(  new BigDecimal(52) );
		ptsgargalo.add(ptgargalo);



		//gt1 IM 1
		gt = new GtDTO();
		gt.setIdGt("964");
		gt.setCdGt("IM_LIN02");
		gt.setDsGt("Linha de Produção 02");
		pt = new PtDTO();
		pt.setIdPt(728L);
		pt.setCdPt("RX_01_LIN02");
		pt.setDsPt("RX_01_LIN02");
		ptgargalo = new PtGargaloDTO();
		ptgargalo.setGt(gt);
		ptgargalo.setPt(pt);
		//ptgargalo.setParada(detalheParadaIM1);
		ptgargalo.setTempoCicloPadrao(  new BigDecimal(53) );//119.11
		ptgargalo.setTempoCicloRealMedio(  new BigDecimal(55) );		
		ptsgargalo.add(ptgargalo);
		
		retorno.setPts(ptsgargalo);

    	return retorno;
    }    
    
    
    // Marcos Sardinha: 2022-07-18
    @SuppressWarnings("unchecked")
	public AnalisesGtIADTO getAnaliseGtsWM() {
    	Map<String, GtAnaliseIADTO> retornoGT = new HashMap<String, GtAnaliseIADTO>();     
    	AnalisesGtIADTO retorno = new AnalisesGtIADTO();
    	retorno.setAnalises(new ArrayList<GtAnaliseIADTO>());
    	
    	// metas definidas em omcfg (considera meta geral)
    	OmCfg omCfg = Util.getConfigGeral(this.getDaoSession());
	 	MetasIADTO metasEC = null;
	 	MetasIADTO metasOEE = null;
	 	MetasIADTO metasDisp = null;
	 	MetasIADTO metasRefugo = null;
	 	MetasIADTO metasRitmo = null;
	 	 
	 	AlertasIADTO alertasIA = null;
	 	boolean gerarAlertaRitmoSuper = false;
	 	boolean gerarAlertaRitmo = false;
	 	boolean gerarAlertaRefugo = false;
	 	boolean gerarAlertaParada = false;
	 	boolean gerarAlertaPerdaMP = false;
	 	
	 	
	 	SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
	 	String s = "";
	 	
	 	// metas
	 	if (omCfg != null) {
			for (OmCfgind omCfgInd : omCfg.getOmCfginds()) {
				
				// efic ciclo
				if (omCfgInd.getOmInd().getIdInd() == 2) {
					metasEC = new MetasIADTO();
					metasEC.setLimInf(omCfgInd.getIndInferior());
					metasEC.setLimSup(omCfgInd.getIndSuperior());
					metasEC.setLimMeta(omCfgInd.getIndMeta());
				}

	
				// refugo
				if (omCfgInd.getOmInd().getIdInd() == 3) {
					metasRefugo = new MetasIADTO();
					metasRefugo.setLimInf(omCfgInd.getIndInferior());
					metasRefugo.setLimSup(omCfgInd.getIndSuperior());
					metasRefugo.setLimMeta(omCfgInd.getIndMeta());
				}
				
				// ritmo
				if (omCfgInd.getOmInd().getIdInd() == 8) {
					metasRitmo = new MetasIADTO();
					metasRitmo.setLimInf(omCfgInd.getIndInferior());
					metasRitmo.setLimSup(omCfgInd.getIndSuperior());
					metasRitmo.setLimMeta(omCfgInd.getIndMeta());
				}
				
				// ooe (tb será usado pra disponbilidade)
				if (omCfgInd.getOmInd().getIdInd() == 5) {
					metasOEE = new MetasIADTO();
					metasOEE.setLimInf(omCfgInd.getIndInferior());
					metasOEE.setLimSup(omCfgInd.getIndSuperior());
					metasOEE.setLimMeta(omCfgInd.getIndMeta());

					metasDisp = new MetasIADTO();
					metasDisp.setLimInf(omCfgInd.getIndInferior());
					metasDisp.setLimSup(omCfgInd.getIndSuperior());
					metasDisp.setLimMeta(omCfgInd.getIndMeta()); 
				}
				
				
			}
	 	}  
	 	


    	int _cdgt = 0;
    	int _coordy = _cdgt + 1;
    	int _coordx = _coordy + 1;
    	int _monit = _coordx + 1;
    	int _cdpt = _monit + 1;
    	int _ciclopadrao = _cdpt + 1;
    	int _idconsolid = _ciclopadrao + 1;
    	int _dtturno = _idconsolid + 1;
    	int _cdturno = _dtturno + 1;
    	int _dsturno = _cdturno + 1;
    	int _qtdcicprod = _dsturno + 1;
    	int _prodbruta = _qtdcicprod + 1;
    	int _prodref = _prodbruta + 1;    	
    	int _tempocicprod = _prodref + 1;
    	int _tempocicimprod = _tempocicprod + 1;
    	int _temporefugado = _tempocicimprod + 1;
    	int _tempoparcp = _temporefugado + 1;
    	int _tempoparsp = _tempoparcp + 1;
    	int _tempoparcpvr = _tempoparsp + 1;
    	int _tempoparspvr = _tempoparcpvr + 1;
    	    	
		List<Object> lista = new ArrayList<Object>();
		String strSQL = "";
		
		// calcula indicadores por pt 
		strSQL = strSQL.concat("SELECT gt.cd_gt, oo.y, oo.x, oo.monitoracao, pt.cd_pt, cns.seg_auto_ciclopadrao, cns.id_consolid, "); 	
		strSQL = strSQL.concat("       cid.dt_referencia, tur.cd_turno, tur.ds_turno, ");
		strSQL = strSQL.concat("       ((CASE WHEN cns.qt_auto_cicloprodutivo IS NULL THEN 0 ELSE cns.qt_auto_cicloprodutivo END) + (CASE WHEN cns.qt_manu_cicloprodutivo IS NULL THEN 0 ELSE cns.qt_manu_cicloprodutivo END)) as qtdcicprodutivo, ");		
		strSQL = strSQL.concat("       ((CASE WHEN cns.pcs_auto_producaobruta IS NULL THEN 0 ELSE cns.pcs_auto_producaobruta END) + (CASE WHEN cns.pcs_manu_producaobruta IS NULL THEN 0 ELSE cns.pcs_manu_producaobruta END)) as qtdprodbruta,");
		strSQL = strSQL.concat("       ((CASE WHEN cns.pcs_auto_producaorefugada IS NULL THEN 0 ELSE cns.pcs_auto_producaorefugada END) + (CASE WHEN cns.pcs_manu_producaorefugada IS NULL THEN 0 ELSE cns.pcs_manu_producaorefugada END)) as qtdref, ");	 
		strSQL = strSQL.concat("       ((CASE WHEN cns.seg_auto_cicloprodutivo IS NULL THEN 0 ELSE cns.seg_auto_cicloprodutivo END) + (CASE WHEN cns.seg_manu_cicloprodutivo IS NULL THEN 0 ELSE cns.seg_manu_cicloprodutivo END)) as tempocicprodutivo, ");
		strSQL = strSQL.concat("       ((CASE WHEN cns.seg_auto_cicloimprodutivo IS NULL THEN 0 ELSE cns.seg_auto_cicloimprodutivo END) + (CASE WHEN cns.seg_manu_cicloimprodutivo IS NULL THEN 0 ELSE cns.seg_manu_cicloimprodutivo END)) as tempocicimprodutivo, ");
		strSQL = strSQL.concat("       ((CASE WHEN cns.seg_auto_temporefugadas IS NULL THEN 0 ELSE cns.seg_auto_temporefugadas END) + (CASE WHEN cns.seg_manu_temporefugadas IS NULL THEN 0 ELSE cns.seg_manu_temporefugadas END)) as temporefugadas,  ");
		strSQL = strSQL.concat("       ((CASE WHEN cns.seg_auto_tempoparada_cp IS NULL THEN 0 ELSE cns.seg_auto_tempoparada_cp END) + (CASE WHEN cns.seg_manu_tempoparada_cp IS NULL THEN 0 ELSE cns.seg_manu_tempoparada_cp END)) as tempoparcp, ");
		strSQL = strSQL.concat("       ((CASE WHEN cns.seg_auto_tempoparada_sp IS NULL THEN 0 ELSE cns.seg_auto_tempoparada_sp END) + (CASE WHEN cns.seg_manu_tempoparada_sp IS NULL THEN 0 ELSE cns.seg_manu_tempoparada_sp END)) as tempoparsp, ");
		strSQL = strSQL.concat("       ((CASE WHEN cns.seg_auto_tempoparada_cp_vr IS NULL THEN 0 ELSE cns.seg_auto_tempoparada_cp_vr END) + (CASE WHEN cns.seg_manu_tempoparada_cp_vr IS NULL THEN 0 ELSE cns.seg_manu_tempoparada_cp_vr END)) as tempoparcpvr, ");
		strSQL = strSQL.concat("       ((CASE WHEN cns.seg_auto_tempoparada_sp_vr IS NULL THEN 0 ELSE cns.seg_auto_tempoparada_sp_vr END) + (CASE WHEN cns.seg_manu_tempoparada_sp_vr IS NULL THEN 0 ELSE cns.seg_manu_tempoparada_sp_vr END)) as tempoparspvr ");		
		strSQL = strSQL.concat("  FROM dw_consolid cid ");

		// o trecho abaixo recupera o ultimo id consolidado de cada pt
		strSQL = strSQL.concat("  JOIN ( ");
		strSQL = strSQL.concat("        SELECT cid.id_pt, cid.id_cp, MAX(cid.dthr_fconsol) as dthr_fconsol ");
		strSQL = strSQL.concat("          FROM dw_consolid cid ");
		strSQL = strSQL.concat("          JOIN om_pt pt ON (pt.id_pt = cid.id_pt AND pt.id_cp = cid.id_cp) ");
		strSQL = strSQL.concat("          JOIN om_obj oo ON (oo.id_pt = pt.id_pt) ");
		strSQL = strSQL.concat("          JOIN om_gt gt ON (gt.id_gt = oo.id_gt) ");
		strSQL = strSQL.concat("         WHERE cid.tp_id = 1 ");
		strSQL = strSQL.concat("           AND pt.st_ativo = 1 ");
		strSQL = strSQL.concat("           AND gt.st_ativo = 1 ");
		strSQL = strSQL.concat("         GROUP BY cid.id_pt, cid.id_cp ");
		strSQL = strSQL.concat("    ) cid2  ON (cid2.id_pt = cid.id_pt AND cid2.id_cp = cid.id_cp AND cid2.dthr_fconsol = cid.dthr_fconsol) ");
		
		strSQL = strSQL.concat("  JOIN dw_consol cns ON (cns.id_consolid = cid.id_consolid) ");
		strSQL = strSQL.concat("  JOIN dw_turno tur ON (tur.id_turno = cid.id_turno) ");
		strSQL = strSQL.concat("  JOIN om_pt pt ON (pt.id_pt = cid.id_pt AND pt.id_cp = cid.id_cp) ");
		strSQL = strSQL.concat("  JOIN om_obj oo ON (oo.id_pt = pt.id_pt) ");
		strSQL = strSQL.concat("  JOIN om_gt gt ON (gt.id_gt = oo.id_gt)  ");
		strSQL = strSQL.concat(" WHERE cid.tp_id  = 1 ");
		strSQL = strSQL.concat("   AND pt.st_ativo = 1 ");
		strSQL = strSQL.concat("   AND gt.st_ativo = 1 ");
		strSQL = strSQL.concat(" ORDER BY gt.cd_gt, oo.y DESC, oo.x DESC, pt.cd_pt ");

		
		SQLQuery q = this.getDao().getSession().createSQLQuery(strSQL);
		
		lista = q.list();	
	 	for (Object reg : lista) { 
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			 
			PtAnaliseIADTO registro = new PtAnaliseIADTO();
			registro.setTotais(new TotaisAnaliseIADTO());
			
			registro.setCdGt((String) registroLido[_cdgt]);
			registro.setCdPt((String) registroLido[_cdpt]);
			registro.setIdConsolId(ConversaoTipos.converterParaBigDecimal(registroLido[_idconsolid]));			
			registro.setCoordY(ConversaoTipos.converterParaBigDecimal(registroLido[_coordy]));
			registro.setCoordX(ConversaoTipos.converterParaBigDecimal(registroLido[_coordx]));
			
			if (registroLido[_monit] == null) {
				registro.setMonitoracao(BigDecimal.ZERO);					
			} else {
				registro.setMonitoracao(ConversaoTipos.converterParaBigDecimal(registroLido[_monit]));
			}
			
			registro.setCicloPadrao(ConversaoTipos.converterParaBigDecimal(registroLido[_ciclopadrao]));			
			
			///registro.setDtReferencia((Date) registroLido[_dtturno]);

			s = dmyFormat.format((Date) registroLido[_dtturno]);
			registro.setDtReferencia(s);
			
			registro.setCdTurno(ConversaoTipos.converterParaBigDecimal(registroLido[_cdturno]).longValue());
			registro.setDsTurno((String) registroLido[_dsturno]);
			
			registro.getTotais().setProdBruta(ConversaoTipos.converterParaBigDecimal(registroLido[_prodbruta]));
			registro.getTotais().setProdRef(ConversaoTipos.converterParaBigDecimal(registroLido[_prodref]));
			registro.getTotais().setQtdCicProdutivo(ConversaoTipos.converterParaBigDecimal(registroLido[_qtdcicprod]));
			registro.getTotais().setTempoCicProdutivo(ConversaoTipos.converterParaBigDecimal(registroLido[_tempocicprod]));
			registro.getTotais().setTempoCicImprodutivo(ConversaoTipos.converterParaBigDecimal(registroLido[_tempocicimprod]));
			registro.getTotais().setTempoRefugos(ConversaoTipos.converterParaBigDecimal(registroLido[_temporefugado]));
			registro.getTotais().setTempoParCP(ConversaoTipos.converterParaBigDecimal(registroLido[_tempoparcp]));
			registro.getTotais().setTempoParSP(ConversaoTipos.converterParaBigDecimal(registroLido[_tempoparsp]));
			registro.getTotais().setTempoParCPVR(ConversaoTipos.converterParaBigDecimal(registroLido[_tempoparcpvr]));
			registro.getTotais().setTempoParSPVR(ConversaoTipos.converterParaBigDecimal(registroLido[_tempoparspvr]));
			
						
			registro.setCicloMedio(FormulasInjet.calcularCicloMedio(
					registro.getTotais().getTempoCicProdutivo(), 
					registro.getTotais().getQtdCicProdutivo()));
			registro.getTotais().setTempoBoas(FormulasInjet.calcularTempoBoas(
					registro.getTotais().getTempoCicProdutivo(), 
					registro.getTotais().getTempoRefugos(), 
					registro.getTotais().getTempoParCPVR(), 
					registro.getTotais().getTempoParSPVR()));
			registro.getTotais().setTempoRitmo(FormulasInjet.calcularRitmo(
					registro.getTotais().getTempoCicProdutivo(), 
					registro.getTotais().getQtdCicProdutivo(), 
					registro.getCicloPadrao(), registro.getTotais().getTempoParCPVR(),
					registro.getTotais().getTempoParSPVR())); 
			registro.getTotais().setTempoProdutivo(FormulasInjet.calcularTempoprodutivas(
					registro.getTotais().getTempoBoas(), 
					BigDecimal.ZERO, 
					registro.getTotais().getTempoRitmo()));
			registro.getTotais().setTempoDisponivel(FormulasInjet.calcularTempoAtivo(
					registro.getTotais().getTempoCicProdutivo(), 
					registro.getTotais().getTempoParCP(), 
					registro.getTotais().getTempoCicImprodutivo(), 
					registro.getTotais().getTempoParCPVR(), 
					registro.getTotais().getTempoParSPVR()));
			registro.getTotais().setTempoTrabalhado(AritmeticaUtil.diminuir(
					registro.getTotais().getTempoDisponivel(), 
					registro.getTotais().getTempoParCP())); 

			/*
			registro.getTotais().setOee(new BigDecimal(FormulasInjet.calcularOEE(
					registro.getTotais().getTempoCicImprodutivo(),
					registro.getTotais().getTempoDisponivel())));
			 */
			
			registro.getTotais().setOee(new BigDecimal(FormulasInjet.calcularOEE(
					registro.getTotais().getTempoCicProdutivo(),
					registro.getTotais().getTempoDisponivel())));
			if(registro.getTotais().getTempoCicProdutivo().longValue()<=0L) {
				registro.getTotais().setOee(new BigDecimal(0L));	
			}

			
			
			
			registro.getTotais().setEfiCiclo(new BigDecimal(FormulasInjet.calcularEficienciaCiclo(
					registro.getCicloPadrao(), 
					registro.getCicloMedio())));
							
			GtAnaliseIADTO regGT = new GtAnaliseIADTO();
			regGT.setMetasEC(metasEC);
			regGT.setMetasOEE(metasOEE);
			regGT.setMetasDisp(metasDisp);
			regGT.setMetasRefugo(metasRefugo);
			regGT.setMetasRitmo(metasRitmo);			
			regGT.setTotaisGt(new TotaisAnaliseIADTO());
			
			if (retornoGT.containsKey(registro.getCdGt())) {
				// recupera pts do gt
				regGT = retornoGT.get(registro.getCdGt());
				
				// remove gt
				retornoGT.remove(registro.getCdGt());				
			} else {
				regGT.setCdGt(registro.getCdGt());
			}

			// adiciona pt ao gt
			regGT.getPts().add(registro);
			
			// atualiza gt
			retornoGT.put(regGT.getCdGt(), regGT);
		
		}
			  
	 	
	 	q = null;
	 	lista = null;
	 	
	 	// calcula indicadores do GT
	 	// Deve levar em consideracao postos marcados como monitoracao.
	 	// Na ausencia de postos com essa caracteristica ou sem dados, considerar o posto mais proximo do fim da linha/celula (considera desenho da linha)
	 	for (String cdGT : retornoGT.keySet()) {
	    	int qtdItensCicPadrao = 0;
	    	BigDecimal segcicloPadraoSum = BigDecimal.ZERO; 
	    		 		
	 		Boolean boolTemPtMonitoracao = false;
	 		Boolean boolAcumula = false;
	 		String cdPostoFimLayout = "";
	 		
	 		List<Long> ids = new ArrayList<Long>();
	 		//ids = getListaIdsAnaliseWN(retornoGT.get(cdGT).getPts());
	 		
	 		// identifica se tem posto configurado pra contabilizar pra celual
	 		for (PtAnaliseIADTO pt : retornoGT.get(cdGT).getPts()) {
	 			if ( (pt.getMonitoracao() != null) && (pt.getMonitoracao().intValue() == 1)  ) {
	 				// deve acumular indicadores pra definicao do indicador global da linha/celula
	 				boolTemPtMonitoracao = true;
	 				break;
	 			}
	 		}
	 		
	 		
	 		if (! boolTemPtMonitoracao) {
	 			// se nao tem posto indicadore de contagem, descobre o mais proximo do fim
		 		cdPostoFimLayout = retornoGT.get(cdGT).getPts().get(0).getCdPt();	
		 		retornoGT.get(cdGT).getPts().get(0).setMonitoracao(BigDecimal.ONE);
	 		}
	 		
	 		// percorre pts pra acumular indicadores
	 		for (PtAnaliseIADTO pt : retornoGT.get(cdGT).getPts()) {
	 			boolAcumula = false;
	 			if (boolTemPtMonitoracao) {
		 			if (pt.getMonitoracao().intValue() == 1) {
		 				// deve acumular indicadores pra definicao do indicador global da linha/celula
		 				boolAcumula = true;
		 			}
	 			} else {
	 				if (pt.getCdPt().equals(cdPostoFimLayout)) {
	 					boolAcumula = true;
	 					
	 				}
	 			}
	 			
	 			if (boolAcumula) {
	 				ids.add(pt.getIdConsolId().longValue());
	 				
	 				TotaisAnaliseIADTO totalGT = new TotaisAnaliseIADTO();
	 				totalGT = retornoGT.get(cdGT).getTotaisGt();
	 				
	 				totalGT.setProdBruta(AritmeticaUtil.somar(totalGT.getProdBruta(), pt.getTotais().getProdBruta()));
	 				totalGT.setProdRef(AritmeticaUtil.somar(totalGT.getProdRef(), pt.getTotais().getProdRef()));
	 				totalGT.setQtdCicProdutivo(AritmeticaUtil.somar(totalGT.getQtdCicProdutivo(), pt.getTotais().getQtdCicProdutivo()));
	 				totalGT.setTempoCicProdutivo(AritmeticaUtil.somar(totalGT.getTempoCicProdutivo(), pt.getTotais().getTempoCicProdutivo()));
	 				totalGT.setTempoCicImprodutivo(AritmeticaUtil.somar(totalGT.getTempoCicImprodutivo(), pt.getTotais().getTempoCicImprodutivo()));
	 				totalGT.setTempoRefugos(AritmeticaUtil.somar(totalGT.getTempoRefugos(), pt.getTotais().getTempoRefugos()));
	 				totalGT.setTempoParCP(AritmeticaUtil.somar(totalGT.getTempoParCP(), pt.getTotais().getTempoParCP()));
	 				totalGT.setTempoParSP(AritmeticaUtil.somar(totalGT.getTempoParSP(), pt.getTotais().getTempoParSP()));
	 				totalGT.setTempoParCPVR(AritmeticaUtil.somar(totalGT.getTempoParCPVR(), pt.getTotais().getTempoParCPVR()));
	 				totalGT.setTempoParSPVR(AritmeticaUtil.somar(totalGT.getTempoParSPVR(), pt.getTotais().getTempoParSPVR()));
	 				
	 				totalGT.setTempoBoas(AritmeticaUtil.somar(totalGT.getTempoBoas(), pt.getTotais().getTempoBoas()));
	 				totalGT.setTempoRitmo(AritmeticaUtil.somar(totalGT.getTempoRitmo(), pt.getTotais().getTempoRitmo()));
	 				totalGT.setTempoProdutivo(AritmeticaUtil.somar(totalGT.getTempoProdutivo(), pt.getTotais().getTempoProdutivo()));
	 				totalGT.setTempoDisponivel(AritmeticaUtil.somar(totalGT.getTempoDisponivel(), pt.getTotais().getTempoDisponivel())); 
	 				totalGT.setTempoTrabalhado(AritmeticaUtil.somar(totalGT.getTempoTrabalhado(), pt.getTotais().getTempoTrabalhado())); 

	 				if (retornoGT.get(cdGT).getCdTurno() == null) {
	 					// atribuir valor do pte
	 					//retornoGT.get(cdGT).setDtReferencia(pt.getDtReferencia());
	 					retornoGT.get(cdGT).setDtReferencia(pt.getDtReferencia());

	 					
	 					retornoGT.get(cdGT).setCdTurno(pt.getCdTurno());
	 					retornoGT.get(cdGT).setDsTurno(pt.getDsTurno());
	 				} else {
	 					// compara as datas e atribui a mais recente (melhorar aqui.. por enquanto atribuindo sem verificar)
	 					retornoGT.get(cdGT).setDtReferencia(pt.getDtReferencia());
	 					retornoGT.get(cdGT).setCdTurno(pt.getCdTurno());
	 					retornoGT.get(cdGT).setDsTurno(pt.getDsTurno());
	 				}
	 				
	 				retornoGT.get(cdGT).setTotaisGt(totalGT);
	 				
	 				
	 				// verifica se ciclo este item entra no calc da efi de ciclo  
	 				if (pt.getCicloPadrao() != null && pt.getCicloMedio().doubleValue() > 0d) {
	 					qtdItensCicPadrao++;
	 					segcicloPadraoSum = AritmeticaUtil.somar(segcicloPadraoSum, pt.getCicloPadrao()); 
					}
	 			}

	 		}
	 		
	 		// finalmente, calcula os indicadores OEE e efi ciclo da linha 	 		
			IndicadorCicloMedioRN cmRN = new IndicadorCicloMedioRN(
					new OmCfg(), 
					null,
					retornoGT.get(cdGT).getTotaisGt().getTempoCicProdutivo(),
					retornoGT.get(cdGT).getTotaisGt().getQtdCicProdutivo(), 
					retornoGT.get(cdGT).getTotaisGt().getTempoParSP());
			double ciclomedio = cmRN.calcularCicloMedio().doubleValue();
	 		
			retornoGT.get(cdGT).setCicloMedioMedio(new BigDecimal(ciclomedio));
	 		if (retornoGT.get(cdGT).getCicloMedioMedio().doubleValue() > 0d) {
		 		retornoGT.get(cdGT).setCicloPadraoMedio(AritmeticaUtil.dividir(segcicloPadraoSum, new BigDecimal(qtdItensCicPadrao)));
		 				
 				retornoGT.get(cdGT).getTotaisGt().setEfiCiclo(new BigDecimal(FormulasInjet.calcularEficienciaCiclo(
 						retornoGT.get(cdGT).getCicloPadraoMedio(), 
 						retornoGT.get(cdGT).getCicloMedioMedio())));
		 					
			}
			 
			retornoGT.get(cdGT).getTotaisGt().setOee(new BigDecimal(FormulasInjet.calcularOEE(
					retornoGT.get(cdGT).getTotaisGt().getTempoCicImprodutivo(), 
					retornoGT.get(cdGT).getTotaisGt().getTempoDisponivel()))); 
			
		 	
			retornoGT.get(cdGT).getTotaisGt().setIndDisponbilidade(FormulasInjet.calcularIndiceDisponibilidade(
					retornoGT.get(cdGT).getTotaisGt().getTempoTrabalhado(), 
					retornoGT.get(cdGT).getTotaisGt().getTempoDisponivel()));
			
		 	
			retornoGT.get(cdGT).getTotaisGt().setIndRitmo(FormulasInjet.calcularRitmoPercentual(
					retornoGT.get(cdGT).getTotaisGt().getTempoCicProdutivo(), 
					retornoGT.get(cdGT).getTotaisGt().getTempoTrabalhado()));
						
			
			retornoGT.get(cdGT).getTotaisGt().setIndRefugo(new BigDecimal(FormulasInjet.calcularIndiceRefugo(
					retornoGT.get(cdGT).getTotaisGt().getProdRef(), 
					retornoGT.get(cdGT).getTotaisGt().getProdBruta())));			
			
			
		 	// metas 
			if (retornoGT.get(cdGT).getMetasRitmo() != null) {
				if (retornoGT.get(cdGT).getTotaisGt().getIndRitmo().doubleValue() >= retornoGT.get(cdGT).getMetasRitmo().getLimMeta().doubleValue()) {
					retornoGT.get(cdGT).setRitmoNaMeta(true);
				}
			}

			if (retornoGT.get(cdGT).getMetasOEE() != null) {
				if (retornoGT.get(cdGT).getTotaisGt().getOee().doubleValue() >= retornoGT.get(cdGT).getMetasOEE().getLimMeta().doubleValue()) { 
					retornoGT.get(cdGT).setOeeNaMeta(true);
				} 
			}

			if (retornoGT.get(cdGT).getMetasDisp() != null) {
				if (retornoGT.get(cdGT).getTotaisGt().getIndDisponbilidade().doubleValue() >= retornoGT.get(cdGT).getMetasDisp().getLimMeta().doubleValue()) { 
					retornoGT.get(cdGT).setDispNaMeta(true);
				} 
			}
			
			if (retornoGT.get(cdGT).getMetasRefugo() != null) {
				if (retornoGT.get(cdGT).getTotaisGt().getIndRefugo().doubleValue() <= retornoGT.get(cdGT).getMetasRefugo().getLimMeta().doubleValue()) { 
					retornoGT.get(cdGT).setRefugoNaMeta(true);
				} 
			}
			
			retornoGT.get(cdGT).setIdsAnalise(ids);
			

			gerarAlertaRitmoSuper = false;
			gerarAlertaRitmo = false;
			gerarAlertaRefugo = false;
		 	gerarAlertaParada = false;
		 	gerarAlertaPerdaMP = false;
		 	
			// Com OEE e ritmo calculados, necessario avaliar esses indicadores
			if (retornoGT.get(cdGT).isOeeNaMeta()) {
				// OEE bomn, mas o ciclo estar subdimensionado... precisa avaliar
				if (retornoGT.get(cdGT).getTotaisGt().getIndRitmo().doubleValue() > retornoGT.get(cdGT).getMetasRitmo().getLimSup().doubleValue()) {
					// ritmo super (provavel sub-dimensionado do ciclo)
					
					// alerta de ciclo super ... informar que tem que ajustar ciclo
					gerarAlertaRitmoSuper = true;
					
				} else {
					// ritmo bom
					
					// avalia perda de componentes
					retornoGT.get(cdGT).setMaiorPerdaMP(getMaiorPerdaMP(retornoGT.get(cdGT).getIdsAnalise()));		
					if (retornoGT.get(cdGT).getMaiorPerdaMP() != null) {
						gerarAlertaPerdaMP = true;
					}
				}
			} else {
				// oee ruim
				if (! retornoGT.get(cdGT).isDispNaMeta()) {
					// verificar maior perda por parada
					retornoGT.get(cdGT).setMaiorParada(getMaiorParada(retornoGT.get(cdGT).getIdsAnalise()));	
					
					// alerta
					if (retornoGT.get(cdGT).getMaiorParada() != null) {
						gerarAlertaParada = true;
					}
				}
				
				if (! retornoGT.get(cdGT).isRitmoNaMeta()) {
					// alerta
					gerarAlertaRitmo = true;
				}
				
				
				if (! retornoGT.get(cdGT).isRefugoNaMeta()) {
					// verificar maior refugo
					retornoGT.get(cdGT).setMaiorRefugo(getMaiorRefugo(retornoGT.get(cdGT).getIdsAnalise()));	
					
					// alerta
					if (retornoGT.get(cdGT).getMaiorRefugo() != null) {
						gerarAlertaRefugo = true;
					}
				}
				
				// avalia perda de componente
				retornoGT.get(cdGT).setMaiorPerdaMP(getMaiorPerdaMP(retornoGT.get(cdGT).getIdsAnalise()));	
				if (retornoGT.get(cdGT).getMaiorPerdaMP() != null) {
					gerarAlertaPerdaMP = true;
				}
			}
			
			
			
			// alerta com todas as eventuais situacoes acima
			if (gerarAlertaRitmoSuper || gerarAlertaRitmo || gerarAlertaPerdaMP || gerarAlertaParada || gerarAlertaRefugo) {
				alertasIA = new AlertasIADTO();
				alertasIA.setDadosAnaliseGT(retornoGT.get(cdGT));
				alertasIA.setGerarAlertaRitmoSuper(gerarAlertaRitmoSuper);
				alertasIA.setGerarAlertaRitmo(gerarAlertaRitmo);
				alertasIA.setGerarAlertaPerdaMP(gerarAlertaPerdaMP);
				alertasIA.setGerarAlertaParada(gerarAlertaParada);
				alertasIA.setGerarAlertaRefugo(gerarAlertaRefugo);
			
				DwConsolid cnsIdFake = new DwConsolid();
 
				IdwLogger log = new IdwLogger("IAGT");
				int idLog = log.getIdAleatorio();
				int identacao = 0;
				
				/*
				ServicoEmailFactory email = ServicoEmailFactory.getInstance(
						log,
						idLog,
						identacao,
						this.getDao().getSession(),
						ServicoEmailFactory.TpEvt.ANALISE_GTS_IA);
		
				((ServicoEmailAnaliseGtsIARN) email).setAlertaIA(alertasIA);
				email.gerarAlerta(cnsIdFake);
				*/		
 
			}
			 
	 	}
	 	
	 	retorno.getAnalises().addAll(retornoGT.values());
    	return retorno;
    }
    
   
    
    private MaiorPerdaMPWMDTO getMaiorPerdaMP(List<Long> listaIdsCns) {
    	MaiorPerdaMPWMDTO retorno = null;
    	List<Object> listaIds = new ArrayList<Object>();
    	
    	for (int i = 0; i < listaIdsCns.size(); i++) { 
			listaIds.add(listaIdsCns.get(i));
		}
    	
    	GraficoPerdaMateriaPrimaRN rn = new GraficoPerdaMateriaPrimaRN(getDao());
    	GraficoPerdasMpDTO graf = null;// rn.getPerdasMateriaPrima(listaIds);
    	
    	if ( graf!=null && graf.getPerdasMateriaPrima().size() > 0) {
    		retorno = new MaiorPerdaMPWMDTO();
    		retorno.setCdComponente(graf.getPerdasMateriaPrima().get(0).getCdProduto());  
    		retorno.setQtdPerdida(ConversaoTipos.converterParaBigDecimal(graf.getPerdasMateriaPrima().get(0).getQuantidadePerdida()).intValue());    		
    	} 
    	
    	rn = null;
    	graf = null;
    	
    	return retorno;
    }
    
    
    private MaiorParadaWMDTO getMaiorParada(List<Long> listaIdsCns) {
    	MaiorParadaWMDTO retorno = null;
    	List<Object> listaIds = new ArrayList<Object>();
    	GraficoParettoParadaDTO maiorParTempo = null;
    	GraficoParettoParadaDTO maiorParTendAlta = null;
    	
    	for (int i = 0; i < listaIdsCns.size(); i++) { 
			listaIds.add(listaIdsCns.get(i));
		}
    	
    	GraficoParettoParadaRN rn = new GraficoParettoParadaRN(getDao());
    	GraficosParettoParadaDTO graf = rn.getMaiorParadaCPWM(listaIds);
    	
    	if (graf.getParadas().size() > 0) {
    		retorno = new MaiorParadaWMDTO(); 
    		maiorParTempo = new GraficoParettoParadaDTO();
    		maiorParTempo = graf.getParadas().get(0);
    		
    		// verifica se existe parada com tendencia de alta
    		for (GraficoParettoParadaDTO parada : graf.getParadas()) {
    			if (parada.getCorBarra() ==  Cor.transformarParaCodigoHexadecimal(GrafTendenciaUtils.SERIE_VERMELHA)) {
    				// encontrou parada com tendencia de alta... atribui e sai do loop
    				maiorParTendAlta = new GraficoParettoParadaDTO();
    				maiorParTendAlta = parada;
    				break;
    			}
    		}
    		
    		// se existe par com tend de alta, utilizar
    		if (maiorParTendAlta != null) {
    			retorno.setCdParada(maiorParTendAlta.getCdParada());
    			retorno.setDsParada(maiorParTendAlta.getDsParada());
    			retorno.setTempoParCP(new BigDecimal(maiorParTendAlta.getTempo()));
    			retorno.setTempoCPFormatado(maiorParTendAlta.getTempoFormatado());
    			retorno.setTendenciaAlta(true);
    		} else {
    			retorno.setCdParada(maiorParTempo.getCdParada());
    			retorno.setDsParada(maiorParTempo.getDsParada());
    			retorno.setTempoParCP(new BigDecimal(maiorParTempo.getTempo()));
    			retorno.setTempoCPFormatado(maiorParTempo.getTempoFormatado());
    			retorno.setTendenciaAlta(false);    			
    		}
    		
    	} 

		maiorParTempo = null;
		maiorParTendAlta = null;
		
    	rn = null;
    	graf = null;
    	
    	return retorno;
    }
    
    
    private MaiorRefugoWMDTO getMaiorRefugo(List<Long> listaIdsCns) {
    	MaiorRefugoWMDTO retorno = null;
    	List<Object> listaIds = new ArrayList<Object>();
    	GraficoParetoRefugosDTO maiorRefQtd = null;
    	GraficoParetoRefugosDTO maiorRefTendAlta = null;
    	
    	for (int i = 0; i < listaIdsCns.size(); i++) { 
			listaIds.add(listaIdsCns.get(i));
		}
    	
    	GraficoParetoRefugoRN rn = new GraficoParetoRefugoRN(getDao());
    	GraficosParetoRefugosDTO graf = rn.getMaiorRefugoWM(listaIds);
    	
    	if (graf.getRefugos().size() > 0) {
    		retorno = new MaiorRefugoWMDTO(); 
    		maiorRefQtd = new GraficoParetoRefugosDTO();
    		maiorRefQtd = graf.getRefugos().get(0);
    		
    		// verifica se existe parada com tendencia de alta
    		for (GraficoParetoRefugosDTO refugo : graf.getRefugos()) {
    			if (refugo.getCorBarra() ==  Cor.transformarParaCodigoHexadecimal(GrafTendenciaUtils.SERIE_VERMELHA)) {
    				// encontrou parada com tendencia de alta... atribui e sai do loop
    				maiorRefTendAlta = new GraficoParetoRefugosDTO();
    				maiorRefTendAlta = refugo;
    				break;
    			}
    		}
    		
    		// se existe par com tend de alta, utilizar
    		if (maiorRefTendAlta != null) {
    			retorno.setCdRefugo(maiorRefTendAlta.getCdRefugo());
    			retorno.setDsRefugo(maiorRefTendAlta.getDsRefugo());
    			retorno.setQtdRefugada(new BigDecimal(maiorRefTendAlta.getQtdRefugada()));
    			retorno.setTendenciaAlta(true);
    		} else {
    			retorno.setCdRefugo(maiorRefQtd.getCdRefugo());
    			retorno.setDsRefugo(maiorRefQtd.getDsRefugo());
    			retorno.setQtdRefugada(new BigDecimal(maiorRefQtd.getQtdRefugada()));
    			retorno.setTendenciaAlta(false);    			
    		}
    		
    	} 

    	maiorRefQtd = null;
    	maiorRefTendAlta = null;
		
    	rn = null;
    	graf = null;
    	
    	return retorno;
    }
    
    
}
