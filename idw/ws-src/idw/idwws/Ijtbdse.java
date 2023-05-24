/**
 * Ijtbdse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbdse  implements java.io.Serializable {
    private java.lang.String cddiasem;

    private java.lang.String dsdiasem;

    private idw.idwws.Ijhortur[] ijhorturs;

    public Ijtbdse() {
    }

    public Ijtbdse(
           java.lang.String cddiasem,
           java.lang.String dsdiasem,
           idw.idwws.Ijhortur[] ijhorturs) {
           this.cddiasem = cddiasem;
           this.dsdiasem = dsdiasem;
           this.ijhorturs = ijhorturs;
    }


    /**
     * Gets the cddiasem value for this Ijtbdse.
     * 
     * @return cddiasem
     */
    public java.lang.String getCddiasem() {
        return cddiasem;
    }


    /**
     * Sets the cddiasem value for this Ijtbdse.
     * 
     * @param cddiasem
     */
    public void setCddiasem(java.lang.String cddiasem) {
        this.cddiasem = cddiasem;
    }


    /**
     * Gets the dsdiasem value for this Ijtbdse.
     * 
     * @return dsdiasem
     */
    public java.lang.String getDsdiasem() {
        return dsdiasem;
    }


    /**
     * Sets the dsdiasem value for this Ijtbdse.
     * 
     * @param dsdiasem
     */
    public void setDsdiasem(java.lang.String dsdiasem) {
        this.dsdiasem = dsdiasem;
    }


    /**
     * Gets the ijhorturs value for this Ijtbdse.
     * 
     * @return ijhorturs
     */
    public idw.idwws.Ijhortur[] getIjhorturs() {
        return ijhorturs;
    }


    /**
     * Sets the ijhorturs value for this Ijtbdse.
     * 
     * @param ijhorturs
     */
    public void setIjhorturs(idw.idwws.Ijhortur[] ijhorturs) {
        this.ijhorturs = ijhorturs;
    }

    public idw.idwws.Ijhortur getIjhorturs(int i) {
        return this.ijhorturs[i];
    }

    public void setIjhorturs(int i, idw.idwws.Ijhortur _value) {
        this.ijhorturs[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbdse)) return false;
        Ijtbdse other = (Ijtbdse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cddiasem==null && other.getCddiasem()==null) || 
             (this.cddiasem!=null &&
              this.cddiasem.equals(other.getCddiasem()))) &&
            ((this.dsdiasem==null && other.getDsdiasem()==null) || 
             (this.dsdiasem!=null &&
              this.dsdiasem.equals(other.getDsdiasem()))) &&
            ((this.ijhorturs==null && other.getIjhorturs()==null) || 
             (this.ijhorturs!=null &&
              java.util.Arrays.equals(this.ijhorturs, other.getIjhorturs())));
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
        if (getCddiasem() != null) {
            _hashCode += getCddiasem().hashCode();
        }
        if (getDsdiasem() != null) {
            _hashCode += getDsdiasem().hashCode();
        }
        if (getIjhorturs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjhorturs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjhorturs(), i);
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
        new org.apache.axis.description.TypeDesc(Ijtbdse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbdse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cddiasem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cddiasem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsdiasem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsdiasem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijhorturs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijhorturs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijhortur"));
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
