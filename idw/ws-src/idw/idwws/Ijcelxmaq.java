/**
 * Ijcelxmaq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijcelxmaq  implements java.io.Serializable {
    private idw.idwws.IjcelxmaqId id;

    private idw.idwws.Ijcelxestagios ijcelxestagios;

    private idw.idwws.Ijtbinj ijtbinjByCdinjetora;

    private idw.idwws.Ijtbinj ijtbinjByCdmaqdestino;

    public Ijcelxmaq() {
    }

    public Ijcelxmaq(
           idw.idwws.IjcelxmaqId id,
           idw.idwws.Ijcelxestagios ijcelxestagios,
           idw.idwws.Ijtbinj ijtbinjByCdinjetora,
           idw.idwws.Ijtbinj ijtbinjByCdmaqdestino) {
           this.id = id;
           this.ijcelxestagios = ijcelxestagios;
           this.ijtbinjByCdinjetora = ijtbinjByCdinjetora;
           this.ijtbinjByCdmaqdestino = ijtbinjByCdmaqdestino;
    }


    /**
     * Gets the id value for this Ijcelxmaq.
     * 
     * @return id
     */
    public idw.idwws.IjcelxmaqId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijcelxmaq.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjcelxmaqId id) {
        this.id = id;
    }


    /**
     * Gets the ijcelxestagios value for this Ijcelxmaq.
     * 
     * @return ijcelxestagios
     */
    public idw.idwws.Ijcelxestagios getIjcelxestagios() {
        return ijcelxestagios;
    }


    /**
     * Sets the ijcelxestagios value for this Ijcelxmaq.
     * 
     * @param ijcelxestagios
     */
    public void setIjcelxestagios(idw.idwws.Ijcelxestagios ijcelxestagios) {
        this.ijcelxestagios = ijcelxestagios;
    }


    /**
     * Gets the ijtbinjByCdinjetora value for this Ijcelxmaq.
     * 
     * @return ijtbinjByCdinjetora
     */
    public idw.idwws.Ijtbinj getIjtbinjByCdinjetora() {
        return ijtbinjByCdinjetora;
    }


    /**
     * Sets the ijtbinjByCdinjetora value for this Ijcelxmaq.
     * 
     * @param ijtbinjByCdinjetora
     */
    public void setIjtbinjByCdinjetora(idw.idwws.Ijtbinj ijtbinjByCdinjetora) {
        this.ijtbinjByCdinjetora = ijtbinjByCdinjetora;
    }


    /**
     * Gets the ijtbinjByCdmaqdestino value for this Ijcelxmaq.
     * 
     * @return ijtbinjByCdmaqdestino
     */
    public idw.idwws.Ijtbinj getIjtbinjByCdmaqdestino() {
        return ijtbinjByCdmaqdestino;
    }


    /**
     * Sets the ijtbinjByCdmaqdestino value for this Ijcelxmaq.
     * 
     * @param ijtbinjByCdmaqdestino
     */
    public void setIjtbinjByCdmaqdestino(idw.idwws.Ijtbinj ijtbinjByCdmaqdestino) {
        this.ijtbinjByCdmaqdestino = ijtbinjByCdmaqdestino;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijcelxmaq)) return false;
        Ijcelxmaq other = (Ijcelxmaq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijcelxestagios==null && other.getIjcelxestagios()==null) || 
             (this.ijcelxestagios!=null &&
              this.ijcelxestagios.equals(other.getIjcelxestagios()))) &&
            ((this.ijtbinjByCdinjetora==null && other.getIjtbinjByCdinjetora()==null) || 
             (this.ijtbinjByCdinjetora!=null &&
              this.ijtbinjByCdinjetora.equals(other.getIjtbinjByCdinjetora()))) &&
            ((this.ijtbinjByCdmaqdestino==null && other.getIjtbinjByCdmaqdestino()==null) || 
             (this.ijtbinjByCdmaqdestino!=null &&
              this.ijtbinjByCdmaqdestino.equals(other.getIjtbinjByCdmaqdestino())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjcelxestagios() != null) {
            _hashCode += getIjcelxestagios().hashCode();
        }
        if (getIjtbinjByCdinjetora() != null) {
            _hashCode += getIjtbinjByCdinjetora().hashCode();
        }
        if (getIjtbinjByCdmaqdestino() != null) {
            _hashCode += getIjtbinjByCdmaqdestino().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijcelxmaq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcelxmaq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcelxmaqId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcelxestagios");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcelxestagios"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcelxestagios"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinjByCdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinjByCdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinjByCdmaqdestino");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinjByCdmaqdestino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
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
