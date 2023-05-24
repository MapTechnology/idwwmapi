package idw.model.rn.web.taylormade;

import idw.model.dao.DAOGenerico;
import idw.model.rn.AbstractRN;

public abstract class AbstractWebTaylorMadeRN extends AbstractRN<DAOGenerico> {
	
	protected final String formatoData;
	protected final String formatoDataHora;
	
	public AbstractWebTaylorMadeRN(String formatoData, String formatoDataHora) {
        this(new DAOGenerico(), formatoData, formatoDataHora);
    }

    public AbstractWebTaylorMadeRN(DAOGenerico dao, String formatoData, String formatoDataHora) {
        super(dao);
        this.formatoData = formatoData;
        this.formatoDataHora = formatoDataHora;
    }
    
    

}
