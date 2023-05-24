/**
 * IjgalobjgalmtrzId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjgalobjgalmtrzId  implements java.io.Serializable {
    private java.lang.String cdgalpao;

    private java.lang.String cdgalpaoobj;

    public IjgalobjgalmtrzId() {
    }

    public IjgalobjgalmtrzId(
           java.lang.String cdgalpao,
           java.lang.String cdgalpaoobj) {
           this.cdgalpao = cdgalpao;
           this.cdgalpaoobj = cdgalpaoobj;
    }


    /**
     * Gets the cdgalpao value for this IjgalobjgalmtrzId.
     * 
     * @return cdgalpao
     */
    public java.lang.String getCdgalpao() {
        return cdgalpao;
    }


    /**
     * Sets the cdgalpao value for this IjgalobjgalmtrzId.
     * 
     * @param cdgalpao
     */
    public void setCdgalpao(java.lang.String cdgalpao) {
        this.cdgalpao = cdgalpao;
    }


    /**
     * Gets the cdgalpaoobj value for this IjgalobjgalmtrzId.
     * 
     * @return cdgalpaoobj
     */
    public java.lang.String getCdgalpaoobj() {
        return cdgalpaoobj;
    }


    /**
     * Sets the cdgalpaoobj value for this IjgalobjgalmtrzId.
     * 
     * @param cdgalpaoobj
     */
    public void setCdgalpaoobj(java.lang.String cdgalpaoobj) {
        this.cdgalpaoobj = cdgalpaoobj;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjgalobjgalmtrzId)) return false;
        IjgalobjgalmtrzId other = (IjgalobjgalmtrzId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgalpao==null && other.getCdgalpao()==null) || 
             (this.cdgalpao!=null &&
              this.cdgalpao.equals(other.getCdgalpao()))) &&
            ((this.cdgalpaoobj==null && other.getCdgalpaoobj()==null) || 
             (this.cdgalpaoobj!=null &&
              this.cdgalpaoobj.equals(other.getCdgalpaoobj())));
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
        if (getCdgalpao() != null) {
            _hashCode += getCdgalpao().hashCode();
        }
        if (getCdgalpaoobj() != null) {
            _hashCode += getCdgalpaoobj().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjgalobjgalmtrzId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgalobjgalmtrzId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgalpao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgalpao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgalpaoobj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgalpaoobj"));
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
