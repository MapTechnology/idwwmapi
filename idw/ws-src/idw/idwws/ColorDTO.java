/**
 * ColorDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ColorDTO  implements java.io.Serializable {
    private int b;

    private int g;

    private int r;

    private int rgb;

    public ColorDTO() {
    }

    public ColorDTO(
           int b,
           int g,
           int r,
           int rgb) {
           this.b = b;
           this.g = g;
           this.r = r;
           this.rgb = rgb;
    }


    /**
     * Gets the b value for this ColorDTO.
     * 
     * @return b
     */
    public int getB() {
        return b;
    }


    /**
     * Sets the b value for this ColorDTO.
     * 
     * @param b
     */
    public void setB(int b) {
        this.b = b;
    }


    /**
     * Gets the g value for this ColorDTO.
     * 
     * @return g
     */
    public int getG() {
        return g;
    }


    /**
     * Sets the g value for this ColorDTO.
     * 
     * @param g
     */
    public void setG(int g) {
        this.g = g;
    }


    /**
     * Gets the r value for this ColorDTO.
     * 
     * @return r
     */
    public int getR() {
        return r;
    }


    /**
     * Sets the r value for this ColorDTO.
     * 
     * @param r
     */
    public void setR(int r) {
        this.r = r;
    }


    /**
     * Gets the rgb value for this ColorDTO.
     * 
     * @return rgb
     */
    public int getRgb() {
        return rgb;
    }


    /**
     * Sets the rgb value for this ColorDTO.
     * 
     * @param rgb
     */
    public void setRgb(int rgb) {
        this.rgb = rgb;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ColorDTO)) return false;
        ColorDTO other = (ColorDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.b == other.getB() &&
            this.g == other.getG() &&
            this.r == other.getR() &&
            this.rgb == other.getRgb();
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
        _hashCode += getB();
        _hashCode += getG();
        _hashCode += getR();
        _hashCode += getRgb();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ColorDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "colorDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("b");
        elemField.setXmlName(new javax.xml.namespace.QName("", "b"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("g");
        elemField.setXmlName(new javax.xml.namespace.QName("", "g"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("r");
        elemField.setXmlName(new javax.xml.namespace.QName("", "r"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rgb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rgb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
