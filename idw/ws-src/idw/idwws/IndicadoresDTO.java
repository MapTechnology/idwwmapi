/**
 * IndicadoresDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IndicadoresDTO  extends idw.idwws.AbstractTemplate  implements java.io.Serializable {
    private java.math.BigDecimal cavAtivas;

    private java.math.BigDecimal cavAtivasMedia;

    private java.math.BigDecimal cavTotal;

    private java.math.BigDecimal cavTotalMedia;

    private java.lang.String cdCp;

    private java.lang.String cdPt;

    private java.math.BigDecimal cicloMedio;

    private java.math.BigDecimal cicloPadrao;

    private java.math.BigDecimal cicloPadraoMedio;

    private java.util.Calendar dtHrFConsol;

    private java.util.Calendar dtHrFPeriodo;

    private java.util.Calendar dtHrIConsol;

    private java.util.Calendar dtHrIPeriodo;

    private java.math.BigDecimal eficienciaCiclo;

    private java.math.BigDecimal eficienciaInstantanea;

    private java.math.BigDecimal eficienciaRealizacao;

    private java.math.BigDecimal IDO;

    private java.math.BigDecimal IPA;

    private java.math.BigDecimal ITO;

    private java.math.BigDecimal indiceCavidadesAtivas;

    private java.math.BigDecimal indiceParada;

    private java.math.BigDecimal indicePerda;

    private java.math.BigDecimal indiceProducao;

    private java.math.BigDecimal indiceRefugo;

    private java.math.BigDecimal oee;

    private java.math.BigDecimal perdaCavidade;

    private java.math.BigDecimal perdaCiclo;

    private java.math.BigDecimal perdaParada;

    private java.math.BigDecimal perdaTotal;

    private java.math.BigDecimal pesoBruto;

    private java.math.BigDecimal pesoLiquido;

    private java.math.BigDecimal producaoBruta;

    private java.math.BigDecimal producaoLiquida;

    private java.math.BigDecimal producaoPlanejada;

    private java.math.BigDecimal producaoPlanejadaMedia;

    private java.math.BigDecimal producaoPrevista;

    private java.math.BigDecimal producaoRefugada;

    private long qtAgrupCicloPadrao;

    private long qtAgrupProducaoPlanejada;

    private java.math.BigDecimal qtCicloImprodutivo;

    private java.math.BigDecimal qtCicloProdutivo;

    private java.math.BigDecimal qtCicloRegulagem;

    private java.math.BigDecimal qtParadaDefault;

    private java.math.BigDecimal qtParadaFds;

    private java.math.BigDecimal qtParadaImprev;

    private java.math.BigDecimal qtParadaMdo;

    private java.math.BigDecimal qtParadaMtbf;

    private java.math.BigDecimal qtParadaMttr;

    private java.math.BigDecimal qtParadaPa;

    private java.math.BigDecimal qtParadaPao;

    private java.math.BigDecimal qtParadaPp;

    private java.math.BigDecimal qtParadaPrev;

    private java.math.BigDecimal qtParadaPtp;

    private java.math.BigDecimal qtParadaRegulagem;

    private java.math.BigDecimal qtParadaScp;

    private java.math.BigDecimal qtParadaSemCnx;

    private java.math.BigDecimal qtParadaSemEvt;

    private java.math.BigDecimal qtParadaSemOp;

    private java.math.BigDecimal ritmo;

    private java.math.BigDecimal tempoAlerta;

    private java.math.BigDecimal tempoAtivo;

    private java.math.BigDecimal tempoBoas;

    private java.math.BigDecimal tempoCicloImprodutivo;

    private java.math.BigDecimal tempoCicloProdutivo;

    private java.math.BigDecimal tempoCicloRegulagem;

    private java.math.BigDecimal tempoParadaAb;

    private java.math.BigDecimal tempoParadaCp;

    private java.math.BigDecimal tempoParadaCpVr;

    private java.math.BigDecimal tempoParadaDefault;

    private java.math.BigDecimal tempoParadaFds;

    private java.math.BigDecimal tempoParadaImprev;

    private java.math.BigDecimal tempoParadaMdo;

    private java.math.BigDecimal tempoParadaMtbf;

    private java.math.BigDecimal tempoParadaMttr;

    private java.math.BigDecimal tempoParadaPa;

    private java.math.BigDecimal tempoParadaPao;

    private java.math.BigDecimal tempoParadaPp;

    private java.math.BigDecimal tempoParadaPrev;

    private java.math.BigDecimal tempoParadaPtp;

    private java.math.BigDecimal tempoParadaRegulagem;

    private java.math.BigDecimal tempoParadaScp;

    private java.math.BigDecimal tempoParadaSemCnx;

    private java.math.BigDecimal tempoParadaSemEvt;

    private java.math.BigDecimal tempoParadaSemOp;

    private java.math.BigDecimal tempoParadaSp;

    private java.math.BigDecimal tempoParadaSpVr;

    private java.math.BigDecimal tempoPerdaCavidade;

    private java.math.BigDecimal tempoPeriodo;

    private java.math.BigDecimal tempoProdutivo;

    private java.math.BigDecimal tempoRefugadas;

    private java.math.BigDecimal tempoRefugado;

    private java.math.BigDecimal tempoTotal;

    private java.math.BigDecimal tempoTrabalhado;

    private java.math.BigDecimal ultimoCiclo;

    public IndicadoresDTO() {
    }

    public IndicadoresDTO(
           java.math.BigDecimal cavAtivas,
           java.math.BigDecimal cavAtivasMedia,
           java.math.BigDecimal cavTotal,
           java.math.BigDecimal cavTotalMedia,
           java.lang.String cdCp,
           java.lang.String cdPt,
           java.math.BigDecimal cicloMedio,
           java.math.BigDecimal cicloPadrao,
           java.math.BigDecimal cicloPadraoMedio,
           java.util.Calendar dtHrFConsol,
           java.util.Calendar dtHrFPeriodo,
           java.util.Calendar dtHrIConsol,
           java.util.Calendar dtHrIPeriodo,
           java.math.BigDecimal eficienciaCiclo,
           java.math.BigDecimal eficienciaInstantanea,
           java.math.BigDecimal eficienciaRealizacao,
           java.math.BigDecimal IDO,
           java.math.BigDecimal IPA,
           java.math.BigDecimal ITO,
           java.math.BigDecimal indiceCavidadesAtivas,
           java.math.BigDecimal indiceParada,
           java.math.BigDecimal indicePerda,
           java.math.BigDecimal indiceProducao,
           java.math.BigDecimal indiceRefugo,
           java.math.BigDecimal oee,
           java.math.BigDecimal perdaCavidade,
           java.math.BigDecimal perdaCiclo,
           java.math.BigDecimal perdaParada,
           java.math.BigDecimal perdaTotal,
           java.math.BigDecimal pesoBruto,
           java.math.BigDecimal pesoLiquido,
           java.math.BigDecimal producaoBruta,
           java.math.BigDecimal producaoLiquida,
           java.math.BigDecimal producaoPlanejada,
           java.math.BigDecimal producaoPlanejadaMedia,
           java.math.BigDecimal producaoPrevista,
           java.math.BigDecimal producaoRefugada,
           long qtAgrupCicloPadrao,
           long qtAgrupProducaoPlanejada,
           java.math.BigDecimal qtCicloImprodutivo,
           java.math.BigDecimal qtCicloProdutivo,
           java.math.BigDecimal qtCicloRegulagem,
           java.math.BigDecimal qtParadaDefault,
           java.math.BigDecimal qtParadaFds,
           java.math.BigDecimal qtParadaImprev,
           java.math.BigDecimal qtParadaMdo,
           java.math.BigDecimal qtParadaMtbf,
           java.math.BigDecimal qtParadaMttr,
           java.math.BigDecimal qtParadaPa,
           java.math.BigDecimal qtParadaPao,
           java.math.BigDecimal qtParadaPp,
           java.math.BigDecimal qtParadaPrev,
           java.math.BigDecimal qtParadaPtp,
           java.math.BigDecimal qtParadaRegulagem,
           java.math.BigDecimal qtParadaScp,
           java.math.BigDecimal qtParadaSemCnx,
           java.math.BigDecimal qtParadaSemEvt,
           java.math.BigDecimal qtParadaSemOp,
           java.math.BigDecimal ritmo,
           java.math.BigDecimal tempoAlerta,
           java.math.BigDecimal tempoAtivo,
           java.math.BigDecimal tempoBoas,
           java.math.BigDecimal tempoCicloImprodutivo,
           java.math.BigDecimal tempoCicloProdutivo,
           java.math.BigDecimal tempoCicloRegulagem,
           java.math.BigDecimal tempoParadaAb,
           java.math.BigDecimal tempoParadaCp,
           java.math.BigDecimal tempoParadaCpVr,
           java.math.BigDecimal tempoParadaDefault,
           java.math.BigDecimal tempoParadaFds,
           java.math.BigDecimal tempoParadaImprev,
           java.math.BigDecimal tempoParadaMdo,
           java.math.BigDecimal tempoParadaMtbf,
           java.math.BigDecimal tempoParadaMttr,
           java.math.BigDecimal tempoParadaPa,
           java.math.BigDecimal tempoParadaPao,
           java.math.BigDecimal tempoParadaPp,
           java.math.BigDecimal tempoParadaPrev,
           java.math.BigDecimal tempoParadaPtp,
           java.math.BigDecimal tempoParadaRegulagem,
           java.math.BigDecimal tempoParadaScp,
           java.math.BigDecimal tempoParadaSemCnx,
           java.math.BigDecimal tempoParadaSemEvt,
           java.math.BigDecimal tempoParadaSemOp,
           java.math.BigDecimal tempoParadaSp,
           java.math.BigDecimal tempoParadaSpVr,
           java.math.BigDecimal tempoPerdaCavidade,
           java.math.BigDecimal tempoPeriodo,
           java.math.BigDecimal tempoProdutivo,
           java.math.BigDecimal tempoRefugadas,
           java.math.BigDecimal tempoRefugado,
           java.math.BigDecimal tempoTotal,
           java.math.BigDecimal tempoTrabalhado,
           java.math.BigDecimal ultimoCiclo) {
        this.cavAtivas = cavAtivas;
        this.cavAtivasMedia = cavAtivasMedia;
        this.cavTotal = cavTotal;
        this.cavTotalMedia = cavTotalMedia;
        this.cdCp = cdCp;
        this.cdPt = cdPt;
        this.cicloMedio = cicloMedio;
        this.cicloPadrao = cicloPadrao;
        this.cicloPadraoMedio = cicloPadraoMedio;
        this.dtHrFConsol = dtHrFConsol;
        this.dtHrFPeriodo = dtHrFPeriodo;
        this.dtHrIConsol = dtHrIConsol;
        this.dtHrIPeriodo = dtHrIPeriodo;
        this.eficienciaCiclo = eficienciaCiclo;
        this.eficienciaInstantanea = eficienciaInstantanea;
        this.eficienciaRealizacao = eficienciaRealizacao;
        this.IDO = IDO;
        this.IPA = IPA;
        this.ITO = ITO;
        this.indiceCavidadesAtivas = indiceCavidadesAtivas;
        this.indiceParada = indiceParada;
        this.indicePerda = indicePerda;
        this.indiceProducao = indiceProducao;
        this.indiceRefugo = indiceRefugo;
        this.oee = oee;
        this.perdaCavidade = perdaCavidade;
        this.perdaCiclo = perdaCiclo;
        this.perdaParada = perdaParada;
        this.perdaTotal = perdaTotal;
        this.pesoBruto = pesoBruto;
        this.pesoLiquido = pesoLiquido;
        this.producaoBruta = producaoBruta;
        this.producaoLiquida = producaoLiquida;
        this.producaoPlanejada = producaoPlanejada;
        this.producaoPlanejadaMedia = producaoPlanejadaMedia;
        this.producaoPrevista = producaoPrevista;
        this.producaoRefugada = producaoRefugada;
        this.qtAgrupCicloPadrao = qtAgrupCicloPadrao;
        this.qtAgrupProducaoPlanejada = qtAgrupProducaoPlanejada;
        this.qtCicloImprodutivo = qtCicloImprodutivo;
        this.qtCicloProdutivo = qtCicloProdutivo;
        this.qtCicloRegulagem = qtCicloRegulagem;
        this.qtParadaDefault = qtParadaDefault;
        this.qtParadaFds = qtParadaFds;
        this.qtParadaImprev = qtParadaImprev;
        this.qtParadaMdo = qtParadaMdo;
        this.qtParadaMtbf = qtParadaMtbf;
        this.qtParadaMttr = qtParadaMttr;
        this.qtParadaPa = qtParadaPa;
        this.qtParadaPao = qtParadaPao;
        this.qtParadaPp = qtParadaPp;
        this.qtParadaPrev = qtParadaPrev;
        this.qtParadaPtp = qtParadaPtp;
        this.qtParadaRegulagem = qtParadaRegulagem;
        this.qtParadaScp = qtParadaScp;
        this.qtParadaSemCnx = qtParadaSemCnx;
        this.qtParadaSemEvt = qtParadaSemEvt;
        this.qtParadaSemOp = qtParadaSemOp;
        this.ritmo = ritmo;
        this.tempoAlerta = tempoAlerta;
        this.tempoAtivo = tempoAtivo;
        this.tempoBoas = tempoBoas;
        this.tempoCicloImprodutivo = tempoCicloImprodutivo;
        this.tempoCicloProdutivo = tempoCicloProdutivo;
        this.tempoCicloRegulagem = tempoCicloRegulagem;
        this.tempoParadaAb = tempoParadaAb;
        this.tempoParadaCp = tempoParadaCp;
        this.tempoParadaCpVr = tempoParadaCpVr;
        this.tempoParadaDefault = tempoParadaDefault;
        this.tempoParadaFds = tempoParadaFds;
        this.tempoParadaImprev = tempoParadaImprev;
        this.tempoParadaMdo = tempoParadaMdo;
        this.tempoParadaMtbf = tempoParadaMtbf;
        this.tempoParadaMttr = tempoParadaMttr;
        this.tempoParadaPa = tempoParadaPa;
        this.tempoParadaPao = tempoParadaPao;
        this.tempoParadaPp = tempoParadaPp;
        this.tempoParadaPrev = tempoParadaPrev;
        this.tempoParadaPtp = tempoParadaPtp;
        this.tempoParadaRegulagem = tempoParadaRegulagem;
        this.tempoParadaScp = tempoParadaScp;
        this.tempoParadaSemCnx = tempoParadaSemCnx;
        this.tempoParadaSemEvt = tempoParadaSemEvt;
        this.tempoParadaSemOp = tempoParadaSemOp;
        this.tempoParadaSp = tempoParadaSp;
        this.tempoParadaSpVr = tempoParadaSpVr;
        this.tempoPerdaCavidade = tempoPerdaCavidade;
        this.tempoPeriodo = tempoPeriodo;
        this.tempoProdutivo = tempoProdutivo;
        this.tempoRefugadas = tempoRefugadas;
        this.tempoRefugado = tempoRefugado;
        this.tempoTotal = tempoTotal;
        this.tempoTrabalhado = tempoTrabalhado;
        this.ultimoCiclo = ultimoCiclo;
    }


    /**
     * Gets the cavAtivas value for this IndicadoresDTO.
     * 
     * @return cavAtivas
     */
    public java.math.BigDecimal getCavAtivas() {
        return cavAtivas;
    }


    /**
     * Sets the cavAtivas value for this IndicadoresDTO.
     * 
     * @param cavAtivas
     */
    public void setCavAtivas(java.math.BigDecimal cavAtivas) {
        this.cavAtivas = cavAtivas;
    }


    /**
     * Gets the cavAtivasMedia value for this IndicadoresDTO.
     * 
     * @return cavAtivasMedia
     */
    public java.math.BigDecimal getCavAtivasMedia() {
        return cavAtivasMedia;
    }


    /**
     * Sets the cavAtivasMedia value for this IndicadoresDTO.
     * 
     * @param cavAtivasMedia
     */
    public void setCavAtivasMedia(java.math.BigDecimal cavAtivasMedia) {
        this.cavAtivasMedia = cavAtivasMedia;
    }


    /**
     * Gets the cavTotal value for this IndicadoresDTO.
     * 
     * @return cavTotal
     */
    public java.math.BigDecimal getCavTotal() {
        return cavTotal;
    }


    /**
     * Sets the cavTotal value for this IndicadoresDTO.
     * 
     * @param cavTotal
     */
    public void setCavTotal(java.math.BigDecimal cavTotal) {
        this.cavTotal = cavTotal;
    }


    /**
     * Gets the cavTotalMedia value for this IndicadoresDTO.
     * 
     * @return cavTotalMedia
     */
    public java.math.BigDecimal getCavTotalMedia() {
        return cavTotalMedia;
    }


    /**
     * Sets the cavTotalMedia value for this IndicadoresDTO.
     * 
     * @param cavTotalMedia
     */
    public void setCavTotalMedia(java.math.BigDecimal cavTotalMedia) {
        this.cavTotalMedia = cavTotalMedia;
    }


    /**
     * Gets the cdCp value for this IndicadoresDTO.
     * 
     * @return cdCp
     */
    public java.lang.String getCdCp() {
        return cdCp;
    }


    /**
     * Sets the cdCp value for this IndicadoresDTO.
     * 
     * @param cdCp
     */
    public void setCdCp(java.lang.String cdCp) {
        this.cdCp = cdCp;
    }


    /**
     * Gets the cdPt value for this IndicadoresDTO.
     * 
     * @return cdPt
     */
    public java.lang.String getCdPt() {
        return cdPt;
    }


    /**
     * Sets the cdPt value for this IndicadoresDTO.
     * 
     * @param cdPt
     */
    public void setCdPt(java.lang.String cdPt) {
        this.cdPt = cdPt;
    }


    /**
     * Gets the cicloMedio value for this IndicadoresDTO.
     * 
     * @return cicloMedio
     */
    public java.math.BigDecimal getCicloMedio() {
        return cicloMedio;
    }


    /**
     * Sets the cicloMedio value for this IndicadoresDTO.
     * 
     * @param cicloMedio
     */
    public void setCicloMedio(java.math.BigDecimal cicloMedio) {
        this.cicloMedio = cicloMedio;
    }


    /**
     * Gets the cicloPadrao value for this IndicadoresDTO.
     * 
     * @return cicloPadrao
     */
    public java.math.BigDecimal getCicloPadrao() {
        return cicloPadrao;
    }


    /**
     * Sets the cicloPadrao value for this IndicadoresDTO.
     * 
     * @param cicloPadrao
     */
    public void setCicloPadrao(java.math.BigDecimal cicloPadrao) {
        this.cicloPadrao = cicloPadrao;
    }


    /**
     * Gets the cicloPadraoMedio value for this IndicadoresDTO.
     * 
     * @return cicloPadraoMedio
     */
    public java.math.BigDecimal getCicloPadraoMedio() {
        return cicloPadraoMedio;
    }


    /**
     * Sets the cicloPadraoMedio value for this IndicadoresDTO.
     * 
     * @param cicloPadraoMedio
     */
    public void setCicloPadraoMedio(java.math.BigDecimal cicloPadraoMedio) {
        this.cicloPadraoMedio = cicloPadraoMedio;
    }


    /**
     * Gets the dtHrFConsol value for this IndicadoresDTO.
     * 
     * @return dtHrFConsol
     */
    public java.util.Calendar getDtHrFConsol() {
        return dtHrFConsol;
    }


    /**
     * Sets the dtHrFConsol value for this IndicadoresDTO.
     * 
     * @param dtHrFConsol
     */
    public void setDtHrFConsol(java.util.Calendar dtHrFConsol) {
        this.dtHrFConsol = dtHrFConsol;
    }


    /**
     * Gets the dtHrFPeriodo value for this IndicadoresDTO.
     * 
     * @return dtHrFPeriodo
     */
    public java.util.Calendar getDtHrFPeriodo() {
        return dtHrFPeriodo;
    }


    /**
     * Sets the dtHrFPeriodo value for this IndicadoresDTO.
     * 
     * @param dtHrFPeriodo
     */
    public void setDtHrFPeriodo(java.util.Calendar dtHrFPeriodo) {
        this.dtHrFPeriodo = dtHrFPeriodo;
    }


    /**
     * Gets the dtHrIConsol value for this IndicadoresDTO.
     * 
     * @return dtHrIConsol
     */
    public java.util.Calendar getDtHrIConsol() {
        return dtHrIConsol;
    }


    /**
     * Sets the dtHrIConsol value for this IndicadoresDTO.
     * 
     * @param dtHrIConsol
     */
    public void setDtHrIConsol(java.util.Calendar dtHrIConsol) {
        this.dtHrIConsol = dtHrIConsol;
    }


    /**
     * Gets the dtHrIPeriodo value for this IndicadoresDTO.
     * 
     * @return dtHrIPeriodo
     */
    public java.util.Calendar getDtHrIPeriodo() {
        return dtHrIPeriodo;
    }


    /**
     * Sets the dtHrIPeriodo value for this IndicadoresDTO.
     * 
     * @param dtHrIPeriodo
     */
    public void setDtHrIPeriodo(java.util.Calendar dtHrIPeriodo) {
        this.dtHrIPeriodo = dtHrIPeriodo;
    }


    /**
     * Gets the eficienciaCiclo value for this IndicadoresDTO.
     * 
     * @return eficienciaCiclo
     */
    public java.math.BigDecimal getEficienciaCiclo() {
        return eficienciaCiclo;
    }


    /**
     * Sets the eficienciaCiclo value for this IndicadoresDTO.
     * 
     * @param eficienciaCiclo
     */
    public void setEficienciaCiclo(java.math.BigDecimal eficienciaCiclo) {
        this.eficienciaCiclo = eficienciaCiclo;
    }


    /**
     * Gets the eficienciaInstantanea value for this IndicadoresDTO.
     * 
     * @return eficienciaInstantanea
     */
    public java.math.BigDecimal getEficienciaInstantanea() {
        return eficienciaInstantanea;
    }


    /**
     * Sets the eficienciaInstantanea value for this IndicadoresDTO.
     * 
     * @param eficienciaInstantanea
     */
    public void setEficienciaInstantanea(java.math.BigDecimal eficienciaInstantanea) {
        this.eficienciaInstantanea = eficienciaInstantanea;
    }


    /**
     * Gets the eficienciaRealizacao value for this IndicadoresDTO.
     * 
     * @return eficienciaRealizacao
     */
    public java.math.BigDecimal getEficienciaRealizacao() {
        return eficienciaRealizacao;
    }


    /**
     * Sets the eficienciaRealizacao value for this IndicadoresDTO.
     * 
     * @param eficienciaRealizacao
     */
    public void setEficienciaRealizacao(java.math.BigDecimal eficienciaRealizacao) {
        this.eficienciaRealizacao = eficienciaRealizacao;
    }


    /**
     * Gets the IDO value for this IndicadoresDTO.
     * 
     * @return IDO
     */
    public java.math.BigDecimal getIDO() {
        return IDO;
    }


    /**
     * Sets the IDO value for this IndicadoresDTO.
     * 
     * @param IDO
     */
    public void setIDO(java.math.BigDecimal IDO) {
        this.IDO = IDO;
    }


    /**
     * Gets the IPA value for this IndicadoresDTO.
     * 
     * @return IPA
     */
    public java.math.BigDecimal getIPA() {
        return IPA;
    }


    /**
     * Sets the IPA value for this IndicadoresDTO.
     * 
     * @param IPA
     */
    public void setIPA(java.math.BigDecimal IPA) {
        this.IPA = IPA;
    }


    /**
     * Gets the ITO value for this IndicadoresDTO.
     * 
     * @return ITO
     */
    public java.math.BigDecimal getITO() {
        return ITO;
    }


    /**
     * Sets the ITO value for this IndicadoresDTO.
     * 
     * @param ITO
     */
    public void setITO(java.math.BigDecimal ITO) {
        this.ITO = ITO;
    }


    /**
     * Gets the indiceCavidadesAtivas value for this IndicadoresDTO.
     * 
     * @return indiceCavidadesAtivas
     */
    public java.math.BigDecimal getIndiceCavidadesAtivas() {
        return indiceCavidadesAtivas;
    }


    /**
     * Sets the indiceCavidadesAtivas value for this IndicadoresDTO.
     * 
     * @param indiceCavidadesAtivas
     */
    public void setIndiceCavidadesAtivas(java.math.BigDecimal indiceCavidadesAtivas) {
        this.indiceCavidadesAtivas = indiceCavidadesAtivas;
    }


    /**
     * Gets the indiceParada value for this IndicadoresDTO.
     * 
     * @return indiceParada
     */
    public java.math.BigDecimal getIndiceParada() {
        return indiceParada;
    }


    /**
     * Sets the indiceParada value for this IndicadoresDTO.
     * 
     * @param indiceParada
     */
    public void setIndiceParada(java.math.BigDecimal indiceParada) {
        this.indiceParada = indiceParada;
    }


    /**
     * Gets the indicePerda value for this IndicadoresDTO.
     * 
     * @return indicePerda
     */
    public java.math.BigDecimal getIndicePerda() {
        return indicePerda;
    }


    /**
     * Sets the indicePerda value for this IndicadoresDTO.
     * 
     * @param indicePerda
     */
    public void setIndicePerda(java.math.BigDecimal indicePerda) {
        this.indicePerda = indicePerda;
    }


    /**
     * Gets the indiceProducao value for this IndicadoresDTO.
     * 
     * @return indiceProducao
     */
    public java.math.BigDecimal getIndiceProducao() {
        return indiceProducao;
    }


    /**
     * Sets the indiceProducao value for this IndicadoresDTO.
     * 
     * @param indiceProducao
     */
    public void setIndiceProducao(java.math.BigDecimal indiceProducao) {
        this.indiceProducao = indiceProducao;
    }


    /**
     * Gets the indiceRefugo value for this IndicadoresDTO.
     * 
     * @return indiceRefugo
     */
    public java.math.BigDecimal getIndiceRefugo() {
        return indiceRefugo;
    }


    /**
     * Sets the indiceRefugo value for this IndicadoresDTO.
     * 
     * @param indiceRefugo
     */
    public void setIndiceRefugo(java.math.BigDecimal indiceRefugo) {
        this.indiceRefugo = indiceRefugo;
    }


    /**
     * Gets the oee value for this IndicadoresDTO.
     * 
     * @return oee
     */
    public java.math.BigDecimal getOee() {
        return oee;
    }


    /**
     * Sets the oee value for this IndicadoresDTO.
     * 
     * @param oee
     */
    public void setOee(java.math.BigDecimal oee) {
        this.oee = oee;
    }


    /**
     * Gets the perdaCavidade value for this IndicadoresDTO.
     * 
     * @return perdaCavidade
     */
    public java.math.BigDecimal getPerdaCavidade() {
        return perdaCavidade;
    }


    /**
     * Sets the perdaCavidade value for this IndicadoresDTO.
     * 
     * @param perdaCavidade
     */
    public void setPerdaCavidade(java.math.BigDecimal perdaCavidade) {
        this.perdaCavidade = perdaCavidade;
    }


    /**
     * Gets the perdaCiclo value for this IndicadoresDTO.
     * 
     * @return perdaCiclo
     */
    public java.math.BigDecimal getPerdaCiclo() {
        return perdaCiclo;
    }


    /**
     * Sets the perdaCiclo value for this IndicadoresDTO.
     * 
     * @param perdaCiclo
     */
    public void setPerdaCiclo(java.math.BigDecimal perdaCiclo) {
        this.perdaCiclo = perdaCiclo;
    }


    /**
     * Gets the perdaParada value for this IndicadoresDTO.
     * 
     * @return perdaParada
     */
    public java.math.BigDecimal getPerdaParada() {
        return perdaParada;
    }


    /**
     * Sets the perdaParada value for this IndicadoresDTO.
     * 
     * @param perdaParada
     */
    public void setPerdaParada(java.math.BigDecimal perdaParada) {
        this.perdaParada = perdaParada;
    }


    /**
     * Gets the perdaTotal value for this IndicadoresDTO.
     * 
     * @return perdaTotal
     */
    public java.math.BigDecimal getPerdaTotal() {
        return perdaTotal;
    }


    /**
     * Sets the perdaTotal value for this IndicadoresDTO.
     * 
     * @param perdaTotal
     */
    public void setPerdaTotal(java.math.BigDecimal perdaTotal) {
        this.perdaTotal = perdaTotal;
    }


    /**
     * Gets the pesoBruto value for this IndicadoresDTO.
     * 
     * @return pesoBruto
     */
    public java.math.BigDecimal getPesoBruto() {
        return pesoBruto;
    }


    /**
     * Sets the pesoBruto value for this IndicadoresDTO.
     * 
     * @param pesoBruto
     */
    public void setPesoBruto(java.math.BigDecimal pesoBruto) {
        this.pesoBruto = pesoBruto;
    }


    /**
     * Gets the pesoLiquido value for this IndicadoresDTO.
     * 
     * @return pesoLiquido
     */
    public java.math.BigDecimal getPesoLiquido() {
        return pesoLiquido;
    }


    /**
     * Sets the pesoLiquido value for this IndicadoresDTO.
     * 
     * @param pesoLiquido
     */
    public void setPesoLiquido(java.math.BigDecimal pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }


    /**
     * Gets the producaoBruta value for this IndicadoresDTO.
     * 
     * @return producaoBruta
     */
    public java.math.BigDecimal getProducaoBruta() {
        return producaoBruta;
    }


    /**
     * Sets the producaoBruta value for this IndicadoresDTO.
     * 
     * @param producaoBruta
     */
    public void setProducaoBruta(java.math.BigDecimal producaoBruta) {
        this.producaoBruta = producaoBruta;
    }


    /**
     * Gets the producaoLiquida value for this IndicadoresDTO.
     * 
     * @return producaoLiquida
     */
    public java.math.BigDecimal getProducaoLiquida() {
        return producaoLiquida;
    }


    /**
     * Sets the producaoLiquida value for this IndicadoresDTO.
     * 
     * @param producaoLiquida
     */
    public void setProducaoLiquida(java.math.BigDecimal producaoLiquida) {
        this.producaoLiquida = producaoLiquida;
    }


    /**
     * Gets the producaoPlanejada value for this IndicadoresDTO.
     * 
     * @return producaoPlanejada
     */
    public java.math.BigDecimal getProducaoPlanejada() {
        return producaoPlanejada;
    }


    /**
     * Sets the producaoPlanejada value for this IndicadoresDTO.
     * 
     * @param producaoPlanejada
     */
    public void setProducaoPlanejada(java.math.BigDecimal producaoPlanejada) {
        this.producaoPlanejada = producaoPlanejada;
    }


    /**
     * Gets the producaoPlanejadaMedia value for this IndicadoresDTO.
     * 
     * @return producaoPlanejadaMedia
     */
    public java.math.BigDecimal getProducaoPlanejadaMedia() {
        return producaoPlanejadaMedia;
    }


    /**
     * Sets the producaoPlanejadaMedia value for this IndicadoresDTO.
     * 
     * @param producaoPlanejadaMedia
     */
    public void setProducaoPlanejadaMedia(java.math.BigDecimal producaoPlanejadaMedia) {
        this.producaoPlanejadaMedia = producaoPlanejadaMedia;
    }


    /**
     * Gets the producaoPrevista value for this IndicadoresDTO.
     * 
     * @return producaoPrevista
     */
    public java.math.BigDecimal getProducaoPrevista() {
        return producaoPrevista;
    }


    /**
     * Sets the producaoPrevista value for this IndicadoresDTO.
     * 
     * @param producaoPrevista
     */
    public void setProducaoPrevista(java.math.BigDecimal producaoPrevista) {
        this.producaoPrevista = producaoPrevista;
    }


    /**
     * Gets the producaoRefugada value for this IndicadoresDTO.
     * 
     * @return producaoRefugada
     */
    public java.math.BigDecimal getProducaoRefugada() {
        return producaoRefugada;
    }


    /**
     * Sets the producaoRefugada value for this IndicadoresDTO.
     * 
     * @param producaoRefugada
     */
    public void setProducaoRefugada(java.math.BigDecimal producaoRefugada) {
        this.producaoRefugada = producaoRefugada;
    }


    /**
     * Gets the qtAgrupCicloPadrao value for this IndicadoresDTO.
     * 
     * @return qtAgrupCicloPadrao
     */
    public long getQtAgrupCicloPadrao() {
        return qtAgrupCicloPadrao;
    }


    /**
     * Sets the qtAgrupCicloPadrao value for this IndicadoresDTO.
     * 
     * @param qtAgrupCicloPadrao
     */
    public void setQtAgrupCicloPadrao(long qtAgrupCicloPadrao) {
        this.qtAgrupCicloPadrao = qtAgrupCicloPadrao;
    }


    /**
     * Gets the qtAgrupProducaoPlanejada value for this IndicadoresDTO.
     * 
     * @return qtAgrupProducaoPlanejada
     */
    public long getQtAgrupProducaoPlanejada() {
        return qtAgrupProducaoPlanejada;
    }


    /**
     * Sets the qtAgrupProducaoPlanejada value for this IndicadoresDTO.
     * 
     * @param qtAgrupProducaoPlanejada
     */
    public void setQtAgrupProducaoPlanejada(long qtAgrupProducaoPlanejada) {
        this.qtAgrupProducaoPlanejada = qtAgrupProducaoPlanejada;
    }


    /**
     * Gets the qtCicloImprodutivo value for this IndicadoresDTO.
     * 
     * @return qtCicloImprodutivo
     */
    public java.math.BigDecimal getQtCicloImprodutivo() {
        return qtCicloImprodutivo;
    }


    /**
     * Sets the qtCicloImprodutivo value for this IndicadoresDTO.
     * 
     * @param qtCicloImprodutivo
     */
    public void setQtCicloImprodutivo(java.math.BigDecimal qtCicloImprodutivo) {
        this.qtCicloImprodutivo = qtCicloImprodutivo;
    }


    /**
     * Gets the qtCicloProdutivo value for this IndicadoresDTO.
     * 
     * @return qtCicloProdutivo
     */
    public java.math.BigDecimal getQtCicloProdutivo() {
        return qtCicloProdutivo;
    }


    /**
     * Sets the qtCicloProdutivo value for this IndicadoresDTO.
     * 
     * @param qtCicloProdutivo
     */
    public void setQtCicloProdutivo(java.math.BigDecimal qtCicloProdutivo) {
        this.qtCicloProdutivo = qtCicloProdutivo;
    }


    /**
     * Gets the qtCicloRegulagem value for this IndicadoresDTO.
     * 
     * @return qtCicloRegulagem
     */
    public java.math.BigDecimal getQtCicloRegulagem() {
        return qtCicloRegulagem;
    }


    /**
     * Sets the qtCicloRegulagem value for this IndicadoresDTO.
     * 
     * @param qtCicloRegulagem
     */
    public void setQtCicloRegulagem(java.math.BigDecimal qtCicloRegulagem) {
        this.qtCicloRegulagem = qtCicloRegulagem;
    }


    /**
     * Gets the qtParadaDefault value for this IndicadoresDTO.
     * 
     * @return qtParadaDefault
     */
    public java.math.BigDecimal getQtParadaDefault() {
        return qtParadaDefault;
    }


    /**
     * Sets the qtParadaDefault value for this IndicadoresDTO.
     * 
     * @param qtParadaDefault
     */
    public void setQtParadaDefault(java.math.BigDecimal qtParadaDefault) {
        this.qtParadaDefault = qtParadaDefault;
    }


    /**
     * Gets the qtParadaFds value for this IndicadoresDTO.
     * 
     * @return qtParadaFds
     */
    public java.math.BigDecimal getQtParadaFds() {
        return qtParadaFds;
    }


    /**
     * Sets the qtParadaFds value for this IndicadoresDTO.
     * 
     * @param qtParadaFds
     */
    public void setQtParadaFds(java.math.BigDecimal qtParadaFds) {
        this.qtParadaFds = qtParadaFds;
    }


    /**
     * Gets the qtParadaImprev value for this IndicadoresDTO.
     * 
     * @return qtParadaImprev
     */
    public java.math.BigDecimal getQtParadaImprev() {
        return qtParadaImprev;
    }


    /**
     * Sets the qtParadaImprev value for this IndicadoresDTO.
     * 
     * @param qtParadaImprev
     */
    public void setQtParadaImprev(java.math.BigDecimal qtParadaImprev) {
        this.qtParadaImprev = qtParadaImprev;
    }


    /**
     * Gets the qtParadaMdo value for this IndicadoresDTO.
     * 
     * @return qtParadaMdo
     */
    public java.math.BigDecimal getQtParadaMdo() {
        return qtParadaMdo;
    }


    /**
     * Sets the qtParadaMdo value for this IndicadoresDTO.
     * 
     * @param qtParadaMdo
     */
    public void setQtParadaMdo(java.math.BigDecimal qtParadaMdo) {
        this.qtParadaMdo = qtParadaMdo;
    }


    /**
     * Gets the qtParadaMtbf value for this IndicadoresDTO.
     * 
     * @return qtParadaMtbf
     */
    public java.math.BigDecimal getQtParadaMtbf() {
        return qtParadaMtbf;
    }


    /**
     * Sets the qtParadaMtbf value for this IndicadoresDTO.
     * 
     * @param qtParadaMtbf
     */
    public void setQtParadaMtbf(java.math.BigDecimal qtParadaMtbf) {
        this.qtParadaMtbf = qtParadaMtbf;
    }


    /**
     * Gets the qtParadaMttr value for this IndicadoresDTO.
     * 
     * @return qtParadaMttr
     */
    public java.math.BigDecimal getQtParadaMttr() {
        return qtParadaMttr;
    }


    /**
     * Sets the qtParadaMttr value for this IndicadoresDTO.
     * 
     * @param qtParadaMttr
     */
    public void setQtParadaMttr(java.math.BigDecimal qtParadaMttr) {
        this.qtParadaMttr = qtParadaMttr;
    }


    /**
     * Gets the qtParadaPa value for this IndicadoresDTO.
     * 
     * @return qtParadaPa
     */
    public java.math.BigDecimal getQtParadaPa() {
        return qtParadaPa;
    }


    /**
     * Sets the qtParadaPa value for this IndicadoresDTO.
     * 
     * @param qtParadaPa
     */
    public void setQtParadaPa(java.math.BigDecimal qtParadaPa) {
        this.qtParadaPa = qtParadaPa;
    }


    /**
     * Gets the qtParadaPao value for this IndicadoresDTO.
     * 
     * @return qtParadaPao
     */
    public java.math.BigDecimal getQtParadaPao() {
        return qtParadaPao;
    }


    /**
     * Sets the qtParadaPao value for this IndicadoresDTO.
     * 
     * @param qtParadaPao
     */
    public void setQtParadaPao(java.math.BigDecimal qtParadaPao) {
        this.qtParadaPao = qtParadaPao;
    }


    /**
     * Gets the qtParadaPp value for this IndicadoresDTO.
     * 
     * @return qtParadaPp
     */
    public java.math.BigDecimal getQtParadaPp() {
        return qtParadaPp;
    }


    /**
     * Sets the qtParadaPp value for this IndicadoresDTO.
     * 
     * @param qtParadaPp
     */
    public void setQtParadaPp(java.math.BigDecimal qtParadaPp) {
        this.qtParadaPp = qtParadaPp;
    }


    /**
     * Gets the qtParadaPrev value for this IndicadoresDTO.
     * 
     * @return qtParadaPrev
     */
    public java.math.BigDecimal getQtParadaPrev() {
        return qtParadaPrev;
    }


    /**
     * Sets the qtParadaPrev value for this IndicadoresDTO.
     * 
     * @param qtParadaPrev
     */
    public void setQtParadaPrev(java.math.BigDecimal qtParadaPrev) {
        this.qtParadaPrev = qtParadaPrev;
    }


    /**
     * Gets the qtParadaPtp value for this IndicadoresDTO.
     * 
     * @return qtParadaPtp
     */
    public java.math.BigDecimal getQtParadaPtp() {
        return qtParadaPtp;
    }


    /**
     * Sets the qtParadaPtp value for this IndicadoresDTO.
     * 
     * @param qtParadaPtp
     */
    public void setQtParadaPtp(java.math.BigDecimal qtParadaPtp) {
        this.qtParadaPtp = qtParadaPtp;
    }


    /**
     * Gets the qtParadaRegulagem value for this IndicadoresDTO.
     * 
     * @return qtParadaRegulagem
     */
    public java.math.BigDecimal getQtParadaRegulagem() {
        return qtParadaRegulagem;
    }


    /**
     * Sets the qtParadaRegulagem value for this IndicadoresDTO.
     * 
     * @param qtParadaRegulagem
     */
    public void setQtParadaRegulagem(java.math.BigDecimal qtParadaRegulagem) {
        this.qtParadaRegulagem = qtParadaRegulagem;
    }


    /**
     * Gets the qtParadaScp value for this IndicadoresDTO.
     * 
     * @return qtParadaScp
     */
    public java.math.BigDecimal getQtParadaScp() {
        return qtParadaScp;
    }


    /**
     * Sets the qtParadaScp value for this IndicadoresDTO.
     * 
     * @param qtParadaScp
     */
    public void setQtParadaScp(java.math.BigDecimal qtParadaScp) {
        this.qtParadaScp = qtParadaScp;
    }


    /**
     * Gets the qtParadaSemCnx value for this IndicadoresDTO.
     * 
     * @return qtParadaSemCnx
     */
    public java.math.BigDecimal getQtParadaSemCnx() {
        return qtParadaSemCnx;
    }


    /**
     * Sets the qtParadaSemCnx value for this IndicadoresDTO.
     * 
     * @param qtParadaSemCnx
     */
    public void setQtParadaSemCnx(java.math.BigDecimal qtParadaSemCnx) {
        this.qtParadaSemCnx = qtParadaSemCnx;
    }


    /**
     * Gets the qtParadaSemEvt value for this IndicadoresDTO.
     * 
     * @return qtParadaSemEvt
     */
    public java.math.BigDecimal getQtParadaSemEvt() {
        return qtParadaSemEvt;
    }


    /**
     * Sets the qtParadaSemEvt value for this IndicadoresDTO.
     * 
     * @param qtParadaSemEvt
     */
    public void setQtParadaSemEvt(java.math.BigDecimal qtParadaSemEvt) {
        this.qtParadaSemEvt = qtParadaSemEvt;
    }


    /**
     * Gets the qtParadaSemOp value for this IndicadoresDTO.
     * 
     * @return qtParadaSemOp
     */
    public java.math.BigDecimal getQtParadaSemOp() {
        return qtParadaSemOp;
    }


    /**
     * Sets the qtParadaSemOp value for this IndicadoresDTO.
     * 
     * @param qtParadaSemOp
     */
    public void setQtParadaSemOp(java.math.BigDecimal qtParadaSemOp) {
        this.qtParadaSemOp = qtParadaSemOp;
    }


    /**
     * Gets the ritmo value for this IndicadoresDTO.
     * 
     * @return ritmo
     */
    public java.math.BigDecimal getRitmo() {
        return ritmo;
    }


    /**
     * Sets the ritmo value for this IndicadoresDTO.
     * 
     * @param ritmo
     */
    public void setRitmo(java.math.BigDecimal ritmo) {
        this.ritmo = ritmo;
    }


    /**
     * Gets the tempoAlerta value for this IndicadoresDTO.
     * 
     * @return tempoAlerta
     */
    public java.math.BigDecimal getTempoAlerta() {
        return tempoAlerta;
    }


    /**
     * Sets the tempoAlerta value for this IndicadoresDTO.
     * 
     * @param tempoAlerta
     */
    public void setTempoAlerta(java.math.BigDecimal tempoAlerta) {
        this.tempoAlerta = tempoAlerta;
    }


    /**
     * Gets the tempoAtivo value for this IndicadoresDTO.
     * 
     * @return tempoAtivo
     */
    public java.math.BigDecimal getTempoAtivo() {
        return tempoAtivo;
    }


    /**
     * Sets the tempoAtivo value for this IndicadoresDTO.
     * 
     * @param tempoAtivo
     */
    public void setTempoAtivo(java.math.BigDecimal tempoAtivo) {
        this.tempoAtivo = tempoAtivo;
    }


    /**
     * Gets the tempoBoas value for this IndicadoresDTO.
     * 
     * @return tempoBoas
     */
    public java.math.BigDecimal getTempoBoas() {
        return tempoBoas;
    }


    /**
     * Sets the tempoBoas value for this IndicadoresDTO.
     * 
     * @param tempoBoas
     */
    public void setTempoBoas(java.math.BigDecimal tempoBoas) {
        this.tempoBoas = tempoBoas;
    }


    /**
     * Gets the tempoCicloImprodutivo value for this IndicadoresDTO.
     * 
     * @return tempoCicloImprodutivo
     */
    public java.math.BigDecimal getTempoCicloImprodutivo() {
        return tempoCicloImprodutivo;
    }


    /**
     * Sets the tempoCicloImprodutivo value for this IndicadoresDTO.
     * 
     * @param tempoCicloImprodutivo
     */
    public void setTempoCicloImprodutivo(java.math.BigDecimal tempoCicloImprodutivo) {
        this.tempoCicloImprodutivo = tempoCicloImprodutivo;
    }


    /**
     * Gets the tempoCicloProdutivo value for this IndicadoresDTO.
     * 
     * @return tempoCicloProdutivo
     */
    public java.math.BigDecimal getTempoCicloProdutivo() {
        return tempoCicloProdutivo;
    }


    /**
     * Sets the tempoCicloProdutivo value for this IndicadoresDTO.
     * 
     * @param tempoCicloProdutivo
     */
    public void setTempoCicloProdutivo(java.math.BigDecimal tempoCicloProdutivo) {
        this.tempoCicloProdutivo = tempoCicloProdutivo;
    }


    /**
     * Gets the tempoCicloRegulagem value for this IndicadoresDTO.
     * 
     * @return tempoCicloRegulagem
     */
    public java.math.BigDecimal getTempoCicloRegulagem() {
        return tempoCicloRegulagem;
    }


    /**
     * Sets the tempoCicloRegulagem value for this IndicadoresDTO.
     * 
     * @param tempoCicloRegulagem
     */
    public void setTempoCicloRegulagem(java.math.BigDecimal tempoCicloRegulagem) {
        this.tempoCicloRegulagem = tempoCicloRegulagem;
    }


    /**
     * Gets the tempoParadaAb value for this IndicadoresDTO.
     * 
     * @return tempoParadaAb
     */
    public java.math.BigDecimal getTempoParadaAb() {
        return tempoParadaAb;
    }


    /**
     * Sets the tempoParadaAb value for this IndicadoresDTO.
     * 
     * @param tempoParadaAb
     */
    public void setTempoParadaAb(java.math.BigDecimal tempoParadaAb) {
        this.tempoParadaAb = tempoParadaAb;
    }


    /**
     * Gets the tempoParadaCp value for this IndicadoresDTO.
     * 
     * @return tempoParadaCp
     */
    public java.math.BigDecimal getTempoParadaCp() {
        return tempoParadaCp;
    }


    /**
     * Sets the tempoParadaCp value for this IndicadoresDTO.
     * 
     * @param tempoParadaCp
     */
    public void setTempoParadaCp(java.math.BigDecimal tempoParadaCp) {
        this.tempoParadaCp = tempoParadaCp;
    }


    /**
     * Gets the tempoParadaCpVr value for this IndicadoresDTO.
     * 
     * @return tempoParadaCpVr
     */
    public java.math.BigDecimal getTempoParadaCpVr() {
        return tempoParadaCpVr;
    }


    /**
     * Sets the tempoParadaCpVr value for this IndicadoresDTO.
     * 
     * @param tempoParadaCpVr
     */
    public void setTempoParadaCpVr(java.math.BigDecimal tempoParadaCpVr) {
        this.tempoParadaCpVr = tempoParadaCpVr;
    }


    /**
     * Gets the tempoParadaDefault value for this IndicadoresDTO.
     * 
     * @return tempoParadaDefault
     */
    public java.math.BigDecimal getTempoParadaDefault() {
        return tempoParadaDefault;
    }


    /**
     * Sets the tempoParadaDefault value for this IndicadoresDTO.
     * 
     * @param tempoParadaDefault
     */
    public void setTempoParadaDefault(java.math.BigDecimal tempoParadaDefault) {
        this.tempoParadaDefault = tempoParadaDefault;
    }


    /**
     * Gets the tempoParadaFds value for this IndicadoresDTO.
     * 
     * @return tempoParadaFds
     */
    public java.math.BigDecimal getTempoParadaFds() {
        return tempoParadaFds;
    }


    /**
     * Sets the tempoParadaFds value for this IndicadoresDTO.
     * 
     * @param tempoParadaFds
     */
    public void setTempoParadaFds(java.math.BigDecimal tempoParadaFds) {
        this.tempoParadaFds = tempoParadaFds;
    }


    /**
     * Gets the tempoParadaImprev value for this IndicadoresDTO.
     * 
     * @return tempoParadaImprev
     */
    public java.math.BigDecimal getTempoParadaImprev() {
        return tempoParadaImprev;
    }


    /**
     * Sets the tempoParadaImprev value for this IndicadoresDTO.
     * 
     * @param tempoParadaImprev
     */
    public void setTempoParadaImprev(java.math.BigDecimal tempoParadaImprev) {
        this.tempoParadaImprev = tempoParadaImprev;
    }


    /**
     * Gets the tempoParadaMdo value for this IndicadoresDTO.
     * 
     * @return tempoParadaMdo
     */
    public java.math.BigDecimal getTempoParadaMdo() {
        return tempoParadaMdo;
    }


    /**
     * Sets the tempoParadaMdo value for this IndicadoresDTO.
     * 
     * @param tempoParadaMdo
     */
    public void setTempoParadaMdo(java.math.BigDecimal tempoParadaMdo) {
        this.tempoParadaMdo = tempoParadaMdo;
    }


    /**
     * Gets the tempoParadaMtbf value for this IndicadoresDTO.
     * 
     * @return tempoParadaMtbf
     */
    public java.math.BigDecimal getTempoParadaMtbf() {
        return tempoParadaMtbf;
    }


    /**
     * Sets the tempoParadaMtbf value for this IndicadoresDTO.
     * 
     * @param tempoParadaMtbf
     */
    public void setTempoParadaMtbf(java.math.BigDecimal tempoParadaMtbf) {
        this.tempoParadaMtbf = tempoParadaMtbf;
    }


    /**
     * Gets the tempoParadaMttr value for this IndicadoresDTO.
     * 
     * @return tempoParadaMttr
     */
    public java.math.BigDecimal getTempoParadaMttr() {
        return tempoParadaMttr;
    }


    /**
     * Sets the tempoParadaMttr value for this IndicadoresDTO.
     * 
     * @param tempoParadaMttr
     */
    public void setTempoParadaMttr(java.math.BigDecimal tempoParadaMttr) {
        this.tempoParadaMttr = tempoParadaMttr;
    }


    /**
     * Gets the tempoParadaPa value for this IndicadoresDTO.
     * 
     * @return tempoParadaPa
     */
    public java.math.BigDecimal getTempoParadaPa() {
        return tempoParadaPa;
    }


    /**
     * Sets the tempoParadaPa value for this IndicadoresDTO.
     * 
     * @param tempoParadaPa
     */
    public void setTempoParadaPa(java.math.BigDecimal tempoParadaPa) {
        this.tempoParadaPa = tempoParadaPa;
    }


    /**
     * Gets the tempoParadaPao value for this IndicadoresDTO.
     * 
     * @return tempoParadaPao
     */
    public java.math.BigDecimal getTempoParadaPao() {
        return tempoParadaPao;
    }


    /**
     * Sets the tempoParadaPao value for this IndicadoresDTO.
     * 
     * @param tempoParadaPao
     */
    public void setTempoParadaPao(java.math.BigDecimal tempoParadaPao) {
        this.tempoParadaPao = tempoParadaPao;
    }


    /**
     * Gets the tempoParadaPp value for this IndicadoresDTO.
     * 
     * @return tempoParadaPp
     */
    public java.math.BigDecimal getTempoParadaPp() {
        return tempoParadaPp;
    }


    /**
     * Sets the tempoParadaPp value for this IndicadoresDTO.
     * 
     * @param tempoParadaPp
     */
    public void setTempoParadaPp(java.math.BigDecimal tempoParadaPp) {
        this.tempoParadaPp = tempoParadaPp;
    }


    /**
     * Gets the tempoParadaPrev value for this IndicadoresDTO.
     * 
     * @return tempoParadaPrev
     */
    public java.math.BigDecimal getTempoParadaPrev() {
        return tempoParadaPrev;
    }


    /**
     * Sets the tempoParadaPrev value for this IndicadoresDTO.
     * 
     * @param tempoParadaPrev
     */
    public void setTempoParadaPrev(java.math.BigDecimal tempoParadaPrev) {
        this.tempoParadaPrev = tempoParadaPrev;
    }


    /**
     * Gets the tempoParadaPtp value for this IndicadoresDTO.
     * 
     * @return tempoParadaPtp
     */
    public java.math.BigDecimal getTempoParadaPtp() {
        return tempoParadaPtp;
    }


    /**
     * Sets the tempoParadaPtp value for this IndicadoresDTO.
     * 
     * @param tempoParadaPtp
     */
    public void setTempoParadaPtp(java.math.BigDecimal tempoParadaPtp) {
        this.tempoParadaPtp = tempoParadaPtp;
    }


    /**
     * Gets the tempoParadaRegulagem value for this IndicadoresDTO.
     * 
     * @return tempoParadaRegulagem
     */
    public java.math.BigDecimal getTempoParadaRegulagem() {
        return tempoParadaRegulagem;
    }


    /**
     * Sets the tempoParadaRegulagem value for this IndicadoresDTO.
     * 
     * @param tempoParadaRegulagem
     */
    public void setTempoParadaRegulagem(java.math.BigDecimal tempoParadaRegulagem) {
        this.tempoParadaRegulagem = tempoParadaRegulagem;
    }


    /**
     * Gets the tempoParadaScp value for this IndicadoresDTO.
     * 
     * @return tempoParadaScp
     */
    public java.math.BigDecimal getTempoParadaScp() {
        return tempoParadaScp;
    }


    /**
     * Sets the tempoParadaScp value for this IndicadoresDTO.
     * 
     * @param tempoParadaScp
     */
    public void setTempoParadaScp(java.math.BigDecimal tempoParadaScp) {
        this.tempoParadaScp = tempoParadaScp;
    }


    /**
     * Gets the tempoParadaSemCnx value for this IndicadoresDTO.
     * 
     * @return tempoParadaSemCnx
     */
    public java.math.BigDecimal getTempoParadaSemCnx() {
        return tempoParadaSemCnx;
    }


    /**
     * Sets the tempoParadaSemCnx value for this IndicadoresDTO.
     * 
     * @param tempoParadaSemCnx
     */
    public void setTempoParadaSemCnx(java.math.BigDecimal tempoParadaSemCnx) {
        this.tempoParadaSemCnx = tempoParadaSemCnx;
    }


    /**
     * Gets the tempoParadaSemEvt value for this IndicadoresDTO.
     * 
     * @return tempoParadaSemEvt
     */
    public java.math.BigDecimal getTempoParadaSemEvt() {
        return tempoParadaSemEvt;
    }


    /**
     * Sets the tempoParadaSemEvt value for this IndicadoresDTO.
     * 
     * @param tempoParadaSemEvt
     */
    public void setTempoParadaSemEvt(java.math.BigDecimal tempoParadaSemEvt) {
        this.tempoParadaSemEvt = tempoParadaSemEvt;
    }


    /**
     * Gets the tempoParadaSemOp value for this IndicadoresDTO.
     * 
     * @return tempoParadaSemOp
     */
    public java.math.BigDecimal getTempoParadaSemOp() {
        return tempoParadaSemOp;
    }


    /**
     * Sets the tempoParadaSemOp value for this IndicadoresDTO.
     * 
     * @param tempoParadaSemOp
     */
    public void setTempoParadaSemOp(java.math.BigDecimal tempoParadaSemOp) {
        this.tempoParadaSemOp = tempoParadaSemOp;
    }


    /**
     * Gets the tempoParadaSp value for this IndicadoresDTO.
     * 
     * @return tempoParadaSp
     */
    public java.math.BigDecimal getTempoParadaSp() {
        return tempoParadaSp;
    }


    /**
     * Sets the tempoParadaSp value for this IndicadoresDTO.
     * 
     * @param tempoParadaSp
     */
    public void setTempoParadaSp(java.math.BigDecimal tempoParadaSp) {
        this.tempoParadaSp = tempoParadaSp;
    }


    /**
     * Gets the tempoParadaSpVr value for this IndicadoresDTO.
     * 
     * @return tempoParadaSpVr
     */
    public java.math.BigDecimal getTempoParadaSpVr() {
        return tempoParadaSpVr;
    }


    /**
     * Sets the tempoParadaSpVr value for this IndicadoresDTO.
     * 
     * @param tempoParadaSpVr
     */
    public void setTempoParadaSpVr(java.math.BigDecimal tempoParadaSpVr) {
        this.tempoParadaSpVr = tempoParadaSpVr;
    }


    /**
     * Gets the tempoPerdaCavidade value for this IndicadoresDTO.
     * 
     * @return tempoPerdaCavidade
     */
    public java.math.BigDecimal getTempoPerdaCavidade() {
        return tempoPerdaCavidade;
    }


    /**
     * Sets the tempoPerdaCavidade value for this IndicadoresDTO.
     * 
     * @param tempoPerdaCavidade
     */
    public void setTempoPerdaCavidade(java.math.BigDecimal tempoPerdaCavidade) {
        this.tempoPerdaCavidade = tempoPerdaCavidade;
    }


    /**
     * Gets the tempoPeriodo value for this IndicadoresDTO.
     * 
     * @return tempoPeriodo
     */
    public java.math.BigDecimal getTempoPeriodo() {
        return tempoPeriodo;
    }


    /**
     * Sets the tempoPeriodo value for this IndicadoresDTO.
     * 
     * @param tempoPeriodo
     */
    public void setTempoPeriodo(java.math.BigDecimal tempoPeriodo) {
        this.tempoPeriodo = tempoPeriodo;
    }


    /**
     * Gets the tempoProdutivo value for this IndicadoresDTO.
     * 
     * @return tempoProdutivo
     */
    public java.math.BigDecimal getTempoProdutivo() {
        return tempoProdutivo;
    }


    /**
     * Sets the tempoProdutivo value for this IndicadoresDTO.
     * 
     * @param tempoProdutivo
     */
    public void setTempoProdutivo(java.math.BigDecimal tempoProdutivo) {
        this.tempoProdutivo = tempoProdutivo;
    }


    /**
     * Gets the tempoRefugadas value for this IndicadoresDTO.
     * 
     * @return tempoRefugadas
     */
    public java.math.BigDecimal getTempoRefugadas() {
        return tempoRefugadas;
    }


    /**
     * Sets the tempoRefugadas value for this IndicadoresDTO.
     * 
     * @param tempoRefugadas
     */
    public void setTempoRefugadas(java.math.BigDecimal tempoRefugadas) {
        this.tempoRefugadas = tempoRefugadas;
    }


    /**
     * Gets the tempoRefugado value for this IndicadoresDTO.
     * 
     * @return tempoRefugado
     */
    public java.math.BigDecimal getTempoRefugado() {
        return tempoRefugado;
    }


    /**
     * Sets the tempoRefugado value for this IndicadoresDTO.
     * 
     * @param tempoRefugado
     */
    public void setTempoRefugado(java.math.BigDecimal tempoRefugado) {
        this.tempoRefugado = tempoRefugado;
    }


    /**
     * Gets the tempoTotal value for this IndicadoresDTO.
     * 
     * @return tempoTotal
     */
    public java.math.BigDecimal getTempoTotal() {
        return tempoTotal;
    }


    /**
     * Sets the tempoTotal value for this IndicadoresDTO.
     * 
     * @param tempoTotal
     */
    public void setTempoTotal(java.math.BigDecimal tempoTotal) {
        this.tempoTotal = tempoTotal;
    }


    /**
     * Gets the tempoTrabalhado value for this IndicadoresDTO.
     * 
     * @return tempoTrabalhado
     */
    public java.math.BigDecimal getTempoTrabalhado() {
        return tempoTrabalhado;
    }


    /**
     * Sets the tempoTrabalhado value for this IndicadoresDTO.
     * 
     * @param tempoTrabalhado
     */
    public void setTempoTrabalhado(java.math.BigDecimal tempoTrabalhado) {
        this.tempoTrabalhado = tempoTrabalhado;
    }


    /**
     * Gets the ultimoCiclo value for this IndicadoresDTO.
     * 
     * @return ultimoCiclo
     */
    public java.math.BigDecimal getUltimoCiclo() {
        return ultimoCiclo;
    }


    /**
     * Sets the ultimoCiclo value for this IndicadoresDTO.
     * 
     * @param ultimoCiclo
     */
    public void setUltimoCiclo(java.math.BigDecimal ultimoCiclo) {
        this.ultimoCiclo = ultimoCiclo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IndicadoresDTO)) return false;
        IndicadoresDTO other = (IndicadoresDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cavAtivas==null && other.getCavAtivas()==null) || 
             (this.cavAtivas!=null &&
              this.cavAtivas.equals(other.getCavAtivas()))) &&
            ((this.cavAtivasMedia==null && other.getCavAtivasMedia()==null) || 
             (this.cavAtivasMedia!=null &&
              this.cavAtivasMedia.equals(other.getCavAtivasMedia()))) &&
            ((this.cavTotal==null && other.getCavTotal()==null) || 
             (this.cavTotal!=null &&
              this.cavTotal.equals(other.getCavTotal()))) &&
            ((this.cavTotalMedia==null && other.getCavTotalMedia()==null) || 
             (this.cavTotalMedia!=null &&
              this.cavTotalMedia.equals(other.getCavTotalMedia()))) &&
            ((this.cdCp==null && other.getCdCp()==null) || 
             (this.cdCp!=null &&
              this.cdCp.equals(other.getCdCp()))) &&
            ((this.cdPt==null && other.getCdPt()==null) || 
             (this.cdPt!=null &&
              this.cdPt.equals(other.getCdPt()))) &&
            ((this.cicloMedio==null && other.getCicloMedio()==null) || 
             (this.cicloMedio!=null &&
              this.cicloMedio.equals(other.getCicloMedio()))) &&
            ((this.cicloPadrao==null && other.getCicloPadrao()==null) || 
             (this.cicloPadrao!=null &&
              this.cicloPadrao.equals(other.getCicloPadrao()))) &&
            ((this.cicloPadraoMedio==null && other.getCicloPadraoMedio()==null) || 
             (this.cicloPadraoMedio!=null &&
              this.cicloPadraoMedio.equals(other.getCicloPadraoMedio()))) &&
            ((this.dtHrFConsol==null && other.getDtHrFConsol()==null) || 
             (this.dtHrFConsol!=null &&
              this.dtHrFConsol.equals(other.getDtHrFConsol()))) &&
            ((this.dtHrFPeriodo==null && other.getDtHrFPeriodo()==null) || 
             (this.dtHrFPeriodo!=null &&
              this.dtHrFPeriodo.equals(other.getDtHrFPeriodo()))) &&
            ((this.dtHrIConsol==null && other.getDtHrIConsol()==null) || 
             (this.dtHrIConsol!=null &&
              this.dtHrIConsol.equals(other.getDtHrIConsol()))) &&
            ((this.dtHrIPeriodo==null && other.getDtHrIPeriodo()==null) || 
             (this.dtHrIPeriodo!=null &&
              this.dtHrIPeriodo.equals(other.getDtHrIPeriodo()))) &&
            ((this.eficienciaCiclo==null && other.getEficienciaCiclo()==null) || 
             (this.eficienciaCiclo!=null &&
              this.eficienciaCiclo.equals(other.getEficienciaCiclo()))) &&
            ((this.eficienciaInstantanea==null && other.getEficienciaInstantanea()==null) || 
             (this.eficienciaInstantanea!=null &&
              this.eficienciaInstantanea.equals(other.getEficienciaInstantanea()))) &&
            ((this.eficienciaRealizacao==null && other.getEficienciaRealizacao()==null) || 
             (this.eficienciaRealizacao!=null &&
              this.eficienciaRealizacao.equals(other.getEficienciaRealizacao()))) &&
            ((this.IDO==null && other.getIDO()==null) || 
             (this.IDO!=null &&
              this.IDO.equals(other.getIDO()))) &&
            ((this.IPA==null && other.getIPA()==null) || 
             (this.IPA!=null &&
              this.IPA.equals(other.getIPA()))) &&
            ((this.ITO==null && other.getITO()==null) || 
             (this.ITO!=null &&
              this.ITO.equals(other.getITO()))) &&
            ((this.indiceCavidadesAtivas==null && other.getIndiceCavidadesAtivas()==null) || 
             (this.indiceCavidadesAtivas!=null &&
              this.indiceCavidadesAtivas.equals(other.getIndiceCavidadesAtivas()))) &&
            ((this.indiceParada==null && other.getIndiceParada()==null) || 
             (this.indiceParada!=null &&
              this.indiceParada.equals(other.getIndiceParada()))) &&
            ((this.indicePerda==null && other.getIndicePerda()==null) || 
             (this.indicePerda!=null &&
              this.indicePerda.equals(other.getIndicePerda()))) &&
            ((this.indiceProducao==null && other.getIndiceProducao()==null) || 
             (this.indiceProducao!=null &&
              this.indiceProducao.equals(other.getIndiceProducao()))) &&
            ((this.indiceRefugo==null && other.getIndiceRefugo()==null) || 
             (this.indiceRefugo!=null &&
              this.indiceRefugo.equals(other.getIndiceRefugo()))) &&
            ((this.oee==null && other.getOee()==null) || 
             (this.oee!=null &&
              this.oee.equals(other.getOee()))) &&
            ((this.perdaCavidade==null && other.getPerdaCavidade()==null) || 
             (this.perdaCavidade!=null &&
              this.perdaCavidade.equals(other.getPerdaCavidade()))) &&
            ((this.perdaCiclo==null && other.getPerdaCiclo()==null) || 
             (this.perdaCiclo!=null &&
              this.perdaCiclo.equals(other.getPerdaCiclo()))) &&
            ((this.perdaParada==null && other.getPerdaParada()==null) || 
             (this.perdaParada!=null &&
              this.perdaParada.equals(other.getPerdaParada()))) &&
            ((this.perdaTotal==null && other.getPerdaTotal()==null) || 
             (this.perdaTotal!=null &&
              this.perdaTotal.equals(other.getPerdaTotal()))) &&
            ((this.pesoBruto==null && other.getPesoBruto()==null) || 
             (this.pesoBruto!=null &&
              this.pesoBruto.equals(other.getPesoBruto()))) &&
            ((this.pesoLiquido==null && other.getPesoLiquido()==null) || 
             (this.pesoLiquido!=null &&
              this.pesoLiquido.equals(other.getPesoLiquido()))) &&
            ((this.producaoBruta==null && other.getProducaoBruta()==null) || 
             (this.producaoBruta!=null &&
              this.producaoBruta.equals(other.getProducaoBruta()))) &&
            ((this.producaoLiquida==null && other.getProducaoLiquida()==null) || 
             (this.producaoLiquida!=null &&
              this.producaoLiquida.equals(other.getProducaoLiquida()))) &&
            ((this.producaoPlanejada==null && other.getProducaoPlanejada()==null) || 
             (this.producaoPlanejada!=null &&
              this.producaoPlanejada.equals(other.getProducaoPlanejada()))) &&
            ((this.producaoPlanejadaMedia==null && other.getProducaoPlanejadaMedia()==null) || 
             (this.producaoPlanejadaMedia!=null &&
              this.producaoPlanejadaMedia.equals(other.getProducaoPlanejadaMedia()))) &&
            ((this.producaoPrevista==null && other.getProducaoPrevista()==null) || 
             (this.producaoPrevista!=null &&
              this.producaoPrevista.equals(other.getProducaoPrevista()))) &&
            ((this.producaoRefugada==null && other.getProducaoRefugada()==null) || 
             (this.producaoRefugada!=null &&
              this.producaoRefugada.equals(other.getProducaoRefugada()))) &&
            this.qtAgrupCicloPadrao == other.getQtAgrupCicloPadrao() &&
            this.qtAgrupProducaoPlanejada == other.getQtAgrupProducaoPlanejada() &&
            ((this.qtCicloImprodutivo==null && other.getQtCicloImprodutivo()==null) || 
             (this.qtCicloImprodutivo!=null &&
              this.qtCicloImprodutivo.equals(other.getQtCicloImprodutivo()))) &&
            ((this.qtCicloProdutivo==null && other.getQtCicloProdutivo()==null) || 
             (this.qtCicloProdutivo!=null &&
              this.qtCicloProdutivo.equals(other.getQtCicloProdutivo()))) &&
            ((this.qtCicloRegulagem==null && other.getQtCicloRegulagem()==null) || 
             (this.qtCicloRegulagem!=null &&
              this.qtCicloRegulagem.equals(other.getQtCicloRegulagem()))) &&
            ((this.qtParadaDefault==null && other.getQtParadaDefault()==null) || 
             (this.qtParadaDefault!=null &&
              this.qtParadaDefault.equals(other.getQtParadaDefault()))) &&
            ((this.qtParadaFds==null && other.getQtParadaFds()==null) || 
             (this.qtParadaFds!=null &&
              this.qtParadaFds.equals(other.getQtParadaFds()))) &&
            ((this.qtParadaImprev==null && other.getQtParadaImprev()==null) || 
             (this.qtParadaImprev!=null &&
              this.qtParadaImprev.equals(other.getQtParadaImprev()))) &&
            ((this.qtParadaMdo==null && other.getQtParadaMdo()==null) || 
             (this.qtParadaMdo!=null &&
              this.qtParadaMdo.equals(other.getQtParadaMdo()))) &&
            ((this.qtParadaMtbf==null && other.getQtParadaMtbf()==null) || 
             (this.qtParadaMtbf!=null &&
              this.qtParadaMtbf.equals(other.getQtParadaMtbf()))) &&
            ((this.qtParadaMttr==null && other.getQtParadaMttr()==null) || 
             (this.qtParadaMttr!=null &&
              this.qtParadaMttr.equals(other.getQtParadaMttr()))) &&
            ((this.qtParadaPa==null && other.getQtParadaPa()==null) || 
             (this.qtParadaPa!=null &&
              this.qtParadaPa.equals(other.getQtParadaPa()))) &&
            ((this.qtParadaPao==null && other.getQtParadaPao()==null) || 
             (this.qtParadaPao!=null &&
              this.qtParadaPao.equals(other.getQtParadaPao()))) &&
            ((this.qtParadaPp==null && other.getQtParadaPp()==null) || 
             (this.qtParadaPp!=null &&
              this.qtParadaPp.equals(other.getQtParadaPp()))) &&
            ((this.qtParadaPrev==null && other.getQtParadaPrev()==null) || 
             (this.qtParadaPrev!=null &&
              this.qtParadaPrev.equals(other.getQtParadaPrev()))) &&
            ((this.qtParadaPtp==null && other.getQtParadaPtp()==null) || 
             (this.qtParadaPtp!=null &&
              this.qtParadaPtp.equals(other.getQtParadaPtp()))) &&
            ((this.qtParadaRegulagem==null && other.getQtParadaRegulagem()==null) || 
             (this.qtParadaRegulagem!=null &&
              this.qtParadaRegulagem.equals(other.getQtParadaRegulagem()))) &&
            ((this.qtParadaScp==null && other.getQtParadaScp()==null) || 
             (this.qtParadaScp!=null &&
              this.qtParadaScp.equals(other.getQtParadaScp()))) &&
            ((this.qtParadaSemCnx==null && other.getQtParadaSemCnx()==null) || 
             (this.qtParadaSemCnx!=null &&
              this.qtParadaSemCnx.equals(other.getQtParadaSemCnx()))) &&
            ((this.qtParadaSemEvt==null && other.getQtParadaSemEvt()==null) || 
             (this.qtParadaSemEvt!=null &&
              this.qtParadaSemEvt.equals(other.getQtParadaSemEvt()))) &&
            ((this.qtParadaSemOp==null && other.getQtParadaSemOp()==null) || 
             (this.qtParadaSemOp!=null &&
              this.qtParadaSemOp.equals(other.getQtParadaSemOp()))) &&
            ((this.ritmo==null && other.getRitmo()==null) || 
             (this.ritmo!=null &&
              this.ritmo.equals(other.getRitmo()))) &&
            ((this.tempoAlerta==null && other.getTempoAlerta()==null) || 
             (this.tempoAlerta!=null &&
              this.tempoAlerta.equals(other.getTempoAlerta()))) &&
            ((this.tempoAtivo==null && other.getTempoAtivo()==null) || 
             (this.tempoAtivo!=null &&
              this.tempoAtivo.equals(other.getTempoAtivo()))) &&
            ((this.tempoBoas==null && other.getTempoBoas()==null) || 
             (this.tempoBoas!=null &&
              this.tempoBoas.equals(other.getTempoBoas()))) &&
            ((this.tempoCicloImprodutivo==null && other.getTempoCicloImprodutivo()==null) || 
             (this.tempoCicloImprodutivo!=null &&
              this.tempoCicloImprodutivo.equals(other.getTempoCicloImprodutivo()))) &&
            ((this.tempoCicloProdutivo==null && other.getTempoCicloProdutivo()==null) || 
             (this.tempoCicloProdutivo!=null &&
              this.tempoCicloProdutivo.equals(other.getTempoCicloProdutivo()))) &&
            ((this.tempoCicloRegulagem==null && other.getTempoCicloRegulagem()==null) || 
             (this.tempoCicloRegulagem!=null &&
              this.tempoCicloRegulagem.equals(other.getTempoCicloRegulagem()))) &&
            ((this.tempoParadaAb==null && other.getTempoParadaAb()==null) || 
             (this.tempoParadaAb!=null &&
              this.tempoParadaAb.equals(other.getTempoParadaAb()))) &&
            ((this.tempoParadaCp==null && other.getTempoParadaCp()==null) || 
             (this.tempoParadaCp!=null &&
              this.tempoParadaCp.equals(other.getTempoParadaCp()))) &&
            ((this.tempoParadaCpVr==null && other.getTempoParadaCpVr()==null) || 
             (this.tempoParadaCpVr!=null &&
              this.tempoParadaCpVr.equals(other.getTempoParadaCpVr()))) &&
            ((this.tempoParadaDefault==null && other.getTempoParadaDefault()==null) || 
             (this.tempoParadaDefault!=null &&
              this.tempoParadaDefault.equals(other.getTempoParadaDefault()))) &&
            ((this.tempoParadaFds==null && other.getTempoParadaFds()==null) || 
             (this.tempoParadaFds!=null &&
              this.tempoParadaFds.equals(other.getTempoParadaFds()))) &&
            ((this.tempoParadaImprev==null && other.getTempoParadaImprev()==null) || 
             (this.tempoParadaImprev!=null &&
              this.tempoParadaImprev.equals(other.getTempoParadaImprev()))) &&
            ((this.tempoParadaMdo==null && other.getTempoParadaMdo()==null) || 
             (this.tempoParadaMdo!=null &&
              this.tempoParadaMdo.equals(other.getTempoParadaMdo()))) &&
            ((this.tempoParadaMtbf==null && other.getTempoParadaMtbf()==null) || 
             (this.tempoParadaMtbf!=null &&
              this.tempoParadaMtbf.equals(other.getTempoParadaMtbf()))) &&
            ((this.tempoParadaMttr==null && other.getTempoParadaMttr()==null) || 
             (this.tempoParadaMttr!=null &&
              this.tempoParadaMttr.equals(other.getTempoParadaMttr()))) &&
            ((this.tempoParadaPa==null && other.getTempoParadaPa()==null) || 
             (this.tempoParadaPa!=null &&
              this.tempoParadaPa.equals(other.getTempoParadaPa()))) &&
            ((this.tempoParadaPao==null && other.getTempoParadaPao()==null) || 
             (this.tempoParadaPao!=null &&
              this.tempoParadaPao.equals(other.getTempoParadaPao()))) &&
            ((this.tempoParadaPp==null && other.getTempoParadaPp()==null) || 
             (this.tempoParadaPp!=null &&
              this.tempoParadaPp.equals(other.getTempoParadaPp()))) &&
            ((this.tempoParadaPrev==null && other.getTempoParadaPrev()==null) || 
             (this.tempoParadaPrev!=null &&
              this.tempoParadaPrev.equals(other.getTempoParadaPrev()))) &&
            ((this.tempoParadaPtp==null && other.getTempoParadaPtp()==null) || 
             (this.tempoParadaPtp!=null &&
              this.tempoParadaPtp.equals(other.getTempoParadaPtp()))) &&
            ((this.tempoParadaRegulagem==null && other.getTempoParadaRegulagem()==null) || 
             (this.tempoParadaRegulagem!=null &&
              this.tempoParadaRegulagem.equals(other.getTempoParadaRegulagem()))) &&
            ((this.tempoParadaScp==null && other.getTempoParadaScp()==null) || 
             (this.tempoParadaScp!=null &&
              this.tempoParadaScp.equals(other.getTempoParadaScp()))) &&
            ((this.tempoParadaSemCnx==null && other.getTempoParadaSemCnx()==null) || 
             (this.tempoParadaSemCnx!=null &&
              this.tempoParadaSemCnx.equals(other.getTempoParadaSemCnx()))) &&
            ((this.tempoParadaSemEvt==null && other.getTempoParadaSemEvt()==null) || 
             (this.tempoParadaSemEvt!=null &&
              this.tempoParadaSemEvt.equals(other.getTempoParadaSemEvt()))) &&
            ((this.tempoParadaSemOp==null && other.getTempoParadaSemOp()==null) || 
             (this.tempoParadaSemOp!=null &&
              this.tempoParadaSemOp.equals(other.getTempoParadaSemOp()))) &&
            ((this.tempoParadaSp==null && other.getTempoParadaSp()==null) || 
             (this.tempoParadaSp!=null &&
              this.tempoParadaSp.equals(other.getTempoParadaSp()))) &&
            ((this.tempoParadaSpVr==null && other.getTempoParadaSpVr()==null) || 
             (this.tempoParadaSpVr!=null &&
              this.tempoParadaSpVr.equals(other.getTempoParadaSpVr()))) &&
            ((this.tempoPerdaCavidade==null && other.getTempoPerdaCavidade()==null) || 
             (this.tempoPerdaCavidade!=null &&
              this.tempoPerdaCavidade.equals(other.getTempoPerdaCavidade()))) &&
            ((this.tempoPeriodo==null && other.getTempoPeriodo()==null) || 
             (this.tempoPeriodo!=null &&
              this.tempoPeriodo.equals(other.getTempoPeriodo()))) &&
            ((this.tempoProdutivo==null && other.getTempoProdutivo()==null) || 
             (this.tempoProdutivo!=null &&
              this.tempoProdutivo.equals(other.getTempoProdutivo()))) &&
            ((this.tempoRefugadas==null && other.getTempoRefugadas()==null) || 
             (this.tempoRefugadas!=null &&
              this.tempoRefugadas.equals(other.getTempoRefugadas()))) &&
            ((this.tempoRefugado==null && other.getTempoRefugado()==null) || 
             (this.tempoRefugado!=null &&
              this.tempoRefugado.equals(other.getTempoRefugado()))) &&
            ((this.tempoTotal==null && other.getTempoTotal()==null) || 
             (this.tempoTotal!=null &&
              this.tempoTotal.equals(other.getTempoTotal()))) &&
            ((this.tempoTrabalhado==null && other.getTempoTrabalhado()==null) || 
             (this.tempoTrabalhado!=null &&
              this.tempoTrabalhado.equals(other.getTempoTrabalhado()))) &&
            ((this.ultimoCiclo==null && other.getUltimoCiclo()==null) || 
             (this.ultimoCiclo!=null &&
              this.ultimoCiclo.equals(other.getUltimoCiclo())));
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
        if (getCavAtivas() != null) {
            _hashCode += getCavAtivas().hashCode();
        }
        if (getCavAtivasMedia() != null) {
            _hashCode += getCavAtivasMedia().hashCode();
        }
        if (getCavTotal() != null) {
            _hashCode += getCavTotal().hashCode();
        }
        if (getCavTotalMedia() != null) {
            _hashCode += getCavTotalMedia().hashCode();
        }
        if (getCdCp() != null) {
            _hashCode += getCdCp().hashCode();
        }
        if (getCdPt() != null) {
            _hashCode += getCdPt().hashCode();
        }
        if (getCicloMedio() != null) {
            _hashCode += getCicloMedio().hashCode();
        }
        if (getCicloPadrao() != null) {
            _hashCode += getCicloPadrao().hashCode();
        }
        if (getCicloPadraoMedio() != null) {
            _hashCode += getCicloPadraoMedio().hashCode();
        }
        if (getDtHrFConsol() != null) {
            _hashCode += getDtHrFConsol().hashCode();
        }
        if (getDtHrFPeriodo() != null) {
            _hashCode += getDtHrFPeriodo().hashCode();
        }
        if (getDtHrIConsol() != null) {
            _hashCode += getDtHrIConsol().hashCode();
        }
        if (getDtHrIPeriodo() != null) {
            _hashCode += getDtHrIPeriodo().hashCode();
        }
        if (getEficienciaCiclo() != null) {
            _hashCode += getEficienciaCiclo().hashCode();
        }
        if (getEficienciaInstantanea() != null) {
            _hashCode += getEficienciaInstantanea().hashCode();
        }
        if (getEficienciaRealizacao() != null) {
            _hashCode += getEficienciaRealizacao().hashCode();
        }
        if (getIDO() != null) {
            _hashCode += getIDO().hashCode();
        }
        if (getIPA() != null) {
            _hashCode += getIPA().hashCode();
        }
        if (getITO() != null) {
            _hashCode += getITO().hashCode();
        }
        if (getIndiceCavidadesAtivas() != null) {
            _hashCode += getIndiceCavidadesAtivas().hashCode();
        }
        if (getIndiceParada() != null) {
            _hashCode += getIndiceParada().hashCode();
        }
        if (getIndicePerda() != null) {
            _hashCode += getIndicePerda().hashCode();
        }
        if (getIndiceProducao() != null) {
            _hashCode += getIndiceProducao().hashCode();
        }
        if (getIndiceRefugo() != null) {
            _hashCode += getIndiceRefugo().hashCode();
        }
        if (getOee() != null) {
            _hashCode += getOee().hashCode();
        }
        if (getPerdaCavidade() != null) {
            _hashCode += getPerdaCavidade().hashCode();
        }
        if (getPerdaCiclo() != null) {
            _hashCode += getPerdaCiclo().hashCode();
        }
        if (getPerdaParada() != null) {
            _hashCode += getPerdaParada().hashCode();
        }
        if (getPerdaTotal() != null) {
            _hashCode += getPerdaTotal().hashCode();
        }
        if (getPesoBruto() != null) {
            _hashCode += getPesoBruto().hashCode();
        }
        if (getPesoLiquido() != null) {
            _hashCode += getPesoLiquido().hashCode();
        }
        if (getProducaoBruta() != null) {
            _hashCode += getProducaoBruta().hashCode();
        }
        if (getProducaoLiquida() != null) {
            _hashCode += getProducaoLiquida().hashCode();
        }
        if (getProducaoPlanejada() != null) {
            _hashCode += getProducaoPlanejada().hashCode();
        }
        if (getProducaoPlanejadaMedia() != null) {
            _hashCode += getProducaoPlanejadaMedia().hashCode();
        }
        if (getProducaoPrevista() != null) {
            _hashCode += getProducaoPrevista().hashCode();
        }
        if (getProducaoRefugada() != null) {
            _hashCode += getProducaoRefugada().hashCode();
        }
        _hashCode += new Long(getQtAgrupCicloPadrao()).hashCode();
        _hashCode += new Long(getQtAgrupProducaoPlanejada()).hashCode();
        if (getQtCicloImprodutivo() != null) {
            _hashCode += getQtCicloImprodutivo().hashCode();
        }
        if (getQtCicloProdutivo() != null) {
            _hashCode += getQtCicloProdutivo().hashCode();
        }
        if (getQtCicloRegulagem() != null) {
            _hashCode += getQtCicloRegulagem().hashCode();
        }
        if (getQtParadaDefault() != null) {
            _hashCode += getQtParadaDefault().hashCode();
        }
        if (getQtParadaFds() != null) {
            _hashCode += getQtParadaFds().hashCode();
        }
        if (getQtParadaImprev() != null) {
            _hashCode += getQtParadaImprev().hashCode();
        }
        if (getQtParadaMdo() != null) {
            _hashCode += getQtParadaMdo().hashCode();
        }
        if (getQtParadaMtbf() != null) {
            _hashCode += getQtParadaMtbf().hashCode();
        }
        if (getQtParadaMttr() != null) {
            _hashCode += getQtParadaMttr().hashCode();
        }
        if (getQtParadaPa() != null) {
            _hashCode += getQtParadaPa().hashCode();
        }
        if (getQtParadaPao() != null) {
            _hashCode += getQtParadaPao().hashCode();
        }
        if (getQtParadaPp() != null) {
            _hashCode += getQtParadaPp().hashCode();
        }
        if (getQtParadaPrev() != null) {
            _hashCode += getQtParadaPrev().hashCode();
        }
        if (getQtParadaPtp() != null) {
            _hashCode += getQtParadaPtp().hashCode();
        }
        if (getQtParadaRegulagem() != null) {
            _hashCode += getQtParadaRegulagem().hashCode();
        }
        if (getQtParadaScp() != null) {
            _hashCode += getQtParadaScp().hashCode();
        }
        if (getQtParadaSemCnx() != null) {
            _hashCode += getQtParadaSemCnx().hashCode();
        }
        if (getQtParadaSemEvt() != null) {
            _hashCode += getQtParadaSemEvt().hashCode();
        }
        if (getQtParadaSemOp() != null) {
            _hashCode += getQtParadaSemOp().hashCode();
        }
        if (getRitmo() != null) {
            _hashCode += getRitmo().hashCode();
        }
        if (getTempoAlerta() != null) {
            _hashCode += getTempoAlerta().hashCode();
        }
        if (getTempoAtivo() != null) {
            _hashCode += getTempoAtivo().hashCode();
        }
        if (getTempoBoas() != null) {
            _hashCode += getTempoBoas().hashCode();
        }
        if (getTempoCicloImprodutivo() != null) {
            _hashCode += getTempoCicloImprodutivo().hashCode();
        }
        if (getTempoCicloProdutivo() != null) {
            _hashCode += getTempoCicloProdutivo().hashCode();
        }
        if (getTempoCicloRegulagem() != null) {
            _hashCode += getTempoCicloRegulagem().hashCode();
        }
        if (getTempoParadaAb() != null) {
            _hashCode += getTempoParadaAb().hashCode();
        }
        if (getTempoParadaCp() != null) {
            _hashCode += getTempoParadaCp().hashCode();
        }
        if (getTempoParadaCpVr() != null) {
            _hashCode += getTempoParadaCpVr().hashCode();
        }
        if (getTempoParadaDefault() != null) {
            _hashCode += getTempoParadaDefault().hashCode();
        }
        if (getTempoParadaFds() != null) {
            _hashCode += getTempoParadaFds().hashCode();
        }
        if (getTempoParadaImprev() != null) {
            _hashCode += getTempoParadaImprev().hashCode();
        }
        if (getTempoParadaMdo() != null) {
            _hashCode += getTempoParadaMdo().hashCode();
        }
        if (getTempoParadaMtbf() != null) {
            _hashCode += getTempoParadaMtbf().hashCode();
        }
        if (getTempoParadaMttr() != null) {
            _hashCode += getTempoParadaMttr().hashCode();
        }
        if (getTempoParadaPa() != null) {
            _hashCode += getTempoParadaPa().hashCode();
        }
        if (getTempoParadaPao() != null) {
            _hashCode += getTempoParadaPao().hashCode();
        }
        if (getTempoParadaPp() != null) {
            _hashCode += getTempoParadaPp().hashCode();
        }
        if (getTempoParadaPrev() != null) {
            _hashCode += getTempoParadaPrev().hashCode();
        }
        if (getTempoParadaPtp() != null) {
            _hashCode += getTempoParadaPtp().hashCode();
        }
        if (getTempoParadaRegulagem() != null) {
            _hashCode += getTempoParadaRegulagem().hashCode();
        }
        if (getTempoParadaScp() != null) {
            _hashCode += getTempoParadaScp().hashCode();
        }
        if (getTempoParadaSemCnx() != null) {
            _hashCode += getTempoParadaSemCnx().hashCode();
        }
        if (getTempoParadaSemEvt() != null) {
            _hashCode += getTempoParadaSemEvt().hashCode();
        }
        if (getTempoParadaSemOp() != null) {
            _hashCode += getTempoParadaSemOp().hashCode();
        }
        if (getTempoParadaSp() != null) {
            _hashCode += getTempoParadaSp().hashCode();
        }
        if (getTempoParadaSpVr() != null) {
            _hashCode += getTempoParadaSpVr().hashCode();
        }
        if (getTempoPerdaCavidade() != null) {
            _hashCode += getTempoPerdaCavidade().hashCode();
        }
        if (getTempoPeriodo() != null) {
            _hashCode += getTempoPeriodo().hashCode();
        }
        if (getTempoProdutivo() != null) {
            _hashCode += getTempoProdutivo().hashCode();
        }
        if (getTempoRefugadas() != null) {
            _hashCode += getTempoRefugadas().hashCode();
        }
        if (getTempoRefugado() != null) {
            _hashCode += getTempoRefugado().hashCode();
        }
        if (getTempoTotal() != null) {
            _hashCode += getTempoTotal().hashCode();
        }
        if (getTempoTrabalhado() != null) {
            _hashCode += getTempoTrabalhado().hashCode();
        }
        if (getUltimoCiclo() != null) {
            _hashCode += getUltimoCiclo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IndicadoresDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "indicadoresDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cavAtivas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cavAtivas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cavAtivasMedia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cavAtivasMedia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cavTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cavTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cavTotalMedia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cavTotalMedia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField.setFieldName("cdPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cicloMedio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cicloMedio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cicloPadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cicloPadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cicloPadraoMedio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cicloPadraoMedio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtHrFConsol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtHrFConsol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtHrFPeriodo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtHrFPeriodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtHrIConsol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtHrIConsol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtHrIPeriodo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtHrIPeriodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficienciaCiclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficienciaCiclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficienciaInstantanea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficienciaInstantanea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficienciaRealizacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficienciaRealizacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IPA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IPA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ITO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ITO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceCavidadesAtivas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceCavidadesAtivas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicePerda");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indicePerda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceProducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceProducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "oee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdaCavidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdaCavidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdaCiclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdaCiclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdaParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdaParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdaTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdaTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pesoBruto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pesoBruto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pesoLiquido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pesoLiquido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoBruta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoBruta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoLiquida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoLiquida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoPlanejada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoPlanejada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoPlanejadaMedia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoPlanejadaMedia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoPrevista");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoPrevista"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoRefugada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoRefugada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAgrupCicloPadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAgrupCicloPadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAgrupProducaoPlanejada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAgrupProducaoPlanejada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtCicloImprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtCicloImprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtCicloProdutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtCicloProdutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtCicloRegulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtCicloRegulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtParadaDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtParadaDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtParadaFds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtParadaFds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtParadaImprev");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtParadaImprev"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtParadaMdo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtParadaMdo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtParadaMtbf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtParadaMtbf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtParadaMttr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtParadaMttr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtParadaPa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtParadaPa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtParadaPao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtParadaPao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtParadaPp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtParadaPp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtParadaPrev");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtParadaPrev"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtParadaPtp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtParadaPtp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtParadaRegulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtParadaRegulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtParadaScp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtParadaScp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtParadaSemCnx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtParadaSemCnx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtParadaSemEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtParadaSemEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtParadaSemOp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtParadaSemOp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ritmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ritmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoAlerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoAlerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoAtivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoBoas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoBoas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoCicloImprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoCicloImprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoCicloProdutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoCicloProdutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoCicloRegulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoCicloRegulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaAb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaAb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaCpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaCpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaFds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaFds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaImprev");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaImprev"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaMdo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaMdo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaMtbf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaMtbf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaMttr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaMttr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaPa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaPa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaPao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaPao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaPp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaPp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaPrev");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaPrev"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaPtp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaPtp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaRegulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaRegulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaScp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaScp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaSemCnx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaSemCnx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaSemEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaSemEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaSemOp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaSemOp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaSp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaSp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaSpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaSpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoPerdaCavidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoPerdaCavidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoPeriodo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoPeriodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoProdutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoProdutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoRefugadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoRefugadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoRefugado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoRefugado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoTrabalhado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoTrabalhado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ultimoCiclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ultimoCiclo"));
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
