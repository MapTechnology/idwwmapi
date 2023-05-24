/**
 * Ijtbunidmedida.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbunidmedida  implements java.io.Serializable {
    private java.lang.String cdunidade;

    private java.lang.String dsunidade;

    private java.lang.String formato;

    private idw.idwws.Ijtbmprima[] ijtbmprimas;

    private idw.idwws.Ijtboperacoes[] ijtboperacoeses;

    private java.lang.String siglaunidade;

    public Ijtbunidmedida() {
    }

    public Ijtbunidmedida(
           java.lang.String cdunidade,
           java.lang.String dsunidade,
           java.lang.String formato,
           idw.idwws.Ijtbmprima[] ijtbmprimas,
           idw.idwws.Ijtboperacoes[] ijtboperacoeses,
           java.lang.String siglaunidade) {
           this.cdunidade = cdunidade;
           this.dsunidade = dsunidade;
           this.formato = formato;
           this.ijtbmprimas = ijtbmprimas;
           this.ijtboperacoeses = ijtboperacoeses;
           this.siglaunidade = siglaunidade;
    }


    /**
     * Gets the cdunidade value for this Ijtbunidmedida.
     * 
     * @return cdunidade
     */
    public java.lang.String getCdunidade() {
        return cdunidade;
    }


    /**
     * Sets the cdunidade value for this Ijtbunidmedida.
     * 
     * @param cdunidade
     */
    public void setCdunidade(java.lang.String cdunidade) {
        this.cdunidade = cdunidade;
    }


    /**
     * Gets the dsunidade value for this Ijtbunidmedida.
     * 
     * @return dsunidade
     */
    public java.lang.String getDsunidade() {
        return dsunidade;
    }


    /**
     * Sets the dsunidade value for this Ijtbunidmedida.
     * 
     * @param dsunidade
     */
    public void setDsunidade(java.lang.String dsunidade) {
        this.dsunidade = dsunidade;
    }


    /**
     * Gets the formato value for this Ijtbunidmedida.
     * 
     * @return formato
     */
    public java.lang.String getFormato() {
        return formato;
    }


    /**
     * Sets the formato value for this Ijtbunidmedida.
     * 
     * @param formato
     */
    public void setFormato(java.lang.String formato) {
        this.formato = formato;
    }


    /**
     * Gets the ijtbmprimas value for this Ijtbunidmedida.
     * 
     * @return ijtbmprimas
     */
    public idw.idwws.Ijtbmprima[] getIjtbmprimas() {
        return ijtbmprimas;
    }


    /**
     * Sets the ijtbmprimas value for this Ijtbunidmedida.
     * 
     * @param ijtbmprimas
     */
    public void setIjtbmprimas(idw.idwws.Ijtbmprima[] ijtbmprimas) {
        this.ijtbmprimas = ijtbmprimas;
    }

    public idw.idwws.Ijtbmprima getIjtbmprimas(int i) {
        return this.ijtbmprimas[i];
    }

    public void setIjtbmprimas(int i, idw.idwws.Ijtbmprima _value) {
        this.ijtbmprimas[i] = _value;
    }


    /**
     * Gets the ijtboperacoeses value for this Ijtbunidmedida.
     * 
     * @return ijtboperacoeses
     */
    public idw.idwws.Ijtboperacoes[] getIjtboperacoeses() {
        return ijtboperacoeses;
    }


    /**
     * Sets the ijtboperacoeses value for this Ijtbunidmedida.
     * 
     * @param ijtboperacoeses
     */
    public void setIjtboperacoeses(idw.idwws.Ijtboperacoes[] ijtboperacoeses) {
        this.ijtboperacoeses = ijtboperacoeses;
    }

    public idw.idwws.Ijtboperacoes getIjtboperacoeses(int i) {
        return this.ijtboperacoeses[i];
    }

    public void setIjtboperacoeses(int i, idw.idwws.Ijtboperacoes _value) {
        this.ijtboperacoeses[i] = _value;
    }


    /**
     * Gets the siglaunidade value for this Ijtbunidmedida.
     * 
     * @return siglaunidade
     */
    public java.lang.String getSiglaunidade() {
        return siglaunidade;
    }


    /**
     * Sets the siglaunidade value for this Ijtbunidmedida.
     * 
     * @param siglaunidade
     */
    public void setSiglaunidade(java.lang.String siglaunidade) {
        this.siglaunidade = siglaunidade;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbunidmedida)) return false;
        Ijtbunidmedida other = (Ijtbunidmedida) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdunidade==null && other.getCdunidade()==null) || 
             (this.cdunidade!=null &&
              this.cdunidade.equals(other.getCdunidade()))) &&
            ((this.dsunidade==null && other.getDsunidade()==null) || 
             (this.dsunidade!=null &&
              this.dsunidade.equals(other.getDsunidade()))) &&
            ((this.formato==null && other.getFormato()==null) || 
             (this.formato!=null &&
              this.formato.equals(other.getFormato()))) &&
            ((this.ijtbmprimas==null && other.getIjtbmprimas()==null) || 
             (this.ijtbmprimas!=null &&
              java.util.Arrays.equals(this.ijtbmprimas, other.getIjtbmprimas()))) &&
            ((this.ijtboperacoeses==null && other.getIjtboperacoeses()==null) || 
             (this.ijtboperacoeses!=null &&
              java.util.Arrays.equals(this.ijtboperacoeses, other.getIjtboperacoeses()))) &&
            ((this.siglaunidade==null && other.getSiglaunidade()==null) || 
             (this.siglaunidade!=null &&
              this.siglaunidade.equals(other.getSiglaunidade())));
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
        if (getCdunidade() != null) {
            _hashCode += getCdunidade().hashCode();
        }
        if (getDsunidade() != null) {
            _hashCode += getDsunidade().hashCode();
        }
        if (getFormato() != null) {
            _hashCode += getFormato().hashCode();
        }
        if (getIjtbmprimas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbmprimas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbmprimas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtboperacoeses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtboperacoeses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtboperacoeses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSiglaunidade() != null) {
            _hashCode += getSiglaunidade().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbunidmedida.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbunidmedida"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdunidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdunidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsunidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsunidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "formato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmprimas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmprimas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmprima"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtboperacoeses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtboperacoeses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtboperacoes"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siglaunidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "siglaunidade"));
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
