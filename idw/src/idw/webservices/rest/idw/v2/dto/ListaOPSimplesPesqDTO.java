package idw.webservices.rest.idw.v2.dto;

import java.util.List;

public class ListaOPSimplesPesqDTO {
	private List<OPSimplesPesqDTO> items;
	private MetaDTO meta;
	
	public List<OPSimplesPesqDTO> getItems() {
		return items;
	}
	public void setItems(List<OPSimplesPesqDTO> items) {
		this.items = items;
	}
	public MetaDTO getMeta() {
		return meta;
	}
	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	}
}
