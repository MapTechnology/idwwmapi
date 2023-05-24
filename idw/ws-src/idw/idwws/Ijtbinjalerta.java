/**
 * Ijtbinjalerta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbinjalerta  implements java.io.Serializable {
    private java.lang.String cdinjetora;

    private idw.idwws.Ijtbinj ijtbinj;

    private java.math.BigDecimal qtalertasdbq;

    private java.math.BigDecimal qtalertasextrinsp;

    private java.math.BigDecimal qtalertasextrpar;

    private java.math.BigDecimal qtalertasoperador;

    private java.math.BigDecimal qtalertasprobqld;

    public Ijtbinjalerta() {
    }

    public Ijtbinjalerta(
           java.lang.String cdinjetora,
           idw.idwws.Ijtbinj ijtbinj,
           java.math.BigDecimal qtalertasdbq,
           java.math.BigDecimal qtalertasextrinsp,
           java.math.BigDecimal qtalertasextrpar,
           java.math.BigDecimal qtalertasoperador,
           java.math.BigDecimal qtalertasprobqld) {
           this.cdinjetora = cdinjetora;
           this.ijtbinj = ijtbinj;
           this.qtalertasdbq = qtalertasdbq;
           this.qtalertasextrinsp = qtalertasextrinsp;
           this.qtalertasextrpar = qtalertasextrpar;
           this.qtalertasoperador = qtalertasoperador;
           this.qtalertasprobqld = qtalertasprobqld;
    }


    /**
     * Gets the cdinjetora value for this Ijtbinjalerta.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this Ijtbinjalerta.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the ijtbinj value for this Ijtbinjalerta.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijtbinjalerta.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the qtalertasdbq value for this Ijtbinjalerta.
     * 
     * @return qtalertasdbq
     */
    public java.math.BigDecimal getQtalertasdbq() {
        return qtalertasdbq;
    }


    /**
     * Sets the qtalertasdbq value for this Ijtbinjalerta.
     * 
     * @param qtalertasdbq
     */
    public void setQtalertasdbq(java.math.BigDecimal qtalertasdbq) {
        this.qtalertasdbq = qtalertasdbq;
    }


    /**
     * Gets the qtalertasextrinsp value for this Ijtbinjalerta.
     * 
     * @return qtalertasextrinsp
     */
    public java.math.BigDecimal getQtalertasextrinsp() {
        return qtalertasextrinsp;
    }


    /**
     * Sets the qtalertasextrinsp value for this Ijtbinjalerta.
     * 
     * @param qtalertasextrinsp
     */
    public void setQtalertasextrinsp(java.math.BigDecimal qtalertasextrinsp) {
        this.qtalertasextrinsp = qtalertasextrinsp;
    }


    /**
     * Gets the qtalertasextrpar value for this Ijtbinjalerta.
     * 
     * @return qtalertasextrpar
     */
    public java.math.BigDecimal getQtalertasextrpar() {
        return qtalertasextrpar;
    }


    /**
     * Sets the qtalertasextrpar value for this Ijtbinjalerta.
     * 
     * @param qtalertasextrpar
     */
    public void setQtalertasextrpar(java.math.BigDecimal qtalertasextrpar) {
        this.qtalertasextrpar = qtalertasextrpar;
    }


    /**
     * Gets the qtalertasoperador value for this Ijtbinjalerta.
     * 
     * @return qtalertasoperador
     */
    public java.math.BigDecimal getQtalertasoperador() {
        return qtalertasoperador;
    }


    /**
     * Sets the qtalertasoperador value for this Ijtbinjalerta.
     * 
     * @param qtalertasoperador
     */
    public void setQtalertasoperador(java.math.BigDecimal qtalertasoperador) {
        this.qtalertasoperador = qtalertasoperador;
    }


    /**
     * Gets the qtalertasprobqld value for this Ijtbinjalerta.
     * 
     * @return qtalertasprobqld
     */
    public java.math.BigDecimal getQtalertasprobqld() {
        return qtalertasprobqld;
    }


    /**
     * Sets the qtalertasprobqld value for this Ijtbinjalerta.
     * 
     * @param qtalertasprobqld
     */
    public void setQtalertasprobqld(java.math.BigDecimal qtalertasprobqld) {
        this.qtalertasprobqld = qtalertasprobqld;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbinjalerta)) return false;
        Ijtbinjalerta other = (Ijtbinjalerta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.qtalertasdbq==null && other.getQtalertasdbq()==null) || 
             (this.qtalertasdbq!=null &&
              this.qtalertasdbq.equals(other.getQtalertasdbq()))) &&
            ((this.qtalertasextrinsp==null && other.getQtalertasextrinsp()==null) || 
             (this.qtalertasextrinsp!=null &&
              this.qtalertasextrinsp.equals(other.getQtalertasextrinsp()))) &&
            ((this.qtalertasextrpar==null && other.getQtalertasextrpar()==null) || 
             (this.qtalertasextrpar!=null &&
              this.qtalertasextrpar.equals(other.getQtalertasextrpar()))) &&
            ((this.qtalertasoperador==null && other.getQtalertasoperador()==null) || 
             (this.qtalertasoperador!=null &&
              this.qtalertasoperador.equals(other.getQtalertasoperador()))) &&
            ((this.qtalertasprobqld==null && other.getQtalertasprobqld()==null) || 
             (this.qtalertasprobqld!=null &&
              this.qtalertasprobqld.equals(other.getQtalertasprobqld())));
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
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getQtalertasdbq() != null) {
            _hashCode += getQtalertasdbq().hashCode();
        }
        if (getQtalertasextrinsp() != null) {
            _hashCode += getQtalertasextrinsp().hashCode();
        }
        if (getQtalertasextrpar() != null) {
            _hashCode += getQtalertasextrpar().hashCode();
        }
        if (getQtalertasoperador() != null) {
            _hashCode += getQtalertasoperador().hashCode();
        }
        if (getQtalertasprobqld() != null) {
            _hashCode += getQtalertasprobqld().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbinjalerta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinjalerta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtalertasdbq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtalertasdbq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtalertasextrinsp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtalertasextrinsp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtalertasextrpar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtalertasextrpar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtalertasoperador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtalertasoperador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtalertasprobqld");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtalertasprobqld"));
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
