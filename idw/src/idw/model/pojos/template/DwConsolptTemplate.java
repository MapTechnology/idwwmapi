package idw.model.pojos.template;

import java.util.Date;

import idw.model.pojos.DwCal;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpt;
import idw.model.rn.DataHoraRN;


public abstract class DwConsolptTemplate extends AbstractTemplate<DwConsolpt>{

	@Override
	protected DwConsolpt atribuir(DwConsolpt itemGet, DwConsolpt itemSet, boolean isCopiarFK) {
		
		if (itemSet == null)
			itemSet = new DwConsolpt();
		
		
		itemSet.setIdConsolpt(itemGet.getIdConsolpt());
		
		itemSet.setDthrInicio(itemGet.getDthrInicio());
		itemSet.setDthrFim(itemGet.getDthrFim());
		
		if(isCopiarFK){
			
			if(itemGet.getDwConsolidByIdConsolidMes() !=null){
				itemSet.setDwConsolidByIdConsolidMes(itemGet.getDwConsolidByIdConsolidMes().clone(false));	
			}
			if(itemGet.getDwCal() != null){
				itemSet.setDwCal((DwCal)itemGet.getDwCal().clone());
			}
			if(itemGet.getDwConsolidByIdConsolidTurno() != null){
				itemSet.setDwConsolidByIdConsolidTurno(itemGet.getDwConsolidByIdConsolidTurno().clone(false));
			}
			if(itemGet.getDwConsolidByIdConsolidHora() != null){
				itemSet.setDwConsolidByIdConsolidHora(itemGet.getDwConsolidByIdConsolidHora().clone(false));
			}
			if(itemGet.getDwFolha() != null){
				itemSet.setDwFolha(itemGet.getDwFolha().clone(false));
			}
			if(itemGet.getDwConsolidByIdConsolidAcu() != null){
				itemSet.setDwConsolidByIdConsolidAcu(itemGet.getDwConsolidByIdConsolidAcu().clone(false));
			}
			if(itemGet.getPpCp() != null){
				itemSet.setPpCp(itemGet.getPpCp().clone(false));
			}
			if(itemGet.getOmPt() != null){
				itemSet.setOmPt(itemGet.getOmPt().clone(false));
			}
			if(itemGet.getDwRtcic() != null) {
				itemSet.setDwRtcic(itemGet.getDwRtcic().clone(false));
			}
			if(itemGet.getDwConsolpalog() != null) {
				itemSet.setDwConsolpalog(itemGet.getDwConsolpalog().clone(false));
			}
		}
		
		return itemSet;
		
	}
	
	/**
	 * Atualiza data de in�cio e fim 
	 * <br> S� atualiza in�cio, se o que for passado for menor que o existente
	 * <br> S� atualiza fim, se o que for passado for maior que o existente 
	 * @param dtHrInicio
	 * @param dtHrFim
	 */
	public void setDtHr(Date dtHrInicio, Date dtHrFim){
		DwConsolpt dwConsolPt = getInstanceT();
		
		dwConsolPt.setDthrInicio(DataHoraRN.getMenorData(getInstanceT().getDthrInicio(), dtHrInicio));
		dwConsolPt.setDthrFim(DataHoraRN.getMaiorData(getInstanceT().getDthrFim(), dtHrFim));
		
	}
	
	/**
	 * Ajusta o último {@code Dwconsolid} para cada um dos tipos de quebra
	 * <br> Ajusta também {@code PpCp, DwFolha, DwCal} com base no último {@code DwConsolid}
	 * @param dwConsolid
	 */
	public void setDwConsolid(DwConsolid dwConsolid){
		DwConsolpt dwConsolPt = getInstanceT();
		
		if(DwConsolidTemplate.TpId.HORA.equals(dwConsolid.getTpId())){
			dwConsolPt.setDwConsolidByIdConsolidHora(pegarMaiorDwConsolid(dwConsolPt.getDwConsolidByIdConsolidHora(), dwConsolid));
			
		}else if(DwConsolidTemplate.TpId.TURNO.equals(dwConsolid.getTpId())){
			dwConsolPt.setDwConsolidByIdConsolidTurno(pegarMaiorDwConsolid(dwConsolPt.getDwConsolidByIdConsolidTurno(), dwConsolid));
			DwConsolid dwConsolidRecente = dwConsolPt.getDwConsolidByIdConsolidTurno();
			dwConsolPt.setPpCp(dwConsolidRecente.getPpCp());
			dwConsolPt.setDwFolha(dwConsolidRecente.getDwFolha());
			dwConsolPt.setDwCal(dwConsolidRecente.getDwCal());
			dwConsolPt.setDtHr(dwConsolid.getDthrIconsol(), dwConsolid.getDthrFconsol());
			
		}else if(DwConsolidTemplate.TpId.MES.equals(dwConsolid.getTpId())){
			dwConsolPt.setDwConsolidByIdConsolidMes(pegarMaiorDwConsolid(dwConsolPt.getDwConsolidByIdConsolidMes(), dwConsolid));
			
		}else if(DwConsolidTemplate.TpId.ACUMULADO.equals(dwConsolid.getTpId())){
			dwConsolPt.setDwConsolidByIdConsolidAcu(pegarMaiorDwConsolid(dwConsolPt.getDwConsolidByIdConsolidAcu(), dwConsolid));
		}
		
		
	}
	
	private DwConsolid pegarMaiorDwConsolid(DwConsolid dwConsolid1, DwConsolid dwConsolidNovo) {
		if (dwConsolid1 == null) {
			return dwConsolidNovo;
		} else {
			if (Long.compare(dwConsolid1.getIdConsolid(), dwConsolidNovo.getIdConsolid()) >= 0) {
				return dwConsolid1;
			} else {
				return dwConsolidNovo;
			}
		}
	}
	
}
