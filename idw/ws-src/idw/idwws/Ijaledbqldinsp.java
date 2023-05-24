/**
 * Ijaledbqldinsp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijaledbqldinsp  implements java.io.Serializable {
    private double idregistro;

    private idw.idwws.Ijaledbqld ijaledbqld;

    private idw.idwws.Ijinspecao ijinspecao;

    private java.math.BigDecimal origemmoduloqld;

    public Ijaledbqldinsp() {
    }

    public Ijaledbqldinsp(
           double idregistro,
           idw.idwws.Ijaledbqld ijaledbqld,
           idw.idwws.Ijinspecao ijinspecao,
           java.math.BigDecimal origemmoduloqld) {
           this.idregistro = idregistro;
           this.ijaledbqld = ijaledbqld;
           this.ijinspecao = ijinspecao;
           this.origemmoduloqld = origemmoduloqld;
    }


    /**
     * Gets the idregistro value for this Ijaledbqldinsp.
     * 
     * @return idregistro
     */
    public double getIdregistro() {
        return idregistro;
    }


    /**
     * Sets the idregistro value for this Ijaledbqldinsp.
     * 
     * @param idregistro
     */
    public void setIdregistro(double idregistro) {
        this.idregistro = idregistro;
    }


    /**
     * Gets the ijaledbqld value for this Ijaledbqldinsp.
     * 
     * @return ijaledbqld
     */
    public idw.idwws.Ijaledbqld getIjaledbqld() {
        return ijaledbqld;
    }


    /**
     * Sets the ijaledbqld value for this Ijaledbqldinsp.
     * 
     * @param ijaledbqld
     */
    public void setIjaledbqld(idw.idwws.Ijaledbqld ijaledbqld) {
        this.ijaledbqld = ijaledbqld;
    }


    /**
     * Gets the ijinspecao value for this Ijaledbqldinsp.
     * 
     * @return ijinspecao
     */
    public idw.idwws.Ijinspecao getIjinspecao() {
        return ijinspecao;
    }


    /**
     * Sets the ijinspecao value for this Ijaledbqldinsp.
     * 
     * @param ijinspecao
     */
    public void setIjinspecao(idw.idwws.Ijinspecao ijinspecao) {
        this.ijinspecao = ijinspecao;
    }


    /**
     * Gets the origemmoduloqld value for this Ijaledbqldinsp.
     * 
     * @return origemmoduloqld
     */
    public java.math.BigDecimal getOrigemmoduloqld() {
        return origemmoduloqld;
    }


    /**
     * Sets the origemmoduloqld value for this Ijaledbqldinsp.
     * 
     * @param origemmoduloqld
     */
    public void setOrigemmoduloqld(java.math.BigDecimal origemmoduloqld) {
        this.origemmoduloqld = origemmoduloqld;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijaledbqldinsp)) return false;
        Ijaledbqldinsp other = (Ijaledbqldinsp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idregistro == other.getIdregistro() &&
            ((this.ijaledbqld==null && other.getIjaledbqld()==null) || 
             (this.ijaledbqld!=null &&
              this.ijaledbqld.equals(other.getIjaledbqld()))) &&
            ((this.ijinspecao==null && other.getIjinspecao()==null) || 
             (this.ijinspecao!=null &&
              this.ijinspecao.equals(other.getIjinspecao()))) &&
            ((this.origemmoduloqld==null && other.getOrigemmoduloqld()==null) || 
             (this.origemmoduloqld!=null &&
              this.origemmoduloqld.equals(other.getOrigemmoduloqld())));
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
        _hashCode += new Double(getIdregistro()).hashCode();
        if (getIjaledbqld() != null) {
            _hashCode += getIjaledbqld().hashCode();
        }
        if (getIjinspecao() != null) {
            _hashCode += getIjinspecao().hashCode();
        }
        if (getOrigemmoduloqld() != null) {
            _hashCode += getOrigemmoduloqld().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijaledbqldinsp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijaledbqldinsp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idregistro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idregistro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijaledbqld");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijaledbqld"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijaledbqld"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijinspecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijinspecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijinspecao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("origemmoduloqld");
        elemField.setXmlName(new javax.xml.namespace.QName("", "origemmoduloqld"));
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
