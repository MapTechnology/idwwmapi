package idw.model.pojos.template;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import idw.model.IPojoMAP;
import idw.model.pojos.OmCargo;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.OmUsrgrp;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;


public abstract class OmUsrTemplate extends AbstractTemplate<OmUsr> implements IPojoMAP{

	public static final String _CD_USR_MAP = "0";
	public static final String _FIELD_NAME_CD = "CdUsr";
	public static final int _MAX_LEN_CD_USR = 30;
	public static final int _MAX_LEN_DS_APELIDO = 10;
	public static final int _MAX_LEN_DS_NOME = 100;
	public static final int _MAX_LEN_LOGIN = 30;
	public static final int _MAX_LEN_SENHA = 100;
	public static final int _MAX_LEN_URL_EMAIL = 255;
	public static final int _MAX_LEN_URL_SMS = 255;

	@Override
	public Long getId() {		
		return getInstanceT().getIdUsr();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdUsr(id == null ? 0L: id.longValue());
	}	
	
	@Override
	public String getCd() {
		return ((OmUsr) this).getCdUsr();
	}

	@Override
	public String getFieldNameCd() {
		return OmUsrTemplate._FIELD_NAME_CD;
	}

	/**
	 * Campos usados no equals:
	 * CdUsr, Login, Senha, DsNome, DsApelido, UrlSms, UrlEmail, OmCc, OmUsrgrp, StAtivo

	 */
	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final OmUsr omUsrOther = (OmUsr) o;
			final OmUsr omUsr = (OmUsr) this;
			equals = (new EqualsBuilderIdw())
						.append(omUsr.getCdUsr(), omUsrOther.getCdUsr())
						.append(omUsr.getLogin(), omUsrOther.getLogin())
						.append(omUsr.getSenha(), omUsrOther.getSenha())
						.append(omUsr.getDsNome(), omUsrOther.getDsNome())
						.append(omUsr.getDsApelido(), omUsrOther.getDsApelido())
						.append(omUsr.getUrlSms(), omUsrOther.getUrlSms())
						.append(omUsr.getUrlEmail(), omUsrOther.getUrlEmail())
						.append(omUsr.getOmCc(), omUsrOther.getOmCc())
						.append(omUsr.getOmUsrgrp(), omUsrOther.getOmUsrgrp())
						.append(omUsr.getStAtivo(), omUsrOther.getStAtivo())
						.isEquals();
		}
		return equals;
	}

	/**
	 * Campos usados no hashCode:
	 *   CdUsr, Login, Senha, DsNome, DsApelido, UrlSms, UrlEmail, OmCc, OmUsrgrp, StAtivo
	 */
	@Override
	public int hashCode(){

		OmUsr omUsr = (OmUsr) this;

		return (new HashCodeBuilderIdw())
						.append(omUsr.getCdUsr())
						.append(omUsr.getLogin())
						.append(omUsr.getSenha())
						.append(omUsr.getDsNome())
						.append(omUsr.getDsApelido())
						.append(omUsr.getUrlSms())
						.append(omUsr.getUrlEmail())
						.append(omUsr.getOmCc())
						.append(omUsr.getOmUsrgrp())
						.append(omUsr.getStAtivo())
				.toHashCode();
	}

	public void set(long idUsr, OmUsr omUsrByIdUsrstativo, OmUsrgrp omUsrgrp,
			OmUsr omUsrByIdUsrrevisao, OmCargo omCargo, OmCc omCc, OmGt omGt, String cdUsr, Long revisao,
			Date dtRevisao, Date dtStativo, Byte stAtivo, String login,
			String senha, String dsNome, String dsApelido, String urlSms, String urlEmail, OmGt omgt){

		OmUsr omUsr = (OmUsr) this;

		omUsr.setIdUsr(idUsr);
		omUsr.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		omUsr.setOmUsrgrp(omUsrgrp);
		omUsr.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		omUsr.setOmCargo(omCargo);
		omUsr.setOmCc(omCc);
		omUsr.setOmGt(omgt);
		omUsr.setCdUsr(cdUsr);
		omUsr.setRevisao(revisao);
		omUsr.setDtRevisao(dtRevisao);
		omUsr.setDtStativo(dtStativo);
		omUsr.setStAtivo(stAtivo);
		omUsr.setLogin(login);
		omUsr.setSenha(senha);
		omUsr.setDsNome(dsNome);
		omUsr.setDsApelido(dsApelido);
		omUsr.setUrlSms(urlSms);
		omUsr.setUrlEmail(urlEmail);
		omUsr.setOmGt(omgt);
	}

	@Override
	protected OmUsr atribuir(OmUsr from, OmUsr to, boolean isCopiarFK) {

		if (to == null) {
			to = new OmUsr();
		}

		to.set(
			from.getIdUsr(),
			(isCopiarFK ? CloneUtil.clone(from.getOmUsrByIdUsrstativo(), false): null),
			(isCopiarFK ? CloneUtil.clone(from.getOmUsrgrp(), false): null),
			(isCopiarFK ? CloneUtil.clone(from.getOmUsrByIdUsrrevisao(), false): null),
			(isCopiarFK ? CloneUtil.clone(from.getOmCargo(), false): null),
			(isCopiarFK ? CloneUtil.clone(from.getOmCc(), false): null),
			(isCopiarFK ? CloneUtil.clone(from.getOmGt(), false): null),
			from.getCdUsr(),
			from.getRevisao(),
			from.getDtRevisao(),
			from.getDtStativo(),
			from.getStAtivo(),
			from.getLogin(),
			from.getSenha(),
			from.getDsNome(),
			from.getDsApelido(),
			from.getUrlSms(),
			from.getUrlEmail(),
			(isCopiarFK ? CloneUtil.clone(from.getOmGt(), false): null));

		return to;
	}

	public void limitarStrings(){
		OmUsr omUsr = (OmUsr) this;
		omUsr.setCdUsr(StringUtils.left(omUsr.getCdUsr(), OmUsrTemplate._MAX_LEN_CD_USR));
		omUsr.setDsApelido(StringUtils.left(omUsr.getDsApelido(), OmUsrTemplate._MAX_LEN_DS_APELIDO));
		omUsr.setDsNome(StringUtils.left(omUsr.getDsNome(), OmUsrTemplate._MAX_LEN_DS_NOME));
		omUsr.setLogin(StringUtils.left(omUsr.getLogin(), OmUsrTemplate._MAX_LEN_LOGIN));
		omUsr.setSenha(StringUtils.left(omUsr.getSenha(), OmUsrTemplate._MAX_LEN_SENHA));
		omUsr.setUrlEmail(StringUtils.left(omUsr.getUrlEmail(), OmUsrTemplate._MAX_LEN_URL_EMAIL));
		omUsr.setUrlSms(StringUtils.left(omUsr.getUrlSms(),OmUsrTemplate._MAX_LEN_URL_SMS));
	}
}
