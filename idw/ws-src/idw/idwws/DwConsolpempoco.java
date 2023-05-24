/**
 * DwConsolpempoco.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolpempoco  extends idw.idwws.DwConsolpempocoTemplate  implements java.io.Serializable {
    private idw.idwws.DwConsolpemp dwConsolpemp;

    private idw.idwws.DwConsolperdamplog dwConsolperdamplog;

    private long idConsolpempoco;

    public DwConsolpempoco() {
    }

    public DwConsolpempoco(
           idw.idwws.DwConsolpemp dwConsolpemp,
           idw.idwws.DwConsolperdamplog dwConsolperdamplog,
           long idConsolpempoco) {
        this.dwConsolpemp = dwConsolpemp;
        this.dwConsolperdamplog = dwConsolperdamplog;
        this.idConsolpempoco = idConsolpempoco;
    }


    /**
     * Gets the dwConsolpemp value for this DwConsolpempoco.
     * 
     * @return dwConsolpemp
     */
    public idw.idwws.DwConsolpemp getDwConsolpemp() {
        return dwConsolpemp;
    }


    /**
     * Sets the dwConsolpemp value for this DwConsolpempoco.
     * 
     * @param dwConsolpemp
     */
    public void setDwConsolpemp(idw.idwws.DwConsolpemp dwConsolpemp) {
        this.dwConsolpemp = dwConsolpemp;
    }


    /**
     * Gets the dwConsolperdamplog value for this DwConsolpempoco.
     * 
     * @return dwConsolperdamplog
     */
    public idw.idwws.DwConsolperdamplog getDwConsolperdamplog() {
        return dwConsolperdamplog;
    }


    /**
     * Sets the dwConsolperdamplog value for this DwConsolpempoco.
     * 
     * @param dwConsolperdamplog
     */
    public void setDwConsolperdamplog(idw.idwws.DwConsolperdamplog dwConsolperdamplog) {
        this.dwConsolperdamplog = dwConsolperdamplog;
    }


    /**
     * Gets the idConsolpempoco value for this DwConsolpempoco.
     * 
     * @return idConsolpempoco
     */
    public long getIdConsolpempoco() {
        return idConsolpempoco;
    }


    /**
     * Sets the idConsolpempoco value for this DwConsolpempoco.
     * 
     * @param idConsolpempoco
     */
    public void setIdConsolpempoco(long idConsolpempoco) {
        this.idConsolpempoco = idConsolpempoco;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolpempoco)) return false;
        DwConsolpempoco other = (DwConsolpempoco) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwConsolpemp==null && other.getDwConsolpemp()==null) || 
             (this.dwConsolpemp!=null &&
              this.dwConsolpemp.equals(other.getDwConsolpemp()))) &&
            ((this.dwConsolperdamplog==null && other.getDwConsolperdamplog()==null) || 
             (this.dwConsolperdamplog!=null &&
              this.dwConsolperdamplog.equals(other.getDwConsolperdamplog()))) &&
            this.idConsolpempoco == other.getIdConsolpempoco();
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
        if (getDwConsolpemp() != null) {
            _hashCode += getDwConsolpemp().hashCode();
        }
        if (getDwConsolperdamplog() != null) {
            _hashCode += getDwConsolperdamplog().hashCode();
        }
        _hashCode += new Long(getIdConsolpempoco()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolpempoco.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpempoco"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolpemp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpemp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpemp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolperdamplog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolperdamplog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolperdamplog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolpempoco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolpempoco"));
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
