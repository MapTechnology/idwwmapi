/**
 * MsEvt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MsEvt  extends idw.idwws.MsEvtTemplate  implements java.io.Serializable {
    private java.lang.String cdAcao;

    private java.lang.String cdAlerta;

    private java.lang.String cdCausa;

    private java.lang.String cdComponente;

    private java.lang.String cdConsulta;

    private java.lang.String cdEstrutura;

    private java.lang.String cdFeeder;

    private java.lang.String cdJustificativa;

    private java.lang.String cdMolde;

    private java.lang.String cdNozzle;

    private java.lang.String cdParada;

    private java.lang.String cdProduto;

    private java.lang.String cdProdutoredz;

    private java.lang.String cdRefugo;

    private java.lang.String cdTec1;

    private java.lang.String cdTec2;

    private java.lang.String cdTecresp;

    private java.lang.String depara;

    private java.util.Calendar dthrCadastrobanco;

    private java.util.Calendar dthrCadastroserver;

    private java.util.Calendar dthrEnvioprcoletoreventos;

    private java.util.Calendar dthrEvento;

    private java.util.Calendar dthrEventoanterior;

    private java.util.Calendar dthrIprocessaserver;

    private java.util.Calendar dthrProcessaserver;

    private java.lang.String erroconsol;

    private java.lang.Long idEvt;

    private java.math.BigDecimal idPrcoletoreventos;

    private java.lang.Boolean isRegulagem;

    private java.lang.String login;

    private java.math.BigDecimal miliDuracaoevento;

    private idw.idwws.MsEvt msEvt;

    private idw.idwws.MsEvt[] msEvts;

    private idw.idwws.MsMonitor[] msMonitors;

    private idw.idwws.MsMsicup msMsicup;

    private idw.idwws.MsTpevt msTpevt;

    private idw.idwws.MsUpihm msUpihm;

    private idw.idwws.MsUp[] msUpsForIdEvtiniciociclo;

    private idw.idwws.MsUp[] msUpsForIdEvtinicioparada;

    private java.lang.String nrop;

    private java.lang.String origem;

    private java.lang.Integer qtErromontagem;

    private java.math.BigDecimal qtde;

    private java.math.BigDecimal qtdeCiclos;

    private java.lang.Integer sequencial;

    private java.math.BigDecimal stEvt;

    private java.math.BigDecimal temperatura;

    private java.lang.Integer tpErromontagem;

    public MsEvt() {
    }

    public MsEvt(
           java.lang.String cdAcao,
           java.lang.String cdAlerta,
           java.lang.String cdCausa,
           java.lang.String cdComponente,
           java.lang.String cdConsulta,
           java.lang.String cdEstrutura,
           java.lang.String cdFeeder,
           java.lang.String cdJustificativa,
           java.lang.String cdMolde,
           java.lang.String cdNozzle,
           java.lang.String cdParada,
           java.lang.String cdProduto,
           java.lang.String cdProdutoredz,
           java.lang.String cdRefugo,
           java.lang.String cdTec1,
           java.lang.String cdTec2,
           java.lang.String cdTecresp,
           java.lang.String depara,
           java.util.Calendar dthrCadastrobanco,
           java.util.Calendar dthrCadastroserver,
           java.util.Calendar dthrEnvioprcoletoreventos,
           java.util.Calendar dthrEvento,
           java.util.Calendar dthrEventoanterior,
           java.util.Calendar dthrIprocessaserver,
           java.util.Calendar dthrProcessaserver,
           java.lang.String erroconsol,
           java.lang.Long idEvt,
           java.math.BigDecimal idPrcoletoreventos,
           java.lang.Boolean isRegulagem,
           java.lang.String login,
           java.math.BigDecimal miliDuracaoevento,
           idw.idwws.MsEvt msEvt,
           idw.idwws.MsEvt[] msEvts,
           idw.idwws.MsMonitor[] msMonitors,
           idw.idwws.MsMsicup msMsicup,
           idw.idwws.MsTpevt msTpevt,
           idw.idwws.MsUpihm msUpihm,
           idw.idwws.MsUp[] msUpsForIdEvtiniciociclo,
           idw.idwws.MsUp[] msUpsForIdEvtinicioparada,
           java.lang.String nrop,
           java.lang.String origem,
           java.lang.Integer qtErromontagem,
           java.math.BigDecimal qtde,
           java.math.BigDecimal qtdeCiclos,
           java.lang.Integer sequencial,
           java.math.BigDecimal stEvt,
           java.math.BigDecimal temperatura,
           java.lang.Integer tpErromontagem) {
        this.cdAcao = cdAcao;
        this.cdAlerta = cdAlerta;
        this.cdCausa = cdCausa;
        this.cdComponente = cdComponente;
        this.cdConsulta = cdConsulta;
        this.cdEstrutura = cdEstrutura;
        this.cdFeeder = cdFeeder;
        this.cdJustificativa = cdJustificativa;
        this.cdMolde = cdMolde;
        this.cdNozzle = cdNozzle;
        this.cdParada = cdParada;
        this.cdProduto = cdProduto;
        this.cdProdutoredz = cdProdutoredz;
        this.cdRefugo = cdRefugo;
        this.cdTec1 = cdTec1;
        this.cdTec2 = cdTec2;
        this.cdTecresp = cdTecresp;
        this.depara = depara;
        this.dthrCadastrobanco = dthrCadastrobanco;
        this.dthrCadastroserver = dthrCadastroserver;
        this.dthrEnvioprcoletoreventos = dthrEnvioprcoletoreventos;
        this.dthrEvento = dthrEvento;
        this.dthrEventoanterior = dthrEventoanterior;
        this.dthrIprocessaserver = dthrIprocessaserver;
        this.dthrProcessaserver = dthrProcessaserver;
        this.erroconsol = erroconsol;
        this.idEvt = idEvt;
        this.idPrcoletoreventos = idPrcoletoreventos;
        this.isRegulagem = isRegulagem;
        this.login = login;
        this.miliDuracaoevento = miliDuracaoevento;
        this.msEvt = msEvt;
        this.msEvts = msEvts;
        this.msMonitors = msMonitors;
        this.msMsicup = msMsicup;
        this.msTpevt = msTpevt;
        this.msUpihm = msUpihm;
        this.msUpsForIdEvtiniciociclo = msUpsForIdEvtiniciociclo;
        this.msUpsForIdEvtinicioparada = msUpsForIdEvtinicioparada;
        this.nrop = nrop;
        this.origem = origem;
        this.qtErromontagem = qtErromontagem;
        this.qtde = qtde;
        this.qtdeCiclos = qtdeCiclos;
        this.sequencial = sequencial;
        this.stEvt = stEvt;
        this.temperatura = temperatura;
        this.tpErromontagem = tpErromontagem;
    }


    /**
     * Gets the cdAcao value for this MsEvt.
     * 
     * @return cdAcao
     */
    public java.lang.String getCdAcao() {
        return cdAcao;
    }


    /**
     * Sets the cdAcao value for this MsEvt.
     * 
     * @param cdAcao
     */
    public void setCdAcao(java.lang.String cdAcao) {
        this.cdAcao = cdAcao;
    }


    /**
     * Gets the cdAlerta value for this MsEvt.
     * 
     * @return cdAlerta
     */
    public java.lang.String getCdAlerta() {
        return cdAlerta;
    }


    /**
     * Sets the cdAlerta value for this MsEvt.
     * 
     * @param cdAlerta
     */
    public void setCdAlerta(java.lang.String cdAlerta) {
        this.cdAlerta = cdAlerta;
    }


    /**
     * Gets the cdCausa value for this MsEvt.
     * 
     * @return cdCausa
     */
    public java.lang.String getCdCausa() {
        return cdCausa;
    }


    /**
     * Sets the cdCausa value for this MsEvt.
     * 
     * @param cdCausa
     */
    public void setCdCausa(java.lang.String cdCausa) {
        this.cdCausa = cdCausa;
    }


    /**
     * Gets the cdComponente value for this MsEvt.
     * 
     * @return cdComponente
     */
    public java.lang.String getCdComponente() {
        return cdComponente;
    }


    /**
     * Sets the cdComponente value for this MsEvt.
     * 
     * @param cdComponente
     */
    public void setCdComponente(java.lang.String cdComponente) {
        this.cdComponente = cdComponente;
    }


    /**
     * Gets the cdConsulta value for this MsEvt.
     * 
     * @return cdConsulta
     */
    public java.lang.String getCdConsulta() {
        return cdConsulta;
    }


    /**
     * Sets the cdConsulta value for this MsEvt.
     * 
     * @param cdConsulta
     */
    public void setCdConsulta(java.lang.String cdConsulta) {
        this.cdConsulta = cdConsulta;
    }


    /**
     * Gets the cdEstrutura value for this MsEvt.
     * 
     * @return cdEstrutura
     */
    public java.lang.String getCdEstrutura() {
        return cdEstrutura;
    }


    /**
     * Sets the cdEstrutura value for this MsEvt.
     * 
     * @param cdEstrutura
     */
    public void setCdEstrutura(java.lang.String cdEstrutura) {
        this.cdEstrutura = cdEstrutura;
    }


    /**
     * Gets the cdFeeder value for this MsEvt.
     * 
     * @return cdFeeder
     */
    public java.lang.String getCdFeeder() {
        return cdFeeder;
    }


    /**
     * Sets the cdFeeder value for this MsEvt.
     * 
     * @param cdFeeder
     */
    public void setCdFeeder(java.lang.String cdFeeder) {
        this.cdFeeder = cdFeeder;
    }


    /**
     * Gets the cdJustificativa value for this MsEvt.
     * 
     * @return cdJustificativa
     */
    public java.lang.String getCdJustificativa() {
        return cdJustificativa;
    }


    /**
     * Sets the cdJustificativa value for this MsEvt.
     * 
     * @param cdJustificativa
     */
    public void setCdJustificativa(java.lang.String cdJustificativa) {
        this.cdJustificativa = cdJustificativa;
    }


    /**
     * Gets the cdMolde value for this MsEvt.
     * 
     * @return cdMolde
     */
    public java.lang.String getCdMolde() {
        return cdMolde;
    }


    /**
     * Sets the cdMolde value for this MsEvt.
     * 
     * @param cdMolde
     */
    public void setCdMolde(java.lang.String cdMolde) {
        this.cdMolde = cdMolde;
    }


    /**
     * Gets the cdNozzle value for this MsEvt.
     * 
     * @return cdNozzle
     */
    public java.lang.String getCdNozzle() {
        return cdNozzle;
    }


    /**
     * Sets the cdNozzle value for this MsEvt.
     * 
     * @param cdNozzle
     */
    public void setCdNozzle(java.lang.String cdNozzle) {
        this.cdNozzle = cdNozzle;
    }


    /**
     * Gets the cdParada value for this MsEvt.
     * 
     * @return cdParada
     */
    public java.lang.String getCdParada() {
        return cdParada;
    }


    /**
     * Sets the cdParada value for this MsEvt.
     * 
     * @param cdParada
     */
    public void setCdParada(java.lang.String cdParada) {
        this.cdParada = cdParada;
    }


    /**
     * Gets the cdProduto value for this MsEvt.
     * 
     * @return cdProduto
     */
    public java.lang.String getCdProduto() {
        return cdProduto;
    }


    /**
     * Sets the cdProduto value for this MsEvt.
     * 
     * @param cdProduto
     */
    public void setCdProduto(java.lang.String cdProduto) {
        this.cdProduto = cdProduto;
    }


    /**
     * Gets the cdProdutoredz value for this MsEvt.
     * 
     * @return cdProdutoredz
     */
    public java.lang.String getCdProdutoredz() {
        return cdProdutoredz;
    }


    /**
     * Sets the cdProdutoredz value for this MsEvt.
     * 
     * @param cdProdutoredz
     */
    public void setCdProdutoredz(java.lang.String cdProdutoredz) {
        this.cdProdutoredz = cdProdutoredz;
    }


    /**
     * Gets the cdRefugo value for this MsEvt.
     * 
     * @return cdRefugo
     */
    public java.lang.String getCdRefugo() {
        return cdRefugo;
    }


    /**
     * Sets the cdRefugo value for this MsEvt.
     * 
     * @param cdRefugo
     */
    public void setCdRefugo(java.lang.String cdRefugo) {
        this.cdRefugo = cdRefugo;
    }


    /**
     * Gets the cdTec1 value for this MsEvt.
     * 
     * @return cdTec1
     */
    public java.lang.String getCdTec1() {
        return cdTec1;
    }


    /**
     * Sets the cdTec1 value for this MsEvt.
     * 
     * @param cdTec1
     */
    public void setCdTec1(java.lang.String cdTec1) {
        this.cdTec1 = cdTec1;
    }


    /**
     * Gets the cdTec2 value for this MsEvt.
     * 
     * @return cdTec2
     */
    public java.lang.String getCdTec2() {
        return cdTec2;
    }


    /**
     * Sets the cdTec2 value for this MsEvt.
     * 
     * @param cdTec2
     */
    public void setCdTec2(java.lang.String cdTec2) {
        this.cdTec2 = cdTec2;
    }


    /**
     * Gets the cdTecresp value for this MsEvt.
     * 
     * @return cdTecresp
     */
    public java.lang.String getCdTecresp() {
        return cdTecresp;
    }


    /**
     * Sets the cdTecresp value for this MsEvt.
     * 
     * @param cdTecresp
     */
    public void setCdTecresp(java.lang.String cdTecresp) {
        this.cdTecresp = cdTecresp;
    }


    /**
     * Gets the depara value for this MsEvt.
     * 
     * @return depara
     */
    public java.lang.String getDepara() {
        return depara;
    }


    /**
     * Sets the depara value for this MsEvt.
     * 
     * @param depara
     */
    public void setDepara(java.lang.String depara) {
        this.depara = depara;
    }


    /**
     * Gets the dthrCadastrobanco value for this MsEvt.
     * 
     * @return dthrCadastrobanco
     */
    public java.util.Calendar getDthrCadastrobanco() {
        return dthrCadastrobanco;
    }


    /**
     * Sets the dthrCadastrobanco value for this MsEvt.
     * 
     * @param dthrCadastrobanco
     */
    public void setDthrCadastrobanco(java.util.Calendar dthrCadastrobanco) {
        this.dthrCadastrobanco = dthrCadastrobanco;
    }


    /**
     * Gets the dthrCadastroserver value for this MsEvt.
     * 
     * @return dthrCadastroserver
     */
    public java.util.Calendar getDthrCadastroserver() {
        return dthrCadastroserver;
    }


    /**
     * Sets the dthrCadastroserver value for this MsEvt.
     * 
     * @param dthrCadastroserver
     */
    public void setDthrCadastroserver(java.util.Calendar dthrCadastroserver) {
        this.dthrCadastroserver = dthrCadastroserver;
    }


    /**
     * Gets the dthrEnvioprcoletoreventos value for this MsEvt.
     * 
     * @return dthrEnvioprcoletoreventos
     */
    public java.util.Calendar getDthrEnvioprcoletoreventos() {
        return dthrEnvioprcoletoreventos;
    }


    /**
     * Sets the dthrEnvioprcoletoreventos value for this MsEvt.
     * 
     * @param dthrEnvioprcoletoreventos
     */
    public void setDthrEnvioprcoletoreventos(java.util.Calendar dthrEnvioprcoletoreventos) {
        this.dthrEnvioprcoletoreventos = dthrEnvioprcoletoreventos;
    }


    /**
     * Gets the dthrEvento value for this MsEvt.
     * 
     * @return dthrEvento
     */
    public java.util.Calendar getDthrEvento() {
        return dthrEvento;
    }


    /**
     * Sets the dthrEvento value for this MsEvt.
     * 
     * @param dthrEvento
     */
    public void setDthrEvento(java.util.Calendar dthrEvento) {
        this.dthrEvento = dthrEvento;
    }


    /**
     * Gets the dthrEventoanterior value for this MsEvt.
     * 
     * @return dthrEventoanterior
     */
    public java.util.Calendar getDthrEventoanterior() {
        return dthrEventoanterior;
    }


    /**
     * Sets the dthrEventoanterior value for this MsEvt.
     * 
     * @param dthrEventoanterior
     */
    public void setDthrEventoanterior(java.util.Calendar dthrEventoanterior) {
        this.dthrEventoanterior = dthrEventoanterior;
    }


    /**
     * Gets the dthrIprocessaserver value for this MsEvt.
     * 
     * @return dthrIprocessaserver
     */
    public java.util.Calendar getDthrIprocessaserver() {
        return dthrIprocessaserver;
    }


    /**
     * Sets the dthrIprocessaserver value for this MsEvt.
     * 
     * @param dthrIprocessaserver
     */
    public void setDthrIprocessaserver(java.util.Calendar dthrIprocessaserver) {
        this.dthrIprocessaserver = dthrIprocessaserver;
    }


    /**
     * Gets the dthrProcessaserver value for this MsEvt.
     * 
     * @return dthrProcessaserver
     */
    public java.util.Calendar getDthrProcessaserver() {
        return dthrProcessaserver;
    }


    /**
     * Sets the dthrProcessaserver value for this MsEvt.
     * 
     * @param dthrProcessaserver
     */
    public void setDthrProcessaserver(java.util.Calendar dthrProcessaserver) {
        this.dthrProcessaserver = dthrProcessaserver;
    }


    /**
     * Gets the erroconsol value for this MsEvt.
     * 
     * @return erroconsol
     */
    public java.lang.String getErroconsol() {
        return erroconsol;
    }


    /**
     * Sets the erroconsol value for this MsEvt.
     * 
     * @param erroconsol
     */
    public void setErroconsol(java.lang.String erroconsol) {
        this.erroconsol = erroconsol;
    }


    /**
     * Gets the idEvt value for this MsEvt.
     * 
     * @return idEvt
     */
    public java.lang.Long getIdEvt() {
        return idEvt;
    }


    /**
     * Sets the idEvt value for this MsEvt.
     * 
     * @param idEvt
     */
    public void setIdEvt(java.lang.Long idEvt) {
        this.idEvt = idEvt;
    }


    /**
     * Gets the idPrcoletoreventos value for this MsEvt.
     * 
     * @return idPrcoletoreventos
     */
    public java.math.BigDecimal getIdPrcoletoreventos() {
        return idPrcoletoreventos;
    }


    /**
     * Sets the idPrcoletoreventos value for this MsEvt.
     * 
     * @param idPrcoletoreventos
     */
    public void setIdPrcoletoreventos(java.math.BigDecimal idPrcoletoreventos) {
        this.idPrcoletoreventos = idPrcoletoreventos;
    }


    /**
     * Gets the isRegulagem value for this MsEvt.
     * 
     * @return isRegulagem
     */
    public java.lang.Boolean getIsRegulagem() {
        return isRegulagem;
    }


    /**
     * Sets the isRegulagem value for this MsEvt.
     * 
     * @param isRegulagem
     */
    public void setIsRegulagem(java.lang.Boolean isRegulagem) {
        this.isRegulagem = isRegulagem;
    }


    /**
     * Gets the login value for this MsEvt.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this MsEvt.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the miliDuracaoevento value for this MsEvt.
     * 
     * @return miliDuracaoevento
     */
    public java.math.BigDecimal getMiliDuracaoevento() {
        return miliDuracaoevento;
    }


    /**
     * Sets the miliDuracaoevento value for this MsEvt.
     * 
     * @param miliDuracaoevento
     */
    public void setMiliDuracaoevento(java.math.BigDecimal miliDuracaoevento) {
        this.miliDuracaoevento = miliDuracaoevento;
    }


    /**
     * Gets the msEvt value for this MsEvt.
     * 
     * @return msEvt
     */
    public idw.idwws.MsEvt getMsEvt() {
        return msEvt;
    }


    /**
     * Sets the msEvt value for this MsEvt.
     * 
     * @param msEvt
     */
    public void setMsEvt(idw.idwws.MsEvt msEvt) {
        this.msEvt = msEvt;
    }


    /**
     * Gets the msEvts value for this MsEvt.
     * 
     * @return msEvts
     */
    public idw.idwws.MsEvt[] getMsEvts() {
        return msEvts;
    }


    /**
     * Sets the msEvts value for this MsEvt.
     * 
     * @param msEvts
     */
    public void setMsEvts(idw.idwws.MsEvt[] msEvts) {
        this.msEvts = msEvts;
    }

    public idw.idwws.MsEvt getMsEvts(int i) {
        return this.msEvts[i];
    }

    public void setMsEvts(int i, idw.idwws.MsEvt _value) {
        this.msEvts[i] = _value;
    }


    /**
     * Gets the msMonitors value for this MsEvt.
     * 
     * @return msMonitors
     */
    public idw.idwws.MsMonitor[] getMsMonitors() {
        return msMonitors;
    }


    /**
     * Sets the msMonitors value for this MsEvt.
     * 
     * @param msMonitors
     */
    public void setMsMonitors(idw.idwws.MsMonitor[] msMonitors) {
        this.msMonitors = msMonitors;
    }

    public idw.idwws.MsMonitor getMsMonitors(int i) {
        return this.msMonitors[i];
    }

    public void setMsMonitors(int i, idw.idwws.MsMonitor _value) {
        this.msMonitors[i] = _value;
    }


    /**
     * Gets the msMsicup value for this MsEvt.
     * 
     * @return msMsicup
     */
    public idw.idwws.MsMsicup getMsMsicup() {
        return msMsicup;
    }


    /**
     * Sets the msMsicup value for this MsEvt.
     * 
     * @param msMsicup
     */
    public void setMsMsicup(idw.idwws.MsMsicup msMsicup) {
        this.msMsicup = msMsicup;
    }


    /**
     * Gets the msTpevt value for this MsEvt.
     * 
     * @return msTpevt
     */
    public idw.idwws.MsTpevt getMsTpevt() {
        return msTpevt;
    }


    /**
     * Sets the msTpevt value for this MsEvt.
     * 
     * @param msTpevt
     */
    public void setMsTpevt(idw.idwws.MsTpevt msTpevt) {
        this.msTpevt = msTpevt;
    }


    /**
     * Gets the msUpihm value for this MsEvt.
     * 
     * @return msUpihm
     */
    public idw.idwws.MsUpihm getMsUpihm() {
        return msUpihm;
    }


    /**
     * Sets the msUpihm value for this MsEvt.
     * 
     * @param msUpihm
     */
    public void setMsUpihm(idw.idwws.MsUpihm msUpihm) {
        this.msUpihm = msUpihm;
    }


    /**
     * Gets the msUpsForIdEvtiniciociclo value for this MsEvt.
     * 
     * @return msUpsForIdEvtiniciociclo
     */
    public idw.idwws.MsUp[] getMsUpsForIdEvtiniciociclo() {
        return msUpsForIdEvtiniciociclo;
    }


    /**
     * Sets the msUpsForIdEvtiniciociclo value for this MsEvt.
     * 
     * @param msUpsForIdEvtiniciociclo
     */
    public void setMsUpsForIdEvtiniciociclo(idw.idwws.MsUp[] msUpsForIdEvtiniciociclo) {
        this.msUpsForIdEvtiniciociclo = msUpsForIdEvtiniciociclo;
    }

    public idw.idwws.MsUp getMsUpsForIdEvtiniciociclo(int i) {
        return this.msUpsForIdEvtiniciociclo[i];
    }

    public void setMsUpsForIdEvtiniciociclo(int i, idw.idwws.MsUp _value) {
        this.msUpsForIdEvtiniciociclo[i] = _value;
    }


    /**
     * Gets the msUpsForIdEvtinicioparada value for this MsEvt.
     * 
     * @return msUpsForIdEvtinicioparada
     */
    public idw.idwws.MsUp[] getMsUpsForIdEvtinicioparada() {
        return msUpsForIdEvtinicioparada;
    }


    /**
     * Sets the msUpsForIdEvtinicioparada value for this MsEvt.
     * 
     * @param msUpsForIdEvtinicioparada
     */
    public void setMsUpsForIdEvtinicioparada(idw.idwws.MsUp[] msUpsForIdEvtinicioparada) {
        this.msUpsForIdEvtinicioparada = msUpsForIdEvtinicioparada;
    }

    public idw.idwws.MsUp getMsUpsForIdEvtinicioparada(int i) {
        return this.msUpsForIdEvtinicioparada[i];
    }

    public void setMsUpsForIdEvtinicioparada(int i, idw.idwws.MsUp _value) {
        this.msUpsForIdEvtinicioparada[i] = _value;
    }


    /**
     * Gets the nrop value for this MsEvt.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this MsEvt.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }


    /**
     * Gets the origem value for this MsEvt.
     * 
     * @return origem
     */
    public java.lang.String getOrigem() {
        return origem;
    }


    /**
     * Sets the origem value for this MsEvt.
     * 
     * @param origem
     */
    public void setOrigem(java.lang.String origem) {
        this.origem = origem;
    }


    /**
     * Gets the qtErromontagem value for this MsEvt.
     * 
     * @return qtErromontagem
     */
    public java.lang.Integer getQtErromontagem() {
        return qtErromontagem;
    }


    /**
     * Sets the qtErromontagem value for this MsEvt.
     * 
     * @param qtErromontagem
     */
    public void setQtErromontagem(java.lang.Integer qtErromontagem) {
        this.qtErromontagem = qtErromontagem;
    }


    /**
     * Gets the qtde value for this MsEvt.
     * 
     * @return qtde
     */
    public java.math.BigDecimal getQtde() {
        return qtde;
    }


    /**
     * Sets the qtde value for this MsEvt.
     * 
     * @param qtde
     */
    public void setQtde(java.math.BigDecimal qtde) {
        this.qtde = qtde;
    }


    /**
     * Gets the qtdeCiclos value for this MsEvt.
     * 
     * @return qtdeCiclos
     */
    public java.math.BigDecimal getQtdeCiclos() {
        return qtdeCiclos;
    }


    /**
     * Sets the qtdeCiclos value for this MsEvt.
     * 
     * @param qtdeCiclos
     */
    public void setQtdeCiclos(java.math.BigDecimal qtdeCiclos) {
        this.qtdeCiclos = qtdeCiclos;
    }


    /**
     * Gets the sequencial value for this MsEvt.
     * 
     * @return sequencial
     */
    public java.lang.Integer getSequencial() {
        return sequencial;
    }


    /**
     * Sets the sequencial value for this MsEvt.
     * 
     * @param sequencial
     */
    public void setSequencial(java.lang.Integer sequencial) {
        this.sequencial = sequencial;
    }


    /**
     * Gets the stEvt value for this MsEvt.
     * 
     * @return stEvt
     */
    public java.math.BigDecimal getStEvt() {
        return stEvt;
    }


    /**
     * Sets the stEvt value for this MsEvt.
     * 
     * @param stEvt
     */
    public void setStEvt(java.math.BigDecimal stEvt) {
        this.stEvt = stEvt;
    }


    /**
     * Gets the temperatura value for this MsEvt.
     * 
     * @return temperatura
     */
    public java.math.BigDecimal getTemperatura() {
        return temperatura;
    }


    /**
     * Sets the temperatura value for this MsEvt.
     * 
     * @param temperatura
     */
    public void setTemperatura(java.math.BigDecimal temperatura) {
        this.temperatura = temperatura;
    }


    /**
     * Gets the tpErromontagem value for this MsEvt.
     * 
     * @return tpErromontagem
     */
    public java.lang.Integer getTpErromontagem() {
        return tpErromontagem;
    }


    /**
     * Sets the tpErromontagem value for this MsEvt.
     * 
     * @param tpErromontagem
     */
    public void setTpErromontagem(java.lang.Integer tpErromontagem) {
        this.tpErromontagem = tpErromontagem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MsEvt)) return false;
        MsEvt other = (MsEvt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdAcao==null && other.getCdAcao()==null) || 
             (this.cdAcao!=null &&
              this.cdAcao.equals(other.getCdAcao()))) &&
            ((this.cdAlerta==null && other.getCdAlerta()==null) || 
             (this.cdAlerta!=null &&
              this.cdAlerta.equals(other.getCdAlerta()))) &&
            ((this.cdCausa==null && other.getCdCausa()==null) || 
             (this.cdCausa!=null &&
              this.cdCausa.equals(other.getCdCausa()))) &&
            ((this.cdComponente==null && other.getCdComponente()==null) || 
             (this.cdComponente!=null &&
              this.cdComponente.equals(other.getCdComponente()))) &&
            ((this.cdConsulta==null && other.getCdConsulta()==null) || 
             (this.cdConsulta!=null &&
              this.cdConsulta.equals(other.getCdConsulta()))) &&
            ((this.cdEstrutura==null && other.getCdEstrutura()==null) || 
             (this.cdEstrutura!=null &&
              this.cdEstrutura.equals(other.getCdEstrutura()))) &&
            ((this.cdFeeder==null && other.getCdFeeder()==null) || 
             (this.cdFeeder!=null &&
              this.cdFeeder.equals(other.getCdFeeder()))) &&
            ((this.cdJustificativa==null && other.getCdJustificativa()==null) || 
             (this.cdJustificativa!=null &&
              this.cdJustificativa.equals(other.getCdJustificativa()))) &&
            ((this.cdMolde==null && other.getCdMolde()==null) || 
             (this.cdMolde!=null &&
              this.cdMolde.equals(other.getCdMolde()))) &&
            ((this.cdNozzle==null && other.getCdNozzle()==null) || 
             (this.cdNozzle!=null &&
              this.cdNozzle.equals(other.getCdNozzle()))) &&
            ((this.cdParada==null && other.getCdParada()==null) || 
             (this.cdParada!=null &&
              this.cdParada.equals(other.getCdParada()))) &&
            ((this.cdProduto==null && other.getCdProduto()==null) || 
             (this.cdProduto!=null &&
              this.cdProduto.equals(other.getCdProduto()))) &&
            ((this.cdProdutoredz==null && other.getCdProdutoredz()==null) || 
             (this.cdProdutoredz!=null &&
              this.cdProdutoredz.equals(other.getCdProdutoredz()))) &&
            ((this.cdRefugo==null && other.getCdRefugo()==null) || 
             (this.cdRefugo!=null &&
              this.cdRefugo.equals(other.getCdRefugo()))) &&
            ((this.cdTec1==null && other.getCdTec1()==null) || 
             (this.cdTec1!=null &&
              this.cdTec1.equals(other.getCdTec1()))) &&
            ((this.cdTec2==null && other.getCdTec2()==null) || 
             (this.cdTec2!=null &&
              this.cdTec2.equals(other.getCdTec2()))) &&
            ((this.cdTecresp==null && other.getCdTecresp()==null) || 
             (this.cdTecresp!=null &&
              this.cdTecresp.equals(other.getCdTecresp()))) &&
            ((this.depara==null && other.getDepara()==null) || 
             (this.depara!=null &&
              this.depara.equals(other.getDepara()))) &&
            ((this.dthrCadastrobanco==null && other.getDthrCadastrobanco()==null) || 
             (this.dthrCadastrobanco!=null &&
              this.dthrCadastrobanco.equals(other.getDthrCadastrobanco()))) &&
            ((this.dthrCadastroserver==null && other.getDthrCadastroserver()==null) || 
             (this.dthrCadastroserver!=null &&
              this.dthrCadastroserver.equals(other.getDthrCadastroserver()))) &&
            ((this.dthrEnvioprcoletoreventos==null && other.getDthrEnvioprcoletoreventos()==null) || 
             (this.dthrEnvioprcoletoreventos!=null &&
              this.dthrEnvioprcoletoreventos.equals(other.getDthrEnvioprcoletoreventos()))) &&
            ((this.dthrEvento==null && other.getDthrEvento()==null) || 
             (this.dthrEvento!=null &&
              this.dthrEvento.equals(other.getDthrEvento()))) &&
            ((this.dthrEventoanterior==null && other.getDthrEventoanterior()==null) || 
             (this.dthrEventoanterior!=null &&
              this.dthrEventoanterior.equals(other.getDthrEventoanterior()))) &&
            ((this.dthrIprocessaserver==null && other.getDthrIprocessaserver()==null) || 
             (this.dthrIprocessaserver!=null &&
              this.dthrIprocessaserver.equals(other.getDthrIprocessaserver()))) &&
            ((this.dthrProcessaserver==null && other.getDthrProcessaserver()==null) || 
             (this.dthrProcessaserver!=null &&
              this.dthrProcessaserver.equals(other.getDthrProcessaserver()))) &&
            ((this.erroconsol==null && other.getErroconsol()==null) || 
             (this.erroconsol!=null &&
              this.erroconsol.equals(other.getErroconsol()))) &&
            ((this.idEvt==null && other.getIdEvt()==null) || 
             (this.idEvt!=null &&
              this.idEvt.equals(other.getIdEvt()))) &&
            ((this.idPrcoletoreventos==null && other.getIdPrcoletoreventos()==null) || 
             (this.idPrcoletoreventos!=null &&
              this.idPrcoletoreventos.equals(other.getIdPrcoletoreventos()))) &&
            ((this.isRegulagem==null && other.getIsRegulagem()==null) || 
             (this.isRegulagem!=null &&
              this.isRegulagem.equals(other.getIsRegulagem()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.miliDuracaoevento==null && other.getMiliDuracaoevento()==null) || 
             (this.miliDuracaoevento!=null &&
              this.miliDuracaoevento.equals(other.getMiliDuracaoevento()))) &&
            ((this.msEvt==null && other.getMsEvt()==null) || 
             (this.msEvt!=null &&
              this.msEvt.equals(other.getMsEvt()))) &&
            ((this.msEvts==null && other.getMsEvts()==null) || 
             (this.msEvts!=null &&
              java.util.Arrays.equals(this.msEvts, other.getMsEvts()))) &&
            ((this.msMonitors==null && other.getMsMonitors()==null) || 
             (this.msMonitors!=null &&
              java.util.Arrays.equals(this.msMonitors, other.getMsMonitors()))) &&
            ((this.msMsicup==null && other.getMsMsicup()==null) || 
             (this.msMsicup!=null &&
              this.msMsicup.equals(other.getMsMsicup()))) &&
            ((this.msTpevt==null && other.getMsTpevt()==null) || 
             (this.msTpevt!=null &&
              this.msTpevt.equals(other.getMsTpevt()))) &&
            ((this.msUpihm==null && other.getMsUpihm()==null) || 
             (this.msUpihm!=null &&
              this.msUpihm.equals(other.getMsUpihm()))) &&
            ((this.msUpsForIdEvtiniciociclo==null && other.getMsUpsForIdEvtiniciociclo()==null) || 
             (this.msUpsForIdEvtiniciociclo!=null &&
              java.util.Arrays.equals(this.msUpsForIdEvtiniciociclo, other.getMsUpsForIdEvtiniciociclo()))) &&
            ((this.msUpsForIdEvtinicioparada==null && other.getMsUpsForIdEvtinicioparada()==null) || 
             (this.msUpsForIdEvtinicioparada!=null &&
              java.util.Arrays.equals(this.msUpsForIdEvtinicioparada, other.getMsUpsForIdEvtinicioparada()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop()))) &&
            ((this.origem==null && other.getOrigem()==null) || 
             (this.origem!=null &&
              this.origem.equals(other.getOrigem()))) &&
            ((this.qtErromontagem==null && other.getQtErromontagem()==null) || 
             (this.qtErromontagem!=null &&
              this.qtErromontagem.equals(other.getQtErromontagem()))) &&
            ((this.qtde==null && other.getQtde()==null) || 
             (this.qtde!=null &&
              this.qtde.equals(other.getQtde()))) &&
            ((this.qtdeCiclos==null && other.getQtdeCiclos()==null) || 
             (this.qtdeCiclos!=null &&
              this.qtdeCiclos.equals(other.getQtdeCiclos()))) &&
            ((this.sequencial==null && other.getSequencial()==null) || 
             (this.sequencial!=null &&
              this.sequencial.equals(other.getSequencial()))) &&
            ((this.stEvt==null && other.getStEvt()==null) || 
             (this.stEvt!=null &&
              this.stEvt.equals(other.getStEvt()))) &&
            ((this.temperatura==null && other.getTemperatura()==null) || 
             (this.temperatura!=null &&
              this.temperatura.equals(other.getTemperatura()))) &&
            ((this.tpErromontagem==null && other.getTpErromontagem()==null) || 
             (this.tpErromontagem!=null &&
              this.tpErromontagem.equals(other.getTpErromontagem())));
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
        if (getCdAcao() != null) {
            _hashCode += getCdAcao().hashCode();
        }
        if (getCdAlerta() != null) {
            _hashCode += getCdAlerta().hashCode();
        }
        if (getCdCausa() != null) {
            _hashCode += getCdCausa().hashCode();
        }
        if (getCdComponente() != null) {
            _hashCode += getCdComponente().hashCode();
        }
        if (getCdConsulta() != null) {
            _hashCode += getCdConsulta().hashCode();
        }
        if (getCdEstrutura() != null) {
            _hashCode += getCdEstrutura().hashCode();
        }
        if (getCdFeeder() != null) {
            _hashCode += getCdFeeder().hashCode();
        }
        if (getCdJustificativa() != null) {
            _hashCode += getCdJustificativa().hashCode();
        }
        if (getCdMolde() != null) {
            _hashCode += getCdMolde().hashCode();
        }
        if (getCdNozzle() != null) {
            _hashCode += getCdNozzle().hashCode();
        }
        if (getCdParada() != null) {
            _hashCode += getCdParada().hashCode();
        }
        if (getCdProduto() != null) {
            _hashCode += getCdProduto().hashCode();
        }
        if (getCdProdutoredz() != null) {
            _hashCode += getCdProdutoredz().hashCode();
        }
        if (getCdRefugo() != null) {
            _hashCode += getCdRefugo().hashCode();
        }
        if (getCdTec1() != null) {
            _hashCode += getCdTec1().hashCode();
        }
        if (getCdTec2() != null) {
            _hashCode += getCdTec2().hashCode();
        }
        if (getCdTecresp() != null) {
            _hashCode += getCdTecresp().hashCode();
        }
        if (getDepara() != null) {
            _hashCode += getDepara().hashCode();
        }
        if (getDthrCadastrobanco() != null) {
            _hashCode += getDthrCadastrobanco().hashCode();
        }
        if (getDthrCadastroserver() != null) {
            _hashCode += getDthrCadastroserver().hashCode();
        }
        if (getDthrEnvioprcoletoreventos() != null) {
            _hashCode += getDthrEnvioprcoletoreventos().hashCode();
        }
        if (getDthrEvento() != null) {
            _hashCode += getDthrEvento().hashCode();
        }
        if (getDthrEventoanterior() != null) {
            _hashCode += getDthrEventoanterior().hashCode();
        }
        if (getDthrIprocessaserver() != null) {
            _hashCode += getDthrIprocessaserver().hashCode();
        }
        if (getDthrProcessaserver() != null) {
            _hashCode += getDthrProcessaserver().hashCode();
        }
        if (getErroconsol() != null) {
            _hashCode += getErroconsol().hashCode();
        }
        if (getIdEvt() != null) {
            _hashCode += getIdEvt().hashCode();
        }
        if (getIdPrcoletoreventos() != null) {
            _hashCode += getIdPrcoletoreventos().hashCode();
        }
        if (getIsRegulagem() != null) {
            _hashCode += getIsRegulagem().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getMiliDuracaoevento() != null) {
            _hashCode += getMiliDuracaoevento().hashCode();
        }
        if (getMsEvt() != null) {
            _hashCode += getMsEvt().hashCode();
        }
        if (getMsEvts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMsEvts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMsEvts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMsMonitors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMsMonitors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMsMonitors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMsMsicup() != null) {
            _hashCode += getMsMsicup().hashCode();
        }
        if (getMsTpevt() != null) {
            _hashCode += getMsTpevt().hashCode();
        }
        if (getMsUpihm() != null) {
            _hashCode += getMsUpihm().hashCode();
        }
        if (getMsUpsForIdEvtiniciociclo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMsUpsForIdEvtiniciociclo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMsUpsForIdEvtiniciociclo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMsUpsForIdEvtinicioparada() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMsUpsForIdEvtinicioparada());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMsUpsForIdEvtinicioparada(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        if (getOrigem() != null) {
            _hashCode += getOrigem().hashCode();
        }
        if (getQtErromontagem() != null) {
            _hashCode += getQtErromontagem().hashCode();
        }
        if (getQtde() != null) {
            _hashCode += getQtde().hashCode();
        }
        if (getQtdeCiclos() != null) {
            _hashCode += getQtdeCiclos().hashCode();
        }
        if (getSequencial() != null) {
            _hashCode += getSequencial().hashCode();
        }
        if (getStEvt() != null) {
            _hashCode += getStEvt().hashCode();
        }
        if (getTemperatura() != null) {
            _hashCode += getTemperatura().hashCode();
        }
        if (getTpErromontagem() != null) {
            _hashCode += getTpErromontagem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MsEvt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msEvt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdAcao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdAcao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdAlerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdAlerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdCausa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdCausa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdComponente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdComponente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdConsulta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdConsulta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdEstrutura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdEstrutura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdFeeder");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdFeeder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdJustificativa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdJustificativa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdMolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdMolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdNozzle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdNozzle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdProdutoredz");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdProdutoredz"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdTec1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdTec1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdTec2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdTec2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdTecresp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdTecresp"));
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
        elemField.setFieldName("dthrCadastrobanco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrCadastrobanco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrCadastroserver");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrCadastroserver"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrEnvioprcoletoreventos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrEnvioprcoletoreventos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrEventoanterior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrEventoanterior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIprocessaserver");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIprocessaserver"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrProcessaserver");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrProcessaserver"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("erroconsol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "erroconsol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPrcoletoreventos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPrcoletoreventos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isRegulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isRegulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("", "login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("miliDuracaoevento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "miliDuracaoevento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msEvt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msEvts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msEvts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msEvt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msMonitors");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msMonitors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msMonitor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msMsicup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msMsicup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msMsicup"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msTpevt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msTpevt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msTpevt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msUpihm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msUpihm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msUpihm"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msUpsForIdEvtiniciociclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msUpsForIdEvtiniciociclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msUp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msUpsForIdEvtinicioparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msUpsForIdEvtinicioparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msUp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("origem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "origem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtErromontagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtErromontagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdeCiclos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdeCiclos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sequencial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sequencial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temperatura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temperatura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpErromontagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpErromontagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
