/**
 * Ijtbmotreploteins.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbmotreploteins  implements java.io.Serializable {
    private java.lang.String cdmotreploteins;

    private java.lang.String dsmotreploteins;

    private idw.idwws.Ijocorreploteins[] ijocorreploteinses;

    public Ijtbmotreploteins() {
    }

    public Ijtbmotreploteins(
           java.lang.String cdmotreploteins,
           java.lang.String dsmotreploteins,
           idw.idwws.Ijocorreploteins[] ijocorreploteinses) {
           this.cdmotreploteins = cdmotreploteins;
           this.dsmotreploteins = dsmotreploteins;
           this.ijocorreploteinses = ijocorreploteinses;
    }


    /**
     * Gets the cdmotreploteins value for this Ijtbmotreploteins.
     * 
     * @return cdmotreploteins
     */
    public java.lang.String getCdmotreploteins() {
        return cdmotreploteins;
    }


    /**
     * Sets the cdmotreploteins value for this Ijtbmotreploteins.
     * 
     * @param cdmotreploteins
     */
    public void setCdmotreploteins(java.lang.String cdmotreploteins) {
        this.cdmotreploteins = cdmotreploteins;
    }


    /**
     * Gets the dsmotreploteins value for this Ijtbmotreploteins.
     * 
     * @return dsmotreploteins
     */
    public java.lang.String getDsmotreploteins() {
        return dsmotreploteins;
    }


    /**
     * Sets the dsmotreploteins value for this Ijtbmotreploteins.
     * 
     * @param dsmotreploteins
     */
    public void setDsmotreploteins(java.lang.String dsmotreploteins) {
        this.dsmotreploteins = dsmotreploteins;
    }


    /**
     * Gets the ijocorreploteinses value for this Ijtbmotreploteins.
     * 
     * @return ijocorreploteinses
     */
    public idw.idwws.Ijocorreploteins[] getIjocorreploteinses() {
        return ijocorreploteinses;
    }


    /**
     * Sets the ijocorreploteinses value for this Ijtbmotreploteins.
     * 
     * @param ijocorreploteinses
     */
    public void setIjocorreploteinses(idw.idwws.Ijocorreploteins[] ijocorreploteinses) {
        this.ijocorreploteinses = ijocorreploteinses;
    }

    public idw.idwws.Ijocorreploteins getIjocorreploteinses(int i) {
        return this.ijocorreploteinses[i];
    }

    public void setIjocorreploteinses(int i, idw.idwws.Ijocorreploteins _value) {
        this.ijocorreploteinses[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbmotreploteins)) return false;
        Ijtbmotreploteins other = (Ijtbmotreploteins) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdmotreploteins==null && other.getCdmotreploteins()==null) || 
             (this.cdmotreploteins!=null &&
              this.cdmotreploteins.equals(other.getCdmotreploteins()))) &&
            ((this.dsmotreploteins==null && other.getDsmotreploteins()==null) || 
             (this.dsmotreploteins!=null &&
              this.dsmotreploteins.equals(other.getDsmotreploteins()))) &&
            ((this.ijocorreploteinses==null && other.getIjocorreploteinses()==null) || 
             (this.ijocorreploteinses!=null &&
              java.util.Arrays.equals(this.ijocorreploteinses, other.getIjocorreploteinses())));
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
        if (getCdmotreploteins() != null) {
            _hashCode += getCdmotreploteins().hashCode();
        }
        if (getDsmotreploteins() != null) {
            _hashCode += getDsmotreploteins().hashCode();
        }
        if (getIjocorreploteinses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjocorreploteinses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjocorreploteinses(), i);
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
        new org.apache.axis.description.TypeDesc(Ijtbmotreploteins.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmotreploteins"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmotreploteins");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmotreploteins"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsmotreploteins");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsmotreploteins"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijocorreploteinses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijocorreploteinses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijocorreploteins"));
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
