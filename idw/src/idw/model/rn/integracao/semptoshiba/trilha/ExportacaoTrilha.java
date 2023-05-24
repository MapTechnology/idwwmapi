package idw.model.rn.integracao.semptoshiba.trilha;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProaltglo;
import idw.model.pojos.OmProduto;
import idw.model.pojos.PpCmcom;
import idw.model.pojos.PpPlano;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.model.pojos.template.PpPlanoTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.PlanejamentoProducaoRN;
import idw.model.rn.ProdutoAlternativoRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.estoque.EstoqueRN;
import idw.util.Util;
import idw.webservices.dto.FiltroExportacaoTrilhaDTO;
import idw.webservices.dto.PlanoDTO;

public class ExportacaoTrilha extends AbstractRN<DAOGenerico> {

	private final Map<String, OmProduto> mapProdutosFinaisDoPlanoProducaoTodos;
	private final Map<String, OmProduto> mapProdutosFinaisDoPlanoProducaoComDat = new HashMap<String, OmProduto>();
	private final Map<String, OmProduto> mapProdutosFinaisDoPlanoProducaoSemDat = new HashMap<String, OmProduto>();	
	private final List<PpPlano> listPlanosProducao;
	private Set<String> listPtsComOperacoes = new HashSet<String>();
	private final Map<String, OmProduto> mapTodosProdutos;
	
	private Map<String, Integer> mapProdutosUltimoEstagioIAC = new HashMap<String, Integer>();
	private final Map<String, Set<DwEstpro>> mapEstoquesProdutos;
	private final List<PpCmcom> listAlternativoNA = new ArrayList<PpCmcom>();
	private final List<OmProaltglo> listAlternativoDireto = new ArrayList<OmProaltglo>();
	private Map<String, BigDecimal> mapMulticiplicidadeProduto = new HashMap<String, BigDecimal>();
	private Map<String, Integer> mapEstagioProduto = new HashMap<String, Integer>();
	
	private static int NIVEL_ESTRUTURA_PARA_OTIMIZACAO_CONSULTA = 4;


	
	private PpPlano ppPlano;
	private final OmCfg omCfg;
	
	public static final boolean ISPLANGT_PARA_GERAR_ARQUIVO_RECURSOS =  false;

	private final EstoqueRN estoqueRN;
	private final ProdutoRN produtoRN; 
	
	public ExportacaoTrilha() {
		this(null, null);
	}
	
	public ExportacaoTrilha(DAOGenerico dao){
		this(dao, null);
	}
	
	public ExportacaoTrilha(DAOGenerico dao, FiltroExportacaoTrilhaDTO filtro) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);

		estoqueRN = new EstoqueRN(dao);
		produtoRN = new ProdutoRN(dao);
		omCfg = Util.getConfigGeral(dao.getSession());
		
		
		PlanejamentoProducaoRN planejamentoProducaoRN = new PlanejamentoProducaoRN(dao);
		
		PlanoDTO planoDTO = new PlanoDTO();
		planoDTO.setStPlano(PpPlanoTemplate.TpPlano.CADASTRADO.getId());	
		
		// Filtro para plano espec�fico
		if(filtro != null && filtro.getPlano() != null 
				&& !StringUtils.isEmpty(filtro.getPlano().getCdPlano())){
			
			planoDTO.setCdPlano(filtro.getPlano().getCdPlano());
			this.ppPlano = filtro.getPlano();
		
		}else{
			this.ppPlano = null;	
		}
				
		this.listPlanosProducao = planejamentoProducaoRN.pesquisarPlanosAtivos(planoDTO, true, true, true, true, NIVEL_ESTRUTURA_PARA_OTIMIZACAO_CONSULTA, true);		
		this.mapProdutosFinaisDoPlanoProducaoTodos = planejamentoProducaoRN.getProdutosFinaisDosPlanosAtivos(this.listPlanosProducao);		
		
		List<OmProduto> listProdutosEstruturaDoPlanoProducao = produtoRN.getProdutosComEstruturas(mapProdutosFinaisDoPlanoProducaoTodos.values(), null);
		
		this.preencheMapProdutosFinaisDoPlanoProducaoComESemDat(this.mapProdutosFinaisDoPlanoProducaoTodos.values());
		
		this.mapTodosProdutos = ProdutoRN.getListaProdutoIndexCdProduto(listProdutosEstruturaDoPlanoProducao);
		
		this.preencherListAlternativoDiretoENADeMapEAdicionaAlternativosNele(this.mapTodosProdutos);
		
		this.mapEstoquesProdutos = estoqueRN.getEstoquesProdutos(mapTodosProdutos.values(), null);
		
	}
	
	private void preencherListAlternativoDiretoENADeMapEAdicionaAlternativosNele(Map<String, OmProduto> mapProdutos){
		ProdutoAlternativoRN produtoAlternativoRN = new ProdutoAlternativoRN(this.getDao());
		
		this.listAlternativoNA.clear();
		this.listAlternativoNA.addAll(produtoAlternativoRN.getTodosProdutosAlternativoNADoPlanoProducao(mapTodosProdutos));
		
		this.listAlternativoDireto.clear();
		this.listAlternativoDireto.addAll(produtoAlternativoRN.getTodosProdutosAlternativoDiretoDoPlanoProducao(mapTodosProdutos));
		
		Map<String, OmProduto> mapProdutosAlternativosNA = produtoAlternativoRN.getMapProdutosAlternativosNAPassandoPpcmcoms(listAlternativoNA);
		Map<String, OmProduto> mapProdutosAlternativosDireto = produtoAlternativoRN.getMapProdutosAlternativosDiretoPassandoOmProaltglos(listAlternativoDireto);
		
		mapProdutos.putAll(mapProdutosAlternativosNA);
		mapProdutos.putAll(mapProdutosAlternativosDireto);
		
	}
	
	private void preencheMapProdutosFinaisDoPlanoProducaoComESemDat(Collection<OmProduto> produtosFinais){
		
		mapProdutosFinaisDoPlanoProducaoComDat.clear();
		mapProdutosFinaisDoPlanoProducaoSemDat.clear();
		
		for(OmProduto omProduto: produtosFinais){
			boolean isDat = (omProduto.getIsDat() != null ? omProduto.getIsDat() : false); 
			if(isDat || OmProdutoTemplate.TpProduto.SEMI_ACABADO.equals(omProduto.getTpProduto())){				
				mapProdutosFinaisDoPlanoProducaoComDat.put(omProduto.getCdProduto(), omProduto);
			}else{
				mapProdutosFinaisDoPlanoProducaoSemDat.put(omProduto.getCdProduto(), omProduto);
			}
		}
		
	}
	
	
	public ArquivosTrilhaDTO getArquivosTxt() {
		List<ArquivoTrilhaDTO> arquivosTxt = new ArrayList<ArquivoTrilhaDTO>();

		ArquivosTrilhaDTO arquivosDTO = new ArquivosTrilhaDTO();

		ArquivoTrilhaAcabados arquivoTrilhaAcabados = new ArquivoTrilhaAcabados(mapProdutosFinaisDoPlanoProducaoTodos);
		arquivosTxt.add(arquivoTrilhaAcabados.getArquivoTrilhaDTO());
		
		ArquivoTrilhaComponentes arquivoTrilhaComponentes = new ArquivoTrilhaComponentes(mapTodosProdutos);
		arquivosTxt.add(arquivoTrilhaComponentes.getArquivoTrilhaDTO());
		
		ArquivoTrilhaEstoque arquivoTrilhaEstoque = new ArquivoTrilhaEstoque(omCfg, mapTodosProdutos, mapEstoquesProdutos);		
		arquivosTxt.add(arquivoTrilhaEstoque.getArquivoTrilhaDTO());
		
		ArquivoTrilhaEstruturas arquivoTrilhaEstruturas = new ArquivoTrilhaEstruturas(mapProdutosFinaisDoPlanoProducaoTodos);
		arquivosTxt.add(arquivoTrilhaEstruturas.getArquivoTrilhaDTO());
		
		ArquivoTrilhaItens arquivoTrilhaItens = new ArquivoTrilhaItens(mapTodosProdutos);
		arquivosTxt.add(arquivoTrilhaItens.getArquivoTrilhaDTO());
				
		
		ArquivoTrilhaOperacoes arquivoTrilhaOperacoes = new ArquivoTrilhaOperacoes(
				getDao(), ppPlano, mapTodosProdutos, mapProdutosFinaisDoPlanoProducaoComDat, mapProdutosFinaisDoPlanoProducaoSemDat);
		arquivosTxt.add(arquivoTrilhaOperacoes.getArquivoTrilhaDTO());
		
		mapProdutosUltimoEstagioIAC = arquivoTrilhaOperacoes.getMapProdutosUltimoEstagioIAC();
		mapEstagioProduto = arquivoTrilhaOperacoes.getMapEstagioProduto();
		listPtsComOperacoes = arquivoTrilhaOperacoes.getListPtsComOperacoes();
		
		
		ArquivoTrilhaPlacas arquivoTrilhaPlacas = new ArquivoTrilhaPlacas(getDao(), mapTodosProdutos);
		arquivosTxt.add(arquivoTrilhaPlacas.getArquivoTrilhaDTO());
		this.mapMulticiplicidadeProduto = arquivoTrilhaPlacas.getMapMulticiplicidadeProduto(); 
		
		ArquivoTrilhaRecursos arquivoTrilhaRecursos = new ArquivoTrilhaRecursos(listPtsComOperacoes);
		arquivosTxt.add(arquivoTrilhaRecursos.getArquivoTrilhaDTO());
		
		ArquivoTrilhaTipoItens arquivoTrilhaTiposItens = new ArquivoTrilhaTipoItens();
		arquivosTxt.add(arquivoTrilhaTiposItens.getArquivoTrilhaDTO());
		
		ArquivoTrilhaTipoOperacoes arquivoTrilhaTiposOperacoes = new ArquivoTrilhaTipoOperacoes(getDao());
		arquivosTxt.add(arquivoTrilhaTiposOperacoes.getArquivoTrilhaDTO());
		
		ArquivoTrilhaGrupo arquivoTrilhaGrupo = new ArquivoTrilhaGrupo(getDao(), mapProdutosFinaisDoPlanoProducaoTodos);
		arquivosTxt.add(arquivoTrilhaGrupo.getArquivoTrilhaDTO());
		
		ArquivoTrilhaOrdemCompraComponentes arquivoTrilhaOrdemCompraComponentes = new ArquivoTrilhaOrdemCompraComponentes(omCfg, getDao(), mapTodosProdutos);
		arquivosTxt.add(arquivoTrilhaOrdemCompraComponentes.getArquivoTrilhaDTO());
		
		ArquivoTrilhaEstoquesProcesso arquivoTrilhaEstoquesProcesso = 
				new ArquivoTrilhaEstoquesProcesso(getDao(), omCfg, mapProdutosUltimoEstagioIAC, mapTodosProdutos, mapEstoquesProdutos);
		arquivosTxt.add(arquivoTrilhaEstoquesProcesso.getArquivoTrilhaDTO());
		
		ArquivoTrilhaNAAbertas arquivoTrilhaNAAbertas = new ArquivoTrilhaNAAbertas(listAlternativoNA, mapTodosProdutos);
		arquivosTxt.add(arquivoTrilhaNAAbertas.getArquivoTrilhaDTO());
		
		ArquivoTrilhaComponentesAlternativos arquivoTrilhaComponentesAlternativos = new ArquivoTrilhaComponentesAlternativos(mapTodosProdutos, listAlternativoDireto);
		arquivosTxt.add(arquivoTrilhaComponentesAlternativos.getArquivoTrilhaDTO());
		
		PreparacaoArquivoTrilhaPlanoProducao preparacaoArquivoTrilhaPlanoProducao = new PreparacaoArquivoTrilhaPlanoProducao(listPlanosProducao);

		ArquivoTrilhaPlanoProducaoSemDat arquivoTrilhaPlanoProducaoSemDat = 
				new ArquivoTrilhaPlanoProducaoSemDat(
						preparacaoArquivoTrilhaPlanoProducao.getLinhasArquivoTrilhaPlanoProducaoSemDat(), 
						preparacaoArquivoTrilhaPlanoProducao.getHeader());
		arquivosTxt.add(arquivoTrilhaPlanoProducaoSemDat.getArquivoTrilhaDTO());

		ArquivoTrilhaPlanoProducaoComDat arquivoTrilhaPlanoProducaoComDat = 
				new ArquivoTrilhaPlanoProducaoComDat(
						preparacaoArquivoTrilhaPlanoProducao.getLinhasArquivoTrilhaPlanoProducaoComDat(), 
						preparacaoArquivoTrilhaPlanoProducao.getHeader());
		arquivosTxt.add(arquivoTrilhaPlanoProducaoComDat.getArquivoTrilhaDTO());		
		
		ArquivoTrilhaConjugados arquivoTrilhaConjugados = new ArquivoTrilhaConjugados(getDao(), mapTodosProdutos, mapEstagioProduto, mapMulticiplicidadeProduto);
		arquivosTxt.add(arquivoTrilhaConjugados.getArquivoTrilhaDTO());
		
		ArquivoTrilhaApsAbertas arquivoTrilhaApsAbertas = new ArquivoTrilhaApsAbertas(mapTodosProdutos);
		arquivosTxt.add(arquivoTrilhaApsAbertas.getArquivoTrilhaDTO());
		
		
		arquivosDTO.setListaArquivosDTO(arquivosTxt);

		return arquivosDTO;
	}


	
}
