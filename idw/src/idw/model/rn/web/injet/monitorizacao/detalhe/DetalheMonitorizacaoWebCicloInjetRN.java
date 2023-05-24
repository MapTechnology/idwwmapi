package idw.model.rn.web.injet.monitorizacao.detalhe;

//TODO: 201804 A confirmar se usa mesmo este (e OUTROS semelhantes) [DetalheMonitorizacaoWebIndicadorRN do vf] ou [DetalheMonitorizacaoWebIndicadorInjetRN do injet]


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.model.rn.detalhemonitorizacao.GraficoBIParetoPerdasRN;
import idw.model.rn.injet.FuncoesApoioInjet;
import idw.model.rn.monitorizacao.injet.DetalheMonitorizacaoPTInjetRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebIndicadorRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebIndicadorRN.IndicadoresValorPadrao;
import idw.webservices.dto.CapabilidadeProcessoDTO;
import idw.webservices.dto.CicloDTO;
import idw.webservices.dto.CiclosDTO;
import idw.webservices.dto.DetalheMonitorizacaoPTInjetDTO;
import idw.webservices.dto.DwFolhaDTO;
import idw.webservices.dto.DwFolhasDTO;
import idw.webservices.dto.FiltroAnaliseTurnoDTO;
import idw.webservices.dto.FiltroCiclosDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.GraficoBIParetoDTO;
import idw.webservices.dto.GraficoBIParetoDetCiclosOrdemMaquinaDTO;
import idw.webservices.dto.GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO;
import idw.webservices.dto.GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO;
import idw.webservices.dto.GraficoBIParetoDetCiclosOrdemProdutoDTO;
import idw.webservices.dto.GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO;
import idw.webservices.dto.GraficoBIParetoDetTodasDTO;
import idw.webservices.dto.GraficoBIParetoPerdasDTO;
import idw.webservices.dto.ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO;
import idw.webservices.dto.ListaGraficoBIParetoDetCiclosOrdemProdutoDTO;
import idw.webservices.dto.ListaGraficoBIParetoDetTodasDTO;
import idw.webservices.rest.dto.monitorizacao.CicloDetalheDTO;
import idw.webservices.rest.dto.monitorizacao.CicloParadaDTO;
import idw.webservices.rest.dto.monitorizacao.DetalheCicloDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalhePostoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroPerdaGanhoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoDetalheCicloDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoEvolucaoCicloPadraoDTO;
import idw.webservices.rest.dto.monitorizacao.MetaIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.PerdaGanhoDTO;
import idw.webservices.rest.dto.monitorizacao.ResumoPerdaGanhoCicloDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaPerdaGanhoCicloDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaPerdaGanhoTodosDTO;
import idw.webservices.rest.dto.monitorizacao.UltimosCicloDTO;
import ms.util.ConversaoTipos;

public class DetalheMonitorizacaoWebCicloInjetRN extends AbstractRN<DAOGenericoInjet> {
	
	public static final int ORDERNAR_POR_POSTO = 0;
	public static final int ORDERNAR_POR_PECAS = 1;
	public static final int ORDERNAR_POR_PESO = 2;
	public static final int ORDERNAR_POR_CUSTO = 3;
	public static final int QUANTIDADE_CICLOS_NO_GRAFICO = 50;
	
	private final String formatoData;
	private final String formatoDataHora;
	private final String formatoHora = "HH:mm:ss";
	
	private FiltroWebInjetRN filtroRN;
	private DetalheMonitorizacaoWebInjetRN detalheRN;
	private DetalheMonitorizacaoWebIndicadorInjetRN indicadorRN;
	private MetaIndicadorDTO metaIndicador;
	private GraficoBIParetoPerdasRN graficoBIParetoPerdasRN;
	
	public DetalheMonitorizacaoWebCicloInjetRN(String formatoData, String formatoDataHora) {
        this(new DAOGenericoInjet(), new DAOGenerico(), formatoData, formatoDataHora);
    }

    public DetalheMonitorizacaoWebCicloInjetRN(DAOGenericoInjet dao, DAOGenerico daoVF, String formatoData, String formatoDataHora) {
        super(dao);
        this.formatoData = formatoData;
        this.formatoDataHora = formatoDataHora;
        this.iniciarObjeto(dao, daoVF);
    }
    
    private void iniciarObjeto(DAOGenericoInjet dao, DAOGenerico daoVF) {
    	this.filtroRN = new FiltroWebInjetRN(getDao(), formatoData, formatoDataHora);
    	this.detalheRN = new DetalheMonitorizacaoWebInjetRN(getDao(), formatoData, formatoDataHora);
    	this.indicadorRN = new DetalheMonitorizacaoWebIndicadorInjetRN(dao, formatoData, formatoDataHora);
    	this.graficoBIParetoPerdasRN = new GraficoBIParetoPerdasRN(daoVF);
    	this.metaIndicador = DetalheMonitorizacaoWebIndicadorInjetRN.getIndicadorPerdasProduto();
    }
        
    public UltimosCicloDTO getUltimosCiclos(FiltroDetalhePostoDTO filtro) throws RegistroDesconhecidoException {
    	UltimosCicloDTO ultimosCicloDTO = new UltimosCicloDTO();
    	
    	DetalheMonitorizacaoPTInjetRN rn = new DetalheMonitorizacaoPTInjetRN(getDao());
    	CiclosDTO consultaDTO = rn.getUltimosCiclos(montarFiltroUltimosCiclos(filtro));
    	
    	List<CicloDetalheDTO> listaCicloDetalhe50 = getListaCicloDetalhe50(consultaDTO);
    	List<CicloDetalheDTO> listaCicloDetalhe = getListaCicloDetalhe(consultaDTO);    	
    	
    	ultimosCicloDTO.setNumeroCiclos(String.valueOf(listaCicloDetalhe.size()));
    	if(consultaDTO.getCapabilidadeProcessoDTO() != null) {
    		CapabilidadeProcessoDTO cpDTO = consultaDTO.getCapabilidadeProcessoDTO();
    		ultimosCicloDTO.setMedia(ConversaoTipos.converteParaString(cpDTO.getMedia(), 3, true));
    		ultimosCicloDTO.setDesvioPadrao(ConversaoTipos.converteParaString(cpDTO.getDesvioPadrao(), 3, true));
    		ultimosCicloDTO.setCp(ConversaoTipos.converteParaString(cpDTO.getCp(), 3, true));
    		ultimosCicloDTO.setCpi(ConversaoTipos.converteParaString(cpDTO.getCpi(), 3, true));
    		ultimosCicloDTO.setCps(ConversaoTipos.converteParaString(cpDTO.getCps(), 3, true));
    		ultimosCicloDTO.setCpk(ConversaoTipos.converteParaString(cpDTO.getCpk(), 3, true));
    	}
    	
    	
    	ultimosCicloDTO.setIntervaloHistograma(getIntervaloHistograma(listaCicloDetalhe));
    	ultimosCicloDTO.setCicloDetalhesView(listaCicloDetalhe50);
    	ultimosCicloDTO.setCicloDetalhes(listaCicloDetalhe);
    	
    	return ultimosCicloDTO;
    }
    
    public List<GraficoEvolucaoCicloPadraoDTO> getGraficoDaEvolucaoDoCicloPadrao(String cdFolha, String cdPt) throws RegistroDesconhecidoException {
    	DetalheMonitorizacaoPTInjetRN rn = new DetalheMonitorizacaoPTInjetRN(getDao());
    	DwFolhasDTO folhasDTO = rn.getDwFolhasPorCodInjet(cdFolha, cdPt);
    	
    	List<GraficoEvolucaoCicloPadraoDTO> listaCicloPadrao = new ArrayList<GraficoEvolucaoCicloPadraoDTO>();
    	for(DwFolhaDTO dto : folhasDTO.getListaDwFolhaDTO()){
    		DwFolha folha = dto.getDwFolha();
    		GraficoEvolucaoCicloPadraoDTO cicloPadraoDTO = new GraficoEvolucaoCicloPadraoDTO();
    		cicloPadraoDTO.setInicioValidade(DataHoraRN.dateToString(folha.getDtRevisao(), formatoDataHora));
    		cicloPadraoDTO.setCicloPadrao(ConversaoTipos.converteParaString(dto.getDwFolha().getSegCiclopadrao(), 2));
    		cicloPadraoDTO.setRevisao(folha.getRevisao().toString());
    		cicloPadraoDTO.setRevisaoUsuario(folha.getOmUsrByIdUsrrevisao().getDsNome());
    		listaCicloPadrao.add(cicloPadraoDTO);    	}
    	
		return listaCicloPadrao;
    }
    
    public List<CicloParadaDTO> getVariacaoDeRitmo(FiltroDetalhePTInjetDTO filtro) {    	
    	List<CicloParadaDTO> ciclosDTO = new ArrayList<CicloParadaDTO>();
    	return ciclosDTO;
    }
    
    private FiltroCiclosDTO montarFiltroUltimosCiclos(FiltroDetalhePostoDTO filtro) throws RegistroDesconhecidoException {
    	FiltroCiclosDTO retorno = new FiltroCiclosDTO();
    	
    	OmPt pt = new OmPt();
    	pt.setCdPt(filtro.getCdPosto());
    	retorno.setOmPt(pt);
    	
    	PpCp ppCp = new PpCp();
    	ppCp.setCdCp(filtro.getCdCp());
    	retorno.setPpCp(ppCp);
    	
    	DwTurno turno = new DwTurno();
    	turno.setIdTurno(filtro.getIdTurno());
    	turno.setCdTurno(FuncoesApoioInjet.getStrZero(filtro.getIdTurno(), 6));
    	
    	FiltroAnaliseTurnoDTO filtroAnaliseTurno = new FiltroAnaliseTurnoDTO();    	
    	filtroAnaliseTurno.setDwTurno(turno);
    	filtroAnaliseTurno.setDtReferencia(DataHoraRN.stringToDate(filtro.getDtReferencia(), formatoData));
    	
    	retorno.setAnaliseTurnoDTO(filtroAnaliseTurno);
    	
    	return retorno;
    }
    
    private List<CicloDetalheDTO> getListaCicloDetalhe50(CiclosDTO ciclos) {
    	List<CicloDetalheDTO> listaCicloDetalhe = new ArrayList<CicloDetalheDTO>();
    	CiclosDTO cicloDetalhe50 = new CiclosDTO();
    	    	    	
    	// lista vem ordenada em ordem descendente. Para efeito de montagem do grafico serao exibidos somente os 50 ultimos
    	cicloDetalhe50.setListaCicloDTO(new ArrayList<CicloDTO>());
    	int qtdCiclos = 0;    	
    	for(CicloDTO ciclo : ciclos.getListaCicloDTO()) {
    		cicloDetalhe50.getListaCicloDTO().add(ciclo);    		
    		qtdCiclos = qtdCiclos + 1;
    		if (qtdCiclos == QUANTIDADE_CICLOS_NO_GRAFICO) { 
    			break;
    		}
    	}

		// agora precisa ordenar em ordem crescente
		Collections
		.sort(cicloDetalhe50.getListaCicloDTO(),
				new Comparator<CicloDTO>() {
					@Override
					public int compare(
							final CicloDTO o1,
							final CicloDTO o2) {
						final CicloDTO item1 = o1;
						final CicloDTO item2 = o2;
						return (item1.getDwRtcic().getDthrIciclo().compareTo(item2.getDwRtcic().getDthrIciclo()));
					}
				});		
    	
    	
    	
    	DAOGenerico daoVF = new DAOGenerico();
    	daoVF.iniciaSessao();
    	DetalheMonitorizacaoWebIndicadorRN indicadorRN = new DetalheMonitorizacaoWebIndicadorRN(daoVF, formatoData, formatoDataHora);
    	List<MetaIndicadorDTO> listaIndicadores = new ArrayList<MetaIndicadorDTO>();
    	listaIndicadores.add(DetalheMonitorizacaoWebIndicadorRN.getIndicadorPadraoDosUltimosCiclos());
    	
    	for(CicloDTO ciclo : cicloDetalhe50.getListaCicloDTO()) {
    		CicloDetalheDTO cicloDTO = new CicloDetalheDTO();
    		
    		cicloDTO.setDescricao(DataHoraRN.dateToString(ciclo.getDwRtcic().getDthrIciclo(), formatoHora));
    		cicloDTO.setDuracao(ConversaoTipos.converteParaString(ciclo.getDwRtcic().getSegDuracao().doubleValue(), 3, true));
    		cicloDTO.setEficiencia(ConversaoTipos.converteParaString(ciclo.getEficienciaCiclo().doubleValue(), 1, true));
    		cicloDTO.setCicloPadrao(ConversaoTipos.converteParaString(ciclo.getCicloPadrao().doubleValue(), 3, true));
    		cicloDTO.setDataHoraInicio(DataHoraRN.dateToString(ciclo.getDwRtcic().getDthrIciclo(), formatoDataHora));
    		cicloDTO.setDataHoraFim(DataHoraRN.dateToString(ciclo.getDwRtcic().getDthrFciclo(), formatoDataHora));
    		cicloDTO.setEficienciaCor(
    				indicadorRN.identificarCorDoIndicador(
    						IndicadoresValorPadrao.EFICIENCIA_DE_CICLO.getCdIndicador(), 
    						listaIndicadores, 
    						cicloDTO.getEficiencia()));
    		
    		listaCicloDetalhe.add(cicloDTO);    		
    	}
 
    	
    	daoVF.finalizaSessao();
    	
    	return listaCicloDetalhe;
    }

    private List<CicloDetalheDTO> getListaCicloDetalhe(CiclosDTO ciclos) {
    	List<CicloDetalheDTO> listaCicloDetalhe = new ArrayList<CicloDetalheDTO>();

    	DAOGenerico daoVF = new DAOGenerico();
    	daoVF.iniciaSessao();
    	DetalheMonitorizacaoWebIndicadorRN indicadorRN = new DetalheMonitorizacaoWebIndicadorRN(daoVF, formatoData, formatoDataHora);
    	List<MetaIndicadorDTO> listaIndicadores = new ArrayList<MetaIndicadorDTO>();
    	listaIndicadores.add(DetalheMonitorizacaoWebIndicadorRN.getIndicadorPadraoDosUltimosCiclos());
    	
    	for(CicloDTO ciclo : ciclos.getListaCicloDTO()) {
    		CicloDetalheDTO cicloDTO = new CicloDetalheDTO();
    		
    		cicloDTO.setDescricao(DataHoraRN.dateToString(ciclo.getDwRtcic().getDthrIciclo(), formatoHora));
    		cicloDTO.setDuracao(ConversaoTipos.converteParaString(ciclo.getDwRtcic().getSegDuracao().doubleValue(), 3, true));
    		cicloDTO.setEficiencia(ConversaoTipos.converteParaString(ciclo.getEficienciaCiclo().doubleValue(), 1, true));
    		cicloDTO.setCicloPadrao(ConversaoTipos.converteParaString(ciclo.getCicloPadrao().doubleValue(), 3, true));
    		cicloDTO.setDataHoraInicio(DataHoraRN.dateToString(ciclo.getDwRtcic().getDthrIciclo(), formatoDataHora));
    		cicloDTO.setDataHoraFim(DataHoraRN.dateToString(ciclo.getDwRtcic().getDthrFciclo(), formatoDataHora));
    		cicloDTO.setEficienciaCor(
    				indicadorRN.identificarCorDoIndicador(
    						IndicadoresValorPadrao.EFICIENCIA_DE_CICLO.getCdIndicador(), 
    						listaIndicadores, 
    						cicloDTO.getEficiencia()));
    		
    		listaCicloDetalhe.add(cicloDTO);    		
    	}
 
    	
    	daoVF.finalizaSessao();
    	
    	return listaCicloDetalhe;
    }
    
    
    private int getIntervaloHistograma(List<CicloDetalheDTO> listaCicloDetalhe) {
    	
    	int tamanhoLista = listaCicloDetalhe.size();

        if (tamanhoLista < 50) {
        	return 6;
        }

        if (tamanhoLista >= 50 && tamanhoLista <= 100) {
        	return 8;
        }

        if (tamanhoLista > 100 && tamanhoLista <= 250) {
        	return 10;
        }

        if (tamanhoLista > 250) {
        	return 15;
        }
        
        return 0;
    }

    public DetalheCicloDTO getDetalheRitmo(FiltroPerdaGanhoDTO filtro) {
    	FiltroDetalhePTInjetDTO filtroConvertido = filtroRN.converterParaFiltroDetalhePerdaGanho(filtro);
    	DetalheMonitorizacaoPTInjetDTO detalheDTO = detalheRN.getDetalheMonitorizacaoPTInjetDTO(filtroConvertido);
    	
    	GraficoBIParetoDTO consultaDTO = getResumoPerdaGanho(filtroConvertido, detalheDTO);
    	
    	DetalheCicloDTO retorno = new DetalheCicloDTO();
    	
    	retorno.setResumo(getResumoPerdaGanhoDTO(detalheDTO, consultaDTO));
    	retorno.setMetaIndicador(metaIndicador);
    	retorno.setProdutosPerdas(gerarValoresPareto(consultaDTO.getGrafBIProdutoPerdas()));
    	retorno.setProdutosGanhos(gerarValoresPareto(consultaDTO.getGrafBIProdutoGanhos()));
    	retorno.setPostosPerdas(gerarValoresPareto(consultaDTO.getGrafBIMaquinaPerdas()));
    	retorno.setPostosGanhos(gerarValoresPareto(consultaDTO.getGrafBIMaquinaGanhos()));
    	
    	return retorno;
    }
    
    public PerdaGanhoDTO getDetalheRitmoTabela(FiltroPerdaGanhoDTO filtro) {
    	FiltroDetalhePTInjetDTO filtroConvertido = filtroRN.converterParaFiltroDetalhePerdaGanho(filtro);
    	DetalheMonitorizacaoPTInjetDTO detalheDTO = detalheRN.getDetalheMonitorizacaoPTInjetDTO(filtroConvertido);
    	
    	GraficoBIParetoDTO resumoDTO = getResumoPerdaGanho(filtroConvertido, detalheDTO);
    	
    	DetalheMonitorizacaoPTInjetRN consultaRN = new DetalheMonitorizacaoPTInjetRN(getDao());
    	
    	String cdPosto = filtro.getCdPostoSelecionado() == null ? "" : filtro.getCdPostoSelecionado();
    	String cdProduto = filtro.getCdProdutoSelecionado() == null ? "" : filtro.getCdProdutoSelecionado();
    	
    	List<TabelaPerdaGanhoCicloDTO> tabelaCiclos = new ArrayList<TabelaPerdaGanhoCicloDTO>();
    	List<TabelaPerdaGanhoTodosDTO> tabelaTodos = new ArrayList<TabelaPerdaGanhoTodosDTO>();

    	if(filtroConvertido.getTipoPareto() == GraficoBIParetoPerdasRN.PARETO_CICLOS) {
    		
    		if(filtro.getTipoOrdenacao() == ORDERNAR_POR_POSTO) {
    			ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO consultaDTO = consultaRN.getDetalhamentoGraficoPerdasBICiclosOrdemMaquina(detalheDTO, cdPosto, cdProduto, true, true);
    			tabelaCiclos = getTabelaOrdenadoPorPosto(consultaDTO);
    		}
    		
    		if(filtro.getTipoOrdenacao() == ORDERNAR_POR_PECAS) {
    			ListaGraficoBIParetoDetCiclosOrdemProdutoDTO consultaDTO = consultaRN.getDetalhamentoGraficoPerdasBICiclosOrdemProduto(detalheDTO, DetalheMonitorizacaoPTInsertRN.ORDEM_UB, cdPosto, cdProduto, true, true);
    			tabelaCiclos = getTabelaOrdenadoPorProduto(consultaDTO);
    		}
    		
    		if(filtro.getTipoOrdenacao() == ORDERNAR_POR_PESO) {
    			ListaGraficoBIParetoDetCiclosOrdemProdutoDTO consultaDTO = consultaRN.getDetalhamentoGraficoPerdasBICiclosOrdemProduto(detalheDTO, DetalheMonitorizacaoPTInsertRN.ORDEM_PESO, cdPosto, cdProduto, true, true);
    			tabelaCiclos = getTabelaOrdenadoPorProduto(consultaDTO);
    		}
    		
    		if(filtro.getTipoOrdenacao() == ORDERNAR_POR_CUSTO) {
    			ListaGraficoBIParetoDetCiclosOrdemProdutoDTO consultaDTO = consultaRN.getDetalhamentoGraficoPerdasBICiclosOrdemProduto(detalheDTO, DetalheMonitorizacaoPTInsertRN.ORDEM_UM, cdPosto, cdProduto, true, true);
    			tabelaCiclos = getTabelaOrdenadoPorProduto(consultaDTO);
    		}
    	
    	}
    	
    	if(filtroConvertido.getTipoPareto() == GraficoBIParetoPerdasRN.PARETO_TODAS) {
    		
    		if(filtro.getTipoOrdenacao() == ORDERNAR_POR_PECAS) {
    			ListaGraficoBIParetoDetTodasDTO consultaDTO = consultaRN.getDetalhamentoGraficoPerdasBITodasOrdemProduto(detalheDTO, DetalheMonitorizacaoPTInsertRN.ORDEM_UB, cdPosto, cdProduto, true, true);
    			tabelaTodos = getTabelaPerdaGanhoTodos(consultaDTO);
    		}
    		
    		if(filtro.getTipoOrdenacao() == ORDERNAR_POR_PESO) {
    			ListaGraficoBIParetoDetTodasDTO consultaDTO = consultaRN.getDetalhamentoGraficoPerdasBITodasOrdemProduto(detalheDTO, DetalheMonitorizacaoPTInsertRN.ORDEM_PESO, cdPosto, cdProduto, true, true);
    			tabelaTodos = getTabelaPerdaGanhoTodos(consultaDTO);
    		}
    		
    		if(filtro.getTipoOrdenacao() == ORDERNAR_POR_CUSTO) {
    			ListaGraficoBIParetoDetTodasDTO consultaDTO = consultaRN.getDetalhamentoGraficoPerdasBITodasOrdemProduto(detalheDTO, DetalheMonitorizacaoPTInsertRN.ORDEM_UM, cdPosto, cdProduto, true, true);
    			tabelaTodos = getTabelaPerdaGanhoTodos(consultaDTO);
    		}
    		
    	}		
    	
    	PerdaGanhoDTO retorno = new PerdaGanhoDTO();
    	retorno.setResumo(getResumoPerdaGanhoDTO(detalheDTO, resumoDTO));
    	retorno.setDetalheCiclos(tabelaCiclos);
    	retorno.setDetalheTodos(tabelaTodos);
    	return retorno;
    }

    // copiado do netbeans com algumas alteracoes: ModeloBIDetPerdasCicloMaquina
    private List<TabelaPerdaGanhoCicloDTO> getTabelaOrdenadoPorPosto(ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO dto) {
    	String cdMaqAnterior = "";
        String cdFerrAnterior = "";
        Double cicPadraoAnterior = 0d;
        
        List<TabelaPerdaGanhoCicloDTO> linhas = new ArrayList<>();
        TabelaPerdaGanhoCicloDTO linha;
    	
    	for (GraficoBIParetoDetCiclosOrdemMaquinaDTO maquina : dto.getListaMaquinas()) {
    		
            if (!cdMaqAnterior.equals("")) {
                linha = new TabelaPerdaGanhoCicloDTO();
                linhas.add(linha);
            }
            
            for (GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO ferramenta : maquina.getFerramentas()) {
            	
                for (GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO produto : ferramenta.getProdutos()) {
                    linha = new TabelaPerdaGanhoCicloDTO();
                    
                    if (!cdMaqAnterior.equals(maquina.getCdMaquina())) {
                        linha.setPosto(maquina.getCdMaquina() + "(" + maquina.getDsMaquina() +")");
                        linha.setFolha(ferramenta.getCdFerramenta());
                        linha.setCicloPadrao(ConversaoTipos.converteParaString(ferramenta.getCicloPadrao(),3));
                        linha.setCicloLido(ConversaoTipos.converteParaString(ferramenta.getCicloMedio(),3));
                        
                        cdMaqAnterior = maquina.getCdMaquina();
                        cdFerrAnterior = ferramenta.getCdFerramenta();
                        cicPadraoAnterior = ferramenta.getCicloPadrao();
                    } else {
                    	if (!cdFerrAnterior.equals(ferramenta.getCdFerramenta())) {
							linha.setFolha(ferramenta.getCdFerramenta());
							linha.setCicloPadrao(ConversaoTipos.converteParaString(ferramenta.getCicloPadrao(),3));
							linha.setCicloLido(ConversaoTipos.converteParaString(ferramenta.getCicloMedio(),3));
							cdFerrAnterior = ferramenta.getCdFerramenta();
							cicPadraoAnterior = ferramenta.getCicloPadrao();
                        } else {
                            if (cicPadraoAnterior.compareTo(ferramenta.getCicloPadrao()) != 0) {
                            	linha.setCicloPadrao(ConversaoTipos.converteParaString(ferramenta.getCicloPadrao(),3));
    							linha.setCicloLido(ConversaoTipos.converteParaString(ferramenta.getCicloMedio(),3));
                                
                                cicPadraoAnterior = ferramenta.getCicloPadrao();
                            }
                        }
                    }
                    
                    linha.setProduto(produto.getCdProduto() + " - " + produto.getDsProduto());
                    linha.setCiclosProdutivos(DataHoraRN.formatSegundosParaHHMMSSmmm(ferramenta.getSegCiclosProdutivos()));
                    linha.setPerdaGanho(ConversaoTipos.converteParaString(produto.getQtdEmUB(), 0));
                    linha.setPerdaGanhoKg(ConversaoTipos.converteParaString(produto.getQtdEmKg(), 3));
                    linha.setPerdaGanhoTon(ConversaoTipos.converteParaString(produto.getQtdEmKg()/1000, 3));
                    linha.setCusto(ConversaoTipos.converteParaString(produto.getQtdEmUM(), 2));
                    linhas.add(linha);
                }
                
                linha = new TabelaPerdaGanhoCicloDTO();
                linha.setProduto("SALDO DA FERRAMENTA");
                linha.setCiclosProdutivos(DataHoraRN.formatSegundosParaHHMMSSmmm(ferramenta.getSegCiclosProdutivos()));
                linha.setPerdaGanho(ConversaoTipos.converteParaString(ferramenta.getQtdEmUB(), 0));
                linha.setPerdaGanhoKg(ConversaoTipos.converteParaString(ferramenta.getQtdEmKg(), 3));
                linha.setPerdaGanhoTon(ConversaoTipos.converteParaString(ferramenta.getQtdEmKg()/1000, 3));    
                linha.setCusto(ConversaoTipos.converteParaString(ferramenta.getQtdEmUM(), 2));
                linhas.add(linha);
            }
            
            linha = new TabelaPerdaGanhoCicloDTO();
            linha.setProduto("SALDO DA MÁQUINA");
            linha.setCiclosProdutivos(DataHoraRN.formatSegundosParaHHMMSSmmm(maquina.getSegCiclosProdutivos()));
            linha.setPerdaGanho(ConversaoTipos.converteParaString(maquina.getQtdEmUB(), 0));
            linha.setPerdaGanhoKg(ConversaoTipos.converteParaString(maquina.getQtdEmKg(), 3));
            linha.setPerdaGanhoTon(ConversaoTipos.converteParaString(maquina.getQtdEmKg()/1000, 3));    
            linha.setCusto(ConversaoTipos.converteParaString(maquina.getQtdEmUM(), 2));
            linhas.add(linha);
        }
    	
    	return linhas;
    }
    
    // copiado do netbeans com algumas alteracoes: ModeloBIDetPerdasCicloProduto
    private List<TabelaPerdaGanhoCicloDTO> getTabelaOrdenadoPorProduto(ListaGraficoBIParetoDetCiclosOrdemProdutoDTO dto) {
    	String cdProdAnterior = "";
        String cdMaqAnterior = "";
        String cdFerrAnterior = "";
        Double cicPadraoAnterior = 0d;
        
        List<TabelaPerdaGanhoCicloDTO> linhas = new ArrayList<>();
        TabelaPerdaGanhoCicloDTO linha;
        
        for (GraficoBIParetoDetCiclosOrdemProdutoDTO produto : dto.getListaProdutos()) {
        	
            if (!cdProdAnterior.equals("")) {
                linha = new TabelaPerdaGanhoCicloDTO();
                linhas.add(linha);
            }
            
            for (GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO fictec : produto.getFictec()) {
                linha = new TabelaPerdaGanhoCicloDTO();
                
                if (!cdProdAnterior.equals(produto.getCdProduto())) {
                    linha.setProduto(produto.getCdProduto() + " - " + produto.getDsProduto());
                    linha.setPosto(fictec.getCdMaquina() + "(" + fictec.getDsMasquina() + ")");
                    linha.setFolha(fictec.getCdFerramenta());
                    linha.setCicloPadrao(ConversaoTipos.converteParaString(fictec.getCicloPadrao(), 3));

                    cdProdAnterior = produto.getCdProduto();
                    cdMaqAnterior = fictec.getCdMaquina();
                    cdFerrAnterior = fictec.getCdFerramenta();
                    cicPadraoAnterior = fictec.getCicloPadrao();
                } else {
                    if (!cdMaqAnterior.equals(fictec.getCdMaquina())) {
                    	linha.setPosto(fictec.getCdMaquina() + "(" + fictec.getDsMasquina() + ")");
                        linha.setFolha(fictec.getCdFerramenta());
                        linha.setCicloPadrao(ConversaoTipos.converteParaString(fictec.getCicloPadrao(), 3));

                        cdMaqAnterior = fictec.getCdMaquina();
                        cdFerrAnterior = fictec.getCdFerramenta();
                        cicPadraoAnterior = fictec.getCicloPadrao();                   
                    } else {
                        if (!cdFerrAnterior.equals(fictec.getCdFerramenta())) {
                        	linha.setFolha(fictec.getCdFerramenta());
                        	linha.setCicloPadrao(ConversaoTipos.converteParaString(fictec.getCicloPadrao(), 3));
                            
                            cdFerrAnterior = fictec.getCdFerramenta();
                            cicPadraoAnterior = fictec.getCicloPadrao();
                        } else {
                            if (!cicPadraoAnterior.equals(fictec.getCicloPadrao())) {
                            	linha.setCicloPadrao(ConversaoTipos.converteParaString(fictec.getCicloPadrao(), 3));                             
                                cicPadraoAnterior = fictec.getCicloPadrao();
                            }
                        }                        
                    }
                }
                
               linha.setCicloLido(ConversaoTipos.converteParaString(fictec.getCicloMedio(), 3));
               linha.setCiclosProdutivos(DataHoraRN.formatSegundosParaHHMMSSmmm(fictec.getSegCiclosProdutivos()));
               linha.setPerdaGanho(ConversaoTipos.converteParaString(fictec.getQtdEmUB(), 0));
               linha.setPerdaGanhoKg(ConversaoTipos.converteParaString(fictec.getQtdEmKg(), 3));
               linha.setPerdaGanhoTon(ConversaoTipos.converteParaString(fictec.getQtdEmKg()/1000, 3));
               linha.setCusto(ConversaoTipos.converteParaString(fictec.getQtdEmUM(), 2));
               linhas.add(linha);
                    
            }
            
            linha = new TabelaPerdaGanhoCicloDTO();
            linha.setCicloLido("SALDO DO PRODUTO");
            linha.setCiclosProdutivos(DataHoraRN.formatSegundosParaHHMMSSmmm(produto.getSegCiclosProdutivos()));
            linha.setPerdaGanho(ConversaoTipos.converteParaString(produto.getQtdEmUB(), 0));
            linha.setPerdaGanhoKg(ConversaoTipos.converteParaString(produto.getQtdEmKg(), 3));
            linha.setPerdaGanhoTon(ConversaoTipos.converteParaString(produto.getQtdEmKg()/1000, 3));
            linha.setCusto(ConversaoTipos.converteParaString(produto.getQtdEmUM(), 2));
            linhas.add(linha);
        }
    	
    	return linhas;
    }

    private List<TabelaPerdaGanhoTodosDTO> getTabelaPerdaGanhoTodos(ListaGraficoBIParetoDetTodasDTO dto) {
    	List<TabelaPerdaGanhoTodosDTO> linhas = new ArrayList<TabelaPerdaGanhoTodosDTO>();
    	
    	for(GraficoBIParetoDetTodasDTO produto : dto.getListaProdutos()) {
    		
    		TabelaPerdaGanhoTodosDTO linha = new TabelaPerdaGanhoTodosDTO();
    		linha.setProduto(produto.getCdProduto() + " - " + produto.getDsProduto());
    		linha.setPerdaGanho(ConversaoTipos.converteParaString(produto.getQtdPerdaEmUB(), 2));
    		linha.setPerdaGanhoKg(ConversaoTipos.converteParaString(produto.getQtdPerdaEmKg(), 3));
    		linha.setPerdaGanhoTon(ConversaoTipos.converteParaString(produto.getQtdPerdaEmTon(), 3));
    		linha.setCusto(ConversaoTipos.converteParaString(produto.getQtdPerdaEmUM(), 2));
    		linha.setPrevistas(ConversaoTipos.converteParaString(produto.getQtdPrevista(), 0));
    		linha.setPrevistasKg(ConversaoTipos.converteParaString(produto.getQtdPrevistaKg(), 3));
    		linha.setPrevistasTon(ConversaoTipos.converteParaString(produto.getQtdPrevistaTon(), 3));
    		linha.setBoas(ConversaoTipos.converteParaString(produto.getQtdBoas(), 0));
    		linha.setBoasKg(ConversaoTipos.converteParaString(produto.getQtdBoasKg(), 3));
    		linha.setBoasTon(ConversaoTipos.converteParaString(produto.getQtdBoasTon(), 3));
    		linha.setEficienciaRealizacao(ConversaoTipos.converteParaString(produto.getEfiRea(), 2));
    		
    		linhas.add(linha);
    	}
    	return linhas;
    }    

    private GraficoBIParetoDTO getResumoPerdaGanho(FiltroDetalhePTInjetDTO filtro, DetalheMonitorizacaoPTInjetDTO detalheDTO) {
    	return graficoBIParetoPerdasRN.getGrafBIParetoPerdas(GraficoBIParetoPerdasRN.QTD_PARETO_PERDAS_BI_EM_UB, filtro, detalheDTO);
    }    

    private ResumoPerdaGanhoCicloDTO getResumoPerdaGanhoDTO(DetalheMonitorizacaoPTInjetDTO detalheDTO, GraficoBIParetoDTO consultaDTO) {
    	ResumoPerdaGanhoCicloDTO resumo = new ResumoPerdaGanhoCicloDTO();
    	
    	String periodo = detalheDTO.getDtReferencia();
    	if(detalheDTO.getDwTurno() != null) {
    		periodo += " - " + detalheDTO.getDwTurno().getDsTurno();
    	}
    	
    	Double quantidadeGanhos = somaQuantidadeItem(consultaDTO.getGrafBIProdutoGanhos());
    	Double quantidadePerdas = somaQuantidadeItem(consultaDTO.getGrafBIProdutoPerdas());
    	Double saldo = quantidadePerdas - quantidadeGanhos;
    	
    	Double quantidadeGanhosKg = somaQuantidadeItemKg(consultaDTO.getGrafBIProdutoGanhos());
    	Double quantidadePerdasKg = somaQuantidadeItemKg(consultaDTO.getGrafBIProdutoPerdas());
    	Double saldoKg = quantidadePerdasKg - quantidadeGanhosKg;
    	
    	Double quantidadeGanhosTon = somaQuantidadeItemTon(consultaDTO.getGrafBIProdutoGanhos());
    	Double quantidadePerdasTon = somaQuantidadeItemTon(consultaDTO.getGrafBIProdutoPerdas());
    	Double saldoTon = quantidadePerdasTon - quantidadeGanhosTon;
    	
    	resumo.setPeriodo(periodo);
    	
    	resumo.setEficienciaCiclo(ConversaoTipos.converteParaString(detalheDTO.getEfiCiclos(), 2));
    	
    	resumo.setGanhosTotaisPecas(ConversaoTipos.converteParaString(quantidadeGanhos, 2));
    	resumo.setGanhosTotaisKg(ConversaoTipos.converteParaString(quantidadeGanhosKg, 4));
    	resumo.setGanhosTotaisTon(ConversaoTipos.converteParaString(quantidadeGanhosTon, 4));
    	
    	resumo.setPerdasTotaisPecas(ConversaoTipos.converteParaString(quantidadePerdas, 2));
    	resumo.setPerdasTotaisKg(ConversaoTipos.converteParaString(quantidadePerdasKg, 4));
    	resumo.setPerdasTotaisTon(ConversaoTipos.converteParaString(quantidadePerdasTon, 4));
    	
    	resumo.setSaldoPecas(ConversaoTipos.converteParaString(saldo, 2));
    	resumo.setSaldoKg(ConversaoTipos.converteParaString(saldoKg, 4));
    	resumo.setSaldoTon(ConversaoTipos.converteParaString(saldoTon, 4));
    	
    	return resumo;
    }
    
    private Double somaQuantidadeItem(List<GraficoBIParetoPerdasDTO> lista) {
    	Double soma = 0d;
    	
    	for(GraficoBIParetoPerdasDTO item : lista) {
    		soma = soma + item.getQtdItem();
    	}
    	
    	return soma;
    }
    
    private Double somaQuantidadeItemKg(List<GraficoBIParetoPerdasDTO> lista) {
    	Double soma = 0d;
    	
    	for(GraficoBIParetoPerdasDTO item : lista) {
    		soma = soma + item.getQtdItemEmKg();
    	}
    	
    	return soma;
    }
    
    private Double somaQuantidadeItemTon(List<GraficoBIParetoPerdasDTO> lista) {
    	Double soma = 0d;
    	
    	for(GraficoBIParetoPerdasDTO item : lista) {
    		soma = soma + item.getQtdItemEmTon();
    	}
    	
    	return soma;
    }

    private List<GraficoDetalheCicloDTO> gerarValoresPareto(List<GraficoBIParetoPerdasDTO> lista) {
    	List<GraficoDetalheCicloDTO> listaRetorno = new ArrayList<GraficoDetalheCicloDTO>();
    	
    	for(GraficoBIParetoPerdasDTO item : lista) {
    		GraficoDetalheCicloDTO dto = new GraficoDetalheCicloDTO();

    		dto.setCodigo(item.getCdItemPareto());
    		dto.setDescricao(item.getDsItemPareto());
    		dto.setPecas(ConversaoTipos.converteParaString(item.getQtdItem(), 2));
    		dto.setPecasIndice(ConversaoTipos.converteParaString(item.getIndItem(), 2));
    		dto.setPecasIndiceCor(indicadorRN.identificarCorDoIndicador(metaIndicador, item.getIndItem().toString()));
    		dto.setPesoKg(ConversaoTipos.converteParaString(item.getQtdItemEmKg(), 4));
    		dto.setPesoKgIndice(ConversaoTipos.converteParaString(item.getIndItemEmKg(), 2));
    		dto.setPesoKgIndiceCor(indicadorRN.identificarCorDoIndicador(metaIndicador, item.getIndItemEmKg().toString()));
    		dto.setPesoTon(ConversaoTipos.converteParaString(item.getQtdItemEmTon(), 4));
    		dto.setPesoTonIndice(ConversaoTipos.converteParaString(item.getIndItemEmTon(), 2));
    		dto.setPesoTonIndiceCor(indicadorRN.identificarCorDoIndicador(metaIndicador, item.getIndItemEmTon().toString()));
    		dto.setCusto(ConversaoTipos.converteParaString(item.getQtdItemEmUnidadeMonetaria(), 3));
    		dto.setCustoIndice(ConversaoTipos.converteParaString(item.getIndItemEmUnidadeMonetaria(), 2));
    		dto.setCustoIndiceCor(indicadorRN.identificarCorDoIndicador(metaIndicador, item.getIndItemEmUnidadeMonetaria().toString()));
    		
    		
    		listaRetorno.add(dto);
    	}
    	
    	return listaRetorno;
    }    
}
