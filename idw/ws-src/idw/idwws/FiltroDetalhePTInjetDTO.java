/**
 * FiltroDetalhePTInjetDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FiltroDetalhePTInjetDTO  implements java.io.Serializable {
    private java.lang.Integer anoFinal;

    private java.lang.Integer anoInicial;

    private java.lang.String cdCp;

    private java.lang.String cdtparada;

    private java.lang.String cdtrefugo;

    private java.lang.String dstparada;

    private java.lang.String dstrefugo;

    private java.util.Calendar dtReferencia;

    private java.util.Calendar dtReferenciaFinal;

    private java.util.Calendar dtReferenciaInicial;

    private java.util.Calendar dthrFhora;

    private java.util.Calendar dthrIhora;

    private idw.idwws.DwRap dwRap;

    private idw.idwws.DwTParada dwTParada;

    private idw.idwws.DwTurno dwTurno;

    private java.lang.Long idCp;

    private long idDwConsolId;

    private java.lang.Long idtparada;

    private java.lang.Long idtrefugo;

    private idw.idwws.IndicadorMinMetaMaxDTO[] indicadoresMinMetaMaxDTO;

    private java.lang.Boolean isClonar;

    private java.lang.Integer mesFinal;

    private java.lang.Integer mesInicial;

    private idw.idwws.OmGt omGt;

    private idw.idwws.OmProduto omProduto;

    private idw.idwws.OmPt omPt;

    private idw.idwws.PpCp ppCp;

    private java.lang.Byte tipoPareto;

    private java.lang.Byte tpId;

    public FiltroDetalhePTInjetDTO() {
    }

    public FiltroDetalhePTInjetDTO(
           java.lang.Integer anoFinal,
           java.lang.Integer anoInicial,
           java.lang.String cdCp,
           java.lang.String cdtparada,
           java.lang.String cdtrefugo,
           java.lang.String dstparada,
           java.lang.String dstrefugo,
           java.util.Calendar dtReferencia,
           java.util.Calendar dtReferenciaFinal,
           java.util.Calendar dtReferenciaInicial,
           java.util.Calendar dthrFhora,
           java.util.Calendar dthrIhora,
           idw.idwws.DwRap dwRap,
           idw.idwws.DwTParada dwTParada,
           idw.idwws.DwTurno dwTurno,
           java.lang.Long idCp,
           long idDwConsolId,
           java.lang.Long idtparada,
           java.lang.Long idtrefugo,
           idw.idwws.IndicadorMinMetaMaxDTO[] indicadoresMinMetaMaxDTO,
           java.lang.Boolean isClonar,
           java.lang.Integer mesFinal,
           java.lang.Integer mesInicial,
           idw.idwws.OmGt omGt,
           idw.idwws.OmProduto omProduto,
           idw.idwws.OmPt omPt,
           idw.idwws.PpCp ppCp,
           java.lang.Byte tipoPareto,
           java.lang.Byte tpId) {
           this.anoFinal = anoFinal;
           this.anoInicial = anoInicial;
           this.cdCp = cdCp;
           this.cdtparada = cdtparada;
           this.cdtrefugo = cdtrefugo;
           this.dstparada = dstparada;
           this.dstrefugo = dstrefugo;
           this.dtReferencia = dtReferencia;
           this.dtReferenciaFinal = dtReferenciaFinal;
           this.dtReferenciaInicial = dtReferenciaInicial;
           this.dthrFhora = dthrFhora;
           this.dthrIhora = dthrIhora;
           this.dwRap = dwRap;
           this.dwTParada = dwTParada;
           this.dwTurno = dwTurno;
           this.idCp = idCp;
           this.idDwConsolId = idDwConsolId;
           this.idtparada = idtparada;
           this.idtrefugo = idtrefugo;
           this.indicadoresMinMetaMaxDTO = indicadoresMinMetaMaxDTO;
           this.isClonar = isClonar;
           this.mesFinal = mesFinal;
           this.mesInicial = mesInicial;
           this.omGt = omGt;
           this.omProduto = omProduto;
           this.omPt = omPt;
           this.ppCp = ppCp;
           this.tipoPareto = tipoPareto;
           this.tpId = tpId;
    }


    /**
     * Gets the anoFinal value for this FiltroDetalhePTInjetDTO.
     * 
     * @return anoFinal
     */
    public java.lang.Integer getAnoFinal() {
        return anoFinal;
    }


    /**
     * Sets the anoFinal value for this FiltroDetalhePTInjetDTO.
     * 
     * @param anoFinal
     */
    public void setAnoFinal(java.lang.Integer anoFinal) {
        this.anoFinal = anoFinal;
    }


    /**
     * Gets the anoInicial value for this FiltroDetalhePTInjetDTO.
     * 
     * @return anoInicial
     */
    public java.lang.Integer getAnoInicial() {
        return anoInicial;
    }


    /**
     * Sets the anoInicial value for this FiltroDetalhePTInjetDTO.
     * 
     * @param anoInicial
     */
    public void setAnoInicial(java.lang.Integer anoInicial) {
        this.anoInicial = anoInicial;
    }


    /**
     * Gets the cdCp value for this FiltroDetalhePTInjetDTO.
     * 
     * @return cdCp
     */
    public java.lang.String getCdCp() {
        return cdCp;
    }


    /**
     * Sets the cdCp value for this FiltroDetalhePTInjetDTO.
     * 
     * @param cdCp
     */
    public void setCdCp(java.lang.String cdCp) {
        this.cdCp = cdCp;
    }


    /**
     * Gets the cdtparada value for this FiltroDetalhePTInjetDTO.
     * 
     * @return cdtparada
     */
    public java.lang.String getCdtparada() {
        return cdtparada;
    }


    /**
     * Sets the cdtparada value for this FiltroDetalhePTInjetDTO.
     * 
     * @param cdtparada
     */
    public void setCdtparada(java.lang.String cdtparada) {
        this.cdtparada = cdtparada;
    }


    /**
     * Gets the cdtrefugo value for this FiltroDetalhePTInjetDTO.
     * 
     * @return cdtrefugo
     */
    public java.lang.String getCdtrefugo() {
        return cdtrefugo;
    }


    /**
     * Sets the cdtrefugo value for this FiltroDetalhePTInjetDTO.
     * 
     * @param cdtrefugo
     */
    public void setCdtrefugo(java.lang.String cdtrefugo) {
        this.cdtrefugo = cdtrefugo;
    }


    /**
     * Gets the dstparada value for this FiltroDetalhePTInjetDTO.
     * 
     * @return dstparada
     */
    public java.lang.String getDstparada() {
        return dstparada;
    }


    /**
     * Sets the dstparada value for this FiltroDetalhePTInjetDTO.
     * 
     * @param dstparada
     */
    public void setDstparada(java.lang.String dstparada) {
        this.dstparada = dstparada;
    }


    /**
     * Gets the dstrefugo value for this FiltroDetalhePTInjetDTO.
     * 
     * @return dstrefugo
     */
    public java.lang.String getDstrefugo() {
        return dstrefugo;
    }


    /**
     * Sets the dstrefugo value for this FiltroDetalhePTInjetDTO.
     * 
     * @param dstrefugo
     */
    public void setDstrefugo(java.lang.String dstrefugo) {
        this.dstrefugo = dstrefugo;
    }


    /**
     * Gets the dtReferencia value for this FiltroDetalhePTInjetDTO.
     * 
     * @return dtReferencia
     */
    public java.util.Calendar getDtReferencia() {
        return dtReferencia;
    }


    /**
     * Sets the dtReferencia value for this FiltroDetalhePTInjetDTO.
     * 
     * @param dtReferencia
     */
    public void setDtReferencia(java.util.Calendar dtReferencia) {
        this.dtReferencia = dtReferencia;
    }


    /**
     * Gets the dtReferenciaFinal value for this FiltroDetalhePTInjetDTO.
     * 
     * @return dtReferenciaFinal
     */
    public java.util.Calendar getDtReferenciaFinal() {
        return dtReferenciaFinal;
    }


    /**
     * Sets the dtReferenciaFinal value for this FiltroDetalhePTInjetDTO.
     * 
     * @param dtReferenciaFinal
     */
    public void setDtReferenciaFinal(java.util.Calendar dtReferenciaFinal) {
        this.dtReferenciaFinal = dtReferenciaFinal;
    }


    /**
     * Gets the dtReferenciaInicial value for this FiltroDetalhePTInjetDTO.
     * 
     * @return dtReferenciaInicial
     */
    public java.util.Calendar getDtReferenciaInicial() {
        return dtReferenciaInicial;
    }


    /**
     * Sets the dtReferenciaInicial value for this FiltroDetalhePTInjetDTO.
     * 
     * @param dtReferenciaInicial
     */
    public void setDtReferenciaInicial(java.util.Calendar dtReferenciaInicial) {
        this.dtReferenciaInicial = dtReferenciaInicial;
    }


    /**
     * Gets the dthrFhora value for this FiltroDetalhePTInjetDTO.
     * 
     * @return dthrFhora
     */
    public java.util.Calendar getDthrFhora() {
        return dthrFhora;
    }


    /**
     * Sets the dthrFhora value for this FiltroDetalhePTInjetDTO.
     * 
     * @param dthrFhora
     */
    public void setDthrFhora(java.util.Calendar dthrFhora) {
        this.dthrFhora = dthrFhora;
    }


    /**
     * Gets the dthrIhora value for this FiltroDetalhePTInjetDTO.
     * 
     * @return dthrIhora
     */
    public java.util.Calendar getDthrIhora() {
        return dthrIhora;
    }


    /**
     * Sets the dthrIhora value for this FiltroDetalhePTInjetDTO.
     * 
     * @param dthrIhora
     */
    public void setDthrIhora(java.util.Calendar dthrIhora) {
        this.dthrIhora = dthrIhora;
    }


    /**
     * Gets the dwRap value for this FiltroDetalhePTInjetDTO.
     * 
     * @return dwRap
     */
    public idw.idwws.DwRap getDwRap() {
        return dwRap;
    }


    /**
     * Sets the dwRap value for this FiltroDetalhePTInjetDTO.
     * 
     * @param dwRap
     */
    public void setDwRap(idw.idwws.DwRap dwRap) {
        this.dwRap = dwRap;
    }


    /**
     * Gets the dwTParada value for this FiltroDetalhePTInjetDTO.
     * 
     * @return dwTParada
     */
    public idw.idwws.DwTParada getDwTParada() {
        return dwTParada;
    }


    /**
     * Sets the dwTParada value for this FiltroDetalhePTInjetDTO.
     * 
     * @param dwTParada
     */
    public void setDwTParada(idw.idwws.DwTParada dwTParada) {
        this.dwTParada = dwTParada;
    }


    /**
     * Gets the dwTurno value for this FiltroDetalhePTInjetDTO.
     * 
     * @return dwTurno
     */
    public idw.idwws.DwTurno getDwTurno() {
        return dwTurno;
    }


    /**
     * Sets the dwTurno value for this FiltroDetalhePTInjetDTO.
     * 
     * @param dwTurno
     */
    public void setDwTurno(idw.idwws.DwTurno dwTurno) {
        this.dwTurno = dwTurno;
    }


    /**
     * Gets the idCp value for this FiltroDetalhePTInjetDTO.
     * 
     * @return idCp
     */
    public java.lang.Long getIdCp() {
        return idCp;
    }


    /**
     * Sets the idCp value for this FiltroDetalhePTInjetDTO.
     * 
     * @param idCp
     */
    public void setIdCp(java.lang.Long idCp) {
        this.idCp = idCp;
    }


    /**
     * Gets the idDwConsolId value for this FiltroDetalhePTInjetDTO.
     * 
     * @return idDwConsolId
     */
    public long getIdDwConsolId() {
        return idDwConsolId;
    }


    /**
     * Sets the idDwConsolId value for this FiltroDetalhePTInjetDTO.
     * 
     * @param idDwConsolId
     */
    public void setIdDwConsolId(long idDwConsolId) {
        this.idDwConsolId = idDwConsolId;
    }


    /**
     * Gets the idtparada value for this FiltroDetalhePTInjetDTO.
     * 
     * @return idtparada
     */
    public java.lang.Long getIdtparada() {
        return idtparada;
    }


    /**
     * Sets the idtparada value for this FiltroDetalhePTInjetDTO.
     * 
     * @param idtparada
     */
    public void setIdtparada(java.lang.Long idtparada) {
        this.idtparada = idtparada;
    }


    /**
     * Gets the idtrefugo value for this FiltroDetalhePTInjetDTO.
     * 
     * @return idtrefugo
     */
    public java.lang.Long getIdtrefugo() {
        return idtrefugo;
    }


    /**
     * Sets the idtrefugo value for this FiltroDetalhePTInjetDTO.
     * 
     * @param idtrefugo
     */
    public void setIdtrefugo(java.lang.Long idtrefugo) {
        this.idtrefugo = idtrefugo;
    }


    /**
     * Gets the indicadoresMinMetaMaxDTO value for this FiltroDetalhePTInjetDTO.
     * 
     * @return indicadoresMinMetaMaxDTO
     */
    public idw.idwws.IndicadorMinMetaMaxDTO[] getIndicadoresMinMetaMaxDTO() {
        return indicadoresMinMetaMaxDTO;
    }


    /**
     * Sets the indicadoresMinMetaMaxDTO value for this FiltroDetalhePTInjetDTO.
     * 
     * @param indicadoresMinMetaMaxDTO
     */
    public void setIndicadoresMinMetaMaxDTO(idw.idwws.IndicadorMinMetaMaxDTO[] indicadoresMinMetaMaxDTO) {
        this.indicadoresMinMetaMaxDTO = indicadoresMinMetaMaxDTO;
    }


    /**
     * Gets the isClonar value for this FiltroDetalhePTInjetDTO.
     * 
     * @return isClonar
     */
    public java.lang.Boolean getIsClonar() {
        return isClonar;
    }


    /**
     * Sets the isClonar value for this FiltroDetalhePTInjetDTO.
     * 
     * @param isClonar
     */
    public void setIsClonar(java.lang.Boolean isClonar) {
        this.isClonar = isClonar;
    }


    /**
     * Gets the mesFinal value for this FiltroDetalhePTInjetDTO.
     * 
     * @return mesFinal
     */
    public java.lang.Integer getMesFinal() {
        return mesFinal;
    }


    /**
     * Sets the mesFinal value for this FiltroDetalhePTInjetDTO.
     * 
     * @param mesFinal
     */
    public void setMesFinal(java.lang.Integer mesFinal) {
        this.mesFinal = mesFinal;
    }


    /**
     * Gets the mesInicial value for this FiltroDetalhePTInjetDTO.
     * 
     * @return mesInicial
     */
    public java.lang.Integer getMesInicial() {
        return mesInicial;
    }


    /**
     * Sets the mesInicial value for this FiltroDetalhePTInjetDTO.
     * 
     * @param mesInicial
     */
    public void setMesInicial(java.lang.Integer mesInicial) {
        this.mesInicial = mesInicial;
    }


    /**
     * Gets the omGt value for this FiltroDetalhePTInjetDTO.
     * 
     * @return omGt
     */
    public idw.idwws.OmGt getOmGt() {
        return omGt;
    }


    /**
     * Sets the omGt value for this FiltroDetalhePTInjetDTO.
     * 
     * @param omGt
     */
    public void setOmGt(idw.idwws.OmGt omGt) {
        this.omGt = omGt;
    }


    /**
     * Gets the omProduto value for this FiltroDetalhePTInjetDTO.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this FiltroDetalhePTInjetDTO.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the omPt value for this FiltroDetalhePTInjetDTO.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this FiltroDetalhePTInjetDTO.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the ppCp value for this FiltroDetalhePTInjetDTO.
     * 
     * @return ppCp
     */
    public idw.idwws.PpCp getPpCp() {
        return ppCp;
    }


    /**
     * Sets the ppCp value for this FiltroDetalhePTInjetDTO.
     * 
     * @param ppCp
     */
    public void setPpCp(idw.idwws.PpCp ppCp) {
        this.ppCp = ppCp;
    }


    /**
     * Gets the tipoPareto value for this FiltroDetalhePTInjetDTO.
     * 
     * @return tipoPareto
     */
    public java.lang.Byte getTipoPareto() {
        return tipoPareto;
    }


    /**
     * Sets the tipoPareto value for this FiltroDetalhePTInjetDTO.
     * 
     * @param tipoPareto
     */
    public void setTipoPareto(java.lang.Byte tipoPareto) {
        this.tipoPareto = tipoPareto;
    }


    /**
     * Gets the tpId value for this FiltroDetalhePTInjetDTO.
     * 
     * @return tpId
     */
    public java.lang.Byte getTpId() {
        return tpId;
    }


    /**
     * Sets the tpId value for this FiltroDetalhePTInjetDTO.
     * 
     * @param tpId
     */
    public void setTpId(java.lang.Byte tpId) {
        this.tpId = tpId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FiltroDetalhePTInjetDTO)) return false;
        FiltroDetalhePTInjetDTO other = (FiltroDetalhePTInjetDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.anoFinal==null && other.getAnoFinal()==null) || 
             (this.anoFinal!=null &&
              this.anoFinal.equals(other.getAnoFinal()))) &&
            ((this.anoInicial==null && other.getAnoInicial()==null) || 
             (this.anoInicial!=null &&
              this.anoInicial.equals(other.getAnoInicial()))) &&
            ((this.cdCp==null && other.getCdCp()==null) || 
             (this.cdCp!=null &&
              this.cdCp.equals(other.getCdCp()))) &&
            ((this.cdtparada==null && other.getCdtparada()==null) || 
             (this.cdtparada!=null &&
              this.cdtparada.equals(other.getCdtparada()))) &&
            ((this.cdtrefugo==null && other.getCdtrefugo()==null) || 
             (this.cdtrefugo!=null &&
              this.cdtrefugo.equals(other.getCdtrefugo()))) &&
            ((this.dstparada==null && other.getDstparada()==null) || 
             (this.dstparada!=null &&
              this.dstparada.equals(other.getDstparada()))) &&
            ((this.dstrefugo==null && other.getDstrefugo()==null) || 
             (this.dstrefugo!=null &&
              this.dstrefugo.equals(other.getDstrefugo()))) &&
            ((this.dtReferencia==null && other.getDtReferencia()==null) || 
             (this.dtReferencia!=null &&
              this.dtReferencia.equals(other.getDtReferencia()))) &&
            ((this.dtReferenciaFinal==null && other.getDtReferenciaFinal()==null) || 
             (this.dtReferenciaFinal!=null &&
              this.dtReferenciaFinal.equals(other.getDtReferenciaFinal()))) &&
            ((this.dtReferenciaInicial==null && other.getDtReferenciaInicial()==null) || 
             (this.dtReferenciaInicial!=null &&
              this.dtReferenciaInicial.equals(other.getDtReferenciaInicial()))) &&
            ((this.dthrFhora==null && other.getDthrFhora()==null) || 
             (this.dthrFhora!=null &&
              this.dthrFhora.equals(other.getDthrFhora()))) &&
            ((this.dthrIhora==null && other.getDthrIhora()==null) || 
             (this.dthrIhora!=null &&
              this.dthrIhora.equals(other.getDthrIhora()))) &&
            ((this.dwRap==null && other.getDwRap()==null) || 
             (this.dwRap!=null &&
              this.dwRap.equals(other.getDwRap()))) &&
            ((this.dwTParada==null && other.getDwTParada()==null) || 
             (this.dwTParada!=null &&
              this.dwTParada.equals(other.getDwTParada()))) &&
            ((this.dwTurno==null && other.getDwTurno()==null) || 
             (this.dwTurno!=null &&
              this.dwTurno.equals(other.getDwTurno()))) &&
            ((this.idCp==null && other.getIdCp()==null) || 
             (this.idCp!=null &&
              this.idCp.equals(other.getIdCp()))) &&
            this.idDwConsolId == other.getIdDwConsolId() &&
            ((this.idtparada==null && other.getIdtparada()==null) || 
             (this.idtparada!=null &&
              this.idtparada.equals(other.getIdtparada()))) &&
            ((this.idtrefugo==null && other.getIdtrefugo()==null) || 
             (this.idtrefugo!=null &&
              this.idtrefugo.equals(other.getIdtrefugo()))) &&
            ((this.indicadoresMinMetaMaxDTO==null && other.getIndicadoresMinMetaMaxDTO()==null) || 
             (this.indicadoresMinMetaMaxDTO!=null &&
              java.util.Arrays.equals(this.indicadoresMinMetaMaxDTO, other.getIndicadoresMinMetaMaxDTO()))) &&
            ((this.isClonar==null && other.getIsClonar()==null) || 
             (this.isClonar!=null &&
              this.isClonar.equals(other.getIsClonar()))) &&
            ((this.mesFinal==null && other.getMesFinal()==null) || 
             (this.mesFinal!=null &&
              this.mesFinal.equals(other.getMesFinal()))) &&
            ((this.mesInicial==null && other.getMesInicial()==null) || 
             (this.mesInicial!=null &&
              this.mesInicial.equals(other.getMesInicial()))) &&
            ((this.omGt==null && other.getOmGt()==null) || 
             (this.omGt!=null &&
              this.omGt.equals(other.getOmGt()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.ppCp==null && other.getPpCp()==null) || 
             (this.ppCp!=null &&
              this.ppCp.equals(other.getPpCp()))) &&
            ((this.tipoPareto==null && other.getTipoPareto()==null) || 
             (this.tipoPareto!=null &&
              this.tipoPareto.equals(other.getTipoPareto()))) &&
            ((this.tpId==null && other.getTpId()==null) || 
             (this.tpId!=null &&
              this.tpId.equals(other.getTpId())));
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
        if (getAnoFinal() != null) {
            _hashCode += getAnoFinal().hashCode();
        }
        if (getAnoInicial() != null) {
            _hashCode += getAnoInicial().hashCode();
        }
        if (getCdCp() != null) {
            _hashCode += getCdCp().hashCode();
        }
        if (getCdtparada() != null) {
            _hashCode += getCdtparada().hashCode();
        }
        if (getCdtrefugo() != null) {
            _hashCode += getCdtrefugo().hashCode();
        }
        if (getDstparada() != null) {
            _hashCode += getDstparada().hashCode();
        }
        if (getDstrefugo() != null) {
            _hashCode += getDstrefugo().hashCode();
        }
        if (getDtReferencia() != null) {
            _hashCode += getDtReferencia().hashCode();
        }
        if (getDtReferenciaFinal() != null) {
            _hashCode += getDtReferenciaFinal().hashCode();
        }
        if (getDtReferenciaInicial() != null) {
            _hashCode += getDtReferenciaInicial().hashCode();
        }
        if (getDthrFhora() != null) {
            _hashCode += getDthrFhora().hashCode();
        }
        if (getDthrIhora() != null) {
            _hashCode += getDthrIhora().hashCode();
        }
        if (getDwRap() != null) {
            _hashCode += getDwRap().hashCode();
        }
        if (getDwTParada() != null) {
            _hashCode += getDwTParada().hashCode();
        }
        if (getDwTurno() != null) {
            _hashCode += getDwTurno().hashCode();
        }
        if (getIdCp() != null) {
            _hashCode += getIdCp().hashCode();
        }
        _hashCode += new Long(getIdDwConsolId()).hashCode();
        if (getIdtparada() != null) {
            _hashCode += getIdtparada().hashCode();
        }
        if (getIdtrefugo() != null) {
            _hashCode += getIdtrefugo().hashCode();
        }
        if (getIndicadoresMinMetaMaxDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIndicadoresMinMetaMaxDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIndicadoresMinMetaMaxDTO(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIsClonar() != null) {
            _hashCode += getIsClonar().hashCode();
        }
        if (getMesFinal() != null) {
            _hashCode += getMesFinal().hashCode();
        }
        if (getMesInicial() != null) {
            _hashCode += getMesInicial().hashCode();
        }
        if (getOmGt() != null) {
            _hashCode += getOmGt().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getPpCp() != null) {
            _hashCode += getPpCp().hashCode();
        }
        if (getTipoPareto() != null) {
            _hashCode += getTipoPareto().hashCode();
        }
        if (getTpId() != null) {
            _hashCode += getTpId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FiltroDetalhePTInjetDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "filtroDetalhePTInjetDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anoFinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "anoFinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anoInicial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "anoInicial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtrefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtrefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dstparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dstparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dstrefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dstrefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtReferenciaFinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtReferenciaFinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtReferenciaInicial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtReferenciaInicial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFhora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFhora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIhora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIhora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTParada"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTurno"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idDwConsolId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idDwConsolId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idtparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idtparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idtrefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idtrefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicadoresMinMetaMaxDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indicadoresMinMetaMaxDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "indicadorMinMetaMaxDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "listaIndicadorMinMetaMexDTOs"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isClonar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isClonar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mesFinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mesFinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mesInicial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mesInicial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoPareto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoPareto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
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
