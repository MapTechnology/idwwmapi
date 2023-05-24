package idw.model.rn.integracao.semptoshiba;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCliente;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PedidoClienteRN;
import idw.model.rn.UsuarioRN;
import idw.model.rn.integracao.semptoshiba.APISempToshiba.PlanoProducao;
import idw.webservices.dto.PlanoDTO;
import idw.webservices.dto.PpNecDTO;
import idw.webservices.dto.PpNecListDTO;
import idw.webservices.dto.PpNeccronDTO;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.dto.ResultadoDTO;
import idw.webservices.dto.UsuarioDTO;

public class IntegracaoPlanoProducao{

	private final DAOGenericoErp daoSempToshiba;
	private final DAOGenerico daoIdw;

	public IntegracaoPlanoProducao(DAOGenerico daoIdw, DAOGenericoErp daoSempToshiba) {
		this.daoIdw = daoIdw;
		this.daoSempToshiba = daoSempToshiba;
	}

	
	/**
	 * Faz a integra��o dos plano de produ��o das datas de referencia 1 e 2
	 * <br> Antes de realizar a integra��o dos planos de produ��o. Desativa todos os pedidos ativos
	 * @param dtInicio apenas de ser um date, est� usando apenas o m�s. Dia e hora ser�o ajustados para o in�cio do m�s
	 * @param dtFim apesar de ser um date, est� usando apenas o m�s. Dia e hora ser�o ajustado para ultimo dia e hora do m�s
	 * @param usrlogado
	 * @param integrarProdutos se {@code true} faz a integra��o dos produtos envolvidos nos planos de produ��o, antes de integr�-los
	 * @return
	 * @throws Exception 
	 */
	public PpNecListDTO integrar(Date dtInicio, Date dtFim, UsuarioDTO usrlogado, boolean integrarProdutos) throws Exception{
				
		Validate.notNull(dtInicio, "dtReferencia1 n�o pode ser nulo");
		Validate.notNull(usrlogado, "usrlogado n�o pode ser nulo");
		
		PpNecListDTO ppNecListDTO = new PpNecListDTO();
		
		// Cole��o com os planos de produ��o a serem integrados para o per�odo (
		Map<Date, List<PlanoProducao>> planosProducaoPeriodo = new HashMap<Date, List<PlanoProducao>>();
		
		// Cole��o com o produtos acabados que fazem parte dos planos de produ��o
		Set<String> produtosAcabados = new HashSet<String>();
		
		Set<String> produtosSemiAcabados = new HashSet<String>();	

		dtInicio = DataHoraRN.getDataHoraInicioMes(dtInicio);

		String dtFimYYYYMM = DataHoraRN.dateToStringYYYYMM(dtFim, "-");		 
		
		Date dataHoraAtual = DataHoraRN.getDataHoraAtual();
		
		dtInicio = DataHoraRN.getMaiorData(dataHoraAtual, dtInicio);
		
		dtInicio = DataHoraRN.getDataSemHora(dtInicio);

		// Se data de fim n�o for passado, indica que s� quer pegar os dados da data de in�cio
		// Deixa fim igual a in�cio, assim pegar� s� da data de in�cio
		dtFim = ObjectUtils.defaultIfNull(dtFim, dtInicio);

		dtFim = DataHoraRN.getDataHoraFimMes(dtFim);

		// Volta 1 m�s, porque dentro do loop, o m�se � adicionado antes de ser usado		
		Date dt = DataHoraRN.adicionaMesNaData(dtInicio, -1);
		
		String dtYYYYMM = null;
		
		UsuarioRN usuarioRN = new UsuarioRN(daoIdw);
		OmUsr omUsr = usuarioRN.getDao().findById(OmUsr.class, usrlogado.getUsuario().getIdUsr(), false);
		usuarioRN = null;
		
		// Pega plano de produ��o dos per�odos
		boolean isPrimeiraVez = true;
		do {
			
			dt = DataHoraRN.adicionaMesNaData(dt, 1);
			dtYYYYMM = DataHoraRN.dateToStringYYYYMM(dt, "-");
			
			List<APISempToshiba.PlanoProducao> listaPlanoProducao = APISempToshiba.SPPlanoProducao.getResultado(daoSempToshiba, dtYYYYMM, "", dtInicio, dtFim);
			
			// Guarda produtos que est�o na lista de planos de produ��o
			addListaProdutosAcabadosOuSemiAcabados(produtosAcabados, produtosSemiAcabados, listaPlanoProducao);
					
			// Guarda a lista de plano de produ��o
			planosProducaoPeriodo.put(dt, listaPlanoProducao);
			
			isPrimeiraVez = false;
		} while(dtYYYYMM.equals(dtFimYYYYMM) == false); // Sai do loop quando passar do fim
		
		// Faz a integra��o dos produtos que est�o na lista de plano de produ��o
		if(integrarProdutos){

			
			IntegracaoEstruturaProduto integracaoEstruturaProduto = new IntegracaoEstruturaProduto(daoIdw, daoSempToshiba);
			List<String> produtosIntegrados = new ArrayList<String>();
			Map<String, OmProduto> produtosEnvolvidosIntegracaoPersistidos = new HashMap<String, OmProduto>();

			// Integra os produtos acabados
//			List<ProdutoDTO> resultadoIntegProdPA = new ArrayList<ProdutoDTO>();
			List<ProdutoDTO> resultadoIntegProdPA = integracaoEstruturaProduto.integrarListaProdutos(produtosAcabados, OmProdutoTemplate.TpProduto.PRODUTO_FINAL, false, usrlogado.getUsuario(), produtosIntegrados, produtosEnvolvidosIntegracaoPersistidos, true);

			// Integra os produtos DAT
			List<ProdutoDTO> resultadoIntegProdDAT = integracaoEstruturaProduto.integrarListaProdutos(produtosSemiAcabados, OmProdutoTemplate.TpProduto.PRODUTO_FINAL, true, usrlogado.getUsuario(), produtosIntegrados, produtosEnvolvidosIntegracaoPersistidos, true);
			
			ppNecListDTO.getResultadoIntegProdutos().addAll(resultadoIntegProdPA);
			ppNecListDTO.getResultadoIntegProdutos().addAll(resultadoIntegProdDAT);
			
			
		}

		// Integra opera��es IMC dos produtos acabados
		IntegracaoOperacao integracaoOperacao = new IntegracaoOperacao(daoIdw, daoSempToshiba, omUsr);
		integracaoOperacao.integrarOperacaoIMCDeListaProdutosPlanosProducao(produtosAcabados, produtosSemiAcabados);
//		IntegracaoOperacao.integrarOperacaoIMCDeListaProdutosPlanosProducaoComTransacaoInterna(omUsr, produtosAcabados, produtosSemiAcabados);
		
		
		// Integra produ��o simultanea
		IntegracaoProdutoConjugado integracaoProdutoConjugado = new IntegracaoProdutoConjugado(daoIdw, daoSempToshiba, omUsr);
		integracaoProdutoConjugado.integrarProdutoConjugadoDeListaProdutosPlanosProducao(produtosAcabados, produtosSemiAcabados);
		
		PedidoClienteRN rn = new PedidoClienteRN(daoIdw);
		
		// Alessandre: Antes de mais nada iremos desativar todos os pedidos
		// ativos para poder importar novos registros,
		// isso � importante pq n�o queremos que pedidos que tenham saido do
		// plano continuem nos planos novos, alem disso,
		// os planos devem incluir novamente manualmente os pedidos novos
		// que foram importados		
		rn.desativarTodosOsPedidos();		
		
		// Faz a integra��o dos planos de produ��o do per�odo (m�s-ano)
		for (Iterator<Entry<Date, List<PlanoProducao>>> it = planosProducaoPeriodo.entrySet().iterator(); it.hasNext();) {
		   
			Map.Entry<Date, List<PlanoProducao>> entry = (Map.Entry<Date, List<PlanoProducao>>) it.next();
		   
			Date key = entry.getKey();
			List<PlanoProducao> planosProducao = entry.getValue();
		   
			PpNecListDTO itemPpNecListDTO = integrar(planosProducao, key, usrlogado);
			
					
			ppNecListDTO.getPpNecDTO().addAll(itemPpNecListDTO.getPpNecDTO());
		}
		
		ppNecListDTO.getResultadoDTO().setIdmensagem(ppNecListDTO.getResultadoDTO().getCOM_SUCESSO());
		
		return ppNecListDTO;
		
	}
	
	/**
	 * Realiza a integra��o de todos os itens da lista de plano de produ��o
	 * @param listaPlanoProducao
	 * @param dtReferencia
	 * @param usrlogado
	 * @return
	 */
	private PpNecListDTO integrar(List<APISempToshiba.PlanoProducao> listaPlanoProducao, Date dtReferencia, UsuarioDTO usrlogado){
		PlanoDTO pl = new PlanoDTO();
		pl.setResultadoDTO(new ResultadoDTO());

		PpNecListDTO ppnecList = new PpNecListDTO();
		ppnecList.setDthrInicioGeral(new Date());
		ppnecList.setMesReferencia(DataHoraRN.getApenasMes(dtReferencia));
		ppnecList.setAnoReferencia(DataHoraRN.getApenasAno(dtReferencia));
		ppnecList.setOmusr(usrlogado.getUsuario());

		ppnecList.setDthrIimportacao(new Date());
		ppnecList.setDsErro(null);
		ppnecList.getPpNecDTO().clear();
		
		ppnecList = prepararListPpNecList(listaPlanoProducao, dtReferencia, usrlogado);

		PedidoClienteRN rn = new PedidoClienteRN(daoIdw);

		ppnecList = rn.salvarRegistroIntegracao(ppnecList);
		ppnecList.getResultadoDTO().setIdmensagem(
				pl.getResultadoDTO().getCOM_SUCESSO());


		return ppnecList;
	
	}
	
	private PpNeccronDTO criarPpNeccronDTOComPlanoProducao(PlanoProducao planoProducao){
		PpNeccronDTO neccron = new PpNeccronDTO();
		neccron.setDtDesejada(planoProducao.getDtDesejada());
		neccron.setQtDesejada(planoProducao.getQtDesejada());
		return neccron;
	}
	
	private void criarPpNeccronDTOComPlanoProducaoEAddEmPpNecDTO(PlanoProducao planoProducao, PpNecDTO ppnecDTO){
		PpNeccronDTO neccron = criarPpNeccronDTOComPlanoProducao(planoProducao);
		ppnecDTO.getPlano().add(neccron);
	}
	
	private PpNecDTO criarPpNecDTO(Date dtReferencia, String produtoLido, String cliente, String linha, UsuarioDTO usrlogado){
		PpNecDTO ppnecDTO = new PpNecDTO();

		String cdNec = DataHoraRN.getApenasMes(dtReferencia) + "/" + DataHoraRN.getApenasAno(dtReferencia) + "-" + produtoLido;
		ppnecDTO.setCdNec(cdNec);

		ppnecDTO.setDtRevisao(dtReferencia);

		PpCliente ppcliente = new PpCliente();
		ppcliente.setCdCliente(cliente);
		ppnecDTO.setPpCliente(ppcliente);

		OmProduto produto = new OmProduto();
		produto.setCdProduto(produtoLido);
		produto.setOmUsrByIdUsrrevisao(usrlogado.getUsuario());
		ppnecDTO.setOmProduto(produto);

		ppnecDTO.setOmUsrByIdUsrrevisao(usrlogado.getUsuario());
		ppnecDTO.setOmUsrByIdUsrstativo(usrlogado.getUsuario());

		// Salva o PT
		OmPt ompt = new OmPt();
		ompt.setCdPt(linha);
		ppnecDTO.setOmPt(ompt);
		
		// Tipo necessidade do cliente - 0
		ppnecDTO.setTpNec(0);

		List<PpNeccronDTO> listaPpNecCron = new ArrayList<PpNeccronDTO>();
		ppnecDTO.setPlano(listaPpNecCron);
		
		return ppnecDTO;
	}
	
	private PpNecListDTO prepararListPpNecList(List<APISempToshiba.PlanoProducao> listaPlanoProducao, Date dtReferencia, UsuarioDTO usrlogado){
		PpNecListDTO ppnecList = new PpNecListDTO();
		
		String clientAnt = "";
		String prodAnt = "";
		PpNecDTO ppnecDTO = null;

		for(APISempToshiba.PlanoProducao planoProducao : listaPlanoProducao) {
			
			String cliente = "PCI"; 
			String linha = planoProducao.getCdLinha();
			String produtoLido = planoProducao.getCdProduto();
			
			boolean isMesmoGrupoClienteProduto = clientAnt.equals(cliente) && (prodAnt.equals(produtoLido));
			
			// agrupa necessidade por cliente e c�digo de produto
			if(isMesmoGrupoClienteProduto == false) {

				ppnecDTO = criarPpNecDTO(dtReferencia, produtoLido, cliente, linha, usrlogado);
				
				ppnecList.getPpNecDTO().add(ppnecDTO);
				
				clientAnt = cliente;
				prodAnt = produtoLido;

			}
			
			criarPpNeccronDTOComPlanoProducaoEAddEmPpNecDTO(planoProducao, ppnecDTO);
		
		}
		
		return ppnecList;
	}
	/** 
	 * Guarda os c�digos de produtos que est�o na lista de plano de produ��o
	 * <br> Se plano de produ��o for do tipo PA, adiciona na lista de produtos acabados. Se for DAT, entra na lista de produtos semiacabados
	 * @param produtosAcabados lista que guarda os c�digos de produtos
	 * @param produtosDAT 
	 * @param listaPlanoProducao lista com planos de produ��o
	 */
	private void addListaProdutosAcabadosOuSemiAcabados(Set<String> produtosAcabados, Set<String> produtosDAT, List<APISempToshiba.PlanoProducao> listaPlanoProducao){
		if(listaPlanoProducao != null){
			for(APISempToshiba.PlanoProducao planoProducao: listaPlanoProducao){
				
				if(planoProducao.getTipoProducao().equals(APISempToshiba.TpProducao.DAT.toString())){
					
					produtosDAT.add(planoProducao.getCdProduto());	
				
				}else if(planoProducao.getTipoProducao().equals(APISempToshiba.TpProducao.PA.toString())){

					produtosAcabados.add(planoProducao.getCdProduto());	
				
				}else{
					throw new IllegalStateException("Tipo da produ��o indefido. Tipo Produto = " + planoProducao.getTipoProducao());
				}
								
			}
		}
	}
	
}