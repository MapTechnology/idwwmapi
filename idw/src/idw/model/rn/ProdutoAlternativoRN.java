package idw.model.rn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.OmProaltglo;
import idw.model.pojos.OmProduto;
import idw.model.pojos.PpCmcom;

public class ProdutoAlternativoRN extends AbstractRN<DAOGenerico>{

	public ProdutoAlternativoRN(){
		this(null);
	}


	public ProdutoAlternativoRN(DAOGenerico dao){
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public List<OmProaltglo> getTodosAlternativosDiretos(){
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("SELECT omProaltglo FROM OmProaltglo omProaltglo");
		q.append("INNER JOIN FETCH omProaltglo.omProdutoByIdProdutoFilho omProdutoByIdProdutoFilho");
		q.append("INNER JOIN FETCH omProaltglo.omProdutoBySemiacabado omProdutoBySemiacabado");
		q.append("INNER JOIN FETCH omProaltglo.omProdutoByIdProdutoMae omProdutoByIdProdutoMae");
		
		return q.list();
	}
	
	public List<OmProaltglo> getListaAlternativoDiretoComSemiacabadoPassandoListaProdutoOriginal(Collection<OmProduto> listOmProdutoSemiAcabado){
		
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("SELECT omProaltglo FROM OmProaltglo omProaltglo");
		q.append("INNER JOIN FETCH omProaltglo.omProdutoByIdProdutoFilho omProdutoByIdProdutoFilho");
		q.append("INNER JOIN FETCH omProaltglo.omProdutoBySemiacabado omProdutoBySemiacabado");
		q.append("INNER JOIN FETCH omProaltglo.omProdutoByIdProdutoMae omProdutoByIdProdutoMae");
		q.append("WHERE omProdutoBySemiacabado IN (:produtos) ");
		
		List<Object> produtos = new ArrayList<Object>();
		produtos.addAll(listOmProdutoSemiAcabado);
		
		q.defineListaParametro("produtos", produtos);
		
		return q.list();
	}

	public List<OmProduto> getListaProdutoFilhoDeOmProaltglo(Collection<OmProaltglo> listaOmProaltglo){
		List<OmProduto> listaProdutos = new ArrayList<OmProduto>();
		for(OmProaltglo omProaltglo: listaOmProaltglo){
			listaProdutos.add(omProaltglo.getOmProdutoByIdProdutoFilho());
		}
		return listaProdutos;
	}	

	public List<PpCmcom> getListaAlternativoNADeProdutosProducaoPassandoListaProdutoOriginal(Collection<OmProduto> listOmProdutoSemiAcabado){
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("SELECT ppCmcom FROM PpCmcom ppCmcom");
		q.append("INNER JOIN FETCH ppCmcom.ppCm ppCm ");
		q.append("INNER JOIN FETCH ppCmcom.omProdutoByIdProdutoentra omProdutoByIdProdutoentra ");
		q.append("INNER JOIN FETCH ppCmcom.omProdutoByIdProdutosai omProdutoByIdProdutosai ");
		q.append("INNER JOIN FETCH ppCmcom.omProdutoByFinal omProdutoByFinal ");
		q.append("WHERE omProdutoByFinal IN (:produtos) ");
		
		List<Object> produtos = new ArrayList<Object>();
		produtos.addAll(listOmProdutoSemiAcabado);
		
		q.defineListaParametro("produtos", produtos);
		
		return q.list();
	}
	
	public List<PpCmcom> getTodosProdutosAlternativoNA(){
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("SELECT ppCmcom FROM PpCmcom ppCmcom");
		q.append("INNER JOIN FETCH ppCmcom.ppCm ppCm ");
		q.append("LEFT JOIN FETCH ppCmcom.omProdutoByIdProdutoentra omProdutoByIdProdutoentra ");
		q.append("LEFT JOIN FETCH ppCmcom.omProdutoByIdProdutosai omProdutoByIdProdutosai ");
		q.append("INNER JOIN FETCH ppCmcom.omProdutoByFinal omProdutoByFinal ");
		
		return q.list();
	}
	
	public Map<String, OmProduto> getTodosProdutosAlternativosDoPlanoProducao(Map<String, OmProduto> produtosPlano){
		List<PpCmcom> produtosNA =  getTodosProdutosAlternativoNADoPlanoProducao(produtosPlano);
		List<OmProaltglo> produtosDireto = getTodosProdutosAlternativoDiretoDoPlanoProducao(produtosPlano);
		
		Map<String, OmProduto> produtosAlternativos = new HashMap<String, OmProduto>();
		produtosAlternativos.putAll(getMapProdutosAlternativosNAPassandoPpcmcoms(produtosNA));
		produtosAlternativos.putAll(getMapProdutosAlternativosDiretoPassandoOmProaltglos(produtosDireto));
		
		return produtosAlternativos;
		
	}
	
	public List<PpCmcom> getTodosProdutosAlternativoNADoPlanoProducao(Map<String, OmProduto> produtosPlano){
		List<PpCmcom> produtosAlternativosNA = getTodosProdutosAlternativoNA();
		List<PpCmcom> produtosAlternativosNADoPlanoProducao = new ArrayList<PpCmcom>();
		
		for(PpCmcom ppCmcom: produtosAlternativosNA){
			
			if(produtosPlano.containsKey(ppCmcom.getOmProdutoByFinal().getCdProduto())){
				
				if(ppCmcom.getOmProdutoByIdProdutosai() != null){
					
					if(produtosPlano.containsKey(ppCmcom.getOmProdutoByIdProdutosai().getCdProduto()) == false){
						continue;
					}
										
				}
				
				produtosAlternativosNADoPlanoProducao.add(ppCmcom);
				
			}
			
		}
		
		return produtosAlternativosNADoPlanoProducao;
		
	}

	public List<OmProaltglo> getTodosProdutosAlternativoDiretoDoPlanoProducao(Map<String, OmProduto> produtosPlano){
		List<OmProaltglo> produtosAlternativosDireto = getTodosAlternativosDiretos();
		List<OmProaltglo> produtosAlternativosDiretoDoPlanoProducao = new ArrayList<OmProaltglo>();
		
		for(OmProaltglo omProaltglo: produtosAlternativosDireto){
			
			if(produtosPlano.containsKey(omProaltglo.getOmProdutoBySemiacabado().getCdProduto())){
				
				if(omProaltglo.getOmProdutoByIdProdutoMae() != null){
					
					if(produtosPlano.containsKey(omProaltglo.getOmProdutoByIdProdutoMae().getCdProduto()) == false){
						continue;
					}
										
				}
				
				produtosAlternativosDiretoDoPlanoProducao.add(omProaltglo);
				
			}
			
		}
		
		return produtosAlternativosDiretoDoPlanoProducao;
		
	}

	public List<OmProduto> getListaProdutoAlternativoDeListaAlternativoNA(Collection<PpCmcom> listaPpCmcom){
		List<OmProduto> listaProdutos = new ArrayList<OmProduto>();
		for(PpCmcom ppCmcom: listaPpCmcom){
			listaProdutos.add(ppCmcom.getOmProdutoByIdProdutoentra());
		}
		return listaProdutos;
	}
	
//	public Map<String, OmProduto> getMapProdutosAlternativosTodosOsTiposDeSemiacabados(Collection<OmProduto> produtosSemiacabados){
//		
//		Map<String, OmProduto> mapProdutos = new HashMap<String, OmProduto>();
//			
//		Map<String, OmProduto> mapProdutosNA = getMapProdutosAlternativosNADeSemiacabadosPassandoOmProdutos(produtosSemiacabados);
//		mapProdutos.putAll(mapProdutosNA);
//				
//		Map<String, OmProduto> mapProdutosDireto = getMapProdutosAlternativosDiretoDeSemiacabadosPassandoOmProdutos(produtosSemiacabados);
//		mapProdutos.putAll(mapProdutosDireto);
//		
//		return mapProdutos;
//	}
	
//	private Map<String, OmProduto> getMapProdutosAlternativosNADeSemiacabadosPassandoOmProdutos(Collection<OmProduto> produtosSemiacabados){
//
//		List<PpCmcom> listAlternativosNA = getListaAlternativoNADeProdutosProducaoPassandoListaProdutoOriginal(produtosSemiacabados);
//		
//		return getMapProdutosAlternativosNAPassandoPpcmcoms(listAlternativosNA);
//		
//	}

	public Map<String, OmProduto> getMapProdutosAlternativosNAPassandoPpcmcoms(Collection<PpCmcom> alternativosNA){
		Map<String, OmProduto> mapProdutos = new HashMap<String, OmProduto>();
		
		
		List<OmProduto> listaProdutosAlternativoNA = getListaProdutoAlternativoDeListaAlternativoNA(alternativosNA);
		
		mapProdutos.putAll(ProdutoRN.getListaProdutoIndexCdProduto(listaProdutosAlternativoNA));
		
		return mapProdutos;
		
	}	
//	private Map<String, OmProduto> getMapProdutosAlternativosDiretoDeSemiacabadosPassandoOmProdutos(Collection<OmProduto> produtosSemiacabados){
//				
//		List<OmProaltglo> listAlternativoDireto= getListaAlternativoDiretoComSemiacabadoPassandoListaProdutoOriginal(produtosSemiacabados);
//		
//		return getMapProdutosAlternativosDiretoPassandoOmProaltglos(listAlternativoDireto);
//		
//	}	
	
	public Map<String, OmProduto> getMapProdutosAlternativosDiretoPassandoOmProaltglos(Collection<OmProaltglo> alternativosDiretos){
		Map<String, OmProduto> mapProdutos = new HashMap<String, OmProduto>();
		
		List<OmProduto> listaProdutosAlternativoDireto = getListaProdutoFilhoDeOmProaltglo(alternativosDiretos);
		
		mapProdutos.putAll(ProdutoRN.getListaProdutoIndexCdProduto(listaProdutosAlternativoDireto));
		
		return mapProdutos;
	}
	
}
