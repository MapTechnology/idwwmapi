package idw.model.rn.injet.dto;


import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class RelatorioProducaoDTO implements Serializable{

	private String nomeMaquina;
	private String dsProduto;
	private String horasTrabalhadas;
	private String horasDisponiveis;
	private BigDecimal qtdPrevista;
	private BigDecimal psPrevisto;
	private BigDecimal producaoRefugada;
	private BigDecimal psProducaoRefugada;
	private BigDecimal producaoLiquida;
	private BigDecimal psProducaoLiquida;
	private BigDecimal producaoBruta;
	private BigDecimal psProducaoBruta;
	private float indRefugo;
	private float indParada;
	private float oee;
	private double kwh;
	private double kwhTon;
	private double kwhProducaoBruta;
	
	public String getNomeMaquina() {
		return nomeMaquina;
	}
	public void setNomeMaquina(String nomeMaquina) {
		this.nomeMaquina = nomeMaquina;
	}
	public String getDsProduto() {
		return dsProduto;
	}
	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}
	public String getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	public void setHorasTrabalhadas(String horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	public String getHorasDisponiveis() {
		return horasDisponiveis;
	}
	public void setHorasDisponiveis(String horasDisponiveis) {
		this.horasDisponiveis = horasDisponiveis;
	}
	public BigDecimal getQtdPrevista() {
		return qtdPrevista;
	}
	public void setQtdPrevista(BigDecimal qtdPrevista) {
		this.qtdPrevista = qtdPrevista;
	}
	public BigDecimal getPsPrevisto() {
		return psPrevisto;
	}
	public void setPsPrevisto(BigDecimal psPrevisto) {
		this.psPrevisto = psPrevisto;
	}
	public BigDecimal getProducaoRefugada() {
		return producaoRefugada;
	}
	public void setProducaoRefugada(BigDecimal producaoRefugada) {
		this.producaoRefugada = producaoRefugada;
	}
	public BigDecimal getPsProducaoRefugada() {
		return psProducaoRefugada;
	}
	public void setPsProducaoRefugada(BigDecimal psProducaoRefugada) {
		this.psProducaoRefugada = psProducaoRefugada;
	}
	public BigDecimal getProducaoLiquida() {
		return producaoLiquida;
	}
	public void setProducaoLiquida(BigDecimal producaoLiquida) {
		this.producaoLiquida = producaoLiquida;
	}
	public BigDecimal getPsProducaoLiquida() {
		return psProducaoLiquida;
	}
	public void setPsProducaoLiquida(BigDecimal psProducaoLiquida) {
		this.psProducaoLiquida = psProducaoLiquida;
	}
	public BigDecimal getProducaoBruta() {
		return producaoBruta;
	}
	public void setProducaoBruta(BigDecimal producaoBruta) {
		this.producaoBruta = producaoBruta;
	}
	public BigDecimal getPsProducaoBruta() {
		return psProducaoBruta;
	}
	public void setPsProducaoBruta(BigDecimal psProducaoBruta) {
		this.psProducaoBruta = psProducaoBruta;
	}
	public float getIndRefugo() {
		return indRefugo;
	}
	public void setIndRefugo(float indRefugo) {
		this.indRefugo = indRefugo;
	}
	public float getIndParada() {
		return indParada;
	}
	public void setIndParada(float indParada) {
		this.indParada = indParada;
	}
	public float getOee() {
		return oee;
	}
	public void setOee(float oee) {
		this.oee = oee;
	}
	public double getKwh() {
		return kwh;
	}
	public void setKwh(double kwh) {
		this.kwh = kwh;
	}
	public double getKwhTon() {
		return kwhTon;
	}
	public void setKwhTon(double kwhTon) {
		this.kwhTon = kwhTon;
	}
	public double getKwhProducaoBruta() {
		return kwhProducaoBruta;
	}
	public void setKwhProducaoBruta(double kwhProducaoBruta) {
		this.kwhProducaoBruta = kwhProducaoBruta;
	}
}
