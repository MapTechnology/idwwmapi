package idw.model.rn.cargabasica;

import idw.model.dao.DAOGenerico;
import idw.model.rn.AbstractRN;

public class CargaBasicaRN extends AbstractRN<DAOGenerico>{

	public CargaBasicaRN(){
		this(new DAOGenerico());
	}
	public CargaBasicaRN(DAOGenerico dao) {
		super(dao);
	}

	public void carregaTabelasBasicas(){
		
		// Carrega tabela com direitos de acesso
		CargaDireitosAcessosRN rn = new CargaDireitosAcessosRN(getDao());
		rn.carrega();
		
	}
}
