/**
 * DwPassmon.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwPassmon  extends idw.idwws.DwPassmonTemplate  implements java.io.Serializable {
    private java.lang.String dsMon;

    private idw.idwws.DwPassagem dwPassagem;

    private long idPassmon;

    private java.lang.Boolean isAlternativo;

    private idw.idwws.OmProduto omProduto;

    public DwPassmon() {
    }

    public DwPassmon(
           java.lang.String dsMon,
           idw.idwws.DwPassagem dwPassagem,
           long idPassmon,
           java.lang.Boolean isAlternativo,
           idw.idwws.OmProduto omProduto) {
        this.dsMon = dsMon;
        this.dwPassagem = dwPassagem;
        this.idPassmon = idPassmon;
        this.isAlternativo = isAlternativo;
        this.omProduto = omProduto;
    }


    /**
     * Gets the dsMon value for this DwPassmon.
     * 
     * @return dsMon
     */
    public java.lang.String getDsMon() {
        return dsMon;
    }


    /**
     * Sets the dsMon value for this DwPassmon.
     * 
     * @param dsMon
     */
    public void setDsMon(java.lang.String dsMon) {
        this.dsMon = dsMon;
    }


    /**
     * Gets the dwPassagem value for this DwPassmon.
     * 
     * @return dwPassagem
     */
    public idw.idwws.DwPassagem getDwPassagem() {
        return dwPassagem;
    }


    /**
     * Sets the dwPassagem value for this DwPassmon.
     * 
     * @param dwPassagem
     */
    public void setDwPassagem(idw.idwws.DwPassagem dwPassagem) {
        this.dwPassagem = dwPassagem;
    }


    /**
     * Gets the idPassmon value for this DwPassmon.
     * 
     * @return idPassmon
     */
    public long getIdPassmon() {
        return idPassmon;
    }


    /**
     * Sets the idPassmon value for this DwPassmon.
     * 
     * @param idPassmon
     */
    public void setIdPassmon(long idPassmon) {
        this.idPassmon = idPassmon;
    }


    /**
     * Gets the isAlternativo value for this DwPassmon.
     * 
     * @return isAlternativo
     */
    public java.lang.Boolean getIsAlternativo() {
        return isAlternativo;
    }


    /**
     * Sets the isAlternativo value for this DwPassmon.
     * 
     * @param isAlternativo
     */
    public void setIsAlternativo(java.lang.Boolean isAlternativo) {
        this.isAlternativo = isAlternativo;
    }


    /**
     * Gets the omProduto value for this DwPassmon.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this DwPassmon.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwPassmon)) return false;
        DwPassmon other = (DwPassmon) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dsMon==null && other.getDsMon()==null) || 
             (this.dsMon!=null &&
              this.dsMon.equals(other.getDsMon()))) &&
            ((this.dwPassagem==null && other.getDwPassagem()==null) || 
             (this.dwPassagem!=null &&
              this.dwPassagem.equals(other.getDwPassagem()))) &&
            this.idPassmon == other.getIdPassmon() &&
            ((this.isAlternativo==null && other.getIsAlternativo()==null) || 
             (this.isAlternativo!=null &&
              this.isAlternativo.equals(other.getIsAlternativo()))) &&
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
        if (getDsMon() != null) {
            _hashCode += getDsMon().hashCode();
        }
        if (getDwPassagem() != null) {
            _hashCode += getDwPassagem().hashCode();
        }
        _hashCode += new Long(getIdPassmon()).hashCode();
        if (getIsAlternativo() != null) {
            _hashCode += getIsAlternativo().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwPassmon.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassmon"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsMon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsMon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPassagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPassagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassagem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPassmon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPassmon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAlternativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isAlternativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
