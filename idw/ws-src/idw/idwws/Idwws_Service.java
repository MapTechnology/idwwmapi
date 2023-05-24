/**
 * Idwws_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public interface Idwws_Service extends javax.xml.rpc.Service {
    public java.lang.String getidwwsPortAddress();

    public idw.idwws.Idwws_PortType getidwwsPort() throws javax.xml.rpc.ServiceException;

    public idw.idwws.Idwws_PortType getidwwsPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
