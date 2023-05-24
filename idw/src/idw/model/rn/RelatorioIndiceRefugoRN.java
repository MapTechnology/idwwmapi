package idw.model.rn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwConsolre;
import idw.model.pojos.DwConsolrelog;
import idw.model.pojos.DwConsolreoco;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroRelatorioIndiceDiarioDTO;
import idw.webservices.dto.ListaRelatorioIndiceRefugoDTO;
import idw.webservices.dto.RelatorioIndiceRefugoDTO;

public class RelatorioIndiceRefugoRN extends AbstractRN<DAOGenerico> {

    public static final int KG = 1000;
    public static final int TON = 1000000;

    public RelatorioIndiceRefugoRN() {
        this(null);
    }

    public RelatorioIndiceRefugoRN(DAOGenerico dao) {
        super(dao);
        if (dao == null) {
            dao = new DAOGenerico();
        }
        this.setDao(dao);
    }

	private Comparator<RelatorioIndiceRefugoDTO> comparatorPosto = new Comparator<RelatorioIndiceRefugoDTO>() {
        @Override
        public int compare(RelatorioIndiceRefugoDTO o1, RelatorioIndiceRefugoDTO o2) {

            if (o1.getMaquina().equals(o2.getMaquina())) {
                if(o1.getProduto().equals(o2.getProduto())){
                    return comparatorRefugo.compare(o1, o2);
                } else {
                    return comparatorProduto.compare(o1, o2);
                }
            }

            return o1.getMaquina().compareTo(o2.getMaquina());
        }
    };

    private Comparator<RelatorioIndiceRefugoDTO> comparatorProduto = new Comparator<RelatorioIndiceRefugoDTO>() {
        @Override
        public int compare(RelatorioIndiceRefugoDTO o1, RelatorioIndiceRefugoDTO o2) {

            if (o1.getProduto().equals(o2.getProduto())) {
                return comparatorRefugo.compare(o1, o2);
            }

            return o1.getProduto().compareTo(o2.getProduto());
        }
    };

    private Comparator<RelatorioIndiceRefugoDTO> comparatorRefugo = new Comparator<RelatorioIndiceRefugoDTO>() {
        @Override
        public int compare(RelatorioIndiceRefugoDTO o1, RelatorioIndiceRefugoDTO o2) {
            //ordem decrescente
            return o2.getQtdRefugada().compareTo(o1.getQtdRefugada());
        }
    };

	public final ListaRelatorioIndiceRefugoDTO getRelatorioIndiceRefugo(FiltroRelatorioIndiceDiarioDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioIndiceRefugoRN.getRelatorioIndiceRefugo");
		log.info( idLog , 0, "RelatorioIndiceRefugoRN.getRelatorioIndiceRefugo filtro usado:" + filtro.toString());
		
		ListaRelatorioIndiceRefugoDTO retorno = montarRelatorio(filtro);
		
		log.mostrarAvaliacaoCompleta();
		
		return retorno;//montarRelatorio(filtro);
		
	}

	private ListaRelatorioIndiceRefugoDTO montarRelatorio(FiltroRelatorioIndiceDiarioDTO filtro) {

		ListaRelatorioIndiceRefugoDTO retorno = new ListaRelatorioIndiceRefugoDTO();
		retorno.setListaRelatorioIndiceRefugo(new ArrayList<RelatorioIndiceRefugoDTO>());

		List<DwConsolid> consolids = getConsulta(filtro);
		HashMap<String, RelatorioIndiceRefugoDTO> mapRelatorio = new HashMap<>();
		HashMap<String, Double> mapProducaoPorMaquinaProduto = new HashMap<>();
		HashMap<String, Double> mapProducaoPorMaquina = new HashMap<>();

		gerarDTO(filtro, consolids, mapRelatorio, mapProducaoPorMaquinaProduto);

		HashMap<String, String> controle = new HashMap<>();
		for (String chave : mapRelatorio.keySet()) {
			RelatorioIndiceRefugoDTO item = mapRelatorio.get(chave);
			String aux = item.getMaquina() + item.getProduto();
			String strAux = controle.get(aux);
			if (strAux == null) {
				Double producaoPt = mapProducaoPorMaquina.get(item.getMaquina());
				if (producaoPt == null) {
					producaoPt = mapProducaoPorMaquinaProduto.get(item.getMaquina() + item.getProduto());
					mapProducaoPorMaquina.put(item.getMaquina(), producaoPt);
				} else {
					mapProducaoPorMaquina.remove(item.getMaquina());
					Double prod = mapProducaoPorMaquinaProduto.get(item.getMaquina() + item.getProduto());
					if(prod == null) {
						prod = 0d;
					}
					Double novaProducao = producaoPt + prod;
					mapProducaoPorMaquina.put(item.getMaquina(), novaProducao);
				}
				controle.put(aux, aux);
			}
		}

		double totalProducao = 0;
		HashMap<String, Double> controleTotal = new HashMap<>();
		for (String chave : mapRelatorio.keySet()) {
			RelatorioIndiceRefugoDTO item = mapRelatorio.get(chave);
			Double totalqtdProduzidoProd = mapProducaoPorMaquinaProduto.get(item.getMaquina() + item.getProduto());
			if(totalqtdProduzidoProd == null) {
				totalqtdProduzidoProd = 0d;
			}
			item.setTotalqtdProduzidoProd(totalqtdProduzidoProd);
			item.setTotalqtdProduzidoPt(mapProducaoPorMaquina.get(item.getMaquina()));
			retorno.getListaRelatorioIndiceRefugo().add(item);

			Double producao = controleTotal.get(item.getMaquina());
			if (producao == null) {
				producao = mapProducaoPorMaquina.get(item.getMaquina());
				producao = (producao == null ? 0d : producao);
				totalProducao = totalProducao + producao;
				controleTotal.put(item.getMaquina(), producao);
			}
		}
		retorno.setTotalPoduzido(totalProducao);

		if (filtro.getTipo().equals("maquina")) {
		    Collections.sort(retorno.getListaRelatorioIndiceRefugo(), comparatorPosto);
        } else if (filtro.getTipo().equals("produto")) {
            Collections.sort(retorno.getListaRelatorioIndiceRefugo(), comparatorProduto);
        } else if (filtro.getTipo().equals("refugo")) {
            Collections.sort(retorno.getListaRelatorioIndiceRefugo(), comparatorRefugo);
        }

		return retorno;
	}

	private void gerarDTO(
	        FiltroRelatorioIndiceDiarioDTO filtro,
	        List<DwConsolid> consolids,
	        HashMap<String, RelatorioIndiceRefugoDTO> mapRelatorio,
	        HashMap<String, Double> mapProducaoPorMaquinaProduto) {

	    for (DwConsolid consolid : consolids) {
            for (DwConsol consol : consolid.getDwConsols()) {

                if (consol.getDwConsolprs() != null && !consol.getDwConsolprs().isEmpty()) {
                    for (DwConsolpr consolpr : consol.getDwConsolprs()) {
                        double producao = 0;

                        int qtdProduzida = 0;
                        if (consolpr.getPcsProducaoBruta() != null) {
                            qtdProduzida = consolpr.getPcsProducaoBruta().intValue();
                        }
                        double pesoProduto = 0;
                        if (consolpr.getOmProduto().getGPesoBruto() != null) {
                            pesoProduto = consolpr.getOmProduto().getGPesoBruto().doubleValue();
                        }

                        if (filtro.isPeca()) {
                            producao = qtdProduzida;
                        } else if (filtro.getUnidMedida().equals("kilo")) {
                            producao = (qtdProduzida * pesoProduto) / KG;
                        } else if (filtro.getUnidMedida().equals("tonelada")) {
                            producao = (qtdProduzida * pesoProduto) / TON;
                        }

                        String chave = consolid.getOmPt().getCdPt() + consolpr.getOmProduto().getCdProduto() + " - " + consolpr.getOmProduto().getDsProduto();
                        Double producaoMaquinaProduto = mapProducaoPorMaquinaProduto.get(chave);
                        if (producaoMaquinaProduto == null) {
                            producaoMaquinaProduto = producao;
                            mapProducaoPorMaquinaProduto.put(chave, producaoMaquinaProduto);
                        } else {
                            mapProducaoPorMaquinaProduto.remove(chave);
                            Double novaProducaoMaquinaProduto = producao + producaoMaquinaProduto;
                            mapProducaoPorMaquinaProduto.put(chave, novaProducaoMaquinaProduto);
                        }

                        /* Alessandre em 18-11-15 inclui o trecho abaixo para incluir
                         * tb os produtos que nao tem refugo
                         * para que os mesmos aparecam no relatorio
                         */
                        // Avalia se existe algum dwconsol do produto que tenha refugo
                        boolean isExisteRefugo = false;
                        for (DwConsolid idAux : consolids) {
                            for (DwConsol cAux : idAux.getDwConsols()) {
                                if (cAux.getDwConsolres() == null || cAux.getDwConsolres().isEmpty()) {
                                    continue;
                                }

                                for (DwConsolpr prAux : cAux.getDwConsolprs()) {
                                    if (prAux.getOmProduto().equals(consolpr.getOmProduto())) {
                                        isExisteRefugo = true;
                                    }
                                }
                            }
                        }

                        if (!isExisteRefugo) {
                            String maquina = consolid.getOmPt().getCdPt();
                            String produto = consolpr.getOmProduto().getCdProduto() + " - " + consolpr.getOmProduto().getDsProduto();
                            //String refugo = ""; 
                            String refugo = "**** - ********";

                            if (filtro.getTipo().equals("maquina")) {
                                chave = maquina + produto + refugo;
                            } else if (filtro.getTipo().equals("produto")) {
                                chave = produto + refugo;
                            } else if (filtro.getTipo().equals("refugo")) {
                                chave = "";
                            }

                            if (!filtro.getTipo().equals("refugo")) {
                                RelatorioIndiceRefugoDTO item = mapRelatorio.get(chave);
                                if (item == null) {
                                    item = new RelatorioIndiceRefugoDTO();
                                    item.setMaquina(maquina);
                                    item.setProduto(produto);
                                    item.setRefugo(refugo);
                                    item.setQtdRefugada(0d);
                                    mapRelatorio.put(chave, item);
                                 } else {
                                    double novaQtdRefugada =  0d + item.getQtdRefugada();
                                    item.setQtdRefugada(novaQtdRefugada);
                                 }
                            }
                        }
                    }
                }

                for (DwConsolre consolre : consol.getDwConsolres()) {
                    for (DwConsolreoco consolreoco : consolre.getDwConsolreocos()) {
                        DwConsolrelog consolrelog = consolreoco.getDwConsolrelog();

                        String maquina = consolid.getOmPt().getCdPt();
                        String produto = consolrelog.getOmProduto().getCdProduto() + " - " +  consolrelog.getOmProduto().getDsProduto();
                        String refugo = consolrelog.getDwTRefugo().getCdTrefugo()
                                + " - " + consolrelog.getDwTRefugo().getDsTrefugo();

                        String chave = null;
                        if (filtro.getTipo().equals("maquina")) {
                            chave = maquina + produto + refugo;
                        } else if (filtro.getTipo().equals("produto")) {
                            chave = produto + refugo;
                        } else if (filtro.getTipo().equals("refugo")) {
                            chave = refugo;
                        }
                        /* Alessandre em 18-11-15 verificar se existe **** no map se exisitr entao remover */
                        if (filtro.getTipo().equals("maquina")) {
                            if (mapRelatorio.containsKey(maquina + produto + "**** - ********")) {
                                mapRelatorio.remove(maquina + produto + "**** - ********");
                            }
                        }

                        double producaoRefugada = 0;
                        int qtdPcsRefugada = 0;
                        
                        Boolean isCancelado = (consolrelog.getIsCancelado() == null ? false : consolrelog.getIsCancelado()); 
                        
                        if (isCancelado == false) {
	                        if (consolrelog.getPcsAutoProducaorefugada() != null) {
	                            qtdPcsRefugada = consolrelog.getPcsAutoProducaorefugada().intValue();
	                        }
	
	                        if (consolrelog.getPcsManuProducaorefugada() != null) {
	                        	qtdPcsRefugada = qtdPcsRefugada + consolrelog.getPcsManuProducaorefugada().intValue();
	                        }
                        }
                        
                        double pesoProduto = 0.0;
                        if (consolrelog.getOmProduto().getGPesoBruto() != null) {
                            pesoProduto = consolrelog.getOmProduto().getGPesoBruto().doubleValue();
                        }
                        if (filtro.isPeca()) {
                            producaoRefugada = 0;
                            
                            if (isCancelado == false) {
	                            if (consolrelog.getPcsAutoProducaorefugada() != null) {
	                                producaoRefugada = consolrelog.getPcsAutoProducaorefugada().doubleValue();
	                            }
	
	                            if (consolrelog.getPcsManuProducaorefugada() != null) {
	                            	producaoRefugada = producaoRefugada + consolrelog.getPcsManuProducaorefugada().doubleValue();
	                            }
                            }
                            
                        } else if (filtro.getUnidMedida().equals("kilo")) {
                            producaoRefugada = (pesoProduto * qtdPcsRefugada) / KG;
                        } else if (filtro.getUnidMedida().equals("tonelada")) {
                            producaoRefugada = (pesoProduto * qtdPcsRefugada) / TON;
                        }

                        //if (qtdPcsRefugada > 0) {
	                        RelatorioIndiceRefugoDTO item = mapRelatorio.get(chave);
	                        if (item == null) {
	                            item = new RelatorioIndiceRefugoDTO();
	                            item.setMaquina(maquina);
	                            item.setProduto(produto);
	                            item.setRefugo(refugo);
	                            item.setQtdRefugada(producaoRefugada);
	                            mapRelatorio.put(chave, item);
	                         } else {
	                            double novaQtdRefugada =  producaoRefugada + item.getQtdRefugada();
	                            item.setQtdRefugada(novaQtdRefugada);
	                            item.setRefugo(refugo);
	                         }
                        //}
                    }
                }
            }
        }
	}

	private List<DwConsolid> getConsulta(FiltroRelatorioIndiceDiarioDTO filtro) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.omPt pt");
		q.append("JOIN consolid.dwTurno turno");
		q.append("JOIN consolid.dwConsols consol");
		q.append("JOIN consol.dwConsolprs consolpr");
		q.append("JOIN consolid.dwFolha folha"); //q.append("LEFT JOIN consolid.dwFolha folha");
		q.append("LEFT JOIN folha.dwFolharaps folharap");
		q.append("LEFT JOIN folharap.dwRap rap");
		q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
		q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta gpferramenta");
		q.append("LEFT JOIN consol.dwConsolres consolre");
		q.append("LEFT JOIN consolre.dwConsolreocos consolreoco");
		q.append("LEFT JOIN consolreoco.dwConsolrelog consolrelog");
		q.append("LEFT JOIN consolrelog.omProduto produto");
		q.append("LEFT JOIN consolrelog.dwTRefugo refugo");
		q.append("LEFT JOIN pt.omObjs obj");
		q.append("LEFT JOIN obj.omGtByIdGt gt");
		q.append("WHERE consolid.tpId = :tpId");
		q.append("AND consolid.stAtivo IS NULL");
		
		if (filtro.getDt_inicio() != null && filtro.getDt_final() != null) {
			q.append("AND consolid.dtReferencia BETWEEN :dataInicio AND :dataFim");
		}

		if (filtro.getOmpt() != null) {
			q.append("AND pt.idPt = :idPt");
		}

		if (filtro.getOmgt() != null) {
			q.append("AND gt.idGt = :idgt");
		}

		if (filtro.getDwRap() != null) {
			q.append("AND rap.cdRap = :cdrap");
		}

		if (filtro.getDwGrupoFerramenta() != null) {
			q.append("AND gpferramenta.idGrupoFerramenta = :idgpRap");
		}

		if (filtro.getTurnoDTO() != null) {
			q.append("AND turno.idTurno = :idturno");
		} else {
			q.append("AND consolid.dwTurno.idTurno != 1");
		}

		q.defineParametro("tpId", (byte) 1);

		if (filtro.getDt_inicio() != null && filtro.getDt_final() != null) {
			q.defineParametroData("dataInicio", filtro.getDt_inicio());
			q.defineParametroData("dataFim", DataHoraRN.getDataHora235959(filtro.getDt_final()));
		}

		if (filtro.getTurnoDTO() != null) {
			q.defineParametro("idturno", filtro.getTurnoDTO().getTurno().getIdTurno());
		}

		if (filtro.getOmpt() != null) {
			q.defineParametro("idPt", filtro.getOmpt().getIdPt());
		}

		if (filtro.getOmgt() != null) {
			q.defineParametro("idgt", filtro.getOmgt().getIdGt());
		}

		if (filtro.getDwRap() != null) {
			q.defineParametro("cdrap", filtro.getDwRap().getCdRap());
		}

		if (filtro.getDwGrupoFerramenta() != null) {
			q.defineParametro("idgpRap", filtro.getDwGrupoFerramenta().getIdGrupoFerramenta());
		}

		List<DwConsolid> retorno = q.list();
		
		return retorno;
	}

}
