/**
 * DwConsolmedparamoco.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolmedparamoco  extends idw.idwws.DwConsolmedparamocoTemplate  implements java.io.Serializable {
    private idw.idwws.DwConsolmedparam dwConsolmedparam;

    private idw.idwws.DwConsolmedparamlog dwConsolmedparamlog;

    private java.math.BigDecimal idConsolmedparamoco;

    public DwConsolmedparamoco() {
    }

    public DwConsolmedparamoco(
           idw.idwws.DwConsolmedparam dwConsolmedparam,
           idw.idwws.DwConsolmedparamlog dwConsolmedparamlog,
           java.math.BigDecimal idConsolmedparamoco) {
        this.dwConsolmedparam = dwConsolmedparam;
        this.dwConsolmedparamlog = dwConsolmedparamlog;
        this.idConsolmedparamoco = idConsolmedparamoco;
    }


    /**
     * Gets the dwConsolmedparam value for this DwConsolmedparamoco.
     * 
     * @return dwConsolmedparam
     */
    public idw.idwws.DwConsolmedparam getDwConsolmedparam() {
        return dwConsolmedparam;
    }


    /**
     * Sets the dwConsolmedparam value for this DwConsolmedparamoco.
     * 
     * @param dwConsolmedparam
     */
    public void setDwConsolmedparam(idw.idwws.DwConsolmedparam dwConsolmedparam) {
        this.dwConsolmedparam = dwConsolmedparam;
    }


    /**
     * Gets the dwConsolmedparamlog value for this DwConsolmedparamoco.
     * 
     * @return dwConsolmedparamlog
     */
    public idw.idwws.DwConsolmedparamlog getDwConsolmedparamlog() {
        return dwConsolmedparamlog;
    }


    /**
     * Sets the dwConsolmedparamlog value for this DwConsolmedparamoco.
     * 
     * @param dwConsolmedparamlog
     */
    public void setDwConsolmedparamlog(idw.idwws.DwConsolmedparamlog dwConsolmedparamlog) {
        this.dwConsolmedparamlog = dwConsolmedparamlog;
    }


    /**
     * Gets the idConsolmedparamoco value for this DwConsolmedparamoco.
     * 
     * @return idConsolmedparamoco
     */
    public java.math.BigDecimal getIdConsolmedparamoco() {
        return idConsolmedparamoco;
    }


    /**
     * Sets the idConsolmedparamoco value for this DwConsolmedparamoco.
     * 
     * @param idConsolmedparamoco
     */
    public void setIdConsolmedparamoco(java.math.BigDecimal idConsolmedparamoco) {
        this.idConsolmedparamoco = idConsolmedparamoco;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolmedparamoco)) return false;
        DwConsolmedparamoco other = (DwConsolmedparamoco) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwConsolmedparam==null && other.getDwConsolmedparam()==null) || 
             (this.dwConsolmedparam!=null &&
              this.dwConsolmedparam.equals(other.getDwConsolmedparam()))) &&
            ((this.dwConsolmedparamlog==null && other.getDwConsolmedparamlog()==null) || 
             (this.dwConsolmedparamlog!=null &&
              this.dwConsolmedparamlog.equals(other.getDwConsolmedparamlog()))) &&
            ((this.idConsolmedparamoco==null && other.getIdConsolmedparamoco()==null) || 
             (this.idConsolmedparamoco!=null &&
              this.idConsolmedparamoco.equals(other.getIdConsolmedparamoco())));
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
        if (getDwConsolmedparam() != null) {
            _hashCode += getDwConsolmedparam().hashCode();
        }
        if (getDwConsolmedparamlog() != null) {
            _hashCode += getDwConsolmedparamlog().hashCode();
        }
        if (getIdConsolmedparamoco() != null) {
            _hashCode += getIdConsolmedparamoco().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolmedparamoco.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmedparamoco"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolmedparam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolmedparam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmedparam"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolmedparamlog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolmedparamlog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmedparamlog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolmedparamoco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolmedparamoco"));
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
