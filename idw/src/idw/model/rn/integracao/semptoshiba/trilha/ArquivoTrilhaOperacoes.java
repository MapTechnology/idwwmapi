package idw.model.rn.integracao.semptoshiba.trilha;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwFolhacicDAO;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhacic;
import idw.model.pojos.DwOperacao;
import idw.model.pojos.DwRota;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.DwRpPredecessora;
import idw.model.pojos.OmProcomest;
import idw.model.pojos.OmProduto;
import idw.model.pojos.PpPlano;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.model.pojos.template.OmTpptTemplate;
import idw.model.rn.FolhaRN;
import idw.model.rn.RoteiroRN;
import idw.model.rn.geraplano.dtos.CtDTO;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.model.rn.integracao.semptoshiba.IntegracaoEstruturaProduto;

public class ArquivoTrilhaOperacoes extends ArquivoTrilha {

	/**
	 * Consider apenas lote minimo default, solicitado para fazer testes iniciais com o simulador. Quando valores estiverem bem definidos, mudar para false. E se não for mais necessário remover.
	 */
	private static boolean CONSIDERAR_APENAS_LOTE_MINIMO_PRODUCAO_DEFAULT = false;

	private static boolean DESPREZAR_OPERACAO_TESTE_ELETRICO = true;
	
	private static final BigDecimal EFICIENCIA_TAXA_PRODUCAO_IAC = BigDecimal.ONE;	
	private static final BigDecimal EFICIENCIA_TAXA_PRODUCAO_IMC = BigDecimal.ONE;

	private static int LOTE_TRANSFERENCIA_PADRAO_IAC = -1;
	private static int LOTE_TRANSFERENCIA_PADRAO_IMC = -1;	
	private static int LOTE_MINIMO_PRODUCAO_PADRAO = -1;	
	private static int TEMPO_REPOUSO_PADRAO = -1;
	private static int CLASSE_PADRAO = -1;
	
	private final Set<String> linhasArquivoSemRepeticao = new HashSet<String>();;
	private final Set<String> listPtsComOperacoes = new HashSet<String>();
	private final Map<String, Integer> mapEstagioProduto = new HashMap<String, Integer>();		
	private final Map<String, Integer> mapProdutosUltimoEstagioIAC = new HashMap<String, Integer>();
	
	private final List<DwRota> listaDwRotaDosPlanosProducoesAtivos;

	private final Map<String, OmProduto> mapTodosProdutos;	
	private final DAOGenerico dao;
	private final RoteiroRN roteiroRN;
	private final FolhaRN folhaRN;
	
	private final Map<String, OmProduto> mapProdutosFinaisDoPlanoProducaoComDat;
	private final Map<String, OmProduto> mapProdutosFinaisDoPlanoProducaoSemDat;

	
	/**
	 * Consider apenas lote transferencia default, solicitado para fazer testes iniciais com o simulador. 
	 * Quando valores estiverem bem definidos, mudar para false. E se não for mais necessário remover.
	 * Alterado para true em 17/03/2014
	 */	
	private static boolean CONSIDERAR_APENAS_LOTE_TRANSFERENCIA_DEFAULT = true;
	

	public ArquivoTrilhaOperacoes(DAOGenerico daoGenerico, PpPlano ppPlano, 
			Map<String, OmProduto> mapTodosProdutos, 
			Map<String, OmProduto> mapProdutosFinaisDoPlanoProducaoComDat,
			Map<String, OmProduto> mapProdutosFinaisDoPlanoProducaoSemDat) {
		
		
		this.dao = daoGenerico;
		this.mapTodosProdutos = mapTodosProdutos;
		this.mapProdutosFinaisDoPlanoProducaoComDat = mapProdutosFinaisDoPlanoProducaoComDat;
		this.mapProdutosFinaisDoPlanoProducaoSemDat = mapProdutosFinaisDoPlanoProducaoSemDat;
		
		this.roteiroRN = new RoteiroRN(daoGenerico);
		this.folhaRN = new FolhaRN(daoGenerico);
		this.listaDwRotaDosPlanosProducoesAtivos = roteiroRN.getDwRotaDeProdutosDosPlanosProducoesAtivos(ppPlano);

		getLinhasOperacoesComRoteiros(listaDwRotaDosPlanosProducoesAtivos); // this.getLinhasOperacoesBaseadoEmRoteiroDosProdutosDosPlanosProducao();	
		
		getLinhasOperacoesBaseadoEmRoteirosComProdutosDAT();
		
		getLinhasOperacoesSemRoteiro(listaDwRotaDosPlanosProducoesAtivos);
	}

	
	public Map<String, Integer> getMapProdutosUltimoEstagioIAC(){
		return mapProdutosUltimoEstagioIAC;
	}

	public Set<String> getListPtsComOperacoes(){
		return this.listPtsComOperacoes;
	}
	
	public Map<String, Integer> getMapEstagioProduto(){
		return this.mapEstagioProduto;
	}

	private void getLinhasOperacoesBaseadoEmRoteirosComProdutosDAT(){
		
		for(OmProduto omProduto: this.mapProdutosFinaisDoPlanoProducaoComDat.values()){
			String cdProdutoSemComplementoDat = IntegracaoEstruturaProduto.removerComplementoDatDeCdProduto(omProduto.getCdProduto());
			
			DwRota dwrota = roteiroRN.getDwRotaQueTemProdutoIACNoPasso(cdProdutoSemComplementoDat);
			
			if(dwrota == null){
				// Senão encontrar a rota pode ser que o produto DAT seja um IMC
				// Então procurar na tabela de operações do IMC os produtos finais que tem o semiacabado, e usar algum roteiro de produto final
				dwrota = roteiroRN.getDwRotaQueTemProdutoIMCNoPasso(cdProdutoSemComplementoDat);
				
			}
			
			getLinhasOperacoesDwRotaEDwOperacao(dwrota, cdProdutoSemComplementoDat, true);
			
		}
		
		
	}
	
	private String getLinhasOperacoesSemRoteiro(List<DwRota> rotasProdutosFinais){
		
		StringBuilder linhas = new StringBuilder();
		
		Set<String> produtosPlanoProducaoComRoteiro = new HashSet<String>();
		for(DwRota rota: rotasProdutosFinais){
			produtosPlanoProducaoComRoteiro.add(rota.getOmProduto().getCdProduto());
		}
		
		
		for(OmProduto omProduto: mapProdutosFinaisDoPlanoProducaoSemDat.values()){
			if(produtosPlanoProducaoComRoteiro.contains(omProduto.getCdProduto()) == false){
				//String linhaOperacaoIMC = getLinhasOperacoesIMCPeloProdutoAcabado(omProduto.getCdProduto(), 0);
				String linhaOperacaoIMC = getLinhasOperacoesIMCPeloProdutoAcabado(omProduto.getCdProduto());
				linhas.append(linhaOperacaoIMC);
			}
		}
	
		return linhas.toString();
	}
	
	@Override
	protected String getFileName() {
		return "OPERACOES.txt";
	}

	@Override
	protected String getHeader() {
		return ArquivoTrilhaUtils.gerarLinha("ItemCod","Operacao","Estagio","LoteProducao","LoteTransferencia", "TempoRepouso", "RecursoCod", "TaxaProducao", "Classe");
	}

	@Override
	protected String getBody() {
		
		StringBuilder sb = new StringBuilder();
		
		List<String> listaLinhasOrdenadas = new ArrayList<String>();
		listaLinhasOrdenadas.addAll(linhasArquivoSemRepeticao);		
		Collections.sort(listaLinhasOrdenadas);
		
		for(String linha: listaLinhasOrdenadas){
			sb.append(linha);
			sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);
		}
		
		return sb.toString();
	}
	
	private void getLinhasOperacoesComRoteiros(List<DwRota> listaDwRota){
		
		for (DwRota dwrota : listaDwRota) {
			getLinhasOperacoesDwRotaEDwOperacao(dwrota, null, true);
		}

	}

	private void getLinhasOperacoesDwRotaEDwOperacao(DwRota dwrota, String cdProdutoComPassosDesejado, boolean isVerificarSeProdutoEstahNaEstruturaQuandoRoteiroForSemiAcabado){

		boolean isChegouNoCdProdutoComPassosDesejado = false;
		
		int ultimoEstagioGeradoParaProduto = 0;
		
		if(dwrota != null){
			
			List<PassosDTO> ultimosPassos = montarUltimosPassos(dwrota);		
			
			// Percorrer os passos montados para exportar os arquivos
			for (PassosDTO ultimoPasso : ultimosPassos){
				
				int estagio = 0;
				
				for (int iPasso = 1; iPasso <= ultimoPasso.getQtMaxPassos(); iPasso++){
					
					List<PassosDTO> passosNoNivel = ultimoPasso.getPassosNoNivel(iPasso);
					
						
					for (PassosDTO pNivel : passosNoNivel){
						
						estagio++;	
						
						for (CtDTO ct : pNivel.getCtsPossiveisOrdenandoPeloCiclo()) {
							
							if(podeExportarOperacaoIAC(pNivel.getDwfolha())){
								
								OmProduto omproduto = pNivel.getDwfolha().getDwFolhaiacs().iterator().next().getOmProduto();
								
								boolean isPodeExportarOperacao = true;
								
								if(isVerificarSeProdutoEstahNaEstruturaQuandoRoteiroForSemiAcabado == false){
									
									if(!StringUtils.isEmpty(cdProdutoComPassosDesejado)){
										if(omproduto.getCdProduto().equals(cdProdutoComPassosDesejado)){
											isChegouNoCdProdutoComPassosDesejado = true;	
										}									
									}
									
								}else{
									String cdProdutoPai = cdProdutoComPassosDesejado;
									if(StringUtils.isEmpty(cdProdutoComPassosDesejado)){
										cdProdutoPai = dwrota.getOmProduto().getCdProduto();
									}
									isPodeExportarOperacao = isProdutoFilhoFazParteEstruturaProdutoPaiPeloCodigoProduto(cdProdutoPai, omproduto.getCdProduto());
								}
								
								if(isPodeExportarOperacao){
									
									String maquina = null;
									if(pNivel.isCtsPossiveisDefinidosManualmente()){
										maquina = ct.getId().toString();
									}
									
									if(!StringUtils.isEmpty(maquina)){
										listPtsComOperacoes.add(maquina);
									}
									
									BigDecimal cicloPadrao = getCicloPadrao(pNivel.getDwfolha(), maquina);
									BigDecimal qtCavAtivas = folhaRN.getPcsPorCicloAtivasFromDwFolhaiac(ct.getDwfolha());								
									BigDecimal taxaProducao = calcularTaxaProducaoParaIAC(cicloPadrao, qtCavAtivas);								
									BigDecimal loteMinimo = omproduto.getQtLoteminprod();								
									BigDecimal loteTransferencia = null;
									if(pNivel.getDwrotapasso().getQtMovimentacao() != null){
										loteTransferencia = pNivel.getDwrotapasso().getQtMovimentacao();
									}
									
	
									String linhaOperacao = gerarLinhaArquivoOperacao(omproduto.getCdProduto(), pNivel.getDwfolha().getOmTppt().getCdTppt(), estagio, 
											taxaProducao, loteMinimo, loteTransferencia, maquina, LOTE_TRANSFERENCIA_PADRAO_IAC);
									
									mapEstagioProduto.put(omproduto.getCdProduto(), estagio);
									
									linhasArquivoSemRepeticao.add(linhaOperacao);
									
									ultimoEstagioGeradoParaProduto = ObjectUtils.max(ultimoEstagioGeradoParaProduto, estagio);
									
									
								}else{
//									//System.out.println("Produto " + omproduto.getCdProduto() + " não faz parte do produto " + cdProdutoComPassosDesejado);
								}
								
								guardarUltimoEstagioIACDoProdutoAntesTesteEletrico(pNivel.getDwfolha(), omproduto, estagio);
								
								
							}
							
							
							// se as maquinas NAO foram definidas manualmente, entao nao mandara para a trilha
							if (pNivel.isCtsPossiveisDefinidosManualmente() == false){
								break;
							}
							
						}
						
						
						// Se chegou no produto desejado, não precisa pegar os passos seguinte
						if(isChegouNoCdProdutoComPassosDesejado && (isVerificarSeProdutoEstahNaEstruturaQuandoRoteiroForSemiAcabado == false)){
							break;
						}
						

					}
					
					
					// Se chegou no produto desejado, não precisa pegar os passos seguinte
					if(isChegouNoCdProdutoComPassosDesejado && (isVerificarSeProdutoEstahNaEstruturaQuandoRoteiroForSemiAcabado == false)){
						break;
					}					
					
				}
				
				// Se chegou no produto desejado, não precisa pegar os passos seguinte
				if(isChegouNoCdProdutoComPassosDesejado && (isVerificarSeProdutoEstahNaEstruturaQuandoRoteiroForSemiAcabado == false)){
					break;
				}
				
			}
		
		}

		boolean isPegarOperacoesIMCPeloProdutoAcabado = StringUtils.isEmpty(cdProdutoComPassosDesejado);		

		if(isPegarOperacoesIMCPeloProdutoAcabado){
			
			// Pega as oeprações do IMC pelo produto acabado
			getLinhasOperacoesIMCPeloProdutoAcabado(dwrota.getOmProduto().getCdProduto());

		}else{
			getLinhasOperacoesIMCPeloProdutoSemiAcabado(cdProdutoComPassosDesejado);
		}
		
		
		
	}
	
	private BigDecimal getCicloPadrao(DwFolha dwFolha, String codigo){
		
		BigDecimal cicloPadrao = null; //dwFolha.getSegCiclopadrao();
		
		if(!StringUtils.isEmpty(codigo)){
			DwFolhacicDAO dwFolhacicDAO = new DwFolhacicDAO(dao.getSession());
			DwFolhacic dwFolhacic = dwFolhacicDAO.getDwFolhacicPelaFolhaECdGtOuCdPt(dwFolha, codigo);
			if(dwFolhacic != null){
				cicloPadrao = dwFolhacic.getSegCiclopadrao();
			}
		}
		
		return cicloPadrao;
		
	}
	
	private List<PassosDTO> montarUltimosPassos(DwRota dwrota){
		List<PassosDTO> ultimosPassos = new ArrayList<PassosDTO>();
		
		// Montar lista de Passos que NÃO sao predecessoras de nenhum outro passo
		for (DwRotapasso dwrotapasso : dwrota.getDwRotapassos()){
			boolean isUltimoPasso = true;
			// Avaliar se dwrotapasso eh o ultimo passo
			for (DwRotapasso rp : dwrota.getDwRotapassos()){
				for (DwRpPredecessora pre : rp.getDwRpPredecessorasForIdRotapassoPai() ){
					if (dwrotapasso.getIdRotapasso() == pre.getDwRotapassoByIdRotapassoFilho().getIdRotapasso()) {
						isUltimoPasso = false;
						break;
					}
				}				
				if (isUltimoPasso == false)
					break;
			}
						
			if (isUltimoPasso == true) {
				PassosDTO passo = new PassosDTO(dwrotapasso);
				passo.setDwfolha(dwrotapasso.getDwFolha());
				passo.defineCtsDisponiveis(dwrotapasso, null, 0, 0, dao);
				
				// Para cada ULTIMO passo montar a lista de predecessoras
				passo.inicializaPredecessoras(dao);

				// Incluir no list dos ultimos passos
				ultimosPassos.add(passo);
			}
		}
		
		return ultimosPassos;
	}
	
	private String getLinhasOperacoesIMCPeloProdutoSemiAcabado(String cdProdutoSemiacabado){		
		
		List<DwOperacao> listaOperacoes = roteiroRN.getOperacoesProdutoDoSemiacabado(cdProdutoSemiacabado);
		
		return getLinhasOperacoesIMC(cdProdutoSemiacabado, listaOperacoes);
		
	}

	private String getLinhasOperacoesIMCPeloProdutoAcabado(String cdProdutoAcabado){		
		
		List<DwOperacao> listaOperacoes = roteiroRN.getOperacoesDoProdutoAcabado(cdProdutoAcabado);
		
		return getLinhasOperacoesIMC(cdProdutoAcabado, listaOperacoes);
		
	}
	
	private String getLinhasOperacoesIMC(String cdProdutoPai, List<DwOperacao> listaOperacoes){
		StringBuilder sb = new StringBuilder();
		
		for(DwOperacao dwOperacao: listaOperacoes){
			
			OmProduto omProdutoSemiAcabado = dwOperacao.getOmProdutoByIdProdutosemiacabado();
			String cdProdutoSemiAcabado = dwOperacao.getOmProdutoByIdProdutosemiacabado().getCdProduto();			
			BigDecimal taxaProdutoIMC = calcularTaxaProducaoParaIMC(dwOperacao.getSegCiclopadrao());
			BigDecimal loteMinimo = omProdutoSemiAcabado.getQtLoteminprod();
			BigDecimal loteTransferencia = new BigDecimal(LOTE_TRANSFERENCIA_PADRAO_IMC);
			String operacao = dwOperacao.getDwTOperacao().getDsToperacao();
			String maquina = dwOperacao.getOmPt().getCdPt();
					
			listPtsComOperacoes.add(maquina);
			
			int estagio = getEstagioIMC(cdProdutoSemiAcabado);
			
			String linhaOperacao = gerarLinhaArquivoOperacao(cdProdutoSemiAcabado, operacao, estagio, 
					taxaProdutoIMC, loteMinimo, loteTransferencia, maquina, LOTE_TRANSFERENCIA_PADRAO_IMC);
			
			mapEstagioProduto.put(cdProdutoSemiAcabado, estagio);

			
			linhasArquivoSemRepeticao.add(linhaOperacao);
					
		}
		
		
		return sb.toString();
	}
	
	private String gerarLinhaArquivoOperacao(String cdProduto, String cdOperacao, int estagio, BigDecimal taxaProducao, BigDecimal loteMinimoProducao, BigDecimal loteTranferencia, String maquina, int loteTransferenciaDefault){
		

		String loteMinimoProducaoString = "";
		if(loteMinimoProducao == null || loteMinimoProducao.intValue() <= 0 || CONSIDERAR_APENAS_LOTE_MINIMO_PRODUCAO_DEFAULT ){
			loteMinimoProducaoString = String.valueOf(LOTE_MINIMO_PRODUCAO_PADRAO);	
		}else{
			loteMinimoProducaoString = ArquivoTrilhaUtils.formataDecimal(loteMinimoProducao.doubleValue());
		}
		
		String loteTransferenciaString = "";
		if(loteTranferencia == null || loteTranferencia.intValue() <= 0 || CONSIDERAR_APENAS_LOTE_TRANSFERENCIA_DEFAULT){
			loteTransferenciaString =  String.valueOf(loteTransferenciaDefault);
		}else{
			loteTransferenciaString = ArquivoTrilhaUtils.formataDecimal(loteTranferencia.doubleValue());
		}
		
		String taxaProducaoString = ArquivoTrilhaUtils.SEM_VALOR;
		if(taxaProducao != null){
			taxaProducaoString = ArquivoTrilhaUtils.formataBigDecimal(taxaProducao).toString();
		}
		
		String linha = ArquivoTrilhaUtils.gerarLinha(
				cdProduto, 
				cdOperacao, 
				String.valueOf(estagio), 
				loteMinimoProducaoString, 
				loteTransferenciaString, 
				String.valueOf(TEMPO_REPOUSO_PADRAO),
				(StringUtils.isEmpty(maquina) ? "-1": maquina),
				taxaProducaoString, 
				String.valueOf(CLASSE_PADRAO));
		
		return linha;
		
	}

	private boolean isProdutoFilhoFazParteEstruturaProdutoPaiPeloCodigoProduto(String cdProdutoPai, String cdProdutoFilho){
		OmProduto omProdutoPai = mapTodosProdutos.get(cdProdutoPai);
		if(omProdutoPai != null){
			return isProdutoFilhoFazParteEstruturaProdutoPaiPeloOmProduto(omProdutoPai, cdProdutoFilho);
		}
		return false;
	}

	private boolean podeExportarOperacaoIAC(DwFolha dwFolha){
		
		if(OmTpptTemplate.Type.PVE.equals(dwFolha.getOmTppt())){
			return false;
		}
		
		if(DESPREZAR_OPERACAO_TESTE_ELETRICO){
			
			if(OmTpptTemplate.Type.PTE.equals(dwFolha.getOmTppt()) 
					|| isCdFolhaTesteEletrico(dwFolha.getCdFolha())){
				return false;
			}
			
			
		}
		
		return true;
		
	}

	private BigDecimal calcularTaxaProducaoParaIAC(BigDecimal cicloPadrao, BigDecimal qtAtivas){
		if(cicloPadrao == null){
			return null;
		}
		BigDecimal cicloPadraoPorPeca = cicloPadrao.divide(qtAtivas, MathContext.DECIMAL32);
		return calcularTaxaProducao(cicloPadraoPorPeca).multiply(EFICIENCIA_TAXA_PRODUCAO_IAC);
	}
	

	private boolean isCdFolhaTesteEletrico(String cdFolha){
		
		if(StringUtils.isEmpty(cdFolha)){
			return false;
		}
		
		if(cdFolha.contains("-ICT")
				|| cdFolha.contains("-TRI")){
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * Calcula a taxa de produção baseado ciclo padrão
	 * {@code 3600 / cicloPadrao * EFICIENCIA}
	 * @param cicloPadrao
	 * @return
	 */
	private BigDecimal calcularTaxaProducao(BigDecimal cicloPadrao){		
		return new BigDecimal(3600).divide(cicloPadrao, MathContext.DECIMAL32);
	}


	private void guardarUltimoEstagioIACDoProdutoAntesTesteEletrico(DwFolha dwFolha, OmProduto omProduto, int estagio){
		
		
		if(isCdFolhaTesteEletrico(dwFolha.getCdFolha()) == false 
				&& OmProdutoTemplate.TpProduto.SEMI_ACABADO.equals(omProduto.getTpProduto()) ){

			String cdProduto = omProduto.getCdProduto();

			Integer ultimoEstagio = mapProdutosUltimoEstagioIAC.get(cdProduto);
			
			ultimoEstagio = ObjectUtils.max(ultimoEstagio, new Integer(estagio));
			
			mapProdutosUltimoEstagioIAC.put(cdProduto, ultimoEstagio);
			
		}
		
	}

	private BigDecimal calcularTaxaProducaoParaIMC(BigDecimal cicloPadrao){		
		return cicloPadrao.multiply(EFICIENCIA_TAXA_PRODUCAO_IMC);
	}

	private boolean isProdutoFilhoFazParteEstruturaProdutoPaiPeloOmProduto(OmProduto omProdutoPai, String cdProdutoFilho){
		for (OmProcomest omProcomest : omProdutoPai.getOmProcomestsForIdProduto()) {
			
			if(omProcomest.getOmProdutoByIdProdutomp().getCdProduto().equals(cdProdutoFilho)){
				return true;
				
			}else{
				if(isProdutoFilhoFazParteEstruturaProdutoPaiPeloOmProduto(omProcomest.getOmProdutoByIdProdutomp(), cdProdutoFilho)){
					return true;
				}
			}
			
		}
		return false;
	}
	
	
	private int getEstagioIMC(String cdProdutoIMC){
		Integer estagio = mapEstagioProduto.get(cdProdutoIMC);
		
		if(estagio == null){
			
			estagio = getEstagioIMCBaseadoEmRoteiroDeSubitem(cdProdutoIMC);
		
			mapEstagioProduto.put(cdProdutoIMC, estagio);
			
		}
				
		return estagio;
	}
	
	private int getEstagioIMCBaseadoEmRoteiroDeSubitem(String cdProdutoIMC){
		
		Integer maiorEstagio = 1;
		
		for(String cdProdutoComEstagio: mapEstagioProduto.keySet()){
			if(isProdutoFilhoFazParteEstruturaProdutoPaiPeloCodigoProduto(cdProdutoIMC, cdProdutoComEstagio)){
				Integer estagio = mapEstagioProduto.get(cdProdutoComEstagio);
				estagio++;
				maiorEstagio = ObjectUtils.max(maiorEstagio, estagio);
			}
		}
		
		return maiorEstagio;
		
	}
	
}
