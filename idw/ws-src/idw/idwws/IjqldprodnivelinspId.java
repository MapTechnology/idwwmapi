/**
 * IjqldprodnivelinspId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjqldprodnivelinspId  implements java.io.Serializable {
    private java.lang.String cdproduto;

    private org.apache.axis.types.UnsignedShort nivelinspaaplicar;

    private double nivelnormalact;

    private double nivelseveraact;

    private double tamamostra;

    private double tammaxlote;

    private double tamminlote;

    public IjqldprodnivelinspId() {
    }

    public IjqldprodnivelinspId(
           java.lang.String cdproduto,
           org.apache.axis.types.UnsignedShort nivelinspaaplicar,
           double nivelnormalact,
           double nivelseveraact,
           double tamamostra,
           double tammaxlote,
           double tamminlote) {
           this.cdproduto = cdproduto;
           this.nivelinspaaplicar = nivelinspaaplicar;
           this.nivelnormalact = nivelnormalact;
           this.nivelseveraact = nivelseveraact;
           this.tamamostra = tamamostra;
           this.tammaxlote = tammaxlote;
           this.tamminlote = tamminlote;
    }


    /**
     * Gets the cdproduto value for this IjqldprodnivelinspId.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this IjqldprodnivelinspId.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the nivelinspaaplicar value for this IjqldprodnivelinspId.
     * 
     * @return nivelinspaaplicar
     */
    public org.apache.axis.types.UnsignedShort getNivelinspaaplicar() {
        return nivelinspaaplicar;
    }


    /**
     * Sets the nivelinspaaplicar value for this IjqldprodnivelinspId.
     * 
     * @param nivelinspaaplicar
     */
    public void setNivelinspaaplicar(org.apache.axis.types.UnsignedShort nivelinspaaplicar) {
        this.nivelinspaaplicar = nivelinspaaplicar;
    }


    /**
     * Gets the nivelnormalact value for this IjqldprodnivelinspId.
     * 
     * @return nivelnormalact
     */
    public double getNivelnormalact() {
        return nivelnormalact;
    }


    /**
     * Sets the nivelnormalact value for this IjqldprodnivelinspId.
     * 
     * @param nivelnormalact
     */
    public void setNivelnormalact(double nivelnormalact) {
        this.nivelnormalact = nivelnormalact;
    }


    /**
     * Gets the nivelseveraact value for this IjqldprodnivelinspId.
     * 
     * @return nivelseveraact
     */
    public double getNivelseveraact() {
        return nivelseveraact;
    }


    /**
     * Sets the nivelseveraact value for this IjqldprodnivelinspId.
     * 
     * @param nivelseveraact
     */
    public void setNivelseveraact(double nivelseveraact) {
        this.nivelseveraact = nivelseveraact;
    }


    /**
     * Gets the tamamostra value for this IjqldprodnivelinspId.
     * 
     * @return tamamostra
     */
    public double getTamamostra() {
        return tamamostra;
    }


    /**
     * Sets the tamamostra value for this IjqldprodnivelinspId.
     * 
     * @param tamamostra
     */
    public void setTamamostra(double tamamostra) {
        this.tamamostra = tamamostra;
    }


    /**
     * Gets the tammaxlote value for this IjqldprodnivelinspId.
     * 
     * @return tammaxlote
     */
    public double getTammaxlote() {
        return tammaxlote;
    }


    /**
     * Sets the tammaxlote value for this IjqldprodnivelinspId.
     * 
     * @param tammaxlote
     */
    public void setTammaxlote(double tammaxlote) {
        this.tammaxlote = tammaxlote;
    }


    /**
     * Gets the tamminlote value for this IjqldprodnivelinspId.
     * 
     * @return tamminlote
     */
    public double getTamminlote() {
        return tamminlote;
    }


    /**
     * Sets the tamminlote value for this IjqldprodnivelinspId.
     * 
     * @param tamminlote
     */
    public void setTamminlote(double tamminlote) {
        this.tamminlote = tamminlote;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjqldprodnivelinspId)) return false;
        IjqldprodnivelinspId other = (IjqldprodnivelinspId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdproduto==null && other.getCdproduto()==null) || 
             (this.cdproduto!=null &&
              this.cdproduto.equals(other.getCdproduto()))) &&
            ((this.nivelinspaaplicar==null && other.getNivelinspaaplicar()==null) || 
             (this.nivelinspaaplicar!=null &&
              this.nivelinspaaplicar.equals(other.getNivelinspaaplicar()))) &&
            this.nivelnormalact == other.getNivelnormalact() &&
            this.nivelseveraact == other.getNivelseveraact() &&
            this.tamamostra == other.getTamamostra() &&
            this.tammaxlote == other.getTammaxlote() &&
            this.tamminlote == other.getTamminlote();
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
        if (getCdproduto() != null) {
            _hashCode += getCdproduto().hashCode();
        }
        if (getNivelinspaaplicar() != null) {
            _hashCode += getNivelinspaaplicar().hashCode();
        }
        _hashCode += new Double(getNivelnormalact()).hashCode();
        _hashCode += new Double(getNivelseveraact()).hashCode();
        _hashCode += new Double(getTamamostra()).hashCode();
        _hashCode += new Double(getTammaxlote()).hashCode();
        _hashCode += new Double(getTamminlote()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjqldprodnivelinspId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijqldprodnivelinspId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nivelinspaaplicar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nivelinspaaplicar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nivelnormalact");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nivelnormalact"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nivelseveraact");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nivelseveraact"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tamamostra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tamamostra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tammaxlote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tammaxlote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tamminlote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tamminlote"));
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
