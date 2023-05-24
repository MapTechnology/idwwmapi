/**
 * IhmDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IhmDTO  implements java.io.Serializable {
    private java.lang.String cdIhm;

    private idw.idwws.PortaEthernetDTO conexaoIHM;

    private java.util.Calendar dthrCadastro;

    private idw.idwws.EventoRealDTO[] eventosPendentes;

    private java.lang.Integer idIhm;

    private java.lang.Boolean isEvtAlerta;

    private java.lang.Boolean isEvtCicloFechado;

    private java.lang.Boolean isEvtLogin;

    private java.lang.Boolean isEvtParada;

    private java.lang.Boolean isEvtPendente;

    private java.lang.Boolean isEvtRefugo;

    private java.lang.Boolean isEvtTrabalhando;

    private java.lang.Boolean isTodosEvt;

    private java.lang.Boolean isUpRegistrado;

    private java.lang.String loginUsuario;

    private java.lang.Integer tipoRequisicaoIHM;

    private java.lang.Integer tipoRequisicaoWS;

    private idw.idwws.EventoPrevistoDTO[] tratamentoSinais;

    private java.lang.String url_Conexao;

    private java.lang.String url_ConexaoAlternativo;

    private java.lang.String url_Ip;

    private idw.idwws.WsDTO wsDTO;

    public IhmDTO() {
    }

    public IhmDTO(
           java.lang.String cdIhm,
           idw.idwws.PortaEthernetDTO conexaoIHM,
           java.util.Calendar dthrCadastro,
           idw.idwws.EventoRealDTO[] eventosPendentes,
           java.lang.Integer idIhm,
           java.lang.Boolean isEvtAlerta,
           java.lang.Boolean isEvtCicloFechado,
           java.lang.Boolean isEvtLogin,
           java.lang.Boolean isEvtParada,
           java.lang.Boolean isEvtPendente,
           java.lang.Boolean isEvtRefugo,
           java.lang.Boolean isEvtTrabalhando,
           java.lang.Boolean isTodosEvt,
           java.lang.Boolean isUpRegistrado,
           java.lang.String loginUsuario,
           java.lang.Integer tipoRequisicaoIHM,
           java.lang.Integer tipoRequisicaoWS,
           idw.idwws.EventoPrevistoDTO[] tratamentoSinais,
           java.lang.String url_Conexao,
           java.lang.String url_ConexaoAlternativo,
           java.lang.String url_Ip,
           idw.idwws.WsDTO wsDTO) {
           this.cdIhm = cdIhm;
           this.conexaoIHM = conexaoIHM;
           this.dthrCadastro = dthrCadastro;
           this.eventosPendentes = eventosPendentes;
           this.idIhm = idIhm;
           this.isEvtAlerta = isEvtAlerta;
           this.isEvtCicloFechado = isEvtCicloFechado;
           this.isEvtLogin = isEvtLogin;
           this.isEvtParada = isEvtParada;
           this.isEvtPendente = isEvtPendente;
           this.isEvtRefugo = isEvtRefugo;
           this.isEvtTrabalhando = isEvtTrabalhando;
           this.isTodosEvt = isTodosEvt;
           this.isUpRegistrado = isUpRegistrado;
           this.loginUsuario = loginUsuario;
           this.tipoRequisicaoIHM = tipoRequisicaoIHM;
           this.tipoRequisicaoWS = tipoRequisicaoWS;
           this.tratamentoSinais = tratamentoSinais;
           this.url_Conexao = url_Conexao;
           this.url_ConexaoAlternativo = url_ConexaoAlternativo;
           this.url_Ip = url_Ip;
           this.wsDTO = wsDTO;
    }


    /**
     * Gets the cdIhm value for this IhmDTO.
     * 
     * @return cdIhm
     */
    public java.lang.String getCdIhm() {
        return cdIhm;
    }


    /**
     * Sets the cdIhm value for this IhmDTO.
     * 
     * @param cdIhm
     */
    public void setCdIhm(java.lang.String cdIhm) {
        this.cdIhm = cdIhm;
    }


    /**
     * Gets the conexaoIHM value for this IhmDTO.
     * 
     * @return conexaoIHM
     */
    public idw.idwws.PortaEthernetDTO getConexaoIHM() {
        return conexaoIHM;
    }


    /**
     * Sets the conexaoIHM value for this IhmDTO.
     * 
     * @param conexaoIHM
     */
    public void setConexaoIHM(idw.idwws.PortaEthernetDTO conexaoIHM) {
        this.conexaoIHM = conexaoIHM;
    }


    /**
     * Gets the dthrCadastro value for this IhmDTO.
     * 
     * @return dthrCadastro
     */
    public java.util.Calendar getDthrCadastro() {
        return dthrCadastro;
    }


    /**
     * Sets the dthrCadastro value for this IhmDTO.
     * 
     * @param dthrCadastro
     */
    public void setDthrCadastro(java.util.Calendar dthrCadastro) {
        this.dthrCadastro = dthrCadastro;
    }


    /**
     * Gets the eventosPendentes value for this IhmDTO.
     * 
     * @return eventosPendentes
     */
    public idw.idwws.EventoRealDTO[] getEventosPendentes() {
        return eventosPendentes;
    }


    /**
     * Sets the eventosPendentes value for this IhmDTO.
     * 
     * @param eventosPendentes
     */
    public void setEventosPendentes(idw.idwws.EventoRealDTO[] eventosPendentes) {
        this.eventosPendentes = eventosPendentes;
    }

    public idw.idwws.EventoRealDTO getEventosPendentes(int i) {
        return this.eventosPendentes[i];
    }

    public void setEventosPendentes(int i, idw.idwws.EventoRealDTO _value) {
        this.eventosPendentes[i] = _value;
    }


    /**
     * Gets the idIhm value for this IhmDTO.
     * 
     * @return idIhm
     */
    public java.lang.Integer getIdIhm() {
        return idIhm;
    }


    /**
     * Sets the idIhm value for this IhmDTO.
     * 
     * @param idIhm
     */
    public void setIdIhm(java.lang.Integer idIhm) {
        this.idIhm = idIhm;
    }


    /**
     * Gets the isEvtAlerta value for this IhmDTO.
     * 
     * @return isEvtAlerta
     */
    public java.lang.Boolean getIsEvtAlerta() {
        return isEvtAlerta;
    }


    /**
     * Sets the isEvtAlerta value for this IhmDTO.
     * 
     * @param isEvtAlerta
     */
    public void setIsEvtAlerta(java.lang.Boolean isEvtAlerta) {
        this.isEvtAlerta = isEvtAlerta;
    }


    /**
     * Gets the isEvtCicloFechado value for this IhmDTO.
     * 
     * @return isEvtCicloFechado
     */
    public java.lang.Boolean getIsEvtCicloFechado() {
        return isEvtCicloFechado;
    }


    /**
     * Sets the isEvtCicloFechado value for this IhmDTO.
     * 
     * @param isEvtCicloFechado
     */
    public void setIsEvtCicloFechado(java.lang.Boolean isEvtCicloFechado) {
        this.isEvtCicloFechado = isEvtCicloFechado;
    }


    /**
     * Gets the isEvtLogin value for this IhmDTO.
     * 
     * @return isEvtLogin
     */
    public java.lang.Boolean getIsEvtLogin() {
        return isEvtLogin;
    }


    /**
     * Sets the isEvtLogin value for this IhmDTO.
     * 
     * @param isEvtLogin
     */
    public void setIsEvtLogin(java.lang.Boolean isEvtLogin) {
        this.isEvtLogin = isEvtLogin;
    }


    /**
     * Gets the isEvtParada value for this IhmDTO.
     * 
     * @return isEvtParada
     */
    public java.lang.Boolean getIsEvtParada() {
        return isEvtParada;
    }


    /**
     * Sets the isEvtParada value for this IhmDTO.
     * 
     * @param isEvtParada
     */
    public void setIsEvtParada(java.lang.Boolean isEvtParada) {
        this.isEvtParada = isEvtParada;
    }


    /**
     * Gets the isEvtPendente value for this IhmDTO.
     * 
     * @return isEvtPendente
     */
    public java.lang.Boolean getIsEvtPendente() {
        return isEvtPendente;
    }


    /**
     * Sets the isEvtPendente value for this IhmDTO.
     * 
     * @param isEvtPendente
     */
    public void setIsEvtPendente(java.lang.Boolean isEvtPendente) {
        this.isEvtPendente = isEvtPendente;
    }


    /**
     * Gets the isEvtRefugo value for this IhmDTO.
     * 
     * @return isEvtRefugo
     */
    public java.lang.Boolean getIsEvtRefugo() {
        return isEvtRefugo;
    }


    /**
     * Sets the isEvtRefugo value for this IhmDTO.
     * 
     * @param isEvtRefugo
     */
    public void setIsEvtRefugo(java.lang.Boolean isEvtRefugo) {
        this.isEvtRefugo = isEvtRefugo;
    }


    /**
     * Gets the isEvtTrabalhando value for this IhmDTO.
     * 
     * @return isEvtTrabalhando
     */
    public java.lang.Boolean getIsEvtTrabalhando() {
        return isEvtTrabalhando;
    }


    /**
     * Sets the isEvtTrabalhando value for this IhmDTO.
     * 
     * @param isEvtTrabalhando
     */
    public void setIsEvtTrabalhando(java.lang.Boolean isEvtTrabalhando) {
        this.isEvtTrabalhando = isEvtTrabalhando;
    }


    /**
     * Gets the isTodosEvt value for this IhmDTO.
     * 
     * @return isTodosEvt
     */
    public java.lang.Boolean getIsTodosEvt() {
        return isTodosEvt;
    }


    /**
     * Sets the isTodosEvt value for this IhmDTO.
     * 
     * @param isTodosEvt
     */
    public void setIsTodosEvt(java.lang.Boolean isTodosEvt) {
        this.isTodosEvt = isTodosEvt;
    }


    /**
     * Gets the isUpRegistrado value for this IhmDTO.
     * 
     * @return isUpRegistrado
     */
    public java.lang.Boolean getIsUpRegistrado() {
        return isUpRegistrado;
    }


    /**
     * Sets the isUpRegistrado value for this IhmDTO.
     * 
     * @param isUpRegistrado
     */
    public void setIsUpRegistrado(java.lang.Boolean isUpRegistrado) {
        this.isUpRegistrado = isUpRegistrado;
    }


    /**
     * Gets the loginUsuario value for this IhmDTO.
     * 
     * @return loginUsuario
     */
    public java.lang.String getLoginUsuario() {
        return loginUsuario;
    }


    /**
     * Sets the loginUsuario value for this IhmDTO.
     * 
     * @param loginUsuario
     */
    public void setLoginUsuario(java.lang.String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }


    /**
     * Gets the tipoRequisicaoIHM value for this IhmDTO.
     * 
     * @return tipoRequisicaoIHM
     */
    public java.lang.Integer getTipoRequisicaoIHM() {
        return tipoRequisicaoIHM;
    }


    /**
     * Sets the tipoRequisicaoIHM value for this IhmDTO.
     * 
     * @param tipoRequisicaoIHM
     */
    public void setTipoRequisicaoIHM(java.lang.Integer tipoRequisicaoIHM) {
        this.tipoRequisicaoIHM = tipoRequisicaoIHM;
    }


    /**
     * Gets the tipoRequisicaoWS value for this IhmDTO.
     * 
     * @return tipoRequisicaoWS
     */
    public java.lang.Integer getTipoRequisicaoWS() {
        return tipoRequisicaoWS;
    }


    /**
     * Sets the tipoRequisicaoWS value for this IhmDTO.
     * 
     * @param tipoRequisicaoWS
     */
    public void setTipoRequisicaoWS(java.lang.Integer tipoRequisicaoWS) {
        this.tipoRequisicaoWS = tipoRequisicaoWS;
    }


    /**
     * Gets the tratamentoSinais value for this IhmDTO.
     * 
     * @return tratamentoSinais
     */
    public idw.idwws.EventoPrevistoDTO[] getTratamentoSinais() {
        return tratamentoSinais;
    }


    /**
     * Sets the tratamentoSinais value for this IhmDTO.
     * 
     * @param tratamentoSinais
     */
    public void setTratamentoSinais(idw.idwws.EventoPrevistoDTO[] tratamentoSinais) {
        this.tratamentoSinais = tratamentoSinais;
    }

    public idw.idwws.EventoPrevistoDTO getTratamentoSinais(int i) {
        return this.tratamentoSinais[i];
    }

    public void setTratamentoSinais(int i, idw.idwws.EventoPrevistoDTO _value) {
        this.tratamentoSinais[i] = _value;
    }


    /**
     * Gets the url_Conexao value for this IhmDTO.
     * 
     * @return url_Conexao
     */
    public java.lang.String getUrl_Conexao() {
        return url_Conexao;
    }


    /**
     * Sets the url_Conexao value for this IhmDTO.
     * 
     * @param url_Conexao
     */
    public void setUrl_Conexao(java.lang.String url_Conexao) {
        this.url_Conexao = url_Conexao;
    }


    /**
     * Gets the url_ConexaoAlternativo value for this IhmDTO.
     * 
     * @return url_ConexaoAlternativo
     */
    public java.lang.String getUrl_ConexaoAlternativo() {
        return url_ConexaoAlternativo;
    }


    /**
     * Sets the url_ConexaoAlternativo value for this IhmDTO.
     * 
     * @param url_ConexaoAlternativo
     */
    public void setUrl_ConexaoAlternativo(java.lang.String url_ConexaoAlternativo) {
        this.url_ConexaoAlternativo = url_ConexaoAlternativo;
    }


    /**
     * Gets the url_Ip value for this IhmDTO.
     * 
     * @return url_Ip
     */
    public java.lang.String getUrl_Ip() {
        return url_Ip;
    }


    /**
     * Sets the url_Ip value for this IhmDTO.
     * 
     * @param url_Ip
     */
    public void setUrl_Ip(java.lang.String url_Ip) {
        this.url_Ip = url_Ip;
    }


    /**
     * Gets the wsDTO value for this IhmDTO.
     * 
     * @return wsDTO
     */
    public idw.idwws.WsDTO getWsDTO() {
        return wsDTO;
    }


    /**
     * Sets the wsDTO value for this IhmDTO.
     * 
     * @param wsDTO
     */
    public void setWsDTO(idw.idwws.WsDTO wsDTO) {
        this.wsDTO = wsDTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IhmDTO)) return false;
        IhmDTO other = (IhmDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdIhm==null && other.getCdIhm()==null) || 
             (this.cdIhm!=null &&
              this.cdIhm.equals(other.getCdIhm()))) &&
            ((this.conexaoIHM==null && other.getConexaoIHM()==null) || 
             (this.conexaoIHM!=null &&
              this.conexaoIHM.equals(other.getConexaoIHM()))) &&
            ((this.dthrCadastro==null && other.getDthrCadastro()==null) || 
             (this.dthrCadastro!=null &&
              this.dthrCadastro.equals(other.getDthrCadastro()))) &&
            ((this.eventosPendentes==null && other.getEventosPendentes()==null) || 
             (this.eventosPendentes!=null &&
              java.util.Arrays.equals(this.eventosPendentes, other.getEventosPendentes()))) &&
            ((this.idIhm==null && other.getIdIhm()==null) || 
             (this.idIhm!=null &&
              this.idIhm.equals(other.getIdIhm()))) &&
            ((this.isEvtAlerta==null && other.getIsEvtAlerta()==null) || 
             (this.isEvtAlerta!=null &&
              this.isEvtAlerta.equals(other.getIsEvtAlerta()))) &&
            ((this.isEvtCicloFechado==null && other.getIsEvtCicloFechado()==null) || 
             (this.isEvtCicloFechado!=null &&
              this.isEvtCicloFechado.equals(other.getIsEvtCicloFechado()))) &&
            ((this.isEvtLogin==null && other.getIsEvtLogin()==null) || 
             (this.isEvtLogin!=null &&
              this.isEvtLogin.equals(other.getIsEvtLogin()))) &&
            ((this.isEvtParada==null && other.getIsEvtParada()==null) || 
             (this.isEvtParada!=null &&
              this.isEvtParada.equals(other.getIsEvtParada()))) &&
            ((this.isEvtPendente==null && other.getIsEvtPendente()==null) || 
             (this.isEvtPendente!=null &&
              this.isEvtPendente.equals(other.getIsEvtPendente()))) &&
            ((this.isEvtRefugo==null && other.getIsEvtRefugo()==null) || 
             (this.isEvtRefugo!=null &&
              this.isEvtRefugo.equals(other.getIsEvtRefugo()))) &&
            ((this.isEvtTrabalhando==null && other.getIsEvtTrabalhando()==null) || 
             (this.isEvtTrabalhando!=null &&
              this.isEvtTrabalhando.equals(other.getIsEvtTrabalhando()))) &&
            ((this.isTodosEvt==null && other.getIsTodosEvt()==null) || 
             (this.isTodosEvt!=null &&
              this.isTodosEvt.equals(other.getIsTodosEvt()))) &&
            ((this.isUpRegistrado==null && other.getIsUpRegistrado()==null) || 
             (this.isUpRegistrado!=null &&
              this.isUpRegistrado.equals(other.getIsUpRegistrado()))) &&
            ((this.loginUsuario==null && other.getLoginUsuario()==null) || 
             (this.loginUsuario!=null &&
              this.loginUsuario.equals(other.getLoginUsuario()))) &&
            ((this.tipoRequisicaoIHM==null && other.getTipoRequisicaoIHM()==null) || 
             (this.tipoRequisicaoIHM!=null &&
              this.tipoRequisicaoIHM.equals(other.getTipoRequisicaoIHM()))) &&
            ((this.tipoRequisicaoWS==null && other.getTipoRequisicaoWS()==null) || 
             (this.tipoRequisicaoWS!=null &&
              this.tipoRequisicaoWS.equals(other.getTipoRequisicaoWS()))) &&
            ((this.tratamentoSinais==null && other.getTratamentoSinais()==null) || 
             (this.tratamentoSinais!=null &&
              java.util.Arrays.equals(this.tratamentoSinais, other.getTratamentoSinais()))) &&
            ((this.url_Conexao==null && other.getUrl_Conexao()==null) || 
             (this.url_Conexao!=null &&
              this.url_Conexao.equals(other.getUrl_Conexao()))) &&
            ((this.url_ConexaoAlternativo==null && other.getUrl_ConexaoAlternativo()==null) || 
             (this.url_ConexaoAlternativo!=null &&
              this.url_ConexaoAlternativo.equals(other.getUrl_ConexaoAlternativo()))) &&
            ((this.url_Ip==null && other.getUrl_Ip()==null) || 
             (this.url_Ip!=null &&
              this.url_Ip.equals(other.getUrl_Ip()))) &&
            ((this.wsDTO==null && other.getWsDTO()==null) || 
             (this.wsDTO!=null &&
              this.wsDTO.equals(other.getWsDTO())));
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
        if (getCdIhm() != null) {
            _hashCode += getCdIhm().hashCode();
        }
        if (getConexaoIHM() != null) {
            _hashCode += getConexaoIHM().hashCode();
        }
        if (getDthrCadastro() != null) {
            _hashCode += getDthrCadastro().hashCode();
        }
        if (getEventosPendentes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEventosPendentes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEventosPendentes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdIhm() != null) {
            _hashCode += getIdIhm().hashCode();
        }
        if (getIsEvtAlerta() != null) {
            _hashCode += getIsEvtAlerta().hashCode();
        }
        if (getIsEvtCicloFechado() != null) {
            _hashCode += getIsEvtCicloFechado().hashCode();
        }
        if (getIsEvtLogin() != null) {
            _hashCode += getIsEvtLogin().hashCode();
        }
        if (getIsEvtParada() != null) {
            _hashCode += getIsEvtParada().hashCode();
        }
        if (getIsEvtPendente() != null) {
            _hashCode += getIsEvtPendente().hashCode();
        }
        if (getIsEvtRefugo() != null) {
            _hashCode += getIsEvtRefugo().hashCode();
        }
        if (getIsEvtTrabalhando() != null) {
            _hashCode += getIsEvtTrabalhando().hashCode();
        }
        if (getIsTodosEvt() != null) {
            _hashCode += getIsTodosEvt().hashCode();
        }
        if (getIsUpRegistrado() != null) {
            _hashCode += getIsUpRegistrado().hashCode();
        }
        if (getLoginUsuario() != null) {
            _hashCode += getLoginUsuario().hashCode();
        }
        if (getTipoRequisicaoIHM() != null) {
            _hashCode += getTipoRequisicaoIHM().hashCode();
        }
        if (getTipoRequisicaoWS() != null) {
            _hashCode += getTipoRequisicaoWS().hashCode();
        }
        if (getTratamentoSinais() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTratamentoSinais());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTratamentoSinais(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUrl_Conexao() != null) {
            _hashCode += getUrl_Conexao().hashCode();
        }
        if (getUrl_ConexaoAlternativo() != null) {
            _hashCode += getUrl_ConexaoAlternativo().hashCode();
        }
        if (getUrl_Ip() != null) {
            _hashCode += getUrl_Ip().hashCode();
        }
        if (getWsDTO() != null) {
            _hashCode += getWsDTO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IhmDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ihmDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdIhm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdIhm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conexaoIHM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "conexaoIHM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "portaEthernetDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrCadastro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrCadastro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventosPendentes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eventosPendentes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "eventoRealDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idIhm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idIhm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEvtAlerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEvtAlerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEvtCicloFechado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEvtCicloFechado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEvtLogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEvtLogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEvtParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEvtParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEvtPendente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEvtPendente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEvtRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEvtRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEvtTrabalhando");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEvtTrabalhando"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isTodosEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isTodosEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isUpRegistrado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isUpRegistrado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("tipoRequisicaoIHM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoRequisicaoIHM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoRequisicaoWS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoRequisicaoWS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tratamentoSinais");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tratamentoSinais"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "eventoPrevistoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url_Conexao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url_Conexao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url_ConexaoAlternativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url_ConexaoAlternativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url_Ip");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url_Ip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wsDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "wsDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "wsDTO"));
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
