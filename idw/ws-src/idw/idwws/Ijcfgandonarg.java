/**
 * Ijcfgandonarg.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijcfgandonarg  implements java.io.Serializable {
    private idw.idwws.IjcfgandonargId id;

    private idw.idwws.Ijcfgandon ijcfgandon;

    private java.lang.String operadorcalculo;

    private java.lang.String operadorlogico;

    private java.math.BigDecimal tpvlreferencia;

    private java.lang.Double vlreferencianum;

    private java.lang.String vlreferenciastr;

    public Ijcfgandonarg() {
    }

    public Ijcfgandonarg(
           idw.idwws.IjcfgandonargId id,
           idw.idwws.Ijcfgandon ijcfgandon,
           java.lang.String operadorcalculo,
           java.lang.String operadorlogico,
           java.math.BigDecimal tpvlreferencia,
           java.lang.Double vlreferencianum,
           java.lang.String vlreferenciastr) {
           this.id = id;
           this.ijcfgandon = ijcfgandon;
           this.operadorcalculo = operadorcalculo;
           this.operadorlogico = operadorlogico;
           this.tpvlreferencia = tpvlreferencia;
           this.vlreferencianum = vlreferencianum;
           this.vlreferenciastr = vlreferenciastr;
    }


    /**
     * Gets the id value for this Ijcfgandonarg.
     * 
     * @return id
     */
    public idw.idwws.IjcfgandonargId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijcfgandonarg.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjcfgandonargId id) {
        this.id = id;
    }


    /**
     * Gets the ijcfgandon value for this Ijcfgandonarg.
     * 
     * @return ijcfgandon
     */
    public idw.idwws.Ijcfgandon getIjcfgandon() {
        return ijcfgandon;
    }


    /**
     * Sets the ijcfgandon value for this Ijcfgandonarg.
     * 
     * @param ijcfgandon
     */
    public void setIjcfgandon(idw.idwws.Ijcfgandon ijcfgandon) {
        this.ijcfgandon = ijcfgandon;
    }


    /**
     * Gets the operadorcalculo value for this Ijcfgandonarg.
     * 
     * @return operadorcalculo
     */
    public java.lang.String getOperadorcalculo() {
        return operadorcalculo;
    }


    /**
     * Sets the operadorcalculo value for this Ijcfgandonarg.
     * 
     * @param operadorcalculo
     */
    public void setOperadorcalculo(java.lang.String operadorcalculo) {
        this.operadorcalculo = operadorcalculo;
    }


    /**
     * Gets the operadorlogico value for this Ijcfgandonarg.
     * 
     * @return operadorlogico
     */
    public java.lang.String getOperadorlogico() {
        return operadorlogico;
    }


    /**
     * Sets the operadorlogico value for this Ijcfgandonarg.
     * 
     * @param operadorlogico
     */
    public void setOperadorlogico(java.lang.String operadorlogico) {
        this.operadorlogico = operadorlogico;
    }


    /**
     * Gets the tpvlreferencia value for this Ijcfgandonarg.
     * 
     * @return tpvlreferencia
     */
    public java.math.BigDecimal getTpvlreferencia() {
        return tpvlreferencia;
    }


    /**
     * Sets the tpvlreferencia value for this Ijcfgandonarg.
     * 
     * @param tpvlreferencia
     */
    public void setTpvlreferencia(java.math.BigDecimal tpvlreferencia) {
        this.tpvlreferencia = tpvlreferencia;
    }


    /**
     * Gets the vlreferencianum value for this Ijcfgandonarg.
     * 
     * @return vlreferencianum
     */
    public java.lang.Double getVlreferencianum() {
        return vlreferencianum;
    }


    /**
     * Sets the vlreferencianum value for this Ijcfgandonarg.
     * 
     * @param vlreferencianum
     */
    public void setVlreferencianum(java.lang.Double vlreferencianum) {
        this.vlreferencianum = vlreferencianum;
    }


    /**
     * Gets the vlreferenciastr value for this Ijcfgandonarg.
     * 
     * @return vlreferenciastr
     */
    public java.lang.String getVlreferenciastr() {
        return vlreferenciastr;
    }


    /**
     * Sets the vlreferenciastr value for this Ijcfgandonarg.
     * 
     * @param vlreferenciastr
     */
    public void setVlreferenciastr(java.lang.String vlreferenciastr) {
        this.vlreferenciastr = vlreferenciastr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijcfgandonarg)) return false;
        Ijcfgandonarg other = (Ijcfgandonarg) obj;
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
            ((this.ijcfgandon==null && other.getIjcfgandon()==null) || 
             (this.ijcfgandon!=null &&
              this.ijcfgandon.equals(other.getIjcfgandon()))) &&
            ((this.operadorcalculo==null && other.getOperadorcalculo()==null) || 
             (this.operadorcalculo!=null &&
              this.operadorcalculo.equals(other.getOperadorcalculo()))) &&
            ((this.operadorlogico==null && other.getOperadorlogico()==null) || 
             (this.operadorlogico!=null &&
              this.operadorlogico.equals(other.getOperadorlogico()))) &&
            ((this.tpvlreferencia==null && other.getTpvlreferencia()==null) || 
             (this.tpvlreferencia!=null &&
              this.tpvlreferencia.equals(other.getTpvlreferencia()))) &&
            ((this.vlreferencianum==null && other.getVlreferencianum()==null) || 
             (this.vlreferencianum!=null &&
              this.vlreferencianum.equals(other.getVlreferencianum()))) &&
            ((this.vlreferenciastr==null && other.getVlreferenciastr()==null) || 
             (this.vlreferenciastr!=null &&
              this.vlreferenciastr.equals(other.getVlreferenciastr())));
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
        if (getIjcfgandon() != null) {
            _hashCode += getIjcfgandon().hashCode();
        }
        if (getOperadorcalculo() != null) {
            _hashCode += getOperadorcalculo().hashCode();
        }
        if (getOperadorlogico() != null) {
            _hashCode += getOperadorlogico().hashCode();
        }
        if (getTpvlreferencia() != null) {
            _hashCode += getTpvlreferencia().hashCode();
        }
        if (getVlreferencianum() != null) {
            _hashCode += getVlreferencianum().hashCode();
        }
        if (getVlreferenciastr() != null) {
            _hashCode += getVlreferenciastr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijcfgandonarg.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcfgandonarg"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcfgandonargId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcfgandon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcfgandon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcfgandon"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operadorcalculo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operadorcalculo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operadorlogico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operadorlogico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpvlreferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpvlreferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlreferencianum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlreferencianum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlreferenciastr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlreferenciastr"));
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
