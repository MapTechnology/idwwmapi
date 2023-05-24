package idw.model.rn.roteiroinspecao;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmProdutoDAO;
import idw.model.dao.OmUsrgrpDAO;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwTpest;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.model.pojos.OmUsrgrp;
import idw.model.pojos.QqFolhaInsRap;
import idw.model.pojos.QqRoteiro;
import idw.model.pojos.QqRoteiroMov;
import idw.model.pojos.QqRoteiroPre;
import idw.model.pojos.QqRoteiroUsr;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.UsuarioRN;
import idw.model.rn.estoque.EstoqueRN;
import idw.model.rn.folhainspecaorap.FolhaInspecaoRapRN;

public class RoteiroInspecaoRN extends AbstractRN<DAOGenerico>{
	
	public RoteiroInspecaoRN() {
		super (new DAOGenerico());
	}

	public RoteiroInspecaoRN(DAOGenerico dao) {
		super(dao);
	}
	
	public RoteirosInspecaoDTO pesquisarRoteiroInspecao(RoteiroInspecaoDTO filtro) {
		RoteirosInspecaoDTO retorno = new RoteirosInspecaoDTO();
		MapQuery q = new MapQuery(getDaoSession());

		createHql(q, filtro);
		q.configuraSelectCount("select a");
		defineParametros(q, filtro);
		
		Integer totalRegistro = q.selectCount("select a");

		
		if (filtro.getQtRegistroPorPagina()==null||filtro.getPagina()==null||filtro.getQtRegistroPorPagina()==0||filtro.getPagina()==0) {
			retorno.setTitle("Não foi definido um número de registros ou um número de página.");

		}else{			// Obtem os registros das pequisas conforma a pagina e quant total por pagina
			q.novaConsulta();
			createHql(q, filtro);
			defineParametros(q, filtro);

			q.query().setFirstResult( (filtro.getPagina()-1) * filtro.getQtRegistroPorPagina());
			q.setMaxResults(filtro.getQtRegistroPorPagina());

			List<QqRoteiro> lista = q.list();

			retorno.setPagina(filtro.getPagina());
			retorno.setTotalPaginas(totalRegistro/filtro.getQtRegistroPorPagina());
			double resto = totalRegistro % filtro.getQtRegistroPorPagina();
			if ( resto > 0 )
				retorno.setTotalPaginas(retorno.getTotalPaginas() + 1);

			// Clona retorno
			retorno.setRoteiros(new ArrayList<RoteiroInspecaoDTO>());
			for (QqRoteiro roteiro : lista) {
				RoteiroInspecaoDTO dto = new RoteiroInspecaoDTO();
				if (lista.size() == 1)
					dto.setRoteiro(roteiro.clone());
				else
					dto.setRoteiro(roteiro.clone(false));
				
				retorno.getRoteiros().add(dto);
			// Se nenhum registro encontrado, passar mensagem
			}
			if (lista.isEmpty()) {
				retorno.setTitle("Nenhum roteiro de inspeção encontrado");
			}
		}

		return retorno;
	}


	private void createHql(MapQuery q, RoteiroInspecaoDTO filtro) {
		q.append("select a");
		q.append("from QqRoteiroInspecao a");

		if (filtro.getRoteiro() != null) {
			q.appendWhere(MapQuery._NULL, "a.stAtivo = :stativo", filtro.getRoteiro().getStAtivo() != null);
			q.appendWhere(MapQuery._AND, "a.cdRoteiro like :cd", filtro.getRoteiro().getCdRoteiro() != null && filtro.getRoteiro().getCdRoteiro().equals("") == false);
			q.appendWhere(MapQuery._AND, "a.dsRoteiro like :ds", filtro.getRoteiro().getDsRoteiro() != null && filtro.getRoteiro().getDsRoteiro().equals("") == false);
			q.appendWhere(MapQuery._AND, "a.omProduto.cdProduto like :cdproduto", filtro.getRoteiro().getOmProduto() != null && filtro.getRoteiro().getOmProduto().getCdProduto() != null && filtro.getRoteiro().getOmProduto().getCdProduto().equals("") == false);
			q.appendWhere(MapQuery._AND, "a.idRoteiro = :id", filtro.getRoteiro().getIdRoteiro() > 0);
		}
	}
	
	private void defineParametros(MapQuery q, RoteiroInspecaoDTO filtro) {
		// Definir os parametros
		if (filtro.getRoteiro() != null) {
			q.defineParametro("id", filtro.getRoteiro().getIdRoteiro());
			q.defineParametro("stativo", filtro.getRoteiro().getStAtivo());
			q.defineParametro("cdfolhainsrap", filtro.getRoteiro().getCdRoteiro());
			q.defineParametro("dsfolhainsrap", filtro.getRoteiro().getDsRoteiro());
			if (filtro.getRoteiro().getOmProduto() != null)
				q.defineParametro("cdproduto", filtro.getRoteiro().getOmProduto().getCdProduto());
		}
	}
	
	
	
	public RoteirosInspecaoDTO pesquisarRoteiroInspecaoById(Long id) {
		RoteirosInspecaoDTO retorno = new RoteirosInspecaoDTO();

		MapQuery q = new MapQuery(getDaoSession());

		RoteiroInspecaoDTO filtro = new RoteiroInspecaoDTO();
		QqRoteiro pojo = new QqRoteiro();
		pojo.setIdRoteiro(id);
		filtro.setRoteiro(pojo);

		// Obtem a quantidade total de registro que a pesquisa retornara
		createHql(q, filtro);
		defineParametros(q, filtro);

		q.setMaxResults(1);

		QqRoteiro roteiro = (QqRoteiro) q.uniqueResult();

		retorno.setPagina(1);
		retorno.setTotalPaginas(1);

		// Clona retorno
		retorno.setRoteiros(new ArrayList<RoteiroInspecaoDTO>());
		if (roteiro != null) {
			RoteiroInspecaoDTO dto = new RoteiroInspecaoDTO();
			dto.setRoteiro(roteiro.clone());
			retorno.getRoteiros().add(dto);
		} else {
			// Se nenhum registro encontrado, passar mensagem
			retorno.setTitle("Nenhum roteiro inspeção encontrado");
		}

		return retorno;

	}
	

	
	public QqRoteiro pesquisarRoteiroInspecaoByCd(String cd) {
		MapQuery q = new MapQuery(getDaoSession());

		RoteiroInspecaoDTO filtro = new RoteiroInspecaoDTO();
		QqRoteiro pojo = new QqRoteiro();
		pojo.setCdRoteiro(cd);
		pojo.setStAtivo((byte)1);
		filtro.setRoteiro(pojo);

		// Obtem a quantidade total de registro que a pesquisa retornara
		createHql(q, filtro);
		defineParametros(q, filtro);

		q.setMaxResults(1);

		QqRoteiro roteiro = (QqRoteiro) q.uniqueResult();

		return roteiro;

	}

	
	public RoteirosInspecaoDTO salvarRoteiroInspecao(RoteiroInspecaoDTO salvar) {
		RoteirosInspecaoDTO retorno = new RoteirosInspecaoDTO();
		retorno.setRoteiros(new ArrayList<RoteiroInspecaoDTO>());
		RoteiroInspecaoDTO roteirodto = new RoteiroInspecaoDTO();
		retorno.getRoteiros().add(roteirodto);

		if (isRoteiroValido(roteirodto, salvar)) {

			// Desativar registro antigo se for o caso
			if (salvar.getRoteiro().getIdRoteiro() != null) {
				RoteirosInspecaoDTO excluido = excluirRoteiroInspecao(salvar.getRoteiro().getIdRoteiro(), salvar.getRoteiro().getOmUsrByIdUsrrevisao().getIdUsr());

				// Limpa id para poder incluir novo
				salvar.getRoteiro().setIdRoteiro(null);
				salvar.getRoteiro().setRevisao(excluido.getRoteiros().get(0).getRoteiro().getRevisao() + 1);
				salvar.getRoteiro().setStAtivo((byte) 1);
				salvar.getRoteiro().setDtRevisao(DataHoraRN.getDataHoraAtual());
				salvar.getRoteiro().setDtStativo(DataHoraRN.getDataHoraAtual());
			} else {
				salvar.getRoteiro().setRevisao(1l);
				salvar.getRoteiro().setStAtivo((byte) 1);
				salvar.getRoteiro().setDtRevisao(DataHoraRN.getDataHoraAtual());
				salvar.getRoteiro().setDtStativo(DataHoraRN.getDataHoraAtual());
			}


			// Incluir um novo registro com nova revisao
			getDao().makePersistent(salvar.getRoteiro());
		
			RoteiroInspecaoDTO dto = new RoteiroInspecaoDTO();
			dto.setRoteiro(dto.getRoteiro().clone());
			retorno.getRoteiros().add(dto);

			// Finaliza
			retorno.setStatus("200");
			retorno.setTitle("Roteiro inspeção salvo com sucesso");
		} else {
			retorno.setStatus("400");
			retorno.setTitle(roteirodto.getTitle());
		}

		return retorno;
	}

	
	// Valida os valores recebidos em salvar
	private boolean isRoteiroValido(RoteiroInspecaoDTO retorno, RoteiroInspecaoDTO salvar) {
		// Avalia se algum campo obrigatorio esta vazio
		if (isRoteiroAlgumCampoVazio(retorno, salvar.getRoteiro())) {
			return false;
		}

		// Avalia se alguma FK é desconhecida
		if (isRoteiroAlgumaFKDesconhecida(retorno, salvar.getRoteiro())) {
			return false;
		}

		// Avalia se alguma integridade referencial
		if (isRoteiroIntegro(retorno, salvar.getRoteiro()) == false) {
			return false;
		}

		return true;
	}


	private boolean isRoteiroAlgumCampoVazio(RoteiroInspecaoDTO retorno, QqRoteiro salvar) {
		boolean isretorno = false;
		// Se o codigo da folha estiver vazio
		if (salvar.getCdRoteiro().isEmpty()) {
			retorno.setTitle("Cd.Roteiro inspeção vazio");
		} else if (salvar.getDsRoteiro().isEmpty()) {
			retorno.setTitle("Descrição Roteiro inspeção vazia");
		} else if (salvar.getOmProduto() == null || salvar.getOmProduto().getCdProduto().isEmpty()) {
			retorno.setTitle("Cd.Produto vazio");
		}
		return isretorno;
	}


	// Metodo para avaliar se as FKs existem
	private boolean isRoteiroAlgumaFKDesconhecida(RoteiroInspecaoDTO retorno, QqRoteiro salvar) {
		boolean isretorno = false;
		UsuarioRN rnu = new UsuarioRN(getDao());
		OmUsrgrpDAO grn = new OmUsrgrpDAO(getDaoSession());
		
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


		// Avaliar as FKs das movimentacoes
		EstoqueRN ern = new EstoqueRN(getDao());
		FolhaInspecaoRapRN frn = new FolhaInspecaoRapRN(getDao());
		for (QqRoteiroMov mov : salvar.getQqRoteiroMovs()) {
			mov.setQqRoteiro(salvar);
			
			// avaliar tipo de estoques
			if (mov.getDwTpestentrada() != null && mov.getDwTpestentrada().getCdTpest().equals("") == false) {
				DwTpest dwtpestEntrada = ern.pesquisarTiposEstoqueByCd(mov.getDwTpestentrada().getCdTpest());
				mov.setDwTpestentrada(dwtpestEntrada);
				if (dwtpestEntrada == null) {
					retorno.setTitle("Tipo estoque entrada desconhecido");
					isretorno = true;
				}
			} else {
				mov.setDwTpestentrada(null);
			}
			if (mov.getDwTpestsaida() != null && mov.getDwTpestsaida().getCdTpest().equals("") == false) {
				DwTpest dwtpestSaida = ern.pesquisarTiposEstoqueByCd(mov.getDwTpestsaida().getCdTpest());
				mov.setDwTpestentrada(dwtpestSaida);
				if (dwtpestSaida == null) {
					retorno.setTitle("Tipo estoque saida desconhecido");
					isretorno = true;
				}
			} else {
				mov.setDwTpestsaida(null);
			}

			// avaliar estoque
			if (mov.getDwEstentrada() != null && mov.getDwEstentrada().getCdEst().equals("") == false) {
				DwEst dwest = ern.pesquisarDwEstEStAtivoByCd(mov.getDwEstentrada().getCdEst());
				mov.setDwEstentrada(dwest);
				if (dwest == null) {
					retorno.setTitle("Estoque entrada desconhecido");
					isretorno = true;
				}
			} else {
				mov.setDwEstentrada(null);
			}
			if (mov.getDwEstsaida() != null && mov.getDwEstsaida().getCdEst().equals("") == false) {
				DwEst dwest = ern.pesquisarDwEstEStAtivoByCd(mov.getDwEstsaida().getCdEst());
				mov.setDwEstsaida(dwest);
				if (dwest == null) {
					retorno.setTitle("Estoque saida desconhecido");
					isretorno = true;
				}
			} else {
				mov.setDwEstsaida(null);
			}

			// avaliar folha inspecao
			if (mov.getQqFolhainsrap() != null && mov.getQqFolhainsrap().getCdFolhainsrap().equals("") == false) {
				QqFolhaInsRap folha = frn.pesquisarFolhaInspecaoRAPByCd(mov.getQqFolhainsrap().getCdFolhainsrap());
				if (folha == null) {
					retorno.setTitle("Folha inspeção é obrigatória");
					isretorno = true;
				} else {
					mov.setQqFolhainsrap(folha);
				}
			} else {
				retorno.setTitle("Folha inspeção é obrigatória");
				isretorno = true;
			}
			
			// Avaliar predecessoras
			for (QqRoteiroPre pre : mov.getQqRoteiroPres()) {
				pre.setQqRoteiroMov(mov);

				// Avaliar como verificar um filho que ainda nao existe no banco mas está nessa relacao
			}
			
			
			
			// avaliar usuarios e grupos
			for (QqRoteiroUsr usr : mov.getQqRoteiroUsrs()) {
				usr.setQqRoteiroMov(mov);
				
				// avaliar se foi passado um usuario ou um grupo de usuario
				if (usr.getOmusr() == null && usr.getOmusrgrp() == null) {
					retorno.setTitle("Informar um usuário ou grupo de usuário");
					isretorno = true;
				}
				
				// Avaliar usuario
				if (usr.getOmusr() != null && usr.getOmusr().getCdUsr().equals("") == false) {
					OmUsr omusr = rnu.getOmUsrByLoginStAtivo(usr.getOmusr().getCdUsr());
					usr.setOmusr(omusr);
					if (omusr == null) {
						retorno.setTitle("Usuário desconhecido");
						isretorno = true;
					}
				} else {
					usr.setOmusr(null);
				}
				
				// Avaliar grupo usuario
				if (usr.getOmusrgrp() != null && usr.getOmusrgrp().getCdUsrgrp().equals("") == false) {
					OmUsrgrp grp = grn.getOmUsrgrpPorCd(usr.getOmusrgrp().getCdUsrgrp());
					usr.setOmusrgrp(grp);
					if (grp == null) {
						retorno.setTitle("Grupo usuário desconhecido");
						isretorno = true;
					}
				} else {
					usr.setOmusrgrp(null);
				}
			}
			
		}

		return isretorno;
	}

	// Metodo para avaiar a integridade referencial
	private boolean isRoteiroIntegro(RoteiroInspecaoDTO retorno, QqRoteiro salvar) {
		boolean isretorno = true;

		// Verifica se o codigo da folha e revisao já existem, quando não for alteracao, mas sim inclusao
		if (salvar.getIdRoteiro() == null) {
			QqRoteiro roteiro = pesquisarRoteiroInspecaoByCd(salvar.getCdRoteiro());
			if (roteiro != null) {
				retorno.setTitle("Roteiroinspeção já cadastrado");
				isretorno = false;
			}
		}

		return isretorno;
	}

	
	
	public RoteirosInspecaoDTO excluirRoteiroInspecao(Long idRoteiro, Long idUsr) {
		RoteirosInspecaoDTO retorno = new RoteirosInspecaoDTO();

		MapQuery q = new MapQuery(getDaoSession());

		RoteiroInspecaoDTO filtro = new RoteiroInspecaoDTO();
		QqRoteiro pojo = new QqRoteiro();
		pojo.setIdRoteiro(idRoteiro);
		filtro.setRoteiro(pojo);


		// Obtem a quantidade total de registro que a pesquisa retornara
		createHql(q, filtro);
		defineParametros(q, filtro);

		q.setMaxResults(1);

		QqRoteiro roteiro = (QqRoteiro) q.uniqueResult();

		retorno.setPagina(1);
		retorno.setTotalPaginas(1);

		// Clona retorno
		retorno.setRoteiros(new ArrayList<RoteiroInspecaoDTO>());
		if (roteiro != null) {
			UsuarioRN rn = new UsuarioRN(getDao());
			// Procura usuario
			OmUsr omusr = rn.getOmUsr(idUsr);

			if (omusr != null) {
				// Excluir folha de inspecao
				roteiro.setDtStativo(DataHoraRN.getDataHoraAtual());
				roteiro.setStAtivo((byte) 0);
				roteiro.setOmUsrByIdUsrstativo(omusr);

				getDao().makePersistent(roteiro);
				retorno.setStatus("200");
				retorno.setTitle("Exclusão realizada com sucesso");
				RoteiroInspecaoDTO dto = new RoteiroInspecaoDTO();
				dto.setRoteiro(roteiro.clone());
				retorno.getRoteiros().add(dto);
			} else {
				retorno.setStatus("400");
				retorno.setTitle("Usuario desconhecido");
			}
		} else {
			retorno.setStatus("400");
			// Se nenhum registro encontrado, passar mensagem
			retorno.setTitle("Nenhum roteiro inspeção encontrado");
		}

		return retorno;

	}

}
