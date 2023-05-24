/**
 * Ijopbloqdet.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijopbloqdet  implements java.io.Serializable {
    private java.util.Calendar dthrdesbloqueio;

    private idw.idwws.IjopbloqdetId id;

    private idw.idwws.Ijopbloq ijopbloq;

    private idw.idwws.Ijtbusu ijtbusu;

    private java.lang.String observacao;

    public Ijopbloqdet() {
    }

    public Ijopbloqdet(
           java.util.Calendar dthrdesbloqueio,
           idw.idwws.IjopbloqdetId id,
           idw.idwws.Ijopbloq ijopbloq,
           idw.idwws.Ijtbusu ijtbusu,
           java.lang.String observacao) {
           this.dthrdesbloqueio = dthrdesbloqueio;
           this.id = id;
           this.ijopbloq = ijopbloq;
           this.ijtbusu = ijtbusu;
           this.observacao = observacao;
    }


    /**
     * Gets the dthrdesbloqueio value for this Ijopbloqdet.
     * 
     * @return dthrdesbloqueio
     */
    public java.util.Calendar getDthrdesbloqueio() {
        return dthrdesbloqueio;
    }


    /**
     * Sets the dthrdesbloqueio value for this Ijopbloqdet.
     * 
     * @param dthrdesbloqueio
     */
    public void setDthrdesbloqueio(java.util.Calendar dthrdesbloqueio) {
        this.dthrdesbloqueio = dthrdesbloqueio;
    }


    /**
     * Gets the id value for this Ijopbloqdet.
     * 
     * @return id
     */
    public idw.idwws.IjopbloqdetId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijopbloqdet.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjopbloqdetId id) {
        this.id = id;
    }


    /**
     * Gets the ijopbloq value for this Ijopbloqdet.
     * 
     * @return ijopbloq
     */
    public idw.idwws.Ijopbloq getIjopbloq() {
        return ijopbloq;
    }


    /**
     * Sets the ijopbloq value for this Ijopbloqdet.
     * 
     * @param ijopbloq
     */
    public void setIjopbloq(idw.idwws.Ijopbloq ijopbloq) {
        this.ijopbloq = ijopbloq;
    }


    /**
     * Gets the ijtbusu value for this Ijopbloqdet.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijopbloqdet.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the observacao value for this Ijopbloqdet.
     * 
     * @return observacao
     */
    public java.lang.String getObservacao() {
        return observacao;
    }


    /**
     * Sets the observacao value for this Ijopbloqdet.
     * 
     * @param observacao
     */
    public void setObservacao(java.lang.String observacao) {
        this.observacao = observacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijopbloqdet)) return false;
        Ijopbloqdet other = (Ijopbloqdet) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrdesbloqueio==null && other.getDthrdesbloqueio()==null) || 
             (this.dthrdesbloqueio!=null &&
              this.dthrdesbloqueio.equals(other.getDthrdesbloqueio()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijopbloq==null && other.getIjopbloq()==null) || 
             (this.ijopbloq!=null &&
              this.ijopbloq.equals(other.getIjopbloq()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu()))) &&
            ((this.observacao==null && other.getObservacao()==null) || 
             (this.observacao!=null &&
              this.observacao.equals(other.getObservacao())));
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
        if (getDthrdesbloqueio() != null) {
            _hashCode += getDthrdesbloqueio().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjopbloq() != null) {
            _hashCode += getIjopbloq().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        if (getObservacao() != null) {
            _hashCode += getObservacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijopbloqdet.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopbloqdet"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrdesbloqueio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrdesbloqueio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopbloqdetId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopbloq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopbloq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopbloq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("observacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "observacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
