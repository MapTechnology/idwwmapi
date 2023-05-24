/**
 * Ijcaptionlinguas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijcaptionlinguas  implements java.io.Serializable {
    private java.lang.String caption;

    private java.math.BigDecimal controltype;

    private idw.idwws.IjcaptionlinguasId id;

    private idw.idwws.Ijlinguas ijlinguas;

    private idw.idwws.Ijtbmodulos ijtbmodulos;

    private java.math.BigDecimal maxlength;

    private java.lang.String tooltip;

    public Ijcaptionlinguas() {
    }

    public Ijcaptionlinguas(
           java.lang.String caption,
           java.math.BigDecimal controltype,
           idw.idwws.IjcaptionlinguasId id,
           idw.idwws.Ijlinguas ijlinguas,
           idw.idwws.Ijtbmodulos ijtbmodulos,
           java.math.BigDecimal maxlength,
           java.lang.String tooltip) {
           this.caption = caption;
           this.controltype = controltype;
           this.id = id;
           this.ijlinguas = ijlinguas;
           this.ijtbmodulos = ijtbmodulos;
           this.maxlength = maxlength;
           this.tooltip = tooltip;
    }


    /**
     * Gets the caption value for this Ijcaptionlinguas.
     * 
     * @return caption
     */
    public java.lang.String getCaption() {
        return caption;
    }


    /**
     * Sets the caption value for this Ijcaptionlinguas.
     * 
     * @param caption
     */
    public void setCaption(java.lang.String caption) {
        this.caption = caption;
    }


    /**
     * Gets the controltype value for this Ijcaptionlinguas.
     * 
     * @return controltype
     */
    public java.math.BigDecimal getControltype() {
        return controltype;
    }


    /**
     * Sets the controltype value for this Ijcaptionlinguas.
     * 
     * @param controltype
     */
    public void setControltype(java.math.BigDecimal controltype) {
        this.controltype = controltype;
    }


    /**
     * Gets the id value for this Ijcaptionlinguas.
     * 
     * @return id
     */
    public idw.idwws.IjcaptionlinguasId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijcaptionlinguas.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjcaptionlinguasId id) {
        this.id = id;
    }


    /**
     * Gets the ijlinguas value for this Ijcaptionlinguas.
     * 
     * @return ijlinguas
     */
    public idw.idwws.Ijlinguas getIjlinguas() {
        return ijlinguas;
    }


    /**
     * Sets the ijlinguas value for this Ijcaptionlinguas.
     * 
     * @param ijlinguas
     */
    public void setIjlinguas(idw.idwws.Ijlinguas ijlinguas) {
        this.ijlinguas = ijlinguas;
    }


    /**
     * Gets the ijtbmodulos value for this Ijcaptionlinguas.
     * 
     * @return ijtbmodulos
     */
    public idw.idwws.Ijtbmodulos getIjtbmodulos() {
        return ijtbmodulos;
    }


    /**
     * Sets the ijtbmodulos value for this Ijcaptionlinguas.
     * 
     * @param ijtbmodulos
     */
    public void setIjtbmodulos(idw.idwws.Ijtbmodulos ijtbmodulos) {
        this.ijtbmodulos = ijtbmodulos;
    }


    /**
     * Gets the maxlength value for this Ijcaptionlinguas.
     * 
     * @return maxlength
     */
    public java.math.BigDecimal getMaxlength() {
        return maxlength;
    }


    /**
     * Sets the maxlength value for this Ijcaptionlinguas.
     * 
     * @param maxlength
     */
    public void setMaxlength(java.math.BigDecimal maxlength) {
        this.maxlength = maxlength;
    }


    /**
     * Gets the tooltip value for this Ijcaptionlinguas.
     * 
     * @return tooltip
     */
    public java.lang.String getTooltip() {
        return tooltip;
    }


    /**
     * Sets the tooltip value for this Ijcaptionlinguas.
     * 
     * @param tooltip
     */
    public void setTooltip(java.lang.String tooltip) {
        this.tooltip = tooltip;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijcaptionlinguas)) return false;
        Ijcaptionlinguas other = (Ijcaptionlinguas) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.caption==null && other.getCaption()==null) || 
             (this.caption!=null &&
              this.caption.equals(other.getCaption()))) &&
            ((this.controltype==null && other.getControltype()==null) || 
             (this.controltype!=null &&
              this.controltype.equals(other.getControltype()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijlinguas==null && other.getIjlinguas()==null) || 
             (this.ijlinguas!=null &&
              this.ijlinguas.equals(other.getIjlinguas()))) &&
            ((this.ijtbmodulos==null && other.getIjtbmodulos()==null) || 
             (this.ijtbmodulos!=null &&
              this.ijtbmodulos.equals(other.getIjtbmodulos()))) &&
            ((this.maxlength==null && other.getMaxlength()==null) || 
             (this.maxlength!=null &&
              this.maxlength.equals(other.getMaxlength()))) &&
            ((this.tooltip==null && other.getTooltip()==null) || 
             (this.tooltip!=null &&
              this.tooltip.equals(other.getTooltip())));
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
        if (getCaption() != null) {
            _hashCode += getCaption().hashCode();
        }
        if (getControltype() != null) {
            _hashCode += getControltype().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjlinguas() != null) {
            _hashCode += getIjlinguas().hashCode();
        }
        if (getIjtbmodulos() != null) {
            _hashCode += getIjtbmodulos().hashCode();
        }
        if (getMaxlength() != null) {
            _hashCode += getMaxlength().hashCode();
        }
        if (getTooltip() != null) {
            _hashCode += getTooltip().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijcaptionlinguas.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcaptionlinguas"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caption");
        elemField.setXmlName(new javax.xml.namespace.QName("", "caption"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("controltype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "controltype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcaptionlinguasId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijlinguas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijlinguas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlinguas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmodulos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmodulos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmodulos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxlength");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maxlength"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tooltip");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tooltip"));
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
