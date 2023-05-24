/**
 * Ijtbtab.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbtab  implements java.io.Serializable {
    private java.lang.String cdtabela;

    private java.lang.String dstabela;

    private idw.idwws.Ijtbesttab[] ijtbesttabs;

    public Ijtbtab() {
    }

    public Ijtbtab(
           java.lang.String cdtabela,
           java.lang.String dstabela,
           idw.idwws.Ijtbesttab[] ijtbesttabs) {
           this.cdtabela = cdtabela;
           this.dstabela = dstabela;
           this.ijtbesttabs = ijtbesttabs;
    }


    /**
     * Gets the cdtabela value for this Ijtbtab.
     * 
     * @return cdtabela
     */
    public java.lang.String getCdtabela() {
        return cdtabela;
    }


    /**
     * Sets the cdtabela value for this Ijtbtab.
     * 
     * @param cdtabela
     */
    public void setCdtabela(java.lang.String cdtabela) {
        this.cdtabela = cdtabela;
    }


    /**
     * Gets the dstabela value for this Ijtbtab.
     * 
     * @return dstabela
     */
    public java.lang.String getDstabela() {
        return dstabela;
    }


    /**
     * Sets the dstabela value for this Ijtbtab.
     * 
     * @param dstabela
     */
    public void setDstabela(java.lang.String dstabela) {
        this.dstabela = dstabela;
    }


    /**
     * Gets the ijtbesttabs value for this Ijtbtab.
     * 
     * @return ijtbesttabs
     */
    public idw.idwws.Ijtbesttab[] getIjtbesttabs() {
        return ijtbesttabs;
    }


    /**
     * Sets the ijtbesttabs value for this Ijtbtab.
     * 
     * @param ijtbesttabs
     */
    public void setIjtbesttabs(idw.idwws.Ijtbesttab[] ijtbesttabs) {
        this.ijtbesttabs = ijtbesttabs;
    }

    public idw.idwws.Ijtbesttab getIjtbesttabs(int i) {
        return this.ijtbesttabs[i];
    }

    public void setIjtbesttabs(int i, idw.idwws.Ijtbesttab _value) {
        this.ijtbesttabs[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbtab)) return false;
        Ijtbtab other = (Ijtbtab) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdtabela==null && other.getCdtabela()==null) || 
             (this.cdtabela!=null &&
              this.cdtabela.equals(other.getCdtabela()))) &&
            ((this.dstabela==null && other.getDstabela()==null) || 
             (this.dstabela!=null &&
              this.dstabela.equals(other.getDstabela()))) &&
            ((this.ijtbesttabs==null && other.getIjtbesttabs()==null) || 
             (this.ijtbesttabs!=null &&
              java.util.Arrays.equals(this.ijtbesttabs, other.getIjtbesttabs())));
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
        if (getCdtabela() != null) {
            _hashCode += getCdtabela().hashCode();
        }
        if (getDstabela() != null) {
            _hashCode += getDstabela().hashCode();
        }
        if (getIjtbesttabs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbesttabs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbesttabs(), i);
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
        new org.apache.axis.description.TypeDesc(Ijtbtab.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtab"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtabela");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtabela"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dstabela");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dstabela"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbesttabs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbesttabs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbesttab"));
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
