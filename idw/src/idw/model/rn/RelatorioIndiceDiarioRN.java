package idw.model.rn;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.rn.detalhemonitorizacao.IndicadorCicloMedioRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.FiltroRelatorioIndiceDiarioDTO;
import idw.webservices.dto.ListaRelatorioIndicesDiariosDTO;
import idw.webservices.dto.RelatorioIndiceDiarioDTO;

public class RelatorioIndiceDiarioRN extends AbstractRN<DAOGenerico> {

	public RelatorioIndiceDiarioRN() {
		this(null);
	}

	public RelatorioIndiceDiarioRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public ListaRelatorioIndicesDiariosDTO getRelatorioIndicesDiarios(FiltroRelatorioIndiceDiarioDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioIndiceDiarioRN.getRelatorioIndicesDiarios");
		log.info( idLog , 0, "RelatorioIndiceDiarioRN.getRelatorioIndicesDiarios filtro usado:" + filtro.toString());
		
		double producaoPorCicloAtivo = 0d;
		double producaoPorCicloTotal = 0d;
		
		ListaRelatorioIndicesDiariosDTO retorno = new ListaRelatorioIndicesDiariosDTO();
		retorno.setListaRelatorioIndiceDiario(new ArrayList<RelatorioIndiceDiarioDTO>());
		List<DwConsolid> listaconsolids = consulta(filtro);
		HashMap<Date, ArrayList<DwConsolid>> mapConsolidsPorPeriodoPt = new HashMap<>();
		Map<Long, String> mapIndPcsCiclo = new HashMap<Long, String>();

		for (DwConsolid consolid : listaconsolids) {
			Date chave = DataHoraRN.getDataSemHora(consolid.getDtReferencia());
			ArrayList<DwConsolid> listaConsolidPorPeriodo = mapConsolidsPorPeriodoPt.get(chave);
			if (listaConsolidPorPeriodo == null) {
				listaConsolidPorPeriodo = new ArrayList<>();
				listaConsolidPorPeriodo.add(consolid);
				mapConsolidsPorPeriodoPt.put(chave, listaConsolidPorPeriodo);
			} else {
				listaConsolidPorPeriodo.add(consolid);
			}
			
			//Marcos Sardinha: 2017-08-23 >> Defeito #4407
			double axCaAtivas = (consolid.getDwConsol().getQtAutoCavativas() == null ? 0d : consolid.getDwConsol().getQtAutoCavativas().doubleValue());
			double axCaTot = (consolid.getDwConsol().getQtAutoCavtotal() == null ? 0d : consolid.getDwConsol().getQtAutoCavtotal().doubleValue());
			
			if (mapIndPcsCiclo.containsKey(consolid.getDwFolha().getIdFolha()) == false) {
				producaoPorCicloAtivo += axCaAtivas;
				producaoPorCicloTotal += axCaTot;		
				
				mapIndPcsCiclo.put(consolid.getDwFolha().getIdFolha(), consolid.getDwFolha().getCdFolha());
			}			
		}
		
		for (Date periodo : mapConsolidsPorPeriodoPt.keySet()) {
			List<DwConsolid> ConsolidPorPeriodo = mapConsolidsPorPeriodoPt.get(periodo);
			RelatorioIndiceDiarioDTO item = totalPorPeca(ConsolidPorPeriodo, filtro);
			
			//Marcos Sardinha: 2017-08-23 >> Defeito #4407
			retorno.setTempoBoas(retorno.getTempoBoas() + item.getTempoBoas());
			retorno.setTempoRitmo(retorno.getTempoRitmo() + item.getTempoRitmo());
			retorno.setTempoAtivo(retorno.getTempoAtivo() + item.getTempoAtivo());
			
			retorno.getListaRelatorioIndiceDiario().add(item);
		}

		//Marcos Sardinha: 2017-08-23 >> Defeito #4407
		retorno.setTempoProdutivo(FormulasInjet.calcularTempoprodutivas(new BigDecimal(retorno.getTempoBoas()), BigDecimal.ZERO , new BigDecimal(retorno.getTempoRitmo())).doubleValue());
		retorno.setIndCavTotal(FormulasInjet.calcularIndiceCavidades(new BigDecimal(producaoPorCicloAtivo), new BigDecimal(producaoPorCicloTotal)).doubleValue());
		
		Comparator<RelatorioIndiceDiarioDTO> comparator = new Comparator<RelatorioIndiceDiarioDTO>() {
			@Override
			public int compare(RelatorioIndiceDiarioDTO o1, RelatorioIndiceDiarioDTO o2) {
				String data1 = o1.getData();
				String data2 = o2.getData();
				return data1.compareTo(data2) * +1;
			}
		};
		Collections.sort(retorno.getListaRelatorioIndiceDiario(), comparator);
		log.mostrarAvaliacaoCompleta();
		return retorno;
	}
	
	private List<DwConsolid> consulta(FiltroRelatorioIndiceDiarioDTO filtro) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.omPt ompt");
		q.append("JOIN consolid.dwConsols consol");
		q.append("LEFT JOIN ompt.omObjs omobj");
		q.append("LEFT JOIN consol.dwConsolprs consolpr");
		q.append("LEFT JOIN consolpr.omProduto omproduto ");
		q.append("LEFT JOIN consol.dwConsolres consolre");
		q.append("LEFT JOIN consolid.dwFolha folha");
		q.append("LEFT JOIN folha.dwFolharaps folharap");
		q.append("LEFT JOIN folharap.dwFolharapcoms folharapcom");
		q.append("LEFT JOIN folharap.dwRap rap");
		
		//Marcos Sardinha: 2017-08-08 >> Defeito #4323
		if (filtro.getDwGrupoFerramenta() != null && filtro.getDwGrupoFerramenta().getCdGrupoFerramenta() != "") {
			q.append("LEFT JOIN rap.dwRapGrupos grpmol");
		}
		
		q.append("WHERE consolid.tpId = :tpId");
		
		//Marcos Sardinha: 2017-08-23 >> Defeito #4407
		q.append("  AND consolid.stAtivo IS NULL");

		
		if (filtro.getDt_inicio() != null
				&& filtro.getDt_final() != null) {
			q.append("AND consolid.dtReferencia BETWEEN :dataincial and :datafinal");
		}
		if (filtro.getOmpt() != null) {
			q.append("AND consolid.omPt.cdPt = :idpt");
		}
		if (filtro.getOmgt() != null) {
			q.append("AND omobj.omGtByIdGt.idGt = :idGt");
		}
		
		if (filtro.getTurnoDTO() != null) {
			q.append("AND consolid.dwTurno.idTurno = :idturno");
		}else{
			q.append("AND consolid.dwTurno.idTurno != 1");
		}
		
		if (filtro.getDwRap() != null) {
			q.append("AND rap.idRap = :idrap");
		}
		if (filtro.getGpDwRap() != null) {
			q.append("AND rap.dwRap.idRap = :idgpRap");
		}

		//Marcos Sardinha: 2017-08-08 >> Defeito #4323
		if (filtro.getDwGrupoFerramenta() != null && filtro.getDwGrupoFerramenta().getCdGrupoFerramenta() != "") {
			q.append("AND grpmol.dwGrupoFerramenta.cdGrupoFerramenta = :cdgrpmol");
		}
		
		q.append("ORDER BY consolid.idConsolid DESC");
		
		
		q.defineParametro("tpId", (byte) 1);

		if (filtro.getDt_inicio() != null && filtro.getDt_final() != null) {
			q.defineParametroTimestamp("dataincial", filtro.getDt_inicio());
			q.defineParametroTimestamp("datafinal", DataHoraRN.getDataHora235959(filtro.getDt_final()));
		}
		if (filtro.getOmpt() != null) {
			q.defineParametro("idpt", filtro.getOmpt().getCdPt());
		}
		if (filtro.getOmgt() != null) {
			q.defineParametro("idGt", filtro.getOmgt().getIdGt());
		}
		if (filtro.getTurnoDTO() != null) {
			q.defineParametro("idturno", filtro.getTurnoDTO().getTurno().getIdTurno());
		}
		if (filtro.getGpDwRap() != null) {
			q.defineParametro("idgpRap", filtro.getGpDwRap().getIdRap());
		}
		if (filtro.getDwRap() != null) {
			q.defineParametro("idrap", filtro.getDwRap().getIdRap());
		}
		
		//Marcos Sardinha: 2017-08-08 >> Defeito #4323
		if (filtro.getDwGrupoFerramenta() != null && filtro.getDwGrupoFerramenta().getCdGrupoFerramenta() != "") {
            q.defineParametro("cdgrpmol", filtro.getDwGrupoFerramenta().getCdGrupoFerramenta());
        }

        
		return q.list();
	}

	private RelatorioIndiceDiarioDTO totalPorPeca(List<DwConsolid> lista, FiltroRelatorioIndiceDiarioDTO filtro) {
		RelatorioIndiceDiarioDTO item = new RelatorioIndiceDiarioDTO();
		double producaoProduzida = 0;
		double producaoPrevista = 0;
		double qtdRefugada = 0;
		double tempoProdutivo = 0;
		double tempoAtivo = 0;
		double tempoBoas = 0;
		double tempoRitmo = 0;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		BigDecimal cavidadesAtivasMolde = BigDecimal.ZERO;
		BigDecimal cavidadesTotalMolde = BigDecimal.ZERO; 

		//Marcos Sardinha: 2017-08-23 >> Defeito #4407
		Map<Long, String> mapIndPcsCiclo = new HashMap<Long, String>();
		
		double oee = 0;
		Double segcicloPadrao = 10d;
		Double segCicloMedio = 10d;
		
		for (DwConsolid consolid : lista) {
			for (DwConsol consol : consolid.getDwConsols()) {
				
				BigDecimal axCaAtivas = (consolid.getDwConsol().getQtAutoCavativas() == null ? BigDecimal.ZERO : consolid.getDwConsol().getQtAutoCavativas());
				BigDecimal axCaTot = (consolid.getDwConsol().getQtAutoCavtotal() == null ? BigDecimal.ZERO : consolid.getDwConsol().getQtAutoCavtotal());
				
				if (mapIndPcsCiclo.containsKey(consolid.getDwFolha().getIdFolha()) == false) {
					cavidadesAtivasMolde = AritmeticaUtil.somar(cavidadesAtivasMolde, axCaAtivas);
					cavidadesTotalMolde = AritmeticaUtil.somar(cavidadesTotalMolde, axCaTot);
					
					mapIndPcsCiclo.put(consolid.getDwFolha().getIdFolha(), consolid.getDwFolha().getCdFolha());
				}

				BigDecimal tempoCicloProdutivoDwConsol = consol.getSegAutoCicloprodutivo();
		
				Double tempoBoasAutoItem = FormulasInjet.calcularTempoBoas(tempoCicloProdutivoDwConsol, consol.getSegAutoTemporefugadas(), consol.getSegAutoTempoparadaCpVr(), consol.getSegAutoTempoparadaSpVr()).doubleValue();
				Double tempoBoasManuItem = FormulasInjet.calcularTempoBoas(consol.getSegManuCicloprodutivo(), consol.getSegManuTemporefugadas(), consol.getSegManuTempoparadaCpVr(), consol.getSegManuTempoparadaSpVr()).doubleValue();

				//Marcos Sardinha: 2017-08-23 >> Defeito #4407
				/*
				if (consol.getPcsProducaoBruta().doubleValue() == 0d) {
					tempoBoasAutoItem = 0d;
					tempoBoasManuItem = 0d;
				}
				*/
				
				OmCfg omcfg = Util.getConfigGeral(getDaoSession());
				IndicadorCicloMedioRN cmRN = new IndicadorCicloMedioRN(omcfg, consolid.getOmPt(), tempoCicloProdutivoDwConsol,
						consol.getQtAutoCicloprodutivo(), consol.getSegAutoTempoparadaSp());

				segCicloMedio = cmRN.calcularCicloMedio().doubleValue();  
				
				if (consol.getSegAutoCiclopadrao() != null && segCicloMedio > 0d) {
					segcicloPadrao = consol.getSegAutoCiclopadrao().doubleValue();
			    }
				
				Double tempoRitmoAutoItem = FormulasInjet.calcularRitmo(
						tempoCicloProdutivoDwConsol, 
						consol.getQtAutoCicloprodutivo(), 
						new BigDecimal(segcicloPadrao), 
						consol.getSegAutoTempoparadaCpVr(), 
						consol.getSegAutoTempoparadaSpVr()).doubleValue();
		
				Double tempoRitmoManuItem = FormulasInjet.calcularRitmo(
						consol.getSegManuCicloprodutivo(), 
						consol.getQtManuCicloprodutivo(), 
						new BigDecimal(segcicloPadrao), 
						consol.getSegManuTempoparadaCpVr(), 
						consol.getSegManuTempoparadaSpVr()).doubleValue();
				
				//Marcos Sardinha: 2017-08-23 >> Defeito #4407
				/*
				if (consol.getPcsProducaoBruta() != null && consol.getPcsProducaoBruta().compareTo(BigDecimal.ZERO) > 0 )
					tempoRitmo += tempoRitmoAutoItem + tempoRitmoManuItem;
				else {
					tempoRitmoAutoItem = 0d;
					tempoRitmoManuItem = 0d;
				}
				*/
				tempoRitmo += tempoRitmoAutoItem + tempoRitmoManuItem;
				

				tempoBoas += tempoBoasAutoItem + tempoBoasManuItem;
				if (tempoBoas < 0) {
					tempoBoas = 0d;
				}
				
				tempoProdutivo = FormulasInjet.calcularTempoprodutivas(
						new BigDecimal(tempoBoas), 
						BigDecimal.ZERO, 
						new BigDecimal(tempoRitmo)).doubleValue();

				
				
				tempoAtivo = tempoAtivo + (consol.getSegAutoTempoativo() != null ? consol.getSegAutoTempoativo().doubleValue() : 0);
//				tempoProdutivo = tempoProdutivo + (consol.getSegAutoTempoprodutivo() != null ? consol.getSegAutoTempoprodutivo().doubleValue() : 0);
				
				oee = FormulasInjet.calcularOEE(BigDecimal.valueOf(tempoProdutivo), BigDecimal.valueOf(tempoAtivo)).doubleValue();

				item.setData(sdf.format(consolid.getDtReferencia()));

				//Marcos Sardinha: 2017-08-23 >> Defeito #4407				
				if(filtro.isPeca()) {
					producaoProduzida = producaoProduzida + consol.getPcsProducaoBruta().intValue();
					producaoPrevista = producaoPrevista + (consol.getPcsAutoProducaoprevista() != null ? consol.getPcsAutoProducaoprevista().doubleValue() : 0);
					qtdRefugada = qtdRefugada + consol.getPcsProducaoRefugada().intValue(); 
				} else { 
					Long pesoBruto = 0l;
					double prodBrutaAux = consol.getPcsProducaoBruta().longValue();
					double prodPrevAux = (consol.getPcsAutoProducaoprevista() != null ? consol.getPcsAutoProducaoprevista().doubleValue() : 0);
					double prodRefAux = consol.getPcsProducaoRefugada().longValue();


					for(DwConsolpr consolpr : consol.getDwConsolprs()) {						
						OmProduto omproduto = getDao().findById(OmProduto.class, consolpr.getOmProduto().getIdProduto(), false);
						if (omproduto != null && omproduto.getGPesoBruto() != null)
							pesoBruto += omproduto.getGPesoBruto().longValue();
					}
					
					prodBrutaAux = (prodBrutaAux * pesoBruto);
					prodPrevAux = (prodPrevAux * pesoBruto);
					prodRefAux = (prodRefAux * pesoBruto);
					
					if(filtro.getUnidMedida().equals("kilo")) {
						prodBrutaAux = (prodBrutaAux /1000);
						prodPrevAux = (prodPrevAux / 1000);
						prodRefAux = (prodRefAux / 1000);
						
					} else if(filtro.getUnidMedida().equals("tonelada")) {
						prodBrutaAux = (prodBrutaAux /1000000);
						prodPrevAux = (prodPrevAux / 1000000);
						prodRefAux = (prodRefAux / 1000000);
					}
										
					producaoProduzida = producaoProduzida + prodBrutaAux;
					producaoPrevista = producaoPrevista + prodPrevAux;
					qtdRefugada = qtdRefugada + prodRefAux;
					
				}
			}
		}

		double qtdBoas = 0;
		qtdBoas = producaoProduzida - qtdRefugada;
		double eficienciarealizacao = FormulasInjet.calcularEficienciaRealizacao(new BigDecimal(qtdBoas), new BigDecimal(producaoPrevista)).doubleValue();
		
		if(producaoProduzida <= 0) {
			item.setIndiceRefugo(0);
		} else {
			item.setIndiceRefugo((qtdRefugada / producaoProduzida) * 100);
		}
		
		item.setQtdPrevista(producaoPrevista);
		item.setQtdProduzida(producaoProduzida);
		item.setQtdRefugada(qtdRefugada);
		item.setTempoAtivo(tempoAtivo);
		item.setTempoProdutivo(tempoProdutivo);
		item.setCavAtivas(cavidadesAtivasMolde.intValue());
		item.setCavTotais(cavidadesTotalMolde.intValue());		
		item.setIndiceCavAtiva( FormulasInjet.calcularIndiceCavidades(cavidadesAtivasMolde, cavidadesTotalMolde));
		item.setOee(oee);
		item.setQtdBoas(qtdBoas);		
		item.setIndiceRealizacao(eficienciarealizacao);
		//Marcos Sardinha: 2017-08-23 >> Defeito #4407
		item.setTempoRitmo(tempoRitmo);
		item.setTempoBoas(tempoBoas);
		
		return item;
	}

}