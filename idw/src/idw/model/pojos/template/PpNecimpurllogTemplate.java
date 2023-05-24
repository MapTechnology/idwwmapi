package idw.model.pojos.template;

import idw.model.pojos.PpNecimpurllog;

public class PpNecimpurllogTemplate extends AbstractTemplate<PpNecimpurllog> {

	@Override
	protected PpNecimpurllog atribuir(PpNecimpurllog from, PpNecimpurllog to,
			boolean isCopiarFK) {
		if(to == null) {
			to = new PpNecimpurllog();
		}
		to.setDsErro(from.getDsErro());
		
		to.setIdNecimpurllog(from.getIdNecimpurllog());
		to.setDthrIimportacao(from.getDthrIimportacao());
		to.setDthrFimportacao(from.getDthrFimportacao());
		to.setStImp(from.getStImp());
		to.setUrlArquivo(from.getUrlArquivo());
		to.setAba(from.getAba());
		to.setPpNecimplog(null);
		to.setPpNecs(null);
		to.setPpNecimpurl(null);
		
		if(isCopiarFK) {
			to.setPpNecimpurl(from.getPpNecimpurl().clone(false));
		}
		
		return to;
	}

}
