package idw.model.rn.estoque;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwEstDAO;
import idw.model.dao.DwEstlocalDAO;
import idw.model.dao.DwEstlocalproDAO;
import idw.model.dao.OmGtDAO;
import idw.model.dao.OmPaDAO;
import idw.model.dao.OmPtDAO;
import idw.model.dao.OmUsrDAO;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstlocal;
import idw.model.pojos.DwEstlocalpro;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.folhainspecaorap.FolhaInspecaoRapRN;
import idw.util.Util;
import idw.webservices.dto.CamposEmUsoOmCfgDTO;
import idw.webservices.dto.DwEstlocalDTO;
import idw.webservices.dto.DwEstlocalsDTO;

public class LocalEstoqueRN extends AbstractRN<DAOGenerico>{

	public LocalEstoqueRN() {
		this(null);
	}
	
	public LocalEstoqueRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public DwEstlocalsDTO getDwEstlocal(DwEstlocalDTO filtro){
		DwEstlocalDAO dwEstlocalDAO = new DwEstlocalDAO(getDaoSession());
		List<DwEstlocal> listaDwEstlocal = dwEstlocalDAO.getDwEstLocalPorFiltro(filtro.getDwEstlocal());
		DwEstlocalsDTO retorno = new DwEstlocalsDTO();
		retorno.setDwEstlocalDTOs(new ArrayList<DwEstlocalDTO>());
		for(DwEstlocal dwEstlocal : listaDwEstlocal){
			DwEstlocalDTO dwEstlocalDTO = new DwEstlocalDTO();
			dwEstlocalDTO.setDwEstlocal(dwEstlocal.clone(true));
			retorno.getDwEstlocalDTOs().add(dwEstlocalDTO);
		}
		return retorno;
	}
	
	public DwEstlocalDTO setDwEstlocal(DwEstlocalDTO dwEstlocalDTO){
		DwEstlocalDTO retorno = new DwEstlocalDTO();
		retorno.setResultadoEvento(retorno.getEVENTO_BEM_SUCEDIDO());
		
		if (dwEstlocalDTO.getDwEstlocal() == null || dwEstlocalDTO.getDwEstlocal().getCdLocal().trim().equals("")){
			dwEstlocalDTO.setResultadoEvento(dwEstlocalDTO.getERRO_CD_LOCAL_ESTOQUE_INVALIDO());
			return dwEstlocalDTO;
		}
		
		DwEstlocalDAO dwEstlocalDao = new DwEstlocalDAO(getDaoSession());
		DwEstlocal estOriginal = dwEstlocalDao.getDwEstlocalPorId(dwEstlocalDTO);
		
		//20160926FVA:
		if (estOriginal != null && estOriginal.getIdEstlocal() > 0 && estOriginal.getStAtivo().equals((byte)0)) {
			retorno.setResultadoEvento(retorno.getERRO_REATIVACAO_INDISPONIVEL());
			return retorno;
		}

		
		DwEstlocal estAlteracao = null;
		
		/* Se o id nao foi passado, estOriginal ser� null, entao verificar se ja existe o codigo do local cadastrado para o mesmo estoque
		 * 
		 */
		if (estOriginal == null) {
			estOriginal = dwEstlocalDao.getDwEstlocalPorCdAtivoOrderById(dwEstlocalDTO.getDwEstlocal().getCdLocal());
			if (estOriginal != null) {
				dwEstlocalDTO.setResultadoEvento(dwEstlocalDTO.getERRO_LOCAL_ESTOQUE_JA_EXISTE());
				return dwEstlocalDTO;
			}
		}
		
		if(estOriginal == null){
			estOriginal = dwEstlocalDTO.getDwEstlocal().clone();
			estOriginal.setRevisao(1l);
			estOriginal.setDtRevisao(new Date());
			estOriginal.setStAtivo((byte)1);
			estOriginal.setDtStativo(new Date());	
		}else{
			/*
			 * Se o registro original ja estiver inativo, entao nao permitir alteracao
			 *
			 */
			if (estOriginal.getStAtivo().equals((byte) 0)){
				dwEstlocalDTO.setResultadoEvento(dwEstlocalDTO.getERRO_REATIVACAO_INDISPONIVEL());
				return dwEstlocalDTO;
			}
			estAlteracao = estOriginal.clone();
			estAlteracao.setStAtivo((byte)0);
			estAlteracao.setDtRevisao(new Date());
			estAlteracao.setIdEstlocal(null);

			estOriginal.setRevisao(estAlteracao.getRevisao() + 1);
			estOriginal.setStAtivo((byte)1);
			estOriginal.setDtStativo(DataHoraRN.getDataHoraAtual());
			estOriginal.setDtRevisao(DataHoraRN.getDataHoraAtual());
			estOriginal.setCdLocal(dwEstlocalDTO.getDwEstlocal().getCdLocal());
			estOriginal.setDsLocal(dwEstlocalDTO.getDwEstlocal().getDsLocal());
			estOriginal.setTpLocalEstoque(dwEstlocalDTO.getDwEstlocal().getTpLocalEstoque());
			estOriginal.setAutomatico(dwEstlocalDTO.getDwEstlocal().getAutomatico());
		}
		
		OmUsrDAO usrDAO = new OmUsrDAO(getDaoSession());
		OmUsr usrStativo = usrDAO.getOmUsrPorCdAtivo(dwEstlocalDTO.getDwEstlocal().getOmUsrByIdUsrstativo().getCdUsr());
		if(usrStativo != null){
			estOriginal.setOmUsrByIdUsrstativo(usrStativo);
		}else{
			retorno.setResultadoEvento(retorno.getERRO_USUARIO_STATIVO_DESCONHECIDO());
			return retorno;
		}

		OmUsr usrRevisao = usrDAO.getOmUsrPorCdAtivo(dwEstlocalDTO.getDwEstlocal().getOmUsrByIdUsrrevisao().getCdUsr());
		if(usrRevisao != null){
			estOriginal.setOmUsrByIdUsrrevisao(dwEstlocalDTO.getDwEstlocal().getOmUsrByIdUsrrevisao());
		}else{
			retorno.setResultadoEvento(retorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
			return retorno;
		}

		DwEstDAO dwEstDAO = new DwEstDAO(getDaoSession());
		DwEst estoque = dwEstDAO.getDwEstPorId(dwEstlocalDTO.getDwEstlocal().getDwEst().getIdEst()); 

		if(estoque != null){
			estOriginal.setDwEst(estoque);
		}else{
			retorno.setResultadoEvento(retorno.getERRO_ESTOQUE_DESCONHECIDO());
			return retorno;
		}

		OmGt omgtCic = null;
		if (dwEstlocalDTO.getDwEstlocal().getOmGt() != null) {
			OmGtDAO gtDAO = new OmGtDAO(getDaoSession());
			omgtCic = gtDAO.getOmGtPorId(dwEstlocalDTO.getDwEstlocal().getOmGt().getIdGt()); 
			estOriginal.setOmGt(omgtCic);
		}
		
		OmPt omptCic = null;
		if (dwEstlocalDTO.getDwEstlocal().getOmPt() != null) {
			OmPtDAO ptDAO = new OmPtDAO(getDaoSession());
			omptCic = ptDAO.getOmPtPorId(dwEstlocalDTO.getDwEstlocal().getOmPt().getIdPt()); 
			estOriginal.setOmPt(omptCic);
		}
		
		OmPa ompaCic = null;
		if (dwEstlocalDTO.getDwEstlocal().getOmPa() != null) {
			OmPaDAO paDAO = new OmPaDAO(getDaoSession());
			ompaCic = paDAO.getOmPaPorId(dwEstlocalDTO.getDwEstlocal().getOmPa().getIdPa()); 
			estOriginal.setOmPa(ompaCic);
		}
		
		if (retorno.getResultadoEvento() == retorno.getEVENTO_BEM_SUCEDIDO()){
			estOriginal = this.getDao().makePersistent(estOriginal);
			if (estAlteracao != null){
				this.getDao().makePersistent(estAlteracao);
			}
		}
		
		retorno.setDwEstlocal(estOriginal.clone());
		return retorno;
	}
	
	public DwEstlocalDTO removeDwEstlocal(DwEstlocalDTO estlocalDTO) {
		DwEstlocalDTO retorno = new DwEstlocalDTO();
		DwEstlocalDAO dwEstlocalDao = new DwEstlocalDAO(getDaoSession());
		OmUsrDAO usrDAO = new OmUsrDAO(getDaoSession());	
		DwEstlocal estLocal = dwEstlocalDao.getDwEstlocalPorId(estlocalDTO);
		
		
		//17/03/2017 Alex: nao remover codigo em uso na configuracao geral.
		CamposEmUsoOmCfgDTO camposEmUsoOmCfgDTO = getCamposEmUsoOmCfg(estlocalDTO);
		retorno.setCamposEmUsoOmCfg(camposEmUsoOmCfgDTO);
		if(camposEmUsoOmCfgDTO.getStatus() != camposEmUsoOmCfgDTO.getSTATUS_NENHUM_CAMPO_EM_USO()) {
			//se entrar nesse if eh pq existe algum codigo em uso
			return retorno;
		}
				
		
		if (estLocal == null){
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
			retorno.setDwEstlocal(estlocalDTO.getDwEstlocal());
			return retorno;
		}else if (estLocal.getStAtivo() == 0){
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
			retorno.setDwEstlocal(estlocalDTO.getDwEstlocal());
			return retorno;
		}else{
			estLocal.setStAtivo((byte)0);
			estLocal.setDtStativo(new Date());	
			OmUsr usrStAtivo = usrDAO.getOmUsrPorCdAtivo(estlocalDTO.getDwEstlocal().getOmUsrByIdUsrstativo().getCdUsr());
			
			if(usrStAtivo != null){
				estLocal.setOmUsrByIdUsrstativo(usrStAtivo);
			}else{
				retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
				retorno.setDwEstlocal(estlocalDTO.getDwEstlocal());
				return retorno;
			}
			try{
				estLocal = this.getDao().makePersistent(estLocal);
			} catch (Exception e){
				e.printStackTrace();
			}
			retorno.setDwEstlocal(estLocal.clone());
			retorno.setResultadoEvento(retorno.getEVENTO_BEM_SUCEDIDO());
			return retorno;
		}
	}
	
	private CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg(DwEstlocalDTO item) {
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		
		//campos
		DwEstlocal estoqueLocalOrigemEmUso = omcfg.getDwEstlocalorigalim();
		
		CamposEmUsoOmCfgDTO camposEmUsoOmCfg = new CamposEmUsoOmCfgDTO();
		
		camposEmUsoOmCfg.setCodigo(item.getDwEstlocal().getCdLocal());
		
		boolean isTemCodigoEmUso = false;
		if(estoqueLocalOrigemEmUso != null) {
			if(item.getDwEstlocal().getCdLocal().equals(estoqueLocalOrigemEmUso.getCdLocal())) {
				camposEmUsoOmCfg.setLocalEstoqueOrigem(true);
				isTemCodigoEmUso = true;
			}
		}
		
		if(isTemCodigoEmUso) {
			camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_TEM_CAMPO_EM_USO());
		} else {
			camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_NENHUM_CAMPO_EM_USO());
		}
		
		return camposEmUsoOmCfg;
	}
	
	public DwEstlocalpro getDwEstlocalproCriaSenaoExistir(DwEstlocal dwEstlocal, DwEstpro dwEstpro, OmProduto produto) {
		DwEstlocalproDAO dwEstlocalproDAO = new DwEstlocalproDAO(getDaoSession());
		DwEstlocalpro estlocalpro = dwEstlocalproDAO.getDwEstlocalproPeloEstlocalProduto(dwEstlocal, produto);
			estlocalpro = newDwEstlocalpro(dwEstlocal, dwEstpro);
			if(estlocalpro == null){
			getDao().makePersistent(estlocalpro);			
		}
		return estlocalpro;
	}
	
	private DwEstlocalpro newDwEstlocalpro(DwEstlocal dwEstlocal, DwEstpro dwEstpro){
		DwEstlocalpro dwEstlocalpro = new DwEstlocalpro();
		dwEstlocalpro.setDwEstlocal(dwEstlocal);
		dwEstlocalpro.setDwEstpro(dwEstpro);
		dwEstlocalpro.setPpCp(null);
		dwEstlocalpro.setQtEntrada(BigDecimal.ZERO);
		dwEstlocalpro.setQtAjuste(BigDecimal.ZERO);
		dwEstlocalpro.setQtSaida(BigDecimal.ZERO);
		dwEstlocalpro.setQtTotal(BigDecimal.ZERO);
		return dwEstlocalpro;
	}

	
	
	/* Metodo para retornar se o local recebido é valido e se requer alguma validacao para a ferramenta passada
	 * 
	 */
	public LocalEstoqueDTO validarLocalEstoque(String cdlocalOrigem, String cdlocalDestino, String cdrap) {
		LocalEstoqueDTO retorno = new LocalEstoqueDTO();
		DwEstlocalDAO rn = new DwEstlocalDAO(getDaoSession());
		
		DwEstlocal dwestlocal = rn.getDwEstlocalPorCdAtivoOrderById(cdlocalDestino);
		
		if (dwestlocal != null) {
			FolhaInspecaoRapRN rrn = new FolhaInspecaoRapRN(getDao());
			retorno.setStatus("200");
			if (dwestlocal.getDwEst() != null)
				retorno.setCdEstoque(dwestlocal.getDwEst().getCdEst());
			retorno.setFolhains(rrn.getQqFolhaInsRapDTO(cdlocalOrigem, cdlocalDestino, cdrap));
			retorno.setIsInspecionar(retorno.getFolhains() != null);
		} else {
			retorno.setStatus("400");
			retorno.setTitle("Local estoque desconhecido");
		}
		
		return retorno;
	}
	
}
