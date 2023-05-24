package idw.model.pojos.template;

import idw.model.pojos.OmResgui;
import idw.util.CloneUtil;


public abstract class OmResguiTemplate extends AbstractTemplate<OmResgui> {

	public enum _TIPO_RECURSO{
		CLP_LOGINOPERADOR(58l),
		CLP_LOGINTECNICO(59l),
		CLP_AUTUORIZACANCELAMENTOETIQUETA(63l),
		CLP_LOGINTECNICOCIP(60l),
		CLP_LOGINTECNICOTROCAOP(64l)
		;

		private final long value;
		private _TIPO_RECURSO(long value){
			this.value = value;
		}
		public long getValue(){
			return this.value;
		}

	}

	@Override
	protected OmResgui atribuir(OmResgui from, OmResgui to, boolean isCopiarFK) {

		if(to == null){
			to = new OmResgui();
		}

		to.setCdResgui(CloneUtil.clone(from.getCdResgui()));
		to.setDsResgui(CloneUtil.clone(from.getDsResgui()));
		to.setDtRevisao(CloneUtil.clone(from.getDtRevisao()));
		to.setDtStativo(CloneUtil.clone(from.getDtStativo()));
		to.setIdResgui(CloneUtil.clone(from.getIdResgui()));
		to.setRevisao(CloneUtil.clone(from.getRevisao()));
		to.setStAtivo(CloneUtil.clone(from.getStAtivo()));
		if(isCopiarFK){
			to.setOmResgui(CloneUtil.clone(from.getOmResgui(), false));
		}

		return to;
	}

}
