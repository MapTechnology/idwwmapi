/**
 * Ijmolproautorizpro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijmolproautorizpro  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedShort cdidentificacao;

    private idw.idwws.IjmolproautorizproId id;

    private idw.idwws.Ijmolproautorizmod ijmolproautorizmod;

    private idw.idwws.Ijtbpro ijtbpro;

    private double pbrutomedio;

    private double pliquidomedio;

    private double qtcavativas;

    private double qtcavidades;

    public Ijmolproautorizpro() {
    }

    public Ijmolproautorizpro(
           org.apache.axis.types.UnsignedShort cdidentificacao,
           idw.idwws.IjmolproautorizproId id,
           idw.idwws.Ijmolproautorizmod ijmolproautorizmod,
           idw.idwws.Ijtbpro ijtbpro,
           double pbrutomedio,
           double pliquidomedio,
           double qtcavativas,
           double qtcavidades) {
           this.cdidentificacao = cdidentificacao;
           this.id = id;
           this.ijmolproautorizmod = ijmolproautorizmod;
           this.ijtbpro = ijtbpro;
           this.pbrutomedio = pbrutomedio;
           this.pliquidomedio = pliquidomedio;
           this.qtcavativas = qtcavativas;
           this.qtcavidades = qtcavidades;
    }


    /**
     * Gets the cdidentificacao value for this Ijmolproautorizpro.
     * 
     * @return cdidentificacao
     */
    public org.apache.axis.types.UnsignedShort getCdidentificacao() {
        return cdidentificacao;
    }


    /**
     * Sets the cdidentificacao value for this Ijmolproautorizpro.
     * 
     * @param cdidentificacao
     */
    public void setCdidentificacao(org.apache.axis.types.UnsignedShort cdidentificacao) {
        this.cdidentificacao = cdidentificacao;
    }


    /**
     * Gets the id value for this Ijmolproautorizpro.
     * 
     * @return id
     */
    public idw.idwws.IjmolproautorizproId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijmolproautorizpro.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjmolproautorizproId id) {
        this.id = id;
    }


    /**
     * Gets the ijmolproautorizmod value for this Ijmolproautorizpro.
     * 
     * @return ijmolproautorizmod
     */
    public idw.idwws.Ijmolproautorizmod getIjmolproautorizmod() {
        return ijmolproautorizmod;
    }


    /**
     * Sets the ijmolproautorizmod value for this Ijmolproautorizpro.
     * 
     * @param ijmolproautorizmod
     */
    public void setIjmolproautorizmod(idw.idwws.Ijmolproautorizmod ijmolproautorizmod) {
        this.ijmolproautorizmod = ijmolproautorizmod;
    }


    /**
     * Gets the ijtbpro value for this Ijmolproautorizpro.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijmolproautorizpro.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the pbrutomedio value for this Ijmolproautorizpro.
     * 
     * @return pbrutomedio
     */
    public double getPbrutomedio() {
        return pbrutomedio;
    }


    /**
     * Sets the pbrutomedio value for this Ijmolproautorizpro.
     * 
     * @param pbrutomedio
     */
    public void setPbrutomedio(double pbrutomedio) {
        this.pbrutomedio = pbrutomedio;
    }


    /**
     * Gets the pliquidomedio value for this Ijmolproautorizpro.
     * 
     * @return pliquidomedio
     */
    public double getPliquidomedio() {
        return pliquidomedio;
    }


    /**
     * Sets the pliquidomedio value for this Ijmolproautorizpro.
     * 
     * @param pliquidomedio
     */
    public void setPliquidomedio(double pliquidomedio) {
        this.pliquidomedio = pliquidomedio;
    }


    /**
     * Gets the qtcavativas value for this Ijmolproautorizpro.
     * 
     * @return qtcavativas
     */
    public double getQtcavativas() {
        return qtcavativas;
    }


    /**
     * Sets the qtcavativas value for this Ijmolproautorizpro.
     * 
     * @param qtcavativas
     */
    public void setQtcavativas(double qtcavativas) {
        this.qtcavativas = qtcavativas;
    }


    /**
     * Gets the qtcavidades value for this Ijmolproautorizpro.
     * 
     * @return qtcavidades
     */
    public double getQtcavidades() {
        return qtcavidades;
    }


    /**
     * Sets the qtcavidades value for this Ijmolproautorizpro.
     * 
     * @param qtcavidades
     */
    public void setQtcavidades(double qtcavidades) {
        this.qtcavidades = qtcavidades;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijmolproautorizpro)) return false;
        Ijmolproautorizpro other = (Ijmolproautorizpro) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdidentificacao==null && other.getCdidentificacao()==null) || 
             (this.cdidentificacao!=null &&
              this.cdidentificacao.equals(other.getCdidentificacao()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijmolproautorizmod==null && other.getIjmolproautorizmod()==null) || 
             (this.ijmolproautorizmod!=null &&
              this.ijmolproautorizmod.equals(other.getIjmolproautorizmod()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            this.pbrutomedio == other.getPbrutomedio() &&
            this.pliquidomedio == other.getPliquidomedio() &&
            this.qtcavativas == other.getQtcavativas() &&
            this.qtcavidades == other.getQtcavidades();
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
        if (getCdidentificacao() != null) {
            _hashCode += getCdidentificacao().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjmolproautorizmod() != null) {
            _hashCode += getIjmolproautorizmod().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        _hashCode += new Double(getPbrutomedio()).hashCode();
        _hashCode += new Double(getPliquidomedio()).hashCode();
        _hashCode += new Double(getQtcavativas()).hashCode();
        _hashCode += new Double(getQtcavidades()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijmolproautorizpro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproautorizpro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdidentificacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdidentificacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproautorizproId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmolproautorizmod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmolproautorizmod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproautorizmod"));
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
        elemField.setFieldName("pbrutomedio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pbrutomedio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pliquidomedio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pliquidomedio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtcavativas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtcavativas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtcavidades");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtcavidades"));
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
