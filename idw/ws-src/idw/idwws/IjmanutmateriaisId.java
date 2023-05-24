/**
 * IjmanutmateriaisId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjmanutmateriaisId  implements java.io.Serializable {
    private double idregistro;

    private java.lang.String nros;

    public IjmanutmateriaisId() {
    }

    public IjmanutmateriaisId(
           double idregistro,
           java.lang.String nros) {
           this.idregistro = idregistro;
           this.nros = nros;
    }


    /**
     * Gets the idregistro value for this IjmanutmateriaisId.
     * 
     * @return idregistro
     */
    public double getIdregistro() {
        return idregistro;
    }


    /**
     * Sets the idregistro value for this IjmanutmateriaisId.
     * 
     * @param idregistro
     */
    public void setIdregistro(double idregistro) {
        this.idregistro = idregistro;
    }


    /**
     * Gets the nros value for this IjmanutmateriaisId.
     * 
     * @return nros
     */
    public java.lang.String getNros() {
        return nros;
    }


    /**
     * Sets the nros value for this IjmanutmateriaisId.
     * 
     * @param nros
     */
    public void setNros(java.lang.String nros) {
        this.nros = nros;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjmanutmateriaisId)) return false;
        IjmanutmateriaisId other = (IjmanutmateriaisId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idregistro == other.getIdregistro() &&
            ((this.nros==null && other.getNros()==null) || 
             (this.nros!=null &&
              this.nros.equals(other.getNros())));
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
        _hashCode += new Double(getIdregistro()).hashCode();
        if (getNros() != null) {
            _hashCode += getNros().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjmanutmateriaisId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutmateriaisId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idregistro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idregistro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nros"));
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
