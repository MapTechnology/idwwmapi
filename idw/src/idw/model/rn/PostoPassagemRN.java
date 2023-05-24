package idw.model.rn;

import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPassagem;
import idw.util.IdwLogger;
import idw.webservices.dto.AcaoDTO;
import idw.webservices.dto.DefeitoDTO;
import idw.webservices.dto.MontagemDTO;
import idw.webservices.dto.OrigemDTO;
import idw.webservices.dto.PassagemDTO;


public class PostoPassagemRN extends PostoPassagemRNAbs {

	public PostoPassagemRN() {
		super(new DAOGenerico());
	}
	public PostoPassagemRN(DAOGenerico dao) {
		super(dao);
	}

	@Override
	protected void postoMontagem(List<MontagemDTO> listaMontagem,
			DwPassagem oDwPassagem, DwNserie oDwNserie, PassagemDTO retorno) {
		// faz nada pois eh o posto de passagem
	}

	@Override
	protected void postoTesteVisual(List<DefeitoDTO> listaDefeitos,
			DwPassagem passagem) {
		// faz nada pois eh o posto de passagem
	}

	@Override
	protected void postoReprocesso(List<AcaoDTO> listaAcoes, List<OrigemDTO> listaOrigens, DwPassagem passagem, PassagemDTO retorno) {
	}

	@Override
	protected void postoTesteFuncional(IdwLogger lo, PassagemDTO passagem,
			DwPassagem oDwPassagem, DwNserie oDwNserie, PassagemDTO retorno) {
	}
	
}
