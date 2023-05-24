/**
 * DwPasscau.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwPasscau  extends idw.idwws.DwPasscauTemplate  implements java.io.Serializable {
    private idw.idwws.DwPassagem dwPassagem;

    private idw.idwws.DwTAcao dwTAcao;

    private idw.idwws.DwTDefeito dwTDefeito;

    private long idPasscau;

    private idw.idwws.OmProduto omProduto;

    public DwPasscau() {
    }

    public DwPasscau(
           idw.idwws.DwPassagem dwPassagem,
           idw.idwws.DwTAcao dwTAcao,
           idw.idwws.DwTDefeito dwTDefeito,
           long idPasscau,
           idw.idwws.OmProduto omProduto) {
        this.dwPassagem = dwPassagem;
        this.dwTAcao = dwTAcao;
        this.dwTDefeito = dwTDefeito;
        this.idPasscau = idPasscau;
        this.omProduto = omProduto;
    }


    /**
     * Gets the dwPassagem value for this DwPasscau.
     * 
     * @return dwPassagem
     */
    public idw.idwws.DwPassagem getDwPassagem() {
        return dwPassagem;
    }


    /**
     * Sets the dwPassagem value for this DwPasscau.
     * 
     * @param dwPassagem
     */
    public void setDwPassagem(idw.idwws.DwPassagem dwPassagem) {
        this.dwPassagem = dwPassagem;
    }


    /**
     * Gets the dwTAcao value for this DwPasscau.
     * 
     * @return dwTAcao
     */
    public idw.idwws.DwTAcao getDwTAcao() {
        return dwTAcao;
    }


    /**
     * Sets the dwTAcao value for this DwPasscau.
     * 
     * @param dwTAcao
     */
    public void setDwTAcao(idw.idwws.DwTAcao dwTAcao) {
        this.dwTAcao = dwTAcao;
    }


    /**
     * Gets the dwTDefeito value for this DwPasscau.
     * 
     * @return dwTDefeito
     */
    public idw.idwws.DwTDefeito getDwTDefeito() {
        return dwTDefeito;
    }


    /**
     * Sets the dwTDefeito value for this DwPasscau.
     * 
     * @param dwTDefeito
     */
    public void setDwTDefeito(idw.idwws.DwTDefeito dwTDefeito) {
        this.dwTDefeito = dwTDefeito;
    }


    /**
     * Gets the idPasscau value for this DwPasscau.
     * 
     * @return idPasscau
     */
    public long getIdPasscau() {
        return idPasscau;
    }


    /**
     * Sets the idPasscau value for this DwPasscau.
     * 
     * @param idPasscau
     */
    public void setIdPasscau(long idPasscau) {
        this.idPasscau = idPasscau;
    }


    /**
     * Gets the omProduto value for this DwPasscau.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this DwPasscau.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwPasscau)) return false;
        DwPasscau other = (DwPasscau) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwPassagem==null && other.getDwPassagem()==null) || 
             (this.dwPassagem!=null &&
              this.dwPassagem.equals(other.getDwPassagem()))) &&
            ((this.dwTAcao==null && other.getDwTAcao()==null) || 
             (this.dwTAcao!=null &&
              this.dwTAcao.equals(other.getDwTAcao()))) &&
            ((this.dwTDefeito==null && other.getDwTDefeito()==null) || 
             (this.dwTDefeito!=null &&
              this.dwTDefeito.equals(other.getDwTDefeito()))) &&
            this.idPasscau == other.getIdPasscau() &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto())));
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
        if (getDwPassagem() != null) {
            _hashCode += getDwPassagem().hashCode();
        }
        if (getDwTAcao() != null) {
            _hashCode += getDwTAcao().hashCode();
        }
        if (getDwTDefeito() != null) {
            _hashCode += getDwTDefeito().hashCode();
        }
        _hashCode += new Long(getIdPasscau()).hashCode();
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwPasscau.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPasscau"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPassagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPassagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassagem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTAcao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTAcao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTAcao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTDefeito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTDefeito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTDefeito"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPasscau");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPasscau"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
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
