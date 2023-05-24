package idw.model.pojos.template;

import idw.model.pojos.OmEmpresa;

public abstract class OmEmpresaTemplate extends AbstractTemplate<OmEmpresa>{

	public static final String _FIELD_NAME_CD = "CdEmpresa";

	@Override
	protected OmEmpresa atribuir(OmEmpresa from, OmEmpresa to, boolean isCopiarFK) {
		if (to == null) {
			to = new OmEmpresa();
		}

		to.setIdEmpresa(from.getIdEmpresa());
		to.setCdEmpresa(from.getCdEmpresa());
		to.setCidade(from.getCidade());
		to.setDsEmpresa(from.getDsEmpresa());
		to.setEndereco(from.getEndereco());
		to.setEstado(from.getEstado());
		to.setPais(from.getPais());
		to.setChaveVerificacao(from.getChaveVerificacao());
		to.setImgBackground(from.getImgBackground());
		to.setImgLogotipo(from.getImgLogotipo());
		to.setImgRodape(from.getImgRodape());
		
		if (isCopiarFK == true) {
		}else if (isCopiarFK == false){
		}

		return to;
	}
}
