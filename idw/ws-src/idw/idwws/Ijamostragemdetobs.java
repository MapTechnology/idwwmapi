/**
 * Ijamostragemdetobs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijamostragemdetobs  implements java.io.Serializable {
    private idw.idwws.IjamostragemdetobsId id;

    private idw.idwws.Ijamostragemdet ijamostragemdet;

    private java.lang.String observacao;

    public Ijamostragemdetobs() {
    }

    public Ijamostragemdetobs(
           idw.idwws.IjamostragemdetobsId id,
           idw.idwws.Ijamostragemdet ijamostragemdet,
           java.lang.String observacao) {
           this.id = id;
           this.ijamostragemdet = ijamostragemdet;
           this.observacao = observacao;
    }


    /**
     * Gets the id value for this Ijamostragemdetobs.
     * 
     * @return id
     */
    public idw.idwws.IjamostragemdetobsId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijamostragemdetobs.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjamostragemdetobsId id) {
        this.id = id;
    }


    /**
     * Gets the ijamostragemdet value for this Ijamostragemdetobs.
     * 
     * @return ijamostragemdet
     */
    public idw.idwws.Ijamostragemdet getIjamostragemdet() {
        return ijamostragemdet;
    }


    /**
     * Sets the ijamostragemdet value for this Ijamostragemdetobs.
     * 
     * @param ijamostragemdet
     */
    public void setIjamostragemdet(idw.idwws.Ijamostragemdet ijamostragemdet) {
        this.ijamostragemdet = ijamostragemdet;
    }


    /**
     * Gets the observacao value for this Ijamostragemdetobs.
     * 
     * @return observacao
     */
    public java.lang.String getObservacao() {
        return observacao;
    }


    /**
     * Sets the observacao value for this Ijamostragemdetobs.
     * 
     * @param observacao
     */
    public void setObservacao(java.lang.String observacao) {
        this.observacao = observacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijamostragemdetobs)) return false;
        Ijamostragemdetobs other = (Ijamostragemdetobs) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijamostragemdet==null && other.getIjamostragemdet()==null) || 
             (this.ijamostragemdet!=null &&
              this.ijamostragemdet.equals(other.getIjamostragemdet()))) &&
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjamostragemdet() != null) {
            _hashCode += getIjamostragemdet().hashCode();
        }
        if (getObservacao() != null) {
            _hashCode += getObservacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijamostragemdetobs.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamostragemdetobs"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamostragemdetobsId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamostragemdet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamostragemdet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamostragemdet"));
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
