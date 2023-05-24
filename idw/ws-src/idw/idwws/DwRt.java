/**
 * DwRt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwRt  extends idw.idwws.DwRtTemplate  implements java.io.Serializable {
    private java.util.Calendar dtReferencia;

    private java.util.Calendar dthrHeartbeat;

    private java.util.Calendar dthrIciclo;

    private idw.idwws.DwConsolid[] dwConsolids;

    private idw.idwws.DwConsolpalog dwConsolpalog;

    private idw.idwws.DwRtcic[] dwRtcics;

    private idw.idwws.DwTurno dwTurno;

    private long idRt;

    private java.lang.Boolean isAlerta;

    private java.lang.Boolean isCip;

    private java.lang.Boolean isConforme;

    private java.lang.Boolean isGargalodinamico;

    private java.lang.Boolean isGargaloteorico;

    private java.lang.Boolean isManutencaopre;

    private java.lang.Boolean isOffline;

    private java.lang.Boolean isOperador;

    private java.lang.Boolean isParadafechaciclo;

    private java.lang.Boolean isParadapeso;

    private java.lang.Boolean isRegulagem;

    private java.lang.Boolean isSemplanejamento;

    private java.lang.Boolean isVidautilmolde;

    private java.lang.Integer msDthriciclo;

    private idw.idwws.OmPt omPt;

    private java.lang.Integer ordemCiclos;

    private java.math.BigDecimal pcsProducaoliquidaOp;

    private java.math.BigDecimal pcsProducaoplanejadaOp;

    private idw.idwws.PpCp ppCp;

    private java.math.BigDecimal segCiclopadraominimo;

    private java.math.BigDecimal segParadaparcial;

    private java.math.BigDecimal segUltimociclo;

    private org.apache.axis.types.UnsignedShort stFuncionamento;

    private org.apache.axis.types.UnsignedShort stQualidade;

    private java.math.BigDecimal ulttemperaturalida;

    public DwRt() {
    }

    public DwRt(
           java.util.Calendar dtReferencia,
           java.util.Calendar dthrHeartbeat,
           java.util.Calendar dthrIciclo,
           idw.idwws.DwConsolid[] dwConsolids,
           idw.idwws.DwConsolpalog dwConsolpalog,
           idw.idwws.DwRtcic[] dwRtcics,
           idw.idwws.DwTurno dwTurno,
           long idRt,
           java.lang.Boolean isAlerta,
           java.lang.Boolean isCip,
           java.lang.Boolean isConforme,
           java.lang.Boolean isGargalodinamico,
           java.lang.Boolean isGargaloteorico,
           java.lang.Boolean isManutencaopre,
           java.lang.Boolean isOffline,
           java.lang.Boolean isOperador,
           java.lang.Boolean isParadafechaciclo,
           java.lang.Boolean isParadapeso,
           java.lang.Boolean isRegulagem,
           java.lang.Boolean isSemplanejamento,
           java.lang.Boolean isVidautilmolde,
           java.lang.Integer msDthriciclo,
           idw.idwws.OmPt omPt,
           java.lang.Integer ordemCiclos,
           java.math.BigDecimal pcsProducaoliquidaOp,
           java.math.BigDecimal pcsProducaoplanejadaOp,
           idw.idwws.PpCp ppCp,
           java.math.BigDecimal segCiclopadraominimo,
           java.math.BigDecimal segParadaparcial,
           java.math.BigDecimal segUltimociclo,
           org.apache.axis.types.UnsignedShort stFuncionamento,
           org.apache.axis.types.UnsignedShort stQualidade,
           java.math.BigDecimal ulttemperaturalida) {
        this.dtReferencia = dtReferencia;
        this.dthrHeartbeat = dthrHeartbeat;
        this.dthrIciclo = dthrIciclo;
        this.dwConsolids = dwConsolids;
        this.dwConsolpalog = dwConsolpalog;
        this.dwRtcics = dwRtcics;
        this.dwTurno = dwTurno;
        this.idRt = idRt;
        this.isAlerta = isAlerta;
        this.isCip = isCip;
        this.isConforme = isConforme;
        this.isGargalodinamico = isGargalodinamico;
        this.isGargaloteorico = isGargaloteorico;
        this.isManutencaopre = isManutencaopre;
        this.isOffline = isOffline;
        this.isOperador = isOperador;
        this.isParadafechaciclo = isParadafechaciclo;
        this.isParadapeso = isParadapeso;
        this.isRegulagem = isRegulagem;
        this.isSemplanejamento = isSemplanejamento;
        this.isVidautilmolde = isVidautilmolde;
        this.msDthriciclo = msDthriciclo;
        this.omPt = omPt;
        this.ordemCiclos = ordemCiclos;
        this.pcsProducaoliquidaOp = pcsProducaoliquidaOp;
        this.pcsProducaoplanejadaOp = pcsProducaoplanejadaOp;
        this.ppCp = ppCp;
        this.segCiclopadraominimo = segCiclopadraominimo;
        this.segParadaparcial = segParadaparcial;
        this.segUltimociclo = segUltimociclo;
        this.stFuncionamento = stFuncionamento;
        this.stQualidade = stQualidade;
        this.ulttemperaturalida = ulttemperaturalida;
    }


    /**
     * Gets the dtReferencia value for this DwRt.
     * 
     * @return dtReferencia
     */
    public java.util.Calendar getDtReferencia() {
        return dtReferencia;
    }


    /**
     * Sets the dtReferencia value for this DwRt.
     * 
     * @param dtReferencia
     */
    public void setDtReferencia(java.util.Calendar dtReferencia) {
        this.dtReferencia = dtReferencia;
    }


    /**
     * Gets the dthrHeartbeat value for this DwRt.
     * 
     * @return dthrHeartbeat
     */
    public java.util.Calendar getDthrHeartbeat() {
        return dthrHeartbeat;
    }


    /**
     * Sets the dthrHeartbeat value for this DwRt.
     * 
     * @param dthrHeartbeat
     */
    public void setDthrHeartbeat(java.util.Calendar dthrHeartbeat) {
        this.dthrHeartbeat = dthrHeartbeat;
    }


    /**
     * Gets the dthrIciclo value for this DwRt.
     * 
     * @return dthrIciclo
     */
    public java.util.Calendar getDthrIciclo() {
        return dthrIciclo;
    }


    /**
     * Sets the dthrIciclo value for this DwRt.
     * 
     * @param dthrIciclo
     */
    public void setDthrIciclo(java.util.Calendar dthrIciclo) {
        this.dthrIciclo = dthrIciclo;
    }


    /**
     * Gets the dwConsolids value for this DwRt.
     * 
     * @return dwConsolids
     */
    public idw.idwws.DwConsolid[] getDwConsolids() {
        return dwConsolids;
    }


    /**
     * Sets the dwConsolids value for this DwRt.
     * 
     * @param dwConsolids
     */
    public void setDwConsolids(idw.idwws.DwConsolid[] dwConsolids) {
        this.dwConsolids = dwConsolids;
    }

    public idw.idwws.DwConsolid getDwConsolids(int i) {
        return this.dwConsolids[i];
    }

    public void setDwConsolids(int i, idw.idwws.DwConsolid _value) {
        this.dwConsolids[i] = _value;
    }


    /**
     * Gets the dwConsolpalog value for this DwRt.
     * 
     * @return dwConsolpalog
     */
    public idw.idwws.DwConsolpalog getDwConsolpalog() {
        return dwConsolpalog;
    }


    /**
     * Sets the dwConsolpalog value for this DwRt.
     * 
     * @param dwConsolpalog
     */
    public void setDwConsolpalog(idw.idwws.DwConsolpalog dwConsolpalog) {
        this.dwConsolpalog = dwConsolpalog;
    }


    /**
     * Gets the dwRtcics value for this DwRt.
     * 
     * @return dwRtcics
     */
    public idw.idwws.DwRtcic[] getDwRtcics() {
        return dwRtcics;
    }


    /**
     * Sets the dwRtcics value for this DwRt.
     * 
     * @param dwRtcics
     */
    public void setDwRtcics(idw.idwws.DwRtcic[] dwRtcics) {
        this.dwRtcics = dwRtcics;
    }

    public idw.idwws.DwRtcic getDwRtcics(int i) {
        return this.dwRtcics[i];
    }

    public void setDwRtcics(int i, idw.idwws.DwRtcic _value) {
        this.dwRtcics[i] = _value;
    }


    /**
     * Gets the dwTurno value for this DwRt.
     * 
     * @return dwTurno
     */
    public idw.idwws.DwTurno getDwTurno() {
        return dwTurno;
    }


    /**
     * Sets the dwTurno value for this DwRt.
     * 
     * @param dwTurno
     */
    public void setDwTurno(idw.idwws.DwTurno dwTurno) {
        this.dwTurno = dwTurno;
    }


    /**
     * Gets the idRt value for this DwRt.
     * 
     * @return idRt
     */
    public long getIdRt() {
        return idRt;
    }


    /**
     * Sets the idRt value for this DwRt.
     * 
     * @param idRt
     */
    public void setIdRt(long idRt) {
        this.idRt = idRt;
    }


    /**
     * Gets the isAlerta value for this DwRt.
     * 
     * @return isAlerta
     */
    public java.lang.Boolean getIsAlerta() {
        return isAlerta;
    }


    /**
     * Sets the isAlerta value for this DwRt.
     * 
     * @param isAlerta
     */
    public void setIsAlerta(java.lang.Boolean isAlerta) {
        this.isAlerta = isAlerta;
    }


    /**
     * Gets the isCip value for this DwRt.
     * 
     * @return isCip
     */
    public java.lang.Boolean getIsCip() {
        return isCip;
    }


    /**
     * Sets the isCip value for this DwRt.
     * 
     * @param isCip
     */
    public void setIsCip(java.lang.Boolean isCip) {
        this.isCip = isCip;
    }


    /**
     * Gets the isConforme value for this DwRt.
     * 
     * @return isConforme
     */
    public java.lang.Boolean getIsConforme() {
        return isConforme;
    }


    /**
     * Sets the isConforme value for this DwRt.
     * 
     * @param isConforme
     */
    public void setIsConforme(java.lang.Boolean isConforme) {
        this.isConforme = isConforme;
    }


    /**
     * Gets the isGargalodinamico value for this DwRt.
     * 
     * @return isGargalodinamico
     */
    public java.lang.Boolean getIsGargalodinamico() {
        return isGargalodinamico;
    }


    /**
     * Sets the isGargalodinamico value for this DwRt.
     * 
     * @param isGargalodinamico
     */
    public void setIsGargalodinamico(java.lang.Boolean isGargalodinamico) {
        this.isGargalodinamico = isGargalodinamico;
    }


    /**
     * Gets the isGargaloteorico value for this DwRt.
     * 
     * @return isGargaloteorico
     */
    public java.lang.Boolean getIsGargaloteorico() {
        return isGargaloteorico;
    }


    /**
     * Sets the isGargaloteorico value for this DwRt.
     * 
     * @param isGargaloteorico
     */
    public void setIsGargaloteorico(java.lang.Boolean isGargaloteorico) {
        this.isGargaloteorico = isGargaloteorico;
    }


    /**
     * Gets the isManutencaopre value for this DwRt.
     * 
     * @return isManutencaopre
     */
    public java.lang.Boolean getIsManutencaopre() {
        return isManutencaopre;
    }


    /**
     * Sets the isManutencaopre value for this DwRt.
     * 
     * @param isManutencaopre
     */
    public void setIsManutencaopre(java.lang.Boolean isManutencaopre) {
        this.isManutencaopre = isManutencaopre;
    }


    /**
     * Gets the isOffline value for this DwRt.
     * 
     * @return isOffline
     */
    public java.lang.Boolean getIsOffline() {
        return isOffline;
    }


    /**
     * Sets the isOffline value for this DwRt.
     * 
     * @param isOffline
     */
    public void setIsOffline(java.lang.Boolean isOffline) {
        this.isOffline = isOffline;
    }


    /**
     * Gets the isOperador value for this DwRt.
     * 
     * @return isOperador
     */
    public java.lang.Boolean getIsOperador() {
        return isOperador;
    }


    /**
     * Sets the isOperador value for this DwRt.
     * 
     * @param isOperador
     */
    public void setIsOperador(java.lang.Boolean isOperador) {
        this.isOperador = isOperador;
    }


    /**
     * Gets the isParadafechaciclo value for this DwRt.
     * 
     * @return isParadafechaciclo
     */
    public java.lang.Boolean getIsParadafechaciclo() {
        return isParadafechaciclo;
    }


    /**
     * Sets the isParadafechaciclo value for this DwRt.
     * 
     * @param isParadafechaciclo
     */
    public void setIsParadafechaciclo(java.lang.Boolean isParadafechaciclo) {
        this.isParadafechaciclo = isParadafechaciclo;
    }


    /**
     * Gets the isParadapeso value for this DwRt.
     * 
     * @return isParadapeso
     */
    public java.lang.Boolean getIsParadapeso() {
        return isParadapeso;
    }


    /**
     * Sets the isParadapeso value for this DwRt.
     * 
     * @param isParadapeso
     */
    public void setIsParadapeso(java.lang.Boolean isParadapeso) {
        this.isParadapeso = isParadapeso;
    }


    /**
     * Gets the isRegulagem value for this DwRt.
     * 
     * @return isRegulagem
     */
    public java.lang.Boolean getIsRegulagem() {
        return isRegulagem;
    }


    /**
     * Sets the isRegulagem value for this DwRt.
     * 
     * @param isRegulagem
     */
    public void setIsRegulagem(java.lang.Boolean isRegulagem) {
        this.isRegulagem = isRegulagem;
    }


    /**
     * Gets the isSemplanejamento value for this DwRt.
     * 
     * @return isSemplanejamento
     */
    public java.lang.Boolean getIsSemplanejamento() {
        return isSemplanejamento;
    }


    /**
     * Sets the isSemplanejamento value for this DwRt.
     * 
     * @param isSemplanejamento
     */
    public void setIsSemplanejamento(java.lang.Boolean isSemplanejamento) {
        this.isSemplanejamento = isSemplanejamento;
    }


    /**
     * Gets the isVidautilmolde value for this DwRt.
     * 
     * @return isVidautilmolde
     */
    public java.lang.Boolean getIsVidautilmolde() {
        return isVidautilmolde;
    }


    /**
     * Sets the isVidautilmolde value for this DwRt.
     * 
     * @param isVidautilmolde
     */
    public void setIsVidautilmolde(java.lang.Boolean isVidautilmolde) {
        this.isVidautilmolde = isVidautilmolde;
    }


    /**
     * Gets the msDthriciclo value for this DwRt.
     * 
     * @return msDthriciclo
     */
    public java.lang.Integer getMsDthriciclo() {
        return msDthriciclo;
    }


    /**
     * Sets the msDthriciclo value for this DwRt.
     * 
     * @param msDthriciclo
     */
    public void setMsDthriciclo(java.lang.Integer msDthriciclo) {
        this.msDthriciclo = msDthriciclo;
    }


    /**
     * Gets the omPt value for this DwRt.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this DwRt.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the ordemCiclos value for this DwRt.
     * 
     * @return ordemCiclos
     */
    public java.lang.Integer getOrdemCiclos() {
        return ordemCiclos;
    }


    /**
     * Sets the ordemCiclos value for this DwRt.
     * 
     * @param ordemCiclos
     */
    public void setOrdemCiclos(java.lang.Integer ordemCiclos) {
        this.ordemCiclos = ordemCiclos;
    }


    /**
     * Gets the pcsProducaoliquidaOp value for this DwRt.
     * 
     * @return pcsProducaoliquidaOp
     */
    public java.math.BigDecimal getPcsProducaoliquidaOp() {
        return pcsProducaoliquidaOp;
    }


    /**
     * Sets the pcsProducaoliquidaOp value for this DwRt.
     * 
     * @param pcsProducaoliquidaOp
     */
    public void setPcsProducaoliquidaOp(java.math.BigDecimal pcsProducaoliquidaOp) {
        this.pcsProducaoliquidaOp = pcsProducaoliquidaOp;
    }


    /**
     * Gets the pcsProducaoplanejadaOp value for this DwRt.
     * 
     * @return pcsProducaoplanejadaOp
     */
    public java.math.BigDecimal getPcsProducaoplanejadaOp() {
        return pcsProducaoplanejadaOp;
    }


    /**
     * Sets the pcsProducaoplanejadaOp value for this DwRt.
     * 
     * @param pcsProducaoplanejadaOp
     */
    public void setPcsProducaoplanejadaOp(java.math.BigDecimal pcsProducaoplanejadaOp) {
        this.pcsProducaoplanejadaOp = pcsProducaoplanejadaOp;
    }


    /**
     * Gets the ppCp value for this DwRt.
     * 
     * @return ppCp
     */
    public idw.idwws.PpCp getPpCp() {
        return ppCp;
    }


    /**
     * Sets the ppCp value for this DwRt.
     * 
     * @param ppCp
     */
    public void setPpCp(idw.idwws.PpCp ppCp) {
        this.ppCp = ppCp;
    }


    /**
     * Gets the segCiclopadraominimo value for this DwRt.
     * 
     * @return segCiclopadraominimo
     */
    public java.math.BigDecimal getSegCiclopadraominimo() {
        return segCiclopadraominimo;
    }


    /**
     * Sets the segCiclopadraominimo value for this DwRt.
     * 
     * @param segCiclopadraominimo
     */
    public void setSegCiclopadraominimo(java.math.BigDecimal segCiclopadraominimo) {
        this.segCiclopadraominimo = segCiclopadraominimo;
    }


    /**
     * Gets the segParadaparcial value for this DwRt.
     * 
     * @return segParadaparcial
     */
    public java.math.BigDecimal getSegParadaparcial() {
        return segParadaparcial;
    }


    /**
     * Sets the segParadaparcial value for this DwRt.
     * 
     * @param segParadaparcial
     */
    public void setSegParadaparcial(java.math.BigDecimal segParadaparcial) {
        this.segParadaparcial = segParadaparcial;
    }


    /**
     * Gets the segUltimociclo value for this DwRt.
     * 
     * @return segUltimociclo
     */
    public java.math.BigDecimal getSegUltimociclo() {
        return segUltimociclo;
    }


    /**
     * Sets the segUltimociclo value for this DwRt.
     * 
     * @param segUltimociclo
     */
    public void setSegUltimociclo(java.math.BigDecimal segUltimociclo) {
        this.segUltimociclo = segUltimociclo;
    }


    /**
     * Gets the stFuncionamento value for this DwRt.
     * 
     * @return stFuncionamento
     */
    public org.apache.axis.types.UnsignedShort getStFuncionamento() {
        return stFuncionamento;
    }


    /**
     * Sets the stFuncionamento value for this DwRt.
     * 
     * @param stFuncionamento
     */
    public void setStFuncionamento(org.apache.axis.types.UnsignedShort stFuncionamento) {
        this.stFuncionamento = stFuncionamento;
    }


    /**
     * Gets the stQualidade value for this DwRt.
     * 
     * @return stQualidade
     */
    public org.apache.axis.types.UnsignedShort getStQualidade() {
        return stQualidade;
    }


    /**
     * Sets the stQualidade value for this DwRt.
     * 
     * @param stQualidade
     */
    public void setStQualidade(org.apache.axis.types.UnsignedShort stQualidade) {
        this.stQualidade = stQualidade;
    }


    /**
     * Gets the ulttemperaturalida value for this DwRt.
     * 
     * @return ulttemperaturalida
     */
    public java.math.BigDecimal getUlttemperaturalida() {
        return ulttemperaturalida;
    }


    /**
     * Sets the ulttemperaturalida value for this DwRt.
     * 
     * @param ulttemperaturalida
     */
    public void setUlttemperaturalida(java.math.BigDecimal ulttemperaturalida) {
        this.ulttemperaturalida = ulttemperaturalida;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwRt)) return false;
        DwRt other = (DwRt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dtReferencia==null && other.getDtReferencia()==null) || 
             (this.dtReferencia!=null &&
              this.dtReferencia.equals(other.getDtReferencia()))) &&
            ((this.dthrHeartbeat==null && other.getDthrHeartbeat()==null) || 
             (this.dthrHeartbeat!=null &&
              this.dthrHeartbeat.equals(other.getDthrHeartbeat()))) &&
            ((this.dthrIciclo==null && other.getDthrIciclo()==null) || 
             (this.dthrIciclo!=null &&
              this.dthrIciclo.equals(other.getDthrIciclo()))) &&
            ((this.dwConsolids==null && other.getDwConsolids()==null) || 
             (this.dwConsolids!=null &&
              java.util.Arrays.equals(this.dwConsolids, other.getDwConsolids()))) &&
            ((this.dwConsolpalog==null && other.getDwConsolpalog()==null) || 
             (this.dwConsolpalog!=null &&
              this.dwConsolpalog.equals(other.getDwConsolpalog()))) &&
            ((this.dwRtcics==null && other.getDwRtcics()==null) || 
             (this.dwRtcics!=null &&
              java.util.Arrays.equals(this.dwRtcics, other.getDwRtcics()))) &&
            ((this.dwTurno==null && other.getDwTurno()==null) || 
             (this.dwTurno!=null &&
              this.dwTurno.equals(other.getDwTurno()))) &&
            this.idRt == other.getIdRt() &&
            ((this.isAlerta==null && other.getIsAlerta()==null) || 
             (this.isAlerta!=null &&
              this.isAlerta.equals(other.getIsAlerta()))) &&
            ((this.isCip==null && other.getIsCip()==null) || 
             (this.isCip!=null &&
              this.isCip.equals(other.getIsCip()))) &&
            ((this.isConforme==null && other.getIsConforme()==null) || 
             (this.isConforme!=null &&
              this.isConforme.equals(other.getIsConforme()))) &&
            ((this.isGargalodinamico==null && other.getIsGargalodinamico()==null) || 
             (this.isGargalodinamico!=null &&
              this.isGargalodinamico.equals(other.getIsGargalodinamico()))) &&
            ((this.isGargaloteorico==null && other.getIsGargaloteorico()==null) || 
             (this.isGargaloteorico!=null &&
              this.isGargaloteorico.equals(other.getIsGargaloteorico()))) &&
            ((this.isManutencaopre==null && other.getIsManutencaopre()==null) || 
             (this.isManutencaopre!=null &&
              this.isManutencaopre.equals(other.getIsManutencaopre()))) &&
            ((this.isOffline==null && other.getIsOffline()==null) || 
             (this.isOffline!=null &&
              this.isOffline.equals(other.getIsOffline()))) &&
            ((this.isOperador==null && other.getIsOperador()==null) || 
             (this.isOperador!=null &&
              this.isOperador.equals(other.getIsOperador()))) &&
            ((this.isParadafechaciclo==null && other.getIsParadafechaciclo()==null) || 
             (this.isParadafechaciclo!=null &&
              this.isParadafechaciclo.equals(other.getIsParadafechaciclo()))) &&
            ((this.isParadapeso==null && other.getIsParadapeso()==null) || 
             (this.isParadapeso!=null &&
              this.isParadapeso.equals(other.getIsParadapeso()))) &&
            ((this.isRegulagem==null && other.getIsRegulagem()==null) || 
             (this.isRegulagem!=null &&
              this.isRegulagem.equals(other.getIsRegulagem()))) &&
            ((this.isSemplanejamento==null && other.getIsSemplanejamento()==null) || 
             (this.isSemplanejamento!=null &&
              this.isSemplanejamento.equals(other.getIsSemplanejamento()))) &&
            ((this.isVidautilmolde==null && other.getIsVidautilmolde()==null) || 
             (this.isVidautilmolde!=null &&
              this.isVidautilmolde.equals(other.getIsVidautilmolde()))) &&
            ((this.msDthriciclo==null && other.getMsDthriciclo()==null) || 
             (this.msDthriciclo!=null &&
              this.msDthriciclo.equals(other.getMsDthriciclo()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.ordemCiclos==null && other.getOrdemCiclos()==null) || 
             (this.ordemCiclos!=null &&
              this.ordemCiclos.equals(other.getOrdemCiclos()))) &&
            ((this.pcsProducaoliquidaOp==null && other.getPcsProducaoliquidaOp()==null) || 
             (this.pcsProducaoliquidaOp!=null &&
              this.pcsProducaoliquidaOp.equals(other.getPcsProducaoliquidaOp()))) &&
            ((this.pcsProducaoplanejadaOp==null && other.getPcsProducaoplanejadaOp()==null) || 
             (this.pcsProducaoplanejadaOp!=null &&
              this.pcsProducaoplanejadaOp.equals(other.getPcsProducaoplanejadaOp()))) &&
            ((this.ppCp==null && other.getPpCp()==null) || 
             (this.ppCp!=null &&
              this.ppCp.equals(other.getPpCp()))) &&
            ((this.segCiclopadraominimo==null && other.getSegCiclopadraominimo()==null) || 
             (this.segCiclopadraominimo!=null &&
              this.segCiclopadraominimo.equals(other.getSegCiclopadraominimo()))) &&
            ((this.segParadaparcial==null && other.getSegParadaparcial()==null) || 
             (this.segParadaparcial!=null &&
              this.segParadaparcial.equals(other.getSegParadaparcial()))) &&
            ((this.segUltimociclo==null && other.getSegUltimociclo()==null) || 
             (this.segUltimociclo!=null &&
              this.segUltimociclo.equals(other.getSegUltimociclo()))) &&
            ((this.stFuncionamento==null && other.getStFuncionamento()==null) || 
             (this.stFuncionamento!=null &&
              this.stFuncionamento.equals(other.getStFuncionamento()))) &&
            ((this.stQualidade==null && other.getStQualidade()==null) || 
             (this.stQualidade!=null &&
              this.stQualidade.equals(other.getStQualidade()))) &&
            ((this.ulttemperaturalida==null && other.getUlttemperaturalida()==null) || 
             (this.ulttemperaturalida!=null &&
              this.ulttemperaturalida.equals(other.getUlttemperaturalida())));
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
        if (getDtReferencia() != null) {
            _hashCode += getDtReferencia().hashCode();
        }
        if (getDthrHeartbeat() != null) {
            _hashCode += getDthrHeartbeat().hashCode();
        }
        if (getDthrIciclo() != null) {
            _hashCode += getDthrIciclo().hashCode();
        }
        if (getDwConsolids() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolids());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolids(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolpalog() != null) {
            _hashCode += getDwConsolpalog().hashCode();
        }
        if (getDwRtcics() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwRtcics());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwRtcics(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTurno() != null) {
            _hashCode += getDwTurno().hashCode();
        }
        _hashCode += new Long(getIdRt()).hashCode();
        if (getIsAlerta() != null) {
            _hashCode += getIsAlerta().hashCode();
        }
        if (getIsCip() != null) {
            _hashCode += getIsCip().hashCode();
        }
        if (getIsConforme() != null) {
            _hashCode += getIsConforme().hashCode();
        }
        if (getIsGargalodinamico() != null) {
            _hashCode += getIsGargalodinamico().hashCode();
        }
        if (getIsGargaloteorico() != null) {
            _hashCode += getIsGargaloteorico().hashCode();
        }
        if (getIsManutencaopre() != null) {
            _hashCode += getIsManutencaopre().hashCode();
        }
        if (getIsOffline() != null) {
            _hashCode += getIsOffline().hashCode();
        }
        if (getIsOperador() != null) {
            _hashCode += getIsOperador().hashCode();
        }
        if (getIsParadafechaciclo() != null) {
            _hashCode += getIsParadafechaciclo().hashCode();
        }
        if (getIsParadapeso() != null) {
            _hashCode += getIsParadapeso().hashCode();
        }
        if (getIsRegulagem() != null) {
            _hashCode += getIsRegulagem().hashCode();
        }
        if (getIsSemplanejamento() != null) {
            _hashCode += getIsSemplanejamento().hashCode();
        }
        if (getIsVidautilmolde() != null) {
            _hashCode += getIsVidautilmolde().hashCode();
        }
        if (getMsDthriciclo() != null) {
            _hashCode += getMsDthriciclo().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getOrdemCiclos() != null) {
            _hashCode += getOrdemCiclos().hashCode();
        }
        if (getPcsProducaoliquidaOp() != null) {
            _hashCode += getPcsProducaoliquidaOp().hashCode();
        }
        if (getPcsProducaoplanejadaOp() != null) {
            _hashCode += getPcsProducaoplanejadaOp().hashCode();
        }
        if (getPpCp() != null) {
            _hashCode += getPpCp().hashCode();
        }
        if (getSegCiclopadraominimo() != null) {
            _hashCode += getSegCiclopadraominimo().hashCode();
        }
        if (getSegParadaparcial() != null) {
            _hashCode += getSegParadaparcial().hashCode();
        }
        if (getSegUltimociclo() != null) {
            _hashCode += getSegUltimociclo().hashCode();
        }
        if (getStFuncionamento() != null) {
            _hashCode += getStFuncionamento().hashCode();
        }
        if (getStQualidade() != null) {
            _hashCode += getStQualidade().hashCode();
        }
        if (getUlttemperaturalida() != null) {
            _hashCode += getUlttemperaturalida().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwRt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrHeartbeat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrHeartbeat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolids");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolids"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolpalog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpalog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpalog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRtcics");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRtcics"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRtcic"));
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
        elemField.setFieldName("idRt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idRt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAlerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isAlerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isCip");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isCip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isConforme");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isConforme"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isGargalodinamico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isGargalodinamico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isGargaloteorico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isGargaloteorico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isManutencaopre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isManutencaopre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isOffline");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isOffline"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isOperador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isOperador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isParadafechaciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isParadafechaciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isParadapeso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isParadapeso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("isSemplanejamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isSemplanejamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isVidautilmolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isVidautilmolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthriciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthriciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("ordemCiclos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordemCiclos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsProducaoliquidaOp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsProducaoliquidaOp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsProducaoplanejadaOp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsProducaoplanejadaOp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField.setFieldName("segCiclopadraominimo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCiclopadraominimo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segParadaparcial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segParadaparcial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segUltimociclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segUltimociclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stFuncionamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stFuncionamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stQualidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stQualidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ulttemperaturalida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ulttemperaturalida"));
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
