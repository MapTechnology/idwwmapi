/**
 * Ijtbgrids.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbgrids  implements java.io.Serializable {
    private java.lang.String headercol;

    private idw.idwws.IjtbgridsId id;

    private idw.idwws.Ijlinguas ijlinguas;

    private java.math.BigDecimal tamcolgrid;

    public Ijtbgrids() {
    }

    public Ijtbgrids(
           java.lang.String headercol,
           idw.idwws.IjtbgridsId id,
           idw.idwws.Ijlinguas ijlinguas,
           java.math.BigDecimal tamcolgrid) {
           this.headercol = headercol;
           this.id = id;
           this.ijlinguas = ijlinguas;
           this.tamcolgrid = tamcolgrid;
    }


    /**
     * Gets the headercol value for this Ijtbgrids.
     * 
     * @return headercol
     */
    public java.lang.String getHeadercol() {
        return headercol;
    }


    /**
     * Sets the headercol value for this Ijtbgrids.
     * 
     * @param headercol
     */
    public void setHeadercol(java.lang.String headercol) {
        this.headercol = headercol;
    }


    /**
     * Gets the id value for this Ijtbgrids.
     * 
     * @return id
     */
    public idw.idwws.IjtbgridsId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijtbgrids.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjtbgridsId id) {
        this.id = id;
    }


    /**
     * Gets the ijlinguas value for this Ijtbgrids.
     * 
     * @return ijlinguas
     */
    public idw.idwws.Ijlinguas getIjlinguas() {
        return ijlinguas;
    }


    /**
     * Sets the ijlinguas value for this Ijtbgrids.
     * 
     * @param ijlinguas
     */
    public void setIjlinguas(idw.idwws.Ijlinguas ijlinguas) {
        this.ijlinguas = ijlinguas;
    }


    /**
     * Gets the tamcolgrid value for this Ijtbgrids.
     * 
     * @return tamcolgrid
     */
    public java.math.BigDecimal getTamcolgrid() {
        return tamcolgrid;
    }


    /**
     * Sets the tamcolgrid value for this Ijtbgrids.
     * 
     * @param tamcolgrid
     */
    public void setTamcolgrid(java.math.BigDecimal tamcolgrid) {
        this.tamcolgrid = tamcolgrid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbgrids)) return false;
        Ijtbgrids other = (Ijtbgrids) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.headercol==null && other.getHeadercol()==null) || 
             (this.headercol!=null &&
              this.headercol.equals(other.getHeadercol()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijlinguas==null && other.getIjlinguas()==null) || 
             (this.ijlinguas!=null &&
              this.ijlinguas.equals(other.getIjlinguas()))) &&
            ((this.tamcolgrid==null && other.getTamcolgrid()==null) || 
             (this.tamcolgrid!=null &&
              this.tamcolgrid.equals(other.getTamcolgrid())));
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
        if (getHeadercol() != null) {
            _hashCode += getHeadercol().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjlinguas() != null) {
            _hashCode += getIjlinguas().hashCode();
        }
        if (getTamcolgrid() != null) {
            _hashCode += getTamcolgrid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbgrids.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbgrids"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("headercol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "headercol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbgridsId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijlinguas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijlinguas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlinguas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tamcolgrid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tamcolgrid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
