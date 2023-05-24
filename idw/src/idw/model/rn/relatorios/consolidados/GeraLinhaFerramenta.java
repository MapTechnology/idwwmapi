package idw.model.rn.relatorios.consolidados;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwFolharap;

public class GeraLinhaFerramenta {
    
    private Ferramenta ferramenta;
    private final Posto posto;
    private final List<Produto> produtos;
    
    private boolean isPrimeiraLinha;
    private final boolean isLinhaTotal;
    
    public GeraLinhaFerramenta(DAOGenerico dao, FiltroRelatorioConsolidadosDTO filtro, DwConsolid id, DwFolharap rap) {        
        super();
        this.posto = new Posto(dao, id);
        this.produtos = new ArrayList<>();
        this.isLinhaTotal = false;
        
        for (DwConsol consol : id.getDwConsols()) {
            for (DwConsolpr consolpr : consol.getDwConsolprs()) {
                
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
                
                Produto produto = new Produto(filtro, ferramenta.getFerramenta(), consolpr, dao);
                produto.setTempoAtivo(posto.getTempoAtivo());
                produto.setCicloPadrao(ferramenta.getCicloPadrao());
                produto.setCavidadesAtivas(ferramenta.getCavidadesAtivas());
                produto.setFatorContagem(ferramenta.getFatorContagem());
                produto.calcularProducaoPrevista();
                
                adicionar(produto);
            }
        }
    }
    
    public GeraLinhaFerramenta(Ferramenta ferramenta, Posto posto, Produto produto) {
        this.ferramenta = ferramenta;
        this.posto = posto;        
        this.produtos = new ArrayList<>();
        this.produtos.add(produto);
        this.isLinhaTotal = true;
    }
    
    public void adicionar(GeraLinhaFerramenta geraLinhaFerramenta) {
        this.ferramenta.adicionar(geraLinhaFerramenta.getFerramenta());
        this.posto.adicionar(geraLinhaFerramenta.getPosto());
        for(Produto produtoNovo : geraLinhaFerramenta.getProdutos()) {
            adicionar(produtoNovo);
        }
    }
    
    public void adicionar(Produto produtoNovo) {
        boolean isAdicionarProdutoNovaNaLista = true;              
        for (Produto produto : produtos) {
            if (produto.equals(produtoNovo)) {
                produto.adicionar(produtoNovo);
                isAdicionarProdutoNovaNaLista = false;
            }
        }

        if (isAdicionarProdutoNovaNaLista) {
            produtos.add(produtoNovo);
        }

    }
    
    public FerramentaConsolidadoDTO getDTO() {
        return getDTO(ferramenta, posto, produtos);
    }
    
    private FerramentaConsolidadoDTO getDTO(Ferramenta ferramenta, Posto posto, List<Produto> produtos) {
        FerramentaConsolidadoDTO dto = new FerramentaConsolidadoDTO();
        dto.setFerramenta(ferramenta.getFerramenta());
        dto.setCicloPadrao(ferramenta.getCicloPadraoFormatado());
        dto.setCicloLido(ferramenta.getCicloLidoFormatado());
        dto.setEficienciaCiclo(ferramenta.getEficienciaCicloFormatado());
        dto.setCavidadesAtivas(ferramenta.getCavidadesAtivasFormatado());
        dto.setCavidadesTotais(ferramenta.getCavidadesTotaisFormatado());
        dto.setIndiceCavidades(ferramenta.getIndiceCavidadesFormatado());
        
        List<FerramentaPostoDTO> postosDTO = new ArrayList<>();
        FerramentaPostoDTO postoDTO = new FerramentaPostoDTO();
        postoDTO.setPosto(posto.getPosto());
        postoDTO.setTon(posto.getTonFormatado());
        postoDTO.setHorasTrabalhadas(posto.getHorasTrabalhadasFormatado());
        postoDTO.setHorasParadas(posto.getHorasParadasFormatado());
        postoDTO.setTempoAtivo(posto.getTempoAtivoFormatado());
        postoDTO.setIndiceParadas(posto.getIndiceParadasFormatado());
        postoDTO.setOee(posto.getOeeFormatado());
        postoDTO.setOeeCap(posto.getOeeCapFormatado());
        
        List<FerramentaPostoProdutoDTO> produtosDTO = new ArrayList<>();
        for(Produto produto : produtos) {
            FerramentaPostoProdutoDTO produtoDTO = new FerramentaPostoProdutoDTO();
            produtoDTO.setProduto(produto.getProduto());
            produtoDTO.setPecasPrevistas(produto.getPecasPrevistasFormatado());
            produtoDTO.setPecasProduzidas(produto.getPecasProduzidasFormatado());
            produtoDTO.setPecasRefugadas(produto.getPecasRefugadasFormatado());
            produtoDTO.setPecasBoas(produto.getPecasBoasFormatado());
            produtoDTO.setIndiceRefugo(produto.getIndiceRefugoFormatado());
            produtoDTO.setEficienciaRealizacao(produto.getEficienciaRealizacaoFormatado());
            produtosDTO.add(produtoDTO);
        }
        
        postoDTO.setProdutos(produtosDTO);
        postosDTO.add(postoDTO);
        dto.setPostos(postosDTO);
        
        dto.setPrimeiraLinha(isPrimeiraLinha);
        dto.setLinhaTotal(isLinhaTotal);
        return dto;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof GeraLinhaFerramenta) {
            GeraLinhaFerramenta objeto = (GeraLinhaFerramenta) obj;
            if(objeto.getFerramenta().getChave().equals(getFerramenta().getChave())) {
                if(objeto.getPosto().getChave().equals(getPosto().getChave())) {
                    return true;
                }                
            }
        }
        return false;
    }
    
    public String getChave() {
        return getFerramenta().getFerramenta();
    }

    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    public Posto getPosto() {
        return posto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    
    public boolean isPrimeiraLinha() {
        return isPrimeiraLinha;
    }

    public void setPrimeiraLinha(boolean isPrimeiraLinha) {
        this.isPrimeiraLinha = isPrimeiraLinha;
    }

}
