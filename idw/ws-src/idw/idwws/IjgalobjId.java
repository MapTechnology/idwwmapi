/**
 * IjgalobjId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjgalobjId  implements java.io.Serializable {
    private java.lang.String cdgalpao;

    private java.lang.String cdinjetora;

    private java.lang.String cdposto;

    private double coorelobjx;

    private double coorelobjy;

    public IjgalobjId() {
    }

    public IjgalobjId(
           java.lang.String cdgalpao,
           java.lang.String cdinjetora,
           java.lang.String cdposto,
           double coorelobjx,
           double coorelobjy) {
           this.cdgalpao = cdgalpao;
           this.cdinjetora = cdinjetora;
           this.cdposto = cdposto;
           this.coorelobjx = coorelobjx;
           this.coorelobjy = coorelobjy;
    }


    /**
     * Gets the cdgalpao value for this IjgalobjId.
     * 
     * @return cdgalpao
     */
    public java.lang.String getCdgalpao() {
        return cdgalpao;
    }


    /**
     * Sets the cdgalpao value for this IjgalobjId.
     * 
     * @param cdgalpao
     */
    public void setCdgalpao(java.lang.String cdgalpao) {
        this.cdgalpao = cdgalpao;
    }


    /**
     * Gets the cdinjetora value for this IjgalobjId.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this IjgalobjId.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the cdposto value for this IjgalobjId.
     * 
     * @return cdposto
     */
    public java.lang.String getCdposto() {
        return cdposto;
    }


    /**
     * Sets the cdposto value for this IjgalobjId.
     * 
     * @param cdposto
     */
    public void setCdposto(java.lang.String cdposto) {
        this.cdposto = cdposto;
    }


    /**
     * Gets the coorelobjx value for this IjgalobjId.
     * 
     * @return coorelobjx
     */
    public double getCoorelobjx() {
        return coorelobjx;
    }


    /**
     * Sets the coorelobjx value for this IjgalobjId.
     * 
     * @param coorelobjx
     */
    public void setCoorelobjx(double coorelobjx) {
        this.coorelobjx = coorelobjx;
    }


    /**
     * Gets the coorelobjy value for this IjgalobjId.
     * 
     * @return coorelobjy
     */
    public double getCoorelobjy() {
        return coorelobjy;
    }


    /**
     * Sets the coorelobjy value for this IjgalobjId.
     * 
     * @param coorelobjy
     */
    public void setCoorelobjy(double coorelobjy) {
        this.coorelobjy = coorelobjy;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjgalobjId)) return false;
        IjgalobjId other = (IjgalobjId) obj;
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
            this.coorelobjx == other.getCoorelobjx() &&
            this.coorelobjy == other.getCoorelobjy();
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
        _hashCode += new Double(getCoorelobjx()).hashCode();
        _hashCode += new Double(getCoorelobjy()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjgalobjId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgalobjId"));
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
        elemField.setFieldName("coorelobjx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coorelobjx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coorelobjy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coorelobjy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
