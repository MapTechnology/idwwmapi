package ms.coleta.servico;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import ms.coleta.dto.MensagemRecebida;
import ms.excessao.ServicoFalhouException;

public interface IServico {
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException;
}
