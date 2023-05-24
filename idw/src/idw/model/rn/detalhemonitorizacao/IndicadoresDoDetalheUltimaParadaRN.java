package idw.model.rn.detalhemonitorizacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwTArea;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;


public class IndicadoresDoDetalheUltimaParadaRN extends AbstractRN<DAOGenerico>{

	private DwConsolpalog palogParAberta;
	private DwConsolpalog palog;
	private Integer tempoParada;
	private Date dthrITurno = null; // usada para retornar o inicio de turno

	
	public IndicadoresDoDetalheUltimaParadaRN(DAOGenerico dao, List<DwConsolid> ids) {
		super(dao);
		
		inicializarValores(ids);
	}
	
	

	/* Inicializa valores da ultima parada
	 * Se for por turno a parada deve ser limitada por turno
	 * Se for acumulado a parada deve ser limitada pela OP
	 */
	
	
	private void inicializarValores(List<DwConsolid> ids) {
		Integer retorno = 0;
		OmPt ompt = null;
		PpCp ppcp = null;
		List<Date> inicioTurno = new ArrayList<>();
		Byte tpId = null;

		
		/* 
		 * Marcos Sardinha: 2017-06-20 >> necessario tratar lista de id, pt e cps... necessario por causa do bi, mapa das cps e prod. fab. turno. 
		 * Implementacao anteior atendia somente ficha da maquina 
		 */
		
		class IdPtCP {
			Byte tpId;
			OmPt ompt;
			PpCp ppcp;
			List<DwConsolid> ids;
		}
		
		IdPtCP itemMap = new IdPtCP();	
		Map <String, IdPtCP> mapIds = new HashMap<String, IdPtCP>();
		
		for (DwConsolid id : ids) {
			String idMap;
			
			tpId = id.getTpId();
			ompt = id.getOmPt();
			ppcp = id.getPpCp();
			
			idMap = tpId + " - "  + ompt.getIdPt() + " - " + ppcp.getIdCp();
			
			if (mapIds.containsKey(idMap) == false) {
				itemMap = new IdPtCP();
				itemMap.tpId = tpId;
				itemMap.ompt = ompt;
				itemMap.ppcp = ppcp;
				itemMap.ids = new ArrayList<DwConsolid>();
				itemMap.ids.add(id);
				
				mapIds.put(idMap, itemMap);
			} else {
				itemMap = mapIds.get(idMap);
				itemMap.ids.add(id);
				mapIds.put(idMap, itemMap);
			}
		}

		
		Set<String> idsMap = mapIds.keySet();
		for (String keyMap : idsMap) {

			tpId = mapIds.get(keyMap).tpId;
			ompt = mapIds.get(keyMap).ompt;
			ppcp = mapIds.get(keyMap).ppcp;
			
			
			// Se for pra analisar ACUMULADO entao pegar a ultima parada do PT com a OP
			if (tpId != null && tpId.equals(DwConsolidTemplate.TpId.ACUMULADO.getValue())) {
				this.palog = getUltimaParadaDoPostoNaOP(ompt, ppcp);
			} else {
				/* Alessandre em 21-11-18 palog não necessáriamente terá o motivo da ultima parada, apesa dele representar a ultima parada. Isso acontece
				 * pq palog não é alterado pela correcao de parada. Mas os dwconsolpa são alterados com o motivo alterado. Assim eh necessário avaliar no periodo
				 * qual sera o dwtparada a ser considerado
				 */
				this.palog = getUltimaParada(mapIds.get(keyMap).ids);
				//if (this.palog != null)
					//this.dwtparada = this.palog.getDwTParada();
			}
			
			inicioTurno = new ArrayList<>();
			for (DwConsolid id : mapIds.get(keyMap).ids) {
				
				// Se nao tem ultima parada entao retornar 0
				if (palog == null)
					break;
				
				// Se o id for de outro PT desconsiderar o registro
				if (ompt.getIdPt().equals(id.getOmPt().getIdPt()) == false)
					continue;
				
				
				//obter o dwtparada mais atual para o periodo avaliado
				
				// Nesse ponto se tem qual a ultima parada em palog. Assim iremos utilizar o inicio e fim do turno e inicio da parada e hora atual
				// para se calcular o tempo da ultima parada
				// 1o Avaliar se o turno ja nao foi contabilizado
				Date dthrI = null;
				Date dthrF = null;
				if (id.getTpId().equals(DwConsolidTemplate.TpId.TURNO.getValue())) {
					dthrI = id.getDthrIturno();
					dthrF = id.getDthrFturno();
				}
				if (id.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue())) {
					dthrI = id.getDthrIhora();
					dthrF = id.getDthrFhora();
				}
				if (id.getTpId().equals(DwConsolidTemplate.TpId.ACUMULADO.getValue())) {
					dthrI = id.getPpCp().getDthrInicioreal();
					dthrF = id.getPpCp().getDthrFinalreal();
					if (dthrF == null)
						dthrF = DataHoraRN.getDataHoraAtual();
				}
				if (inicioTurno.contains(dthrI))
					continue;
				
				dthrITurno = dthrI;
				
				inicioTurno.add(dthrI);
				
				Date dthrFParada = palog.getDthrFparada();
				if (dthrFParada == null)
					dthrFParada = DataHoraRN.getDataHoraAtual();
				
				int duracao = DataHoraRN.getQuantidadeSegundosNaIntersecao(dthrI, dthrF, palog.getDthrIparada(), dthrFParada);
				retorno += duracao;
			}
			
		}
		
		if (retorno == 0) {
			this.palog = null;
		}
		else {
			this.tempoParada = retorno;
		}
	}
	
	
	
	private DwConsolpalog getUltimaParada(List<DwConsolid> ids) {
		DwConsolpalog palog = null;
		for (DwConsolid id : ids) {
			if (palog == null) {
				if (id.getDwRt() != null && id.getDwRt().getDwConsolpalog() != null) {
					palog = id.getDwRt().getDwConsolpalog();
				}
			} else if (
					id.getDwRt() != null &&
					id.getDwRt().getDwConsolpalog() != null && 
					DataHoraRN.after(id.getDwRt().getDwConsolpalog().getDthrIparada(), palog.getDthrIparada())) {
				palog = id.getDwRt().getDwConsolpalog();
			}
		}
		
		return palog;
	}
	
	/*
	 * Obtem a ultima parada do posto na OP mesmo q a parada esteja aberta
	 */
	
	private DwConsolpalog getUltimaParadaDoPostoNaOP(OmPt ompt, PpCp ppcp) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwConsolpalog a");
		q.append("join a.dwConsolpaocos b");
		q.append("join b.dwConsolpa c");
		q.append("join c.dwConsol d");
		q.append("join d.dwConsolid e");
		q.append("where e.tpId = :tpid");
		q.append("and e.omPt.idPt = :idpt");
		q.append("and e.ppCp.idCp = :idcp");
		q.append("order by a.dthrIparada desc");
		
		q.setMaxResults(1);
		q.defineParametro("tpid", DwConsolidTemplate.TpId.TURNO.getValue());
		q.defineParametro("idpt", ompt.getIdPt());
		q.defineParametro("idcp", ppcp.getIdCp());
		
		return (DwConsolpalog) q.uniqueResult();
	}
	// Retorna o tempo da ultima parada, considerando os varios turnos por onde a parada passou
	// Esse metodo faz sentido apenas quando se analisa um PT
	public Integer calcularTempoUltimaParada() {
		return this.tempoParada;
	}

	public boolean isParadaEmAberto() {
		if (palogParAberta != null) {
			return true;
		}
		return false;
	}

	public boolean isUltimParadaPesa() {
		if (palog != null && palog.getDwTParada() != null) {
			if (palog.getDwTParada().getIsPesa())
				return true;
		}
		return false;
	}
	
	public String getParadaAtualUltParada() {
		if (palog != null)
			return palog.getDwTParada().getCdTparada() + " - " + palog.getDwTParada().getDsTparada();
		return "";
	}
	
	public String getAreaResponsavel() {
		if (palog != null && palog.getDwTParada().getDwTArea() != null) {
			DwTArea dwTArea = palog.getDwTParada().getDwTArea();
			return dwTArea.getCdArea() + " - " + dwTArea.getDsArea();
		}
		return "";
	}
	
	public String getDataInicioUltimaParada() {
		if (palog != null)
			if (dthrITurno == null || DataHoraRN.after(palog.getDthrIparada(), dthrITurno))
				return DataHoraRN.dateToString(DataHoraRN.getDataSemHora(palog.getDthrIparada()), "dd/MM/yyyy");
			else
				return DataHoraRN.dateToString(DataHoraRN.getDataSemHora(dthrITurno), "dd/MM/yyyy");
		return "";
	}
	
	public String getHoraInicioUltimaParada() {
		if (palog != null)
			if (dthrITurno == null || DataHoraRN.after(palog.getDthrIparada(), dthrITurno))
				return DataHoraRN.getHoraFormatoHHMMSS(palog.getDthrIparada());
			else
				return DataHoraRN.getHoraFormatoHHMMSS(dthrITurno);
		return "";
	}
}
