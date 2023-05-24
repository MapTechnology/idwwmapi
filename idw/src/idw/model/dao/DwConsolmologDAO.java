package idw.model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import idw.model.pojos.DwConsolmolog;
import idw.model.rn.DataHoraRN;

public class DwConsolmologDAO {

    private final MapQuery q;

    public DwConsolmologDAO(Session session) {
        q = new MapQuery(session);
    }

    /**
     * Pega logins abertos e fechados para o pt.<br>
     * 
     * @param idPt
     * @param dtHrInicio
     * @param dtHrFim
     * @return
     */
    public List<DwConsolmolog> getOperadoresLogadosNoPeriodoPorPt(long idPt, Date dtHrInicio, Date dtHrFim) {

        q.append("SELECT dwConsolmolog FROM DwConsolmolog dwConsolmolog");
        q.append("INNER JOIN FETCH dwConsolmolog.omUsr");
        q.append("WHERE dwConsolmolog.omPt.idPt = :idPt");
        q.append("AND ((dwConsolmolog.dthrIlogin <= :dtHrFim AND dwConsolmolog.dthrFlogin IS NULL)");
        q.append("      OR (dwConsolmolog.dthrIlogin BETWEEN :dtHrInicio AND :dtHrFim)");
        q.append("      OR (dwConsolmolog.dthrFlogin BETWEEN :dtHrInicio AND :dtHrFim)");
        q.append("      OR (dwConsolmolog.dthrIlogin < :dtHrInicio AND dwConsolmolog.dthrFlogin > :dtHrFim)");
        q.append("    )");
        q.append("ORDER BY dwConsolmolog.idConsolmolog");
        q.defineParametro("idPt", idPt);
        q.defineParametro("dtHrInicio", dtHrInicio);
        q.defineParametro("dtHrFim", dtHrFim);

        return q.list();

    }


    public List<DwConsolmolog> getOperadoresNoPeriodoPorPtComLoginEmAberto(long idPt, Date dtHrInicio, Date dtHrFim) {

        q.append("SELECT dwConsolmolog FROM DwConsolmolog dwConsolmolog");
        q.append("INNER JOIN FETCH dwConsolmolog.omUsr");
        q.append("WHERE dwConsolmolog.omPt.idPt = :idPt");
        q.append("AND dwConsolmolog.dthrIlogin <= :dtHrFim AND dwConsolmolog.dthrFlogin IS NULL");
        q.append("ORDER BY dwConsolmolog.idConsolmolog");
        q.defineParametro("idPt", idPt);
        q.defineParametro("dtHrInicio", dtHrInicio);
        q.defineParametro("dtHrFim", dtHrFim);

        return q.list();
    }

    // Marcos Sardinha: 20017-07-14 Defeito #3902 >> login em aberto nao tem vinculo com cp 
    public List<DwConsolmolog> getOperadoresNoPeriodoPorPtNaCPComLoginEmAberto(long idPt, long idCp, Date dtHrFim) {
    	Map<Long, DwConsolmolog> mapLoginsAbertos = new HashMap<Long,DwConsolmolog>();
    	
        final int _dwconsolmolog = 0;
        final int _dthrEntradaCP = 1;
        final int _dthrSaidaCP = 2;
        final int _dthrLogin = 3;
        
        q.append("SELECT dwConsolmolog, ptcp.dthrEntrada, ptcp.dthrSaida, dwConsolmolog.dthrIlogin");
    	q.append("FROM DwConsolmolog dwConsolmolog");
        q.append("JOIN FETCH dwConsolmolog.omUsr");
        q.append("JOIN FETCH dwConsolmolog.omPt pt");
        q.append("JOIN FETCH pt.omPtcps ptcp");
        q.append("JOIN FETCH ptcp.ppCp cp");        
        q.append("WHERE dwConsolmolog.omPt.idPt = :idPt");
        q.append("AND cp.idCp = :idCp");
        q.append("AND dwConsolmolog.dthrIlogin <= :dtHrFim AND dwConsolmolog.dthrFlogin IS NULL");
        q.append("ORDER BY dwConsolmolog.idConsolmolog");
        q.defineParametro("idPt", idPt);
        q.defineParametro("idCp", idCp);
        q.defineParametro("dtHrFim", dtHrFim);

        List<Object> lista = q.list();        
        for (Object reg : lista) {
        	Object[] registro = (Object[]) reg;
        	
        	DwConsolmolog molog = (DwConsolmolog) registro[_dwconsolmolog];
        	Date dthrEntradaCP = (Date) registro[_dthrEntradaCP];
        	Date dthrSaidaCP = (Date) registro[_dthrSaidaCP];
        	Date dthrLogin = (Date) registro[_dthrLogin];
        	
        	boolean islogadoCP = false;
        	
        	if (dthrSaidaCP == null) {
            	islogadoCP = true;
        		
        	} else {
            	//login realizado dentro do periodo da OP
            	if ( (DataHoraRN.after(dthrLogin, dthrEntradaCP) || DataHoraRN.equals(dthrLogin, dthrEntradaCP)) 
            			&&  (DataHoraRN.before(dthrLogin, dthrSaidaCP) || DataHoraRN.equals(dthrLogin, dthrSaidaCP)) )  {
            		islogadoCP = true;
            	}  else {
                	if (DataHoraRN.after(dthrEntradaCP, dthrLogin) || DataHoraRN.equals(dthrEntradaCP, dthrLogin)) {
                		islogadoCP = true;
                	}
            	}
        	}
        	
        	if (islogadoCP) {
        		if (mapLoginsAbertos.containsKey(molog.getIdConsolmolog()) == false) {
        			mapLoginsAbertos.put(molog.getIdConsolmolog(), molog);
        		}
        	}
        }
        
        List<DwConsolmolog> listaretorno = new ArrayList<DwConsolmolog>();
        listaretorno.addAll(mapLoginsAbertos.values());

        return listaretorno;

    }

}
