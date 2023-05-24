/**
 * IcDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IcDTO  implements java.io.Serializable {
    private java.lang.String cd_ic;

    private java.lang.String ds_ic;

    private java.util.Calendar dthr_heartbeat;

    private java.util.Calendar dthr_revisao;

    private java.util.Calendar dthr_stativo;

    private java.lang.String firmware;

    private java.lang.Integer idIc;

    private idw.idwws.IdwLogger log;

    private idw.idwws.IdwLogger logAndon;

    private java.lang.String loginUsuario;

    private idw.idwws.PortaEthernetDTO portaEthernet;

    private idw.idwws.PortaSerial232DTO portaRS232;

    private idw.idwws.PortaSerial485DTO portaRS485;

    private idw.idwws.PortaUSBDTO portaUSB;

    private idw.idwws.IcUpDTO[] portas;

    private boolean removerThread;

    private java.lang.Integer revisao;

    private boolean stAndonConfiguravelAtivo;

    private java.lang.Integer st_ativo;

    private int tpCalculoAndon;

    private java.lang.Integer tp_ic;

    private idw.idwws.AndonDTO[] ultimosParametrosAndon;

    private java.lang.String url_conexao;

    public IcDTO() {
    }

    public IcDTO(
           java.lang.String cd_ic,
           java.lang.String ds_ic,
           java.util.Calendar dthr_heartbeat,
           java.util.Calendar dthr_revisao,
           java.util.Calendar dthr_stativo,
           java.lang.String firmware,
           java.lang.Integer idIc,
           idw.idwws.IdwLogger log,
           idw.idwws.IdwLogger logAndon,
           java.lang.String loginUsuario,
           idw.idwws.PortaEthernetDTO portaEthernet,
           idw.idwws.PortaSerial232DTO portaRS232,
           idw.idwws.PortaSerial485DTO portaRS485,
           idw.idwws.PortaUSBDTO portaUSB,
           idw.idwws.IcUpDTO[] portas,
           boolean removerThread,
           java.lang.Integer revisao,
           boolean stAndonConfiguravelAtivo,
           java.lang.Integer st_ativo,
           int tpCalculoAndon,
           java.lang.Integer tp_ic,
           idw.idwws.AndonDTO[] ultimosParametrosAndon,
           java.lang.String url_conexao) {
           this.cd_ic = cd_ic;
           this.ds_ic = ds_ic;
           this.dthr_heartbeat = dthr_heartbeat;
           this.dthr_revisao = dthr_revisao;
           this.dthr_stativo = dthr_stativo;
           this.firmware = firmware;
           this.idIc = idIc;
           this.log = log;
           this.logAndon = logAndon;
           this.loginUsuario = loginUsuario;
           this.portaEthernet = portaEthernet;
           this.portaRS232 = portaRS232;
           this.portaRS485 = portaRS485;
           this.portaUSB = portaUSB;
           this.portas = portas;
           this.removerThread = removerThread;
           this.revisao = revisao;
           this.stAndonConfiguravelAtivo = stAndonConfiguravelAtivo;
           this.st_ativo = st_ativo;
           this.tpCalculoAndon = tpCalculoAndon;
           this.tp_ic = tp_ic;
           this.ultimosParametrosAndon = ultimosParametrosAndon;
           this.url_conexao = url_conexao;
    }


    /**
     * Gets the cd_ic value for this IcDTO.
     * 
     * @return cd_ic
     */
    public java.lang.String getCd_ic() {
        return cd_ic;
    }


    /**
     * Sets the cd_ic value for this IcDTO.
     * 
     * @param cd_ic
     */
    public void setCd_ic(java.lang.String cd_ic) {
        this.cd_ic = cd_ic;
    }


    /**
     * Gets the ds_ic value for this IcDTO.
     * 
     * @return ds_ic
     */
    public java.lang.String getDs_ic() {
        return ds_ic;
    }


    /**
     * Sets the ds_ic value for this IcDTO.
     * 
     * @param ds_ic
     */
    public void setDs_ic(java.lang.String ds_ic) {
        this.ds_ic = ds_ic;
    }


    /**
     * Gets the dthr_heartbeat value for this IcDTO.
     * 
     * @return dthr_heartbeat
     */
    public java.util.Calendar getDthr_heartbeat() {
        return dthr_heartbeat;
    }


    /**
     * Sets the dthr_heartbeat value for this IcDTO.
     * 
     * @param dthr_heartbeat
     */
    public void setDthr_heartbeat(java.util.Calendar dthr_heartbeat) {
        this.dthr_heartbeat = dthr_heartbeat;
    }


    /**
     * Gets the dthr_revisao value for this IcDTO.
     * 
     * @return dthr_revisao
     */
    public java.util.Calendar getDthr_revisao() {
        return dthr_revisao;
    }


    /**
     * Sets the dthr_revisao value for this IcDTO.
     * 
     * @param dthr_revisao
     */
    public void setDthr_revisao(java.util.Calendar dthr_revisao) {
        this.dthr_revisao = dthr_revisao;
    }


    /**
     * Gets the dthr_stativo value for this IcDTO.
     * 
     * @return dthr_stativo
     */
    public java.util.Calendar getDthr_stativo() {
        return dthr_stativo;
    }


    /**
     * Sets the dthr_stativo value for this IcDTO.
     * 
     * @param dthr_stativo
     */
    public void setDthr_stativo(java.util.Calendar dthr_stativo) {
        this.dthr_stativo = dthr_stativo;
    }


    /**
     * Gets the firmware value for this IcDTO.
     * 
     * @return firmware
     */
    public java.lang.String getFirmware() {
        return firmware;
    }


    /**
     * Sets the firmware value for this IcDTO.
     * 
     * @param firmware
     */
    public void setFirmware(java.lang.String firmware) {
        this.firmware = firmware;
    }


    /**
     * Gets the idIc value for this IcDTO.
     * 
     * @return idIc
     */
    public java.lang.Integer getIdIc() {
        return idIc;
    }


    /**
     * Sets the idIc value for this IcDTO.
     * 
     * @param idIc
     */
    public void setIdIc(java.lang.Integer idIc) {
        this.idIc = idIc;
    }


    /**
     * Gets the log value for this IcDTO.
     * 
     * @return log
     */
    public idw.idwws.IdwLogger getLog() {
        return log;
    }


    /**
     * Sets the log value for this IcDTO.
     * 
     * @param log
     */
    public void setLog(idw.idwws.IdwLogger log) {
        this.log = log;
    }


    /**
     * Gets the logAndon value for this IcDTO.
     * 
     * @return logAndon
     */
    public idw.idwws.IdwLogger getLogAndon() {
        return logAndon;
    }


    /**
     * Sets the logAndon value for this IcDTO.
     * 
     * @param logAndon
     */
    public void setLogAndon(idw.idwws.IdwLogger logAndon) {
        this.logAndon = logAndon;
    }


    /**
     * Gets the loginUsuario value for this IcDTO.
     * 
     * @return loginUsuario
     */
    public java.lang.String getLoginUsuario() {
        return loginUsuario;
    }


    /**
     * Sets the loginUsuario value for this IcDTO.
     * 
     * @param loginUsuario
     */
    public void setLoginUsuario(java.lang.String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }


    /**
     * Gets the portaEthernet value for this IcDTO.
     * 
     * @return portaEthernet
     */
    public idw.idwws.PortaEthernetDTO getPortaEthernet() {
        return portaEthernet;
    }


    /**
     * Sets the portaEthernet value for this IcDTO.
     * 
     * @param portaEthernet
     */
    public void setPortaEthernet(idw.idwws.PortaEthernetDTO portaEthernet) {
        this.portaEthernet = portaEthernet;
    }


    /**
     * Gets the portaRS232 value for this IcDTO.
     * 
     * @return portaRS232
     */
    public idw.idwws.PortaSerial232DTO getPortaRS232() {
        return portaRS232;
    }


    /**
     * Sets the portaRS232 value for this IcDTO.
     * 
     * @param portaRS232
     */
    public void setPortaRS232(idw.idwws.PortaSerial232DTO portaRS232) {
        this.portaRS232 = portaRS232;
    }


    /**
     * Gets the portaRS485 value for this IcDTO.
     * 
     * @return portaRS485
     */
    public idw.idwws.PortaSerial485DTO getPortaRS485() {
        return portaRS485;
    }


    /**
     * Sets the portaRS485 value for this IcDTO.
     * 
     * @param portaRS485
     */
    public void setPortaRS485(idw.idwws.PortaSerial485DTO portaRS485) {
        this.portaRS485 = portaRS485;
    }


    /**
     * Gets the portaUSB value for this IcDTO.
     * 
     * @return portaUSB
     */
    public idw.idwws.PortaUSBDTO getPortaUSB() {
        return portaUSB;
    }


    /**
     * Sets the portaUSB value for this IcDTO.
     * 
     * @param portaUSB
     */
    public void setPortaUSB(idw.idwws.PortaUSBDTO portaUSB) {
        this.portaUSB = portaUSB;
    }


    /**
     * Gets the portas value for this IcDTO.
     * 
     * @return portas
     */
    public idw.idwws.IcUpDTO[] getPortas() {
        return portas;
    }


    /**
     * Sets the portas value for this IcDTO.
     * 
     * @param portas
     */
    public void setPortas(idw.idwws.IcUpDTO[] portas) {
        this.portas = portas;
    }

    public idw.idwws.IcUpDTO getPortas(int i) {
        return this.portas[i];
    }

    public void setPortas(int i, idw.idwws.IcUpDTO _value) {
        this.portas[i] = _value;
    }


    /**
     * Gets the removerThread value for this IcDTO.
     * 
     * @return removerThread
     */
    public boolean isRemoverThread() {
        return removerThread;
    }


    /**
     * Sets the removerThread value for this IcDTO.
     * 
     * @param removerThread
     */
    public void setRemoverThread(boolean removerThread) {
        this.removerThread = removerThread;
    }


    /**
     * Gets the revisao value for this IcDTO.
     * 
     * @return revisao
     */
    public java.lang.Integer getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this IcDTO.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Integer revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAndonConfiguravelAtivo value for this IcDTO.
     * 
     * @return stAndonConfiguravelAtivo
     */
    public boolean isStAndonConfiguravelAtivo() {
        return stAndonConfiguravelAtivo;
    }


    /**
     * Sets the stAndonConfiguravelAtivo value for this IcDTO.
     * 
     * @param stAndonConfiguravelAtivo
     */
    public void setStAndonConfiguravelAtivo(boolean stAndonConfiguravelAtivo) {
        this.stAndonConfiguravelAtivo = stAndonConfiguravelAtivo;
    }


    /**
     * Gets the st_ativo value for this IcDTO.
     * 
     * @return st_ativo
     */
    public java.lang.Integer getSt_ativo() {
        return st_ativo;
    }


    /**
     * Sets the st_ativo value for this IcDTO.
     * 
     * @param st_ativo
     */
    public void setSt_ativo(java.lang.Integer st_ativo) {
        this.st_ativo = st_ativo;
    }


    /**
     * Gets the tpCalculoAndon value for this IcDTO.
     * 
     * @return tpCalculoAndon
     */
    public int getTpCalculoAndon() {
        return tpCalculoAndon;
    }


    /**
     * Sets the tpCalculoAndon value for this IcDTO.
     * 
     * @param tpCalculoAndon
     */
    public void setTpCalculoAndon(int tpCalculoAndon) {
        this.tpCalculoAndon = tpCalculoAndon;
    }


    /**
     * Gets the tp_ic value for this IcDTO.
     * 
     * @return tp_ic
     */
    public java.lang.Integer getTp_ic() {
        return tp_ic;
    }


    /**
     * Sets the tp_ic value for this IcDTO.
     * 
     * @param tp_ic
     */
    public void setTp_ic(java.lang.Integer tp_ic) {
        this.tp_ic = tp_ic;
    }


    /**
     * Gets the ultimosParametrosAndon value for this IcDTO.
     * 
     * @return ultimosParametrosAndon
     */
    public idw.idwws.AndonDTO[] getUltimosParametrosAndon() {
        return ultimosParametrosAndon;
    }


    /**
     * Sets the ultimosParametrosAndon value for this IcDTO.
     * 
     * @param ultimosParametrosAndon
     */
    public void setUltimosParametrosAndon(idw.idwws.AndonDTO[] ultimosParametrosAndon) {
        this.ultimosParametrosAndon = ultimosParametrosAndon;
    }

    public idw.idwws.AndonDTO getUltimosParametrosAndon(int i) {
        return this.ultimosParametrosAndon[i];
    }

    public void setUltimosParametrosAndon(int i, idw.idwws.AndonDTO _value) {
        this.ultimosParametrosAndon[i] = _value;
    }


    /**
     * Gets the url_conexao value for this IcDTO.
     * 
     * @return url_conexao
     */
    public java.lang.String getUrl_conexao() {
        return url_conexao;
    }


    /**
     * Sets the url_conexao value for this IcDTO.
     * 
     * @param url_conexao
     */
    public void setUrl_conexao(java.lang.String url_conexao) {
        this.url_conexao = url_conexao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IcDTO)) return false;
        IcDTO other = (IcDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cd_ic==null && other.getCd_ic()==null) || 
             (this.cd_ic!=null &&
              this.cd_ic.equals(other.getCd_ic()))) &&
            ((this.ds_ic==null && other.getDs_ic()==null) || 
             (this.ds_ic!=null &&
              this.ds_ic.equals(other.getDs_ic()))) &&
            ((this.dthr_heartbeat==null && other.getDthr_heartbeat()==null) || 
             (this.dthr_heartbeat!=null &&
              this.dthr_heartbeat.equals(other.getDthr_heartbeat()))) &&
            ((this.dthr_revisao==null && other.getDthr_revisao()==null) || 
             (this.dthr_revisao!=null &&
              this.dthr_revisao.equals(other.getDthr_revisao()))) &&
            ((this.dthr_stativo==null && other.getDthr_stativo()==null) || 
             (this.dthr_stativo!=null &&
              this.dthr_stativo.equals(other.getDthr_stativo()))) &&
            ((this.firmware==null && other.getFirmware()==null) || 
             (this.firmware!=null &&
              this.firmware.equals(other.getFirmware()))) &&
            ((this.idIc==null && other.getIdIc()==null) || 
             (this.idIc!=null &&
              this.idIc.equals(other.getIdIc()))) &&
            ((this.log==null && other.getLog()==null) || 
             (this.log!=null &&
              this.log.equals(other.getLog()))) &&
            ((this.logAndon==null && other.getLogAndon()==null) || 
             (this.logAndon!=null &&
              this.logAndon.equals(other.getLogAndon()))) &&
            ((this.loginUsuario==null && other.getLoginUsuario()==null) || 
             (this.loginUsuario!=null &&
              this.loginUsuario.equals(other.getLoginUsuario()))) &&
            ((this.portaEthernet==null && other.getPortaEthernet()==null) || 
             (this.portaEthernet!=null &&
              this.portaEthernet.equals(other.getPortaEthernet()))) &&
            ((this.portaRS232==null && other.getPortaRS232()==null) || 
             (this.portaRS232!=null &&
              this.portaRS232.equals(other.getPortaRS232()))) &&
            ((this.portaRS485==null && other.getPortaRS485()==null) || 
             (this.portaRS485!=null &&
              this.portaRS485.equals(other.getPortaRS485()))) &&
            ((this.portaUSB==null && other.getPortaUSB()==null) || 
             (this.portaUSB!=null &&
              this.portaUSB.equals(other.getPortaUSB()))) &&
            ((this.portas==null && other.getPortas()==null) || 
             (this.portas!=null &&
              java.util.Arrays.equals(this.portas, other.getPortas()))) &&
            this.removerThread == other.isRemoverThread() &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            this.stAndonConfiguravelAtivo == other.isStAndonConfiguravelAtivo() &&
            ((this.st_ativo==null && other.getSt_ativo()==null) || 
             (this.st_ativo!=null &&
              this.st_ativo.equals(other.getSt_ativo()))) &&
            this.tpCalculoAndon == other.getTpCalculoAndon() &&
            ((this.tp_ic==null && other.getTp_ic()==null) || 
             (this.tp_ic!=null &&
              this.tp_ic.equals(other.getTp_ic()))) &&
            ((this.ultimosParametrosAndon==null && other.getUltimosParametrosAndon()==null) || 
             (this.ultimosParametrosAndon!=null &&
              java.util.Arrays.equals(this.ultimosParametrosAndon, other.getUltimosParametrosAndon()))) &&
            ((this.url_conexao==null && other.getUrl_conexao()==null) || 
             (this.url_conexao!=null &&
              this.url_conexao.equals(other.getUrl_conexao())));
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
        if (getCd_ic() != null) {
            _hashCode += getCd_ic().hashCode();
        }
        if (getDs_ic() != null) {
            _hashCode += getDs_ic().hashCode();
        }
        if (getDthr_heartbeat() != null) {
            _hashCode += getDthr_heartbeat().hashCode();
        }
        if (getDthr_revisao() != null) {
            _hashCode += getDthr_revisao().hashCode();
        }
        if (getDthr_stativo() != null) {
            _hashCode += getDthr_stativo().hashCode();
        }
        if (getFirmware() != null) {
            _hashCode += getFirmware().hashCode();
        }
        if (getIdIc() != null) {
            _hashCode += getIdIc().hashCode();
        }
        if (getLog() != null) {
            _hashCode += getLog().hashCode();
        }
        if (getLogAndon() != null) {
            _hashCode += getLogAndon().hashCode();
        }
        if (getLoginUsuario() != null) {
            _hashCode += getLoginUsuario().hashCode();
        }
        if (getPortaEthernet() != null) {
            _hashCode += getPortaEthernet().hashCode();
        }
        if (getPortaRS232() != null) {
            _hashCode += getPortaRS232().hashCode();
        }
        if (getPortaRS485() != null) {
            _hashCode += getPortaRS485().hashCode();
        }
        if (getPortaUSB() != null) {
            _hashCode += getPortaUSB().hashCode();
        }
        if (getPortas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPortas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPortas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isRemoverThread() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        _hashCode += (isStAndonConfiguravelAtivo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSt_ativo() != null) {
            _hashCode += getSt_ativo().hashCode();
        }
        _hashCode += getTpCalculoAndon();
        if (getTp_ic() != null) {
            _hashCode += getTp_ic().hashCode();
        }
        if (getUltimosParametrosAndon() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUltimosParametrosAndon());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUltimosParametrosAndon(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUrl_conexao() != null) {
            _hashCode += getUrl_conexao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IcDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "icDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cd_ic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cd_ic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ds_ic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ds_ic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthr_heartbeat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthr_heartbeat"));
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
        elemField.setFieldName("firmware");
        elemField.setXmlName(new javax.xml.namespace.QName("", "firmware"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idIc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idIc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("log");
        elemField.setXmlName(new javax.xml.namespace.QName("", "log"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "idwLogger"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logAndon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "logAndon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "idwLogger"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "loginUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portaEthernet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "portaEthernet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "portaEthernetDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portaRS232");
        elemField.setXmlName(new javax.xml.namespace.QName("", "portaRS232"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "portaSerial232DTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portaRS485");
        elemField.setXmlName(new javax.xml.namespace.QName("", "portaRS485"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "portaSerial485DTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portaUSB");
        elemField.setXmlName(new javax.xml.namespace.QName("", "portaUSB"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "portaUSBDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "portas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "icUpDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("removerThread");
        elemField.setXmlName(new javax.xml.namespace.QName("", "removerThread"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("stAndonConfiguravelAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAndonConfiguravelAtivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tp_ic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tp_ic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ultimosParametrosAndon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ultimosParametrosAndon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "andonDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url_conexao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url_conexao"));
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
