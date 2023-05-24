package ms.coleta.ic.drivercoleta;

import java.util.HashMap;
import java.util.Map;

import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;

public class ArquivoMonitoradoFactory {
	
	@SuppressWarnings("rawtypes")
	private Map<ColetaFileType, Class> coletasDisponiveis = new HashMap<ColetaFileType, Class>();
	private static ArquivoMonitoradoFactory instancia;

	
	private ArquivoMonitoradoFactory() {		
		coletasDisponiveis.put(ColetaFileType.MITRASTAR_TX, ArquivoMonitoradoTX.class);
		coletasDisponiveis.put(ColetaFileType.MITRASTAR_RX, ArquivoMonitoradoPTRXPK.class);
		coletasDisponiveis.put(ColetaFileType.MITRASTAR_PK, ArquivoMonitoradoPTRXPK.class);
		coletasDisponiveis.put(ColetaFileType.MITRASTAR_24G, ArquivoMonitorado24G5G.class);
		coletasDisponiveis.put(ColetaFileType.MITRASTAR_5G, ArquivoMonitorado24G5G.class);
		coletasDisponiveis.put(ColetaFileType.MITRASTAR_PT, ArquivoMonitoradoPTRXPK.class);

		// Alessandre em 26-10-17 inclui o tratamento abaixo pois a classe nao estava na relacao e estava ocorrendo nullpointer por isso
		coletasDisponiveis.put(ColetaFileType.MITRASTAR_FTP, ArquivoMonitoradoFTP.class);
	}
	
	public static ArquivoMonitoradoFactory getInstancia() {
		if (instancia == null)
			instancia = new ArquivoMonitoradoFactory();
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	public ArquivoMonitorado getArquivoMonitorado(String pathRelativo, ColetaFileType fileType) {
		try {
			return (ArquivoMonitorado) coletasDisponiveis.get(fileType).getConstructor(String.class, ColetaFileType.class).newInstance(pathRelativo, fileType);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Nao foi possivel criar o arquivoMonitorado: " + fileType);
		}
	}
}
