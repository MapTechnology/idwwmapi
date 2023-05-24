/**
 * Ijtbintemail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbintemail  implements java.io.Serializable {
    private java.lang.String cdinterno;

    private java.lang.String cdintervalo;

    private java.lang.String dsintervalo;

    private idw.idwws.Ijintinf[] ijintinfs;

    public Ijtbintemail() {
    }

    public Ijtbintemail(
           java.lang.String cdinterno,
           java.lang.String cdintervalo,
           java.lang.String dsintervalo,
           idw.idwws.Ijintinf[] ijintinfs) {
           this.cdinterno = cdinterno;
           this.cdintervalo = cdintervalo;
           this.dsintervalo = dsintervalo;
           this.ijintinfs = ijintinfs;
    }


    /**
     * Gets the cdinterno value for this Ijtbintemail.
     * 
     * @return cdinterno
     */
    public java.lang.String getCdinterno() {
        return cdinterno;
    }


    /**
     * Sets the cdinterno value for this Ijtbintemail.
     * 
     * @param cdinterno
     */
    public void setCdinterno(java.lang.String cdinterno) {
        this.cdinterno = cdinterno;
    }


    /**
     * Gets the cdintervalo value for this Ijtbintemail.
     * 
     * @return cdintervalo
     */
    public java.lang.String getCdintervalo() {
        return cdintervalo;
    }


    /**
     * Sets the cdintervalo value for this Ijtbintemail.
     * 
     * @param cdintervalo
     */
    public void setCdintervalo(java.lang.String cdintervalo) {
        this.cdintervalo = cdintervalo;
    }


    /**
     * Gets the dsintervalo value for this Ijtbintemail.
     * 
     * @return dsintervalo
     */
    public java.lang.String getDsintervalo() {
        return dsintervalo;
    }


    /**
     * Sets the dsintervalo value for this Ijtbintemail.
     * 
     * @param dsintervalo
     */
    public void setDsintervalo(java.lang.String dsintervalo) {
        this.dsintervalo = dsintervalo;
    }


    /**
     * Gets the ijintinfs value for this Ijtbintemail.
     * 
     * @return ijintinfs
     */
    public idw.idwws.Ijintinf[] getIjintinfs() {
        return ijintinfs;
    }


    /**
     * Sets the ijintinfs value for this Ijtbintemail.
     * 
     * @param ijintinfs
     */
    public void setIjintinfs(idw.idwws.Ijintinf[] ijintinfs) {
        this.ijintinfs = ijintinfs;
    }

    public idw.idwws.Ijintinf getIjintinfs(int i) {
        return this.ijintinfs[i];
    }

    public void setIjintinfs(int i, idw.idwws.Ijintinf _value) {
        this.ijintinfs[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbintemail)) return false;
        Ijtbintemail other = (Ijtbintemail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdinterno==null && other.getCdinterno()==null) || 
             (this.cdinterno!=null &&
              this.cdinterno.equals(other.getCdinterno()))) &&
            ((this.cdintervalo==null && other.getCdintervalo()==null) || 
             (this.cdintervalo!=null &&
              this.cdintervalo.equals(other.getCdintervalo()))) &&
            ((this.dsintervalo==null && other.getDsintervalo()==null) || 
             (this.dsintervalo!=null &&
              this.dsintervalo.equals(other.getDsintervalo()))) &&
            ((this.ijintinfs==null && other.getIjintinfs()==null) || 
             (this.ijintinfs!=null &&
              java.util.Arrays.equals(this.ijintinfs, other.getIjintinfs())));
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
        if (getCdinterno() != null) {
            _hashCode += getCdinterno().hashCode();
        }
        if (getCdintervalo() != null) {
            _hashCode += getCdintervalo().hashCode();
        }
        if (getDsintervalo() != null) {
            _hashCode += getDsintervalo().hashCode();
        }
        if (getIjintinfs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjintinfs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjintinfs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbintemail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbintemail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinterno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinterno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdintervalo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdintervalo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsintervalo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsintervalo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijintinfs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijintinfs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijintinf"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
