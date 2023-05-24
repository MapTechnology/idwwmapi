/**
 * DwConsolreoco.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolreoco  implements java.io.Serializable {
    private idw.idwws.DwConsolre dwConsolre;

    private idw.idwws.DwConsolrelog dwConsolrelog;

    private long idConsolreoco;

    public DwConsolreoco() {
    }

    public DwConsolreoco(
           idw.idwws.DwConsolre dwConsolre,
           idw.idwws.DwConsolrelog dwConsolrelog,
           long idConsolreoco) {
           this.dwConsolre = dwConsolre;
           this.dwConsolrelog = dwConsolrelog;
           this.idConsolreoco = idConsolreoco;
    }


    /**
     * Gets the dwConsolre value for this DwConsolreoco.
     * 
     * @return dwConsolre
     */
    public idw.idwws.DwConsolre getDwConsolre() {
        return dwConsolre;
    }


    /**
     * Sets the dwConsolre value for this DwConsolreoco.
     * 
     * @param dwConsolre
     */
    public void setDwConsolre(idw.idwws.DwConsolre dwConsolre) {
        this.dwConsolre = dwConsolre;
    }


    /**
     * Gets the dwConsolrelog value for this DwConsolreoco.
     * 
     * @return dwConsolrelog
     */
    public idw.idwws.DwConsolrelog getDwConsolrelog() {
        return dwConsolrelog;
    }


    /**
     * Sets the dwConsolrelog value for this DwConsolreoco.
     * 
     * @param dwConsolrelog
     */
    public void setDwConsolrelog(idw.idwws.DwConsolrelog dwConsolrelog) {
        this.dwConsolrelog = dwConsolrelog;
    }


    /**
     * Gets the idConsolreoco value for this DwConsolreoco.
     * 
     * @return idConsolreoco
     */
    public long getIdConsolreoco() {
        return idConsolreoco;
    }


    /**
     * Sets the idConsolreoco value for this DwConsolreoco.
     * 
     * @param idConsolreoco
     */
    public void setIdConsolreoco(long idConsolreoco) {
        this.idConsolreoco = idConsolreoco;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolreoco)) return false;
        DwConsolreoco other = (DwConsolreoco) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dwConsolre==null && other.getDwConsolre()==null) || 
             (this.dwConsolre!=null &&
              this.dwConsolre.equals(other.getDwConsolre()))) &&
            ((this.dwConsolrelog==null && other.getDwConsolrelog()==null) || 
             (this.dwConsolrelog!=null &&
              this.dwConsolrelog.equals(other.getDwConsolrelog()))) &&
            this.idConsolreoco == other.getIdConsolreoco();
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
        if (getDwConsolre() != null) {
            _hashCode += getDwConsolre().hashCode();
        }
        if (getDwConsolrelog() != null) {
            _hashCode += getDwConsolrelog().hashCode();
        }
        _hashCode += new Long(getIdConsolreoco()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolreoco.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolreoco"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolre"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolrelog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolrelog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolrelog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolreoco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolreoco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
