package idw.view.grafico;

import idw.webservices.dto.FiltroGraficoDTO;
import idw.webservices.dto.MaquinaDTO;

@SuppressWarnings("serial")
public abstract class GraficosCfwswebFactory extends GraficoAbstractBarraView {
	public static final int TAXA = 1;
	
	public abstract void setFiltroGraficoDTO(FiltroGraficoDTO filtro);
	
	public static GraficosCfwswebFactory getGraficosFactory(int whichFactory) {
		  
	    switch (whichFactory) {
	    	case TAXA    : 
	    		return new TaxaGraficoFactory();     
	    	
	    	default           : 
	    		return null;
	    }
}
	
	public static GraficoBase getGraficoMobile(MaquinaDTO maquinaDTO, String grafico){
		// Ultimos ciclos = 1
		// Indice de refugo = 2
		// Parreto parada = 3
		// Area responsavel = 4
		// Perdas de producao = 5
		GraficoBase retorno = null;

		if (grafico.equals("1"))
			retorno = getGraficoParettoReprocesso(maquinaDTO);
		
		return retorno;
	}

	private static GraficoBase getGraficoParettoReprocesso(MaquinaDTO maquinaDTO){
		GraficoParettoReprocesso retorno = new GraficoParettoReprocesso();
		retorno.setParettos(maquinaDTO.getParettos());
		return retorno;
	}
	
}
