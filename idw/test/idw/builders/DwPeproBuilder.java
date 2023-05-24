package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.DwPepro;


public class DwPeproBuilder extends AbstractPojoPersistentBuilder<DwPepro, DAOGenericoTest> {

	private String dsPepro = BuilderDefaults.DESCRICAO;
	
	public DwPeproBuilder withDsPepro(String dsPepro){
		this.dsPepro = dsPepro;
		return this;
	}
	
	@Override
	public DwPepro build(){
		DwPepro dwPepro = new DwPepro();
		dwPepro.setDsPepro(dsPepro);
		return dwPepro;
	}

}