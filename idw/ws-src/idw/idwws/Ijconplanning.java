/**
 * Ijconplanning.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijconplanning  implements java.io.Serializable {
    private java.lang.String cdusuario;

    private idw.idwws.Ijtbusu ijtbusu;

    private org.apache.axis.types.UnsignedShort legendacoresgantt;

    private org.apache.axis.types.UnsignedShort zoomgantt;

    public Ijconplanning() {
    }

    public Ijconplanning(
           java.lang.String cdusuario,
           idw.idwws.Ijtbusu ijtbusu,
           org.apache.axis.types.UnsignedShort legendacoresgantt,
           org.apache.axis.types.UnsignedShort zoomgantt) {
           this.cdusuario = cdusuario;
           this.ijtbusu = ijtbusu;
           this.legendacoresgantt = legendacoresgantt;
           this.zoomgantt = zoomgantt;
    }


    /**
     * Gets the cdusuario value for this Ijconplanning.
     * 
     * @return cdusuario
     */
    public java.lang.String getCdusuario() {
        return cdusuario;
    }


    /**
     * Sets the cdusuario value for this Ijconplanning.
     * 
     * @param cdusuario
     */
    public void setCdusuario(java.lang.String cdusuario) {
        this.cdusuario = cdusuario;
    }


    /**
     * Gets the ijtbusu value for this Ijconplanning.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijconplanning.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the legendacoresgantt value for this Ijconplanning.
     * 
     * @return legendacoresgantt
     */
    public org.apache.axis.types.UnsignedShort getLegendacoresgantt() {
        return legendacoresgantt;
    }


    /**
     * Sets the legendacoresgantt value for this Ijconplanning.
     * 
     * @param legendacoresgantt
     */
    public void setLegendacoresgantt(org.apache.axis.types.UnsignedShort legendacoresgantt) {
        this.legendacoresgantt = legendacoresgantt;
    }


    /**
     * Gets the zoomgantt value for this Ijconplanning.
     * 
     * @return zoomgantt
     */
    public org.apache.axis.types.UnsignedShort getZoomgantt() {
        return zoomgantt;
    }


    /**
     * Sets the zoomgantt value for this Ijconplanning.
     * 
     * @param zoomgantt
     */
    public void setZoomgantt(org.apache.axis.types.UnsignedShort zoomgantt) {
        this.zoomgantt = zoomgantt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijconplanning)) return false;
        Ijconplanning other = (Ijconplanning) obj;
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
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu()))) &&
            ((this.legendacoresgantt==null && other.getLegendacoresgantt()==null) || 
             (this.legendacoresgantt!=null &&
              this.legendacoresgantt.equals(other.getLegendacoresgantt()))) &&
            ((this.zoomgantt==null && other.getZoomgantt()==null) || 
             (this.zoomgantt!=null &&
              this.zoomgantt.equals(other.getZoomgantt())));
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
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        if (getLegendacoresgantt() != null) {
            _hashCode += getLegendacoresgantt().hashCode();
        }
        if (getZoomgantt() != null) {
            _hashCode += getZoomgantt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijconplanning.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijconplanning"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdusuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdusuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("legendacoresgantt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "legendacoresgantt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zoomgantt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "zoomgantt"));
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
