/**
 * ProgramacaoWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.pst.scam.server.presentation.web.endpoint;

public class ProgramacaoWSServiceLocator extends org.apache.axis.client.Service implements br.com.pst.scam.server.presentation.web.endpoint.ProgramacaoWSService {

    public ProgramacaoWSServiceLocator() {
    }


    public ProgramacaoWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProgramacaoWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ProgramacaoWSPort
    // servidor de producao = http://mao-webapp-01.pst.local:8180/SCAM/programacaoWS
    // servidor de testes = http://192.168.4.44:8480/SCAM/programacaoWS
    private java.lang.String ProgramacaoWSPort_address = "http://mao-webapp-01.pst.local:8180/SCAM/programacaoWS";

    public java.lang.String getProgramacaoWSPortAddress() {
        return ProgramacaoWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ProgramacaoWSPortWSDDServiceName = "ProgramacaoWSPort";

    public java.lang.String getProgramacaoWSPortWSDDServiceName() {
        return ProgramacaoWSPortWSDDServiceName;
    }

    public void setProgramacaoWSPortWSDDServiceName(java.lang.String name) {
        ProgramacaoWSPortWSDDServiceName = name;
    }

    public br.com.pst.scam.server.presentation.web.endpoint.ProgramacaoWS getProgramacaoWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ProgramacaoWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getProgramacaoWSPort(endpoint);
    }

    public br.com.pst.scam.server.presentation.web.endpoint.ProgramacaoWS getProgramacaoWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.pst.scam.server.presentation.web.endpoint.ProgramacaoWSPortBindingStub _stub = new br.com.pst.scam.server.presentation.web.endpoint.ProgramacaoWSPortBindingStub(portAddress, this);
            _stub.setPortName(getProgramacaoWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setProgramacaoWSPortEndpointAddress(java.lang.String address) {
        ProgramacaoWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.pst.scam.server.presentation.web.endpoint.ProgramacaoWS.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.pst.scam.server.presentation.web.endpoint.ProgramacaoWSPortBindingStub _stub = new br.com.pst.scam.server.presentation.web.endpoint.ProgramacaoWSPortBindingStub(new java.net.URL(ProgramacaoWSPort_address), this);
                _stub.setPortName(getProgramacaoWSPortWSDDServiceName());
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
        if ("ProgramacaoWSPort".equals(inputPortName)) {
            return getProgramacaoWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://endpoint.web.presentation.server.scam.pst.com.br/", "ProgramacaoWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://endpoint.web.presentation.server.scam.pst.com.br/", "ProgramacaoWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ProgramacaoWSPort".equals(portName)) {
            setProgramacaoWSPortEndpointAddress(address);
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
