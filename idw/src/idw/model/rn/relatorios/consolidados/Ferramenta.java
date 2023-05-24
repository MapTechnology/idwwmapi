package idw.model.rn.relatorios.consolidados;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.OmProduto;
import idw.model.rn.FolhaRN;
import idw.model.rn.detalhemonitorizacao.IndicadoresDoDetalheCiclosRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import ms.util.ConversaoTipos;

public class Ferramenta {
    
    private final DAOGenerico dao;
    private final FiltroRelatorioConsolidadosDTO filtro;
    
    private final DwConsolid id;
    private List<DwConsolid> ids = new ArrayList<>();
    
    //Marcos Sardinha: 2017-06-24 >> precisa quebrar por idFolha ... passou a ser chave
    private Long idFolha;
    private String ferramenta = "";
    
    private BigDecimal cicloPadrao = BigDecimal.ZERO;
    private BigDecimal cicloLido = BigDecimal.ZERO;
    private BigDecimal eficienciaCiclo = BigDecimal.ZERO;
    
    private BigDecimal cavidadesAtivas = BigDecimal.ZERO;
    private BigDecimal cavidadesTotais = BigDecimal.ZERO;
    private BigDecimal indiceCavidades = new BigDecimal(0);
    private BigDecimal fatorContagem = BigDecimal.ONE;
    
    //campos usados em calculos internos
    private BigDecimal cavidadesAtivasAcumulado = BigDecimal.ZERO;
    private BigDecimal cavidadesTotaisAcumulado = BigDecimal.ZERO;
    
    public Ferramenta(DAOGenerico dao, FiltroRelatorioConsolidadosDTO filtro) {
        this.dao = dao;
        this.id = null;
        this.filtro = filtro;
    }
    
    public Ferramenta(DAOGenerico dao, FiltroRelatorioConsolidadosDTO filtro, String ferramenta) {
        this.dao = dao;
        this.id = null;
        this.filtro = filtro;
        this.ferramenta = ferramenta;
    }
    
    public Ferramenta(DAOGenerico dao, FiltroRelatorioConsolidadosDTO filtro, DwConsolid id) {
    	super();
        this.dao = dao;
        this.id = id;
        this.filtro = filtro;
        adicionar(id);
        
        this.setIdFolha(id.getDwFolha().getIdFolha());
        this.ferramenta = "---";
        
        //this.ferramenta = id.getDwFolha().getIdFolha() + "---";;
        
        
        contabilizarCavidades(null, null);

        calcularValores();
        
        this.cavidadesAtivasAcumulado = this.cavidadesAtivas;
        this.cavidadesTotaisAcumulado = this.cavidadesTotais;
    }
    
    public Ferramenta(DAOGenerico dao, FiltroRelatorioConsolidadosDTO filtro, DwConsolid id, DwFolharap rap) {
    	this(dao, filtro, id, rap, null);
    }
    
    public Ferramenta(DAOGenerico dao, FiltroRelatorioConsolidadosDTO filtro, DwConsolid id, DwFolharap rap, DwConsolpr dwconsolpr) {
    	super();
        this.dao = dao;
        this.id = id;
        this.filtro = filtro;
        adicionar(id);
        
        this.setIdFolha(id.getDwFolha().getIdFolha());
        this.ferramenta = rap.getDwRap().getCdRap() + " - " + rap.getDwRap().getDsRap();
        
        if (dwconsolpr != null && dwconsolpr.getOmProduto() != null)
        	contabilizarCavidades(rap, dwconsolpr.getOmProduto());
        else
        	contabilizarCavidades(rap, null);
        calcularValores();
        
        this.cavidadesAtivasAcumulado = this.cavidadesAtivas;
        this.cavidadesTotaisAcumulado = this.cavidadesTotais;
    }
    
    public void adicionar(Ferramenta ferramenta) {
        DwConsolid novoId = ferramenta.getId();
        adicionar(novoId);
        
        this.cavidadesAtivasAcumulado = AritmeticaUtil.somar(cavidadesAtivasAcumulado, ferramenta.getCavidadesAtivas());
        this.cavidadesTotaisAcumulado = AritmeticaUtil.somar(cavidadesTotaisAcumulado, ferramenta.getCavidadesTotais());
        calcularIndiceCavidadesAcumulado();
        
        calcularValores();
    }
    
    public void adicionar(DwConsolid novoId) {
        if(novoId == null) {
            return;
        }
        
        boolean isSalvarNovoId = true;
        for(DwConsolid i : ids) {
            if(i.getIdConsolid() == novoId.getIdConsolid()) {
                isSalvarNovoId = false;
                break;
            }
        }
        
        if(isSalvarNovoId) {
            ids.add(novoId);
        }
    }
    
    public void calcularValores() {
        IndicadoresDoDetalheCiclosRN ciclosRN = new IndicadoresDoDetalheCiclosRN(dao);
        FiltroDetalhePTInjetDTO filtroAux = new FiltroDetalhePTInjetDTO();
        if(filtro.getPeriodoInicial() != null){
            filtroAux.setDtReferenciaInicial(filtro.getPeriodoInicial());
        } else {
            filtroAux.setDtReferenciaInicial(new Date());
        }
        calcularCicloPadrao(ciclosRN, filtroAux);
        calcularCicloLido(ciclosRN, filtroAux);
        
        calcularEficienciaCiclo();
        
    }
    
    private void contabilizarCavidades(DwFolharap rap, OmProduto omproduto) {
        // Caso nao haja cavidades na DWFolharapcoms use a producao por ciclo.
        if(rap != null && (rap.getDwFolharapcoms() != null || rap.getDwFolharapcoms().size() > 0)) {
            for (DwFolharapcom rapcom : rap.getDwFolharapcoms()) {
            	if (omproduto != null && omproduto.getCdProduto().equals(rapcom.getOmProduto().getCdProduto()) == false)
            		continue;
            	
                this.cavidadesAtivas = AritmeticaUtil.somar(
                        cavidadesAtivas, 
                        rapcom.getQtAtiva());
                this.cavidadesTotais = AritmeticaUtil.somar(
                        cavidadesTotais, 
                        rapcom.getQtTotal());
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
                this.cavidadesTotais = AritmeticaUtil.somar(
                        cavidadesTotais, 
                        producaoPorCiclo);
            } else {
                setarValorPadraoParaCavidades();
            }
        }
        
        calcularIndiceCavidades();
    }
    
    private void setarValorPadraoParaCavidades() {
        this.cavidadesAtivas = BigDecimal.ONE;
        this.cavidadesTotais = BigDecimal.ONE;
    }
    
    private void calcularCicloPadrao(IndicadoresDoDetalheCiclosRN ciclosRN, FiltroDetalhePTInjetDTO filtroAux) {
        this.cicloPadrao = new BigDecimal(
                ciclosRN.calcularCicloPadrao(
                        ids,
                        filtroAux));
        
    }
    
    //OBS: cicloLido = cicloMedio
    private void calcularCicloLido(IndicadoresDoDetalheCiclosRN ciclosRN, FiltroDetalhePTInjetDTO filtroAux) {
        this.cicloLido = new BigDecimal(
                ciclosRN.calcularCicloMedio(
                        ids, 
                        filtroAux));
    }
    
    private void calcularEficienciaCiclo() {
        this.eficienciaCiclo = new BigDecimal(
                FormulasInjet.calcularEficienciaCiclo(
                        cicloPadrao, 
                        cicloLido));
    }
    
    private void calcularIndiceCavidades() {
        this.indiceCavidades = 
                AritmeticaUtil.dividir(cavidadesAtivas, cavidadesTotais)
                        .multiply(new BigDecimal(100));
    }
    
    private void calcularIndiceCavidadesAcumulado() {
        this.indiceCavidades = 
                AritmeticaUtil.dividir(cavidadesAtivasAcumulado, cavidadesTotaisAcumulado)
                        .multiply(new BigDecimal(100));
    }
    
    public String getChave() {
       String retorno;
       try {
    	   retorno = getIdFolha().toString() + getCicloPadraoFormatado();
       } catch (Exception e) {
    	   retorno = "";
       }
       return retorno;
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
    
    public String getCicloLidoFormatado() {
        return ConversaoTipos.converteParaStringComFormat(getCicloLido().doubleValue(), 3) + "s";
    }
    
    public String getEficienciaCicloFormatado() {
        return ConversaoTipos.converteParaStringComFormat(getEficienciaCiclo().doubleValue(), 2);
    }
    
    public String getCavidadesAtivasFormatado() {
        return ConversaoTipos.converteParaStringComFormat(getCavidadesAtivas().doubleValue(), 0);
    }
    
    public String getCavidadesTotaisFormatado() {
        return ConversaoTipos.converteParaStringComFormat(getCavidadesTotais().doubleValue(), 0);
    }
    
    public String getIndiceCavidadesFormatado() {
        return ConversaoTipos.converteParaStringComFormat(getIndiceCavidades().doubleValue(), 2);
    }
    
    //GETTERS
    public DwConsolid getId() {
        return id;
    }

    public List<DwConsolid> getIds() {
        return ids;
    }

    public void setIds(List<DwConsolid> ids) {
        this.ids = ids;
    }

    public String getFerramenta() {
        return ferramenta;
    }

    public BigDecimal getCicloPadrao() {
        return cicloPadrao;
    }

    public BigDecimal getCicloLido() {
        return cicloLido;
    }

    public BigDecimal getEficienciaCiclo() {
        return eficienciaCiclo;
    }

    public BigDecimal getCavidadesAtivas() {
        return cavidadesAtivas;
    }

    public BigDecimal getCavidadesTotais() {
        return cavidadesTotais;
    }

    public BigDecimal getIndiceCavidades() {
        return indiceCavidades;
    }

	public Long getIdFolha() {
		return idFolha;
	}

	public void setIdFolha(Long idFolha) {
		this.idFolha = idFolha;
	}

	public BigDecimal getFatorContagem() {
		return fatorContagem;
	}

	public void setFatorContagem(BigDecimal fatorContagem) {
		this.fatorContagem = fatorContagem;
	}

	
}
