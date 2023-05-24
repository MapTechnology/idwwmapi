/**
 * Ijetqfaixa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijetqfaixa  implements java.io.Serializable {
    private idw.idwws.IjetqfaixaId id;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtbpro ijtbpro;

    private double nrseqfinal;

    private double nrseqinicial;

    private java.lang.Double nrultseqlida;

    public Ijetqfaixa() {
    }

    public Ijetqfaixa(
           idw.idwws.IjetqfaixaId id,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtbpro ijtbpro,
           double nrseqfinal,
           double nrseqinicial,
           java.lang.Double nrultseqlida) {
           this.id = id;
           this.ijop = ijop;
           this.ijtbpro = ijtbpro;
           this.nrseqfinal = nrseqfinal;
           this.nrseqinicial = nrseqinicial;
           this.nrultseqlida = nrultseqlida;
    }


    /**
     * Gets the id value for this Ijetqfaixa.
     * 
     * @return id
     */
    public idw.idwws.IjetqfaixaId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijetqfaixa.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjetqfaixaId id) {
        this.id = id;
    }


    /**
     * Gets the ijop value for this Ijetqfaixa.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijetqfaixa.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtbpro value for this Ijetqfaixa.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijetqfaixa.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the nrseqfinal value for this Ijetqfaixa.
     * 
     * @return nrseqfinal
     */
    public double getNrseqfinal() {
        return nrseqfinal;
    }


    /**
     * Sets the nrseqfinal value for this Ijetqfaixa.
     * 
     * @param nrseqfinal
     */
    public void setNrseqfinal(double nrseqfinal) {
        this.nrseqfinal = nrseqfinal;
    }


    /**
     * Gets the nrseqinicial value for this Ijetqfaixa.
     * 
     * @return nrseqinicial
     */
    public double getNrseqinicial() {
        return nrseqinicial;
    }


    /**
     * Sets the nrseqinicial value for this Ijetqfaixa.
     * 
     * @param nrseqinicial
     */
    public void setNrseqinicial(double nrseqinicial) {
        this.nrseqinicial = nrseqinicial;
    }


    /**
     * Gets the nrultseqlida value for this Ijetqfaixa.
     * 
     * @return nrultseqlida
     */
    public java.lang.Double getNrultseqlida() {
        return nrultseqlida;
    }


    /**
     * Sets the nrultseqlida value for this Ijetqfaixa.
     * 
     * @param nrultseqlida
     */
    public void setNrultseqlida(java.lang.Double nrultseqlida) {
        this.nrultseqlida = nrultseqlida;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijetqfaixa)) return false;
        Ijetqfaixa other = (Ijetqfaixa) obj;
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
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            this.nrseqfinal == other.getNrseqfinal() &&
            this.nrseqinicial == other.getNrseqinicial() &&
            ((this.nrultseqlida==null && other.getNrultseqlida()==null) || 
             (this.nrultseqlida!=null &&
              this.nrultseqlida.equals(other.getNrultseqlida())));
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
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        _hashCode += new Double(getNrseqfinal()).hashCode();
        _hashCode += new Double(getNrseqinicial()).hashCode();
        if (getNrultseqlida() != null) {
            _hashCode += getNrultseqlida().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijetqfaixa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijetqfaixa"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijetqfaixaId"));
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
        elemField.setFieldName("ijtbpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrseqfinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrseqfinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrseqinicial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrseqinicial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrultseqlida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrultseqlida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
