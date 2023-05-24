/**
 * Ijopmprima.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijopmprima  implements java.io.Serializable {
    private java.lang.String cdproduto;

    private java.util.Calendar dthrivalcompmprima;

    private double idreg;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtbmprima ijtbmprima;

    private java.lang.String nrlotemprima;

    public Ijopmprima() {
    }

    public Ijopmprima(
           java.lang.String cdproduto,
           java.util.Calendar dthrivalcompmprima,
           double idreg,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtbmprima ijtbmprima,
           java.lang.String nrlotemprima) {
           this.cdproduto = cdproduto;
           this.dthrivalcompmprima = dthrivalcompmprima;
           this.idreg = idreg;
           this.ijop = ijop;
           this.ijtbmprima = ijtbmprima;
           this.nrlotemprima = nrlotemprima;
    }


    /**
     * Gets the cdproduto value for this Ijopmprima.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this Ijopmprima.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the dthrivalcompmprima value for this Ijopmprima.
     * 
     * @return dthrivalcompmprima
     */
    public java.util.Calendar getDthrivalcompmprima() {
        return dthrivalcompmprima;
    }


    /**
     * Sets the dthrivalcompmprima value for this Ijopmprima.
     * 
     * @param dthrivalcompmprima
     */
    public void setDthrivalcompmprima(java.util.Calendar dthrivalcompmprima) {
        this.dthrivalcompmprima = dthrivalcompmprima;
    }


    /**
     * Gets the idreg value for this Ijopmprima.
     * 
     * @return idreg
     */
    public double getIdreg() {
        return idreg;
    }


    /**
     * Sets the idreg value for this Ijopmprima.
     * 
     * @param idreg
     */
    public void setIdreg(double idreg) {
        this.idreg = idreg;
    }


    /**
     * Gets the ijop value for this Ijopmprima.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijopmprima.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtbmprima value for this Ijopmprima.
     * 
     * @return ijtbmprima
     */
    public idw.idwws.Ijtbmprima getIjtbmprima() {
        return ijtbmprima;
    }


    /**
     * Sets the ijtbmprima value for this Ijopmprima.
     * 
     * @param ijtbmprima
     */
    public void setIjtbmprima(idw.idwws.Ijtbmprima ijtbmprima) {
        this.ijtbmprima = ijtbmprima;
    }


    /**
     * Gets the nrlotemprima value for this Ijopmprima.
     * 
     * @return nrlotemprima
     */
    public java.lang.String getNrlotemprima() {
        return nrlotemprima;
    }


    /**
     * Sets the nrlotemprima value for this Ijopmprima.
     * 
     * @param nrlotemprima
     */
    public void setNrlotemprima(java.lang.String nrlotemprima) {
        this.nrlotemprima = nrlotemprima;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijopmprima)) return false;
        Ijopmprima other = (Ijopmprima) obj;
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
            ((this.dthrivalcompmprima==null && other.getDthrivalcompmprima()==null) || 
             (this.dthrivalcompmprima!=null &&
              this.dthrivalcompmprima.equals(other.getDthrivalcompmprima()))) &&
            this.idreg == other.getIdreg() &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijtbmprima==null && other.getIjtbmprima()==null) || 
             (this.ijtbmprima!=null &&
              this.ijtbmprima.equals(other.getIjtbmprima()))) &&
            ((this.nrlotemprima==null && other.getNrlotemprima()==null) || 
             (this.nrlotemprima!=null &&
              this.nrlotemprima.equals(other.getNrlotemprima())));
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
        if (getDthrivalcompmprima() != null) {
            _hashCode += getDthrivalcompmprima().hashCode();
        }
        _hashCode += new Double(getIdreg()).hashCode();
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjtbmprima() != null) {
            _hashCode += getIjtbmprima().hashCode();
        }
        if (getNrlotemprima() != null) {
            _hashCode += getNrlotemprima().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijopmprima.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopmprima"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrivalcompmprima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrivalcompmprima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idreg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idreg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
        elemField.setFieldName("ijtbmprima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmprima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmprima"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrlotemprima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrlotemprima"));
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
