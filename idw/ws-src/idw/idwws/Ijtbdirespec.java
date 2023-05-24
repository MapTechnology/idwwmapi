/**
 * Ijtbdirespec.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbdirespec  implements java.io.Serializable {
    private java.lang.String cdfuncao;

    private java.lang.String dsfuncao;

    private idw.idwws.Ijusudirespec[] ijusudirespecs;

    private org.apache.axis.types.UnsignedShort stfuncao;

    public Ijtbdirespec() {
    }

    public Ijtbdirespec(
           java.lang.String cdfuncao,
           java.lang.String dsfuncao,
           idw.idwws.Ijusudirespec[] ijusudirespecs,
           org.apache.axis.types.UnsignedShort stfuncao) {
           this.cdfuncao = cdfuncao;
           this.dsfuncao = dsfuncao;
           this.ijusudirespecs = ijusudirespecs;
           this.stfuncao = stfuncao;
    }


    /**
     * Gets the cdfuncao value for this Ijtbdirespec.
     * 
     * @return cdfuncao
     */
    public java.lang.String getCdfuncao() {
        return cdfuncao;
    }


    /**
     * Sets the cdfuncao value for this Ijtbdirespec.
     * 
     * @param cdfuncao
     */
    public void setCdfuncao(java.lang.String cdfuncao) {
        this.cdfuncao = cdfuncao;
    }


    /**
     * Gets the dsfuncao value for this Ijtbdirespec.
     * 
     * @return dsfuncao
     */
    public java.lang.String getDsfuncao() {
        return dsfuncao;
    }


    /**
     * Sets the dsfuncao value for this Ijtbdirespec.
     * 
     * @param dsfuncao
     */
    public void setDsfuncao(java.lang.String dsfuncao) {
        this.dsfuncao = dsfuncao;
    }


    /**
     * Gets the ijusudirespecs value for this Ijtbdirespec.
     * 
     * @return ijusudirespecs
     */
    public idw.idwws.Ijusudirespec[] getIjusudirespecs() {
        return ijusudirespecs;
    }


    /**
     * Sets the ijusudirespecs value for this Ijtbdirespec.
     * 
     * @param ijusudirespecs
     */
    public void setIjusudirespecs(idw.idwws.Ijusudirespec[] ijusudirespecs) {
        this.ijusudirespecs = ijusudirespecs;
    }

    public idw.idwws.Ijusudirespec getIjusudirespecs(int i) {
        return this.ijusudirespecs[i];
    }

    public void setIjusudirespecs(int i, idw.idwws.Ijusudirespec _value) {
        this.ijusudirespecs[i] = _value;
    }


    /**
     * Gets the stfuncao value for this Ijtbdirespec.
     * 
     * @return stfuncao
     */
    public org.apache.axis.types.UnsignedShort getStfuncao() {
        return stfuncao;
    }


    /**
     * Sets the stfuncao value for this Ijtbdirespec.
     * 
     * @param stfuncao
     */
    public void setStfuncao(org.apache.axis.types.UnsignedShort stfuncao) {
        this.stfuncao = stfuncao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbdirespec)) return false;
        Ijtbdirespec other = (Ijtbdirespec) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdfuncao==null && other.getCdfuncao()==null) || 
             (this.cdfuncao!=null &&
              this.cdfuncao.equals(other.getCdfuncao()))) &&
            ((this.dsfuncao==null && other.getDsfuncao()==null) || 
             (this.dsfuncao!=null &&
              this.dsfuncao.equals(other.getDsfuncao()))) &&
            ((this.ijusudirespecs==null && other.getIjusudirespecs()==null) || 
             (this.ijusudirespecs!=null &&
              java.util.Arrays.equals(this.ijusudirespecs, other.getIjusudirespecs()))) &&
            ((this.stfuncao==null && other.getStfuncao()==null) || 
             (this.stfuncao!=null &&
              this.stfuncao.equals(other.getStfuncao())));
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
        if (getCdfuncao() != null) {
            _hashCode += getCdfuncao().hashCode();
        }
        if (getDsfuncao() != null) {
            _hashCode += getDsfuncao().hashCode();
        }
        if (getIjusudirespecs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjusudirespecs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjusudirespecs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStfuncao() != null) {
            _hashCode += getStfuncao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbdirespec.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbdirespec"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdfuncao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdfuncao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsfuncao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsfuncao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijusudirespecs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijusudirespecs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijusudirespec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stfuncao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stfuncao"));
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
