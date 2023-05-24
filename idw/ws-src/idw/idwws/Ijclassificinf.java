/**
 * Ijclassificinf.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijclassificinf  implements java.io.Serializable {
    private idw.idwws.IjclassificinfId id;

    private idw.idwws.Ijselitensarq[] ijselitensarqs;

    private idw.idwws.Ijtbinf ijtbinf;

    private idw.idwws.Ijtbtipoinf ijtbtipoinf;

    public Ijclassificinf() {
    }

    public Ijclassificinf(
           idw.idwws.IjclassificinfId id,
           idw.idwws.Ijselitensarq[] ijselitensarqs,
           idw.idwws.Ijtbinf ijtbinf,
           idw.idwws.Ijtbtipoinf ijtbtipoinf) {
           this.id = id;
           this.ijselitensarqs = ijselitensarqs;
           this.ijtbinf = ijtbinf;
           this.ijtbtipoinf = ijtbtipoinf;
    }


    /**
     * Gets the id value for this Ijclassificinf.
     * 
     * @return id
     */
    public idw.idwws.IjclassificinfId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijclassificinf.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjclassificinfId id) {
        this.id = id;
    }


    /**
     * Gets the ijselitensarqs value for this Ijclassificinf.
     * 
     * @return ijselitensarqs
     */
    public idw.idwws.Ijselitensarq[] getIjselitensarqs() {
        return ijselitensarqs;
    }


    /**
     * Sets the ijselitensarqs value for this Ijclassificinf.
     * 
     * @param ijselitensarqs
     */
    public void setIjselitensarqs(idw.idwws.Ijselitensarq[] ijselitensarqs) {
        this.ijselitensarqs = ijselitensarqs;
    }

    public idw.idwws.Ijselitensarq getIjselitensarqs(int i) {
        return this.ijselitensarqs[i];
    }

    public void setIjselitensarqs(int i, idw.idwws.Ijselitensarq _value) {
        this.ijselitensarqs[i] = _value;
    }


    /**
     * Gets the ijtbinf value for this Ijclassificinf.
     * 
     * @return ijtbinf
     */
    public idw.idwws.Ijtbinf getIjtbinf() {
        return ijtbinf;
    }


    /**
     * Sets the ijtbinf value for this Ijclassificinf.
     * 
     * @param ijtbinf
     */
    public void setIjtbinf(idw.idwws.Ijtbinf ijtbinf) {
        this.ijtbinf = ijtbinf;
    }


    /**
     * Gets the ijtbtipoinf value for this Ijclassificinf.
     * 
     * @return ijtbtipoinf
     */
    public idw.idwws.Ijtbtipoinf getIjtbtipoinf() {
        return ijtbtipoinf;
    }


    /**
     * Sets the ijtbtipoinf value for this Ijclassificinf.
     * 
     * @param ijtbtipoinf
     */
    public void setIjtbtipoinf(idw.idwws.Ijtbtipoinf ijtbtipoinf) {
        this.ijtbtipoinf = ijtbtipoinf;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijclassificinf)) return false;
        Ijclassificinf other = (Ijclassificinf) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijselitensarqs==null && other.getIjselitensarqs()==null) || 
             (this.ijselitensarqs!=null &&
              java.util.Arrays.equals(this.ijselitensarqs, other.getIjselitensarqs()))) &&
            ((this.ijtbinf==null && other.getIjtbinf()==null) || 
             (this.ijtbinf!=null &&
              this.ijtbinf.equals(other.getIjtbinf()))) &&
            ((this.ijtbtipoinf==null && other.getIjtbtipoinf()==null) || 
             (this.ijtbtipoinf!=null &&
              this.ijtbtipoinf.equals(other.getIjtbtipoinf())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjselitensarqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjselitensarqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjselitensarqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbinf() != null) {
            _hashCode += getIjtbinf().hashCode();
        }
        if (getIjtbtipoinf() != null) {
            _hashCode += getIjtbtipoinf().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijclassificinf.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijclassificinf"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijclassificinfId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijselitensarqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijselitensarqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijselitensarq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinf"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbtipoinf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbtipoinf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtipoinf"));
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
