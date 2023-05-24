package idw.model.rn.impprog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.ImportacaoProgramaFalhouException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCategoriaException;
import idw.model.excessoes.SemConfiguracaoException;
import idw.model.excessoes.SemFeedersException;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPrg;
import idw.model.pojos.OmPrgpos;
import idw.model.pojos.OmPrgposproalt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.PTRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.ProgramaInsersoraRN;
import idw.model.rn.alimentacao.MapaAlimentacaoRN;
import idw.util.ArquivosDiretorios;
import idw.util.Util;
import idw.webservices.dto.ComponenteDeParaDTO;
import idw.webservices.dto.ComponentesDeParaDTO;
import idw.webservices.dto.ProgramaInsersoraDTO;
import idw.webservices.dto.ProgramasInsersorasDTO;
import ms.util.UtilsThreads;

public class ImportaProgramaRN extends DAOGenerico {

	public void importaProgramasInsersoras() {
		// Obtem a lista de maquinas insersoras que tenham a url de conexao definida
		PTRN ptrn = new PTRN(getDao());

		List<OmPt> ompts = null;
		ompts = ptrn.pesquisarTodosPtStAtivo();

		OmCfg omcfg = Util.getConfigGeral(getDao().getSession());

		Validate.notNull(omcfg, "Sem configuracao geral do sistema");
		Validate.notNull(omcfg.getOmEmpresa(), "Sem empresa definida na configuracao geral");

		if (ompts == null || ompts.isEmpty() == true)
			return;

		// Interage sobre cada maquina
		for (OmPt ompt : ompts) {
			// Obtem o factory para o tipo de maquina insersora avaliada
			ImportaProgramaFactory importaProgramaFactory = ImportaProgramaFactory.instance(ompt.getTpImpprog());

			if (importaProgramaFactory == null)
				continue;

			IImportaProgramaRN rn = importaProgramaFactory.getImportaProgramaRN(omcfg.getOmEmpresa());

			// Obtem a lista de programas ativos para a maquina avaliada
			ProgramasInsersorasDTO programas = null;

			if (rn != null) {
				rn.inicializacao();
				programas = rn.getProgramasInsersorasDTO(ompt);
			}

			if (programas == null || programas.getProgramasInsersorasDTO() == null) {
				if (rn != null)
					rn.finalizacao();
				continue;
			}

			// Interage sobre cada programa ativo
			for (ProgramaInsersoraDTO programa : programas.getProgramasInsersorasDTO()) {
				// Verifica se houve mudanca no programa, se nao, passar para o proximo programa
				OmPrg omprg = null;
				try {
					omprg = pesquisarOmprg(programa, ompt);
					if (DataHoraRN.equals(omprg.getDtRevisao(), programa.getOmprg().getDtRevisao()))
						continue;

					// Salva a data de revisao do programa para copia-la ao programa completo.
					// que sera usada para salvar o programa alterado.
					programa.setDthrRevisao(programa.getOmprg().getDtRevisao());

				} catch (RegistroDesconhecidoException e) {
					omprg = programa.getOmprg();
				}

				// Obtem o programa completo que esta sendo avaliado
				programa.setOmpt(ompt);
				programa.setOmprg(omprg);

				ProgramaInsersoraDTO programaCompleto = rn.getProgramaInsersoraDTO(programa);
				programaCompleto.setDthrRevisao(programa.getDthrRevisao());

				// Verifica se o programa obtido esta diferente do programa gravado
				salvaProgramaInsersora(omprg, programaCompleto, true);
				flushReiniciandoTransacao();
				UtilsThreads.pausaNaThread(2000);
			}
			rn.finalizacao();
		}
	}

	/*
	 * O programa soh sera retornado se tiver algum mapa ativo
	 */
	private OmPrg pesquisarOmprg(ProgramaInsersoraDTO programa, OmPt ompt) throws RegistroDesconhecidoException {
		MapQuery q = new MapQuery(getSession());

		q.append("select omprg");
		q.append("from OmPrg omprg ");
		q.append("join fetch omprg.omPt ompt ");
		q.append("join fetch omprg.omMapas ommapa");
		q.append("join fetch ommapa.omPt omptt");
		q.append("where ");
		q.append("omprg.cdPrg = :cdprg ");
		q.append("and omprg.stAtivo = 1");
		q.append("and ommapa.stAtivo = 1");
		q.append("and ompt.idPt = :idpt");
		q.append("and ompt = omptt");
		q.append("order by omprg.idPrg desc ");

		q.defineParametro("cdprg", programa.getOmprg().getCdPrg());
		q.defineParametro("idpt", ompt.getIdPt());
		q.setMaxResults(1);

		OmPrg retorno = (OmPrg) q.uniqueResult();

		if (retorno == null)
			throw new RegistroDesconhecidoException();

		return retorno;
	}

	public void salvaProgramaInsersora(OmPrg omprg, ProgramaInsersoraDTO programa, boolean isForcarImportacao) {
		// Salva o programa
		ProgramaInsersoraRN rnPrograma = new ProgramaInsersoraRN();
		rnPrograma.setSession(getSession());
		double cicloPadrao = programa.getCicloPadrao();
		programa = rnPrograma.setProgramaInsersoraDTO(programa, isForcarImportacao);

		// Salva uma folha de processo referente ao programa importado
		if (programa.getResultadoEvento() == programa.getEVENTO_BEM_SUCEDIDO()) {
			FolhaRN rn = new FolhaRN();
			rn.setDaoSession(getSession());
			programa.setCicloPadrao(cicloPadrao);
			rn.salvarFolhaAPartirDoPrograma(programa, isForcarImportacao);
		}

		// Salva o mapa de alimentacao somente se o programa foi atualizado
		if (programa.getResultadoEvento() == programa.getEVENTO_BEM_SUCEDIDO()) {
			MapaAlimentacaoRN rnMapa = new MapaAlimentacaoRN();
			rnMapa.setSession(getSession());
			rnMapa.setMapaAlimentacaoDTO(programa);
		}
	}

	private void importarAquivoBase(AProgramaSMD prg, boolean isForcarImportacao) throws ImportacaoProgramaFalhouException {

		// Obtem as maquinas relacionadas no conteudo
		// this.iniciaConexaoBanco(null);
		List<MaquinaSMDPanasonic> maquinas;
		try {
			maquinas = prg.obtemMaquinas();
		} catch (SemCategoriaException e1) {
			e1.printStackTrace();
			throw new ImportacaoProgramaFalhouException();
		}

		PTRN ptRN = new PTRN();
		ptRN.setDaoSession(getSession());

		ProgramaInsersoraRN prgRN = new ProgramaInsersoraRN();
		prgRN.setSession(getSession());

		ProdutoRN prodRN = new ProdutoRN();
		prodRN.setDaoSession(getSession());

		for (MaquinaSMDPanasonic maq : maquinas) {
			// Verifica se o programa que esta sendo importado eh mais recente que o
			// programa cadastrado para cada maquina. Se for mais recento ou nao existir o programa
			// entao importar. Se nao, passar para proxima maquina.
			List<OmPt> ompts = ptRN.pesquisarListaPtLikeDeParaPtStAtivo(maq.getNomeMaquina());
			Validate.notNull(ompts, "Pt " + maq.getNomeMaquina() + " desconhecido no programa " + prg.getPrograma());
			Validate.notEmpty(ompts, "Pt " + maq.getNomeMaquina() + " desconhecido no programa " + prg.getPrograma());
			for (OmPt ompt : ompts) {
				// Pesquisa programa

				OmPrg omprgAnterior = null;
				omprgAnterior = prgRN.pesquisarOmPrgByCdEPt(prg.getPrograma(), ompt.getIdPt());

				if (omprgAnterior != null) {
					try {
						if (isForcarImportacao == false && DataHoraRN.equals(prg.obtemDataHoraPrograma(), omprgAnterior.getDtRevisao())) {
							continue;
						}
					} catch (SemCategoriaException e) {
						throw new ImportacaoProgramaFalhouException();
					}
				}

				// Importa programa

				// Incluir omprg
				OmPrg omprg = new OmPrg();
				omprg.setCdPrg(prg.getPrograma());
				omprg.setDsPrg(prg.getPrograma());
				try {
					omprg.setDtRevisao(prg.obtemDataHoraPrograma());
				} catch (SemCategoriaException e1) {
					throw new ImportacaoProgramaFalhouException();
				}
				omprg.setDtStativo(DataHoraRN.getDataHoraAtual());
				omprg.setIdPrg(0);
				omprg.setOmPt(ompt);
				if (omprgAnterior == null)
					omprg.setRevisao(1l);
				else
					omprg.setRevisao(omprgAnterior.getRevisao() + 1);
				omprg.setStAtivo((byte) 1);

				// Obtem os feeders e componentes gerando o omprgpos
				Set<OmPrgpos> omprgposes = new HashSet<OmPrgpos>();
				List<ComponenteDeParaDTO> alternativoDePara = new ArrayList<ComponenteDeParaDTO>();
				List<MaquinaSMDFeeder> componentes;
				try {
					componentes = prg.obtemFeeders(maq);
				} catch (SemFeedersException e) {
					throw new ImportacaoProgramaFalhouException();
				}

				for (MaquinaSMDFeeder componente : componentes) {
					OmPrgpos omprgpos = new OmPrgpos();

					// Encontra omProduto
					OmProduto omproduto = new OmProduto();
					omproduto.setCdProduto(componente.getCdProduto());

					if (componente.getDescricao() != null && !(componente.getDescricao().equals("")))
						omproduto.setDsProduto(componente.getDescricao());

					omprgpos.setFeedertable("desconhecido");
					omprgpos.setFeedertrack(componente.getCdFeederDePara());
					omprgpos.setIdPrgpos(0);
					omprgpos.setName(componente.getCdFeederDePara());
					omprgpos.setOmPrg(omprg);
					omprgpos.setOmProduto(omproduto);
					omprgpos.setQtUsada(componente.getQuantidade());
					omprgpos.setPosicao(componente.getPosicao());
					omprgpos.setOmPrgposproalts(new HashSet<OmPrgposproalt>());
					omprgposes.add(omprgpos);

					// Luiz 26/04/2018 adiciona na lista componentesDePara caso o componente tenha um componente alternativo
					// Fabrício Valério 07/11/2018 - Adição de uma condição para a importação de programa Panasonic
					if (!(componente.getCdProdutoAlternativo() == null)) {
						if (!componente.getCdProdutoAlternativo().equals("") && componente.getCdProdutoAlternativo().length() > 0) {
							// Luiz 03/01/2019 trata casos em que existe mais de um alternativo separado por ", " ou "/ "
							if (componente.getCdProdutoAlternativo().contains(",")) {
								String campoInteiro = new String(componente.getCdProdutoAlternativo());
								campoInteiro = campoInteiro.replaceAll("\\s+", "");
								campoInteiro = campoInteiro.replaceAll(" ", "");
								String[] alternativos = campoInteiro.split(",");
								for (String codigoAlternativo : alternativos) {
									// Alessandre em 26-04-19 acrescentei o if abaixo para filtrar os componentes vazios
									// pois teve u caso com ,xxxxx
									if (codigoAlternativo.trim().equals(""))
										continue;

									/* Incluir no programa o alternativo */
									OmPrgposproalt proalt = new OmPrgposproalt();
									proalt.setIdPrgposproalt(null);
									proalt.setOmPrgpos(omprgpos);
									OmProduto omprodutoAux = new OmProduto();
									omprodutoAux.setCdProduto(codigoAlternativo);
									proalt.setOmProduto(omprodutoAux);
									omprgpos.getOmPrgposproalts().add(proalt);
									
									ComponenteDeParaDTO componenteAlternativo = new ComponenteDeParaDTO();
									componenteAlternativo.setComponente(componente.getCdProduto());
									componenteAlternativo.setFornecedor(codigoAlternativo);
									alternativoDePara.add(componenteAlternativo);
								}
							} else if (componente.getCdProdutoAlternativo().contains("/")) {
								String campoInteiro = new String(componente.getCdProdutoAlternativo());
								campoInteiro = campoInteiro.replaceAll("\\s+", "");
								campoInteiro = campoInteiro.replaceAll(" ", "");
								String[] alternativos = campoInteiro.split("/");
								for (String codigoAlternativo : alternativos) {
									
									/* Incluir no programa o alternativo */
									OmPrgposproalt proalt = new OmPrgposproalt();
									proalt.setIdPrgposproalt(null);
									proalt.setOmPrgpos(omprgpos);
									OmProduto omprodutoAux = new OmProduto();
									omprodutoAux.setCdProduto(codigoAlternativo);
									proalt.setOmProduto(omprodutoAux);
									omprgpos.getOmPrgposproalts().add(proalt);

									
									ComponenteDeParaDTO componenteAlternativo = new ComponenteDeParaDTO();
									componenteAlternativo.setComponente(componente.getCdProduto());
									componenteAlternativo.setFornecedor(codigoAlternativo);
									alternativoDePara.add(componenteAlternativo);
								}
							} else {
								/* Incluir no programa o alternativo */
								OmPrgposproalt proalt = new OmPrgposproalt();
								proalt.setIdPrgposproalt(null);
								proalt.setOmPrgpos(omprgpos);
								OmProduto omprodutoAux = new OmProduto();
								omprodutoAux.setCdProduto(componente.getCdProdutoAlternativo());
								proalt.setOmProduto(omprodutoAux);
								omprgpos.getOmPrgposproalts().add(proalt);

								ComponenteDeParaDTO componenteAlternativo = new ComponenteDeParaDTO();
								componenteAlternativo.setComponente(componente.getCdProduto());
								componenteAlternativo.setFornecedor(componente.getCdProdutoAlternativo());
								alternativoDePara.add(componenteAlternativo);
							}
						}
					}
				}

				ProgramaInsersoraDTO programa = new ProgramaInsersoraDTO();

				try {
					programa.setDthrRevisao(prg.obtemDataHoraPrograma());
				} catch (SemCategoriaException e) {
					throw new ImportacaoProgramaFalhouException();
				}
				programa.setOmprg(omprg);
				programa.setOmprgpos(omprgposes);
				programa.setOmpt(ompt);
				programa.setCicloPadrao(maq.getCicloPadrao());

				// Transfere o programa para o mapa de alimentacao
				salvaProgramaInsersora(omprg, programa, isForcarImportacao);

				// Luiz 26/04/2018 Caso exista algum componente alternativo na lista, então insere no banco
				if (alternativoDePara != null && alternativoDePara.size() > 0) {
					ComponentesDeParaDTO componentesDePara = new ComponentesDeParaDTO();
					componentesDePara.setComponentes(alternativoDePara);
					try {
						prodRN.importarComponentesDePara(componentesDePara);
					} catch (SemConfiguracaoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		ImportaProgramaRN rn = new ImportaProgramaRN();
		try {
			rn.iniciaConexaoBanco();
			String conteudo = null;
			try {
				conteudo = ArquivosDiretorios.lerArquivo("c:/alessandre/temporario/Report_HGU-ENCONET-MNC-N1-N2-V6-B20-2-BOT-L02.xml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				rn.importarArquivo("Report_HGU-ENCONET-MNC-N1-N2-V6-B20-2-BOT-L02.XML", conteudo, true);
			} catch (ImportacaoProgramaFalhouException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
	}

	public void importarArquivo(String arquivo, String conteudo, boolean isForcarImportacao) throws ImportacaoProgramaFalhouException {
		// Obtem o nome do programa
		AProgramaSMD prg = null;

		try {
			// Luiz - 20190326 - Metodo "removerComponentesAlterntivosXML" consume muito processamento nos casos em que o conteudo nao
			// precisa ser processado por este metodo
			// por isso implementei o "if" para desviar no caso do programa da SIEMENS
			if (!(arquivo.toUpperCase().contains("REPORT_") && arquivo.toUpperCase().contains(".XML"))) {
				conteudo = removerComponentesAlterntivosXML(conteudo);
			}
			prg = AProgramaSMD.getInstancia(arquivo, conteudo);
		} catch (SemCategoriaException e2) {
			throw new ImportacaoProgramaFalhouException();
		}

		importarAquivoBase(prg, isForcarImportacao);
		conteudo = null;
	}

	public void importarArquivo(String arquivo, byte[] conteudo, boolean isForcarImportacao) throws ImportacaoProgramaFalhouException {
		// Obtem o nome do programa
		AProgramaSMD prg = null;

		try {
			prg = AProgramaSMD.getInstancia(arquivo, conteudo);
		} catch (SemCategoriaException e2) {
			throw new ImportacaoProgramaFalhouException();
		}

		importarAquivoBase(prg, isForcarImportacao);
	}

	private String removerComponentesAlterntivosXML(String conteudo) {
		StringBuilder apoio = new StringBuilder();
		boolean isInicioTagUnit = false;
		HashMap<String, String> mapTagsParaAlterar = new HashMap<>();

		for (int i = 0; i < conteudo.length(); i++) {
			apoio.append(conteudo.charAt(i));

			if (!isInicioTagUnit) {
				if (apoio.indexOf("<Unit>") >= 0) {
					isInicioTagUnit = true;
				}
			} else {
				if (apoio.substring(apoio.length() - 12, i + 1).equals("</fsPartNum>")) {
					String tagComCdComponente = apoio.substring(apoio.lastIndexOf("<fsPartNum>"), i) + ">";
					String valorTag = tagComCdComponente.substring(tagComCdComponente.indexOf(">") + 1, tagComCdComponente.length() - 12);
					if (!valorTag.contains("fsPartNum")) {
						if (valorTag.contains("/")) {
							String cdComponente = valorTag.substring(0, valorTag.indexOf("/"));
							valorTag = "<fsPartNum>" + cdComponente + "</fsPartNum>";
						} else {
							String cdComponente = valorTag;
							valorTag = "<fsPartNum>" + cdComponente + "</fsPartNum>";
						}
						mapTagsParaAlterar.put(tagComCdComponente, valorTag);
					}
					tagComCdComponente = null;
					valorTag = null;
				}
			}
		}

		for (String tag : mapTagsParaAlterar.keySet()) {
			String tagAlterada = mapTagsParaAlterar.get(tag);

			String caractereEspecial = null;
			caractereEspecial = tag.contains("\\") ? "\\" : caractereEspecial;
			caractereEspecial = tag.contains("+") ? "+" : caractereEspecial;
			caractereEspecial = tag.contains("^") ? "^" : caractereEspecial;
			caractereEspecial = tag.contains("$") ? "$" : caractereEspecial;
			caractereEspecial = tag.contains("?") ? "?" : caractereEspecial;
			caractereEspecial = tag.contains("*") ? "*" : caractereEspecial;
			caractereEspecial = tag.contains("(") ? "(" : caractereEspecial;
			caractereEspecial = tag.contains(")") ? ")" : caractereEspecial;
			caractereEspecial = tag.contains("[") ? "[" : caractereEspecial;
			caractereEspecial = tag.contains("{") ? "{" : caractereEspecial;
			caractereEspecial = tag.contains("|") ? "|" : caractereEspecial;

			if (tag != null && caractereEspecial != null && tag.contains(caractereEspecial)) {
				int indexCaracterEspecial = tag.indexOf(caractereEspecial);
				StringBuilder builder = new StringBuilder(tag);
				builder.insert(indexCaracterEspecial, "\\");
				tag = builder.toString();
			}

			conteudo = conteudo.replaceAll(tag, tagAlterada);
		}
		apoio = null;
		return conteudo;
	}

}
