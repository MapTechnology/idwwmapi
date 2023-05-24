package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.List;

public class RelatorioCargaMaquinaDTO {
	private String maquina;
	private String molde;
	private String produto;
	private String op;
	private BigDecimal plano = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugo = BigDecimal.ZERO.setScale(4);
	private BigDecimal boas = BigDecimal.ZERO.setScale(4);
	private BigDecimal saldo = BigDecimal.ZERO.setScale(4);
	private BigDecimal metaHora = BigDecimal.ZERO.setScale(4);
	private BigDecimal metaDia = BigDecimal.ZERO.setScale(4);
	private String stOp ;
	private Integer dia;
	private Integer corQtd;
	
	private List<RelatorioCargaMaquinaDTO> itens;	
	
	private List<BigDecimal> listaPlanejadoDia;
	private BigDecimal planejadoDia0 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia1 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia2 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia3 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia4 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia5 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia6 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia7 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia8 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia9 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia10 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia11 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia12 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia13 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia14 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia15 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia16 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia17 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia18 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia19 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia20 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia21 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia22 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia23 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia24 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia25 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia26 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia27 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia28 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia29 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planejadoDia30 = BigDecimal.ZERO.setScale(4);	
	
	private List<BigDecimal> listaProducaoDia;
	private BigDecimal producaoDia0 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia1 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia2 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia3 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia4 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia5 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia6 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia7 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia8 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia9 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia10 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia11 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia12 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia13 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia14 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia15 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia16 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia17 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia18 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia19 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia20 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia21 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia22 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia23 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia24 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia25 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia26 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia27 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia28 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia29 = BigDecimal.ZERO.setScale(4);
	private BigDecimal producaoDia30 = BigDecimal.ZERO.setScale(4); 	
	
	private List<BigDecimal> listaRefugoDia;
	private BigDecimal refugoDia0 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia1 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia2 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia3 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia4 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia5 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia6 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia7 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia8 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia9 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia10 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia11 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia12 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia13 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia14 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia15 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia16 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia17 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia18 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia19 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia20 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia21 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia22 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia23 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia24 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia25 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia26 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia27 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia28 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia29 = BigDecimal.ZERO.setScale(4);
	private BigDecimal refugoDia30 = BigDecimal.ZERO.setScale(4);
	
	private List<BigDecimal> listaBoasDia;
	private BigDecimal boasDia0 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia1 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia2 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia3 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia4 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia5 = BigDecimal.ZERO.setScale(4) ;
	private BigDecimal boasDia6 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia7 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia8 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia9 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia10 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia11 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia12 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia13 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia14 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia15 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia16 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia17 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia18 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia19 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia20 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia21 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia22 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia23 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia24 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia25 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia26 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia27 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia28 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia29 = BigDecimal.ZERO.setScale(4);
	private BigDecimal boasDia30 = BigDecimal.ZERO.setScale(4);
	
	private BigDecimal planMaqDia0 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia1 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia2 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia3 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia4 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia5 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia6 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia7 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia8 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia9 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia10 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia11 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia12 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia13 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia14 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia15 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia16 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia17 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia18 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia19 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia20 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia21 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia22 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia23 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia24 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia25 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia26 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia27 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia28 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia29 = BigDecimal.ZERO.setScale(4);
	private BigDecimal planMaqDia30 = BigDecimal.ZERO.setScale(4);

	
	private Integer corDia0 = 1;
	private Integer corDia1 = 1;
	private Integer corDia2 = 1;
	private Integer corDia3 = 1;
	private Integer corDia4 = 1;
	private Integer corDia5 = 1;
	private Integer corDia6 = 1;
	private Integer corDia7 = 1;
	private Integer corDia8 = 1;
	private Integer corDia9 = 1;
	private Integer corDia10 = 1;
	private Integer corDia11 = 1;
	private Integer corDia12 = 1;
	private Integer corDia13 = 1;
	private Integer corDia14 = 1;
	private Integer corDia15 = 1;
	private Integer corDia16 = 1;
	private Integer corDia17 = 1;
	private Integer corDia18 = 1;
	private Integer corDia19 = 1;
	private Integer corDia20 = 1;
	private Integer corDia21 = 1;
	private Integer corDia22 = 1;
	private Integer corDia23 = 1;
	private Integer corDia24 = 1;
	private Integer corDia25 = 1;
	private Integer corDia26 = 1;
	private Integer corDia27 = 1;
	private Integer corDia28 = 1;
	private Integer corDia29 = 1;
	private Integer corDia30 = 1;	
	
	
	public BigDecimal getRefugo() {
		return refugo;
	}

	public void setRefugo(BigDecimal refugo) {
		this.refugo = refugo;
	}

	public BigDecimal getPlanMaqDia1() {
		return planMaqDia1;
	}

	public void setPlanMaqDia1(BigDecimal planMaqDia1) {
		this.planMaqDia1 = planMaqDia1;
	}

	public BigDecimal getPlanMaqDia2() {
		return planMaqDia2;
	}

	public void setPlanMaqDia2(BigDecimal planMaqDia2) {
		this.planMaqDia2 = planMaqDia2;
	}

	public BigDecimal getPlanMaqDia3() {
		return planMaqDia3;
	}

	public void setPlanMaqDia3(BigDecimal planMaqDia3) {
		this.planMaqDia3 = planMaqDia3;
	}

	public BigDecimal getPlanMaqDia4() {
		return planMaqDia4;
	}

	public void setPlanMaqDia4(BigDecimal planMaqDia4) {
		this.planMaqDia4 = planMaqDia4;
	}

	public BigDecimal getPlanMaqDia5() {
		return planMaqDia5;
	}

	public void setPlanMaqDia5(BigDecimal planMaqDia5) {
		this.planMaqDia5 = planMaqDia5;
	}

	public BigDecimal getPlanMaqDia6() {
		return planMaqDia6;
	}

	public void setPlanMaqDia6(BigDecimal planMaqDia6) {
		this.planMaqDia6 = planMaqDia6;
	}

	public BigDecimal getPlanMaqDia7() {
		return planMaqDia7;
	}

	public void setPlanMaqDia7(BigDecimal planMaqDia7) {
		this.planMaqDia7 = planMaqDia7;
	}

	public BigDecimal getPlanMaqDia8() {
		return planMaqDia8;
	}

	public void setPlanMaqDia8(BigDecimal planMaqDia8) {
		this.planMaqDia8 = planMaqDia8;
	}

	public BigDecimal getPlanMaqDia9() {
		return planMaqDia9;
	}

	public void setPlanMaqDia9(BigDecimal planMaqDia9) {
		this.planMaqDia9 = planMaqDia9;
	}

	public BigDecimal getPlanMaqDia10() {
		return planMaqDia10;
	}

	public void setPlanMaqDia10(BigDecimal planMaqDia10) {
		this.planMaqDia10 = planMaqDia10;
	}

	public BigDecimal getPlanMaqDia11() {
		return planMaqDia11;
	}

	public void setPlanMaqDia11(BigDecimal planMaqDia11) {
		this.planMaqDia11 = planMaqDia11;
	}

	public BigDecimal getPlanMaqDia12() {
		return planMaqDia12;
	}

	public void setPlanMaqDia12(BigDecimal planMaqDia12) {
		this.planMaqDia12 = planMaqDia12;
	}

	public BigDecimal getPlanMaqDia13() {
		return planMaqDia13;
	}

	public void setPlanMaqDia13(BigDecimal planMaqDia13) {
		this.planMaqDia13 = planMaqDia13;
	}

	public BigDecimal getPlanMaqDia14() {
		return planMaqDia14;
	}

	public void setPlanMaqDia14(BigDecimal planMaqDia14) {
		this.planMaqDia14 = planMaqDia14;
	}

	public BigDecimal getPlanMaqDia15() {
		return planMaqDia15;
	}

	public void setPlanMaqDia15(BigDecimal planMaqDia15) {
		this.planMaqDia15 = planMaqDia15;
	}

	public BigDecimal getPlanMaqDia16() {
		return planMaqDia16;
	}

	public void setPlanMaqDia16(BigDecimal planMaqDia16) {
		this.planMaqDia16 = planMaqDia16;
	}

	public BigDecimal getPlanMaqDia17() {
		return planMaqDia17;
	}

	public void setPlanMaqDia17(BigDecimal planMaqDia17) {
		this.planMaqDia17 = planMaqDia17;
	}

	public BigDecimal getPlanMaqDia18() {
		return planMaqDia18;
	}

	public void setPlanMaqDia18(BigDecimal planMaqDia18) {
		this.planMaqDia18 = planMaqDia18;
	}

	public BigDecimal getPlanMaqDia19() {
		return planMaqDia19;
	}

	public void setPlanMaqDia19(BigDecimal planMaqDia19) {
		this.planMaqDia19 = planMaqDia19;
	}

	public BigDecimal getPlanMaqDia20() {
		return planMaqDia20;
	}

	public void setPlanMaqDia20(BigDecimal planMaqDia20) {
		this.planMaqDia20 = planMaqDia20;
	}

	public BigDecimal getPlanMaqDia21() {
		return planMaqDia21;
	}

	public void setPlanMaqDia21(BigDecimal planMaqDia21) {
		this.planMaqDia21 = planMaqDia21;
	}

	public BigDecimal getPlanMaqDia22() {
		return planMaqDia22;
	}

	public void setPlanMaqDia22(BigDecimal planMaqDia22) {
		this.planMaqDia22 = planMaqDia22;
	}

	public BigDecimal getPlanMaqDia23() {
		return planMaqDia23;
	}

	public void setPlanMaqDia23(BigDecimal planMaqDia23) {
		this.planMaqDia23 = planMaqDia23;
	}

	public BigDecimal getPlanMaqDia24() {
		return planMaqDia24;
	}

	public void setPlanMaqDia24(BigDecimal planMaqDia24) {
		this.planMaqDia24 = planMaqDia24;
	}

	public BigDecimal getPlanMaqDia25() {
		return planMaqDia25;
	}

	public void setPlanMaqDia25(BigDecimal planMaqDia25) {
		this.planMaqDia25 = planMaqDia25;
	}

	public BigDecimal getPlanMaqDia26() {
		return planMaqDia26;
	}

	public void setPlanMaqDia26(BigDecimal planMaqDia26) {
		this.planMaqDia26 = planMaqDia26;
	}

	public BigDecimal getPlanMaqDia27() {
		return planMaqDia27;
	}

	public void setPlanMaqDia27(BigDecimal planMaqDia27) {
		this.planMaqDia27 = planMaqDia27;
	}

	public BigDecimal getPlanMaqDia28() {
		return planMaqDia28;
	}

	public void setPlanMaqDia28(BigDecimal planMaqDia28) {
		this.planMaqDia28 = planMaqDia28;
	}

	public BigDecimal getPlanMaqDia29() {
		return planMaqDia29;
	}

	public void setPlanMaqDia29(BigDecimal planMaqDia29) {
		this.planMaqDia29 = planMaqDia29;
	}

	public BigDecimal getPlanMaqDia30() {
		return planMaqDia30;
	}

	public void setPlanMaqDia30(BigDecimal planMaqDia30) {
		this.planMaqDia30 = planMaqDia30;
	}

	public BigDecimal getPlanMaqDia0() {
		return planMaqDia0;
	}

	public void setPlanMaqDia0(BigDecimal planMaqDia0) {
		this.planMaqDia0 = planMaqDia0;
	}

	public BigDecimal getPlanejadoDia1() {
		return planejadoDia1;
	}

	public void setPlanejadoDia1(BigDecimal planejadoDia1) {
		this.planejadoDia1 = planejadoDia1;
	}

	public BigDecimal getPlanejadoDia2() {
		return planejadoDia2;
	}

	public void setPlanejadoDia2(BigDecimal planejadoDia2) {
		this.planejadoDia2 = planejadoDia2;
	}

	public BigDecimal getPlanejadoDia3() {
		return planejadoDia3;
	}

	public void setPlanejadoDia3(BigDecimal planejadoDia3) {
		this.planejadoDia3 = planejadoDia3;
	}

	public BigDecimal getPlanejadoDia4() {
		return planejadoDia4;
	}

	public void setPlanejadoDia4(BigDecimal planejadoDia4) {
		this.planejadoDia4 = planejadoDia4;
	}

	public BigDecimal getPlanejadoDia5() {
		return planejadoDia5;
	}

	public void setPlanejadoDia5(BigDecimal planejadoDia5) {
		this.planejadoDia5 = planejadoDia5;
	}

	public BigDecimal getPlanejadoDia6() {
		return planejadoDia6;
	}

	public void setPlanejadoDia6(BigDecimal planejadoDia6) {
		this.planejadoDia6 = planejadoDia6;
	}

	public BigDecimal getPlanejadoDia7() {
		return planejadoDia7;
	}

	public void setPlanejadoDia7(BigDecimal planejadoDia7) {
		this.planejadoDia7 = planejadoDia7;
	}

	public BigDecimal getPlanejadoDia8() {
		return planejadoDia8;
	}

	public void setPlanejadoDia8(BigDecimal planejadoDia8) {
		this.planejadoDia8 = planejadoDia8;
	}

	public BigDecimal getPlanejadoDia9() {
		return planejadoDia9;
	}

	public void setPlanejadoDia9(BigDecimal planejadoDia9) {
		this.planejadoDia9 = planejadoDia9;
	}

	public BigDecimal getPlanejadoDia10() {
		return planejadoDia10;
	}

	public void setPlanejadoDia10(BigDecimal planejadoDia10) {
		this.planejadoDia10 = planejadoDia10;
	}

	public BigDecimal getPlanejadoDia11() {
		return planejadoDia11;
	}

	public void setPlanejadoDia11(BigDecimal planejadoDia11) {
		this.planejadoDia11 = planejadoDia11;
	}

	public BigDecimal getPlanejadoDia12() {
		return planejadoDia12;
	}

	public void setPlanejadoDia12(BigDecimal planejadoDia12) {
		this.planejadoDia12 = planejadoDia12;
	}

	public BigDecimal getPlanejadoDia13() {
		return planejadoDia13;
	}

	public void setPlanejadoDia13(BigDecimal planejadoDia13) {
		this.planejadoDia13 = planejadoDia13;
	}

	public BigDecimal getPlanejadoDia14() {
		return planejadoDia14;
	}

	public void setPlanejadoDia14(BigDecimal planejadoDia14) {
		this.planejadoDia14 = planejadoDia14;
	}

	public BigDecimal getPlanejadoDia15() {
		return planejadoDia15;
	}

	public void setPlanejadoDia15(BigDecimal planejadoDia15) {
		this.planejadoDia15 = planejadoDia15;
	}

	public BigDecimal getPlanejadoDia16() {
		return planejadoDia16;
	}

	public void setPlanejadoDia16(BigDecimal planejadoDia16) {
		this.planejadoDia16 = planejadoDia16;
	}

	public BigDecimal getPlanejadoDia17() {
		return planejadoDia17;
	}

	public void setPlanejadoDia17(BigDecimal planejadoDia17) {
		this.planejadoDia17 = planejadoDia17;
	}

	public BigDecimal getPlanejadoDia18() {
		return planejadoDia18;
	}

	public void setPlanejadoDia18(BigDecimal planejadoDia18) {
		this.planejadoDia18 = planejadoDia18;
	}

	public BigDecimal getPlanejadoDia19() {
		return planejadoDia19;
	}

	public void setPlanejadoDia19(BigDecimal planejadoDia19) {
		this.planejadoDia19 = planejadoDia19;
	}

	public BigDecimal getPlanejadoDia20() {
		return planejadoDia20;
	}

	public void setPlanejadoDia20(BigDecimal planejadoDia20) {
		this.planejadoDia20 = planejadoDia20;
	}

	public BigDecimal getPlanejadoDia21() {
		return planejadoDia21;
	}

	public void setPlanejadoDia21(BigDecimal planejadoDia21) {
		this.planejadoDia21 = planejadoDia21;
	}

	public BigDecimal getPlanejadoDia22() {
		return planejadoDia22;
	}

	public void setPlanejadoDia22(BigDecimal planejadoDia22) {
		this.planejadoDia22 = planejadoDia22;
	}

	public BigDecimal getPlanejadoDia23() {
		return planejadoDia23;
	}

	public void setPlanejadoDia23(BigDecimal planejadoDia23) {
		this.planejadoDia23 = planejadoDia23;
	}

	public BigDecimal getPlanejadoDia24() {
		return planejadoDia24;
	}

	public void setPlanejadoDia24(BigDecimal planejadoDia24) {
		this.planejadoDia24 = planejadoDia24;
	}

	public BigDecimal getPlanejadoDia25() {
		return planejadoDia25;
	}

	public void setPlanejadoDia25(BigDecimal planejadoDia25) {
		this.planejadoDia25 = planejadoDia25;
	}

	public BigDecimal getPlanejadoDia26() {
		return planejadoDia26;
	}

	public void setPlanejadoDia26(BigDecimal planejadoDia26) {
		this.planejadoDia26 = planejadoDia26;
	}

	public BigDecimal getPlanejadoDia27() {
		return planejadoDia27;
	}

	public void setPlanejadoDia27(BigDecimal planejadoDia27) {
		this.planejadoDia27 = planejadoDia27;
	}

	public BigDecimal getPlanejadoDia28() {
		return planejadoDia28;
	}

	public void setPlanejadoDia28(BigDecimal planejadoDia28) {
		this.planejadoDia28 = planejadoDia28;
	}

	public BigDecimal getPlanejadoDia29() {
		return planejadoDia29;
	}

	public void setPlanejadoDia29(BigDecimal planejadoDia29) {
		this.planejadoDia29 = planejadoDia29;
	}

	public BigDecimal getPlanejadoDia30() {
		return planejadoDia30;
	}

	public void setPlanejadoDia30(BigDecimal planejadoDia30) {
		this.planejadoDia30 = planejadoDia30;
	}

	public BigDecimal getPlanejadoDia0() {
		return planejadoDia0;
	}

	public void setPlanejadoDia0(BigDecimal planejadoDia0) {
		this.planejadoDia0 = planejadoDia0;
	}

	
	public BigDecimal getBoasDia1() {
		return boasDia1;
	}

	public void setBoasDia1(BigDecimal boasDia1) {
		this.boasDia1 = boasDia1;
	}

	public BigDecimal getBoasDia2() {
		return boasDia2;
	}

	public void setBoasDia2(BigDecimal boasDia2) {
		this.boasDia2 = boasDia2;
	}

	public BigDecimal getBoasDia3() {
		return boasDia3;
	}

	public void setBoasDia3(BigDecimal boasDia3) {
		this.boasDia3 = boasDia3;
	}

	public BigDecimal getBoasDia4() {
		return boasDia4;
	}

	public void setBoasDia4(BigDecimal boasDia4) {
		this.boasDia4 = boasDia4;
	}

	public BigDecimal getBoasDia5() {
		return boasDia5;
	}

	public void setBoasDia5(BigDecimal boasDia5) {
		this.boasDia5 = boasDia5;
	}

	public BigDecimal getBoasDia6() {
		return boasDia6;
	}

	public void setBoasDia6(BigDecimal boasDia6) {
		this.boasDia6 = boasDia6;
	}

	public BigDecimal getBoasDia7() {
		return boasDia7;
	}

	public void setBoasDia7(BigDecimal boasDia7) {
		this.boasDia7 = boasDia7;
	}

	public BigDecimal getBoasDia8() {
		return boasDia8;
	}

	public void setBoasDia8(BigDecimal boasDia8) {
		this.boasDia8 = boasDia8;
	}

	public BigDecimal getBoasDia9() {
		return boasDia9;
	}

	public void setBoasDia9(BigDecimal boasDia9) {
		this.boasDia9 = boasDia9;
	}

	public BigDecimal getBoasDia10() {
		return boasDia10;
	}

	public void setBoasDia10(BigDecimal boasDia10) {
		this.boasDia10 = boasDia10;
	}

	public BigDecimal getBoasDia11() {
		return boasDia11;
	}

	public void setBoasDia11(BigDecimal boasDia11) {
		this.boasDia11 = boasDia11;
	}

	public BigDecimal getBoasDia12() {
		return boasDia12;
	}

	public void setBoasDia12(BigDecimal boasDia12) {
		this.boasDia12 = boasDia12;
	}

	public BigDecimal getBoasDia13() {
		return boasDia13;
	}

	public void setBoasDia13(BigDecimal boasDia13) {
		this.boasDia13 = boasDia13;
	}

	public BigDecimal getBoasDia14() {
		return boasDia14;
	}

	public void setBoasDia14(BigDecimal boasDia14) {
		this.boasDia14 = boasDia14;
	}

	public BigDecimal getBoasDia15() {
		return boasDia15;
	}

	public void setBoasDia15(BigDecimal boasDia15) {
		this.boasDia15 = boasDia15;
	}

	public BigDecimal getBoasDia16() {
		return boasDia16;
	}

	public void setBoasDia16(BigDecimal boasDia16) {
		this.boasDia16 = boasDia16;
	}

	public BigDecimal getBoasDia17() {
		return boasDia17;
	}

	public void setBoasDia17(BigDecimal boasDia17) {
		this.boasDia17 = boasDia17;
	}

	public BigDecimal getBoasDia18() {
		return boasDia18;
	}

	public void setBoasDia18(BigDecimal boasDia18) {
		this.boasDia18 = boasDia18;
	}

	public BigDecimal getBoasDia19() {
		return boasDia19;
	}

	public void setBoasDia19(BigDecimal boasDia19) {
		this.boasDia19 = boasDia19;
	}

	public BigDecimal getBoasDia20() {
		return boasDia20;
	}

	public void setBoasDia20(BigDecimal boasDia20) {
		this.boasDia20 = boasDia20;
	}

	public BigDecimal getBoasDia21() {
		return boasDia21;
	}

	public void setBoasDia21(BigDecimal boasDia21) {
		this.boasDia21 = boasDia21;
	}

	public BigDecimal getBoasDia22() {
		return boasDia22;
	}

	public void setBoasDia22(BigDecimal boasDia22) {
		this.boasDia22 = boasDia22;
	}

	public BigDecimal getBoasDia23() {
		return boasDia23;
	}

	public void setBoasDia23(BigDecimal boasDia23) {
		this.boasDia23 = boasDia23;
	}

	public BigDecimal getBoasDia24() {
		return boasDia24;
	}

	public void setBoasDia24(BigDecimal boasDia24) {
		this.boasDia24 = boasDia24;
	}

	public BigDecimal getBoasDia25() {
		return boasDia25;
	}

	public void setBoasDia25(BigDecimal boasDia25) {
		this.boasDia25 = boasDia25;
	}

	public BigDecimal getBoasDia26() {
		return boasDia26;
	}

	public void setBoasDia26(BigDecimal boasDia26) {
		this.boasDia26 = boasDia26;
	}

	public BigDecimal getBoasDia27() {
		return boasDia27;
	}

	public void setBoasDia27(BigDecimal boasDia27) {
		this.boasDia27 = boasDia27;
	}

	public BigDecimal getBoasDia28() {
		return boasDia28;
	}

	public void setBoasDia28(BigDecimal boasDia28) {
		this.boasDia28 = boasDia28;
	}

	public BigDecimal getBoasDia29() {
		return boasDia29;
	}

	public void setBoasDia29(BigDecimal boasDia29) {
		this.boasDia29 = boasDia29;
	}

	public BigDecimal getBoasDia30() {
		return boasDia30;
	}

	public void setBoasDia30(BigDecimal boasDia30) {
		this.boasDia30 = boasDia30;
	}

	public BigDecimal getBoasDia0() {
		return boasDia0;
	}

	public void setBoasDia0(BigDecimal boasDia31) {
		this.boasDia0 = boasDia31;
	}

	public BigDecimal getProducaoDia0() {
		return producaoDia0;
	}

	public void setProducaoDia0(BigDecimal producaoDia0) {
		this.producaoDia0 = producaoDia0;
	}


	public BigDecimal getProducaoDia1() {
		return producaoDia1;
	}

	public void setProducaoDia1(BigDecimal producaoDia1) {
		this.producaoDia1 = producaoDia1;
	}

	public BigDecimal getProducaoDia2() {
		return producaoDia2;
	}

	public void setProducaoDia2(BigDecimal producaoDia2) {
		this.producaoDia2 = producaoDia2;
	}

	public BigDecimal getProducaoDia3() {
		return producaoDia3;
	}

	public void setProducaoDia3(BigDecimal producaoDia3) {
		this.producaoDia3 = producaoDia3;
	}

	public BigDecimal getProducaoDia4() {
		return producaoDia4;
	}

	public void setProducaoDia4(BigDecimal producaoDia4) {
		this.producaoDia4 = producaoDia4;
	}

	public BigDecimal getProducaoDia5() {
		return producaoDia5;
	}

	public void setProducaoDia5(BigDecimal producaoDia5) {
		this.producaoDia5 = producaoDia5;
	}

	public BigDecimal getProducaoDia6() {
		return producaoDia6;
	}

	public void setProducaoDia6(BigDecimal producaoDia6) {
		this.producaoDia6 = producaoDia6;
	}

	public BigDecimal getProducaoDia7() {
		return producaoDia7;
	}

	public void setProducaoDia7(BigDecimal producaoDia7) {
		this.producaoDia7 = producaoDia7;
	}

	public BigDecimal getProducaoDia8() {
		return producaoDia8;
	}

	public void setProducaoDia8(BigDecimal producaoDia8) {
		this.producaoDia8 = producaoDia8;
	}

	public BigDecimal getProducaoDia9() {
		return producaoDia9;
	}

	public void setProducaoDia9(BigDecimal producaoDia9) {
		this.producaoDia9 = producaoDia9;
	}

	public BigDecimal getProducaoDia10() {
		return producaoDia10;
	}

	public void setProducaoDia10(BigDecimal producaoDia10) {
		this.producaoDia10 = producaoDia10;
	}

	public BigDecimal getProducaoDia11() {
		return producaoDia11;
	}

	public void setProducaoDia11(BigDecimal producaoDia11) {
		this.producaoDia11 = producaoDia11;
	}

	public BigDecimal getProducaoDia12() {
		return producaoDia12;
	}

	public void setProducaoDia12(BigDecimal producaoDia12) {
		this.producaoDia12 = producaoDia12;
	}

	public BigDecimal getProducaoDia13() {
		return producaoDia13;
	}

	public void setProducaoDia13(BigDecimal producaoDia13) {
		this.producaoDia13 = producaoDia13;
	}

	public BigDecimal getProducaoDia14() {
		return producaoDia14;
	}

	public void setProducaoDia14(BigDecimal producaoDia14) {
		this.producaoDia14 = producaoDia14;
	}

	public BigDecimal getProducaoDia15() {
		return producaoDia15;
	}

	public void setProducaoDia15(BigDecimal producaoDia15) {
		this.producaoDia15 = producaoDia15;
	}

	public BigDecimal getProducaoDia16() {
		return producaoDia16;
	}

	public void setProducaoDia16(BigDecimal producaoDia16) {
		this.producaoDia16 = producaoDia16;
	}

	public BigDecimal getProducaoDia17() {
		return producaoDia17;
	}

	public void setProducaoDia17(BigDecimal producaoDia17) {
		this.producaoDia17 = producaoDia17;
	}

	public BigDecimal getProducaoDia18() {
		return producaoDia18;
	}

	public void setProducaoDia18(BigDecimal producaoDia18) {
		this.producaoDia18 = producaoDia18;
	}

	public BigDecimal getProducaoDia19() {
		return producaoDia19;
	}

	public void setProducaoDia19(BigDecimal producaoDia19) {
		this.producaoDia19 = producaoDia19;
	}

	public BigDecimal getProducaoDia20() {
		return producaoDia20;
	}

	public void setProducaoDia20(BigDecimal producaoDia20) {
		this.producaoDia20 = producaoDia20;
	}

	public BigDecimal getProducaoDia21() {
		return producaoDia21;
	}

	public void setProducaoDia21(BigDecimal producaoDia21) {
		this.producaoDia21 = producaoDia21;
	}

	public BigDecimal getProducaoDia22() {
		return producaoDia22;
	}

	public void setProducaoDia22(BigDecimal producaoDia22) {
		this.producaoDia22 = producaoDia22;
	}

	public BigDecimal getProducaoDia23() {
		return producaoDia23;
	}

	public void setProducaoDia23(BigDecimal producaoDia23) {
		this.producaoDia23 = producaoDia23;
	}

	public BigDecimal getProducaoDia24() {
		return producaoDia24;
	}

	public void setProducaoDia24(BigDecimal producaoDia24) {
		this.producaoDia24 = producaoDia24;
	}

	public BigDecimal getProducaoDia25() {
		return producaoDia25;
	}

	public void setProducaoDia25(BigDecimal producaoDia25) {
		this.producaoDia25 = producaoDia25;
	}

	public BigDecimal getProducaoDia26() {
		return producaoDia26;
	}

	public void setProducaoDia26(BigDecimal producaoDia26) {
		this.producaoDia26 = producaoDia26;
	}

	public BigDecimal getProducaoDia27() {
		return producaoDia27;
	}

	public void setProducaoDia27(BigDecimal producaoDia27) {
		this.producaoDia27 = producaoDia27;
	}

	public BigDecimal getProducaoDia28() {
		return producaoDia28;
	}

	public void setProducaoDia28(BigDecimal producaoDia28) {
		this.producaoDia28 = producaoDia28;
	}

	public BigDecimal getProducaoDia29() {
		return producaoDia29;
	}

	public void setProducaoDia29(BigDecimal producaoDia29) {
		this.producaoDia29 = producaoDia29;
	}

	public BigDecimal getProducaoDia30() {
		return producaoDia30;
	}

	public void setProducaoDia30(BigDecimal producaoDia30) {
		this.producaoDia30 = producaoDia30;
	}

	public List<BigDecimal> getListaRefugoDia() {
		return listaRefugoDia;
	}

	public void setListaRefugoDia(List<BigDecimal> listaRefugo) {
		this.listaRefugoDia = listaRefugo;
	}

	public BigDecimal getRefugoDia1() {
		return refugoDia1;
	}

	public void setRefugoDia1(BigDecimal refugoDia1) {
		this.refugoDia1 = refugoDia1;
	}

	public BigDecimal getRefugoDia2() {
		return refugoDia2;
	}

	public void setRefugoDia2(BigDecimal refugoDia2) {
		this.refugoDia2 = refugoDia2;
	}

	public BigDecimal getRefugoDia3() {
		return refugoDia3;
	}

	public void setRefugoDia3(BigDecimal refugoDia3) {
		this.refugoDia3 = refugoDia3;
	}

	public BigDecimal getRefugoDia4() {
		return refugoDia4;
	}

	public void setRefugoDia4(BigDecimal refugoDia4) {
		this.refugoDia4 = refugoDia4;
	}

	public BigDecimal getRefugoDia5() {
		return refugoDia5;
	}

	public void setRefugoDia5(BigDecimal refugoDia5) {
		this.refugoDia5 = refugoDia5;
	}

	public BigDecimal getRefugoDia6() {
		return refugoDia6;
	}

	public void setRefugoDia6(BigDecimal refugoDia6) {
		this.refugoDia6 = refugoDia6;
	}

	public BigDecimal getRefugoDia7() {
		return refugoDia7;
	}

	public void setRefugoDia7(BigDecimal refugoDia7) {
		this.refugoDia7 = refugoDia7;
	}

	public BigDecimal getRefugoDia8() {
		return refugoDia8;
	}

	public void setRefugoDia8(BigDecimal refugoDia8) {
		this.refugoDia8 = refugoDia8;
	}

	public BigDecimal getRefugoDia9() {
		return refugoDia9;
	}

	public void setRefugoDia9(BigDecimal refugoDia9) {
		this.refugoDia9 = refugoDia9;
	}

	public BigDecimal getRefugoDia10() {
		return refugoDia10;
	}

	public void setRefugoDia10(BigDecimal refugoDia10) {
		this.refugoDia10 = refugoDia10;
	}

	public BigDecimal getRefugoDia11() {
		return refugoDia11;
	}

	public void setRefugoDia11(BigDecimal refugoDia11) {
		this.refugoDia11 = refugoDia11;
	}

	public BigDecimal getRefugoDia12() {
		return refugoDia12;
	}

	public void setRefugoDia12(BigDecimal refugoDia12) {
		this.refugoDia12 = refugoDia12;
	}

	public BigDecimal getRefugoDia13() {
		return refugoDia13;
	}

	public void setRefugoDia13(BigDecimal refugoDia13) {
		this.refugoDia13 = refugoDia13;
	}

	public BigDecimal getRefugoDia14() {
		return refugoDia14;
	}

	public void setRefugoDia14(BigDecimal refugoDia14) {
		this.refugoDia14 = refugoDia14;
	}

	public BigDecimal getRefugoDia15() {
		return refugoDia15;
	}

	public void setRefugoDia15(BigDecimal refugoDia15) {
		this.refugoDia15 = refugoDia15;
	}

	public BigDecimal getRefugoDia16() {
		return refugoDia16;
	}

	public void setRefugoDia16(BigDecimal refugoDia16) {
		this.refugoDia16 = refugoDia16;
	}

	public BigDecimal getRefugoDia17() {
		return refugoDia17;
	}

	public void setRefugoDia17(BigDecimal refugoDia17) {
		this.refugoDia17 = refugoDia17;
	}

	public BigDecimal getRefugoDia18() {
		return refugoDia18;
	}

	public void setRefugoDia18(BigDecimal refugoDia18) {
		this.refugoDia18 = refugoDia18;
	}

	public BigDecimal getRefugoDia19() {
		return refugoDia19;
	}

	public void setRefugoDia19(BigDecimal refugoDia19) {
		this.refugoDia19 = refugoDia19;
	}

	public BigDecimal getRefugoDia20() {
		return refugoDia20;
	}

	public void setRefugoDia20(BigDecimal refugoDia20) {
		this.refugoDia20 = refugoDia20;
	}

	public BigDecimal getRefugoDia21() {
		return refugoDia21;
	}

	public void setRefugoDia21(BigDecimal refugoDia21) {
		this.refugoDia21 = refugoDia21;
	}

	public BigDecimal getRefugoDia22() {
		return refugoDia22;
	}

	public void setRefugoDia22(BigDecimal refugoDia22) {
		this.refugoDia22 = refugoDia22;
	}

	public BigDecimal getRefugoDia23() {
		return refugoDia23;
	}

	public void setRefugoDia23(BigDecimal refugoDia23) {
		this.refugoDia23 = refugoDia23;
	}

	public BigDecimal getRefugoDia24() {
		return refugoDia24;
	}

	public void setRefugoDia24(BigDecimal refugoDia24) {
		this.refugoDia24 = refugoDia24;
	}

	public BigDecimal getRefugoDia25() {
		return refugoDia25;
	}

	public void setRefugoDia25(BigDecimal refugoDia25) {
		this.refugoDia25 = refugoDia25;
	}

	public BigDecimal getRefugoDia26() {
		return refugoDia26;
	}

	public void setRefugoDia26(BigDecimal refugoDia26) {
		this.refugoDia26 = refugoDia26;
	}

	public BigDecimal getRefugoDia27() {
		return refugoDia27;
	}

	public void setRefugoDia27(BigDecimal refugoDia27) {
		this.refugoDia27 = refugoDia27;
	}

	public BigDecimal getRefugoDia28() {
		return refugoDia28;
	}

	public void setRefugoDia28(BigDecimal refugoDia28) {
		this.refugoDia28 = refugoDia28;
	}

	public BigDecimal getRefugoDia29() {
		return refugoDia29;
	}

	public void setRefugoDia29(BigDecimal refugoDia29) {
		this.refugoDia29 = refugoDia29;
	}

	public BigDecimal getRefugoDia30() {
		return refugoDia30;
	}

	public void setRefugoDia30(BigDecimal refugoDia30) {
		this.refugoDia30 = refugoDia30;
	}

	public BigDecimal getRefugoDia0() {
		return refugoDia0;
	}

	public void setRefugoDia0(BigDecimal refugoDia0) {
		this.refugoDia0 = refugoDia0;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}
	
	public String getStOp() {
		return stOp;
	}

	public void setStOp(String stOp) {
		this.stOp = stOp;
	}

	public List<RelatorioCargaMaquinaDTO> getItens() {
		return itens;
	}

	public void setItens(List<RelatorioCargaMaquinaDTO> itens) {
		this.itens = itens;
	}

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public String getMolde() {
		return molde;
	}

	public void setMolde(String molde) {
		this.molde = molde;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public BigDecimal getPlano() {
		return plano;
	}

	public void setPlano(BigDecimal plano) {
		this.plano = plano;
	}

	public BigDecimal getBoas() {
		return boas;
	}

	public void setBoas(BigDecimal boas) {
		this.boas = boas;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public BigDecimal getMetaHora() {
		return metaHora;
	}

	public void setMetaHora(BigDecimal metaHora) {
		this.metaHora = metaHora;
	}

	public BigDecimal getMetaDia() {
		return metaDia;
	}

	public void setMetaDia(BigDecimal metaDia) {
		this.metaDia = metaDia;
	}

	public List<BigDecimal> getListaPlanejadoDia() {
		return listaPlanejadoDia;
	}

	public void setListaPlanejadoDia(List<BigDecimal> listaPlanejadoDia) {
		this.listaPlanejadoDia = listaPlanejadoDia;
	}

	public List<BigDecimal> getListaProducaoDia() {
		return listaProducaoDia;
	}

	public void setListaProducaoDia(List<BigDecimal> listaProducaoDia) {
		this.listaProducaoDia = listaProducaoDia;
	}

	public List<BigDecimal> getListaBoasDia() {
		return listaBoasDia;
	}

	public void setListaBoasDia(List<BigDecimal> listaBoasDia) {
		this.listaBoasDia = listaBoasDia;
	}

	public Integer getCorQtd() {
		return corQtd;
	}

	public void setCorQtd(Integer corQtd) {
		this.corQtd = corQtd;
	}

	public Integer getCorDia0() {
		return corDia0;
	}

	public void setCorDia0(Integer corDia0) {
		this.corDia0 = corDia0;
	}

	public Integer getCorDia1() {
		return corDia1;
	}

	public void setCorDia1(Integer corDia1) {
		this.corDia1 = corDia1;
	}

	public Integer getCorDia2() {
		return corDia2;
	}

	public void setCorDia2(Integer corDia2) {
		this.corDia2 = corDia2;
	}

	public Integer getCorDia3() {
		return corDia3;
	}

	public void setCorDia3(Integer corDia3) {
		this.corDia3 = corDia3;
	}

	public Integer getCorDia4() {
		return corDia4;
	}

	public void setCorDia4(Integer corDia4) {
		this.corDia4 = corDia4;
	}

	public Integer getCorDia5() {
		return corDia5;
	}

	public void setCorDia5(Integer corDia5) {
		this.corDia5 = corDia5;
	}

	public Integer getCorDia6() {
		return corDia6;
	}

	public void setCorDia6(Integer corDia6) {
		this.corDia6 = corDia6;
	}

	public Integer getCorDia7() {
		return corDia7;
	}

	public void setCorDia7(Integer corDia7) {
		this.corDia7 = corDia7;
	}

	public Integer getCorDia8() {
		return corDia8;
	}

	public void setCorDia8(Integer corDia8) {
		this.corDia8 = corDia8;
	}

	public Integer getCorDia9() {
		return corDia9;
	}

	public void setCorDia9(Integer corDia9) {
		this.corDia9 = corDia9;
	}

	public Integer getCorDia10() {
		return corDia10;
	}

	public void setCorDia10(Integer corDia10) {
		this.corDia10 = corDia10;
	}

	public Integer getCorDia11() {
		return corDia11;
	}

	public void setCorDia11(Integer corDia11) {
		this.corDia11 = corDia11;
	}

	public Integer getCorDia12() {
		return corDia12;
	}

	public void setCorDia12(Integer corDia12) {
		this.corDia12 = corDia12;
	}

	public Integer getCorDia13() {
		return corDia13;
	}

	public void setCorDia13(Integer corDia13) {
		this.corDia13 = corDia13;
	}

	public Integer getCorDia14() {
		return corDia14;
	}

	public void setCorDia14(Integer corDia14) {
		this.corDia14 = corDia14;
	}

	public Integer getCorDia15() {
		return corDia15;
	}

	public void setCorDia15(Integer corDia15) {
		this.corDia15 = corDia15;
	}

	public Integer getCorDia16() {
		return corDia16;
	}

	public void setCorDia16(Integer corDia16) {
		this.corDia16 = corDia16;
	}

	public Integer getCorDia17() {
		return corDia17;
	}

	public void setCorDia17(Integer corDia17) {
		this.corDia17 = corDia17;
	}

	public Integer getCorDia18() {
		return corDia18;
	}

	public void setCorDia18(Integer corDia18) {
		this.corDia18 = corDia18;
	}

	public Integer getCorDia19() {
		return corDia19;
	}

	public void setCorDia19(Integer corDia19) {
		this.corDia19 = corDia19;
	}

	public Integer getCorDia20() {
		return corDia20;
	}

	public void setCorDia20(Integer corDia20) {
		this.corDia20 = corDia20;
	}

	public Integer getCorDia21() {
		return corDia21;
	}

	public void setCorDia21(Integer corDia21) {
		this.corDia21 = corDia21;
	}

	public Integer getCorDia22() {
		return corDia22;
	}

	public void setCorDia22(Integer corDia22) {
		this.corDia22 = corDia22;
	}

	public Integer getCorDia23() {
		return corDia23;
	}

	public void setCorDia23(Integer corDia23) {
		this.corDia23 = corDia23;
	}

	public Integer getCorDia24() {
		return corDia24;
	}

	public void setCorDia24(Integer corDia24) {
		this.corDia24 = corDia24;
	}

	public Integer getCorDia25() {
		return corDia25;
	}

	public void setCorDia25(Integer corDia25) {
		this.corDia25 = corDia25;
	}

	public Integer getCorDia26() {
		return corDia26;
	}

	public void setCorDia26(Integer corDia26) {
		this.corDia26 = corDia26;
	}

	public Integer getCorDia27() {
		return corDia27;
	}

	public void setCorDia27(Integer corDia27) {
		this.corDia27 = corDia27;
	}

	public Integer getCorDia28() {
		return corDia28;
	}

	public void setCorDia28(Integer corDia28) {
		this.corDia28 = corDia28;
	}

	public Integer getCorDia29() {
		return corDia29;
	}

	public void setCorDia29(Integer corDia29) {
		this.corDia29 = corDia29;
	}

	public Integer getCorDia30() {
		return corDia30;
	}

	public void setCorDia30(Integer corDia30) {
		this.corDia30 = corDia30;
	}

}
