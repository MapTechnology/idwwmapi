/**
 * IjcfgandmaqevtargId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjcfgandmaqevtargId  implements java.io.Serializable {
    private double ideventoandon;

    private java.math.BigDecimal ordemcondicao;

    public IjcfgandmaqevtargId() {
    }

    public IjcfgandmaqevtargId(
           double ideventoandon,
           java.math.BigDecimal ordemcondicao) {
           this.ideventoandon = ideventoandon;
           this.ordemcondicao = ordemcondicao;
    }


    /**
     * Gets the ideventoandon value for this IjcfgandmaqevtargId.
     * 
     * @return ideventoandon
     */
    public double getIdeventoandon() {
        return ideventoandon;
    }


    /**
     * Sets the ideventoandon value for this IjcfgandmaqevtargId.
     * 
     * @param ideventoandon
     */
    public void setIdeventoandon(double ideventoandon) {
        this.ideventoandon = ideventoandon;
    }


    /**
     * Gets the ordemcondicao value for this IjcfgandmaqevtargId.
     * 
     * @return ordemcondicao
     */
    public java.math.BigDecimal getOrdemcondicao() {
        return ordemcondicao;
    }


    /**
     * Sets the ordemcondicao value for this IjcfgandmaqevtargId.
     * 
     * @param ordemcondicao
     */
    public void setOrdemcondicao(java.math.BigDecimal ordemcondicao) {
        this.ordemcondicao = ordemcondicao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjcfgandmaqevtargId)) return false;
        IjcfgandmaqevtargId other = (IjcfgandmaqevtargId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ideventoandon == other.getIdeventoandon() &&
            ((this.ordemcondicao==null && other.getOrdemcondicao()==null) || 
             (this.ordemcondicao!=null &&
              this.ordemcondicao.equals(other.getOrdemcondicao())));
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
        _hashCode += new Double(getIdeventoandon()).hashCode();
        if (getOrdemcondicao() != null) {
            _hashCode += getOrdemcondicao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjcfgandmaqevtargId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcfgandmaqevtargId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ideventoandon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ideventoandon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordemcondicao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordemcondicao"));
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
