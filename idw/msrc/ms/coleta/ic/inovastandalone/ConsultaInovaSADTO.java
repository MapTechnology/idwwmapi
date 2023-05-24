package ms.coleta.ic.inovastandalone;

import java.util.List;

import idw.model.pojos.MsPerfilandon;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;

@SuppressWarnings("serial")
public class ConsultaInovaSADTO extends ObjRtMonitorizacaoDTO {

    private Double efiCiclosTurno;
    private Double efiCiclosOP;
    private Double indiceParadasPorTurno;
    private Double indiceParadasPorOP;
    private String dthrAtual;
    private Double saldoAProduzir;
    private Double metaProdHora;
    private List<String> listaProdutos;
    private Double cicloMedio;
    private Double cicloPadrao;
	private String cipDthrIni;
	private String cipDuration;
    private String intervaloHora;
    private MsPerfilandon msPerfilAndon;
	
	public Double getIndiceParadasPorTurno() {
		return indiceParadasPorTurno;
	}
	public void setIndiceParadasPorTurno(Double indiceParadasPorTurno) {
		this.indiceParadasPorTurno = indiceParadasPorTurno;
	}
	public Double getIndiceParadasPorOP() {
		return indiceParadasPorOP;
	}
	public void setIndiceParadasPorOP(Double indiceParadasPorOP) {
		this.indiceParadasPorOP = indiceParadasPorOP;
	}
	public Double getEfiCiclosTurno() {
		return efiCiclosTurno;
	}
	public void setEfiCiclosTurno(Double efiCiclosTurno) {
		this.efiCiclosTurno = efiCiclosTurno;
	}
	public Double getEfiCiclosOP() {
		return efiCiclosOP;
	}
	public void setEfiCiclosOP(Double efiCiclosOP) {
		this.efiCiclosOP = efiCiclosOP;
	}
	public String getIntervaloHora() {
		return intervaloHora;
	}
	public void setIntervaloHora(String intervaloHora) {
		this.intervaloHora = intervaloHora;
	}
	public String getDthrAtual() {
		return dthrAtual;
	}
	public void setDthrAtual(String dthrAtual) {
		this.dthrAtual = dthrAtual;
	}
	public Double getSaldoAProduzir() {
		return saldoAProduzir;
	}
	public void setSaldoAProduzir(Double saldoAProduzir) {
		this.saldoAProduzir = saldoAProduzir;
	}
	public Double getMetaProdHora() {
		return metaProdHora;
	}
	public void setMetaProdHora(Double metaProdHora) {
		this.metaProdHora = metaProdHora;
	}
	public List<String> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(List<String> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	public Double getCicloMedio() {
		return cicloMedio;
	}
	public void setCicloMedio(Double cicloMedio) {
		this.cicloMedio = cicloMedio;
	}
	public Double getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(Double cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public String getCipDthrIni() {
		return cipDthrIni;
	}
	public void setCipDthrIni(String cipDthrIni) {
		this.cipDthrIni = cipDthrIni;
	}
	public String getCipDuration() {
		return cipDuration;
	}
	public void setCipDuration(String cipDuration) {
		this.cipDuration = cipDuration;
	}
	public void setMsPerfilAndon(MsPerfilandon msPerfilandon) {
		this.msPerfilAndon = msPerfilandon;
	}
	public MsPerfilandon getMsPerfilAndon() {
		return msPerfilAndon;
	}
}
