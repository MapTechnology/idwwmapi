package idw.model.rn.relatorios.consolidados;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwFolharap;

public class GeraLinhaProduto {
    
    private final Produto produto;
    private Ferramenta ferramenta;
    private final List<Posto> postos;
    
    private boolean isPrimeiraLinha;
    private final boolean isLinhaTotal;
    
    public GeraLinhaProduto(DAOGenerico dao, FiltroRelatorioConsolidadosDTO filtro, DwConsolid id, DwConsolpr consolpr) {
    	super();
        this.ferramenta = new Ferramenta(dao, filtro);
        this.postos = new ArrayList<>();
        this.isLinhaTotal = false;
        
        /* Em alguns casos a folha nao tera nenhuma ferramenta associada. Mesmo assim é necessário preencher ferramenta para
         * poder vim os dados de ciclo
         * Alem disso a ferramenta deve considerar o produto afim de obter a cav ativas correta
         */

        
        //Marcos Sardinha: 2017-07-18 >> Defeito #4079
        
        /*
        if (id.getPpCp().getDwFolha().getDwFolharaps().isEmpty()) {
        	this.ferramenta = new Ferramenta(dao, filtro, id);
        } else {
	        for(DwFolharap rapAux : id.getPpCp().getDwFolha().getDwFolharaps()) {
	            this.ferramenta = new Ferramenta(dao, filtro, id, rapAux, consolpr);
	        }
        } 
        */
        
        if (id.getDwFolha().getDwFolharaps().isEmpty()) {
        	this.ferramenta = new Ferramenta(dao, filtro, id);
        } else {
	        for(DwFolharap rapAux : id.getDwFolha().getDwFolharaps()) {
	            this.ferramenta = new Ferramenta(dao, filtro, id, rapAux, consolpr);
	        }
        } 

        
        this.produto = new Produto(filtro, ferramenta.getFerramenta(), consolpr, dao);
        
        Posto posto = new Posto(dao, id);
        adicionar(posto);
        
        this.produto.setTempoAtivo(posto.getTempoAtivo());
        this.produto.setCicloPadrao(ferramenta.getCicloPadrao());
        this.produto.setCavidadesAtivas(ferramenta.getCavidadesAtivas());
        this.produto.setFatorContagem(ferramenta.getFatorContagem());
        this.produto.calcularProducaoPrevista();
    }
    
    public GeraLinhaProduto(Produto produto, Ferramenta ferramenta, Posto posto) {
    	super();
        this.produto = produto;
        this.ferramenta = ferramenta;
        this.postos = new ArrayList<>();
        adicionar(posto);
        this.isLinhaTotal = true;
    }
    
    public void adicionar(GeraLinhaProduto geraLinhaProduto) {
        this.produto.adicionar(geraLinhaProduto.getProduto());
        this.ferramenta.adicionar(geraLinhaProduto.getFerramenta());
        for(Posto postoNovo : geraLinhaProduto.getPostos()) {
            adicionar(postoNovo);
        }
    }
    
    public void adicionar(Posto postoNovo) {
        boolean isAdicionarPostoNovaNaLista = true;
        for (Posto posto : postos) {
            if (posto.equals(postoNovo)) {
                posto.adicionar(postoNovo);
                isAdicionarPostoNovaNaLista = false;
            }
        }

        if (isAdicionarPostoNovaNaLista) {
            postos.add(postoNovo);
        }

    }
    
    public ProdutoConsolidadoDTO getDTO() {
        return getDTO(produto, ferramenta, postos);
    }
    
    private ProdutoConsolidadoDTO getDTO(Produto produto, Ferramenta ferramenta, List<Posto> postos) {
        ProdutoConsolidadoDTO dto = new ProdutoConsolidadoDTO();
        dto.setProduto(produto.getProduto());
        dto.setPecasPrevistas(produto.getPecasPrevistasFormatado());
        dto.setPecasProduzidas(produto.getPecasProduzidasFormatado());
        dto.setPecasRefugadas(produto.getPecasRefugadasFormatado());
        dto.setPecasBoas(produto.getPecasBoasFormatado());
        dto.setIndiceRefugo(produto.getIndiceRefugoFormatado());
        dto.setEficienciaRealizacao(produto.getEficienciaRealizacaoFormatado());
        
        List<ProdutoFerramentaDTO> ferramentasDTO = new ArrayList<>();
        ProdutoFerramentaDTO ferramentaDTO = new ProdutoFerramentaDTO();
        ferramentaDTO.setFerramenta(ferramenta.getFerramenta());
        ferramentaDTO.setCicloPadrao(ferramenta.getCicloPadraoFormatado());
        ferramentaDTO.setCicloLido(ferramenta.getCicloLidoFormatado());
        ferramentaDTO.setEficienciaCiclo(ferramenta.getEficienciaCicloFormatado());
        ferramentaDTO.setCavidadesAtivas(ferramenta.getCavidadesAtivasFormatado());
        ferramentaDTO.setCavidadesTotais(ferramenta.getCavidadesTotaisFormatado());
        ferramentaDTO.setIndiceCavidades(ferramenta.getIndiceCavidadesFormatado());
        
        List<ProdutoFerramentaPostoDTO> postosDTO = new ArrayList<>();
        for(Posto posto : postos) {
            ProdutoFerramentaPostoDTO postoDTO = new ProdutoFerramentaPostoDTO();
            postoDTO.setPosto(posto.getPosto());
            postoDTO.setTon(posto.getTonFormatado());
            postoDTO.setHorasTrabalhadas(posto.getHorasTrabalhadasFormatado());
            postoDTO.setHorasParadas(posto.getHorasParadasFormatado());
            postoDTO.setTempoAtivo(posto.getTempoAtivoFormatado());
            postoDTO.setIndiceParadas(posto.getIndiceParadasFormatado());
            postoDTO.setOee(posto.getOeeFormatado());
            postoDTO.setOeeCap(posto.getOeeCapFormatado());
            
            postosDTO.add(postoDTO);
        }
        
        ferramentaDTO.setPostos(postosDTO);
        ferramentasDTO.add(ferramentaDTO);
        dto.setFerramentas(ferramentasDTO);
        
        dto.setPrimeiraLinha(isPrimeiraLinha);
        dto.setLinhaTotal(isLinhaTotal);
        return dto;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof GeraLinhaProduto) {
            GeraLinhaProduto objeto = (GeraLinhaProduto) obj;
            if(objeto.getProduto().getChave().equals(produto.getChave())) {
                if(objeto.getFerramenta().getChave().equals(getFerramenta().getChave())) {
                    return true;
                }            	
            }
        }
        return false;
    }
    
    public String getChave() {
        return getProduto().getChave();
    }

    public Produto getProduto() {
        return produto;
    }

    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    public List<Posto> getPostos() {
        return postos;
    }
    
    public boolean isPrimeiraLinha() {
        return isPrimeiraLinha;
    }

    public void setPrimeiraLinha(boolean isPrimeiraLinha) {
        this.isPrimeiraLinha = isPrimeiraLinha;
    }
    
}
