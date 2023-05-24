package idw.model.rn.integracao.semptoshiba;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.excessoes.ClienteDesconhecidoException;
import idw.model.excessoes.ItemDentroSubItemReferenciaCircularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroInvalido;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProaltglo;
import idw.model.pojos.OmProduto;
import idw.model.pojos.PpCm;
import idw.model.pojos.PpCmcom;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.model.pojos.template.PpPlanoTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PlanejamentoProducaoRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.integracao.IntegracaoJaRealizadaException;
import idw.util.Util;
import idw.webservices.dto.PlanoDTO;
import idw.webservices.dto.ProdutoDTO;

public class IntegracaoCM  {

	private DAOGenericoErp daoSempToshiba;
	private DAOGenerico daoIdw;
	private final OmCfg omcfg;
	private final Map<String, OmProduto> mapProdutosComEstruturaEAlternativosDosPlanosProducaoAtivos = new HashMap<String, OmProduto>();
	private final Map<String, OmProduto> mapProdutosComEstruturaDosPlanosProducaoAtivos;
	private final IntegracaoEstruturaProduto integracaoEstruturaProduto;
	private final List<String> produtosIntegrados = new ArrayList<String>();
	private final Set<String> cdProdutosAlternativosInvalidos = new HashSet<String>();
	
	public IntegracaoCM(DAOGenerico daoIdw, DAOGenericoErp daoSempToshiba) throws SemPlanejamentoException {
		this.daoSempToshiba = daoSempToshiba;
		this.daoIdw = daoIdw;
		this.omcfg = Util.getConfigGeral(daoIdw.getSession());
		
		
		PlanejamentoProducaoRN planejamentoProducaoRN = new PlanejamentoProducaoRN(this.daoIdw);
		PlanoDTO planoDTO = new PlanoDTO();
		planoDTO.setStPlano(PpPlanoTemplate.TpPlano.CADASTRADO.getId());
		Map<String, OmProduto> listProdutosFinaisDoPlanoProducao = planejamentoProducaoRN.getProdutosFinaisDosPlanosAtivos(planoDTO, false, false, false, true, 5, false);
		
		
		if(listProdutosFinaisDoPlanoProducao.isEmpty()){
			throw new SemPlanejamentoException("Plano de produ��o com situa��o cadastrado, n�o foi encontrado");
		}
		
		ProdutoRN produtoRN = new ProdutoRN(daoIdw);
		List<OmProduto> listProdutosEstruturaDoPlanoProducao = produtoRN.getProdutosComEstruturas(listProdutosFinaisDoPlanoProducao.values(), null);
		this.mapProdutosComEstruturaDosPlanosProducaoAtivos = ProdutoRN.getListaProdutoIndexCdProduto(listProdutosEstruturaDoPlanoProducao);
		this.mapProdutosComEstruturaEAlternativosDosPlanosProducaoAtivos.putAll(mapProdutosComEstruturaDosPlanosProducaoAtivos);
		
		this.integracaoEstruturaProduto = new IntegracaoEstruturaProduto(daoIdw, daoSempToshiba);
		
	}

	public void integrarAlternativoNA() {

		MapQuery uq = new MapQuery(daoIdw.getSession());
		uq.append("delete from PpCmcom");
		uq.query().executeUpdate();

		uq.novaConsulta();
		uq.append("delete from PpCm");
		uq.query().executeUpdate();

		List<APISempToshiba.ItemAlternativoNA> lista = APISempToshiba.SPItemAlternativoNA.getResultado(daoSempToshiba);
		
		for (APISempToshiba.ItemAlternativoNA res : lista) {

			// Obtem o registro
			String numNA;
			String codModelo;
			String posicao;
			String codItemSai;
			String codItemEntra;
			double qtSai;
			double qtEntra;
			String obs;
			Date dtEntra;
			Date dtSai;
			
			numNA = res.getNumNA();
			codModelo = res.getCodModelo();
			posicao = res.getPosicao();
			codItemSai = res.getCodItemSai();
			codItemEntra = res.getCodItemEntra();
			qtSai = res.getQtdSai().doubleValue();
			qtEntra = res.getQtdEntra().doubleValue();
			obs = res.getObs();
			dtEntra = res.getDataEntra();
			dtSai = res.getDataSai();
			

			// Se n�o foi importado, importar
			OmProduto omProdutoByIdProduto = mapProdutosComEstruturaDosPlanosProducaoAtivos.get(codModelo);
			if (omProdutoByIdProduto == null) {
				// 
				continue;
			}

			OmProduto omProdutoByIdProdutosai = null;
			if(StringUtils.isEmpty(codItemSai) == false){
				omProdutoByIdProdutosai = mapProdutosComEstruturaDosPlanosProducaoAtivos.get(codItemSai);
				if(omProdutoByIdProdutosai == null){
					//Produto n�o faz parte do plano de produ��o
					continue;	
				}
				
			}

			
			OmProduto omProdutoByIdProdutoentra = null;
			try {				
				omProdutoByIdProdutoentra = getProdutoAlternativo(codItemEntra, omProdutoByIdProdutosai);
			} catch (RegistroInvalido e) {
				e.printStackTrace();
				continue;
			}
			
			PpCm ppcm = new PpCm();

			ppcm.setCdCm(numNA);
			ppcm.setDsCm("Cadastrado pela Integra��o");
			ppcm.setDthrVigor(dtEntra);
			ppcm.setDthrSai(dtSai);
			ppcm.setDtRevisao(DataHoraRN.getDataHoraAtual());
			ppcm.setDtStativo(DataHoraRN.getDataHoraAtual());
			ppcm.setIdCm(null);
			ppcm.setIsConsumirmp(1);
			ppcm.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
			ppcm.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());
			ppcm.setRevisao(1l);
			ppcm.setStAtivo((byte) 1);

			ppcm.setPpCmcoms(new HashSet<PpCmcom>());

			daoIdw.makePersistent(ppcm);

			PpCmcom ppcmcom = new PpCmcom();
			ppcmcom.setDthrVigor(dtEntra);
			ppcmcom.setDthrSai(dtSai);
			ppcmcom.setIdCmcom(null);
			ppcmcom.setIsConsumirmp(1);
			ppcmcom.setOmProdutoByFinal(omProdutoByIdProduto);
			ppcmcom.setOmProdutoByIdProdutoentra(omProdutoByIdProdutoentra);
			ppcmcom.setOmProdutoByIdProdutosai(omProdutoByIdProdutosai);
			ppcmcom.setPpCm(ppcm);
			ppcmcom.setQtEntra(new BigDecimal(qtEntra));
			ppcmcom.setQtSai(new BigDecimal(qtSai));
			ppcmcom.setObs(obs);
			ppcmcom.setPosicao(posicao);
			
			
			ppcm.getPpCmcoms().add(ppcmcom);

			daoIdw.makePersistent(ppcm);
		}
	}

	public void integrarAlternativoDireto() {
		
		MapQuery qu = new MapQuery(daoIdw.getSession());
		qu.append("delete from OmProaltglo");
		qu.query().executeUpdate();

		List<APISempToshiba.ItemAlternativoDireto> lista = APISempToshiba.SPItemAlternativoDireto.getResultado(daoSempToshiba);
		
		int i = 0;
		for (APISempToshiba.ItemAlternativoDireto res : lista) {
			i++;
			// Obtem o registro
			String codModelo;
			String codItemSai;
			String codItemEntra;
			BigDecimal qt;
			Integer prioridade;
			
			codModelo = res.getCodModelo();
			codItemSai = res.getDe();
			codItemEntra = res.getPara();
			qt = new BigDecimal(res.getFrequencia());
			prioridade = res.getPrioridade();

			// Verifica se o registro ja existe em omproaltglo
			OmProduto omprodutoModelo = mapProdutosComEstruturaDosPlanosProducaoAtivos.get(codModelo);
			if (omprodutoModelo == null) {
				continue;
			}
			
			OmProduto omprodutoSai = mapProdutosComEstruturaDosPlanosProducaoAtivos.get(codItemSai);
			if (omprodutoSai == null) {
				// Produto deveria fazer parte dos produtos relacionados aos itens que comp�em a os produtos do plano
				continue;
			}
			
			OmProduto omprodutoEntrad = null;
			try {
				omprodutoEntrad = getProdutoAlternativo(codItemEntra, omprodutoSai.getTpProduto());
			} catch (RegistroInvalido e) {
				e.printStackTrace();
				continue;
			}
			
			//System.out.println(i);

			OmProaltglo omproalt = new OmProaltglo();
			omproalt.setIdProalt(0l);
			omproalt.setOmProdutoByIdProdutoFilho(omprodutoEntrad);
			omproalt.setOmProdutoByIdProdutoMae(omprodutoSai);
			omproalt.setOmProdutoBySemiacabado(omprodutoModelo);
			omproalt.setQt(qt);
			omproalt.setPrioridade(prioridade);
			
			daoIdw.makePersistent(omproalt);
		}
	}
	
	private OmProduto getProdutoAlternativo(String cdProdutoAlternativo, OmProduto produtoSai) throws RegistroInvalido{
		Byte tpProduto = null;
		if(produtoSai != null){
			tpProduto = produtoSai.getTpProduto();
		}
		
		return getProdutoAlternativo(cdProdutoAlternativo, tpProduto);
		
	}
	
	private OmProduto getProdutoAlternativo(String cdProdutoAlternativo, Byte tpProduto) throws RegistroInvalido{
		
		OmProduto omProdutoByIdProdutoentra = null;
		
		if(StringUtils.isEmpty(cdProdutoAlternativo) == false){
			
			if(cdProdutosAlternativosInvalidos.contains(cdProdutoAlternativo)){
				throw new RegistroInvalido("Produto alternativo n�o foi integrado anteriormente, pois era inv�lido");
			}
			omProdutoByIdProdutoentra = mapProdutosComEstruturaEAlternativosDosPlanosProducaoAtivos.get(cdProdutoAlternativo);
			
			if (omProdutoByIdProdutoentra == null) {

				ProdutoDTO produtoDTO = new ProdutoDTO();
				OmProduto omProdutoParaIntegrar = new OmProduto();
				produtoDTO.setProduto(omProdutoParaIntegrar);
				omProdutoParaIntegrar.setCdProduto(cdProdutoAlternativo);

				if(tpProduto == null){
					tpProduto = OmProdutoTemplate.TpProduto.COMPONENTE.getId();
				}
				omProdutoParaIntegrar.setTpProduto(tpProduto);
				omProdutoParaIntegrar.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
				omProdutoParaIntegrar.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());
				
				try{
					try {
						omProdutoByIdProdutoentra = integracaoEstruturaProduto.integrarProdutoPegandoDadosSempToshiba(
								omProdutoParaIntegrar, produtosIntegrados, mapProdutosComEstruturaEAlternativosDosPlanosProducaoAtivos);
					} catch (ClienteDesconhecidoException e) {
						e.printStackTrace();
						throw new RegistroInvalido(e.getMessage());
					} catch (ItemDentroSubItemReferenciaCircularException e) {
						e.printStackTrace();
						throw new RegistroInvalido(e.getMessage());
					} catch (IntegracaoJaRealizadaException e) {
						e.printStackTrace();
						throw new RegistroInvalido(e.getMessage());
					} catch (RegistroInvalido e) {
						e.printStackTrace();
						throw e;
					} catch (RegistroDesconhecidoException e) {
						e.printStackTrace();
						throw new RegistroInvalido(e.getMessage());
					}
				
				}catch(RegistroInvalido e){
					cdProdutosAlternativosInvalidos.add(cdProdutoAlternativo);
					throw e;
				}
				
			}
			
		}
		
		return omProdutoByIdProdutoentra;
	}
	
	public static void main(String[] args){
		
		DAOGenerico daoIdw = new DAOGenerico();
		DAOGenericoErp daoSempToshiba = new DAOGenericoErp();
		
		try{
			daoIdw.iniciaConexaoBanco();
			daoSempToshiba.iniciaConexaoBanco();

			IntegracaoCM integracao = new IntegracaoCM(daoIdw, daoSempToshiba);
			integracao.integrarAlternativoDireto();
			integracao.integrarAlternativoNA();
		
		}catch(Exception e){
			e.printStackTrace();
			daoIdw.rollBackTransacaoSemException();
			daoSempToshiba.rollBackTransacaoSemException();
			
		}finally{
		
			daoIdw.finalizaConexaoBancoSemException();
			daoSempToshiba.finalizaConexaoBancoSemException();			

		}		

	}
}
