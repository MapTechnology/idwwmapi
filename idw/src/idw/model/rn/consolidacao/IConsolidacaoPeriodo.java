package idw.model.rn.consolidacao;

import java.util.Date;

import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwConsolid;
import idw.util.IdwLogger;

/**
 * Realiza disponibiliza métodos para consolidação nos períodos de hora, turno, mês/ano e acumulado
 * @author milton
 *
 */
public interface IConsolidacaoPeriodo {
	public void consolidarTurno(DwConsolid dwConsolid, Date dtHrIRef, Date dtHrFRef, Long duracao, IdwLogger log, int idLog, int identacao, String chamador) throws SemCicloPadraoException;
	public void consolidarHora(DwConsolid dwConsolid, Date dtHrIRef, Date dtHrFRef, Long duracao, IdwLogger log, int idLog, int identacao, String chamador) throws SemCicloPadraoException;
	public void consolidarMes(DwConsolid dwConsolid, Date dtHrIRef, Date dtHrFRef, Long duracao, IdwLogger log, int idLog, int identacao, String chamador) throws SemCicloPadraoException;
	public void consolidarAcumulado(DwConsolid dwConsolid, Date dtHrIRef, Date dtHrFRef, Long duracao, IdwLogger log, int idLog, int identacao, String chamador) throws SemCicloPadraoException;
}
