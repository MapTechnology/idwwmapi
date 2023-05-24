/**
 * Ijreaparintrasalog.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijreaparintrasalog  implements java.io.Serializable {
    private double idregintrasalog;

    private idw.idwws.Ijreapar ijreapar;

    private java.lang.String txtanotacao;

    public Ijreaparintrasalog() {
    }

    public Ijreaparintrasalog(
           double idregintrasalog,
           idw.idwws.Ijreapar ijreapar,
           java.lang.String txtanotacao) {
           this.idregintrasalog = idregintrasalog;
           this.ijreapar = ijreapar;
           this.txtanotacao = txtanotacao;
    }


    /**
     * Gets the idregintrasalog value for this Ijreaparintrasalog.
     * 
     * @return idregintrasalog
     */
    public double getIdregintrasalog() {
        return idregintrasalog;
    }


    /**
     * Sets the idregintrasalog value for this Ijreaparintrasalog.
     * 
     * @param idregintrasalog
     */
    public void setIdregintrasalog(double idregintrasalog) {
        this.idregintrasalog = idregintrasalog;
    }


    /**
     * Gets the ijreapar value for this Ijreaparintrasalog.
     * 
     * @return ijreapar
     */
    public idw.idwws.Ijreapar getIjreapar() {
        return ijreapar;
    }


    /**
     * Sets the ijreapar value for this Ijreaparintrasalog.
     * 
     * @param ijreapar
     */
    public void setIjreapar(idw.idwws.Ijreapar ijreapar) {
        this.ijreapar = ijreapar;
    }


    /**
     * Gets the txtanotacao value for this Ijreaparintrasalog.
     * 
     * @return txtanotacao
     */
    public java.lang.String getTxtanotacao() {
        return txtanotacao;
    }


    /**
     * Sets the txtanotacao value for this Ijreaparintrasalog.
     * 
     * @param txtanotacao
     */
    public void setTxtanotacao(java.lang.String txtanotacao) {
        this.txtanotacao = txtanotacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijreaparintrasalog)) return false;
        Ijreaparintrasalog other = (Ijreaparintrasalog) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idregintrasalog == other.getIdregintrasalog() &&
            ((this.ijreapar==null && other.getIjreapar()==null) || 
             (this.ijreapar!=null &&
              this.ijreapar.equals(other.getIjreapar()))) &&
            ((this.txtanotacao==null && other.getTxtanotacao()==null) || 
             (this.txtanotacao!=null &&
              this.txtanotacao.equals(other.getTxtanotacao())));
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
        _hashCode += new Double(getIdregintrasalog()).hashCode();
        if (getIjreapar() != null) {
            _hashCode += getIjreapar().hashCode();
        }
        if (getTxtanotacao() != null) {
            _hashCode += getTxtanotacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijreaparintrasalog.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreaparintrasalog"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idregintrasalog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idregintrasalog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreapar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreapar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreapar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("txtanotacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "txtanotacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
