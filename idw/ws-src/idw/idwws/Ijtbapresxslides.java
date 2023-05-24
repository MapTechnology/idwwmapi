/**
 * Ijtbapresxslides.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbapresxslides  implements java.io.Serializable {
    private java.math.BigDecimal duracao;

    private idw.idwws.IjtbapresxslidesId id;

    private idw.idwws.Ijtbapresentacao ijtbapresentacao;

    private idw.idwws.Ijtbslides ijtbslides;

    public Ijtbapresxslides() {
    }

    public Ijtbapresxslides(
           java.math.BigDecimal duracao,
           idw.idwws.IjtbapresxslidesId id,
           idw.idwws.Ijtbapresentacao ijtbapresentacao,
           idw.idwws.Ijtbslides ijtbslides) {
           this.duracao = duracao;
           this.id = id;
           this.ijtbapresentacao = ijtbapresentacao;
           this.ijtbslides = ijtbslides;
    }


    /**
     * Gets the duracao value for this Ijtbapresxslides.
     * 
     * @return duracao
     */
    public java.math.BigDecimal getDuracao() {
        return duracao;
    }


    /**
     * Sets the duracao value for this Ijtbapresxslides.
     * 
     * @param duracao
     */
    public void setDuracao(java.math.BigDecimal duracao) {
        this.duracao = duracao;
    }


    /**
     * Gets the id value for this Ijtbapresxslides.
     * 
     * @return id
     */
    public idw.idwws.IjtbapresxslidesId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijtbapresxslides.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjtbapresxslidesId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbapresentacao value for this Ijtbapresxslides.
     * 
     * @return ijtbapresentacao
     */
    public idw.idwws.Ijtbapresentacao getIjtbapresentacao() {
        return ijtbapresentacao;
    }


    /**
     * Sets the ijtbapresentacao value for this Ijtbapresxslides.
     * 
     * @param ijtbapresentacao
     */
    public void setIjtbapresentacao(idw.idwws.Ijtbapresentacao ijtbapresentacao) {
        this.ijtbapresentacao = ijtbapresentacao;
    }


    /**
     * Gets the ijtbslides value for this Ijtbapresxslides.
     * 
     * @return ijtbslides
     */
    public idw.idwws.Ijtbslides getIjtbslides() {
        return ijtbslides;
    }


    /**
     * Sets the ijtbslides value for this Ijtbapresxslides.
     * 
     * @param ijtbslides
     */
    public void setIjtbslides(idw.idwws.Ijtbslides ijtbslides) {
        this.ijtbslides = ijtbslides;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbapresxslides)) return false;
        Ijtbapresxslides other = (Ijtbapresxslides) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.duracao==null && other.getDuracao()==null) || 
             (this.duracao!=null &&
              this.duracao.equals(other.getDuracao()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijtbapresentacao==null && other.getIjtbapresentacao()==null) || 
             (this.ijtbapresentacao!=null &&
              this.ijtbapresentacao.equals(other.getIjtbapresentacao()))) &&
            ((this.ijtbslides==null && other.getIjtbslides()==null) || 
             (this.ijtbslides!=null &&
              this.ijtbslides.equals(other.getIjtbslides())));
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
        if (getDuracao() != null) {
            _hashCode += getDuracao().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjtbapresentacao() != null) {
            _hashCode += getIjtbapresentacao().hashCode();
        }
        if (getIjtbslides() != null) {
            _hashCode += getIjtbslides().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbapresxslides.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbapresxslides"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duracao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "duracao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbapresxslidesId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbapresentacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbapresentacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbapresentacao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbslides");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbslides"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbslides"));
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
