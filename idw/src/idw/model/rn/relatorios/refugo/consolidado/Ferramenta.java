package idw.model.rn.relatorios.refugo.consolidado;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.rn.FolhaRN;
import idw.model.rn.detalhemonitorizacao.IndicadoresDoDetalheCiclosRN;
import idw.util.AritmeticaUtil;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import ms.util.ConversaoTipos;

public class Ferramenta {
    
    private final DAOGenerico dao;
    private final FiltroRelatorioRefugoConsolidadoPorMoldeDTO filtro;
    
    private final DwConsolid id;
    private final List<DwConsolid> ids = new ArrayList<>();
    
    private String ferramenta = "";    
    private BigDecimal cicloPadrao = BigDecimal.ZERO;
    private BigDecimal cicloMedio = BigDecimal.ZERO;
    private BigDecimal cavidadesAtivas = BigDecimal.ZERO;
    
    public Ferramenta(DAOGenerico dao, FiltroRelatorioRefugoConsolidadoPorMoldeDTO filtro, DwConsolid id, DwFolharap rap) {
        this.dao = dao;
        this.id = id;
        this.filtro = filtro;
        this.ids.add(id);
        
        this.ferramenta = rap.getDwRap().getCdRap() + " - " + rap.getDwRap().getDsRap();
        
        contabilizarCavidades(rap);
        calcularValores();
    }
    
    public void adicionar(Ferramenta ferramenta) {
        DwConsolid novoId = ferramenta.getId();
        if(novoId != null) {
            this.ids.add(novoId);
        }        
        calcularValores();
    }
    
    private void calcularValores() {
        IndicadoresDoDetalheCiclosRN ciclosRN = new IndicadoresDoDetalheCiclosRN(dao);
        FiltroDetalhePTInjetDTO filtroAux = new FiltroDetalhePTInjetDTO();
        if(filtro.getPeriodoInicial() != null){
            filtroAux.setDtReferenciaInicial(filtro.getPeriodoInicial());
        } else {
            filtroAux.setDtReferenciaInicial(new Date());
        }
        calcularCicloPadrao(ciclosRN, filtroAux);
        calcularCicloMedio(ciclosRN, filtroAux);
    }
    
    private void contabilizarCavidades(DwFolharap rap) {
        // Caso nao haja cavidades na DWFolharapcoms use a producao por ciclo.
        if(rap.getDwFolharapcoms() != null || rap.getDwFolharapcoms().size() > 0) {
            for (DwFolharapcom rapcom : rap.getDwFolharapcoms()) {
                this.cavidadesAtivas = AritmeticaUtil.somar(
                        cavidadesAtivas, 
                        rapcom.getQtAtiva());
            }
        } else {
            FolhaRN folhaRN = new FolhaRN(dao);
            BigDecimal producaoPorCiclo;
            try {
                producaoPorCiclo = folhaRN.getPcsPorCicloAtivas(id.getDwFolha());
            } catch (SemPcsPorCicloAtivasException e) {
                producaoPorCiclo = null;
            }
            if (producaoPorCiclo != null) {
                this.cavidadesAtivas = AritmeticaUtil.somar(
                        cavidadesAtivas, 
                        producaoPorCiclo);
            } else {
                setarValorPadraoParaCavidades();
            }
        }
    }
    
    private void setarValorPadraoParaCavidades() {
        this.cavidadesAtivas = BigDecimal.ONE;
    }
    
    private void calcularCicloPadrao(IndicadoresDoDetalheCiclosRN ciclosRN, FiltroDetalhePTInjetDTO filtroAux) {
        this.cicloPadrao = new BigDecimal(
                ciclosRN.calcularCicloPadrao(
                        ids,
                        filtroAux));
    }
    
    private void calcularCicloMedio(IndicadoresDoDetalheCiclosRN ciclosRN, FiltroDetalhePTInjetDTO filtroAux) {
        this.cicloMedio = new BigDecimal(
                ciclosRN.calcularCicloMedio(
                        ids, 
                        filtroAux));
    }
    
    public String getChave() {
        return getFerramenta() + getCicloPadraoFormatado();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Ferramenta) {
            Ferramenta objeto = (Ferramenta) obj;
            if(objeto.getChave().equals(getChave())) {
                return true;                
            }
        }
        return false;
    }
    
    //GETTERS FORMATADO
    public String getCicloPadraoFormatado() {
        return ConversaoTipos.converteParaStringComFormat(getCicloPadrao().doubleValue(), 3) + "s";
    }
    
    //GETTERS
    public DwConsolid getId() {
        return id;
    }

    public List<DwConsolid> getIds() {
        return ids;
    }

    public String getFerramenta() {
        return ferramenta;
    }

    public BigDecimal getCicloPadrao() {
        return cicloPadrao;
    }

    public BigDecimal getCavidadesAtivas() {
        return cavidadesAtivas;
    }

    public BigDecimal getCicloMedio() {
        return cicloMedio;
    }
    
    

}
