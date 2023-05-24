/**
 * Ijtbequipamentos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbequipamentos  implements java.io.Serializable {
    private java.lang.String comsoftfab;

    private java.lang.String dsequipamento;

    private java.lang.String enderecoip;

    private java.lang.String gateway;

    private java.lang.String idequipamento;

    private idw.idwws.Ijcomequipamento[] ijcomequipamentos;

    private idw.idwws.Ijcomequipcent[] ijcomequipcents;

    private idw.idwws.Ijtbaleauto[] ijtbaleautos;

    private java.lang.String parcomserialpc;

    private java.lang.String submascararede;

    private java.math.BigDecimal tpequipamento;

    public Ijtbequipamentos() {
    }

    public Ijtbequipamentos(
           java.lang.String comsoftfab,
           java.lang.String dsequipamento,
           java.lang.String enderecoip,
           java.lang.String gateway,
           java.lang.String idequipamento,
           idw.idwws.Ijcomequipamento[] ijcomequipamentos,
           idw.idwws.Ijcomequipcent[] ijcomequipcents,
           idw.idwws.Ijtbaleauto[] ijtbaleautos,
           java.lang.String parcomserialpc,
           java.lang.String submascararede,
           java.math.BigDecimal tpequipamento) {
           this.comsoftfab = comsoftfab;
           this.dsequipamento = dsequipamento;
           this.enderecoip = enderecoip;
           this.gateway = gateway;
           this.idequipamento = idequipamento;
           this.ijcomequipamentos = ijcomequipamentos;
           this.ijcomequipcents = ijcomequipcents;
           this.ijtbaleautos = ijtbaleautos;
           this.parcomserialpc = parcomserialpc;
           this.submascararede = submascararede;
           this.tpequipamento = tpequipamento;
    }


    /**
     * Gets the comsoftfab value for this Ijtbequipamentos.
     * 
     * @return comsoftfab
     */
    public java.lang.String getComsoftfab() {
        return comsoftfab;
    }


    /**
     * Sets the comsoftfab value for this Ijtbequipamentos.
     * 
     * @param comsoftfab
     */
    public void setComsoftfab(java.lang.String comsoftfab) {
        this.comsoftfab = comsoftfab;
    }


    /**
     * Gets the dsequipamento value for this Ijtbequipamentos.
     * 
     * @return dsequipamento
     */
    public java.lang.String getDsequipamento() {
        return dsequipamento;
    }


    /**
     * Sets the dsequipamento value for this Ijtbequipamentos.
     * 
     * @param dsequipamento
     */
    public void setDsequipamento(java.lang.String dsequipamento) {
        this.dsequipamento = dsequipamento;
    }


    /**
     * Gets the enderecoip value for this Ijtbequipamentos.
     * 
     * @return enderecoip
     */
    public java.lang.String getEnderecoip() {
        return enderecoip;
    }


    /**
     * Sets the enderecoip value for this Ijtbequipamentos.
     * 
     * @param enderecoip
     */
    public void setEnderecoip(java.lang.String enderecoip) {
        this.enderecoip = enderecoip;
    }


    /**
     * Gets the gateway value for this Ijtbequipamentos.
     * 
     * @return gateway
     */
    public java.lang.String getGateway() {
        return gateway;
    }


    /**
     * Sets the gateway value for this Ijtbequipamentos.
     * 
     * @param gateway
     */
    public void setGateway(java.lang.String gateway) {
        this.gateway = gateway;
    }


    /**
     * Gets the idequipamento value for this Ijtbequipamentos.
     * 
     * @return idequipamento
     */
    public java.lang.String getIdequipamento() {
        return idequipamento;
    }


    /**
     * Sets the idequipamento value for this Ijtbequipamentos.
     * 
     * @param idequipamento
     */
    public void setIdequipamento(java.lang.String idequipamento) {
        this.idequipamento = idequipamento;
    }


    /**
     * Gets the ijcomequipamentos value for this Ijtbequipamentos.
     * 
     * @return ijcomequipamentos
     */
    public idw.idwws.Ijcomequipamento[] getIjcomequipamentos() {
        return ijcomequipamentos;
    }


    /**
     * Sets the ijcomequipamentos value for this Ijtbequipamentos.
     * 
     * @param ijcomequipamentos
     */
    public void setIjcomequipamentos(idw.idwws.Ijcomequipamento[] ijcomequipamentos) {
        this.ijcomequipamentos = ijcomequipamentos;
    }

    public idw.idwws.Ijcomequipamento getIjcomequipamentos(int i) {
        return this.ijcomequipamentos[i];
    }

    public void setIjcomequipamentos(int i, idw.idwws.Ijcomequipamento _value) {
        this.ijcomequipamentos[i] = _value;
    }


    /**
     * Gets the ijcomequipcents value for this Ijtbequipamentos.
     * 
     * @return ijcomequipcents
     */
    public idw.idwws.Ijcomequipcent[] getIjcomequipcents() {
        return ijcomequipcents;
    }


    /**
     * Sets the ijcomequipcents value for this Ijtbequipamentos.
     * 
     * @param ijcomequipcents
     */
    public void setIjcomequipcents(idw.idwws.Ijcomequipcent[] ijcomequipcents) {
        this.ijcomequipcents = ijcomequipcents;
    }

    public idw.idwws.Ijcomequipcent getIjcomequipcents(int i) {
        return this.ijcomequipcents[i];
    }

    public void setIjcomequipcents(int i, idw.idwws.Ijcomequipcent _value) {
        this.ijcomequipcents[i] = _value;
    }


    /**
     * Gets the ijtbaleautos value for this Ijtbequipamentos.
     * 
     * @return ijtbaleautos
     */
    public idw.idwws.Ijtbaleauto[] getIjtbaleautos() {
        return ijtbaleautos;
    }


    /**
     * Sets the ijtbaleautos value for this Ijtbequipamentos.
     * 
     * @param ijtbaleautos
     */
    public void setIjtbaleautos(idw.idwws.Ijtbaleauto[] ijtbaleautos) {
        this.ijtbaleautos = ijtbaleautos;
    }

    public idw.idwws.Ijtbaleauto getIjtbaleautos(int i) {
        return this.ijtbaleautos[i];
    }

    public void setIjtbaleautos(int i, idw.idwws.Ijtbaleauto _value) {
        this.ijtbaleautos[i] = _value;
    }


    /**
     * Gets the parcomserialpc value for this Ijtbequipamentos.
     * 
     * @return parcomserialpc
     */
    public java.lang.String getParcomserialpc() {
        return parcomserialpc;
    }


    /**
     * Sets the parcomserialpc value for this Ijtbequipamentos.
     * 
     * @param parcomserialpc
     */
    public void setParcomserialpc(java.lang.String parcomserialpc) {
        this.parcomserialpc = parcomserialpc;
    }


    /**
     * Gets the submascararede value for this Ijtbequipamentos.
     * 
     * @return submascararede
     */
    public java.lang.String getSubmascararede() {
        return submascararede;
    }


    /**
     * Sets the submascararede value for this Ijtbequipamentos.
     * 
     * @param submascararede
     */
    public void setSubmascararede(java.lang.String submascararede) {
        this.submascararede = submascararede;
    }


    /**
     * Gets the tpequipamento value for this Ijtbequipamentos.
     * 
     * @return tpequipamento
     */
    public java.math.BigDecimal getTpequipamento() {
        return tpequipamento;
    }


    /**
     * Sets the tpequipamento value for this Ijtbequipamentos.
     * 
     * @param tpequipamento
     */
    public void setTpequipamento(java.math.BigDecimal tpequipamento) {
        this.tpequipamento = tpequipamento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbequipamentos)) return false;
        Ijtbequipamentos other = (Ijtbequipamentos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.comsoftfab==null && other.getComsoftfab()==null) || 
             (this.comsoftfab!=null &&
              this.comsoftfab.equals(other.getComsoftfab()))) &&
            ((this.dsequipamento==null && other.getDsequipamento()==null) || 
             (this.dsequipamento!=null &&
              this.dsequipamento.equals(other.getDsequipamento()))) &&
            ((this.enderecoip==null && other.getEnderecoip()==null) || 
             (this.enderecoip!=null &&
              this.enderecoip.equals(other.getEnderecoip()))) &&
            ((this.gateway==null && other.getGateway()==null) || 
             (this.gateway!=null &&
              this.gateway.equals(other.getGateway()))) &&
            ((this.idequipamento==null && other.getIdequipamento()==null) || 
             (this.idequipamento!=null &&
              this.idequipamento.equals(other.getIdequipamento()))) &&
            ((this.ijcomequipamentos==null && other.getIjcomequipamentos()==null) || 
             (this.ijcomequipamentos!=null &&
              java.util.Arrays.equals(this.ijcomequipamentos, other.getIjcomequipamentos()))) &&
            ((this.ijcomequipcents==null && other.getIjcomequipcents()==null) || 
             (this.ijcomequipcents!=null &&
              java.util.Arrays.equals(this.ijcomequipcents, other.getIjcomequipcents()))) &&
            ((this.ijtbaleautos==null && other.getIjtbaleautos()==null) || 
             (this.ijtbaleautos!=null &&
              java.util.Arrays.equals(this.ijtbaleautos, other.getIjtbaleautos()))) &&
            ((this.parcomserialpc==null && other.getParcomserialpc()==null) || 
             (this.parcomserialpc!=null &&
              this.parcomserialpc.equals(other.getParcomserialpc()))) &&
            ((this.submascararede==null && other.getSubmascararede()==null) || 
             (this.submascararede!=null &&
              this.submascararede.equals(other.getSubmascararede()))) &&
            ((this.tpequipamento==null && other.getTpequipamento()==null) || 
             (this.tpequipamento!=null &&
              this.tpequipamento.equals(other.getTpequipamento())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getComsoftfab() != null) {
            _hashCode += getComsoftfab().hashCode();
        }
        if (getDsequipamento() != null) {
            _hashCode += getDsequipamento().hashCode();
        }
        if (getEnderecoip() != null) {
            _hashCode += getEnderecoip().hashCode();
        }
        if (getGateway() != null) {
            _hashCode += getGateway().hashCode();
        }
        if (getIdequipamento() != null) {
            _hashCode += getIdequipamento().hashCode();
        }
        if (getIjcomequipamentos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjcomequipamentos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjcomequipamentos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjcomequipcents() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjcomequipcents());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjcomequipcents(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbaleautos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbaleautos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbaleautos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getParcomserialpc() != null) {
            _hashCode += getParcomserialpc().hashCode();
        }
        if (getSubmascararede() != null) {
            _hashCode += getSubmascararede().hashCode();
        }
        if (getTpequipamento() != null) {
            _hashCode += getTpequipamento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbequipamentos.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbequipamentos"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comsoftfab");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comsoftfab"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsequipamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsequipamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enderecoip");
        elemField.setXmlName(new javax.xml.namespace.QName("", "enderecoip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gateway");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gateway"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idequipamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idequipamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcomequipamentos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcomequipamentos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcomequipamento"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcomequipcents");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcomequipcents"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcomequipcent"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbaleautos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbaleautos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbaleauto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parcomserialpc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parcomserialpc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("submascararede");
        elemField.setXmlName(new javax.xml.namespace.QName("", "submascararede"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpequipamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpequipamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
