package idw.webservices.rest.idw.v2.dto;

import java.util.List;

public class ListaCausasDTO {
	private List<CausaDTO> items;
	private MetaDTO meta;
	
	public List<CausaDTO> getItems() {
		return items;
	}
	public void setItems(List<CausaDTO> items) {
		this.items = items;
	}
	public MetaDTO getMeta() {
		return meta;
	}
	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	}
	
}
