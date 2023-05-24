package idw.webservices.rest.idw.v2.dto;

import java.util.List;

public class ListaMSsDTO {
	private List<MsDTO2> items;
	private MetaDTO meta;
	public List<MsDTO2> getItems() {
		return items;
	}
	public void setItems(List<MsDTO2> items) {
		this.items = items;
	}
	public MetaDTO getMeta() {
		return meta;
	}
	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	}
	
	
}
