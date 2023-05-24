package idw.model.rn.consolidacao.variacaoritmo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwConsolpalogDAO;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmo;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpamo;
import idw.model.pojos.DwTParada;
import idw.model.pojos.OmPt;
import idw.model.rn.AbstractRN;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.util.AritmeticaUtil;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoVariacaoRitmo extends AbstractRN<DAOGenerico> implements IConsolidacaoVariacaoRitmo{
	
	public ConsolidacaoVariacaoRitmo(DAOGenerico dao) {
		super(dao);
	}
	
	public static void ajustarParadaVarRitmoDeDwConsolEDwConsolpa(boolean isPesaEficiencia, BigDecimal tempoParada, BigDecimal qt, DwConsol dwConsol, DwConsolpa dwConsolpa){
		if(isPesaEficiencia){
			dwConsol.setSegAutoTempoparadaCpVr(AritmeticaUtil.somar(tempoParada, dwConsol.getSegAutoTempoparadaCpVr()));
			dwConsolpa.setSegAutoTempoparadaCpVr(AritmeticaUtil.somar(tempoParada, dwConsolpa.getSegAutoTempoparadaCpVr()));
			dwConsol.setQtAutoOcoparadaCpVr(AritmeticaUtil.somar(qt, dwConsol.getQtAutoOcoparadaCpVr()));
			dwConsolpa.setQtAutoOcoparadaCpVr(AritmeticaUtil.somar(qt, dwConsolpa.getQtAutoOcoparadaCpVr()));
		}else{
			dwConsol.setSegAutoTempoparadaSpVr(AritmeticaUtil.somar(tempoParada, dwConsol.getSegAutoTempoparadaSpVr()));
			dwConsolpa.setSegAutoTempoparadaSpVr(AritmeticaUtil.somar(tempoParada, dwConsolpa.getSegAutoTempoparadaSpVr()));
			dwConsol.setQtAutoOcoparadaSpVr(AritmeticaUtil.somar(qt, dwConsol.getQtAutoOcoparadaSpVr()));
			dwConsolpa.setQtAutoOcoparadaSpVr(AritmeticaUtil.somar(qt, dwConsolpa.getQtAutoOcoparadaSpVr()));

		}
	}
	
	public static void ajustarParadaVarRitmoDeDwConsolmoEDwConsolpamo(boolean isPesaEficiencia, BigDecimal tempoParada, BigDecimal qt, DwConsolmo dwConsolmo, DwConsolpamo dwConsolpamo){

		if(isPesaEficiencia){
			dwConsolmo.setSegAutoTempoparadaCpVr(AritmeticaUtil.somar(tempoParada, dwConsolmo.getSegAutoTempoparadaCpVr()));
			dwConsolpamo.setSegAutoTempoparadaCpVr(AritmeticaUtil.somar(tempoParada, dwConsolpamo.getSegAutoTempoparadaCpVr()));
			dwConsolmo.setQtAutoOcoparadaCpVr(AritmeticaUtil.somar(qt, dwConsolmo.getQtAutoOcoparadaCpVr()));
			dwConsolpamo.setQtAutoOcoparadaCpVr(AritmeticaUtil.somar(qt, dwConsolpamo.getQtAutoOcoparadaCpVr()));
		}else{
			dwConsolmo.setSegAutoTempoparadaSpVr(AritmeticaUtil.somar(tempoParada, dwConsolmo.getSegAutoTempoparadaSpVr()));
			dwConsolpamo.setSegAutoTempoparadaSpVr(AritmeticaUtil.somar(tempoParada, dwConsolpamo.getSegAutoTempoparadaSpVr()));
			dwConsolmo.setQtAutoOcoparadaSpVr(AritmeticaUtil.somar(qt, dwConsolmo.getQtAutoOcoparadaSpVr()));
			dwConsolpamo.setQtAutoOcoparadaSpVr(AritmeticaUtil.somar(qt, dwConsolpamo.getQtAutoOcoparadaSpVr()));
		}
		
	}
	
	public void consolidarRemocaoVariacaoRitmoNoPeriodo(DwConsolid dwConsolid, OmPt omPt,  Date dtHrIperiodo, Date dtHrFperiodo) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException{
		
		DwConsolpalogDAO dwConsolpalogDAO = new DwConsolpalogDAO(this.getDaoSession());
		List<DwConsolpalog> listParadasDentroCiclo = dwConsolpalogDAO.obtemDwConsolpalogPeriodo(omPt.getIdPt(), dtHrIperiodo, dtHrFperiodo,false);
		
		for(DwConsolpalog dwConsolpalog: listParadasDentroCiclo){
			
			Date dtHrInicioVarRitmo = DataHoraRN.getMaiorData(dtHrIperiodo, dwConsolpalog.getDthrIparada());
			Date dtHrFimVarRitmo = DataHoraRN.getMenorData(dtHrFperiodo, dwConsolpalog.getDthrFparada());
			
			long duracao = DataHoraRN.getQuantidadeSegundosNoPeriodo(dtHrInicioVarRitmo, dtHrFimVarRitmo);
			
			consolidar(dwConsolid, duracao, dwConsolpalog.getDwTParada(), true);

		}

	}
	
	@Override
	public void consolidar(DwConsolid dwConsolid, long duracao, DwTParada dwTParada, boolean isAbater) {
		if(isAbater){
			duracao = (-1) * duracao;
		}
		
		DwConsol dwConsol = dwConsolid.getDwConsols().iterator().next();
		
		ConsolidaRN consolidaRN = new ConsolidaRN(this.getDao());
		DwConsolpa dwConsolpa = consolidaRN.getDwConsolpaSeNaoEncontrarGerarNovo(dwConsol, dwTParada);
		
		ConsolidacaoVariacaoRitmo.ajustarParadaVarRitmoDeDwConsolEDwConsolpa(dwTParada.getIsPesa(), new BigDecimal(duracao), BigDecimal.ONE, dwConsol, dwConsolpa);
		this.getDao().makePersistent(dwConsol);
		this.getDao().makePersistent(dwConsolpa);
		
		List<DwConsolmo> dwConsolmoComLoginAberto = consolidaRN.getDwConsolmoComLoginAberto(dwConsol.getIdConsol());
		
		//Atualizar DwConsolmo (DwConsol)
		for(DwConsolmo dwConsolmo: dwConsolmoComLoginAberto){

			// dw_consolpamo
			DwConsolpamo dwConsolpamo = consolidaRN.getDwConsolpamoSeNaoEncontrarNovo(dwConsolpa, dwConsolmo);
			ConsolidacaoVariacaoRitmo.ajustarParadaVarRitmoDeDwConsolmoEDwConsolpamo(dwTParada.getIsPesa(), new BigDecimal(duracao), BigDecimal.ONE, dwConsolmo, dwConsolpamo);
			
			this.getDao().makePersistent(dwConsolmo);
			this.getDao().makePersistent(dwConsolpamo);
			
		}	
		
	}
	

}
