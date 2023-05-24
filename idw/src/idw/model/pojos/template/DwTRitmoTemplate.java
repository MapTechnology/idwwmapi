package idw.model.pojos.template;

import java.util.Date;

import idw.model.IPojoMAPAkOmTppt;
import idw.model.pojos.DwTRitmo;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;

/**
 * isFDS - Indica que a parada sem peso est√° ocorrendo porque final de semana.
 * isMDO - Indica que a parada e do tipo m„o-de-obra
 * isMTBF - MTBF ("Mean Time Between Failures") ou per√≠odo m√©dio entre falhas
 * isMTTR -
 * isPA - parada de avaria
 * isPAO - parada de anomalia organizacional
 * isPP - parada de preparaÁ„oo
 * isPREV - parada prevista
 * isPTP - Parada de troca de produÁ„oo
 * isSCP - Indica que a parada sem peso est√° ocorrendo porque n„o h√° pedido em carteira que justifique a produÁ„oo.
 *
 * @author map
 *
 */
public abstract class DwTRitmoTemplate extends AbstractTemplate<DwTRitmo> implements IPojoMAPAkOmTppt {

	public static final String _FIELD_NAME_CD = "CdTritmo";

	@Override
	public Long getId() {		
		return getInstanceT().getIdTritmo();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdTritmo(id);
	}

	@Override
	public String getCd() {
		return ((DwTRitmo)this).getCdTritmo();
	}

	@Override
	public String getFieldNameCd() {
		return DwTRitmoTemplate._FIELD_NAME_CD;
	}


	@Override
	protected DwTRitmo atribuir(DwTRitmo itemGet, DwTRitmo itemSet, boolean isCopiarFK) {

		if (itemSet == null) {
			itemSet = new DwTRitmo();
		}
		
		itemSet.set(
				itemGet.getIdTritmo(),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmTppt(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrstativo(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrrevisao(),false) : null),
				itemGet.getCdTritmo(),
				itemGet.getRevisao(),
				itemGet.getDsTritmo(),
				itemGet.getDtRevisao(),
				itemGet.getStAtivo(),
				itemGet.getDtStativo());


		return itemSet;

	}
	
	public void set(long idTritmo, OmTppt omTppt, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdTritmo, Long revisao,
			String dsTritmo, Date dtRevisao, Byte stAtivo, Date dtStativo) {

		DwTRitmo dwTRitmo = (DwTRitmo) this;

		dwTRitmo.setIdTritmo(idTritmo);
		dwTRitmo.setOmTppt(omTppt);
		dwTRitmo.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		dwTRitmo.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		dwTRitmo.setCdTritmo(cdTritmo);
		dwTRitmo.setRevisao(revisao);
		dwTRitmo.setDsTritmo(dsTritmo);
		dwTRitmo.setDtRevisao(dtRevisao);
		dwTRitmo.setStAtivo(stAtivo);
		dwTRitmo.setDtStativo(dtStativo);

	}

	
}
