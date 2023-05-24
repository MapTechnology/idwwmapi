package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.Date;

public class RelatorioProdutividadeDTO {
	
	private String linha;
	private String op;
	private String turno;
	private String dtReferencia;
	private Date dtInicio;
	private Date dtFim;
	private BigDecimal producaoBruta;
	private BigDecimal producaoPlanejada;
	private String modelo;
	
	private int hora1;
    private int hora2;
    private int hora3;
    private int hora4;
    private int hora5;
    private int hora6;
    private int hora7;
    private int hora8;
    private int hora9;
    private int hora10;
    private int hora11;
    private int hora12;
    
    private String dthr1;
    private String dthr2;
    private String dthr3;
    private String dthr4;
    private String dthr5;
    private String dthr6;
    private String dthr7;
    private String dthr8;
    private String dthr9;
    private String dthr10;
    private String dthr11;
    private String dthr12;
	
	public String getLinha() {
		return linha;
	}
	public void setLinha(String linha) {
		this.linha = linha;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(String dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public Date getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}
	public Date getDtFim() {
		return dtFim;
	}
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}
	public BigDecimal getProducaoBruta() {
		return producaoBruta;
	}
	public void setProducaoBruta(BigDecimal producaoBruta) {
		this.producaoBruta = producaoBruta;
	}
	public BigDecimal getProducaoPlanejada() {
		return producaoPlanejada;
	}
	public void setProducaoPlanejada(BigDecimal producaoPlanejada) {
		this.producaoPlanejada = producaoPlanejada;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getHora1() {
		return hora1;
	}
	public void setHora1(int hora1) {
		this.hora1 = hora1;
	}
	public int getHora2() {
		return hora2;
	}
	public void setHora2(int hora2) {
		this.hora2 = hora2;
	}
	public int getHora3() {
		return hora3;
	}
	public void setHora3(int hora3) {
		this.hora3 = hora3;
	}
	public int getHora4() {
		return hora4;
	}
	public void setHora4(int hora4) {
		this.hora4 = hora4;
	}
	public int getHora5() {
		return hora5;
	}
	public void setHora5(int hora5) {
		this.hora5 = hora5;
	}
	public int getHora6() {
		return hora6;
	}
	public void setHora6(int hora6) {
		this.hora6 = hora6;
	}
	public int getHora7() {
		return hora7;
	}
	public void setHora7(int hora7) {
		this.hora7 = hora7;
	}
	public int getHora8() {
		return hora8;
	}
	public void setHora8(int hora8) {
		this.hora8 = hora8;
	}
	public int getHora9() {
		return hora9;
	}
	public void setHora9(int hora9) {
		this.hora9 = hora9;
	}
	public int getHora10() {
		return hora10;
	}
	public void setHora10(int hora10) {
		this.hora10 = hora10;
	}
	public int getHora11() {
		return hora11;
	}
	public void setHora11(int hora11) {
		this.hora11 = hora11;
	}
	public int getHora12() {
		return hora12;
	}
	public void setHora12(int hora12) {
		this.hora12 = hora12;
	}
	
	public void setHora(int sequencia, String dthr, int valor) {
		switch (sequencia) {
		case 1:
			hora1 += valor;
			dthr1 = dthr;
			break;
		case 2:
			hora2 += valor;
			dthr2 = dthr;
			break;
		case 3:
			hora3 += valor;
			dthr3 = dthr;
			break;
		case 4:
			hora4 += valor;
			dthr4 = dthr;
			break;
		case 5:
			hora5 += valor;
			dthr5 = dthr;
			break;
		case 6:
			hora6 += valor;
			dthr6 = dthr;
			break;
		case 7:
			hora7 += valor;
			dthr7 = dthr;
			break;
		case 8:
			hora8 += valor;
			dthr8 = dthr;
			break;
		case 9:
			hora9 += valor;
			dthr9 = dthr;
			break;
		case 10:
			hora10 += valor;
			dthr10 = dthr;
			break;
		case 11:
			hora11 += valor;
			dthr11 = dthr;
			break;
		case 12:
			hora12 += valor;
			dthr12 = dthr;
			break;
		}
	}
	public String getDthr1() {
		return dthr1;
	}
	public void setDthr1(String dthr1) {
		this.dthr1 = dthr1;
	}
	public String getDthr2() {
		return dthr2;
	}
	public void setDthr2(String dthr2) {
		this.dthr2 = dthr2;
	}
	public String getDthr3() {
		return dthr3;
	}
	public void setDthr3(String dthr3) {
		this.dthr3 = dthr3;
	}
	public String getDthr4() {
		return dthr4;
	}
	public void setDthr4(String dthr4) {
		this.dthr4 = dthr4;
	}
	public String getDthr5() {
		return dthr5;
	}
	public void setDthr5(String dthr5) {
		this.dthr5 = dthr5;
	}
	public String getDthr6() {
		return dthr6;
	}
	public void setDthr6(String dthr6) {
		this.dthr6 = dthr6;
	}
	public String getDthr7() {
		return dthr7;
	}
	public void setDthr7(String dthr7) {
		this.dthr7 = dthr7;
	}
	public String getDthr8() {
		return dthr8;
	}
	public void setDthr8(String dthr8) {
		this.dthr8 = dthr8;
	}
	public String getDthr9() {
		return dthr9;
	}
	public void setDthr9(String dthr9) {
		this.dthr9 = dthr9;
	}
	public String getDthr10() {
		return dthr10;
	}
	public void setDthr10(String dthr10) {
		this.dthr10 = dthr10;
	}
	public String getDthr11() {
		return dthr11;
	}
	public void setDthr11(String dthr11) {
		this.dthr11 = dthr11;
	}
	public String getDthr12() {
		return dthr12;
	}
	public void setDthr12(String dthr12) {
		this.dthr12 = dthr12;
	}
	
	
	
}
