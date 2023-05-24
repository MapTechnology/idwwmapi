package ms.model;

import java.math.BigDecimal;
import java.util.Date;

public interface IPojoMs {
	public Date getDthrRevisao();
	public void setDthrRevisao(Date dtRevisao);
	public Date getDthrStativo();
	public void setDthrStativo(Date dtStativo);
	public BigDecimal getRevisao();
	public void setRevisao(BigDecimal revisao);
	public BigDecimal getStAtivo();
	public void setStAtivo(BigDecimal stAtivo);
}
