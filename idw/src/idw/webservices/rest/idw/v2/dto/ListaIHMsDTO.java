package idw.webservices.rest.idw.v2.dto;

import java.util.List;

public class ListaIHMsDTO {
	private List<IhmDTO2> items;
	private MetaDTO meta;
	
	public List<IhmDTO2> getItems() {
		return items;
	}
	public void setItems(List<IhmDTO2> items) {
		this.items = items;
	}
	public MetaDTO getMeta() {
		return meta;
	}
	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	}
}
