package idw.model.rn.detalhemonitorizacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolParam;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmedparamlog;
import idw.model.pojos.template.DwConsolParamTemplate;
import idw.model.pojos.template.DwFtParamTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.injet.PlanejamentoInjetRN;
import idw.webservices.dto.PeriodoDTO;
import ms.util.ConversaoTipos;

/*
 * Essa classe tem como objetivo retornar uma lista com o consumo de producao x energia eletrica
 */
public class EnergiaConsumidaProducaoRN  extends AbstractRN<DAOGenerico> {

	public EnergiaConsumidaProducaoRN() {
		super(new DAOGenerico());
	}

	public EnergiaConsumidaProducaoRN(DAOGenerico dao) {
		super(dao);
	}

	public List<EnergiaConsumidaProducaoDTO> getListaEnergiaConsumidaProducao(List<DwConsolid> lista) {
		Map<String, EnergiaConsumidaProducaoDTO> ops = new HashMap<>();
		for (DwConsolid id : lista) {
			String cdOP = id.getPpCp().getNrop();
			for (DwConsol consol : id.getDwConsols()) {
				for (DwConsolParam param : consol.getDwConsolParams() ) {
					getDao().evict(param);
					getDao().evict(consol);
					// Se nao for ENERGIA CONSUMIDA, descartar
					if (param.getDwFtParam().getIdFtParam() != DwFtParamTemplate.Type.ENERGIACONSUMIDA.getId() ||
							param.getTpReferencia().equals(DwConsolParamTemplate.TpReferencia.tempo_avaliar.getValue()) == false
							) {
						continue;
					}
					
					// Para energia consumida agrupar po OP
					EnergiaConsumidaProducaoDTO dto;
					if (ops.containsKey(cdOP)) {
						dto = ops.get(cdOP);
					} else {
						dto = new EnergiaConsumidaProducaoDTO();
						dto.setNrop(cdOP);
						dto.setProducaoBrutaKwh(BigDecimal.ZERO);
						dto.setProducaoBrutaValormonetario(BigDecimal.ZERO);
						dto.setProducaoLiquidaKwh(BigDecimal.ZERO);
						dto.setProducaoLiquidaValormonetario(BigDecimal.ZERO);
						dto.setProducaoRefugadaKwh(BigDecimal.ZERO);
						dto.setProducaoRefugadaValormonetario(BigDecimal.ZERO);
						dto.setProducaoBruta(BigDecimal.ZERO);
						dto.setProducaoLiquida(BigDecimal.ZERO);
						dto.setProducaoRefugada(BigDecimal.ZERO);
						dto.setKwh(BigDecimal.ZERO);
						dto.setValorMonetario(BigDecimal.ZERO);
						ops.put(cdOP, dto);
					}
					BigDecimal producaoBruta = BigDecimal.ZERO;
					BigDecimal producaoLiquida = BigDecimal.ZERO;
					BigDecimal producaoRefugada = BigDecimal.ZERO;
					BigDecimal kwh = BigDecimal.ZERO;
					BigDecimal valorMonetario = BigDecimal.ZERO;

					if (consol.getPcsProducaoBruta() != null)
						producaoBruta = consol.getPcsProducaoBruta();
					if (consol.getPcsProducaoLiquida() != null)
						producaoLiquida = consol.getPcsProducaoLiquida(); //.divide(param.getVlSomado(), BigDecimal.ROUND_HALF_EVEN);
					if (consol.getPcsAutoProducaorefugada() != null)
						producaoRefugada = consol.getPcsAutoProducaorefugada(); // .divide(param.getVlSomado(), BigDecimal.ROUND_HALF_EVEN);
					if (param.getVlSomado() != null && param.getVlSomado().compareTo(BigDecimal.ZERO) > 0)
						kwh = param.getVlSomado();
					if (param.getVlMonetario() != null && param.getVlMonetario().compareTo(BigDecimal.ZERO) > 0)
						valorMonetario = param.getVlMonetario();
					
					// Atualiza valores
					dto.setProducaoBruta(dto.getProducaoBruta().add(producaoBruta) );
					dto.setProducaoLiquida(dto.getProducaoLiquida().add(producaoLiquida));
					dto.setProducaoRefugada(dto.getProducaoRefugada().add(producaoRefugada));
					dto.setKwh(dto.getKwh().add(kwh));
					dto.setValorMonetario(dto.getValorMonetario().add(valorMonetario));
					
				}
			}
		}
		
		// Com os totais encontrados, calcular o valores finais
		for (String cdop : ops.keySet()) {
			EnergiaConsumidaProducaoDTO dto = ops.get(cdop);

			/* Calcula valor monetario */
			BigDecimal producaoBrutaValormonetario = BigDecimal.ZERO;
			BigDecimal producaoLiquidaValormonetario = BigDecimal.ZERO;
			BigDecimal producaoRefugadaValormonetario = BigDecimal.ZERO;

			if (dto.getValorMonetario() != null && dto.getValorMonetario().compareTo(BigDecimal.ZERO) > 0) {
				producaoBrutaValormonetario = dto.getProducaoBruta().divide(dto.getValorMonetario(), BigDecimal.ROUND_HALF_EVEN);
				producaoLiquidaValormonetario = dto.getProducaoLiquida().divide(dto.getValorMonetario(), BigDecimal.ROUND_HALF_EVEN);
				producaoRefugadaValormonetario = dto.getProducaoRefugada().divide(dto.getValorMonetario(), BigDecimal.ROUND_HALF_EVEN);
			}
			dto.setProducaoBrutaValormonetario(dto.getProducaoBrutaValormonetario().add(producaoBrutaValormonetario));
			dto.setProducaoLiquidaValormonetario(dto.getProducaoLiquidaValormonetario().add(producaoLiquidaValormonetario));
			dto.setProducaoRefugadaValormonetario(dto.getProducaoRefugadaValormonetario().add(producaoRefugadaValormonetario));

			/* Calcula valores */
			BigDecimal producaoBrutaKwh = BigDecimal.ZERO;
			BigDecimal producaoLiquidaKwh = BigDecimal.ZERO;
			BigDecimal producaoRefugadaKwh = BigDecimal.ZERO;

			if (dto.getKwh() != null && dto.getKwh().compareTo(BigDecimal.ZERO) > 0) {
				producaoBrutaKwh = dto.getProducaoBruta().divide(dto.getKwh(), BigDecimal.ROUND_HALF_EVEN);
				producaoLiquidaKwh = dto.getProducaoLiquida().divide(dto.getKwh(), BigDecimal.ROUND_HALF_EVEN);
				producaoRefugadaKwh = dto.getProducaoRefugada().divide(dto.getKwh(), BigDecimal.ROUND_HALF_EVEN);
			}
			
			dto.setProducaoBrutaKwh(producaoBrutaKwh);
			dto.setProducaoLiquidaKwh(producaoLiquidaKwh);
			dto.setProducaoRefugadaKwh(producaoRefugadaKwh);
		}
		
		// Prepara retorno
		List<EnergiaConsumidaProducaoDTO> retorno = new ArrayList<>(ops.values());
		return retorno;
	}

	public List<EnergiaConsumidaProducaoDTO> getListaEnergiaConsumidaProducaoInjet(DAOGenericoInjet daoInj, DAOGenerico daoVF, List<DwConsolid> lista) {
		Map<String, EnergiaConsumidaProducaoDTO> ops = new HashMap<>();
		for (DwConsolid id : lista) {
			String cdCP = id.getPpCp().getCdCp();
			String cdPt = id.getOmPt().getCdPt();
			Date dthrIniTur = id.getDthrIturno();
			Date dthrFimTur = id.getDthrFturno();
			
			List<PeriodoDTO> listaPeriodosOP = new ArrayList<>();
			PlanejamentoInjetRN ijRN = new PlanejamentoInjetRN(daoInj);
			listaPeriodosOP = ijRN.getPeriodosOPTurno(cdPt, cdCP, dthrIniTur, dthrFimTur);
			
			for (DwConsol consol : id.getDwConsols()) {				
				for (PeriodoDTO periodo : listaPeriodosOP) {
					// recuperar valores
			    	MapQuery q = new MapQuery(daoVF.getSession());
			    	q.append("SELECT SUM(CASE WHEN logm.vlrLido IS NULL THEN  0 ELSE logm.vlrLido END) as vlLido, ");
					q.append("       SUM(CASE WHEN logm.vlMonetario  IS NULL THEN  0 ELSE logm.vlMonetario END) as vlMonetario ");
			    	q.append("  FROM DwConsolParam cpm");
			    	q.append("  JOIN cpm.dwConsolParammeds meds");
			    	q.append("  JOIN meds.dwConsolmedparamlog logm");
			    	q.append(" WHERE cpm.dwConsol.dwConsolid.omPt.cdPt = :cdpt");
					q.append("   AND cpm.dwFtParam.idFtParam = :idft ");
					q.append("   AND cpm.tpReferencia = :idtpref ");
			    	q.append("   AND logm.dthrMedicao BETWEEN :dthrini AND :dthrfim");
			    	
					q.defineParametro("cdpt", cdPt);
					//20180814 testes q.defineParametro("idft", DwFtParamTemplate.Type.ENERGIACONSUMIDA .getId());
					//20180814 testes q.defineParametro("idft", DwFtParamTemplate.Type.CORRENTE.getId());
					q.defineParametro("idft", DwFtParamTemplate.Type.ENERGIACONSUMIDA.getId());
					q.defineParametro("idtpref", DwConsolParamTemplate.TpReferencia.tempo_avaliar.getValue());
					q.defineParametro("dthrini", periodo.getDtHrInicio());
					q.defineParametro("dthrfim", periodo.getDtHrFim());
					q.setMaxResults(1);
			
					List<Object> listaEnergy = q.list();
					if (listaEnergy.size() > 0) {
					    Object reg = listaEnergy.get(0);
						Object[] registro = null;
						Object regAux = (Object) reg;
						registro = (Object[]) regAux;
							
						BigDecimal vlLido = ConversaoTipos.converterParaBigDecimal(registro[0]);
						BigDecimal vlMonetario = ConversaoTipos.converterParaBigDecimal(registro[1]);
						
						if (vlLido != null) {
							// Para energia consumida agrupar po OP
							EnergiaConsumidaProducaoDTO dto;
							if (ops.containsKey(cdCP)) {
								dto = ops.get(cdCP);
							} else {
								dto = new EnergiaConsumidaProducaoDTO();
								dto.setNrop(cdCP);
								dto.setProducaoBrutaKwh(BigDecimal.ZERO);
								dto.setProducaoBrutaValormonetario(BigDecimal.ZERO);
								dto.setProducaoLiquidaKwh(BigDecimal.ZERO);
								dto.setProducaoLiquidaValormonetario(BigDecimal.ZERO);
								dto.setProducaoRefugadaKwh(BigDecimal.ZERO);
								dto.setProducaoRefugadaValormonetario(BigDecimal.ZERO);
								dto.setProducaoBruta(BigDecimal.ZERO);
								dto.setProducaoLiquida(BigDecimal.ZERO);
								dto.setProducaoRefugada(BigDecimal.ZERO);
								dto.setKwh(BigDecimal.ZERO);
								dto.setValorMonetario(BigDecimal.ZERO);
								ops.put(cdCP, dto);
							}
							BigDecimal producaoBruta = BigDecimal.ZERO;
							BigDecimal producaoLiquida = BigDecimal.ZERO;
							BigDecimal producaoRefugada = BigDecimal.ZERO;
							BigDecimal kwh = BigDecimal.ZERO;
							BigDecimal valorMonetario = BigDecimal.ZERO;
		
							if (consol.getPcsProducaoBruta() != null)
								producaoBruta = consol.getPcsProducaoBruta();
							
							if (consol.getPcsProducaoLiquida() != null)
								producaoLiquida = consol.getPcsProducaoLiquida(); //.divide(param.getVlSomado(), BigDecimal.ROUND_HALF_EVEN);
							
							if (consol.getPcsAutoProducaorefugada() != null)
								producaoRefugada = consol.getPcsAutoProducaorefugada(); // .divide(param.getVlSomado(), BigDecimal.ROUND_HALF_EVEN);
							
							if (vlLido.compareTo(BigDecimal.ZERO) > 0)
								kwh = vlLido;
							
							if (vlMonetario.compareTo(BigDecimal.ZERO) > 0)
								valorMonetario = vlMonetario;
							
							// Atualiza valores
							dto.setProducaoBruta(dto.getProducaoBruta().add(producaoBruta) );
							dto.setProducaoLiquida(dto.getProducaoLiquida().add(producaoLiquida));
							dto.setProducaoRefugada(dto.getProducaoRefugada().add(producaoRefugada));
							dto.setKwh(dto.getKwh().add(kwh));
							dto.setValorMonetario(dto.getValorMonetario().add(valorMonetario));
						}
					}
				}
			}
		}
		
		// Com os totais encontrados, calcular o valores finais
		for (String cdop : ops.keySet()) {
			EnergiaConsumidaProducaoDTO dto = ops.get(cdop);

			/* Calcula valor monetario */
			BigDecimal producaoBrutaValormonetario = BigDecimal.ZERO;
			BigDecimal producaoLiquidaValormonetario = BigDecimal.ZERO;
			BigDecimal producaoRefugadaValormonetario = BigDecimal.ZERO;

			if (dto.getValorMonetario() != null && dto.getValorMonetario().compareTo(BigDecimal.ZERO) > 0) {
				producaoBrutaValormonetario = dto.getProducaoBruta().divide(dto.getValorMonetario(), BigDecimal.ROUND_HALF_EVEN);
				producaoLiquidaValormonetario = dto.getProducaoLiquida().divide(dto.getValorMonetario(), BigDecimal.ROUND_HALF_EVEN);
				producaoRefugadaValormonetario = dto.getProducaoRefugada().divide(dto.getValorMonetario(), BigDecimal.ROUND_HALF_EVEN);
			}
			dto.setProducaoBrutaValormonetario(dto.getProducaoBrutaValormonetario().add(producaoBrutaValormonetario));
			dto.setProducaoLiquidaValormonetario(dto.getProducaoLiquidaValormonetario().add(producaoLiquidaValormonetario));
			dto.setProducaoRefugadaValormonetario(dto.getProducaoRefugadaValormonetario().add(producaoRefugadaValormonetario));

			/* Calcula valores */
			BigDecimal producaoBrutaKwh = BigDecimal.ZERO;
			BigDecimal producaoLiquidaKwh = BigDecimal.ZERO;
			BigDecimal producaoRefugadaKwh = BigDecimal.ZERO;

			if (dto.getKwh() != null && dto.getKwh().compareTo(BigDecimal.ZERO) > 0) {
				producaoBrutaKwh = dto.getProducaoBruta().divide(dto.getKwh(), BigDecimal.ROUND_HALF_EVEN);
				producaoLiquidaKwh = dto.getProducaoLiquida().divide(dto.getKwh(), BigDecimal.ROUND_HALF_EVEN);
				producaoRefugadaKwh = dto.getProducaoRefugada().divide(dto.getKwh(), BigDecimal.ROUND_HALF_EVEN);
			}
			
			dto.setProducaoBrutaKwh(producaoBrutaKwh);
			dto.setProducaoLiquidaKwh(producaoLiquidaKwh);
			dto.setProducaoRefugadaKwh(producaoRefugadaKwh);
		}
		
		// Prepara retorno
		List<EnergiaConsumidaProducaoDTO> retorno = new ArrayList<>(ops.values());
		return retorno;
	}
}
