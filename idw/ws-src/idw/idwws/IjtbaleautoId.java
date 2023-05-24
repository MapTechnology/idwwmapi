/**
 * IjtbaleautoId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjtbaleautoId  implements java.io.Serializable {
    private java.lang.String cdalertaauto;

    private java.lang.String idequipamento;

    public IjtbaleautoId() {
    }

    public IjtbaleautoId(
           java.lang.String cdalertaauto,
           java.lang.String idequipamento) {
           this.cdalertaauto = cdalertaauto;
           this.idequipamento = idequipamento;
    }


    /**
     * Gets the cdalertaauto value for this IjtbaleautoId.
     * 
     * @return cdalertaauto
     */
    public java.lang.String getCdalertaauto() {
        return cdalertaauto;
    }


    /**
     * Sets the cdalertaauto value for this IjtbaleautoId.
     * 
     * @param cdalertaauto
     */
    public void setCdalertaauto(java.lang.String cdalertaauto) {
        this.cdalertaauto = cdalertaauto;
    }


    /**
     * Gets the idequipamento value for this IjtbaleautoId.
     * 
     * @return idequipamento
     */
    public java.lang.String getIdequipamento() {
        return idequipamento;
    }


    /**
     * Sets the idequipamento value for this IjtbaleautoId.
     * 
     * @param idequipamento
     */
    public void setIdequipamento(java.lang.String idequipamento) {
        this.idequipamento = idequipamento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjtbaleautoId)) return false;
        IjtbaleautoId other = (IjtbaleautoId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdalertaauto==null && other.getCdalertaauto()==null) || 
             (this.cdalertaauto!=null &&
              this.cdalertaauto.equals(other.getCdalertaauto()))) &&
            ((this.idequipamento==null && other.getIdequipamento()==null) || 
             (this.idequipamento!=null &&
              this.idequipamento.equals(other.getIdequipamento())));
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
        if (getCdalertaauto() != null) {
            _hashCode += getCdalertaauto().hashCode();
        }
        if (getIdequipamento() != null) {
            _hashCode += getIdequipamento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjtbaleautoId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbaleautoId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdalertaauto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdalertaauto"));
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
