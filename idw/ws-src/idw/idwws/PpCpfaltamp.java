/**
 * PpCpfaltamp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpCpfaltamp  extends idw.idwws.PpCpfaltampTemplate  implements java.io.Serializable {
    private java.lang.Long idCpfaltamp;

    private idw.idwws.OmProduto omProduto;

    private idw.idwws.PpCp ppCp;

    private java.lang.Double qtde;

    private java.lang.Integer stMp;

    public PpCpfaltamp() {
    }

    public PpCpfaltamp(
           java.lang.Long idCpfaltamp,
           idw.idwws.OmProduto omProduto,
           idw.idwws.PpCp ppCp,
           java.lang.Double qtde,
           java.lang.Integer stMp) {
        this.idCpfaltamp = idCpfaltamp;
        this.omProduto = omProduto;
        this.ppCp = ppCp;
        this.qtde = qtde;
        this.stMp = stMp;
    }


    /**
     * Gets the idCpfaltamp value for this PpCpfaltamp.
     * 
     * @return idCpfaltamp
     */
    public java.lang.Long getIdCpfaltamp() {
        return idCpfaltamp;
    }


    /**
     * Sets the idCpfaltamp value for this PpCpfaltamp.
     * 
     * @param idCpfaltamp
     */
    public void setIdCpfaltamp(java.lang.Long idCpfaltamp) {
        this.idCpfaltamp = idCpfaltamp;
    }


    /**
     * Gets the omProduto value for this PpCpfaltamp.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this PpCpfaltamp.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the ppCp value for this PpCpfaltamp.
     * 
     * @return ppCp
     */
    public idw.idwws.PpCp getPpCp() {
        return ppCp;
    }


    /**
     * Sets the ppCp value for this PpCpfaltamp.
     * 
     * @param ppCp
     */
    public void setPpCp(idw.idwws.PpCp ppCp) {
        this.ppCp = ppCp;
    }


    /**
     * Gets the qtde value for this PpCpfaltamp.
     * 
     * @return qtde
     */
    public java.lang.Double getQtde() {
        return qtde;
    }


    /**
     * Sets the qtde value for this PpCpfaltamp.
     * 
     * @param qtde
     */
    public void setQtde(java.lang.Double qtde) {
        this.qtde = qtde;
    }


    /**
     * Gets the stMp value for this PpCpfaltamp.
     * 
     * @return stMp
     */
    public java.lang.Integer getStMp() {
        return stMp;
    }


    /**
     * Sets the stMp value for this PpCpfaltamp.
     * 
     * @param stMp
     */
    public void setStMp(java.lang.Integer stMp) {
        this.stMp = stMp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpCpfaltamp)) return false;
        PpCpfaltamp other = (PpCpfaltamp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.idCpfaltamp==null && other.getIdCpfaltamp()==null) || 
             (this.idCpfaltamp!=null &&
              this.idCpfaltamp.equals(other.getIdCpfaltamp()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.ppCp==null && other.getPpCp()==null) || 
             (this.ppCp!=null &&
              this.ppCp.equals(other.getPpCp()))) &&
            ((this.qtde==null && other.getQtde()==null) || 
             (this.qtde!=null &&
              this.qtde.equals(other.getQtde()))) &&
            ((this.stMp==null && other.getStMp()==null) || 
             (this.stMp!=null &&
              this.stMp.equals(other.getStMp())));
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
        if (getIdCpfaltamp() != null) {
            _hashCode += getIdCpfaltamp().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getPpCp() != null) {
            _hashCode += getPpCp().hashCode();
        }
        if (getQtde() != null) {
            _hashCode += getQtde().hashCode();
        }
        if (getStMp() != null) {
            _hashCode += getStMp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpCpfaltamp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpfaltamp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCpfaltamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCpfaltamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("ppCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stMp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stMp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
