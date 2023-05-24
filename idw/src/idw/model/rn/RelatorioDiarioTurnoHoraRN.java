package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwTurno;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpPre;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.PpNec;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.util.IdwLogger;
import idw.webservices.dto.DadosRelatorioDTO;
import idw.webservices.dto.RelatorioDTO;
import idw.webservices.dto.RelatoriosDTO;
import idw.webservices.dto.TurnoDTO;
import idw.webservices.dto.TurnosDTO;

public class RelatorioDiarioTurnoHoraRN implements IDao{
	private DAOGenerico dao;
	private boolean isCalculaApont = false;
	private Date dateInicioApont;
	private Date dateFimApont;
	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}

	@Override
	public void iniciaConexaoBanco(Session sessao) {
		dao.iniciaSessao();
		dao.iniciaTransacao();
	}

	@Override
	public void finalizaConexaoBanco() {
		dao.finalizaTransacao();
		dao.finalizaSessao();
	}

	public RelatorioDiarioTurnoHoraRN() {
		if (dao == null) {
			dao = new DAOGenerico();
		}
	}
	
	public boolean isCalculaApont() {
		return isCalculaApont;
	}

	public void setCalculaApont(boolean isCalculaApont, Date apontI, Date apontF) {
		this.isCalculaApont = isCalculaApont;
		setDateInicioApont(apontI);
		setDateFimApont(apontF);
	}

	public DAOGenerico getDao() {
		return dao;
	}

	public void setDao(DAOGenerico dao) {
		this.dao = dao;
	}

	public Date getDateInicioApont() {
		return dateInicioApont;
	}

	public void setDateInicioApont(Date dateInicioApont) {
		this.dateInicioApont = dateInicioApont;
	}

	public Date getDateFimApont() {
		return dateFimApont;
	}

	public void setDateFimApont(Date dateFimApont) {
		this.dateFimApont = dateFimApont;
	}

	public RelatorioDiarioTurnoHoraRN(DAOGenerico dao) {
		this.dao = dao;
	}
	
	public DadosRelatorioDTO relatorioTurnoHora (Date rf){
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioDiarioTurnoHoraRN.relatorioTurnoHora");
		log.info( idLog , 0, "RelatorioDiarioTurnoHoraRN.relatorioTurnoHora filtro usado:" + rf.toString());

		DadosRelatorioDTO retorno = relatorioPlanejadoRealizado (rf,rf, true);
		
		log.mostrarAvaliacaoCompleta();
		
		return retorno;//relatorioPlanejadoRealizado (rf,rf, true);			
	
	}

	public DadosRelatorioDTO relatorioPlanejadoRealizado (Date dtInicio, Date dtFim){
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioDiarioTurnoHoraRN.relatorioPlanejadoRealizado");
		log.info( idLog , 0, "RelatorioDiarioTurnoHoraRN.relatorioPlanejadoRealizado filtro usado:" + dtInicio.toString() + ", " + dtFim.toString());
		
		DadosRelatorioDTO retorno = relatorioPlanejadoRealizado (dtInicio, dtFim, false);
		
		log.mostrarAvaliacaoCompleta();
		
		return retorno;//relatorioPlanejadoRealizado (dtInicio, dtFim, false);
	
	}
	
	public DadosRelatorioDTO relatorioPlanejadoRealizadoByProdutoFinal (Date dtInicio, Date dtFim, PpNec ppnec, boolean isCalculaHora, boolean isApont, Date iniApont, Date fimApont ){
		
		DadosRelatorioDTO retorno = new DadosRelatorioDTO();
		retorno.setListaRelatorios(new ArrayList<RelatoriosDTO>());
		CpRN cpRN = new CpRN();
		cpRN.iniciaConexaoBanco();
		
		this.isCalculaApont = isApont;
		this.dateInicioApont = iniApont;
		this.dateFimApont = fimApont;
		
		List<PpCp> listaCp = cpRN.pesquisarPpCpIntervaloDatasByProdutoFinal(dtInicio, dtFim, ppnec);
		TurnoRN turnoRn = new TurnoRN(this.dao);
		TurnosDTO turnos = turnoRn.getTurnos();
		turnos = eliminaTurnoInvalido(turnos);
		ordenaTurnos(turnos.getTurnos());
		
		for(PpCp cp: listaCp){
			
			DwCal cal = null;
			if (cp.getDwCal() == null){
				cal = pesquisarCal(cp);
			}else{
				cal = cp.getDwCal();
			}
			
			BigDecimal quantidadeCp = BigDecimal.valueOf(0);
			if(cal == null)
				continue;
			
			RelatoriosDTO relat = new RelatoriosDTO();
			relat.setPpcp(cp.clone());
			
			if((cp.getPpCpPresForIdCp() != null) && (!cp.getPpCpPresForIdCp().isEmpty())){
				relat.getPpcp().setPpCpPresForIdCp(new HashSet<PpCpPre>());
				for(PpCpPre cpPre: cp.getPpCpPresForIdCp()){
					PpCpPre cpPree = new PpCpPre();
					cpPre.setIdCppre(null);
					cpPree.setPpCpByIdCp(cpPre.getPpCpByIdCp().clone());
					relat.getPpcp().getPpCpPresForIdCp().add(cpPree);
				}
				
			}

			
			for (PpCpproduto prod: cp.getPpCpprodutos()){
				relat.setProduto(prod.getOmProduto().clone());
				quantidadeCp = prod.getPcsProducaoplanejada();
			}
			relat.setRel(preencherRelatorio(cp, relat, dtInicio, dtFim, cal, turnos, quantidadeCp, isCalculaHora));
			relat.getPpcp().setPasso(quantidadeCp);
//			relat.getProduto().setCdProduto(cp.getCdCp() + "( " + quantidadeCp +" )");
			retorno.getListaRelatorios().add(relat);
		}
		return retorno;
	}
	
	public DadosRelatorioDTO relatorioPlanejadoRealizado (Date dtInicio, Date dtFim, boolean isCalculaHora ){
		
		DadosRelatorioDTO retorno = new DadosRelatorioDTO();
		retorno.setListaRelatorios(new ArrayList<RelatoriosDTO>());
		
		CpRN cpRN = new CpRN();
		cpRN.iniciaConexaoBanco();
		
		// Alessandre: em 12-8-14 ao inves de pegar as ppcps diretamente, irei pegar as ppcps que estiveram em producao durante o periodo
		//List<PpCp> listaCp = cpRN.pesquisarPpCpIntervaloDatas(dtInicio, dtFim);
		List<PpCp> listaCp = cpRN.pesquisarPpCpQuePassaramNaData(dtInicio, dtFim);
		
		TurnoRN turnoRn = new TurnoRN(this.dao);
		TurnosDTO turnos = turnoRn.getTurnos();
		turnos = eliminaTurnoInvalido(turnos);
		ordenaTurnos(turnos.getTurnos());
		
		for(PpCp cp: listaCp){
			
			DwCal cal = null;
			if (cp.getDwCal() == null){
				cal = pesquisarCal(cp);
			}else{
				cal = cp.getDwCal();
			}
			
			BigDecimal quantidadeCp = BigDecimal.valueOf(0);
			if(cal == null)
				continue;
			
			RelatoriosDTO relat = new RelatoriosDTO();
			for (PpCpproduto prod: cp.getPpCpprodutos()){
				relat.setProduto(prod.getOmProduto().clone());
				quantidadeCp = prod.getPcsProducaoplanejada();
			}
			relat.setRel(preencherRelatorio(cp, relat, dtInicio, dtFim, cal, turnos, quantidadeCp, isCalculaHora));
			relat.getProduto().setCdProduto(relat.getProduto().getCdProduto() +  "( " + quantidadeCp +" )");
			if(cp.getOmPt() != null)
				relat.setMaquina(cp.getOmPt().getCdPt());
			else if (cp.getOmGt() != null)
				relat.setMaquina(cp.getOmGt().getCdGt());
			retorno.getListaRelatorios().add(relat);
		}
		
		return retorno;
		
	}
	
	private DwCal pesquisarCal(PpCp cp){
		CalendarioRN calRN = new CalendarioRN(this.dao);
		calRN.setSession(this.dao.getSession());
		List<DwCal> listCal = null;
		
		if (cp.getOmPt() != null){
			listCal = calRN.pesquisarListaDwCalByOmPt(cp.getOmPt());
		}else if (cp.getOmGt() != null){
			listCal = calRN.pesquisarListaDwCalByOmGt(cp.getOmGt());
		}
		
		DwCal cal = null;
		//e se cp usar dois calendários? estou tratando apenas um calendário q esteja valido
		if (listCal != null && listCal.isEmpty() == false){
			cal = listCal.get(0);
		}
		return cal;
	}
	
	@SuppressWarnings("deprecation")
	private List<RelatorioDTO> preencherRelatorio(PpCp cp, RelatoriosDTO relatoriosDTO, Date dtInicio, Date dtFim , DwCal cal, TurnosDTO turnosLista, BigDecimal quantidadeCp, boolean isCalculaHora){
		
		if((this.dateInicioApont == null || this.dateFimApont == null) &&(DataHoraRN.isDiaMesAnoIguais(dtInicio, cp.getDthrInicio())==false)&&(DataHoraRN.before(cp.getDthrInicio(), dtInicio))){
			this.dateInicioApont = DataHoraRN.setHoraNaData(cp.getDthrInicio(),0,0,0,0);
			this.dateFimApont = DataHoraRN.setDiaNaData(dtInicio, dtInicio.getDate()-1);
			this.dateFimApont = DataHoraRN.setHoraNaData(this.dateFimApont, 23, 59, 59, 59);
		}
		
		dtFim = DataHoraRN.setHoraNaData(dtFim, 23, 59, 59, 59);
		ConsolidaRN consolidaRn = new ConsolidaRN();
		consolidaRn.setDaoSession(this.dao.getSession());
		
		List<RelatorioDTO> relatorioDTOs = new ArrayList<RelatorioDTO>();
		List<DwCalsem> listaDwCalSem = new ArrayList<DwCalsem>();
		listaDwCalSem.addAll(cal.getDwCalsems());
		ordenaCalendariosSemanais(listaDwCalSem);
		
		Calendar diaCp = Calendar.getInstance();
		diaCp.setTime(DataHoraRN.setHoraNaData(DataHoraRN.adicionaSegundosNaData(cp.getDthrInicio(), cp.getDwFolha().getSegSetup()), 0, 0, 0, 0));
		
		Date dataFinal = DataHoraRN.setHoraNaData(dtFim, 23, 59, 59, 59);
		if(cp.getDthrFinal() != null && DataHoraRN.after(dataFinal, cp.getDthrFinal())){
			dataFinal = cp.getDthrFinal();
		}
		
		Date i = DataHoraRN.setHoraNaData(DataHoraRN.adicionaSegundosNaData(cp.getDthrInicio(), cp.getDwFolha().getSegSetup()), 0, 0, 0, 0);
		BigDecimal inicioSeg = BigDecimal.valueOf(DataHoraRN.getQuantidadeSegundosNoPeriodo(i, DataHoraRN.adicionaSegundosNaData(cp.getDthrInicio(), cp.getDwFolha().getSegSetup())));
		Date f = DataHoraRN.setHoraNaData(dataFinal, 0, 0, 0, 0);
		BigDecimal fimSeg = BigDecimal.valueOf(DataHoraRN.getQuantidadeSegundosNoPeriodo(f, dataFinal));
		
		BigDecimal quantSegInicio = BigDecimal.valueOf(0);
		BigDecimal quantSegFim = BigDecimal.valueOf(0);
		BigDecimal segFimTurno = BigDecimal.valueOf(0);
		BigDecimal tempoAnterior = BigDecimal.valueOf(0);
		
		List<PpCp> controleHoras = configuraLista(dtFim); 
		
		boolean isCalculaTurno = false;
		boolean isFirstDay = true;
		boolean isLastDay = false;
		boolean isInicio = false;
		int idTurnoInicio = 0;
		int idTurnoFim = 0;
		
		while (DataHoraRN.before(diaCp.getTime(), dataFinal)){
			
			RelatorioDTO novoRel = new RelatorioDTO();
			novoRel.setHorasPlanej(new ArrayList<BigDecimal>());
			
			TurnosDTO turnos = new TurnosDTO();
			List<TurnoDTO> t = new ArrayList<TurnoDTO>();
			t.addAll(turnosLista.getTurnos());
			turnos.setTurnos(t);
			
			TurnosDTO turnosReal = new TurnosDTO();
			List<TurnoDTO> tR = new ArrayList<TurnoDTO>();
			tR.addAll(turnosLista.getTurnos());
			turnosReal.setTurnos(tR);
			
			int diaDaSemanaDoMes = diaCp.get(Calendar.DAY_OF_WEEK) - 1;
			
			isLastDay = DataHoraRN.isDiaMesAnoIguais(diaCp.getTime(), dataFinal);
			
			for(DwCalsem calSem: listaDwCalSem){
				
				if (calSem.getDiasemana().compareTo(BigDecimal.valueOf(diaDaSemanaDoMes))!=0){
					continue;	
				}
				
				BigDecimal hrFim = calSem.getHrFinal();
					
				if(calSem.getHrFinal().compareTo(BigDecimal.valueOf(86400)) > 0){
					hrFim = BigDecimal.valueOf(86400);
				}
				
				if ((isFirstDay == true)&&(calSem.getHrInicial().compareTo(inicioSeg)<=0)&&(hrFim.compareTo(inicioSeg)>=0)){
					quantSegInicio = hrFim.subtract(inicioSeg);
					idTurnoInicio = (int)calSem.getDwTurno().getIdTurno();
					if (isLastDay)
						calculaHoras(inicioSeg, calSem, fimSeg, controleHoras, isFirstDay, isLastDay);
				}						
				
				if (isLastDay == true){
						
					if((calSem.getIsInicioturno() == true) || (hrFim.compareTo(BigDecimal.valueOf(86400)) >= 0)){
						segFimTurno = BigDecimal.valueOf(0);
					}
					
					if ((quantSegFim.compareTo(BigDecimal.valueOf(0))==0)&&(fimSeg.compareTo(calSem.getHrInicial())>=0)&&(fimSeg.compareTo(calSem.getHrFinal())<=0)){
						idTurnoFim = (int) calSem.getDwTurno().getIdTurno();
						
						if ((isFirstDay == true)&&(idTurnoFim==idTurnoInicio)){
							
							if(calSem.getHrInicial().compareTo(inicioSeg)<0){
								quantSegFim = fimSeg.subtract(inicioSeg);
							}else{
								quantSegFim = quantSegInicio.add(fimSeg.subtract(calSem.getHrInicial()));
							}
							
						}else{
							quantSegFim = segFimTurno.add(fimSeg.subtract(calSem.getHrInicial()));
							quantSegFim = quantSegFim.add(tempoAnterior);
							tempoAnterior = BigDecimal.valueOf(0);
						}
						
					}else{
						segFimTurno = segFimTurno.add(hrFim.subtract(calSem.getHrInicial()));
						segFimTurno = segFimTurno.add(tempoAnterior);
						tempoAnterior = BigDecimal.valueOf(0);
					}
					
					if((isCalculaTurno)&&(isCalculaHora)){
						calculaHoras(inicioSeg, calSem, fimSeg, controleHoras, isFirstDay, isLastDay);
					}
					
					if((quantSegFim.compareTo(BigDecimal.valueOf(0))!=0)&&(calSem.getHrFinal().compareTo(fimSeg) >=0)){
						break;
					}
					
				}
				
				if(isCalculaTurno == true){
					calculaTurno(turnos, calSem, hrFim, tempoAnterior);
				}
				
				if(isFirstDay == true){
					
					if ((isCalculaTurno == true)&&( isInicio==true|| idTurnoInicio == calSem.getDwTurno().getIdTurno())){
						quantSegInicio = quantSegInicio.add(hrFim.subtract(calSem.getHrInicial()));
					}
					
					if((calSem.getHrInicial().compareTo(inicioSeg)<=0)&&(hrFim.compareTo(inicioSeg)>=0)){
						isInicio = true;
						isCalculaTurno = true;
					}
					
					if(calSem.getIsFimturno() || (hrFim.compareTo(BigDecimal.valueOf(86400)) >= 0)){
						isInicio = false;
					}
				}
							
				if(calSem.getHrFinal().compareTo(BigDecimal.valueOf(86400)) > 0){
					tempoAnterior = BigDecimal.valueOf(86400);
					tempoAnterior = calSem.getHrFinal().subtract(tempoAnterior);
					break;
				}
					
			}
			
			List<TurnoDTO> listaTurnos = new ArrayList<TurnoDTO>();
			
			for(TurnoDTO turno: turnos.getTurnos()){
				TurnoDTO turnoNovo = new TurnoDTO();
				DwTurno dwTurno = new DwTurno();
				dwTurno.setDsTurno(turno.getTurno().getDsTurno());
				dwTurno.setIdTurno(turno.getTurno().getIdTurno());
				BigDecimal calc = BigDecimal.valueOf(0);
				if ((isLastDay)&&(turno.getTurno().getIdTurno() == idTurnoFim)){
					calc = calcularProducao(cp, quantSegFim);
				}else{
					if ((isFirstDay)&&(turno.getTurno().getIdTurno() == idTurnoInicio)){
						calc = calcularProducao(cp, quantSegInicio);
					}else{
						calc = calcularProducao(cp, turno.getQuantidade());
					}
				}
				//quando ajeitar o gerar plano, apagar essa condi�ao
				/*if (calc.compareTo(quantidadeCp)>0)
					calc = quantidadeCp;
				else
//					quantidadeCp = quantidadeCp.subtract(calc);*/
				
				turnoNovo.setQuantidade(calc);
				turnoNovo.setTurno(dwTurno);
				listaTurnos.add(turnoNovo);
				turno.setQuantidade(BigDecimal.valueOf(0));
			}
			
			if(isCalculaApont)
				calculaApontamento(relatoriosDTO, diaCp.getTime(), listaTurnos);
				
			if(DataHoraRN.isIntersecao(diaCp.getTime(), dtInicio, dtFim))
				calculaDiaRelatorio(listaTurnos, novoRel, diaCp, consolidaRn, cp, isCalculaHora, relatorioDTOs, controleHoras, turnosReal);
			
			
			isFirstDay = false;
			diaCp.set(Calendar.DAY_OF_MONTH, diaCp.get(Calendar.DAY_OF_MONTH) +1 );  
		}
		
		return relatorioDTOs;
		
	}
	
	private void calculaApontamento(RelatoriosDTO relat, Date diaAtual, List<TurnoDTO> listaTurnos){
		if(dateInicioApont != null && dateFimApont != null){
			if (DataHoraRN.isIntersecao(diaAtual, dateInicioApont, dateFimApont)){
				for (TurnoDTO turno: listaTurnos){
					relat.setQtdApont(relat.getQtdApont().add(turno.getQuantidade()));
				}
			}
		}
	}
	
	private void calculaHoras(BigDecimal inicioSeg, DwCalsem calSem, BigDecimal fimSeg, List<PpCp> controleHoras, boolean isFirstDay, boolean isLastDay){
		BigDecimal inH = BigDecimal.valueOf(0);
		BigDecimal fimH = BigDecimal.valueOf(0);
		
		if(isFirstDay){
			if(calSem.getHrInicial().compareTo(inicioSeg)>0){
				inH = calSem.getHrInicial();
			}else{
				inH = inicioSeg;
			}
		}
		
		if (isLastDay){
			if(calSem.getHrFinal().compareTo(fimSeg)<0){
				fimH = calSem.getHrFinal();
			}else{
				fimH = fimSeg;
			}
		}
		
		if((!isFirstDay)&&(!isLastDay)){
			inH = calSem.getHrInicial();
			fimH = calSem.getHrFinal();
		}
		
		for (PpCp ppcp: controleHoras){
			
			Date iPpCp = DataHoraRN.setHoraNaData(ppcp.getDthrInicio(), 0, 0, 0, 0);
			BigDecimal inicioPpCp = BigDecimal.valueOf(DataHoraRN.getQuantidadeSegundosNoPeriodo(iPpCp, ppcp.getDthrInicio()));
			
			Date fPpCp = DataHoraRN.setHoraNaData(ppcp.getDthrFinal(), 0, 0, 0, 0);
			BigDecimal finalPpCp = BigDecimal.valueOf(DataHoraRN.getQuantidadeSegundosNoPeriodo(fPpCp, ppcp.getDthrFinal()));
			
			if((inicioPpCp.compareTo(inH)<=0)&&(finalPpCp.compareTo(inH)>=0) && ((inicioPpCp.compareTo(fimH)<=0)&&(finalPpCp.compareTo(fimH)>=0))){
				ppcp.setPasso(ppcp.getPasso().add(fimH.subtract(inH)));
			}else if((inicioPpCp.compareTo(inH)<=0)&&(finalPpCp.compareTo(inH)>=0)){
				ppcp.setPasso(ppcp.getPasso().add(finalPpCp.subtract(inH)));
			}else if((inicioPpCp.compareTo(fimH)<=0)&&(finalPpCp.compareTo(fimH)>=0)){
				ppcp.setPasso(ppcp.getPasso().add(fimH.subtract(finalPpCp)));
			}
			
		}
	}
	
	private void calculaTurno(TurnosDTO turnos, DwCalsem calSem, BigDecimal hrFim, BigDecimal tempoAnterior){
		for(TurnoDTO turno: turnos.getTurnos()){
			if(calSem.getDwTurno().getIdTurno() != turno.getTurno().getIdTurno())
				continue;
			turno.setQuantidade(turno.getQuantidade().add(hrFim.subtract(calSem.getHrInicial())));
			turno.setQuantidade(turno.getQuantidade().add(tempoAnterior));
			tempoAnterior = BigDecimal.valueOf(0);
			break;
		}
	}
	
	private void calculaDiaRelatorio(List<TurnoDTO> listaTurnos, RelatorioDTO novoRel, Calendar diaCp, ConsolidaRN consolidaRn, PpCp cp, 
			boolean isCalculaHora, List<RelatorioDTO> relatorioDTOs, List<PpCp> controleHoras, TurnosDTO turnoReal){
		
		TurnosDTO turnosN = new TurnosDTO();
		turnosN.setTurnos(listaTurnos);
		
		novoRel.setData(diaCp.getTime());
		novoRel.setQtdTurnos(turnosN);
		novoRel.setQtdTurnoReal(new TurnosDTO());
		
		List<DwConsolid> listaConsolid = consolidaRn.pesquisarDwConsolidPorPpCp(diaCp.getTime(), cp);
		
		for (DwConsolid consolid: listaConsolid){
			
			for(TurnoDTO t: turnoReal.getTurnos()){
				if(consolid.getDwTurno().getIdTurno() != t.getTurno().getIdTurno()){
					continue;
				}
				DwConsol dwconsol = new DwConsol();
				for(DwConsol consol: consolid.getDwConsols()){
					dwconsol = consol.clone(false);
					break;
				}
				if (dwconsol.getPcsManuProducaobruta() != null)
					t.setQuantidade(t.getQuantidade().add(dwconsol.getPcsManuProducaobruta()));
			}
		}
		
		novoRel.getQtdTurnoReal().setTurnos(new ArrayList<TurnoDTO>());
		for(TurnoDTO t: turnoReal.getTurnos()){
			TurnoDTO tur = new TurnoDTO();
			DwTurno dw = new DwTurno();
			dw.setIdTurno(t.getTurno().getIdTurno());
			dw.setDsTurno(t.getTurno().getDsTurno());
			tur.setTurno(dw);
			tur.setQuantidade(t.getQuantidade());
			novoRel.getQtdTurnoReal().getTurnos().add(tur);
		}
		
		if(isCalculaHora){
			novoRel.setHorasPlanej(new ArrayList<BigDecimal>());
			for(PpCp ppCpRel : controleHoras){
				BigDecimal cal = calcularProducao(cp, ppCpRel.getPasso());
				novoRel.getHorasPlanej().add(cal);
			}
		}
		
		relatorioDTOs.add(novoRel);
	}
	
	
	private BigDecimal calcularProducao(PpCp cp, BigDecimal seg){
		
		PassosDTO passosCp = new PassosDTO(cp);
		@SuppressWarnings("unused")
		int tempo = passosCp.getTempoEstimadoSegundos(1);
		double segundo = seg.doubleValue();
		double prod = segundo / passosCp.getTempoProd();
		
		long retorno = Math.round(prod); 
		return BigDecimal.valueOf(retorno) ;
	}
	
	public List<DwCalsem> prepararListaDwCalSem(Set<DwCalsem> lista){
		
		List<DwCalsem> listaDwCalSem = new ArrayList<DwCalsem>();
		listaDwCalSem.addAll(lista);
		
		List<DwCalsem> retorno = new ArrayList<DwCalsem>();
		Boolean isPossui = false;
		
		for (DwCalsem calsem: listaDwCalSem){
			
			for(DwCalsem calS: retorno){
				if( (calS.getHrFinal().equals(calsem.getHrFinal())) && (calS.getHrInicial().equals(calsem.getHrInicial())) ){
					
					if((calS.getDwTurno() == null)||(calS.getDwTurno().getIdTurno() == 0)){
						calS.setDwTurno(calsem.getDwTurno());
					}
					isPossui = true;
				}
			}
			
			if(isPossui == false)
				retorno.add(calsem);
			else
				isPossui = false;
			
		}
		
		ordenaCalendariosSemanais(retorno);
		
		return retorno;
	}
	
	private void ordenaCalendariosSemanais(List<DwCalsem> calS){
		Comparator<DwCalsem> comparator = new Comparator<DwCalsem>() {
            @Override
			public int compare(DwCalsem p1, DwCalsem p2) {
            	
            	int retorno;
            	if (p1.getDiasemana().compareTo(p2.getDiasemana()) < 0){
            		retorno = -1;
            	}else if (p1.getDiasemana().compareTo(p2.getDiasemana()) > 0){ 
            		retorno = +1;
            	}else{
            		if (p1.getHrInicial().compareTo(p2.getHrInicial()) < 0){
                		retorno = -1;
                	}else if (p1.getHrInicial().compareTo(p2.getHrInicial()) > 0){ 
                		retorno = +1;
                	}else{
            			retorno = 0;
                	}
            	}
            	
            	return retorno;
            }
        };
        
        Collections.sort(calS, comparator);
	}
	

	private void ordenaTurnos(List<TurnoDTO> turno){
		Comparator<TurnoDTO> comparator = new Comparator<TurnoDTO>() {
            @Override
			public int compare(TurnoDTO p1, TurnoDTO p2) {
            	int retorno;
            	if (p1.getTurno().getIdTurno() < p2.getTurno().getIdTurno()){
            		retorno = -1;
            	}else if (p1.getTurno().getIdTurno() > p2.getTurno().getIdTurno()){ 
            		retorno = +1;
            	}else{
        			retorno = 0;
            	}
            	return retorno;
            }
        };
        
        Collections.sort(turno, comparator);
	}
	
	@SuppressWarnings("deprecation")
	private List<PpCp> configuraLista(Date rf){
		List<PpCp> controleHoras = new ArrayList<PpCp>();
		Date control = DataHoraRN.setHoraNaData(rf, 0, 0, 0, 0);
		
		for (int i=0; i<24; i++){
			PpCp cp = new PpCp();
			cp.setDthrInicio(control);
			control = DataHoraRN.setHoraNaData(control, control.getHours()+1, 0, 0, 0);
			cp.setDthrFinal(control);
			controleHoras.add(cp);
			cp.setPasso(BigDecimal.valueOf(0));
		}
		return controleHoras;
	}
	
	private TurnosDTO eliminaTurnoInvalido(TurnosDTO t){
        TurnosDTO turnoNovo = new TurnosDTO();
        List<TurnoDTO> list = new ArrayList<TurnoDTO>();
        
        for(TurnoDTO turno: t.getTurnos()){
            if(turno.getTurno().getIdTurno() == 1)
                continue;
            list.add(turno);
        }
        turnoNovo.setTurnos(list);
        return turnoNovo;
    }

}
