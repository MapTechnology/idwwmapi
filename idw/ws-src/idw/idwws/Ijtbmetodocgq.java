/**
 * Ijtbmetodocgq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbmetodocgq  implements java.io.Serializable {
    private java.lang.String idmetodo;

    private idw.idwws.Ijespecinsppro[] ijespecinsppros;

    private idw.idwws.Ijespecinsproatrib[] ijespecinsproatribs;

    public Ijtbmetodocgq() {
    }

    public Ijtbmetodocgq(
           java.lang.String idmetodo,
           idw.idwws.Ijespecinsppro[] ijespecinsppros,
           idw.idwws.Ijespecinsproatrib[] ijespecinsproatribs) {
           this.idmetodo = idmetodo;
           this.ijespecinsppros = ijespecinsppros;
           this.ijespecinsproatribs = ijespecinsproatribs;
    }


    /**
     * Gets the idmetodo value for this Ijtbmetodocgq.
     * 
     * @return idmetodo
     */
    public java.lang.String getIdmetodo() {
        return idmetodo;
    }


    /**
     * Sets the idmetodo value for this Ijtbmetodocgq.
     * 
     * @param idmetodo
     */
    public void setIdmetodo(java.lang.String idmetodo) {
        this.idmetodo = idmetodo;
    }


    /**
     * Gets the ijespecinsppros value for this Ijtbmetodocgq.
     * 
     * @return ijespecinsppros
     */
    public idw.idwws.Ijespecinsppro[] getIjespecinsppros() {
        return ijespecinsppros;
    }


    /**
     * Sets the ijespecinsppros value for this Ijtbmetodocgq.
     * 
     * @param ijespecinsppros
     */
    public void setIjespecinsppros(idw.idwws.Ijespecinsppro[] ijespecinsppros) {
        this.ijespecinsppros = ijespecinsppros;
    }

    public idw.idwws.Ijespecinsppro getIjespecinsppros(int i) {
        return this.ijespecinsppros[i];
    }

    public void setIjespecinsppros(int i, idw.idwws.Ijespecinsppro _value) {
        this.ijespecinsppros[i] = _value;
    }


    /**
     * Gets the ijespecinsproatribs value for this Ijtbmetodocgq.
     * 
     * @return ijespecinsproatribs
     */
    public idw.idwws.Ijespecinsproatrib[] getIjespecinsproatribs() {
        return ijespecinsproatribs;
    }


    /**
     * Sets the ijespecinsproatribs value for this Ijtbmetodocgq.
     * 
     * @param ijespecinsproatribs
     */
    public void setIjespecinsproatribs(idw.idwws.Ijespecinsproatrib[] ijespecinsproatribs) {
        this.ijespecinsproatribs = ijespecinsproatribs;
    }

    public idw.idwws.Ijespecinsproatrib getIjespecinsproatribs(int i) {
        return this.ijespecinsproatribs[i];
    }

    public void setIjespecinsproatribs(int i, idw.idwws.Ijespecinsproatrib _value) {
        this.ijespecinsproatribs[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbmetodocgq)) return false;
        Ijtbmetodocgq other = (Ijtbmetodocgq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idmetodo==null && other.getIdmetodo()==null) || 
             (this.idmetodo!=null &&
              this.idmetodo.equals(other.getIdmetodo()))) &&
            ((this.ijespecinsppros==null && other.getIjespecinsppros()==null) || 
             (this.ijespecinsppros!=null &&
              java.util.Arrays.equals(this.ijespecinsppros, other.getIjespecinsppros()))) &&
            ((this.ijespecinsproatribs==null && other.getIjespecinsproatribs()==null) || 
             (this.ijespecinsproatribs!=null &&
              java.util.Arrays.equals(this.ijespecinsproatribs, other.getIjespecinsproatribs())));
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
        if (getIdmetodo() != null) {
            _hashCode += getIdmetodo().hashCode();
        }
        if (getIjespecinsppros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjespecinsppros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjespecinsppros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjespecinsproatribs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjespecinsproatribs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjespecinsproatribs(), i);
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
        new org.apache.axis.description.TypeDesc(Ijtbmetodocgq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmetodocgq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idmetodo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idmetodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijespecinsppros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijespecinsppros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijespecinsppro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijespecinsproatribs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijespecinsproatribs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijespecinsproatrib"));
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
