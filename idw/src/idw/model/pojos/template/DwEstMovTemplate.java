package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.Date;

import idw.model.pojos.DwEstlocalpro;
import idw.model.pojos.DwEstmov;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.OmUsr;
import idw.model.rn.DataHoraRN;
import idw.util.AritmeticaUtil;
import idw.util.CloneUtil;

/**
 * Lancamento da modificacao no estoque
 *
 */
public abstract class DwEstMovTemplate extends AbstractTemplate<DwEstmov>{
	
	public enum TpLancamento{
		TOTAL("AJUSTE"),
		AJUSTE("AJUSTE"),
		FINAL_MES("FINAL MES");
		
		private final String ds;
		
		TpLancamento(String ds){
			this.ds = ds;
		}
		
		public String getDs(){
			return this.ds;
		}
		
	}
	
	public enum TpOrigem{
		
		APONTAMENTO_AUTO(0),
		AJUSTE_MANUAL(1),
		IMPORTADO(2),
		INTEGRADO(3),
		AJUSTE_AUTO(4),
		CHECKLEVEL(5);
		
		private final int id;
		TpOrigem(int id){
			this.id = id;
		}
		
		public int getId(){
			return this.id;
		}
		
	}
	
	public enum TpMov{
		ENTRADA(0),
		SAIDA(1),
		AJUSTE(2),
		TOTAL(3);
		
		private final int id;
		TpMov(int id){
			this.id = id;
		}
		
		public int getId(){
			return this.id;
		}
		
	}

	public static DwEstmov newDwEstMovTotal(Date dtHrCadastro, Date dthrMov, DwEstpro dwestpro, DwEstlocalpro dwEstlocalpro, OmUsr omusr,  
			BigDecimal qtTotal, DwEstMovTemplate.TpOrigem tpOrigem) {
		
		return newDwEstMov(dtHrCadastro, dthrMov, dwestpro, dwEstlocalpro, omusr, DwEstMovTemplate.TpLancamento.TOTAL, qtTotal, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, DwEstMovTemplate.TpMov.TOTAL, tpOrigem);
		
	}

	public static DwEstmov newDwEstMovAjuste(Date dtHrCadastro, Date dthrMov, DwEstpro dwestpro, DwEstlocalpro dwEstlocalpro,  
			OmUsr omusr, BigDecimal qtTotal, BigDecimal qtAjuste, BigDecimal qtEntrada, BigDecimal qtSaida, DwEstMovTemplate.TpOrigem tpOrigem) {
		
		return newDwEstMov(dtHrCadastro, dthrMov, dwestpro, dwEstlocalpro, omusr, DwEstMovTemplate.TpLancamento.AJUSTE, qtTotal, qtAjuste, qtEntrada, qtSaida, DwEstMovTemplate.TpMov.AJUSTE, tpOrigem);
		
	}	
	
	public static DwEstmov newDwEstMov(Date dtHrCadastro, Date dthrMov, DwEstpro dwestpro, DwEstlocalpro dwEstlocalpro, OmUsr omusr, DwEstMovTemplate.TpLancamento tpLancamento, 
			BigDecimal qtTotal, BigDecimal qtAjuste, BigDecimal qtEntrada, BigDecimal qtSaida, DwEstMovTemplate.TpMov tpMov, DwEstMovTemplate.TpOrigem tpOrigem) {
		
		int ano = DataHoraRN.getApenasAno(dthrMov);
		int mes = DataHoraRN.getApenasMes(dthrMov);
		
		DwEstmov dwestmov = new DwEstmov();
		dwestmov.setDthrCadastro(dtHrCadastro);
		dwestmov.setDthrMov(dthrMov);
		dwestmov.setAno(ano);
		dwestmov.setMes(mes);
		dwestmov.setDwEstpro(dwestpro);
		dwestmov.setDwEstlocalpro(dwEstlocalpro);
		dwestmov.setIdEstmov(null);
		dwestmov.setIsEfetivado(true);
		dwestmov.setOmUsr(omusr);
		dwestmov.setLancamento(tpLancamento.getDs());
		dwestmov.setDwTurno(null);
		if(dwEstlocalpro != null){
			dwestmov.setQtEntradaAnt(dwEstlocalpro.getQtEntrada());
			dwestmov.setQtReservadaAnt(BigDecimal.ZERO);
			dwestmov.setQtSaidaAnt(dwEstlocalpro.getQtSaida());
			dwestmov.setQtAjusteAnt(dwEstlocalpro.getQtAjuste());
			dwestmov.setQtTotalAnt(dwEstlocalpro.getQtTotal());			
		}else{
			dwestmov.setQtEntradaAnt(dwestpro.getQtEntrada());
			dwestmov.setQtReservadaAnt(dwestpro.getQtReservada());
			dwestmov.setQtSaidaAnt(dwestpro.getQtSaida());
			dwestmov.setQtAjusteAnt(dwestpro.getQtAjuste());
			dwestmov.setQtTotalAnt(dwestpro.getQtTotal());			
		}
		
		dwestmov.setTpMov(tpMov.getId()); 
		dwestmov.setTpOrigem(tpOrigem.getId());
		dwestmov.setQtTotal(qtTotal);
		dwestmov.setQtAjuste(qtAjuste);
		dwestmov.setQtAjuste(AritmeticaUtil.somar(dwestmov.getQtAjuste(), qtEntrada));
		dwestmov.setQtAjuste(AritmeticaUtil.diminuir(dwestmov.getQtAjuste(), qtSaida));
		
		return dwestmov;
	}
	
	@Override
	protected DwEstmov atribuir(DwEstmov from, DwEstmov to, boolean isCopiarFK) {
		if(to == null){
			to = new DwEstmov();
		}

		to.setIdEstmov(from.getIdEstmov());
		to.setQtAjuste(from.getQtAjuste());
		to.setQtAjusteAnt(from.getQtAjusteAnt());
		to.setQtEntradaAnt(from.getQtEntradaAnt());
		to.setQtReservadaAnt(from.getQtReservadaAnt());
		to.setQtSaidaAnt(from.getQtSaidaAnt());
		to.setQtTotal(from.getQtTotal());
		to.setQtTotalAnt(from.getQtTotalAnt());
		
		to.setDthrMov(from.getDthrMov());
		to.setDthrCadastro(from.getDthrCadastro());
		to.setIsEfetivado(from.getIsEfetivado());
		to.setTpMov(from.getTpMov());
		to.setTpOrigem(from.getTpOrigem());
		to.setLancamento(from.getLancamento());
		
		
		to.setAno(from.getAno());
		to.setMes(from.getMes());
		
		if(isCopiarFK){
			to.setOmUsr(CloneUtil.clone(from.getOmUsr(),false));
			to.setDwEstpro(CloneUtil.clone(from.getDwEstpro(),false));
			to.setOmPt(CloneUtil.clone(from.getOmPt(), false));
			to.setDwTurno(CloneUtil.clone(from.getDwTurno(), false));
			to.setOmGt(CloneUtil.clone(from.getOmGt(), false));
		}
		
		return to;
	}
	
}
