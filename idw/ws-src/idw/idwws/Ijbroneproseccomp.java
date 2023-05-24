/**
 * Ijbroneproseccomp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijbroneproseccomp  implements java.io.Serializable {
    private idw.idwws.IjbroneproseccompId id;

    private idw.idwws.Ijtbmprima ijtbmprima;

    private idw.idwws.Ijtbpro ijtbpro;

    private double quantidade;

    public Ijbroneproseccomp() {
    }

    public Ijbroneproseccomp(
           idw.idwws.IjbroneproseccompId id,
           idw.idwws.Ijtbmprima ijtbmprima,
           idw.idwws.Ijtbpro ijtbpro,
           double quantidade) {
           this.id = id;
           this.ijtbmprima = ijtbmprima;
           this.ijtbpro = ijtbpro;
           this.quantidade = quantidade;
    }


    /**
     * Gets the id value for this Ijbroneproseccomp.
     * 
     * @return id
     */
    public idw.idwws.IjbroneproseccompId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijbroneproseccomp.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjbroneproseccompId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbmprima value for this Ijbroneproseccomp.
     * 
     * @return ijtbmprima
     */
    public idw.idwws.Ijtbmprima getIjtbmprima() {
        return ijtbmprima;
    }


    /**
     * Sets the ijtbmprima value for this Ijbroneproseccomp.
     * 
     * @param ijtbmprima
     */
    public void setIjtbmprima(idw.idwws.Ijtbmprima ijtbmprima) {
        this.ijtbmprima = ijtbmprima;
    }


    /**
     * Gets the ijtbpro value for this Ijbroneproseccomp.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijbroneproseccomp.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the quantidade value for this Ijbroneproseccomp.
     * 
     * @return quantidade
     */
    public double getQuantidade() {
        return quantidade;
    }


    /**
     * Sets the quantidade value for this Ijbroneproseccomp.
     * 
     * @param quantidade
     */
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijbroneproseccomp)) return false;
        Ijbroneproseccomp other = (Ijbroneproseccomp) obj;
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
            ((this.ijtbmprima==null && other.getIjtbmprima()==null) || 
             (this.ijtbmprima!=null &&
              this.ijtbmprima.equals(other.getIjtbmprima()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            this.quantidade == other.getQuantidade();
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
        if (getIjtbmprima() != null) {
            _hashCode += getIjtbmprima().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        _hashCode += new Double(getQuantidade()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijbroneproseccomp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijbroneproseccomp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijbroneproseccompId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmprima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmprima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmprima"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quantidade"));
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
