/**
 * Ijtbconttempo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbconttempo  implements java.io.Serializable {
    private java.lang.String cdtempo;

    private java.lang.String dstempo;

    private idw.idwws.Ijlinguas ijlinguas;

    private java.math.BigDecimal valoremseg;

    public Ijtbconttempo() {
    }

    public Ijtbconttempo(
           java.lang.String cdtempo,
           java.lang.String dstempo,
           idw.idwws.Ijlinguas ijlinguas,
           java.math.BigDecimal valoremseg) {
           this.cdtempo = cdtempo;
           this.dstempo = dstempo;
           this.ijlinguas = ijlinguas;
           this.valoremseg = valoremseg;
    }


    /**
     * Gets the cdtempo value for this Ijtbconttempo.
     * 
     * @return cdtempo
     */
    public java.lang.String getCdtempo() {
        return cdtempo;
    }


    /**
     * Sets the cdtempo value for this Ijtbconttempo.
     * 
     * @param cdtempo
     */
    public void setCdtempo(java.lang.String cdtempo) {
        this.cdtempo = cdtempo;
    }


    /**
     * Gets the dstempo value for this Ijtbconttempo.
     * 
     * @return dstempo
     */
    public java.lang.String getDstempo() {
        return dstempo;
    }


    /**
     * Sets the dstempo value for this Ijtbconttempo.
     * 
     * @param dstempo
     */
    public void setDstempo(java.lang.String dstempo) {
        this.dstempo = dstempo;
    }


    /**
     * Gets the ijlinguas value for this Ijtbconttempo.
     * 
     * @return ijlinguas
     */
    public idw.idwws.Ijlinguas getIjlinguas() {
        return ijlinguas;
    }


    /**
     * Sets the ijlinguas value for this Ijtbconttempo.
     * 
     * @param ijlinguas
     */
    public void setIjlinguas(idw.idwws.Ijlinguas ijlinguas) {
        this.ijlinguas = ijlinguas;
    }


    /**
     * Gets the valoremseg value for this Ijtbconttempo.
     * 
     * @return valoremseg
     */
    public java.math.BigDecimal getValoremseg() {
        return valoremseg;
    }


    /**
     * Sets the valoremseg value for this Ijtbconttempo.
     * 
     * @param valoremseg
     */
    public void setValoremseg(java.math.BigDecimal valoremseg) {
        this.valoremseg = valoremseg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbconttempo)) return false;
        Ijtbconttempo other = (Ijtbconttempo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdtempo==null && other.getCdtempo()==null) || 
             (this.cdtempo!=null &&
              this.cdtempo.equals(other.getCdtempo()))) &&
            ((this.dstempo==null && other.getDstempo()==null) || 
             (this.dstempo!=null &&
              this.dstempo.equals(other.getDstempo()))) &&
            ((this.ijlinguas==null && other.getIjlinguas()==null) || 
             (this.ijlinguas!=null &&
              this.ijlinguas.equals(other.getIjlinguas()))) &&
            ((this.valoremseg==null && other.getValoremseg()==null) || 
             (this.valoremseg!=null &&
              this.valoremseg.equals(other.getValoremseg())));
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
        if (getCdtempo() != null) {
            _hashCode += getCdtempo().hashCode();
        }
        if (getDstempo() != null) {
            _hashCode += getDstempo().hashCode();
        }
        if (getIjlinguas() != null) {
            _hashCode += getIjlinguas().hashCode();
        }
        if (getValoremseg() != null) {
            _hashCode += getValoremseg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbconttempo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbconttempo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtempo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtempo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dstempo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dstempo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("valoremseg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valoremseg"));
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
