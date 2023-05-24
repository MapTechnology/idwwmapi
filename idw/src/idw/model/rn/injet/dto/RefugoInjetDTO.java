package idw.model.rn.injet.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RefugoInjetDTO extends RefugoTempoInjetDTO implements Serializable{

	private String cdRefugo;
	private String dsRefugo;
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
	@Override
	public boolean equals(Object comparar){
		return (this.cdRefugo.equals(((RefugoInjetDTO)comparar).getCdRefugo()));
	}
}
