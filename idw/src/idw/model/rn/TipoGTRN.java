package idw.model.rn;

import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.OmTpgt;
import idw.model.pojos.OmUsr;
import idw.webservices.dto.ListaTipoGTDTO;
import idw.webservices.dto.TipoGTDTO;

public class TipoGTRN extends AbstractRN<DAOGenerico>{
	
	public TipoGTRN() {
		super(new DAOGenerico());
	}

	public TipoGTRN(DAOGenerico dao) {
		super(dao);
	}

	public ListaTipoGTDTO getTipoGTDTO(TipoGTDTO filtro) {
		ListaTipoGTDTO retorno = new ListaTipoGTDTO();
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from OmTpgt a");
		q.appendWhere(MapQuery._NULL, "a.cdTpgt = :cdtpgt", filtro.getOmtpgt().getCdTpgt() != null && filtro.getOmtpgt().getCdTpgt().equals("") == false);
		q.appendWhere(MapQuery._AND, "a.stAtivo = :stativo", filtro.getOmtpgt().getStAtivo() != null && filtro.getOmtpgt().getStAtivo() != null);
		
		q.defineParametro("cdtpgt", filtro.getOmtpgt().getCdTpgt());
		q.defineParametro("stativo", filtro.getOmtpgt().getStAtivo());
		
		List<OmTpgt> lista = q.list();
		
		for (OmTpgt omtpgt : lista) {
			TipoGTDTO dto = new TipoGTDTO();
			dto.setOmtpgt(omtpgt.clone(false));
			dto.getOmtpgt().setOmUsrByIdUsrrevisao(omtpgt.getOmUsrByIdUsrrevisao().clone(false));
			dto.getOmtpgt().setOmUsrByIdUsrstativo(omtpgt.getOmUsrByIdUsrstativo().clone(false));
			retorno.getLista().add(dto);
		}
		
		return retorno;
	}
	
	public TipoGTDTO setTipoGTDTO(TipoGTDTO dto) {
		TipoGTDTO retorno = new TipoGTDTO();
		
		UsuarioRN urn = new UsuarioRN(getDao());
		
		OmUsr omusrrevisao;
		try {
			omusrrevisao = urn.getOmUsr(dto.getOmtpgt().getOmUsrByIdUsrrevisao().getCdUsr());
		} catch (RegistroDesconhecidoException e) {
			omusrrevisao = null;
		}
		OmUsr omusrstativo;
		try {
			omusrstativo = urn.getOmUsr(dto.getOmtpgt().getOmUsrByIdUsrstativo().getCdUsr());
		} catch (RegistroDesconhecidoException e) {
			omusrstativo = null;
		}
		
		Long revisao = 1l;
		
		// Pesquisa se existe
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from OmTpgt a");
		
		OmTpgt omtpgt = null;
		
		if (dto.getOmtpgt().getIdTpgt() != null && dto.getOmtpgt().getIdTpgt() > 0l) {
			// alteracao
			q.appendWhere(MapQuery._NULL, "a.idTpgt = :idtpgt", dto.getOmtpgt().getIdTpgt() > 0l);
			
			q.defineParametro("idtpgt", dto.getOmtpgt().getIdTpgt());
			
			omtpgt = (OmTpgt) q.uniqueResult();
			
			OmTpgt omtpgtAnterior = new OmTpgt();
			omtpgtAnterior.setIdTpgt(null);
			omtpgtAnterior.setCdTpgt(omtpgt.getCdTpgt());
			omtpgtAnterior.setDsTpgt(omtpgt.getDsTpgt());
			omtpgtAnterior.setDtRevisao(omtpgt.getDtRevisao());
			omtpgtAnterior.setDtStativo(DataHoraRN.getDataHoraAtual());
			omtpgtAnterior.setOmUsrByIdUsrrevisao(omtpgt.getOmUsrByIdUsrrevisao());
			omtpgtAnterior.setOmUsrByIdUsrstativo(omusrstativo);
			omtpgtAnterior.setRevisao(omtpgt.getRevisao());
			omtpgtAnterior.setStAtivo((byte) 0);
			
			getDao().makePersistent(omtpgtAnterior);
			
			revisao = omtpgt.getRevisao() + 1;
		} else {
			// inclusao, ver se o codigo ja existe
			q.appendWhere(MapQuery._NULL, "a.cdTpgt = :cd", true);
			q.appendWhere(MapQuery._AND, "a.stAtivo = 1", true);
			
			q.setMaxResults(1);
			q.defineParametro("cd", dto.getOmtpgt().getCdTpgt());
			
			omtpgt = (OmTpgt) q.uniqueResult();
			if (omtpgt != null) {
				retorno.setOmtpgt(omtpgt.clone(false));
				retorno.getOmtpgt().setOmUsrByIdUsrrevisao(omtpgt.getOmUsrByIdUsrrevisao().clone(false));
				retorno.getOmtpgt().setOmUsrByIdUsrstativo(omtpgt.getOmUsrByIdUsrstativo().clone(false));
				
				return retorno;
			}
			
			omtpgt = new OmTpgt();
			revisao = 1l;
			omtpgt.setIdTpgt(null);
		}
		
		// atribui novos valores
		omtpgt.setCdTpgt(dto.getOmtpgt().getCdTpgt());
		omtpgt.setDsTpgt(dto.getOmtpgt().getDsTpgt());
		omtpgt.setDtRevisao(dto.getOmtpgt().getDtRevisao());
		omtpgt.setDtStativo(dto.getOmtpgt().getDtStativo());
		omtpgt.setOmUsrByIdUsrrevisao(omusrrevisao);
		omtpgt.setOmUsrByIdUsrstativo(omusrstativo);
		omtpgt.setRevisao(revisao);
		omtpgt.setStAtivo(dto.getOmtpgt().getStAtivo());
		omtpgt.setTpConsolidacao(dto.getOmtpgt().getTpConsolidacao());
		
		getDao().makePersistent(omtpgt);
		
		retorno.setOmtpgt(omtpgt.clone(false));
		retorno.getOmtpgt().setOmUsrByIdUsrrevisao(omtpgt.getOmUsrByIdUsrrevisao().clone(false));
		retorno.getOmtpgt().setOmUsrByIdUsrstativo(omtpgt.getOmUsrByIdUsrstativo().clone(false));
		
		return retorno;
	}
	
	public TipoGTDTO excluirTipoGTDTO(TipoGTDTO filtro) {
		TipoGTDTO retorno = new TipoGTDTO();

		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from OmTpgt a");
		q.appendWhere(MapQuery._NULL, "a.idTpgt = :idtpgt", filtro.getOmtpgt().getIdTpgt() > 0l);
		
		q.setMaxResults(1);
		
		q.defineParametro("idtpgt", filtro.getOmtpgt().getIdTpgt());
		
		OmTpgt omtpgt = (OmTpgt) q.uniqueResult();
		
		if (omtpgt != null) {
			omtpgt.setStAtivo((byte) 0);
			omtpgt.setDtStativo(DataHoraRN.getDataHoraAtual());
			
			UsuarioRN rn = new UsuarioRN(getDao());
			OmUsr omusr = rn.getOmUsr(filtro.getOmtpgt().getIdTpgt());
			
			omtpgt.setOmUsrByIdUsrstativo(omusr);
			
			getDao().makePersistent(omtpgt);
			
			retorno.setOmtpgt(omtpgt.clone(false));
		}

		return retorno;
	}
	
}
