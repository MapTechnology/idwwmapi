package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import idw.model.pojos.DwPepro;
import idw.model.pojos.MsEvt;
import idw.model.pojos.MsEvtcep;
import idw.model.pojos.MsUp;
import ms.model.APojoMs;

public abstract class MsEvtTemplate extends APojoMs<MsEvt>{
	public abstract Set<MsEvtcep> getMsEvtceps();
	
	private static int _MAX_LEN_ERRO_CONSOL = 512;
	
	public enum StEvt{
		PENDENTE(0), PROCESSADO(1), REJEITADO(2), APENASLOG(3), PROCESSADOREGULAGEM(4);
		private int value;
		private final BigDecimal valueBigDecimal;
		
		StEvt(int value){			
			this.value = value;
			this.valueBigDecimal = new BigDecimal(value);
		}
		public int getValue(){
			return this.value;
		}
		public BigDecimal getValueBigDecimal() {
			return this.valueBigDecimal;
		}
		public boolean equals(BigDecimal o) {
			if(o == null) {
				return false;
			}
			return o.equals(valueBigDecimal);
		}
		public boolean equals(MsEvt o) {
			if(o == null ) {
				return false;
			}
			return equals(o.getStEvt());
		}
	}
	
	public enum TpProcessado {
	    PROCESSADO_NORMAL(StEvt.PROCESSADO), PROCESSADO_REGULAGEM(StEvt.PROCESSADOREGULAGEM);
	    private final StEvt stEvt;
	    TpProcessado(StEvt stEvt){
	        this.stEvt = stEvt;
	    }
        public StEvt getStEvt() {
            return stEvt;
        }
	}
	
	@Override
	public String toString(){
		final String SEPARADOR = "|";
		StringBuilder sb = new StringBuilder();
		MsEvt msEvt = (MsEvt) this;
		sb.append("idEvt").append(SEPARADOR).append(msEvt.getIdEvt());
		sb.append("msTpevt").append(SEPARADOR).append(msEvt.getMsTpevt().getIdTpevt());
		sb.append("msMsicup").append(SEPARADOR).append((msEvt.getMsMsicup() == null ? null : msEvt.getMsMsicup().getIdMsicup()));
		sb.append("msEvt").append(SEPARADOR).append((msEvt.getMsEvt() == null ? null : msEvt.getMsEvt().getIdEvt()));
		sb.append("msUpihm").append(SEPARADOR).append((msEvt.getMsUpihm() == null ? null : msEvt.getMsUpihm()));
		sb.append("dthrEvento").append(SEPARADOR).append(msEvt.getDthrEvento());
		sb.append("stEvt").append(SEPARADOR).append(msEvt.getStEvt());
		sb.append("dthrEventoanterior").append(SEPARADOR).append(msEvt.getDthrEventoanterior());
		sb.append("dthrCadastrobanco").append(SEPARADOR).append(msEvt.getDthrCadastrobanco());
		sb.append("dthrCadastroserver").append(SEPARADOR).append(msEvt.getDthrCadastroserver());
		sb.append("miliDuracaoevento").append(SEPARADOR).append(msEvt.getMiliDuracaoevento());
		sb.append("dthrEnvioprcoletoreventos").append(SEPARADOR).append(msEvt.getDthrEnvioprcoletoreventos());
		sb.append("idPrcoletoreventos").append(SEPARADOR).append(msEvt.getIdPrcoletoreventos());
		sb.append("login").append(SEPARADOR).append(msEvt.getLogin());
		sb.append("qtdeCiclos").append(SEPARADOR).append(msEvt.getQtdeCiclos());
		sb.append("cdParada").append(SEPARADOR).append(msEvt.getCdParada());
		sb.append("cdDefeito").append(SEPARADOR).append(msEvt.getCdDefeito());
		sb.append("cdRefugo").append(SEPARADOR).append(msEvt.getCdRefugo());
		sb.append("cdConsulta").append(SEPARADOR).append(msEvt.getCdConsulta());
		sb.append("cdAcao").append(SEPARADOR).append(msEvt.getCdAcao());
		sb.append("cdCausa").append(SEPARADOR).append(msEvt.getCdCausa());
		sb.append("cdJustificativa").append(SEPARADOR).append(msEvt.getCdJustificativa());
		sb.append("cdAlerta").append(SEPARADOR).append(msEvt.getCdAlerta());
		sb.append("cdTec1").append(SEPARADOR).append(msEvt.getCdTec1());
		sb.append("cdTec2").append(SEPARADOR).append(msEvt.getCdTec2());
		sb.append("cdTecresp").append(SEPARADOR).append(msEvt.getCdTecresp());
		sb.append("cdProdutoredz").append(SEPARADOR).append(msEvt.getCdProdutoredz());
		sb.append("cdProduto").append(SEPARADOR).append(msEvt.getCdProduto());
		sb.append("nrop").append(SEPARADOR).append(msEvt.getNrop());
		sb.append("cdMolde").append(SEPARADOR).append(msEvt.getCdMolde());
		sb.append("cdEstrutura").append(SEPARADOR).append(msEvt.getCdEstrutura());	
		sb.append("origem").append(SEPARADOR).append(msEvt.getOrigem());
		sb.append("isregulagem").append(SEPARADOR).append(msEvt.getIsRegulagem());
		if (msEvt.getMsEvtceps() != null && msEvt.getMsEvtceps().size() > 0) {
			MsEvtcep cep = msEvt.getMsEvtceps().iterator().next();
			sb.append("tensao").append(SEPARADOR).append(cep.getTensao());
			sb.append("tensao1").append(SEPARADOR).append(cep.getTensao1());
			sb.append("tensao2").append(SEPARADOR).append(cep.getTensao2());
			sb.append("tensao3").append(SEPARADOR).append(cep.getTensao3());
			sb.append("tensao12").append(SEPARADOR).append(cep.getTensao1e2());
			sb.append("tensao13").append(SEPARADOR).append(cep.getTensao1e3());
			sb.append("tensao23").append(SEPARADOR).append(cep.getTensao2e3());
			sb.append("corrente").append(SEPARADOR).append(cep.getCorrente());
			sb.append("corrente1").append(SEPARADOR).append(cep.getCorrente1());
			sb.append("corrente2").append(SEPARADOR).append(cep.getCorrente2());
			sb.append("corrente3").append(SEPARADOR).append(cep.getCorrente3());
			sb.append("fp").append(SEPARADOR).append(cep.getFatorpotencia());
			sb.append("ec").append(SEPARADOR).append(cep.getEnergiaconsumida());
		}
		return sb.toString();
	}
	
	@Override
	protected MsEvt atribuir(MsEvt from, MsEvt to, boolean isCopiarFK) {
		
		if (to == null)
			to = new MsEvt();
		
		if(from.getDthrCadastrobanco() != null){
			to.setDthrCadastrobanco((Date) from.getDthrCadastrobanco().clone());
			
		}
		
		if(from.getDthrCadastroserver() != null){
			to.setDthrCadastroserver((Date) from.getDthrCadastroserver().clone());	
		}
		if(from.getDthrProcessaserver() != null){
			to.setDthrProcessaserver((Date) from.getDthrProcessaserver().clone());	
		}
		if(from.getDthrIprocessaserver() != null){
			to.setDthrIprocessaserver((Date) from.getDthrIprocessaserver().clone());	
		}

		if(from.getDthrEnvioprcoletoreventos() != null){
			to.setDthrEnvioprcoletoreventos((Date) from.getDthrEnvioprcoletoreventos().clone());	
		}

		if(from.getDthrEvento() != null){
			to.setDthrEvento((Date) from.getDthrEvento().clone());	
		}
		
		if(from.getDthrEventoanterior() != null){
			to.setDthrEventoanterior((Date) from.getDthrEventoanterior().clone());	
		}		
		
		if(from.getIdEvt() != null){
			to.setIdEvt(from.getIdEvt());
		}

		if(from.getIdPrcoletoreventos() != null){
			to.setIdPrcoletoreventos( new BigDecimal(from.getIdPrcoletoreventos().doubleValue()));	
		}		

		if(from.getMiliDuracaoevento() != null){
			to.setMiliDuracaoevento( from.getMiliDuracaoevento() );	
		}
		
		if(from.getStEvt() != null){
			to.setStEvt( new BigDecimal(from.getStEvt().doubleValue()));	
		}

		to.setLogin(from.getLogin());
		to.setQtdeCiclos(from.getQtdeCiclos());
		to.setQtde(from.getQtde());
		to.setSegCiclopadrao(from.getSegCiclopadrao());
		to.setProducaoliquida(from.getProducaoliquida());
		to.setProducaorefugada(from.getProducaorefugada());
		to.setCdParada(from.getCdParada());
		to.setCdDefeito(from.getCdDefeito());
		to.setCdRefugo(from.getCdRefugo());
		to.setCdConsulta(from.getCdConsulta());
		to.setCdAcao(from.getCdAcao());
		to.setCdCausa(from.getCdCausa());
		to.setCdJustificativa(from.getCdJustificativa());
		to.setCdAlerta(from.getCdAlerta());
		to.setCdTec1(from.getCdTec1());
		to.setCdTec2(from.getCdTec2());
		to.setCdTecresp(from.getCdTecresp());
		to.setCdProdutoredz(from.getCdProdutoredz());
		to.setCdProduto(from.getCdProduto());
		to.setNrop(from.getNrop());
		to.setCb(from.getCb());
		to.setCbserial(from.getCbserial());
		to.setCdMolde(from.getCdMolde());
		to.setCdEstrutura(from.getCdEstrutura());
		to.setSequencial(from.getSequencial());
		to.setOrigem(from.getOrigem());
		to.setDepara(from.getDepara());
		
		to.setCdUp(from.getCdUp());
		
		to.setIsRegulagem(from.getIsRegulagem());
		to.setIsMontagemfechadaantecipadamente(from.getIsMontagemfechadaantecipadamente());
		
		to.setCdComponente(from.getCdComponente());
		to.setCdFeeder(from.getCdFeeder());
		to.setCdNozzle(from.getCdNozzle());
		to.setTpErromontagem(from.getTpErromontagem());
		to.setQtErromontagem(from.getQtErromontagem());
		to.setCdArea(from.getCdArea());

		to.setSeqbigint(from.getSeqbigint()  );
		
		if(isCopiarFK == true){
			
			if (from.getDwPepro() != null) {
				to.setDwPepro((DwPepro)from.getDwPepro().clone());
			}
			
			if(from.getMsEvt() != null){
				to.setMsEvt(from.getMsEvt().clone(false));
			}
			
			if(from.getMsMsicup() != null) {
				to.setMsMsicup(from.getMsMsicup().clone());
			}
			
			if(from.getMsTpevt() != null){
				to.setMsTpevt(from.getMsTpevt().clone(false));
			}
			
			if(from.getMsUpihm() != null){
				to.setMsUpihm(from.getMsUpihm().clone(false));
			}

			if(from.getMsEvts() != null){
				Set<MsEvt> listaMsEvt = new HashSet<MsEvt>();
				for(MsEvt msEvt: from.getMsEvts()){
					listaMsEvt.add(msEvt.clone(false));
				}
				to.setMsEvts(listaMsEvt);				
			}

			if(from.getMsUpsForIdEvtiniciociclo() != null){
				Set<MsUp> listaMsUpsForIdEvtiniciociclo = new HashSet<MsUp>();
				for(MsUp msUp: from.getMsUpsForIdEvtiniciociclo()){
					listaMsUpsForIdEvtiniciociclo.add(msUp.clone(false));
				}
				to.setMsUpsForIdEvtiniciociclo(listaMsUpsForIdEvtiniciociclo);
			}

			if(from.getMsUpsForIdEvtinicioparada() != null){
				Set<MsUp> listaMsUpsForIdEvtinicioparada = new HashSet<MsUp>();
				for(MsUp msUp: from.getMsUpsForIdEvtinicioparada()){
					listaMsUpsForIdEvtinicioparada.add(msUp.clone(false));
				}
				to.setMsUpsForIdEvtiniciociclo(listaMsUpsForIdEvtinicioparada);
			}			
		}
					
		return to;
	}

	public void setResultadoProcessamento(StEvt stEvt, Date dtHrIProcessamento, Date dtHrFimProcessamento, String erroConsol) {
		MsEvt msEvt = (MsEvt) this;
		msEvt.setStEvt(new BigDecimal(stEvt.getValue()));
		msEvt.setDthrIprocessaserver(dtHrIProcessamento);
		msEvt.setDthrProcessaserver(dtHrFimProcessamento);
		msEvt.setErroconsol(limitaTamanhoErroconsol(erroConsol));
	}
	
	public static String limitaTamanhoErroconsol(String erroConsol) {
	    if (erroConsol != null && erroConsol.length() > _MAX_LEN_ERRO_CONSOL) {
	        return erroConsol.substring(0, _MAX_LEN_ERRO_CONSOL);
	    }else {
	    	return erroConsol;
	    }
	}
	
//	public void setErroconsolLimitandoTamanho(String erroConsol) {
//	    erroConsol = limitaTamanhoErroconsol(erroConsol);
//	    MsEvt msEvt = (MsEvt) this;
//	    msEvt.setErroconsol(erroConsol);
//	}
//	
	public BigDecimal obtemTemperatura() {
		BigDecimal retorno = null;
		if (getMsEvtceps().size() > 0) {
			for (MsEvtcep cep : getMsEvtceps()) {
				retorno = cep.getTemperatura();
			}
		}
		return retorno;
	}
	
	public BigDecimal obtemFatorpotencia() {
		BigDecimal retorno = null;
		if (getMsEvtceps().size() > 0) {
			for (MsEvtcep cep : getMsEvtceps()) {
				retorno = cep.getFatorpotencia();
			}
		}
		return retorno;
	}
	
	public BigDecimal obtemEnergiaconsumida() {
		BigDecimal retorno = null;
		if (getMsEvtceps().size() > 0) {
			for (MsEvtcep cep : getMsEvtceps()) {
				retorno = cep.getEnergiaconsumida();
			}
		}
		return retorno;
	}
}
