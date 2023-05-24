/**
 * Ijtbgru.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbgru  implements java.io.Serializable {
    private java.lang.String cdgrupo;

    private java.lang.String dsgrupo;

    private idw.idwws.Ijdirace[] ijdiraces;

    private idw.idwws.Ijgruusu[] ijgruusus;

    public Ijtbgru() {
    }

    public Ijtbgru(
           java.lang.String cdgrupo,
           java.lang.String dsgrupo,
           idw.idwws.Ijdirace[] ijdiraces,
           idw.idwws.Ijgruusu[] ijgruusus) {
           this.cdgrupo = cdgrupo;
           this.dsgrupo = dsgrupo;
           this.ijdiraces = ijdiraces;
           this.ijgruusus = ijgruusus;
    }


    /**
     * Gets the cdgrupo value for this Ijtbgru.
     * 
     * @return cdgrupo
     */
    public java.lang.String getCdgrupo() {
        return cdgrupo;
    }


    /**
     * Sets the cdgrupo value for this Ijtbgru.
     * 
     * @param cdgrupo
     */
    public void setCdgrupo(java.lang.String cdgrupo) {
        this.cdgrupo = cdgrupo;
    }


    /**
     * Gets the dsgrupo value for this Ijtbgru.
     * 
     * @return dsgrupo
     */
    public java.lang.String getDsgrupo() {
        return dsgrupo;
    }


    /**
     * Sets the dsgrupo value for this Ijtbgru.
     * 
     * @param dsgrupo
     */
    public void setDsgrupo(java.lang.String dsgrupo) {
        this.dsgrupo = dsgrupo;
    }


    /**
     * Gets the ijdiraces value for this Ijtbgru.
     * 
     * @return ijdiraces
     */
    public idw.idwws.Ijdirace[] getIjdiraces() {
        return ijdiraces;
    }


    /**
     * Sets the ijdiraces value for this Ijtbgru.
     * 
     * @param ijdiraces
     */
    public void setIjdiraces(idw.idwws.Ijdirace[] ijdiraces) {
        this.ijdiraces = ijdiraces;
    }

    public idw.idwws.Ijdirace getIjdiraces(int i) {
        return this.ijdiraces[i];
    }

    public void setIjdiraces(int i, idw.idwws.Ijdirace _value) {
        this.ijdiraces[i] = _value;
    }


    /**
     * Gets the ijgruusus value for this Ijtbgru.
     * 
     * @return ijgruusus
     */
    public idw.idwws.Ijgruusu[] getIjgruusus() {
        return ijgruusus;
    }


    /**
     * Sets the ijgruusus value for this Ijtbgru.
     * 
     * @param ijgruusus
     */
    public void setIjgruusus(idw.idwws.Ijgruusu[] ijgruusus) {
        this.ijgruusus = ijgruusus;
    }

    public idw.idwws.Ijgruusu getIjgruusus(int i) {
        return this.ijgruusus[i];
    }

    public void setIjgruusus(int i, idw.idwws.Ijgruusu _value) {
        this.ijgruusus[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbgru)) return false;
        Ijtbgru other = (Ijtbgru) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgrupo==null && other.getCdgrupo()==null) || 
             (this.cdgrupo!=null &&
              this.cdgrupo.equals(other.getCdgrupo()))) &&
            ((this.dsgrupo==null && other.getDsgrupo()==null) || 
             (this.dsgrupo!=null &&
              this.dsgrupo.equals(other.getDsgrupo()))) &&
            ((this.ijdiraces==null && other.getIjdiraces()==null) || 
             (this.ijdiraces!=null &&
              java.util.Arrays.equals(this.ijdiraces, other.getIjdiraces()))) &&
            ((this.ijgruusus==null && other.getIjgruusus()==null) || 
             (this.ijgruusus!=null &&
              java.util.Arrays.equals(this.ijgruusus, other.getIjgruusus())));
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
        if (getCdgrupo() != null) {
            _hashCode += getCdgrupo().hashCode();
        }
        if (getDsgrupo() != null) {
            _hashCode += getDsgrupo().hashCode();
        }
        if (getIjdiraces() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjdiraces());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjdiraces(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjgruusus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgruusus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgruusus(), i);
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
        new org.apache.axis.description.TypeDesc(Ijtbgru.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbgru"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgrupo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgrupo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsgrupo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsgrupo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijdiraces");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijdiraces"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdirace"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgruusus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgruusus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgruusu"));
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
