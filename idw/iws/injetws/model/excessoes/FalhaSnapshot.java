package injetws.model.excessoes;

import javax.xml.ws.WebFault;

@WebFault(name="FalhaSnapshotException", targetNamespace = "http://ms/msws")
public class FalhaSnapshot extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FalhaSnapshotException faultInfo;
	
	public FalhaSnapshot(String message, FalhaSnapshotException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    public FalhaSnapshot(String message, FalhaSnapshotException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    public FalhaSnapshotException getFaultInfo() {
        return faultInfo;
    }
    
}
