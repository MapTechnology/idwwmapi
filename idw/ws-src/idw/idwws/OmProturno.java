/**
 * OmProturno.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmProturno  extends idw.idwws.OmProturnoTemplate  implements java.io.Serializable {
    private idw.idwws.DwTurno dwTurno;

    private java.lang.Long idOmproturno;

    private idw.idwws.OmProduto omProduto;

    private java.lang.Integer tpRelacao;

    public OmProturno() {
    }

    public OmProturno(
           idw.idwws.DwTurno dwTurno,
           java.lang.Long idOmproturno,
           idw.idwws.OmProduto omProduto,
           java.lang.Integer tpRelacao) {
        this.dwTurno = dwTurno;
        this.idOmproturno = idOmproturno;
        this.omProduto = omProduto;
        this.tpRelacao = tpRelacao;
    }


    /**
     * Gets the dwTurno value for this OmProturno.
     * 
     * @return dwTurno
     */
    public idw.idwws.DwTurno getDwTurno() {
        return dwTurno;
    }


    /**
     * Sets the dwTurno value for this OmProturno.
     * 
     * @param dwTurno
     */
    public void setDwTurno(idw.idwws.DwTurno dwTurno) {
        this.dwTurno = dwTurno;
    }


    /**
     * Gets the idOmproturno value for this OmProturno.
     * 
     * @return idOmproturno
     */
    public java.lang.Long getIdOmproturno() {
        return idOmproturno;
    }


    /**
     * Sets the idOmproturno value for this OmProturno.
     * 
     * @param idOmproturno
     */
    public void setIdOmproturno(java.lang.Long idOmproturno) {
        this.idOmproturno = idOmproturno;
    }


    /**
     * Gets the omProduto value for this OmProturno.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this OmProturno.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the tpRelacao value for this OmProturno.
     * 
     * @return tpRelacao
     */
    public java.lang.Integer getTpRelacao() {
        return tpRelacao;
    }


    /**
     * Sets the tpRelacao value for this OmProturno.
     * 
     * @param tpRelacao
     */
    public void setTpRelacao(java.lang.Integer tpRelacao) {
        this.tpRelacao = tpRelacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmProturno)) return false;
        OmProturno other = (OmProturno) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwTurno==null && other.getDwTurno()==null) || 
             (this.dwTurno!=null &&
              this.dwTurno.equals(other.getDwTurno()))) &&
            ((this.idOmproturno==null && other.getIdOmproturno()==null) || 
             (this.idOmproturno!=null &&
              this.idOmproturno.equals(other.getIdOmproturno()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.tpRelacao==null && other.getTpRelacao()==null) || 
             (this.tpRelacao!=null &&
              this.tpRelacao.equals(other.getTpRelacao())));
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
        if (getDwTurno() != null) {
            _hashCode += getDwTurno().hashCode();
        }
        if (getIdOmproturno() != null) {
            _hashCode += getIdOmproturno().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getTpRelacao() != null) {
            _hashCode += getTpRelacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmProturno.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProturno"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTurno"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idOmproturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idOmproturno"));
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
        elemField.setFieldName("tpRelacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpRelacao"));
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
