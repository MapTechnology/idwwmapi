package idw.relatorio.analiseproducaoeficiencia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwFolha;
import idw.model.rn.DataHoraRN;
import idw.util.AritmeticaUtil;

class ProducaoHora {

	private BigDecimal pcsProducaoLiquida;
	private BigDecimal pcsProducaoBruta;
	private BigDecimal pcsProducaoRefugada;
	private BigDecimal segAutoTempoAtivo;
	private BigDecimal segAutoTempoparadaCp;
	private BigDecimal segAutoCicloprodutivo;
	private BigDecimal qtAutoCicloprodutivo;
	private DwFolha dwFolha;
	private BigDecimal segAutoCicloPadrao;
	private Date dthrIHora;
	private Date dthrFHora;
	private Date dthrIReferencia;
	private Date dthrFReferencia;

	private List<AnaliseProducaoEficienciaHoraAHoraDetalheDTO> eventosHora =
			new ArrayList<AnaliseProducaoEficienciaHoraAHoraDetalheDTO>();

	ProducaoHora(Date dtHrIHora, Date dtHrFHora, DwConsol dwConsol, DwConsolpr dwConsolpr,
			DwFolha dwFolha, List<AnaliseProducaoEficienciaHoraAHoraDetalheDTO> eventosHora,
			Date dthrIReferencia, Date dthrFReferencia) {
		this.dthrIHora = dtHrIHora;
		this.dthrFHora = dtHrFHora;
		this.pcsProducaoLiquida = dwConsolpr.getPcsProducaoLiquida();
		this.pcsProducaoBruta = dwConsolpr.getPcsProducaoBruta();
		this.pcsProducaoRefugada = dwConsolpr.getPcsProducaoRefugada();
		this.segAutoTempoparadaCp = dwConsol.getSegAutoTempoparadaCp();
		this.segAutoCicloprodutivo = dwConsol.getSegAutoCicloprodutivo();
		this.qtAutoCicloprodutivo = dwConsol.getQtAutoCicloprodutivo();
		this.segAutoTempoAtivo = dwConsol.getSegAutoTempoativo();
		this.segAutoCicloPadrao = dwConsol.getSegAutoCiclopadrao();
		this.dwFolha = dwFolha;
		this.dthrIReferencia = dthrIReferencia;
		this.dthrFReferencia = dthrFReferencia;
		this.eventosHora.addAll(eventosHora);
	}

	ProducaoHora(Date dtHrIHora, Date dtHrFHora, DwFolha dwFolha, BigDecimal segAutoCicloPadrao,
			BigDecimal tempoAtivo, BigDecimal tempoParadaCp, AnaliseProducaoEficienciaHoraAHoraDetalheDTO eventoHora,
			Date dthrIReferencia, Date dthrFReferencia) {
		this.dthrIHora = dtHrIHora;
		this.dthrFHora = dtHrFHora;
		this.segAutoTempoAtivo = tempoAtivo;
		this.segAutoTempoparadaCp = tempoParadaCp;
		this.segAutoCicloPadrao = segAutoCicloPadrao;
		this.dwFolha = dwFolha;
		this.dthrIReferencia = dthrIReferencia;
		this.dthrFReferencia = dthrFReferencia;
		this.eventosHora.add(eventoHora);
	}
	
	/**
	 * @return Menor data/hora de início evento encontrado dentro da hora
	 */
	public Date getDthrIReferencia() {
		return dthrIReferencia;
	}

	/**
	 * @return Maior data/hora de fim evento encontrado dentro da hora
	 */
	public Date getDthrFReferencia() {
		return dthrFReferencia;
	}

	/**
	 * Guarda a menor e maior data do evento de produção que ocorreu na hora
	 *
	 * @param dthrI
	 * @param dthrF
	 */
	private void setPeriodoReferencia(Date dthrI, Date dthrF) {
		if (dthrIReferencia == null) {
			dthrIReferencia = dthrI;
		}

		if (dthrI != null && dthrIReferencia != null && DataHoraRN.before(dthrI, dthrIReferencia)) {
			dthrI = dthrIReferencia;
		}

		if (dthrFReferencia == null) {
			dthrFReferencia = dthrF;
		}

		if (dthrF != null && dthrFReferencia != null && DataHoraRN.after(dthrF, dthrFReferencia)) {
			dthrF = dthrFReferencia;
		}
	}

	public BigDecimal getPcsProducaoLiquida() {
		return pcsProducaoLiquida;
	}

	public BigDecimal getPcsProducaoBruta() {
		return pcsProducaoBruta;
	}

	public BigDecimal getPcsProducaoRefugada() {
		return pcsProducaoRefugada;
	}

	public BigDecimal getSegAutoCicloPadrao() {
		return segAutoCicloPadrao;
	}

	public BigDecimal getSegAutoTempoAtivo() {
		return segAutoTempoAtivo;
	}

	public BigDecimal getSegAutoTempoparadaCp() {
		return segAutoTempoparadaCp;
	}

	public BigDecimal getSegAutoCicloprodutivo() {
		return segAutoCicloprodutivo;
	}

	public BigDecimal getQtAutoCicloprodutivo() {
		return qtAutoCicloprodutivo;
	}

	public DwFolha getDwFolha() {
		return dwFolha;
	}

	public List<AnaliseProducaoEficienciaHoraAHoraDetalheDTO> getEventosHora() {
		return eventosHora;
	}

	public Date getDthrIHora() {
		return dthrIHora;
	}

	public Date getDthrFHora() {
		return dthrFHora;
	}

	/**
	 * Pega dados produtivos passados como parametro e os soma com os da instancia. <br>
	 *
	 * @param producaoHora
	 */
	public void agrupar(ProducaoHora producaoHora) {

		pcsProducaoLiquida = AritmeticaUtil.somar(pcsProducaoLiquida, producaoHora.getPcsProducaoLiquida());
		pcsProducaoBruta = AritmeticaUtil.somar(pcsProducaoBruta, producaoHora.getPcsProducaoBruta());
		pcsProducaoRefugada = AritmeticaUtil.somar(pcsProducaoRefugada, producaoHora.getPcsProducaoRefugada());
		segAutoTempoAtivo = AritmeticaUtil.somar(segAutoTempoAtivo, producaoHora.getSegAutoTempoAtivo());
		segAutoCicloprodutivo = AritmeticaUtil.somar(segAutoCicloprodutivo, producaoHora.getSegAutoCicloprodutivo());
		qtAutoCicloprodutivo = AritmeticaUtil.somar(qtAutoCicloprodutivo, producaoHora.getQtAutoCicloprodutivo());
		segAutoTempoparadaCp = AritmeticaUtil.somar(segAutoTempoparadaCp, producaoHora.getSegAutoTempoparadaCp());
		eventosHora.addAll(producaoHora.getEventosHora());
		setPeriodoReferencia(producaoHora.getDthrIReferencia(), producaoHora.getDthrFReferencia());
	}

}
