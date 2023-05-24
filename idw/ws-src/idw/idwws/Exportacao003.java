/**
 * Exportacao003.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Exportacao003  implements java.io.Serializable {
    private idw.idwws.Exportacao003Id id;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtblocalparada ijtblocalparada;

    private idw.idwws.Ijtbpar ijtbpar;

    private idw.idwws.Ijtbvarritmo ijtbvarritmo;

    private org.apache.axis.types.UnsignedShort stexportacao;

    public Exportacao003() {
    }

    public Exportacao003(
           idw.idwws.Exportacao003Id id,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtblocalparada ijtblocalparada,
           idw.idwws.Ijtbpar ijtbpar,
           idw.idwws.Ijtbvarritmo ijtbvarritmo,
           org.apache.axis.types.UnsignedShort stexportacao) {
           this.id = id;
           this.ijop = ijop;
           this.ijtblocalparada = ijtblocalparada;
           this.ijtbpar = ijtbpar;
           this.ijtbvarritmo = ijtbvarritmo;
           this.stexportacao = stexportacao;
    }


    /**
     * Gets the id value for this Exportacao003.
     * 
     * @return id
     */
    public idw.idwws.Exportacao003Id getId() {
        return id;
    }


    /**
     * Sets the id value for this Exportacao003.
     * 
     * @param id
     */
    public void setId(idw.idwws.Exportacao003Id id) {
        this.id = id;
    }


    /**
     * Gets the ijop value for this Exportacao003.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Exportacao003.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtblocalparada value for this Exportacao003.
     * 
     * @return ijtblocalparada
     */
    public idw.idwws.Ijtblocalparada getIjtblocalparada() {
        return ijtblocalparada;
    }


    /**
     * Sets the ijtblocalparada value for this Exportacao003.
     * 
     * @param ijtblocalparada
     */
    public void setIjtblocalparada(idw.idwws.Ijtblocalparada ijtblocalparada) {
        this.ijtblocalparada = ijtblocalparada;
    }


    /**
     * Gets the ijtbpar value for this Exportacao003.
     * 
     * @return ijtbpar
     */
    public idw.idwws.Ijtbpar getIjtbpar() {
        return ijtbpar;
    }


    /**
     * Sets the ijtbpar value for this Exportacao003.
     * 
     * @param ijtbpar
     */
    public void setIjtbpar(idw.idwws.Ijtbpar ijtbpar) {
        this.ijtbpar = ijtbpar;
    }


    /**
     * Gets the ijtbvarritmo value for this Exportacao003.
     * 
     * @return ijtbvarritmo
     */
    public idw.idwws.Ijtbvarritmo getIjtbvarritmo() {
        return ijtbvarritmo;
    }


    /**
     * Sets the ijtbvarritmo value for this Exportacao003.
     * 
     * @param ijtbvarritmo
     */
    public void setIjtbvarritmo(idw.idwws.Ijtbvarritmo ijtbvarritmo) {
        this.ijtbvarritmo = ijtbvarritmo;
    }


    /**
     * Gets the stexportacao value for this Exportacao003.
     * 
     * @return stexportacao
     */
    public org.apache.axis.types.UnsignedShort getStexportacao() {
        return stexportacao;
    }


    /**
     * Sets the stexportacao value for this Exportacao003.
     * 
     * @param stexportacao
     */
    public void setStexportacao(org.apache.axis.types.UnsignedShort stexportacao) {
        this.stexportacao = stexportacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Exportacao003)) return false;
        Exportacao003 other = (Exportacao003) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijtblocalparada==null && other.getIjtblocalparada()==null) || 
             (this.ijtblocalparada!=null &&
              this.ijtblocalparada.equals(other.getIjtblocalparada()))) &&
            ((this.ijtbpar==null && other.getIjtbpar()==null) || 
             (this.ijtbpar!=null &&
              this.ijtbpar.equals(other.getIjtbpar()))) &&
            ((this.ijtbvarritmo==null && other.getIjtbvarritmo()==null) || 
             (this.ijtbvarritmo!=null &&
              this.ijtbvarritmo.equals(other.getIjtbvarritmo()))) &&
            ((this.stexportacao==null && other.getStexportacao()==null) || 
             (this.stexportacao!=null &&
              this.stexportacao.equals(other.getStexportacao())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjtblocalparada() != null) {
            _hashCode += getIjtblocalparada().hashCode();
        }
        if (getIjtbpar() != null) {
            _hashCode += getIjtbpar().hashCode();
        }
        if (getIjtbvarritmo() != null) {
            _hashCode += getIjtbvarritmo().hashCode();
        }
        if (getStexportacao() != null) {
            _hashCode += getStexportacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Exportacao003.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "exportacao003"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "exportacao003Id"));
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
        elemField.setFieldName("ijtblocalparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtblocalparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtblocalparada"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbvarritmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbvarritmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbvarritmo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stexportacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stexportacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
