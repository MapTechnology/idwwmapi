/**
 * MaquinaInjetDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MaquinaInjetDTO  implements java.io.Serializable {
    private idw.idwws.AlertaInjetDTO[] alertas;

    private java.lang.String cdLingua;

    private java.lang.String cdMaquina;

    private idw.idwws.CicloInjetDTO[] ciclos;

    private int corFrente;

    private int corFundo;

    private idw.idwws.DadosParaECPonderadaInjetDTO[] dadosECPonderada;

    private java.lang.String dsMaquina;

    private java.util.Calendar dthrFTurno;

    private java.util.Calendar dthrITurno;

    private java.math.BigDecimal ec_padrao;

    private java.math.BigDecimal eo_padrao;

    private idw.idwws.Ijgrpinj[] gruposQueMaquinaPertence;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbmol ijtbmolAtualNaMaquina;

    private java.math.BigDecimal ir_padrao;

    private idw.idwws.MaquinaPlanejamentoInjetDTO maquinaPlanejamentoDTO;

    private idw.idwws.MaquinaTotalInjetDTO maquinaTotalDTO;

    private java.lang.String nrop;

    private idw.idwws.Ijlogope[] operadoresAcumulado;

    private idw.idwws.Ijlogope[] operadoresTurno;

    private idw.idwws.ParadaInjetDTO paradaAtualUltimaParada;

    private idw.idwws.ParadaInjetDTO[] paradas;

    private idw.idwws.ProdutoInjetDTO[] produtos;

    private idw.idwws.RefugoInjetDTO[] refugos;

    private idw.idwws.TrocaOPInjetDTO[] trocasDeOP;

    public MaquinaInjetDTO() {
    }

    public MaquinaInjetDTO(
           idw.idwws.AlertaInjetDTO[] alertas,
           java.lang.String cdLingua,
           java.lang.String cdMaquina,
           idw.idwws.CicloInjetDTO[] ciclos,
           int corFrente,
           int corFundo,
           idw.idwws.DadosParaECPonderadaInjetDTO[] dadosECPonderada,
           java.lang.String dsMaquina,
           java.util.Calendar dthrFTurno,
           java.util.Calendar dthrITurno,
           java.math.BigDecimal ec_padrao,
           java.math.BigDecimal eo_padrao,
           idw.idwws.Ijgrpinj[] gruposQueMaquinaPertence,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbmol ijtbmolAtualNaMaquina,
           java.math.BigDecimal ir_padrao,
           idw.idwws.MaquinaPlanejamentoInjetDTO maquinaPlanejamentoDTO,
           idw.idwws.MaquinaTotalInjetDTO maquinaTotalDTO,
           java.lang.String nrop,
           idw.idwws.Ijlogope[] operadoresAcumulado,
           idw.idwws.Ijlogope[] operadoresTurno,
           idw.idwws.ParadaInjetDTO paradaAtualUltimaParada,
           idw.idwws.ParadaInjetDTO[] paradas,
           idw.idwws.ProdutoInjetDTO[] produtos,
           idw.idwws.RefugoInjetDTO[] refugos,
           idw.idwws.TrocaOPInjetDTO[] trocasDeOP) {
           this.alertas = alertas;
           this.cdLingua = cdLingua;
           this.cdMaquina = cdMaquina;
           this.ciclos = ciclos;
           this.corFrente = corFrente;
           this.corFundo = corFundo;
           this.dadosECPonderada = dadosECPonderada;
           this.dsMaquina = dsMaquina;
           this.dthrFTurno = dthrFTurno;
           this.dthrITurno = dthrITurno;
           this.ec_padrao = ec_padrao;
           this.eo_padrao = eo_padrao;
           this.gruposQueMaquinaPertence = gruposQueMaquinaPertence;
           this.ijtbinj = ijtbinj;
           this.ijtbmolAtualNaMaquina = ijtbmolAtualNaMaquina;
           this.ir_padrao = ir_padrao;
           this.maquinaPlanejamentoDTO = maquinaPlanejamentoDTO;
           this.maquinaTotalDTO = maquinaTotalDTO;
           this.nrop = nrop;
           this.operadoresAcumulado = operadoresAcumulado;
           this.operadoresTurno = operadoresTurno;
           this.paradaAtualUltimaParada = paradaAtualUltimaParada;
           this.paradas = paradas;
           this.produtos = produtos;
           this.refugos = refugos;
           this.trocasDeOP = trocasDeOP;
    }


    /**
     * Gets the alertas value for this MaquinaInjetDTO.
     * 
     * @return alertas
     */
    public idw.idwws.AlertaInjetDTO[] getAlertas() {
        return alertas;
    }


    /**
     * Sets the alertas value for this MaquinaInjetDTO.
     * 
     * @param alertas
     */
    public void setAlertas(idw.idwws.AlertaInjetDTO[] alertas) {
        this.alertas = alertas;
    }

    public idw.idwws.AlertaInjetDTO getAlertas(int i) {
        return this.alertas[i];
    }

    public void setAlertas(int i, idw.idwws.AlertaInjetDTO _value) {
        this.alertas[i] = _value;
    }


    /**
     * Gets the cdLingua value for this MaquinaInjetDTO.
     * 
     * @return cdLingua
     */
    public java.lang.String getCdLingua() {
        return cdLingua;
    }


    /**
     * Sets the cdLingua value for this MaquinaInjetDTO.
     * 
     * @param cdLingua
     */
    public void setCdLingua(java.lang.String cdLingua) {
        this.cdLingua = cdLingua;
    }


    /**
     * Gets the cdMaquina value for this MaquinaInjetDTO.
     * 
     * @return cdMaquina
     */
    public java.lang.String getCdMaquina() {
        return cdMaquina;
    }


    /**
     * Sets the cdMaquina value for this MaquinaInjetDTO.
     * 
     * @param cdMaquina
     */
    public void setCdMaquina(java.lang.String cdMaquina) {
        this.cdMaquina = cdMaquina;
    }


    /**
     * Gets the ciclos value for this MaquinaInjetDTO.
     * 
     * @return ciclos
     */
    public idw.idwws.CicloInjetDTO[] getCiclos() {
        return ciclos;
    }


    /**
     * Sets the ciclos value for this MaquinaInjetDTO.
     * 
     * @param ciclos
     */
    public void setCiclos(idw.idwws.CicloInjetDTO[] ciclos) {
        this.ciclos = ciclos;
    }

    public idw.idwws.CicloInjetDTO getCiclos(int i) {
        return this.ciclos[i];
    }

    public void setCiclos(int i, idw.idwws.CicloInjetDTO _value) {
        this.ciclos[i] = _value;
    }


    /**
     * Gets the corFrente value for this MaquinaInjetDTO.
     * 
     * @return corFrente
     */
    public int getCorFrente() {
        return corFrente;
    }


    /**
     * Sets the corFrente value for this MaquinaInjetDTO.
     * 
     * @param corFrente
     */
    public void setCorFrente(int corFrente) {
        this.corFrente = corFrente;
    }


    /**
     * Gets the corFundo value for this MaquinaInjetDTO.
     * 
     * @return corFundo
     */
    public int getCorFundo() {
        return corFundo;
    }


    /**
     * Sets the corFundo value for this MaquinaInjetDTO.
     * 
     * @param corFundo
     */
    public void setCorFundo(int corFundo) {
        this.corFundo = corFundo;
    }


    /**
     * Gets the dadosECPonderada value for this MaquinaInjetDTO.
     * 
     * @return dadosECPonderada
     */
    public idw.idwws.DadosParaECPonderadaInjetDTO[] getDadosECPonderada() {
        return dadosECPonderada;
    }


    /**
     * Sets the dadosECPonderada value for this MaquinaInjetDTO.
     * 
     * @param dadosECPonderada
     */
    public void setDadosECPonderada(idw.idwws.DadosParaECPonderadaInjetDTO[] dadosECPonderada) {
        this.dadosECPonderada = dadosECPonderada;
    }

    public idw.idwws.DadosParaECPonderadaInjetDTO getDadosECPonderada(int i) {
        return this.dadosECPonderada[i];
    }

    public void setDadosECPonderada(int i, idw.idwws.DadosParaECPonderadaInjetDTO _value) {
        this.dadosECPonderada[i] = _value;
    }


    /**
     * Gets the dsMaquina value for this MaquinaInjetDTO.
     * 
     * @return dsMaquina
     */
    public java.lang.String getDsMaquina() {
        return dsMaquina;
    }


    /**
     * Sets the dsMaquina value for this MaquinaInjetDTO.
     * 
     * @param dsMaquina
     */
    public void setDsMaquina(java.lang.String dsMaquina) {
        this.dsMaquina = dsMaquina;
    }


    /**
     * Gets the dthrFTurno value for this MaquinaInjetDTO.
     * 
     * @return dthrFTurno
     */
    public java.util.Calendar getDthrFTurno() {
        return dthrFTurno;
    }


    /**
     * Sets the dthrFTurno value for this MaquinaInjetDTO.
     * 
     * @param dthrFTurno
     */
    public void setDthrFTurno(java.util.Calendar dthrFTurno) {
        this.dthrFTurno = dthrFTurno;
    }


    /**
     * Gets the dthrITurno value for this MaquinaInjetDTO.
     * 
     * @return dthrITurno
     */
    public java.util.Calendar getDthrITurno() {
        return dthrITurno;
    }


    /**
     * Sets the dthrITurno value for this MaquinaInjetDTO.
     * 
     * @param dthrITurno
     */
    public void setDthrITurno(java.util.Calendar dthrITurno) {
        this.dthrITurno = dthrITurno;
    }


    /**
     * Gets the ec_padrao value for this MaquinaInjetDTO.
     * 
     * @return ec_padrao
     */
    public java.math.BigDecimal getEc_padrao() {
        return ec_padrao;
    }


    /**
     * Sets the ec_padrao value for this MaquinaInjetDTO.
     * 
     * @param ec_padrao
     */
    public void setEc_padrao(java.math.BigDecimal ec_padrao) {
        this.ec_padrao = ec_padrao;
    }


    /**
     * Gets the eo_padrao value for this MaquinaInjetDTO.
     * 
     * @return eo_padrao
     */
    public java.math.BigDecimal getEo_padrao() {
        return eo_padrao;
    }


    /**
     * Sets the eo_padrao value for this MaquinaInjetDTO.
     * 
     * @param eo_padrao
     */
    public void setEo_padrao(java.math.BigDecimal eo_padrao) {
        this.eo_padrao = eo_padrao;
    }


    /**
     * Gets the gruposQueMaquinaPertence value for this MaquinaInjetDTO.
     * 
     * @return gruposQueMaquinaPertence
     */
    public idw.idwws.Ijgrpinj[] getGruposQueMaquinaPertence() {
        return gruposQueMaquinaPertence;
    }


    /**
     * Sets the gruposQueMaquinaPertence value for this MaquinaInjetDTO.
     * 
     * @param gruposQueMaquinaPertence
     */
    public void setGruposQueMaquinaPertence(idw.idwws.Ijgrpinj[] gruposQueMaquinaPertence) {
        this.gruposQueMaquinaPertence = gruposQueMaquinaPertence;
    }

    public idw.idwws.Ijgrpinj getGruposQueMaquinaPertence(int i) {
        return this.gruposQueMaquinaPertence[i];
    }

    public void setGruposQueMaquinaPertence(int i, idw.idwws.Ijgrpinj _value) {
        this.gruposQueMaquinaPertence[i] = _value;
    }


    /**
     * Gets the ijtbinj value for this MaquinaInjetDTO.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this MaquinaInjetDTO.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbmolAtualNaMaquina value for this MaquinaInjetDTO.
     * 
     * @return ijtbmolAtualNaMaquina
     */
    public idw.idwws.Ijtbmol getIjtbmolAtualNaMaquina() {
        return ijtbmolAtualNaMaquina;
    }


    /**
     * Sets the ijtbmolAtualNaMaquina value for this MaquinaInjetDTO.
     * 
     * @param ijtbmolAtualNaMaquina
     */
    public void setIjtbmolAtualNaMaquina(idw.idwws.Ijtbmol ijtbmolAtualNaMaquina) {
        this.ijtbmolAtualNaMaquina = ijtbmolAtualNaMaquina;
    }


    /**
     * Gets the ir_padrao value for this MaquinaInjetDTO.
     * 
     * @return ir_padrao
     */
    public java.math.BigDecimal getIr_padrao() {
        return ir_padrao;
    }


    /**
     * Sets the ir_padrao value for this MaquinaInjetDTO.
     * 
     * @param ir_padrao
     */
    public void setIr_padrao(java.math.BigDecimal ir_padrao) {
        this.ir_padrao = ir_padrao;
    }


    /**
     * Gets the maquinaPlanejamentoDTO value for this MaquinaInjetDTO.
     * 
     * @return maquinaPlanejamentoDTO
     */
    public idw.idwws.MaquinaPlanejamentoInjetDTO getMaquinaPlanejamentoDTO() {
        return maquinaPlanejamentoDTO;
    }


    /**
     * Sets the maquinaPlanejamentoDTO value for this MaquinaInjetDTO.
     * 
     * @param maquinaPlanejamentoDTO
     */
    public void setMaquinaPlanejamentoDTO(idw.idwws.MaquinaPlanejamentoInjetDTO maquinaPlanejamentoDTO) {
        this.maquinaPlanejamentoDTO = maquinaPlanejamentoDTO;
    }


    /**
     * Gets the maquinaTotalDTO value for this MaquinaInjetDTO.
     * 
     * @return maquinaTotalDTO
     */
    public idw.idwws.MaquinaTotalInjetDTO getMaquinaTotalDTO() {
        return maquinaTotalDTO;
    }


    /**
     * Sets the maquinaTotalDTO value for this MaquinaInjetDTO.
     * 
     * @param maquinaTotalDTO
     */
    public void setMaquinaTotalDTO(idw.idwws.MaquinaTotalInjetDTO maquinaTotalDTO) {
        this.maquinaTotalDTO = maquinaTotalDTO;
    }


    /**
     * Gets the nrop value for this MaquinaInjetDTO.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this MaquinaInjetDTO.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }


    /**
     * Gets the operadoresAcumulado value for this MaquinaInjetDTO.
     * 
     * @return operadoresAcumulado
     */
    public idw.idwws.Ijlogope[] getOperadoresAcumulado() {
        return operadoresAcumulado;
    }


    /**
     * Sets the operadoresAcumulado value for this MaquinaInjetDTO.
     * 
     * @param operadoresAcumulado
     */
    public void setOperadoresAcumulado(idw.idwws.Ijlogope[] operadoresAcumulado) {
        this.operadoresAcumulado = operadoresAcumulado;
    }

    public idw.idwws.Ijlogope getOperadoresAcumulado(int i) {
        return this.operadoresAcumulado[i];
    }

    public void setOperadoresAcumulado(int i, idw.idwws.Ijlogope _value) {
        this.operadoresAcumulado[i] = _value;
    }


    /**
     * Gets the operadoresTurno value for this MaquinaInjetDTO.
     * 
     * @return operadoresTurno
     */
    public idw.idwws.Ijlogope[] getOperadoresTurno() {
        return operadoresTurno;
    }


    /**
     * Sets the operadoresTurno value for this MaquinaInjetDTO.
     * 
     * @param operadoresTurno
     */
    public void setOperadoresTurno(idw.idwws.Ijlogope[] operadoresTurno) {
        this.operadoresTurno = operadoresTurno;
    }

    public idw.idwws.Ijlogope getOperadoresTurno(int i) {
        return this.operadoresTurno[i];
    }

    public void setOperadoresTurno(int i, idw.idwws.Ijlogope _value) {
        this.operadoresTurno[i] = _value;
    }


    /**
     * Gets the paradaAtualUltimaParada value for this MaquinaInjetDTO.
     * 
     * @return paradaAtualUltimaParada
     */
    public idw.idwws.ParadaInjetDTO getParadaAtualUltimaParada() {
        return paradaAtualUltimaParada;
    }


    /**
     * Sets the paradaAtualUltimaParada value for this MaquinaInjetDTO.
     * 
     * @param paradaAtualUltimaParada
     */
    public void setParadaAtualUltimaParada(idw.idwws.ParadaInjetDTO paradaAtualUltimaParada) {
        this.paradaAtualUltimaParada = paradaAtualUltimaParada;
    }


    /**
     * Gets the paradas value for this MaquinaInjetDTO.
     * 
     * @return paradas
     */
    public idw.idwws.ParadaInjetDTO[] getParadas() {
        return paradas;
    }


    /**
     * Sets the paradas value for this MaquinaInjetDTO.
     * 
     * @param paradas
     */
    public void setParadas(idw.idwws.ParadaInjetDTO[] paradas) {
        this.paradas = paradas;
    }

    public idw.idwws.ParadaInjetDTO getParadas(int i) {
        return this.paradas[i];
    }

    public void setParadas(int i, idw.idwws.ParadaInjetDTO _value) {
        this.paradas[i] = _value;
    }


    /**
     * Gets the produtos value for this MaquinaInjetDTO.
     * 
     * @return produtos
     */
    public idw.idwws.ProdutoInjetDTO[] getProdutos() {
        return produtos;
    }


    /**
     * Sets the produtos value for this MaquinaInjetDTO.
     * 
     * @param produtos
     */
    public void setProdutos(idw.idwws.ProdutoInjetDTO[] produtos) {
        this.produtos = produtos;
    }

    public idw.idwws.ProdutoInjetDTO getProdutos(int i) {
        return this.produtos[i];
    }

    public void setProdutos(int i, idw.idwws.ProdutoInjetDTO _value) {
        this.produtos[i] = _value;
    }


    /**
     * Gets the refugos value for this MaquinaInjetDTO.
     * 
     * @return refugos
     */
    public idw.idwws.RefugoInjetDTO[] getRefugos() {
        return refugos;
    }


    /**
     * Sets the refugos value for this MaquinaInjetDTO.
     * 
     * @param refugos
     */
    public void setRefugos(idw.idwws.RefugoInjetDTO[] refugos) {
        this.refugos = refugos;
    }

    public idw.idwws.RefugoInjetDTO getRefugos(int i) {
        return this.refugos[i];
    }

    public void setRefugos(int i, idw.idwws.RefugoInjetDTO _value) {
        this.refugos[i] = _value;
    }


    /**
     * Gets the trocasDeOP value for this MaquinaInjetDTO.
     * 
     * @return trocasDeOP
     */
    public idw.idwws.TrocaOPInjetDTO[] getTrocasDeOP() {
        return trocasDeOP;
    }


    /**
     * Sets the trocasDeOP value for this MaquinaInjetDTO.
     * 
     * @param trocasDeOP
     */
    public void setTrocasDeOP(idw.idwws.TrocaOPInjetDTO[] trocasDeOP) {
        this.trocasDeOP = trocasDeOP;
    }

    public idw.idwws.TrocaOPInjetDTO getTrocasDeOP(int i) {
        return this.trocasDeOP[i];
    }

    public void setTrocasDeOP(int i, idw.idwws.TrocaOPInjetDTO _value) {
        this.trocasDeOP[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MaquinaInjetDTO)) return false;
        MaquinaInjetDTO other = (MaquinaInjetDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.alertas==null && other.getAlertas()==null) || 
             (this.alertas!=null &&
              java.util.Arrays.equals(this.alertas, other.getAlertas()))) &&
            ((this.cdLingua==null && other.getCdLingua()==null) || 
             (this.cdLingua!=null &&
              this.cdLingua.equals(other.getCdLingua()))) &&
            ((this.cdMaquina==null && other.getCdMaquina()==null) || 
             (this.cdMaquina!=null &&
              this.cdMaquina.equals(other.getCdMaquina()))) &&
            ((this.ciclos==null && other.getCiclos()==null) || 
             (this.ciclos!=null &&
              java.util.Arrays.equals(this.ciclos, other.getCiclos()))) &&
            this.corFrente == other.getCorFrente() &&
            this.corFundo == other.getCorFundo() &&
            ((this.dadosECPonderada==null && other.getDadosECPonderada()==null) || 
             (this.dadosECPonderada!=null &&
              java.util.Arrays.equals(this.dadosECPonderada, other.getDadosECPonderada()))) &&
            ((this.dsMaquina==null && other.getDsMaquina()==null) || 
             (this.dsMaquina!=null &&
              this.dsMaquina.equals(other.getDsMaquina()))) &&
            ((this.dthrFTurno==null && other.getDthrFTurno()==null) || 
             (this.dthrFTurno!=null &&
              this.dthrFTurno.equals(other.getDthrFTurno()))) &&
            ((this.dthrITurno==null && other.getDthrITurno()==null) || 
             (this.dthrITurno!=null &&
              this.dthrITurno.equals(other.getDthrITurno()))) &&
            ((this.ec_padrao==null && other.getEc_padrao()==null) || 
             (this.ec_padrao!=null &&
              this.ec_padrao.equals(other.getEc_padrao()))) &&
            ((this.eo_padrao==null && other.getEo_padrao()==null) || 
             (this.eo_padrao!=null &&
              this.eo_padrao.equals(other.getEo_padrao()))) &&
            ((this.gruposQueMaquinaPertence==null && other.getGruposQueMaquinaPertence()==null) || 
             (this.gruposQueMaquinaPertence!=null &&
              java.util.Arrays.equals(this.gruposQueMaquinaPertence, other.getGruposQueMaquinaPertence()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbmolAtualNaMaquina==null && other.getIjtbmolAtualNaMaquina()==null) || 
             (this.ijtbmolAtualNaMaquina!=null &&
              this.ijtbmolAtualNaMaquina.equals(other.getIjtbmolAtualNaMaquina()))) &&
            ((this.ir_padrao==null && other.getIr_padrao()==null) || 
             (this.ir_padrao!=null &&
              this.ir_padrao.equals(other.getIr_padrao()))) &&
            ((this.maquinaPlanejamentoDTO==null && other.getMaquinaPlanejamentoDTO()==null) || 
             (this.maquinaPlanejamentoDTO!=null &&
              this.maquinaPlanejamentoDTO.equals(other.getMaquinaPlanejamentoDTO()))) &&
            ((this.maquinaTotalDTO==null && other.getMaquinaTotalDTO()==null) || 
             (this.maquinaTotalDTO!=null &&
              this.maquinaTotalDTO.equals(other.getMaquinaTotalDTO()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop()))) &&
            ((this.operadoresAcumulado==null && other.getOperadoresAcumulado()==null) || 
             (this.operadoresAcumulado!=null &&
              java.util.Arrays.equals(this.operadoresAcumulado, other.getOperadoresAcumulado()))) &&
            ((this.operadoresTurno==null && other.getOperadoresTurno()==null) || 
             (this.operadoresTurno!=null &&
              java.util.Arrays.equals(this.operadoresTurno, other.getOperadoresTurno()))) &&
            ((this.paradaAtualUltimaParada==null && other.getParadaAtualUltimaParada()==null) || 
             (this.paradaAtualUltimaParada!=null &&
              this.paradaAtualUltimaParada.equals(other.getParadaAtualUltimaParada()))) &&
            ((this.paradas==null && other.getParadas()==null) || 
             (this.paradas!=null &&
              java.util.Arrays.equals(this.paradas, other.getParadas()))) &&
            ((this.produtos==null && other.getProdutos()==null) || 
             (this.produtos!=null &&
              java.util.Arrays.equals(this.produtos, other.getProdutos()))) &&
            ((this.refugos==null && other.getRefugos()==null) || 
             (this.refugos!=null &&
              java.util.Arrays.equals(this.refugos, other.getRefugos()))) &&
            ((this.trocasDeOP==null && other.getTrocasDeOP()==null) || 
             (this.trocasDeOP!=null &&
              java.util.Arrays.equals(this.trocasDeOP, other.getTrocasDeOP())));
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
        if (getAlertas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAlertas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAlertas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCdLingua() != null) {
            _hashCode += getCdLingua().hashCode();
        }
        if (getCdMaquina() != null) {
            _hashCode += getCdMaquina().hashCode();
        }
        if (getCiclos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCiclos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCiclos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getCorFrente();
        _hashCode += getCorFundo();
        if (getDadosECPonderada() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDadosECPonderada());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDadosECPonderada(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDsMaquina() != null) {
            _hashCode += getDsMaquina().hashCode();
        }
        if (getDthrFTurno() != null) {
            _hashCode += getDthrFTurno().hashCode();
        }
        if (getDthrITurno() != null) {
            _hashCode += getDthrITurno().hashCode();
        }
        if (getEc_padrao() != null) {
            _hashCode += getEc_padrao().hashCode();
        }
        if (getEo_padrao() != null) {
            _hashCode += getEo_padrao().hashCode();
        }
        if (getGruposQueMaquinaPertence() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGruposQueMaquinaPertence());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGruposQueMaquinaPertence(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbmolAtualNaMaquina() != null) {
            _hashCode += getIjtbmolAtualNaMaquina().hashCode();
        }
        if (getIr_padrao() != null) {
            _hashCode += getIr_padrao().hashCode();
        }
        if (getMaquinaPlanejamentoDTO() != null) {
            _hashCode += getMaquinaPlanejamentoDTO().hashCode();
        }
        if (getMaquinaTotalDTO() != null) {
            _hashCode += getMaquinaTotalDTO().hashCode();
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        if (getOperadoresAcumulado() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOperadoresAcumulado());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOperadoresAcumulado(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOperadoresTurno() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOperadoresTurno());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOperadoresTurno(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getParadaAtualUltimaParada() != null) {
            _hashCode += getParadaAtualUltimaParada().hashCode();
        }
        if (getParadas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getParadas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getParadas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getProdutos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProdutos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProdutos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRefugos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRefugos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRefugos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTrocasDeOP() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTrocasDeOP());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTrocasDeOP(), i);
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
        new org.apache.axis.description.TypeDesc(MaquinaInjetDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "maquinaInjetDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alertas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "alertas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "alertaInjetDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdLingua");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdLingua"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdMaquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdMaquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ciclos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ciclos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "cicloInjetDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corFrente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corFrente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corFundo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corFundo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosECPonderada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dadosECPonderada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dadosParaECPonderadaInjetDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsMaquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsMaquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrITurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrITurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ec_padrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ec_padrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eo_padrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eo_padrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gruposQueMaquinaPertence");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gruposQueMaquinaPertence"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmolAtualNaMaquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmolAtualNaMaquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ir_padrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ir_padrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maquinaPlanejamentoDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maquinaPlanejamentoDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "maquinaPlanejamentoInjetDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maquinaTotalDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maquinaTotalDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "maquinaTotalInjetDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operadoresAcumulado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operadoresAcumulado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlogope"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operadoresTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operadoresTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlogope"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaAtualUltimaParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaAtualUltimaParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "paradaInjetDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "paradaInjetDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produtos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produtos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "produtoInjetDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refugos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "refugos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "refugoInjetDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trocasDeOP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "trocasDeOP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "trocaOPInjetDTO"));
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
