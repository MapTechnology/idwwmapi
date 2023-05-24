/**
 * Ijtbcentrocusto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbcentrocusto  implements java.io.Serializable {
    private java.lang.String cdcentrocusto;

    private java.lang.String dscentrocusto;

    private idw.idwws.Ijcentrocustoxmaq[] ijcentrocustoxmaqs;

    public Ijtbcentrocusto() {
    }

    public Ijtbcentrocusto(
           java.lang.String cdcentrocusto,
           java.lang.String dscentrocusto,
           idw.idwws.Ijcentrocustoxmaq[] ijcentrocustoxmaqs) {
           this.cdcentrocusto = cdcentrocusto;
           this.dscentrocusto = dscentrocusto;
           this.ijcentrocustoxmaqs = ijcentrocustoxmaqs;
    }


    /**
     * Gets the cdcentrocusto value for this Ijtbcentrocusto.
     * 
     * @return cdcentrocusto
     */
    public java.lang.String getCdcentrocusto() {
        return cdcentrocusto;
    }


    /**
     * Sets the cdcentrocusto value for this Ijtbcentrocusto.
     * 
     * @param cdcentrocusto
     */
    public void setCdcentrocusto(java.lang.String cdcentrocusto) {
        this.cdcentrocusto = cdcentrocusto;
    }


    /**
     * Gets the dscentrocusto value for this Ijtbcentrocusto.
     * 
     * @return dscentrocusto
     */
    public java.lang.String getDscentrocusto() {
        return dscentrocusto;
    }


    /**
     * Sets the dscentrocusto value for this Ijtbcentrocusto.
     * 
     * @param dscentrocusto
     */
    public void setDscentrocusto(java.lang.String dscentrocusto) {
        this.dscentrocusto = dscentrocusto;
    }


    /**
     * Gets the ijcentrocustoxmaqs value for this Ijtbcentrocusto.
     * 
     * @return ijcentrocustoxmaqs
     */
    public idw.idwws.Ijcentrocustoxmaq[] getIjcentrocustoxmaqs() {
        return ijcentrocustoxmaqs;
    }


    /**
     * Sets the ijcentrocustoxmaqs value for this Ijtbcentrocusto.
     * 
     * @param ijcentrocustoxmaqs
     */
    public void setIjcentrocustoxmaqs(idw.idwws.Ijcentrocustoxmaq[] ijcentrocustoxmaqs) {
        this.ijcentrocustoxmaqs = ijcentrocustoxmaqs;
    }

    public idw.idwws.Ijcentrocustoxmaq getIjcentrocustoxmaqs(int i) {
        return this.ijcentrocustoxmaqs[i];
    }

    public void setIjcentrocustoxmaqs(int i, idw.idwws.Ijcentrocustoxmaq _value) {
        this.ijcentrocustoxmaqs[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbcentrocusto)) return false;
        Ijtbcentrocusto other = (Ijtbcentrocusto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcentrocusto==null && other.getCdcentrocusto()==null) || 
             (this.cdcentrocusto!=null &&
              this.cdcentrocusto.equals(other.getCdcentrocusto()))) &&
            ((this.dscentrocusto==null && other.getDscentrocusto()==null) || 
             (this.dscentrocusto!=null &&
              this.dscentrocusto.equals(other.getDscentrocusto()))) &&
            ((this.ijcentrocustoxmaqs==null && other.getIjcentrocustoxmaqs()==null) || 
             (this.ijcentrocustoxmaqs!=null &&
              java.util.Arrays.equals(this.ijcentrocustoxmaqs, other.getIjcentrocustoxmaqs())));
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
        if (getCdcentrocusto() != null) {
            _hashCode += getCdcentrocusto().hashCode();
        }
        if (getDscentrocusto() != null) {
            _hashCode += getDscentrocusto().hashCode();
        }
        if (getIjcentrocustoxmaqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjcentrocustoxmaqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjcentrocustoxmaqs(), i);
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
        new org.apache.axis.description.TypeDesc(Ijtbcentrocusto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcentrocusto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcentrocusto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcentrocusto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dscentrocusto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dscentrocusto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcentrocustoxmaqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcentrocustoxmaqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcentrocustoxmaq"));
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
