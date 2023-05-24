package idw.model.rn;

import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwPassdef;
import idw.model.pojos.DwTDefeito;
import idw.webservices.dto.AcaoDTO;
import idw.webservices.dto.DefeitoDTO;
import idw.webservices.dto.MontagemDTO;
import idw.webservices.dto.OrigemDTO;
import idw.webservices.dto.PassagemDTO;
import injetws.model.excessoes.SemSGBDException;


public class PostoTesteVisualRN extends PostoPassagemRNAbs {

	public PostoTesteVisualRN() {
		super(new DAOGenerico());
	}
	
	public PostoTesteVisualRN(DAOGenerico dao) {
		super(dao);
	}

	@Override
	protected void postoTesteVisual(List<DefeitoDTO> listaDefeitos, DwPassagem passagem) {
		// se listaDeDefeitos n�o estiver vazia, ent�o salvar defeitos passados
		
		// interagir sobre listaCDDefeitos
		for(DefeitoDTO defeito : listaDefeitos) {
			this.salvaDefeito(defeito.getIdTDefeito(), defeito.getIdTAcao(), passagem);
		}
		
	}
	
	private void salvaDefeito(Long idTDefeito, long idTAcao, DwPassagem passagem) {
		DwTDefeito dwtdefeito = null;
		
		DiversosRN rn = new DiversosRN();
		rn.setSession(getDaoSession());
		
		dwtdefeito = (DwTDefeito) rn.findById(DwTDefeito.class, idTDefeito, false);
		
		DwPassdef dwpassdef = new DwPassdef();
		
		dwpassdef.setDwPassagem(passagem);
		dwpassdef.setDwTDefeito(dwtdefeito);
		
		getDaoSession().merge(dwpassdef);
	}

	@Override
	protected void postoMontagem(List<MontagemDTO> listaMontagem,
			DwPassagem oDwPassagem, DwNserie oDwNserie, PassagemDTO retorno) {
		// faz nada
	}
	@Override
	protected void postoReprocesso(List<AcaoDTO> listaAcoes, List<OrigemDTO> listaOrigens, DwPassagem passagem, PassagemDTO retorno) {
	}

	@Override
	protected void postoTesteFuncional(idw.util.IdwLogger log, PassagemDTO passagem, DwPassagem oDwPassagem,
			DwNserie oDwNserie, PassagemDTO retorno) throws SemSGBDException {
	}

}
