package idw.model.rn.cp;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.PpCp;
import idw.model.rn.CpRN;
import ms.model.dto.EventoColetado;

/* Essa classe retorna a OP quando o tipo de sessao for po MOLDE
 * 
 */
public class CriarOP_tpFolha implements IObtemOP{

	@Override
	public PpCp obtem(EventoColetado evento, DAOGenerico dao) {
		// Procura a PPCP mais antiga q ainda nao tenha entrado em máquina
		CpRN rn = new CpRN(dao);
		
		/* A op criada pela folha eh feita no inovaSA que nesse ponto ja criou a Cp via webservice. ENtao devemos apenas resgatar
		 * esse cp para poder incluir o evento de entrada de op
		 */
		PpCp ppcp = rn.pesquisarPpCpByNrDocCdPt(evento.getCdop(), evento.getIcUpDTO().getUpDTO().getCd_up());
		
		return ppcp;
	}

	
}
