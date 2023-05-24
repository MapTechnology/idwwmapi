package idw.model.rn.monitorizacao.injet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.SQLQuery;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTParada;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import ms.util.ConversaoTipos;

public class IndicadoresDoDetalheUltimaParadaInjetRN extends AbstractRN<DAOGenericoInjet>{

	private DwConsolpalog palog;
	private Integer tempoParada;
	private Date dthrITurno = null; // usada para retornar o inicio de turno

	
	public IndicadoresDoDetalheUltimaParadaInjetRN(DAOGenericoInjet dao, List<DwConsolid> ids) {
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
						
			this.palog = getUltimaParada(mapIds.get(keyMap).ids);
			
			inicioTurno = new ArrayList<>();
			for (DwConsolid id : mapIds.get(keyMap).ids) {
				
				// Se nao tem ultima parada entao retornar 0
				if (palog == null)
					break;
				
				// Se o id for de outro PT desconsiderar o registro
				if (ompt.getCdPt().equals(id.getOmPt().getCdPt()) == false)
					continue;
				
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
	
	
	
	@SuppressWarnings("unchecked")
	private DwConsolpalog getUltimaParada(List<DwConsolid> ids) {
		DwConsolpalog palog = null;
		
		int _dthrIPar = 0;
		int _dthrFPar = _dthrIPar + 1;
		int _tmpParadasCP = _dthrFPar + 1;
		int _tmpParadasSP = _tmpParadasCP + 1;
		int _cdParada = _tmpParadasSP + 1;
		int _dsParada = _cdParada + 1;
		int _cdAreaResp = _dsParada + 1;
		int _dsAreaResp = _cdAreaResp + 1;
		int _paradaCP = _dsAreaResp + 1;
		
		class RegistroLido {
			Date dthrIPar;
			Date dthrFPar;
			BigDecimal tmpParadas = BigDecimal.ZERO;
			String cdParada;
			String dsParada;
			String cdAreaResp;
			String dsAreaResp;
			Integer paradaComPeso;			
		}
		
		for (DwConsolid id : ids) {
			if (id.getTpId().equals(DetalheMonitorizacaoPTInjetRN.PERIODO_CONSOLIDACAO_HORA)) {
				break;
			}
						
			String strSQL = "";
			strSQL = strSQL.concat("SELECT a.dthripar, a.dthrfpar, a.tmpparadas, a.tmpparadassempeso, ");
			strSQL = strSQL.concat("       b.cdparada, b.dsparada, c.cdarea, c.dsarea, ");
			strSQL = strSQL.concat("       (CASE WHEN b.saidademolde IS NULL THEN 0 ELSE (CASE WHEN b.saidademolde = 0 THEN 1 ELSE 0 END) END) as pesa ");
			strSQL = strSQL.concat("  FROM ijreaparcnsocorTUR a ");
			strSQL = strSQL.concat("  JOIN ijtbpar b ON (b.cdparada = a.cdparada) ");
			strSQL = strSQL.concat("  JOIN ijareres c ON (c.cdarea = b.cdarea) ");
			strSQL = strSQL.concat("  JOIN ijtbinj d ON (d.cdinjetora = a.cdinjetora) ");
			strSQL = strSQL.concat(" WHERE a.dtturno = :dtturno ");
			strSQL = strSQL.concat("   AND a.cdturno = :cdturno ");
			strSQL = strSQL.concat("   AND d.cdinjestendido = :cdinjetora ");
			strSQL = strSQL.concat("   AND a.nrop = :nrop ");			
			strSQL = strSQL.concat(" ORDER BY a.dthripar DESC ");
			
			SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
			q.setTimestamp("dtturno", id.getDtReferencia())
			 .setString("cdturno", id.getDwTurno().getCdTurno())
			 .setString("cdinjetora", id.getOmPt().getCdPt())
			 .setString("nrop", id.getPpCp().getCdCp());
			
			List<Object> lista = new ArrayList<Object>();
			lista = q.list();
			if (lista != null && lista.size() > 0) {
				Object reg = lista.get(0);				
				
				RegistroLido registro = new RegistroLido();
				Object[] registroLido = null;
				Object registroLidoAux = (Object) reg;
				registroLido = (Object[]) registroLidoAux;				
				
				registro.dthrIPar = (Date) registroLido[_dthrIPar];
				registro.dthrFPar = (Date) registroLido[_dthrFPar];
				registro.tmpParadas = ConversaoTipos.converterParaBigDecimal(registroLido[_tmpParadasCP]).add(ConversaoTipos.converterParaBigDecimal(registroLido[_tmpParadasSP]));  
				registro.cdParada = (String) registroLido[_cdParada];
				registro.dsParada = (String) registroLido[_dsParada];
				registro.cdAreaResp = (String) registroLido[_cdAreaResp];
				registro.dsAreaResp = (String) registroLido[_dsAreaResp];
				registro.paradaComPeso = ConversaoTipos.converterParaBigDecimal(registroLido[_paradaCP]).intValue();
				
				
				DwTArea area = new DwTArea();
				area.setCdArea(registro.cdAreaResp);
				area.setDsArea(registro.dsAreaResp);
				
				DwTParada parada = new DwTParada();
				parada.setDwTArea(area);
				parada.setCdTparada(registro.cdParada);
				parada.setDsTparada(registro.dsParada);
				parada.setIsPesa(registro.paradaComPeso == 1);
				
				palog = new DwConsolpalog();
				palog.setDwTParada(parada);
				palog.setDthrIparada(registro.dthrIPar);
				palog.setDthrFparada(registro.dthrFPar);
				
				
				if (parada.getIsPesa()) {
					palog.setSegAutoTempoparadaCp(registro.tmpParadas);
				} else {
					palog.setSegAutoTempoparadaSp(registro.tmpParadas);
				}
			}			
		}
		
		return palog;
	}
		
	// Retorna o tempo da ultima parada, considerando os varios turnos por onde a parada passou
	// Esse metodo faz sentido apenas quando se analisa um PT
	public Integer calcularTempoUltimaParada() {
		return this.tempoParada;
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
