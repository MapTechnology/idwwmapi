/**
 * Exportacao002Id.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Exportacao002Id  implements java.io.Serializable {
    private java.util.Calendar dthrfinalizacao;

    private java.util.Calendar dthrinicializacao;

    private java.lang.String nrop;

    private org.apache.axis.types.UnsignedShort stexportacao;

    public Exportacao002Id() {
    }

    public Exportacao002Id(
           java.util.Calendar dthrfinalizacao,
           java.util.Calendar dthrinicializacao,
           java.lang.String nrop,
           org.apache.axis.types.UnsignedShort stexportacao) {
           this.dthrfinalizacao = dthrfinalizacao;
           this.dthrinicializacao = dthrinicializacao;
           this.nrop = nrop;
           this.stexportacao = stexportacao;
    }


    /**
     * Gets the dthrfinalizacao value for this Exportacao002Id.
     * 
     * @return dthrfinalizacao
     */
    public java.util.Calendar getDthrfinalizacao() {
        return dthrfinalizacao;
    }


    /**
     * Sets the dthrfinalizacao value for this Exportacao002Id.
     * 
     * @param dthrfinalizacao
     */
    public void setDthrfinalizacao(java.util.Calendar dthrfinalizacao) {
        this.dthrfinalizacao = dthrfinalizacao;
    }


    /**
     * Gets the dthrinicializacao value for this Exportacao002Id.
     * 
     * @return dthrinicializacao
     */
    public java.util.Calendar getDthrinicializacao() {
        return dthrinicializacao;
    }


    /**
     * Sets the dthrinicializacao value for this Exportacao002Id.
     * 
     * @param dthrinicializacao
     */
    public void setDthrinicializacao(java.util.Calendar dthrinicializacao) {
        this.dthrinicializacao = dthrinicializacao;
    }


    /**
     * Gets the nrop value for this Exportacao002Id.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this Exportacao002Id.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }


    /**
     * Gets the stexportacao value for this Exportacao002Id.
     * 
     * @return stexportacao
     */
    public org.apache.axis.types.UnsignedShort getStexportacao() {
        return stexportacao;
    }


    /**
     * Sets the stexportacao value for this Exportacao002Id.
     * 
     * @param stexportacao
     */
    public void setStexportacao(org.apache.axis.types.UnsignedShort stexportacao) {
        this.stexportacao = stexportacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Exportacao002Id)) return false;
        Exportacao002Id other = (Exportacao002Id) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrfinalizacao==null && other.getDthrfinalizacao()==null) || 
             (this.dthrfinalizacao!=null &&
              this.dthrfinalizacao.equals(other.getDthrfinalizacao()))) &&
            ((this.dthrinicializacao==null && other.getDthrinicializacao()==null) || 
             (this.dthrinicializacao!=null &&
              this.dthrinicializacao.equals(other.getDthrinicializacao()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop()))) &&
            ((this.stexportacao==null && other.getStexportacao()==null) || 
             (this.stexportacao!=null &&
              this.stexportacao.equals(other.getStexportacao())));
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
        if (getDthrfinalizacao() != null) {
            _hashCode += getDthrfinalizacao().hashCode();
        }
        if (getDthrinicializacao() != null) {
            _hashCode += getDthrinicializacao().hashCode();
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        if (getStexportacao() != null) {
            _hashCode += getStexportacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Exportacao002Id.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "exportacao002Id"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfinalizacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfinalizacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrinicializacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrinicializacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stexportacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stexportacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
