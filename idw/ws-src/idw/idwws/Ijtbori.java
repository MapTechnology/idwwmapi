/**
 * Ijtbori.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbori  implements java.io.Serializable {
    private java.lang.String cdorigem;

    private java.lang.String dsorigem;

    private idw.idwws.Ijtbmol[] ijtbmols;

    public Ijtbori() {
    }

    public Ijtbori(
           java.lang.String cdorigem,
           java.lang.String dsorigem,
           idw.idwws.Ijtbmol[] ijtbmols) {
           this.cdorigem = cdorigem;
           this.dsorigem = dsorigem;
           this.ijtbmols = ijtbmols;
    }


    /**
     * Gets the cdorigem value for this Ijtbori.
     * 
     * @return cdorigem
     */
    public java.lang.String getCdorigem() {
        return cdorigem;
    }


    /**
     * Sets the cdorigem value for this Ijtbori.
     * 
     * @param cdorigem
     */
    public void setCdorigem(java.lang.String cdorigem) {
        this.cdorigem = cdorigem;
    }


    /**
     * Gets the dsorigem value for this Ijtbori.
     * 
     * @return dsorigem
     */
    public java.lang.String getDsorigem() {
        return dsorigem;
    }


    /**
     * Sets the dsorigem value for this Ijtbori.
     * 
     * @param dsorigem
     */
    public void setDsorigem(java.lang.String dsorigem) {
        this.dsorigem = dsorigem;
    }


    /**
     * Gets the ijtbmols value for this Ijtbori.
     * 
     * @return ijtbmols
     */
    public idw.idwws.Ijtbmol[] getIjtbmols() {
        return ijtbmols;
    }


    /**
     * Sets the ijtbmols value for this Ijtbori.
     * 
     * @param ijtbmols
     */
    public void setIjtbmols(idw.idwws.Ijtbmol[] ijtbmols) {
        this.ijtbmols = ijtbmols;
    }

    public idw.idwws.Ijtbmol getIjtbmols(int i) {
        return this.ijtbmols[i];
    }

    public void setIjtbmols(int i, idw.idwws.Ijtbmol _value) {
        this.ijtbmols[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbori)) return false;
        Ijtbori other = (Ijtbori) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdorigem==null && other.getCdorigem()==null) || 
             (this.cdorigem!=null &&
              this.cdorigem.equals(other.getCdorigem()))) &&
            ((this.dsorigem==null && other.getDsorigem()==null) || 
             (this.dsorigem!=null &&
              this.dsorigem.equals(other.getDsorigem()))) &&
            ((this.ijtbmols==null && other.getIjtbmols()==null) || 
             (this.ijtbmols!=null &&
              java.util.Arrays.equals(this.ijtbmols, other.getIjtbmols())));
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
        if (getCdorigem() != null) {
            _hashCode += getCdorigem().hashCode();
        }
        if (getDsorigem() != null) {
            _hashCode += getDsorigem().hashCode();
        }
        if (getIjtbmols() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbmols());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbmols(), i);
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
        new org.apache.axis.description.TypeDesc(Ijtbori.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbori"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdorigem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdorigem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsorigem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsorigem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmols");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmols"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmol"));
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
