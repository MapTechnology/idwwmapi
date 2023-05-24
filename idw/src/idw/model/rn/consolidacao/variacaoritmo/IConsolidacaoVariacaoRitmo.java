package idw.model.rn.consolidacao.variacaoritmo;

import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwTParada;

public interface IConsolidacaoVariacaoRitmo {
	public void consolidar(DwConsolid dwConsolid, long duracao, DwTParada dwTParada, boolean isAbater);
}
