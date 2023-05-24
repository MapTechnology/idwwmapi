/**
 * DwConsolpalogtec.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolpalogtec  implements java.io.Serializable {
    private idw.idwws.DwConsolpalog dwConsolpalog;

    private double idConsolpalogtec;

    private idw.idwws.OmUsr omUsr;

    public DwConsolpalogtec() {
    }

    public DwConsolpalogtec(
           idw.idwws.DwConsolpalog dwConsolpalog,
           double idConsolpalogtec,
           idw.idwws.OmUsr omUsr) {
           this.dwConsolpalog = dwConsolpalog;
           this.idConsolpalogtec = idConsolpalogtec;
           this.omUsr = omUsr;
    }


    /**
     * Gets the dwConsolpalog value for this DwConsolpalogtec.
     * 
     * @return dwConsolpalog
     */
    public idw.idwws.DwConsolpalog getDwConsolpalog() {
        return dwConsolpalog;
    }


    /**
     * Sets the dwConsolpalog value for this DwConsolpalogtec.
     * 
     * @param dwConsolpalog
     */
    public void setDwConsolpalog(idw.idwws.DwConsolpalog dwConsolpalog) {
        this.dwConsolpalog = dwConsolpalog;
    }


    /**
     * Gets the idConsolpalogtec value for this DwConsolpalogtec.
     * 
     * @return idConsolpalogtec
     */
    public double getIdConsolpalogtec() {
        return idConsolpalogtec;
    }


    /**
     * Sets the idConsolpalogtec value for this DwConsolpalogtec.
     * 
     * @param idConsolpalogtec
     */
    public void setIdConsolpalogtec(double idConsolpalogtec) {
        this.idConsolpalogtec = idConsolpalogtec;
    }


    /**
     * Gets the omUsr value for this DwConsolpalogtec.
     * 
     * @return omUsr
     */
    public idw.idwws.OmUsr getOmUsr() {
        return omUsr;
    }


    /**
     * Sets the omUsr value for this DwConsolpalogtec.
     * 
     * @param omUsr
     */
    public void setOmUsr(idw.idwws.OmUsr omUsr) {
        this.omUsr = omUsr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolpalogtec)) return false;
        DwConsolpalogtec other = (DwConsolpalogtec) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dwConsolpalog==null && other.getDwConsolpalog()==null) || 
             (this.dwConsolpalog!=null &&
              this.dwConsolpalog.equals(other.getDwConsolpalog()))) &&
            this.idConsolpalogtec == other.getIdConsolpalogtec() &&
            ((this.omUsr==null && other.getOmUsr()==null) || 
             (this.omUsr!=null &&
              this.omUsr.equals(other.getOmUsr())));
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
        if (getDwConsolpalog() != null) {
            _hashCode += getDwConsolpalog().hashCode();
        }
        _hashCode += new Double(getIdConsolpalogtec()).hashCode();
        if (getOmUsr() != null) {
            _hashCode += getOmUsr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolpalogtec.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpalogtec"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolpalog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpalog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpalog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolpalogtec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolpalogtec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
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
