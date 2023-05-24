/**
 * Ijgalobjmtrz.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgalobjmtrz  implements java.io.Serializable {
    private idw.idwws.IjgalobjmtrzId id;

    private idw.idwws.Ijtbgal ijtbgal;

    private idw.idwws.Ijtbinj ijtbinjByCdinjetora;

    private idw.idwws.Ijtbinj ijtbinjByCdposto;

    public Ijgalobjmtrz() {
    }

    public Ijgalobjmtrz(
           idw.idwws.IjgalobjmtrzId id,
           idw.idwws.Ijtbgal ijtbgal,
           idw.idwws.Ijtbinj ijtbinjByCdinjetora,
           idw.idwws.Ijtbinj ijtbinjByCdposto) {
           this.id = id;
           this.ijtbgal = ijtbgal;
           this.ijtbinjByCdinjetora = ijtbinjByCdinjetora;
           this.ijtbinjByCdposto = ijtbinjByCdposto;
    }


    /**
     * Gets the id value for this Ijgalobjmtrz.
     * 
     * @return id
     */
    public idw.idwws.IjgalobjmtrzId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijgalobjmtrz.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjgalobjmtrzId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbgal value for this Ijgalobjmtrz.
     * 
     * @return ijtbgal
     */
    public idw.idwws.Ijtbgal getIjtbgal() {
        return ijtbgal;
    }


    /**
     * Sets the ijtbgal value for this Ijgalobjmtrz.
     * 
     * @param ijtbgal
     */
    public void setIjtbgal(idw.idwws.Ijtbgal ijtbgal) {
        this.ijtbgal = ijtbgal;
    }


    /**
     * Gets the ijtbinjByCdinjetora value for this Ijgalobjmtrz.
     * 
     * @return ijtbinjByCdinjetora
     */
    public idw.idwws.Ijtbinj getIjtbinjByCdinjetora() {
        return ijtbinjByCdinjetora;
    }


    /**
     * Sets the ijtbinjByCdinjetora value for this Ijgalobjmtrz.
     * 
     * @param ijtbinjByCdinjetora
     */
    public void setIjtbinjByCdinjetora(idw.idwws.Ijtbinj ijtbinjByCdinjetora) {
        this.ijtbinjByCdinjetora = ijtbinjByCdinjetora;
    }


    /**
     * Gets the ijtbinjByCdposto value for this Ijgalobjmtrz.
     * 
     * @return ijtbinjByCdposto
     */
    public idw.idwws.Ijtbinj getIjtbinjByCdposto() {
        return ijtbinjByCdposto;
    }


    /**
     * Sets the ijtbinjByCdposto value for this Ijgalobjmtrz.
     * 
     * @param ijtbinjByCdposto
     */
    public void setIjtbinjByCdposto(idw.idwws.Ijtbinj ijtbinjByCdposto) {
        this.ijtbinjByCdposto = ijtbinjByCdposto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgalobjmtrz)) return false;
        Ijgalobjmtrz other = (Ijgalobjmtrz) obj;
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
            ((this.ijtbgal==null && other.getIjtbgal()==null) || 
             (this.ijtbgal!=null &&
              this.ijtbgal.equals(other.getIjtbgal()))) &&
            ((this.ijtbinjByCdinjetora==null && other.getIjtbinjByCdinjetora()==null) || 
             (this.ijtbinjByCdinjetora!=null &&
              this.ijtbinjByCdinjetora.equals(other.getIjtbinjByCdinjetora()))) &&
            ((this.ijtbinjByCdposto==null && other.getIjtbinjByCdposto()==null) || 
             (this.ijtbinjByCdposto!=null &&
              this.ijtbinjByCdposto.equals(other.getIjtbinjByCdposto())));
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
        if (getIjtbgal() != null) {
            _hashCode += getIjtbgal().hashCode();
        }
        if (getIjtbinjByCdinjetora() != null) {
            _hashCode += getIjtbinjByCdinjetora().hashCode();
        }
        if (getIjtbinjByCdposto() != null) {
            _hashCode += getIjtbinjByCdposto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgalobjmtrz.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgalobjmtrz"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgalobjmtrzId"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinjByCdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinjByCdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinjByCdposto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinjByCdposto"));
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
