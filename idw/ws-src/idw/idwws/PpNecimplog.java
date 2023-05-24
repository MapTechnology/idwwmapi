/**
 * PpNecimplog.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpNecimplog  extends idw.idwws.PpNecimplogTemplate  implements java.io.Serializable {
    private java.lang.Integer anoReferencia;

    private java.util.Calendar dthrFimportacao;

    private java.util.Calendar dthrIimportacao;

    private java.lang.Long idNecimplog;

    private java.lang.Integer mesReferencia;

    private idw.idwws.OmUsr omUsr;

    private idw.idwws.PpNecimp ppNecimp;

    private idw.idwws.PpNecimpurllog[] ppNecimpurllogs;

    public PpNecimplog() {
    }

    public PpNecimplog(
           java.lang.Integer anoReferencia,
           java.util.Calendar dthrFimportacao,
           java.util.Calendar dthrIimportacao,
           java.lang.Long idNecimplog,
           java.lang.Integer mesReferencia,
           idw.idwws.OmUsr omUsr,
           idw.idwws.PpNecimp ppNecimp,
           idw.idwws.PpNecimpurllog[] ppNecimpurllogs) {
        this.anoReferencia = anoReferencia;
        this.dthrFimportacao = dthrFimportacao;
        this.dthrIimportacao = dthrIimportacao;
        this.idNecimplog = idNecimplog;
        this.mesReferencia = mesReferencia;
        this.omUsr = omUsr;
        this.ppNecimp = ppNecimp;
        this.ppNecimpurllogs = ppNecimpurllogs;
    }


    /**
     * Gets the anoReferencia value for this PpNecimplog.
     * 
     * @return anoReferencia
     */
    public java.lang.Integer getAnoReferencia() {
        return anoReferencia;
    }


    /**
     * Sets the anoReferencia value for this PpNecimplog.
     * 
     * @param anoReferencia
     */
    public void setAnoReferencia(java.lang.Integer anoReferencia) {
        this.anoReferencia = anoReferencia;
    }


    /**
     * Gets the dthrFimportacao value for this PpNecimplog.
     * 
     * @return dthrFimportacao
     */
    public java.util.Calendar getDthrFimportacao() {
        return dthrFimportacao;
    }


    /**
     * Sets the dthrFimportacao value for this PpNecimplog.
     * 
     * @param dthrFimportacao
     */
    public void setDthrFimportacao(java.util.Calendar dthrFimportacao) {
        this.dthrFimportacao = dthrFimportacao;
    }


    /**
     * Gets the dthrIimportacao value for this PpNecimplog.
     * 
     * @return dthrIimportacao
     */
    public java.util.Calendar getDthrIimportacao() {
        return dthrIimportacao;
    }


    /**
     * Sets the dthrIimportacao value for this PpNecimplog.
     * 
     * @param dthrIimportacao
     */
    public void setDthrIimportacao(java.util.Calendar dthrIimportacao) {
        this.dthrIimportacao = dthrIimportacao;
    }


    /**
     * Gets the idNecimplog value for this PpNecimplog.
     * 
     * @return idNecimplog
     */
    public java.lang.Long getIdNecimplog() {
        return idNecimplog;
    }


    /**
     * Sets the idNecimplog value for this PpNecimplog.
     * 
     * @param idNecimplog
     */
    public void setIdNecimplog(java.lang.Long idNecimplog) {
        this.idNecimplog = idNecimplog;
    }


    /**
     * Gets the mesReferencia value for this PpNecimplog.
     * 
     * @return mesReferencia
     */
    public java.lang.Integer getMesReferencia() {
        return mesReferencia;
    }


    /**
     * Sets the mesReferencia value for this PpNecimplog.
     * 
     * @param mesReferencia
     */
    public void setMesReferencia(java.lang.Integer mesReferencia) {
        this.mesReferencia = mesReferencia;
    }


    /**
     * Gets the omUsr value for this PpNecimplog.
     * 
     * @return omUsr
     */
    public idw.idwws.OmUsr getOmUsr() {
        return omUsr;
    }


    /**
     * Sets the omUsr value for this PpNecimplog.
     * 
     * @param omUsr
     */
    public void setOmUsr(idw.idwws.OmUsr omUsr) {
        this.omUsr = omUsr;
    }


    /**
     * Gets the ppNecimp value for this PpNecimplog.
     * 
     * @return ppNecimp
     */
    public idw.idwws.PpNecimp getPpNecimp() {
        return ppNecimp;
    }


    /**
     * Sets the ppNecimp value for this PpNecimplog.
     * 
     * @param ppNecimp
     */
    public void setPpNecimp(idw.idwws.PpNecimp ppNecimp) {
        this.ppNecimp = ppNecimp;
    }


    /**
     * Gets the ppNecimpurllogs value for this PpNecimplog.
     * 
     * @return ppNecimpurllogs
     */
    public idw.idwws.PpNecimpurllog[] getPpNecimpurllogs() {
        return ppNecimpurllogs;
    }


    /**
     * Sets the ppNecimpurllogs value for this PpNecimplog.
     * 
     * @param ppNecimpurllogs
     */
    public void setPpNecimpurllogs(idw.idwws.PpNecimpurllog[] ppNecimpurllogs) {
        this.ppNecimpurllogs = ppNecimpurllogs;
    }

    public idw.idwws.PpNecimpurllog getPpNecimpurllogs(int i) {
        return this.ppNecimpurllogs[i];
    }

    public void setPpNecimpurllogs(int i, idw.idwws.PpNecimpurllog _value) {
        this.ppNecimpurllogs[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpNecimplog)) return false;
        PpNecimplog other = (PpNecimplog) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.anoReferencia==null && other.getAnoReferencia()==null) || 
             (this.anoReferencia!=null &&
              this.anoReferencia.equals(other.getAnoReferencia()))) &&
            ((this.dthrFimportacao==null && other.getDthrFimportacao()==null) || 
             (this.dthrFimportacao!=null &&
              this.dthrFimportacao.equals(other.getDthrFimportacao()))) &&
            ((this.dthrIimportacao==null && other.getDthrIimportacao()==null) || 
             (this.dthrIimportacao!=null &&
              this.dthrIimportacao.equals(other.getDthrIimportacao()))) &&
            ((this.idNecimplog==null && other.getIdNecimplog()==null) || 
             (this.idNecimplog!=null &&
              this.idNecimplog.equals(other.getIdNecimplog()))) &&
            ((this.mesReferencia==null && other.getMesReferencia()==null) || 
             (this.mesReferencia!=null &&
              this.mesReferencia.equals(other.getMesReferencia()))) &&
            ((this.omUsr==null && other.getOmUsr()==null) || 
             (this.omUsr!=null &&
              this.omUsr.equals(other.getOmUsr()))) &&
            ((this.ppNecimp==null && other.getPpNecimp()==null) || 
             (this.ppNecimp!=null &&
              this.ppNecimp.equals(other.getPpNecimp()))) &&
            ((this.ppNecimpurllogs==null && other.getPpNecimpurllogs()==null) || 
             (this.ppNecimpurllogs!=null &&
              java.util.Arrays.equals(this.ppNecimpurllogs, other.getPpNecimpurllogs())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getAnoReferencia() != null) {
            _hashCode += getAnoReferencia().hashCode();
        }
        if (getDthrFimportacao() != null) {
            _hashCode += getDthrFimportacao().hashCode();
        }
        if (getDthrIimportacao() != null) {
            _hashCode += getDthrIimportacao().hashCode();
        }
        if (getIdNecimplog() != null) {
            _hashCode += getIdNecimplog().hashCode();
        }
        if (getMesReferencia() != null) {
            _hashCode += getMesReferencia().hashCode();
        }
        if (getOmUsr() != null) {
            _hashCode += getOmUsr().hashCode();
        }
        if (getPpNecimp() != null) {
            _hashCode += getPpNecimp().hashCode();
        }
        if (getPpNecimpurllogs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpNecimpurllogs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpNecimpurllogs(), i);
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
        new org.apache.axis.description.TypeDesc(PpNecimplog.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecimplog"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anoReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "anoReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFimportacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFimportacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIimportacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIimportacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idNecimplog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idNecimplog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mesReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mesReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppNecimp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppNecimp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecimp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppNecimpurllogs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppNecimpurllogs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecimpurllog"));
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
