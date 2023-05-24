package idw.model.rn.relatorios.refugo.consolidado;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwFolharap;

public class GeraLinha {
    
    private Ferramenta ferramenta;
    private String posto;
    private List<Produto> produtos = new ArrayList<>();
    
    public GeraLinha(
            DAOGenerico dao,
            FiltroRelatorioRefugoConsolidadoPorMoldeDTO filtro,
            DwConsolid id,
            DwFolharap rap) {
        
        this.ferramenta = new Ferramenta(dao, filtro, id, rap);
        
        this.posto = id.getOmPt().getCdPt();
        
        for (DwConsol consol : id.getDwConsols()) {
            for (DwConsolpr consolpr : consol.getDwConsolprs()) {
                
                Produto produto = new Produto(dao, consolpr);                
                adicionar(produto);
                
            }
        }
    }
    
    public void adicionar(GeraLinha geraLinhaFerramenta) {
        this.ferramenta.adicionar(geraLinhaFerramenta.getFerramenta());
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
    
    public List<RelatorioRefugoConsolidadoPorMoldeDTO> getDTOs() {
        List<RelatorioRefugoConsolidadoPorMoldeDTO> lista = new ArrayList<>();
        
        for(Produto produto : produtos) {
            RelatorioRefugoConsolidadoPorMoldeDTO dto = new RelatorioRefugoConsolidadoPorMoldeDTO();
            
            dto.setFerramenta(ferramenta.getFerramenta());
            dto.setPosto(posto);
            dto.setCicloPadrao(ferramenta.getCicloPadraoFormatado());
            dto.setProduto(produto.getProduto());
            dto.setCicloMedio(ferramenta.getCicloMedio());
            //dto.setCavidade(ferramenta.getCavidadesAtivas());            
            dto.setCavidade(produto.getCavidade());
            dto.setPecasProduzidas(produto.getPecasProduzidas());
            dto.setPecasRefugadas(produto.getPecasRefugadas());
            dto.setPecasBoas(produto.getPecasBoas());
            
            lista.add(dto);
        }
        
        return lista;
    }

    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    public String getPosto() {
        return posto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    
    public String getChave() {
        return ferramenta.getChave() + posto;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof GeraLinha) {
            GeraLinha objeto = (GeraLinha) obj;
            if(objeto.getChave().equals(this.getChave())) {
                return true;  
            }
        }
        return false;
    }
    
    

}
