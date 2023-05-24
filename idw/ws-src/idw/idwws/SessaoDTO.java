/**
 * SessaoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class SessaoDTO  implements java.io.Serializable {
    private int PT_DESCONHECIDO;

    private int PT_MONTAGEM;

    private int PT_TESTE_FUNCIONAL;

    private int PT_TESTE_PASSA_NAO_PASSA;

    private int PT_TESTE_PASSA_COD_DEFEITO;

    private int PT_TESTE_REPROCESSO;

    private int PT_PASSAGEM;

    private java.lang.String cdUsr;

    private boolean conexao;

    private java.lang.String dsGt;

    private java.lang.String dsPt;

    private java.lang.String ds_apelido;

    private java.util.Calendar dthrParasincronia;

    private java.util.Calendar dthrUltimoHeartBeat;

    private java.util.Calendar dthrevento;

    private long idCal;

    private long idFolha;

    private long idGrpUsrOperador;

    private long idGrpUsrSupervisor;

    private long idGt;

    private long idPt;

    private long idTppt;

    private long idUsr;

    private boolean logonObrigatorio;

    private java.lang.String mac;

    private java.lang.String mascaraCdProdutoFilho;

    private java.lang.String mascaraCdProdutoPai;

    private boolean primeiraLevaTesteFuncional;

    private idw.idwws.ResultadoDTO resultado;

    private java.math.BigDecimal segFeedbacklogin;

    private java.math.BigDecimal segHeartbeat;

    private java.math.BigDecimal segLogoutauto;

    private java.math.BigDecimal segX;

    private java.math.BigDecimal segY;

    private java.math.BigDecimal segZ;

    private int tppt;

    public SessaoDTO() {
    }

    public SessaoDTO(
           int PT_DESCONHECIDO,
           int PT_MONTAGEM,
           int PT_TESTE_FUNCIONAL,
           int PT_TESTE_PASSA_NAO_PASSA,
           int PT_TESTE_PASSA_COD_DEFEITO,
           int PT_TESTE_REPROCESSO,
           int PT_PASSAGEM,
           java.lang.String cdUsr,
           boolean conexao,
           java.lang.String dsGt,
           java.lang.String dsPt,
           java.lang.String ds_apelido,
           java.util.Calendar dthrParasincronia,
           java.util.Calendar dthrUltimoHeartBeat,
           java.util.Calendar dthrevento,
           long idCal,
           long idFolha,
           long idGrpUsrOperador,
           long idGrpUsrSupervisor,
           long idGt,
           long idPt,
           long idTppt,
           long idUsr,
           boolean logonObrigatorio,
           java.lang.String mac,
           java.lang.String mascaraCdProdutoFilho,
           java.lang.String mascaraCdProdutoPai,
           boolean primeiraLevaTesteFuncional,
           idw.idwws.ResultadoDTO resultado,
           java.math.BigDecimal segFeedbacklogin,
           java.math.BigDecimal segHeartbeat,
           java.math.BigDecimal segLogoutauto,
           java.math.BigDecimal segX,
           java.math.BigDecimal segY,
           java.math.BigDecimal segZ,
           int tppt) {
           this.PT_DESCONHECIDO = PT_DESCONHECIDO;
           this.PT_MONTAGEM = PT_MONTAGEM;
           this.PT_TESTE_FUNCIONAL = PT_TESTE_FUNCIONAL;
           this.PT_TESTE_PASSA_NAO_PASSA = PT_TESTE_PASSA_NAO_PASSA;
           this.PT_TESTE_PASSA_COD_DEFEITO = PT_TESTE_PASSA_COD_DEFEITO;
           this.PT_TESTE_REPROCESSO = PT_TESTE_REPROCESSO;
           this.PT_PASSAGEM = PT_PASSAGEM;
           this.cdUsr = cdUsr;
           this.conexao = conexao;
           this.dsGt = dsGt;
           this.dsPt = dsPt;
           this.ds_apelido = ds_apelido;
           this.dthrParasincronia = dthrParasincronia;
           this.dthrUltimoHeartBeat = dthrUltimoHeartBeat;
           this.dthrevento = dthrevento;
           this.idCal = idCal;
           this.idFolha = idFolha;
           this.idGrpUsrOperador = idGrpUsrOperador;
           this.idGrpUsrSupervisor = idGrpUsrSupervisor;
           this.idGt = idGt;
           this.idPt = idPt;
           this.idTppt = idTppt;
           this.idUsr = idUsr;
           this.logonObrigatorio = logonObrigatorio;
           this.mac = mac;
           this.mascaraCdProdutoFilho = mascaraCdProdutoFilho;
           this.mascaraCdProdutoPai = mascaraCdProdutoPai;
           this.primeiraLevaTesteFuncional = primeiraLevaTesteFuncional;
           this.resultado = resultado;
           this.segFeedbacklogin = segFeedbacklogin;
           this.segHeartbeat = segHeartbeat;
           this.segLogoutauto = segLogoutauto;
           this.segX = segX;
           this.segY = segY;
           this.segZ = segZ;
           this.tppt = tppt;
    }


    /**
     * Gets the PT_DESCONHECIDO value for this SessaoDTO.
     * 
     * @return PT_DESCONHECIDO
     */
    public int getPT_DESCONHECIDO() {
        return PT_DESCONHECIDO;
    }


    /**
     * Sets the PT_DESCONHECIDO value for this SessaoDTO.
     * 
     * @param PT_DESCONHECIDO
     */
    public void setPT_DESCONHECIDO(int PT_DESCONHECIDO) {
        this.PT_DESCONHECIDO = PT_DESCONHECIDO;
    }


    /**
     * Gets the PT_MONTAGEM value for this SessaoDTO.
     * 
     * @return PT_MONTAGEM
     */
    public int getPT_MONTAGEM() {
        return PT_MONTAGEM;
    }


    /**
     * Sets the PT_MONTAGEM value for this SessaoDTO.
     * 
     * @param PT_MONTAGEM
     */
    public void setPT_MONTAGEM(int PT_MONTAGEM) {
        this.PT_MONTAGEM = PT_MONTAGEM;
    }


    /**
     * Gets the PT_TESTE_FUNCIONAL value for this SessaoDTO.
     * 
     * @return PT_TESTE_FUNCIONAL
     */
    public int getPT_TESTE_FUNCIONAL() {
        return PT_TESTE_FUNCIONAL;
    }


    /**
     * Sets the PT_TESTE_FUNCIONAL value for this SessaoDTO.
     * 
     * @param PT_TESTE_FUNCIONAL
     */
    public void setPT_TESTE_FUNCIONAL(int PT_TESTE_FUNCIONAL) {
        this.PT_TESTE_FUNCIONAL = PT_TESTE_FUNCIONAL;
    }


    /**
     * Gets the PT_TESTE_PASSA_NAO_PASSA value for this SessaoDTO.
     * 
     * @return PT_TESTE_PASSA_NAO_PASSA
     */
    public int getPT_TESTE_PASSA_NAO_PASSA() {
        return PT_TESTE_PASSA_NAO_PASSA;
    }


    /**
     * Sets the PT_TESTE_PASSA_NAO_PASSA value for this SessaoDTO.
     * 
     * @param PT_TESTE_PASSA_NAO_PASSA
     */
    public void setPT_TESTE_PASSA_NAO_PASSA(int PT_TESTE_PASSA_NAO_PASSA) {
        this.PT_TESTE_PASSA_NAO_PASSA = PT_TESTE_PASSA_NAO_PASSA;
    }


    /**
     * Gets the PT_TESTE_PASSA_COD_DEFEITO value for this SessaoDTO.
     * 
     * @return PT_TESTE_PASSA_COD_DEFEITO
     */
    public int getPT_TESTE_PASSA_COD_DEFEITO() {
        return PT_TESTE_PASSA_COD_DEFEITO;
    }


    /**
     * Sets the PT_TESTE_PASSA_COD_DEFEITO value for this SessaoDTO.
     * 
     * @param PT_TESTE_PASSA_COD_DEFEITO
     */
    public void setPT_TESTE_PASSA_COD_DEFEITO(int PT_TESTE_PASSA_COD_DEFEITO) {
        this.PT_TESTE_PASSA_COD_DEFEITO = PT_TESTE_PASSA_COD_DEFEITO;
    }


    /**
     * Gets the PT_TESTE_REPROCESSO value for this SessaoDTO.
     * 
     * @return PT_TESTE_REPROCESSO
     */
    public int getPT_TESTE_REPROCESSO() {
        return PT_TESTE_REPROCESSO;
    }


    /**
     * Sets the PT_TESTE_REPROCESSO value for this SessaoDTO.
     * 
     * @param PT_TESTE_REPROCESSO
     */
    public void setPT_TESTE_REPROCESSO(int PT_TESTE_REPROCESSO) {
        this.PT_TESTE_REPROCESSO = PT_TESTE_REPROCESSO;
    }


    /**
     * Gets the PT_PASSAGEM value for this SessaoDTO.
     * 
     * @return PT_PASSAGEM
     */
    public int getPT_PASSAGEM() {
        return PT_PASSAGEM;
    }


    /**
     * Sets the PT_PASSAGEM value for this SessaoDTO.
     * 
     * @param PT_PASSAGEM
     */
    public void setPT_PASSAGEM(int PT_PASSAGEM) {
        this.PT_PASSAGEM = PT_PASSAGEM;
    }


    /**
     * Gets the cdUsr value for this SessaoDTO.
     * 
     * @return cdUsr
     */
    public java.lang.String getCdUsr() {
        return cdUsr;
    }


    /**
     * Sets the cdUsr value for this SessaoDTO.
     * 
     * @param cdUsr
     */
    public void setCdUsr(java.lang.String cdUsr) {
        this.cdUsr = cdUsr;
    }


    /**
     * Gets the conexao value for this SessaoDTO.
     * 
     * @return conexao
     */
    public boolean isConexao() {
        return conexao;
    }


    /**
     * Sets the conexao value for this SessaoDTO.
     * 
     * @param conexao
     */
    public void setConexao(boolean conexao) {
        this.conexao = conexao;
    }


    /**
     * Gets the dsGt value for this SessaoDTO.
     * 
     * @return dsGt
     */
    public java.lang.String getDsGt() {
        return dsGt;
    }


    /**
     * Sets the dsGt value for this SessaoDTO.
     * 
     * @param dsGt
     */
    public void setDsGt(java.lang.String dsGt) {
        this.dsGt = dsGt;
    }


    /**
     * Gets the dsPt value for this SessaoDTO.
     * 
     * @return dsPt
     */
    public java.lang.String getDsPt() {
        return dsPt;
    }


    /**
     * Sets the dsPt value for this SessaoDTO.
     * 
     * @param dsPt
     */
    public void setDsPt(java.lang.String dsPt) {
        this.dsPt = dsPt;
    }


    /**
     * Gets the ds_apelido value for this SessaoDTO.
     * 
     * @return ds_apelido
     */
    public java.lang.String getDs_apelido() {
        return ds_apelido;
    }


    /**
     * Sets the ds_apelido value for this SessaoDTO.
     * 
     * @param ds_apelido
     */
    public void setDs_apelido(java.lang.String ds_apelido) {
        this.ds_apelido = ds_apelido;
    }


    /**
     * Gets the dthrParasincronia value for this SessaoDTO.
     * 
     * @return dthrParasincronia
     */
    public java.util.Calendar getDthrParasincronia() {
        return dthrParasincronia;
    }


    /**
     * Sets the dthrParasincronia value for this SessaoDTO.
     * 
     * @param dthrParasincronia
     */
    public void setDthrParasincronia(java.util.Calendar dthrParasincronia) {
        this.dthrParasincronia = dthrParasincronia;
    }


    /**
     * Gets the dthrUltimoHeartBeat value for this SessaoDTO.
     * 
     * @return dthrUltimoHeartBeat
     */
    public java.util.Calendar getDthrUltimoHeartBeat() {
        return dthrUltimoHeartBeat;
    }


    /**
     * Sets the dthrUltimoHeartBeat value for this SessaoDTO.
     * 
     * @param dthrUltimoHeartBeat
     */
    public void setDthrUltimoHeartBeat(java.util.Calendar dthrUltimoHeartBeat) {
        this.dthrUltimoHeartBeat = dthrUltimoHeartBeat;
    }


    /**
     * Gets the dthrevento value for this SessaoDTO.
     * 
     * @return dthrevento
     */
    public java.util.Calendar getDthrevento() {
        return dthrevento;
    }


    /**
     * Sets the dthrevento value for this SessaoDTO.
     * 
     * @param dthrevento
     */
    public void setDthrevento(java.util.Calendar dthrevento) {
        this.dthrevento = dthrevento;
    }


    /**
     * Gets the idCal value for this SessaoDTO.
     * 
     * @return idCal
     */
    public long getIdCal() {
        return idCal;
    }


    /**
     * Sets the idCal value for this SessaoDTO.
     * 
     * @param idCal
     */
    public void setIdCal(long idCal) {
        this.idCal = idCal;
    }


    /**
     * Gets the idFolha value for this SessaoDTO.
     * 
     * @return idFolha
     */
    public long getIdFolha() {
        return idFolha;
    }


    /**
     * Sets the idFolha value for this SessaoDTO.
     * 
     * @param idFolha
     */
    public void setIdFolha(long idFolha) {
        this.idFolha = idFolha;
    }


    /**
     * Gets the idGrpUsrOperador value for this SessaoDTO.
     * 
     * @return idGrpUsrOperador
     */
    public long getIdGrpUsrOperador() {
        return idGrpUsrOperador;
    }


    /**
     * Sets the idGrpUsrOperador value for this SessaoDTO.
     * 
     * @param idGrpUsrOperador
     */
    public void setIdGrpUsrOperador(long idGrpUsrOperador) {
        this.idGrpUsrOperador = idGrpUsrOperador;
    }


    /**
     * Gets the idGrpUsrSupervisor value for this SessaoDTO.
     * 
     * @return idGrpUsrSupervisor
     */
    public long getIdGrpUsrSupervisor() {
        return idGrpUsrSupervisor;
    }


    /**
     * Sets the idGrpUsrSupervisor value for this SessaoDTO.
     * 
     * @param idGrpUsrSupervisor
     */
    public void setIdGrpUsrSupervisor(long idGrpUsrSupervisor) {
        this.idGrpUsrSupervisor = idGrpUsrSupervisor;
    }


    /**
     * Gets the idGt value for this SessaoDTO.
     * 
     * @return idGt
     */
    public long getIdGt() {
        return idGt;
    }


    /**
     * Sets the idGt value for this SessaoDTO.
     * 
     * @param idGt
     */
    public void setIdGt(long idGt) {
        this.idGt = idGt;
    }


    /**
     * Gets the idPt value for this SessaoDTO.
     * 
     * @return idPt
     */
    public long getIdPt() {
        return idPt;
    }


    /**
     * Sets the idPt value for this SessaoDTO.
     * 
     * @param idPt
     */
    public void setIdPt(long idPt) {
        this.idPt = idPt;
    }


    /**
     * Gets the idTppt value for this SessaoDTO.
     * 
     * @return idTppt
     */
    public long getIdTppt() {
        return idTppt;
    }


    /**
     * Sets the idTppt value for this SessaoDTO.
     * 
     * @param idTppt
     */
    public void setIdTppt(long idTppt) {
        this.idTppt = idTppt;
    }


    /**
     * Gets the idUsr value for this SessaoDTO.
     * 
     * @return idUsr
     */
    public long getIdUsr() {
        return idUsr;
    }


    /**
     * Sets the idUsr value for this SessaoDTO.
     * 
     * @param idUsr
     */
    public void setIdUsr(long idUsr) {
        this.idUsr = idUsr;
    }


    /**
     * Gets the logonObrigatorio value for this SessaoDTO.
     * 
     * @return logonObrigatorio
     */
    public boolean isLogonObrigatorio() {
        return logonObrigatorio;
    }


    /**
     * Sets the logonObrigatorio value for this SessaoDTO.
     * 
     * @param logonObrigatorio
     */
    public void setLogonObrigatorio(boolean logonObrigatorio) {
        this.logonObrigatorio = logonObrigatorio;
    }


    /**
     * Gets the mac value for this SessaoDTO.
     * 
     * @return mac
     */
    public java.lang.String getMac() {
        return mac;
    }


    /**
     * Sets the mac value for this SessaoDTO.
     * 
     * @param mac
     */
    public void setMac(java.lang.String mac) {
        this.mac = mac;
    }


    /**
     * Gets the mascaraCdProdutoFilho value for this SessaoDTO.
     * 
     * @return mascaraCdProdutoFilho
     */
    public java.lang.String getMascaraCdProdutoFilho() {
        return mascaraCdProdutoFilho;
    }


    /**
     * Sets the mascaraCdProdutoFilho value for this SessaoDTO.
     * 
     * @param mascaraCdProdutoFilho
     */
    public void setMascaraCdProdutoFilho(java.lang.String mascaraCdProdutoFilho) {
        this.mascaraCdProdutoFilho = mascaraCdProdutoFilho;
    }


    /**
     * Gets the mascaraCdProdutoPai value for this SessaoDTO.
     * 
     * @return mascaraCdProdutoPai
     */
    public java.lang.String getMascaraCdProdutoPai() {
        return mascaraCdProdutoPai;
    }


    /**
     * Sets the mascaraCdProdutoPai value for this SessaoDTO.
     * 
     * @param mascaraCdProdutoPai
     */
    public void setMascaraCdProdutoPai(java.lang.String mascaraCdProdutoPai) {
        this.mascaraCdProdutoPai = mascaraCdProdutoPai;
    }


    /**
     * Gets the primeiraLevaTesteFuncional value for this SessaoDTO.
     * 
     * @return primeiraLevaTesteFuncional
     */
    public boolean isPrimeiraLevaTesteFuncional() {
        return primeiraLevaTesteFuncional;
    }


    /**
     * Sets the primeiraLevaTesteFuncional value for this SessaoDTO.
     * 
     * @param primeiraLevaTesteFuncional
     */
    public void setPrimeiraLevaTesteFuncional(boolean primeiraLevaTesteFuncional) {
        this.primeiraLevaTesteFuncional = primeiraLevaTesteFuncional;
    }


    /**
     * Gets the resultado value for this SessaoDTO.
     * 
     * @return resultado
     */
    public idw.idwws.ResultadoDTO getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this SessaoDTO.
     * 
     * @param resultado
     */
    public void setResultado(idw.idwws.ResultadoDTO resultado) {
        this.resultado = resultado;
    }


    /**
     * Gets the segFeedbacklogin value for this SessaoDTO.
     * 
     * @return segFeedbacklogin
     */
    public java.math.BigDecimal getSegFeedbacklogin() {
        return segFeedbacklogin;
    }


    /**
     * Sets the segFeedbacklogin value for this SessaoDTO.
     * 
     * @param segFeedbacklogin
     */
    public void setSegFeedbacklogin(java.math.BigDecimal segFeedbacklogin) {
        this.segFeedbacklogin = segFeedbacklogin;
    }


    /**
     * Gets the segHeartbeat value for this SessaoDTO.
     * 
     * @return segHeartbeat
     */
    public java.math.BigDecimal getSegHeartbeat() {
        return segHeartbeat;
    }


    /**
     * Sets the segHeartbeat value for this SessaoDTO.
     * 
     * @param segHeartbeat
     */
    public void setSegHeartbeat(java.math.BigDecimal segHeartbeat) {
        this.segHeartbeat = segHeartbeat;
    }


    /**
     * Gets the segLogoutauto value for this SessaoDTO.
     * 
     * @return segLogoutauto
     */
    public java.math.BigDecimal getSegLogoutauto() {
        return segLogoutauto;
    }


    /**
     * Sets the segLogoutauto value for this SessaoDTO.
     * 
     * @param segLogoutauto
     */
    public void setSegLogoutauto(java.math.BigDecimal segLogoutauto) {
        this.segLogoutauto = segLogoutauto;
    }


    /**
     * Gets the segX value for this SessaoDTO.
     * 
     * @return segX
     */
    public java.math.BigDecimal getSegX() {
        return segX;
    }


    /**
     * Sets the segX value for this SessaoDTO.
     * 
     * @param segX
     */
    public void setSegX(java.math.BigDecimal segX) {
        this.segX = segX;
    }


    /**
     * Gets the segY value for this SessaoDTO.
     * 
     * @return segY
     */
    public java.math.BigDecimal getSegY() {
        return segY;
    }


    /**
     * Sets the segY value for this SessaoDTO.
     * 
     * @param segY
     */
    public void setSegY(java.math.BigDecimal segY) {
        this.segY = segY;
    }


    /**
     * Gets the segZ value for this SessaoDTO.
     * 
     * @return segZ
     */
    public java.math.BigDecimal getSegZ() {
        return segZ;
    }


    /**
     * Sets the segZ value for this SessaoDTO.
     * 
     * @param segZ
     */
    public void setSegZ(java.math.BigDecimal segZ) {
        this.segZ = segZ;
    }


    /**
     * Gets the tppt value for this SessaoDTO.
     * 
     * @return tppt
     */
    public int getTppt() {
        return tppt;
    }


    /**
     * Sets the tppt value for this SessaoDTO.
     * 
     * @param tppt
     */
    public void setTppt(int tppt) {
        this.tppt = tppt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SessaoDTO)) return false;
        SessaoDTO other = (SessaoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.PT_DESCONHECIDO == other.getPT_DESCONHECIDO() &&
            this.PT_MONTAGEM == other.getPT_MONTAGEM() &&
            this.PT_TESTE_FUNCIONAL == other.getPT_TESTE_FUNCIONAL() &&
            this.PT_TESTE_PASSA_NAO_PASSA == other.getPT_TESTE_PASSA_NAO_PASSA() &&
            this.PT_TESTE_PASSA_COD_DEFEITO == other.getPT_TESTE_PASSA_COD_DEFEITO() &&
            this.PT_TESTE_REPROCESSO == other.getPT_TESTE_REPROCESSO() &&
            this.PT_PASSAGEM == other.getPT_PASSAGEM() &&
            ((this.cdUsr==null && other.getCdUsr()==null) || 
             (this.cdUsr!=null &&
              this.cdUsr.equals(other.getCdUsr()))) &&
            this.conexao == other.isConexao() &&
            ((this.dsGt==null && other.getDsGt()==null) || 
             (this.dsGt!=null &&
              this.dsGt.equals(other.getDsGt()))) &&
            ((this.dsPt==null && other.getDsPt()==null) || 
             (this.dsPt!=null &&
              this.dsPt.equals(other.getDsPt()))) &&
            ((this.ds_apelido==null && other.getDs_apelido()==null) || 
             (this.ds_apelido!=null &&
              this.ds_apelido.equals(other.getDs_apelido()))) &&
            ((this.dthrParasincronia==null && other.getDthrParasincronia()==null) || 
             (this.dthrParasincronia!=null &&
              this.dthrParasincronia.equals(other.getDthrParasincronia()))) &&
            ((this.dthrUltimoHeartBeat==null && other.getDthrUltimoHeartBeat()==null) || 
             (this.dthrUltimoHeartBeat!=null &&
              this.dthrUltimoHeartBeat.equals(other.getDthrUltimoHeartBeat()))) &&
            ((this.dthrevento==null && other.getDthrevento()==null) || 
             (this.dthrevento!=null &&
              this.dthrevento.equals(other.getDthrevento()))) &&
            this.idCal == other.getIdCal() &&
            this.idFolha == other.getIdFolha() &&
            this.idGrpUsrOperador == other.getIdGrpUsrOperador() &&
            this.idGrpUsrSupervisor == other.getIdGrpUsrSupervisor() &&
            this.idGt == other.getIdGt() &&
            this.idPt == other.getIdPt() &&
            this.idTppt == other.getIdTppt() &&
            this.idUsr == other.getIdUsr() &&
            this.logonObrigatorio == other.isLogonObrigatorio() &&
            ((this.mac==null && other.getMac()==null) || 
             (this.mac!=null &&
              this.mac.equals(other.getMac()))) &&
            ((this.mascaraCdProdutoFilho==null && other.getMascaraCdProdutoFilho()==null) || 
             (this.mascaraCdProdutoFilho!=null &&
              this.mascaraCdProdutoFilho.equals(other.getMascaraCdProdutoFilho()))) &&
            ((this.mascaraCdProdutoPai==null && other.getMascaraCdProdutoPai()==null) || 
             (this.mascaraCdProdutoPai!=null &&
              this.mascaraCdProdutoPai.equals(other.getMascaraCdProdutoPai()))) &&
            this.primeiraLevaTesteFuncional == other.isPrimeiraLevaTesteFuncional() &&
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado()))) &&
            ((this.segFeedbacklogin==null && other.getSegFeedbacklogin()==null) || 
             (this.segFeedbacklogin!=null &&
              this.segFeedbacklogin.equals(other.getSegFeedbacklogin()))) &&
            ((this.segHeartbeat==null && other.getSegHeartbeat()==null) || 
             (this.segHeartbeat!=null &&
              this.segHeartbeat.equals(other.getSegHeartbeat()))) &&
            ((this.segLogoutauto==null && other.getSegLogoutauto()==null) || 
             (this.segLogoutauto!=null &&
              this.segLogoutauto.equals(other.getSegLogoutauto()))) &&
            ((this.segX==null && other.getSegX()==null) || 
             (this.segX!=null &&
              this.segX.equals(other.getSegX()))) &&
            ((this.segY==null && other.getSegY()==null) || 
             (this.segY!=null &&
              this.segY.equals(other.getSegY()))) &&
            ((this.segZ==null && other.getSegZ()==null) || 
             (this.segZ!=null &&
              this.segZ.equals(other.getSegZ()))) &&
            this.tppt == other.getTppt();
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
        _hashCode += getPT_DESCONHECIDO();
        _hashCode += getPT_MONTAGEM();
        _hashCode += getPT_TESTE_FUNCIONAL();
        _hashCode += getPT_TESTE_PASSA_NAO_PASSA();
        _hashCode += getPT_TESTE_PASSA_COD_DEFEITO();
        _hashCode += getPT_TESTE_REPROCESSO();
        _hashCode += getPT_PASSAGEM();
        if (getCdUsr() != null) {
            _hashCode += getCdUsr().hashCode();
        }
        _hashCode += (isConexao() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDsGt() != null) {
            _hashCode += getDsGt().hashCode();
        }
        if (getDsPt() != null) {
            _hashCode += getDsPt().hashCode();
        }
        if (getDs_apelido() != null) {
            _hashCode += getDs_apelido().hashCode();
        }
        if (getDthrParasincronia() != null) {
            _hashCode += getDthrParasincronia().hashCode();
        }
        if (getDthrUltimoHeartBeat() != null) {
            _hashCode += getDthrUltimoHeartBeat().hashCode();
        }
        if (getDthrevento() != null) {
            _hashCode += getDthrevento().hashCode();
        }
        _hashCode += new Long(getIdCal()).hashCode();
        _hashCode += new Long(getIdFolha()).hashCode();
        _hashCode += new Long(getIdGrpUsrOperador()).hashCode();
        _hashCode += new Long(getIdGrpUsrSupervisor()).hashCode();
        _hashCode += new Long(getIdGt()).hashCode();
        _hashCode += new Long(getIdPt()).hashCode();
        _hashCode += new Long(getIdTppt()).hashCode();
        _hashCode += new Long(getIdUsr()).hashCode();
        _hashCode += (isLogonObrigatorio() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getMac() != null) {
            _hashCode += getMac().hashCode();
        }
        if (getMascaraCdProdutoFilho() != null) {
            _hashCode += getMascaraCdProdutoFilho().hashCode();
        }
        if (getMascaraCdProdutoPai() != null) {
            _hashCode += getMascaraCdProdutoPai().hashCode();
        }
        _hashCode += (isPrimeiraLevaTesteFuncional() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        if (getSegFeedbacklogin() != null) {
            _hashCode += getSegFeedbacklogin().hashCode();
        }
        if (getSegHeartbeat() != null) {
            _hashCode += getSegHeartbeat().hashCode();
        }
        if (getSegLogoutauto() != null) {
            _hashCode += getSegLogoutauto().hashCode();
        }
        if (getSegX() != null) {
            _hashCode += getSegX().hashCode();
        }
        if (getSegY() != null) {
            _hashCode += getSegY().hashCode();
        }
        if (getSegZ() != null) {
            _hashCode += getSegZ().hashCode();
        }
        _hashCode += getTppt();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SessaoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "sessaoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PT_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PT_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PT_MONTAGEM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PT_MONTAGEM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PT_TESTE_FUNCIONAL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PT_TESTE_FUNCIONAL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PT_TESTE_PASSA_NAO_PASSA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PT_TESTE_PASSA_NAO_PASSA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PT_TESTE_PASSA_COD_DEFEITO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PT_TESTE_PASSA_COD_DEFEITO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PT_TESTE_REPROCESSO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PT_TESTE_REPROCESSO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PT_PASSAGEM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PT_PASSAGEM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conexao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "conexao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ds_apelido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ds_apelido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrParasincronia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrParasincronia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrUltimoHeartBeat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrUltimoHeartBeat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrevento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrevento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idGrpUsrOperador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idGrpUsrOperador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idGrpUsrSupervisor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idGrpUsrSupervisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTppt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTppt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logonObrigatorio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "logonObrigatorio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mac");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mac"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mascaraCdProdutoFilho");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mascaraCdProdutoFilho"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mascaraCdProdutoPai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mascaraCdProdutoPai"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primeiraLevaTesteFuncional");
        elemField.setXmlName(new javax.xml.namespace.QName("", "primeiraLevaTesteFuncional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segFeedbacklogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segFeedbacklogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segHeartbeat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segHeartbeat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segLogoutauto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segLogoutauto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segX");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segX"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segZ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segZ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tppt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tppt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
