package idw.model.rn.consolidacao.producao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.ReprocessarMsEvtException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhacic;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwRt;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwRtTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.TempoRealRN;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.model.rn.consolidacao.planejamento.ConsolidacaoPlanejamento;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoInicioCiclo extends ConsolidacaoProducao implements IConsolidacao{
	
	/**
	 * @param omPt
	 * @param dwCalsems <dwCalSem>
	 * @param msEvt
	 * @param omcfg
	 * @param log
	 * @throws SemCicloPadraoException 
	 * @throws SemSGBDException 
	 * @throws SemCalendarioException 
	 * @throws SemPlanejamentoException 
	 * @throws ReprocessarMsEvtException 
	 */
	@Override
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, 
			MsEvt msEvt, OmCfg omcfg, IdwLogger log, int idLog, int identacao)  
					throws SemCalendarioException, SemSGBDException, SemCicloPadraoException, 
					SemPlanejamentoException, RegistroDesconhecidoException, ReprocessarMsEvtException {
		Validate.notNull(msEvt.getDthrEvento(), "Inicio de ciclo está nulo");
		
		final Date dtHrInicioCiclo = msEvt.getDthrEvento();
		
		// Comentado em 05/03/14, pois ao pegar o inicio do ultimo ciclo do ultimo dwrt, ocorreu de o ultimo dwrt não ter o ultimo ciclo da Máquina
		// Assim acaba consolidando mais que o necess�rio
		//final Date dtHrInicioCiclo = getInicioUltimoCicloDeUltimoDwRtSenaoEncontraUsaInicioPassado(omPt, msEvt.getDthrEvento());
		Validate.notNull(omPt, "Posto de trablaho está nulo");		
		Validate.notNull(omPt.getIdPt(), "idPt está nulo");
		PpCp ppCp = obtemPpCp(log, idLog, identacao, omPt, dwCalsems, msEvt, omcfg);
		Validate.notNull(ppCp, "ppCp não pode ser nulo");
		
		ppCp.mudarDthrIniciorealIfNull(dtHrInicioCiclo);
		
		DwPepro dwPepro = msEvt.getDwPepro();
		
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		DwFolha dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
		Validate.notNull(dwFolha,"nao tem folha ativa para o ppCp");
		consolidarInicioCiclo(omPt, dwConsolpt, dwCalsems, dtHrInicioCiclo, ppCp, dwFolha, omcfg, log, idLog, identacao, dwPepro, msEvt);
		
		ConsolidacaoPlanejamento consolidacaoPlanejamento = new ConsolidacaoPlanejamento(getDao());
		consolidacaoPlanejamento.setInicioPpCpentsai(ppCp, omPt, dtHrInicioCiclo);

	}

	private void consolidarInicioCiclo(
			OmPt omPt, 
			DwConsolpt dwConsolpt, 
			List<DwCalsem> dwCalsems, 
			Date dtHrInicioCiclo, 
			PpCp ppCp, 
			DwFolha dwFolha, 
			OmCfg omcfg, 
			IdwLogger log, 
			int idLog, 
			int identacao, 
			DwPepro dwPepro,
			MsEvt msevt) throws SemPlanejamentoException, SemCicloPadraoException, SemCalendarioException, SemSGBDException, RegistroDesconhecidoException, ReprocessarMsEvtException {

		Validate.notNull(omPt, "Posto de trablaho está nulo");
		Validate.notNull(dtHrInicioCiclo, "Inicio do ciclo está nulo");
		Validate.notNull(omPt.getIdPt(), "idPt está nulo");
		Validate.notNull(ppCp, "ppCp não pode ser nulo");
		Validate.notNull(dwFolha,"não tem folha ativa para o ppCp");

		ppCp.mudarDthrIniciorealIfNull(dtHrInicioCiclo);

		// Finaliza parada aberta		
		forcarFinalizacaoParadaAbertaEmNovoCiclo(dtHrInicioCiclo, null, omPt, dwConsolpt, dwCalsems, ppCp, dwFolha, omcfg, log, idLog, identacao, dwPepro, msevt);

		// Pega ConsolId
		DwConsolid dwConsolid = this.obtemConsolIdTurno(log, idLog, identacao, omPt, dwCalsems, ppCp, dwFolha, dtHrInicioCiclo, omcfg, dwPepro);
		
		// Atualiza os ultimos dados consolida��o do pt
		dwConsolpt.setDwConsolid(dwConsolid);
		
		TempoRealRN trn = new TempoRealRN(getDao());
		DwRt dwRt = trn.obtemDwRtParaHeartBeatSemClonarTurnoDTO(dtHrInicioCiclo, omPt, log, dwPepro);
		
		DwFolhacic dwFolhaCic;
		BigDecimal cicloPadrao = null;
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		
		try {
			dwFolhaCic = folhaRN.getFolhacic(dwFolha, omPt);
			cicloPadrao = dwFolhaCic.getSegCiclopadrao();
		} catch (SemCicloPadraoException e){
			cicloPadrao = dwFolha.getSegCiclopadrao();
		}

		if(dwRt != null){
			// Atualiza dados sobre o Inicio do ciclo
			consolidarInicioCicloDwRt(dwRt, dtHrInicioCiclo, cicloPadrao, log, idLog, identacao);
			this.getDao().makePersistent(dwRt);
		}

	}
	
	/**
	 * Atualiza os dados sobre o Inicio do ciclo em {@code DwRt}
	 * @param dwRt
	 * @param dtHrInicioCiclo
	 * @param cicloPadrao
	 */
	public void consolidarInicioCicloDwRt(DwRt dwRt, Date dtHrInicioCiclo, BigDecimal cicloPadrao, IdwLogger log, int idLog, int identacao){
		Validate.notNull(dwRt, "dwRt não pode ser nulo");
		Validate.notNull(dtHrInicioCiclo, "dtHrInicioCiclo não pode ser nulo");
		Validate.notNull(cicloPadrao, "cicloPadrao não pode ser nulo");
		Validate.validState(cicloPadrao.compareTo(BigDecimal.ZERO) > 0, "cicloPadrao deve ser maio que zero");

		if(dwRt.getIsRegulagem() == null ){
			dwRt.setIsRegulagem(false);
		}

		log.info(idLog, identacao, "Com planejamento em idRt = " + dwRt.getIdRt());
		// Máquina com planejamento
		dwRt.setIsSemplanejamento(false);

		// Máquina não está offline
		if (dwRt.getOmPt() != null && dwRt.getIsOffline() != null && dwRt.getIsOffline() == true) {
			dwRt.setIsOffline(false);
			getDao().makePersistent(dwRt.getOmPt());
		}

		//Dados do Inicio do ciclo
		dwRt.setDthrIciclo(dtHrInicioCiclo);
		dwRt.setMsDthriciclo(DataHoraRN.getApenasMilisegundos(dtHrInicioCiclo));
		
		TempoRealRN.setDthrEmDwRtBaseadoNosEventos(dwRt, dtHrInicioCiclo);	
		
		// Indica que está em produção
		dwRt.setStFuncionamento(DwRtTemplate.StFuncionamento.PRODUZINDO.getId());

	}

	
	
	
}
