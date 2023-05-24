package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwEstmov;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRota;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.OmProcomest;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPropaihomo;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpneccron;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.PpNeccron;
import idw.model.pojos.PpPlano;
import idw.util.IdwLogger;
import idw.util.OrdenadorAcompanhamentos;
import idw.webservices.dto.DadosDiaPlanProdDTO;
import idw.webservices.dto.PlanoAcompanhamentoDTO;
import idw.webservices.dto.PlanoAcompanhamentoDTOList;
import idw.webservices.dto.PlanoDTO;

public class AcompanhamentoPlanejamentoRN implements IDao {

	protected DAOGenerico dao;
	private MapQuery qProducao;

	public AcompanhamentoPlanejamentoRN() {
		if (this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}

	public AcompanhamentoPlanejamentoRN(DAOGenerico dao) {
		this.dao = dao;
	}

	protected void inicializaQueryProducao() {
		qProducao = new MapQuery(this.dao.getSession());
		qProducao.append("select distinct dwconsolid");
		qProducao.append("from DwConsolid dwconsolid");
		qProducao.append("join fetch dwconsolid.dwConsols dwconsol");
		qProducao.append("join dwconsolid.dwFolha dwfolha");
		qProducao.append("join dwfolha.dwFolhaiacs dwfolhaiac");
		qProducao.appendWhere(MapQuery._NULL, "dwconsolid.ano = :ano", true);
		qProducao.appendWhere(MapQuery._AND, "dwconsolid.mes = :mes", true);
		qProducao.appendWhere(MapQuery._AND, "dwfolhaiac.omProduto = :omproduto", true);

	}

	public void iniciaConexaoBancoStatless() {
		this.dao.iniciaSessaoStateless();
		this.dao.iniciaTransacaoStateless();
	}

	public void finalizaConexaoBancoStatless() {
		this.dao.finalizaTransacaoStateless();
		this.dao.finalizaSessaoStateless();
	}

	/*
	 * Metodo principal para retorno dos dados a tela de monitorizacao do
	 * planejamento
	 */
	public PlanoAcompanhamentoDTOList capturarAcompanhamentos(PlanoAcompanhamentoDTO planoAcomp) {
		IdwLogger log = new IdwLogger("MonitorizacaoPP");
		int idLog = log.getIdAleatorio();
		int identacao = 0;

		PlanoDTO planoDTO = planoAcomp.getPlanoDTO();
		int dia = planoAcomp.getDiaReferencia();
		int mes = planoAcomp.getMesReferencia();
		int ano = planoAcomp.getAnoReferencia();

		List<PlanoAcompanhamentoDTO> listaTemp = null;
		List<PlanoAcompanhamentoDTO> listaRetorno = null;

		List<PpCp> listaCps = capturarPpCps(log, idLog, identacao, planoDTO,
				mes, ano);

		if ((listaCps != null) && (!listaCps.isEmpty())) {
			listaTemp = new ArrayList<PlanoAcompanhamentoDTO>();

			for (PpCp cp : listaCps) {

				PpCp ppCp = cp.clone(false);
				log.info(idLog, identacao, "CP " + ppCp.getCdCp());

				// pegar clones
				// ****************************************************

				if (cp.getPpCliente() != null) {
					ppCp.setPpCliente(cp.getPpCliente().clone(false));
				}

				if ((cp.getPpCpprodutos() != null)
						&& (!cp.getPpCpprodutos().isEmpty())) {
					ppCp.setPpCpprodutos(new HashSet<PpCpproduto>());
					for (PpCpproduto prod : cp.getPpCpprodutos()) {
						OmProduto produto = (OmProduto) prod.getOmProduto()
								.clone(false);

						log.info(idLog, identacao + 5,
								"Produto " + produto.getCdProduto());

						produto.setPpCliente(prod.getOmProduto().getPpCliente()
								.clone(false));
						PpCpproduto cpProduto = prod.clone(false);
						cpProduto.setOmProduto(produto);
						ppCp.getPpCpprodutos().add(cpProduto);
					}
				}

				if (cp.getDwFolha() != null) {
					ppCp.setDwFolha((DwFolha) cp.getDwFolha().clone(false));
				}

				if (cp.getDwRota() != null) {

					for (DwRotapasso rotaPasso : cp.getDwRota()
							.getDwRotapassos()) {
						rotaPasso.setDwRotapassoByIdRotapassosucessoNc(null);
						rotaPasso.setDwRotapassoPts(null);
						rotaPasso.setDwFolha((DwFolha) rotaPasso.getDwFolha()
								.clone(false));

						rotaPasso.setDwEst(null);
						rotaPasso.setDwEstConsumir(null);
						rotaPasso.setDwRotapassoByIdRotapassosucessoraC(null);
						rotaPasso.setDwRpPredecessorasForIdRotapassoFilho(null);
						rotaPasso.setDwRpPredecessorasForIdRotapassoPai(null);
						rotaPasso.setDwRotapassosForIdRotapassosucessoNc(null);
						rotaPasso.setDwRotapassosForIdRotapassosucessoraC(null);
					}

					ppCp.setDwRota((DwRota) cp.getDwRota().clone());
				}
				// *******************************************************************
				ppCp.setPpCpneccrons(new HashSet<PpCpneccron>());
				for (PpCpneccron cpneccron : cp.getPpCpneccrons()) {
					PpCpneccron ppCpNeccron = cpneccron.clone();
					try {
						// evitar o problema da sessao stateless
						cpneccron.getPpPlaneccron().getPpNeccron().getPpNec()
								.setPpNeccrons(null);
						cpneccron.getPpPlaneccron().getPpNeccron().getPpNec()
								.setPpPlanecs(null);
						// **************************************************************

						ppCpNeccron.getPpPlaneccron().setPpNeccron(
								cpneccron.getPpPlaneccron().getPpNeccron()
										.clone(false));
						ppCpNeccron
								.getPpPlaneccron()
								.getPpNeccron()
								.setPpNec(
										cpneccron.getPpPlaneccron()
												.getPpNeccron().getPpNec()
												.clone(false));
					} catch (NullPointerException r) {
						r.printStackTrace();
					}
					ppCp.getPpCpneccrons().add(ppCpNeccron);
				}
				PlanoAcompanhamentoDTO acomp = new PlanoAcompanhamentoDTO();
				acomp.setPlanoDTO(planoDTO);
				acomp.setPpcp(ppCp);
				acomp.setDiaReferencia(dia);
				acomp.setMesReferencia(mes);
				acomp.setAnoReferencia(ano);
				calcularValores(acomp);

				listaTemp.add(acomp);
			}

			// comentado temporariamente
			Collections.sort(listaTemp, new OrdenadorAcompanhamentos());

			// calcular a lista de Dias
			listaRetorno = new ArrayList<PlanoAcompanhamentoDTO>();
			for (PlanoAcompanhamentoDTO acomp : listaTemp) {
				if (!existeCombinacaoCntESemiproduto(listaRetorno, acomp)) {
					inicializarColunasDias(acomp);
					listaRetorno.add(acomp);
				}
			}
			// calcular valores dependentes da lista de Dias
			for (PlanoAcompanhamentoDTO acomp : listaRetorno) {
				calcularValoresRestantes(acomp);
			}
		}

		PlanoAcompanhamentoDTOList retorno = new PlanoAcompanhamentoDTOList(
				listaRetorno);

		// calcular indicadores de atraso
		Long total = 0L;
		Long atrasos = 0L;

		retorno.setIndiceAtraso(calcularIndiceAtraso(planoAcomp.getPlanoDTO()
				.getIdPlano(), atrasos, total));
		retorno.setIndiceAntecipacao(calcularIndiceAntecipacao(planoAcomp
				.getPlanoDTO().getIdPlano(), total));
		retorno.setMediaAtrasos(calcularMediaAtrasos(planoAcomp.getPlanoDTO()
				.getIdPlano(), atrasos));

		return retorno;
	}

	protected boolean existeCombinacaoCntESemiproduto(
			List<PlanoAcompanhamentoDTO> listaRetorno,
			PlanoAcompanhamentoDTO acomp) {

		for (PlanoAcompanhamentoDTO a : listaRetorno) {
			if ((a.getCnt().compareTo(acomp.getCnt()) == 0)
					&& (a.getSemiProduto().compareTo(acomp.getSemiProduto()) == 0)) {
				return true;
			}
		}

		return false;
	}

	protected void inicializarColunasDias(PlanoAcompanhamentoDTO acomp) {
		int mes = acomp.getMesReferencia();
		int ano = acomp.getAnoReferencia();

		acomp.setDias(new ArrayList<DadosDiaPlanProdDTO>());

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, mes);
		cal.set(Calendar.YEAR, ano);
		int maiorDia = cal.getMaximum(Calendar.DAY_OF_MONTH);

		OmProduto produto = null;
		for (PpCpproduto ppcpprod : acomp.getPpcp().getPpCpprodutos()) {
			produto = ppcpprod.getOmProduto();
		}

		MapQuery q = new MapQuery(this.dao.getSession());
		int i;
		Double somaCobertura = 0.0;
		for (i = 1; i <= maiorDia; i++) {
			cal.set(Calendar.DAY_OF_MONTH, i);
			Date inicio = DataHoraRN.setHoraNaData(cal.getTime(), 0, 0, 0, 0);
			Date fim = DataHoraRN.setHoraNaData(inicio, 23, 59, 59, 999);

			q.novaConsulta();
			q.append("select ppcp from PpCp ppcp");
			q.append("join fetch ppcp.ppCpprodutos ppcpprod");
			// alterado pq tava dando erro de query
			q.append("join fetch ppcp.ppCpneccrons cpneccron");
			q.append("join fetch cpneccron.ppPlaneccron  ppPlaneccron");
			// ***************************************
			q.append("join fetch ppPlaneccron.ppNeccron neccron");

			q.appendWhere(MapQuery._NULL, "ppcpprod.omProduto = :produto", true);
			q.appendWhere(MapQuery._AND,
					"neccron.dtDesejada between :inicio and :fim", true);
			// q.appendWhere(MapQuery._AND, "ppcp.ppCliente = :cliente", true);
			q.appendWhere(MapQuery._AND, "ppcp.stAtivo = 1", true);
			q.appendWhere(MapQuery._AND, "ppcp.ppPlano.idPlano = :plano", true);

			q.defineParametro("produto", produto);
			q.defineParametroTimestamp("inicio", inicio);
			q.defineParametroTimestamp("fim", fim);
			q.defineParametro("plano", acomp.getPlanoDTO().getIdPlano());
			// q.defineParametro("cliente", cliente);

			List<PpCp> lista = q.list();

			DadosDiaPlanProdDTO dadosDia = new DadosDiaPlanProdDTO();
			Double soma = 0.0;
			if ((lista != null) && (!lista.isEmpty())) {
				for (PpCp ppcp : lista) {
					for (PpCpneccron cpneccron : ppcp.getPpCpneccrons()) {
						PpNeccron neccron = cpneccron.getPpPlaneccron()
								.getPpNeccron();

						Calendar calendar = Calendar.getInstance();
						calendar.setTime(neccron.getDtDesejada());
						if ((calendar.get(Calendar.DAY_OF_MONTH) == cal
								.get(Calendar.DAY_OF_MONTH))
								&& (calendar.get(Calendar.MONTH) == cal
										.get(Calendar.MONTH))
								&& (calendar.get(Calendar.YEAR) == cal
										.get(Calendar.YEAR))) {
							soma += neccron.getQtDesejada().doubleValue();
						}
					}
				}
			}
			somaCobertura += soma;
			if ((acomp.getProduzidoMes() != null)
					&& (somaCobertura <= acomp.getProduzidoMes())) {
				dadosDia.setCoberto(true);
			} else {
				dadosDia.setCoberto(false);
			}
			dadosDia.setValorDia(soma);
			acomp.getDias().add(dadosDia);
		}
	}

	private void calcularValoresRestantes(PlanoAcompanhamentoDTO acomp) {
		// calcular Producao Total
		Double soma = 0.0;

		for (DadosDiaPlanProdDTO dadosDia : acomp.getDias()) {
			soma += dadosDia.getValorDia();
		}
		acomp.setProducaoTotal(soma);

		// calcular Falta Sobra
		acomp.setFaltaSobra(acomp.getProducaoTotal()
				- acomp.getKitTotal().doubleValue());

		// calcular soma planejada ate dia X
		soma = 0.0;
		int i;
		for (i = 1; i <= acomp.getDiaReferencia(); i++) {
			soma += acomp.getDias().get(i - 1).getValorDia();
		}
		acomp.setSomaPlanejada(soma); // parece que nao passa por aqui
	}

	private List<PpCp> capturarPpCps(IdwLogger log, int idLog, int identacao,
			PlanoDTO planoDTO, Integer mes, Integer ano) {
		MapQuery q = new MapQuery(this.dao.getSession()); // getSessionStateless());

		q.append("select distinct ppcp from PpCp ppcp");
		q.append("join fetch ppcp.ppPlano ppplano");
		q.append("join fetch ppcp.ppCpprodutos ppcpprod");
		q.append("join fetch ppcp.ppCliente ppcliente");
		q.append("join fetch ppcp.dwRota dwrota");

		q.append("join fetch ppcp.dwFolha dwfolha");
		q.append("join fetch dwrota.dwRotapassos rotapasso");
		q.append("join fetch rotapasso.dwFolha dwfolha");
		q.append("join fetch ppcp.ppCpneccrons cpneccron");
		q.append("join fetch cpneccron.ppPlaneccron planeccron");

		// adicionado para resolver o problema no stateless
		q.append("join fetch planeccron.ppNeccron ppNeccron");
		q.append("join fetch ppNeccron.ppNec ppNec");
		q.append("join fetch ppcpprod.omProduto omProduto");
		q.append("left join fetch omProduto.ppCliente ppcliente");

		// ------------------------------------------------
		q.appendWhere(
				MapQuery._NULL,
				"ppcp.ppPlano = :plano",
				((planoDTO != null) && (planoDTO.getIdPlano() != null) && (planoDTO
						.getIdPlano() > 0)));
		q.appendWhere(MapQuery._AND, "ppcp.stAtivo = 1", true);
		q.appendWhere(MapQuery._AND,
				"ppNeccron.dtDesejada between :inicio and :fim", true);

		q.append("order by dwrota.idRota, rotapasso.passo");

		PpPlano plano = new PpPlano();
		plano.setIdPlano(planoDTO.getIdPlano());
		q.defineParametro("plano", plano);
		Date inicio = DataHoraRN.getData(ano, mes + 1, 01);
		Date fim = DataHoraRN.getUltimoDiaDoMesDaData(inicio);
		fim = DataHoraRN.setHoraNaData(fim, 23, 59, 59, 999);

		q.defineParametro("inicio", inicio);
		q.defineParametro("fim", fim);

		List<PpCp> listaCps = q.list();

		return listaCps;
	}

	private void calcularValores(PlanoAcompanhamentoDTO acomp) {
		PpCp ppcp = acomp.getPpcp();
		OmProduto produto = null;

		int mes = acomp.getMesReferencia();
		int ano = acomp.getAnoReferencia();

		// calcular Qtde Producao Simulacao (campo editavel na GUI do cliente)
		acomp.setQtdeProducaoSimulacao(0);

		// calcular Disponivel produzir
		acomp.setDisponivelProduzir(0L);

		for (PpCpproduto prod : ppcp.getPpCpprodutos()) {
			produto = prod.getOmProduto();
			// calcular CNT
			acomp.setCnt(produto.getPpCliente().getCdCliente());

			acomp.setSemiProduto(produto.getCdProduto());
			acomp.setPlaca(produto.getDsCurta());
		}

		acomp.setPasso(ppcp.getPasso());

		if (acomp.getPasso() == null) {
			acomp.setPasso(BigDecimal.ZERO);
		}
		// calcular Saldo Mes Anterior
		BigDecimal saldoAnterior = calcularSaldoMesAnterior(produto, mes, ano);
		saldoAnterior = saldoAnterior.add(calcularSaldoMesAnteriorNosProdutos(
				produto, mes, ano));
		acomp.setSaldoAnterior(saldoAnterior);

		// calcular produzido no m�s
		acomp.setProduzidoMes(calcularProduzidoMes(produto, mes, ano));

		// calcular Kit Total
		acomp.setKitTotal(acomp.getSaldoAnterior().longValue()
				+ acomp.getProduzidoMes());
	}

	protected BigDecimal calcularSaldoMesAnterior(OmProduto produto,
			Integer mes, Integer ano) {
		BigDecimal retorno = BigDecimal.ZERO;

		if ((mes == null) || (ano == null) || (produto == null)) {
			return retorno;
		}

		MapQuery q = new MapQuery(this.dao.getSession());
		q.append("select dwestmov from DwEstmov dwestmov");
		q.append("join fetch dwestmov.dwEstpro dwestpro");

		q.appendWhere(MapQuery._NULL, "dwestmov.dthrMov between ? and ?", true);
		q.appendWhere(MapQuery._AND, "dwestpro.omProduto = :omproduto", true);
		q.appendWhere(MapQuery._AND, "dwestmov.lancamento = 'FINAL MES'", true);
		q.append("order by dwestmov.dthrMov desc");

		Date fim = DataHoraRN.getData(ano, mes, 1);
		fim = DataHoraRN.subtraiDiasDaData(fim, 1);
		Date inicio = DataHoraRN.getPrimeiroDiaDoMesDaData(fim);

		q.query().setDate(0, inicio);
		q.query().setDate(1, fim);

		//q.defineParametroData("fim", fim);
		q.defineParametro("omproduto", produto);

		q.setMaxResults(1);

		List<DwEstmov> lista = q.list();

		if ((lista != null) && (!lista.isEmpty())) {
			DwEstmov dw = lista.get(0);
			retorno = dw.getQtEntradaAnt().subtract(dw.getQtSaidaAnt());
			retorno = retorno.add(dw.getQtAjuste());
		}

		return retorno;
	}

	protected BigDecimal calcularSaldoMesAnteriorNosProdutos(OmProduto produto,
			Integer mes, Integer ano) {
		BigDecimal retorno = BigDecimal.ZERO;

		if ((mes == null) || (ano == null) || (produto == null)) {
			return retorno;
		}

		// Obtem o pai imediatamente superior
		MapQuery q = new MapQuery(this.dao.getSession());
		q.append("select omprocom from OmProcomest omprocom");
		q.append("join fetch omprocom.omProdutoByIdProduto omproduto");
		q.appendWhere(MapQuery._NULL,
				"omprocom.omProdutoByIdProdutomp = :produto", true);
		// alessandre: comentei pq talvez nao seja do tipo 3 e tanto faz
		// q.appendWhere(MapQuery._AND, "omproduto.tpProduto = 3", true);
		q.defineParametro("produto", produto);
		List<OmProcomest> lista = q.list();

		// Obtem todos os demais pais descartanto o pai imediatamente superior.
		// Isso exsite pq o pai siginificativo nem sempre eh o imediatamente
		// superior
		q.novaConsulta();
		q.append("select ompropaihomo");
		q.append("from OmPropaihomo ompropaihomo");
		q.append("where ompropaihomo.omProdutoByIdProduto = :produto");
		q.defineParametro("produto", produto);
		List<OmPropaihomo> listaHomo = q.list();

		Set<OmProduto> listaProdutos = new HashSet<OmProduto>();
		if ((lista != null) && (!lista.isEmpty())) {
			for (OmProcomest pojo : lista) {
				listaProdutos.add(pojo.getOmProdutoByIdProduto());
			}
		}
		if (listaHomo != null && listaHomo.isEmpty() == false) {
			for (OmPropaihomo pojo : listaHomo) {
				listaProdutos.add(pojo.getOmProdutoByIdProdutopai());
			}
		}

		// pega os saldos de todos os pais
		for (OmProduto pojo : listaProdutos) {
			retorno = retorno.add(calcularSaldoMesAnterior(pojo, mes, ano));
		}

		return retorno;
	}

	/*
	 * Alessandre: comentei o metodo abaixo para criar um novo em seguida. O
	 * metodo abaixo encontrava a produ��o baseando-se no saldo atual - o saldo
	 * do mes anterior, mas isso causava uma serie de problemas quando se
	 * importava a producao em momentos diferentes e em ordem diferentes
	 * deixandoo o saldo atual com problema. Assim, a producao ser� obtida em
	 * dwConsol
	 */
	// protected Long calcularProduzidoMes(OmProduto produto, Integer mes,
	// Integer ano) {
	// Long retorno = 0l;
	//
	// if ((mes == null) || (ano == null) || (produto == null)) {
	// return retorno;
	// }
	//
	// MapQuery q = new MapQuery(this.dao.getSession());
	// q.append("select dwestmov from DwEstmov dwestmov");
	// q.append("join fetch dwestmov.dwEstpro dwestpro");
	// q.appendWhere(MapQuery._NULL, "dwestmov.ano = :ano", true);
	// q.appendWhere(MapQuery._AND, "dwestmov.mes = :mes", true);
	// q.appendWhere(MapQuery._AND, "dwestpro.omProduto = :omproduto", true);
	// q.append("order by dwestmov.idEstmov desc");
	//
	// q.defineParametro("ano", ano);
	// q.defineParametro("mes", mes);
	// q.defineParametro("omproduto", produto);
	//
	// q.setMaxResults(1);
	//
	// List<DwEstmov> lista = q.list();
	//
	// if ((lista != null) && (!lista.isEmpty())) {
	// DwEstmov dw = lista.get(0);
	// retorno = dw.getQtEntradaAnt().longValue();
	// retorno -= dw.getQtSaidaAnt().longValue();
	// retorno += dw.getQtAjuste().longValue();
	// }
	//
	// return retorno;
	// }
	protected Long calcularProduzidoMes(OmProduto produto, Integer mes,
			Integer ano) {
		Long retorno = 0l;

		if ((mes == null) || (ano == null) || (produto == null)) {
			return retorno;
		}

		qProducao.defineParametro("ano", ano);
		qProducao.defineParametro("mes", mes);
		qProducao.defineParametro("omproduto", produto);

		List<DwConsolid> lista = qProducao.list();

		if ((lista != null) && (lista.isEmpty() == false)) {
			for (DwConsolid dwconsolid : lista) {
				for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
					if (dwconsol.getPcsManuProducaobruta() != null)
						retorno += dwconsol.getPcsManuProducaobruta().longValue();
				}
			}
		}

		return retorno;
	}

	/*
	 * Esse metodo foi criado para considerar que a producao de das cps firmadas
	 * serao consideradas. Nao eh o ideal. O correto seria se basear nessas CPs
	 * para se identificar onde a produ�ao ira iniciar.
	 */
	protected Long calcularASerProduzido(OmProduto produto) {
		MapQuery q = new MapQuery(dao.getSession());
		q.append("select ppcp");
		q.append("from PpCp ppcp");
		q.append("join ppcp.ppPlano ppplano");
		q.append("join ppcp.ppCpprodutos ppcpprodutos");
		q.append("where ppplano.stAtivo = 1 and ppplano.stPlano = 1"); // plano
																		// firmado
		q.append("and ? between ppcp.dthrInicio and ppcp.dthrFinal");
		q.append("and ppcpprodutos.omProduto = :omproduto");

		q.query()
				.setTimestamp(0, DataHoraRN.getDataHoraAtual());
		q.defineParametro("omproduto", produto);

		List<PpCp> lista = q.list();
		Long retorno = 0l;
		for (PpCp ppcp : lista) {
			for (PpCpproduto prod : ppcp.getPpCpprodutos()) {
				retorno += prod.getPcsProducaoplanejada().longValue();
			}
		}

		return retorno;
	}

	private Double calcularIndiceAtraso(Long idPlano, Long atrasos, Long total) {
		Double retorno = 0.0;

		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select count(*) from DwConsolid consolid");
		q.append("join consolid.ppCp ppcp");

		q.appendWhere(MapQuery._NULL,
				"ppcp.dthrInicio < consolid.dthrCadastro", true);
		q.appendWhere(MapQuery._AND, "ppcp.ppPlano = :plano",
				((idPlano != null) && (idPlano > 0)));

		PpPlano plano = new PpPlano();
		plano.setIdPlano(idPlano);
		q.defineParametro("plano", plano);

		atrasos = (Long) q.uniqueResult();

		q.novaConsulta();

		q.append("select count(*) from PpCp ppcp");

		q.appendWhere(MapQuery._NULL, "ppcp.ppPlano = :plano",
				((idPlano != null) && (idPlano > 0)));

		q.defineParametro("plano", plano);
		q.setMaxResults(1);

		total = (Long) q.uniqueResult();

		if ((atrasos != null) && (total != null) && (total != 0.0)) {
			retorno = (atrasos.doubleValue() / total.doubleValue()) * 100;
		}

		return retorno;
	}

	private Double calcularIndiceAntecipacao(Long idPlano, Long total) {
		Double retorno = 0.0;
		MapQuery q = new MapQuery(this.dao.getSession());
		q.append("select count(*) from DwConsolid consolid");
		q.append("join consolid.ppCp ppcp");
		q.appendWhere(MapQuery._NULL,
				"ppcp.dthrInicio > consolid.dthrCadastro", true);
		q.appendWhere(MapQuery._AND, "ppcp.ppPlano = :plano",
				((idPlano != null) && (idPlano > 0)));
		PpPlano plano = new PpPlano();
		plano.setIdPlano(idPlano);
		q.defineParametro("plano", plano);

		Long antecipacao = (Long) q.uniqueResult();

		if ((antecipacao != null) && (total != null) && (total != 0.0)) {
			retorno = (antecipacao.doubleValue() / total.doubleValue()) * 100;
		}

		return retorno;
	}

	private Double calcularMediaAtrasos(Long idPlano, Long atrasos) {
		Double retorno = 0.0;

		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select sum((consolid.dthrCadastro - ppcp.dthrInicio)*1440) from DwConsolid consolid");
		q.append("join consolid.ppCp ppcp");

		q.appendWhere(MapQuery._NULL,
				"ppcp.dthrInicio < consolid.dthrCadastro", true);
		q.appendWhere(MapQuery._AND, "ppcp.ppPlano = :plano",
				((idPlano != null) && (idPlano > 0)));

		PpPlano plano = new PpPlano();
		plano.setIdPlano(idPlano);
		q.defineParametro("plano", plano);

		Long tempoAtraso = (Long) q.uniqueResult();

		if ((atrasos != null) && (atrasos != 0.0) && (tempoAtraso != null)) {
			retorno = tempoAtraso.doubleValue() / atrasos.doubleValue();
		}
		return retorno;
	}

	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}
	@Override
	public void iniciaConexaoBanco(Session sessao) {
		this.dao.iniciaSessao();
		this.dao.iniciaTransacao();
	}

	@Override
	public void finalizaConexaoBanco() {
		this.dao.finalizaTransacao();
		this.dao.finalizaSessao();
	}

}
