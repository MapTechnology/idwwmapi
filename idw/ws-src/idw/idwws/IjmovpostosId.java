/**
 * IjmovpostosId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjmovpostosId  implements java.io.Serializable {
    private java.lang.String cdgrupoestproc;

    private java.lang.String cdinjetora;

    private java.lang.String cdoperacao;

    private java.lang.String cdoperador;

    private java.lang.String cdposto;

    private java.util.Calendar dthrfimoperacao;

    private java.util.Calendar dthriniciooperacao;

    private java.math.BigDecimal execestagio;

    private java.lang.String nrop;

    private java.lang.Double qtdmov;

    public IjmovpostosId() {
    }

    public IjmovpostosId(
           java.lang.String cdgrupoestproc,
           java.lang.String cdinjetora,
           java.lang.String cdoperacao,
           java.lang.String cdoperador,
           java.lang.String cdposto,
           java.util.Calendar dthrfimoperacao,
           java.util.Calendar dthriniciooperacao,
           java.math.BigDecimal execestagio,
           java.lang.String nrop,
           java.lang.Double qtdmov) {
           this.cdgrupoestproc = cdgrupoestproc;
           this.cdinjetora = cdinjetora;
           this.cdoperacao = cdoperacao;
           this.cdoperador = cdoperador;
           this.cdposto = cdposto;
           this.dthrfimoperacao = dthrfimoperacao;
           this.dthriniciooperacao = dthriniciooperacao;
           this.execestagio = execestagio;
           this.nrop = nrop;
           this.qtdmov = qtdmov;
    }


    /**
     * Gets the cdgrupoestproc value for this IjmovpostosId.
     * 
     * @return cdgrupoestproc
     */
    public java.lang.String getCdgrupoestproc() {
        return cdgrupoestproc;
    }


    /**
     * Sets the cdgrupoestproc value for this IjmovpostosId.
     * 
     * @param cdgrupoestproc
     */
    public void setCdgrupoestproc(java.lang.String cdgrupoestproc) {
        this.cdgrupoestproc = cdgrupoestproc;
    }


    /**
     * Gets the cdinjetora value for this IjmovpostosId.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this IjmovpostosId.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the cdoperacao value for this IjmovpostosId.
     * 
     * @return cdoperacao
     */
    public java.lang.String getCdoperacao() {
        return cdoperacao;
    }


    /**
     * Sets the cdoperacao value for this IjmovpostosId.
     * 
     * @param cdoperacao
     */
    public void setCdoperacao(java.lang.String cdoperacao) {
        this.cdoperacao = cdoperacao;
    }


    /**
     * Gets the cdoperador value for this IjmovpostosId.
     * 
     * @return cdoperador
     */
    public java.lang.String getCdoperador() {
        return cdoperador;
    }


    /**
     * Sets the cdoperador value for this IjmovpostosId.
     * 
     * @param cdoperador
     */
    public void setCdoperador(java.lang.String cdoperador) {
        this.cdoperador = cdoperador;
    }


    /**
     * Gets the cdposto value for this IjmovpostosId.
     * 
     * @return cdposto
     */
    public java.lang.String getCdposto() {
        return cdposto;
    }


    /**
     * Sets the cdposto value for this IjmovpostosId.
     * 
     * @param cdposto
     */
    public void setCdposto(java.lang.String cdposto) {
        this.cdposto = cdposto;
    }


    /**
     * Gets the dthrfimoperacao value for this IjmovpostosId.
     * 
     * @return dthrfimoperacao
     */
    public java.util.Calendar getDthrfimoperacao() {
        return dthrfimoperacao;
    }


    /**
     * Sets the dthrfimoperacao value for this IjmovpostosId.
     * 
     * @param dthrfimoperacao
     */
    public void setDthrfimoperacao(java.util.Calendar dthrfimoperacao) {
        this.dthrfimoperacao = dthrfimoperacao;
    }


    /**
     * Gets the dthriniciooperacao value for this IjmovpostosId.
     * 
     * @return dthriniciooperacao
     */
    public java.util.Calendar getDthriniciooperacao() {
        return dthriniciooperacao;
    }


    /**
     * Sets the dthriniciooperacao value for this IjmovpostosId.
     * 
     * @param dthriniciooperacao
     */
    public void setDthriniciooperacao(java.util.Calendar dthriniciooperacao) {
        this.dthriniciooperacao = dthriniciooperacao;
    }


    /**
     * Gets the execestagio value for this IjmovpostosId.
     * 
     * @return execestagio
     */
    public java.math.BigDecimal getExecestagio() {
        return execestagio;
    }


    /**
     * Sets the execestagio value for this IjmovpostosId.
     * 
     * @param execestagio
     */
    public void setExecestagio(java.math.BigDecimal execestagio) {
        this.execestagio = execestagio;
    }


    /**
     * Gets the nrop value for this IjmovpostosId.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this IjmovpostosId.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }


    /**
     * Gets the qtdmov value for this IjmovpostosId.
     * 
     * @return qtdmov
     */
    public java.lang.Double getQtdmov() {
        return qtdmov;
    }


    /**
     * Sets the qtdmov value for this IjmovpostosId.
     * 
     * @param qtdmov
     */
    public void setQtdmov(java.lang.Double qtdmov) {
        this.qtdmov = qtdmov;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjmovpostosId)) return false;
        IjmovpostosId other = (IjmovpostosId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgrupoestproc==null && other.getCdgrupoestproc()==null) || 
             (this.cdgrupoestproc!=null &&
              this.cdgrupoestproc.equals(other.getCdgrupoestproc()))) &&
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.cdoperacao==null && other.getCdoperacao()==null) || 
             (this.cdoperacao!=null &&
              this.cdoperacao.equals(other.getCdoperacao()))) &&
            ((this.cdoperador==null && other.getCdoperador()==null) || 
             (this.cdoperador!=null &&
              this.cdoperador.equals(other.getCdoperador()))) &&
            ((this.cdposto==null && other.getCdposto()==null) || 
             (this.cdposto!=null &&
              this.cdposto.equals(other.getCdposto()))) &&
            ((this.dthrfimoperacao==null && other.getDthrfimoperacao()==null) || 
             (this.dthrfimoperacao!=null &&
              this.dthrfimoperacao.equals(other.getDthrfimoperacao()))) &&
            ((this.dthriniciooperacao==null && other.getDthriniciooperacao()==null) || 
             (this.dthriniciooperacao!=null &&
              this.dthriniciooperacao.equals(other.getDthriniciooperacao()))) &&
            ((this.execestagio==null && other.getExecestagio()==null) || 
             (this.execestagio!=null &&
              this.execestagio.equals(other.getExecestagio()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop()))) &&
            ((this.qtdmov==null && other.getQtdmov()==null) || 
             (this.qtdmov!=null &&
              this.qtdmov.equals(other.getQtdmov())));
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
        if (getCdgrupoestproc() != null) {
            _hashCode += getCdgrupoestproc().hashCode();
        }
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getCdoperacao() != null) {
            _hashCode += getCdoperacao().hashCode();
        }
        if (getCdoperador() != null) {
            _hashCode += getCdoperador().hashCode();
        }
        if (getCdposto() != null) {
            _hashCode += getCdposto().hashCode();
        }
        if (getDthrfimoperacao() != null) {
            _hashCode += getDthrfimoperacao().hashCode();
        }
        if (getDthriniciooperacao() != null) {
            _hashCode += getDthriniciooperacao().hashCode();
        }
        if (getExecestagio() != null) {
            _hashCode += getExecestagio().hashCode();
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        if (getQtdmov() != null) {
            _hashCode += getQtdmov().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjmovpostosId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmovpostosId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgrupoestproc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgrupoestproc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdoperacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdoperacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdoperador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdoperador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdposto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdposto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfimoperacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfimoperacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthriniciooperacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthriniciooperacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("execestagio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "execestagio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdmov");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdmov"));
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
