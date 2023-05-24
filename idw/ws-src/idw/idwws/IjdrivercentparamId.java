/**
 * IjdrivercentparamId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjdrivercentparamId  implements java.io.Serializable {
    private double iddrivercentral;

    private java.math.BigDecimal ordemparametro;

    public IjdrivercentparamId() {
    }

    public IjdrivercentparamId(
           double iddrivercentral,
           java.math.BigDecimal ordemparametro) {
           this.iddrivercentral = iddrivercentral;
           this.ordemparametro = ordemparametro;
    }


    /**
     * Gets the iddrivercentral value for this IjdrivercentparamId.
     * 
     * @return iddrivercentral
     */
    public double getIddrivercentral() {
        return iddrivercentral;
    }


    /**
     * Sets the iddrivercentral value for this IjdrivercentparamId.
     * 
     * @param iddrivercentral
     */
    public void setIddrivercentral(double iddrivercentral) {
        this.iddrivercentral = iddrivercentral;
    }


    /**
     * Gets the ordemparametro value for this IjdrivercentparamId.
     * 
     * @return ordemparametro
     */
    public java.math.BigDecimal getOrdemparametro() {
        return ordemparametro;
    }


    /**
     * Sets the ordemparametro value for this IjdrivercentparamId.
     * 
     * @param ordemparametro
     */
    public void setOrdemparametro(java.math.BigDecimal ordemparametro) {
        this.ordemparametro = ordemparametro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjdrivercentparamId)) return false;
        IjdrivercentparamId other = (IjdrivercentparamId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.iddrivercentral == other.getIddrivercentral() &&
            ((this.ordemparametro==null && other.getOrdemparametro()==null) || 
             (this.ordemparametro!=null &&
              this.ordemparametro.equals(other.getOrdemparametro())));
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
        _hashCode += new Double(getIddrivercentral()).hashCode();
        if (getOrdemparametro() != null) {
            _hashCode += getOrdemparametro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjdrivercentparamId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdrivercentparamId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iddrivercentral");
        elemField.setXmlName(new javax.xml.namespace.QName("", "iddrivercentral"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordemparametro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordemparametro"));
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
