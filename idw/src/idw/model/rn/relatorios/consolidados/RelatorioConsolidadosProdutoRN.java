package idw.model.rn.relatorios.consolidados;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;

public class RelatorioConsolidadosProdutoRN extends AbstractRelatorioConsolidado{
	
	private final FiltroRelatorioConsolidadosDTO filtro;
	
    public RelatorioConsolidadosProdutoRN(DAOGenerico dao, FiltroRelatorioConsolidadosDTO filtro) {
		super(dao);
		this.filtro = filtro;
	}

    public RelatorioConsolidadoDTO getRelatorioAgrupadoPorProduto(
            DAOGenerico dao,
            FiltroRelatorioConsolidadosDTO filtro,
            Map<String,List<GeraLinhaProduto>> linhas) {
        
        dto = new RelatorioConsolidadoDTO();
        ciclosPadroes = new HashMap<String, BigDecimal>();
        ids = new ArrayList<>();
        
        dto.setProdutos(getProdutosDTO(dao, filtro, linhas));
        calcularTotaisPorProduto(dao, filtro, linhas);
        return dto;
    }


    //PRODUTO
    public SortedMap<String,List<GeraLinhaProduto>> getLinhasAgrupadoPorProduto(List<DwConsolid> consolids) {
        SortedMap<String,List<GeraLinhaProduto>> linhasProdutos = new TreeMap<String, List<GeraLinhaProduto>>();
        
        for (DwConsolid id : consolids) {
            for (DwConsol consol : id.getDwConsols()) {
                for (DwConsolpr consolpr : consol.getDwConsolprs()) {
                    GeraLinhaProduto novaLinha = new GeraLinhaProduto(getDao(), filtro, id, consolpr);
                    mesclarLinhasIguaisPorProduto(linhasProdutos, novaLinha);
                }
            }
        }

        return linhasProdutos;
    }
    
    private void mesclarLinhasIguaisPorProduto(Map<String,List<GeraLinhaProduto>> linhasProdutos, GeraLinhaProduto novaLinha) {
        List<GeraLinhaProduto> linhasDaChave = linhasProdutos.get(novaLinha.getChave());
        
        if(linhasDaChave == null) {
            linhasDaChave = new ArrayList<>();
            linhasProdutos.put(novaLinha.getChave(), linhasDaChave);
        }
        
        for(GeraLinhaProduto linha: linhasDaChave) {
            
            if(linha.equals(novaLinha)) {
                linha.adicionar(novaLinha);
                return;
            }
            
        }
        
        linhasDaChave.add(novaLinha);
    }
    
    public void organizarListaPorProduto(Map<String,List<GeraLinhaProduto>> linhas) {
        Comparator<GeraLinhaProduto> comparator = new Comparator<GeraLinhaProduto>() {
            @Override
            public int compare(GeraLinhaProduto o1, GeraLinhaProduto o2) {
            	 //Marcos Sardinha: 2017-06-24 >> precisa quebrar por idFolha ... passou a ser chave
                //String chave1 = o1.getProduto().getProduto() + o1.getFerramenta().getFerramenta();
                //String chave2 = o2.getProduto().getProduto() + o2.getFerramenta().getFerramenta();
            	String chave1 = o1.getProduto().getProduto() + o1.getFerramenta().getIdFolha();
                String chave2 = o2.getProduto().getProduto() + o2.getFerramenta().getIdFolha();                
            	return chave2.compareTo(chave1);
            }
        };
        
        for(String chave : linhas.keySet()) {
            Collections.sort(linhas.get(chave), comparator);
        }        
    }

    private List<ProdutoConsolidadoDTO> getProdutosDTO(
            DAOGenerico dao,
            FiltroRelatorioConsolidadosDTO filtro,
            Map<String,List<GeraLinhaProduto>> linhas) {
        
        List<ProdutoConsolidadoDTO> retorno = new ArrayList<>();
        
        // Linhas tem a relacao de todos os produtos. Devemos iteragir sobre essa relacao e calcular o total do produto
        for(String chave : linhas.keySet()) {
            List<GeraLinhaProduto> linhasDaChave = linhas.get(chave);
            
            GeraLinhaProduto primeiraLinhaDaChave = linhasDaChave.get(0);
            primeiraLinhaDaChave.setPrimeiraLinha(true);
            
            //calculando total geral do produto
            Produto produtoTotal = new Produto(filtro, dao);
            Ferramenta ferramentaTotal = new Ferramenta(dao, filtro);
            Posto postoTotal = new Posto();            
            
            // Iterage novamente sobre linhas para calcular total do produto
            for (GeraLinhaProduto linha : linhas.get(chave)) {
                produtoTotal.adicionar(linha.getProduto());
                ferramentaTotal.adicionar(linha.getFerramenta());
                for (Posto posto : linha.getPostos()) {
                    postoTotal.adicionar(posto);
                }
            }
            GeraLinhaProduto linhaTotal = new GeraLinhaProduto(produtoTotal, ferramentaTotal, postoTotal);
            
            //gerando dto
            for (GeraLinhaProduto linha : linhasDaChave) {
                retorno.add(linha.getDTO());
            }
            retorno.add(linhaTotal.getDTO());
            retorno.add(new ProdutoConsolidadoDTO());
        }
        
        return retorno;
    }
    
    private void calcularTotaisPorProduto(
            DAOGenerico dao,
            FiltroRelatorioConsolidadosDTO filtro,
            Map<String,List<GeraLinhaProduto>> linhas) {
        
        Produto produtoTotal = new Produto(filtro, dao);
        Ferramenta ferramentaTotal = new Ferramenta(dao, filtro);
        Posto postoTotal = new Posto();
        
        //evita duplicacao das horas do posto no valor total.
        List<String> chaves = new ArrayList<>();
        
        for(String key : linhas.keySet()) {
            for (GeraLinhaProduto linha : linhas.get(key)) {
                produtoTotal.adicionar(linha.getProduto());
                ferramentaTotal.adicionar(linha.getFerramenta());
                
                for (Posto posto : linha.getPostos()) {
                    
                    String chave = "";
                    chave += linha.getFerramenta().getChave();
                    chave += linha.getFerramenta().getCavidadesAtivasFormatado();
                    chave += linha.getFerramenta().getCavidadesTotaisFormatado();
                    chave += posto.getChave();
                    
                    if(!chaves.contains(chave)) {
                        chaves.add(chave);
                        postoTotal.adicionar(posto);
                        adicionarNoMap(posto, linha.getFerramenta());
                    }
                    
                }
            }
        }
        
        adicionarIdsDoMap(ferramentaTotal);
        preencherFormatandoCamposTotaisDoRelatorioDTO(postoTotal, ferramentaTotal, produtoTotal);
    }
}
