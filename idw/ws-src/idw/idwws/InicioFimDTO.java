/**
 * InicioFimDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class InicioFimDTO  implements java.io.Serializable {
    private java.util.Calendar fim;

    private java.util.Calendar inicio;

    public InicioFimDTO() {
    }

    public InicioFimDTO(
           java.util.Calendar fim,
           java.util.Calendar inicio) {
           this.fim = fim;
           this.inicio = inicio;
    }


    /**
     * Gets the fim value for this InicioFimDTO.
     * 
     * @return fim
     */
    public java.util.Calendar getFim() {
        return fim;
    }


    /**
     * Sets the fim value for this InicioFimDTO.
     * 
     * @param fim
     */
    public void setFim(java.util.Calendar fim) {
        this.fim = fim;
    }


    /**
     * Gets the inicio value for this InicioFimDTO.
     * 
     * @return inicio
     */
    public java.util.Calendar getInicio() {
        return inicio;
    }


    /**
     * Sets the inicio value for this InicioFimDTO.
     * 
     * @param inicio
     */
    public void setInicio(java.util.Calendar inicio) {
        this.inicio = inicio;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InicioFimDTO)) return false;
        InicioFimDTO other = (InicioFimDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fim==null && other.getFim()==null) || 
             (this.fim!=null &&
              this.fim.equals(other.getFim()))) &&
            ((this.inicio==null && other.getInicio()==null) || 
             (this.inicio!=null &&
              this.inicio.equals(other.getInicio())));
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
        if (getFim() != null) {
            _hashCode += getFim().hashCode();
        }
        if (getInicio() != null) {
            _hashCode += getInicio().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InicioFimDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "inicioFimDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
