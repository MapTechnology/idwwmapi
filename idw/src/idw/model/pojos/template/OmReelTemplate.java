package idw.model.pojos.template;

import java.math.BigDecimal;

import idw.model.pojos.OmAlimrea;
import idw.model.pojos.OmReel;

public abstract class OmReelTemplate extends AbstractTemplate<OmReel> {
	public abstract BigDecimal getQtAlimentada();
	public abstract void setQtAlimentada(BigDecimal qtAlimentada);
	public abstract BigDecimal getQtUsada();
	public abstract void setQtUsada(BigDecimal qtUsada);
	public abstract BigDecimal getQtPerdida();
	public abstract void setQtPerdida(BigDecimal qtPerdida);

		
	@Override
	protected OmReel atribuir(OmReel from, OmReel to, boolean isCopiarFK) {
		if (to == null) {
			to = new OmReel();
		}
		
		to.setIdReel(from.getIdReel());
		to.setCdReelid(from.getCdReelid());
		to.setDthrCadastro(from.getDthrCadastro());
		to.setQtAlimentada(from.getQtAlimentada());
		to.setQtUsada(from.getQtUsada());
		to.setQtPerdida(from.getQtPerdida());
		
		if (isCopiarFK) {
			if (from.getOmAlimrea() != null)
				to.setOmAlimrea( (OmAlimrea) from.getOmAlimrea().clone());
		}
		return to;
	}
	
	public BigDecimal obtemQtAtual() {
		BigDecimal retorno = getQtAlimentada();
		
		if (getQtUsada() != null)
			retorno = retorno.subtract(getQtUsada());
		if (getQtPerdida() != null)
			retorno = retorno.subtract(getQtPerdida());
		
		return retorno;
	}
}
