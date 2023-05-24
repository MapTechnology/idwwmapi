package idw.webservices.rest.idw.v2.dto;

import java.util.List;

public class ListaPTsDTO {
	private List<PtDTO2> items;
	private MetaDTO meta;
	
	public List<PtDTO2> getItems() {
		return items;
	}
	public void setItems(List<PtDTO2> items) {
		this.items = items;
	}
	public MetaDTO getMeta() {
		return meta;
	}
	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	}
}
