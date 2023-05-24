package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.dao.OmUsrDAO;
import idw.model.dao.OmUsrgrpDAO;
import idw.model.pojos.MsDetector;
import idw.model.pojos.MsInd;
import idw.model.pojos.MsTpevt;
import idw.model.pojos.MsTrigger;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.OmUsrgrp;
import idw.webservices.dto.MsDetectorDTO;
import idw.webservices.dto.MsDetectorsDTO;
import idw.webservices.dto.MsIndsDTO;
import idw.webservices.dto.MsTpEvtsDTO;
import idw.webservices.dto.OmTpptDTO;
import idw.webservices.dto.ResultadoDTO;

public class AlertaPlanejamentoRN implements IDao{

	private DAOGenerico dao;


	public AlertaPlanejamentoRN(){
		if(this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}

	public AlertaPlanejamentoRN(DAOGenerico dao) {
		this.dao = dao;
	}

	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}
	@Override
	public void iniciaConexaoBanco(Session sessao) {
		this.dao.iniciaSessao();
		this.dao.iniciaTransacao();
	}

	@Override
	public void finalizaConexaoBanco() {
		this.dao.finalizaTransacao();
		this.dao.finalizaSessao();
	}

	public MsDetectorDTO salvarAlertaPlanejamento(MsDetectorDTO dto){

		MsDetectorDTO retorno = new MsDetectorDTO();
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);

		//Pesquisar o plano para saber se já existe, se existir marcar pra excluir
		MsDetector msDetector = this.pesquisarMsDetectorPorCd(dto.getMsDetector().getCdDetector());
		if(msDetector != null) {
			if(((dto.getMsDetector().getIdDetector() != null)) && (dto.getMsDetector().getIdDetector().intValue() > 0)) {
				MsDetectorDTO Detectordto = this.excluirRegistro(dto);

				if((Detectordto.getResultadoDTO() != null) && (Detectordto.getResultadoDTO().getIdmensagem() != Detectordto.getResultadoDTO().COM_SUCESSO)) {
					resultadoDTO = Detectordto.getResultadoDTO();
					return retorno;
				}
			} else {
				resultadoDTO.setIdmensagem(resultadoDTO.REGISTRO_JA_EXISTE);
				return retorno;
			}
		}


        MsDetector msDetectorNovo = dto.getMsDetector().clone();

        msDetectorNovo.setIdDetector(null);
        msDetectorNovo.setStAtivo(new BigDecimal(1));
        msDetectorNovo.setDthrStativo(DataHoraRN.getDataHoraAtual());
        msDetectorNovo.setDthrRevisao(DataHoraRN.getDataHoraAtual());

		//verifica a revisao, se ja existe incrementa de 1, seta direto valor 1
		if ((msDetectorNovo.getRevisao() == null) || ((msDetectorNovo.getRevisao() != null) && (msDetectorNovo.getRevisao().intValue() <= 0)) ){
			msDetectorNovo.setRevisao(new BigDecimal(1));
		} else {
			msDetectorNovo.setRevisao(new BigDecimal(msDetectorNovo.getRevisao().intValue() + 1));
		}


		//verificar usuarios stAtivo e Revisao
		OmUsr omUsrStAtivo = null;
		OmUsr omUsrRevisao = null;
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(this.dao.getSession());

		try {
			omUsrStAtivo = usuarioRN.getDao().findById(OmUsr.class, dto.getMsDetector().getOmUsrByIdUsrstativo().getIdUsr(), false);

			if(omUsrStAtivo == null) {
				resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
				return retorno;

			}
		} catch(Exception e) {
			resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
			return retorno;
		}

		try {
			omUsrRevisao = usuarioRN.getDao().findById(OmUsr.class, dto.getMsDetector().getOmUsrByIdUsrstativo().getIdUsr(), false);

			if(omUsrRevisao == null) {
				resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
				return retorno;

			}
		} catch(Exception e) {
			resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
			return retorno;
		}

		msDetectorNovo.setOmUsrByIdUsrstativo(omUsrStAtivo);
		msDetectorNovo.setOmUsrByIdUsrrevisao(omUsrRevisao);
		
		OmUsrgrpDAO usrgrpDAO = new OmUsrgrpDAO(this.dao.getSession());
		
		OmUsrgrp omusrgrp = null;
		try {
			omusrgrp = usrgrpDAO.getOmUsrgrpPorCdAtivoOrderById(dto.getMsDetector().getOmUsrgrp().getCdUsrgrp());

			if(omusrgrp == null) {
				resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
				return retorno;

			}
		} catch(Exception e) {
			resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
			return retorno;
		}
		msDetectorNovo.setOmUsrgrp(omusrgrp);

		//salvar filhos
		msDetectorNovo.setMsTriggers(new HashSet<MsTrigger>());

		for (MsTrigger t :dto.getMsDetector().getMsTriggers()){
			t.setIdTrigger(null);
			t.setMsDetector(msDetectorNovo);
			msDetectorNovo.getMsTriggers().add(t);
		}



		msDetectorNovo = this.dao.makePersistent(msDetectorNovo);

		retorno = new MsDetectorDTO();
		retorno.setMsDetector(msDetectorNovo.clone());
		resultadoDTO.setIdmensagem(resultadoDTO.COM_SUCESSO);
		retorno.setResultadoDTO(resultadoDTO);


		return retorno;


	}


	public MsDetector pesquisarMsDetectorPorCd(String cdDetector){

		//verifica se já existe um registro com  cd
		MapQuery q = new MapQuery(this.dao.getSession());
		q.append("select d");
		q.append("from MsDetector d");
		q.append("where d.cdDetector = :cdDetector");
		q.append("and d.stAtivo =1");

		q.defineParametro("cdDetector", cdDetector);
		q.setMaxResults(1);

		MsDetector retorno = (MsDetector) q.uniqueResult();
		return retorno;
	}

	public MsDetectorDTO excluirRegistro(MsDetectorDTO dto) {
		MsDetectorDTO retorno = dto;
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);

		MsDetector msDetector = null;

		// Pesquisa o msDetector para excluir
		if (dto.getMsDetector().getIdDetector() != null){
			msDetector = this.dao.findById(MsDetector.class, dto.getMsDetector().getIdDetector().longValue() , false);
		}


		// Se nao existir o registro desejado para exclusao, entao retornar ao solicitante informando registro desconhecido
		if (msDetector == null){
			resultadoDTO.setIdmensagem(resultadoDTO.CODIGO_DESCONHECIDO);
			return retorno;
		}

		// Se o registro solicitado para exclusao ja estiver marcado como excluir, retornar ao solicitante informando a situacao
		if(msDetector.getStAtivo().intValue() == 0) {
			resultadoDTO.setIdmensagem(resultadoDTO.ERRO_EXCLUI_STATIVO_ZERO);
			return retorno;
		}

		// Pesquisar o usuario logado
		OmUsr msusr = null;
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(this.dao.getSession());

		try {
			msusr = usuarioRN.getDao().findById(OmUsr.class,dto.getMsDetector().getOmUsrByIdUsrstativo().getIdUsr(), false);

			if(msusr == null){
				resultadoDTO.setIdmensagem(resultadoDTO.USUARIO_DESCONHECIDO);
				return retorno;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}


		// Marca stAtivo com zero informando que registro foi desativado
		msDetector.setStAtivo(new BigDecimal(0));
		msDetector.setDthrStativo(DataHoraRN.getDataHoraAtual());
		msDetector.setOmUsrByIdUsrstativo(msusr);

		msDetector = this.dao.makePersistent(msDetector);


		retorno = new MsDetectorDTO();
		retorno.setMsDetector(msDetector.clone());
		resultadoDTO.setIdmensagem(resultadoDTO.COM_SUCESSO);
		retorno.setResultadoDTO(resultadoDTO);

		return retorno;
	}


	public MsDetectorsDTO pesquisarMsDetector(MsDetectorDTO dto) {
		MsDetectorsDTO retorno = new MsDetectorsDTO();
		MapQuery query = new MapQuery(this.dao.getSession());
		query.append("SELECT d");
		query.append("FROM MsDetector d");
		query.appendWhere(MapQuery._NULL,"d.cdDetector = :cdDetector", !dto.getMsDetector().getCdDetector().equals(""));
		query.appendWhere(MapQuery._AND,"d.dsDetector = :dsDetector", !dto.getMsDetector().getDsDetector().equals(""));
		query.appendWhere(MapQuery._AND,"d.omUsrgrp.idUsrgrp = :idOmUsrgrp", dto.getMsDetector().getOmUsrgrp() != null);
		query.appendWhere(MapQuery._AND,"d.isEmail = :isEmail", dto.getMsDetector().getIsEmail());
		query.appendWhere(MapQuery._AND,"d.isSms = :isSms", dto.getMsDetector().getIsSms());
		query.appendWhere(MapQuery._AND,"d.stAtivo = :stAtivo", dto.getMsDetector().getStAtivo() != null);
		query.appendWhere(MapQuery._AND,"d.dthrRevisao >= :dtRevisao AND d.dthrRevisao <= :dtRevisaoF", dto.getMsDetector().getDthrRevisao() != null);
		query.appendWhere(MapQuery._AND,"d.dthrStativo >= :dtStativo AND d.dthrStativo <= :dtStativoF", dto.getMsDetector().getDthrStativo() != null);
		
		query.defineParametro("cdDetector", dto.getMsDetector().getCdDetector());
		query.defineParametro("dsDetector", dto.getMsDetector().getDsDetector());

		if(dto.getMsDetector().getStAtivo() != null) {
			query.defineParametro("stAtivo",  dto.getMsDetector().getStAtivo());
		}
		if(dto.getMsDetector().getOmUsrgrp() != null) {
			query.defineParametro("idOmUsrgrp",  dto.getMsDetector().getOmUsrgrp().getIdUsrgrp());
		}
		if(dto.getMsDetector().getIsEmail()) {
			query.defineParametro("isEmail", dto.getMsDetector().getIsEmail());
		}
		if(dto.getMsDetector().getIsSms()) {
			query.defineParametro("isSms", dto.getMsDetector().getIsSms());
		}
		if(dto.getMsDetector().getDthrRevisao() != null) {
			query.defineParametro("dtRevisao", dto.getMsDetector().getDthrRevisao());
			query.defineParametro("dtRevisaoF",DataHoraRN.getDataHora235959(dto.getMsDetector().getDthrRevisao()));
		}
		if(dto.getMsDetector().getDthrStativo() != null) {
			query.defineParametro("dtStativo", dto.getMsDetector().getDthrStativo());
			query.defineParametro("dtStativoF",DataHoraRN.getDataHora235959(dto.getMsDetector().getDthrStativo()));
		}
		
		List<MsDetector> listaDetector = query.list();

		if (listaDetector == null){
			retorno.setListaMsDetectorDTO(new ArrayList<MsDetectorDTO>());
			return retorno;
		}

		List<MsDetectorDTO> listaDetectorDTO = new ArrayList<MsDetectorDTO>();

		for(MsDetector d :listaDetector){
			MsDetectorDTO msDetectorDTO = new MsDetectorDTO();
			msDetectorDTO.setMsDetector(d.clone());
			listaDetectorDTO.add(msDetectorDTO);
		}

		retorno.setListaMsDetectorDTO(listaDetectorDTO);
		return retorno;
	}


	public MsDetectorDTO excluirMsDetectors(MsDetectorsDTO msDetectorsDTO) {

		MsDetectorDTO retorno = new MsDetectorDTO();
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);

		// Pesquisar o usuario logado
		OmUsr omusr = null;
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(this.dao.getSession());


		for (MsDetectorDTO dto :msDetectorsDTO.getListaMsDetectorDTO()){
			
			try {
				
//				omusr = usuarioRN.getDao().findById(OmUsr.class, dto.getMsDetector().getOmUsrByIdUsrstativo().getIdUsr(), false);

				OmUsrDAO usrDAO = new OmUsrDAO(dao.getSession());
				omusr = usrDAO.getOmUsrPorCdAtivo(dto.getMsDetector().getOmUsrByIdUsrstativo().getCdUsr());
//				usrDAO.getOmUsrPorCdAtivo(dto.getMsDetector().getOmUsrByIdUsr.getCdUsr());
				
				if(omusr == null){
					resultadoDTO.setIdmensagem(resultadoDTO.USUARIO_DESCONHECIDO);
					return retorno;
				}
			} catch(Exception e) {
				e.printStackTrace();
			}



			MsDetector msdetector = this.dao.findById(MsDetector.class, dto.getMsDetector().getIdDetector().longValue(), false);

			// Marca stAtivo com zero informando que registro foi desativado
			msdetector.setStAtivo(new BigDecimal(0)); //(char) 0
			msdetector.setDthrStativo(DataHoraRN.getDataHoraAtual());
			msdetector.setOmUsrByIdUsrstativo(omusr);

			this.dao.makePersistent(msdetector);
		}





		retorno.getResultadoDTO().setIdmensagem(resultadoDTO.COM_SUCESSO);

		return retorno;
	}


	public MsTpEvtsDTO pesquisarMsTpEvts(){
	    MapQuery query = new MapQuery(this.dao.getSession());
	    query.append("Select tpEvt ");
	    query.append("from MsTpevt tpEvt");

	    List<MsTpevt> listaTpEvts = query.list();
		List<MsTpevt> listaretorno = new ArrayList<MsTpevt>();
	    MsTpEvtsDTO retorno = new MsTpEvtsDTO();

	    for (MsTpevt evt : listaTpEvts){
	    	listaretorno.add(evt.clone(false));
	    }

	    retorno.setListaTpEvts(listaretorno);

	    return retorno;
	}

	public OmTpptDTO pesquisarOmTppts(){
		MapQuery query = new MapQuery(this.dao.getSession());
	    query.append("Select omTppt ");
	    query.append("from OmTppt omTppt");
	    query.append("where omTppt.stAtivo = 1 ");

	    List<OmTppt> listaOmtppts = query.list();

	    OmTpptDTO retorno = new OmTpptDTO();
	    List<OmTppt> listaRetorno = new ArrayList<OmTppt>();
	    for(OmTppt omtppt : listaOmtppts){
	    	listaRetorno.add(omtppt.clone());
	    }
	    retorno.setListaOmTppts(listaRetorno);

	    return retorno;
	}

	public MsIndsDTO pesquisaInds(){
		MapQuery query = new MapQuery(this.dao.getSession());

	    query.append("from MsInd msind where msind.idInd >= 12");


	    List<MsInd> listaMsInds = query.list();
		List<MsInd> listaRetorno = new ArrayList<MsInd>();

	    MsIndsDTO retorno = new MsIndsDTO();

	    for(MsInd msInd : listaMsInds){
	    	listaRetorno.add(msInd.clone());
	    }
	    retorno.setListaMsInds(listaRetorno);

	    return retorno;
	}


}
