package idw.model.rn.consolidacao.parada;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTParada;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwPeproTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.ParadaRN;
import idw.model.rn.consolidacao.EventoInvalidoException;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.model.rn.consolidacao.planejamento.ConsolidacaoPlanejamento;
import idw.util.IdwLogger;
import idw.util.Util;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoInicioParada extends ConsolidacaoParada implements IConsolidacao {
	
	public ConsolidacaoInicioParada(){		
	}
	
	public ConsolidacaoInicioParada(DAOGenerico dao){
		super(dao);
	}
	
	@Override
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwConsolPt,
			List<DwCalsem> dwCalsems, MsEvt msEvt, OmCfg omcfg, IdwLogger log,
			int idLog, int identacao) throws SemCalendarioException,
			SemSGBDException, SemCicloPadraoException,
			SemPlanejamentoException, RegistroDesconhecidoException, EventoInvalidoException {
		
		Validate.notNull(msEvt.getDthrEvento(), "Inicio de parada esta nulo");
		
		Date dtHrInicioParada = msEvt.getDthrEvento();

		Validate.notNull(omPt, "Posto de trabalho esta nulo");
		Validate.notNull(omPt.getIdPt(), "idPt esta nulo");		
		
		DwConsolpalog ultimaParada = this.getUltimaParadaFromDwConsolpalog(omPt);

		// Verifica já teve alguma parada e se o inicio eh o mesmo da parada que se quer iniciar. Se for cancelar
		if(ultimaParada != null && ultimaParada.getDthrIparada() != null ){

			// Se parada anterior for igual a atual, indica que jÃ¡ foi tratada, evento serÃ¡ descartado
			if (DataHoraRN.compareTo(ultimaParada.getDthrIparada(), dtHrInicioParada) == 0) {
				throw new EventoInvalidoException(msEvt, "Parada já está no banco de dados. " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtHrInicioParada));
			}			

			// Se parada anterior estiver aberta, descartar evento			
			if (ultimaParada.isAberta()) {
				throw new EventoInvalidoException(msEvt, "Já existe uma parada aberta.");
			}

			// Inicio de parada deve ser maior que o fim da ultima parada
			if(ultimaParada.getDthrFparada() != null){
				// Fim da parada anterior deve ser menor ou igual ao inicio da proxima
				if (DataHoraRN.compareTo(ultimaParada.getDthrFparada(), dtHrInicioParada) > 0) {
					throw new EventoInvalidoException(msEvt, "Fim da parada anterior e maior que o inicio da nova."
						+ " Fim da anterior: " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(ultimaParada.getDthrFparada())
						+ " Início da nova: " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtHrInicioParada));
				}
			}

		}
		
		validarEventoDeveSerMaiorUltimoEventoConsolidado(dwConsolPt, dtHrInicioParada);

		ultimaParada = null;

		String cdParada = msEvt.getCdParada();
		// Se cdParada estiver preenchido, pegar referencia da parada de DwTParada
		DwTParada dwTParada = null;
		if(StringUtils.isEmpty(cdParada) || (cdParada != null && (cdParada.equals("null") || cdParada.equals("") ) ) ){
			// Pegar codigo de parada default
			OmCfg omCfg = Util.getConfigGeral(this.getDao().getSession());

			Validate.validState(omCfg != null, "Configuracao nao encontrada. OmCfg nulo.");
			if (msEvt.getDwPepro() != null && msEvt.getDwPepro().getIdPepro() == DwPeproTemplate.Type.CONTROLE_REINICIO_DE_PROCESSO.getId())
				dwTParada = omCfg.getDwTParadaByIdTparadacip();
			
			if (dwTParada == null)
				dwTParada = omCfg.getDwTParada();

			Validate.validState(dwTParada != null, "Parada padrao nao encontrada. (OmCfg.dwTparada nulo)");
			
			// Usar como referencia o codigo da parada default na configuracao
			cdParada = dwTParada.getCdTparada();
		}

		PpCp ppCp = obtemPpCp(log, idLog, identacao, omPt, dwCalsems, msEvt, omcfg);
		Validate.notNull(ppCp, "ppCp eh nulo");
		
		ppCp.mudarDthrIniciorealIfNull(dtHrInicioParada);
		
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		DwFolha dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
		Validate.notNull(dwFolha,"nao tem folha ativa para o ppCp");
		
		ParadaRN paradaRN = new ParadaRN(this.getDao());
		try {
			dwTParada = paradaRN.getDwTParada(cdParada, omPt.getOmTppt());
			
			// Se a parada existir verificar se a descricao eh igual ao que veio no cb
			if (dwTParada != null && msEvt.getCb() != null && msEvt.getCb().equals("") == false && dwTParada.getDsTparada().equals(msEvt.getCb()) == false) {
				dwTParada.setDsTparada(msEvt.getCb());
				getDao().makePersistent(dwTParada);
			}
		} catch (RegistroDesconhecidoException e) {
			
			DwTArea dwTAreaPadrao = null;
			if (omcfg != null) {
				DwTParada paradaPadrao = omcfg.getDwTParada();
				if(paradaPadrao != null) {
					dwTAreaPadrao = paradaPadrao.getDwTArea();
				}
			}
			String dsParada ;
			if (msEvt.getCb() != null && msEvt.getCb().equals("") == false) {
				dsParada = msEvt.getCb();
			} else {
				dsParada = "Cadastrada ao consolidar inicio de parada";
			}

			dwTParada = paradaRN.salvarDesativandoOriginal(cdParada, dsParada, omPt.getOmTppt(), dwTAreaPadrao, null, null);
			log.info("Parada " + cdParada + " cadastrada automaticamente ao consolidar inicio de parada");
			
		}
	
		boolean isVarRitmo = isMaquinaComTempoParadaDentroTempoCiclo(omPt);
		
		// Atualiza pojo DwConsolpalog
		DwConsolpalog dwConsolpalog = new DwConsolpalog();
		dwConsolpalog.setIdConsolpalog(null);
		dwConsolpalog.setDthrIparada(dtHrInicioParada);
		dwConsolpalog.setOmPt(omPt);
		dwConsolpalog.setDwTParada(dwTParada);
		dwConsolpalog.setPpCp(ppCp);
		dwConsolpalog.setDthrFparadaAb(dtHrInicioParada);
		
		// Se parada nao contar para tempo ativo, sera marcada como parada de variaçãoo de ritmo (tempo de parada ja esta contida no tempo do ciclo)
		dwConsolpalog.setIsVarritmo(isVarRitmo);		
		
		getDao().makePersistent(dwConsolpalog);
		
		dwConsolPt.setDwConsolpalog(dwConsolpalog);
		
//		consolidarTempoParada(false, true, omPt, dwConsolPt, dwCalsems, ppCp, dwFolha, omcfg, log, 
//				idLog, 0, msEvt.getDwPepro(), dwConsolpalog, dtHrInicioParada, dtHrInicioParada);
		
		ConsolidacaoPeriodoParada consolidacaoPeriodoParada = 
				new ConsolidacaoPeriodoParada(log, idLog, identacao, this, omcfg, dwConsolPt, ppCp, dwFolha, msEvt.getDwPepro(), true);
		
		consolidacaoPeriodoParada.consolidar(false, dtHrInicioParada, dtHrInicioParada, dwConsolpalog, dtHrInicioParada, "ConsolidacaoInicioParada");
		
		ConsolidacaoPlanejamento consolidacaoPlanejamento = new ConsolidacaoPlanejamento(getDao());
		consolidacaoPlanejamento.setInicioPpCpentsai(ppCp, omPt, dtHrInicioParada);
		
	}
	
}
