/**
 * Ijamstrdetaltcgq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijamstrdetaltcgq  implements java.io.Serializable {
    private java.math.BigDecimal amostra;

    private double idctrlaltcgqamstvl;

    private idw.idwws.Ijamstraltcgq ijamstraltcgq;

    private org.apache.axis.types.UnsignedShort resultado;

    private double vllido;

    public Ijamstrdetaltcgq() {
    }

    public Ijamstrdetaltcgq(
           java.math.BigDecimal amostra,
           double idctrlaltcgqamstvl,
           idw.idwws.Ijamstraltcgq ijamstraltcgq,
           org.apache.axis.types.UnsignedShort resultado,
           double vllido) {
           this.amostra = amostra;
           this.idctrlaltcgqamstvl = idctrlaltcgqamstvl;
           this.ijamstraltcgq = ijamstraltcgq;
           this.resultado = resultado;
           this.vllido = vllido;
    }


    /**
     * Gets the amostra value for this Ijamstrdetaltcgq.
     * 
     * @return amostra
     */
    public java.math.BigDecimal getAmostra() {
        return amostra;
    }


    /**
     * Sets the amostra value for this Ijamstrdetaltcgq.
     * 
     * @param amostra
     */
    public void setAmostra(java.math.BigDecimal amostra) {
        this.amostra = amostra;
    }


    /**
     * Gets the idctrlaltcgqamstvl value for this Ijamstrdetaltcgq.
     * 
     * @return idctrlaltcgqamstvl
     */
    public double getIdctrlaltcgqamstvl() {
        return idctrlaltcgqamstvl;
    }


    /**
     * Sets the idctrlaltcgqamstvl value for this Ijamstrdetaltcgq.
     * 
     * @param idctrlaltcgqamstvl
     */
    public void setIdctrlaltcgqamstvl(double idctrlaltcgqamstvl) {
        this.idctrlaltcgqamstvl = idctrlaltcgqamstvl;
    }


    /**
     * Gets the ijamstraltcgq value for this Ijamstrdetaltcgq.
     * 
     * @return ijamstraltcgq
     */
    public idw.idwws.Ijamstraltcgq getIjamstraltcgq() {
        return ijamstraltcgq;
    }


    /**
     * Sets the ijamstraltcgq value for this Ijamstrdetaltcgq.
     * 
     * @param ijamstraltcgq
     */
    public void setIjamstraltcgq(idw.idwws.Ijamstraltcgq ijamstraltcgq) {
        this.ijamstraltcgq = ijamstraltcgq;
    }


    /**
     * Gets the resultado value for this Ijamstrdetaltcgq.
     * 
     * @return resultado
     */
    public org.apache.axis.types.UnsignedShort getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this Ijamstrdetaltcgq.
     * 
     * @param resultado
     */
    public void setResultado(org.apache.axis.types.UnsignedShort resultado) {
        this.resultado = resultado;
    }


    /**
     * Gets the vllido value for this Ijamstrdetaltcgq.
     * 
     * @return vllido
     */
    public double getVllido() {
        return vllido;
    }


    /**
     * Sets the vllido value for this Ijamstrdetaltcgq.
     * 
     * @param vllido
     */
    public void setVllido(double vllido) {
        this.vllido = vllido;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijamstrdetaltcgq)) return false;
        Ijamstrdetaltcgq other = (Ijamstrdetaltcgq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.amostra==null && other.getAmostra()==null) || 
             (this.amostra!=null &&
              this.amostra.equals(other.getAmostra()))) &&
            this.idctrlaltcgqamstvl == other.getIdctrlaltcgqamstvl() &&
            ((this.ijamstraltcgq==null && other.getIjamstraltcgq()==null) || 
             (this.ijamstraltcgq!=null &&
              this.ijamstraltcgq.equals(other.getIjamstraltcgq()))) &&
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado()))) &&
            this.vllido == other.getVllido();
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
        if (getAmostra() != null) {
            _hashCode += getAmostra().hashCode();
        }
        _hashCode += new Double(getIdctrlaltcgqamstvl()).hashCode();
        if (getIjamstraltcgq() != null) {
            _hashCode += getIjamstraltcgq().hashCode();
        }
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        _hashCode += new Double(getVllido()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijamstrdetaltcgq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamstrdetaltcgq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amostra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amostra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idctrlaltcgqamstvl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idctrlaltcgqamstvl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamstraltcgq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamstraltcgq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamstraltcgq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vllido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vllido"));
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
