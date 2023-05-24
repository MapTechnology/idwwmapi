package idw.model.rn.consolidacao.producao;

import java.math.BigDecimal;
import java.util.Date;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.ReprocessarMsEvtException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwFolha;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.rn.AbstractRN;
import idw.model.rn.alimentacao.ConsumoAlimentacaoRN;
import idw.model.rn.estoque.EstoqueRN;
import idw.util.IdwLogger;

public class ConsolidacaoFimCicloNoEstoque extends AbstractRN<DAOGenerico>{

	public ConsolidacaoFimCicloNoEstoque(DAOGenerico dao) {
		super(dao);
	}

	public void consolidarCicloNoEstoque(IdwLogger log, int idLog, int identacao, boolean isProdutivo, 
			OmCfg omcfg, OmPt omPt, PpCp ppCp, DwFolha dwFolha, Date dtHrFimCiclo, BigDecimal producaoPorCiclo, MsEvt msevt) 
					throws ReprocessarMsEvtException, SemCalendarioException {
		
		// gera estoque da producao apenas se estiver setado o flag para controlar nivel da alimentacao
		if(isProdutivo && omcfg.getIsNivelfeeder() != null && omcfg.getIsNivelfeeder() == true){
			
			EstoqueRN estoqueRN = new EstoqueRN(getDao());				
			try{
				/* Lancando no estoque a producao realizada
				 * 
				 */
				estoqueRN.addEstoqueProducaoNoCiclo(omcfg, omPt, ppCp, dwFolha, dtHrFimCiclo);
				/* Consumindo do estoque precedente a producao realizada, considerando o roteiro de producao
				 * A estrutura do produto nao eh considerada ainda, talvez seja no projeto do paraguai
				 */
				estoqueRN.subEstoqueProducaoNoCiclo(omcfg, omPt, ppCp, dwFolha, dtHrFimCiclo);
			}catch (Exception e){
				log.info(idLog, identacao, "Excessao subEstoqueProducaoNoCiclo", e);
				throw new ReprocessarMsEvtException();				
			}

			ConsumoAlimentacaoRN consumoAlimentacao = new ConsumoAlimentacaoRN(getDao());
			consumoAlimentacao.consumirPorCiclo(omPt, dtHrFimCiclo, producaoPorCiclo);
			
			// Atualiza o estoque de OmReel e de OmAlimrea
			// A regra para diferencia o consumo de MP por passagem e por final de ciclo é o CB estar null no evento de fim de ciclo
			// qdo for null é pq nao existe evento de passagem
			// o = 1 abaixo eh pqr causa da semp que esta mandando 1 no cb e nao deveria. nao vou investigado o motivo
			// Alessandre em 28-11-19 comentei o trecho abaixo pois estou tendo problemas no consumo de MP. Ela esta ocorrendo na passagem e aqui
			// consumindo assim mais do que o necessario. O metodo private foi removido da classe. No futuro caso seja necessario aproveitar o metodo da ConsolidacaoPassagem
			/*
			if (msevt.getCb() == null || (msevt.getCb() != null && msevt.getCb().trim().equals("1"))) {
				consumirMPemOmAlimreaReel(omPt, msevt, dwFolha, log, idLog, identacao);
			}*/
		}
	}
}
