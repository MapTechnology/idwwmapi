package idw.model.rn.cp;

import java.math.BigDecimal;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.PpCp;
import idw.model.rn.CpRN;
import idw.model.rn.FolhaRN;
import idw.util.AritmeticaUtil;
import ms.model.dto.EventoColetado;
import ms.model.dto.OPAutomaticaDTO;
import ms.util.ConversaoTipos;

/* Essa classe retorna a OP quando o tipo de sessao for po MOLDE
 * 
 */
public class CriarOP_tpFerramentaQtdeCiclos implements IObtemOP{

	@Override
	public PpCp obtem(EventoColetado evento, DAOGenerico dao) {
		// Procura a PPCP mais antiga q ainda nao tenha entrado em m�quina
		CpRN rn = new CpRN(dao);
		
		// Identificar qual a folha sera Usada
		FolhaRN frn = new FolhaRN(dao);
		
		evento.setUp(evento.getIcUpDTO().getUpDTO().getCd_up());
		
		DwFolha dwfolha = frn.pesquisaFolhaByRapEstrutura(evento.getCdmolde(), evento.getCdestrutura());
		
		if (dwfolha == null) {
			return null;
		}
		evento.setCdFolha(dwfolha.getCdFolha());
		
		/* A partir da qtde de ciclos encontrar a producao planejada
		 * 
		 */
		BigDecimal qtCavAtivas = null;
		// 1 interage sobre cada produto e obtem o que tiver maior cavidade. Esse tera a qtde de cavidades ativas pela qtde ciclos
		for (DwFolharap rap : dwfolha.getDwFolharaps()) {
			for (DwFolharapcom com : rap.getDwFolharapcoms()) {
				if (qtCavAtivas == null || qtCavAtivas.compareTo(com.getQtAtiva()) < 0)
					qtCavAtivas = com.getQtAtiva();
			}
		}
		if (qtCavAtivas == null) {
			for (DwFolhaiac iac : dwfolha.getDwFolhaiacs()) {
				qtCavAtivas = iac.getQtAtiva();
			}
		}
		if (qtCavAtivas == null)
			qtCavAtivas = BigDecimal.ONE;
		
		BigDecimal qtCiclos = ConversaoTipos.converterParaBigDecimal(evento.getQtde());
		
		
		evento.setQtde(ConversaoTipos.converteParaString(AritmeticaUtil.multiplicar(qtCavAtivas, qtCiclos), 0));
		
		

		OPAutomaticaDTO dto = rn.criarOPAutomatica(evento);
		
		PpCp ppcp = rn.pesquisarPpCpByNrDocCdPt(dto.getNrDoc(), evento.getIcUpDTO().getUpDTO().getCd_up());
		
		return ppcp;
	}

	
}
