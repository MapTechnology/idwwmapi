package ms.coleta.ic.automata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class LinhaArquivoAutomata {

	private final static String OP_VALOR_PADRAO = "op";
	private final static String PADRAO_DATA_HORA_COM_SEGUNDOS = "yyyy-MM-dd HH:mm:ss";
	private final static String PADRAO_DATA_HORA_SEM_SEGUNDOS = "yyyy-MM-dd HH:mm";
	private final static boolean IS_USAR_HORA_LOCAL_NAS_DATAS_SEM_SEGUNDOS = true;

	private String tipoDeDadoDaLinha;
	private String op;
	
	private boolean isParada = false;

	//VALORES DO ARQUIVO
	private String valorStatus;
	private String valorAlarm;
	private String valorCodigoParada;
	private String valorSpc;
	private String valorDataHora;

	private String valorDataHoraInicioParada;

	//VALORES DO STATUS
	private Bit bit;
	private boolean isAlarmeEmAndamento;
	private boolean isInicioDeCiclo;
	private boolean isMaquinaEmAmbienteManutencao;
	private boolean isInicioDeInjecao;

	private LinhaArquivoAutomata instancia;

	private List<LinhaArquivoAutomata> bufferEventosShopOrder;

	// Controle
	private String linha;
	private String linhaResumida;
	private String[] colunas;

	private IdwLogger log;
	private int idLog;
	private ICAutomata ic;
	private IcUpDTO icUpDTO;

	public LinhaArquivoAutomata() {
		super();
	}

	public LinhaArquivoAutomata(IdwLogger log, String linha, ICAutomata ic, IcUpDTO icUpDTO) {
		super();
		this.log = log;
		idLog = log.getIdAleatorio();
		this.linha = linha;
		this.ic = ic;
		this.icUpDTO = icUpDTO;
		parseLinhaTratada();
	}

	private void parseLinhaTratada() {
		colunas =  idw.util.UtilsString.quebrarStringEmVetor(linha, ";").toArray(new String[0]);
		removePrimeiroCaracterDasStringSeForEspacoBranco(colunas);
		
		if(isLinhaNoPadraoEsperado() == false) {
			return;
		}
		
		this.op = OP_VALOR_PADRAO;
		
		tipoDeDadoDaLinha = colunas[0];
		if(tipoDeDadoDaLinha.equals(ETipoDeDado.STATUS_DA_MAQUINA.getValue())){
			tratarLinhaStatusDaMaquina();
		} else if(tipoDeDadoDaLinha.equals(ETipoDeDado.DADOS_DO_PROCESSO.getValue())) {
			tratarLinhaSPC();
		} else if(tipoDeDadoDaLinha.equals(ETipoDeDado.ALARME.getValue())) {
			tratarLinhaAlarm();
		} else if(tipoDeDadoDaLinha.equals(ETipoDeDado.CODIGO_DE_PARADA.getValue())) {
			tratarLinhaParada();
		}
	}

	private void tratarLinhaStatusDaMaquina() {
		setStatus(colunas[1]);
		valorDataHora = colunas[2];
	}

	private void tratarLinhaSPC() {
		//TODO implementar
	}

	private void tratarLinhaAlarm() {
		//TODO implementar
	}

	private void tratarLinhaParada() {
		valorCodigoParada = colunas[1];
		valorDataHoraInicioParada = colunas[2];
	}

	private void setStatus(String s) {
		valorStatus = s;
		bit = new Bit(valorStatus);
		isAlarmeEmAndamento = bit.getValorDaPosicao(EPosicoesStatus.ALARME_EM_ANDAMENTO.getValue());
		isInicioDeCiclo = bit.getValorDaPosicao(EPosicoesStatus.INICIO_DE_CICLO.getValue());
		isMaquinaEmAmbienteManutencao = bit.getValorDaPosicao(EPosicoesStatus.MAQUINA_EM_AMBIENTE_MANUTENCAO.getValue());
		isInicioDeInjecao = bit.getValorDaPosicao(EPosicoesStatus.INICIO_DE_INJECAO.getValue());
	}

	private EventoColetado geraEventoInicioCiclo() {
		EventoColetado eventoColetado = new EventoColetado();
		eventoColetado.setTipoEvento(ServicoFactory._INICIO_CICLO);
		eventoColetado.setDthrEvento(getDataComOuSemSegundo(valorDataHora));
		eventoColetado.setCdop(op);
		eventoColetado.setIcUpDTO(icUpDTO);
		eventoColetado.setOrigem(linha);
		return eventoColetado;
	}

	private EventoColetado geraEventoInicioParada() {
		this.isParada = true;
		EventoColetado eventoColetado = new EventoColetado();
		eventoColetado.setTipoEvento(ServicoFactory._INICIO_PARADA);
		eventoColetado.setDthrEvento(getDataComOuSemSegundo(valorDataHoraInicioParada));
		eventoColetado.setCdparada(valorCodigoParada);
		eventoColetado.setCdop(op);
		eventoColetado.setIcUpDTO(icUpDTO);
		eventoColetado.setOrigem(linha);
		return eventoColetado;
	}

	//TODO NULLPOINT - eventoColetado.setCdparada(linhaParadaAberta.getValorCodigoParada());
	private EventoColetado geraEventoFimParada() {
		
		LinhaArquivoAutomata linhaParadaAberta = ic.obtemUltimaParadaOp(op);
		ic.removerUltimaParadaOp(op);
		
		if(linhaParadaAberta == null) {
			return null;
		}
		
		EventoColetado eventoColetado = new EventoColetado();
		eventoColetado.setTipoEvento(ServicoFactory._FIM_PARADA);
		eventoColetado.setDthrEvento(getDataComOuSemSegundo(valorDataHora));
		eventoColetado.setCdparada(linhaParadaAberta.getValorCodigoParada());
		eventoColetado.setCdop(op);
		eventoColetado.setIcUpDTO(icUpDTO);
		eventoColetado.setOrigem(linha);
		return eventoColetado;
	}

	private void removePrimeiroCaracterDasStringSeForEspacoBranco(String[] array) {
		for(int i=0; i<array.length; i++) {
			if(array[i].startsWith(" ")){
				array[i] = array[i].substring(1);
			}
		}
	}

	private Date getDataComOuSemSegundo(String texto) {
		Date data = null;
		
		try {
		
			if(isFormatoValido(PADRAO_DATA_HORA_SEM_SEGUNDOS, texto)) {
				data = DataHoraRN.toDateFrom(PADRAO_DATA_HORA_SEM_SEGUNDOS, texto);
				
				if(IS_USAR_HORA_LOCAL_NAS_DATAS_SEM_SEGUNDOS) {
					data = new Date();
					
					//Date dataLocal = new Date();
					//int segundos = DataHoraRN.getApenasSegundos(dataLocal);
					//data = DataHoraRN.adicionaSegundosNaData(data, segundos);
				}
				
			} else {
				data = DataHoraRN.toDateFrom(PADRAO_DATA_HORA_COM_SEGUNDOS, texto);
			}
		
		} catch (ParseException ex) {
			ex.printStackTrace();
			log.info("Excessao: ", ex);
	    }
		
		return data;
	}

	private boolean isFormatoValido(String formato, String valor) {
		Date data = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            data = sdf.parse(valor);
            if (!valor.equals(sdf.format(data))) {
                data = null;
            }
        } catch (ParseException ex) {
        	
        }
        return data != null;
    }

	public boolean isLinhaNoPadraoEsperado() {
		if(colunas == null || colunas.length == 0) {
			return false;
		}
		return true;
	}

	public List<EventoColetado> obtemEvento() {
		List<EventoColetado> retorno = new ArrayList<>();
		
		if(tipoDeDadoDaLinha.equals(ETipoDeDado.STATUS_DA_MAQUINA.getValue())){
			
			EventoColetado eventoFimParada = geraEventoFimParada();
			if(eventoFimParada != null) {
				retorno.add(eventoFimParada);
			}
			
			
			if(isInicioDeCiclo) {
				retorno.add(geraEventoInicioCiclo());
			}
			
		} else if(tipoDeDadoDaLinha.equals(ETipoDeDado.DADOS_DO_PROCESSO.getValue())) {
			
		} else if(tipoDeDadoDaLinha.equals(ETipoDeDado.ALARME.getValue())) {
			
		} else if(tipoDeDadoDaLinha.equals(ETipoDeDado.CODIGO_DE_PARADA.getValue())) {
			retorno.add(geraEventoInicioParada());			
		}

		return retorno;
	}

	public LinhaArquivoAutomata getInstancia() {
		return instancia;
	}

	public void setInstancia(LinhaArquivoAutomata instancia) {
		this.instancia = instancia;
	}

	public List<LinhaArquivoAutomata> getBufferEventosShopOrder() {
		return bufferEventosShopOrder;
	}

	public void setBufferEventosShopOrder(
			List<LinhaArquivoAutomata> bufferEventosShopOrder) {
		this.bufferEventosShopOrder = bufferEventosShopOrder;
	}

	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	public String getLinhaResumida() {
		return linhaResumida;
	}

	public void setLinhaResumida(String linhaResumida) {
		this.linhaResumida = linhaResumida;
	}

	public String[] getColunas() {
		return colunas;
	}

	public void setColunas(String[] colunas) {
		this.colunas = colunas;
	}

	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}

	public int getIdLog() {
		return idLog;
	}

	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}

	public ICAutomata getIc() {
		return ic;
	}

	public void setIc(ICAutomata ic) {
		this.ic = ic;
	}

	public IcUpDTO getIcUpDTO() {
		return icUpDTO;
	}

	public void setIcUpDTO(IcUpDTO icUpDTO) {
		this.icUpDTO = icUpDTO;
	}

	public String getOp() {
		return op;
	}

	public boolean isParada() {
		return isParada;
	}

	public String getValorCodigoParada() {
		return valorCodigoParada;
	}
	
	
	
}
