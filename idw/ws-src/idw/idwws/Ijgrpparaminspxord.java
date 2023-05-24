/**
 * Ijgrpparaminspxord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrpparaminspxord  implements java.io.Serializable {
    private idw.idwws.IjgrpparaminspxordId id;

    private idw.idwws.Ijgrpparaminsp ijgrpparaminsp;

    private idw.idwws.Ijparaminspec ijparaminspec;

    private java.math.BigDecimal ordemedicao;

    public Ijgrpparaminspxord() {
    }

    public Ijgrpparaminspxord(
           idw.idwws.IjgrpparaminspxordId id,
           idw.idwws.Ijgrpparaminsp ijgrpparaminsp,
           idw.idwws.Ijparaminspec ijparaminspec,
           java.math.BigDecimal ordemedicao) {
           this.id = id;
           this.ijgrpparaminsp = ijgrpparaminsp;
           this.ijparaminspec = ijparaminspec;
           this.ordemedicao = ordemedicao;
    }


    /**
     * Gets the id value for this Ijgrpparaminspxord.
     * 
     * @return id
     */
    public idw.idwws.IjgrpparaminspxordId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijgrpparaminspxord.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjgrpparaminspxordId id) {
        this.id = id;
    }


    /**
     * Gets the ijgrpparaminsp value for this Ijgrpparaminspxord.
     * 
     * @return ijgrpparaminsp
     */
    public idw.idwws.Ijgrpparaminsp getIjgrpparaminsp() {
        return ijgrpparaminsp;
    }


    /**
     * Sets the ijgrpparaminsp value for this Ijgrpparaminspxord.
     * 
     * @param ijgrpparaminsp
     */
    public void setIjgrpparaminsp(idw.idwws.Ijgrpparaminsp ijgrpparaminsp) {
        this.ijgrpparaminsp = ijgrpparaminsp;
    }


    /**
     * Gets the ijparaminspec value for this Ijgrpparaminspxord.
     * 
     * @return ijparaminspec
     */
    public idw.idwws.Ijparaminspec getIjparaminspec() {
        return ijparaminspec;
    }


    /**
     * Sets the ijparaminspec value for this Ijgrpparaminspxord.
     * 
     * @param ijparaminspec
     */
    public void setIjparaminspec(idw.idwws.Ijparaminspec ijparaminspec) {
        this.ijparaminspec = ijparaminspec;
    }


    /**
     * Gets the ordemedicao value for this Ijgrpparaminspxord.
     * 
     * @return ordemedicao
     */
    public java.math.BigDecimal getOrdemedicao() {
        return ordemedicao;
    }


    /**
     * Sets the ordemedicao value for this Ijgrpparaminspxord.
     * 
     * @param ordemedicao
     */
    public void setOrdemedicao(java.math.BigDecimal ordemedicao) {
        this.ordemedicao = ordemedicao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrpparaminspxord)) return false;
        Ijgrpparaminspxord other = (Ijgrpparaminspxord) obj;
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
            ((this.ijgrpparaminsp==null && other.getIjgrpparaminsp()==null) || 
             (this.ijgrpparaminsp!=null &&
              this.ijgrpparaminsp.equals(other.getIjgrpparaminsp()))) &&
            ((this.ijparaminspec==null && other.getIjparaminspec()==null) || 
             (this.ijparaminspec!=null &&
              this.ijparaminspec.equals(other.getIjparaminspec()))) &&
            ((this.ordemedicao==null && other.getOrdemedicao()==null) || 
             (this.ordemedicao!=null &&
              this.ordemedicao.equals(other.getOrdemedicao())));
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
        if (getIjgrpparaminsp() != null) {
            _hashCode += getIjgrpparaminsp().hashCode();
        }
        if (getIjparaminspec() != null) {
            _hashCode += getIjparaminspec().hashCode();
        }
        if (getOrdemedicao() != null) {
            _hashCode += getOrdemedicao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgrpparaminspxord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpparaminspxord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpparaminspxordId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpparaminsp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpparaminsp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpparaminsp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijparaminspec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijparaminspec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparaminspec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordemedicao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordemedicao"));
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
