package idw.model.pojos.template;

import java.math.BigDecimal;

import idw.model.pojos.MsMsicup;
import ms.model.APojoMs;

public class MsMsicupTemplate extends APojoMs<MsMsicup>{

	public static final BigDecimal _TP_CONEXAO_TUDO = BigDecimal.ZERO;
	
	@Override
	protected MsMsicup atribuir(MsMsicup from, MsMsicup to, boolean isCopiarFK) {
		if (to == null)
			to = new MsMsicup();
		
		to.setIdMsicup(from.getIdMsicup());
		to.setTpConexao(from.getTpConexao());
		to.setUrlConexao(from.getUrlConexao());
		to.setUrlAuxiliar(from.getUrlAuxiliar());
		to.setIsAtivo(from.getIsAtivo());

		if (isCopiarFK){
			to.setMsIc(from.getMsIc().clone());
			to.setMsMs(from.getMsMs().clone());
			to.setMsUp(from.getMsUp().clone());
		}
		return to;
	}

}
