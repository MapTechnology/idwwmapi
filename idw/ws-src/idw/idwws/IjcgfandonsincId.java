/**
 * IjcgfandonsincId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjcgfandonsincId  implements java.io.Serializable {
    private java.lang.String cdmestre;

    private double ideventoandon;

    public IjcgfandonsincId() {
    }

    public IjcgfandonsincId(
           java.lang.String cdmestre,
           double ideventoandon) {
           this.cdmestre = cdmestre;
           this.ideventoandon = ideventoandon;
    }


    /**
     * Gets the cdmestre value for this IjcgfandonsincId.
     * 
     * @return cdmestre
     */
    public java.lang.String getCdmestre() {
        return cdmestre;
    }


    /**
     * Sets the cdmestre value for this IjcgfandonsincId.
     * 
     * @param cdmestre
     */
    public void setCdmestre(java.lang.String cdmestre) {
        this.cdmestre = cdmestre;
    }


    /**
     * Gets the ideventoandon value for this IjcgfandonsincId.
     * 
     * @return ideventoandon
     */
    public double getIdeventoandon() {
        return ideventoandon;
    }


    /**
     * Sets the ideventoandon value for this IjcgfandonsincId.
     * 
     * @param ideventoandon
     */
    public void setIdeventoandon(double ideventoandon) {
        this.ideventoandon = ideventoandon;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjcgfandonsincId)) return false;
        IjcgfandonsincId other = (IjcgfandonsincId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdmestre==null && other.getCdmestre()==null) || 
             (this.cdmestre!=null &&
              this.cdmestre.equals(other.getCdmestre()))) &&
            this.ideventoandon == other.getIdeventoandon();
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
        if (getCdmestre() != null) {
            _hashCode += getCdmestre().hashCode();
        }
        _hashCode += new Double(getIdeventoandon()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjcgfandonsincId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcgfandonsincId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmestre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmestre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ideventoandon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ideventoandon"));
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
