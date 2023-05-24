package idw.model.dao.interceptor;


import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.PpCp;
import idw.util.IdwLogger;

public class AuditorInterceptor extends EmptyInterceptor {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int updates;
    private int creates;
    private int loads;
    private IdwLogger log;

    public void onDelete(Object entity,
                         Serializable id,
                         Object[] state,
                         String[] propertyNames,
                         Type[] types) {
    	
    	System.out.println("deleting " + entity.getClass());

        if ( entity instanceof DwConsolpaoco ) {
        	DwConsolpaoco pojo = (DwConsolpaoco) entity;
        }
    }

    // aparentemente usado no update
    public boolean onFlushDirty(Object entity,
                                Serializable id,
                                Object[] currentState,
                                Object[] previousState,
                                String[] propertyNames,
                                Type[] types) {

        if (entity instanceof DwConsol) {
        	DwConsol pojo = (DwConsol) entity;
        	if (pojo.getIdConsol() == 446952l)
        		System.out.println("idConsol = " + pojo.getIdConsol() + " PB=" + pojo.getPcsAutoProducaobruta());
        }
//        if (entity instanceof DwConsolpaoco) {
//        	DwConsolpaoco pojo = (DwConsolpaoco) entity;
//        	System.out.println(pojo.toString());
//        }
//        if (entity instanceof DwConsol) {
//        	DwConsol pojo = (DwConsol) entity;
//        	System.out.println("id=" + pojo.getIdConsol() + " cp=" + pojo.getSegAutoTempoparadaCp());
//        }


        return false;
    }

    public boolean onLoad(Object entity,
                          Serializable id,
                          Object[] state,
                          String[] propertyNames,
                          Type[] types) {
        return false;
    }

    // aparentemente executado no insert
    public boolean onSave(Object entity,
                          Serializable id,
                          Object[] state,
                          String[] propertyNames,
                          Type[] types) {

//    	System.out.println(entity.getClass().getName());
        if (entity instanceof DwConsol) {
        	DwConsol pojo = (DwConsol) entity;
//        	if (pojo.getIdConsol() == 11201l) {
        		// (new Exception()).printStackTrace();
        		System.out.println(pojo.getIdConsol() + " = alterando pcsAutoProducaoBruta para " + pojo.getPcsAutoProducaobruta());
//        	}
        }

    	/*
        if ( entity instanceof PrUp ) {
        	PrUp prup = (PrUp) entity;
        	log = new IdwLogger(prup.getIdup().toString());
        	if (prup.getDthrinicic() != null)
        		log.info("onSave para idup = " + prup.getIdup() + " com dthrinicic=" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(prup.getDthrinicic()));
        	else
        		log.info("onSave para idup = " + prup.getIdup());
        }
        
        if (entity instanceof PrColetorEventos) {
        	System.out.println("onSave");
        	(new Exception()).printStackTrace();
        }*/
        
        return false;
    }

    public void afterTransactionCompletion(Transaction tx) {
//        updates=0;
//        creates=0;
//        loads=0;
//        log = new IdwLogger("transacao" + tx.toString());
//    	log.info("Fechou a transavao via: ");
//    	log.info("stack ", new Exception());
    	Exception e = new Exception();
    	System.out.println("afterTransactionCompletion");
    	e.printStackTrace();

    }

    public void afterTransactionBegin(Transaction tx) {
//    	log = new IdwLogger("transacao" + tx.toString());
//    	log.info("Abriu a transacao via: ");
//    	log.info("stack", new Exception());
    	Exception e = new Exception();
    	System.out.println("afterTransactionBegin");
    	e.printStackTrace();
    }
}