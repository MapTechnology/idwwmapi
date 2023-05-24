package idw.model.rn.impprog.erp;

import idw.model.pojos.OmEmpresa;
import idw.model.rn.EmpresaRN;
import idw.model.rn.impprog.IImportaProgramaRN;
import idw.model.rn.impprog.ImportaProgramaFactory;

public class ImportaProgramaErpFactory extends ImportaProgramaFactory {

	/**
	 * Importa o mapa de alimentacao do ERP da Semp para a base do IDW
	 * @see idw.model.rn.impprog.ImportaProgramaFactory#getImportaProgramaRN()
	 */
	@Override
	public IImportaProgramaRN getImportaProgramaRN(OmEmpresa omempresa) {
		IImportaProgramaRN retorno = null;
		if (EmpresaRN.isEmpresaSemp(omempresa))
			retorno = new ImportaProgramaErpSempRN();
		else if (EmpresaRN.isEmpresaPst(omempresa))
			retorno = new ImportaProgramaErpPstRN();
		return retorno;
	}

}
