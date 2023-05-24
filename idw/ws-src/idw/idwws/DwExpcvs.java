/**
 * DwExpcvs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwExpcvs  extends idw.idwws.DwExpcvsTemplate  implements java.io.Serializable {
    private java.lang.String cdExpcvs;

    private java.lang.String complemento;

    private java.math.BigDecimal correntemaxima;

    private java.math.BigDecimal correnteminima;

    private java.lang.String dsExpcvs;

    private java.util.Calendar dthrFentrada;

    private java.util.Calendar dthrFreprocesso;

    private java.util.Calendar dthrIentrada;

    private java.util.Calendar dthrIreprocesso;

    private idw.idwws.DwExpcvspf[] dwExpcvspfs;

    private idw.idwws.DwFtEtapa dwFtEtapa;

    private idw.idwws.DwTAcao dwTAcao;

    private idw.idwws.DwTDefeito dwTDefeitoByIdTdefeito;

    private idw.idwws.DwTDefeito dwTDefeitoByIdTdefeitoreprocesso;

    private long idExpcvs;

    private java.lang.Boolean isApenascomfalha;

    private java.lang.Boolean isApenascomfalhareprocesso;

    private java.lang.Boolean isApenassucessoreprocesso;

    private java.lang.String nseriefinal;

    private java.lang.String nserieincial;

    private idw.idwws.OmProduto omProduto;

    private idw.idwws.OmPt omPt;

    private idw.idwws.OmUsr omUsrByIdUsroperador;

    private idw.idwws.OmUsr omUsrByIdUsrsupervisor;

    private java.math.BigDecimal qtLinhasporarquivo;

    private java.math.BigDecimal qtTotallinhas;

    private java.lang.String sku;

    private java.math.BigDecimal stFluxoentrada;

    private java.math.BigDecimal stFluxosaida;

    private java.math.BigDecimal tensaomaxima;

    private java.math.BigDecimal tensaominima;

    private java.math.BigDecimal tpExportacao;

    public DwExpcvs() {
    }

    public DwExpcvs(
           java.lang.String cdExpcvs,
           java.lang.String complemento,
           java.math.BigDecimal correntemaxima,
           java.math.BigDecimal correnteminima,
           java.lang.String dsExpcvs,
           java.util.Calendar dthrFentrada,
           java.util.Calendar dthrFreprocesso,
           java.util.Calendar dthrIentrada,
           java.util.Calendar dthrIreprocesso,
           idw.idwws.DwExpcvspf[] dwExpcvspfs,
           idw.idwws.DwFtEtapa dwFtEtapa,
           idw.idwws.DwTAcao dwTAcao,
           idw.idwws.DwTDefeito dwTDefeitoByIdTdefeito,
           idw.idwws.DwTDefeito dwTDefeitoByIdTdefeitoreprocesso,
           long idExpcvs,
           java.lang.Boolean isApenascomfalha,
           java.lang.Boolean isApenascomfalhareprocesso,
           java.lang.Boolean isApenassucessoreprocesso,
           java.lang.String nseriefinal,
           java.lang.String nserieincial,
           idw.idwws.OmProduto omProduto,
           idw.idwws.OmPt omPt,
           idw.idwws.OmUsr omUsrByIdUsroperador,
           idw.idwws.OmUsr omUsrByIdUsrsupervisor,
           java.math.BigDecimal qtLinhasporarquivo,
           java.math.BigDecimal qtTotallinhas,
           java.lang.String sku,
           java.math.BigDecimal stFluxoentrada,
           java.math.BigDecimal stFluxosaida,
           java.math.BigDecimal tensaomaxima,
           java.math.BigDecimal tensaominima,
           java.math.BigDecimal tpExportacao) {
        this.cdExpcvs = cdExpcvs;
        this.complemento = complemento;
        this.correntemaxima = correntemaxima;
        this.correnteminima = correnteminima;
        this.dsExpcvs = dsExpcvs;
        this.dthrFentrada = dthrFentrada;
        this.dthrFreprocesso = dthrFreprocesso;
        this.dthrIentrada = dthrIentrada;
        this.dthrIreprocesso = dthrIreprocesso;
        this.dwExpcvspfs = dwExpcvspfs;
        this.dwFtEtapa = dwFtEtapa;
        this.dwTAcao = dwTAcao;
        this.dwTDefeitoByIdTdefeito = dwTDefeitoByIdTdefeito;
        this.dwTDefeitoByIdTdefeitoreprocesso = dwTDefeitoByIdTdefeitoreprocesso;
        this.idExpcvs = idExpcvs;
        this.isApenascomfalha = isApenascomfalha;
        this.isApenascomfalhareprocesso = isApenascomfalhareprocesso;
        this.isApenassucessoreprocesso = isApenassucessoreprocesso;
        this.nseriefinal = nseriefinal;
        this.nserieincial = nserieincial;
        this.omProduto = omProduto;
        this.omPt = omPt;
        this.omUsrByIdUsroperador = omUsrByIdUsroperador;
        this.omUsrByIdUsrsupervisor = omUsrByIdUsrsupervisor;
        this.qtLinhasporarquivo = qtLinhasporarquivo;
        this.qtTotallinhas = qtTotallinhas;
        this.sku = sku;
        this.stFluxoentrada = stFluxoentrada;
        this.stFluxosaida = stFluxosaida;
        this.tensaomaxima = tensaomaxima;
        this.tensaominima = tensaominima;
        this.tpExportacao = tpExportacao;
    }


    /**
     * Gets the cdExpcvs value for this DwExpcvs.
     * 
     * @return cdExpcvs
     */
    public java.lang.String getCdExpcvs() {
        return cdExpcvs;
    }


    /**
     * Sets the cdExpcvs value for this DwExpcvs.
     * 
     * @param cdExpcvs
     */
    public void setCdExpcvs(java.lang.String cdExpcvs) {
        this.cdExpcvs = cdExpcvs;
    }


    /**
     * Gets the complemento value for this DwExpcvs.
     * 
     * @return complemento
     */
    public java.lang.String getComplemento() {
        return complemento;
    }


    /**
     * Sets the complemento value for this DwExpcvs.
     * 
     * @param complemento
     */
    public void setComplemento(java.lang.String complemento) {
        this.complemento = complemento;
    }


    /**
     * Gets the correntemaxima value for this DwExpcvs.
     * 
     * @return correntemaxima
     */
    public java.math.BigDecimal getCorrentemaxima() {
        return correntemaxima;
    }


    /**
     * Sets the correntemaxima value for this DwExpcvs.
     * 
     * @param correntemaxima
     */
    public void setCorrentemaxima(java.math.BigDecimal correntemaxima) {
        this.correntemaxima = correntemaxima;
    }


    /**
     * Gets the correnteminima value for this DwExpcvs.
     * 
     * @return correnteminima
     */
    public java.math.BigDecimal getCorrenteminima() {
        return correnteminima;
    }


    /**
     * Sets the correnteminima value for this DwExpcvs.
     * 
     * @param correnteminima
     */
    public void setCorrenteminima(java.math.BigDecimal correnteminima) {
        this.correnteminima = correnteminima;
    }


    /**
     * Gets the dsExpcvs value for this DwExpcvs.
     * 
     * @return dsExpcvs
     */
    public java.lang.String getDsExpcvs() {
        return dsExpcvs;
    }


    /**
     * Sets the dsExpcvs value for this DwExpcvs.
     * 
     * @param dsExpcvs
     */
    public void setDsExpcvs(java.lang.String dsExpcvs) {
        this.dsExpcvs = dsExpcvs;
    }


    /**
     * Gets the dthrFentrada value for this DwExpcvs.
     * 
     * @return dthrFentrada
     */
    public java.util.Calendar getDthrFentrada() {
        return dthrFentrada;
    }


    /**
     * Sets the dthrFentrada value for this DwExpcvs.
     * 
     * @param dthrFentrada
     */
    public void setDthrFentrada(java.util.Calendar dthrFentrada) {
        this.dthrFentrada = dthrFentrada;
    }


    /**
     * Gets the dthrFreprocesso value for this DwExpcvs.
     * 
     * @return dthrFreprocesso
     */
    public java.util.Calendar getDthrFreprocesso() {
        return dthrFreprocesso;
    }


    /**
     * Sets the dthrFreprocesso value for this DwExpcvs.
     * 
     * @param dthrFreprocesso
     */
    public void setDthrFreprocesso(java.util.Calendar dthrFreprocesso) {
        this.dthrFreprocesso = dthrFreprocesso;
    }


    /**
     * Gets the dthrIentrada value for this DwExpcvs.
     * 
     * @return dthrIentrada
     */
    public java.util.Calendar getDthrIentrada() {
        return dthrIentrada;
    }


    /**
     * Sets the dthrIentrada value for this DwExpcvs.
     * 
     * @param dthrIentrada
     */
    public void setDthrIentrada(java.util.Calendar dthrIentrada) {
        this.dthrIentrada = dthrIentrada;
    }


    /**
     * Gets the dthrIreprocesso value for this DwExpcvs.
     * 
     * @return dthrIreprocesso
     */
    public java.util.Calendar getDthrIreprocesso() {
        return dthrIreprocesso;
    }


    /**
     * Sets the dthrIreprocesso value for this DwExpcvs.
     * 
     * @param dthrIreprocesso
     */
    public void setDthrIreprocesso(java.util.Calendar dthrIreprocesso) {
        this.dthrIreprocesso = dthrIreprocesso;
    }


    /**
     * Gets the dwExpcvspfs value for this DwExpcvs.
     * 
     * @return dwExpcvspfs
     */
    public idw.idwws.DwExpcvspf[] getDwExpcvspfs() {
        return dwExpcvspfs;
    }


    /**
     * Sets the dwExpcvspfs value for this DwExpcvs.
     * 
     * @param dwExpcvspfs
     */
    public void setDwExpcvspfs(idw.idwws.DwExpcvspf[] dwExpcvspfs) {
        this.dwExpcvspfs = dwExpcvspfs;
    }

    public idw.idwws.DwExpcvspf getDwExpcvspfs(int i) {
        return this.dwExpcvspfs[i];
    }

    public void setDwExpcvspfs(int i, idw.idwws.DwExpcvspf _value) {
        this.dwExpcvspfs[i] = _value;
    }


    /**
     * Gets the dwFtEtapa value for this DwExpcvs.
     * 
     * @return dwFtEtapa
     */
    public idw.idwws.DwFtEtapa getDwFtEtapa() {
        return dwFtEtapa;
    }


    /**
     * Sets the dwFtEtapa value for this DwExpcvs.
     * 
     * @param dwFtEtapa
     */
    public void setDwFtEtapa(idw.idwws.DwFtEtapa dwFtEtapa) {
        this.dwFtEtapa = dwFtEtapa;
    }


    /**
     * Gets the dwTAcao value for this DwExpcvs.
     * 
     * @return dwTAcao
     */
    public idw.idwws.DwTAcao getDwTAcao() {
        return dwTAcao;
    }


    /**
     * Sets the dwTAcao value for this DwExpcvs.
     * 
     * @param dwTAcao
     */
    public void setDwTAcao(idw.idwws.DwTAcao dwTAcao) {
        this.dwTAcao = dwTAcao;
    }


    /**
     * Gets the dwTDefeitoByIdTdefeito value for this DwExpcvs.
     * 
     * @return dwTDefeitoByIdTdefeito
     */
    public idw.idwws.DwTDefeito getDwTDefeitoByIdTdefeito() {
        return dwTDefeitoByIdTdefeito;
    }


    /**
     * Sets the dwTDefeitoByIdTdefeito value for this DwExpcvs.
     * 
     * @param dwTDefeitoByIdTdefeito
     */
    public void setDwTDefeitoByIdTdefeito(idw.idwws.DwTDefeito dwTDefeitoByIdTdefeito) {
        this.dwTDefeitoByIdTdefeito = dwTDefeitoByIdTdefeito;
    }


    /**
     * Gets the dwTDefeitoByIdTdefeitoreprocesso value for this DwExpcvs.
     * 
     * @return dwTDefeitoByIdTdefeitoreprocesso
     */
    public idw.idwws.DwTDefeito getDwTDefeitoByIdTdefeitoreprocesso() {
        return dwTDefeitoByIdTdefeitoreprocesso;
    }


    /**
     * Sets the dwTDefeitoByIdTdefeitoreprocesso value for this DwExpcvs.
     * 
     * @param dwTDefeitoByIdTdefeitoreprocesso
     */
    public void setDwTDefeitoByIdTdefeitoreprocesso(idw.idwws.DwTDefeito dwTDefeitoByIdTdefeitoreprocesso) {
        this.dwTDefeitoByIdTdefeitoreprocesso = dwTDefeitoByIdTdefeitoreprocesso;
    }


    /**
     * Gets the idExpcvs value for this DwExpcvs.
     * 
     * @return idExpcvs
     */
    public long getIdExpcvs() {
        return idExpcvs;
    }


    /**
     * Sets the idExpcvs value for this DwExpcvs.
     * 
     * @param idExpcvs
     */
    public void setIdExpcvs(long idExpcvs) {
        this.idExpcvs = idExpcvs;
    }


    /**
     * Gets the isApenascomfalha value for this DwExpcvs.
     * 
     * @return isApenascomfalha
     */
    public java.lang.Boolean getIsApenascomfalha() {
        return isApenascomfalha;
    }


    /**
     * Sets the isApenascomfalha value for this DwExpcvs.
     * 
     * @param isApenascomfalha
     */
    public void setIsApenascomfalha(java.lang.Boolean isApenascomfalha) {
        this.isApenascomfalha = isApenascomfalha;
    }


    /**
     * Gets the isApenascomfalhareprocesso value for this DwExpcvs.
     * 
     * @return isApenascomfalhareprocesso
     */
    public java.lang.Boolean getIsApenascomfalhareprocesso() {
        return isApenascomfalhareprocesso;
    }


    /**
     * Sets the isApenascomfalhareprocesso value for this DwExpcvs.
     * 
     * @param isApenascomfalhareprocesso
     */
    public void setIsApenascomfalhareprocesso(java.lang.Boolean isApenascomfalhareprocesso) {
        this.isApenascomfalhareprocesso = isApenascomfalhareprocesso;
    }


    /**
     * Gets the isApenassucessoreprocesso value for this DwExpcvs.
     * 
     * @return isApenassucessoreprocesso
     */
    public java.lang.Boolean getIsApenassucessoreprocesso() {
        return isApenassucessoreprocesso;
    }


    /**
     * Sets the isApenassucessoreprocesso value for this DwExpcvs.
     * 
     * @param isApenassucessoreprocesso
     */
    public void setIsApenassucessoreprocesso(java.lang.Boolean isApenassucessoreprocesso) {
        this.isApenassucessoreprocesso = isApenassucessoreprocesso;
    }


    /**
     * Gets the nseriefinal value for this DwExpcvs.
     * 
     * @return nseriefinal
     */
    public java.lang.String getNseriefinal() {
        return nseriefinal;
    }


    /**
     * Sets the nseriefinal value for this DwExpcvs.
     * 
     * @param nseriefinal
     */
    public void setNseriefinal(java.lang.String nseriefinal) {
        this.nseriefinal = nseriefinal;
    }


    /**
     * Gets the nserieincial value for this DwExpcvs.
     * 
     * @return nserieincial
     */
    public java.lang.String getNserieincial() {
        return nserieincial;
    }


    /**
     * Sets the nserieincial value for this DwExpcvs.
     * 
     * @param nserieincial
     */
    public void setNserieincial(java.lang.String nserieincial) {
        this.nserieincial = nserieincial;
    }


    /**
     * Gets the omProduto value for this DwExpcvs.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this DwExpcvs.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the omPt value for this DwExpcvs.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this DwExpcvs.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the omUsrByIdUsroperador value for this DwExpcvs.
     * 
     * @return omUsrByIdUsroperador
     */
    public idw.idwws.OmUsr getOmUsrByIdUsroperador() {
        return omUsrByIdUsroperador;
    }


    /**
     * Sets the omUsrByIdUsroperador value for this DwExpcvs.
     * 
     * @param omUsrByIdUsroperador
     */
    public void setOmUsrByIdUsroperador(idw.idwws.OmUsr omUsrByIdUsroperador) {
        this.omUsrByIdUsroperador = omUsrByIdUsroperador;
    }


    /**
     * Gets the omUsrByIdUsrsupervisor value for this DwExpcvs.
     * 
     * @return omUsrByIdUsrsupervisor
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrsupervisor() {
        return omUsrByIdUsrsupervisor;
    }


    /**
     * Sets the omUsrByIdUsrsupervisor value for this DwExpcvs.
     * 
     * @param omUsrByIdUsrsupervisor
     */
    public void setOmUsrByIdUsrsupervisor(idw.idwws.OmUsr omUsrByIdUsrsupervisor) {
        this.omUsrByIdUsrsupervisor = omUsrByIdUsrsupervisor;
    }


    /**
     * Gets the qtLinhasporarquivo value for this DwExpcvs.
     * 
     * @return qtLinhasporarquivo
     */
    public java.math.BigDecimal getQtLinhasporarquivo() {
        return qtLinhasporarquivo;
    }


    /**
     * Sets the qtLinhasporarquivo value for this DwExpcvs.
     * 
     * @param qtLinhasporarquivo
     */
    public void setQtLinhasporarquivo(java.math.BigDecimal qtLinhasporarquivo) {
        this.qtLinhasporarquivo = qtLinhasporarquivo;
    }


    /**
     * Gets the qtTotallinhas value for this DwExpcvs.
     * 
     * @return qtTotallinhas
     */
    public java.math.BigDecimal getQtTotallinhas() {
        return qtTotallinhas;
    }


    /**
     * Sets the qtTotallinhas value for this DwExpcvs.
     * 
     * @param qtTotallinhas
     */
    public void setQtTotallinhas(java.math.BigDecimal qtTotallinhas) {
        this.qtTotallinhas = qtTotallinhas;
    }


    /**
     * Gets the sku value for this DwExpcvs.
     * 
     * @return sku
     */
    public java.lang.String getSku() {
        return sku;
    }


    /**
     * Sets the sku value for this DwExpcvs.
     * 
     * @param sku
     */
    public void setSku(java.lang.String sku) {
        this.sku = sku;
    }


    /**
     * Gets the stFluxoentrada value for this DwExpcvs.
     * 
     * @return stFluxoentrada
     */
    public java.math.BigDecimal getStFluxoentrada() {
        return stFluxoentrada;
    }


    /**
     * Sets the stFluxoentrada value for this DwExpcvs.
     * 
     * @param stFluxoentrada
     */
    public void setStFluxoentrada(java.math.BigDecimal stFluxoentrada) {
        this.stFluxoentrada = stFluxoentrada;
    }


    /**
     * Gets the stFluxosaida value for this DwExpcvs.
     * 
     * @return stFluxosaida
     */
    public java.math.BigDecimal getStFluxosaida() {
        return stFluxosaida;
    }


    /**
     * Sets the stFluxosaida value for this DwExpcvs.
     * 
     * @param stFluxosaida
     */
    public void setStFluxosaida(java.math.BigDecimal stFluxosaida) {
        this.stFluxosaida = stFluxosaida;
    }


    /**
     * Gets the tensaomaxima value for this DwExpcvs.
     * 
     * @return tensaomaxima
     */
    public java.math.BigDecimal getTensaomaxima() {
        return tensaomaxima;
    }


    /**
     * Sets the tensaomaxima value for this DwExpcvs.
     * 
     * @param tensaomaxima
     */
    public void setTensaomaxima(java.math.BigDecimal tensaomaxima) {
        this.tensaomaxima = tensaomaxima;
    }


    /**
     * Gets the tensaominima value for this DwExpcvs.
     * 
     * @return tensaominima
     */
    public java.math.BigDecimal getTensaominima() {
        return tensaominima;
    }


    /**
     * Sets the tensaominima value for this DwExpcvs.
     * 
     * @param tensaominima
     */
    public void setTensaominima(java.math.BigDecimal tensaominima) {
        this.tensaominima = tensaominima;
    }


    /**
     * Gets the tpExportacao value for this DwExpcvs.
     * 
     * @return tpExportacao
     */
    public java.math.BigDecimal getTpExportacao() {
        return tpExportacao;
    }


    /**
     * Sets the tpExportacao value for this DwExpcvs.
     * 
     * @param tpExportacao
     */
    public void setTpExportacao(java.math.BigDecimal tpExportacao) {
        this.tpExportacao = tpExportacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwExpcvs)) return false;
        DwExpcvs other = (DwExpcvs) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdExpcvs==null && other.getCdExpcvs()==null) || 
             (this.cdExpcvs!=null &&
              this.cdExpcvs.equals(other.getCdExpcvs()))) &&
            ((this.complemento==null && other.getComplemento()==null) || 
             (this.complemento!=null &&
              this.complemento.equals(other.getComplemento()))) &&
            ((this.correntemaxima==null && other.getCorrentemaxima()==null) || 
             (this.correntemaxima!=null &&
              this.correntemaxima.equals(other.getCorrentemaxima()))) &&
            ((this.correnteminima==null && other.getCorrenteminima()==null) || 
             (this.correnteminima!=null &&
              this.correnteminima.equals(other.getCorrenteminima()))) &&
            ((this.dsExpcvs==null && other.getDsExpcvs()==null) || 
             (this.dsExpcvs!=null &&
              this.dsExpcvs.equals(other.getDsExpcvs()))) &&
            ((this.dthrFentrada==null && other.getDthrFentrada()==null) || 
             (this.dthrFentrada!=null &&
              this.dthrFentrada.equals(other.getDthrFentrada()))) &&
            ((this.dthrFreprocesso==null && other.getDthrFreprocesso()==null) || 
             (this.dthrFreprocesso!=null &&
              this.dthrFreprocesso.equals(other.getDthrFreprocesso()))) &&
            ((this.dthrIentrada==null && other.getDthrIentrada()==null) || 
             (this.dthrIentrada!=null &&
              this.dthrIentrada.equals(other.getDthrIentrada()))) &&
            ((this.dthrIreprocesso==null && other.getDthrIreprocesso()==null) || 
             (this.dthrIreprocesso!=null &&
              this.dthrIreprocesso.equals(other.getDthrIreprocesso()))) &&
            ((this.dwExpcvspfs==null && other.getDwExpcvspfs()==null) || 
             (this.dwExpcvspfs!=null &&
              java.util.Arrays.equals(this.dwExpcvspfs, other.getDwExpcvspfs()))) &&
            ((this.dwFtEtapa==null && other.getDwFtEtapa()==null) || 
             (this.dwFtEtapa!=null &&
              this.dwFtEtapa.equals(other.getDwFtEtapa()))) &&
            ((this.dwTAcao==null && other.getDwTAcao()==null) || 
             (this.dwTAcao!=null &&
              this.dwTAcao.equals(other.getDwTAcao()))) &&
            ((this.dwTDefeitoByIdTdefeito==null && other.getDwTDefeitoByIdTdefeito()==null) || 
             (this.dwTDefeitoByIdTdefeito!=null &&
              this.dwTDefeitoByIdTdefeito.equals(other.getDwTDefeitoByIdTdefeito()))) &&
            ((this.dwTDefeitoByIdTdefeitoreprocesso==null && other.getDwTDefeitoByIdTdefeitoreprocesso()==null) || 
             (this.dwTDefeitoByIdTdefeitoreprocesso!=null &&
              this.dwTDefeitoByIdTdefeitoreprocesso.equals(other.getDwTDefeitoByIdTdefeitoreprocesso()))) &&
            this.idExpcvs == other.getIdExpcvs() &&
            ((this.isApenascomfalha==null && other.getIsApenascomfalha()==null) || 
             (this.isApenascomfalha!=null &&
              this.isApenascomfalha.equals(other.getIsApenascomfalha()))) &&
            ((this.isApenascomfalhareprocesso==null && other.getIsApenascomfalhareprocesso()==null) || 
             (this.isApenascomfalhareprocesso!=null &&
              this.isApenascomfalhareprocesso.equals(other.getIsApenascomfalhareprocesso()))) &&
            ((this.isApenassucessoreprocesso==null && other.getIsApenassucessoreprocesso()==null) || 
             (this.isApenassucessoreprocesso!=null &&
              this.isApenassucessoreprocesso.equals(other.getIsApenassucessoreprocesso()))) &&
            ((this.nseriefinal==null && other.getNseriefinal()==null) || 
             (this.nseriefinal!=null &&
              this.nseriefinal.equals(other.getNseriefinal()))) &&
            ((this.nserieincial==null && other.getNserieincial()==null) || 
             (this.nserieincial!=null &&
              this.nserieincial.equals(other.getNserieincial()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.omUsrByIdUsroperador==null && other.getOmUsrByIdUsroperador()==null) || 
             (this.omUsrByIdUsroperador!=null &&
              this.omUsrByIdUsroperador.equals(other.getOmUsrByIdUsroperador()))) &&
            ((this.omUsrByIdUsrsupervisor==null && other.getOmUsrByIdUsrsupervisor()==null) || 
             (this.omUsrByIdUsrsupervisor!=null &&
              this.omUsrByIdUsrsupervisor.equals(other.getOmUsrByIdUsrsupervisor()))) &&
            ((this.qtLinhasporarquivo==null && other.getQtLinhasporarquivo()==null) || 
             (this.qtLinhasporarquivo!=null &&
              this.qtLinhasporarquivo.equals(other.getQtLinhasporarquivo()))) &&
            ((this.qtTotallinhas==null && other.getQtTotallinhas()==null) || 
             (this.qtTotallinhas!=null &&
              this.qtTotallinhas.equals(other.getQtTotallinhas()))) &&
            ((this.sku==null && other.getSku()==null) || 
             (this.sku!=null &&
              this.sku.equals(other.getSku()))) &&
            ((this.stFluxoentrada==null && other.getStFluxoentrada()==null) || 
             (this.stFluxoentrada!=null &&
              this.stFluxoentrada.equals(other.getStFluxoentrada()))) &&
            ((this.stFluxosaida==null && other.getStFluxosaida()==null) || 
             (this.stFluxosaida!=null &&
              this.stFluxosaida.equals(other.getStFluxosaida()))) &&
            ((this.tensaomaxima==null && other.getTensaomaxima()==null) || 
             (this.tensaomaxima!=null &&
              this.tensaomaxima.equals(other.getTensaomaxima()))) &&
            ((this.tensaominima==null && other.getTensaominima()==null) || 
             (this.tensaominima!=null &&
              this.tensaominima.equals(other.getTensaominima()))) &&
            ((this.tpExportacao==null && other.getTpExportacao()==null) || 
             (this.tpExportacao!=null &&
              this.tpExportacao.equals(other.getTpExportacao())));
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
        if (getCdExpcvs() != null) {
            _hashCode += getCdExpcvs().hashCode();
        }
        if (getComplemento() != null) {
            _hashCode += getComplemento().hashCode();
        }
        if (getCorrentemaxima() != null) {
            _hashCode += getCorrentemaxima().hashCode();
        }
        if (getCorrenteminima() != null) {
            _hashCode += getCorrenteminima().hashCode();
        }
        if (getDsExpcvs() != null) {
            _hashCode += getDsExpcvs().hashCode();
        }
        if (getDthrFentrada() != null) {
            _hashCode += getDthrFentrada().hashCode();
        }
        if (getDthrFreprocesso() != null) {
            _hashCode += getDthrFreprocesso().hashCode();
        }
        if (getDthrIentrada() != null) {
            _hashCode += getDthrIentrada().hashCode();
        }
        if (getDthrIreprocesso() != null) {
            _hashCode += getDthrIreprocesso().hashCode();
        }
        if (getDwExpcvspfs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwExpcvspfs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwExpcvspfs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwFtEtapa() != null) {
            _hashCode += getDwFtEtapa().hashCode();
        }
        if (getDwTAcao() != null) {
            _hashCode += getDwTAcao().hashCode();
        }
        if (getDwTDefeitoByIdTdefeito() != null) {
            _hashCode += getDwTDefeitoByIdTdefeito().hashCode();
        }
        if (getDwTDefeitoByIdTdefeitoreprocesso() != null) {
            _hashCode += getDwTDefeitoByIdTdefeitoreprocesso().hashCode();
        }
        _hashCode += new Long(getIdExpcvs()).hashCode();
        if (getIsApenascomfalha() != null) {
            _hashCode += getIsApenascomfalha().hashCode();
        }
        if (getIsApenascomfalhareprocesso() != null) {
            _hashCode += getIsApenascomfalhareprocesso().hashCode();
        }
        if (getIsApenassucessoreprocesso() != null) {
            _hashCode += getIsApenassucessoreprocesso().hashCode();
        }
        if (getNseriefinal() != null) {
            _hashCode += getNseriefinal().hashCode();
        }
        if (getNserieincial() != null) {
            _hashCode += getNserieincial().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getOmUsrByIdUsroperador() != null) {
            _hashCode += getOmUsrByIdUsroperador().hashCode();
        }
        if (getOmUsrByIdUsrsupervisor() != null) {
            _hashCode += getOmUsrByIdUsrsupervisor().hashCode();
        }
        if (getQtLinhasporarquivo() != null) {
            _hashCode += getQtLinhasporarquivo().hashCode();
        }
        if (getQtTotallinhas() != null) {
            _hashCode += getQtTotallinhas().hashCode();
        }
        if (getSku() != null) {
            _hashCode += getSku().hashCode();
        }
        if (getStFluxoentrada() != null) {
            _hashCode += getStFluxoentrada().hashCode();
        }
        if (getStFluxosaida() != null) {
            _hashCode += getStFluxosaida().hashCode();
        }
        if (getTensaomaxima() != null) {
            _hashCode += getTensaomaxima().hashCode();
        }
        if (getTensaominima() != null) {
            _hashCode += getTensaominima().hashCode();
        }
        if (getTpExportacao() != null) {
            _hashCode += getTpExportacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwExpcvs.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwExpcvs"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdExpcvs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdExpcvs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("complemento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "complemento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correntemaxima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "correntemaxima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correnteminima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "correnteminima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsExpcvs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsExpcvs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFentrada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFentrada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFreprocesso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFreprocesso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIentrada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIentrada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIreprocesso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIreprocesso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwExpcvspfs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwExpcvspfs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwExpcvspf"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtEtapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtEtapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtEtapa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTAcao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTAcao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTAcao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTDefeitoByIdTdefeito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTDefeitoByIdTdefeito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTDefeito"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTDefeitoByIdTdefeitoreprocesso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTDefeitoByIdTdefeitoreprocesso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTDefeito"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idExpcvs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idExpcvs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isApenascomfalha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isApenascomfalha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isApenascomfalhareprocesso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isApenascomfalhareprocesso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isApenassucessoreprocesso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isApenassucessoreprocesso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nseriefinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nseriefinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nserieincial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nserieincial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("omUsrByIdUsroperador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsroperador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsrsupervisor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsrsupervisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtLinhasporarquivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtLinhasporarquivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtTotallinhas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtTotallinhas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sku");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sku"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stFluxoentrada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stFluxoentrada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stFluxosaida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stFluxosaida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tensaomaxima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tensaomaxima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tensaominima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tensaominima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpExportacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpExportacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
