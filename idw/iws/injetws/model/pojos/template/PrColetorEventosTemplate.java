package injetws.model.pojos.template;

import java.math.BigDecimal;
import java.util.Date;

import injetws.model.pojos.PrUp;


public abstract class PrColetorEventosTemplate {

	public abstract Integer getIdeventocoletor();
	public abstract PrUp getPrUp();
	public abstract BigDecimal getTpevento();
	public abstract String getIdeventomasterbridgecollectodb();
	public abstract Date getDthr1evento();
	public abstract double getMsdthr1evento();
	public abstract Date getDthr2evento();
	public abstract double getMsdthr2evento();
	public abstract String getNrop();
	public abstract String getCdmolde();
	public abstract String getCdestrutura();
	public abstract Date getDthriniplanejada();
	public abstract String getInf01();
	public abstract String getInf02();
	public abstract String getInf03();
	public abstract String getInf04();
	public abstract String getInf05();
	public abstract String getInf06();
	public abstract String getInf07();
	public abstract String getInf08();
	public abstract String getInf09();
	public abstract String getInf10();
	public abstract String getInf11();
	public abstract String getInf12();
	public abstract String getInf13();
	public abstract String getInf14();
	public abstract String getInf15();
	public abstract String getInf16();
	public abstract String getInf17();
	public abstract String getInf18();
	public abstract String getInf19();
	public abstract String getInf20();
	public abstract String getStevento();
	public abstract String getTxtMensagem();

	@Override
	public String toString() {
		return "PrColetorEventosTemplate [getIdeventocoletor()="
				+ getIdeventocoletor() + ", getPrUp()=" + getPrUp()
				+ ", getTpevento()=" + getTpevento()
				+ ", getIdeventomasterbridgecollectodb()="
				+ getIdeventomasterbridgecollectodb() + ", getDthr1evento()="
				+ getDthr1evento() + ", getMsdthr1evento()="
				+ getMsdthr1evento() + ", getDthr2evento()=" + getDthr2evento()
				+ ", getMsdthr2evento()=" + getMsdthr2evento() + ", getNrop()="
				+ getNrop() + ", getCdmolde()=" + getCdmolde()
				+ ", getCdestrutura()=" + getCdestrutura()
				+ ", getDthriniplanejada()=" + getDthriniplanejada()
				+ ", getInf01()=" + getInf01() + ", getInf02()=" + getInf02()
				+ ", getInf03()=" + getInf03() + ", getInf04()=" + getInf04()
				+ ", getInf05()=" + getInf05() + ", getInf06()=" + getInf06()
				+ ", getInf07()=" + getInf07() + ", getInf08()=" + getInf08()
				+ ", getInf09()=" + getInf09() + ", getInf10()=" + getInf10()
				+ ", getInf11()=" + getInf11() + ", getInf12()=" + getInf12()
				+ ", getInf13()=" + getInf13() + ", getInf14()=" + getInf14()
				+ ", getInf15()=" + getInf15() + ", getInf16()=" + getInf16()
				+ ", getInf17()=" + getInf17() + ", getInf18()=" + getInf18()
				+ ", getInf19()=" + getInf19() + ", getInf20()=" + getInf20()
				+ ", getStevento()=" + getStevento() + ", getTxtmensagem()="
				+ getTxtMensagem() + "]";
	}
}
