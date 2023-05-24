package ms.coleta.dto;

import java.util.Date;

public class SessaoRefugoDTO {
	private long idConsolrelog;
	private long idTMotivo;
	private String cdRefugo = "";
	private String dsRefugo = "";
	private String cdProduto = "";
	private int qtd;
	private String cb = "";
	private Date dthrRefugo;
	
	private long idTppt;
	
	public String getCdRefugo() {
		return cdRefugo;
	}
	public void setCdRefugo(String cdRefugo) {
		this.cdRefugo = cdRefugo;
	}
	public String getDsRefugo() {
		return dsRefugo;
	}
	public void setDsRefugo(String dsRefugo) {
		this.dsRefugo = dsRefugo;
	}
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public String getCb() {
		return cb;
	}
	public void setCb(String cb) {
		this.cb = cb;
	}
	public Date getDthrRefugo() {
		return dthrRefugo;
	}
	public void setDthrRefugo(Date dthrRefugo) {
		this.dthrRefugo = dthrRefugo;
	}
	public long getIdTppt() {
		return idTppt;
	}
	public void setIdTppt(long idTppt) {
		this.idTppt = idTppt;
	}
	public long getIdConsolrelog() {
		return idConsolrelog;
	}
	public void setIdConsolrelog(long idConsolrelog) {
		this.idConsolrelog = idConsolrelog;
	}
	public long getIdTMotivo() {
		return idTMotivo;
	}
	public void setIdTMotivo(long idTMotivo) {
		this.idTMotivo = idTMotivo;
	}
}
