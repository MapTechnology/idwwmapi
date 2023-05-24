/**
 * OmTexto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmTexto  extends idw.idwws.OmTextoTemplate  implements java.io.Serializable {
    private java.lang.String dsTexto;

    private java.lang.String fonte;

    private long idTexto;

    private idw.idwws.OmObj[] omObjs;

    private java.lang.Integer tamanhofonte;

    public OmTexto() {
    }

    public OmTexto(
           java.lang.String dsTexto,
           java.lang.String fonte,
           long idTexto,
           idw.idwws.OmObj[] omObjs,
           java.lang.Integer tamanhofonte) {
        this.dsTexto = dsTexto;
        this.fonte = fonte;
        this.idTexto = idTexto;
        this.omObjs = omObjs;
        this.tamanhofonte = tamanhofonte;
    }


    /**
     * Gets the dsTexto value for this OmTexto.
     * 
     * @return dsTexto
     */
    public java.lang.String getDsTexto() {
        return dsTexto;
    }


    /**
     * Sets the dsTexto value for this OmTexto.
     * 
     * @param dsTexto
     */
    public void setDsTexto(java.lang.String dsTexto) {
        this.dsTexto = dsTexto;
    }


    /**
     * Gets the fonte value for this OmTexto.
     * 
     * @return fonte
     */
    public java.lang.String getFonte() {
        return fonte;
    }


    /**
     * Sets the fonte value for this OmTexto.
     * 
     * @param fonte
     */
    public void setFonte(java.lang.String fonte) {
        this.fonte = fonte;
    }


    /**
     * Gets the idTexto value for this OmTexto.
     * 
     * @return idTexto
     */
    public long getIdTexto() {
        return idTexto;
    }


    /**
     * Sets the idTexto value for this OmTexto.
     * 
     * @param idTexto
     */
    public void setIdTexto(long idTexto) {
        this.idTexto = idTexto;
    }


    /**
     * Gets the omObjs value for this OmTexto.
     * 
     * @return omObjs
     */
    public idw.idwws.OmObj[] getOmObjs() {
        return omObjs;
    }


    /**
     * Sets the omObjs value for this OmTexto.
     * 
     * @param omObjs
     */
    public void setOmObjs(idw.idwws.OmObj[] omObjs) {
        this.omObjs = omObjs;
    }

    public idw.idwws.OmObj getOmObjs(int i) {
        return this.omObjs[i];
    }

    public void setOmObjs(int i, idw.idwws.OmObj _value) {
        this.omObjs[i] = _value;
    }


    /**
     * Gets the tamanhofonte value for this OmTexto.
     * 
     * @return tamanhofonte
     */
    public java.lang.Integer getTamanhofonte() {
        return tamanhofonte;
    }


    /**
     * Sets the tamanhofonte value for this OmTexto.
     * 
     * @param tamanhofonte
     */
    public void setTamanhofonte(java.lang.Integer tamanhofonte) {
        this.tamanhofonte = tamanhofonte;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmTexto)) return false;
        OmTexto other = (OmTexto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dsTexto==null && other.getDsTexto()==null) || 
             (this.dsTexto!=null &&
              this.dsTexto.equals(other.getDsTexto()))) &&
            ((this.fonte==null && other.getFonte()==null) || 
             (this.fonte!=null &&
              this.fonte.equals(other.getFonte()))) &&
            this.idTexto == other.getIdTexto() &&
            ((this.omObjs==null && other.getOmObjs()==null) || 
             (this.omObjs!=null &&
              java.util.Arrays.equals(this.omObjs, other.getOmObjs()))) &&
            ((this.tamanhofonte==null && other.getTamanhofonte()==null) || 
             (this.tamanhofonte!=null &&
              this.tamanhofonte.equals(other.getTamanhofonte())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getDsTexto() != null) {
            _hashCode += getDsTexto().hashCode();
        }
        if (getFonte() != null) {
            _hashCode += getFonte().hashCode();
        }
        _hashCode += new Long(getIdTexto()).hashCode();
        if (getOmObjs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmObjs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmObjs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTamanhofonte() != null) {
            _hashCode += getTamanhofonte().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmTexto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTexto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsTexto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsTexto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fonte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fonte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTexto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTexto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omObjs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omObjs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omObj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tamanhofonte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tamanhofonte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
