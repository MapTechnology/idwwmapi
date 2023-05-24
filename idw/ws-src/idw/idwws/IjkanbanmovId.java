/**
 * IjkanbanmovId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjkanbanmovId  implements java.io.Serializable {
    private java.util.Calendar dthrmovimentacao;

    private java.lang.String idcartaokanban;

    public IjkanbanmovId() {
    }

    public IjkanbanmovId(
           java.util.Calendar dthrmovimentacao,
           java.lang.String idcartaokanban) {
           this.dthrmovimentacao = dthrmovimentacao;
           this.idcartaokanban = idcartaokanban;
    }


    /**
     * Gets the dthrmovimentacao value for this IjkanbanmovId.
     * 
     * @return dthrmovimentacao
     */
    public java.util.Calendar getDthrmovimentacao() {
        return dthrmovimentacao;
    }


    /**
     * Sets the dthrmovimentacao value for this IjkanbanmovId.
     * 
     * @param dthrmovimentacao
     */
    public void setDthrmovimentacao(java.util.Calendar dthrmovimentacao) {
        this.dthrmovimentacao = dthrmovimentacao;
    }


    /**
     * Gets the idcartaokanban value for this IjkanbanmovId.
     * 
     * @return idcartaokanban
     */
    public java.lang.String getIdcartaokanban() {
        return idcartaokanban;
    }


    /**
     * Sets the idcartaokanban value for this IjkanbanmovId.
     * 
     * @param idcartaokanban
     */
    public void setIdcartaokanban(java.lang.String idcartaokanban) {
        this.idcartaokanban = idcartaokanban;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjkanbanmovId)) return false;
        IjkanbanmovId other = (IjkanbanmovId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrmovimentacao==null && other.getDthrmovimentacao()==null) || 
             (this.dthrmovimentacao!=null &&
              this.dthrmovimentacao.equals(other.getDthrmovimentacao()))) &&
            ((this.idcartaokanban==null && other.getIdcartaokanban()==null) || 
             (this.idcartaokanban!=null &&
              this.idcartaokanban.equals(other.getIdcartaokanban())));
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
        if (getDthrmovimentacao() != null) {
            _hashCode += getDthrmovimentacao().hashCode();
        }
        if (getIdcartaokanban() != null) {
            _hashCode += getIdcartaokanban().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjkanbanmovId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanmovId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrmovimentacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrmovimentacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idcartaokanban");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idcartaokanban"));
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
