package idw.model.rn.impprog.oas;

import idw.model.pojos.OmEmpresa;
import idw.model.rn.impprog.IImportaProgramaRN;
import idw.model.rn.impprog.ImportaProgramaFactory;



public class ImportaProgramaOASFactory extends ImportaProgramaFactory {
	@Override
	public IImportaProgramaRN getImportaProgramaRN(OmEmpresa omempresa) {
        return (IImportaProgramaRN) new ImportaProgramaOASRN();
	}
}
