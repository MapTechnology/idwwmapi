package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwRap;
import idw.model.pojos.OmProduto;
import idw.model.pojos.template.DwPeproTemplate;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroRelatorioProdRegulagemDTO;
import idw.webservices.dto.MaquinaParRegulagemDTO;
import idw.webservices.dto.ParRegulagemDTO;
import idw.webservices.dto.ParadaRegulagemDTO;
import idw.webservices.dto.PostoProducaoRegulagemDTO;
import idw.webservices.dto.RelatorioParRegulagemDTO;
import idw.webservices.dto.RelatorioProducaoRegulagemDTO;
import ms.util.ConversaoTipos;

public class RelatorioProdRegulagemRN extends AbstractRN<DAOGenerico> {

	public static final int AGRUPAR_POR_POSTO = 1;
	public static final int AGRUPAR_POR_FERRAMENTA = 2;
	public static final int AGRUPAR_POR_PRODUTO = 3;

	public RelatorioProdRegulagemRN() {
		this(null);
	}

	public RelatorioProdRegulagemRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	// metodo principal para gerar relatorio
	public RelatorioProducaoRegulagemDTO getProdRegulagemDTO(FiltroRelatorioProdRegulagemDTO filtro) {
		   
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioProdRegulagemRN.getProdRegulagemDTO");
		log.info( idLog , 0, "RelatorioProdRegulagemRN.getProdRegulagemDTO filtro usado:" + filtro.toString());
		
		
		RelatorioProducaoRegulagemDTO retorno = new RelatorioProducaoRegulagemDTO();
		List<PostoProducaoRegulagemDTO> postosPeriodo = new ArrayList<>();
		
		List<DwConsolid> ids = realizarConsultaBanco(filtro, null);
		

		for (DwConsolid id : ids) {
			for (DwConsol consol : id.getDwConsols()) {
				
				List<DwConsolpa> listapas = new ArrayList<>();
				listapas.addAll(consol.getDwConsolpas());
				List<DwConsolid> listaid = new ArrayList<>();
				listaid.add(id);
				
				for (DwConsolpa consolpa : listapas) {
					
					for (OmProduto omproduto : id.getProdutos()) {
						
						PostoProducaoRegulagemDTO dto = new PostoProducaoRegulagemDTO();
						
						dto.setCdPosto(id.getOmPt().getCdPt());
						dto.setPosto(id.getOmPt().getCdPt());
						DwRap dwrap = id.getFerramenta();
						if (dwrap != null)
							dto.setFerramenta(dwrap.getCdRap());
						else
							dto.setFerramenta("-");

						
						
						if (omproduto != null) {
							dto.setCdProduto(omproduto.getCdProduto());
							dto.setProduto(omproduto.getCdProduto() + "-" + omproduto.getDsProduto());
						} else
							dto.setProduto("-");
						
						
						/* Verifica se ja existe. Se existir assume
						 * 
						 */
						boolean isExiste = false;
						for (PostoProducaoRegulagemDTO dtoAux : postosPeriodo) {
							if (dtoAux.equals(dto)) {
								dto = dtoAux; // .addParadas(dto.getParadas());
								isExiste = true;
								break;
							}
						}
												
						
						ParadaRegulagemDTO parada = new ParadaRegulagemDTO();
						parada.setParada(consolpa.getDwTParada().getCdTparada() + "-" + consolpa.getDwTParada().getDsTparada());
						if (consolpa.getSegAutoTempoparadaCp() != null)
							parada.setTempoParada(consolpa.getSegAutoTempoparadaCp().longValue());
						
						if (consolpa.getSegAutoTempoparadaSp() != null)
							parada.setTempoParada(consolpa.getSegAutoTempoparadaSp().longValue());
						
						parada.setTempoParadaHora(DataHoraRN.formatSegundosParaHHMMSS((int)parada.getTempoParada()));
						
						if (parada.getTempoParada() > 0l) {
							//System.out.println("add parada " + parada.getParada());
							dto.addParada(parada);
						}
						
						dto.setTotalProducaoEmRegulagem(0d);
						dto.setTotalProducaoEmRegulagemHora("0");
						
						// Total parada posto
						dto.setTotalTempoParada(500);
						dto.setTotalTempoParadaHora("1100");
						
						dto.addConsolPA(consolpa);

						/* Verifica se o dto ja esta na lista. Se estiver acumular valores
						 * 
						 */
						
						retorno.addParada(consolpa);
						
						if (isExiste == false) {
							postosPeriodo.add(dto);
						}
					}
				}
			}
		}		

		// Contabiliza a producao em regulagem para o dto
		ids = realizarConsultaBanco(filtro, DwPeproTemplate.Type.REGULAGEM.getId()); 
		
		// varre os periodos que tem regulagem
		for (DwConsolid id : ids) {
			for (DwConsol consol : id.getDwConsols()) {
				for (DwConsolpr consolpr : consol.getDwConsolprs()) {
					contabilizaProducaoEmRegulagem(filtro, retorno, postosPeriodo, id, consolpr);
				}
			} // end for dwconsol
		} // end for dwconsolid
		
		
		// Se o filtro estiver ativo pens os postos com regulgem devem ser presentdos
		if (filtro.getIsFiltrarApenasPostosComRegulagem() != null && filtro.getIsFiltrarApenasPostosComRegulagem()) {
			Iterator<PostoProducaoRegulagemDTO> ip = postosPeriodo.iterator();
			while (ip.hasNext()) {
				PostoProducaoRegulagemDTO dtoAux = ip.next();
				if (dtoAux.getTotalTempoParadaRegulagemComPesoNaEficiencia() <= 0 && dtoAux.getTotalTempoParadaRegulagemSemPesoNaEficiencia() <= 0)
					ip.remove();
			}
		}
		

		
		// Finaliza retorno com os dados processados
		retorno.setPostosPeriodo(postosPeriodo);
		
		
		/* Alessandre em 19-07-16 Nao encontrei onde os atributos abaixo sao usados no relatorio assim comentei
		retorno.setPeriodoTempoParadaComPesoNaEficiencia(0l);
		retorno.setPeriodoTempoParadaSemPesoNaEficiencia(1l);
		
		retorno.setPeriodoTempoParadaRegulagemComPesoNaEficiencia(3l);
);
		
		retorno.setPeriodoTempoParada(5l);
		
		*/
		
		// Abaixo variaveis com os totais do PERIODO
		// Soma os totais
		BigDecimal segTempoParadaCPTotal = BigDecimal.ZERO;
		BigDecimal segTempoParadaSPTotal = BigDecimal.ZERO;
		for (PostoProducaoRegulagemDTO dto : retorno.getPostosPeriodo() ) {
			segTempoParadaCPTotal = segTempoParadaCPTotal.add(new BigDecimal(dto.getTotalTempoParadaComPesoNaEficiencia()));
			segTempoParadaSPTotal = segTempoParadaSPTotal.add(new BigDecimal(dto.getTotalTempoParadaSemPesoNaEficiencia()));
		}
		retorno.setPeriodoTempoParadaComPesoNaEficienciaHora(DataHoraRN.formatSegundosParaHHMMSS(segTempoParadaCPTotal.intValue())); // Total parada com peso
		retorno.setPeriodoTempoParadaSemPesoNaEficienciaHora(DataHoraRN.formatSegundosParaHHMMSS(segTempoParadaSPTotal.intValue()));	 // Total parada sem peso
		retorno.setPeriodoTempoParadaRegulagemComPesoNaEficienciaHora(DataHoraRN.formatSegundosParaHHMMSS((int)retorno.getPeriodoTempoParadaRegulagemComPesoNaEficiencia())); // Tempo parada EM REGULAGEM com peso
		retorno.setPeriodoTempoParadaRegulagemSemPesoNaEficienciaHora(DataHoraRN.formatSegundosParaHHMMSS((int)retorno.getPeriodoTempoParadaRegulagemSemPesoNaEficiencia())); // Tempo parada EM REGULAGEM sem peso

		// O total abaixo � apresentado apenas quando o filtro para mostrar o detalhe das paradas est� ativo
		// esse total � a soma das paradas com peso e sem peso
		retorno.setPeriodoTempoParadaHora(DataHoraRN.formatSegundosParaHHMMSS(segTempoParadaCPTotal.add(segTempoParadaSPTotal).intValue())); // NAO LOCALIZADO
		
		if (filtro.isPeso())
			retorno.setPeriodoProducaoEmRegulagemHora(ConversaoTipos.converteParaStringComFormat(retorno.getPeriodoProducaoEmRegulagem(), 3)); // Total producao EM REGULAGEM
		else
			retorno.setPeriodoProducaoEmRegulagemHora(ConversaoTipos.converteParaStringComFormat(retorno.getPeriodoProducaoEmRegulagem(), 3)); // Total producao EM REGULAGEM

		/* No final reordenar a lista de postos + ferramentas
		*/
		Collections.sort(retorno.getPostosPeriodo(), new Comparator<PostoProducaoRegulagemDTO>() {
			@Override
			public int compare(PostoProducaoRegulagemDTO o1, PostoProducaoRegulagemDTO o2) {
				int retorno = o1.getPosto().compareTo(o2.getPosto());
				if (retorno == 0)
					retorno = o1.getFerramenta().compareTo(o2.getFerramenta());
				return retorno;
			}
		});
		log.mostrarAvaliacaoCompleta();
		return retorno;
	}

	private String getIdentificaoFolhaMaisRap(DwConsolid id, DwConsolpa consolpa) {
		// identificacao de folha + rap
		String folhaMaisRap = id.getDwFolha().getCdFolha();
		String raps = "";				

		for (DwFolharap fr : id.getDwFolha().getDwFolharaps()) {
			DwRap dwrap = fr.getDwRap();
			if (dwrap != null) {
				if (raps.equals("")) {
					raps = dwrap.getCdRap();
				} else {
					raps = raps + ", " + dwrap.getCdRap();
				}
			} 
		}
		
		if (! raps.equals("")) {
			folhaMaisRap = folhaMaisRap + " / " + raps;
		}
		
		//System.out.println("folhaMaisRap >> " + folhaMaisRap);
		return folhaMaisRap;
	}
	
	// metodo para recuperar somente as paradas ocorridas em regulagem
	public RelatorioParRegulagemDTO getParRegulagemDTO(FiltroRelatorioProdRegulagemDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioProdRegulagemRN.getParRegulagemDTO");
		log.info( idLog , 0, "RelatorioProdRegulagemRN.getParRegulagemDTO filtro usado:" + filtro.toString());
		
		RelatorioParRegulagemDTO retorno = new RelatorioParRegulagemDTO();
		retorno.setParadas(new ArrayList<ParRegulagemDTO>());

		class ParRegulagem {
			String rapsPar;
			String raps;
			String parada;
			Double segTempoPar;			
		}
		
		class MaquinaParRegulagem {
			String cdMaquina;
			Map<String, ParRegulagem> paradas = new HashMap<String, ParRegulagem>();
		}
		
		Map<String, MaquinaParRegulagem> mapMaquinas = new HashMap<String, MaquinaParRegulagem>();
		 
		
		List<DwConsolid> ids = realizarConsultaBanco(filtro, null);		
		for (DwConsolid id : ids) {
			String cdMaquina = id.getOmPt().getCdPt();
			
			for (DwConsol consol : id.getDwConsols()) {
				
				List<DwConsolpa> listapas = new ArrayList<>();
				listapas.addAll(consol.getDwConsolpas());
				List<DwConsolid> listaid = new ArrayList<>();
				listaid.add(id);
			
								
				for (DwConsolpa consolpa : listapas) {	
					if (consolpa.getDwTParada().getIsRegulagem() != null && consolpa.getDwTParada().getIsRegulagem()) {
					
						Double tempoPar = 0d;
						tempoPar += ( consolpa.getSegAutoTempoparadaCp() == null ? 0d : consolpa.getSegAutoTempoparadaCp().doubleValue() );   
						tempoPar += ( consolpa.getSegManuTempoparadaCp() == null ? 0d : consolpa.getSegManuTempoparadaCp().doubleValue() );
						tempoPar += ( consolpa.getSegAutoTempoparadaSp() == null ? 0d : consolpa.getSegAutoTempoparadaSp().doubleValue() );
						tempoPar += ( consolpa.getSegManuTempoparadaSp() == null ? 0d : consolpa.getSegManuTempoparadaSp().doubleValue() );
						
						String folhaMaisRap = getIdentificaoFolhaMaisRap(id, consolpa);
						String parada = consolpa.getDwTParada().getCdTparada() + " " + consolpa.getDwTParada().getDsTparada();
						String keyRapPar = folhaMaisRap + "..." + parada;
	
						if (mapMaquinas.containsKey(cdMaquina)) {
							MaquinaParRegulagem maquinaReg = mapMaquinas.get(cdMaquina);						
							Map<String, ParRegulagem> paradasReg = maquinaReg.paradas;
							
							if (paradasReg.containsKey(keyRapPar)) {
								Double tempo = mapMaquinas.get(cdMaquina).paradas.get(keyRapPar).segTempoPar;
								mapMaquinas.get(cdMaquina).paradas.get(keyRapPar).segTempoPar = tempo + tempoPar;
								
							} else {
								ParRegulagem paradaReg = new ParRegulagem();
								paradaReg.raps = folhaMaisRap;
								paradaReg.parada = parada;
								paradaReg.rapsPar = keyRapPar;
								paradaReg.segTempoPar = tempoPar;
								
								paradasReg.put(paradaReg.rapsPar, paradaReg);
															
								maquinaReg.paradas = paradasReg;
								
								mapMaquinas.put(cdMaquina, maquinaReg);							
							}
							
						} else {
							Map<String, ParRegulagem> paradasReg = new HashMap<String, ParRegulagem>();
							
							ParRegulagem paradaReg = new ParRegulagem();
							paradaReg.raps = folhaMaisRap;
							paradaReg.parada = parada;
							paradaReg.rapsPar = keyRapPar;
							paradaReg.segTempoPar = tempoPar;
							
							paradasReg.put(paradaReg.rapsPar, paradaReg);
							
							MaquinaParRegulagem maquinaReg = new MaquinaParRegulagem();
							maquinaReg.cdMaquina = cdMaquina;
							maquinaReg.paradas = paradasReg;
							
							mapMaquinas.put(cdMaquina, maquinaReg);
						}
					}
				}				
			}
		}		

		List<MaquinaParRegulagemDTO> listaMaq = new ArrayList<MaquinaParRegulagemDTO>();
		
		Set<String> keysMaq = mapMaquinas.keySet();
		for (String keyMaq : keysMaq) {			
			MaquinaParRegulagemDTO maquina = new MaquinaParRegulagemDTO();
			maquina.setMaquina(mapMaquinas.get(keyMaq).cdMaquina);
			maquina.setParadas(new ArrayList<ParRegulagemDTO>());
			maquina.setSegTempoParMaq(0d);
			
			Set<String> keysPar = mapMaquinas.get(keyMaq).paradas.keySet();
			for (String keyPar: keysPar) {
				ParRegulagemDTO par = new ParRegulagemDTO();
				par.setMaquina(maquina.getMaquina());
				par.setParada(mapMaquinas.get(keyMaq).paradas.get(keyPar).parada);
				par.setRaps(mapMaquinas.get(keyMaq).paradas.get(keyPar).raps);
				par.setSegTempoPar(mapMaquinas.get(keyMaq).paradas.get(keyPar).segTempoPar);
				par.setTempoPar(DataHoraRN.getSegundosParaHoraFormata(par.getSegTempoPar().intValue()));
				
				maquina.setSegTempoParMaq(maquina.getSegTempoParMaq() + par.getSegTempoPar());
				maquina.getParadas().add(par);
			}

			maquina.setTempoParMaq(DataHoraRN.getSegundosParaHoraFormata(maquina.getSegTempoParMaq().intValue()));
			for (ParRegulagemDTO par : maquina.getParadas()) {
				par.setTempoParMaq(maquina.getTempoParMaq());
			}
			
			
			listaMaq.add(maquina);
		}
		
		
		Comparator<ParRegulagemDTO> comparatorMaquina = new Comparator<ParRegulagemDTO>() {
			@Override
			public int compare(ParRegulagemDTO o1, ParRegulagemDTO o2) {				
				return (o1.getMaquina() + o1.getRaps() + o1.getParada()).compareTo((o2.getMaquina() + o2.getRaps() + o2.getParada()));
			}
		};

		for (MaquinaParRegulagemDTO maq : listaMaq) {
			retorno.getParadas().addAll(maq.getParadas());			
		}
		
		Collections.sort(retorno.getParadas(), comparatorMaquina);
		
		log.mostrarAvaliacaoCompleta();

		return retorno;
	}
	
	
	private void contabilizaProducaoEmRegulagem(
			FiltroRelatorioProdRegulagemDTO filtro,
			RelatorioProducaoRegulagemDTO retorno, 
			List<PostoProducaoRegulagemDTO> postosPeriodo, 
			DwConsolid id,
			DwConsolpr consolpr) {
		/*
		 * Verifica se o dto ja esta na lista. Se estiver acumular valores
		 * 
		 */
		for (PostoProducaoRegulagemDTO dto : postosPeriodo) {

			// Verifica se o dtoAux corresponde ao posto, produto e ferramenta de id e consolpr
			if (dto.getCdPosto().contains(id.getOmPt().getCdPt()) && dto.getCdProduto().contains(consolpr.getOmProduto().getCdProduto())) {

				BigDecimal producaoBruta = BigDecimal.ZERO;

				if (filtro.isPeso()) {
					if (filtro.getTipoPeso().equals("kg")) {
						BigDecimal producaoKg = consolpr.getOmProduto().getGPesoBruto();
						// Se o peso tiver sido definido entao calcular
						if (producaoKg != null) {
							producaoKg = producaoKg.divide(new BigDecimal(1000));
							producaoKg = producaoKg.multiply(consolpr.getPcsProducaoBruta());
							producaoBruta = producaoKg;
						}
					} else {
						BigDecimal producaoTn = consolpr.getOmProduto().getGPesoBruto();
						// Se o peso tiver sido definido entao calcular
						if (producaoTn != null) {
							producaoTn = producaoTn.divide(new BigDecimal(1000)); // Kg
							producaoTn = producaoTn.divide(new BigDecimal(1000)); // Tn
							producaoTn = producaoTn.multiply(consolpr.getPcsProducaoBruta());
							producaoBruta = producaoTn;
						}
					}
				} else {
					producaoBruta = consolpr.getPcsProducaoBruta();
				}

				if (producaoBruta != null) {
					if (filtro.isPeso()) {
						dto.setTotalProducaoEmRegulagem(dto.getTotalProducaoEmRegulagem() + producaoBruta.doubleValue());
					} else {
						dto.setTotalProducaoEmRegulagem(dto.getTotalProducaoEmRegulagem() + producaoBruta.doubleValue());
					}
				}

				if (filtro.isPeso()) {
					dto.setTotalProducaoEmRegulagemHora(ConversaoTipos.converteParaStringCasasOpcionais(dto.getTotalProducaoEmRegulagem(), 3));
				} else {
					dto.setTotalProducaoEmRegulagemHora(ConversaoTipos.converteParaStringCasasOpcionais(dto.getTotalProducaoEmRegulagem(), 3));
				}

				if (producaoBruta != null) {
					if (filtro.isPeso()) {
						retorno.setPeriodoProducaoEmRegulagem(retorno.getPeriodoProducaoEmRegulagem() + producaoBruta.doubleValue());
					} else {
						retorno.setPeriodoProducaoEmRegulagem(retorno.getPeriodoProducaoEmRegulagem() + producaoBruta.doubleValue());
					}
				}
			}
		}
	}		



	// Pesquisa os dados de paradas normais
	private List<DwConsolid> realizarConsultaBanco(FiltroRelatorioProdRegulagemDTO filtro, Long idPepro) {

		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN fetch consolid.dwConsols consol");
		q.append("join fetch consol.dwConsolprs consolpr");
		q.append("JOIN consolid.omPt pt");
		q.append("JOIN consolid.ppCp cp");
		q.append("JOIN consolid.dwFolha folha");
		q.append("left join pt.omObjs omobj");
		q.append("left JOIN folha.dwFolharaps folharap");
		q.append("left JOIN folharap.dwRap rap");
		q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
		q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta gpferramenta");
		q.append("WHERE consolid.tpId = :tpId");
		
		if (idPepro != null)
			q.append("and consolid.dwPepro.idPepro = :idpepro");

		if (filtro.getPeriodoInicial() != null
				&& filtro.getPeriodoFinal() != null) {
			q.append("AND consolid.dtReferencia BETWEEN :dataincial and :datafinal");
		}

		if (filtro.getTurnoDTO() != null) {
			q.append("AND consolid.dwTurno.idTurno = :idturno");
		}
		if (filtro.getOmpt() != null) {
			q.append("AND consolid.omPt.cdPt = :cdpt");
		} else if (filtro.getOmgt() != null) {
			q.append("AND omobj.omGtByIdGt.idGt = :idGt");
		}
		if (filtro.getRap() != null) {
			q.append("AND rap.idRap = :idrap");
		}
		if (filtro.getGrupoFerramenta() != null) {
			q.append("AND gpferramenta.idGrupoFerramenta = :idGpRap");
		}

		q.defineParametro("tpId", (byte) 1);
		q.defineParametro("idpepro", idPepro);

		// q.append("AND consolid.dwPepro.idPepro = :idpepro");
		// q.defineParametro("idpepro", DwPeproTemplate.Type.REGULAGEM.getId());

		if (filtro.getPeriodoInicial() != null
				&& filtro.getPeriodoFinal() != null) {
			q.defineParametroTimestamp("dataincial", filtro.getPeriodoInicial());
			q.defineParametroTimestamp("datafinal",
					DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));
		}
		if (filtro.getTurnoDTO() != null) {
			q.defineParametro("idturno", filtro.getTurnoDTO().getTurno()
					.getIdTurno());
		}
		if (filtro.getOmgt() != null) {
			q.defineParametro("idGt", filtro.getOmgt().getIdGt());
		} else if (filtro.getOmpt() != null) {
			q.defineParametro("cdpt", filtro.getOmpt().getCdPt());
		}
		if (filtro.getGrupoFerramenta() != null) {
			q.defineParametro("idGpRap", filtro.getGrupoFerramenta()
					.getIdGrupoFerramenta());
		} else if (filtro.getRap() != null) {
			q.defineParametro("idrap", filtro.getRap().getIdRap());
		}

		return q.list();
	}

}
