/**
 * PassagemDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PassagemDTO  implements java.io.Serializable {
    private java.lang.String cb;

    private boolean deveSerPassagemNova;

    private java.util.Calendar dtHrEvento;

    private java.util.Calendar dtHrEventoAnterior;

    private idw.idwws.DwFolha dwfolha;

    private idw.idwws.DwNserie dwnserie;

    private idw.idwws.DwRotapasso dwrotapasso;

    private int enviarRefugo;

    private long idFolha;

    private long idGrpUsrOperador;

    private long idGrpUsrSupervisor;

    private long idGt;

    private long idNSerie;

    private long idProduto;

    private long idPt;

    private long idTppt;

    private long idUsr;

    private idw.idwws.AcaoDTO[] listaAcoes;

    private idw.idwws.DefeitoDTO[] listaDefeitos;

    private idw.idwws.MontagemDTO[] listaMontagem;

    private java.lang.String mascaraCdProdutoPai;

    private idw.idwws.NaoConformidadeDTO[] naoConformidadesAtuais;

    private idw.idwws.OmCfg omcfg;

    private boolean passaadiante;

    private java.lang.String reSupervisor;

    private idw.idwws.FolhaDTO receitaTeste;

    private idw.idwws.ResultadoDTO resultado;

    private idw.idwws.ResultadoTesteDTO resultadoTesteFuncional;

    private java.math.BigDecimal segTempoParafusadeira;

    private int tppt;

    private java.lang.Integer[] tpptAnterioes;

    public PassagemDTO() {
    }

    public PassagemDTO(
           java.lang.String cb,
           boolean deveSerPassagemNova,
           java.util.Calendar dtHrEvento,
           java.util.Calendar dtHrEventoAnterior,
           idw.idwws.DwFolha dwfolha,
           idw.idwws.DwNserie dwnserie,
           idw.idwws.DwRotapasso dwrotapasso,
           int enviarRefugo,
           long idFolha,
           long idGrpUsrOperador,
           long idGrpUsrSupervisor,
           long idGt,
           long idNSerie,
           long idProduto,
           long idPt,
           long idTppt,
           long idUsr,
           idw.idwws.AcaoDTO[] listaAcoes,
           idw.idwws.DefeitoDTO[] listaDefeitos,
           idw.idwws.MontagemDTO[] listaMontagem,
           java.lang.String mascaraCdProdutoPai,
           idw.idwws.NaoConformidadeDTO[] naoConformidadesAtuais,
           idw.idwws.OmCfg omcfg,
           boolean passaadiante,
           java.lang.String reSupervisor,
           idw.idwws.FolhaDTO receitaTeste,
           idw.idwws.ResultadoDTO resultado,
           idw.idwws.ResultadoTesteDTO resultadoTesteFuncional,
           java.math.BigDecimal segTempoParafusadeira,
           int tppt,
           java.lang.Integer[] tpptAnterioes) {
           this.cb = cb;
           this.deveSerPassagemNova = deveSerPassagemNova;
           this.dtHrEvento = dtHrEvento;
           this.dtHrEventoAnterior = dtHrEventoAnterior;
           this.dwfolha = dwfolha;
           this.dwnserie = dwnserie;
           this.dwrotapasso = dwrotapasso;
           this.enviarRefugo = enviarRefugo;
           this.idFolha = idFolha;
           this.idGrpUsrOperador = idGrpUsrOperador;
           this.idGrpUsrSupervisor = idGrpUsrSupervisor;
           this.idGt = idGt;
           this.idNSerie = idNSerie;
           this.idProduto = idProduto;
           this.idPt = idPt;
           this.idTppt = idTppt;
           this.idUsr = idUsr;
           this.listaAcoes = listaAcoes;
           this.listaDefeitos = listaDefeitos;
           this.listaMontagem = listaMontagem;
           this.mascaraCdProdutoPai = mascaraCdProdutoPai;
           this.naoConformidadesAtuais = naoConformidadesAtuais;
           this.omcfg = omcfg;
           this.passaadiante = passaadiante;
           this.reSupervisor = reSupervisor;
           this.receitaTeste = receitaTeste;
           this.resultado = resultado;
           this.resultadoTesteFuncional = resultadoTesteFuncional;
           this.segTempoParafusadeira = segTempoParafusadeira;
           this.tppt = tppt;
           this.tpptAnterioes = tpptAnterioes;
    }


    /**
     * Gets the cb value for this PassagemDTO.
     * 
     * @return cb
     */
    public java.lang.String getCb() {
        return cb;
    }


    /**
     * Sets the cb value for this PassagemDTO.
     * 
     * @param cb
     */
    public void setCb(java.lang.String cb) {
        this.cb = cb;
    }


    /**
     * Gets the deveSerPassagemNova value for this PassagemDTO.
     * 
     * @return deveSerPassagemNova
     */
    public boolean isDeveSerPassagemNova() {
        return deveSerPassagemNova;
    }


    /**
     * Sets the deveSerPassagemNova value for this PassagemDTO.
     * 
     * @param deveSerPassagemNova
     */
    public void setDeveSerPassagemNova(boolean deveSerPassagemNova) {
        this.deveSerPassagemNova = deveSerPassagemNova;
    }


    /**
     * Gets the dtHrEvento value for this PassagemDTO.
     * 
     * @return dtHrEvento
     */
    public java.util.Calendar getDtHrEvento() {
        return dtHrEvento;
    }


    /**
     * Sets the dtHrEvento value for this PassagemDTO.
     * 
     * @param dtHrEvento
     */
    public void setDtHrEvento(java.util.Calendar dtHrEvento) {
        this.dtHrEvento = dtHrEvento;
    }


    /**
     * Gets the dtHrEventoAnterior value for this PassagemDTO.
     * 
     * @return dtHrEventoAnterior
     */
    public java.util.Calendar getDtHrEventoAnterior() {
        return dtHrEventoAnterior;
    }


    /**
     * Sets the dtHrEventoAnterior value for this PassagemDTO.
     * 
     * @param dtHrEventoAnterior
     */
    public void setDtHrEventoAnterior(java.util.Calendar dtHrEventoAnterior) {
        this.dtHrEventoAnterior = dtHrEventoAnterior;
    }


    /**
     * Gets the dwfolha value for this PassagemDTO.
     * 
     * @return dwfolha
     */
    public idw.idwws.DwFolha getDwfolha() {
        return dwfolha;
    }


    /**
     * Sets the dwfolha value for this PassagemDTO.
     * 
     * @param dwfolha
     */
    public void setDwfolha(idw.idwws.DwFolha dwfolha) {
        this.dwfolha = dwfolha;
    }


    /**
     * Gets the dwnserie value for this PassagemDTO.
     * 
     * @return dwnserie
     */
    public idw.idwws.DwNserie getDwnserie() {
        return dwnserie;
    }


    /**
     * Sets the dwnserie value for this PassagemDTO.
     * 
     * @param dwnserie
     */
    public void setDwnserie(idw.idwws.DwNserie dwnserie) {
        this.dwnserie = dwnserie;
    }


    /**
     * Gets the dwrotapasso value for this PassagemDTO.
     * 
     * @return dwrotapasso
     */
    public idw.idwws.DwRotapasso getDwrotapasso() {
        return dwrotapasso;
    }


    /**
     * Sets the dwrotapasso value for this PassagemDTO.
     * 
     * @param dwrotapasso
     */
    public void setDwrotapasso(idw.idwws.DwRotapasso dwrotapasso) {
        this.dwrotapasso = dwrotapasso;
    }


    /**
     * Gets the enviarRefugo value for this PassagemDTO.
     * 
     * @return enviarRefugo
     */
    public int getEnviarRefugo() {
        return enviarRefugo;
    }


    /**
     * Sets the enviarRefugo value for this PassagemDTO.
     * 
     * @param enviarRefugo
     */
    public void setEnviarRefugo(int enviarRefugo) {
        this.enviarRefugo = enviarRefugo;
    }


    /**
     * Gets the idFolha value for this PassagemDTO.
     * 
     * @return idFolha
     */
    public long getIdFolha() {
        return idFolha;
    }


    /**
     * Sets the idFolha value for this PassagemDTO.
     * 
     * @param idFolha
     */
    public void setIdFolha(long idFolha) {
        this.idFolha = idFolha;
    }


    /**
     * Gets the idGrpUsrOperador value for this PassagemDTO.
     * 
     * @return idGrpUsrOperador
     */
    public long getIdGrpUsrOperador() {
        return idGrpUsrOperador;
    }


    /**
     * Sets the idGrpUsrOperador value for this PassagemDTO.
     * 
     * @param idGrpUsrOperador
     */
    public void setIdGrpUsrOperador(long idGrpUsrOperador) {
        this.idGrpUsrOperador = idGrpUsrOperador;
    }


    /**
     * Gets the idGrpUsrSupervisor value for this PassagemDTO.
     * 
     * @return idGrpUsrSupervisor
     */
    public long getIdGrpUsrSupervisor() {
        return idGrpUsrSupervisor;
    }


    /**
     * Sets the idGrpUsrSupervisor value for this PassagemDTO.
     * 
     * @param idGrpUsrSupervisor
     */
    public void setIdGrpUsrSupervisor(long idGrpUsrSupervisor) {
        this.idGrpUsrSupervisor = idGrpUsrSupervisor;
    }


    /**
     * Gets the idGt value for this PassagemDTO.
     * 
     * @return idGt
     */
    public long getIdGt() {
        return idGt;
    }


    /**
     * Sets the idGt value for this PassagemDTO.
     * 
     * @param idGt
     */
    public void setIdGt(long idGt) {
        this.idGt = idGt;
    }


    /**
     * Gets the idNSerie value for this PassagemDTO.
     * 
     * @return idNSerie
     */
    public long getIdNSerie() {
        return idNSerie;
    }


    /**
     * Sets the idNSerie value for this PassagemDTO.
     * 
     * @param idNSerie
     */
    public void setIdNSerie(long idNSerie) {
        this.idNSerie = idNSerie;
    }


    /**
     * Gets the idProduto value for this PassagemDTO.
     * 
     * @return idProduto
     */
    public long getIdProduto() {
        return idProduto;
    }


    /**
     * Sets the idProduto value for this PassagemDTO.
     * 
     * @param idProduto
     */
    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }


    /**
     * Gets the idPt value for this PassagemDTO.
     * 
     * @return idPt
     */
    public long getIdPt() {
        return idPt;
    }


    /**
     * Sets the idPt value for this PassagemDTO.
     * 
     * @param idPt
     */
    public void setIdPt(long idPt) {
        this.idPt = idPt;
    }


    /**
     * Gets the idTppt value for this PassagemDTO.
     * 
     * @return idTppt
     */
    public long getIdTppt() {
        return idTppt;
    }


    /**
     * Sets the idTppt value for this PassagemDTO.
     * 
     * @param idTppt
     */
    public void setIdTppt(long idTppt) {
        this.idTppt = idTppt;
    }


    /**
     * Gets the idUsr value for this PassagemDTO.
     * 
     * @return idUsr
     */
    public long getIdUsr() {
        return idUsr;
    }


    /**
     * Sets the idUsr value for this PassagemDTO.
     * 
     * @param idUsr
     */
    public void setIdUsr(long idUsr) {
        this.idUsr = idUsr;
    }


    /**
     * Gets the listaAcoes value for this PassagemDTO.
     * 
     * @return listaAcoes
     */
    public idw.idwws.AcaoDTO[] getListaAcoes() {
        return listaAcoes;
    }


    /**
     * Sets the listaAcoes value for this PassagemDTO.
     * 
     * @param listaAcoes
     */
    public void setListaAcoes(idw.idwws.AcaoDTO[] listaAcoes) {
        this.listaAcoes = listaAcoes;
    }

    public idw.idwws.AcaoDTO getListaAcoes(int i) {
        return this.listaAcoes[i];
    }

    public void setListaAcoes(int i, idw.idwws.AcaoDTO _value) {
        this.listaAcoes[i] = _value;
    }


    /**
     * Gets the listaDefeitos value for this PassagemDTO.
     * 
     * @return listaDefeitos
     */
    public idw.idwws.DefeitoDTO[] getListaDefeitos() {
        return listaDefeitos;
    }


    /**
     * Sets the listaDefeitos value for this PassagemDTO.
     * 
     * @param listaDefeitos
     */
    public void setListaDefeitos(idw.idwws.DefeitoDTO[] listaDefeitos) {
        this.listaDefeitos = listaDefeitos;
    }

    public idw.idwws.DefeitoDTO getListaDefeitos(int i) {
        return this.listaDefeitos[i];
    }

    public void setListaDefeitos(int i, idw.idwws.DefeitoDTO _value) {
        this.listaDefeitos[i] = _value;
    }


    /**
     * Gets the listaMontagem value for this PassagemDTO.
     * 
     * @return listaMontagem
     */
    public idw.idwws.MontagemDTO[] getListaMontagem() {
        return listaMontagem;
    }


    /**
     * Sets the listaMontagem value for this PassagemDTO.
     * 
     * @param listaMontagem
     */
    public void setListaMontagem(idw.idwws.MontagemDTO[] listaMontagem) {
        this.listaMontagem = listaMontagem;
    }

    public idw.idwws.MontagemDTO getListaMontagem(int i) {
        return this.listaMontagem[i];
    }

    public void setListaMontagem(int i, idw.idwws.MontagemDTO _value) {
        this.listaMontagem[i] = _value;
    }


    /**
     * Gets the mascaraCdProdutoPai value for this PassagemDTO.
     * 
     * @return mascaraCdProdutoPai
     */
    public java.lang.String getMascaraCdProdutoPai() {
        return mascaraCdProdutoPai;
    }


    /**
     * Sets the mascaraCdProdutoPai value for this PassagemDTO.
     * 
     * @param mascaraCdProdutoPai
     */
    public void setMascaraCdProdutoPai(java.lang.String mascaraCdProdutoPai) {
        this.mascaraCdProdutoPai = mascaraCdProdutoPai;
    }


    /**
     * Gets the naoConformidadesAtuais value for this PassagemDTO.
     * 
     * @return naoConformidadesAtuais
     */
    public idw.idwws.NaoConformidadeDTO[] getNaoConformidadesAtuais() {
        return naoConformidadesAtuais;
    }


    /**
     * Sets the naoConformidadesAtuais value for this PassagemDTO.
     * 
     * @param naoConformidadesAtuais
     */
    public void setNaoConformidadesAtuais(idw.idwws.NaoConformidadeDTO[] naoConformidadesAtuais) {
        this.naoConformidadesAtuais = naoConformidadesAtuais;
    }

    public idw.idwws.NaoConformidadeDTO getNaoConformidadesAtuais(int i) {
        return this.naoConformidadesAtuais[i];
    }

    public void setNaoConformidadesAtuais(int i, idw.idwws.NaoConformidadeDTO _value) {
        this.naoConformidadesAtuais[i] = _value;
    }


    /**
     * Gets the omcfg value for this PassagemDTO.
     * 
     * @return omcfg
     */
    public idw.idwws.OmCfg getOmcfg() {
        return omcfg;
    }


    /**
     * Sets the omcfg value for this PassagemDTO.
     * 
     * @param omcfg
     */
    public void setOmcfg(idw.idwws.OmCfg omcfg) {
        this.omcfg = omcfg;
    }


    /**
     * Gets the passaadiante value for this PassagemDTO.
     * 
     * @return passaadiante
     */
    public boolean isPassaadiante() {
        return passaadiante;
    }


    /**
     * Sets the passaadiante value for this PassagemDTO.
     * 
     * @param passaadiante
     */
    public void setPassaadiante(boolean passaadiante) {
        this.passaadiante = passaadiante;
    }


    /**
     * Gets the reSupervisor value for this PassagemDTO.
     * 
     * @return reSupervisor
     */
    public java.lang.String getReSupervisor() {
        return reSupervisor;
    }


    /**
     * Sets the reSupervisor value for this PassagemDTO.
     * 
     * @param reSupervisor
     */
    public void setReSupervisor(java.lang.String reSupervisor) {
        this.reSupervisor = reSupervisor;
    }


    /**
     * Gets the receitaTeste value for this PassagemDTO.
     * 
     * @return receitaTeste
     */
    public idw.idwws.FolhaDTO getReceitaTeste() {
        return receitaTeste;
    }


    /**
     * Sets the receitaTeste value for this PassagemDTO.
     * 
     * @param receitaTeste
     */
    public void setReceitaTeste(idw.idwws.FolhaDTO receitaTeste) {
        this.receitaTeste = receitaTeste;
    }


    /**
     * Gets the resultado value for this PassagemDTO.
     * 
     * @return resultado
     */
    public idw.idwws.ResultadoDTO getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this PassagemDTO.
     * 
     * @param resultado
     */
    public void setResultado(idw.idwws.ResultadoDTO resultado) {
        this.resultado = resultado;
    }


    /**
     * Gets the resultadoTesteFuncional value for this PassagemDTO.
     * 
     * @return resultadoTesteFuncional
     */
    public idw.idwws.ResultadoTesteDTO getResultadoTesteFuncional() {
        return resultadoTesteFuncional;
    }


    /**
     * Sets the resultadoTesteFuncional value for this PassagemDTO.
     * 
     * @param resultadoTesteFuncional
     */
    public void setResultadoTesteFuncional(idw.idwws.ResultadoTesteDTO resultadoTesteFuncional) {
        this.resultadoTesteFuncional = resultadoTesteFuncional;
    }


    /**
     * Gets the segTempoParafusadeira value for this PassagemDTO.
     * 
     * @return segTempoParafusadeira
     */
    public java.math.BigDecimal getSegTempoParafusadeira() {
        return segTempoParafusadeira;
    }


    /**
     * Sets the segTempoParafusadeira value for this PassagemDTO.
     * 
     * @param segTempoParafusadeira
     */
    public void setSegTempoParafusadeira(java.math.BigDecimal segTempoParafusadeira) {
        this.segTempoParafusadeira = segTempoParafusadeira;
    }


    /**
     * Gets the tppt value for this PassagemDTO.
     * 
     * @return tppt
     */
    public int getTppt() {
        return tppt;
    }


    /**
     * Sets the tppt value for this PassagemDTO.
     * 
     * @param tppt
     */
    public void setTppt(int tppt) {
        this.tppt = tppt;
    }


    /**
     * Gets the tpptAnterioes value for this PassagemDTO.
     * 
     * @return tpptAnterioes
     */
    public java.lang.Integer[] getTpptAnterioes() {
        return tpptAnterioes;
    }


    /**
     * Sets the tpptAnterioes value for this PassagemDTO.
     * 
     * @param tpptAnterioes
     */
    public void setTpptAnterioes(java.lang.Integer[] tpptAnterioes) {
        this.tpptAnterioes = tpptAnterioes;
    }

    public java.lang.Integer getTpptAnterioes(int i) {
        return this.tpptAnterioes[i];
    }

    public void setTpptAnterioes(int i, java.lang.Integer _value) {
        this.tpptAnterioes[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PassagemDTO)) return false;
        PassagemDTO other = (PassagemDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cb==null && other.getCb()==null) || 
             (this.cb!=null &&
              this.cb.equals(other.getCb()))) &&
            this.deveSerPassagemNova == other.isDeveSerPassagemNova() &&
            ((this.dtHrEvento==null && other.getDtHrEvento()==null) || 
             (this.dtHrEvento!=null &&
              this.dtHrEvento.equals(other.getDtHrEvento()))) &&
            ((this.dtHrEventoAnterior==null && other.getDtHrEventoAnterior()==null) || 
             (this.dtHrEventoAnterior!=null &&
              this.dtHrEventoAnterior.equals(other.getDtHrEventoAnterior()))) &&
            ((this.dwfolha==null && other.getDwfolha()==null) || 
             (this.dwfolha!=null &&
              this.dwfolha.equals(other.getDwfolha()))) &&
            ((this.dwnserie==null && other.getDwnserie()==null) || 
             (this.dwnserie!=null &&
              this.dwnserie.equals(other.getDwnserie()))) &&
            ((this.dwrotapasso==null && other.getDwrotapasso()==null) || 
             (this.dwrotapasso!=null &&
              this.dwrotapasso.equals(other.getDwrotapasso()))) &&
            this.enviarRefugo == other.getEnviarRefugo() &&
            this.idFolha == other.getIdFolha() &&
            this.idGrpUsrOperador == other.getIdGrpUsrOperador() &&
            this.idGrpUsrSupervisor == other.getIdGrpUsrSupervisor() &&
            this.idGt == other.getIdGt() &&
            this.idNSerie == other.getIdNSerie() &&
            this.idProduto == other.getIdProduto() &&
            this.idPt == other.getIdPt() &&
            this.idTppt == other.getIdTppt() &&
            this.idUsr == other.getIdUsr() &&
            ((this.listaAcoes==null && other.getListaAcoes()==null) || 
             (this.listaAcoes!=null &&
              java.util.Arrays.equals(this.listaAcoes, other.getListaAcoes()))) &&
            ((this.listaDefeitos==null && other.getListaDefeitos()==null) || 
             (this.listaDefeitos!=null &&
              java.util.Arrays.equals(this.listaDefeitos, other.getListaDefeitos()))) &&
            ((this.listaMontagem==null && other.getListaMontagem()==null) || 
             (this.listaMontagem!=null &&
              java.util.Arrays.equals(this.listaMontagem, other.getListaMontagem()))) &&
            ((this.mascaraCdProdutoPai==null && other.getMascaraCdProdutoPai()==null) || 
             (this.mascaraCdProdutoPai!=null &&
              this.mascaraCdProdutoPai.equals(other.getMascaraCdProdutoPai()))) &&
            ((this.naoConformidadesAtuais==null && other.getNaoConformidadesAtuais()==null) || 
             (this.naoConformidadesAtuais!=null &&
              java.util.Arrays.equals(this.naoConformidadesAtuais, other.getNaoConformidadesAtuais()))) &&
            ((this.omcfg==null && other.getOmcfg()==null) || 
             (this.omcfg!=null &&
              this.omcfg.equals(other.getOmcfg()))) &&
            this.passaadiante == other.isPassaadiante() &&
            ((this.reSupervisor==null && other.getReSupervisor()==null) || 
             (this.reSupervisor!=null &&
              this.reSupervisor.equals(other.getReSupervisor()))) &&
            ((this.receitaTeste==null && other.getReceitaTeste()==null) || 
             (this.receitaTeste!=null &&
              this.receitaTeste.equals(other.getReceitaTeste()))) &&
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado()))) &&
            ((this.resultadoTesteFuncional==null && other.getResultadoTesteFuncional()==null) || 
             (this.resultadoTesteFuncional!=null &&
              this.resultadoTesteFuncional.equals(other.getResultadoTesteFuncional()))) &&
            ((this.segTempoParafusadeira==null && other.getSegTempoParafusadeira()==null) || 
             (this.segTempoParafusadeira!=null &&
              this.segTempoParafusadeira.equals(other.getSegTempoParafusadeira()))) &&
            this.tppt == other.getTppt() &&
            ((this.tpptAnterioes==null && other.getTpptAnterioes()==null) || 
             (this.tpptAnterioes!=null &&
              java.util.Arrays.equals(this.tpptAnterioes, other.getTpptAnterioes())));
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
        if (getCb() != null) {
            _hashCode += getCb().hashCode();
        }
        _hashCode += (isDeveSerPassagemNova() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDtHrEvento() != null) {
            _hashCode += getDtHrEvento().hashCode();
        }
        if (getDtHrEventoAnterior() != null) {
            _hashCode += getDtHrEventoAnterior().hashCode();
        }
        if (getDwfolha() != null) {
            _hashCode += getDwfolha().hashCode();
        }
        if (getDwnserie() != null) {
            _hashCode += getDwnserie().hashCode();
        }
        if (getDwrotapasso() != null) {
            _hashCode += getDwrotapasso().hashCode();
        }
        _hashCode += getEnviarRefugo();
        _hashCode += new Long(getIdFolha()).hashCode();
        _hashCode += new Long(getIdGrpUsrOperador()).hashCode();
        _hashCode += new Long(getIdGrpUsrSupervisor()).hashCode();
        _hashCode += new Long(getIdGt()).hashCode();
        _hashCode += new Long(getIdNSerie()).hashCode();
        _hashCode += new Long(getIdProduto()).hashCode();
        _hashCode += new Long(getIdPt()).hashCode();
        _hashCode += new Long(getIdTppt()).hashCode();
        _hashCode += new Long(getIdUsr()).hashCode();
        if (getListaAcoes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaAcoes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaAcoes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaDefeitos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaDefeitos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaDefeitos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaMontagem() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaMontagem());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaMontagem(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMascaraCdProdutoPai() != null) {
            _hashCode += getMascaraCdProdutoPai().hashCode();
        }
        if (getNaoConformidadesAtuais() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNaoConformidadesAtuais());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNaoConformidadesAtuais(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmcfg() != null) {
            _hashCode += getOmcfg().hashCode();
        }
        _hashCode += (isPassaadiante() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getReSupervisor() != null) {
            _hashCode += getReSupervisor().hashCode();
        }
        if (getReceitaTeste() != null) {
            _hashCode += getReceitaTeste().hashCode();
        }
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        if (getResultadoTesteFuncional() != null) {
            _hashCode += getResultadoTesteFuncional().hashCode();
        }
        if (getSegTempoParafusadeira() != null) {
            _hashCode += getSegTempoParafusadeira().hashCode();
        }
        _hashCode += getTppt();
        if (getTpptAnterioes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTpptAnterioes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTpptAnterioes(), i);
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
        new org.apache.axis.description.TypeDesc(PassagemDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "passagemDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deveSerPassagemNova");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deveSerPassagemNova"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtHrEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtHrEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtHrEventoAnterior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtHrEventoAnterior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwfolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwfolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwnserie");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwnserie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwNserie"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwrotapasso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwrotapasso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRotapasso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enviarRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "enviarRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("idNSerie");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idNSerie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idProduto"));
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
        elemField.setFieldName("listaAcoes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaAcoes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "acaoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaDefeitos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaDefeitos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "defeitoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaMontagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaMontagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "montagemDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mascaraCdProdutoPai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mascaraCdProdutoPai"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("naoConformidadesAtuais");
        elemField.setXmlName(new javax.xml.namespace.QName("", "naoConformidadesAtuais"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "naoConformidadeDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omcfg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omcfg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("passaadiante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "passaadiante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reSupervisor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reSupervisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receitaTeste");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receitaTeste"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "folhaDTO"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("resultadoTesteFuncional");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoTesteFuncional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoTesteDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segTempoParafusadeira");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segTempoParafusadeira"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpptAnterioes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpptAnterioes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
