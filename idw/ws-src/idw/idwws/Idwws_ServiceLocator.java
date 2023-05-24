/**
 * Idwws_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Idwws_ServiceLocator extends org.apache.axis.client.Service implements idw.idwws.Idwws_Service {

    public Idwws_ServiceLocator() {
    }


    public Idwws_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Idwws_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for idwwsPort
    private java.lang.String idwwsPort_address = "http://localhost:8080/idw/idwws";

    public java.lang.String getidwwsPortAddress() {
        return idwwsPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String idwwsPortWSDDServiceName = "idwwsPort";

    public java.lang.String getidwwsPortWSDDServiceName() {
        return idwwsPortWSDDServiceName;
    }

    public void setidwwsPortWSDDServiceName(java.lang.String name) {
        idwwsPortWSDDServiceName = name;
    }

    public idw.idwws.Idwws_PortType getidwwsPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(idwwsPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getidwwsPort(endpoint);
    }

    public idw.idwws.Idwws_PortType getidwwsPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            idw.idwws.IdwwsPortBindingStub _stub = new idw.idwws.IdwwsPortBindingStub(portAddress, this);
            _stub.setPortName(getidwwsPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setidwwsPortEndpointAddress(java.lang.String address) {
        idwwsPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (idw.idwws.Idwws_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                idw.idwws.IdwwsPortBindingStub _stub = new idw.idwws.IdwwsPortBindingStub(new java.net.URL(idwwsPort_address), this);
                _stub.setPortName(getidwwsPortWSDDServiceName());
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
        if ("idwwsPort".equals(inputPortName)) {
            return getidwwsPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://idw/idwws", "idwws");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://idw/idwws", "idwwsPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("idwwsPort".equals(portName)) {
            setidwwsPortEndpointAddress(address);
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
