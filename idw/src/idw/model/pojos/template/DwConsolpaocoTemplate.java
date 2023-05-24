
package idw.model.pojos.template;

import idw.model.pojos.DwConsolpaoco;



public abstract class DwConsolpaocoTemplate extends AbstractTemplate<DwConsolpaoco> {

	
	@Override
	protected DwConsolpaoco atribuir(DwConsolpaoco itemGet, DwConsolpaoco itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwConsolpaoco();
		
		itemSet.setIdConsolpaoco(itemGet.getIdConsolpaoco());
		if(isCopiarFK == true){
			itemSet.setDwConsolpalog(itemGet.getDwConsolpalog().clone(true));
			
			if (itemGet.getDwConsolpa() != null)
				itemSet.setDwConsolpa(itemGet.getDwConsolpa().clone(false));
		}
		itemSet.setDthrIparada(itemGet.getDthrIparada());
		itemSet.setMsDthriparada(itemGet.getMsDthriparada());
		itemSet.setDthrFparada(itemGet.getDthrFparada());
		itemSet.setMsDthrfparada(itemGet.getMsDthrfparada());
		itemSet.setIsContinuaproximoperiodo(itemGet.getIsContinuaproximoperiodo());
		itemSet.setDthrFparadaAb(itemGet.getDthrFparadaAb());
		itemSet.setMsDthrfparadaAb(itemGet.getMsDthrfparadaAb());
		
		itemSet.setDthrCadastro(itemGet.getDthrCadastro());
		itemSet.setOrigem(itemGet.getOrigem());
		
		itemSet.setPcsAutoPerdaparadaCp(itemGet.getPcsAutoPerdaparadaCp());
		itemSet.setPcsAutoPerdaparadaSp(itemGet.getPcsAutoPerdaparadaSp());
		itemSet.setPcsManuPerdaparadaCp(itemGet.getPcsManuPerdaparadaCp());
		itemSet.setPcsManuPerdaparadaSp(itemGet.getPcsManuPerdaparadaSp());
		
		return itemSet;
	}
	
	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder();
		DwConsolpaoco from = (DwConsolpaoco) this;
		
		retorno.append("id=");
		retorno.append(from.getIdConsolpaoco());
		retorno.append("\n");
		
		retorno.append("origem=");
		retorno.append(from.getOrigem());
		retorno.append("\n");

		retorno.append("dthrCadastro=");
		retorno.append(from.getDthrCadastro());
		retorno.append("\n");

		retorno.append("dthrIParada=");
		retorno.append(from.getDthrIparada());
		retorno.append("\n");
		
		retorno.append("dthrFParada=");
		retorno.append(from.getDthrFparada());
		retorno.append("\n");

		retorno.append("dthrFParadaAB=");
		retorno.append(from.getDthrFparadaAb());
		retorno.append("\n");

		retorno.append("isContinuaProximoPeriodo=");
		retorno.append(from.getIsContinuaproximoperiodo());
		retorno.append("\n");

		retorno.append("msdthrfparada=");
		retorno.append(from.getMsDthrfparada());
		retorno.append("\n");

		retorno.append("msdthrfparadaAB=");
		retorno.append(from.getMsDthrfparadaAb());
		retorno.append("\n");
		
		retorno.append("msdthriparada=");
		retorno.append(from.getMsDthriparada());
		retorno.append("\n");

		retorno.append("pcsAutoPerdaparadaCP=");
		retorno.append(from.getPcsAutoPerdaparadaCp());
		retorno.append("\n");
		
		retorno.append("pcsAutoPerdaParadaSP=");
		retorno.append(from.getPcsAutoPerdaparadaSp());
		retorno.append("\n");

		retorno.append("pcsManuPerdaparadaCP=");
		retorno.append(from.getPcsManuPerdaparadaCp());
		retorno.append("\n");
		
		retorno.append("pcsManuPerdaParadaSP=");
		retorno.append(from.getPcsManuPerdaparadaSp());
		retorno.append("#");

		return retorno.toString();
	}
}
