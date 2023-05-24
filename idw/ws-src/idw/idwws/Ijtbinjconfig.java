/**
 * Ijtbinjconfig.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbinjconfig  implements java.io.Serializable {
    private idw.idwws.IjtbinjconfigId id;

    private idw.idwws.Ijtbinj ijtbinj;

    private org.apache.axis.types.UnsignedShort stsincronismo;

    private java.lang.String tpdadovalor;

    private java.lang.String valor;

    public Ijtbinjconfig() {
    }

    public Ijtbinjconfig(
           idw.idwws.IjtbinjconfigId id,
           idw.idwws.Ijtbinj ijtbinj,
           org.apache.axis.types.UnsignedShort stsincronismo,
           java.lang.String tpdadovalor,
           java.lang.String valor) {
           this.id = id;
           this.ijtbinj = ijtbinj;
           this.stsincronismo = stsincronismo;
           this.tpdadovalor = tpdadovalor;
           this.valor = valor;
    }


    /**
     * Gets the id value for this Ijtbinjconfig.
     * 
     * @return id
     */
    public idw.idwws.IjtbinjconfigId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijtbinjconfig.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjtbinjconfigId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbinj value for this Ijtbinjconfig.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijtbinjconfig.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the stsincronismo value for this Ijtbinjconfig.
     * 
     * @return stsincronismo
     */
    public org.apache.axis.types.UnsignedShort getStsincronismo() {
        return stsincronismo;
    }


    /**
     * Sets the stsincronismo value for this Ijtbinjconfig.
     * 
     * @param stsincronismo
     */
    public void setStsincronismo(org.apache.axis.types.UnsignedShort stsincronismo) {
        this.stsincronismo = stsincronismo;
    }


    /**
     * Gets the tpdadovalor value for this Ijtbinjconfig.
     * 
     * @return tpdadovalor
     */
    public java.lang.String getTpdadovalor() {
        return tpdadovalor;
    }


    /**
     * Sets the tpdadovalor value for this Ijtbinjconfig.
     * 
     * @param tpdadovalor
     */
    public void setTpdadovalor(java.lang.String tpdadovalor) {
        this.tpdadovalor = tpdadovalor;
    }


    /**
     * Gets the valor value for this Ijtbinjconfig.
     * 
     * @return valor
     */
    public java.lang.String getValor() {
        return valor;
    }


    /**
     * Sets the valor value for this Ijtbinjconfig.
     * 
     * @param valor
     */
    public void setValor(java.lang.String valor) {
        this.valor = valor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbinjconfig)) return false;
        Ijtbinjconfig other = (Ijtbinjconfig) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.stsincronismo==null && other.getStsincronismo()==null) || 
             (this.stsincronismo!=null &&
              this.stsincronismo.equals(other.getStsincronismo()))) &&
            ((this.tpdadovalor==null && other.getTpdadovalor()==null) || 
             (this.tpdadovalor!=null &&
              this.tpdadovalor.equals(other.getTpdadovalor()))) &&
            ((this.valor==null && other.getValor()==null) || 
             (this.valor!=null &&
              this.valor.equals(other.getValor())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getStsincronismo() != null) {
            _hashCode += getStsincronismo().hashCode();
        }
        if (getTpdadovalor() != null) {
            _hashCode += getTpdadovalor().hashCode();
        }
        if (getValor() != null) {
            _hashCode += getValor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbinjconfig.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinjconfig"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinjconfigId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stsincronismo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stsincronismo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpdadovalor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpdadovalor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valor"));
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
