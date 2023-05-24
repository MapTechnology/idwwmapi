package idw.webservices.rest.idw.v2.dto;

import java.util.List;

public class ListaRefugosDTO {
	private List<RefugoCadDTO> items;
	private MetaDTO meta;
	public List<RefugoCadDTO> getItems() {
		return items;
	}
	public void setItems(List<RefugoCadDTO> items) {
		this.items = items;
	}
	public MetaDTO getMeta() {
		return meta;
	}
	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	}
}
