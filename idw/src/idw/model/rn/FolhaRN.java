package idw.model.rn;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.Validate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwProcedimentoDAO;
import idw.model.dao.DwRotapassoDAO;
import idw.model.dao.MapQuery;
import idw.model.dao.OmGtDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPacoteOuFatorException;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.excessoes.SemSessaoHibernateException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhacic;
import idw.model.pojos.DwFolhaemb;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.DwFolhamedtemhor;
import idw.model.pojos.DwFolhamedtemp;
import idw.model.pojos.DwFolhamedtemphorcfg;
import idw.model.pojos.DwFolhamon;
import idw.model.pojos.DwFolhamoncomp;
import idw.model.pojos.DwFolhaoperacao;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwFolhasetup;
import idw.model.pojos.DwFolhateste;
import idw.model.pojos.DwFtEtapa;
import idw.model.pojos.DwFtSub;
import idw.model.pojos.DwFtSubparam;
import idw.model.pojos.DwOperacao;
import idw.model.pojos.DwProcedimento;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwTestesub;
import idw.model.pojos.DwTestesubetapa;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgscrpimp;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPrg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmRegrasNscb;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwFolhaTemplate;
import idw.model.pojos.template.DwFtParamTemplate;
import idw.model.pojos.template.OmTpptTemplate;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.CicloDTO;
import idw.webservices.dto.DadosProdutoSADTO;
import idw.webservices.dto.DwFolhaDTO;
import idw.webservices.dto.DwFolhasDTO;
import idw.webservices.dto.DwOperacaoDTO;
import idw.webservices.dto.FolhaDTO;
import idw.webservices.dto.FolhaEtapaDTO;
import idw.webservices.dto.FolhasDTO;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.dto.ProdutosDTO;
import idw.webservices.dto.ProgramaInsersoraDTO;
import idw.webservices.dto.ResultadoDTO;
import idw.webservices.dto.StatusProdutoSADTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.FolhaDTO2;
import idw.webservices.rest.idw.v2.dto.FolhaRapDTO2;
import idw.webservices.rest.idw.v2.dto.FolhaRapProdutoDTO;
import idw.webservices.rest.idw.v2.dto.ListaFolhasProcessoDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;
import ms.coleta.dto.ColetaParametroDTO;
import ms.util.ConversaoTipos;

public class FolhaRN extends AbstractRN<DAOGenerico> {

	public FolhaRN() {
		this(null);
	}

	public FolhaRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public FolhasDTO getFolhasDTO(FolhaDTO filtro) {

		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t ");
		q.append("from DwFolha t ");
		q.append("where 1=1 ");

		long id = 0;

		if ((filtro.getPesquisaEtapasRevisao() != null) && filtro.getPesquisaEtapasRevisao()) {
			q = new MapQuery(this.getDao().getSession());

			q.append("select distinct t from DwFolha t ");
			q.append("join t.dwFolhatestes a ");
			q.append("join a.dwTestesubs b ");
			q.append("join b.dwFtSub c ");
			q.append("left join b.dwTestesubetapas e ");
			q.append("join c.dwFtEtapa d ");

			// captura a Colecao de RAPS
			// --------------------------------------------------------------
			q.append("left join fetch t.dwFolharaps.dwRap rap ");
			// --------------------------------------------------------------

			// captura a Colecao das "RAP - Composiçãoo"
			// --------------------------------------------------------------
			q.append("left join fetch t.dwFolharaps.dwFolharapcoms rapcoms ");
			q.append("left join fetch t.dwFolharaps.dwFolharapcoms.omProduto produto ");
			// --------------------------------------------------------------

			if ((filtro.getFolha().getOmGt() != null) && (filtro.getFolha().getOmGt().getIdGt() > 0)) {
				q.append("where d.stAtivo = 1 and t.stAtivo = 1 ");
				if ((filtro.getFolha().getOmGt() != null) && (filtro.getFolha().getOmGt().getIdGt() > 0)) {
					q.append("AND t.omGt.idGt = :idGt ");
				}
				if ((filtro.getFolha().getDwFolhatestes() != null) && (filtro.getFolha().getDwFolhatestes().size() > 0)) {
					q.append("AND a.omProduto.idProduto = :idproduto ");
					for (DwFolhateste dw : filtro.getFolha().getDwFolhatestes()) {
						id = dw.getOmProduto().getIdProduto();
					}
				}
			} else {
				q.append("where d.stAtivo = 0 ");
			}

		} else if ((filtro.getFolha().getIsModelo() != null) && (filtro.getFolha().getIsModelo() == true)) {
			q.append("AND t.isModelo=true ");
			
		} else if ((filtro.getFolha().getIdFolha() != null) && (filtro.getFolha().getIdFolha() > 0)) {
			q.append("AND t.idFolha=:idFolha ");
			
		} else {
			if ((filtro.getFolha().getCdFolha() != null) && !filtro.getFolha().getCdFolha().equals("")) {
				q.append("AND t.cdFolha like :cdFolha ");
			}
			if ((filtro.getFolha().getDsFolha() != null) && !filtro.getFolha().getDsFolha().equals("")) {
				q.append("AND t.dsFolha=:dsFolha  ");
			}
			if (filtro.getFolha().getSegCiclominimo() != null) {
				q.append("AND t.segCiclominimo=:segCiclominimo ");
			}
			if (filtro.getFolha().getSegCiclopadrao() != null) {
				q.append("AND t.segCiclopadrao=:segCiclopadrao ");
			}
			if (filtro.getFolha().getSegCiclotimeout() != null) {
				q.append("AND t.segCiclotimeout=:segCiclotimeout ");
			}
			if (filtro.getFolha().getSegLogoutauto() != null) {
				q.append("AND t.segLogoutauto=:segLogoutauto ");
			}
			if ((filtro.getFolha().getTpFolha() != null)
					&& (filtro.getFolha().getTpFolha().intValue() <= 7)) {
				q.append("AND t.tpFolha=:tpFolha ");
			}
			if (filtro.getFolha().getDtRevisao() != null) {
				q.append("AND t.dtRevisao=:dtRevisao ");
			}
			if ((filtro.getFolha().getOmUsrByIdUsrrevisao() != null) && !filtro.getFolha().getOmUsrByIdUsrrevisao().getCdUsr().equals("")) {
				q.append("AND t.omUsrByIdUsrrevisao.cdUsr=:cdUsrRev ");
			}
			if ((filtro.getFolha().getOmUsrByIdUsrrevisao() != null) && (filtro.getFolha().getOmUsrByIdUsrrevisao().getDsNome() != null)
					&& !filtro.getFolha().getOmUsrByIdUsrrevisao().getDsNome().equals("")) {
				q.append("AND t.omUsrByIdUsrrevisao.dsNome=:dsNomeRev ");
			}
			if ((filtro.getFolha().getOmUsrByIdUsrstativo() != null) && !filtro.getFolha().getOmUsrByIdUsrstativo().getCdUsr().equals("")) {
				q.append("AND t.omUsrByIdUsrstativo.cdUsr=:cdUsrSt ");
			}
			if ((filtro.getFolha().getOmUsrByIdUsrstativo() != null) && (filtro.getFolha().getOmUsrByIdUsrstativo().getDsNome() != null)
					&& !filtro.getFolha().getOmUsrByIdUsrstativo().getDsNome().equals("")) {
				q.append("AND t.omUsrByIdUsrstativo.dsNome=:dsNomeSt ");
			}
			if (filtro.getFolha().getDtStativo() != null) {
				q.append("AND t.dtStativo=:dtStativo ");
			}

			if ((filtro.getFolha().getStAtivo() != null) && (filtro.getFolha().getStAtivo() < (byte) 2)) {
				q.append("AND t.stAtivo=:stAtivo ");
			}
		}

		q.defineParametro("idFolha", filtro.getFolha().getIdFolha());
		q.defineParametro("cdFolha", filtro.getFolha().getCdFolha());
		q.defineParametro("dsFolha", filtro.getFolha().getDsFolha());
		q.defineParametro("segCiclominimo", filtro.getFolha().getSegCiclominimo());
		q.defineParametro("segCiclopadrao", filtro.getFolha().getSegCiclopadrao());
		q.defineParametro("segCiclotimeout", filtro.getFolha().getSegCiclotimeout());
		q.defineParametro("segLogoutauto", filtro.getFolha().getSegLogoutauto());
		q.defineParametro("tpFolha", filtro.getFolha().getTpFolha());
		q.setMaxResults(100);

		if (filtro.getFolha().getOmGt() != null) {
			q.defineParametro("idGt", filtro.getFolha().getOmGt().getIdGt());
		}

		if (id > 0) {
			q.defineParametro("idproduto", id);
		}

		if (filtro.getFolha().getOmUsrByIdUsrrevisao() != null) {
			q.defineParametro("cdUsrRev", filtro.getFolha().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getFolha().getOmUsrByIdUsrrevisao().getDsNome());
		}
		if (filtro.getFolha().getOmUsrByIdUsrstativo() != null) {
			q.defineParametro("cdUsrSt", filtro.getFolha().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getFolha().getOmUsrByIdUsrstativo().getDsNome());
		}
		q.defineParametro("revisao", filtro.getFolha().getRevisao());
		q.defineParametro("stAtivo", filtro.getFolha().getStAtivo());

		q.defineParametroData("dtRevisao", filtro.getFolha().getDtRevisao());
		q.defineParametroData("dtStativo", filtro.getFolha().getDtStativo());

		List<DwFolha> listaPesquisa = null;
		try {
			listaPesquisa = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<FolhaDTO> lista = new ArrayList<FolhaDTO>();

		if (listaPesquisa != null) {
			for (DwFolha item : listaPesquisa) {
				FolhaDTO itemDTO = new FolhaDTO();
				itemDTO.setFolha(item.clone());

				
				// DwFolhateste
				if (item.getDwFolhatestes() != null) {
					itemDTO.getFolha().setDwFolhatestes(new HashSet<DwFolhateste>());
					for (DwFolhateste itemList : item.getDwFolhatestes()) {
						DwFolhateste dwFolhateste = (DwFolhateste) itemList.clone();
						itemDTO.getFolha().getDwFolhatestes().add(dwFolhateste);

						List<FolhaEtapaDTO> folhaEtapas = new ArrayList<FolhaEtapaDTO>();
						for (DwTestesub dwTestesub : itemList.getDwTestesubs()) {
							boolean existe = false;
							FolhaEtapaDTO folhaEtapa = new FolhaEtapaDTO();
							for (FolhaEtapaDTO folhaEtapaDTO : folhaEtapas) {
								if (dwTestesub.getDwFtSub().getDwFtEtapa().getIdFtEtapa() == folhaEtapaDTO.getEtapa().getIdFtEtapa()) {
									folhaEtapa = folhaEtapaDTO;
									existe = true;
								}
							}
							if (!existe) {
								folhaEtapa.setEtapa((DwFtEtapa) dwTestesub.getDwFtSub().getDwFtEtapa().clone());
								if (dwTestesub.getOrdemEtapa() != null) {
									folhaEtapa.setOrdem(dwTestesub.getOrdemEtapa());
								} else {
									folhaEtapa.setOrdem(0);
								}
								folhaEtapa.setTestesSub(new ArrayList<DwTestesub>());
								folhaEtapas.add(folhaEtapa);
							}
							DwTestesub testeSub = (DwTestesub) dwTestesub.clone();

							testeSub.setDwTestesubetapas(new HashSet<DwTestesubetapa>());
							if (dwTestesub.getDwTestesubetapas() != null) {
								for (DwTestesubetapa testeSubetapa : dwTestesub.getDwTestesubetapas()) {
									DwTestesubetapa cloneTesteSubetapa = (DwTestesubetapa) testeSubetapa.clone();
									cloneTesteSubetapa.getDwFtSubparam()
											.setDwFtSub((DwFtSub) testeSubetapa.getDwFtSubparam().getDwFtSub().clone());
									testeSub.getDwTestesubetapas().add(cloneTesteSubetapa);
								}
							}
							folhaEtapa.getTestesSub().add(testeSub);
						}
						itemDTO.setFolhaEtapasDTO(folhaEtapas);
					}
				}

				// DwFolhacic
				if ((item.getDwFolhacics() != null) && (item.getDwFolhacics().size() > 0)) {
					itemDTO.getFolha().setDwFolhacics(new HashSet<DwFolhacic>());
					for (DwFolhacic cic : item.getDwFolhacics()) {
						itemDTO.getFolha().getDwFolhacics().add(cic.clone());
					}
				}

				// DwFolhasetup. Nessa tabela a folha esta registrada em
				// folhaentrando
				// As folhas saindo sao as folhas anteriores (que podem estar em
				// maquina)
				if (item.getDwFolhasetupsForIdFolhaentrando() != null) {
					itemDTO.getFolha().setDwFolhasetupsForIdFolhaentrando(new HashSet<DwFolhasetup>());
					for (DwFolhasetup setup : item.getDwFolhasetupsForIdFolhaentrando()) {
						DwFolhasetup setupClone = setup.clone(false);
						setupClone.setDwFolhaByIdFolhasaindo(setup.getDwFolhaByIdFolhasaindo().clone(false));
						itemDTO.getFolha().getDwFolhasetupsForIdFolhaentrando().add(setupClone);
					}
				}

				// DwFolhamon
				if (item.getDwFolhamons() != null) {
					itemDTO.getFolha().setDwFolhamons(new HashSet<DwFolhamon>());
					for (DwFolhamon itemList : item.getDwFolhamons()) {
						DwFolhamon dwFolhamon = (DwFolhamon) itemList.clone();
						itemDTO.getFolha().getDwFolhamons().add(dwFolhamon);
					}
				}

				// embalagens
				if (item.getDwFolhaembs() != null) {
					itemDTO.getFolha().setDwFolhaembs(new HashSet<DwFolhaemb>());
					for (DwFolhaemb emb : item.getDwFolhaembs()) {
						DwFolhaemb embc = emb.clone();
						itemDTO.getFolha().getDwFolhaembs().add(embc);
					}
				}

				// DwFolhamedtemp. Configuraçãoo de parametros de mediçãoo de
				// temperatura
				if (item.getDwFolhamedtemps() != null) {
					itemDTO.getFolha().setDwFolhamedtemps(new HashSet<DwFolhamedtemp>());
					for (DwFolhamedtemp itemFMT : item.getDwFolhamedtemps()) {
						DwFolhamedtemp fmt = itemFMT.clone();
						itemDTO.getFolha().getDwFolhamedtemps().add(fmt);
					}
				}
				itemDTO.setResultadoEvento(0);
				lista.add(itemDTO);

				// INicializar retorno das operacoes
				if (item.getDwFolhaoperacoes() != null) {
					itemDTO.getFolha().setDwFolhaoperacoes(new HashSet<DwFolhaoperacao>());
					for (DwFolhaoperacao folhaopera : item.getDwFolhaoperacoes()) {
						DwFolhaoperacao folhaoperaClone = folhaopera.clone();
						itemDTO.getFolha().getDwFolhaoperacoes().add(folhaoperaClone);
					}
				}

			}
		}

		FolhasDTO dtoRetorno = new FolhasDTO();
		dtoRetorno.setFolhas(lista);
		return dtoRetorno;
	}

	public FolhasDTO getFolhasDTOSemClonarFilhos(FolhaDTO filtro) {

		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t ");
		q.append("from DwFolha t ");
		q.append("where 1=1 ");

		long id = 0;

		if (filtro.getPesquisaEtapasRevisao() != null && filtro.getPesquisaEtapasRevisao()) {
			q = new MapQuery(this.getDao().getSession());

			q.append("select distinct t from DwFolha t ");
			q.append("join t.dwFolhatestes a ");
			q.append("join a.dwTestesubs b ");
			q.append("join b.dwFtSub c ");
			q.append("left join b.dwTestesubetapas e ");
			q.append("join c.dwFtEtapa d ");

			// captura a Colecao de RAPS
			// --------------------------------------------------------------
			q.append("left join fetch t.dwFolharaps.dwRap rap ");
			// --------------------------------------------------------------

			// captura a Colecao das "RAP - Composiçãoo"
			// --------------------------------------------------------------
			q.append("left join fetch t.dwFolharaps.dwFolharapcoms rapcoms ");
			q.append("left join fetch t.dwFolharaps.dwFolharapcoms.omProduto produto ");
			// --------------------------------------------------------------

			if (filtro.getFolha().getOmGt() != null && filtro.getFolha().getOmGt().getIdGt() > 0) {
				q.append("where d.stAtivo = 1 and t.stAtivo = 1 ");
				if (filtro.getFolha().getOmGt() != null && filtro.getFolha().getOmGt().getIdGt() > 0) {
					q.append("AND t.omGt.idGt = :idGt ");
				}
				if (filtro.getFolha().getDwFolhatestes() != null && filtro.getFolha().getDwFolhatestes().size() > 0) {
					q.append("AND a.omProduto.idProduto = :idproduto ");
					for (DwFolhateste dw : filtro.getFolha().getDwFolhatestes()) {
						id = dw.getOmProduto().getIdProduto();
					}
				}
			} else {
				q.append("where d.stAtivo = 0 ");
			}

		} else if (filtro.getFolha().getIsModelo() != null && filtro.getFolha().getIsModelo() == true) {
			q.append("AND t.isModelo=true ");
		} else if (filtro.getFolha().getIdFolha() != null && filtro.getFolha().getIdFolha() > 0) {
			q.append("AND t.idFolha=:idFolha ");
		} else {
			if (filtro.getFolha().getCdFolha() != null && !filtro.getFolha().getCdFolha().equals("")) {
				q.append("AND t.cdFolha like :cdFolha ");
			}
			if ((filtro.getFolha().getDsFolha() != null) && !filtro.getFolha().getDsFolha().equals("")) {
				q.append("AND t.dsFolha=:dsFolha  ");
			}
			if (filtro.getFolha().getSegCiclominimo() != null) {
				q.append("AND t.segCiclominimo=:segCiclominimo ");
			}
			if (filtro.getFolha().getSegCiclopadrao() != null) {
				q.append("AND t.segCiclopadrao=:segCiclopadrao ");
			}
			if (filtro.getFolha().getSegCiclotimeout() != null) {
				q.append("AND t.segCiclotimeout=:segCiclotimeout ");
			}
			if (filtro.getFolha().getSegLogoutauto() != null) {
				q.append("AND t.segLogoutauto=:segLogoutauto ");
			}
			if ((filtro.getFolha().getTpFolha() != null) && (filtro.getFolha().getTpFolha().intValue() <= 7)) {
				q.append("AND t.tpFolha=:tpFolha ");
			}
			if (filtro.getFolha().getDtRevisao() != null) {
				q.append("AND t.dtRevisao=:dtRevisao ");
			}
			if (filtro.getFolha().getOmTppt() != null && filtro.getFolha().getOmTppt().getCdTppt() != null
					&& filtro.getFolha().getOmTppt().getCdTppt().equals("") == false) {
				q.append("and t.omTppt.cdTppt = :cdtppt");
			}
			if ((filtro.getFolha().getOmUsrByIdUsrrevisao() != null) && !filtro.getFolha().getOmUsrByIdUsrrevisao().getCdUsr().equals("")) {
				q.append("AND t.omUsrByIdUsrrevisao.cdUsr=:cdUsrRev ");
			}
			if ((filtro.getFolha().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getFolha().getOmUsrByIdUsrrevisao().getDsNome() != null)
					&& !filtro.getFolha().getOmUsrByIdUsrrevisao().getDsNome().equals("")) {
				q.append("AND t.omUsrByIdUsrrevisao.dsNome=:dsNomeRev ");
			}
			if ((filtro.getFolha().getOmUsrByIdUsrstativo() != null) && !filtro.getFolha().getOmUsrByIdUsrstativo().getCdUsr().equals("")) {
				q.append("AND t.omUsrByIdUsrstativo.cdUsr=:cdUsrSt ");
			}
			if ((filtro.getFolha().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getFolha().getOmUsrByIdUsrstativo().getDsNome() != null)
					&& !filtro.getFolha().getOmUsrByIdUsrstativo().getDsNome().equals("")) {
				q.append("AND t.omUsrByIdUsrstativo.dsNome=:dsNomeSt ");
			}
			if (filtro.getFolha().getDtStativo() != null) {
				q.append("AND t.dtStativo=:dtStativo ");
			}

			if ((filtro.getFolha().getStAtivo() != null) && (filtro.getFolha().getStAtivo() < (byte) 2)) {
				q.append("AND t.stAtivo=:stAtivo ");
			}
		}

		q.defineParametro("idFolha", filtro.getFolha().getIdFolha());
		q.defineParametro("cdFolha", filtro.getFolha().getCdFolha() + "%");
		q.defineParametro("dsFolha", filtro.getFolha().getDsFolha());
		q.defineParametro("segCiclominimo", filtro.getFolha().getSegCiclominimo());
		q.defineParametro("segCiclopadrao", filtro.getFolha().getSegCiclopadrao());
		q.defineParametro("segCiclotimeout", filtro.getFolha().getSegCiclotimeout());
		q.defineParametro("segLogoutauto", filtro.getFolha().getSegLogoutauto());
		q.defineParametro("tpFolha", filtro.getFolha().getTpFolha());
		if (filtro.getFolha().getOmTppt() != null)
			q.defineParametro("cdtppt", filtro.getFolha().getOmTppt().getCdTppt());
		q.setMaxResults(100); // Causa das folhas que recentemente foram atualizadas/cadastradas não aparecerem na pesquisa.

		if (filtro.getFolha().getOmGt() != null) {
			q.defineParametro("idGt", filtro.getFolha().getOmGt().getIdGt());
		}

		if (id > 0) {
			q.defineParametro("idproduto", id);
		}

		if (filtro.getFolha().getOmUsrByIdUsrrevisao() != null) {
			q.defineParametro("cdUsrRev", filtro.getFolha().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getFolha().getOmUsrByIdUsrrevisao().getDsNome());
		}
		if (filtro.getFolha().getOmUsrByIdUsrstativo() != null) {
			q.defineParametro("cdUsrSt", filtro.getFolha().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getFolha().getOmUsrByIdUsrstativo().getDsNome());
		}
		q.defineParametro("revisao", filtro.getFolha().getRevisao());
		q.defineParametro("stAtivo", filtro.getFolha().getStAtivo());

		q.defineParametroData("dtRevisao", filtro.getFolha().getDtRevisao());
		q.defineParametroData("dtStativo", filtro.getFolha().getDtStativo());

		List<DwFolha> listaPesquisa = null;
		try {
			listaPesquisa = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<FolhaDTO> lista = new ArrayList<FolhaDTO>();

		if (listaPesquisa != null) {
			for (DwFolha item : listaPesquisa) {
				FolhaDTO itemDTO = new FolhaDTO();
				itemDTO.setFolha(item.clone(false));

				itemDTO.setResultadoEvento(0);
				lista.add(itemDTO);
			}
		}

		FolhasDTO dtoRetorno = new FolhasDTO();
		dtoRetorno.setFolhas(lista);
		return dtoRetorno;
	}

	/**
	 *
	 * @param itemDTO
	 * @return
	 * @deprecated - usar {@link #setFolhaSemCadastroEtapaDTO(FolhaDTO)}
	 */
	@Deprecated
	public FolhaDTO setFolhaDTO(FolhaDTO itemDTO) {
		FolhaDTO dtoRetorno = new FolhaDTO();
		dtoRetorno.setResultadoEvento(dtoRetorno.getEVENTO_BEM_SUCEDIDO());

		if (itemDTO.getFolha().getCdFolha().trim().equals("")) {
			dtoRetorno
					.setResultadoEvento(dtoRetorno.getERRO_CDFOLHA_INVALIDO());
			return dtoRetorno;
		}

		String hql = "";

		hql = "from DwFolha t where t.idFolha = ::idFolha ";
		hql = hql.replaceAll("::idFolha",
				String.valueOf(itemDTO.getFolha().getIdFolha()));

		Query q = this.getDao().getSession().createQuery(hql);

		DwFolha itemOriginal = (DwFolha) q.uniqueResult();

		DwFolha itemAlteracao = null;

		if (itemOriginal == null) {
			itemOriginal = itemDTO.getFolha().clone();
			itemOriginal.setIdFolha(null);
			itemOriginal.setRevisao(1l);
			itemOriginal.setDtRevisao(new Date());
			itemOriginal.setStAtivo((byte) 1);
			itemOriginal.setDtStativo(new Date());

			// Verifica se o codigo + revisao ja existe no banco, se exitir
			// retornar ao cliente a excessao

			MapQuery queryCdFolha = new MapQuery(this.getDao().getSession());

			queryCdFolha.append("from DwFolha t");
			queryCdFolha
					.append("where t.cdFolha = :cdFolha and t.stAtivo = 1 ");

			queryCdFolha.defineParametro("cdFolha", itemOriginal.getCdFolha());

			if (queryCdFolha.list().size() > 0) {
				dtoRetorno.setResultadoEvento(dtoRetorno
						.getERRO_FOLHA_JA_EXISTE());
				return dtoRetorno;
			}
		} else {
			itemAlteracao = new DwFolha();
			itemAlteracao.copy(itemOriginal, true);
			itemAlteracao.setIdFolha(null);
			itemAlteracao.setStAtivo((byte) 0);
			itemOriginal.copy(itemDTO.getFolha(), false);
			itemOriginal.setDtRevisao(new Date());
			itemOriginal.setRevisao(itemOriginal.getRevisao() + 1);
		}
		itemDTO = this.validaFolha(itemDTO);

		dtoRetorno.setResultadoEvento(itemDTO.getResultadoEvento());
		dtoRetorno.setEtapaComErro(itemDTO.getEtapaComErro());
		dtoRetorno.setSubetapaComErro(itemDTO.getSubetapaComErro());
		if (dtoRetorno.getResultadoEvento() != dtoRetorno
				.getEVENTO_BEM_SUCEDIDO()) {
			this.getDao().getSession().getTransaction().rollback();
			return dtoRetorno;
		}

		// DwFolhatestes. Se for uma folha de teste funcional
		if (itemOriginal.getDwFolhatestes() != null) {
			for (Iterator<DwFolhateste> iterator = itemOriginal
					.getDwFolhatestes().iterator(); iterator.hasNext();) {
				DwFolhateste item = iterator.next();
				// Se existirem etapas e subetapas, percorre-las para realizar a
				// exclusao para futura inclusao
				if (item.getDwTestesubs() != null) {
					for (Iterator<DwTestesub> iterator2 = item.getDwTestesubs()
							.iterator(); iterator.hasNext();) {
						DwTestesub item2 = iterator2.next();
						this.getDao().getSession().delete(item2);
						iterator2.remove();
						continue;
					}
				}
				this.getDao().getSession().delete(item);
				iterator.remove();
				continue;

			}
		}
		// Se for uma folha do tipo receita de testes, entao altera a folha
		// original com as etapas e subetapas novas
		if (itemDTO.getFolha().getDwFolhatestes() != null && itemDTO.getFolha().getTpFolha().intValue() == 0) {
			itemOriginal.setDwFolhatestes(new HashSet<DwFolhateste>());
			for (DwFolhateste itemList : itemDTO.getFolha().getDwFolhatestes()) {
				itemList.setDwFolha(itemOriginal);
				itemList.setIdFolhateste(0l);
				itemList.setDwTestesubs(new HashSet<DwTestesub>());
				if (itemDTO.getFolhaEtapasDTO() != null) {
					for (FolhaEtapaDTO folha : itemDTO.getFolhaEtapasDTO()) {
						for (DwTestesub testeSub : folha.getTestesSub()) {
							testeSub.setIdTestesub(0l);
							testeSub.setOrdemEtapa(folha.getOrdem());
							testeSub.setDwFolhateste(itemList);

							for (DwTestesubetapa testeSubetapa : testeSub.getDwTestesubetapas()) {
								testeSubetapa.setIdTestesubetapa(0l);
								testeSubetapa.setDwTestesub(testeSub);
								testeSub.getDwTestesubetapas().add(testeSubetapa);
							}

							itemList.getDwTestesubs().add(testeSub);
						}

					}
				}

				itemOriginal.getDwFolhatestes().add(itemList);
			}
		} else {
			itemOriginal.setDwFolhatestes(null);
		}

		// DwFolhamons
		if (itemOriginal.getDwFolhamons() != null) {
			for (Iterator<DwFolhamon> iterator = itemOriginal.getDwFolhamons()
					.iterator(); iterator.hasNext();) {
				DwFolhamon item = iterator.next();
				if (item.getDwFolhamoncomps() != null) {
					for (Iterator<DwFolhamoncomp> iterator2 = item
							.getDwFolhamoncomps().iterator(); iterator
									.hasNext();) {
						DwFolhamoncomp item2 = iterator2.next();
						this.getDao().getSession().delete(item2);
						iterator2.remove();
						continue;
					}
				}
				this.getDao().getSession().delete(item);
				iterator.remove();
				continue;

			}
		}
		if ((itemDTO.getFolha().getDwFolhamons() != null)
				&& (itemDTO.getFolha().getTpFolha().intValue() == 1)) {
			itemOriginal.setDwFolhamons(new HashSet<DwFolhamon>());
			for (DwFolhamon itemList : itemDTO.getFolha().getDwFolhamons()) {
				itemList.setDwFolha(itemOriginal);
				itemList.setIdFolhamon(0l);
				itemOriginal.getDwFolhamons().add(itemList);
			}
		} else {
			itemOriginal.setDwFolhamons(null);
		}

		// Verifica se o idgt existe
		try {
			hql = "from OmGt t where t.cdGt = '::cdGt' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idGt ";
			hql = hql.replaceAll("::cdGt", itemDTO.getFolha().getOmGt()
					.getCdGt());
			q = this.getDao().getSession().createQuery(hql);
			OmGt item = (OmGt) q.list().get(0);
			itemOriginal.setOmGt(item);
		} catch (Exception e) {
			e.printStackTrace();
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_GT_DESCONHECIDO());
			this.getDao().getSession().getTransaction().rollback();
			return dtoRetorno;
		}

		// Verifica se o idtppt existe
		try {
			hql = "from OmTppt t where t.cdTppt = '::cdTppt' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idTppt ";
			hql = hql.replaceAll("::cdTppt", itemDTO.getFolha().getOmTppt()
					.getCdTppt());
			q = this.getDao().getSession().createQuery(hql);
			OmTppt item = (OmTppt) q.list().get(0);
			itemOriginal.setOmTppt(item);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno
					.getERRO_TIPOPOSTO_DESCONHECIDO());
			this.getDao().getSession().getTransaction().rollback();
			return dtoRetorno;
		}

		// Verifica se o ompt existe
		try {
			hql = "from OmPt t where t.cdPt = '::cdPt' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idPt ";
			hql = hql.replaceAll("::cdPt", itemDTO.getFolha().getOmPt()
					.getCdPt());
			q = this.getDao().getSession().createQuery(hql);
			OmPt item = (OmPt) q.list().get(0);
			itemOriginal.setOmPt(item);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno
					.getERRO_TIPOPOSTO_DESCONHECIDO());
			this.getDao().getSession().getTransaction().rollback();
			return dtoRetorno;
		}

		// Verifica se o usuario da revisao existe
		try {
			hql = "from OmUsr t where t.cdUsr = '::cdUsr' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idUsr ";

			hql = hql.replaceAll("::cdUsr", itemDTO.getFolha()
					.getOmUsrByIdUsrrevisao().getCdUsr());

			q = this.getDao().getSession().createQuery(hql);

			OmUsr omUsrRevisao = (OmUsr) q.list().get(0);

			itemOriginal.setOmUsrByIdUsrrevisao(omUsrRevisao);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno
					.getERRO_USUARIO_REVISAO_DESCONHECIDO());
			this.getDao().getSession().getTransaction().rollback();
			return dtoRetorno;
		}

		try {
			hql = "from OmUsr t where t.cdUsr = '::cdUsr' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idUsr ";
			hql = hql.replaceAll("::cdUsr", itemDTO.getFolha()
					.getOmUsrByIdUsrstativo().getCdUsr());

			q = this.getDao().getSession().createQuery(hql);

			OmUsr omUsrStAtivo = (OmUsr) q.list().get(0);

			itemOriginal.setOmUsrByIdUsrstativo(omUsrStAtivo);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno
					.getERRO_USUARIO_STATUS_DESCONHECIDO());
			this.getDao().getSession().getTransaction().rollback();
			return dtoRetorno;
		}

		if (dtoRetorno.getResultadoEvento() == dtoRetorno
				.getEVENTO_BEM_SUCEDIDO()) {
			try {
				itemOriginal = this.getDao().makePersistent(itemOriginal);
				if (itemAlteracao != null) {
					itemAlteracao = this.getDao().makePersistent(itemAlteracao);
				}
			} catch (Exception e) {
				dtoRetorno
						.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
				e.printStackTrace();
			}

			dtoRetorno.setFolha(itemOriginal.clone());

			// DwFolhateste
			if (itemOriginal.getDwFolhatestes() != null) {
				dtoRetorno.getFolha().setDwFolhatestes(
						new HashSet<DwFolhateste>());
				for (DwFolhateste itemList : itemOriginal.getDwFolhatestes()) {
					DwFolhateste dwFolhateste = (DwFolhateste) itemList.clone();
					dtoRetorno.getFolha().getDwFolhatestes().add(dwFolhateste);

					List<FolhaEtapaDTO> folhaEtapas = new ArrayList<FolhaEtapaDTO>();
					for (DwTestesub dwTestesub : itemList.getDwTestesubs()) {
						boolean existe = false;
						FolhaEtapaDTO folhaEtapa = new FolhaEtapaDTO();
						for (FolhaEtapaDTO folhaEtapaDTO : folhaEtapas) {
							if (dwTestesub.getDwFtSub().getDwFtEtapa()
									.getIdFtEtapa() == folhaEtapaDTO.getEtapa()
											.getIdFtEtapa()) {
								folhaEtapa = folhaEtapaDTO;
								existe = true;
							}
						}
						if (!existe) {
							folhaEtapa.setEtapa((DwFtEtapa) dwTestesub
									.getDwFtSub().getDwFtEtapa().clone());
							folhaEtapa.setOrdem(dwTestesub.getOrdemEtapa());
							folhaEtapa
									.setTestesSub(new ArrayList<DwTestesub>());
							folhaEtapas.add(folhaEtapa);
						}
						DwTestesub testeSub = (DwTestesub) dwTestesub.clone();

						testeSub.setDwTestesubetapas(new HashSet<DwTestesubetapa>());
						if (dwTestesub.getDwTestesubetapas() != null) {
							for (DwTestesubetapa testeSubetapa : dwTestesub
									.getDwTestesubetapas()) {
								testeSub.getDwTestesubetapas()
										.add((DwTestesubetapa) testeSubetapa
												.clone());
							}
						}
						folhaEtapa.getTestesSub().add(testeSub);
					}
					dtoRetorno.setFolhaEtapasDTO(folhaEtapas);
				}
			}

			// DwFolhamon
			if (itemOriginal.getDwFolhamons() != null) {
				dtoRetorno.getFolha().setDwFolhamons(new HashSet<DwFolhamon>());
				for (DwFolhamon itemList : itemOriginal.getDwFolhamons()) {
					DwFolhamon dwFolhamon = (DwFolhamon) itemList.clone();
					for (DwFolhamoncomp dwFolhamoncomp : itemList
							.getDwFolhamoncomps()) {
						dwFolhamon.getDwFolhamoncomps().add(
								(DwFolhamoncomp) dwFolhamoncomp.clone());
					}
					dtoRetorno.getFolha().getDwFolhamons().add(dwFolhamon);
				}
			}

		} else {
			this.getDao().getSession().getTransaction().rollback();
		}

		return dtoRetorno;
	}

	public FolhasDTO removeFolhasDTO(FolhasDTO itensDTO) {

		List<FolhaDTO> listaRetorno = new ArrayList<FolhaDTO>();
		for (FolhaDTO item : itensDTO.getFolhas()) {
			FolhaDTO itemRetorno = new FolhaDTO();
			String hql = "";

			hql = "from DwFolha t where t.idFolha = ::idFolha";
			hql = hql.replaceAll("::idFolha",
					String.valueOf(item.getFolha().getIdFolha()));

			Query q = this.getDao().getSession().createQuery(hql);

			DwFolha itemOriginal = (DwFolha) q.uniqueResult();

			if (itemOriginal == null) {
				itemRetorno.setResultadoEvento(itemRetorno
						.getERRO_CDFOLHA_INVALIDO());
				itemRetorno.setFolha(item.getFolha());
			} else if (itemOriginal.getStAtivo() == 0) {
				itemRetorno.setResultadoEvento(itemRetorno
						.getERRO_CDFOLHA_INVALIDO());
				itemRetorno.setFolha(itemOriginal.clone());
			} else {
				itemOriginal.setStAtivo((byte) 0);
				itemOriginal.setDtStativo(new Date());

				try {
					itemOriginal = this.getDao().makePersistent(itemOriginal);
				} catch (Exception e) {
					e.printStackTrace();
				}

				itemRetorno.setFolha(itemOriginal.clone());

				itemRetorno.setResultadoEvento(0);
			}

			listaRetorno.add(itemRetorno);
		}

		FolhasDTO itensRetorno = new FolhasDTO();
		itensRetorno.setFolhas(listaRetorno);
		return itensRetorno;
	}

	private FolhaDTO validaFolha(FolhaDTO folha) {
		FolhaDTO retorno = folha;
		FolhaDTO obtemErro = new FolhaDTO();
		// tp_folha
		if ((folha.getFolha().getTpFolha().byteValue() < 0)
				|| (folha.getFolha().getTpFolha().byteValue() > 5)) {
			retorno.setResultadoEvento(obtemErro
					.getERRO_TIPOFOLHA_DESCONHECIDO());
			return retorno;
		}
		if (folha.getFolha().getTpFolha().intValue() == 0) { // Teste funcional
			if ((folha.getFolha().getDwFolhatestes() == null)
					|| (folha.getFolha().getDwFolhatestes().size() == 0)) {
				retorno.setResultadoEvento(obtemErro
						.getERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS());
				return retorno;
			}
			for (DwFolhateste dwFolhateste : folha.getFolha()
					.getDwFolhatestes()) {
				// Verifica se frequencia foi definida
				if ((dwFolhateste.getFrequenciaHz() == null)
						|| (dwFolhateste.getFrequenciaHz() <= 0)
						|| (dwFolhateste.getTensaoMax() == null)
						|| (dwFolhateste.getTensaoMax().doubleValue() > 300d)
						|| (dwFolhateste.getTensaoMin() == null)
						|| (dwFolhateste.getTensaoMin().doubleValue() <= 0d)) {
					retorno.setResultadoEvento(obtemErro
							.getERRO_TENSAO_INVALIDA());
					return retorno;
				}

				// Verifica se o produto existe
				try {
					String hql = "from OmProduto t where t.cdProduto = '::cdProduto' ";
					hql += "and t.stAtivo = 1 ";
					hql += "order by t.idProduto ";
					hql = hql.replaceAll("::cdProduto", dwFolhateste
							.getOmProduto().getCdProduto());
					Query q = this.getDao().getSession().createQuery(hql);
					OmProduto item = (OmProduto) q.list().get(0);
					dwFolhateste.setOmProduto(item);
				} catch (Exception e) {
					retorno.setResultadoEvento(obtemErro
							.getERRO_PRODUTO_DESCONHECIDO());
					return retorno;
				}
				// Verifica se o gt existe da folha de teste
				try {
					String hql = "from OmGt t where t.cdGt = '::cdGt' ";
					hql += "and t.stAtivo = 1 ";
					hql += "order by t.idGt ";
					hql = hql.replaceAll("::cdGt", dwFolhateste.getOmGt()
							.getCdGt());
					Query q = this.getDao().getSession().createQuery(hql);
					OmGt item = (OmGt) q.list().get(0);
					dwFolhateste.setOmGt(item);
				} catch (Exception e) {
					retorno.setResultadoEvento(obtemErro
							.getERRO_GT_DESCONHECIDO());
					return retorno;
				}
				if (folha.getFolhaEtapasDTO() != null) {
					for (FolhaEtapaDTO folhaEtapa : folha.getFolhaEtapasDTO()) {
						for (DwTestesub testeSub : folhaEtapa.getTestesSub()) {
							// Verifica se a sub-etapa existe
							try {
								String hql = "from DwFtSub t where t.idFtSub = ::idFtSub ";

								hql = hql.replaceAll("::idFtSub", String
										.valueOf(testeSub.getDwFtSub()
												.getIdFtSub()));

								Query q = this.getDao().getSession()
										.createQuery(hql);

								DwFtSub dwFtSub = (DwFtSub) q.list().get(0);

								testeSub.setDwFtSub(dwFtSub);
							} catch (Exception e) {
								retorno.setResultadoEvento(obtemErro
										.getERRO_SUBETAPA_INVALIDA());
								return retorno;
							}
							// ms_cap_med_pos_falha
							if ((testeSub.getQtMedSegPosFalha() != null)
									&& (testeSub.getQtMedSegPosFalha() > 0)) {
								if ((testeSub.getMsCapMedPosFalha() == null)
										|| (testeSub.getMsCapMedPosFalha() <= 0)) {
									retorno.setResultadoEvento(obtemErro
											.getERRO_TEMPO_POSFALHA_INVALIDO());
									return retorno;
								}
							}

							for (DwTestesubetapa dwTestesubetapa : testeSub
									.getDwTestesubetapas()) {
								// Verifica se id_subparam existe
								DwFtSubparam dwFtSubparam = null;
								try {
									String hql = "from DwFtSubparam t where t.idSubparam = ::idSubparam ";

									hql = hql.replaceAll("::idSubparam", String
											.valueOf(dwTestesubetapa
													.getDwFtSubparam()
													.getIdSubparam()));

									Query q = this.getDao().getSession()
											.createQuery(hql);

									dwFtSubparam = (DwFtSubparam) q.list().get(
											0);

									dwTestesubetapa
											.setDwFtSubparam(dwFtSubparam);
								} catch (Exception e) {

									retorno.setEtapaComErro(folhaEtapa
											.getEtapa().getDsEtapa());
									retorno.setSubetapaComErro(dwFtSubparam
											.getDwFtSub().getDsSub());

									retorno.setResultadoEvento(obtemErro
											.getERRO_PARAMETRO_INVALIDO());
									return retorno;
								}
								// se NAO minimo <= meta <= maximo
								try {
									boolean limiteok = true;
									if (dwTestesubetapa.getDwFtSubparam()
											.getDwFtParam().getIsMinimo()) {
										if (dwTestesubetapa.getDwFtSubparam()
												.getDwFtParam().getIsMeta()) {
											if (dwTestesubetapa.getMinimo()
													.doubleValue() > dwTestesubetapa
															.getMeta().doubleValue()) {
												limiteok = false;
											}
										} else if (dwTestesubetapa
												.getDwFtSubparam()
												.getDwFtParam().getIsMaximo()) {
											if (dwTestesubetapa.getMinimo()
													.doubleValue() > dwTestesubetapa
															.getMaximo().doubleValue()) {
												limiteok = false;
											}
										}
									}
									if (dwTestesubetapa.getDwFtSubparam()
											.getDwFtParam().getIsMeta()) {
										if (dwTestesubetapa.getDwFtSubparam()
												.getDwFtParam().getIsMaximo()) {
											if (dwTestesubetapa.getMeta()
													.doubleValue() > dwTestesubetapa
															.getMaximo().doubleValue()) {
												limiteok = false;
											}
										}
									}
									if (!limiteok) {
										retorno.setResultadoEvento(obtemErro
												.getERRO_LIMITES_MEDICAO_INCONSISTENTES());
										return retorno;
									}
								} catch (Exception e) {
									retorno.setResultadoEvento(obtemErro
											.getERRO_LIMITES_MEDICAO_INCONSISTENTES());
									return retorno;
								}
								// st_ft_param
								dwFtSubparam = dwTestesubetapa
										.getDwFtSubparam();
								if (dwFtSubparam.getDwFtParam().getIsCombo()) {
									if ((dwTestesubetapa.getSt() == null)
											|| ((dwTestesubetapa.getSt()
													.byteValue() != dwFtSubparam
															.getDwFtParam()
															.getStValor1().byteValue())
													&& (dwTestesubetapa.getSt()
															.byteValue() != dwFtSubparam
																	.getDwFtParam()
																	.getStValor2()
																	.byteValue())
													&& (dwTestesubetapa.getSt()
															.byteValue() != dwFtSubparam
																	.getDwFtParam()
																	.getStValor3()
																	.byteValue())
													&& (dwTestesubetapa
															.getSt().byteValue() != dwFtSubparam
																	.getDwFtParam()
																	.getStValor4().byteValue()))) {

										retorno.setEtapaComErro(folhaEtapa
												.getEtapa().getCdEtapa()
												+ "-"
												+ folhaEtapa.getEtapa()
														.getDsEtapa());
										retorno.setSubetapaComErro(dwFtSubparam
												.getDwFtSub().getDsSub());

										retorno.setResultadoEvento(obtemErro
												.getERRO_VALOR_PARAMETRO_INVALIDO());
										return retorno;
									}
								}
							}
						}
					}
				}
			}
		}
		if (folha.getFolha().getTpFolha().intValue() == 1) { // folha montagem
			if ((folha.getFolha().getDwFolhamons() == null)
					|| (folha.getFolha().getDwFolhamons().size() == 0)) {
				retorno.setResultadoEvento(obtemErro
						.getERRO_RELACAO_PARTES_FALTANDO());
				return retorno;
			}
			for (DwFolhamon folhamon : folha.getFolha().getDwFolhamons()) {
				if ((folhamon.getDwFolhamoncomps() == null)
						|| (folhamon.getDwFolhamoncomps().size() == 0)) {
					retorno.setResultadoEvento(obtemErro
							.getERRO_RELACAO_PARTES_FALTANDO());
					return retorno;
				}
				// Verifica se o produto existe
				try {
					String hql = "from OmProduto t where t.cdProduto = '::cdProduto' ";
					hql += "and t.stAtivo = 1 ";
					hql += "order by t.idProduto ";
					hql = hql.replaceAll("::cdProduto", folhamon.getOmProduto()
							.getCdProduto());
					Query q = this.getDao().getSession().createQuery(hql);
					OmProduto item = (OmProduto) q.list().get(0);
					folhamon.setOmProduto(item);
				} catch (Exception e) {
					retorno.setResultadoEvento(obtemErro
							.getERRO_PRODUTO_PRINCIPAL_DESCONHECIDO());
					return retorno;
				}

				for (DwFolhamoncomp dwFolhamoncomp : folhamon
						.getDwFolhamoncomps()) {
					// Verifica se o produto existe
					try {
						String hql = "from OmProduto t where t.cdProduto = '::cdProduto' ";
						hql += "and t.stAtivo = 1 ";
						hql += "order by t.idProduto ";
						hql = hql.replaceAll("::cdProduto", dwFolhamoncomp
								.getOmProduto().getCdProduto());
						Query q = this.getDao().getSession().createQuery(hql);
						OmProduto item = (OmProduto) q.list().get(0);
						dwFolhamoncomp.setOmProduto(item);
						dwFolhamoncomp.setIdFolhamoncomp(0l);
					} catch (Exception e) {
						retorno.setResultadoEvento(obtemErro
								.getERRO_PRODUTO_COMPONENTE_DESCONHECIDO());
						return retorno;
					}
					dwFolhamoncomp.setDwFolhamon(folhamon);
				}
			}
		}

		retorno.setResultadoEvento(obtemErro.getEVENTO_BEM_SUCEDIDO());
		return retorno;
	}

	public DwFolharapcom getFolharapcom(DwFolharap dwFolharap,
			OmProduto omProduto) throws RegistroDesconhecidoException {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select dwFolharapcom");
		q.append("from DwFolharapcom dwFolharapcom ");
		q.append("where dwFolharapcom.dwFolharap = :dwFolharap");
		q.append("and dwFolharapcom.omProduto = :omProduto");
		q.defineParametro("dwFolharap", dwFolharap);
		q.defineParametro("omProduto", omProduto);
		q.query().setMaxResults(1);
		DwFolharapcom dwFolharapcom = (DwFolharapcom) q.uniqueResult();
		if (dwFolharapcom == null) {
			throw new RegistroDesconhecidoException();
		}
		return dwFolharapcom;

	}

	public DwFolharapcom getFolharapcom(DwFolha dwFolha, OmProduto omProduto)
			throws RegistroDesconhecidoException {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select c");
		q.append("from DwFolha a");
		q.append("join a.dwFolharaps b");
		q.append("join b.dwFolharapcoms c");
		q.append("where a.idFolha = :idfolha");
		q.append("and c.omProduto = :omProduto");
		q.defineParametro("idfolha", dwFolha.getIdFolha());
		q.defineParametro("omProduto", omProduto);
		q.query().setMaxResults(1);
		DwFolharapcom dwFolharapcom = (DwFolharapcom) q.uniqueResult();
		if (dwFolharapcom == null) {
			throw new RegistroDesconhecidoException();
		}
		return dwFolharapcom;
	}

	/**
	 * Pega DwFolhaIac pelo id de DwFolha
	 *
	 * @param dwFolha
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwFolhaiac getFolhaiac(DwFolha dwFolha) throws RegistroDesconhecidoException {
		MapQuery q = null;

		if (getDaoSession() != null)
			q = new MapQuery(getDaoSession());
		else {
			try {
				q = new MapQuery(getDaoSessionStatless());
			} catch (SemSessaoHibernateException e) {
			}
		}

		q.append("select dwFolhaiac");
		q.append("from DwFolhaiac dwFolhaiac ");
		q.append("join fetch dwFolhaiac.omProduto b");
		q.append("where dwFolhaiac.dwFolha = :dwFolha");
		q.defineParametro("dwFolha", dwFolha);
		q.query().setMaxResults(1);
		DwFolhaiac dwFolhaiac = (DwFolhaiac) q.uniqueResult();
		if (dwFolhaiac == null) {
			throw new RegistroDesconhecidoException();
		}
		return dwFolhaiac;

	}

	public DwFolharap getFolharap(DwFolha dwFolha, DwRap dwRap)
			throws RegistroDesconhecidoException {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("from DwFolharap dwFolharap ");
		q.append("where dwFolharap.dwFolha = :dwFolha");
		q.append("and dwFolharap.dwRap = :dwRap");
		q.defineParametro("dwFolha", dwFolha);
		q.defineParametro("dwRap", dwRap);
		q.query().setMaxResults(1);
		DwFolharap dwFolharap = (DwFolharap) q.uniqueResult();
		if (dwFolharap == null) {
			throw new RegistroDesconhecidoException();
		}
		return dwFolharap;

	}

	/**
	 * Retorna DwFolharap baseada somente em dwFolha. Apesar de estar da relaçãoo entre DwFolha e DwFolhaRap estar mapeada como 1-n, na
	 * prÃ¡tica Ã© 1-1
	 *
	 * @param dwFolha
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwFolharap getFolharap(DwFolha dwFolha)
			throws RegistroDesconhecidoException {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("from DwFolharap dwFolharap ");
		q.append("where dwFolharap.dwFolha = :dwFolha");
		q.defineParametro("dwFolha", dwFolha);
		q.query().setMaxResults(1);
		DwFolharap dwFolharap = (DwFolharap) q.uniqueResult();
		if (dwFolharap == null) {
			throw new RegistroDesconhecidoException();
		}
		return dwFolharap;

	}

	public BigDecimal getPcsPorCicloAtivasFromFolhaiacOuDwFolha(DwFolha dwFolha) throws SemPcsPorCicloAtivasException {
		return getPcsPorCicloAtivasFromDwFolhaiac(dwFolha);
	}

	public BigDecimal getPcsPorCicloAtivasFromDwFolhaiac(DwFolha dwFolha) {
		DwFolhaiac dwFolhaiac = null;
		BigDecimal pecasPorCicloAtivo = BigDecimal.ONE;
		if (!dwFolha.getDwFolhaiacs().isEmpty()) {
			dwFolhaiac = dwFolha.getDwFolhaiacs().iterator().next();
		}
		if (dwFolhaiac != null) {
			pecasPorCicloAtivo = dwFolhaiac.getQtAtiva();
		} else {
			if (!dwFolha.getDwFolharaps().isEmpty()) {
				pecasPorCicloAtivo = BigDecimal.ZERO;
				for (DwFolharap dwFolharap : dwFolha.getDwFolharaps()) {
					pecasPorCicloAtivo = pecasPorCicloAtivo
							.add(getPcsPorCicloAtivasFromDwFolharap(dwFolharap));
				}
			}
		}
		return pecasPorCicloAtivo;
	}

	public BigDecimal getPcsPorCicloAtivasFromDwFolha(DwFolha dwFolha) {
		DwFolhaiac dwFolhaiac = null;
		BigDecimal pecasPorCicloAtivo = BigDecimal.ZERO;
		if (!dwFolha.getDwFolhaiacs().isEmpty()) {
			dwFolhaiac = dwFolha.getDwFolhaiacs().iterator().next();
		}
		if (dwFolhaiac != null) {
			pecasPorCicloAtivo = pecasPorCicloAtivo.add(dwFolhaiac.getQtAtiva());
		}
		if (!dwFolha.getDwFolharaps().isEmpty()) {
			for (DwFolharap dwFolharap : dwFolha.getDwFolharaps()) {
				pecasPorCicloAtivo = pecasPorCicloAtivo.add(getPcsPorCicloAtivasFromDwFolharap(dwFolharap));
			}
		}
		if (pecasPorCicloAtivo.equals(BigDecimal.ZERO))
			pecasPorCicloAtivo = BigDecimal.ONE;
		return pecasPorCicloAtivo;
	}

	public boolean isProducaoEmMolde(DwFolha dwFolha) {
		DwFolhaiac dwFolhaiac = null;
		if (!dwFolha.getDwFolhaiacs().isEmpty()) {
			dwFolhaiac = dwFolha.getDwFolhaiacs().iterator().next();
		}
		if (dwFolhaiac != null) {
			return false;
		} else {
			if (!dwFolha.getDwFolharaps().isEmpty()) {
				return true;
			}
		}

		return false;
	}

	public List<OmProduto> getProdutosFromDwFolha(DwFolha dwFolha) {
		DwFolhaiac dwFolhaiac = null;
		List<OmProduto> retorno = new ArrayList<OmProduto>();

		if (!dwFolha.getDwFolhaiacs().isEmpty()) {
			dwFolhaiac = dwFolha.getDwFolhaiacs().iterator().next();
		}
		if (dwFolhaiac != null) {
			retorno.add(dwFolhaiac.getOmProduto());
		}

		if (!dwFolha.getDwFolharaps().isEmpty()) {
			Iterator<DwFolharap> it = dwFolha.getDwFolharaps().iterator();
			while (it.hasNext()) {
				DwFolharap dwFolharap = it.next();
				retorno.addAll(getProdutosFromDwFolharap(dwFolharap));
			}
		}

		return retorno;
	}

	public List<OmProduto> getProdutosFromDwFolhaiac(DwFolha dwFolha) {
		DwFolhaiac dwFolhaiac = null;
		List<OmProduto> retorno = new ArrayList<OmProduto>();
		if (!dwFolha.getDwFolhaiacs().isEmpty()) {
			dwFolhaiac = dwFolha.getDwFolhaiacs().iterator().next();
		}
		if (dwFolhaiac != null) {
			retorno.add(dwFolhaiac.getOmProduto());
		} else {
			if (!dwFolha.getDwFolharaps().isEmpty()) {
				Iterator<DwFolharap> it = dwFolha.getDwFolharaps().iterator();
				while (it.hasNext()) {
					DwFolharap dwFolharap = it.next();
					retorno.addAll(getProdutosFromDwFolharap(dwFolharap));
				}
			}
		}

		return retorno;
	}

	private List<OmProduto> getProdutosFromDwFolharap(DwFolharap dwFolharap) {
		List<OmProduto> retorno = new ArrayList<OmProduto>();

		if (dwFolharap.getDwFolharapcoms().isEmpty() == false) {
			for (DwFolharapcom dwFolharapcom : dwFolharap.getDwFolharapcoms()) {
				retorno.add(dwFolharapcom.getOmProduto());
			}
		}

		return retorno;
	}

	public List<DwFolharapcom> getDwFolharapcomsFromDwFolha(DwFolha dwFolha) {
		List<DwFolharapcom> retorno = new ArrayList<DwFolharapcom>();
		if (!dwFolha.getDwFolharaps().isEmpty()) {
			Iterator<DwFolharap> it = dwFolha.getDwFolharaps().iterator();
			while (it.hasNext()) {
				DwFolharap dwFolharap = it.next();
				retorno.addAll(getDwFolharapcomsFromDwFolharap(dwFolharap));
			}
		}

		return retorno;
	}

	private List<DwFolharapcom> getDwFolharapcomsFromDwFolharap(
			DwFolharap dwFolharap) {
		List<DwFolharapcom> retorno = new ArrayList<DwFolharapcom>();

		if (dwFolharap.getDwFolharapcoms().isEmpty() == false) {
			retorno.addAll(dwFolharap.getDwFolharapcoms());
		}

		return retorno;
	}

	private BigDecimal getPcsPorCicloAtivasFromDwFolharap(DwFolharap dwFolharap) {

		BigDecimal pcsCicloAtivas = BigDecimal.ZERO;

		/*
		 * Alessandre: em 24-6-14 comentei o if abaixo deixando ativo apenas o else. Na importacao do injet dwfolharap estava com a
		 * qtcavativa ok mas dwfolharapcom nao estava. Alessandre: em 01-12-14 reativei o if abaixo pois dwfolharapcom possui agora os
		 * valores certos e dwfolharap NAO.
		 */
		if (dwFolharap.getDwFolharapcoms().isEmpty() == false) {
			for (DwFolharapcom dwFolharapcom : dwFolharap.getDwFolharapcoms()) {
				pcsCicloAtivas = pcsCicloAtivas.add(dwFolharapcom.getQtAtiva());
			}
		} else {
			pcsCicloAtivas = dwFolharap.getQtUsada();
		}

		if (pcsCicloAtivas.equals(BigDecimal.ZERO)) {
			pcsCicloAtivas = BigDecimal.ONE;
		}
		return pcsCicloAtivas;
	}

	private BigDecimal getPcsPorCicloTotaisFromDwFolharap(DwFolharap dwFolharap) {

		BigDecimal pcsCicloTotais = BigDecimal.ZERO;

		if (dwFolharap.getDwFolharapcoms().isEmpty() == false) {
			for (DwFolharapcom dwFolharapcom : dwFolharap.getDwFolharapcoms()) {
				pcsCicloTotais = pcsCicloTotais.add(dwFolharapcom.getQtTotal());
			}
		} else {
			pcsCicloTotais = dwFolharap.getQtUsada();
		}

		if (pcsCicloTotais.equals(BigDecimal.ZERO)) {
			pcsCicloTotais = BigDecimal.ONE;
		}
		return pcsCicloTotais;
	}

	/**
	 * Pegar a quantidade de cavidades ativas relaciona da a folha
	 * <p>
	 * Primeiramente procura pelas cavidades em dw_folhaiac. Se não encontrar, procura em dw_folharap. Se ainda assim não encontrar nada,
	 * levanta exceçãoo
	 *
	 * @param dwFolha
	 *            não pode ser null e deve ter pelo menos seu id preenchido.
	 *            <p>
	 *            Caso não encontre ciclo padrão na relaçãoo folha e posto de trabalho, usar o SegCiclopadrao de DwFolha passado no mÃ©todo.
	 *            Se contÃ©udo não estiver preenchido, pega o que esta na tabela de folhas
	 * @param omPt
	 *            não pode ser null e deve ter pelo menos seu id preenchido
	 * @return
	 * @throws SemPcsPorCicloAtivasException
	 */
	public BigDecimal getPcsPorCicloAtivas(DwFolha dwFolha) throws SemPcsPorCicloAtivasException {

		BigDecimal pcsCicloAtivas = BigDecimal.ZERO;
		try {

			DwFolhaiac dwFolhaiac = this.getFolhaiac(dwFolha);
			pcsCicloAtivas = dwFolhaiac.getQtAtiva();

		} catch (RegistroDesconhecidoException eIac) {
		}
		try {
			DwFolharap dwfolharap = this.getFolharap(dwFolha);
			pcsCicloAtivas = pcsCicloAtivas.add(getPcsPorCicloAtivasFromDwFolharap(dwfolharap));
		} catch (RegistroDesconhecidoException eRap) {
		}

		/*
		 * O eduardo comentou o if abaixo, mas nao sabe o motivo. Descomentei (Alessandre) em 11-12-13 pois estava dando erro na
		 * consolidacao da Semp
		 */
		if (pcsCicloAtivas == null || pcsCicloAtivas.equals(BigDecimal.ZERO)) {
			// Alessandre: vou assumir 1 em 28-2-13, senao vou ter erro no
			// detalhe da maquina
			pcsCicloAtivas = BigDecimal.ONE;
			// throw new SemPcsPorCicloAtivasException(dwFolha.getIdFolha());
		}

		return pcsCicloAtivas;
	}

	public BigDecimal getPcsCicloAtivas(Map<DwFolha, BigDecimal> mapQtPcsCicloAtivas, DwFolha folha) {
		BigDecimal pcsCicloAtivas = mapQtPcsCicloAtivas.get(folha);
		if (pcsCicloAtivas == null) {

			// recupera pcs por ciclo
			try {
				pcsCicloAtivas = getPcsPorCicloAtivas(folha);
			} catch (Exception e) {
				pcsCicloAtivas = BigDecimal.ONE;
			}

			mapQtPcsCicloAtivas.put(folha, pcsCicloAtivas);

		}
		return pcsCicloAtivas;
	}

	/**
	 * Pegar a quantidade de cavidades totais relacionada a folha
	 * <p>
	 * Primeiramente procura pelas cavidades em dw_folhaiac. Se não encontrar, procura em dw_folharap. Se ainda assim não encontrar nada,
	 * levanta exceçãoo
	 *
	 * @param dwFolha
	 *            não pode ser null e deve ter pelo menos seu id preenchido.
	 *            <p>
	 *            Caso não encontre ciclo padrão na relaçãoo folha e posto de trabalho, usar o SegCiclopadrao de DwFolha passado no mÃ©todo.
	 *            Se contÃ©udo não estiver preenchido, pega o que esta na tabela de folhas
	 * @param omPt
	 *            não pode ser null e deve ter pelo menos seu id preenchido
	 * @return
	 * @throws SemPcsPorCicloAtivasException
	 */
	public BigDecimal getPcsPorCicloTotais(DwFolha dwFolha) throws SemPcsPorCicloAtivasException {
		BigDecimal pcsCicloTotais = BigDecimal.ZERO;
		try {
			DwFolhaiac dwFolhaiac = this.getFolhaiac(dwFolha);
			pcsCicloTotais = dwFolhaiac.getQtAtiva();

		} catch (RegistroDesconhecidoException eIac) {
			try {
				DwFolharap dwfolharap = this.getFolharap(dwFolha);
				pcsCicloTotais = getPcsPorCicloTotaisFromDwFolharap(dwfolharap);
			} catch (RegistroDesconhecidoException eRap) {
				pcsCicloTotais = BigDecimal.ZERO;
			}

		}

		if (pcsCicloTotais.equals(BigDecimal.ZERO)) {
			pcsCicloTotais = BigDecimal.ONE;
		}

		return pcsCicloTotais;
	}

	public BigDecimal getPcsPorCicloAtivasNaoEncontrandoAssumeUm(DwFolha dwFolha) {
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		try {
			return folhaRN.getPcsPorCicloAtivas(dwFolha);
		} catch (SemPcsPorCicloAtivasException e) {
			return BigDecimal.ONE;
		}
	}

	public BigDecimal getPcsPorCicloAtivasEmDwFolhaIACComTpFolhaETpPt(
			String cdProduto, DwFolhaTemplate.TpFolha tpFolha,
			OmTpptTemplate.Type tpptType) {
 
		boolean isFiltroTpFolha = (tpFolha != null);
		boolean isFiltroTpptType = (tpptType != null);

		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("SELECT dwFolhaiac FROM DwFolhaiac dwFolhaiac");
		q.append("INNER JOIN dwFolhaiac.omProduto omProduto ");
		q.append("INNER JOIN dwFolhaiac.dwFolha dwFolha ");
		q.append("INNER JOIN dwFolha.omTppt omTppt ");

		q.append("WHERE omProduto.cdProduto = :cdProduto ");
		q.append("AND omProduto.stAtivo = :stAtivoProduto ");
		q.append("AND dwFolha.stAtivo = :stAtivoDwFolha ");

		if (isFiltroTpFolha) {
			q.append("AND dwFolha.tpFolha = :tpFolha");
		}

		if (isFiltroTpptType) {
			q.append("AND dwFolha.omTppt.idTppt = :idTppt");
		}

		q.append("ORDER BY dwFolhaiac.idFolhaiac DESC, dwFolha.idFolha DESC");

		q.defineParametro("cdProduto", cdProduto);
		q.defineParametro("stAtivoProduto", (byte) 1);
		q.defineParametro("stAtivoDwFolha", (byte) 1);

		if (isFiltroTpFolha) {
			q.defineParametro("tpFolha", tpFolha.getValue());
		}

		if (isFiltroTpptType) {
			q.defineParametro("idTppt", tpptType.getId());
		}

		q.setMaxResults(1);

		DwFolhaiac dwFolhaiac = (DwFolhaiac) q.uniqueResult();

		BigDecimal retorno = BigDecimal.ONE;

		if (dwFolhaiac != null && dwFolhaiac.getQtAtiva() != null) {
			retorno = dwFolhaiac.getQtAtiva();
		}

		return retorno;
	}

	private String getChaveParaMapCavidadeProduto(DwFolha dwFolha, OmProduto omProduto) {
		return dwFolha.getIdFolha() + "|" + omProduto.getCdProduto();
	}

	public BigDecimal getPcsPorCicloAtivas(Map<String, BigDecimal> mapCavAtivaProd, DwFolha dwFolha, OmProduto omProduto) {
		String chave = getChaveParaMapCavidadeProduto(dwFolha, omProduto);

		BigDecimal cavAtivas = mapCavAtivaProd.get(chave);

		if (cavAtivas == null) {
			try {
				cavAtivas = getPcsPorCicloAtivas(dwFolha, omProduto);
			} catch (SemPcsPorCicloAtivasException e) {
				cavAtivas = BigDecimal.ONE;
			}
			mapCavAtivaProd.put(chave, cavAtivas);
		}

		return cavAtivas;
	}

	public BigDecimal getPcsPorCicloTodas(Map<String, BigDecimal> mapCavTotalProd, DwFolha dwFolha, OmProduto omProduto) {
		String chave = getChaveParaMapCavidadeProduto(dwFolha, omProduto);

		BigDecimal cavTotais = mapCavTotalProd.get(chave);

		if (cavTotais == null) {
			try {
				cavTotais = getPcsPorCicloTodas(dwFolha, omProduto);
			} catch (SemPcsPorCicloAtivasException e) {
				cavTotais = BigDecimal.ONE;
			}
			mapCavTotalProd.put(chave, cavTotais);
		}

		return cavTotais;
	}

	/**
	 * Pegar a quantidade de cavidades ativas relacionada a folha e a um produto especÃ­fico
	 * <p>
	 * Primeiramente procura pelas cavidades em dw_folhaiac. Se não encontrar, procura em dw_folharap. Se ainda assim não encontrar nada,
	 * levanta exceçãoo
	 *
	 * @param dwFolha
	 *            não pode ser null e deve ter pelo menos seu id preenchido.
	 * @param omProduto
	 *            não pode ser null e deve ter pelo menos seu id preenchido
	 * @return
	 * @throws SemPcsPorCicloAtivasException
	 */
	public BigDecimal getPcsPorCicloAtivas(DwFolha dwFolha, OmProduto omProduto) throws SemPcsPorCicloAtivasException {
		BigDecimal pcsCicloAtivas = BigDecimal.ZERO;
		try {
			DwFolhaiac dwFolhaiac = null;
			for (DwFolhaiac pojo : dwFolha.getDwFolhaiacs()) {
				dwFolhaiac = pojo;
			}
			if (dwFolhaiac == null)
				throw new RegistroDesconhecidoException();

			if (dwFolhaiac.getOmProduto() != null && dwFolhaiac.getOmProduto().getCdProduto().equals(omProduto.getCdProduto()))
				pcsCicloAtivas = dwFolhaiac.getQtAtiva();
			else
				throw new RegistroDesconhecidoException();

		} catch (RegistroDesconhecidoException eIac) {
			for (DwFolharap dwfolharap : dwFolha.getDwFolharaps()) {
				for (DwFolharapcom drapc : dwfolharap.getDwFolharapcoms()) {
					if (drapc.getOmProduto().getCdProduto().equals(omProduto.getCdProduto())) {
						pcsCicloAtivas = pcsCicloAtivas.add(drapc.getQtAtiva());
					}
				}
			}
		}

		if (pcsCicloAtivas == null || pcsCicloAtivas.equals(BigDecimal.ZERO)) {
			// tratamento para eventual inconsistencia na base de dados
			// (associaçãooe entre folha e produtos - UNICOBA)

			// Marcos Sardinha: 2017-01-20 - qdo nao encontra especializacao por produto, procura somente por folha
			pcsCicloAtivas = getPcsPorCicloAtivas(dwFolha);
		}

		return pcsCicloAtivas;
	}

	/**
	 * Pegar a quantidade de cavidades totais relacionada a folha e a um produto especÃ­fico
	 * <p>
	 * Primeiramente procura pelas cavidades em dw_folhaiac. Se não encontrar, procura em dw_folharap. Se ainda assim não encontrar nada,
	 * levanta exceçãoo
	 *
	 * @param dwFolha
	 *            não pode ser null e deve ter pelo menos seu id preenchido.
	 * @param omProduto
	 *            não pode ser null e deve ter pelo menos seu id preenchido
	 * @return
	 * @throws SemPcsPorCicloAtivasException
	 */
	public BigDecimal getPcsPorCicloTodas(DwFolha dwFolha, OmProduto omProduto) throws SemPcsPorCicloAtivasException {
		BigDecimal pcsCicloTotal = BigDecimal.ZERO;
		try {
			DwFolhaiac dwFolhaiac = null;
			for (DwFolhaiac pojo : dwFolha.getDwFolhaiacs()) {
				dwFolhaiac = pojo;
			}
			if (dwFolhaiac == null)
				throw new RegistroDesconhecidoException();

			if (dwFolhaiac.getOmProduto() != null && dwFolhaiac.getOmProduto().getCdProduto().equals(omProduto.getCdProduto()))
				pcsCicloTotal = dwFolhaiac.getQtAtiva();
			else
				throw new RegistroDesconhecidoException();

		} catch (RegistroDesconhecidoException eIac) {
			for (DwFolharap dwfolharap : dwFolha.getDwFolharaps()) {
				for (DwFolharapcom drapc : dwfolharap.getDwFolharapcoms()) {
					if (drapc.getOmProduto().getCdProduto().equals(omProduto.getCdProduto())) {
						pcsCicloTotal = pcsCicloTotal.add(drapc.getQtTotal());
					}
				}
			}
		}

		if (pcsCicloTotal == null || pcsCicloTotal.equals(BigDecimal.ZERO)) {
			// tratamento para eventual inconsistencia na base de dados
			// (associaçãooe entre folha e produtos - UNICOBA)
			// pcsCicloTotal = BigDecimal.ONE;

			// Marcos Sardinha: 2017-02-01 - qdo nao encontra especializacao por produto, procura somente por folha
			pcsCicloTotal = getPcsPorCicloTotais(dwFolha);

		}

		return pcsCicloTotal;
	}

	/**
	 * Pegar o ciclo padrão relacionado a folha e ao posto de trabalho
	 * <p>
	 * Se não encontrar nesta condiçãoo, pega o ciclo padrão apenas de DwFolha
	 *
	 * @param dwFolha
	 *            não pode ser null e deve ter pelo menos seu id preenchido.
	 *            <p>
	 *            Caso não encontre ciclo padrão na relaçãoo folha e posto de trabalho, usar o SegCiclopadrao de DwFolha passado no mÃ©todo.
	 *            Se contÃ©udo não estiver preenchido, pega o que esta na tabela de folhas
	 * @param omPt
	 *            não pode ser null e deve ter pelo menos seu id preenchido
	 * @return
	 * @throws SemCicloPadraoException
	 */
	public BigDecimal getCicloPadrao(DwFolha dwFolha, OmPt omPt) throws SemCicloPadraoException {
		BigDecimal cicloPadrao = BigDecimal.ZERO;
		try {

			DwFolhacic dwFolhacic = this.getFolhacic(dwFolha, omPt);

			cicloPadrao = dwFolhacic.getSegCiclopadrao();

		} catch (SemCicloPadraoException e) {
			cicloPadrao = getCicloPadraoFromDwFolha(dwFolha, omPt);
			if (cicloPadrao == null) {
				throw new SemCicloPadraoException(dwFolha.getIdFolha(), omPt.getIdPt());
			}
		}

		return cicloPadrao;

	}

	public BigDecimal getCicloPadrao(Map<String, BigDecimal> mapCicloPadrao, DwFolha dwFolha, OmPt omPt) throws SemCicloPadraoException {
		String chave = getChaveFolhaPt(dwFolha, omPt);

		BigDecimal cicloPadrao = mapCicloPadrao.get(chave);
		if (cicloPadrao == null) {
			cicloPadrao = getCicloPadrao(dwFolha, omPt);
			mapCicloPadrao.put(chave, cicloPadrao);
		}

		return cicloPadrao;

	}

	public BigDecimal getCicloMinimoFromDwFolha(DwFolha dwFolha, OmPt omPt) throws SemCicloPadraoException {
		BigDecimal cicloMinimo = BigDecimal.ZERO;

		DwFolha dwFolhaPesq = null;
		try {
			dwFolhaPesq = getDwFolhaByCdFolhaEOmPt(dwFolha.getCdFolha(), omPt).getDwFolha();
			if (dwFolhaPesq == null)
				dwFolhaPesq = dwFolha;
		} catch (Exception e) {
			dwFolhaPesq = null;
		}

		if (dwFolhaPesq != null) {
			if (dwFolhaPesq.getSegCiclominimo() == null || dwFolhaPesq.getSegCiclominimo().equals(BigDecimal.ZERO)) {
				throw new SemCicloPadraoException(dwFolha.getIdFolha(), omPt.getIdPt());
			} else {
				cicloMinimo = dwFolhaPesq.getSegCiclominimo();
			}

		}
		return cicloMinimo;
	}

	public BigDecimal getCicloMaximoFromDwFolha(DwFolha dwFolha, OmPt omPt) throws SemCicloPadraoException {
		BigDecimal cicloMaximo = BigDecimal.ZERO;

		if (dwFolha.getSegCiclotimeout() == null || dwFolha.getSegCiclotimeout().equals(BigDecimal.ZERO)) {
			DwFolha dwFolhaPesq = this.pesquisarFolhaPorID(dwFolha.getIdFolha());
			if (dwFolhaPesq != null) {
				if (dwFolhaPesq.getSegCiclotimeout() == null || dwFolhaPesq.getSegCiclotimeout().equals(BigDecimal.ZERO)) {
					throw new SemCicloPadraoException(dwFolha.getIdFolha(), omPt.getIdPt());
				} else {
					cicloMaximo = dwFolhaPesq.getSegCiclotimeout();
				}

			}
		} else {
			cicloMaximo = dwFolha.getSegCiclotimeout();
		}
		return cicloMaximo;
	}

	public BigDecimal getCicloPadraoFromDwFolha(DwFolha dwFolha, OmPt omPt) throws SemCicloPadraoException {
		BigDecimal cicloPadrao = BigDecimal.ZERO;

		if (dwFolha.getSegCiclopadrao() == null || dwFolha.getSegCiclopadrao().equals(BigDecimal.ZERO)) {
			DwFolha dwFolhaPesq = this.pesquisarFolhaPorID(dwFolha.getIdFolha());
			if (dwFolhaPesq != null) {
				if (dwFolhaPesq.getSegCiclopadrao() == null || dwFolhaPesq.getSegCiclopadrao().equals(BigDecimal.ZERO)) {
					throw new SemCicloPadraoException(dwFolha.getIdFolha(), omPt.getIdPt());
				} else {
					cicloPadrao = dwFolhaPesq.getSegCiclopadrao();
				}

			}
		} else {
			cicloPadrao = dwFolha.getSegCiclopadrao();
		}
		return cicloPadrao;
	}

	public BigDecimal getFatorContagemFromDwFolha(DwFolha dwFolha, OmPt omPt) throws SemPacoteOuFatorException {
		BigDecimal fatorContagem = null;
		DwFolha dwFolhaPesq = this.pesquisarFolhaPorID(dwFolha.getIdFolha());

		for (DwFolhacic cic : dwFolhaPesq.getDwFolhacics()) {
			if (cic.getOmPt() != null && cic.getOmPt().getIdPt().equals(omPt.getIdPt())) {
				if (cic.getQtFatorcontagem() != null)
					fatorContagem = cic.getQtFatorcontagem();
			}
		}
		if (fatorContagem == null && dwFolhaPesq.getQtFatorcontagem() != null) {
			fatorContagem = dwFolhaPesq.getQtFatorcontagem();
		}
		if (fatorContagem == null)
			throw new SemPacoteOuFatorException(dwFolha.getIdFolha(), omPt.getIdPt());

		return fatorContagem;
	}


	public Integer getPacoteCicloFromDwFolha(DwFolha dwFolha, OmPt omPt) throws SemPacoteOuFatorException {
		DwFolha dwFolhaPesq = this.pesquisarFolhaPorID(dwFolha.getIdFolha());

		Integer pacoteCiclo = null;

		// Verificar se existe especializacao de ciclo. Se existir considerar essas informações para o pacote de ciclo
		for (DwFolhacic cic : dwFolhaPesq.getDwFolhacics()) {
			if (cic.getOmPt() != null && cic.getOmPt().getIdPt().equals(omPt.getIdPt())) {
				if (cic.getQtPacoteciclo() != null) {
					pacoteCiclo = cic.getQtPacoteciclo();
				}
			}
		}

		if (pacoteCiclo == null && dwFolhaPesq.getQtPacoteciclo() != null) {
			pacoteCiclo = dwFolhaPesq.getQtPacoteciclo();
		}

		if (pacoteCiclo == null)
			throw new SemPacoteOuFatorException(dwFolha.getIdFolha(), omPt.getIdPt());

		return pacoteCiclo;
	}

	public BigDecimal getCicloPadraoFromDwFolhacisOuDwFolha(DwFolha dwFolha,
			OmPt omPt) throws SemCicloPadraoException {
		if (dwFolha == null)
			throw new SemCicloPadraoException(0l, omPt.getIdPt());

		BigDecimal cicloPadrao = getCicloPadraoFromDwFolhacis(
				dwFolha.getDwFolhacics(), omPt);
		if (cicloPadrao == null) {
			cicloPadrao = getCicloPadraoFromDwFolha(dwFolha, omPt);
			if (cicloPadrao == null) {
				throw new SemCicloPadraoException(dwFolha.getIdFolha(),
						omPt.getIdPt());
			}
		}
		return cicloPadrao;
	}

	public BigDecimal getCicloPadraoFromDwFolhacis(Set<DwFolhacic> folhaCics,
			OmPt omPt) {
		DwFolhacic dwFolhacic = getFolhacicFromDwFolhacics(folhaCics, omPt);
		if (dwFolhacic != null) {
			return dwFolhacic.getSegCiclopadrao();
		}
		return null;

	}

	/**
	 * Pegar DwFolhaCic
	 *
	 * @param dwFolha
	 * @param omPt
	 * @return
	 * @throws SemCicloPadraoException
	 */
	public DwFolhacic getFolhacic(DwFolha dwFolha, OmPt omPt) throws SemCicloPadraoException {
		Validate.notNull(dwFolha, "dwFolha");
		Validate.notNull(omPt, "omPt");

		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select a");
		q.append("from DwFolhacic a ");
		q.append("where a.dwFolha.idFolha = :dwFolha");
		q.append("and a.omPt.idPt = :omPt");
		q.defineParametro("dwFolha", dwFolha.getIdFolha());
		q.defineParametro("omPt", omPt.getIdPt());
		q.query().setMaxResults(1);
		DwFolhacic dwFolhacic = (DwFolhacic) q.uniqueResult();
		if (dwFolhacic == null) {
			throw new SemCicloPadraoException(dwFolha.getIdFolha(),
					omPt.getIdPt());
		}
		return dwFolhacic;
	}

	private String getChaveFolhaPt(DwFolha dwFolha, OmPt omPt) {
		Validate.notNull(dwFolha, "dwFolha");
		Validate.notNull(omPt, "omPt");

		return dwFolha.getIdFolha() + "|" + omPt.getIdPt();
	}

	public DwFolhacic getFolhaCic(Map<String, DwFolhacic> mapFolhaCic, DwFolha dwFolha, OmPt omPt) throws SemCicloPadraoException {
		String chave = getChaveFolhaPt(dwFolha, omPt);

		DwFolhacic dwFolhaCic = mapFolhaCic.get(chave);

		if (dwFolhaCic == null) {
			dwFolhaCic = getFolhacic(dwFolha, omPt);
			mapFolhaCic.put(chave, dwFolhaCic);
		}

		return dwFolhaCic;
	}

	public DwFolhacic getFolhacicFromDwFolhacics(Set<DwFolhacic> folhaCics,
			OmPt omPt) {
		Validate.notNull(folhaCics, "folhaCics nao pode ser nulo");
		Validate.notNull(omPt, "omPt nao pode ser nulo");

		for (DwFolhacic folhaCic : folhaCics) {
			if (folhaCic.getOmPt() != null) {
				if (folhaCic.getOmPt().getIdPt().equals(omPt.getIdPt())) {
					return folhaCic;
				}
			}
		}

		return null;
	}

	public FolhasDTO getFolhasporProduto(ProdutoDTO filtro) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select f from DwFolha f ");
		List<DwFolha> listaPesquisa = null;
		try {
			listaPesquisa = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<FolhaDTO> lista = new ArrayList<FolhaDTO>();

		if (listaPesquisa != null) {
			for (DwFolha item : listaPesquisa) {
				FolhaDTO itemDTO = new FolhaDTO();
				itemDTO.setFolha(item.clone());

				// DwFolhateste
				if (item.getDwFolhatestes() != null) {
					itemDTO.getFolha().setDwFolhatestes(
							new HashSet<DwFolhateste>());
					for (DwFolhateste itemList : item.getDwFolhatestes()) {
						DwFolhateste dwFolhateste = (DwFolhateste) itemList
								.clone();
						itemDTO.getFolha().getDwFolhatestes().add(dwFolhateste);

						List<FolhaEtapaDTO> folhaEtapas = new ArrayList<FolhaEtapaDTO>();
						for (DwTestesub dwTestesub : itemList.getDwTestesubs()) {
							boolean existe = false;
							FolhaEtapaDTO folhaEtapa = new FolhaEtapaDTO();
							for (FolhaEtapaDTO folhaEtapaDTO : folhaEtapas) {
								if (dwTestesub.getDwFtSub().getDwFtEtapa()
										.getIdFtEtapa() == folhaEtapaDTO
												.getEtapa().getIdFtEtapa()) {
									folhaEtapa = folhaEtapaDTO;
									existe = true;
								}
							}
							if (!existe) {
								folhaEtapa.setEtapa((DwFtEtapa) dwTestesub
										.getDwFtSub().getDwFtEtapa().clone());
								folhaEtapa.setOrdem(dwTestesub.getOrdemEtapa());
								folhaEtapa
										.setTestesSub(new ArrayList<DwTestesub>());
								folhaEtapas.add(folhaEtapa);
							}
							DwTestesub testeSub = (DwTestesub) dwTestesub
									.clone();

							testeSub.setDwTestesubetapas(new HashSet<DwTestesubetapa>());
							if (dwTestesub.getDwTestesubetapas() != null) {
								for (DwTestesubetapa testeSubetapa : dwTestesub
										.getDwTestesubetapas()) {
									testeSub.getDwTestesubetapas().add(
											(DwTestesubetapa) testeSubetapa
													.clone());
								}
							}
							folhaEtapa.getTestesSub().add(testeSub);
						}
						itemDTO.setFolhaEtapasDTO(folhaEtapas);
					}
				}

				// DwFolhamon
				if (item.getDwFolhamons() != null) {
					itemDTO.getFolha().setDwFolhamons(new HashSet<DwFolhamon>());
					for (DwFolhamon itemList : item.getDwFolhamons()) {
						DwFolhamon dwFolhamon = (DwFolhamon) itemList.clone();
						for (DwFolhamoncomp dwFolhamoncomp : itemList.getDwFolhamoncomps()) {
							dwFolhamon.getDwFolhamoncomps().add((DwFolhamoncomp) dwFolhamoncomp.clone());
						}
						itemDTO.getFolha().getDwFolhamons().add(dwFolhamon);
					}
				}

				// Embalagens
				if (item.getDwFolhaembs() != null) {
					itemDTO.getFolha().setDwFolhaembs(new HashSet<DwFolhaemb>());
					for (DwFolhaemb emb : item.getDwFolhaembs()) {
						DwFolhaemb embc = emb.clone();
						itemDTO.getFolha().getDwFolhaembs().add(embc);
					}
				}

				itemDTO.setResultadoEvento(0);
				lista.add(itemDTO);

			}
		}

		FolhasDTO dtoRetorno = new FolhasDTO();
		dtoRetorno.setFolhas(lista);
		return dtoRetorno;

	}

	/*
	 * Metodo principal para salvar a folha
	 */
	public FolhaDTO setFolhaSemCadastroEtapaDTO(FolhaDTO itemDTO) {
		FolhaDTO dtoRetorno = new FolhaDTO();
		dtoRetorno.setResultadoEvento(dtoRetorno.getEVENTO_BEM_SUCEDIDO());

		if (itemDTO.getFolha() == null || itemDTO.getFolha().getCdFolha() == null || itemDTO.getFolha().getCdFolha().trim().equals("")) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_CDFOLHA_INVALIDO());
			return dtoRetorno;
		}

		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select t from DwFolha t where t.cdFolha = :cdfolha and t.stAtivo = 1");
		q.defineParametro("cdfolha", itemDTO.getFolha().getCdFolha());

		DwFolha dwfolhaAnterior = (DwFolha) q.uniqueResult();
		DwFolha dwfolhaNovo = itemDTO.getFolha();

		// Limpa os ids dos pojos envolvidos afim de incluir novos registros,
		// deixando os anteriores para o registro antigo
		// limpaAFolhaQueSeraSalva(dwfolhaNovo, itemDTO.getFolha(), itemDTO.getFolhaEtapasDTO());

		// Desativa a dwfolhaAnterior
		if (dwfolhaAnterior != null) {
			if (itemDTO.getFolha().getIdFolha() == null || itemDTO.getFolha().getIdFolha() == 0) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_FOLHA_JA_EXISTE());
				return dtoRetorno;
			} else {
				dwfolhaAnterior.setStAtivo((byte) 0);
			}
		}
		dwfolhaNovo.setIdFolha(null);

		
		this.verificaIntegridadeEInstanciaFKs(dwfolhaNovo, itemDTO, dtoRetorno);
		

		// Salva a configuracao
		//
		if (dtoRetorno.getResultadoEvento() != dtoRetorno.getEVENTO_BEM_SUCEDIDO()) {
			this.getDao().getSession().getTransaction().rollback();
			return dtoRetorno;
		}

		// Talvez aqui tenha que salvar o cadastro de etapa e subetapa antes
		// de salvar a folha

		// Inclui registro novo e desativa antigo
		try {
			prepararFolhaFerramentaParaSalvar(dtoRetorno, dwfolhaNovo);
			if (dtoRetorno.getResultadoEvento() != dtoRetorno.getEVENTO_BEM_SUCEDIDO()) {
				this.getDao().getSession().getTransaction().rollback();
				return dtoRetorno;
			}
			// -----------------FIM SALVAR OS RAPS FILHOS --------------------

			// salvar programa IAC
			prepararFolhaIACParaSalvar(dtoRetorno, dwfolhaNovo);
			if (dtoRetorno.getResultadoEvento() != dtoRetorno.getEVENTO_BEM_SUCEDIDO()) {
				this.getDao().getSession().getTransaction().rollback();
				return dtoRetorno;
			}
			// fim salvar programa IAC

			// Inicio salvando a folha ciclo
			prepararFolhaCICParaSalvar(q, dwfolhaNovo);

			// salvar folha de temperatura
			prepararFolhaVariavelRespostaParaSalvar(dwfolhaNovo);

			/*
			 * Preparar para salvar os tempos de setup
			 */
			prepararFolhaSetupParaSalvar(itemDTO, dwfolhaNovo);
			if (itemDTO.getResultadoEvento() != itemDTO.getEVENTO_BEM_SUCEDIDO()) {
				this.getDao().getSession().getTransaction().rollback();
				return dtoRetorno;
			}

			/*
			 * Prepara para salvar a receita de testes
			 */
			prepararFolhaTesteParaSalvar(itemDTO, dwfolhaNovo);
			if (itemDTO.getResultadoEvento() != itemDTO.getEVENTO_BEM_SUCEDIDO()) {
				this.getDao().getSession().getTransaction().rollback();
				dtoRetorno.setResultadoEvento(itemDTO.getResultadoEvento());
				return dtoRetorno;
			}

			// Prepara folha OPERACAO
			if (itemDTO.getFolha().getDwFolhaoperacoes() != null && itemDTO.getFolha().getDwFolhaoperacoes().isEmpty() == false) {

				for (DwFolhaoperacao foperacao : itemDTO.getFolha().getDwFolhaoperacoes()) {
					foperacao.setDwFolha(dwfolhaNovo);
					foperacao.setIdFolhaoperacao(null);
					foperacao.setIpBalanceamento(null);

					// Salvar Operacao
					DwOperacao dwOperacao = salvarOperacao(foperacao.getDwOperacao());

					foperacao.setDwOperacao(dwOperacao);
				}
			} else {
				dwfolhaNovo.setDwFolhaoperacoes(null);
			}

			this.getDao().inclusaoDescartandoOriginal(dwfolhaAnterior, dwfolhaNovo.getOmUsrByIdUsrrevisao(), dwfolhaNovo);
	
			// Altera o roteiro para utilizar o novo id da folha
			if (dwfolhaAnterior != null) {
				DwRotapassoDAO dwRotapassoDAO = new DwRotapassoDAO(getDaoSession());
				dwRotapassoDAO.alterarDwFolhaTodosPassos(dwfolhaAnterior.getCdFolha(), dwfolhaNovo);
				dwRotapassoDAO.alterarDwFolhaTodasSetupsaindo(dwfolhaAnterior, dwfolhaNovo);
			}

			/*
			 * Alessandre em 25-06-15, Na teoria quando uma folha for alterada NAO deve haver impacto nas ordens de producao que estï¿½o
			 * usando a folha com revisao anterior isso acontece porque o planejamento de producao quando feito foi considerando-se aquela
			 * situaï¿½ï¿½o das folhas de processo. Entretanto, o procedimento de setup quando alterado, ï¿½ bom que seja refletido na folha
			 * da OP, evitando a necessidade de criar uma nova OP. Assim, vou alterar a PPCP para usar a nova versï¿½o da folha, desativando
			 * a ppcp antiga e criando uma nova ppcp, por enquanto fiz a alteracao apenas o idanterior
			 */
			if (dwfolhaAnterior != null && dwfolhaNovo.getDwProcedimento() != null) {
				dwfolhaAnterior.setDwProcedimento(dwfolhaNovo.getDwProcedimento());
				getDao().makePersistent(dwfolhaAnterior);
			}

		} catch (Exception e) {
			e.printStackTrace();
			this.getDao().getSession().getTransaction().rollback();
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
			return dtoRetorno;
		}

		// Ate aqui tudo deve ter sido salvo.

		// Prepara DTO de retorno
		dtoRetorno.setFolha(dwfolhaNovo.clone());

		dtoRetorno.getFolha().setDwFolhasetupsForIdFolhasaindo(null);

		/*
		 * Alessandre: Tirei para o sistema de planejamento, mas futuramente pode ser devolvido Voltei em 02-06-15 para a Fucapi
		 */
		// Prepara o DwFolhamon para o retorno
		if (dwfolhaNovo.getDwFolhamons() != null) {
			dtoRetorno.getFolha().setDwFolhamons(new HashSet<DwFolhamon>());
			for (DwFolhamon itemList : dwfolhaNovo.getDwFolhamons()) {
				DwFolhamon dwFolhamon = (DwFolhamon) itemList.clone();
				dwFolhamon.setDwFolhamoncomps(new HashSet<DwFolhamoncomp>());
				for (DwFolhamoncomp dwFolhamoncomp : itemList.getDwFolhamoncomps()) {
					dwFolhamon.getDwFolhamoncomps().add((DwFolhamoncomp) dwFolhamoncomp.clone());
				}
				dtoRetorno.getFolha().getDwFolhamons().add(dwFolhamon);
			}
		}

		if (dwfolhaNovo.getDwFolhaembs() != null) {
			dtoRetorno.getFolha().setDwFolhaembs(new HashSet<DwFolhaemb>());
			for (DwFolhaemb emb : dwfolhaNovo.getDwFolhaembs()) {
				DwFolhaemb embc = emb.clone();
				dtoRetorno.getFolha().getDwFolhaembs().add(embc);
			}
		}
		// Prepara DwFolhaTeste
		if (dwfolhaNovo.getDwFolhatestes() != null) {
			dtoRetorno.getFolha().setDwFolhatestes(new HashSet<DwFolhateste>());
			for (DwFolhateste itemList : dwfolhaNovo.getDwFolhatestes()) {
				DwFolhateste dwFolhateste = (DwFolhateste) itemList.clone();
				dtoRetorno.getFolha().getDwFolhatestes().add(dwFolhateste);

				List<FolhaEtapaDTO> folhaEtapas = new ArrayList<FolhaEtapaDTO>();
				for (DwTestesub dwTestesub : itemList.getDwTestesubs()) {
					boolean existe = false;
					FolhaEtapaDTO folhaEtapa = new FolhaEtapaDTO();
					for (FolhaEtapaDTO folhaEtapaDTO : folhaEtapas) {
						if (dwTestesub.getDwFtSub().getDwFtEtapa().getIdFtEtapa() == folhaEtapaDTO.getEtapa().getIdFtEtapa()) {
							folhaEtapa = folhaEtapaDTO;
							existe = true;
						}
					}
					if (!existe) {
						folhaEtapa.setEtapa((DwFtEtapa) dwTestesub.getDwFtSub().getDwFtEtapa().clone());
						folhaEtapa.setOrdem(dwTestesub.getOrdemEtapa());
						folhaEtapa.setTestesSub(new ArrayList<DwTestesub>());
						folhaEtapas.add(folhaEtapa);
					}
					DwTestesub testeSub = (DwTestesub) dwTestesub.clone();

					testeSub.setDwTestesubetapas(new HashSet<DwTestesubetapa>());
					if (dwTestesub.getDwTestesubetapas() != null) {
						for (DwTestesubetapa testeSubetapa : dwTestesub.getDwTestesubetapas()) {
							DwTestesubetapa cloneTesteSubetapa = (DwTestesubetapa) testeSubetapa.clone();
							cloneTesteSubetapa.getDwFtSubparam().setDwFtSub((DwFtSub) testeSubetapa.getDwFtSubparam().getDwFtSub().clone());
							testeSub.getDwTestesubetapas().add(cloneTesteSubetapa);
						}
					}
					folhaEtapa.getTestesSub().add(testeSub);
				}
				dtoRetorno.setFolhaEtapasDTO(folhaEtapas);
			}
		}

		// INicializar retorno das operacoes
		if (dwfolhaNovo.getDwFolhaoperacoes() != null) {
			dtoRetorno.getFolha().setDwFolhaoperacoes(new HashSet<DwFolhaoperacao>());
			for (DwFolhaoperacao folhaopera : dwfolhaNovo.getDwFolhaoperacoes()) {
				DwFolhaoperacao folhaoperaClone = folhaopera.clone();
				dtoRetorno.getFolha().getDwFolhaoperacoes().add(folhaoperaClone);
			}
		}

		dtoRetorno.setResultadoEvento(dtoRetorno.getEVENTO_BEM_SUCEDIDO());
		/*
		 * O atributo isFolhaComOpEmMAquina serï¿½ true quando o IHM puder trocar OP e quando a folha estiver em uma OP em maquina
		 */
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		PTRN ptrn = new PTRN(getDao());
		// Obtem lista de pts ativos com OP
		List<OmPt> listapts = ptrn.pesquisarPtStAtivoComOpEmProducaoDaFolha(dtoRetorno.getFolha().getCdFolha());
		for (OmPt omptp : listapts) {
			if (omptp.getOmTppt() != null && omptp.getOmTppt().getIsIhmtrocaop() != null) {
				// O if abaixo nao pode estar junto com o if acima pois se os
				// campos acima forem null entao deve-se testar os campos de
				// omcfg
				if (omptp.getOmTppt().getIsIhmtrocaop() == true)
					dtoRetorno.setFolhaComOpEmMaquina(true);
			} else if (omcfg.getIsIhmtrocaop() != null && omcfg.getIsIhmtrocaop()) {
				dtoRetorno.setFolhaComOpEmMaquina(true);
			}
		}
		return dtoRetorno;
	}

	private DwOperacao salvarOperacao(DwOperacao dwoperacao) {
		OperacaoRN rn = new OperacaoRN(getDao());

		DwOperacaoDTO dto = new DwOperacaoDTO();

		dto.setDwOperacao(dwoperacao);

		dto = rn.salvarDwOperacao(dto);

		return dto.getDwOperacao();
	}

	private void prepararFolhaFerramentaParaSalvar(FolhaDTO dtoRetorno, DwFolha dwfolhaNovo) {
		Set<DwFolharap> listaDwFolhaRaps = null;

		// -----------------INICIO SALVAR OS RAPS FILHOS -----------------
		if ((dwfolhaNovo.getDwFolharaps() != null) && (dwfolhaNovo.getDwFolharaps().size() > 0)) {
			listaDwFolhaRaps = new HashSet<DwFolharap>();

			for (DwFolharap folhaRap : dwfolhaNovo.getDwFolharaps()) {
				DwRap dwRap = null;
				if (folhaRap.getDwRap() != null && folhaRap.getDwRap().getCdRap() != null) {
					dwRap = this.pesquisaDwRap(folhaRap.getDwRap().getCdRap());
				}

				if (dwRap == null) {
					dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DWRAP_DESCONHECIDA());
					return;
				}

				DwFolharap dwFolhaRap = new DwFolharap();
				dwFolhaRap.setDwRap(dwRap);
				dwFolhaRap.setQtUsada(folhaRap.getDwRap().getQtAlocada());
				dwFolhaRap.setSegTempopreparacao(folhaRap.getDwRap().getSegTempoliberacao());

				Set<DwFolharapcom> listaDwFolharapcom = null;
				if ((folhaRap.getDwFolharapcoms() != null) && (folhaRap.getDwFolharapcoms().size() > 0)) {
					listaDwFolharapcom = new HashSet<DwFolharapcom>();

					for (DwFolharapcom folhaRapcom : folhaRap.getDwFolharapcoms()) {
						OmProduto produto = this.pesquisaOmproduto(folhaRapcom.getOmProduto().getCdProduto());

						if (produto == null) {
							dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PRODUTO_DESCONHECIDO());
							return;
						}

						DwFolharapcom dwFolhaRapcom = new DwFolharapcom();
						dwFolhaRapcom.setOmProduto(produto);
						dwFolhaRapcom.setQtAtiva(folhaRapcom.getQtAtiva());
						dwFolhaRapcom.setQtTotal(folhaRapcom.getQtTotal());
						dwFolhaRapcom.setDwFolharap(dwFolhaRap);
						dwFolhaRapcom.setIdredzproduto(folhaRapcom.getIdredzproduto());

						listaDwFolharapcom.add(dwFolhaRapcom);
					}
				}
				dwFolhaRap.setDwFolharapcoms(listaDwFolharapcom);

				dwFolhaRap.setDwFolha(dwfolhaNovo);
				listaDwFolhaRaps.add(dwFolhaRap);
			}
		}

		dwfolhaNovo.setDwFolharaps(listaDwFolhaRaps);
	}

	private void prepararFolhaSetupParaSalvar(FolhaDTO itemDTO, DwFolha dwfolhaNovo) {
		dwfolhaNovo.setDwFolhasetupsForIdFolhasaindo(null);
		Set<DwFolhasetup> listaDwFolhaSetup = null;
		if (itemDTO.getFolha().getDwFolhasetupsForIdFolhaentrando() != null && itemDTO.getFolha().getDwFolhasetupsForIdFolhaentrando().size() > 0) {
			listaDwFolhaSetup = new HashSet<DwFolhasetup>();

			for (DwFolhasetup setup : itemDTO.getFolha().getDwFolhasetupsForIdFolhaentrando()) {

				DwFolha test = null;
				// o if abaixo garante que se a folha saindo for a mesma
				// folha principal. a princial nova sera usada
				if (setup.getDwFolhaByIdFolhasaindo().getCdFolha().equals(dwfolhaNovo.getCdFolha()))
					test = dwfolhaNovo;
				else
					test = this.pesquisaFolhaByCdEStSemRota(setup.getDwFolhaByIdFolhasaindo().getCdFolha());
				// Se nao encontrou a folha ï¿½ pq ela esta desativada
				if (test == null)
					continue;

				DwFolhasetup dwFolhaSetup = new DwFolhasetup();

				dwFolhaSetup.setDwFolhaByIdFolhaentrando(dwfolhaNovo);
				dwFolhaSetup.setDwFolhaByIdFolhasaindo(test);
				dwFolhaSetup.setSegSetup(setup.getSegSetup());

				listaDwFolhaSetup.add(dwFolhaSetup);
			}
		}
		dwfolhaNovo.setDwFolhasetupsForIdFolhaentrando(listaDwFolhaSetup);
	}

	private void prepararFolhaVariavelRespostaParaSalvar(DwFolha dwfolhaNovo) {
		Set<DwFolhamedtemp> listaDwFolhamedtemps = null;
		if (dwfolhaNovo.getDwFolhamedtemps() != null && dwfolhaNovo.getDwFolhamedtemps().size() > 0) {
			listaDwFolhamedtemps = new HashSet<DwFolhamedtemp>(0);
			for (DwFolhamedtemp itemFMT : dwfolhaNovo.getDwFolhamedtemps()) {
				DwFolhamedtemp dwFolhamedtemp = itemFMT.clone();
				Set<DwFolhamedtemhor> listaDwFolhamedtemhors = new HashSet<DwFolhamedtemhor>(0);

				for (DwFolhamedtemhor itemFMTH : itemFMT.getDwFolhamedtemhors()) {
					DwFolhamedtemhor dwFolhamedtemhor = itemFMTH.clone();
					Set<DwFolhamedtemphorcfg> listaDwFolhamedtemphorcfg = new HashSet<DwFolhamedtemphorcfg>(0);

					for (DwFolhamedtemphorcfg itemFMTCfg : itemFMTH.getDwFolhamedtemphorcfgs()) {
						DwFolhamedtemphorcfg dwFolhamedtemphorcfg = itemFMTCfg.clone();
						dwFolhamedtemphorcfg.setDwFolhamedtemhor(dwFolhamedtemhor);
						listaDwFolhamedtemphorcfg.add(dwFolhamedtemphorcfg);
					}

					dwFolhamedtemhor.setDwFolhamedtemp(dwFolhamedtemp);
					dwFolhamedtemhor.setDwFolhamedtemphorcfgs(listaDwFolhamedtemphorcfg);
					listaDwFolhamedtemhors.add(dwFolhamedtemhor);

				}

				dwFolhamedtemp.setDwFolha(dwfolhaNovo);
				dwFolhamedtemp.setDwFolhamedtemhors(listaDwFolhamedtemhors);
				listaDwFolhamedtemps.add(dwFolhamedtemp);
			}
		}
		dwfolhaNovo.setDwFolhamedtemps(listaDwFolhamedtemps);
	}

	private void prepararFolhaCICParaSalvar(MapQuery q, DwFolha dwfolhaNovo) {
		Set<DwFolhacic> listacic = null;
		if (dwfolhaNovo.getDwFolhacics() != null && dwfolhaNovo.getDwFolhacics().size() > 0) {
			listacic = new HashSet<DwFolhacic>(0);
			for (DwFolhacic cic : dwfolhaNovo.getDwFolhacics()) {
				// Confirma PT
				OmPt omptCic = null;
				if (cic.getOmPt() != null) {
					q.novaConsulta();
					q.append("from OmPt ompt where ompt.stAtivo = 1 and ompt.cdPt = :cdpt");
					q.defineParametro("cdpt", cic.getOmPt().getCdPt());
					q.setMaxResults(1);
					omptCic = (OmPt) q.uniqueResult();
				}

				// Confirma GT
				OmGt omgtCic = null;
				if (cic.getOmGt() != null) {
					q.novaConsulta();
					q.append("from OmGt omgt where omgt.stAtivo = 1 and omgt.cdGt = :cdgt");
					q.defineParametro("cdgt", cic.getOmGt().getCdGt());
					q.setMaxResults(1);
					omgtCic = (OmGt) q.uniqueResult();
				}

				// Associa os pesquisados ao pojo
				cic.setOmGt(omgtCic);
				cic.setOmPt(omptCic);
				cic.setDwFolha(dwfolhaNovo);
				cic.setIdFolhacic(null);

				listacic.add(cic);
			}
		}
		dwfolhaNovo.setDwFolhacics(listacic);
	}

	/* Prepara os dados da Receita de Teste para serem salvos no banco */
	private void prepararFolhaTesteParaSalvar(FolhaDTO dtoRetorno, DwFolha dwfolhaNovo) {
		if (dtoRetorno.getFolhaEtapasDTO() != null && dtoRetorno.getFolhaEtapasDTO().isEmpty() == false) {
			ProdutoRN rn = new ProdutoRN(getDao());
			GTRN grn = new GTRN();
			grn.setDao(getDao());
			UsuarioRN urn = new UsuarioRN(getDao());
			
			for (DwFolhateste itemList : dtoRetorno.getFolha().getDwFolhatestes()) {
				itemList.setDwFolha(dwfolhaNovo);
				itemList.setIdFolhateste(0l);
				
				OmProduto omproduto;
				if (itemList.getOmProduto() == null || itemList.getOmProduto().getCdProduto() == null || itemList.getOmProduto().getCdProduto().trim().equals("")) {
					FolhaDTO resultado = new FolhaDTO();
					dtoRetorno.setResultadoEvento(resultado.getERRO_PRODUTO_DESCONHECIDO());
					return;
				}
				try {
					omproduto = rn.getOmProduto(itemList.getOmProduto().getCdProduto());
				} catch (RegistroDesconhecidoException e) {
					omproduto = null;
				}
				itemList.setOmProduto(omproduto);
				OmGt omgt;
				omgt = grn.getOmGtPorIdOuCd(null, itemList.getOmGt().getCdGt());
				itemList.setOmGt(omgt);
				
				
				
				itemList.setDwTestesubs(new HashSet<DwTestesub>());
				if (dtoRetorno.getFolhaEtapasDTO() != null) {
					for (FolhaEtapaDTO folha : dtoRetorno.getFolhaEtapasDTO()) {
						for (DwTestesub testeSub : folha.getTestesSub()) {
							testeSub.setIdTestesub(0l);
							testeSub.setOrdemEtapa(folha.getOrdem());
							testeSub.setDwFolhateste(itemList);
							
							// Inicializa DwFtEtapa
							DwFtEtapa dwftetapa = new DwFtEtapa();
							dwftetapa.setIdFtEtapa(0l);
							dwftetapa.setCdEtapa(folha.getEtapa().getCdEtapa());
							dwftetapa.setDsEtapa(folha.getEtapa().getDsEtapa());
							dwftetapa.setDsMensagemnok(folha.getEtapa().getDsMensagemnok());
							dwftetapa.setDsMensagemok(folha.getEtapa().getDsMensagemok());
							dwftetapa.setDtRevisao(DataHoraRN.getDataHoraAtual());
							dwftetapa.setDtStativo(dwftetapa.getDtRevisao());
							
							OmUsr omusr;
							try {
								omusr = urn.getOmUsr(folha.getEtapa().getOmUsrByIdUsrrevisao().getCdUsr());
							} catch (RegistroDesconhecidoException e) {
								omusr  = null;
							}
							
							dwftetapa.setOmUsrByIdUsrrevisao(omusr);
							dwftetapa.setOmUsrByIdUsrstativo(omusr);
							dwftetapa.setRevisao(1l);
							dwftetapa.setStAtivo((byte) 1);
							
							getDao().makePersistent(dwftetapa);
						
							DwFtSub dwftsub = testeSub.getDwFtSub();
							dwftsub.setIdFtSub(0l);
							dwftsub.setDwFtEtapa(dwftetapa);
							dwftsub.setDwFtSubparams(null);
							
							getDao().makePersistent(dwftsub);
							
							
							testeSub.setDwFtSub(dwftsub);
							
							
							
							for (DwTestesubetapa testeSubetapa : testeSub.getDwTestesubetapas()) {
								testeSubetapa.setIdTestesubetapa(0l);
								testeSubetapa.setDwTestesub(testeSub);
								

								DwFtSubparam subparam = testeSubetapa.getDwFtSubparam();
								subparam.setIdSubparam(0l);
								subparam.setDwFtSub(dwftsub);

								getDao().makePersistent(subparam);
								
							}

							itemList.getDwTestesubs().add(testeSub);
							
						}

					}
				}
			}
		} else {
			dwfolhaNovo.setDwFolhatestes(null);
		}
	}

	private void prepararFolhaIACParaSalvar(FolhaDTO dtoRetorno, DwFolha dwfolhaNovo) {
		Set<DwFolhaiac> listaDwFolhaiacs = null;
		if (dwfolhaNovo.getDwFolhaiacs() != null && dwfolhaNovo.getDwFolhaiacs().size() > 0) {
			listaDwFolhaiacs = new HashSet<DwFolhaiac>();

			for (DwFolhaiac folhaIac : dwfolhaNovo.getDwFolhaiacs()) {
				OmProduto omProduto = null;
				if (folhaIac != null && folhaIac.getOmProduto() != null && folhaIac.getOmProduto().getCdProduto() != null)
					omProduto = this.pesquisaOmproduto(folhaIac.getOmProduto().getCdProduto());

				if (omProduto == null) {
					dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PRODUTO_DESCONHECIDO());
					return;
				}
				/*
				 * Apos constatar a existencia do produto, entao devemos verificar se producao por ciclo foi definida
				 */
				if (folhaIac.getQtAtiva() == null || folhaIac.getQtAtiva().doubleValue() <= 0d) {
					dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PRODUCAO_CICLO_INVALIDA());
					return;
				}
				DwFolhaiac dwFolhaiac = new DwFolhaiac();
				dwFolhaiac.setOmProduto(omProduto);

				OmPrg omPrg = null;

				if (folhaIac.getOmPrg() != null && folhaIac.getOmPrg().getCdPrg().trim().equals("") == false) {
					omPrg = this.pesquisaOmPrg(folhaIac.getOmPrg().getCdPrg());

					if (folhaIac.getOmPrg().getCdPrg() == null || folhaIac.getOmPrg().getCdPrg().equals("") || omPrg == null) {
						dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_OMPRG_DESCONHECIDO());
						return;
					}
					if (folhaIac.getOmPrg().getCdPrg() != null && folhaIac.getOmPrg().getCdPrg().equals("") == false) {
						dwFolhaiac.setOmPrg(omPrg);
					} else {
						dwFolhaiac.setOmPrg(null);
					}
				}
				dwFolhaiac.setQtAtiva(folhaIac.getQtAtiva());
				dwFolhaiac.setQtMpporciclo(folhaIac.getQtMpporciclo());

				if (folhaIac.getOmProdutodois() != null && folhaIac.getOmProdutodois().getCdProduto().equals("") == false) {
					OmProduto omProdutodois = this.pesquisaOmproduto(folhaIac.getOmProdutodois().getCdProduto());

					if (omProdutodois == null) {
						dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PRODUTO_DESCONHECIDO());
						return;
					}
					dwFolhaiac.setOmProdutodois(omProdutodois);
				} else {
					dwFolhaiac.setOmProdutodois(null);
				}
				dwFolhaiac.setDwFolha(dwfolhaNovo);
				listaDwFolhaiacs.add(dwFolhaiac);
			}
		}
		dwfolhaNovo.setDwFolhaiacs(listaDwFolhaiacs);
	}

	private void verificaIntegridadeEInstanciaFKs(DwFolha dwfolhaNovo, FolhaDTO itemDTO, FolhaDTO dtoRetorno) {

		// Avalia se os valores de ciclo sao validos
		if (dwfolhaNovo.getSegCiclotimeout() != null && dwfolhaNovo.getSegCiclotimeout().intValue() > 1000) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_CICLO_INVALIDO());
			return;
		}

		if (dwfolhaNovo.getDwFolhaiacs().isEmpty() == false && dwfolhaNovo.getDwFolharaps().isEmpty() == false) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_OU_RAP_OU_PRODUTOFABRICADO());
			return;
		}
		// Verifica se existe produto na folha
		if (dwfolhaNovo.getDwFolharaps().isEmpty() == false) {
			for (DwFolharap folharap : dwfolhaNovo.getDwFolharaps()) {
				if (folharap.getDwFolharapcoms().isEmpty()) {
					dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_OU_RAP_OU_PRODUTOFABRICADO());
					return;
				}
			}
		}

		ProdutoRN prn = new ProdutoRN(getDao());
		// FOlha de montagem
		if (dwfolhaNovo.getDwFolhamons() != null && dwfolhaNovo.getDwFolhamons().size() > 0) {
			for (DwFolhamon folhamon : dwfolhaNovo.getDwFolhamons()) {
				folhamon.setIdFolhamon(0);
				folhamon.setDwFolha(dwfolhaNovo);
				if ((folhamon.getDwFolhamoncomps() == null) || (folhamon.getDwFolhamoncomps().size() == 0)) {
					dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_RELACAO_PARTES_FALTANDO());
					return;
				}
				// Verifica se o produto existe
				try {
					OmProduto item = prn.getOmProduto(folhamon.getOmProduto().getCdProduto());
					if (item == null) {
						dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PRODUTO_PRINCIPAL_DESCONHECIDO());
						return;
					}
					folhamon.setOmProduto(item);
				} catch (Exception e) {
					dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PRODUTO_PRINCIPAL_DESCONHECIDO());
					return;
				}

				for (DwFolhamoncomp dwFolhamoncomp : folhamon.getDwFolhamoncomps()) {
					dwFolhamoncomp.setIdFolhamoncomp(0);
					dwFolhamoncomp.setDwFolhamon(folhamon);
					// Verifica se o produto existe
					try {
						OmProduto item = prn.getOmProduto(dwFolhamoncomp.getOmProduto().getCdProduto());
						if (item == null) {
							dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PRODUTO_COMPONENTE_DESCONHECIDO());
							return;
						}
						dwFolhamoncomp.setOmProduto(item);
						dwFolhamoncomp.setIdFolhamoncomp(0l);
					} catch (Exception e) {
						dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PRODUTO_COMPONENTE_DESCONHECIDO());
						return;
					}
					// dwFolhamoncomp.setDwFolhamon(folhamon);
				}
			}
		}

		// Folha embalagem
		if (dwfolhaNovo.getDwFolhaembs() != null && dwfolhaNovo.getDwFolhaembs().isEmpty() == false) {
			ConfiguracaoRN crn = new ConfiguracaoRN();
			crn.setDao(getDao());
			for (DwFolhaemb folhaemb : dwfolhaNovo.getDwFolhaembs()) {
				OmProduto omproduto = null;
				try {
					if (folhaemb.getOmProduto().getCdProduto() != null && folhaemb.getOmProduto().getCdProduto().isEmpty() == false)
						omproduto = prn.getOmProduto(folhaemb.getOmProduto().getCdProduto());
				} catch (RegistroDesconhecidoException e) {
					omproduto = null;
				}
				if (omproduto == null) {
					dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_EMBALAGEM_DESCONHECIDA());
					return;
				}

				if (folhaemb.getOmCfgscrpimp() != null && folhaemb.getOmCfgscrpimp().getCdScrp() != null
						&& folhaemb.getOmCfgscrpimp().getCdScrp().equals("") == false) {
					OmCfgscrpimp omcfgscrp = crn.getOmCfgscrpimpByCd(folhaemb.getOmCfgscrpimp().getCdScrp());
					if (omcfgscrp == null && folhaemb.getOmCfgscrpimp().getCdScrp() != null
							&& folhaemb.getOmCfgscrpimp().getCdScrp().equals("") == false) {
						dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_SCRIPT_DESCONHECIDO());
						return;
					}
					folhaemb.setOmCfgscrpimp(omcfgscrp);
				} else
					folhaemb.setOmCfgscrpimp(null);

				folhaemb.setIdFolhaemb(null);
				folhaemb.setDwFolha(dwfolhaNovo);
				folhaemb.setOmProduto(omproduto);
			}
		}

		
		// ------------------------------------------------------------------------------------
		// Ricardo: 06/02/2023 - MEXER REGRA AQUI!
		// ------------------------------------------------------------------------------------
		
		if (itemDTO.getFolha().getOmGt() != null) {

			// Verifica se o gt existe da folha
			try {
				OmGtDAO gtDAO = new OmGtDAO(getDaoSession());

				OmGt item = gtDAO.getOmGtPorCdAtivo(itemDTO.getFolha().getOmGt().getCdGt());
				if (item == null) {
					dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_GT_DESCONHECIDO());
					return;
				}
				dwfolhaNovo.setOmGt(item);
			} catch (Exception e) {
				e.printStackTrace();
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_GT_DESCONHECIDO());
				return;
			}
			
		}
		
		
		// ------------------------------------------------------------------------------------
		

		// Verifica se o usuario da revisao existe
		UsuarioRN uRN = new UsuarioRN(getDao());
		OmUsr omUsrRevisao = null;
		try {
			omUsrRevisao = uRN.getOmUsr(itemDTO.getFolha().getOmUsrByIdUsrrevisao().getCdUsr());
			if (omUsrRevisao == null) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
				return;
			}
			dwfolhaNovo.setOmUsrByIdUsrrevisao(omUsrRevisao);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
			return;
		}

		// Verifica usuario do stAtivo
		OmUsr omUsrStAtivo = null;
		try {
			omUsrStAtivo = uRN.getOmUsr(itemDTO.getFolha().getOmUsrByIdUsrstativo().getCdUsr());
			if (omUsrStAtivo == null) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
				return;
			}

			dwfolhaNovo.setOmUsrByIdUsrstativo(omUsrStAtivo);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
			return;
		}

		/*
		 * Verificar a regra do CB
		 *
		 */
		DiversosRN drn = new DiversosRN();
		drn.setDao(getDao());
		if (itemDTO.getFolha().getOmRegrasNscb() != null) {
			OmRegrasNscb omregra = drn.pesquisarOmRegrasnscb(itemDTO.getFolha().getOmRegrasNscb().getCdRegrasNscb());
			dwfolhaNovo.setOmRegrasNscb(omregra);
		}

		// Verifica se o idtppt existe
		String hql;
		Query q;
		try {
			hql = "from OmTppt t where t.cdTppt = '::cdTppt' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idTppt ";
			hql = hql.replaceAll("::cdTppt", itemDTO.getFolha().getOmTppt()
					.getCdTppt());
			q = this.getDao().getSession().createQuery(hql);
			OmTppt item = (OmTppt) q.list().get(0);
			dwfolhaNovo.setOmTppt(item);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_TIPOPOSTO_DESCONHECIDO());
			return;
		}

		try {
			if (itemDTO.getFolha().getOmPt() != null && itemDTO.getFolha().getOmPt().getCdPt() != null
					&& itemDTO.getFolha().getOmPt().getCdPt().equals("") == false) {
				hql = "from OmPt t where t.cdPt = '::cdPt' ";
				hql += "and t.stAtivo = 1 ";
				hql += "order by t.idPt ";
				hql = hql.replaceAll("::cdPt", itemDTO.getFolha().getOmPt()
						.getCdPt());
				q = this.getDao().getSession().createQuery(hql);
				OmPt item = (OmPt) q.list().get(0);
				dwfolhaNovo.setOmPt(item);
			}
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PT_DESCONHECIDO());
			e.printStackTrace();
			return;
		}

		if (itemDTO.getFolha().getDwProcedimento() != null) {
			DwProcedimentoDAO dao = new DwProcedimentoDAO(getDaoSession());
			try {
				DwProcedimento aux = dao.getDwProcedimentoFromCd(itemDTO.getFolha().getDwProcedimento().getCdProcedimento());
				if (aux == null) {
					dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PROCEDIMENTO_DESCONHECIDO());
					return;
				}
				dwfolhaNovo.setDwProcedimento(aux);
			} catch (Exception e) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PROCEDIMENTO_DESCONHECIDO());
				return;
			}
		}
	}

	public DwRap pesquisaDwRap(String cd) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select dwrap from DwRap dwrap");

		q.appendWhere(MapQuery._NULL, "dwrap.cdRap = :cddwrap",
				((cd != null) && (!cd.isEmpty())));
		q.appendWhere(MapQuery._AND, "dwrap.stAtivo = 1", true);

		q.defineParametro("cddwrap", cd);

		q.setMaxResults(1);

		return (DwRap) q.uniqueResult();
	}

	public OmProduto pesquisaOmproduto(String cd) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select omproduto from OmProduto omproduto");

		q.appendWhere(MapQuery._NULL, "omproduto.cdProduto = :cdproduto",
				((cd != null) && (!cd.isEmpty())));
		q.appendWhere(MapQuery._AND, "omproduto.stAtivo = '1'", true);

		q.defineParametro("cdproduto", cd);

		q.setMaxResults(1);

		return (OmProduto) q.uniqueResult();
	}

	public OmPrg pesquisaOmPrg(String cd) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select omprg from OmPrg omprg");

		q.appendWhere(MapQuery._NULL, "omprg.cdPrg = :cdprg",
				((cd != null) && (!cd.isEmpty())));
		q.appendWhere(MapQuery._AND, "omprg.stAtivo = '1'", true);

		q.defineParametro("cdprg", cd);

		q.setMaxResults(1);

		return (OmPrg) q.uniqueResult();
	}

	public DwFolha pesquisaFolhaByCdEStComRota(String cd) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select dwf from DwFolha dwf");
		q.append("join fetch dwf.dwRotapassos dwrotapasso");
		q.append("join fetch dwrotapasso.dwRota dwrota");

		q.appendWhere(MapQuery._NULL, "dwf.cdFolha = :cdfolha",
				((cd != null) && (!cd.isEmpty())));
		q.appendWhere(MapQuery._AND, "dwf.stAtivo = '1'", true);
		q.appendWhere(MapQuery._AND, "dwrota.stAtivo = '1'", true);

		q.defineParametro("cdfolha", cd);

		q.setMaxResults(1);

		return (DwFolha) q.uniqueResult();
	}

	public DwFolha pesquisaFolhaByCdEStSemRota(String cd) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select dwf from DwFolha dwf");

		q.appendWhere(MapQuery._NULL, "dwf.cdFolha = :cdfolha", ((cd != null) && (!cd.isEmpty())));
		q.appendWhere(MapQuery._AND, "dwf.stAtivo = :stAtivo", true);

		q.defineParametro("cdfolha", cd);
		q.defineParametro("stAtivo", (byte) 1);

		q.setMaxResults(1);

		return (DwFolha) q.uniqueResult();
	}

	public DwFolha pesquisaFolhaByRapEstrutura(String cdRap, String cdEstrutura) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select dwf from DwFolha dwf");
		q.append("join dwf.dwFolharaps dwfolharap");
		q.append("join dwfolharap.dwRap dwrap");

		q.appendWhere(MapQuery._NULL, "dwf.stAtivo = :stAtivo", true);
		q.appendWhere(MapQuery._AND, "upper(dwrap.cdRap) = :cdrap", true);
		q.appendWhere(MapQuery._AND, "dwf.cdFolha like :cdfolha", true);

		q.defineParametro("cdrap", cdRap.toUpperCase());
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("cdfolha", "%-" + cdEstrutura);

		q.setMaxResults(1);

		return (DwFolha) q.uniqueResult();
	}

	/**
	 * Pega a Folha ativa. Primeiro verifica se a folha de PpCp ainda Ã© ativa, se não for, pega a vÃ¡lida
	 *
	 * @param ppCP
	 * @return
	 */
	public DwFolha getDwFolhaAtiva(PpCp ppCp) {
		DwFolha dwFolha = ppCp.getDwFolha();
		if (dwFolha.getStAtivo().equals((byte) 0)) {
			// Pesqusiar qual o novo id da folha
			FolhaRN rn = new FolhaRN(this.getDao());
			DwFolha dwfolhaPesquisada = rn.pesquisaFolhaByCdEStSemRota(dwFolha.getCdFolha());

			if (dwfolhaPesquisada != null) {
				dwFolha = dwfolhaPesquisada;
			}
			dwfolhaPesquisada = null;
			rn = null;
		}

		return dwFolha;

	}

	public DwFolha pesquisaFolhaByOmPrgESt(String cdPrograma) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select dwf from DwFolha dwf");
		q.append("join dwf.dwFolhaiacs dwfolhaiac");
		q.append("join dwfolhaiac.omPrg omprg");

		q.appendWhere(MapQuery._NULL, "omprg.cdPrg = :cdprg",
				((cdPrograma != null) && (!cdPrograma.isEmpty())));
		q.appendWhere(MapQuery._AND, "dwf.stAtivo = '1'", true);

		q.defineParametro("cdprg", cdPrograma);

		q.setMaxResults(1);

		return (DwFolha) q.uniqueResult();
	}

	public DwFolha pesquisaFolhaDeUmProdutoNoGT(Long idproduto, Long idgt) {
		MapQuery q = new MapQuery(getDaoSession());

		q.append("select dwfolha ");
		q.append("from DwFolha dwfolha ");
		q.append("join dwfolha.dwFolhatestes dwfolhateste ");
		q.append("where dwfolha.omGt.idGt = :idgt and ");
		q.append("dwfolhateste.omProduto.idProduto = :idproduto ");

		q.defineParametro("idgt", idgt);
		q.defineParametro("idproduto", idproduto);

		q.setMaxResults(1);

		return (DwFolha) q.uniqueResult();
	}

	public DwFolha pesquisaFolhaPorCp(Long idcp) {

		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select folha");
		q.append("from DwFolha folha");
		q.append("join folha.ppCps pp");
		q.append("where folha.stAtivo = 1");
		q.append("and pp.stAtivo = 1");
		q.append("and pp.idCp =:idCp");

		q.defineParametro("idCp", idcp);
		q.setMaxResults(1);
		DwFolha folha = (DwFolha) q.list().get(0);

		return folha;
	}

	public DwFolha pesquisaFolhaPorCpByNrDoc(String nrdoc) {

		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select folha");
		q.append("from DwFolha folha");
		q.append("join folha.ppCps pp");
		q.append("join pp.ppCpprodutos ppcpproduto");
		q.append("where folha.stAtivo = 1");
		q.append("and pp.stAtivo = 1");
		q.append("and ppcpproduto.nrDoc =:nrdoc");

		q.defineParametro("nrdoc", nrdoc);
		q.setMaxResults(1);
		DwFolha folha = (DwFolha) q.list().get(0);

		return folha;
	}
	
	
	public DwFolha pesquisaProdutoNaFolha(OmProduto omproduto, OmTppt omtppt) {
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select distinct f");
		q.append("from DwFolha f");
		q.append("join fetch f.dwFolhaiacs folhaiacs");
		q.append("join fetch folhaiacs.omProduto p");
		q.append("where p.cdProduto = :cdProduto");
		q.append("and f.omTppt = :omtppt");
		q.append("and f.stAtivo = 1");
		q.append("and p.stAtivo = 1");

		q.defineParametro("cdProduto", omproduto.getCdProduto());
		q.defineParametro("omtppt", omtppt);
		q.setMaxResults(1);
		
		return (DwFolha) q.uniqueResult();
	}

	public DwFolhasDTO pesquisaProdutoNaFolha(String cdProduto, long idpt) {

		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select distinct f");
		q.append("from DwFolha f");
		q.append("join fetch f.dwFolhaiacs folhaiacs");
		q.append("join fetch folhaiacs.omProduto p");
		q.append("where p.cdProduto = :cdProduto");
		if (idpt != -1) {
			q.append("and folhaiacs.omPrg.omPt.idPt = :idPt");
		}
		q.append("and f.stAtivo = 1");

		q.defineParametro("cdProduto", cdProduto);
		if (idpt != -1) {
			q.defineParametro("idPt", idpt);
		}

		List<DwFolha> listafolha = q.list();

		if (listafolha == null) {
			listafolha = new ArrayList<DwFolha>();
		}

		List<DwFolhaDTO> listaDTO = new ArrayList<DwFolhaDTO>();
		for (DwFolha folha : listafolha) {
			DwFolhaDTO dto = new DwFolhaDTO();
			dto.setDwFolha(folha.clone());
			listaDTO.add(dto);
		}
		DwFolhasDTO retorno = new DwFolhasDTO();
		retorno.setListaDwFolhaDTO(listaDTO);
		return retorno;
	}

	public DwFolha pesquisarFolhaPorID(long idFolha) {
		DwFolha retorno = null;

		retorno = this.getDao().findById(DwFolha.class, idFolha, false);

		return retorno;
	}

	public List<ColetaParametroDTO> getDadosMedTempPorIdPt(String cdpt)
			throws RegistroDesconhecidoException {

		MapQuery q = new MapQuery(this.getDao().getSession());
		Calendar dthrAtual = new GregorianCalendar();

		q.append("select distinct temphorcfg");
		q.append("from DwFolhamedtemphorcfg temphorcfg");
		q.append("join fetch temphorcfg.dwFolhamedtemhor temhor");
		q.append("join fetch temhor.dwFolhamedtemp medtemp");
		q.append("join fetch medtemp.dwFolha folha");
		q.append("join fetch folha.omPt ompt");
		q.append("where ompt.cdPt =:cdpt");
		q.append("and folha.stAtivo = 1");
		q.append("and temhor.diasemini <= :diasem");
		q.append("and temhor.diasemfim >= :diasem");
		q.append("and temhor.hrini <= :hora");
		q.append("and temhor.hrfim >= :hora");
		q.append("order by temphorcfg.dwFolhamedtemhor.idFolhamedtemphorario desc");

		q.defineParametro("cdpt", cdpt);
		BigDecimal hora = new BigDecimal(dthrAtual.get(Calendar.HOUR_OF_DAY));
		hora = hora.multiply(new BigDecimal(3600));
		q.defineParametro("hora", hora);
		q.defineParametro("diasem",
				new BigDecimal(dthrAtual.get(Calendar.DAY_OF_WEEK)));
		try {
			/*
			 * Modificado por amaury em 19.11.14 para retornar uma lista de coletaparametroDTOCom isso o coletaParametroDTO poderÃ¡ ter
			 * vÃ¡rios parÃ¢metros de mediçãoo diferentes
			 */

			List<DwFolhamedtemphorcfg> listMedTempHorCfg = q.list();
			List<ColetaParametroDTO> coletaParametroDTO = new ArrayList<ColetaParametroDTO>();
			ColetaParametroDTO colparDTO = new ColetaParametroDTO();
			if (listMedTempHorCfg != null && listMedTempHorCfg.size() > 0) {
				int i = 0;
				int agrupador = 0; /*
									 * agrupa de 5 em 5 e então adiciona na lista
									 */
				for (i = 0; i < listMedTempHorCfg.size(); i++) {

					DwFolhamedtemphorcfg medtemphorcfg;
					medtemphorcfg = listMedTempHorCfg.get(i);
					colparDTO.setLimites(medtemphorcfg);
					colparDTO.setDadosDeControle(medtemphorcfg
							.getDwFolhamedtemhor().getDwFolhamedtemp());
					colparDTO.setCdFolha(medtemphorcfg.getDwFolhamedtemhor()
							.getDwFolhamedtemp().getDwFolha().getCdFolha());
					colparDTO.setDwFolhamedtemphorcfg(medtemphorcfg);
					colparDTO.setSegIntervaloLeitura(medtemphorcfg
							.getDwFolhamedtemhor().getSegIntervaloLeitura());
					agrupador++;
					/*
					 * O retorno da query Ã© de 5 de elementos para uma variÃ¡vel de mediçãoo. ApÃ³s percorre os 5 elementos ele adiciona na
					 * lista
					 */
					if (agrupador != 0 && agrupador % 5 == 0) {
						colparDTO.setTpparametro(DwFtParamTemplate.Type
								.getType(medtemphorcfg.getDwFolhamedtemhor()
										.getDwFtParam().getIdFtParam()));
						coletaParametroDTO.add(colparDTO);
						colparDTO = new ColetaParametroDTO();
						agrupador = 0;
					}
				}
			}
			return coletaParametroDTO;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RegistroDesconhecidoException();
		}
	}

	public DwFolha getDwFolhaByOmPt(OmPt ompt, Byte tpFolha) {

		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select a");
		q.append("from DwFolha a");
		q.append("where a.omPt = :ompt");
		q.append("and a.tpFolha = :tpfolha");
		q.append("and a.stAtivo = 1");

		q.defineParametro("ompt", ompt);
		q.defineParametro("tpfolha", tpFolha);
		q.setMaxResults(1);
		return (DwFolha) q.uniqueResult();
	}

	public void salvarFolhaAPartirDoPrograma(ProgramaInsersoraDTO programa, boolean isForcarImportacao) {
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		String cdFolha = "";
		try {
			cdFolha = programa.getOmprg().getCdPrg().substring(0, omcfg.getMascarafolha().length()) + "-"
					+ programa.getOmpt().getOmTppt().getCdTppt();
		} catch (Exception e) {
			cdFolha = programa.getOmprg().getCdPrg() + "-" + programa.getOmpt().getOmTppt().getCdTppt();
		}
		// Verifica se a folha existe
		DwFolha dwfolha = pesquisaFolhaByCdEStSemRota(cdFolha);
		if (dwfolha == null) {
			OmGt omgt = omcfg.getOmGtimpcic();
			if (omgt == null) {
				OmGtDAO gtDAO = new OmGtDAO(getDaoSession());
				omgt = gtDAO.getPrimeiroGtAtivo();
			}
			dwfolha = new DwFolha();
			dwfolha.setIdFolha(null);
			dwfolha.setCdFolha(cdFolha);
			dwfolha.setDsFolha(programa.getOmprg().getDsPrg());
			dwfolha.setDtRevisao(DataHoraRN.getDataHoraAtual());
			dwfolha.setDtStativo(DataHoraRN.getDataHoraAtual());
			dwfolha.setOmTppt(programa.getOmpt().getOmTppt());
			dwfolha.setRevisao(1l);
			dwfolha.setTpFolha((byte) 6); // programa iac
			dwfolha.setStAtivo((byte) 1);
			dwfolha.setSegSetup(3600);
			dwfolha.setOmGt(omgt);
			dwfolha.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
			dwfolha.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());

			// pesquisa produto
			/*
			 * ProdutoRN rnP = new ProdutoRN(); rnP.setDaoSession(getDaoSession()); OmProduto omproduto =
			 * rnP.getProdutoByCdEStAtivo(programa.getOmprg().getCdPrg());
			 *
			 * // Incluir dwfolhaiac DwFolhaiac iac = new DwFolhaiac(); iac.setDwFolha(dwfolha); iac.setIdFolhaiac(null);
			 * iac.setQtAtiva(BigDecimal.ONE); iac.setOmProduto(omproduto);
			 *
			 * dwfolha.getDwFolhaiacs().add(iac);
			 */
			dwfolha.setSegCiclopadrao((new BigDecimal(programa.getCicloPadrao())).setScale(2, RoundingMode.HALF_UP));
			dwfolha.setSegCiclominimo(BigDecimal.ZERO);
			dwfolha.setSegCiclotimeout(new BigDecimal(200));
			getDaoSession().saveOrUpdate(dwfolha);
		}
	}

	public DwFolhasDTO getDwFolhasPorCod(FolhaDTO filtro) {
		if (filtro != null || (filtro != null && filtro.getFolha() != null)) {
			String cdFolha = filtro.getFolha().getCdFolha();
			String cdPt = filtro.getFolha().getOmPt().getCdPt();

			return this.getDwFolhasPorCod(cdFolha, cdPt);
		}
		return null;
	}

	public DwFolhasDTO getDwFolhasPorCod(String cdFolha, String cdPt) {

		DwFolhasDTO retorno = null;

		MapQuery q = new MapQuery(this.getDao().getSession());

		/*
		 * Alessandre em 15-05-17 modifiquei o hql abaixo desmembrando em 2, pois pode acontecer de nao ter especializacao de ciclo para o
		 * posto solicitado, mesmo assim, o mesmo deve ser retornado
		 */
		q.append("select f ");
		q.append("from DwFolha f ");
		q.append("join fetch f.dwFolhacics c ");
		q.append("join fetch c.omPt d ");
		q.append("where f.cdFolha = :cdfolha ");
		q.append("and d.cdPt = :pt) ");

		q.defineParametro("cdfolha", cdFolha);
		q.defineParametro("pt", cdPt);

		List<DwFolha> listaFolhas = q.list();

		/*
		 * Alessandre em 15-05-17 se nao tiver encontrado nada, entao pesquisar as folhas pelo codigo e o tipo pt
		 *
		 */
		if (listaFolhas.isEmpty()) {
			PTRN prn = new PTRN(getDao());
			OmPt ompt;
			try {
				ompt = prn.getOmPt(cdPt);
				q.novaConsulta();
				q.append("select f ");
				q.append("from DwFolha f ");
				q.append("where f.cdFolha = :cdfolha ");
				q.append("and f.omTppt = :omtppt ");

				q.defineParametro("cdfolha", cdFolha);
				q.defineParametro("omtppt", ompt.getOmTppt());

				listaFolhas = q.list();
			} catch (RegistroDesconhecidoException e) {
			}
		}

		List<DwFolhaDTO> listaFolhaDTO = new ArrayList<DwFolhaDTO>();

		for (DwFolha f : listaFolhas) {
			DwFolha folha = f.clone();
			DwFolhaDTO folhaDTO = new DwFolhaDTO();
			folhaDTO.setDwFolha(folha);
			listaFolhaDTO.add(folhaDTO);
		}

		Collections.sort(listaFolhaDTO, new Comparator<DwFolhaDTO>() {
			@Override
			public int compare(final DwFolhaDTO o1, final DwFolhaDTO o2) {
				return Long.valueOf(o1.getDwFolha().getRevisao())
						.compareTo(
								Long.valueOf(o2.getDwFolha().getRevisao()));
			}
		});

		retorno = new DwFolhasDTO();
		retorno.setListaDwFolhaDTO(listaFolhaDTO);

		return retorno;
	}

	public DwFolhaDTO getDwFolhaAtivaByCd(FolhaDTO filtro)
			throws RegistroDesconhecidoException {

		DwFolhaDTO retorno = null;

		if (filtro.getFolha() != null) {
			MapQuery q = new MapQuery(this.getDao().getSession());
			q.append("select f ");
			q.append("from DwFolha f ");
			q.append("left join fetch f.dwFolhacics c ");
			q.append("where f.cdFolha = :cdfolha ");
			q.append("and (c is null OR c.omPt = :pt OR f.omTppt = :omtppt) ");
			q.append("and f.stAtivo = 1 ");

			q.defineParametro("cdfolha", filtro.getFolha().getCdFolha());
			q.defineParametro("pt", filtro.getFolha().getOmPt());
			q.defineParametro("omtppt", filtro.getFolha().getOmPt().getOmTppt());

			DwFolha dwfolha = (DwFolha) q.uniqueResult();

			if (dwfolha == null)
				throw new RegistroDesconhecidoException();

			DwFolhaDTO folhaDTO = new DwFolhaDTO();

			DwFolha folha = dwfolha.clone();
			folhaDTO.setDwFolha(folha);

			retorno = folhaDTO;
		}

		return retorno;
	}

	public DwFolhasDTO getTodasDwFolhasAtivas() {
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("select dwfolha");
		q.append("from DwFolha dwfolha");
		q.append("where dwfolha.stAtivo = 1");
		q.append("order by dwfolha.cdFolha");
		List<DwFolha> listaPesquisa = null;
		try {
			listaPesquisa = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<DwFolhaDTO> lista = new ArrayList<DwFolhaDTO>();

		if (listaPesquisa != null) {
			for (DwFolha item : listaPesquisa) {
				DwFolhaDTO dwFolhaDTO = new DwFolhaDTO();
				dwFolhaDTO.setDwFolha(item.clone());
				lista.add(dwFolhaDTO);
			}
		}

		DwFolhasDTO listaRetorno = new DwFolhasDTO();
		listaRetorno.setListaDwFolhaDTO(lista);

		return listaRetorno;
	}

	public DwFolhasDTO getDwFolhaDoProcedimento(DwProcedimento dwProcedimento) {
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("select dwfolha");
		q.append("from DwFolha dwfolha");
		q.append("where dwfolha.stAtivo = 1");
		q.append("and dwfolha.dwProcedimento.idProcedimento = "
				+ dwProcedimento.getIdProcedimento());
		q.append("order by dwfolha.idFolha");
		List<DwFolha> listaPesquisa = null;
		try {
			listaPesquisa = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<DwFolhaDTO> lista = new ArrayList<DwFolhaDTO>();

		if (listaPesquisa != null) {
			for (DwFolha item : listaPesquisa) {
				DwFolhaDTO dwFolhaDTO = new DwFolhaDTO();
				dwFolhaDTO.setDwFolha(item.clone());
				lista.add(dwFolhaDTO);
			}
		}

		DwFolhasDTO listaRetorno = new DwFolhasDTO();
		listaRetorno.setListaDwFolhaDTO(lista);

		return listaRetorno;
	}

	public void updateFolhaDTO(FolhaDTO itemDTO) {
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("update DwFolha dwFolha");
		q.append(" set dwFolha.dwProcedimento.idProcedimento = :idDwProcedimento");
		q.append(" where dwFolha.idFolha = :idFolha");
		q.append(" and dwFolha.stAtivo = 1");
		q.defineParametro("idDwProcedimento", itemDTO.getFolha()
				.getDwProcedimento().getIdProcedimento());
		q.defineParametro("idFolha", itemDTO.getFolha().getIdFolha());
		q.query().executeUpdate();
	}

	/**
	 * Retorna as cavidades ativas (pcs por ciclo) do primeiro DwConsolid da lista
	 *
	 * @param listadwconsol
	 * @return
	 */
	public Double getPcsPorCicloAtivas(List<DwConsolid> listaDwconsolid) {
		BigDecimal cavativas = BigDecimal.ZERO;
		FolhaRN folhaRN = new FolhaRN(getDao());

		for (DwConsolid dwci : listaDwconsolid) {
			// cavidades ativas
			try {
				cavativas = folhaRN.getPcsPorCicloAtivas(dwci.getDwFolha());
			} catch (SemPcsPorCicloAtivasException e) {
				// TODO Auto-generated catch block
				cavativas = BigDecimal.ONE;
			}
		}
		return cavativas.doubleValue();
	}

	public static void main(String[] args) {
		FolhaRN rn = new FolhaRN();
		rn.iniciaConexaoBanco();
		CicloDTO dto = rn.getCicloTimeoutEPadrao("", "NXTL12");
		System.out.println("ciclo=" + dto.getCicloPadrao());
		rn.finalizaConexaoBanco();
	}
	
	
	/*
	 * Metodo responsavel em obter o ciclo padrao para a coleta fuji abrir ou nao a parada automatica
	 *
	 */
	public idw.webservices.dto.CicloDTO getCicloTimeoutEPadrao(String cdProduto, String maquina) {
		DwFolha dwfolha = new DwFolha();
		DwFolhacic dwfolhacic = new DwFolhacic();
		PTRN prn = new PTRN(getDao());

		OmCfg omcfg = Util.getConfigGeral(getDaoSession());

		idw.webservices.dto.CicloDTO cicloDTO = new idw.webservices.dto.CicloDTO();

		if (omcfg == null) {
			cicloDTO = new idw.webservices.dto.CicloDTO();
			return cicloDTO;
		}
		OmPt ompt;
		try {
			ompt = prn.getOmPt(maquina);
		} catch (RegistroDesconhecidoException e1) {
			cicloDTO = new idw.webservices.dto.CicloDTO();
			return cicloDTO;
		}

		/*
		String cdProdutoTratado;

		try {
			cdProdutoTratado = Util.extraiPorMascara(cdProduto, omcfg.getMascarafolha());
		} catch (Exception e) {
			cdProdutoTratado = cdProduto;
		}

		cdProdutoTratado += "-" + ompt.getOmTppt().getCdTppt();*/

		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("select dwfolha from DwFolha dwfolha");
		q.append("where dwfolha.cdFolha = :cdfolha");
		q.append("and dwfolha.stAtivo = 1");
		q.append("order by dwfolha.idFolha desc");
		q.defineParametro("cdfolha", ompt.getPpCp().getDwFolha().getCdFolha());

		q.setMaxResults(1);

		try {
			dwfolha = (DwFolha) q.uniqueResult();

			cicloDTO.setEficienciaCiclo(dwfolha.getSegCiclotimeout());
		} catch (Exception e) {
			cicloDTO = new idw.webservices.dto.CicloDTO();
			return cicloDTO;
		}

		MapQuery r = new MapQuery(this.getDaoSession());
		r.append("select dwfolhacic from DwFolhacic dwfolhacic");
		r.append("join dwfolhacic.omPt ompt");
		r.append("where dwfolhacic.dwFolha.idFolha = :idFolha");
		r.append("and ompt.cdPt = :cdPt");
		r.append("order by dwfolhacic.idFolhacic desc");
		r.defineParametro("idFolha", dwfolha.getIdFolha());
		r.defineParametro("cdPt", maquina);

		r.setMaxResults(1);

		try {
			dwfolhacic = (DwFolhacic) r.uniqueResult();

			cicloDTO.setCicloPadrao(dwfolhacic.getSegCiclopadrao());
		} catch (Exception e) {
			cicloDTO.setCicloPadrao(dwfolha.getSegCiclopadrao());
		}

		return cicloDTO;
	}

	public DwFolhaDTO getDwFolhaByCdFolhaEOmPt(String cdFolha, OmPt ompt) {
		DwFolha dwFolha = new DwFolha();
		dwFolha.setCdFolha(cdFolha);
		dwFolha.setOmPt(ompt);

		FolhaDTO filtro = new FolhaDTO();
		filtro.setFolha(dwFolha);

		DwFolhaDTO folha = null;
		try {
			folha = this.getDwFolhaAtivaByCd(filtro);
		} catch (Exception e) {
			folha = null;
		}
		return folha;
	}

	public List<DwFolhamoncomp> getListaDwFolhamoncompOPAtual(String cdPt) {
		List<DwFolhamoncomp> res = null;

		try {
			MapQuery q = new MapQuery(this.getDaoSession());

			q.append("select distinct dwfolha");

			q.append("from OmPt ompt");
			q.append("join ompt.ppCp ppcp");
			q.append("join ppcp.dwFolha dwfolha");

			q.append("where ompt.cdPt = :cdPt");
			q.append("and ompt.stAtivo = 1");

			q.defineParametro("cdPt", cdPt);
			q.setMaxResults(1);

			DwFolha dwfolha = (DwFolha) q.uniqueResult();

			/* Pegar a ultima revisao da folha */
			q.novaConsulta();
			q.append("select distinct dwfolhamoncomps");
			q.append("from DwFolha dwfolha");
			q.append("join dwfolha.dwFolhamons dwfolhamons");
			q.append("join dwfolhamons.dwFolhamoncomps dwfolhamoncomps");
			q.append("where dwfolha.cdFolha = :cdfolha");
			q.append("and dwfolha.stAtivo = 1");
			q.append("order by dwfolhamoncomps.ordem asc");

			q.defineParametro("cdfolha", dwfolha.getCdFolha());

			res = q.list();

		} catch (Exception e) {
			res = null;
		}

		return res;
	}

	public List<StatusProdutoSADTO> getStatusDeProdutoDaOPStandAlone(long idPt,
			long idCp, long idTurno, Date dthrIhora) {
		IdwLogger log = new IdwLogger("QueriesStandAlone");

		List<StatusProdutoSADTO> retorno = new ArrayList<StatusProdutoSADTO>();

		log.iniciaAvaliacao("Query getStatusDeProdutoDaOPStandAlone");

		MapQuery q = new MapQuery(this.getDaoSession());

		q.append("select distinct omprod.idProduto as idProduto,");
		q.append("omprod.cdProduto as cdProduto,");
		q.append("dwconsolpr.pcsAutoProducaobruta as pcsProducaobruta,");
		q.append("dwconsolpr.pcsAutoProducaorefugada as pcsProducaorefugada");

		q.append("from DwConsolid dwconsolid");
		q.append("join dwconsolid.dwConsols dwconsol");
		q.append("join dwconsol.dwConsolprs dwconsolpr");
		q.append("join dwconsolpr.omProduto omprod");
		q.append("join dwconsolid.ppCp ppcp");

		q.append("where dwconsolid.dthrIhora = :dthrihora");
		q.append("and dwconsolid.omPt.idPt = :idPt");
		q.append("and dwconsolid.dwTurno.idTurno = :idturno");
		q.append("and ppcp.idCp = :idCp");

		q.append("order by omprod.cdProduto");

		q.defineParametroTimestamp("dthrihora", dthrIhora);
		q.defineParametro("idturno", idTurno);
		q.defineParametro("idCp", idCp);
		q.defineParametro("idPt", idPt);

		q.query().setResultTransformer(
				Transformers.aliasToBean(StatusProdutoSADTO.class));

		retorno = q.list();

		log.mostrarAvaliacaoCompleta();

		return retorno;
	}

	public List<DadosProdutoSADTO> getDadosDeProdutoDaOPStandAlone(Long idCp,
			Long idPt) {

		IdwLogger log = new IdwLogger("QueriesStandAlone");

		List<DadosProdutoSADTO> retorno = new ArrayList<DadosProdutoSADTO>();

		log.iniciaAvaliacao("Query1");

		MapQuery q = new MapQuery(this.getDaoSession());

		q.append("select distinct omprod.idProduto as idProduto,");
		q.append("omprod.cdProduto as cdProduto,");
		q.append("folharapcom.idredzproduto as idredzproduto,");
		q.append("folharapcom.qtTotal as qtTotal,");
		q.append("folharapcom.qtAtiva as qtAtiva,");
		q.append("ppcpprods.pcsProducaobruta as pcsProducaobruta,");
		q.append("ppcpprods.pcsProducaorefugada as pcsProducaorefugada,");
		q.append("ppcpprods.pcsProducaoplanejada as pcsProducaoplanejada");

		q.append("from OmProduto omprod");
		q.append("join omprod.ppCpprodutos ppcpprods");
		q.append("join ppcpprods.ppCp ppcp");
		q.append("join ppcp.dwFolha folha");
		q.append("join folha.dwFolharaps folharap");
		q.append("join folharap.dwFolharapcoms folharapcom");

		q.append("where ppcp.idCp=:idcp");
		q.append("and ppcp.stAtivo=1");
		q.append("and ppcp.omPt.stAtivo=1");
		q.append("and (folharapcom.omProduto.idProduto = omprod.idProduto)");
		q.append("and ppcp.omPt.idPt=:idpt");

		q.append("order by omprod.cdProduto");

		q.defineParametro("idcp", idCp);
		q.defineParametro("idpt", idPt);

		q.query().setResultTransformer(
				Transformers.aliasToBean(DadosProdutoSADTO.class));

		retorno = q.list();

		log.mostrarAvaliacaoCompleta();
		log.iniciaAvaliacao("Query2");

		q = new MapQuery(this.getDaoSession());

		q.append("select distinct omprod.idProduto as idProduto,");
		q.append("omprod.cdProduto as cdProduto,");
		q.append("folhaiac.qtAtiva as qtAtiva,");
		q.append("ppcpprods.pcsProducaobruta as pcsProducaobruta,");
		q.append("ppcpprods.pcsProducaorefugada as pcsProducaorefugada,");
		q.append("ppcpprods.pcsProducaoplanejada as pcsProducaoplanejada");

		q.append("from OmProduto omprod");
		q.append("join omprod.ppCpprodutos ppcpprods");
		q.append("join ppcpprods.ppCp ppcp");
		q.append("join ppcp.dwFolha folha");
		q.append("join folha.dwFolhaiacs folhaiac");

		q.append("where ppcp.idCp=:idcp");
		q.append("and ppcp.stAtivo=1");
		q.append("and ppcp.omPt.stAtivo=1");
		q.append("and (folhaiac.omProduto.idProduto = omprod.idProduto)");
		q.append("and ppcp.omPt.idPt=:idpt");

		q.append("order by omprod.cdProduto");

		q.defineParametro("idcp", idCp);
		q.defineParametro("idpt", idPt);

		q.query().setResultTransformer(
				Transformers.aliasToBean(DadosProdutoSADTO.class));

		List<DadosProdutoSADTO> lista = q.list();
		retorno.addAll(lista);

		log.mostrarAvaliacaoCompleta();
		log.iniciaAvaliacao("Query3");

		q = new MapQuery(this.getDaoSession());

		q.append("select distinct omprod.idProduto as idProduto,");
		q.append("omprod.cdProduto as cdProduto,");
		q.append("ppcpprod.pcsProducaobruta as pcsProducaobruta,");
		q.append("ppcpprod.pcsProducaorefugada as pcsProducaorefugada,");
		q.append("ppcpprod.pcsProducaoplanejada as pcsProducaoplanejada");

		q.append("from PpCpproduto ppcpprod");
		q.append("join ppcpprod.ppCp ppcp");
		q.append("join ppcpprod.omProduto omprod");

		q.append("where ppcp.idCp=:idcp");
		q.append("and ppcp.omPt.stAtivo=1");
		q.append("and ppcp.omPt.idPt=:idpt");

		q.append("order by omprod.cdProduto");

		q.defineParametro("idcp", idCp);
		q.defineParametro("idpt", idPt);

		q.query().setResultTransformer(
				Transformers.aliasToBean(DadosProdutoSADTO.class));

		lista = q.list();

		log.mostrarAvaliacaoCompleta();

		for (DadosProdutoSADTO dto : lista) {
			boolean pertence = false;
			for (DadosProdutoSADTO reDTO : retorno) {
				if (reDTO.getCdProduto().equals(dto.getCdProduto())) {
					pertence = true;
					break;
				}
			}
			if (pertence == false) {
				if (dto.getPcsProducaobruta() == null)
					dto.setPcsProducaobruta(BigDecimal.ZERO);
				if (dto.getPcsProducaoplanejada() == null)
					dto.setPcsProducaoplanejada(BigDecimal.ZERO);
				if (dto.getPcsProducaorefugada() == null)
					dto.setPcsProducaorefugada(BigDecimal.ZERO);
				retorno.add(dto);
			}
		}

		return retorno;
	}

	/*
	 * Esse metodo tem por objetivo pesquisar a folha a partir do codigo de barras lido nos postos de verificacao
	 */
	public DwFolha getDwFolhaPassagem(String cdPt, String nrop, String cb) {
		DwFolha retorno;
		PpCp ppcp = null;
		CpRN cprn = new CpRN(getDao());

		if (nrop != null && nrop.equals("") == false)
			ppcp = cprn.pesquisarPpCpByNrDocCdPt(nrop, cdPt);

		if (ppcp == null && cb != null && cb.equals("") == false) {
			// Aqui devera ter uma consulta para encontrar a ppcp a partir do PT
			// e do codigo de barras lido
			ppcp = null;
		}

		DwFolha folhaP = getDwFolhaAtiva(ppcp); //aqui ppcp null

		retorno = folhaP.clone();

		return retorno;
	}

	public DwFolha pesquisarDwFolhaByCdProduto(String cdproduto, String cdPt) {
		MapQuery q = null;
		if (getDaoSession() != null)
			q = new MapQuery(getDaoSession());
		else {
			try {
				q = new MapQuery(getDaoSessionStatless());
			} catch (SemSessaoHibernateException e) {
			}
		}
		PTRN rn = new PTRN(getDao());

		OmPt ompt;
		try {
			ompt = rn.getOmPt(cdPt);
		} catch (RegistroDesconhecidoException e) {
			return null;
		}

		q.append("select a");
		q.append("from DwFolha a");
		q.append("join fetch a.dwFolharaps b");
		q.append("join fetch b.dwFolharapcoms c");
		q.append("join fetch c.omProduto d");
		q.append("where a.stAtivo = 1");
		q.append("and upper(d.cdProduto) = :cd");
		q.append("and a.omTppt = :omtppt");
		q.append("and (select count(*) from DwFolharapcom c1 where c1.dwFolharap = b) = 1)");
		q.defineParametro("cd", cdproduto.toUpperCase());
		q.defineParametro("omtppt", ompt.getOmTppt());

		List<DwFolha> lista = q.list();

		DwFolha dwfolha = null;

		// O loop abaixo garante pegar a folha que tenha somente o produto solicitado. Se existir uma outra folha com o produto
		// solicitado mas tenha outro produto tb, deve ser desconsiderado
		for (DwFolha dwfolhaaux : lista) {
			for (DwFolharap rap : dwfolhaaux.getDwFolharaps()) {
				if (rap.getDwFolharapcoms().size() == 1) {
					dwfolha = dwfolhaaux;
				}
			}
		}

		if (dwfolha == null) {
			q.novaConsulta();
			q.append("select a");
			q.append("from DwFolha a");
			q.append("join fetch a.dwFolhaiacs b");
			q.append("join fetch b.omProduto c");
			q.append("where a.stAtivo = 1");
			q.append("and c.cdProduto = :cd");
			q.append("and a.omTppt = :omtppt");
			q.defineParametro("cd", cdproduto);
			q.defineParametro("omtppt", ompt.getOmTppt());
			q.setMaxResults(1);
			dwfolha = (DwFolha) q.uniqueResult();
		}

		return dwfolha;
	}

	public DwFolha pesquisarDwFolhaByCdProdutoEEstrutura(String cdproduto, String cdPt, String cdEstrutura) {
		MapQuery q = new MapQuery(getDaoSession());
		PTRN rn = new PTRN(getDao());

		OmPt ompt;
		try {
			ompt = rn.getOmPt(cdPt);
		} catch (RegistroDesconhecidoException e) {
			return null;
		}

		q.append("select a");
		q.append("from DwFolha a");
		q.append("join a.dwFolharaps b");
		q.append("join b.dwFolharapcoms c");
		q.append("join c.omProduto d");
		q.append("where a.stAtivo = 1");
		q.append("and upper(d.cdProduto) = :cd");
		q.append("and a.omTppt = :omtppt");
		q.append("and a.cdFolha like :cdFolha");
		// Escolher a folha que tenha somente o produto desejado
		q.append("and (select count(*) from DwFolharapcom c1 where c1.dwFolharap = b) = 1");

		q.defineParametro("cd", cdproduto.toUpperCase());
		q.defineParametro("omtppt", ompt.getOmTppt());
		q.defineParametro("cdFolha", "%-" + cdEstrutura);
		q.setMaxResults(1);

		DwFolha dwfolha = (DwFolha) q.uniqueResult();

		if (dwfolha == null) {
			q.novaConsulta();
			q.append("select a");
			q.append("from DwFolha a");
			q.append("join a.dwFolhaiacs b");
			q.append("join b.omProduto c");
			q.append("where a.stAtivo = 1");
			q.append("and c.cdProduto = :cd");
			q.append("and a.omTppt = :omtppt");
			q.append("and a.cdFolha like :cdFolha");
			q.defineParametro("cd", cdproduto);
			q.defineParametro("omtppt", ompt.getOmTppt());
			q.defineParametro("cdFolha", "%-" + cdEstrutura);
			q.setMaxResults(1);
			dwfolha = (DwFolha) q.uniqueResult();
		}

		return dwfolha;
	}

	public DwFolha pesquisarDwFolhaByCdFerramenta(String cdFerramenta, String cdPt) {
		MapQuery q = new MapQuery(getDaoSession());
		PTRN rn = new PTRN(getDao());

		OmPt ompt;
		try {
			ompt = rn.getOmPt(cdPt);
		} catch (RegistroDesconhecidoException e) {
			return null;
		}

		q.append("select a");
		q.append("from DwFolha a");
		q.append("join a.dwFolharaps b");
		q.append("join b.dwRap c");
		q.append("where a.stAtivo = 1");
		q.append("and c.cdRap = :cd");
		q.append("and a.omTppt = :omtppt");
		q.defineParametro("cd", cdFerramenta);
		q.defineParametro("omtppt", ompt.getOmTppt());
		q.setMaxResults(1);

		DwFolha dwfolha = (DwFolha) q.uniqueResult();

		return dwfolha;
	}

	public DwFolha pesquisarDwFolhaByCdFerramentaProduto(String cdFerramenta, String cdproduto, String cdPt) {
		MapQuery q = new MapQuery(getDaoSession());
		PTRN rn = new PTRN(getDao());

		OmPt ompt;
		try {
			ompt = rn.getOmPt(cdPt);
		} catch (RegistroDesconhecidoException e) {
			return null;
		}

		q.append("select a");
		q.append("from DwFolha a");
		q.append("join a.dwFolharaps b");
		q.append("join b.dwRap c");
		q.append("join b.dwFolharapcoms d");
		q.append("join d.omProduto e");

		q.append("where a.stAtivo = 1");
		q.append("and upper(c.cdRap) = :cd");
		q.append("and a.omTppt = :omtppt");
		q.append("and upper(e.cdProduto) = :cdproduto");

		// E a folha escolhida soh pode ter o produto passado. Se tiver mais de um produto nao eh a folha desejada
		q.append("and (select count(*) from DwFolharapcom d1 where d1.dwFolharap = b) = 1");

		q.defineParametro("cd", cdFerramenta.toUpperCase());
		q.defineParametro("omtppt", ompt.getOmTppt());
		q.defineParametro("cdproduto", cdproduto.toUpperCase());
		q.setMaxResults(1);

		DwFolha dwfolha = (DwFolha) q.uniqueResult();

		return dwfolha;
	}

	/*
	 * Esse metodo sera usado pela integracao para obter a folha para op e caso nao exista folha para o posto avaliar e produto sera usado
	 * um semiacabado de acordo com a esturtura do produto
	 */
	public ProdutosDTO pesquisarFolhaComOsProdutosConsiderandoEstrutura(ProdutosDTO produtos, OmPt ompt) {
		ProdutosDTO retorno = produtos;
		for (ProdutoDTO dto : produtos.getProdutos()) {
			DwFolha dwfolha = pesquisarDwFolhaByCdProduto(dto.getProduto().getCdProduto(), ompt.getCdPt());
			if (dwfolha == null) {
				// Se nao existir a folha avaliar para algum semiacabado do produto final
				retorno.setResultado(new ResultadoDTO());
				retorno.getResultado().setIdmensagem(retorno.getResultado().FOLHA_DESCONHECIDA);
				return retorno;
			}
			retorno.setDwfolha(dwfolha.clone(false));
		}
		return retorno;
	}
	
	
	/* Retorna a producao por ciclo de dwfolhaiac para a folha carregada no PT
	 * 
	 */
	public Integer getProducaoPorCiclo(String cdpt) {
		Integer retorno = 0;
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from OmPt a");
		q.append("join fetch a.ppCp b");
		q.append("join fetch b.dwFolha c");
		q.append("where a.cdPt = :cdpt");
		q.append("and a.stAtivo = 1");
		
		q.defineParametro("cdpt", cdpt);
		q.setMaxResults(1);
		
		OmPt ompt = (OmPt) q.uniqueResult();
		
		if (ompt == null)
			return retorno;
		
		PpCp ppcp = ompt.getPpCp();
		
		if (ppcp == null)
			return retorno;
		
		DwFolha dwfolha = ppcp.getDwFolha();
		
		if (dwfolha == null)
			return retorno;
		
		DwFolha dwfolhaAtual = pesquisaFolhaByCdEStSemRota(dwfolha.getCdFolha());
		if (dwfolhaAtual == null || (dwfolhaAtual != null && dwfolhaAtual.getDwFolhaiacs() == null) || dwfolhaAtual.getDwFolhaiacs().isEmpty())
			return retorno;
		
		DwFolhaiac iac = dwfolhaAtual.getDwFolhaiacs().iterator().next();
		
		if (iac != null && iac.getQtAtiva() != null)
			retorno = iac.getQtAtiva().intValue();
		
		return retorno;
	}
	


	@SuppressWarnings("unused")
	public ListaFolhasProcessoDTO getFolhasProcessosDTO(FiltroPesquisaDTO filtro) {
		ListaFolhasProcessoDTO retorno = new ListaFolhasProcessoDTO();
		retorno.setItems(new ArrayList<FolhaDTO2>());
		retorno.setMeta(new MetaDTO(filtro));
				
		MapQuery q = new MapQuery(this.getDaoSession());
		
		q.append("select distinct t ");
		q.append("from DwFolha t ");
		
		q.append("join fetch t.dwFolharaps a ");
		q.append("join fetch a.dwRap b ");
		q.append("join fetch a.dwFolharapcoms c ");
		q.append("join fetch c.omProduto d ");
		q.append("join fetch t.omGt e ");
		
		q.append("where t.stAtivo = 1 ");
		// q.append("and t.omTppt.cdTppt = 'CIC' ");
		
		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){
			q.append("AND (");
			q.append(" upper(t.cdFolha) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.dsFolha) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		}
		
		q.append("order by t.cdFolha");
		
		// Lista do pojo
		List<DwFolha> listaPesquisa = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
		
		// Percorre as ferramentas da folha
 		for (DwFolha registro : listaPesquisa) {
 			
 			FolhaDTO2 regDTO = new FolhaDTO2();
 			
 			regDTO.setIdFolha(registro.getIdFolha());
 			regDTO.setCdFolha(registro.getCdFolha());
 			regDTO.setDsFolha(registro.getDsFolha());
 			regDTO.setTpPt(registro.getOmTppt().getCdTppt());
 			regDTO.setTpFolha(registro.getTpFolha());
 			regDTO.setCdGt(registro.getOmGt().getCdGt());
 			
 			if (registro.getSegCiclominimo() != null) {
 				regDTO.setCicloMinimo(registro.getSegCiclominimo().setScale(3));	
 			} else {
 				regDTO.setCicloMinimo(BigDecimal.ZERO);
 			}
 			
 			if (registro.getSegCiclotimeout() != null) {
 				regDTO.setCicloTimeout(registro.getSegCiclotimeout().setScale(2));	
 			} else {
 				regDTO.setCicloTimeout(BigDecimal.ZERO);
 			}
 			
 			if (registro.getSegCiclopadrao() != null) {
 				regDTO.setCicloPadrao(registro.getSegCiclopadrao().setScale(3));	
 			} else {
 				regDTO.setCicloPadrao(BigDecimal.ZERO);
 			}
 			
 			regDTO.setSetup(registro.getSegSetup());
 			regDTO.setStRegistro(registro.getStAtivo().intValue());

 			List<FolhaRapDTO2> raps = new ArrayList<FolhaRapDTO2>();
 			List<FolhaRapProdutoDTO> produtos = new ArrayList<FolhaRapProdutoDTO>();
 			
 			FolhaRapDTO2 rap;
 			FolhaRapProdutoDTO produto;
 			
 			for (DwFolharap rapFolha : registro.getDwFolharaps()) {
 			
 				rap = new FolhaRapDTO2();
 				
 				rap.setCdFerramenta(rapFolha.getDwRap().getCdRap());
 				rap.setDsFerramenta(rapFolha.getDwRap().getDsRap());
 				
 				if (rapFolha.getDwRap().getQtTotal() != null) {
 					rap.setQtTotal(rapFolha.getDwRap().getQtTotal().setScale(4));	
 				} else {
 					rap.setQtTotal(BigDecimal.ZERO);
 				}
 				
 				if (rapFolha.getDwRap().getQtAlocada() != null) {
 					rap.setQtAlocada(rapFolha.getDwRap().getQtAlocada().setScale(4));	
 				} else {
 					rap.setQtAlocada(BigDecimal.ZERO);
 				}
 				
 				if (rapFolha.getSegTempopreparacao() != null) {
 					rap.setTempoPreparacao(rapFolha.getSegTempopreparacao().setScale(0));	
 				} else {
 					rap.setTempoPreparacao(BigDecimal.ZERO);
 				}
 				
 			    // Inicia nova lista de produtos (para a ferramenta "rapFolha")
 				produtos = new ArrayList<FolhaRapProdutoDTO>();
 				
 			    // Percorre os produtos da ferramenta "rapFolha"
 				for (DwFolharapcom rapProduto : rapFolha.getDwFolharapcoms()) {
 					
 					produto = new FolhaRapProdutoDTO();
 					
 					produto.setCdProduto(rapProduto.getOmProduto().getCdProduto());
 					produto.setDsProduto(rapProduto.getOmProduto().getDsProduto());
 					produto.setIdReduzido(rapProduto.getIdredzproduto());
 					produto.setQtTotal(rapProduto.getQtTotal().setScale(4));
 					produto.setQtAlocada(rapProduto.getQtAtiva().setScale(4));
 					
 				    // Adiciona produto para a ferramenta "rapFolha"
 					produtos.add(produto);
 					
 				}
 				
 				// Atualiza a lista de produtos da ferramenta
 				rap.setProdutos(produtos);
 				
 				// Atualiza a lista de ferramentas
 				raps.add(rap);
 				
 			}
 			
 			// Seta as ferramentas da folha
 			regDTO.setFerramentas(raps);
 			
 			// Atualiza o retorno
 			retorno.getItems().add(regDTO);
 		}
		
		
 		if (listaPesquisa.size() > 0) {
 			ResumoRetornoRegistrosRN resRN = new ResumoRetornoRegistrosRN(getDao());
 			retorno.setMeta(resRN.getMetaDTO(filtro, q, listaPesquisa.size()));
 			resRN = null;
 		}
		
		q = null;
		listaPesquisa = null;
		
		return retorno;
		
	}
	
	@SuppressWarnings("unused")
	public FolhaDTO2 getFolhaProcessosByCd(String cdFolha) {
		FolhaDTO2 retorno = new FolhaDTO2();
		
		MapQuery q = new MapQuery(this.getDaoSession());
		
		q.append("select distinct t ");
		q.append("from DwFolha t ");
		
		q.append("join fetch t.dwFolharaps a ");
		q.append("join fetch a.dwRap b ");
		q.append("join fetch a.dwFolharapcoms c ");
		q.append("join fetch c.omProduto d ");
		q.append("join fetch t.omGt e ");
		
		
		q.append("where t.stAtivo = 1 ");
		// q.append("and t.omTppt.cdTppt = 'CIC' ");
		q.append("and t.cdFolha = :cdFolha ");
		
		q.append("order by t.cdFolha");
		
		q.defineParametro("cdFolha", cdFolha);
		
		// Lista do pojo
		List<DwFolha> lista = q.list();
		
		if (lista.size() == 1) {
			
 			FolhaDTO2 regDTO = new FolhaDTO2();
 			
 			regDTO.setIdFolha(lista.get(0).getIdFolha());
 			regDTO.setCdFolha(lista.get(0).getCdFolha());
 			regDTO.setDsFolha(lista.get(0).getDsFolha());
 			regDTO.setTpPt(lista.get(0).getOmTppt().getCdTppt());
 			regDTO.setTpFolha(lista.get(0).getTpFolha());
 			regDTO.setCdGt(lista.get(0).getOmGt().getCdGt());
 			
 			if (lista.get(0).getSegCiclominimo() != null) {
 				regDTO.setCicloMinimo(lista.get(0).getSegCiclominimo().setScale(3));	
 			} else {
 				regDTO.setCicloMinimo(BigDecimal.ZERO);
 			}
 			
 			if (lista.get(0).getSegCiclotimeout() != null) {
 				regDTO.setCicloTimeout(lista.get(0).getSegCiclotimeout().setScale(2));	
 			} else {
 				regDTO.setCicloTimeout(BigDecimal.ZERO);
 			}
 			
 			if (lista.get(0).getSegCiclopadrao() != null) {
 				regDTO.setCicloPadrao(lista.get(0).getSegCiclopadrao().setScale(3));	
 			} else {
 				regDTO.setCicloPadrao(BigDecimal.ZERO);
 			}
 			
 			regDTO.setSetup(lista.get(0).getSegSetup());
 			regDTO.setStRegistro(lista.get(0).getStAtivo().intValue());

 			List<FolhaRapDTO2> raps = new ArrayList<FolhaRapDTO2>();
 			List<FolhaRapProdutoDTO> produtos = new ArrayList<FolhaRapProdutoDTO>();
 			
 			FolhaRapDTO2 rap;
 			FolhaRapProdutoDTO produto;
 			
 			// Percorre as ferramentas da folha
 			for (DwFolharap rapFolha : lista.get(0).getDwFolharaps()) {
 			
 				rap = new FolhaRapDTO2();
 				
 				rap.setCdFerramenta(rapFolha.getDwRap().getCdRap());
 				rap.setDsFerramenta(rapFolha.getDwRap().getDsRap());
 				
 				if (rapFolha.getDwRap().getQtTotal() != null) {
 					rap.setQtTotal(rapFolha.getDwRap().getQtTotal().setScale(4));
 				} else {
 					rap.setQtTotal(BigDecimal.ZERO);
 				}
 				
 				if (rapFolha.getDwRap().getQtAlocada() != null) {
 					rap.setQtAlocada(rapFolha.getDwRap().getQtAlocada().setScale(4));	
 				} else {
 					rap.setQtAlocada(BigDecimal.ZERO);
 				}
 				
 				if (rapFolha.getSegTempopreparacao() != null) {
 					rap.setTempoPreparacao(rapFolha.getSegTempopreparacao().setScale(0));	
 				} else {
 					rap.setTempoPreparacao(BigDecimal.ZERO);
 				}
 				
 				// Inicia nova lista de produtos (para a ferramenta "rapFolha") 
 				produtos = new ArrayList<FolhaRapProdutoDTO>();
 				
 				// Percorre os produtos da ferramenta "rapFolha"
 				for (DwFolharapcom rapProduto : rapFolha.getDwFolharapcoms()) {
 				
 					produto = new FolhaRapProdutoDTO();
 					
 					produto.setCdProduto(rapProduto.getOmProduto().getCdProduto());
 					produto.setDsProduto(rapProduto.getOmProduto().getDsProduto());
 					produto.setIdReduzido(rapProduto.getIdredzproduto());
 					produto.setQtTotal(rapProduto.getQtTotal().setScale(4));
 					produto.setQtAlocada(rapProduto.getQtAtiva().setScale(4));
 					
 					// Adiciona produto para a ferramenta "rapFolha"
 					produtos.add(produto);
 					
 				}
 				
 				// Atualiza a lista de produtos da ferramenta
 				rap.setProdutos(produtos);
 				
 				// Atualiza a lista de ferramentas
 				raps.add(rap);
 				
 			}
 			
 			// Seta as ferramentas da folha
 			regDTO.setFerramentas(raps);
 			
 			// Atualiza o retorno
 			retorno = regDTO;
 			
		}
		
		return retorno;
		
	}
	
	public DwFolha getDwFolhaByCd(String cdFolha) {

		MapQuery q = new MapQuery(this.getDao().getSession());
		
		q.append("select t ");
		q.append("from DwFolha t ");
		q.append("where t.stAtivo = 1 ");
		q.append("  and t.cdFolha = :cdfolha");
		
		q.defineParametro("cdfolha", cdFolha);
		
		q.setMaxResults(1);
		
		return (DwFolha) q.uniqueResult();
		
	}
	
	@SuppressWarnings("unchecked")
	public Integer getIdReduzidoProdutoCpAtual(String cdPt, String cdProduto) {
		Integer id = null;
		String strSQL = "";
		
		getDao().iniciaSessao();		
		
		SQLQuery q = null;
		
				
		strSQL = strSQL.concat("SELECT frc.id_produto, frc.idredzproduto ");
		strSQL = strSQL.concat("  FROM om_pt pt  ");
		strSQL = strSQL.concat("  JOIN pp_cp cp ON (cp.id_cp = pt.id_cp) ");
		strSQL = strSQL.concat("  JOIN dw_folharap fr ON (fr.id_folha = cp.id_folha) ");
		strSQL = strSQL.concat("  JOIN dw_folharapcom frc ON (frc.id_folharap = fr.id_folharap) ");
		strSQL = strSQL.concat("  JOIN om_produto pro ON (pro.id_produto = frc.id_produto) ");
		strSQL = strSQL.concat(" WHERE pt.st_ativo = 1 ");
		strSQL = strSQL.concat("   AND pt.cd_pt = :cdPt ");
		strSQL = strSQL.concat("   AND pro.cd_produto = :cdProduto  ");
			
		q = this.getDaoSession().createSQLQuery(strSQL);
		q.setParameter("cdPt", cdPt); 
		q.setParameter("cdProduto", cdProduto); 
	    List<Object> lista = q.list();
				 
		if (lista.size() > 0) {
			Object[] registroLido = null;
			Object registroLidoAux = (Object) lista.get(0);
			registroLido = (Object[]) registroLidoAux;
			
			id = ConversaoTipos.converterParaBigDecimal(registroLido[1]).intValue();
		}
		 
		getDao().finalizaSessao();
		lista = null;
		
		return id;
	}
	
	@SuppressWarnings("unchecked")
	public List<FolhaRapProdutoDTO> getProdutosOPAtual(String cdPt) {
		List<FolhaRapProdutoDTO> retorno = new ArrayList<FolhaRapProdutoDTO>();
		
		int _cdpro = 0;
		int _dspro = _cdpro + 1;
		int _ppc = _dspro + 1;
		
		String strSQL = "";
		
		getDao().iniciaSessao();		
		
		SQLQuery q = null;
				
		strSQL = strSQL.concat("SELECT pro.cd_produto, pro.ds_produto, frc.qt_ativa ");
		strSQL = strSQL.concat("  FROM om_pt pt  ");
		strSQL = strSQL.concat("  JOIN pp_cp cp ON (cp.id_cp = pt.id_cp) ");
		strSQL = strSQL.concat("  JOIN dw_folharap fr ON (fr.id_folha = cp.id_folha) ");
		strSQL = strSQL.concat("  JOIN dw_folharapcom frc ON (frc.id_folharap = fr.id_folharap) ");
		strSQL = strSQL.concat("  JOIN om_produto pro ON (pro.id_produto = frc.id_produto) ");
		strSQL = strSQL.concat(" WHERE pt.st_ativo = 1 ");
		strSQL = strSQL.concat("   AND pt.cd_pt = :cdPt ");
		strSQL = strSQL.concat(" ORDER BY pro.cd_produto");
			
		q = this.getDaoSession().createSQLQuery(strSQL);
		q.setParameter("cdPt", cdPt);  
	    List<Object> lista = q.list();
				
	    for (Object reg : lista) {
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			FolhaRapProdutoDTO item = new FolhaRapProdutoDTO();
			item.setCdProduto((String) registroLido[_cdpro]);
			item.setDsProduto((String) registroLido[_dspro]);
			item.setQtAlocada(ConversaoTipos.converterParaBigDecimal(registroLido[_ppc]).setScale(0));
			
			retorno.add(item);
		}
		 
		getDao().finalizaSessao();
		lista = null;
		
		return retorno;
	}
	
	@SuppressWarnings("unused")
	public List<FolhaDTO2> getFolhasGt(String cdGt) {
		List<FolhaDTO2> retorno = new ArrayList<FolhaDTO2>();
				
		MapQuery q = new MapQuery(this.getDaoSession());
		
		q.append("select distinct t ");
		q.append("from DwFolha t ");
		q.append("join fetch t.omGt e ");		
		q.append("where t.stAtivo = 1 ");
		q.append("and t.omTppt.cdTppt = 'CIC' ");
		q.append("and e.cdGt = :cdGt ");
		q.append("order by t.cdFolha");
		
		q.defineParametro("cdGt", cdGt);
		
		// Lista do pojo
		List<DwFolha> listaPesquisa = q.list();
		
		// Percorre as ferramentas da folha
 		for (DwFolha registro : listaPesquisa) { 			
 			FolhaDTO2 regDTO = new FolhaDTO2();
 			
 			regDTO.setIdFolha(registro.getIdFolha());
 			regDTO.setCdFolha(registro.getCdFolha());    
 			
 			retorno.add(regDTO);
 		}	
		 	 
		q = null;
		listaPesquisa = null;
		
		return retorno;
		
	}

	
}
