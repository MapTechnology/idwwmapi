/**
 * Ijinjcfgmetamonit.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijinjcfgmetamonit  implements java.io.Serializable {
    private double eficciclo;

    private double eficrealizacao;

    private double idregistro;

    private idw.idwws.Ijtbinj ijtbinj;

    public Ijinjcfgmetamonit() {
    }

    public Ijinjcfgmetamonit(
           double eficciclo,
           double eficrealizacao,
           double idregistro,
           idw.idwws.Ijtbinj ijtbinj) {
           this.eficciclo = eficciclo;
           this.eficrealizacao = eficrealizacao;
           this.idregistro = idregistro;
           this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the eficciclo value for this Ijinjcfgmetamonit.
     * 
     * @return eficciclo
     */
    public double getEficciclo() {
        return eficciclo;
    }


    /**
     * Sets the eficciclo value for this Ijinjcfgmetamonit.
     * 
     * @param eficciclo
     */
    public void setEficciclo(double eficciclo) {
        this.eficciclo = eficciclo;
    }


    /**
     * Gets the eficrealizacao value for this Ijinjcfgmetamonit.
     * 
     * @return eficrealizacao
     */
    public double getEficrealizacao() {
        return eficrealizacao;
    }


    /**
     * Sets the eficrealizacao value for this Ijinjcfgmetamonit.
     * 
     * @param eficrealizacao
     */
    public void setEficrealizacao(double eficrealizacao) {
        this.eficrealizacao = eficrealizacao;
    }


    /**
     * Gets the idregistro value for this Ijinjcfgmetamonit.
     * 
     * @return idregistro
     */
    public double getIdregistro() {
        return idregistro;
    }


    /**
     * Sets the idregistro value for this Ijinjcfgmetamonit.
     * 
     * @param idregistro
     */
    public void setIdregistro(double idregistro) {
        this.idregistro = idregistro;
    }


    /**
     * Gets the ijtbinj value for this Ijinjcfgmetamonit.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijinjcfgmetamonit.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijinjcfgmetamonit)) return false;
        Ijinjcfgmetamonit other = (Ijinjcfgmetamonit) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.eficciclo == other.getEficciclo() &&
            this.eficrealizacao == other.getEficrealizacao() &&
            this.idregistro == other.getIdregistro() &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj())));
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
        _hashCode += new Double(getEficciclo()).hashCode();
        _hashCode += new Double(getEficrealizacao()).hashCode();
        _hashCode += new Double(getIdregistro()).hashCode();
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijinjcfgmetamonit.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijinjcfgmetamonit"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficrealizacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficrealizacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idregistro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idregistro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
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
