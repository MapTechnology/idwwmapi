package idw.model.rn.web.vf;

import idw.model.dao.DAOGenerico;
import idw.model.rn.AbstractRN;

public abstract class AbstractWebRN extends AbstractRN<DAOGenerico> {
	
	protected final String formatoData;
	protected final String formatoDataHora;
	
	public AbstractWebRN(String formatoData, String formatoDataHora) {
        this(new DAOGenerico(), formatoData, formatoDataHora);
    }

    public AbstractWebRN(DAOGenerico dao, String formatoData, String formatoDataHora) {
        super(dao);
        this.formatoData = formatoData;
        this.formatoDataHora = formatoDataHora;
    }

}
