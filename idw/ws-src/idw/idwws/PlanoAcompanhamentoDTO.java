/**
 * PlanoAcompanhamentoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PlanoAcompanhamentoDTO  implements java.io.Serializable {
    private java.lang.Integer anoReferencia;

    private java.lang.String cnt;

    private int corFrente;

    private int corFundo;

    private java.lang.String descricao;

    private java.lang.Integer diaReferencia;

    private idw.idwws.DadosDiaPlanProdDTO[] dias;

    private java.lang.Long disponivelProduzir;

    private java.lang.Double faltaSobra;

    private int idPasso;

    private java.lang.Long idRota;

    private java.lang.Long kitTotal;

    private idw.idwws.PpNec[] listaPpnec;

    private java.lang.Integer mesReferencia;

    private java.math.BigDecimal passo;

    private java.lang.String placa;

    private idw.idwws.PlanoDTO planoDTO;

    private idw.idwws.PpCp ppcp;

    private java.lang.Double producaoTotal;

    private java.lang.Long produzidoMes;

    private java.lang.Integer qtdeProducaoSimulacao;

    private java.math.BigDecimal saldoAnterior;

    private java.lang.Integer saldoRealEstoque;

    private java.lang.String semiProduto;

    private java.lang.Double somaPlanejada;

    private boolean ultimoPasso;

    private java.lang.Long aProduzirCpsAtuais;

    public PlanoAcompanhamentoDTO() {
    }

    public PlanoAcompanhamentoDTO(
           java.lang.Integer anoReferencia,
           java.lang.String cnt,
           int corFrente,
           int corFundo,
           java.lang.String descricao,
           java.lang.Integer diaReferencia,
           idw.idwws.DadosDiaPlanProdDTO[] dias,
           java.lang.Long disponivelProduzir,
           java.lang.Double faltaSobra,
           int idPasso,
           java.lang.Long idRota,
           java.lang.Long kitTotal,
           idw.idwws.PpNec[] listaPpnec,
           java.lang.Integer mesReferencia,
           java.math.BigDecimal passo,
           java.lang.String placa,
           idw.idwws.PlanoDTO planoDTO,
           idw.idwws.PpCp ppcp,
           java.lang.Double producaoTotal,
           java.lang.Long produzidoMes,
           java.lang.Integer qtdeProducaoSimulacao,
           java.math.BigDecimal saldoAnterior,
           java.lang.Integer saldoRealEstoque,
           java.lang.String semiProduto,
           java.lang.Double somaPlanejada,
           boolean ultimoPasso,
           java.lang.Long aProduzirCpsAtuais) {
           this.anoReferencia = anoReferencia;
           this.cnt = cnt;
           this.corFrente = corFrente;
           this.corFundo = corFundo;
           this.descricao = descricao;
           this.diaReferencia = diaReferencia;
           this.dias = dias;
           this.disponivelProduzir = disponivelProduzir;
           this.faltaSobra = faltaSobra;
           this.idPasso = idPasso;
           this.idRota = idRota;
           this.kitTotal = kitTotal;
           this.listaPpnec = listaPpnec;
           this.mesReferencia = mesReferencia;
           this.passo = passo;
           this.placa = placa;
           this.planoDTO = planoDTO;
           this.ppcp = ppcp;
           this.producaoTotal = producaoTotal;
           this.produzidoMes = produzidoMes;
           this.qtdeProducaoSimulacao = qtdeProducaoSimulacao;
           this.saldoAnterior = saldoAnterior;
           this.saldoRealEstoque = saldoRealEstoque;
           this.semiProduto = semiProduto;
           this.somaPlanejada = somaPlanejada;
           this.ultimoPasso = ultimoPasso;
           this.aProduzirCpsAtuais = aProduzirCpsAtuais;
    }


    /**
     * Gets the anoReferencia value for this PlanoAcompanhamentoDTO.
     * 
     * @return anoReferencia
     */
    public java.lang.Integer getAnoReferencia() {
        return anoReferencia;
    }


    /**
     * Sets the anoReferencia value for this PlanoAcompanhamentoDTO.
     * 
     * @param anoReferencia
     */
    public void setAnoReferencia(java.lang.Integer anoReferencia) {
        this.anoReferencia = anoReferencia;
    }


    /**
     * Gets the cnt value for this PlanoAcompanhamentoDTO.
     * 
     * @return cnt
     */
    public java.lang.String getCnt() {
        return cnt;
    }


    /**
     * Sets the cnt value for this PlanoAcompanhamentoDTO.
     * 
     * @param cnt
     */
    public void setCnt(java.lang.String cnt) {
        this.cnt = cnt;
    }


    /**
     * Gets the corFrente value for this PlanoAcompanhamentoDTO.
     * 
     * @return corFrente
     */
    public int getCorFrente() {
        return corFrente;
    }


    /**
     * Sets the corFrente value for this PlanoAcompanhamentoDTO.
     * 
     * @param corFrente
     */
    public void setCorFrente(int corFrente) {
        this.corFrente = corFrente;
    }


    /**
     * Gets the corFundo value for this PlanoAcompanhamentoDTO.
     * 
     * @return corFundo
     */
    public int getCorFundo() {
        return corFundo;
    }


    /**
     * Sets the corFundo value for this PlanoAcompanhamentoDTO.
     * 
     * @param corFundo
     */
    public void setCorFundo(int corFundo) {
        this.corFundo = corFundo;
    }


    /**
     * Gets the descricao value for this PlanoAcompanhamentoDTO.
     * 
     * @return descricao
     */
    public java.lang.String getDescricao() {
        return descricao;
    }


    /**
     * Sets the descricao value for this PlanoAcompanhamentoDTO.
     * 
     * @param descricao
     */
    public void setDescricao(java.lang.String descricao) {
        this.descricao = descricao;
    }


    /**
     * Gets the diaReferencia value for this PlanoAcompanhamentoDTO.
     * 
     * @return diaReferencia
     */
    public java.lang.Integer getDiaReferencia() {
        return diaReferencia;
    }


    /**
     * Sets the diaReferencia value for this PlanoAcompanhamentoDTO.
     * 
     * @param diaReferencia
     */
    public void setDiaReferencia(java.lang.Integer diaReferencia) {
        this.diaReferencia = diaReferencia;
    }


    /**
     * Gets the dias value for this PlanoAcompanhamentoDTO.
     * 
     * @return dias
     */
    public idw.idwws.DadosDiaPlanProdDTO[] getDias() {
        return dias;
    }


    /**
     * Sets the dias value for this PlanoAcompanhamentoDTO.
     * 
     * @param dias
     */
    public void setDias(idw.idwws.DadosDiaPlanProdDTO[] dias) {
        this.dias = dias;
    }

    public idw.idwws.DadosDiaPlanProdDTO getDias(int i) {
        return this.dias[i];
    }

    public void setDias(int i, idw.idwws.DadosDiaPlanProdDTO _value) {
        this.dias[i] = _value;
    }


    /**
     * Gets the disponivelProduzir value for this PlanoAcompanhamentoDTO.
     * 
     * @return disponivelProduzir
     */
    public java.lang.Long getDisponivelProduzir() {
        return disponivelProduzir;
    }


    /**
     * Sets the disponivelProduzir value for this PlanoAcompanhamentoDTO.
     * 
     * @param disponivelProduzir
     */
    public void setDisponivelProduzir(java.lang.Long disponivelProduzir) {
        this.disponivelProduzir = disponivelProduzir;
    }


    /**
     * Gets the faltaSobra value for this PlanoAcompanhamentoDTO.
     * 
     * @return faltaSobra
     */
    public java.lang.Double getFaltaSobra() {
        return faltaSobra;
    }


    /**
     * Sets the faltaSobra value for this PlanoAcompanhamentoDTO.
     * 
     * @param faltaSobra
     */
    public void setFaltaSobra(java.lang.Double faltaSobra) {
        this.faltaSobra = faltaSobra;
    }


    /**
     * Gets the idPasso value for this PlanoAcompanhamentoDTO.
     * 
     * @return idPasso
     */
    public int getIdPasso() {
        return idPasso;
    }


    /**
     * Sets the idPasso value for this PlanoAcompanhamentoDTO.
     * 
     * @param idPasso
     */
    public void setIdPasso(int idPasso) {
        this.idPasso = idPasso;
    }


    /**
     * Gets the idRota value for this PlanoAcompanhamentoDTO.
     * 
     * @return idRota
     */
    public java.lang.Long getIdRota() {
        return idRota;
    }


    /**
     * Sets the idRota value for this PlanoAcompanhamentoDTO.
     * 
     * @param idRota
     */
    public void setIdRota(java.lang.Long idRota) {
        this.idRota = idRota;
    }


    /**
     * Gets the kitTotal value for this PlanoAcompanhamentoDTO.
     * 
     * @return kitTotal
     */
    public java.lang.Long getKitTotal() {
        return kitTotal;
    }


    /**
     * Sets the kitTotal value for this PlanoAcompanhamentoDTO.
     * 
     * @param kitTotal
     */
    public void setKitTotal(java.lang.Long kitTotal) {
        this.kitTotal = kitTotal;
    }


    /**
     * Gets the listaPpnec value for this PlanoAcompanhamentoDTO.
     * 
     * @return listaPpnec
     */
    public idw.idwws.PpNec[] getListaPpnec() {
        return listaPpnec;
    }


    /**
     * Sets the listaPpnec value for this PlanoAcompanhamentoDTO.
     * 
     * @param listaPpnec
     */
    public void setListaPpnec(idw.idwws.PpNec[] listaPpnec) {
        this.listaPpnec = listaPpnec;
    }

    public idw.idwws.PpNec getListaPpnec(int i) {
        return this.listaPpnec[i];
    }

    public void setListaPpnec(int i, idw.idwws.PpNec _value) {
        this.listaPpnec[i] = _value;
    }


    /**
     * Gets the mesReferencia value for this PlanoAcompanhamentoDTO.
     * 
     * @return mesReferencia
     */
    public java.lang.Integer getMesReferencia() {
        return mesReferencia;
    }


    /**
     * Sets the mesReferencia value for this PlanoAcompanhamentoDTO.
     * 
     * @param mesReferencia
     */
    public void setMesReferencia(java.lang.Integer mesReferencia) {
        this.mesReferencia = mesReferencia;
    }


    /**
     * Gets the passo value for this PlanoAcompanhamentoDTO.
     * 
     * @return passo
     */
    public java.math.BigDecimal getPasso() {
        return passo;
    }


    /**
     * Sets the passo value for this PlanoAcompanhamentoDTO.
     * 
     * @param passo
     */
    public void setPasso(java.math.BigDecimal passo) {
        this.passo = passo;
    }


    /**
     * Gets the placa value for this PlanoAcompanhamentoDTO.
     * 
     * @return placa
     */
    public java.lang.String getPlaca() {
        return placa;
    }


    /**
     * Sets the placa value for this PlanoAcompanhamentoDTO.
     * 
     * @param placa
     */
    public void setPlaca(java.lang.String placa) {
        this.placa = placa;
    }


    /**
     * Gets the planoDTO value for this PlanoAcompanhamentoDTO.
     * 
     * @return planoDTO
     */
    public idw.idwws.PlanoDTO getPlanoDTO() {
        return planoDTO;
    }


    /**
     * Sets the planoDTO value for this PlanoAcompanhamentoDTO.
     * 
     * @param planoDTO
     */
    public void setPlanoDTO(idw.idwws.PlanoDTO planoDTO) {
        this.planoDTO = planoDTO;
    }


    /**
     * Gets the ppcp value for this PlanoAcompanhamentoDTO.
     * 
     * @return ppcp
     */
    public idw.idwws.PpCp getPpcp() {
        return ppcp;
    }


    /**
     * Sets the ppcp value for this PlanoAcompanhamentoDTO.
     * 
     * @param ppcp
     */
    public void setPpcp(idw.idwws.PpCp ppcp) {
        this.ppcp = ppcp;
    }


    /**
     * Gets the producaoTotal value for this PlanoAcompanhamentoDTO.
     * 
     * @return producaoTotal
     */
    public java.lang.Double getProducaoTotal() {
        return producaoTotal;
    }


    /**
     * Sets the producaoTotal value for this PlanoAcompanhamentoDTO.
     * 
     * @param producaoTotal
     */
    public void setProducaoTotal(java.lang.Double producaoTotal) {
        this.producaoTotal = producaoTotal;
    }


    /**
     * Gets the produzidoMes value for this PlanoAcompanhamentoDTO.
     * 
     * @return produzidoMes
     */
    public java.lang.Long getProduzidoMes() {
        return produzidoMes;
    }


    /**
     * Sets the produzidoMes value for this PlanoAcompanhamentoDTO.
     * 
     * @param produzidoMes
     */
    public void setProduzidoMes(java.lang.Long produzidoMes) {
        this.produzidoMes = produzidoMes;
    }


    /**
     * Gets the qtdeProducaoSimulacao value for this PlanoAcompanhamentoDTO.
     * 
     * @return qtdeProducaoSimulacao
     */
    public java.lang.Integer getQtdeProducaoSimulacao() {
        return qtdeProducaoSimulacao;
    }


    /**
     * Sets the qtdeProducaoSimulacao value for this PlanoAcompanhamentoDTO.
     * 
     * @param qtdeProducaoSimulacao
     */
    public void setQtdeProducaoSimulacao(java.lang.Integer qtdeProducaoSimulacao) {
        this.qtdeProducaoSimulacao = qtdeProducaoSimulacao;
    }


    /**
     * Gets the saldoAnterior value for this PlanoAcompanhamentoDTO.
     * 
     * @return saldoAnterior
     */
    public java.math.BigDecimal getSaldoAnterior() {
        return saldoAnterior;
    }


    /**
     * Sets the saldoAnterior value for this PlanoAcompanhamentoDTO.
     * 
     * @param saldoAnterior
     */
    public void setSaldoAnterior(java.math.BigDecimal saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }


    /**
     * Gets the saldoRealEstoque value for this PlanoAcompanhamentoDTO.
     * 
     * @return saldoRealEstoque
     */
    public java.lang.Integer getSaldoRealEstoque() {
        return saldoRealEstoque;
    }


    /**
     * Sets the saldoRealEstoque value for this PlanoAcompanhamentoDTO.
     * 
     * @param saldoRealEstoque
     */
    public void setSaldoRealEstoque(java.lang.Integer saldoRealEstoque) {
        this.saldoRealEstoque = saldoRealEstoque;
    }


    /**
     * Gets the semiProduto value for this PlanoAcompanhamentoDTO.
     * 
     * @return semiProduto
     */
    public java.lang.String getSemiProduto() {
        return semiProduto;
    }


    /**
     * Sets the semiProduto value for this PlanoAcompanhamentoDTO.
     * 
     * @param semiProduto
     */
    public void setSemiProduto(java.lang.String semiProduto) {
        this.semiProduto = semiProduto;
    }


    /**
     * Gets the somaPlanejada value for this PlanoAcompanhamentoDTO.
     * 
     * @return somaPlanejada
     */
    public java.lang.Double getSomaPlanejada() {
        return somaPlanejada;
    }


    /**
     * Sets the somaPlanejada value for this PlanoAcompanhamentoDTO.
     * 
     * @param somaPlanejada
     */
    public void setSomaPlanejada(java.lang.Double somaPlanejada) {
        this.somaPlanejada = somaPlanejada;
    }


    /**
     * Gets the ultimoPasso value for this PlanoAcompanhamentoDTO.
     * 
     * @return ultimoPasso
     */
    public boolean isUltimoPasso() {
        return ultimoPasso;
    }


    /**
     * Sets the ultimoPasso value for this PlanoAcompanhamentoDTO.
     * 
     * @param ultimoPasso
     */
    public void setUltimoPasso(boolean ultimoPasso) {
        this.ultimoPasso = ultimoPasso;
    }


    /**
     * Gets the aProduzirCpsAtuais value for this PlanoAcompanhamentoDTO.
     * 
     * @return aProduzirCpsAtuais
     */
    public java.lang.Long getAProduzirCpsAtuais() {
        return aProduzirCpsAtuais;
    }


    /**
     * Sets the aProduzirCpsAtuais value for this PlanoAcompanhamentoDTO.
     * 
     * @param aProduzirCpsAtuais
     */
    public void setAProduzirCpsAtuais(java.lang.Long aProduzirCpsAtuais) {
        this.aProduzirCpsAtuais = aProduzirCpsAtuais;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PlanoAcompanhamentoDTO)) return false;
        PlanoAcompanhamentoDTO other = (PlanoAcompanhamentoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.anoReferencia==null && other.getAnoReferencia()==null) || 
             (this.anoReferencia!=null &&
              this.anoReferencia.equals(other.getAnoReferencia()))) &&
            ((this.cnt==null && other.getCnt()==null) || 
             (this.cnt!=null &&
              this.cnt.equals(other.getCnt()))) &&
            this.corFrente == other.getCorFrente() &&
            this.corFundo == other.getCorFundo() &&
            ((this.descricao==null && other.getDescricao()==null) || 
             (this.descricao!=null &&
              this.descricao.equals(other.getDescricao()))) &&
            ((this.diaReferencia==null && other.getDiaReferencia()==null) || 
             (this.diaReferencia!=null &&
              this.diaReferencia.equals(other.getDiaReferencia()))) &&
            ((this.dias==null && other.getDias()==null) || 
             (this.dias!=null &&
              java.util.Arrays.equals(this.dias, other.getDias()))) &&
            ((this.disponivelProduzir==null && other.getDisponivelProduzir()==null) || 
             (this.disponivelProduzir!=null &&
              this.disponivelProduzir.equals(other.getDisponivelProduzir()))) &&
            ((this.faltaSobra==null && other.getFaltaSobra()==null) || 
             (this.faltaSobra!=null &&
              this.faltaSobra.equals(other.getFaltaSobra()))) &&
            this.idPasso == other.getIdPasso() &&
            ((this.idRota==null && other.getIdRota()==null) || 
             (this.idRota!=null &&
              this.idRota.equals(other.getIdRota()))) &&
            ((this.kitTotal==null && other.getKitTotal()==null) || 
             (this.kitTotal!=null &&
              this.kitTotal.equals(other.getKitTotal()))) &&
            ((this.listaPpnec==null && other.getListaPpnec()==null) || 
             (this.listaPpnec!=null &&
              java.util.Arrays.equals(this.listaPpnec, other.getListaPpnec()))) &&
            ((this.mesReferencia==null && other.getMesReferencia()==null) || 
             (this.mesReferencia!=null &&
              this.mesReferencia.equals(other.getMesReferencia()))) &&
            ((this.passo==null && other.getPasso()==null) || 
             (this.passo!=null &&
              this.passo.equals(other.getPasso()))) &&
            ((this.placa==null && other.getPlaca()==null) || 
             (this.placa!=null &&
              this.placa.equals(other.getPlaca()))) &&
            ((this.planoDTO==null && other.getPlanoDTO()==null) || 
             (this.planoDTO!=null &&
              this.planoDTO.equals(other.getPlanoDTO()))) &&
            ((this.ppcp==null && other.getPpcp()==null) || 
             (this.ppcp!=null &&
              this.ppcp.equals(other.getPpcp()))) &&
            ((this.producaoTotal==null && other.getProducaoTotal()==null) || 
             (this.producaoTotal!=null &&
              this.producaoTotal.equals(other.getProducaoTotal()))) &&
            ((this.produzidoMes==null && other.getProduzidoMes()==null) || 
             (this.produzidoMes!=null &&
              this.produzidoMes.equals(other.getProduzidoMes()))) &&
            ((this.qtdeProducaoSimulacao==null && other.getQtdeProducaoSimulacao()==null) || 
             (this.qtdeProducaoSimulacao!=null &&
              this.qtdeProducaoSimulacao.equals(other.getQtdeProducaoSimulacao()))) &&
            ((this.saldoAnterior==null && other.getSaldoAnterior()==null) || 
             (this.saldoAnterior!=null &&
              this.saldoAnterior.equals(other.getSaldoAnterior()))) &&
            ((this.saldoRealEstoque==null && other.getSaldoRealEstoque()==null) || 
             (this.saldoRealEstoque!=null &&
              this.saldoRealEstoque.equals(other.getSaldoRealEstoque()))) &&
            ((this.semiProduto==null && other.getSemiProduto()==null) || 
             (this.semiProduto!=null &&
              this.semiProduto.equals(other.getSemiProduto()))) &&
            ((this.somaPlanejada==null && other.getSomaPlanejada()==null) || 
             (this.somaPlanejada!=null &&
              this.somaPlanejada.equals(other.getSomaPlanejada()))) &&
            this.ultimoPasso == other.isUltimoPasso() &&
            ((this.aProduzirCpsAtuais==null && other.getAProduzirCpsAtuais()==null) || 
             (this.aProduzirCpsAtuais!=null &&
              this.aProduzirCpsAtuais.equals(other.getAProduzirCpsAtuais())));
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
        if (getAnoReferencia() != null) {
            _hashCode += getAnoReferencia().hashCode();
        }
        if (getCnt() != null) {
            _hashCode += getCnt().hashCode();
        }
        _hashCode += getCorFrente();
        _hashCode += getCorFundo();
        if (getDescricao() != null) {
            _hashCode += getDescricao().hashCode();
        }
        if (getDiaReferencia() != null) {
            _hashCode += getDiaReferencia().hashCode();
        }
        if (getDias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDias(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDisponivelProduzir() != null) {
            _hashCode += getDisponivelProduzir().hashCode();
        }
        if (getFaltaSobra() != null) {
            _hashCode += getFaltaSobra().hashCode();
        }
        _hashCode += getIdPasso();
        if (getIdRota() != null) {
            _hashCode += getIdRota().hashCode();
        }
        if (getKitTotal() != null) {
            _hashCode += getKitTotal().hashCode();
        }
        if (getListaPpnec() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaPpnec());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaPpnec(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMesReferencia() != null) {
            _hashCode += getMesReferencia().hashCode();
        }
        if (getPasso() != null) {
            _hashCode += getPasso().hashCode();
        }
        if (getPlaca() != null) {
            _hashCode += getPlaca().hashCode();
        }
        if (getPlanoDTO() != null) {
            _hashCode += getPlanoDTO().hashCode();
        }
        if (getPpcp() != null) {
            _hashCode += getPpcp().hashCode();
        }
        if (getProducaoTotal() != null) {
            _hashCode += getProducaoTotal().hashCode();
        }
        if (getProduzidoMes() != null) {
            _hashCode += getProduzidoMes().hashCode();
        }
        if (getQtdeProducaoSimulacao() != null) {
            _hashCode += getQtdeProducaoSimulacao().hashCode();
        }
        if (getSaldoAnterior() != null) {
            _hashCode += getSaldoAnterior().hashCode();
        }
        if (getSaldoRealEstoque() != null) {
            _hashCode += getSaldoRealEstoque().hashCode();
        }
        if (getSemiProduto() != null) {
            _hashCode += getSemiProduto().hashCode();
        }
        if (getSomaPlanejada() != null) {
            _hashCode += getSomaPlanejada().hashCode();
        }
        _hashCode += (isUltimoPasso() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getAProduzirCpsAtuais() != null) {
            _hashCode += getAProduzirCpsAtuais().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PlanoAcompanhamentoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "planoAcompanhamentoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anoReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "anoReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cnt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corFrente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corFrente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corFundo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corFundo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descricao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descricao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diaReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "diaReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dias");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dadosDiaPlanProdDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("disponivelProduzir");
        elemField.setXmlName(new javax.xml.namespace.QName("", "disponivelProduzir"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("faltaSobra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "faltaSobra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPasso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPasso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idRota");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idRota"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kitTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "kitTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaPpnec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaPpnec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mesReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mesReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("passo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "passo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("placa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "placa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("planoDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "planoDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "planoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppcp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppcp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produzidoMes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produzidoMes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdeProducaoSimulacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdeProducaoSimulacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saldoAnterior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "saldoAnterior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saldoRealEstoque");
        elemField.setXmlName(new javax.xml.namespace.QName("", "saldoRealEstoque"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("semiProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "semiProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("somaPlanejada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "somaPlanejada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ultimoPasso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ultimoPasso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AProduzirCpsAtuais");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aProduzirCpsAtuais"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
