package idw.relatorio.analiseproducaoeficiencia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.Session;

import idw.model.dao.DwConsolmologDAO;
import idw.model.pojos.DwConsolmolog;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.FiltroRelatorioAnaliseEficienciaDTO;

final class TrataOperadoresLogadosPeriodo {
	private final List<OperadorLogDTO> listaOperadoresLogados;
	private static final Comparator<OperadorLogDTO> COMPARE_OPERADORES = new Comparator<OperadorLogDTO>() {

		@Override
		public int compare(OperadorLogDTO o1, OperadorLogDTO o2) {
			int compare = DataHoraRN.compareTo(o1.getLogin(), o2.getLogin());
			if (compare == 0) {
				compare = o1.getNome().compareTo(o1.getNome());
			}
			return compare;
		}

	};

	TrataOperadoresLogadosPeriodo(Session session, final FiltroRelatorioAnaliseEficienciaDTO filtro) {

		DwConsolmologDAO dwConsolmologDAO = new DwConsolmologDAO(session);
		List<DwConsolmolog> listaOperadoresLogados = dwConsolmologDAO.getOperadoresLogadosNoPeriodoPorPt(
				filtro.getOmpt().getIdPt(),
				filtro.getDt_inicio(),
				filtro.getDt_final());
		this.listaOperadoresLogados = convertListOperadorLogDTO(listaOperadoresLogados);

	}

	void ordenar(AnaliseProducaoEficienciaHoraAHoraDTO relatorioProduto) {
		Collections.sort(relatorioProduto.getListaOperadoresDTO(), COMPARE_OPERADORES);
	}

	void addOperadoresLogadosDentroPeriodo(
			AnaliseProducaoEficienciaHoraAHoraDTO relatorioProduto, ProducaoHora producaoHora) {

		Date dthrIPeriodo = ObjectUtils.defaultIfNull(producaoHora.getDthrIReferencia(), producaoHora.getDthrIHora());
		Date dthrFPeriodo = ObjectUtils.defaultIfNull(producaoHora.getDthrFReferencia(), producaoHora.getDthrFHora());
		addOperadoresLogadosDentroPeriodo(relatorioProduto, dthrIPeriodo, dthrFPeriodo);
	}

	private void addOperadoresLogadosDentroPeriodo(AnaliseProducaoEficienciaHoraAHoraDTO relatorioProduto, Date dthrIPeriodo,
			Date dthrFPeriodo) {
		for (OperadorLogDTO operadorLogDTO : listaOperadoresLogados) {
			if (isLoginDentroPeriodoConsolidado(operadorLogDTO, dthrIPeriodo, dthrFPeriodo)) {
				addOperadorLog(operadorLogDTO, relatorioProduto.getListaOperadoresDTO());
			}
		}
	}

	private List<OperadorLogDTO> convertListOperadorLogDTO(Iterable<DwConsolmolog> mologs) {
		List<OperadorLogDTO> retorno = new ArrayList<OperadorLogDTO>();
		for (DwConsolmolog molog : mologs) {
			retorno.add(createOperadorLogDTO(molog.getOmUsr().getCdUsr() + "-" + molog.getOmUsr().getDsNome(), molog.getDthrIlogin(), molog.getDthrFlogin()));
		}
		return retorno;
	}

	/**
	 * Inclui operador na lista.<br>
	 * Só insere operador que ainda não estiver na lista.
	 *
	 * @param logdto
	 * @param operadores
	 */
	private void addOperadorLog(final OperadorLogDTO logdto, final List<OperadorLogDTO> operadores) {
		if (!operadores.contains(logdto)) {
			operadores.add(logdto);
		}
	}

	private OperadorLogDTO createOperadorLogDTO(String nome, Date login, Date logout) {
		OperadorLogDTO operador = new OperadorLogDTO();
		operador.setNome(nome);
		operador.setLogin(login);
		operador.setLogout(logout);
		operador.setLoginFormatado(DataHoraRN.dateToStringDDMMYYYYHHMMSS(login));
		if (logout == null) {
			operador.setLogoutFormatado("-");
		} else {
			operador.setLogoutFormatado(DataHoraRN.dateToStringDDMMYYYYHHMMSS(logout));
		}
		return operador;
	}

	private boolean isLoginDentroPeriodoConsolidado(OperadorLogDTO molog, Date dthrIPeriodo, Date dthrFPeriodo) {
		Date dthrLogin = molog.getLogin();
		Date dthrLogout = molog.getLogout();

		if (dthrIPeriodo != null && dthrFPeriodo != null) {
			if (dthrLogout == null) {
				return DataHoraRN.before(dthrLogin, dthrFPeriodo);
			} else {

				return DataHoraRN.isIntersecao(dthrLogin, dthrLogout, dthrIPeriodo, dthrFPeriodo);
			}
		}
		return false;
	}

}
