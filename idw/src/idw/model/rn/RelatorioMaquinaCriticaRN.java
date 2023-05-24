package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmPt;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroRelMaqCriticaDTO;
import idw.webservices.dto.RelatorioMaquinasCriticasDTO;
import ms.util.ConversaoTipos;

public class RelatorioMaquinaCriticaRN extends AbstractRN<DAOGenerico> {

	public RelatorioMaquinaCriticaRN() {
		this(null);
	}

	public RelatorioMaquinaCriticaRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public RelatorioMaquinasCriticasDTO getRelatorioMaquinasCriticas(FiltroRelMaqCriticaDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioMaquinaCriticaRN.getRelatorioMaquinasCriticas");
		log.info( idLog , 0, "RelatorioMaquinaCriticaRN.getRelatorioMaquinasCriticas filtro usado:" + filtro.toString());
		
		List<DwConsolid> listaConsolid = consulta(filtro);
		DwTurno turnoAnterior = getTurnoAnteiroAoTurno(filtro.getDwTurno());
		
		RelatorioMaquinasCriticasDTO retorno = montarRelarorio(listaConsolid, filtro, turnoAnterior);
		
		log.mostrarAvaliacaoCompleta();
		
		return retorno;//montarRelarorio(listaConsolid, filtro, turnoAnterior);
	
	}

	private List<DwConsolid> consulta(FiltroRelMaqCriticaDTO filtro) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwConsols consol");
		q.append("JOIN consolid.dwTurno turno");
		q.append("JOIN consolid.omPt pt");
		q.append("WHERE consolid.tpId = :tpId");
		q.append("AND consolid.dtReferencia = :dtRef");
		q.append("AND turno.idTurno = :idTurno");
		q.append("and consolid.stAtivo is null");
		// removi a clausa abaixo para permitir que os postos sem producao
		// aparecam tambem
		// q.append("AND consol.pcsAutoProducaobruta IS NOT NULL");
		if (filtro.getListaMaquinas() != null) {
			if (!filtro.getListaMaquinas().isEmpty()) {
				q.append("AND pt.idPt IN (:pts)");
			}
		}
		q.append("ORDER BY consolid.dthrIhora");

		q.defineParametro("tpId", (byte) 0);
		q.defineParametro("idTurno", filtro.getDwTurno().getIdTurno());
		q.defineParametroData("dtRef", filtro.getDataReferencia());
		if (filtro.getListaMaquinas() != null) {
			List<Object> lista = new ArrayList<>();
			for (OmPt pt : filtro.getListaMaquinas()) {
				lista.add(pt.getIdPt());
			}
			if (!filtro.getListaMaquinas().isEmpty()) {
				q.defineListaParametro("pts", lista);
			}
		}
		return q.list();
	}

	private Double getProdTurnoAnterior(Date dtRef, DwTurno turnoAnterior, String cdPt, String cdProduto) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT SUM(consol.pcsAutoProducaobruta)");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwConsols consol");
		q.append("JOIN consolid.dwTurno turno");
		q.append("JOIN consolid.omPt pt");

		q.append("JOIN consolid.dwFolha folha");
		q.append("LEFT JOIN folha.dwFolhaiacs folhaiac");
		q.append("LEFT JOIN folhaiac.omProduto produto1");
		q.append("LEFT JOIN folha.dwFolharaps folharap");
		q.append("LEFT JOIN folharap.dwFolharapcoms folharapcom");
		q.append("LEFT JOIN folharapcom.omProduto produto2");

		q.append("WHERE consolid.tpId = :tpId");
		q.append("AND consolid.dtReferencia = :dtRef");
		q.append("AND turno.idTurno = :idTurno");
		q.append("and consolid.stAtivo is null");
		q.append("AND consol.pcsAutoProducaobruta IS NOT NULL");
		q.append("AND pt.cdPt = :cdPt");

		q.append("AND (produto1.cdProduto = :cdProduto OR produto2.cdProduto = :cdProduto)");

		q.append("GROUP BY consolid.tpId");

		q.defineParametro("tpId", (byte) 0);
		q.defineParametro("idTurno", turnoAnterior.getIdTurno());
		q.defineParametroData("dtRef", dtRef);
		q.defineParametro("cdPt", cdPt);
		q.defineParametro("cdProduto", cdProduto);
		BigDecimal retorno = (BigDecimal) q.uniqueResult();
		if (retorno == null) {
			return 0d;
		} else {
			return retorno.doubleValue();
		}
	}

	private RelatorioMaquinasCriticasDTO montarRelarorio(List<DwConsolid> listaConsolids, FiltroRelMaqCriticaDTO filtro, DwTurno turnoAnterior) {
		RelatorioMaquinasCriticasDTO retorno = new RelatorioMaquinasCriticasDTO();
		retorno.setListaHoras(new ArrayList<String>());
		retorno.setItens(new ArrayList<RelatorioMaquinasCriticasDTO>());
		if (turnoAnterior != null) {
			retorno.setTurnoAnterior(turnoAnterior.getDsTurno());
		}

		// ENCONTRANDO HORARIOS
		HashMap<String, Integer> mapHoras = new HashMap<>();
		for (DwConsolid consolid : listaConsolids) {
			if (mapHoras.size() == 12) {
				break;
			}
			String data = DataHoraRN.dateToStringDDMMHHMM(consolid.getDthrIhora());
			Integer valor = mapHoras.get(data);
			if (valor == null) {
				String strData = "<html>" + data.substring(0, 5) + "<br>" + data.substring(6, 11) + "</html>";
				retorno.getListaHoras().add(strData);
				mapHoras.put(data, mapHoras.size() + 1);
			}
		}

		HashMap<String, RelatorioMaquinasCriticasDTO> mapMaquinas = new HashMap<>();

		for (DwConsolid consolid : listaConsolids) {
			String data = DataHoraRN.dateToStringDDMMHHMM(consolid.getDthrIhora());
			Integer valor = mapHoras.get(data);
			if (valor == null) {
				break;
			}
			for (DwConsol consol : consolid.getDwConsols()) {

				String cdProduto = null;
				BigDecimal pesoProduto = BigDecimal.ZERO;

				for (DwFolhaiac folhaiac : consolid.getDwFolha().getDwFolhaiacs()) {
					cdProduto = folhaiac.getOmProduto().getCdProduto();
					pesoProduto = folhaiac.getOmProduto().getGPesoBruto() != null ? folhaiac.getOmProduto().getGPesoBruto() : BigDecimal.ZERO;
				}
				for (DwFolharap folharap : consolid.getDwFolha().getDwFolharaps()) {
					for (DwFolharapcom folharapcom : folharap.getDwFolharapcoms()) {
						if (cdProduto == null) {
							cdProduto = folharapcom.getOmProduto().getCdProduto();
						} else {
							cdProduto = cdProduto + ", " + folharapcom.getOmProduto().getCdProduto();
						}
						pesoProduto = folharapcom.getOmProduto().getGPesoBruto() != null ? folharapcom.getOmProduto().getGPesoBruto() : BigDecimal.ZERO;
					}
				}

				String paradas = null;
				for (DwConsolpa consolpa : consol.getDwConsolpas()) {
					if (paradas == null) {
						paradas = consolpa.getDwTParada().getDsTparada();
					} else {
						paradas = paradas + ", " + consolpa.getDwTParada().getDsTparada();
					}
				}

				String prodBruta = null;

				double prodPrevi = consol.getPcsAutoProducaoprevista() != null ? consol.getPcsAutoProducaoprevista().doubleValue() : 0;
				if (filtro.isMostrarEmPeca()) {
					prodBruta = ConversaoTipos.converteParaStringCasasOpcionais(consol.getPcsProducaoBruta(), 3);
				} else if (filtro.isMostrarEmKilograma()) {
					double intProdBruta = consol.getPcsProducaoBruta().doubleValue();

					prodBruta = ConversaoTipos.converteParaStringCasasOpcionais( (pesoProduto.doubleValue() * intProdBruta) / 1000d, 3);
					prodPrevi = (pesoProduto.doubleValue() * prodPrevi) / 1000d;

				} else {

					double intProdBruta = consol.getPcsProducaoBruta().doubleValue();

					prodBruta = ConversaoTipos.converteParaStringCasasOpcionais( (pesoProduto.doubleValue() * intProdBruta) / 1000000d, 3);
					prodPrevi = (pesoProduto.doubleValue() * prodPrevi) / 1000000d;
				}

				String chave = consolid.getOmPt().getCdPt() + cdProduto;

				RelatorioMaquinasCriticasDTO aux = mapMaquinas.get(chave);
				if (aux == null) {
					aux = new RelatorioMaquinasCriticasDTO();
					aux.setPesoBruto(String.valueOf(pesoProduto));
					aux.setMaquina(consolid.getOmPt().getCdPt());
					aux.setProduto(cdProduto);
					aux.setParada(paradas);
					aux.setMeta(ConversaoTipos.converteParaStringCasasOpcionais(prodPrevi, 3));
					aux.setProdTurno(ConversaoTipos.converteParaStringCasasOpcionais(Double.parseDouble(prodBruta), 3));
					setarValoresHoras(mapHoras, aux, consolid.getDthrIhora(), prodBruta);
					mapMaquinas.put(chave, aux);
				} else {
					String prodTurno = null;
					if (filtro.isMostrarEmPeca()) {
						double intProdBruta = Double.parseDouble(prodBruta);
						prodTurno = ConversaoTipos.converteParaStringCasasOpcionais(Double.parseDouble(aux.getProdTurno()) + intProdBruta, 3);
					} else {
						double doubleProdBruta = Double.parseDouble(prodBruta);
						prodTurno = ConversaoTipos.converteParaStringCasasOpcionais(Double.parseDouble(aux.getProdTurno()) + doubleProdBruta, 3);
					}

					if (prodPrevi > Double.parseDouble(aux.getMeta())) {
						aux.setMeta(ConversaoTipos.converteParaStringCasasOpcionais(prodPrevi, 3));
					}
					aux.setProdTurno(prodTurno);
					aux.setParada(paradas);
					setarValoresHoras(mapHoras, aux, consolid.getDthrIhora(), prodBruta);
				}
			}
			if (mapMaquinas.size() == 13) {
				break;
			}
		}

		for (String chave : mapMaquinas.keySet()) {
			RelatorioMaquinasCriticasDTO item = mapMaquinas.get(chave);

			String producaoTotal = null;
			if (filtro.isMostrarEmPeca()) {
				double prodTurnoAnt = 0;
				if (turnoAnterior != null) {
					prodTurnoAnt = getProdTurnoAnterior(filtro.getDataReferencia(), turnoAnterior, item.getMaquina(), item.getProduto());
				}
				
				item.setProdTurnoAnt(ConversaoTipos.converteParaStringCasasOpcionais(Double.valueOf(prodTurnoAnt), 3));
				producaoTotal = ConversaoTipos.converteParaStringCasasOpcionais(Double.parseDouble(item.getProdTurno()) + prodTurnoAnt, 3);
			} else {
				double prodTurnoAnt = getProdTurnoAnterior(filtro.getDataReferencia(), turnoAnterior, item.getMaquina(), item.getProduto());
				
				if (filtro.isMostrarEmKilograma()) {

					item.setProdTurnoAnt(ConversaoTipos.converteParaStringCasasOpcionais((prodTurnoAnt) * Double.valueOf(item.getPesoBruto()) /1000, 3));

				}else if(filtro.isMostrarEmTonela()){
					
					item.setProdTurnoAnt(ConversaoTipos.converteParaStringCasasOpcionais(prodTurnoAnt * Double.valueOf(item.getPesoBruto()) /1000000, 3));

				}
				producaoTotal = ConversaoTipos.converteParaStringCasasOpcionais(Double.parseDouble(item.getProdTurno()) + Double.parseDouble(item.getProdTurnoAnt()), 3);
			}

			item.setProdTotal(producaoTotal);
			retorno.getItens().add(item);
		}

		Collections.sort(retorno.getListaHoras(), new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		return retorno;
	}

	private void setarValoresHoras(HashMap<String, Integer> mapHoras, RelatorioMaquinasCriticasDTO item, Date dthrIhora, String producaoBrutaP) {
		String producaoBruta = ConversaoTipos.converteDecimalParaString(Double.parseDouble(producaoBrutaP), 3);

		Integer posicaoHoraAux = mapHoras.get(DataHoraRN.dateToStringDDMMHHMM(dthrIhora));

		if (posicaoHoraAux != null) {
			if (posicaoHoraAux == 1) {
				item.addProdHora1(producaoBruta);
			}
			if (posicaoHoraAux == 2) {
				item.addProdHora2(producaoBruta);
			}
			if (posicaoHoraAux == 3) {
				item.addProdHora3(producaoBruta);
			}
			if (posicaoHoraAux == 4) {
				item.addProdHora4(producaoBruta);
			}
			if (posicaoHoraAux == 5) {
				item.addProdHora5(producaoBruta);
			}
			if (posicaoHoraAux == 6) {
				item.addProdHora6(producaoBruta);
			}
			if (posicaoHoraAux == 7) {
				item.addProdHora7(producaoBruta);
			}
			if (posicaoHoraAux == 8) {
				item.addProdHora8(producaoBruta);
			}
			if (posicaoHoraAux == 9) {
				item.addProdHora9(producaoBruta);
			}
			if (posicaoHoraAux == 10) {
				item.addProdHora10(producaoBruta);
			}
			if (posicaoHoraAux == 11) {
				item.addProdHora11(producaoBruta);
			}
			if (posicaoHoraAux == 12) {
				item.addProdHora12(producaoBruta);
			}
		}
	}

	private DwTurno getTurnoAnteiroAoTurno(DwTurno turno) {

		MapQuery query = new MapQuery(getDaoSession());
		MapQuery q = new MapQuery(getDaoSession());
		Integer cd = Integer.parseInt(turno.getCdTurno());
		if (cd > 0)
			cd--;
		else {

			q.append("from DwTurno t");
			q.append("where t.stAtivo = 1");

			cd = q.list().size() - 1;
			System.out.println("AQUII " + cd);
		}

		query.append("from DwTurno t");
		query.append("where t.stAtivo = 1");
		query.append("and t.cdTurno = :cd");
		query.append("order by t.idTurno");
		query.defineParametro("cd", cd.toString());

		if (query.list().size() == 0)
			return null;

		return (DwTurno) query.uniqueResult();
	}
}