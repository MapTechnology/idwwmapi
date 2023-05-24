/**
 * Ijgrpref.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrpref  implements java.io.Serializable {
    private java.lang.String cdgruporef;

    private java.lang.String dsgruporef;

    private idw.idwws.Ijgrpdetref[] ijgrpdetrefs;

    private idw.idwws.Ijgrpinjref[] ijgrpinjrefs;

    public Ijgrpref() {
    }

    public Ijgrpref(
           java.lang.String cdgruporef,
           java.lang.String dsgruporef,
           idw.idwws.Ijgrpdetref[] ijgrpdetrefs,
           idw.idwws.Ijgrpinjref[] ijgrpinjrefs) {
           this.cdgruporef = cdgruporef;
           this.dsgruporef = dsgruporef;
           this.ijgrpdetrefs = ijgrpdetrefs;
           this.ijgrpinjrefs = ijgrpinjrefs;
    }


    /**
     * Gets the cdgruporef value for this Ijgrpref.
     * 
     * @return cdgruporef
     */
    public java.lang.String getCdgruporef() {
        return cdgruporef;
    }


    /**
     * Sets the cdgruporef value for this Ijgrpref.
     * 
     * @param cdgruporef
     */
    public void setCdgruporef(java.lang.String cdgruporef) {
        this.cdgruporef = cdgruporef;
    }


    /**
     * Gets the dsgruporef value for this Ijgrpref.
     * 
     * @return dsgruporef
     */
    public java.lang.String getDsgruporef() {
        return dsgruporef;
    }


    /**
     * Sets the dsgruporef value for this Ijgrpref.
     * 
     * @param dsgruporef
     */
    public void setDsgruporef(java.lang.String dsgruporef) {
        this.dsgruporef = dsgruporef;
    }


    /**
     * Gets the ijgrpdetrefs value for this Ijgrpref.
     * 
     * @return ijgrpdetrefs
     */
    public idw.idwws.Ijgrpdetref[] getIjgrpdetrefs() {
        return ijgrpdetrefs;
    }


    /**
     * Sets the ijgrpdetrefs value for this Ijgrpref.
     * 
     * @param ijgrpdetrefs
     */
    public void setIjgrpdetrefs(idw.idwws.Ijgrpdetref[] ijgrpdetrefs) {
        this.ijgrpdetrefs = ijgrpdetrefs;
    }

    public idw.idwws.Ijgrpdetref getIjgrpdetrefs(int i) {
        return this.ijgrpdetrefs[i];
    }

    public void setIjgrpdetrefs(int i, idw.idwws.Ijgrpdetref _value) {
        this.ijgrpdetrefs[i] = _value;
    }


    /**
     * Gets the ijgrpinjrefs value for this Ijgrpref.
     * 
     * @return ijgrpinjrefs
     */
    public idw.idwws.Ijgrpinjref[] getIjgrpinjrefs() {
        return ijgrpinjrefs;
    }


    /**
     * Sets the ijgrpinjrefs value for this Ijgrpref.
     * 
     * @param ijgrpinjrefs
     */
    public void setIjgrpinjrefs(idw.idwws.Ijgrpinjref[] ijgrpinjrefs) {
        this.ijgrpinjrefs = ijgrpinjrefs;
    }

    public idw.idwws.Ijgrpinjref getIjgrpinjrefs(int i) {
        return this.ijgrpinjrefs[i];
    }

    public void setIjgrpinjrefs(int i, idw.idwws.Ijgrpinjref _value) {
        this.ijgrpinjrefs[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrpref)) return false;
        Ijgrpref other = (Ijgrpref) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgruporef==null && other.getCdgruporef()==null) || 
             (this.cdgruporef!=null &&
              this.cdgruporef.equals(other.getCdgruporef()))) &&
            ((this.dsgruporef==null && other.getDsgruporef()==null) || 
             (this.dsgruporef!=null &&
              this.dsgruporef.equals(other.getDsgruporef()))) &&
            ((this.ijgrpdetrefs==null && other.getIjgrpdetrefs()==null) || 
             (this.ijgrpdetrefs!=null &&
              java.util.Arrays.equals(this.ijgrpdetrefs, other.getIjgrpdetrefs()))) &&
            ((this.ijgrpinjrefs==null && other.getIjgrpinjrefs()==null) || 
             (this.ijgrpinjrefs!=null &&
              java.util.Arrays.equals(this.ijgrpinjrefs, other.getIjgrpinjrefs())));
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
        if (getCdgruporef() != null) {
            _hashCode += getCdgruporef().hashCode();
        }
        if (getDsgruporef() != null) {
            _hashCode += getDsgruporef().hashCode();
        }
        if (getIjgrpdetrefs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpdetrefs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpdetrefs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjgrpinjrefs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpinjrefs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpinjrefs(), i);
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
        new org.apache.axis.description.TypeDesc(Ijgrpref.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpref"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgruporef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgruporef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsgruporef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsgruporef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpdetrefs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpdetrefs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetref"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpinjrefs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpinjrefs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpinjref"));
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
