/**
 * Ijtbgrpitemcnc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbgrpitemcnc  implements java.io.Serializable {
    private java.lang.String cdgrpitemcnc;

    private java.lang.String dsgrpitemcnc;

    private idw.idwws.Ijtbitemcnc[] ijtbitemcncs;

    public Ijtbgrpitemcnc() {
    }

    public Ijtbgrpitemcnc(
           java.lang.String cdgrpitemcnc,
           java.lang.String dsgrpitemcnc,
           idw.idwws.Ijtbitemcnc[] ijtbitemcncs) {
           this.cdgrpitemcnc = cdgrpitemcnc;
           this.dsgrpitemcnc = dsgrpitemcnc;
           this.ijtbitemcncs = ijtbitemcncs;
    }


    /**
     * Gets the cdgrpitemcnc value for this Ijtbgrpitemcnc.
     * 
     * @return cdgrpitemcnc
     */
    public java.lang.String getCdgrpitemcnc() {
        return cdgrpitemcnc;
    }


    /**
     * Sets the cdgrpitemcnc value for this Ijtbgrpitemcnc.
     * 
     * @param cdgrpitemcnc
     */
    public void setCdgrpitemcnc(java.lang.String cdgrpitemcnc) {
        this.cdgrpitemcnc = cdgrpitemcnc;
    }


    /**
     * Gets the dsgrpitemcnc value for this Ijtbgrpitemcnc.
     * 
     * @return dsgrpitemcnc
     */
    public java.lang.String getDsgrpitemcnc() {
        return dsgrpitemcnc;
    }


    /**
     * Sets the dsgrpitemcnc value for this Ijtbgrpitemcnc.
     * 
     * @param dsgrpitemcnc
     */
    public void setDsgrpitemcnc(java.lang.String dsgrpitemcnc) {
        this.dsgrpitemcnc = dsgrpitemcnc;
    }


    /**
     * Gets the ijtbitemcncs value for this Ijtbgrpitemcnc.
     * 
     * @return ijtbitemcncs
     */
    public idw.idwws.Ijtbitemcnc[] getIjtbitemcncs() {
        return ijtbitemcncs;
    }


    /**
     * Sets the ijtbitemcncs value for this Ijtbgrpitemcnc.
     * 
     * @param ijtbitemcncs
     */
    public void setIjtbitemcncs(idw.idwws.Ijtbitemcnc[] ijtbitemcncs) {
        this.ijtbitemcncs = ijtbitemcncs;
    }

    public idw.idwws.Ijtbitemcnc getIjtbitemcncs(int i) {
        return this.ijtbitemcncs[i];
    }

    public void setIjtbitemcncs(int i, idw.idwws.Ijtbitemcnc _value) {
        this.ijtbitemcncs[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbgrpitemcnc)) return false;
        Ijtbgrpitemcnc other = (Ijtbgrpitemcnc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgrpitemcnc==null && other.getCdgrpitemcnc()==null) || 
             (this.cdgrpitemcnc!=null &&
              this.cdgrpitemcnc.equals(other.getCdgrpitemcnc()))) &&
            ((this.dsgrpitemcnc==null && other.getDsgrpitemcnc()==null) || 
             (this.dsgrpitemcnc!=null &&
              this.dsgrpitemcnc.equals(other.getDsgrpitemcnc()))) &&
            ((this.ijtbitemcncs==null && other.getIjtbitemcncs()==null) || 
             (this.ijtbitemcncs!=null &&
              java.util.Arrays.equals(this.ijtbitemcncs, other.getIjtbitemcncs())));
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
        if (getCdgrpitemcnc() != null) {
            _hashCode += getCdgrpitemcnc().hashCode();
        }
        if (getDsgrpitemcnc() != null) {
            _hashCode += getDsgrpitemcnc().hashCode();
        }
        if (getIjtbitemcncs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbitemcncs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbitemcncs(), i);
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
        new org.apache.axis.description.TypeDesc(Ijtbgrpitemcnc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbgrpitemcnc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgrpitemcnc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgrpitemcnc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsgrpitemcnc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsgrpitemcnc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbitemcncs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbitemcncs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbitemcnc"));
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
