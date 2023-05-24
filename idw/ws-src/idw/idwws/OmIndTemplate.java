/**
 * OmIndTemplate.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public abstract class OmIndTemplate  extends idw.idwws.AbstractTemplate  implements java.io.Serializable {
    private boolean eficienciaCiclo;

    private boolean eficienciaRealizacao;

    private boolean indiceParada;

    private boolean indiceRefugo;

    private boolean oee;

    private boolean produtividade;

    private boolean qualidade;

    private boolean ritmo;

    private boolean ritmoPerc;

    public OmIndTemplate() {
    }

    public OmIndTemplate(
           boolean eficienciaCiclo,
           boolean eficienciaRealizacao,
           boolean indiceParada,
           boolean indiceRefugo,
           boolean oee,
           boolean produtividade,
           boolean qualidade,
           boolean ritmo,
           boolean ritmoPerc) {
        this.eficienciaCiclo = eficienciaCiclo;
        this.eficienciaRealizacao = eficienciaRealizacao;
        this.indiceParada = indiceParada;
        this.indiceRefugo = indiceRefugo;
        this.oee = oee;
        this.produtividade = produtividade;
        this.qualidade = qualidade;
        this.ritmo = ritmo;
        this.ritmoPerc = ritmoPerc;
    }


    /**
     * Gets the eficienciaCiclo value for this OmIndTemplate.
     * 
     * @return eficienciaCiclo
     */
    public boolean isEficienciaCiclo() {
        return eficienciaCiclo;
    }


    /**
     * Sets the eficienciaCiclo value for this OmIndTemplate.
     * 
     * @param eficienciaCiclo
     */
    public void setEficienciaCiclo(boolean eficienciaCiclo) {
        this.eficienciaCiclo = eficienciaCiclo;
    }


    /**
     * Gets the eficienciaRealizacao value for this OmIndTemplate.
     * 
     * @return eficienciaRealizacao
     */
    public boolean isEficienciaRealizacao() {
        return eficienciaRealizacao;
    }


    /**
     * Sets the eficienciaRealizacao value for this OmIndTemplate.
     * 
     * @param eficienciaRealizacao
     */
    public void setEficienciaRealizacao(boolean eficienciaRealizacao) {
        this.eficienciaRealizacao = eficienciaRealizacao;
    }


    /**
     * Gets the indiceParada value for this OmIndTemplate.
     * 
     * @return indiceParada
     */
    public boolean isIndiceParada() {
        return indiceParada;
    }


    /**
     * Sets the indiceParada value for this OmIndTemplate.
     * 
     * @param indiceParada
     */
    public void setIndiceParada(boolean indiceParada) {
        this.indiceParada = indiceParada;
    }


    /**
     * Gets the indiceRefugo value for this OmIndTemplate.
     * 
     * @return indiceRefugo
     */
    public boolean isIndiceRefugo() {
        return indiceRefugo;
    }


    /**
     * Sets the indiceRefugo value for this OmIndTemplate.
     * 
     * @param indiceRefugo
     */
    public void setIndiceRefugo(boolean indiceRefugo) {
        this.indiceRefugo = indiceRefugo;
    }


    /**
     * Gets the oee value for this OmIndTemplate.
     * 
     * @return oee
     */
    public boolean isOee() {
        return oee;
    }


    /**
     * Sets the oee value for this OmIndTemplate.
     * 
     * @param oee
     */
    public void setOee(boolean oee) {
        this.oee = oee;
    }


    /**
     * Gets the produtividade value for this OmIndTemplate.
     * 
     * @return produtividade
     */
    public boolean isProdutividade() {
        return produtividade;
    }


    /**
     * Sets the produtividade value for this OmIndTemplate.
     * 
     * @param produtividade
     */
    public void setProdutividade(boolean produtividade) {
        this.produtividade = produtividade;
    }


    /**
     * Gets the qualidade value for this OmIndTemplate.
     * 
     * @return qualidade
     */
    public boolean isQualidade() {
        return qualidade;
    }


    /**
     * Sets the qualidade value for this OmIndTemplate.
     * 
     * @param qualidade
     */
    public void setQualidade(boolean qualidade) {
        this.qualidade = qualidade;
    }


    /**
     * Gets the ritmo value for this OmIndTemplate.
     * 
     * @return ritmo
     */
    public boolean isRitmo() {
        return ritmo;
    }


    /**
     * Sets the ritmo value for this OmIndTemplate.
     * 
     * @param ritmo
     */
    public void setRitmo(boolean ritmo) {
        this.ritmo = ritmo;
    }


    /**
     * Gets the ritmoPerc value for this OmIndTemplate.
     * 
     * @return ritmoPerc
     */
    public boolean isRitmoPerc() {
        return ritmoPerc;
    }


    /**
     * Sets the ritmoPerc value for this OmIndTemplate.
     * 
     * @param ritmoPerc
     */
    public void setRitmoPerc(boolean ritmoPerc) {
        this.ritmoPerc = ritmoPerc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmIndTemplate)) return false;
        OmIndTemplate other = (OmIndTemplate) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.eficienciaCiclo == other.isEficienciaCiclo() &&
            this.eficienciaRealizacao == other.isEficienciaRealizacao() &&
            this.indiceParada == other.isIndiceParada() &&
            this.indiceRefugo == other.isIndiceRefugo() &&
            this.oee == other.isOee() &&
            this.produtividade == other.isProdutividade() &&
            this.qualidade == other.isQualidade() &&
            this.ritmo == other.isRitmo() &&
            this.ritmoPerc == other.isRitmoPerc();
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
        _hashCode += (isEficienciaCiclo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isEficienciaRealizacao() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIndiceParada() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIndiceRefugo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isOee() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isProdutividade() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isQualidade() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isRitmo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isRitmoPerc() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmIndTemplate.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omIndTemplate"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficienciaCiclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficienciaCiclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficienciaRealizacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficienciaRealizacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "oee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produtividade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produtividade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qualidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qualidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ritmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ritmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ritmoPerc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ritmoPerc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
