/**
 * IjgalobjmtrzId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjgalobjmtrzId  implements java.io.Serializable {
    private java.lang.String cdgalpao;

    private java.lang.String cdinjetora;

    private java.lang.String cdposto;

    private java.math.BigDecimal coordcoluna;

    private java.math.BigDecimal coordlinha;

    public IjgalobjmtrzId() {
    }

    public IjgalobjmtrzId(
           java.lang.String cdgalpao,
           java.lang.String cdinjetora,
           java.lang.String cdposto,
           java.math.BigDecimal coordcoluna,
           java.math.BigDecimal coordlinha) {
           this.cdgalpao = cdgalpao;
           this.cdinjetora = cdinjetora;
           this.cdposto = cdposto;
           this.coordcoluna = coordcoluna;
           this.coordlinha = coordlinha;
    }


    /**
     * Gets the cdgalpao value for this IjgalobjmtrzId.
     * 
     * @return cdgalpao
     */
    public java.lang.String getCdgalpao() {
        return cdgalpao;
    }


    /**
     * Sets the cdgalpao value for this IjgalobjmtrzId.
     * 
     * @param cdgalpao
     */
    public void setCdgalpao(java.lang.String cdgalpao) {
        this.cdgalpao = cdgalpao;
    }


    /**
     * Gets the cdinjetora value for this IjgalobjmtrzId.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this IjgalobjmtrzId.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the cdposto value for this IjgalobjmtrzId.
     * 
     * @return cdposto
     */
    public java.lang.String getCdposto() {
        return cdposto;
    }


    /**
     * Sets the cdposto value for this IjgalobjmtrzId.
     * 
     * @param cdposto
     */
    public void setCdposto(java.lang.String cdposto) {
        this.cdposto = cdposto;
    }


    /**
     * Gets the coordcoluna value for this IjgalobjmtrzId.
     * 
     * @return coordcoluna
     */
    public java.math.BigDecimal getCoordcoluna() {
        return coordcoluna;
    }


    /**
     * Sets the coordcoluna value for this IjgalobjmtrzId.
     * 
     * @param coordcoluna
     */
    public void setCoordcoluna(java.math.BigDecimal coordcoluna) {
        this.coordcoluna = coordcoluna;
    }


    /**
     * Gets the coordlinha value for this IjgalobjmtrzId.
     * 
     * @return coordlinha
     */
    public java.math.BigDecimal getCoordlinha() {
        return coordlinha;
    }


    /**
     * Sets the coordlinha value for this IjgalobjmtrzId.
     * 
     * @param coordlinha
     */
    public void setCoordlinha(java.math.BigDecimal coordlinha) {
        this.coordlinha = coordlinha;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjgalobjmtrzId)) return false;
        IjgalobjmtrzId other = (IjgalobjmtrzId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgalpao==null && other.getCdgalpao()==null) || 
             (this.cdgalpao!=null &&
              this.cdgalpao.equals(other.getCdgalpao()))) &&
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.cdposto==null && other.getCdposto()==null) || 
             (this.cdposto!=null &&
              this.cdposto.equals(other.getCdposto()))) &&
            ((this.coordcoluna==null && other.getCoordcoluna()==null) || 
             (this.coordcoluna!=null &&
              this.coordcoluna.equals(other.getCoordcoluna()))) &&
            ((this.coordlinha==null && other.getCoordlinha()==null) || 
             (this.coordlinha!=null &&
              this.coordlinha.equals(other.getCoordlinha())));
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
        if (getCdgalpao() != null) {
            _hashCode += getCdgalpao().hashCode();
        }
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getCdposto() != null) {
            _hashCode += getCdposto().hashCode();
        }
        if (getCoordcoluna() != null) {
            _hashCode += getCoordcoluna().hashCode();
        }
        if (getCoordlinha() != null) {
            _hashCode += getCoordlinha().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjgalobjmtrzId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgalobjmtrzId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgalpao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgalpao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdposto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdposto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coordcoluna");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coordcoluna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coordlinha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coordlinha"));
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
