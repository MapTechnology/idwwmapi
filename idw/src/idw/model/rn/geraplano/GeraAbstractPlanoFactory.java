package idw.model.rn.geraplano;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpPlano;
import idw.util.IdwLogger;
import idw.webservices.dto.PlanoDTO;



public abstract class GeraAbstractPlanoFactory {
	
	public static final int _ALGORITMO_TIPO_A_REGRESSIVO = 1;
	public static final int _ALGORITMO_TIPO_B_PROGRESSIVO = 2;
	public static final int _ALGORITMO_TIPO_C_PROGRESSIVO = 3;
	
	public static GeraAbstractPlanoFactory getInstancia(DAOGenerico dao, int tipoAlgoritmo) {
		GeraAbstractPlanoFactory retorno = null;
		switch (tipoAlgoritmo){
		case _ALGORITMO_TIPO_A_REGRESSIVO: // Algoritmo padrão
			retorno = new GeraPlanoProducaoTipoA(dao);
			break;
		case _ALGORITMO_TIPO_B_PROGRESSIVO:
			retorno = new GeraPlanoProducaoTipoA(dao);
			break;
		case _ALGORITMO_TIPO_C_PROGRESSIVO:
			retorno = new GeraPlanoProducaoTipoA(dao);
			break;
		}
		retorno = new GeraPlanoProducaoTipoC(dao);
		return retorno;
    }
	
	public abstract PlanoDTO processaPlano(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr);
}
