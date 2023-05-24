package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.DwFolhaoperacao;
import idw.model.pojos.DwOperacao;
import idw.model.pojos.IpBalanceamento;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.IpBalanceamentoTemplate;
import idw.model.pojos.template.IpBalanceamentoTemplate.StatusBalanceamento;
import idw.model.pojos.template.IpBalanceamentoTemplate.TipoAlgoritmo;
import idw.model.rn.algoritmos.balanceamento.AlgoritmoBalanceamentoPesoPosicional;
import idw.util.IdwLogger;
import idw.webservices.dto.FaseDTO;
import idw.webservices.dto.FolhaDTO;
import idw.webservices.dto.FolhasDTO;
import idw.webservices.dto.IpBalanceamentoDTO;
import idw.webservices.dto.IpBalanceamentosDTO;
import idw.webservices.dto.PostoBalanceamentoDTO;
import idw.webservices.dto.RelatorioGraficoLinhaBalanceadaOperacaoDTO;
import idw.webservices.dto.RelatorioGraficoLinhaBalanceadaPostoDTO;
import idw.webservices.dto.RelatorioGraficoTempoProdutoDTO;
import idw.webservices.dto.ResultadoDTO;
import ms.util.ConversaoTipos;

public class BalanceamentoRN extends AbstractRN<DAOGenerico> {
	
	public static final String LABEL_TAKT_TIME = "Takt Time";
	public static final String COR_TAKT_TIME = "16711680";//Color.RED
	
	public static final String LABEL_TEMPO_TOTAL_GRAFICO_TEMPO_PRODUTO = "Tempo Total";
	public static final String COR_TEMPO_TOTAL_GRAFICO_TEMPO_PRODUTO = COR_TAKT_TIME;
	
	public BalanceamentoRN() {
		this(null);
	}

	public BalanceamentoRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public IpBalanceamentosDTO pesquisarBalanceamento(IpBalanceamentoDTO filtro){
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("SELECT balanceamento");		
		q.append("FROM IpBalanceamento balanceamento");
		q.append("WHERE 1 = 1");
		
		if( filtro.getBalanceamento() != null && filtro.getBalanceamento().getCdBalanceamento() != null && !filtro.getBalanceamento().getCdBalanceamento().equals("")){
			q.append("AND balanceamento.cdBalanceamento = :cdBalanceamento");
		}
		
		if(filtro.getBalanceamento().getOmProdutoByIdProdutoacabado() != null && filtro.getBalanceamento().getOmProdutoByIdProdutoacabado().getIdProduto() != 0L){
			q.append("AND balanceamento.omProdutoByIdProdutoacabado.idProduto = :idProdutoAcabado");
		}
		
		if(filtro.getBalanceamento().getOmProdutoByIdProdutosemiacabado() != null && filtro.getBalanceamento().getOmProdutoByIdProdutosemiacabado().getIdProduto() != 0L){
			q.append("AND balanceamento.omProdutoByIdProdutosemiacabado.idProduto = :idProdutoSemiAcabado");
		}
		
		if (filtro.getBalanceamento().getRevisao() != null) {
			q.append("AND balanceamento.revisao = :revisao");
		}
		if (filtro.getBalanceamento().getStAtivo() != null && filtro.getBalanceamento().getStAtivo() < (byte)2) {
			q.append("AND balanceamento.stAtivo = :stAtivo");
		}
		
		q.defineParametro("cdBalanceamento", filtro.getBalanceamento().getCdBalanceamento());
		q.defineParametro("idProdutoAcabado", filtro.getBalanceamento().getOmProdutoByIdProdutoacabado().getIdProduto());
		q.defineParametro("idProdutoSemiAcabado", filtro.getBalanceamento().getOmProdutoByIdProdutosemiacabado().getIdProduto());
		q.defineParametro("revisao", filtro.getBalanceamento().getRevisao());
		q.defineParametro("stAtivo", filtro.getBalanceamento().getStAtivo());
		
		List<IpBalanceamento> listaPesquisa = null;
		try{
			listaPesquisa = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<IpBalanceamentoDTO> lista = new ArrayList<IpBalanceamentoDTO>();

		if (listaPesquisa != null) {
			for (IpBalanceamento item : listaPesquisa) {
				IpBalanceamentoDTO dto = new IpBalanceamentoDTO();
				dto.setBalanceamento(item.clone());
				lista.add(dto);
			}
		}
		IpBalanceamentosDTO listaRetorno = new IpBalanceamentosDTO();
		listaRetorno.setLista(lista);
		return listaRetorno;		
	}
	
	public IpBalanceamentoDTO setBalanceamento(IpBalanceamentoDTO dto){		
		dto = validarBalanceamento(dto);
		dto.getBalanceamento().setStBalanceamento(IpBalanceamentoTemplate.StatusBalanceamento.CADASTRADO.getValue());
		if(dto.getResultado().getIdmensagem() == dto.getResultado().getCOM_SUCESSO()){			
			dto.setBalanceamento(salvarDesativandoOriginal(dto.getBalanceamento().clone(true), new Date(),
					dto.getBalanceamento().getOmUsrByIdUsrrevisao()).clone());
		}
		return dto;
	}
	
	//se o dto for valido é retornado: IpBalanceamentoDTO.resultado.idmensagem = ResultadoDTO.COM_SUCESSO;
	public IpBalanceamentoDTO validarBalanceamento(IpBalanceamentoDTO dto){
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		dto.setResultado(resultadoDTO);		
		
		//VALIDANDO CODIGO
		IpBalanceamento balanceamentoSalvo = null;
		if(dto.getBalanceamento().getIdBalanceamento() == null || dto.getBalanceamento().getIdBalanceamento() == 0L) {
			balanceamentoSalvo = getIpBalanceamento(dto.getBalanceamento().getCdBalanceamento());
			
			if(balanceamentoSalvo != null){
				resultadoDTO.setIdmensagem(resultadoDTO.getCODIGO_EM_USO());
				return dto;
			}
		}
		
		//VALIDANDO PRODUTO ACABADO
		boolean produtoAcabadoValido = false;
		ProdutoRN produtoRN = new ProdutoRN(getDao());
		if(dto.getBalanceamento().getOmProdutoByIdProdutoacabado() != null){
			try {
				dto.getBalanceamento().setOmProdutoByIdProdutoacabado(produtoRN.getOmProduto(dto.getBalanceamento().getOmProdutoByIdProdutoacabado().getCdProduto()));
				produtoAcabadoValido = true;
			} catch (RegistroDesconhecidoException e) {
				produtoAcabadoValido = false;
			}
		}
		
		if(produtoAcabadoValido == false){
			resultadoDTO.setIdmensagem(resultadoDTO.getPRODUTO_ACABADO_INVALIDO());
			return dto;
		}
				
		//VALIDANDO PRODUTO SEMI ACABADO
		boolean produtoSemiAcabadoValido = false;
		if(dto.getBalanceamento().getOmProdutoByIdProdutosemiacabado() != null){
			try {
				dto.getBalanceamento().setOmProdutoByIdProdutosemiacabado(produtoRN.getOmProduto(dto.getBalanceamento().getOmProdutoByIdProdutosemiacabado().getCdProduto()));
				produtoSemiAcabadoValido = true;
			} catch (RegistroDesconhecidoException e) {
				produtoSemiAcabadoValido = false;
			}
		}
		
		if(produtoSemiAcabadoValido == false){
			resultadoDTO.setIdmensagem(resultadoDTO.getPRODUTO_SEMI_ACABADO_INVALIDO());
			return dto;
		}
		
		//VALIDANDO SE PRODUTO ACABADO E SEMI ACABADO É UNICO
//		IpBalanceamentoDTO filtro = new IpBalanceamentoDTO();
//		IpBalanceamento balanceamento = new IpBalanceamento();
//		balanceamento.setOmProdutoByIdProdutoacabado(produtoRN.getOmProduto(dto.getBalanceamento().getOmProdutoByIdProdutoacabado().getIdProduto()).clone(true));
//		balanceamento.setOmProdutoByIdProdutosemiacabado(produtoRN.getOmProduto(dto.getBalanceamento().getOmProdutoByIdProdutosemiacabado().getIdProduto()).clone(true));
//		balanceamento.setStAtivo(new Byte("1"));
//		filtro.setBalanceamento(balanceamento);
//		IpBalanceamentosDTO dtos = pesquisarBalanceamento(filtro);
//		if(dtos.getLista().size() > 0) {
//			resultadoDTO.setIdmensagem(resultadoDTO.getPRODUTO_NAO_ACEITO());
//			return dto;
//		}
		
		//VALIDANDO ALGORITMO BALANCEAMENTO
		boolean tipoAlgoritmoValido = false;
		if(dto.getBalanceamento().getTpAlgoritmo() != null){
			for(TipoAlgoritmo tipoAlgoritmo : IpBalanceamentoTemplate.TipoAlgoritmo.values()){
				if(dto.getBalanceamento().getTpAlgoritmo().equals(tipoAlgoritmo.getValue())){
					tipoAlgoritmoValido = true;
					break;
				}
			}
		}		
		
		if(tipoAlgoritmoValido == false){
			resultadoDTO.setIdmensagem(resultadoDTO.getALGORITMO_BALANCEAMENTO_INVALIDO());
			return dto;
		}
		
		resultadoDTO.setIdmensagem(resultadoDTO.getCOM_SUCESSO());			
		return dto;
	}
	
	public IpBalanceamentoDTO balancear(IpBalanceamentoDTO dto){
		IdwLogger log = new IdwLogger("BalanceamentoRN");
		int idLog = log.getIdAleatorio();
		
		ProdutoRN produtoRN = new ProdutoRN(getDao());
		OmProduto produtoAcabado = null;
		OmProduto produtoSemiAcabado = null;
		try {
			produtoAcabado = produtoRN.getOmProduto(dto.getBalanceamento().getOmProdutoByIdProdutoacabado().getCdProduto());
			produtoSemiAcabado = produtoRN.getOmProduto(dto.getBalanceamento().getOmProdutoByIdProdutosemiacabado().getCdProduto());
		} catch (RegistroDesconhecidoException e) {
			//tratar produto desconhecido
		}
		
		if(produtoAcabado == null || produtoSemiAcabado == null){
			//tratar produto null
		}
		
		OperacaoRN operacaoRN = new OperacaoRN(getDao());
		List<DwOperacao> operacoes = operacaoRN.getOperacoes(produtoAcabado, produtoSemiAcabado);	
		
		IpBalanceamento balanceamento = dto.getBalanceamento();
		
		BigDecimal tempoDiarioSegundos = balanceamento.getSegTempodisponiveldiario();
		BigDecimal producaoDiaria = balanceamento.getPcsProducaoplanejadadiaria();
		BigDecimal fadiga = balanceamento.getIndFadiga();
		
		BigDecimal taktTime;
		boolean isPossuiTaktTime = dto.getBalanceamento() != null && dto.getBalanceamento().getSegTakttime() != null;
		if(dto.isRebalancear() || isPossuiTaktTime){
			taktTime = dto.getBalanceamento().getSegTakttime();
		} else {
			taktTime = balanceamento.calcularTaktTime(tempoDiarioSegundos, producaoDiaria, fadiga);
		} 
		
		AlgoritmoBalanceamentoPesoPosicional algoritmoBalanceamentoPesoPosicional = new AlgoritmoBalanceamentoPesoPosicional();
		List<FaseDTO> fases = algoritmoBalanceamentoPesoPosicional.balancear(taktTime.longValue(), operacoes, log, idLog);
		
		BigDecimal numeroPostosTrabalho = BigDecimal.ZERO;
		if(fases != null && fases.size() != 0){
			for(FaseDTO fase : fases){
				if(fase.getPostos() != null){
					BigDecimal size = new BigDecimal(fase.getPostos().size());
					numeroPostosTrabalho = numeroPostosTrabalho.add(size);
				}
			}
		}
		
		BigDecimal tempoTotalMontagem = balanceamento.getTempoTotalMontagem(operacoes);
		long quantidadeTotalOperacoes = balanceamento.getQuantidadeTotalOperacoes(operacoes);
		
		BigDecimal eficiencia;
		if(numeroPostosTrabalho == BigDecimal.ZERO){
			eficiencia = BigDecimal.ZERO;
		} else {
			eficiencia = balanceamento.calcularEficiencia(numeroPostosTrabalho, taktTime, tempoTotalMontagem);
		}
		
		dto.setFases(fases);
		dto.setTaktTime(taktTime);
		dto.setCorTaktTime(COR_TAKT_TIME);
		dto.setTempoTotalMontagem(tempoTotalMontagem);
		dto.setQuantidadeTotalOperacoes(quantidadeTotalOperacoes);
		dto.setNumeroPostosTrabalho(numeroPostosTrabalho);
		dto.setEficiencia(eficiencia);
		
		dto.setListaRelatorioPosto(gerarRelatorioGraficoLinhaBalanceadaPosto(dto));
		dto.setListaRelatorioOperacao(gerarRelatorioGraficoLinhaBalanceadaOperacao(dto));
		
		dto.setListaRelatorioGraficoTempoProduto(gerarRelatorioGraficoTempoProduto(dto));
		return dto;
	}
	
	public IpBalanceamentoDTO firmarBalanceamento(IpBalanceamentoDTO dto){
		ResultadoDTO resultado = new ResultadoDTO();
		
		boolean isStatusBalanceamentoCadastrado =
				(dto.getBalanceamento() != null)
				&& (dto.getBalanceamento().getStBalanceamento() != null)
				&& (dto.getBalanceamento().getStBalanceamento() == StatusBalanceamento.CADASTRADO.getValue());
		if(isStatusBalanceamentoCadastrado == false){
			resultado.setIdmensagem(resultado.getSTATUS_BALANCEAMENTO_INVALIDO());
			dto.setResultado(resultado);
			return dto;
		}
		
		OmGt GT = dto.getBalanceamento().getOmGt();
		
		try {
			BigDecimal taktTime = dto.getBalanceamento().getSegTakttime();
			dto.setBalanceamento(getDao().findByCd(dto.getBalanceamento().clone(true)));
			dto.getBalanceamento().setSegTakttime(taktTime);
			dto.getBalanceamento().setOmGt(GT);
			dto.getBalanceamento().setStBalanceamento(StatusBalanceamento.FIRMADO.getValue());
			dto.setBalanceamento(getDao().makePersistent(dto.getBalanceamento()).clone(true));
		} catch (RegistroDesconhecidoException e) {
			e.printStackTrace();
		}
		
		FolhaRN folhaRN = new FolhaRN(getDao());
		
		for(FaseDTO fase : dto.getFases()){
			for(PostoBalanceamentoDTO posto: fase.getPostos()){
				DwFolha folha = new DwFolha();
				folha.setCdFolha(posto.getCodigoFolha());
				folha.setSegCiclotimeout(new BigDecimal(200));
				folha.setSegCiclopadrao(posto.getCicloPadrao());
				folha.setOmTppt(posto.getOmTppt());
				folha.setSegSetup(0);
				folha.setOmUsrByIdUsrrevisao(dto.getBalanceamento().getOmUsrByIdUsrrevisao());
				folha.setOmUsrByIdUsrstativo(dto.getBalanceamento().getOmUsrByIdUsrstativo());
				folha.setOmGt(GT);
				
				DwFolhaiac dwFolhaiac = new DwFolhaiac();
				dwFolhaiac.setDwFolha(folha);
				dwFolhaiac.setOmProduto(posto.getProdutoSemiAcabado().clone(true));
				dwFolhaiac.setQtAtiva(BigDecimal.ONE);
				
				folha.getDwFolhaiacs().add(dwFolhaiac);
				
				FolhaDTO folhaDTO = new FolhaDTO();
				folhaDTO.setFolha(folha);
				folhaDTO = folhaRN.setFolhaSemCadastroEtapaDTO(folhaDTO);
				
				//salvando DwFolhaOperacao
				Long ordem = new Long(posto.getOrdem());
				for(DwOperacao operacao : posto.getOperacoes()) {
					DwFolhaoperacao folhaoperacao = new DwFolhaoperacao();
					folhaoperacao.setDwFolha(folhaDTO.getFolha());
					folhaoperacao.setDwOperacao(operacao);
					folhaoperacao.setIpBalanceamento(dto.getBalanceamento());
					folhaoperacao.setOrdem(ordem.intValue());
					getDao().makePersistent(folhaoperacao);
				}
			}
		}	
		
		resultado.setIdmensagem(resultado.getCOM_SUCESSO());
		dto.setResultado(resultado);
		return dto;
	}
	
	public IpBalanceamentosDTO excluirBalanceamentos(IpBalanceamentosDTO dtos) {
		ResultadoDTO resultado = new ResultadoDTO();
		resultado.setIdmensagem(resultado.getCOM_SUCESSO());
		
		FolhaRN folhaRN = new FolhaRN(getDao());
		for(IpBalanceamentoDTO dto : dtos.getLista()){
			try {
				dto = balancear(dto);
				if(dto.getFases() != null){
					for(FaseDTO fase : dto.getFases()){
						if(fase.getPostos() != null){
							for(PostoBalanceamentoDTO postoDTO : fase.getPostos()){

								FolhaDTO folhaDTO = new FolhaDTO();
								DwFolha folha = new DwFolha();
								folha.setCdFolha(postoDTO.getCodigoFolha());
								folha.setStAtivo(new Byte("1"));
								folhaDTO.setFolha(folha);
								FolhasDTO folhasDTO = folhaRN.getFolhasDTO(folhaDTO);
								for(FolhaDTO filhaFolhaDTO : folhasDTO.getFolhas()) {
									getDao().desativar(DwFolha.class, filhaFolhaDTO.getFolha().getIdFolha(), new Date(), dto.getBalanceamento().getOmUsrByIdUsrrevisao().clone());
								}
							}
						}	
					}
				}
							
				this.getDao().desativar(IpBalanceamento.class, dto.getBalanceamento().getIdBalanceamento(), new Date(), dto.getBalanceamento().getOmUsrByIdUsrrevisao().clone());		
			} catch (RegistroJaDesativadoException e) {
				resultado.setIdmensagem(resultado.getERRO_EXCLUI_STATIVO_ZERO());
				break;
			}
		}
		
		dtos.setResultado(resultado);
		dtos.setLista(null);
		return dtos;
	}
	
	public IpBalanceamento salvarDesativandoOriginal(IpBalanceamento ipBalanceamento, Date dateBalanceamento, OmUsr omUsrBalanceamento) {
		return this.getDao().salvarDesativandoOriginal(ipBalanceamento, dateBalanceamento, omUsrBalanceamento);
	}
	
	public IpBalanceamento getIpBalanceamento(String cdBalanceamento){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("SELECT balanceamento FROM IpBalanceamento balanceamento");
		q.append("WHERE balanceamento.cdBalanceamento = :cdBalanceamento");
		q.append("ORDER BY balanceamento.idBalanceamento");
		q.defineParametro("cdBalanceamento", cdBalanceamento);
		q.setMaxResults(1);
		return (IpBalanceamento) q.uniqueResult();
	}
	
	private List<RelatorioGraficoLinhaBalanceadaPostoDTO> gerarRelatorioGraficoLinhaBalanceadaPosto(IpBalanceamentoDTO dto){
		List<RelatorioGraficoLinhaBalanceadaPostoDTO> lista = new ArrayList<>();
		
		List<FaseDTO> fases = dto.getFases();        
        for(FaseDTO fase : fases){
            for(PostoBalanceamentoDTO posto : fase.getPostos()){    
            	
            	BigDecimal tempoPosto = BigDecimal.ZERO;
            	for(DwOperacao operacao : posto.getOperacoes()){
            		tempoPosto = tempoPosto.add(operacao.getSegCiclopadrao());
            	}
            	
            	RelatorioGraficoLinhaBalanceadaPostoDTO graficoDTO = new RelatorioGraficoLinhaBalanceadaPostoDTO();
            	graficoDTO.setFase(fase.getFase().getCdGt());
            	graficoDTO.setCorFase(fase.getFase().getCor());
            	graficoDTO.setPosto(getPostoLabel(fase, posto));
            	graficoDTO.setTempoPosto(ConversaoTipos.converteParaString(tempoPosto, 2));
            	graficoDTO.setSegCicloPadrao(tempoPosto);
            	lista.add(graficoDTO);
            }            
        }
        
        RelatorioGraficoLinhaBalanceadaPostoDTO taktTime = new RelatorioGraficoLinhaBalanceadaPostoDTO();
        taktTime.setFase(LABEL_TAKT_TIME);
        taktTime.setCorFase(COR_TAKT_TIME);
        taktTime.setPosto("");
        taktTime.setTempoPosto(ConversaoTipos.converteParaString(dto.getTaktTime(), 2));
        taktTime.setSegCicloPadrao(dto.getTaktTime());
        
        lista.add(taktTime);
		
		return lista;
	}
	
	private List<RelatorioGraficoLinhaBalanceadaOperacaoDTO> gerarRelatorioGraficoLinhaBalanceadaOperacao(IpBalanceamentoDTO dto){
		List<RelatorioGraficoLinhaBalanceadaOperacaoDTO> lista = new ArrayList<>();
		
		List<FaseDTO> fases = dto.getFases();        
        for(FaseDTO fase : fases){
            for(PostoBalanceamentoDTO posto : fase.getPostos()){    
            	
            	BigDecimal tempoPosto = BigDecimal.ZERO;
            	for(DwOperacao operacao : posto.getOperacoes()){
            		tempoPosto = tempoPosto.add(operacao.getSegCiclopadrao());
            		
            		RelatorioGraficoLinhaBalanceadaOperacaoDTO graficoDTO = new RelatorioGraficoLinhaBalanceadaOperacaoDTO();            		
            		
                    String tempoOperacao = ConversaoTipos.converteParaString(operacao.getSegCiclopadrao(), 2);
                    
                    graficoDTO.setFase(fase.getFase().getCdGt());
                    graficoDTO.setCorFase(operacao.getOmGt().getCor());
                    graficoDTO.setPosto(getPostoLabel(fase, posto));
                    graficoDTO.setOperacao(operacao.getCd());
                    graficoDTO.setTempoOperacao(tempoOperacao);
                    graficoDTO.setSegTempoOperacao(operacao.getSegCiclopadrao());
                    lista.add(graficoDTO);
            	}
            }            
        }
        
        RelatorioGraficoLinhaBalanceadaOperacaoDTO taktTime = new RelatorioGraficoLinhaBalanceadaOperacaoDTO();
        taktTime.setFase(LABEL_TAKT_TIME);
        taktTime.setCorFase(COR_TAKT_TIME);
        taktTime.setPosto("");
        taktTime.setOperacao("");
        taktTime.setTempoOperacao(ConversaoTipos.converteParaString(dto.getTaktTime(), 2));
        taktTime.setSegTempoOperacao(dto.getTaktTime());
        
        lista.add(taktTime);
		
		return lista;
	}
	
	private List<RelatorioGraficoTempoProdutoDTO> gerarRelatorioGraficoTempoProduto(IpBalanceamentoDTO dto){
		List<RelatorioGraficoTempoProdutoDTO> lista = new ArrayList<>();
		
		List<FaseDTO> fases = dto.getFases();
		BigDecimal tempoTotal = BigDecimal.ZERO;
		BigDecimal tempoFase;
		String corFase = "";
		String produto = "";
        for(FaseDTO fase : fases){
        	
        	tempoFase = BigDecimal.ZERO;
            for(PostoBalanceamentoDTO posto : fase.getPostos()){
            	for(DwOperacao operacao : posto.getOperacoes()){
            		tempoTotal = tempoTotal.add(operacao.getSegCiclopadrao());
            		tempoFase = tempoFase.add(operacao.getSegCiclopadrao());
            		corFase = operacao.getOmGt().getCor();
            		produto = operacao.getOmProdutoByIdProdutosemiacabado().getCdProduto();
            	}
            }
            RelatorioGraficoTempoProdutoDTO graficoDTO = new RelatorioGraficoTempoProdutoDTO();
            graficoDTO.setFase(fase.getFase().getCdGt());
            graficoDTO.setCorFase(corFase);
            graficoDTO.setProduto(produto);
            graficoDTO.setTempoFase(ConversaoTipos.converteParaString(tempoFase, 2));
            lista.add(graficoDTO);
        }
        
        RelatorioGraficoTempoProdutoDTO tempoTotalDTO = new RelatorioGraficoTempoProdutoDTO();
        tempoTotalDTO.setFase(LABEL_TEMPO_TOTAL_GRAFICO_TEMPO_PRODUTO);
        tempoTotalDTO.setCorFase(COR_TEMPO_TOTAL_GRAFICO_TEMPO_PRODUTO);
        tempoTotalDTO.setProduto(produto);
        tempoTotalDTO.setTempoFase(ConversaoTipos.converteParaString(tempoTotal, 2));
        lista.add(tempoTotalDTO);
		
		return lista;
	}
	
	private String getPostoLabel(FaseDTO fase, PostoBalanceamentoDTO posto){
		String postoLabel = "Posto " + fase.getOrdemFase() + posto.getOrdem();
        postoLabel += " (" + posto.getOmTppt().getCdTppt() + ")";
        return postoLabel;
	}

}
