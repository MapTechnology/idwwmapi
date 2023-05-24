package idw.model.rn.folhainspecaorap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmProdutoDAO;
import idw.model.pojos.DwFtParam;
import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwTprap;
import idw.model.pojos.MmOs;
import idw.model.pojos.MmOsInsRap;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.model.pojos.QqFolhaInsAtiv;
import idw.model.pojos.QqFolhaInsMed;
import idw.model.pojos.QqFolhaInsRap;
import idw.model.pojos.QqFolhainsft;
import idw.model.pojos.QqInsRap;
import idw.model.pojos.QqInsrapFt;
import idw.model.pojos.template.MmOsTemplate;
import idw.model.pojos.template.QqInsRapTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.DwRapRN;
import idw.model.rn.GrupoFerramentaRN;
import idw.model.rn.ParametroRN;
import idw.model.rn.UsuarioRN;
import idw.model.rn.estoque.EstoqueRN;
import idw.model.rn.estoque.LocalEstoqueDTO;

public class FolhaInspecaoRapRN extends AbstractRN<DAOGenerico>{

	public FolhaInspecaoRapRN() {
		this(null);
	}

	public FolhaInspecaoRapRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public static void main(String[] args) {
		FolhaInspecaoRapRN rn = new FolhaInspecaoRapRN();

		rn.iniciaConexaoBanco();
		FiltroFolhaInspecaoRapDTO filtro = new FiltroFolhaInspecaoRapDTO();
		filtro.setQtRegistroPorPagina(10);
		filtro.setPagina(2);
		QqFolhaInsRap pojo = new QqFolhaInsRap();
		pojo.setIdFolhainsrap(100l);
		filtro.setFolhainsrap(pojo);

		rn.pesquisarFolhasInspecaoRAP(filtro);
		rn.finalizaConexaoBanco();

	}
	/* Metodo para pesquisar em QQ_FOLHA_INS_RAP
	 *
	 */
	public FolhasInspecaoRapDTO pesquisarFolhasInspecaoRAP(FiltroFolhaInspecaoRapDTO filtro) {
		FolhasInspecaoRapDTO retorno = new FolhasInspecaoRapDTO();
		MapQuery q = new MapQuery(getDaoSession());

		// Obtem a quantidade total de registro que a pesquisa retornara
		createHqlFolhasInspecaoRAP(q, filtro);
		q.configuraSelectCount("select a");
		defineParametroFolhasInspecaoRAP(q, filtro);
		Integer totalRegistro = q.selectCount("select a");

		
		if (filtro.getQtRegistroPorPagina()==null||filtro.getPagina()==null||filtro.getQtRegistroPorPagina()==0||filtro.getPagina()==0) {
			retorno.setTitle("Não foi definido um número de registros ou um número de página.");

		}else{			// Obtem os registros das pequisas conforma a pagina e quant total por pagina
			q.novaConsulta();
			createHqlFolhasInspecaoRAP(q, filtro);
			defineParametroFolhasInspecaoRAP(q, filtro);

			q.query().setFirstResult( (filtro.getPagina()-1) * filtro.getQtRegistroPorPagina());
			q.setMaxResults(filtro.getQtRegistroPorPagina());

			List<QqFolhaInsRap> lista = q.list();

			retorno.setPagina(filtro.getPagina());
			retorno.setTotalPaginas(totalRegistro/filtro.getQtRegistroPorPagina());
			double resto = totalRegistro % filtro.getQtRegistroPorPagina();
			if ( resto > 0 )
				retorno.setTotalPaginas(retorno.getTotalPaginas() + 1);

			// Clona retorno
			retorno.setFolhas(new ArrayList<FolhaInspecaoRapDTO>());
			for (QqFolhaInsRap folha : lista) {
				FolhaInspecaoRapDTO rapdto = new FolhaInspecaoRapDTO();
				if (lista.size() == 1)
					rapdto.setQqFolhaInsRap(folha.clone());
				else
					rapdto.setQqFolhaInsRap(folha.clone(false));
				retorno.getFolhas().add(rapdto);
			// Se nenhum registro encontrado, passar mensagem
			}
			if (lista.isEmpty()) {
				retorno.setTitle("Nenhum folha de inspeção encontrada");
			}	
		}

		return retorno;
	}

	/* Metodo para retornar o hql da pesquisarFolhasInspecaoRAP
	 *
	 */
	private void createHqlFolhasInspecaoRAP(MapQuery q, FiltroFolhaInspecaoRapDTO filtro) {
		q.append("select a");
		q.append("from QqFolhaInsRap a");

		if (filtro.getFolhainsrap() != null) {

			q.appendWhere(MapQuery._NULL, "a.stAtivo = :stativo", filtro.getFolhainsrap().getStAtivo() != null);
			q.appendWhere(MapQuery._AND, "a.cdFolhainsrap like :cdfolhainsrap", filtro.getFolhainsrap().getCdFolhainsrap() != null && filtro.getFolhainsrap().getCdFolhainsrap().equals("") == false);
			q.appendWhere(MapQuery._AND, "a.dsFolhainsrap like :dsfolhainsrap", filtro.getFolhainsrap().getDsFolhainsrap() != null && filtro.getFolhainsrap().getDsFolhainsrap().equals("") == false);
			q.appendWhere(MapQuery._AND, "a.omProduto.cdProduto like :cdproduto", filtro.getFolhainsrap().getOmProduto() != null && filtro.getFolhainsrap().getOmProduto().getCdProduto() != null && filtro.getFolhainsrap().getOmProduto().getCdProduto().equals("") == false);
			q.appendWhere(MapQuery._AND, "a.dwGrupoFerramenta.cdGrupoFerramenta like :cdgrupoferramenta", filtro.getFolhainsrap().getDwGrupoFerramenta() != null && filtro.getFolhainsrap().getDwGrupoFerramenta().getCdGrupoFerramenta() != null && filtro.getFolhainsrap().getDwGrupoFerramenta().getCdGrupoFerramenta().equals("") == false);
			q.appendWhere(MapQuery._AND, "a.dwTprap.cdTprap like :cdtprap", filtro.getFolhainsrap().getDwTprap() != null && filtro.getFolhainsrap().getDwTprap().getCdTprap() != null && filtro.getFolhainsrap().getDwTprap().getCdTprap().equals("") == false);
			q.appendWhere(MapQuery._AND, "a.dwRap.cdRap like :cdrap", filtro.getFolhainsrap().getDwRap() != null && filtro.getFolhainsrap().getDwRap().getCdRap() != null && filtro.getFolhainsrap().getDwRap().getCdRap().equals("") == false);
			q.appendWhere(MapQuery._AND, "a.idFolhainsrap = :id", filtro.getFolhainsrap().getIdFolhainsrap() != null && filtro.getFolhainsrap().getIdFolhainsrap() > 0);

		}
	}

	private void defineParametroFolhasInspecaoRAP(MapQuery q, FiltroFolhaInspecaoRapDTO filtro) {
		// Definir os parametros
		if (filtro.getFolhainsrap() != null) {
			q.defineParametro("id", filtro.getFolhainsrap().getIdFolhainsrap());
			q.defineParametro("stativo", filtro.getFolhainsrap().getStAtivo());
			q.defineParametro("cdfolhainsrap", filtro.getFolhainsrap().getCdFolhainsrap());
			q.defineParametro("dsfolhainsrap", filtro.getFolhainsrap().getDsFolhainsrap());
			if (filtro.getFolhainsrap().getOmProduto() != null)
				q.defineParametro("cdproduto", filtro.getFolhainsrap().getOmProduto().getCdProduto());
			if (filtro.getFolhainsrap().getDwGrupoFerramenta() != null)
				q.defineParametro("cdgrupoferramenta", filtro.getFolhainsrap().getDwGrupoFerramenta().getCdGrupoFerramenta());
			if (filtro.getFolhainsrap().getDwTprap() != null)
				q.defineParametro("cdtprap", filtro.getFolhainsrap().getDwTprap().getCdTprap());
			if (filtro.getFolhainsrap().getDwRap() != null)
				q.defineParametro("cdrap", filtro.getFolhainsrap().getDwRap().getCdRap());
		}
	}


	public FolhasInspecaoRapDTO pesquisarFolhaInspecaoRAPById(Long id) {
		FolhasInspecaoRapDTO retorno = new FolhasInspecaoRapDTO();

		MapQuery q = new MapQuery(getDaoSession());

		FiltroFolhaInspecaoRapDTO filtro = new FiltroFolhaInspecaoRapDTO();
		QqFolhaInsRap pojo = new QqFolhaInsRap();
		pojo.setIdFolhainsrap(id);
		filtro.setFolhainsrap(pojo);

		// Obtem a quantidade total de registro que a pesquisa retornara
		createHqlFolhasInspecaoRAP(q, filtro);
		defineParametroFolhasInspecaoRAP(q, filtro);

		q.setMaxResults(1);

		QqFolhaInsRap folha = (QqFolhaInsRap) q.uniqueResult();

		retorno.setPagina(1);
		retorno.setTotalPaginas(1);

		// Clona retorno
		retorno.setFolhas(new ArrayList<FolhaInspecaoRapDTO>());
		if (folha != null) {
			FolhaInspecaoRapDTO rapdto = new FolhaInspecaoRapDTO();
			rapdto.setQqFolhaInsRap(folha.clone());
			retorno.getFolhas().add(rapdto);
		} else {
			// Se nenhum registro encontrado, passar mensagem
			retorno.setTitle("Nenhum folha de inspeção encontrada");
		}

		return retorno;

	}



	public QqFolhaInsRap pesquisarFolhaInspecaoRAPByCd(String cd) {
		MapQuery q = new MapQuery(getDaoSession());

		FiltroFolhaInspecaoRapDTO filtro = new FiltroFolhaInspecaoRapDTO();
		QqFolhaInsRap pojo = new QqFolhaInsRap();
		pojo.setCdFolhainsrap(cd);
		pojo.setStAtivo((byte) 1);
		filtro.setFolhainsrap(pojo);

		// Obtem a quantidade total de registro que a pesquisa retornara
		createHqlFolhasInspecaoRAP(q, filtro);
		defineParametroFolhasInspecaoRAP(q, filtro);

		q.setMaxResults(1);

		QqFolhaInsRap folha = (QqFolhaInsRap) q.uniqueResult();

		return folha;

	}



	public FolhasInspecaoRapDTO excluirFolhaInspecaoRAP(Long idFolhainsrap, Long idUsr) {
		FolhasInspecaoRapDTO retorno = new FolhasInspecaoRapDTO();

		MapQuery q = new MapQuery(getDaoSession());

		FiltroFolhaInspecaoRapDTO filtro = new FiltroFolhaInspecaoRapDTO();
		QqFolhaInsRap pojo = new QqFolhaInsRap();
		pojo.setIdFolhainsrap(idFolhainsrap);
		filtro.setFolhainsrap(pojo);


		// Obtem a quantidade total de registro que a pesquisa retornara
		createHqlFolhasInspecaoRAP(q, filtro);
		defineParametroFolhasInspecaoRAP(q, filtro);

		q.setMaxResults(1);

		QqFolhaInsRap folha = (QqFolhaInsRap) q.uniqueResult();

		retorno.setPagina(1);
		retorno.setTotalPaginas(1);

		// Clona retorno
		retorno.setFolhas(new ArrayList<FolhaInspecaoRapDTO>());
		if (folha != null) {
			UsuarioRN rn = new UsuarioRN(getDao());
			// Procura usuario
			OmUsr omusr = rn.getOmUsr(idUsr);

			if (omusr != null) {
				// Excluir folha de inspecao
				folha.setDtStativo(DataHoraRN.getDataHoraAtual());
				folha.setStAtivo((byte) 0);
				folha.setOmUsrByIdUsrstativo(omusr);

				getDao().makePersistent(folha);
				retorno.setStatus("200");
				retorno.setTitle("Exclusão realizada com sucesso");
				FolhaInspecaoRapDTO rapdto = new FolhaInspecaoRapDTO();
				rapdto.setQqFolhaInsRap(folha.clone());
				retorno.getFolhas().add(rapdto);
			} else {
				retorno.setStatus("400");
				retorno.setTitle("Usuario desconhecido");
			}
		} else {
			retorno.setStatus("400");
			// Se nenhum registro encontrado, passar mensagem
			retorno.setTitle("Nenhum folha de inspeção encontrada");
		}

		return retorno;

	}


	public FolhasInspecaoRapDTO salvarFolhaInspecaoRAP(FiltroFolhaInspecaoRapDTO rapdto) {
		FolhasInspecaoRapDTO retorno = new FolhasInspecaoRapDTO();
		retorno.setFolhas(new ArrayList<FolhaInspecaoRapDTO>());
		FolhaInspecaoRapDTO folhadto = new FolhaInspecaoRapDTO();
		retorno.getFolhas().add(folhadto);

		if (isFolhaInsRapValida(folhadto, rapdto)) {

			// Desativar registro antigo se for o caso
			if (rapdto.getFolhainsrap().getIdFolhainsrap() != null) {
				FolhasInspecaoRapDTO excluido = excluirFolhaInspecaoRAP(rapdto.getFolhainsrap().getIdFolhainsrap(), rapdto.getFolhainsrap().getOmUsrByIdUsrrevisao().getIdUsr());

				// Limpa id para poder incluir novo
				rapdto.getFolhainsrap().setIdFolhainsrap(null);
				rapdto.getFolhainsrap().setRevisao(excluido.getFolhas().get(0).getQqFolhaInsRap().getRevisao() + 1);
				rapdto.getFolhainsrap().setStAtivo((byte) 1);
				rapdto.getFolhainsrap().setDtRevisao(DataHoraRN.getDataHoraAtual());
				rapdto.getFolhainsrap().setDtStativo(DataHoraRN.getDataHoraAtual());

			} else {
				rapdto.getFolhainsrap().setRevisao(1l);
				rapdto.getFolhainsrap().setStAtivo((byte) 1);
				rapdto.getFolhainsrap().setDtRevisao(DataHoraRN.getDataHoraAtual());
				rapdto.getFolhainsrap().setDtStativo(DataHoraRN.getDataHoraAtual());
			}


			// Incluir um novo registro com nova revisao
			getDao().makePersistent(rapdto.getFolhainsrap());
		
			FolhaInspecaoRapDTO dto = new FolhaInspecaoRapDTO();
			dto.setQqFolhaInsRap(rapdto.getFolhainsrap().clone());
			retorno.getFolhas().add(dto);

			// Finaliza
			retorno.setStatus("200");
			retorno.setTitle("Folha de inspeção salva com sucesso");
		} else {
			retorno.setStatus("400");
			retorno.setTitle(folhadto.getTitle());
		}

		return retorno;
	}

	/* Valida a FolhaInspecaoRap
	 *
	 */
	private boolean isFolhaInsRapValida(FolhaInspecaoRapDTO retorno, FiltroFolhaInspecaoRapDTO salvar) {
		// Avalia se algum campo obrigatorio esta vazio
		if (isFolhaInsRapAlgumCampoVazio(retorno, salvar.getFolhainsrap())) {
			return false;
		}

		// Avalia se alguma FK é desconhecida
		if (isFolhaInsRapAlgumaFKDesconhecida(retorno, salvar.getFolhainsrap())) {
			return false;
		}

		// Avalia se alguma integridade referencial
		if (isFolhaInsRapIntegro(retorno, salvar.getFolhainsrap()) == false) {
			return false;
		}

		return true;
	}

	// Metodo para avaliar se algum campo obrigatorio está vazio
	private boolean isFolhaInsRapAlgumCampoVazio(FolhaInspecaoRapDTO retorno, QqFolhaInsRap salvar) {
		boolean isretorno = false;
		// Se o codigo da folha estiver vazio
		if (salvar.getCdFolhainsrap().isEmpty()) {
			retorno.setTitle("Cd.Folha inspeção vazio");
		} else if (salvar.getDsFolhainsrap().isEmpty()) {
			// Se a descricao da folha estivar vazia
			retorno.setTitle("Descrição Folha inspeção vazia");
		} else if (salvar.getDwGrupoFerramenta() == null || salvar.getDwGrupoFerramenta().getCdGrupoFerramenta().isEmpty()) {
			retorno.setTitle("Cd.Grupo ferramenta vazio");
		} else if (salvar.getDwTprap() == null || salvar.getDwTprap().getCdTprap().isEmpty()) {
			retorno.setTitle("Tipo ferramenta vazio");
		} else if (salvar.getOmProduto() == null || salvar.getOmProduto().getCdProduto().isEmpty()) {
			retorno.setTitle("Cd.Produto vazio");
		} else  if (salvar.getQqFolhaInsAtivs() == null || salvar.getQqFolhaInsAtivs().isEmpty() == false) {
			// Avalia se tem alguma informacao vazia na atividade
			for (QqFolhaInsAtiv ativ : salvar.getQqFolhaInsAtivs()) {
				if (ativ.getDsFolhainsativ().isEmpty()) {
					retorno.setTitle("Descrição atividade vazia");
				} else if (ativ.getOrdem() == null) {
					retorno.setTitle("Ordem da atividade " + ativ.getDsFolhainsativ() + " não definida.");
				} else if (ativ.getSegDuracaoesperada() == null) {
					retorno.setTitle("Duração da atividade " + ativ.getDsFolhainsativ() + " não definida.");
				} else {
					// avaliar as midias
					for (QqFolhaInsMed midia : ativ.getQqFolhaInsMeds()) {
						if (midia.getDsFolhainsmed().isEmpty()) {
							retorno.setTitle("Descrição da mídia vazia");
						} else if (midia.getNomearquivo().isEmpty()) {
							retorno.setTitle("Nome do arquivo da midia vazio");
						} else if (midia.getOrdem() == null || midia.getOrdem() <= 0) {
							retorno.setTitle("Ordem da mida vazia");
						}
					}

					// avaliar as variaveis de medição
					for (QqFolhainsft ft : ativ.getQqFolhainsfts()) {
						if(ft.getDwFtParam() == null) {
							retorno.setTitle("Variável medição desconhecida");
						} else if (ft.getDwFtParam().getIsMinimo() != null && ft.getDwFtParam().getIsMinimo() && ft.getMinimo() == null) {
							retorno.setTitle("Valor minimo vazio");
						} else if (ft.getDwFtParam().getIsMeta() != null && ft.getDwFtParam().getIsMeta() && ft.getMeta() == null) {
							retorno.setTitle("Valor meta vazio");
						} else if (ft.getDwFtParam().getIsMaximo() != null && ft.getDwFtParam().getIsMaximo() && ft.getMaximo() == null) {
							retorno.setTitle("Valor máximo vazio");
						} else if (ft.getDwFtParam().getIsCombo() != null && ft.getDwFtParam().getIsCombo()) {
							if (
									ft.getDwFtParam().getStValor1() != ft.getSt().byteValue() &&
									ft.getDwFtParam().getStValor2() != ft.getSt().byteValue() &&
									ft.getDwFtParam().getStValor3() != ft.getSt().byteValue() &&
									ft.getDwFtParam().getStValor4() != ft.getSt().byteValue()
									) {
								retorno.setTitle("Valor variável medição inválido");
							}
						}
					}
				}
			}
		}


		return isretorno;
	}


	// Metodo para avaliar se as FKs existem
	private boolean isFolhaInsRapAlgumaFKDesconhecida(FolhaInspecaoRapDTO retorno, QqFolhaInsRap salvar) {
		boolean isretorno = false;

		// Avaliar grupo de ferramentas
		if (salvar.getDwGrupoFerramenta() != null) {
			GrupoFerramentaRN rn = new GrupoFerramentaRN(getDao());
			DwGrupoFerramenta grupo = rn.pesquisarGrupoFerramentaByCd(salvar.getDwGrupoFerramenta().getCdGrupoFerramenta());
			if (grupo == null) {
				retorno.setTitle("Grupo ferramenta desconhecido");
				isretorno = true;
			} else {
				salvar.setDwGrupoFerramenta(grupo);
			}
		} else {
			retorno.setTitle("Grupo ferramenta desconhecido");
			isretorno = true;
		}

		// Avaliar tipo de ferramenta
		DwRapRN rn = new DwRapRN(getDao());
		if (salvar.getDwTprap() != null) {
			DwTprap dwtprap = rn.pesquisarTipoRAPByCd(salvar.getDwTprap().getCdTprap());
			if (dwtprap == null) {
				retorno.setTitle("Tipo ferramenta desconhecido");
				isretorno = true;
			} else {
				salvar.setDwTprap(dwtprap);
			}
		} else {
			retorno.setTitle("Tipo ferramenta desconhecido");
			isretorno = true;
		}

		// Avaliar ferramenta
		if (salvar.getDwRap() != null && salvar.getDwRap().getCdRap() != null && salvar.getDwRap().getCdRap().trim().equals("") == false) {
			rn.setCdRap(salvar.getDwRap().getCdRap());
			DwRap dwrap = rn.pesquisarDwRapByCdRap();
			if (dwrap == null) {
				retorno.setTitle("Ferramenta desconhecida");
				isretorno = true;
			} else {
				salvar.setDwRap(dwrap);
			}
		} else {
			salvar.setDwRap(null);
		}

		// Avaliar produto
		if (salvar.getOmProduto() != null) {
			OmProdutoDAO rnp = new OmProdutoDAO(getDaoSession());
			OmProduto omproduto = rnp.getOmProdutoPorCdAtivoOrderByIdDesc(salvar.getOmProduto().getCdProduto());
			if (omproduto == null) {
				retorno.setTitle("Código do produto desconhecido");
				isretorno = true;
			} else {
				salvar.setOmProduto(omproduto);
			}
		} else {
			retorno.setTitle("Código do produto desconhecido");
			isretorno = true;
		}

		// Avaliar usuario da revisao
		if (salvar.getOmUsrByIdUsrrevisao() != null) {
			UsuarioRN rnu = new UsuarioRN(getDao());
			OmUsr omusr = rnu.getOmUsrByLoginStAtivo(salvar.getOmUsrByIdUsrrevisao().getLogin());
			if (omusr == null) {
				retorno.setTitle("Usuário desconhecido");
				isretorno = true;
			} else {
				salvar.setOmUsrByIdUsrrevisao(omusr);
				salvar.setOmUsrByIdUsrstativo(omusr);
			}
		} else {
			retorno.setTitle("Usuário desconhecido");
			isretorno = true;
		}


		// Avaliar as FKs das atividades
		ParametroRN rnp = new ParametroRN(getDao());
		for (QqFolhaInsAtiv ativ : salvar.getQqFolhaInsAtivs()) {
			ativ.setQqFolhaInsRap(salvar);
			for (QqFolhainsft ft : ativ.getQqFolhainsfts()) {
				ft.setQqFolhaInsAtiv(ativ);
				if (ft.getDwFtParam() != null) {
					DwFtParam pardto = rnp.getDwFtParam(ft.getDwFtParam().getIdFtParam());
					if (pardto == null) {
						retorno.setTitle("Variável de medição desconhecida");
						isretorno = true;
					} else {
						ft.setDwFtParam(pardto);
					}
				}
			}
			
			// avalia as medias
			for (QqFolhaInsMed med : ativ.getQqFolhaInsMeds()) {
				med.setQqFolhaInsAtiv(ativ);
				med.setIdFolhainsmed(null);
			}
		}

		return isretorno;
	}

	// Metodo para avaiar a integridade referencial
	private boolean isFolhaInsRapIntegro(FolhaInspecaoRapDTO retorno, QqFolhaInsRap salvar) {
		boolean isretorno = true;

		// Verifica se o codigo da folha e revisao já existem, quando não for alteracao, mas sim inclusao
		if (salvar.getIdFolhainsrap() == null) {
			QqFolhaInsRap folha = pesquisarFolhaInspecaoRAPByCd(salvar.getCdFolhainsrap());
			if (folha != null) {
				retorno.setTitle("Folha de inspeção já cadastrada");
				isretorno = false;
			}
		}

		return isretorno;
	}


	public QqFolhaInsRapDTO getQqFolhaInsRapDTO(String cdLocalOrigem, String cdLocalDestino, String cdrap) {
		QqFolhaInsRapDTO retorno = null;
		
		DwRapRN rn = new DwRapRN(getDao());
		
		DwRap dwrap;
		rn.setCdRap(cdrap);
		dwrap = rn.pesquisarDwRapByCdRap();
		
		// Enquanto ainda nao tem o roteiro de inspecao, pesquisar pelo grupo da ferramenta e pelo produto para encontrar a folha de inspecao
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from QqFolhaInsRap a ");
		q.append("where a.stAtivo = 1 and");
		q.append("a.dwTprap = :dwtprap and");
		q.append("a.dwGrupoFerramenta = :dwgrupoferramenta");
		
		q.defineParametro("dwtprap", dwrap.getDwTprap());
		q.defineParametro("dwgrupoferramenta", dwrap.getDwRapGrupos().iterator().next().getDwGrupoFerramenta());
		q.setMaxResults(1);
		
		QqFolhaInsRap folhains = (QqFolhaInsRap) q.uniqueResult();
		
		if (folhains != null) {
			retorno = new QqFolhaInsRapDTO();
			retorno.setIdFolhainsrap(folhains.getIdFolhainsrap());
			retorno.setCdFolhainsrap(folhains.getCdFolhainsrap());
			retorno.setRevisao(folhains.getRevisao());
			retorno.setDtRevisao(folhains.getDtRevisao());
			retorno.setDtStativo(folhains.getDtStativo());
			retorno.setAtividades(new ArrayList<QqFolhaInsAtivDTO>());
			
			List<QqFolhaInsAtiv> ativs = new ArrayList<QqFolhaInsAtiv>(folhains.getQqFolhaInsAtivs());
			
			Collections.sort(ativs, new Comparator<QqFolhaInsAtiv>() {

				@Override
				public int compare(QqFolhaInsAtiv o1, QqFolhaInsAtiv o2) {
					return o1.getOrdem().compareTo(o2.getOrdem());
				}
			});
			
			for (QqFolhaInsAtiv ativ : ativs) {
				QqFolhaInsAtivDTO ativDTO = new QqFolhaInsAtivDTO();
				ativDTO.setIdFolhainsativ(ativ.getIdFolhainsativ());
				ativDTO.setDsFolhainsativ(ativ.getDsFolhainsativ());
				ativDTO.setOrdem(ativ.getOrdem());
				ativDTO.setSegDuracaoesperada(ativ.getSegDuracaoesperada());
				
				// Obtem variaveis de medicao
				ativDTO.setQqFolhainsfts(new ArrayList<QqFolhainsftDTO>());
				for (QqFolhainsft ft : ativ.getQqFolhainsfts()) {
					QqFolhainsftDTO ftDTO = new QqFolhainsftDTO();
					ftDTO.setIdFolhainsft(ft.getIdFolhainsft());
					ftDTO.setDsVariavel(ft.getDwFtParam().getDsParametro());
					if (ft.getMaximo() != null)
						ftDTO.setMaximo(ft.getMaximo().doubleValue());
					if (ft.getMeta() != null)
						ftDTO.setMeta(ft.getMeta().doubleValue());
					if (ft.getMinimo() != null)
						ftDTO.setMinimo(ft.getMinimo().doubleValue());
					ftDTO.setStEsperado(ft.getSt());
					ftDTO.setIsMinimo(ft.getDwFtParam().getIsMinimo());
					ftDTO.setIsMeta(ft.getDwFtParam().getIsMeta());
					ftDTO.setIsMaximo(ft.getDwFtParam().getIsMaximo());
					ftDTO.setIsCombo(ft.getDwFtParam().getIsCombo());
					try {
						ftDTO.setSt1(ft.getDwFtParam().getStValor1().intValue());
						ftDTO.setDs1(ft.getDwFtParam().getDsValor1());
					} catch (Exception e) {
						ftDTO.setSt1(0);
						ftDTO.setDs1("");
					}
					try {
						ftDTO.setSt2(ft.getDwFtParam().getStValor2().intValue());
						ftDTO.setDs2(ft.getDwFtParam().getDsValor2());
					} catch (Exception e) {
						ftDTO.setSt2(0);
						ftDTO.setDs2("");
					}
					try {
						ftDTO.setSt3(ft.getDwFtParam().getStValor3().intValue());
						ftDTO.setDs3(ft.getDwFtParam().getDsValor3());
					} catch (Exception e) {
						ftDTO.setSt3(0);
						ftDTO.setDs3("");
					}
					try {
						ftDTO.setSt4(ft.getDwFtParam().getStValor4().intValue());
						ftDTO.setDs4(ft.getDwFtParam().getDsValor4());
					} catch (Exception e) {
						ftDTO.setSt4(0);
						ftDTO.setDs4("");
					}
					ftDTO.setSt(-1);
					ativDTO.getQqFolhainsfts().add(ftDTO);
				}
				
				
				// Obtem medias
				ativDTO.setQqFolhaInsMeds(new ArrayList<QqFolhaInsMedDTO>());
				for (QqFolhaInsMed med : ativ.getQqFolhaInsMeds()) {
					QqFolhaInsMedDTO medDTO = new QqFolhaInsMedDTO();
					medDTO.setIdFolhainsmed(med.getIdFolhainsmed());
					medDTO.setDsFolhainsmed(med.getDsFolhainsmed());
					medDTO.setMedia(med.getMedia());
					medDTO.setNomearquivo(med.getNomearquivo());
					medDTO.setOrdem(med.getOrdem());
					ativDTO.getQqFolhaInsMeds().add(medDTO);
				}
				
				retorno.getAtividades().add(ativDTO);
			}
		}		
		
		return retorno;
	}

	
	
	/* Metodo abaixo sera chamado apos uma inspecao na ferramenta ser executada.
	 * Alem do registro da inspeção uma movimentacao de esstoque tambem poderá ocorrer
	 */
	public QqInsRapDTO salvarInspecaoFerramenta(LocalEstoqueDTO local) {

		// salva a movimentacao
		EstoqueRN ern = new EstoqueRN(getDao());
		//SucessoDTO retornoMovimentacao = 
		ern.movimentarFerramenta(local.getCdLocalOrigem(), local.getCdLocalDestino(), local.getCdRap(), local.getLogin());

		
		// Encontra a folha
		QqFolhaInsRap folhainsrap = pesquisarFolhaInspecaoRAPById(local.getFolhains().getIdFolhainsrap()).getFolhas().get(0).getQqFolhaInsRap();
		
		// Valida os dados da inspeção
		
		// Pesquisa usuario
		UsuarioRN urn = new UsuarioRN(getDao());
		OmUsr omusr = urn.getOmUsrByLoginStAtivo(local.getLogin());
		
		// Pesquisa a ferramenta
		DwRapRN frn = new DwRapRN(getDao());
		frn.setCdRap(local.getCdRap());
		DwRap dwrap = frn.pesquisarDwRapByCdRap();
		
		
		Date dthrAtual = DataHoraRN.getDataHoraAtual();
		// Salvar OS se for o caso
		MmOs mmos = new MmOs();
		mmos.setIdOs(null);
		mmos.setCdOs(local.getCdRap() + DataHoraRN.getDataHoraAtualFormatada());
		mmos.setRevisao(1l);
		mmos.setDsOs("OS gerada pela movimentação ferramenta " + local.getCdRap());
		mmos.setDtRevisao(dthrAtual);
		mmos.setDtStativo(dthrAtual);
		mmos.setOmUsrByIdUsrrevisao(omusr);
		mmos.setOmUsrByIdUsrstativo(omusr);
		mmos.setStAtivo((byte) 1);
		mmos.setStOs(MmOsTemplate._ST_OS._FECHADA.getValue());

		getDao().makePersistent(mmos);

		MmOsInsRap mmOsInsRap = new MmOsInsRap();
		mmOsInsRap.setIdOsinsrap(null);
		mmOsInsRap.setMmOs(mmos);
		mmOsInsRap.setQqFolhaInsRap(folhainsrap);
		mmOsInsRap.setDwEstmovRap(ern.getDwestmovrap());
		mmOsInsRap.setDwRap(dwrap);
		
		getDao().makePersistent(mmOsInsRap);

		
		// Salva a inspeção
		QqInsRap qqinsrap = new QqInsRap();
		qqinsrap.setIdInsRap(null);
		qqinsrap.setCdInspecao(mmos.getCdOs());
		qqinsrap.setRevisao(1l);
		qqinsrap.setDsInspecao(mmos.getDsOs());
		qqinsrap.setDtRevisao(dthrAtual);
		qqinsrap.setDtStativo(dthrAtual);
		qqinsrap.setDwRap(dwrap);
		qqinsrap.setMmOsInsRap(mmOsInsRap);
		qqinsrap.setOmUsrByIdUsrrevisao(omusr);
		qqinsrap.setOmUsrByIdUsrstativo(omusr);
		qqinsrap.setStAtivo((byte)1);

		qqinsrap.setQqInsrapFts(new HashSet<QqInsrapFt>());

		boolean isInspecaoConforme = true;
		
		for (QqFolhaInsAtivDTO ativ : local.getFolhains().getAtividades()) {
			for (QqFolhainsftDTO ft : ativ.getQqFolhainsfts()) {
				QqInsrapFt rapft = new QqInsrapFt();
				
				// Pesquisa qqfolhainsft
				QqFolhainsft qqfolhainsft = getDao().findById(QqFolhainsft.class, ft.getIdFolhainsft(), false);
				
				rapft.setQqFolhainsft(qqfolhainsft);
				rapft.setQqInsRap(qqinsrap);
				rapft.setIdInsrapft(null);
				rapft.setStMedido((byte)(ft.getSt()) );
				rapft.setVlMedido(new BigDecimal(ft.getValor()) );
				
				qqinsrap.getQqInsrapFts().add(rapft);
				
				
				// Avalia se o resultado foi conforme ou nao conforme
				if (ft.getIsMinimo() && (ft.getValor() < ft.getMinimo()) )
					isInspecaoConforme = false;
				if (ft.getIsMeta() && (ft.getValor() != ft.getMeta()) )
					isInspecaoConforme = false;
				if (ft.getIsMaximo() && (ft.getValor() > ft.getMaximo()) )
					isInspecaoConforme = false;
				if (ft.getIsCombo() && ft.getSt() != ft.getStEsperado())
					isInspecaoConforme = false;
			}
		}

		// Determina se a inspecao foi conforme ou nao conforme
		if (isInspecaoConforme)
			qqinsrap.setStInspecao(QqInsRapTemplate._ST_INSPECAO._CONFORME.getValue());
		else
			qqinsrap.setStInspecao(QqInsRapTemplate._ST_INSPECAO._NAO_CONFORME.getValue());
			
		getDao().makePersistent(qqinsrap);
		
		QqInsRapDTO retorno = new QqInsRapDTO();
		retorno.setCdInspecao(qqinsrap.getCdInspecao());
		retorno.setStInspecao(qqinsrap.getStInspecao());
		return retorno;
	}

}










