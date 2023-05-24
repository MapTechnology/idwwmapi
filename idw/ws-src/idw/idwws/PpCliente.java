/**
 * PpCliente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpCliente  extends idw.idwws.PpClienteTemplate  implements java.io.Serializable {
    private java.lang.String cdCliente;

    private java.lang.String cidade;

    private java.lang.String cnpjCpf;

    private java.lang.String contato;

    private java.lang.String depara;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwEstpro[] dwEstpros;

    private java.lang.String endereco;

    private java.lang.String estado;

    private java.math.BigDecimal hrLeadtime;

    private java.lang.Long idCliente;

    private java.lang.String nmCliente;

    private idw.idwws.OmClidiario[] omClidiarios;

    private idw.idwws.OmContato[] omContatos;

    private idw.idwws.OmProduto[] omProdutos;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.lang.String pais;

    private idw.idwws.PpCp[] ppCps;

    private idw.idwws.PpNec[] ppNecs;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    private java.lang.String telefonedois;

    private java.lang.String telefonetres;

    private java.lang.String telefoneum;

    private java.lang.Integer tpCliente;

    private java.lang.String urlSite;

    public PpCliente() {
    }

    public PpCliente(
           java.lang.Long id,
           java.lang.String cdCliente,
           java.lang.String cidade,
           java.lang.String cnpjCpf,
           java.lang.String contato,
           java.lang.String depara,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwEstpro[] dwEstpros,
           java.lang.String endereco,
           java.lang.String estado,
           java.math.BigDecimal hrLeadtime,
           java.lang.Long idCliente,
           java.lang.String nmCliente,
           idw.idwws.OmClidiario[] omClidiarios,
           idw.idwws.OmContato[] omContatos,
           idw.idwws.OmProduto[] omProdutos,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.String pais,
           idw.idwws.PpCp[] ppCps,
           idw.idwws.PpNec[] ppNecs,
           java.lang.Long revisao,
           java.lang.Byte stAtivo,
           java.lang.String telefonedois,
           java.lang.String telefonetres,
           java.lang.String telefoneum,
           java.lang.Integer tpCliente,
           java.lang.String urlSite) {
        super(
            id);
        this.cdCliente = cdCliente;
        this.cidade = cidade;
        this.cnpjCpf = cnpjCpf;
        this.contato = contato;
        this.depara = depara;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwEstpros = dwEstpros;
        this.endereco = endereco;
        this.estado = estado;
        this.hrLeadtime = hrLeadtime;
        this.idCliente = idCliente;
        this.nmCliente = nmCliente;
        this.omClidiarios = omClidiarios;
        this.omContatos = omContatos;
        this.omProdutos = omProdutos;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.pais = pais;
        this.ppCps = ppCps;
        this.ppNecs = ppNecs;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
        this.telefonedois = telefonedois;
        this.telefonetres = telefonetres;
        this.telefoneum = telefoneum;
        this.tpCliente = tpCliente;
        this.urlSite = urlSite;
    }


    /**
     * Gets the cdCliente value for this PpCliente.
     * 
     * @return cdCliente
     */
    public java.lang.String getCdCliente() {
        return cdCliente;
    }


    /**
     * Sets the cdCliente value for this PpCliente.
     * 
     * @param cdCliente
     */
    public void setCdCliente(java.lang.String cdCliente) {
        this.cdCliente = cdCliente;
    }


    /**
     * Gets the cidade value for this PpCliente.
     * 
     * @return cidade
     */
    public java.lang.String getCidade() {
        return cidade;
    }


    /**
     * Sets the cidade value for this PpCliente.
     * 
     * @param cidade
     */
    public void setCidade(java.lang.String cidade) {
        this.cidade = cidade;
    }


    /**
     * Gets the cnpjCpf value for this PpCliente.
     * 
     * @return cnpjCpf
     */
    public java.lang.String getCnpjCpf() {
        return cnpjCpf;
    }


    /**
     * Sets the cnpjCpf value for this PpCliente.
     * 
     * @param cnpjCpf
     */
    public void setCnpjCpf(java.lang.String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }


    /**
     * Gets the contato value for this PpCliente.
     * 
     * @return contato
     */
    public java.lang.String getContato() {
        return contato;
    }


    /**
     * Sets the contato value for this PpCliente.
     * 
     * @param contato
     */
    public void setContato(java.lang.String contato) {
        this.contato = contato;
    }


    /**
     * Gets the depara value for this PpCliente.
     * 
     * @return depara
     */
    public java.lang.String getDepara() {
        return depara;
    }


    /**
     * Sets the depara value for this PpCliente.
     * 
     * @param depara
     */
    public void setDepara(java.lang.String depara) {
        this.depara = depara;
    }


    /**
     * Gets the dtRevisao value for this PpCliente.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this PpCliente.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this PpCliente.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this PpCliente.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwEstpros value for this PpCliente.
     * 
     * @return dwEstpros
     */
    public idw.idwws.DwEstpro[] getDwEstpros() {
        return dwEstpros;
    }


    /**
     * Sets the dwEstpros value for this PpCliente.
     * 
     * @param dwEstpros
     */
    public void setDwEstpros(idw.idwws.DwEstpro[] dwEstpros) {
        this.dwEstpros = dwEstpros;
    }

    public idw.idwws.DwEstpro getDwEstpros(int i) {
        return this.dwEstpros[i];
    }

    public void setDwEstpros(int i, idw.idwws.DwEstpro _value) {
        this.dwEstpros[i] = _value;
    }


    /**
     * Gets the endereco value for this PpCliente.
     * 
     * @return endereco
     */
    public java.lang.String getEndereco() {
        return endereco;
    }


    /**
     * Sets the endereco value for this PpCliente.
     * 
     * @param endereco
     */
    public void setEndereco(java.lang.String endereco) {
        this.endereco = endereco;
    }


    /**
     * Gets the estado value for this PpCliente.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this PpCliente.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the hrLeadtime value for this PpCliente.
     * 
     * @return hrLeadtime
     */
    public java.math.BigDecimal getHrLeadtime() {
        return hrLeadtime;
    }


    /**
     * Sets the hrLeadtime value for this PpCliente.
     * 
     * @param hrLeadtime
     */
    public void setHrLeadtime(java.math.BigDecimal hrLeadtime) {
        this.hrLeadtime = hrLeadtime;
    }


    /**
     * Gets the idCliente value for this PpCliente.
     * 
     * @return idCliente
     */
    public java.lang.Long getIdCliente() {
        return idCliente;
    }


    /**
     * Sets the idCliente value for this PpCliente.
     * 
     * @param idCliente
     */
    public void setIdCliente(java.lang.Long idCliente) {
        this.idCliente = idCliente;
    }


    /**
     * Gets the nmCliente value for this PpCliente.
     * 
     * @return nmCliente
     */
    public java.lang.String getNmCliente() {
        return nmCliente;
    }


    /**
     * Sets the nmCliente value for this PpCliente.
     * 
     * @param nmCliente
     */
    public void setNmCliente(java.lang.String nmCliente) {
        this.nmCliente = nmCliente;
    }


    /**
     * Gets the omClidiarios value for this PpCliente.
     * 
     * @return omClidiarios
     */
    public idw.idwws.OmClidiario[] getOmClidiarios() {
        return omClidiarios;
    }


    /**
     * Sets the omClidiarios value for this PpCliente.
     * 
     * @param omClidiarios
     */
    public void setOmClidiarios(idw.idwws.OmClidiario[] omClidiarios) {
        this.omClidiarios = omClidiarios;
    }

    public idw.idwws.OmClidiario getOmClidiarios(int i) {
        return this.omClidiarios[i];
    }

    public void setOmClidiarios(int i, idw.idwws.OmClidiario _value) {
        this.omClidiarios[i] = _value;
    }


    /**
     * Gets the omContatos value for this PpCliente.
     * 
     * @return omContatos
     */
    public idw.idwws.OmContato[] getOmContatos() {
        return omContatos;
    }


    /**
     * Sets the omContatos value for this PpCliente.
     * 
     * @param omContatos
     */
    public void setOmContatos(idw.idwws.OmContato[] omContatos) {
        this.omContatos = omContatos;
    }

    public idw.idwws.OmContato getOmContatos(int i) {
        return this.omContatos[i];
    }

    public void setOmContatos(int i, idw.idwws.OmContato _value) {
        this.omContatos[i] = _value;
    }


    /**
     * Gets the omProdutos value for this PpCliente.
     * 
     * @return omProdutos
     */
    public idw.idwws.OmProduto[] getOmProdutos() {
        return omProdutos;
    }


    /**
     * Sets the omProdutos value for this PpCliente.
     * 
     * @param omProdutos
     */
    public void setOmProdutos(idw.idwws.OmProduto[] omProdutos) {
        this.omProdutos = omProdutos;
    }

    public idw.idwws.OmProduto getOmProdutos(int i) {
        return this.omProdutos[i];
    }

    public void setOmProdutos(int i, idw.idwws.OmProduto _value) {
        this.omProdutos[i] = _value;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this PpCliente.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this PpCliente.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this PpCliente.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this PpCliente.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the pais value for this PpCliente.
     * 
     * @return pais
     */
    public java.lang.String getPais() {
        return pais;
    }


    /**
     * Sets the pais value for this PpCliente.
     * 
     * @param pais
     */
    public void setPais(java.lang.String pais) {
        this.pais = pais;
    }


    /**
     * Gets the ppCps value for this PpCliente.
     * 
     * @return ppCps
     */
    public idw.idwws.PpCp[] getPpCps() {
        return ppCps;
    }


    /**
     * Sets the ppCps value for this PpCliente.
     * 
     * @param ppCps
     */
    public void setPpCps(idw.idwws.PpCp[] ppCps) {
        this.ppCps = ppCps;
    }

    public idw.idwws.PpCp getPpCps(int i) {
        return this.ppCps[i];
    }

    public void setPpCps(int i, idw.idwws.PpCp _value) {
        this.ppCps[i] = _value;
    }


    /**
     * Gets the ppNecs value for this PpCliente.
     * 
     * @return ppNecs
     */
    public idw.idwws.PpNec[] getPpNecs() {
        return ppNecs;
    }


    /**
     * Sets the ppNecs value for this PpCliente.
     * 
     * @param ppNecs
     */
    public void setPpNecs(idw.idwws.PpNec[] ppNecs) {
        this.ppNecs = ppNecs;
    }

    public idw.idwws.PpNec getPpNecs(int i) {
        return this.ppNecs[i];
    }

    public void setPpNecs(int i, idw.idwws.PpNec _value) {
        this.ppNecs[i] = _value;
    }


    /**
     * Gets the revisao value for this PpCliente.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this PpCliente.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this PpCliente.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this PpCliente.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the telefonedois value for this PpCliente.
     * 
     * @return telefonedois
     */
    public java.lang.String getTelefonedois() {
        return telefonedois;
    }


    /**
     * Sets the telefonedois value for this PpCliente.
     * 
     * @param telefonedois
     */
    public void setTelefonedois(java.lang.String telefonedois) {
        this.telefonedois = telefonedois;
    }


    /**
     * Gets the telefonetres value for this PpCliente.
     * 
     * @return telefonetres
     */
    public java.lang.String getTelefonetres() {
        return telefonetres;
    }


    /**
     * Sets the telefonetres value for this PpCliente.
     * 
     * @param telefonetres
     */
    public void setTelefonetres(java.lang.String telefonetres) {
        this.telefonetres = telefonetres;
    }


    /**
     * Gets the telefoneum value for this PpCliente.
     * 
     * @return telefoneum
     */
    public java.lang.String getTelefoneum() {
        return telefoneum;
    }


    /**
     * Sets the telefoneum value for this PpCliente.
     * 
     * @param telefoneum
     */
    public void setTelefoneum(java.lang.String telefoneum) {
        this.telefoneum = telefoneum;
    }


    /**
     * Gets the tpCliente value for this PpCliente.
     * 
     * @return tpCliente
     */
    public java.lang.Integer getTpCliente() {
        return tpCliente;
    }


    /**
     * Sets the tpCliente value for this PpCliente.
     * 
     * @param tpCliente
     */
    public void setTpCliente(java.lang.Integer tpCliente) {
        this.tpCliente = tpCliente;
    }


    /**
     * Gets the urlSite value for this PpCliente.
     * 
     * @return urlSite
     */
    public java.lang.String getUrlSite() {
        return urlSite;
    }


    /**
     * Sets the urlSite value for this PpCliente.
     * 
     * @param urlSite
     */
    public void setUrlSite(java.lang.String urlSite) {
        this.urlSite = urlSite;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpCliente)) return false;
        PpCliente other = (PpCliente) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdCliente==null && other.getCdCliente()==null) || 
             (this.cdCliente!=null &&
              this.cdCliente.equals(other.getCdCliente()))) &&
            ((this.cidade==null && other.getCidade()==null) || 
             (this.cidade!=null &&
              this.cidade.equals(other.getCidade()))) &&
            ((this.cnpjCpf==null && other.getCnpjCpf()==null) || 
             (this.cnpjCpf!=null &&
              this.cnpjCpf.equals(other.getCnpjCpf()))) &&
            ((this.contato==null && other.getContato()==null) || 
             (this.contato!=null &&
              this.contato.equals(other.getContato()))) &&
            ((this.depara==null && other.getDepara()==null) || 
             (this.depara!=null &&
              this.depara.equals(other.getDepara()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dwEstpros==null && other.getDwEstpros()==null) || 
             (this.dwEstpros!=null &&
              java.util.Arrays.equals(this.dwEstpros, other.getDwEstpros()))) &&
            ((this.endereco==null && other.getEndereco()==null) || 
             (this.endereco!=null &&
              this.endereco.equals(other.getEndereco()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.hrLeadtime==null && other.getHrLeadtime()==null) || 
             (this.hrLeadtime!=null &&
              this.hrLeadtime.equals(other.getHrLeadtime()))) &&
            ((this.idCliente==null && other.getIdCliente()==null) || 
             (this.idCliente!=null &&
              this.idCliente.equals(other.getIdCliente()))) &&
            ((this.nmCliente==null && other.getNmCliente()==null) || 
             (this.nmCliente!=null &&
              this.nmCliente.equals(other.getNmCliente()))) &&
            ((this.omClidiarios==null && other.getOmClidiarios()==null) || 
             (this.omClidiarios!=null &&
              java.util.Arrays.equals(this.omClidiarios, other.getOmClidiarios()))) &&
            ((this.omContatos==null && other.getOmContatos()==null) || 
             (this.omContatos!=null &&
              java.util.Arrays.equals(this.omContatos, other.getOmContatos()))) &&
            ((this.omProdutos==null && other.getOmProdutos()==null) || 
             (this.omProdutos!=null &&
              java.util.Arrays.equals(this.omProdutos, other.getOmProdutos()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.pais==null && other.getPais()==null) || 
             (this.pais!=null &&
              this.pais.equals(other.getPais()))) &&
            ((this.ppCps==null && other.getPpCps()==null) || 
             (this.ppCps!=null &&
              java.util.Arrays.equals(this.ppCps, other.getPpCps()))) &&
            ((this.ppNecs==null && other.getPpNecs()==null) || 
             (this.ppNecs!=null &&
              java.util.Arrays.equals(this.ppNecs, other.getPpNecs()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.telefonedois==null && other.getTelefonedois()==null) || 
             (this.telefonedois!=null &&
              this.telefonedois.equals(other.getTelefonedois()))) &&
            ((this.telefonetres==null && other.getTelefonetres()==null) || 
             (this.telefonetres!=null &&
              this.telefonetres.equals(other.getTelefonetres()))) &&
            ((this.telefoneum==null && other.getTelefoneum()==null) || 
             (this.telefoneum!=null &&
              this.telefoneum.equals(other.getTelefoneum()))) &&
            ((this.tpCliente==null && other.getTpCliente()==null) || 
             (this.tpCliente!=null &&
              this.tpCliente.equals(other.getTpCliente()))) &&
            ((this.urlSite==null && other.getUrlSite()==null) || 
             (this.urlSite!=null &&
              this.urlSite.equals(other.getUrlSite())));
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
        if (getCdCliente() != null) {
            _hashCode += getCdCliente().hashCode();
        }
        if (getCidade() != null) {
            _hashCode += getCidade().hashCode();
        }
        if (getCnpjCpf() != null) {
            _hashCode += getCnpjCpf().hashCode();
        }
        if (getContato() != null) {
            _hashCode += getContato().hashCode();
        }
        if (getDepara() != null) {
            _hashCode += getDepara().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDwEstpros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwEstpros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwEstpros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEndereco() != null) {
            _hashCode += getEndereco().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getHrLeadtime() != null) {
            _hashCode += getHrLeadtime().hashCode();
        }
        if (getIdCliente() != null) {
            _hashCode += getIdCliente().hashCode();
        }
        if (getNmCliente() != null) {
            _hashCode += getNmCliente().hashCode();
        }
        if (getOmClidiarios() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmClidiarios());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmClidiarios(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmContatos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmContatos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmContatos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmProdutos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmProdutos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmProdutos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
        }
        if (getPais() != null) {
            _hashCode += getPais().hashCode();
        }
        if (getPpCps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpCps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpCps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpNecs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpNecs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpNecs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        if (getTelefonedois() != null) {
            _hashCode += getTelefonedois().hashCode();
        }
        if (getTelefonetres() != null) {
            _hashCode += getTelefonetres().hashCode();
        }
        if (getTelefoneum() != null) {
            _hashCode += getTelefoneum().hashCode();
        }
        if (getTpCliente() != null) {
            _hashCode += getTpCliente().hashCode();
        }
        if (getUrlSite() != null) {
            _hashCode += getUrlSite().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpCliente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCliente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cnpjCpf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cnpjCpf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depara");
        elemField.setXmlName(new javax.xml.namespace.QName("", "depara"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtRevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtRevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtStativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtStativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstpros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstpros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endereco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endereco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hrLeadtime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hrLeadtime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nmCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nmCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omClidiarios");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omClidiarios"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omClidiario"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omContatos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omContatos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omContato"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProdutos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProdutos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pais");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pais"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppNecs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppNecs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAtivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefonedois");
        elemField.setXmlName(new javax.xml.namespace.QName("", "telefonedois"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefonetres");
        elemField.setXmlName(new javax.xml.namespace.QName("", "telefonetres"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefoneum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "telefoneum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlSite");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlSite"));
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
