package idw.model.rn.web.injet.bi;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.monitorizacao.injet.ConfiguracoesInjetRN;
import idw.model.rn.web.injet.bi.BiWebInjetRN.UnidadeExibicaoOuOrdenacaoQtdBI;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.webservices.rest.BiResource;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiFiltroDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasRefugoDetDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasRefugoDetalheDTO;
import ms.util.ConversaoTipos;

public class BiWebGraficoPerdasRefugoDetInjetRN extends AbstractRN<DAOGenericoInjet> {	
	private static final String COR_CELULA_SEM_COR = "";
	private static final String COR_CELULA_PERDA_REFUGO_SUB_TOTAL_MOLDE = "#fddcb9";
	private static final String COR_CELULA_PERDA_REFUGO_SUB_TOTAL_MAQUINA = "#e0e0e0";
	private static final String COR_CELULA_PERDA_REFUGO_SUB_TOTAL_PRODUTO = "#f7c7bd";
	
	private static final String TEXTO_CELULA_PERDA_REFUGO_SUB_TOTAL_MOLDE = "TOTAL DA FERRAMENTA";
	private static final String TEXTO_CELULA_PERDA_REFUGO_SUB_TOTAL_MAQUINA = "TOTAL DO PT";
	private static final String TEXTO_CELULA_PERDA_REFUGO_SUB_TOTAL_PRODUTO = "TOTAL DO PRODUTO";
	

	
	private class RegistroPerda {
		String cdPt;
		String dsPt;
		String cdFerramenta;
		String cdEstrutura;
		String cdProduto;
		String dsProduto;
		String cdRefugo;
		String dsRefugo;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal prodBrutaUB =  BigDecimal.ZERO;
		BigDecimal prodPrevUB =  BigDecimal.ZERO;
	}

	private class RegistroProdPrevProdBruta {
		String id;
		BigDecimal prodBrutaUB =  BigDecimal.ZERO;
		BigDecimal prodPrevUB =  BigDecimal.ZERO;
	}
	
	private class PerdasDetRefugo {
		String cdRefugo;
		String dsRefugo;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;	
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
		BigDecimal indiceUB =  BigDecimal.ZERO;
	}

	private class PerdasMaqDetProduto {
		String cdProduto;
		String dsProduto;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;	
		BigDecimal prodBrutaUB =  BigDecimal.ZERO;
		BigDecimal prodPrevUB =  BigDecimal.ZERO;
		BigDecimal indiceUB =  BigDecimal.ZERO;
		Map<String, PerdasDetRefugo> refugos = new HashMap<String, PerdasDetRefugo>();
	}

	private class PerdasMaqDetFerramentaEstrutura {
		String cdEstrutura;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;	
		BigDecimal prodBrutaUB =  BigDecimal.ZERO;
		BigDecimal prodPrevUB =  BigDecimal.ZERO;
		BigDecimal indiceUB =  BigDecimal.ZERO;
		Map<String, PerdasMaqDetProduto> produtos = new HashMap<String, PerdasMaqDetProduto>();
	}

	private class PerdasMaqDetFerramenta {
		String cdFerramenta;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;	
		BigDecimal prodBrutaUB =  BigDecimal.ZERO;
		BigDecimal indiceUB =  BigDecimal.ZERO;		
		Map<String, PerdasMaqDetFerramentaEstrutura> estruturas = new HashMap<String, PerdasMaqDetFerramentaEstrutura>();
	}

	private class PerdasMaqDetMaquina {
		String cdPt;
		String cdIdentificacaoPt;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;	
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
		BigDecimal prodBrutaUB =  BigDecimal.ZERO;
		BigDecimal prodPrevUB =  BigDecimal.ZERO;
		BigDecimal indiceUB =  BigDecimal.ZERO;
		Map<String, PerdasMaqDetFerramenta> ferramentas = new HashMap<String, PerdasMaqDetFerramenta>();
	}
	
	private class PerdasProDetFerramentaEstrutura {
		String cdEstrutura;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;	
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
		BigDecimal prodBrutaUB =  BigDecimal.ZERO;
		BigDecimal prodPrevUB =  BigDecimal.ZERO;
		BigDecimal indiceUB =  BigDecimal.ZERO;
		Map<String, PerdasDetRefugo> refugos = new HashMap<String, PerdasDetRefugo>();
	} 
	
	private class PerdasProDetFerramenta {
		String cdFerramenta;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;	
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
		BigDecimal prodBrutaUB =  BigDecimal.ZERO;
		BigDecimal indiceUB =  BigDecimal.ZERO;
		Map<String, PerdasProDetFerramentaEstrutura> estruturas = new HashMap<String, PerdasProDetFerramentaEstrutura>();
	} 
	
	private class PerdasProDetMaquina {
		String cdPt;
		String cdIdentificacaoPt;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;	
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
		BigDecimal prodBrutaUB =  BigDecimal.ZERO;
		BigDecimal prodPrevUB =  BigDecimal.ZERO;
		BigDecimal indiceUB =  BigDecimal.ZERO;
		Map<String, PerdasProDetFerramenta> ferramentas = new HashMap<String, PerdasProDetFerramenta>();
	} 

	private class PerdasProDetProduto {
		String cdProduto;
		String dsProduto;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;	
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
		BigDecimal prodBrutaUB =  BigDecimal.ZERO;
		BigDecimal prodPrevUB =  BigDecimal.ZERO;
		BigDecimal indiceUB =  BigDecimal.ZERO;
		Map<String, PerdasProDetMaquina> maquinas = new HashMap<String, PerdasProDetMaquina>();
	} 
	
	
	
	private static final Comparator<PerdasMaqDetMaquina> comparaPerdasMaqMaq = new Comparator<PerdasMaqDetMaquina>() {
		@Override
        public int compare(PerdasMaqDetMaquina o1, PerdasMaqDetMaquina o2) {
			return o1.indiceUB.compareTo(o2.indiceUB) * -1;
        }
    };	

	private static final Comparator<PerdasMaqDetFerramenta> comparaPerdasMaqMol = new Comparator<PerdasMaqDetFerramenta>() {
		@Override
        public int compare(PerdasMaqDetFerramenta o1, PerdasMaqDetFerramenta o2) {
			return o1.indiceUB.compareTo(o2.indiceUB) * -1;
        }
    };	

	
    private static final Comparator<PerdasMaqDetFerramentaEstrutura> comparaPerdasMaqEstru = new Comparator<PerdasMaqDetFerramentaEstrutura>() {
		@Override
        public int compare(PerdasMaqDetFerramentaEstrutura o1, PerdasMaqDetFerramentaEstrutura o2) {
			return o1.indiceUB.compareTo(o2.indiceUB) * -1;
        }
    };	    
    
	private static final Comparator<PerdasMaqDetProduto> comparaPerdasMaqProduto = new Comparator<PerdasMaqDetProduto>() {
		@Override
        public int compare(PerdasMaqDetProduto o1, PerdasMaqDetProduto o2) {
			return o1.indiceUB.compareTo(o2.indiceUB) * -1;
        }
    };	    

	
    private static final Comparator<PerdasDetRefugo> comparaPerdasMaqProRefugo = new Comparator<PerdasDetRefugo>() {
		@Override
        public int compare(PerdasDetRefugo o1, PerdasDetRefugo o2) {
			return o1.indiceUB.compareTo(o2.indiceUB) * -1;
        }
    };	    



	private static final Comparator<PerdasProDetProduto> comparaPerdasProProduto = new Comparator<PerdasProDetProduto>() {
		@Override
        public int compare(PerdasProDetProduto o1, PerdasProDetProduto o2) {
			return o1.perdaOrdenacao.compareTo(o2.perdaOrdenacao) * -1;
        }
    };	

	private static final Comparator<PerdasProDetMaquina> comparaPerdasProMaq = new Comparator<PerdasProDetMaquina>() {
		@Override
        public int compare(PerdasProDetMaquina o1, PerdasProDetMaquina o2) {
			return o1.perdaOrdenacao.compareTo(o2.perdaOrdenacao) * -1;
        }
    };	 
    
	private static final Comparator<PerdasProDetFerramenta> comparaPerdasProMol = new Comparator<PerdasProDetFerramenta>() {
		@Override
        public int compare(PerdasProDetFerramenta o1, PerdasProDetFerramenta o2) {
			return o1.perdaOrdenacao.compareTo(o2.perdaOrdenacao) * -1;
        }
    };	

    private static final Comparator<PerdasProDetFerramentaEstrutura> comparaPerdasProEstru = new Comparator<PerdasProDetFerramentaEstrutura>() {
		@Override
        public int compare(PerdasProDetFerramentaEstrutura o1, PerdasProDetFerramentaEstrutura o2) {
			return o1.perdaOrdenacao.compareTo(o2.perdaOrdenacao) * -1;
        }
    };	    
    
    private static final Comparator<PerdasDetRefugo> comparaPerdasProRefugo = new Comparator<PerdasDetRefugo>() {
		@Override
        public int compare(PerdasDetRefugo o1, PerdasDetRefugo o2) {
			return o1.perdaOrdenacao.compareTo(o2.perdaOrdenacao) * -1;
        }
    };	    

	

    
    public BiWebGraficoPerdasRefugoDetInjetRN() {
		this(new DAOGenericoInjet());
	}

	public BiWebGraficoPerdasRefugoDetInjetRN(DAOGenericoInjet dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenericoInjet();
		}
		this.setDao(dao);
	}

	@SuppressWarnings("unchecked")
	public BiParetoPerdasRefugoDetalheDTO getParetoPerdasRefugoMaqDet(BiFiltroDTO filtroBIDet, String cdRefugo, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		BiFiltroDTO filtroBI = new BiFiltroDTO();
		BiWebInjetRN biRN = new BiWebInjetRN(getDao(), BiResource.FORMATO_DATA, BiResource.FORMATO_DATA_HORA);
		filtroBI = biRN.filtroBiTransformado(filtroBIDet);
		
		BiParetoPerdasRefugoDetalheDTO resumo = new BiParetoPerdasRefugoDetalheDTO();
		resumo.setDetalhes(new ArrayList<BiParetoPerdasRefugoDetDTO>());;
		BigDecimal totalCusto = BigDecimal.ZERO;
		
		Map<String, PerdasMaqDetMaquina> mapResumo = new HashMap<String, PerdasMaqDetMaquina>();
		Map<String, RegistroProdPrevProdBruta> mapPBPP_MFEP = new HashMap<String, RegistroProdPrevProdBruta>();
		Map<String, RegistroProdPrevProdBruta> mapPBPP_MFE = new HashMap<String, RegistroProdPrevProdBruta>();
		Map<String, RegistroProdPrevProdBruta> mapPBPP_MF = new HashMap<String, RegistroProdPrevProdBruta>();
		Map<String, RegistroProdPrevProdBruta> mapPBPP_M = new HashMap<String, RegistroProdPrevProdBruta>();
		
		
		int _cdpt = 0;
		int _dspt = _cdpt + 1;		
		int _cdferramenta = _dspt + 1;
		int _cdestrutura = _cdferramenta + 1;				
		int _cdproduto = _cdestrutura + 1;
		int _dsproduto = _cdproduto + 1;
		
		int _cdrefugo = _dsproduto + 1;
		int _dsrefugo = _cdrefugo + 1;		
		int _perdasUB = _dsrefugo + 1;
		int _perdasGr = _perdasUB + 1;
		int _perdasUM = _perdasGr + 1;
		
		int _prodBrutaUB = _dsproduto + 1;
		int _prodPrevUB = _prodBrutaUB + 1;
		
		
		// producao bruta e prevista
		String strSQL = "";		
		List<Object>  lista = new ArrayList<Object>();
		strSQL = getConsultaProdBrutaProdPrev(filtroBI, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosNaQuery(q, filtroBI, cdRefugo, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		
		lista = q.list();		
		for (Object reg : lista) {
			RegistroPerda registro = new RegistroPerda();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			registro.cdPt = (String) registroLido[_cdpt];
			registro.cdFerramenta = (String) registroLido[_cdferramenta];
			registro.cdEstrutura = (String) registroLido[_cdestrutura];
			registro.cdProduto = (String) registroLido[_cdproduto];
			registro.prodBrutaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_prodBrutaUB]);
			registro.prodPrevUB = ConversaoTipos.converterParaBigDecimal(registroLido[_prodPrevUB]);
			
			String keyM = registro.cdPt;
			String keyMF = keyM + registro.cdFerramenta;
			String keyMFE = keyMF + registro.cdEstrutura;
			String keyMFEP = keyMFE + registro.cdProduto;
			
			
			// maquinas
			if (! mapPBPP_M.containsKey(keyM)) {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP.id = keyM;
				prodBP.prodBrutaUB = registro.prodBrutaUB;
				prodBP.prodPrevUB = registro.prodPrevUB;
				
				mapPBPP_M.put(keyM, prodBP);	
				
			} else {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP = mapPBPP_M.get(keyM);
				
				prodBP.prodBrutaUB = AritmeticaUtil.somar(prodBP.prodBrutaUB, registro.prodBrutaUB);
				prodBP.prodPrevUB = AritmeticaUtil.somar(prodBP.prodPrevUB, registro.prodPrevUB);
				
				mapPBPP_M.put(keyM, prodBP);					
			}

			
			// ferramentas
			if (! mapPBPP_MF.containsKey(keyMF)) {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP.id = keyMF;
				prodBP.prodBrutaUB = registro.prodBrutaUB;
				prodBP.prodPrevUB = registro.prodPrevUB;
				
				mapPBPP_MF.put(keyMF, prodBP);	
				
			} else {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP = mapPBPP_MF.get(keyMF);
				
				prodBP.prodBrutaUB = AritmeticaUtil.somar(prodBP.prodBrutaUB, registro.prodBrutaUB);
				prodBP.prodPrevUB = AritmeticaUtil.somar(prodBP.prodPrevUB, registro.prodPrevUB);
				
				mapPBPP_MF.put(keyMF, prodBP);					
			}
			

			// estrutruas
			if (! mapPBPP_MFE.containsKey(keyMFE)) {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP.id = keyMF;
				prodBP.prodBrutaUB = registro.prodBrutaUB;
				prodBP.prodPrevUB = registro.prodPrevUB;
				
				mapPBPP_MFE.put(keyMFE, prodBP);	
				
			} else {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP = mapPBPP_MFE.get(keyMFE);
				
				prodBP.prodBrutaUB = AritmeticaUtil.somar(prodBP.prodBrutaUB, registro.prodBrutaUB);
				prodBP.prodPrevUB = AritmeticaUtil.somar(prodBP.prodPrevUB, registro.prodPrevUB);
				
				mapPBPP_MFE.put(keyMFE, prodBP);					
			}
			

			// produtos
			if (! mapPBPP_MFEP.containsKey(keyMFEP)) {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP.id = keyMF;
				prodBP.prodBrutaUB = registro.prodBrutaUB;
				prodBP.prodPrevUB = registro.prodPrevUB;
				
				mapPBPP_MFEP.put(keyMFEP, prodBP);	
				
			} else {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP = mapPBPP_MFEP.get(keyMFEP);
				
				prodBP.prodBrutaUB = AritmeticaUtil.somar(prodBP.prodBrutaUB, registro.prodBrutaUB);
				prodBP.prodPrevUB = AritmeticaUtil.somar(prodBP.prodPrevUB, registro.prodPrevUB);
				
				mapPBPP_MFEP.put(keyMFEP, prodBP);					
			}
		}

		
		
		// qtdes
		strSQL = "";		
		lista = new ArrayList<Object>();
		strSQL = getConsultaRefugos(filtroBI, cdRefugo, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosNaQuery(q, filtroBI, cdRefugo, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		
		lista = q.list();		
		for (Object reg : lista) {
			RegistroPerda registro = new RegistroPerda();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdPt = (String) registroLido[_cdpt];
			registro.dsPt = (String) registroLido[_dspt];
			registro.cdFerramenta = (String) registroLido[_cdferramenta];
			registro.cdEstrutura = (String) registroLido[_cdestrutura];
			registro.cdProduto = (String) registroLido[_cdproduto];
			registro.dsProduto = (String) registroLido[_dsproduto];
			registro.cdRefugo = (String) registroLido[_cdrefugo];
			registro.dsRefugo = (String) registroLido[_dsrefugo];
			registro.perdaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasUB]);
			registro.perdaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasGr]);
			registro.perdaUM = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasUM]);
			
			String keyM = registro.cdPt;
			String keyMF = keyM + registro.cdFerramenta;
			String keyMFE = keyMF + registro.cdEstrutura;
			String keyMFEP = keyMFE + registro.cdProduto;			

			
			PerdasDetRefugo perdaRefugoReg = new PerdasDetRefugo();
			perdaRefugoReg.cdRefugo = registro.cdRefugo;
			perdaRefugoReg.dsRefugo = registro.dsRefugo;
			perdaRefugoReg.perdaUB = registro.perdaUB;
			perdaRefugoReg.perdaGr = registro.perdaGr;
			perdaRefugoReg.perdaUM  = registro.perdaUM;
			perdaRefugoReg.indiceUB = new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaRefugoReg.perdaUB, mapPBPP_MFEP.get(keyMFEP).prodBrutaUB));

			
			PerdasMaqDetProduto perdaProdutoReg = new PerdasMaqDetProduto();
			perdaProdutoReg.cdProduto = registro.cdProduto;
			perdaProdutoReg.dsProduto = registro.dsProduto;
			perdaProdutoReg.perdaUB = registro.perdaUB;
			perdaProdutoReg.perdaGr = registro.perdaGr;
			perdaProdutoReg.perdaUM = registro.perdaUM;
			perdaProdutoReg.refugos.put(registro.cdRefugo, perdaRefugoReg);
			perdaProdutoReg.prodBrutaUB = mapPBPP_MFEP.get(keyMFEP).prodBrutaUB;
			perdaProdutoReg.prodPrevUB = mapPBPP_MFEP.get(keyMFEP).prodPrevUB;
			perdaProdutoReg.indiceUB = new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaProdutoReg.perdaUB, perdaProdutoReg.prodBrutaUB));

			
			PerdasMaqDetFerramentaEstrutura perdaEstruturaReg = new PerdasMaqDetFerramentaEstrutura();
			perdaEstruturaReg.cdEstrutura = registro.cdEstrutura;
			perdaEstruturaReg.perdaUB = registro.perdaUB;
			perdaEstruturaReg.perdaGr = registro.perdaGr;
			perdaEstruturaReg.perdaUM = registro.perdaUM;
			perdaEstruturaReg.produtos.put(registro.cdProduto, perdaProdutoReg);
			perdaEstruturaReg.prodBrutaUB = mapPBPP_MFE.get(keyMFE).prodBrutaUB;
			perdaEstruturaReg.prodPrevUB = mapPBPP_MFE.get(keyMFE).prodPrevUB;
			perdaEstruturaReg.indiceUB = new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaEstruturaReg.perdaUB, perdaEstruturaReg.prodBrutaUB));

			
			
			PerdasMaqDetFerramenta perdaFerramentaReg = new PerdasMaqDetFerramenta();
			perdaFerramentaReg.cdFerramenta = registro.cdFerramenta;
			perdaFerramentaReg.perdaUB = registro.perdaUB;
			perdaFerramentaReg.perdaGr = registro.perdaGr;
			perdaFerramentaReg.perdaUM = registro.perdaUM;
			perdaFerramentaReg.estruturas.put(registro.cdEstrutura, perdaEstruturaReg);
			perdaFerramentaReg.prodBrutaUB = mapPBPP_MF.get(keyMF).prodBrutaUB;
			perdaFerramentaReg.indiceUB = new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaFerramentaReg.perdaUB, perdaFerramentaReg.prodBrutaUB));

			
			PerdasMaqDetMaquina perdaMaquinaReg = new PerdasMaqDetMaquina();
			perdaMaquinaReg.cdPt = registro.cdPt;
			perdaMaquinaReg.cdIdentificacaoPt = registro.dsPt;
			perdaMaquinaReg.perdaUB = registro.perdaUB;
			perdaMaquinaReg.perdaGr = registro.perdaGr;
			perdaMaquinaReg.perdaUM = registro.perdaUM;
			perdaMaquinaReg.ferramentas.put(registro.cdFerramenta, perdaFerramentaReg);
			perdaMaquinaReg.prodBrutaUB = mapPBPP_M.get(keyM).prodBrutaUB;
			perdaMaquinaReg.prodPrevUB = mapPBPP_M.get(keyM).prodPrevUB;
			perdaMaquinaReg.indiceUB = new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaMaquinaReg.perdaUB, perdaMaquinaReg.prodBrutaUB));

			
			if (! mapResumo.containsKey(registro.cdPt)) {
				mapResumo.put(registro.cdPt, perdaMaquinaReg);
				
			} else {
				PerdasMaqDetMaquina perdaMaquina = new PerdasMaqDetMaquina();
				perdaMaquina = mapResumo.get(registro.cdPt);
				
				// atualiza perdas maquina
				perdaMaquina.perdaUB = AritmeticaUtil.somar(perdaMaquina.perdaUB, registro.perdaUB);
				perdaMaquina.perdaGr = AritmeticaUtil.somar(perdaMaquina.perdaGr, registro.perdaGr);
				perdaMaquina.perdaUM = AritmeticaUtil.somar(perdaMaquina.perdaUM, registro.perdaUM);
				perdaMaquina.indiceUB = new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaMaquina.perdaUB, perdaMaquina.prodBrutaUB));
				
				
				if (! perdaMaquina.ferramentas.containsKey(registro.cdFerramenta)) {
					PerdasMaqDetFerramenta perdaFerramenta = new PerdasMaqDetFerramenta();
					
					perdaFerramenta = perdaFerramentaReg;					
					perdaMaquina.ferramentas.put(registro.cdFerramenta, perdaFerramenta);
					
				} else {
					PerdasMaqDetFerramenta perdaFerramenta = new PerdasMaqDetFerramenta();
					perdaFerramenta = perdaMaquina.ferramentas.get(registro.cdFerramenta);
				
					// atualiza perdas ferramenta
					perdaFerramenta.perdaUB = AritmeticaUtil.somar(perdaFerramenta.perdaUB, registro.perdaUB);
					perdaFerramenta.perdaGr = AritmeticaUtil.somar(perdaFerramenta.perdaGr, registro.perdaGr);
					perdaFerramenta.perdaUM = AritmeticaUtil.somar(perdaFerramenta.perdaUM, registro.perdaUM);
					perdaFerramenta.indiceUB = new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaFerramenta.perdaUB, perdaFerramenta.prodBrutaUB));					
					
					
					if (! perdaFerramenta.estruturas.containsKey(registro.cdEstrutura)) {
						PerdasMaqDetFerramentaEstrutura perdaEstrutura = new PerdasMaqDetFerramentaEstrutura();
						perdaEstrutura = perdaEstruturaReg;		
						perdaFerramenta.estruturas.put(registro.cdEstrutura, perdaEstrutura);
						
					} else {
						PerdasMaqDetFerramentaEstrutura perdaEstrutura = new PerdasMaqDetFerramentaEstrutura();
						perdaEstrutura = perdaFerramenta.estruturas.get(registro.cdEstrutura);

						// atualiza estruturas
						perdaEstrutura.perdaUB = AritmeticaUtil.somar(perdaEstrutura.perdaUB, registro.perdaUB);
						perdaEstrutura.perdaGr = AritmeticaUtil.somar(perdaEstrutura.perdaGr, registro.perdaGr);
						perdaEstrutura.perdaUM = AritmeticaUtil.somar(perdaEstrutura.perdaUM, registro.perdaUM);
						perdaEstrutura.indiceUB = new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaEstrutura.perdaUB, perdaEstrutura.prodBrutaUB));
						
						
						if (! perdaEstrutura.produtos.containsKey(registro.cdProduto)) {
							PerdasMaqDetProduto perdaProduto = new PerdasMaqDetProduto();
							perdaProduto = perdaProdutoReg;
							perdaEstrutura.produtos.put(registro.cdProduto, perdaProduto);
							
						} else {
							PerdasMaqDetProduto perdaProduto = new PerdasMaqDetProduto();
							perdaProduto = perdaEstrutura.produtos.get(registro.cdProduto);							
							
							// atualiza produtos
							perdaProduto.perdaUB = AritmeticaUtil.somar(perdaProduto.perdaUB, registro.perdaUB);
							perdaProduto.perdaGr = AritmeticaUtil.somar(perdaProduto.perdaGr, registro.perdaGr);
							perdaProduto.perdaUM = AritmeticaUtil.somar(perdaProduto.perdaUM, registro.perdaUM);
							perdaProduto.indiceUB = new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaProduto.perdaUB, perdaProduto.prodBrutaUB));
							
							perdaProduto.refugos.put(registro.cdRefugo, perdaRefugoReg);
							perdaEstrutura.produtos.put(registro.cdProduto, perdaProduto);
						}
						
						perdaFerramenta.estruturas.put(registro.cdEstrutura, perdaEstrutura);
					}
					
					perdaMaquina.ferramentas.put(registro.cdFerramenta, perdaFerramenta);
				}
				
				mapResumo.remove(registro.cdPt);				
				mapResumo.put(registro.cdPt, perdaMaquina);
			}
			
			totalCusto = AritmeticaUtil.somar(totalCusto, registro.perdaUM);
		}
		

		
		// Ordenacao por maquina
		List<PerdasMaqDetMaquina> listaMaq = new ArrayList<PerdasMaqDetMaquina>();
		listaMaq.addAll(mapResumo.values());
		Collections.sort(listaMaq, comparaPerdasMaqMaq);
		
		for (PerdasMaqDetMaquina perdaMaq : listaMaq) {

			if (resumo.getDetalhes().size() > 0) {
				BiParetoPerdasRefugoDetDTO linhaDetPerdas = new BiParetoPerdasRefugoDetDTO();
				linhaDetPerdas.setPt("");
				linhaDetPerdas.setFerramenta("");
				linhaDetPerdas.setProduto("");
				linhaDetPerdas.setCdProduto("");
				linhaDetPerdas.setRefugo("");
				linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_SEM_COR);
				linhaDetPerdas.setPerdaUB("");
				linhaDetPerdas.setPerdaKg("");
				linhaDetPerdas.setPerdaTon("");
				linhaDetPerdas.setPerdaUM("");					
				linhaDetPerdas.setProdBrutaUB("");
				linhaDetPerdas.setProdPrevUB("");
				linhaDetPerdas.setIndRefUB("");
				
				resumo.getDetalhes().add(linhaDetPerdas);
			}
			
			
			// Ordenacao por ferramenta
			List<PerdasMaqDetFerramenta> listaFerr = new ArrayList<PerdasMaqDetFerramenta>();
			listaFerr.addAll(perdaMaq.ferramentas.values());
			Collections.sort(listaFerr, comparaPerdasMaqMol);
			
			int contadorMol = 0;
			for (PerdasMaqDetFerramenta perdaFerr : listaFerr) {
				contadorMol++;
				
				// Ordenacao por estrutura
				List<PerdasMaqDetFerramentaEstrutura> listaEstru = new ArrayList<PerdasMaqDetFerramentaEstrutura>();
				listaEstru.addAll(perdaFerr.estruturas.values());
				Collections.sort(listaEstru, comparaPerdasMaqEstru);
				
				int contadorEstru = 0;
				for (PerdasMaqDetFerramentaEstrutura perdaEstru : listaEstru) {
					contadorEstru++;
					
					// Ordenacao por produto
					List<PerdasMaqDetProduto> listaPro = new ArrayList<PerdasMaqDetProduto>();
					listaPro.addAll(perdaEstru.produtos.values());
					Collections.sort(listaPro, comparaPerdasMaqProduto);
					
					int contadorPro = 0;
					for (PerdasMaqDetProduto perdaPro : listaPro) {
						contadorPro++;
						
						// Ordenacao por refugo
						List<PerdasDetRefugo> listaRef = new ArrayList<PerdasDetRefugo>();
						listaRef.addAll(perdaPro.refugos.values());
						Collections.sort(listaRef, comparaPerdasMaqProRefugo);
						
						int contadorRef = 0;
						for (PerdasDetRefugo perdaRef : listaRef) {
							contadorRef++;
							
							BiParetoPerdasRefugoDetDTO linhaDetPerdas = new BiParetoPerdasRefugoDetDTO();
							
							if (contadorMol == 1 && contadorEstru == 1 && contadorPro == 1 && contadorRef == 1) {
								linhaDetPerdas.setPt(perdaMaq.cdPt + " (" + perdaMaq.cdIdentificacaoPt + ")");	
							} else {
								linhaDetPerdas.setPt("");
							}
							
							if (contadorEstru == 1 && contadorPro == 1 && contadorRef == 1) {
								linhaDetPerdas.setFerramenta(perdaFerr.cdFerramenta + "/" + perdaEstru.cdEstrutura);
							} else {
								linhaDetPerdas.setFerramenta("");	
							}

							if (contadorPro == 1 && contadorRef == 1) {
								linhaDetPerdas.setProduto(perdaPro.cdProduto + " (" + perdaPro.dsProduto + ")");
								linhaDetPerdas.setCdProduto(perdaPro.cdProduto);
							} else {
								linhaDetPerdas.setProduto("");	
								linhaDetPerdas.setCdProduto("");
							}


							linhaDetPerdas.setRefugo(perdaRef.cdRefugo + " (" + perdaRef.dsRefugo + ")");
							linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_SEM_COR);				
							
							linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaRef.perdaUB));
							linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaRef.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
							linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaRef.perdaGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
							linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaRef.perdaUM, 2));							
							
							linhaDetPerdas.setProdBrutaUB("");
							linhaDetPerdas.setProdPrevUB("");
							linhaDetPerdas.setIndRefUB("");
							
							resumo.getDetalhes().add(linhaDetPerdas);							
						}
						
						// total do produto
						BiParetoPerdasRefugoDetDTO linhaDetPerdas = new BiParetoPerdasRefugoDetDTO();
						linhaDetPerdas.setPt("");
						linhaDetPerdas.setFerramenta("");
						linhaDetPerdas.setProduto("");
						linhaDetPerdas.setCdProduto("");
						linhaDetPerdas.setRefugo(TEXTO_CELULA_PERDA_REFUGO_SUB_TOTAL_PRODUTO);
						linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_PERDA_REFUGO_SUB_TOTAL_PRODUTO);				
						linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaPro.perdaUB));
						linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaPro.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
						linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaPro.perdaGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
						linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaPro.perdaUM, 2));							
						linhaDetPerdas.setProdBrutaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaPro.prodBrutaUB));
						linhaDetPerdas.setProdPrevUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaPro.prodPrevUB));
						linhaDetPerdas.setIndRefUB(ConversaoTipos.converteParaString(perdaPro.indiceUB, 2));
						
						resumo.getDetalhes().add(linhaDetPerdas);						

						
					}
					
					// total da estrutura
					BiParetoPerdasRefugoDetDTO linhaDetPerdas = new BiParetoPerdasRefugoDetDTO();
					linhaDetPerdas.setPt("");
					linhaDetPerdas.setFerramenta("");
					linhaDetPerdas.setProduto("");
					linhaDetPerdas.setCdProduto("");
					linhaDetPerdas.setRefugo(TEXTO_CELULA_PERDA_REFUGO_SUB_TOTAL_MOLDE);
					linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_PERDA_REFUGO_SUB_TOTAL_MOLDE);				
					linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaEstru.perdaUB));
					linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaEstru.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
					linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaEstru.perdaGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
					linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaEstru.perdaUM, 2));							
					linhaDetPerdas.setProdBrutaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaEstru.prodBrutaUB));
					linhaDetPerdas.setProdPrevUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaEstru.prodPrevUB));
					linhaDetPerdas.setIndRefUB(ConversaoTipos.converteParaString(perdaEstru.indiceUB, 2));
					
					resumo.getDetalhes().add(linhaDetPerdas);											
				}
				
				

			}
			
			// linha em branco
			BiParetoPerdasRefugoDetDTO linhaDetPerdas = new BiParetoPerdasRefugoDetDTO();
			linhaDetPerdas.setPt("");
			linhaDetPerdas.setFerramenta("");
			linhaDetPerdas.setProduto("");
			linhaDetPerdas.setCdProduto("");
			linhaDetPerdas.setRefugo("");
			linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_SEM_COR);				
			linhaDetPerdas.setPerdaUB("");
			linhaDetPerdas.setPerdaKg("");
			linhaDetPerdas.setPerdaTon("");
			linhaDetPerdas.setPerdaUM("");					
			linhaDetPerdas.setProdBrutaUB("");
			linhaDetPerdas.setProdPrevUB("");
			linhaDetPerdas.setIndRefUB("");
			
			resumo.getDetalhes().add(linhaDetPerdas);
			
			// perda da maquina
			linhaDetPerdas = new BiParetoPerdasRefugoDetDTO();
			linhaDetPerdas.setPt("");
			linhaDetPerdas.setFerramenta("");
			linhaDetPerdas.setProduto("");
			linhaDetPerdas.setCdProduto("");
			linhaDetPerdas.setRefugo(TEXTO_CELULA_PERDA_REFUGO_SUB_TOTAL_MAQUINA);
			linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_PERDA_REFUGO_SUB_TOTAL_MAQUINA);				
			linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaMaq.perdaUB));
			linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaMaq.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
			linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaMaq.perdaGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
			linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaMaq.perdaUM, 2));							
			linhaDetPerdas.setProdBrutaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaMaq.prodBrutaUB));
			linhaDetPerdas.setProdPrevUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaMaq.prodPrevUB));
			linhaDetPerdas.setIndRefUB(ConversaoTipos.converteParaString(perdaMaq.indiceUB, 2));
			
			resumo.getDetalhes().add(linhaDetPerdas);											
			
		}

		resumo.setTotalCusto(ConversaoTipos.converteParaString(totalCusto, 2));
		
		resumo.setTotalProdUB(filtroBI.getIndicadores().getPcsProdBruta());
		resumo.setTotalProdKg(filtroBI.getIndicadores().getPcsProdBrutaKg());
		resumo.setTotalProdTon(filtroBI.getIndicadores().getPcsProdBrutaTon());

		resumo.setTotalRefugoUB(filtroBI.getIndicadores().getPcsProdRefugada());
		resumo.setTotalRefugoKg(filtroBI.getIndicadores().getPcsProdRefugadaKg());
		resumo.setTotalRefugoTon(filtroBI.getIndicadores().getPcsProdRefugadaTon());

		resumo.setIndRef(filtroBI.getIndicadores().getIndRef());
		resumo.setIndRefGr(filtroBI.getIndicadores().getIndRefGr());		
		
		return resumo;			
	}

	@SuppressWarnings("unchecked")
	public BiParetoPerdasRefugoDetalheDTO getParetoPerdasRefugoProDet(BiFiltroDTO filtroBIDet, UnidadeExibicaoOuOrdenacaoQtdBI ordenacao, String cdRefugo, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		
		BiFiltroDTO filtroBI = new BiFiltroDTO();
		BiWebInjetRN biRN = new BiWebInjetRN(getDao(), BiResource.FORMATO_DATA, BiResource.FORMATO_DATA_HORA);
		filtroBI = biRN.filtroBiTransformado(filtroBIDet);

		BiParetoPerdasRefugoDetalheDTO resumo = new BiParetoPerdasRefugoDetalheDTO();
		resumo.setDetalhes(new ArrayList<BiParetoPerdasRefugoDetDTO>());;
		BigDecimal totalCusto = BigDecimal.ZERO;
		
		Map<String, PerdasProDetProduto> mapResumo = new HashMap<String, PerdasProDetProduto>();
		Map<String, RegistroProdPrevProdBruta> mapPBPP_P = new HashMap<String, RegistroProdPrevProdBruta>();
		Map<String, RegistroProdPrevProdBruta> mapPBPP_PM = new HashMap<String, RegistroProdPrevProdBruta>();
		Map<String, RegistroProdPrevProdBruta> mapPBPP_PMF = new HashMap<String, RegistroProdPrevProdBruta>();
		Map<String, RegistroProdPrevProdBruta> mapPBPP_PMFE = new HashMap<String, RegistroProdPrevProdBruta>();

		
				
		int _cdpt = 0;
		int _dspt = _cdpt + 1;		
		int _cdferramenta = _dspt + 1;
		int _cdestrutura = _cdferramenta + 1;				
		int _cdproduto = _cdestrutura + 1;
		int _dsproduto = _cdproduto + 1;
		
		int _cdrefugo = _dsproduto + 1;
		int _dsrefugo = _cdrefugo + 1;		
		int _perdasUB = _dsrefugo + 1;
		int _perdasGr = _perdasUB + 1;
		int _perdasUM = _perdasGr + 1;
		
		int _prodBrutaUB = _dsproduto + 1;
		int _prodPrevUB = _prodBrutaUB + 1;
		
		
		// producao bruta e prevista
		String strSQL = "";		
		List<Object>  lista = new ArrayList<Object>();
		strSQL = getConsultaProdBrutaProdPrev(filtroBI, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosNaQuery(q, filtroBI, cdRefugo, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		
		lista = q.list();		
		for (Object reg : lista) {
			RegistroPerda registro = new RegistroPerda();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			registro.cdPt = (String) registroLido[_cdpt];
			registro.cdFerramenta = (String) registroLido[_cdferramenta];
			registro.cdEstrutura = (String) registroLido[_cdestrutura];
			registro.cdProduto = (String) registroLido[_cdproduto];
			registro.prodBrutaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_prodBrutaUB]);
			registro.prodPrevUB = ConversaoTipos.converterParaBigDecimal(registroLido[_prodPrevUB]);
			
			String keyP = registro.cdProduto;
			String keyPM = keyP + registro.cdPt;
			String keyPMF = keyP + registro.cdFerramenta;
			String keyPMFE = keyPMF + registro.cdEstrutura;			


			// produtos
			if (! mapPBPP_P.containsKey(keyP)) {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP.id = keyP;
				prodBP.prodBrutaUB = registro.prodBrutaUB;
				prodBP.prodPrevUB = registro.prodPrevUB;
				
				mapPBPP_P.put(keyP, prodBP);	
				
			} else {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP = mapPBPP_P.get(keyP);
				
				prodBP.prodBrutaUB = AritmeticaUtil.somar(prodBP.prodBrutaUB, registro.prodBrutaUB);
				prodBP.prodPrevUB = AritmeticaUtil.somar(prodBP.prodPrevUB, registro.prodPrevUB);
				
				mapPBPP_P.put(keyP, prodBP);					
			}

			
			// maquinas
			if (! mapPBPP_PM.containsKey(keyPM)) {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP.id = keyPM;
				prodBP.prodBrutaUB = registro.prodBrutaUB;
				prodBP.prodPrevUB = registro.prodPrevUB;
				
				mapPBPP_PM.put(keyPM, prodBP);	
				
			} else {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP = mapPBPP_PM.get(keyPM);
				
				prodBP.prodBrutaUB = AritmeticaUtil.somar(prodBP.prodBrutaUB, registro.prodBrutaUB);
				prodBP.prodPrevUB = AritmeticaUtil.somar(prodBP.prodPrevUB, registro.prodPrevUB);
				
				mapPBPP_PM.put(keyPM, prodBP);					
			}

			
			// ferramentas
			if (! mapPBPP_PMF.containsKey(keyPMF)) {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP.id = keyPMF;
				prodBP.prodBrutaUB = registro.prodBrutaUB;
				prodBP.prodPrevUB = registro.prodPrevUB;
				
				mapPBPP_PMF.put(keyPMF, prodBP);	
				
			} else {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP = mapPBPP_PMF.get(keyPMF);
				
				prodBP.prodBrutaUB = AritmeticaUtil.somar(prodBP.prodBrutaUB, registro.prodBrutaUB);
				prodBP.prodPrevUB = AritmeticaUtil.somar(prodBP.prodPrevUB, registro.prodPrevUB);
				
				mapPBPP_PMF.put(keyPMF, prodBP);					
			}
			

			// estrutruas
			if (! mapPBPP_PMFE.containsKey(keyPMFE)) {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP.id = keyPMFE;
				prodBP.prodBrutaUB = registro.prodBrutaUB;
				prodBP.prodPrevUB = registro.prodPrevUB;
				
				mapPBPP_PMFE.put(keyPMFE, prodBP);	
				
			} else {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP = mapPBPP_PMFE.get(keyPMFE);
				
				prodBP.prodBrutaUB = AritmeticaUtil.somar(prodBP.prodBrutaUB, registro.prodBrutaUB);
				prodBP.prodPrevUB = AritmeticaUtil.somar(prodBP.prodPrevUB, registro.prodPrevUB);
				
				mapPBPP_PMFE.put(keyPMFE, prodBP);					
			}
		}

		
		
		// qtdes
		strSQL = "";		
		lista = new ArrayList<Object>();
		strSQL = getConsultaRefugos(filtroBI, cdRefugo, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosNaQuery(q, filtroBI, cdRefugo, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		
		lista = q.list();		
		for (Object reg : lista) {
			RegistroPerda registro = new RegistroPerda();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdPt = (String) registroLido[_cdpt];
			registro.dsPt = (String) registroLido[_dspt];
			registro.cdFerramenta = (String) registroLido[_cdferramenta];
			registro.cdEstrutura = (String) registroLido[_cdestrutura];
			registro.cdProduto = (String) registroLido[_cdproduto];
			registro.dsProduto = (String) registroLido[_dsproduto];
			registro.cdRefugo = (String) registroLido[_cdrefugo];
			registro.dsRefugo = (String) registroLido[_dsrefugo];
			registro.perdaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasUB]);
			registro.perdaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasGr]);
			registro.perdaUM = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasUM]);
			
			String keyP = registro.cdProduto;
			String keyPM = keyP + registro.cdPt;
			String keyPMF = keyP + registro.cdFerramenta;
			String keyPMFE = keyPMF + registro.cdEstrutura;			

			
			PerdasDetRefugo perdaRefugoReg = new PerdasDetRefugo();
			perdaRefugoReg.cdRefugo = registro.cdRefugo;
			perdaRefugoReg.dsRefugo = registro.dsRefugo;
			perdaRefugoReg.perdaUB = registro.perdaUB;
			perdaRefugoReg.perdaGr = registro.perdaGr;
			perdaRefugoReg.perdaUM  = registro.perdaUM;
			perdaRefugoReg.perdaOrdenacao = getValorPerda(ordenacao, registro);
			perdaRefugoReg.indiceUB = new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaRefugoReg.perdaUB, mapPBPP_PMFE.get(keyPMFE).prodBrutaUB));

			
			PerdasProDetFerramentaEstrutura perdaEstruturaReg = new PerdasProDetFerramentaEstrutura();
			perdaEstruturaReg.cdEstrutura = registro.cdEstrutura;
			perdaEstruturaReg.perdaUB = registro.perdaUB;
			perdaEstruturaReg.perdaGr = registro.perdaGr;
			perdaEstruturaReg.perdaUM = registro.perdaUM;
			perdaEstruturaReg.refugos.put(registro.cdRefugo, perdaRefugoReg);
			perdaEstruturaReg.prodBrutaUB = mapPBPP_PMFE.get(keyPMFE).prodBrutaUB;
			perdaEstruturaReg.prodPrevUB = mapPBPP_PMFE.get(keyPMFE).prodPrevUB;
			perdaEstruturaReg.indiceUB = new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaEstruturaReg.perdaUB, perdaEstruturaReg.prodBrutaUB));
			
			
			PerdasProDetFerramenta perdaFerramentaReg = new PerdasProDetFerramenta();
			perdaFerramentaReg.cdFerramenta = registro.cdFerramenta;
			perdaFerramentaReg.perdaUB = registro.perdaUB;
			perdaFerramentaReg.perdaGr = registro.perdaGr;
			perdaFerramentaReg.perdaUM = registro.perdaUM;
			perdaFerramentaReg.estruturas.put(registro.cdEstrutura, perdaEstruturaReg);
			perdaFerramentaReg.prodBrutaUB = mapPBPP_PMF.get(keyPMF).prodBrutaUB;
			perdaFerramentaReg.indiceUB = new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaFerramentaReg.perdaUB, perdaFerramentaReg.prodBrutaUB));

			
			PerdasProDetMaquina perdaMaquinaReg = new PerdasProDetMaquina();
			perdaMaquinaReg.cdPt = registro.cdPt;
			perdaMaquinaReg.cdIdentificacaoPt = registro.dsPt;
			perdaMaquinaReg.perdaUB = registro.perdaUB;
			perdaMaquinaReg.perdaGr = registro.perdaGr;
			perdaMaquinaReg.perdaUM = registro.perdaUM;
			perdaMaquinaReg.ferramentas.put(registro.cdFerramenta, perdaFerramentaReg);
			perdaMaquinaReg.prodBrutaUB = mapPBPP_PM.get(keyPM).prodBrutaUB;
			perdaMaquinaReg.prodPrevUB = mapPBPP_PM.get(keyPM).prodPrevUB;
			perdaMaquinaReg.indiceUB = new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaMaquinaReg.perdaUB, perdaMaquinaReg.prodBrutaUB));


			PerdasProDetProduto perdaProdutoReg = new PerdasProDetProduto();
			perdaProdutoReg.cdProduto = registro.cdProduto;
			perdaProdutoReg.dsProduto = registro.dsProduto;
			perdaProdutoReg.perdaUB = registro.perdaUB;
			perdaProdutoReg.perdaGr = registro.perdaGr;
			perdaProdutoReg.perdaUM = registro.perdaUM;
			perdaProdutoReg.maquinas.put(registro.cdPt, perdaMaquinaReg);
			perdaProdutoReg.prodBrutaUB = mapPBPP_P.get(keyP).prodBrutaUB;
			perdaProdutoReg.prodPrevUB = mapPBPP_P.get(keyP).prodPrevUB;
			perdaProdutoReg.indiceUB = new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaProdutoReg.perdaUB, perdaProdutoReg.prodBrutaUB));


			
			if (! mapResumo.containsKey(registro.cdProduto)) {
				mapResumo.put(registro.cdProduto, perdaProdutoReg);
				
			} else {
				PerdasProDetProduto perdaProduto = new PerdasProDetProduto();
				perdaProduto = mapResumo.get(registro.cdProduto);
				
				// atualiza perdas produto
				perdaProduto.perdaUB = AritmeticaUtil.somar(perdaProduto.perdaUB, registro.perdaUB);
				perdaProduto.perdaGr = AritmeticaUtil.somar(perdaProduto.perdaGr, registro.perdaGr);
				perdaProduto.perdaUM = AritmeticaUtil.somar(perdaProduto.perdaUM, registro.perdaUM);
				perdaProduto.indiceUB = new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaProduto.perdaUB, perdaProduto.prodBrutaUB));
				
				
				if (! perdaProduto.maquinas.containsKey(registro.cdPt)) {
					PerdasProDetMaquina perdaMaquina = new PerdasProDetMaquina();
					
					perdaMaquina = perdaMaquinaReg;					
					perdaProduto.maquinas.put(registro.cdPt, perdaMaquina);
					
				} else {
					PerdasProDetMaquina perdaMaquina = new PerdasProDetMaquina();
					perdaMaquina = perdaProduto.maquinas.get(registro.cdPt);
				
					// atualiza perdas maquinas
					perdaMaquina.perdaUB = AritmeticaUtil.somar(perdaMaquina.perdaUB, registro.perdaUB);
					perdaMaquina.perdaGr = AritmeticaUtil.somar(perdaMaquina.perdaGr, registro.perdaGr);
					perdaMaquina.perdaUM = AritmeticaUtil.somar(perdaMaquina.perdaUM, registro.perdaUM);
					perdaMaquina.indiceUB = new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaMaquina.perdaUB, perdaMaquina.prodBrutaUB));					
					
					
					if (! perdaMaquina.ferramentas.containsKey(registro.cdFerramenta)) {
						PerdasProDetFerramenta perdaFerramenta = new PerdasProDetFerramenta();
						perdaFerramenta = perdaFerramentaReg;		
						perdaMaquina.ferramentas.put(registro.cdFerramenta, perdaFerramenta);
						
					} else {
						PerdasProDetFerramenta perdaFerramenta = new PerdasProDetFerramenta();
						perdaFerramenta = perdaMaquina.ferramentas.get(registro.cdFerramenta);

						// atualiza ferrmentas
						perdaFerramenta.perdaUB = AritmeticaUtil.somar(perdaFerramenta.perdaUB, registro.perdaUB);
						perdaFerramenta.perdaGr = AritmeticaUtil.somar(perdaFerramenta.perdaGr, registro.perdaGr);
						perdaFerramenta.perdaUM = AritmeticaUtil.somar(perdaFerramenta.perdaUM, registro.perdaUM);
						perdaFerramenta.indiceUB = new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaFerramenta.perdaUB, perdaFerramenta.prodBrutaUB));
						
						
						if (! perdaFerramenta.estruturas.containsKey(registro.cdEstrutura)) {
							PerdasProDetFerramentaEstrutura perdaEstrutura = new PerdasProDetFerramentaEstrutura();
							perdaEstrutura = perdaEstruturaReg;
							perdaFerramenta.estruturas.put(registro.cdEstrutura, perdaEstrutura);
							
						} else {
							PerdasProDetFerramentaEstrutura perdaEstrutura = new PerdasProDetFerramentaEstrutura();
							perdaEstrutura = perdaFerramenta.estruturas.get(registro.cdEstrutura);							
							
							// atualiza estruturas
							perdaEstrutura.perdaUB = AritmeticaUtil.somar(perdaEstrutura.perdaUB, registro.perdaUB);
							perdaEstrutura.perdaGr = AritmeticaUtil.somar(perdaEstrutura.perdaGr, registro.perdaGr);
							perdaEstrutura.perdaUM = AritmeticaUtil.somar(perdaEstrutura.perdaUM, registro.perdaUM);
							perdaEstrutura.indiceUB = new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaEstrutura.perdaUB, perdaEstrutura.prodBrutaUB));
							
							perdaEstrutura.refugos.put(registro.cdRefugo, perdaRefugoReg);
							perdaFerramenta.estruturas.put(registro.cdEstrutura, perdaEstrutura);
						}
						
						perdaMaquina.ferramentas.put(registro.cdFerramenta, perdaFerramenta);
					}
					
					perdaProduto.maquinas.put(registro.cdPt, perdaMaquina);
				}
				
				mapResumo.remove(registro.cdProduto);				
				mapResumo.put(registro.cdProduto, perdaProduto);
			}

			totalCusto = AritmeticaUtil.somar(totalCusto, registro.perdaUM);
		}
		

		
		// Ordenacao por produto
		List<PerdasProDetProduto> listaPro = new ArrayList<PerdasProDetProduto>();
		listaPro.addAll(mapResumo.values());
		Collections.sort(listaPro, comparaPerdasProProduto);
		
		for (PerdasProDetProduto perdaPro : listaPro) {			
			if (resumo.getDetalhes().size() > 0) {
				BiParetoPerdasRefugoDetDTO linhaDetPerdas = new BiParetoPerdasRefugoDetDTO();
				linhaDetPerdas.setPt("");
				linhaDetPerdas.setFerramenta("");
				linhaDetPerdas.setProduto("");
				linhaDetPerdas.setCdProduto("");
				linhaDetPerdas.setRefugo("");
				linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_SEM_COR);				
				linhaDetPerdas.setPerdaUB("");
				linhaDetPerdas.setPerdaKg("");
				linhaDetPerdas.setPerdaTon("");
				linhaDetPerdas.setPerdaUM("");					
				linhaDetPerdas.setProdBrutaUB("");
				linhaDetPerdas.setProdPrevUB("");
				linhaDetPerdas.setIndRefUB("");
				
				resumo.getDetalhes().add(linhaDetPerdas);
			}
			
			
			// Ordenacao por maquina
			List<PerdasProDetMaquina> listaMaq = new ArrayList<PerdasProDetMaquina>();
			listaMaq.addAll(perdaPro.maquinas.values());
			Collections.sort(listaMaq, comparaPerdasProMaq);
			
			int contadorMaq = 0;
			for (PerdasProDetMaquina perdaMaq : listaMaq) {
				contadorMaq++;
				
				// Ordenacao por ferramenta
				List<PerdasProDetFerramenta> listaFerr = new ArrayList<PerdasProDetFerramenta>();
				listaFerr.addAll(perdaMaq.ferramentas.values());
				Collections.sort(listaFerr, comparaPerdasProMol);
				
				int contadorMol = 0;
				for (PerdasProDetFerramenta perdaFerr : listaFerr) {
					contadorMol++;
					
					// Ordenacao por estrutura
					List<PerdasProDetFerramentaEstrutura> listaEstru = new ArrayList<PerdasProDetFerramentaEstrutura>();
					listaEstru.addAll(perdaFerr.estruturas.values());
					Collections.sort(listaEstru, comparaPerdasProEstru);
					
					int contadorEstru = 0;
					for (PerdasProDetFerramentaEstrutura perdaEstru : listaEstru) {
						contadorEstru++;
						
						// Ordenacao por refugo
						List<PerdasDetRefugo> listaRef = new ArrayList<PerdasDetRefugo>();
						listaRef.addAll(perdaEstru.refugos.values());
						Collections.sort(listaRef, comparaPerdasProRefugo);
						
						int contadorRef = 0;
						for (PerdasDetRefugo perdaRef : listaRef) {
							contadorRef++;
							
							BiParetoPerdasRefugoDetDTO linhaDetPerdas = new BiParetoPerdasRefugoDetDTO();
							
							if (contadorMaq == 1 && contadorMol == 1 && contadorEstru == 1 && contadorRef == 1) {
								linhaDetPerdas.setProduto(perdaPro.cdProduto + " (" + perdaPro.dsProduto + ")");
								linhaDetPerdas.setCdProduto(perdaPro.cdProduto);
							} else {
								linhaDetPerdas.setProduto("");
								linhaDetPerdas.setCdProduto("");
							}
							
							if (contadorMol == 1 && contadorEstru == 1 && contadorRef == 1) {
								linhaDetPerdas.setPt(perdaMaq.cdPt + "/" + perdaMaq.cdIdentificacaoPt);
							} else {
								linhaDetPerdas.setPt("");	
							}

							if (contadorRef == 1) {
								linhaDetPerdas.setFerramenta(perdaFerr.cdFerramenta);
							} else {
								linhaDetPerdas.setFerramenta("");	
							}


							linhaDetPerdas.setRefugo(perdaRef.cdRefugo + " (" + perdaRef.dsRefugo + ")");
							linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_SEM_COR);				
							
							linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaRef.perdaUB));
							linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaRef.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
							linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaRef.perdaGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
							linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaRef.perdaUM, 2));							
							
							linhaDetPerdas.setProdBrutaUB("");
							linhaDetPerdas.setProdPrevUB("");
							linhaDetPerdas.setIndRefUB("");
							
							resumo.getDetalhes().add(linhaDetPerdas);							
						}
						
						// total do molde/estrutura
						BiParetoPerdasRefugoDetDTO linhaDetPerdas = new BiParetoPerdasRefugoDetDTO();
						linhaDetPerdas.setPt("");
						linhaDetPerdas.setFerramenta("");
						linhaDetPerdas.setProduto("");
						linhaDetPerdas.setCdProduto("");
						linhaDetPerdas.setRefugo(TEXTO_CELULA_PERDA_REFUGO_SUB_TOTAL_MOLDE);
						linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_PERDA_REFUGO_SUB_TOTAL_MOLDE);				
						linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaEstru.perdaUB));
						linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaEstru.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
						linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaEstru.perdaGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
						linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaEstru.perdaUM, 2));							
						linhaDetPerdas.setProdBrutaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaEstru.prodBrutaUB));
						linhaDetPerdas.setProdPrevUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaEstru.prodPrevUB));
						linhaDetPerdas.setIndRefUB(ConversaoTipos.converteParaString(perdaEstru.indiceUB, 2));
						
						resumo.getDetalhes().add(linhaDetPerdas);						

						
					}
				}
				
				// total da maquina
				BiParetoPerdasRefugoDetDTO linhaDetPerdas = new BiParetoPerdasRefugoDetDTO();
				linhaDetPerdas.setPt("");
				linhaDetPerdas.setFerramenta("");
				linhaDetPerdas.setProduto("");
				linhaDetPerdas.setCdProduto("");
				linhaDetPerdas.setRefugo(TEXTO_CELULA_PERDA_REFUGO_SUB_TOTAL_MAQUINA);
				linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_PERDA_REFUGO_SUB_TOTAL_MAQUINA);				
				linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaMaq.perdaUB));
				linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaMaq.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
				linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaMaq.perdaGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
				linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaMaq.perdaUM, 2));							
				linhaDetPerdas.setProdBrutaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaMaq.prodBrutaUB));
				linhaDetPerdas.setProdPrevUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaMaq.prodPrevUB));
				linhaDetPerdas.setIndRefUB(ConversaoTipos.converteParaString(perdaMaq.indiceUB, 2));
				
				resumo.getDetalhes().add(linhaDetPerdas);														

			}
			
			// linha em branco
			BiParetoPerdasRefugoDetDTO linhaDetPerdas = new BiParetoPerdasRefugoDetDTO();
			linhaDetPerdas.setPt("");
			linhaDetPerdas.setFerramenta("");
			linhaDetPerdas.setProduto("");
			linhaDetPerdas.setCdProduto("");
			linhaDetPerdas.setRefugo("");
			linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_SEM_COR);				
			linhaDetPerdas.setPerdaUB("");
			linhaDetPerdas.setPerdaKg("");
			linhaDetPerdas.setPerdaTon("");
			linhaDetPerdas.setPerdaUM("");					
			linhaDetPerdas.setProdBrutaUB("");
			linhaDetPerdas.setProdPrevUB("");
			linhaDetPerdas.setIndRefUB("");
			
			resumo.getDetalhes().add(linhaDetPerdas);
			
			// perda da maquina
			linhaDetPerdas = new BiParetoPerdasRefugoDetDTO();
			linhaDetPerdas.setPt("");
			linhaDetPerdas.setFerramenta("");
			linhaDetPerdas.setProduto("");
			linhaDetPerdas.setCdProduto("");
			linhaDetPerdas.setRefugo(TEXTO_CELULA_PERDA_REFUGO_SUB_TOTAL_PRODUTO);
			linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_PERDA_REFUGO_SUB_TOTAL_PRODUTO);				
			linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaPro.perdaUB));
			linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaPro.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
			linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaPro.perdaGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
			linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaPro.perdaUM, 2));							
			linhaDetPerdas.setProdBrutaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaPro.prodBrutaUB));
			linhaDetPerdas.setProdPrevUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaPro.prodPrevUB));
			linhaDetPerdas.setIndRefUB(ConversaoTipos.converteParaString(perdaPro.indiceUB, 2));
			
			resumo.getDetalhes().add(linhaDetPerdas);											
			
		}

		resumo.setTotalCusto(ConversaoTipos.converteParaString(totalCusto, 2));
		
		resumo.setTotalProdUB(filtroBI.getIndicadores().getPcsProdBruta());
		resumo.setTotalProdKg(filtroBI.getIndicadores().getPcsProdBrutaKg());
		resumo.setTotalProdTon(filtroBI.getIndicadores().getPcsProdBrutaTon());

		resumo.setTotalRefugoUB(filtroBI.getIndicadores().getPcsProdRefugada());
		resumo.setTotalRefugoKg(filtroBI.getIndicadores().getPcsProdRefugadaKg());
		resumo.setTotalRefugoTon(filtroBI.getIndicadores().getPcsProdRefugadaTon());

		resumo.setIndRef(filtroBI.getIndicadores().getIndRef());
		resumo.setIndRefGr(filtroBI.getIndicadores().getIndRefGr());
		
		return resumo;			
	}

	private String getConsultaRefugos(BiFiltroDTO filtroBI, String cdRefugo, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		String strSQL;

		strSQL = "";
		strSQL = strSQL.concat("SELECT b.cdinjestendido, b.cdidentific, c.cdmolestendido, a.cdestrutura, mp.cdproduto, f.dsproduto, a.cdrefugo, tr.dsrefugo, ");
		strSQL = strSQL.concat("       SUM(a.qtrefugada / dc.divisorUB) as qtdRefUB, ");
		strSQL = strSQL.concat("       SUM( (a.qtrefugada / dc.divisorUB) * mp.pbrutomedio ) as qtdRefGr,");
		strSQL = strSQL.concat("       SUM( (a.qtrefugada / dc.divisorUB) * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdRefUM ");
		
		// tabelas
		strSQL = strSQL.concat("  FROM ijrearef a ");
		strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
		strSQL = strSQL.concat("  JOIN ijcnsTurIniFim ht ON (ht.dtref BETWEEN :dtini AND :dtfim) ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbref tr ON (tr.cdrefugo = a.cdrefugo) ");
		strSQL = strSQL.concat("  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL.concat("  JOIN ijmolpro mp ON (mp.cdmolde = ft.cdmolde AND mp.cdestrutura = ft.cdestrutura AND mp.dthrival = ft.dthrivalestru AND mp.cdidentificacao = a.cdidentificacao) ");
		strSQL = strSQL.concat("  JOIN ijtbpro f ON (f.cdproduto = mp.cdproduto) ");

		// tabelas relacionados a maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");		
		} else {			
			strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = a.cdinjetora) ");
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");	
		}

		
		// filtros
		strSQL = strSQL.concat(" WHERE (a.lcancelado = 0  OR a.lcancelado IS NULL) ");
		strSQL = strSQL.concat("   AND a.dthrirefugo BETWEEN ht.dthrini AND ht.dthrfim ");
		
		
		if (! cdRefugo.equals("")) {
			strSQL = strSQL.concat(" AND a.cdrefugo  = :cdrefugo ");
		}
		if (! cdPtSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND b.cdinjestendido  = :cdptSelecaoPareto ");
		}
		if (! cdProdutoSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND mp.cdproduto  = :cdprodutoSelecaoPareto ");
		}
		
		
		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cdturno = :cdturno ");
		}		

		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND b.cdinjestendido = :cdpt ");	
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");		
			} else {			
				strSQL = strSQL.concat("  AND cm.classe = :cdclasse ");
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND c.cdmolestendido = :cdrap ");	
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");	
		}
		
		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat("  AND mp.cdproduto = :cdproduto ");	
		}

		strSQL = strSQL.concat(" GROUP BY b.cdinjestendido, b.cdidentific, c.cdmolestendido, a.cdestrutura, mp.cdproduto, f.dsproduto, a.cdrefugo, tr.dsrefugo ");
				
		return strSQL;
	}

	private String getConsultaProdBrutaProdPrev(BiFiltroDTO filtroBI, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		String strSQL;

		strSQL = "";
		strSQL = strSQL.concat("SELECT a.cdinjestendido, i.cdidentific, a.cdmolestendido, a.cdestrutura, a.cdproduto, f.dsproduto, ");
		strSQL = strSQL.concat("       SUM(a.prodbruta) as prodbruta, ");
		strSQL = strSQL.concat("       SUM(a.prodprev) as prodprev ");
		
		// tabelas
		strSQL = strSQL.concat("  FROM viewBIDtRefProdutos a ");
		strSQL = strSQL.concat("  JOIN ijtbpro f ON (f.cdproduto = a.cdproduto) ");
		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");


		// tabelas relacionados a maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");		
		} else {			
			strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = a.cdinjetora) ");
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");	
		}

		
		// filtros
		strSQL = strSQL.concat(" WHERE a.dtturno BETWEEN :dtini AND :dtfim ");
		
		
		if (! cdPtSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND a.cdinjestendido  = :cdptSelecaoPareto ");
		}
		if (! cdProdutoSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND a.cdproduto  = :cdprodutoSelecaoPareto ");
		}
		
		
		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cdturno = :cdturno ");
		}		

		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND a.cdinjestendido = :cdpt ");	
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");		
			} else {			
				strSQL = strSQL.concat("  AND cm.classe = :cdclasse ");
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND a.cdmolestendido = :cdrap ");	
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");	
		}
		
		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat("  AND a.cdproduto = :cdproduto ");	
		}

		strSQL = strSQL.concat(" GROUP BY a.cdinjestendido, i.cdidentific, a.cdmolestendido, a.cdestrutura, a.cdproduto, f.dsproduto ");
				
		return strSQL;
	}

	private SQLQuery setFiltrosNaQuery(SQLQuery q, BiFiltroDTO filtroBI, String cdRefugo, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		q.setTimestamp("dthrini", filtroBI.getDtIniDt());
		q.setTimestamp("dthrfim", filtroBI.getDtFimDt());
		

		if (! cdRefugo.equals("")) {
			q.setString("cdrefugo", cdRefugo);
		}

		if (! cdPtSelecaoPareto.equals("")) {
			q.setString("cdptSelecaoPareto", cdPtSelecaoPareto);
		}
		
		if (! cdProdutoSelecaoPareto.equals("")) {
			q.setString("cdprodutoSelecaoPareto", cdProdutoSelecaoPareto);
		}
		
		if (!filtroBI.getCdTurno().equals("")) {
			q.setString("cdturno", filtroBI.getCdTurno());
		}
				
		if (!filtroBI.getCdPt().equals("")) {
			q.setString("cdpt", filtroBI.getCdPt());
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				q.setString("cdgt", filtroBI.getCdGt());
			} else {			
				q.setString("cdclasse", filtroBI.getCdClasseMaquina());
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			q.setString("cdrap", filtroBI.getCdRap());
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			q.setString("cdgrprap", filtroBI.getCdGrpRap());
		}
		
		if (!filtroBI.getCdProduto().equals("")) {
			q.setString("cdproduto", filtroBI.getCdProduto());
		}
		
		return q;
	}
		
	private BigDecimal getValorPerda(UnidadeExibicaoOuOrdenacaoQtdBI ordenacao, RegistroPerda registro) {
		BigDecimal valor = BigDecimal.ZERO;
		
		if (ordenacao == UnidadeExibicaoOuOrdenacaoQtdBI.QTD_PARETO_PERDAS_BI_EM_UB) {
			valor = registro.perdaUB;
		} else {
			if (ordenacao == UnidadeExibicaoOuOrdenacaoQtdBI.QTD_PARETO_PERDAS_BI_EM_UM) {
				valor = registro.perdaUM;	
			}  else {
				valor = registro.perdaGr;
			}
		}
		
		return valor;		
	}
	
}
