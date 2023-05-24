package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.HashSet;

import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwTArea;

public abstract class DwConsolpaTemplate extends AbstractTemplate<DwConsolpa>{

	public abstract BigDecimal getSegAutoTempoparadaCp();
	public abstract void setSegAutoTempoparadaCp(BigDecimal segAutoTempoparadaCp);
	public abstract BigDecimal getSegAutoTempoparadaSp();
	public abstract void setSegAutoTempoparadaSp(BigDecimal segAutoTempoparadaSp);

	@Override
	protected DwConsolpa atribuir(DwConsolpa itemGet, DwConsolpa itemSet,
			boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwConsolpa();
		
		itemSet.setIdConsolpa(itemGet.getIdConsolpa());
		itemSet.setQtAutoOcoparadaCp(itemGet.getQtAutoOcoparadaCp());
		itemSet.setQtAutoOcoparadaSp(itemGet.getQtAutoOcoparadaSp());
		itemSet.setQtManuOcoparadaCp(itemGet.getQtManuOcoparadaCp());
		itemSet.setQtManuOcoparadaSp(itemGet.getQtManuOcoparadaSp());
		itemSet.setSegAutoTempoparadaAb(itemGet.getSegAutoTempoparadaAb());
		itemSet.setSegAutoTempoparadaCp(itemGet.getSegAutoTempoparadaCp());
		itemSet.setSegAutoTempoparadaSp(itemGet.getSegAutoTempoparadaSp());
		itemSet.setSegManuTempoparadaCp(itemGet.getSegManuTempoparadaCp());
		itemSet.setSegManuTempoparadaSp(itemGet.getSegManuTempoparadaSp());
		
		itemSet.setSegAutoTempoparadaCpVr(itemGet.getSegAutoTempoparadaCpVr());
		itemSet.setSegAutoTempoparadaSpVr(itemGet.getSegAutoTempoparadaSpVr());
		itemSet.setSegManuTempoparadaCpVr(itemGet.getSegManuTempoparadaCpVr());
		itemSet.setSegManuTempoparadaSpVr(itemGet.getSegManuTempoparadaSpVr());
		itemSet.setQtAutoOcoparadaCpVr(itemGet.getQtAutoOcoparadaCpVr());
		itemSet.setQtAutoOcoparadaSpVr(itemGet.getQtAutoOcoparadaSpVr());
		itemSet.setQtManuOcoparadaCpVr(itemGet.getQtManuOcoparadaCpVr());
		itemSet.setQtManuOcoparadaSpVr(itemGet.getQtManuOcoparadaSpVr());
		itemSet.setSegAutoTempoparadaDefault(itemGet.getSegAutoTempoparadaDefault());
		itemSet.setSegAutoTempoparadaSemOp(itemGet.getSegAutoTempoparadaSemOp());
		itemSet.setSegAutoTempoparadaSemEvt(itemGet.getSegAutoTempoparadaSemEvt());
		itemSet.setSegAutoTempoparadaSemCnx(itemGet.getSegAutoTempoparadaSemCnx());
		itemSet.setSegManuTempoparadaDefault(itemGet.getSegManuTempoparadaDefault());
		itemSet.setSegManuTempoparadaSemOp(itemGet.getSegManuTempoparadaSemOp());
		itemSet.setSegManuTempoparadaSemEvt(itemGet.getSegManuTempoparadaSemEvt());
		itemSet.setSegManuTempoparadaSemCnx(itemGet.getSegManuTempoparadaSemCnx());
		itemSet.setQtAutoTempoparadaDefault(itemGet.getQtAutoTempoparadaDefault());
		itemSet.setQtAutoTempoparadaSemOp(itemGet.getQtAutoTempoparadaSemOp());
		itemSet.setQtAutoTempoparadaSemEvt(itemGet.getQtAutoTempoparadaSemEvt());
		itemSet.setQtAutoTempoparadaSemCnx(itemGet.getQtAutoTempoparadaSemCnx());
		itemSet.setQtManuTempoparadaDefault(itemGet.getQtManuTempoparadaDefault());
		itemSet.setQtManuTempoparadaSemOp(itemGet.getQtManuTempoparadaSemOp());
		itemSet.setQtManuTempoparadaSemEvt(itemGet.getQtManuTempoparadaSemEvt());
		itemSet.setQtManuTempoparadaSemCnx(itemGet.getQtManuTempoparadaSemCnx());
		itemSet.setSegAutoCta(itemGet.getSegAutoCta());
		itemSet.setSegManuCta(itemGet.getSegManuCta());
		
		itemSet.setPcsAutoPerdaparadaCp(itemGet.getPcsAutoPerdaparadaCp());
		itemSet.setPcsAutoPerdaparadaSp(itemGet.getPcsAutoPerdaparadaSp());
		itemSet.setPcsManuPerdaparadaCp(itemGet.getPcsManuPerdaparadaCp());
		itemSet.setPcsManuPerdaparadaSp(itemGet.getPcsManuPerdaparadaSp());
		
		if (isCopiarFK){
			
			if(itemGet.getDwConsolpaocos() != null){
				itemSet.setDwConsolpaocos(new HashSet<DwConsolpaoco>());
				
				for(DwConsolpaoco dwconsolpaoco :itemGet.getDwConsolpaocos()){
					itemSet.getDwConsolpaocos().add(dwconsolpaoco.clone(true));
				}
				
			}

		}

		// necess�rio copiar independente de isCopiarFK. Utilizada nos gr�ficos de paradas 
		if (itemGet.getDwTParada() != null){
			DwTArea dwTarea = null;
			if (itemGet.getDwTParada().getDwTArea() != null){
				dwTarea = itemGet.getDwTParada().getDwTArea().clone(false);
			}
			 
			itemSet.setDwTParada(itemGet.getDwTParada().clone(false));
			itemSet.getDwTParada().setDwTArea(dwTarea);
		}
		
		return itemSet;
	}
	
	public boolean isRegistroInvalido() {
		
		//20170119...
		// detectado ocorrência de registros em dwPA cujo [seg_auto_tempoparada_cp<0] , e a maioria deles com agravante de não possuir correlato em dwPAOCO.
		// // a ver --select count(*) from dw_consolpa where seg_auto_tempoparada_cp<0 --43
		// Conversado com Alessandre, acordado em alterar diretamente este método do Template de modo a disponibilizar o "descarte" de tais registros para todos as de´pendências.
		//20170119 Trecho abaixo passa a ignorar também os itens com tempo<0 ; registros que inclusive, coincidentemente, não estão listados em dwconsolpaoco; contudo não usado esse fato (dwconsolpaoco null) aqui na condicional abaixo.
		// alteração:
		// ANTES:	== 0d
		// APÒS:	<= 0d
		//20170119.
		
		//20170119: <= 0d
		return  (getSegAutoTempoparadaCp() == null && getSegAutoTempoparadaSp() == null) ||
				(getSegAutoTempoparadaCp() == null && getSegAutoTempoparadaSp() != null && getSegAutoTempoparadaSp().doubleValue() <= 0d) ||
				(getSegAutoTempoparadaCp() != null && getSegAutoTempoparadaCp().doubleValue() <= 0d && getSegAutoTempoparadaSp() == null) ||
				(getSegAutoTempoparadaCp() != null && getSegAutoTempoparadaCp().doubleValue() <= 0d && getSegAutoTempoparadaSp() == null && getSegAutoTempoparadaSp() != null && getSegAutoTempoparadaSp().doubleValue() <= 0d)
				;
	}
	
	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder();
		DwConsolpa from = (DwConsolpa) this;
		
		retorno.append("idConsolpa=");
		retorno.append(from.getIdConsolpa());
		retorno.append(", ");
		
		retorno.append("pcsAutoPerdaparadaCp=");
		retorno.append(from.getPcsAutoPerdaparadaCp());
		retorno.append(", ");

		retorno.append("pcsAutoPerdaparadaSp=");
		retorno.append(from.getPcsAutoPerdaparadaSp());
		retorno.append(", ");

		retorno.append("segAutoTempoParadaCp=");
		retorno.append(from.getSegAutoTempoparadaCp());
		retorno.append(", ");

		retorno.append("segAutoTempoParadaSp=");
		retorno.append(from.getSegAutoTempoparadaSp());
		retorno.append("#");

		return retorno.toString();
	}
}
