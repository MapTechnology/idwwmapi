package idw.model.pojos.template;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionException;

import idw.model.IPojoMAP;
import idw.model.pojos.DwDetativ;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwGrpativ;
import idw.model.pojos.DwProcarhom;
import idw.model.pojos.DwProcativ;
import idw.model.pojos.DwProcedimento;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;

public abstract class DwProcedimentoTemplate extends AbstractTemplate<DwProcedimento> implements IPojoMAP{
	
	public static final String _FIELD_NAME_CD = "CdProcedimento";
	
	@Override
	public Long getId() {
		return getInstanceT().getIdProcedimento();
	}

	@Override
	public void setId(Long id) {
		getInstanceT().setIdProcedimento(id);
	}
	
	@Override
	public String getCd() {
		return ((DwProcedimento) this).getCdProcedimento();
	}

	@Override
	public String getFieldNameCd() {
		return DwProcedimentoTemplate._FIELD_NAME_CD;
	}
	
	public void set(Long idProcedimento, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdProcedimento, Long revisao,
			String dsProcedimento, Date dtRevisao, Byte stAtivo, Date dtStativo, String obs) {

		DwProcedimento dwProcedimento = (DwProcedimento) this;

		dwProcedimento.setIdProcedimento(idProcedimento);
		dwProcedimento.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		dwProcedimento.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		dwProcedimento.setCdProcedimento(cdProcedimento);
		dwProcedimento.setRevisao(revisao);
		dwProcedimento.setDsProcedimento(dsProcedimento);
		dwProcedimento.setDtRevisao(dtRevisao);
		dwProcedimento.setStAtivo(stAtivo);
		dwProcedimento.setDtStativo(dtStativo);
		dwProcedimento.setObs(obs);

	}
	
	@Override
	protected DwProcedimento atribuir(DwProcedimento itemGet, DwProcedimento itemSet, boolean isCopiarFK) {
		if (itemSet == null) {
			itemSet = new DwProcedimento();
		}

		itemSet.set(
				itemGet.getIdProcedimento(),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrstativo(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrrevisao(),false) : null),
				itemGet.getCdProcedimento(),
				itemGet.getRevisao(),
				itemGet.getDsProcedimento(),
				itemGet.getDtRevisao(),
				itemGet.getStAtivo(),
				itemGet.getDtStativo(),
				itemGet.getObs());
		if(isCopiarFK){
			if ((itemGet.getDwProcarhoms() != null)	&& (!itemGet.getDwProcarhoms().isEmpty())) {
				try {
					itemSet.setDwProcarhoms(new HashSet<DwProcarhom>());
					for (DwProcarhom dwProcarhom : itemGet.getDwProcarhoms()) {
						itemSet.getDwProcarhoms().add(dwProcarhom.clone(false));
					}
				} catch (SessionException e) {
					itemSet.setDwProcarhoms(null);
				}
			}
			if ((itemGet.getDwProcativs() != null) && (!itemGet.getDwProcativs().isEmpty())) {
				try {
					itemSet.setDwProcativs(new HashSet<DwProcativ>());
					for (DwProcativ dwProcativ : itemGet.getDwProcativs()) {
						DwProcativ item= new DwProcativ();
						item = dwProcativ.clone(false);
						DwGrpativ dwGrpativ = new DwGrpativ();
						dwGrpativ = dwProcativ.getDwGrpativ().clone();
						item.setDwGrpativ(dwGrpativ);
						Set<DwDetativ> detativs = new HashSet<>(0);
						for(DwDetativ detativ : dwProcativ.getDwDetativs()) {
							DwDetativ dwDetativ = detativ.clone(false);
							detativs.add(dwDetativ);
						}
						item.setDwDetativs(detativs);
						itemSet.getDwProcativs().add(item);
						
					}
				} catch (SessionException e) {
					itemSet.setDwProcativs(null);
				}
			}
			/* Alessandre em 15-02-16 nao faz sentido trazer os procedimentos realizados durante a clonagem do procedimento
			if ((itemGet.getDwProreas() != null) && (!itemGet.getDwProreas().isEmpty())) {
				try {
					itemSet.setDwProreas(new HashSet<DwProrea>());
					for (DwProrea dwProrea : itemGet.getDwProreas()) {
						DwProrea item= new DwProrea();
						item = dwProrea.clone(false);
						item.setDwConsolid(dwProrea.getDwConsolid().clone(false));
						Set<DwProreaativ> dwProreaativs = new HashSet<DwProreaativ>(0);
						
						for(DwProreaativ proreaativ: dwProrea.getDwProreaativs()){
							DwProreaativ proreaativRet = proreaativ.clone(true);
							dwProreaativs.add(proreaativRet);
						}
						item.setDwProreaativs(dwProreaativs);
						itemSet.getDwProreas().add(item);
					}
				} catch (SessionException e) {
					itemSet.setDwProreas(null);
				}
			}*/
			if ((itemGet.getDwFolhas() != null) && (!itemGet.getDwFolhas().isEmpty())) {
				try {
					itemSet.setDwFolhas(new HashSet<DwFolha>());
					for (DwFolha folha : itemGet.getDwFolhas()) {
						DwFolha item = new DwFolha();
						item = folha.clone(false);
						itemSet.getDwFolhas().add(item);
					}
				} catch (SessionException e) {
					itemSet.setDwFolhas(null);
				}
			}
		}
		return itemSet;
		
	}

}