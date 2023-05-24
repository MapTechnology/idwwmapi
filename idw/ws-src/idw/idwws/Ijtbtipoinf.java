/**
 * Ijtbtipoinf.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbtipoinf  implements java.io.Serializable {
    private java.lang.String cdinterno;

    private java.lang.String cdtipoinf;

    private java.lang.String dstipoinf;

    private idw.idwws.Ijclassificcont[] ijclassificconts;

    private idw.idwws.Ijclassificinf[] ijclassificinfs;

    private java.lang.String nomeicone;

    public Ijtbtipoinf() {
    }

    public Ijtbtipoinf(
           java.lang.String cdinterno,
           java.lang.String cdtipoinf,
           java.lang.String dstipoinf,
           idw.idwws.Ijclassificcont[] ijclassificconts,
           idw.idwws.Ijclassificinf[] ijclassificinfs,
           java.lang.String nomeicone) {
           this.cdinterno = cdinterno;
           this.cdtipoinf = cdtipoinf;
           this.dstipoinf = dstipoinf;
           this.ijclassificconts = ijclassificconts;
           this.ijclassificinfs = ijclassificinfs;
           this.nomeicone = nomeicone;
    }


    /**
     * Gets the cdinterno value for this Ijtbtipoinf.
     * 
     * @return cdinterno
     */
    public java.lang.String getCdinterno() {
        return cdinterno;
    }


    /**
     * Sets the cdinterno value for this Ijtbtipoinf.
     * 
     * @param cdinterno
     */
    public void setCdinterno(java.lang.String cdinterno) {
        this.cdinterno = cdinterno;
    }


    /**
     * Gets the cdtipoinf value for this Ijtbtipoinf.
     * 
     * @return cdtipoinf
     */
    public java.lang.String getCdtipoinf() {
        return cdtipoinf;
    }


    /**
     * Sets the cdtipoinf value for this Ijtbtipoinf.
     * 
     * @param cdtipoinf
     */
    public void setCdtipoinf(java.lang.String cdtipoinf) {
        this.cdtipoinf = cdtipoinf;
    }


    /**
     * Gets the dstipoinf value for this Ijtbtipoinf.
     * 
     * @return dstipoinf
     */
    public java.lang.String getDstipoinf() {
        return dstipoinf;
    }


    /**
     * Sets the dstipoinf value for this Ijtbtipoinf.
     * 
     * @param dstipoinf
     */
    public void setDstipoinf(java.lang.String dstipoinf) {
        this.dstipoinf = dstipoinf;
    }


    /**
     * Gets the ijclassificconts value for this Ijtbtipoinf.
     * 
     * @return ijclassificconts
     */
    public idw.idwws.Ijclassificcont[] getIjclassificconts() {
        return ijclassificconts;
    }


    /**
     * Sets the ijclassificconts value for this Ijtbtipoinf.
     * 
     * @param ijclassificconts
     */
    public void setIjclassificconts(idw.idwws.Ijclassificcont[] ijclassificconts) {
        this.ijclassificconts = ijclassificconts;
    }

    public idw.idwws.Ijclassificcont getIjclassificconts(int i) {
        return this.ijclassificconts[i];
    }

    public void setIjclassificconts(int i, idw.idwws.Ijclassificcont _value) {
        this.ijclassificconts[i] = _value;
    }


    /**
     * Gets the ijclassificinfs value for this Ijtbtipoinf.
     * 
     * @return ijclassificinfs
     */
    public idw.idwws.Ijclassificinf[] getIjclassificinfs() {
        return ijclassificinfs;
    }


    /**
     * Sets the ijclassificinfs value for this Ijtbtipoinf.
     * 
     * @param ijclassificinfs
     */
    public void setIjclassificinfs(idw.idwws.Ijclassificinf[] ijclassificinfs) {
        this.ijclassificinfs = ijclassificinfs;
    }

    public idw.idwws.Ijclassificinf getIjclassificinfs(int i) {
        return this.ijclassificinfs[i];
    }

    public void setIjclassificinfs(int i, idw.idwws.Ijclassificinf _value) {
        this.ijclassificinfs[i] = _value;
    }


    /**
     * Gets the nomeicone value for this Ijtbtipoinf.
     * 
     * @return nomeicone
     */
    public java.lang.String getNomeicone() {
        return nomeicone;
    }


    /**
     * Sets the nomeicone value for this Ijtbtipoinf.
     * 
     * @param nomeicone
     */
    public void setNomeicone(java.lang.String nomeicone) {
        this.nomeicone = nomeicone;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbtipoinf)) return false;
        Ijtbtipoinf other = (Ijtbtipoinf) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdinterno==null && other.getCdinterno()==null) || 
             (this.cdinterno!=null &&
              this.cdinterno.equals(other.getCdinterno()))) &&
            ((this.cdtipoinf==null && other.getCdtipoinf()==null) || 
             (this.cdtipoinf!=null &&
              this.cdtipoinf.equals(other.getCdtipoinf()))) &&
            ((this.dstipoinf==null && other.getDstipoinf()==null) || 
             (this.dstipoinf!=null &&
              this.dstipoinf.equals(other.getDstipoinf()))) &&
            ((this.ijclassificconts==null && other.getIjclassificconts()==null) || 
             (this.ijclassificconts!=null &&
              java.util.Arrays.equals(this.ijclassificconts, other.getIjclassificconts()))) &&
            ((this.ijclassificinfs==null && other.getIjclassificinfs()==null) || 
             (this.ijclassificinfs!=null &&
              java.util.Arrays.equals(this.ijclassificinfs, other.getIjclassificinfs()))) &&
            ((this.nomeicone==null && other.getNomeicone()==null) || 
             (this.nomeicone!=null &&
              this.nomeicone.equals(other.getNomeicone())));
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
        if (getCdinterno() != null) {
            _hashCode += getCdinterno().hashCode();
        }
        if (getCdtipoinf() != null) {
            _hashCode += getCdtipoinf().hashCode();
        }
        if (getDstipoinf() != null) {
            _hashCode += getDstipoinf().hashCode();
        }
        if (getIjclassificconts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjclassificconts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjclassificconts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjclassificinfs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjclassificinfs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjclassificinfs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNomeicone() != null) {
            _hashCode += getNomeicone().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbtipoinf.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtipoinf"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinterno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinterno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtipoinf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtipoinf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dstipoinf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dstipoinf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijclassificconts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijclassificconts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijclassificcont"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijclassificinfs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijclassificinfs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijclassificinf"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeicone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nomeicone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
