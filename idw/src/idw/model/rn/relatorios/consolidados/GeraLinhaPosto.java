package idw.model.rn.relatorios.consolidados;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwFolharap;

public class GeraLinhaPosto {

    private final Posto posto;
    private Ferramenta ferramenta;
    private final List<Produto> produtos;
    
    private boolean isPrimeiraLinha;
    private final boolean isLinhaTotal;
    	
    public GeraLinhaPosto(DAOGenerico dao, FiltroRelatorioConsolidadosDTO filtro, DwConsolid id) {
        this.posto = new Posto(dao, id);
        this.ferramenta = new Ferramenta(dao, filtro);
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
                produto.setTempoAtivo(consol.getSegAutoTempoativo());
                produto.setCicloPadrao(ferramenta.getCicloPadrao());
                produto.setCavidadesAtivas(ferramenta.getCavidadesAtivas());
                produto.setFatorContagem(ferramenta.getFatorContagem());
                produto.calcularProducaoPrevista();
                
                adicionar(produto);
            }
        }
    }
    
    public GeraLinhaPosto(Posto posto, Ferramenta ferramenta, Produto produto) {
    	super();
    	
        this.posto = posto;
        this.ferramenta = ferramenta;
        this.produtos = new ArrayList<>();
        this.produtos.add(produto);
        this.isLinhaTotal = true;
    }
    
    public void contabilizarTotal(GeraLinhaPosto geraLinhaPosto) {
        this.posto.contabilizarTotal(geraLinhaPosto.getPosto());
    }
    
    public void adicionar(GeraLinhaPosto geraLinhaPosto) {
        this.posto.adicionar(geraLinhaPosto.getPosto());
        this.ferramenta.adicionar(geraLinhaPosto.getFerramenta());
        for(Produto produtoNovo : geraLinhaPosto.getProdutos()) {
            adicionar(produtoNovo);
        }
    }
    
    private void adicionar(Produto produtoNovo) {
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
    
    public PostoConsolidadoDTO getDTO() {
        return getDTO(posto, ferramenta, produtos);
    }
    
    private PostoConsolidadoDTO getDTO(Posto posto, Ferramenta ferramentas, List<Produto> produtos) {
        PostoConsolidadoDTO dto = new PostoConsolidadoDTO();
        dto.setPosto(posto.getPosto());
        dto.setTon(posto.getTonFormatado());
        dto.setHorasTrabalhadas(posto.getHorasTrabalhadasFormatado());
        dto.setHorasParadas(posto.getHorasParadasFormatado());
        dto.setTempoAtivo(posto.getTempoAtivoFormatado());
        dto.setIndiceParadas(posto.getIndiceParadasFormatado());
        dto.setOee(posto.getOeeFormatado());
        dto.setOeeCap(posto.getOeeCapFormatado());
        dto.setIndPcsCiclo(posto.getIndPcsCicloFormatado());
        
        List<PostoFerramentaDTO> ferramentasDTO = new ArrayList<>();
        PostoFerramentaDTO ferramentaDTO = new PostoFerramentaDTO();
        ferramentaDTO.setFerramenta(ferramenta.getFerramenta());
        ferramentaDTO.setCicloPadrao(ferramenta.getCicloPadraoFormatado());
        ferramentaDTO.setCicloLido(ferramenta.getCicloLidoFormatado());
        ferramentaDTO.setEficienciaCiclo(ferramenta.getEficienciaCicloFormatado());
        ferramentaDTO.setCavidadesAtivas(ferramenta.getCavidadesAtivasFormatado());
        ferramentaDTO.setCavidadesTotais(ferramenta.getCavidadesTotaisFormatado());
        ferramentaDTO.setIndiceCavidades(ferramenta.getIndiceCavidadesFormatado());
        
        List<PostoFerramentaProdutoDTO> produtosDTO = new ArrayList<>();
        for(Produto produto : produtos) {
            PostoFerramentaProdutoDTO produtoDTO = new PostoFerramentaProdutoDTO();
            produtoDTO.setProduto(produto.getProduto());
            produtoDTO.setPecasPrevistas(produto.getPecasPrevistasFormatado());
            produtoDTO.setPecasProduzidas(produto.getPecasProduzidasFormatado());
            produtoDTO.setPecasRefugadas(produto.getPecasRefugadasFormatado());
            produtoDTO.setPecasBoas(produto.getPecasBoasFormatado());
            produtoDTO.setIndiceRefugo(produto.getIndiceRefugoFormatado());
            produtoDTO.setEficienciaRealizacao(produto.getEficienciaRealizacaoFormatado());
            produtosDTO.add(produtoDTO);
        }
        
        ferramentaDTO.setProdutos(produtosDTO);
        ferramentasDTO.add(ferramentaDTO);        
        dto.setFerramentas(ferramentasDTO);
        
        dto.setPrimeiraLinha(isPrimeiraLinha);
        dto.setLinhaTotal(isLinhaTotal);
        return dto;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof GeraLinhaPosto) {
            GeraLinhaPosto objeto = (GeraLinhaPosto) obj;
            if(objeto.getPosto().getChave().equals(getPosto().getChave())) {
                if(objeto.getFerramenta().getChave().equals(getFerramenta().getChave())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public String getChave() {
        return getPosto().getChave();
    }
    
    public Posto getPosto() {
        return posto;
    }

    public Ferramenta getFerramenta() {
        return ferramenta;
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
