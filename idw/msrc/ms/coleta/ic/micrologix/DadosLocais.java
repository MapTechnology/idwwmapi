package ms.coleta.ic.micrologix;

import java.util.Date;

public class DadosLocais {
	private final static int _NAODEFINIDO = -1;

	public boolean deveTratar = false;
	public Date dthrUltimaAmostragem = new Date();
	public long tempoEntreAmostragens = 30000; // tempo padr�o 30 segundos
												// (30000 ms)
	public int ultimoestadoConsolidado = _NAODEFINIDO; // -1 N�o
														// iniciado,0- OK ,
														// 1 -Zona Aceitavel
														// , 2- ZonaCritica
														// superior,3- Sem
														// Conex�o
	public int estadoAferido = _NAODEFINIDO;
	public int lastEstadoAferido = _NAODEFINIDO;
	public int nrRetries = 5; // N�mero de aferi��es repetidas para
								// considerar uma mudan�a de estado
	public int countRetries = 0;
	public double ultimaAmostragem = _NAODEFINIDO;
	public double limiteAceitavelSup = _NAODEFINIDO;
	public double limiteAceitavelInf = _NAODEFINIDO;
	public double limiteCriticoSup = _NAODEFINIDO;
	public double limiteCriticoInf = _NAODEFINIDO;
	public String cdFolha = null;

}
