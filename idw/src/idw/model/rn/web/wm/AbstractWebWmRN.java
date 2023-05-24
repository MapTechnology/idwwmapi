package idw.model.rn.web.wm;

import idw.model.dao.DAOGenerico;
import idw.model.rn.AbstractRN;

public abstract class AbstractWebWmRN extends AbstractRN<DAOGenerico> {
	
	protected final String formatoData;
	protected final String formatoDataHora;
	
	public AbstractWebWmRN(String formatoData, String formatoDataHora) {
        this(new DAOGenerico(), formatoData, formatoDataHora);
    }

    public AbstractWebWmRN(DAOGenerico dao, String formatoData, String formatoDataHora) {
        super(dao);
        this.formatoData = formatoData;
        this.formatoDataHora = formatoDataHora;
    }

}
