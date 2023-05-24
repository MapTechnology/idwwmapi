package idw.webservices.rest.idw.v2.dto;

import java.util.List;

public class ListaGTsDTO {
	private List<GtDTO2> items;
	private MetaDTO meta;
	
	public List<GtDTO2> getItems() {
		return items;
	}
	public void setItems(List<GtDTO2> items) {
		this.items = items;
	}
	public MetaDTO getMeta() {
		return meta;
	}
	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	}
}
