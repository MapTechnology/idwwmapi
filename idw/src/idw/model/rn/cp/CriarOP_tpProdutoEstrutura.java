package idw.model.rn.cp;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwFolha;
import idw.model.pojos.PpCp;
import idw.model.rn.CpRN;
import idw.model.rn.FolhaRN;
import ms.model.dto.EventoColetado;
import ms.model.dto.OPAutomaticaDTO;

/* Essa classe retorna a OP quando o tipo de sessao for por PRODUTO e estrutura
 * 
 */
public class CriarOP_tpProdutoEstrutura implements IObtemOP{

	@Override
	public PpCp obtem(EventoColetado evento, DAOGenerico dao) {
		// Procura a PPCP mais antiga q ainda nao tenha entrado em m�quina
		CpRN rn = new CpRN(dao);
		
		// Identificar qual a folha sera Usada
		FolhaRN frn = new FolhaRN(dao);
		
		evento.setUp(evento.getIcUpDTO().getUpDTO().getCd_up());
		
		DwFolha dwfolha = frn.pesquisarDwFolhaByCdProdutoEEstrutura(evento.getCdproduto(), evento.getIcUpDTO().getUpDTO().getCd_up(), evento.getCdestrutura());
		
		if (dwfolha == null) {
			return null;
		}
		evento.setCdFolha(dwfolha.getCdFolha());
		
		// Multiplicar pela producao por ciclo da folha
		long qtdPcsPorCiclo = 1l;
		try {
			qtdPcsPorCiclo = frn.getPcsPorCicloAtivasFromDwFolha(dwfolha).longValue();
		} catch (Exception e) {
			e.printStackTrace();
			qtdPcsPorCiclo = 1l;
		}

		Long qtde0 = Long.parseLong(evento.getQtde());
		Long qtde = qtde0 * qtdPcsPorCiclo;
		evento.setQtde(qtde.toString());
		

		OPAutomaticaDTO dto = rn.criarOPAutomatica(evento);
		
		PpCp ppcp = rn.pesquisarPpCpByNrDocCdPt(dto.getNrDoc(), evento.getIcUpDTO().getUpDTO().getCd_up());
		
		return ppcp;
	}

	
}
