/**
 * Ijetqproduto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijetqproduto  implements java.io.Serializable {
    private java.lang.String cdbarrasproduto;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtbpro ijtbpro;

    private double nrseq;

    private double qtitensemb;

    public Ijetqproduto() {
    }

    public Ijetqproduto(
           java.lang.String cdbarrasproduto,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtbpro ijtbpro,
           double nrseq,
           double qtitensemb) {
           this.cdbarrasproduto = cdbarrasproduto;
           this.ijop = ijop;
           this.ijtbpro = ijtbpro;
           this.nrseq = nrseq;
           this.qtitensemb = qtitensemb;
    }


    /**
     * Gets the cdbarrasproduto value for this Ijetqproduto.
     * 
     * @return cdbarrasproduto
     */
    public java.lang.String getCdbarrasproduto() {
        return cdbarrasproduto;
    }


    /**
     * Sets the cdbarrasproduto value for this Ijetqproduto.
     * 
     * @param cdbarrasproduto
     */
    public void setCdbarrasproduto(java.lang.String cdbarrasproduto) {
        this.cdbarrasproduto = cdbarrasproduto;
    }


    /**
     * Gets the ijop value for this Ijetqproduto.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijetqproduto.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtbpro value for this Ijetqproduto.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijetqproduto.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the nrseq value for this Ijetqproduto.
     * 
     * @return nrseq
     */
    public double getNrseq() {
        return nrseq;
    }


    /**
     * Sets the nrseq value for this Ijetqproduto.
     * 
     * @param nrseq
     */
    public void setNrseq(double nrseq) {
        this.nrseq = nrseq;
    }


    /**
     * Gets the qtitensemb value for this Ijetqproduto.
     * 
     * @return qtitensemb
     */
    public double getQtitensemb() {
        return qtitensemb;
    }


    /**
     * Sets the qtitensemb value for this Ijetqproduto.
     * 
     * @param qtitensemb
     */
    public void setQtitensemb(double qtitensemb) {
        this.qtitensemb = qtitensemb;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijetqproduto)) return false;
        Ijetqproduto other = (Ijetqproduto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdbarrasproduto==null && other.getCdbarrasproduto()==null) || 
             (this.cdbarrasproduto!=null &&
              this.cdbarrasproduto.equals(other.getCdbarrasproduto()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            this.nrseq == other.getNrseq() &&
            this.qtitensemb == other.getQtitensemb();
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
        if (getCdbarrasproduto() != null) {
            _hashCode += getCdbarrasproduto().hashCode();
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        _hashCode += new Double(getNrseq()).hashCode();
        _hashCode += new Double(getQtitensemb()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijetqproduto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijetqproduto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdbarrasproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdbarrasproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
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
        elemField.setFieldName("nrseq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrseq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtitensemb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtitensemb"));
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
