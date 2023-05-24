package idw.model.rn.consolidacao.refugo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmo;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwConsolprmo;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwConsolre;
import idw.model.pojos.DwConsolrelog;
import idw.model.pojos.DwConsolreoco;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwRt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.TurnoRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.util.IdwLogger;
import idw.webservices.dto.TurnoAtualDTO;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoRefugoRN extends ConsolidaRN{
	/**
	 * Consolidar refugo de todos os perÃ­odos
	 * @param omPt
	 * @param dwConsolpt
	 * @param dwCalsems
	 * @param ppCp
	 * @param dwFolha
	 * @param dwConsolrelog
	 * @param omcfg
	 * @param log
	 * @throws RegistroDesconhecidoException
	 * @throws SemCalendarioException
	 * @throws SemSGBDException
	 * @throws SemCicloPadraoException
	 */
	protected void consolidarRefugoTodosPeriodos(OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, PpCp ppCp, DwFolha dwFolha, 
			DwConsolrelog dwConsolrelog, OmCfg omcfg, IdwLogger log, int idLog, int identacao, DwPepro dwPepro) throws RegistroDesconhecidoException, SemCalendarioException, SemSGBDException, SemCicloPadraoException{
		consolidarRefugoTurno(omPt, dwConsolpt, dwCalsems, ppCp, dwFolha, dwConsolrelog, omcfg, log, idLog, identacao, dwPepro);
		consolidarRefugoHora(omPt, dwConsolpt, dwCalsems, ppCp, dwFolha, dwConsolrelog, omcfg, log, dwPepro);
		consolidarRefugoAcumulado(omPt, dwConsolpt, dwCalsems, ppCp, dwFolha, dwConsolrelog, omcfg, log, dwPepro);
	}
	
	/**
	 * 
	 * @param omPt
	 * @param dwConsolpt
	 * @param dwCalsems
	 * @param ppCp
	 * @param dwFolha
	 * @param dwConsolrelog
	 * @param omcfg
	 * @param log
	 * @param dwPepro
	 * @throws RegistroDesconhecidoException
	 * @throws SemCalendarioException
	 * @throws SemSGBDException
	 * @throws SemCicloPadraoException
	 * 
	 * @author Alan Nascimento
	 * 
	 * Rotina temporária para identificar quando chamada do Apontamento Manual SONY. Isso para não considerar flag de posto quando consolidar 
	 * motivos em Consol e Consolpr. 
	 * Para economizar comentários o mesmo vale paras os métodos chamados dentro desta e assim por diante.
	 * Todas rotinas com "_SONY" foram criadas com este próposito
	 * 
	 */
	protected void consolidarRefugoTodosPeriodos_SONY(OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, PpCp ppCp, DwFolha dwFolha, 
													  DwConsolrelog dwConsolrelog, OmCfg omcfg, IdwLogger log, DwPepro dwPepro) throws RegistroDesconhecidoException, SemCalendarioException, SemSGBDException, SemCicloPadraoException{
		
		consolidarRefugoTurno_SONY(omPt, dwConsolpt, dwCalsems, ppCp, dwFolha, dwConsolrelog, omcfg, log, dwPepro);
		consolidarRefugoHora_SONY(omPt, dwConsolpt, dwCalsems, ppCp, dwFolha, dwConsolrelog, omcfg, log, dwPepro);
		consolidarRefugoAcumulado_SONY(omPt, dwConsolpt, dwCalsems, ppCp, dwFolha, dwConsolrelog, omcfg, log, dwPepro);
	
	}
	
	/**
	 * Consolida os dados de refugo para o turno
	 * @param omPt
	 * @param dwConsolpt
	 * @param dwCalsems
	 * @param ppCp
	 * @param dwFolha
	 * @param dwConsolrelog - Deve estar atualizado com valores do evento atual. Pois este dados indicaram se a quantidade serÃ¡ abatida ou nÃ£o.
	 * @param omcfg
	 * @param log
	 * @throws RegistroDesconhecidoException
	 * @throws SemCalendarioException
	 * @throws SemSGBDException
	 * @throws SemCicloPadraoException
	 */
	private void consolidarRefugoTurno(OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, PpCp ppCp, DwFolha dwFolha, DwConsolrelog dwConsolrelog, 
			OmCfg omcfg, IdwLogger log, int idLog, int identacao, DwPepro dwPepro) throws RegistroDesconhecidoException, SemCalendarioException, SemSGBDException, SemCicloPadraoException {

		Validate.notNull(omPt, "OmPt esta nulo");
		Validate.notNull(ppCp, "PpCp esta nulo");
		Validate.notNull(dwConsolrelog, "dwConsolrelog esta nulo");

		// Pega ConsolId
		DwConsolid dwConsolid = this.obtemConsolIdTurno(log, idLog, identacao, omPt, dwCalsems, ppCp, dwFolha, dwConsolrelog.getDthrRefugo(), omcfg, dwPepro);

		consolidarRefugoDwConsolid(log, dwConsolid, dwConsolpt, dwConsolrelog);

	}

	private void consolidarRefugoTurno_SONY(OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, PpCp ppCp, DwFolha dwFolha, DwConsolrelog dwConsolrelog, 
											OmCfg omcfg, IdwLogger log, DwPepro dwPepro) throws RegistroDesconhecidoException, SemCalendarioException, SemSGBDException, SemCicloPadraoException {

		Validate.notNull(omPt, "OmPt esta nulo");
		Validate.notNull(ppCp, "PpCp esta nulo");
		Validate.notNull(dwConsolrelog, "dwConsolrelog esta nulo");

		// Pega ConsolId
		DwConsolid dwConsolid = this.obtemConsolIdTurno(log, 0, 0, omPt, dwCalsems, ppCp, dwFolha, dwConsolrelog.getDthrRefugo(), omcfg, dwPepro);

		consolidarRefugoDwConsolid_SONY(log, dwConsolid, dwConsolpt, dwConsolrelog);

	}

	/**
	 * Consolidar refugo por hora
	 * @param omPt
	 * @param ppCp
	 * @param dwConsolrelog
	 * @throws SemSGBDException
	 * @throws SemCalendarioException
	 */
	private void consolidarRefugoHora(OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, PpCp ppCp, DwFolha dwFolha, 
			DwConsolrelog dwConsolrelog, OmCfg omCfg, IdwLogger log, DwPepro dwPepro) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException{
		DwConsolid dwConsolid = this.obtemConsolIdHora(omPt, dwCalsems, ppCp, dwFolha, dwConsolrelog.getDthrRefugo(), omCfg, dwPepro);
		consolidarRefugoDwConsolid(log, dwConsolid, dwConsolpt, dwConsolrelog);
	}

	private void consolidarRefugoHora_SONY(OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, PpCp ppCp, DwFolha dwFolha, 
										   DwConsolrelog dwConsolrelog, OmCfg omCfg, IdwLogger log, DwPepro dwPepro) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException{
		
		DwConsolid dwConsolid = this.obtemConsolIdHora(omPt, dwCalsems, ppCp, dwFolha, dwConsolrelog.getDthrRefugo(), omCfg, dwPepro);
		
		consolidarRefugoDwConsolid_SONY(log, dwConsolid, dwConsolpt, dwConsolrelog);
	
	}

	private void consolidarRefugoAcumulado(OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, 
			PpCp ppCp, 
			DwFolha dwFolha, DwConsolrelog dwConsolrelog, OmCfg omCfg, IdwLogger log, DwPepro dwPepro) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException{
		
		TurnoRN turnoRN = new TurnoRN(getDao());

		// Pega os per�odos com os turnos
		TurnoAtualDTO turnoAtualDTO = turnoRN.getTurnoAtualDTO(dwCalsems, dwConsolrelog.getDthrRefugo());

		DwConsolid dwConsolid = this.obtemConsolIdAcumulado(omPt, ppCp, dwFolha, turnoAtualDTO);
		
		consolidarRefugoDwConsolid(log, dwConsolid, dwConsolpt, dwConsolrelog);
	}

	private void consolidarRefugoAcumulado_SONY(OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, 
												PpCp ppCp, 
												DwFolha dwFolha, DwConsolrelog dwConsolrelog, OmCfg omCfg, IdwLogger log, DwPepro dwPepro) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException{
		
		TurnoRN turnoRN = new TurnoRN(getDao());

		// Pega os per�odos com os turnos
		TurnoAtualDTO turnoAtualDTO = turnoRN.getTurnoAtualDTO(dwCalsems, dwConsolrelog.getDthrRefugo());

		DwConsolid dwConsolid = this.obtemConsolIdAcumulado(omPt, ppCp, dwFolha, turnoAtualDTO);
		
		consolidarRefugoDwConsolid_SONY(log, dwConsolid, dwConsolpt, dwConsolrelog);
	
	}

	/**
	 * Consolidar refugo para o DwConsolid
	 * @param dwConsolid
	 * @param dwConsolrelog
	 */
	private void consolidarRefugoDwConsolid(IdwLogger log, DwConsolid dwConsolid, DwConsolpt dwConsolpt, DwConsolrelog dwConsolrelog) throws SemCicloPadraoException{
		// Pega dwConsol
		DwConsol dwConsol = null;
		for(DwConsol item:dwConsolid.getDwConsols()){
			dwConsol = item;
			break;
		}

		DwRt dwRt = dwConsolid.getDwRt();

		DwFolha dwFolha = dwConsolid.getDwFolha();

		BigDecimal cavAtiva = getCavAtivasAjustaDwConsolSenaoTiver(dwConsol);

		BigDecimal cicloPadrao = this.getCicloPadrao(dwConsolid.getOmPt(), dwFolha);

		BigDecimal qtde = dwConsolrelog.getPcsAutoProducaorefugada();

		if (dwConsolrelog.getIsCancelado() != null) {
			// A quantidade Ã© atualizada dependendo se for cancelada ou nÃ£o
			qtde = (dwConsolrelog.getIsCancelado() ? qtde.negate(): qtde);
		}
	
		// Ciclo padrÃ£o
		dwConsol.setSegAutoCiclopadrao(cicloPadrao);

		/* Alessandre em 27-11-17 foi incluida uma configuracao em OmPt para informar quando um motivo de refugo
		 * nao deve ser contabilizado em DwConsol e DwConsolpr. Isso acontece devido a coleta da Sony que enviara a producao bruta, liquida e refugada
		 * durante o ciclo. Assim o motivo de refugo deve atualizar apenas o pareto.
		 * O cliente tem ciencia da divergencia que pode existir entre o pareto e total refugado
		 * Alessandre em 22-10-18, foi acrescentado para a Sony o flag dwTrefugo.isAutomatico que complementa a configuracao ompt.isCicloComRefugo
		 * ou seja, mesmo que isCicloComRefugo seja true ele o dwTrefugo.isAuto9matico
		 */
		if (
				dwConsolid.getOmPt().getIsCiclocomrefugo() == null || 
				dwConsolid.getOmPt().getIsCiclocomrefugo() == false ||
				dwConsolrelog.getDwTRefugo().getIsAutomatico() == null || 
				dwConsolrelog.getDwTRefugo().getIsAutomatico() == false ) {
			// Atualiza a quantidade refugada
			dwConsol.setPcsAutoProducaorefugada(AritmeticaUtil.somar(dwConsol.getPcsAutoProducaorefugada(), qtde));
			
			
			// Alessandre em 30-10-2018. Se o PT estiver configurado para apontar refugo e producao liquida independentemente, e entrou nesse trecho
			// eh pq o motivo do refugo está configurado para desconsiderar essa configuracao. Entao nessa situacao o refugo deve descontar seu valor na producao liquida
			if (dwConsolid.getOmPt().getIsCiclocomrefugo() != null && dwConsolid.getOmPt().getIsCiclocomrefugo() == true) {
				BigDecimal producaoLiquida = dwConsol.getPcsAutoProducaoliquida();
				if (producaoLiquida == null)
					producaoLiquida = BigDecimal.ZERO;
				producaoLiquida = producaoLiquida.subtract(qtde);
				
				dwConsol.setPcsAutoProducaoliquida(producaoLiquida);
			}
		
			// Tempo de refugo
			dwConsol.setSegAutoTemporefugadas(
					FormulasInjet.calcularTempoRefugoComBaseNoCiclo(
							dwConsol.getPcsProducaoBruta(), 
							dwConsol.getPcsProducaoRefugada(), 
							dwConsol.getSegAutoCicloprodutivo()));
	
			// Horas boas: tempo de ciclo produtivo - Refugo em segundos
			dwConsol.setSegAutoBoas(FormulasInjet.calcularTempoBoas(dwConsol.getSegAutoCicloprodutivo(), dwConsol.getSegAutoTemporefugadas(), dwConsol.getSegAutoTempoparadaCpVr(), dwConsol.getSegAutoTempoparadaSpVr()));

			// Tempo produtivo: Horas boas - Cavidades inativas em segundos - Ritmo (se resultado for negativo, considerar ZERO)
	
			dwConsol.setSegAutoTempoprodutivo(FormulasInjet.calcularTempoprodutivas(dwConsol.getSegAutoBoas(), dwConsol.getSegAutoPerdacav(), dwConsol.getSegAutoRitmo()));

			// Atualizar DwConsolpr
			for(DwConsolpr dwConsolpr: dwConsol.getDwConsolprs()){
	
				// Refugar apenas para o produto lancado em dwconsolrelog
				if (dwConsolrelog.getOmProduto().getCdProduto().equals(dwConsolpr.getOmProduto().getCdProduto())) {
					// PeÃ§as refugadas
					if(dwConsolpr.getPcsAutoProducaorefugada() != null){
						dwConsolpr.setPcsAutoProducaorefugada((AritmeticaUtil.somar(dwConsolpr.getPcsAutoProducaorefugada(), qtde)));
					}else{
						dwConsolpr.setPcsAutoProducaorefugada(qtde);
					}
		
					// Alessandre em 30-10-2018. Se o PT estiver configurado para apontar refugo e producao liquida independentemente, e entrou nesse trecho
					// eh pq o motivo do refugo está configurado para desconsiderar essa configuracao. Entao nessa situacao o refugo deve descontar seu valor na producao liquida
					if (dwConsolid.getOmPt().getIsCiclocomrefugo() != null && dwConsolid.getOmPt().getIsCiclocomrefugo() == true) {
						BigDecimal producaoLiquida = dwConsolpr.getPcsAutoProducaoliquida();
						if (producaoLiquida == null)
							producaoLiquida = BigDecimal.ZERO;
						producaoLiquida = producaoLiquida.subtract(qtde);
						dwConsolpr.setPcsAutoProducaoliquida(producaoLiquida);
					}
					
					this.getDao().makePersistent(dwConsolpr);
				}
			}

			List<DwConsolmo> dwConsolmoComLoginAberto = this.getDwConsolmoComLoginAberto(dwConsol.getIdConsol());
	
			//Atualizar DwConsolmo (DwConsol)
			for(DwConsolmo dwConsolmo: dwConsolmoComLoginAberto){
	
				// PeÃ§as refugadas
				dwConsolmo.setPcsAutoProducaorefugada(AritmeticaUtil.somar(dwConsolmo.getPcsAutoProducaorefugada(), qtde));
	
				//Atualizar DwConsolprmo (DwConsolmo)
				for(DwConsolprmo dwConsolprmo: dwConsolmo.getDwConsolprmos()){
					dwConsolprmo.setPcsAutoProducaorefugada(AritmeticaUtil.somar(dwConsolprmo.getPcsAutoProducaorefugada(), cavAtiva.longValue()));
					this.getDao().makePersistent(dwConsolprmo);
				}
	
				this.getDao().makePersistent(dwConsolmo);
	
			}
		}
	
		this.getDao().makePersistent(dwConsol);

		DwConsolre dwConsolre = this.getDwConsolre(dwConsol.getIdConsol(), dwConsolrelog.getDwTRefugo().getIdTrefugo());
		if(dwConsolre == null){
			
			dwConsolre = new DwConsolre();
			dwConsolre.setDwConsol(dwConsol);
			dwConsolre.setDwTRefugo(dwConsolrelog.getDwTRefugo());
			dwConsolre.setPcsAutoProducaorefugada(new BigDecimal(0));
			dwConsolre.setPcsManuProducaorefugada(new BigDecimal(0));
		}
		dwConsolre.setPcsAutoProducaorefugada(AritmeticaUtil.somar(dwConsolre.getPcsAutoProducaorefugada(), qtde));

		this.getDao().makePersistent(dwConsolre);
		

		DwConsolreoco dwConsolreoco = this.getDwConsolreoco(dwConsolre.getIdConsolre(), dwConsolrelog.getIdConsolrelog());
		if(dwConsolreoco == null){
			
			dwConsolreoco = new DwConsolreoco();
			dwConsolreoco.setDwConsolre(dwConsolre);
			dwConsolreoco.setDwConsolrelog(dwConsolrelog);
		}
		this.getDao().makePersistent(dwConsolreoco);

		if(dwRt != null){
			if(dwRt.getIsRegulagem() == null ){
				dwRt.setIsRegulagem(false);
			}

			// MÃ¡quina com planejamento
			dwRt.setIsSemplanejamento(false);

			// MÃ¡quina nÃ£o estÃ¡ offline
			dwRt.setIsOffline(false);
						
			//TODO milton calcular is_vidautilmolde

			//pcs_producaoliquida_op
			if(dwRt.getPcsProducaoliquidaOp() == null){
				dwRt.setPcsProducaoliquidaOp(BigDecimal.ZERO);
			}
			dwRt.setPcsProducaoliquidaOp(dwRt.getPcsProducaoliquidaOp().subtract(qtde));

			// Indica que estÃ¡ em produÃ§Ã£o
			this.getDao().makePersistent(dwRt);
		}
	}
	
	private void consolidarRefugoDwConsolid_SONY(IdwLogger log, DwConsolid dwConsolid, DwConsolpt dwConsolpt, DwConsolrelog dwConsolrelog) throws SemCicloPadraoException{
		// Pega dwConsol
		DwConsol dwConsol = null;
		for(DwConsol item:dwConsolid.getDwConsols()){
			dwConsol = item;
			break;
		}

		DwRt dwRt = dwConsolid.getDwRt();

		DwFolha dwFolha = dwConsolid.getDwFolha();

		BigDecimal cavAtiva = getCavAtivasAjustaDwConsolSenaoTiver(dwConsol);

		BigDecimal cicloPadrao = this.getCicloPadrao(dwConsolid.getOmPt(), dwFolha);

		BigDecimal qtde = dwConsolrelog.getPcsAutoProducaorefugada();

		if (dwConsolrelog.getIsCancelado() != null) {
			// A quantidade Ã© atualizada dependendo se for cancelada ou nÃ£o
			qtde = (dwConsolrelog.getIsCancelado() ? qtde.negate(): qtde);
		}
	
		// Ciclo padrÃ£o
		dwConsol.setSegAutoCiclopadrao(cicloPadrao);

		/* Alessandre em 27-11-17 foi incluida uma configuracao em OmPt para informar quando um motivo de refugo
		 * nao deve ser contabilizado em DwConsol e DwConsolpr. Isso acontece devido a coleta da Sony que enviara a producao bruta, liquida e refugada
		 * durante o ciclo. Assim o motivo de refugo deve atualizar apenas o pareto.
		 * O cliente tem ciencia da divergencia que pode existir entre o pareto e total refugado
		 */
		//if (dwConsolid.getOmPt().getIsCiclocomrefugo() == null || dwConsolid.getOmPt().getIsCiclocomrefugo() == false) {
			// Atualiza a quantidade refugada
			dwConsol.setPcsAutoProducaorefugada(AritmeticaUtil.somar(dwConsol.getPcsAutoProducaorefugada(), qtde));
		
			// Tempo de refugo
			dwConsol.setSegAutoTemporefugadas(
					FormulasInjet.calcularTempoRefugoComBaseNoCiclo(
							dwConsol.getPcsProducaoBruta(), 
							dwConsol.getPcsProducaoRefugada(), 
							dwConsol.getSegAutoCicloprodutivo()));
	
			// Horas boas: tempo de ciclo produtivo - Refugo em segundos
			dwConsol.setSegAutoBoas(FormulasInjet.calcularTempoBoas(dwConsol.getSegAutoCicloprodutivo(), dwConsol.getSegAutoTemporefugadas(), dwConsol.getSegAutoTempoparadaCpVr(), dwConsol.getSegAutoTempoparadaSpVr()));

			// Tempo produtivo: Horas boas - Cavidades inativas em segundos - Ritmo (se resultado for negativo, considerar ZERO)
	
			dwConsol.setSegAutoTempoprodutivo(FormulasInjet.calcularTempoprodutivas(dwConsol.getSegAutoBoas(), dwConsol.getSegAutoPerdacav(), dwConsol.getSegAutoRitmo()));

			// Atualizar DwConsolpr
			for(DwConsolpr dwConsolpr: dwConsol.getDwConsolprs()){
	
				// Refugar apenas para o produto lancado em dwconsolrelog
				if (dwConsolrelog.getOmProduto().getCdProduto().equals(dwConsolpr.getOmProduto().getCdProduto())) {
					// PeÃ§as refugadas
					if(dwConsolpr.getPcsAutoProducaorefugada() != null){
						dwConsolpr.setPcsAutoProducaorefugada((AritmeticaUtil.somar(dwConsolpr.getPcsAutoProducaorefugada(), qtde)));
					}else{
						dwConsolpr.setPcsAutoProducaorefugada(qtde);
					}
		
					this.getDao().makePersistent(dwConsolpr);
				}
			}

			List<DwConsolmo> dwConsolmoComLoginAberto = this.getDwConsolmoComLoginAberto(dwConsol.getIdConsol());
	
			//Atualizar DwConsolmo (DwConsol)
			for(DwConsolmo dwConsolmo: dwConsolmoComLoginAberto){
	
				// PeÃ§as refugadas
				dwConsolmo.setPcsAutoProducaorefugada(AritmeticaUtil.somar(dwConsolmo.getPcsAutoProducaorefugada(), qtde));
	
				//Atualizar DwConsolprmo (DwConsolmo)
				for(DwConsolprmo dwConsolprmo: dwConsolmo.getDwConsolprmos()){
					dwConsolprmo.setPcsAutoProducaorefugada(AritmeticaUtil.somar(dwConsolprmo.getPcsAutoProducaorefugada(), cavAtiva.longValue()));
					this.getDao().makePersistent(dwConsolprmo);
				}
	
				this.getDao().makePersistent(dwConsolmo);
	
			}
		//}
	
	
	
		this.getDao().makePersistent(dwConsol);

		DwConsolre dwConsolre = this.getDwConsolre(dwConsol.getIdConsol(), dwConsolrelog.getDwTRefugo().getIdTrefugo());
		if(dwConsolre == null){
			
			dwConsolre = new DwConsolre();
			dwConsolre.setDwConsol(dwConsol);
			dwConsolre.setDwTRefugo(dwConsolrelog.getDwTRefugo());
			dwConsolre.setPcsAutoProducaorefugada(new BigDecimal(0));
			dwConsolre.setPcsManuProducaorefugada(new BigDecimal(0));
		}
		dwConsolre.setPcsAutoProducaorefugada(AritmeticaUtil.somar(dwConsolre.getPcsAutoProducaorefugada(), qtde));

		this.getDao().makePersistent(dwConsolre);
		

		DwConsolreoco dwConsolreoco = this.getDwConsolreoco(dwConsolre.getIdConsolre(), dwConsolrelog.getIdConsolrelog());
		if(dwConsolreoco == null){
			
			dwConsolreoco = new DwConsolreoco();
			dwConsolreoco.setDwConsolre(dwConsolre);
			dwConsolreoco.setDwConsolrelog(dwConsolrelog);
		}
		this.getDao().makePersistent(dwConsolreoco);

		if(dwRt != null){
			if(dwRt.getIsRegulagem() == null ){
				dwRt.setIsRegulagem(false);
			}

			// MÃ¡quina com planejamento
			dwRt.setIsSemplanejamento(false);

			// MÃ¡quina nÃ£o estÃ¡ offline
			dwRt.setIsOffline(false);
						
			//TODO milton calcular is_vidautilmolde

			//pcs_producaoliquida_op
			if(dwRt.getPcsProducaoliquidaOp() == null){
				dwRt.setPcsProducaoliquidaOp(BigDecimal.ZERO);
			}
			dwRt.setPcsProducaoliquidaOp(dwRt.getPcsProducaoliquidaOp().subtract(qtde));

			// Indica que estÃ¡ em produÃ§Ã£o
			this.getDao().makePersistent(dwRt);
		}
	}
	
	public List<DwConsolre> getDwConsolre(Long idDwConsol){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwConsolre FROM DwConsolre dwConsolre");
		q.append("where dwConsolre.dwConsol.idConsol = :idConsol");
		q.defineParametro("idConsol", idDwConsol);
		return q.list();
	}

	private DwConsolre getDwConsolre(long idConsol, long idTRefugo){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwConsolre FROM DwConsolre dwConsolre");
		q.append("where dwConsolre.dwConsol.idConsol = :idConsol");
		q.append("and dwConsolre.dwTRefugo.idTrefugo = :idTRefugo");
		q.defineParametro("idConsol", idConsol);
		q.defineParametro("idTRefugo", idTRefugo);
		q.setMaxResults(1);
		return (DwConsolre) q.uniqueResult();
	}
	/**
	 * Busca DwConsolrelog
	 * @param idPt
	 * @param dthrRefugo
	 * @return
	 */
	protected DwConsolrelog obtemDwConsolrelog(Long idPt, Date dthrRefugo){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("SELECT dwConsolrelog ");
		q.append("FROM DwConsolrelog dwConsolrelog ");
		q.append("WHERE dwConsolrelog.omPt.idPt = :idPt ");
		q.append("AND dwConsolrelog.dthrRefugo = :dthrRefugo");
		q.defineParametro("idPt", idPt);
		q.defineParametroTimestamp("dthrRefugo", dthrRefugo);
		DwConsolrelog dwConsolrelog = null;
		dwConsolrelog = (DwConsolrelog) q.query().uniqueResult();
		q = null;
		return(dwConsolrelog);
	}

	public DwConsolreoco getDwConsolreoco(long idConsolre, long idConsolrelog){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwConsolreoco FROM DwConsolreoco dwConsolreoco");
		q.append("where dwConsolreoco.dwConsolre.idConsolre = :idConsolre");
		q.append("and dwConsolreoco.dwConsolrelog.idConsolrelog = :idConsolrelog");
		q.defineParametro("idConsolre", idConsolre);
		q.defineParametro("idConsolrelog", idConsolrelog);
		q.setMaxResults(1);
		return (DwConsolreoco) q.uniqueResult();
	}
	
	
	/*
	 * Esse metodo retorna true se o NS n�o está refugado
	 */
	public boolean validaRefugoInovaSA(String ns , Long idRef){
		
		boolean retorno = false;
		MapQuery q = new MapQuery(this.getDao().getSession());
		
    	q.append("select dwnserie");
    	q.append("from DwNserie dwnserie");
    	q.append("where dwnserie.ns = :ns");
    	q.append("and dwnserie.dwEst.idEst = :idRef");

    	q.defineParametro("ns", ns);
    	q.defineParametro("idRef", idRef);
    	q.setMaxResults(1);
    	
    	 if((DwNserie) q.uniqueResult() == null){
    		 retorno = true;    		 
    	 }    	
    	
		return retorno;		
			
	}
	
}
