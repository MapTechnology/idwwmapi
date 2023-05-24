/**
 * DwFolharapcom.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwFolharapcom  extends idw.idwws.DwFolharapcomTemplate  implements java.io.Serializable {
    private idw.idwws.DwFolharap dwFolharap;

    private java.lang.Long idFolharapcom;

    private idw.idwws.OmProduto omProduto;

    private java.math.BigDecimal qtAtiva;

    private java.math.BigDecimal qtTotal;

    public DwFolharapcom() {
    }

    public DwFolharapcom(
           idw.idwws.DwFolharap dwFolharap,
           java.lang.Long idFolharapcom,
           idw.idwws.OmProduto omProduto,
           java.math.BigDecimal qtAtiva,
           java.math.BigDecimal qtTotal) {
        this.dwFolharap = dwFolharap;
        this.idFolharapcom = idFolharapcom;
        this.omProduto = omProduto;
        this.qtAtiva = qtAtiva;
        this.qtTotal = qtTotal;
    }


    /**
     * Gets the dwFolharap value for this DwFolharapcom.
     * 
     * @return dwFolharap
     */
    public idw.idwws.DwFolharap getDwFolharap() {
        return dwFolharap;
    }


    /**
     * Sets the dwFolharap value for this DwFolharapcom.
     * 
     * @param dwFolharap
     */
    public void setDwFolharap(idw.idwws.DwFolharap dwFolharap) {
        this.dwFolharap = dwFolharap;
    }


    /**
     * Gets the idFolharapcom value for this DwFolharapcom.
     * 
     * @return idFolharapcom
     */
    public java.lang.Long getIdFolharapcom() {
        return idFolharapcom;
    }


    /**
     * Sets the idFolharapcom value for this DwFolharapcom.
     * 
     * @param idFolharapcom
     */
    public void setIdFolharapcom(java.lang.Long idFolharapcom) {
        this.idFolharapcom = idFolharapcom;
    }


    /**
     * Gets the omProduto value for this DwFolharapcom.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this DwFolharapcom.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the qtAtiva value for this DwFolharapcom.
     * 
     * @return qtAtiva
     */
    public java.math.BigDecimal getQtAtiva() {
        return qtAtiva;
    }


    /**
     * Sets the qtAtiva value for this DwFolharapcom.
     * 
     * @param qtAtiva
     */
    public void setQtAtiva(java.math.BigDecimal qtAtiva) {
        this.qtAtiva = qtAtiva;
    }


    /**
     * Gets the qtTotal value for this DwFolharapcom.
     * 
     * @return qtTotal
     */
    public java.math.BigDecimal getQtTotal() {
        return qtTotal;
    }


    /**
     * Sets the qtTotal value for this DwFolharapcom.
     * 
     * @param qtTotal
     */
    public void setQtTotal(java.math.BigDecimal qtTotal) {
        this.qtTotal = qtTotal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwFolharapcom)) return false;
        DwFolharapcom other = (DwFolharapcom) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwFolharap==null && other.getDwFolharap()==null) || 
             (this.dwFolharap!=null &&
              this.dwFolharap.equals(other.getDwFolharap()))) &&
            ((this.idFolharapcom==null && other.getIdFolharapcom()==null) || 
             (this.idFolharapcom!=null &&
              this.idFolharapcom.equals(other.getIdFolharapcom()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.qtAtiva==null && other.getQtAtiva()==null) || 
             (this.qtAtiva!=null &&
              this.qtAtiva.equals(other.getQtAtiva()))) &&
            ((this.qtTotal==null && other.getQtTotal()==null) || 
             (this.qtTotal!=null &&
              this.qtTotal.equals(other.getQtTotal())));
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
        if (getDwFolharap() != null) {
            _hashCode += getDwFolharap().hashCode();
        }
        if (getIdFolharapcom() != null) {
            _hashCode += getIdFolharapcom().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getQtAtiva() != null) {
            _hashCode += getQtAtiva().hashCode();
        }
        if (getQtTotal() != null) {
            _hashCode += getQtTotal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwFolharapcom.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolharapcom"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolharap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolharap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolharap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFolharapcom");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFolharapcom"));
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
        elemField.setFieldName("qtAtiva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAtiva"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtTotal"));
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
