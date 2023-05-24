package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwRap;
import idw.model.rn.DataHoraRN;
import idw.model.rn.detalhemonitorizacao.IndicadoresDeTempoRN;
import idw.util.FormulasInjet;
import ms.util.ConversaoTipos;

public class RelatorioConsolidadosDTO {

	private String maquina;
	private String descMaquina;
	private Date dtReferencia;
	private String horasTrab;
	private String horasParadas;
	private String horasTrabDecimal;
	private String horasParadasDecimal;
	private String tpAtivo;
	private String tpAtivoDecimal;
	private String indiceParada;
	private List<DwRap> rap;
	private List<FerramentaDTO> ferramenta;
	private String cicloPadrao;
	private String cicloLido;
	private String efiCiclo;
	private String efcCicloPond;
	private List<ProdutoDTO> produto;
	private String metros;
	private BigDecimal segTempoParadaSP = BigDecimal.ZERO;


	private String mQuadPrevisto;
	private String mQuadProduzido;
	private String mQuadRef;
	private String mQuadBons;
	
	private BigDecimal producaoPrevista;
	private BigDecimal producaoBruta;
	
	private String cavidadesAtivas;
	private String pesoBruto;

	private String indiceCavidades;
	
	private BigDecimal somaTempoProducaoLiquida;
	private BigDecimal somaTempoRitmo;

	private String indiceRef;
	private String eficRealizada;
	private String oee;
	private String oeeCAP;

	// Cálculo total dos atributos
	private String hrsTrabTotal;
	private String hrsParadaTotal;
	private String tpAtivoTotal;

	private String indiceParadaTotal;
	private String eficRelizadaTotal;

	private String mQtdePrevisto;
	private String mQtdeProduzido;
	private String mQtdeRefugado;
	private String mQtdeBons;
	private String indiceRefugoTotal;
	private String indiceCavidadesTotal;
	private String totalCavidades;

	private String cicloPadraoTotal;
	private String cicloLidoTotal;

	private String oeeTotal;
	private String oeeCAPTotal;


	// O atributo abaixo eh usado para se guardar os ids envolvidos no calculo da linha, assim sera possivel calcular o ciclo pdarao e medio
	@Transient
	private List<DwConsolid> ids = new ArrayList<>();
	
	
	public String getDescMaquina() {
		return descMaquina;
	}

	public void setDescMaquina(String descMaquina) {
		this.descMaquina = descMaquina;
	}

	public String getTotalCavidades() {
		return totalCavidades;
	}

	public void setTotalCavidades(String totalCavidades) {
		this.totalCavidades = totalCavidades;
	}

	public String getIndiceCavidadesTotal() {
		return indiceCavidadesTotal;
	}

	public void setIndiceCavidadesTotal(String indiceCavidadesTotal) {
		this.indiceCavidadesTotal = indiceCavidadesTotal;
	}

	public String getIndiceCavidades() {
		return indiceCavidades;
	}

	public void setIndiceCavidades(String indiceCavidades) {
		this.indiceCavidades = indiceCavidades;
	}

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public Date getDtReferencia() {
		return dtReferencia;
	}

	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}

	public String getHorasTrab() {
		return horasTrab;
	}

	public void setHorasTrab(String horasTrab) {
		this.horasTrab = horasTrab;
	}

	public String getHorasParadas() {
		return horasParadas;
	}

	public void setHorasParadas(String horasParadas) {
		this.horasParadas = horasParadas;
	}

	public String getHorasTrabDecimal() {
		return horasTrabDecimal;
	}

	public void setHorasTrabDecimal(String horasTrabDecimal) {
		this.horasTrabDecimal = horasTrabDecimal;
	}

	public String getHorasParadasDecimal() {
		return horasParadasDecimal;
	}

	public void setHorasParadasDecimal(String horasParadasDecimal) {
		this.horasParadasDecimal = horasParadasDecimal;
	}

	public String getTpAtivo() {
		return tpAtivo;
	}

	public void setTpAtivo(String tpAtivo) {
		this.tpAtivo = tpAtivo;
	}

	public String getTpAtivoDecimal() {
		return tpAtivoDecimal;
	}

	public void setTpAtivoDecimal(String tpAtivoDecimal) {
		this.tpAtivoDecimal = tpAtivoDecimal;
	}

	public String getIndiceParada() {
		return indiceParada;
	}

	public void setIndiceParada(String indiceParada) {
		this.indiceParada = indiceParada;
	}

	public List<DwRap> getRap() {
		return rap;
	}

	public void setRap(List<DwRap> rap) {
		this.rap = rap;
	}

	public List<FerramentaDTO> getFerramenta() {
		return ferramenta;
	}

	public void setFerramenta(List<FerramentaDTO> ferramenta) {
		this.ferramenta = ferramenta;
	}

	public String getCicloPadrao() {
		return cicloPadrao;
	}

	public void setCicloPadrao(String cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}

	public String getCicloLido() {
		return cicloLido;
	}

	public void setCicloLido(String cicloLido) {
		this.cicloLido = cicloLido;
	}

	public String getEfiCiclo() {
		return efiCiclo;
	}

	public void setEfiCiclo(String efiCiclo) {
		this.efiCiclo = efiCiclo;
	}

	public String getEfcCicloPond() {
		return efcCicloPond;
	}

	public void setEfcCicloPond(String efcCicloPond) {
		this.efcCicloPond = efcCicloPond;
	}

	public List<ProdutoDTO> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoDTO> produto) {
		this.produto = produto;
	}

	public String getMetros() {
		return metros;
	}

	public void setMetros(String metros) {
		this.metros = metros;
	}

	public String getmQuadPrevisto() {
		return mQuadPrevisto;
	}

	public void setmQuadPrevisto(String mQuadPrevisto) {
		this.mQuadPrevisto = mQuadPrevisto;
	}

	public String getmQuadProduzido() {
		return mQuadProduzido;
	}

	public void setmQuadProduzido(String mQuadProduzido) {
		this.mQuadProduzido = mQuadProduzido;
	}

	public String getmQuadRef() {
		return mQuadRef;
	}

	public void setmQuadRef(String mQuadRef) {
		this.mQuadRef = mQuadRef;
	}

	public String getmQuadBons() {
		return mQuadBons;
	}

	public void setmQuadBons(String mQuadBons) {
		this.mQuadBons = mQuadBons;
	}

	public String getCavidadesAtivas() {
		return cavidadesAtivas;
	}

	public void setCavidadesAtivas(String cavidadesAtivas) {
		this.cavidadesAtivas = cavidadesAtivas;
	}

	public String getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(String pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public String getIndiceRef() {
		return indiceRef;
	}

	public void setIndiceRef(String indiceRef) {
		this.indiceRef = indiceRef;
	}

	public String getEficRealizada() {
		return eficRealizada;
	}

	public void setEficRealizada(String eficRealizada) {
		this.eficRealizada = eficRealizada;
	}

	public String getOee() {
		return oee;
	}

	public void setOee(String oee) {
		this.oee = oee;
	}

	public String getOeeCAP() {
		return oeeCAP;
	}

	public void setOeeCAP(String oeeCAP) {
		this.oeeCAP = oeeCAP;
	}

	public String getHrsTrabTotal() {
		return hrsTrabTotal;
	}

	public void setHrsTrabTotal(String hrsTrabTotal) {
		this.hrsTrabTotal = hrsTrabTotal;
	}

	public String getHrsParadaTotal() {
		return hrsParadaTotal;
	}

	public void setHrsParadaTotal(String hrsParadaTotal) {
		this.hrsParadaTotal = hrsParadaTotal;
	}

	public String getTpAtivoTotal() {
		return tpAtivoTotal;
	}

	public void setTpAtivoTotal(String tpAtivoTotal) {
		this.tpAtivoTotal = tpAtivoTotal;
	}

	public String getIndiceParadaTotal() {
		return indiceParadaTotal;
	}

	public void setIndiceParadaTotal(String indiceParadaTotal) {
		this.indiceParadaTotal = indiceParadaTotal;
	}

	public String getEficRelizadaTotal() {
		return eficRelizadaTotal;
	}

	public void setEficRelizadaTotal(String eficRelizadaTotal) {
		this.eficRelizadaTotal = eficRelizadaTotal;
	}

	public String getmQtdePrevisto() {
		return mQtdePrevisto;
	}

	public void setmQtdePrevisto(String mQtdePrevisto) {
		this.mQtdePrevisto = mQtdePrevisto;
	}

	public String getmQtdeProduzido() {
		return mQtdeProduzido;
	}

	public void setmQtdeProduzido(String mQtdeProduzido) {
		this.mQtdeProduzido = mQtdeProduzido;
	}

	public String getmQtdeRefugado() {
		return mQtdeRefugado;
	}

	public void setmQtdeRefugado(String mQtdeRefugado) {
		this.mQtdeRefugado = mQtdeRefugado;
	}

	public String getmQtdeBons() {
		return mQtdeBons;
	}

	public void setmQtdeBons(String mQtdeBons) {
		this.mQtdeBons = mQtdeBons;
	}

	public String getIndiceRefugoTotal() {
		return indiceRefugoTotal;
	}

	public void setIndiceRefugoTotal(String indiceRefugoTotal) {
		this.indiceRefugoTotal = indiceRefugoTotal;
	}

	public String getCicloPadraoTotal() {
		return cicloPadraoTotal;
	}

	public void setCicloPadraoTotal(String cicloPadraoTotal) {
		this.cicloPadraoTotal = cicloPadraoTotal;
	}

	public String getCicloLidoTotal() {
		return cicloLidoTotal;
	}

	public void setCicloLidoTotal(String cicloLidoTotal) {
		this.cicloLidoTotal = cicloLidoTotal;
	}

	public String getOeeTotal() {
		return oeeTotal;
	}

	public void setOeeTotal(String oeeTotal) {
		this.oeeTotal = oeeTotal;
	}

	public String getOeeCAPTotal() {
		return oeeCAPTotal;
	}

	public void setOeeCAPTotal(String oeeCAPTotal) {
		this.oeeCAPTotal = oeeCAPTotal;
	}

	public void add(DwConsol dto) {
		
		// Recalcular o tempo trabalhado
		// Recalcula o tempo ativo
		// Recalcula tempo ativo, mais serguro usar em casos em que o tempo foi
		// calculado errado
		// Tempo Ativo
		Double tempoAtivoAutoItem;
		Double tempoAtivoManuItem;


		tempoAtivoAutoItem = FormulasInjet.calcularTempoAtivo(dto.getSegAutoCicloprodutivo(),
				dto.getSegAutoTempoparadaCp(), dto.getSegAutoCicloimprodutivo(),
				dto.getSegAutoTempoparadaCpVr(), dto.getSegAutoTempoparadaSpVr()).doubleValue();
		// Tempo manual
		tempoAtivoManuItem = FormulasInjet.calcularTempoAtivo(dto.getSegManuCicloprodutivo(),
				dto.getSegManuTempoparadaCp(), dto.getSegManuCicloimprodutivo(),
				dto.getSegManuTempoparadaCpVr(), dto.getSegManuTempoparadaSpVr()).doubleValue();

		
		
		
		// Recalcula o tempo trabalhado
		Double tempoTrabalhadoAutoItem = FormulasInjet
				.calcularTempoTrabalhado(new BigDecimal(tempoAtivoAutoItem), dto.getSegAutoTempoparadaCp())
				.doubleValue();
		Double tempoTrabalhadoManuItem = FormulasInjet
				.calcularTempoTrabalhado(new BigDecimal(tempoAtivoManuItem), dto.getSegManuTempoparadaCp())
				.doubleValue();
		if (dto.getPcsProducaoBruta() == null || dto.getPcsProducaoBruta().doubleValue() == 0d) {
			tempoTrabalhadoAutoItem = 0d;
			tempoTrabalhadoManuItem = 0d;
		}

		Double tempotrabalhado = 0d;
		if (tempoTrabalhadoAutoItem > 0)
			tempotrabalhado += tempoTrabalhadoAutoItem;
		if (tempoTrabalhadoManuItem > 0)
			tempotrabalhado += tempoTrabalhadoManuItem;

		
		
		
		
		

		if (tempotrabalhado != null) {
			Double valAux = ConversaoTipos.converteParaDouble(getHorasTrabDecimal());
			valAux += tempotrabalhado;
			setHorasTrab(DataHoraRN.formatSegundosParaHHMMSS(valAux.intValue()));
			setHorasTrabDecimal(ConversaoTipos.converteParaString(valAux, 2));
		}

		if (dto.getGAutoPesoBruto() != null) {
			Double valAux = ConversaoTipos.converteParaDouble(getPesoBruto());
			valAux += dto.getGAutoPesoBruto().doubleValue();
			setPesoBruto(ConversaoTipos.converteParaString(valAux, 2));
		}

		if (dto.getSegAutoTempoparadaCp() != null) {
			Double valAux = ConversaoTipos.converteParaDouble(getHorasParadasDecimal());
			valAux += dto.getSegAutoTempoparadaCp().doubleValue();
			setHorasParadas(DataHoraRN.formatSegundosParaHHMMSS(valAux.intValue()));
			setHorasParadasDecimal(ConversaoTipos.converteParaString(valAux, 2));
		}

		if (dto.getSegAutoTempoativo() != null) {
			Double valAux = ConversaoTipos.converteParaDouble(getTpAtivoDecimal());
			valAux += dto.getSegAutoTempoativo().doubleValue();
			setTpAtivo(DataHoraRN.formatSegundosParaHHMMSS(valAux.intValue()));
			setTpAtivoDecimal(ConversaoTipos.converteParaString(valAux, 2));
		}
		
		if (dto.getSegAutoTempoparadaSp() != null) {
			setSegTempoParadaSP(getSegTempoParadaSP().add(dto.getSegAutoTempoparadaSp()));
		}
		
		IndicadoresDeTempoRN trn = new IndicadoresDeTempoRN(dto);

		if (trn.getTempoProducaoLiquida() != null) {

			Double valAux = getSomaTempoProducaoLiquida().doubleValue();
			valAux += trn.getTempoProducaoLiquida().doubleValue();
			setSomaTempoProducaoLiquida(new BigDecimal(valAux.intValue()));
		}

		if (trn.getTempoRitmo() != null) {

			Double valAux = getSomaTempoRitmo().doubleValue();

			valAux += trn.getTempoRitmo().doubleValue();
			setSomaTempoRitmo(new BigDecimal(valAux.intValue()));
		}
		
		if (dto.getPcsProducaoBruta() != null) {
			Double valAux = getProducaoBruta().doubleValue();
			valAux += dto.getPcsProducaoBruta().doubleValue();

			setmQuadProduzido(ConversaoTipos.converteDecimalParaString(valAux, 2));
			setProducaoBruta(new BigDecimal(valAux));
		}

		if (dto.getPcsAutoProducaoprevista() != null) {

			if (getProducaoPrevista() != null) {
				int prodprev = getProducaoPrevista().intValue();
				prodprev += dto.getPcsAutoProducaoprevista().intValue();
				setProducaoPrevista(new BigDecimal(prodprev));
			}else
				setProducaoPrevista(dto.getPcsAutoProducaoprevista());

			setmQuadPrevisto(ConversaoTipos.converteParaString(getProducaoPrevista(), 0));
			
		}

		if (dto.getPcsProducaoRefugada() != null) {
			Double valAux = ConversaoTipos.converteParaDouble(getmQuadRef());

			valAux += dto.getPcsProducaoRefugada().doubleValue();

			setmQuadRef(ConversaoTipos.converteDecimalParaString(valAux, 3));
		}

		if (dto.getPcsProducaoLiquida() != null) {
			Double valAux = ConversaoTipos.converteParaDouble(getmQuadBons());

			valAux += dto.getPcsProducaoLiquida().doubleValue();

			setmQuadBons(ConversaoTipos.converteDecimalParaString(valAux, 3));
		}
		
		addId(dto.getDwConsolid());

	}

	public BigDecimal getProducaoPrevista() {
		return producaoPrevista;
	}

	public void setProducaoPrevista(BigDecimal producaoPrevista) {
		this.producaoPrevista = producaoPrevista;
	}

	public BigDecimal getSomaTempoProducaoLiquida() {
		return somaTempoProducaoLiquida;
	}

	public void setSomaTempoProducaoLiquida(BigDecimal somaTempoProducaoLiquida) {
		this.somaTempoProducaoLiquida = somaTempoProducaoLiquida;
	}

	public BigDecimal getSomaTempoRitmo() {
		return somaTempoRitmo;
	}

	public void setSomaTempoRitmo(BigDecimal somaTempoRitmo) {
		this.somaTempoRitmo = somaTempoRitmo;
	}

	public BigDecimal getProducaoBruta() {
		return producaoBruta;
	}

	public void setProducaoBruta(BigDecimal producaoBruta) {
		this.producaoBruta = producaoBruta;
	}

	public BigDecimal getSegTempoParadaSP() {
		return segTempoParadaSP;
	}

	public void setSegTempoParadaSP(BigDecimal segTempoParadaSP) {
		this.segTempoParadaSP = segTempoParadaSP;
	}
	
	public void addId(DwConsolid id) {
		this.ids.add(id);
	}
	
	public List<DwConsolid> getIds() {
		return this.ids;
	}
}
