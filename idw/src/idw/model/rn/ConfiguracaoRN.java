package idw.model.rn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwCalDAO;
import idw.model.dao.DwEstDAO;
import idw.model.dao.DwEstlocalDAO;
import idw.model.dao.DwFtParamDAO;
import idw.model.dao.DwPeproDAO;
import idw.model.dao.DwTParadaDAO;
import idw.model.dao.MapQuery;
import idw.model.dao.OmCcDAO;
import idw.model.dao.OmCfgDAO;
import idw.model.dao.OmGtDAO;
import idw.model.dao.OmProdutoDAO;
import idw.model.dao.OmPtDAO;
import idw.model.dao.OmResguiDAO;
import idw.model.dao.OmTpgtDAO;
import idw.model.dao.OmTpptDAO;
import idw.model.dao.OmUsrDAO;
import idw.model.dao.OmUsrgrpDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstlocal;
import idw.model.pojos.DwFtParam;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwTAlerta;
import idw.model.pojos.DwTParada;
import idw.model.pojos.DwTRefugo;
import idw.model.pojos.DwTRitmo;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgabc;
import idw.model.pojos.OmCfgind;
import idw.model.pojos.OmCfgptdetcoleta;
import idw.model.pojos.OmCfgscrpimp;
import idw.model.pojos.OmCfgurl;
import idw.model.pojos.OmEmpresa;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmRegrasNscb;
import idw.model.pojos.OmResgui;
import idw.model.pojos.OmTpgt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.OmUsrgrp;
import idw.model.rn.classificacaoabc.ClassificacaoABCRN;
import idw.webservices.dto.ConfiguracaoDTO;
import idw.webservices.dto.ConfiguracoesDTO;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.dto.ProdutosDTO;

public class ConfiguracaoRN extends DAOGenerico {

	public ConfiguracaoRN newSession(Session session) {
		this.setSession(session);
		return this;
	}

	/** PEGA CONFIGURACAO ATIVA */
	public OmCfg getConfiguracao() {
		ConfiguracaoDTO filtro = new ConfiguracaoDTO();
		filtro.setConfiguracao(new OmCfg());
		filtro.getConfiguracao().setStAtivo((byte) 1);
		return getConfiguracao(filtro);
	}

	/**
	 * RETORNA APENAS A PRIMEIRA LINHA DE CONFIGURAÇÃO ENCONTRADA
	 * 
	 * @param filtro
	 * @return
	 */
	public OmCfg getConfiguracao(ConfiguracaoDTO filtro) {
		ConfiguracoesDTO configuracoesDTO = getConfiguracoesDTO(filtro);
		if (configuracoesDTO != null
				&& configuracoesDTO.getConfiguracoes() != null
				&& configuracoesDTO.getConfiguracoes().size() > 0) {
			return configuracoesDTO.getConfiguracoes().get(0).getConfiguracao();
		}
		return null;
	}

	public ConfiguracoesDTO getConfiguracoesDTO(ConfiguracaoDTO filtro) {

		filtro.getConfiguracao().setIsLogonobrigatorio(null);
		filtro.getConfiguracao().setIsNivelfeeder(null);
		filtro.getConfiguracao().setIsIhmtrocaop(null);
		filtro.getConfiguracao().setIsRequerTecnicoFimCip(null);
		filtro.getConfiguracao().setIsRequerTecnicoInicioCip(null);
		filtro.getConfiguracao().setIsImpMapaQtUnica(null);
		filtro.getConfiguracao().setLogin(null);
		filtro.getConfiguracao().setSenha(null);
		filtro.getConfiguracao().setEmailsscriptpadraonc(null);
		filtro.getConfiguracao().setEmailaoi(null);
		filtro.getConfiguracao().setIdWhatsapp(null);
		filtro.getConfiguracao().setPwWhatsapp(null);
		filtro.getConfiguracao().setTpWhatsapp(null);
		filtro.getConfiguracao().setTelWhatsapp(null);
		filtro.getConfiguracao().setIsLogoutautomatico(null);
		filtro.getConfiguracao().setSegLogoutautomatico(null);
		
		List<OmCfg> lista = findByExample(OmCfg.class, filtro.getConfiguracao());
		List<ConfiguracaoDTO> configuracoes = new ArrayList<ConfiguracaoDTO>();

		ConfiguracoesDTO retorno = new ConfiguracoesDTO();
		retorno.setProdutosSemConsumo(new ProdutosDTO());
		retorno.getProdutosSemConsumo().setProdutos(new ArrayList<ProdutoDTO>());

		OmProdutoDAO produtoDAO = new OmProdutoDAO(getSession());
		List<OmProduto> listaProdutosSemConsumo = produtoDAO.getProdutosSemConsumo();
		for (OmProduto produto : listaProdutosSemConsumo) {
			ProdutoDTO produtoDTO = new ProdutoDTO();
			produtoDTO.setProduto(produto.clone(false));
			retorno.getProdutosSemConsumo().getProdutos().add(produtoDTO);
		}

		for (OmCfg omcfg : lista) {
			ConfiguracaoDTO configuracao = new ConfiguracaoDTO();
			configuracao.setConfiguracao(omcfg.clone());
			Set<OmCfgptdetcoleta> omCfgptdetcoletas = new HashSet<OmCfgptdetcoleta>();
			for (OmCfgptdetcoleta omCfgpt : omcfg.getOmCfgptdetcoletas()) {
				omCfgptdetcoletas.add((OmCfgptdetcoleta) omCfgpt.clone());
			}
			configuracao.getConfiguracao().setOmCfgptdetcoletas(
					omCfgptdetcoletas);

			Set<OmCfgind> omCfginds = new HashSet<OmCfgind>();
			for (OmCfgind omCfgind : omcfg.getOmCfginds()) {
				omCfginds.add((OmCfgind) omCfgind.clone());
			}

			Set<OmCfgurl> omCfgurls = new HashSet<OmCfgurl>();
			for (OmCfgurl omCfgurl : omcfg.getOmCfgurls()) {
				omCfgurls.add((OmCfgurl) omCfgurl.clone());
			}

			Set<OmCfgscrpimp> omCfgscrpimp = new HashSet<OmCfgscrpimp>();
			for (OmCfgscrpimp ax : omcfg.getOmCfgscrpimps()) {
				omCfgscrpimp.add((OmCfgscrpimp) ax.clone());
			}
			
			// Clone empresa tb se existir
			if (omcfg.getOmEmpresa() != null)
				configuracao.getConfiguracao().setOmEmpresa(omcfg.getOmEmpresa().clone());
			configuracao.getConfiguracao().setOmCfginds(omCfginds);
			configuracao.getConfiguracao().setOmCfgurls(omCfgurls);
			configuracao.getConfiguracao().setOmCfgscrpimps(omCfgscrpimp);
			configuracoes.add(configuracao);
		}
		retorno.getResultado().setIdmensagem(retorno.getResultado().COM_SUCESSO);
		retorno.setConfiguracoes(configuracoes);
		return retorno;
	}

	public ConfiguracaoDTO setConfiguracaoDTO(ConfiguracaoDTO configuracao) {

		ConfiguracaoDTO configuracaoRetorno = new ConfiguracaoDTO();
		configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().COM_SUCESSO);

		OmCfgDAO cfgDAO = new OmCfgDAO(getSession());

		OmCfg omcfgAnterior = cfgDAO.getConfigGeral();
		if(omcfgAnterior == null) {
			omcfgAnterior = cfgDAO.getUltimaConfigGeralAtiva();
		}

		OmCfg omcfgNovo = configuracao.getConfiguracao().clone();
		omcfgNovo.setIsRitmosempreNasHrsprod(omcfgAnterior.getIsRitmosempreNasHrsprod());

		// LIMPA OS IDS DOS POJOS ENVOLVIDOS AFIM DE INCLUIR NOVOS REGISTROS,
		// DEIXANDO OS ANTERIORES PARA O REGISTRO ANTIGO
		omcfgNovo.setIdCfg(0l);
		omcfgNovo.setOmCfgptdetcoletas(new HashSet<OmCfgptdetcoleta>());
		for (OmCfgptdetcoleta oc : configuracao.getConfiguracao().getOmCfgptdetcoletas()) {
			oc.setIdCfgptdetcoleta(0l);
			omcfgNovo.getOmCfgptdetcoletas().add(oc.clone());
		}
		omcfgNovo.setOmCfginds(new HashSet<OmCfgind>());
		for (OmCfgind omcfgind : configuracao.getConfiguracao().getOmCfginds()) {
			omcfgNovo.getOmCfginds().add(omcfgind.clone());
		}

		omcfgNovo.setOmCfgurls(new HashSet<OmCfgurl>());
		for (OmCfgurl cfgurl : configuracao.getConfiguracao().getOmCfgurls()) {
			System.out.println("URLS 1: " + cfgurl.getIdCfgurl());
			omcfgNovo.getOmCfgurls().add(cfgurl.clone());

		}
		omcfgNovo.setOmCfgscrpimps(new HashSet<OmCfgscrpimp>());

		for (OmCfgscrpimp sp : configuracao.getConfiguracao().getOmCfgscrpimps()) {
			omcfgNovo.getOmCfgscrpimps().add((OmCfgscrpimp) sp.clone());
		}

		verificaIntegridadeEInstanciaFKs(omcfgNovo, configuracao,
				configuracaoRetorno);

		// SALVA A CONFIGURACAO
		if (configuracaoRetorno.getResultado().getIdmensagem() == configuracaoRetorno
				.getResultado().COM_SUCESSO) {

			guardarDadosDeOmCfgAntigaNaNovaVersao(omcfgAnterior, omcfgNovo);
			
			
			inclusaoDescartandoOriginal(omcfgAnterior,
					omcfgNovo.getOmUsrByIdUsrrevisao(), omcfgNovo);
			
			// PREPARA DTO DE RETORNO
			configuracaoRetorno.setConfiguracao((OmCfg) omcfgNovo.clone());
			Set<OmCfgptdetcoleta> omCfgptdetcoletas = new HashSet<OmCfgptdetcoleta>();
			for (OmCfgptdetcoleta omCfgpt : omcfgNovo.getOmCfgptdetcoletas()) {
				omCfgptdetcoletas.add((OmCfgptdetcoleta) omCfgpt.clone());
			}
			configuracaoRetorno.getConfiguracao().setOmCfgptdetcoletas(omCfgptdetcoletas);

			Set<OmCfgind> omCfginds = new HashSet<OmCfgind>();
			for (OmCfgind omCfgind : omcfgNovo.getOmCfginds()) {
				omCfginds.add((OmCfgind) omCfgind.clone());
			}
			configuracaoRetorno.getConfiguracao().setOmCfginds(omCfginds);

			Set<OmCfgurl> omCfgurls = new HashSet<OmCfgurl>();
			for (OmCfgurl cfgUrl : omcfgNovo.getOmCfgurls()) {
				omCfgurls.add((OmCfgurl) cfgUrl.clone());
			}
			configuracaoRetorno.getConfiguracao().setOmCfgurls(omCfgurls);

			Set<OmCfgscrpimp> omScrsps = new HashSet<OmCfgscrpimp>();

			for (OmCfgscrpimp sp : omcfgNovo.getOmCfgscrpimps()) {
				omScrsps.add((OmCfgscrpimp) sp.clone());

			}
			configuracaoRetorno.getConfiguracao().setOmCfgscrpimps(omScrsps);

		}

		return configuracaoRetorno;
	}

	private void guardarDadosDeOmCfgAntigaNaNovaVersao(OmCfg omcfgAnterior,
			OmCfg omcfgNovo) {
		// GUARDA ALGUNS VALORES DO POJO ANTERIOR NA NOVA VERSÃO
		if (omcfgAnterior != null) {
			if (omcfgAnterior.getDthrEstliberado() != null) {
				omcfgNovo
						.setDthrEstliberado(omcfgAnterior.getDthrEstliberado());
			}
		}
	}

	public ConfiguracoesDTO removeConfiguracoesDTO(
			ConfiguracoesDTO configuracoes) {

		List<ConfiguracaoDTO> listaRetorno = new ArrayList<ConfiguracaoDTO>();
		if (configuracoes.getConfiguracoes() == null) {
			ConfiguracaoDTO configuracaoRetorno = new ConfiguracaoDTO();
			configuracaoRetorno.getResultado().setIdmensagem(
					configuracaoRetorno.getResultado()
							.getCONFIGURACAO_DESCONHECIDA());
		} else {
			for (ConfiguracaoDTO configuracao : configuracoes
					.getConfiguracoes()) {
				ConfiguracaoDTO configuracaoRetorno = new ConfiguracaoDTO();

				OmCfgDAO cfgDAO = new OmCfgDAO(getSession());
				OmCfg omcfg = cfgDAO.getOmCfgPorId(configuracao
						.getConfiguracao().getIdCfg());

				if (omcfg == null) {
					configuracaoRetorno.getResultado().setIdmensagem(
							configuracaoRetorno.getResultado()
									.getCONFIGURACAO_DESCONHECIDA());
					configuracaoRetorno.setConfiguracao(configuracao
							.getConfiguracao());
				} else if ((omcfg.getOmCfgptdetcoletas() != null && omcfg
						.getOmCfgptdetcoletas().size() > 0)
						|| (omcfg.getOmCfgscrpimps() != null && omcfg
								.getOmCfgscrpimps().size() > 0)) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().ERRO_CONFIGURACAO_SENDO_USADA);
					configuracaoRetorno.setConfiguracao(configuracao
							.getConfiguracao());
				} else {
					configuracaoRetorno.setConfiguracao(omcfg.clone());
					try {
						getSession().delete(omcfg);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				listaRetorno.add(configuracaoRetorno);

			}
		}
		ConfiguracoesDTO configuracoesRetorno = new ConfiguracoesDTO();
		configuracoesRetorno.setConfiguracoes(listaRetorno);
		configuracoesRetorno.getResultado().setIdmensagem(
				configuracoesRetorno.getResultado().COM_SUCESSO);
		return configuracoesRetorno;
	}

	private void verificaIntegridadeEInstanciaFKs(OmCfg omcfgOriginal,
			ConfiguracaoDTO configuracao, ConfiguracaoDTO configuracaoRetorno) {

		OmUsrDAO usrDAO = new OmUsrDAO(getSession());
		DwEstDAO estDAO = new DwEstDAO(getSession());
		DwPeproDAO peproDAO = new DwPeproDAO(getSession());
		DwFtParamDAO ftparamDAO = new DwFtParamDAO(getSession());
		OmTpgtDAO tpgtDAO = new OmTpgtDAO(getSession());
		OmTpptDAO tpptDAO = new OmTpptDAO(getSession());
		OmUsrgrpDAO usrgrpDAO = new OmUsrgrpDAO(getSession());
		DwTParadaDAO tparadaDAO = new DwTParadaDAO(getSession());
		AlertaRN alertaRN = new AlertaRN(getDao());

		if (!configuracao.getConfiguracao().getDwTRitmo().getCdTritmo()
				.equals("")) {
			try {
				RitmoRN ritmoRN = new RitmoRN(this);
				DwTRitmo ritmo = ritmoRN
						.getDwTRitmoPorCdAtivoOrderById(configuracao
								.getConfiguracao().getDwTRitmo().getCdTritmo());
				omcfgOriginal.setDwTRitmo(ritmo);
				if (ritmo == null) {
					configuracaoRetorno.getResultado().setIdmensagem(
							configuracaoRetorno.getResultado().RITMO_INVALIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno.getResultado().setIdmensagem(
						configuracaoRetorno.getResultado().RITMO_INVALIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setDwTRitmo(null);
		}

		if (!configuracao.getConfiguracao().getOmEmpresa().getCdEmpresa()
				.equals("")) {
			try {
				EmpresaRN empresaRN = new EmpresaRN(this);
				OmEmpresa empresa = empresaRN.getOmEmpresa(configuracao
						.getConfiguracao().getOmEmpresa().getCdEmpresa());
				omcfgOriginal.setOmEmpresa(empresa);
				if (empresa == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().EMPRESA_INVALIDA);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno.getResultado().setIdmensagem(
						configuracaoRetorno.getResultado().EMPRESA_INVALIDA);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setOmEmpresa(null);
		}

		try {
			ClassificacaoABCRN classificacaoRN = new ClassificacaoABCRN(this);
			OmCfgabc abc = classificacaoRN
					.getOmCfgabcPorCdAtivoOrderByCd(configuracao
							.getConfiguracao().getOmCfgabc().getCdCfgabc());
			omcfgOriginal.setOmCfgabc(abc);
			if (abc == null) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().CLASSIFICACAOABC_INVALIDO);
				return;
			}
		} catch (Exception e) {
			configuracaoRetorno
					.getResultado()
					.setIdmensagem(
							configuracaoRetorno.getResultado().CLASSIFICACAOABC_INVALIDO);
			e.printStackTrace();
			return;
		}

		try {
			DwPepro item = peproDAO.getDwPeproPorId(configuracao
					.getConfiguracao().getDwPeproByIdPeproctreproc()
					.getIdPepro());
			omcfgOriginal.setDwPeproByIdPeproctreproc(item);
			if (item == null) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().ERRO_PEPRO_DESCONHECIDO);
				return;
			}
		} catch (Exception e) {
			configuracaoRetorno.getResultado().setIdmensagem(
					configuracaoRetorno.getResultado().ERRO_PEPRO_DESCONHECIDO);
			e.printStackTrace();
			return;
		}

		try {
			DwCalDAO calDAO = new DwCalDAO(getSession());
			DwCal dwcal = calDAO.getDwCalPorCdAtivo(configuracao
					.getConfiguracao().getDwCal().getCdCal());
			omcfgOriginal.setDwCal(dwcal);
			if (dwcal == null) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().ERROR_SEM_CALENDARIO);
				return;
			}
		} catch (Exception e) {
			configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().ERROR_SEM_CALENDARIO);
			e.printStackTrace();
			return;
		}

		try {
			DwPepro item = peproDAO
					.getDwPeproPorId(configuracao.getConfiguracao()
							.getDwPeproByIdPepronormal().getIdPepro());
			omcfgOriginal.setDwPeproByIdPepronormal(item);
			if (item == null) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().ERRO_PEPRO_DESCONHECIDO);
				return;
			}
		} catch (Exception e) {
			configuracaoRetorno.getResultado().setIdmensagem(
					configuracaoRetorno.getResultado().ERRO_PEPRO_DESCONHECIDO);
			e.printStackTrace();
			return;
		}

		try {
			OmUsr item = usrDAO.getOmUsrPorCdAtivoOrderById(configuracao
					.getConfiguracao().getOmUsrimpprog().getCdUsr());
			omcfgOriginal.setOmUsrimpprog(item);
			if (item == null) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().USUARIO_DESCONHECIDO);
				return;
			}
		} catch (Exception e) {
			configuracaoRetorno.getResultado().setIdmensagem(
					configuracaoRetorno.getResultado().USUARIO_DESCONHECIDO);
			e.printStackTrace();
			return;
		}
		
		if(configuracao.getConfiguracao().getOmCcdefault() == null || configuracao.getConfiguracao().getOmCcdefault().getCdCc().equals("")) {
			configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().ERRO_CC_VAZIO);
			return;
		}

		if (configuracao.getConfiguracao().getOmCcdefault() != null
				&& !configuracao.getConfiguracao().getOmCcdefault().getCdCc()
						.equals("")) {
			try {
				OmCcDAO ccDAO = new OmCcDAO(getSession());
				OmCc item = ccDAO.getOmCcPorCdAtivoOrderById(configuracao
						.getConfiguracao().getOmCcdefault().getCdCc());
				omcfgOriginal.setOmCcdefault(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().ERRO_CC_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().ERRO_CC_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setOmCcdefault(null);
		}

		try {
			OmUsr item = usrDAO.getOmUsrPorCdAtivoOrderById(configuracao
					.getConfiguracao().getOmUsrByIdUsrrevisao().getCdUsr());
			omcfgOriginal.setOmUsrByIdUsrrevisao(item);
			if (item == null) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().USUARIO_DESCONHECIDO);
				return;
			}
		} catch (Exception e) {
			configuracaoRetorno.getResultado().setIdmensagem(
					configuracaoRetorno.getResultado().USUARIO_DESCONHECIDO);
			e.printStackTrace();
			return;
		}

		try {
			OmUsr item = usrDAO.getOmUsrPorCdAtivoOrderById(configuracao
					.getConfiguracao().getOmUsrByIdUsrstativo().getCdUsr());
			omcfgOriginal.setOmUsrByIdUsrstativo(item);
			if (item == null) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().USUARIO_DESCONHECIDO);
				return;
			}
		} catch (Exception e) {
			configuracaoRetorno.getResultado().setIdmensagem(
					configuracaoRetorno.getResultado().USUARIO_DESCONHECIDO);
			e.printStackTrace();
			return;
		}

		if (configuracao.getConfiguracao().getOmProduto() != null
				&& configuracao.getConfiguracao().getOmProduto().getCdProduto() != null
				&& !configuracao.getConfiguracao().getOmProduto()
						.getCdProduto().equals("")) {
			try {
				OmProdutoDAO produtoDAO = new OmProdutoDAO(getSession());
				OmProduto item = produtoDAO
						.getOmProdutoPorCdAtivoOrderByIdDesc(configuracao
								.getConfiguracao().getOmProduto()
								.getCdProduto());
				omcfgOriginal.setOmProduto(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().PRODUTO_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().PRODUTO_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setOmProduto(null);
		}

		if (configuracao.getConfiguracao().getOmResgui() != null
				&& configuracao.getConfiguracao().getOmResgui().getCdResgui() != null
				&& !configuracao.getConfiguracao().getOmResgui().getCdResgui()
						.equals("")) {
			try {
				OmResguiDAO resguiDAO = new OmResguiDAO(getSession());
				OmResgui item = resguiDAO
						.getOmResguiPorCdAtivoOrderById(configuracao
								.getConfiguracao().getOmResgui().getCdResgui());
				omcfgOriginal.setOmResgui(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().ERRO_RES_GUI_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().ERRO_RES_GUI_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setOmResgui(null);
		}

		if (configuracao.getConfiguracao().getDwEstByIdEstAlimentacao() != null
				&& configuracao.getConfiguracao().getDwEstByIdEstAlimentacao()
						.getCdEst() != null
				&& !configuracao.getConfiguracao().getDwEstByIdEstAlimentacao()
						.getCdEst().equals("")) {
			try {
				DwEst item = estDAO.getDwEstPorCdAtivoOrderById(configuracao
						.getConfiguracao().getDwEstByIdEstAlimentacao()
						.getCdEst());
				omcfgOriginal.setDwEstByIdEstAlimentacao(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().ESTOQUE_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().ESTOQUE_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setDwEstByIdEstAlimentacao(null);
		}

		if (configuracao.getConfiguracao().getDwEstlocalorigalim() != null
				&& configuracao.getConfiguracao().getDwEstlocalorigalim()
						.getCdLocal() != null
				&& !configuracao.getConfiguracao().getDwEstlocalorigalim()
						.getCdLocal().equals("")) {
			try {
				DwEstlocalDAO estlocalDAO = new DwEstlocalDAO(getSession());
				DwEstlocal item = estlocalDAO
						.getDwEstlocalPorCdAtivoOrderById(configuracao
								.getConfiguracao().getDwEstlocalorigalim()
								.getCdLocal());
				omcfgOriginal.setDwEstlocalorigalim(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().EST_LOCAL_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().EST_LOCAL_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setDwEstlocalorigalim(null);
		}

		if (configuracao.getConfiguracao().getOmTpgtByIdTpgtfabrica() != null
				&& configuracao.getConfiguracao().getOmTpgtByIdTpgtfabrica()
						.getCdTpgt() != null
				&& !configuracao.getConfiguracao().getOmTpgtByIdTpgtfabrica()
						.getCdTpgt().equals("")) {
			try {
				OmTpgt item = tpgtDAO.getOmTpgtPorCdAtivoOrderById(configuracao
						.getConfiguracao().getOmTpgtByIdTpgtfabrica()
						.getCdTpgt());
				omcfgOriginal.setOmTpgtByIdTpgtfabrica(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().TIPO_GT_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().TIPO_GT_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setOmTpgtByIdTpgtfabrica(null);
		}

		if (configuracao.getConfiguracao().getOmTpgtByIdTpgtlogsuper() != null
				&& configuracao.getConfiguracao().getOmTpgtByIdTpgtlogsuper()
						.getCdTpgt() != null
				&& !configuracao.getConfiguracao().getOmTpgtByIdTpgtlogsuper()
						.getCdTpgt().equals("")) {
			try {
				OmTpgt item = tpgtDAO.getOmTpgtPorCdAtivoOrderById(configuracao
						.getConfiguracao().getOmTpgtByIdTpgtlogsuper()
						.getCdTpgt());
				omcfgOriginal.setOmTpgtByIdTpgtlogsuper(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().TIPO_GT_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().TIPO_GT_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setOmTpgtByIdTpgtlogsuper(null);
		}

		if (configuracao.getConfiguracao().getOmTpptByIdTpptinsersora() != null
				&& configuracao.getConfiguracao().getOmTpptByIdTpptinsersora()
						.getCdTppt() != null
				&& !configuracao.getConfiguracao().getOmTpptByIdTpptinsersora()
						.equals("")
				&& !configuracao.getConfiguracao().getOmTpptByIdTpptinsersora()
						.getCdTppt().equals("")) {
			try {
				OmTppt item = tpptDAO.getOmTpptPorCdAtivoOrderById(configuracao
						.getConfiguracao().getOmTpptByIdTpptinsersora()
						.getCdTppt());
				omcfgOriginal.setOmTpptByIdTpptinsersora(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().TIPO_PT_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().TIPO_PT_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setOmTpptByIdTpptinsersora(null);
		}

		if (configuracao.getConfiguracao().getOmTpptByIdTpptpm() != null
				&& configuracao.getConfiguracao().getOmTpptByIdTpptpm()
						.getCdTppt() != null
				&& !configuracao.getConfiguracao().getOmTpptByIdTpptpm()
						.getCdTppt().equals("")) {
			try {
				OmTppt item = tpptDAO.getOmTpptPorCdAtivoOrderById(configuracao
						.getConfiguracao().getOmTpptByIdTpptpm().getCdTppt());
				omcfgOriginal.setOmTpptByIdTpptpm(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().TIPO_PT_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().TIPO_PT_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setOmTpptByIdTpptpm(null);
		}

		if (configuracao.getConfiguracao().getDwTParadaByIdTparadacip() != null
				&& configuracao.getConfiguracao().getDwTParadaByIdTparadacip()
						.getCdTparada() != null
				&& !configuracao.getConfiguracao().getDwTParadaByIdTparadacip()
						.getCdTparada().equals("")) {
			try {
				DwTParada item = tparadaDAO
						.getDwTParadaPorCdAtivoOrderById(configuracao
								.getConfiguracao().getDwTParadaByIdTparadacip()
								.getCdTparada());
				omcfgOriginal.setDwTParadaByIdTparadacip(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().ERRO_PARADA_DESCONHECIDA);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().ERRO_PARADA_DESCONHECIDA);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setDwTParadaByIdTparadacip(null);
		}

		if (	configuracao.getConfiguracao().getDwTParadasemconexao() != null && 
				configuracao.getConfiguracao().getDwTParadasemconexao().getCdTparada() != null && 
				!configuracao.getConfiguracao().getDwTParadasemconexao().getCdTparada().equals("")) {
			try {
				DwTParada item = tparadaDAO.getDwTParadaPorCdAtivoOrderById(configuracao.getConfiguracao().getDwTParadasemconexao().getCdTparada());
				omcfgOriginal.setDwTParadasemconexao(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().ERRO_PARADA_DESCONHECIDA);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().ERRO_PARADA_DESCONHECIDA);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setDwTParadasemconexao(null);
		}

		if (configuracao.getConfiguracao().getDwTAlerta() != null
				&& configuracao.getConfiguracao().getDwTAlerta().getCdTalerta() != null
				&& !configuracao.getConfiguracao().getDwTAlerta()
						.getCdTalerta().equals("")) {
			try {
				DwTAlerta item = alertaRN.getDwTAlerta(configuracao
						.getConfiguracao().getDwTAlerta().getCdTalerta());
				omcfgOriginal.setDwTAlerta(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().ALERTA_TIPO_INVALIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().ALERTA_TIPO_INVALIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setDwTAlerta(null);
		}

		if (configuracao.getConfiguracao().getOmTpptByIdTpptppass() != null
				&& configuracao.getConfiguracao().getOmTpptByIdTpptppass()
						.getCdTppt() != null
				&& !configuracao.getConfiguracao().getOmTpptByIdTpptppass()
						.getCdTppt().equals("")) {
			try {
				OmTppt item = tpptDAO
						.getOmTpptPorCdAtivoOrderById(configuracao
								.getConfiguracao().getOmTpptByIdTpptppass()
								.getCdTppt());
				omcfgOriginal.setOmTpptByIdTpptppass(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().TIPO_PT_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().TIPO_PT_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setOmTpptByIdTpptppass(null);
		}

		if (configuracao.getConfiguracao().getOmTpptByIdTpptprepro() != null
				&& configuracao.getConfiguracao().getOmTpptByIdTpptprepro()
						.getCdTppt() != null
				&& !configuracao.getConfiguracao().getOmTpptByIdTpptprepro()
						.getCdTppt().equals("")) {
			try {
				OmTppt item = tpptDAO.getOmTpptPorCdAtivoOrderById(configuracao
						.getConfiguracao().getOmTpptByIdTpptprepro()
						.getCdTppt());
				omcfgOriginal.setOmTpptByIdTpptprepro(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().TIPO_PT_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().TIPO_PT_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setOmTpptByIdTpptprepro(null);
		}

		if (configuracao.getConfiguracao().getOmTpptByIdTpptptf() != null
				&& configuracao.getConfiguracao().getOmTpptByIdTpptptf()
						.getCdTppt() != null
				&& !configuracao.getConfiguracao().getOmTpptByIdTpptptf()
						.getCdTppt().equals("")) {
			try {
				OmTppt item = tpptDAO.getOmTpptPorCdAtivoOrderById(configuracao
						.getConfiguracao().getOmTpptByIdTpptptf().getCdTppt());
				omcfgOriginal.setOmTpptByIdTpptptf(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().TIPO_PT_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().TIPO_PT_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setOmTpptByIdTpptptf(null);
		}

		if (configuracao.getConfiguracao().getOmTpptByIdTpptpts() != null
				&& configuracao.getConfiguracao().getOmTpptByIdTpptpts()
						.getCdTppt() != null
				&& !configuracao.getConfiguracao().getOmTpptByIdTpptpts()
						.getCdTppt().equals("")) {
			try {
				OmTppt item = tpptDAO.getOmTpptPorCdAtivoOrderById(configuracao
						.getConfiguracao().getOmTpptByIdTpptpts().getCdTppt());
				omcfgOriginal.setOmTpptByIdTpptpts(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().TIPO_PT_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().TIPO_PT_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setOmTpptByIdTpptpts(null);
		}

		if (configuracao.getConfiguracao().getOmTpptByIdTpptptscd() != null
				&& configuracao.getConfiguracao().getOmTpptByIdTpptptscd()
						.getCdTppt() != null
				&& !configuracao.getConfiguracao().getOmTpptByIdTpptptscd()
						.getCdTppt().equals("")) {
			try {
				OmTppt item = tpptDAO
						.getOmTpptPorCdAtivoOrderById(configuracao
								.getConfiguracao().getOmTpptByIdTpptptscd()
								.getCdTppt());
				omcfgOriginal.setOmTpptByIdTpptptscd(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().TIPO_PT_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().TIPO_PT_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setOmTpptByIdTpptptscd(null);
		}

		if (configuracao.getConfiguracao().getOmUsrgrpByIdUsrgrpoperador() != null && configuracao.getConfiguracao().getOmUsrgrpByIdUsrgrpoperador().getCdUsrgrp() != null && !configuracao.getConfiguracao().getOmUsrgrpByIdUsrgrpoperador().getCdUsrgrp().equals("")) {
			try {
				OmUsrgrp item = usrgrpDAO.getOmUsrgrpPorCdAtivoOrderById(configuracao.getConfiguracao().getOmUsrgrpByIdUsrgrpoperador().getCdUsrgrp());
				omcfgOriginal.setOmUsrgrpByIdUsrgrpoperador(item);
				if (item == null) {
					configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().GRP_USUARIO_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().GRP_USUARIO_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setOmUsrgrpByIdUsrgrpoperador(null);
		}

		
		if (configuracao.getConfiguracao().getOmUsrgrpByIdUsrgrpmonitor() != null && configuracao.getConfiguracao().getOmUsrgrpByIdUsrgrpmonitor().getCdUsrgrp() != null && !configuracao.getConfiguracao().getOmUsrgrpByIdUsrgrpmonitor().getCdUsrgrp().equals("")) {
			try {
				OmUsrgrp item = usrgrpDAO.getOmUsrgrpPorCdAtivoOrderById(configuracao.getConfiguracao().getOmUsrgrpByIdUsrgrpmonitor().getCdUsrgrp());
				omcfgOriginal.setOmUsrgrpByIdUsrgrpmonitor(item);
				if (item == null) {
					configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().GRP_USUARIO_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().GRP_USUARIO_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setOmUsrgrpByIdUsrgrpmonitor(null);
		}

		
		if (configuracao.getConfiguracao().getOmUsrgrpByIdUsrgrptecnico() != null && configuracao.getConfiguracao().getOmUsrgrpByIdUsrgrptecnico().getCdUsrgrp() != null && !configuracao.getConfiguracao().getOmUsrgrpByIdUsrgrptecnico().getCdUsrgrp().equals("")) {
			try {
				OmUsrgrp item = usrgrpDAO.getOmUsrgrpPorCdAtivoOrderById(configuracao.getConfiguracao().getOmUsrgrpByIdUsrgrptecnico().getCdUsrgrp());
				omcfgOriginal.setOmUsrgrpByIdUsrgrptecnico(item);
				if (item == null) {
					configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().GRP_USUARIO_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().GRP_USUARIO_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setOmUsrgrpByIdUsrgrptecnico(null);
		}

		
		
		if (configuracao.getConfiguracao().getOmUsrgrpByIdUsrgrpsupervisor() != null
				&& configuracao.getConfiguracao()
						.getOmUsrgrpByIdUsrgrpsupervisor().getCdUsrgrp() != null
				&& !configuracao.getConfiguracao()
						.getOmUsrgrpByIdUsrgrpsupervisor().getCdUsrgrp()
						.equals("")) {
			try {
				OmUsrgrp item = usrgrpDAO
						.getOmUsrgrpPorCdAtivoOrderById(configuracao
								.getConfiguracao()
								.getOmUsrgrpByIdUsrgrpsupervisor()
								.getCdUsrgrp());
				omcfgOriginal.setOmUsrgrpByIdUsrgrpsupervisor(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().GRP_USUARIO_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().GRP_USUARIO_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setOmUsrgrpByIdUsrgrpsupervisor(null);
		}

		if (configuracao.getConfiguracao().getDwEstByIdEstexpedicao() != null
				&& configuracao.getConfiguracao().getDwEstByIdEstexpedicao()
						.getCdEst() != null
				&& !configuracao.getConfiguracao().getDwEstByIdEstexpedicao()
						.getCdEst().equals("")) {
			try {
				DwEst item = estDAO.getDwEstPorCdAtivoOrderById(configuracao
						.getConfiguracao().getDwEstByIdEstexpedicao()
						.getCdEst());
				omcfgOriginal.setDwEstByIdEstexpedicao(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().ESTOQUE_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().ESTOQUE_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setDwEstByIdEstexpedicao(null);
		}

		if (configuracao.getConfiguracao().getDwEstByIdEstmp() != null
				&& configuracao.getConfiguracao().getDwEstByIdEstmp()
						.getCdEst() != null
				&& !configuracao.getConfiguracao().getDwEstByIdEstmp()
						.getCdEst().equals("")) {
			try {
				DwEst item = estDAO.getDwEstPorCdAtivoOrderById(configuracao
						.getConfiguracao().getDwEstByIdEstmp().getCdEst());
				omcfgOriginal.setDwEstByIdEstmp(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().ESTOQUE_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().ESTOQUE_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setDwEstByIdEstmp(null);
		}

		if (configuracao.getConfiguracao().getDwEstByIdEstliberado() != null
				&& configuracao.getConfiguracao().getDwEstByIdEstliberado()
						.getCdEst() != null
				&& !configuracao.getConfiguracao().getDwEstByIdEstliberado()
						.getCdEst().equals("")) {
			try {
				DwEst item = estDAO
						.getDwEstPorCdAtivoOrderById(configuracao
								.getConfiguracao().getDwEstByIdEstliberado()
								.getCdEst());
				omcfgOriginal.setDwEstByIdEstliberado(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().ESTOQUE_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().ESTOQUE_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setDwEstByIdEstliberado(null);
		}

		if (configuracao.getConfiguracao().getDwEstByIdEstproducao() != null
				&& configuracao.getConfiguracao().getDwEstByIdEstproducao()
						.getCdEst() != null
				&& !configuracao.getConfiguracao().getDwEstByIdEstproducao()
						.getCdEst().equals("")) {
			try {
				DwEst item = estDAO
						.getDwEstPorCdAtivoOrderById(configuracao
								.getConfiguracao().getDwEstByIdEstproducao()
								.getCdEst());
				omcfgOriginal.setDwEstByIdEstproducao(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().ESTOQUE_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().ESTOQUE_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setDwEstByIdEstproducao(null);
		}

		if (configuracao.getConfiguracao().getDwEstByIdEstrefugo() != null
				&& configuracao.getConfiguracao().getDwEstByIdEstrefugo()
						.getCdEst() != null
				&& !configuracao.getConfiguracao().getDwEstByIdEstrefugo()
						.getCdEst().equals("")) {
			try {
				DwEst item = estDAO.getDwEstPorCdAtivoOrderById(configuracao
						.getConfiguracao().getDwEstByIdEstrefugo().getCdEst());
				omcfgOriginal.setDwEstByIdEstrefugo(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().ESTOQUE_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().ESTOQUE_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setDwEstByIdEstrefugo(null);
		}

		if (configuracao.getConfiguracao().getDwFtParamByIdFtParamcorrente() != null
				&& configuracao.getConfiguracao()
						.getDwFtParamByIdFtParamcorrente().getIdFtParam() > 0) {
			try {
				DwFtParam item = ftparamDAO.getDwFtParamPorId(configuracao
						.getConfiguracao().getDwFtParamByIdFtParamcorrente()
						.getIdFtParam());
				omcfgOriginal.setDwFtParamByIdFtParamcorrente(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().FT_PARAM_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().FT_PARAM_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setDwFtParamByIdFtParamcorrente(null);
		}

		if (configuracao.getConfiguracao().getDwFtParamByIdFtParamflusos() != null
				&& configuracao.getConfiguracao()
						.getDwFtParamByIdFtParamflusos().getIdFtParam() > 0) {
			try {
				DwFtParam item = ftparamDAO.getDwFtParamPorId(configuracao
						.getConfiguracao().getDwFtParamByIdFtParamflusos()
						.getIdFtParam());
				omcfgOriginal.setDwFtParamByIdFtParamflusos(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().FT_PARAM_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().FT_PARAM_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setDwFtParamByIdFtParamflusos(null);
		}

		if (configuracao.getConfiguracao().getDwFtParamByIdFtParamfluxoe() != null
				&& configuracao.getConfiguracao()
						.getDwFtParamByIdFtParamfluxoe().getIdFtParam() > 0) {
			try {
				DwFtParam item = ftparamDAO.getDwFtParamPorId(configuracao
						.getConfiguracao().getDwFtParamByIdFtParamfluxoe()
						.getIdFtParam());
				omcfgOriginal.setDwFtParamByIdFtParamfluxoe(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().FT_PARAM_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().FT_PARAM_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setDwFtParamByIdFtParamfluxoe(null);
		}

		if (configuracao.getConfiguracao().getDwFtParamByIdFtParamtensao() != null && configuracao.getConfiguracao().getDwFtParamByIdFtParamtensao().getIdFtParam() > 0) {
			try {
				DwFtParam item = ftparamDAO.getDwFtParamPorId(configuracao.getConfiguracao().getDwFtParamByIdFtParamtensao().getIdFtParam());
				omcfgOriginal.setDwFtParamByIdFtParamtensao(item);
				if (item == null) {
					configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().FT_PARAM_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().FT_PARAM_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setDwFtParamByIdFtParamtensao(null);
		}

		
		/* Verificacao da energia consumida
		 * 
		 */
		if (configuracao.getConfiguracao().getDwFtParamByIdFtParamec() != null && configuracao.getConfiguracao().getDwFtParamByIdFtParamec().getIdFtParam() > 0) {
			try {
				DwFtParam item = ftparamDAO.getDwFtParamPorId(configuracao.getConfiguracao().getDwFtParamByIdFtParamec().getIdFtParam());
				omcfgOriginal.setDwFtParamByIdFtParamec(item);
				if (item == null) {
					configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().FT_PARAM_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().FT_PARAM_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setDwFtParamByIdFtParamec(null);
		}

		
		
		
		if (configuracao.getConfiguracao().getOmCfgptdetcoletas() != null) {
			Set<OmCfgptdetcoleta> omCfgptdetcoletas = new HashSet<OmCfgptdetcoleta>();
			for (OmCfgptdetcoleta omCfgptdetcoleta : configuracao
					.getConfiguracao().getOmCfgptdetcoletas()) {
				omCfgptdetcoleta.setOmCfg(omcfgOriginal);
				try {
					OmPtDAO ptDAO = new OmPtDAO(getSession());
					OmPt item = ptDAO
							.getOmPtPorCdAtivoOrderById(omCfgptdetcoleta
									.getOmPt().getCdPt());
					omCfgptdetcoleta.setOmPt(item);
					if (item == null) {
						configuracaoRetorno
								.getResultado()
								.setIdmensagem(
										configuracaoRetorno.getResultado().PT_DESCONHECIDO);
						return;
					}
				} catch (Exception e) {
					configuracaoRetorno.getResultado().setIdmensagem(
							configuracaoRetorno.getResultado().PT_DESCONHECIDO);
					e.printStackTrace();
					return;
				}

				omCfgptdetcoletas.add(omCfgptdetcoleta);
			}
			omcfgOriginal.setOmCfgptdetcoletas(omCfgptdetcoletas);
		}

		if (configuracao.getConfiguracao().getDwTParada() != null
				&& !configuracao.getConfiguracao().getDwTParada()
						.getCdTparada().equals("")) {
			try {
				DwTParada item = tparadaDAO
						.getDwTParadaPorCdAtivoOrderById(configuracao
								.getConfiguracao().getDwTParada()
								.getCdTparada());
				omcfgOriginal.setDwTParada(item);
				if (item == null) {
					configuracaoRetorno
							.getResultado()
							.setIdmensagem(
									configuracaoRetorno.getResultado().ERRO_PARADA_DESCONHECIDA);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().ERRO_PARADA_DESCONHECIDA);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setDwTParada(null);
		}

		if (configuracao.getConfiguracao().getDwTRefugo() != null && !configuracao.getConfiguracao().getDwTRefugo().getCdTrefugo().equals("")) {
			try {
				RefugoRN dao = new RefugoRN(getDao());
				DwTRefugo item = dao.getDwTRefugoPorCdAtivo(configuracao.getConfiguracao().getDwTRefugo().getCdTrefugo());
				omcfgOriginal.setDwTRefugo(item);
				if (item == null) {
					configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().getREFUGO_DESCONHECIDO());
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().getREFUGO_DESCONHECIDO());
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setDwTRefugo(null);
		}

		if (configuracao.getConfiguracao().getOmGtimpcic() != null && !configuracao.getConfiguracao().getOmGtimpcic().getCdGt().equals("")) {
			try {
				OmGtDAO gtDAO = new OmGtDAO(getSession());
				OmGt item = gtDAO.getOmGtPorCdAtivoOrderById(configuracao.getConfiguracao().getOmGtimpcic().getCdGt());
				omcfgOriginal.setOmGtimpcic(item);
				if (item == null) {
					configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().ERROR_GT_DESCONHECIDO);
					return;
				}
			} catch (Exception e) {
				configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().ERROR_GT_DESCONHECIDO);
				e.printStackTrace();
				return;
			}
		} else {
			omcfgOriginal.setOmGtimpcic(null);
		}

		if (configuracao.getConfiguracao().getOmCfginds() != null) {
			Set<OmCfgind> omCfginds = new HashSet<OmCfgind>();
			for (OmCfgind omCfgindAux : configuracao.getConfiguracao().getOmCfginds()) {
				try {
					omCfgindAux.setOmCfg(omcfgOriginal);
				} catch (Exception e) {
					configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().ERRO_DESCONHECIDO);
					e.printStackTrace();
					return;
				}
				omCfginds.add(omCfgindAux);
			}
			omcfgOriginal.setOmCfginds(omCfginds);
		}

		if (configuracao.getConfiguracao().getOmCfgurls() != null) {
			Set<OmCfgurl> omCfgurls = new HashSet<OmCfgurl>();
			for (OmCfgurl omCfgurlAux : configuracao.getConfiguracao().getOmCfgurls()) {
				try {
					omCfgurlAux.setOmCfg(omcfgOriginal);
					System.out.println("Deveria url: " + omCfgurlAux.getIdCfgurl());
				} catch (Exception e) {
					configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().ERRO_DESCONHECIDO);
					e.printStackTrace();
					return;
				}
				omCfgurls.add(omCfgurlAux);
			}
			omcfgOriginal.setOmCfgurls(omCfgurls);
		}

	

		if (configuracao.getConfiguracao().getOmCfgscrpimps() != null) {
			Set<OmCfgscrpimp> omCfgscrpimp = new HashSet<OmCfgscrpimp>();
			for (OmCfgscrpimp ax : configuracao.getConfiguracao().getOmCfgscrpimps()) {
				try {
					ax.setOmCfg(omcfgOriginal);
				} catch (Exception e) {
					configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().ERRO_DESCONHECIDO);
					e.printStackTrace();
					return;
				}
				omCfgscrpimp.add(ax);
			}
			omcfgOriginal.setOmCfgscrpimps(omCfgscrpimp);
		}

		// Verificar se existem as regras informadas
		if (configuracao.getConfiguracao().getOmRegrasNscbByIdRegrasCb() != null && configuracao.getConfiguracao().getOmRegrasNscbByIdRegrasCb().getCdRegrasNscb() != null && configuracao.getConfiguracao().getOmRegrasNscbByIdRegrasCb().getCdRegrasNscb().equals("") == false) {
			OmRegrasNscb regracb = null;

			try {
				regracb = getDao().findByCd(OmRegrasNscb.class, configuracao.getConfiguracao().getOmRegrasNscbByIdRegrasCb().getCdRegrasNscb(), OmRegrasNscb._FIELD_NAME_CD, true);
			} catch (RegistroDesconhecidoException e) {
				configuracaoRetorno.getResultado().setIdmensagem(configuracaoRetorno.getResultado().ERRO_RES_GUI_DESCONHECIDO);
				configuracaoRetorno.getResultado().setComplemento(configuracao.getConfiguracao().getOmRegrasNscbByIdRegrasCb().getCdRegrasNscb());
				return;
			}
			omcfgOriginal.setOmRegrasNscbByIdRegrasCb(regracb);
		} else
			omcfgOriginal.setOmRegrasNscbByIdRegrasCb(null);

		if (configuracao.getConfiguracao().getOmRegrasNscbByIdRegrasNs() != null && configuracao.getConfiguracao().getOmRegrasNscbByIdRegrasNs().getCdRegrasNscb() != null && configuracao.getConfiguracao().getOmRegrasNscbByIdRegrasNs().getCdRegrasNscb().equals("") == false) {
			OmRegrasNscb regracb = null;

			try {
				regracb = getDao().findByCd(
						OmRegrasNscb.class,
						configuracao.getConfiguracao()
								.getOmRegrasNscbByIdRegrasNs()
								.getCdRegrasNscb(),
						OmRegrasNscb._FIELD_NAME_CD, true);
			} catch (RegistroDesconhecidoException e) {
				configuracaoRetorno
						.getResultado()
						.setIdmensagem(
								configuracaoRetorno.getResultado().ERRO_RES_GUI_DESCONHECIDO);
				configuracaoRetorno.getResultado().setComplemento(
						configuracao.getConfiguracao()
								.getOmRegrasNscbByIdRegrasNs()
								.getCdRegrasNscb());
				return;
			}
			omcfgOriginal.setOmRegrasNscbByIdRegrasNs(regracb);
		} else
			omcfgOriginal.setOmRegrasNscbByIdRegrasNs(null);

	}

	public List<OmCfgurl> getCfgurls() {
		List<OmCfgurl> retorno = new ArrayList<OmCfgurl>();
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select omcfgurl From OmCfgurl omcfgurl");
		q.append("join omcfgurl.omCfg omcfg");
		q.append("where omcfg.stAtivo = 1");
		retorno = q.list();
		return retorno;
	}
	
	public OmCfgscrpimp getOmCfgscrpimpByCd(String cd) {
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select a");
		q.append("from OmCfgscrpimp a");
		q.append("join a.omCfg b");
		q.append("where a.stativo = 1");
		q.append("and b.stAtivo = 1");
		q.append("and a.cdScrp = :cd");
		
		q.setMaxResults(1);
		q.defineParametro("cd", cd);
		
		return (OmCfgscrpimp) q.uniqueResult();
	}
}