package idw.model.excessoes;

@SuppressWarnings("serial")
public class ReprocessarMsEvtException extends Exception {
    public ReprocessarMsEvtException() {

    }
    
    public ReprocessarMsEvtException(Exception e) {
    	super(e);
    }

    public ReprocessarMsEvtException(String msg) {
        super(msg);
    }

}
