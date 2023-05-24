package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.OmAlgocor;

public class OmAlgocorBuilder extends AbstractPojoPersistentBuilder<OmAlgocor, DAOGenericoTest>{
	
	private String dsAlgocor = BuilderDefaults.DESCRICAO;

	public OmAlgocorBuilder withDsAlgocor(String dsAlgocor){
		this.dsAlgocor = dsAlgocor;
		return this;
	}

	@Override
	public OmAlgocor build() {
		OmAlgocor algocor = new OmAlgocor();
		algocor.setDsAlgocor(dsAlgocor);
		return algocor;
	}

}