package idw.model.rn.detalhemonitorizacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolmedparamlog;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmPt;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroGraficoDetalhePtDTO;
import idw.webservices.dto.GraficoDetalhePtFornoDTO;

public class DetalheMonitorizacaoPTFornoRN  extends AbstractRN<DAOGenerico> {

	public DetalheMonitorizacaoPTFornoRN() {
		super(new DAOGenerico());
	}
	
	public DetalheMonitorizacaoPTFornoRN(DAOGenerico dao) {
		super(dao);
	}


	public GraficoDetalhePtFornoDTO getGraficoPtForno(FiltroGraficoDetalhePtDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "DetalheMonitorizacaoPTFornoRN.getGraficoPtForno");
		log.info( idLog , 0, "DetalheMonitorizacaoPTFornoRN.getGraficoPtForno filtro usado:" + filtro.toString());
		
		// inciializar retorno GraficoDetalhePtFornoDTO
		GraficoDetalhePtFornoDTO retorno = new GraficoDetalhePtFornoDTO();
		// Consultar tabela DwConsolmedparamlog
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select distinct a");
		q.append("from DwConsolmedparamlog a");
		q.append("join a.dwConsolParammeds b");
		q.append("join b.dwConsolParam c");
		q.append("join c.dwConsol d");
		q.append("join d.dwConsolid e");
		q.append("join e.omPt ompt");
		q.append("where a.dthrMedicao between :inicio and :fim");
		q.append("and ompt.cdPt = :cdpt");
		if (filtro.getTpId() != null && filtro.getTpId().longValue() > 0l)
			q.append("and c.dwFtParam.idFtParam = :idftparam");
		
		Date dtReferenciaFinal = DataHoraRN.adicionaMinutosNaData(filtro.getDtReferencia(), 60);
		q.defineParametroTimestamp("inicio", filtro.getDtReferencia());
		q.defineParametroTimestamp("fim", dtReferenciaFinal);
		q.defineParametro("cdpt", filtro.getOmPt().getCdPt());
		q.defineParametro("idftparam", filtro.getTpId().longValue());
		
		List<DwConsolmedparamlog> lista = q.list();
		
		retorno.setListaDwConsolMedParamLog(new ArrayList<DwConsolmedparamlog>());
		for (DwConsolmedparamlog pojo : lista) {
			retorno.getListaDwConsolMedParamLog().add(pojo.clone(false));
		}
		
		log.mostrarAvaliacaoCompleta();
		return retorno;
	}
	
	/*
	 * Alessandre: em 11-8-14 comentei todo o metodo e criei um novo com a ideia de otimizar a consulta
	public GraficoDetalhePtFornoDTO getGraficoPtForno(FiltroGraficoDetalhePtDTO filtro) {

		GraficoDetalhePtFornoDTO retorno = new GraficoDetalhePtFornoDTO();
		retorno.setListaDwConsolId(new ArrayList<DwConsolid>());
		retorno.setListaDwConsolMedParamLog(new ArrayList<DwConsolmedparamlog>());

		List<DwConsolid> listaDwconsolidRetorno = new ArrayList<DwConsolid>();
		List<DwConsolmedparamlog> listaDwconsolmedparamlogRetorno = new ArrayList<DwConsolmedparamlog>();

		Byte tpId = (filtro.getTpId() == null ? DwConsolidTemplate.TpId.TURNO.getValue() : filtro.getTpId());
		
		if(filtro.getIdCp() != null){
			filtro.setPpCp(new PpCp());
			filtro.getPpCp().setIdCp(filtro.getIdCp());
		}
		
		List<DwConsolid> listadwconsolid = this.getDwConsolid(null, tpId,
				filtro.getOmPt(), filtro.getPpCp(), filtro.getDwTurno(),
				filtro.getDwTParada(), filtro.getDtReferencia(),
				filtro.getDtReferenciaInicial(), filtro.getDtReferenciaFinal(),
				filtro.getDthrIturno(), filtro.getDthrFturno(),
				filtro.getDthrIhora(), filtro.getDthrFhora(),
				false, false, false, false, null, false, false, false); // filtra a lista de DwConsolid

		if (listadwconsolid != null) { // verifica se possui lista de DwConsolId do filtro passado como parametro
			
			for (DwConsolid dwconsolid : listadwconsolid) { // percorre lista de dwconsolid
				for (DwConsol dwconsol : dwconsolid.getDwConsols()) { // percorre lista de dwconsol
					MapQuery query = new MapQuery(getDao().getSession());

					query.append("SELECT dwconsolmedparam FROM DwConsolmedparam dwconsolmedparam");
					query.append("WHERE dwconsolmedparam.dwConsol.idConsol = :idConsol");
					query.setMaxResults(100);

					if (dwconsol.getIdConsol() != 0) { // verifica se o idConsol é diferente de ZERO
						query.defineParametro("idConsol",dwconsol.getIdConsol());
					}

					List<DwConsolmedparam> queryListaDwConsolmedparam = new ArrayList<DwConsolmedparam>();
					queryListaDwConsolmedparam = query.list(); // obtem a lista de DwConsolmedparam do query

					// verifica se possui lista de DwConsolmedparam
					if (queryListaDwConsolmedparam != null) {
						
						// percorre a lista de DwConsolmedparam
						for (DwConsolmedparam dwconsolmedparam : queryListaDwConsolmedparam) {
							
							 // compara se o IdFtParam é igual a 5 (valor correspondente temperatura)
							if (DwFtParamTemplate.Type.TEMPERATURA.equals(dwconsolmedparam.getDwFtParam().getIdFtParam())) {

								// Pesquisa apenas as ultimas 100 ocorrencias
								MapQuery q = new MapQuery(getDaoSession());
								q.append("select a");
								q.append("from DwConsolmedparamoco a");
								q.append("where a.dwConsolmedparam = :dwconsolmedparam");
								q.append("order by a.idConsolmedparamoco desc");
								q.setMaxResults(50);
								q.defineParametro("dwconsolmedparam", dwconsolmedparam);
								
								List<DwConsolmedparamoco> listaoco = q.list();

								// percorre a lista de ocorrencia do DwConsolmedparam
								for (DwConsolmedparamoco dwconsolmedparamoco : listaoco) {
									
									// se o ID do DwConsolmedparam que tem o IdFtParam igual 5 for igual ao ID do Dwconsolmedparam da lista de ocorrencias
									if (dwconsolmedparamoco.getDwConsolmedparam().getIdConsolmedparam().equals(dwconsolmedparam.getIdConsolmedparam())) {
										// adiciona DwConsolmedparamlog na lista p retorno
										listaDwconsolmedparamlogRetorno.add(dwconsolmedparamoco.getDwConsolmedparamlog().clone(true));
									}
								}

							}
						}
					}
				}
				
				//trecho para fazer o clone apenas das informacoes necessarias para a leitura dos limites de temperatura (DwFolhamedtemphorcfgs)
				DwConsolid consolId = dwconsolid.clone(false);
				consolId.setDwFolha(dwconsolid.getDwFolha().clone(false)); //realiza clone do dwFolha relacionado com o dwconsolid consultado no banco
				consolId.getDwFolha().setDwFolhamedtemps(new HashSet<idw.model.pojos.DwFolhamedtemp>(0));
				
				//percorre os objetos DwFolhamedtemps relacionado com dwfolha
				for(DwFolhamedtemp folhamedtemp : dwconsolid.getDwFolha().getDwFolhamedtemps()){
					DwFolhamedtemp novoFolhaMedTemp = folhamedtemp.clone(false); //realiza clone do folhamedtemp
					novoFolhaMedTemp.setDwFolhamedtemhors(new HashSet<idw.model.pojos.DwFolhamedtemhor>(0));
					
					//percorre os objetos DwFolhamedtemhors relacionado com DwFolhamedtemp
					for(idw.model.pojos.DwFolhamedtemhor folhamedtemhor : folhamedtemp.getDwFolhamedtemhors()){
						idw.model.pojos.DwFolhamedtemhor novoFolhaMedTempHor = folhamedtemhor.clone(false); //realiza clone do folhamedtemhor
						novoFolhaMedTempHor.setDwFolhamedtemphorcfgs(new HashSet<idw.model.pojos.DwFolhamedtemphorcfg>(0));
						
						//percorre os objetos DwFolhamedtemhorcfgs relacionado com DwFolhamedtemhor
						for(idw.model.pojos.DwFolhamedtemphorcfg folhamedtemphorcfg : folhamedtemhor.getDwFolhamedtemphorcfgs()){
							//adiciona o novo objeto DwFolhamedtemphorcfg
							novoFolhaMedTempHor.getDwFolhamedtemphorcfgs().add(folhamedtemphorcfg.clone(false)); //realiza clone do folhamedtemphorcfg
						}
						
						//adiciona o novo objeto DwFolhamedtemhor
						novoFolhaMedTemp.getDwFolhamedtemhors().add(novoFolhaMedTempHor);
					}
					//adiciona o objeto DwFolhamedtemps com o clone dos objetos necessarios para leitura dos limites de temperatura
					consolId.getDwFolha().getDwFolhamedtemps().add(novoFolhaMedTemp);
				}
				//adiciona o dwconsolId no objeto de retorno
				listaDwconsolidRetorno.add(consolId);
//				listaDwconsolidRetorno.add(dwconsolid.clone(true)); // adiciona o dwconsolid na lista para retorno
			}
			
		}

		// adiciona as lista no objeto para retorno
		if (listaDwconsolidRetorno != null) {
			retorno.getListaDwConsolId().addAll(listaDwconsolidRetorno);
		}

		if (listaDwconsolmedparamlogRetorno != null) {
			//trecho para ordenar lista de medicoes de temperatura
			Collections.sort(listaDwconsolmedparamlogRetorno,new Comparator<DwConsolmedparamlog>() {
				@Override
				public int compare(DwConsolmedparamlog o1,DwConsolmedparamlog o2) {
//					return o1.getIdConsolmedparamlog().compareTo(o2.getIdConsolmedparamlog()); //ordena lista de forma crescente pelo id
//					return o1.getDthrMedicao().compareTo(o2.getDthrMedicao()); //ordena lista de forma crescente pela data de medicao
					return o2.getDthrMedicao().compareTo(o1.getDthrMedicao()); //ordena lista de forma decrescente pela data de medicao
				}
			});

//			retorno.getListaDwConsolMedParamLog().addAll(listaDwconsolmedparamlogRetorno);
			
			int qtdAmostrasTotal = 100; //setando quantidade maxima de temperaturas para o grafico
			
			//verifica se a quantidade de temperatura e maior que a quantidade de amostrar total
			if(listaDwconsolmedparamlogRetorno.size() > qtdAmostrasTotal){	
				//percorre a lista de temperaturas e adiciona apenas a quantidade maxima para o grafico
				for(int i=0; i<qtdAmostrasTotal; i++){
					retorno.getListaDwConsolMedParamLog().add(listaDwconsolmedparamlogRetorno.get(i));
				}
			}else{ //caso a quantidade de temperaturas lida seja menor ou igual adiciona toda lista
				retorno.getListaDwConsolMedParamLog().addAll(listaDwconsolmedparamlogRetorno); 
			}
		}

		return retorno;
	}	 */



	/**
	 * Pega a lista de DwConsolmedparam, DwConsolid, DwConsoolmedparamlog,
	 * DwFolhamedtemhor, DwFolhamedtemphorcfg da máquina forno selecionada na
	 * monitoriza��oo, para gerar grafico de temperaturas
	 * 
	 * @param filtro
	 * @return Objeto GraficoDetalhePtFornoDTO com as lista citadas a cima
	 */
	public GraficoDetalhePtFornoDTO getGraficoPtFornoAndroid(Long idpt,
			Long idturno, String dtreferencia, Long idCp){
		FiltroGraficoDetalhePtDTO filtro = new FiltroGraficoDetalhePtDTO();
		OmPt ompt = null;
		DwTurno turno = null;

		try {
			ompt = this.getDao().findById(OmPt.class, idpt, false);
		} catch (Exception e) {
		}

		try {
			turno = this.getDao().findById(DwTurno.class, idturno, false);
		} catch (Exception e) {
		}

		filtro.setOmPt(ompt);
		filtro.setDwTurno(turno);
		filtro.setDtReferencia(dtreferencia != null ? DataHoraRN.stringToDate(
				dtreferencia, "dd/MM/yyyy") : null);
		filtro.setIdCp(idCp);
		return getGraficoPtForno(filtro);
		
	}
}
