/**
 * Ijcfgandmaqevtarg.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijcfgandmaqevtarg  implements java.io.Serializable {
    private idw.idwws.IjcfgandmaqevtargId id;

    private idw.idwws.Ijcfgandmaqevt ijcfgandmaqevt;

    private java.lang.String operadorcalculo;

    private java.lang.String operadorlogico;

    private java.math.BigDecimal tpvlreferencia;

    private java.lang.Double vlreferencianum;

    private java.lang.String vlreferenciastr;

    public Ijcfgandmaqevtarg() {
    }

    public Ijcfgandmaqevtarg(
           idw.idwws.IjcfgandmaqevtargId id,
           idw.idwws.Ijcfgandmaqevt ijcfgandmaqevt,
           java.lang.String operadorcalculo,
           java.lang.String operadorlogico,
           java.math.BigDecimal tpvlreferencia,
           java.lang.Double vlreferencianum,
           java.lang.String vlreferenciastr) {
           this.id = id;
           this.ijcfgandmaqevt = ijcfgandmaqevt;
           this.operadorcalculo = operadorcalculo;
           this.operadorlogico = operadorlogico;
           this.tpvlreferencia = tpvlreferencia;
           this.vlreferencianum = vlreferencianum;
           this.vlreferenciastr = vlreferenciastr;
    }


    /**
     * Gets the id value for this Ijcfgandmaqevtarg.
     * 
     * @return id
     */
    public idw.idwws.IjcfgandmaqevtargId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijcfgandmaqevtarg.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjcfgandmaqevtargId id) {
        this.id = id;
    }


    /**
     * Gets the ijcfgandmaqevt value for this Ijcfgandmaqevtarg.
     * 
     * @return ijcfgandmaqevt
     */
    public idw.idwws.Ijcfgandmaqevt getIjcfgandmaqevt() {
        return ijcfgandmaqevt;
    }


    /**
     * Sets the ijcfgandmaqevt value for this Ijcfgandmaqevtarg.
     * 
     * @param ijcfgandmaqevt
     */
    public void setIjcfgandmaqevt(idw.idwws.Ijcfgandmaqevt ijcfgandmaqevt) {
        this.ijcfgandmaqevt = ijcfgandmaqevt;
    }


    /**
     * Gets the operadorcalculo value for this Ijcfgandmaqevtarg.
     * 
     * @return operadorcalculo
     */
    public java.lang.String getOperadorcalculo() {
        return operadorcalculo;
    }


    /**
     * Sets the operadorcalculo value for this Ijcfgandmaqevtarg.
     * 
     * @param operadorcalculo
     */
    public void setOperadorcalculo(java.lang.String operadorcalculo) {
        this.operadorcalculo = operadorcalculo;
    }


    /**
     * Gets the operadorlogico value for this Ijcfgandmaqevtarg.
     * 
     * @return operadorlogico
     */
    public java.lang.String getOperadorlogico() {
        return operadorlogico;
    }


    /**
     * Sets the operadorlogico value for this Ijcfgandmaqevtarg.
     * 
     * @param operadorlogico
     */
    public void setOperadorlogico(java.lang.String operadorlogico) {
        this.operadorlogico = operadorlogico;
    }


    /**
     * Gets the tpvlreferencia value for this Ijcfgandmaqevtarg.
     * 
     * @return tpvlreferencia
     */
    public java.math.BigDecimal getTpvlreferencia() {
        return tpvlreferencia;
    }


    /**
     * Sets the tpvlreferencia value for this Ijcfgandmaqevtarg.
     * 
     * @param tpvlreferencia
     */
    public void setTpvlreferencia(java.math.BigDecimal tpvlreferencia) {
        this.tpvlreferencia = tpvlreferencia;
    }


    /**
     * Gets the vlreferencianum value for this Ijcfgandmaqevtarg.
     * 
     * @return vlreferencianum
     */
    public java.lang.Double getVlreferencianum() {
        return vlreferencianum;
    }


    /**
     * Sets the vlreferencianum value for this Ijcfgandmaqevtarg.
     * 
     * @param vlreferencianum
     */
    public void setVlreferencianum(java.lang.Double vlreferencianum) {
        this.vlreferencianum = vlreferencianum;
    }


    /**
     * Gets the vlreferenciastr value for this Ijcfgandmaqevtarg.
     * 
     * @return vlreferenciastr
     */
    public java.lang.String getVlreferenciastr() {
        return vlreferenciastr;
    }


    /**
     * Sets the vlreferenciastr value for this Ijcfgandmaqevtarg.
     * 
     * @param vlreferenciastr
     */
    public void setVlreferenciastr(java.lang.String vlreferenciastr) {
        this.vlreferenciastr = vlreferenciastr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijcfgandmaqevtarg)) return false;
        Ijcfgandmaqevtarg other = (Ijcfgandmaqevtarg) obj;
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
            ((this.ijcfgandmaqevt==null && other.getIjcfgandmaqevt()==null) || 
             (this.ijcfgandmaqevt!=null &&
              this.ijcfgandmaqevt.equals(other.getIjcfgandmaqevt()))) &&
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
        if (getIjcfgandmaqevt() != null) {
            _hashCode += getIjcfgandmaqevt().hashCode();
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
        new org.apache.axis.description.TypeDesc(Ijcfgandmaqevtarg.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcfgandmaqevtarg"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcfgandmaqevtargId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcfgandmaqevt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcfgandmaqevt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcfgandmaqevt"));
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
