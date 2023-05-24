package ms.coleta.ic.juki;

import idw.util.IdwLogger;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

import org.apache.commons.vfs2.impl.DefaultFileMonitor;

public abstract class JukiWatcher {
	public abstract void iniciarWatcher();

	protected IdwLogger log;
	private ICJuki ic;
	protected DefaultFileMonitor fm = null;
	private List<String> caminhos = new ArrayList<>(); // Urls de Conexao
	private List<IcUpDTO> icUpDTOList = new ArrayList<IcUpDTO>();

	private List<TratadorHeartBeat> tratadorHeartBeatList = new ArrayList<TratadorHeartBeat>();

	public JukiWatcher(ICJuki ic, IdwLogger log) {
		super();
		this.ic = ic;
		this.log = log;
	}

	public void addDiretorio(String caminho) {
		log.info("adicionando " + caminho);
		caminhos.add(caminho);
	}

	public void addIcUpDTO(IcUpDTO icUpDTO) {
		log.info("adicionando " + icUpDTO.getUpDTO().getCd_up());
		icUpDTOList.add(icUpDTO);
	}

	public void finalizar() {
		log.info("Finalizando watcher");
		fm.stop();
		mataTratadoresHeartBeat();
	}

	public void monitoraHeartBeat(List<IcUpDTO> list) {
		// Monitora a necessidade de lancar parada automatica
		// e lanca a parada se necessario
		// monitoraParadaAutomatica();

		// Lança evento de HeartBeat
		// Como e criado um watcher por IC, basta lancar aqui um evento de HeartBeat
		List<EventoColetado> eventos;
		for (IcUpDTO auxIcUpDTO : list) {
			if (auxIcUpDTO.getUrlConexao() != null
					&& !auxIcUpDTO.getUrlConexao().equals("")) {
				File caminhoRemoto = new File (auxIcUpDTO.getUrlConexao());
				if (caminhoRemoto.exists()) {
					eventos = geraEventoHeartBeat(new Date(), auxIcUpDTO);
					getIc().getBufferEventos().addEventos((eventos));
				}
			}
		}
	}

	protected List<EventoColetado> geraEventoHeartBeat(Date dataEvento, IcUpDTO icupdto) {
		EventoColetado eventoColetado = new EventoColetado();

		eventoColetado.setTipoEvento(ServicoFactory._IC_HEART_BEAT); // Fim de Ciclo
		eventoColetado.setDthrEvento(dataEvento);
		eventoColetado.setCb("");
		eventoColetado.setIcUpDTO(icupdto);
		// eventoColetado.setOrigem("SonyWatcher: Parada Automatica Lancada Pela Coleta");
		eventoColetado.setOrigem("");

		List<EventoColetado> eventos = new ArrayList<EventoColetado>();
		eventos.add(eventoColetado);

		log.info("JukiWatcher: Gerou evento de Heart Beat:;"
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventoColetado.getDthrEvento())
				+ ";" + eventoColetado.getCdop());

		return eventos;
	}

	public void mataTratadoresHeartBeat() {
		if (tratadorHeartBeatList.size() > 0) {
			for (TratadorHeartBeat a : tratadorHeartBeatList) {
				// a.stop();
				a.setContinuarExecutando(false);
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				log.error("Falha ao dar sleep para matar threads de HeartBeat"+e);
			}
		}
	}

	public void addTratadorHeartBeat(TratadorHeartBeat novo) {
		if (novo != null) {
			for (TratadorHeartBeat a : tratadorHeartBeatList) {
				if (a.getName().equals("monitoraHeartBeatJuki")) {
					a.setContinuarExecutando(false);
					tratadorHeartBeatList.remove(a);
				}
			}
			tratadorHeartBeatList.add(novo);
		}
	}

	public DefaultFileMonitor getFm() {
		return fm;
	}

	public void setFm(DefaultFileMonitor fm) {
		this.fm = fm;
	}

	protected ICJuki getIc() {
		return ic;
	}

	protected void setIc(ICJuki ic) {
		this.ic = ic;
	}

	public List<String> getCaminhos() {
		return caminhos;
	}

	protected void setCaminhos(List<String> caminhos) {
		this.caminhos = caminhos;
	}

	protected List<IcUpDTO> getIcUpDTOList() {
		return icUpDTOList;
	}

	protected void setIcUpDTOList(List<IcUpDTO> icUpDTOList) {
		this.icUpDTOList = icUpDTOList;
	}

}
