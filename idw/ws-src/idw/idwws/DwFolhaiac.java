/**
 * DwFolhaiac.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwFolhaiac  extends idw.idwws.DwFolhaiacTemplate  implements java.io.Serializable {
    private idw.idwws.DwFolha dwFolha;

    private java.lang.Long idFolhaiac;

    private idw.idwws.OmPrg omPrg;

    private idw.idwws.OmProduto omProduto;

    private idw.idwws.OmProduto omProdutodois;

    private java.math.BigDecimal qtAtiva;

    public DwFolhaiac() {
    }

    public DwFolhaiac(
           idw.idwws.DwFolha dwFolha,
           java.lang.Long idFolhaiac,
           idw.idwws.OmPrg omPrg,
           idw.idwws.OmProduto omProduto,
           idw.idwws.OmProduto omProdutodois,
           java.math.BigDecimal qtAtiva) {
        this.dwFolha = dwFolha;
        this.idFolhaiac = idFolhaiac;
        this.omPrg = omPrg;
        this.omProduto = omProduto;
        this.omProdutodois = omProdutodois;
        this.qtAtiva = qtAtiva;
    }


    /**
     * Gets the dwFolha value for this DwFolhaiac.
     * 
     * @return dwFolha
     */
    public idw.idwws.DwFolha getDwFolha() {
        return dwFolha;
    }


    /**
     * Sets the dwFolha value for this DwFolhaiac.
     * 
     * @param dwFolha
     */
    public void setDwFolha(idw.idwws.DwFolha dwFolha) {
        this.dwFolha = dwFolha;
    }


    /**
     * Gets the idFolhaiac value for this DwFolhaiac.
     * 
     * @return idFolhaiac
     */
    public java.lang.Long getIdFolhaiac() {
        return idFolhaiac;
    }


    /**
     * Sets the idFolhaiac value for this DwFolhaiac.
     * 
     * @param idFolhaiac
     */
    public void setIdFolhaiac(java.lang.Long idFolhaiac) {
        this.idFolhaiac = idFolhaiac;
    }


    /**
     * Gets the omPrg value for this DwFolhaiac.
     * 
     * @return omPrg
     */
    public idw.idwws.OmPrg getOmPrg() {
        return omPrg;
    }


    /**
     * Sets the omPrg value for this DwFolhaiac.
     * 
     * @param omPrg
     */
    public void setOmPrg(idw.idwws.OmPrg omPrg) {
        this.omPrg = omPrg;
    }


    /**
     * Gets the omProduto value for this DwFolhaiac.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this DwFolhaiac.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the omProdutodois value for this DwFolhaiac.
     * 
     * @return omProdutodois
     */
    public idw.idwws.OmProduto getOmProdutodois() {
        return omProdutodois;
    }


    /**
     * Sets the omProdutodois value for this DwFolhaiac.
     * 
     * @param omProdutodois
     */
    public void setOmProdutodois(idw.idwws.OmProduto omProdutodois) {
        this.omProdutodois = omProdutodois;
    }


    /**
     * Gets the qtAtiva value for this DwFolhaiac.
     * 
     * @return qtAtiva
     */
    public java.math.BigDecimal getQtAtiva() {
        return qtAtiva;
    }


    /**
     * Sets the qtAtiva value for this DwFolhaiac.
     * 
     * @param qtAtiva
     */
    public void setQtAtiva(java.math.BigDecimal qtAtiva) {
        this.qtAtiva = qtAtiva;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwFolhaiac)) return false;
        DwFolhaiac other = (DwFolhaiac) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwFolha==null && other.getDwFolha()==null) || 
             (this.dwFolha!=null &&
              this.dwFolha.equals(other.getDwFolha()))) &&
            ((this.idFolhaiac==null && other.getIdFolhaiac()==null) || 
             (this.idFolhaiac!=null &&
              this.idFolhaiac.equals(other.getIdFolhaiac()))) &&
            ((this.omPrg==null && other.getOmPrg()==null) || 
             (this.omPrg!=null &&
              this.omPrg.equals(other.getOmPrg()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.omProdutodois==null && other.getOmProdutodois()==null) || 
             (this.omProdutodois!=null &&
              this.omProdutodois.equals(other.getOmProdutodois()))) &&
            ((this.qtAtiva==null && other.getQtAtiva()==null) || 
             (this.qtAtiva!=null &&
              this.qtAtiva.equals(other.getQtAtiva())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getDwFolha() != null) {
            _hashCode += getDwFolha().hashCode();
        }
        if (getIdFolhaiac() != null) {
            _hashCode += getIdFolhaiac().hashCode();
        }
        if (getOmPrg() != null) {
            _hashCode += getOmPrg().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getOmProdutodois() != null) {
            _hashCode += getOmProdutodois().hashCode();
        }
        if (getQtAtiva() != null) {
            _hashCode += getQtAtiva().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwFolhaiac.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhaiac"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFolhaiac");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFolhaiac"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPrg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPrg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPrg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProdutodois");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProdutodois"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAtiva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAtiva"));
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
