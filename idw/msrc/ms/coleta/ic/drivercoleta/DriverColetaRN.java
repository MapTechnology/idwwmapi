package ms.coleta.ic.drivercoleta;

import idw.util.IdwLogger;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import ms.model.MsFacade;
import ms.model.dto.IcDTO;
import ms.util.UtilsThreads;

public class DriverColetaRN {
	
	private IdwLogger log = null;
	private String pathRelativo;
	private ColetaArquivoMaquinas coletas = null;
	private TratadorHeartBeat tratadorHeartBeat = null;

	public enum ColetaFileType {
		UNKOWN, 
		MITRASTAR_TX, 
		MITRASTAR_RX, 
		MITRASTAR_PK, 
		MITRASTAR_24G, 
		MITRASTAR_5G, 
		MITRASTAR_PT, 
		MITRASTAR_FTP,
		MITRASTAR_SSID, 
		ASKEY
	}
	
	public DriverColetaRN(String pathRelativo, IdwLogger log) {
		this.log=log;
		this.pathRelativo=pathRelativo;
		this.coletas = new ColetaArquivoMaquinas(this.pathRelativo, this.log);
		log.info("DriverColetaRN INICIALIZADO");
	}
	
	public static ColetaFileType getFileType(String fileTypeString) {
		if(fileTypeString.equalsIgnoreCase("TX")) {
			return ColetaFileType.MITRASTAR_TX;
		} else if(fileTypeString.equalsIgnoreCase("RX")) {
			return ColetaFileType.MITRASTAR_RX;
		} else if(fileTypeString.equalsIgnoreCase("PT")) {
			return ColetaFileType.MITRASTAR_PT;
		} else if(fileTypeString.equalsIgnoreCase("PK")) {
			return ColetaFileType.MITRASTAR_PK;
		} else if(fileTypeString.equalsIgnoreCase("2.4G") || fileTypeString.equalsIgnoreCase("24G")) {
			return ColetaFileType.MITRASTAR_24G;
		} else if(fileTypeString.equalsIgnoreCase("5G")) {
			return ColetaFileType.MITRASTAR_5G;
		} else if(fileTypeString.equalsIgnoreCase("FTP")) {
			return ColetaFileType.MITRASTAR_FTP;
		} else if(fileTypeString.equalsIgnoreCase("SSID")) {
			return ColetaFileType.MITRASTAR_SSID;
		} else {
			return ColetaFileType.UNKOWN;
		}
	}

	public void avaliarUpsParaProcessamento(){

		log.info("avaliarUpsParaProcessamento - INICIO");

		InetAddress ip;
		IcDTO icdto = new IcDTO();

		try {

			//Descobre qual o mac da maquina para procurar o IC relativo.
			// Deprecated
			ip = InetAddress.getLocalHost();
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);

			byte[] mac = network.getHardwareAddress();
			
			StringBuilder sb = new StringBuilder(18);
		    for (byte b : mac) {
		        if (sb.length() > 0)
		            sb.append(':');
		        sb.append(String.format("%02x", b));
		    }
		    // End Deprecated
		    
			do{
				//Busca ICs associados ao mac da maquina.
				try{
					// icdto = MsFacade.getInstancia().pesquisarMsIcPorUrlConexao(sb.toString().toUpperCase());
					icdto = MsFacade.getInstancia().pesquisarMsIcPorUrlConexao("IC_ColetaIM");

					if(icdto == null || icdto.getPortas() == null)
					{
						//this.log.info("Nenhuma UP assossiada ao IC de mac " + sb.toString().toUpperCase() + " tentando novamente em 10 segundos");
						this.log.info("Nenhuma UP assossiada ao IC com url de conexao IC_ColetaIM tentando novamente em 60 segundos");
					}
				} catch(Exception e)
				{
					e.printStackTrace();
				} finally {
					UtilsThreads.pausaNaThread(60000);
				}
			}while(icdto == null || icdto.getPortas() == null);

			this.log.iniciaAvaliacao("atualizaColetas");
			//Cria Threads para Monitorar Pasta de Logs e para Tratar os Logs copiados
			coletas.atualizaColetas(icdto.getPortas());
			
			verificaThreadHeartBeat (icdto);
			this.log.getAvaliacaoCompleta();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		log.info("avaliarUpsParaProcessamento - FIM");
	}

	private void verificaThreadHeartBeat(IcDTO icdto) {
		if (tratadorHeartBeat == null) {
			tratadorHeartBeat = new TratadorHeartBeat(icdto, log);
			tratadorHeartBeat.setName("tratadorHeartBeat_" + icdto.getCd_ic());
			
			tratadorHeartBeat.start();
		} else if (!tratadorHeartBeat.getIcdto().getCd_ic().equals(icdto.getCd_ic())) {
			// Para thread anterior
			tratadorHeartBeat.setContinuarExecutando(false);
			tratadorHeartBeat.interrupt();
			// Cria uma nova
			tratadorHeartBeat = new TratadorHeartBeat(icdto, log);
			tratadorHeartBeat.start();
		}
		
	}
}
