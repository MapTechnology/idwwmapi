package idw.model.rn.alimentacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;

import idw.model.dao.MapQuery;
import idw.model.pojos.OmAlim;
import idw.model.pojos.OmAlimrea;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.OmAlimreaTemplate;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.webservices.dto.MonitorizacaoAlimDTO;
import idw.webservices.dto.MonitorizacoesAlimsDTO;

public class MonitorizacaoAlimentacaoByReelRN extends MonitorizacaoAlimentacaoRN {

	/*
	 * O metodo abaixo foi substituido pelo moinitorizacaoRealimentacao, pois o atual metodo não estava retornando a necessidade de
	 * realimentar determinado posto. Ou seja, o PA que nao fosse realimentado e zerasse era removido do retorno
	 */
	@Deprecated
	public MonitorizacoesAlimsDTO monitorizacaoAlimentacao(String cdPt, boolean isMaisDeUmProduto, boolean isFiltrarGt) {
		MonitorizacoesAlimsDTO retorno = new MonitorizacoesAlimsDTO();
		List<MonitorizacaoAlimDTO> lista = new ArrayList<MonitorizacaoAlimDTO>();
		List<String> postos = new ArrayList<>();

		if (isFiltrarGt) {
			List<OmPt> ompts = getOmPtDoGt(cdPt);
			for (OmPt ompt : ompts) {
				postos.add(ompt.getCdPt());
			}
		} else {

			// Se o PT nao foi passado entao devemos pegar todos os pts
			if (cdPt.trim().equals("")) {
				List<OmPt> ompts = getOmPtComAlimentacao();
				for (OmPt ompt : ompts) {
					postos.add(ompt.getCdPt());
				}
			} else {
				postos.add(cdPt);
			}

		}

		/* Pesquisa as últimas alimentações dos Postos */
		for (String posto : postos) {
			OmAlim omalim = pesquisarUltimasAlimentacoes(posto);

			/* Interage sobre todas as alimentações encontradas, calculando previsao de termino */
			// for (OmAlim omalim : omalims) {
			for (OmAlimrea omalimrea : omalim.getOmAlimreas()) {

				// Se nao existe qtde alimentada, ignorar
				if (omalimrea.getQtAlimentada() == null || omalimrea.getQtAlimentada() <= 0)
					continue;

				// Se o feeder foi totalmente consumido entao nao apresentar
				if (omalimrea.getQtAtual() == null || omalimrea.getQtAtual().compareTo(BigDecimal.ZERO) <= 0)
					continue;

				MonitorizacaoAlimDTO dto = new MonitorizacaoAlimDTO();

				dto.setCdMapa(omalim.getOmMapa().getCdMapa());
				dto.setCdPa(omalimrea.getCbRap());
				dto.setCdProduto(omalimrea.getCdLido());
				dto.setCdPt(omalim.getOmMapa().getOmPt().getCdPt());

				// Encontra o ciclo padrao
				BigDecimal cicloPadrao = getCicloPadrao(omalim.getOmMapa().getOmPt());
				dto.setCicloPadrao(cicloPadrao.doubleValue());

				// Encontra a quantidade de ciclos restantes
				BigDecimal qtUsadaPorCiclo = ObjectUtils.defaultIfNull(omalimrea.getOmMapapa().getQtUsada(), BigDecimal.ONE);
				if (qtUsadaPorCiclo.intValue() == 0)
					qtUsadaPorCiclo = BigDecimal.ONE;
				long qtCicloRestante = calcularQtCiclosRestantes(omalimrea.getQtAtual(), qtUsadaPorCiclo);
				dto.setQtCicloRestante(qtCicloRestante);

				dto.setQtPorPlaca(qtUsadaPorCiclo);
				dto.setQtAlimentada(new BigDecimal(omalimrea.getQtAlimentada()));
				dto.setQtUsada(omalimrea.getQtUsada());

				// Encontra previsao de termino
				long previsaoTermino = calcularPrevisaoTermino(cicloPadrao, qtCicloRestante);
				dto.setPrevisaoTermino(previsaoTermino);

				// Encontra quantos produtos precisam ser fabricados
				long qtProduzidaPorCiclo = 1l; // getQtProduzidaPorCicloDoPt(mapCavAtivDoPt, omalim.getOmMapa().getOmPt().getCdPt());
				long produtosRestantes = calcularProdutosRestantes(qtCicloRestante, qtProduzidaPorCiclo);
				dto.setQtProdutoRestante(produtosRestantes);

				dto.setQtAtual(omalimrea.getQtAtual());

				lista.add(dto);
			}
			// }
		}

		Collections.sort(lista,
				new Comparator<MonitorizacaoAlimDTO>() {
					@Override
					public int compare(MonitorizacaoAlimDTO o1,
							MonitorizacaoAlimDTO o2) {
						return Long.compare(o1.getPrevisaoTermino(),
								o2.getPrevisaoTermino());

					}
				});

		retorno.setLista(lista);

		return retorno;
	}

	public OmAlim pesquisarUltimasAlimentacoes(String cdPt) {
		// List<OmAlim> retorno;

		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from OmAlim a");
		q.append("join fetch a.omMapa b");
		q.append("join fetch b.omPt ompt");
		q.append("join fetch a.omAlimreas c");
		q.append("join fetch c.omMapapa d");
		q.append("join fetch d.omProduto e");
		q.append("where a.tpAlim = 3");
		q.append("and a.stAlim = 1");
		q.append("and ompt.stAtivo = 1");
		q.append("and ompt.cdPt = :cd");
		q.append("order by a.idAlim desc");

		q.defineParametro("cd", cdPt);
		q.setMaxResults(1);

		return (OmAlim) q.uniqueResult();

	}

	private List<OmPt> getOmPtDoGt(String cdgt) {
		MapQuery q = new MapQuery(getDaoSession());

		q.append("select a");
		q.append("from OmPt a");
		q.append("join a.omGt b");
		q.append("where b.cdGt = :cd");
		q.append("and a.stAtivo = 1");

		q.defineParametro("cd", cdgt);
		return q.list();
	}

	public MonitorizacoesAlimsDTO monitorizacaoRealimentacao(String cdPt, boolean isMaisDeUmProduto, boolean isFiltrarGt) {
		IdwLogger log = new IdwLogger("monitorizacaoRealimentacao");
		int idLog = log.getIdAleatorio();
		int identacao = 0;

		log.iniciaAvaliacao("monitorizacaoRealimentacao");

		MonitorizacoesAlimsDTO retorno = new MonitorizacoesAlimsDTO();
		List<MonitorizacaoAlimDTO> lista = new ArrayList<MonitorizacaoAlimDTO>();
		List<String> postos = new ArrayList<>();

		if (isFiltrarGt) {
			List<OmPt> ompts = getOmPtDoGt(cdPt);
			for (OmPt ompt : ompts) {
				postos.add(ompt.getCdPt());
			}
		} else {

			// Se o PT nao foi passado entao devemos pegar todos os pts
			if (cdPt.trim().equals("")) {
				List<OmPt> ompts = getOmPtComAlimentacao();
				for (OmPt ompt : ompts) {
					postos.add(ompt.getCdPt());
				}
			} else {
				postos.add(cdPt);
			}

		}

		/* Pesquisa as últimas alimentações dos Postos */
		for (String posto : postos) {
			OmAlim omalim = pesquisarUltimasAlimentacoes(posto);

			if (omalim == null)
				continue; // ignora se o posto nao tem alimentacao

			/* Interage sobre todas as alimentações encontradas, calculando previsao de termino */
			// for (OmAlim omalim : omalims) {
			for (OmAlimrea omalimrea : omalim.getOmAlimreas()) {

				// Se foi uma alimentacao ou realimentacao errda, descartar
				if (omalimrea.getStLeitura().equals(OmAlimreaTemplate.StLeitura.FALHOU.getId()))
					continue;

				MonitorizacaoAlimDTO dto = new MonitorizacaoAlimDTO();

				dto.setCdMapa(omalim.getOmMapa().getCdMapa());
				dto.setCdPa(omalimrea.getCbRap());
				dto.setCdProduto(omalimrea.getOmMapapa().getOmProduto().getCdProduto()); // nao usar o cbLido pois pode ser alternativo e
																							// devemos apresentar apenas um item por feeder
				dto.setCdPt(omalim.getOmMapa().getOmPt().getCdPt());

				/*
				 * Verifica se o dto acima já foi adicionado a lista de retorno. Se foi entao usar o que ja foi anteriormente adicionado a
				 * lista
				 * 
				 */
				boolean isExiste = false;
				for (MonitorizacaoAlimDTO dtoAux : lista) {
					if (dtoAux.equals(dto)) {
						dto = dtoAux;
						isExiste = true;
						break;
					}
				}

				// Se existe entao nao eh necessario pegar novamente os dados abaixo
				if (isExiste == false) {

					// Encontra o ciclo padrao
					BigDecimal cicloPadrao = getCicloPadrao(omalim.getOmMapa().getOmPt());
					dto.setCicloPadrao(cicloPadrao.doubleValue());

					// Encontrar a qtde de comonentes usado por ciclo
					BigDecimal qtUsadaPorCiclo = ObjectUtils.defaultIfNull(omalimrea.getOmMapapa().getQtUsada(), BigDecimal.ONE);
					if (qtUsadaPorCiclo.intValue() == 0)
						qtUsadaPorCiclo = BigDecimal.ONE;

					dto.setQtPorPlaca(qtUsadaPorCiclo);
				}

				// Encontra a quantidade de ciclos restantes
				long qtCicloRestante = 0l;
				if (omalimrea.getQtAtual() != null)
					qtCicloRestante = calcularQtCiclosRestantes(omalimrea.getQtAtual(), dto.getQtPorPlaca() /* qtUsadaPorCiclo */);

				// Acumula com valores anteriores
				dto.setQtCicloRestante(dto.getQtCicloRestante() + qtCicloRestante);
				if (dto.getQtAlimentada() == null || dto.getQtAlimentada().compareTo(BigDecimal.ZERO) < 0)
					dto.setQtAlimentada(BigDecimal.ZERO);
				if (omalimrea.getQtAlimentada() != null)
					dto.setQtAlimentada(dto.getQtAlimentada().add(new BigDecimal(omalimrea.getQtAlimentada())));

				if (dto.getQtUsada() == null || dto.getQtUsada().compareTo(BigDecimal.ZERO) < 0)
					dto.setQtUsada(BigDecimal.ZERO);
				if (omalimrea.getQtUsada() != null)
					dto.setQtUsada(dto.getQtUsada().add(omalimrea.getQtUsada()));

				// Encontra previsao de termino
				long previsaoTermino =
						calcularPrevisaoTermino(new BigDecimal(dto.getCicloPadrao()) /* cicloPadrao */, dto.getQtCicloRestante());
//				if (previsaoTermino > 0l) {
//					System.out.println(dto.getCdPa() + " - " + previsaoTermino);
//				} else if (dto.getCdPa().equals("Z1005")) {
//					System.out.println("z1005 com " + dto.getPrevisaoTermino() + " ciclopadrao:" + dto.getCicloPadrao() + " qtCicRest: "
//							+ dto.getQtCicloRestante());
//				}
				dto.setPrevisaoTermino(previsaoTermino);

				// Encontra quantos produtos precisam ser fabricados
				long qtProduzidaPorCiclo = 1l; // TODO encontrar mais acima junto com o ciclo padrao
				long produtosRestantes = calcularProdutosRestantes(qtCicloRestante, qtProduzidaPorCiclo);
				dto.setQtProdutoRestante(produtosRestantes);

				if (dto.getQtAtual() == null || dto.getQtAtual().compareTo(BigDecimal.ZERO) < 0)
					dto.setQtAtual(BigDecimal.ZERO);
				if (omalimrea.getQtAtual() != null)
					dto.setQtAtual(dto.getQtAtual().add(omalimrea.getQtAtual()));

				if (isExiste == false)
					lista.add(dto);
			}
			// }
		}

		Collections.sort(lista,
				new Comparator<MonitorizacaoAlimDTO>() {
					@Override
					public int compare(MonitorizacaoAlimDTO o1, MonitorizacaoAlimDTO o2) {
						int retorno = Long.compare(o1.getPrevisaoTermino(), o2.getPrevisaoTermino());
						if (retorno == 0) {
							retorno = o1.getCdPa().compareTo(o2.getCdPa());
						}
						return retorno;
					}
				});

		retorno.setLista(lista);

		log.mostrarAvaliacaoCompleta(idLog, identacao);

		return retorno;
	}

	/*
	 * Metodo tem como objetivo retornar a alimentacao corrente dos posto ordenando pelo cdPa
	 * 
	 */
	public MonitorizacoesAlimsDTO monitorizacaoAlimentacao(String cdPt, String filtrar) {
		IdwLogger log = new IdwLogger("monitorizacaoAlimentacao");
		int idLog = log.getIdAleatorio();
		int identacao = 0;

		log.iniciaAvaliacao("monitorizacaoAlimentacao");

		MonitorizacoesAlimsDTO retorno = new MonitorizacoesAlimsDTO();
		List<MonitorizacaoAlimDTO> lista = new ArrayList<MonitorizacaoAlimDTO>();

		retorno.setCdPt(cdPt);
		
		OmAlim omalim = pesquisarUltimasAlimentacoes(cdPt);

		if (omalim != null) {
			
			retorno.setCdMapa(omalim.getOmMapa().getCdMapa());

			for (OmAlimrea omalimrea : omalim.getOmAlimreas()) {

				// Se foi uma alimentacao ou realimentacao errda, descartar
				if (omalimrea.getStLeitura().equals(OmAlimreaTemplate.StLeitura.FALHOU.getId()))
					continue;
				
				// Se um filtro foi definido, avalia-lo. Se falhar, descartar
				if (filtrar != null && filtrar.trim().compareTo("") != 0) {
					if (
							(omalimrea.getCbRap() == null || filtrar.contains(omalimrea.getCbRap()) == false ) &&
							(omalimrea.getCb() == null || filtrar.contains(omalimrea.getCb()) == false ) &&
							(omalimrea.getCbRap() == null || filtrar.contains(omalimrea.getCbRap()) == false ) &&
							
							(omalimrea.getCbRap() == null || omalimrea.getCbRap().contains(filtrar) == false) &&
							(omalimrea.getCb() == null || omalimrea.getCb().contains(filtrar) == false) &&
							(omalimrea.getCbRap() == null || omalimrea.getCbRap().contains(filtrar) == false)
							) {

								continue;
							}
				}

				MonitorizacaoAlimDTO dto = new MonitorizacaoAlimDTO();

				dto.setCdMapa(omalim.getOmMapa().getCdMapa());
				dto.setCdPa(omalimrea.getCbRap());
				dto.setCdProduto(omalimrea.getOmMapapa().getOmProduto().getCdProduto()); // nao usar o cbLido pois pode ser alternativo e
																							// devemos apresentar apenas um item por feeder
				dto.setCdPt(omalim.getOmMapa().getOmPt().getCdPt());

				// Encontra a ordem de acordo com o cadastro do PT
				
				dto.setOrdem(omalimrea.getOmMapapa().getOmPa().getOrdem());
				/*
				 * Verifica se o dto acima já foi adicionado a lista de retorno. Se foi entao usar o que ja foi anteriormente adicionado a
				 * lista
				 * 
				 */
				boolean isExiste = false;
				for (MonitorizacaoAlimDTO dtoAux : lista) {
					if (dtoAux.equals(dto)) {
						dto = dtoAux;
						isExiste = true;
						break;
					}
				}

				// Se existe entao nao eh necessario pegar novamente os dados abaixo
				if (isExiste == false) {

					// Encontra o ciclo padrao
					BigDecimal cicloPadrao = getCicloPadrao(omalim.getOmMapa().getOmPt());
					dto.setCicloPadrao(cicloPadrao.doubleValue());

					// Encontrar a qtde de comonentes usado por ciclo
					BigDecimal qtUsadaPorCiclo = ObjectUtils.defaultIfNull(omalimrea.getOmMapapa().getQtUsada(), BigDecimal.ONE);
					if (qtUsadaPorCiclo.intValue() == 0)
						qtUsadaPorCiclo = BigDecimal.ONE;

					dto.setQtPorPlaca(qtUsadaPorCiclo);
				}

				// Encontra a quantidade de ciclos restantes
				long qtCicloRestante = 0l;
				if (omalimrea.getQtAtual() != null)
					qtCicloRestante = calcularQtCiclosRestantes(omalimrea.getQtAtual(), dto.getQtPorPlaca() /* qtUsadaPorCiclo */);

				// Acumula com valores anteriores
				dto.setQtCicloRestante(dto.getQtCicloRestante() + qtCicloRestante);
				if (dto.getQtAlimentada() == null || dto.getQtAlimentada().compareTo(BigDecimal.ZERO) < 0)
					dto.setQtAlimentada(BigDecimal.ZERO);
				if (omalimrea.getQtAlimentada() != null)
					dto.setQtAlimentada(dto.getQtAlimentada().add(new BigDecimal(omalimrea.getQtAlimentada())));

				if (dto.getQtUsada() == null || dto.getQtUsada().compareTo(BigDecimal.ZERO) < 0)
					dto.setQtUsada(BigDecimal.ZERO);
				if (omalimrea.getQtUsada() != null)
					dto.setQtUsada(dto.getQtUsada().add(omalimrea.getQtUsada()));

				// Encontra previsao de termino
				long previsaoTermino = calcularPrevisaoTermino(new BigDecimal(dto.getCicloPadrao()) /* cicloPadrao */, dto.getQtCicloRestante());
				dto.setPrevisaoTermino(previsaoTermino);

				// Encontra quantos produtos precisam ser fabricados
				long qtProduzidaPorCiclo = 1l; // TODO encontrar mais acima junto com o ciclo padrao
				long produtosRestantes = calcularProdutosRestantes(qtCicloRestante, qtProduzidaPorCiclo);
				dto.setQtProdutoRestante(produtosRestantes);

				if (dto.getQtAtual() == null || dto.getQtAtual().compareTo(BigDecimal.ZERO) < 0)
					dto.setQtAtual(BigDecimal.ZERO);
				if (omalimrea.getQtAtual() != null)
					dto.setQtAtual(dto.getQtAtual().add(omalimrea.getQtAtual()));

				if (isExiste == false)
					lista.add(dto);
			}

		}
		
		// Ordena pelo ordem do PA
		Collections.sort(lista,
				new Comparator<MonitorizacaoAlimDTO>() {
					@Override
					public int compare(MonitorizacaoAlimDTO o1, MonitorizacaoAlimDTO o2) {
						int retorno = o1.getOrdem().compareTo(o2.getOrdem());
						return retorno;
					}
				});

		retorno.setLista(lista);

		log.mostrarAvaliacaoCompleta(idLog, identacao);

		return retorno;
	}

	
	
	
	
	/* Metodo chamado para obter o historico de alimentacao e realimentacao de determinado Pa do posto
	 * 
	 */
	public MonitorizacoesAlimsDTO historicoAlimentacao(String cdPt, String cdPa) {
		IdwLogger log = new IdwLogger("historicoAlimentacao");
		int idLog = log.getIdAleatorio();
		int identacao = 0;

		log.iniciaAvaliacao("historicoAlimentacao");

		MonitorizacoesAlimsDTO retorno = new MonitorizacoesAlimsDTO();
		List<MonitorizacaoAlimDTO> lista = new ArrayList<MonitorizacaoAlimDTO>();

		retorno.setCdPt(cdPt);
		
		OmAlim omalim = pesquisarUltimasAlimentacoes(cdPt);

		if (omalim != null) {
			
			retorno.setCdMapa(omalim.getOmMapa().getCdMapa());

			for (OmAlimrea omalimrea : omalim.getOmAlimreas()) {

				// Descartar outros PAs. Entretanto pegar tambem as leituras com falha
				if (omalimrea.getOmMapapa().getOmPa().getCdPa().equals(cdPa) == false)
					continue;

				MonitorizacaoAlimDTO dto = new MonitorizacaoAlimDTO();

				dto.setCdMapa(omalim.getOmMapa().getCdMapa());
				dto.setRevisao(omalim.getOmMapa().getRevisao().intValue());
				dto.setIdMapa(omalim.getOmMapa().getIdMapa());
				dto.setCdPa(omalimrea.getCbRap());
				dto.setCdProduto(omalimrea.getOmMapapa().getOmProduto().getCdProduto()); // nao usar o cbLido pois pode ser alternativo e
																							// devemos apresentar apenas um item por feeder
				dto.setCdPt(omalim.getOmMapa().getOmPt().getCdPt());

				dto.setSucesso(omalimrea.getStLeitura().equals(OmAlimreaTemplate.StLeitura.FALHOU.getId()) == false);
				dto.setTipoAlimentacao(omalimrea.getTpLeitura() - 1); // 1 - alimentacao 2-realimentacao transformar para 0-alimentacao 1-realimentacao
				dto.setDthrLeitura(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(omalimrea.getDthrLeitura()));
				dto.setAlimentador(omalimrea.getOmUsr().getDsApelido());
				dto.setCdProdutoLido(omalimrea.getCdLido());
				dto.setIdEmbalagem(omalimrea.getCb());

				// Encontra o ciclo padrao
				BigDecimal cicloPadrao = getCicloPadrao(omalim.getOmMapa().getOmPt());
				dto.setCicloPadrao(cicloPadrao.doubleValue());

				// Encontrar a qtde de comonentes usado por ciclo
				BigDecimal qtUsadaPorCiclo = ObjectUtils.defaultIfNull(omalimrea.getOmMapapa().getQtUsada(), BigDecimal.ONE);
				if (qtUsadaPorCiclo.intValue() == 0)
					qtUsadaPorCiclo = BigDecimal.ONE;

				dto.setQtPorPlaca(qtUsadaPorCiclo);

				// Encontra a quantidade de ciclos restantes
				long qtCicloRestante = 0l;
				if (omalimrea.getQtAtual() != null)
					qtCicloRestante = calcularQtCiclosRestantes(omalimrea.getQtAtual(), dto.getQtPorPlaca() /* qtUsadaPorCiclo */);

				// Acumula com valores anteriores
				dto.setQtCicloRestante(dto.getQtCicloRestante() + qtCicloRestante);
				if (dto.getQtAlimentada() == null || dto.getQtAlimentada().compareTo(BigDecimal.ZERO) < 0)
					dto.setQtAlimentada(BigDecimal.ZERO);
				if (omalimrea.getQtAlimentada() != null)
					dto.setQtAlimentada(dto.getQtAlimentada().add(new BigDecimal(omalimrea.getQtAlimentada())));

				if (dto.getQtUsada() == null || dto.getQtUsada().compareTo(BigDecimal.ZERO) < 0)
					dto.setQtUsada(BigDecimal.ZERO);
				if (omalimrea.getQtUsada() != null)
					dto.setQtUsada(dto.getQtUsada().add(omalimrea.getQtUsada()));

				// Encontra previsao de termino
				long previsaoTermino = calcularPrevisaoTermino(new BigDecimal(dto.getCicloPadrao()) /* cicloPadrao */, dto.getQtCicloRestante());
				dto.setPrevisaoTermino(previsaoTermino);

				// Encontra quantos produtos precisam ser fabricados
				long qtProduzidaPorCiclo = 1l; // TODO encontrar mais acima junto com o ciclo padrao
				long produtosRestantes = calcularProdutosRestantes(qtCicloRestante, qtProduzidaPorCiclo);
				dto.setQtProdutoRestante(produtosRestantes);

				if (dto.getQtAtual() == null || dto.getQtAtual().compareTo(BigDecimal.ZERO) < 0)
					dto.setQtAtual(BigDecimal.ZERO);
				if (omalimrea.getQtAtual() != null)
					dto.setQtAtual(dto.getQtAtual().add(omalimrea.getQtAtual()));

				lista.add(dto);

			}

		}
		
		// Ordena pelo PA
		Collections.sort(lista,
				new Comparator<MonitorizacaoAlimDTO>() {
					@Override
					public int compare(MonitorizacaoAlimDTO o1, MonitorizacaoAlimDTO o2) {
						int retorno = o1.getDthrLeitura().compareTo(o2.getDthrLeitura());
						return retorno * -1;
					}
				});

		retorno.setLista(lista);

		log.mostrarAvaliacaoCompleta(idLog, identacao);

		return retorno;
	}

}
