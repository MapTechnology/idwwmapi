/**
 * MaquinaTotalInjetDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MaquinaTotalInjetDTO  implements java.io.Serializable {
    private java.math.BigDecimal cicloMedio;

    private java.math.BigDecimal cicloPadrao;

    private java.lang.Float eficienciaCiclo;

    private idw.idwws.EficienciaCicloInjetDTO[] eficienciaCicloDTOs;

    private java.lang.Float eficienciaCicloPonderada;

    private java.lang.Float eficienciaRealizacao;

    private java.lang.Float eficienciaUltimoCiclo;

    private java.lang.Float indiceCavidadeAtiva;

    private java.lang.Float indiceParada;

    private java.lang.Float indicePerda;

    private java.lang.Float indiceRefugo;

    private java.math.BigDecimal pci;

    private java.math.BigDecimal perdaCavidadeCusto;

    private java.math.BigDecimal perdaCavidadeKg;

    private java.math.BigDecimal perdaCavidadeUnidade;

    private java.math.BigDecimal perdaCicloCusto;

    private java.math.BigDecimal perdaCicloUnidade;

    private java.math.BigDecimal perdaParadaCusto;

    private java.math.BigDecimal perdaParadaSemPesoCusto;

    private java.math.BigDecimal perdaParadasKq;

    private java.math.BigDecimal perdaParadasSemPesoKg;

    private java.math.BigDecimal perdaParadasSemPesoUnidade;

    private java.math.BigDecimal perdaParadasUnidade;

    private java.math.BigDecimal producaoBrutaKg;

    private java.math.BigDecimal producaoBrutaUnidade;

    private java.math.BigDecimal producaoLiquidaKg;

    private java.math.BigDecimal producaoLiquidaUnidade;

    private java.math.BigDecimal producaoPrevistaHoraria;

    private java.math.BigDecimal producaoPrevistaKg;

    private java.math.BigDecimal producaoPrevistaUnidade;

    private java.math.BigDecimal producaoRefugadaCusto;

    private java.math.BigDecimal producaoRefugadaKg;

    private java.math.BigDecimal producaoRefugadaUnidade;

    private java.lang.Integer qtCicloPadraoDiferentes;

    private java.math.BigDecimal qtCiclosPrevistos;

    private java.math.BigDecimal qtInjNormal;
    
    private java.lang.Integer qtOcorrenciaParadasMTBFMTTR;

    private java.math.BigDecimal tempoAtivoSegundos;

    private java.math.BigDecimal tempoCicloImprodutivoSegundos;

    private java.math.BigDecimal tempoCicloProdutivoSegundos;

    private java.math.BigDecimal tempoCorrecaoCTT;

    private java.math.BigDecimal tempoDisponiveisSegundos;

    private java.math.BigDecimal tempoParadaEmAbertoSegundos;

    private java.math.BigDecimal tempoParadaSegundos;

    private java.math.BigDecimal tempoParadaSemPesoSegundos;

    private java.math.BigDecimal tempoParadasMTTR;

    private java.math.BigDecimal tempoPerdaCavidadeSegundos;

    private java.math.BigDecimal tempoPerdaCicloSegundos;

    private java.math.BigDecimal tempoPrevistoCicloSegundos;

    private java.math.BigDecimal tempoProdutivasSegundos;

    private java.math.BigDecimal tempoRefugoSegundos;

    private java.math.BigDecimal tempoRitmoSegundos;

    private java.math.BigDecimal tempoTrabalhadoSegundos;

    private java.math.BigDecimal ultimoCiclo;

    private java.lang.Float utilizacao;

    public MaquinaTotalInjetDTO() {
    }

    public MaquinaTotalInjetDTO(
           java.math.BigDecimal cicloMedio,
           java.math.BigDecimal cicloPadrao,
           java.lang.Float eficienciaCiclo,
           idw.idwws.EficienciaCicloInjetDTO[] eficienciaCicloDTOs,
           java.lang.Float eficienciaCicloPonderada,
           java.lang.Float eficienciaRealizacao,
           java.lang.Float eficienciaUltimoCiclo,
           java.lang.Float indiceCavidadeAtiva,
           java.lang.Float indiceParada,
           java.lang.Float indicePerda,
           java.lang.Float indiceRefugo,
           java.math.BigDecimal pci,
           java.math.BigDecimal perdaCavidadeCusto,
           java.math.BigDecimal perdaCavidadeKg,
           java.math.BigDecimal perdaCavidadeUnidade,
           java.math.BigDecimal perdaCicloCusto,
           java.math.BigDecimal perdaCicloUnidade,
           java.math.BigDecimal perdaParadaCusto,
           java.math.BigDecimal perdaParadaSemPesoCusto,
           java.math.BigDecimal perdaParadasKq,
           java.math.BigDecimal perdaParadasSemPesoKg,
           java.math.BigDecimal perdaParadasSemPesoUnidade,
           java.math.BigDecimal perdaParadasUnidade,
           java.math.BigDecimal producaoBrutaKg,
           java.math.BigDecimal producaoBrutaUnidade,
           java.math.BigDecimal producaoLiquidaKg,
           java.math.BigDecimal producaoLiquidaUnidade,
           java.math.BigDecimal producaoPrevistaHoraria,
           java.math.BigDecimal producaoPrevistaKg,
           java.math.BigDecimal producaoPrevistaUnidade,
           java.math.BigDecimal producaoRefugadaCusto,
           java.math.BigDecimal producaoRefugadaKg,
           java.math.BigDecimal producaoRefugadaUnidade,
           java.lang.Integer qtCicloPadraoDiferentes,
           java.math.BigDecimal qtCiclosPrevistos,
           java.math.BigDecimal qtInjNormal,
           java.lang.Integer qtOcorrenciaParadasMTBFMTTR,
           java.math.BigDecimal tempoAtivoSegundos,
           java.math.BigDecimal tempoCicloImprodutivoSegundos,
           java.math.BigDecimal tempoCicloProdutivoSegundos,
           java.math.BigDecimal tempoCorrecaoCTT,
           java.math.BigDecimal tempoDisponiveisSegundos,
           java.math.BigDecimal tempoParadaEmAbertoSegundos,
           java.math.BigDecimal tempoParadaSegundos,
           java.math.BigDecimal tempoParadaSemPesoSegundos,
           java.math.BigDecimal tempoParadasMTTR,
           java.math.BigDecimal tempoPerdaCavidadeSegundos,
           java.math.BigDecimal tempoPerdaCicloSegundos,
           java.math.BigDecimal tempoPrevistoCicloSegundos,
           java.math.BigDecimal tempoProdutivasSegundos,
           java.math.BigDecimal tempoRefugoSegundos,
           java.math.BigDecimal tempoRitmoSegundos,
           java.math.BigDecimal tempoTrabalhadoSegundos,
           java.math.BigDecimal ultimoCiclo,
           java.lang.Float utilizacao) {
           this.cicloMedio = cicloMedio;
           this.cicloPadrao = cicloPadrao;
           this.eficienciaCiclo = eficienciaCiclo;
           this.eficienciaCicloDTOs = eficienciaCicloDTOs;
           this.eficienciaCicloPonderada = eficienciaCicloPonderada;
           this.eficienciaRealizacao = eficienciaRealizacao;
           this.eficienciaUltimoCiclo = eficienciaUltimoCiclo;
           this.indiceCavidadeAtiva = indiceCavidadeAtiva;
           this.indiceParada = indiceParada;
           this.indicePerda = indicePerda;
           this.indiceRefugo = indiceRefugo;
           this.pci = pci;
           this.perdaCavidadeCusto = perdaCavidadeCusto;
           this.perdaCavidadeKg = perdaCavidadeKg;
           this.perdaCavidadeUnidade = perdaCavidadeUnidade;
           this.perdaCicloCusto = perdaCicloCusto;
           this.perdaCicloUnidade = perdaCicloUnidade;
           this.perdaParadaCusto = perdaParadaCusto;
           this.perdaParadaSemPesoCusto = perdaParadaSemPesoCusto;
           this.perdaParadasKq = perdaParadasKq;
           this.perdaParadasSemPesoKg = perdaParadasSemPesoKg;
           this.perdaParadasSemPesoUnidade = perdaParadasSemPesoUnidade;
           this.perdaParadasUnidade = perdaParadasUnidade;
           this.producaoBrutaKg = producaoBrutaKg;
           this.producaoBrutaUnidade = producaoBrutaUnidade;
           this.producaoLiquidaKg = producaoLiquidaKg;
           this.producaoLiquidaUnidade = producaoLiquidaUnidade;
           this.producaoPrevistaHoraria = producaoPrevistaHoraria;
           this.producaoPrevistaKg = producaoPrevistaKg;
           this.producaoPrevistaUnidade = producaoPrevistaUnidade;
           this.producaoRefugadaCusto = producaoRefugadaCusto;
           this.producaoRefugadaKg = producaoRefugadaKg;
           this.producaoRefugadaUnidade = producaoRefugadaUnidade;
           this.qtCicloPadraoDiferentes = qtCicloPadraoDiferentes;
           this.qtCiclosPrevistos = qtCiclosPrevistos;
           this.qtInjNormal = qtInjNormal;
           this.qtOcorrenciaParadasMTBFMTTR = qtOcorrenciaParadasMTBFMTTR;
           this.tempoAtivoSegundos = tempoAtivoSegundos;
           this.tempoCicloImprodutivoSegundos = tempoCicloImprodutivoSegundos;
           this.tempoCicloProdutivoSegundos = tempoCicloProdutivoSegundos;
           this.tempoCorrecaoCTT = tempoCorrecaoCTT;
           this.tempoDisponiveisSegundos = tempoDisponiveisSegundos;
           this.tempoParadaEmAbertoSegundos = tempoParadaEmAbertoSegundos;
           this.tempoParadaSegundos = tempoParadaSegundos;
           this.tempoParadaSemPesoSegundos = tempoParadaSemPesoSegundos;
           this.tempoParadasMTTR = tempoParadasMTTR;
           this.tempoPerdaCavidadeSegundos = tempoPerdaCavidadeSegundos;
           this.tempoPerdaCicloSegundos = tempoPerdaCicloSegundos;
           this.tempoPrevistoCicloSegundos = tempoPrevistoCicloSegundos;
           this.tempoProdutivasSegundos = tempoProdutivasSegundos;
           this.tempoRefugoSegundos = tempoRefugoSegundos;
           this.tempoRitmoSegundos = tempoRitmoSegundos;
           this.tempoTrabalhadoSegundos = tempoTrabalhadoSegundos;
           this.ultimoCiclo = ultimoCiclo;
           this.utilizacao = utilizacao;
    }


    /**
     * Gets the cicloMedio value for this MaquinaTotalInjetDTO.
     * 
     * @return cicloMedio
     */
    public java.math.BigDecimal getCicloMedio() {
        return cicloMedio;
    }


    /**
     * Sets the cicloMedio value for this MaquinaTotalInjetDTO.
     * 
     * @param cicloMedio
     */
    public void setCicloMedio(java.math.BigDecimal cicloMedio) {
        this.cicloMedio = cicloMedio;
    }


    /**
     * Gets the cicloPadrao value for this MaquinaTotalInjetDTO.
     * 
     * @return cicloPadrao
     */
    public java.math.BigDecimal getCicloPadrao() {
        return cicloPadrao;
    }


    /**
     * Sets the cicloPadrao value for this MaquinaTotalInjetDTO.
     * 
     * @param cicloPadrao
     */
    public void setCicloPadrao(java.math.BigDecimal cicloPadrao) {
        this.cicloPadrao = cicloPadrao;
    }


    /**
     * Gets the eficienciaCiclo value for this MaquinaTotalInjetDTO.
     * 
     * @return eficienciaCiclo
     */
    public java.lang.Float getEficienciaCiclo() {
        return eficienciaCiclo;
    }


    /**
     * Sets the eficienciaCiclo value for this MaquinaTotalInjetDTO.
     * 
     * @param eficienciaCiclo
     */
    public void setEficienciaCiclo(java.lang.Float eficienciaCiclo) {
        this.eficienciaCiclo = eficienciaCiclo;
    }


    /**
     * Gets the eficienciaCicloDTOs value for this MaquinaTotalInjetDTO.
     * 
     * @return eficienciaCicloDTOs
     */
    public idw.idwws.EficienciaCicloInjetDTO[] getEficienciaCicloDTOs() {
        return eficienciaCicloDTOs;
    }


    /**
     * Sets the eficienciaCicloDTOs value for this MaquinaTotalInjetDTO.
     * 
     * @param eficienciaCicloDTOs
     */
    public void setEficienciaCicloDTOs(idw.idwws.EficienciaCicloInjetDTO[] eficienciaCicloDTOs) {
        this.eficienciaCicloDTOs = eficienciaCicloDTOs;
    }

    public idw.idwws.EficienciaCicloInjetDTO getEficienciaCicloDTOs(int i) {
        return this.eficienciaCicloDTOs[i];
    }

    public void setEficienciaCicloDTOs(int i, idw.idwws.EficienciaCicloInjetDTO _value) {
        this.eficienciaCicloDTOs[i] = _value;
    }


    /**
     * Gets the eficienciaCicloPonderada value for this MaquinaTotalInjetDTO.
     * 
     * @return eficienciaCicloPonderada
     */
    public java.lang.Float getEficienciaCicloPonderada() {
        return eficienciaCicloPonderada;
    }


    /**
     * Sets the eficienciaCicloPonderada value for this MaquinaTotalInjetDTO.
     * 
     * @param eficienciaCicloPonderada
     */
    public void setEficienciaCicloPonderada(java.lang.Float eficienciaCicloPonderada) {
        this.eficienciaCicloPonderada = eficienciaCicloPonderada;
    }


    /**
     * Gets the eficienciaRealizacao value for this MaquinaTotalInjetDTO.
     * 
     * @return eficienciaRealizacao
     */
    public java.lang.Float getEficienciaRealizacao() {
        return eficienciaRealizacao;
    }


    /**
     * Sets the eficienciaRealizacao value for this MaquinaTotalInjetDTO.
     * 
     * @param eficienciaRealizacao
     */
    public void setEficienciaRealizacao(java.lang.Float eficienciaRealizacao) {
        this.eficienciaRealizacao = eficienciaRealizacao;
    }


    /**
     * Gets the eficienciaUltimoCiclo value for this MaquinaTotalInjetDTO.
     * 
     * @return eficienciaUltimoCiclo
     */
    public java.lang.Float getEficienciaUltimoCiclo() {
        return eficienciaUltimoCiclo;
    }


    /**
     * Sets the eficienciaUltimoCiclo value for this MaquinaTotalInjetDTO.
     * 
     * @param eficienciaUltimoCiclo
     */
    public void setEficienciaUltimoCiclo(java.lang.Float eficienciaUltimoCiclo) {
        this.eficienciaUltimoCiclo = eficienciaUltimoCiclo;
    }


    /**
     * Gets the indiceCavidadeAtiva value for this MaquinaTotalInjetDTO.
     * 
     * @return indiceCavidadeAtiva
     */
    public java.lang.Float getIndiceCavidadeAtiva() {
        return indiceCavidadeAtiva;
    }


    /**
     * Sets the indiceCavidadeAtiva value for this MaquinaTotalInjetDTO.
     * 
     * @param indiceCavidadeAtiva
     */
    public void setIndiceCavidadeAtiva(java.lang.Float indiceCavidadeAtiva) {
        this.indiceCavidadeAtiva = indiceCavidadeAtiva;
    }


    /**
     * Gets the indiceParada value for this MaquinaTotalInjetDTO.
     * 
     * @return indiceParada
     */
    public java.lang.Float getIndiceParada() {
        return indiceParada;
    }


    /**
     * Sets the indiceParada value for this MaquinaTotalInjetDTO.
     * 
     * @param indiceParada
     */
    public void setIndiceParada(java.lang.Float indiceParada) {
        this.indiceParada = indiceParada;
    }


    /**
     * Gets the indicePerda value for this MaquinaTotalInjetDTO.
     * 
     * @return indicePerda
     */
    public java.lang.Float getIndicePerda() {
        return indicePerda;
    }


    /**
     * Sets the indicePerda value for this MaquinaTotalInjetDTO.
     * 
     * @param indicePerda
     */
    public void setIndicePerda(java.lang.Float indicePerda) {
        this.indicePerda = indicePerda;
    }


    /**
     * Gets the indiceRefugo value for this MaquinaTotalInjetDTO.
     * 
     * @return indiceRefugo
     */
    public java.lang.Float getIndiceRefugo() {
        return indiceRefugo;
    }


    /**
     * Sets the indiceRefugo value for this MaquinaTotalInjetDTO.
     * 
     * @param indiceRefugo
     */
    public void setIndiceRefugo(java.lang.Float indiceRefugo) {
        this.indiceRefugo = indiceRefugo;
    }


    /**
     * Gets the pci value for this MaquinaTotalInjetDTO.
     * 
     * @return pci
     */
    public java.math.BigDecimal getPci() {
        return pci;
    }


    /**
     * Sets the pci value for this MaquinaTotalInjetDTO.
     * 
     * @param pci
     */
    public void setPci(java.math.BigDecimal pci) {
        this.pci = pci;
    }


    /**
     * Gets the perdaCavidadeCusto value for this MaquinaTotalInjetDTO.
     * 
     * @return perdaCavidadeCusto
     */
    public java.math.BigDecimal getPerdaCavidadeCusto() {
        return perdaCavidadeCusto;
    }


    /**
     * Sets the perdaCavidadeCusto value for this MaquinaTotalInjetDTO.
     * 
     * @param perdaCavidadeCusto
     */
    public void setPerdaCavidadeCusto(java.math.BigDecimal perdaCavidadeCusto) {
        this.perdaCavidadeCusto = perdaCavidadeCusto;
    }


    /**
     * Gets the perdaCavidadeKg value for this MaquinaTotalInjetDTO.
     * 
     * @return perdaCavidadeKg
     */
    public java.math.BigDecimal getPerdaCavidadeKg() {
        return perdaCavidadeKg;
    }


    /**
     * Sets the perdaCavidadeKg value for this MaquinaTotalInjetDTO.
     * 
     * @param perdaCavidadeKg
     */
    public void setPerdaCavidadeKg(java.math.BigDecimal perdaCavidadeKg) {
        this.perdaCavidadeKg = perdaCavidadeKg;
    }


    /**
     * Gets the perdaCavidadeUnidade value for this MaquinaTotalInjetDTO.
     * 
     * @return perdaCavidadeUnidade
     */
    public java.math.BigDecimal getPerdaCavidadeUnidade() {
        return perdaCavidadeUnidade;
    }


    /**
     * Sets the perdaCavidadeUnidade value for this MaquinaTotalInjetDTO.
     * 
     * @param perdaCavidadeUnidade
     */
    public void setPerdaCavidadeUnidade(java.math.BigDecimal perdaCavidadeUnidade) {
        this.perdaCavidadeUnidade = perdaCavidadeUnidade;
    }


    /**
     * Gets the perdaCicloCusto value for this MaquinaTotalInjetDTO.
     * 
     * @return perdaCicloCusto
     */
    public java.math.BigDecimal getPerdaCicloCusto() {
        return perdaCicloCusto;
    }


    /**
     * Sets the perdaCicloCusto value for this MaquinaTotalInjetDTO.
     * 
     * @param perdaCicloCusto
     */
    public void setPerdaCicloCusto(java.math.BigDecimal perdaCicloCusto) {
        this.perdaCicloCusto = perdaCicloCusto;
    }


    /**
     * Gets the perdaCicloUnidade value for this MaquinaTotalInjetDTO.
     * 
     * @return perdaCicloUnidade
     */
    public java.math.BigDecimal getPerdaCicloUnidade() {
        return perdaCicloUnidade;
    }


    /**
     * Sets the perdaCicloUnidade value for this MaquinaTotalInjetDTO.
     * 
     * @param perdaCicloUnidade
     */
    public void setPerdaCicloUnidade(java.math.BigDecimal perdaCicloUnidade) {
        this.perdaCicloUnidade = perdaCicloUnidade;
    }


    /**
     * Gets the perdaParadaCusto value for this MaquinaTotalInjetDTO.
     * 
     * @return perdaParadaCusto
     */
    public java.math.BigDecimal getPerdaParadaCusto() {
        return perdaParadaCusto;
    }


    /**
     * Sets the perdaParadaCusto value for this MaquinaTotalInjetDTO.
     * 
     * @param perdaParadaCusto
     */
    public void setPerdaParadaCusto(java.math.BigDecimal perdaParadaCusto) {
        this.perdaParadaCusto = perdaParadaCusto;
    }


    /**
     * Gets the perdaParadaSemPesoCusto value for this MaquinaTotalInjetDTO.
     * 
     * @return perdaParadaSemPesoCusto
     */
    public java.math.BigDecimal getPerdaParadaSemPesoCusto() {
        return perdaParadaSemPesoCusto;
    }


    /**
     * Sets the perdaParadaSemPesoCusto value for this MaquinaTotalInjetDTO.
     * 
     * @param perdaParadaSemPesoCusto
     */
    public void setPerdaParadaSemPesoCusto(java.math.BigDecimal perdaParadaSemPesoCusto) {
        this.perdaParadaSemPesoCusto = perdaParadaSemPesoCusto;
    }


    /**
     * Gets the perdaParadasKq value for this MaquinaTotalInjetDTO.
     * 
     * @return perdaParadasKq
     */
    public java.math.BigDecimal getPerdaParadasKq() {
        return perdaParadasKq;
    }


    /**
     * Sets the perdaParadasKq value for this MaquinaTotalInjetDTO.
     * 
     * @param perdaParadasKq
     */
    public void setPerdaParadasKq(java.math.BigDecimal perdaParadasKq) {
        this.perdaParadasKq = perdaParadasKq;
    }


    /**
     * Gets the perdaParadasSemPesoKg value for this MaquinaTotalInjetDTO.
     * 
     * @return perdaParadasSemPesoKg
     */
    public java.math.BigDecimal getPerdaParadasSemPesoKg() {
        return perdaParadasSemPesoKg;
    }


    /**
     * Sets the perdaParadasSemPesoKg value for this MaquinaTotalInjetDTO.
     * 
     * @param perdaParadasSemPesoKg
     */
    public void setPerdaParadasSemPesoKg(java.math.BigDecimal perdaParadasSemPesoKg) {
        this.perdaParadasSemPesoKg = perdaParadasSemPesoKg;
    }


    /**
     * Gets the perdaParadasSemPesoUnidade value for this MaquinaTotalInjetDTO.
     * 
     * @return perdaParadasSemPesoUnidade
     */
    public java.math.BigDecimal getPerdaParadasSemPesoUnidade() {
        return perdaParadasSemPesoUnidade;
    }


    /**
     * Sets the perdaParadasSemPesoUnidade value for this MaquinaTotalInjetDTO.
     * 
     * @param perdaParadasSemPesoUnidade
     */
    public void setPerdaParadasSemPesoUnidade(java.math.BigDecimal perdaParadasSemPesoUnidade) {
        this.perdaParadasSemPesoUnidade = perdaParadasSemPesoUnidade;
    }


    /**
     * Gets the perdaParadasUnidade value for this MaquinaTotalInjetDTO.
     * 
     * @return perdaParadasUnidade
     */
    public java.math.BigDecimal getPerdaParadasUnidade() {
        return perdaParadasUnidade;
    }


    /**
     * Sets the perdaParadasUnidade value for this MaquinaTotalInjetDTO.
     * 
     * @param perdaParadasUnidade
     */
    public void setPerdaParadasUnidade(java.math.BigDecimal perdaParadasUnidade) {
        this.perdaParadasUnidade = perdaParadasUnidade;
    }


    /**
     * Gets the producaoBrutaKg value for this MaquinaTotalInjetDTO.
     * 
     * @return producaoBrutaKg
     */
    public java.math.BigDecimal getProducaoBrutaKg() {
        return producaoBrutaKg;
    }


    /**
     * Sets the producaoBrutaKg value for this MaquinaTotalInjetDTO.
     * 
     * @param producaoBrutaKg
     */
    public void setProducaoBrutaKg(java.math.BigDecimal producaoBrutaKg) {
        this.producaoBrutaKg = producaoBrutaKg;
    }


    /**
     * Gets the producaoBrutaUnidade value for this MaquinaTotalInjetDTO.
     * 
     * @return producaoBrutaUnidade
     */
    public java.math.BigDecimal getProducaoBrutaUnidade() {
        return producaoBrutaUnidade;
    }


    /**
     * Sets the producaoBrutaUnidade value for this MaquinaTotalInjetDTO.
     * 
     * @param producaoBrutaUnidade
     */
    public void setProducaoBrutaUnidade(java.math.BigDecimal producaoBrutaUnidade) {
        this.producaoBrutaUnidade = producaoBrutaUnidade;
    }


    /**
     * Gets the producaoLiquidaKg value for this MaquinaTotalInjetDTO.
     * 
     * @return producaoLiquidaKg
     */
    public java.math.BigDecimal getProducaoLiquidaKg() {
        return producaoLiquidaKg;
    }


    /**
     * Sets the producaoLiquidaKg value for this MaquinaTotalInjetDTO.
     * 
     * @param producaoLiquidaKg
     */
    public void setProducaoLiquidaKg(java.math.BigDecimal producaoLiquidaKg) {
        this.producaoLiquidaKg = producaoLiquidaKg;
    }


    /**
     * Gets the producaoLiquidaUnidade value for this MaquinaTotalInjetDTO.
     * 
     * @return producaoLiquidaUnidade
     */
    public java.math.BigDecimal getProducaoLiquidaUnidade() {
        return producaoLiquidaUnidade;
    }


    /**
     * Sets the producaoLiquidaUnidade value for this MaquinaTotalInjetDTO.
     * 
     * @param producaoLiquidaUnidade
     */
    public void setProducaoLiquidaUnidade(java.math.BigDecimal producaoLiquidaUnidade) {
        this.producaoLiquidaUnidade = producaoLiquidaUnidade;
    }


    /**
     * Gets the producaoPrevistaHoraria value for this MaquinaTotalInjetDTO.
     * 
     * @return producaoPrevistaHoraria
     */
    public java.math.BigDecimal getProducaoPrevistaHoraria() {
        return producaoPrevistaHoraria;
    }


    /**
     * Sets the producaoPrevistaHoraria value for this MaquinaTotalInjetDTO.
     * 
     * @param producaoPrevistaHoraria
     */
    public void setProducaoPrevistaHoraria(java.math.BigDecimal producaoPrevistaHoraria) {
        this.producaoPrevistaHoraria = producaoPrevistaHoraria;
    }


    /**
     * Gets the producaoPrevistaKg value for this MaquinaTotalInjetDTO.
     * 
     * @return producaoPrevistaKg
     */
    public java.math.BigDecimal getProducaoPrevistaKg() {
        return producaoPrevistaKg;
    }


    /**
     * Sets the producaoPrevistaKg value for this MaquinaTotalInjetDTO.
     * 
     * @param producaoPrevistaKg
     */
    public void setProducaoPrevistaKg(java.math.BigDecimal producaoPrevistaKg) {
        this.producaoPrevistaKg = producaoPrevistaKg;
    }


    /**
     * Gets the producaoPrevistaUnidade value for this MaquinaTotalInjetDTO.
     * 
     * @return producaoPrevistaUnidade
     */
    public java.math.BigDecimal getProducaoPrevistaUnidade() {
        return producaoPrevistaUnidade;
    }


    /**
     * Sets the producaoPrevistaUnidade value for this MaquinaTotalInjetDTO.
     * 
     * @param producaoPrevistaUnidade
     */
    public void setProducaoPrevistaUnidade(java.math.BigDecimal producaoPrevistaUnidade) {
        this.producaoPrevistaUnidade = producaoPrevistaUnidade;
    }


    /**
     * Gets the producaoRefugadaCusto value for this MaquinaTotalInjetDTO.
     * 
     * @return producaoRefugadaCusto
     */
    public java.math.BigDecimal getProducaoRefugadaCusto() {
        return producaoRefugadaCusto;
    }


    /**
     * Sets the producaoRefugadaCusto value for this MaquinaTotalInjetDTO.
     * 
     * @param producaoRefugadaCusto
     */
    public void setProducaoRefugadaCusto(java.math.BigDecimal producaoRefugadaCusto) {
        this.producaoRefugadaCusto = producaoRefugadaCusto;
    }


    /**
     * Gets the producaoRefugadaKg value for this MaquinaTotalInjetDTO.
     * 
     * @return producaoRefugadaKg
     */
    public java.math.BigDecimal getProducaoRefugadaKg() {
        return producaoRefugadaKg;
    }


    /**
     * Sets the producaoRefugadaKg value for this MaquinaTotalInjetDTO.
     * 
     * @param producaoRefugadaKg
     */
    public void setProducaoRefugadaKg(java.math.BigDecimal producaoRefugadaKg) {
        this.producaoRefugadaKg = producaoRefugadaKg;
    }


    /**
     * Gets the producaoRefugadaUnidade value for this MaquinaTotalInjetDTO.
     * 
     * @return producaoRefugadaUnidade
     */
    public java.math.BigDecimal getProducaoRefugadaUnidade() {
        return producaoRefugadaUnidade;
    }


    /**
     * Sets the producaoRefugadaUnidade value for this MaquinaTotalInjetDTO.
     * 
     * @param producaoRefugadaUnidade
     */
    public void setProducaoRefugadaUnidade(java.math.BigDecimal producaoRefugadaUnidade) {
        this.producaoRefugadaUnidade = producaoRefugadaUnidade;
    }


    /**
     * Gets the qtCicloPadraoDiferentes value for this MaquinaTotalInjetDTO.
     * 
     * @return qtCicloPadraoDiferentes
     */
    public java.lang.Integer getQtCicloPadraoDiferentes() {
        return qtCicloPadraoDiferentes;
    }


    /**
     * Sets the qtCicloPadraoDiferentes value for this MaquinaTotalInjetDTO.
     * 
     * @param qtCicloPadraoDiferentes
     */
    public void setQtCicloPadraoDiferentes(java.lang.Integer qtCicloPadraoDiferentes) {
        this.qtCicloPadraoDiferentes = qtCicloPadraoDiferentes;
    }

    
    
    /**
     * Gets the qtCiclosPrevistos value for this MaquinaTotalInjetDTO.
     * 
     * @return qtCiclosPrevistos
     */
    public java.math.BigDecimal getQtCiclosPrevistos() {
		return qtCiclosPrevistos;
	}

    /**
     * Sets the qtCiclosPrevistos value for this MaquinaTotalInjetDTO.
     * 
     * @param qtCiclosPrevistos
     */
	public void setQtCiclosPrevistos(java.math.BigDecimal qtCiclosPrevistos) {
		this.qtCiclosPrevistos = qtCiclosPrevistos;
	}

	/**
     * Gets the qtInjNormal value for this MaquinaTotalInjetDTO.
     * 
     * @return qtInjNormal
     */
    public java.math.BigDecimal getQtInjNormal() {
        return qtInjNormal;
    }


    /**
     * Sets the qtInjNormal value for this MaquinaTotalInjetDTO.
     * 
     * @param qtInjNormal
     */
    public void setQtInjNormal(java.math.BigDecimal qtInjNormal) {
        this.qtInjNormal = qtInjNormal;
    }


    /**
     * Gets the qtOcorrenciaParadasMTBFMTTR value for this MaquinaTotalInjetDTO.
     * 
     * @return qtOcorrenciaParadasMTBFMTTR
     */
    public java.lang.Integer getQtOcorrenciaParadasMTBFMTTR() {
        return qtOcorrenciaParadasMTBFMTTR;
    }


    /**
     * Sets the qtOcorrenciaParadasMTBFMTTR value for this MaquinaTotalInjetDTO.
     * 
     * @param qtOcorrenciaParadasMTBFMTTR
     */
    public void setQtOcorrenciaParadasMTBFMTTR(java.lang.Integer qtOcorrenciaParadasMTBFMTTR) {
        this.qtOcorrenciaParadasMTBFMTTR = qtOcorrenciaParadasMTBFMTTR;
    }


    /**
     * Gets the tempoAtivoSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @return tempoAtivoSegundos
     */
    public java.math.BigDecimal getTempoAtivoSegundos() {
        return tempoAtivoSegundos;
    }


    /**
     * Sets the tempoAtivoSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @param tempoAtivoSegundos
     */
    public void setTempoAtivoSegundos(java.math.BigDecimal tempoAtivoSegundos) {
        this.tempoAtivoSegundos = tempoAtivoSegundos;
    }


    /**
     * Gets the tempoCicloImprodutivoSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @return tempoCicloImprodutivoSegundos
     */
    public java.math.BigDecimal getTempoCicloImprodutivoSegundos() {
        return tempoCicloImprodutivoSegundos;
    }


    /**
     * Sets the tempoCicloImprodutivoSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @param tempoCicloImprodutivoSegundos
     */
    public void setTempoCicloImprodutivoSegundos(java.math.BigDecimal tempoCicloImprodutivoSegundos) {
        this.tempoCicloImprodutivoSegundos = tempoCicloImprodutivoSegundos;
    }


    /**
     * Gets the tempoCicloProdutivoSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @return tempoCicloProdutivoSegundos
     */
    public java.math.BigDecimal getTempoCicloProdutivoSegundos() {
        return tempoCicloProdutivoSegundos;
    }


    /**
     * Sets the tempoCicloProdutivoSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @param tempoCicloProdutivoSegundos
     */
    public void setTempoCicloProdutivoSegundos(java.math.BigDecimal tempoCicloProdutivoSegundos) {
        this.tempoCicloProdutivoSegundos = tempoCicloProdutivoSegundos;
    }


    /**
     * Gets the tempoCorrecaoCTT value for this MaquinaTotalInjetDTO.
     * 
     * @return tempoCorrecaoCTT
     */
    public java.math.BigDecimal getTempoCorrecaoCTT() {
        return tempoCorrecaoCTT;
    }


    /**
     * Sets the tempoCorrecaoCTT value for this MaquinaTotalInjetDTO.
     * 
     * @param tempoCorrecaoCTT
     */
    public void setTempoCorrecaoCTT(java.math.BigDecimal tempoCorrecaoCTT) {
        this.tempoCorrecaoCTT = tempoCorrecaoCTT;
    }


    /**
     * Gets the tempoDisponiveisSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @return tempoDisponiveisSegundos
     */
    public java.math.BigDecimal getTempoDisponiveisSegundos() {
        return tempoDisponiveisSegundos;
    }


    /**
     * Sets the tempoDisponiveisSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @param tempoDisponiveisSegundos
     */
    public void setTempoDisponiveisSegundos(java.math.BigDecimal tempoDisponiveisSegundos) {
        this.tempoDisponiveisSegundos = tempoDisponiveisSegundos;
    }


    /**
     * Gets the tempoParadaEmAbertoSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @return tempoParadaEmAbertoSegundos
     */
    public java.math.BigDecimal getTempoParadaEmAbertoSegundos() {
        return tempoParadaEmAbertoSegundos;
    }


    /**
     * Sets the tempoParadaEmAbertoSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @param tempoParadaEmAbertoSegundos
     */
    public void setTempoParadaEmAbertoSegundos(java.math.BigDecimal tempoParadaEmAbertoSegundos) {
        this.tempoParadaEmAbertoSegundos = tempoParadaEmAbertoSegundos;
    }


    /**
     * Gets the tempoParadaSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @return tempoParadaSegundos
     */
    public java.math.BigDecimal getTempoParadaSegundos() {
        return tempoParadaSegundos;
    }


    /**
     * Sets the tempoParadaSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @param tempoParadaSegundos
     */
    public void setTempoParadaSegundos(java.math.BigDecimal tempoParadaSegundos) {
        this.tempoParadaSegundos = tempoParadaSegundos;
    }


    /**
     * Gets the tempoParadaSemPesoSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @return tempoParadaSemPesoSegundos
     */
    public java.math.BigDecimal getTempoParadaSemPesoSegundos() {
        return tempoParadaSemPesoSegundos;
    }


    /**
     * Sets the tempoParadaSemPesoSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @param tempoParadaSemPesoSegundos
     */
    public void setTempoParadaSemPesoSegundos(java.math.BigDecimal tempoParadaSemPesoSegundos) {
        this.tempoParadaSemPesoSegundos = tempoParadaSemPesoSegundos;
    }


    /**
     * Gets the tempoParadasMTTR value for this MaquinaTotalInjetDTO.
     * 
     * @return tempoParadasMTTR
     */
    public java.math.BigDecimal getTempoParadasMTTR() {
        return tempoParadasMTTR;
    }


    /**
     * Sets the tempoParadasMTTR value for this MaquinaTotalInjetDTO.
     * 
     * @param tempoParadasMTTR
     */
    public void setTempoParadasMTTR(java.math.BigDecimal tempoParadasMTTR) {
        this.tempoParadasMTTR = tempoParadasMTTR;
    }


    /**
     * Gets the tempoPerdaCavidadeSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @return tempoPerdaCavidadeSegundos
     */
    public java.math.BigDecimal getTempoPerdaCavidadeSegundos() {
        return tempoPerdaCavidadeSegundos;
    }


    /**
     * Sets the tempoPerdaCavidadeSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @param tempoPerdaCavidadeSegundos
     */
    public void setTempoPerdaCavidadeSegundos(java.math.BigDecimal tempoPerdaCavidadeSegundos) {
        this.tempoPerdaCavidadeSegundos = tempoPerdaCavidadeSegundos;
    }


    /**
     * Gets the tempoPerdaCicloSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @return tempoPerdaCicloSegundos
     */
    public java.math.BigDecimal getTempoPerdaCicloSegundos() {
        return tempoPerdaCicloSegundos;
    }


    /**
     * Sets the tempoPerdaCicloSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @param tempoPerdaCicloSegundos
     */
    public void setTempoPerdaCicloSegundos(java.math.BigDecimal tempoPerdaCicloSegundos) {
        this.tempoPerdaCicloSegundos = tempoPerdaCicloSegundos;
    }


    /**
     * Gets the tempoPrevistoCicloSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @return tempoPrevistoCicloSegundos
     */
    public java.math.BigDecimal getTempoPrevistoCicloSegundos() {
        return tempoPrevistoCicloSegundos;
    }


    /**
     * Sets the tempoPrevistoCicloSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @param tempoPrevistoCicloSegundos
     */
    public void setTempoPrevistoCicloSegundos(java.math.BigDecimal tempoPrevistoCicloSegundos) {
        this.tempoPrevistoCicloSegundos = tempoPrevistoCicloSegundos;
    }


    /**
     * Gets the tempoProdutivasSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @return tempoProdutivasSegundos
     */
    public java.math.BigDecimal getTempoProdutivasSegundos() {
        return tempoProdutivasSegundos;
    }


    /**
     * Sets the tempoProdutivasSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @param tempoProdutivasSegundos
     */
    public void setTempoProdutivasSegundos(java.math.BigDecimal tempoProdutivasSegundos) {
        this.tempoProdutivasSegundos = tempoProdutivasSegundos;
    }


    /**
     * Gets the tempoRefugoSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @return tempoRefugoSegundos
     */
    public java.math.BigDecimal getTempoRefugoSegundos() {
        return tempoRefugoSegundos;
    }


    /**
     * Sets the tempoRefugoSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @param tempoRefugoSegundos
     */
    public void setTempoRefugoSegundos(java.math.BigDecimal tempoRefugoSegundos) {
        this.tempoRefugoSegundos = tempoRefugoSegundos;
    }


    /**
     * Gets the tempoRitmoSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @return tempoRitmoSegundos
     */
    public java.math.BigDecimal getTempoRitmoSegundos() {
        return tempoRitmoSegundos;
    }


    /**
     * Sets the tempoRitmoSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @param tempoRitmoSegundos
     */
    public void setTempoRitmoSegundos(java.math.BigDecimal tempoRitmoSegundos) {
        this.tempoRitmoSegundos = tempoRitmoSegundos;
    }


    /**
     * Gets the tempoTrabalhadoSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @return tempoTrabalhadoSegundos
     */
    public java.math.BigDecimal getTempoTrabalhadoSegundos() {
        return tempoTrabalhadoSegundos;
    }


    /**
     * Sets the tempoTrabalhadoSegundos value for this MaquinaTotalInjetDTO.
     * 
     * @param tempoTrabalhadoSegundos
     */
    public void setTempoTrabalhadoSegundos(java.math.BigDecimal tempoTrabalhadoSegundos) {
        this.tempoTrabalhadoSegundos = tempoTrabalhadoSegundos;
    }


    /**
     * Gets the ultimoCiclo value for this MaquinaTotalInjetDTO.
     * 
     * @return ultimoCiclo
     */
    public java.math.BigDecimal getUltimoCiclo() {
        return ultimoCiclo;
    }


    /**
     * Sets the ultimoCiclo value for this MaquinaTotalInjetDTO.
     * 
     * @param ultimoCiclo
     */
    public void setUltimoCiclo(java.math.BigDecimal ultimoCiclo) {
        this.ultimoCiclo = ultimoCiclo;
    }


    /**
     * Gets the utilizacao value for this MaquinaTotalInjetDTO.
     * 
     * @return utilizacao
     */
    public java.lang.Float getUtilizacao() {
        return utilizacao;
    }


    /**
     * Sets the utilizacao value for this MaquinaTotalInjetDTO.
     * 
     * @param utilizacao
     */
    public void setUtilizacao(java.lang.Float utilizacao) {
        this.utilizacao = utilizacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MaquinaTotalInjetDTO)) return false;
        MaquinaTotalInjetDTO other = (MaquinaTotalInjetDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cicloMedio==null && other.getCicloMedio()==null) || 
             (this.cicloMedio!=null &&
              this.cicloMedio.equals(other.getCicloMedio()))) &&
            ((this.cicloPadrao==null && other.getCicloPadrao()==null) || 
             (this.cicloPadrao!=null &&
              this.cicloPadrao.equals(other.getCicloPadrao()))) &&
            ((this.eficienciaCiclo==null && other.getEficienciaCiclo()==null) || 
             (this.eficienciaCiclo!=null &&
              this.eficienciaCiclo.equals(other.getEficienciaCiclo()))) &&
            ((this.eficienciaCicloDTOs==null && other.getEficienciaCicloDTOs()==null) || 
             (this.eficienciaCicloDTOs!=null &&
              java.util.Arrays.equals(this.eficienciaCicloDTOs, other.getEficienciaCicloDTOs()))) &&
            ((this.eficienciaCicloPonderada==null && other.getEficienciaCicloPonderada()==null) || 
             (this.eficienciaCicloPonderada!=null &&
              this.eficienciaCicloPonderada.equals(other.getEficienciaCicloPonderada()))) &&
            ((this.eficienciaRealizacao==null && other.getEficienciaRealizacao()==null) || 
             (this.eficienciaRealizacao!=null &&
              this.eficienciaRealizacao.equals(other.getEficienciaRealizacao()))) &&
            ((this.eficienciaUltimoCiclo==null && other.getEficienciaUltimoCiclo()==null) || 
             (this.eficienciaUltimoCiclo!=null &&
              this.eficienciaUltimoCiclo.equals(other.getEficienciaUltimoCiclo()))) &&
            ((this.indiceCavidadeAtiva==null && other.getIndiceCavidadeAtiva()==null) || 
             (this.indiceCavidadeAtiva!=null &&
              this.indiceCavidadeAtiva.equals(other.getIndiceCavidadeAtiva()))) &&
            ((this.indiceParada==null && other.getIndiceParada()==null) || 
             (this.indiceParada!=null &&
              this.indiceParada.equals(other.getIndiceParada()))) &&
            ((this.indicePerda==null && other.getIndicePerda()==null) || 
             (this.indicePerda!=null &&
              this.indicePerda.equals(other.getIndicePerda()))) &&
            ((this.indiceRefugo==null && other.getIndiceRefugo()==null) || 
             (this.indiceRefugo!=null &&
              this.indiceRefugo.equals(other.getIndiceRefugo()))) &&
            ((this.pci==null && other.getPci()==null) || 
             (this.pci!=null &&
              this.pci.equals(other.getPci()))) &&
            ((this.perdaCavidadeCusto==null && other.getPerdaCavidadeCusto()==null) || 
             (this.perdaCavidadeCusto!=null &&
              this.perdaCavidadeCusto.equals(other.getPerdaCavidadeCusto()))) &&
            ((this.perdaCavidadeKg==null && other.getPerdaCavidadeKg()==null) || 
             (this.perdaCavidadeKg!=null &&
              this.perdaCavidadeKg.equals(other.getPerdaCavidadeKg()))) &&
            ((this.perdaCavidadeUnidade==null && other.getPerdaCavidadeUnidade()==null) || 
             (this.perdaCavidadeUnidade!=null &&
              this.perdaCavidadeUnidade.equals(other.getPerdaCavidadeUnidade()))) &&
            ((this.perdaCicloCusto==null && other.getPerdaCicloCusto()==null) || 
             (this.perdaCicloCusto!=null &&
              this.perdaCicloCusto.equals(other.getPerdaCicloCusto()))) &&
            ((this.perdaCicloUnidade==null && other.getPerdaCicloUnidade()==null) || 
             (this.perdaCicloUnidade!=null &&
              this.perdaCicloUnidade.equals(other.getPerdaCicloUnidade()))) &&
            ((this.perdaParadaCusto==null && other.getPerdaParadaCusto()==null) || 
             (this.perdaParadaCusto!=null &&
              this.perdaParadaCusto.equals(other.getPerdaParadaCusto()))) &&
            ((this.perdaParadaSemPesoCusto==null && other.getPerdaParadaSemPesoCusto()==null) || 
             (this.perdaParadaSemPesoCusto!=null &&
              this.perdaParadaSemPesoCusto.equals(other.getPerdaParadaSemPesoCusto()))) &&
            ((this.perdaParadasKq==null && other.getPerdaParadasKq()==null) || 
             (this.perdaParadasKq!=null &&
              this.perdaParadasKq.equals(other.getPerdaParadasKq()))) &&
            ((this.perdaParadasSemPesoKg==null && other.getPerdaParadasSemPesoKg()==null) || 
             (this.perdaParadasSemPesoKg!=null &&
              this.perdaParadasSemPesoKg.equals(other.getPerdaParadasSemPesoKg()))) &&
            ((this.perdaParadasSemPesoUnidade==null && other.getPerdaParadasSemPesoUnidade()==null) || 
             (this.perdaParadasSemPesoUnidade!=null &&
              this.perdaParadasSemPesoUnidade.equals(other.getPerdaParadasSemPesoUnidade()))) &&
            ((this.perdaParadasUnidade==null && other.getPerdaParadasUnidade()==null) || 
             (this.perdaParadasUnidade!=null &&
              this.perdaParadasUnidade.equals(other.getPerdaParadasUnidade()))) &&
            ((this.producaoBrutaKg==null && other.getProducaoBrutaKg()==null) || 
             (this.producaoBrutaKg!=null &&
              this.producaoBrutaKg.equals(other.getProducaoBrutaKg()))) &&
            ((this.producaoBrutaUnidade==null && other.getProducaoBrutaUnidade()==null) || 
             (this.producaoBrutaUnidade!=null &&
              this.producaoBrutaUnidade.equals(other.getProducaoBrutaUnidade()))) &&
            ((this.producaoLiquidaKg==null && other.getProducaoLiquidaKg()==null) || 
             (this.producaoLiquidaKg!=null &&
              this.producaoLiquidaKg.equals(other.getProducaoLiquidaKg()))) &&
            ((this.producaoLiquidaUnidade==null && other.getProducaoLiquidaUnidade()==null) || 
             (this.producaoLiquidaUnidade!=null &&
              this.producaoLiquidaUnidade.equals(other.getProducaoLiquidaUnidade()))) &&
            ((this.producaoPrevistaHoraria==null && other.getProducaoPrevistaHoraria()==null) || 
             (this.producaoPrevistaHoraria!=null &&
              this.producaoPrevistaHoraria.equals(other.getProducaoPrevistaHoraria()))) &&
            ((this.producaoPrevistaKg==null && other.getProducaoPrevistaKg()==null) || 
             (this.producaoPrevistaKg!=null &&
              this.producaoPrevistaKg.equals(other.getProducaoPrevistaKg()))) &&
            ((this.producaoPrevistaUnidade==null && other.getProducaoPrevistaUnidade()==null) || 
             (this.producaoPrevistaUnidade!=null &&
              this.producaoPrevistaUnidade.equals(other.getProducaoPrevistaUnidade()))) &&
            ((this.producaoRefugadaCusto==null && other.getProducaoRefugadaCusto()==null) || 
             (this.producaoRefugadaCusto!=null &&
              this.producaoRefugadaCusto.equals(other.getProducaoRefugadaCusto()))) &&
            ((this.producaoRefugadaKg==null && other.getProducaoRefugadaKg()==null) || 
             (this.producaoRefugadaKg!=null &&
              this.producaoRefugadaKg.equals(other.getProducaoRefugadaKg()))) &&
            ((this.producaoRefugadaUnidade==null && other.getProducaoRefugadaUnidade()==null) || 
             (this.producaoRefugadaUnidade!=null &&
              this.producaoRefugadaUnidade.equals(other.getProducaoRefugadaUnidade()))) &&
            ((this.qtCicloPadraoDiferentes==null && other.getQtCicloPadraoDiferentes()==null) || 
             (this.qtCicloPadraoDiferentes!=null &&
              this.qtCicloPadraoDiferentes.equals(other.getQtCicloPadraoDiferentes()))) &&
            ((this.qtCiclosPrevistos==null && other.getQtCiclosPrevistos()==null) || 
              (this.qtCiclosPrevistos!=null &&
               this.qtCiclosPrevistos.equals(other.getQtCiclosPrevistos()))) &&              
            ((this.qtInjNormal==null && other.getQtInjNormal()==null) || 
             (this.qtInjNormal!=null &&
              this.qtInjNormal.equals(other.getQtInjNormal()))) &&
            ((this.qtOcorrenciaParadasMTBFMTTR==null && other.getQtOcorrenciaParadasMTBFMTTR()==null) || 
             (this.qtOcorrenciaParadasMTBFMTTR!=null &&
              this.qtOcorrenciaParadasMTBFMTTR.equals(other.getQtOcorrenciaParadasMTBFMTTR()))) &&
            ((this.tempoAtivoSegundos==null && other.getTempoAtivoSegundos()==null) || 
             (this.tempoAtivoSegundos!=null &&
              this.tempoAtivoSegundos.equals(other.getTempoAtivoSegundos()))) &&
            ((this.tempoCicloImprodutivoSegundos==null && other.getTempoCicloImprodutivoSegundos()==null) || 
             (this.tempoCicloImprodutivoSegundos!=null &&
              this.tempoCicloImprodutivoSegundos.equals(other.getTempoCicloImprodutivoSegundos()))) &&
            ((this.tempoCicloProdutivoSegundos==null && other.getTempoCicloProdutivoSegundos()==null) || 
             (this.tempoCicloProdutivoSegundos!=null &&
              this.tempoCicloProdutivoSegundos.equals(other.getTempoCicloProdutivoSegundos()))) &&
            ((this.tempoCorrecaoCTT==null && other.getTempoCorrecaoCTT()==null) || 
             (this.tempoCorrecaoCTT!=null &&
              this.tempoCorrecaoCTT.equals(other.getTempoCorrecaoCTT()))) &&
            ((this.tempoDisponiveisSegundos==null && other.getTempoDisponiveisSegundos()==null) || 
             (this.tempoDisponiveisSegundos!=null &&
              this.tempoDisponiveisSegundos.equals(other.getTempoDisponiveisSegundos()))) &&
            ((this.tempoParadaEmAbertoSegundos==null && other.getTempoParadaEmAbertoSegundos()==null) || 
             (this.tempoParadaEmAbertoSegundos!=null &&
              this.tempoParadaEmAbertoSegundos.equals(other.getTempoParadaEmAbertoSegundos()))) &&
            ((this.tempoParadaSegundos==null && other.getTempoParadaSegundos()==null) || 
             (this.tempoParadaSegundos!=null &&
              this.tempoParadaSegundos.equals(other.getTempoParadaSegundos()))) &&
            ((this.tempoParadaSemPesoSegundos==null && other.getTempoParadaSemPesoSegundos()==null) || 
             (this.tempoParadaSemPesoSegundos!=null &&
              this.tempoParadaSemPesoSegundos.equals(other.getTempoParadaSemPesoSegundos()))) &&
            ((this.tempoParadasMTTR==null && other.getTempoParadasMTTR()==null) || 
             (this.tempoParadasMTTR!=null &&
              this.tempoParadasMTTR.equals(other.getTempoParadasMTTR()))) &&
            ((this.tempoPerdaCavidadeSegundos==null && other.getTempoPerdaCavidadeSegundos()==null) || 
             (this.tempoPerdaCavidadeSegundos!=null &&
              this.tempoPerdaCavidadeSegundos.equals(other.getTempoPerdaCavidadeSegundos()))) &&
            ((this.tempoPerdaCicloSegundos==null && other.getTempoPerdaCicloSegundos()==null) || 
             (this.tempoPerdaCicloSegundos!=null &&
              this.tempoPerdaCicloSegundos.equals(other.getTempoPerdaCicloSegundos()))) &&
            ((this.tempoPrevistoCicloSegundos==null && other.getTempoPrevistoCicloSegundos()==null) || 
             (this.tempoPrevistoCicloSegundos!=null &&
              this.tempoPrevistoCicloSegundos.equals(other.getTempoPrevistoCicloSegundos()))) &&
            ((this.tempoProdutivasSegundos==null && other.getTempoProdutivasSegundos()==null) || 
             (this.tempoProdutivasSegundos!=null &&
              this.tempoProdutivasSegundos.equals(other.getTempoProdutivasSegundos()))) &&
            ((this.tempoRefugoSegundos==null && other.getTempoRefugoSegundos()==null) || 
             (this.tempoRefugoSegundos!=null &&
              this.tempoRefugoSegundos.equals(other.getTempoRefugoSegundos()))) &&
            ((this.tempoRitmoSegundos==null && other.getTempoRitmoSegundos()==null) || 
             (this.tempoRitmoSegundos!=null &&
              this.tempoRitmoSegundos.equals(other.getTempoRitmoSegundos()))) &&
            ((this.tempoTrabalhadoSegundos==null && other.getTempoTrabalhadoSegundos()==null) || 
             (this.tempoTrabalhadoSegundos!=null &&
              this.tempoTrabalhadoSegundos.equals(other.getTempoTrabalhadoSegundos()))) &&
            ((this.ultimoCiclo==null && other.getUltimoCiclo()==null) || 
             (this.ultimoCiclo!=null &&
              this.ultimoCiclo.equals(other.getUltimoCiclo()))) &&
            ((this.utilizacao==null && other.getUtilizacao()==null) || 
             (this.utilizacao!=null &&
              this.utilizacao.equals(other.getUtilizacao())));
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
        if (getCicloMedio() != null) {
            _hashCode += getCicloMedio().hashCode();
        }
        if (getCicloPadrao() != null) {
            _hashCode += getCicloPadrao().hashCode();
        }
        if (getEficienciaCiclo() != null) {
            _hashCode += getEficienciaCiclo().hashCode();
        }
        if (getEficienciaCicloDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEficienciaCicloDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEficienciaCicloDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEficienciaCicloPonderada() != null) {
            _hashCode += getEficienciaCicloPonderada().hashCode();
        }
        if (getEficienciaRealizacao() != null) {
            _hashCode += getEficienciaRealizacao().hashCode();
        }
        if (getEficienciaUltimoCiclo() != null) {
            _hashCode += getEficienciaUltimoCiclo().hashCode();
        }
        if (getIndiceCavidadeAtiva() != null) {
            _hashCode += getIndiceCavidadeAtiva().hashCode();
        }
        if (getIndiceParada() != null) {
            _hashCode += getIndiceParada().hashCode();
        }
        if (getIndicePerda() != null) {
            _hashCode += getIndicePerda().hashCode();
        }
        if (getIndiceRefugo() != null) {
            _hashCode += getIndiceRefugo().hashCode();
        }
        if (getPci() != null) {
            _hashCode += getPci().hashCode();
        }
        if (getPerdaCavidadeCusto() != null) {
            _hashCode += getPerdaCavidadeCusto().hashCode();
        }
        if (getPerdaCavidadeKg() != null) {
            _hashCode += getPerdaCavidadeKg().hashCode();
        }
        if (getPerdaCavidadeUnidade() != null) {
            _hashCode += getPerdaCavidadeUnidade().hashCode();
        }
        if (getPerdaCicloCusto() != null) {
            _hashCode += getPerdaCicloCusto().hashCode();
        }
        if (getPerdaCicloUnidade() != null) {
            _hashCode += getPerdaCicloUnidade().hashCode();
        }
        if (getPerdaParadaCusto() != null) {
            _hashCode += getPerdaParadaCusto().hashCode();
        }
        if (getPerdaParadaSemPesoCusto() != null) {
            _hashCode += getPerdaParadaSemPesoCusto().hashCode();
        }
        if (getPerdaParadasKq() != null) {
            _hashCode += getPerdaParadasKq().hashCode();
        }
        if (getPerdaParadasSemPesoKg() != null) {
            _hashCode += getPerdaParadasSemPesoKg().hashCode();
        }
        if (getPerdaParadasSemPesoUnidade() != null) {
            _hashCode += getPerdaParadasSemPesoUnidade().hashCode();
        }
        if (getPerdaParadasUnidade() != null) {
            _hashCode += getPerdaParadasUnidade().hashCode();
        }
        if (getProducaoBrutaKg() != null) {
            _hashCode += getProducaoBrutaKg().hashCode();
        }
        if (getProducaoBrutaUnidade() != null) {
            _hashCode += getProducaoBrutaUnidade().hashCode();
        }
        if (getProducaoLiquidaKg() != null) {
            _hashCode += getProducaoLiquidaKg().hashCode();
        }
        if (getProducaoLiquidaUnidade() != null) {
            _hashCode += getProducaoLiquidaUnidade().hashCode();
        }
        if (getProducaoPrevistaHoraria() != null) {
            _hashCode += getProducaoPrevistaHoraria().hashCode();
        }
        if (getProducaoPrevistaKg() != null) {
            _hashCode += getProducaoPrevistaKg().hashCode();
        }
        if (getProducaoPrevistaUnidade() != null) {
            _hashCode += getProducaoPrevistaUnidade().hashCode();
        }
        if (getProducaoRefugadaCusto() != null) {
            _hashCode += getProducaoRefugadaCusto().hashCode();
        }
        if (getProducaoRefugadaKg() != null) {
            _hashCode += getProducaoRefugadaKg().hashCode();
        }
        if (getProducaoRefugadaUnidade() != null) {
            _hashCode += getProducaoRefugadaUnidade().hashCode();
        }
        if (getQtCicloPadraoDiferentes() != null) {
            _hashCode += getQtCicloPadraoDiferentes().hashCode();
        }
        if (getQtCiclosPrevistos() != null) {
            _hashCode += getQtCiclosPrevistos().hashCode();
        }        
        if (getQtInjNormal() != null) {
            _hashCode += getQtInjNormal().hashCode();
        }
        if (getQtOcorrenciaParadasMTBFMTTR() != null) {
            _hashCode += getQtOcorrenciaParadasMTBFMTTR().hashCode();
        }
        if (getTempoAtivoSegundos() != null) {
            _hashCode += getTempoAtivoSegundos().hashCode();
        }
        if (getTempoCicloImprodutivoSegundos() != null) {
            _hashCode += getTempoCicloImprodutivoSegundos().hashCode();
        }
        if (getTempoCicloProdutivoSegundos() != null) {
            _hashCode += getTempoCicloProdutivoSegundos().hashCode();
        }
        if (getTempoCorrecaoCTT() != null) {
            _hashCode += getTempoCorrecaoCTT().hashCode();
        }
        if (getTempoDisponiveisSegundos() != null) {
            _hashCode += getTempoDisponiveisSegundos().hashCode();
        }
        if (getTempoParadaEmAbertoSegundos() != null) {
            _hashCode += getTempoParadaEmAbertoSegundos().hashCode();
        }
        if (getTempoParadaSegundos() != null) {
            _hashCode += getTempoParadaSegundos().hashCode();
        }
        if (getTempoParadaSemPesoSegundos() != null) {
            _hashCode += getTempoParadaSemPesoSegundos().hashCode();
        }
        if (getTempoParadasMTTR() != null) {
            _hashCode += getTempoParadasMTTR().hashCode();
        }
        if (getTempoPerdaCavidadeSegundos() != null) {
            _hashCode += getTempoPerdaCavidadeSegundos().hashCode();
        }
        if (getTempoPerdaCicloSegundos() != null) {
            _hashCode += getTempoPerdaCicloSegundos().hashCode();
        }
        if (getTempoPrevistoCicloSegundos() != null) {
            _hashCode += getTempoPrevistoCicloSegundos().hashCode();
        }
        if (getTempoProdutivasSegundos() != null) {
            _hashCode += getTempoProdutivasSegundos().hashCode();
        }
        if (getTempoRefugoSegundos() != null) {
            _hashCode += getTempoRefugoSegundos().hashCode();
        }
        if (getTempoRitmoSegundos() != null) {
            _hashCode += getTempoRitmoSegundos().hashCode();
        }
        if (getTempoTrabalhadoSegundos() != null) {
            _hashCode += getTempoTrabalhadoSegundos().hashCode();
        }
        if (getUltimoCiclo() != null) {
            _hashCode += getUltimoCiclo().hashCode();
        }
        if (getUtilizacao() != null) {
            _hashCode += getUtilizacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MaquinaTotalInjetDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "maquinaTotalInjetDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("eficienciaCiclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficienciaCiclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficienciaCicloDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficienciaCicloDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "eficienciaCicloInjetDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficienciaCicloPonderada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficienciaCicloPonderada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficienciaRealizacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficienciaRealizacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficienciaUltimoCiclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficienciaUltimoCiclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceCavidadeAtiva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceCavidadeAtiva"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicePerda");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indicePerda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pci");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pci"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdaCavidadeCusto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdaCavidadeCusto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdaCavidadeKg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdaCavidadeKg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdaCavidadeUnidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdaCavidadeUnidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdaCicloCusto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdaCicloCusto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdaCicloUnidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdaCicloUnidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdaParadaCusto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdaParadaCusto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdaParadaSemPesoCusto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdaParadaSemPesoCusto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdaParadasKq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdaParadasKq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdaParadasSemPesoKg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdaParadasSemPesoKg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdaParadasSemPesoUnidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdaParadasSemPesoUnidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdaParadasUnidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdaParadasUnidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoBrutaKg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoBrutaKg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoBrutaUnidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoBrutaUnidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoLiquidaKg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoLiquidaKg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoLiquidaUnidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoLiquidaUnidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoPrevistaHoraria");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoPrevistaHoraria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoPrevistaKg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoPrevistaKg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoPrevistaUnidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoPrevistaUnidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoRefugadaCusto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoRefugadaCusto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoRefugadaKg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoRefugadaKg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoRefugadaUnidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoRefugadaUnidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtCicloPadraoDiferentes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtCicloPadraoDiferentes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtCiclosPrevistos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtCiclosPrevistos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);        
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtInjNormal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtInjNormal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtOcorrenciaParadasMTBFMTTR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtOcorrenciaParadasMTBFMTTR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoAtivoSegundos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoAtivoSegundos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoCicloImprodutivoSegundos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoCicloImprodutivoSegundos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoCicloProdutivoSegundos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoCicloProdutivoSegundos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoCorrecaoCTT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoCorrecaoCTT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoDisponiveisSegundos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoDisponiveisSegundos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaEmAbertoSegundos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaEmAbertoSegundos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaSegundos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaSegundos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaSemPesoSegundos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaSemPesoSegundos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadasMTTR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadasMTTR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoPerdaCavidadeSegundos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoPerdaCavidadeSegundos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoPerdaCicloSegundos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoPerdaCicloSegundos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoPrevistoCicloSegundos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoPrevistoCicloSegundos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoProdutivasSegundos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoProdutivasSegundos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoRefugoSegundos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoRefugoSegundos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoRitmoSegundos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoRitmoSegundos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoTrabalhadoSegundos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoTrabalhadoSegundos"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("utilizacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "utilizacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
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
