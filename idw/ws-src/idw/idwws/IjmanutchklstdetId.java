/**
 * IjmanutchklstdetId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjmanutchklstdetId  implements java.io.Serializable {
    private java.lang.String idchklst;

    private double seqitem;

    public IjmanutchklstdetId() {
    }

    public IjmanutchklstdetId(
           java.lang.String idchklst,
           double seqitem) {
           this.idchklst = idchklst;
           this.seqitem = seqitem;
    }


    /**
     * Gets the idchklst value for this IjmanutchklstdetId.
     * 
     * @return idchklst
     */
    public java.lang.String getIdchklst() {
        return idchklst;
    }


    /**
     * Sets the idchklst value for this IjmanutchklstdetId.
     * 
     * @param idchklst
     */
    public void setIdchklst(java.lang.String idchklst) {
        this.idchklst = idchklst;
    }


    /**
     * Gets the seqitem value for this IjmanutchklstdetId.
     * 
     * @return seqitem
     */
    public double getSeqitem() {
        return seqitem;
    }


    /**
     * Sets the seqitem value for this IjmanutchklstdetId.
     * 
     * @param seqitem
     */
    public void setSeqitem(double seqitem) {
        this.seqitem = seqitem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjmanutchklstdetId)) return false;
        IjmanutchklstdetId other = (IjmanutchklstdetId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idchklst==null && other.getIdchklst()==null) || 
             (this.idchklst!=null &&
              this.idchklst.equals(other.getIdchklst()))) &&
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
        if (getIdchklst() != null) {
            _hashCode += getIdchklst().hashCode();
        }
        _hashCode += new Double(getSeqitem()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjmanutchklstdetId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutchklstdetId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idchklst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idchklst"));
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
