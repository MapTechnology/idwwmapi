package idw.model.rn;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.PpCliente;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.util.IdwLogger;
import idw.util.SQLUtils;
import idw.webservices.dto.FiltroRelatorioPlanejamentoRealizadoDTO;
import idw.webservices.dto.RelatorioPlanejamentoRealizadoDTO;
import ms.util.ConversaoTipos;

public class RelatorioPlanejamentoRealizadoRN extends AbstractRN<DAOGenerico> {

	public RelatorioPlanejamentoRealizadoRN() {
		this(null);
	}

	public RelatorioPlanejamentoRealizadoRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	/* Metodo principal para montar o relatorio */
 	public RelatorioPlanejamentoRealizadoDTO getRelatorioPlanejamentoRealizado(FiltroRelatorioPlanejamentoRealizadoDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioPlanejamentoRealizadoRN.getRelatorioPlanejamentoRealizado");
		log.info( idLog , 0, "RelatorioPlanejamentoRealizadoRN.getRelatorioPlanejamentoRealizado filtro usado:" + filtro.toString());

		List<Object> lista = consulta(filtro);
		List<Object> listaOPNC = consultaOPNaoConsolidado(filtro);
		
		RelatorioPlanejamentoRealizadoDTO retorno = montarEstruturaRelatorio(lista, filtro);
		
		retorno = montarEstruturaRelatorio(listaOPNC, filtro, retorno);
		
		ordernarLista(retorno.getItens());
		
		log.mostrarAvaliacaoCompleta();
		
		return retorno;
	}

	private List<Object> consulta(FiltroRelatorioPlanejamentoRealizadoDTO filtro) {

		//Marcos Sardinha: 2017-09-05 >> Defeito #4414 >> inclusao de colunas de apontamento manual (prod bruta) e refugo (auto e manual)
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT ");
		q.append("ppcpproduto.nrDoc, ");
		q.append("nec.cdNec, ");
		q.append("cliente.nmCliente, ");
		q.append("cp.stCp, ");
		q.append("cp.dthrFinal, ");
		q.append("rap.cdRap, ");
		q.append("prod.dsProduto, ");
		q.append("prod.cdProduto, ");
		q.append("prod.GPesoLiquido, ");
		q.append("ppcpproduto.pcsProducaoplanejada, ");
		q.append("consolpr.pcsAutoProducaobruta, ");
		q.append("consolpr.pcsManuProducaobruta, ");
		q.append("consolpr.pcsAutoProducaorefugada, ");
		q.append("consolpr.pcsManuProducaorefugada, ");		
		q.append("pt.cdPt, ");
		q.append("cliente2.nmCliente,");
		q.append("rap.id ");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwFolha folha");
		q.append("JOIN consolid.omPt pt");
		q.append("JOIN consolid.ppCp cp");
		q.append("JOIN consolid.dwConsols consol");
		q.append("JOIN consol.dwConsolprs consolpr");
		q.append("LEFT JOIN cp.ppPlano plano");
		q.append("LEFT JOIN cp.ppCliente cliente");
		q.append("LEFT JOIN cp.ppCpprodutos ppcpproduto");
		q.append("LEFT JOIN ppcpproduto.omProduto prod");
		q.append("LEFT JOIN cp.ppNec nec");
		q.append("LEFT JOIN cp.ppCliente cliente");
		q.append("LEFT JOIN folha.dwFolharaps folharap");
		q.append("LEFT JOIN folharap.dwRap rap");

		q.append("LEFT JOIN rap.ppCliente cliente2");

		q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
		q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta grupoferramenta");
		
		
		q.append("WHERE consolid.tpId = :tpid");
		q.append("AND (consolid.stAtivo IS NULL or consolid.stAtivo = 1)");

		
		
		
		
		
		q.append("AND (");
        q.append("(cp.dthrInicioreal <= :dtFim AND cp.dthrFinalreal IS NULL) OR");
        
        
        // Checa o inicio e fim real dentro do periodo
        q.append(SQLUtils.getSQLDentroPeriodo("cp.dthrInicioreal", "cp.dthrFinalreal", ":dtInicio", ":dtFim"));

        q.append("OR");

		// Checa Início e fim planejado dentro do período
		q.append(SQLUtils.getSQLDentroPeriodo("cp.dthrInicio", "cp.dthrFinal", ":dtInicio", ":dtFim"));
		q.append(")");
		

		if (filtro.getOmgt() != null) {
			q.append("and exists (from OmObj omobj join omobj.omGtByIdGt omgt where omgt.idGt = :idgt and omobj.omPt = consolid.omPt)");
			q.defineParametro("idgt", filtro.getOmgt().getIdGt());
		}

		if (filtro.getOmpt() != null) {
			q.append("AND pt.cdPt = :cdpt");
			q.defineParametro("cdpt", filtro.getOmpt().getCdPt());
		}


		if (filtro.getDwRap() != null) {
			q.append("AND rap.idRap = :idrap");
			q.defineParametro("idrap", filtro.getDwRap().getIdRap());
		}

		if (filtro.getDwGrupoFerramenta() != null) {
			q.append("AND grupoferramenta.idGrupoFerramenta = :idferramenta");
			q.defineParametro("idferramenta", filtro.getDwGrupoFerramenta()
					.getIdGrupoFerramenta());
		}

		q.defineParametro("tpid", (byte) DwConsolidTemplate.TpId.TURNO.getValue());

		q.defineParametroTimestamp("dtInicio", DataHoraRN.getDataSemHora(filtro.getPeriodoInicial()));
		q.defineParametroTimestamp("dtEmissao", DataHoraRN.getDataSemHora(filtro.getPeriodoEmissaoRelatorio()));
		q.defineParametroTimestamp("dtFim", DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));

		return q.list();
	}


	private List<Object> consultaOPNaoConsolidado(FiltroRelatorioPlanejamentoRealizadoDTO filtro) {

		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT ");

		q.append("ppcpproduto.nrDoc,");
		q.append("nec.cdNec,");
		q.append("cliente.nmCliente,");
		q.append("cp.stCp,");
		q.append("cp.dthrFinal, ");
		q.append("prod.dsProduto, ");
		q.append("prod.cdProduto, ");
		q.append("prod.GPesoLiquido,");
		q.append("ppcpproduto.pcsProducaoplanejada, ");
		q.append("rap.cdRap,");
		q.append("ompt.cdPt");

		q.append("FROM PpCp cp");
		q.append("JOIN cp.dwFolha folha");
		q.append("join cp.omPt ompt");

		q.append("LEFT JOIN cp.ppPlano plano");
		q.append("LEFT JOIN cp.ppCliente cliente");
		q.append("LEFT JOIN cp.ppCpprodutos ppcpproduto");
		q.append("LEFT JOIN ppcpproduto.omProduto prod");
		q.append("LEFT JOIN cp.ppNec nec");
		q.append("LEFT JOIN cp.ppCliente cliente");

		q.append("LEFT JOIN folha.dwFolharaps folharap");
		q.append("LEFT JOIN folharap.dwRap rap");

		q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
		q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta grupoferramenta");

		q.append("WHERE cp.stAtivo = :stAtivo");
		
	    // Checa Início e fim planejado dentro do período
		q.append("AND (");
        q.append(SQLUtils.getSQLDentroPeriodo("cp.dthrInicio", "cp.dthrFinal", ":dtInicio", ":dtFim"));
        q.append("    )");
        
		if (filtro.getOmpt() != null) {
			q.append("AND cp.omPt.idPt = :idpt");
			q.defineParametro("idpt", filtro.getOmpt().getIdPt());
		}
		if (filtro.getOmgt() != null) {
			q.append("and exists (from OmObj omobj where omobj.omGtByIdGt.idGt = :idgt and omobj.omPt = cp.omPt)");
			q.defineParametro("idgt", filtro.getOmgt().getIdGt());
		}
		if (filtro.getDwRap() != null) {
			q.append("AND rap.idRap = :idrap");
			q.defineParametro("idrap", filtro.getDwRap().getIdRap());
		}
		if (filtro.getDwGrupoFerramenta() != null) {
			q.append("AND grupoferramenta.idGrupoFerramenta = :idferramenta");
			q.defineParametro("idferramenta", filtro.getDwGrupoFerramenta()
					.getIdGrupoFerramenta());
		}
		q.defineParametro("stAtivo", (byte) 1);

		q.defineParametroTimestamp("dtInicio", DataHoraRN.getDataSemHora(filtro.getPeriodoInicial()));
		q.defineParametroTimestamp("dtFim", DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));

		return q.list();
	}

	private RelatorioPlanejamentoRealizadoDTO montarEstruturaRelatorio(
			List<Object> lista, FiltroRelatorioPlanejamentoRealizadoDTO filtro) {

		
		//Marcos Sardinha: 2017-09-05 >> Defeito #4414 >> inclusao de colunas de apontamento manual (prod bruta) e refugo (auto e manual)		
		int _op = 0;
		int _pedido = 1;
		int _cliente = 2;
		int _situacao = 3;
		int _dataPrevFim = 4;
		int _molde = 5;
		int _dsproduto = 6;
		int _cdproduto = 7;
		int _pesoLiquido = 8;
		int _plano = 9;		
		int _producaoBrutaAuto = 10;
		int _producaoBrutaManu = 11;
		int _producaoRefugadaAuto = 12;
		int _producaoRefugadaManu = 13;		
		int _maquina = 14;
		int _cliente2 = 15;

		RelatorioPlanejamentoRealizadoDTO retorno = new RelatorioPlanejamentoRealizadoDTO();
		retorno.setItens(new ArrayList<RelatorioPlanejamentoRealizadoDTO>());
		HashMap<String, RelatorioPlanejamentoRealizadoDTO> relatorio = new HashMap<>();
		for (Object obj : lista) {
			String chave = "";
			Object[] reg = (Object[]) obj;
			chave += reg[_op];
			chave += retornaPedido((String) reg[_pedido]);
			chave += retornaString((String) reg[_cliente]);
			chave += retornaSituacaoOp((int) reg[_situacao]);
			chave += retornaData((Date) reg[_dataPrevFim]);
			chave += reg[_molde];
			chave += reg[_dsproduto];
			chave += reg[_cdproduto];			
			chave += reg[_maquina];
			
			Double pesoLiquido = 0.0;// Apesar de estar nomeada de pesoLiquido
										// essa variável representa o Peso
			Double producaoPlano = 0.0;
			Double producaoBruta = 0.0;
			Double producaoRefugada = 0.0;
			pesoLiquido = verifica((BigDecimal) reg[_pesoLiquido]);
			producaoPlano = verifica((BigDecimal) reg[_plano]);
			producaoBruta = verifica((BigDecimal) reg[_producaoBrutaAuto]) + verifica((BigDecimal) reg[_producaoBrutaManu]);
			producaoRefugada = verifica((BigDecimal) reg[_producaoRefugadaAuto]) + verifica((BigDecimal) reg[_producaoRefugadaManu]);

			RelatorioPlanejamentoRealizadoDTO item = new RelatorioPlanejamentoRealizadoDTO();
			if (!relatorio.containsKey(chave)) {
				String nomeCliente = retornaString((String) reg[_cliente]);
				if (nomeCliente.equals("")) {
					nomeCliente = retornaString((String) reg[_cliente2]);
				}
				item.setOp((String) reg[_op]);
				item.setPedido(retornaPedido((String) reg[_pedido]));
				item.setCliente(nomeCliente);
				item.setSituacao(retornaSituacaoOp((int) reg[_situacao]));
				item.setDataPrevFim(retornaData((Date) reg[_dataPrevFim]));
				item.setMolde((String) reg[_molde]);
				String produto = "" + reg[_cdproduto] + " " + reg[_dsproduto];

				item.setProduto(produto);

				item.setPlano(retornaPesoConvertido(producaoPlano, pesoLiquido, filtro));
				item.setPlanoDouble(ConversaoTipos.converteParaDouble(item.getPlano()));

				item.setProducao(retornaPesoConvertido(producaoBruta - producaoRefugada, pesoLiquido, filtro));
				item.setProducaoDouble(ConversaoTipos.converteParaDouble(item.getProducao()));

				item.setProduzir(retornaPesoConvertido(producaoPlano - producaoBruta - producaoRefugada, pesoLiquido, filtro));
				item.setProduzirDouble(ConversaoTipos.converteParaDouble(item.getProduzir()));

				item.setMaquina((String) reg[_maquina]);

				item.setProdMaq(retornaPesoConvertido(producaoBruta - producaoRefugada, pesoLiquido, filtro));
				item.setProdMaqDouble(ConversaoTipos.converteParaDouble(item.getProdMaq()));

				relatorio.put(chave, item);

			} else {
				int casas = 0;

				if (filtro.isPeca()) {
					casas = 2; // casas opcionais ma formatacao
				} else if (filtro.isKilograma()) {
					casas = 3;

				} else if (filtro.isTonelada()) {
					casas = 4;

				}
				item = relatorio.get(chave);
				Double novaProducaoPlano = ConversaoTipos.converteParaDouble(item.getPlano());

				item.setPlano(ConversaoTipos.converteParaStringCasasOpcionais(novaProducaoPlano, casas));
				item.setPlanoDouble(ConversaoTipos.converteParaDouble(item.getPlano()));
				Double novaProducao = ConversaoTipos.converteParaDouble(retornaPesoConvertido(producaoBruta - producaoRefugada, pesoLiquido, filtro)) + 
									  ConversaoTipos.converteParaDouble(item.getProducao());

				item.setProducao(ConversaoTipos.converteParaStringCasasOpcionais(novaProducao, casas));
				item.setProducaoDouble(ConversaoTipos.converteParaDouble(item.getProducao()));

				double result = (novaProducaoPlano - novaProducao);

				item.setProdMaq(ConversaoTipos.converteParaStringCasasOpcionais(novaProducao, casas));
				item.setProdMaqDouble(ConversaoTipos.converteParaDouble(item.getProdMaq()));

				item.setProduzir(ConversaoTipos.converteParaStringCasasOpcionais(result, casas));
				item.setProduzirDouble(ConversaoTipos.converteParaDouble(item.getProduzir()));

			}

		}

		for (String chaveHash : relatorio.keySet()) {
			RelatorioPlanejamentoRealizadoDTO itemDto = new RelatorioPlanejamentoRealizadoDTO();
			itemDto = relatorio.get(chaveHash);
			retorno.getItens().add(itemDto);
		}

		return retorno;
	}

	private RelatorioPlanejamentoRealizadoDTO montarEstruturaRelatorio(
			List<Object> lista, FiltroRelatorioPlanejamentoRealizadoDTO filtro,
			RelatorioPlanejamentoRealizadoDTO retorno) {

		String situacao = "disponivel";

		int _op = 0;
		int _pedido = 1;
		int _cliente = 2;
		int _dataPrevFim = 4;
		int _dsproduto = 5;
		int _cdproduto = 6;
		int _pesoLiquido = 7;
		int _plano = 8;
		int _molde = 9;
		int _pt = 10;
		
		for (Object obj : lista) {
			Object[] reg = (Object[]) obj;

			String op = (String) reg[_op];
			String posto = (String) reg[_pt];

			boolean naLista = false;
			for (RelatorioPlanejamentoRealizadoDTO o : retorno.getItens()) {
				if (op != null) {
					if (op.equals(o.getOp()) && posto.equals(o.getMaquina())) {
						naLista = true;
						break;
					}
				}
			}
			
			if (naLista == false) {
				RelatorioPlanejamentoRealizadoDTO item = new RelatorioPlanejamentoRealizadoDTO();
				int casas = 0;
				if (filtro.isPeca()) {

					casas = 0;

				} else if (filtro.isKilograma()) {

					casas = 3;

				} else if (filtro.isTonelada()) {

					casas = 4;

				}

				item.setOp((String) reg[_op]);
				item.setPedido(retornaPedido((String) reg[_pedido]));
				item.setCliente(retornaString((String) reg[_cliente]));
				item.setSituacao(situacao);
				item.setDataPrevFim(retornaData((Date) reg[_dataPrevFim]));
				item.setMolde((String) reg[_molde]);
				String produto = "" + reg[_cdproduto] + " " + reg[_dsproduto];
				item.setProduto(produto);

				BigDecimal bdplano = (BigDecimal) reg[_plano];
				double plano = bdplano.doubleValue();
				BigDecimal pliquido = (BigDecimal) reg[_pesoLiquido];
				double pesoliquido = 0d;
				if (pliquido != null)
					pesoliquido = pliquido.doubleValue();

				item.setPlano(ConversaoTipos.converteDecimalParaString(Double.valueOf(retornaPesoConvertido(plano, pesoliquido, filtro)), casas));
				item.setPlanoDouble(ConversaoTipos.converteParaDouble(item.getPlano()));
				item.setProducao(ConversaoTipos.converteParaStringCasasOpcionais(0.0, casas));
				item.setProducaoDouble(ConversaoTipos.converteParaDouble(item.getProducao()));
				item.setProduzir(ConversaoTipos.converteParaStringCasasOpcionais(0.0, casas));
				item.setProduzirDouble(ConversaoTipos.converteParaDouble(item.getProduzir()));
				item.setMaquina((String) reg[_pt]);
				item.setProdMaq(ConversaoTipos.converteParaStringCasasOpcionais(0.0, casas));
				item.setProdMaqDouble(ConversaoTipos.converteParaDouble(item.getProdMaq()));
				retorno.getItens().add(item);

			}

		}

		return retorno;
	}

	private void ordernarLista(List<RelatorioPlanejamentoRealizadoDTO> lista) {

		Collections.sort(lista,
				new Comparator<RelatorioPlanejamentoRealizadoDTO>() {

					@Override
					public int compare(RelatorioPlanejamentoRealizadoDTO o1,
							RelatorioPlanejamentoRealizadoDTO o2) {
						String s1 = o1.getOp() + o1.getMaquina();
						String s2 = o2.getOp() + o2.getMaquina();
						s1 = s1.replace("-", "");
						s2 = s2.replace("-", "");
						return s1.compareTo(s2)*-1;
					}					

				});
	}

	private String retornaPesoConvertido(Double producao, Double pesoLiquido, FiltroRelatorioPlanejamentoRealizadoDTO filtro) {

		
		if (filtro.isPeca() == true) {
			return ConversaoTipos.converteParaStringCasasOpcionais(producao, 2);
		} else if (filtro.isKilograma() == true) {
			double kgs = (producao * pesoLiquido) / 1000;
			return ConversaoTipos.converteParaStringCasasOpcionais(kgs, 3);

		} else {
			BigDecimal p = new BigDecimal(producao);
			p = p.multiply(new BigDecimal(pesoLiquido));

			BigDecimal bd = p.divide(new BigDecimal(1000000));
			bd = bd.round(new MathContext(4));
			
			return ConversaoTipos.converteParaStringCasasOpcionais(bd.doubleValue(), 4);
		}
	}

	private String retornaData(Date dthrFhora) {
		if (dthrFhora != null) {
			return DataHoraRN.dateToStringDDMMYYYYHHMMSS(dthrFhora);
		} else {
			return "*******************";
		}
	}

	public String retornaSituacaoOp(int stOp) {
	    
		switch (stOp) {
		case 0:
			return "cadastrada";
		case 1:
			return "firmada";
		case 2:
			return "suspensa";
		case 3:
			return "cancelada";
		case 4:
			return "concluida";
		case 5:
			return "em setup";
		case 6:
			return "iniciada";
		}
		return null;
	}

	public String retornaNomeCliente(PpCliente ppCliente) {
		if (ppCliente != null) {
			return ppCliente.getNmCliente();
		} else {
			return "";
		}
	}

	public String retornaPedido(String nec) {
		if (nec != null) {
			return nec;
		} else {
			return "";
		}
	}

	public double verifica(BigDecimal bigDecimal) {

		if (bigDecimal == null) {
			return 0;
		} else {
			return bigDecimal.doubleValue();
		}
	}

	private String retornaString(String item) {
		if (item != null) {
			return item;
		} else {
			return "";
		}
	}

}
