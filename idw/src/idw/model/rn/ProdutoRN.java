package idw.model.rn;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmCcDAO;
import idw.model.dao.OmForDAO;
import idw.model.dao.OmProdutoDAO;
import idw.model.dao.OmProgrpDAO;
import idw.model.dao.OmUsrDAO;
import idw.model.dao.PpClienteDAO;
import idw.model.excessoes.ClienteDesconhecidoException;
import idw.model.excessoes.ItemDentroSubItemReferenciaCircularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.excessoes.SemConfiguracaoException;
import idw.model.excessoes.SemSessaoHibernateException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwMacrange;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.DwRt;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmFor;
import idw.model.pojos.OmProaltglo;
import idw.model.pojos.OmProcomest;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmPromidia;
import idw.model.pojos.OmPropaihomo;
import idw.model.pojos.OmProrange;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUnidmedida;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCliente;
import idw.model.pojos.PpNec;
import idw.model.pojos.template.DwEstMovTemplate;
import idw.model.pojos.template.OmProcomestTemplate;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.model.pojos.template.OmProrangeTemplate;
import idw.model.rn.estoque.EstoqueRN;
import idw.util.EqualsBuilderIdw;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.CamposEmUsoOmCfgDTO;
import idw.webservices.dto.ComponenteDTO;
import idw.webservices.dto.ComponenteDeParaDTO;
import idw.webservices.dto.ComponentesDeParaDTO;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasDTO;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.dto.ProdutosDTO;
import idw.webservices.dto.ResultadoDTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.ListaProdutosDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;
import idw.webservices.rest.idw.v2.dto.ProdutoDTO2;
import injetws.model.excessoes.SemSGBDException;
import ms.util.ConversaoTipos;


public class ProdutoRN extends AbstractRN<DAOGenerico> {

	private static final String TRECHO_DS_PADRAO_PRODUTO_2 = "Incluido";
	private static final String TRECHO_DS_PADRAO_PRODUTO_1 = "Cadastrad";
	private IdwLogger log = new IdwLogger();
	private IdwLogger logCF = new IdwLogger("CFeederErro");

	public ProdutoRN() {
		this(null);
	}

	public ProdutoRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public ProdutosDTO getTodosProdutosDTO() {
		ProdutosDTO retorno = new ProdutosDTO();
		OmProdutoDAO produtoDAO = new OmProdutoDAO(getDaoSession());
		List<OmProduto> listaProdutos = produtoDAO.getOmProdutosAtivos();
		List<ProdutoDTO> listaProdutoDTO = new ArrayList<ProdutoDTO>();
		if (listaProdutos != null) {
			for (OmProduto produto : listaProdutos) {
				ProdutoDTO prodDTO = new ProdutoDTO();
				prodDTO.setProduto(produto.clone(false));
				listaProdutoDTO.add(prodDTO);
			}
		}
		Collections.sort(listaProdutoDTO, new Comparator<ProdutoDTO>() {

			@Override
			public int compare(ProdutoDTO o1, ProdutoDTO o2) {
				return o1.getProduto().getCdProduto().compareTo(o2.getProduto().getCdProduto());
			}
		});
		retorno.setProdutos(listaProdutoDTO);
		return retorno;
	}

	public ProdutosDTO getProdutosDTO(ProdutoDTO filtro) {
		OmProdutoDAO produtoDAO = new OmProdutoDAO(getDaoSession());
		List<OmProduto> listaOmproduto = produtoDAO.getProdutosMax50(filtro.getProduto());
		ProdutosDTO retorno = new ProdutosDTO();

		List<ProdutoDTO> lista = new ArrayList<ProdutoDTO>();

		if (listaOmproduto != null) {

			EstoqueRN estoqueRN = new EstoqueRN(this.getDao());

			for (OmProduto omProduto : listaOmproduto) {
				ProdutoDTO produto = new ProdutoDTO();
				produto.setProduto(omProduto.clone());
				produto.getProduto().setOmProaltglosForIdProdutoMae(new HashSet<OmProaltglo>());

				for (OmProaltglo item : omProduto.getOmProaltglosForIdProdutoMae()) {
					OmProaltglo omProaltglo = new OmProaltglo();
					omProaltglo.setOmProdutoByIdProdutoFilho(item.getOmProdutoByIdProdutoFilho().clone());

					produto.getProduto().getOmProaltglosForIdProdutoMae().add(
							omProaltglo);
				}

				// Clona estrutura do produto
				for (OmProcomest item : omProduto.getOmProcomestsForIdProduto()) {
					OmProcomest omprocomest = new OmProcomest();
					omprocomest.setIdProcomest(item.getIdProcomest());
					omprocomest.setQtUsada(item.getQtUsada());
					omprocomest.setTpProcomest(item.getTpProcomest());
					omprocomest.setConjunto(item.getConjunto());
					omprocomest.setOmProdutoByIdProdutomp(item.getOmProdutoByIdProdutomp().clone(false));
					produto.getProduto().getOmProcomestsForIdProduto().add(omprocomest);
				}

				// Clona produto pai homologados
				for (OmPropaihomo item : omProduto.getOmPropaihomosForIdProduto()) {
					OmPropaihomo ompropaihomo = new OmPropaihomo();
					ompropaihomo.setOmProdutoByIdProdutopai(item.getOmProdutoByIdProdutopai().clone(false));
					produto.getProduto().getOmPropaihomosForIdProduto().add(ompropaihomo);
				}

				try {
					produto.setEstoqueProducao(estoqueRN.getEstoqueProducaoTotalProduto(omProduto));
				} catch (SemConfiguracaoException e) {
					retorno.setResultado(new ResultadoDTO());
					retorno.getResultado().setIdmensagem(retorno.getResultado().getSEM_CONFIGURACAO());
					return retorno;
				}
				produto.setResultadoEvento(0);
				lista.add(produto);
			}
		}
		retorno.setProdutos(lista);

		return retorno;
	}

	public ProdutoDTO setProdutoDTO(ProdutoDTO produto) {
		ProdutoDTO produtoRetorno = new ProdutoDTO();
		produtoRetorno.setResultadoEvento(produtoRetorno.getEVENTO_BEM_SUCEDIDO());

		OmUsrDAO usrDAO = new OmUsrDAO(getDaoSession());

		if (produto.getProduto().getCdProduto() == null
				|| (produto.getProduto().getCdProduto() != null && produto.getProduto().getCdProduto().trim().equals(""))) {
			produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_CDPRODUTO_INVALIDO());
			return produtoRetorno;
		}
		if (produto.getProduto().getIdProduto() > 0 && produto.getProduto().getStAtivo().equals((byte) 0)) {
			produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_REATIVACAO_INDISPONIVEL());
			return produtoRetorno;
		}
		// Avaliar os valores de peso
		if ((produto.getProduto().getGPesoLiquido() != null && produto.getProduto().getGPesoBruto() == null) ||
				(produto.getProduto().getGPesoLiquido() != null && produto.getProduto().getGPesoBruto() != null
						&& produto.getProduto().getGPesoLiquido().compareTo(produto.getProduto().getGPesoBruto()) > 0)
				||
				(produto.getProduto().getGPesoLiquido() == null && produto.getProduto().getGPesoBruto() != null)) {
			produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_PESOS_INVALIDOS());
			return produtoRetorno;
		}

		OmProdutoDAO produtoDAO = new OmProdutoDAO(getDaoSession());
		boolean isInclusao = false;

		OmProduto omProdutoOriginal = produtoDAO.getOmProdutoPorId(produto.getProduto().getIdProduto());

		OmProduto omProdutoAlteracao = null;

		if (omProdutoOriginal == null) {
			omProdutoOriginal = produto.getProduto().clone();
			omProdutoOriginal.setCdProduto(omProdutoOriginal.getCdProduto().trim());
			omProdutoOriginal.setRevisao(1l);
			omProdutoOriginal.setDtRevisao(new Date());
			omProdutoOriginal.setStAtivo((byte) 1);
			omProdutoOriginal.setDtStativo(new Date());
			isInclusao = true;

			OmProduto prodAux = produtoDAO.getOmProdutoPorCdAtivoOrderByIdDesc(omProdutoOriginal.getCdProduto());
			if (prodAux != null) {
				produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_PRODUTO_JA_EXISTE());
				return produtoRetorno;
			}
		} else {
			omProdutoAlteracao = new OmProduto();
			omProdutoAlteracao.copy(omProdutoOriginal, true);
			omProdutoAlteracao.setIdProduto(0l);
			omProdutoAlteracao.setStAtivo((byte) 0);
			omProdutoOriginal.copy(produto.getProduto(), false);
			omProdutoOriginal.setDtRevisao(new Date());
			omProdutoOriginal.setDtStativo(new Date());
		}

		// Somente apos pesquisar se a nova revisao ja existe é que o pojo
		// original deve ter a revisao somada, se for antes,
		// a pesquisa acima ira trazer o pojo somado
		if (isInclusao == false) {
			if (omProdutoOriginal.getRevisao() == null)
				omProdutoOriginal.setRevisao(1l);
			else
				omProdutoOriginal.setRevisao(omProdutoOriginal.getRevisao() + 1);
			
			// Inserir relacionamentos anteriores para a revis�o antiga
			// Produtos alternativos
			if (omProdutoOriginal.getOmProaltglosForIdProdutoMae() != null && omProdutoOriginal.getOmProaltglosForIdProdutoMae().size() > 0) {
				omProdutoAlteracao.setOmProaltglosForIdProdutoMae(new HashSet<OmProaltglo>());
				for (OmProaltglo omProaltglo : omProdutoOriginal.getOmProaltglosForIdProdutoMae()) {
					OmProaltglo omProaltgloFilho = new OmProaltglo();
					omProaltgloFilho.setOmProdutoByIdProdutoMae(omProdutoAlteracao);
					omProaltgloFilho.setOmProdutoByIdProdutoFilho(omProaltglo.getOmProdutoByIdProdutoFilho());
					omProdutoAlteracao.getOmProaltglosForIdProdutoMae().add(omProaltgloFilho);
				}
			}
			
			// BOM
			if (omProdutoOriginal.getOmProcomestsForIdProduto() != null && omProdutoOriginal.getOmProcomestsForIdProduto().size() > 0) {
				omProdutoAlteracao.setOmProcomestsForIdProduto(new HashSet<OmProcomest>());
				for (OmProcomest omprocomest : omProdutoOriginal.getOmProcomestsForIdProduto()) {
					OmProcomest novo = new OmProcomest();
					novo.setConjunto(omprocomest.getConjunto());
					novo.setIdProcomest(null);
					novo.setOmProdutoByIdProduto(omProdutoAlteracao);
					novo.setOmProdutoByIdProdutomp(omprocomest.getOmProdutoByIdProdutomp());
					novo.setQtUsada(omprocomest.getQtUsada());
					novo.setTpProcomest(omprocomest.getTpProcomest());
					omProdutoAlteracao.getOmProcomestsForIdProduto().add(novo);
				}
			}
			
			// Midias
			if (omProdutoOriginal.getOmPromidias() != null && omProdutoOriginal.getOmPromidias().size() > 0) {
				omProdutoAlteracao.setOmPromidias(new HashSet<OmPromidia>());
				for (OmPromidia ompromidia : omProdutoOriginal.getOmPromidias()) {
					OmPromidia novo = new OmPromidia();
					novo.setIdPromidia(null);
					novo.setDsPromidia(ompromidia.getDsPromidia());
					novo.setDthrCadastro(ompromidia.getDthrCadastro());
					novo.setDthrFvalidade(ompromidia.getDthrFvalidade());
					novo.setDthrIvalidade(ompromidia.getDthrIvalidade());
					novo.setExtensaoArquivo(ompromidia.getExtensaoArquivo());
					novo.setMidia(ompromidia.getMidia());
					novo.setNomearquivo(ompromidia.getNomearquivo());
					novo.setOmProduto(omProdutoAlteracao);
					novo.setOmPt(ompromidia.getOmPt());
					novo.setOmTppt(ompromidia.getOmTppt());
					novo.setOmUsr(ompromidia.getOmUsr());
					novo.setStAtivo(ompromidia.getStAtivo());
					novo.setTpMidia(ompromidia.getTpMidia());
					omProdutoAlteracao.getOmPromidias().add(novo);
				}
			}

			// Exclus�o dos filhos para o item atual
			for (Iterator<OmProaltglo> iterator = omProdutoOriginal.getOmProaltglosForIdProdutoMae().iterator(); iterator.hasNext();) {
				OmProaltglo itemOmProaltglo = iterator.next();
				this.getDaoSession().delete(itemOmProaltglo);
				iterator.remove();
			}
			for (Iterator<OmProcomest> iterator = omProdutoOriginal.getOmProcomestsForIdProduto().iterator(); iterator.hasNext();) {
				OmProcomest item = iterator.next();
				this.getDaoSession().delete(item);
				iterator.remove();
			}
			for (Iterator<OmPropaihomo> iterator = omProdutoOriginal.getOmPropaihomosForIdProduto().iterator(); iterator.hasNext();) {
				OmPropaihomo item = iterator.next();
				this.getDaoSession().delete(item);
				iterator.remove();
			}
			// limpando a lista de midias.
			for (Iterator<OmPromidia> iterator = omProdutoOriginal.getOmPromidias().iterator(); iterator.hasNext();) {
				OmPromidia item = iterator.next();
				this.getDaoSession().delete(item);
				iterator.remove();
			}

			// inclus�o dos filhos para o item atual
			if (produto.getProduto().getOmProaltglosForIdProdutoMae() != null && produto.getProduto().getOmProaltglosForIdProdutoMae().size() > 0) {
				for (OmProaltglo omProaltglo : produto.getProduto().getOmProaltglosForIdProdutoMae()) {
					OmProaltglo omProaltgloFilho = new OmProaltglo();
					try {
						OmProduto omProdutoByIdProdutoFilho =
								produtoDAO.getOmProdutoPorId(omProaltglo.getOmProdutoByIdProdutoFilho().getIdProduto());
						omProaltgloFilho.setOmProdutoByIdProdutoMae(omProdutoOriginal);
						omProaltgloFilho.setOmProdutoByIdProdutoFilho(omProdutoByIdProdutoFilho);
						if (omProdutoByIdProdutoFilho == null) {
							produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_CDPRODUTO_INVALIDO());
							return produtoRetorno;
						}
					} catch (Exception e) {
						produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_CDPRODUTO_INVALIDO());
						e.printStackTrace();
						return produtoRetorno;
					}
					omProdutoOriginal.getOmProaltglosForIdProdutoMae().add(omProaltgloFilho);
				}
			}

			for (OmProcomest omprocomest : produto.getProduto().getOmProcomestsForIdProduto()) {
				OmProcomest e = new OmProcomest();

				OmProduto p = produtoDAO.getOmProdutoPorId(omprocomest.getOmProdutoByIdProdutomp().getIdProduto());
				if (p == null) {
					produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_CDPRODUTO_INVALIDO());
					return produtoRetorno;
				}
				e.setOmProdutoByIdProdutomp(p);
				e.setOmProdutoByIdProduto(omProdutoOriginal);
				e.setConjunto(omprocomest.getConjunto());
				e.setQtUsada(omprocomest.getQtUsada());
				e.setTpProcomest(omprocomest.getTpProcomest());
				omProdutoOriginal.getOmProcomestsForIdProduto().add(e);
			}

			for (OmPropaihomo ompropaihomo : produto.getProduto().getOmPropaihomosForIdProduto()) {
				OmPropaihomo pojo = new OmPropaihomo();
				OmProduto p = produtoDAO.getOmProdutoPorId(ompropaihomo.getOmProdutoByIdProdutopai().getIdProduto());
				if (p == null) {
					produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_CDPRODUTO_INVALIDO());
					return produtoRetorno;
				}
				pojo.setOmProdutoByIdProdutopai(p);
				pojo.setOmProdutoByIdProduto(omProdutoOriginal);
				omProdutoOriginal.getOmPropaihomosForIdProduto().add(pojo);
			}

			// atualizando omPromidias
			for (OmPromidia omPromidia : produto.getProduto().getOmPromidias()) {
				omPromidia.setOmProduto(omProdutoOriginal);

				// Procura omtppt
				if (omPromidia.getOmTppt() != null && omPromidia.getOmTppt().getCdTppt() != null && omPromidia.getOmTppt().getCdTppt().equals("") == false) {
					TpptRN rn = new TpptRN(getDao());
					OmTppt omtppt = rn.getOmTpptByCd(omPromidia.getOmTppt().getCdTppt());
					omPromidia.setOmTppt(omtppt);
				} else
					omPromidia.setOmTppt(null);

				// Procura ompt
				if (omPromidia.getOmPt() != null && omPromidia.getOmPt().getCdPt() != null && omPromidia.getOmPt().getCdPt().equals("") == false) {
					PTRN prn = new PTRN(getDao());
					OmPt ompt;
					try {
						ompt = prn.getOmPt(omPromidia.getOmPt().getCdPt());
					} catch (RegistroDesconhecidoException e) {
						ompt = null;
					}
					omPromidia.setOmPt(ompt);
				} else
					omPromidia.setOmPt(null);

				// produra omusr
				if (omPromidia.getOmUsr() != null) {
					OmUsr omUsr = usrDAO.getOmUsrPorCdAtivoOrderById(omPromidia.getOmUsr().getCdUsr());
					omPromidia.setOmUsr(omUsr);

				}
				
				getDao().makePersistent(omPromidia);
				omProdutoOriginal.getOmPromidias().add(omPromidia);
			}

		} else {
			omProdutoOriginal.setOmProaltglosForIdProdutoMae(new HashSet<OmProaltglo>());
			for (OmProaltglo omProaltglo : produto.getProduto().getOmProaltglosForIdProdutoMae()) {
				OmProaltglo omProaltgloFilho = new OmProaltglo();
				if (omProaltglo != null && omProaltglo.getOmProdutoByIdProdutoFilho() != null) {
					try {
						OmProduto omProdutoByIdProdutoFilho =
								produtoDAO.getOmProdutoPorId(omProaltglo.getOmProdutoByIdProdutoFilho().getIdProduto());
						omProaltgloFilho.setOmProdutoByIdProdutoMae(omProdutoOriginal);
						omProaltgloFilho.setOmProdutoByIdProdutoFilho(omProdutoByIdProdutoFilho);
						if (omProdutoByIdProdutoFilho == null) {
							produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_CDPRODUTO_INVALIDO());
							return produtoRetorno;
						}
					} catch (Exception e) {
						produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_CDPRODUTO_INVALIDO());
						e.printStackTrace();
						return produtoRetorno;
					}
					omProdutoOriginal.getOmProaltglosForIdProdutoMae().add(omProaltgloFilho);
				}
			}
			omProdutoOriginal.setOmProcomestsForIdProduto(new HashSet<OmProcomest>());
			for (OmProcomest omprocomest : produto.getProduto().getOmProcomestsForIdProduto()) {
				OmProcomest e = new OmProcomest();
				OmProduto p = produtoDAO.getOmProdutoPorId(omprocomest.getOmProdutoByIdProdutomp().getIdProduto());
				if (p == null) {
					produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_CDPRODUTO_INVALIDO());
					return produtoRetorno;
				}
				e.setConjunto(omprocomest.getConjunto());
				e.setQtUsada(omprocomest.getQtUsada());
				e.setTpProcomest(omprocomest.getTpProcomest());
				e.setOmProdutoByIdProdutomp(p);
				e.setOmProdutoByIdProduto(omProdutoOriginal);
				omProdutoOriginal.getOmProcomestsForIdProduto().add(e);
			}
		}

		// Avaliar o grupo de produto para qualquer tipo de produto
		if (produto.getProduto().getOmProgrp() != null && !produto.getProduto().getOmProgrp().getCdProgrp().equals("")) {
			try {
				OmProgrpDAO progrpDAO = new OmProgrpDAO(getDaoSession());
				OmProgrp omProgrp = progrpDAO.getOmProgrpPorCdAtivoOrderById(produto.getProduto().getOmProgrp().getCdProgrp());
				omProdutoOriginal.setOmProgrp(omProgrp);
				if (omProgrp == null) {
					produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_GRUPOPRODUTO_DESCONHECIDO());
					return produtoRetorno;
				}
			} catch (Exception e) {
				produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_GRUPOPRODUTO_DESCONHECIDO());
				e.printStackTrace();
				return produtoRetorno;
			}
		} else {
			omProdutoOriginal.setOmProgrp(null);
		}

		// Se produto do tipo COMPONENTE, avaliar o agrupador se tiver sido informado
		if ((produto.getProduto().getTpProduto() == 1) &&
				(produto.getProduto().getOmProdutoByIdProdutoagru() != null) &&
				(produto.getProduto().getOmProdutoByIdProdutoagru().getCdProduto() != null) &&
				!produto.getProduto().getOmProdutoByIdProdutoagru().getCdProduto().equals("")) {
			try {
				OmProduto omProAgru =
						produtoDAO.getOmProdutoPorCdAtivoOrderByIdDesc(produto.getProduto().getOmProdutoByIdProdutoagru().getCdProduto());
				omProdutoOriginal.setOmProdutoByIdProdutoagru(omProAgru);
				if (omProAgru == null) {
					produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_AGRUPADOR_DESCONHECIDO());
					return produtoRetorno;
				}
			} catch (Exception e) {
				produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_AGRUPADOR_DESCONHECIDO());
				e.printStackTrace();
				return produtoRetorno;
			}
		} else {
			omProdutoOriginal.setOmProdutoByIdProdutoagru(null);
		}

		if ((produto.getProduto().getOmCc() != null) &&
				(produto.getProduto().getOmCc().getCdCc() != null)
				&& !produto.getProduto().getOmCc().getCdCc().equals("")) {
			try {
				OmCcDAO ccDAO = new OmCcDAO(getDaoSession());
				OmCc omCc = ccDAO.getOmCcPorCdAtivoOrderById(produto.getProduto().getOmCc().getCdCc());
				omProdutoOriginal.setOmCc(omCc);
				if (omCc == null) {
					produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_CC_DESCONHECIDO());
					return produtoRetorno;
				}
			} catch (Exception e) {
				produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_CC_DESCONHECIDO());
				e.printStackTrace();
				return produtoRetorno;
			}
		} else {
			omProdutoOriginal.setOmCc(null);
		}

		if (produto.getProduto().getOmFor() != null && !produto.getProduto().getOmFor().getCdFor().equals("")) {
			try {
				OmForDAO forDAO = new OmForDAO(getDaoSession());
				OmFor omFor = forDAO.getOmForPorCdAtivoOrderById(produto.getProduto().getOmFor().getCdFor());// (OmFor) q.list().get(0);
				omProdutoOriginal.setOmFor(omFor);
				if (omFor == null) {
					produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_FOR_DESCONHECIDO());
					return produtoRetorno;
				}
			} catch (Exception e) {
				produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_FOR_DESCONHECIDO());
				e.printStackTrace();
				return produtoRetorno;
			}
		} else {
			omProdutoOriginal.setOmFor(null);
		}

		try {
			OmUsr omUsrRevisao = usrDAO.getOmUsrPorCdAtivoOrderById(produto.getProduto().getOmUsrByIdUsrrevisao().getCdUsr());
			omProdutoOriginal.setOmUsrByIdUsrrevisao(omUsrRevisao);
			if (omUsrRevisao == null) {
				produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
				return produtoRetorno;
			}
		} catch (Exception e) {
			produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
			e.printStackTrace();
			return produtoRetorno;
		}

		try {
			OmUsr omUsrStAtivo = usrDAO.getOmUsrPorCdAtivoOrderById(produto.getProduto().getOmUsrByIdUsrstativo().getCdUsr());
			omProdutoOriginal.setOmUsrByIdUsrstativo(omUsrStAtivo);
			if (omUsrStAtivo == null) {
				produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
				return produtoRetorno;
			}
		} catch (Exception e) {
			produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
			e.printStackTrace();
			return produtoRetorno;
		}

		// Avalia se o tipo do produto eh aceitavel
		if ((produto.getProduto().getTpProduto() < 0) || (produto.getProduto().getTpProduto() > 4)) {
			produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_TIPOPRODUTO_VAZIO());
		}

		if (produto.getProduto().getTpSemiacabado() != null && (produto.getProduto().getTpSemiacabado() < 0 || produto.getProduto().getTpSemiacabado() > 2)) {
			produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_SEMIACABADO_INVALIDO());
			return produtoRetorno;
		}

		// Avalia se o cliente existe
		PpClienteDAO clienteDAO = new PpClienteDAO(getDaoSession());
		PpCliente ppcliente = null;
		if (produto.getProduto().getPpCliente() != null) {
			ppcliente = clienteDAO.getPpClientePorCdAtivo(produto.getProduto().getPpCliente().getCdCliente());
			if (ppcliente == null) {
				produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_CLIENTE_DESCONHECIDO());
				return produtoRetorno;
			}
		}

		omProdutoOriginal.setPpCliente(ppcliente);

		OmUnidmedida omUnidmedida = null;
		if (produto.getProduto().getOmUnidmedida() != null && !produto.getProduto().getOmUnidmedida().getCd().isEmpty()) {
			try {
				omUnidmedida = getOmUnidmedida(produto.getProduto().getOmUnidmedida().getCd());

			} catch (RegistroDesconhecidoException e1) {
			}
		}
		omProdutoOriginal.setOmUnidmedida(omUnidmedida);
		// Se tudo correu certo,
		if (produtoRetorno.getResultadoEvento() == produtoRetorno.getEVENTO_BEM_SUCEDIDO()) {
			try {
				omProdutoOriginal.getQtLoteminprod();
				omProdutoOriginal = getDao().makePersistent(omProdutoOriginal);
				if (omProdutoAlteracao != null) {
					omProdutoAlteracao = getDao().makePersistent(omProdutoAlteracao);
				}

			} catch (Exception e) {
				produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_DESCONHECIDO());
				e.printStackTrace();
			}

			if (isInclusao) {
				// salvando omPromidias
				for (OmPromidia omPromidia : produto.getProduto().getOmPromidias()) {
					omPromidia.setOmProduto(omProdutoOriginal);
					omPromidia.setStAtivo((byte) 1);
					if (omPromidia.getOmPt() != null && omPromidia.getOmPt().getCdPt().trim().equals(""))
						omPromidia.setOmPt(null);

					getDao().makePersistent(omPromidia);
				}
			}

			produtoRetorno.setProduto(omProdutoOriginal.clone());
			produtoRetorno.getProduto().setOmProaltglosForIdProdutoMae(new HashSet<OmProaltglo>());
			for (OmProaltglo item : omProdutoOriginal.getOmProaltglosForIdProdutoMae()) {
				OmProaltglo omProaltglo = new OmProaltglo();
				omProaltglo.setOmProdutoByIdProdutoFilho(item.getOmProdutoByIdProdutoFilho().clone());
				produtoRetorno.getProduto().getOmProaltglosForIdProdutoMae().add(omProaltglo);
			}

			// Clona estrutura do produto
			for (OmProcomest item : omProdutoOriginal.getOmProcomestsForIdProduto()) {
				OmProcomest omprocomest = new OmProcomest();
				omprocomest.setIdProcomest(item.getIdProcomest());
				omprocomest.setQtUsada(item.getQtUsada());
				omprocomest.setTpProcomest(item.getTpProcomest());
				omprocomest.setConjunto(item.getConjunto());
				omprocomest.setOmProdutoByIdProdutomp(item.getOmProdutoByIdProdutomp().clone());
				produtoRetorno.getProduto().getOmProcomestsForIdProduto().add(omprocomest);
			}

			// Clona a lista de produtos pai homologados
			produtoRetorno.getProduto().setOmPropaihomosForIdProduto(new HashSet<OmPropaihomo>());
			for (OmPropaihomo item : omProdutoOriginal.getOmPropaihomosForIdProduto()) {
				OmPropaihomo pojo = new OmPropaihomo();
				pojo.setOmProdutoByIdProdutopai(item.getOmProdutoByIdProdutopai().clone(false));
				produtoRetorno.getProduto().getOmPropaihomosForIdProduto().add(pojo);
			}

			EstoqueRN estoqueRN = new EstoqueRN(this.getDao());

			try {
				estoqueRN.setEstoqueProducaoTotalProduto(omProdutoOriginal, produto.getEstoqueProducao(),
						omProdutoOriginal.getOmUsrByIdUsrrevisao(), true, DataHoraRN.getDataHoraAtual(),
						DwEstMovTemplate.TpOrigem.AJUSTE_MANUAL);
				produtoRetorno.setEstoqueProducao(estoqueRN.getEstoqueProducaoTotalProduto(produtoRetorno.getProduto()));
			} catch (SemConfiguracaoException e) {
				produtoRetorno.setProduto(null);
				produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_SEM_CONFIGURACAO());
			}

		}

		return produtoRetorno;
	}

	public ProdutosDTO removeProdutosDTO(ProdutosDTO produtos) {
		ProdutosDTO produtosRetorno = new ProdutosDTO();

		// 17/03/2017 Alex: nao remover codigo em uso na configuracao geral.
		CamposEmUsoOmCfgDTO camposEmUsoOmCfgDTO = getCamposEmUsoOmCfg(produtos);
		produtosRetorno.setCamposEmUsoOmCfg(camposEmUsoOmCfgDTO);
		if (camposEmUsoOmCfgDTO.getStatus() != camposEmUsoOmCfgDTO.getSTATUS_NENHUM_CAMPO_EM_USO()) {
			// se entrar nesse if eh pq existe algum codigo em uso
			produtosRetorno.setProdutos(new ArrayList<ProdutoDTO>());
			return produtosRetorno;
		}

		List<ProdutoDTO> listaRetorno = new ArrayList<ProdutoDTO>();
		for (ProdutoDTO produto : produtos.getProdutos()) {
			ProdutoDTO produtoRetorno = new ProdutoDTO();
			OmProdutoDAO produtoDAO = new OmProdutoDAO(getDaoSession());
			OmProduto omProduto = produtoDAO.getOmProdutoPorId(produto.getProduto().getIdProduto());

			if (omProduto == null) {
				produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_DESCONHECIDO());
				produtoRetorno.setProduto(produto.getProduto());
			} else if (omProduto.getStAtivo() == 0) {
				produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_DESCONHECIDO());
				produtoRetorno.setProduto(omProduto.clone());
			} else {
				omProduto.setStAtivo((byte) 0);
				omProduto.setDtStativo(new Date());

				try {
					omProduto = getDao().makePersistent(omProduto);
				} catch (Exception e) {
					e.printStackTrace();
				}

				produtoRetorno.setProduto(omProduto.clone());
				produtoRetorno.getProduto().setOmProaltglosForIdProdutoMae(
						new HashSet<OmProaltglo>());
				for (OmProaltglo item : omProduto.getOmProaltglosForIdProdutoMae()) {
					OmProaltglo omProaltglo = new OmProaltglo();
					omProaltglo.setOmProdutoByIdProdutoFilho(item.getOmProdutoByIdProdutoFilho().clone());
					produtoRetorno.getProduto().getOmProaltglosForIdProdutoMae().add(omProaltglo);
				}
				produtoRetorno.setResultadoEvento(produtoRetorno.getEVENTO_BEM_SUCEDIDO());
			}

			listaRetorno.add(produtoRetorno);
		}

		produtosRetorno.setProdutos(listaRetorno);
		return produtosRetorno;
	}

	private CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg(ProdutosDTO itens) {
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());

		// campos
		OmProduto produtoEmUso = omcfg.getOmProduto();

		CamposEmUsoOmCfgDTO camposEmUsoOmCfg = new CamposEmUsoOmCfgDTO();
		boolean isTemCodigoEmUso = false;
		for (ProdutoDTO item : itens.getProdutos()) {
			camposEmUsoOmCfg.setCodigo(item.getProduto().getCdProduto());

			if (produtoEmUso != null) {
				if (item.getProduto().getCdProduto().equals(produtoEmUso.getCdProduto())) {
					camposEmUsoOmCfg.setProdutoDefaultParaImportacaoIAC(true);
					isTemCodigoEmUso = true;
				}
			}

		}

		if (isTemCodigoEmUso) {

			if (itens.getProdutos() != null && itens.getProdutos().size() > 1) {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_EXCLUSAO_ABORTADA());
			} else {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_TEM_CAMPO_EM_USO());
			}

		} else {
			camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_NENHUM_CAMPO_EM_USO());
		}

		return camposEmUsoOmCfg;
	}

	public ProdutoDTO ativaProdutoDTO(ProdutoDTO produto) {
		ProdutoDTO produtoRetorno = new ProdutoDTO();

		// Verifica se a revisao que está sendo reativada é a maior para o codigo
		OmProdutoDAO produtoDAO = new OmProdutoDAO(getDaoSession());
		OmProduto prodAux = produtoDAO.getOmProdutoPorCdComMaiorRevisao(produto.getProduto().getCdProduto(),
				produto.getProduto().getRevisao());
		if (prodAux != null) {
			produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_REATIVACAO_INDISPONIVEL());
			return produtoRetorno;
		}

		OmProduto omProduto = produtoDAO.getOmProdutoPorId(produto.getProduto().getIdProduto());

		if (omProduto == null) {
			produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_DESCONHECIDO());
			produtoRetorno.setProduto(produto.getProduto());
			return produtoRetorno;
		} else if (omProduto.getStAtivo() == 1) {
			produtoRetorno.setResultadoEvento(produtoRetorno.getERRO_DESCONHECIDO());
			produtoRetorno.setProduto(omProduto.clone());
		} else {
			omProduto.setStAtivo((byte) 1);
			omProduto.setDtStativo(new Date());
		}

		try {
			omProduto = getDao().makePersistent(omProduto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		produtoRetorno.setProduto(omProduto.clone());

		produtoRetorno.getProduto().setOmProaltglosForIdProdutoMae(new HashSet<OmProaltglo>());
		for (OmProaltglo item : omProduto.getOmProaltglosForIdProdutoMae()) {
			OmProaltglo omProaltglo = new OmProaltglo();
			omProaltglo.setOmProdutoByIdProdutoFilho(item.getOmProdutoByIdProdutoFilho().clone());
			produtoRetorno.getProduto().getOmProaltglosForIdProdutoMae().add(omProaltglo);
		}
		produtoRetorno.setResultadoEvento(produtoRetorno.getEVENTO_BEM_SUCEDIDO());
		return produtoRetorno;
	}

	public PesquisasDTO pesquisaOmprodutoComponente(PesquisaDTO pesquisa) {
		OmProdutoDAO dao = new OmProdutoDAO(getDaoSession());
		List<OmProduto> lista =
				dao.getOmProdutos(pesquisa.getCodigo(), pesquisa.getDescricao(), OmProdutoTemplate.TpProduto.COMPONENTE.getId());

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmProduto item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdProduto());
				itemDTO.setDescricao(item.getDsProduto());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO retorno = new PesquisasDTO();
		retorno.setPesquisa(listaDTO);
		return retorno;
	}

	public PesquisasDTO pesquisaOmprodutoSemiacabado(PesquisaDTO pesquisa) {
		OmProdutoDAO dao = new OmProdutoDAO(getDaoSession());
		List<OmProduto> lista =
				dao.getOmProdutos(pesquisa.getCodigo(), pesquisa.getDescricao(), OmProdutoTemplate.TpProduto.SEMI_ACABADO.getId());

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmProduto item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdProduto());
				itemDTO.setDescricao(item.getDsProduto());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO retorno = new PesquisasDTO();
		retorno.setPesquisa(listaDTO);
		return retorno;
	}

	public PesquisasDTO pesquisaOmprodutoComponenteComAgrupador(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from OmProduto t ";
		hql += "join fetch t.omProdutoByIdProdutoagru omProdutoByIdProdutoagru ";
		hql += "where t.stAtivo=1 and t.tpProduto = 1 and omProdutoByIdProdutoagru.cdProduto is not null ";

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdProduto = '::cdProduto' or t.dsProduto = '::dsProduto' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdProduto = '::cdProduto' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsProduto = '::dsProduto' ";
		}

		hql = hql.replaceAll("::cdProduto", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsProduto", pesquisa.getDescricao());

		Query q = this.getDaoSession().createQuery(hql);

		List<OmProduto> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmProduto item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdProduto());
				itemDTO.setDescricao(item.getDsProduto());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaOmprodutoAgrupador(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from OmProduto t ";
		hql += "where t.stAtivo=1 and t.tpProduto = 2 ";

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdProduto = '::cdProduto' or t.dsProduto = '::dsProduto' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdProduto = '::cdProduto' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsProduto = '::dsProduto' ";
		}

		hql = hql.replaceAll("::cdProduto", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsProduto", pesquisa.getDescricao());

		Query q = this.getDaoSession().createQuery(hql);

		List<OmProduto> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmProduto item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdProduto());
				itemDTO.setDescricao(item.getDsProduto());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaOmprodutoNaFolha(PesquisaDTO pesquisa) {
		List<OmProduto> lista = null;

		MapQuery q = new MapQuery(getDaoSession());
		q.append("select t ");
		q.append("from OmProduto t ");
		q.append("where t.stAtivo=1");
		q.append("and (t.tpProduto = 0"); // produto final
		q.append("or t.tpProduto = 3)"); // semiacabado

		if (pesquisa.getCodigo().equals("") == false) {
			q.append("and t.cdProduto = :cdProduto");
		}

		if (pesquisa.getRegistro() != null && pesquisa.getRegistro() instanceof DwFolha) {
			FolhaRN rn = new FolhaRN(getDao());
			DwFolha dwfolha = rn.pesquisaFolhaByCdEStSemRota(((DwFolha) pesquisa.getRegistro()).getCdFolha());
			lista = rn.getProdutosFromDwFolha(dwfolha);
		} else {
			q.defineParametro("cdProduto", pesquisa.getCodigo());
			try {
				lista = q.list();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmProduto item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdProduto());
				itemDTO.setDescricao(item.getDsProduto());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public OmProduto salvarOmproduto(OmProduto omproduto) {
		OmProduto retorno = new OmProduto();

		if (omproduto.getCdProduto().trim().equals("")) {
			return retorno;
		}

		boolean isInclusao = false;

		String hql = "";

		hql = "from OmProduto omproduto where omproduto.idProduto = ::idproduto ";
		hql = hql.replaceAll("::idproduto", String.valueOf(omproduto.getIdProduto()));

		Query q = this.getDaoSession().createQuery(hql);

		OmProduto omProdutoOriginal = (OmProduto) q.uniqueResult();

		OmProduto omProdutoAlteracao = null;

		if (omProdutoOriginal == null) {
			omProdutoOriginal = omproduto.clone();
			omProdutoOriginal.setRevisao(1l);
			omProdutoOriginal.setDtRevisao(new Date());
			omProdutoOriginal.setStAtivo((byte) 1);
			omProdutoOriginal.setDtStativo(new Date());
			isInclusao = true;
		} else {
			omProdutoAlteracao = new OmProduto();
			omProdutoAlteracao.copy(omProdutoOriginal, true);
			omProdutoAlteracao.setIdProduto(0l);
			omProdutoAlteracao.setStAtivo((byte) 0);
			omProdutoOriginal.copy(omproduto, false);
			omProdutoOriginal.setDtRevisao(new Date());
		}

		// Verifica se o codigo + revisao do grupo de usuario ja existe no
		// banco, se exitir retornar ao cliente a excessao
		hql = "";

		hql += "from OmProduto omproduto ";
		hql += "where omproduto.cdProduto = '::cdproduto' ";
		hql += "and omproduto.revisao = ::revisao ";

		hql = hql.replaceAll("::cdproduto", omProdutoOriginal.getCdProduto());
		hql = hql.replaceAll("::revisao", String.valueOf((omProdutoOriginal.getRevisao() + 1l)));
		q = this.getDaoSession().createQuery(hql);

		if (q.list().size() > 0) {
			return retorno;
		}

		// Somente apos pesquisar se a nova revisao ja existe é que o pojo
		// original deve ter a revisao somada, se for antes,
		// a pesquisa acima ira trazer o pojo somado
		if (isInclusao == false) {
			omProdutoOriginal.setRevisao(omProdutoOriginal.getRevisao() + 1);
		}

		if (omproduto != null && omproduto.getOmProgrp() != null && omproduto.getOmProgrp().getCdProgrp() != null) {
			try {
				hql = "from OmProgrp t where t.cdProgrp = '::cdProgrp' ";
				hql += "and t.stAtivo = 1 ";
				hql += "order by t.idProgrp ";
				hql = hql.replaceAll("::cdProgrp", omproduto.getOmProgrp().getCdProgrp());

				q = this.getDaoSession().createQuery(hql);

				OmProgrp omProgrp = (OmProgrp) q.list().get(0);

				omProdutoOriginal.setOmProgrp(omProgrp);
			} catch (Exception e) {
				omProdutoOriginal.setOmProgrp(null);
			}
		} else
			omProdutoOriginal.setOmProgrp(null);

		if ((omproduto.getOmCc() != null) && !omproduto.getOmCc().getCdCc().equals("")) {
			try {
				hql = "from OmCc t where t.cdCc = '::cdCc' ";
				hql += "and t.stAtivo = 1 ";
				hql += "order by t.idCc ";
				hql = hql.replaceAll("::cdCc", omproduto.getOmCc().getCdCc());

				q = this.getDaoSession().createQuery(hql);

				OmCc omCc = (OmCc) q.list().get(0);

				omProdutoOriginal.setOmCc(omCc);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			hql = "from OmFor t where t.cdFor = '::cdFor' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idFor ";
			hql = hql.replaceAll("::cdFor", omproduto.getOmFor().getCdFor());

			q = this.getDaoSession().createQuery(hql);

			OmFor omFor = (OmFor) q.list().get(0);

			omProdutoOriginal.setOmFor(omFor);
		} catch (Exception e) {
			omProdutoOriginal.setOmFor(null);
		}

		try {
			hql = "from OmUsr t where t.cdUsr = '::cdUsr' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idUsr ";

			hql = hql.replaceAll("::cdUsr", omproduto.getOmUsrByIdUsrrevisao().getCdUsr());

			q = this.getDaoSession().createQuery(hql);

			OmUsr omUsrRevisao = (OmUsr) q.list().get(0);

			omProdutoOriginal.setOmUsrByIdUsrrevisao(omUsrRevisao);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			hql = "from OmUsr t where t.cdUsr = '::cdUsr' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idUsr ";
			hql = hql.replaceAll("::cdUsr", omproduto.getOmUsrByIdUsrstativo()
					.getCdUsr());

			q = this.getDaoSession().createQuery(hql);

			OmUsr omUsrStAtivo = (OmUsr) q.list().get(0);

			omProdutoOriginal.setOmUsrByIdUsrstativo(omUsrStAtivo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			omProdutoOriginal = getDao().makePersistent(omProdutoOriginal);
			if (omProdutoAlteracao != null) {
				getDao().makePersistent(omProdutoAlteracao);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		retorno = omProdutoOriginal;

		return retorno;
	}

	// Importacao Programa - Ailton 09/10/2017
	public OmProduto salvarOmprodutoImportacaoPrograma(OmProduto omproduto) {
		OmProduto retorno = new OmProduto();

		if (omproduto.getCdProduto().trim().equals("")) {
			return retorno;
		}

		boolean isInclusao = false;

		String hql = "";

		hql = "from OmProduto omproduto where omproduto.idProduto = ::idproduto ";
		hql = hql.replaceAll("::idproduto", String.valueOf(omproduto.getIdProduto()));

		Query q = this.getDaoSession().createQuery(hql);

		OmProduto omProdutoOriginal = (OmProduto) q.uniqueResult();

		OmProduto omProdutoAlteracao = null;

		if (omProdutoOriginal == null) {
			omProdutoOriginal = omproduto.clone();
			omProdutoOriginal.setRevisao(1l);
			omProdutoOriginal.setDtRevisao(new Date());
			omProdutoOriginal.setStAtivo((byte) 1);
			omProdutoOriginal.setDtStativo(new Date());
			isInclusao = true;
		} else {
			omProdutoAlteracao = new OmProduto();
			omProdutoAlteracao.copy(omProdutoOriginal, true);
			omProdutoAlteracao.setIdProduto(0l);
			omProdutoAlteracao.setStAtivo((byte) 0);
			omProdutoOriginal.copy(omproduto, false);
			omProdutoOriginal.setDtRevisao(new Date());
		}

		// Verifica se o codigo + revisao do grupo de usuario ja existe no
		// banco, se exitir retornar ao cliente a excessao
		hql = "";

		hql += "from OmProduto omproduto ";
		hql += "where omproduto.cdProduto = '::cdproduto' ";
		hql += "and omproduto.revisao = ::revisao ";

		hql = hql.replaceAll("::cdproduto", omProdutoOriginal.getCdProduto());
		hql = hql.replaceAll("::revisao", String.valueOf((omProdutoOriginal.getRevisao() + 1l)));
		q = this.getDaoSession().createQuery(hql);

		if (q.list().size() > 0) {
			return retorno;
		}

		// Somente apos pesquisar se a nova revisao ja existe é que o pojo
		// original deve ter a revisao somada, se for antes,
		// a pesquisa acima ira trazer o pojo somado
		if (isInclusao == false) {
			omProdutoOriginal.setRevisao(omProdutoOriginal.getRevisao() + 1);
		}

		if (omproduto != null && omproduto.getOmProgrp() != null && omproduto.getOmProgrp().getCdProgrp() != null) {
			try {
				hql = "from OmProgrp t where t.cdProgrp = '::cdProgrp' ";
				hql += "and t.stAtivo = 1 ";
				hql += "order by t.idProgrp ";
				hql = hql.replaceAll("::cdProgrp", omproduto.getOmProgrp().getCdProgrp());

				q = this.getDaoSession().createQuery(hql);

				OmProgrp omProgrp = (OmProgrp) q.list().get(0);

				omProdutoOriginal.setOmProgrp(omProgrp);
			} catch (Exception e) {
				omProdutoOriginal.setOmProgrp(null);
			}
		} else
			omProdutoOriginal.setOmProgrp(null);

		if ((omproduto.getOmCc() != null) && !omproduto.getOmCc().getCdCc().equals("")) {
			try {
				hql = "from OmCc t where t.cdCc = '::cdCc' ";
				hql += "and t.stAtivo = 1 ";
				hql += "order by t.idCc ";
				hql = hql.replaceAll("::cdCc", omproduto.getOmCc().getCdCc());

				q = this.getDaoSession().createQuery(hql);

				OmCc omCc = (OmCc) q.list().get(0);

				omProdutoOriginal.setOmCc(omCc);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			hql = "from OmFor t where t.cdFor = '::cdFor' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idFor ";
			hql = hql.replaceAll("::cdFor", omproduto.getOmFor().getCdFor());

			q = this.getDaoSession().createQuery(hql);

			OmFor omFor = (OmFor) q.list().get(0);

			omProdutoOriginal.setOmFor(omFor);
		} catch (Exception e) {
			omProdutoOriginal.setOmFor(null);
		}

		try {
			hql = "from OmUsr t where t.cdUsr = '::cdUsr' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idUsr ";

			hql = hql.replaceAll("::cdUsr", omproduto.getOmUsrByIdUsrrevisao().getCdUsr());

			q = this.getDaoSession().createQuery(hql);

			OmUsr omUsrRevisao = (OmUsr) q.list().get(0);

			omProdutoOriginal.setOmUsrByIdUsrrevisao(omUsrRevisao);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			hql = "from OmUsr t where t.cdUsr = '::cdUsr' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idUsr ";
			hql = hql.replaceAll("::cdUsr", omproduto.getOmUsrByIdUsrstativo()
					.getCdUsr());

			q = this.getDaoSession().createQuery(hql);

			OmUsr omUsrStAtivo = (OmUsr) q.list().get(0);

			omProdutoOriginal.setOmUsrByIdUsrstativo(omUsrStAtivo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			omProdutoOriginal = getDao().makePersistent(omProdutoOriginal);
			if (omProdutoAlteracao != null) {
				getDao().makePersistent(omProdutoAlteracao);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		retorno = omProdutoOriginal;

		return retorno;
	}

	public ComponentesDeParaDTO importarComponentesDePara(ComponentesDeParaDTO componentes) throws SemConfiguracaoException {

		DiversosRN rnDiversos = new DiversosRN();
		rnDiversos.setSession(getDao().getSession());

		OmCfg omcfg = rnDiversos.pesquisaOmcfg();
		for (ComponenteDeParaDTO componente : componentes.getComponentes()) {

			if (this.isImportadoEmOmProaltglo(componente.getComponente(), componente.getFornecedor())) {
				continue;
			}
			if (componente == null || componente.getComponente() == null || componente.getComponente().trim().equals("")) {
				continue;
			}
			OmProduto omprodutoComponente = null;
			try {
				omprodutoComponente = this.getOmProduto(componente.getComponente());
			} catch (RegistroDesconhecidoException e) {
				// Produto nao existe, entao providenciar o cadastro
				omprodutoComponente = new OmProduto();
				omprodutoComponente.setCdProduto(componente.getComponente());
				omprodutoComponente.setDsProduto("Cadastrado na importa��o de componentes de/para");
				omprodutoComponente.setMinValposalim(new BigDecimal(0));
				omprodutoComponente.setOmCc(omcfg.getOmCcdefault());
				omprodutoComponente.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
				omprodutoComponente.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());
				omprodutoComponente.setOmProgrp(new OmProgrp());
				omprodutoComponente.getOmProgrp().setCdProgrp("0");
				omprodutoComponente.setTpProduto(OmProdutoTemplate.TpProduto.COMPONENTE.getId());

				omprodutoComponente = this.salvarOmproduto(omprodutoComponente);
			}

			OmProduto omprodutoFornecedor = null;
			try {
				omprodutoFornecedor = this.getOmProduto(componente.getFornecedor());
			} catch (RegistroDesconhecidoException e) {
				// Produto nao existe, entao providenciar o cadastro
				omprodutoFornecedor = new OmProduto();
				omprodutoFornecedor.setCdProduto(componente.getFornecedor());
				omprodutoFornecedor.setDsProduto("Cadastrado na importa��o de componentes de/para");
				omprodutoFornecedor.setMinValposalim(new BigDecimal(0));
				omprodutoFornecedor.setOmCc(omcfg.getOmCcdefault());
				omprodutoFornecedor.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
				omprodutoFornecedor.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());
				omprodutoFornecedor.setTpProduto(OmProdutoTemplate.TpProduto.COMPONENTE.getId());
				omprodutoFornecedor = this.salvarOmproduto(omprodutoFornecedor);
			}

			if (!this.isExisteOmProaltglo(omprodutoComponente.getIdProduto(), omprodutoFornecedor.getIdProduto())) {
				OmProaltglo omProaltglo = new OmProaltglo();
				omProaltglo.setOmProdutoByIdProdutoMae(omprodutoComponente);
				omProaltglo.setOmProdutoByIdProdutoFilho(omprodutoFornecedor);
				this.getDao().makePersistent(omProaltglo);
			}

			if (this.isExisteOmProaltglo(omprodutoFornecedor.getIdProduto(), omprodutoComponente.getIdProduto()) == false &&
					omprodutoFornecedor != null && omprodutoFornecedor.getIdProduto() > 0l &&
					omprodutoComponente != null && omprodutoComponente.getIdProduto() > 0l) {
				OmProaltglo omProaltglo = new OmProaltglo();
				omProaltglo.setIdProalt(0l);
				omProaltglo.setOmProdutoByIdProdutoMae(omprodutoFornecedor);
				omProaltglo.setOmProdutoByIdProdutoFilho(omprodutoComponente);
				this.getDao().makePersistent(omProaltglo);
			}

			componente.setResultadoEvento(componente.getEVENTO_BEM_SUCEDIDO());
		}

		return componentes;
	}

	public boolean isExisteOmProaltglo(long idProdutoMae, long idProdutoFilho) {

		String hql = "";
		hql += "select t ";
		hql += "from OmProaltglo t ";
		hql += "where  ";
		hql += "t.omProdutoByIdProdutoMae.idProduto='::idProdutoMae' and ";
		hql += "t.omProdutoByIdProdutoFilho.idProduto='::idProdutoFilho' ";

		hql = hql.replaceAll("::idProdutoMae", String.valueOf(idProdutoMae));
		hql = hql.replaceAll("::idProdutoFilho", String.valueOf(idProdutoFilho));

		Query q = this.getDaoSession().createQuery(hql);

		List<OmProaltglo> listaOmproaltglo = null;
		try {
			listaOmproaltglo = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ((listaOmproaltglo == null) || (listaOmproaltglo.size() <= 0) ? false : true);
	}

	public static void main(String[] args) {
		ProdutoRN rn = new ProdutoRN();
		rn.iniciaConexaoBanco();
		System.out.println(rn.isExisteOmProaltglo("A2BA00000007", "000000"));
		rn.finalizaConexaoBanco();
	}

	public boolean isExisteOmProaltglo(String cdProdutoMae, String cdProdutoFilho) {

		MapQuery q = new MapQuery(getDaoSession());

		q.append("select t ");
		q.append("from OmProaltglo t ");
		q.append("where  ");
		q.append("t.omProdutoByIdProdutoMae.cdProduto=:cdprodutomae and ");
		// Luiz 20190312 Modifiquei o filtro de substring para filtro exato, pois isso pode gerar erro de alimentação
		//q.append(":cdprodutofilho like '%' || t.omProdutoByIdProdutoFilho.cdProduto || '%'");
		q.append("t.omProdutoByIdProdutoFilho.cdProduto=:cdprodutofilho");

		q.defineParametro("cdprodutomae", cdProdutoMae);
		q.defineParametro("cdprodutofilho", cdProdutoFilho);

		List<OmProaltglo> listaOmproaltglo = null;
		try {
			listaOmproaltglo = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (((listaOmproaltglo == null) || (listaOmproaltglo.size() <= 0) ? false : true)) {
			logCF.info("Tentativa errada com o código: " + cdProdutoFilho);
		}
		return ((listaOmproaltglo == null) || (listaOmproaltglo.size() <= 0) ? false : true);
	}

	public boolean isImportadoEmOmProaltglo(String cdProdutoMae,
			String cdProdutoFilho) {

		String hql = "";
		hql += "select t ";
		hql += "from OmProaltglo t ";
		hql += "join fetch t.omProdutoByIdProdutoMae omProdutoByIdProdutoMae ";
		hql += "join fetch t.omProdutoByIdProdutoFilho omProdutoByIdProdutoFilho ";
		hql += "where  ";
		hql += "omProdutoByIdProdutoMae.cdProduto='::cdProdutoMae' and ";
		hql += "omProdutoByIdProdutoFilho.cdProduto='::cdProdutoFilho' ";

		hql = hql.replaceAll("::cdProdutoMae", String.valueOf(cdProdutoMae));
		hql = hql
				.replaceAll("::cdProdutoFilho", String.valueOf(cdProdutoFilho));

		Query q = this.getDaoSession().createQuery(hql);

		List<OmProaltglo> listaOmproaltglo = null;
		try {
			listaOmproaltglo = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ((listaOmproaltglo == null) || (listaOmproaltglo.size() <= 0) ? false
				: true);
	}

	public boolean isProdutoEAlternativo(String cdProduto, String cdProdutoLido) {
		return this.isExisteOmProaltglo(cdProduto, cdProdutoLido);
	}

	/**
	 * @deprecated Substituido pelo Util.extraiPorMascara
	 * @param cb
	 * @param mascara
	 * @return
	 */
	@Deprecated
	public String extraiProduto(String cb, String mascara) {
		/**
		 * @DEPRECATED O padr�o da etiqueta do produto: a. AAAAA - 5 primeiras posições = código do produto (sku=modelo) b. B = 1 posi��oo =
		 *             voltagem A=110 B=220v c. C = 1 posi��oo = cor d. D = 1 posi��oo = vers�o do produto, exemplo A, B, C. Quando uma nova
		 *             vers�o é criada, a vers�o anterior se torna obsoleta e deixa de ser produzida. e. EE = 2 posições = se o produto é
		 *             para o mercado NA (nacional) ou internacional. f. FFFFFFFFF = 9 posições = número de série do produto. g. GG = 2
		 *             posições = uso n�o identificado.
		 *
		 *             retornar AAAAA
		 **/

		/**
		 * SessaoDTO deve ter o campo om_cfg.mascaraCdProdutoPai, que terá o conteudo
		 *
		 * ??????--??
		 *
		 * assim retorno = CB nas posicoes onde aparece o ?, por exemplo
		 *
		 * CB = 1234567890ABCDEF
		 *
		 * retorno sera = 12345690
		 *
		 */

		char[] cCb = cb.toCharArray();
		char[] cMascara = mascara.toCharArray();
		StringBuilder sbCdProduto = new StringBuilder();

		String codigoProduto = null;

		try {
			for (int iCont = 0; iCont < cMascara.length; iCont++) {
				if (cMascara[iCont] == '?') {
					sbCdProduto.append(cCb[iCont]);
				}
			}
			codigoProduto = sbCdProduto.toString();
		} catch (Exception e) {
			codigoProduto = cb;
		}

		return (codigoProduto);
	}

	public OmProduto getProdutoByCdEStAtivo(String cdProduto) {
		MapQuery q = null;

		if (getDaoSession() != null)
			q = new MapQuery(this.getDaoSession());
		else {
			try {
				q = new MapQuery(this.getDaoSessionStatless());
			} catch (SemSessaoHibernateException e) {
			}
		}

		q.append("select omproduto ");
		q.append("from OmProduto omproduto ");
		q.append("where omproduto.cdProduto = :cdProduto ");

		q.append("and omproduto.stAtivo = 1");
		q.append("order by omproduto.idProduto desc");

		q.defineParametro("cdProduto", cdProduto);
		q.query().setMaxResults(1);

		OmProduto oOmProduto = null;

		oOmProduto = (OmProduto) q.query().uniqueResult();

		if (oOmProduto != null)
			return (oOmProduto.clone());
		return null;
	}

	public OmProduto getProdutoByDepara(String cdProduto) {
		String hql = "";

		// select * from om_produto where cd_produto = produto and st_ativo = 1

		hql += "SELECT omproduto ";
		hql += "FROM OmProduto omproduto ";
		hql += "WHERE (omproduto.cdProduto = '::cdProduto') AND ";
		hql += "(omproduto.stAtivo = 1) ";

		hql = hql.replaceAll("::cdProduto", cdProduto);

		OmProduto oOmProduto = null;
		try {
			oOmProduto = Util.getDadosBanco(new OmProduto(), this.getDaoSession(),
					hql);
		} catch (SemSGBDException e) {
			// TODO: ?????????????????????
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
			oOmProduto = null;
		}

		return (oOmProduto);
	}

	public ComponenteDTO verificaComponente(ComponenteDTO componente) {
		ComponenteDTO retorno = new ComponenteDTO();
		// pegando configuracao geral do sistema
		OmCfg oOmCfg = null;
		oOmCfg = Util.getConfigGeral(this.getDaoSession());
		if (oOmCfg == null) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getSEM_CONFIGURACAO());
			return retorno;
		}

		// extrai codigo do produto do codigo de barras
		// produto = acoplamento.cb usando om_cfg.mascaraCdProdutoFilho
		String cdProduto = Util.extraiPorMascara(componente.getCb(), oOmCfg.getMascaracdprodutomp());

		// verifica se o produto filho (componente) existe
		OmProduto oOmProduto = null;
		try {
			oOmProduto = this.getOmProdutoAgrupador(cdProduto);
		} catch (RegistroDesconhecidoException e) {
			oOmProduto = null;
		}

		// se n�o existir registro
		if (oOmProduto == null) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getCOMPONENTE_DESCONHECIDO());
		} else { // se existir
			retorno.setIdProduto(oOmProduto.getIdProduto()); // = id_produto do 1o registro encontrado
			retorno.getResultado().setIdmensagem(retorno.getResultado().getCOM_SUCESSO());
		}

		return retorno;
	}

	public OmProduto getOmProdutoComponente(String cdProduto)
			throws RegistroDesconhecidoException {

		String hql = "";
		hql += "select t ";
		hql += "from OmProduto t ";
		hql += "where  ";
		hql += "t.cdProduto='::cdProduto:' and ";
		hql += "t.stAtivo = 1 and t.tpProduto = 1 ";
		hql += "order by t.revisao desc ";

		hql = hql.replaceAll("::cdProduto:", cdProduto);

		Query q = this.getDaoSession().createQuery(hql);

		List<OmProduto> listaOmproduto = null;
		try {
			listaOmproduto = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if ((listaOmproduto == null) || (listaOmproduto.size() <= 0)) {
			throw new RegistroDesconhecidoException();
		}

		OmProduto retorno = listaOmproduto.get(0);

		return retorno;
	}

	public OmProduto getOmProdutoAgrupador(String cdProduto)
			throws RegistroDesconhecidoException {

		String hql = "";
		hql += "select t ";
		hql += "from OmProduto t ";
		hql += "where  ";
		hql += "t.cdProduto='::cdProduto:' and ";
		hql += "t.stAtivo = 1 and t.tpProduto = 2 ";
		hql += "order by t.revisao desc ";

		hql = hql.replaceAll("::cdProduto:", cdProduto);

		Query q = this.getDaoSession().createQuery(hql);

		List<OmProduto> listaOmproduto = null;
		try {
			listaOmproduto = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if ((listaOmproduto == null) || (listaOmproduto.size() <= 0)) {
			throw new RegistroDesconhecidoException();
		}

		OmProduto retorno = listaOmproduto.get(0);

		return retorno;
	}

	public List<OmProcomest> getOmProcomest(Long idProduto) {
		MapQuery q = new MapQuery(this.getDaoSession());

		q.append("from OmProcomest omprocomest ");
		q.append("omprocomest.omProdutoByIdProduto.idProduto = :idProduto");

		q.defineParametro("idProduto", idProduto);

		return q.list();
	}

	/* Metodo chamado pelo webservice para realizar a importacao da estrutura do produto */
	public ProdutoDTO importarPlanilhaEstruturaProduto(ProdutoDTO produto) {
		this.log = new IdwLogger("ImportarPlanilhaEstruturaProduto");
		int idLog = this.log.getIdAleatorio();
		this.log.iniciaAvaliacao(idLog, "ImportarPlanilhaEstruturaProduto");
		// Chama a rotina de inclus�o recursiva da estrutura do produto
		ProdutoDTO retorno = new ProdutoDTO();
		retorno.setResultadoEvento(retorno.getEVENTO_BEM_SUCEDIDO());
		try {
			retorno.setProduto(this.incluirEstruturaProduto(0, produto.getProduto(), false, null, null, null, true).clone());
		} catch (ClienteDesconhecidoException e) {
			retorno.setResultadoEvento(retorno.getERRO_CLIENTE_DESCONHECIDO());
		} catch (ItemDentroSubItemReferenciaCircularException e) {
			retorno.setResultadoEvento(retorno.getERRO_ITEM_DENTRO_DE_SEU_SUBITEM());
			retorno.setERRO_COMPLEMENTO(e.getMessage());
		}
		this.log.paraAvaliacao(this.getDao());
		return retorno;
	}

	public OmProduto integrarProduto(OmProduto produto, List<String> produtosIntegrados,
			Map<String, OmProduto> produtosPersistidosEnvolvidos, boolean isApagarEstrutura)
			throws ClienteDesconhecidoException, ItemDentroSubItemReferenciaCircularException {
		return this.incluirEstruturaProduto(0, produto, true, null, produtosIntegrados, produtosPersistidosEnvolvidos, isApagarEstrutura);
	}

	/**
	 * Apaga toda a estrutura dos produtos indicados no parametro
	 * 
	 * @param idProdutos
	 */
	public void apagarEstruturasProdutos(List<Long> idProdutos) {

		if (idProdutos.isEmpty() == false) {

			MapQuery q = new MapQuery(this.getDaoSession());

			q.append("delete from OmProcomest omProcomest");
			q.append("where (");

			for (int i = 0; i < idProdutos.size(); i++) {
				if (i != 0) {
					q.appendOR();
				}
				q.append(" omProcomest.omProdutoByIdProduto.idProduto = :idProduto" + i);
			}
			q.append(")");

			int i = 0;
			for (Long idProduto : idProdutos) {
				q.defineParametro("idProduto" + i, idProduto);
				i++;
			}

			q.query().executeUpdate();
		}

	}

	/**
	 * Apaga toda a estrutura do produto indicado no parametro
	 * 
	 * @param idProduto
	 */
	private void apagarEstruturaProduto(long idProduto) {
		MapQuery q = new MapQuery(this.getDaoSession());

		q.append("delete from OmProcomest omProcomest");
		q.append("where omProcomest.omProdutoByIdProduto.idProduto = :idProduto");
		q.defineParametro("idProduto", idProduto);

		q.query().executeUpdate();
	}

	/**
	 * Atualiza dados do produto, e apaga a sua composi��oo/estrutura atual
	 * 
	 * @param omproduto
	 * @param isIntegracao
	 * @param produtos
	 *            lista de produtos, se estiver preenchida, procura nela, caso contrário, procura no banco de dados
	 * @return
	 * @throws ClienteDesconhecidoException
	 */
	private OmProduto atualizarProduto(OmProduto omproduto, boolean isIntegracao, Map<String, OmProduto> produtos)
			throws ClienteDesconhecidoException {
		// Verifica se produto existe
		OmProduto p = null;
		OmUsr omusr = this.getDao().findById(OmUsr.class, omproduto.getOmUsrByIdUsrrevisao().getIdUsr(), false);
		Date dataHoraAtual = DataHoraRN.getDataHoraAtual();
		try {

			// if(produtos != null){
			// p = produtos.get(omproduto.getCdProduto());
			// if(p == null){
			// throw new RegistroDesconhecidoException();
			// }
			// }else {
			// p = getOmProduto(omproduto.getCdProduto(), false, true, true);
			// }

			if (produtos != null) {
				p = produtos.get(omproduto.getCdProduto());
			}

			if (p == null) {
				p = getOmProduto(omproduto.getCdProduto(), false, true, true);

				if (produtos != null) {
					produtos.put(p.getCdProduto(), p);
				}
			}

			/*
			 * Só atualiza se a propriedade estiver diferente. Útil no caso de ser tudo igual o hibernate n�o lançará para o banco o update.
			 * Quanto menor o acesso ao banco de dados, melhor a performance.
			 */
			boolean isHouveAlteracao = false;

			if (new EqualsBuilderIdw().append(p.getTpProduto(), omproduto.getTpProduto()).isEquals() == false) {
				isHouveAlteracao = true;
				p.setTpProduto(omproduto.getTpProduto());
			}

			// Só atualiza se estiver diferente
			if (omproduto.getDsProduto().equals("") == false
					&& new EqualsBuilderIdw().append(p.getDsProduto(), omproduto.getDsProduto()).isEquals() == false) {
				isHouveAlteracao = true;
				p.setDsProduto(omproduto.getDsProduto());
			}

			if (new EqualsBuilderIdw().append(p.getTpOrigem(), omproduto.getTpOrigem()).isEquals() == false) {
				isHouveAlteracao = true;
				p.setTpOrigem(omproduto.getTpOrigem());
			}

			if (new EqualsBuilderIdw().append(p.getTpSemiacabado(), omproduto.getTpSemiacabado()).isEquals() == false) {
				isHouveAlteracao = true;
				p.setTpSemiacabado(omproduto.getTpSemiacabado());
			}

			if (new EqualsBuilderIdw().append(p.getTpClasseabc(), omproduto.getTpClasseabc()).isEquals() == false) {
				isHouveAlteracao = true;
				p.setTpClasseabc(omproduto.getTpClasseabc());
			}

			if (new EqualsBuilderIdw().append(p.getVlCustounit(), omproduto.getVlCustounit()).isEquals() == false) {
				isHouveAlteracao = true;
				if (omproduto.getVlCustounit() == null) {
					p.setVlCustounit(BigDecimal.ZERO);
				} else {
					p.setVlCustounit(omproduto.getVlCustounit().setScale(6, BigDecimal.ROUND_HALF_DOWN));
				}
			}

			if (p.getHrLeadtimeentrada() == null) {
				isHouveAlteracao = true;
				p.setHrLeadtimeentrada(new BigDecimal(24));
			}

			if (p.getHrLeadtimesaida() == null) {
				isHouveAlteracao = true;
				p.setHrLeadtimesaida(new BigDecimal(24));
			}

			if (p.getStAtivo().byteValue() == 0) {
				isHouveAlteracao = true;
				p.setStAtivo((byte) 1);
			}

			// Atualizar Unidade medida
			if (omproduto.getOmUnidmedida() != null) {

				// Só atualiza unidade de medidda, se código for diferente
				if (p.getOmUnidmedida() == null
						|| omproduto.getOmUnidmedida().getCdUnidmedida().equals(p.getOmUnidmedida().getCdUnidmedida()) == false) {

					OmUnidmedida omUnidmedida =
							getOmUnidmedidaGeraNovoSeNaoEncontrar(omproduto.getOmUnidmedida().getCdUnidmedida(), dataHoraAtual, omusr);
					p.setOmUnidmedida(omUnidmedida);
					isHouveAlteracao = true;

				}

			}

			/*
			 * TODO milton PpCliente deve ser atualizado? Quando produto n�o é encontrado, e é criado no exceptions deste trecho, ele é
			 * criado. Mas quando existe, n�o há essa atualiza��oo. Se tiver realmente que atualizar. Lembrar de pegar o OmProduto já com o
			 * PpCliente carregado. E só atualizar, se forem diferentes
			 *
			 */

			// Atualiza Cliente
			if (omproduto.getPpCliente() != null) {

				// Só atualiza cliente, se código for diferente
				if (p.getPpCliente() == null
						|| (omproduto.getPpCliente().getCdCliente().equals("") == false
								&& omproduto.getPpCliente().getCdCliente().equals(p.getPpCliente().getCdCliente()) == false)) {

					if (omproduto.getPpCliente().getCdCliente().equals("") == false) {
						ClienteRN clienteRN = new ClienteRN(this.getDao());
						PpCliente ppCliente = clienteRN.getPpClienteGeraNovoSeNaoEncontrar(omproduto.getPpCliente().getCdCliente(),
								isIntegracao, dataHoraAtual, omusr);

						p.setPpCliente(ppCliente);
						isHouveAlteracao = true;
					}
				}

			}

			// Só chama procedimento de atualiza��oo no banco de dados se realmente houve altera��oo na instancia do pojo
			if (isHouveAlteracao) {

				p.setDtRevisao(dataHoraAtual);
				p.setDtStativo(dataHoraAtual);

				if (p.getRevisao() != null) {
					p.setRevisao(p.getRevisao() + 1);
				} else {
					p.setRevisao(1l);
				}

				p.setOmUsrByIdUsrrevisao(omusr);
				p.setOmUsrByIdUsrstativo(omusr);

				this.getDao().makePersistent(p);
			}

		} catch (RegistroDesconhecidoException e1) {
			// Se n�o existir, incluir o produto
			p = omproduto.clone();
			p.setTpProduto(omproduto.getTpProduto());
			p.setDtRevisao(dataHoraAtual);
			p.setDtStativo(dataHoraAtual);
			p.setStAtivo((byte) 1);
			p.setOmFor(null);
			p.setRevisao(1l);
			p.setOmCc(null);
			p.setOmCfgs(null);
			p.setOmMapapas(null);
			p.setOmMapas(null);
			p.setOmProgrp(null);
			p.setOmProcomestsForIdProduto(null);
			p.setOmProdutoByIdProdutoagru(null);
			p.setHrLeadtimeentrada(new BigDecimal(24));
			p.setHrLeadtimesaida(new BigDecimal(24));
			p.setVlCustounit(BigDecimal.ZERO);
			// Atualizar Unidade medida
			if (omproduto.getOmUnidmedida() != null) {
				OmUnidmedida omUnidmedida =
						getOmUnidmedidaGeraNovoSeNaoEncontrar(omproduto.getOmUnidmedida().getCdUnidmedida(), dataHoraAtual, omusr);
				p.setOmUnidmedida(omUnidmedida);
			}

			// Seta usuarios
			p.setOmUsrByIdUsrrevisao(omusr);
			p.setOmUsrByIdUsrstativo(omusr);

			// Trata atualiza��oo do campo cliente se estiver preenchido
			if (omproduto.getPpCliente() != null && omproduto.getPpCliente().getCdCliente().equals("") == false) {
				ClienteRN clienteRN = new ClienteRN(this.getDao());

				PpCliente ppCliente = clienteRN.getPpClienteGeraNovoSeNaoEncontrar(omproduto.getPpCliente().getCdCliente(), isIntegracao,
						dataHoraAtual, omusr);

				p.setPpCliente(ppCliente);
			}
			p.setPpCliente(null);
			this.getDao().makePersistent(p);
			if (produtos != null) {
				produtos.put(p.getCdProduto(), p);
			}

		}

		return p;
	}

	/**
	 * Incluir o produtos e toda a sua estrutura.
	 * <p>
	 * Faz valida��oo de recursividade de relacionamento. No caso abaixo há recursividade no prod1, pois ele está dentro de um de seus
	 * filhos
	 * <p>
	 * >prod1 <br>
	 * ->prod2 <br>
	 * -->prod3 <br>
	 * --->prod 1
	 *
	 * @param nivel
	 * @param omproduto
	 * @param isIntegracao
	 * @param cdProdutosPai
	 *            guardas o cdProduto dos itens pai, para validar se há recursividade. Ex: prod1 -> prod2 -> prod3 -> prod1
	 * @param cdProdutosIntegrados
	 *            lista os produtos que já foram integrados na opera��oo
	 * @param produtosPersistidosEnvolvidos
	 *            se estiver nulo, faz a pesquisa do produto no banco de dados e n�o na cole��oo
	 * @param isApagarEstrutura
	 *            indica se irá apagar ou n�o a estrutura. Como exclus�o da estrutura pode ser feita antes deste trecho, realizado com bloco
	 *            de todos os itens envolvidos, n�o há a necessida de chamar aqui. Feito para otimizar a performance.
	 * @return
	 * @throws ClienteDesconhecidoException
	 * @throws ItemDentroSubItemReferenciaCircularException
	 */
	private OmProduto incluirEstruturaProduto(int nivel, OmProduto omproduto, boolean isIntegracao, List<String> cdProdutosPai,
			List<String> cdProdutosIntegrados, Map<String, OmProduto> produtosPersistidosEnvolvidos, boolean isApagarEstrutura)
			throws ClienteDesconhecidoException, ItemDentroSubItemReferenciaCircularException {

		// 28.08.13 milton - uso do log em comentado para agilizar o processamento
		// this.log.info(idLog, nivel, nivel + " - " + omproduto.getCdProduto());
		if (omproduto != null && omproduto.getCdProduto() != null)
			omproduto.setCdProduto(omproduto.getCdProduto().trim());

		OmProduto omprodutoPersistente = null;

		// Chama a rotina de inclusao e atualizacao do produto
		omprodutoPersistente = this.atualizarProduto(omproduto, isIntegracao, produtosPersistidosEnvolvidos);

		if (cdProdutosPai == null) {
			cdProdutosPai = new ArrayList<String>();
		}

		cdProdutosPai.add(omproduto.getCdProduto());

		if (cdProdutosIntegrados == null) {
			cdProdutosIntegrados = new ArrayList<String>();
		}

		if (cdProdutosIntegrados.contains(omproduto.getCdProduto())) {

			// 28.08.13 milton - uso do log em comentado para agilizar o processamento
			// this.log.info(idLog,nivel, "Estrutura de " + omproduto.getCdProduto() + " n�o será integrada. Pois já foi integrada durante
			// opera��oo");

		} else {

			if (isApagarEstrutura) {
				// remove todas a composi��oo do produto
				apagarEstruturaProduto(omprodutoPersistente.getIdProduto());
			}

			// Varrer a estrtutura do omproduto
			for (OmProcomest omprocomest : omproduto.getOmProcomestsForIdProduto()) {

				String cdProdFilho = omprocomest.getOmProdutoByIdProdutomp().getCdProduto().trim();
				omprocomest.getOmProdutoByIdProdutomp().setCdProduto(cdProdFilho);
				if (cdProdutosPai.contains(cdProdFilho)) {
					throw new ItemDentroSubItemReferenciaCircularException(
							"Produto pai esta dentro de um de seus subitens. Avaliando subitem " + cdProdFilho + ". Produtos Pai: "
									+ cdProdutosPai.toString());
				}

				OmProduto omprodutoMP = null;

				// Se a estrutura varrida tiver um produto que tenha tambem sua estrutura, chamar incluirEstruturaProduto recursivamente
				if ((omprocomest.getOmProdutoByIdProdutomp().getOmProcomestsForIdProduto() != null)
						&& (omprocomest.getOmProdutoByIdProdutomp().getOmProcomestsForIdProduto().size() > 0)) {
					// 28.08.13 milton - uso do log em comentado para agilizar o processamento
					// this.log.info(idLog,nivel, omprocomest.getOmProdutoByIdProdutomp().getOmProcomestsForIdProduto());
					omprodutoMP = this.incluirEstruturaProduto(nivel + 1, omprocomest.getOmProdutoByIdProdutomp(), isIntegracao,
							cdProdutosPai, cdProdutosIntegrados, produtosPersistidosEnvolvidos, isApagarEstrutura);
				} else {

					// 28.08.13 milton - uso do log em comentado para agilizar o processamento
					// this.log.info(idLog, nivel+1, (nivel+1) + " - " + omprocomest.getOmProdutoByIdProdutomp().getCdProduto());

					// Se a estrutura varrida nao tiver um produto com estrutura, entao fazer as verificacoes de existencia e atualizacao
					// desse produto
					// Obtem o produtoMP da estrutura
					omprodutoMP =
							this.atualizarProduto(omprocomest.getOmProdutoByIdProdutomp(), isIntegracao, produtosPersistidosEnvolvidos);

					if (isApagarEstrutura) {
						// remove todas a composi��oo do produto. N�o possui subitens, ent�o é matéria-prima
						apagarEstruturaProduto(omprodutoMP.getIdProduto());
					}

				}

				// Para cada estrutura deve-se já setar o produto pai persistente
				omprocomest.setOmProdutoByIdProduto(omprodutoPersistente);
				omprocomest.setOmProdutoByIdProdutomp(omprodutoMP);
				if (OmProdutoTemplate.TpProduto.SEMI_ACABADO.equals(omprodutoMP.getTpProduto())) {
					omprocomest.setTpProcomest(OmProcomestTemplate.TpProcomest.SEMI_ACABADO.getId());
				} else {
					omprocomest.setTpProcomest(OmProcomestTemplate.TpProcomest.MATERIA_PRIMA.getId()); // qualquer outra coisa que nao seja
																										// semi-acabado sera identificado
																										// como materia-prima
				}

				// Salva a estrutura
				// Para o sqlserver qdo omprocomest.qtUsada tem mais de 4 casas decimais, da um erro de cast
				// Assim, vamos arredondar quando houver mais de 4 casas
				omprocomest.setQtUsada(omprocomest.getQtUsada().setScale(4, RoundingMode.HALF_EVEN));

				// 28.08.13 milton - uso do log em comentado para agilizar o processamento
				// log.info(idLog, 0, omprocomest.getQtUsada());
				this.getDao().makePersistent(omprocomest);
			}
		}

		cdProdutosPai.remove(omproduto.getCdProduto());
		cdProdutosIntegrados.add(omproduto.getCdProduto());

		return omprodutoPersistente;
	}

	public OmProcomest obtemEstruturaProduto(IdwLogger log, int idLog, int identacao, OmProduto omprodutoPai, OmProduto omprodutoFilho) {
		OmProcomest retorno = null;

		retorno = new OmProcomest();
		retorno.setQtUsada(BigDecimal.ONE);
		return retorno;

	}

	public PesquisasDTO pesquisaOmprodutoExcessaoProdutoFinal(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from OmProduto t ";
		hql += "where t.stAtivo=1 and t.tpProduto != 0 ";

		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdProduto = '::cdProduto' or t.dsProduto = '::dsProduto' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdProduto = '::cdProduto' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsProduto = '::dsProduto' ";
		}

		hql = hql.replaceAll("::cdProduto", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsProduto", pesquisa.getDescricao());

		Query q = this.getDaoSession().createQuery(hql);

		List<OmProduto> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmProduto item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdProduto());
				itemDTO.setDescricao(item.getDsProduto());
				itemDTO.setRegistro(item.clone());
				this.getDao().evict(item);
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	/**
	 * Desativa todos os registros da tabela de produtos
	 * 
	 * @param dataHoraDesativacao
	 * @param omUsrOperacao
	 *            Usuário que desativou o produto
	 */
	public void desativarOmProdutos(Date dataHoraDesativacao, OmUsr omUsrOperacao) {
		this.getDao().desativarMuitos(OmProduto.class, OmProdutoTemplate._FIELD_NAME_CD, null, false, dataHoraDesativacao, omUsrOperacao);
	}

	/**
	 * Desativa registros da tabela de produtos
	 * 
	 * @param listaOmPRodutoDevemFicarAtivos
	 *            Lista de códigos de devem ficar permanecer ativos
	 * @param dataHoraDesativacao
	 * @param omUsrOperacao
	 *            Usuário que desativou a usr
	 */
	public void desativarOmProdutos(List<String> listaOmPRodutoDevemFicarAtivos, Date dataHoraDesativacao, OmUsr omUsrOperacao) {
		if (listaOmPRodutoDevemFicarAtivos.size() <= 2100) {
			this.getDao().desativarMuitos(OmProduto.class, OmProdutoTemplate._FIELD_NAME_CD, listaOmPRodutoDevemFicarAtivos, true,
					dataHoraDesativacao, omUsrOperacao);
		} else {
			List<OmProduto> lista = getTodosProdutosAtivos();
			for (OmProduto omproduto : lista) {
				// Nao desativar o produto desconhecido
				if (omproduto.getCdProduto().equals("0"))
					continue;

				if (listaOmPRodutoDevemFicarAtivos.contains(omproduto.getCdProduto()) == false) {
					omproduto.setStAtivo((byte) 0);
					getDao().makePersistent(omproduto);
				}
			}
		}
	}

	/**
	 * Desativa relacionado ao código
	 * 
	 * @param cdProduto
	 * @param date
	 * @param omUsrOperacao
	 *            usuário que está desativando
	 * @throws RegistroJaDesativadoException
	 * @throws RegistroDesconhecidoException
	 */
	public void desativarProduto(String cdProduto, Date date, OmUsr omUsrOperacao)
			throws RegistroDesconhecidoException, RegistroJaDesativadoException {
		this.getDao().desativar(OmProduto.class, cdProduto, OmProdutoTemplate._FIELD_NAME_CD, null, date, omUsrOperacao);
	}

	/**
	 * Desativa {@code OmProdtuo} relacionado ao id do produto
	 * 
	 * @param idProduto
	 * @param date
	 * @param omUsrOperacao
	 * @throws RegistroJaDesativadoException
	 */
	public void desativarProduto(long idProduto, Date date, OmUsr omUsrOperacao) throws RegistroJaDesativadoException {
		this.getDao().desativar(OmProduto.class, idProduto, date, omUsrOperacao);
	}

	/**
	 * Pega última revis�o de {@code OmProduto} com pojo ativado, relacionado com o código do produto
	 * 
	 * @param cdProduto
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public OmProduto getOmProduto(String cdProduto) throws RegistroDesconhecidoException {
		return getOmProduto(cdProduto, true, false, false);
	}

	/**
	 * Pega última revis�o de {@code OmProduto} com pojo ativado, relacionado com o código do produto
	 * 
	 * @param cdProduto
	 * @param isJoinOmUnidmedida
	 * @param isJoinPpCliente
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public OmProduto getOmProduto(String cdProduto, boolean isApenasAtivado, boolean isJoinOmUnidmedida, boolean isJoinPpCliente)
			throws RegistroDesconhecidoException {
		StringBuilder sb = new StringBuilder();
		if (isJoinOmUnidmedida) {
			sb.append(ProdutoRN.getHqlLeftJoinProdutoComUnidadeMedida("omProduto", ""));
		}
		if (isJoinPpCliente) {
			sb.append(ProdutoRN.getHqlLeftJoinProdutoComCliente("omProduto", ""));
		}
		return this.getDao().findByCd(OmProduto.class, cdProduto, OmProdutoTemplate._FIELD_NAME_CD, null, isApenasAtivado, sb.toString());
	}

	public List<OmProduto> getOmProdutos(Set<String> cdProdutos, boolean isJoinOmUnidmedida, boolean isJoinPpCliente)
			throws RegistroDesconhecidoException {
		StringBuilder sb = new StringBuilder();
		if (isJoinOmUnidmedida) {
			sb.append(ProdutoRN.getHqlLeftJoinProdutoComUnidadeMedida("omProduto", ""));
		}
		if (isJoinPpCliente) {
			sb.append(ProdutoRN.getHqlLeftJoinProdutoComCliente("omProduto", ""));
		}
		return this.getDao().findByCds(OmProduto.class, cdProdutos, OmProdutoTemplate._FIELD_NAME_CD, null, true, sb.toString());
	}

	/**
	 * Pega {@code OmProduto} relacionado com o id do produto
	 * 
	 * @param idProduto
	 * @return
	 */
	public OmProduto getOmProduto(long idProduto) {
		return this.getDao().findById(OmProduto.class, idProduto, false);
	}

	/**
	 * Salvar unidade de medida, desativando o id antigo, e gerando um novo id para o novo
	 * 
	 * @param omUnidmedidaOld
	 * @param omUnidmedida
	 * @param dateOperacao
	 * @param omUsrOperacao
	 * @return
	 */
	public OmUnidmedida salvarDesativandoOriginalOmUnidmedida(OmUnidmedida omUnidmedidaOld, OmUnidmedida omUnidmedida, Date dateOperacao,
			OmUsr omUsrOperacao) {
		return this.getDao().salvarDesativandoOriginal(omUnidmedidaOld, omUnidmedida, dateOperacao, omUsrOperacao);
	}

	public OmProduto salvarDesativandoOriginal(OmProduto omProdutoOld, OmProduto omProduto, Date dateOperacao, OmUsr omUsrOperacao) {
		if (omProdutoOld != null) {

			// Deixa o id da nova vers�o com o mesmo número
			omProduto.setIdProduto(omProdutoOld.getIdProduto());

			// Muda o id, para gerar um novo id para a antiga vers�o
			omProdutoOld.setIdProduto(0L);
		}
		return this.getDao().salvarDesativandoOriginal(omProdutoOld, omProduto, dateOperacao, omUsrOperacao);
	}

	public OmProduto salvarRevisaoOmProduto(OmProduto omProdutoOld, OmProduto omProdutoNew, Date dateOperacao, OmUsr omUsrOperacao) {
		return this.getDao().salvarDeixandoOriginal(omProdutoOld, omProdutoNew, dateOperacao, omUsrOperacao);
	}

	/*
	 * Pesquisa a relacao de produtos que sao pai de determinao produto
	 */
	public ProdutosDTO pesquisarProdutosPaiDisponiveis(Long idProduto) {

		ProdutosDTO retorno = new ProdutosDTO();

		retorno.setProdutos(new ArrayList<ProdutoDTO>());
		retorno.getProdutos().addAll(pesquisarProdutosPaiDisponiveisRecursivamente(idProduto));

		return retorno;
	}

	private List<ProdutoDTO> pesquisarProdutosPaiDisponiveisRecursivamente(Long idProduto) {
		MapQuery q = new MapQuery(getDao().getSession());

		q.append("select omprocomest");
		q.append("from OmProcomest omprocomest");
		q.append("join omprocomest.omProdutoByIdProduto omproduto");
		q.append("where omprocomest.omProdutoByIdProdutomp.idProduto = :idproduto");
		q.append("and omproduto.tpProduto != 0");
		q.defineParametro("idproduto", idProduto);
		List<OmProcomest> lista = q.list();

		List<ProdutoDTO> retorno = new ArrayList<ProdutoDTO>();

		for (OmProcomest pojo : lista) {
			ProdutoDTO p = new ProdutoDTO();
			p.setProduto(pojo.getOmProdutoByIdProduto().clone(false));

			retorno.add(p);

			// Chama o metodo recursivamente para pegar os pais dos pais
			retorno.addAll(pesquisarProdutosPaiDisponiveisRecursivamente(pojo.getOmProdutoByIdProduto().getIdProduto()));
		}

		return retorno;
	}

	public OmProduto incluirComponente(OmProduto omproduto) {
		return getDao().makePersistent(omproduto);
	}

	/**
	 * Pega unidade de medida ativa
	 * 
	 * @param cdUnidmedida
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public OmUnidmedida getOmUnidmedida(String cdUnidmedida) throws RegistroDesconhecidoException {
		return this.getOmUnidmedida(cdUnidmedida, true);
	}

	/**
	 * Pega unidade de medida ativa, se n�o existe cria um novo
	 * 
	 * @param cdUnidmedida
	 * @param dateOperacao
	 * @param omUsrOperacao
	 * @return
	 */
	public OmUnidmedida getOmUnidmedidaGeraNovoSeNaoEncontrar(String cdUnidmedida, Date dateOperacao, OmUsr omUsrOperacao) {

		Validate.notEmpty(cdUnidmedida, "Código de unidade de medida vazio");
		try {
			return getOmUnidmedida(cdUnidmedida);
		} catch (RegistroDesconhecidoException e) {
			OmUnidmedida omUnidmedida = new OmUnidmedida();
			omUnidmedida.setCdUnidmedida(cdUnidmedida);
			omUnidmedida.setDsUnidmedida(cdUnidmedida);
			omUnidmedida.setStAtivo((byte) 1);
			return salvarDesativandoOriginalOmUnidmedida(null, omUnidmedida, dateOperacao, omUsrOperacao);
		}

	}

	public List<OmProduto> getTodosProdutosAtivos() {
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("select omproduto");
		q.append("from OmProduto omproduto");
		q.append("where omproduto.stAtivo = 1");
		q.append("order by omproduto.idProduto");
		return q.list();
	}

	public List<OmProduto> getTodosProdutosAcabadosESemiAtivos() {
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("select omproduto");
		q.append("from OmProduto omproduto");
		q.append("where omproduto.stAtivo = 1");
		q.append("and omproduto.tpProduto in (0, 3)"); // produtos acabados e semiacabados
		q.append("order by omproduto.idProduto");
		return q.list();
	}

	public static Map<String, OmProduto> getListaProdutoIndexCdProduto(Collection<OmProduto> produtos) {
		Map<String, OmProduto> map = new HashMap<String, OmProduto>();
		for (OmProduto omProduto : produtos) {
			map.put(omProduto.getCdProduto(), omProduto);
		}
		return map;
	}

	public Map<String, OmProduto> getTodosProdutosAtivosIndexCdProduto() {
		return getListaProdutoIndexCdProduto(getTodosProdutosAtivos());
	}

	public static String getHqlLeftJoinProdutoComGrupoProduto(String strOmProduto, String strOmProgrpAlias) {
		StringBuilder sb = new StringBuilder();
		sb.append(" LEFT JOIN FETCH ");
		sb.append(strOmProduto);
		sb.append(".omProgrp");
		sb.append(" ");
		if (StringUtils.isEmpty(strOmProgrpAlias)) {
			sb.append(strOmProgrpAlias);
		}
		return sb.toString();
	}

	public static String getHqlLeftJoinProdutoComUnidadeMedida(String strOmProduto, String strOmUnidMedidaAlias) {
		StringBuilder sb = new StringBuilder();
		sb.append(" LEFT JOIN FETCH ");
		sb.append(strOmProduto);
		sb.append(".omUnidmedida");
		sb.append(" ");
		if (StringUtils.isEmpty(strOmUnidMedidaAlias)) {
			sb.append(strOmUnidMedidaAlias);
		}
		return sb.toString();
	}

	public static String getHqlLeftJoinProdutoComCliente(String strOmProduto, String strPpClienteAlias) {
		StringBuilder sb = new StringBuilder();
		sb.append(" LEFT JOIN FETCH ");
		sb.append(strOmProduto);
		sb.append(".ppCliente");
		sb.append(" ");
		if (StringUtils.isEmpty(strPpClienteAlias)) {
			sb.append(strPpClienteAlias);
		}
		return sb.toString();
	}

	public static String getHqlLeftJoinProdutoComEstrutura(String stringOmProdutoInicialParaHql, int niveis, boolean isJoinUnidadeMedida,
			boolean isJoinClienteProduto) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sbItemPai = new StringBuilder(stringOmProdutoInicialParaHql);

		for (int i = 1; i <= niveis; i++) {

			StringBuilder sbItemFilhoApelido = new StringBuilder("omProcomest").append("_").append(i);
			sb.append(" LEFT JOIN FETCH ").append(sbItemPai).append(".omProcomestsForIdProduto ").append(sbItemFilhoApelido);

			sbItemPai = new StringBuilder("omProdutoByIdProdutomp").append("_").append(i);
			sb.append(" LEFT JOIN FETCH ").append(sbItemFilhoApelido).append(".omProdutoByIdProdutomp ").append(sbItemPai);

			if (isJoinUnidadeMedida) {
				sb.append(ProdutoRN.getHqlLeftJoinProdutoComUnidadeMedida(sbItemPai.toString(), ""));
			}
			if (isJoinClienteProduto) {
				sb.append(ProdutoRN.getHqlLeftJoinProdutoComCliente(sbItemPai.toString(), ""));
			}

		}
		return sb.toString();
	}

	/**
	 * Pega a unidade de medida
	 * 
	 * @param cdUnidmedida
	 * @param isFiltroAtivo
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public OmUnidmedida getOmUnidmedida(String cdUnidmedida, boolean isFiltroAtivo) throws RegistroDesconhecidoException {
		return this.getDao().findByCd(OmUnidmedida.class, cdUnidmedida, OmUnidmedida._FIELD_NAME_CD, null, isFiltroAtivo);
	}

	/**
	 * Pega os produtos e suas estruturas
	 * 
	 * @param listaOmProdutos
	 * @param tpProduto
	 * @return
	 * @see #getProdutoComEstrutura(OmProduto, idw.model.pojos.template.OmProdutoTemplate.TpProduto)
	 */
	public List<OmProduto> getProdutosComEstruturas(Collection<OmProduto> listaOmProdutos, OmProdutoTemplate.TpProduto tpProduto) {
		List<OmProduto> listaProdutosComEstruturas = new ArrayList<OmProduto>();
		for (OmProduto omProduto : listaOmProdutos) {
			listaProdutosComEstruturas.addAll(getProdutoComEstrutura(omProduto, tpProduto));
		}
		return listaProdutosComEstruturas;
	}

	/**
	 * Retorna uma lista de OmProduto que fazem parte da estrutura de omproduto e de seus filhos
	 * 
	 * @param omproduto
	 * @param tpProduto
	 * @return
	 */
	public List<OmProduto> getProdutoComEstrutura(OmProduto omproduto, OmProdutoTemplate.TpProduto tpProduto) {

		List<OmProduto> retorno = new ArrayList<OmProduto>();

		if (tpProduto == null || tpProduto.equals(omproduto.getTpProduto())) {
			retorno.add(omproduto);
		}

		for (OmProcomest omprocomest : omproduto.getOmProcomestsForIdProduto()) {

			if (tpProduto == null || tpProduto.equals(omprocomest.getOmProdutoByIdProdutomp().getTpProduto())) {
				retorno.add(omprocomest.getOmProdutoByIdProdutomp());
			}

			retorno.addAll(getProdutoComEstrutura(omprocomest.getOmProdutoByIdProdutomp(), tpProduto));

		}

		return retorno;

	}

	public List<OmProduto> getListaProdutosComTpProduto(Collection<OmProduto> produtos, OmProdutoTemplate.TpProduto... tpProdutos) {
		List<OmProduto> listaProdutosComTpProdutos = new ArrayList<OmProduto>();

		for (OmProduto omProduto : produtos) {
			if (omProduto.isTpProduto(tpProdutos)) {
				listaProdutosComTpProdutos.add(omProduto);
			}
		}

		return listaProdutosComTpProdutos;

	}

	/*
	 * Pesquisar todos os produtos finais que estao passando pelo turno de referencia Esse metodo é usado pela monitoriza��oo de roteiro
	 */
	public ProdutosDTO pesquisarProdutosFinaisNoTurno(Date dtReferencia, String cdTurno) {
		RoteiroRN rn = new RoteiroRN(getDao());

		ProdutosDTO retorno = new ProdutosDTO();
		retorno.setProdutos(new ArrayList<ProdutoDTO>());

		// Obter todos os dwrts da data e turno de referencia passados
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select dwrt");
		q.append("from DwRt dwrt");
		q.append("join fetch dwrt.dwConsolids dwconsolid");
		q.append("join fetch dwconsolid.dwFolha dwfolha");
		q.append("left join fetch dwfolha.dwFolhaiacs dwfolhaiac");
		q.append("left join fetch dwfolhaiac.omProduto omproduto");
		q.append("where dwrt.dtReferencia = :dtreferencia");
		q.append("and dwrt.dwTurno.cdTurno = :cdturno");
		q.defineParametro("dtreferencia", dtReferencia);
		q.defineParametro("cdturno", cdTurno);

		List<DwRt> lista = q.list();

		for (DwRt dwrt : lista) {
			for (DwConsolid dwconsolid : dwrt.getDwConsolids()) {
				// Obtem o pai maior do semiacabado
				// OmProduto omproduto = null;
				List<DwFolha> listaSemiacabados = new ArrayList<>();

				try {
					// omproduto = dwconsolid.getDwFolha().getDwFolhaiacs().iterator().next().getOmProduto();
					listaSemiacabados.add(dwconsolid.getDwFolha());
				} catch (Exception e) {
					// omproduto = null;
				}
				// Se nao encontrou produto, verificar os produtos das ferramentas
				// if (omproduto == null) {
				// for (DwFolharap dwfolharap : dwconsolid.getDwFolha().getDwFolharaps()) {
				// for (DwFolharapcom dwfolharapcom : dwfolharap.getDwFolharapcoms()) {
				// listaSemiacabados.add(dwfolharapcom.getOmProduto());
				// }
				// }
				// }

				// Se nao tiver produto definido, entao passar para o proximo dwrt
				if (listaSemiacabados.isEmpty()) {
					continue;
				}

				List<OmProduto> listaPai = new ArrayList<OmProduto>();

				/*
				 * Verificar se a folha do semiacabado tem roteiro. Se sim usar o produto do roteiro
				 *
				 */
				for (DwFolha folhasemi : listaSemiacabados) {
					List<DwRotapasso> passos = rn.pesquisarDwRotapassoDaFolha(folhasemi);
					for (DwRotapasso passo : passos) {
						if (passo.getDwRota().getStAtivo().equals((byte) 0))
							continue;
						listaPai.add(passo.getDwRota().getOmProduto());
					}
				}
				// for (OmProduto omprodutoSemiacabado : listaSemiacabados) {
				// List<OmProduto> pais = pesquisarProdutosPaiMaiorRecursivamente(omprodutoSemiacabado.getIdProduto());
				// listaPai.addAll(pais);
				// parametros.add(omprodutoSemiacabado.getCdProduto());
				// }

				// Inserir na lista de retorno se nao existir na lista
				for (OmProduto pai : listaPai) {
					retorno.addOmProduto(pai.clone(false));
				}
			}
		}
		return retorno;
	}

	public PesquisasDTO getOmProdutoFinalAtivo(PesquisaDTO filtro) {
		OmProdutoDAO produtoDAO = new OmProdutoDAO(getDaoSession());
		List<OmProduto> listaProdutosFinais;
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();
		if (filtro.getRegistro() != null) {
			PpNec pedido = (PpNec) filtro.getRegistro();
			listaProdutosFinais =
					produtoDAO.getOmProdutoFinalAtivoPorCdDsOuPedido(filtro.getCodigo(), filtro.getDescricao(), pedido.getIdNec());
		} else {
			listaProdutosFinais = produtoDAO.getOmProdutoFinalAtivoApartirDaRota(filtro.getCodigo(), filtro.getDescricao());
		}
		for (OmProduto produtoFinal : listaProdutosFinais) {
			PesquisaDTO itemDTO = new PesquisaDTO();
			itemDTO.setCodigo(produtoFinal.getCdProduto());
			itemDTO.setDescricao(produtoFinal.getDsProduto());
			itemDTO.setRegistro(produtoFinal.clone());
			listaDTO.add(itemDTO);
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}

	public static boolean isDsProdutoPadrao(OmProduto omProduto) {
		if (omProduto != null) {
			String dsProduto = omProduto.getDsProduto();
			return dsProduto.contains(TRECHO_DS_PADRAO_PRODUTO_1) || dsProduto.contains(TRECHO_DS_PADRAO_PRODUTO_2);
		}
		return false;
	}

	public PesquisasDTO getOmProdutosFinaisESemiAcabados(PesquisaDTO filtro) {
		OmProdutoDAO dao = new OmProdutoDAO(getDaoSession());
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();
		List<OmProduto> listaProdutos = dao.getOmprodutosFinaisESemiAcabados(filtro.getCodigo(), filtro.getDescricao());
		for (OmProduto produto : listaProdutos) {
			PesquisaDTO itemDTO = new PesquisaDTO();
			itemDTO.setCodigo(produto.getCdProduto());
			itemDTO.setDescricao(produto.getDsProduto());
			OmProduto clone = produto.clone(false);
			clone.setOmUsrByIdUsrrevisao(produto.getOmUsrByIdUsrrevisao().clone(false));
			clone.setOmUsrByIdUsrstativo(produto.getOmUsrByIdUsrstativo().clone(false));
			itemDTO.setRegistro(clone);
			listaDTO.add(itemDTO);
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}

	public List<OmProduto> getListaProduto(String cdProduto) {
		OmProdutoDAO dao = new OmProdutoDAO(getDaoSession());
		return dao.getListaProduto(cdProduto);
	}

	public List<OmProduto> getListaProdutoGts(String listaIdGt) {
		OmProdutoDAO dao = new OmProdutoDAO(getDaoSession());
		return dao.getListaProdutoGts(listaIdGt);
	}

	public List<OmProduto> getListaProdutoGtsCdProduto(String listaIdGt, String cdProduto) {
		OmProdutoDAO dao = new OmProdutoDAO(getDaoSession());
		return dao.getListaProdutoGtsCdProduto(listaIdGt, cdProduto);
	}

	public ProdutosDTO pesquisarProdutosComBanco(String cdProduto) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select distinct a ");
		q.append("from OmProduto a");
		q.append("join fetch a.omProrange b");
		q.append("where a.stAtivo = 1");
		if (cdProduto != null && cdProduto.equals("") == false) {
			q.append("and a.cdProduto like :cd");
		}

		q.defineParametro("cd", "%" + cdProduto + "%");

		List<OmProduto> lista = q.list();
		ProdutosDTO retorno = new ProdutosDTO();
		retorno.setResultado(new ResultadoDTO());
		retorno.getResultado().setIdmensagem(0);
		retorno.setProdutos(new ArrayList<ProdutoDTO>());
		for (OmProduto omproduto : lista) {
			ProdutoDTO dto = new ProdutoDTO();
			OmProduto omprodutoClone = omproduto.clone(false);
			omprodutoClone.setOmUsrByIdUsrrevisao(omproduto.getOmUsrByIdUsrrevisao().clone(false));
			omprodutoClone.setOmUsrByIdUsrstativo(omproduto.getOmUsrByIdUsrstativo().clone(false));
			dto.setProduto(omprodutoClone);

			if (omproduto.getOmProrange() != null) {
				for (OmProrange range : omproduto.getOmProrange()) {
					OmProrange clone = range.clone(false);
					clone.setOmUsrByIdUsrrevisao(range.getOmUsrByIdUsrrevisao().clone(false));
					clone.setOmUsrByIdUsrstativo(range.getOmUsrByIdUsrstativo().clone(false));
					dto.getProduto().getOmProrange().add(clone);
				}
			}
			retorno.getProdutos().add(dto);
		}

		return retorno;
	}

	public ProdutoDTO salvarProdutosComBanco(ProdutoDTO produtodto) {
		ProdutoDTO resultado = validarProdutoComBanco(produtodto);
		if (resultado.getResultadoEvento() != 0) {
			produtodto.setResultadoEvento(resultado.getResultadoEvento());
			produtodto.setERRO_COMPLEMENTO(resultado.getERRO_COMPLEMENTO());
			return produtodto;
		}

		ProdutoDTO retorno = new ProdutoDTO();
		OmProduto omproduto = resultado.getProduto().clone(false);
		omproduto.setOmUsrByIdUsrrevisao(resultado.getProduto().getOmUsrByIdUsrrevisao().clone(false));
		omproduto.setOmUsrByIdUsrstativo(omproduto.getOmUsrByIdUsrrevisao());
		omproduto.setOmProrange(new HashSet<OmProrange>());
		omproduto.setDwConsolprs(null);
		
		// Atuailzar os OmProrange atuais com os novos valores e incluir novos registros
		for (OmProrange range : resultado.getProduto().getOmProrange()) {
			// Se tiver id entao localizar
			OmProrange omprorange;
			if (range.getIdProrange() != null && range.getIdProrange() > 0l) {
				omprorange = getDao().findById(OmProrange.class, range.getIdProrange(), true);
			} else {
				omprorange = new OmProrange();
				omprorange.setIdProrange(null);
			}
			
			// Alterar dados encontrados com os recebidos
			omprorange.setConsumoporciclo(range.getConsumoporciclo());
			omprorange.setDthrRevisao(range.getDthrRevisao());
			omprorange.setDthrStativo(range.getDthrStativo());
			omprorange.setDwMacrange(range.getDwMacrange());
			omprorange.setIsExclusivo(range.getIsExclusivo());
			omprorange.setNsFinal(range.getNsFinal());
			omprorange.setNsInicial(range.getNsInicial());
			omprorange.setOmProduto(range.getOmProduto());
			omprorange.setOmUsrByIdUsrrevisao(range.getOmUsrByIdUsrrevisao());
			omprorange.setOmUsrByIdUsrstativo(range.getOmUsrByIdUsrstativo());
			omprorange.setStAtivo(range.getStAtivo());
			omprorange.setTpRegra(range.getTpRegra());
			omprorange.setQtTotal(range.getQtTotal());

			omprorange = getDao().makePersistent(omprorange);
			
			OmProrange clone = omprorange.clone(false);
			clone.setOmProduto(null);
			if (omprorange.getOmUsrByIdUsrrevisao() != null)
				clone.setOmUsrByIdUsrrevisao(omprorange.getOmUsrByIdUsrrevisao().clone(false));
			if (omprorange.getOmUsrByIdUsrstativo() != null)
				clone.setOmUsrByIdUsrstativo(omprorange.getOmUsrByIdUsrstativo().clone(false));
			if (omprorange.getDwMacrange() != null)
				clone.setDwMacrange(omprorange.getDwMacrange().clone(false));
			omproduto.getOmProrange().add(clone);
		}

		retorno.setProduto(omproduto);
		return retorno;
	}

	private ProdutoDTO validarProdutoComBanco(ProdutoDTO dto) {
		ProdutoDTO retorno = new ProdutoDTO();
		UsuarioRN urn = new UsuarioRN(getDao());
		MacRN mrn = new MacRN(getDao(), null);

		OmProduto omproduto = dto.getProduto().clone(false);
		retorno.setProduto(omproduto);
		OmProduto pesquisado = null;
		try {
			pesquisado = getOmProduto(omproduto.getCdProduto());
			if (pesquisado == null) {
				retorno.setResultadoEvento(6); //dto.getERRO_CDPRODUTO_INVALIDO());
				return retorno;
			}
			omproduto.setCdProduto(pesquisado.getCdProduto());
			omproduto.setDsProduto(pesquisado.getDsProduto());
			omproduto.setStAtivo(pesquisado.getStAtivo());
			omproduto.setOmUsrByIdUsrrevisao(pesquisado.getOmUsrByIdUsrrevisao().clone(false));
			omproduto.setOmUsrByIdUsrstativo(pesquisado.getOmUsrByIdUsrstativo().clone(false));
			omproduto.setIdProduto(pesquisado.getIdProduto());
			omproduto.setRevisao(pesquisado.getRevisao());
		} catch (RegistroDesconhecidoException e) {
			retorno.setResultadoEvento(6); // dto.getERRO_CDPRODUTO_INVALIDO());
			return retorno;
		}

		// Avaliar cada range que sera salvo
		for (OmProrange rangeOri : dto.getProduto().getOmProrange()) {
			OmProrange range = rangeOri.clone(false);
			
			range.setOmProduto(pesquisado);

			// Avaliar usuarios
			OmUsr usrRevisao;
			try {
				usrRevisao = urn.getOmUsr(rangeOri.getOmUsrByIdUsrrevisao().getCdUsr());
			} catch (RegistroDesconhecidoException e) {
				usrRevisao = null;
			}
			if (usrRevisao == null) {
				retorno.setResultadoEvento(4 /*dto.getERRO_USUARIO_REVISAO_DESCONHECIDO()*/);
				return retorno;
			}
			range.setOmUsrByIdUsrrevisao(usrRevisao);

			OmUsr usrStativo;
			try {
				usrStativo = urn.getOmUsr(rangeOri.getOmUsrByIdUsrstativo().getCdUsr());
			} catch (RegistroDesconhecidoException e) {
				usrStativo = null;
			}
			if (usrStativo == null) {
				retorno.setResultadoEvento(5 /*dto.getERRO_USUARIO_STATUS_DESCONHECIDO()*/);
				return retorno;
			}
			range.setOmUsrByIdUsrstativo(usrStativo);

			// NSs nao podem estar vazios
			if (range.getNsInicial() == null || range.getNsInicial().trim().equals("")) {
				retorno.setResultadoEvento(19 /*dto.getERRO_NS_INVALIDO()*/);
				retorno.setERRO_COMPLEMENTO("NS inical vazio");
				return retorno;
			}
			if (range.getNsFinal() == null || range.getNsFinal().trim().equals("")) {
				retorno.setResultadoEvento(19 /*dto.getERRO_NS_INVALIDO()*/);
				retorno.setERRO_COMPLEMENTO("NS final vazio");
				return retorno;
			}

			// NS final nao pode ser inferior ao inicial
			BigInteger nsinicial;
			BigInteger nsfinal;

			if (range.getTpRegra().equals((byte)OmProrangeTemplate._TPREGRA.TP_REGRA_HEXADECIMAL.getValue())) {
				nsinicial = ConversaoTipos.converteHexParaDecimal(range.getNsInicial());
				nsfinal = ConversaoTipos.converteHexParaDecimal(range.getNsFinal());
			} else {
				nsinicial = ConversaoTipos.converteParaBigInteger(range.getNsInicial());
				nsfinal = ConversaoTipos.converteParaBigInteger(range.getNsFinal());
			}
			if (nsinicial.compareTo(nsfinal) > 0) {
				retorno.setResultadoEvento(19 /*dto.getERRO_NS_INVALIDO()*/);
				retorno.setERRO_COMPLEMENTO("NS inicial maior NS final");
				return retorno;
			}

			// Avaliar se existe pai e se a faixa esta sujeita ao pai
			DwMacrange macrange = null;
			if (rangeOri.getDwMacrange() != null && rangeOri.getIdProrange() != null) {
				macrange = getDao().findById(DwMacrange.class, rangeOri.getIdProrange(), false);
				// verifica se esta na faixa do pai
				if (macrange != null) {
					BigInteger nsInicialPai = ConversaoTipos.converteHexParaDecimal(macrange.getCdMacInicial());
					BigInteger nsFinalPai = ConversaoTipos.converteHexParaDecimal(macrange.getCdMacFinal());

					if (mrn.isIntersecaoNoRange(nsInicialPai, nsFinalPai, nsinicial, nsfinal)) {
						retorno.setResultadoEvento(8); // dto.getERRO_FOR_DESCONHECIDO());
						retorno.setERRO_COMPLEMENTO("Fora do range pai " + nsInicialPai + " - " + nsFinalPai + " -  " + macrange.getCdModelo());
						return retorno;
					}
				}
			}
			range.setDwMacrange(macrange);

			// Avaliar se é exclusiva e se existe a faixa em outro cadastro
			ResultadoDTO res = isRangeConflita(range);
			if (res.getIdmensagem() != 0) {
				retorno.setResultadoEvento(res.getIdmensagem());
				retorno.setERRO_COMPLEMENTO(res.getComplemento());
				return retorno;
			}

			// Avaliar se o consumodo por ciclo é multiplo da quantidade total da faixa. Obtem a qtde no intervalo e / pelo Consumo por
			// ciclo. Nao
			// pode haver resto
			BigInteger qtde = nsfinal.subtract(nsinicial);
			qtde = qtde.add(BigInteger.ONE); // soma 1 para incluir o ultimo numero da faixa
			BigInteger porciclo = BigInteger.valueOf(range.getConsumoporciclo().longValue());
			BigInteger resto = qtde.mod(porciclo);
			if (resto.compareTo(BigInteger.ZERO) > 0) {
				retorno.setResultadoEvento(20); // dto.getERRO_MULTIPLO());
				StringBuilder complemento = new StringBuilder();
				
				
				complemento.append("O id=");
				complemento.append(range.getIdProrange());
				complemento.append(", com intervalo [");
				complemento.append(range.getNsInicial());
				complemento.append("] à [");
				complemento.append(range.getNsFinal());
				complemento.append("]\npossui ");
				complemento.append(ConversaoTipos.converteParaString(qtde));
				complemento.append(" números.\nDeveria ser um multiplo de ");
				complemento.append(ConversaoTipos.converteParaString(porciclo));
				complemento.append(".\nSugestão de número final ");
				complemento.append(calcularNSFinal(qtde, porciclo, nsfinal, range));
				retorno.setERRO_COMPLEMENTO(complemento.toString());
				return retorno;
			}
			
			omproduto.getOmProrange().add(range);

		}
		return retorno;
	}
	
	/* calcular o NS final considerando o multiplo informado
	 * 
	 */
	private String calcularNSFinal(BigInteger qtde, BigInteger porciclo, BigInteger nsfinal, OmProrange range) {
		String retorno = range.getNsFinal();
		BigInteger resto = qtde.mod(porciclo);
		// Se tiver resto eh pq o numero nao eh multimlo entao calcular l
		if (resto.compareTo(BigInteger.ZERO) > 0) {
			BigInteger divisao = qtde.divide(porciclo);
			divisao = divisao.multiply(porciclo);
			divisao = divisao.add(porciclo);
			divisao = divisao.subtract(qtde);
			nsfinal = nsfinal.add(divisao);
			retorno = ConversaoTipos.converteDecimalParaHex(nsfinal);
		}
		return retorno;
	}
	
	private ResultadoDTO isRangeConflita(OmProrange range) {
		ResultadoDTO retorno = new ResultadoDTO();
		MacRN rn = new MacRN(getDao(), null);
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from OmProrange a");
		q.append("join a.omProduto b");
		q.append("where a.stAtivo = 1");
		if (range.getIdProrange() != null)
			q.append("and a.idProrange <> :id");
		q.append("AND a.tpRegra = :tp");

		q.defineParametro("id", range.getIdProrange());
		q.defineParametro("tp", range.getTpRegra());

		BigInteger nsinicial;
		BigInteger nsfinal;

		if (range.getTpRegra().equals(OmProrangeTemplate._TPREGRA.TP_REGRA_HEXADECIMAL.getValue())) {
			nsinicial = ConversaoTipos.converteHexParaDecimal(range.getNsInicial());
			nsfinal = ConversaoTipos.converteHexParaDecimal(range.getNsFinal());
		} else {
			nsinicial = ConversaoTipos.converteParaBigInteger(range.getNsInicial());
			nsfinal = ConversaoTipos.converteParaBigInteger(range.getNsFinal());
		}

		List<OmProrange> lista = q.list();
		boolean isConflito = false;
		OmProrange rangeConflito = null;
		for (OmProrange omprorange : lista) {
			BigInteger nsinicialBanco;
			BigInteger nsfinalBanco;

			if (omprorange.getTpRegra().equals(OmProrangeTemplate._TPREGRA.TP_REGRA_HEXADECIMAL.getValue())) {
				nsinicialBanco = ConversaoTipos.converteHexParaDecimal(omprorange.getNsInicial());
				nsfinalBanco = ConversaoTipos.converteHexParaDecimal(omprorange.getNsFinal());
			} else {
				nsinicialBanco = ConversaoTipos.converteParaBigInteger(omprorange.getNsInicial());
				nsfinalBanco = ConversaoTipos.converteParaBigInteger(omprorange.getNsFinal());
			}
			if (
					rn.isIntersecaoNoRange(nsinicialBanco, nsfinalBanco, nsinicial, nsfinal) &&
					omprorange.getStAtivo() == (byte) 1 &&
					range.getStAtivo() == (byte) 1 &&
					// Um ou outro sao exclusivos
					(omprorange.getIsExclusivo() || range.getIsExclusivo()) 
					 ) {
				isConflito = true;
				rangeConflito = omprorange;
				break;
			}
		}
		if (isConflito) {
			StringBuilder complemento = new StringBuilder();
			
			complemento.append("O cadastro com id=");
			complemento.append(range.getIdProrange());
			complemento.append(" e intervalo [");
			complemento.append(range.getNsInicial());
			complemento.append("] até [");
			complemento.append(range.getNsFinal());
			
			complemento.append("] conflitou.\nPesquisar Cd.Produto [");
			complemento.append(rangeConflito.getOmProduto().getCdProduto());
			complemento.append("]\ncom o Id. [");
			complemento.append(rangeConflito.getIdProrange());

			complemento.append("] e NS inicial=[");
			complemento.append(rangeConflito.getNsInicial());
			complemento.append("] até [");
			complemento.append(rangeConflito.getNsFinal());
			complemento.append("].\nDesmarcar [Exclusivo para produto] para permitir conflitos.");
			
			retorno.setIdmensagem(1);
			retorno.setComplemento(complemento.toString());
		} else
			retorno.setIdmensagem(0);
		return retorno;
	}
	
	
	
	public ProdutosDTO pesquisarProdutos(String variavel) {
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from OmProduto a");
		q.append("where a.stAtivo = 1 and (a.cdProduto like :cd or");
		q.append("a.dsProduto like :ds)");
		
		q.setMaxResults(100);
		q.defineParametro("cd", "%" + variavel + "%");
		q.defineParametro("ds", "%" + variavel + "%");
		
		List<OmProduto> lista = q.list();
		
		ProdutosDTO retorno = new ProdutosDTO();
		retorno.setProdutos(new ArrayList<ProdutoDTO>());
		for (OmProduto ft : lista) {
			ProdutoDTO parametro = new ProdutoDTO();
			parametro.setProduto(ft.clone(false));
			retorno.getProdutos().add(parametro);
		}
		
		return retorno;
	}

	public ListaProdutosDTO getProdutosDTO(FiltroPesquisaDTO filtro){
		ListaProdutosDTO retorno = new ListaProdutosDTO();
		retorno.setItems(new ArrayList<ProdutoDTO2>());
		retorno.setMeta(new MetaDTO(filtro));
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select DISTINCT t");
		q.append("from OmProduto t");
		//q.append("left join fetch t.ppCliente c");
		q.append("WHERE t.stAtivo = 1");
		q.append("  AND t.tpProduto = 0 ");

		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){			
			q.append("AND (");
			q.append(" upper(t.cdProduto) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.dsProduto) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		} 
 		q.append("ORDER BY t.cdProduto");

 
 		List<OmProduto> lista = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
 		for (OmProduto reg : lista) {
 			ProdutoDTO2 regDTO = new ProdutoDTO2();

 			regDTO.setIdProduto(reg.getIdProduto());
 			regDTO.setCdProduto(reg.getCdProduto());
 			regDTO.setDsProduto(reg.getDsProduto());
 			
 			if (reg.getPpCliente() != null) {
 	 			regDTO.setCdCliente(reg.getPpCliente().getCdCliente()); 				
 			} else {
 				regDTO.setCdCliente("");
 			}
 			
 			regDTO.setTpProduto(reg.getTpProduto().intValue());
 			regDTO.setClasseABC(getClasseABC(reg.getTpClasseabc()));
 			regDTO.setCustoUnitario(reg.getVlCustounit() == null ? 0 : reg.getVlCustounit().doubleValue());
 			regDTO.setPesoBruto(reg.getGPesoBruto() == null ? 0 : reg.getGPesoBruto().doubleValue());
 			regDTO.setPesoLiquido(reg.getGPesoLiquido() == null ? 0 : reg.getGPesoLiquido().doubleValue());
 			
 			retorno.getItems().add(regDTO);
 		}
		
		
 		if (lista.size() > 0) {
 			ResumoRetornoRegistrosRN resRN = new ResumoRetornoRegistrosRN(getDao());
 			retorno.setMeta(resRN.getMetaDTO(filtro, q, lista.size()));
 			resRN = null;
 		}
		
		q = null;
		lista = null;

		return retorno;
	}
	
	public String getClasseABC(Byte classe) {
		String classeABC = "C";
		
		if (classe != null) {
			if (classe.intValue() == 0) {
				classeABC = "A";
				
			} else if (classe.intValue() == 1) {
				classeABC = "B";

			} else {
				classeABC = "C";				
			}
		}
		
		return classeABC;
	}

	public Byte getClasseValue(String classeABC) {
		Byte classe = 0;
		
		if (classeABC.equals("A")) {
			classe = 0;
			
		} else if (classeABC.equals("B")) {
			classe = 1;

		} else {
			classe = 2;				
		}
		
		return classe;
	}
	
	public ProdutoDTO2 getProdutoByCd(String cdProduto){
		ProdutoDTO2 retorno = new ProdutoDTO2();
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select DISTINCT t");
		q.append("from OmProduto t");
		//q.append("left join fetch t.ppCliente c");
		q.append("WHERE t.stAtivo = 1");
		q.append("AND t.cdProduto = :cdProduto");
		q.append("AND t.tpProduto = 0 ");
 		q.append("ORDER BY t.cdProduto");
 		
 		q.defineParametro("cdProduto", cdProduto);
 
 		List<OmProduto> lista = q.list();
 		if (lista.size() == 1) {
 			retorno.setIdProduto(lista.get(0).getIdProduto());
 			retorno.setCdProduto(lista.get(0).getCdProduto());
 			retorno.setDsProduto(lista.get(0).getDsProduto());
 			
 			if (lista.get(0).getPpCliente() != null) {
 				retorno.setCdCliente(lista.get(0).getPpCliente().getCdCliente()); 				
 			} else {
 				retorno.setCdCliente("");
 			}
 			
 			retorno.setTpProduto(lista.get(0).getTpProduto().intValue());
 			retorno.setClasseABC(getClasseABC(lista.get(0).getTpClasseabc()));
 			retorno.setCustoUnitario(lista.get(0).getVlCustounit() == null ? 0 : lista.get(0).getVlCustounit().doubleValue());
 			retorno.setPesoBruto(lista.get(0).getGPesoBruto() == null ? 0 : lista.get(0).getGPesoBruto().doubleValue());
 			retorno.setPesoLiquido(lista.get(0).getGPesoLiquido() == null ? 0 : lista.get(0).getGPesoLiquido().doubleValue());
 			
 			retorno.setStRegistro(lista.get(0).getStAtivo().intValue());			 
 		}

		return retorno;
	}
}
