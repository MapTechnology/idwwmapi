/**
 * Ijtbprodeflote.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbprodeflote  implements java.io.Serializable {
    private java.lang.String cdproduto;

    private idw.idwws.Ijtbpro ijtbpro;

    private double percfirmlote;

    private java.math.BigDecimal tamlotepadrao;

    public Ijtbprodeflote() {
    }

    public Ijtbprodeflote(
           java.lang.String cdproduto,
           idw.idwws.Ijtbpro ijtbpro,
           double percfirmlote,
           java.math.BigDecimal tamlotepadrao) {
           this.cdproduto = cdproduto;
           this.ijtbpro = ijtbpro;
           this.percfirmlote = percfirmlote;
           this.tamlotepadrao = tamlotepadrao;
    }


    /**
     * Gets the cdproduto value for this Ijtbprodeflote.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this Ijtbprodeflote.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the ijtbpro value for this Ijtbprodeflote.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijtbprodeflote.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the percfirmlote value for this Ijtbprodeflote.
     * 
     * @return percfirmlote
     */
    public double getPercfirmlote() {
        return percfirmlote;
    }


    /**
     * Sets the percfirmlote value for this Ijtbprodeflote.
     * 
     * @param percfirmlote
     */
    public void setPercfirmlote(double percfirmlote) {
        this.percfirmlote = percfirmlote;
    }


    /**
     * Gets the tamlotepadrao value for this Ijtbprodeflote.
     * 
     * @return tamlotepadrao
     */
    public java.math.BigDecimal getTamlotepadrao() {
        return tamlotepadrao;
    }


    /**
     * Sets the tamlotepadrao value for this Ijtbprodeflote.
     * 
     * @param tamlotepadrao
     */
    public void setTamlotepadrao(java.math.BigDecimal tamlotepadrao) {
        this.tamlotepadrao = tamlotepadrao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbprodeflote)) return false;
        Ijtbprodeflote other = (Ijtbprodeflote) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdproduto==null && other.getCdproduto()==null) || 
             (this.cdproduto!=null &&
              this.cdproduto.equals(other.getCdproduto()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            this.percfirmlote == other.getPercfirmlote() &&
            ((this.tamlotepadrao==null && other.getTamlotepadrao()==null) || 
             (this.tamlotepadrao!=null &&
              this.tamlotepadrao.equals(other.getTamlotepadrao())));
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
        if (getCdproduto() != null) {
            _hashCode += getCdproduto().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        _hashCode += new Double(getPercfirmlote()).hashCode();
        if (getTamlotepadrao() != null) {
            _hashCode += getTamlotepadrao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbprodeflote.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbprodeflote"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("percfirmlote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "percfirmlote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tamlotepadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tamlotepadrao"));
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
