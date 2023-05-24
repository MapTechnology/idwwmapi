/**
 * IjmanutrecbloqId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjmanutrecbloqId  implements java.io.Serializable {
    private java.util.Calendar dtfimbloq;

    private java.util.Calendar dtinibloq;

    private java.lang.String idrecurso;

    private java.lang.String nros;

    private java.lang.String tprecurso;

    public IjmanutrecbloqId() {
    }

    public IjmanutrecbloqId(
           java.util.Calendar dtfimbloq,
           java.util.Calendar dtinibloq,
           java.lang.String idrecurso,
           java.lang.String nros,
           java.lang.String tprecurso) {
           this.dtfimbloq = dtfimbloq;
           this.dtinibloq = dtinibloq;
           this.idrecurso = idrecurso;
           this.nros = nros;
           this.tprecurso = tprecurso;
    }


    /**
     * Gets the dtfimbloq value for this IjmanutrecbloqId.
     * 
     * @return dtfimbloq
     */
    public java.util.Calendar getDtfimbloq() {
        return dtfimbloq;
    }


    /**
     * Sets the dtfimbloq value for this IjmanutrecbloqId.
     * 
     * @param dtfimbloq
     */
    public void setDtfimbloq(java.util.Calendar dtfimbloq) {
        this.dtfimbloq = dtfimbloq;
    }


    /**
     * Gets the dtinibloq value for this IjmanutrecbloqId.
     * 
     * @return dtinibloq
     */
    public java.util.Calendar getDtinibloq() {
        return dtinibloq;
    }


    /**
     * Sets the dtinibloq value for this IjmanutrecbloqId.
     * 
     * @param dtinibloq
     */
    public void setDtinibloq(java.util.Calendar dtinibloq) {
        this.dtinibloq = dtinibloq;
    }


    /**
     * Gets the idrecurso value for this IjmanutrecbloqId.
     * 
     * @return idrecurso
     */
    public java.lang.String getIdrecurso() {
        return idrecurso;
    }


    /**
     * Sets the idrecurso value for this IjmanutrecbloqId.
     * 
     * @param idrecurso
     */
    public void setIdrecurso(java.lang.String idrecurso) {
        this.idrecurso = idrecurso;
    }


    /**
     * Gets the nros value for this IjmanutrecbloqId.
     * 
     * @return nros
     */
    public java.lang.String getNros() {
        return nros;
    }


    /**
     * Sets the nros value for this IjmanutrecbloqId.
     * 
     * @param nros
     */
    public void setNros(java.lang.String nros) {
        this.nros = nros;
    }


    /**
     * Gets the tprecurso value for this IjmanutrecbloqId.
     * 
     * @return tprecurso
     */
    public java.lang.String getTprecurso() {
        return tprecurso;
    }


    /**
     * Sets the tprecurso value for this IjmanutrecbloqId.
     * 
     * @param tprecurso
     */
    public void setTprecurso(java.lang.String tprecurso) {
        this.tprecurso = tprecurso;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjmanutrecbloqId)) return false;
        IjmanutrecbloqId other = (IjmanutrecbloqId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dtfimbloq==null && other.getDtfimbloq()==null) || 
             (this.dtfimbloq!=null &&
              this.dtfimbloq.equals(other.getDtfimbloq()))) &&
            ((this.dtinibloq==null && other.getDtinibloq()==null) || 
             (this.dtinibloq!=null &&
              this.dtinibloq.equals(other.getDtinibloq()))) &&
            ((this.idrecurso==null && other.getIdrecurso()==null) || 
             (this.idrecurso!=null &&
              this.idrecurso.equals(other.getIdrecurso()))) &&
            ((this.nros==null && other.getNros()==null) || 
             (this.nros!=null &&
              this.nros.equals(other.getNros()))) &&
            ((this.tprecurso==null && other.getTprecurso()==null) || 
             (this.tprecurso!=null &&
              this.tprecurso.equals(other.getTprecurso())));
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
        if (getDtfimbloq() != null) {
            _hashCode += getDtfimbloq().hashCode();
        }
        if (getDtinibloq() != null) {
            _hashCode += getDtinibloq().hashCode();
        }
        if (getIdrecurso() != null) {
            _hashCode += getIdrecurso().hashCode();
        }
        if (getNros() != null) {
            _hashCode += getNros().hashCode();
        }
        if (getTprecurso() != null) {
            _hashCode += getTprecurso().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjmanutrecbloqId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutrecbloqId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtfimbloq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtfimbloq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtinibloq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtinibloq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idrecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idrecurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tprecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tprecurso"));
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
