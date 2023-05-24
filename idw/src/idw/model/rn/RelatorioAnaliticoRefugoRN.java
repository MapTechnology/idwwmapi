package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroRelatorioIndiceDiarioDTO;
import idw.webservices.dto.ListaRelatorioAnaliticoRefugoDTO;
import idw.webservices.dto.RelatorioAnaliticoRefugoDTO;

public class RelatorioAnaliticoRefugoRN extends AbstractRN<DAOGenerico> {
	
	public RelatorioAnaliticoRefugoRN() {
		this(null);
	}

	public RelatorioAnaliticoRefugoRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public ListaRelatorioAnaliticoRefugoDTO getListaRelatorioAnaliticoRefugoDTO(FiltroRelatorioIndiceDiarioDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorionR100RN.getRelatorioR100DTO");
		log.info( idLog , 0, "RelatorionR100RN.getRelatorioR100DTO filtro usado:" + filtro.toString());
		ListaRelatorioAnaliticoRefugoDTO retorno = montarEstruturaPorKilograma(filtro);
		log.mostrarAvaliacaoCompleta();		
		return retorno;//montarEstruturaPorKilograma(filtro);
	}
	
	private List<DwConsolid> consultaRelatorioAnaliticoRefugo(FiltroRelatorioIndiceDiarioDTO filtro) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwConsols consol");
		q.append("JOIN consolid.omPt ompt");
		q.append("LEFT JOIN ompt.omObjs omobj");
		q.append("left join omobj.omGtByIdGt omgt");
		q.append("LEFT JOIN consol.dwConsolprs consolpr");
		q.append("LEFT JOIN consolpr.omProduto omproduto ");
		q.append("LEFT JOIN consolid.dwFolha folha");
		q.append("LEFT JOIN folha.dwFolharaps folharap");
		q.append("LEFT JOIN folharap.dwRap rap");
		q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
		q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta gpferramenta");
		q.append("WHERE consolid.tpId = :tpId");
//		q.append("AND ompt.stAtivo = :stAtivo"); alessandre removi pois pode ter lancamentos de pts que foram excluidos
		q.append("AND consolpr.pcsAutoProducaorefugada IS NOT NULL");
//		q.append("AND omproduto.stAtivo = :stAtivo"); alessandre removi pois pode ter lancamentos de produtos que foram excluidos

		if (filtro.getDt_inicio() != null && filtro.getDt_final() != null) {
			q.append("AND consolid.dtReferencia BETWEEN :dataincial and :datafinal");
		}
		if (filtro.getOmpt() != null) {
			q.append("AND consolid.omPt.idPt = :idpt");
		}
		if (filtro.getOmgt() != null) {
			q.append("AND omgt = :omgt");
		}
		if (filtro.getTurnoDTO() != null) {
			q.append("AND consolid.dwTurno.idTurno = :idturno");
		}else{
			q.append("AND consolid.dwTurno.idTurno != 1");
		}
		if (filtro.getDwRap() != null) {
			q.append("AND rap.idRap = :idrap");
		}
		
		if(filtro.getDwGrupoFerramenta() != null){
			q.append("AND gpferramenta.idGrupoFerramenta = :idferramenta");
		}
				
		q.defineParametro("tpId", (byte) 1);
		q.defineParametro("stAtivo", (byte) 1);

		if (filtro.getDt_inicio() != null && filtro.getDt_final() != null) {
			q.defineParametroTimestamp("dataincial", filtro.getDt_inicio());
			q.defineParametroTimestamp("datafinal",DataHoraRN.getDataHora235959(filtro.getDt_final()));
		}
		if (filtro.getOmpt() != null) {
			q.defineParametro("idpt", filtro.getOmpt().getIdPt());
		}
		if (filtro.getOmgt() != null) {
			q.defineParametro("omgt", filtro.getOmgt());
		}
		if (filtro.getTurnoDTO() != null) {
			q.defineParametro("idturno", filtro.getTurnoDTO().getTurno().getIdTurno());
		}
		if(filtro.getDwGrupoFerramenta() != null){
			q.defineParametro("idferramenta", filtro.getDwGrupoFerramenta().getIdGrupoFerramenta());
		}
		if (filtro.getDwRap() != null) {
			q.defineParametro("idrap", filtro.getDwRap().getIdRap());
		}
		return q.list();
	}

	private ListaRelatorioAnaliticoRefugoDTO montarEstruturaPorKilograma(FiltroRelatorioIndiceDiarioDTO filtro) {
		List<DwConsolid> listaDwConsolid = consultaRelatorioAnaliticoRefugo(filtro);

		ListaRelatorioAnaliticoRefugoDTO retorno = new ListaRelatorioAnaliticoRefugoDTO();
		retorno.setListaDatas(new ArrayList<Date>());
		retorno.setListaRelatorioAnaliticoRefugo(new ArrayList<RelatorioAnaliticoRefugoDTO>());

		HashMap<String, RelatorioAnaliticoRefugoDTO> mapRelatorio = new HashMap<>();
		HashMap<Date, Integer> mapDatas = new HashMap<>();

		
		long diff = filtro.getDt_final().getTime() - filtro.getDt_inicio().getTime();// Obtém a diferença entre as datas
		int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);// Obtém a diferença de dias
		days += 1;// Iguala a diferença a data limite.
		
		for(int i =0 ; i< days  ;i++){
			
			Calendar cal = Calendar.getInstance();
	        cal.setTime(filtro.getDt_inicio());
	        cal.add(Calendar.DATE, i); 
//	    	System.out.println(cal.getTime());
	    	Date data = DataHoraRN.getDataSemHora(cal.getTime());
			retorno.getListaDatas().add( data );	
			mapDatas.put(data, i+1);
	
			
		}
		retorno.setListaDatas(retorno.getListaDatas());
		int totalPecasRefugadas = 0;
		
		int pesoFiltro = 0;
		if (filtro.getUnidMedida().equals("kilo")) {
			pesoFiltro = 1000;
		}
		if (filtro.getUnidMedida().equals("tonelada")) {
			pesoFiltro = 1000000;
		}
		
		
		
		
		
		for (DwConsolid consolid : listaDwConsolid) {
			for (DwConsol consol : consolid.getDwConsols()) {
				for (DwConsolpr consolpr : consol.getDwConsolprs()) {
					if (consolpr.getOmProduto() != null) {

						String produto = consolpr.getOmProduto() != null ? consolpr.getOmProduto().getCdProduto() + " - " + consolpr.getOmProduto().getDsProduto() : "";
						
						Date dataReferencia = (DataHoraRN.getDataSemHora(consol.getDwConsolid().getDtReferencia()));
						
						int qtdPecaRefugada = (consolpr.getPcsProducaoRefugada() != null ? consolpr.getPcsProducaoRefugada().intValue() : 0);
						
						totalPecasRefugadas = totalPecasRefugadas + qtdPecaRefugada;
						
						BigDecimal prodRefugada = new BigDecimal(qtdPecaRefugada);
						BigDecimal pesoBruto = consolpr.getOmProduto().getGPesoBruto() != null ? new BigDecimal(consolpr.getOmProduto().getGPesoBruto().intValue()) : BigDecimal.ZERO;
						BigDecimal peso = prodRefugada.multiply(pesoBruto);
						peso = peso.divide(new BigDecimal(pesoFiltro));

						int pesoDoProduto = (consolpr.getOmProduto().getGPesoBruto() != null ? consolpr.getOmProduto().getGPesoBruto().intValue() : 0);
						
						
						
						RelatorioAnaliticoRefugoDTO relatorio = mapRelatorio.get(produto);
						
						if (relatorio == null) {
							relatorio = new RelatorioAnaliticoRefugoDTO();
							relatorio.setProduto(produto);
							relatorio.setData(dataReferencia);
							relatorio.setPesoProduto(pesoDoProduto);

							Integer posicao = mapDatas.get(dataReferencia);
							if (posicao != null) {
								if (posicao == 1) {								
									relatorio.setPecaDt1(qtdPecaRefugada);
									relatorio.setPesoDt1(peso);								
								}
								if (posicao == 2) {									
									relatorio.setPecaDt2(qtdPecaRefugada);
									relatorio.setPesoDt2(peso);									
								}
								if (posicao == 3) {
									relatorio.setPecaDt3(qtdPecaRefugada);
									relatorio.setPesoDt3(peso);
								}
								if (posicao == 4) {
									relatorio.setPecaDt4(qtdPecaRefugada);
									relatorio.setPesoDt4(peso);
								}
								if (posicao == 5) {
									relatorio.setPecaDt5(qtdPecaRefugada);
									relatorio.setPesoDt5(peso);								    				    
								}
								relatorio.setPecasAcumuladas(qtdPecaRefugada);
							    relatorio.setPesosAcumulados(peso);
							}
							mapRelatorio.put(produto, relatorio);
						} else {
							Integer posicao = mapDatas.get(dataReferencia);
							if (posicao != null) {
								if (posicao == 1) {
									relatorio.setPecaDt1(qtdPecaRefugada + relatorio.getPecaDt1());
									relatorio.setPesoDt1(peso.add(relatorio.getPesoDt1()));
								}
								if (posicao == 2) {
									relatorio.setPecaDt2(qtdPecaRefugada + relatorio.getPecaDt2());
									relatorio.setPesoDt1(peso.add(relatorio.getPesoDt2()));
								}
								if (posicao == 3) {
									relatorio.setPecaDt3(qtdPecaRefugada + relatorio.getPecaDt3());
									relatorio.setPesoDt3(peso.add(relatorio.getPesoDt3()));		
								}
								if (posicao == 4) {
									relatorio.setPecaDt4(qtdPecaRefugada + relatorio.getPecaDt4());
									relatorio.setPesoDt4(peso.add(relatorio.getPesoDt4()));			
								}
								if (posicao == 5) {
									relatorio.setPecaDt5(qtdPecaRefugada + relatorio.getPecaDt5());
									relatorio.setPesoDt5(peso.add(relatorio.getPesoDt5()));				
								}
								relatorio.setPecasAcumuladas(relatorio.getPecasAcumuladas() + qtdPecaRefugada);
								relatorio.setPesosAcumulados(relatorio.getPesosAcumulados().add(peso));	
							}
						}
					}
				}
			}
		}
		double indiceTotalAnterior = 0;
		for (String chave : mapRelatorio.keySet()) {			
			RelatorioAnaliticoRefugoDTO relatorio = mapRelatorio.get(chave);
			relatorio.setIndiceRefugo(getIndiceRefugo(relatorio.getPecasAcumuladas(), totalPecasRefugadas));
			retorno.getListaRelatorioAnaliticoRefugo().add(relatorio);			
		}
		Comparator<RelatorioAnaliticoRefugoDTO> comparator = new Comparator<RelatorioAnaliticoRefugoDTO>() {
			@Override
			public int compare(RelatorioAnaliticoRefugoDTO o1, RelatorioAnaliticoRefugoDTO o2) {
				return DataHoraRN.compareTo(o1.getData(), o2.getData());
			}
		};
		Collections.sort(retorno.getListaRelatorioAnaliticoRefugo(), comparator);
		
		for(RelatorioAnaliticoRefugoDTO item : retorno.getListaRelatorioAnaliticoRefugo()) {
			indiceTotalAnterior = indiceTotalAnterior + item.getIndiceRefugo();
			item.setIndiceTotal(indiceTotalAnterior);
		}
		
		return retorno;
	}
	
	private double getIndiceRefugo(int qtdPecasPorDia, int qtdPecasTotal) {
		Double retorno = ((Double.valueOf(qtdPecasPorDia) * 100) / Double.valueOf(qtdPecasTotal));
	    return retorno;
	}

}
