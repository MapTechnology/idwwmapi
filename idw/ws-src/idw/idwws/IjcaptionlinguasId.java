/**
 * IjcaptionlinguasId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjcaptionlinguasId  implements java.io.Serializable {
    private java.lang.String cdlingua;

    private java.lang.String cdmodulo;

    private java.lang.String controlname;

    private java.lang.String formname;

    private java.math.BigDecimal indice;

    public IjcaptionlinguasId() {
    }

    public IjcaptionlinguasId(
           java.lang.String cdlingua,
           java.lang.String cdmodulo,
           java.lang.String controlname,
           java.lang.String formname,
           java.math.BigDecimal indice) {
           this.cdlingua = cdlingua;
           this.cdmodulo = cdmodulo;
           this.controlname = controlname;
           this.formname = formname;
           this.indice = indice;
    }


    /**
     * Gets the cdlingua value for this IjcaptionlinguasId.
     * 
     * @return cdlingua
     */
    public java.lang.String getCdlingua() {
        return cdlingua;
    }


    /**
     * Sets the cdlingua value for this IjcaptionlinguasId.
     * 
     * @param cdlingua
     */
    public void setCdlingua(java.lang.String cdlingua) {
        this.cdlingua = cdlingua;
    }


    /**
     * Gets the cdmodulo value for this IjcaptionlinguasId.
     * 
     * @return cdmodulo
     */
    public java.lang.String getCdmodulo() {
        return cdmodulo;
    }


    /**
     * Sets the cdmodulo value for this IjcaptionlinguasId.
     * 
     * @param cdmodulo
     */
    public void setCdmodulo(java.lang.String cdmodulo) {
        this.cdmodulo = cdmodulo;
    }


    /**
     * Gets the controlname value for this IjcaptionlinguasId.
     * 
     * @return controlname
     */
    public java.lang.String getControlname() {
        return controlname;
    }


    /**
     * Sets the controlname value for this IjcaptionlinguasId.
     * 
     * @param controlname
     */
    public void setControlname(java.lang.String controlname) {
        this.controlname = controlname;
    }


    /**
     * Gets the formname value for this IjcaptionlinguasId.
     * 
     * @return formname
     */
    public java.lang.String getFormname() {
        return formname;
    }


    /**
     * Sets the formname value for this IjcaptionlinguasId.
     * 
     * @param formname
     */
    public void setFormname(java.lang.String formname) {
        this.formname = formname;
    }


    /**
     * Gets the indice value for this IjcaptionlinguasId.
     * 
     * @return indice
     */
    public java.math.BigDecimal getIndice() {
        return indice;
    }


    /**
     * Sets the indice value for this IjcaptionlinguasId.
     * 
     * @param indice
     */
    public void setIndice(java.math.BigDecimal indice) {
        this.indice = indice;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjcaptionlinguasId)) return false;
        IjcaptionlinguasId other = (IjcaptionlinguasId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdlingua==null && other.getCdlingua()==null) || 
             (this.cdlingua!=null &&
              this.cdlingua.equals(other.getCdlingua()))) &&
            ((this.cdmodulo==null && other.getCdmodulo()==null) || 
             (this.cdmodulo!=null &&
              this.cdmodulo.equals(other.getCdmodulo()))) &&
            ((this.controlname==null && other.getControlname()==null) || 
             (this.controlname!=null &&
              this.controlname.equals(other.getControlname()))) &&
            ((this.formname==null && other.getFormname()==null) || 
             (this.formname!=null &&
              this.formname.equals(other.getFormname()))) &&
            ((this.indice==null && other.getIndice()==null) || 
             (this.indice!=null &&
              this.indice.equals(other.getIndice())));
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
        if (getCdlingua() != null) {
            _hashCode += getCdlingua().hashCode();
        }
        if (getCdmodulo() != null) {
            _hashCode += getCdmodulo().hashCode();
        }
        if (getControlname() != null) {
            _hashCode += getControlname().hashCode();
        }
        if (getFormname() != null) {
            _hashCode += getFormname().hashCode();
        }
        if (getIndice() != null) {
            _hashCode += getIndice().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjcaptionlinguasId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcaptionlinguasId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdlingua");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdlingua"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmodulo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmodulo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("controlname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "controlname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "formname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indice"));
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
