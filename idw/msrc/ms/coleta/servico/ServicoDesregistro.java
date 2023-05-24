package ms.coleta.servico;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import ms.coleta.dto.MensagemRecebida;
import ms.excessao.ServicoFalhouException;

public class ServicoDesregistro implements IServico {
	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		throw new ServicoFalhouException(null);
	}
}
