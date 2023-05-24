/**
 * DwConsolalmo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolalmo  implements java.io.Serializable {
    private idw.idwws.DwConsolal dwConsolal;

    private idw.idwws.DwConsolmo dwConsolmo;

    private long idConsolalmo;

    private java.math.BigDecimal segAutoTempoalerta;

    private java.math.BigDecimal segManuTempoalerta;

    public DwConsolalmo() {
    }

    public DwConsolalmo(
           idw.idwws.DwConsolal dwConsolal,
           idw.idwws.DwConsolmo dwConsolmo,
           long idConsolalmo,
           java.math.BigDecimal segAutoTempoalerta,
           java.math.BigDecimal segManuTempoalerta) {
           this.dwConsolal = dwConsolal;
           this.dwConsolmo = dwConsolmo;
           this.idConsolalmo = idConsolalmo;
           this.segAutoTempoalerta = segAutoTempoalerta;
           this.segManuTempoalerta = segManuTempoalerta;
    }


    /**
     * Gets the dwConsolal value for this DwConsolalmo.
     * 
     * @return dwConsolal
     */
    public idw.idwws.DwConsolal getDwConsolal() {
        return dwConsolal;
    }


    /**
     * Sets the dwConsolal value for this DwConsolalmo.
     * 
     * @param dwConsolal
     */
    public void setDwConsolal(idw.idwws.DwConsolal dwConsolal) {
        this.dwConsolal = dwConsolal;
    }


    /**
     * Gets the dwConsolmo value for this DwConsolalmo.
     * 
     * @return dwConsolmo
     */
    public idw.idwws.DwConsolmo getDwConsolmo() {
        return dwConsolmo;
    }


    /**
     * Sets the dwConsolmo value for this DwConsolalmo.
     * 
     * @param dwConsolmo
     */
    public void setDwConsolmo(idw.idwws.DwConsolmo dwConsolmo) {
        this.dwConsolmo = dwConsolmo;
    }


    /**
     * Gets the idConsolalmo value for this DwConsolalmo.
     * 
     * @return idConsolalmo
     */
    public long getIdConsolalmo() {
        return idConsolalmo;
    }


    /**
     * Sets the idConsolalmo value for this DwConsolalmo.
     * 
     * @param idConsolalmo
     */
    public void setIdConsolalmo(long idConsolalmo) {
        this.idConsolalmo = idConsolalmo;
    }


    /**
     * Gets the segAutoTempoalerta value for this DwConsolalmo.
     * 
     * @return segAutoTempoalerta
     */
    public java.math.BigDecimal getSegAutoTempoalerta() {
        return segAutoTempoalerta;
    }


    /**
     * Sets the segAutoTempoalerta value for this DwConsolalmo.
     * 
     * @param segAutoTempoalerta
     */
    public void setSegAutoTempoalerta(java.math.BigDecimal segAutoTempoalerta) {
        this.segAutoTempoalerta = segAutoTempoalerta;
    }


    /**
     * Gets the segManuTempoalerta value for this DwConsolalmo.
     * 
     * @return segManuTempoalerta
     */
    public java.math.BigDecimal getSegManuTempoalerta() {
        return segManuTempoalerta;
    }


    /**
     * Sets the segManuTempoalerta value for this DwConsolalmo.
     * 
     * @param segManuTempoalerta
     */
    public void setSegManuTempoalerta(java.math.BigDecimal segManuTempoalerta) {
        this.segManuTempoalerta = segManuTempoalerta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolalmo)) return false;
        DwConsolalmo other = (DwConsolalmo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dwConsolal==null && other.getDwConsolal()==null) || 
             (this.dwConsolal!=null &&
              this.dwConsolal.equals(other.getDwConsolal()))) &&
            ((this.dwConsolmo==null && other.getDwConsolmo()==null) || 
             (this.dwConsolmo!=null &&
              this.dwConsolmo.equals(other.getDwConsolmo()))) &&
            this.idConsolalmo == other.getIdConsolalmo() &&
            ((this.segAutoTempoalerta==null && other.getSegAutoTempoalerta()==null) || 
             (this.segAutoTempoalerta!=null &&
              this.segAutoTempoalerta.equals(other.getSegAutoTempoalerta()))) &&
            ((this.segManuTempoalerta==null && other.getSegManuTempoalerta()==null) || 
             (this.segManuTempoalerta!=null &&
              this.segManuTempoalerta.equals(other.getSegManuTempoalerta())));
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
        if (getDwConsolal() != null) {
            _hashCode += getDwConsolal().hashCode();
        }
        if (getDwConsolmo() != null) {
            _hashCode += getDwConsolmo().hashCode();
        }
        _hashCode += new Long(getIdConsolalmo()).hashCode();
        if (getSegAutoTempoalerta() != null) {
            _hashCode += getSegAutoTempoalerta().hashCode();
        }
        if (getSegManuTempoalerta() != null) {
            _hashCode += getSegManuTempoalerta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolalmo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolalmo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolalmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolalmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoalerta"));
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
