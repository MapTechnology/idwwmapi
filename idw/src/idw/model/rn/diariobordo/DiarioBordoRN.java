package idw.model.rn.diariobordo;

import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwNserieobs;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.rn.AbstractRN;
import idw.model.rn.NumeroSerieRN;
import idw.model.rn.UsuarioRN;

public class DiarioBordoRN extends AbstractRN<DAOGenerico>{

	public DiarioBordoRN() {
		super(new DAOGenerico());
	}
	public DiarioBordoRN(DAOGenerico dao) {
		super(dao);
	}
	
	// Metodo responsavel em salvar o diario de bordo digitador pelo tecnico do reprocesso
	public void setDiarioBordo(DiarioBordoDTO obs) {
		// Instancia as chaves estrangeiras
		DwNserie dwnserie;
		OmPt ompt = getDao().findById(OmPt.class, obs.getIdPosto(), false);
		OmUsr omusr;
		
		
		// pesquisa NS pelo CB
		NumeroSerieRN rn  = new NumeroSerieRN(getDao());
		
		try {
			dwnserie = rn.getDwNserieCb(obs.getNs());
		} catch (NumeroSerieIrregularException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dwnserie = null;
		}
		
		// pesquisa pelo operador
		UsuarioRN urn = new UsuarioRN(getDao());
		omusr = urn.getOmUsrByLoginStAtivo(obs.getUsuario());
		
		DwNserieobs nserieobs = new DwNserieobs();
		
		nserieobs.setDsObs(obs.getObs());
		nserieobs.setDthrObs(obs.getDthrObs());
		nserieobs.setDwNserie(dwnserie);
		nserieobs.setOmPt(ompt);
		nserieobs.setOmUsr(omusr);
		
		getDao().makePersistent(nserieobs);
	}

	public DiariosBordoDTO getDiariosBordoDTO(String ns) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwNserieobs a");
		q.append("join a.dwNserie b");
		q.append("where b.cb = :cb");
		
		q.defineParametro("cb", ns);
		
		DiariosBordoDTO retorno = new DiariosBordoDTO();
		List<DwNserieobs> lista = q.list();
		for (DwNserieobs obs : lista) {
			DiarioBordoDTO dto = new DiarioBordoDTO();
			dto.setDthrObs(obs.getDthrObs());
			dto.setObs(obs.getDsObs());
			dto.setPosto(obs.getOmPt().getCdPt());
			dto.setIdPosto(obs.getOmPt().getIdPt());
			dto.setUsuario(obs.getOmUsr().getCdUsr());
			retorno.getDiarios().add(dto);
		}
		return retorno;
	}
}
