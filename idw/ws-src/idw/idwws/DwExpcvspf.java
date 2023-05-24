/**
 * DwExpcvspf.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwExpcvspf  extends idw.idwws.DwExpcvspfTemplate  implements java.io.Serializable {
    private idw.idwws.DwExpcvs dwExpcvs;

    private long idExpcfvpf;

    private idw.idwws.OmProgrp omProgrp;

    public DwExpcvspf() {
    }

    public DwExpcvspf(
           idw.idwws.DwExpcvs dwExpcvs,
           long idExpcfvpf,
           idw.idwws.OmProgrp omProgrp) {
        this.dwExpcvs = dwExpcvs;
        this.idExpcfvpf = idExpcfvpf;
        this.omProgrp = omProgrp;
    }


    /**
     * Gets the dwExpcvs value for this DwExpcvspf.
     * 
     * @return dwExpcvs
     */
    public idw.idwws.DwExpcvs getDwExpcvs() {
        return dwExpcvs;
    }


    /**
     * Sets the dwExpcvs value for this DwExpcvspf.
     * 
     * @param dwExpcvs
     */
    public void setDwExpcvs(idw.idwws.DwExpcvs dwExpcvs) {
        this.dwExpcvs = dwExpcvs;
    }


    /**
     * Gets the idExpcfvpf value for this DwExpcvspf.
     * 
     * @return idExpcfvpf
     */
    public long getIdExpcfvpf() {
        return idExpcfvpf;
    }


    /**
     * Sets the idExpcfvpf value for this DwExpcvspf.
     * 
     * @param idExpcfvpf
     */
    public void setIdExpcfvpf(long idExpcfvpf) {
        this.idExpcfvpf = idExpcfvpf;
    }


    /**
     * Gets the omProgrp value for this DwExpcvspf.
     * 
     * @return omProgrp
     */
    public idw.idwws.OmProgrp getOmProgrp() {
        return omProgrp;
    }


    /**
     * Sets the omProgrp value for this DwExpcvspf.
     * 
     * @param omProgrp
     */
    public void setOmProgrp(idw.idwws.OmProgrp omProgrp) {
        this.omProgrp = omProgrp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwExpcvspf)) return false;
        DwExpcvspf other = (DwExpcvspf) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwExpcvs==null && other.getDwExpcvs()==null) || 
             (this.dwExpcvs!=null &&
              this.dwExpcvs.equals(other.getDwExpcvs()))) &&
            this.idExpcfvpf == other.getIdExpcfvpf() &&
            ((this.omProgrp==null && other.getOmProgrp()==null) || 
             (this.omProgrp!=null &&
              this.omProgrp.equals(other.getOmProgrp())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getDwExpcvs() != null) {
            _hashCode += getDwExpcvs().hashCode();
        }
        _hashCode += new Long(getIdExpcfvpf()).hashCode();
        if (getOmProgrp() != null) {
            _hashCode += getOmProgrp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwExpcvspf.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwExpcvspf"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwExpcvs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwExpcvs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwExpcvs"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idExpcfvpf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idExpcfvpf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProgrp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProgrp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProgrp"));
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
