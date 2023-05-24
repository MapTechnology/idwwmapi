package idw.webservices.rest.idw.v2.dto;

import java.util.List;

public class ListaJustificativasDTO {
	private List<JustificativaDTO> items;
	private MetaDTO meta;
	public List<JustificativaDTO> getItems() {
		return items;
	}
	public void setItems(List<JustificativaDTO> items) {
		this.items = items;
	}
	public MetaDTO getMeta() {
		return meta;
	}
	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	}
}
