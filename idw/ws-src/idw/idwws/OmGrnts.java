/**
 * OmGrnts.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmGrnts  extends idw.idwws.OmGrntsTemplate  implements java.io.Serializable {
    private long idGrnts;

    private idw.idwws.OmResgui omResgui;

    private idw.idwws.OmUsrgrp omUsrgrp;

    private java.lang.Byte tpAcesso;

    public OmGrnts() {
    }

    public OmGrnts(
           long idGrnts,
           idw.idwws.OmResgui omResgui,
           idw.idwws.OmUsrgrp omUsrgrp,
           java.lang.Byte tpAcesso) {
        this.idGrnts = idGrnts;
        this.omResgui = omResgui;
        this.omUsrgrp = omUsrgrp;
        this.tpAcesso = tpAcesso;
    }


    /**
     * Gets the idGrnts value for this OmGrnts.
     * 
     * @return idGrnts
     */
    public long getIdGrnts() {
        return idGrnts;
    }


    /**
     * Sets the idGrnts value for this OmGrnts.
     * 
     * @param idGrnts
     */
    public void setIdGrnts(long idGrnts) {
        this.idGrnts = idGrnts;
    }


    /**
     * Gets the omResgui value for this OmGrnts.
     * 
     * @return omResgui
     */
    public idw.idwws.OmResgui getOmResgui() {
        return omResgui;
    }


    /**
     * Sets the omResgui value for this OmGrnts.
     * 
     * @param omResgui
     */
    public void setOmResgui(idw.idwws.OmResgui omResgui) {
        this.omResgui = omResgui;
    }


    /**
     * Gets the omUsrgrp value for this OmGrnts.
     * 
     * @return omUsrgrp
     */
    public idw.idwws.OmUsrgrp getOmUsrgrp() {
        return omUsrgrp;
    }


    /**
     * Sets the omUsrgrp value for this OmGrnts.
     * 
     * @param omUsrgrp
     */
    public void setOmUsrgrp(idw.idwws.OmUsrgrp omUsrgrp) {
        this.omUsrgrp = omUsrgrp;
    }


    /**
     * Gets the tpAcesso value for this OmGrnts.
     * 
     * @return tpAcesso
     */
    public java.lang.Byte getTpAcesso() {
        return tpAcesso;
    }


    /**
     * Sets the tpAcesso value for this OmGrnts.
     * 
     * @param tpAcesso
     */
    public void setTpAcesso(java.lang.Byte tpAcesso) {
        this.tpAcesso = tpAcesso;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmGrnts)) return false;
        OmGrnts other = (OmGrnts) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.idGrnts == other.getIdGrnts() &&
            ((this.omResgui==null && other.getOmResgui()==null) || 
             (this.omResgui!=null &&
              this.omResgui.equals(other.getOmResgui()))) &&
            ((this.omUsrgrp==null && other.getOmUsrgrp()==null) || 
             (this.omUsrgrp!=null &&
              this.omUsrgrp.equals(other.getOmUsrgrp()))) &&
            ((this.tpAcesso==null && other.getTpAcesso()==null) || 
             (this.tpAcesso!=null &&
              this.tpAcesso.equals(other.getTpAcesso())));
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
        _hashCode += new Long(getIdGrnts()).hashCode();
        if (getOmResgui() != null) {
            _hashCode += getOmResgui().hashCode();
        }
        if (getOmUsrgrp() != null) {
            _hashCode += getOmUsrgrp().hashCode();
        }
        if (getTpAcesso() != null) {
            _hashCode += getTpAcesso().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmGrnts.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGrnts"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idGrnts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idGrnts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omResgui");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omResgui"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omResgui"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrgrp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrgrp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsrgrp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpAcesso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpAcesso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
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
