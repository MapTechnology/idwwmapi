/**
 * Ijestruprod.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijestruprod  implements java.io.Serializable {
    private idw.idwws.IjestruprodId id;

    private idw.idwws.Ijtbpro ijtbproByCdproduto;

    private idw.idwws.Ijtbpro ijtbproByCdprodutoseq;

    private double qtitens;

    public Ijestruprod() {
    }

    public Ijestruprod(
           idw.idwws.IjestruprodId id,
           idw.idwws.Ijtbpro ijtbproByCdproduto,
           idw.idwws.Ijtbpro ijtbproByCdprodutoseq,
           double qtitens) {
           this.id = id;
           this.ijtbproByCdproduto = ijtbproByCdproduto;
           this.ijtbproByCdprodutoseq = ijtbproByCdprodutoseq;
           this.qtitens = qtitens;
    }


    /**
     * Gets the id value for this Ijestruprod.
     * 
     * @return id
     */
    public idw.idwws.IjestruprodId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijestruprod.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjestruprodId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbproByCdproduto value for this Ijestruprod.
     * 
     * @return ijtbproByCdproduto
     */
    public idw.idwws.Ijtbpro getIjtbproByCdproduto() {
        return ijtbproByCdproduto;
    }


    /**
     * Sets the ijtbproByCdproduto value for this Ijestruprod.
     * 
     * @param ijtbproByCdproduto
     */
    public void setIjtbproByCdproduto(idw.idwws.Ijtbpro ijtbproByCdproduto) {
        this.ijtbproByCdproduto = ijtbproByCdproduto;
    }


    /**
     * Gets the ijtbproByCdprodutoseq value for this Ijestruprod.
     * 
     * @return ijtbproByCdprodutoseq
     */
    public idw.idwws.Ijtbpro getIjtbproByCdprodutoseq() {
        return ijtbproByCdprodutoseq;
    }


    /**
     * Sets the ijtbproByCdprodutoseq value for this Ijestruprod.
     * 
     * @param ijtbproByCdprodutoseq
     */
    public void setIjtbproByCdprodutoseq(idw.idwws.Ijtbpro ijtbproByCdprodutoseq) {
        this.ijtbproByCdprodutoseq = ijtbproByCdprodutoseq;
    }


    /**
     * Gets the qtitens value for this Ijestruprod.
     * 
     * @return qtitens
     */
    public double getQtitens() {
        return qtitens;
    }


    /**
     * Sets the qtitens value for this Ijestruprod.
     * 
     * @param qtitens
     */
    public void setQtitens(double qtitens) {
        this.qtitens = qtitens;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijestruprod)) return false;
        Ijestruprod other = (Ijestruprod) obj;
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
            ((this.ijtbproByCdproduto==null && other.getIjtbproByCdproduto()==null) || 
             (this.ijtbproByCdproduto!=null &&
              this.ijtbproByCdproduto.equals(other.getIjtbproByCdproduto()))) &&
            ((this.ijtbproByCdprodutoseq==null && other.getIjtbproByCdprodutoseq()==null) || 
             (this.ijtbproByCdprodutoseq!=null &&
              this.ijtbproByCdprodutoseq.equals(other.getIjtbproByCdprodutoseq()))) &&
            this.qtitens == other.getQtitens();
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
        if (getIjtbproByCdproduto() != null) {
            _hashCode += getIjtbproByCdproduto().hashCode();
        }
        if (getIjtbproByCdprodutoseq() != null) {
            _hashCode += getIjtbproByCdprodutoseq().hashCode();
        }
        _hashCode += new Double(getQtitens()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijestruprod.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestruprod"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestruprodId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbproByCdproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbproByCdproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbproByCdprodutoseq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbproByCdprodutoseq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtitens");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtitens"));
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
