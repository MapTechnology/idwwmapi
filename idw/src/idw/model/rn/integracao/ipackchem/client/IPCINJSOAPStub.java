/**
 * IPCINJSOAPStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.model.rn.integracao.ipackchem.client;

public class IPCINJSOAPStub extends org.apache.axis.client.Stub implements idw.model.rn.integracao.ipackchem.client.IPCINJSOAP {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[3];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("XLIBCERTIFICADO");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XLST_PAR03"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XPAR03"), idw.model.rn.integracao.ipackchem.client.XPAR03.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XRET03"));
        oper.setReturnClass(idw.model.rn.integracao.ipackchem.client.XRET03.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XLIBCERTIFICADORESULT"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("XOPDTPREV");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XLST_PAR01"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XPAR01"), idw.model.rn.integracao.ipackchem.client.XPAR01.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XRET01"));
        oper.setReturnClass(idw.model.rn.integracao.ipackchem.client.XRET01.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XOPDTPREVRESULT"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("XPRODUCAO");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XLST_PAR02"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XPAR02"), idw.model.rn.integracao.ipackchem.client.XPAR02.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XRET02"));
        oper.setReturnClass(idw.model.rn.integracao.ipackchem.client.XRET02.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XPRODUCAORESULT"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

    }

    public IPCINJSOAPStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public IPCINJSOAPStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public IPCINJSOAPStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "ARRAYOFXPAR02LST");
            cachedSerQNames.add(qName);
            cls = idw.model.rn.integracao.ipackchem.client.XPAR02LST[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XPAR02LST");
            qName2 = new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XPAR02LST");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XPAR01");
            cachedSerQNames.add(qName);
            cls = idw.model.rn.integracao.ipackchem.client.XPAR01.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XPAR02");
            cachedSerQNames.add(qName);
            cls = idw.model.rn.integracao.ipackchem.client.XPAR02.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XPAR02LST");
            cachedSerQNames.add(qName);
            cls = idw.model.rn.integracao.ipackchem.client.XPAR02LST.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XPAR03");
            cachedSerQNames.add(qName);
            cls = idw.model.rn.integracao.ipackchem.client.XPAR03.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XRET01");
            cachedSerQNames.add(qName);
            cls = idw.model.rn.integracao.ipackchem.client.XRET01.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XRET02");
            cachedSerQNames.add(qName);
            cls = idw.model.rn.integracao.ipackchem.client.XRET02.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XRET03");
            cachedSerQNames.add(qName);
            cls = idw.model.rn.integracao.ipackchem.client.XRET03.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public idw.model.rn.integracao.ipackchem.client.XRET03 XLIBCERTIFICADO(idw.model.rn.integracao.ipackchem.client.XPAR03 XLST_PAR03) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ipackchem.totvs.com.br:8807/XLIBCERTIFICADO");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XLIBCERTIFICADO"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {XLST_PAR03});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (idw.model.rn.integracao.ipackchem.client.XRET03) _resp;
            } catch (java.lang.Exception _exception) {
                return (idw.model.rn.integracao.ipackchem.client.XRET03) org.apache.axis.utils.JavaUtils.convert(_resp, idw.model.rn.integracao.ipackchem.client.XRET03.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public idw.model.rn.integracao.ipackchem.client.XRET01 XOPDTPREV(idw.model.rn.integracao.ipackchem.client.XPAR01 XLST_PAR01) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ipackchem.totvs.com.br:8807/XOPDTPREV");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XOPDTPREV"));

        setRequestHeaders(_call);
        setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] { XLST_PAR01 });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (idw.model.rn.integracao.ipackchem.client.XRET01) _resp;
				} catch (java.lang.Exception _exception) {
					return (idw.model.rn.integracao.ipackchem.client.XRET01) org.apache.axis.utils.JavaUtils.convert(_resp,
							idw.model.rn.integracao.ipackchem.client.XRET01.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

    public idw.model.rn.integracao.ipackchem.client.XRET02 XPRODUCAO(idw.model.rn.integracao.ipackchem.client.XPAR02 XLST_PAR02) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ipackchem.totvs.com.br:8807/XPRODUCAO");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XPRODUCAO"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {XLST_PAR02});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (idw.model.rn.integracao.ipackchem.client.XRET02) _resp;
            } catch (java.lang.Exception _exception) {
                return (idw.model.rn.integracao.ipackchem.client.XRET02) org.apache.axis.utils.JavaUtils.convert(_resp, idw.model.rn.integracao.ipackchem.client.XRET02.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
