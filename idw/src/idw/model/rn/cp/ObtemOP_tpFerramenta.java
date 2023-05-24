package idw.model.rn.cp;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.PpCp;
import idw.model.rn.CpRN;
import ms.model.dto.EventoColetado;

/* Essa classe retorna a OP quando o tipo de sessao for po MOLDE
 * 
 */
public class ObtemOP_tpFerramenta implements IObtemOP{

	@Override
	public PpCp obtem(EventoColetado evento, DAOGenerico dao) {
		// Procura a PPCP mais antiga q ainda nao tenha entrado em m�quina
		CpRN rn = new CpRN(dao);
		String cdMolde = evento.getCdmolde();
		PpCp ppcp = rn.pesquisarPpCpSemProducaoParaFerramenta(evento.getIcUpDTO().getUpDTO().getCd_up(), cdMolde);

		return ppcp;
	}

	
}
