package ms.coleta.ic.sony.dvd;

import java.util.ArrayList;
import java.util.List;

import idw.util.IdwLogger;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsString;

public class LinhaArquivoSonyAIMHISBT {
	
	int posDateTime = EPosicoesDVDLog.DateTime.getValue();
	int posToteID = EPosicoesDVDLog.ToteID.getValue();
	int posOrderOKQuantity = EPosicoesDVDLog.OrderOKQuantity.getValue();
	int posOKQuantity = EPosicoesDVDLog.OKQuantity.getValue();
	int posShopOrder = EPosicoesDVDLog.ShopOrder.getValue();
	int posOrderQuantity = EPosicoesDVDLog.OrderQuantity.getValue();

	String dateTime;
	String toteID;
	String orderOKQuantity;
	String oKQuantity;
	String shopOrder;
	String orderQuantity;
	String origem;
	
	private String linha;
	private String[] linhas;
	private String linhaResumida;

	private IdwLogger log;
	private int idLog;
	
	private IcUpDTO icUpDTO;

	public LinhaArquivoSonyAIMHISBT(IdwLogger log, String linha, IcUpDTO icUpDTO) {
		super();
		this.log = log;
		idLog = log.getIdAleatorio();
		this.linha = linha;
		this.icUpDTO = icUpDTO;
		parseLinhaTratada();
	}
	
	
	private void parseLinhaTratada() {
		try {

			linhas =  idw.util.UtilsString.quebrarStringEmVetor(linha, ",").toArray(new String[0]);
			
			// this.dDateTime = UtilsString.removeApas(linhas[posDDateTime]);
			this.dateTime =  linhas[posDateTime];
			this.toteID = linhas[posToteID];
			this.orderOKQuantity = linhas[posOrderOKQuantity];
			this.oKQuantity = linhas[posOKQuantity];
			this.shopOrder = linhas[posShopOrder];
			this.orderQuantity = linhas[posOrderQuantity];
			
			this.origem = dateTime + "," + toteID + "," + orderOKQuantity + "," + oKQuantity + "," + shopOrder
					+ "," + orderQuantity;
			
		} catch (Exception e) {
			log.info(idLog, 0, "EventoLogSony: Excecao no setEventoDTO: " + e.toString()
					+ "\nLinha da Excecao no setEventoDTO: " + linhaResumida);
		}
	}

	public boolean isLinhaNoPadraoEsperado() {
		return ( (this.dateTime != null) && (!this.dateTime.equals("")) && (this.oKQuantity != null)
				&& (!this.oKQuantity.equals("")) && (this.shopOrder != null) && (!this.shopOrder.equals("")) );
	}
	
	@Override
	public String toString() {
		return (dateTime + "," + toteID + "," + orderOKQuantity + "," + oKQuantity + "," + shopOrder
				+ "," + orderQuantity);
	}

	public List<EventoColetado> obtemEvento() {
		List<EventoColetado> retorno = new ArrayList<>();
		
		EventoColetado eventoCiclo = geraEventoFimCiclo();
		if (eventoCiclo != null) {
			retorno.add(eventoCiclo);
		}
		
		return retorno;
	}

	private EventoColetado geraEventoFimCiclo() {
		EventoColetado eventoColetado = new EventoColetado();
		
		eventoColetado.setTipoEvento(ServicoFactory._FIM_CICLO); // Fim de Ciclo
		eventoColetado.setCdop(shopOrder);
		eventoColetado.setDthrEvento(UtilsString.dateTimeStringToDate(dateTime));
		eventoColetado.setQtde(oKQuantity);
		eventoColetado.setIcUpDTO(icUpDTO);
		eventoColetado.setOrigem(origem);
		
		return eventoColetado;
	}


	public String getShopOrder() {
		return shopOrder;
	}
	
	
}
