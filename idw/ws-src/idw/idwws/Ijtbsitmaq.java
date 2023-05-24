/**
 * Ijtbsitmaq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbsitmaq  implements java.io.Serializable {
    private java.lang.String cdcor;

    private java.lang.String dssitmaq;

    private java.lang.String expressao;

    private idw.idwws.IjtbsitmaqId id;

    private idw.idwws.Ijlinguas ijlinguas;

    public Ijtbsitmaq() {
    }

    public Ijtbsitmaq(
           java.lang.String cdcor,
           java.lang.String dssitmaq,
           java.lang.String expressao,
           idw.idwws.IjtbsitmaqId id,
           idw.idwws.Ijlinguas ijlinguas) {
           this.cdcor = cdcor;
           this.dssitmaq = dssitmaq;
           this.expressao = expressao;
           this.id = id;
           this.ijlinguas = ijlinguas;
    }


    /**
     * Gets the cdcor value for this Ijtbsitmaq.
     * 
     * @return cdcor
     */
    public java.lang.String getCdcor() {
        return cdcor;
    }


    /**
     * Sets the cdcor value for this Ijtbsitmaq.
     * 
     * @param cdcor
     */
    public void setCdcor(java.lang.String cdcor) {
        this.cdcor = cdcor;
    }


    /**
     * Gets the dssitmaq value for this Ijtbsitmaq.
     * 
     * @return dssitmaq
     */
    public java.lang.String getDssitmaq() {
        return dssitmaq;
    }


    /**
     * Sets the dssitmaq value for this Ijtbsitmaq.
     * 
     * @param dssitmaq
     */
    public void setDssitmaq(java.lang.String dssitmaq) {
        this.dssitmaq = dssitmaq;
    }


    /**
     * Gets the expressao value for this Ijtbsitmaq.
     * 
     * @return expressao
     */
    public java.lang.String getExpressao() {
        return expressao;
    }


    /**
     * Sets the expressao value for this Ijtbsitmaq.
     * 
     * @param expressao
     */
    public void setExpressao(java.lang.String expressao) {
        this.expressao = expressao;
    }


    /**
     * Gets the id value for this Ijtbsitmaq.
     * 
     * @return id
     */
    public idw.idwws.IjtbsitmaqId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijtbsitmaq.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjtbsitmaqId id) {
        this.id = id;
    }


    /**
     * Gets the ijlinguas value for this Ijtbsitmaq.
     * 
     * @return ijlinguas
     */
    public idw.idwws.Ijlinguas getIjlinguas() {
        return ijlinguas;
    }


    /**
     * Sets the ijlinguas value for this Ijtbsitmaq.
     * 
     * @param ijlinguas
     */
    public void setIjlinguas(idw.idwws.Ijlinguas ijlinguas) {
        this.ijlinguas = ijlinguas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbsitmaq)) return false;
        Ijtbsitmaq other = (Ijtbsitmaq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcor==null && other.getCdcor()==null) || 
             (this.cdcor!=null &&
              this.cdcor.equals(other.getCdcor()))) &&
            ((this.dssitmaq==null && other.getDssitmaq()==null) || 
             (this.dssitmaq!=null &&
              this.dssitmaq.equals(other.getDssitmaq()))) &&
            ((this.expressao==null && other.getExpressao()==null) || 
             (this.expressao!=null &&
              this.expressao.equals(other.getExpressao()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijlinguas==null && other.getIjlinguas()==null) || 
             (this.ijlinguas!=null &&
              this.ijlinguas.equals(other.getIjlinguas())));
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
        if (getCdcor() != null) {
            _hashCode += getCdcor().hashCode();
        }
        if (getDssitmaq() != null) {
            _hashCode += getDssitmaq().hashCode();
        }
        if (getExpressao() != null) {
            _hashCode += getExpressao().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjlinguas() != null) {
            _hashCode += getIjlinguas().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbsitmaq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbsitmaq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dssitmaq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dssitmaq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expressao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "expressao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbsitmaqId"));
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
