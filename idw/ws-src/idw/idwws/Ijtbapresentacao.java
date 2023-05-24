/**
 * Ijtbapresentacao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbapresentacao  implements java.io.Serializable {
    private java.lang.String cdapresentacao;

    private java.lang.String dsapresentacao;

    private idw.idwws.Ijtbapresxslides[] ijtbapresxslideses;

    public Ijtbapresentacao() {
    }

    public Ijtbapresentacao(
           java.lang.String cdapresentacao,
           java.lang.String dsapresentacao,
           idw.idwws.Ijtbapresxslides[] ijtbapresxslideses) {
           this.cdapresentacao = cdapresentacao;
           this.dsapresentacao = dsapresentacao;
           this.ijtbapresxslideses = ijtbapresxslideses;
    }


    /**
     * Gets the cdapresentacao value for this Ijtbapresentacao.
     * 
     * @return cdapresentacao
     */
    public java.lang.String getCdapresentacao() {
        return cdapresentacao;
    }


    /**
     * Sets the cdapresentacao value for this Ijtbapresentacao.
     * 
     * @param cdapresentacao
     */
    public void setCdapresentacao(java.lang.String cdapresentacao) {
        this.cdapresentacao = cdapresentacao;
    }


    /**
     * Gets the dsapresentacao value for this Ijtbapresentacao.
     * 
     * @return dsapresentacao
     */
    public java.lang.String getDsapresentacao() {
        return dsapresentacao;
    }


    /**
     * Sets the dsapresentacao value for this Ijtbapresentacao.
     * 
     * @param dsapresentacao
     */
    public void setDsapresentacao(java.lang.String dsapresentacao) {
        this.dsapresentacao = dsapresentacao;
    }


    /**
     * Gets the ijtbapresxslideses value for this Ijtbapresentacao.
     * 
     * @return ijtbapresxslideses
     */
    public idw.idwws.Ijtbapresxslides[] getIjtbapresxslideses() {
        return ijtbapresxslideses;
    }


    /**
     * Sets the ijtbapresxslideses value for this Ijtbapresentacao.
     * 
     * @param ijtbapresxslideses
     */
    public void setIjtbapresxslideses(idw.idwws.Ijtbapresxslides[] ijtbapresxslideses) {
        this.ijtbapresxslideses = ijtbapresxslideses;
    }

    public idw.idwws.Ijtbapresxslides getIjtbapresxslideses(int i) {
        return this.ijtbapresxslideses[i];
    }

    public void setIjtbapresxslideses(int i, idw.idwws.Ijtbapresxslides _value) {
        this.ijtbapresxslideses[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbapresentacao)) return false;
        Ijtbapresentacao other = (Ijtbapresentacao) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdapresentacao==null && other.getCdapresentacao()==null) || 
             (this.cdapresentacao!=null &&
              this.cdapresentacao.equals(other.getCdapresentacao()))) &&
            ((this.dsapresentacao==null && other.getDsapresentacao()==null) || 
             (this.dsapresentacao!=null &&
              this.dsapresentacao.equals(other.getDsapresentacao()))) &&
            ((this.ijtbapresxslideses==null && other.getIjtbapresxslideses()==null) || 
             (this.ijtbapresxslideses!=null &&
              java.util.Arrays.equals(this.ijtbapresxslideses, other.getIjtbapresxslideses())));
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
        if (getCdapresentacao() != null) {
            _hashCode += getCdapresentacao().hashCode();
        }
        if (getDsapresentacao() != null) {
            _hashCode += getDsapresentacao().hashCode();
        }
        if (getIjtbapresxslideses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbapresxslideses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbapresxslideses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbapresentacao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbapresentacao"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdapresentacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdapresentacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsapresentacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsapresentacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbapresxslideses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbapresxslideses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbapresxslides"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
