package idw.model.rn.consolidacao.parametromedicao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.Validate;

import idw.model.dao.MapQuery;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.ReprocessarMsEvtException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolParam;
import idw.model.pojos.DwConsolParammed;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmedparamlog;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpaParam;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFtParam;
import idw.model.pojos.DwRt;
import idw.model.pojos.DwRtcic;
import idw.model.pojos.DwTParada;
import idw.model.pojos.MsEvt;
import idw.model.pojos.MsEvtcep;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwConsolParamTemplate;
import idw.model.pojos.template.DwFtParamTemplate;
import idw.model.pojos.template.DwRtTemplate;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.PTRN;
import idw.model.rn.ParametroRN;
import idw.model.rn.TarifaRN;
import idw.model.rn.TempoRealRN;
import idw.model.rn.consolidacao.EventoInvalidoException;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoParametroMedicao extends ConsolidaRN implements IConsolidacao{

	private DwRtcic dwrtcic = null;
	
	/*
	 * Esse metodo sera usado apenas quando a consolidacao for chamada a partir de um fechamento de ciclo. Logo o valor medido sera associado ao ciclo que fechou
	 * Para tanto devera ser incluida na tabela MsEvt o campo com o valor medido ao final do ciclo
	 */
	public void setDwRtcic(DwRtcic dwrtcic) {
		this.dwrtcic = dwrtcic;
	}
	
	
	@Override
	public void executarConsolidacao(
			OmPt omPt, 
			DwConsolpt dwconsolpt,
			List<DwCalsem> dwCalsems, 
			MsEvt msevt, 
			OmCfg omcfg, 
			IdwLogger log,
			int idLog, 
			int identacao) 
					throws SemCalendarioException, SemSGBDException, SemCicloPadraoException,
							SemPlanejamentoException, RegistroDesconhecidoException,
							EventoInvalidoException, ReprocessarMsEvtException,
							NumeroSerieIrregularException {

		TarifaRN tarifaRN = new TarifaRN(getDao());
		BigDecimal valorMonetarioEnergia = BigDecimal.ZERO;
		Date dthrMedicao = msevt.getDthrEvento();
		int msDthrmedicao = DataHoraRN.getApenasMilisegundos(dthrMedicao);
		
		byte zona = -1;
		boolean par = false;//180720F separar medicoes zonas TOP de BOTTOM
		int intValorparimpar = 0;
		
		Validate.notNull(dthrMedicao, "Data esta nula");
		PTRN ptrn = new PTRN(getDao());
		
		List<OmPt> listaPts = ptrn.pesquisarPtsPaidoPtCEP(omPt);
		if (listaPts == null)
			listaPts = new ArrayList<OmPt>();
		
		listaPts.add(omPt);
		
		
		//Marcos Sardinha: 2019-08-07 consolidacao de parametros CNC genericos
		class CepGenerico {
			String idValorLido = null;
			BigDecimal valorLido = BigDecimal.ZERO;
		}

		Map<Long, CepGenerico> valoresCepGenerico = new HashMap<Long, CepGenerico>();
		Map<Long, BigDecimal> valores = new HashMap<>();
		
		// Inicializa os vetores com os valores das zonas
		for (MsEvtcep cep : msevt.getMsEvtceps()) {
			//Marcos Sardinha: 2019-08-07 consolidacao de parametros CNC genericos
			if (cep.getDwFtParam() != null) {
				CepGenerico cepGenerico = new CepGenerico();
				cepGenerico.idValorLido = (cep.getIdValorLido() == null ? "" : cep.getIdValorLido());
				cepGenerico.valorLido = cep.getValorLidoParam();
				valoresCepGenerico.put(cep.getDwFtParam().getIdFtParam(), cepGenerico);
								
			} else {						
				zona = -1;
				//190214 if (cep.getTemperatura() != null && cep.getZona()==null  ) {
				if (cep.getTemperatura() != null && ( (cep.getZona()==null) || (cep.getZona()!=null && cep.getZona().longValue()==(-1L) ) )  ) {
					valores.put(DwFtParamTemplate.Type.TEMPERATURA.getId(), cep.getTemperatura());
				}
				//190214 if (cep.getTemperatura() != null  && cep.getZona()!=null ) {
				if (cep.getTemperatura() != null  && cep.getZona()!=null && cep.getZona().longValue()!=(-1L) ) {
					
					//0	1	2	3	4	...dados
					//0	x	2	x	4	...TOP (pares, inclusive o zero 0)
					//x	1	x	3	x	...BOTTOM (ímpares)
					intValorparimpar = cep.getZona().intValue();
					if (intValorparimpar!=0){
						par = (( intValorparimpar % 2 ) == 0);
						if (par){
							valores.put(DwFtParamTemplate.Type.TEMPERATURA_ZONAS_TOP.getId(), cep.getTemperatura());	
						}
						else {
							valores.put(DwFtParamTemplate.Type.TEMPERATURA_ZONAS_BOTTOM.getId(), cep.getTemperatura());
						}
					}
					else
					{
						//zero-0 =  TOP (e pares)
						valores.put(DwFtParamTemplate.Type.TEMPERATURA_ZONAS_TOP.getId(), cep.getTemperatura());					
					}
					//TODO: fazer pra quando for ZONA, mas SEM TOP/BOTTOM (só um lado) valores.put(DwFtParamTemplate.Type.TEMPERATURA_ZONAS.getId(), cep.getTemperatura());
	
					
					zona = cep.getZona();
				}
				
				if (cep.getVelocidade() != null) {
					valores.put(DwFtParamTemplate.Type.VELOCIDADE.getId(), cep.getVelocidade());
				}
	
				if (cep.getPressao() != null) {
					valores.put(DwFtParamTemplate.Type.PRESSAO.getId(), cep.getPressao());
				}
				
				if (cep.getFatorpotencia() != null)
					valores.put(DwFtParamTemplate.Type.FATORPONTENCIA.getId(), cep.getFatorpotencia());
				if (cep.getEnergiaconsumida() != null) {
					valores.put(DwFtParamTemplate.Type.ENERGIACONSUMIDA.getId(), cep.getEnergiaconsumida());
					try{
						valorMonetarioEnergia = tarifaRN.getValorMonetario(omPt, msevt.getDthrEvento(), cep.getEnergiaconsumida()); 
					} catch(NullPointerException e){
						log.info(idLog, identacao,"SERVICO NAO IMPLEMENTADO - VALOR MONETARIO ENERGIA");
					}
				}
				if (cep.getTensao() != null)
					valores.put(DwFtParamTemplate.Type.TENSAO.getId(), cep.getTensao());
				if (cep.getTensao1() != null)
					valores.put(DwFtParamTemplate.Type.TENSAO_FASE_1.getId(), cep.getTensao1());
				if (cep.getTensao1e2() != null)
					valores.put(DwFtParamTemplate.Type.TENSAO_FASE_1_e_2.getId(), cep.getTensao1e2());
				if (cep.getTensao1e3() != null)
					valores.put(DwFtParamTemplate.Type.TENSAO_FASE_1_e_3.getId(), cep.getTensao1e3());
				if (cep.getTensao2() != null)
					valores.put(DwFtParamTemplate.Type.TENSAO_FASE_2.getId(), cep.getTensao2());
				if (cep.getTensao2e3() != null)
					valores.put(DwFtParamTemplate.Type.TENSAO_FASE_2_e_3.getId(), cep.getTensao2e3());
				if (cep.getTensao3() != null)
					valores.put(DwFtParamTemplate.Type.TENSAO_FASE_3.getId(), cep.getTensao3());
				if (cep.getCorrente() != null)
					valores.put(DwFtParamTemplate.Type.CORRENTE.getId(), cep.getCorrente());
				if (cep.getCorrente1() != null)
					valores.put(DwFtParamTemplate.Type.CORRENTE_FASE_1.getId(), cep.getCorrente1());
				if (cep.getCorrente2() != null)
					valores.put(DwFtParamTemplate.Type.CORRENTE_FASE_2.getId(), cep.getCorrente2());
				if (cep.getCorrente3() != null)
					valores.put(DwFtParamTemplate.Type.CORRENTE_FASE_3.getId(), cep.getCorrente3());
			}
		}

		
		// Varre a lista de postos para inserir os valores de medicao encontrados
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		ParametroRN parametroRN = new ParametroRN(this.getDao());

		for (OmPt omptParaLancamento : listaPts) {
			// Pega referencia da ordem de producao
			PpCp ppCp = obtemPpCp(log, idLog, identacao, omptParaLancamento, dwCalsems, msevt, omcfg);
			Validate.notNull(ppCp, "PpCp esta nulo");
			ppCp.mudarDthrIniciorealIfNull(dthrMedicao);
			
			DwFolha dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
			Validate.notNull(ppCp, "nao encontrou dwFolha ativa para PpCp");
			
			//Marcos Sardinha: 2019-08-07 consolidacao de parametros CNC genericos
			for (Long idftparam : valoresCepGenerico.keySet()) {
				CepGenerico cepGenerico = valoresCepGenerico.get(idftparam);
				BigDecimal medicao = cepGenerico.valorLido;

				DwConsolmedparamlog dwConsolmedparamlog = new DwConsolmedparamlog();
				DwFtParam dwFtParam = null;
				dwFtParam = parametroRN.getDwFtParam(idftparam);
				dwConsolmedparamlog.setVlrLido(medicao);
				if (! cepGenerico.idValorLido.equals("")) {
					dwConsolmedparamlog.setIdValorLido(cepGenerico.idValorLido);
				}
					
				
				dwConsolmedparamlog.setDthrMedicao(dthrMedicao);
				dwConsolmedparamlog.setMsDthrmedicao(msDthrmedicao);
				dwConsolmedparamlog.setDwFtParam(dwFtParam);
				dwConsolmedparamlog.setDwrtcic(dwrtcic);
				
				this.getDao().makePersistent(dwConsolmedparamlog);
			
				// Consolidacao no turno e na hora
				DwConsolid dwConsolidNoTurno = this.obtemConsolIdTurno(log, idLog, identacao, omptParaLancamento, dwCalsems, ppCp, dwFolha, dwConsolmedparamlog.getDthrMedicao(), omcfg, msevt.getDwPepro());
				DwConsolid dwConsolidNaHora = this.obtemConsolIdHora(omptParaLancamento, dwCalsems, ppCp, dwFolha, dwConsolmedparamlog.getDthrMedicao(), omcfg, msevt.getDwPepro());
				// OBtem o dwRt de referencia com base no horario de referencia. A linha abaixa foi comentada e substituida pela seguinte pois ocorreu uma situacao de estar com dwrt anterior
				// e a monitorizacao mostrar a ultima temperatura errada
				//DwRt dwRt = dwConsolidNoTurno.getDwRt();
				DwRt dwRt =obtemUltimoDwRt(omptParaLancamento.getIdPt());
				dwRt.setUlttemperaturalida(medicao);

				
				TempoRealRN.setDthrEmDwRtBaseadoNosEventos(dwRt, dwConsolmedparamlog.getDthrMedicao());
				
				// Consolidacao no turno para HORAS TRABALHADAS, se a maquina estiver trabalhadno
				if (dwRt.getStFuncionamento().equals(DwRtTemplate.StFuncionamento.PRODUZINDO.getId())) {
					consolidarParametroMedicao(log, DwConsolParamTemplate.TpReferencia.tempo_trabalhado_do_dwconsol.getValue(), dwConsolidNoTurno, dwRt, dwconsolpt, dwConsolmedparamlog, valorMonetarioEnergia);
					consolidarParametroMedicao(log, DwConsolParamTemplate.TpReferencia.tempo_trabalhado_do_dwconsol.getValue(), dwConsolidNaHora, dwRt, dwconsolpt, dwConsolmedparamlog, valorMonetarioEnergia);
				} else if (dwRt.getIsParadapeso() == true) {
					// Consolidacao no turno para HORAS PARADAS COM PESO, se a maquina estiver parada com peso
					consolidarParametroMedicao(log, DwConsolParamTemplate.TpReferencia.tempo_total_parada_cp_do_dwconsol.getValue(), dwConsolidNoTurno, dwRt, dwconsolpt, dwConsolmedparamlog, valorMonetarioEnergia);
					consolidarParametroMedicao(log, DwConsolParamTemplate.TpReferencia.tempo_total_parada_cp_do_dwconsol.getValue(), dwConsolidNaHora, dwRt, dwconsolpt, dwConsolmedparamlog, valorMonetarioEnergia);
				} else {
					// Consolidacao no turno para HORAS PARADAS SEM PESO, se a maquina estiver parada sem peso
					consolidarParametroMedicao(log, DwConsolParamTemplate.TpReferencia.tempo_total_parada_sp_do_dwconsol.getValue(), dwConsolidNoTurno, dwRt, dwconsolpt, dwConsolmedparamlog, valorMonetarioEnergia);
					consolidarParametroMedicao(log, DwConsolParamTemplate.TpReferencia.tempo_total_parada_sp_do_dwconsol.getValue(), dwConsolidNaHora, dwRt, dwconsolpt, dwConsolmedparamlog, valorMonetarioEnergia);
				}
			
				//Consolidacao no tunro para HORAS TOTAIS
				consolidarParametroMedicao(log, DwConsolParamTemplate.TpReferencia.tempo_avaliar.getValue(), dwConsolidNoTurno, dwRt, dwconsolpt, dwConsolmedparamlog, valorMonetarioEnergia);
				consolidarParametroMedicao(log, DwConsolParamTemplate.TpReferencia.tempo_avaliar.getValue(), dwConsolidNaHora, dwRt, dwconsolpt, dwConsolmedparamlog, valorMonetarioEnergia);
			}
			// fim cep generico
			
			
			
			
			// Avaliar todos os possiveis parametros que possam ter sido passados
			for (Long idftparam : valores.keySet()) {
				BigDecimal medicao = valores.get(idftparam);

				DwConsolmedparamlog dwConsolmedparamlog = new DwConsolmedparamlog();
				DwFtParam dwFtParam = null;
				dwFtParam = parametroRN.getDwFtParam(idftparam);
				dwConsolmedparamlog.setVlrLido(medicao);
				if (zona != -1)
					dwConsolmedparamlog.setZona(zona);
				
				dwConsolmedparamlog.setDthrMedicao(dthrMedicao);
				dwConsolmedparamlog.setMsDthrmedicao(msDthrmedicao);
				dwConsolmedparamlog.setDwFtParam(dwFtParam);
				dwConsolmedparamlog.setDwrtcic(dwrtcic);
				// Salvar valor monetario apenas para a energia consumida
				if (dwFtParam.getIdFtParam() == DwFtParamTemplate.Type.ENERGIACONSUMIDA.getId())
					dwConsolmedparamlog.setVlMonetario(valorMonetarioEnergia);
			
				this.getDao().makePersistent(dwConsolmedparamlog);
			
	
				// Consolidacao no turno e na hora
				DwConsolid dwConsolidNoTurno = this.obtemConsolIdTurno(log, idLog, identacao, omptParaLancamento, dwCalsems, ppCp, dwFolha, dwConsolmedparamlog.getDthrMedicao(), omcfg, msevt.getDwPepro());
				DwConsolid dwConsolidNaHora = this.obtemConsolIdHora(omptParaLancamento, dwCalsems, ppCp, dwFolha, dwConsolmedparamlog.getDthrMedicao(), omcfg, msevt.getDwPepro());
				
				// OBtem o dwRt de referencia com base no horario de referencia. A linha abaixa foi comentada e substituida pela seguinte pois ocorreu uma situacao de estar com dwrt anterior
				// e a monitorizacao mostrar a ultima temperatura errada
				//DwRt dwRt = dwConsolidNoTurno.getDwRt();
				DwRt dwRt =obtemUltimoDwRt(omptParaLancamento.getIdPt());
				
				dwRt.setUlttemperaturalida(medicao);
				
				TempoRealRN.setDthrEmDwRtBaseadoNosEventos(dwRt, dwConsolmedparamlog.getDthrMedicao());
				
				// Consolidacao no turno para HORAS TRABALHADAS, se a maquina estiver trabalhadno
				if (dwRt.getStFuncionamento().equals(DwRtTemplate.StFuncionamento.PRODUZINDO.getId())) {
					consolidarParametroMedicao(log, DwConsolParamTemplate.TpReferencia.tempo_trabalhado_do_dwconsol.getValue(), dwConsolidNoTurno, dwRt, dwconsolpt, dwConsolmedparamlog, valorMonetarioEnergia);
					consolidarParametroMedicao(log, DwConsolParamTemplate.TpReferencia.tempo_trabalhado_do_dwconsol.getValue(), dwConsolidNaHora, dwRt, dwconsolpt, dwConsolmedparamlog, valorMonetarioEnergia);
				} else if (dwRt.getIsParadapeso() == true) {
					// Consolidacao no turno para HORAS PARADAS COM PESO, se a maquina estiver parada com peso
					consolidarParametroMedicao(log, DwConsolParamTemplate.TpReferencia.tempo_total_parada_cp_do_dwconsol.getValue(), dwConsolidNoTurno, dwRt, dwconsolpt, dwConsolmedparamlog, valorMonetarioEnergia);
					consolidarParametroMedicao(log, DwConsolParamTemplate.TpReferencia.tempo_total_parada_cp_do_dwconsol.getValue(), dwConsolidNaHora, dwRt, dwconsolpt, dwConsolmedparamlog, valorMonetarioEnergia);
				} else {
					// Consolidacao no turno para HORAS PARADAS SEM PESO, se a maquina estiver parada sem peso
					consolidarParametroMedicao(log, DwConsolParamTemplate.TpReferencia.tempo_total_parada_sp_do_dwconsol.getValue(), dwConsolidNoTurno, dwRt, dwconsolpt, dwConsolmedparamlog, valorMonetarioEnergia);
					consolidarParametroMedicao(log, DwConsolParamTemplate.TpReferencia.tempo_total_parada_sp_do_dwconsol.getValue(), dwConsolidNaHora, dwRt, dwconsolpt, dwConsolmedparamlog, valorMonetarioEnergia);
				}
			
				//Consolidacao no tunro para HORAS TOTAIS
				consolidarParametroMedicao(log, DwConsolParamTemplate.TpReferencia.tempo_avaliar.getValue(), dwConsolidNoTurno, dwRt, dwconsolpt, dwConsolmedparamlog, valorMonetarioEnergia);
				consolidarParametroMedicao(log, DwConsolParamTemplate.TpReferencia.tempo_avaliar.getValue(), dwConsolidNaHora, dwRt, dwconsolpt, dwConsolmedparamlog, valorMonetarioEnergia);
			}
		}
	}

	/* Consolidar o parametro de medicao ocnforme dwConsolid passado eo tipo de referencia
	 * 
		tempo_avaliar((byte)0),
		tempo_trabalhado_do_dwconsol((byte)1),
		tempo_total_parada_cp_do_dwconsol((byte)2),
		tempo_total_parada_sp_do_dwconsol((byte)3);
	 */
	private void consolidarParametroMedicao(IdwLogger log, Byte tpReferencia, DwConsolid dwConsolid, DwRt dwrt, DwConsolpt dwConsolpt, DwConsolmedparamlog medicaolog, BigDecimal valorMonetarioEnergia) throws SemCicloPadraoException{
		
		// Pega dwConsol
		DwConsol dwConsol = null;
		for(DwConsol item:dwConsolid.getDwConsols()){
			dwConsol = item;
			break;
		}

		//180719F zona..
		Byte zona = null;
		if (medicaolog!=null &&  medicaolog.getZona()!=null){
			zona = medicaolog.getZona();
		}

		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwConsolParam a");
		q.append("where a.tpReferencia = :tp");
		q.append("and a.dwConsol = :dwconsol");
		q.append("and a.dwFtParam = :dwftparam");

		
		//Marcos Sardinha: 2019-08-07 consolidacao de parametros CNC genericos
		if(medicaolog.getIdValorLido() != null) {
			q.append("and a.idValorLido = :idvalorlido");
		}
		
		
		//180719F zona..
		if (zona!=null){
			q.append("and a.zona = :zona");
		}
		
		
		q.setMaxResults(1);
		q.defineParametro("tp", tpReferencia);
		q.defineParametro("dwconsol", dwConsol);
		q.defineParametro("dwftparam", medicaolog.getDwFtParam());

		
		//180719F zona..
		if (zona!=null){
			q.defineParametro("zona", zona);
		}
		
		//Marcos Sardinha: 2019-08-07 consolidacao de parametros CNC genericos
		if(medicaolog.getIdValorLido() != null) {
			q.defineParametro("idvalorlido", medicaolog.getIdValorLido());
		}
		
		
		BigDecimal valor = medicaolog.getVlrLido();

		DwConsolParam consolparam = (DwConsolParam) q.uniqueResult();
		
		if(consolparam == null){
			consolparam  = new DwConsolParam();
			consolparam.setDwConsol(dwConsol); 
			consolparam.setDwFtParam(medicaolog.getDwFtParam());
			consolparam.setQtMedicoes(1);
			consolparam.setTpReferencia(tpReferencia);
			consolparam.setVlMaximo(valor);
			consolparam.setVlMedio(valor);
			consolparam.setVlMinimo(valor);
			consolparam.setVlSomado(valor);

			
			//180719F zona..
			if (zona!=null){
				consolparam.setZona(zona);
			}

			//Marcos Sardinha: 2019-08-07 consolidacao de parametros CNC genericos
			if(medicaolog.getIdValorLido() != null) {
				consolparam.setIdValorLido(medicaolog.getIdValorLido());
			}
			
			if (medicaolog.getDwFtParam().getIdFtParam() == DwFtParamTemplate.Type.ENERGIACONSUMIDA.getId())
				consolparam.setVlMonetario(valorMonetarioEnergia);
		} else {
			consolparam.setQtMedicoes(consolparam.getQtMedicoes() + 1);
			if (valor.compareTo(consolparam.getVlMaximo()) > 0)
				consolparam.setVlMaximo(valor);
			
			if (valor.compareTo(consolparam.getVlMaximo()) < 0)
				consolparam.setVlMinimo(valor);
			
			consolparam.setVlSomado(consolparam.getVlSomado().add(valor));
			consolparam.setVlMedio(consolparam.getVlSomado().divide(new BigDecimal(consolparam.getQtMedicoes()), 4, BigDecimal.ROUND_HALF_DOWN));
			if (medicaolog.getDwFtParam().getIdFtParam() == DwFtParamTemplate.Type.ENERGIACONSUMIDA.getId())
				consolparam.setVlMonetario(consolparam.getVlMonetario().add(valorMonetarioEnergia));
			
		}
		this.getDao().makePersistent(consolparam);
		
		// Se a maquina estiver parada entao consolidar para a parada em aberto
		DwConsolpaParam dwconsolpaparam = null;
		if (	tpReferencia.equals(DwConsolParamTemplate.TpReferencia.tempo_total_parada_cp_do_dwconsol.getValue()) ||
				tpReferencia.equals(DwConsolParamTemplate.TpReferencia.tempo_total_parada_sp_do_dwconsol.getValue())
				) {
			
			// Pesquisar dwconsolpa
			DwConsolpa dwconsolpa = getDwConsolpa(dwConsol, dwrt.getDwConsolpalog().getDwTParada());
			
			// PEsquisar dwconsolpaparam
			dwconsolpaparam = getDwConsolpapara(dwconsolpa, medicaolog.getDwFtParam());
			
			// Se nao existirm incluir dwConoslpaParam
			if (dwconsolpaparam == null) {
				dwconsolpaparam = new DwConsolpaParam();
				dwconsolpaparam.setDwConsolpa(dwconsolpa); 
				dwconsolpaparam.setDwFtParam(medicaolog.getDwFtParam());
				dwconsolpaparam.setQtMedicoes(BigDecimal.ONE);
				dwconsolpaparam.setVlMaximo(valor);
				dwconsolpaparam.setVlmedio(valor);
				dwconsolpaparam.setVlMinimo(valor.intValue());
				dwconsolpaparam.setVlSomado(valor);
				if (medicaolog.getDwFtParam().getIdFtParam() == DwFtParamTemplate.Type.ENERGIACONSUMIDA.getId())
					dwconsolpaparam.setVlMonetario(valorMonetarioEnergia);
			} else {
				dwconsolpaparam.setQtMedicoes(dwconsolpaparam.getQtMedicoes().add(BigDecimal.ONE));
				if (valor.intValue() > dwconsolpaparam.getVlMaximo().intValue())
					dwconsolpaparam.setVlMaximo(valor);
				
				if (valor.intValue() < dwconsolpaparam.getVlMinimo().intValue())
					dwconsolpaparam.setVlMinimo(valor.intValue());
				
				dwconsolpaparam.setVlSomado(dwconsolpaparam.getVlSomado().add(valor));
				dwconsolpaparam.setVlmedio(dwconsolpaparam.getVlSomado().divide(dwconsolpaparam.getQtMedicoes(), 4, BigDecimal.ROUND_HALF_DOWN));
				if (medicaolog.getDwFtParam().getIdFtParam() == DwFtParamTemplate.Type.ENERGIACONSUMIDA.getId())
					dwconsolpaparam.setVlMonetario(dwconsolpaparam.getVlMonetario().add(valorMonetarioEnergia));
			}
			
			getDao().makePersistent(dwconsolpaparam);
			
		}
		
		
		
		
		
		
		

		// Relacionar aos totais qual foi o valor medido para se chegar a eles
		DwConsolParammed dwconsolparammed = new DwConsolParammed();
		dwconsolparammed.setDwConsolmedparamlog(medicaolog);
		dwconsolparammed.setDwConsolpaParam(dwconsolpaparam);
		dwconsolparammed.setDwConsolParam(consolparam);
		//dwconsolparammed.setDwConsolpaoco();
		dwconsolparammed.setIdConsolparammed(null);

		getDao().makePersistent(dwconsolparammed);
		
	}
	
	private DwConsolpa getDwConsolpa(DwConsol dwconsol, DwTParada dwtparada) {
		DwConsolpa retorno = null;
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwConsolpa a");
		q.append("where a.dwConsol = :dwconsol");
		q.append("and a.dwTParada = :dwtparada");
		q.setMaxResults(1);
		q.defineParametro("dwconsol", dwconsol);
		q.defineParametro("dwtparada", dwtparada);
		retorno = (DwConsolpa) q.uniqueResult();
		return retorno;
	}
	private DwConsolpaParam getDwConsolpapara(DwConsolpa dwconsolpa, DwFtParam dwftparam) {
		DwConsolpaParam retorno = null;
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from DwConsolpaParam a");
		q.append("where a.dwFtParam = :dwftparam");
		q.append("and a.dwConsolpa = :dwconsolpa");
		
		q.setMaxResults(1);
		q.defineParametro("dwftparam", dwftparam);
		q.defineParametro("dwconsolpa", dwconsolpa);
		
		retorno = (DwConsolpaParam) q.uniqueResult();
		
		return retorno;
	}
}
