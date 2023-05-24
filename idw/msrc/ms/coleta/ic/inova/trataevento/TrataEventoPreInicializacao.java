package ms.coleta.ic.inova.trataevento;

import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;

public class TrataEventoPreInicializacao extends TrataEvento {
	
	public TrataEventoPreInicializacao() {
	}
	
//	public TrataEventoPreInicializacao(String[] dadoRecebido, IcUpDTO lcup, Calendar dataEvento) {
//		super(dadoRecebido, lcup, dataEvento);
//	}
	
	@Override
	public EventoColetado trataEvento() {
		EventoColetado eventoColetado = new EventoColetado();
		
		eventoColetado.setTipoEvento(ServicoFactory._PRE_INICIALIZAR); // evento para o ms
		eventoColetado.setDthrEvento(dataEvento.getTime());
		eventoColetado.setExisteEvento(true);
		eventoColetado.setIcUpDTO(this.lcup);
		
		int paradaDefault = 0;
		
		if(dadoRecebido[10] != null) {
			try {
				paradaDefault = Integer.parseInt(dadoRecebido[10]);
			} catch(NumberFormatException e) {
				this.log.info(idLog, 0, e.getStackTrace());
			}
		}
		
		eventoColetado.setParadaDefault(paradaDefault);
		
		return(eventoColetado);
	}

}
