/**
 * IPCINJLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.model.rn.integracao.ipackchem.client;

public class IPCINJLocator extends org.apache.axis.client.Service implements idw.model.rn.integracao.ipackchem.client.IPCINJ {

/**
 * Servicos de Integraçãoo - Protheus x Injet
 */

    public IPCINJLocator() {
    }


    public IPCINJLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IPCINJLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IPCINJSOAP
    private java.lang.String IPCINJSOAP_address = "http://ipackchem.totvs.com.br:8807/ws_teste/IPCINJ.apw";

    public java.lang.String getIPCINJSOAPAddress() {
        return IPCINJSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String IPCINJSOAPWSDDServiceName = "IPCINJSOAP";

    public java.lang.String getIPCINJSOAPWSDDServiceName() {
        return IPCINJSOAPWSDDServiceName;
    }

    public void setIPCINJSOAPWSDDServiceName(java.lang.String name) {
        IPCINJSOAPWSDDServiceName = name;
    }

    public idw.model.rn.integracao.ipackchem.client.IPCINJSOAP getIPCINJSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IPCINJSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIPCINJSOAP(endpoint);
    }

    public idw.model.rn.integracao.ipackchem.client.IPCINJSOAP getIPCINJSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
        	idw.model.rn.integracao.ipackchem.client.IPCINJSOAPStub _stub = new idw.model.rn.integracao.ipackchem.client.IPCINJSOAPStub(portAddress, this);
            _stub.setPortName(getIPCINJSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIPCINJSOAPEndpointAddress(java.lang.String address) {
        IPCINJSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (idw.model.rn.integracao.ipackchem.client.IPCINJSOAP.class.isAssignableFrom(serviceEndpointInterface)) {
            	idw.model.rn.integracao.ipackchem.client.IPCINJSOAPStub _stub = new idw.model.rn.integracao.ipackchem.client.IPCINJSOAPStub(new java.net.URL(IPCINJSOAP_address), this);
                _stub.setPortName(getIPCINJSOAPWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("IPCINJSOAP".equals(inputPortName)) {
            return getIPCINJSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "IPCINJ");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "IPCINJSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("IPCINJSOAP".equals(portName)) {
            setIPCINJSOAPEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
