/**
 * DetalheMonitorizacaoPTInjetDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DetalheMonitorizacaoPTInjetDTO  implements java.io.Serializable {
    private idw.idwws.AlertaDTO[] alertasandroidDTO;

    private java.lang.String cav_ativas;

    private java.lang.Double ciclosCicMedio;

    private java.lang.Double ciclosCicPadrao;

    private java.lang.Double ciclosEficienciaCic;

    private java.lang.Double ciclosUltimoCic;

    private java.lang.String dtReferencia;

    private java.lang.String dtinicioOP;

    private idw.idwws.DwFolha dwFolha;

    private idw.idwws.DwTurno dwTurno;

    private java.lang.Double efiCiclos;

    private java.lang.Double efiRealizacao;

    private java.lang.Double eficiclosPond;

    private java.lang.Double eficiencia;

    private java.lang.String identificacaomolde;

    private long idrt;

    private java.lang.Double indiceCavAtivas;

    private java.lang.Double indiceParadas;

    private java.lang.Double indicePerdas;

    private java.lang.Double indiceRefugos;

    private idw.idwws.AlertaDTO[] listaAlertas;

    private idw.idwws.GraficoCicloDTO[] listaCiclos;

    private idw.idwws.DwConsolid[] listaDwConsolId;

    private idw.idwws.DwConsolidDTOs listaDwConsolidTurno;

    private idw.idwws.GraficoTempoDTO[] listaGraficoTempoDTO;

    private idw.idwws.OperadorDTO[] listaOperadores;

    private idw.idwws.PerdasDTO[] listaPerdas;

    private idw.idwws.ProdutoDTO[] listaProdutos;

    private idw.idwws.DetalheMonitorizacaoPTInjetDTO[] listaTurnos;

    private java.lang.String maquina;

    private java.lang.Double metaHora;

    private java.lang.String molde;

    private idw.idwws.OmPt omPt;

    private idw.idwws.OperadorDTO[] operadoresandroidDTO;

    private java.lang.String ordemproducao;

    private java.lang.String paradaAreaResponsavel;

    private java.lang.String paradaAtualUltParada;

    private java.lang.String paradaDtInicio;

    private java.lang.String paradaHrIncio;

    private java.lang.Double paradaMTBF;

    private java.lang.Double paradaMTTR;

    private java.lang.Double paradasIndiceParadas;

    private java.lang.Double paradasTempoParadas;

    private java.lang.Double pci;

    private java.lang.Double pcsPorCicloAtivas;

    private java.lang.Double perdasCiclos;

    private java.lang.Double perdasParadas;

    private idw.idwws.PerdasDTO[] perdasandroidDTO;

    private java.lang.String periodo;

    private java.lang.Double produtividadeOEE;

    private java.lang.Double produtividadeOEECapital;

    private java.lang.String produto;

    private idw.idwws.ProdutosDTO produtosandroidDTO;

    private java.lang.Double projPCIHoras;

    private java.lang.Double qtdPecasBoas;

    private java.lang.Double qtdPrevista;

    private java.lang.Double qtdProduzida;

    private java.lang.Double qtdRefugadas;

    private java.lang.Double qtdeCiclosExecutar;

    private java.lang.Double tempoAtivo;

    private java.lang.Double tempoBoas;

    private java.lang.Integer tempoCalendario;

    private java.lang.Double tempoCavIsoladas;

    private java.lang.Double tempoCiclosImprodutivos;

    private java.lang.Double tempoCiclosProdutivos;

    private java.lang.Double tempoDisponiveis;

    private java.lang.Integer tempoDuplicadoColeta;

    private java.lang.Double tempoNaoDisponivel;

    private java.lang.String tempoParadaAtualUltParada;

    private java.lang.Double tempoParadas;

    private java.lang.Double tempoProdutivas;

    private java.lang.Double tempoRefugos;

    private java.lang.Double tempoRitmo;

    private java.lang.Integer tempoSemColeta;

    private java.lang.Double tempoTotais;

    private java.lang.Double tempoTrabalhadas;

    private java.lang.Double totalPerdas;

    private java.lang.Double utilizacao;

    private java.lang.Double ciclosEficienciaUltCic;

    public DetalheMonitorizacaoPTInjetDTO() {
    }

    public DetalheMonitorizacaoPTInjetDTO(
           idw.idwws.AlertaDTO[] alertasandroidDTO,
           java.lang.String cav_ativas,
           java.lang.Double ciclosCicMedio,
           java.lang.Double ciclosCicPadrao,
           java.lang.Double ciclosEficienciaCic,
           java.lang.Double ciclosUltimoCic,
           java.lang.String dtReferencia,
           java.lang.String dtinicioOP,
           idw.idwws.DwFolha dwFolha,
           idw.idwws.DwTurno dwTurno,
           java.lang.Double efiCiclos,
           java.lang.Double efiRealizacao,
           java.lang.Double eficiclosPond,
           java.lang.Double eficiencia,
           java.lang.String identificacaomolde,
           long idrt,
           java.lang.Double indiceCavAtivas,
           java.lang.Double indiceParadas,
           java.lang.Double indicePerdas,
           java.lang.Double indiceRefugos,
           idw.idwws.AlertaDTO[] listaAlertas,
           idw.idwws.GraficoCicloDTO[] listaCiclos,
           idw.idwws.DwConsolid[] listaDwConsolId,
           idw.idwws.DwConsolidDTOs listaDwConsolidTurno,
           idw.idwws.GraficoTempoDTO[] listaGraficoTempoDTO,
           idw.idwws.OperadorDTO[] listaOperadores,
           idw.idwws.PerdasDTO[] listaPerdas,
           idw.idwws.ProdutoDTO[] listaProdutos,
           idw.idwws.DetalheMonitorizacaoPTInjetDTO[] listaTurnos,
           java.lang.String maquina,
           java.lang.Double metaHora,
           java.lang.String molde,
           idw.idwws.OmPt omPt,
           idw.idwws.OperadorDTO[] operadoresandroidDTO,
           java.lang.String ordemproducao,
           java.lang.String paradaAreaResponsavel,
           java.lang.String paradaAtualUltParada,
           java.lang.String paradaDtInicio,
           java.lang.String paradaHrIncio,
           java.lang.Double paradaMTBF,
           java.lang.Double paradaMTTR,
           java.lang.Double paradasIndiceParadas,
           java.lang.Double paradasTempoParadas,
           java.lang.Double pci,
           java.lang.Double pcsPorCicloAtivas,
           java.lang.Double perdasCiclos,
           java.lang.Double perdasParadas,
           idw.idwws.PerdasDTO[] perdasandroidDTO,
           java.lang.String periodo,
           java.lang.Double produtividadeOEE,
           java.lang.Double produtividadeOEECapital,
           java.lang.String produto,
           idw.idwws.ProdutosDTO produtosandroidDTO,
           java.lang.Double projPCIHoras,
           java.lang.Double qtdPecasBoas,
           java.lang.Double qtdPrevista,
           java.lang.Double qtdProduzida,
           java.lang.Double qtdRefugadas,
           java.lang.Double qtdeCiclosExecutar,
           java.lang.Double tempoAtivo,
           java.lang.Double tempoBoas,
           java.lang.Integer tempoCalendario,
           java.lang.Double tempoCavIsoladas,
           java.lang.Double tempoCiclosImprodutivos,
           java.lang.Double tempoCiclosProdutivos,
           java.lang.Double tempoDisponiveis,
           java.lang.Integer tempoDuplicadoColeta,
           java.lang.Double tempoNaoDisponivel,
           java.lang.String tempoParadaAtualUltParada,
           java.lang.Double tempoParadas,
           java.lang.Double tempoProdutivas,
           java.lang.Double tempoRefugos,
           java.lang.Double tempoRitmo,
           java.lang.Integer tempoSemColeta,
           java.lang.Double tempoTotais,
           java.lang.Double tempoTrabalhadas,
           java.lang.Double totalPerdas,
           java.lang.Double utilizacao,
           java.lang.Double ciclosEficienciaUltCic) {
           this.alertasandroidDTO = alertasandroidDTO;
           this.cav_ativas = cav_ativas;
           this.ciclosCicMedio = ciclosCicMedio;
           this.ciclosCicPadrao = ciclosCicPadrao;
           this.ciclosEficienciaCic = ciclosEficienciaCic;
           this.ciclosUltimoCic = ciclosUltimoCic;
           this.dtReferencia = dtReferencia;
           this.dtinicioOP = dtinicioOP;
           this.dwFolha = dwFolha;
           this.dwTurno = dwTurno;
           this.efiCiclos = efiCiclos;
           this.efiRealizacao = efiRealizacao;
           this.eficiclosPond = eficiclosPond;
           this.eficiencia = eficiencia;
           this.identificacaomolde = identificacaomolde;
           this.idrt = idrt;
           this.indiceCavAtivas = indiceCavAtivas;
           this.indiceParadas = indiceParadas;
           this.indicePerdas = indicePerdas;
           this.indiceRefugos = indiceRefugos;
           this.listaAlertas = listaAlertas;
           this.listaCiclos = listaCiclos;
           this.listaDwConsolId = listaDwConsolId;
           this.listaDwConsolidTurno = listaDwConsolidTurno;
           this.listaGraficoTempoDTO = listaGraficoTempoDTO;
           this.listaOperadores = listaOperadores;
           this.listaPerdas = listaPerdas;
           this.listaProdutos = listaProdutos;
           this.listaTurnos = listaTurnos;
           this.maquina = maquina;
           this.metaHora = metaHora;
           this.molde = molde;
           this.omPt = omPt;
           this.operadoresandroidDTO = operadoresandroidDTO;
           this.ordemproducao = ordemproducao;
           this.paradaAreaResponsavel = paradaAreaResponsavel;
           this.paradaAtualUltParada = paradaAtualUltParada;
           this.paradaDtInicio = paradaDtInicio;
           this.paradaHrIncio = paradaHrIncio;
           this.paradaMTBF = paradaMTBF;
           this.paradaMTTR = paradaMTTR;
           this.paradasIndiceParadas = paradasIndiceParadas;
           this.paradasTempoParadas = paradasTempoParadas;
           this.pci = pci;
           this.pcsPorCicloAtivas = pcsPorCicloAtivas;
           this.perdasCiclos = perdasCiclos;
           this.perdasParadas = perdasParadas;
           this.perdasandroidDTO = perdasandroidDTO;
           this.periodo = periodo;
           this.produtividadeOEE = produtividadeOEE;
           this.produtividadeOEECapital = produtividadeOEECapital;
           this.produto = produto;
           this.produtosandroidDTO = produtosandroidDTO;
           this.projPCIHoras = projPCIHoras;
           this.qtdPecasBoas = qtdPecasBoas;
           this.qtdPrevista = qtdPrevista;
           this.qtdProduzida = qtdProduzida;
           this.qtdRefugadas = qtdRefugadas;
           this.qtdeCiclosExecutar = qtdeCiclosExecutar;
           this.tempoAtivo = tempoAtivo;
           this.tempoBoas = tempoBoas;
           this.tempoCalendario = tempoCalendario;
           this.tempoCavIsoladas = tempoCavIsoladas;
           this.tempoCiclosImprodutivos = tempoCiclosImprodutivos;
           this.tempoCiclosProdutivos = tempoCiclosProdutivos;
           this.tempoDisponiveis = tempoDisponiveis;
           this.tempoDuplicadoColeta = tempoDuplicadoColeta;
           this.tempoNaoDisponivel = tempoNaoDisponivel;
           this.tempoParadaAtualUltParada = tempoParadaAtualUltParada;
           this.tempoParadas = tempoParadas;
           this.tempoProdutivas = tempoProdutivas;
           this.tempoRefugos = tempoRefugos;
           this.tempoRitmo = tempoRitmo;
           this.tempoSemColeta = tempoSemColeta;
           this.tempoTotais = tempoTotais;
           this.tempoTrabalhadas = tempoTrabalhadas;
           this.totalPerdas = totalPerdas;
           this.utilizacao = utilizacao;
           this.ciclosEficienciaUltCic = ciclosEficienciaUltCic;
    }


    /**
     * Gets the alertasandroidDTO value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return alertasandroidDTO
     */
    public idw.idwws.AlertaDTO[] getAlertasandroidDTO() {
        return alertasandroidDTO;
    }


    /**
     * Sets the alertasandroidDTO value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param alertasandroidDTO
     */
    public void setAlertasandroidDTO(idw.idwws.AlertaDTO[] alertasandroidDTO) {
        this.alertasandroidDTO = alertasandroidDTO;
    }


    /**
     * Gets the cav_ativas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return cav_ativas
     */
    public java.lang.String getCav_ativas() {
        return cav_ativas;
    }


    /**
     * Sets the cav_ativas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param cav_ativas
     */
    public void setCav_ativas(java.lang.String cav_ativas) {
        this.cav_ativas = cav_ativas;
    }


    /**
     * Gets the ciclosCicMedio value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return ciclosCicMedio
     */
    public java.lang.Double getCiclosCicMedio() {
        return ciclosCicMedio;
    }


    /**
     * Sets the ciclosCicMedio value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param ciclosCicMedio
     */
    public void setCiclosCicMedio(java.lang.Double ciclosCicMedio) {
        this.ciclosCicMedio = ciclosCicMedio;
    }


    /**
     * Gets the ciclosCicPadrao value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return ciclosCicPadrao
     */
    public java.lang.Double getCiclosCicPadrao() {
        return ciclosCicPadrao;
    }


    /**
     * Sets the ciclosCicPadrao value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param ciclosCicPadrao
     */
    public void setCiclosCicPadrao(java.lang.Double ciclosCicPadrao) {
        this.ciclosCicPadrao = ciclosCicPadrao;
    }


    /**
     * Gets the ciclosEficienciaCic value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return ciclosEficienciaCic
     */
    public java.lang.Double getCiclosEficienciaCic() {
        return ciclosEficienciaCic;
    }


    /**
     * Sets the ciclosEficienciaCic value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param ciclosEficienciaCic
     */
    public void setCiclosEficienciaCic(java.lang.Double ciclosEficienciaCic) {
        this.ciclosEficienciaCic = ciclosEficienciaCic;
    }


    /**
     * Gets the ciclosUltimoCic value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return ciclosUltimoCic
     */
    public java.lang.Double getCiclosUltimoCic() {
        return ciclosUltimoCic;
    }


    /**
     * Sets the ciclosUltimoCic value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param ciclosUltimoCic
     */
    public void setCiclosUltimoCic(java.lang.Double ciclosUltimoCic) {
        this.ciclosUltimoCic = ciclosUltimoCic;
    }


    /**
     * Gets the dtReferencia value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return dtReferencia
     */
    public java.lang.String getDtReferencia() {
        return dtReferencia;
    }


    /**
     * Sets the dtReferencia value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param dtReferencia
     */
    public void setDtReferencia(java.lang.String dtReferencia) {
        this.dtReferencia = dtReferencia;
    }


    /**
     * Gets the dtinicioOP value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return dtinicioOP
     */
    public java.lang.String getDtinicioOP() {
        return dtinicioOP;
    }


    /**
     * Sets the dtinicioOP value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param dtinicioOP
     */
    public void setDtinicioOP(java.lang.String dtinicioOP) {
        this.dtinicioOP = dtinicioOP;
    }


    /**
     * Gets the dwFolha value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return dwFolha
     */
    public idw.idwws.DwFolha getDwFolha() {
        return dwFolha;
    }


    /**
     * Sets the dwFolha value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param dwFolha
     */
    public void setDwFolha(idw.idwws.DwFolha dwFolha) {
        this.dwFolha = dwFolha;
    }


    /**
     * Gets the dwTurno value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return dwTurno
     */
    public idw.idwws.DwTurno getDwTurno() {
        return dwTurno;
    }


    /**
     * Sets the dwTurno value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param dwTurno
     */
    public void setDwTurno(idw.idwws.DwTurno dwTurno) {
        this.dwTurno = dwTurno;
    }


    /**
     * Gets the efiCiclos value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return efiCiclos
     */
    public java.lang.Double getEfiCiclos() {
        return efiCiclos;
    }


    /**
     * Sets the efiCiclos value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param efiCiclos
     */
    public void setEfiCiclos(java.lang.Double efiCiclos) {
        this.efiCiclos = efiCiclos;
    }


    /**
     * Gets the efiRealizacao value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return efiRealizacao
     */
    public java.lang.Double getEfiRealizacao() {
        return efiRealizacao;
    }


    /**
     * Sets the efiRealizacao value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param efiRealizacao
     */
    public void setEfiRealizacao(java.lang.Double efiRealizacao) {
        this.efiRealizacao = efiRealizacao;
    }


    /**
     * Gets the eficiclosPond value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return eficiclosPond
     */
    public java.lang.Double getEficiclosPond() {
        return eficiclosPond;
    }


    /**
     * Sets the eficiclosPond value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param eficiclosPond
     */
    public void setEficiclosPond(java.lang.Double eficiclosPond) {
        this.eficiclosPond = eficiclosPond;
    }


    /**
     * Gets the eficiencia value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return eficiencia
     */
    public java.lang.Double getEficiencia() {
        return eficiencia;
    }


    /**
     * Sets the eficiencia value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param eficiencia
     */
    public void setEficiencia(java.lang.Double eficiencia) {
        this.eficiencia = eficiencia;
    }


    /**
     * Gets the identificacaomolde value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return identificacaomolde
     */
    public java.lang.String getIdentificacaomolde() {
        return identificacaomolde;
    }


    /**
     * Sets the identificacaomolde value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param identificacaomolde
     */
    public void setIdentificacaomolde(java.lang.String identificacaomolde) {
        this.identificacaomolde = identificacaomolde;
    }


    /**
     * Gets the idrt value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return idrt
     */
    public long getIdrt() {
        return idrt;
    }


    /**
     * Sets the idrt value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param idrt
     */
    public void setIdrt(long idrt) {
        this.idrt = idrt;
    }


    /**
     * Gets the indiceCavAtivas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return indiceCavAtivas
     */
    public java.lang.Double getIndiceCavAtivas() {
        return indiceCavAtivas;
    }


    /**
     * Sets the indiceCavAtivas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param indiceCavAtivas
     */
    public void setIndiceCavAtivas(java.lang.Double indiceCavAtivas) {
        this.indiceCavAtivas = indiceCavAtivas;
    }


    /**
     * Gets the indiceParadas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return indiceParadas
     */
    public java.lang.Double getIndiceParadas() {
        return indiceParadas;
    }


    /**
     * Sets the indiceParadas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param indiceParadas
     */
    public void setIndiceParadas(java.lang.Double indiceParadas) {
        this.indiceParadas = indiceParadas;
    }


    /**
     * Gets the indicePerdas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return indicePerdas
     */
    public java.lang.Double getIndicePerdas() {
        return indicePerdas;
    }


    /**
     * Sets the indicePerdas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param indicePerdas
     */
    public void setIndicePerdas(java.lang.Double indicePerdas) {
        this.indicePerdas = indicePerdas;
    }


    /**
     * Gets the indiceRefugos value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return indiceRefugos
     */
    public java.lang.Double getIndiceRefugos() {
        return indiceRefugos;
    }


    /**
     * Sets the indiceRefugos value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param indiceRefugos
     */
    public void setIndiceRefugos(java.lang.Double indiceRefugos) {
        this.indiceRefugos = indiceRefugos;
    }


    /**
     * Gets the listaAlertas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return listaAlertas
     */
    public idw.idwws.AlertaDTO[] getListaAlertas() {
        return listaAlertas;
    }


    /**
     * Sets the listaAlertas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param listaAlertas
     */
    public void setListaAlertas(idw.idwws.AlertaDTO[] listaAlertas) {
        this.listaAlertas = listaAlertas;
    }

    public idw.idwws.AlertaDTO getListaAlertas(int i) {
        return this.listaAlertas[i];
    }

    public void setListaAlertas(int i, idw.idwws.AlertaDTO _value) {
        this.listaAlertas[i] = _value;
    }


    /**
     * Gets the listaCiclos value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return listaCiclos
     */
    public idw.idwws.GraficoCicloDTO[] getListaCiclos() {
        return listaCiclos;
    }


    /**
     * Sets the listaCiclos value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param listaCiclos
     */
    public void setListaCiclos(idw.idwws.GraficoCicloDTO[] listaCiclos) {
        this.listaCiclos = listaCiclos;
    }

    public idw.idwws.GraficoCicloDTO getListaCiclos(int i) {
        return this.listaCiclos[i];
    }

    public void setListaCiclos(int i, idw.idwws.GraficoCicloDTO _value) {
        this.listaCiclos[i] = _value;
    }


    /**
     * Gets the listaDwConsolId value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return listaDwConsolId
     */
    public idw.idwws.DwConsolid[] getListaDwConsolId() {
        return listaDwConsolId;
    }


    /**
     * Sets the listaDwConsolId value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param listaDwConsolId
     */
    public void setListaDwConsolId(idw.idwws.DwConsolid[] listaDwConsolId) {
        this.listaDwConsolId = listaDwConsolId;
    }

    public idw.idwws.DwConsolid getListaDwConsolId(int i) {
        return this.listaDwConsolId[i];
    }

    public void setListaDwConsolId(int i, idw.idwws.DwConsolid _value) {
        this.listaDwConsolId[i] = _value;
    }


    /**
     * Gets the listaDwConsolidTurno value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return listaDwConsolidTurno
     */
    public idw.idwws.DwConsolidDTOs getListaDwConsolidTurno() {
        return listaDwConsolidTurno;
    }


    /**
     * Sets the listaDwConsolidTurno value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param listaDwConsolidTurno
     */
    public void setListaDwConsolidTurno(idw.idwws.DwConsolidDTOs listaDwConsolidTurno) {
        this.listaDwConsolidTurno = listaDwConsolidTurno;
    }


    /**
     * Gets the listaGraficoTempoDTO value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return listaGraficoTempoDTO
     */
    public idw.idwws.GraficoTempoDTO[] getListaGraficoTempoDTO() {
        return listaGraficoTempoDTO;
    }


    /**
     * Sets the listaGraficoTempoDTO value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param listaGraficoTempoDTO
     */
    public void setListaGraficoTempoDTO(idw.idwws.GraficoTempoDTO[] listaGraficoTempoDTO) {
        this.listaGraficoTempoDTO = listaGraficoTempoDTO;
    }

    public idw.idwws.GraficoTempoDTO getListaGraficoTempoDTO(int i) {
        return this.listaGraficoTempoDTO[i];
    }

    public void setListaGraficoTempoDTO(int i, idw.idwws.GraficoTempoDTO _value) {
        this.listaGraficoTempoDTO[i] = _value;
    }


    /**
     * Gets the listaOperadores value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return listaOperadores
     */
    public idw.idwws.OperadorDTO[] getListaOperadores() {
        return listaOperadores;
    }


    /**
     * Sets the listaOperadores value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param listaOperadores
     */
    public void setListaOperadores(idw.idwws.OperadorDTO[] listaOperadores) {
        this.listaOperadores = listaOperadores;
    }

    public idw.idwws.OperadorDTO getListaOperadores(int i) {
        return this.listaOperadores[i];
    }

    public void setListaOperadores(int i, idw.idwws.OperadorDTO _value) {
        this.listaOperadores[i] = _value;
    }


    /**
     * Gets the listaPerdas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return listaPerdas
     */
    public idw.idwws.PerdasDTO[] getListaPerdas() {
        return listaPerdas;
    }


    /**
     * Sets the listaPerdas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param listaPerdas
     */
    public void setListaPerdas(idw.idwws.PerdasDTO[] listaPerdas) {
        this.listaPerdas = listaPerdas;
    }

    public idw.idwws.PerdasDTO getListaPerdas(int i) {
        return this.listaPerdas[i];
    }

    public void setListaPerdas(int i, idw.idwws.PerdasDTO _value) {
        this.listaPerdas[i] = _value;
    }


    /**
     * Gets the listaProdutos value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return listaProdutos
     */
    public idw.idwws.ProdutoDTO[] getListaProdutos() {
        return listaProdutos;
    }


    /**
     * Sets the listaProdutos value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param listaProdutos
     */
    public void setListaProdutos(idw.idwws.ProdutoDTO[] listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public idw.idwws.ProdutoDTO getListaProdutos(int i) {
        return this.listaProdutos[i];
    }

    public void setListaProdutos(int i, idw.idwws.ProdutoDTO _value) {
        this.listaProdutos[i] = _value;
    }


    /**
     * Gets the listaTurnos value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return listaTurnos
     */
    public idw.idwws.DetalheMonitorizacaoPTInjetDTO[] getListaTurnos() {
        return listaTurnos;
    }


    /**
     * Sets the listaTurnos value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param listaTurnos
     */
    public void setListaTurnos(idw.idwws.DetalheMonitorizacaoPTInjetDTO[] listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public idw.idwws.DetalheMonitorizacaoPTInjetDTO getListaTurnos(int i) {
        return this.listaTurnos[i];
    }

    public void setListaTurnos(int i, idw.idwws.DetalheMonitorizacaoPTInjetDTO _value) {
        this.listaTurnos[i] = _value;
    }


    /**
     * Gets the maquina value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return maquina
     */
    public java.lang.String getMaquina() {
        return maquina;
    }


    /**
     * Sets the maquina value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param maquina
     */
    public void setMaquina(java.lang.String maquina) {
        this.maquina = maquina;
    }


    /**
     * Gets the metaHora value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return metaHora
     */
    public java.lang.Double getMetaHora() {
        return metaHora;
    }


    /**
     * Sets the metaHora value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param metaHora
     */
    public void setMetaHora(java.lang.Double metaHora) {
        this.metaHora = metaHora;
    }


    /**
     * Gets the molde value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return molde
     */
    public java.lang.String getMolde() {
        return molde;
    }


    /**
     * Sets the molde value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param molde
     */
    public void setMolde(java.lang.String molde) {
        this.molde = molde;
    }


    /**
     * Gets the omPt value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the operadoresandroidDTO value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return operadoresandroidDTO
     */
    public idw.idwws.OperadorDTO[] getOperadoresandroidDTO() {
        return operadoresandroidDTO;
    }


    /**
     * Sets the operadoresandroidDTO value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param operadoresandroidDTO
     */
    public void setOperadoresandroidDTO(idw.idwws.OperadorDTO[] operadoresandroidDTO) {
        this.operadoresandroidDTO = operadoresandroidDTO;
    }


    /**
     * Gets the ordemproducao value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return ordemproducao
     */
    public java.lang.String getOrdemproducao() {
        return ordemproducao;
    }


    /**
     * Sets the ordemproducao value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param ordemproducao
     */
    public void setOrdemproducao(java.lang.String ordemproducao) {
        this.ordemproducao = ordemproducao;
    }


    /**
     * Gets the paradaAreaResponsavel value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return paradaAreaResponsavel
     */
    public java.lang.String getParadaAreaResponsavel() {
        return paradaAreaResponsavel;
    }


    /**
     * Sets the paradaAreaResponsavel value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param paradaAreaResponsavel
     */
    public void setParadaAreaResponsavel(java.lang.String paradaAreaResponsavel) {
        this.paradaAreaResponsavel = paradaAreaResponsavel;
    }


    /**
     * Gets the paradaAtualUltParada value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return paradaAtualUltParada
     */
    public java.lang.String getParadaAtualUltParada() {
        return paradaAtualUltParada;
    }


    /**
     * Sets the paradaAtualUltParada value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param paradaAtualUltParada
     */
    public void setParadaAtualUltParada(java.lang.String paradaAtualUltParada) {
        this.paradaAtualUltParada = paradaAtualUltParada;
    }


    /**
     * Gets the paradaDtInicio value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return paradaDtInicio
     */
    public java.lang.String getParadaDtInicio() {
        return paradaDtInicio;
    }


    /**
     * Sets the paradaDtInicio value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param paradaDtInicio
     */
    public void setParadaDtInicio(java.lang.String paradaDtInicio) {
        this.paradaDtInicio = paradaDtInicio;
    }


    /**
     * Gets the paradaHrIncio value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return paradaHrIncio
     */
    public java.lang.String getParadaHrIncio() {
        return paradaHrIncio;
    }


    /**
     * Sets the paradaHrIncio value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param paradaHrIncio
     */
    public void setParadaHrIncio(java.lang.String paradaHrIncio) {
        this.paradaHrIncio = paradaHrIncio;
    }


    /**
     * Gets the paradaMTBF value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return paradaMTBF
     */
    public java.lang.Double getParadaMTBF() {
        return paradaMTBF;
    }


    /**
     * Sets the paradaMTBF value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param paradaMTBF
     */
    public void setParadaMTBF(java.lang.Double paradaMTBF) {
        this.paradaMTBF = paradaMTBF;
    }


    /**
     * Gets the paradaMTTR value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return paradaMTTR
     */
    public java.lang.Double getParadaMTTR() {
        return paradaMTTR;
    }


    /**
     * Sets the paradaMTTR value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param paradaMTTR
     */
    public void setParadaMTTR(java.lang.Double paradaMTTR) {
        this.paradaMTTR = paradaMTTR;
    }


    /**
     * Gets the paradasIndiceParadas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return paradasIndiceParadas
     */
    public java.lang.Double getParadasIndiceParadas() {
        return paradasIndiceParadas;
    }


    /**
     * Sets the paradasIndiceParadas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param paradasIndiceParadas
     */
    public void setParadasIndiceParadas(java.lang.Double paradasIndiceParadas) {
        this.paradasIndiceParadas = paradasIndiceParadas;
    }


    /**
     * Gets the paradasTempoParadas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return paradasTempoParadas
     */
    public java.lang.Double getParadasTempoParadas() {
        return paradasTempoParadas;
    }


    /**
     * Sets the paradasTempoParadas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param paradasTempoParadas
     */
    public void setParadasTempoParadas(java.lang.Double paradasTempoParadas) {
        this.paradasTempoParadas = paradasTempoParadas;
    }


    /**
     * Gets the pci value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return pci
     */
    public java.lang.Double getPci() {
        return pci;
    }


    /**
     * Sets the pci value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param pci
     */
    public void setPci(java.lang.Double pci) {
        this.pci = pci;
    }


    /**
     * Gets the pcsPorCicloAtivas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return pcsPorCicloAtivas
     */
    public java.lang.Double getPcsPorCicloAtivas() {
        return pcsPorCicloAtivas;
    }


    /**
     * Sets the pcsPorCicloAtivas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param pcsPorCicloAtivas
     */
    public void setPcsPorCicloAtivas(java.lang.Double pcsPorCicloAtivas) {
        this.pcsPorCicloAtivas = pcsPorCicloAtivas;
    }


    /**
     * Gets the perdasCiclos value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return perdasCiclos
     */
    public java.lang.Double getPerdasCiclos() {
        return perdasCiclos;
    }


    /**
     * Sets the perdasCiclos value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param perdasCiclos
     */
    public void setPerdasCiclos(java.lang.Double perdasCiclos) {
        this.perdasCiclos = perdasCiclos;
    }


    /**
     * Gets the perdasParadas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return perdasParadas
     */
    public java.lang.Double getPerdasParadas() {
        return perdasParadas;
    }


    /**
     * Sets the perdasParadas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param perdasParadas
     */
    public void setPerdasParadas(java.lang.Double perdasParadas) {
        this.perdasParadas = perdasParadas;
    }


    /**
     * Gets the perdasandroidDTO value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return perdasandroidDTO
     */
    public idw.idwws.PerdasDTO[] getPerdasandroidDTO() {
        return perdasandroidDTO;
    }


    /**
     * Sets the perdasandroidDTO value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param perdasandroidDTO
     */
    public void setPerdasandroidDTO(idw.idwws.PerdasDTO[] perdasandroidDTO) {
        this.perdasandroidDTO = perdasandroidDTO;
    }


    /**
     * Gets the periodo value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return periodo
     */
    public java.lang.String getPeriodo() {
        return periodo;
    }


    /**
     * Sets the periodo value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param periodo
     */
    public void setPeriodo(java.lang.String periodo) {
        this.periodo = periodo;
    }


    /**
     * Gets the produtividadeOEE value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return produtividadeOEE
     */
    public java.lang.Double getProdutividadeOEE() {
        return produtividadeOEE;
    }


    /**
     * Sets the produtividadeOEE value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param produtividadeOEE
     */
    public void setProdutividadeOEE(java.lang.Double produtividadeOEE) {
        this.produtividadeOEE = produtividadeOEE;
    }


    /**
     * Gets the produtividadeOEECapital value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return produtividadeOEECapital
     */
    public java.lang.Double getProdutividadeOEECapital() {
        return produtividadeOEECapital;
    }


    /**
     * Sets the produtividadeOEECapital value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param produtividadeOEECapital
     */
    public void setProdutividadeOEECapital(java.lang.Double produtividadeOEECapital) {
        this.produtividadeOEECapital = produtividadeOEECapital;
    }


    /**
     * Gets the produto value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return produto
     */
    public java.lang.String getProduto() {
        return produto;
    }


    /**
     * Sets the produto value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param produto
     */
    public void setProduto(java.lang.String produto) {
        this.produto = produto;
    }


    /**
     * Gets the produtosandroidDTO value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return produtosandroidDTO
     */
    public idw.idwws.ProdutosDTO getProdutosandroidDTO() {
        return produtosandroidDTO;
    }


    /**
     * Sets the produtosandroidDTO value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param produtosandroidDTO
     */
    public void setProdutosandroidDTO(idw.idwws.ProdutosDTO produtosandroidDTO) {
        this.produtosandroidDTO = produtosandroidDTO;
    }


    /**
     * Gets the projPCIHoras value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return projPCIHoras
     */
    public java.lang.Double getProjPCIHoras() {
        return projPCIHoras;
    }


    /**
     * Sets the projPCIHoras value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param projPCIHoras
     */
    public void setProjPCIHoras(java.lang.Double projPCIHoras) {
        this.projPCIHoras = projPCIHoras;
    }


    /**
     * Gets the qtdPecasBoas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return qtdPecasBoas
     */
    public java.lang.Double getQtdPecasBoas() {
        return qtdPecasBoas;
    }


    /**
     * Sets the qtdPecasBoas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param qtdPecasBoas
     */
    public void setQtdPecasBoas(java.lang.Double qtdPecasBoas) {
        this.qtdPecasBoas = qtdPecasBoas;
    }


    /**
     * Gets the qtdPrevista value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return qtdPrevista
     */
    public java.lang.Double getQtdPrevista() {
        return qtdPrevista;
    }


    /**
     * Sets the qtdPrevista value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param qtdPrevista
     */
    public void setQtdPrevista(java.lang.Double qtdPrevista) {
        this.qtdPrevista = qtdPrevista;
    }


    /**
     * Gets the qtdProduzida value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return qtdProduzida
     */
    public java.lang.Double getQtdProduzida() {
        return qtdProduzida;
    }


    /**
     * Sets the qtdProduzida value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param qtdProduzida
     */
    public void setQtdProduzida(java.lang.Double qtdProduzida) {
        this.qtdProduzida = qtdProduzida;
    }


    /**
     * Gets the qtdRefugadas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return qtdRefugadas
     */
    public java.lang.Double getQtdRefugadas() {
        return qtdRefugadas;
    }


    /**
     * Sets the qtdRefugadas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param qtdRefugadas
     */
    public void setQtdRefugadas(java.lang.Double qtdRefugadas) {
        this.qtdRefugadas = qtdRefugadas;
    }


    /**
     * Gets the qtdeCiclosExecutar value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return qtdeCiclosExecutar
     */
    public java.lang.Double getQtdeCiclosExecutar() {
        return qtdeCiclosExecutar;
    }


    /**
     * Sets the qtdeCiclosExecutar value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param qtdeCiclosExecutar
     */
    public void setQtdeCiclosExecutar(java.lang.Double qtdeCiclosExecutar) {
        this.qtdeCiclosExecutar = qtdeCiclosExecutar;
    }


    /**
     * Gets the tempoAtivo value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return tempoAtivo
     */
    public java.lang.Double getTempoAtivo() {
        return tempoAtivo;
    }


    /**
     * Sets the tempoAtivo value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param tempoAtivo
     */
    public void setTempoAtivo(java.lang.Double tempoAtivo) {
        this.tempoAtivo = tempoAtivo;
    }


    /**
     * Gets the tempoBoas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return tempoBoas
     */
    public java.lang.Double getTempoBoas() {
        return tempoBoas;
    }


    /**
     * Sets the tempoBoas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param tempoBoas
     */
    public void setTempoBoas(java.lang.Double tempoBoas) {
        this.tempoBoas = tempoBoas;
    }


    /**
     * Gets the tempoCalendario value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return tempoCalendario
     */
    public java.lang.Integer getTempoCalendario() {
        return tempoCalendario;
    }


    /**
     * Sets the tempoCalendario value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param tempoCalendario
     */
    public void setTempoCalendario(java.lang.Integer tempoCalendario) {
        this.tempoCalendario = tempoCalendario;
    }


    /**
     * Gets the tempoCavIsoladas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return tempoCavIsoladas
     */
    public java.lang.Double getTempoCavIsoladas() {
        return tempoCavIsoladas;
    }


    /**
     * Sets the tempoCavIsoladas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param tempoCavIsoladas
     */
    public void setTempoCavIsoladas(java.lang.Double tempoCavIsoladas) {
        this.tempoCavIsoladas = tempoCavIsoladas;
    }


    /**
     * Gets the tempoCiclosImprodutivos value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return tempoCiclosImprodutivos
     */
    public java.lang.Double getTempoCiclosImprodutivos() {
        return tempoCiclosImprodutivos;
    }


    /**
     * Sets the tempoCiclosImprodutivos value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param tempoCiclosImprodutivos
     */
    public void setTempoCiclosImprodutivos(java.lang.Double tempoCiclosImprodutivos) {
        this.tempoCiclosImprodutivos = tempoCiclosImprodutivos;
    }


    /**
     * Gets the tempoCiclosProdutivos value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return tempoCiclosProdutivos
     */
    public java.lang.Double getTempoCiclosProdutivos() {
        return tempoCiclosProdutivos;
    }


    /**
     * Sets the tempoCiclosProdutivos value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param tempoCiclosProdutivos
     */
    public void setTempoCiclosProdutivos(java.lang.Double tempoCiclosProdutivos) {
        this.tempoCiclosProdutivos = tempoCiclosProdutivos;
    }


    /**
     * Gets the tempoDisponiveis value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return tempoDisponiveis
     */
    public java.lang.Double getTempoDisponiveis() {
        return tempoDisponiveis;
    }


    /**
     * Sets the tempoDisponiveis value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param tempoDisponiveis
     */
    public void setTempoDisponiveis(java.lang.Double tempoDisponiveis) {
        this.tempoDisponiveis = tempoDisponiveis;
    }


    /**
     * Gets the tempoDuplicadoColeta value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return tempoDuplicadoColeta
     */
    public java.lang.Integer getTempoDuplicadoColeta() {
        return tempoDuplicadoColeta;
    }


    /**
     * Sets the tempoDuplicadoColeta value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param tempoDuplicadoColeta
     */
    public void setTempoDuplicadoColeta(java.lang.Integer tempoDuplicadoColeta) {
        this.tempoDuplicadoColeta = tempoDuplicadoColeta;
    }


    /**
     * Gets the tempoNaoDisponivel value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return tempoNaoDisponivel
     */
    public java.lang.Double getTempoNaoDisponivel() {
        return tempoNaoDisponivel;
    }


    /**
     * Sets the tempoNaoDisponivel value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param tempoNaoDisponivel
     */
    public void setTempoNaoDisponivel(java.lang.Double tempoNaoDisponivel) {
        this.tempoNaoDisponivel = tempoNaoDisponivel;
    }


    /**
     * Gets the tempoParadaAtualUltParada value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return tempoParadaAtualUltParada
     */
    public java.lang.String getTempoParadaAtualUltParada() {
        return tempoParadaAtualUltParada;
    }


    /**
     * Sets the tempoParadaAtualUltParada value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param tempoParadaAtualUltParada
     */
    public void setTempoParadaAtualUltParada(java.lang.String tempoParadaAtualUltParada) {
        this.tempoParadaAtualUltParada = tempoParadaAtualUltParada;
    }


    /**
     * Gets the tempoParadas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return tempoParadas
     */
    public java.lang.Double getTempoParadas() {
        return tempoParadas;
    }


    /**
     * Sets the tempoParadas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param tempoParadas
     */
    public void setTempoParadas(java.lang.Double tempoParadas) {
        this.tempoParadas = tempoParadas;
    }


    /**
     * Gets the tempoProdutivas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return tempoProdutivas
     */
    public java.lang.Double getTempoProdutivas() {
        return tempoProdutivas;
    }


    /**
     * Sets the tempoProdutivas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param tempoProdutivas
     */
    public void setTempoProdutivas(java.lang.Double tempoProdutivas) {
        this.tempoProdutivas = tempoProdutivas;
    }


    /**
     * Gets the tempoRefugos value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return tempoRefugos
     */
    public java.lang.Double getTempoRefugos() {
        return tempoRefugos;
    }


    /**
     * Sets the tempoRefugos value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param tempoRefugos
     */
    public void setTempoRefugos(java.lang.Double tempoRefugos) {
        this.tempoRefugos = tempoRefugos;
    }


    /**
     * Gets the tempoRitmo value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return tempoRitmo
     */
    public java.lang.Double getTempoRitmo() {
        return tempoRitmo;
    }


    /**
     * Sets the tempoRitmo value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param tempoRitmo
     */
    public void setTempoRitmo(java.lang.Double tempoRitmo) {
        this.tempoRitmo = tempoRitmo;
    }


    /**
     * Gets the tempoSemColeta value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return tempoSemColeta
     */
    public java.lang.Integer getTempoSemColeta() {
        return tempoSemColeta;
    }


    /**
     * Sets the tempoSemColeta value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param tempoSemColeta
     */
    public void setTempoSemColeta(java.lang.Integer tempoSemColeta) {
        this.tempoSemColeta = tempoSemColeta;
    }


    /**
     * Gets the tempoTotais value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return tempoTotais
     */
    public java.lang.Double getTempoTotais() {
        return tempoTotais;
    }


    /**
     * Sets the tempoTotais value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param tempoTotais
     */
    public void setTempoTotais(java.lang.Double tempoTotais) {
        this.tempoTotais = tempoTotais;
    }


    /**
     * Gets the tempoTrabalhadas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return tempoTrabalhadas
     */
    public java.lang.Double getTempoTrabalhadas() {
        return tempoTrabalhadas;
    }


    /**
     * Sets the tempoTrabalhadas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param tempoTrabalhadas
     */
    public void setTempoTrabalhadas(java.lang.Double tempoTrabalhadas) {
        this.tempoTrabalhadas = tempoTrabalhadas;
    }


    /**
     * Gets the totalPerdas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return totalPerdas
     */
    public java.lang.Double getTotalPerdas() {
        return totalPerdas;
    }


    /**
     * Sets the totalPerdas value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param totalPerdas
     */
    public void setTotalPerdas(java.lang.Double totalPerdas) {
        this.totalPerdas = totalPerdas;
    }


    /**
     * Gets the utilizacao value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return utilizacao
     */
    public java.lang.Double getUtilizacao() {
        return utilizacao;
    }


    /**
     * Sets the utilizacao value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param utilizacao
     */
    public void setUtilizacao(java.lang.Double utilizacao) {
        this.utilizacao = utilizacao;
    }


    /**
     * Gets the ciclosEficienciaUltCic value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @return ciclosEficienciaUltCic
     */
    public java.lang.Double getCiclosEficienciaUltCic() {
        return ciclosEficienciaUltCic;
    }


    /**
     * Sets the ciclosEficienciaUltCic value for this DetalheMonitorizacaoPTInjetDTO.
     * 
     * @param ciclosEficienciaUltCic
     */
    public void setCiclosEficienciaUltCic(java.lang.Double ciclosEficienciaUltCic) {
        this.ciclosEficienciaUltCic = ciclosEficienciaUltCic;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DetalheMonitorizacaoPTInjetDTO)) return false;
        DetalheMonitorizacaoPTInjetDTO other = (DetalheMonitorizacaoPTInjetDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.alertasandroidDTO==null && other.getAlertasandroidDTO()==null) || 
             (this.alertasandroidDTO!=null &&
              java.util.Arrays.equals(this.alertasandroidDTO, other.getAlertasandroidDTO()))) &&
            ((this.cav_ativas==null && other.getCav_ativas()==null) || 
             (this.cav_ativas!=null &&
              this.cav_ativas.equals(other.getCav_ativas()))) &&
            ((this.ciclosCicMedio==null && other.getCiclosCicMedio()==null) || 
             (this.ciclosCicMedio!=null &&
              this.ciclosCicMedio.equals(other.getCiclosCicMedio()))) &&
            ((this.ciclosCicPadrao==null && other.getCiclosCicPadrao()==null) || 
             (this.ciclosCicPadrao!=null &&
              this.ciclosCicPadrao.equals(other.getCiclosCicPadrao()))) &&
            ((this.ciclosEficienciaCic==null && other.getCiclosEficienciaCic()==null) || 
             (this.ciclosEficienciaCic!=null &&
              this.ciclosEficienciaCic.equals(other.getCiclosEficienciaCic()))) &&
            ((this.ciclosUltimoCic==null && other.getCiclosUltimoCic()==null) || 
             (this.ciclosUltimoCic!=null &&
              this.ciclosUltimoCic.equals(other.getCiclosUltimoCic()))) &&
            ((this.dtReferencia==null && other.getDtReferencia()==null) || 
             (this.dtReferencia!=null &&
              this.dtReferencia.equals(other.getDtReferencia()))) &&
            ((this.dtinicioOP==null && other.getDtinicioOP()==null) || 
             (this.dtinicioOP!=null &&
              this.dtinicioOP.equals(other.getDtinicioOP()))) &&
            ((this.dwFolha==null && other.getDwFolha()==null) || 
             (this.dwFolha!=null &&
              this.dwFolha.equals(other.getDwFolha()))) &&
            ((this.dwTurno==null && other.getDwTurno()==null) || 
             (this.dwTurno!=null &&
              this.dwTurno.equals(other.getDwTurno()))) &&
            ((this.efiCiclos==null && other.getEfiCiclos()==null) || 
             (this.efiCiclos!=null &&
              this.efiCiclos.equals(other.getEfiCiclos()))) &&
            ((this.efiRealizacao==null && other.getEfiRealizacao()==null) || 
             (this.efiRealizacao!=null &&
              this.efiRealizacao.equals(other.getEfiRealizacao()))) &&
            ((this.eficiclosPond==null && other.getEficiclosPond()==null) || 
             (this.eficiclosPond!=null &&
              this.eficiclosPond.equals(other.getEficiclosPond()))) &&
            ((this.eficiencia==null && other.getEficiencia()==null) || 
             (this.eficiencia!=null &&
              this.eficiencia.equals(other.getEficiencia()))) &&
            ((this.identificacaomolde==null && other.getIdentificacaomolde()==null) || 
             (this.identificacaomolde!=null &&
              this.identificacaomolde.equals(other.getIdentificacaomolde()))) &&
            this.idrt == other.getIdrt() &&
            ((this.indiceCavAtivas==null && other.getIndiceCavAtivas()==null) || 
             (this.indiceCavAtivas!=null &&
              this.indiceCavAtivas.equals(other.getIndiceCavAtivas()))) &&
            ((this.indiceParadas==null && other.getIndiceParadas()==null) || 
             (this.indiceParadas!=null &&
              this.indiceParadas.equals(other.getIndiceParadas()))) &&
            ((this.indicePerdas==null && other.getIndicePerdas()==null) || 
             (this.indicePerdas!=null &&
              this.indicePerdas.equals(other.getIndicePerdas()))) &&
            ((this.indiceRefugos==null && other.getIndiceRefugos()==null) || 
             (this.indiceRefugos!=null &&
              this.indiceRefugos.equals(other.getIndiceRefugos()))) &&
            ((this.listaAlertas==null && other.getListaAlertas()==null) || 
             (this.listaAlertas!=null &&
              java.util.Arrays.equals(this.listaAlertas, other.getListaAlertas()))) &&
            ((this.listaCiclos==null && other.getListaCiclos()==null) || 
             (this.listaCiclos!=null &&
              java.util.Arrays.equals(this.listaCiclos, other.getListaCiclos()))) &&
            ((this.listaDwConsolId==null && other.getListaDwConsolId()==null) || 
             (this.listaDwConsolId!=null &&
              java.util.Arrays.equals(this.listaDwConsolId, other.getListaDwConsolId()))) &&
            ((this.listaDwConsolidTurno==null && other.getListaDwConsolidTurno()==null) || 
             (this.listaDwConsolidTurno!=null &&
              this.listaDwConsolidTurno.equals(other.getListaDwConsolidTurno()))) &&
            ((this.listaGraficoTempoDTO==null && other.getListaGraficoTempoDTO()==null) || 
             (this.listaGraficoTempoDTO!=null &&
              java.util.Arrays.equals(this.listaGraficoTempoDTO, other.getListaGraficoTempoDTO()))) &&
            ((this.listaOperadores==null && other.getListaOperadores()==null) || 
             (this.listaOperadores!=null &&
              java.util.Arrays.equals(this.listaOperadores, other.getListaOperadores()))) &&
            ((this.listaPerdas==null && other.getListaPerdas()==null) || 
             (this.listaPerdas!=null &&
              java.util.Arrays.equals(this.listaPerdas, other.getListaPerdas()))) &&
            ((this.listaProdutos==null && other.getListaProdutos()==null) || 
             (this.listaProdutos!=null &&
              java.util.Arrays.equals(this.listaProdutos, other.getListaProdutos()))) &&
            ((this.listaTurnos==null && other.getListaTurnos()==null) || 
             (this.listaTurnos!=null &&
              java.util.Arrays.equals(this.listaTurnos, other.getListaTurnos()))) &&
            ((this.maquina==null && other.getMaquina()==null) || 
             (this.maquina!=null &&
              this.maquina.equals(other.getMaquina()))) &&
            ((this.metaHora==null && other.getMetaHora()==null) || 
             (this.metaHora!=null &&
              this.metaHora.equals(other.getMetaHora()))) &&
            ((this.molde==null && other.getMolde()==null) || 
             (this.molde!=null &&
              this.molde.equals(other.getMolde()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.operadoresandroidDTO==null && other.getOperadoresandroidDTO()==null) || 
             (this.operadoresandroidDTO!=null &&
              java.util.Arrays.equals(this.operadoresandroidDTO, other.getOperadoresandroidDTO()))) &&
            ((this.ordemproducao==null && other.getOrdemproducao()==null) || 
             (this.ordemproducao!=null &&
              this.ordemproducao.equals(other.getOrdemproducao()))) &&
            ((this.paradaAreaResponsavel==null && other.getParadaAreaResponsavel()==null) || 
             (this.paradaAreaResponsavel!=null &&
              this.paradaAreaResponsavel.equals(other.getParadaAreaResponsavel()))) &&
            ((this.paradaAtualUltParada==null && other.getParadaAtualUltParada()==null) || 
             (this.paradaAtualUltParada!=null &&
              this.paradaAtualUltParada.equals(other.getParadaAtualUltParada()))) &&
            ((this.paradaDtInicio==null && other.getParadaDtInicio()==null) || 
             (this.paradaDtInicio!=null &&
              this.paradaDtInicio.equals(other.getParadaDtInicio()))) &&
            ((this.paradaHrIncio==null && other.getParadaHrIncio()==null) || 
             (this.paradaHrIncio!=null &&
              this.paradaHrIncio.equals(other.getParadaHrIncio()))) &&
            ((this.paradaMTBF==null && other.getParadaMTBF()==null) || 
             (this.paradaMTBF!=null &&
              this.paradaMTBF.equals(other.getParadaMTBF()))) &&
            ((this.paradaMTTR==null && other.getParadaMTTR()==null) || 
             (this.paradaMTTR!=null &&
              this.paradaMTTR.equals(other.getParadaMTTR()))) &&
            ((this.paradasIndiceParadas==null && other.getParadasIndiceParadas()==null) || 
             (this.paradasIndiceParadas!=null &&
              this.paradasIndiceParadas.equals(other.getParadasIndiceParadas()))) &&
            ((this.paradasTempoParadas==null && other.getParadasTempoParadas()==null) || 
             (this.paradasTempoParadas!=null &&
              this.paradasTempoParadas.equals(other.getParadasTempoParadas()))) &&
            ((this.pci==null && other.getPci()==null) || 
             (this.pci!=null &&
              this.pci.equals(other.getPci()))) &&
            ((this.pcsPorCicloAtivas==null && other.getPcsPorCicloAtivas()==null) || 
             (this.pcsPorCicloAtivas!=null &&
              this.pcsPorCicloAtivas.equals(other.getPcsPorCicloAtivas()))) &&
            ((this.perdasCiclos==null && other.getPerdasCiclos()==null) || 
             (this.perdasCiclos!=null &&
              this.perdasCiclos.equals(other.getPerdasCiclos()))) &&
            ((this.perdasParadas==null && other.getPerdasParadas()==null) || 
             (this.perdasParadas!=null &&
              this.perdasParadas.equals(other.getPerdasParadas()))) &&
            ((this.perdasandroidDTO==null && other.getPerdasandroidDTO()==null) || 
             (this.perdasandroidDTO!=null &&
              java.util.Arrays.equals(this.perdasandroidDTO, other.getPerdasandroidDTO()))) &&
            ((this.periodo==null && other.getPeriodo()==null) || 
             (this.periodo!=null &&
              this.periodo.equals(other.getPeriodo()))) &&
            ((this.produtividadeOEE==null && other.getProdutividadeOEE()==null) || 
             (this.produtividadeOEE!=null &&
              this.produtividadeOEE.equals(other.getProdutividadeOEE()))) &&
            ((this.produtividadeOEECapital==null && other.getProdutividadeOEECapital()==null) || 
             (this.produtividadeOEECapital!=null &&
              this.produtividadeOEECapital.equals(other.getProdutividadeOEECapital()))) &&
            ((this.produto==null && other.getProduto()==null) || 
             (this.produto!=null &&
              this.produto.equals(other.getProduto()))) &&
            ((this.produtosandroidDTO==null && other.getProdutosandroidDTO()==null) || 
             (this.produtosandroidDTO!=null &&
              this.produtosandroidDTO.equals(other.getProdutosandroidDTO()))) &&
            ((this.projPCIHoras==null && other.getProjPCIHoras()==null) || 
             (this.projPCIHoras!=null &&
              this.projPCIHoras.equals(other.getProjPCIHoras()))) &&
            ((this.qtdPecasBoas==null && other.getQtdPecasBoas()==null) || 
             (this.qtdPecasBoas!=null &&
              this.qtdPecasBoas.equals(other.getQtdPecasBoas()))) &&
            ((this.qtdPrevista==null && other.getQtdPrevista()==null) || 
             (this.qtdPrevista!=null &&
              this.qtdPrevista.equals(other.getQtdPrevista()))) &&
            ((this.qtdProduzida==null && other.getQtdProduzida()==null) || 
             (this.qtdProduzida!=null &&
              this.qtdProduzida.equals(other.getQtdProduzida()))) &&
            ((this.qtdRefugadas==null && other.getQtdRefugadas()==null) || 
             (this.qtdRefugadas!=null &&
              this.qtdRefugadas.equals(other.getQtdRefugadas()))) &&
            ((this.qtdeCiclosExecutar==null && other.getQtdeCiclosExecutar()==null) || 
             (this.qtdeCiclosExecutar!=null &&
              this.qtdeCiclosExecutar.equals(other.getQtdeCiclosExecutar()))) &&
            ((this.tempoAtivo==null && other.getTempoAtivo()==null) || 
             (this.tempoAtivo!=null &&
              this.tempoAtivo.equals(other.getTempoAtivo()))) &&
            ((this.tempoBoas==null && other.getTempoBoas()==null) || 
             (this.tempoBoas!=null &&
              this.tempoBoas.equals(other.getTempoBoas()))) &&
            ((this.tempoCalendario==null && other.getTempoCalendario()==null) || 
             (this.tempoCalendario!=null &&
              this.tempoCalendario.equals(other.getTempoCalendario()))) &&
            ((this.tempoCavIsoladas==null && other.getTempoCavIsoladas()==null) || 
             (this.tempoCavIsoladas!=null &&
              this.tempoCavIsoladas.equals(other.getTempoCavIsoladas()))) &&
            ((this.tempoCiclosImprodutivos==null && other.getTempoCiclosImprodutivos()==null) || 
             (this.tempoCiclosImprodutivos!=null &&
              this.tempoCiclosImprodutivos.equals(other.getTempoCiclosImprodutivos()))) &&
            ((this.tempoCiclosProdutivos==null && other.getTempoCiclosProdutivos()==null) || 
             (this.tempoCiclosProdutivos!=null &&
              this.tempoCiclosProdutivos.equals(other.getTempoCiclosProdutivos()))) &&
            ((this.tempoDisponiveis==null && other.getTempoDisponiveis()==null) || 
             (this.tempoDisponiveis!=null &&
              this.tempoDisponiveis.equals(other.getTempoDisponiveis()))) &&
            ((this.tempoDuplicadoColeta==null && other.getTempoDuplicadoColeta()==null) || 
             (this.tempoDuplicadoColeta!=null &&
              this.tempoDuplicadoColeta.equals(other.getTempoDuplicadoColeta()))) &&
            ((this.tempoNaoDisponivel==null && other.getTempoNaoDisponivel()==null) || 
             (this.tempoNaoDisponivel!=null &&
              this.tempoNaoDisponivel.equals(other.getTempoNaoDisponivel()))) &&
            ((this.tempoParadaAtualUltParada==null && other.getTempoParadaAtualUltParada()==null) || 
             (this.tempoParadaAtualUltParada!=null &&
              this.tempoParadaAtualUltParada.equals(other.getTempoParadaAtualUltParada()))) &&
            ((this.tempoParadas==null && other.getTempoParadas()==null) || 
             (this.tempoParadas!=null &&
              this.tempoParadas.equals(other.getTempoParadas()))) &&
            ((this.tempoProdutivas==null && other.getTempoProdutivas()==null) || 
             (this.tempoProdutivas!=null &&
              this.tempoProdutivas.equals(other.getTempoProdutivas()))) &&
            ((this.tempoRefugos==null && other.getTempoRefugos()==null) || 
             (this.tempoRefugos!=null &&
              this.tempoRefugos.equals(other.getTempoRefugos()))) &&
            ((this.tempoRitmo==null && other.getTempoRitmo()==null) || 
             (this.tempoRitmo!=null &&
              this.tempoRitmo.equals(other.getTempoRitmo()))) &&
            ((this.tempoSemColeta==null && other.getTempoSemColeta()==null) || 
             (this.tempoSemColeta!=null &&
              this.tempoSemColeta.equals(other.getTempoSemColeta()))) &&
            ((this.tempoTotais==null && other.getTempoTotais()==null) || 
             (this.tempoTotais!=null &&
              this.tempoTotais.equals(other.getTempoTotais()))) &&
            ((this.tempoTrabalhadas==null && other.getTempoTrabalhadas()==null) || 
             (this.tempoTrabalhadas!=null &&
              this.tempoTrabalhadas.equals(other.getTempoTrabalhadas()))) &&
            ((this.totalPerdas==null && other.getTotalPerdas()==null) || 
             (this.totalPerdas!=null &&
              this.totalPerdas.equals(other.getTotalPerdas()))) &&
            ((this.utilizacao==null && other.getUtilizacao()==null) || 
             (this.utilizacao!=null &&
              this.utilizacao.equals(other.getUtilizacao()))) &&
            ((this.ciclosEficienciaUltCic==null && other.getCiclosEficienciaUltCic()==null) || 
             (this.ciclosEficienciaUltCic!=null &&
              this.ciclosEficienciaUltCic.equals(other.getCiclosEficienciaUltCic())));
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
        if (getAlertasandroidDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAlertasandroidDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAlertasandroidDTO(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCav_ativas() != null) {
            _hashCode += getCav_ativas().hashCode();
        }
        if (getCiclosCicMedio() != null) {
            _hashCode += getCiclosCicMedio().hashCode();
        }
        if (getCiclosCicPadrao() != null) {
            _hashCode += getCiclosCicPadrao().hashCode();
        }
        if (getCiclosEficienciaCic() != null) {
            _hashCode += getCiclosEficienciaCic().hashCode();
        }
        if (getCiclosUltimoCic() != null) {
            _hashCode += getCiclosUltimoCic().hashCode();
        }
        if (getDtReferencia() != null) {
            _hashCode += getDtReferencia().hashCode();
        }
        if (getDtinicioOP() != null) {
            _hashCode += getDtinicioOP().hashCode();
        }
        if (getDwFolha() != null) {
            _hashCode += getDwFolha().hashCode();
        }
        if (getDwTurno() != null) {
            _hashCode += getDwTurno().hashCode();
        }
        if (getEfiCiclos() != null) {
            _hashCode += getEfiCiclos().hashCode();
        }
        if (getEfiRealizacao() != null) {
            _hashCode += getEfiRealizacao().hashCode();
        }
        if (getEficiclosPond() != null) {
            _hashCode += getEficiclosPond().hashCode();
        }
        if (getEficiencia() != null) {
            _hashCode += getEficiencia().hashCode();
        }
        if (getIdentificacaomolde() != null) {
            _hashCode += getIdentificacaomolde().hashCode();
        }
        _hashCode += new Long(getIdrt()).hashCode();
        if (getIndiceCavAtivas() != null) {
            _hashCode += getIndiceCavAtivas().hashCode();
        }
        if (getIndiceParadas() != null) {
            _hashCode += getIndiceParadas().hashCode();
        }
        if (getIndicePerdas() != null) {
            _hashCode += getIndicePerdas().hashCode();
        }
        if (getIndiceRefugos() != null) {
            _hashCode += getIndiceRefugos().hashCode();
        }
        if (getListaAlertas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaAlertas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaAlertas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaCiclos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaCiclos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaCiclos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaDwConsolId() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaDwConsolId());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaDwConsolId(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaDwConsolidTurno() != null) {
            _hashCode += getListaDwConsolidTurno().hashCode();
        }
        if (getListaGraficoTempoDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaGraficoTempoDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaGraficoTempoDTO(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaOperadores() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaOperadores());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaOperadores(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaPerdas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaPerdas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaPerdas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaProdutos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaProdutos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaProdutos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaTurnos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaTurnos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaTurnos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMaquina() != null) {
            _hashCode += getMaquina().hashCode();
        }
        if (getMetaHora() != null) {
            _hashCode += getMetaHora().hashCode();
        }
        if (getMolde() != null) {
            _hashCode += getMolde().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getOperadoresandroidDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOperadoresandroidDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOperadoresandroidDTO(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOrdemproducao() != null) {
            _hashCode += getOrdemproducao().hashCode();
        }
        if (getParadaAreaResponsavel() != null) {
            _hashCode += getParadaAreaResponsavel().hashCode();
        }
        if (getParadaAtualUltParada() != null) {
            _hashCode += getParadaAtualUltParada().hashCode();
        }
        if (getParadaDtInicio() != null) {
            _hashCode += getParadaDtInicio().hashCode();
        }
        if (getParadaHrIncio() != null) {
            _hashCode += getParadaHrIncio().hashCode();
        }
        if (getParadaMTBF() != null) {
            _hashCode += getParadaMTBF().hashCode();
        }
        if (getParadaMTTR() != null) {
            _hashCode += getParadaMTTR().hashCode();
        }
        if (getParadasIndiceParadas() != null) {
            _hashCode += getParadasIndiceParadas().hashCode();
        }
        if (getParadasTempoParadas() != null) {
            _hashCode += getParadasTempoParadas().hashCode();
        }
        if (getPci() != null) {
            _hashCode += getPci().hashCode();
        }
        if (getPcsPorCicloAtivas() != null) {
            _hashCode += getPcsPorCicloAtivas().hashCode();
        }
        if (getPerdasCiclos() != null) {
            _hashCode += getPerdasCiclos().hashCode();
        }
        if (getPerdasParadas() != null) {
            _hashCode += getPerdasParadas().hashCode();
        }
        if (getPerdasandroidDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPerdasandroidDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPerdasandroidDTO(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPeriodo() != null) {
            _hashCode += getPeriodo().hashCode();
        }
        if (getProdutividadeOEE() != null) {
            _hashCode += getProdutividadeOEE().hashCode();
        }
        if (getProdutividadeOEECapital() != null) {
            _hashCode += getProdutividadeOEECapital().hashCode();
        }
        if (getProduto() != null) {
            _hashCode += getProduto().hashCode();
        }
        if (getProdutosandroidDTO() != null) {
            _hashCode += getProdutosandroidDTO().hashCode();
        }
        if (getProjPCIHoras() != null) {
            _hashCode += getProjPCIHoras().hashCode();
        }
        if (getQtdPecasBoas() != null) {
            _hashCode += getQtdPecasBoas().hashCode();
        }
        if (getQtdPrevista() != null) {
            _hashCode += getQtdPrevista().hashCode();
        }
        if (getQtdProduzida() != null) {
            _hashCode += getQtdProduzida().hashCode();
        }
        if (getQtdRefugadas() != null) {
            _hashCode += getQtdRefugadas().hashCode();
        }
        if (getQtdeCiclosExecutar() != null) {
            _hashCode += getQtdeCiclosExecutar().hashCode();
        }
        if (getTempoAtivo() != null) {
            _hashCode += getTempoAtivo().hashCode();
        }
        if (getTempoBoas() != null) {
            _hashCode += getTempoBoas().hashCode();
        }
        if (getTempoCalendario() != null) {
            _hashCode += getTempoCalendario().hashCode();
        }
        if (getTempoCavIsoladas() != null) {
            _hashCode += getTempoCavIsoladas().hashCode();
        }
        if (getTempoCiclosImprodutivos() != null) {
            _hashCode += getTempoCiclosImprodutivos().hashCode();
        }
        if (getTempoCiclosProdutivos() != null) {
            _hashCode += getTempoCiclosProdutivos().hashCode();
        }
        if (getTempoDisponiveis() != null) {
            _hashCode += getTempoDisponiveis().hashCode();
        }
        if (getTempoDuplicadoColeta() != null) {
            _hashCode += getTempoDuplicadoColeta().hashCode();
        }
        if (getTempoNaoDisponivel() != null) {
            _hashCode += getTempoNaoDisponivel().hashCode();
        }
        if (getTempoParadaAtualUltParada() != null) {
            _hashCode += getTempoParadaAtualUltParada().hashCode();
        }
        if (getTempoParadas() != null) {
            _hashCode += getTempoParadas().hashCode();
        }
        if (getTempoProdutivas() != null) {
            _hashCode += getTempoProdutivas().hashCode();
        }
        if (getTempoRefugos() != null) {
            _hashCode += getTempoRefugos().hashCode();
        }
        if (getTempoRitmo() != null) {
            _hashCode += getTempoRitmo().hashCode();
        }
        if (getTempoSemColeta() != null) {
            _hashCode += getTempoSemColeta().hashCode();
        }
        if (getTempoTotais() != null) {
            _hashCode += getTempoTotais().hashCode();
        }
        if (getTempoTrabalhadas() != null) {
            _hashCode += getTempoTrabalhadas().hashCode();
        }
        if (getTotalPerdas() != null) {
            _hashCode += getTotalPerdas().hashCode();
        }
        if (getUtilizacao() != null) {
            _hashCode += getUtilizacao().hashCode();
        }
        if (getCiclosEficienciaUltCic() != null) {
            _hashCode += getCiclosEficienciaUltCic().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DetalheMonitorizacaoPTInjetDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalheMonitorizacaoPTInjetDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alertasandroidDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "alertasandroidDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "alertaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "listaAlertasDTO"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cav_ativas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cav_ativas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ciclosCicMedio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ciclosCicMedio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ciclosCicPadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ciclosCicPadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ciclosEficienciaCic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ciclosEficienciaCic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ciclosUltimoCic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ciclosUltimoCic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtinicioOP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtinicioOP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTurno"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("efiCiclos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "efiCiclos"));
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
        elemField.setFieldName("eficiclosPond");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficiclosPond"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficiencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficiencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identificacaomolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "identificacaomolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idrt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idrt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("indicePerdas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indicePerdas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("listaAlertas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaAlertas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "alertaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaCiclos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaCiclos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "graficoCicloDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaDwConsolId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaDwConsolId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaDwConsolidTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaDwConsolidTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolidDTOs"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaGraficoTempoDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaGraficoTempoDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "graficoTempoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaOperadores");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaOperadores"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "operadorDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaPerdas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaPerdas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "perdasDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaProdutos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaProdutos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "produtoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaTurnos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaTurnos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalheMonitorizacaoPTInjetDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metaHora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metaHora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("molde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "molde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("operadoresandroidDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operadoresandroidDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "operadorDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "listaOperadoresDTO"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordemproducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordemproducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaAreaResponsavel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaAreaResponsavel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaAtualUltParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaAtualUltParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaDtInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaDtInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaHrIncio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaHrIncio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaMTBF");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaMTBF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaMTTR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaMTTR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradasIndiceParadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradasIndiceParadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradasTempoParadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradasTempoParadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pci");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pci"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsPorCicloAtivas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsPorCicloAtivas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdasCiclos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdasCiclos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdasParadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdasParadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdasandroidDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdasandroidDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "perdasDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "listaperdasDTO"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("periodo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "periodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("produtividadeOEECapital");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produtividadeOEECapital"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produtosandroidDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produtosandroidDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "produtosDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projPCIHoras");
        elemField.setXmlName(new javax.xml.namespace.QName("", "projPCIHoras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdPecasBoas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdPecasBoas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdPrevista");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdPrevista"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdProduzida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdProduzida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdRefugadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdRefugadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdeCiclosExecutar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdeCiclosExecutar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoAtivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoBoas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoBoas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoCalendario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoCalendario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoCavIsoladas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoCavIsoladas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoCiclosImprodutivos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoCiclosImprodutivos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoCiclosProdutivos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoCiclosProdutivos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoDisponiveis");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoDisponiveis"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoDuplicadoColeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoDuplicadoColeta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoNaoDisponivel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoNaoDisponivel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaAtualUltParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaAtualUltParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoProdutivas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoProdutivas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoRefugos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoRefugos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoRitmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoRitmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoSemColeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoSemColeta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoTotais");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoTotais"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoTrabalhadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoTrabalhadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalPerdas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalPerdas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("utilizacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "utilizacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ciclosEficienciaUltCic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ciclosEficienciaUltCic"));
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
