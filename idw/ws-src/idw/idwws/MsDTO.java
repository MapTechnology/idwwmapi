/**
 * MsDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MsDTO  implements java.io.Serializable {
    private java.lang.String cd_ms;

    private java.lang.String ds_ms;

    private java.util.Calendar dthr_heart_beat;

    private java.util.Calendar dthr_revisao;

    private java.util.Calendar dthr_stativo;

    private idw.idwws.IcUpDTO[] icsColetados;

    private java.lang.Long idMs;

    private idw.idwws.IhmDTO[] ihmsRegistrados;

    private java.lang.String loginUsuario;

    private java.lang.Integer revisao;

    private java.lang.Integer st_ativo;

    private java.lang.Integer tpCalculoAndon;

    private java.lang.String urlConexao;

    public MsDTO() {
    }

    public MsDTO(
           java.lang.String cd_ms,
           java.lang.String ds_ms,
           java.util.Calendar dthr_heart_beat,
           java.util.Calendar dthr_revisao,
           java.util.Calendar dthr_stativo,
           idw.idwws.IcUpDTO[] icsColetados,
           java.lang.Long idMs,
           idw.idwws.IhmDTO[] ihmsRegistrados,
           java.lang.String loginUsuario,
           java.lang.Integer revisao,
           java.lang.Integer st_ativo,
           java.lang.Integer tpCalculoAndon,
           java.lang.String urlConexao) {
           this.cd_ms = cd_ms;
           this.ds_ms = ds_ms;
           this.dthr_heart_beat = dthr_heart_beat;
           this.dthr_revisao = dthr_revisao;
           this.dthr_stativo = dthr_stativo;
           this.icsColetados = icsColetados;
           this.idMs = idMs;
           this.ihmsRegistrados = ihmsRegistrados;
           this.loginUsuario = loginUsuario;
           this.revisao = revisao;
           this.st_ativo = st_ativo;
           this.tpCalculoAndon = tpCalculoAndon;
           this.urlConexao = urlConexao;
    }


    /**
     * Gets the cd_ms value for this MsDTO.
     * 
     * @return cd_ms
     */
    public java.lang.String getCd_ms() {
        return cd_ms;
    }


    /**
     * Sets the cd_ms value for this MsDTO.
     * 
     * @param cd_ms
     */
    public void setCd_ms(java.lang.String cd_ms) {
        this.cd_ms = cd_ms;
    }


    /**
     * Gets the ds_ms value for this MsDTO.
     * 
     * @return ds_ms
     */
    public java.lang.String getDs_ms() {
        return ds_ms;
    }


    /**
     * Sets the ds_ms value for this MsDTO.
     * 
     * @param ds_ms
     */
    public void setDs_ms(java.lang.String ds_ms) {
        this.ds_ms = ds_ms;
    }


    /**
     * Gets the dthr_heart_beat value for this MsDTO.
     * 
     * @return dthr_heart_beat
     */
    public java.util.Calendar getDthr_heart_beat() {
        return dthr_heart_beat;
    }


    /**
     * Sets the dthr_heart_beat value for this MsDTO.
     * 
     * @param dthr_heart_beat
     */
    public void setDthr_heart_beat(java.util.Calendar dthr_heart_beat) {
        this.dthr_heart_beat = dthr_heart_beat;
    }


    /**
     * Gets the dthr_revisao value for this MsDTO.
     * 
     * @return dthr_revisao
     */
    public java.util.Calendar getDthr_revisao() {
        return dthr_revisao;
    }


    /**
     * Sets the dthr_revisao value for this MsDTO.
     * 
     * @param dthr_revisao
     */
    public void setDthr_revisao(java.util.Calendar dthr_revisao) {
        this.dthr_revisao = dthr_revisao;
    }


    /**
     * Gets the dthr_stativo value for this MsDTO.
     * 
     * @return dthr_stativo
     */
    public java.util.Calendar getDthr_stativo() {
        return dthr_stativo;
    }


    /**
     * Sets the dthr_stativo value for this MsDTO.
     * 
     * @param dthr_stativo
     */
    public void setDthr_stativo(java.util.Calendar dthr_stativo) {
        this.dthr_stativo = dthr_stativo;
    }


    /**
     * Gets the icsColetados value for this MsDTO.
     * 
     * @return icsColetados
     */
    public idw.idwws.IcUpDTO[] getIcsColetados() {
        return icsColetados;
    }


    /**
     * Sets the icsColetados value for this MsDTO.
     * 
     * @param icsColetados
     */
    public void setIcsColetados(idw.idwws.IcUpDTO[] icsColetados) {
        this.icsColetados = icsColetados;
    }

    public idw.idwws.IcUpDTO getIcsColetados(int i) {
        return this.icsColetados[i];
    }

    public void setIcsColetados(int i, idw.idwws.IcUpDTO _value) {
        this.icsColetados[i] = _value;
    }


    /**
     * Gets the idMs value for this MsDTO.
     * 
     * @return idMs
     */
    public java.lang.Long getIdMs() {
        return idMs;
    }


    /**
     * Sets the idMs value for this MsDTO.
     * 
     * @param idMs
     */
    public void setIdMs(java.lang.Long idMs) {
        this.idMs = idMs;
    }


    /**
     * Gets the ihmsRegistrados value for this MsDTO.
     * 
     * @return ihmsRegistrados
     */
    public idw.idwws.IhmDTO[] getIhmsRegistrados() {
        return ihmsRegistrados;
    }


    /**
     * Sets the ihmsRegistrados value for this MsDTO.
     * 
     * @param ihmsRegistrados
     */
    public void setIhmsRegistrados(idw.idwws.IhmDTO[] ihmsRegistrados) {
        this.ihmsRegistrados = ihmsRegistrados;
    }

    public idw.idwws.IhmDTO getIhmsRegistrados(int i) {
        return this.ihmsRegistrados[i];
    }

    public void setIhmsRegistrados(int i, idw.idwws.IhmDTO _value) {
        this.ihmsRegistrados[i] = _value;
    }


    /**
     * Gets the loginUsuario value for this MsDTO.
     * 
     * @return loginUsuario
     */
    public java.lang.String getLoginUsuario() {
        return loginUsuario;
    }


    /**
     * Sets the loginUsuario value for this MsDTO.
     * 
     * @param loginUsuario
     */
    public void setLoginUsuario(java.lang.String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }


    /**
     * Gets the revisao value for this MsDTO.
     * 
     * @return revisao
     */
    public java.lang.Integer getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this MsDTO.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Integer revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the st_ativo value for this MsDTO.
     * 
     * @return st_ativo
     */
    public java.lang.Integer getSt_ativo() {
        return st_ativo;
    }


    /**
     * Sets the st_ativo value for this MsDTO.
     * 
     * @param st_ativo
     */
    public void setSt_ativo(java.lang.Integer st_ativo) {
        this.st_ativo = st_ativo;
    }


    /**
     * Gets the tpCalculoAndon value for this MsDTO.
     * 
     * @return tpCalculoAndon
     */
    public java.lang.Integer getTpCalculoAndon() {
        return tpCalculoAndon;
    }


    /**
     * Sets the tpCalculoAndon value for this MsDTO.
     * 
     * @param tpCalculoAndon
     */
    public void setTpCalculoAndon(java.lang.Integer tpCalculoAndon) {
        this.tpCalculoAndon = tpCalculoAndon;
    }


    /**
     * Gets the urlConexao value for this MsDTO.
     * 
     * @return urlConexao
     */
    public java.lang.String getUrlConexao() {
        return urlConexao;
    }


    /**
     * Sets the urlConexao value for this MsDTO.
     * 
     * @param urlConexao
     */
    public void setUrlConexao(java.lang.String urlConexao) {
        this.urlConexao = urlConexao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MsDTO)) return false;
        MsDTO other = (MsDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cd_ms==null && other.getCd_ms()==null) || 
             (this.cd_ms!=null &&
              this.cd_ms.equals(other.getCd_ms()))) &&
            ((this.ds_ms==null && other.getDs_ms()==null) || 
             (this.ds_ms!=null &&
              this.ds_ms.equals(other.getDs_ms()))) &&
            ((this.dthr_heart_beat==null && other.getDthr_heart_beat()==null) || 
             (this.dthr_heart_beat!=null &&
              this.dthr_heart_beat.equals(other.getDthr_heart_beat()))) &&
            ((this.dthr_revisao==null && other.getDthr_revisao()==null) || 
             (this.dthr_revisao!=null &&
              this.dthr_revisao.equals(other.getDthr_revisao()))) &&
            ((this.dthr_stativo==null && other.getDthr_stativo()==null) || 
             (this.dthr_stativo!=null &&
              this.dthr_stativo.equals(other.getDthr_stativo()))) &&
            ((this.icsColetados==null && other.getIcsColetados()==null) || 
             (this.icsColetados!=null &&
              java.util.Arrays.equals(this.icsColetados, other.getIcsColetados()))) &&
            ((this.idMs==null && other.getIdMs()==null) || 
             (this.idMs!=null &&
              this.idMs.equals(other.getIdMs()))) &&
            ((this.ihmsRegistrados==null && other.getIhmsRegistrados()==null) || 
             (this.ihmsRegistrados!=null &&
              java.util.Arrays.equals(this.ihmsRegistrados, other.getIhmsRegistrados()))) &&
            ((this.loginUsuario==null && other.getLoginUsuario()==null) || 
             (this.loginUsuario!=null &&
              this.loginUsuario.equals(other.getLoginUsuario()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.st_ativo==null && other.getSt_ativo()==null) || 
             (this.st_ativo!=null &&
              this.st_ativo.equals(other.getSt_ativo()))) &&
            ((this.tpCalculoAndon==null && other.getTpCalculoAndon()==null) || 
             (this.tpCalculoAndon!=null &&
              this.tpCalculoAndon.equals(other.getTpCalculoAndon()))) &&
            ((this.urlConexao==null && other.getUrlConexao()==null) || 
             (this.urlConexao!=null &&
              this.urlConexao.equals(other.getUrlConexao())));
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
        if (getCd_ms() != null) {
            _hashCode += getCd_ms().hashCode();
        }
        if (getDs_ms() != null) {
            _hashCode += getDs_ms().hashCode();
        }
        if (getDthr_heart_beat() != null) {
            _hashCode += getDthr_heart_beat().hashCode();
        }
        if (getDthr_revisao() != null) {
            _hashCode += getDthr_revisao().hashCode();
        }
        if (getDthr_stativo() != null) {
            _hashCode += getDthr_stativo().hashCode();
        }
        if (getIcsColetados() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIcsColetados());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIcsColetados(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdMs() != null) {
            _hashCode += getIdMs().hashCode();
        }
        if (getIhmsRegistrados() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIhmsRegistrados());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIhmsRegistrados(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLoginUsuario() != null) {
            _hashCode += getLoginUsuario().hashCode();
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getSt_ativo() != null) {
            _hashCode += getSt_ativo().hashCode();
        }
        if (getTpCalculoAndon() != null) {
            _hashCode += getTpCalculoAndon().hashCode();
        }
        if (getUrlConexao() != null) {
            _hashCode += getUrlConexao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MsDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cd_ms");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cd_ms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ds_ms");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ds_ms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthr_heart_beat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthr_heart_beat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthr_revisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthr_revisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthr_stativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthr_stativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("icsColetados");
        elemField.setXmlName(new javax.xml.namespace.QName("", "icsColetados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "icUpDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idMs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idMs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ihmsRegistrados");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ihmsRegistrados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ihmDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "loginUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("st_ativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "st_ativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpCalculoAndon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpCalculoAndon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlConexao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlConexao"));
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
