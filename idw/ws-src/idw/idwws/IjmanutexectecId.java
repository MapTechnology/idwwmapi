/**
 * IjmanutexectecId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjmanutexectecId  implements java.io.Serializable {
    private java.lang.String cdusuario;

    private java.lang.String nros;

    private double seqitem;

    public IjmanutexectecId() {
    }

    public IjmanutexectecId(
           java.lang.String cdusuario,
           java.lang.String nros,
           double seqitem) {
           this.cdusuario = cdusuario;
           this.nros = nros;
           this.seqitem = seqitem;
    }


    /**
     * Gets the cdusuario value for this IjmanutexectecId.
     * 
     * @return cdusuario
     */
    public java.lang.String getCdusuario() {
        return cdusuario;
    }


    /**
     * Sets the cdusuario value for this IjmanutexectecId.
     * 
     * @param cdusuario
     */
    public void setCdusuario(java.lang.String cdusuario) {
        this.cdusuario = cdusuario;
    }


    /**
     * Gets the nros value for this IjmanutexectecId.
     * 
     * @return nros
     */
    public java.lang.String getNros() {
        return nros;
    }


    /**
     * Sets the nros value for this IjmanutexectecId.
     * 
     * @param nros
     */
    public void setNros(java.lang.String nros) {
        this.nros = nros;
    }


    /**
     * Gets the seqitem value for this IjmanutexectecId.
     * 
     * @return seqitem
     */
    public double getSeqitem() {
        return seqitem;
    }


    /**
     * Sets the seqitem value for this IjmanutexectecId.
     * 
     * @param seqitem
     */
    public void setSeqitem(double seqitem) {
        this.seqitem = seqitem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjmanutexectecId)) return false;
        IjmanutexectecId other = (IjmanutexectecId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdusuario==null && other.getCdusuario()==null) || 
             (this.cdusuario!=null &&
              this.cdusuario.equals(other.getCdusuario()))) &&
            ((this.nros==null && other.getNros()==null) || 
             (this.nros!=null &&
              this.nros.equals(other.getNros()))) &&
            this.seqitem == other.getSeqitem();
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
        if (getCdusuario() != null) {
            _hashCode += getCdusuario().hashCode();
        }
        if (getNros() != null) {
            _hashCode += getNros().hashCode();
        }
        _hashCode += new Double(getSeqitem()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjmanutexectecId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutexectecId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdusuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdusuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seqitem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "seqitem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
