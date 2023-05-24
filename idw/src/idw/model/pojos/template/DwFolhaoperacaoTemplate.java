package idw.model.pojos.template;

import org.hibernate.SessionException;

import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhaoperacao;
import idw.model.pojos.DwOperacao;
import idw.model.pojos.IpBalanceamento;

public class DwFolhaoperacaoTemplate extends AbstractTemplate<DwFolhaoperacao> {

	@Override
	protected DwFolhaoperacao atribuir(DwFolhaoperacao from, DwFolhaoperacao to, boolean isCopiarFK) {
		if(to == null) {
			to = new DwFolhaoperacao();
		}
		
		to.setIdFolhaoperacao(from.getIdFolhaoperacao());
		to.setOrdem(from.getOrdem());

		if (isCopiarFK == true){
			if (from.getDwFolha() != null) {
				try {
					if (from.getDwFolha() != null)
						to.setDwFolha((DwFolha)from.getDwFolha().clone(false));
				}catch(SessionException e) {
					to.setDwFolha(null);
				}
				try {
					if (from.getDwOperacao() != null)
						to.setDwOperacao((DwOperacao)from.getDwOperacao().clone(false));
				}catch(SessionException e) {
					to.setDwOperacao(null);
				}
				try {
					if (from.getIpBalanceamento() != null)
						to.setIpBalanceamento((IpBalanceamento)from.getIpBalanceamento().clone(false));
				}catch(SessionException e) {
					to.setIpBalanceamento(null);
				}
			}
		}
		
		return to;
	}

}
