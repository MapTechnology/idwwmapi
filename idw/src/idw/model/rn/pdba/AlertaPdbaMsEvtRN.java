package idw.model.rn.pdba;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.IdwFacade;
import idw.model.pojos.DwConsolallog;
import idw.model.pojos.DwTAlerta;
import idw.model.pojos.MsEvt;
import idw.model.pojos.template.MsEvtTemplate;
import idw.model.rn.AlertaRN;
import idw.model.rn.DataHoraRN;
import injetws.webservices.dto.IwsAlertaDTO;
import injetws.webservices.dto.IwsListaAlertaDTO;
import ms.coleta.servico.ServicoFactory;

public class AlertaPdbaMsEvtRN extends AbstractPdbaMsEvtRN{

	/*
	 * Esse metododo � a substituicao do metodo com mesmo nome do injetws. Seu objetivo � chamar o metodo do inejtws e salvar o evento tambem em msevt
	 */
	public boolean setTr_alertaInicio(String idUp, String cdAlerta, Date dthrInicio){
		// Atencao: O servico do alerta tb eesta chamando o injetws abaixo e no momento a chamada abaixo
		// nao pode ser removida pois eh necessario retornar o resultado do mesmo.
		// Alem disso, o servico de inicio do alerta nao grava em msEvt. Entao inclui um flag no evento
		// para avisa-lo que nao deve chamar o injetws e alterei o servico do alerta para incluir em msevt
		boolean retorno = true;
		
		try {
			MsEvt msevt = executarServico(null, idUp, cdAlerta, dthrInicio, null, null, ServicoFactory._INICIA_ALERTA, "setTr_alertaInicio " + DataHoraRN.getDataHoraAtualFormatada());
			retorno = !msevt.getStEvt().equals(MsEvtTemplate.StEvt.REJEITADO.getValueBigDecimal());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retorno;

	}



	public boolean setTr_alertaFim(String idUp, String cdAlerta, Date dthrFim){
		// Atencao: O servico do alerta tb eesta chamando o injetws abaixo e no momento a chamada abaixo
		// nao pode ser removida pois eh necessario retornar o resultado do mesmo.
		// Alem disso, o servico de inicio do alerta nao grava em msEvt. Entao inclui um flag no evento
		// para avisa-lo que nao deve chamar o injetws e alterei o servico do alerta para incluir em msevt
		boolean retorno = true;

		try {
			MsEvt msevt = executarServico(null, idUp, cdAlerta, dthrFim, null, null, ServicoFactory._REMOVE_ALERTA, "setTr_alertaFim " + DataHoraRN.getDataHoraAtualFormatada());
			retorno = !msevt.getStEvt().equals(MsEvtTemplate.StEvt.REJEITADO.getValueBigDecimal());
		} catch (Exception e){
			e.printStackTrace();
		}
		return retorno;
	}
	
	public IwsAlertaDTO getTr_TabAlertaSetaCod(String cdAlerta) {
		
		IwsAlertaDTO retorno = null;
		
		AlertaRN rn = new AlertaRN();
		try {
			rn.iniciaConexaoBanco();

			retorno = new IwsAlertaDTO();

			DwTAlerta dwtalerta = null;
			List<DwTAlerta> lista = rn.pesqusiarTodosDwTAlertaAtivos();
			for (DwTAlerta tal : lista) {
				if (tal.getCdTalerta().equals(cdAlerta) && tal.getOmTppt().isMaquinaCiclica()) {
					dwtalerta = tal;
				}
			}
			// Se encontoru o alerta e o mesmo nao eh automatico
			if (dwtalerta != null && (dwtalerta.getIsAutomatico() == null || dwtalerta.getIsAutomatico() == false) ){
				retorno.setCdAlerta(dwtalerta.getCdTalerta());
				retorno.setDsAlerta(dwtalerta.getDsTalerta());
				retorno.setIdAlerta(String.valueOf(dwtalerta.getIdTalerta()));
			} else {
				retorno = new IwsAlertaDTO();
				retorno.setCdAlerta("");
			}

		} catch (Exception e) {
			e.printStackTrace();
			retorno = new IwsAlertaDTO();
			retorno.setCdAlerta("");
		} finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}

	
	public IwsListaAlertaDTO getTr_alertasAbertos(String cdMaquina){
		IwsListaAlertaDTO retorno = null;
		
		List<DwConsolallog> lista = IdwFacade.getInstancia().getDwConsolalComAlertaAberto(cdMaquina);
		retorno = new IwsListaAlertaDTO();
		List<IwsAlertaDTO> listaAlertas = new ArrayList<IwsAlertaDTO>();

		for (DwConsolallog log : lista) {
			IwsAlertaDTO dto = new IwsAlertaDTO();
			dto.setCdAlerta(log.getDwTAlerta().getCdTalerta());
			dto.setDsAlerta(log.getDwTAlerta().getDsTalerta());
			dto.setdthrinialerta(log.getDthrIalerta());
			dto.setIdAlerta(String.valueOf(log.getDwTAlerta().getIdTalerta()));
			dto.setIdRevisao(1);
			dto.setmsDtHrIniAlerta(0d);
			dto.setStAlerta(1);
			dto.setTempolimite(0d);
			dto.setTpAlerta(1);
			
			listaAlertas.add(dto);
		}
		retorno.setAlertas(listaAlertas);
		
		return retorno;
	}
}
