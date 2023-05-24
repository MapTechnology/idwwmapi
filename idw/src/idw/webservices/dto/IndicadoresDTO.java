package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwRt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.AbstractTemplate;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.detalhemonitorizacao.IndicadorCicloMedioRN;
import idw.model.rn.monitorizacao.injet.DetalheMonitorizacaoPTInjetRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.util.Util;

@SuppressWarnings("serial")
public class IndicadoresDTO extends AbstractTemplate<IndicadoresDTO> implements Serializable{
	private Date dtHrIPeriodo;
	private Date dtHrFPeriodo;
	private Date dtHrIConsol;
	private Date dtHrFConsol;
	private String cdCp;
	private String cdPt;
	private BigDecimal tempoPeriodo;
	private BigDecimal tempoTotal;	
	private BigDecimal indiceCavidadesAtivas;
	private BigDecimal eficienciaRealizacao;
	private BigDecimal eficienciaCiclo;
	private BigDecimal eficienciaInstantanea;
	private BigDecimal indiceProducao;
	private BigDecimal indicePerda;
	private BigDecimal indiceParada;
	private BigDecimal indiceRefugo;
	private BigDecimal oee;
	private BigDecimal producaoPlanejada;
	private BigDecimal producaoPlanejadaMedia;
	private BigDecimal producaoPrevista;
	private BigDecimal producaoRefugada;
	private BigDecimal producaoBruta;
	private BigDecimal producaoLiquida;
	private BigDecimal perdaCavidade;
	private BigDecimal perdaParada;
	private BigDecimal perdaCiclo;
	private BigDecimal perdaTotal;
	private BigDecimal tempoProdutivo;
	private BigDecimal cicloMedio;	
	private BigDecimal ritmo;  
	private BigDecimal tempoRefugado;
	private BigDecimal tempoTrabalhado;
	private BigDecimal tempoCicloImprodutivo;
	private BigDecimal tempoCicloProdutivo;
	private BigDecimal tempoCicloRegulagem;
	private BigDecimal qtCicloRegulagem;
	private BigDecimal qtCicloImprodutivo;
	private BigDecimal qtCicloProdutivo;	
	private BigDecimal tempoParadaCp;
	private BigDecimal tempoParadaSp;
	private BigDecimal tempoParadaCpVr;
	private BigDecimal tempoParadaSpVr;
	private BigDecimal tempoAtivo;
	private BigDecimal cicloPadraoMedio;
	private BigDecimal cicloPadrao;
	private BigDecimal tempoPerdaCavidade;
	private BigDecimal tempoBoas;
	private BigDecimal tempoRefugadas;
	private BigDecimal tempoAlerta;
	private BigDecimal cavTotal;
	private BigDecimal cavAtivas;
	private BigDecimal cavTotalMedia;
	private BigDecimal cavAtivasMedia;	
	private BigDecimal tempoParadaMtbf;

	private BigDecimal tempoParadaPao;
	private BigDecimal tempoParadaPa;
	private BigDecimal tempoParadaPtp;
	private BigDecimal tempoParadaScp;
	private BigDecimal tempoParadaMdo;
	private BigDecimal tempoParadaFds;
	private BigDecimal tempoParadaImprev;
	private BigDecimal tempoParadaPrev;
	private BigDecimal tempoParadaPp;
	private BigDecimal tempoParadaRegulagem;
	private BigDecimal tempoParadaDefault;
	private BigDecimal tempoParadaSemOp;
	private BigDecimal tempoParadaSemEvt;
	private BigDecimal tempoParadaSemCnx;	
	private BigDecimal pesoBruto;
	private BigDecimal pesoLiquido;
	private BigDecimal tempoParadaAb;
	private BigDecimal qtParadaMtbf;
	private BigDecimal qtParadaMttr;
	private BigDecimal qtParadaPao;
	private BigDecimal qtParadaPa;
	private BigDecimal qtParadaPtp;
	private BigDecimal qtParadaScp;
	private BigDecimal qtParadaMdo;
	private BigDecimal qtParadaFds;
	private BigDecimal qtParadaImprev;
	private BigDecimal qtParadaPrev;
	private BigDecimal qtParadaPp;
	private BigDecimal qtParadaRegulagem;
	private BigDecimal qtParadaDefault;
	private BigDecimal qtParadaSemOp;
	private BigDecimal qtParadaSemEvt;
	private BigDecimal qtParadaSemCnx;	
	private BigDecimal ITO;	
	private BigDecimal IDO;	
	private BigDecimal IPA;
	private BigDecimal ultimoCiclo;
	private long qtAgrupCicloPadrao;
	private long qtAgrupProducaoPlanejada;

	private transient Agrupador agrupador;
	
	
	public String getCdCp() {
		return cdCp;
	}

	public void setCdCp(String cdCp) {
		this.cdCp = cdCp;
	}

	public String getCdPt() {
		return cdPt;
	}

	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}

	public BigDecimal getCavTotalMedia() {
		return cavTotalMedia;
	}

	public void setCavTotalMedia(BigDecimal cavTotalMedia) {
		this.cavTotalMedia = cavTotalMedia;
	}

	public BigDecimal getCavAtivasMedia() {
		return cavAtivasMedia;
	}

	public void setCavAtivasMedia(BigDecimal cavAtivasMedia) {
		this.cavAtivasMedia = cavAtivasMedia;
	}

	public BigDecimal getUltimoCiclo() {
		return ultimoCiclo;
	}

	public void setUltimoCiclo(BigDecimal ultimoCiclo) {
		this.ultimoCiclo = ultimoCiclo;
	}

	public IndicadoresDTO(){
	}
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public BigDecimal getIndiceProducao() {
		return indiceProducao;
	}

	public long getQtAgrupProducaoPlanejada() {
		return qtAgrupProducaoPlanejada;
	}

	public void setQtAgrupProducaoPlanejada(long qtAgrupProducaoPlanejada) {
		this.qtAgrupProducaoPlanejada = qtAgrupProducaoPlanejada;
	}

	public void setIndiceProducao(BigDecimal indiceProducao) {
		this.indiceProducao = indiceProducao;
	}
	
	public long getQtAgrupCicloPadrao() {
		return qtAgrupCicloPadrao;
	}

	public void setQtAgrupCicloPadrao(long qtAgrupCicloPadrao) {
		this.qtAgrupCicloPadrao = qtAgrupCicloPadrao;
	}


	/**
	 * Agrupa os dados 
	 * @param params Usado para for�ar o m�todo a ser transient (n�o ser� referenciado quando o webservice for gerado)
	 * 
	 */	
	public Agrupador getAgrupador(Object... params){
		if(this.agrupador == null){
			this.agrupador = new Agrupador(this);
		}
		return this.agrupador;
	}
	
	
	
	
	public static IndicadoresDTO newInstance(DwConsolid dwConsolid, OmCfg omcfg, DAOGenerico dao){
		IndicadoresDTO ind = new IndicadoresDTO();
		
		DwConsol dwConsol = dwConsolid.getDwConsols().iterator().next();
		
		if( dwConsolid != null ){
			if(dwConsolid.getPpCp() != null){
				ind.setProducaoPlanejada(new BigDecimal(dwConsolid.getPpCp().getQtPecasProduzir()));
				ind.setCdCp(dwConsolid.getPpCp().getCdCp());
			}
		
			if(DwConsolidTemplate.TpId.HORA.equals(dwConsolid.getTpId())){
				ind.setDtHrIPeriodo(dwConsolid.getDthrIhora());
				ind.setDtHrFPeriodo(dwConsolid.getDthrFhora());
			}else if(DwConsolidTemplate.TpId.TURNO.equals(dwConsolid.getTpId())){
				ind.setDtHrIPeriodo(dwConsolid.getDthrIturno());
				ind.setDtHrFPeriodo(dwConsolid.getDthrFturno());			
			}else{
				ind.setDtHrIPeriodo(dwConsolid.getDthrIconsol());
				ind.setDtHrFPeriodo(dwConsolid.getDthrFconsol());				
			}			
			
			ind.setDtHrIConsol(dwConsolid.getDthrIconsol());
			ind.setDtHrFConsol(dwConsolid.getDthrFconsol());
			
			// Guarda o �ltimo ciclo
			if(dwConsolid.getDwRt() != null){
				if (IdwFacade.IS_IDW_ATIVO) {
					DwRt dwRt = dwConsolid.getDwRt();				
					ind.setUltimoCiclo(dwRt.getSegUltimociclo());					
				} else {
					DetalheMonitorizacaoPTInjetRN rn = new DetalheMonitorizacaoPTInjetRN();
					rn.getDao().iniciaSessao();
					ind.setUltimoCiclo(rn.pegaUltimoCiclo(dwConsolid.getOmPt(), dwConsolid.getPpCp()));
					rn.getDao().finalizaSessao();
				}
			}			

			if(dwConsolid.getOmPt() != null){
				ind.setCdPt(dwConsolid.getOmPt().getCdPt());
			}
		}
		
		ind.setProducaoPrevista(AritmeticaUtil.somar(dwConsol.getPcsAutoProducaoprevista(), dwConsol.getPcsManuProducaoprevista()));
		ind.setProducaoRefugada(dwConsol.getPcsProducaoRefugada());
		
		ind.setProducaoBruta(dwConsol.getPcsProducaoBruta());
		ind.setProducaoLiquida(dwConsol.getPcsProducaoLiquida());
		ind.setPerdaCavidade(AritmeticaUtil.somar(dwConsol.getPcsAutoPerdacavidades(), dwConsol.getPcsManuPerdacavidades()));
		ind.setPerdaParada(dwConsol.getPcsAutoPerdaparadaCp());
		ind.setPerdaCiclo(dwConsol.getPcsAutoPerdaciclo());
	
		//Marcos Sardinha: 2017-09-01 >> Defeito #4540 >> tempo produtivo bichado
		//ind.setTempoProdutivo(AritmeticaUtil.somar(dwConsol.getSegAutoTempoprodutivo(), dwConsol.getSegManuTempoprodutivo()));
		BigDecimal qtCicloprodutivo = AritmeticaUtil.somar(dwConsol.getQtAutoCicloprodutivo() == null ? BigDecimal.ZERO : dwConsol.getQtAutoCicloprodutivo() , 
		    	 										 dwConsol.getQtManuCicloprodutivo() == null ? BigDecimal.ZERO : dwConsol.getQtManuCicloprodutivo());		
		BigDecimal segCicloProdutivo = AritmeticaUtil.somar(dwConsol.getSegAutoCicloprodutivo() == null ? BigDecimal.ZERO : dwConsol.getSegAutoCicloprodutivo() , 
													    	dwConsol.getSegManuCicloprodutivo() == null ? BigDecimal.ZERO : dwConsol.getSegManuCicloprodutivo());
		BigDecimal segTempoParadaComPesoVariacaoRitmo = AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadaCpVr() == null ? BigDecimal.ZERO : dwConsol.getSegAutoTempoparadaCpVr() , 
																			 dwConsol.getSegManuTempoparadaCpVr() == null ? BigDecimal.ZERO : dwConsol.getSegManuTempoparadaCpVr());
		BigDecimal segTempoParadaSemPesoVariacaoRitmo = AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadaSpVr() == null ? BigDecimal.ZERO : dwConsol.getSegAutoTempoparadaSpVr(), 
		    	 															 dwConsol.getSegManuTempoparadaSpVr() == null ? BigDecimal.ZERO : dwConsol.getSegManuTempoparadaSpVr());
		
		BigDecimal segTemporefugado = FormulasInjet.calcularTempoRefugoComBaseNoCiclo(ind.getProducaoBruta(), ind.getProducaoRefugada(), segCicloProdutivo);

		BigDecimal segBoas = FormulasInjet.calcularTempoBoas(segCicloProdutivo, segTemporefugado, segTempoParadaComPesoVariacaoRitmo, segTempoParadaSemPesoVariacaoRitmo);
		BigDecimal segRitmo = FormulasInjet.calcularRitmo(segCicloProdutivo, qtCicloprodutivo, dwConsol.getSegAutoCiclopadrao() , segTempoParadaComPesoVariacaoRitmo, segTempoParadaSemPesoVariacaoRitmo);
		BigDecimal horasProdutivas = FormulasInjet.calcularTempoprodutivas(segBoas, BigDecimal.ZERO, segRitmo);
		ind.setTempoProdutivo(horasProdutivas);
		
		IndicadorCicloMedioRN cmRN = new IndicadorCicloMedioRN(omcfg, dwConsolid.getOmPt(), dwConsol.getSegAutoCicloprodutivo(), dwConsol.getQtAutoCicloprodutivo(), dwConsol.getSegAutoTempoparadaSp());
		ind.setCicloMedio(cmRN.calcularCicloMedio());
		
		ind.setTempoAtivo(dwConsol.getSegAutoTempoativo());
		
		
		ind.setRitmo(dwConsol.getSegAutoRitmo());  
		ind.setTempoRefugado(dwConsol.getSegAutoTemporefugadas());
		ind.setTempoTrabalhado(dwConsol.getSegAutoTempotrabalhado());
		ind.setTempoCicloImprodutivo(dwConsol.getSegAutoCicloimprodutivo());
		ind.setTempoCicloProdutivo(dwConsol.getSegAutoCicloprodutivo());
		//TODO aguardar getSegAutoCicloregulagem() ser criado  
		//ind.setTempoCicloRegulagem(dwConsol.getSegAutoCicloregulagem());		
		ind.setQtCicloRegulagem(dwConsol.getQtAutoCicloregulagem());
		ind.setQtCicloImprodutivo(dwConsol.getQtAutoCicloimprodutivo());
		ind.setQtCicloProdutivo(dwConsol.getQtAutoCicloprodutivo());	
		ind.setTempoParadaCp(dwConsol.getSegAutoTempoparadaCp());
		ind.setTempoParadaSp(dwConsol.getSegAutoTempoparadaSp());

		List<DwConsolid> consolids = new ArrayList<>();
		consolids.add(dwConsolid);
		
		if (ind.getPerdaParada() == null)
			ind.setPerdaParada(BigDecimal.ZERO);

		ind.setTempoParadaCpVr(dwConsol.getSegAutoTempoparadaCpVr());
		ind.setTempoParadaSpVr(dwConsol.getSegAutoTempoparadaSpVr());
			
		ind.setCicloPadrao(dwConsol.getSegAutoCiclopadrao());
		ind.setTempoPerdaCavidade(dwConsol.getPcsAutoPerdacavidades());
		ind.setTempoBoas(dwConsol.getSegAutoBoas());
		ind.setTempoRefugadas(dwConsol.getSegAutoTemporefugadas());
		ind.setTempoAlerta(dwConsol.getSegAutoTempoalerta());
		
		//Marcos Sardinha: 2017-09-05 >> Defeito #4552
		//ind.setCavTotal(dwConsol.getPcsAutoCavTotal());
		//ind.setCavAtivas(dwConsol.getPcsAutoCavAtivas());
		ind.setCavTotal(dwConsol.getQtAutoCavtotal());
		ind.setCavAtivas(dwConsol.getQtAutoCavativas());

		
		ind.setTempoParadaMtbf(dwConsol.getSegAutoTempoparadamtbf());

		ind.setTempoParadaPao(dwConsol.getSegAutoTempoparadapao());
		ind.setTempoParadaPa(dwConsol.getSegAutoTempoparadapa());
		ind.setTempoParadaPtp(dwConsol.getSegAutoTempoparadaptp());
		ind.setTempoParadaScp(dwConsol.getSegAutoTempoparadascp());
		ind.setTempoParadaMdo(dwConsol.getSegAutoTempoparadamdo());
		ind.setTempoParadaFds(dwConsol.getSegAutoTempoparadafds());
		ind.setTempoParadaImprev(dwConsol.getSegAutoTempoparadaimprev());
		ind.setTempoParadaPrev(dwConsol.getSegAutoTempoparadaprev());
		ind.setTempoParadaPp(dwConsol.getSegAutoTempoparadapp());
		ind.setTempoParadaRegulagem(dwConsol.getSegAutoTempoparadaregulagem());
		ind.setTempoParadaDefault(dwConsol.getSegAutoTempoparadaDefault());		
		ind.setTempoParadaSemOp(dwConsol.getSegAutoTempoparadaSemOp());
		ind.setTempoParadaSemEvt(dwConsol.getSegAutoTempoparadaSemEvt());
		ind.setTempoParadaSemCnx(dwConsol.getSegAutoTempoparadaSemCnx());	
		ind.setPesoBruto(dwConsol.getGAutoPesoBruto());
		ind.setPesoLiquido(dwConsol.getGAutoPesoLiquido());
		ind.setTempoParadaAb(dwConsol.getSegAutoTempoparadaAb());		
		ind.setQtParadaMtbf(dwConsol.getQtAutoOcoparadamtbf());

		ind.setQtParadaPao(dwConsol.getQtAutoOcoparadapao());
		ind.setQtParadaPa(dwConsol.getQtAutoOcoparadapa());
		ind.setQtParadaPtp(dwConsol.getQtAutoOcoparadaptp());
		ind.setQtParadaScp(dwConsol.getQtAutoOcoparadascp());
		ind.setQtParadaMdo(dwConsol.getQtAutoOcoparadamdo());
		ind.setQtParadaFds(dwConsol.getQtAutoOcoparadafds());
		ind.setQtParadaImprev(dwConsol.getQtAutoOcoparadaimprev());
		ind.setQtParadaPrev(dwConsol.getQtAutoOcoparadaprev());
		ind.setQtParadaPp(dwConsol.getQtAutoOcoparadapp());
		ind.setQtParadaRegulagem(dwConsol.getQtAutoOcoparadaregulagem());
		ind.setQtParadaDefault(dwConsol.getQtAutoTempoparadaDefault());
		ind.setQtParadaSemOp(dwConsol.getQtAutoTempoparadaSemOp());
		ind.setQtParadaSemEvt(dwConsol.getQtAutoTempoparadaSemEvt());
		ind.setQtParadaSemCnx(dwConsol.getQtAutoTempoparadaSemCnx());	
		
		ind.calcularDados(1, omcfg,  dwConsolid.getOmPt());
		
		return ind;
	}
	
	public static IndicadoresDTO newInstance(DwConsolid dwConsolid, OmCfg omcfg, DAOGenerico dao, boolean isGargalosAgrupados){
		IndicadoresDTO ind = new IndicadoresDTO();
		
		DwConsol dwConsol = dwConsolid.getDwConsols().iterator().next();
		
		if( dwConsolid != null ){
			if(dwConsolid.getPpCp() != null){
				ind.setProducaoPlanejada(new BigDecimal(dwConsolid.getPpCp().getQtPecasProduzir()));
				ind.setCdCp(dwConsolid.getPpCp().getCdCp());
			}
		
			if(DwConsolidTemplate.TpId.HORA.equals(dwConsolid.getTpId())){
				ind.setDtHrIPeriodo(dwConsolid.getDthrIhora());
				ind.setDtHrFPeriodo(dwConsolid.getDthrFhora());
			}else if(DwConsolidTemplate.TpId.TURNO.equals(dwConsolid.getTpId())){
				ind.setDtHrIPeriodo(dwConsolid.getDthrIturno());
				ind.setDtHrFPeriodo(dwConsolid.getDthrFturno());			
			}else{
				ind.setDtHrIPeriodo(dwConsolid.getDthrIconsol());
				ind.setDtHrFPeriodo(dwConsolid.getDthrFconsol());				
			}			
			
			ind.setDtHrIConsol(dwConsolid.getDthrIconsol());
			ind.setDtHrFConsol(dwConsolid.getDthrFconsol());
			
			// Guarda o �ltimo ciclo
			if(dwConsolid.getDwRt() != null){
				if (IdwFacade.IS_IDW_ATIVO) {
					DwRt dwRt = dwConsolid.getDwRt();				
					ind.setUltimoCiclo(dwRt.getSegUltimociclo());					
				} else {
					DetalheMonitorizacaoPTInjetRN rn = new DetalheMonitorizacaoPTInjetRN();
					rn.getDao().iniciaSessao();
					ind.setUltimoCiclo(rn.pegaUltimoCiclo(dwConsolid.getOmPt(), dwConsolid.getPpCp()));
					rn.getDao().finalizaSessao();
				}
			}			

			if(dwConsolid.getOmPt() != null){
				//190423 ind.setCdPt(dwConsolid.getOmPt().getCdPt());
				ind.setCdPt( dwConsolid.getOmPt().getOmTppt().getCdTppt() );//190423
				
				
				//190513..
				//190513 - devido a questao de simplificacao do tipopt para todas as maquinas em IAC (usando mesmo 'SMD' para tudo).
				if(dwConsolid.getOmPt().getCdPt()!=null){
					if ( ( dwConsolid.getOmPt().getCdPt() ).length()<=1 ){
						ind.setCdPt( ind.getCdPt() + "-" +  dwConsolid.getOmPt().getCdPt().charAt(0) );
					}
					if ( ( dwConsolid.getOmPt().getCdPt() ).length()>=2 ){
						ind.setCdPt( ind.getCdPt() + "-" +  dwConsolid.getOmPt().getCdPt().charAt(0) );
						ind.setCdPt( ind.getCdPt() +  dwConsolid.getOmPt().getCdPt().charAt(1) );
					}
				}
				//190513.
				
			}
		}
		
		ind.setProducaoPrevista(AritmeticaUtil.somar(dwConsol.getPcsAutoProducaoprevista(), dwConsol.getPcsManuProducaoprevista()));
		ind.setProducaoRefugada(dwConsol.getPcsProducaoRefugada());
		
		ind.setProducaoBruta(dwConsol.getPcsProducaoBruta());
		ind.setProducaoLiquida(dwConsol.getPcsProducaoLiquida());
		ind.setPerdaCavidade(AritmeticaUtil.somar(dwConsol.getPcsAutoPerdacavidades(), dwConsol.getPcsManuPerdacavidades()));
		ind.setPerdaParada(dwConsol.getPcsAutoPerdaparadaCp());
		ind.setPerdaCiclo(dwConsol.getPcsAutoPerdaciclo());
	
		//Marcos Sardinha: 2017-09-01 >> Defeito #4540 >> tempo produtivo bichado
		//ind.setTempoProdutivo(AritmeticaUtil.somar(dwConsol.getSegAutoTempoprodutivo(), dwConsol.getSegManuTempoprodutivo()));
		BigDecimal qtCicloprodutivo = AritmeticaUtil.somar(dwConsol.getQtAutoCicloprodutivo() == null ? BigDecimal.ZERO : dwConsol.getQtAutoCicloprodutivo() , 
		    	 										 dwConsol.getQtManuCicloprodutivo() == null ? BigDecimal.ZERO : dwConsol.getQtManuCicloprodutivo());		
		BigDecimal segCicloProdutivo = AritmeticaUtil.somar(dwConsol.getSegAutoCicloprodutivo() == null ? BigDecimal.ZERO : dwConsol.getSegAutoCicloprodutivo() , 
													    	dwConsol.getSegManuCicloprodutivo() == null ? BigDecimal.ZERO : dwConsol.getSegManuCicloprodutivo());
		BigDecimal segTempoParadaComPesoVariacaoRitmo = AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadaCpVr() == null ? BigDecimal.ZERO : dwConsol.getSegAutoTempoparadaCpVr() , 
																			 dwConsol.getSegManuTempoparadaCpVr() == null ? BigDecimal.ZERO : dwConsol.getSegManuTempoparadaCpVr());
		BigDecimal segTempoParadaSemPesoVariacaoRitmo = AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadaSpVr() == null ? BigDecimal.ZERO : dwConsol.getSegAutoTempoparadaSpVr(), 
		    	 															 dwConsol.getSegManuTempoparadaSpVr() == null ? BigDecimal.ZERO : dwConsol.getSegManuTempoparadaSpVr());
		
		BigDecimal segTemporefugado = FormulasInjet.calcularTempoRefugoComBaseNoCiclo(ind.getProducaoBruta(), ind.getProducaoRefugada(), segCicloProdutivo);

		BigDecimal segBoas = FormulasInjet.calcularTempoBoas(segCicloProdutivo, segTemporefugado, segTempoParadaComPesoVariacaoRitmo, segTempoParadaSemPesoVariacaoRitmo);
		BigDecimal segRitmo = FormulasInjet.calcularRitmo(segCicloProdutivo, qtCicloprodutivo, dwConsol.getSegAutoCiclopadrao() , segTempoParadaComPesoVariacaoRitmo, segTempoParadaSemPesoVariacaoRitmo);
		BigDecimal horasProdutivas = FormulasInjet.calcularTempoprodutivas(segBoas, BigDecimal.ZERO, segRitmo);
		ind.setTempoProdutivo(horasProdutivas);
		
		IndicadorCicloMedioRN cmRN = new IndicadorCicloMedioRN(omcfg, dwConsolid.getOmPt(), dwConsol.getSegAutoCicloprodutivo(), dwConsol.getQtAutoCicloprodutivo(), dwConsol.getSegAutoTempoparadaSp());
		ind.setCicloMedio(cmRN.calcularCicloMedio());
		
		ind.setTempoAtivo(dwConsol.getSegAutoTempoativo());
		
		
		ind.setRitmo(dwConsol.getSegAutoRitmo());  
		ind.setTempoRefugado(dwConsol.getSegAutoTemporefugadas());
		ind.setTempoTrabalhado(dwConsol.getSegAutoTempotrabalhado());
		ind.setTempoCicloImprodutivo(dwConsol.getSegAutoCicloimprodutivo());
		ind.setTempoCicloProdutivo(dwConsol.getSegAutoCicloprodutivo());
		//TODO aguardar getSegAutoCicloregulagem() ser criado  
		//ind.setTempoCicloRegulagem(dwConsol.getSegAutoCicloregulagem());		
		ind.setQtCicloRegulagem(dwConsol.getQtAutoCicloregulagem());
		ind.setQtCicloImprodutivo(dwConsol.getQtAutoCicloimprodutivo());
		ind.setQtCicloProdutivo(dwConsol.getQtAutoCicloprodutivo());	
		ind.setTempoParadaCp(dwConsol.getSegAutoTempoparadaCp());
		ind.setTempoParadaSp(dwConsol.getSegAutoTempoparadaSp());

		List<DwConsolid> consolids = new ArrayList<>();
		consolids.add(dwConsolid);
		
		if (ind.getPerdaParada() == null)
			ind.setPerdaParada(BigDecimal.ZERO);

		ind.setTempoParadaCpVr(dwConsol.getSegAutoTempoparadaCpVr());
		ind.setTempoParadaSpVr(dwConsol.getSegAutoTempoparadaSpVr());
			
		ind.setCicloPadrao(dwConsol.getSegAutoCiclopadrao());
		ind.setTempoPerdaCavidade(dwConsol.getPcsAutoPerdacavidades());
		ind.setTempoBoas(dwConsol.getSegAutoBoas());
		ind.setTempoRefugadas(dwConsol.getSegAutoTemporefugadas());
		ind.setTempoAlerta(dwConsol.getSegAutoTempoalerta());
		
		//Marcos Sardinha: 2017-09-05 >> Defeito #4552
		//ind.setCavTotal(dwConsol.getPcsAutoCavTotal());
		//ind.setCavAtivas(dwConsol.getPcsAutoCavAtivas());
		ind.setCavTotal(dwConsol.getQtAutoCavtotal());
		ind.setCavAtivas(dwConsol.getQtAutoCavativas());

		
		ind.setTempoParadaMtbf(dwConsol.getSegAutoTempoparadamtbf());

		ind.setTempoParadaPao(dwConsol.getSegAutoTempoparadapao());
		ind.setTempoParadaPa(dwConsol.getSegAutoTempoparadapa());
		ind.setTempoParadaPtp(dwConsol.getSegAutoTempoparadaptp());
		ind.setTempoParadaScp(dwConsol.getSegAutoTempoparadascp());
		ind.setTempoParadaMdo(dwConsol.getSegAutoTempoparadamdo());
		ind.setTempoParadaFds(dwConsol.getSegAutoTempoparadafds());
		ind.setTempoParadaImprev(dwConsol.getSegAutoTempoparadaimprev());
		ind.setTempoParadaPrev(dwConsol.getSegAutoTempoparadaprev());
		ind.setTempoParadaPp(dwConsol.getSegAutoTempoparadapp());
		ind.setTempoParadaRegulagem(dwConsol.getSegAutoTempoparadaregulagem());
		ind.setTempoParadaDefault(dwConsol.getSegAutoTempoparadaDefault());		
		ind.setTempoParadaSemOp(dwConsol.getSegAutoTempoparadaSemOp());
		ind.setTempoParadaSemEvt(dwConsol.getSegAutoTempoparadaSemEvt());
		ind.setTempoParadaSemCnx(dwConsol.getSegAutoTempoparadaSemCnx());	
		ind.setPesoBruto(dwConsol.getGAutoPesoBruto());
		ind.setPesoLiquido(dwConsol.getGAutoPesoLiquido());
		ind.setTempoParadaAb(dwConsol.getSegAutoTempoparadaAb());		
		ind.setQtParadaMtbf(dwConsol.getQtAutoOcoparadamtbf());

		ind.setQtParadaPao(dwConsol.getQtAutoOcoparadapao());
		ind.setQtParadaPa(dwConsol.getQtAutoOcoparadapa());
		ind.setQtParadaPtp(dwConsol.getQtAutoOcoparadaptp());
		ind.setQtParadaScp(dwConsol.getQtAutoOcoparadascp());
		ind.setQtParadaMdo(dwConsol.getQtAutoOcoparadamdo());
		ind.setQtParadaFds(dwConsol.getQtAutoOcoparadafds());
		ind.setQtParadaImprev(dwConsol.getQtAutoOcoparadaimprev());
		ind.setQtParadaPrev(dwConsol.getQtAutoOcoparadaprev());
		ind.setQtParadaPp(dwConsol.getQtAutoOcoparadapp());
		ind.setQtParadaRegulagem(dwConsol.getQtAutoOcoparadaregulagem());
		ind.setQtParadaDefault(dwConsol.getQtAutoTempoparadaDefault());
		ind.setQtParadaSemOp(dwConsol.getQtAutoTempoparadaSemOp());
		ind.setQtParadaSemEvt(dwConsol.getQtAutoTempoparadaSemEvt());
		ind.setQtParadaSemCnx(dwConsol.getQtAutoTempoparadaSemCnx());	

		ind.calcularDados(1, omcfg,  dwConsolid.getOmPt(), true);

		return ind;
	}
	
	
	
	
	@Override
	protected IndicadoresDTO atribuir(IndicadoresDTO from, IndicadoresDTO to,
			boolean isCopiarFK) {
		
		to.setCdCp(from.getCdCp());		
		to.setCdPt(from.getCdPt());
		to.setIndiceCavidadesAtivas(from.getIndiceCavidadesAtivas());
		to.setEficienciaCiclo(from.getEficienciaCiclo());
		to.setEficienciaRealizacao(from.getEficienciaRealizacao());
		to.setIndicePerda(from.getIndicePerda());
		to.setIndiceParada(from.getIndiceParada());
		to.setIndiceRefugo(from.getIndiceRefugo());
		to.setOee(from.getOee());
		to.setProducaoPlanejada(from.getProducaoPlanejada());
		to.setProducaoPlanejadaMedia(from.getProducaoPlanejadaMedia());
		to.setProducaoPrevista(from.getProducaoPrevista());
		to.setProducaoRefugada(from.getProducaoRefugada());
		to.setProducaoBruta(from.getProducaoBruta());
		to.setProducaoLiquida(from.getProducaoLiquida());
		to.setPerdaCavidade(from.getPerdaCavidade());
		to.setPerdaParada(from.getPerdaParada());
		to.setPerdaCiclo(from.getPerdaCiclo());
		to.setPerdaTotal(from.getPerdaTotal());
		to.setTempoProdutivo(from.getTempoProdutivo());
		to.setCicloMedio(from.getCicloMedio());	
		to.setRitmo(from.getRitmo());  
		to.setTempoRefugado(from.getTempoRefugado());
		to.setTempoTrabalhado(from.getTempoTrabalhado());
		to.setTempoCicloImprodutivo(from.getTempoCicloImprodutivo());
		to.setTempoCicloProdutivo(from.getTempoCicloProdutivo());
		to.setTempoCicloRegulagem(from.getTempoCicloRegulagem());
		to.setQtCicloRegulagem(from.getQtCicloRegulagem());
		to.setQtCicloImprodutivo(from.getQtCicloImprodutivo());
		to.setQtCicloProdutivo(from.getQtCicloProdutivo());	
		to.setTempoParadaCp(from.getTempoParadaCp());
		to.setTempoParadaSp(from.getTempoParadaSp());
		to.setTempoAtivo(from.getTempoAtivo());
		to.setCicloPadraoMedio(from.getCicloPadraoMedio());
		to.setCicloPadrao(from.getCicloPadrao());
		to.setTempoPerdaCavidade(from.getTempoPerdaCavidade());
		to.setTempoBoas(from.getTempoBoas());
		to.setTempoRefugadas(from.getTempoRefugadas());
		to.setTempoAlerta(from.getTempoAlerta());
		to.setCavTotal(from.getCavTotal());
		to.setCavAtivas(from.getCavAtivas());
		to.setTempoParadaMtbf(from.getTempoParadaMtbf());

		to.setTempoParadaPao(from.getTempoParadaPao());
		to.setTempoParadaPa(from.getTempoParadaPa());
		to.setTempoParadaPtp(from.getTempoParadaPtp());
		to.setTempoParadaScp(from.getTempoParadaScp());
		to.setTempoParadaMdo(from.getTempoParadaMdo());
		to.setTempoParadaFds(from.getTempoParadaFds());
		to.setTempoParadaImprev(from.getTempoParadaImprev());
		to.setTempoParadaPrev(from.getTempoParadaImprev());
		to.setTempoParadaPp(from.getTempoParadaPp());
		to.setTempoParadaRegulagem(from.getTempoParadaRegulagem());
		to.setTempoParadaDefault(from.getTempoParadaDefault());
		to.setTempoParadaSemOp(from.getTempoParadaSemOp());
		to.setTempoParadaSemEvt(from.getTempoParadaSemEvt());
		to.setTempoParadaSemCnx(from.getTempoParadaSemCnx());	
		to.setPesoBruto(from.getPesoBruto());
		to.setPesoLiquido(from.getPesoLiquido());
		to.setTempoParadaAb(from.getTempoParadaAb());
		to.setQtParadaMtbf(from.getQtParadaMtbf());
		to.setQtParadaMttr(from.getQtParadaMttr());
		to.setQtParadaPao(from.getQtParadaPao());
		to.setQtParadaPa(from.getQtParadaPa());
		to.setQtParadaPtp(from.getQtParadaPtp());
		to.setQtParadaScp(from.getQtParadaScp());
		to.setQtParadaMdo(from.getQtParadaMdo());
		to.setQtParadaFds(from.getQtParadaFds());
		to.setQtParadaImprev(from.getQtParadaImprev());
		to.setQtParadaPrev(from.getQtParadaPrev());
		to.setQtParadaPp(from.getQtParadaPp());
		to.setQtParadaRegulagem(from.getQtParadaRegulagem());
		to.setQtParadaDefault(from.getQtParadaDefault());
		to.setQtParadaSemOp(from.getQtParadaSemOp());
		to.setQtParadaSemEvt(from.getQtParadaSemEvt());
		to.setQtParadaSemCnx(from.getQtParadaSemCnx());	
		to.setUltimoCiclo(from.getUltimoCiclo());
		to.setDtHrIPeriodo(from.getDtHrIPeriodo());
		to.setDtHrFPeriodo(from.getDtHrFPeriodo());
		to.setDtHrIConsol(from.getDtHrIConsol());
		to.setDtHrFConsol(from.getDtHrFConsol());
		to.setTempoPeriodo(from.getTempoPeriodo());
		to.setTempoTotal(from.getTempoTotal());
		to.setITO(from.getITO());	
		to.setIDO(from.getIDO());	
		to.setIPA(from.getIPA());
		to.setOee(from.getOee());
		to.setIndiceProducao(from.getIndiceProducao());
		to.setQtAgrupCicloPadrao(from.getQtAgrupCicloPadrao());
		to.setQtAgrupProducaoPlanejada(from.getQtAgrupProducaoPlanejada());
		to.setEficienciaInstantanea(from.getEficienciaInstantanea());
		to.setCavAtivasMedia(from.getCavAtivasMedia());
		to.setCavTotalMedia(from.getCavTotalMedia());
		return to;
	}
	
	
	
	/**
	 * Calcula os indicadores 
	 * TODO milton - elaborar regra para c�lculo de efici�ncia instantanea para grupo de m�quina
	 * @param totalMaquinas
	 */
	private void calcularDados(int totalMaquinas, OmCfg omcfg, OmPt ompt){
		
		this.setCavAtivas(ObjectUtils.defaultIfNull(this.getCavAtivas(), BigDecimal.ZERO));
		this.setCavAtivasMedia(ObjectUtils.defaultIfNull(this.getCavAtivas(), BigDecimal.ZERO));
		this.setQtCicloProdutivo(ObjectUtils.defaultIfNull(this.getQtCicloProdutivo(),BigDecimal.ZERO));
		this.setCavTotal(ObjectUtils.defaultIfNull(this.getCavTotal(), BigDecimal.ZERO));
		this.setCavTotalMedia(ObjectUtils.defaultIfNull(this.getCavTotal(), BigDecimal.ZERO));
		this.setCicloPadraoMedio(ObjectUtils.defaultIfNull(this.getCicloPadraoMedio(), BigDecimal.ONE));
		this.setCicloMedio(ObjectUtils.defaultIfNull(this.getCicloMedio(), BigDecimal.ZERO));
		this.setITO(BigDecimal.ZERO);
		this.setIDO(BigDecimal.ZERO);
		this.setIPA(BigDecimal.ZERO);
		this.setProducaoBruta(ObjectUtils.defaultIfNull(this.getProducaoBruta(), BigDecimal.ZERO));
		this.setProducaoRefugada(ObjectUtils.defaultIfNull(this.getProducaoRefugada(), BigDecimal.ZERO));
		
		this.setProducaoLiquida(ObjectUtils.defaultIfNull(this.getProducaoLiquida(), BigDecimal.ZERO));
		
		
		//Marcos Sardinha: 2017-09-05 >> Defeito #4552
		
		/*
		if(this.getQtCicloProdutivo().compareTo(BigDecimal.ZERO) == 1){		
			this.setCavAtivasMedia(Util.getBigDecimalDefault(this.getCavAtivas().divide(this.getQtCicloProdutivo(), MathContext.DECIMAL32)));
			this.setCavTotalMedia(Util.getBigDecimalDefault(this.getCavTotal().divide(this.getQtCicloProdutivo(), MathContext.DECIMAL32)));
		}
		*/
		
		IndicadorCicloMedioRN cmRN = new IndicadorCicloMedioRN(omcfg, ompt, this.getTempoCicloProdutivo(), this.getQtCicloProdutivo(), this.getTempoParadaSp());
		this.setCicloMedio(cmRN.calcularCicloMedio());
			
		if(this.getQtAgrupCicloPadrao() > 0 ){
			this.setCicloPadraoMedio(this.getCicloPadraoMedio().divide(new BigDecimal(this.getQtAgrupCicloPadrao()), MathContext.DECIMAL32));
		}
		if(this.getQtAgrupProducaoPlanejada() > 0){
			this.setProducaoPlanejadaMedia(this.getProducaoPlanejada().divide(new BigDecimal(this.getQtAgrupProducaoPlanejada()), MathContext.DECIMAL32));
		}
		
		this.setIndiceProducao(Util.newInstanceBigDecimal(FormulasInjet.calcularIndiceProducaoDaOP(this.getProducaoLiquida(), this.getProducaoPlanejada())));
		
		this.setTempoAtivo(this.getTempoAtivo());
		this.setTempoTotal(Util.newInstanceBigDecimal(FormulasInjet.calcularTempoTotal(this.getTempoParadaSp(), this.getTempoAtivo())));
		this.setProducaoPrevista(this.getProducaoPrevista());
		this.setIndicePerda(Util.newInstanceBigDecimal(FormulasInjet.calcularIndicePerda(
					this.getPerdaTotal(), this.getProducaoPrevista())));
		this.setOee(Util.newInstanceBigDecimal(FormulasInjet.calcularOEE(this.getTempoProdutivo(), this.getTempoAtivo())));
		this.setIndiceParada(Util.newInstanceBigDecimal(FormulasInjet.calcularIndiceParada(this.getTempoParadaCp(), this.getTempoAtivo())));
		this.setEficienciaCiclo(Util.newInstanceBigDecimal(FormulasInjet.calcularEficienciaCiclo(this.getCicloPadrao(), this.getCicloMedio())));
		this.setEficienciaRealizacao(Util.newInstanceBigDecimal(FormulasInjet.calcularEficienciaRealizacao(this.getProducaoLiquida(), this.getProducaoPrevista())));		
		this.setIndiceRefugo(Util.newInstanceBigDecimal(FormulasInjet.calcularIndiceRefugo(this.getProducaoRefugada(), this.getProducaoBruta())));
		
		
		if(this.getCavTotal() != null ){
			if(this.getCavTotal().compareTo(this.getCavAtivas()) >= 0){
				this.setIndiceCavidadesAtivas(Util.getBigDecimalDefault(
						FormulasInjet.calcularIndicePcsPorCicloAtivas(this.getCavTotal(), this.getCavAtivas())));
			}else{
				this.setIndiceCavidadesAtivas(BigDecimal.ZERO);
			}
		}else{
			this.setIndiceCavidadesAtivas(BigDecimal.ZERO);
		}
		
		if(this.getDtHrIPeriodo() != null && this.getDtHrFPeriodo() != null){
			this.setTempoPeriodo(Util.newInstanceBigDecimal(DataHoraRN.getQuantidadeSegundosNoPeriodo(this.getDtHrIPeriodo(), this.getDtHrFPeriodo())).multiply(new BigDecimal(totalMaquinas)));
		} else{
			this.setTempoPeriodo(BigDecimal.ZERO);
		}
		
		this.setTempoTrabalhado(Util.getBigDecimalDefault(FormulasInjet.calcularTempoTrabalhado(this.getTempoAtivo(), this.getTempoParadaCp())));
		
		if(this.getTempoPeriodo() != null &&  this.getTempoPeriodo().compareTo(BigDecimal.ZERO) == 1 ){
			this.setITO(Util.getBigDecimalDefault(FormulasInjet.calcularITO(this.getTempoPeriodo(), this.getTempoParadaCp(), this.getTempoParadaSp())));
			this.setIDO(Util.getBigDecimalDefault(FormulasInjet.calcularIDO(this.getQtCicloProdutivo(), this.getCicloPadrao(), this.getTempoPeriodo(), this.getTempoParadaCp(), this.getTempoParadaSp())));
			this.setIPA(Util.getBigDecimalDefault(FormulasInjet.calcularIPA(this.getProducaoBruta(), this.getProducaoLiquida())));
		}
//		this.setOee(FormulasInjet.calcularOEE(this.getITO(), this.getIDO(), this.getIPA()));

		BigDecimal perdaCiclo = ObjectUtils.defaultIfNull(this.perdaCiclo, BigDecimal.ZERO);
		BigDecimal perdaParada = ObjectUtils.defaultIfNull(this.getPerdaParada(), BigDecimal.ZERO);
		BigDecimal producaoRefugada = ObjectUtils.defaultIfNull(this.getProducaoRefugada(), BigDecimal.ZERO);
		BigDecimal perdaCavidades = ObjectUtils.defaultIfNull(this.getPerdaCavidade(), BigDecimal.ZERO);
		
		this.setPerdaTotal(Util.newInstanceBigDecimal(
				FormulasInjet.calcularTotalPerdas(perdaCiclo.doubleValue(),perdaParada.doubleValue(), 
				producaoRefugada.doubleValue(), perdaCavidades.doubleValue())));
		
		this.setEficienciaInstantanea(Util.newInstanceBigDecimal(FormulasInjet.calcularEficienciaInstantanea(this.getCicloPadrao(), this.getUltimoCiclo())));
		
	}
	
	/**
	 * Calcula os indicadores 
	 * TODO milton - elaborar regra para c�lculo de efici�ncia instantanea para grupo de m�quina
	 * @param totalMaquinas
	 */
	private void calcularDados(int totalMaquinas, OmCfg omcfg, OmPt ompt, boolean isGargalosAgrupados){
		
		this.setCavAtivas(ObjectUtils.defaultIfNull(this.getCavAtivas(), BigDecimal.ZERO));
		this.setCavAtivasMedia(ObjectUtils.defaultIfNull(this.getCavAtivas(), BigDecimal.ZERO));
		this.setQtCicloProdutivo(ObjectUtils.defaultIfNull(this.getQtCicloProdutivo(),BigDecimal.ZERO));
		this.setCavTotal(ObjectUtils.defaultIfNull(this.getCavTotal(), BigDecimal.ZERO));
		this.setCavTotalMedia(ObjectUtils.defaultIfNull(this.getCavTotal(), BigDecimal.ZERO));
		this.setCicloPadraoMedio(ObjectUtils.defaultIfNull(this.getCicloPadraoMedio(), BigDecimal.ONE));
		this.setCicloMedio(ObjectUtils.defaultIfNull(this.getCicloMedio(), BigDecimal.ZERO));
		this.setITO(BigDecimal.ZERO);
		this.setIDO(BigDecimal.ZERO);
		this.setIPA(BigDecimal.ZERO);
		this.setProducaoBruta(ObjectUtils.defaultIfNull(this.getProducaoBruta(), BigDecimal.ZERO));
		this.setProducaoRefugada(ObjectUtils.defaultIfNull(this.getProducaoRefugada(), BigDecimal.ZERO));
		
		this.setProducaoLiquida(ObjectUtils.defaultIfNull(this.getProducaoLiquida(), BigDecimal.ZERO));
		
		
		//Marcos Sardinha: 2017-09-05 >> Defeito #4552
		
		/*
		if(this.getQtCicloProdutivo().compareTo(BigDecimal.ZERO) == 1){		
			this.setCavAtivasMedia(Util.getBigDecimalDefault(this.getCavAtivas().divide(this.getQtCicloProdutivo(), MathContext.DECIMAL32)));
			this.setCavTotalMedia(Util.getBigDecimalDefault(this.getCavTotal().divide(this.getQtCicloProdutivo(), MathContext.DECIMAL32)));
		}
		*/
		
		IndicadorCicloMedioRN cmRN = new IndicadorCicloMedioRN(omcfg, ompt, this.getTempoCicloProdutivo(), this.getQtCicloProdutivo(), this.getTempoParadaSp());
		this.setCicloMedio(cmRN.calcularCicloMedio());
			
		if(this.getQtAgrupCicloPadrao() > 0 ){
			this.setCicloPadraoMedio(this.getCicloPadraoMedio().divide(new BigDecimal(this.getQtAgrupCicloPadrao()), MathContext.DECIMAL32));
		}
		if(this.getQtAgrupProducaoPlanejada() > 0){
			this.setProducaoPlanejadaMedia(this.getProducaoPlanejada().divide(new BigDecimal(this.getQtAgrupProducaoPlanejada()), MathContext.DECIMAL32));
		}
		
		this.setIndiceProducao(Util.newInstanceBigDecimal(FormulasInjet.calcularIndiceProducaoDaOP(this.getProducaoLiquida(), this.getProducaoPlanejada())));
		
		this.setTempoAtivo(this.getTempoAtivo());
		this.setTempoTotal(Util.newInstanceBigDecimal(FormulasInjet.calcularTempoTotal(this.getTempoParadaSp(), this.getTempoAtivo())));
		this.setProducaoPrevista(this.getProducaoPrevista());
		this.setIndicePerda(Util.newInstanceBigDecimal(FormulasInjet.calcularIndicePerda(
					this.getPerdaTotal(), this.getProducaoPrevista())));
		this.setOee(Util.newInstanceBigDecimal(FormulasInjet.calcularOEE(this.getTempoProdutivo(), this.getTempoAtivo())));
		this.setIndiceParada(Util.newInstanceBigDecimal(FormulasInjet.calcularIndiceParada(this.getTempoParadaCp(), this.getTempoAtivo())));
		this.setEficienciaCiclo(Util.newInstanceBigDecimal(FormulasInjet.calcularEficienciaCiclo(this.getCicloPadrao(), this.getCicloMedio())));
		this.setEficienciaRealizacao(Util.newInstanceBigDecimal(FormulasInjet.calcularEficienciaRealizacao(this.getProducaoLiquida(), this.getProducaoPrevista())));		
		this.setIndiceRefugo(Util.newInstanceBigDecimal(FormulasInjet.calcularIndiceRefugo(this.getProducaoRefugada(), this.getProducaoBruta())));
		
		
		if(this.getCavTotal() != null ){
			if(this.getCavTotal().compareTo(this.getCavAtivas()) >= 0){
				this.setIndiceCavidadesAtivas(Util.getBigDecimalDefault(
						FormulasInjet.calcularIndicePcsPorCicloAtivas(this.getCavTotal(), this.getCavAtivas())));
			}else{
				this.setIndiceCavidadesAtivas(BigDecimal.ZERO);
			}
		}else{
			this.setIndiceCavidadesAtivas(BigDecimal.ZERO);
		}
		
		if(this.getDtHrIPeriodo() != null && this.getDtHrFPeriodo() != null){
			this.setTempoPeriodo(Util.newInstanceBigDecimal(DataHoraRN.getQuantidadeSegundosNoPeriodo(this.getDtHrIPeriodo(), this.getDtHrFPeriodo())).multiply(new BigDecimal(totalMaquinas)));
		} else{
			this.setTempoPeriodo(BigDecimal.ZERO);
		}
		
		this.setTempoTrabalhado(Util.getBigDecimalDefault(FormulasInjet.calcularTempoTrabalhado(this.getTempoAtivo(), this.getTempoParadaCp())));
		
		if(this.getTempoPeriodo() != null &&  this.getTempoPeriodo().compareTo(BigDecimal.ZERO) == 1 ){
			this.setITO(Util.getBigDecimalDefault(FormulasInjet.calcularITO(this.getTempoPeriodo(), this.getTempoParadaCp(), this.getTempoParadaSp())));
			this.setIDO(Util.getBigDecimalDefault(FormulasInjet.calcularIDO(this.getQtCicloProdutivo(), this.getCicloPadrao(), this.getTempoPeriodo(), this.getTempoParadaCp(), this.getTempoParadaSp())));
			this.setIPA(Util.getBigDecimalDefault(FormulasInjet.calcularIPA(this.getProducaoBruta(), this.getProducaoLiquida())));
		}
//		this.setOee(FormulasInjet.calcularOEE(this.getITO(), this.getIDO(), this.getIPA()));

		BigDecimal perdaCiclo = ObjectUtils.defaultIfNull(this.perdaCiclo, BigDecimal.ZERO);
		BigDecimal perdaParada = ObjectUtils.defaultIfNull(this.getPerdaParada(), BigDecimal.ZERO);
		BigDecimal producaoRefugada = ObjectUtils.defaultIfNull(this.getProducaoRefugada(), BigDecimal.ZERO);
		BigDecimal perdaCavidades = ObjectUtils.defaultIfNull(this.getPerdaCavidade(), BigDecimal.ZERO);
		
		this.setPerdaTotal(Util.newInstanceBigDecimal(
				FormulasInjet.calcularTotalPerdas(perdaCiclo.doubleValue(),perdaParada.doubleValue(), 
				producaoRefugada.doubleValue(), perdaCavidades.doubleValue())));
		
		//190425.INI
		//ciclo médio tratado com agrupamento, caso for:
		if(isGargalosAgrupados && this!=null && this.getQtAgrupCicloPadrao()!=0L && this.getCicloMedio()!=null && this.getQtAgrupCicloPadrao()>1L && this.getQtAgrupCicloPadrao()<=10L){
			BigDecimal bdMediaEntrePontosAgrupados = new BigDecimal(0L);
			bdMediaEntrePontosAgrupados = new BigDecimal(0L);
			bdMediaEntrePontosAgrupados =  bdMediaEntrePontosAgrupados.valueOf(this.getCicloMedio().doubleValue() /this.getQtAgrupCicloPadrao()) ;
			this.setCicloMedio(  bdMediaEntrePontosAgrupados );
		}
		//ciclo padrão médio tratado com agrupamento, caso for:
		if(isGargalosAgrupados && this!=null && this.getQtAgrupCicloPadrao()!=0L && this.getCicloPadraoMedio()!=null && this.getQtAgrupCicloPadrao()>1L && this.getQtAgrupCicloPadrao()<=10L){
			BigDecimal bdMediaEntrePontosAgrupados = new BigDecimal(0L);
			bdMediaEntrePontosAgrupados = new BigDecimal(0L);
			bdMediaEntrePontosAgrupados =  bdMediaEntrePontosAgrupados.valueOf(this.getCicloPadraoMedio().doubleValue() /this.getQtAgrupCicloPadrao()) ;
			this.setCicloPadraoMedio(  bdMediaEntrePontosAgrupados );
			this.setCicloPadrao(this.getCicloPadraoMedio());//convencionado esta atribuição
		}
		//190425.FIM


		this.setEficienciaInstantanea(Util.newInstanceBigDecimal(FormulasInjet.calcularEficienciaInstantanea(this.getCicloPadrao(), this.getUltimoCiclo())));
		
	}
	
	
	
	/**
	 * Agrupa os itens de {@code IndicadoresDTO}
	 * Itens que est�o sendo agrupados:
	 * 		Efici�ncia de Realiza��o (%)
 	 * 		Produ��o Planejada
 	 *	 	Produ��o Total
 	 * 		Perdas Totais
 	 * 		�ndice de Perdas (%)
 	 * 		Produtividade OEE (%)
 	 * 		�ndice de Paradas (%)
 	 * 		Perdas por Paradas
 	 * 		Tempo Total das Paradas
 	 * 		Efici�ncia de Ciclo (%)
 	 * 		Perdas Por Inefici�ncia de Ciclo
 	 * 		�ndice de Refugos (%)
 	 * 		Refugos
 	 * 		�ndice de Cavidades Ativas (%) 
	 * 
	 * 
	 */
	public class Agrupador{
				
		private final IndicadoresDTO indicadoresDTO;
		private IndicadoresDTO indicadoresDTOAgrupado;
		
		/** 
		 * Lista usada para guardar a quantidade planejada para o grupo Cp e Pt.
		 * <br> A principio a quantidade planejada era acumulada para cada item que passasse pelo {@link #add(IndicadoresDTO)}, mas pode ocorrer de para um mesmo per�odo (turno, hora e etc)
		 * <br> tenha mais de 1 registro, que corresponde a quebra de folha (isso ocorre em mudan�a de ciclo padr�o). Ent�o neste caso iria somar quantidade a mais para produ��o planejada.
		 * <br> Para evitar este tipo de situa��o, guarda as quantidade planejadas nesta lista, e depois soma tudo e atualiza a quantidade planejada em {@link #result(int)}
		 * <br> A cole��o usa como key, {@link #getKeyPtCp(IndicadoresDTO)} 
		 */
		private Map<String, BigDecimal> producoesPlanejadas;
		

		
		private Agrupador(IndicadoresDTO indicadoresDTO){
			this.indicadoresDTO = indicadoresDTO;
			this.indicadoresDTOAgrupado = new IndicadoresDTO();
			this.producoesPlanejadas = new HashMap<String, BigDecimal>();
		}
		
		
		
		private String getKeyPtCp(IndicadoresDTO ind){
			try{
				String cdPt = ObjectUtils.defaultIfNull(ind.getCdPt(), "");
				String cdCp = ObjectUtils.defaultIfNull(ind.getCdCp(), "");
				return new StringBuilder(cdPt).append(cdCp).toString();
			}catch(NullPointerException e){
				throw e;
			}
		}		
		private String getKeyPtCp(IndicadoresDTO ind, boolean isGargalosAgrupados){
			try{
				String cdPt = ObjectUtils.defaultIfNull(ind.getCdPt(), "");
				String cdCp = ObjectUtils.defaultIfNull(ind.getCdCp(), "");
				return new StringBuilder(cdPt).append(cdCp).toString();
			}catch(NullPointerException e){
				throw e;
			}
		}		
		
		
		
		public void reset(){
			indicadoresDTOAgrupado = new IndicadoresDTO();		
		}
		
		
		
		/**
		 * @param ind
		 * @return
		 */
		public Agrupador add(IndicadoresDTO ind){
			
			// Acumula o total planejado, agrupando por Pt e Cp
			if(ind.getProducaoPlanejada() != null && ind.getProducaoPlanejada().compareTo(BigDecimal.ZERO) == 1){
				this.producoesPlanejadas.put(getKeyPtCp(ind), ind.getProducaoPlanejada());
			}
			
			indicadoresDTOAgrupado.setProducaoPlanejada(AritmeticaUtil.somar(indicadoresDTOAgrupado.getProducaoPlanejada(), ind.getProducaoPlanejada()));
			indicadoresDTOAgrupado.setProducaoLiquida(AritmeticaUtil.somar(indicadoresDTOAgrupado.getProducaoLiquida(), ind.getProducaoLiquida()));			
			indicadoresDTOAgrupado.setProducaoPrevista(AritmeticaUtil.somar(indicadoresDTOAgrupado.getProducaoPrevista(), ind.getProducaoPrevista()));
			indicadoresDTOAgrupado.setProducaoRefugada(AritmeticaUtil.somar(indicadoresDTOAgrupado.getProducaoRefugada(), ind.getProducaoRefugada()));
			indicadoresDTOAgrupado.setProducaoBruta(AritmeticaUtil.somar(indicadoresDTOAgrupado.getProducaoBruta(), ind.getProducaoBruta()));
			indicadoresDTOAgrupado.setCicloPadraoMedio(AritmeticaUtil.somar(indicadoresDTOAgrupado.getCicloPadraoMedio(), ind.getCicloPadrao()));
			indicadoresDTOAgrupado.setPerdaCavidade(AritmeticaUtil.somar(indicadoresDTOAgrupado.getPerdaCavidade(), ind.getPerdaCavidade()));
			indicadoresDTOAgrupado.setPerdaCiclo(AritmeticaUtil.somar(indicadoresDTOAgrupado.getPerdaCiclo(), ind.getPerdaCiclo()));			
			indicadoresDTOAgrupado.setPerdaParada(AritmeticaUtil.somar(indicadoresDTOAgrupado.getPerdaParada(), ind.getPerdaParada()));
			indicadoresDTOAgrupado.setPerdaTotal(AritmeticaUtil.somar(indicadoresDTOAgrupado.getPerdaTotal(), ind.getPerdaTotal()));
			indicadoresDTOAgrupado.setTempoCicloProdutivo(AritmeticaUtil.somar(indicadoresDTOAgrupado.getTempoCicloProdutivo(), ind.getTempoCicloProdutivo()));
			indicadoresDTOAgrupado.setTempoCicloImprodutivo(AritmeticaUtil.somar(indicadoresDTOAgrupado.getTempoCicloImprodutivo(), ind.getTempoCicloImprodutivo()));
			indicadoresDTOAgrupado.setTempoAtivo(AritmeticaUtil.somar(indicadoresDTOAgrupado.getTempoAtivo(), ind.getTempoAtivo()));
			indicadoresDTOAgrupado.setQtCicloProdutivo(AritmeticaUtil.somar(indicadoresDTOAgrupado.getQtCicloProdutivo(), ind.getQtCicloProdutivo()));
			indicadoresDTOAgrupado.setCavTotal(AritmeticaUtil.somar(indicadoresDTOAgrupado.getCavTotal(), ind.getCavTotal()));
			indicadoresDTOAgrupado.setCavAtivas(AritmeticaUtil.somar(indicadoresDTOAgrupado.getCavAtivas(), ind.getCavAtivas()));
			
			// guarda �ltimo ciclo padr�o
			indicadoresDTOAgrupado.setCicloPadrao(ObjectUtils.defaultIfNull(ind.getCicloPadrao(), indicadoresDTOAgrupado.getCicloPadrao())); 
			
			indicadoresDTOAgrupado.setUltimoCiclo(ObjectUtils.defaultIfNull(ind.getUltimoCiclo(), indicadoresDTOAgrupado.getUltimoCiclo())); 
			indicadoresDTOAgrupado.setTempoParadaCp(AritmeticaUtil.somar(indicadoresDTOAgrupado.getTempoParadaCp(), ind.getTempoParadaCp()));
			indicadoresDTOAgrupado.setTempoParadaSp(AritmeticaUtil.somar(indicadoresDTOAgrupado.getTempoParadaSp(), ind.getTempoParadaSp()));
			indicadoresDTOAgrupado.setTempoAlerta(AritmeticaUtil.somar(indicadoresDTOAgrupado.getTempoAlerta(), ind.getTempoAlerta()));
			indicadoresDTOAgrupado.setTempoCicloRegulagem(AritmeticaUtil.somar(indicadoresDTOAgrupado.getTempoCicloRegulagem(), ind.getTempoCicloRegulagem()));
			indicadoresDTOAgrupado.setTempoProdutivo(AritmeticaUtil.somar(indicadoresDTOAgrupado.getTempoProdutivo(), ind.getTempoProdutivo()));
			
			// Pega o menor in�cio per�odo
			if(ObjectUtils.compare(ind.getDtHrIPeriodo(), indicadoresDTOAgrupado.getDtHrIPeriodo(), true) == -1){
				indicadoresDTOAgrupado.setDtHrIPeriodo(ind.getDtHrIPeriodo());	
			}
			
			// Pega o menor in�cio consol
			if(ObjectUtils.compare(ind.getDtHrIConsol(), indicadoresDTOAgrupado.getDtHrIConsol(), true) == -1){
				indicadoresDTOAgrupado.setDtHrIConsol(ind.getDtHrIConsol());	
			}
			
			// Pega o menor fim per�odo			
			if(ObjectUtils.compare(ind.getDtHrFPeriodo(), indicadoresDTOAgrupado.getDtHrFPeriodo(), false) == 1){
				indicadoresDTOAgrupado.setDtHrFPeriodo(ind.getDtHrFPeriodo());	
			}
			
			// Pega o menor fim consol			
			if(ObjectUtils.compare(ind.getDtHrFConsol(), indicadoresDTOAgrupado.getDtHrFConsol(), false) == 1){
				indicadoresDTOAgrupado.setDtHrFConsol(ind.getDtHrFConsol());	
			}
			
			if(ind.getCicloPadrao() != null &&  ind.getCicloPadrao().compareTo(BigDecimal.ONE) >= 1){
				indicadoresDTOAgrupado.setQtAgrupCicloPadrao(indicadoresDTOAgrupado.getQtAgrupCicloPadrao() + 1);
			}
	
			if(ind.getProducaoPlanejada() != null &&  ind.getProducaoPlanejada().compareTo(BigDecimal.ONE) >= 1){
				indicadoresDTOAgrupado.setQtAgrupProducaoPlanejada(indicadoresDTOAgrupado.getQtAgrupProducaoPlanejada() + 1);
			}
			
			return this;
		}
		public Agrupador add(IndicadoresDTO ind, boolean isGargalosAgrupados){
			
			indicadoresDTOAgrupado.setCdPt(ind.getCdPt());
			
			// Acumula o total planejado, agrupando por Pt e Cp
			if(ind.getProducaoPlanejada() != null && ind.getProducaoPlanejada().compareTo(BigDecimal.ZERO) == 1){
				this.producoesPlanejadas.put(getKeyPtCp(ind, true), ind.getProducaoPlanejada());
			}
			
			indicadoresDTOAgrupado.setProducaoPlanejada(AritmeticaUtil.somar(indicadoresDTOAgrupado.getProducaoPlanejada(), ind.getProducaoPlanejada()));
			indicadoresDTOAgrupado.setProducaoLiquida(AritmeticaUtil.somar(indicadoresDTOAgrupado.getProducaoLiquida(), ind.getProducaoLiquida()));			
			indicadoresDTOAgrupado.setProducaoPrevista(AritmeticaUtil.somar(indicadoresDTOAgrupado.getProducaoPrevista(), ind.getProducaoPrevista()));
			indicadoresDTOAgrupado.setProducaoRefugada(AritmeticaUtil.somar(indicadoresDTOAgrupado.getProducaoRefugada(), ind.getProducaoRefugada()));
			indicadoresDTOAgrupado.setProducaoBruta(AritmeticaUtil.somar(indicadoresDTOAgrupado.getProducaoBruta(), ind.getProducaoBruta()));
			indicadoresDTOAgrupado.setCicloPadraoMedio(AritmeticaUtil.somar(indicadoresDTOAgrupado.getCicloPadraoMedio(), ind.getCicloPadrao()));
			indicadoresDTOAgrupado.setPerdaCavidade(AritmeticaUtil.somar(indicadoresDTOAgrupado.getPerdaCavidade(), ind.getPerdaCavidade()));
			indicadoresDTOAgrupado.setPerdaCiclo(AritmeticaUtil.somar(indicadoresDTOAgrupado.getPerdaCiclo(), ind.getPerdaCiclo()));			
			indicadoresDTOAgrupado.setPerdaParada(AritmeticaUtil.somar(indicadoresDTOAgrupado.getPerdaParada(), ind.getPerdaParada()));
			indicadoresDTOAgrupado.setPerdaTotal(AritmeticaUtil.somar(indicadoresDTOAgrupado.getPerdaTotal(), ind.getPerdaTotal()));
			indicadoresDTOAgrupado.setTempoCicloProdutivo(AritmeticaUtil.somar(indicadoresDTOAgrupado.getTempoCicloProdutivo(), ind.getTempoCicloProdutivo()));
			indicadoresDTOAgrupado.setTempoCicloImprodutivo(AritmeticaUtil.somar(indicadoresDTOAgrupado.getTempoCicloImprodutivo(), ind.getTempoCicloImprodutivo()));
			indicadoresDTOAgrupado.setTempoAtivo(AritmeticaUtil.somar(indicadoresDTOAgrupado.getTempoAtivo(), ind.getTempoAtivo()));
			indicadoresDTOAgrupado.setQtCicloProdutivo(AritmeticaUtil.somar(indicadoresDTOAgrupado.getQtCicloProdutivo(), ind.getQtCicloProdutivo()));
			indicadoresDTOAgrupado.setCavTotal(AritmeticaUtil.somar(indicadoresDTOAgrupado.getCavTotal(), ind.getCavTotal()));
			indicadoresDTOAgrupado.setCavAtivas(AritmeticaUtil.somar(indicadoresDTOAgrupado.getCavAtivas(), ind.getCavAtivas()));
			
			// guarda �ltimo ciclo padr�o
			indicadoresDTOAgrupado.setCicloPadrao(ObjectUtils.defaultIfNull(ind.getCicloPadrao(), indicadoresDTOAgrupado.getCicloPadrao())); 
			
			indicadoresDTOAgrupado.setUltimoCiclo(ObjectUtils.defaultIfNull(ind.getUltimoCiclo(), indicadoresDTOAgrupado.getUltimoCiclo())); 
			indicadoresDTOAgrupado.setTempoParadaCp(AritmeticaUtil.somar(indicadoresDTOAgrupado.getTempoParadaCp(), ind.getTempoParadaCp()));
			indicadoresDTOAgrupado.setTempoParadaSp(AritmeticaUtil.somar(indicadoresDTOAgrupado.getTempoParadaSp(), ind.getTempoParadaSp()));
			indicadoresDTOAgrupado.setTempoAlerta(AritmeticaUtil.somar(indicadoresDTOAgrupado.getTempoAlerta(), ind.getTempoAlerta()));
			indicadoresDTOAgrupado.setTempoCicloRegulagem(AritmeticaUtil.somar(indicadoresDTOAgrupado.getTempoCicloRegulagem(), ind.getTempoCicloRegulagem()));
			indicadoresDTOAgrupado.setTempoProdutivo(AritmeticaUtil.somar(indicadoresDTOAgrupado.getTempoProdutivo(), ind.getTempoProdutivo()));
			
			// Pega o menor in�cio per�odo
			if(ObjectUtils.compare(ind.getDtHrIPeriodo(), indicadoresDTOAgrupado.getDtHrIPeriodo(), true) == -1){
				indicadoresDTOAgrupado.setDtHrIPeriodo(ind.getDtHrIPeriodo());	
			}
			
			// Pega o menor in�cio consol
			if(ObjectUtils.compare(ind.getDtHrIConsol(), indicadoresDTOAgrupado.getDtHrIConsol(), true) == -1){
				indicadoresDTOAgrupado.setDtHrIConsol(ind.getDtHrIConsol());	
			}
			
			// Pega o menor fim per�odo			
			if(ObjectUtils.compare(ind.getDtHrFPeriodo(), indicadoresDTOAgrupado.getDtHrFPeriodo(), false) == 1){
				indicadoresDTOAgrupado.setDtHrFPeriodo(ind.getDtHrFPeriodo());	
			}
			
			// Pega o menor fim consol			
			if(ObjectUtils.compare(ind.getDtHrFConsol(), indicadoresDTOAgrupado.getDtHrFConsol(), false) == 1){
				indicadoresDTOAgrupado.setDtHrFConsol(ind.getDtHrFConsol());	
			}
			
			if(ind.getCicloPadrao() != null &&  ind.getCicloPadrao().compareTo(BigDecimal.ONE) >= 1){
				indicadoresDTOAgrupado.setQtAgrupCicloPadrao(indicadoresDTOAgrupado.getQtAgrupCicloPadrao() + 1);
			}
	
			if(ind.getProducaoPlanejada() != null &&  ind.getProducaoPlanejada().compareTo(BigDecimal.ONE) >= 1){
				indicadoresDTOAgrupado.setQtAgrupProducaoPlanejada(indicadoresDTOAgrupado.getQtAgrupProducaoPlanejada() + 1);
			}
			
			return this;
		}
		
		
		
		
		public Agrupador add(DwConsolid dwConsolid, OmCfg omcfg, DAOGenerico dao){
			this.add(IndicadoresDTO.newInstance(dwConsolid, omcfg, dao));
			return this;
		}
		public Agrupador add(DwConsolid dwConsolid, OmCfg omcfg, DAOGenerico dao, boolean isGargalosAgrupados){
			this.add(IndicadoresDTO.newInstance(dwConsolid, omcfg, dao, true));
			return this;
		}
		
		
		
		
		public Agrupador add(List<DwConsolid> listaDwConsolid, OmCfg omcfg, DAOGenerico dao){
			for(DwConsolid dwConsolid: listaDwConsolid){
				this.add(dwConsolid, omcfg, dao);
			}
			return this;
		}
		public Agrupador add(List<DwConsolid> listaDwConsolid, OmCfg omcfg, DAOGenerico dao, boolean isGargalosAgrupados){
			for(DwConsolid dwConsolid: listaDwConsolid){
				this.add(dwConsolid, omcfg, dao, true);
			}
			return this;
		}
		
		
		
		
		public IndicadoresDTO result(OmCfg omcfg, OmPt ompt){
			return result(1, omcfg, ompt);
		}
		public IndicadoresDTO result(OmCfg omcfg, OmPt ompt, boolean isGargalosAgrupados){
			return result(1, omcfg, ompt, true);
		}
		
		
		
		/**
	 	 *	Resultado do agrupamento de dados 
	 	 */			
		public IndicadoresDTO result(int totalMaquinas, OmCfg omcfg, OmPt ompt){
			
			// guarda a quantidade planejada
			BigDecimal totalPlanejado = BigDecimal.ZERO;
			for(BigDecimal producaoPlanejada: this.producoesPlanejadas.values()){
				totalPlanejado = totalPlanejado.add(producaoPlanejada);
			}
			
//	trecho abaixo s� era usado como debug para visualizar as quantidade planejadas, nas duas formas de acumula��o			
//			if(new EqualsBuilderIdw().append(indicadoresDTOAgrupado.getProducaoPlanejada(), totalPlanejado).isEquals() == false){
//				//System.out.println("indicadoresDTOAgrupado.getProducaoPlanejada() = " + indicadoresDTOAgrupado.getProducaoPlanejada() +
//						"  totalPlanejado = " + totalPlanejado);
//			}
			
			indicadoresDTOAgrupado.setProducaoPlanejada(totalPlanejado);
						
			indicadoresDTOAgrupado.calcularDados(totalMaquinas, omcfg, ompt);
			
			return indicadoresDTOAgrupado;
		}
		public IndicadoresDTO result(int totalMaquinas, OmCfg omcfg, OmPt ompt, boolean isGargalosAgrupados){
			
			// guarda a quantidade planejada
			BigDecimal totalPlanejado = BigDecimal.ZERO;
			for(BigDecimal producaoPlanejada: this.producoesPlanejadas.values()){
				totalPlanejado = totalPlanejado.add(producaoPlanejada);
			}
			
//	trecho abaixo s� era usado como debug para visualizar as quantidade planejadas, nas duas formas de acumula��o			
//			if(new EqualsBuilderIdw().append(indicadoresDTOAgrupado.getProducaoPlanejada(), totalPlanejado).isEquals() == false){
//				//System.out.println("indicadoresDTOAgrupado.getProducaoPlanejada() = " + indicadoresDTOAgrupado.getProducaoPlanejada() +
//						"  totalPlanejado = " + totalPlanejado);
//			}
			
			indicadoresDTOAgrupado.setProducaoPlanejada(totalPlanejado);
						
			indicadoresDTOAgrupado.calcularDados(totalMaquinas, omcfg, ompt, true);
			
			return indicadoresDTOAgrupado;
		}
		
		
		
		public void resultMerge(OmCfg omcfg, OmPt ompt){
			resultMerge(1, omcfg, ompt);
		}
		public void resultMerge(OmCfg omcfg, OmPt ompt, boolean isGargalosAgrupados){
			resultMerge(1, omcfg, ompt, true);
		}
		
		
		
		/**
		 * Mesma o resulta com o {@code IndicadoresDTO} do agrupador
		 */
		public void resultMerge(int totalMaquinas, OmCfg omcfg, OmPt ompt){
			IndicadoresDTO result = this.result(totalMaquinas, omcfg, ompt);
			this.indicadoresDTO.copy(result, false);
		}
		public void resultMerge(int totalMaquinas, OmCfg omcfg, OmPt ompt, boolean isGargalosAgrupados){
			IndicadoresDTO result = this.result(totalMaquinas, omcfg, ompt, true);
			this.indicadoresDTO.copy(result, false);
		}
		
		
	}
	
	public BigDecimal getPerdaParada() {
		return perdaParada;
	}


	public void setPerdaParada(BigDecimal perdaParada) {
		this.perdaParada = perdaParada;
	}

	public BigDecimal getPerdaTotal() {
		return perdaTotal;
	}


	public void setPerdaTotal(BigDecimal perdaTotal) {
		this.perdaTotal = perdaTotal;
	}
	
	public BigDecimal getOee() {
		return oee;
	}
	public void setOee(BigDecimal oee) {
		this.oee = oee;
	}
	public BigDecimal getProducaoPlanejada() {
		return producaoPlanejada;
	}
	public void setProducaoPlanejada(BigDecimal producaoPlanejada) {
		this.producaoPlanejada = producaoPlanejada;
	}
	public BigDecimal getProducaoPlanejadaMedia() {
		return producaoPlanejadaMedia;
	}
	public void setProducaoPlanejadaMedia(BigDecimal producaoPlanejadaMedia) {
		this.producaoPlanejadaMedia = producaoPlanejadaMedia;
	}	
	public BigDecimal getProducaoPrevista() {
		return producaoPrevista;
	}
	public void setProducaoPrevista(BigDecimal producaoPrevista) {
		this.producaoPrevista = producaoPrevista;
	}
	public BigDecimal getProducaoRefugada() {
		return producaoRefugada;
	}
	public void setProducaoRefugada(BigDecimal producaoRefugada) {
		this.producaoRefugada = producaoRefugada;
	}
	public BigDecimal getProducaoBruta() {
		return producaoBruta;
	}
	public void setProducaoBruta(BigDecimal producaoBruta) {
		this.producaoBruta = producaoBruta;
	}
	public BigDecimal getProducaoLiquida() {
		return producaoLiquida;
	}
	public void setProducaoLiquida(BigDecimal producaoLiquida) {
		this.producaoLiquida = producaoLiquida;
	}
	public BigDecimal getPerdaCavidade() {
		return perdaCavidade;
	}
	public void setPerdaCavidade(BigDecimal perdaCavidade) {
		this.perdaCavidade = perdaCavidade;
	}
	public BigDecimal getTempoProdutivo() {
		return tempoProdutivo;
	}
	public void setTempoProdutivo(BigDecimal tempoProdutivo) {
		this.tempoProdutivo = tempoProdutivo;
	}
	public BigDecimal getCicloMedio() {
		return cicloMedio;
	}
	public void setCicloMedio(BigDecimal cicloMedio) {
		this.cicloMedio = cicloMedio;
	}
	public BigDecimal getPerdaCiclo() {
		return perdaCiclo;
	}
	public void setPerdaCiclo(BigDecimal perdaCiclo) {
		this.perdaCiclo = perdaCiclo;
	}
	public BigDecimal getRitmo() {
		return ritmo;
	}
	public void setRitmo(BigDecimal ritmo) {
		this.ritmo = ritmo;
	}
	public BigDecimal getTempoRefugado() {
		return tempoRefugado;
	}
	public void setTempoRefugado(BigDecimal tempoRefugado) {
		this.tempoRefugado = tempoRefugado;
	}
	public BigDecimal getTempoTrabalhado() {
		return tempoTrabalhado;
	}
	public void setTempoTrabalhado(BigDecimal tempoTrabalhado) {
		this.tempoTrabalhado = tempoTrabalhado;
	}
	public BigDecimal getTempoCicloImprodutivo() {
		return tempoCicloImprodutivo;
	}
	public void setTempoCicloImprodutivo(BigDecimal tempoCicloImprodutivo) {
		this.tempoCicloImprodutivo = tempoCicloImprodutivo;
	}
	public BigDecimal getTempoCicloProdutivo() {
		return tempoCicloProdutivo;
	}
	public void setTempoCicloProdutivo(BigDecimal tempoCicloProdutivo) {
		this.tempoCicloProdutivo = tempoCicloProdutivo;
	}
	public BigDecimal getTempoCicloRegulagem() {
		return tempoCicloRegulagem;
	}
	public void setTempoCicloRegulagem(BigDecimal tempoCicloRegulagem) {
		this.tempoCicloRegulagem = tempoCicloRegulagem;
	}
	public BigDecimal getQtCicloRegulagem() {
		return qtCicloRegulagem;
	}
	public void setQtCicloRegulagem(BigDecimal qtCicloRegulagem) {
		this.qtCicloRegulagem = qtCicloRegulagem;
	}
	public BigDecimal getQtCicloImprodutivo() {
		return qtCicloImprodutivo;
	}
	public void setQtCicloImprodutivo(BigDecimal qtCicloImprodutivo) {
		this.qtCicloImprodutivo = qtCicloImprodutivo;
	}
	public BigDecimal getQtCicloProdutivo() {
		return qtCicloProdutivo;
	}
	public void setQtCicloProdutivo(BigDecimal qtCicloProdutivo) {
		this.qtCicloProdutivo = qtCicloProdutivo;
	}
	public BigDecimal getTempoParadaCp() {
		return tempoParadaCp;
	}
	public void setTempoParadaCp(BigDecimal tempoParadaCp) {
		this.tempoParadaCp = tempoParadaCp;
	}
	public BigDecimal getTempoParadaSp() {
		return tempoParadaSp;
	}
	public void setTempoParadaSp(BigDecimal tempoParadaSp) {
		this.tempoParadaSp = tempoParadaSp;
	}
	public BigDecimal getTempoParadaCpVr() {
		return tempoParadaCpVr;
	}
	public void setTempoParadaCpVr(BigDecimal tempoParadaCpVr) {
		this.tempoParadaCpVr = tempoParadaCpVr;
	}
	public BigDecimal getTempoParadaSpVr() {
		return tempoParadaSpVr;
	}
	public void setTempoParadaSpVr(BigDecimal tempoParadaSpVr) {
		this.tempoParadaSpVr = tempoParadaSpVr;
	}
	public BigDecimal getTempoAtivo() {
		return tempoAtivo;
	}
	public void setTempoAtivo(BigDecimal tempoAtivo) {
		this.tempoAtivo = tempoAtivo;
	}
	public BigDecimal getCicloPadraoMedio() {
		return this.cicloPadraoMedio;
	}
	public void setCicloPadraoMedio(BigDecimal cicloPadraoMedio) {
		this.cicloPadraoMedio = cicloPadraoMedio;
	}
	public BigDecimal getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(BigDecimal cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public BigDecimal getTempoPerdaCavidade() {
		return tempoPerdaCavidade;
	}
	public void setTempoPerdaCavidade(BigDecimal tempoPerdaCavidade) {
		this.tempoPerdaCavidade = tempoPerdaCavidade;
	}
	public BigDecimal getTempoBoas() {
		return tempoBoas;
	}
	public void setTempoBoas(BigDecimal tempoBoas) {
		this.tempoBoas = tempoBoas;
	}
	public BigDecimal getTempoRefugadas() {
		return tempoRefugadas;
	}
	public void setTempoRefugadas(BigDecimal tempoRefugadas) {
		this.tempoRefugadas = tempoRefugadas;
	}
	public BigDecimal getTempoAlerta() {
		return tempoAlerta;
	}
	public void setTempoAlerta(BigDecimal tempoAlerta) {
		this.tempoAlerta = tempoAlerta;
	}
	public BigDecimal getCavTotal() {
		return cavTotal;
	}
	public void setCavTotal(BigDecimal cavTotal) {
		this.cavTotal = cavTotal;
	}
	public BigDecimal getCavAtivas() {
		return cavAtivas;
	}
	public void setCavAtivas(BigDecimal cavAtivas) {
		this.cavAtivas = cavAtivas;
	}
	public BigDecimal getTempoParadaMtbf() {
		return tempoParadaMtbf;
	}
	public void setTempoParadaMtbf(BigDecimal tempoParadaMtbf) {
		this.tempoParadaMtbf = tempoParadaMtbf;
	}
	public BigDecimal getTempoParadaPao() {
		return tempoParadaPao;
	}
	public void setTempoParadaPao(BigDecimal tempoParadaPao) {
		this.tempoParadaPao = tempoParadaPao;
	}
	public BigDecimal getTempoParadaPa() {
		return tempoParadaPa;
	}
	public void setTempoParadaPa(BigDecimal tempoParadaPa) {
		this.tempoParadaPa = tempoParadaPa;
	}
	public BigDecimal getTempoParadaPtp() {
		return tempoParadaPtp;
	}
	public void setTempoParadaPtp(BigDecimal tempoParadaPtp) {
		this.tempoParadaPtp = tempoParadaPtp;
	}
	public BigDecimal getTempoParadaScp() {
		return tempoParadaScp;
	}
	public void setTempoParadaScp(BigDecimal tempoParadaScp) {
		this.tempoParadaScp = tempoParadaScp;
	}
	public BigDecimal getTempoParadaMdo() {
		return tempoParadaMdo;
	}
	public void setTempoParadaMdo(BigDecimal tempoParadaMdo) {
		this.tempoParadaMdo = tempoParadaMdo;
	}
	public BigDecimal getTempoParadaFds() {
		return tempoParadaFds;
	}
	public void setTempoParadaFds(BigDecimal tempoParadaFds) {
		this.tempoParadaFds = tempoParadaFds;
	}
	public BigDecimal getTempoParadaImprev() {
		return tempoParadaImprev;
	}
	public void setTempoParadaImprev(BigDecimal tempoParadaImprev) {
		this.tempoParadaImprev = tempoParadaImprev;
	}
	public BigDecimal getTempoParadaPrev() {
		return tempoParadaPrev;
	}
	public void setTempoParadaPrev(BigDecimal tempoParadaPrev) {
		this.tempoParadaPrev = tempoParadaPrev;
	}
	public BigDecimal getTempoParadaPp() {
		return tempoParadaPp;
	}
	public void setTempoParadaPp(BigDecimal tempoParadaPp) {
		this.tempoParadaPp = tempoParadaPp;
	}
	public BigDecimal getTempoParadaRegulagem() {
		return tempoParadaRegulagem;
	}
	public void setTempoParadaRegulagem(BigDecimal tempoParadaRegulagem) {
		this.tempoParadaRegulagem = tempoParadaRegulagem;
	}
	public BigDecimal getTempoParadaDefault() {
		return tempoParadaDefault;
	}
	public void setTempoParadaDefault(BigDecimal tempoParadaDefault) {
		this.tempoParadaDefault = tempoParadaDefault;
	}
	public BigDecimal getTempoParadaSemOp() {
		return tempoParadaSemOp;
	}
	public void setTempoParadaSemOp(BigDecimal tempoParadaSemOp) {
		this.tempoParadaSemOp = tempoParadaSemOp;
	}
	public BigDecimal getTempoParadaSemEvt() {
		return tempoParadaSemEvt;
	}
	public void setTempoParadaSemEvt(BigDecimal tempoParadaSemEvt) {
		this.tempoParadaSemEvt = tempoParadaSemEvt;
	}
	public BigDecimal getTempoParadaSemCnx() {
		return tempoParadaSemCnx;
	}
	public void setTempoParadaSemCnx(BigDecimal tempoParadaSemCnx) {
		this.tempoParadaSemCnx = tempoParadaSemCnx;
	}
	public BigDecimal getPesoBruto() {
		return pesoBruto;
	}
	public void setPesoBruto(BigDecimal pesoBruto) {
		this.pesoBruto = pesoBruto;
	}
	public BigDecimal getPesoLiquido() {
		return pesoLiquido;
	}
	public void setPesoLiquido(BigDecimal pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}
	public BigDecimal getTempoParadaAb() {
		return tempoParadaAb;
	}
	public void setTempoParadaAb(BigDecimal tempoParadaAb) {
		this.tempoParadaAb = tempoParadaAb;
	}
	public BigDecimal getQtParadaMtbf() {
		return qtParadaMtbf;
	}
	public void setQtParadaMtbf(BigDecimal qtParadaMtbf) {
		this.qtParadaMtbf = qtParadaMtbf;
	}
	public BigDecimal getQtParadaMttr() {
		return qtParadaMttr;
	}
	public void setQtParadaMttr(BigDecimal qtParadaMttr) {
		this.qtParadaMttr = qtParadaMttr;
	}
	public BigDecimal getQtParadaPao() {
		return qtParadaPao;
	}
	public void setQtParadaPao(BigDecimal qtParadaPao) {
		this.qtParadaPao = qtParadaPao;
	}
	public BigDecimal getQtParadaPa() {
		return qtParadaPa;
	}
	public void setQtParadaPa(BigDecimal qtParadaPa) {
		this.qtParadaPa = qtParadaPa;
	}
	public BigDecimal getQtParadaPtp() {
		return qtParadaPtp;
	}
	public void setQtParadaPtp(BigDecimal qtParadaPtp) {
		this.qtParadaPtp = qtParadaPtp;
	}
	public BigDecimal getQtParadaScp() {
		return qtParadaScp;
	}
	public void setQtParadaScp(BigDecimal qtParadaScp) {
		this.qtParadaScp = qtParadaScp;
	}
	public BigDecimal getQtParadaMdo() {
		return qtParadaMdo;
	}
	public void setQtParadaMdo(BigDecimal qtParadaMdo) {
		this.qtParadaMdo = qtParadaMdo;
	}
	public BigDecimal getQtParadaFds() {
		return qtParadaFds;
	}
	public void setQtParadaFds(BigDecimal qtParadaFds) {
		this.qtParadaFds = qtParadaFds;
	}
	public BigDecimal getQtParadaImprev() {
		return qtParadaImprev;
	}
	public void setQtParadaImprev(BigDecimal qtParadaImprev) {
		this.qtParadaImprev = qtParadaImprev;
	}
	public BigDecimal getQtParadaPrev() {
		return qtParadaPrev;
	}
	public void setQtParadaPrev(BigDecimal qtParadaPrev) {
		this.qtParadaPrev = qtParadaPrev;
	}
	public BigDecimal getQtParadaPp() {
		return qtParadaPp;
	}
	public void setQtParadaPp(BigDecimal qtParadaPp) {
		this.qtParadaPp = qtParadaPp;
	}
	public BigDecimal getQtParadaRegulagem() {
		return qtParadaRegulagem;
	}
	public void setQtParadaRegulagem(BigDecimal qtParadaRegulagem) {
		this.qtParadaRegulagem = qtParadaRegulagem;
	}
	public BigDecimal getQtParadaDefault() {
		return qtParadaDefault;
	}
	public void setQtParadaDefault(BigDecimal qtParadaDefault) {
		this.qtParadaDefault = qtParadaDefault;
	}
	public BigDecimal getQtParadaSemOp() {
		return qtParadaSemOp;
	}
	public void setQtParadaSemOp(BigDecimal qtParadaSemOp) {
		this.qtParadaSemOp = qtParadaSemOp;
	}
	public BigDecimal getQtParadaSemEvt() {
		return qtParadaSemEvt;
	}
	public void setQtParadaSemEvt(BigDecimal qtParadaSemEvt) {
		this.qtParadaSemEvt = qtParadaSemEvt;
	}
	public BigDecimal getQtParadaSemCnx() {
		return qtParadaSemCnx;
	}
	public void setQtParadaSemCnx(BigDecimal qtParadaSemCnx) {
		this.qtParadaSemCnx = qtParadaSemCnx;
	}
	public BigDecimal getIndicePerda() {
		return indicePerda;
	}
	public void setIndicePerda(BigDecimal indicePerda) {
		this.indicePerda = indicePerda;
	}
	public BigDecimal getIndiceParada() {
		return indiceParada;
	}
	public void setIndiceParada(BigDecimal indiceParada) {
		this.indiceParada = indiceParada;
	}
	public BigDecimal getEficienciaCiclo() {
		return eficienciaCiclo;
	}
	public void setEficienciaCiclo(BigDecimal eficienciaCiclo) {
		this.eficienciaCiclo = eficienciaCiclo;
	}
	public BigDecimal getIndiceRefugo() {
		return indiceRefugo;
	}
	public void setIndiceRefugo(BigDecimal indiceRefugo) {
		this.indiceRefugo = indiceRefugo;
	}
	public BigDecimal getIndiceCavidadesAtivas() {
		return indiceCavidadesAtivas;
	}
	public void setIndiceCavidadesAtivas(BigDecimal indiceCavidadesAtivas) {
		this.indiceCavidadesAtivas = indiceCavidadesAtivas;
	}
	public BigDecimal getEficienciaRealizacao() {
		return eficienciaRealizacao;
	}
	public void setEficienciaRealizacao(BigDecimal eficienciaRealizacao) {
		this.eficienciaRealizacao = eficienciaRealizacao;
	}
	public BigDecimal getEficienciaInstantanea() {
		return eficienciaInstantanea;
	}
	public void setEficienciaInstantanea(BigDecimal eficienciaInstantanea) {
		this.eficienciaInstantanea = eficienciaInstantanea;
	}
	public Date getDtHrIPeriodo() {
		return dtHrIPeriodo;
	}
	public void setDtHrIPeriodo(Date dtHrIPeriodo) {
		this.dtHrIPeriodo = dtHrIPeriodo;
	}
	public Date getDtHrFPeriodo() {
		return dtHrFPeriodo;
	}
	public void setDtHrFPeriodo(Date dtHrFPeriodo) {
		this.dtHrFPeriodo = dtHrFPeriodo;
	}
	public Date getDtHrIConsol() {
		return dtHrIConsol;
	}
	public void setDtHrIConsol(Date dtHrIConsol) {
		this.dtHrIConsol = dtHrIConsol;
	}
	public Date getDtHrFConsol() {
		return dtHrFConsol;
	}
	public void setDtHrFConsol(Date dtHrFConsol) {
		this.dtHrFConsol = dtHrFConsol;
	}
	public BigDecimal getTempoPeriodo() {
		return tempoPeriodo;
	}
	public void setTempoPeriodo(BigDecimal tempoPeriodo) {
		this.tempoPeriodo = tempoPeriodo;
	}
	public BigDecimal getTempoTotal() {
		return tempoTotal;
	}
	public void setTempoTotal(BigDecimal tempoTotal) {
		this.tempoTotal = tempoTotal;
	}
	public void setAgrupador(Agrupador agrupador) {
		this.agrupador = agrupador;
	}

	public BigDecimal getITO() {
		return ITO;
	}

	public void setITO(BigDecimal iTO) {
		ITO = iTO;
	}

	public BigDecimal getIDO() {
		return IDO;
	}

	public void setIDO(BigDecimal iDO) {
		IDO = iDO;
	}

	public BigDecimal getIPA() {
		return IPA;
	}
	
	public void setIPA(BigDecimal iPA) {
		IPA = iPA;
	}
	
}
