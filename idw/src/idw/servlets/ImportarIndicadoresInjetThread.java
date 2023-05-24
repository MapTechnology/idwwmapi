package idw.servlets;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import idw.idwws.FiltroMaquinaInjetDTO;
import idw.idwws.IdwwsProxy;
import idw.idwws.MaquinaInjetDTO;
import idw.idwws.MaquinasInjetDTO;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwRt;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgurl;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwPeproTemplate;
import idw.model.pojos.template.DwRtTemplate;
import idw.model.rn.ConfiguracaoRN;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.PTRN;
import idw.model.rn.TurnoRN;
import idw.util.FormulasInjet;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.util.UtilsString;
import idw.webservices.dto.PtDTO;
import idw.webservices.dto.TurnoAtualDTO;
import idw.webservices.dto.TurnoDTO;
import idw.webservices.dto.TurnosDTO;

public class ImportarIndicadoresInjetThread extends Thread {

	private IdwLogger log = null;
	private boolean isThreadExecutando = true;
	private final int DELAY_AUTO_UPDATE = 3600000;

	public ImportarIndicadoresInjetThread() {
		this.setName("ImportarIndicadoresInjetThread-" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(DataHoraRN.getDataHoraAtual()));
	}

	/*
	public static void main(String[] args) {
		idw.model.rn.injet.dto.FiltroMaquinaInjetDTO filtro = new idw.model.rn.injet.dto.FiltroMaquinaInjetDTO();
		filtro.setCdMaquina("|00079");
		filtro.setCdTurno("000001");
		filtro.setData(DataHoraRN.getDataHoraAtual());
		filtro.setDtFinal(DataHoraRN.getDataHoraAtual());
		filtro.setIsProcessarTempoReal(true);
		//IdwwsProxy ws = new IdwwsProxy("http://170.10.0.207:8080/idw/idwws");

		idw.model.rn.injet.dto.MaquinasInjetDTO dto = null;
		
			dto = IdwFacade.getInstancia().getIndicadoresInjet(filtro);

		//MaquinaInjetDTO arrayMaq[] = dto.getMaquinas();
		//List<MaquinaInjetDTO> listaMaquinaInjetDTO = Arrays.asList( arrayMaq );
	
		for (idw.model.rn.injet.dto.MaquinaInjetDTO maquinaInjetDTO : dto.getMaquinas()) {
			if (maquinaInjetDTO.getCorFrente() == idw.model.rn.injet.dto.MaquinaInjetDTO.FRENTE_PARADA) {
				
			}
		}
	}*/

	/*
	public static void main(String[] args) {
		FiltroMaquinaInjetDTO filtro = new FiltroMaquinaInjetDTO();
		filtro.setCdMaquina("|00016");
		filtro.setCdTurno("000002");
		filtro.setData(DataHoraRN.toCalendar(DataHoraRN.getData(2015, 7, 5)));
		filtro.setDtFinal(filtro.getData());
		filtro.setIsProcessarTempoReal(true);
		IdwwsProxy ws = new IdwwsProxy("http://TTAMSRV01:9191/idw/idwws");
		//IdwwsProxy ws = new IdwwsProxy("http://localhost:8080/idw/idwws");

		MaquinasInjetDTO dto = null;
		
		try {
			dto = ws.getIndicadoresInjet(filtro);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MaquinaInjetDTO arrayMaq[] = dto.getMaquinas();
		List<MaquinaInjetDTO> listaMaquinaInjetDTO = new ArrayList<>();
		if (arrayMaq != null)
			listaMaquinaInjetDTO = Arrays.asList( arrayMaq );
	
		for (MaquinaInjetDTO maquinaInjetDTO : listaMaquinaInjetDTO) {
			if (maquinaInjetDTO.getCorFrente() == idw.model.rn.injet.dto.MaquinaInjetDTO.FRENTE_PARADA) {
				
			}
			System.out.println("Qtde refugada=" + maquinaInjetDTO.getMaquinaTotalDTO().getProducaoRefugadaUnidade());
		}
		System.out.println("fim");
	}
	
	

	public static void main(String[] args) {
		idw.model.rn.injet.dto.FiltroMaquinaInjetDTO filtro = new idw.model.rn.injet.dto.FiltroMaquinaInjetDTO();
		filtro.setCdMaquina("|00001");
		filtro.setCdTurno("000001");
		filtro.setData(DataHoraRN.getDataHoraAtual());
		filtro.setData(DataHoraRN.setAnoNaData(filtro.getData(), 2015));
		filtro.setData(DataHoraRN.setMesNaData(filtro.getData(), 9));
		filtro.setData(DataHoraRN.setDiaNaData(filtro.getData(), 20));
		filtro.setDtFinal(filtro.getData());
		filtro.setIsProcessarTempoReal(true);
		//IdwwsProxy ws = new IdwwsProxy("http://170.10.0.207:8080/idw/idwws");

		idw.model.rn.injet.dto.MaquinasInjetDTO dto = null;
		
		dto = IdwFacade.getInstancia().getIndicadoresInjet(filtro);

		//MaquinaInjetDTO arrayMaq[] = dto.getMaquinas();
		//List<MaquinaInjetDTO> listaMaquinaInjetDTO = Arrays.asList( arrayMaq );
		
		for (idw.model.rn.injet.dto.MaquinaInjetDTO maquinaInjetDTO : dto.getMaquinas()) {
			if (maquinaInjetDTO.getCorFrente() == idw.model.rn.injet.dto.MaquinaInjetDTO.FRENTE_PARADA) {
				
			}
		}
	}
	
	*/
	
	@Override
	public void run() {

		this.log = new IdwLogger("ImportarIndicadoresInjetThread");

		ConfiguracaoRN confRN = new ConfiguracaoRN();

		PTRN ptRN = new PTRN();

		FolhaRN folhaRN = new FolhaRN();

		ConsolidaRN consolRN = new ConsolidaRN();

		TurnoRN turnoRN = new TurnoRN();

		DwConsolid dwConsolid = new DwConsolid();
		List<Date> listaDatas = new ArrayList<Date>();

		while (isThreadExecutando) {
			try {
				confRN.iniciaConexaoBanco();
	
				ptRN.setDaoSession(confRN.getSession());
				folhaRN.setDaoSession(confRN.getSession());
				consolRN.setDaoSession(confRN.getSession());
				turnoRN.setDaoSession(confRN.getSession());
				TurnosDTO turnos = turnoRN.getTurnos();
	
				List<OmCfgurl> listaCfgurl = confRN.getCfgurls();
				List<PtDTO> listaPts = new ArrayList<PtDTO>();
	
				for (OmCfgurl cfgUrl : listaCfgurl) {
					List<OmPt> lista = ptRN.getPtsPorUrlConexao(cfgUrl);
					for (OmPt ompt : lista) {
						PtDTO dto = new PtDTO();
						dto.setPt(ompt);
						dto.setOmcfgurl(cfgUrl);
						listaPts.add(dto);
					}
				}

				OmCfg omcfg = Util.getConfigGeral(confRN.getSession());
				
				// Varre todos os PTs da fabrica remota
				for (PtDTO dtoPT : listaPts) {
					OmPt pt = dtoPT.getPt();
					dwConsolid = consolRN.getUltimoDwConsolidTurno(pt.getIdPt());
					Date dtReferenciaInicial = null;
					if (dwConsolid != null) {
						dtReferenciaInicial = dwConsolid.getDtReferencia();
					} else {
						dtReferenciaInicial = DataHoraRN.getDataHoraInicioMes(DataHoraRN.getDataHoraAtual());
					}
					dtReferenciaInicial = DataHoraRN.subtraiDiasDaData(DataHoraRN.getDataHoraAtual(), 2);
					dtReferenciaInicial = DataHoraRN.getDataSemHora(dtReferenciaInicial);
					
					listaDatas = DataHoraRN.getDatasNoPeriodo(dtReferenciaInicial, new Date());
					// Varre todos os turnos cadastrados no centralizador
					for (TurnoDTO turno : turnos.getTurnos()) {
						FiltroMaquinaInjetDTO filtro = new FiltroMaquinaInjetDTO();
						filtro.setCdMaquina(pt.getDepara());
						
						// O codigo do turno deve seguir o padrao do Injet
						filtro.setCdTurno(UtilsString.getZerosAEsquerda(turno.getTurno().getCdTurno(), 6));
						
						// Varre todas as datas de hoje dois dias atras
						for (Date dtReferencia : listaDatas) {
							if (dtoPT.getOmcfgurl().getUtc() != null) {
								XMLGregorianCalendar data = DataHoraRN.converteDateParaXMLCalendar(dtReferencia);
								data.setTimezone(dtoPT.getOmcfgurl().getUtc().intValue());

								filtro.setData(DataHoraRN.toCalendar(DataHoraRN.converteXMLCalendarParaDate(data)));
								filtro.setDtFinal(filtro.getData());
							} else {
								filtro.setData(DataHoraRN.toCalendar(dtReferencia));
								filtro.setDtFinal(DataHoraRN.toCalendar(dtReferencia));
							}
							
							
							
							log.info("Importando data " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtReferencia));
							filtro.setIsProcessarTempoReal(true);
							try {
								if (!confRN.getSession().isOpen()) {
									confRN.iniciaConexaoBanco();
									ptRN.setDaoSession(confRN.getSession());
									turnoRN.setDaoSession(confRN.getSession());
									consolRN.setDaoSession(confRN.getSession());
									folhaRN.setDaoSession(confRN.getSession());
								}
	
								OmPt omPt = new OmPt();
								omPt.setCdPt(pt.getCdPt());
								PtDTO ptDTO = ptRN.getOmPtPorIdOuCd(omPt);
	
								//aqui devo chamar o webservice
								IdwwsProxy ws = null;
								if (ptDTO.getPt().getUrlConexao().contains("http")) {
									ws = new IdwwsProxy(ptDTO.getPt().getUrlConexao() + "/idwws");
									log.info("chamou para " + ptDTO.getPt().getUrlConexao() + "/idwws");
								} else {
									ws = new IdwwsProxy("http://" + ptDTO.getPt().getUrlConexao() + "/idwws");
									log.info("chamou para http://" + ptDTO.getPt().getUrlConexao() + "/idwws");
								}
								MaquinasInjetDTO dto = ws.getIndicadoresInjet(filtro);
								MaquinaInjetDTO arrayMaq[] = dto.getMaquinas();
								log.info(filtro.getCdMaquina() + " - executou getIndicadoresInjet para turno " + filtro.getCdTurno() + " data " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtReferencia) );
								if (arrayMaq == null || arrayMaq.length <=0 ) {
									log.info("retornou vazio");
									continue;
								}
								log.info("Retornou registro = " + arrayMaq.length);

								List<MaquinaInjetDTO> listaMaquinaInjetDTO = Arrays.asList( arrayMaq );
								List<DwCalsem> dwCalsems = turnoRN.getCalendarioSemanalComTurnosIndefinidosParaPt(ptDTO.getPt(), dtReferencia);
								

								for (MaquinaInjetDTO maquinaInjetDTO : listaMaquinaInjetDTO) {
									if (maquinaInjetDTO.getProdutos().length <= 0) {
										log.info("Sem dados para maquina " + ptDTO.getPt().getCdPt() + " na data " + DataHoraRN.toStringDDMMYY(dtReferencia) );
										continue;
									}
									log.info("avaliando maquina " + maquinaInjetDTO.getCdMaquina() + " na turno " + filtro.getCdTurno() + " na data " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtReferencia));
									String cdProduto;
									try {
										cdProduto = maquinaInjetDTO.getProdutos(0).getCdProduto();
										if (cdProduto == null)
											cdProduto = "0";
									} catch (Exception e) {
										e.printStackTrace();
										cdProduto = "0";
									}
									log.info("size = " + maquinaInjetDTO.getProdutos().length + " obtendo PPCP do pt = " + ptDTO.getPt().getIdPt() + " op = " + maquinaInjetDTO.getNrop()+ "  cdProduto=" + cdProduto);
									PpCp ppCp = consolRN.obtemPpCp(log, 0, 0, ptDTO.getPt(), dwCalsems, maquinaInjetDTO.getNrop(), cdProduto, cdProduto, dtReferencia, omcfg, null);
		
									DwFolha folha = folhaRN.getDwFolhaAtiva(ppCp);
		
									TurnoAtualDTO turnoAtualDTO;
	
									try {
										turnoAtualDTO = turnoRN.getTurnoAtualDTOPassandoIdPtEDtTurnoECdTurno(omPt, dtReferencia, turno.getTurno().getCdTurno());
										log.info("dthrITurno = " + turnoAtualDTO.getDtHrITurno() + " para ompt.cdPt = " + omPt.getCdPt() + " dtReferencia=" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtReferencia) + " cdTurno = " + turno.getTurno().getCdTurno());
									} catch (IllegalStateException e) {
										e.printStackTrace();
										log.info("Nao encontrou o turno ", e);
										continue;
										
									}
									MsEvt msevt = new MsEvt();
									DwPepro pro = consolRN.getDao().findById(DwPepro.class, DwPeproTemplate.Type.NORMAL.getId(), false);
									msevt.setDwPepro(pro);
									consolRN.getDao().evict(msevt);
									dwConsolid = consolRN.obtemConsolIdTurno(log, 0, 0, ptDTO.getPt(), ppCp, folha, turnoAtualDTO, msevt.getDwPepro());
									DwRt dwrt = dwConsolid.getDwRt();
									
									if (maquinaInjetDTO.getIjtbinj().getStfuncionamento().equals("0")){
										dwrt.setStFuncionamento(DwRtTemplate.StFuncionamento.PARADA.getId());
										dwrt.setIsParadapeso(!maquinaInjetDTO.getParadaAtualUltimaParada().isParadaPesa());
									} else {
										dwrt.setStFuncionamento(DwRtTemplate.StFuncionamento.PRODUZINDO.getId());
										dwrt.setIsParadapeso(false);
									}
									
									
									log.info("Stfuncionamento de " + maquinaInjetDTO.getIjtbinj().getCdinjestendido() + ": " + maquinaInjetDTO.getIjtbinj().getStfuncionamento());
									
									if (
											maquinaInjetDTO.getIjtbinj() != null && 
											maquinaInjetDTO.getIjtbinj().getAguardandomolde() != null && 
											maquinaInjetDTO.getIjtbinj().getAguardandomolde().equals(BigDecimal.ONE))
										dwrt.setIsSemplanejamento(true);
									else
										dwrt.setIsSemplanejamento(false);
																	
									// Marcos Sardinha: 2015-07-30
									dwConsolid.setDthrIconsol(DataHoraRN.getDataHoraAtual());
									dwConsolid.setDthrFconsol(dwConsolid.getDthrIconsol());
									consolRN.getDao().makePersistent(dwConsolid);
									
									
									DwConsol consol = dwConsolid.getDwConsols().iterator().next();
		
									if (consol == null) {
										consol = new DwConsol();
										consol.setSegAutoTempoprodutivo(maquinaInjetDTO.getMaquinaTotalDTO().getTempoProdutivasSegundos());
										consol.setSegAutoTempoativo(maquinaInjetDTO.getMaquinaTotalDTO().getTempoAtivoSegundos());
										consol.setSegAutoTempocalendario(maquinaInjetDTO.getMaquinaTotalDTO().getTempoAtivoSegundos().add(maquinaInjetDTO.getMaquinaTotalDTO().getTempoParadaSemPesoSegundos()));
										
										
										consol.setSegAutoCicloprodutivo(maquinaInjetDTO.getMaquinaTotalDTO().getTempoCicloProdutivoSegundos());
										consol.setSegAutoCiclopadrao(maquinaInjetDTO.getMaquinaTotalDTO().getCicloPadrao());
										consol.setQtAutoCicloprodutivo(maquinaInjetDTO.getMaquinaTotalDTO().getQtInjNormal());
										consol.setPcsAutoProducaorefugada(maquinaInjetDTO.getMaquinaTotalDTO().getProducaoRefugadaUnidade());
										consol.setPcsAutoProducaobruta(maquinaInjetDTO.getMaquinaTotalDTO().getProducaoBrutaUnidade());
										
										// Marcos Sardinha: 2015-06-02
										consol.setSegAutoTempotrabalhado(maquinaInjetDTO.getMaquinaTotalDTO().getTempoTrabalhadoSegundos());
										maquinaInjetDTO.getMaquinaTotalDTO().setTempoRefugoSegundos(maquinaInjetDTO.getMaquinaTotalDTO().getTempoRefugoSegundos().divide(BigDecimal.ONE, 10, BigDecimal.ROUND_HALF_EVEN));
										consol.setSegAutoTemporefugadas(maquinaInjetDTO.getMaquinaTotalDTO().getTempoRefugoSegundos());
										
										// Marcos Sardinha: 2015-06-17
										consol.setQtAutoCicloPrevisto(maquinaInjetDTO.getMaquinaTotalDTO().getQtCiclosPrevistos());
										
										log.info("incluindo dwconsolid");
										consolRN.getDao().makePersistent(consol);
									} else {
										Float valor = maquinaInjetDTO.getMaquinaTotalDTO().getTempoProdutivasSegundos().floatValue();
										
										valor = FormulasInjet.formatarCasaDecimalDoFloat(valor);
										
										consol.setSegAutoTempoprodutivo(new BigDecimal(valor));
										consol.setSegAutoTempoativo(maquinaInjetDTO.getMaquinaTotalDTO().getTempoAtivoSegundos());
										consol.setSegAutoTempocalendario(maquinaInjetDTO.getMaquinaTotalDTO().getTempoAtivoSegundos().add(maquinaInjetDTO.getMaquinaTotalDTO().getTempoParadaSemPesoSegundos()));
										log.info("Alterando tcalendario para " + consol.getSegAutoTempocalendario() + " para maquina " + ptDTO.getPt().getCdPt() + " na data " + DataHoraRN.toStringDDMMYY(dtReferencia));
										log.info("TempoAtivo " + consol.getSegAutoTempoativo() + " TempoParadaSemPeso " + maquinaInjetDTO.getMaquinaTotalDTO().getTempoParadaSemPesoSegundos());
										consol.setSegAutoCicloprodutivo(maquinaInjetDTO.getMaquinaTotalDTO().getTempoCicloProdutivoSegundos());
										consol.setSegAutoCiclopadrao(maquinaInjetDTO.getMaquinaTotalDTO().getCicloPadrao());
										consol.setQtAutoCicloprodutivo(maquinaInjetDTO.getMaquinaTotalDTO().getQtInjNormal());
										consol.setPcsAutoProducaorefugada(maquinaInjetDTO.getMaquinaTotalDTO().getProducaoRefugadaUnidade());
										consol.setPcsAutoProducaobruta(maquinaInjetDTO.getMaquinaTotalDTO().getProducaoBrutaUnidade());
										
										// Marcos Sardinha: 2015-06-02
										consol.setSegAutoTempotrabalhado(maquinaInjetDTO.getMaquinaTotalDTO().getTempoTrabalhadoSegundos());
										maquinaInjetDTO.getMaquinaTotalDTO().setTempoRefugoSegundos(maquinaInjetDTO.getMaquinaTotalDTO().getTempoRefugoSegundos().divide(BigDecimal.ONE, 10, BigDecimal.ROUND_HALF_EVEN));
										consol.setSegAutoTemporefugadas(maquinaInjetDTO.getMaquinaTotalDTO().getTempoRefugoSegundos());
	
										// Marcos Sardinha: 2015-06-10
										consol.setQtAutoCicloPrevisto(maquinaInjetDTO.getMaquinaTotalDTO().getQtCiclosPrevistos());
										
										log.info("salvando dwconsolid");
										consolRN.getDao().makePersistent(consol);
									}
								}
							} catch (Exception e) {
								e.printStackTrace();
								log.info("Reiniciando a thread de importacao de indicadores do Injet", e);
							}
						}
					}
	
				}
	
				log.info("fim indicadores importacao");

				Thread.sleep(DELAY_AUTO_UPDATE);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Erro ", e);
			} finally {
				try {
					confRN.finalizaConexaoBanco();
				} catch (Exception e) {
					e.printStackTrace();
					log.info("Erro ", e);
				}
			}
		}
	}

	public void pararThread() {
		this.isThreadExecutando = false;
	}

}
