/**
 * Ijgalobjabcmtrz.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgalobjabcmtrz  implements java.io.Serializable {
    private java.math.BigDecimal coordcoluna;

    private java.math.BigDecimal coordlinha;

    private idw.idwws.IjgalobjabcmtrzId id;

    private idw.idwws.Ijtbgal ijtbgal;

    public Ijgalobjabcmtrz() {
    }

    public Ijgalobjabcmtrz(
           java.math.BigDecimal coordcoluna,
           java.math.BigDecimal coordlinha,
           idw.idwws.IjgalobjabcmtrzId id,
           idw.idwws.Ijtbgal ijtbgal) {
           this.coordcoluna = coordcoluna;
           this.coordlinha = coordlinha;
           this.id = id;
           this.ijtbgal = ijtbgal;
    }


    /**
     * Gets the coordcoluna value for this Ijgalobjabcmtrz.
     * 
     * @return coordcoluna
     */
    public java.math.BigDecimal getCoordcoluna() {
        return coordcoluna;
    }


    /**
     * Sets the coordcoluna value for this Ijgalobjabcmtrz.
     * 
     * @param coordcoluna
     */
    public void setCoordcoluna(java.math.BigDecimal coordcoluna) {
        this.coordcoluna = coordcoluna;
    }


    /**
     * Gets the coordlinha value for this Ijgalobjabcmtrz.
     * 
     * @return coordlinha
     */
    public java.math.BigDecimal getCoordlinha() {
        return coordlinha;
    }


    /**
     * Sets the coordlinha value for this Ijgalobjabcmtrz.
     * 
     * @param coordlinha
     */
    public void setCoordlinha(java.math.BigDecimal coordlinha) {
        this.coordlinha = coordlinha;
    }


    /**
     * Gets the id value for this Ijgalobjabcmtrz.
     * 
     * @return id
     */
    public idw.idwws.IjgalobjabcmtrzId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijgalobjabcmtrz.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjgalobjabcmtrzId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbgal value for this Ijgalobjabcmtrz.
     * 
     * @return ijtbgal
     */
    public idw.idwws.Ijtbgal getIjtbgal() {
        return ijtbgal;
    }


    /**
     * Sets the ijtbgal value for this Ijgalobjabcmtrz.
     * 
     * @param ijtbgal
     */
    public void setIjtbgal(idw.idwws.Ijtbgal ijtbgal) {
        this.ijtbgal = ijtbgal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgalobjabcmtrz)) return false;
        Ijgalobjabcmtrz other = (Ijgalobjabcmtrz) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.coordcoluna==null && other.getCoordcoluna()==null) || 
             (this.coordcoluna!=null &&
              this.coordcoluna.equals(other.getCoordcoluna()))) &&
            ((this.coordlinha==null && other.getCoordlinha()==null) || 
             (this.coordlinha!=null &&
              this.coordlinha.equals(other.getCoordlinha()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijtbgal==null && other.getIjtbgal()==null) || 
             (this.ijtbgal!=null &&
              this.ijtbgal.equals(other.getIjtbgal())));
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
        if (getCoordcoluna() != null) {
            _hashCode += getCoordcoluna().hashCode();
        }
        if (getCoordlinha() != null) {
            _hashCode += getCoordlinha().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjtbgal() != null) {
            _hashCode += getIjtbgal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgalobjabcmtrz.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgalobjabcmtrz"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coordcoluna");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coordcoluna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coordlinha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coordlinha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgalobjabcmtrzId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbgal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbgal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbgal"));
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
