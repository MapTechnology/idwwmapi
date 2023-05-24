/**
 * Ijreprodt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijreprodt  implements java.io.Serializable {
    private java.util.Calendar dtCadastro;

    private java.util.Calendar dtReferencia;

    private double idReproc;

    private idw.idwws.Ijtbtur ijtbtur;

    private org.apache.axis.types.UnsignedShort stOrigem;

    public Ijreprodt() {
    }

    public Ijreprodt(
           java.util.Calendar dtCadastro,
           java.util.Calendar dtReferencia,
           double idReproc,
           idw.idwws.Ijtbtur ijtbtur,
           org.apache.axis.types.UnsignedShort stOrigem) {
           this.dtCadastro = dtCadastro;
           this.dtReferencia = dtReferencia;
           this.idReproc = idReproc;
           this.ijtbtur = ijtbtur;
           this.stOrigem = stOrigem;
    }


    /**
     * Gets the dtCadastro value for this Ijreprodt.
     * 
     * @return dtCadastro
     */
    public java.util.Calendar getDtCadastro() {
        return dtCadastro;
    }


    /**
     * Sets the dtCadastro value for this Ijreprodt.
     * 
     * @param dtCadastro
     */
    public void setDtCadastro(java.util.Calendar dtCadastro) {
        this.dtCadastro = dtCadastro;
    }


    /**
     * Gets the dtReferencia value for this Ijreprodt.
     * 
     * @return dtReferencia
     */
    public java.util.Calendar getDtReferencia() {
        return dtReferencia;
    }


    /**
     * Sets the dtReferencia value for this Ijreprodt.
     * 
     * @param dtReferencia
     */
    public void setDtReferencia(java.util.Calendar dtReferencia) {
        this.dtReferencia = dtReferencia;
    }


    /**
     * Gets the idReproc value for this Ijreprodt.
     * 
     * @return idReproc
     */
    public double getIdReproc() {
        return idReproc;
    }


    /**
     * Sets the idReproc value for this Ijreprodt.
     * 
     * @param idReproc
     */
    public void setIdReproc(double idReproc) {
        this.idReproc = idReproc;
    }


    /**
     * Gets the ijtbtur value for this Ijreprodt.
     * 
     * @return ijtbtur
     */
    public idw.idwws.Ijtbtur getIjtbtur() {
        return ijtbtur;
    }


    /**
     * Sets the ijtbtur value for this Ijreprodt.
     * 
     * @param ijtbtur
     */
    public void setIjtbtur(idw.idwws.Ijtbtur ijtbtur) {
        this.ijtbtur = ijtbtur;
    }


    /**
     * Gets the stOrigem value for this Ijreprodt.
     * 
     * @return stOrigem
     */
    public org.apache.axis.types.UnsignedShort getStOrigem() {
        return stOrigem;
    }


    /**
     * Sets the stOrigem value for this Ijreprodt.
     * 
     * @param stOrigem
     */
    public void setStOrigem(org.apache.axis.types.UnsignedShort stOrigem) {
        this.stOrigem = stOrigem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijreprodt)) return false;
        Ijreprodt other = (Ijreprodt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dtCadastro==null && other.getDtCadastro()==null) || 
             (this.dtCadastro!=null &&
              this.dtCadastro.equals(other.getDtCadastro()))) &&
            ((this.dtReferencia==null && other.getDtReferencia()==null) || 
             (this.dtReferencia!=null &&
              this.dtReferencia.equals(other.getDtReferencia()))) &&
            this.idReproc == other.getIdReproc() &&
            ((this.ijtbtur==null && other.getIjtbtur()==null) || 
             (this.ijtbtur!=null &&
              this.ijtbtur.equals(other.getIjtbtur()))) &&
            ((this.stOrigem==null && other.getStOrigem()==null) || 
             (this.stOrigem!=null &&
              this.stOrigem.equals(other.getStOrigem())));
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
        if (getDtCadastro() != null) {
            _hashCode += getDtCadastro().hashCode();
        }
        if (getDtReferencia() != null) {
            _hashCode += getDtReferencia().hashCode();
        }
        _hashCode += new Double(getIdReproc()).hashCode();
        if (getIjtbtur() != null) {
            _hashCode += getIjtbtur().hashCode();
        }
        if (getStOrigem() != null) {
            _hashCode += getStOrigem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijreprodt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreprodt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtCadastro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtCadastro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idReproc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idReproc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbtur");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbtur"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtur"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stOrigem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stOrigem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
