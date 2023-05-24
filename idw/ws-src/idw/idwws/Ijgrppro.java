/**
 * Ijgrppro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrppro  implements java.io.Serializable {
    private java.lang.String cdgrppro;

    private java.lang.String dsgrppro;

    private idw.idwws.Ijgrpdetprocgq[] ijgrpdetprocgqs;

    private idw.idwws.Ijgrpdetpro[] ijgrpdetpros;

    private java.math.BigDecimal tmpsetup;

    public Ijgrppro() {
    }

    public Ijgrppro(
           java.lang.String cdgrppro,
           java.lang.String dsgrppro,
           idw.idwws.Ijgrpdetprocgq[] ijgrpdetprocgqs,
           idw.idwws.Ijgrpdetpro[] ijgrpdetpros,
           java.math.BigDecimal tmpsetup) {
           this.cdgrppro = cdgrppro;
           this.dsgrppro = dsgrppro;
           this.ijgrpdetprocgqs = ijgrpdetprocgqs;
           this.ijgrpdetpros = ijgrpdetpros;
           this.tmpsetup = tmpsetup;
    }


    /**
     * Gets the cdgrppro value for this Ijgrppro.
     * 
     * @return cdgrppro
     */
    public java.lang.String getCdgrppro() {
        return cdgrppro;
    }


    /**
     * Sets the cdgrppro value for this Ijgrppro.
     * 
     * @param cdgrppro
     */
    public void setCdgrppro(java.lang.String cdgrppro) {
        this.cdgrppro = cdgrppro;
    }


    /**
     * Gets the dsgrppro value for this Ijgrppro.
     * 
     * @return dsgrppro
     */
    public java.lang.String getDsgrppro() {
        return dsgrppro;
    }


    /**
     * Sets the dsgrppro value for this Ijgrppro.
     * 
     * @param dsgrppro
     */
    public void setDsgrppro(java.lang.String dsgrppro) {
        this.dsgrppro = dsgrppro;
    }


    /**
     * Gets the ijgrpdetprocgqs value for this Ijgrppro.
     * 
     * @return ijgrpdetprocgqs
     */
    public idw.idwws.Ijgrpdetprocgq[] getIjgrpdetprocgqs() {
        return ijgrpdetprocgqs;
    }


    /**
     * Sets the ijgrpdetprocgqs value for this Ijgrppro.
     * 
     * @param ijgrpdetprocgqs
     */
    public void setIjgrpdetprocgqs(idw.idwws.Ijgrpdetprocgq[] ijgrpdetprocgqs) {
        this.ijgrpdetprocgqs = ijgrpdetprocgqs;
    }

    public idw.idwws.Ijgrpdetprocgq getIjgrpdetprocgqs(int i) {
        return this.ijgrpdetprocgqs[i];
    }

    public void setIjgrpdetprocgqs(int i, idw.idwws.Ijgrpdetprocgq _value) {
        this.ijgrpdetprocgqs[i] = _value;
    }


    /**
     * Gets the ijgrpdetpros value for this Ijgrppro.
     * 
     * @return ijgrpdetpros
     */
    public idw.idwws.Ijgrpdetpro[] getIjgrpdetpros() {
        return ijgrpdetpros;
    }


    /**
     * Sets the ijgrpdetpros value for this Ijgrppro.
     * 
     * @param ijgrpdetpros
     */
    public void setIjgrpdetpros(idw.idwws.Ijgrpdetpro[] ijgrpdetpros) {
        this.ijgrpdetpros = ijgrpdetpros;
    }

    public idw.idwws.Ijgrpdetpro getIjgrpdetpros(int i) {
        return this.ijgrpdetpros[i];
    }

    public void setIjgrpdetpros(int i, idw.idwws.Ijgrpdetpro _value) {
        this.ijgrpdetpros[i] = _value;
    }


    /**
     * Gets the tmpsetup value for this Ijgrppro.
     * 
     * @return tmpsetup
     */
    public java.math.BigDecimal getTmpsetup() {
        return tmpsetup;
    }


    /**
     * Sets the tmpsetup value for this Ijgrppro.
     * 
     * @param tmpsetup
     */
    public void setTmpsetup(java.math.BigDecimal tmpsetup) {
        this.tmpsetup = tmpsetup;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrppro)) return false;
        Ijgrppro other = (Ijgrppro) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgrppro==null && other.getCdgrppro()==null) || 
             (this.cdgrppro!=null &&
              this.cdgrppro.equals(other.getCdgrppro()))) &&
            ((this.dsgrppro==null && other.getDsgrppro()==null) || 
             (this.dsgrppro!=null &&
              this.dsgrppro.equals(other.getDsgrppro()))) &&
            ((this.ijgrpdetprocgqs==null && other.getIjgrpdetprocgqs()==null) || 
             (this.ijgrpdetprocgqs!=null &&
              java.util.Arrays.equals(this.ijgrpdetprocgqs, other.getIjgrpdetprocgqs()))) &&
            ((this.ijgrpdetpros==null && other.getIjgrpdetpros()==null) || 
             (this.ijgrpdetpros!=null &&
              java.util.Arrays.equals(this.ijgrpdetpros, other.getIjgrpdetpros()))) &&
            ((this.tmpsetup==null && other.getTmpsetup()==null) || 
             (this.tmpsetup!=null &&
              this.tmpsetup.equals(other.getTmpsetup())));
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
        if (getCdgrppro() != null) {
            _hashCode += getCdgrppro().hashCode();
        }
        if (getDsgrppro() != null) {
            _hashCode += getDsgrppro().hashCode();
        }
        if (getIjgrpdetprocgqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpdetprocgqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpdetprocgqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjgrpdetpros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpdetpros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpdetpros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTmpsetup() != null) {
            _hashCode += getTmpsetup().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgrppro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrppro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgrppro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgrppro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsgrppro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsgrppro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpdetprocgqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpdetprocgqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetprocgq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpdetpros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpdetpros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmpsetup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmpsetup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
