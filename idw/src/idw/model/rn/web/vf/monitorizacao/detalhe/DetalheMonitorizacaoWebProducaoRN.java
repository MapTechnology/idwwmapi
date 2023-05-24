package idw.model.rn.web.vf.monitorizacao.detalhe;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import ms.util.ConversaoTipos;
import idw.model.dao.DAOGenerico;
import idw.model.dao.PpCpDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsoldef;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwConsolidTemplate.TpId;
import idw.model.rn.AbstractRN;
import idw.model.rn.CpRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoGraficoAreaResponsavelRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebRN.FiltroOp;
import idw.util.AritmeticaUtil;
import idw.util.Cor;
import idw.util.FormulasInjet;
import idw.webservices.dto.DetalhamentoProducaoDTO;
import idw.webservices.dto.DetalheParadaDTO;
import idw.webservices.dto.DetalheProducaoDTO;
import idw.webservices.dto.DetalheRefugoDTO;
import idw.webservices.dto.DwConsolidDTO;
import idw.webservices.dto.DwConsolidDTOs;
import idw.webservices.dto.FiltroDetalheProducaoDTO;
import idw.webservices.dto.FiltroGraficoDetalhePtDTO;
import idw.webservices.dto.GraficoDetalhePtDTO;
import idw.webservices.dto.IndicadorMinMetaMaxDTO;
import idw.webservices.dto.IndicadoresMinMetaMaxDTO;
import idw.webservices.rest.dto.monitorizacao.CicloDetalheDTO;
import idw.webservices.rest.dto.monitorizacao.DetalheProducaoHoraDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalhePostoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoParadaMTDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoPizzaDTO;
import idw.webservices.rest.dto.monitorizacao.GraficosDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoProducaoDetalheDTO;
import idw.webservices.rest.dto.monitorizacao.LegendaMetaDTO;
import idw.webservices.rest.dto.monitorizacao.MTDTO;
import idw.webservices.rest.dto.monitorizacao.MetaIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaParadaHoraDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaProducaoHora;
import idw.webservices.rest.dto.monitorizacao.TabelaRefugoHora;

public class DetalheMonitorizacaoWebProducaoRN extends AbstractRN<DAOGenerico> {
	
	public static final Color COR_MTBF = Color.RED;
	public static final Color COR_MTTR = Color.YELLOW;
	
	public static final Color COR_MARCADOR_GRAFICO_PRODUCAO = Color.MAGENTA;
	
	public static final String CD_INDICADOR_EFICIENCIA_REALIZACAO = "ER";
	public static final String CD_INDICADOR_UTILIZACAO = "U";
	public static final String CD_INDICADOR_PRODUTIVIDADE_OEE = "OEE";
	public static final String CD_INDICADOR_PRODUCAO_LIQUIDA = "PL";
	public static final String CD_INDICADOR_EFICIENCIA_CICLO = "EC";

	private final String formatoData;
	private final String formatoDataHora;
	
	DetalheMonitorizacaoWebIndicadorRN indicadorRN;
	
	private OmPt omPt;
	private PpCp ppCp;
	
	private Session sessao;
	public Session getSession() {
		return this.sessao;
	}
	public void setSession(Session sessao) {
		this.sessao = sessao;
	}
	

	
	public static final Comparator<DwConsolidDTO> comparaPorId = new Comparator<DwConsolidDTO>() {
        @Override
        public int compare(final DwConsolidDTO o1, final DwConsolidDTO o2) {
            return Long.valueOf(o1.getDwConsolid().getIdConsolid()).compareTo(Long.valueOf(o2.getDwConsolid().getIdConsolid()));
        };
    };
    
    public static final Comparator<DwConsolidDTO> comparaPorHoraInicial = new Comparator<DwConsolidDTO>() {
        @Override
        public int compare(final DwConsolidDTO o1, final DwConsolidDTO o2) {
            return DataHoraRN.compareTo(o1.getDwConsolid().getDthrIhora(), o2.getDwConsolid().getDthrIhora());      
        };
    };
    
    public static final Comparator<DwConsolidDTO> comparaPorHoraCadastroOuHoraFinalConsol = new Comparator<DwConsolidDTO>() {
    	@Override
        public int compare(final DwConsolidDTO o1, final DwConsolidDTO o2) {
            Date d1 = o1.getDwConsolid().getDthrFconsol() != null ? o1.getDwConsolid().getDthrFconsol() : o1.getDwConsolid().getDthrCadastro();
            Date d2 = o2.getDwConsolid().getDthrFconsol() != null ? o2.getDwConsolid().getDthrFconsol() : o2.getDwConsolid().getDthrCadastro();
            return d1.compareTo(d2);
        }
    };
	
	public DetalheMonitorizacaoWebProducaoRN(String formatoData, String formatoDataHora) {
        this(new DAOGenerico(), formatoData, formatoDataHora);
    }

    public DetalheMonitorizacaoWebProducaoRN(DAOGenerico dao, String formatoData, String formatoDataHora) {
        super(dao);
        this.formatoData = formatoData;
        this.formatoDataHora = formatoDataHora;
        this.indicadorRN = new DetalheMonitorizacaoWebIndicadorRN(getDao(), formatoData, formatoDataHora);
    }
    
    public GraficosDTO getGraficos(FiltroDetalhePostoDTO filtro) throws RegistroDesconhecidoException {
    	GraficoDetalhePtDTO graficoPorTurno = getDetalheProducaoPorTurno(filtro);
    	GraficoDetalhePtDTO graficoPorHora = getDetalheProducaoPorHora(filtro, graficoPorTurno);
    	
    	List<MetaIndicadorDTO> listaIndicadores = getMetaIndicadoresProducao(filtro.getCdPosto());
    	MetaIndicadorDTO cicloMetaIndicador = DetalheMonitorizacaoWebIndicadorRN.getIndicadorPadraoDosUltimosCiclos();
    	
    	List<GraficoProducaoDetalheDTO> producaoDetalhes = new ArrayList<GraficoProducaoDetalheDTO>();
    	List<CicloDetalheDTO> cicloDetalhes = new ArrayList<CicloDetalheDTO>();
    	
    	List<DwConsolidDTO> listaDwConsolidDTO = graficoPorHora.getDwConsolidDTOs().getListaDwConsolidDTO();
    	Collections.sort(listaDwConsolidDTO, comparaPorHoraInicial);
    	
    	String ultimoMarcador = "";
    	for (DwConsolidDTO dto : listaDwConsolidDTO) {
    		DwConsolid dwconsolid = dto.getDwConsolid();
    		
    		for(DwConsol dwconsol : dto.getDwConsolid().getDwConsols()) {
    			
    			producaoDetalhes.add(getDetalheProducao(dwconsolid, dwconsol, ultimoMarcador, listaIndicadores));
    			cicloDetalhes.add(getDetalheCiclo(dwconsolid, dwconsol, ultimoMarcador, cicloMetaIndicador, graficoPorHora));
    			
    			ultimoMarcador = getMarcador(dwconsolid);
    		}
    	}
    	
    	GraficosDTO graficoDTO = new GraficosDTO();    	
    	graficoDTO.setLegendaMeta(getLegendaMeta(graficoPorHora));
    	graficoDTO.setMetaIndicadores(listaIndicadores);
    	graficoDTO.setCicloMetaIndicador(cicloMetaIndicador);
    	graficoDTO.setProducaoDetalhes(producaoDetalhes);
    	graficoDTO.setCicloDetalhes(cicloDetalhes);
    	graficoDTO.setParadaAreaResponsavelDetalhes(getGraficoParadaAreaResponsavel(graficoPorTurno));
    	graficoDTO.setDefeitoAreaResponsavelDetalhes(getGraficoDefeitoAreaResponsavel(graficoPorTurno));
    	graficoDTO.setParadaMT(getParadaMT(graficoPorHora));
    	
    	return graficoDTO;
    }
    
    public List<FiltroDetalhePostoDTO> getListaFiltroDetalhePostoHora(FiltroDetalhePostoDTO filtro) throws RegistroDesconhecidoException {
    	List<FiltroDetalhePostoDTO> lista = new ArrayList<FiltroDetalhePostoDTO>();
    	
    	GraficoDetalhePtDTO graficoPorTurno = getDetalheProducaoPorTurno(filtro);
    	GraficoDetalhePtDTO graficoPorHora = getDetalheProducaoPorHora(filtro, graficoPorTurno);
    	
    	List<DwConsolidDTO> listaDwConsolidDTO = graficoPorHora.getDwConsolidDTOs().getListaDwConsolidDTO();
    	Collections.sort(listaDwConsolidDTO, comparaPorHoraInicial);
    	
    	DwConsolidDTOs listaGrafico = new DwConsolidDTOs();
    	listaGrafico.setListaDwConsolidDTO(new ArrayList<DwConsolidDTO>());
        listaGrafico.getListaDwConsolidDTO().addAll(listaDwConsolidDTO);
        
        for (int i = 0; i < listaGrafico.getListaDwConsolidDTO().size(); i++) {
        	DwConsolid dwconsolid = listaGrafico.getListaDwConsolidDTO().get(i).getDwConsolid();
            
            FiltroDetalhePostoDTO filtroDTO = new FiltroDetalhePostoDTO();
            filtroDTO.setIdConsolid(dwconsolid.getIdConsolid());
            filtroDTO.setFiltroOp(filtro.getFiltroOp());
            filtroDTO.setCdCp(filtro.getCdCp());
            filtroDTO.setDtReferencia(filtro.getDtReferencia());
            filtroDTO.setDtHrReferenciaInicial(DataHoraRN.dateToString(dwconsolid.getDthrIhora(), formatoDataHora));
            filtroDTO.setDtHrReferenciaFinal(DataHoraRN.dateToString(dwconsolid.getDthrFhora(), formatoDataHora));
            filtroDTO.setIdTurno(filtro.getIdTurno());
            filtroDTO.setCdPosto(filtro.getCdPosto());
            filtroDTO.setTpId(filtro.getTpId());
            
            lista.add(filtroDTO);
        }
    	
    	return lista;
    }
    
    public DetalheProducaoHoraDTO getDetalheProducaoHora(FiltroDetalhePostoDTO filtro) throws RegistroDesconhecidoException {
    	DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN(getDao());
    	DetalhamentoProducaoDTO detalhe = rn.getDetalhamentoProducao(getfiltroDetalheProducaoHora(filtro));
    	
    	DetalheProducaoHoraDTO detalheDTO = new DetalheProducaoHoraDTO();
    	detalheDTO.setDtHrInicial(DataHoraRN.dateToString(detalhe.getDthrinicio(), formatoDataHora));
    	detalheDTO.setDtHrFinal(DataHoraRN.dateToString(detalhe.getDthrfim(), formatoDataHora));
    	detalheDTO.setDuracaoIntervalo(detalhe.getDuracaointervalo());    	
    	detalheDTO.setTempoDisponivel(DataHoraRN.formatSegundosParaHHMMSSmmm(detalhe.getTempodisponivel()));
    	detalheDTO.setHorasTrabalhadas(DataHoraRN.formatSegundosParaHHMMSSmmm(detalhe.getHorastrabalhadas()));
    	detalheDTO.setHorasParadas(ConversaoTipos.converteParaString(detalhe.getHorasparadas(), 0));
    	detalheDTO.setHorasParadasView(DataHoraRN.formatSegundosParaHHMMSSmmm(detalhe.getHorasparadas()));
    	detalheDTO.setIndiceParadas(ConversaoTipos.converteParaString(detalhe.getIndiceparadas(), 2));    	
    	detalheDTO.setUltimoCicloPadrao(ConversaoTipos.converteParaString(detalhe.getUltimocicpadrao(), 2));
    	detalheDTO.setCicloPadraoMedio(ConversaoTipos.converteParaString(detalhe.getCicpadraomedio(), 2));
    	detalheDTO.setCicloMedio(ConversaoTipos.converteParaString(detalhe.getCicmedio(), 2));    	
    	detalheDTO.setPerdasPorCiclo(ConversaoTipos.converteParaString(detalhe.getPerdascic(), 2));
    	detalheDTO.setPerdasPorRefugos(ConversaoTipos.converteParaString(detalhe.getPerdasrefugos(), 2));
    	detalheDTO.setPerdasPorParadas(ConversaoTipos.converteParaString(detalhe.getPerdasparadas(), 2));
    	detalheDTO.setTotalPerdas(ConversaoTipos.converteParaString(detalhe.getTotalperdas(), 2));
    	detalheDTO.setListaProducao(getListaProducao(detalhe));
    	detalheDTO.setListaRefugo(getListaRefugo(detalhe));
    	detalheDTO.setListaParada(getListaParada(detalhe));
    	
    	detalheDTO.setMostrarGraficoPerdas(true);
    	
    	return detalheDTO;
    }
    
    @Deprecated
    public DwConsolid getPrimeiroDwConsolidDoTurno(FiltroDetalhePostoDTO filtro) throws RegistroDesconhecidoException {
    	GraficoDetalhePtDTO graficoPorTurno = getDetalheProducaoPorTurno(filtro);
    	GraficoDetalhePtDTO graficoPorHora = getDetalheProducaoPorHora(filtro, graficoPorTurno);
    	
    	List<DwConsolidDTO> listaDwConsolidDTO = graficoPorHora.getDwConsolidDTOs().getListaDwConsolidDTO();
    	Collections.sort(listaDwConsolidDTO, comparaPorHoraCadastroOuHoraFinalConsol);
    	
    	DwConsolid dwConsolid = listaDwConsolidDTO.get(listaDwConsolidDTO.size() - 1).getDwConsolid();
    	
    	return dwConsolid;
    }
    
    private List<TabelaProducaoHora> getListaProducao(DetalhamentoProducaoDTO detalhe) {
    	List<TabelaProducaoHora> lista = new ArrayList<TabelaProducaoHora>();
    	
    	for(DetalheProducaoDTO producao : detalhe.getListaproducao()) {
    		TabelaProducaoHora dto = new TabelaProducaoHora();
    		
    		dto.setPosto(producao.getMaquina());
    		dto.setFerramenta(producao.getFerramenta());
    		dto.setProduto(producao.getProduto());
    		dto.setProducaoPrevista(ConversaoTipos.converteParaStringCasasOpcionais(producao.getProd_prevista(), 2));
    		dto.setProducaoRealizada(ConversaoTipos.converteParaStringCasasOpcionais(producao.getProd_realizada(), 2));
    		dto.setRefugadas(ConversaoTipos.converteParaStringCasasOpcionais(producao.getProd_refugadas(), 2));
    		dto.setBoas(ConversaoTipos.converteParaStringCasasOpcionais(producao.getProd_boas(), 2));
    		dto.setEficienciaRealizacao(ConversaoTipos.converteParaString(producao.getEficiencia_realizacao(), 2));
    		dto.setEficienciaCiclo(ConversaoTipos.converteParaString(producao.getEficiencia_ciclo(), 2));
    		dto.setPerdasCiclo(ConversaoTipos.converteParaString(producao.getPerdas_ciclo(), 2));
    		dto.setCicloPadrao(ConversaoTipos.converteParaString(producao.getCicloPadrao(), 2));
    		dto.setDtRevisao(DataHoraRN.dateToString(producao.getDtRevisao(), formatoDataHora));
    		dto.setIdFolha(String.valueOf(producao.getIdFolha()));
    		dto.setProducaoCiclo(ConversaoTipos.converteParaString(producao.getProducaoPorCiclo(), 2));
    		
    		lista.add(dto);
    	}
    	
    	return lista;
    }
    
    private List<TabelaRefugoHora> getListaRefugo(DetalhamentoProducaoDTO detalhe) {
    	List<TabelaRefugoHora> lista = new ArrayList<TabelaRefugoHora>();
    	
    	for(DetalheRefugoDTO refugo : detalhe.getListarefugos()) {
    		TabelaRefugoHora dto = new TabelaRefugoHora();
    		
    		dto.setPosto(refugo.getDsPt());
    		dto.setFerramenta(refugo.getFerramenta());
    		dto.setProduto(refugo.getProduto());
    		dto.setRefugo(refugo.getRefugo());
    		dto.setQuantidade(ConversaoTipos.converteParaString(refugo.getQtde_refugo(), 2));
    		dto.setDtHrOcorrencia(DataHoraRN.dateToString(refugo.getDthrocorrencia(), formatoDataHora));
    		dto.setCausa(refugo.getCausa());
    		dto.setAcao(refugo.getAcao());
    		
    		lista.add(dto);
    	}
    	
    	return lista;
    }
    
    private List<TabelaParadaHoraDTO> getListaParada(DetalhamentoProducaoDTO detalhe) {
    	List<TabelaParadaHoraDTO> lista = new ArrayList<TabelaParadaHoraDTO>();
    	
    	for(DetalheParadaDTO parada : detalhe.getListaparadas()) {
    		TabelaParadaHoraDTO dto = new TabelaParadaHoraDTO();
    		
    		dto.setPosto(parada.getDsPt());
    		dto.setFolha(parada.getFolha());
    		dto.setFerramenta(parada.getFerramenta());
    		dto.setParada(parada.getParada());
    		dto.setInicio(DataHoraRN.dateToString(parada.getInicio(), formatoDataHora));
    		dto.setFim(DataHoraRN.dateToString(parada.getFim(), formatoDataHora));
    		dto.setDuracao(parada.getDuracao());
    		dto.setAreaResponsavel(parada.getArea_resp() != null ? parada.getArea_resp().getCdArea() + "-" + parada.getArea_resp().getDsArea() : "");
    		dto.setCausa(parada.getCausa());
    		dto.setAcao(parada.getAcao());
    		dto.setJustificativa(parada.getJustificativa());
    		dto.setTecnico1(parada.getTecnico1());
    		dto.setTecnico2(parada.getTecnico2());
    		dto.setTecnicoResponsavel(parada.getTecnico_responsavel());
    		dto.setPerdasParada(ConversaoTipos.converteParaString(parada.getPerdas_paradas(), 2));
    		dto.setTurno(parada.getTurno());
    		
    		lista.add(dto);
    	}
    	
    	return lista;
    }
    
    private FiltroDetalheProducaoDTO getfiltroDetalheProducaoHora(FiltroDetalhePostoDTO filtro) {
    	FiltroDetalheProducaoDTO filtroConvertido = new FiltroDetalheProducaoDTO();
    	
    	//filtroConvertido.setFiltroOp(filtro.getFiltroOp());
    	
    	PpCpDAO ppCpDAO = new PpCpDAO(getDaoSession());
    	//150915 . VER ANOTACOES. 190515. PpCp ppCp = ppCpDAO.getPpCpPorCdOrdeByIdDesc(filtro.getCdCp());

    	//190515..
    	PpCp ppCp = new PpCp();
    	if (filtro!=null && filtro.getCdCp()!=null){
        	if (filtro.getCdPosto()!=null){
        		ppCp = ppCpDAO.getPpCpPorCdCpPtOrdeByIdDesc(filtro.getCdCp(), filtro.getCdPosto());	
        	} else {
        		ppCp = ppCpDAO.getPpCpPorCdOrdeByIdDesc(filtro.getCdCp());	
        	}
    	}
    	//190515..
    	
    	filtroConvertido.setIdCp(ppCp == null ? 0L : ppCp.getIdCp());
    	
    	filtroConvertido.setDthrinicio(DataHoraRN.stringToDate(filtro.getDtHrReferenciaInicial(), formatoDataHora));
    	filtroConvertido.setDthrfim(DataHoraRN.stringToDate(filtro.getDtHrReferenciaFinal(), formatoDataHora));
    	
    	DwTurno turno = new DwTurno();
    	turno.setIdTurno(filtro.getIdTurno());
    	filtroConvertido.setDwTurno(turno);
    	
    	OmPt posto = new OmPt();
    	posto.setCdPt(filtro.getCdPosto());
    	filtroConvertido.setOmpt(posto);
    	
    	filtroConvertido.setTpId(filtro.getTpId());
    	
    	filtroConvertido.setIddwConsolid(filtro.getIdConsolid());
    	
    	return filtroConvertido;
    }
    
    private GraficoDetalhePtDTO getDetalheProducaoPorHora(FiltroDetalhePostoDTO filtro, GraficoDetalhePtDTO graficoPorTurno) throws RegistroDesconhecidoException {
    	
    	GraficoDetalhePtDTO retorno = new GraficoDetalhePtDTO();//20171129
    	
    	FiltroGraficoDetalhePtDTO filtroConvertidoHora = montarFiltroPorHora(filtro, graficoPorTurno);
    	DetalheMonitorizacaoGraficoAreaResponsavelRN rn = new DetalheMonitorizacaoGraficoAreaResponsavelRN(getDao());
    	
    	retorno = rn.getGraficoDetalhePtDTO(filtroConvertidoHora);//20171129
    	//20171129..
    	if (retorno!=null && retorno.getLimiteinferior()!=null && retorno.getLimitesuperior()!=null){
    		if (retorno.getLimitesuperior().doubleValue() < retorno.getLimiteinferior().doubleValue()){
    			retorno.setLimitesuperior(retorno.getLimiteinferior().doubleValue());
    		}
    	}
    	//20171129.
    	return retorno;
    }
    
    
    private GraficoDetalhePtDTO getDetalheProducaoPorTurno(FiltroDetalhePostoDTO filtro) throws RegistroDesconhecidoException {
    	
    	GraficoDetalhePtDTO retorno = new GraficoDetalhePtDTO();//20171129

    	FiltroGraficoDetalhePtDTO filtroConvertidoTurno = montarFiltroPorTurno(filtro);
    	DetalheMonitorizacaoGraficoAreaResponsavelRN rn = new DetalheMonitorizacaoGraficoAreaResponsavelRN(getDao());
    	
    	retorno = rn.getGraficoDetalhePtDTO(filtroConvertidoTurno);//20171129
    	//20171129..
    	if (retorno!=null && retorno.getLimiteinferior()!=null && retorno.getLimitesuperior()!=null){
    		if (retorno.getLimitesuperior().doubleValue() < retorno.getLimiteinferior().doubleValue()){
    			retorno.setLimitesuperior(retorno.getLimiteinferior().doubleValue());
    		}
    	}
    	//20171129.
    	return retorno;   	
    }

    
    private GraficoProducaoDetalheDTO getDetalheProducao(DwConsolid dwconsolid, DwConsol dwconsol, String ultimoMarcador, List<MetaIndicadorDTO> listaIndicadores) {
    	GraficoProducaoDetalheDTO detalheDTO = new GraficoProducaoDetalheDTO();
    	
		detalheDTO.setHora(getHora(dwconsolid));
		
		boolean isMostrarMarcador = !ultimoMarcador.equals(getMarcador(dwconsolid));
		
		detalheDTO.setMarcadorDs(getMarcador(dwconsolid));
		detalheDTO.setMarcadorCor(Cor.transformarParaCodigoHexadecimal(COR_MARCADOR_GRAFICO_PRODUCAO));
		detalheDTO.setMostrarMarcador(isMostrarMarcador);
		
		detalheDTO.setEficienciaRealizacaoComRefugo(getEficienciaRealizacao(dwconsol, true));
		detalheDTO.setEficienciaRealizacaoSemRefugo(getEficienciaRealizacao(dwconsol, false));
		detalheDTO.setEficienciaUtilizacao(getEficienciaUtilizacao(dwconsol));
		detalheDTO.setEficienciaProdutividade(getProdutividadeOEE(dwconsol));
		detalheDTO.setProducaoLiquida(getProducaoLiquida(dwconsol));
		
		detalheDTO.setDataHoraInicio(
    			dwconsolid.getDthrIhora() == null ? 
    					"" : DataHoraRN.dateToString(dwconsolid.getDthrIhora(), formatoDataHora));
    	detalheDTO.setDataHoraFim(
    			dwconsolid.getDthrFhora() == null ? 
    					"" : DataHoraRN.dateToString(dwconsolid.getDthrFhora(), formatoDataHora));
		
		detalheDTO.setEficienciaRealizacaoComRefugoCor(
				indicadorRN.identificarCorDoIndicador(
						CD_INDICADOR_EFICIENCIA_REALIZACAO, 
						listaIndicadores, 
						detalheDTO.getEficienciaRealizacaoComRefugo()));
		detalheDTO.setEficienciaRealizacaoSemRefugoCor(
				indicadorRN.identificarCorDoIndicador(
						CD_INDICADOR_EFICIENCIA_REALIZACAO, 
						listaIndicadores, 
						detalheDTO.getEficienciaRealizacaoSemRefugo()));
		detalheDTO.setEficienciaUtilizacaoCor(
				indicadorRN.identificarCorDoIndicador(
						CD_INDICADOR_UTILIZACAO, 
						listaIndicadores, 
						detalheDTO.getEficienciaUtilizacao()));
		detalheDTO.setEficienciaProdutividadeCor(
				indicadorRN.identificarCorDoIndicador(
						CD_INDICADOR_PRODUTIVIDADE_OEE, 
						listaIndicadores, 
						detalheDTO.getEficienciaProdutividade()));    			
		detalheDTO.setProducaoLiquidaCor(
				indicadorRN.identificarCorDoIndicador(
						CD_INDICADOR_PRODUCAO_LIQUIDA, 
						listaIndicadores, 
						detalheDTO.getProducaoLiquida()));
		return detalheDTO;
    }
    
    private CicloDetalheDTO getDetalheCiclo(DwConsolid dwconsolid, DwConsol dwconsol, String ultimoMarcador, MetaIndicadorDTO metaIndicador, GraficoDetalhePtDTO graficoDetalhePtDTO) {
    	CicloDetalheDTO detalheDTO = new CicloDetalheDTO();
    	
    	detalheDTO.setDescricao(getHora(dwconsolid));
    	
    	boolean isMostrarMarcador = !ultimoMarcador.equals(getMarcador(dwconsolid));
		
		detalheDTO.setMarcadorDs(getMarcador(dwconsolid));
		detalheDTO.setMarcadorCor(Cor.transformarParaCodigoHexadecimal(COR_MARCADOR_GRAFICO_PRODUCAO));
		detalheDTO.setMostrarMarcador(isMostrarMarcador);
    	
    	Float eficienciaCiclo = FormulasInjet.calcularEficienciaCiclo(dwconsol.getSegAutoCiclopadrao(), dwconsol.getSegAutoCiclomedio());
    	detalheDTO.setEficiencia(ConversaoTipos.converteParaString(eficienciaCiclo, 2));
    	detalheDTO.setDataHoraInicio(
    			dwconsolid.getDthrIhora() == null ? 
    					"" : DataHoraRN.dateToString(dwconsolid.getDthrIhora(), formatoDataHora));
    	detalheDTO.setDataHoraFim(
    			dwconsolid.getDthrFhora() == null ? 
    					"" : DataHoraRN.dateToString(dwconsolid.getDthrFhora(), formatoDataHora));    	
    	detalheDTO.setCicloMedio(ConversaoTipos.converteParaString(dwconsol.getSegAutoCiclomedio(), 2));
    	
    	//TODO: [graficoDetalhePtDTO.getDataIocorrencia()] chegando aqui NULL. Corrigir na RN do VF
    	/* 	TODO: [graficoDetalhePtDTO.getDataIocorrencia()] chegando aqui NULL. Corrigir na RN do VF
    	 * TODO20171129
    	 * 
    	 * 		Banco GBR parametros:
				{
				    "filtroOp": 1,
				    "cdCp": "9174",
				    "dtReferencia": "02/10/2017",
				    "idTurno": 2,
				    "cdPosto": "TECNICO CAMERA",
				    "tpId": 1
				}
    	 */   	
    	//20171129 (defesa enquanto não TODO20171129)
    	String strPrimeiraOcorrenciaDia = "";
    	String strUltimaOcorrenciaDia = "";
    	if (graficoDetalhePtDTO!=null && graficoDetalhePtDTO.getDataIocorrencia()!=null){
    		strPrimeiraOcorrenciaDia = DataHoraRN.dateToString(graficoDetalhePtDTO.getDataIocorrencia().getTime(), formatoDataHora);    		
    	}
    	else{
    		strPrimeiraOcorrenciaDia = DataHoraRN.dateToString(dwconsolid.getDtReferencia(), formatoDataHora);
    	}
    	if (graficoDetalhePtDTO!=null && graficoDetalhePtDTO.getDataFocorrencia()!=null){
    		strUltimaOcorrenciaDia = DataHoraRN.dateToString(graficoDetalhePtDTO.getDataFocorrencia().getTime(), formatoDataHora);    		
    	}
    	else{
    		strUltimaOcorrenciaDia = DataHoraRN.dateToString(dwconsolid.getDtReferencia(), formatoDataHora);
    	}
    	
    	
    	detalheDTO.setPrimeiraOcorrenciaDoDia(strPrimeiraOcorrenciaDia);
    	detalheDTO.setUltimaOcorrenciaDoDia(strUltimaOcorrenciaDia);
    	
    	detalheDTO.setEficienciaCor(
				indicadorRN.identificarCorDoIndicador(
						metaIndicador, 
						detalheDTO.getEficiencia()));
    	
    	return detalheDTO;
    }
    
    //fonte: Netbeans DetalheMonitorizacaoPTInjetGUI.getGraficoDetalhePtPorTurno
    private FiltroGraficoDetalhePtDTO montarFiltroPorTurno(FiltroDetalhePostoDTO filtro) throws RegistroDesconhecidoException {
    	FiltroGraficoDetalhePtDTO retorno = new FiltroGraficoDetalhePtDTO();
    	
    	PTRN ptRN = new PTRN(getDao());
    	this.omPt = ptRN.getOmPt(filtro.getCdPosto());
    	retorno.setOmPt(this.omPt);
    	
    	CpRN cpRN = new CpRN(getDao());
    	this.ppCp = cpRN.pesquisarPpCpByCdCpCdPt(filtro.getCdCp(), filtro.getCdPosto());    	
    	if(filtro.getFiltroOp() == FiltroOp.ULTIMA_OP_NO_TURNO.getValor()) {
    		if (this!=null && this.ppCp!=null && this.ppCp.getIdCp()!=null){
    			retorno.setIdCp(this.ppCp.getIdCp());	
    		} else {
    			retorno.setIdCp(0L);
    		}
        }
    	
    	retorno.setDtReferencia(DataHoraRN.stringToDate(filtro.getDtReferencia(), formatoData));
    	
    	DwTurno turno = new DwTurno();
    	turno.setIdTurno(filtro.getIdTurno());
    	retorno.setDwTurno(turno);
    	
    	retorno.setTpId(filtro.getTpId());
    	
    	retorno.setComParadas(true);
    	return retorno;
    }
    
    //fonte: Netbeans DetalheMonitorizacaoPTInjetGUI.getGraficoDetalhePtPorHora
    private FiltroGraficoDetalhePtDTO montarFiltroPorHora(FiltroDetalhePostoDTO filtro, GraficoDetalhePtDTO graficoPorTurno) throws RegistroDesconhecidoException {
    	if (graficoPorTurno.getDwConsolidDTOs() == null 
    			|| graficoPorTurno.getDwConsolidDTOs().getListaDwConsolidDTO() == null
    			|| graficoPorTurno.getDwConsolidDTOs().getListaDwConsolidDTO().isEmpty()) {
            return null;
        }
    	
    	List<DwConsolidDTO> listaDwConsolidDTO = graficoPorTurno.getDwConsolidDTOs().getListaDwConsolidDTO();
        Collections.sort(listaDwConsolidDTO, comparaPorId);
        DwConsolid dwConsolid = listaDwConsolidDTO.get(listaDwConsolidDTO.size() - 1).getDwConsolid();
        
        Date dthrFhora = dwConsolid.getDthrFturno();
        if (DataHoraRN.after(dthrFhora, DataHoraRN.getDataHoraAtual())) {
        	dthrFhora = DataHoraRN.getDataHoraAtual();
        }
        Date dthrIhora = DataHoraRN.subtraiDiasDaData(dthrFhora, 1);
        
        FiltroGraficoDetalhePtDTO filtroPorHora = new FiltroGraficoDetalhePtDTO();
        filtroPorHora.setTpId(TpId.HORA.getValue());
        filtroPorHora.setOmPt(omPt);
        filtroPorHora.setDthrIhora(dthrIhora);
        filtroPorHora.setDthrFhora(dthrFhora);
        
        if(filtro.getFiltroOp() == FiltroOp.ULTIMA_OP_NO_TURNO.getValor()) {
        	if (this!=null && this.ppCp!=null && this.ppCp.getIdCp()!=null){
        		filtroPorHora.setIdCp(this.ppCp.getIdCp());	
    		} else {
    			filtroPorHora.setIdCp(0L);
    		}
        	
        }
        
        return filtroPorHora;
    }
    
    // fonte: Netbeans GraficoProducaoBarra.getEficRealizacao
    private String getEficienciaRealizacao(DwConsol dwconsol, boolean isConsiderarRefugo) {
    	Double retorno;
        Long producaoBruta;
        Long producaoRefugada;

        Long producaoLiquida;
        Long producaoPrevista;

        producaoPrevista = dwconsol.getPcsAutoProducaoprevista() != null ? dwconsol.getPcsAutoProducaoprevista().longValue() : 0l;
        producaoPrevista += dwconsol.getPcsManuProducaoprevista() != null ? dwconsol.getPcsManuProducaoprevista().longValue() : 0l;
        producaoBruta = dwconsol.getPcsAutoProducaobruta() != null ? dwconsol.getPcsAutoProducaobruta().longValue() : 0l;
        producaoBruta += dwconsol.getPcsManuProducaobruta() != null ? dwconsol.getPcsManuProducaobruta().longValue() : 0l;
        producaoRefugada = dwconsol.getPcsAutoProducaorefugada() != null ? dwconsol.getPcsAutoProducaorefugada().longValue() : 0l;
        producaoRefugada += dwconsol.getPcsManuProducaorefugada() != null ? dwconsol.getPcsManuProducaorefugada().longValue() : 0l;

        if(isConsiderarRefugo) {
        	producaoLiquida = producaoBruta - producaoRefugada;
        } else {
        	producaoLiquida = producaoBruta;
        }

        retorno = FormulasInjet.calcularEficienciaRealizacao(
        		new BigDecimal(producaoLiquida), new BigDecimal(producaoPrevista));
        return ConversaoTipos.converteParaString(retorno, 2);
    }
    
    // fonte: Netbeans GraficoProducaoBarra.getEficUtilizacao
    private String getEficienciaUtilizacao(DwConsol dwconsol) {
    	Float retorno = FormulasInjet.calcularUtilizacao(dwconsol.getSegAutoTempotrabalhado(), dwconsol.getSegAutoTempoativo());
    	return ConversaoTipos.converteParaString(retorno, 2);
    }
    
    // fonte: Netbeans GraficoProducaoBarra.getProdOEE
    private String getProdutividadeOEE(DwConsol dwconsol) {
    	Float retorno = FormulasInjet.calcularOEE(dwconsol.getSegAutoTempoprodutivo(), dwconsol.getSegAutoTempoativo());
    	return ConversaoTipos.converteParaString(retorno, 2);
    }
    
    // fonte: Netbeans GraficoProducaoBarra.setarValorBarraProduzido
    private String getProducaoLiquida(DwConsol dwconsol) {
    	BigDecimal produzido = dwconsol.getPcsAutoProducaobruta();
        if(produzido == null){
            produzido = BigDecimal.ZERO;
        }
        // Ajusta producao manual
        if (dwconsol.getPcsManuProducaobruta() != null) {
            produzido = produzido.add(dwconsol.getPcsManuProducaobruta());
        }
        // Ajusta producao refugada
        if (dwconsol.getPcsAutoProducaorefugada() != null) {
            produzido = produzido.subtract(dwconsol.getPcsAutoProducaorefugada());
        }
        return ConversaoTipos.converteParaString(produzido, 2);
    }
    
    private List<MetaIndicadorDTO> getMetaIndicadoresProducao(String cdPosto) {
    	
    	IndicadoresMinMetaMaxDTO indicadores = indicadorRN.getIndicadores(cdPosto);
    	
    	List<MetaIndicadorDTO> lista = new ArrayList<MetaIndicadorDTO>();
    	
    	for(int i=0; i<4; i++) {
    		MetaIndicadorDTO dto = new MetaIndicadorDTO();
    		dto.setCdIndicador("");
    		dto.setDsIndicador("");
    		dto.setValorLegendaSuperior("100");
    		dto.setValorLegendaMeta("85");
    		dto.setValorLegendaInferior("50");
    		dto.setCorLegendaSuperior(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_SUPERIOR));
    		dto.setCorLegendaMeta(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_META));
    		dto.setCorLegendaInferior(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebIndicadorRN.COR_INDICADOR_INFERIOR));
    		dto.setMelhorAcimaMeta(true);
    		lista.add(dto);
    	}
    	
    	lista.get(0).setCdIndicador(CD_INDICADOR_EFICIENCIA_REALIZACAO);
    	lista.get(0).setDsIndicador("Eficiência de realização");
    	lista.get(0).setValorLegendaSuperior("70");
    	lista.get(0).setValorLegendaMeta("");
    	lista.get(0).setValorLegendaInferior("50");
    	
    	IndicadorMinMetaMaxDTO indicadorUtilizacao = indicadorRN.extrairIndicador("UTIL", indicadores);
    	
    	lista.get(1).setCdIndicador(CD_INDICADOR_UTILIZACAO);
    	lista.get(1).setDsIndicador("Utilização");
    	if(indicadorUtilizacao != null) {
    		lista.get(1).setValorLegendaSuperior(ConversaoTipos.converteParaString(indicadorUtilizacao.getIndSuperior(), 2));
        	lista.get(1).setValorLegendaMeta(ConversaoTipos.converteParaString(indicadorUtilizacao.getIndMeta(), 2));
        	lista.get(1).setValorLegendaInferior(ConversaoTipos.converteParaString(indicadorUtilizacao.getIndInferior(), 2));
    	} else {
    		lista.get(1).setValorLegendaSuperior("90");
        	lista.get(1).setValorLegendaMeta("");
        	lista.get(1).setValorLegendaInferior("50");
    	}
    	
    	lista.get(2).setCdIndicador(CD_INDICADOR_PRODUTIVIDADE_OEE);
    	lista.get(2).setDsIndicador("Produtividade (OEE)");
    	lista.get(2).setValorLegendaSuperior("85");
    	lista.get(2).setValorLegendaMeta("");
    	lista.get(2).setValorLegendaInferior("50");
    	
    	lista.get(3).setCdIndicador(CD_INDICADOR_PRODUCAO_LIQUIDA);
    	lista.get(3).setDsIndicador("Produção liquida");
    	
		lista.add(DetalheMonitorizacaoWebIndicadorRN.getIndicadorPadraoDosUltimosCiclos());
    	
    	return lista;
    }
    
    // fonte: Netbeans DetalheMonitorizacaoPTInjetMain.calcularValoresGraficoAreaResponsavel
    private List<GraficoPizzaDTO> getGraficoParadaAreaResponsavel(GraficoDetalhePtDTO graficoDetalhePtDTO) {
    	List<GraficoPizzaDTO> listaGrafico = new ArrayList<GraficoPizzaDTO>();
    	
    	Map<String, List<Object>> mapChaveArea = new HashMap<String, List<Object>>();
    	final int CODIGO = 0;
    	final int TEMPO_PARADA = 1;
    	
    	Double tempoParadaTotal = 0d;
    	DwConsolidDTOs consolidDTOS = graficoDetalhePtDTO.getDwConsolidDTOs();
        List<DwConsolidDTO> listaDTO = consolidDTOS.getListaDwConsolidDTO();
        for (DwConsolidDTO dto : listaDTO) {
            DwConsolid dwconsolid = dto.getDwConsolid();

            if (dwconsolid != null) {
                if (dwconsolid.getDwConsols() != null) {

                    for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
                        if (dwconsol.getDwConsolpas() != null) {
                            for (DwConsolpa dwconsolpa : dwconsol.getDwConsolpas()) {
                            	
                                Double tempoParada = dwconsolpa.getSegAutoTempoparadaCp() != null ? dwconsolpa.getSegAutoTempoparadaCp().doubleValue() : 0d;
                                tempoParada += dwconsolpa.getSegManuTempoparadaCp() != null ? dwconsolpa.getSegManuTempoparadaCp().doubleValue() : 0d;
                                tempoParadaTotal += tempoParada;
                                
                                if (dwconsolpa.getDwTParada() != null) {
                                    DwTArea area = dwconsolpa.getDwTParada().getDwTArea();
                                    
                                    boolean isAreaDesconhecida = area == null || area.getDsArea() == null || area.getDsArea().equals("");
                                    
                                    if(isAreaDesconhecida) {
                                    	// netbeans corta as areas desconhecidas
                                    	continue;
                                    }
                                    
                                    String chaveArea = isAreaDesconhecida ? "ÁREA DESCONHECIDA" : area.getDsArea();
                                    
                                    List<Object> objetoArea = mapChaveArea.get(chaveArea);
                                    if(objetoArea != null) {
                                    	Double tempoParadaObjeto = (Double) objetoArea.get(TEMPO_PARADA);
                                    	tempoParada += tempoParadaObjeto;
                                    }
                                    objetoArea = new ArrayList<Object>();
                                    objetoArea.add(area.getCdArea());
                                    objetoArea.add(tempoParada);
                                    mapChaveArea.put(chaveArea, objetoArea);
                                }
                            }
                        }
                    }
                }
            }
        }
        
        int quantidadeDeCores = mapChaveArea.size();
        List<Color> cores = Cor.getListaDeCores(quantidadeDeCores);
        
        // imitando gambiarra do desktop para bater os valores
        for(String chave : mapChaveArea.keySet()) {
        	Double tempoParada = (Double) mapChaveArea.get(chave).get(TEMPO_PARADA);
        	if (tempoParada == 0) {
        		mapChaveArea.get(chave).set(TEMPO_PARADA, 1d);
        		tempoParadaTotal += 1d;
        	}
        }
        
        int posicao = 0;
        for(String chave : mapChaveArea.keySet()) {
        	Color cor = cores.get(posicao);
        	posicao++;
        	
        	Double valor = (Double) mapChaveArea.get(chave).get(TEMPO_PARADA);        	
        	BigDecimal indice = AritmeticaUtil.calcularPorcentagem(new BigDecimal(valor), new BigDecimal(tempoParadaTotal));
        	
        	GraficoPizzaDTO grafico = new GraficoPizzaDTO();
        	grafico.setCodigo((String) mapChaveArea.get(chave).get(CODIGO));
        	grafico.setDescricao(chave);
        	grafico.setValor(DataHoraRN.formatSegundosParaHHMMSSmmm(valor));
        	grafico.setIndice(ConversaoTipos.converteParaString(indice, 2));
        	grafico.setCor(Cor.transformarParaCodigoHexadecimal(cor));
        	listaGrafico.add(grafico);
        }
    	
    	return listaGrafico;
    }
    
    // fonte: Netbeans DetalheMonitorizacaoPTInjetMain.calcularValoresGraficoAreaResponsavelDefeito
    private List<GraficoPizzaDTO> getGraficoDefeitoAreaResponsavel(GraficoDetalhePtDTO graficoDetalhePtDTO) {
    	List<GraficoPizzaDTO> listaGrafico = new ArrayList<GraficoPizzaDTO>();
    	
    	Map<String, Double> mapChaveArea = new HashMap<String, Double>();
    	
    	Double quantidadeTotal = 0d;
    	DwConsolidDTOs consolidDTOS = graficoDetalhePtDTO.getDwConsolidDTOs();
        List<DwConsolidDTO> listaDTO = consolidDTOS.getListaDwConsolidDTO();
        for (DwConsolidDTO dto : listaDTO) {
            DwConsolid dwconsolid = dto.getDwConsolid();

            if (dwconsolid != null) {
                if (dwconsolid.getDwConsols() != null) {

                    for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
                    	if (dwconsol.getDwConsoldefs() != null) {
                            for (DwConsoldef dwConsoldef : dwconsol.getDwConsoldefs()) {
                            	
                            	Double quantidadeDefeitos = dwConsoldef.getQtDefeitos().doubleValue();
                                
                                if (dwConsoldef.getDwTArea() != null) {
                                    DwTArea area = dwConsoldef.getDwTArea();
                                    
                                    boolean isAreaDesconhecida = area == null || area.getDsArea() == null || area.getDsArea().equals("");
                                    String chaveArea = isAreaDesconhecida ? "ÁREA DESCONHECIDA" : area.getDsArea();
                                    
                                    Double quantidadeArea = mapChaveArea.get(chaveArea);
                                    if(quantidadeArea != null) {
                                    	quantidadeDefeitos += quantidadeArea;
                                    }
                                    mapChaveArea.put(chaveArea, quantidadeDefeitos);
                                }
                            }
                        }
                    }
                }
            }
        }
        
        int posicao = 0;
        for(String chave : mapChaveArea.keySet()) {
        	Color cor = getCor(posicao);
        	posicao++;
        	
        	Double valor = mapChaveArea.get(chave);
        	BigDecimal indice = AritmeticaUtil.calcularPorcentagem(new BigDecimal(valor), new BigDecimal(quantidadeTotal));
        	
        	GraficoPizzaDTO grafico = new GraficoPizzaDTO();
        	grafico.setCodigo(chave);
        	grafico.setValor(DataHoraRN.formatSegundosParaHHMMSSmmm(valor));
        	grafico.setIndice(ConversaoTipos.converteParaString(indice, 2));
        	grafico.setCor(Cor.transformarParaCodigoHexadecimal(cor));
        	listaGrafico.add(grafico);
        }
    	
    	return listaGrafico;
    }
    
    @Deprecated
    /**
     * usar Cor.getListaDeCores
     */
	private Color getCor(int posicao) {
		switch (posicao) {
		case 0:
			return Color.BLUE;
		case 1:
			return Color.RED;
		case 2:
			return Color.GRAY;
		case 3:
			return Color.CYAN;
		case 4:
			return new Color(255, 153, 102);
		case 5:
			return Color.YELLOW;
		case 6:
			return Color.PINK;
		default:
			return Color.BLACK;
		}
	}
    
    private LegendaMetaDTO getLegendaMeta(GraficoDetalhePtDTO consultaDTO) {
    	LegendaMetaDTO legendaDTO = new LegendaMetaDTO();
    	
    	legendaDTO.setMetaHora(ConversaoTipos.converteParaString(consultaDTO.getMetaHora(), 0));
    	legendaDTO.setCavidadesAtivas(ConversaoTipos.converteParaString(consultaDTO.getCavAtivas(), 0));
    	legendaDTO.setLse(ConversaoTipos.converteParaString(consultaDTO.getLimitesuperior(), 3));
    	legendaDTO.setMeta(ConversaoTipos.converteParaString(consultaDTO.getCicloPadrao(), 3));
    	legendaDTO.setLie(ConversaoTipos.converteParaString(consultaDTO.getLimiteinferior(), 3));
    	
    	return legendaDTO;
    }
    
    private GraficoParadaMTDTO getParadaMT(GraficoDetalhePtDTO consultaDTO) {
    	GraficoParadaMTDTO paradaMT = calcularValoresMttrMtbf(consultaDTO);
    	return paradaMT;
    }
    
    // fonte: Netbeans DetalheMonitorizacaoPTInjetMain.calcularvaloresMttrMtbf
    private GraficoParadaMTDTO calcularValoresMttrMtbf(GraficoDetalhePtDTO graficodetalheptDTO) {
        Double tempoAtivo = 0d;
        Double tempoMTTR = 0d;
        Integer ocorrenciaMTBF = 0;
        DwConsolidDTOs dwconsolidDTOS = graficodetalheptDTO.getDwConsolidDTOs();

        if (dwconsolidDTOS.getListaDwConsolidDTO() != null) {
            for (DwConsolidDTO dwconsolidDTO : dwconsolidDTOS.getListaDwConsolidDTO()) {
                DwConsolid dwconsolid = dwconsolidDTO.getDwConsolid();

                if (dwconsolid.getDwConsols() != null) {
                    for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
                    	tempoAtivo += dwconsol.getSegAutoTempoativo() != null ? dwconsol.getSegAutoTempoativo().longValue() : 0l;
                    	tempoAtivo += dwconsol.getSegManuTempoativo() != null ? dwconsol.getSegManuTempoativo().longValue() : 0l;

                        tempoMTTR += dwconsol.getSegAutoTempoparadamtbf() != null ? dwconsol.getSegAutoTempoparadamtbf().longValue() : 0l;
                        tempoMTTR += dwconsol.getSegManuTempoparadamtbf() != null ? dwconsol.getSegManuTempoparadamtbf().longValue() : 0l;

                        ocorrenciaMTBF += dwconsol.getQtAutoOcoparadamtbf() != null ? dwconsol.getQtAutoOcoparadamtbf().intValue() : 0;
                        ocorrenciaMTBF += dwconsol.getQtManuOcoparadamtbf() != null ? dwconsol.getQtManuOcoparadamtbf().intValue() : 0;
                    }
                }
            }
        }

        Float mttr = FormulasInjet.calcularMTTR(BigDecimal.valueOf(tempoMTTR), ocorrenciaMTBF);
        Float mtbf = FormulasInjet.calcularMTBF(BigDecimal.valueOf(tempoAtivo), ocorrenciaMTBF);

        tempoAtivo = tempoAtivo / 60;
        tempoMTTR = tempoMTTR / 60;

        GraficoParadaMTDTO paradaMT = new GraficoParadaMTDTO();
        paradaMT.setTempoAtivo(ConversaoTipos.converteParaString(tempoAtivo, 2));
        paradaMT.setTempoParadaMTTR(ConversaoTipos.converteParaString(tempoMTTR, 2));
        paradaMT.setQuantidadeOcorrenciasMTs(ocorrenciaMTBF.toString());
        paradaMT.setMtbf(ConversaoTipos.converteParaString(mtbf, 2));
        paradaMT.setMttr(ConversaoTipos.converteParaString(mttr, 2));
        preencherListasParadaMT(graficodetalheptDTO, paradaMT);
        return paradaMT;
    }
    
    private void preencherListasParadaMT(GraficoDetalhePtDTO graficodetalheptDTO, GraficoParadaMTDTO graficoDTO) {
    	List<MTDTO> listaMTBF = new ArrayList<MTDTO>();
    	List<MTDTO> listaMTTR = new ArrayList<MTDTO>();
    	
    	DwConsolidDTOs dwconsoliddtos = graficodetalheptDTO.getDwConsolidDTOs();
        List<DwConsolidDTO> listaDTO  = dwconsoliddtos.getListaDwConsolidDTO();
        for(DwConsolidDTO dto :listaDTO){
            DwConsolid dwconsolid = dto.getDwConsolid();
            if (dwconsolid != null) {
                if (dwconsolid.getDwConsols() != null) {
                    for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
                    	
                    	Long tempoativo = dwconsol.getSegAutoTempoativo() != null ? dwconsol.getSegAutoTempoativo().longValue() : 0l;
                        tempoativo += dwconsol.getSegManuTempoativo() != null ? dwconsol.getSegManuTempoativo().longValue() : 0l;
                        
                        Long tempoparada = dwconsol.getSegAutoTempoparadamtbf() != null ? dwconsol.getSegAutoTempoparadamtbf().longValue() : 0l;
                        tempoparada += dwconsol.getSegManuTempoparadamtbf() != null ? dwconsol.getSegManuTempoparadamtbf().longValue() : 0l;
                        
                        Integer qtdeOcorrenciaParadaMTBF = dwconsol.getQtAutoOcoparadamtbf() != null ? dwconsol.getQtAutoOcoparadamtbf().intValue() : 0;
                        qtdeOcorrenciaParadaMTBF += dwconsol.getQtManuOcoparadamtbf() != null ? dwconsol.getQtManuOcoparadamtbf().intValue() : 0;
                        
                        Integer qtdeOcorrenciaParadaMTTR = dwconsol.getQtAutoOcoparadamtbf() != null ? dwconsol.getQtAutoOcoparadamtbf().intValue() : 0;
                        qtdeOcorrenciaParadaMTTR += dwconsol.getQtManuOcoparadamtbf() != null ? dwconsol.getQtManuOcoparadamtbf().intValue() : 0;
                        
                        Float valorMTBF = FormulasInjet.calcularMTBF(BigDecimal.valueOf(tempoativo), qtdeOcorrenciaParadaMTBF);
                        Float valorMTTR = FormulasInjet.calcularMTTR(BigDecimal.valueOf(tempoparada), qtdeOcorrenciaParadaMTTR);
                        
                        String descricao = dwconsolid.getDthrIhora() != null ? DataHoraRN.dateToStringHH(dwconsolid.getDthrIhora()) : "";
                        String dtHrInicio = dwconsolid.getDthrIhora() != null ? DataHoraRN.dateToStringDDMMYYYYHHMMSS(dwconsolid.getDthrIhora()) : "";
                        String dtHrFim = dwconsolid.getDthrFhora() != null ? DataHoraRN.dateToStringDDMMYYYYHHMMSS(dwconsolid.getDthrFhora()) : "";
                        
                        MTDTO mtbf = new MTDTO();
                        mtbf.setValor(ConversaoTipos.converteParaString(valorMTBF, 2));
                        mtbf.setDescricao(descricao);
                        mtbf.setDtHrInicio(dtHrInicio);
                        mtbf.setDtHrFim(dtHrFim);
                        mtbf.setCor(Cor.transformarParaCodigoHexadecimal(COR_MTBF));
                        
                        if(valorMTBF > 0f) {
                        	listaMTBF.add(mtbf);
                        }
                        
                        MTDTO mttr = new MTDTO();
                        mttr.setValor(ConversaoTipos.converteParaString(valorMTTR, 2));
                        mttr.setDescricao(descricao);
                        mttr.setDtHrInicio(dtHrInicio);
                        mttr.setDtHrFim(dtHrFim);
                        mttr.setCor(Cor.transformarParaCodigoHexadecimal(COR_MTTR));
                        
                        if(valorMTTR > 0f) {
                        	listaMTTR.add(mttr);
                        }
                    }
                }
            }
        }
        
        graficoDTO.setListaMTBF(listaMTBF);
        graficoDTO.setListaMTTR(listaMTTR);
    }
    
    private String getHora(DwConsolid dwconsolid) {
    	return dwconsolid.getDthrIhora() != null ? DataHoraRN.dateToStringHH(dwconsolid.getDthrIhora()) + "h" : "";
    }
    
    private String getMarcador(DwConsolid dwconsolid) {
    	return dwconsolid.getDwTurno().getDsTurno();
    }
}
