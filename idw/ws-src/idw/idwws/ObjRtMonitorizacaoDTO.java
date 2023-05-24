/**
 * ObjRtMonitorizacaoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ObjRtMonitorizacaoDTO  implements java.io.Serializable {
    private boolean alertaVidaUtil;

    private java.lang.String areaResponsavel;

    private idw.idwws.ColorDTO COR_FUNDO_DENTRO_META;

    private idw.idwws.ColorDTO COR_FUNDO_FORA_META;

    private idw.idwws.ColorDTO COR_FUNDO_OFFLINE;

    private idw.idwws.ColorDTO COR_FUNDO_PARADA;

    private java.lang.String cdCp;

    private java.lang.String cdFolha;

    private java.lang.String cdGt;

    private java.lang.String cdProduto;

    private java.lang.String cdPt;

    private boolean comAlerta;

    private boolean consolidacaoEmAtraso;

    private idw.idwws.ColorDTO corFundo;

    private boolean dentroDaMeta;

    private java.lang.String dsFolha;

    private java.lang.String dsGt;

    private java.lang.String dsProduto;

    private java.lang.String dsPt;

    private java.lang.String dsTurno;

    private java.util.Calendar dtReferencia;

    private java.lang.String duracaoParada;

    private idw.idwws.DwConsolmolog[] dwConsolmologs;

    private java.lang.Double efiCiclos;

    private java.lang.Double efiInstantanea;

    private java.lang.Double efiRealizacao;

    private int filtroIndicadorLabel;

    private java.util.Calendar fimParada;

    private boolean gargaloDinamico;

    private boolean gargaloTeorico;

    private java.lang.Long idCp;

    private long idDwConsolId;

    private long idGt;

    private long idPt;

    private long idTurno;

    private long idtppt;

    private java.lang.Double indOEE;

    private java.lang.Double indiceCavAtivas;

    private java.lang.Double indiceParadas;

    private java.lang.Double indiceProducao;

    private boolean indiceRefugo3PorCento;

    private java.lang.Double indiceRefugos;

    private java.util.Calendar iniParada;

    private boolean manutencaoPrev;

    private java.lang.Double metaInstatanea;

    private boolean offline;

    private boolean opConcluida;

    private boolean opConcluida90PorCento;

    private boolean parada;

    private boolean paradaComPeso;

    private boolean paradaManutencao;

    private boolean paradaNaoInformada;

    private boolean paradaSemPesoEfic;

    private boolean perdaSincronismo;

    private java.lang.Double producaoLiquida;

    private java.lang.Double produtividadeOEE;

    private boolean saidaDaCelula;

    private boolean temDwRt;

    private boolean temOmAlgocor;

    private boolean temOmCfg;

    private boolean temOperador;

    private boolean temPlanejamento;

    private boolean temperaturaZonaActInf;

    private boolean temperaturaZonaActSup;

    private boolean temperaturaZonaCritInf;

    private boolean temperaturaZonaCritSup;

    private boolean temperaturaZonaIdeal;

    private int tipoAlgoritmo;

    private int tipoGT;

    private int tipoObj;

    private int tipoPT;

    private java.lang.String ultimaOp;

    private java.lang.String ultimaParada;

    private java.lang.Double ultimaTemperaturaLida;

    private java.lang.String ultimoMolde;

    private java.lang.String urlImg;

    private java.lang.Double x;

    private java.lang.Double x2;

    private java.lang.Double y;

    private java.lang.Double y2;

    public ObjRtMonitorizacaoDTO() {
    }

    public ObjRtMonitorizacaoDTO(
           boolean alertaVidaUtil,
           java.lang.String areaResponsavel,
           idw.idwws.ColorDTO COR_FUNDO_DENTRO_META,
           idw.idwws.ColorDTO COR_FUNDO_FORA_META,
           idw.idwws.ColorDTO COR_FUNDO_OFFLINE,
           idw.idwws.ColorDTO COR_FUNDO_PARADA,
           java.lang.String cdCp,
           java.lang.String cdFolha,
           java.lang.String cdGt,
           java.lang.String cdProduto,
           java.lang.String cdPt,
           boolean comAlerta,
           boolean consolidacaoEmAtraso,
           idw.idwws.ColorDTO corFundo,
           boolean dentroDaMeta,
           java.lang.String dsFolha,
           java.lang.String dsGt,
           java.lang.String dsProduto,
           java.lang.String dsPt,
           java.lang.String dsTurno,
           java.util.Calendar dtReferencia,
           java.lang.String duracaoParada,
           idw.idwws.DwConsolmolog[] dwConsolmologs,
           java.lang.Double efiCiclos,
           java.lang.Double efiInstantanea,
           java.lang.Double efiRealizacao,
           int filtroIndicadorLabel,
           java.util.Calendar fimParada,
           boolean gargaloDinamico,
           boolean gargaloTeorico,
           java.lang.Long idCp,
           long idDwConsolId,
           long idGt,
           long idPt,
           long idTurno,
           long idtppt,
           java.lang.Double indOEE,
           java.lang.Double indiceCavAtivas,
           java.lang.Double indiceParadas,
           java.lang.Double indiceProducao,
           boolean indiceRefugo3PorCento,
           java.lang.Double indiceRefugos,
           java.util.Calendar iniParada,
           boolean manutencaoPrev,
           java.lang.Double metaInstatanea,
           boolean offline,
           boolean opConcluida,
           boolean opConcluida90PorCento,
           boolean parada,
           boolean paradaComPeso,
           boolean paradaManutencao,
           boolean paradaNaoInformada,
           boolean paradaSemPesoEfic,
           boolean perdaSincronismo,
           java.lang.Double producaoLiquida,
           java.lang.Double produtividadeOEE,
           boolean saidaDaCelula,
           boolean temDwRt,
           boolean temOmAlgocor,
           boolean temOmCfg,
           boolean temOperador,
           boolean temPlanejamento,
           boolean temperaturaZonaActInf,
           boolean temperaturaZonaActSup,
           boolean temperaturaZonaCritInf,
           boolean temperaturaZonaCritSup,
           boolean temperaturaZonaIdeal,
           int tipoAlgoritmo,
           int tipoGT,
           int tipoObj,
           int tipoPT,
           java.lang.String ultimaOp,
           java.lang.String ultimaParada,
           java.lang.Double ultimaTemperaturaLida,
           java.lang.String ultimoMolde,
           java.lang.String urlImg,
           java.lang.Double x,
           java.lang.Double x2,
           java.lang.Double y,
           java.lang.Double y2) {
           this.alertaVidaUtil = alertaVidaUtil;
           this.areaResponsavel = areaResponsavel;
           this.COR_FUNDO_DENTRO_META = COR_FUNDO_DENTRO_META;
           this.COR_FUNDO_FORA_META = COR_FUNDO_FORA_META;
           this.COR_FUNDO_OFFLINE = COR_FUNDO_OFFLINE;
           this.COR_FUNDO_PARADA = COR_FUNDO_PARADA;
           this.cdCp = cdCp;
           this.cdFolha = cdFolha;
           this.cdGt = cdGt;
           this.cdProduto = cdProduto;
           this.cdPt = cdPt;
           this.comAlerta = comAlerta;
           this.consolidacaoEmAtraso = consolidacaoEmAtraso;
           this.corFundo = corFundo;
           this.dentroDaMeta = dentroDaMeta;
           this.dsFolha = dsFolha;
           this.dsGt = dsGt;
           this.dsProduto = dsProduto;
           this.dsPt = dsPt;
           this.dsTurno = dsTurno;
           this.dtReferencia = dtReferencia;
           this.duracaoParada = duracaoParada;
           this.dwConsolmologs = dwConsolmologs;
           this.efiCiclos = efiCiclos;
           this.efiInstantanea = efiInstantanea;
           this.efiRealizacao = efiRealizacao;
           this.filtroIndicadorLabel = filtroIndicadorLabel;
           this.fimParada = fimParada;
           this.gargaloDinamico = gargaloDinamico;
           this.gargaloTeorico = gargaloTeorico;
           this.idCp = idCp;
           this.idDwConsolId = idDwConsolId;
           this.idGt = idGt;
           this.idPt = idPt;
           this.idTurno = idTurno;
           this.idtppt = idtppt;
           this.indOEE = indOEE;
           this.indiceCavAtivas = indiceCavAtivas;
           this.indiceParadas = indiceParadas;
           this.indiceProducao = indiceProducao;
           this.indiceRefugo3PorCento = indiceRefugo3PorCento;
           this.indiceRefugos = indiceRefugos;
           this.iniParada = iniParada;
           this.manutencaoPrev = manutencaoPrev;
           this.metaInstatanea = metaInstatanea;
           this.offline = offline;
           this.opConcluida = opConcluida;
           this.opConcluida90PorCento = opConcluida90PorCento;
           this.parada = parada;
           this.paradaComPeso = paradaComPeso;
           this.paradaManutencao = paradaManutencao;
           this.paradaNaoInformada = paradaNaoInformada;
           this.paradaSemPesoEfic = paradaSemPesoEfic;
           this.perdaSincronismo = perdaSincronismo;
           this.producaoLiquida = producaoLiquida;
           this.produtividadeOEE = produtividadeOEE;
           this.saidaDaCelula = saidaDaCelula;
           this.temDwRt = temDwRt;
           this.temOmAlgocor = temOmAlgocor;
           this.temOmCfg = temOmCfg;
           this.temOperador = temOperador;
           this.temPlanejamento = temPlanejamento;
           this.temperaturaZonaActInf = temperaturaZonaActInf;
           this.temperaturaZonaActSup = temperaturaZonaActSup;
           this.temperaturaZonaCritInf = temperaturaZonaCritInf;
           this.temperaturaZonaCritSup = temperaturaZonaCritSup;
           this.temperaturaZonaIdeal = temperaturaZonaIdeal;
           this.tipoAlgoritmo = tipoAlgoritmo;
           this.tipoGT = tipoGT;
           this.tipoObj = tipoObj;
           this.tipoPT = tipoPT;
           this.ultimaOp = ultimaOp;
           this.ultimaParada = ultimaParada;
           this.ultimaTemperaturaLida = ultimaTemperaturaLida;
           this.ultimoMolde = ultimoMolde;
           this.urlImg = urlImg;
           this.x = x;
           this.x2 = x2;
           this.y = y;
           this.y2 = y2;
    }


    /**
     * Gets the alertaVidaUtil value for this ObjRtMonitorizacaoDTO.
     * 
     * @return alertaVidaUtil
     */
    public boolean isAlertaVidaUtil() {
        return alertaVidaUtil;
    }


    /**
     * Sets the alertaVidaUtil value for this ObjRtMonitorizacaoDTO.
     * 
     * @param alertaVidaUtil
     */
    public void setAlertaVidaUtil(boolean alertaVidaUtil) {
        this.alertaVidaUtil = alertaVidaUtil;
    }


    /**
     * Gets the areaResponsavel value for this ObjRtMonitorizacaoDTO.
     * 
     * @return areaResponsavel
     */
    public java.lang.String getAreaResponsavel() {
        return areaResponsavel;
    }


    /**
     * Sets the areaResponsavel value for this ObjRtMonitorizacaoDTO.
     * 
     * @param areaResponsavel
     */
    public void setAreaResponsavel(java.lang.String areaResponsavel) {
        this.areaResponsavel = areaResponsavel;
    }


    /**
     * Gets the COR_FUNDO_DENTRO_META value for this ObjRtMonitorizacaoDTO.
     * 
     * @return COR_FUNDO_DENTRO_META
     */
    public idw.idwws.ColorDTO getCOR_FUNDO_DENTRO_META() {
        return COR_FUNDO_DENTRO_META;
    }


    /**
     * Sets the COR_FUNDO_DENTRO_META value for this ObjRtMonitorizacaoDTO.
     * 
     * @param COR_FUNDO_DENTRO_META
     */
    public void setCOR_FUNDO_DENTRO_META(idw.idwws.ColorDTO COR_FUNDO_DENTRO_META) {
        this.COR_FUNDO_DENTRO_META = COR_FUNDO_DENTRO_META;
    }


    /**
     * Gets the COR_FUNDO_FORA_META value for this ObjRtMonitorizacaoDTO.
     * 
     * @return COR_FUNDO_FORA_META
     */
    public idw.idwws.ColorDTO getCOR_FUNDO_FORA_META() {
        return COR_FUNDO_FORA_META;
    }


    /**
     * Sets the COR_FUNDO_FORA_META value for this ObjRtMonitorizacaoDTO.
     * 
     * @param COR_FUNDO_FORA_META
     */
    public void setCOR_FUNDO_FORA_META(idw.idwws.ColorDTO COR_FUNDO_FORA_META) {
        this.COR_FUNDO_FORA_META = COR_FUNDO_FORA_META;
    }


    /**
     * Gets the COR_FUNDO_OFFLINE value for this ObjRtMonitorizacaoDTO.
     * 
     * @return COR_FUNDO_OFFLINE
     */
    public idw.idwws.ColorDTO getCOR_FUNDO_OFFLINE() {
        return COR_FUNDO_OFFLINE;
    }


    /**
     * Sets the COR_FUNDO_OFFLINE value for this ObjRtMonitorizacaoDTO.
     * 
     * @param COR_FUNDO_OFFLINE
     */
    public void setCOR_FUNDO_OFFLINE(idw.idwws.ColorDTO COR_FUNDO_OFFLINE) {
        this.COR_FUNDO_OFFLINE = COR_FUNDO_OFFLINE;
    }


    /**
     * Gets the COR_FUNDO_PARADA value for this ObjRtMonitorizacaoDTO.
     * 
     * @return COR_FUNDO_PARADA
     */
    public idw.idwws.ColorDTO getCOR_FUNDO_PARADA() {
        return COR_FUNDO_PARADA;
    }


    /**
     * Sets the COR_FUNDO_PARADA value for this ObjRtMonitorizacaoDTO.
     * 
     * @param COR_FUNDO_PARADA
     */
    public void setCOR_FUNDO_PARADA(idw.idwws.ColorDTO COR_FUNDO_PARADA) {
        this.COR_FUNDO_PARADA = COR_FUNDO_PARADA;
    }


    /**
     * Gets the cdCp value for this ObjRtMonitorizacaoDTO.
     * 
     * @return cdCp
     */
    public java.lang.String getCdCp() {
        return cdCp;
    }


    /**
     * Sets the cdCp value for this ObjRtMonitorizacaoDTO.
     * 
     * @param cdCp
     */
    public void setCdCp(java.lang.String cdCp) {
        this.cdCp = cdCp;
    }


    /**
     * Gets the cdFolha value for this ObjRtMonitorizacaoDTO.
     * 
     * @return cdFolha
     */
    public java.lang.String getCdFolha() {
        return cdFolha;
    }


    /**
     * Sets the cdFolha value for this ObjRtMonitorizacaoDTO.
     * 
     * @param cdFolha
     */
    public void setCdFolha(java.lang.String cdFolha) {
        this.cdFolha = cdFolha;
    }


    /**
     * Gets the cdGt value for this ObjRtMonitorizacaoDTO.
     * 
     * @return cdGt
     */
    public java.lang.String getCdGt() {
        return cdGt;
    }


    /**
     * Sets the cdGt value for this ObjRtMonitorizacaoDTO.
     * 
     * @param cdGt
     */
    public void setCdGt(java.lang.String cdGt) {
        this.cdGt = cdGt;
    }


    /**
     * Gets the cdProduto value for this ObjRtMonitorizacaoDTO.
     * 
     * @return cdProduto
     */
    public java.lang.String getCdProduto() {
        return cdProduto;
    }


    /**
     * Sets the cdProduto value for this ObjRtMonitorizacaoDTO.
     * 
     * @param cdProduto
     */
    public void setCdProduto(java.lang.String cdProduto) {
        this.cdProduto = cdProduto;
    }


    /**
     * Gets the cdPt value for this ObjRtMonitorizacaoDTO.
     * 
     * @return cdPt
     */
    public java.lang.String getCdPt() {
        return cdPt;
    }


    /**
     * Sets the cdPt value for this ObjRtMonitorizacaoDTO.
     * 
     * @param cdPt
     */
    public void setCdPt(java.lang.String cdPt) {
        this.cdPt = cdPt;
    }


    /**
     * Gets the comAlerta value for this ObjRtMonitorizacaoDTO.
     * 
     * @return comAlerta
     */
    public boolean isComAlerta() {
        return comAlerta;
    }


    /**
     * Sets the comAlerta value for this ObjRtMonitorizacaoDTO.
     * 
     * @param comAlerta
     */
    public void setComAlerta(boolean comAlerta) {
        this.comAlerta = comAlerta;
    }


    /**
     * Gets the consolidacaoEmAtraso value for this ObjRtMonitorizacaoDTO.
     * 
     * @return consolidacaoEmAtraso
     */
    public boolean isConsolidacaoEmAtraso() {
        return consolidacaoEmAtraso;
    }


    /**
     * Sets the consolidacaoEmAtraso value for this ObjRtMonitorizacaoDTO.
     * 
     * @param consolidacaoEmAtraso
     */
    public void setConsolidacaoEmAtraso(boolean consolidacaoEmAtraso) {
        this.consolidacaoEmAtraso = consolidacaoEmAtraso;
    }


    /**
     * Gets the corFundo value for this ObjRtMonitorizacaoDTO.
     * 
     * @return corFundo
     */
    public idw.idwws.ColorDTO getCorFundo() {
        return corFundo;
    }


    /**
     * Sets the corFundo value for this ObjRtMonitorizacaoDTO.
     * 
     * @param corFundo
     */
    public void setCorFundo(idw.idwws.ColorDTO corFundo) {
        this.corFundo = corFundo;
    }


    /**
     * Gets the dentroDaMeta value for this ObjRtMonitorizacaoDTO.
     * 
     * @return dentroDaMeta
     */
    public boolean isDentroDaMeta() {
        return dentroDaMeta;
    }


    /**
     * Sets the dentroDaMeta value for this ObjRtMonitorizacaoDTO.
     * 
     * @param dentroDaMeta
     */
    public void setDentroDaMeta(boolean dentroDaMeta) {
        this.dentroDaMeta = dentroDaMeta;
    }


    /**
     * Gets the dsFolha value for this ObjRtMonitorizacaoDTO.
     * 
     * @return dsFolha
     */
    public java.lang.String getDsFolha() {
        return dsFolha;
    }


    /**
     * Sets the dsFolha value for this ObjRtMonitorizacaoDTO.
     * 
     * @param dsFolha
     */
    public void setDsFolha(java.lang.String dsFolha) {
        this.dsFolha = dsFolha;
    }


    /**
     * Gets the dsGt value for this ObjRtMonitorizacaoDTO.
     * 
     * @return dsGt
     */
    public java.lang.String getDsGt() {
        return dsGt;
    }


    /**
     * Sets the dsGt value for this ObjRtMonitorizacaoDTO.
     * 
     * @param dsGt
     */
    public void setDsGt(java.lang.String dsGt) {
        this.dsGt = dsGt;
    }


    /**
     * Gets the dsProduto value for this ObjRtMonitorizacaoDTO.
     * 
     * @return dsProduto
     */
    public java.lang.String getDsProduto() {
        return dsProduto;
    }


    /**
     * Sets the dsProduto value for this ObjRtMonitorizacaoDTO.
     * 
     * @param dsProduto
     */
    public void setDsProduto(java.lang.String dsProduto) {
        this.dsProduto = dsProduto;
    }


    /**
     * Gets the dsPt value for this ObjRtMonitorizacaoDTO.
     * 
     * @return dsPt
     */
    public java.lang.String getDsPt() {
        return dsPt;
    }


    /**
     * Sets the dsPt value for this ObjRtMonitorizacaoDTO.
     * 
     * @param dsPt
     */
    public void setDsPt(java.lang.String dsPt) {
        this.dsPt = dsPt;
    }


    /**
     * Gets the dsTurno value for this ObjRtMonitorizacaoDTO.
     * 
     * @return dsTurno
     */
    public java.lang.String getDsTurno() {
        return dsTurno;
    }


    /**
     * Sets the dsTurno value for this ObjRtMonitorizacaoDTO.
     * 
     * @param dsTurno
     */
    public void setDsTurno(java.lang.String dsTurno) {
        this.dsTurno = dsTurno;
    }


    /**
     * Gets the dtReferencia value for this ObjRtMonitorizacaoDTO.
     * 
     * @return dtReferencia
     */
    public java.util.Calendar getDtReferencia() {
        return dtReferencia;
    }


    /**
     * Sets the dtReferencia value for this ObjRtMonitorizacaoDTO.
     * 
     * @param dtReferencia
     */
    public void setDtReferencia(java.util.Calendar dtReferencia) {
        this.dtReferencia = dtReferencia;
    }


    /**
     * Gets the duracaoParada value for this ObjRtMonitorizacaoDTO.
     * 
     * @return duracaoParada
     */
    public java.lang.String getDuracaoParada() {
        return duracaoParada;
    }


    /**
     * Sets the duracaoParada value for this ObjRtMonitorizacaoDTO.
     * 
     * @param duracaoParada
     */
    public void setDuracaoParada(java.lang.String duracaoParada) {
        this.duracaoParada = duracaoParada;
    }


    /**
     * Gets the dwConsolmologs value for this ObjRtMonitorizacaoDTO.
     * 
     * @return dwConsolmologs
     */
    public idw.idwws.DwConsolmolog[] getDwConsolmologs() {
        return dwConsolmologs;
    }


    /**
     * Sets the dwConsolmologs value for this ObjRtMonitorizacaoDTO.
     * 
     * @param dwConsolmologs
     */
    public void setDwConsolmologs(idw.idwws.DwConsolmolog[] dwConsolmologs) {
        this.dwConsolmologs = dwConsolmologs;
    }

    public idw.idwws.DwConsolmolog getDwConsolmologs(int i) {
        return this.dwConsolmologs[i];
    }

    public void setDwConsolmologs(int i, idw.idwws.DwConsolmolog _value) {
        this.dwConsolmologs[i] = _value;
    }


    /**
     * Gets the efiCiclos value for this ObjRtMonitorizacaoDTO.
     * 
     * @return efiCiclos
     */
    public java.lang.Double getEfiCiclos() {
        return efiCiclos;
    }


    /**
     * Sets the efiCiclos value for this ObjRtMonitorizacaoDTO.
     * 
     * @param efiCiclos
     */
    public void setEfiCiclos(java.lang.Double efiCiclos) {
        this.efiCiclos = efiCiclos;
    }


    /**
     * Gets the efiInstantanea value for this ObjRtMonitorizacaoDTO.
     * 
     * @return efiInstantanea
     */
    public java.lang.Double getEfiInstantanea() {
        return efiInstantanea;
    }


    /**
     * Sets the efiInstantanea value for this ObjRtMonitorizacaoDTO.
     * 
     * @param efiInstantanea
     */
    public void setEfiInstantanea(java.lang.Double efiInstantanea) {
        this.efiInstantanea = efiInstantanea;
    }


    /**
     * Gets the efiRealizacao value for this ObjRtMonitorizacaoDTO.
     * 
     * @return efiRealizacao
     */
    public java.lang.Double getEfiRealizacao() {
        return efiRealizacao;
    }


    /**
     * Sets the efiRealizacao value for this ObjRtMonitorizacaoDTO.
     * 
     * @param efiRealizacao
     */
    public void setEfiRealizacao(java.lang.Double efiRealizacao) {
        this.efiRealizacao = efiRealizacao;
    }


    /**
     * Gets the filtroIndicadorLabel value for this ObjRtMonitorizacaoDTO.
     * 
     * @return filtroIndicadorLabel
     */
    public int getFiltroIndicadorLabel() {
        return filtroIndicadorLabel;
    }


    /**
     * Sets the filtroIndicadorLabel value for this ObjRtMonitorizacaoDTO.
     * 
     * @param filtroIndicadorLabel
     */
    public void setFiltroIndicadorLabel(int filtroIndicadorLabel) {
        this.filtroIndicadorLabel = filtroIndicadorLabel;
    }


    /**
     * Gets the fimParada value for this ObjRtMonitorizacaoDTO.
     * 
     * @return fimParada
     */
    public java.util.Calendar getFimParada() {
        return fimParada;
    }


    /**
     * Sets the fimParada value for this ObjRtMonitorizacaoDTO.
     * 
     * @param fimParada
     */
    public void setFimParada(java.util.Calendar fimParada) {
        this.fimParada = fimParada;
    }


    /**
     * Gets the gargaloDinamico value for this ObjRtMonitorizacaoDTO.
     * 
     * @return gargaloDinamico
     */
    public boolean isGargaloDinamico() {
        return gargaloDinamico;
    }


    /**
     * Sets the gargaloDinamico value for this ObjRtMonitorizacaoDTO.
     * 
     * @param gargaloDinamico
     */
    public void setGargaloDinamico(boolean gargaloDinamico) {
        this.gargaloDinamico = gargaloDinamico;
    }


    /**
     * Gets the gargaloTeorico value for this ObjRtMonitorizacaoDTO.
     * 
     * @return gargaloTeorico
     */
    public boolean isGargaloTeorico() {
        return gargaloTeorico;
    }


    /**
     * Sets the gargaloTeorico value for this ObjRtMonitorizacaoDTO.
     * 
     * @param gargaloTeorico
     */
    public void setGargaloTeorico(boolean gargaloTeorico) {
        this.gargaloTeorico = gargaloTeorico;
    }


    /**
     * Gets the idCp value for this ObjRtMonitorizacaoDTO.
     * 
     * @return idCp
     */
    public java.lang.Long getIdCp() {
        return idCp;
    }


    /**
     * Sets the idCp value for this ObjRtMonitorizacaoDTO.
     * 
     * @param idCp
     */
    public void setIdCp(java.lang.Long idCp) {
        this.idCp = idCp;
    }


    /**
     * Gets the idDwConsolId value for this ObjRtMonitorizacaoDTO.
     * 
     * @return idDwConsolId
     */
    public long getIdDwConsolId() {
        return idDwConsolId;
    }


    /**
     * Sets the idDwConsolId value for this ObjRtMonitorizacaoDTO.
     * 
     * @param idDwConsolId
     */
    public void setIdDwConsolId(long idDwConsolId) {
        this.idDwConsolId = idDwConsolId;
    }


    /**
     * Gets the idGt value for this ObjRtMonitorizacaoDTO.
     * 
     * @return idGt
     */
    public long getIdGt() {
        return idGt;
    }


    /**
     * Sets the idGt value for this ObjRtMonitorizacaoDTO.
     * 
     * @param idGt
     */
    public void setIdGt(long idGt) {
        this.idGt = idGt;
    }


    /**
     * Gets the idPt value for this ObjRtMonitorizacaoDTO.
     * 
     * @return idPt
     */
    public long getIdPt() {
        return idPt;
    }


    /**
     * Sets the idPt value for this ObjRtMonitorizacaoDTO.
     * 
     * @param idPt
     */
    public void setIdPt(long idPt) {
        this.idPt = idPt;
    }


    /**
     * Gets the idTurno value for this ObjRtMonitorizacaoDTO.
     * 
     * @return idTurno
     */
    public long getIdTurno() {
        return idTurno;
    }


    /**
     * Sets the idTurno value for this ObjRtMonitorizacaoDTO.
     * 
     * @param idTurno
     */
    public void setIdTurno(long idTurno) {
        this.idTurno = idTurno;
    }


    /**
     * Gets the idtppt value for this ObjRtMonitorizacaoDTO.
     * 
     * @return idtppt
     */
    public long getIdtppt() {
        return idtppt;
    }


    /**
     * Sets the idtppt value for this ObjRtMonitorizacaoDTO.
     * 
     * @param idtppt
     */
    public void setIdtppt(long idtppt) {
        this.idtppt = idtppt;
    }


    /**
     * Gets the indOEE value for this ObjRtMonitorizacaoDTO.
     * 
     * @return indOEE
     */
    public java.lang.Double getIndOEE() {
        return indOEE;
    }


    /**
     * Sets the indOEE value for this ObjRtMonitorizacaoDTO.
     * 
     * @param indOEE
     */
    public void setIndOEE(java.lang.Double indOEE) {
        this.indOEE = indOEE;
    }


    /**
     * Gets the indiceCavAtivas value for this ObjRtMonitorizacaoDTO.
     * 
     * @return indiceCavAtivas
     */
    public java.lang.Double getIndiceCavAtivas() {
        return indiceCavAtivas;
    }


    /**
     * Sets the indiceCavAtivas value for this ObjRtMonitorizacaoDTO.
     * 
     * @param indiceCavAtivas
     */
    public void setIndiceCavAtivas(java.lang.Double indiceCavAtivas) {
        this.indiceCavAtivas = indiceCavAtivas;
    }


    /**
     * Gets the indiceParadas value for this ObjRtMonitorizacaoDTO.
     * 
     * @return indiceParadas
     */
    public java.lang.Double getIndiceParadas() {
        return indiceParadas;
    }


    /**
     * Sets the indiceParadas value for this ObjRtMonitorizacaoDTO.
     * 
     * @param indiceParadas
     */
    public void setIndiceParadas(java.lang.Double indiceParadas) {
        this.indiceParadas = indiceParadas;
    }


    /**
     * Gets the indiceProducao value for this ObjRtMonitorizacaoDTO.
     * 
     * @return indiceProducao
     */
    public java.lang.Double getIndiceProducao() {
        return indiceProducao;
    }


    /**
     * Sets the indiceProducao value for this ObjRtMonitorizacaoDTO.
     * 
     * @param indiceProducao
     */
    public void setIndiceProducao(java.lang.Double indiceProducao) {
        this.indiceProducao = indiceProducao;
    }


    /**
     * Gets the indiceRefugo3PorCento value for this ObjRtMonitorizacaoDTO.
     * 
     * @return indiceRefugo3PorCento
     */
    public boolean isIndiceRefugo3PorCento() {
        return indiceRefugo3PorCento;
    }


    /**
     * Sets the indiceRefugo3PorCento value for this ObjRtMonitorizacaoDTO.
     * 
     * @param indiceRefugo3PorCento
     */
    public void setIndiceRefugo3PorCento(boolean indiceRefugo3PorCento) {
        this.indiceRefugo3PorCento = indiceRefugo3PorCento;
    }


    /**
     * Gets the indiceRefugos value for this ObjRtMonitorizacaoDTO.
     * 
     * @return indiceRefugos
     */
    public java.lang.Double getIndiceRefugos() {
        return indiceRefugos;
    }


    /**
     * Sets the indiceRefugos value for this ObjRtMonitorizacaoDTO.
     * 
     * @param indiceRefugos
     */
    public void setIndiceRefugos(java.lang.Double indiceRefugos) {
        this.indiceRefugos = indiceRefugos;
    }


    /**
     * Gets the iniParada value for this ObjRtMonitorizacaoDTO.
     * 
     * @return iniParada
     */
    public java.util.Calendar getIniParada() {
        return iniParada;
    }


    /**
     * Sets the iniParada value for this ObjRtMonitorizacaoDTO.
     * 
     * @param iniParada
     */
    public void setIniParada(java.util.Calendar iniParada) {
        this.iniParada = iniParada;
    }


    /**
     * Gets the manutencaoPrev value for this ObjRtMonitorizacaoDTO.
     * 
     * @return manutencaoPrev
     */
    public boolean isManutencaoPrev() {
        return manutencaoPrev;
    }


    /**
     * Sets the manutencaoPrev value for this ObjRtMonitorizacaoDTO.
     * 
     * @param manutencaoPrev
     */
    public void setManutencaoPrev(boolean manutencaoPrev) {
        this.manutencaoPrev = manutencaoPrev;
    }


    /**
     * Gets the metaInstatanea value for this ObjRtMonitorizacaoDTO.
     * 
     * @return metaInstatanea
     */
    public java.lang.Double getMetaInstatanea() {
        return metaInstatanea;
    }


    /**
     * Sets the metaInstatanea value for this ObjRtMonitorizacaoDTO.
     * 
     * @param metaInstatanea
     */
    public void setMetaInstatanea(java.lang.Double metaInstatanea) {
        this.metaInstatanea = metaInstatanea;
    }


    /**
     * Gets the offline value for this ObjRtMonitorizacaoDTO.
     * 
     * @return offline
     */
    public boolean isOffline() {
        return offline;
    }


    /**
     * Sets the offline value for this ObjRtMonitorizacaoDTO.
     * 
     * @param offline
     */
    public void setOffline(boolean offline) {
        this.offline = offline;
    }


    /**
     * Gets the opConcluida value for this ObjRtMonitorizacaoDTO.
     * 
     * @return opConcluida
     */
    public boolean isOpConcluida() {
        return opConcluida;
    }


    /**
     * Sets the opConcluida value for this ObjRtMonitorizacaoDTO.
     * 
     * @param opConcluida
     */
    public void setOpConcluida(boolean opConcluida) {
        this.opConcluida = opConcluida;
    }


    /**
     * Gets the opConcluida90PorCento value for this ObjRtMonitorizacaoDTO.
     * 
     * @return opConcluida90PorCento
     */
    public boolean isOpConcluida90PorCento() {
        return opConcluida90PorCento;
    }


    /**
     * Sets the opConcluida90PorCento value for this ObjRtMonitorizacaoDTO.
     * 
     * @param opConcluida90PorCento
     */
    public void setOpConcluida90PorCento(boolean opConcluida90PorCento) {
        this.opConcluida90PorCento = opConcluida90PorCento;
    }


    /**
     * Gets the parada value for this ObjRtMonitorizacaoDTO.
     * 
     * @return parada
     */
    public boolean isParada() {
        return parada;
    }


    /**
     * Sets the parada value for this ObjRtMonitorizacaoDTO.
     * 
     * @param parada
     */
    public void setParada(boolean parada) {
        this.parada = parada;
    }


    /**
     * Gets the paradaComPeso value for this ObjRtMonitorizacaoDTO.
     * 
     * @return paradaComPeso
     */
    public boolean isParadaComPeso() {
        return paradaComPeso;
    }


    /**
     * Sets the paradaComPeso value for this ObjRtMonitorizacaoDTO.
     * 
     * @param paradaComPeso
     */
    public void setParadaComPeso(boolean paradaComPeso) {
        this.paradaComPeso = paradaComPeso;
    }


    /**
     * Gets the paradaManutencao value for this ObjRtMonitorizacaoDTO.
     * 
     * @return paradaManutencao
     */
    public boolean isParadaManutencao() {
        return paradaManutencao;
    }


    /**
     * Sets the paradaManutencao value for this ObjRtMonitorizacaoDTO.
     * 
     * @param paradaManutencao
     */
    public void setParadaManutencao(boolean paradaManutencao) {
        this.paradaManutencao = paradaManutencao;
    }


    /**
     * Gets the paradaNaoInformada value for this ObjRtMonitorizacaoDTO.
     * 
     * @return paradaNaoInformada
     */
    public boolean isParadaNaoInformada() {
        return paradaNaoInformada;
    }


    /**
     * Sets the paradaNaoInformada value for this ObjRtMonitorizacaoDTO.
     * 
     * @param paradaNaoInformada
     */
    public void setParadaNaoInformada(boolean paradaNaoInformada) {
        this.paradaNaoInformada = paradaNaoInformada;
    }


    /**
     * Gets the paradaSemPesoEfic value for this ObjRtMonitorizacaoDTO.
     * 
     * @return paradaSemPesoEfic
     */
    public boolean isParadaSemPesoEfic() {
        return paradaSemPesoEfic;
    }


    /**
     * Sets the paradaSemPesoEfic value for this ObjRtMonitorizacaoDTO.
     * 
     * @param paradaSemPesoEfic
     */
    public void setParadaSemPesoEfic(boolean paradaSemPesoEfic) {
        this.paradaSemPesoEfic = paradaSemPesoEfic;
    }


    /**
     * Gets the perdaSincronismo value for this ObjRtMonitorizacaoDTO.
     * 
     * @return perdaSincronismo
     */
    public boolean isPerdaSincronismo() {
        return perdaSincronismo;
    }


    /**
     * Sets the perdaSincronismo value for this ObjRtMonitorizacaoDTO.
     * 
     * @param perdaSincronismo
     */
    public void setPerdaSincronismo(boolean perdaSincronismo) {
        this.perdaSincronismo = perdaSincronismo;
    }


    /**
     * Gets the producaoLiquida value for this ObjRtMonitorizacaoDTO.
     * 
     * @return producaoLiquida
     */
    public java.lang.Double getProducaoLiquida() {
        return producaoLiquida;
    }


    /**
     * Sets the producaoLiquida value for this ObjRtMonitorizacaoDTO.
     * 
     * @param producaoLiquida
     */
    public void setProducaoLiquida(java.lang.Double producaoLiquida) {
        this.producaoLiquida = producaoLiquida;
    }


    /**
     * Gets the produtividadeOEE value for this ObjRtMonitorizacaoDTO.
     * 
     * @return produtividadeOEE
     */
    public java.lang.Double getProdutividadeOEE() {
        return produtividadeOEE;
    }


    /**
     * Sets the produtividadeOEE value for this ObjRtMonitorizacaoDTO.
     * 
     * @param produtividadeOEE
     */
    public void setProdutividadeOEE(java.lang.Double produtividadeOEE) {
        this.produtividadeOEE = produtividadeOEE;
    }


    /**
     * Gets the saidaDaCelula value for this ObjRtMonitorizacaoDTO.
     * 
     * @return saidaDaCelula
     */
    public boolean isSaidaDaCelula() {
        return saidaDaCelula;
    }


    /**
     * Sets the saidaDaCelula value for this ObjRtMonitorizacaoDTO.
     * 
     * @param saidaDaCelula
     */
    public void setSaidaDaCelula(boolean saidaDaCelula) {
        this.saidaDaCelula = saidaDaCelula;
    }


    /**
     * Gets the temDwRt value for this ObjRtMonitorizacaoDTO.
     * 
     * @return temDwRt
     */
    public boolean isTemDwRt() {
        return temDwRt;
    }


    /**
     * Sets the temDwRt value for this ObjRtMonitorizacaoDTO.
     * 
     * @param temDwRt
     */
    public void setTemDwRt(boolean temDwRt) {
        this.temDwRt = temDwRt;
    }


    /**
     * Gets the temOmAlgocor value for this ObjRtMonitorizacaoDTO.
     * 
     * @return temOmAlgocor
     */
    public boolean isTemOmAlgocor() {
        return temOmAlgocor;
    }


    /**
     * Sets the temOmAlgocor value for this ObjRtMonitorizacaoDTO.
     * 
     * @param temOmAlgocor
     */
    public void setTemOmAlgocor(boolean temOmAlgocor) {
        this.temOmAlgocor = temOmAlgocor;
    }


    /**
     * Gets the temOmCfg value for this ObjRtMonitorizacaoDTO.
     * 
     * @return temOmCfg
     */
    public boolean isTemOmCfg() {
        return temOmCfg;
    }


    /**
     * Sets the temOmCfg value for this ObjRtMonitorizacaoDTO.
     * 
     * @param temOmCfg
     */
    public void setTemOmCfg(boolean temOmCfg) {
        this.temOmCfg = temOmCfg;
    }


    /**
     * Gets the temOperador value for this ObjRtMonitorizacaoDTO.
     * 
     * @return temOperador
     */
    public boolean isTemOperador() {
        return temOperador;
    }


    /**
     * Sets the temOperador value for this ObjRtMonitorizacaoDTO.
     * 
     * @param temOperador
     */
    public void setTemOperador(boolean temOperador) {
        this.temOperador = temOperador;
    }


    /**
     * Gets the temPlanejamento value for this ObjRtMonitorizacaoDTO.
     * 
     * @return temPlanejamento
     */
    public boolean isTemPlanejamento() {
        return temPlanejamento;
    }


    /**
     * Sets the temPlanejamento value for this ObjRtMonitorizacaoDTO.
     * 
     * @param temPlanejamento
     */
    public void setTemPlanejamento(boolean temPlanejamento) {
        this.temPlanejamento = temPlanejamento;
    }


    /**
     * Gets the temperaturaZonaActInf value for this ObjRtMonitorizacaoDTO.
     * 
     * @return temperaturaZonaActInf
     */
    public boolean isTemperaturaZonaActInf() {
        return temperaturaZonaActInf;
    }


    /**
     * Sets the temperaturaZonaActInf value for this ObjRtMonitorizacaoDTO.
     * 
     * @param temperaturaZonaActInf
     */
    public void setTemperaturaZonaActInf(boolean temperaturaZonaActInf) {
        this.temperaturaZonaActInf = temperaturaZonaActInf;
    }


    /**
     * Gets the temperaturaZonaActSup value for this ObjRtMonitorizacaoDTO.
     * 
     * @return temperaturaZonaActSup
     */
    public boolean isTemperaturaZonaActSup() {
        return temperaturaZonaActSup;
    }


    /**
     * Sets the temperaturaZonaActSup value for this ObjRtMonitorizacaoDTO.
     * 
     * @param temperaturaZonaActSup
     */
    public void setTemperaturaZonaActSup(boolean temperaturaZonaActSup) {
        this.temperaturaZonaActSup = temperaturaZonaActSup;
    }


    /**
     * Gets the temperaturaZonaCritInf value for this ObjRtMonitorizacaoDTO.
     * 
     * @return temperaturaZonaCritInf
     */
    public boolean isTemperaturaZonaCritInf() {
        return temperaturaZonaCritInf;
    }


    /**
     * Sets the temperaturaZonaCritInf value for this ObjRtMonitorizacaoDTO.
     * 
     * @param temperaturaZonaCritInf
     */
    public void setTemperaturaZonaCritInf(boolean temperaturaZonaCritInf) {
        this.temperaturaZonaCritInf = temperaturaZonaCritInf;
    }


    /**
     * Gets the temperaturaZonaCritSup value for this ObjRtMonitorizacaoDTO.
     * 
     * @return temperaturaZonaCritSup
     */
    public boolean isTemperaturaZonaCritSup() {
        return temperaturaZonaCritSup;
    }


    /**
     * Sets the temperaturaZonaCritSup value for this ObjRtMonitorizacaoDTO.
     * 
     * @param temperaturaZonaCritSup
     */
    public void setTemperaturaZonaCritSup(boolean temperaturaZonaCritSup) {
        this.temperaturaZonaCritSup = temperaturaZonaCritSup;
    }


    /**
     * Gets the temperaturaZonaIdeal value for this ObjRtMonitorizacaoDTO.
     * 
     * @return temperaturaZonaIdeal
     */
    public boolean isTemperaturaZonaIdeal() {
        return temperaturaZonaIdeal;
    }


    /**
     * Sets the temperaturaZonaIdeal value for this ObjRtMonitorizacaoDTO.
     * 
     * @param temperaturaZonaIdeal
     */
    public void setTemperaturaZonaIdeal(boolean temperaturaZonaIdeal) {
        this.temperaturaZonaIdeal = temperaturaZonaIdeal;
    }


    /**
     * Gets the tipoAlgoritmo value for this ObjRtMonitorizacaoDTO.
     * 
     * @return tipoAlgoritmo
     */
    public int getTipoAlgoritmo() {
        return tipoAlgoritmo;
    }


    /**
     * Sets the tipoAlgoritmo value for this ObjRtMonitorizacaoDTO.
     * 
     * @param tipoAlgoritmo
     */
    public void setTipoAlgoritmo(int tipoAlgoritmo) {
        this.tipoAlgoritmo = tipoAlgoritmo;
    }


    /**
     * Gets the tipoGT value for this ObjRtMonitorizacaoDTO.
     * 
     * @return tipoGT
     */
    public int getTipoGT() {
        return tipoGT;
    }


    /**
     * Sets the tipoGT value for this ObjRtMonitorizacaoDTO.
     * 
     * @param tipoGT
     */
    public void setTipoGT(int tipoGT) {
        this.tipoGT = tipoGT;
    }


    /**
     * Gets the tipoObj value for this ObjRtMonitorizacaoDTO.
     * 
     * @return tipoObj
     */
    public int getTipoObj() {
        return tipoObj;
    }


    /**
     * Sets the tipoObj value for this ObjRtMonitorizacaoDTO.
     * 
     * @param tipoObj
     */
    public void setTipoObj(int tipoObj) {
        this.tipoObj = tipoObj;
    }


    /**
     * Gets the tipoPT value for this ObjRtMonitorizacaoDTO.
     * 
     * @return tipoPT
     */
    public int getTipoPT() {
        return tipoPT;
    }


    /**
     * Sets the tipoPT value for this ObjRtMonitorizacaoDTO.
     * 
     * @param tipoPT
     */
    public void setTipoPT(int tipoPT) {
        this.tipoPT = tipoPT;
    }


    /**
     * Gets the ultimaOp value for this ObjRtMonitorizacaoDTO.
     * 
     * @return ultimaOp
     */
    public java.lang.String getUltimaOp() {
        return ultimaOp;
    }


    /**
     * Sets the ultimaOp value for this ObjRtMonitorizacaoDTO.
     * 
     * @param ultimaOp
     */
    public void setUltimaOp(java.lang.String ultimaOp) {
        this.ultimaOp = ultimaOp;
    }


    /**
     * Gets the ultimaParada value for this ObjRtMonitorizacaoDTO.
     * 
     * @return ultimaParada
     */
    public java.lang.String getUltimaParada() {
        return ultimaParada;
    }


    /**
     * Sets the ultimaParada value for this ObjRtMonitorizacaoDTO.
     * 
     * @param ultimaParada
     */
    public void setUltimaParada(java.lang.String ultimaParada) {
        this.ultimaParada = ultimaParada;
    }


    /**
     * Gets the ultimaTemperaturaLida value for this ObjRtMonitorizacaoDTO.
     * 
     * @return ultimaTemperaturaLida
     */
    public java.lang.Double getUltimaTemperaturaLida() {
        return ultimaTemperaturaLida;
    }


    /**
     * Sets the ultimaTemperaturaLida value for this ObjRtMonitorizacaoDTO.
     * 
     * @param ultimaTemperaturaLida
     */
    public void setUltimaTemperaturaLida(java.lang.Double ultimaTemperaturaLida) {
        this.ultimaTemperaturaLida = ultimaTemperaturaLida;
    }


    /**
     * Gets the ultimoMolde value for this ObjRtMonitorizacaoDTO.
     * 
     * @return ultimoMolde
     */
    public java.lang.String getUltimoMolde() {
        return ultimoMolde;
    }


    /**
     * Sets the ultimoMolde value for this ObjRtMonitorizacaoDTO.
     * 
     * @param ultimoMolde
     */
    public void setUltimoMolde(java.lang.String ultimoMolde) {
        this.ultimoMolde = ultimoMolde;
    }


    /**
     * Gets the urlImg value for this ObjRtMonitorizacaoDTO.
     * 
     * @return urlImg
     */
    public java.lang.String getUrlImg() {
        return urlImg;
    }


    /**
     * Sets the urlImg value for this ObjRtMonitorizacaoDTO.
     * 
     * @param urlImg
     */
    public void setUrlImg(java.lang.String urlImg) {
        this.urlImg = urlImg;
    }


    /**
     * Gets the x value for this ObjRtMonitorizacaoDTO.
     * 
     * @return x
     */
    public java.lang.Double getX() {
        return x;
    }


    /**
     * Sets the x value for this ObjRtMonitorizacaoDTO.
     * 
     * @param x
     */
    public void setX(java.lang.Double x) {
        this.x = x;
    }


    /**
     * Gets the x2 value for this ObjRtMonitorizacaoDTO.
     * 
     * @return x2
     */
    public java.lang.Double getX2() {
        return x2;
    }


    /**
     * Sets the x2 value for this ObjRtMonitorizacaoDTO.
     * 
     * @param x2
     */
    public void setX2(java.lang.Double x2) {
        this.x2 = x2;
    }


    /**
     * Gets the y value for this ObjRtMonitorizacaoDTO.
     * 
     * @return y
     */
    public java.lang.Double getY() {
        return y;
    }


    /**
     * Sets the y value for this ObjRtMonitorizacaoDTO.
     * 
     * @param y
     */
    public void setY(java.lang.Double y) {
        this.y = y;
    }


    /**
     * Gets the y2 value for this ObjRtMonitorizacaoDTO.
     * 
     * @return y2
     */
    public java.lang.Double getY2() {
        return y2;
    }


    /**
     * Sets the y2 value for this ObjRtMonitorizacaoDTO.
     * 
     * @param y2
     */
    public void setY2(java.lang.Double y2) {
        this.y2 = y2;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObjRtMonitorizacaoDTO)) return false;
        ObjRtMonitorizacaoDTO other = (ObjRtMonitorizacaoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.alertaVidaUtil == other.isAlertaVidaUtil() &&
            ((this.areaResponsavel==null && other.getAreaResponsavel()==null) || 
             (this.areaResponsavel!=null &&
              this.areaResponsavel.equals(other.getAreaResponsavel()))) &&
            ((this.COR_FUNDO_DENTRO_META==null && other.getCOR_FUNDO_DENTRO_META()==null) || 
             (this.COR_FUNDO_DENTRO_META!=null &&
              this.COR_FUNDO_DENTRO_META.equals(other.getCOR_FUNDO_DENTRO_META()))) &&
            ((this.COR_FUNDO_FORA_META==null && other.getCOR_FUNDO_FORA_META()==null) || 
             (this.COR_FUNDO_FORA_META!=null &&
              this.COR_FUNDO_FORA_META.equals(other.getCOR_FUNDO_FORA_META()))) &&
            ((this.COR_FUNDO_OFFLINE==null && other.getCOR_FUNDO_OFFLINE()==null) || 
             (this.COR_FUNDO_OFFLINE!=null &&
              this.COR_FUNDO_OFFLINE.equals(other.getCOR_FUNDO_OFFLINE()))) &&
            ((this.COR_FUNDO_PARADA==null && other.getCOR_FUNDO_PARADA()==null) || 
             (this.COR_FUNDO_PARADA!=null &&
              this.COR_FUNDO_PARADA.equals(other.getCOR_FUNDO_PARADA()))) &&
            ((this.cdCp==null && other.getCdCp()==null) || 
             (this.cdCp!=null &&
              this.cdCp.equals(other.getCdCp()))) &&
            ((this.cdFolha==null && other.getCdFolha()==null) || 
             (this.cdFolha!=null &&
              this.cdFolha.equals(other.getCdFolha()))) &&
            ((this.cdGt==null && other.getCdGt()==null) || 
             (this.cdGt!=null &&
              this.cdGt.equals(other.getCdGt()))) &&
            ((this.cdProduto==null && other.getCdProduto()==null) || 
             (this.cdProduto!=null &&
              this.cdProduto.equals(other.getCdProduto()))) &&
            ((this.cdPt==null && other.getCdPt()==null) || 
             (this.cdPt!=null &&
              this.cdPt.equals(other.getCdPt()))) &&
            this.comAlerta == other.isComAlerta() &&
            this.consolidacaoEmAtraso == other.isConsolidacaoEmAtraso() &&
            ((this.corFundo==null && other.getCorFundo()==null) || 
             (this.corFundo!=null &&
              this.corFundo.equals(other.getCorFundo()))) &&
            this.dentroDaMeta == other.isDentroDaMeta() &&
            ((this.dsFolha==null && other.getDsFolha()==null) || 
             (this.dsFolha!=null &&
              this.dsFolha.equals(other.getDsFolha()))) &&
            ((this.dsGt==null && other.getDsGt()==null) || 
             (this.dsGt!=null &&
              this.dsGt.equals(other.getDsGt()))) &&
            ((this.dsProduto==null && other.getDsProduto()==null) || 
             (this.dsProduto!=null &&
              this.dsProduto.equals(other.getDsProduto()))) &&
            ((this.dsPt==null && other.getDsPt()==null) || 
             (this.dsPt!=null &&
              this.dsPt.equals(other.getDsPt()))) &&
            ((this.dsTurno==null && other.getDsTurno()==null) || 
             (this.dsTurno!=null &&
              this.dsTurno.equals(other.getDsTurno()))) &&
            ((this.dtReferencia==null && other.getDtReferencia()==null) || 
             (this.dtReferencia!=null &&
              this.dtReferencia.equals(other.getDtReferencia()))) &&
            ((this.duracaoParada==null && other.getDuracaoParada()==null) || 
             (this.duracaoParada!=null &&
              this.duracaoParada.equals(other.getDuracaoParada()))) &&
            ((this.dwConsolmologs==null && other.getDwConsolmologs()==null) || 
             (this.dwConsolmologs!=null &&
              java.util.Arrays.equals(this.dwConsolmologs, other.getDwConsolmologs()))) &&
            ((this.efiCiclos==null && other.getEfiCiclos()==null) || 
             (this.efiCiclos!=null &&
              this.efiCiclos.equals(other.getEfiCiclos()))) &&
            ((this.efiInstantanea==null && other.getEfiInstantanea()==null) || 
             (this.efiInstantanea!=null &&
              this.efiInstantanea.equals(other.getEfiInstantanea()))) &&
            ((this.efiRealizacao==null && other.getEfiRealizacao()==null) || 
             (this.efiRealizacao!=null &&
              this.efiRealizacao.equals(other.getEfiRealizacao()))) &&
            this.filtroIndicadorLabel == other.getFiltroIndicadorLabel() &&
            ((this.fimParada==null && other.getFimParada()==null) || 
             (this.fimParada!=null &&
              this.fimParada.equals(other.getFimParada()))) &&
            this.gargaloDinamico == other.isGargaloDinamico() &&
            this.gargaloTeorico == other.isGargaloTeorico() &&
            ((this.idCp==null && other.getIdCp()==null) || 
             (this.idCp!=null &&
              this.idCp.equals(other.getIdCp()))) &&
            this.idDwConsolId == other.getIdDwConsolId() &&
            this.idGt == other.getIdGt() &&
            this.idPt == other.getIdPt() &&
            this.idTurno == other.getIdTurno() &&
            this.idtppt == other.getIdtppt() &&
            ((this.indOEE==null && other.getIndOEE()==null) || 
             (this.indOEE!=null &&
              this.indOEE.equals(other.getIndOEE()))) &&
            ((this.indiceCavAtivas==null && other.getIndiceCavAtivas()==null) || 
             (this.indiceCavAtivas!=null &&
              this.indiceCavAtivas.equals(other.getIndiceCavAtivas()))) &&
            ((this.indiceParadas==null && other.getIndiceParadas()==null) || 
             (this.indiceParadas!=null &&
              this.indiceParadas.equals(other.getIndiceParadas()))) &&
            ((this.indiceProducao==null && other.getIndiceProducao()==null) || 
             (this.indiceProducao!=null &&
              this.indiceProducao.equals(other.getIndiceProducao()))) &&
            this.indiceRefugo3PorCento == other.isIndiceRefugo3PorCento() &&
            ((this.indiceRefugos==null && other.getIndiceRefugos()==null) || 
             (this.indiceRefugos!=null &&
              this.indiceRefugos.equals(other.getIndiceRefugos()))) &&
            ((this.iniParada==null && other.getIniParada()==null) || 
             (this.iniParada!=null &&
              this.iniParada.equals(other.getIniParada()))) &&
            this.manutencaoPrev == other.isManutencaoPrev() &&
            ((this.metaInstatanea==null && other.getMetaInstatanea()==null) || 
             (this.metaInstatanea!=null &&
              this.metaInstatanea.equals(other.getMetaInstatanea()))) &&
            this.offline == other.isOffline() &&
            this.opConcluida == other.isOpConcluida() &&
            this.opConcluida90PorCento == other.isOpConcluida90PorCento() &&
            this.parada == other.isParada() &&
            this.paradaComPeso == other.isParadaComPeso() &&
            this.paradaManutencao == other.isParadaManutencao() &&
            this.paradaNaoInformada == other.isParadaNaoInformada() &&
            this.paradaSemPesoEfic == other.isParadaSemPesoEfic() &&
            this.perdaSincronismo == other.isPerdaSincronismo() &&
            ((this.producaoLiquida==null && other.getProducaoLiquida()==null) || 
             (this.producaoLiquida!=null &&
              this.producaoLiquida.equals(other.getProducaoLiquida()))) &&
            ((this.produtividadeOEE==null && other.getProdutividadeOEE()==null) || 
             (this.produtividadeOEE!=null &&
              this.produtividadeOEE.equals(other.getProdutividadeOEE()))) &&
            this.saidaDaCelula == other.isSaidaDaCelula() &&
            this.temDwRt == other.isTemDwRt() &&
            this.temOmAlgocor == other.isTemOmAlgocor() &&
            this.temOmCfg == other.isTemOmCfg() &&
            this.temOperador == other.isTemOperador() &&
            this.temPlanejamento == other.isTemPlanejamento() &&
            this.temperaturaZonaActInf == other.isTemperaturaZonaActInf() &&
            this.temperaturaZonaActSup == other.isTemperaturaZonaActSup() &&
            this.temperaturaZonaCritInf == other.isTemperaturaZonaCritInf() &&
            this.temperaturaZonaCritSup == other.isTemperaturaZonaCritSup() &&
            this.temperaturaZonaIdeal == other.isTemperaturaZonaIdeal() &&
            this.tipoAlgoritmo == other.getTipoAlgoritmo() &&
            this.tipoGT == other.getTipoGT() &&
            this.tipoObj == other.getTipoObj() &&
            this.tipoPT == other.getTipoPT() &&
            ((this.ultimaOp==null && other.getUltimaOp()==null) || 
             (this.ultimaOp!=null &&
              this.ultimaOp.equals(other.getUltimaOp()))) &&
            ((this.ultimaParada==null && other.getUltimaParada()==null) || 
             (this.ultimaParada!=null &&
              this.ultimaParada.equals(other.getUltimaParada()))) &&
            ((this.ultimaTemperaturaLida==null && other.getUltimaTemperaturaLida()==null) || 
             (this.ultimaTemperaturaLida!=null &&
              this.ultimaTemperaturaLida.equals(other.getUltimaTemperaturaLida()))) &&
            ((this.ultimoMolde==null && other.getUltimoMolde()==null) || 
             (this.ultimoMolde!=null &&
              this.ultimoMolde.equals(other.getUltimoMolde()))) &&
            ((this.urlImg==null && other.getUrlImg()==null) || 
             (this.urlImg!=null &&
              this.urlImg.equals(other.getUrlImg()))) &&
            ((this.x==null && other.getX()==null) || 
             (this.x!=null &&
              this.x.equals(other.getX()))) &&
            ((this.x2==null && other.getX2()==null) || 
             (this.x2!=null &&
              this.x2.equals(other.getX2()))) &&
            ((this.y==null && other.getY()==null) || 
             (this.y!=null &&
              this.y.equals(other.getY()))) &&
            ((this.y2==null && other.getY2()==null) || 
             (this.y2!=null &&
              this.y2.equals(other.getY2())));
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
        _hashCode += (isAlertaVidaUtil() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getAreaResponsavel() != null) {
            _hashCode += getAreaResponsavel().hashCode();
        }
        if (getCOR_FUNDO_DENTRO_META() != null) {
            _hashCode += getCOR_FUNDO_DENTRO_META().hashCode();
        }
        if (getCOR_FUNDO_FORA_META() != null) {
            _hashCode += getCOR_FUNDO_FORA_META().hashCode();
        }
        if (getCOR_FUNDO_OFFLINE() != null) {
            _hashCode += getCOR_FUNDO_OFFLINE().hashCode();
        }
        if (getCOR_FUNDO_PARADA() != null) {
            _hashCode += getCOR_FUNDO_PARADA().hashCode();
        }
        if (getCdCp() != null) {
            _hashCode += getCdCp().hashCode();
        }
        if (getCdFolha() != null) {
            _hashCode += getCdFolha().hashCode();
        }
        if (getCdGt() != null) {
            _hashCode += getCdGt().hashCode();
        }
        if (getCdProduto() != null) {
            _hashCode += getCdProduto().hashCode();
        }
        if (getCdPt() != null) {
            _hashCode += getCdPt().hashCode();
        }
        _hashCode += (isComAlerta() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isConsolidacaoEmAtraso() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCorFundo() != null) {
            _hashCode += getCorFundo().hashCode();
        }
        _hashCode += (isDentroDaMeta() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDsFolha() != null) {
            _hashCode += getDsFolha().hashCode();
        }
        if (getDsGt() != null) {
            _hashCode += getDsGt().hashCode();
        }
        if (getDsProduto() != null) {
            _hashCode += getDsProduto().hashCode();
        }
        if (getDsPt() != null) {
            _hashCode += getDsPt().hashCode();
        }
        if (getDsTurno() != null) {
            _hashCode += getDsTurno().hashCode();
        }
        if (getDtReferencia() != null) {
            _hashCode += getDtReferencia().hashCode();
        }
        if (getDuracaoParada() != null) {
            _hashCode += getDuracaoParada().hashCode();
        }
        if (getDwConsolmologs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolmologs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolmologs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEfiCiclos() != null) {
            _hashCode += getEfiCiclos().hashCode();
        }
        if (getEfiInstantanea() != null) {
            _hashCode += getEfiInstantanea().hashCode();
        }
        if (getEfiRealizacao() != null) {
            _hashCode += getEfiRealizacao().hashCode();
        }
        _hashCode += getFiltroIndicadorLabel();
        if (getFimParada() != null) {
            _hashCode += getFimParada().hashCode();
        }
        _hashCode += (isGargaloDinamico() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isGargaloTeorico() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getIdCp() != null) {
            _hashCode += getIdCp().hashCode();
        }
        _hashCode += new Long(getIdDwConsolId()).hashCode();
        _hashCode += new Long(getIdGt()).hashCode();
        _hashCode += new Long(getIdPt()).hashCode();
        _hashCode += new Long(getIdTurno()).hashCode();
        _hashCode += new Long(getIdtppt()).hashCode();
        if (getIndOEE() != null) {
            _hashCode += getIndOEE().hashCode();
        }
        if (getIndiceCavAtivas() != null) {
            _hashCode += getIndiceCavAtivas().hashCode();
        }
        if (getIndiceParadas() != null) {
            _hashCode += getIndiceParadas().hashCode();
        }
        if (getIndiceProducao() != null) {
            _hashCode += getIndiceProducao().hashCode();
        }
        _hashCode += (isIndiceRefugo3PorCento() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getIndiceRefugos() != null) {
            _hashCode += getIndiceRefugos().hashCode();
        }
        if (getIniParada() != null) {
            _hashCode += getIniParada().hashCode();
        }
        _hashCode += (isManutencaoPrev() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getMetaInstatanea() != null) {
            _hashCode += getMetaInstatanea().hashCode();
        }
        _hashCode += (isOffline() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isOpConcluida() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isOpConcluida90PorCento() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isParada() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isParadaComPeso() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isParadaManutencao() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isParadaNaoInformada() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isParadaSemPesoEfic() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isPerdaSincronismo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getProducaoLiquida() != null) {
            _hashCode += getProducaoLiquida().hashCode();
        }
        if (getProdutividadeOEE() != null) {
            _hashCode += getProdutividadeOEE().hashCode();
        }
        _hashCode += (isSaidaDaCelula() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isTemDwRt() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isTemOmAlgocor() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isTemOmCfg() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isTemOperador() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isTemPlanejamento() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isTemperaturaZonaActInf() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isTemperaturaZonaActSup() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isTemperaturaZonaCritInf() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isTemperaturaZonaCritSup() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isTemperaturaZonaIdeal() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getTipoAlgoritmo();
        _hashCode += getTipoGT();
        _hashCode += getTipoObj();
        _hashCode += getTipoPT();
        if (getUltimaOp() != null) {
            _hashCode += getUltimaOp().hashCode();
        }
        if (getUltimaParada() != null) {
            _hashCode += getUltimaParada().hashCode();
        }
        if (getUltimaTemperaturaLida() != null) {
            _hashCode += getUltimaTemperaturaLida().hashCode();
        }
        if (getUltimoMolde() != null) {
            _hashCode += getUltimoMolde().hashCode();
        }
        if (getUrlImg() != null) {
            _hashCode += getUrlImg().hashCode();
        }
        if (getX() != null) {
            _hashCode += getX().hashCode();
        }
        if (getX2() != null) {
            _hashCode += getX2().hashCode();
        }
        if (getY() != null) {
            _hashCode += getY().hashCode();
        }
        if (getY2() != null) {
            _hashCode += getY2().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObjRtMonitorizacaoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "objRtMonitorizacaoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alertaVidaUtil");
        elemField.setXmlName(new javax.xml.namespace.QName("", "alertaVidaUtil"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("areaResponsavel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "areaResponsavel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COR_FUNDO_DENTRO_META");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COR_FUNDO_DENTRO_META"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "colorDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COR_FUNDO_FORA_META");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COR_FUNDO_FORA_META"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "colorDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COR_FUNDO_OFFLINE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COR_FUNDO_OFFLINE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "colorDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COR_FUNDO_PARADA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COR_FUNDO_PARADA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "colorDTO"));
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
        elemField.setFieldName("cdFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdGt"));
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
        elemField.setFieldName("cdPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comAlerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comAlerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consolidacaoEmAtraso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "consolidacaoEmAtraso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corFundo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corFundo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "colorDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dentroDaMeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dentroDaMeta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("dsProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsProduto"));
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
        elemField.setFieldName("dsTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsTurno"));
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
        elemField.setFieldName("duracaoParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "duracaoParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolmologs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolmologs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmolog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("efiCiclos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "efiCiclos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("efiInstantanea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "efiInstantanea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("efiRealizacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "efiRealizacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filtroIndicadorLabel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "filtroIndicadorLabel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fimParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fimParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gargaloDinamico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gargaloDinamico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gargaloTeorico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gargaloTeorico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("idTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idtppt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idtppt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indOEE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indOEE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceCavAtivas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceCavAtivas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceParadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceParadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceProducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceProducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceRefugo3PorCento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceRefugo3porCento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceRefugos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceRefugos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iniParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "iniParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("manutencaoPrev");
        elemField.setXmlName(new javax.xml.namespace.QName("", "manutencaoPrev"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metaInstatanea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metaInstatanea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offline");
        elemField.setXmlName(new javax.xml.namespace.QName("", "offline"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("opConcluida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "opConcluida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("opConcluida90PorCento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "opConcluida90PorCento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaComPeso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaComPeso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaManutencao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaManutencao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaNaoInformada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaNaoInformada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaSemPesoEfic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaSemPesoEfic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdaSincronismo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdaSincronismo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoLiquida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoLiquida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produtividadeOEE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produtividadeOEE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saidaDaCelula");
        elemField.setXmlName(new javax.xml.namespace.QName("", "saidaDaCelula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temDwRt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temDwRt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temOmAlgocor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temOmAlgocor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temOmCfg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temOmCfg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temOperador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temOperador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temPlanejamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temPlanejamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temperaturaZonaActInf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temperaturaZonaActInf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temperaturaZonaActSup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temperaturaZonaActSup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temperaturaZonaCritInf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temperaturaZonaCritInf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temperaturaZonaCritSup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temperaturaZonaCritSup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temperaturaZonaIdeal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temperaturaZonaIdeal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoAlgoritmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoAlgoritmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoGT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoGT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoObj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoObj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoPT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoPT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ultimaOp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ultimaOp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ultimaParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ultimaParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ultimaTemperaturaLida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ultimaTemperaturaLida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ultimoMolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ultimoMolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlImg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlImg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x");
        elemField.setXmlName(new javax.xml.namespace.QName("", "x"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "x2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("y");
        elemField.setXmlName(new javax.xml.namespace.QName("", "y"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("y2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "y2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
