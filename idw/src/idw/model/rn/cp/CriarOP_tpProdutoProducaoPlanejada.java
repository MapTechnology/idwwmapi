package idw.model.rn.cp;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwFolha;
import idw.model.pojos.PpCp;
import idw.model.rn.CpRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.PTRN;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.model.dto.OPAutomaticaDTO;
import ms.model.dto.UpDTO;

/* Essa classe retorna a OP quando o tipo de sessao for po MOLDE
 * 
 */
public class CriarOP_tpProdutoProducaoPlanejada implements IObtemOP{

	@Override
	public PpCp obtem(EventoColetado evento, DAOGenerico dao) {
		// Procura a PPCP mais antiga q ainda nao tenha entrado em m�quina
		CpRN rn = new CpRN(dao);
		
		// Identificar qual a folha sera Usada
		FolhaRN frn = new FolhaRN(dao);
		
		evento.setUp(evento.getIcUpDTO().getUpDTO().getCd_up());
		
		DwFolha dwfolha = frn.pesquisarDwFolhaByCdProduto(evento.getCdproduto(), evento.getIcUpDTO().getUpDTO().getCd_up());
		
		// Se nao existir folha entao nao se deve criar a op
		if (dwfolha == null) {
			return null; // nao eh possivel criar uma op
		}
		evento.setCdFolha(dwfolha.getCdFolha());
		
		
		OPAutomaticaDTO dto = rn.criarOPAutomatica(evento);
		
		PpCp ppcp = null;
		
		if (dto != null)
			ppcp = rn.pesquisarPpCpByNrDocCdPt(dto.getNrDoc(), evento.getIcUpDTO().getUpDTO().getCd_up());
		
		return ppcp;
	}

	public static void main(String[] args) {
		CriarOP_tpProdutoProducaoPlanejada rn = new CriarOP_tpProdutoProducaoPlanejada();
		PTRN prn = new PTRN();
		prn.iniciaConexaoBanco();
		
		EventoColetado evento = new EventoColetado();
		evento.setCdproduto("1");
		evento.setDthrEvento(DataHoraRN.getDataHoraAtual());
		IcUpDTO icupdto = new IcUpDTO();
		UpDTO updto = new UpDTO();
		updto.setCd_up("000004");
		icupdto.setUpDTO(updto);
		evento.setIcUpDTO(icupdto);
		PpCp ppcp = rn.obtem(evento, prn.getDao());
		System.out.println("ppcp id = " + ppcp.getIdCp() + " cd=" + ppcp.getCdCp());
		prn.finalizaConexaoBanco();
	}
}
