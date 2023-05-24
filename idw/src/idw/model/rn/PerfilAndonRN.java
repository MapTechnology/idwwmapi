package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MsIcDAO;
import idw.model.dao.MsPerfilandonDAO;
import idw.model.dao.MsUsrDAO;
import idw.model.pojos.MsIc;
import idw.model.pojos.MsPerfilandon;
import idw.model.pojos.MsPerfilregras;
import idw.model.pojos.MsUsr;
import idw.webservices.dto.PerfilAndonDTO;
import idw.webservices.dto.PerfisAndonDTO;

public class PerfilAndonRN extends AbstractRN<DAOGenerico> {

	public PerfilAndonRN() {
		this(null);
	}

	public PerfilAndonRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public PerfisAndonDTO getMsPerfilandon(PerfilAndonDTO dto) {
		PerfisAndonDTO retorno = new PerfisAndonDTO();
		retorno.setAndonDTOs(new ArrayList<PerfilAndonDTO>());
		MsPerfilandonDAO dao = new MsPerfilandonDAO(getDaoSession());
		List<MsPerfilandon> lista = dao.getMsPerfilandons(dto.getMsPerfilandon());
		for(MsPerfilandon item : lista) {
			PerfilAndonDTO andonDTO = new  PerfilAndonDTO();
			andonDTO.setMsPerfilandon(item.clone());
			retorno.getAndonDTOs().add(andonDTO);
		}		
		return retorno;
	}
	
	public PerfisAndonDTO getPerfilAndonsAtivos() {
		PerfisAndonDTO retorno = new PerfisAndonDTO();
		retorno.setAndonDTOs(new ArrayList<PerfilAndonDTO>());
		MsPerfilandonDAO dao = new MsPerfilandonDAO(getDaoSession());
		List<MsPerfilandon> lista = dao.getPerfilAndonsAtivos();
		for(MsPerfilandon item : lista) {
			PerfilAndonDTO andonDTO = new  PerfilAndonDTO();
			andonDTO.setMsPerfilandon(item.clone(false));
			retorno.getAndonDTOs().add(andonDTO);
		}		
		return retorno;		
	}
	
	
	public PerfilAndonDTO setMsPerfilandon(PerfilAndonDTO dto) {
		
		PerfilAndonDTO retorno = new PerfilAndonDTO();
		
		retorno.setResultadoEvento(retorno.getEVENTO_BEM_SUCEDIDO());
		
		if (dto.getMsPerfilandon().getCdPerfilandon().isEmpty()) {
			retorno.setResultadoEvento(retorno.getERRO_CD_INVALIDO());
			return retorno;
		}
		
		if (dto.getMsPerfilandon().getDsPerfilandon().isEmpty()) {
			retorno.setResultadoEvento(retorno.getERRO_DS_INVALIDO());
			return retorno;
		}
		
		MsPerfilandonDAO dao = new MsPerfilandonDAO(getDaoSession());
		MsPerfilandon andonOriginal = dto.getMsPerfilandon().clone();
		MsPerfilandon andonAlteracao = dao.getMsPerfilAndonPorCdAtivo(dto.getMsPerfilandon().getCdPerfilandon());
		
		// Se for inclusão...
		if(andonAlteracao == null) {
			andonOriginal.setRevisao(1l);
			andonOriginal.setDtRevisao(DataHoraRN.getDataHoraAtual());
			andonOriginal.setDtStativo(DataHoraRN.getDataHoraAtual());
		
			// Alteração...
		} else {
			
			// Testa se o código já existe
			if(andonOriginal.getIdPerfilandon() == null) {
				MsPerfilandon perfilAux = dao.getMsPerfilAndonPorCdAtivo(dto.getMsPerfilandon().getCdPerfilandon());
				if(perfilAux != null) {
					retorno.setResultadoEvento(retorno.getERRO_CD_JA_CADASTRADO());
					return retorno;
				}
			}
			
			// Seta alguns dados
			andonAlteracao.setDtStativo(DataHoraRN.getDataHoraAtual());
			andonAlteracao.setStAtivo((byte) 0);
			andonOriginal.setIdPerfilandon(null);
			andonOriginal.setRevisao(andonAlteracao.getRevisao() + 1);
			andonOriginal.setDtRevisao(DataHoraRN.getDataHoraAtual());
			andonOriginal.setDtStativo(DataHoraRN.getDataHoraAtual());
			
			// Inicializa a lista de Ics do Andon
			for (Iterator<MsIc> i = andonAlteracao.getMsIcs().iterator(); i.hasNext();) {
				MsIc ic = i.next();
				ic.setMsPerfilandon(null);
				getDao().makePersistent(ic);
				i.remove();
			}
			
		}
		
		
		// Monta as regras
		Set<MsPerfilregras> regras = null;
		if(andonOriginal.getMsPerfilregrases() != null && !andonOriginal.getMsPerfilregrases().isEmpty()) {
			regras = new HashSet<>();
			for(MsPerfilregras regra : andonOriginal.getMsPerfilregrases()) {
				regra.setIdPerfilregras(null);
				regra.setMsPerfilandon(andonOriginal);
				regras.add(regra);
			}
		}
		// Seta as regras
		andonOriginal.setMsPerfilregrases(regras);
		
		
		// Seta o usuário ativo
		MsUsrDAO usuarioDAO = new MsUsrDAO(getDaoSession());
		try {
			MsUsr usrAtivo = usuarioDAO.getMsUsrPorLoginAtivo(dto.getMsPerfilandon().getMsUsrByIdUsrStAtivo().getLogin());
			if(usrAtivo == null) {
				retorno.setResultadoEvento(retorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
				return retorno;
			}
			andonOriginal.setMsUsrByIdUsrStAtivo(usrAtivo);
		} catch (Exception e) {
			retorno.setResultadoEvento(retorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
			e.printStackTrace();
			return retorno;
		}
		
		
		// Seta o usuário da revisão
		try {
			MsUsr usr = usuarioDAO.getMsUsrPorLoginAtivo(dto.getMsPerfilandon().getMsUsrByIdUsrRevisao().getLogin());
			if(usr == null) {
				retorno.setResultadoEvento(retorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
				return retorno;
			}
			andonOriginal.setMsUsrByIdUsrRevisao(usr);
			if(andonAlteracao != null) {
				andonAlteracao.setMsUsrByIdUsrRevisao(usr);
			}
		} catch (Exception e) {
			retorno.setResultadoEvento(retorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
			e.printStackTrace();
			return retorno;
		}
		
		
		// Se chegou até aqui sem nenhum erro, então salva
		if (retorno.getResultadoEvento() == retorno.getEVENTO_BEM_SUCEDIDO()) {
			try {
				andonOriginal = this.getDao().makePersistent(andonOriginal);
				if (andonAlteracao != null) {
					andonAlteracao = this.getDao().makePersistent(andonAlteracao);
				}
			} catch (Exception e) {
				retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
				e.printStackTrace();
				return retorno;
			}
		}
		
		// Seta o retorno
		retorno.setMsPerfilandon(andonOriginal.clone());
		
		
		// Associa o "perfil do andon" aos "ICs selecionados" (salva o "id do andon" na tabela de ICs "ms_ic")
		if (andonOriginal.getMsIcs() != null && !andonOriginal.getMsIcs().isEmpty()) {
			MsIcDAO icDAO = new MsIcDAO(getDaoSession());
			for(MsIc item : andonOriginal.getMsIcs()) {
				MsIc ic = icDAO.getMsIc(item.getIdIc().intValue());
				ic.setMsPerfilandon(andonOriginal);
				ic = getDao().makePersistent(ic);
				retorno.getMsPerfilandon().getMsIcs().add(ic.clone(false));
			}
		}
		
		
		return retorno;
		
	}
	
	
	public PerfilAndonDTO excluirPerfilAndon(PerfilAndonDTO dto) {
		PerfilAndonDTO retorno = new PerfilAndonDTO();
		MsPerfilandonDAO dao = new MsPerfilandonDAO(getDaoSession());
		MsPerfilandon perfilAndon = dao.getMsPerfilAndonPorId(dto.getMsPerfilandon().getIdPerfilandon());
		perfilAndon.setStAtivo((byte) 0);
		perfilAndon.setDtStativo(new Date());
		
		try {
			MsUsrDAO usuarioDAO = new MsUsrDAO(getDaoSession());
			MsUsr usr = usuarioDAO.getMsUsrPorLoginAtivo(dto.getMsPerfilandon().getMsUsrByIdUsrStAtivo().getLogin());
			perfilAndon.setMsUsrByIdUsrStAtivo(usr);
		} catch (Exception e) {
			retorno.setResultadoEvento(retorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
			e.printStackTrace();
			return retorno;
		}
		
		try {
			perfilAndon = this.getDao().makePersistent(perfilAndon);
		} catch (Exception e) {
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
			e.printStackTrace();
			return retorno;
		}
		
		retorno.setMsPerfilandon(perfilAndon.clone());
		
		return retorno;
	}
	
}
