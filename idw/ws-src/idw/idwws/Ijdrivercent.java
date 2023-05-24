/**
 * Ijdrivercent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijdrivercent  implements java.io.Serializable {
    private double iddrivercentral;

    private java.lang.String idportacom;

    private idw.idwws.Ijdrivercentparam[] ijdrivercentparams;

    private idw.idwws.Ijtbcentinsp ijtbcentinsp;

    private idw.idwws.Ijtbdrivers ijtbdrivers;

    private java.math.BigDecimal stativo;

    private java.math.BigDecimal stexclusao;

    public Ijdrivercent() {
    }

    public Ijdrivercent(
           double iddrivercentral,
           java.lang.String idportacom,
           idw.idwws.Ijdrivercentparam[] ijdrivercentparams,
           idw.idwws.Ijtbcentinsp ijtbcentinsp,
           idw.idwws.Ijtbdrivers ijtbdrivers,
           java.math.BigDecimal stativo,
           java.math.BigDecimal stexclusao) {
           this.iddrivercentral = iddrivercentral;
           this.idportacom = idportacom;
           this.ijdrivercentparams = ijdrivercentparams;
           this.ijtbcentinsp = ijtbcentinsp;
           this.ijtbdrivers = ijtbdrivers;
           this.stativo = stativo;
           this.stexclusao = stexclusao;
    }


    /**
     * Gets the iddrivercentral value for this Ijdrivercent.
     * 
     * @return iddrivercentral
     */
    public double getIddrivercentral() {
        return iddrivercentral;
    }


    /**
     * Sets the iddrivercentral value for this Ijdrivercent.
     * 
     * @param iddrivercentral
     */
    public void setIddrivercentral(double iddrivercentral) {
        this.iddrivercentral = iddrivercentral;
    }


    /**
     * Gets the idportacom value for this Ijdrivercent.
     * 
     * @return idportacom
     */
    public java.lang.String getIdportacom() {
        return idportacom;
    }


    /**
     * Sets the idportacom value for this Ijdrivercent.
     * 
     * @param idportacom
     */
    public void setIdportacom(java.lang.String idportacom) {
        this.idportacom = idportacom;
    }


    /**
     * Gets the ijdrivercentparams value for this Ijdrivercent.
     * 
     * @return ijdrivercentparams
     */
    public idw.idwws.Ijdrivercentparam[] getIjdrivercentparams() {
        return ijdrivercentparams;
    }


    /**
     * Sets the ijdrivercentparams value for this Ijdrivercent.
     * 
     * @param ijdrivercentparams
     */
    public void setIjdrivercentparams(idw.idwws.Ijdrivercentparam[] ijdrivercentparams) {
        this.ijdrivercentparams = ijdrivercentparams;
    }

    public idw.idwws.Ijdrivercentparam getIjdrivercentparams(int i) {
        return this.ijdrivercentparams[i];
    }

    public void setIjdrivercentparams(int i, idw.idwws.Ijdrivercentparam _value) {
        this.ijdrivercentparams[i] = _value;
    }


    /**
     * Gets the ijtbcentinsp value for this Ijdrivercent.
     * 
     * @return ijtbcentinsp
     */
    public idw.idwws.Ijtbcentinsp getIjtbcentinsp() {
        return ijtbcentinsp;
    }


    /**
     * Sets the ijtbcentinsp value for this Ijdrivercent.
     * 
     * @param ijtbcentinsp
     */
    public void setIjtbcentinsp(idw.idwws.Ijtbcentinsp ijtbcentinsp) {
        this.ijtbcentinsp = ijtbcentinsp;
    }


    /**
     * Gets the ijtbdrivers value for this Ijdrivercent.
     * 
     * @return ijtbdrivers
     */
    public idw.idwws.Ijtbdrivers getIjtbdrivers() {
        return ijtbdrivers;
    }


    /**
     * Sets the ijtbdrivers value for this Ijdrivercent.
     * 
     * @param ijtbdrivers
     */
    public void setIjtbdrivers(idw.idwws.Ijtbdrivers ijtbdrivers) {
        this.ijtbdrivers = ijtbdrivers;
    }


    /**
     * Gets the stativo value for this Ijdrivercent.
     * 
     * @return stativo
     */
    public java.math.BigDecimal getStativo() {
        return stativo;
    }


    /**
     * Sets the stativo value for this Ijdrivercent.
     * 
     * @param stativo
     */
    public void setStativo(java.math.BigDecimal stativo) {
        this.stativo = stativo;
    }


    /**
     * Gets the stexclusao value for this Ijdrivercent.
     * 
     * @return stexclusao
     */
    public java.math.BigDecimal getStexclusao() {
        return stexclusao;
    }


    /**
     * Sets the stexclusao value for this Ijdrivercent.
     * 
     * @param stexclusao
     */
    public void setStexclusao(java.math.BigDecimal stexclusao) {
        this.stexclusao = stexclusao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijdrivercent)) return false;
        Ijdrivercent other = (Ijdrivercent) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.iddrivercentral == other.getIddrivercentral() &&
            ((this.idportacom==null && other.getIdportacom()==null) || 
             (this.idportacom!=null &&
              this.idportacom.equals(other.getIdportacom()))) &&
            ((this.ijdrivercentparams==null && other.getIjdrivercentparams()==null) || 
             (this.ijdrivercentparams!=null &&
              java.util.Arrays.equals(this.ijdrivercentparams, other.getIjdrivercentparams()))) &&
            ((this.ijtbcentinsp==null && other.getIjtbcentinsp()==null) || 
             (this.ijtbcentinsp!=null &&
              this.ijtbcentinsp.equals(other.getIjtbcentinsp()))) &&
            ((this.ijtbdrivers==null && other.getIjtbdrivers()==null) || 
             (this.ijtbdrivers!=null &&
              this.ijtbdrivers.equals(other.getIjtbdrivers()))) &&
            ((this.stativo==null && other.getStativo()==null) || 
             (this.stativo!=null &&
              this.stativo.equals(other.getStativo()))) &&
            ((this.stexclusao==null && other.getStexclusao()==null) || 
             (this.stexclusao!=null &&
              this.stexclusao.equals(other.getStexclusao())));
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
        _hashCode += new Double(getIddrivercentral()).hashCode();
        if (getIdportacom() != null) {
            _hashCode += getIdportacom().hashCode();
        }
        if (getIjdrivercentparams() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjdrivercentparams());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjdrivercentparams(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbcentinsp() != null) {
            _hashCode += getIjtbcentinsp().hashCode();
        }
        if (getIjtbdrivers() != null) {
            _hashCode += getIjtbdrivers().hashCode();
        }
        if (getStativo() != null) {
            _hashCode += getStativo().hashCode();
        }
        if (getStexclusao() != null) {
            _hashCode += getStexclusao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijdrivercent.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdrivercent"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iddrivercentral");
        elemField.setXmlName(new javax.xml.namespace.QName("", "iddrivercentral"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idportacom");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idportacom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijdrivercentparams");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijdrivercentparams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdrivercentparam"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbcentinsp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbcentinsp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcentinsp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbdrivers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbdrivers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbdrivers"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stexclusao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stexclusao"));
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
