package idw.webservices.dto;

import java.util.List;

import ms.util.ConversaoTipos;

public class RelatorioMaquinasCriticasDTO {
	
	
	private String pesoBruto;
	private String maquina;
	private String produto;
	private String parada;
	private String turnoAnterior;
	private String meta;
	private String prodHora1;
	private String prodHora2;
	private String prodHora3;
	private String prodHora4;
	private String prodHora5;
	private String prodHora6;
	private String prodHora7;
	private String prodHora8;
	private String prodHora9;
	private String prodHora10;
	private String prodHora11;
	private String prodHora12;
	private String prodTurno;
	private String prodTurnoAnt;
	private String prodTotal;
	private List<String> listaHoras;
	private List<RelatorioMaquinasCriticasDTO> itens;
	
	
	
	public String getPesoBruto() {
		return pesoBruto;
	}
	public void setPesoBruto(String pesoBruto) {
		this.pesoBruto = pesoBruto;
	}
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getParada() {
		return parada;
	}
	public void setParada(String parada) {
		this.parada = parada;
	}	
	public String getTurnoAnterior() {
		return turnoAnterior;
	}
	public void setTurnoAnterior(String turnoAnterior) {
		this.turnoAnterior = turnoAnterior;
	}
	public String getMeta() {
		return meta;
	}
	public void setMeta(String meta) {
		this.meta = meta;
	}
	public String getProdHora1() {
		return prodHora1;
	}
	public void setProdHora1(String prodHora1) {
		this.prodHora1 = prodHora1;
	}
	public String getProdHora2() {
		return prodHora2;
	}
	public void setProdHora2(String prodHora2) {
		this.prodHora2 = prodHora2;
	}
	public String getProdHora3() {
		return prodHora3;
	}
	public void setProdHora3(String prodHora3) {
		this.prodHora3 = prodHora3;
	}
	public String getProdHora4() {
		return prodHora4;
	}
	public void setProdHora4(String prodHora4) {
		this.prodHora4 = prodHora4;
	}
	public String getProdHora5() {
		return prodHora5;
	}
	public void setProdHora5(String prodHora5) {
		this.prodHora5 = prodHora5;
	}
	public String getProdHora6() {
		return prodHora6;
	}
	public void setProdHora6(String prodHora6) {
		this.prodHora6 = prodHora6;
	}
	public String getProdHora7() {
		return prodHora7;
	}
	public void setProdHora7(String prodHora7) {
		this.prodHora7 = prodHora7;
	}
	public String getProdHora8() {
		return prodHora8;
	}
	public void setProdHora8(String prodHora8) {
		this.prodHora8 = prodHora8;
	}
	public String getProdHora9() {
		return prodHora9;
	}
	public void setProdHora9(String prodHora9) {
		this.prodHora9 = prodHora9;
	}
	public String getProdHora10() {
		return prodHora10;
	}
	public void setProdHora10(String prodHora10) {
		this.prodHora10 = prodHora10;
	}
	public String getProdHora11() {
		return prodHora11;
	}
	public void setProdHora11(String prodHora11) {
		this.prodHora11 = prodHora11;
	}
	public String getProdHora12() {
		return prodHora12;
	}
	public void setProdHora12(String prodHora12) {
		this.prodHora12 = prodHora12;
	}
	public String getProdTurno() {
		return prodTurno;
	}
	public void setProdTurno(String prodTurno) {
		this.prodTurno = prodTurno;
	}
	public String getProdTurnoAnt() {
		return prodTurnoAnt;
	}
	public void setProdTurnoAnt(String prodTurnoAnt) {
		this.prodTurnoAnt = prodTurnoAnt;
	}
	public String getProdTotal() {
		return prodTotal;
	}
	public void setProdTotal(String prodTotal) {
		this.prodTotal = prodTotal;
	}
	public List<String> getListaHoras() {
		return listaHoras;
	}
	public void setListaHoras(List<String> listaHoras) {
		this.listaHoras = listaHoras;
	}
	public List<RelatorioMaquinasCriticasDTO> getItens() {
		return itens;
	}
	public void setItens(List<RelatorioMaquinasCriticasDTO> itens) {
		this.itens = itens;
	}
	public void addProdHora1(String valor) {
		Double prodHora = 0d;
		if (prodHora1 != null)
			prodHora = Double.parseDouble(prodHora1);
		prodHora += Double.parseDouble(valor);
		prodHora1 = ConversaoTipos.converteParaStringCasasOpcionais(prodHora, 3);
	}
	public void addProdHora2(String valor) {
		Double prodHora = 0d;
		if (prodHora2 != null)
			prodHora = Double.parseDouble(prodHora2);
		prodHora += Double.parseDouble(valor);
		prodHora2 = ConversaoTipos.converteParaStringCasasOpcionais(prodHora, 3);
	}
	public void addProdHora3(String valor) {
		Double prodHora = 0d;
		if (prodHora3 != null)
			prodHora = Double.parseDouble(prodHora3);
		prodHora += Double.parseDouble(valor);
		prodHora3 = ConversaoTipos.converteParaStringCasasOpcionais(prodHora, 3);
	}
	public void addProdHora4(String valor) {
		Double prodHora = 0d;
		if (prodHora4 != null)
			prodHora = Double.parseDouble(prodHora4);
		prodHora += Double.parseDouble(valor);
		prodHora4 = ConversaoTipos.converteParaStringCasasOpcionais(prodHora, 3);
	}
	public void addProdHora5(String valor) {
		Double prodHora = 0d;
		if (prodHora5 != null)
			prodHora = Double.parseDouble(prodHora5);
		prodHora += Double.parseDouble(valor);
		prodHora5 = ConversaoTipos.converteParaStringCasasOpcionais(prodHora, 3);
	}
	public void addProdHora6(String valor) {
		Double prodHora = 0d;
		if (prodHora6 != null)
			prodHora = Double.parseDouble(prodHora6);
		prodHora += Double.parseDouble(valor);
		prodHora6 = ConversaoTipos.converteParaStringCasasOpcionais(prodHora, 3);
	}
	public void addProdHora7(String valor) {
		Double prodHora = 0d;
		if (prodHora7 != null)
			prodHora = Double.parseDouble(prodHora7);
		prodHora += Double.parseDouble(valor);
		prodHora7 = ConversaoTipos.converteParaStringCasasOpcionais(prodHora, 3);
	}
	public void addProdHora8(String valor) {
		Double prodHora = 0d;
		if (prodHora8 != null)
			prodHora = Double.parseDouble(prodHora8);
		prodHora += Double.parseDouble(valor);
		prodHora8 = ConversaoTipos.converteParaStringCasasOpcionais(prodHora, 3);
	}
	public void addProdHora9(String valor) {
		Double prodHora = 0d;
		if (prodHora9 != null)
			prodHora = Double.parseDouble(prodHora9);
		prodHora += Double.parseDouble(valor);
		prodHora9 = ConversaoTipos.converteParaStringCasasOpcionais(prodHora, 3);
	}
	public void addProdHora10(String valor) {
		Double prodHora = 0d;
		if (prodHora10 != null)
			prodHora = Double.parseDouble(prodHora10);
		prodHora += Double.parseDouble(valor);
		prodHora10 = ConversaoTipos.converteParaStringCasasOpcionais(prodHora, 3);
	}
	public void addProdHora11(String valor) {
		Double prodHora = 0d;
		if (prodHora11 != null)
			prodHora = Double.parseDouble(prodHora11);
		prodHora += Double.parseDouble(valor);
		prodHora11 = ConversaoTipos.converteParaStringCasasOpcionais(prodHora, 3);
	}
	public void addProdHora12(String valor) {
		Double prodHora = 0d;
		if (prodHora12 != null)
			prodHora = Double.parseDouble(prodHora12);
		prodHora += Double.parseDouble(valor);
		prodHora12 = ConversaoTipos.converteParaStringCasasOpcionais(prodHora, 3);
	}
}