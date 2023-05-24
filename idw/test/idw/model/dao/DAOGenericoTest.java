package idw.model.dao;

import idw.builders.DwCalBuilder;
import idw.builders.DwPeproBuilder;
import idw.builders.OmCcBuilder;
import idw.builders.OmCfgBuilder;
import idw.builders.OmUsrBuilder;
import idw.builders.OmUsrgrpBuilder;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwPepro;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmUsr;

import org.hibernate.SessionFactory;

public class DAOGenericoTest extends DAOGenerico{

	@Override
	protected SessionFactory getSessionFactory() {
		return HibernateUtilTest.getSessionFactory();
	}
	
	public OmCfg createOmCfg(){
		
		OmUsr omUsr = new OmUsrBuilder()
			.withOmUsrgrp(new OmUsrgrpBuilder().buildAndPersist(this))			
			.buildAndPersist(this);
		DwPepro dwPepro = new DwPeproBuilder().buildAndPersist(this);
		
		DwCal dwCal = new DwCalBuilder()
			.withOmUsrRevisao(omUsr)
			.withOmUsrStAtivo(omUsr)
			.buildAndPersist(this);
		
		OmCc omCc = new OmCcBuilder()
			.withOmUsrrevisao(omUsr)
			.withOmUsrstativo(omUsr)
			.buildAndPersist(this);
		
		OmCfg omCfg = new OmCfgBuilder()
			.withDwCal(dwCal)
			.withDwPeproNormal(dwPepro)
			.withDwPreproCtrepproc(dwPepro)
			.withOmUsrimpprog(omUsr)
			.withOmUsrrevisao(omUsr)
			.withOmUsrstativo(omUsr)
			.withDwCal(dwCal)
			.withOmCcdefault(omCc)  
			.buildAndPersist(this);
				
		return omCfg;
				
	}
	
	
}
