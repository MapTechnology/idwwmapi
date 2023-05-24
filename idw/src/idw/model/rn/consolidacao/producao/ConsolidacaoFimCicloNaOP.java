package idw.model.rn.consolidacao.producao;

import java.util.Date;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmPtcp;
import idw.model.pojos.PpCp;
import idw.model.rn.AbstractRN;
import idw.model.rn.consolidacao.planejamento.ConsolidacaoPlanejamento;

public class ConsolidacaoFimCicloNaOP extends AbstractRN<DAOGenerico>{

	public ConsolidacaoFimCicloNaOP(DAOGenerico dao) {
		super(dao);
	}

	public void consolidarCicloNaOP(OmPt omPt, PpCp ppCp, Date dthrInicioCiclo) {
		// Atualizar a quantidade de ciclos feitos na OP para o PT
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from OmPtcp a");
		q.append("where a.omPt = :ompt");
		q.append("and a.ppCp = :ppcp");
		
		q.defineParametro("ompt", omPt);
		q.defineParametro("ppcp", ppCp);
		
		OmPtcp omptcp = (OmPtcp) q.uniqueResult();
		if (omptcp == null) {
			omptcp = new OmPtcp();
			omptcp.setOmPt(omPt);
			omptcp.setPpCp(ppCp);
			omptcp.setQtCiclos(0);
			omptcp.setQtCiclosregulagem(0);
		}
		
		if (omptcp.getQtCiclos() == null)
			omptcp.setQtCiclos(0);
		
		/* Alessandre em 19-07-17 comentei a linha abaixop ara nao mais alterar a quantidade de ciclos quando forem consolidados
		 * esse atributo sera alterado pelo servico de ciclo. O objetivo eh representar a qtde de ciclos que vieram do coletor
		 * ao inves dos ciclos consolidados com sucesso. Isso é necessário para evitar o coletor contar um ciclo
		 * depois o heartbeat decrescer esse ciclo para na sequencia acrescentar novamente. Causando uma falsa impressao
		 * que o ciclo nao foi contabilizado, principalemnte na leitura de um CB
		 */
		//omptcp.setQtCiclos(omptcp.getQtCiclos() + 1);
		getDao().makePersistent(omptcp);
		
		ConsolidacaoPlanejamento consolidacaoPlanejamento = new ConsolidacaoPlanejamento(getDao());
		consolidacaoPlanejamento.setInicioPpCpentsai(ppCp, omPt, dthrInicioCiclo);
		
	}
}
