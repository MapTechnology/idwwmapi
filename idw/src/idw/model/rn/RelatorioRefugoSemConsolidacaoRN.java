package idw.model.rn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolrelog;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroRelatorioIndiceDiarioDTO;
import idw.webservices.dto.ListaRelatorioRefugoSemConsolidacaoDTO;
import idw.webservices.dto.RelatorioRefugoSemConsolidacaoDTO;

public class RelatorioRefugoSemConsolidacaoRN extends AbstractRN<DAOGenerico>{

	public RelatorioRefugoSemConsolidacaoRN() {
		this(null);
	}

	public RelatorioRefugoSemConsolidacaoRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	
	public ListaRelatorioRefugoSemConsolidacaoDTO getListaRelatorioRefugoSemConsolidacaoDTO(FiltroRelatorioIndiceDiarioDTO filtro){
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioRefugoSemConsolidacaoRN.getListaRelatorioRefugoSemConsolidacaoDTO");
		log.info( idLog , 0, "RelatorioRefugoSemConsolidacaoRN.getListaRelatorioRefugoSemConsolidacaoDTO filtro usado:" + filtro.toString());
		
		List<DwConsolrelog>listaConsolrelog = new ArrayList<DwConsolrelog>();
		listaConsolrelog.addAll(consultaRelatorioRefugoSemConsolidacao(filtro));
		
		ListaRelatorioRefugoSemConsolidacaoDTO retorno = new ListaRelatorioRefugoSemConsolidacaoDTO();
		if (filtro.getTipo().equals("maquina")) {
			retorno = montarRelatorioRefugoSemConsolidacaoPorMaquina(filtro,listaConsolrelog);
		}
		if(filtro.getTipo().equals("produto")){
			retorno = montarRelatorioRefugoSemConsolidacaoPorProduto(filtro,listaConsolrelog);
		}
		if (filtro.getTipo().equals("refugo")) {
			retorno = montarRelatorioRefugoSemConsolidacao(filtro,listaConsolrelog);
		}
		log.mostrarAvaliacaoCompleta();		
		return retorno;

	}
	private List<DwConsolrelog> consultaRelatorioRefugoSemConsolidacao(FiltroRelatorioIndiceDiarioDTO filtro) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT consolrelog");
		q.append("FROM DwConsolrelog consolrelog");
		q.append("JOIN consolrelog.dwConsolreocos consolreoco");
		q.append("JOIN consolreoco.dwConsolre consolre");
		q.append("JOIN consolre.dwConsol consol");
		q.append("JOIN consol.dwConsolid consolid");
		q.append("JOIN consolrelog.omPt ompt");
		q.append("JOIN consolrelog.omProduto omproduto");
		q.append("JOIN consolrelog.dwTRefugo tRefugo");
		q.append("WHERE ompt.stAtivo = :stAtivo");
		q.append("AND omproduto.stAtivo = :stAtivo");
		
		
		if(filtro.getDt_inicio() != null && filtro.getDt_final() != null){
			q.append("AND consolid.dtReferencia BETWEEN :dataincial and :datafinal");
		}
		
		if(filtro.getOmpt()!= null){
			q.append("AND consolrelog.omPt.cdPt = :cdpt");
		}
		if (filtro.getTurnoDTO() != null) {
			q.append("AND consolid.dwTurno.idTurno = :idturno");
		}
		q.defineParametro("stAtivo", (byte) 1);
		
		if(filtro.getDt_inicio() != null && filtro.getDt_final() != null){
			q.defineParametroTimestamp("dataincial", filtro.getDt_inicio());
			q.defineParametroTimestamp("datafinal",DataHoraRN.getDataHora235959(filtro.getDt_final()));
		}
		if (filtro.getTurnoDTO() != null) {
			q.defineParametro("idturno", filtro.getTurnoDTO().getTurno().getIdTurno());
		}
		
		if (filtro.getOmpt() != null) {
			q.defineParametro("cdpt", filtro.getOmpt().getCdPt());
		}

		return q.list();
	}
	
	private ListaRelatorioRefugoSemConsolidacaoDTO montarRelatorioRefugoSemConsolidacaoPorMaquina(FiltroRelatorioIndiceDiarioDTO filtro,List<DwConsolrelog>listaConsolrelog){
		
		ListaRelatorioRefugoSemConsolidacaoDTO retorno = new ListaRelatorioRefugoSemConsolidacaoDTO();
		retorno.setListaRelatorioRefugoSemConsolidacao(new ArrayList<RelatorioRefugoSemConsolidacaoDTO>());
		
		HashMap<String, RelatorioRefugoSemConsolidacaoDTO> mapRelatorio = new HashMap<>();
		HashMap<String, Double>qtdRefugadoPorMaquina =  new HashMap<>();
		HashMap<String, Double> qtdRefugadoPorProduto =  new HashMap<>();
		
		if (filtro.isPeca()) {
			for(DwConsolrelog consolrelog : listaConsolrelog ){
				int qtdRefugada = consolrelog.getPcsAutoProducaorefugada()!= null ?consolrelog.getPcsAutoProducaorefugada().intValue():0;
				String produto = consolrelog.getOmProduto().getCdProduto()+"-"+consolrelog.getOmProduto().getDsProduto();
				String maquina = consolrelog.getOmPt().getDsPt() ;
				String refugo =  consolrelog.getDwTRefugo()!=null ? consolrelog.getDwTRefugo().getCdTrefugo()+""+ consolrelog.getDwTRefugo().getDsTrefugo():"";
				
				String chave =  maquina+produto+refugo;
			RelatorioRefugoSemConsolidacaoDTO relatorio = mapRelatorio.get(chave);
			if(relatorio == null ){
				relatorio = new RelatorioRefugoSemConsolidacaoDTO();
				relatorio.setMaquina(maquina);
				relatorio.setProduto(produto);
				relatorio.setRefugo(refugo);
				relatorio.setQtdRefugada(new Double(qtdRefugada));
		
				mapRelatorio.put(chave, relatorio);
			}else{
				int qtdRefAux = qtdRefugada + relatorio.getQtdRefugada().intValue();
				relatorio.setQtdRefugada(new Double(qtdRefAux));

			}

			}

		
	for(String  chave :  mapRelatorio.keySet()){
			
		RelatorioRefugoSemConsolidacaoDTO relatorio = mapRelatorio.get(chave);
		
		String chaveAux =  relatorio.getProduto()+relatorio.getMaquina();
		Double  qtdrefMaquina = qtdRefugadoPorMaquina.get(chaveAux);
		
			if (qtdrefMaquina == null) {
				qtdRefugadoPorMaquina.put(chaveAux, relatorio.getQtdRefugada());
			} else {
				qtdRefugadoPorMaquina.put(chaveAux, relatorio.getQtdRefugada()+ qtdrefMaquina);
			}
			
			String chaveAux2 =  relatorio.getProduto();
			Double qtdrefProduto = qtdRefugadoPorProduto.get(chaveAux2);
			
			if(qtdrefProduto==null){
				qtdRefugadoPorProduto.put(chaveAux2, relatorio.getQtdRefugada());
				
			}else{
				qtdRefugadoPorProduto.put(chaveAux2, relatorio.getQtdRefugada()+qtdrefProduto);
			}
			retorno.getListaRelatorioRefugoSemConsolidacao().add(relatorio);
		}
	
		Comparator<RelatorioRefugoSemConsolidacaoDTO>comparator = new Comparator<RelatorioRefugoSemConsolidacaoDTO>() {

			@Override
			public int compare(RelatorioRefugoSemConsolidacaoDTO o1,RelatorioRefugoSemConsolidacaoDTO o2) {
				String prod =  o1.getProduto();
				String prod2 = o2.getProduto();
				return prod.compareTo(prod2) * +1;
			}		
		};
		Collections.sort(retorno.getListaRelatorioRefugoSemConsolidacao(),comparator);
	
		return retorno;
		}else{
			int peso = 0;
			
			if(filtro.getUnidMedida().equals("kilo")){
				peso = 1000;
			}else
				if(filtro.getUnidMedida().equals("ton")){
					peso= 1000000;
				}

				for(DwConsolrelog consolrelog :listaConsolrelog ){
					String produto = consolrelog.getOmProduto().getCdProduto()+"-"+consolrelog.getOmProduto().getDsProduto();
					String maquina = consolrelog.getOmPt().getDsPt() ;
					String refugo =  consolrelog.getDwTRefugo()!=null ? consolrelog.getDwTRefugo().getCdTrefugo()+"-"+ consolrelog.getDwTRefugo().getDsTrefugo():"";
				
					double qtdRefugada = ((consolrelog.getPcsAutoProducaorefugada()!= null ?consolrelog.getPcsAutoProducaorefugada().doubleValue():0.0)*
										(consolrelog.getOmProduto().getGPesoLiquido() != null ? consolrelog.getOmProduto().getGPesoLiquido().doubleValue() : 0.0))/peso	;
					
					String chave =  maquina+produto+refugo;
					RelatorioRefugoSemConsolidacaoDTO relatorio = mapRelatorio.get(chave);
						if(relatorio == null ){
							relatorio = new RelatorioRefugoSemConsolidacaoDTO();
				
							relatorio.setProduto(produto);
							relatorio.setRefugo(refugo);
							relatorio.setQtdRefugada(qtdRefugada);
							relatorio.setMaquina(maquina);
							mapRelatorio.put(chave, relatorio);
						}else{
							double qtdRefAux = qtdRefugada + relatorio.getQtdRefugada();
							relatorio.setQtdRefugada(qtdRefAux);
						}
				}
				

		}
		for(String  chave :  mapRelatorio.keySet()){
			
		RelatorioRefugoSemConsolidacaoDTO relatorio = mapRelatorio.get(chave);
		
		String chaveAux =  relatorio.getProduto()+relatorio.getMaquina();
		Double  qtdrefMaquina = qtdRefugadoPorMaquina.get(chaveAux);
		
			if (qtdrefMaquina == null) {
				qtdRefugadoPorMaquina.put(chaveAux, relatorio.getQtdRefugada());
			} else {
				qtdRefugadoPorMaquina.put(chaveAux, relatorio.getQtdRefugada()+ qtdrefMaquina);
			}
			
			String chaveAux2 =  relatorio.getProduto();
			Double qtdrefProduto = qtdRefugadoPorProduto.get(chaveAux2);
			
			if(qtdrefProduto==null){
				qtdRefugadoPorProduto.put(chaveAux2, relatorio.getQtdRefugada());
				
			}else{
				qtdRefugadoPorProduto.put(chaveAux2, relatorio.getQtdRefugada()+qtdrefProduto);
			}
			retorno.getListaRelatorioRefugoSemConsolidacao().add(relatorio);
		}
	
		Comparator<RelatorioRefugoSemConsolidacaoDTO>comparator = new Comparator<RelatorioRefugoSemConsolidacaoDTO>() {

			@Override
			public int compare(RelatorioRefugoSemConsolidacaoDTO o1,RelatorioRefugoSemConsolidacaoDTO o2) {
				String prod =  o1.getProduto();
				String prod2 = o2.getProduto();
				return prod.compareTo(prod2) * +1;
			}		
		};
		Collections.sort(retorno.getListaRelatorioRefugoSemConsolidacao(),comparator);
	
		return retorno;
	}
	
	private ListaRelatorioRefugoSemConsolidacaoDTO montarRelatorioRefugoSemConsolidacaoPorProduto(FiltroRelatorioIndiceDiarioDTO filtro,List<DwConsolrelog>listaConsolrelog) {
		ListaRelatorioRefugoSemConsolidacaoDTO retorno = new ListaRelatorioRefugoSemConsolidacaoDTO();
		retorno.setListaRelatorioRefugoSemConsolidacao(new ArrayList<RelatorioRefugoSemConsolidacaoDTO>());
	
		HashMap<String, RelatorioRefugoSemConsolidacaoDTO>mapRelatorio = new HashMap<>();
		HashMap<String, Double> qtdRefugadoPorProduto =  new HashMap<>();
	
		if(filtro.isPeca()){
		for(DwConsolrelog consolrelog :listaConsolrelog){
			int qtdRefugada = consolrelog.getPcsAutoProducaorefugada()!= null ?consolrelog.getPcsAutoProducaorefugada().intValue():0;
			String produto = consolrelog.getOmProduto().getCdProduto()+"-"+consolrelog.getOmProduto().getDsProduto();
			String refugo =  consolrelog.getDwTRefugo()!=null ? consolrelog.getDwTRefugo().getCdTrefugo()+" "+ consolrelog.getDwTRefugo().getDsTrefugo():"";
			
			String chave =  produto+refugo;
			RelatorioRefugoSemConsolidacaoDTO relatorio = mapRelatorio.get(chave);
				if(relatorio == null ){
					relatorio = new RelatorioRefugoSemConsolidacaoDTO();
		
					relatorio.setProduto(produto);
					relatorio.setRefugo(refugo);
					relatorio.setQtdRefugada(new Double(qtdRefugada));
		
					mapRelatorio.put(chave, relatorio);
				}else{
					int qtdRefAux = qtdRefugada + relatorio.getQtdRefugada().intValue();
					relatorio.setQtdRefugada(new Double(qtdRefAux));
				}
			
		}
			
			for(String  chave :  mapRelatorio.keySet()){
				int totalFimRefugo =0;
				RelatorioRefugoSemConsolidacaoDTO relatorio = mapRelatorio.get(chave);
					String chaveAux =  relatorio.getProduto();
					Double qtdrefProduto = qtdRefugadoPorProduto.get(chaveAux);
					totalFimRefugo += relatorio.getQtdRefugada().intValue();
					
					if(qtdrefProduto==null){
					
						qtdRefugadoPorProduto.put(chaveAux, relatorio.getQtdRefugada());
						
					}else{
						qtdRefugadoPorProduto.put(chaveAux, relatorio.getQtdRefugada()+qtdrefProduto);
					}
					retorno.getListaRelatorioRefugoSemConsolidacao().add(relatorio);
					retorno.setTotalRefugado(new Double (totalFimRefugo));
				}
			
				Comparator<RelatorioRefugoSemConsolidacaoDTO>comparator = new Comparator<RelatorioRefugoSemConsolidacaoDTO>() {

					@Override
					public int compare(RelatorioRefugoSemConsolidacaoDTO o1,RelatorioRefugoSemConsolidacaoDTO o2) {
						String prod =  o1.getProduto();
						String prod2 = o2.getProduto();
						return prod.compareTo(prod2) * +1;
					}		
				};
				Collections.sort(retorno.getListaRelatorioRefugoSemConsolidacao(),comparator);
		
				return retorno;
		}else{
			int peso = 0;
			
			if(filtro.getUnidMedida().equals("kilo")){
				peso = 1000;
			}else
				if(filtro.getUnidMedida().equals("ton")){
					peso= 1000000;
				}
			for(DwConsolrelog consolrelog :listaConsolrelog){
				double qtdRefugada = ((consolrelog.getPcsAutoProducaorefugada()!= null ?consolrelog.getPcsAutoProducaorefugada().doubleValue():0.0)*
						(consolrelog.getOmProduto().getGPesoLiquido() != null ? consolrelog.getOmProduto().getGPesoLiquido().doubleValue() : 0.0))/peso	;
				String produto = consolrelog.getOmProduto().getCdProduto()+"-"+consolrelog.getOmProduto().getDsProduto();
			
				String refugo =  consolrelog.getDwTRefugo()!=null ? consolrelog.getDwTRefugo().getCdTrefugo()+""+ consolrelog.getDwTRefugo().getDsTrefugo():"";
				String chave =  produto+refugo;
				RelatorioRefugoSemConsolidacaoDTO relatorio = mapRelatorio.get(chave);
					if(relatorio == null ){
						relatorio = new RelatorioRefugoSemConsolidacaoDTO();
			
						relatorio.setProduto(produto);
						relatorio.setRefugo(refugo);
						relatorio.setQtdRefugada(qtdRefugada);
						mapRelatorio.put(chave, relatorio);
					}else{
						double qtdRefAux = qtdRefugada + relatorio.getQtdRefugada();
						relatorio.setQtdRefugada(qtdRefAux);
					}
			}
		

		double totalFimRefugo = 0.0;
		for(String  chave :  mapRelatorio.keySet()){
			RelatorioRefugoSemConsolidacaoDTO relatorio = mapRelatorio.get(chave);
				String chaveAux =  relatorio.getProduto();
				Double qtdrefProduto = qtdRefugadoPorProduto.get(chaveAux);
				
				if(qtdrefProduto==null){
					totalFimRefugo = totalFimRefugo + relatorio.getQtdRefugada();
					qtdRefugadoPorProduto.put(chaveAux, relatorio.getQtdRefugada());
					
				}else{
					totalFimRefugo = totalFimRefugo + relatorio.getQtdRefugada();
					qtdRefugadoPorProduto.put(chaveAux, relatorio.getQtdRefugada()+qtdrefProduto);
				}
				retorno.getListaRelatorioRefugoSemConsolidacao().add(relatorio);
				retorno.setTotalRefugado(totalFimRefugo);
			}
		
		}
		Comparator<RelatorioRefugoSemConsolidacaoDTO>comparator = new Comparator<RelatorioRefugoSemConsolidacaoDTO>() {

			@Override
			public int compare(RelatorioRefugoSemConsolidacaoDTO o1,RelatorioRefugoSemConsolidacaoDTO o2) {
				String prod =  o1.getProduto();
				String prod2 = o2.getProduto();
				return prod.compareTo(prod2) * +1;
			}		
		};
		Collections.sort(retorno.getListaRelatorioRefugoSemConsolidacao(),comparator);
		
		return retorno;
	
	}
	private ListaRelatorioRefugoSemConsolidacaoDTO montarRelatorioRefugoSemConsolidacao(FiltroRelatorioIndiceDiarioDTO filtro,List<DwConsolrelog>listaConsolrelog) {
		ListaRelatorioRefugoSemConsolidacaoDTO retorno = new ListaRelatorioRefugoSemConsolidacaoDTO();
		retorno.setListaRelatorioRefugoSemConsolidacao(new ArrayList<RelatorioRefugoSemConsolidacaoDTO>());
		HashMap<String, RelatorioRefugoSemConsolidacaoDTO> mapRelatorio = new HashMap<>();
		if(filtro.isPeca()){
			
			for(DwConsolrelog consolrelog : listaConsolrelog){
				int	qtdRefugado  = consolrelog.getPcsAutoProducaorefugada()!= null ?consolrelog.getPcsAutoProducaorefugada().intValue() :0;
				String refugo = consolrelog.getDwTRefugo().getCdTrefugo()+" - " +consolrelog.getDwTRefugo().getDsTrefugo(); 
		 
				String chave = refugo;
				RelatorioRefugoSemConsolidacaoDTO relatorio = mapRelatorio.get(chave);
		
				if(relatorio == null){
					relatorio = new RelatorioRefugoSemConsolidacaoDTO();
					relatorio.setRefugo(refugo);
					relatorio.setQtdRefugada(new Double(qtdRefugado));
					mapRelatorio.put(chave, relatorio);
				}else{
					int qtdRefAux = qtdRefugado + relatorio.getQtdRefugada().intValue();
					relatorio.setQtdRefugada(new Double(qtdRefAux));
				}
			}
			int totalQtdRefugo = 0;
			for (String chave : mapRelatorio.keySet()) {
				RelatorioRefugoSemConsolidacaoDTO relatorio = mapRelatorio.get(chave);
				totalQtdRefugo = totalQtdRefugo + relatorio.getQtdRefugada().intValue();
				
				retorno.getListaRelatorioRefugoSemConsolidacao().add(relatorio);
			}
			retorno.setTotalRefugado(new Double (totalQtdRefugo));
			Comparator<RelatorioRefugoSemConsolidacaoDTO>comparator = new Comparator<RelatorioRefugoSemConsolidacaoDTO>() {

				@Override
				public int compare(RelatorioRefugoSemConsolidacaoDTO o1,RelatorioRefugoSemConsolidacaoDTO o2) {
					String ref =  o1.getRefugo();
					String ref2 = o2.getRefugo();
					return ref.compareTo(ref2) * +1;
				}		
			};
			Collections.sort(retorno.getListaRelatorioRefugoSemConsolidacao(),comparator);
			return retorno;
	}else{
		int peso = 0;
		
		if(filtro.getUnidMedida().equals("kilo")){
			peso = 1000;
		}else
			if(filtro.getUnidMedida().equals("ton")){
				peso= 1000000;
			}
			for(DwConsolrelog consolrelog : listaConsolrelog){
				double	qtdRefugado  = ((consolrelog.getPcsAutoProducaorefugada()!= null ? consolrelog.getPcsAutoProducaorefugada().doubleValue():0.0)*
						(consolrelog.getOmProduto().getGPesoLiquido() != null ? consolrelog.getOmProduto().getGPesoLiquido().doubleValue():0.0))/peso	;

				String refugo = consolrelog.getDwTRefugo().getCdTrefugo()+" - " +consolrelog.getDwTRefugo().getDsTrefugo(); 
				
				String chave = refugo;
				
				RelatorioRefugoSemConsolidacaoDTO relatorio = mapRelatorio.get(chave);
				if (relatorio == null) {
					relatorio = new RelatorioRefugoSemConsolidacaoDTO();
					relatorio.setQtdRefugada(new Double(qtdRefugado));
					relatorio.setRefugo(refugo);
				
					mapRelatorio.put(chave, relatorio);
				} else {
					double qtdRefAux = qtdRefugado + relatorio.getQtdRefugada();
					relatorio.setQtdRefugada(qtdRefAux);
				}
			}
	}
		double totalQtdRefugo = 0;
		for(String chave : mapRelatorio.keySet()){
			RelatorioRefugoSemConsolidacaoDTO relatorio =  mapRelatorio.get(chave);
			totalQtdRefugo = totalQtdRefugo + relatorio.getQtdRefugada();
			
			retorno.getListaRelatorioRefugoSemConsolidacao().add(relatorio);
		}
		retorno.setTotalRefugado(totalQtdRefugo);
		Comparator<RelatorioRefugoSemConsolidacaoDTO>comparator = new Comparator<RelatorioRefugoSemConsolidacaoDTO>() {

			@Override
			public int compare(RelatorioRefugoSemConsolidacaoDTO o1,RelatorioRefugoSemConsolidacaoDTO o2) {
				String ref =  o1.getRefugo();
				String ref2 = o2.getRefugo();
				return ref.compareTo(ref2) * +1;
			}		
		};
		Collections.sort(retorno.getListaRelatorioRefugoSemConsolidacao(),comparator);
		return retorno;

	}

}

