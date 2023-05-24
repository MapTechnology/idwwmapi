package idw.model.rn.impprog;

import idw.model.pojos.OmEmpresa;
import idw.model.rn.impprog.erp.ImportaProgramaErpFactory;
import idw.model.rn.impprog.oas.ImportaProgramaOASFactory;

public abstract class ImportaProgramaFactory {

	public static final Class _IMPORTA_PROGRAMA_OAS = ImportaProgramaOASFactory.class;
	public static final Class _IMPORTA_PROGRAMA_ERP = ImportaProgramaErpFactory.class;

	public static ImportaProgramaFactory instance(Class factory) {
		try {
			return (ImportaProgramaFactory)factory.newInstance();
		} catch (Exception ex) {
			throw new RuntimeException("Nao foi criada o ImportaProgramaFactory: " + factory);
		}
	}

	public static ImportaProgramaFactory instance(int tp_impprog) {
		ImportaProgramaFactory retorno = null;
		switch (tp_impprog){
		case 0:
			retorno = null;
			break;
		case 1:
			retorno = instance(_IMPORTA_PROGRAMA_OAS);
			break;
		case 2:
			retorno = instance(_IMPORTA_PROGRAMA_ERP);
			break;
		}
		return retorno;
	}

	public abstract IImportaProgramaRN getImportaProgramaRN(OmEmpresa omempresa);    
}
