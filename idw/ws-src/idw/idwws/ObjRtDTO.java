/**
 * ObjRtDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ObjRtDTO  implements java.io.Serializable {
    private boolean alertaVidaUtil;

    private idw.idwws.ColorDTO COR_FUNDO_DENTRO_META;

    private idw.idwws.ColorDTO COR_FUNDO_FORA_META;

    private idw.idwws.ColorDTO COR_FUNDO_OFFLINE;

    private idw.idwws.ColorDTO COR_FUNDO_PARADA;

    private boolean comAlerta;

    private boolean consolidacaoEmAtraso;

    private idw.idwws.ColorDTO corFundo;

    private boolean dentroDaMeta;

    private java.util.Calendar dtReferencia;

    private idw.idwws.DwConsolmolog[] dwConsolmologs;

    private idw.idwws.DwTurno dwTurno;

    private boolean gargaloDinamico;

    private boolean gargaloTeorico;

    private boolean indiceRefugo3PorCento;

    private idw.idwws.ObjDTO objDTO;

    private boolean offline;

    private idw.idwws.OmProduto omproduto;

    private boolean opConcluida;

    private boolean opConcluida90PorCento;

    private boolean parada;

    private boolean paradaComPeso;

    private boolean paradaManutencao;

    private boolean paradaNaoInformada;

    private boolean paradaSemPesoEfic;

    private boolean perdaSincronismo;

    private boolean saidaDaCelula;

    private boolean semMolde;

    private boolean temDwRt;

    private boolean temOmAlgocor;

    private boolean temOmCfg;

    private boolean temOperador;

    private boolean temPlanejamento;

    private int tipoAlgoritmo;

    public ObjRtDTO() {
    }

    public ObjRtDTO(
           boolean alertaVidaUtil,
           idw.idwws.ColorDTO COR_FUNDO_DENTRO_META,
           idw.idwws.ColorDTO COR_FUNDO_FORA_META,
           idw.idwws.ColorDTO COR_FUNDO_OFFLINE,
           idw.idwws.ColorDTO COR_FUNDO_PARADA,
           boolean comAlerta,
           boolean consolidacaoEmAtraso,
           idw.idwws.ColorDTO corFundo,
           boolean dentroDaMeta,
           java.util.Calendar dtReferencia,
           idw.idwws.DwConsolmolog[] dwConsolmologs,
           idw.idwws.DwTurno dwTurno,
           boolean gargaloDinamico,
           boolean gargaloTeorico,
           boolean indiceRefugo3PorCento,
           idw.idwws.ObjDTO objDTO,
           boolean offline,
           idw.idwws.OmProduto omproduto,
           boolean opConcluida,
           boolean opConcluida90PorCento,
           boolean parada,
           boolean paradaComPeso,
           boolean paradaManutencao,
           boolean paradaNaoInformada,
           boolean paradaSemPesoEfic,
           boolean perdaSincronismo,
           boolean saidaDaCelula,
           boolean semMolde,
           boolean temDwRt,
           boolean temOmAlgocor,
           boolean temOmCfg,
           boolean temOperador,
           boolean temPlanejamento,
           int tipoAlgoritmo) {
           this.alertaVidaUtil = alertaVidaUtil;
           this.COR_FUNDO_DENTRO_META = COR_FUNDO_DENTRO_META;
           this.COR_FUNDO_FORA_META = COR_FUNDO_FORA_META;
           this.COR_FUNDO_OFFLINE = COR_FUNDO_OFFLINE;
           this.COR_FUNDO_PARADA = COR_FUNDO_PARADA;
           this.comAlerta = comAlerta;
           this.consolidacaoEmAtraso = consolidacaoEmAtraso;
           this.corFundo = corFundo;
           this.dentroDaMeta = dentroDaMeta;
           this.dtReferencia = dtReferencia;
           this.dwConsolmologs = dwConsolmologs;
           this.dwTurno = dwTurno;
           this.gargaloDinamico = gargaloDinamico;
           this.gargaloTeorico = gargaloTeorico;
           this.indiceRefugo3PorCento = indiceRefugo3PorCento;
           this.objDTO = objDTO;
           this.offline = offline;
           this.omproduto = omproduto;
           this.opConcluida = opConcluida;
           this.opConcluida90PorCento = opConcluida90PorCento;
           this.parada = parada;
           this.paradaComPeso = paradaComPeso;
           this.paradaManutencao = paradaManutencao;
           this.paradaNaoInformada = paradaNaoInformada;
           this.paradaSemPesoEfic = paradaSemPesoEfic;
           this.perdaSincronismo = perdaSincronismo;
           this.saidaDaCelula = saidaDaCelula;
           this.semMolde = semMolde;
           this.temDwRt = temDwRt;
           this.temOmAlgocor = temOmAlgocor;
           this.temOmCfg = temOmCfg;
           this.temOperador = temOperador;
           this.temPlanejamento = temPlanejamento;
           this.tipoAlgoritmo = tipoAlgoritmo;
    }


    /**
     * Gets the alertaVidaUtil value for this ObjRtDTO.
     * 
     * @return alertaVidaUtil
     */
    public boolean isAlertaVidaUtil() {
        return alertaVidaUtil;
    }


    /**
     * Sets the alertaVidaUtil value for this ObjRtDTO.
     * 
     * @param alertaVidaUtil
     */
    public void setAlertaVidaUtil(boolean alertaVidaUtil) {
        this.alertaVidaUtil = alertaVidaUtil;
    }


    /**
     * Gets the COR_FUNDO_DENTRO_META value for this ObjRtDTO.
     * 
     * @return COR_FUNDO_DENTRO_META
     */
    public idw.idwws.ColorDTO getCOR_FUNDO_DENTRO_META() {
        return COR_FUNDO_DENTRO_META;
    }


    /**
     * Sets the COR_FUNDO_DENTRO_META value for this ObjRtDTO.
     * 
     * @param COR_FUNDO_DENTRO_META
     */
    public void setCOR_FUNDO_DENTRO_META(idw.idwws.ColorDTO COR_FUNDO_DENTRO_META) {
        this.COR_FUNDO_DENTRO_META = COR_FUNDO_DENTRO_META;
    }


    /**
     * Gets the COR_FUNDO_FORA_META value for this ObjRtDTO.
     * 
     * @return COR_FUNDO_FORA_META
     */
    public idw.idwws.ColorDTO getCOR_FUNDO_FORA_META() {
        return COR_FUNDO_FORA_META;
    }


    /**
     * Sets the COR_FUNDO_FORA_META value for this ObjRtDTO.
     * 
     * @param COR_FUNDO_FORA_META
     */
    public void setCOR_FUNDO_FORA_META(idw.idwws.ColorDTO COR_FUNDO_FORA_META) {
        this.COR_FUNDO_FORA_META = COR_FUNDO_FORA_META;
    }


    /**
     * Gets the COR_FUNDO_OFFLINE value for this ObjRtDTO.
     * 
     * @return COR_FUNDO_OFFLINE
     */
    public idw.idwws.ColorDTO getCOR_FUNDO_OFFLINE() {
        return COR_FUNDO_OFFLINE;
    }


    /**
     * Sets the COR_FUNDO_OFFLINE value for this ObjRtDTO.
     * 
     * @param COR_FUNDO_OFFLINE
     */
    public void setCOR_FUNDO_OFFLINE(idw.idwws.ColorDTO COR_FUNDO_OFFLINE) {
        this.COR_FUNDO_OFFLINE = COR_FUNDO_OFFLINE;
    }


    /**
     * Gets the COR_FUNDO_PARADA value for this ObjRtDTO.
     * 
     * @return COR_FUNDO_PARADA
     */
    public idw.idwws.ColorDTO getCOR_FUNDO_PARADA() {
        return COR_FUNDO_PARADA;
    }


    /**
     * Sets the COR_FUNDO_PARADA value for this ObjRtDTO.
     * 
     * @param COR_FUNDO_PARADA
     */
    public void setCOR_FUNDO_PARADA(idw.idwws.ColorDTO COR_FUNDO_PARADA) {
        this.COR_FUNDO_PARADA = COR_FUNDO_PARADA;
    }


    /**
     * Gets the comAlerta value for this ObjRtDTO.
     * 
     * @return comAlerta
     */
    public boolean isComAlerta() {
        return comAlerta;
    }


    /**
     * Sets the comAlerta value for this ObjRtDTO.
     * 
     * @param comAlerta
     */
    public void setComAlerta(boolean comAlerta) {
        this.comAlerta = comAlerta;
    }


    /**
     * Gets the consolidacaoEmAtraso value for this ObjRtDTO.
     * 
     * @return consolidacaoEmAtraso
     */
    public boolean isConsolidacaoEmAtraso() {
        return consolidacaoEmAtraso;
    }


    /**
     * Sets the consolidacaoEmAtraso value for this ObjRtDTO.
     * 
     * @param consolidacaoEmAtraso
     */
    public void setConsolidacaoEmAtraso(boolean consolidacaoEmAtraso) {
        this.consolidacaoEmAtraso = consolidacaoEmAtraso;
    }


    /**
     * Gets the corFundo value for this ObjRtDTO.
     * 
     * @return corFundo
     */
    public idw.idwws.ColorDTO getCorFundo() {
        return corFundo;
    }


    /**
     * Sets the corFundo value for this ObjRtDTO.
     * 
     * @param corFundo
     */
    public void setCorFundo(idw.idwws.ColorDTO corFundo) {
        this.corFundo = corFundo;
    }


    /**
     * Gets the dentroDaMeta value for this ObjRtDTO.
     * 
     * @return dentroDaMeta
     */
    public boolean isDentroDaMeta() {
        return dentroDaMeta;
    }


    /**
     * Sets the dentroDaMeta value for this ObjRtDTO.
     * 
     * @param dentroDaMeta
     */
    public void setDentroDaMeta(boolean dentroDaMeta) {
        this.dentroDaMeta = dentroDaMeta;
    }


    /**
     * Gets the dtReferencia value for this ObjRtDTO.
     * 
     * @return dtReferencia
     */
    public java.util.Calendar getDtReferencia() {
        return dtReferencia;
    }


    /**
     * Sets the dtReferencia value for this ObjRtDTO.
     * 
     * @param dtReferencia
     */
    public void setDtReferencia(java.util.Calendar dtReferencia) {
        this.dtReferencia = dtReferencia;
    }


    /**
     * Gets the dwConsolmologs value for this ObjRtDTO.
     * 
     * @return dwConsolmologs
     */
    public idw.idwws.DwConsolmolog[] getDwConsolmologs() {
        return dwConsolmologs;
    }


    /**
     * Sets the dwConsolmologs value for this ObjRtDTO.
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
     * Gets the dwTurno value for this ObjRtDTO.
     * 
     * @return dwTurno
     */
    public idw.idwws.DwTurno getDwTurno() {
        return dwTurno;
    }


    /**
     * Sets the dwTurno value for this ObjRtDTO.
     * 
     * @param dwTurno
     */
    public void setDwTurno(idw.idwws.DwTurno dwTurno) {
        this.dwTurno = dwTurno;
    }


    /**
     * Gets the gargaloDinamico value for this ObjRtDTO.
     * 
     * @return gargaloDinamico
     */
    public boolean isGargaloDinamico() {
        return gargaloDinamico;
    }


    /**
     * Sets the gargaloDinamico value for this ObjRtDTO.
     * 
     * @param gargaloDinamico
     */
    public void setGargaloDinamico(boolean gargaloDinamico) {
        this.gargaloDinamico = gargaloDinamico;
    }


    /**
     * Gets the gargaloTeorico value for this ObjRtDTO.
     * 
     * @return gargaloTeorico
     */
    public boolean isGargaloTeorico() {
        return gargaloTeorico;
    }


    /**
     * Sets the gargaloTeorico value for this ObjRtDTO.
     * 
     * @param gargaloTeorico
     */
    public void setGargaloTeorico(boolean gargaloTeorico) {
        this.gargaloTeorico = gargaloTeorico;
    }


    /**
     * Gets the indiceRefugo3PorCento value for this ObjRtDTO.
     * 
     * @return indiceRefugo3PorCento
     */
    public boolean isIndiceRefugo3PorCento() {
        return indiceRefugo3PorCento;
    }


    /**
     * Sets the indiceRefugo3PorCento value for this ObjRtDTO.
     * 
     * @param indiceRefugo3PorCento
     */
    public void setIndiceRefugo3PorCento(boolean indiceRefugo3PorCento) {
        this.indiceRefugo3PorCento = indiceRefugo3PorCento;
    }


    /**
     * Gets the objDTO value for this ObjRtDTO.
     * 
     * @return objDTO
     */
    public idw.idwws.ObjDTO getObjDTO() {
        return objDTO;
    }


    /**
     * Sets the objDTO value for this ObjRtDTO.
     * 
     * @param objDTO
     */
    public void setObjDTO(idw.idwws.ObjDTO objDTO) {
        this.objDTO = objDTO;
    }


    /**
     * Gets the offline value for this ObjRtDTO.
     * 
     * @return offline
     */
    public boolean isOffline() {
        return offline;
    }


    /**
     * Sets the offline value for this ObjRtDTO.
     * 
     * @param offline
     */
    public void setOffline(boolean offline) {
        this.offline = offline;
    }


    /**
     * Gets the omproduto value for this ObjRtDTO.
     * 
     * @return omproduto
     */
    public idw.idwws.OmProduto getOmproduto() {
        return omproduto;
    }


    /**
     * Sets the omproduto value for this ObjRtDTO.
     * 
     * @param omproduto
     */
    public void setOmproduto(idw.idwws.OmProduto omproduto) {
        this.omproduto = omproduto;
    }


    /**
     * Gets the opConcluida value for this ObjRtDTO.
     * 
     * @return opConcluida
     */
    public boolean isOpConcluida() {
        return opConcluida;
    }


    /**
     * Sets the opConcluida value for this ObjRtDTO.
     * 
     * @param opConcluida
     */
    public void setOpConcluida(boolean opConcluida) {
        this.opConcluida = opConcluida;
    }


    /**
     * Gets the opConcluida90PorCento value for this ObjRtDTO.
     * 
     * @return opConcluida90PorCento
     */
    public boolean isOpConcluida90PorCento() {
        return opConcluida90PorCento;
    }


    /**
     * Sets the opConcluida90PorCento value for this ObjRtDTO.
     * 
     * @param opConcluida90PorCento
     */
    public void setOpConcluida90PorCento(boolean opConcluida90PorCento) {
        this.opConcluida90PorCento = opConcluida90PorCento;
    }


    /**
     * Gets the parada value for this ObjRtDTO.
     * 
     * @return parada
     */
    public boolean isParada() {
        return parada;
    }


    /**
     * Sets the parada value for this ObjRtDTO.
     * 
     * @param parada
     */
    public void setParada(boolean parada) {
        this.parada = parada;
    }


    /**
     * Gets the paradaComPeso value for this ObjRtDTO.
     * 
     * @return paradaComPeso
     */
    public boolean isParadaComPeso() {
        return paradaComPeso;
    }


    /**
     * Sets the paradaComPeso value for this ObjRtDTO.
     * 
     * @param paradaComPeso
     */
    public void setParadaComPeso(boolean paradaComPeso) {
        this.paradaComPeso = paradaComPeso;
    }


    /**
     * Gets the paradaManutencao value for this ObjRtDTO.
     * 
     * @return paradaManutencao
     */
    public boolean isParadaManutencao() {
        return paradaManutencao;
    }


    /**
     * Sets the paradaManutencao value for this ObjRtDTO.
     * 
     * @param paradaManutencao
     */
    public void setParadaManutencao(boolean paradaManutencao) {
        this.paradaManutencao = paradaManutencao;
    }


    /**
     * Gets the paradaNaoInformada value for this ObjRtDTO.
     * 
     * @return paradaNaoInformada
     */
    public boolean isParadaNaoInformada() {
        return paradaNaoInformada;
    }


    /**
     * Sets the paradaNaoInformada value for this ObjRtDTO.
     * 
     * @param paradaNaoInformada
     */
    public void setParadaNaoInformada(boolean paradaNaoInformada) {
        this.paradaNaoInformada = paradaNaoInformada;
    }


    /**
     * Gets the paradaSemPesoEfic value for this ObjRtDTO.
     * 
     * @return paradaSemPesoEfic
     */
    public boolean isParadaSemPesoEfic() {
        return paradaSemPesoEfic;
    }


    /**
     * Sets the paradaSemPesoEfic value for this ObjRtDTO.
     * 
     * @param paradaSemPesoEfic
     */
    public void setParadaSemPesoEfic(boolean paradaSemPesoEfic) {
        this.paradaSemPesoEfic = paradaSemPesoEfic;
    }


    /**
     * Gets the perdaSincronismo value for this ObjRtDTO.
     * 
     * @return perdaSincronismo
     */
    public boolean isPerdaSincronismo() {
        return perdaSincronismo;
    }


    /**
     * Sets the perdaSincronismo value for this ObjRtDTO.
     * 
     * @param perdaSincronismo
     */
    public void setPerdaSincronismo(boolean perdaSincronismo) {
        this.perdaSincronismo = perdaSincronismo;
    }


    /**
     * Gets the saidaDaCelula value for this ObjRtDTO.
     * 
     * @return saidaDaCelula
     */
    public boolean isSaidaDaCelula() {
        return saidaDaCelula;
    }


    /**
     * Sets the saidaDaCelula value for this ObjRtDTO.
     * 
     * @param saidaDaCelula
     */
    public void setSaidaDaCelula(boolean saidaDaCelula) {
        this.saidaDaCelula = saidaDaCelula;
    }


    /**
     * Gets the semMolde value for this ObjRtDTO.
     * 
     * @return semMolde
     */
    public boolean isSemMolde() {
        return semMolde;
    }


    /**
     * Sets the semMolde value for this ObjRtDTO.
     * 
     * @param semMolde
     */
    public void setSemMolde(boolean semMolde) {
        this.semMolde = semMolde;
    }


    /**
     * Gets the temDwRt value for this ObjRtDTO.
     * 
     * @return temDwRt
     */
    public boolean isTemDwRt() {
        return temDwRt;
    }


    /**
     * Sets the temDwRt value for this ObjRtDTO.
     * 
     * @param temDwRt
     */
    public void setTemDwRt(boolean temDwRt) {
        this.temDwRt = temDwRt;
    }


    /**
     * Gets the temOmAlgocor value for this ObjRtDTO.
     * 
     * @return temOmAlgocor
     */
    public boolean isTemOmAlgocor() {
        return temOmAlgocor;
    }


    /**
     * Sets the temOmAlgocor value for this ObjRtDTO.
     * 
     * @param temOmAlgocor
     */
    public void setTemOmAlgocor(boolean temOmAlgocor) {
        this.temOmAlgocor = temOmAlgocor;
    }


    /**
     * Gets the temOmCfg value for this ObjRtDTO.
     * 
     * @return temOmCfg
     */
    public boolean isTemOmCfg() {
        return temOmCfg;
    }


    /**
     * Sets the temOmCfg value for this ObjRtDTO.
     * 
     * @param temOmCfg
     */
    public void setTemOmCfg(boolean temOmCfg) {
        this.temOmCfg = temOmCfg;
    }


    /**
     * Gets the temOperador value for this ObjRtDTO.
     * 
     * @return temOperador
     */
    public boolean isTemOperador() {
        return temOperador;
    }


    /**
     * Sets the temOperador value for this ObjRtDTO.
     * 
     * @param temOperador
     */
    public void setTemOperador(boolean temOperador) {
        this.temOperador = temOperador;
    }


    /**
     * Gets the temPlanejamento value for this ObjRtDTO.
     * 
     * @return temPlanejamento
     */
    public boolean isTemPlanejamento() {
        return temPlanejamento;
    }


    /**
     * Sets the temPlanejamento value for this ObjRtDTO.
     * 
     * @param temPlanejamento
     */
    public void setTemPlanejamento(boolean temPlanejamento) {
        this.temPlanejamento = temPlanejamento;
    }


    /**
     * Gets the tipoAlgoritmo value for this ObjRtDTO.
     * 
     * @return tipoAlgoritmo
     */
    public int getTipoAlgoritmo() {
        return tipoAlgoritmo;
    }


    /**
     * Sets the tipoAlgoritmo value for this ObjRtDTO.
     * 
     * @param tipoAlgoritmo
     */
    public void setTipoAlgoritmo(int tipoAlgoritmo) {
        this.tipoAlgoritmo = tipoAlgoritmo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObjRtDTO)) return false;
        ObjRtDTO other = (ObjRtDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.alertaVidaUtil == other.isAlertaVidaUtil() &&
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
            this.comAlerta == other.isComAlerta() &&
            this.consolidacaoEmAtraso == other.isConsolidacaoEmAtraso() &&
            ((this.corFundo==null && other.getCorFundo()==null) || 
             (this.corFundo!=null &&
              this.corFundo.equals(other.getCorFundo()))) &&
            this.dentroDaMeta == other.isDentroDaMeta() &&
            ((this.dtReferencia==null && other.getDtReferencia()==null) || 
             (this.dtReferencia!=null &&
              this.dtReferencia.equals(other.getDtReferencia()))) &&
            ((this.dwConsolmologs==null && other.getDwConsolmologs()==null) || 
             (this.dwConsolmologs!=null &&
              java.util.Arrays.equals(this.dwConsolmologs, other.getDwConsolmologs()))) &&
            ((this.dwTurno==null && other.getDwTurno()==null) || 
             (this.dwTurno!=null &&
              this.dwTurno.equals(other.getDwTurno()))) &&
            this.gargaloDinamico == other.isGargaloDinamico() &&
            this.gargaloTeorico == other.isGargaloTeorico() &&
            this.indiceRefugo3PorCento == other.isIndiceRefugo3PorCento() &&
            ((this.objDTO==null && other.getObjDTO()==null) || 
             (this.objDTO!=null &&
              this.objDTO.equals(other.getObjDTO()))) &&
            this.offline == other.isOffline() &&
            ((this.omproduto==null && other.getOmproduto()==null) || 
             (this.omproduto!=null &&
              this.omproduto.equals(other.getOmproduto()))) &&
            this.opConcluida == other.isOpConcluida() &&
            this.opConcluida90PorCento == other.isOpConcluida90PorCento() &&
            this.parada == other.isParada() &&
            this.paradaComPeso == other.isParadaComPeso() &&
            this.paradaManutencao == other.isParadaManutencao() &&
            this.paradaNaoInformada == other.isParadaNaoInformada() &&
            this.paradaSemPesoEfic == other.isParadaSemPesoEfic() &&
            this.perdaSincronismo == other.isPerdaSincronismo() &&
            this.saidaDaCelula == other.isSaidaDaCelula() &&
            this.semMolde == other.isSemMolde() &&
            this.temDwRt == other.isTemDwRt() &&
            this.temOmAlgocor == other.isTemOmAlgocor() &&
            this.temOmCfg == other.isTemOmCfg() &&
            this.temOperador == other.isTemOperador() &&
            this.temPlanejamento == other.isTemPlanejamento() &&
            this.tipoAlgoritmo == other.getTipoAlgoritmo();
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
        _hashCode += (isComAlerta() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isConsolidacaoEmAtraso() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCorFundo() != null) {
            _hashCode += getCorFundo().hashCode();
        }
        _hashCode += (isDentroDaMeta() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDtReferencia() != null) {
            _hashCode += getDtReferencia().hashCode();
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
        if (getDwTurno() != null) {
            _hashCode += getDwTurno().hashCode();
        }
        _hashCode += (isGargaloDinamico() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isGargaloTeorico() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIndiceRefugo3PorCento() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getObjDTO() != null) {
            _hashCode += getObjDTO().hashCode();
        }
        _hashCode += (isOffline() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getOmproduto() != null) {
            _hashCode += getOmproduto().hashCode();
        }
        _hashCode += (isOpConcluida() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isOpConcluida90PorCento() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isParada() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isParadaComPeso() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isParadaManutencao() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isParadaNaoInformada() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isParadaSemPesoEfic() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isPerdaSincronismo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isSaidaDaCelula() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isSemMolde() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isTemDwRt() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isTemOmAlgocor() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isTemOmCfg() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isTemOperador() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isTemPlanejamento() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getTipoAlgoritmo();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObjRtDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "objRtDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alertaVidaUtil");
        elemField.setXmlName(new javax.xml.namespace.QName("", "alertaVidaUtil"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("dtReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("dwTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTurno"));
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
        elemField.setFieldName("indiceRefugo3PorCento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceRefugo3porCento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "objDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "objDTO"));
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
        elemField.setFieldName("omproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("saidaDaCelula");
        elemField.setXmlName(new javax.xml.namespace.QName("", "saidaDaCelula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("semMolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "semMolde"));
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
        elemField.setFieldName("tipoAlgoritmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoAlgoritmo"));
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
