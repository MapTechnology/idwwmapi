package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTParada;
import idw.util.FormulasInjet;
import idw.webservices.dto.FiltroRelatorioIndiceParadasDTO;
import idw.webservices.dto.ListaRelatorioIndiceParadaMoldeDTO;
import idw.webservices.dto.RelatorioIndiceParadasMoldeDTO;
import ms.util.ConversaoTipos;

public class RelatorioIndiceParadasMoldesRN extends AbstractParadaRN{

	// Os dois maps abaixo estao sendo usados no modelo padrao
	private Map<String, BigDecimal> totaisParadasMoldeEMaquina = new HashMap<>();
	
	
	public RelatorioIndiceParadasMoldesRN() {
		this(null);
	}
	
	
	public RelatorioIndiceParadasMoldesRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public ListaRelatorioIndiceParadaMoldeDTO getConsolpasMoldeDTO(FiltroRelatorioIndiceParadasDTO filtro) {
		List<DwConsolpa> listaConsolpa = new ArrayList<>();
		MapQuery q = new MapQuery(getDaoSession());
		ListaRelatorioIndiceParadaMoldeDTO retorno = new ListaRelatorioIndiceParadaMoldeDTO();
	
		Map<String, Map<String, BigDecimal>> mapTempoAtivoMaquinas = getTempoAtivoPT(q, filtro);
		
		if (filtro.getIsTodasParadas() == true && filtro.getIsTodasAreas() == true) {
			listaConsolpa.addAll(getListaDwConsolpa(q, filtro, null, null));

		} else if (filtro.getDwTParadas() != null && filtro.getDwTAreas() == null) {
			for (DwTParada parada : filtro.getDwTParadas()) {
				listaConsolpa.addAll(getListaDwConsolpa(q, filtro, parada, null));
			}

		} else if (filtro.getDwTAreas() != null && filtro.getDwTParadas() == null) {
			for (DwTArea area : filtro.getDwTAreas()) {
				listaConsolpa.addAll(getListaDwConsolpa(q, filtro, null, area));
			}
		} else {
			for (DwTArea area : filtro.getDwTAreas()) {
				for (DwTParada parada : filtro.getDwTParadas()) {
					listaConsolpa.addAll(getListaDwConsolpa(q, filtro, parada, area));
				}
			}
		}

		if (!listaConsolpa.isEmpty()) {
			if(filtro.getTipo().equals("padrao")) {
				retorno = montaRelatorioIndiceParadaMoldePadrao(listaConsolpa, mapTempoAtivoMaquinas);
			}
			if(filtro.getTipo().equals("modelo1")) {
				retorno = montaRelatorioIndiceParadaMoldeMod1(listaConsolpa);
			}
			if(filtro.getTipo().equals("modelo2")) {
				retorno = montaRelatorioIndiceParadaMoldeMod2(listaConsolpa);
			}
		}
		return retorno;
		
	}
	
	private RelatorioIndiceParadasMoldeDTO obtemListaRetorno(List<RelatorioIndiceParadasMoldeDTO> lista, DwConsolpa pa) {
		RelatorioIndiceParadasMoldeDTO retorno = null;
		for (RelatorioIndiceParadasMoldeDTO dto : lista) {
			// COnsiderar o mesmo molde, maquina e parada
			
			if (dto.isExiste(pa)) {
				retorno = dto;
				break;
			}
		}
		if (retorno == null) {
			retorno = new RelatorioIndiceParadasMoldeDTO(pa);
			lista.add(retorno);
		}
		
		return retorno;
	}

	/*
	 * Metodo principal para montar relatorio do tipo padrao
	 */
	
	//Marcos Sardinha: 2017-09-14 >> Defeito #4392 
	private BigDecimal getTempoAtivoMaq(Map<String, Map<String, BigDecimal>> mapTempoAtivoMaq, String cdPt) {
		BigDecimal tempoAtivo = BigDecimal.ZERO;
		
		Map<String, BigDecimal> mapTempoAtivoRAP = mapTempoAtivoMaq.get(cdPt);
		Set<String> keysRap = mapTempoAtivoRAP.keySet();
		for (String rap : keysRap) {
			BigDecimal tempo =  mapTempoAtivoRAP.get(rap);
			tempoAtivo = tempoAtivo.add(tempo);
		}
		
		return tempoAtivo;
	}
	
	//Marcos Sardinha: 2017-09-14 >> Defeito #4392
	private BigDecimal getTempoAtivoRAP(Map<String, Map<String, BigDecimal>> mapTempoAtivoMaq, String cdPt, String cdRAP) {
		BigDecimal tempoAtivo = mapTempoAtivoMaq.get(cdPt).get(cdRAP);
		return tempoAtivo;
	}

	//Marcos Sardinha: 2017-09-14 >> Defeito #4392
	private BigDecimal getTempoAtivoTotal(Map<String, Map<String, BigDecimal>> mapTempoAtivoMaq) {
		BigDecimal tempoAtivo = BigDecimal.ZERO;

		Set<String> keysPT = mapTempoAtivoMaq.keySet();
		for(String pt : keysPT) {
			Map<String, BigDecimal> mapTempoAtivoRAP = mapTempoAtivoMaq.get(pt);
			Set<String> keysRap = mapTempoAtivoRAP.keySet();
			for (String rap : keysRap) {
				BigDecimal tempo =  mapTempoAtivoRAP.get(rap);
				tempoAtivo = tempoAtivo.add(tempo);
			}			
		}
				
		return tempoAtivo;
	}	
	
	//Marcos Sardinha: 2017-09-14 >> Defeito #4392	
	private ListaRelatorioIndiceParadaMoldeDTO montaRelatorioIndiceParadaMoldePadrao(List<DwConsolpa> listaConsolpa, Map<String, Map<String, BigDecimal>> mapTempoAtivoMaq) {

		BigDecimal totalGeralTempoAtivo = getTempoAtivoTotal(mapTempoAtivoMaq);
		BigDecimal tempoTotalParadasCP = BigDecimal.ZERO;
		BigDecimal tempoTotalParadasSP = BigDecimal.ZERO;
		
		ListaRelatorioIndiceParadaMoldeDTO retorno = new ListaRelatorioIndiceParadaMoldeDTO();
		
		List<RelatorioIndiceParadasMoldeDTO> listaRetorno = new ArrayList<>();
		

		
		// o proximo loop ira ler todas as paradas e montar o dto de retorno
		for (DwConsolpa pa : listaConsolpa) {
			String cdPt  = pa.getDwConsol().getDwConsolid().getOmPt().getCdPt();
			String cdRAP = pa.getDwConsol().getDwConsolid().getDwFolha().getDwFolharaps().iterator().next().getDwRap().getCdRap();
			
			BigDecimal tempoAtivoMolde = getTempoAtivoRAP(mapTempoAtivoMaq, cdPt, cdRAP);
			BigDecimal tempoAtivoMaquina = getTempoAtivoMaq(mapTempoAtivoMaq, cdPt);
			
			RelatorioIndiceParadasMoldeDTO dtorelParada = obtemListaRetorno(listaRetorno, pa);
			dtorelParada.setTempoAtivoMaquina(tempoAtivoMaquina.toString());
			dtorelParada.setTempoAtivoMolde(tempoAtivoMolde.toString());		
			
			
			//Marcos Sardinha: 2017-09-14 >> Defeito #4392 -- tempo ativo tem quer ser do periodo todo.. nao somente dos periodos onde ocorreu pardaaa
			dtorelParada.setTempoAtivoMaquina(tempoAtivoMaquina.toString());
			
			Integer contador = 0;
			for(DwConsolpaoco oco : pa.getDwConsolpaocos()){
				contador += DataHoraRN.getQuantidadeSegundosNoPeriodo(oco.getDthrIparada(), oco.getDthrFparada());
			}

			BigDecimal tempoParadaCorrente  = BigDecimal.ZERO;
			BigDecimal tempoParadaCorrenteSP = BigDecimal.ZERO;
			BigDecimal tempoParadaCorrenteCP = BigDecimal.ZERO;
			tempoParadaCorrente = new BigDecimal(contador);
			if (pa.getDwTParada().getIsPesa() != null && pa.getDwTParada().getIsPesa() == false) //20161107F: if para SP CP
			{
				tempoParadaCorrenteSP = tempoParadaCorrente;
			}
			else
			{
				tempoParadaCorrenteCP = tempoParadaCorrente;
			}
			tempoTotalParadasSP = tempoTotalParadasSP.add(tempoParadaCorrenteSP);
			tempoTotalParadasCP = tempoTotalParadasCP.add(tempoParadaCorrenteCP);

			dtorelParada.setTempo(dtorelParada.getTempo().add(tempoParadaCorrente));

			// Gerar total para o molde
			BigDecimal tempoAux = BigDecimal.ZERO;
			if (totaisParadasMoldeEMaquina.containsKey(dtorelParada.getMolde()))
				tempoAux = totaisParadasMoldeEMaquina.get(dtorelParada.getMolde());
			tempoAux = tempoAux.add(tempoParadaCorrenteCP); //20161221 tempoParadaCorrente
			totaisParadasMoldeEMaquina.put(dtorelParada.getMolde(), tempoAux);
			
			// Gerar total para o molde + maquina
			tempoAux = BigDecimal.ZERO;
			if (totaisParadasMoldeEMaquina.containsKey(dtorelParada.getMolde() + "-" + dtorelParada.getMaquina()))
				tempoAux = totaisParadasMoldeEMaquina.get(dtorelParada.getMolde() + "-" + dtorelParada.getMaquina());
			tempoAux = tempoAux.add(tempoParadaCorrenteCP); //20161221 tempoParadaCorrente
			totaisParadasMoldeEMaquina.put(dtorelParada.getMolde() + "-" + dtorelParada.getMaquina(), tempoAux);


		}

		
 
		
		// Interage sobre a lista de retorno para atualizar os valores de totais em cada linha
		// total por maquina
		for (RelatorioIndiceParadasMoldeDTO dto : listaRetorno) {
			BigDecimal totalParadaMolde = BigDecimal.ZERO;
			BigDecimal totalParadaMaquina = BigDecimal.ZERO;
			BigDecimal tempoAtivoMolde = BigDecimal.ZERO;
			BigDecimal tempoAtivoMaquina = BigDecimal.ZERO;
			
			tempoAtivoMolde = getTempoAtivoRAP(mapTempoAtivoMaq, dto.getMaquina(), dto.getMolde());
			tempoAtivoMaquina = getTempoAtivoMaq(mapTempoAtivoMaq, dto.getMaquina());

			if (totaisParadasMoldeEMaquina.containsKey(dto.getMolde()))
				totalParadaMolde = totaisParadasMoldeEMaquina.get(dto.getMolde());
			if (totaisParadasMoldeEMaquina.containsKey(dto.getMolde() + "-" + dto.getMaquina()))
				totalParadaMaquina = totaisParadasMoldeEMaquina.get(dto.getMolde() + "-" + dto.getMaquina());
			
			// Define novamente o total tempo ativo do molde
			dto.setTempoAtivoMolde(DataHoraRN.formatSegundosParaHHMMSS(tempoAtivoMolde.intValue()));
			
			// total por molde
			Double ipmolde = FormulasInjet.calcularIndiceParada(totalParadaMolde, tempoAtivoMolde);
			Double ipmaquina = FormulasInjet.calcularIndiceParada(totalParadaMaquina, tempoAtivoMaquina);
			dto.setTempoAtivoMolde(DataHoraRN.formatSegundosParaHHMMSS(tempoAtivoMolde.intValue()) );
			dto.setTotalMoldeIndiceBaseA(ConversaoTipos.converteParaString(ipmolde,2));
			dto.setTotalMoldeIndiceBaseB("---");
			dto.setTotalMoldeTempo(DataHoraRN.formatSegundosParaHHMMSS(totalParadaMolde.intValue()) );

			
			// total por molde + maquina
			ipmolde = FormulasInjet.calcularIndiceParada(totalParadaMaquina, tempoAtivoMolde);
			dto.setTempoAtivoMaquina(DataHoraRN.formatSegundosParaHHMMSS( tempoAtivoMaquina.intValue()) ) ;
			dto.setTotalMaquinaIndiceBaseA(ConversaoTipos.converteParaString(ipmolde,2));
			dto.setTotalMaquinaIndiceBaseB(ConversaoTipos.converteParaString(ipmaquina,2));
			dto.setTotalMaquinaTempo(DataHoraRN.formatSegundosParaHHMMSS(totalParadaMaquina.intValue()));
	
			// Calcular indices
			ipmolde = FormulasInjet.calcularIndiceParada(dto.getTempo(), tempoAtivoMolde);
			ipmaquina = FormulasInjet.calcularIndiceParada(dto.getTempo(), tempoAtivoMaquina);
			dto.setIndiceBaseA(ConversaoTipos.converteParaString(ipmolde,2));
			dto.setIndiceBaseB(ConversaoTipos.converteParaString(ipmaquina,2));
			
			Double ipC = FormulasInjet.calcularIndiceParada(dto.getTempo(), totalGeralTempoAtivo);
			dto.setTotalMoldeIndiceBaseC(ConversaoTipos.converteParaString(ipC,2));

		}

		
		retorno.setMoldeDTOs(listaRetorno);
		
		// Finaliza inicializacao do retorno com os dados para o rodape do relatorio
		retorno.setTempoAtivo(DataHoraRN.formatSegundosParaHHMMSS(totalGeralTempoAtivo.intValue()));
		retorno.setTempoTotalParadasCP(DataHoraRN.formatSegundosParaHHMMSS(tempoTotalParadasCP.intValue()));
		retorno.setTempoTotalParadasSP(DataHoraRN.formatSegundosParaHHMMSS(tempoTotalParadasSP.intValue()));

		retorno.setTempoTotalParadas(DataHoraRN.formatSegundosParaHHMMSS(tempoTotalParadasCP.add(tempoTotalParadasSP).intValue()));
		Double ipC = FormulasInjet.calcularIndiceParada(tempoTotalParadasCP, totalGeralTempoAtivo);
		retorno.setIndiceParadas(ConversaoTipos.converteParaString(ipC,2));
		
		
		return retorno;
	}

	
	
	
	
	
	private ListaRelatorioIndiceParadaMoldeDTO montaRelatorioIndiceParadaMoldeMod1(List<DwConsolpa> listaConsolpa) {	
		
		HashMap<String, RelatorioIndiceParadasMoldeDTO> mapRelatorioParadaMolde = new HashMap<>();
		HashMap<String, RelatorioIndiceParadasMoldeDTO> mapIndiceMaquina = new HashMap<>();
		
		Double tempoTotalParadasCP = 0d;
		Double tempoTotalParadasSP = 0d;

		
		for (DwConsolpa dwConsolpa : listaConsolpa) {
			
			
			Integer contador = 0;
			for(DwConsolpaoco oco : dwConsolpa.getDwConsolpaocos()){
				contador += DataHoraRN.getQuantidadeSegundosNoPeriodo(oco.getDthrIparada(), oco.getDthrFparada());
			}
			
			//20170110..
			BigDecimal tempoParadaCorrente  = BigDecimal.ZERO;
			BigDecimal tempoParadaCorrenteSP = BigDecimal.ZERO;
			BigDecimal tempoParadaCorrenteCP = BigDecimal.ZERO;
			tempoParadaCorrente = new BigDecimal(contador);
			if (dwConsolpa.getDwTParada().getIsPesa() != null && dwConsolpa.getDwTParada().getIsPesa() == false){
				tempoParadaCorrenteSP = tempoParadaCorrente;
			}
			else{
				tempoParadaCorrenteCP = tempoParadaCorrente;
			}
			tempoTotalParadasSP += tempoParadaCorrenteSP.doubleValue();
			tempoTotalParadasCP += tempoParadaCorrenteCP.doubleValue();
			//20170110.

			
			String cdMolde;
			try{
				cdMolde = dwConsolpa.getDwConsol().getDwConsolid().getDwFolha().getDwFolharaps() != null ? dwConsolpa.getDwConsol().getDwConsolid().getDwFolha().getDwFolharaps().iterator().next().getDwRap().getCdRap(): "";
			}catch(Exception e){
				cdMolde = "";
			}
			
			String dsMolde;
			try{
				dsMolde = dwConsolpa.getDwConsol().getDwConsolid().getDwFolha().getDwFolharaps() != null ? dwConsolpa.getDwConsol().getDwConsolid().getDwFolha().getDwFolharaps().iterator().next().getDwRap().getDsRap(): "";
			}catch(Exception e){
				dsMolde = "";
			}
			String omPt = dwConsolpa.getDwConsol().getDwConsolid().getOmPt() != null ? dwConsolpa.getDwConsol().getDwConsolid().getOmPt().getCdPt() : "";
			String chave = cdMolde+omPt;
			
			RelatorioIndiceParadasMoldeDTO dtorelTempoParadaMaquina = mapIndiceMaquina.get(omPt);
			
			if (dtorelTempoParadaMaquina == null){
				dtorelTempoParadaMaquina = new RelatorioIndiceParadasMoldeDTO();
				//20170116 dtorelTempoParadaMaquina.setTempoPorMaquina(tempoParadaCorrenteCP); //20170110 (tempoParadaCorrente);
				dtorelTempoParadaMaquina.setTempoPorMaquina(tempoParadaCorrente); //20170116 
				mapIndiceMaquina.put(omPt, dtorelTempoParadaMaquina);
			}else{
				//20170116 BigDecimal tempoAux = new BigDecimal(dtorelTempoParadaMaquina.getTempoPorMaquina().doubleValue() + tempoParadaCorrenteCP.doubleValue()); //20170110 + tempoParadaCorrente.doubleValue());
				BigDecimal tempoAux = new BigDecimal(dtorelTempoParadaMaquina.getTempoPorMaquina().doubleValue() + tempoParadaCorrente.doubleValue()); //20170116
				dtorelTempoParadaMaquina.setTempoPorMaquina(tempoAux);
			}
			
			RelatorioIndiceParadasMoldeDTO dtorelTempoParadaMoldMaquina = mapRelatorioParadaMolde.get(chave);
			if(dtorelTempoParadaMoldMaquina == null) {
				dtorelTempoParadaMoldMaquina = new RelatorioIndiceParadasMoldeDTO();
				dtorelTempoParadaMoldMaquina.setMaquina(omPt);
				dtorelTempoParadaMoldMaquina.setDescMolde(dsMolde);
				dtorelTempoParadaMoldMaquina.setMolde(cdMolde);
				//20170116 dtorelTempoParadaMoldMaquina.setTempo(tempoParadaCorrenteCP); //20170110 (tempoParadaCorrente);
				dtorelTempoParadaMoldMaquina.setTempo(tempoParadaCorrente); //20170116
				mapRelatorioParadaMolde.put(chave, dtorelTempoParadaMoldMaquina);
			} else {
				//20170116 BigDecimal tempoAux = new BigDecimal(dtorelTempoParadaMoldMaquina.getTempo().doubleValue() + tempoParadaCorrenteCP.doubleValue()); //20170110 + tempoParadaCorrente.doubleValue());
				BigDecimal tempoAux = new BigDecimal(dtorelTempoParadaMoldMaquina.getTempo().doubleValue() + tempoParadaCorrente.doubleValue()); //20170116
				dtorelTempoParadaMoldMaquina.setTempo(tempoAux);
			}
		}
		
//		Double totalTempoTodasParadas = tempoTotalParadasCP + tempoTotalParadasSP;
//		double porcentagemTotalParada = (totalTempoTodasParadas.doubleValue() * 100) / totalTempoTodasParadas;
//		String indiceTotal = String.valueOf(arredondarPorcentagem(porcentagemTotalParada, 2, 1)) + "%";
//		
		ListaRelatorioIndiceParadaMoldeDTO retorno = new ListaRelatorioIndiceParadaMoldeDTO();
		retorno.setMoldeDTOs(new ArrayList<RelatorioIndiceParadasMoldeDTO>()); 	
//		retorno.setTempoTotalParadas(DataHoraRN.formatSegundosParaHHMMSS(totalTempoTodasParadas.intValue()));
//		retorno.setIndiceParadas(indiceTotal);
		
		int i = 0;
		List<RelatorioIndiceParadasMoldeDTO> listaDadosRelatorio = new ArrayList<>();
		
		for(String chave : mapRelatorioParadaMolde.keySet()){
			RelatorioIndiceParadasMoldeDTO relatorio = mapRelatorioParadaMolde.get(chave);
			Double tempoTotalParada = relatorio.getTempo().doubleValue();
			String ompt = relatorio.getMaquina();
			for (String aux : mapIndiceMaquina.keySet()){
				if (ompt.equals(aux)){
					RelatorioIndiceParadasMoldeDTO dto = mapIndiceMaquina.get(aux);
					relatorio.setTempoPorMaquina(dto.getTempoPorMaquina());
				}
			}
			
			if(tempoTotalParada.doubleValue() <= 0) {
				continue;
			}
			listaDadosRelatorio.add(relatorio);
		}		
		
		Comparator<RelatorioIndiceParadasMoldeDTO> comparator = new Comparator<RelatorioIndiceParadasMoldeDTO>() {
			@Override
			public int compare(RelatorioIndiceParadasMoldeDTO o1, RelatorioIndiceParadasMoldeDTO o2) {
				String molde1 = o1.getMaquina()+o1.getMolde();
				String molde2 = o2.getMaquina()+o2.getMolde();
				return molde1.compareTo(molde2);
			}
		};
		
		Collections.sort(listaDadosRelatorio, comparator);
		
		for(RelatorioIndiceParadasMoldeDTO relatorio : listaDadosRelatorio){
			
			Double tempoParadaMaquina = relatorio.getTempoPorMaquina().doubleValue();
			Double tempoTotalParada = relatorio.getTempo().doubleValue();
//			relatorio.setTempo(DataHoraRN.formatSegundosParaHHMMSS(tempoTotalParada.intValue()));
			double porcentagemParada = (tempoTotalParada.doubleValue() * 100) / tempoParadaMaquina;
			double indice = arredondarPorcentagem(porcentagemParada, 2, 1);
			relatorio.setIndice(indice);
			relatorio.setNumeroLinhaRel(i);
			retorno.getMoldeDTOs().add(relatorio);
			i++;
		}
		
		return retorno;

	}

	private ListaRelatorioIndiceParadaMoldeDTO montaRelatorioIndiceParadaMoldeMod2(List<DwConsolpa> listaConsolpa) {
		
		HashMap<String, RelatorioIndiceParadasMoldeDTO> mapRelatorioParadaMolde = new HashMap<>();
		
		Double tempoTotalParadasCP = 0d;
		Double tempoTotalParadasSP = 0d;
		
		for (DwConsolpa dwConsolpa : listaConsolpa) {
			Integer contador = 0;

			
			for(DwConsolpaoco oco : dwConsolpa.getDwConsolpaocos()){
				contador += DataHoraRN.getQuantidadeSegundosNoPeriodo(oco.getDthrIparada(), oco.getDthrFparada());
			}

			//20170110..
			BigDecimal tempoParadaCorrente  = BigDecimal.ZERO;
			BigDecimal tempoParadaCorrenteSP = BigDecimal.ZERO;
			BigDecimal tempoParadaCorrenteCP = BigDecimal.ZERO;
			tempoParadaCorrente = new BigDecimal(contador);
			if (dwConsolpa.getDwTParada().getIsPesa() != null && dwConsolpa.getDwTParada().getIsPesa() == false){
				tempoParadaCorrenteSP = tempoParadaCorrente;
			}
			else{
				tempoParadaCorrenteCP = tempoParadaCorrente;
			}
			tempoTotalParadasSP += tempoParadaCorrenteSP.doubleValue();
			tempoTotalParadasCP += tempoParadaCorrenteCP.doubleValue();
			//20170110.


			//20160116 Double tempo = tempoParadaCorrenteCP.doubleValue(); //20170110 contador.doubleValue();
			Double tempo = tempoParadaCorrente.doubleValue(); //20160116


			String cdMolde;
			try{
				cdMolde = dwConsolpa.getDwConsol().getDwConsolid().getDwFolha().getDwFolharaps() != null ? dwConsolpa.getDwConsol().getDwConsolid().getDwFolha().getDwFolharaps().iterator().next().getDwRap().getCdRap(): "";
			}catch(Exception e){
				cdMolde = "";
			}
			
			String dsMolde;
			try{
				dsMolde = dwConsolpa.getDwConsol().getDwConsolid().getDwFolha().getDwFolharaps() != null ? dwConsolpa.getDwConsol().getDwConsolid().getDwFolha().getDwFolharaps().iterator().next().getDwRap().getDsRap(): "";
			}catch(Exception e){
				dsMolde = "";
			}

			RelatorioIndiceParadasMoldeDTO relatorio = mapRelatorioParadaMolde.get(cdMolde);
			if(relatorio == null) {
				relatorio = new RelatorioIndiceParadasMoldeDTO();
				relatorio.setDescMolde(dsMolde);
				relatorio.setMolde(cdMolde);
				relatorio.setTempo(new BigDecimal(tempo));
				mapRelatorioParadaMolde.put(cdMolde, relatorio);
			} else {
				BigDecimal tempoAux = new BigDecimal(relatorio.getTempo().doubleValue() + tempo.doubleValue());
				relatorio.setTempo(tempoAux);
			}
		}
		
		//20170116 Double totalTempoTodasParadas = tempoTotalParadasCP ; //20170110 + tempoTotalParadasSP;
		Double totalTempoTodasParadas = tempoTotalParadasCP + tempoTotalParadasSP; //20170116
		double porcentagemTotalParada = (totalTempoTodasParadas.doubleValue() * 100) / totalTempoTodasParadas;
		String indiceTotal = String.valueOf(arredondarPorcentagem(porcentagemTotalParada, 2, 1));
		
		ListaRelatorioIndiceParadaMoldeDTO retorno = new ListaRelatorioIndiceParadaMoldeDTO();
		retorno.setMoldeDTOs(new ArrayList<RelatorioIndiceParadasMoldeDTO>()); 	
		retorno.setTempoTotalParadas(DataHoraRN.formatSegundosParaHHMMSS(totalTempoTodasParadas.intValue()));
		retorno.setIndiceParadas(indiceTotal);
		
		int i = 0;
		List<RelatorioIndiceParadasMoldeDTO> listaDadosRelatorio = new ArrayList<>();
		
		for(String chave : mapRelatorioParadaMolde.keySet()){
			RelatorioIndiceParadasMoldeDTO relatorio = mapRelatorioParadaMolde.get(chave);
			Double tempoTotalParada = relatorio.getTempo().doubleValue();
			if(tempoTotalParada.doubleValue() <= 0) {
				continue;
			}
			listaDadosRelatorio.add(relatorio);
		}		
		
		Comparator<RelatorioIndiceParadasMoldeDTO> comparator = new Comparator<RelatorioIndiceParadasMoldeDTO>() {
			@Override
			public int compare(RelatorioIndiceParadasMoldeDTO o1, RelatorioIndiceParadasMoldeDTO o2) {
				String molde1 = o1.getMolde();
				String molde2 = o2.getMolde();
				return molde1.compareTo(molde2);
			}
		};
		
		Collections.sort(listaDadosRelatorio, comparator);
		
		for(RelatorioIndiceParadasMoldeDTO relatorio : listaDadosRelatorio){
			Double tempoTotalParada = relatorio.getTempo().doubleValue();
//			relatorio.setTempo(DataHoraRN.formatSegundosParaHHMMSS(tempoTotalParada.intValue()));
			double porcentagemParada = (tempoTotalParada.doubleValue() * 100) / totalTempoTodasParadas;
			double indice = arredondarPorcentagem(porcentagemParada, 2, 1);
			relatorio.setIndice(indice);
			relatorio.setNumeroLinhaRel(i);
			retorno.getMoldeDTOs().add(relatorio);
			i++;
		}
		
		return retorno;
	}
	
	//20161219..
	private List<DwConsolpa> removeConsolpaInvalido(List<DwConsolpa> listaConsolpa){
		List<DwConsolpa> listaConsolpaSemInvalidos = new ArrayList<>();
		for(DwConsolpa pa : listaConsolpa){
			boolean isConsolpaInvalido = false;
			
			isConsolpaInvalido = pa.isRegistroInvalido();

			if(isConsolpaInvalido == false){
				listaConsolpaSemInvalidos.add(pa);
			}
		}
		return listaConsolpaSemInvalidos;
	}

	private List<DwConsolpa> getListaDwConsolpa(MapQuery q, FiltroRelatorioIndiceParadasDTO filtro, DwTParada parada, DwTArea area) {
		q.novaConsulta();
		q.append("SELECT consolpa");
		q.append("FROM DwConsolpa consolpa");
		q.append("JOIN consolpa.dwConsol consol");
		q.append("JOIN consol.dwConsolid consolid");
		q.append("join consolid.ppCp ppcp");
		q.append("join ppcp.ppCpprodutos ppcpproduto");
		
		q.append("JOIN consolid.omPt pt");
		q.append("LEFT JOIN pt.omObjs omobj");
		
		q.append("JOIN consolpa.dwTParada parada");
		q.append("LEFT JOIN parada.dwTArea area");
		q.append("JOIN consolid.dwFolha folha");
		// Alessandre em 15-12-15 removi o left dos dois joins abaixo pois o relatorio funcionara paenas para
		// quem tem ferramenta definida
		q.append("JOIN folha.dwFolharaps folharap");
		q.append("JOIN folharap.dwRap rap");
		
		q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
		q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta grupoferramenta");
		
		q.append("WHERE consolid.tpId = :tpId");
		
		if(filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null){
			q.append("AND consolid.dtReferencia BETWEEN :dataincial AND :datafinal");
		}
		if (filtro.getCdop() != null) {
			q.append("AND ppcpproduto.nrDoc = :cdop");
		}
		if (filtro.getTurnoDTO() != null) {
			q.append("AND consolid.dwTurno.idTurno = :idturno");
		}else{
			q.append("AND consolid.dwTurno.idTurno <> 1");
		}
		if (filtro.getOmpt() != null) {
//			q.append("AND consolid.omPt.idPt = :idpt");
			q.append("AND pt.idPt = :idpt");
		}
		if (filtro.getOmgt() != null) {
			q.append("AND omobj.omGtByIdGt.idGt = :idgt");
		}
		if (filtro.getDwRap() != null) {
			q.append("AND rap.idRap = :idrap");
		}
		if (filtro.getDwGrupoFerramenta() != null) {
			q.append("AND grupoferramenta.idGrupoFerramenta = :idgpRap");
		}
		if(parada != null) {
			q.append("AND parada.cdTparada = :cdparada");
		}
		if(area != null){
			q.append("AND area.cdArea = :cdArea"); 
		}
		
		q.defineParametro("tpId", (byte) 1);		
		q.defineParametro("cdop", filtro.getCdop());
		
		if (filtro.getDwGrupoFerramenta() != null) {
			q.defineParametro("idgpRap", filtro.getDwGrupoFerramenta().getIdGrupoFerramenta());
		}
		if (filtro.getDwRap() != null) {
			q.defineParametro("idrap", filtro.getDwRap().getIdRap());
		}
		if (filtro.getOmgt() != null) {
			q.defineParametro("idgt", filtro.getOmgt().getIdGt());
		}
		if (filtro.getOmpt() != null) {
			q.defineParametro("idpt", filtro.getOmpt().getIdPt());
		}
		
		if (filtro.getTurnoDTO() != null) {
			q.defineParametro("idturno", filtro.getTurnoDTO().getTurno().getIdTurno());
		}
		
		
		
		if(parada != null){
			q.defineParametro("cdparada", parada.getCdTparada());
		}
		if(area != null){
			q.defineParametro("cdArea", area.getCdArea());
		}
		if(filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null){
			q.defineParametroTimestamp("dataincial", filtro.getPeriodoInicial());
			q.defineParametroTimestamp("datafinal",DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));
		}

		List<DwConsolpa> retorno = null;


		retorno = q.list();


		retorno = removeConsolpaInvalido(retorno);//20161219F
		//20170123 off		listaConsolpa = removeConsolpaComIdRepetido(listaConsolpa);
		retorno = removeConsolpaComIdRepetido(retorno, true); //20170123 considera os casos de idPA0

 
		retorno = removeConsolpaInvalido(retorno);//20161219F
		retorno = removeConsolpaComIdRepetido(retorno, true); //20170123

		return retorno;
	}



	private Map<String, Map<String, BigDecimal>> getTempoAtivoPT(MapQuery q, FiltroRelatorioIndiceParadasDTO filtro) {
		Map<String, Map<String, BigDecimal>>  mapTempoAtivo = new HashMap<String, Map<String, BigDecimal>>();
		
		int _cdPt = 0;
		int _cdRap = 1;
		int _tempoAtivo = 2;
		
		q.novaConsulta();		
		q.append("SELECT pt.cdPt, rap.cdRap, SUM( (CASE WHEN consol.segAutoTempoativo IS NULL THEN 0.00 ELSE consol.segAutoTempoativo END) + (CASE WHEN consol.segManuTempoativo IS NULL THEN 0.00 ELSE consol.segManuTempoativo END) )");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwConsols consol");
		q.append("JOIN consolid.omPt pt");
		q.append("JOIN consolid.dwFolha folha");
		q.append("LEFT JOIN folha.dwFolharaps folharap");
		q.append("LEFT JOIN folharap.dwRap rap");
		q.append("WHERE consolid.idConsolid in (");

		q.append("SELECT DISTINCT consolidSQ.idConsolid ");
		q.append("FROM DwConsolid consolidSQ");
		q.append("JOIN consolidSQ.dwConsols consolSQ");
		q.append("join consolidSQ.ppCp ppcpSQ");
		q.append("join ppcpSQ.ppCpprodutos ppcpprodutoSQ");
		
		q.append("JOIN consolidSQ.omPt ptSQ");
		q.append("LEFT JOIN ptSQ.omObjs omobjSQ");
		
		q.append("JOIN consolidSQ.dwFolha folhaSQ");

		q.append("LEFT JOIN folhaSQ.dwFolharaps folharapSQ");
		q.append("LEFT JOIN folharapSQ.dwRap rap");
		
		q.append("LEFT JOIN rap.dwRapGrupos rapgrupoSQ");
		q.append("LEFT JOIN rapgrupoSQ.dwGrupoFerramenta grupoferramentaSQ");
		
		q.append("WHERE consolidSQ.tpId = :tpId");
		q.append("AND consolidSQ.stAtivo IS NULL");
		
		
		if(filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null){
			q.append("AND consolidSQ.dtReferencia BETWEEN :dataincial AND :datafinal");
		}
		if (filtro.getCdop() != null) {
			q.append("AND ppcpprodutoSQ.nrDoc = :cdop");
		}
		if (filtro.getTurnoDTO() != null) {
			q.append("AND consolidSQ.dwTurno.idTurno = :idturno");
		}else{
			q.append("AND consolidSQ.dwTurno.idTurno <> 1");
		}
		if (filtro.getOmpt() != null) {
			q.append("AND ptSQ.idPt = :idpt");
		}
		if (filtro.getOmgt() != null) {
			q.append("AND omobjSQ.omGtByIdGt.idGt = :idgt");
		}
		if (filtro.getDwRap() != null) {
			q.append("AND rap.idRap = :idrap");
		}
		if (filtro.getDwGrupoFerramenta() != null) {
			q.append("AND grupoferramentaSQ.idGrupoFerramenta = :idgpRap");
		}
		
		
		q.append(")");
		q.append("GROUP BY pt.cdPt, rap.cdRap");

		//parametros
		q.defineParametro("tpId", (byte) 1);		
		q.defineParametro("cdop", filtro.getCdop());
		
		if (filtro.getDwGrupoFerramenta() != null) {
			q.defineParametro("idgpRap", filtro.getDwGrupoFerramenta().getIdGrupoFerramenta());
		}
		if (filtro.getDwRap() != null) {
			q.defineParametro("idrap", filtro.getDwRap().getIdRap());
		}
		if (filtro.getOmgt() != null) {
			q.defineParametro("idgt", filtro.getOmgt().getIdGt());
		}
		if (filtro.getOmpt() != null) {
			q.defineParametro("idpt", filtro.getOmpt().getIdPt());
		}
		
		if (filtro.getTurnoDTO() != null) {
			q.defineParametro("idturno", filtro.getTurnoDTO().getTurno().getIdTurno());
		}
		
		if(filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null){
			q.defineParametroTimestamp("dataincial", filtro.getPeriodoInicial());
			q.defineParametroTimestamp("datafinal",DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));
		}
		
		
		List<Object> lista = q.list();
        for (Object reg : lista) {
            Object[] registro = (Object[]) reg;

            String cdPt = registro[_cdPt].toString();
            String cdRap = (registro[_cdRap] == null ? "_NULL_" : registro[_cdRap].toString());
            BigDecimal tempoAtivo = new BigDecimal((Double) registro[_tempoAtivo]);
            
            Map<String, BigDecimal> mapMol = new HashMap<String, BigDecimal>();
            
            if (mapTempoAtivo.containsKey(cdPt)) {
            	mapMol = mapTempoAtivo.get(cdPt);
            }
            
            mapMol.put(cdRap, tempoAtivo);            
            mapTempoAtivo.put(cdPt, mapMol);
        }

		return mapTempoAtivo;
	}

	private double arredondarPorcentagem(double valor, int casas, int ceilOrFloor) {
		 double arredondado = valor;
	     arredondado *= (Math.pow(10, casas));
	     if (ceilOrFloor == 0) {
	    	 arredondado = Math.ceil(arredondado);
	     } else {
	    	 arredondado = Math.floor(arredondado);
	     }
	     arredondado /= (Math.pow(10, casas));
	     return arredondado;
	}

}
