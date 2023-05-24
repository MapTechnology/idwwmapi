package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.Date;

public class RelatorioAnaliticoRefugoDTO {
	
	private Date data;
	private double indiceRefugo;
	private double indiceTotal;
	private int pecaDt1;
	private int pecaDt2;
	private int pecaDt3;
	private int pecaDt4;
	private int pecaDt5;
	private int pecasAcumuladas;
	private BigDecimal pesoDt1 = BigDecimal.ZERO;
	private BigDecimal pesoDt2 = BigDecimal.ZERO;
	private BigDecimal pesoDt3 = BigDecimal.ZERO;
	private BigDecimal pesoDt4 = BigDecimal.ZERO;
	private BigDecimal pesoDt5 = BigDecimal.ZERO;
	private int pesoProduto;
	private BigDecimal pesosAcumulados = BigDecimal.ZERO;
	private String produto;

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getIndiceRefugo() {
		return indiceRefugo;
	}
	public void setIndiceRefugo(double indiceRefugo) {
		this.indiceRefugo = indiceRefugo;
	}
	public double getIndiceTotal() {
		return indiceTotal;
	}
	public void setIndiceTotal(double indiceTotal) {
		this.indiceTotal = indiceTotal;
	}
	public int getPecaDt1() {
		return pecaDt1;
	}
	public void setPecaDt1(int pecaDt1) {
		this.pecaDt1 = pecaDt1;
	}
	public int getPecaDt2() {
		return pecaDt2;
	}
	public void setPecaDt2(int pecaDt2) {
		this.pecaDt2 = pecaDt2;
	}
	public int getPecaDt3() {
		return pecaDt3;
	}
	public void setPecaDt3(int pecaDt3) {
		this.pecaDt3 = pecaDt3;
	}
	public int getPecaDt4() {
		return pecaDt4;
	}
	public void setPecaDt4(int pecaDt4) {
		this.pecaDt4 = pecaDt4;
	}
	public int getPecaDt5() {
		return pecaDt5;
	}
	public void setPecaDt5(int pecaDt5) {
		this.pecaDt5 = pecaDt5;
	}
	public int getPecasAcumuladas() {
		return pecasAcumuladas;
	}
	public void setPecasAcumuladas(int pecasAcumuladas) {
		this.pecasAcumuladas = pecasAcumuladas;
	}
	public BigDecimal getPesoDt1() {
		return pesoDt1;
	}
	public void setPesoDt1(BigDecimal pesoDt1) {
		this.pesoDt1 = pesoDt1;
	}
	public BigDecimal getPesoDt2() {
		return pesoDt2;
	}
	public void setPesoDt2(BigDecimal pesoDt2) {
		this.pesoDt2 = pesoDt2;
	}
	public BigDecimal getPesoDt3() {
		return pesoDt3;
	}
	public void setPesoDt3(BigDecimal pesoDt3) {
		this.pesoDt3 = pesoDt3;
	}
	public BigDecimal getPesoDt4() {
		return pesoDt4;
	}
	public void setPesoDt4(BigDecimal pesoDt4) {
		this.pesoDt4 = pesoDt4;
	}
	public BigDecimal getPesoDt5() {
		return pesoDt5;
	}
	public void setPesoDt5(BigDecimal pesoDt5) {
		this.pesoDt5 = pesoDt5;
	}
	public int getPesoProduto() {
		return pesoProduto;
	}
	public void setPesoProduto(int pesoProduto) {
		this.pesoProduto = pesoProduto;
	}
	public BigDecimal getPesosAcumulados() {
		return pesosAcumulados;
	}
	public void setPesosAcumulados(BigDecimal pesosAcumulados) {
		this.pesosAcumulados = pesosAcumulados;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	
}