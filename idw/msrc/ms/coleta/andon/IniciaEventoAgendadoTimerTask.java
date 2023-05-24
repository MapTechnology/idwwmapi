package ms.coleta.andon;

import java.util.TimerTask;

import ms.coleta.dto.AndonDTO;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;

public class IniciaEventoAgendadoTimerTask extends TimerTask {
	private AndonDTO eventoTemporizadoAndon; 
	private IIC adam = null;		
	
	public IniciaEventoAgendadoTimerTask(AndonDTO eventoAndon, IIC adam) {
		this.eventoTemporizadoAndon = new AndonDTO(eventoAndon);			
		this.adam = adam;
	}
	
	@Override
	public void run() {
		try {
			System.out.print("Executando IniciaEventoAgendado ");
			if(this.eventoTemporizadoAndon.getTpeventoandon() == AndonDTO._EVENTO_ANDON_PARADA) {
				this.eventoTemporizadoAndon.setStativo(1);				
				adam.setUnicoDadoParametroParametroSaida(new ParametroDTO(this.eventoTemporizadoAndon));
				//System.out.println("evento de PARADA na saida " + this.eventoTemporizadoAndon.getIdrele());
			}
			if(this.eventoTemporizadoAndon.getTpeventoandon() == AndonDTO._EVENTO_ANDON_INSPECAO_PENDENTE) {
				// Desliga a saída digital
				this.eventoTemporizadoAndon.setStativo(0);
				adam.setUnicoDadoParametroParametroSaida(new ParametroDTO(this.eventoTemporizadoAndon));
				//System.out.println("desativando evento de INSPECAO PENDENTE na saida " + this.eventoTemporizadoAndon.getIdrele());
				Thread.sleep(1000);
				// Liga a saída digital após 1s, para visualização do usuário que houve o reinício do alerta.
				this.eventoTemporizadoAndon.setStativo(1);
				adam.setUnicoDadoParametroParametroSaida(new ParametroDTO(this.eventoTemporizadoAndon));
				//System.out.println("desativando evento de INSPECAO PENDENTE na saida " + this.eventoTemporizadoAndon.getIdrele());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
