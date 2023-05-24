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
import idw.util.FormulasInjet;

public class RelatorioConsolidadosPostoRN extends AbstractRelatorioConsolidado{
	
	private final FiltroRelatorioConsolidadosDTO filtro;
	
	private Double pcsCicAtiva = 0d;
	private Double pcsCicTotal = 0d;

	private Map<Long, String> mapIndPcsCiclo = new HashMap<Long, String>();
	
    public RelatorioConsolidadosPostoRN(DAOGenerico dao, FiltroRelatorioConsolidadosDTO filtro) {
		super(dao);
		this.filtro = filtro;
	}

	//POSTO
    public SortedMap<String,List<GeraLinhaPosto>> getLinhasAgrupadoPorPosto(List<DwConsolid> consolids) {
        SortedMap<String,List<GeraLinhaPosto>> linhas = new TreeMap<String, List<GeraLinhaPosto>>();
        for (DwConsolid id : consolids) {
            GeraLinhaPosto novaLinha = new GeraLinhaPosto(getDao(), filtro, id);
            analisarAcumularPcsPorCiclo(id);
            mesclarOuContabilizarLinhasPorPosto(linhas, novaLinha);
        }
        return linhas;
    }
    
    public Double indPcsPorCiclo(){
    	return FormulasInjet.calcularIndicePcsPorCicloAtivas(new BigDecimal(pcsCicTotal) , new BigDecimal(pcsCicAtiva)).doubleValue();
    }
    
    private void analisarAcumularPcsPorCiclo(DwConsolid id){
    	if (mapIndPcsCiclo.containsKey(id.getDwFolha().getIdFolha()) == false) {
    		mapIndPcsCiclo.put(id.getDwFolha().getIdFolha(), id.getDwFolha().getCdFolha());
    		
    		pcsCicAtiva += (id.getDwConsol().getQtAutoCavativas() == null ? 0d : id.getDwConsol().getQtAutoCavativas().doubleValue());
    		pcsCicTotal += (id.getDwConsol().getQtAutoCavtotal() == null ? 0d : id.getDwConsol().getQtAutoCavtotal().doubleValue());
    	}
    }
    
    private void mesclarOuContabilizarLinhasPorPosto(Map<String,List<GeraLinhaPosto>> linhasPosto, GeraLinhaPosto novaLinha) {
        List<GeraLinhaPosto> linhasDaChave = linhasPosto.get(novaLinha.getChave());
        
        if(linhasDaChave == null) {
            linhasDaChave = new ArrayList<>();
            linhasPosto.put(novaLinha.getChave(), linhasDaChave);
        }
        
        for(GeraLinhaPosto linha: linhasDaChave) {
            
            if(linha.equals(novaLinha)) {
                linha.adicionar(novaLinha);
                return;
            }
            
        }
        
        linhasDaChave.add(novaLinha);
    }
    
    public void organizarListaPorPosto(Map<String,List<GeraLinhaPosto>> linhas) {
        Comparator<GeraLinhaPosto> comparator = new Comparator<GeraLinhaPosto>() {
            @Override
            public int compare(GeraLinhaPosto o1, GeraLinhaPosto o2) {
                String chave1 = o1.getPosto().getChave() + o1.getFerramenta().getChave();
                String chave2 = o2.getPosto().getChave() + o2.getFerramenta().getChave();
                return chave2.compareTo(chave1);
            }
        };
        
        for(String chave : linhas.keySet()) {
            Collections.sort(linhas.get(chave), comparator);
        }        
    }

    
    public RelatorioConsolidadoDTO getRelatorioAgrupadoPorPosto(
            DAOGenerico dao,
            FiltroRelatorioConsolidadosDTO filtro,
            Map<String,List<GeraLinhaPosto>> linhas) {
        
        dto = new RelatorioConsolidadoDTO();
        ciclosPadroes = new HashMap<String, BigDecimal>();
        ids = new ArrayList<>();
        
        dto.setPostos(getPostosDTO(dao, filtro, linhas));
        calcularTotaisDoRelatorio(dao, filtro, linhas);
        return dto;
    }
    
    private List<PostoConsolidadoDTO> getPostosDTO(
            DAOGenerico dao,
            FiltroRelatorioConsolidadosDTO filtro,
            Map<String,List<GeraLinhaPosto>> linhas) {
        
        List<PostoConsolidadoDTO> postosDTO = new ArrayList<>();
        
        for(String chave : linhas.keySet()) {
            List<GeraLinhaPosto> linhasDaChave = linhas.get(chave);
            GeraLinhaPosto primeiraLinhaDaChave = linhasDaChave.get(0);
            primeiraLinhaDaChave.setPrimeiraLinha(true);
            
            //contabilizando horas totais do posto
            for (int i=1; i<linhasDaChave.size(); i++) {
                primeiraLinhaDaChave.contabilizarTotal(linhasDaChave.get(i));
            }
            
            //calculando total geral do posto
            Posto postoTotal = new Posto();
            Ferramenta ferramentaTotal = new Ferramenta(dao, filtro);
            Produto produtoTotal = new Produto(filtro, dao);
            for (GeraLinhaPosto linha : linhas.get(chave)) {
                postoTotal.adicionar(linha.getPosto());
                ferramentaTotal.adicionar(linha.getFerramenta());
                for (Produto produto : linha.getProdutos()) {
                    produtoTotal.adicionar(produto);
                }
            }
            GeraLinhaPosto linhaTotal = new GeraLinhaPosto(postoTotal, ferramentaTotal, produtoTotal);
            
            //gerando dto
            for (GeraLinhaPosto linha : linhasDaChave) {
                postosDTO.add(linha.getDTO());
            }
            postosDTO.add(linhaTotal.getDTO());
            postosDTO.add(new PostoConsolidadoDTO());
        }
        
        return postosDTO;
    }
    
    /* Metodo responsavel em calcular o total geral do relatorio
     * 
     */
    private void calcularTotaisDoRelatorio(
            DAOGenerico dao,
            FiltroRelatorioConsolidadosDTO filtro,
            Map<String,List<GeraLinhaPosto>> linhas) {
        
        Posto totalTodosOsPostos = new Posto();
        Ferramenta totalTodasAsFerramentas = new Ferramenta(dao, filtro);
        Produto totalTodosOsProdutos = new Produto(filtro, dao);
        
        for(String chave : linhas.keySet()) {
            for (GeraLinhaPosto linha : linhas.get(chave)) {
                totalTodosOsPostos.adicionar(linha.getPosto());
                totalTodasAsFerramentas.adicionar(linha.getFerramenta());
                
                adicionarNoMap(linha.getPosto(), linha.getFerramenta());
                for (Produto produto : linha.getProdutos()) {
                    totalTodosOsProdutos.adicionar(produto);
                }
            }
        }
        
        adicionarIdsDoMap(totalTodasAsFerramentas);
        
        
        preencherFormatandoCamposTotaisDoRelatorioDTO(totalTodosOsPostos, totalTodasAsFerramentas, totalTodosOsProdutos, indPcsPorCiclo());
        
        
    }

}
