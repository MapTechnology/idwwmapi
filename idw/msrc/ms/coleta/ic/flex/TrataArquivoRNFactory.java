package ms.coleta.ic.flex;

import java.util.HashMap;
import java.util.Map;

import idw.util.IdwLogger;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.flex.pk.TrataArquivoRNPK;
import ms.coleta.ic.flex.teste24g.TrataArquivoRN24G;
import ms.coleta.ic.flex.tx.TrataArquivoRNTX;
import ms.model.dto.IcUpDTO;

public class TrataArquivoRNFactory {
	@SuppressWarnings("rawtypes")
	private Map<ColetaFileType, Class> coletasDisponiveis = new HashMap<ColetaFileType, Class>();
	private static TrataArquivoRNFactory instancia;

	private TrataArquivoRNFactory() {
		coletasDisponiveis.put(ColetaFileType.MITRASTAR_TX, TrataArquivoRNTX.class);
		coletasDisponiveis.put(ColetaFileType.MITRASTAR_RX, TrataArquivoRNPK.class);
		coletasDisponiveis.put(ColetaFileType.MITRASTAR_PK, TrataArquivoRNPK.class);
		coletasDisponiveis.put(ColetaFileType.MITRASTAR_24G, TrataArquivoRN24G.class);
		coletasDisponiveis.put(ColetaFileType.MITRASTAR_5G, TrataArquivoRN24G.class);
		coletasDisponiveis.put(ColetaFileType.MITRASTAR_PT, TrataArquivoRNPK.class);
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
