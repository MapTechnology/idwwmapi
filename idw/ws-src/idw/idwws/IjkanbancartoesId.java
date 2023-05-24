/**
 * IjkanbancartoesId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjkanbancartoesId  implements java.io.Serializable {
    private java.lang.String idcartaokanban;

    private java.lang.String nrlotekanban;

    public IjkanbancartoesId() {
    }

    public IjkanbancartoesId(
           java.lang.String idcartaokanban,
           java.lang.String nrlotekanban) {
           this.idcartaokanban = idcartaokanban;
           this.nrlotekanban = nrlotekanban;
    }


    /**
     * Gets the idcartaokanban value for this IjkanbancartoesId.
     * 
     * @return idcartaokanban
     */
    public java.lang.String getIdcartaokanban() {
        return idcartaokanban;
    }


    /**
     * Sets the idcartaokanban value for this IjkanbancartoesId.
     * 
     * @param idcartaokanban
     */
    public void setIdcartaokanban(java.lang.String idcartaokanban) {
        this.idcartaokanban = idcartaokanban;
    }


    /**
     * Gets the nrlotekanban value for this IjkanbancartoesId.
     * 
     * @return nrlotekanban
     */
    public java.lang.String getNrlotekanban() {
        return nrlotekanban;
    }


    /**
     * Sets the nrlotekanban value for this IjkanbancartoesId.
     * 
     * @param nrlotekanban
     */
    public void setNrlotekanban(java.lang.String nrlotekanban) {
        this.nrlotekanban = nrlotekanban;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjkanbancartoesId)) return false;
        IjkanbancartoesId other = (IjkanbancartoesId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idcartaokanban==null && other.getIdcartaokanban()==null) || 
             (this.idcartaokanban!=null &&
              this.idcartaokanban.equals(other.getIdcartaokanban()))) &&
            ((this.nrlotekanban==null && other.getNrlotekanban()==null) || 
             (this.nrlotekanban!=null &&
              this.nrlotekanban.equals(other.getNrlotekanban())));
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
        if (getIdcartaokanban() != null) {
            _hashCode += getIdcartaokanban().hashCode();
        }
        if (getNrlotekanban() != null) {
            _hashCode += getNrlotekanban().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjkanbancartoesId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbancartoesId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idcartaokanban");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idcartaokanban"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrlotekanban");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrlotekanban"));
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
