/**
 * Ijgrpmol.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrpmol  implements java.io.Serializable {
    private java.lang.String cdgrpmol;

    private java.lang.String dsgrpmol;

    private idw.idwws.Ijgrpdetmol[] ijgrpdetmols;

    public Ijgrpmol() {
    }

    public Ijgrpmol(
           java.lang.String cdgrpmol,
           java.lang.String dsgrpmol,
           idw.idwws.Ijgrpdetmol[] ijgrpdetmols) {
           this.cdgrpmol = cdgrpmol;
           this.dsgrpmol = dsgrpmol;
           this.ijgrpdetmols = ijgrpdetmols;
    }


    /**
     * Gets the cdgrpmol value for this Ijgrpmol.
     * 
     * @return cdgrpmol
     */
    public java.lang.String getCdgrpmol() {
        return cdgrpmol;
    }


    /**
     * Sets the cdgrpmol value for this Ijgrpmol.
     * 
     * @param cdgrpmol
     */
    public void setCdgrpmol(java.lang.String cdgrpmol) {
        this.cdgrpmol = cdgrpmol;
    }


    /**
     * Gets the dsgrpmol value for this Ijgrpmol.
     * 
     * @return dsgrpmol
     */
    public java.lang.String getDsgrpmol() {
        return dsgrpmol;
    }


    /**
     * Sets the dsgrpmol value for this Ijgrpmol.
     * 
     * @param dsgrpmol
     */
    public void setDsgrpmol(java.lang.String dsgrpmol) {
        this.dsgrpmol = dsgrpmol;
    }


    /**
     * Gets the ijgrpdetmols value for this Ijgrpmol.
     * 
     * @return ijgrpdetmols
     */
    public idw.idwws.Ijgrpdetmol[] getIjgrpdetmols() {
        return ijgrpdetmols;
    }


    /**
     * Sets the ijgrpdetmols value for this Ijgrpmol.
     * 
     * @param ijgrpdetmols
     */
    public void setIjgrpdetmols(idw.idwws.Ijgrpdetmol[] ijgrpdetmols) {
        this.ijgrpdetmols = ijgrpdetmols;
    }

    public idw.idwws.Ijgrpdetmol getIjgrpdetmols(int i) {
        return this.ijgrpdetmols[i];
    }

    public void setIjgrpdetmols(int i, idw.idwws.Ijgrpdetmol _value) {
        this.ijgrpdetmols[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrpmol)) return false;
        Ijgrpmol other = (Ijgrpmol) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgrpmol==null && other.getCdgrpmol()==null) || 
             (this.cdgrpmol!=null &&
              this.cdgrpmol.equals(other.getCdgrpmol()))) &&
            ((this.dsgrpmol==null && other.getDsgrpmol()==null) || 
             (this.dsgrpmol!=null &&
              this.dsgrpmol.equals(other.getDsgrpmol()))) &&
            ((this.ijgrpdetmols==null && other.getIjgrpdetmols()==null) || 
             (this.ijgrpdetmols!=null &&
              java.util.Arrays.equals(this.ijgrpdetmols, other.getIjgrpdetmols())));
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
        if (getCdgrpmol() != null) {
            _hashCode += getCdgrpmol().hashCode();
        }
        if (getDsgrpmol() != null) {
            _hashCode += getDsgrpmol().hashCode();
        }
        if (getIjgrpdetmols() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpdetmols());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpdetmols(), i);
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
        new org.apache.axis.description.TypeDesc(Ijgrpmol.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpmol"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgrpmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgrpmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsgrpmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsgrpmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpdetmols");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpdetmols"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetmol"));
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
