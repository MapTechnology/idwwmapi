package idw.model.rn.procedimento;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwProcativ;
import idw.model.pojos.DwProcedimento;
import idw.model.pojos.DwProrea;
import idw.model.pojos.DwProreaativ;
import idw.model.pojos.DwProreaativobs;
import idw.model.pojos.DwProreausr;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwProreaTemplate;
import idw.model.pojos.template.DwProreaativTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.CpRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.UsuarioRN;
import idw.model.rn.servemail.ServicoEmailFactory;
import idw.model.rn.servemail.ServicoEmailProcedimentoRN;
import idw.util.IdwLogger;
import idw.webservices.dto.AtividadeRealizadaDTO;
import idw.webservices.dto.AtividadesRealizadasDTO;
import idw.webservices.dto.DwProreaDTO;
import idw.webservices.dto.DwProreaUsrDTO;
import idw.webservices.dto.ObservacaoRealizadaDTO;
import idw.webservices.dto.TurnoAtualDTO;
import injetws.model.excessoes.SemSGBDException;

public class ProcedimentoRealizadoRN extends AbstractRN<DAOGenerico>{

	public ProcedimentoRealizadoRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public ProcedimentoRealizadoRN() {
		this(null);
	}
	public String finalizarSetup(AtividadesRealizadasDTO realizadasDTO){
		IdwLogger log = new IdwLogger("finalizarSetup");
		int idLog = log.getIdAleatorio(); 
		int identacao = 0;
		
		List<DwProreaDTO> dwProreaDTOnovo = new ArrayList<DwProreaDTO>();
		PpCp ppCp = new PpCp();
		
		DwProrea dwProrea = new DwProrea();
		//criaçãoo DwProrea
		dwProrea.setStProrea(DwProreaTemplate.StProrea.STATUS_ABERTO.getValue());
		//PpCp
		ppCp = getPpCp(realizadasDTO.getAtividadeRealizadaDTOs().get(0).getIdCp());
		
		ppCp.setDthrFsetup(DataHoraRN.getDataHoraAtual());
		Date dthrIsetup = null;
		for (AtividadeRealizadaDTO dto : realizadasDTO.getAtividadeRealizadaDTOs()) {
			if (dthrIsetup == null || DataHoraRN.after(dthrIsetup, dto.getDthrInicio()))
				dthrIsetup = dto.getDthrInicio();
		}
		ppCp.setDthrIsetup(dthrIsetup);
		
		//DwConsolid 
		DwConsolid dwConsolid = getDwConsolid(log, idLog, identacao,  ppCp, realizadasDTO.getAtividadeRealizadaDTOs().get(0).getDthrInicio());
		dwProrea.setDwConsolid(dwConsolid);
		
		//DwProcedimento
		DwProcedimento dwProcedimento = ppCp.getDwFolha().getDwProcedimento();
		dwProrea.setDwProcedimento(dwProcedimento);

		dwProrea = getDao().makePersistent(dwProrea);
			
		//getDao().flushReiniciandoTransacao();
		getDao().flush();
		for(AtividadeRealizadaDTO atividadeRealizadaDTO : realizadasDTO.getAtividadeRealizadaDTOs()){
			DwProreaDTO dto = novaAtividadeRealizada(dwProrea.getIdProrea(), atividadeRealizadaDTO.getDthrInicio(), atividadeRealizadaDTO.getDthrFim(), atividadeRealizadaDTO.getIdProcativ(), atividadeRealizadaDTO.getIdUsr(), atividadeRealizadaDTO.getStProreaativ(),atividadeRealizadaDTO.getDsObs());
			if(atividadeRealizadaDTO.getStProreaativ().byteValue() != DwProreaativTemplate.Type.EXECUTANDO.getId()){
				dwProreaDTOnovo.add(dto);
			}
		}
		
		if(realizadasDTO.getObservacaoRealizadaDTOs() != null && realizadasDTO.getObservacaoRealizadaDTOs().size() > 0){
			for(ObservacaoRealizadaDTO observacaoRealizadaDTO: realizadasDTO.getObservacaoRealizadaDTOs()){
				for(DwProreaDTO dto : dwProreaDTOnovo) {
					for(DwProreaativ dwProreaativ : dto.getDwProrea().getDwProreaativs()){
						if(dwProreaativ.getDwProcativ().getIdProcativ() == observacaoRealizadaDTO.getIdProcativ()){
							novaObs(dwProreaativ.getIdProreaativ(), observacaoRealizadaDTO.getDsObs(), observacaoRealizadaDTO.getDthr());
						}
					}
				}
			}
		}
		
		if (realizadasDTO.getDwProreaUsrDTOs() != null) {
			if (!realizadasDTO.getDwProreaUsrDTOs().isEmpty()) {
				for (DwProreaUsrDTO dwProreaUsrDTO : realizadasDTO.getDwProreaUsrDTOs()) {
					novoDwProreausr(dwProreaUsrDTO.getIdomUsr() , dwProrea.getIdProrea());
					}
			}
		}
		return "Sucesso";
	}
	
	public DwProreausr novoDwProreausr(Long idomUsr, Long iddwProrea) {
		DwProreausr dwProreausr = new DwProreausr();
		
		DwProrea dwProrea = getDao().findById(DwProrea.class, iddwProrea, true);
		OmUsr omUsr = getDao().findById(OmUsr.class, idomUsr, true);
		
		System.out.println("id prorea: "+ dwProrea.getIdProrea()+"   id OmUsr: "+omUsr.getIdUsr());
		
		dwProreausr.setDwProrea(dwProrea.clone(true));		
		dwProreausr.setOmUsr(omUsr.clone(true));
		
		getDao().makePersistent(dwProreausr.clone(true));
		getDao().flush();
		
		return dwProreausr.clone(true);
	}
	
	public DwProreaDTO novaAtividadeRealizada(Long iddwProrea,Date dthrInicio,Date dthrFim,Long idProcativ,Long idUsr,Byte stProreaativ, String obs){
		DwProreaDTO retorno = new DwProreaDTO();
		DwProrea dwProrea = getDao().findById(DwProrea.class, iddwProrea, true);
		System.out.println("id prorea: "+dwProrea.getIdProrea()+"   id dwconsolid: "+dwProrea.getDwConsolid().getIdConsolid());
		//Atividade
		DwProreaativ dwProreaativ = new DwProreaativ();
		dwProreaativ.setDthrInicio(dthrInicio);
		dwProreaativ.setDthrFim(dthrFim);
		dwProreaativ.setDwProcativ(getDwProcativ(idProcativ));
		dwProreaativ.setOmUsr(getOmUsr(idUsr));
		dwProreaativ.setDwProrea(dwProrea);
		dwProreaativ.setStProreaativ(stProreaativ);
		dwProreaativ = getDao().makePersistent(dwProreaativ);
		//getDao().flushReiniciandoTransacao();
		getDao().flush();
		
		dwProrea.setStProrea(getStProrea(dwProreaativ.getDwProrea()));
		dwProrea = getDao().makePersistent(dwProreaativ.getDwProrea());
		dwProreaativ.setDwProrea(dwProrea);
		getDao().makePersistent(dwProreaativ);
		//getDao().flushReiniciandoTransacao();
		getDao().flush();
		
		if(stProreaativ==2||stProreaativ==3){//se atividade foi realizada com ressalva (st = 2) ou nao realizada (st = 3) é obrigatório um comentario (DwProreaativObs) 
			DwProreaativobs dwProreaativobs = novaObs(dwProreaativ, obs, dthrInicio);
			dwProreaativobs = getDao().makePersistent(dwProreaativobs);
		}
		
		dwProrea = dwProrea.clone(true);
		
		Set<DwProreaativ> dwProreaativs = new HashSet<DwProreaativ>(0);
		DwProreaativ dwProreaativRet = dwProreaativ.clone(false);
		dwProreaativRet.setDwProrea(dwProreaativ.getDwProrea().clone(false));
		dwProreaativRet.setOmUsr(dwProreaativ.getOmUsr().clone(false));
		DwProcativ dwProcativRet = dwProreaativ.getDwProcativ().clone(false);
			dwProcativRet.setDwGrpativ(dwProreaativ.getDwProcativ().getDwGrpativ().clone(false));
			dwProcativRet.setDwProcedimento(dwProreaativ.getDwProcativ().getDwProcedimento().clone(false));
		dwProreaativRet.setDwProcativ(dwProcativRet);
		dwProreaativs.add(dwProreaativRet);
		dwProrea.setDwProreaativs(dwProreaativs);

		
		retorno.setDwProrea(dwProrea);
		return retorno;
	}
	
	@Deprecated
	public DwProreaDTO novaAtividadeRealizada(Long iddwProrea,Date dthrAtual,Long idProcativ,Long idUsr,Byte stProreaativ, String obs){
		DwProreaDTO retorno = new DwProreaDTO();
		DwProrea dwProrea = getDao().findById(DwProrea.class, iddwProrea, true);
		System.out.println("id prorea: "+dwProrea.getIdProrea()+"   id dwconsolid: "+dwProrea.getDwConsolid().getIdConsolid());
		//Atividade
		DwProreaativ dwProreaativAtigo = isNovoProreaativ(idProcativ,dwProrea.getIdProrea());
		//Verifica se é uma nova atividade sendo realizada, se n�o retorna o DwProreaativ, se sim retorna nulo 
		DwProreaativ dwProreaativ = dwProreaativAtigo;
		//Verifica se atividade n�o pode ser realizada (st = 3)
		if(stProreaativ!=3){
			if(dwProreaativAtigo==null){
				dwProreaativ = new DwProreaativ();
				dwProreaativ.setDthrInicio(dthrAtual);
				dwProreaativ.setDthrFim(null);
				dwProreaativ.setDwProcativ(getDwProcativ(idProcativ));
				dwProreaativ.setOmUsr(getOmUsr(idUsr));
				dwProreaativ.setDwProrea(dwProrea);
				dwProreaativ.setStProreaativ(stProreaativ);
			}else{
				dwProreaativ.setStProreaativ(stProreaativ);
				dwProreaativ.setDthrFim(dthrAtual);
				dwProreaativ.setDwProrea(dwProrea);
				if(stProreaativ==2){//se atividade foi realizada com ressalva (st = 2) é obrigatório um comentario (DwProreaativObs)
					DwProreaativobs dwProreaativobs = novaObs(dwProreaativ, obs, dthrAtual);
					Set<DwProreaativobs> dwProreaativobses = new HashSet<DwProreaativobs>(0);
					dwProreaativobses.add(dwProreaativobs);
					dwProreaativ.setDwProreaativobses(dwProreaativobses);
				}
			}
		}else{
			if(dwProreaativAtigo==null){
				dwProreaativ = new DwProreaativ();
				dwProreaativ.setDthrInicio(dthrAtual);
				dwProreaativ.setDthrFim(dthrAtual);
				dwProreaativ.setDwProcativ(getDwProcativ(idProcativ));
				dwProreaativ.setOmUsr(getOmUsr(idUsr));
				dwProreaativ.setDwProrea(dwProrea);
				dwProreaativ.setStProreaativ(stProreaativ);
			}else{
				dwProreaativ.setStProreaativ(stProreaativ);
				dwProreaativ.setDthrFim(dthrAtual);
				dwProreaativ.setDwProrea(dwProrea);
			}
			DwProreaativobs dwProreaativobs = novaObs(dwProreaativ, obs, dthrAtual);
			Set<DwProreaativobs> dwProreaativobses = new HashSet<DwProreaativobs>(0);
			dwProreaativobses.add(dwProreaativobs);
			dwProreaativ.setDwProreaativobses(dwProreaativobses);
		}
		dwProreaativ = getDao().makePersistent(dwProreaativ);
		dwProrea.setStProrea(getStProrea(dwProrea));
		dwProrea = getDao().makePersistent(dwProrea);
		
		dwProrea = dwProrea.clone(true);
		
		Set<DwProreaativ> dwProreaativs = new HashSet<DwProreaativ>(0);
		DwProreaativ dwProreaativRet = dwProreaativ.clone(false);
		dwProreaativRet.setDwProrea(dwProreaativ.getDwProrea().clone(false));
		dwProreaativRet.setOmUsr(dwProreaativ.getOmUsr().clone(false));
		DwProcativ dwProcativRet = dwProreaativ.getDwProcativ().clone(false);
			dwProcativRet.setDwGrpativ(dwProreaativ.getDwProcativ().getDwGrpativ().clone(false));
			dwProcativRet.setDwProcedimento(dwProreaativ.getDwProcativ().getDwProcedimento().clone(false));
		dwProreaativRet.setDwProcativ(dwProcativRet);
		dwProreaativs.add(dwProreaativRet);
		dwProrea.setDwProreaativs(dwProreaativs);

		
		retorno.setDwProrea(dwProrea);
		return retorno;
	}
	public Byte getStProrea(DwProrea dwProrea){
		Byte retorno=0;
		int nProcedimentosRea = 0;
		int nProcedimentos =dwProrea.getDwProcedimento().getDwProcativs().size();
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select a");
		q.append("from DwProreaativ a");
		q.append("join fetch a.dwProrea c");
		q.append("where c.idProrea= :idProrea ");
		q.append("and a.stProreaativ!=0");
		
		q.defineParametro("idProrea", dwProrea.getIdProrea());
		List<DwProreaativ> listaPesquisa = null;
		try{
			listaPesquisa = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}
		nProcedimentosRea=listaPesquisa.size();
		if(nProcedimentosRea==nProcedimentos){
			retorno = 1;
		}
		return retorno;
	}
	
	private DwConsolid getDwConsolid(IdwLogger log, int idLog, int identacao, PpCp ppCp, Date dthrAtual){
		DwConsolid dwConsolid = new DwConsolid();
		ConsolidaRN consolidaRN = new ConsolidaRN(getDao());
		TurnoRN turnoRN = new TurnoRN(getDao());
		TurnoAtualDTO turnoAtualDTO = new TurnoAtualDTO();
		OmPt omPt = null;
		
		try {
			log.info(idLog, identacao, "PPCP = " + ppCp.getIdCp());
			
			if (ppCp.getOmPt() != null) {				
				omPt = ppCp.getOmPt();
				log.info(idLog, identacao, "OMPT = " + ppCp.getOmPt());
			} else {
				
				MapQuery q = new MapQuery(this.getDao().getSession());
				
				q.append("select a");				
				q.append("from OmPt a");
				q.append("join a.omGt b");
				q.append("where b.idGt = :idGt ");
				
				if (ppCp.getOmGt() == null) {
					log.info(idLog, identacao, "Erro: GT nulo.");
					return null;
				}
				
				if (ppCp.getOmGt().getIdGt() == null) {
					log.info(idLog, identacao, "Erro: GT nao tem IdGt valido.");
					return null;
				}
				
				q.defineParametro("idGt", ppCp.getOmGt().getIdGt());
				
				log.info(idLog, identacao, "id OmGt: " + ppCp.getOmGt().getIdGt().toString());
				
				q.setMaxResults(1);
				
				omPt = (OmPt) q.uniqueResult();
				
				log.info(idLog, identacao, "OMPT = " + omPt);	
			}
			
			if (omPt == null) {
				log.info(idLog, identacao, "Nao ha PTs cadastrados no GT: " + ppCp.getOmGt().getIdGt().toString());
				return null;
			}
			
			turnoAtualDTO = turnoRN.getTurnoAtualDTOSemClone(omPt, dthrAtual);
			ppCp.setOmPt(omPt);
			
			
		} catch (SemCalendarioException e) {
			e.printStackTrace();
		}
		
		try {
			//System.out.println("getDwConsolid para procedimento realizado");
			dwConsolid = consolidaRN.obtemConsolIdTurno(log, idLog, identacao, ppCp.getOmPt(), ppCp, ppCp.getDwFolha(), turnoAtualDTO, null).clone(false);
		} catch (SemCalendarioException e) {
			e.printStackTrace();
		} catch (SemSGBDException e) {
			e.printStackTrace();
		} catch (SemCicloPadraoException e) {
			e.printStackTrace();
		}
		return dwConsolid;
	}
	private DwProcativ getDwProcativ(Long idProcativ){
		ProcedimentoRN procedimentoRN = new ProcedimentoRN(getDao());
		return procedimentoRN.getDwProcativ(idProcativ);
	}
	public PpCp getPpCp(Long idCp){
		CpRN cpRN = new CpRN(getDao());
		PpCp cp = new PpCp();
		cp.setId(idCp);
		return cpRN.pesquisarPpCpByIdCpForSetup(cp);
	}
	private OmUsr getOmUsr(Long idOmUsr){
		UsuarioRN usuarioRN = new UsuarioRN(getDao());
		return usuarioRN.getOmUsr(idOmUsr);
	}
	public DwProreaDTO isNovoProrea(long idCp){
		DwProreaDTO retorno = new DwProreaDTO();
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select a");
		q.append("from DwProrea a");
		q.append("join fetch a.dwConsolid b");
		q.append("join fetch b.ppCp e");
		q.append("join fetch a.dwProcedimento c");
		q.append("join fetch a.dwProreaativs d");
		q.append("where e.idCp= :idCp");
		q.append("and a.stProrea = 0");
		
		q.defineParametro("idCp", idCp);
		q.setMaxResults(1);
		
		DwProrea dwProrea = (DwProrea) q.uniqueResult();
		if(dwProrea!=null)
			retorno.setDwProrea(dwProrea);
		else 
			retorno.setDwProrea(null);
		return retorno;
	}
	public DwProreaativ isNovoProreaativ(long idProcativ,long idProrea){
		DwProreaativ retorno = new DwProreaativ();
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select a");
		q.append("from DwProreaativ a");
		q.append("join fetch a.dwProcativ b");
		q.append("join fetch a.omUsr d");
		q.append("where b.idProcativ= :idProcativ ");
		q.append("and a.dwProrea.idProrea = :idProrea");
		
		q.defineParametro("idProcativ", idProcativ);
		q.defineParametro("idProrea", idProrea);
		q.setMaxResults(1);
		
		DwProreaativ dwProreaativ = (DwProreaativ) q.uniqueResult();
		if(dwProreaativ!=null)
			retorno= dwProreaativ;
		else 
			retorno= null;
		return retorno;
	}

	public DwProreaativobs novaObs(long idProreaativ, String dsObs, Date dthrObs){
		DwProreaativobs dwProreaativobs = new DwProreaativobs();
		DwProreaativ dwProreaativ = getProreaativ(idProreaativ);
		
		dwProreaativobs.setDwProreaativ(dwProreaativ);
		dwProreaativobs.setDsObs(dsObs);
		dwProreaativobs.setIsTexto(true);
		dwProreaativobs.setDthrObs(dthrObs);
		dwProreaativobs = getDao().makePersistent(dwProreaativobs);
		DwProreaativobs dwProreaativobsC = dwProreaativobs.clone(false);
		
		DwProreaativ dwProreaativC = dwProreaativobs.getDwProreaativ().clone(false);
		DwProcativ dwProcativC = dwProreaativobs.getDwProreaativ().getDwProcativ().clone(false);
		dwProcativC.setDwProcedimento(dwProreaativobs.getDwProreaativ().getDwProcativ().getDwProcedimento().clone(false));
		try {
			dwProcativC.setDwTArea(dwProreaativobs.getDwProreaativ().getDwProcativ().getDwTArea().clone(false));
		} catch (NullPointerException e) {
			dwProcativC.setDwTArea(null);
		}
		dwProreaativC.setDwProcativ(dwProcativC);
		dwProreaativobsC.setDwProreaativ(dwProreaativC);
		
		IdwLogger log = new IdwLogger("ProcedimentoRealizadoRN");
		int idLog = log.getIdAleatorio();
		int identacao = 5;
		
		ServicoEmailFactory email = ServicoEmailFactory.getInstance(log, idLog, identacao, getDaoSession(), ServicoEmailFactory.TpEvt.OBS_PROCEDIMENTO);
		( (ServicoEmailProcedimentoRN) email).setDwProreaativobs(dwProreaativobsC);
		( (ServicoEmailProcedimentoRN) email).setEnviou(false);
		
		//BUSCA POR DWCONSOLID POR ID PORQUE QUANDO ADICIONAVA OBS NO ANDROID
		//DAVA ERRO NESSE PONTO DIZENDO QUE EU QUERIA SALVAR UM CONSOLID COM UM ID QUE JA TINHA NA BASE
		email.gerarAlerta(getDao().findById(DwConsolid.class, dwProreaativ.getDwProrea().getDwConsolid().getIdConsolid(), true));
		//email.gerarAlerta(dwProreaativ.getDwProrea().getDwConsolid());

		return dwProreaativobsC;
	}
	
	public DwProreaativobs novaObs(DwProreaativ dwProreaativ, String dsObs, Date dthrObs){
		DwProreaativobs dwProreaativobs = new DwProreaativobs();
		
		dwProreaativobs.setDwProreaativ(dwProreaativ);
		dwProreaativobs.setDsObs(dsObs);
		dwProreaativobs.setIsTexto(true);
		dwProreaativobs.setDthrObs(dthrObs);
		
		IdwLogger log = new IdwLogger("ProcedimentoRealizadoRN");
		int idLog = log.getIdAleatorio();
		int identacao = 5;
		
		ServicoEmailFactory email = ServicoEmailFactory.getInstance(log, idLog, identacao, getDaoSession(), ServicoEmailFactory.TpEvt.OBS_PROCEDIMENTO);
		( (ServicoEmailProcedimentoRN) email).setDwProreaativobs(dwProreaativobs);
		( (ServicoEmailProcedimentoRN) email).setEnviou(false);
		DwConsolid dwconsolid = getDao().findById(DwConsolid.class, dwProreaativ.getDwProrea().getDwConsolid().getIdConsolid(), false);
		email.gerarAlerta(dwconsolid);
		
		return dwProreaativobs;
	}
	
	
	public DwProreaativ getProreaativ(long idProreaativ){
		DwProreaativ retorno = new DwProreaativ();
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select a");
		q.append("from DwProreaativ a");
		q.append("join fetch a.dwProcativ b");
		q.append("join fetch a.dwProrea c");
		q.append("join fetch a.omUsr d");
		q.append("where a.idProreaativ= :idProreaativ ");
		
		q.defineParametro("idProreaativ", idProreaativ);
		q.setMaxResults(1);
		
		DwProreaativ dwProreaativ = (DwProreaativ) q.uniqueResult();
		if(dwProreaativ!=null)
			retorno= dwProreaativ;
		else 
			retorno= null;
		return retorno;
	}
}
