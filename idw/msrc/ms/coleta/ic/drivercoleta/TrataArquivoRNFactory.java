package ms.coleta.ic.drivercoleta;

import idw.util.IdwLogger;

import java.util.HashMap;
import java.util.Map;

import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.model.dto.IcUpDTO;

public class TrataArquivoRNFactory {
	@SuppressWarnings("rawtypes")
	private Map<ColetaFileType, Class> coletasDisponiveis = new HashMap<ColetaFileType, Class>();
	private static TrataArquivoRNFactory instancia;

	
	private TrataArquivoRNFactory() {		
		coletasDisponiveis.put(ColetaFileType.MITRASTAR_TX, TrataArquivoRNTX.class);
		coletasDisponiveis.put(ColetaFileType.MITRASTAR_RX, TrataArquivoRNPTRXPK.class);
		coletasDisponiveis.put(ColetaFileType.MITRASTAR_PK, TrataArquivoRNPTRXPK.class);
		coletasDisponiveis.put(ColetaFileType.MITRASTAR_24G, TrataArquivoRN24G5G.class);
		coletasDisponiveis.put(ColetaFileType.MITRASTAR_5G, TrataArquivoRN24G5G.class);
		coletasDisponiveis.put(ColetaFileType.MITRASTAR_PT, TrataArquivoRNPTRXPK.class);
	}
	
	public static TrataArquivoRNFactory getInstancia() {
		if (instancia == null)
			instancia = new TrataArquivoRNFactory();
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	public TrataArquivoRN getTrataArquivoRN(String pathRelativo, IcUpDTO icupdto, ColetaFileType fileType, IdwLogger log) {
		try {
			return (TrataArquivoRN) coletasDisponiveis.get(fileType)
					.getConstructor(String.class, IcUpDTO.class, ColetaFileType.class, IdwLogger.class)
					.newInstance(pathRelativo, icupdto, fileType, log);
		} catch (Exception e) {
			 throw new RuntimeException("Nao foi possivel criar o trataArquivoRN: " + fileType);
		}
	}
}
