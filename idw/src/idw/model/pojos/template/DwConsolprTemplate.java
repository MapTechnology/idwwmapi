package idw.model.pojos.template;

import java.math.BigDecimal;

import idw.model.pojos.DwConsolpr;
import idw.util.AritmeticaUtil;

public abstract class DwConsolprTemplate  extends AbstractTemplate<DwConsolpr>{
	@Override
	protected DwConsolpr atribuir(DwConsolpr itemGet, DwConsolpr itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwConsolpr();

		itemSet.setIdConsolpr(itemGet.getIdConsolpr());

		itemSet.setGAutoPesoBruto(itemGet.getGAutoPesoBruto());
		itemSet.setGAutoPesoLiquido(itemGet.getGAutoPesoLiquido());
		itemSet.setGManuPesoBruto(itemGet.getGManuPesoBruto());
		itemSet.setGManuPesoLiquido(itemGet.getGManuPesoLiquido());
		
		itemSet.setPcsAutoProducaobruta(itemGet.getPcsAutoProducaobruta());
		itemSet.setPcsAutoProducaoliquida(itemGet.getPcsAutoProducaoliquida());
		itemSet.setPcsAutoProducaorefugada(itemGet.getPcsAutoProducaorefugada());
		itemSet.setPcsManuProducaobruta(itemGet.getPcsManuProducaobruta());
		itemSet.setPcsManuProducaoliquida(itemGet.getPcsManuProducaoliquida());
		itemSet.setPcsManuProducaorefugada(itemGet.getPcsManuProducaorefugada());
		
		itemSet.setPcsAutoPerdacavidades(itemGet.getPcsAutoPerdacavidades());
		itemSet.setPcsAutoPerdaciclo(itemGet.getPcsAutoPerdaciclo());
		itemSet.setPcsAutoPerdaparadaCp(itemGet.getPcsAutoPerdaparadaCp());
		itemSet.setPcsAutoPerdaparadaSp(itemGet.getPcsAutoPerdaparadaSp());
		itemSet.setSegAutoTempoparada(itemGet.getSegAutoTempoparada());
		itemSet.setSegAutoTempoparadaSp(itemGet.getSegAutoTempoparadaSp());
		
		itemSet.setPcsAutoProducaoprevista(itemGet.getPcsAutoProducaoprevista());
		itemSet.setSegAutoRitmo(itemGet.getSegAutoRitmo());
		
		
		itemSet.setOmProduto(itemGet.getOmProduto().clone(false));
		
		if(isCopiarFK){
			itemSet.setDwConsol(itemGet.getDwConsol().clone(false));
		}
				
		// TODO implementar clone de DwConsolprmo 
	
		return itemSet;
	}
	
	@Override
	public String toString() {
		DwConsolpr itemGet = (DwConsolpr) this;

		StringBuilder retorno = new StringBuilder();

		retorno.append("idconsolpr=").append(itemGet.getIdConsolpr()).append("\n");

		retorno.append("getGAutoPesoBruto=").append(itemGet.getGAutoPesoBruto()).append("\n");
		retorno.append("getGAutoPesoLiquido=").append(itemGet.getGAutoPesoLiquido()).append("\n");
		retorno.append("getGManuPesoBruto=").append(itemGet.getGManuPesoBruto()).append("\n");
		retorno.append("getGManuPesoLiquido=").append(itemGet.getGManuPesoLiquido()).append("\n");
		
		retorno.append("getPcsAutoProducaobruta=").append(itemGet.getPcsAutoProducaobruta()).append("\n");
		retorno.append("getPcsAutoProducaorefugada=").append(itemGet.getPcsAutoProducaorefugada()).append("\n");
		retorno.append("getPcsManuProducaobruta=").append(itemGet.getPcsManuProducaobruta()).append("\n");
		retorno.append("getPcsManuProducaorefugada=").append(itemGet.getPcsManuProducaorefugada()).append("\n");
		retorno.append("getOmProduto=").append(itemGet.getOmProduto().getIdProduto()).append("\n");

		retorno.append("getSegAutoTempoparada=").append(itemGet.getSegAutoTempoparada()).append("\n");
		retorno.append("getOmProduto=").append(itemGet.getSegAutoTempoparadaSp()).append("\n");
		
		return retorno.toString();
	}
	
	
	public BigDecimal getPcsProducaoLiquida(){
		BigDecimal pl = getInstanceT().getPcsAutoProducaoliquida();
		
		if (pl == null)
			pl = AritmeticaUtil.diminuir(
				getPcsProducaoBruta(),
				getPcsProducaoRefugada());
		
		return pl;
	}
	
	// Retorna a producao bruta considerando a correcao manual
	public BigDecimal getPcsProducaoBruta() {
		BigDecimal autoProducaoBruta = getInstanceT().getPcsAutoProducaobruta();
		
		if (autoProducaoBruta == null)
			autoProducaoBruta = BigDecimal.ZERO;
			
		if (getInstanceT().getPcsManuProducaobruta() != null)
			autoProducaoBruta = autoProducaoBruta.add(getInstanceT().getPcsManuProducaobruta());
		return autoProducaoBruta;
	}
	
	// Retorna a producao refugada considerando correcao
	public BigDecimal getPcsProducaoRefugada() {
		BigDecimal autoProducaoRefugada = getInstanceT().getPcsAutoProducaorefugada();
		if (autoProducaoRefugada == null)
			autoProducaoRefugada = BigDecimal.ZERO;
		if (getInstanceT().getPcsManuProducaorefugada() != null)
			autoProducaoRefugada = autoProducaoRefugada.add(getInstanceT().getPcsManuProducaorefugada());
		return autoProducaoRefugada;
	}

}
