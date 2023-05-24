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
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolharap;

public class RelatorioConsolidadosFerramentaRN extends AbstractRelatorioConsolidado {
	
	private final FiltroRelatorioConsolidadosDTO filtro;
	
    public RelatorioConsolidadosFerramentaRN(DAOGenerico dao, FiltroRelatorioConsolidadosDTO filtro) {
		super(dao);
		this.filtro = filtro;
	}

	//FERRAMENTA
    public SortedMap<String,List<GeraLinhaFerramenta>> getLinhasAgrupadoPorFerramenta(List<DwConsolid> consolids) {
        SortedMap<String,List<GeraLinhaFerramenta>> linhasFerramentas = new TreeMap<String, List<GeraLinhaFerramenta>>();
        for (DwConsolid id : consolids) {
            
            for(DwFolharap rap : id.getPpCp().getDwFolha().getDwFolharaps()) {
                GeraLinhaFerramenta novaLinha = new GeraLinhaFerramenta(getDao(), filtro, id, rap);
                mesclarLinhasIguaisPorFerramenta(linhasFerramentas, novaLinha); 
                break;
            }
            
        }
        return linhasFerramentas;
    }
    
    public void mesclarLinhasIguaisPorFerramenta(Map<String,List<GeraLinhaFerramenta>> linhasFerramentas, GeraLinhaFerramenta novaLinha) {
        List<GeraLinhaFerramenta> linhasDaChave = linhasFerramentas.get(novaLinha.getChave());
        
        if(linhasDaChave == null) {
            linhasDaChave = new ArrayList<>();
            linhasFerramentas.put(novaLinha.getChave(), linhasDaChave);
        }
        
        for(GeraLinhaFerramenta linha: linhasDaChave) {
            
            if(linha.equals(novaLinha)) {
                linha.adicionar(novaLinha);
                return;
            }
            
        }
        
        linhasDaChave.add(novaLinha);
    }
    
    public void organizarListaPorFerramenta(Map<String,List<GeraLinhaFerramenta>> linhas) {
        Comparator<GeraLinhaFerramenta> comparator = new Comparator<GeraLinhaFerramenta>() {
            @Override
            public int compare(GeraLinhaFerramenta o1, GeraLinhaFerramenta o2) {
                String chave1 = o1.getFerramenta().getChave() + o1.getPosto().getChave();
                String chave2 = o2.getFerramenta().getChave() + o2.getPosto().getChave();
                return chave2.compareTo(chave1);
            }
        };
        
        for(String chave : linhas.keySet()) {
            Collections.sort(linhas.get(chave), comparator);
        }        
    }

    public RelatorioConsolidadoDTO getRelatorioAgrupadoPorFerramenta(
            DAOGenerico dao,
            FiltroRelatorioConsolidadosDTO filtro,
            Map<String,List<GeraLinhaFerramenta>> linhas) {
        
        dto = new RelatorioConsolidadoDTO();
        ciclosPadroes = new HashMap<String, BigDecimal>();
        ids = new ArrayList<>();
        
        dto.setFerramentas(getFerramentasDTO(dao, filtro, linhas));
        calcularTotaisPorFerramenta(dao, filtro, linhas);
        return dto;
    }
    
    
    
    

    private List<FerramentaConsolidadoDTO> getFerramentasDTO(
            DAOGenerico dao,
            FiltroRelatorioConsolidadosDTO filtro,
            Map<String,List<GeraLinhaFerramenta>> linhas) {
        
        List<FerramentaConsolidadoDTO> ferramentasDTO = new ArrayList<>();
        
        for(String chave : linhas.keySet()) {
            List<GeraLinhaFerramenta> linhasDaChave = linhas.get(chave);
            
            GeraLinhaFerramenta primeiraLinhaDaChave = linhasDaChave.get(0);
            primeiraLinhaDaChave.setPrimeiraLinha(true);
            
            //calculando total geral do ferramenta
            Ferramenta ferramentaTotal = new Ferramenta(dao, filtro);
            Posto postoTotal = new Posto();            
            Produto produtoTotal = new Produto(filtro, dao);
            for (GeraLinhaFerramenta linha : linhas.get(chave)) {
                ferramentaTotal.adicionar(linha.getFerramenta());
                postoTotal.adicionar(linha.getPosto());                
                for (Produto produto : linha.getProdutos()) {
                    produtoTotal.adicionar(produto);
                }
            }
            GeraLinhaFerramenta linhaTotal = new GeraLinhaFerramenta(ferramentaTotal, postoTotal, produtoTotal);
            
            //gerando dto
            for (GeraLinhaFerramenta linha : linhasDaChave) {
                ferramentasDTO.add(linha.getDTO());
            }
            ferramentasDTO.add(linhaTotal.getDTO());
            ferramentasDTO.add(new FerramentaConsolidadoDTO());
        }
        
        return ferramentasDTO;
    }
    
    private void calcularTotaisPorFerramenta(
            DAOGenerico dao,
            FiltroRelatorioConsolidadosDTO filtro,
            Map<String,List<GeraLinhaFerramenta>> linhas) {
        
        Ferramenta ferramentaTotal = new Ferramenta(dao, filtro);
        Posto postoTotal = new Posto();        
        Produto produtoTotal = new Produto(filtro, dao);
        
        for(String chave : linhas.keySet()) {
            for (GeraLinhaFerramenta linha : linhas.get(chave)) {
                ferramentaTotal.adicionar(linha.getFerramenta());
                postoTotal.adicionar(linha.getPosto());
                adicionarNoMap(linha.getPosto(), linha.getFerramenta());
                for (Produto produto : linha.getProdutos()) {
                    produtoTotal.adicionar(produto);
                }
            }
        }
        
        adicionarIdsDoMap(ferramentaTotal);
        preencherFormatandoCamposTotaisDoRelatorioDTO(postoTotal, ferramentaTotal, produtoTotal);
    }

}
