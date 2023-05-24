package idw.model.rn.integracao.semptoshiba;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.exception.SQLGrammarException;

import idw.model.dao.DAOGenerico;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.excessoes.ClienteDesconhecidoException;
import idw.model.excessoes.ItemDentroSubItemReferenciaCircularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroInvalido;
import idw.model.pojos.OmProcomest;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmUnidmedida;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCliente;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.model.rn.ProdutoRN;
import idw.model.rn.integracao.IntegracaoJaRealizadaException;
import idw.webservices.dto.IntegracaoEstruturaDTO;
import idw.webservices.dto.ProdutoDTO;

public final class IntegracaoEstruturaProduto {
	
	/**
	 * Indica se usa a tabela de cliente ou de grupo de produto para a exporta��o do arquivo 
	 * de GRUPOS.txt para a Trilha. 
	 * <br>Atualmente marcado para usar a tabela de clientes.
	 * <br>Aguardando defini��o do Alessandre sobre qual tabela usar 
	 * <br>TODO milton/alessandre
	 */
	public static final boolean USAR_GRUPO_PRODUTO_PELA_TABELA_CLIENTE = true;
	
	public static final String COMPLEMENTO_CD_PRODUTO_DAT = "-DAT";
	public static final int TAMANHO_COMPLEMENTO_CD_PRODUTO_DAT = COMPLEMENTO_CD_PRODUTO_DAT.length();
	
	private final DAOGenerico daoIdw;
	private final DAOGenericoErp daoSempToshiba;
	
	
	
	public IntegracaoEstruturaProduto(DAOGenerico daoIdw, DAOGenericoErp daoSempToshiba){
		this.daoIdw = daoIdw;
		this.daoSempToshiba = daoSempToshiba;
	}

	/**
	 * Faz a integra��o da estrutura de produto, controlando a transa��o internamente
	 * @param produto
	 */
	public static ProdutoDTO integrarProdutoComTransacaoInterna(ProdutoDTO produto, List<String> produtosIntegrados, Map<String, OmProduto> produtosEnvolvidosIntegracaoPersistidos){
		
		ProdutoDTO resultado = new ProdutoDTO();
		resultado.setProduto(produto.getProduto());
		
		final DAOGenerico daoIdw = new DAOGenerico();
		final DAOGenericoErp daoSempToshiba = new DAOGenericoErp();
		
		try{
			daoIdw.iniciaConexaoBanco();
			daoSempToshiba.iniciaConexaoBanco();
			IntegracaoEstruturaProduto integracaoEstruturaProduto = new IntegracaoEstruturaProduto(daoIdw, daoSempToshiba);
			
			resultado = integracaoEstruturaProduto.integrarProdutoDTOPegandoDadosSempToshiba(produto, produtosIntegrados, produtosEnvolvidosIntegracaoPersistidos);
		
		}catch(Exception e){
			e.printStackTrace();
			resultado.setResultadoEvento(resultado.getERRO_DESCONHECIDO());
		}finally{
			if(resultado.getResultadoEvento() != resultado.getEVENTO_BEM_SUCEDIDO()){
				daoIdw.rollBackTransacaoSemException();
				daoSempToshiba.rollBackTransacaoSemException();
			}else{
				daoIdw.finalizaConexaoBanco();
				daoSempToshiba.finalizaConexaoBanco();				
			}
			daoIdw.finalizaSessaoSemException();
			daoSempToshiba.finalizaSessaoSemException();
		}	
		return resultado;
		
	}
	
	public static List<ProdutoDTO> integrarListaProdutosComTransacaoInterna(Set<String> produtos, OmProdutoTemplate.TpProduto tpProduto, boolean isDat, OmUsr omUsr, List<String> produtosIntegrados, Map<String, OmProduto> produtosEnvolvidosIntegracaoPersistidos, boolean isUsarTransacaoCadaProduto){
		
		List<ProdutoDTO> resultadoLista = new ArrayList<ProdutoDTO>();
		ProdutoDTO resultado = new ProdutoDTO();
		final DAOGenerico daoIdw = new DAOGenerico();
		final DAOGenericoErp daoSempToshiba = new DAOGenericoErp();
				
		try{
			daoIdw.iniciaConexaoBanco();
			daoSempToshiba.iniciaConexaoBanco();
			IntegracaoEstruturaProduto integracaoEstruturaProduto = new IntegracaoEstruturaProduto(daoIdw, daoSempToshiba);
			
			resultadoLista = integracaoEstruturaProduto.integrarListaProdutos(produtos, tpProduto, isDat, omUsr, produtosIntegrados, produtosEnvolvidosIntegracaoPersistidos, isUsarTransacaoCadaProduto);
			resultado.setResultadoEvento(resultado.getEVENTO_BEM_SUCEDIDO());
			
		}catch(Exception e){
			e.printStackTrace();			
			resultado.setResultadoEvento(resultado.getERRO_DESCONHECIDO());;
			
		}finally{
			if(resultado.getResultadoEvento() != resultado.getEVENTO_BEM_SUCEDIDO()){
				daoIdw.rollBackTransacaoSemException();
				daoSempToshiba.rollBackTransacaoSemException();
			}else{
				daoIdw.finalizaConexaoBanco();
				daoSempToshiba.finalizaConexaoBanco();				
			}
			daoIdw.finalizaSessaoSemException();
			daoSempToshiba.finalizaSessaoSemException();
		}	
		return resultadoLista;		
	}
	
	/**
	 * Converte tipo de item {@link APISempToshiba.SPEstruturaProduto#TIPO_ORIGEM} para tipo de origem do produto 
	 * @param tipoItem
	 * @return
	 */
	private OmProdutoTemplate.TpOrigem tipoItemParaTpOrigem(String tipoItem){
		
		tipoItem = StringUtils.trimToEmpty(tipoItem);
		
		if(!tipoItem.isEmpty()){
			
			try{
				switch (APISempToshiba.TipoOrigem.valueOf(tipoItem)) {
				case L :
					return OmProdutoTemplate.TpOrigem.LOCAL;
				case N:
					return OmProdutoTemplate.TpOrigem.NACIONAL;
				case I:
					return OmProdutoTemplate.TpOrigem.IMPORTADO;
				}
				
			}catch(IllegalArgumentException e){
				return OmProdutoTemplate.TpOrigem.INDEFINIDO; 
			}
			
		}
		return OmProdutoTemplate.TpOrigem.INDEFINIDO;
	}

	/**
	 * Converte tipo de item {@link EStoreProcedureMapEstruturaProduto#TIPO_SEMI_ACABADO} para {@link OmProdutoTemplate.TpSemiacabado}
	 * @param tipoItem
	 * @return
	 */
	private Byte tipoItemParaTpSemiacabado(String tipoItem){
		
		tipoItem = StringUtils.trimToEmpty(tipoItem);
		
		if(!tipoItem.isEmpty()){
			
			try{
			
				switch (APISempToshiba.TipoSemiAcabado.valueOf(tipoItem)) {
				case I :
					return OmProdutoTemplate.TpSemiacabado.IAC.getId();
				case M:
					return OmProdutoTemplate.TpSemiacabado.IMC.getId();
				}
				
			}catch(IllegalArgumentException e){
				return null; 
			}
			
		}
		return null;
	}

	public static void main(String[] args){
		
		//System.out.println( removerComplementoDatDeCdProduto("518492-DAT"));
		
//		Set<String> produtos = new HashSet<String>();
//		produtos.add("923335");
//		produtos.add("923344");
//		produtos.add("923371");
//		produtos.add("923380");
//		produtos.add("923415");
//		produtos.add("923451");
//		produtos.add("923488");
//		produtos.add("923503");
//		produtos.add("923530");
//		produtos.add("923549");
//		produtos.add("923558");
//		produtos.add("923576");
//		produtos.add("923610");
//		produtos.add("923629");
//		produtos.add("923834");
//		produtos.add("923022");
//		OmUsr omUsr = new OmUsr();
//		omUsr.setId(1L);
//		IntegracaoEstruturaProduto.integrarListaProdutosTransacaoInterna(produtos, TpProduto.PRODUTO_FINAL, omUsr, null, null);
	}
	
	public List<ProdutoDTO> integrarListaProdutos(Set<String> produtos, OmProdutoTemplate.TpProduto tpProduto, boolean isDat, OmUsr omUsr, List<String> produtosIntegrados, Map<String, OmProduto> produtosEnvolvidosIntegracaoPersistidos, boolean isUsarTransacaoCadaProduto){
		
		List<ProdutoDTO> resultado = new ArrayList<ProdutoDTO>();

		if(produtosIntegrados == null){
			produtosIntegrados = new ArrayList<String>();	
		}
		
		
		for(String cdProduto:produtos){
			ProdutoDTO prod = new ProdutoDTO();
			prod.setProduto(new OmProduto());
			
			prod.getProduto().setCdProduto(cdProduto);
			prod.getProduto().setTpProduto(tpProduto.getId());
			prod.getProduto().setOmUsrByIdUsrrevisao(omUsr);
			prod.getProduto().setIsDat(isDat);		
			
			prod.getProduto().setCdProduto(prod.getProduto().getCdProduto());
			
			ProdutoDTO produtoDTO = new ProdutoDTO();
			produtoDTO.setProduto(prod.getProduto());
			try {
				
				if(isUsarTransacaoCadaProduto){
					produtoDTO = integrarProdutoComTransacaoInterna(prod, produtosIntegrados, produtosEnvolvidosIntegracaoPersistidos);
				}else{
					produtoDTO = integrarProdutoDTOPegandoDadosSempToshiba(prod, produtosIntegrados, produtosEnvolvidosIntegracaoPersistidos);
				}
				
			} catch (Exception e){
				e.printStackTrace();
				produtoDTO.setResultadoEvento(produtoDTO.getERRO_DESCONHECIDO());
			}
	
			resultado.add(produtoDTO);	
		
		}
		return resultado;
	}
	
	public static String adicionarComplementoDATEmCdProduto(String cdProduto){
		if(isCdProdutoComComplementoDAT(cdProduto)){
			return cdProduto;
		}
		return cdProduto + COMPLEMENTO_CD_PRODUTO_DAT;
	}
	
	public static String adicionarComplementoDATEmCdProdutoSeForDat(OmProduto omProduto){
		
		String cdProduto = omProduto.getCdProduto();
		
		if(ObjectUtils.defaultIfNull(omProduto.getIsDat(), Boolean.FALSE)){
			cdProduto = adicionarComplementoDATEmCdProduto(cdProduto);
		}
		
		return cdProduto;
		
	}
	
	public static String pegarComplementoDATDeCdProduto(String cdProduto){
		int tamanhoCdProduto = cdProduto.length();
		return StringUtils.mid(cdProduto, tamanhoCdProduto - TAMANHO_COMPLEMENTO_CD_PRODUTO_DAT, TAMANHO_COMPLEMENTO_CD_PRODUTO_DAT);
	}

	public static boolean isCdProdutoComComplementoDAT(String cdProduto){
		return pegarComplementoDATDeCdProduto(cdProduto).equals(COMPLEMENTO_CD_PRODUTO_DAT);
	}		
	
	public static String removerComplementoDatDeCdProduto(String cdProduto){
		String cdProdutoSemComplementoDAT = cdProduto;
				
		if(isCdProdutoComComplementoDAT(cdProduto)){
			cdProdutoSemComplementoDAT = StringUtils.mid(cdProduto, 0, cdProduto.length() - TAMANHO_COMPLEMENTO_CD_PRODUTO_DAT);
		}
		return cdProdutoSemComplementoDAT;
		
	}
	
	private OmProduto criarOmProdutoDeSpGrupo(Object[] registroGrupoProd, byte tpProdutoSugerido, OmUsr omUsr){
		OmProduto omprod = new OmProduto();
		PpCliente ppCliente = new PpCliente();
		OmProgrp omProgrp = new OmProgrp();

		omprod.setCdProduto((String) registroGrupoProd[APISempToshiba.SPGrupo.CD_PRODUTO.getId()]);
		omprod.setTpOrigem(OmProdutoTemplate.TpOrigem.NACIONAL.getId());

		if (IntegracaoEstruturaProduto.USAR_GRUPO_PRODUTO_PELA_TABELA_CLIENTE) {
			// if (registro[1] == null)
			if (registroGrupoProd[APISempToshiba.SPGrupo.CD_GRUPO.getId()] == null) {
				ppCliente.setCdCliente("PCI");
			} else {
				ppCliente.setCdCliente((String) registroGrupoProd[APISempToshiba.SPGrupo.CD_GRUPO.getId()]);
			}
			try {
				ppCliente.setCdCliente(ppCliente.getCdCliente().substring(0, 3));
			} catch (StringIndexOutOfBoundsException e) {
				
			}
			omprod.setPpCliente(ppCliente);
		} else {
			// if (registro[1] == null)
			if (registroGrupoProd[APISempToshiba.SPGrupo.CD_GRUPO.getId()] == null) {
				omProgrp.setCdProgrp("PCI");
			} else {
				omProgrp.setCdProgrp((String) registroGrupoProd[APISempToshiba.SPGrupo.CD_GRUPO.getId()]);
			}

			try {
				omProgrp.setCdProgrp(omProgrp.getCdProgrp().substring(0, 3));
			} catch (StringIndexOutOfBoundsException e) {
				
			}
			omprod.setOmProgrp(omProgrp);
		}

		// omprod.setDsProduto((String) registro[2]);
		omprod.setDsProduto((String) registroGrupoProd[APISempToshiba.SPGrupo.DS_PRODUTO.getId()]);
		omprod.setTpProduto(tpProdutoSugerido);
		omprod.setOmUsrByIdUsrrevisao(omUsr);
		omprod.setOmUsrByIdUsrstativo(omUsr);
		omprod.setRevisao(1l);
		omprod.setStAtivo((byte) 1);
		omprod.setTpProducao(OmProdutoTemplate.TpProducao.NORMAL.getId()); // producao normal

		// Trata unidade de medida
		String cdUnidMedida = (String) registroGrupoProd[APISempToshiba.SPGrupo.UNIDADE_MEDIDA.getId()];
		if (StringUtils.isNotEmpty(cdUnidMedida)) {
			OmUnidmedida omUnidmedida = new OmUnidmedida();
			omUnidmedida.set(cdUnidMedida, cdUnidMedida, (byte) 1);
			omprod.setOmUnidmedida(omUnidmedida);
		}

		if(OmProdutoTemplate.TpProduto.PRODUTO_FINAL.equals(tpProdutoSugerido)){
			omprod.setTpProduto(tpProdutoSugerido);
		}else{
			Integer tpProduto = null;
			if (registroGrupoProd[APISempToshiba.SPGrupo.TP_PRODUTO_2.getId()] instanceof Byte) {
				Byte tpB = (Byte) registroGrupoProd[APISempToshiba.SPGrupo.TP_PRODUTO_2.getId()];
				tpProduto = tpB.intValue();
			} else if (registroGrupoProd[APISempToshiba.SPGrupo.TP_PRODUTO_2.getId()] instanceof Integer) {
				tpProduto = (Integer) registroGrupoProd[APISempToshiba.SPGrupo.TP_PRODUTO_2.getId()];
			}
			
			if(tpProduto == null){
				tpProduto = new Integer(tpProdutoSugerido);
			}else if (tpProduto == APISempToshiba.TpProduto.SEMI_ACABADO.getId()) {
				tpProduto = (int) OmProdutoTemplate.TpProduto.SEMI_ACABADO.getId(); // 3;
		
			// 0 = componente
			} else if (tpProduto == APISempToshiba.TpProduto.COMPONENTE.getId()) {
				tpProduto = (int) OmProdutoTemplate.TpProduto.COMPONENTE.getId(); // 1;
			}
			
			omprod.setTpProduto(tpProduto.byteValue());
		}

		// Valor unit�rio
		if (registroGrupoProd[APISempToshiba.SPGrupo.VALOR_UNITARIO.getId()] instanceof String) {
			omprod.setVlCustounit(new BigDecimal(registroGrupoProd[APISempToshiba.SPGrupo.VALOR_UNITARIO.getId()].toString()));
		} else {
			omprod.setVlCustounit((BigDecimal) registroGrupoProd[APISempToshiba.SPGrupo.VALOR_UNITARIO.getId()]);
		}
		
		// Tipo do item (indicando a origem do produto)
		String tipoItem = (String) registroGrupoProd[APISempToshiba.SPEstruturaProduto.TIPO_ORIGEM.getId()];
		omprod.setTpOrigem(tipoItemParaTpOrigem(tipoItem).getId());

		// Tipo do semiacabado
		String tipoSemiAcabado = String.valueOf(registroGrupoProd[APISempToshiba.SPEstruturaProduto.TIPO_SEMI_ACABADO.getId()]);
		omprod.setTpSemiacabado(tipoItemParaTpSemiacabado(tipoSemiAcabado));
		omprod.setTpClasseabc((byte) 0); // classe a
		
		return omprod;
	}
	
	private IntegracaoEstruturaDTO criarIntegracaoEstruturaDTO(OmProduto omprodutoMP, BigDecimal qtUsada, Integer nivel){
		IntegracaoEstruturaDTO integracaoEstruturaDTO = new IntegracaoEstruturaDTO();
		
		OmProcomest omprocomest = new OmProcomest();
		omprocomest.setOmProdutoByIdProdutomp(omprodutoMP);
		omprocomest.setQtUsada(qtUsada);

		integracaoEstruturaDTO.setProduto(omprocomest);
		integracaoEstruturaDTO.setNivel(nivel);
		
		return integracaoEstruturaDTO;
		
	}
	
	private OmProduto criarOmProdutoParaEstrutra(Object[] registroEstruturaProd, OmUsr omUsr, PpCliente ppCliente, OmProgrp omProgrp){
		
		OmProduto omprodutoMP = new OmProduto();
		omprodutoMP.setCdProduto((String) registroEstruturaProd[APISempToshiba.SPEstruturaProduto.CD_PRODUTO.getId()]);
		omprodutoMP.setDsProduto((String) registroEstruturaProd[APISempToshiba.SPEstruturaProduto.DS_PRODUTO.getId()]);
		omprodutoMP.setIdProduto(0);
		omprodutoMP.setOmUsrByIdUsrrevisao(omUsr);
		if (IntegracaoEstruturaProduto.USAR_GRUPO_PRODUTO_PELA_TABELA_CLIENTE) {
			omprodutoMP.setPpCliente(ppCliente);
		} else {
			omprodutoMP.setOmProgrp(omProgrp);
		}

		omprodutoMP.setRevisao(1l);
		omprodutoMP.setStAtivo((byte) 1);
		omprodutoMP.setTpProducao(OmProdutoTemplate.TpProducao.NORMAL.getId());

		// Integer tpProduto= (Integer) registro2[4];
		System.out.println("tpproduto=" + registroEstruturaProd[APISempToshiba.SPEstruturaProduto.TP_PRODUTO.getId()]);
		Integer tpProduto = 0;
		try {
			tpProduto = (Integer) registroEstruturaProd[APISempToshiba.SPEstruturaProduto.TP_PRODUTO.getId()];
		} catch (ClassCastException e) {
			tpProduto = ((BigDecimal) registroEstruturaProd[APISempToshiba.SPEstruturaProduto.TP_PRODUTO.getId()]).intValue();
		}
		
		// 1 = semica acabado na semp
		if (tpProduto == APISempToshiba.TpProduto.SEMI_ACABADO.getId()) {
			tpProduto = (int) OmProdutoTemplate.TpProduto.SEMI_ACABADO.getId(); // 3;
		
		// 0 = componente
		} else if (tpProduto == APISempToshiba.TpProduto.COMPONENTE.getId()) {
			tpProduto = (int) OmProdutoTemplate.TpProduto.COMPONENTE.getId(); // 1;
		}
		
		/* Na Inventur 1 - matria prima 3 - semiacabado
		if (tpProduto == 1)
			tpProduto = 0;
		else
			tpProduto = 1;
		*/
		omprodutoMP.setTpProduto(tpProduto.byteValue());

		// Trata unidade de medida
		String cdUnidMedida ="";
		try {
			cdUnidMedida = (String) registroEstruturaProd[APISempToshiba.SPEstruturaProduto.UNIDADE_MEDIDA.getId()];
		} catch (ClassCastException e) {
			cdUnidMedida = String.valueOf(((Integer) registroEstruturaProd[APISempToshiba.SPEstruturaProduto.UNIDADE_MEDIDA.getId()]));
		}
		if (StringUtils.isNotEmpty(cdUnidMedida)) {
			OmUnidmedida omUnidmedida = new OmUnidmedida();
			omUnidmedida.set(cdUnidMedida, cdUnidMedida, (byte) 1);
			omprodutoMP.setOmUnidmedida(omUnidmedida);
		}

		// Valor unit�rio
		if (registroEstruturaProd[APISempToshiba.SPEstruturaProduto.VALOR_UNITARIO.getId()] instanceof Double) {
			Double vl = (Double) registroEstruturaProd[APISempToshiba.SPEstruturaProduto.VALOR_UNITARIO.getId()];
			omprodutoMP.setVlCustounit(new BigDecimal(vl));
		} else
			try {
				omprodutoMP.setVlCustounit((BigDecimal) registroEstruturaProd[APISempToshiba.SPEstruturaProduto.VALOR_UNITARIO.getId()]);
			} catch (ClassCastException e) {
				omprodutoMP.setVlCustounit(new BigDecimal((Integer) registroEstruturaProd[APISempToshiba.SPEstruturaProduto.VALOR_UNITARIO.getId()]));
			}

		// Tipo do item (indicando a origem do produto)
		String tipoItem;
		if (registroEstruturaProd[APISempToshiba.SPEstruturaProduto.TIPO_ORIGEM.getId()] instanceof Integer) {
			Integer vl = (Integer) registroEstruturaProd[APISempToshiba.SPEstruturaProduto.TIPO_ORIGEM.getId()];
			tipoItem = vl.toString();
		} else
			tipoItem = (String) registroEstruturaProd[APISempToshiba.SPEstruturaProduto.TIPO_ORIGEM.getId()];
		omprodutoMP.setTpOrigem(tipoItemParaTpOrigem(tipoItem).getId());

		// Tipo do semiacabado
		String tipoSemiAcabado = String.valueOf(registroEstruturaProd[APISempToshiba.SPEstruturaProduto.TIPO_SEMI_ACABADO.getId()]);
		omprodutoMP.setTpSemiacabado(tipoItemParaTpSemiacabado(tipoSemiAcabado));
		omprodutoMP.setTpClasseabc((byte) 0);
		
		return omprodutoMP;
		
	}


	/**
	 * 
	 * @param produtoParaIntegrar
	 * @param produtosIntegrados
	 * @return 
	 */
	public ProdutoDTO integrarProdutoDTOPegandoDadosSempToshiba(ProdutoDTO produtoParaIntegrar, List<String> produtosIntegrados, Map<String, OmProduto> produtosEnvolvidosIntegracaoPersistidos) {
		ProdutoDTO produtoRetorno = new ProdutoDTO();
		produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_DESCONHECIDO());
		produtoRetorno.setProduto(produtoParaIntegrar.getProduto());
		
		try {
			
			final OmProduto omProdutoIntegrado = integrarProdutoPegandoDadosSempToshiba(produtoParaIntegrar.getProduto(), produtosIntegrados, produtosEnvolvidosIntegracaoPersistidos);
				
			produtoRetorno.setProduto(omProdutoIntegrado.clone());
			
			produtoRetorno.setResultadoEvento(produtoRetorno.getEVENTO_BEM_SUCEDIDO());


		} catch (ClienteDesconhecidoException e) {
			produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_CLIENTE_DESCONHECIDO());
		} catch (ItemDentroSubItemReferenciaCircularException e) {
			produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_ITEM_DENTRO_DE_SEU_SUBITEM());
		} catch(IntegracaoJaRealizadaException e){
			produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_INTEGRACAO_JA_REALIZADA());
		} catch(RegistroInvalido e){
			produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_CDPRODUTO_INVALIDO());			
		} catch (Exception e) {
			e.printStackTrace();
			produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_DESCONHECIDO());
		}

		return produtoRetorno;

	}
	
	public OmProduto integrarProdutoPegandoDadosSempToshiba(OmProduto produtoParaIntegrar, List<String> produtosIntegrados, Map<String, OmProduto> produtosEnvolvidosIntegracaoPersistidos) throws ClienteDesconhecidoException, ItemDentroSubItemReferenciaCircularException, IntegracaoJaRealizadaException, RegistroInvalido, RegistroDesconhecidoException {
		
		boolean isProdutoDat = ObjectUtils.defaultIfNull(produtoParaIntegrar.getIsDat(), Boolean.FALSE);
		
		String cdProdutoSemComplementoDatSeForDat = produtoParaIntegrar.getCdProduto(); 
		String cdProdutoComComplementoDatSeForDat = cdProdutoSemComplementoDatSeForDat;
				
		Byte tpProdutoParadaConsultaErpSempToshiba = produtoParaIntegrar.getTpProduto();
		
		if(isProdutoDat){
			cdProdutoSemComplementoDatSeForDat = removerComplementoDatDeCdProduto(produtoParaIntegrar.getCdProduto());
			cdProdutoComComplementoDatSeForDat = adicionarComplementoDATEmCdProduto(cdProdutoSemComplementoDatSeForDat);
			tpProdutoParadaConsultaErpSempToshiba = OmProdutoTemplate.TpProduto.SEMI_ACABADO.getId();
		}
		
		String cdProdutoParaConsultaERPSempToshiba = cdProdutoSemComplementoDatSeForDat;
		
			
		// Avalia se registro j� foi integrado
		if(produtosIntegrados != null){
			
			if(produtosIntegrados.contains(produtoParaIntegrar.getCdProduto())){
				throw new IntegracaoJaRealizadaException(new StringBuilder("Produto ").append(produtoParaIntegrar.getCdProduto()).append("j� foi integrado").toString());
			}
		}else{
			produtosIntegrados = new ArrayList<String>();
		}
		

		OmProduto omprod = new OmProduto();

		// Pega os grupos de produtos

		Query resul = APISempToshiba.SPGrupo.getQuery(
				this.daoSempToshiba, cdProdutoParaConsultaERPSempToshiba, tpProdutoParadaConsultaErpSempToshiba.toString());

		Iterator res = null;
		
		try {
			res = resul.list().iterator();
		} catch (SQLGrammarException e) {
			res = null;
		}

		if (res != null && res.hasNext()== false) {
			throw new RegistroInvalido("Codigo de produto " + cdProdutoParaConsultaERPSempToshiba + " nao esta disponivel para integracao. N�o encontrado em spc_MAPCliente");
			
		}else{
			Object[] registroGrupoProd = {cdProdutoParaConsultaERPSempToshiba, "", "", "", "", tpProdutoParadaConsultaErpSempToshiba, "", "", "0"};
			
			if (res != null) {
				registroGrupoProd = (Object[]) res.next();
//						CD_PRODUTO(0),
						/** C�digo do grupo */
//						CD_GRUPO(1),
						/** Descri��o do produto */
//						DS_PRODUTO(2),
						/** Tipo do produto. Atualmente em desuso. Est� retornando o tipo produto que � passado para a SP */
//						TP_PRODUTO_OBSOLETO_NAO_USAR(3),
						/** Unidade medida TODO tratar campo*/
//						UNIDADE_MEDIDA(4),
						/** Tipo do produto  {@link TpProduto} */
//						TP_PRODUTO_2(5),
						/** Tipo semiacabado {@link TipoSemiAcabado} */
//						TP_SEMIACABADO(6),
						/** Tipo Origem {@link TipoOrigem}*/
//						TP_ORIGEM(7),		
//						VALOR_UNITARIO(8)
			}
			
			// Lista para baixar todos os produtos envolvidos na opera��o, no cache;
			final Set<String> cdProdutos = new HashSet<String>();
			
			List<IntegracaoEstruturaDTO> estruturaProcedure = new ArrayList<IntegracaoEstruturaDTO>();				
			int nivelAdicionalQuandoTemDat = 0;
			
			omprod = criarOmProdutoDeSpGrupo(registroGrupoProd, produtoParaIntegrar.getTpProduto(), produtoParaIntegrar.getOmUsrByIdUsrrevisao());
			
			if(isProdutoDat){
				
				OmProduto omprodMP = omprod.clone(true);					
				omprodMP.setCdProduto(cdProdutoSemComplementoDatSeForDat);
				omprodMP.setTpProduto(OmProdutoTemplate.TpProduto.SEMI_ACABADO.getId());
				
				omprod.setCdProduto(cdProdutoComComplementoDatSeForDat);
				omprod.setTpProduto(produtoParaIntegrar.getTpProduto());
				omprod.setIsDat(true);
				
				IntegracaoEstruturaDTO integ = criarIntegracaoEstruturaDTO(omprodMP, BigDecimal.ONE, 1);					
				estruturaProcedure.add(integ);
				
				nivelAdicionalQuandoTemDat = 1;
				
				cdProdutos.add(omprodMP.getCdProduto());
				
			}
			
			for (IntegracaoEstruturaDTO dto : estruturaProcedure) {
				System.out.println("nivel=" + dto.getNivel() + " estprod " + dto.getProduto().getQtUsada());
			}
			

			cdProdutos.add(omprod.getCdProduto());
			
			Query cstmt = APISempToshiba.SPEstruturaProduto.getQuery(
					this.daoSempToshiba, cdProdutoParaConsultaERPSempToshiba);
			
			Iterator rs = cstmt.list().iterator();
			

			while (rs.hasNext()) {
				Object[] registroEstruturaProd = (Object[]) rs.next();
				

				OmProduto omprodutoMP = criarOmProdutoParaEstrutra(registroEstruturaProd, omprod.getOmUsrByIdUsrrevisao(), omprod.getPpCliente(), omprod.getOmProgrp());
				
				System.out.println("qtusada=" + registroEstruturaProd[APISempToshiba.SPEstruturaProduto.QT_USADA.getId()]);
				BigDecimal qtUsada = BigDecimal.ZERO;
				qtUsada = (BigDecimal) registroEstruturaProd[APISempToshiba.SPEstruturaProduto.QT_USADA.getId()];
				Integer nivel;
				if (registroEstruturaProd[APISempToshiba.SPEstruturaProduto.NIVEL.getId()] instanceof String) {
					String vl = registroEstruturaProd[APISempToshiba.SPEstruturaProduto.NIVEL.getId()].toString();
					nivel = Integer.valueOf(vl);
				} else
					nivel = (Integer) registroEstruturaProd[APISempToshiba.SPEstruturaProduto.NIVEL.getId()];

				// Quando � integra��o de DAT, � gerado um nivel a mais no in�cio da estrutura no IDW. 
				// Na estrutra do ERP da Semp Toshiba n�o tem este n�vel
				nivel += nivelAdicionalQuandoTemDat;

				
				IntegracaoEstruturaDTO integ = criarIntegracaoEstruturaDTO(omprodutoMP, qtUsada, nivel);
				
				estruturaProcedure.add(integ);
				
				// S� guarda os produtos que ainda n�o foram integrados
				if(produtosIntegrados.contains(omprodutoMP.getCdProduto()) == false){
					cdProdutos.add(omprodutoMP.getCdProduto());	
				}
				
			}
			
			
			percorreLista(omprod, 1, estruturaProcedure, 0);
			

			final ProdutoRN produtorn = new ProdutoRN(daoIdw);
			
			final List<OmProduto> produtosEnvolvidosIntegracao = new ArrayList<OmProduto>(); 
			try{
				// Consulta para guardar todos os produtos no cache do hibernate (diminuindo o hit com o banco de dados).
				// Produtos j� integrados (vari�vel produtosIntegrados), n�o entrar�o nesta lista
				produtosEnvolvidosIntegracao.addAll(produtorn.getOmProdutos(cdProdutos, true, true));
				
			}catch(RegistroDesconhecidoException e){
				// Indica que todos os produtos s�o novos
			}
			
			// Lista de produtosEnvolvidosIntegracao indexado pelo cdProduto
			if(produtosEnvolvidosIntegracaoPersistidos == null){
				produtosEnvolvidosIntegracaoPersistidos = new HashMap<String, OmProduto>();
			}
			
			// Lista dos ids de produtos que ser�o apagados
			final List<Long> idsProdutosParaApagarEstrutura = new ArrayList<Long>();
			
			for(OmProduto omProduto: produtosEnvolvidosIntegracao){
				
				produtosEnvolvidosIntegracaoPersistidos.put(omProduto.getCdProduto(), omProduto);
			
				// S� ser�o apagadas as estruturas que ainda n�o foram integradas
				if(produtosIntegrados.contains(omProduto.getCdProduto()) == false){
					idsProdutosParaApagarEstrutura.add(omProduto.getIdProduto());
				}
			
			}
			
			// Apaga a estrutura de todos os produtos envolvidos que est�o persistidos e que ainda n�o foram integrados
			produtorn.apagarEstruturasProdutos(idsProdutosParaApagarEstrutura);
			
			final OmProduto omProdutoIntegrado = produtorn.integrarProduto(omprod, produtosIntegrados, produtosEnvolvidosIntegracaoPersistidos, false);
			
			return omProdutoIntegrado;

		}
		
	}

	private int percorreLista(OmProduto omprod, int nivel, List<IntegracaoEstruturaDTO> estruturaProcedure, int index){
		int ant = 0;
		int i = index;
		
		// se o produto for uma materia-prima e possuir estrutura entao transforma-lo em agrupador (fantasma)
		if (omprod.getTpProduto() != null && omprod.getTpProduto().equals(OmProdutoTemplate.TpProduto.COMPONENTE.getId()) && estruturaProcedure.isEmpty() == false) {
			omprod.setTpProduto(OmProdutoTemplate.TpProduto.AGRUPADOR.getId());
		}
		
		while(i < estruturaProcedure.size()){
			if (estruturaProcedure.get(i).getNivel() == nivel) {				
				omprod.getOmProcomestsForIdProduto().add(estruturaProcedure.get(i).getProduto());
			}else{
			  if (estruturaProcedure.get(i).getNivel() < nivel) {
				  i--;
				  return i;
			  }
			  i = percorreLista(estruturaProcedure.get(ant).getProduto().getOmProdutoByIdProdutomp(), estruturaProcedure.get(i).getNivel(), estruturaProcedure, i);
			}
			ant = i;
			i++;
			
		}
		i--;
		return i;
	}
	

}
