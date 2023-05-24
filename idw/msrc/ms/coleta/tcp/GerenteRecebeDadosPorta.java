package ms.coleta.tcp;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.dto.MensagemRecebida;
import ms.model.dto.IcDTO;

public class GerenteRecebeDadosPorta  extends Thread{

	// Abaixo fila FIFO thread safe com os eventos sequenciados para serem recebidos
	private BlockingQueue<MensagemRecebida> filaFIFO = new LinkedBlockingQueue<MensagemRecebida>();
	public String up;
	public String ip;
	private IdwLogger log;
	private IcDTO dadosicDTO;
	
	private boolean isExecutando = false;
	
	public GerenteRecebeDadosPorta(String up, String ip, IdwLogger log, IcDTO dadosicDTO) {
		super();
		this.up = up;
		this.ip = ip;
		this.log = log;
		this.dadosicDTO = dadosicDTO;
		
		setName("GerenteRecebeDadosPorta_"+ this.up);
	}
	
	// Insere na fila uma mensagem
	public boolean addMensagemRecebida(MensagemRecebida mensagemRecebida) {
		mensagemRecebida.setDataMensagemRecebida(new Date());
		return filaFIFO.offer(mensagemRecebida);
	}
	
	/* Processa a fila de eventos enquanto houver eventos */
	@Override
	public void run() {
		MensagemRecebida mensagemRecebida = null;
		isExecutando = true;
		do {
			mensagemRecebida = filaFIFO.poll();
			if (mensagemRecebida != null) {
				RecebeDadosPorta trecdad = new RecebeDadosPorta(ip, mensagemRecebida, log, dadosicDTO);
				trecdad.processaMensagem();
				if(mensagemRecebida.getDataMensagemRecebida() != null)
					log.info("Tempo para tratar mensagemRecebida = " + DataHoraRN.getQuantidadeMilisegundosNoPeriodo(mensagemRecebida.getDataMensagemRecebida(), new Date()) + "ms");
			} 
		} while (mensagemRecebida != null);

		// Saindo do run ou seja, thread parando execução
		isExecutando = false;
	}
	
	public boolean isExecutando() {
		return isExecutando;
	}
}
