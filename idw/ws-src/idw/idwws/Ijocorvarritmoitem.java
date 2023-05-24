/**
 * Ijocorvarritmoitem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijocorvarritmoitem  implements java.io.Serializable {
    private double idregvarritmoitem;

    private idw.idwws.Ijocorvarritmo ijocorvarritmo;

    private idw.idwws.Ijtbvarritmo ijtbvarritmo;

    private java.math.BigDecimal perc;

    public Ijocorvarritmoitem() {
    }

    public Ijocorvarritmoitem(
           double idregvarritmoitem,
           idw.idwws.Ijocorvarritmo ijocorvarritmo,
           idw.idwws.Ijtbvarritmo ijtbvarritmo,
           java.math.BigDecimal perc) {
           this.idregvarritmoitem = idregvarritmoitem;
           this.ijocorvarritmo = ijocorvarritmo;
           this.ijtbvarritmo = ijtbvarritmo;
           this.perc = perc;
    }


    /**
     * Gets the idregvarritmoitem value for this Ijocorvarritmoitem.
     * 
     * @return idregvarritmoitem
     */
    public double getIdregvarritmoitem() {
        return idregvarritmoitem;
    }


    /**
     * Sets the idregvarritmoitem value for this Ijocorvarritmoitem.
     * 
     * @param idregvarritmoitem
     */
    public void setIdregvarritmoitem(double idregvarritmoitem) {
        this.idregvarritmoitem = idregvarritmoitem;
    }


    /**
     * Gets the ijocorvarritmo value for this Ijocorvarritmoitem.
     * 
     * @return ijocorvarritmo
     */
    public idw.idwws.Ijocorvarritmo getIjocorvarritmo() {
        return ijocorvarritmo;
    }


    /**
     * Sets the ijocorvarritmo value for this Ijocorvarritmoitem.
     * 
     * @param ijocorvarritmo
     */
    public void setIjocorvarritmo(idw.idwws.Ijocorvarritmo ijocorvarritmo) {
        this.ijocorvarritmo = ijocorvarritmo;
    }


    /**
     * Gets the ijtbvarritmo value for this Ijocorvarritmoitem.
     * 
     * @return ijtbvarritmo
     */
    public idw.idwws.Ijtbvarritmo getIjtbvarritmo() {
        return ijtbvarritmo;
    }


    /**
     * Sets the ijtbvarritmo value for this Ijocorvarritmoitem.
     * 
     * @param ijtbvarritmo
     */
    public void setIjtbvarritmo(idw.idwws.Ijtbvarritmo ijtbvarritmo) {
        this.ijtbvarritmo = ijtbvarritmo;
    }


    /**
     * Gets the perc value for this Ijocorvarritmoitem.
     * 
     * @return perc
     */
    public java.math.BigDecimal getPerc() {
        return perc;
    }


    /**
     * Sets the perc value for this Ijocorvarritmoitem.
     * 
     * @param perc
     */
    public void setPerc(java.math.BigDecimal perc) {
        this.perc = perc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijocorvarritmoitem)) return false;
        Ijocorvarritmoitem other = (Ijocorvarritmoitem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idregvarritmoitem == other.getIdregvarritmoitem() &&
            ((this.ijocorvarritmo==null && other.getIjocorvarritmo()==null) || 
             (this.ijocorvarritmo!=null &&
              this.ijocorvarritmo.equals(other.getIjocorvarritmo()))) &&
            ((this.ijtbvarritmo==null && other.getIjtbvarritmo()==null) || 
             (this.ijtbvarritmo!=null &&
              this.ijtbvarritmo.equals(other.getIjtbvarritmo()))) &&
            ((this.perc==null && other.getPerc()==null) || 
             (this.perc!=null &&
              this.perc.equals(other.getPerc())));
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
        _hashCode += new Double(getIdregvarritmoitem()).hashCode();
        if (getIjocorvarritmo() != null) {
            _hashCode += getIjocorvarritmo().hashCode();
        }
        if (getIjtbvarritmo() != null) {
            _hashCode += getIjtbvarritmo().hashCode();
        }
        if (getPerc() != null) {
            _hashCode += getPerc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijocorvarritmoitem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijocorvarritmoitem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idregvarritmoitem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idregvarritmoitem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijocorvarritmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijocorvarritmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijocorvarritmo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbvarritmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbvarritmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbvarritmo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perc"));
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
