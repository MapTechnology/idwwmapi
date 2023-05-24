package idw.model.rn;

import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.OmAlgocor;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.webservices.dto.ListaTipoPTDTO;
import idw.webservices.dto.TipoPTDTO;

public class TipoPTRN extends AbstractRN<DAOGenerico>{
	
	public TipoPTRN() {
		super(new DAOGenerico());
	}

	public TipoPTRN(DAOGenerico dao) {
		super(dao);
	}

	public ListaTipoPTDTO getTipoPTDTO(TipoPTDTO filtro) {
		ListaTipoPTDTO retorno = new ListaTipoPTDTO();
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from OmTppt a");
		q.appendWhere(MapQuery._NULL, "a.cdTppt = :cdtppt", filtro.getOmTppt().getCdTppt() != null && filtro.getOmTppt().getCdTppt().equals("") == false);
		q.appendWhere(MapQuery._AND, "a.stAtivo = :stativo", filtro.getOmTppt().getStAtivo() != null && filtro.getOmTppt().getStAtivo() != null);
		
		q.defineParametro("cdtppt", filtro.getOmTppt().getCdTppt());
		q.defineParametro("stativo", filtro.getOmTppt().getStAtivo());
		
		System.out.println("query tipopt " + q.hqlToString());
		List<OmTppt> lista = q.list();
		
		for (OmTppt omTppt : lista) {
			TipoPTDTO dto = new TipoPTDTO();
			dto.setOmTppt(omTppt.clone(false));
			dto.getOmTppt().setOmUsrByIdUsrrevisao(omTppt.getOmUsrByIdUsrrevisao().clone(false));
			dto.getOmTppt().setOmUsrByIdUsrstativo(omTppt.getOmUsrByIdUsrstativo().clone(false));
			dto.getOmTppt().setOmAlgocor(omTppt.getOmAlgocor().clone(false));
			retorno.getLista().add(dto);
		}
		
		return retorno;
	}
	
	public TipoPTDTO setTipoPTDTO(TipoPTDTO dto) {
		TipoPTDTO retorno = new TipoPTDTO();
		
		UsuarioRN urn = new UsuarioRN(getDao());
		
		OmUsr omusrrevisao;
		try {
			omusrrevisao = urn.getOmUsr(dto.getOmTppt().getOmUsrByIdUsrrevisao().getCdUsr());
		} catch (RegistroDesconhecidoException e) {
			omusrrevisao = null;
		}
		OmUsr omusrstativo;
		try {
			omusrstativo = urn.getOmUsr(dto.getOmTppt().getOmUsrByIdUsrstativo().getCdUsr());
		} catch (RegistroDesconhecidoException e) {
			omusrstativo = null;
		}
		
		Long revisao = 1l;
		
		// Pesquisa se existe
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from OmTppt a");
		
		OmTppt omTppt = null;
		
		if (dto.getOmTppt().getIdTppt() != null && dto.getOmTppt().getIdTppt() > 0l) {
			// alteracao
			q.appendWhere(MapQuery._NULL, "a.idTppt = :idtppt", dto.getOmTppt().getIdTppt() > 0l);
			
			q.defineParametro("idtppt", dto.getOmTppt().getIdTppt());
			
			omTppt = (OmTppt) q.uniqueResult();
			
			OmTppt omTpptAnterior = new OmTppt();
			omTpptAnterior.setIdTppt(null);
			omTpptAnterior.setCdTppt(omTppt.getCdTppt());
			omTpptAnterior.setDsTppt(omTppt.getDsTppt());
			omTpptAnterior.setDtRevisao(omTppt.getDtRevisao());
			omTpptAnterior.setDtStativo(DataHoraRN.getDataHoraAtual());
			omTpptAnterior.setOmUsrByIdUsrrevisao(omTppt.getOmUsrByIdUsrrevisao());
			omTpptAnterior.setOmUsrByIdUsrstativo(omusrstativo);
			omTpptAnterior.setRevisao(omTppt.getRevisao());
			omTpptAnterior.setOmAlgocor(omTppt.getOmAlgocor());
			omTpptAnterior.setStAtivo((byte) 0);
			omTpptAnterior.setTpColeta(omTppt.getTpColeta());
			omTpptAnterior.setTpProducao(omTppt.getTpProducao());
			
			getDao().makePersistent(omTpptAnterior);
			
			revisao = omTppt.getRevisao() + 1;
		} else {
			// inclusao, ver se o codigo ja existe
			q.appendWhere(MapQuery._NULL, "a.cdTppt = :cd", true);
			q.appendWhere(MapQuery._AND, "a.stAtivo = 1", true);
			
			q.setMaxResults(1);
			q.defineParametro("cd", dto.getOmTppt().getCdTppt());
			
			omTppt = (OmTppt) q.uniqueResult();
			if (omTppt != null) {
				retorno.setOmTppt(omTppt.clone(false));
				retorno.getOmTppt().setOmUsrByIdUsrrevisao(omTppt.getOmUsrByIdUsrrevisao().clone(false));
				retorno.getOmTppt().setOmUsrByIdUsrstativo(omTppt.getOmUsrByIdUsrstativo().clone(false));
				retorno.getOmTppt().setOmAlgocor(omTppt.getOmAlgocor().clone(false));
				
				return retorno;
			}
			
			omTppt = new OmTppt();
			revisao = 1l;
			omTppt.setIdTppt(null);
		}
		
		// atribui novos valores
		omTppt.setCdTppt(dto.getOmTppt().getCdTppt());
		omTppt.setDsTppt(dto.getOmTppt().getDsTppt());
		omTppt.setDtRevisao(dto.getOmTppt().getDtRevisao());
		omTppt.setDtStativo(dto.getOmTppt().getDtStativo());
		omTppt.setOmUsrByIdUsrrevisao(omusrrevisao);
		omTppt.setOmUsrByIdUsrstativo(omusrstativo);
		omTppt.setRevisao(revisao);
		omTppt.setStAtivo(dto.getOmTppt().getStAtivo());
		omTppt.setTpColeta(dto.getOmTppt().getTpColeta());
		omTppt.setTpProducao(dto.getOmTppt().getTpProducao());
		omTppt.setIsIhmtrocaop(dto.getOmTppt().getIsIhmtrocaop());
		omTppt.setIsRequerTecnicoFimCip(dto.getOmTppt().getIsRequerTecnicoFimCip());
		omTppt.setIsRequerTecnicoInicioCip(dto.getOmTppt().getIsRequerTecnicoInicioCip());
		
		OmAlgocor omAlgocor;
		MapQuery q2 = new MapQuery(getDaoSession());
		
		q2.append("select a");
		q2.append("from OmAlgocor a");
		q2.append("where a.dsAlgocor =:ds");
		q2.defineParametro("ds", dto.getOmTppt().getOmAlgocor().getDsAlgocor());
		q2.setMaxResults(1);
		
		omAlgocor = (OmAlgocor) q2.uniqueResult();
		
		omTppt.setOmAlgocor(omAlgocor);
		
		
		
		getDao().makePersistent(omTppt);
		
		retorno.setOmTppt(omTppt.clone(false));
		retorno.getOmTppt().setOmUsrByIdUsrrevisao(omTppt.getOmUsrByIdUsrrevisao().clone(false));
		retorno.getOmTppt().setOmUsrByIdUsrstativo(omTppt.getOmUsrByIdUsrstativo().clone(false));
		retorno.getOmTppt().setOmAlgocor(omTppt.getOmAlgocor().clone(false));
		
		return retorno;
	}
	
	public TipoPTDTO excluirTipoPTDTO(TipoPTDTO filtro) {
		TipoPTDTO retorno = new TipoPTDTO();

		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from OmTppt a");
		q.appendWhere(MapQuery._NULL, "a.idtppt = :idtppt", filtro.getOmTppt().getIdTppt() > 0l);
		
		q.setMaxResults(1);
		
		q.defineParametro("idtppt", filtro.getOmTppt().getIdTppt());
		
		OmTppt OmTppt = (OmTppt) q.uniqueResult();
		
		if (OmTppt != null) {
			OmTppt.setStAtivo((byte) 0);
			OmTppt.setDtStativo(DataHoraRN.getDataHoraAtual());
			
			UsuarioRN rn = new UsuarioRN(getDao());
			OmUsr omusr = rn.getOmUsr(filtro.getOmTppt().getIdTppt());
			
			OmTppt.setOmUsrByIdUsrstativo(omusr);
			
			getDao().makePersistent(OmTppt);
			
			retorno.setOmTppt(OmTppt.clone(false));
		}

		return retorno;
	}
	
}
