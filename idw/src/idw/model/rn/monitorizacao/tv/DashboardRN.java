package idw.model.rn.monitorizacao.tv;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmCfgindDAO;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRt;
import idw.model.pojos.OmCfgind;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.DwRtTemplate;
import idw.model.pojos.template.OmIndTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.TurnoRN;
import idw.util.FormulasInjet;
import idw.webservices.dto.DashboardDTO;
import idw.webservices.dto.DashboardParadasDTO;
import idw.webservices.dto.DashboardsDTO;
import idw.webservices.dto.FiltroDashboardDTO;
import idw.webservices.dto.TurnoAtualDTO;
import ms.util.ConversaoTipos;

public class DashboardRN extends AbstractRN<DAOGenerico> {

	public DashboardRN() {
		this(null);
	}

	public DashboardRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	/*
	 * Metodo principal para obtencao dos dados ao dashboard
	 */
	public DashboardsDTO getDashboardsDTO(FiltroDashboardDTO filtro){
		DashboardsDTO retorno = new DashboardsDTO();
		TurnoRN rn = new TurnoRN(getDao());
		TurnoAtualDTO turnoAtualDTO = new TurnoAtualDTO();
		try {
			turnoAtualDTO = rn.getTurnoAtual1PTDTO(filtro.getDtHrAtual());
		} catch (SemCalendarioException e) {
			e.printStackTrace();
		}
		turnoAtualDTO.getIdTurno();
		turnoAtualDTO.getDtReferencia();
		
		retorno.setTurnoAtual(turnoAtualDTO.getDwturno().getDsTurno());
		OmCfgindDAO omCfgindDAO = new OmCfgindDAO(getDaoSession());		
		OmCfgind omCfgInd = omCfgindDAO.getOmCfgind(OmIndTemplate.Tipo.OEE);

		String oeeMeta = String.valueOf(omCfgInd.getIndMeta().doubleValue());
		
		/*select *
				from dw_consolid a
				join dw_consol b on b.id_consolid = a.id_consolid
				join om_pt c on c.id_pt = a.id_pt
				join om_gt d on c.id_gt = d.id_gt
				where a.dt_referencia = turnoatual
				and a.id_turno = turnoatual
				and a.tp_id = 1
				and c.is_aponGt = 1
				and d.id_gt = idGt
		*/
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select a");
		q.append("from DwConsolid a");
		q.append("join a.dwConsols b");
		q.append("join a.omPt c");
		q.append("join c.omGt d");
		q.append("join a.dwTurno e");
		q.append("where a.tpId = 1 ");
		q.append("and c.isApongt = 1 ");

		if(filtro.getIdGt()!= null){
			q.append("AND d.idGt=:idGt ");
		}
			
		if(turnoAtualDTO != null) {
			q.append("AND e.idTurno = :idTurno");
			q.append("AND a.dtReferencia = :dtReferencia"); 
		}
		q.append("order by a.idConsolid desc");
		
		if(turnoAtualDTO != null) {
			q.defineParametro("idTurno", turnoAtualDTO.getIdTurno());
			q.defineParametro("dtReferencia", turnoAtualDTO.getDtReferencia());
		}
		q.defineParametro("idGt", filtro.getIdGt());
		
		List<DwConsolid> listaPesquisa = null;
		try{
			listaPesquisa = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}
		List<DashboardDTO> listaRetorno = new ArrayList<>();
		String opAtual = "";
		BigDecimal tempoTotalParada = BigDecimal.ZERO;
		BigDecimal tempoProdutivo = BigDecimal.ZERO;
		BigDecimal tempoAtivo = BigDecimal.ZERO;
		for(DwConsolid dwConsolid : listaPesquisa){
			// Se nao tiver uma OP entao passar pro poximo registro
			if (dwConsolid.getOmPt() == null || dwConsolid.getOmPt().getPpCp() == null)
				continue;
			
			if (opAtual.equals("")) {
				opAtual = dwConsolid.getOmPt().getPpCp().getCdCp();
			}
			if(opAtual.equals(dwConsolid.getPpCp().getCdCp()) == false){
				continue;
				// nao pega as ops teoricamente diferentes da atual;
			}
			DashboardDTO dashboardDTO = new DashboardDTO();
			dashboardDTO.setPtsParados(new ArrayList<String>());
			
			DwConsolid dwConsolidC = dwConsolid.clone(false);
			//Linha
			dwConsolidC.setOmPt(dwConsolid.getOmPt().clone(true));
			dashboardDTO.setIdGt(dwConsolidC.getOmPt().getOmGt().getIdGt());
			dashboardDTO.setLinha(dwConsolidC.getOmPt().getOmGt().getDsGt());
						
			//Modelo&Op&QtdOp
			dwConsolidC.setPpCp(dwConsolid.getPpCp().clone(true));
			
			// Ordernar os produtos para caso existam mais de um aparece apenas um no dashboard
			List<PpCpproduto> listaprodutos = new ArrayList<PpCpproduto>(dwConsolidC.getPpCp().getPpCpprodutos());
			java.util.Collections.sort(listaprodutos, new Comparator<PpCpproduto>() {
				@Override
				public int compare(PpCpproduto o1, PpCpproduto o2) {
					return o1.getIdCpproduto().compareTo(o2.getIdCpproduto());
				}
			});
			for(PpCpproduto ppCpproduto : listaprodutos){
				if(ppCpproduto!=null){
					dashboardDTO.setModelo(ppCpproduto.getOmProduto().getCdProduto());
					dashboardDTO.setDsModelo(ppCpproduto.getOmProduto().getDsProduto());
					dashboardDTO.setOp(ppCpproduto.getNrDoc());
					dashboardDTO.setQtdOp(String.valueOf(ppCpproduto.getPcsProducaoplanejada().intValue()));
					break;
				}
			}
			
			//Ciclo
			BigDecimal cicloPadrao = BigDecimal.ZERO;
			BigDecimal producaoCiclo = BigDecimal.ZERO;
			BigDecimal producaoLiquida = BigDecimal.ZERO; 
			BigDecimal tempoCalendario = BigDecimal.ZERO;
			BigDecimal cicloMedio = BigDecimal.ZERO;
			BigDecimal qtdRefugada = BigDecimal.ZERO;
			for(DwConsol dwConsol : dwConsolidC.getDwConsols()){
				if(dwConsol!=null){
					cicloPadrao=dwConsol.getSegAutoCiclopadrao();
					cicloMedio = dwConsol.getSegAutoCiclomedio();
					producaoLiquida=dwConsol.getPcsProducaoLiquida();
					tempoCalendario=dwConsol.getSegAutoTempocalendario();
					
					if(dwConsol.getPcsProducaoRefugada() != null)
						qtdRefugada=dwConsol.getPcsProducaoRefugada();
					
					if (dwConsol.getSegAutoTempoparadaCp() != null)
						tempoTotalParada = tempoTotalParada.add(dwConsol.getSegAutoTempoparadaCp());
					
					if (dwConsol.getSegAutoTempoparadaSp() != null)
						tempoTotalParada = tempoTotalParada.add(dwConsol.getSegAutoTempoparadaSp());
					
					if (dwConsol.getSegAutoTempoativo() != null) 
						tempoAtivo = tempoAtivo.add(dwConsol.getSegAutoTempoativo());
										
					if (dwConsol.getSegAutoTempoprodutivo() != null)
						tempoProdutivo = tempoProdutivo.add(dwConsol.getSegAutoTempoprodutivo());
					
					break;
				}
			}
			dwConsolidC.setDwFolha(dwConsolid.getDwFolha().clone(false));
			producaoCiclo = getProducaoCiclo(dwConsolidC.getDwFolha());
			Float meta = (3600/cicloPadrao.floatValue())*producaoCiclo.floatValue();
			
			dashboardDTO.setMeta(String.valueOf(meta.intValue()) + " un");//meta
			float qtdFalhas=0;
			Float yield = 0f;
			if (producaoLiquida != null) {
				yield = qtdFalhas/producaoLiquida.floatValue();
			}
			dashboardDTO.setYield(yield.toString());//yield
			Float planTurno = (tempoCalendario.floatValue() / cicloPadrao.floatValue()) * producaoCiclo.floatValue();
			dashboardDTO.setPlanTurno(String.valueOf(planTurno.intValue()));
			
			//AcumDia
			Float acumDia = getAcumDia(turnoAtualDTO.getDtReferencia(), dwConsolidC.getOmPt().getIdPt(), dwConsolidC.getPpCp().getIdCp());
			dashboardDTO.setAcumDia(acumDia.toString());
			
			//Producao
			List<Float> producao = getProducoes(turnoAtualDTO.getDtReferencia(), dwConsolidC.getOmPt().getIdPt(), turnoAtualDTO.getIdTurno(), dwConsolid.getPpCp());
			if(producao.size()<=0){
				dashboardDTO.setProdHora("0.0");
				dashboardDTO.setProdHoraAnt("0.0");
			}else{
				dashboardDTO.setProdHora(producao.get(producao.size()-1).toString());
				if(producao.size()>1)
					dashboardDTO.setProdHoraAnt(producao.get(producao.size()-2).toString());
				else
					dashboardDTO.setProdHoraAnt("0.0");
			}
			dashboardDTO.setQtdRefugada(String.valueOf(qtdRefugada.intValue()));
			
			// Calcula o OEE
			Float oee = FormulasInjet.calcularOEE(tempoProdutivo, tempoAtivo);
			dashboardDTO.setOee(ConversaoTipos.converteParaString(oee.doubleValue(), 2) + "%");
			dashboardDTO.setOeeMeta(oeeMeta+"%");
			
			dashboardDTO.setProducaoLiquida(String.valueOf(producaoLiquida.intValue()));
			if (cicloMedio != null)
				dashboardDTO.setSegCicloMedioAtual(ConversaoTipos.converteParaString(cicloMedio.doubleValue(), 2) + " s");
			else
				dashboardDTO.setSegCicloMedioAtual("0 s");
			
			dashboardDTO.setSegCicloPadrao(String.valueOf(cicloPadrao) + " s");
			
			listaRetorno.add(dashboardDTO);
		}
		retorno.setListaDashboardDTO(listaRetorno);
		
		// Obter a lista de maquinas paradas do GT. Esse select esta trazendo todos os RT inclusive os antigos para o turno gerando em bug  que mostra um PT parado que nao esta
		MapQuery q2 = new MapQuery(getDaoSession());
		q2.append("select dwrt");
		q2.append("from DwRt dwrt");
		q2.append("join dwrt.omPt ompt");
		q2.append("where ompt.omGt.idGt = :omgt");
		q2.append("and ompt.stAtivo = 1");
		q2.append("and dwrt.dtReferencia = :dtreferencia");
		q2.append("and dwrt.dwTurno.idTurno = :dwturno");
		q2.append("and ompt.ppCp = dwrt.ppCp");
		q2.append("order by dwrt.dthrHeartbeat desc, dwrt.dthrEvento DESC, dwrt.idRt desc");
		
		q2.defineParametro("omgt", filtro.getIdGt());
		q2.defineParametroData("dtreferencia", turnoAtualDTO.getDtReferencia());
		q2.defineParametro("dwturno", turnoAtualDTO.getIdTurno());
		
		List<DwRt> listaRt = q2.list();
		boolean isPTSemOp = false;
		if (retorno.getListaDashboardDTO().size() > 0) {
			retorno.getListaDashboardDTO().get(0).setPtsParados(new ArrayList<String>());
			retorno.getListaDashboardDTO().get(0).setInfoPtsParados(new ArrayList<DashboardParadasDTO>());
			
			// Adicionado o list abaixo para controlar o for viabilizando que ele processe apenas o 1o registro de cada maquina
			// desconsiderando os demais resolvendo assim o bug relatado no comentario do select anterior
			List<String> rtsLidos = new ArrayList<String>();
			for (DwRt dwrt : listaRt) {
				if (rtsLidos.contains(dwrt.getOmPt().getCdPt()))
					continue;
				
				if (dwrt.getIsSemplanejamento() && dwrt.getOmPt().getIsApongt() != null && dwrt.getOmPt().getIsApongt())
					isPTSemOp = true;
				
				rtsLidos.add(dwrt.getOmPt().getCdPt());
				if (dwrt.getStFuncionamento().equals(DwRtTemplate.StFuncionamento.PARADA.getId())) {
					if (retorno.getListaDashboardDTO().get(0).getPtsParados().contains(dwrt.getOmPt().getCdPt()) == false) {
						retorno.getListaDashboardDTO().get(0).getPtsParados().add(dwrt.getOmPt().getCdPt());
						
						ConsolidaRN prn = new ConsolidaRN(getDao());
						DwConsolpalog log = prn.getUltimaParadaFromDwConsolpalog(dwrt.getOmPt());
						if(log.getDthrFparada() == null) {
						
							String parada =(log.getDwTParada().getDsTparada() != null ?
									  log.getDwTParada().getDsTparada() +" - "  : "")+"Cod:"+
									 log.getDwTParada().getCdTparada();
							
							int duracaoSeg = DataHoraRN.getQuantidadeSegundosNoPeriodo(log.getDthrIparada(), new Date());
							int duracaoTotalSeg = tempoTotalParada.intValue() + duracaoSeg;
							DashboardParadasDTO item = new DashboardParadasDTO();
							item.setCdPt(dwrt.getOmPt().getCdPt());
							item.setIsApontaParaGt(dwrt.getOmPt().getIsApongt());
							item.setParada(parada);
							item.setDuracao(DataHoraRN.formatSegundosParaHHMMSS(duracaoSeg));
							item.setDuracaoTotal(DataHoraRN.formatSegundosParaHHMMSS(duracaoTotalSeg));
							retorno.getListaDashboardDTO().get(0).getInfoPtsParados().add(item);
						}
					}
				}
			}
		} else {
			// Se nao encontrar dwrt entao considerar q pt esta sem op
			isPTSemOp = true;
		}
		// Se estiver sem OP entao retornar em branco a fim de deixar o dashboard com a mensagem aguardando
		if (isPTSemOp) {
			retorno = new DashboardsDTO();
		}
		return retorno;
	}
	private BigDecimal getProducaoCiclo(DwFolha dwFolha){
		BigDecimal producaoCiclo = new BigDecimal(0); 
		FolhaRN folhaRN = new FolhaRN(getDao());
		try {
			producaoCiclo = folhaRN.getPcsPorCicloAtivas(dwFolha);
		} catch (SemPcsPorCicloAtivasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return producaoCiclo;
	}
	public List<Float> getProducoes(Date dthrRef, Long idPt, Long idTurno, PpCp ppcp){
		MapQuery q = new MapQuery(this.getDao().getSession());
		/*select b.pcs_auto_producaobruta from dw_consolid a
				join dw_consol b on b.id_consolid = a.id_consolid
			where a.tp_id = 0 (hora) and a.dt_referencia = 'dthrRef' and 
			a.id_turno = n and a.id_pt = n order by a.id_consolid desc*/
				q.append("select a");
				q.append("from DwConsolid a");
				q.append("join a.dwConsols b");
				q.append("join a.omPt c");
				q.append("join a.dwTurno e");
				q.append("where a.tpId = 0 ");
				q.append("and a.ppCp = :ppcp");

				if(idPt!= null){
					q.append("AND c.idPt=:idPt ");
				}
				if(idTurno!= null){
					q.append("AND e.idTurno=:idTurno ");
				}
				if(dthrRef != null) {
					q.append("AND a.dtReferencia = :dtReferencia "); 
				}
				if(dthrRef != null) {
					q.defineParametro("dtReferencia", dthrRef);
				}
				q.defineParametro("idPt", idPt);	
				q.defineParametro("idTurno", idTurno);
				q.defineParametro("ppcp", ppcp);
				
				List<DwConsolid> listaPesquisa = null;
				try{
					listaPesquisa = q.list();
				} catch (Exception e){
					e.printStackTrace();
				}
				List<Float> listaRetorno = new ArrayList<Float>();
				for(DwConsolid dwConsolid:listaPesquisa){
					DwConsolid consolidC = dwConsolid.clone(false);
					for(DwConsol consol:consolidC.getDwConsols()){
						if(consol!=null){
							listaRetorno.add(consol.getPcsProducaoBruta().floatValue());
							break;
						}
					}
				}
				return listaRetorno;
	}
	private Float getAcumDia(Date dthrRef,Long idPt,Long idCp){
		Float acumDia = new Float(0);
		MapQuery q = new MapQuery(this.getDao().getSession());
/*		select sum(b.pcs_auto_producaobruta)
	from dw_consolid a
		join dw_consol b
	where a.dt_referencia = d
	and a.tp_id = 1
	and omPt = pt
	and ppCp = cp*/
		q.append("select distinct a");
		q.append("from DwConsolid a");
		q.append("join a.dwConsols b");
		q.append("join a.omPt c");
		q.append("join a.ppCp d");
		q.append("where a.tpId = 1 ");

		if(idPt!= null){
			q.append("AND c.idPt=:idPt ");
		}
		if(idCp!= null){
			q.append("AND d.idCp=:idCp ");
		}
		if(dthrRef != null) {
			q.append("AND a.dtReferencia = :dtReferencia "); 
		}
		if(dthrRef != null) {
			q.defineParametro("dtReferencia", dthrRef);
		}
		q.defineParametro("idPt", idPt);	
		q.defineParametro("idCp", idCp);
		
		List<DwConsolid> listaPesquisa = null;
		try{
			listaPesquisa = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}
		for(DwConsolid dwConsolid:listaPesquisa){
			DwConsolid consolidC = dwConsolid.clone(false);
			for(DwConsol consol:consolidC.getDwConsols()){
				if(consol!=null){
					acumDia+=consol.getPcsProducaoBruta().floatValue();
					break;
				}
			}
		}
		
		return acumDia;
	}
}
