/**
 * IjlogvidautilId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjlogvidautilId  implements java.io.Serializable {
    private java.lang.String cdmolde;

    private java.lang.String cdusualterou;

    private java.util.Calendar dthralteracao;

    private java.lang.String justaltvidautil;

    private double percalevidautil;

    private double qttotcicexec;

    private double vidautil;

    public IjlogvidautilId() {
    }

    public IjlogvidautilId(
           java.lang.String cdmolde,
           java.lang.String cdusualterou,
           java.util.Calendar dthralteracao,
           java.lang.String justaltvidautil,
           double percalevidautil,
           double qttotcicexec,
           double vidautil) {
           this.cdmolde = cdmolde;
           this.cdusualterou = cdusualterou;
           this.dthralteracao = dthralteracao;
           this.justaltvidautil = justaltvidautil;
           this.percalevidautil = percalevidautil;
           this.qttotcicexec = qttotcicexec;
           this.vidautil = vidautil;
    }


    /**
     * Gets the cdmolde value for this IjlogvidautilId.
     * 
     * @return cdmolde
     */
    public java.lang.String getCdmolde() {
        return cdmolde;
    }


    /**
     * Sets the cdmolde value for this IjlogvidautilId.
     * 
     * @param cdmolde
     */
    public void setCdmolde(java.lang.String cdmolde) {
        this.cdmolde = cdmolde;
    }


    /**
     * Gets the cdusualterou value for this IjlogvidautilId.
     * 
     * @return cdusualterou
     */
    public java.lang.String getCdusualterou() {
        return cdusualterou;
    }


    /**
     * Sets the cdusualterou value for this IjlogvidautilId.
     * 
     * @param cdusualterou
     */
    public void setCdusualterou(java.lang.String cdusualterou) {
        this.cdusualterou = cdusualterou;
    }


    /**
     * Gets the dthralteracao value for this IjlogvidautilId.
     * 
     * @return dthralteracao
     */
    public java.util.Calendar getDthralteracao() {
        return dthralteracao;
    }


    /**
     * Sets the dthralteracao value for this IjlogvidautilId.
     * 
     * @param dthralteracao
     */
    public void setDthralteracao(java.util.Calendar dthralteracao) {
        this.dthralteracao = dthralteracao;
    }


    /**
     * Gets the justaltvidautil value for this IjlogvidautilId.
     * 
     * @return justaltvidautil
     */
    public java.lang.String getJustaltvidautil() {
        return justaltvidautil;
    }


    /**
     * Sets the justaltvidautil value for this IjlogvidautilId.
     * 
     * @param justaltvidautil
     */
    public void setJustaltvidautil(java.lang.String justaltvidautil) {
        this.justaltvidautil = justaltvidautil;
    }


    /**
     * Gets the percalevidautil value for this IjlogvidautilId.
     * 
     * @return percalevidautil
     */
    public double getPercalevidautil() {
        return percalevidautil;
    }


    /**
     * Sets the percalevidautil value for this IjlogvidautilId.
     * 
     * @param percalevidautil
     */
    public void setPercalevidautil(double percalevidautil) {
        this.percalevidautil = percalevidautil;
    }


    /**
     * Gets the qttotcicexec value for this IjlogvidautilId.
     * 
     * @return qttotcicexec
     */
    public double getQttotcicexec() {
        return qttotcicexec;
    }


    /**
     * Sets the qttotcicexec value for this IjlogvidautilId.
     * 
     * @param qttotcicexec
     */
    public void setQttotcicexec(double qttotcicexec) {
        this.qttotcicexec = qttotcicexec;
    }


    /**
     * Gets the vidautil value for this IjlogvidautilId.
     * 
     * @return vidautil
     */
    public double getVidautil() {
        return vidautil;
    }


    /**
     * Sets the vidautil value for this IjlogvidautilId.
     * 
     * @param vidautil
     */
    public void setVidautil(double vidautil) {
        this.vidautil = vidautil;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjlogvidautilId)) return false;
        IjlogvidautilId other = (IjlogvidautilId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdmolde==null && other.getCdmolde()==null) || 
             (this.cdmolde!=null &&
              this.cdmolde.equals(other.getCdmolde()))) &&
            ((this.cdusualterou==null && other.getCdusualterou()==null) || 
             (this.cdusualterou!=null &&
              this.cdusualterou.equals(other.getCdusualterou()))) &&
            ((this.dthralteracao==null && other.getDthralteracao()==null) || 
             (this.dthralteracao!=null &&
              this.dthralteracao.equals(other.getDthralteracao()))) &&
            ((this.justaltvidautil==null && other.getJustaltvidautil()==null) || 
             (this.justaltvidautil!=null &&
              this.justaltvidautil.equals(other.getJustaltvidautil()))) &&
            this.percalevidautil == other.getPercalevidautil() &&
            this.qttotcicexec == other.getQttotcicexec() &&
            this.vidautil == other.getVidautil();
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
        if (getCdmolde() != null) {
            _hashCode += getCdmolde().hashCode();
        }
        if (getCdusualterou() != null) {
            _hashCode += getCdusualterou().hashCode();
        }
        if (getDthralteracao() != null) {
            _hashCode += getDthralteracao().hashCode();
        }
        if (getJustaltvidautil() != null) {
            _hashCode += getJustaltvidautil().hashCode();
        }
        _hashCode += new Double(getPercalevidautil()).hashCode();
        _hashCode += new Double(getQttotcicexec()).hashCode();
        _hashCode += new Double(getVidautil()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjlogvidautilId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlogvidautilId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdusualterou");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdusualterou"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthralteracao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthralteracao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("justaltvidautil");
        elemField.setXmlName(new javax.xml.namespace.QName("", "justaltvidautil"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("percalevidautil");
        elemField.setXmlName(new javax.xml.namespace.QName("", "percalevidautil"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qttotcicexec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qttotcicexec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vidautil");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vidautil"));
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
