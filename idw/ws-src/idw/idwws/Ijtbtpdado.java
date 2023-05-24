/**
 * Ijtbtpdado.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbtpdado  implements java.io.Serializable {
    private java.lang.String cdtpdado;

    private java.lang.String dstpdado;

    private idw.idwws.Ijtbesttab[] ijtbesttabs;

    private java.lang.String mascara;

    public Ijtbtpdado() {
    }

    public Ijtbtpdado(
           java.lang.String cdtpdado,
           java.lang.String dstpdado,
           idw.idwws.Ijtbesttab[] ijtbesttabs,
           java.lang.String mascara) {
           this.cdtpdado = cdtpdado;
           this.dstpdado = dstpdado;
           this.ijtbesttabs = ijtbesttabs;
           this.mascara = mascara;
    }


    /**
     * Gets the cdtpdado value for this Ijtbtpdado.
     * 
     * @return cdtpdado
     */
    public java.lang.String getCdtpdado() {
        return cdtpdado;
    }


    /**
     * Sets the cdtpdado value for this Ijtbtpdado.
     * 
     * @param cdtpdado
     */
    public void setCdtpdado(java.lang.String cdtpdado) {
        this.cdtpdado = cdtpdado;
    }


    /**
     * Gets the dstpdado value for this Ijtbtpdado.
     * 
     * @return dstpdado
     */
    public java.lang.String getDstpdado() {
        return dstpdado;
    }


    /**
     * Sets the dstpdado value for this Ijtbtpdado.
     * 
     * @param dstpdado
     */
    public void setDstpdado(java.lang.String dstpdado) {
        this.dstpdado = dstpdado;
    }


    /**
     * Gets the ijtbesttabs value for this Ijtbtpdado.
     * 
     * @return ijtbesttabs
     */
    public idw.idwws.Ijtbesttab[] getIjtbesttabs() {
        return ijtbesttabs;
    }


    /**
     * Sets the ijtbesttabs value for this Ijtbtpdado.
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


    /**
     * Gets the mascara value for this Ijtbtpdado.
     * 
     * @return mascara
     */
    public java.lang.String getMascara() {
        return mascara;
    }


    /**
     * Sets the mascara value for this Ijtbtpdado.
     * 
     * @param mascara
     */
    public void setMascara(java.lang.String mascara) {
        this.mascara = mascara;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbtpdado)) return false;
        Ijtbtpdado other = (Ijtbtpdado) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdtpdado==null && other.getCdtpdado()==null) || 
             (this.cdtpdado!=null &&
              this.cdtpdado.equals(other.getCdtpdado()))) &&
            ((this.dstpdado==null && other.getDstpdado()==null) || 
             (this.dstpdado!=null &&
              this.dstpdado.equals(other.getDstpdado()))) &&
            ((this.ijtbesttabs==null && other.getIjtbesttabs()==null) || 
             (this.ijtbesttabs!=null &&
              java.util.Arrays.equals(this.ijtbesttabs, other.getIjtbesttabs()))) &&
            ((this.mascara==null && other.getMascara()==null) || 
             (this.mascara!=null &&
              this.mascara.equals(other.getMascara())));
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
        if (getCdtpdado() != null) {
            _hashCode += getCdtpdado().hashCode();
        }
        if (getDstpdado() != null) {
            _hashCode += getDstpdado().hashCode();
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
        if (getMascara() != null) {
            _hashCode += getMascara().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbtpdado.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtpdado"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtpdado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtpdado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dstpdado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dstpdado"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mascara");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mascara"));
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
