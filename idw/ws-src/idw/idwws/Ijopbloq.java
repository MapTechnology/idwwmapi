/**
 * Ijopbloq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijopbloq  implements java.io.Serializable {
    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijopbloqdet[] ijopbloqdets;

    private java.lang.String nrop;

    private org.apache.axis.types.UnsignedShort stbloqueio;

    public Ijopbloq() {
    }

    public Ijopbloq(
           idw.idwws.Ijop ijop,
           idw.idwws.Ijopbloqdet[] ijopbloqdets,
           java.lang.String nrop,
           org.apache.axis.types.UnsignedShort stbloqueio) {
           this.ijop = ijop;
           this.ijopbloqdets = ijopbloqdets;
           this.nrop = nrop;
           this.stbloqueio = stbloqueio;
    }


    /**
     * Gets the ijop value for this Ijopbloq.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijopbloq.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijopbloqdets value for this Ijopbloq.
     * 
     * @return ijopbloqdets
     */
    public idw.idwws.Ijopbloqdet[] getIjopbloqdets() {
        return ijopbloqdets;
    }


    /**
     * Sets the ijopbloqdets value for this Ijopbloq.
     * 
     * @param ijopbloqdets
     */
    public void setIjopbloqdets(idw.idwws.Ijopbloqdet[] ijopbloqdets) {
        this.ijopbloqdets = ijopbloqdets;
    }

    public idw.idwws.Ijopbloqdet getIjopbloqdets(int i) {
        return this.ijopbloqdets[i];
    }

    public void setIjopbloqdets(int i, idw.idwws.Ijopbloqdet _value) {
        this.ijopbloqdets[i] = _value;
    }


    /**
     * Gets the nrop value for this Ijopbloq.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this Ijopbloq.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }


    /**
     * Gets the stbloqueio value for this Ijopbloq.
     * 
     * @return stbloqueio
     */
    public org.apache.axis.types.UnsignedShort getStbloqueio() {
        return stbloqueio;
    }


    /**
     * Sets the stbloqueio value for this Ijopbloq.
     * 
     * @param stbloqueio
     */
    public void setStbloqueio(org.apache.axis.types.UnsignedShort stbloqueio) {
        this.stbloqueio = stbloqueio;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijopbloq)) return false;
        Ijopbloq other = (Ijopbloq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijopbloqdets==null && other.getIjopbloqdets()==null) || 
             (this.ijopbloqdets!=null &&
              java.util.Arrays.equals(this.ijopbloqdets, other.getIjopbloqdets()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop()))) &&
            ((this.stbloqueio==null && other.getStbloqueio()==null) || 
             (this.stbloqueio!=null &&
              this.stbloqueio.equals(other.getStbloqueio())));
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
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjopbloqdets() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjopbloqdets());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjopbloqdets(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        if (getStbloqueio() != null) {
            _hashCode += getStbloqueio().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijopbloq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopbloq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopbloqdets");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopbloqdets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopbloqdet"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stbloqueio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stbloqueio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
