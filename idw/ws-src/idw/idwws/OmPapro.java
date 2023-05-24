/**
 * OmPapro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmPapro  extends idw.idwws.OmPaproTemplate  implements java.io.Serializable {
    private long idPapro;

    private idw.idwws.OmMapapa omMapapa;

    private idw.idwws.OmPa omPa;

    private idw.idwws.OmProduto omProduto;

    private idw.idwws.OmPt omPt;

    private java.math.BigDecimal qtAtual;

    public OmPapro() {
    }

    public OmPapro(
           long idPapro,
           idw.idwws.OmMapapa omMapapa,
           idw.idwws.OmPa omPa,
           idw.idwws.OmProduto omProduto,
           idw.idwws.OmPt omPt,
           java.math.BigDecimal qtAtual) {
        this.idPapro = idPapro;
        this.omMapapa = omMapapa;
        this.omPa = omPa;
        this.omProduto = omProduto;
        this.omPt = omPt;
        this.qtAtual = qtAtual;
    }


    /**
     * Gets the idPapro value for this OmPapro.
     * 
     * @return idPapro
     */
    public long getIdPapro() {
        return idPapro;
    }


    /**
     * Sets the idPapro value for this OmPapro.
     * 
     * @param idPapro
     */
    public void setIdPapro(long idPapro) {
        this.idPapro = idPapro;
    }


    /**
     * Gets the omMapapa value for this OmPapro.
     * 
     * @return omMapapa
     */
    public idw.idwws.OmMapapa getOmMapapa() {
        return omMapapa;
    }


    /**
     * Sets the omMapapa value for this OmPapro.
     * 
     * @param omMapapa
     */
    public void setOmMapapa(idw.idwws.OmMapapa omMapapa) {
        this.omMapapa = omMapapa;
    }


    /**
     * Gets the omPa value for this OmPapro.
     * 
     * @return omPa
     */
    public idw.idwws.OmPa getOmPa() {
        return omPa;
    }


    /**
     * Sets the omPa value for this OmPapro.
     * 
     * @param omPa
     */
    public void setOmPa(idw.idwws.OmPa omPa) {
        this.omPa = omPa;
    }


    /**
     * Gets the omProduto value for this OmPapro.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this OmPapro.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the omPt value for this OmPapro.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this OmPapro.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the qtAtual value for this OmPapro.
     * 
     * @return qtAtual
     */
    public java.math.BigDecimal getQtAtual() {
        return qtAtual;
    }


    /**
     * Sets the qtAtual value for this OmPapro.
     * 
     * @param qtAtual
     */
    public void setQtAtual(java.math.BigDecimal qtAtual) {
        this.qtAtual = qtAtual;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmPapro)) return false;
        OmPapro other = (OmPapro) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.idPapro == other.getIdPapro() &&
            ((this.omMapapa==null && other.getOmMapapa()==null) || 
             (this.omMapapa!=null &&
              this.omMapapa.equals(other.getOmMapapa()))) &&
            ((this.omPa==null && other.getOmPa()==null) || 
             (this.omPa!=null &&
              this.omPa.equals(other.getOmPa()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.qtAtual==null && other.getQtAtual()==null) || 
             (this.qtAtual!=null &&
              this.qtAtual.equals(other.getQtAtual())));
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
        _hashCode += new Long(getIdPapro()).hashCode();
        if (getOmMapapa() != null) {
            _hashCode += getOmMapapa().hashCode();
        }
        if (getOmPa() != null) {
            _hashCode += getOmPa().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getQtAtual() != null) {
            _hashCode += getQtAtual().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmPapro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPapro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPapro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPapro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omMapapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omMapapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omMapapa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPa"));
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
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAtual");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAtual"));
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
