package ms.coleta.protocolo;

import idw.model.IdwFacade;
import idw.model.rn.DataHoraRN;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsString;

public class ProtocoloEntradaNovo extends ProtocoloEntradaFactory{

	private final MensagemRecebida mensagemRecebida;
	
	public ProtocoloEntradaNovo(MensagemRecebida mensagem) {
		super();
		this.mensagemRecebida = mensagem;
	}
	
	public String getArg(List<String> args, int index) {
		if(args == null || index > args.size() || index < 0)
			return null;
		return args.get(index-1);
	}
	
	public IcUpDTO getIcUpDTO(MensagemRecebida mensagemRecebida) {
		// Localiza o msicupdto dentro da lista de MsIcDTOLocal.msicupdtolocais
		for(IcUpDTO msicupdto : mensagemRecebida.getDadosIcDTO().getMsIcUpDTOLocais()) {
			
			String up = mensagemRecebida.getUp();
			
			if (up == null || up.equals("")) {
				mensagemRecebida.getLog().info("A UP nao foi passada na mensagem, entao assumindo " + msicupdto.getIdIcUp());
				return msicupdto;
			} else if(msicupdto.getUpDTO().getCd_up().equals(up)) {
				mensagemRecebida.getLog().info("Encontrou a up " + up);
				return msicupdto;
			} else {
				mensagemRecebida.getLog().info("Pesquisando a up " + up + " na lista msicupdtolocais no item msicupdtolocal " + msicupdto.getIdIcUp() + " sem encontrar.");
			}
		}
		return Stubedelegate.getInstancia().getMsthread().getIcUp(mensagemRecebida.getUp());
	}
	
	private Map<String, String> getEvtArgs(String mensagem) {
		Map<String, String> evtArgs = new HashMap<String, String>();
		String evtArgNumberString = "0";
		int evtArgNumber = 0;
		try{
			evtArgNumberString = UtilsString.getValorFromSecaoChave(mensagem, "evtarg", "n");
			evtArgNumber = Integer.parseInt(evtArgNumberString);
		} catch (Exception e){
		}
		
		evtArgs.put("n", evtArgNumberString);
		for(int evtArgIndex = 1; evtArgIndex <= evtArgNumber; evtArgIndex++) {
			String evtArgIndexString = String.valueOf(evtArgIndex);
			String evtArg = UtilsString.getValorFromSecaoChave(mensagem, "evtarg", evtArgIndexString);
			//System.out.println(evtArgIndexString + "=" + evtArg);
			evtArgs.put(evtArgIndexString, evtArg);
		}
		return evtArgs;
	}
	
	@Override
	public EventoColetado criarEventoColetado() {
		EventoColetado retorno = new EventoColetado();
		String mensagem = mensagemRecebida.getMensagemRecebidaTcp();
		
		retorno.setExisteEvento(true);
		retorno.setLog(mensagemRecebida.getLog());
		retorno.setIdentacao(mensagemRecebida.getIdentacao());
		retorno.setIdLog(mensagemRecebida.getIdLog());
		retorno.setOrigem(mensagemRecebida.getMensagemRecebidaTcp());
		
		retorno.setTipoEvento(Integer.parseInt(UtilsString.getValorFromSecaoChave(mensagem, "evt", "ac")));
		retorno.setIdEvt(new BigDecimal(UtilsString.getValorFromSecaoChave(mensagem, "evt", "id")));
		retorno.setCdop(UtilsString.getValorFromSecaoChave(mensagem, "evt", "nrop"));
		retorno.setUp(mensagemRecebida.getUp());
		retorno.setIcUpDTO(getIcUpDTO(mensagemRecebida));
		String dthrEventoString = UtilsString.getValorFromSecaoChave(mensagem, "evt", "dthr");

		Date dthrevento = (dthrEventoString != null && dthrEventoString.equals("") == false) ? 
				DataHoraRN.stringToDate(dthrEventoString, "yyyy-MM-dd HH:mm:ss.SSS") :
				IdwFacade.getInstancia().getDataHoraServidorBanco();
		retorno.setDthrEvento(dthrevento);
		
		
		Map<String, String> evtArgs = getEvtArgs(mensagem);

		try{
			ServicoFactory.getInstancia().getProtocolo(retorno.getTipoEvento()).parseEvtArgs(retorno, evtArgs);
		}catch(Exception e) {
			e.printStackTrace();
			if(retorno.getLog() != null)
				retorno.getLog().info("Falha em parseEvtArgs(servico=" + retorno.getTipoEvento() + ")");
		}

		return retorno;
	}

	@Override
	public String getCdUp(String clientSentence) {
		return UtilsString.getValorFromSecaoChave(clientSentence, "evt", "up");
	}
	
}
