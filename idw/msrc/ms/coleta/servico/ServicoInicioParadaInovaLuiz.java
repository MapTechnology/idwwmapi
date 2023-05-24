package ms.coleta.servico;

import java.util.Calendar;
import java.util.Map;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.rn.UpRN;

public class ServicoInicioParadaInovaLuiz  implements IServico {
	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		
				// passando a data do evento para calendar
				Calendar dataEvento = Calendar.getInstance();
				dataEvento.setTime(mensagem.getEventoColetado().getDthrEvento());
				
				Integer paradaDefault = mensagem.getEventoColetado().getParadaDefault();
				
				// montando parametro de retorno
				ParametroDTO parametro = new ParametroDTO();
				
				parametro.setTipoEvento(mensagem.getEventoColetado().getTipoEvento());
				parametro.setDataHoraEvento(dataEvento);
				parametro.setParadaDefault(paradaDefault);
				
				mensagem.getIc().setParametro(parametro);
				
				return null;
				
			}

}
