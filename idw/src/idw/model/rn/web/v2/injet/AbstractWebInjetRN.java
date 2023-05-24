package idw.model.rn.web.v2.injet;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.rn.AbstractRN;

public class AbstractWebInjetRN extends AbstractRN<DAOGenericoInjet> {
	
	protected final String formatoData;
	protected final String formatoDataHora;
	
	public AbstractWebInjetRN(String formatoData, String formatoDataHora) {
        this(new DAOGenericoInjet(), formatoData, formatoDataHora);
    }

    public AbstractWebInjetRN(DAOGenericoInjet dao, String formatoData, String formatoDataHora) {
        super(dao);
        this.formatoData = formatoData;
        this.formatoDataHora = formatoDataHora;
    }

}
