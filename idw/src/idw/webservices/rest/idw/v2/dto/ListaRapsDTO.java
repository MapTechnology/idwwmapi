package idw.webservices.rest.idw.v2.dto;

import java.util.List;

public class ListaRapsDTO {
	private List<RapDTO> items;
	private MetaDTO meta;
	
	public List<RapDTO> getItems() {
		return items;
	}
	public void setItems(List<RapDTO> items) {
		this.items = items;
	}
	public MetaDTO getMeta() {
		return meta;
	}
	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	}
}
